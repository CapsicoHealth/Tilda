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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.ConnectionPool;
import tilda.utils.AsciiArt;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class Migrate
  {
    static final Logger         LOG               = LogManager.getLogger(Migrate.class.getName());

    static private boolean      _MIGRATION_START_ = false;
    static private boolean      _IS_TESTING_      = false;
    static private List<String> _OverrideFiles    = new ArrayList<String>();

    static public boolean isMigrationActive()
      {
        return _MIGRATION_START_;
      }

    static public boolean isTesting()
      {
        return _IS_TESTING_;
      }

    public static void setIsTesting(boolean isTesting)
      {
        _IS_TESTING_ = isTesting;
      }

    public static List<String> getOverrideFiles()
      {
        return _OverrideFiles;
      }

    public static void main(String[] Args)
    throws IOException
      {
        LOG.info("");
        LOG.info("Tilda migration utility");
        LOG.info("");
        LOG.info("###################################################################################################");
        LOG.info("##  This utility will attempt to migrate automatically the database connected to via the 'MAIN'  ##");
        LOG.info("##  connection definined in tilda.config.json, using ALL the Tilda schema definitions found in   ##");
        LOG.info("##  JARs in the classpath.                                                                       ##");
        LOG.info("###################################################################################################");
        LOG.info("");
        if (Args != null)
          for (int i = 0; i < Args.length; ++i)
            {
              String FileName = Args[i];
              boolean Error = false;
              if (TextUtil.isNullOrEmpty(FileName) == false)
                {
                  if (FileUtil.existsFileOrResource(FileName) == false)
                    {
                      LOG.error("Cannot locate Override Model file/resource '" + FileName + "'. Check your file path if it's a file, or classpath if it's a resource.");
                      Error = true;
                    }
                  else
                    _OverrideFiles.add(FileName);
                }
              if (Error == true)
                {
                  LOG.info("\n"
                  + "\n"
                  + "          ======================================================================================\n"
                  + AsciiArt.Error("               ")
                  + "\n"
                  + "                Some error(s) occurred while trying to locate Tilda Override Model files.\n"
                  + "          ======================================================================================\n"
                  + "\n");
                  System.exit(-1);
                }
            }
        try
          {
            _MIGRATION_START_ = true;
            ConnectionPool.autoInit();
          }
        catch (Exception E)
          {
            LOG.error("Cannot migrate the database.\n", E);
          }

        LOG.info("");
        LOG.info("DONE.");
        LOG.info("");
      }
  }
