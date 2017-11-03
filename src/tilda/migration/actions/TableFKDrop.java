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
import tilda.db.metadata.FKMeta;
import tilda.migration.MigrationAction;

public class TableFKDrop extends MigrationAction
  {
    protected static final Logger LOG = LogManager.getLogger(TableFKDrop.class.getName());

    public TableFKDrop(tilda.parsing.parts.Object SrcObj, tilda.parsing.parts.Object TargetObj, FKMeta FK)
      {
        super(false);
        _SrcObj = SrcObj;
        _TargetObj = TargetObj;
        _FK = FK;
      }

    protected tilda.parsing.parts.Object _SrcObj;
    protected tilda.parsing.parts.Object _TargetObj;
    protected FKMeta _FK;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableDropFK(_SrcObj, _FK);
      }

    @Override
    public String getDescription()
      {
        return "Dropping Table " + _SrcObj.getFullName()+"'s Foreign Key " + _FK._Name + "("+_FK.getColumnList()+") to " + (_TargetObj==null ? _FK._OtherSchema+"."+_FK._OtherTable : _TargetObj.getFullName());
      }


  }
