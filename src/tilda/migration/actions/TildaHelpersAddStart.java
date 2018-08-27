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

public class TildaHelpersAddStart extends MigrationAction
  {

    static final Logger LOG = LogManager.getLogger(TildaHelpersAddStart.class.getName());

    public TildaHelpersAddStart()
      {
        super(Maintenance_Factory.SCHEMA_LABEL, Maintenance_Factory.TABLENAME_LABEL, false);
      }

    public boolean process(Connection C)
    throws Exception
      {
        LOG.debug(getDescription());

        String Str = C.getHelperFunctionsScript(true);
        if (C.ExecuteDDL(TILDA__KEY_Factory.SCHEMA_LABEL, "*", Str) == false)
          return false;
        return true;
      }

    @Override
    public String getDescription()
      {
        return "Adding Tilda start-helper stored procedures";
      }

    @Override
    public boolean isNeeded(Connection C, DatabaseMeta DBMeta)
    throws Exception
      {
        if (DBMeta.getTableMeta(Maintenance_Factory.SCHEMA_LABEL, Maintenance_Factory.TABLENAME_LABEL) == null)
          return true;
        String StartScript = C.getHelperFunctionsScript(true);
        String EndScript = C.getHelperFunctionsScript(false);
        if (StartScript == null)
         throw new Exception("Cannot load Tilda helper start script.");
        if (EndScript == null)
          throw new Exception("Cannot load Tilda helper end script.");
        String Str = StartScript+"\n"+EndScript;
        Maintenance_Data M = Maintenance_Factory.LookupByPrimaryKey("TILDA_HELPERS", "TILDA_HELPERS");
        return M.Read(C) == false || M.getValue().equals(Str.trim()) == false;
      }

  }
