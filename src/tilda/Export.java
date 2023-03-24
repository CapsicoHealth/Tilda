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

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.TableDataWriteChannel;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.metadata.TableMeta;
import tilda.db.metadata.TableViewMeta;
import tilda.db.metadata.ViewMeta;
import tilda.db.processors.ExporterObjectProcessor;
import tilda.db.processors.ExporterObjectProcessorCSV;
import tilda.db.processors.ExporterObjectProcessorJSON;
import tilda.db.processors.ExporterRecordProcessorCSVJSON;
import tilda.db.processors.ObjectProcessor;
import tilda.utils.DurationUtil;
import tilda.utils.ParseUtil;
import tilda.utils.SystemValues;
import tilda.utils.concurrent.Executor;
import tilda.utils.concurrent.SimpleRunnable;
import tilda.utils.gcp.BQHelper;
import tilda.utils.gcp.BQWriter;
import tilda.utils.gcp.JobHelper;

public class Export
  {
    protected static final Logger LOG = LogManager.getLogger(Export.class.getName());

    public static long export(Connection C, String mode, String fullName, String path, int logFrequency, int maxCount)
    throws Exception
      {
        String[] parts = fullName.split("\\.");
        if (parts.length == 2)
          return exportGeneric(C, mode, parts[0], parts[1], path, logFrequency, maxCount);
        else
          return exportTilda(C, mode, fullName, path, logFrequency, maxCount);
      }

    public static long exportGeneric(Connection C, String mode, String schemaName, String tableViewName, String path, int logFrequency, int maxCount)
    throws Exception
      {
        // Get the table meta-data
        TableViewMeta TVM = new TableMeta(schemaName, tableViewName, "Table/View");
        TVM.load(C);
        if (TVM.getColumnMetaList().isEmpty() == true)
          {
            TVM = new ViewMeta(schemaName, tableViewName, "Table/View");
            TVM.load(C);
            if (TVM.getColumnMetaList().isEmpty() == true)
              throw new Exception("Cannot find table/view '"+tableViewName+"'.");
          }
        
        if (path.startsWith("bq`") == true)
          {
            if (path.endsWith("`") == false)
              throw new Exception("The <export_path> parameter '" + path + "' must be of the form 'bq`project.dataset{.tablename}`'.");
            String[] parts = path.substring("bq`".length(), path.length() - 1).split("\\.");
            if (parts.length != 2 && parts.length != 3)
              throw new Exception("The bq path '" + path + "' must be of the form 'bq`project.dataset`'.");
            BigQuery bq = BQHelper.getBigQuery(parts[0]);
            String bqSchemaName = parts[1];
            String bqTableName = parts.length == 3 ? parts[2] : tableViewName;
            LOG.debug("Destination table: " + parts[0] + "." + bqSchemaName + "." + bqTableName + ".");
            Schema schema = BQHelper.getBQSchemaFromMeta(TVM);
            LOG.debug("Source schema for " + schemaName + "." + tableViewName + ":\n " + BQHelper.getSchemaColumns(schema) + "\n");
            TableDataWriteChannel Out = BQHelper.getTableWriterChannel(bq, bqSchemaName, bqTableName, mode, schema, false);
            BQWriter writer = new BQWriter(Out);
            ExporterRecordProcessorCSVJSON RP = new ExporterRecordProcessorCSVJSON(C, writer, path, logFrequency, TVM, mode, mode.equalsIgnoreCase("csv"));
            C.executeMetaFullSelect(TVM, RP);
            writer.close();
            List<String> errMessages = new ArrayList<String>();
            if (JobHelper.completeJob(Out.getJob(), errMessages) == null)
              throw new Exception("Copying data to BQ failed.");
            return RP.getTotalCount();
          }
        else
          {
            String outputFileName = mode.equalsIgnoreCase("csv") == true ? path + "\\" + tableViewName + ".csv"
                                                                         : path + "\\" + tableViewName + (mode.equalsIgnoreCase("jsonl") ? ".jsonl" : ".json")
                                                                         ;
            FileWriter writer = new FileWriter(outputFileName);
            ExporterRecordProcessorCSVJSON RP = new ExporterRecordProcessorCSVJSON(C, writer, path, logFrequency, TVM, mode, true);
            C.executeMetaFullSelect(TVM, RP);
            writer.close();
            return RP.getTotalCount();
          }
      }

    public static long exportTilda(Connection C, String mode, String fullName, String path, int logFrequency, int maxCount)
    throws Exception
      {
        int lastDot = fullName.lastIndexOf(".");
        if (lastDot == -1)
          throw new Exception("Incorrect Tilda object name '" + fullName + "'.");

        String tableName = fullName.substring(lastDot + 1);

        Class<?> factoryClass = Class.forName(fullName + "_Factory");
        ExporterObjectProcessor<?> OP = null;
        TableDataWriteChannel Out = null;

        if (path.startsWith("bq`") == true)
          {
            if (path.endsWith("`") == false)
              throw new Exception("The <export_path> parameter '" + path + "' must be of the form 'bq`project.dataset{.tablename}`'.");
            String[] parts = path.substring("bq`".length(), path.length() - 1).split("\\.");
            if (parts.length != 2 && parts.length != 3)
              throw new Exception("The bq path '" + path + "' must be of the form 'bq`project.dataset`'.");
            BigQuery bq = BQHelper.getBigQuery(parts[0]);
            String schemaName = (String) factoryClass.getSuperclass().getDeclaredField("SCHEMA_LABEL").get(null);
            Schema schema = BQHelper.getBQSchemaFromTilda(schemaName, tableName, "");
            boolean fromDB = false;
            if (schema == null)
              {
                fromDB = true;
                schema = BQHelper.getBQSchemaFromDB(C, schemaName, tableName);
              }
            LOG.debug("Source schema for " + schemaName + "." + tableName + ":\n " + BQHelper.getSchemaColumns(schema) + "\n");
            String bqSchemaName = parts[1];
            String bqTableName = parts.length == 3 ? parts[2] : tableName;
            LOG.debug("Destination table: " + parts[0] + "." + bqSchemaName + "." + bqTableName + ".");
            Out = BQHelper.getTableWriterChannel(bq, bqSchemaName, bqTableName, mode, schema, false);
            BQWriter writer = new BQWriter(Out);
            if (fromDB == false)
              {
                OP = mode.equalsIgnoreCase("csv") == true
                ? new ExporterObjectProcessorCSV(writer, path, logFrequency, factoryClass, false)
                : new ExporterObjectProcessorJSON(writer, path, logFrequency, mode.equalsIgnoreCase("jsonl"));
              }
            else
              {
                // OP = new ExporterRecordProcessorCSVJSON(C, writer, path, logFrequency, tvm, mode, true)
                // C.executeMetaFullSelect(schemaName, tableName, OP);
              }
          }
        else
          {
            OP = mode.equalsIgnoreCase("csv") == true
            ? new ExporterObjectProcessorCSV(path + "\\" + tableName + ".csv", logFrequency, factoryClass, true)
            : new ExporterObjectProcessorJSON(path + "\\" + tableName + (mode.equalsIgnoreCase("jsonl") ? ".jsonl" : ".json"), logFrequency, mode.equalsIgnoreCase("jsonl"));
          }

        Method M = factoryClass.getMethod("lookupWhereAll", Connection.class, ObjectProcessor.class, int.class, int.class);
        M.invoke(null, C, OP, 0, maxCount);

        if (Out != null)
          {
            Out.close();
            List<String> errMessages = new ArrayList<String>();
            if (JobHelper.completeJob(Out.getJob(), errMessages) == null)
              return 0;
          }
        return OP.getTotalCount();
      }

    protected static class Exporter extends SimpleRunnable
      {
        public Exporter(String connectionId, String mode, String name, String path, int logFrequency)
          {
            super(name);
            _connectionId = connectionId;
            _mode = mode;
            _path = path;
            _logFrequency = logFrequency;
          }

        String _connectionId;
        String _mode;
        String _path;
        int    _logFrequency;

        @Override
        public void doRun()
        throws Exception
          {
            Connection C = ConnectionPool.get(_connectionId);
            setCount(export(C, _mode, getName(), _path, _logFrequency, -1));
            C.rollback();
            C.close();
          }
      }

    public static void main(String[] args)
    throws Exception
      {
        LOG.info("----------------------------------------------------------------------------------------------------------------------------");
        LOG.info("This utility exports one or more tables to CSV/JSON/JSONL or directly to BigQuery.");
        LOG.info("  - Export <connection_id> <threads> <mode> <export_path> <tilda_class_name> ( <max_count> | <tilda_class_name>+ )");
        LOG.info("  - It takes 5+ parameter:");
        LOG.info("      . the connection Id");
        LOG.info("      . the number of threads");
        LOG.info("      . the export mode (CSV|JSON|JSONL)");
        LOG.info("      . the path(s) where the file(s) should be saved or a BQ destination as 'bq`<project>.<dataset>{.<tablename>}`'");
        LOG.info("      . one or more full class names of a Tilda object (without _Data or _Factory).");
        LOG.info("      . if only one class name is provided, the ability to specify a max count to limit the number of rows exported.");
        LOG.info("  - For example");
        LOG.info("      . ExportToCSV MAIN 2 CSV \"C:\\mypath\\data_export\\\" com.myCo.myProj.data.User com.myCo.myProj.data.Role");
        LOG.info("      . ExportToCSV MAIN 2 JSONL bq`myproject.mydataset` com.myCo.myProj.data.User com.myCo.myProj.data.Role");
        LOG.info("NOTE: Test before assuming that more threads will make this faster!");
        LOG.info("NOTE: If specifying a BQ destination with a table name, only one tilda_class_name is expected.");
        LOG.info("----------------------------------------------------------------------------------------------------------------------------");
        LOG.info("");
        LOG.info("");

        if (args.length < 5)
          throw new Exception("This utility needs at least 5 parameters passed.");

        String connectionId = args[0];
        int threads = ParseUtil.parseInteger(args[1], 1);
        String mode = args[2];
        if (mode.equalsIgnoreCase("csv") == false && mode.equalsIgnoreCase("json") == false && mode.equalsIgnoreCase("jsonl") == false)
          throw new Exception("This utility was called with mode='" + mode + "' which is not supported. Only CSV, JSON or JSONL are supported.");

        String path = args[3];
        final int logFrequency = 10_000;
        int max_count = args.length <= 5 ? SystemValues.EVIL_VALUE : ParseUtil.parseInteger(args[5], SystemValues.EVIL_VALUE);

        LOG.debug("connection_id: " + connectionId + "; threads: " + threads + "; mode: " + mode + "; export_path: " + path + ";");

        if (args.length == 6 && max_count != SystemValues.EVIL_VALUE)
          { // if there are 6 parameters, and the 6th parameter is a number, we are in the max_count scenario
            // and threads better be equal to 1.
            if (threads != 1)
              throw new Exception("If specifying a single output with a max_count value, threads must be equal to 1.");
          }
        else if (path.startsWith("bq`") == true && path.split("\\.").length == 3 && args.length > 5)
          throw new Exception("This utility was called with path='" + path + "' which contains a target table name in BQ: only one <tilda_class_name source> can be provided in that case whereas " + (args.length - 4) + " were found.");

        if (threads == 1)
          {
            long TS = System.nanoTime();
            Connection C = ConnectionPool.get(connectionId);
            C.setReadOnly(true);
            long totalCount = 0;
            // if there are 6 parameters, and the 6th parameter is a number, we are in the max_count scenario
            if (args.length == 6 && max_count != SystemValues.EVIL_VALUE)
              {
                totalCount += export(C, mode, args[4], path, logFrequency, max_count);
                C.rollback();
              }
            else
              for (int i = 4; i < args.length; ++i)
                {
                  totalCount += export(C, mode, args[i], path, logFrequency, -1);
                  C.rollback();
                }
            C.close();
            C = null;
            long durationNano = System.nanoTime() - TS;
            LOG.info("Saved a total of " + totalCount + " records to " + mode.toUpperCase() + " from " + (args.length - 4) + " tables/views"
            + " in " + DurationUtil.printDuration(durationNano) + " (" + DurationUtil.printPerformancePerMinute(durationNano, totalCount) + " records/min)");
          }
        else
          {
            Executor E = new Executor(threads);
            for (int i = 4; i < args.length; ++i)
              {
                E.addRunnable(new Exporter(connectionId, mode, args[i], path, logFrequency));
              }
            E.run();
          }
        LOG.info("The utility completed.");
      }

  }
