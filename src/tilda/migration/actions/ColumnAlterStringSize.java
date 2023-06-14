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
import tilda.db.metadata.ColumnMeta;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Column;

public class ColumnAlterStringSize extends MigrationAction
  {
    public ColumnAlterStringSize(ColumnMeta ColMeta, Column Col)
      {
        super(Col._ParentObject._ParentSchema._Name, Col._ParentObject._Name, false, MaintenanceLog_Data._actionUpdate, MaintenanceLog_Data._objectTypeColumn);
        _Col = Col;
        _ColMeta = ColMeta;
      }

    protected Column _Col;
    protected ColumnMeta _ColMeta;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableAlterColumnStringSize(_ColMeta, _Col);
      }

    @Override
    public String getDescription()
      {
        return "Alter table "+_Col._ParentObject.getFullName()
              +(_Col._Size > _ColMeta._Size ? " expanding" : " shrinking")+" string column "+_Col.getName()+" size from "+_ColMeta._Size+" to "+_Col._Size;
      }
  }
