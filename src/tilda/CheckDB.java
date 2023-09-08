/* ===========================================================================
 * Copyright (C) 2023 CapsicoHealth Inc.
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
        LOG.debug("CheckDB <driverClassName> <dbUrl> <user> <retries> <delay> <postWait>\n"
        +"    Checks a database connectivity by verifying that a user could log on (even though we don't specify a password),\n"
        +"    vs another error. Takes 6 parameters. If a connection cannot be made, exits with a system code of -1.\n"
        +" For example: CheckDB \"org.postgresql.Driver\" \"jdbc:postgresql://localhost:5432/MyDB\" postgres 10 15 30\n"
        +"              Checks the DB up to 10 times, waiting 15 seconds in between retries, and waiting an additional \n"
        +"              30s after a successful connection"
        );

        String driverClassName = args[0];
        String dbUrl = args[1];
        String user = args[2];
        int retries = ParseUtil.parseInteger(args[3], 3);
        int delay = ParseUtil.parseInteger(args[4], 10);
        int postWait = ParseUtil.parseInteger(args[5], 10);

        LOG.debug("driverClassName: "+driverClassName);
        LOG.debug("dbUrl          : "+dbUrl);
        LOG.debug("user           : "+user);
        LOG.debug("retries        : "+retries);
        LOG.debug("delay          : "+delay);
        LOG.debug("postWwait      : "+postWait);

        Class.forName(driverClassName);

        int attempt = 0;
        while (true)
          {
            try
              {
                ++attempt;
                LOG.debug("Connection attempt #"+attempt);
                DriverManager.getConnection(dbUrl, user, "XXX");
                LOG.error("Something is not right: this connection shouldn't have succeeded since we didn't pass in a password. You must specify an account that requires a password.");
                System.exit(-1);
              }
            catch (SQLException e)
              {
                String msg = e.getMessage().toLowerCase();
                if (msg.matches(".*(login|password).*(auth)?.*fail.*(user)?.*") == true)
                  {
                    LOG.debug("The database is online! Expected exception was: "+e.getMessage()+" (State="+e.getSQLState()+")");
                    LOG.debug("Waiting a bit more ("+postWait+" seconds)");
                    Thread.sleep(postWait*1000);
                    LOG.debug("Let's check one more time!");
                    try 
                      {
                        ++attempt;
                        LOG.debug("Connection attempt #"+attempt);
                        DriverManager.getConnection(dbUrl, user, "XXX");
                        LOG.error("Something is not right: this connection shouldn't have succeeded since we didn't pass in a password. You must specify an account that requires a password.");
                        System.exit(-1);
                      }
                    catch (SQLException e2)
                      {
                        msg = e2.getMessage().toLowerCase();
                        if (msg.matches(".*(login|password).*(auth)?.*fail.*(user)?.*") == true)
                          {
                            LOG.debug("SUCCESS!!!");
                            return;
                          }
                      }
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
