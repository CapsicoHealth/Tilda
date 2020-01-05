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

package tilda.db;

import tilda.db.processors.ScalarRP;
import tilda.utils.concurrent.DBPoll;

/**
 * Allows managing a templorary database-level sequence with
 * 
 * @author Laurent Hasson
 *
 */
public class SequencePoll extends DBPoll
  {
    public static interface Handler
      {
        public void handle(String SequenceName, int Count, long SequenceValue);

        public void close();
      }

    public SequencePoll(String PoolName, long PauseMillis, String SequenceName, Handler H)
      {
        super(PoolName, PauseMillis);
        _SequenceName = SequenceName;
        _H = H;
      }

    String  _SequenceName;
    Handler _H;
    
    public String getSequenceName() { return _SequenceName; }

    @Override
    public void init()
    throws Exception
      {
        super.init();
        if (_C.executeDDL("public", "sequences", "CREATE SEQUENCE " + _SequenceName + " minvalue 0;") == false)
          throw new Exception("Cannot create sequence '" + _SequenceName + "'.");
        if (_C.executeDDL("public", "sequences", "SELECT setval('" + _SequenceName + "', 0);") == false)
          throw new Exception("Cannot create sequence '" + _SequenceName + "'.");
        _C.commit();
      }

    @Override
    protected void close()
    throws Exception
      {
        if (_C.executeDDL("public", "sequences", "DROP SEQUENCE " + _SequenceName + ";") == false)
          throw new Exception("Cannot drop sequence '" + _SequenceName + "'.");
        _C.commit();
        _H.close();
      }


    @Override
    protected boolean doRun(Connection C, int Count)
    throws Exception
      {
        try
          {
            ScalarRP RP = new ScalarRP();
            // Gotta to a nextval to cross transaction boundaries, so we are playing a trick here.
            if (C.executeSelect("public", _SequenceName, "select nextval('" + _SequenceName + "')", RP) <= 0)
              {
                LOG.debug("Finished sequence polling");
                return false;
              }
            // We are doing whatever the nextval value has returned, minus the count here +1 (since it's 0-based).
            // That way, we get the true count of nextvals from the sequence minus those we artificially create here.
            _H.handle(_SequenceName, Count, RP.getResult() - Count - 1);
          }
        catch (Exception E)
          {
            LOG.error("Exception managing the sequence polling\n", E);
            throw E;
          }
        return true;
      }
  }
