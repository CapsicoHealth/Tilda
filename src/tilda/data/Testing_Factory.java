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

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
 * This is the application class <B>Data_TESTING</B> mapped to the table <B>TILDA.TESTING</B>.
 * 
 * @see tilda.data._Tilda.TILDA__TESTING
 */
public class Testing_Factory extends tilda.data._Tilda.TILDA__TESTING_Factory
  {
    protected static final Logger LOG = LogManager.getLogger(Testing_Factory.class.getName());

    public Testing_Factory()
      {
      }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Implement your customizations, if any, below.
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void init(Connection C)
    throws Exception
      {
        // Add logic to initialize your object, for example, caching some values, or validating some things.
      }

//    public static int WriteBatch(Connection C, List<Testing_Data> L, int batchSize)
//    throws Exception
//      {
//        long T0 = System.nanoTime();
//
//        if (L == null || L.isEmpty() == true)
//          return -1;
//
//        java.sql.PreparedStatement PS = null;
//        List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
//        int count = 0;
//        int batchStart = 0;
//
//        try
//          {
//            C.setSavepoint();
//            String Q = L.get(0).getWriteQuery(C);
//            PS = C.prepareStatement(Q);
//
//            int index = -1;
//            for (Testing_Data d : L)
//              {
//                ++index;
//                if (d == null || d.hasChanged() == false)
//                  continue;
//
//                if (d.__Init == InitMode.CREATE)
//                  {
//                    LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.TILDA.Testing' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
//                    QueryDetails.setLastQuery(TILDA__TESTING_Factory.SCHEMA_TABLENAME_LABEL, "");
//                    return index;
//                  }
//
//                if (d.BeforeWrite(C) == false)
//                  {
//                    LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.Testing object at positon #" + index + " failed in its BeforeWrite() method.");
//                    QueryDetails.setLastQuery(TILDA__TESTING_Factory.SCHEMA_TABLENAME_LABEL, "");
//                    return index;
//                  }
//
//                int i = d.populatePreparedStatement(C, PS, AllocatedArrays);
//
//                PS.addBatch();
//                if (index != 0 && index % batchSize == 0)
//                  {
//                    int[] results = PS.executeBatch();
//                    if (results == null || results.length != 1 || results[0] == 0)
//                      {
//                        LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.TILDA.Testing objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
//                        return index;
//                      }
//                    for (int index2 = batchStart; index2 <= index; ++index2)
//                      L.get(index2).stateUpdatePostWrite();
//                    LOG.debug("Batch-inserted objects between positions #" + batchStart + " and #" + index + ".");
//                    batchStart = 0;
//                  }
//                PS.clearParameters();
//              }
//            if (index != 0 && index % batchSize != 0)
//              {
//                int[] results = PS.executeBatch();
//                if (results == null || results.length != 1 || results[0] == 0)
//                  {
//                    LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.TILDA.Testing objects ending at position #" + index + " failed being written to the database.");
//                    return index;
//                  }
//                for (int index2 = batchStart; index2 <= index; ++index2)
//                  L.get(index2).stateUpdatePostWrite();
//                LOG.debug("Final Batch-inserted objects between positions #" + batchStart + " and #" + index + ".");
//              }
//
//            C.releaseSavepoint(true);
//          }
//        catch (java.sql.SQLException E)
//          {
//            C.releaseSavepoint(false);
//            return tilda.data._Tilda.TILDA__1_0.HandleCatch(C, E, "updated or inserted");
//          }
//        finally
//          {
//            tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TESTING_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
//            PS = null;
//            AllocatedArrays = null;
//          }
//      }

  }
