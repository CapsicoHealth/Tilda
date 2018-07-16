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
import tilda.db.metadata.DatabaseMeta;
import tilda.migration.DDLDependencyManager;
import tilda.migration.MigrationAction;

public class DDLDependencyPreManagement extends MigrationAction
  {
    static final Logger LOG = LogManager.getLogger(DDLDependencyPreManagement.class.getName());

    public DDLDependencyPreManagement(DDLDependencyManager DdlDepMan)
      {
        super(DdlDepMan.getSchemaName(), DdlDepMan.getTableViewName(), true);
        _DdlDepMan = DdlDepMan;
      }

    public final DDLDependencyManager _DdlDepMan;

    @Override
    public boolean process(Connection C)
    throws Exception
      {
        // We expect the code calling us to not invoke process if "isNeeded" returned false.
        // Therefore, if we are called, it's because of the first time this is ever run on a DB
        // and the DDL Management infrastructure hasn't been created yet (as per comments in isNeeded).
        // So here, at this point, the infrastructure should have been instanciated, and we have to rerun
        // "fetch".
        if (_DdlDepMan.hasDependencies() == false)
         _DdlDepMan.fetchDependencies(C);

        _DdlDepMan.dropDependencies(C);
        return true;
      }

    @Override
    public boolean isNeeded(Connection C, DatabaseMeta DBMeta)
    throws Exception
      {
        try
          {
            // when running for the first time on a given database, i.e., the tilda.getdependenciesddls function doesn't exist yet,
            // so we can't reallt assess whether there are dependencies or not. So we delay to the "process" step. This happens only
            // for the first time the migrate utility is ran when the DDL Management infrastructure hasn't been created yet.
            C.setSavepoint();
            if (_DdlDepMan.fetchDependencies(C) == false)
              return false;
            if (_DdlDepMan.hasDependencies() == false)
              return false;
          }
        catch (Exception E)
          {
            LOG.warn("An error occurred while looking at dependencies. This is because this is the first time this is being run ever for this database. The utility should continue properly.");
            C.releaseSavepoint(false);
          }
        return true;
      }

    public String getDescription()
      {
        return "Dropping all views dependent on " + _DdlDepMan.getSchemaName() + "." + _DdlDepMan.getTableViewName() + " (to be re-created after all changes have been applied).";
      }
  }
