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

package tilda.db;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.Key_Data;
import tilda.db.processors.ObjectProcessor;

public class DynamicQueryTest
  {
    protected static final Logger LOG = LogManager.getLogger(DynamicQueryTest.class.getName());

    public static void main(String[] args)
      {

        Connection C = null;
        try
          {
            C = ConnectionPool.get("MAIN");
            LOG.info("===== TEST 1 ===============================================================================");
            Test1(C);
            LOG.info("===== TEST 2 ===============================================================================");
            Test2(C);
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

    private static void Test1(Connection C)
    throws Exception
      {
        List<Key_Data> L = (List<Key_Data>) MasterFactory.lookupWhere(C, Key_Data.class, "NAME like 'PATIENTS.%' AND MAX <> 1", 0, -1);
        for (Key_Data D : L)
          LOG.debug(D.toString());
      }

    private static class ObjProc implements ObjectProcessor<Key_Data>
      {

      @Override
      public boolean process(int Index, Key_Data Obj)
      throws Exception
        {
          LOG.debug(Obj.toString());
          return true;
        }

      }

    private static void Test2(Connection C)
    throws Exception
      {
        ObjProc OP = new ObjProc();
        MasterFactory.lookupWhere(C, Key_Data.class, OP, "NAME like 'PATIENTS.%' AND MAX <> 1", 0, -1);
      }

  }
