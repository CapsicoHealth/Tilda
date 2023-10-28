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

import java.time.ZonedDateTime;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.Catalog_Factory;
import tilda.data.Key_Factory;
import tilda.data.MaintenanceLog_Data;
import tilda.data.MaintenanceLog_Factory;
import tilda.db.Connection;
import tilda.db.metadata.DatabaseMeta;
import tilda.generation.helpers.CatalogHelper;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Schema;
import tilda.utils.DateTimeUtil;
import tilda.utils.LogUtil;

public class TildaCatalogAdd extends MigrationAction
  {
    private static final String TILDA_HELPERS_CATALOG = "TILDA_HELPERS_CATALOG";
    static final Logger         LOG                   = LogManager.getLogger(TildaCatalogAdd.class.getName());

    public TildaCatalogAdd(List<Schema> TildaList)
      {
        super(null, null, true, MaintenanceLog_Data._actionCatalog, MaintenanceLog_Data._objectTypeSchema);
        _TildaList = TildaList;
      }

    protected List<Schema> _TildaList;

    public boolean process(Connection C)
    throws Exception
      {
        LOG.debug(getDescription());

        ZonedDateTime startZDT = DateTimeUtil.nowLocal();

        CatalogHelper CH = new CatalogHelper();
        for (Schema s : _TildaList)
          CH.addSchema(s);

        LOG.debug("Updating the catalog information");
        LogUtil.setLogLevel(Level.ERROR);

        StringBuilder str = new StringBuilder();
        try
          {
            String statement = "select TILDA.getKeyBatchAsMaxExclusive('" + Catalog_Factory.SCHEMA_TABLENAME_LABEL.toUpperCase() + "', " + CH._CL.size() + ")-" + CH._CL.size() + ";";
            long firstKey = C.executeSelectLong(Key_Factory.SCHEMA_LABEL, Key_Factory.TABLENAME_LABEL, statement);

            final int size = 10000;
            int start = 0;
            while (start < CH._CL.size())
              {
                statement = CH.outputSQLProc(C.getSQlCodeGen(), firstKey, start, size);
                str.append(statement);
                if (C.executeDDL(MaintenanceLog_Factory.SCHEMA_LABEL, TILDA_HELPERS_CATALOG, statement) == false)
                  return false;
                start += size;
              }
          }
        finally
          {
            LogUtil.resetLogLevel();
          }

        /*@formatter:off*/
        MaintenanceLog_Data M = MaintenanceLog_Factory.create(C
                                                             ,MaintenanceLog_Data._typeMigration, MaintenanceLog_Factory.SCHEMA_LABEL, TILDA_HELPERS_CATALOG
                                                             ,startZDT, DateTimeUtil.nowLocal()
                                                             ,MaintenanceLog_Data._actionExecute, MaintenanceLog_Data._objectTypeScript
                                                             ,str.toString(), getDescription()
                                                             );
        /*@formatter:on*/

        String statement = "UPDATE " + Catalog_Factory.SCHEMA_TABLENAME_LABEL + " set deleted = current_timestamp where \"lastUpdated\" < '" + DateTimeUtil.printDateTimeForSQL(startZDT) + "';\n";
        if (C.executeDDL(MaintenanceLog_Factory.SCHEMA_LABEL, TILDA_HELPERS_CATALOG, statement) == false)
          return false;

        return true;
      }

    @Override
    public String getDescription()
      {
        return "Adding Tilda catalog entries.";
      }

    @Override
    public boolean isNeeded(Connection C, DatabaseMeta DBMeta)
    throws Exception
      {
        return true;
      }

  }
