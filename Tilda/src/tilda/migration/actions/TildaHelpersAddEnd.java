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

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.MaintenanceLog_Data;
import tilda.data.MaintenanceLog_Factory;
import tilda.db.Connection;
import tilda.db.metadata.DatabaseMeta;
import tilda.migration.MigrationAction;

public class TildaHelpersAddEnd extends MigrationAction
  {

    private static final String TILDA_HELPERS_END = "TILDA_HELPERS_END";

    static final Logger         LOG               = LogManager.getLogger(TildaHelpersAddEnd.class.getName());

    public TildaHelpersAddEnd()
      {
        super(MaintenanceLog_Factory.SCHEMA_LABEL, TILDA_HELPERS_END, false, MaintenanceLog_Data._actionExecute, MaintenanceLog_Data._objectTypeScript);
      }

    public boolean process(Connection C)
    throws Exception
      {
        LOG.debug(getDescription());
        String statement = C.getHelperFunctionsScript(false);
        return C.executeDDL(MaintenanceLog_Factory.SCHEMA_LABEL, TILDA_HELPERS_END, statement);
      }

    @Override
    public String getDescription()
      {
        return "Adding Tilda end-helper stored procedures";
      }

    @Override
    public boolean isNeeded(Connection C, DatabaseMeta DBMeta)
    throws Exception
      {
        // When run for the first time, some tables may not exist yet.
        if (DBMeta.getTableMeta(MaintenanceLog_Factory.SCHEMA_LABEL, MaintenanceLog_Factory.TABLENAME_LABEL) == null)
          return true;
        String endScript = C.getHelperFunctionsScript(true);
        if (endScript == null)
          throw new Exception("Cannot load Tilda helper end script.");
        // Get the most recent log for executing the script
        List<MaintenanceLog_Data> L = MaintenanceLog_Factory.lookupWhereSchemaObjectStart(C, MaintenanceLog_Factory.SCHEMA_LABEL, TILDA_HELPERS_END, 0, 1);
        if (L.isEmpty() == true)
          return true;
        MaintenanceLog_Data M = L.get(0);
        return M.getStatement().trim().equals(endScript.trim()) == false;
      }

  }
