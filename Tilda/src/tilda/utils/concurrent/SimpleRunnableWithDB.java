/* ===========================================================================
 * Copyright (C) 2018 CapsicoHealth Inc.
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

package tilda.utils.concurrent;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.utils.DurationUtil;

public abstract class SimpleRunnableWithDB extends SimpleRunnable
  {
    protected static final Logger LOG = LogManager.getLogger(SimpleRunnableWithDB.class);

    public SimpleRunnableWithDB(String poolId, String name)
      {
        super(name);
        _poolName = poolId;
      }

    String _poolName;

    @Override
    public void run()
      {
        long T0 = System.nanoTime();
        Connection C = null;
        try
          {
            C = ConnectionPool.get(_poolName);
            doRun(C);
            C.commit();
            C.close();
            _taskTimeNano = System.nanoTime() - T0;
            LOG.debug("\n\n*******************************************************************************************\n"
            + "** Task " + _name + " ran in " + DurationUtil.printDuration(_taskTimeNano) + ".\n"
            + (_totalCount == 0 ? "" : "** Processed " + _totalCount + " records (" + DurationUtil.printPerformancePerMinute(_taskTimeNano, _totalCount) + " records/min).\n")
            + "*******************************************************************************************\n\n");
          }
        catch (Exception E)
          {
            LOG.error("An error occurred in the thread\n", E);
            _executor.addException(E);
            try
              {
                if (C != null)
                  C.rollback();
              }
            catch (SQLException E2)
              {
                LOG.error("An error occurred rolling back the transaction\n", E2);
              }
            try
              {
                if (C != null)
                  C.close();
              }
            catch (SQLException E2)
              {
                LOG.error("An error occurred closing the transaction\n", E2);
              }
            _taskTimeNano = System.nanoTime() - T0;
          }
      }

    public final void doRun()
    throws Exception
      {
        throw new Exception("This method should not be called in this class. Use doRun(Connection C) instead.");
      }

    public abstract void doRun(Connection C)
    throws Exception;

  }
