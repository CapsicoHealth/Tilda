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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IndexColumnMeta
  {
    static final Logger LOG = LogManager.getLogger(IndexColumnMeta.class.getName());

    protected IndexColumnMeta(ResultSet RS)
    throws Exception
      {
        _Pos = RS.getInt("ORDINAL_POSITION");
        _Col = RS.getString("COLUMN_NAME");
        _AscStr = RS.getString("ASC_OR_DESC");
        _Asc = _AscStr == null ? null : _AscStr.equalsIgnoreCase("A") == true ? true : _AscStr.equalsIgnoreCase("D") ? false : null;
      }

    public final int        _Pos;
    public final String     _Col;
    public final String     _AscStr;
    public final Boolean    _Asc;

    public String toString()
      {
        return "Pos: "+_Pos+"; Col: "+_Col+"; Asc: "+_Asc+";";
      }
  }
