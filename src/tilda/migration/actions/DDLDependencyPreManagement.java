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

import tilda.db.Connection;
import tilda.migration.DDLDependencyManager;
import tilda.migration.MigrationAction;

public class DDLDependencyPreManagement extends MigrationAction
  {
    public DDLDependencyPreManagement(DDLDependencyManager DdlDepMan)
      {
        super(DdlDepMan.getSchemaName(), DdlDepMan.getTableViewName(), true);
        _DdlDepMan = DdlDepMan;
      }

    protected DDLDependencyManager _DdlDepMan;

    @Override
    public boolean process(Connection C)
    throws Exception
      {
        if (_DdlDepMan.fetchDependencies(C) == false)
         return false;
        _DdlDepMan.dropDependencies(C);
        return true;
      }

    public String getDescription()
      {
        return "Dropping all views dependent on " + _DdlDepMan.getSchemaName() + "." + _DdlDepMan.getTableViewName()+" (to be re-created after all changes have been applied).";
      }
  }
