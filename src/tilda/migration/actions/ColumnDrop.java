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
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Object;

public class ColumnDrop extends MigrationAction
  {
    public ColumnDrop(Object Obj, String ColumnName)
      {
        super(Obj._ParentSchema._Name, Obj._Name, false, null);
        _Obj = Obj;
        _ColumnName = ColumnName;
      }

    protected Object _Obj;
    protected String _ColumnName;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableDropColumn(_Obj, _ColumnName);
      }

    @Override
    public String getDescription()
      {
        return "Alter table "+_Obj.getFullName()+" drop column "+_ColumnName;
      }
  }
