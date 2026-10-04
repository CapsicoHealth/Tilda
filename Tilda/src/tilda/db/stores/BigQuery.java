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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.core.BaseConnection;

import tilda.data.ZoneInfo_Data;
import tilda.db.Connection;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.PKMeta;
import tilda.db.metadata.TableMeta;
import tilda.db.processors.LocalDateRP;
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
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Index.Option;
import tilda.parsing.parts.Index.Option;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OrderBy;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.types.Type_DatetimePrimitive;
import tilda.utils.DurationUtil.IntervalEnum;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;
import tilda.utils.pairs.ColMetaColPair;

public class BigQuery extends CommonStoreImpl
  {
    static final Logger LOG = LogManager.getLogger(BigQuery.class.getName());

    @Override
    public String getName()
      {
        return "BigQuery";
      }

    @Override
    public boolean isColumnArrayCompatible(Column Col, ColumnMeta CMeta)
      {
        if (Col.getType() == ColumnType.VECTOR && Col.isCollection() == false)
          return CMeta.isArray();
        return super.isColumnArrayCompatible(Col, CMeta);
      }

    @Override
    public boolean isColumnTypeCompatible(Column Col, ColumnMeta CMeta)
      {
        if (Col.getType() == CMeta._TildaType)
          return true;
        String modelType = getColumnType(Col);
        int precisionStart = modelType.indexOf('(');
        if (precisionStart >= 0)
          modelType = modelType.substring(0, precisionStart);
        return modelType.equalsIgnoreCase(CMeta._TypeName);
      }

    @Override
    public boolean supportsStringSizeLimits()
      {
        return false;
      }

    @Override
    public String getCurrentTimestampStr()
      {
        return "CURRENT_TIMESTAMP()";
      }

    @Override
    public String getCurrentDateTimeStr()
      {
        return "CURRENT_DATETIME()";
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
        // LOG.error(AsciiArt.printError(AsciiArt._DEFAULT_LEAD, "UNIMPLEMENTED LOGIC!!!!!"));
        return _NODATA_SQL_STATES; // "23505".equals(E.getSQLState());
      }


    protected static final String[] _LOCK_CONN_ERROR_SUBSTR = { "deadlocked on lock", "lock request time out", "lock inconsistency found", "connection reset", "connection is closed"
    };

    @Override
    public String[] getConnectionLockMsgs()
      {
        // LOG.error(AsciiArt.printError(AsciiArt._DEFAULT_LEAD, "UNIMPLEMENTED LOGIC!!!!!"));
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
        // LOG.error(AsciiArt.printError(AsciiArt._DEFAULT_LEAD, "UNIMPLEMENTED LOGIC!!!!!"));
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
    public boolean supportsTildaCatalog()
      {
        return false;
      }

    @Override
    public Map<String, PKMeta> loadPrimaryKeyMetadata(Connection Con, String schemaName)
    throws Exception
      {
        return PKMeta.loadSchemaPrimaryKeysFromJdbc(Con, schemaName);
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
    public boolean supportsVectorIndices()
      {
        return true;
      }

    @Override
    public boolean supportsVectorIndicesInlineOnCreateTable()
      {
        return false;
      }

    @Override
    public boolean supportsVectorIndexMetadata()
      {
        return true;
      }

    @Override
    public void loadVectorIndexMetadata(Connection Con, TableMeta TMeta)
    throws Exception
      {
        String metadataView = quoteIdentifier(TMeta._SchemaName + ".INFORMATION_SCHEMA.VECTOR_INDEX_COLUMNS");
        String query = "SELECT index_name, index_column_name FROM " + metadataView
        + " WHERE table_name = " + TextUtil.escapeSingleQuoteForSQL(TMeta._TableName);
        try (Statement statement = Con.createStatement(); ResultSet rows = statement.executeQuery(query))
          {
            while (rows.next() == true)
              {
                TMeta.addVectorIndexMetadata(rows.getString("index_name"), rows.getString("index_column_name"));
              }
          }
      }

    @Override
    public DatabaseSchemaMetadata loadSchemaMetadata(Connection Con, String schemaName)
    throws Exception
      {
        String query = buildSchemaMetadataQuery(schemaName);
        DatabaseSchemaMetadata metadata = new DatabaseSchemaMetadata();
        try (Statement statement = Con.createStatement(); ResultSet rows = statement.executeQuery(query))
          {
            while (rows.next() == true)
              {
                String tableName = rows.getString("table_name").toLowerCase(Locale.ROOT);
                String metadataValue = rows.getString("metadata_value");
                if ("TABLE_DESCRIPTION".equals(rows.getString("metadata_kind")) == true)
                  metadata._TableDescriptions.put(tableName, metadataValue);
                else if (metadataValue != null)
                  {
                    Map<String, String> tableDefaults = metadata._ColumnDefaults.get(tableName);
                    if (tableDefaults == null)
                      {
                        tableDefaults = new HashMap<String, String>();
                        metadata._ColumnDefaults.put(tableName, tableDefaults);
                      }
                    tableDefaults.put(rows.getString("column_name").toLowerCase(Locale.ROOT), metadataValue);
                  }
              }
          }
        return metadata;
      }

    static String buildSchemaMetadataQuery(String schemaName)
      {
        String tableOptions = quoteIdentifier(schemaName + ".INFORMATION_SCHEMA.TABLE_OPTIONS");
        String columns = quoteIdentifier(schemaName + ".INFORMATION_SCHEMA.COLUMNS");
        return "SELECT 'TABLE_DESCRIPTION' AS metadata_kind, table_name, CAST(NULL AS STRING) AS column_name, JSON_VALUE(option_value, '$') AS metadata_value FROM "
        + tableOptions + " WHERE option_name = 'description' UNION ALL SELECT 'COLUMN_DEFAULT' AS metadata_kind, table_name, column_name, column_default AS metadata_value FROM "
        + columns + " WHERE column_default IS NOT NULL";
      }
    @Override
    public boolean hasVectorIndexDataForIndexCreation(Connection Con, Index IX)
    throws Exception
      {
        Column vectorColumn = null;
        for (Column column : IX._ColumnObjs)
          if (column != null && column.getType() == ColumnType.VECTOR)
            {
              vectorColumn = column;
              break;
            }
        if (vectorColumn == null)
          return true;

        String query = buildVectorIndexDataCheckQuery(IX._Parent.getShortName(), vectorColumn.getName());
        try (Statement statement = Con.createStatement(); ResultSet rows = statement.executeQuery(query))
          {
            return rows.next();
          }
      }

    static String buildVectorIndexDataCheckQuery(String tableName, String columnName)
      {
        String column = quoteIdentifier(columnName);
        return "SELECT 1 FROM " + quoteIdentifier(tableName) + " WHERE " + column + " IS NOT NULL AND ARRAY_LENGTH(" + column
        + ") > 0 AND NOT EXISTS (SELECT 1 FROM UNNEST(" + column + ") AS element WHERE element IS NULL) LIMIT 1";
      }

    @Override
    public boolean alterTableDropIndex(Connection Con, Object Obj, IndexMeta IX)
    throws Exception
      {
        if (IX._VectorIndex == false)
          return true;
        String query = "DROP VECTOR INDEX " + quoteIdentifier(IX._Name) + " ON " + quoteIdentifier(Obj.getShortName()) + ";";
        return Con.executeDDL(Obj._ParentSchema._Name, Obj.getBaseName(), query);
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
    public void getFullColumnVar(StringBuilder Str, String SchemaName, String TableName, String ColumnName)
      {
        if (TextUtil.isNullOrEmpty(TableName) == false)
          Str.append(TableName).append(".");
        Str.append(getColumnQuotingStartChar()).append(ColumnName).append(getColumnQuotingEndChar());
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

    @Override
    public boolean alterTableAlterColumnMulti(Connection Con, List<ColMetaColPair> BatchTypeCols, List<ColMetaColPair> BatchSizeCols, ZoneInfo_Data defaultZI)
    throws Exception
      {
        if (BatchTypeCols != null && BatchTypeCols.isEmpty() == false)
          {
            StringBuilder details = new StringBuilder("BigQuery cannot automatically alter these column types; manual migration is required:");
            for (ColMetaColPair pair : BatchTypeCols)
              {
                details.append("\n - ");
                if (pair == null || pair._Col == null || pair._CMeta == null)
                  details.append("column details unavailable");
                else
                  details.append(pair._Col._ParentObject.getFullName()).append('.').append(pair._Col.getName())
                  .append(": database type ").append(pair._CMeta._TypeName).append(" (JDBC ").append(pair._CMeta._Type)
                  .append(", mapped ").append(pair._CMeta._TildaType).append("), model type ").append(getColumnType(pair._Col));
              }
            throw new UnsupportedOperationException(details.toString());
          }
        return true;
      }

    // LDH-NOTE: What is the difference between getColumnType and getColumnTypeRaw????

    @Override
    public String getColumnType(ColumnType Type, Integer Size, String typeModifier, ColumnMode M, boolean isCollection, Integer Precision, Integer Scale)
      {
        if (M != ColumnMode.CALCULATED)
          {
            if (Type == ColumnType.STRING)
              {
                DBStringType ST = Size == null ? null : getDBStringType(Size);
                return isCollection == true ? "ARRAY<STRING>" : "STRING";
              }
            else if (Type == ColumnType.VECTOR)
              {
                return "ARRAY<FLOAT64>";
              }
          }

        return (Type != ColumnType.JSON && isCollection == true ? "ARRAY<" : "")
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
        if ("TIMESTAMP".equalsIgnoreCase(TypeName) == true)
          return ColumnType.DATETIME;
        if ("DATETIME".equalsIgnoreCase(TypeName) == true)
          return ColumnType.DATETIME_PLAIN;
        return TildaType;
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
        String Q = buildTableCommentQuery(obj.getShortName(), obj._Description);

        return con.executeDDL(obj._ParentSchema._Name, obj.getBaseName(), Q);
      }

    static String buildTableCommentQuery(String tableName, String description)
      {
        return "ALTER TABLE " + tableName + " SET OPTIONS (description=" + TextUtil.escapeDoubleQuoteWithSlash(description) + ");";
      }

    @Override
    public boolean alterTableAlterColumnComment(Connection con, Column col)
    throws Exception
      {
        String Q = "ALTER TABLE " + col._ParentObject.getShortName()
        + " ALTER COLUMN " + getShortColumnVar(col)
        + " SET OPTIONS (description=" + TextUtil.escapeDoubleQuoteWithSlash(col._Description) + ");";
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
        String Q = "ALTER TABLE " + col._ParentObject.getShortName() + " RENAME COLUMN " + getShortColumnVar(oldName) + " TO " + getShortColumnVar(col);
        return con.executeDDL(col._ParentObject._ParentSchema._Name, col._ParentObject.getBaseName(), Q);
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

    @Override
    public String alterTableAddIndexUsingDDL(Index IX)
    throws Exception
      {
        return null;
      }

    @Override
    public String alterTableAddIndexWithDDL(Index IX)
    throws Exception
      {
        return null;
      }

    @Override
    public String alterTableAddIndexDDL(Index IX)
    throws Exception
      {
        Column vectorColumn = null;
        for (Column C : IX._ColumnObjs)
          if (C != null && C.getType() == ColumnType.VECTOR)
            {
              if (vectorColumn != null || IX._ColumnObjs.size() != 1)
                throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' must contain exactly one VECTOR column for BigQuery vector-index generation.");
              vectorColumn = C;
            }

        if (vectorColumn != null)
          {
            if (IX._Db == false)
              return "-- app-level VECTOR index only -- Index '" + IX.getName() + "' on " + IX._Parent.getShortName() + "(" + vectorColumn.getName() + ")\n";
            return getVectorIndexDDL(IX, vectorColumn);
          }

        StringWriter OutStr = new StringWriter();
        PrintWriter Out = new PrintWriter(OutStr);

        if (IX._Unique == false)
          {
            Out.print("-- app-level index only -- Index '" + IX.getName() + "' on " + IX._Parent.getShortName() + "(");
            Sql.PrintColumnList(Out, IX._ColumnObjs, IX._IndexColumnModifiers);
            Out.print(")");
            if (IX._OrderByObjs.isEmpty() == false)
              {
                Out.print(" order by ");
                boolean First = IX._ColumnObjs.isEmpty();
                for (OrderBy OB : IX._OrderByObjs)
                  {
                    if (OB == null)
                      continue;

                    if (First == true)
                      First = false;
                    else
                      Out.print(", ");
                    Out.print("\"" + OB._Col.getName() + "\" " + OB._Order);
                    if (OB._Nulls != null)
                      Out.print(" NULLS " + OB._Nulls);
                  }
              }
          }
        else
          {
            Out.print("-- app-level index only -- ALTER TABLE " + IX._Parent.getShortName() + " ADD CONSTRAINT " + IX.getName() + " UNIQUE (");
            Sql.PrintColumnList(Out, IX._ColumnObjs, IX._IndexColumnModifiers);
            Out.print(") NOT ENFORCED; --  ");
          }
        if (IX._SubQuery != null)
          {
            Query Q = IX._SubQuery.getQuery(DBType.Postgres);
            Out.print(" where " + Q._ClauseStatic);
          }

        if (IX._NullsNotDistinct == true)
          Out.print(" NULLS NOT DISTINCT");

        Out.print("\n");

        if (IX._Cluster == true)
          Out.print("-- app-level index only -- ALTER TABLE " + IX._Parent.getShortName() + " CLUSTER on " + IX.getName() + ";\n");

        return OutStr.toString();
      }

    private static String getVectorIndexDDL(Index IX, Column vectorColumn)
    throws Exception
      {
        VectorIndexConfiguration details = getVectorIndexConfiguration(IX);
        Map<String, String> options = getVectorIndexOptions(IX, details);
        StringBuilder ddl = new StringBuilder("CREATE VECTOR INDEX IF NOT EXISTS ")
        .append(quoteIdentifier(IX.getName()))
        .append(" ON ").append(quoteIdentifier(IX._Parent.getShortName()))
        .append("(").append(quoteIdentifier(vectorColumn.getName())).append(") OPTIONS (index_type = '")
        .append(details._Algorithm.equals("ivf") ? "IVF" : "TREE_AH")
        .append("', distance_type = '").append(getBigQueryDistance(IX, details._Distance)).append("'");

        if ("ivf".equals(details._Algorithm) == true && options.containsKey("num_lists") == true)
          ddl.append(", ivf_options = '{\"num_lists\":").append(options.get("num_lists")).append("}'");
        else if ("tree_ah".equals(details._Algorithm) == true && options.isEmpty() == false)
          {
            ddl.append(", tree_ah_options = '{");
            boolean first = true;
            if (options.containsKey("leaf_node_embedding_count") == true)
              {
                ddl.append("\"leaf_node_embedding_count\":").append(options.get("leaf_node_embedding_count"));
                first = false;
              }
            if (options.containsKey("normalization_type") == true)
              {
                if (first == false)
                  ddl.append(", ");
                ddl.append("\"normalization_type\":\"").append(options.get("normalization_type")).append("\"");
              }
            ddl.append("}'");
          }

        return ddl.append(");\n").toString();
      }

    private static VectorIndexConfiguration getVectorIndexConfiguration(Index IX)
    throws Exception
      {
        for (Column C : IX._ColumnObjs)
          if (C != null && C.getType() == ColumnType.VECTOR && TextUtil.isNullOrEmpty(IX._IndexColumnModifiers.get(C.getName())) == false)
            throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' uses the retired vector column-modifier syntax. Move its settings into the index 'vector' object.");

        Index.Details selected = IX.getDetails(DBType.BigQuery);
        if (selected == null)
          throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' requires a vector.details entry for BigQuery.");

        VectorIndexConfiguration details = new VectorIndexConfiguration();
        details._Distance = IX._Vector == null || TextUtil.isNullOrEmpty(IX._Vector._Distance) == true ? "euclidean" : IX._Vector._Distance.toLowerCase(Locale.ROOT);
        String algorithm = IX._Vector == null ? null : IX._Vector._Algorithm;
        if (TextUtil.isNullOrEmpty(selected._Algorithm) == false)
          {
            if (TextUtil.isNullOrEmpty(algorithm) == false)
              throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' cannot specify both vector.algorithm and vector.details[].algorithm.");
            algorithm = selected._Algorithm;
          }
        details._Algorithm = TextUtil.isNullOrEmpty(algorithm) == true ? "ivf" : algorithm.toLowerCase(Locale.ROOT);
        details._Options = selected._Options;

        if ("ivf".equals(details._Algorithm) == false && "tree_ah".equals(details._Algorithm) == false)
          throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' has unsupported BigQuery vector algorithm '" + details._Algorithm + "'. Supported algorithms: ivf, tree_ah.");
        getBigQueryDistance(IX, details._Distance);
        return details;
      }

    private static Map<String, String> getVectorIndexOptions(Index IX, VectorIndexConfiguration details)
    throws Exception
      {
        Map<String, String> options = new HashMap<String, String>();
        if (details._Options != null)
          for (Option option : details._Options)
            {
              if (option == null || TextUtil.isNullOrEmpty(option._Option) == true || TextUtil.isNullOrEmpty(option._Value) == true)
                throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' has a vector option without both 'option' and 'value'.");
              String name = option._Option.toLowerCase(Locale.ROOT);
              if (options.put(name, option._Value) != null)
                throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' has duplicate BigQuery vector option '" + option._Option + "'.");
            }

        for (String name : options.keySet())
          if ("ivf".equals(details._Algorithm) == true ? "num_lists".equals(name) == false
              : "leaf_node_embedding_count".equals(name) == false && "normalization_type".equals(name) == false)
            throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' has unsupported BigQuery " + details._Algorithm + " option '" + name + "'.");

        if ("ivf".equals(details._Algorithm) == true && options.containsKey("num_lists") == true)
          options.put("num_lists", getIntegerOption(IX, "num_lists", options.get("num_lists"), 1, 5000));
        else if ("ivf".equals(details._Algorithm) == true)
          options.put("num_lists", "1000");
        if ("tree_ah".equals(details._Algorithm) == true)
          {
            if (options.containsKey("leaf_node_embedding_count") == true)
              options.put("leaf_node_embedding_count", getIntegerOption(IX, "leaf_node_embedding_count", options.get("leaf_node_embedding_count"), 500L, Long.MAX_VALUE));
            if (options.containsKey("normalization_type") == true)
              {
                String normalization = options.get("normalization_type").toUpperCase(Locale.ROOT);
                if ("NONE".equals(normalization) == false && "L2".equals(normalization) == false)
                  throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' has unsupported BigQuery normalization_type '" + options.get("normalization_type") + "'. Supported values: NONE, L2.");
                options.put("normalization_type", normalization);
              }
          }
        return options;
      }

    private static String getIntegerOption(Index IX, String name, String value, long min, long max)
    throws Exception
      {
        try
          {
            long parsed = Long.parseLong(value);
            if (parsed >= min && parsed <= max)
              return Long.toString(parsed);
          }
        catch (NumberFormatException ignored)
          {
          }
        throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' has invalid BigQuery vector option '" + name + "': '" + value + "'. Expected an integer from " + min + " through " + max + ".");
      }

    private static String getBigQueryDistance(Index IX, String distance)
    throws Exception
      {
        if ("euclidean".equalsIgnoreCase(distance) == true)
          return "EUCLIDEAN";
        if ("cosine".equalsIgnoreCase(distance) == true)
          return "COSINE";
        if ("dot".equalsIgnoreCase(distance) == true)
          return "DOT_PRODUCT";
        throw new Exception(IX._Parent.getFullName() + " index '" + IX.getName() + "' has unsupported BigQuery vector distance '" + distance + "'. Supported distances: euclidean, cosine, dot.");
      }

    private static String quoteIdentifier(String identifier)
      {
        return "`" + identifier.replace("`", "\\`") + "`";
      }

    private static class VectorIndexConfiguration
      {
        String _Distance;
        String _Algorithm;
        java.util.List<Option> _Options;
      }

  }
