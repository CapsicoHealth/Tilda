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

import tilda.db.Connection;
import tilda.enums.ColumnType;
import tilda.parsing.parts.Convention;
import tilda.utils.pairs.StringStringPair;

public class ColumnMeta
  {
    protected ColumnMeta(Connection C, ResultSet RS)
      throws Exception
      {
        // System.out.println(JDBCHelper.printResultSet(RS));
        _SrcSchema = RS.getString("TABLE_SCHEM");
        _SrcTable = RS.getString("TABLE_NAME");
        _NameOriginal = RS.getString("COLUMN_NAME");
        _Name = _NameOriginal.toLowerCase();
        _Nullable = RS.getInt("NULLABLE");
        _Size = RS.getInt("COLUMN_SIZE");
        // if(_Name.equals("a11"))
        // System.out.println(JDBCHelper.printResultSet(RS));
        _Precision = RS.getInt("COLUMN_SIZE");
        _Scale = RS.getInt("DECIMAL_DIGITS");
        _TypeName = RS.getString("TYPE_NAME");
        _Type = RS.getInt("DATA_TYPE");
        _Descr = RS.getString("REMARKS");
        _Default = RS.getString("COLUMN_DEF");
        StringStringPair SSP = C.getTypeMapping(_Type, _Name, _Size, _TypeName);
        _TypeSql = SSP._N;
        _TildaType = ColumnType.parse(SSP._V);
        // _ParentTable = T;
        // _ParentView = V;
      }

    public final String     _SrcSchema;
    public final String     _SrcTable;
    public String           _Name;
    public final String     _NameOriginal;
    public final int        _Nullable;
    public final int        _Size;
    public final int        _Precision;
    public final int        _Scale;
    public final int        _Type;
    public final ColumnType _TildaType;
    public final String     _TypeSql;
    public final String     _TypeName;
    public final String     _Descr;
    public final String     _Default;
    protected TableMeta     _ParentTable;
    protected ViewMeta      _ParentView;

    public void attachToTable(TableMeta parentTable)
      {
        _ParentTable = parentTable;
      }

    public void attachToView(ViewMeta parentView)
      {
        _ParentView = parentView;
      }

    public boolean isArray()
      {
        return _Type == java.sql.Types.ARRAY;
      }

    public TableMeta getParentTable()
      {
        return _ParentTable;
      }

    public ViewMeta getParentView()
      {
        return _ParentView;
      }

    public String toString()
      {
        return "Name: " + _Name + "; Nullable: " + _Nullable + "; Size: " + _Size + "; Type: " + _Type + "/" + _TypeSql + "; TypeName: " + _TypeName + "; Default: " + _Default + "; Descr: " + _Descr + ";";
      }

    public FKColumnMeta getFKMeta()
      {
        if (_ParentTable == null || _ParentTable._ForeignKeysOut.isEmpty() == true)
          return null;

        for (FKMeta FK : _ParentTable._ForeignKeysOut.values())
          for (FKColumnMeta FKCol : FK._Columns)
            if (FKCol._FKCol.equalsIgnoreCase(_Name) == true)
              return FKCol;

        return null;
      }

    public ColumnMeta getTZCol()
      {
        return _ParentTable!=null?_ParentTable.getColumnMeta(_NameOriginal+Convention.getDefaultTzColPostfix(), false) : null;
      }
  }
