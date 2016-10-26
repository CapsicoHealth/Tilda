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

public class ColumnAlterNull implements MigrationAction
  {
    public ColumnAlterNull(Column Col, boolean Nullable)
      {
        _Col = Col;
        _Nullable = Nullable;
      }

    protected Column _Col;
    protected boolean _Nullable;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableAlterColumnNull(_Col, _Col._DefaultCreateValue == null ? null : _Col._DefaultCreateValue._Value);
      }

    @Override
    public String getDescription()
      {
        return "Alter table "+_Col._ParentObject.getFullName()+" add column "+_Col.getName();
      }
  }
