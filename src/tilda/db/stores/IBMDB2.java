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

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.ZoneInfo_Data;
import tilda.db.Connection;
import tilda.enums.AggregateType;
import tilda.enums.ColumnType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.migration.ColInfo;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.types.ColumnDefinition;
import tilda.utils.TextUtil;
import tilda.utils.pairs.StringStringPair;

public class IBMDB2 implements DBType
  {
    
    static final Logger LOG = LogManager.getLogger(IBMDB2.class.getName());
    
    @Override
    public String getName()
      {
        return "IBMDB2";
      }
    
    
    @Override
    public boolean isErrNoData(String SQLState, int ErrorCode)
      {
        return SQLState.equals("23505");
      }

    @Override
    public String getCurrentTimestampStr()
      {
        return "CURRENT TIMESTAMP";
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
    public boolean supportsSelectLimit()
      {
        return false;
      }

    @Override
    public boolean supportsSelectOffset()
      {
        return false;
      }

    @Override
    public String getSelectLimitClause(int Start, int Size)
      {
        return "";
      }

    @Override
    public boolean FullIdentifierOnUpdate()
      {
        return false;
      }

    @Override
    public String getAggregateStr(AggregateType AT)
      {
        switch (AT)
          {
            case AVG:
              return "avg";
            case DEV:
              return "stddev";
            case MAX:
              return "max";
            case MIN:
              return "min";
            case SUM:
              return "sum";
            case VAR:
              return "variance";
            default:
              throw new Error("Cannot convert AggregateType " + AT + " to a database aggregate function name.");
          }
      }


    @Override
    public boolean alterTableAddColumn(Connection Con, Column Col, String DefaultValue)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }
    
    @Override
    public boolean alterTableDropColumn(Connection Con, Object Obj, ColInfo CI)
    throws Exception
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
    public boolean createView(Connection Con, View V, boolean Drop)
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

    @Override
    public boolean alterTableAlterColumnNull(Connection Con, Column Col, String DefaultValue)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public int getCLOBThreshhold()
      {
        return 4096;
      }

    @Override
    public boolean alterTableAlterColumnStringSize(Connection Con, Column Col, int DBSize)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean alterTableAlterColumnType(Connection Con, ColumnType fromType, Column Col, ZoneInfo_Data defaultZI)
      {
        throw new UnsupportedOperationException();
      }
    
    @Override
    public boolean addHelperFunctions(Connection Con) throws Exception
     {
       throw new UnsupportedOperationException();
     }    
    
    @Override
    public StringStringPair getTypeMapping(int type, String name, int size, String typeName)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean supportsArrays()
      {
        return false;
      }

    @Override
    public void getFullColumnVar(StringBuilder Str, String SchemaName, String TableName, String ColumnName)
      {
        Str.append("\"").append(SchemaName).append("\".\"").append(TableName).append("\".\"").append(ColumnName).append("\"");
      }

    @Override
    public void getFullTableVar(StringBuilder Str, String SchemaName, String TableName)
      {
        Str.append("\"").append(SchemaName).append("\".\"").append(TableName).append("\"");
      }


    @Override
    public void setArray(Connection C, PreparedStatement PS, int i, ColumnType Type, List<Array> allocatedArrays, Collection<?> val)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public Collection<?> getArray(ResultSet RS, int i, ColumnType Type, boolean isSet)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public void setJson(PreparedStatement PS, int i, String jsonValue)
    throws Exception
      {
        // TODO Auto-generated method stub
        
      }


    @Override
    public String getJson(ResultSet RS, int i)
    throws Exception
      {
        // TODO Auto-generated method stub
        return null;
      }


    @Override
    public String getJsonParametrizedQueryPlaceHolder()
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public void setOrderByWithNullsOrdering(Connection C, StringBuilder Str, ColumnDefinition Col, boolean Asc, boolean NullsLast)
      {
        throw new UnsupportedOperationException();
        
      }


    @Override
    public void truncateTable(Connection C, String schemaName, String tableName)
    throws Exception
      {
        throw new UnsupportedOperationException();
        
      }


  }
