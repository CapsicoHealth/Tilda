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

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.Loader;
import tilda.parsing.parts.Schema;
import tilda.utils.AsciiArt;
import tilda.utils.FileUtil;

public class Docs
  {
    static final Logger LOG = LogManager.getLogger(Docs.class.getName());

    public static void main(String[] Args)
      {
        LOG.info("");
        LOG.info("Tilda documentation utility");
        LOG.info("  - Takes one parameter, a folder, where to put the documentation files from active Tilda schemas in the classpath.");
        LOG.info("");
        if (Args.length != 1)
          {
            LOG.error("You must specify a single parameter, a folder where to put the documentation files from active Tilda schemas in the classpath.");
            return;
          }
        try
          {
            List<Schema> TildaList = Loader.LoadTildaResources();
            if (TildaList == null)
              throw new Exception("We didn't find the necessary Tilda resources.");
            for (Schema S : TildaList)
              {
                String Name = FileUtil.getBasePathFromFileOrResource(S._ResourceName)+"_Tilda/TILDA___Docs."+S._Name.toUpperCase()+".html";
                LOG.debug("Extracting Tilda documentation "+Name);
                PrintWriter Out = FileUtil.getBufferedPrintWriter(Args[0]+File.separator+"TILDA___Docs."+S._Name.toUpperCase()+".html", false);
                FileUtil.copyFileContentsIntoAnotherFile(Name, Out);
                Out.close();

                Name = FileUtil.getBasePathFromFileOrResource(S._ResourceName)+"_Tilda/TILDA___PostgreSQL."+S._Name.toUpperCase()+".sql";
                LOG.debug("Extracting Tilda SQL file "+Name);
                Out = FileUtil.getBufferedPrintWriter(Args[0]+File.separator+"TILDA___PostgreSQL."+S._Name.toUpperCase()+".sql", false);
                FileUtil.copyFileContentsIntoAnotherFile(Name, Out);
                Out.close();
              }
          }
        catch (Exception E)
          {
            LOG.error("\n"
                     +"          ======================================================================================\n"
                     +AsciiArt.Error("               ")
                     +"\n"
                     +"               Cannot extract documentation from active Tilda definitions in the classpath.\n"
                     +"          ======================================================================================\n"
                     , E);
            System.exit(-1);
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
