/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
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

import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.performance.PerfTracker;
import tilda.utils.DurationUtil;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class Import
  {
    protected static final Logger LOG = LogManager.getLogger(Import.class.getName());

    public static void main(String[] args)
      {
        LOG.info("\n*************************************************************************************************************************************");
        ConnectionPool.autoInit();
        LOG.info("\n*************************************************************************************************************************************\n");

        Connection C = null;
        ArrayList<String> arguments = new ArrayList<>(Arrays.asList(args));
        
        if (arguments.size() < 4)
          {
            PrintUsageHint();
            System.exit(1);
          }

        try
          {
            long timeTaken = System.nanoTime();
            int RecordsCount = 0;
            
            for(int i=0; i < arguments.size() ; )
              {
                if("-f".equals(arguments.get(i)))
                  {
                    Importer I = getFileImporter(null, arguments.get(i+1));
                    String[] connectionIdsArr = arguments.get(i+3).split(",");
                    List<String> connectionIds = new ArrayList<>(Arrays.asList(connectionIdsArr));
                    Iterator<String> iterator = connectionIds.iterator();

                    if ( "ALL".equals(connectionIds.get(0)) )
                      {
                        iterator = ConnectionPool.getAllDataSourceIds().keySet().iterator();
                      }                      
                    else if ( "ALL_TENANTS".equals(connectionIds.get(0)) )
                      {
                        iterator = ConnectionPool.getAllTenantDataSourceIds().keySet().iterator(); 
                      }

                    // Loop connectionIds and run Import
                    while(iterator.hasNext())
                      {
                        C = ConnectionPool.get(iterator.next());
                        RecordsCount += Do(I, C);
                        C.commit();
                        C.close();
                        C = null;                        
                      }
                    i+=4;
                  }
                else { /* Do Nothing, at the moment */ }
              }
            
            timeTaken = System.nanoTime() - timeTaken;
            LOG.info("");
            LOG.info("");
            LOG.info("");
            LOG.info("Processed a total of " + RecordsCount + " records in " + DurationUtil.getDurationSeconds(timeTaken) + "s (" + DurationUtil.PrintPerformancePerMinute(timeTaken, RecordsCount) + " records/mn).");
            StringBuilder Str = new StringBuilder();
            Str.setLength(0);
            PerfTracker.print(Str);
            //LDH-NOTE: there is a bug in the Log4j code with a limit on buffer size if out to a file!
            LOG.info(TextUtil.toMaxLength(Str.toString(), 20000));
          }
        catch (Throwable T)
          {
            LOG.error("An exception occurred\n", T);
            try
              {
                C.rollback();
              }
            catch (SQLException X)
              { }
          }
        finally
        {
          if (C != null)
            try
              {
                C.close();
              }
            catch (SQLException E)
              { }
      }


        LOG.info("Import completed.");
      }
    
    private static void PrintUsageHint()
      {
        LOG.error("This utility must be called with at least 4 argument:");
        LOG.error("    1) -f ");
        LOG.error("    2) The path to an JSON import file named as _tilda.<Schema>.sampledata.<samplePackage>.json.");
        LOG.error("    3) -c ");
        LOG.error("    4) Comma Separated values of Connection Id. Ex: MAIN,PEPPER");
        LOG.error("The utility will then execute the class <Schema.package>+'.importers.'+<samplesPackage>.Root which must implement the ImportProcessor class.");
        LOG.error("*** for Multi Tenant System.");
        LOG.error("    ALL           = All Connection Ids. Except 'KEYS'");
        LOG.error("    ALL_TENANTS   = All Connection Ids. Except 'MAIN' & 'KEYS'");
      }
    
    protected static int Do(Importer I, Connection C)
      throws Exception
      {
        LOG.info("");
        LOG.info("");
        LOG.info("");
        LOG.info("=======================================================================================================================");
        LOG.info("== Importing into DB ( Url: "+C.getURL()+" )");
        LOG.info("=======================================================================================================================");
        long T = System.nanoTime();
        int Total = I.process(C);
        T = System.nanoTime() - T;
        
        LOG.info("Processed " + Total + " records in " + DurationUtil.getDurationSeconds(T) + "s (" + DurationUtil.PrintPerformancePerMinute(T, Total) + " records/mn).");
        return Total;
      }
    
    protected static Importer getFileImporter(String OverridePackageName, String ImportFileName)
    throws Exception
      {
        LOG.info("");
        LOG.info("");
        LOG.info("");
        LOG.info("=======================================================================================================================");
        LOG.info("== Reading Import file: "+ImportFileName);
        LOG.info("=======================================================================================================================");
        Reader R = FileUtil.getReaderFromFileOrResource(ImportFileName);

        Pattern P = Pattern.compile("\\.*\\_tilda\\.([^\\.]+)\\.sampledata\\.([^\\.]+)\\.json\\z");
        Matcher M = P.matcher(ImportFileName);
        if (M.find() == false)
          throw new Exception("The argument '" + ImportFileName + "' is invalid: it should match the format '_tilda.'+<SchemaName>+'.sampledata.'+<samplesPackage>+'.json'.");
        String SchemaName = M.group(1);
        String SamplePackageName = OverridePackageName == null ? M.group(2) : OverridePackageName;

        String SchemaPackage = ConnectionPool.getSchemaPackage(SchemaName);
        if (SchemaPackage == null)
          throw new Exception("The Schema '" + SchemaName + "' cannot be found as defined in the Tilda configuration file.");

        String RootClassName = SchemaPackage + ".importers." + SamplePackageName + ".RootImporter";
        Class<?> RootClass = null;
        try
          {
            RootClass = Class.forName(RootClassName);
          }
        catch (ClassNotFoundException E)
          {
            throw new Exception("The root importer class as inferred from the input file '" + ImportFileName + "' cannot be found in the classpath.");
          }

        // long T = System.nanoTime();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Importer I = (Importer) gson.fromJson(R, RootClass);
        // TODO OPTIONAL: Print Time taken to read File
        R.close();
        return I;        
      }
  }



//Connection C = null;
//try
//{
  //int RecordsCount = 0;
  //long timeTaken = System.nanoTime();
  //int FileCount = 0;
  
  //if (ConnectionPool.getUniqueDataSourceIds().size() > 1) // Multi Tenant System
    //{
      //C = ConnectionPool.get(arguments.get(arguments.size() - 1));
      //arguments.remove(arguments.size() - 1);
    //}
  //else // Single Tenant System
    //{
      // C = ConnectionPool.get("MAIN");
    //}
  //
  //if (arguments.get(0).equalsIgnoreCase("-packageName") == true)
    //{
      //++FileCount;
      //RecordsCount += Do(arguments.get(1), arguments.get(2), C);
      //C.commit();
    //}
  //else for (String a : arguments)
    //{
      //RecordsCount += Do(null, a, C);
      //++FileCount;
      //C.commit();
    //}
  //timeTaken = System.nanoTime() - timeTaken;
  //LOG.info("\n\n\n");
  //LOG.info("===> "+ C.getURL());
  //LOG.info("Processed a total of " + RecordsCount + " records from "+FileCount+" files in " + DurationUtil.getDurationSeconds(timeTaken) + "s (" + DurationUtil.PrintPerformancePerMinute(timeTaken, RecordsCount) + " records/mn).");
  //StringBuilder Str = new StringBuilder();
  //Str.setLength(0);
  //PerfTracker.print(Str);
  ////LDH-NOTE: there is a bug in the Log4j code with a limit on buffer size if out to a file!
  ////LOG.info(Str.toString());
  //LOG.info(TextUtil.toMaxLength(Str.toString(), 20000));
//}
//catch (Throwable T)
//{
//  LOG.error("An exception occurred\n", T);
//  try
//    {
//      C.rollback();
//    }
//  catch (SQLException x)
//    {
//    }
//}
//finally
//{
//  if (C != null)
//    try
//      {
//        C.close();
//      }
//    catch (SQLException E)
//      {
//      }
//}


