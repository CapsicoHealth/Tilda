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
import tilda.db.metadata.IndexMeta;
import tilda.migration.MigrationAction;

public class TableIndexDrop extends MigrationAction
  {
    protected static final Logger LOG = LogManager.getLogger(TableIndexDrop.class.getName());

    public TableIndexDrop(tilda.parsing.parts.Object SrcObj, tilda.parsing.parts.Object TargetObj, IndexMeta IX)
      {
        super(false);
        _SrcObj = SrcObj;
        _TargetObj = TargetObj;
        _IX = IX;
      }

    protected tilda.parsing.parts.Object _SrcObj;
    protected tilda.parsing.parts.Object _TargetObj;
    protected IndexMeta _IX;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableDropIndex(_SrcObj, _IX);
      }

    @Override
    public String getDescription()
      {
        return "Dropping Table " + _SrcObj.getFullName()+"'s Index " + _IX._Name + "("+_IX.toString()+")";
      }
  }
