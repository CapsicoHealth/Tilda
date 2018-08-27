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

import tilda.db.Connection;
import tilda.migration.MigrationAction;

public class TableIndexRename extends MigrationAction
  {
    protected static final Logger LOG = LogManager.getLogger(TableIndexDrop.class.getName());

    public TableIndexRename(tilda.parsing.parts.Object Obj, String OldName, String NewName)
      {
        super(Obj._ParentSchema._Name, Obj._Name, false);
        _Obj = Obj;
        _OldName = OldName;
        _NewName = NewName;
      }

    protected tilda.parsing.parts.Object _Obj;
    protected String _OldName;
    protected String _NewName;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableRenameIndex(_Obj, _OldName, _NewName);
      }

    @Override
    public String getDescription()
      {
        return _OldName.equalsIgnoreCase(_NewName) == false
              ? "Renaming Index " + _Obj.getShortName()+"." + _OldName + " to "+ _NewName
              : "Making case-insensitive Index " + _Obj.getShortName()+".\"" + _OldName + "\" to "+ _NewName.toLowerCase()
              ;
      }
  }
