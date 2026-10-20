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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.MaintenanceLog_Data;
import tilda.db.Connection;
import tilda.db.metadata.FKMeta;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.ForeignKey;

/**
 * Brings the name of a database foreign key in line with the model's naming convention <code>fk_&lt;tableName&gt;_&lt;fkName&gt;</code>
 * when the foreign key is otherwise logically identical (same source columns and destination). Databases that cannot rename
 * constraints do this by dropping and re-adding the foreign key.
 */
public class TableFKRename extends MigrationAction
  {
    protected static final Logger LOG = LogManager.getLogger(TableFKRename.class.getName());

    public TableFKRename(ForeignKey FK, FKMeta oldFK)
      {
        super(FK._ParentObject._ParentSchema._Name, FK._ParentObject._Name, false, MaintenanceLog_Data._actionUpdate, MaintenanceLog_Data._objectTypeForeignKey);
        _FK = FK;
        _OldFK = oldFK;
      }

    protected ForeignKey _FK;
    protected FKMeta     _OldFK;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableRenameFK(_FK, _OldFK);
      }

    @Override
    public String getDescription()
      {
        return "Renaming FK " + _FK._ParentObject.getFullName() + "." + _OldFK._Name + "(" + _FK.getColumnList() + ") to " + _FK.getName();
      }
  }
