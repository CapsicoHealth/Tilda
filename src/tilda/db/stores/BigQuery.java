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
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.core.BaseConnection;

import tilda.db.Connection;
import tilda.db.processors.LocalDateRP;
import tilda.db.processors.ZonedDateTimeRP;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
import tilda.enums.TildaType;
import tilda.generation.bigquery.BigQueryType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.types.Type_DatetimePrimitive;
import tilda.utils.DurationUtil.IntervalEnum;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

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
//        LOG.error(AsciiArt.printError(AsciiArt._DEFAULT_LEAD, "UNIMPLEMENTED LOGIC!!!!!"));
        return _NODATA_SQL_STATES; // "23505".equals(E.getSQLState());
      }


    protected static final String[] _LOCK_CONN_ERROR_SUBSTR = { "deadlocked on lock", "lock request time out", "lock inconsistency found", "connection reset", "connection is closed"
    };

    @Override
    public String[] getConnectionLockMsgs()
      {
//        LOG.error(AsciiArt.printError(AsciiArt._DEFAULT_LEAD, "UNIMPLEMENTED LOGIC!!!!!"));
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
//        LOG.error(AsciiArt.printError(AsciiArt._DEFAULT_LEAD, "UNIMPLEMENTED LOGIC!!!!!"));
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
    public boolean supportsFirstLastAggregates()
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
    protected ColumnType getSubTypeMapping(String Name, String TypeName, ColumnType TildaType)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public String getJsonParametrizedQueryPlaceHolder()
      {
        return "cast(? as json)";
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
    public boolean alterTableComment(Connection con, Object obj)
    throws Exception
      {
        String Q = "ALTER TABLE " + obj.getShortName() 
        + "SET OPTIONS (description="+TextUtil.escapeDoubleQuoteWithSlash(obj._Description)+");";

        return con.executeDDL(obj._ParentSchema._Name, obj.getBaseName(), Q);
      }

    @Override
    public boolean alterTableAlterColumnComment(Connection con, Column col)
    throws Exception
      {
        String Q = "ALTER TABLE " + col._ParentObject.getShortName() 
                 + "ALTER COLUMN " + getShortColumnVar(col)
                 + "SET OPTIONS (description="+TextUtil.escapeDoubleQuoteWithSlash(col._Description)+");";
        return con.executeDDL(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q);
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
        return true;
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

    @Override
    public boolean supportsSuperMetaDataQueries()
      {
        return false;
      }

    @Override
    public boolean supportsReorg()
      {
        return false;
      }

    @Override
    public boolean reorgTable(Connection con, String schemaName, String tableName, String clusterIndexName, boolean verbose, boolean full)
    throws Exception
      {
        return false;
      }
    
    @Override
    public boolean isCaseSentitiveSchemaTableViewNames()
      {
        return true;
      }

  }
