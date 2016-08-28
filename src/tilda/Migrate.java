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

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.utils.SystemValues;

public class Migrate
  {
    static final Logger LOG = LogManager.getLogger(Migrate.class.getName());
    
    static boolean _MIGRATION_START_ = false;
    
    static public boolean isMigrationActive() { return _MIGRATION_START_; }

    public static void main(String[] Args)
      {
        SystemValues.autoInit();

        Connection C = null;
        try
          {
            _MIGRATION_START_ = true;
            C = ConnectionPool.get("MAIN");
            C.close();
          }
        catch (Exception E)
          {
            if (C != null)
              try
                {
                  C.close();
                }
              catch (Exception E2)
                {
                  LOG.catching(E2);
                }

            LOG.error("Cannot migrate the database.\n", E);
          }

      }
  }
