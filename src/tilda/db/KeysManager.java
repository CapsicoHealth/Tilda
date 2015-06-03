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
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.Key_Data;
import tilda.data.Key_Factory;
import tilda.parsing.Parser;


public class KeysManager
  {
    protected static final Logger     LOG = LogManager.getLogger(Parser.class.getName());

    protected static Map<String, Key_Data> _M  = null;

    public static long getKey(String ObjectName) throws Exception
      {
        Init();
        
        Key_Data k = _M.get(ObjectName);
        if (k == null)
         throw new Exception("Requested a key for unknown object '"+ObjectName+"'.");
        
        return k.nextKey();
      }

    protected static final String _SEM = "KEYS";

    protected static void Init() throws SQLException
      {
        if (_M == null)
          synchronized (_SEM)
            {
              if (_M == null)
                {
                  Connection C = null;
                  try
                    {
                      _M = new HashMap<String, Key_Data>();
                      C = ConnectionPool.get(_SEM);
                      ListResults<Key_Data> L = Key_Factory.LookupWhereAllByName(C, 0, -1);
                      for (Key_Data k : L)
                        {
                          _M.put(k.getName(), k);
                        }
                    }
                  catch (Throwable T)
                    {
                      LOG.error("Cannot initialize the Tilda KEYS", T);
                      throw new Error(T);
                    }
                  finally
                    {
                      if (C != null)
                        {
                          C.rollback();
                          C.close();
                        }
                    }
                }
            }
      }
  }
