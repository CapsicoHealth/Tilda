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
import tilda.db.metadata.TableMeta;
import tilda.migration.MigrationAction;

public class TablePKSwitchType extends MigrationAction
  {
    protected static final Logger LOG = LogManager.getLogger(TablePKSwitchType.class.getName());

    public TablePKSwitchType(tilda.parsing.parts.Object Obj, TableMeta TMeta)
      {
        super(Obj._ParentSchema._Name, Obj._Name, false, MaintenanceLog_Data._actionUpdate, MaintenanceLog_Data._objectTypePrimaryKey);
        _Obj = Obj;
        _TMeta = TMeta;
      }

    protected tilda.parsing.parts.Object _Obj;
    protected TableMeta                  _TMeta;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableSwitchTablePKType(_Obj, _TMeta._PrimaryKey);
      }

    @Override
    public String getDescription()
      {
        if (_TMeta._PrimaryKey._Identity == true)
         return "Removing generated identity for Table " + _Obj.getFullName() + "'s Primary Key.";

        return "Adding generated identity for table " + _Obj.getFullName() + "'s Primary Key.";
      }


  }
