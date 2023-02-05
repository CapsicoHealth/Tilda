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

public class TableComment extends MigrationAction
  {
    public TableComment(tilda.parsing.parts.Object Obj)
      {
        super(Obj._ParentSchema._Name, Obj._Name, false, MaintenanceLog_Data._actionComment, MaintenanceLog_Data._objectTypeTable);
        _Obj = Obj;
      }

    protected tilda.parsing.parts.Object _Obj;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableComment(_Obj);
      }

    @Override
    public String getDescription()
      {
        return "Set table "+_Obj.getFullName()+"'s comment";
      }
  }
