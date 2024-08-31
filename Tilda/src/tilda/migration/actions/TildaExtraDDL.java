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
import tilda.db.JDBCHelper;
import tilda.db.metadata.DatabaseMeta;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Schema;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class TildaExtraDDL extends MigrationAction
  {

    static final Logger LOG = LogManager.getLogger(TildaExtraDDL.class.getName());

    public TildaExtraDDL(Schema S, String resourceName)
      throws Exception
      {
        super(S._Name, FileUtil.getBasePathFromFileOrResource(S._ResourceName) + resourceName, false, MaintenanceLog_Data._actionExecute, MaintenanceLog_Data._objectTypeScript);
      }
    
    public boolean process(Connection C)
    throws Exception
      {
        if (JDBCHelper.isRehearsal() == false)
         LOG.debug(getDescription());

        String statement = FileUtil.getFileOfResourceContents(_TableViewName);
        if (TextUtil.isNullOrEmpty(statement) == true)
          return true;

        return C.executeDDL(_SchemaName, _TableViewName, statement);
      }

    @Override
    public String getDescription()
      {
        return "Running an extra external DDL script '" + _TableViewName + "' on schema '" + _SchemaName + "'";
      }

    @Override
    public boolean isNeeded(Connection C, DatabaseMeta DBMeta)
    throws Exception
      {
        // When run for the first time, some tables may not exist yet.
        if (DBMeta.getTableMeta(MaintenanceLog_Factory.SCHEMA_LABEL, MaintenanceLog_Factory.TABLENAME_LABEL) == null)
          return true;
        String statement = FileUtil.getFileOfResourceContents(_TableViewName);
        if (TextUtil.isNullOrEmpty(statement) == true)
          throw new Exception("Cannot find external DDL script '" + _TableViewName + "'.");
        // Get the most recent log for executing the script
        List<MaintenanceLog_Data> L = MaintenanceLog_Factory.lookupWhereSchemaObjectStart(C, _SchemaName, _TableViewName, 0, 1);
        if (L.isEmpty() == true)
          return true;
        MaintenanceLog_Data M = L.get(0);
        boolean same = M.getStatement().trim().equals(statement.trim());
        return !same;
      }
  }
