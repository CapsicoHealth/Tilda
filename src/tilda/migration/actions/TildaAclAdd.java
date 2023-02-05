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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.MaintenanceLog_Data;
import tilda.data.MaintenanceLog_Factory;
import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.QueryDetails;
import tilda.db.metadata.DatabaseMeta;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Schema;
import tilda.utils.DateTimeUtil;
import tilda.utils.FileUtil;

public class TildaAclAdd extends MigrationAction
  {
    private static final String TILDA_HELPERS_ACL = "TILDA_HELPERS_ACL";
    static final Logger         LOG               = LogManager.getLogger(TildaAclAdd.class.getName());

    public TildaAclAdd(List<Schema> TildaList)
      {
        super(null, null, true, MaintenanceLog_Data._actionUpdate, MaintenanceLog_Data._objectTypeSchema);
        _TildaList = TildaList;
      }

    protected List<Schema> _TildaList;

    public boolean process(Connection C)
    throws Exception
      {
        LOG.debug(getDescription());

        boolean isSuperUser = C.isSuperUser();
        Connection superUserCon = isSuperUser == true ? C : null;
        try
          {
            if (isSuperUser == false)
              {
                LOG.warn("");
                LOG.warn("");
                LOG.warn("=====================================================================================================");
                LOG.warn("=====================================================================================================");
                LOG.warn("The migration utility manages access control and roles for the database " + C.getPoolId() + ".");
                LOG.warn("To do that, it needs a superuser id and password:");
                LOG.info("Enter a superuser id:");
                String userId = FileUtil.readlnFromStdIn(false);
                LOG.info("Enter the password:");
                String userPswd = FileUtil.readlnFromStdIn(true);
                superUserCon = ConnectionPool.get(C.getPoolId(), userId, userPswd);
              }
            String statement = superUserCon.getAclRolesScript(_TildaList);
            if (statement == null)
              return true;

            ZonedDateTime startZDT = DateTimeUtil.nowLocal();
            if (superUserCon.executeDDL(MaintenanceLog_Factory.SCHEMA_LABEL, TILDA_HELPERS_ACL, statement) == false)
              return false;

            /*@formatter:off*/
            MaintenanceLog_Data M = MaintenanceLog_Factory.create(superUserCon
                                                                 ,MaintenanceLog_Data._typeMigration, MaintenanceLog_Factory.SCHEMA_LABEL, TILDA_HELPERS_ACL
                                                                 ,startZDT, DateTimeUtil.nowLocal()
                                                                 ,MaintenanceLog_Data._actionExecute, MaintenanceLog_Data._objectTypeScript
                                                                 ,QueryDetails.getLastQuerySecure(), getDescription()
                                                                 );
            /*@formatter:on*/
            if (M != null)
              {
                superUserCon.commit();
                return true;
              }
            return false;
          }
        finally
          {
            if (isSuperUser == false && superUserCon != null)
              superUserCon.close();
          }
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
        // For now, most changes may result in dropping and re-creating tables and/or views.
        // As a result, we should run ACL every time no matter what.
        return true;
        /*
         * if (DBMeta.getTableMeta(Maintenance_Factory.SCHEMA_LABEL, Maintenance_Factory.TABLENAME_LABEL) == null)
         * return true;
         * String Str = C.getAclRolesScript(_TildaList);
         * if (Str == null)
         * return false;
         * Maintenance_Data M = Maintenance_Factory.lookupByPrimaryKey("TILDA_ACL", "TILDA_ACL");
         * return M.read(C) == false || M.getValue().equals(Str.trim()) == false;
         */
      }

  }
