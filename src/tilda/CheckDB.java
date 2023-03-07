/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.ParseUtil;

public class CheckDB
  {
    protected static final Logger LOG = LogManager.getLogger(CheckDB.class.getName());

    public static void main(String args[])
    throws Exception
      {
        String driverClassName = args[0];
        String dbUrl = args[1];
        int retries = ParseUtil.parseInteger(args[2], 2);
        int delay = ParseUtil.parseInteger(args[3], 10);
        
        LOG.debug("driverClassName: "+driverClassName);
        LOG.debug("dbUrl          : "+dbUrl);
        LOG.debug("retries        : "+retries);
        LOG.debug("delay          : "+delay);

        Class.forName(driverClassName);

        int attempt = 0;
        while (true)
          {
            try
              {
                ++attempt;
                LOG.debug("Connection attempt #"+attempt);
                DriverManager.getConnection(dbUrl);
                LOG.debug("The database is online!");
                return;
              }
            catch (SQLException e)
              {
                if (e.getMessage().toLowerCase().contains("login") == true)
                  {
                    LOG.debug("The database is online! Exception was: "+e.getMessage());
                    return;
                  }
                LOG.warn("The database is not online: SQLState="+e.getSQLState()+"; SQLState="+e.getErrorCode()+"\n", e);
                if (--retries > 0)
                 {
                   LOG.warn("Will retry in "+delay+" seconds.");
                   Thread.sleep(delay*1000);
                 }
                else
                  break;
              }
          }
        LOG.error("Could not connect to the database.");
        System.exit(-1);
      }

  }
