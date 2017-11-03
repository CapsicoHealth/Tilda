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
import tilda.parsing.parts.ForeignKey;

public class TableFKAdd extends MigrationAction
  {
    protected static final Logger LOG = LogManager.getLogger(TableFKAdd.class.getName());

    public TableFKAdd(ForeignKey FK)
      {
        super(false);
        _FK = FK;
      }

    protected ForeignKey _FK;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableAddFK(_FK);
      }

    @Override
    public String getDescription()
      {
        return "Adding FK "+_FK._Name+"("+_FK.getColumnList()+") to table " + _FK._ParentObject.getFullName();
      }


  }
