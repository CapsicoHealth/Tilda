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
import tilda.db.metadata.TableMeta;
import tilda.migration.MigrationAction;
import tilda.utils.TextUtil;

public class TablePKReplace extends MigrationAction
  {
    protected static final Logger LOG = LogManager.getLogger(TablePKReplace.class.getName());

    public TablePKReplace(tilda.parsing.parts.Object O, TableMeta TMeta)
      {
        super(false);
        _O = O;
        _TMeta = TMeta;
        // LOG.debug("FK Out");
        // for (FKMeta fk : _TMeta._ForeignKeysOut.values())
        // LOG.debug(" "+fk.toString());
        // LOG.debug("FK In");
        // for (FKMeta fk : _TMeta._ForeignKeysIn.values())
        // LOG.debug(" "+fk.toString());
        // LOG.debug("xxx");
      }

    protected tilda.parsing.parts.Object _O;
    protected TableMeta                  _TMeta;

    public boolean process(Connection C)
    throws Exception
      {
        return C.alterTableReplaceTablePK(_O, _TMeta._PrimaryKey);
      }

    @Override
    public String getDescription()
      {
        if (_TMeta._PrimaryKey != null)
          {
            if (_O._PrimaryKey == null)
              return "Dropping Table " + _O.getFullName() + "'s Primary Key " + _TMeta._PrimaryKey.toString();
            return "Updating Table " + _O.getFullName() + "'s Primary Key from " + _TMeta._PrimaryKey.toString() + " to (" + TextUtil.Print(_O._PrimaryKey._Columns) + ")";
          }

        if (_O._PrimaryKey == null)
          return "Not doing anything to Table " + _O.getFullName() + "'s Primary Key. Why is this being called?";
        return "Adding Table " + _O.getFullName() + "'s Primary Key (" + TextUtil.Print(_O._PrimaryKey._Columns) + ")";
      }


  }
