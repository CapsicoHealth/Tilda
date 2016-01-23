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

import tilda.data.ZoneInfo_Data;
import tilda.db.Connection;
import tilda.enums.AggregateType;
import tilda.enums.ColumnType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;

public interface DBType
  {
    public String  getName();
    public boolean isErrNoData(String SQLState, int ErrorCode);
    public String  getCurrentTimestampStr();
    public boolean isLockOrConnectionError(SQLException t);
    public boolean needsSavepoint();
    public boolean supportsSelectLimit();
    public boolean supportsSelectOffset();
    public String  getSelectLimitClause(int Start, int Size);
    
    public CodeGenSql getSQlCodeGen();    
    public boolean createSchema(Connection Con, Schema S) throws Exception;
    public boolean createTable(Connection Con, Object Obj) throws Exception;
    public boolean createView(Connection Con, View V, boolean Drop) throws Exception;
    public boolean alterTableAddColumn(Connection Con, Column Col, String DefaultValue) throws Exception;
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
  }
