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

import java.io.PrintWriter;
import java.io.StringWriter;
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
import tilda.generation.Generator;
import tilda.generation.SQLServer2014.SQLServerType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.postgres9.PostgresType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.types.ColumnDefinition;
import tilda.types.Type_DatetimePrimitive;
import tilda.utils.DurationUtil.IntervalEnum;
import tilda.utils.TextUtil;
import tilda.utils.pairs.ColMetaColPair;
import tilda.utils.pairs.StringStringPair;

public class MSSQL implements DBType
  {
    static final Logger LOG = LogManager.getLogger(MSSQL.class.getName());

    @Override
    public String getName()
      {
        return "MSSQL";
      }

    @Override
    public boolean isErrNoData(SQLException E)
      {
        return E.getSQLState().equals("23000") || E.getErrorCode() == 2601;
      }


    @Override
    public String getCurrentTimestampStr()
      {
        return "current_timestamp";
      }

    protected static final String[] _LOCK_CONN_ERROR_SUBSTR = {
        "deadlocked on lock", "lock request time out", "lock inconsistency found", "connection reset", "connection is closed", "connection has been closed"
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
    public boolean supportsArrays()
      {
        return false;
      }

    @Override
    public String getSelectLimitClause(int Start, int Size)
      {
        return "";
      }

    @Override
    public String getAggregateStr(AggregateType AT)
      {
        switch (AT)
          {
            case AVG:
              return "avg";
            case DEV:
              return "stdev";
            case MAX:
              return "max";
            case MIN:
              return "min";
            case SUM:
              return "sum";
            case VAR:
              return "var";
            default:
              throw new Error("Cannot convert AggregateType " + AT + " to a database aggregate function name.");
          }
      }

    @Override
    public boolean FullIdentifierOnUpdate()
      {
        return false;
      }

    protected static CodeGenSql _SQL = new tilda.generation.SQLServer2014.Sql();

    @Override
    public CodeGenSql getSQlCodeGen()
      {
        return _SQL;
      }

    @Override
    public boolean createSchema(Connection Con, Schema S)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        getSQlCodeGen().genFileStart(Out, S);
        Con.executeDDL(S.getShortName(), null, Str.toString());
        return true;
      }

    @Override
    public boolean createTable(Connection Con, Object Obj)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getTableDDL(getSQlCodeGen(), Out, Obj, true, true);
        Con.executeDDL(Obj._ParentSchema._Name, Obj.getShortName(), Str.toString());
        return true;
      }

    @Override
    public boolean createKeysEntry(Connection Con, Object Obj)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getTableDDL(getSQlCodeGen(), Out, Obj, false, true);
        Con.executeDDL(Obj._ParentSchema._Name, Obj.getShortName(), Str.toString());
        return true;
      }

    @Override
    public boolean dropView(Connection Con, View V)
    throws Exception
      {
        Con.executeDDL(V._ParentSchema._Name, V.getShortName(), "DROP VIEW [" + V._ParentSchema._Name + "].[" + V._Name + "]");
        return true;
      }

    @Override
    public boolean createView(Connection Con, View V)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getFullViewDDL(getSQlCodeGen(), Out, V);
        Con.executeDDL(V._ParentSchema._Name, V.getShortName(), Str.toString());
        return true;
      }

    public String getColumnType(ColumnType T, Integer S, ColumnMode M, boolean Collection)
      {
        if (Collection == true)
          return "nvarchar(max)";
        
        if (T == ColumnType.STRING && M != ColumnMode.CALCULATED)
          {
            DBStringType DBT = getDBStringType(S);
            return DBT == DBStringType.CHARACTER ? PostgresType.CHAR._SQLType + "(" + S + ")"
            : DBT == DBStringType.VARCHAR ? PostgresType.STRING._SQLType + "(" + S + ")"
            : "nvarchar(max)";
          }

        return SQLServerType.get(T)._SQLType;
      }

    @Override
    public boolean alterTableAddColumn(Connection Con, Column Col, String DefaultValue)
    throws Exception
      {
        if (Col._Nullable == false && DefaultValue == null)
          throw new Exception("Cannot add new 'not null' column '" + Col.getFullName() + "' to a table without a default value. Add a default value in the model, or manually migrate your database.");
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ADD \"" + Col.getName() + "\" " + getColumnType(Col.getType(), Col._Size, Col._Mode, Col.isCollection());
        if (Col._Nullable == false)
          {
            Q += " not null DEFAULT " + ValueHelper.printValue(Col.getName(), Col.getType(), DefaultValue);
          }

        Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
        return true;
      }

    @Override
    public boolean alterTableDropColumn(Connection Con, Object Obj, String ColumnName)
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
        return false;
      }

    @Override
    public String getHelperFunctionsScript(Connection Con, boolean Start)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }


    @Override
    public StringStringPair getTypeMapping(int Type, String Name, int Size, String TypeName)
    throws Exception
      {
        ColumnType TildaType = null;
        String TypeSql = null;
        switch (Type)
          {
            /*@formatter:off*/
            case java.sql.Types.ARRAY        : TypeSql = "ARRAY"       ;
               switch (TypeName)
                {
                  case "_int4"  : TildaType = ColumnType.INTEGER; break;
                  case "_int8"  : TildaType = ColumnType.LONG; break;
                  case "_float4": TildaType = ColumnType.FLOAT; break;
                  case "_float8": TildaType = ColumnType.DOUBLE; break;
                  case "_bpchar": TildaType = ColumnType.CHAR; break;
                  case "_text"  : TildaType = ColumnType.STRING; break;
                  case "_bool"  : TildaType = ColumnType.BOOLEAN; break;
                  case "_uuid"  : TildaType = ColumnType.UUID; break;
                  
                  default: throw new Exception("Cannot map SQL TypeName "+TypeName+" for array column '"+Name+"'.");
                }
               break;
            case java.sql.Types.BIGINT       : TypeSql = "BIGINT"       ; TildaType = ColumnType.LONG; break;
            case java.sql.Types.BINARY       : TypeSql = "BINARY"       ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.BIT          : TypeSql = "BIT"          ; TildaType = ColumnType.BOOLEAN; break;
            case java.sql.Types.BLOB         : TypeSql = "BLOB"         ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.BOOLEAN      : TypeSql = "BOOLEAN"      ; TildaType = ColumnType.BOOLEAN; break;
            case java.sql.Types.CHAR         : TypeSql = "CHAR"         ; TildaType = Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.CLOB         : TypeSql = "CLOB"         ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.DATALINK     : TypeSql = "DATALINK"     ; TildaType = null; break;
            case java.sql.Types.DATE         : TypeSql = "DATE"         ; TildaType = null; break;
            case java.sql.Types.DECIMAL      : TypeSql = "DECIMAL"      ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.DISTINCT     : TypeSql = "DISTINCT"     ; TildaType = null; break;
            case java.sql.Types.DOUBLE       : TypeSql = "DOUBLE"       ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.FLOAT        : TypeSql = "FLOAT"        ; TildaType = ColumnType.FLOAT; break;
            case java.sql.Types.INTEGER      : TypeSql = "INTEGER"      ; TildaType = ColumnType.INTEGER; break;
            case java.sql.Types.JAVA_OBJECT  : TypeSql = "JAVA_OBJECT"  ; TildaType = null; break;
            case java.sql.Types.LONGNVARCHAR : TypeSql = "LONGNVARCHAR" ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.LONGVARBINARY: TypeSql = "LONGVARBINARY"; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.LONGVARCHAR  : TypeSql = "LONGVARCHAR"  ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.NCHAR        : TypeSql = "NCHAR"        ; TildaType = Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.NCLOB        : TypeSql = "NCLOB"        ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.NULL         : TypeSql = "NULL"         ; TildaType = null; break;
            case java.sql.Types.NUMERIC      : TypeSql = "NUMERIC"      ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.NVARCHAR     : TypeSql = "NVARCHAR"     ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.OTHER        :
              if (TypeName != null && TypeName.equalsIgnoreCase("jsonb") == true)
                {
                  TypeSql = "JSONB";
                  TildaType = ColumnType.JSON;
                }
              else
                {
                  TypeSql = "OTHER";
                  TildaType = null;
                }
              break;
            case java.sql.Types.REAL         : TypeSql = "REAL"         ; TildaType = ColumnType.FLOAT; break;
            case java.sql.Types.REF          : TypeSql = "REF"          ; TildaType = null; break;
            case java.sql.Types.ROWID        : TypeSql = "ROWID"        ; TildaType = null; break;
            case java.sql.Types.SMALLINT     : TypeSql = "SMALLINT"     ; TildaType = null; break;
            case java.sql.Types.SQLXML       : TypeSql = "SQLXML"       ; TildaType = null; break;
            case java.sql.Types.STRUCT       : TypeSql = "STRUCT"       ; TildaType = null; break;
            case java.sql.Types.TIME         : TypeSql = "TIME"         ; TildaType = null; break;
            case microsoft.sql.Types.DATETIMEOFFSET:             
            case java.sql.Types.TIMESTAMP    : TypeSql = "TIMESTAMP"    ; TildaType = ColumnType.DATETIME; break;
            case java.sql.Types.TINYINT      : TypeSql = "TINYINT"      ; TildaType = null; break;
            case java.sql.Types.VARBINARY    : TypeSql = "VARBINARY"    ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.VARCHAR      : TypeSql = "VARCHAR"      ; TildaType = ColumnType.STRING; break;
            default: throw new Exception("Cannot map SQL Type "+Type+" for column "+Name+"("+TypeName+").");
            /*@formatter:on*/
          }
        return new StringStringPair(TypeSql, TildaType.name());
      }

    @Override
    public void getFullColumnVar(StringBuilder Str, String SchemaName, String TableName, String ColumnName)
      {
        if (TextUtil.isNullOrEmpty(SchemaName) == false)
          Str.append("[").append(SchemaName).append("].");
        if (TextUtil.isNullOrEmpty(TableName) == false)
          Str.append("[").append(TableName).append("].");
        Str.append("[").append(ColumnName).append("]");
      }

    @Override
    public void getFullTableVar(StringBuilder Str, String SchemaName, String TableName)
      {
        Str.append("[").append(SchemaName).append("].[").append(TableName).append("]");
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
        StringBuilder Str = new StringBuilder();
        TextUtil.escapeSingleQuoteForSQL(Str, val, true);
        PS.setString(i, Str.toString());
      }

    @Override
    public Collection<?> getArray(ResultSet RS, int i, ColumnType Type, boolean isSet)
    throws Exception
      {
        String Str = RS.getString(i);
        if (Str == null)
          return null;

        String[] parts = Str.split("\\s*',\\s*'\\s*");
        if (parts == null || parts.length == 0)
          return null;

        // Remove the leading and trailing " in the entire string sequence.
        if (TextUtil.isNullOrEmpty(parts[0]) == false)
          {
            parts[0] = parts[0].substring(1);
          }
        if (TextUtil.isNullOrEmpty(parts[parts.length - 1]) == false)
          {
            parts[parts.length - 1] = parts[parts.length - 1].substring(0, parts[parts.length - 1].length() - 1);
          }

        // Convert String[] to proper type and collection.
        return Type.parse(isSet, parts);
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
        return "?";
      }

    @Override
    public void setOrderByWithNullsOrdering(Connection C, StringBuilder Str, ColumnDefinition Col, boolean Asc, boolean NullsLast)
      {
        Str.append("(CASE WHEN ");
        Col.getFullColumnVarForSelect(C, Str);
        Str.append(NullsLast ? " IS NULL THEN 1 ELSE 0 END) ASC, " : " IS NULL THEN 0 ELSE 1 END) ASC, ");
        Col.getFullColumnVarForSelect(C, Str);
        Str.append(Asc == true ? " ASC" : " DESC");
      }

    @Override
    public void truncateTable(Connection C, String schemaName, String tableName, boolean cascade)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        Str.append("TRUNCATE TABLE ");
        getFullTableVar(Str, schemaName, tableName);
        C.executeUpdate(schemaName, tableName, Str.toString());
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
    public boolean alterTableRenameIndex(Connection Con, Object Obj, String OldName, String NewName)
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
