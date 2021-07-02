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

public class TableColumnRename extends MigrationAction
  {
    public TableColumnRename(tilda.parsing.parts.Column col, String oldName)
      {
        super(col._ParentObject._ParentSchema._Name, col._ParentObject._Name, false);
        _col = col;
        _oldName = oldName;
      }

    protected tilda.parsing.parts.Column _col;
    protected String _oldName;

    public boolean process(Connection C)
    throws Exception
      {
        return C.renameTableColumn(_col, _oldName);
      }

    @Override
    public String getDescription()
      {
        return "Renaming column '"+_col._ParentObject.getShortName()+"."+_oldName+"' to '"+_col.getName()+"'.";
      }
  }
