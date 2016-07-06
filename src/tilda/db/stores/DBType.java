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
import tilda.utils.pairs.StringStringPair;

public interface DBType
  {
    public String  getName();
    public boolean isErrNoData(String SQLState, int ErrorCode);
    public String  getCurrentTimestampStr();
    public boolean isLockOrConnectionError(SQLException t);
    public boolean needsSavepoint();
    public boolean supportsArrays();
    public boolean supportsSelectLimit();
    public boolean supportsSelectOffset();
    public String  getSelectLimitClause(int Start, int Size);
    
    public CodeGenSql getSQlCodeGen();    
    public boolean createSchema(Connection Con, Schema S) throws Exception;
    public boolean createTable(Connection Con, Object Obj) throws Exception;
    public boolean createView(Connection Con, View V, boolean Drop) throws Exception;
    public boolean alterTableAddColumn(Connection Con, Column Col, String DefaultValue) throws Exception;
    public boolean alterTableDropColumn(Connection Con, Object Obj, ColInfo CI) throws Exception;
    public boolean alterTableAlterColumnNull(Connection Con, Column Col, String DefaultValue) throws Exception;
    public boolean addHelperFunctions(Connection Con) throws Exception;    


    public static DBType DB2       = new IBMDB2    ();
    public static DBType SQLServer = new MSSQL     ();
    public static DBType Postgres  = new PostgreSQL();
    
    public static DBType[] _DBTypes = { Postgres, SQLServer, DB2 };

    public boolean FullIdentifierOnUpdate();
    public String getAggregateStr(AggregateType AT);

    public int getCLOBThreshhold();
    public boolean alterTableAlterColumnStringSize(Connection Con, Column Col, int DBSize) throws Exception;

    public boolean alterTableAlterColumnType(Connection Con, ColumnType fromType, Column Col, ZoneInfo_Data defaultZI) throws Exception;
    public StringStringPair getTypeMapping(int type, String name, int size, String typeName) throws Exception;
    public void getFullColumnVar(StringBuilder Str, String SchemaName, String TableName, String ColumnName);
    public void getFullTableVar(StringBuilder Str, String SchemaName, String TableName);
    public void          setArray(Connection C, PreparedStatement PS, int i, ColumnType Type, List<Array> allocatedArrays, Collection<?> val) throws Exception;
    public Collection<?> getArray(              ResultSet         RS, int i, ColumnType Type, boolean isSet) throws Exception;
    public void          setJson (              PreparedStatement PS, int i, String jsonValue) throws Exception;
    public String        getJson (              ResultSet         RS, int i) throws Exception;
    public String        getJsonParametrizedQueryPlaceHolder();
    public void          setOrderByWithNullsOrdering(Connection C, StringBuilder Str, ColumnDefinition Col, boolean Asc, boolean NullsLast);
    public void truncateTable(Connection C, String schemaName, String tableName) throws Exception;
  }
