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
      }

    public final String                            _Table;
    public final String                            _Query;
    public String                                  _Warnings           = null;
    public boolean                                 _WarningsCollection = false;
    public boolean                                 _Deadlocked         = false;
    public boolean                                 _Canceled           = false;

    private static final ThreadLocal<QueryDetails> _LastQuery          = new ThreadLocal<QueryDetails>();

    public static void setLastQuery(String TableName, String Query)
      {
        // Creates a whole new QueryDetail, but most pass on the _WarningsCollection flag.
        QueryDetails lastQuery = _LastQuery.get();
        boolean warningsCollection = lastQuery != null ? lastQuery._WarningsCollection : false;
        lastQuery = new QueryDetails(TableName, Query);
        lastQuery._WarningsCollection = warningsCollection;
        _LastQuery.set(lastQuery);
      }

    public static void setLastQueryWarning(String str)
      {
        QueryDetails LastQuery = _LastQuery.get();
        if (LastQuery != null && TextUtil.isNullOrEmpty(str) == false)
          LastQuery._Warnings = str;
      }

    public static void setLastQueryDeadlocked()
      {
        QueryDetails LastQuery = _LastQuery.get();
        if (LastQuery != null)
          LastQuery._Deadlocked = true;
      }

    public static void setLastQueryCanceled()
      {
        QueryDetails LastQuery = _LastQuery.get();
        if (LastQuery != null)
          LastQuery._Canceled = true;
      }

    public static boolean isLastQueryDeadlocked()
      {
        QueryDetails LastQuery = _LastQuery.get();
        return LastQuery != null ? LastQuery._Deadlocked : false;
      }

    public static boolean isLastQueryCanceled()
      {
        QueryDetails LastQuery = _LastQuery.get();
        return LastQuery != null ? LastQuery._Canceled : false;
      }

    public static String getLastQuery()
      {
        QueryDetails LastQuery = _LastQuery.get();
        return LastQuery == null ? null : LastQuery._Query;
      }

    public static String getLastQuerySecure()
      {
        QueryDetails LastQuery = _LastQuery.get();
        return LastQuery == null ? null : LastQuery._Query.replaceAll("\'[^\']*\'", "'****'");
      }

    public static String getLastQueryWarnings()
      {
        QueryDetails LastQuery = _LastQuery.get();
        return LastQuery != null ? LastQuery._Warnings : null;
      }

    public static void setWarningsCollection(boolean val)
      {
        QueryDetails LastQuery = _LastQuery.get();
        if (LastQuery != null)
          LastQuery._WarningsCollection = val;
      }

    public static boolean isWarningsCollection()
      {
        QueryDetails LastQuery = _LastQuery.get();
        return LastQuery != null ? LastQuery._WarningsCollection : false;

      }


    public static final String _LOGGING_HEADER = TextUtil.identity("    ~~ ");

    public static void logQuery(String tableName, String query, String values)
      {
        LOG.debug(_LOGGING_HEADER + AnsiUtil.NEGATIVE + "[" + tableName + "]" + AnsiUtil.NEGATIVE_OFF + ": " + query);
        if (values != null)
          LOG.debug(_LOGGING_HEADER + "   " + values);
      }

    private static final ThreadLocal<Boolean> _SessionMaskMode          = new ThreadLocal<Boolean>();
    public static boolean getThreadMaskMode()
      {
        Boolean sessionMaskMode = _SessionMaskMode.get();
        return sessionMaskMode==null?false:sessionMaskMode;
      }

    /**
     * This method sets the masking mode for the current thread. Any Tilda object created in the thread
     * will be marked as masked by default. This method should typically be used in the context of setting up a session and
     * Connections. This shouldn't be used in application-level code to "disable" masking mode for instance.
     */
    public static void setThreadMaskMode_DO_NOT_USE_IN_GENERAL_APP_CODE(boolean maskingMode)
      {
        _SessionMaskMode.set(maskingMode);
      }
  }
