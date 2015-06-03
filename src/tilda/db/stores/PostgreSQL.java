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

package tilda.db.stores;

import java.sql.SQLException;

import tilda.utils.TextUtil;

public class PostgreSQL implements DBType
  {
    @Override
    public boolean isErrNoData(String SQLState, int ErrorCode)
      {
        return SQLState.equals("23505");
      }


    @Override
    public String getCurrentTimestampStr()
      {
        return "statement_timestamp()";
      }


    @Override
    public String getName()
      {
        return "PostgreSQL";
      }

    protected static final String[] _LOCK_CONN_ERROR_SUBSTR = { "deadlocked on lock"
        , "lock request time out"
        , "lock inconsistency found"
        , "connection reset"
        , "connection is closed"
        };

    @Override
    public boolean isLockOrConnectionError(SQLException E)
      {
        return TextUtil.indexOf(E.getMessage().toLowerCase(), _LOCK_CONN_ERROR_SUBSTR);
      }
    
    @Override
    public boolean needsSavepoint()
      {
        return true;
      }

    @Override
    public boolean supportsSelectSubsetting()
      {
        return true;
      }

    @Override
    public boolean getSelectSubsettingClause(StringBuilder Str, int Start, int Size)
      {
        if (Start <= 0 && Size <= 0)
         return false;
        
        if (Size <= 0)
         Str.append(" LIMIT ALL");
        else
         Str.append(" LIMIT ").append(Size);
        if (Start > 0)
         Str.append(" OFFSET "+Start);

        return true;
      }
    
    @Override
    public boolean FullIdentifierOnUpdate()
      {
        return true;
      }
  }
