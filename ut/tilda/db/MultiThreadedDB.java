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

import tilda.db.processors.ScalarRP;
import tilda.utils.concurrent.Executor;
import tilda.utils.concurrent.SimpleRunnableDB;

public class MultiThreadedDB
  {
    protected static final Logger LOG = LogManager.getLogger(MultiThreadedDB.class.getName());

    public static void main(String[] args)
      {

        Connection C = null;
        try
          {
            C = ConnectionPool.get("MAIN");
            Test(C);
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



    protected static class CountRunnable extends SimpleRunnableDB
      {
        public CountRunnable(int testId, String PoolId)
          {
            super("MultiTest "+testId, PoolId);
            _TestId = testId;
          }
        
        int _TestId;


        @Override
        public void doRun(Connection C)
        throws Exception
          {
            LOG.debug("   Test " + _TestId);
            ScalarRP RP = new ScalarRP();
            C.executeSelect("CMS", "Claim", "select count(*) from CMS.Beneficiary", RP);
            LOG.debug("   Test " + _TestId + " -- COMPLETED: "+RP.getResult());
          }
      }

    private static void Test(Connection C)
    throws Exception
      {
        Executor O = new Executor(1);
        for (int i = 1; i <= 16; ++i)
          O.addRunnable(new CountRunnable(i, C.getPoolId()));

        List<Exception> Exceptions = O.run();
        if (Exceptions.isEmpty() == false)
          {
            LOG.error("There were " + Exceptions.size() + " errors.");
            for (Exception E : Exceptions)
              LOG.error("      ", E);
            throw new Exception("Couldn't read the database schema meta data.");
          }
        else
          LOG.info("COMPLETED SUCCESSFULLY");
      }

  }
