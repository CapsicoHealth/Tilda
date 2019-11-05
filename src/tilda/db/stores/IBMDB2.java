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
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.FKMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.PKMeta;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.types.ColumnDefinition;
import tilda.types.Type_DatetimePrimitive;
import tilda.utils.DurationUtil.IntervalEnum;
import tilda.utils.TextUtil;
import tilda.utils.pairs.ColMetaColPair;
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
    public boolean isErrNoData(SQLException E)
      {
        return E.getSQLState().equals("23505");
      }

    @Override
    public String getCurrentTimestampStr()
      {
        return "CURRENT TIMESTAMP";
      }

    protected static final String[] _LOCK_CONN_ERROR_SUBSTR = { "deadlocked on lock", "lock request time out", "lock inconsistency found", "connection reset", "connection is closed"
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
    public boolean fullIdentifierOnUpdate()
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
    public boolean alterTableDropColumn(Connection Con, Object Obj, String ColumnName)
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
    public boolean createKeysEntry(Connection Con, Object Obj)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean dropView(Connection Con, View V)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean createView(Connection Con, View V)
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
    public DBStringType getDBStringType(int Size)
      {
        return Size < 20 ? DBStringType.CHARACTER
        : Size < 4096 ? DBStringType.VARCHAR
        : DBStringType.TEXT;
      }
    
    @Override
    public boolean alterTableAlterColumnNumericSize(Connection connection, ColumnMeta colMeta, Column col)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }    

    @Override
    public boolean alterTableAlterColumnStringSize(Connection Con, ColumnMeta ColMeta, Column Col)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean alterTableAlterColumnType(Connection Con, ColumnMeta ColMeta, Column Col, ZoneInfo_Data defaultZI)
      {
        throw new UnsupportedOperationException();
      }  
    
    @Override
    public boolean alterTableAlterColumnMulti(Connection Con, List<ColMetaColPair> BatchTypeCols, List<ColMetaColPair> BatchSizeCols, ZoneInfo_Data defaultZI)
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public String getHelperFunctionsScript(Connection Con, boolean Start)
    throws Exception
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
    public void getColumnType(StringBuilder Str, ColumnType T, Integer S, ColumnMode M, boolean Collection, Integer Precision, Integer Scale)
      {
        throw new UnsupportedOperationException();        
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
    public void truncateTable(Connection C, String schemaName, String tableName, boolean cascade)
    throws Exception
      {
        throw new UnsupportedOperationException();

      }

    @Override
    public void age(Connection C, StringBuilder Str, Type_DatetimePrimitive ColStart, Type_DatetimePrimitive ColEnd, IntervalEnum Type, int Count, String Operator)
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean alterTableComment(Connection C, Object Obj)
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean alterTableAlterColumnComment(Connection C, Column Col)
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public void within(Connection C, StringBuilder Str, Type_DatetimePrimitive Col, Type_DatetimePrimitive ColStart, long DurationCount, IntervalEnum DurationType)
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public String getAclRolesScript(Connection Con, List<Schema> TildaList)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public boolean alterTableReplaceTablePK(Connection Con, Object Obj, PKMeta oldPK)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean alterTableDropFK(Connection Con, Object Obj, FKMeta FK)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean alterTableAddFK(Connection Con, ForeignKey FK)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean alterTableDropIndex(Connection Con, Object Obj, IndexMeta IX)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public boolean alterTableAddIndex(Connection Con, Index IX)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }
    
    @Override
    public boolean isSuperUser(Connection C)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public boolean alterTableRenameIndex(Connection Con, Object Obj, String OldName, String NewName)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }
    
    @Override
    public int getMaxColumnNameSize()
      {
        return 63;
      }
    @Override
    public int getMaxTableNameSize()
      {
        return 63;
      }


    @Override
    public String alterTableAddIndexDDL(Index IX)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public boolean alterTableAlterColumnDefault(Connection Con, Column Col)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public int getMaxCores(Connection C)
    throws Exception
      {
        // TODO Auto-generated method stub
        return 2;
      }

    public String getBackendConnectionId(Connection connection)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public void cancel(Connection C)
    throws SQLException
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public boolean isCanceledError(SQLException t)
      {
        throw new UnsupportedOperationException();
      }
  }
