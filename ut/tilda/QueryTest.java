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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.Key_Data;
import tilda.data.Key_Factory;
import tilda.data.Testing_Factory;
import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.SelectQuery;
import tilda.db.UpdateQuery;
import tilda.db.processors.StringListRP;

public class QueryTest extends Key_Factory
  {
    protected static final Logger LOG = LogManager.getLogger(QueryTest.class.getName());

    protected QueryTest()
      {
      }

    public static void main(String[] args)
      {

        Connection C = null;
        try
          {
            C = ConnectionPool.get("MAIN");

            Key_Data K = Key_Factory.Create(-3, "TOTO", 0, 100);

              {
                UpdateQuery Q = newUpdateQuery(C);
                Q.set(COLS.MAX, COLS.MAX).plus(COLS.COUNT).set(COLS.COUNT, 100)
                    .where().equals(COLS.REFNUM, K.getRefnum()).and().equals(COLS.NAME, "TOTO");
                Q.execute();
              }
              {
                SelectQuery Q = newSelectQuery(C);
                Q.set(COLS.MAX, COLS.COUNT)
                    .from(Testing_Factory.SCHEMA_LABEL, Testing_Factory.TABLENAME_LABEL)
                    .from(Key_Factory.SCHEMA_LABEL, Key_Factory.TABLENAME_LABEL)
                    .where().equals(COLS.REFNUM, K.getRefnum()).and().equals(COLS.NAME, "TOTO");
                Q.execute(new StringListRP(), 0, -1);
              }

            StringBuilder Q = new StringBuilder();
            Q.append("update "); Key_Factory.getFullTableNameVar(C, Q); 
            Q.append(" set ").append(COLS.MAX).append("=").append(COLS.MAX).append("+").append(COLS.COUNT)
             .append(" where ").append(COLS.REFNUM).append("=").append(K.getRefnum())
             ;            
            C.ExecuteUpdate(Key_Factory.SCHEMA_LABEL, Key_Factory.TABLENAME_LABEL, Q.toString());

            C.rollback();
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
                  C.close();
                }
              catch (SQLException E)
                {
                }
          }
      }
  }
