/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

package tilda.loader.csv;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.loader.csv.ImporterThread;
import tilda.loader.csv.CSVImporter.Results;
import tilda.loader.parser.Config;
import tilda.loader.parser.DataObject;

import tilda.db.Connection;
import tilda.utils.DurationUtil;

public class ImportProcessor
  {
    protected static final Logger LOG = LogManager.getLogger(ImportProcessor.class.getName());

    public static void process(Connection C, Config Conf, List<DataObject> CMSDataList)
      {
        try
          {
            List<Results> Results = new ArrayList<Results>();
            for (DataObject Data : CMSDataList)
              {
                validate(Data);
                List<Results> Res = CSVImporter.process(C, Conf, Data);
                if (Res == null)
                  break;
                Results.addAll(Res);
              }

            long totalCount = 0;
            long totalNano = 0;
            for (Results R : Results)
              {
                totalCount += R._RecordsCount;
                totalNano += R._TimeNano;
                LOG.debug("Processed file " + R._FileName + " into table " + R._TableName + " in " + DurationUtil.PrintDurationSeconds(R._TimeNano) +
                " (" + DurationUtil.PrintPerformancePerMinute(R._TimeNano, R._RecordsCount) + " Records/min)");
              }
            LOG.debug("--------------------------------------------------------------------------------------------------------------");
            LOG.debug("In total, processed " + totalCount + " in " + DurationUtil.PrintDuration(totalNano) + " (" + DurationUtil.PrintPerformancePerMinute(totalNano, totalCount) + " Records/min)");

          }
        catch (Exception E)
          {
            LOG.error("Error: ", E);
          }
        finally
          {
            try
              {
                if (C != null)
                  C.close();
              }
            catch (SQLException e)
              {
                LOG.error("Error in the application: ", e);
              }
          }
      }

    /*
     * Launch and Shutdown threads
     */
    public static void parallelProcess(List<String> connectionIds, String rootFolder, List<DataObject> CMSDataList)
      {
          ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
          List<Future<List<Results>>> futures = new ArrayList<>();
          
          List<Results> Results = new ArrayList<Results>();
          for (DataObject Data : CMSDataList)
            {
              validate(Data);
              for(String connectionId : connectionIds)
                {
                  Callable<List<Results>> thread = new ImporterThread(connectionId, rootFolder, Data);
                  Future<List<Results>> future =  pool.submit(thread);
                  futures.add(future);
                }
            }
          
          Iterator<Future<List<Results>>> iterator = futures.iterator(); 
          while(iterator.hasNext())
            {
              Future<List<Results>> future = iterator.next();
              List<Results> Res;
              try
                {
                  Res = future.get();
                }
              catch (InterruptedException | ExecutionException e)
                {
                  LOG.error("Exception in one of the ImporterThread's..", e);
                  Res = null;
                }
              if (Res == null)
                break;
              Results.addAll(Res);
            }

          long totalCount = 0;
          long totalNano = 0;
          for (Results R : Results)
            {
              totalCount += R._RecordsCount;
              totalNano += R._TimeNano;
              LOG.debug("Processed file " + R._FileName + " into table " + R._TableName + " in " + DurationUtil.PrintDurationSeconds(R._TimeNano) +
              " (" + DurationUtil.PrintPerformancePerMinute(R._TimeNano, R._RecordsCount) + " Records/min)");
            }
          LOG.debug("--------------------------------------------------------------------------------------------------------------");
          LOG.debug("In total, processed " + totalCount + " in " + DurationUtil.PrintDuration(totalNano) + " (" + DurationUtil.PrintPerformancePerMinute(totalNano, totalCount) + " Records/min)");
      }
    
    
    public static boolean truncateTable(Connection C, String SchemaName, String TableName)
      {

        try
          {
            C.truncateTable(SchemaName, TableName);
//            C.setTableLogging(SchemaName, TableName, false);
            C.commit();
          }
        catch (Exception e)
          {
            LOG.error("Error in the truncating tables: ", e);
            return false;
          }
        return true;
      }

    private static void validate(DataObject data)
      {
        // TODO Auto-generated method stub

      }
  }
