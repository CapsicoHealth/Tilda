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
import tilda.db.ConnectionPoolStateInternal;

public abstract class SimpleRunnableDB extends SimpleRunnable
  {
    protected static final Logger LOG = LogManager.getLogger(SimpleRunnableDB.class);

    public SimpleRunnableDB(String TaskName, String PoolId)
      {
        super(TaskName);
        _PoolId = PoolId;
      }

    String _PoolId;

    @Override
    public void doRun()
    throws Exception
      {
        Connection C = null;
        try
          {
            C = ConnectionPoolStateInternal.get(_PoolId);
            doRun(C);
            C.commit();
          }
        catch (Throwable T)
          {
            try
              {
                if (C != null)
                  C.rollback();
              }
            catch (SQLException E)
              {
                LOG.error("An error occurred rolling back the transaction\n", E);
              }
            throw T;
          }
        finally
          {
            try
              {
                if (C != null)
                  C.close();
              }
            catch (SQLException E)
              {
                LOG.error("An error occurred closing the transaction\n", E);
              }
          }
      }

    public abstract void doRun(Connection C)
    throws Exception;

  }
