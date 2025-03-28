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
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.performance.PerfTracker;
import tilda.utils.DurationUtil;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;
import tilda.utils.json.gson_serializers.GSONSerializerInitializer;

public class Import
  {
    protected static final Logger LOG = LogManager.getLogger(Import.class.getName());

    public static void main(String[] args)
      {
        List<ParamSet> params = validateParams(args);
        Connection C = null;

        LOG.info("\n*************************************************************************************************************************************");
        printUsageHint();
        LOG.info("\n*************************************************************************************************************************************");
        ConnectionPool.autoInit();
        LOG.info("\n*************************************************************************************************************************************\n");

        String currentFile = null;
        try
          {
            long timeTaken = System.nanoTime();
            int RecordsCount = 0;

            for (ParamSet ps : params)
              {
                Importer I = getFileImporter(ps._fileName, ps._schema, ps._importer);
                Iterator<String> iterator = ConnectionPool.getConnectionListFromParam(ps._connection);
                // Loop connectionIds and run Import
                while (iterator.hasNext())
                  {
                    C = ConnectionPool.get(iterator.next());
                    RecordsCount += process(I, C);
                    C.commit();
                    C.close();
                    C = null;
                  }
              }

            timeTaken = System.nanoTime() - timeTaken;
            LOG.info("");
            LOG.info("");
            LOG.info("");
            LOG.info("Processed a total of " + RecordsCount + " records in " + DurationUtil.getDurationSeconds(timeTaken) + "s (" + DurationUtil.printPerformancePerMinute(timeTaken, RecordsCount) + " records/mn).");
            StringBuilder Str = new StringBuilder();
            Str.setLength(0);
            PerfTracker.print(Str);
            // LDH-NOTE: there is a bug in the Log4j code with a limit on buffer size if out to a file!
            LOG.info(TextUtil.toMaxLength(Str.toString(), 50000));
          }
        catch (Throwable T)
          {
            LOG.error("An exception occurred importing file " + currentFile + "\n", T);
            System.exit(-1);
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


        LOG.info("Import completed.");
      }

    private static class ParamSet
      {
        protected static Pattern _P = Pattern.compile("\\.*\\_tilda\\.([^\\.]+)\\.([a-zA-Z][_\\-a-zA-Z0-9]*)\\.([^\\.]+)\\.json\\z");

        public String            _fileName;
        public String            _schema;
        public String            _importer;
        public String            _connection;

        public int getNextParamSet(String[] args, int i)
          {
            if (i + 4 > args.length)
              {
                LOG.error("Not finding at least 4 parameters at position '" + i + "', either -f <file_name> -c <connection> or -f <file_name> -s <schema>.<importer> -c <connection>.");
                printUsageHint();
                System.exit(-1);
              }
            if (args[i].equals("-f") == false)
              {
                LOG.error("Expecting flag -f at position '" + i + "'.");
                printUsageHint();
                System.exit(-1);
              }
            _fileName = args[i + 1];

            i += 2;

            if (args[i].equals("-s") == true)
              {
                if (i + 4 > args.length)
                  {
                    LOG.error("Not finding at least 4 parameters at position '" + i + "', for -s <schema>.<importer> -c <connection>.");
                    printUsageHint();
                    System.exit(-1);
                  }
                String[] parts = args[i + 1].split("\\.");
                if (parts.length != 2)
                  {
                    LOG.error("The attribute -s '" + args[i + 1] + "' doesn't follow the format '<schema>.<importer>' as " + parts.length + " parts were found instead of 2");
                    printUsageHint();
                    System.exit(-1);
                  }
                _schema = parts[0];
                _importer = parts[1];
                i += 2;
              }
            else
              {
                Matcher M = _P.matcher(_fileName);
                if (M.find() == false)
                  {
                    LOG.error("The argument '" + _fileName + "' is invalid: it should match the format '_tilda.<schema>.<identifier>.<importer>.json'.");
                    printUsageHint();
                    System.exit(-1);
                  }
                _schema = M.group(1);
                _importer = M.group(3);
              }

            if (args[i].equals("-c") == false)
              {
                LOG.error("Expecting flag -c at position " + i + ".");
                printUsageHint();
                System.exit(-1);
              }

            _connection = args[i + 1];
            return i + 2;
          }
      }

    private static List<ParamSet> validateParams(String[] args)
      {
        List<ParamSet> params = new ArrayList<ParamSet>();
        int i = 0;
        while (i < args.length)
          {
            ParamSet ps = new ParamSet();
            i = ps.getNextParamSet(args, i);
            params.add(ps);
          }
        return params;
      }

    private static void printUsageHint()
      {
        LOG.error("");
        LOG.error("Import utility must be called with parameter(s) in following format:");
        LOG.error("   -f <file_name> {-s <schema>.<importer_package> } -c (ALL | ALL_TENANTS | <connection_id>) ");
        LOG.error("");
        LOG.error("<file_name> must either follow the pattern '_tilda.<schema>.<identifier>.<importer_package>.json'");
        LOG.error("where <schema> is the name of the schema for the data being loaded, <identifier> is any filename-compatible");
        LOG.error("name, and <importer_package> is the name of the importer package. This helps the utility automatically load");
        LOG.error("the class <schema>.importers.<importer_package>.RootImporter.");
        LOG.error("");
        LOG.error("If the filename is instead an arbitrary filename, the additional parameter -s must be supplied to specify");
        LOG.error("<schema> and <importer_package> information");
        LOG.error("");
        LOG.error("Ex: -f tilda/data/_tilda.Tilda.sampledata.zones.json -c MAIN,KEYS");
        LOG.error("    -f tilda/data/some-extra-zones.json -s Tilda.zones -c MAIN,KEYS");
        LOG.error("");
        LOG.error("Note that the self-documented filename format is prefered since the name itself contains all the needed");
        LOG.error("to automtically load the data properly.");
        LOG.error("");
        LOG.error("*** for Multi Tenant System.");
        LOG.error("    ALL           = All Connection Ids. Except 'KEYS'");
        LOG.error("    ALL_TENANTS   = All Connection Ids. Except 'MAIN' & 'KEYS'");
        LOG.error("");
      }

    public static int process(Importer I, Connection C)
    throws Exception
      {
        LOG.info("");
        LOG.info("");
        LOG.info("");
        LOG.info("=======================================================================================================================");
        LOG.info("== Importing into DB ( Url: " + C.getURL() + " )");
        LOG.info("=======================================================================================================================");
        long T = System.nanoTime();
        int Total = I.process(C);
        T = System.nanoTime() - T;

        LOG.info("Processed " + Total + " records in " + DurationUtil.getDurationSeconds(T) + "s (" + DurationUtil.printPerformancePerMinute(T, Total) + " records/mn).");
        return Total;
      }

    public static Importer getFileImporter(String fileName, String schema, String importer)
    throws Exception
      {
        LOG.info("");
        LOG.info("");
        LOG.info("");
        LOG.info("=======================================================================================================================");
        LOG.info("== Reading Import file: " + fileName);
        LOG.info("=======================================================================================================================");
        Reader R = FileUtil.getReaderFromFileOrResource(fileName);

        // This method can be called internally to auto load files, so in case, we need to re-decipher the parts.
        if (schema == null || importer == null)
          {
            Matcher M = ParamSet._P.matcher(fileName);
            if (M.find() == false)
              throw new Exception("The argument '" + fileName + "' is invalid: it should match the format '_tilda.<schema>.<identifier>.<importer>.json'.");
            schema = M.group(1);
            importer = M.group(3);
          }

        String SchemaPackage = ConnectionPool.getSchemaPackage(schema);
        if (SchemaPackage == null)
          throw new Exception("The Schema '" + schema + "' cannot be found as defined in the Tilda configuration file.");

        String RootClassName = SchemaPackage + ".importers." + importer + ".RootImporter";
        Class<?> RootClass = null;
        try
          {
            RootClass = Class.forName(RootClassName);
          }
        catch (ClassNotFoundException E)
          {
            throw new Exception("The root importer class '" + RootClassName + "' to process file '" + fileName + "' cannot be found in the classpath.");
          }

        // long T = System.nanoTime();
        Gson gson = GSONSerializerInitializer.newBuilder().setPrettyPrinting().create();
        Importer I = (Importer) gson.fromJson(R, RootClass);
        // TODO OPTIONAL: Print Time taken to read File
        R.close();
        return I;
      }
  }
