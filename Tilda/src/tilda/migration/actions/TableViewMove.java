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
import tilda.db.Connection;
import tilda.enums.TildaType;
import tilda.migration.MigrationAction;

public class TableViewMove extends MigrationAction
  {
    public TableViewMove(String srcSchemaName, String srcTableVieName, String dstSchemaName, String dstTableViewName, boolean isView)
       {
         super(srcSchemaName, srcTableVieName, false, MaintenanceLog_Data._actionRename, isView ? MaintenanceLog_Data._objectTypeView : MaintenanceLog_Data._objectTypeTable);
         _dstSchemaName = dstSchemaName;
         _dstTableViewName = dstTableViewName;
       }

    protected String _dstSchemaName;
    protected String _dstTableViewName;

    public boolean process(Connection C)
    throws Exception
      {
        return C.moveTableView(_maintenanceObjectType.equals(MaintenanceLog_Data._objectTypeView) ? TildaType.VIEW : TildaType.OBJECT, _SchemaName, _TableViewName, _dstSchemaName, _dstTableViewName);
      }

    @Override
    public String getDescription()
      {
        return "Moving "+_maintenanceObjectType+" from '"+_SchemaName+"."+_TableViewName+"' to '"+_dstSchemaName+"."+_dstTableViewName+"'.";
      }
  }
