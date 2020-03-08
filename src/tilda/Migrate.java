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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.ConnectionPool;
import tilda.utils.AsciiArt;

public class Migrate
  {
    static final Logger    LOG               = LogManager.getLogger(Migrate.class.getName());

    static private boolean _MIGRATION_START_ = false;
    static private boolean _IS_TESTING_      = false;

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

    public static void main(String[] Args)
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
        try
          {
            _MIGRATION_START_ = true;
            ConnectionPool.autoInit();
          }
        catch (Throwable T)
          {
            LOG.error("\n"
            + "          ======================================================================================\n"
            + AsciiArt.Error("               ")
            + "\n"
            + "                                Cannot Automatically Migrate The Database.\n"
            + "          ======================================================================================\n", T);
//            LogUtil.catchingCauses(LOG, T);
            System.exit(-1);
          }

        LOG.info("\n"
        + "          ======================================================================================\n"
        + AsciiArt.Woohoo("                       ")
        + "\n"
        + "               The database was automatically migrated to match the Application's data model.    \n"
        + "          ======================================================================================");
      }
  }
