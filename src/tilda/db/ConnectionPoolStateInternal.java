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


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.Migrate;
import tilda.enums.TransactionType;
import tilda.performance.PerfTracker;
import tilda.utils.concurrent.SimpleRunnableDB;


/**
 * Separating connection-getting from main {@link ConnectionPool} class to allow for multi-threading.
 * <p>
 * For performance reason, we are adding multi-threading to the {@link ConnectionPool} initialization logic, in particular
 * when we start reading up the database metadata. We have a very large database at a customer location with several dozen
 * schemas and several thousand tables/views. The part of the initialization reading up the metadata takes a couple of minutes
 * to run which is very annoying when doing frequent migrations or restarting of a web app during dev for example.
 * <p>
 * However, since this is happening from the context of the static initializer for {@link ConnectionPool}, we can't call back into it
 * from another thread as the class in the JVM hasn't completed static initialization. The trick is to separate the singleton logic
 * and state for getting new connections from the main {@link ConnectionPool} class so that it's reusable internally during the static
 * initialization phase.
 * <p>
 * This class should only be used by internal Tilda code (e.g., {@link SimpleRunnableDB}. The {@link ConnectionPool} class remain the main class
 * to use across application code.
 * 
 * @author Laurent Hasson
 *
 */
public class ConnectionPoolStateInternal
  {
    private ConnectionPoolStateInternal()
      {
      }
    static final Logger                           LOG                  = LogManager.getLogger(ConnectionPoolStateInternal.class.getName());

    protected static Map<String, BasicDataSource> _DataSourcesById     = new HashMap<String, BasicDataSource>();

    public static Connection get(String Id)
    throws Exception
      {
        return get(Id, null, null);
      }

    public static Connection get(String Id, String userId, String userPswd)
    throws Exception
      {
        if (userId == null)
          LOG.info(QueryDetails._LOGGING_HEADER + "G E T T I N G   C O N N E C T I O N  -----  " + Id);
        else
          LOG.info(QueryDetails._LOGGING_HEADER + "G E T T I N G   U N P O O L E D   C O N N E C T I O N   W I T H   U S E R   O V E R R I D E  (" + userId + ")-----  " + Id);
        BasicDataSource BDS = _DataSourcesById.get(Id);
        if (BDS == null)
          throw new Exception("Cannot find a connection pool for " + Id);

        java.sql.Connection C = null;
        for (int i = 1; i < 100; ++i)
          {
            try
              {
                long T0 = System.nanoTime();
                if (userId == null)
                  {
                    LOG.debug("GETTING CONN");
                    C = BDS.getConnection();
                    LOG.debug("GETTING CONN -- DONE");
                  }
                else
                  {
                    Class.forName(BDS.getDriverClassName());
                    C = DriverManager.getConnection(BDS.getUrl(), userId, userPswd);
                    C.setAutoCommit(false);
                    C.setTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);
                    C.setClientInfo("defaultRowFetchSize", "1000");
                  }
                LOG.debug("GETTING CONN -- TRACK PERF");
                PerfTracker.add(TransactionType.CONNECTION_GET, System.nanoTime() - T0);
                LOG.debug("GETTING CONN -- TRACK PERF -- DONE");
                break;
              }
            catch (SQLException E)
              {
                LOG.error("   - Attempt #" + i + " failed to obtain a connection: " + E.getMessage());
                if (Migrate.isTesting() == true)
                  {
                    if (C != null)
                      C.close();
                    throw E;
                  }
                if (i == 1)
                  LOG.error("     (Sleeping for 30 seconds, and will re-try again, for a max of 100 times)");
                Thread.sleep(1000 * 30);
              }
          }
        if (C == null)
          throw new Exception("Failed obtaining a connection after numerous tries.");
        Connection Conn = new Connection(C, Id);
        LOG.info(QueryDetails._LOGGING_HEADER + "G O T           C O N N E C T I O N  -----  " + Conn._PoolId + ", " + BDS.getNumActive() + "/" + BDS.getNumIdle() + "/" + BDS.getMaxTotal());
        return Conn;
      }

    public static BasicDataSource getDataSourceById(String PoolId)
      {
        return _DataSourcesById.get(PoolId);
      }
  }
