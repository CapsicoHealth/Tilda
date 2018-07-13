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

import tilda.data.Maintenance_Data;
import tilda.data.Maintenance_Factory;
import tilda.data._Tilda.TILDA__KEY_Factory;
import tilda.db.Connection;
import tilda.db.metadata.DatabaseMeta;
import tilda.migration.MigrationAction;

public class TildaHelpersAdd extends MigrationAction
  {

    static final Logger LOG = LogManager.getLogger(TildaHelpersAdd.class.getName());

    public TildaHelpersAdd()
      {
        super(null, null, false);
      }

    public boolean process(Connection C)
    throws Exception
      {
        LOG.debug(getDescription());

        String Str = C.getHelperFunctionsScript();
        if (C.ExecuteDDL(TILDA__KEY_Factory.SCHEMA_LABEL, "*", Str) == false)
          return false;

        Maintenance_Data M = Maintenance_Factory.LookupByPrimaryKey("TILDA_HELPERS", "TILDA_HELPERS");
        if (M.Read(C) == false)
          M = Maintenance_Factory.Create("TILDA_HELPERS", "TILDA_HELPERS");
        M.setValue(Str);
        return M.Write(C);
      }

    @Override
    public String getDescription()
      {
        return "Adding Tilda helper stored procedures";
      }

    @Override
    public boolean isNeeded(Connection C, DatabaseMeta DBMeta)
    throws Exception
      {
        if (DBMeta.getTableMeta(Maintenance_Factory.SCHEMA_LABEL, Maintenance_Factory.TABLENAME_LABEL) == null)
          return true;
        String Str = C.getHelperFunctionsScript();
        if (Str == null)
          return false;
        Maintenance_Data M = Maintenance_Factory.LookupByPrimaryKey("TILDA_HELPERS", "TILDA_HELPERS");
        return M.Read(C) == false || M.getValue().equals(Str.trim()) == false;
      }

  }
