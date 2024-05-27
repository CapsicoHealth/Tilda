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
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.core.BaseConnection;

import tilda.db.Connection;
import tilda.db.processors.ScalarRP;
import tilda.db.processors.StringRP;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.postgres9.PostgresType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.types.Type_DatetimePrimitive;
import tilda.utils.DurationUtil.IntervalEnum;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class PostgreSQL extends CommonStoreImpl
  {
    static final Logger LOG = LogManager.getLogger(PostgreSQL.class.getName());

    @Override
    public String getName()
      {
        return "PostgreSQL";
      }


    protected static final String[] _NODATA_SQL_STATES = { "23505"
    };

    @Override
    public String[] getConnectionNoDataStates()
      {
        return _NODATA_SQL_STATES;
      }

    protected static final String[] _LOCK_CONN_ERROR_SUBSTR = { "deadlocked on lock", "lock request time out", "lock inconsistency found", "connection reset", "connection is closed"
    };

    @Override
    public String[] getConnectionLockMsgs()
      {
        return _LOCK_CONN_ERROR_SUBSTR;
      }

    /**
     * Postgres Cancellation codes, from <A href="https://www.postgresql.org/docs/11/errcodes-appendix.html">https://www.postgresql.org/docs/11/errcodes-appendix.html</A>
     * <P>
     * <UL>
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
        return _CANCEL_SQL_STATES;
      }

    @Override
    public String getCurrentTimestampStr()
      {
        return "statement_timestamp()";
      }
    
    @Override
    public String getCurrentDateTimeStr()
      {
        return "(statement_timestamp() at time zone 'utc')::timestamp";
      }
    

    @Override
    public String getCurrentDateStr()
      {
        return "current_date";
      }

    @Override
    public char getColumnQuotingStartChar()
      {
        return '"';
      }

    @Override
    public char getColumnQuotingEndChar()
      {
        return '"';
      }

    @Override
    public boolean supportsPrimaryKeys()
      {
        return true;
      }

    @Override
    public boolean supportsForeignKeys()
      {
        return true;
      }

    @Override
    public boolean supportsIndices()
      {
        return true;
      }

    @Override
    public boolean supportsSuperMetaDataQueries()
      {
        return true;
      }

    @Override
    public boolean needsSavepoint()
      {
        return true;
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
        return true;
      }

    @Override
    public boolean supportsFirstLastAggregates()
      {
        return true;
      }

    @Override
    public boolean supportsArrays()
      {
        return true;
      }


    @Override
    public String getSelectLimitClause(int Start, int Size)
      {
        if (Start <= 0 && Size <= 0)
          return "";

        StringBuilder Str = new StringBuilder();
        if (Size <= 0)
          Str.append(" LIMIT ALL");
        else
          Str.append(" LIMIT ").append(Size);
        if (Start > 0)
          Str.append(" OFFSET " + Start);

        return Str.toString();
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
            case STRING:
              return "string_agg";
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

    protected static tilda.generation.postgres9.Sql _SQL = new tilda.generation.postgres9.Sql();

    @Override
    public CodeGenSql getSQlCodeGen()
      {
        return _SQL;
      }

    @Override
    public DBStringType getDBStringType(int Size)
      {
        return Size <= 8 ? DBStringType.CHARACTER
        : Size <= 4090 ? DBStringType.VARCHAR
        : DBStringType.TEXT;
      }

    public String getColumnType(ColumnType T, Integer S, ColumnMode M, boolean Collection, Integer Precision, Integer Scale)
      {
        if (T == ColumnType.STRING && M != ColumnMode.CALCULATED)
          {
            DBStringType ST = S == null ? null : getDBStringType(S);
            return Collection == true ? "text[]"
            : ST == DBStringType.CHARACTER ? PostgresType.CHAR._SQLType + "(" + S + ")"
            : ST == DBStringType.VARCHAR ? PostgresType.STRING._SQLType + "(" + S + ")"
            : "text";
          }

        return PostgresType.get(T)._SQLType
        + (T == ColumnType.NUMERIC && Precision != null ? "(" + Precision + (Scale != null ? "," + Scale : "") + ")" : "")
        + (T != ColumnType.JSON && Collection == true ? "[]" : "");
      }

    // LDH-NOTE: What is the difference between getColumnType and getColumnTypeRaw????

    @Override
    public String getColumnTypeRaw(ColumnType Type, int Size, boolean Calculated, boolean isCollection, boolean MultiOverride)
      {
        if (Type == ColumnType.STRING && Calculated == false)
          {
            DBStringType DBT = getDBStringType(Size);
            return isCollection == true || MultiOverride == true ? "text"
            : DBT == DBStringType.CHARACTER ? PostgresType.CHAR._SQLType
            : DBT == DBStringType.VARCHAR ? PostgresType.STRING._SQLType
            : "text";
          }
        if (Type == ColumnType.JSON)
          return "jsonb";
        return isCollection == true ? PostgresType.get(Type)._SQLArrayType : PostgresType.get(Type)._SQLType;
      }


    @Override
    public String getHelperFunctionsScript(Connection Con, boolean Start)
    throws Exception
      {
        return FileUtil.getFileOfResourceContents("tilda/db/stores/PostgreSQL.helpers-" + (Start == true ? "start" : "end") + ".sql");
      }


    public void reCreateRole(StringBuilder Str, String Role)
    throws Exception
      {
        Role = Role.toLowerCase();
        Str.append("DO $body$\n");
        Str.append("BEGIN\n");
        Str.append("   IF NOT EXISTS (SELECT FROM pg_catalog.pg_roles WHERE rolname = " + TextUtil.escapeSingleQuoteForSQL(Role) + ")\n");
        Str.append("   THEN\n");
        Str.append("      CREATE ROLE " + Role + ";\n");
        Str.append("   END IF;\n");
        Str.append("END $body$;\n");
        // Str.append("DELETE FROM pg_catalog.pg_authid WHERE rolname='"+Role+"';\n");
        // Str.append("CREATE ROLE "+Role+";\n");
      }

    @Override
    public String getAclRolesScript(Connection Con, List<Schema> TildaList)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        reCreateRole(Str, "tilda_app");
        reCreateRole(Str, "tilda_read_only");
        reCreateRole(Str, "tilda_reporting");

        for (Schema S : TildaList)
          {
            Str.append("GRANT ALL ON SCHEMA ").append(S.getShortName()).append(" TO tilda_app;\n");
            Str.append("GRANT ALL ON ALL TABLES IN SCHEMA ").append(S.getShortName()).append(" TO tilda_app;\n");
            Str.append("GRANT ALL ON ALL FUNCTIONS IN SCHEMA ").append(S.getShortName()).append(" TO tilda_app;\n");
            Str.append("GRANT ALL ON ALL SEQUENCES IN SCHEMA ").append(S.getShortName()).append(" TO tilda_app;\n");
            Str.append("GRANT USAGE ON SCHEMA ").append(S.getShortName()).append(" TO tilda_read_only;\n");
            Str.append("GRANT SELECT ON ALL TABLES IN SCHEMA ").append(S.getShortName()).append(" TO tilda_read_only;\n");
            Str.append("GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA ").append(S.getShortName()).append(" TO tilda_read_only;\n");
            Str.append("GRANT SELECT ON ALL SEQUENCES IN SCHEMA ").append(S.getShortName()).append(" TO tilda_read_only;\n");
          }

        return Str.toString();
      }


    @Override
    protected ColumnType getSubTypeMapping(String Name, String TypeName, ColumnType TildaType)
    throws Exception
      {
        if (TypeName.startsWith("_") == true)
          TypeName = TypeName.substring(1);
        /*@formatter:off*/
        switch (TypeName)
          {
            case "int2"          : TildaType = ColumnType.SHORT         ; break;
            case "int4"          : TildaType = ColumnType.INTEGER       ; break;
            case "int8"          : TildaType = ColumnType.LONG          ; break;
            case "float4"        : TildaType = ColumnType.FLOAT         ; break;
            case "float8"        : TildaType = ColumnType.DOUBLE        ; break;
            case "numeric"       : TildaType = ColumnType.NUMERIC       ; break;
            case "uuid"          : TildaType = ColumnType.UUID          ; break;
            case "bpchar"        : TildaType = ColumnType.CHAR          ; break;
            case "text"          :
            case "varchar"       :
            case "character_data": TildaType = ColumnType.STRING        ; break;
            case "bool"          : TildaType = ColumnType.BOOLEAN       ; break;
            case "date"          : TildaType = ColumnType.DATE          ; break;
            case "timestamptz"   : TildaType = ColumnType.DATETIME      ; break;
            case "timestamp"     : TildaType = ColumnType.DATETIME_PLAIN; break;
            default: TildaType = null;
                     LOG.warn("Cannot map SQL TypeName " + TypeName + " for array column '" + Name + "'. Set to UNMAPPED column type.");
          }
        /*@formatter:on*/
        return TildaType;
      }

    @Override
    public String getJsonParametrizedQueryPlaceHolder()
      {
        return "cast(? as jsonb)";
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
    public boolean alterTableAlterColumnComment(Connection Con, Column Col)
    throws Exception
      {
        String Q = "COMMENT ON COLUMN " + Col._ParentObject.getShortName() + ".\"" + Col.getName() + "\" IS " + TextUtil.escapeSingleQuoteForSQL(Col._Description) + ";";
        return Con.executeDDL(Col._ParentObject._ParentSchema._Name, Col._ParentObject.getBaseName(), Q);
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
    public boolean supportsReorg()
      {
        return true;
      }

    @Override
    public boolean reorgTable(Connection con, String schemaName, String tableName, String clusterIndexName, boolean verbose, boolean full)
    throws Exception
      {
        String Q = TextUtil.isNullOrEmpty(clusterIndexName) == true
        ? "VACUUM " + (full ? " FULL" : "") + (verbose ? " VERBOSE" : "") + " ANALYZE " + schemaName + ".\"" + tableName + "\";"
        : "CLUSTER" + (verbose ? " VERBOSE" : "") + " " + schemaName + ".\"" + tableName + "\" USING " + clusterIndexName + ";";
        return con.executeDDL(schemaName, tableName, Q);
      }

    @Override
    public boolean isCaseSentitiveSchemaTableViewNames()
      {
        return false;
      }

  }
