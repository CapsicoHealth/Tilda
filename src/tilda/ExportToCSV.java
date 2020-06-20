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

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.processors.CSVExporterObjectProcessor;
import tilda.db.processors.ObjectProcessor;
import tilda.interfaces.CSVable;
import tilda.utils.DurationUtil;
import tilda.utils.ParseUtil;
import tilda.utils.concurrent.Executor;
import tilda.utils.concurrent.SimpleRunnable;

public class ExportToCSV
  {
    protected static final Logger LOG = LogManager.getLogger(ExportToCSV.class.getName());

    public static long CSVExport(Connection C, String fullName, String path, int logFrequency)
    throws Exception
      {
        int lastDot = fullName.lastIndexOf(".");
        if (lastDot == -1)
          throw new Exception("Incorrect Tilda object name '" + fullName + "'.");

        CSVExporterObjectProcessor<CSVable> OP = new CSVExporterObjectProcessor<CSVable>(path + "\\" + fullName.substring(lastDot + 1) + ".csv", logFrequency);
        Class<?> Factory = Class.forName(fullName + "_Factory");
        Method M = Factory.getMethod("lookupWhereAll", Connection.class, ObjectProcessor.class, int.class, int.class);
        M.invoke(null, C, OP, 0, -1);
        return OP.getTotalCount();
      }

    protected static class CSVExporter extends SimpleRunnable
      {
        public CSVExporter(String name, String path, int logFrequency)
          {
            super(name);
            _path = path;
            _logFrequency = logFrequency;
          }

        String _path;
        int    _logFrequency;

        @Override
        public void doRun()
        throws Exception
          {
            Connection C = ConnectionPool.get("MAIN");
            setCount(CSVExport(C, getName(), _path, _logFrequency));
            C.rollback();
            C.close();
          }
      }

    public static void main(String[] args)
    throws Exception
      {
        LOG.info("This utility exports one or more tables to CSV.");
        LOG.info("  - It takes 3+ parameter: the number of threads, the path where the CSV files should be saved, and one or more full class names of a Tilda object (without _Data or _Factory).");
        LOG.info("  - ExportToCSV <threads> <export_path> <tilda_class_name>+");
        LOG.info("  - ExportToCSV 2 \"C:\\mypath\\data_export\\\" com.myCo.myProj.data.User com.myCo.myProj.data.Role");
        LOG.info("Test before assuming that more threads will make this faster!");

        if (args.length < 3)
          throw new Exception("This utility needs at least 3 parameters passed.");

        int threads = ParseUtil.parseInteger(args[0], 1);
        String path = args[1];
        final int logFrequency = 100_000;

        if (threads == 1)
          {
            long TS = System.nanoTime();
            Connection C = ConnectionPool.get("MAIN");
            long totalCount = 0;
            for (int i = 2; i < args.length; ++i)
              {
                totalCount += CSVExport(C, args[i], path, logFrequency);
                C.rollback();
              }
            C.close();
            C = null;
            long durationNano = System.nanoTime() - TS;
            LOG.info("Saved a total of " + totalCount + " records to CSV from " + (args.length - 1) + " tables/views"
            + " in " + DurationUtil.printDuration(durationNano) + " (" + DurationUtil.printPerformancePerMinute(durationNano, totalCount) + " records/min)");
          }
        else
          {
            Executor E = new Executor(threads);
            for (int i = 2; i < args.length; ++i)
              E.addRunnable(new CSVExporter(args[i], path, logFrequency));
            E.run();
          }
        LOG.info("The utility completed.");
      }

  }
