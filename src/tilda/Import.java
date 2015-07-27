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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.performance.PerfTracker;
import tilda.utils.DurationUtil;
import tilda.utils.FileUtil;
import tilda.utils.SystemValues;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Import
  {
    protected static final Logger LOG = LogManager.getLogger(Import.class.getName());

    public static void main(String[] args)
      {
        LOG.info("\n*************************************************************************************************************************************");
        SystemValues.autoInit();
        ConnectionPool.autoInit();
        LOG.info("\n*************************************************************************************************************************************\n");

        if (args.length == 0)
          {
            LOG.error("This utility must be called with at least 1 argument: the path to an JSON import file named as _tilda.<Schema>.sampledata.<samplePackage>.json.");
            LOG.error("The utility will then execute the class <Schema.package>+'.importers.'+<samplesPackage>.Root which must implement the ImportProcessor class.");
            System.exit(1);
          }

        Connection C = null;
        try
          {
            int Total = 0;
            long T0 = System.nanoTime();
            C = ConnectionPool.get("MAIN");
            for (String a : args)
              {
                Total += Do(a, C);
                C.commit();
              }
            T0 = System.nanoTime() - T0;
            LOG.info("All in all, processed a total of " + Total + " records in " + DurationUtil.getDurationSeconds(T0) + "s (" + DurationUtil.PrintPerformancePerMinute(T0, Total) + " records/mn).");
            StringBuilder Str = new StringBuilder();
            PerfTracker.print(Str);
            LOG.info(Str);
          }
        catch (Throwable T)
          {
            LOG.error("An exception occurred\n", T);
            try
              {
                C.rollback();
              }
            catch (SQLException x)
              {
              }
          }
        finally
          {
            if (C != null)
              try
                {
                  C.close();
                }
              catch (SQLException E)
                {
                }
          }
      }
    
    protected static int Do(String ImportFileName, Connection C)
      throws Exception
      {
        Reader R = null;
        if (new File(ImportFileName).exists() == false)
         {
           InputStream In = FileUtil.getResourceAsStream(ImportFileName);
           if (In == null)
             {
               throw new Exception("Cannot find import file/resource '" + ImportFileName + "'.");
             }
           R = new BufferedReader(new InputStreamReader(In));
         }
        else
         R = new BufferedReader(new FileReader(ImportFileName));

        Pattern P = Pattern.compile("\\.*\\_tilda\\.([^\\.]+)\\.sampledata\\.([^\\.]+)\\.json\\z");
        Matcher M = P.matcher(ImportFileName);
        if (M.find() == false)
          throw new Exception("The argument '" + ImportFileName + "' is invalid: it should match the format '_tilda.'+<SchemaName>+'.sampledata.'+<samplesPackage>+'.json'.");
        String SchemaName = M.group(1);
        String SamplePackageName = M.group(2);

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

        long T = System.nanoTime();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Importer I = (Importer) gson.fromJson(R, RootClass);
        R.close();
        int Total = I.process(C);
        T = System.nanoTime() - T;

        LOG.info("Processed " + Total + " records in " + DurationUtil.getDurationSeconds(T) + "s (" + DurationUtil.PrintPerformancePerMinute(T, Total) + " records/mn).");
        return Total;
      }
  }
