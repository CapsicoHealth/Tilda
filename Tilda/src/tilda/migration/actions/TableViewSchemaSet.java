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
import tilda.migration.MigrationAction;

public class TableViewSchemaSet extends MigrationAction
  {
    public TableViewSchemaSet(tilda.parsing.parts.Base Base, String OldSchemaName)
      {
        super(Base._ParentSchema._Name, Base._Name, false, MaintenanceLog_Data._actionRename, MaintenanceLog_Data._objectTypeView);
        _Base = Base;
        _OldSchemaName = OldSchemaName;
      }

    protected tilda.parsing.parts.Base _Base;
    protected String _OldSchemaName;

    public boolean process(Connection C)
    throws Exception
      {
        return C.moveTableView(_Base, _OldSchemaName);
      }

    @Override
    public String getDescription()
      {
        return "Moving "+_Base._TildaType.name()+" '"+_Base._Name+"' from schema '"+_OldSchemaName+"' to '"+_Base._ParentSchema._Name+"'.";
      }
  }
