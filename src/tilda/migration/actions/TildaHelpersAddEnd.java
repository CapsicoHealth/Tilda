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
import tilda.migration.MigrationAction;

public class TildaHelpersAddEnd extends MigrationAction
  {

    static final Logger LOG = LogManager.getLogger(TildaHelpersAddEnd.class.getName());

    public TildaHelpersAddEnd()
      {
        super(Maintenance_Factory.SCHEMA_LABEL, Maintenance_Factory.TABLENAME_LABEL, false);
      }

    public boolean process(Connection C)
    throws Exception
      {
        LOG.debug(getDescription());

        String Str = C.getHelperFunctionsScript(false);
        if (C.ExecuteDDL(TILDA__KEY_Factory.SCHEMA_LABEL, "*", Str) == false)
          return false;

        Str = C.getHelperFunctionsScript(true)+"\n"+Str;
        Maintenance_Data M = Maintenance_Factory.LookupByPrimaryKey("TILDA_HELPERS", "TILDA_HELPERS");
        if (M.Read(C) == false)
          M = Maintenance_Factory.Create("TILDA_HELPERS", "TILDA_HELPERS");
        M.setValue(Str);
        return M.Write(C);
      }

    @Override
    public String getDescription()
      {
        return "Adding Tilda end-helper stored procedures";
      }
    
    // No need for isNeeded. The migrator code is responsible to add "end" if it added "start"

  }
