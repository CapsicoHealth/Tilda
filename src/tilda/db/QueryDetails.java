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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.AnsiUtil;
import tilda.utils.TextUtil;

public class QueryDetails
  {

    static final Logger LOG = LogManager.getLogger(QueryDetails.class.getName());

    public QueryDetails(String Table, String Query)
      {
        _Table = Table;
        _Query = Query;
        _Deadlocked = false;
      }

    public final String                            _Table;
    public final String                            _Query;
    public boolean                                 _Deadlocked;

    private static final ThreadLocal<QueryDetails> _LastQuery = new ThreadLocal<QueryDetails>();

    public static void setLastQuery(String TableName, String Query)
      {
        _LastQuery.set(new QueryDetails(TableName, Query));
      }

    public static void setLastQueryDeadlocked()
      {
        QueryDetails LastQuery = _LastQuery.get();
        if (LastQuery != null)
          LastQuery._Deadlocked = true;
      }

    public static boolean isLastQueryDeadlocked()
      {
        QueryDetails LastQuery = _LastQuery.get();
        return LastQuery != null ? LastQuery._Deadlocked : false;
      }

    public static String getLastQuerySecure()
      {
        QueryDetails LastQuery = _LastQuery.get();
        return LastQuery == null ? null : LastQuery._Query.replaceAll("\'[^\']*\'", "'****'");
      }

    public static final String _LOGGING_HEADER = TextUtil.Identity("    ~~ ");
    
    public static void logQuery(String TableName, String Query, String Values)
      {
        LOG.debug(_LOGGING_HEADER + AnsiUtil.NEGATIVE + "["+TableName+"]" + AnsiUtil.NEGATIVE_OFF + ": "+Query);
        if (Values != null)
         LOG.debug(_LOGGING_HEADER + "   " + Values);
      }
  }
