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

import java.util.Iterator;

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
import tilda.utils.SystemValues;

public class Gen
  {
    static final Logger LOG = LogManager.getLogger(Gen.class.getName());

    public static void main(String[] Args)
      {
        SystemValues.autoInit();

        if (Args.length == 0)
          {
            LOG.error("The utility must be called with a path to a Tilda json file");
            System.exit(-1);
          }

        for (String path : Args)
          {
            try
              {
                GeneratorSession G = new GeneratorSession("java", 8, -1, "postgres", 9, -1);
                
                ParserSession PS = Parser.parse(path, G.getSql());
                if (PS == null)
                  {
                    throw new Exception("An error occurred trying to process Tilda file '" + path + "'.");
                  }
                else
                  {
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
                  }
              }
            catch (Throwable T)
              {
                LOG.info("\n"
                        +"          ======================================================================================\n"
                        +AsciiArt.Error("               ")
                        +"\n"
                        +"                Couldn't load the Tilda definition file " + path + ".\n"
                        +"          ======================================================================================\n"
                        , T);
                System.exit(-1);
              }
          }
        
        LOG.info("\n"
                +"          ======================================================================================\n"
                +AsciiArt.Woohoo("                       ")
                +"\n"
                +"              All Tilda code, migration scripts and documentation was generated succesfully.    \n"
                +"          ======================================================================================"
                );
      }
  }
