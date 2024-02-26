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

public class ColumnAlterNull extends MigrationAction
  {
    public ColumnAlterNull(Column Col)
      {
        super(Col._ParentObject._ParentSchema._Name, Col._ParentObject._Name, false, MaintenanceLog_Data._actionUpdate, MaintenanceLog_Data._objectTypeColumn);
        _Col = Col;
      }

    protected Column _Col;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableAlterColumnNull(_Col, _Col._DefaultCreateValue == null ? null : _Col._DefaultCreateValue._Value);
      }

    @Override
    public String getDescription()
      {
        return "Alter table "+_Col._ParentObject.getFullName()
              +" alter column "+_Col.getName()
              +(_Col._Nullable==true?" null":" not null")
              +(_Col._DefaultCreateValue == null ? "" : " with default '"+_Col._DefaultCreateValue._Value+"'");
      }
  }
