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
        
        ValidateParams(arguments);

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
                  }
                else { throw new Exception("Cannot find a -f parameter starting the command line"); }
                i+=4;
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
    
    private static void ValidateParams(ArrayList<String> arguments)
      {
        if (arguments.size() % 4 != 0)
          {
            PrintUsageHint();
            System.exit(-1);
          }
        
        for (int i = 0 ; i < arguments.size() ; )
          {
            if ( !"-f".equals(arguments.get(i)) || arguments.get(i+1) == null 
                || !"-c".equals(arguments.get(i+2)) || arguments.get(i+3) == null )
              {
                PrintUsageHint();
                System.exit(-1);
              }
            i += 4;
          }
      }

    private static void PrintUsageHint()
      {
        LOG.error("");
        LOG.error("Import utility must be called with parameter(s) in following format:");
        LOG.error("-f <file_name> -c ( ALL | ALL_TENANTS | <connection_id>) ");
        LOG.error("Ex: -f tilda/data/_tilda.Tilda.sampledata.zones.json -c MAIN,KEYS");
        LOG.error("*** for Multi Tenant System.");
        LOG.error("    ALL           = All Connection Ids. Except 'KEYS'");
        LOG.error("    ALL_TENANTS   = All Connection Ids. Except 'MAIN' & 'KEYS'");
        LOG.error("");
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
