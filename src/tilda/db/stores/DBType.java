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
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

import tilda.data.ZoneInfo_Data;
import tilda.db.Connection;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.FKMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.PKMeta;
import tilda.db.metadata.ViewMeta;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.types.ColumnDefinition;
import tilda.types.Type_DatetimePrimitive;
import tilda.utils.DurationUtil.IntervalEnum;
import tilda.utils.pairs.ColMetaColPair;
import tilda.utils.pairs.StringStringPair;

public interface DBType
  {
    public String   getName();
//    public boolean isErrNoData(SQLException t);
//    public boolean isLockOrConnectionError(SQLException t);
//    public boolean isCanceledError(SQLException t);
    public boolean  needsSavepoint();
    public boolean  supportsArrays();
    public boolean  supportsSelectLimit();
    public boolean  supportsSelectOffset();
    public boolean  supportsFilterClause();
    public boolean  supportsFirstLastAggregates();
    public boolean  supportsPrimaryKeys();
    public boolean  supportsForeignKeys();
    public boolean  supportsIndices();
    public boolean  supportsSuperMetaDataQueries();
    public String   getSelectLimitClause(int Start, int Size);
    public int      getMaxColumnNameSize();
    public int      getMaxTableNameSize();
    public char     getColumnQuotingStartChar();
    public char     getColumnQuotingEndChar();
    public String[] getConnectionNoDataStates();
    public String[] getConnectionLockMsgs();
    public String[] getConnectionCancelStates();
    /**
     * @return The string denoting the current timestamp with timezone statement, e.g., "statement_timestamp()" for Postgres, or "CURRENT_TIMESTAMP" for bigquery.
     */
    public String   getCurrentTimestampStr();
    /**
     * @return The string denoting the current timestamp without timezone statement, "statement_timestamp()::timestamp" for Postgres, or "CURRENT_DATETIME" for bigquery.
     */
    public String   getCurrentDateTimeStr();
    public String   getCurrentDateStr();
    public boolean  isCaseSentitiveSchemaTableViewNames();
    
    public CodeGenSql getSQlCodeGen();

    public boolean createSchema                    (Connection Con, Schema S) throws Exception;
    public boolean createTable                     (Connection Con, Object Obj) throws Exception;
    public boolean alterTableComment               (Connection Con, Object Obj) throws Exception;
    public boolean createKeysEntry                 (Connection Con, Object Obj) throws Exception;
    public boolean dropView                        (Connection Con, View V) throws Exception;
    public boolean dropView                        (Connection con, ViewMeta v, boolean cascade) throws Exception;
    public boolean createView                      (Connection Con, View V) throws Exception;
    public boolean alterTableAddColumn             (Connection Con, Column Col, String DefaultValue, String temporaryDefaultValue) throws Exception;
    public boolean alterTableAlterColumnDefault    (Connection Con, Column Col) throws Exception;
    public boolean alterTableAlterColumnNumericSize(Connection connection, ColumnMeta colMeta, Column col) throws Exception;
    public boolean alterTableDropColumn            (Connection Con, Object Obj, String ColumnName) throws Exception;   
    public boolean alterTableAlterColumnNull       (Connection Con, Column Col, String DefaultValue) throws Exception;
    public boolean alterTableAlterColumnComment    (Connection Con, Column Col) throws Exception;
    public boolean alterTableAlterColumnType       (Connection Con, ColumnMeta ColMeta, Column Col, ZoneInfo_Data defaultZI) throws Exception;
    public boolean alterTableAlterColumnMulti      (Connection Con, List<ColMetaColPair> BatchTypeCols, List<ColMetaColPair> BatchSizeCols, ZoneInfo_Data defaultZI)  throws Exception;
    public boolean alterTableAlterColumnStringSize (Connection Con, ColumnMeta ColMeta, Column Col) throws Exception;
    public boolean alterTableReplaceTablePK        (Connection Con, Object Obj, PKMeta oldPK) throws Exception;
    public boolean alterTableDropFK                (Connection Con, Object Obj, FKMeta FK) throws Exception;
    public boolean alterTableAddFK                 (Connection Con, ForeignKey FK) throws Exception;
    public boolean alterTableDropIndex             (Connection Con, Object Obj, IndexMeta IX) throws Exception;
    public String  alterTableAddIndexDDL           (Index IX) throws Exception;
    public boolean alterTableAddIndex              (Connection Con, Index IX) throws Exception;
    public boolean alterTableIndexDropCluster      (Connection Con, IndexMeta IX) throws Exception;
    public boolean alterTableIndexAddCluster       (Connection Con, Index IX) throws Exception;
    public boolean alterTableRenameIndex           (Connection Con, Object Obj, String OldName, String NewName) throws Exception;
    public String  getHelperFunctionsScript        (Connection Con, boolean start) throws Exception;    
    public String  getAclRolesScript               (Connection Con, List<Schema> TildaList) throws Exception;
    public boolean isSuperUser                     (Connection Con) throws Exception;


    public void   truncateTable(Connection C, String schemaName, String tableName, boolean cascade) throws Exception;

//    public static DBType DB2       = new IBMDB2    ();
    public static DBType SQLServer = new MSSQL     ();
    public static DBType Postgres  = new PostgreSQL();
    public static DBType BigQuery  = new BigQuery  ();
    
    public static DBType[] _DBTypes = { Postgres, BigQuery, SQLServer/*, DB2*/ };

    public boolean fullIdentifierOnUpdate();
    public String getAggregateStr(AggregateType AT);

    public DBStringType getDBStringType(int Size);

    public StringStringPair getTypeMapping(int type, String name, int size, String typeName) throws Exception;
    
    public String           getFullTableVar (Object O);
    public String           getFullTableVar(Object O, int i);
    public void             getFullTableVar (StringBuilder Str, String SchemaName, String TableName);
    public String           getShortColumnVar(String name);
    public String           getShortColumnVar(Column C);
    public String           rewriteExpressionColumnQuoting(String expr);
    public String           getFullColumnVar(Column C);
    public String           getFullColumnVar(Column C, int i);
    public void             getFullColumnVar(StringBuilder Str, String SchemaName, String TableName, String ColumnName);
    public String           getColumnType(Column C);
    public String           getColumnType(Column C, ColumnType AggregateType);
    public void             getColumnType   (StringBuilder Str, ColumnType T, Integer S, ColumnMode M, boolean Collection, Integer Precision, Integer Scale);
    public String           getColumnTypeRaw(Column C, boolean MultiOverride);
    public String           getColumnTypeRaw(ColumnType Type, int Size, boolean isArray);
    public void             setArray(Connection Con, PreparedStatement PS, int i, ColumnType Type, List<Array> allocatedArrays, Collection<?> val) throws Exception;
    public String           getJsonParametrizedQueryPlaceHolder();
    public void             setOrderByWithNullsOrdering(Connection Con, StringBuilder Str, ColumnDefinition Col, boolean Asc, boolean NullsLast);
    public void             age(Connection Con, StringBuilder Str, Type_DatetimePrimitive ColStart, Type_DatetimePrimitive ColEnd, IntervalEnum Type, int Count, String Operator);
    public void             within(Connection Con, StringBuilder Str, Type_DatetimePrimitive Col, Type_DatetimePrimitive ColStart, long DurationCount, IntervalEnum DurationType);
    public String getBackendConnectionId(Connection con) throws Exception;
    void cancel(Connection con) throws SQLException;
    public boolean moveTableView(Connection con, Base base, String oldSchemaName) throws Exception;
    public boolean renameTableView(Connection con, Base base, String oldName) throws Exception;
    public boolean renameTableColumn(Connection con, Column col, String oldName) throws Exception;
    public ZonedDateTime getCurrentTimestamp(Connection con) throws Exception;
    public ZonedDateTime getCurrentDateTime(Connection con) throws Exception;
    public LocalDate getCurrentDate(Connection con) throws Exception;
    public boolean supportsReorg();
    public boolean reorgTable(Connection con, String schemaName, String tableName, String clusterIndexName, boolean verbose, boolean full) throws Exception;
  }
