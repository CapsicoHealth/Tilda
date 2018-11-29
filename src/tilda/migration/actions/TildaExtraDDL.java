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
import tilda.db.Connection;
import tilda.db.metadata.DatabaseMeta;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Schema;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class TildaExtraDDL extends MigrationAction
  {

    static final Logger LOG = LogManager.getLogger(TildaExtraDDL.class.getName());

    public TildaExtraDDL(Schema S, String ResourceName)
      throws Exception
      {
        super(S._Name, null, false);
        _ResourceName = FileUtil.getBasePathFromFileOrResource(S._ResourceName) + ResourceName;
        _SchemaName = S._Name;
      }

    protected String _ResourceName;
    protected String _SchemaName;

    public boolean process(Connection C)
    throws Exception
      {
        LOG.debug(getDescription());

        String Str = FileUtil.getFileOfResourceContents(_ResourceName);
        if (TextUtil.isNullOrEmpty(Str) == true)
          return true;

        if (C.ExecuteDDL(_SchemaName, "*", Str) == false)
          return false;

        Maintenance_Data M = Maintenance_Factory.LookupByPrimaryKey("EXTERNAL_DDL", _ResourceName);
        if (M.Read(C) == false)
          M = Maintenance_Factory.Create("EXTERNAL_DDL", _ResourceName);
        M.setValue(Str);
        return M.Write(C);
      }

    @Override
    public String getDescription()
      {
        return "Running an extra external DDL script '" + _ResourceName + "' on schema '" + _SchemaName + "'";
      }

    @Override
    public boolean isNeeded(Connection C, DatabaseMeta DBMeta)
    throws Exception
      {
        if (DBMeta.getTableMeta(Maintenance_Factory.SCHEMA_LABEL, Maintenance_Factory.TABLENAME_LABEL) == null)
          return true;
        String Str = FileUtil.getFileOfResourceContents(_ResourceName);
        if (TextUtil.isNullOrEmpty(Str) == true)
          return false;
        Maintenance_Data M = Maintenance_Factory.LookupByPrimaryKey("EXTERNAL_DDL", _ResourceName);
        return M.Read(C) == false || M.getValue().equals(Str.trim()) == false;
      }
  }
