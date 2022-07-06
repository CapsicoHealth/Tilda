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

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.TableDataWriteChannel;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.processors.ExporterCSVObjectProcessor;
import tilda.db.processors.ExporterJSONObjectProcessor;
import tilda.db.processors.ExporterObjectProcessor;
import tilda.db.processors.ObjectProcessor;
import tilda.utils.DurationUtil;
import tilda.utils.ParseUtil;
import tilda.utils.concurrent.Executor;
import tilda.utils.concurrent.SimpleRunnable;
import tilda.utils.gcp.BQHelper;
import tilda.utils.gcp.BQWriter;
import tilda.utils.gcp.JobHelper;

public class Export
  {
    protected static final Logger LOG = LogManager.getLogger(Export.class.getName());

    public static long export(Connection C, String mode, String fullName, String path, int logFrequency)
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
            Schema schema = BQHelper.getTildaBQSchema(schemaName, tableName, "");
            LOG.debug("Source schema for "+schemaName+"."+tableName+":\n "+BQHelper.getSchemaColumns(schema)+"\n");
            String bqSchemaName = parts[1];
            String bqTableName = parts.length == 3 ? parts[2] : tableName;
            LOG.debug("Destination table: "+parts[0]+"."+bqSchemaName+"."+bqTableName+".");
            Out = BQHelper.getTableWriterChannel(bq, bqSchemaName, bqTableName, mode, schema, false);
            BQWriter writer = new BQWriter(Out);
            OP = mode.equalsIgnoreCase("csv") == true
            ? new ExporterCSVObjectProcessor(writer, path, logFrequency, factoryClass, false)
            : new ExporterJSONObjectProcessor(writer, path, logFrequency, mode.equalsIgnoreCase("jsonl"));
          }
        else
          {
            OP = mode.equalsIgnoreCase("csv") == true
            ? new ExporterCSVObjectProcessor(path + "\\" + tableName + ".csv", logFrequency, factoryClass, true)
            : new ExporterJSONObjectProcessor(path + "\\" + tableName + (mode.equalsIgnoreCase("jsonl") ? ".jsonl" : ".json"), logFrequency, mode.equalsIgnoreCase("jsonl"));
          }

        Method M = factoryClass.getMethod("lookupWhereAll", Connection.class, ObjectProcessor.class, int.class, int.class);
        M.invoke(null, C, OP, 0, -1);

        if (Out != null)
          {
            Out.close();
            if (JobHelper.completeJob(Out.getJob()) == null)
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
            setCount(export(C, _mode, getName(), _path, _logFrequency));
            C.rollback();
            C.close();
          }
      }

    public static void main(String[] args)
    throws Exception
      {
        LOG.info("----------------------------------------------------------------------------------------------------------------------------");
        LOG.info("This utility exports one or more tables to CSV/JSON/JSONL or directly to BigQuery.");
        LOG.info("  - Export <connection_id> <threads> <mode> <export_path> <tilda_class_name>+");
        LOG.info("  - It takes 5+ parameter:");
        LOG.info("      . the connection Id");
        LOG.info("      . the number of threads");
        LOG.info("      . the export mode (CSV|JSON|JSONL)");
        LOG.info("      . the path(s) where the file(s) should be saved or a BQ destination as 'bq`<project>.<dataset>{.<tablename>}`'");
        LOG.info("      . one or more full class names of a Tilda object (without _Data or _Factory).");
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

//        LOG.debug("path: "+path+"; path.startsWith(\"bq`\"): "+path.startsWith("bq`")+"; path.split(\"\\\\.\").length: "+path.split("\\.").length+": args.length: "+args.length+";");
        if (path.startsWith("bq`")==true && path.split("\\.").length == 3 && args.length > 5)
          throw new Exception("This utility was called with path='" + path + "' which contains a target table name in BQ: only one <tilda_class_name source> can be provided in that case whereas "+(args.length-4)+" were found.");

        LOG.debug("connection_id: "+connectionId+"; threads: "+threads+"; mode: "+mode+"; export_path: "+path+";");

        if (threads == 1)
          {
            long TS = System.nanoTime();
            Connection C = ConnectionPool.get(connectionId);
            C.setReadOnly(true);
            long totalCount = 0;
            for (int i = 4; i < args.length; ++i)
              {
                totalCount += export(C, mode, args[i], path, logFrequency);
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
