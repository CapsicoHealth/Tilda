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

import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.JDBCHelper;

public class SQLServerTest
  {
    protected static final Logger LOG = LogManager.getLogger(SQLServerTest.class.getName());

    public static void main(String[] args)
      {

        Connection C = null;
        try
          {
            C = ConnectionPool.get("MAIN");
            Test1(C, "create schema TILDA");
          }
        catch (Exception E)
          {
            LOG.error("An exception occurred", E);
          }
        finally
          {
            if (C != null)
              try
                {
                  C.rollback();
                  C.close();
                }
              catch (SQLException E)
                {
                }
          }
      }

    protected static int Test1(Connection C, String Query)
    throws Exception
      {
        Statement S = null;
        try
          {
            S = C.createStatement();
            boolean OK = S.execute(Query);
            LOG.debug("OK: "+OK);
            C.commit();
            return 1;
          }
        finally
          {
            JDBCHelper.closeStatement(S);
          }
      }
  }
