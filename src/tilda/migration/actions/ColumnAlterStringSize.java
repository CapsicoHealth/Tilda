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
import tilda.parsing.parts.Column;

public class ColumnAlterStringSize extends MigrationAction
  {
    public ColumnAlterStringSize(Column Col, int CurrentSize)
      {
        super(false);
        _Col = Col;
        _CurrentSize = CurrentSize;
      }

    protected Column _Col;
    protected int _CurrentSize;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableAlterColumnStringSize(_Col, _CurrentSize);
      }

    @Override
    public String getDescription()
      {
        return "Alter table "+_Col._ParentObject.getFullName()
              +(_Col._Size > _CurrentSize ? " expanding" : " shrinking")+" string column "+_Col.getName()+" size from "+_CurrentSize+" to "+_Col._Size;
      }
  }
