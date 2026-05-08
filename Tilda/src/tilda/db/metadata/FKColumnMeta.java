/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

package tilda.db.metadata;

import java.sql.ResultSet;

public class FKColumnMeta
  {
    protected FKColumnMeta(ResultSet RS, FKMeta FK)
    throws Exception
      {
        _Pos = RS.getInt("KEY_SEQ");
        _PKCol = RS.getString("PKCOLUMN_NAME");
        _FKCol = RS.getString("FKCOLUMN_NAME");
        _ParentFK=FK; 
      }

    public final int        _Pos;
    public final String     _PKCol;
    public final String     _FKCol;
    public final FKMeta     _ParentFK;

    public String toString()
      {
        return "Pos: "+_Pos+"; PKCol: "+_PKCol+"; FKCol: "+_FKCol+";";
      }
  }
