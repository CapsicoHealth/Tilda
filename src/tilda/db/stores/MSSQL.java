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
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.generation.Generator;
import tilda.generation.SQLServer2014.SQLServerType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.migration.ColInfo;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.types.ColumnDefinition;
import tilda.utils.TextUtil;
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
    public boolean isErrNoData(String SQLState, int ErrorCode)
      {
        return SQLState.equals("23000") || ErrorCode == 2601;
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
        Con.ExecuteDDL(S.getShortName(), null, Str.toString());
        return true;
      }

    @Override
    public boolean createTable(Connection Con, Object Obj)
    throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getFullTableDDL(getSQlCodeGen(), Out, Obj);
        Con.ExecuteDDL(Obj._ParentSchema._Name, Obj.getShortName(), Str.toString());
        return true;
      }

    @Override
    public boolean createView(Connection Con, View V, boolean Drop)
    throws Exception
      {
        if (Drop == true)
          {
            Con.ExecuteUpdate(V._ParentSchema._Name, V.getShortName(), "DROP VIEW [" + V._ParentSchema._Name + "].[" + V._Name + "]");
          }
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getFullViewDDL(getSQlCodeGen(), Out, V);
        Con.ExecuteDDL(V._ParentSchema._Name, V.getShortName(), Str.toString());
        return true;
      }

    public String getColumnType(ColumnType T, Integer S, ColumnMode M, boolean Collection)
      {
        if (Collection == true)
          return "nvarchar(max)";
        if (T == ColumnType.STRING && M != ColumnMode.CALCULATED)
          return S < 15 ? SQLServerType.CHAR._SQLType + "(" + S + ")" : S < getCLOBThreshhold() ? SQLServerType.STRING._SQLType + "(" + S + ")" : "nvarchar(max)";
        return SQLServerType.get(T)._SQLType;
      }

    @Override
    public boolean alterTableAddColumn(Connection Con, Column Col, String DefaultValue)
    throws Exception
      {
        if (Col._Nullable == false && DefaultValue == null)
          throw new Exception("Cannot add new 'not null' column '" + Col.getFullName() + "' to a table without a default value. Add a default value in the model, or manually migrate your database.");
        String Q = "ALTER TABLE " + Col._ParentObject.getShortName() + " ADD \"" + Col.getName() + "\" " + getColumnType(Col._Type, Col._Size, Col._Mode, Col.isCollection());
        if (Col._Nullable == false)
          {
            Q += " not null DEFAULT " + ValueHelper.printValue(Col, DefaultValue);
          }

        Con.ExecuteDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
        return true;
      }

    @Override
    public boolean alterTableDropColumn(Connection Con, Object Obj, ColInfo CI)
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
        return false;
      }

    @Override
    public boolean addHelperFunctions(Connection Con)
    throws Exception
      {
        return true;
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
                  default: throw new Exception("Cannot map SQL TypeName "+TypeName+" for array column.");
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
    public void setArray(Connection C, PreparedStatement PS, int i, ColumnType Type, List<Array> allocatedArrays, Collection<?> val)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        TextUtil.EscapeSingleQuoteForSQL(Str, val, true);
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
    public void truncateTable(Connection C, String schemaName, String tableName)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        Str.append("TRUNCATE TABLE ");
        getFullTableVar(Str, schemaName, tableName);
        C.ExecuteUpdate(schemaName, tableName, Str.toString());
      }

  }
