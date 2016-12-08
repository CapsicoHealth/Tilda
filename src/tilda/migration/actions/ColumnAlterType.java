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

import tilda.data.ZoneInfo_Factory;
import tilda.db.Connection;
import tilda.enums.ColumnType;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Column;

public class ColumnAlterType extends MigrationAction
  {
    public ColumnAlterType(Column Col, ColumnType CurrentType)
      {
        super(false);
        _Col = Col;
        _CurrentType = CurrentType;
      }

    protected Column _Col;
    protected ColumnType _CurrentType;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableAlterColumnType(_CurrentType, _Col, ZoneInfo_Factory.getEnumerationById("UTC"));
      }

    @Override
    public String getDescription()
      {
        return "Alter table "+_Col._ParentObject.getFullName()
              +" alter column "+_Col.getName()+" type from "+_CurrentType.toString()+" to "+_Col.getType().toString();
      }
  }
