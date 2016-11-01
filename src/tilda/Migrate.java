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

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.ConnectionPool;

public class Migrate
  {
    static final Logger    LOG               = LogManager.getLogger(Migrate.class.getName());

    static private boolean _MIGRATION_START_ = false;

    static public boolean isMigrationActive()
      {
        return _MIGRATION_START_;
      }

    public static void main(String[] Args)
      {
        LOG.info("###################################################################################################");
        LOG.info("##  This utility will attempt to migrate automatically the database connected to via the 'MAIN'  ##");
        LOG.info("##  connection definined in tilda.config.json, using ALL the Tilda schema definitions found in   ##");
        LOG.info("##  JARs in the classpath.                                                                       ##");
        LOG.info("###################################################################################################");
        LOG.info("");
        LOG.info("!!! THIS UTILITY MAY CHANGE DATA IN YOUR DATABASE. MAKE SURE YOU HAVE A BACKUP. !!!");
//        LOG.info("    ===> "+DBUrl);
        LOG.info("");
        LOG.info("Press 'y' followed by enter to continue.");
        Scanner scanner = null;
        try
          {
            scanner = new Scanner(System.in);
            String answer = scanner.next();
            if (answer.toLowerCase().equals("y") == false)
              throw new Exception("User asked to exit.");
            LOG.info("");
            LOG.info("OK! Starting the migration...");
            LOG.info("------------------------------------");
            _MIGRATION_START_ = true;
            ConnectionPool.autoInit();
          }
        catch (Exception E)
          {
            LOG.error("Cannot migrate the database.\n", E);
          }
        finally
          {
            if (scanner != null)
              scanner.close();
          }

        LOG.info("");
        LOG.info("=========================================================");
        LOG.info("===  Woohoo! The database was migrated successfully.  ===");
        LOG.info("=========================================================");
        LOG.info("");
      }
  }
