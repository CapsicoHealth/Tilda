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
import tilda.migration.DDLDependencyManager;
import tilda.migration.MigrationAction;

public class DDLDependencyPostManagement extends MigrationAction
  {
    public DDLDependencyPostManagement(DDLDependencyManager DdlDepMan)
      {
        super(DdlDepMan.getSchemaName(), DdlDepMan.getTableViewName(), true, MaintenanceLog_Data._actionUpdate, MaintenanceLog_Data._objectTypeView);
        _DdlDepMan = DdlDepMan;
      }

    protected DDLDependencyManager _DdlDepMan;

    @Override
    public boolean process(Connection C)
    throws Exception
      {
        _DdlDepMan.restoreDependencies(C);
        return true;
      }

    public String getDescription()
      {
        return "Restoring all views that were dependent on " + _DdlDepMan.getSchemaName() + "." + _DdlDepMan.getTableViewName() + ".";
      }

    @Override
    public void errorHandling(Connection C)
    throws Exception
      {
        _DdlDepMan.errorHandling(C);
      }
  }
