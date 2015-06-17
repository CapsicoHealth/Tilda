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

import tilda.db.Connection;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.utils.TextUtil;

public class MSSQL implements DBType
  {
    @Override
    public boolean isErrNoData(String SQLState, int ErrorCode)
      {
        return SQLState.equals("23000") || ErrorCode == 2601;
      }


    @Override
    public String getCurrentTimestampStr()
      {
        return "current_timestamp";
      }


    @Override
    public String getName()
      {
        return "SQLServer";
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
        return false;
      }
    
    @Override
    public boolean supportsSelectSubsetting()
      {
        return false;
      }

    @Override
    public boolean getSelectSubsettingClause(StringBuilder Str, int Start, int Size)
      {
        return false;
      }

    @Override
    public boolean FullIdentifierOnUpdate()
      {
        return false;
      }
    
    @Override
    public boolean alterTableAddColumn(Connection Con, Column Col, String DefaultValue) throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public CodeGenSql getSQlCodeGen()
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean createTable(Connection Con, Object Obj)
      throws Exception
      {
        throw new UnsupportedOperationException();
      }
    
    @Override
    public boolean createSchema(Connection Con, Schema S)
      throws Exception
      {
        throw new UnsupportedOperationException();
      }
  }
