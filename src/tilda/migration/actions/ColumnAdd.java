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
import tilda.parsing.parts.Column;

public class ColumnAdd extends MigrationAction
  {
    public ColumnAdd(Column col, String temporaryDefaultValue)
      {
        super(col._ParentObject._ParentSchema._Name, col._ParentObject._Name, false, MaintenanceLog_Data._actionCreate, MaintenanceLog_Data._objectTypeColumn);
        _col = col;
        _temporaryDefaultValue = temporaryDefaultValue;
      }

    protected Column _col;
    protected String _temporaryDefaultValue;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableAddColumn(_col, _col._DefaultCreateValue == null ? null : _col._DefaultCreateValue._Value, _temporaryDefaultValue);
      }
    

    @Override
    public String getDescription()
      {
        return "Alter table "+_col._ParentObject.getFullName()+" add column "+_col.getName()
        +(_col._Nullable == false ? " SET NOT NULL" : "")
        +(_col._DefaultCreateValue == null ? "" : " with default '"+_col._DefaultCreateValue._Value+"'")
        ;
      }
  }
