/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tilda;

import java.io.BufferedReader;
import java.io.StringReader;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.LegacySQLTypeName;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.Table;
import com.google.cloud.bigquery.TableDataWriteChannel;
import com.google.cloud.bigquery.TableDefinition.Type;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.config.ConnDefs;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.TableMeta;
import tilda.db.metadata.TableViewMeta;
import tilda.db.metadata.ViewMeta;
import tilda.db.processors.ExporterRecordProcessorCSVJSON;
import tilda.utils.DateTimeUtil;
import tilda.utils.DurationUtil;
import tilda.utils.TextUtil;
import tilda.utils.gcp.BQHelper;
import tilda.utils.gcp.BQWriter;
import tilda.utils.gcp.JobHelper;
import tilda.utils.gcp.JobResults;

public class Export
  {
    protected static final Logger LOG = LogManager.getLogger(Export.class.getName());

    /*
     * public static long export(Connection C, String mode, String src, String dst, int logFrequency)
     * throws Exception
     * {
     * // String[] parts = fullName.split("\\.");
     * // if (parts.length == 2)
     * return exportGeneric(C, mode, src, dst, logFrequency);
     * // else
     * // return exportTilda(C, mode, fullName, path, logFrequency, maxCount);
     * }
     */

    static private class PathParser
      {
        /**
         * Expecting a path in the form of bq`<project>.<dataset>.<table/view>`
         * 
         * @param path
         * @throws Exception
         */
        public PathParser(String path)
          throws Exception
          {
            _type = path.startsWith("bq`") == true ? "BQ" : path.startsWith("pg`") == true ? "PG" : null;
            if (_type == null || path.endsWith("`") == false)
              throw new Exception("The path '" + path + "' is invalid. Must be bq`<project>.<dataset>.<table/view>` or pg`<schema>.<table/view>`");

            String[] parts = path.substring(3, path.length() - 1).split("\\.");
            if (_type.equals("BQ") == true)
              {
                if (parts.length != 3)
                  throw new Exception("BQ paths must be of the form bq`<project>.<dataset>.<table/view>. The path '" + path + "' only has " + parts.length + " parts instead of 3 required.");
                _project = parts[0];
                _schema = parts[1];
                _tableView = parts[2];
                return;
              }
            // PG
            if (parts.length != 2)
              throw new Exception("PG paths must be of the form pg`<dataset>.<table/view>. The path '" + path + "' only has " + parts.length + " parts instead of 2 required.");
            _project = null;
            _schema = parts[0];
            _tableView = parts[1];
          }

        protected final String  _type;
        protected final String  _project;
        protected final String  _schema;
        protected final String  _tableView;

        protected int           _tableViewType;
        protected String[]      _columns;
        protected Schema        _BQSchema;
        protected TableViewMeta _PGSchema;

        public Exception getColumns(Connection C, BigQuery bq)
        throws Exception
          {
            if (_type.equals("PG") == true)
              {
                // Get the table meta-data
                TableViewMeta TVM = new TableMeta(_schema, _tableView, "Table");
                TVM.load(C);
                if (TVM.getColumnMetaList().isEmpty() == true)
                  {
                    TVM = new ViewMeta(_schema, _tableView, "View");
                    TVM.load(C);
                    if (TVM.getColumnMetaList().isEmpty() == true)
                      return new Exception("Cannot find PG table/view '" + _schema + "." + _tableView + "'.");
                    _tableViewType = 2;
                  }
                else
                  _tableViewType = 1;
                List<ColumnMeta> L = TVM.getColumnMetaList();
                _columns = new String[L.size()];
                for (int i = 0; i < L.size(); ++i)
                  _columns[i] = L.get(i)._NameOriginal;
                _PGSchema = TVM;
                return null;
              }
            else if (_type.equals("BQ") == true)
              {
                Table T = bq.getTable(_schema, _tableView);
                if (T == null)
                  return new Exception("Cannot find BQ table/view '" + _project + "." + _schema + "." + _tableView + "'.");

                _tableViewType = T.getDefinition().getType() == Type.VIEW ? 2 : T.getDefinition().getType() == Type.TABLE ? 1 : 0;
                if (_tableViewType == 0)
                  throw new Exception("Cannot BQ entity '" + _project + "." + _schema + "." + _tableView + "' is neither a View nor a Table. It is a " + T.getDefinition().getType() + ".");

                _BQSchema = T.getDefinition().getSchema();
                FieldList L = _BQSchema.getFields();
                _columns = new String[L.size()];
                for (int i = 0; i < L.size(); ++i)
                  _columns[i] = L.get(i).getName();
                return null;
              }

            throw new Exception("DataSource type is neither PG nor BQ: " + _type);
          }
      }

    public static long exportGeneric(Connection C, String mode, String src, String dst, int logFrequency)
    throws Exception
      {
        PathParser srcPath = new PathParser(src);
        PathParser dstPath = new PathParser(dst);

        if (srcPath._type.equals("PG") == true && dstPath._type.equals("BQ") == true)
          {
            BigQuery bq = BQHelper.getBigQuery(dstPath._project);
            LOG.debug("Source PG for " + srcPath._schema + "." + srcPath._tableView + ".");
            Exception E = srcPath.getColumns(C, bq);
            if (E != null)
              throw E;
            LOG.debug("Destination BQ table: " + dstPath._project + "." + dstPath._schema + "." + dstPath._tableView + ".");
            E = dstPath.getColumns(C, bq);
            if (E != null) // destination schema/table doesn't exist in BQ, so let's create it on the fly.
              dstPath._BQSchema = BQHelper.getBQSchemaFromMeta(srcPath._PGSchema);

            LOG.debug("Columns: " + TextUtil.print(srcPath._columns));
            if (dstPath._tableViewType == 2)
              throw new Exception("The destination '" + dst + "' is a view. Cannot write to a view.");

            TableDataWriteChannel Out = BQHelper.getTableWriterChannel(bq, dstPath._schema, dstPath._tableView, mode, dstPath._BQSchema, false);
            BQWriter writer = new BQWriter(Out);
            ExporterRecordProcessorCSVJSON RP = new ExporterRecordProcessorCSVJSON(C, writer, dst, logFrequency, srcPath._PGSchema, mode, mode.equalsIgnoreCase("csv"));
            C.executeMetaFullSelect(srcPath._PGSchema, RP);
            writer.close();
            List<String> errMessages = new ArrayList<String>();
            if (RP.getTotalCount() == 0)
              errMessages.add("There was no data found from the source.");
            if (JobHelper.completeJob(Out.getJob(), errMessages) == null)
              throw new Exception("Copying data to BQ failed.\n" + TextUtil.print(errMessages.iterator(), "\n"));
            return RP.getTotalCount();
          }
        else if (srcPath._type.equals("BQ") == true && dstPath._type.equals("PG") == true)
          {
            BigQuery bq = BQHelper.getBigQuery(srcPath._project);
            LOG.debug("Source BQ table: " + srcPath._project + "." + srcPath._schema + "." + srcPath._tableView + ".");
            Exception E = srcPath.getColumns(C, bq);
            if (E != null)
              throw E;
            LOG.debug("Destination PG for " + dstPath._schema + "." + dstPath._tableView + ".");
            E = dstPath.getColumns(C, bq);
            if (E != null) // destination schema/table doesn't exist in PG
              {
                
              }
            LOG.debug("Columns: " + TextUtil.print(srcPath._columns));
            if (dstPath._tableViewType == 2)
              throw new Exception("The destination '" + dst + "' is a view. Cannot write to a view.");

            StringBuilder str = new StringBuilder("`");
            TextUtil.print(srcPath._columns, "`, `", str);
            String srcQuery = "SELECT " + str.toString() + "` FROM `" + srcPath._project + "." + srcPath._schema + "." + srcPath._tableView + "`;";

            str.setLength(0);
            TextUtil.print(srcPath._columns, "\", \"", str);
            String dstQuery = "COPY " + dstPath._schema + "." + dstPath._tableView + "(\"" + str.toString() + "\") FROM STDIN CSV DELIMITER ','";
            CopyManager copyManager = new CopyManager(C.unwrap(BaseConnection.class));
            JobResults jr = BQHelper.runQuery(bq, srcQuery);
            StringBuilder csvRowOut = new StringBuilder();
            int i = 0;
            int currentBatchSize = 10_000;
            Iterator<FieldValueList> I = jr._r.iterateAll().iterator();
            while (true)
              {

                FieldValueList row = null;
                if (I.hasNext() == true)
                  {
                    row = I.next();
                    toCSV(csvRowOut, row, srcPath._BQSchema);
                    csvRowOut.append("\n");
                    ++i;
                  }
                if (i % currentBatchSize == 0 || row == null)
                  {
                    copyManager.copyIn(dstQuery, new BufferedReader(new StringReader(csvRowOut.toString())));
                    if (row == null)
                      break;
                    csvRowOut.setLength(0);
                  }
              }
            return i;
          }

        throw new Exception("The source/destination configuration is not supported: only between BQ and PG.");
        // else
        // {
        // String outputFileName = mode.equalsIgnoreCase("csv") == true ? path + "\\" + tableViewName + ".csv"
        // : path + "\\" + tableViewName + (mode.equalsIgnoreCase("jsonl") ? ".jsonl" : ".json");
        // FileWriter writer = new FileWriter(outputFileName);
        // ExporterRecordProcessorCSVJSON RP = new ExporterRecordProcessorCSVJSON(C, writer, path, logFrequency, TVM, mode, mode.equalsIgnoreCase("csv"));
        // C.executeMetaFullSelect(TVM, RP);
        // writer.close();
        // return RP.getTotalCount();
        // }
      }

    private static void toCSV(StringBuilder csvRowOut, FieldValueList row, Schema s)
    throws Exception
      {
        FieldList FL = s.getFields();
        for (int i = 0; i < row.size(); ++i)
          {
            FieldValue v = row.get(i);
            Field f = FL.get(i);
            if (i != 0)
              csvRowOut.append(",");
            if (v.isNull() == true)
              continue;
            if (v.getAttribute() == Attribute.PRIMITIVE)
              TextUtil.escapeDoubleQuoteForCSV(csvRowOut, printFieldValue(v, f));
            else if (v.getAttribute() == Attribute.REPEATED)
              {
                List<FieldValue> L = v.getRepeatedValue();
                csvRowOut.append("\"{");
                boolean first = true;
                for (FieldValue v2 : L)
                  {
                    if (v.getAttribute() == Attribute.RECORD)
                      throw new Exception("Cannot handle BQ repeated values of repeated values... Column " + i + ".");
                    if (first == false)
                      csvRowOut.append(",");
                    csvRowOut.append(TextUtil.escapeDoubleQuoteForCSV(printFieldValue(v, f)).replaceAll("\"", "\\\""));
                  }
                csvRowOut.append("}\"");
              }
            else if (v.getAttribute() == Attribute.RECORD)
              TextUtil.escapeDoubleQuoteForCSV(csvRowOut, v.getStringValue());
            else
              throw new Exception("Column attribute type '" + v.getAttribute().name() + "' not supported. Column " + i + ".");
          }
      }


    private static String printFieldValue(FieldValue v, Field f)
    throws Exception
      {
        if (f.getType() == LegacySQLTypeName.BIGNUMERIC
        || f.getType() == LegacySQLTypeName.BOOLEAN
        || f.getType() == LegacySQLTypeName.DATE
        || f.getType() == LegacySQLTypeName.DATETIME
        || f.getType() == LegacySQLTypeName.FLOAT
        || f.getType() == LegacySQLTypeName.INTEGER
        || f.getType() == LegacySQLTypeName.JSON
        || f.getType() == LegacySQLTypeName.NUMERIC
        || f.getType() == LegacySQLTypeName.RECORD
        || f.getType() == LegacySQLTypeName.STRING)
          {
            return v.getStringValue();
          }
        else if (f.getType() == LegacySQLTypeName.TIMESTAMP)
          {
            ZonedDateTime ZDT = v.getTimestampInstant().atZone(ZoneId.of("UTC"));
            return DateTimeUtil.printDateTimeForJSON(ZDT);
          }
        throw new Exception("Cannot handle BQ type '" + f.getType().name() + "'");
      }

    public static void main(String[] args)
    throws Exception
      {
        LOG.info("----------------------------------------------------------------------------------------------------------------------------");
        LOG.info("This utility exports a table between PG and BQ.");
        LOG.info("  - Export <connection_id> <mode> <data_source> <data_destination>");
        LOG.info("  - It takes 4 parameter:");
        LOG.info("      . the connection Id");
        LOG.info("      . the export mode (CSV|JSON|JSONL)");
        LOG.info("      . the data source as a BQ destination as 'bq`<project>.<dataset>{.<tablename>}`' or a PG destination as 'pg`<schema>.<tablename>`'.");
        LOG.info("      . the data destination as a file path, a BQ destination as 'bq`<project>.<dataset>{.<tablename>}`', or a PG destination as 'pg`<schema>.<tablename>`'");
        LOG.info("  - For example");
        LOG.info("      . Export MAIN 2 CSV \"C:\\mypath\\data_export\\\" pg`USER.Role`");
        LOG.info("      . Export MAIN 2 JSONL bq`myproject.mydataset` pg`User.Role`");
        LOG.info("NOTE: Test before assuming that more threads will make this faster!");
        LOG.info("NOTE: If specifying a BQ destination, the project name is used and will be expected as part of the name of the appropriate keys file, i.e., .");
        LOG.info("----------------------------------------------------------------------------------------------------------------------------");
        LOG.info("");
        LOG.info("");

        if (args.length != 4)
          throw new Exception("This utility needs 5 parameters.");

        String connectionId = args[0];
        String mode = args[1];
        if (mode.equalsIgnoreCase("csv") == false && mode.equalsIgnoreCase("json") == false && mode.equalsIgnoreCase("jsonl") == false)
          throw new Exception("This utility was called with mode='" + mode + "' which is not supported. Only CSV, JSON or JSONL are supported.");

        final int logFrequency = 100_000;
        // int max_count = args.length <= 5 ? SystemValues.EVIL_VALUE : ParseUtil.parseInteger(args[5], SystemValues.EVIL_VALUE);

        String src = args[2];
        String dst = args[3];

        LOG.debug("connection_id: " + connectionId + "; mode: " + mode + "; src: " + src + "; dst: " + dst + ";");

        // if (args.length == 6 && max_count != SystemValues.EVIL_VALUE)
        // { // if there are 6 parameters, and the 6th parameter is a number, we are in the max_count scenario
        // // and threads better be equal to 1.
        // if (threads != 1)
        // throw new Exception("If specifying a single output with a max_count value, threads must be equal to 1.");
        // }
        // else if (path.startsWith("bq`") == true && path.split("\\.").length == 3 && args.length > 5)
        // throw new Exception("This utility was called with path='" + path + "' which contains a target table name in BQ: only one <tilda_class_name source> can be provided in
        // that case whereas " + (args.length - 4) + " were found.");

        // if (threads == 1)
        // {
        long TS = System.nanoTime();
        ConnDefs._SKIP_TILDA_LOADING = true; // Skip loading Tilda infrastructure since we are 100% JDBC-based DB meta-data only.
        Connection C = ConnectionPool.get(connectionId);
        // C.setReadOnly(true);
        long totalCount = 0;
        // if there are 6 parameters, and the 6th parameter is a number, we are in the max_count scenario
        // if (args.length == 6 && max_count != SystemValues.EVIL_VALUE)
        // {
        totalCount += exportGeneric(C, mode, src, dst, logFrequency);
        C.commit();
        // }
        // else
        // for (int i = 4; i < args.length; ++i)
        // {
        // totalCount += export(C, mode, args[i], path, logFrequency, -1);
        // C.rollback();
        // }
        C.close();
        C = null;
        long durationNano = System.nanoTime() - TS;
        LOG.info("Saved a total of " + totalCount + " records to " + mode.toUpperCase() + " from " + (args.length - 4) + " tables/views"
        + " in " + DurationUtil.printDuration(durationNano) + " (" + DurationUtil.printPerformancePerMinute(durationNano, totalCount) + " records/min)");
        // }
        // else
        // {
        // Executor E = new Executor(threads);
        // for (int i = 4; i < args.length; ++i)
        // {
        // E.addRunnable(new Exporter(connectionId, mode, args[i], path, logFrequency));
        // }
        // E.run();
        // }
        LOG.info("The utility completed.");
      }

  }
