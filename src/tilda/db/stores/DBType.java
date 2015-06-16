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

import tilda.db.Connection;
import tilda.parsing.parts.Column;

public interface DBType
  {
    public String  getName();
    public boolean isErrNoData(String SQLState, int ErrorCode);
    public String  getCurrentTimestampStr();
    public boolean isLockOrConnectionError(SQLException t);
    public boolean needsSavepoint();
    public boolean supportsSelectSubsetting();
    public boolean getSelectSubsettingClause(StringBuilder Str, int Start, int Size);
    public boolean alterTableAddColumn(Connection Con, Column Col) throws Exception;

    public static DBType DB2       = new IBMDB2    ();
    public static DBType SQLServer = new MSSQL     ();
    public static DBType Postgres  = new PostgreSQL();
    
    public static DBType[] _DBTypes = { Postgres, SQLServer, DB2 };

    public boolean FullIdentifierOnUpdate();
  }
