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
import tilda.utils.SystemValues;

/**
 * Thread-friendly class to create a new connection and invoke a subclass' soRun() method for any processing.
 * <P>
 * Any user of this class is responsible for calling the init() and close() methods. The class implements the Runnable interface
 * and as such can be used in a new thread. the derived class doRun() method is called repeatedly at given intervals until it
 * returns false, at which time, the thread ends.
 * 
 * @author Laurent Hasson
 */
public abstract class DBPoll implements Runnable
  {
    protected static final Logger LOG = LogManager.getLogger(DBPoll.class);

    /**
     * Constructor for the class, taking a pool name and pause amount in millis seconds in between calls to doRun()
     * 
     * @param PoolName The name of the pool the new connection must be taken from.
     * @param PauseMillis The amount of time in milliseconds between calls to the doRun() method.
     */
    public DBPoll(String PoolName, long PauseMillis)
      {
        _PoolName = PoolName;
        _PauseMillis = PauseMillis;
      }

    String               _PoolName;
    long                 _PauseMillis;
    Exception            _E;
    protected Connection _C;

    /**
     * Initializes the connection. Must be called before the class is used either directly by calling the run() method, or through a Thread.
     *
     * @throws Exception if the connection couldn't be instanciated.
     */
    public void init()
    throws Exception
      {
        _C = ConnectionPool.get(_PoolName);
      }

    /**
     * If launched as a thread, attempts to terminate is asap.
     */
    public void terminate()
      {
        _PauseMillis = SystemValues.EVIL_VALUE;
      }

    /**
     * 
     */
    @Override
    public void run()
      {
        try
          {
            int count = -1;
            while (_PauseMillis != SystemValues.EVIL_VALUE && doRun(_C, ++count) == true)
              Thread.sleep(_PauseMillis);
          }
        catch (Exception E)
          {
            LOG.error("An error occurred in the thread\n", E);
            _E = E;
          }
        finally
          {
            try
              {
                _C.rollback();
              }
            catch (SQLException E)
              {
                LOG.error("An error occurred rolling back the transaction\n", E);
              }
            try
              {
                close();
              }
            catch (Exception E)
              {
                LOG.error("An error occurred closing the thread\n", E);
              }
            try
              {
                _C.close();
              }
            catch (SQLException E)
              {
                LOG.error("An error occurred closing the transaction\n", E);
              }
          }
      }

    /**
     * 
     * @param C
     * @param Count
     * @return
     * @throws Exception
     */
    protected abstract boolean doRun(Connection C, int Count)
    throws Exception;

    /**
     * Called when the thread is closing
     *
     * @throws Exception
     */
    protected abstract void close()
    throws Exception;

    
  }
