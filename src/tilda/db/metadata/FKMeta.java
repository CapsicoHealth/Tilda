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
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FKMeta
  {
    static final Logger LOG = LogManager.getLogger(FKMeta.class.getName());

    protected FKMeta(ResultSet RS, boolean Outgoing, TableMeta parentTable)
      throws Exception
      {
        // LOG.debug(JDBCHelper.PrintResultSet(RS));
        _Name = RS.getString("FK_NAME");
        _OtherSchema = RS.getString(Outgoing == true ? "PKTABLE_SCHEM" : "FKTABLE_SCHEM").toLowerCase();
        _OtherTable = RS.getString(Outgoing == true ? "PKTABLE_NAME" : "FKTABLE_NAME").toLowerCase();
        _Outgoing = Outgoing;
        _ParentTable = parentTable;
      }

    public final String             _Name;
    public final String             _OtherSchema;
    public final String             _OtherTable;
    public final boolean            _Outgoing;
    public final TableMeta          _ParentTable;

    public final List<FKColumnMeta> _Columns = new ArrayList<FKColumnMeta>();

    public String getCleanName()
      {
        String cleanName = _Name;
        if (cleanName.toLowerCase().startsWith(_ParentTable._TableName.toLowerCase()) == true)
          cleanName = cleanName.substring(_ParentTable._TableName.length());
        if (cleanName.startsWith("_") == true)
          cleanName = cleanName.substring(1);
        if (cleanName.toLowerCase().endsWith("_fkey") == true)
          cleanName = cleanName.substring(0, cleanName.length()-"_fkey".length());
        
        return cleanName;
      }

    public void addColumn(ResultSet RS)
    throws Exception
      {
        FKColumnMeta CM = new FKColumnMeta(RS, this);
        boolean Found = false;
        for (FKColumnMeta FKCM : _Columns)
          if (FKCM._Pos == CM._Pos)
            {
              Found = true;
              break;
            }
        if (Found == false)
          _Columns.add(CM._Pos - 1, CM);
      }

    public String getColumnList()
      {
        StringBuilder Str = new StringBuilder();
        for (FKColumnMeta FKCM : _Columns)
          {
            if (Str.length() != 0)
              Str.append(", ");
            Str.append(FKCM._FKCol);
          }
        return Str.toString();
      }

    public String toString()
      {
        StringBuilder Str = new StringBuilder();
        for (FKColumnMeta FKCM : _Columns)
          {
            if (Str.length() != 0)
              Str.append(", ");
            Str.append("(").append(FKCM.toString()).append(")");
          }
        return "Name: " + _Name + "; " + (_Outgoing == true ? "To" : "From") + ": " + _OtherSchema + "." + _OtherTable + "; Columns: [" + Str.toString() + "];";
      }

    public String getSignature()
      {
        return _OtherSchema.toUpperCase() + "." + _OtherTable.toUpperCase() + "(" + getColumnList() + ")";
      }
  }
