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
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.core.BaseConnection;

import tilda.db.Connection;
import tilda.db.metadata.FKMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.PKMeta;
import tilda.db.processors.LocalDateRP;
import tilda.db.processors.ScalarRP;
import tilda.db.processors.StringRP;
import tilda.db.processors.ZonedDateTimeRP;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
import tilda.enums.TildaType;
import tilda.generation.bigquery.BigQueryType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.postgres9.Sql;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OrderBy;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.types.ColumnDefinition;
import tilda.types.Type_DatetimePrimitive;
import tilda.utils.AsciiArt;
import tilda.utils.CollectionUtil;
import tilda.utils.DurationUtil.IntervalEnum;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;
import tilda.utils.pairs.StringStringPair;

public class BigQuery extends CommonStoreImpl
  {
    static final Logger LOG = LogManager.getLogger(BigQuery.class.getName());

    @Override
    public String getName()
      {
        return "BigQuery";
      }

    @Override
    public String getCurrentTimestampStr()
      {
        return "CURRENT_TIMESTAMP()";
      }

    @Override
    public String getCurrentDateStr()
      {
        return "CURRENT_DATE()";
      }

    protected static final String[] _NODATA_SQL_STATES = { ""
    };

    @Override
    public String[] getConnectionNoDataStates()
      {
        LOG.error(AsciiArt.printError(AsciiArt._DEFAULT_LEAD, "UNIMPLEMENTED LOGIC!!!!!"));
        return _NODATA_SQL_STATES; // "23505".equals(E.getSQLState());
      }


    protected static final String[] _LOCK_CONN_ERROR_SUBSTR = { "deadlocked on lock", "lock request time out", "lock inconsistency found", "connection reset", "connection is closed"
    };

    @Override
    public String[] getConnectionLockMsgs()
      {
        LOG.error(AsciiArt.printError(AsciiArt._DEFAULT_LEAD, "UNIMPLEMENTED LOGIC!!!!!"));
        return _LOCK_CONN_ERROR_SUBSTR;
      }

    /**
     * BigQuery Cancellation codes, from <A href="https://www.postgresql.org/docs/11/errcodes-appendix.html">https://www.postgresql.org/docs/11/errcodes-appendix.html</A>
     * <P>
     * <UL>
     * <LI><B>xxxxx</B>: xxxxxxxxxxxxx.</LI>
     * <LI><B>57000</B>: operator_intervention.</LI>
     * <LI><B>57014</B>: query_canceled.</LI>
     * <LI><B>57P01</B>: admin_shutdown.</LI>
     * <LI><B>57P02</B>: crash_shutdown.</LI>
     * <LI><B>57P03</B>: cannot_connect_now.</LI>
     * <LI><B>57P04</B>: database_dropped.</LI>
     * </UL>
     */
    protected static final String[] _CANCEL_SQL_STATES = { "57000", "57014", "57P01", "57P02", "57P03", "57P04"
    };

    @Override
    public String[] getConnectionCancelStates()
      {
        LOG.error(AsciiArt.printError(AsciiArt._DEFAULT_LEAD, "UNIMPLEMENTED LOGIC!!!!!"));
        return _CANCEL_SQL_STATES;
      }

    @Override
    public boolean needsSavepoint()
      {
        return false;
      }

    @Override
    public boolean supportsSelectLimit()
      {
        return true;
      }

    @Override
    public boolean supportsSelectOffset()
      {
        return true;
      }

    @Override
    public boolean supportsFilterClause()
      {
        return false;
      }

    @Override
    public boolean supportsArrays()
      {
        return true;
      }

    @Override
    public boolean supportsPrimaryKeys()
      {
        return false;
      }

    @Override
    public boolean supportsForeignKeys()
      {
        return false;
      }

    @Override
    public boolean supportsIndices()
      {
        return false;
      }
    
    @Override
    public char getColumnQuotingStartChar()
      {
        return '`';
      }

    @Override
    public char getColumnQuotingEndChar()
      {
        return '`';
      }

    @Override
    public String getAggregateStr(AggregateType AT)
      {
        switch (AT)
          {
            case COUNT:
              return "count";
            case AVG:
              return "avg";
            case MIN:
              return "min";
            case MAX:
              return "max";
            case SUM:
              return "sum";
            case FIRST:
              return "first";
            case LAST:
              return "last";
            case DEV:
              return "stddev";
            case VAR:
              return "variance";
            case ARRAY:
              return "array_agg";
            case ARRAYCAT:
              return "array_cat_agg";
            case ROW_NUMBER:
              return "row_number";
            case RANK:
              return "rank";
            case PERCENT_RANK:
              return "percent_rank";
            case LEAD:
              return "lead";
            case LAG:
              return "lag";
            case NTH_VALUE:
              return "nth_value";
            default:
              throw new Error("Cannot convert AggregateType " + AT + " to a database aggregate function name.");
          }
      }


    @Override
    public boolean fullIdentifierOnUpdate()
      {
        return true;
      }

    protected static tilda.generation.bigquery.Sql _SQL = new tilda.generation.bigquery.Sql();

    @Override
    public CodeGenSql getSQlCodeGen()
      {
        return _SQL;
      }

    @Override
    public DBStringType getDBStringType(int Size)
      {
        return DBStringType.TEXT;
      }

// LDH-NOTE: What is the difference between getColumnType and getColumnTypeRaw????
    
    @Override
    public String getColumnType(ColumnType Type, Integer Size, ColumnMode M, boolean isCollection, Integer Precision, Integer Scale)
      {
        if (Type == ColumnType.STRING && M != ColumnMode.CALCULATED)
          {
            DBStringType ST = Size == null ? null : getDBStringType(Size);
            return isCollection == true ? "ARRAY<STRING>" : "STRING";
          }

        return (Type != ColumnType.JSON && isCollection == true ? "ARRAY<":"")
        + BigQueryType.get(Type)._SQLType
        + (Type == ColumnType.NUMERIC && Precision != null ? "(" + Precision + (Scale != null ? "," + Scale : "") + ")" : "")
        + (Type != ColumnType.JSON && isCollection == true ? ">" : "");
      }

 // LDH-NOTE: What is the difference between getColumnType and getColumnTypeRaw????
    
    @Override
    public String getColumnTypeRaw(ColumnType Type, int Size, boolean Calculated, boolean isCollection, boolean MultiOverride)
      {
        if (Type == ColumnType.STRING && Calculated == false)
          {
            DBStringType DBT = getDBStringType(Size);
            return isCollection == true || MultiOverride == true ? "STRING"
            : DBT == DBStringType.CHARACTER ? BigQueryType.CHAR._SQLType
            : DBT == DBStringType.VARCHAR ? BigQueryType.STRING._SQLType
            : "STRING";
          }
        if (Type == ColumnType.JSON)
          return "json";
        return isCollection == true ? BigQueryType.get(Type)._SQLArrayType : BigQueryType.get(Type)._SQLType;
      }    

    @Override
    public String getHelperFunctionsScript(Connection Con, boolean Start)
    throws Exception
      {
        return FileUtil.getFileOfResourceContents("tilda/db/stores/BigQuery.helpers-" + (Start == true ? "start" : "end") + ".sql");
      }

    @Override
    public String getAclRolesScript(Connection Con, List<Schema> TildaList)
    throws Exception
      {
        return null;
      }

    @Override
    public StringStringPair getTypeMapping(int Type, String Name, int Size, String TypeName)
    throws Exception
      {
        // LOG.debug("Type: "+Type+"; Name: "+Name+"; Size: "+Size+"; TypeName: "+TypeName+";");
        ColumnType TildaType = null;
        String TypeSql = null;
        switch (Type)
          {
            /*@formatter:off*/
            case java.sql.Types.ARRAY        : TypeSql = "ARRAY"        ;
                                               TildaType = getSubTypeMapping(Name, TypeName, TildaType);
                                               break;
            case java.sql.Types.DISTINCT     : TypeSql = "DISTINCT"     ;
                                               TildaType = getSubTypeMapping(Name, TypeName, TildaType);
                                               break;
            case java.sql.Types.BIGINT       : TypeSql = "BIGINT"       ; TildaType = ColumnType.LONG; break;
            case java.sql.Types.BINARY       : TypeSql = "BINARY"       ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.BIT          : TypeSql = "BIT"          ; TildaType = ColumnType.BOOLEAN; break;
            case java.sql.Types.BLOB         : TypeSql = "BLOB"         ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.BOOLEAN      : TypeSql = "BOOLEAN"      ; TildaType = ColumnType.BOOLEAN; break;
            case java.sql.Types.CHAR         : TypeSql = "CHAR"         ; TildaType = Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.CLOB         : TypeSql = "CLOB"         ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.DATALINK     : TypeSql = "DATALINK"     ; TildaType = null; break;
            case java.sql.Types.DATE         : TypeSql = "DATE"         ; TildaType = ColumnType.DATE; break;
            case java.sql.Types.DECIMAL      : TypeSql = "DECIMAL"      ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.DOUBLE       : TypeSql = "DOUBLE"       ; TildaType = ColumnType.DOUBLE; break;
            case java.sql.Types.FLOAT        : TypeSql = "FLOAT"        ; TildaType = ColumnType.FLOAT; break;
            case java.sql.Types.SMALLINT     : TypeSql = "SMALLINT"     ; TildaType = ColumnType.SHORT; break;
            case java.sql.Types.INTEGER      : TypeSql = "INTEGER"      ; TildaType = ColumnType.INTEGER; break;
            case java.sql.Types.JAVA_OBJECT  : TypeSql = "JAVA_OBJECT"  ; TildaType = null; break;
            case java.sql.Types.LONGNVARCHAR : TypeSql = "LONGNVARCHAR" ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.LONGVARBINARY: TypeSql = "LONGVARBINARY"; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.LONGVARCHAR  : TypeSql = "LONGVARCHAR"  ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.NCHAR        : TypeSql = "NCHAR"        ; TildaType = Size==1 ? ColumnType.CHAR : ColumnType.STRING; break;
            case java.sql.Types.NCLOB        : TypeSql = "NCLOB"        ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.NULL         : TypeSql = "NULL"         ; TildaType = null; break;
            case java.sql.Types.NUMERIC      : TypeSql = "NUMERIC"      ; TildaType = ColumnType.NUMERIC; break;
            case java.sql.Types.NVARCHAR     : TypeSql = "NVARCHAR"     ; TildaType = ColumnType.STRING; break;
            case java.sql.Types.OTHER        :
              if (TypeName != null && TypeName.equalsIgnoreCase("jsonb") == true)
                {
                  TypeSql = "JSONB";
                  TildaType = ColumnType.JSON;
                }
              else if (TypeName != null && TypeName.equalsIgnoreCase("uuid") == true)
                {
                  TypeSql = "UUID";
                  TildaType = ColumnType.UUID;
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
            case java.sql.Types.SQLXML       : TypeSql = "SQLXML"       ; TildaType = null; break;
            case java.sql.Types.STRUCT       : TypeSql = "STRUCT"       ; TildaType = null; break;
            case java.sql.Types.TIME         : TypeSql = "TIME"         ; TildaType = null; break;
            case java.sql.Types.TIMESTAMP    : TypeSql = "TIMESTAMP"    ; TildaType = ColumnType.DATETIME; break;
            case java.sql.Types.TINYINT      : TypeSql = "TINYINT"      ; TildaType = null; break;
            case java.sql.Types.VARBINARY    : TypeSql = "VARBINARY"    ; TildaType = ColumnType.BINARY; break;
            case java.sql.Types.VARCHAR      : TypeSql = "VARCHAR"      ; TildaType = ColumnType.STRING; break;
            default:
              TildaType = null;
              LOG.warn("Cannot map SQL Type "+Type+" for column "+Name+"("+TypeName+"). Has been set to UNMAPPED column type.");
            /*@formatter:on*/
          }
        return new StringStringPair(TypeSql, TildaType == null ? null : TildaType.name());
      }


    private static ColumnType getSubTypeMapping(String Name, String TypeName, ColumnType TildaType)
    throws Exception
      {
        switch (TypeName)
          {
            case "_int2":
              TildaType = ColumnType.SHORT;
              break;
            case "_int4":
              TildaType = ColumnType.INTEGER;
              break;
            case "_int8":
              TildaType = ColumnType.LONG;
              break;
            case "_float4":
              TildaType = ColumnType.FLOAT;
              break;
            case "_float8":
              TildaType = ColumnType.DOUBLE;
              break;
            case "_numeric":
              TildaType = ColumnType.NUMERIC;
              break;
            case "_uuid":
              TildaType = ColumnType.UUID;
              break;
            case "_bpchar":
              TildaType = ColumnType.CHAR;
              break;
            case "_text":
            case "_varchar":
            case "character_data":
              TildaType = ColumnType.STRING;
              break;
            case "_bool":
              TildaType = ColumnType.BOOLEAN;
              break;
            case "_date":
              TildaType = ColumnType.DATE;
              break;
            case "_timestamptz":
              TildaType = ColumnType.DATETIME;
              break;
            default:
              TildaType = null;
              LOG.warn("Cannot map SQL TypeName " + TypeName + " for array column '" + Name + "'. Set to UNMAPPED column type.");
          }
        return TildaType;
      }

    @Override
    public void getFullColumnVar(StringBuilder Str, String SchemaName, String TableName, String ColumnName)
      {
        if (TextUtil.isNullOrEmpty(SchemaName) == false)
          Str.append(SchemaName).append(".").append(TableName).append(".");
        else if (TextUtil.isNullOrEmpty(TableName) == false)
          Str.append(TableName).append(".");
        Str.append("\"").append(ColumnName).append("\"");
      }

    @Override
    public void getFullTableVar(StringBuilder Str, String SchemaName, String TableName)
      {
        Str.append(SchemaName).append(".").append(TableName);
      }


    @Override
    public void setArray(Connection C, PreparedStatement PS, int i, ColumnType Type, List<Array> allocatedArrays, Collection<?> val)
    throws Exception
      {
        java.sql.Array A = C.createArrayOf(_SQL.getColumnTypeRaw(Type, -1, true), val.toArray());
        allocatedArrays.add(A);
        PS.setArray(i, A);
      }


    @Override
    public Collection<?> getArray(ResultSet RS, int i, ColumnType Type, boolean isSet)
    throws Exception
      {
        Array A = RS.getArray(i);
        if (A == null)
          return null;
        Collection<?> val = isSet == true ? CollectionUtil.toSet(A.getArray())
        : CollectionUtil.toList(A.getArray());
        A.free();
        return val;
      }

    @Override
    public Collection<?> getArray(ResultSet RS, String colName, ColumnType Type, boolean isSet)
    throws Exception
      {
        Array A = RS.getArray(colName);
        if (A == null)
          return null;
        Collection<?> val = isSet == true ? CollectionUtil.toSet(A.getArray())
        : CollectionUtil.toList(A.getArray());
        A.free();
        return val;
      }

    /*
     * @Override
     * public void setJson(PreparedStatement PS, int i, String jsonValue)
     * throws Exception
     * {
     * // TODO Auto-generated method stub
     * 
     * }
     * 
     * 
     * @Override
     * public String getJson(ResultSet RS, int i)
     * throws Exception
     * {
     * // TODO Auto-generated method stub
     * return null;
     * }
     * 
     * @Override
     * public String getJson(ResultSet RS, String colName)
     * throws Exception
     * {
     * // TODO Auto-generated method stub
     * return null;
     * }
     */

    @Override
    public String getJsonParametrizedQueryPlaceHolder()
      {
        return "cast(? as jsonb)";
      }


    @Override
    public void setOrderByWithNullsOrdering(Connection C, StringBuilder Str, ColumnDefinition Col, boolean Asc, boolean NullsLast)
      {
        Col.getFullColumnVarForSelect(C, Str);
        Str.append(Asc == true ? " ASC" : " DESC");
        Str.append(" NULLS ").append(NullsLast == true ? "LAST" : "FIRST");
      }


    @Override
    public void truncateTable(Connection C, String schemaName, String tableName, boolean cascade)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        Str.append("TRUNCATE ");
        getFullTableVar(Str, schemaName, tableName);
        if (cascade == true)
          Str.append(" CASCADE");
        C.executeUpdate(schemaName, tableName, Str.toString());
      }


    @Override
    public void age(Connection C, StringBuilder Str, Type_DatetimePrimitive ColStart, Type_DatetimePrimitive ColEnd, IntervalEnum Type, int Count, String Operator)
      {
        Str.append(" (");
        ColEnd.getFullColumnVarForSelect(C, Str);
        Str.append(" - ");
        ColStart.getFullColumnVarForSelect(C, Str);
        Str.append(")").append(Operator).append("INTERVAL '").append(Count).append(" ").append(Type.toString()).append("'");
      }


    @Override
    public boolean alterTableComment(Connection Con, Object Obj)
    throws Exception
      {
        String Q = "COMMENT ON TABLE " + Obj.getShortName() + " IS " + TextUtil.escapeSingleQuoteForSQL(Obj._Description) + ";";
        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }

    @Override
    public boolean alterTableReplaceTablePK(Connection Con, Object Obj, PKMeta oldPK)
    throws Exception
      {
        if (oldPK != null)
          {
            String Q = "ALTER TABLE " + Obj.getShortName() + " DROP CONSTRAINT \"" + oldPK._Name + "\";";
            if (Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q) == false)
              return false;
          }
        if (Obj._PrimaryKey != null)
          {
            String Q = "ALTER TABLE " + Obj.getShortName() + " ADD PRIMARY KEY (" + PrintColumnList(Obj._PrimaryKey._ColumnObjs) + ");";
            return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
          }
        return true;
      }

    @Override
    public boolean alterTableDropFK(Connection Con, Object Obj, FKMeta FK)
    throws Exception
      {
        String Q = "ALTER TABLE " + Obj.getShortName() + " DROP CONSTRAINT \"" + FK._Name + "\";";
        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }

    @Override
    public boolean alterTableAddFK(Connection Con, ForeignKey FK)
    throws Exception
      {
        String Q = "ALTER TABLE " + FK._ParentObject.getShortName() + " ADD CONSTRAINT \"" + FK._Name + "\""
        + " FOREIGN KEY (" + PrintColumnList(FK._SrcColumnObjs) + ") REFERENCES " + FK._DestObjectObj._ParentSchema._Name + "." + FK._DestObjectObj._Name
        + " ON DELETE restrict ON UPDATE cascade";
        return Con.executeDDL(FK._ParentObject._ParentSchema._Name, FK._ParentObject.getBaseName(), Q);
      }

    @Override
    public boolean alterTableDropIndex(Connection Con, Object Obj, IndexMeta IX)
    throws Exception
      {
        // If the DB Name comes in as all lower case, it's case-insensitive. Otherwise, we have to quote.
        String DropName = IX._Name.equals(IX._Name.toLowerCase()) == false ? "\"" + IX._Name + "\"" : IX._Name;
        String Q = "DROP INDEX " + Obj._ParentSchema._Name + "." + DropName + ";";
        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), Q);
      }


    @Override
    public String alterTableAddIndexDDL(Index IX)
    throws Exception
      {
        StringWriter OutStr = new StringWriter();
        PrintWriter Out = new PrintWriter(OutStr);
        boolean Gin = true;
        for (Column C : IX._ColumnObjs)
          if (C.getType() != ColumnType.JSON && (C.getType() != ColumnType.STRING || C.isCollection() == false))
            Gin = false;
        for (OrderBy OB : IX._OrderByObjs)
          if (OB._Col.getType() != ColumnType.JSON && (OB._Col.getType() != ColumnType.STRING || OB._Col.isCollection() == false))
            Gin = false;
        if (Gin == true && IX._Unique == true)
          throw new Exception(IX._Parent.getFullName() + " is defining index '" + IX.getName() + "' which is GIN-Elligible and also defined as UNIQUE: GIN indices cannot be unique.");
        if (IX._Db == false)
          Out.print("-- app-level index only -- ");
        if (supportsIndices() == false)
          Out.print("-- ");
        Out.print("CREATE" + (IX._Unique == true ? " UNIQUE" : "") + " INDEX IF NOT EXISTS " + IX.getName() + " ON " + IX._Parent.getShortName() + (Gin ? " USING gin " : "") + " (");
        if (IX._ColumnObjs.isEmpty() == false)
          Sql.PrintColumnList(Out, IX._ColumnObjs, IX._LALColumns);
        if (IX._OrderByObjs.isEmpty() == false)
          {
            boolean First = IX._ColumnObjs.isEmpty();
            for (OrderBy OB : IX._OrderByObjs)
              {
                if (OB == null)
                  continue;

                if (First == true)
                  First = false;
                else
                  Out.print(", ");
                Out.print("\"" + OB._Col.getName() + "\" " + (Gin ? "" : OB._Order));
                if (OB._Nulls != null)
                  Out.print(" NULLS " + OB._Nulls);
              }
          }
        Out.print(")");
        if (IX._SubQuery != null)
          {
            Query Q = IX._SubQuery.getQuery(DBType.Postgres);
            Out.print(" where " + Q._Clause);
          }
        Out.println(";");
        return OutStr.toString();
      }

    @Override
    public boolean alterTableAddIndex(Connection Con, Index IX)
    throws Exception
      {
        return Con.executeDDL(IX._Parent._ParentSchema._Name, IX._Parent.getBaseName(), alterTableAddIndexDDL(IX));
      }


    @Override
    public boolean alterTableRenameIndex(Connection Con, Object Obj, String OldName, String NewName)
    throws Exception
      {
        // If the DB Name comes in as all lower case, it's case-insensitive. Otherwise, we have to quote.
        if (OldName.equals(OldName.toLowerCase()) == false || OldName.equals(TextUtil.sanitizeName(OldName)) == false)
          OldName = "\"" + OldName + "\"";

        String Q = "ALTER INDEX " + Obj._ParentSchema._Name + "." + OldName + " RENAME TO " + NewName + ";";

        return Con.executeDDL(Obj._ParentSchema._Name, Obj._Name, Q);
      }


    private static String PrintColumnList(List<Column> Columns)
      {
        StringBuilder Str = new StringBuilder();
        boolean First = true;
        for (Column C : Columns)
          {
            if (C == null)
              continue;
            if (First == true)
              First = false;
            else
              Str.append(", ");
            Str.append("\"" + C.getName() + "\"");
          }
        return Str.toString();
      }

    @Override
    public void within(Connection C, StringBuilder Str, Type_DatetimePrimitive Col, Type_DatetimePrimitive ColStart, long DurationCount, IntervalEnum DurationType)
      {
        if (DurationCount >= 0)
          {
            Str.append(" (");
            Col.getFullColumnVarForSelect(C, Str);
            Str.append(" >= ");
            ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(" and ");
            Col.getFullColumnVarForSelect(C, Str);
            Str.append(" < ");
            ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(" + INTERVAL '").append(DurationCount).append(" ").append(DurationType.toString()).append("'");
            Str.append(")");
          }
        else
          {
            DurationCount = -DurationCount;
            Str.append(" (");
            Col.getFullColumnVarForSelect(C, Str);
            Str.append(" > ");
            ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(" - INTERVAL '").append(DurationCount).append(" ").append(DurationType.toString()).append("'");
            Str.append(" and ");
            Col.getFullColumnVarForSelect(C, Str);
            Str.append(" <= ");
            ColStart.getFullColumnVarForSelect(C, Str);
            Str.append(")");
          }
      }

    @Override
    public boolean isSuperUser(Connection C)
    throws Exception
      {
        // First, let's check if the user has a "superuser" role
        // We make the assumption here that any role with "superuser" in the name has enough access rights to perform migration actions.
        String Q = "WITH RECURSIVE cte AS (\n"
        + "  SELECT oid FROM pg_roles WHERE rolname = (SELECT current_role)\n"
        + "  UNION ALL\n"
        + "  SELECT m.roleid\n"
        + "    FROM cte\n"
        + "       JOIN pg_auth_members m ON m.member = cte.oid\n"
        + ")\n"
        + "SELECT count(*) FROM cte WHERE oid::regrole::TEXT ILIKE '%superuser%'";
        ScalarRP SRP = new ScalarRP();
        C.executeSelect("SYSTEM", "CURRENT_SETTING", Q, SRP);
        if (SRP.getResult() > 0)
          return true;

        Q = "select current_setting('is_superuser');";
        StringRP RP = new StringRP();
        C.executeSelect("SYSTEM", "CURRENT_SETTING", Q, RP);
        return "on".equals(RP.getResult()) == true;
      }


    @Override
    public void cancel(Connection C)
    throws SQLException
      {
        C.unwrap(BaseConnection.class).cancelQuery();
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
    public String getBackendConnectionId(Connection connection)
    throws Exception
      {
        return null;
      }

    @Override
    public boolean moveTableView(Connection Con, Base base, String oldSchemaName)
    throws Exception
      {

        String Q = "ALTER " + (base._TildaType == TildaType.VIEW ? "VIEW" : "TABLE") + " " + oldSchemaName + "." + base._Name + " SET SCHEMA " + base._ParentSchema._Name + "";
        return Con.executeDDL(base._ParentSchema._Name, base.getBaseName(), Q);
      }

    @Override
    public boolean renameTableView(Connection Con, Base base, String oldName)
    throws Exception
      {
        String Q = "ALTER " + (base._TildaType == TildaType.VIEW ? "VIEW" : "TABLE") + " " + base._ParentSchema._Name + "." + oldName + " RENAME TO " + base._Name + "";
        return Con.executeDDL(base._ParentSchema._Name, base.getBaseName(), Q);
      }

    @Override
    public boolean renameTableColumn(Connection con, Column col, String oldName)
    throws Exception
      {
        String Q = "ALTER TABLE " + col._ParentObject.getShortName() + " RENAME COLUMN \"" + oldName + "\" TO \"" + col.getName() + "\"";
        return con.executeDDL(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q);
      }

    @Override
    public ZonedDateTime getCurrentTimestamp(Connection Con)
    throws Exception
      {
        ZonedDateTimeRP RP = new ZonedDateTimeRP();
        Con.executeSelect("TILDA", "CURRENT_TIMESTAMP", "select " + getCurrentTimestampStr(), RP);
        return RP.getResult();
      }

    @Override
    public LocalDate getCurrentDate(Connection Con)
    throws Exception
      {
        LocalDateRP RP = new LocalDateRP();
        Con.executeSelect("TILDA", "CURRENT_DATE", "select " + getCurrentDateStr(), RP);
        return RP.getResult();
      }

  }
