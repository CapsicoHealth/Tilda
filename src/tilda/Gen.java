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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.generation.Generator;
import tilda.generation.GeneratorSession;
import tilda.generation.Manifest;
import tilda.generation.html.DocGen;
import tilda.parsing.Parser;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Schema;
import tilda.utils.AsciiArt;
import tilda.utils.DurationUtil;
import tilda.utils.SystemValues;

/**
 * This command line utility will generate necessary artifacts from a tilda schema definition file as defined in
 * <A href="https://github.com/CapsicoHealth/Tilda/wiki/Tilda-JSON-Syntax">the Tilda Wiki</A>.
 * <P>
 * It takes one or more parameters that represent the paths to the Tilda JSON files to be processed.
 * This utility automatically handles dependencies for any listed schemas. For example:
 * 
 * <PRE>
 *   tilda.Gen C:/projects/Xyz/src/com/myCo/package/schema1/_tilda.Schema1.json
 * </PRE>
 * 
 * @author Laurent Hasson
 *
 */
public class Gen
  {
    static final Logger      LOG   = LogManager.getLogger(Gen.class.getName());

    static final Set<String> NOTES = new TreeSet<String>();

    public static void main(String[] Args)
      {
        SystemValues.autoInit();

        if (Args.length == 0)
          {
            LOG.error("The utility must be called with a path to a Tilda json file");
            System.exit(-1);
          }
        long TS = System.nanoTime();
        Map<String, Schema> SchemaCache = new HashMap<String, Schema>();
        for (String path : Args)
          {
            if (path.endsWith(".jsonX") == true)
              {
                LOG.info("File '" + path + "' ends in .jsonX and will be skipped");
                continue;
              }
            try
              {
                GeneratorSession G = new GeneratorSession("java", 8, -1, "postgres", 9, 6);
                ParserSession PS = Parser.parse(path, G.getSql(), SchemaCache, false);
                if (PS == null)
                  throw new Exception("An error occurred trying to process Tilda file '" + path + "'.");
                if (PS.getErrorCount() > 0)
                  {
                    PS.printErrors();
                    throw new java.lang.RuntimeException("There were " + PS.getErrorCount() + " errors detected during gen.");
                  }

                LOG.info("Loaded Tilda schema '" + PS._Main.getFullName() + "'.");
                if (PS.hasDependencies() == true)
                  {
                    LOG.info("  Loaded and validated dependencies:");
                    Iterator<Schema> I = PS.getDependenciesIterator();
                    while (I.hasNext() == true)
                      LOG.debug("    - " + I.next().getFullName() + ".");
                  }
                Generator.generate(PS._Main, G);
                Manifest.update(PS);
                // new GraphvizUtil(PS._Main, G).writeSchema();
                new DocGen(PS._Main, G).writeSchema(PS);
                LOG.info("Generated Tilda code for schema '" + PS._Main.getFullName() + "'.");

                if (PS.getNoteCount() > 0)
                  {
                    NOTES.addAll(PS._Notes);
                  }
              }
            catch (Throwable T)
              {
                LOG.info("\n"
                + "          ======================================================================================\n"
                + AsciiArt.Error("               ")
                + "\n"
                + "                       Couldn't load the Tilda definition file " + path + ".\n"
                + "          ======================================================================================\n", T);
                System.exit(-1);
              }
          }
        // Now that we can realize views into tables in another schema, we have to output
        // documentation of a given realized table twice. The first time is in the schema
        // of its originating view. The second is in its destination. Because the target
        // schemas are modified in the pass above, we do this second pass to make sure the
        // docs are completed and output (i.e., the first pass of the target schema did not
        // have the realized tables ready for output yet.
        try
          {
            for (Schema S : SchemaCache.values())
              {
                if (S._ForeignRealizations == false)
                  continue;
                GeneratorSession G = new GeneratorSession("java", 8, -1, "postgres", 9, 6);
                ParserSession PS = new ParserSession(S, null);
                DocGen DG = new DocGen(PS._Main, G);
                DG.writeSchema(PS);
              }
          }
        catch (Throwable T)
          {
            LOG.info("\n"
            + "          ======================================================================================\n"
            + AsciiArt.Error("               ")
            + "\n"
            + "                      An error occurred resolving the foreign-realized schemas.\n"
            + "          ======================================================================================\n", T);
            System.exit(-1);
          }

        if (NOTES.size() > 0)
          {
            LOG.info("\n");
            LOG.info("================================================ Gen Notes ================================================");
            LOG.info("There were " + NOTES.size() + " notes raised when validating the generated code.");
            int i = 0;
            for (String Note : NOTES)
              LOG.info("    " + (++i) + (i < 10 ? " " : "") + " - " + Note);
            LOG.info("\n");
          }

        LOG.info("\n"
        + "          ======================================================================================\n"
        + AsciiArt.Woohoo("                       ")
        + "\n"
        + "              All Tilda code, migration scripts and documentation was generated succesfully.    \n"
        + "                            " + DurationUtil.printDuration(System.nanoTime() - TS) + "\n"
        + "                            " + (SchemaCache.size()-1) + " Schemas, " + countTables(SchemaCache) + " Tables, and " + countViews(SchemaCache) + " Views\n"
        + "          ======================================================================================");
      }

    private static int countTables(Map<String, Schema> schemaCache)
      {
        int count = 0;
        for (Schema s : schemaCache.values())
          if (s._Name.equalsIgnoreCase("TILDA") == false)
            count += s._Objects.size();
        return count;
      }

    private static int countViews(Map<String, Schema> schemaCache)
      {
        int count = 0;
        for (Schema s : schemaCache.values())
          if (s._Name.equalsIgnoreCase("TILDA") == false)
            count += s._Views.size();
        return count;
      }

  }
