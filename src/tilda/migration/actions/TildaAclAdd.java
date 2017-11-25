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

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.Maintenance_Data;
import tilda.data.Maintenance_Factory;
import tilda.data._Tilda.TILDA__KEY_Factory;
import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.metadata.DatabaseMeta;
import tilda.migration.MigrationAction;
import tilda.parsing.parts.Schema;
import tilda.utils.FileUtil;

public class TildaAclAdd extends MigrationAction
  {
    static final Logger LOG = LogManager.getLogger(TildaAclAdd.class.getName());

    public TildaAclAdd(List<Schema> TildaList)
      {
        super(true);
        _TildaList = TildaList;
      }

    protected List<Schema> _TildaList;

    public boolean process(Connection C)
    throws Exception
      {
        LOG.debug(getDescription());

        boolean isSuperUser = C.isSuperUser();
        Connection SuperUserCon = isSuperUser == true ? C : null;
        try
          {
            if (isSuperUser == false)
             {
               LOG.warn("");
               LOG.warn("-----------------------------------------------------------------------------------------------------");
               LOG.warn("The migration utility manages access control and roles for the database " + C.getPoolId() + ".");
               LOG.warn("To do that, it needs a superuser id and password:");
               LOG.info("Enter a superuser id:");
               String userId = FileUtil.readlnFromStdIn(false);
               LOG.info("Enter the password:");
               String userPswd = FileUtil.readlnFromStdIn(true);
               SuperUserCon = ConnectionPool.get(C.getPoolId(), userId, userPswd);
             }
            String Str = SuperUserCon.getAclRolesScript(_TildaList);
            if (SuperUserCon.ExecuteDDL(TILDA__KEY_Factory.SCHEMA_LABEL, "*", Str) == false)
              return false;

            Maintenance_Data M = Maintenance_Factory.LookupByPrimaryKey("TILDA_ACL", "TILDA_ACL");
            if (M.Read(SuperUserCon) == false)
              M = Maintenance_Factory.Create("TILDA_ACL", "TILDA_ACL");
            M.setValue(Str);
            boolean res = M.Write(SuperUserCon);
            if (res == true)
              SuperUserCon.commit();
            return res;
          }
        finally
          {
            if (isSuperUser == false && SuperUserCon != null)
              SuperUserCon.close();
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
        if (DBMeta.getTableMeta(Maintenance_Factory.SCHEMA_LABEL, Maintenance_Factory.TABLENAME_LABEL) == null)
          return true;
        String Str = C.getAclRolesScript(_TildaList);
        if (Str == null)
          return false;
        Maintenance_Data M = Maintenance_Factory.LookupByPrimaryKey("TILDA_ACL", "TILDA_ACL");
        return M.Read(C) == false || M.getValue().equals(Str.trim()) == false;
      }

  }
