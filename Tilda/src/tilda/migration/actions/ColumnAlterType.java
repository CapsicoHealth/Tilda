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

package tilda.migration.actions;

import tilda.data.MaintenanceLog_Data;
import tilda.data.ZoneInfo_Factory;
import tilda.db.Connection;
import tilda.db.metadata.ColumnMeta;
import tilda.enums.ColumnType;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Column;

public class ColumnAlterType extends MigrationAction
  {
    public ColumnAlterType(Connection C, ColumnMeta CMeta, Column Col)
      {
        super(Col._ParentObject._ParentSchema._Name, Col._ParentObject._Name, false, MaintenanceLog_Data._actionUpdate, MaintenanceLog_Data._objectTypeColumn);
        _Col = Col;
        _CMeta = CMeta;
        StringBuilder Str = new StringBuilder();
        C.getColumnType(Str, Col.getType(), Col._Size, Col._Mode, Col.isCollection(), Col._Precision, Col._Scale);
        _ColTypeStr = Str.toString();
      }

    protected Column _Col;
    protected String _ColTypeStr;
    protected ColumnMeta _CMeta;

    public boolean process(Connection C)
    throws Exception
      {       
        return C.alterTableAlterColumnType(C, _CMeta, _Col, ZoneInfo_Factory.getEnumerationById("UTC"));
      }


    @Override
    public String getDescription()
      {
        return "Alter table "+_Col._ParentObject.getFullName()
              +" alter column "+_Col.getName()+" type from "+_CMeta._TypeSql+(_CMeta._TildaType == ColumnType.STRING &&  _CMeta._Size > 0 ? "("+_CMeta._Size+")":"")
              +" to "+_ColTypeStr;
      }
  }
