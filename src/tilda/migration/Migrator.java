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

package tilda.migration;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.KeysManager;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.DatabaseMeta;
import tilda.db.metadata.TableMeta;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.migration.actions.ColumnAdd;
import tilda.migration.actions.ColumnAlterNull;
import tilda.migration.actions.ColumnAlterStringSize;
import tilda.migration.actions.ColumnAlterType;
import tilda.migration.actions.ColumnDrop;
import tilda.migration.actions.SchemaCreate;
import tilda.migration.actions.SchemaViewsCreate;
import tilda.migration.actions.SchemaViewsDrop;
import tilda.migration.actions.TableCreate;
import tilda.migration.actions.TableKeyCreate;
import tilda.migration.actions.TildaHelpersAdd;
import tilda.parsing.Parser;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;

public class Migrator
  {
    protected static final Logger LOG                 = LogManager.getLogger(Parser.class.getName());

    public static final String    TILDA_VERSION       = "1.0";
    public static final String    TILDA_VERSION_VAROK = "1_0";

    public static void MigrateDatabase(Connection C, boolean CheckOnly, List<Schema> TildaList, DatabaseMeta DBMeta)
    throws Exception
      {
        List<MigrationScript> Scripts = new ArrayList<MigrationScript>();
        int ActionCount = 0;

        LOG.info("Analyzing differences between the database and the application's expected data model...");
        MigrationScript InitScript = new MigrationScript(null, new ArrayList<MigrationAction>());
        for (Schema S : TildaList)
          InitScript._Actions.add(new SchemaViewsDrop(S));
        Scripts.add(InitScript);
        for (Schema S : TildaList)
          {
            List<MigrationAction> L = Migrator.getMigrationActions(S, DBMeta);
            if (L.isEmpty() == false)
              {
                ActionCount += L.size();
              }
            L.add(new SchemaViewsCreate(S));
            Scripts.add(new MigrationScript(S, L));
          }
        MigrationScript ClosingScript = new MigrationScript(null, new ArrayList<MigrationAction>());
        ClosingScript._Actions.add(new TildaHelpersAdd());
        Scripts.add(ClosingScript);

        if (ActionCount > 0)
          {
            LOG.info("There were " + ActionCount + " discrepencies found in the database Vs. the application's required data model:");
            for (MigrationScript S : Scripts)
              for (MigrationAction A : S._Actions)
                LOG.debug("    - " + A.getDescription() + ".");
            if (CheckOnly == false)
              {
                LOG.info("Applying migration actions.");
                for (MigrationScript S : Scripts)
                  {
                    for (MigrationAction A : S._Actions)
                      if (A.process(C) == true)
                        C.commit();
                      else
                        throw new Exception("There was an error with the action '" + A.getDescription() + "'.");
                  }
              }
          }

        if (ActionCount == 0)
          {
            LOG.info("");
            LOG.info("");
            LOG.info("====================================================================");
            LOG.info("===  Woohoo! The database matches the Application's data model.  ===");
            LOG.info("====================================================================");
            LOG.info("");
          }
        else if (CheckOnly == false)
          {
            KeysManager.reloadAll();
            LOG.info("");
            LOG.info("");
            LOG.info("================================================================================================");
            LOG.info("===  Woohoo! The database was automatically migrated to match the Application's data model.  ===");
            LOG.info("================================================================================================");
            LOG.info("");
          }
      }

    protected static List<MigrationAction> getMigrationActions(Schema S, DatabaseMeta DBMeta)
    throws Exception
      {
        LOG.info("Comparing the application's data model with the database's for " + S.getFullName());

        List<MigrationAction> Actions = new ArrayList<MigrationAction>();

        if (DBMeta.getSchemaMeta(S._Name) == null)
          Actions.add(new SchemaCreate(S));

        for (Object Obj : S._Objects)
          {
            if (Obj._FST == FrameworkSourcedType.VIEW)
              continue;
            TableMeta TMeta = DBMeta.getTableMeta(Obj._ParentSchema._Name, Obj._Name);
            if (TMeta == null)
              Actions.add(new TableCreate(Obj));
            else
              {
                if (Obj._PrimaryKey != null && Obj._PrimaryKey._Autogen == true && KeysManager.hasKey(Obj.getShortName()) == false)
                  Actions.add(new TableKeyCreate(Obj));
                for (Column Col : Obj._Columns)
                  {
                    if (Col == null || Col._Mode == ColumnMode.CALCULATED)
                      continue;
                    ColumnMeta CI = TMeta.getColumnMeta(Col.getName());
                    if (CI == null)
                      Actions.add(new ColumnAdd(Col));
                    else
                      {
                        if (CI._Nullable == 1 && Col._Nullable == false || CI._Nullable == 0 && Col._Nullable == true)
                          Actions.add(new ColumnAlterNull(Col));

                        if (DBMeta.supportsArrays() == true)
                          {
                            if (CI.isArray() == false && Col.isCollection() == true && Col._Type != ColumnType.JSON)
                              throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as an array, but it's not an array in the DB. The database needs to be migrated manually.");
                            else if (CI.isArray() == true && (Col.isCollection() == false || Col._Type == ColumnType.JSON))
                              throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as an base type, but it's an array in the DB. The database needs to be migrated manually.");
                          }

                        if (Col._Type == ColumnType.STRING && Col.isCollection() == false
                        && (CI._Size < DBMeta.getCLOBThreshhold() && CI._Size != Col._Size
                        || CI._Size >= DBMeta.getCLOBThreshhold() && Col._Size < DBMeta.getCLOBThreshhold()))
                          Actions.add(new ColumnAlterStringSize(Col, CI._Size));

                        if (Col.isCollection() == false
                        && (Col._Type == ColumnType.BITFIELD && CI._TildaType != ColumnType.INTEGER
                        || Col._Type == ColumnType.JSON && CI._TildaType != ColumnType.STRING && CI._TildaType != ColumnType.JSON
                        || Col._Type != ColumnType.BITFIELD && Col._Type != ColumnType.JSON && Col._Type != CI._TildaType))
                          Actions.add(new ColumnAlterType(Col, CI._TildaType));
                      }
                  }
                for (String c : Obj._DropOldColumns)
                  {
                    ColumnMeta CI = TMeta.getColumnMeta(c);
                    Column Col = Obj.getColumn(c);
                    if (Col == null && CI != null)
                      Actions.add(new ColumnDrop(Obj, c));
                  }
              }
          }

        return Actions;
      }
  }
