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

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.Migrate;
import tilda.db.Connection;
import tilda.db.KeysManager;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.DatabaseMeta;
import tilda.db.metadata.FKMeta;
import tilda.db.metadata.IndexMeta;
import tilda.db.metadata.PKMeta;
import tilda.db.metadata.SchemaMeta;
import tilda.db.metadata.TableMeta;
import tilda.db.metadata.ViewMeta;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectMode;
import tilda.generation.interfaces.CodeGenSql;
import tilda.migration.actions.ColumnAdd;
import tilda.migration.actions.ColumnAlterMulti;
import tilda.migration.actions.ColumnAlterNull;
import tilda.migration.actions.ColumnAlterNumericSize;
import tilda.migration.actions.ColumnComment;
import tilda.migration.actions.ColumnDefault;
import tilda.migration.actions.DDLDependencyPostManagement;
import tilda.migration.actions.DDLDependencyPreManagement;
import tilda.migration.actions.SchemaCreate;
import tilda.migration.actions.TableColumnRename;
import tilda.migration.actions.TableComment;
import tilda.migration.actions.TableCreate;
import tilda.migration.actions.TableFKAdd;
import tilda.migration.actions.TableFKDrop;
import tilda.migration.actions.TableIndexAdd;
import tilda.migration.actions.TableIndexDrop;
import tilda.migration.actions.TableIndexRename;
import tilda.migration.actions.TableKeyCreate;
import tilda.migration.actions.TablePKReplace;
import tilda.migration.actions.TableViewRename;
import tilda.migration.actions.TableViewSchemaSet;
import tilda.migration.actions.TildaAclAdd;
import tilda.migration.actions.TildaExtraDDL;
import tilda.migration.actions.TildaHelpersAddEnd;
import tilda.migration.actions.TildaHelpersAddStart;
import tilda.migration.actions.ViewCreate;
import tilda.migration.actions.ViewDrop;
import tilda.parsing.Parser;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.MigrationMove;
import tilda.parsing.parts.MigrationRename;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.PrimaryKey;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.utils.AsciiArt;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class Migrator
  {
    protected static final Logger LOG                 = LogManager.getLogger(Parser.class.getName());

    public static final String    TILDA_VERSION       = "1.0";
    public static final String    TILDA_VERSION_VAROK = "1_0";

    public static void MigrateDatabase(Connection C, boolean CheckOnly, List<Schema> TildaList, DatabaseMeta DBMeta, boolean first, List<String> connectionUrls, String[] DependencySchemas)
    throws Exception
      {
        MigrationDataModel migrationData = Migrator.AnalyzeDatabase(C, CheckOnly, TildaList, DBMeta);

        if (migrationData.getActionCount() == 0)
          {
            if (CheckOnly == false)
              {
                MigrationAction A = new TildaHelpersAddStart();
                if (A.isNeeded(C, DBMeta) == true)
                  {
                    A.process(C);
                    new TildaHelpersAddEnd().process(C);
                    C.commit();
                  }
                doAcl(C, TildaList, DBMeta);
              }
            LOG.info("\n"
            + "          ==============================================================================\n"
            + AsciiArt.OK("                                    ")
            + "\n"
            + "                    The database already matched the Application's data model.          \n"
            + "          ==============================================================================\n");
          }
        else if (CheckOnly == false)
          {
            PrintDiscrepancies(C, migrationData, DependencySchemas);
            confirmMigration(C);
            applyMigration(C, migrationData, DependencySchemas);
            doAcl(C, TildaList, DBMeta);
            if (Migrate.isTesting() == false)
              KeysManager.reloadAll();
          }
        else
          {
            LOG.warn("\n"
            + "          =============================================================================================================\n"
            + AsciiArt.Warning("          ")
            + "\n"
            + "                 The database DOES NOT match the Application's data model. The application may NOT run properly!       \n"
            + "          =============================================================================================================\n");
          }
      }

    private static void doAcl(Connection C, List<Schema> TildaList, DatabaseMeta DBMeta)
    throws Exception
      {
        MigrationAction A = new TildaAclAdd(TildaList);
        if (A.isNeeded(C, DBMeta) == true)
          A.process(C);
      }

    public static void PrintDiscrepancies(Connection C, MigrationDataModel migrationData, String[] DependencySchemas)
    throws Exception
      {
        LOG.info("");
        LOG.warn("There were " + migrationData.getActionCount() + " discrepencies found between the application's required data model and the database " + C.getPoolName() + ".");
        LOG.info("");
        int counter = 0;
        int counterApplied = 0;
        for (MigrationScript S : migrationData.getMigrationScripts())
          {
            int counterSchema = 0;
            for (MigrationAction MA : S._Actions)
              {
                boolean included = S._S == null || TextUtil.findElement(DependencySchemas, S._S._Name, true, 0) == -1;
                if (S._S != null && counterSchema == 0) // Print schema header for logs
                  {
                    ++counterSchema;
                    LOG.warn("    Schema '" + S._S._Name + "': " + (included == true ? "" : " DECLARED AS A DEPENDENCY IN tilda.config.json AND WON'T BE MIGRATED!"));
                  }
                if (MA.isDependencyAction() == false)
                  {
                    if (included == true)
                      ++counterApplied;
                    LOG.warn((included == true ? "       " : "       // ") + (++counter) + " - " + MA.getDescription());
                  }
                else
                  LOG.debug((included == true ? "       " : "       // ") + "(dependency) " + MA.getDescription());
              }
          }
        List<MigrationDrops> drops = migrationData.getDropList();
        if (drops != null && drops.isEmpty() == false)
          {
            LOG.info("");
            File F = new File("tilda.migration.drops.sql");
            PrintWriter out = new PrintWriter(new FileOutputStream(F, false));
            for (MigrationDrops d : drops)
              out.println("-- " + d.process());
            out.close();
            LOG.info("A total of " + drops.size() + " drop actions have been saved to the file " + F.getCanonicalPath() + ".");
          }
        LOG.info("");
        LOG.info("A total of " + counterApplied + " migration steps will be applied.");
      }

    public static MigrationDataModel AnalyzeDatabase(Connection C, boolean checkOnly, List<Schema> tildaList, DatabaseMeta DBMeta)
    throws Exception
      {
        List<MigrationScript> scripts = new ArrayList<MigrationScript>();
        int actionCount = 0;

        // if (CheckOnly == false && Migrate.isTesting() == false)
        // AddTildaHelpers(C, TildaList, DBMeta);

        LOG.info("===> Analyzing DB ( Url: " + C.getPoolName() + " )");
        LOG.info("Analyzing differences between the database and the application's expected data model...");
        List<MigrationDrops> dropList = new ArrayList<MigrationDrops>();
        for (Schema S : tildaList)
          {
            List<MigrationAction> L = Migrator.getMigrationActions(C, C.getSQlCodeGen(), S, tildaList, DBMeta);
            for (MigrationAction MA : L)
              if (MA.isDependencyAction() == false)
                ++actionCount;
            scripts.add(new MigrationScript(S, L));
            dropList.addAll(Migrator.getDropScripts(C, C.getSQlCodeGen(), S, DBMeta));
          }
        return new MigrationDataModel(actionCount, scripts, dropList);
      }


    protected static void confirmMigration(Connection C)
    throws Exception
      {
        LOG.info("\n");
        LOG.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("!!! THE FOLLOWING DATABASE WILL NOW BE MIGRATED:");
        LOG.info("!!!    ==> " + C.getPoolName());
        LOG.info("!!!     ______ ____  ______   ____   ___    ______ __ __ __  __ ____  _____    ___   ");
        LOG.info("!!!    / ____// __ \\/_  __/  / __ ) /   |  / ____// //_// / / // __ \\/ ___/   /__ \\ ");
        LOG.info("!!!   / / __ / / / / / /    / __  |/ /| | / /    / ,<  / / / // /_/ /\\__ \\     / _/ ");
        LOG.info("!!!  / /_/ // /_/ / / /    / /_/ // ___ |/ /___ / /| |/ /_/ // ____/___/ /    /_/   ");
        LOG.info("!!!  \\____/ \\____/ /_/    /_____//_/  |_|\\____//_/ |_|\\____//_/    /____/    (_)    ");
        LOG.info("!!!");
        LOG.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        LOG.info("\n");
        try
          {
            LOG.info("Press 'yes' followed by enter to continue.");
            String answer = FileUtil.readlnFromStdIn(false);
            if (answer.toLowerCase().equals("yes") == false)
              throw new Exception("User asked to exit.");
            LOG.info("");
            LOG.info("OK! Starting the migration...");
            LOG.info("------------------------------------");
          }
        catch (Exception E)
          {
            throw E;
          }
      }

    protected static void applyMigration(Connection C, MigrationDataModel migrationData, String[] DependencySchemas)
    throws Exception
      {
        LOG.info("===> Migrating DB ( Url: " + C.getURL() + " )");
        LOG.info("Applying migration actions.");
        // DDLDependencyManager DdlDepMan = null;
        MigrationAction lastAction = null;
        try
          {
            for (MigrationScript S : migrationData.getMigrationScripts())
              {
                if (S._Actions.isEmpty() == true)
                  continue;
                if (S._S != null && TextUtil.findElement(DependencySchemas, S._S._Name, true, 0) != -1)
                  continue;
                String lastEntityName = null;
                for (MigrationAction A : S._Actions)
                  {
                    lastAction = A;
                    String currentEntityName = A._SchemaName + "." + A._TableViewName;
                    LOG.debug("Applying migration: " + A.getDescription());
                    if (A.process(C) == false)
                      throw new Exception("There was an error with the action '" + A.getDescription() + "'.");
                    if (Migrate.isTesting() == false && lastEntityName != null && currentEntityName.equals(lastEntityName) == false)
                      C.commit();
                    // if (A.getClass() == DDLDependencyPreManagement.class)
                    // DdlDepMan = ((DDLDependencyPreManagement) A)._DdlDepMan;
                    // else if (A.getClass() == DDLDependencyPostManagement.class)
                    // DdlDepMan = null;
                    lastEntityName = currentEntityName;
                  }
                C.commit();
              }
          }
        catch (Exception E)
          {
            LOG.error("An exception occurred during migration: " + lastAction.getDescription());
            LOG.catching(E);
            // if (DdlDepMan != null)
            // {
            C.rollback();
            // LOG.debug("There were dropped dependencies that need to be restored now.");
            // DdlDepMan.restoreDependencies(C);
            // C.commit();
            // }
            try
              {
                lastAction.errorHandling(C);
                C.commit();
              }
            catch (Throwable T)
              {
                LOG.catching(T);
                C.rollback();
              }

            throw new Exception("Migration failed, and temporarily dropped dependencies were restored");
          }
      }

    protected static List<MigrationAction> getMigrationActions(Connection C, CodeGenSql CGSQL, Schema S, List<Schema> TildaList, DatabaseMeta DBMeta)
    throws Exception
      {
        LOG.info("Comparing the application's data model with the database's for " + S.getFullName());

        List<MigrationAction> Actions = new ArrayList<MigrationAction>();
        List<String> Errors = new ArrayList<String>();

        // Create the schema if not exists
        if (DBMeta.getSchemaMeta(S._Name) == null)
          {
            Actions.add(new SchemaCreate(S));
            // We must create the schema object in DBMeta so that if there are any future migrations of pre-existing
            // tables/views from an older schema to a newer schema.
            DBMeta.addSchema(S._Name);
          }

        if (S._Migration != null) // Are there any migration steps to move tables over to this schema?
          {
            if (S._Migration._Moves.isEmpty() == false)
              for (MigrationMove MM : S._Migration._Moves)
                if (MM != null)
                  {
                    if (DBMeta.getSchemaMeta(MM._Schema) == null) // We might move some tables/views from an external schema which we should load.
                      DBMeta.load(C, MM._Schema);

                    for (Object obj : MM._Objects) // let's look at tables to transfer
                      {
                        TableMeta TMSrc = DBMeta.getTableMeta(MM._Schema, obj._Name); // src table
                        TableMeta TMDest = DBMeta.getTableMeta(S._Name, obj._Name); // dst table
                        // src table must exist and dst table must not exist (i.e., if it doesn't, it's been migrated previously already).
                        if (TMDest == null && TMSrc != null)
                          {
                            // Add the migration action
                            Actions.add(new TableViewSchemaSet(obj, MM._Schema));
                            // Transfer table to new schema to avoid double-creation later in this loop
                            // i.e., the table didn't exist in this schema when the database was originally scanned (DBMeta).
                            if (DBMeta.getSchemaMeta(obj._ParentSchema._Name).moveTableMetaFromOtherSchema(DBMeta, TMSrc) == false)
                              throw new Exception("An error occurred: table '" + obj._Name + "' is being moved from schema '" + MM._Schema + "' to '" + obj._ParentSchema._Name + "' but seems to already exist there even though we just tested that a second ago and found nothing!");
                          }
                      }
                    for (View v : MM._Views)
                      {
                        ViewMeta VMSrc = DBMeta.getViewMeta(MM._Schema, v._Name);
                        ViewMeta VMDest = DBMeta.getViewMeta(S._Name, v._Name);
                        // src view must exist and dst view must not exist (i.e., if it doesn't, it's been migrated previously already).
                        if (VMDest == null && VMSrc != null)
                          {
                            // Add the migration action
                            Actions.add(new TableViewSchemaSet(v, MM._Schema));
                            // Transfer view to new schema to avoid double-creation later in this loop
                            // i.e., the table didn't exist in this schema when the database was originally scanned (DBMeta).
                            if (DBMeta.getSchemaMeta(v._ParentSchema._Name).moveViewMetaFromOtherSchema(DBMeta, VMSrc) == false)
                              throw new Exception("An error occurred: view '" + v._Name + "' is being moved from schema '" + MM._Schema + "' to '" + v._ParentSchema._Name + "' but seems to already exist there even though we just tested that a second ago and found nothing!");
                          }
                      }
                  }

            if (S._Migration._Renames.isEmpty() == false)
              for (MigrationRename MR : S._Migration._Renames)
                if (MR != null)
                  {
                    if (MR._Object != null) // Renaming object of column
                      {
                        if (MR._Column != null) // renaming column
                          {
                            TableMeta TM = DBMeta.getTableMeta(MR._Schema._Name, MR._ObjectName);
                            if (TM != null)
                              {
                                List<ColumnMeta> CMSrcs = new ArrayList<ColumnMeta>();
                                for (String n : MR._OldNames)
                                  {
                                    ColumnMeta CMSrc = TM.getColumnMeta(n); // src column
                                    if (CMSrc != null)
                                      CMSrcs.add(CMSrc);
                                  }
                                ColumnMeta CMDest = TM.getColumnMeta(MR._Column.getName()); // dst column
                                // dst column must not exist and only one src column must be existing in the DB (i.e., if it doesn't, it's been migrated previously already).
                                if (CMDest == null && CMSrcs.size() == 1)
                                  {
                                    // Add the migration action
                                    Actions.add(new TableColumnRename(MR._Column, CMSrcs.get(0)._Name));
                                    // Rename table to avoid double-creation later in this loop
                                    // i.e., the table didn't exist in this schema when the database was originally scanned (DBMeta).
                                    if (DBMeta.getSchemaMeta(MR._Object._ParentSchema._Name).renameTableColumn(DBMeta, TM, CMSrcs.get(0)._Name, MR._Column.getName()) == false)
                                      throw new Exception("An error occurred: Column '" + CMSrcs.get(0)._ParentTable._SchemaName + "." + CMSrcs.get(0)._ParentTable._TableName + "." + CMSrcs.get(0)._Name + "' is being renamed to '" + MR._ColumnName + "' but seems to already exist there even though we just tested that a second ago and found nothing!");
                                  }
                              }
                          }
                        else // Only renaming an object
                          {
                            List<TableMeta> TMSrcs = new ArrayList<TableMeta>();
                            for (String n : MR._OldNames)
                              {
                                TableMeta TMSrc = DBMeta.getTableMeta(MR._Schema._Name, n); // src table
                                if (TMSrc != null)
                                  TMSrcs.add(TMSrc);
                              }
                            TableMeta TMDest = DBMeta.getTableMeta(MR._Schema._Name, MR._Object._Name); // dst table
                            // src table must exist and dst table must not exist (i.e., if it doesn't, it's been migrated previously already).
                            if (TMDest == null && TMSrcs.size() == 1)
                              {
                                // Add the migration action
                                Actions.add(new TableViewRename(MR._Object, TMSrcs.get(0)._TableName));
                                // Rename table to avoid double-creation later in this loop
                                // i.e., the table didn't exist in this schema when the database was originally scanned (DBMeta).
                                if (DBMeta.getSchemaMeta(MR._Object._ParentSchema._Name).renameTable(DBMeta, TMSrcs.get(0), MR._Object._Name) == false)
                                  throw new Exception("An error occurred: table '" + TMSrcs.get(0)._SchemaName + "." + TMSrcs.get(0)._TableName + "' is being renamed to '" + MR._Object._Name + "' but seems to already exist there even though we just tested that a second ago and found nothing!");
                              }
                          }
                      }
                    else if (MR._View != null) // renaming view
                      {
                        List<ViewMeta> VMSrcs = new ArrayList<ViewMeta>();
                        for (String n : MR._OldNames)
                          {
                            ViewMeta VMSrc = DBMeta.getViewMeta(MR._Schema._Name, n); // src view
                            if (VMSrc != null)
                              VMSrcs.add(VMSrc);
                          }
                        ViewMeta VMDest = DBMeta.getViewMeta(MR._Schema._Name, MR._View._Name); // dst view
                        // src table must exist and dst table must not exist (i.e., if it doesn't, it's been migrated previously already).
                        if (VMDest == null && VMSrcs.size() == 1)
                          {
                            // Add the migration action
                            Actions.add(new TableViewRename(MR._View, VMSrcs.get(0)._ViewName));
                            // Rename table to avoid double-creation later in this loop
                            // i.e., the table didn't exist in this schema when the database was originally scanned (DBMeta).
                            if (DBMeta.getSchemaMeta(MR._Object._ParentSchema._Name).renameView(DBMeta, VMSrcs.get(0), MR._Object._Name) == false)
                              throw new Exception("An error occurred: view '" + VMSrcs.get(0)._SchemaName + "." + VMSrcs.get(0)._ViewName + "' is being renamed to '" + MR._Object._Name + "' but seems to already exist there even though we just tested that a second ago and found nothing!");
                          }
                      }
                  }
          }

        boolean Helpers = false;
        if (S._Name.equalsIgnoreCase("TILDA") == true)
          {
            MigrationAction A = new TildaHelpersAddStart();
            if (A.isNeeded(C, DBMeta) == true)
              {
                Actions.add(A);
                Helpers = true;
              }
          }

        if (S._ExtraDDL != null && S._ExtraDDL._Before != null)
          for (String ddl : S._ExtraDDL._Before)
            {
              TildaExtraDDL A = new TildaExtraDDL(S, ddl);
              if (A.isNeeded(C, DBMeta) == true)
                Actions.add(A);
            }

        for (Object Obj : S._Objects)
          {

            if (Obj == null)
              continue;
            if (Obj._FST == FrameworkSourcedType.VIEW || Obj._Mode == ObjectMode.CODE_ONLY == true)
              continue;

            TableMeta TMeta = DBMeta.getTableMeta(Obj._ParentSchema._Name, Obj._Name);
            int DddlManagementPos = Actions.size();

            boolean NeedsDdlDependencyManagement = false;
            if (TMeta == null)
              Actions.add(new TableCreate(Obj));
            else
              {
                if (Obj._Description.equalsIgnoreCase(TMeta._Descr) == false)
                  Actions.add(new TableComment(Obj));

                ColumnAlterMulti CAM = new ColumnAlterMulti(C, Obj);

                for (Column Col : Obj._Columns)
                  {
                    if (Col == null || Col._Mode == ColumnMode.CALCULATED)
                      continue;

                    ColumnMeta CMeta = TMeta.getColumnMeta(Col.getName());
                    if (CMeta == null)
                      Actions.add(new ColumnAdd(Col));
                    else
                      {
                        if (Col._Description.equalsIgnoreCase(CMeta._Descr) == false)
                          Actions.add(new ColumnComment(Col));

                        // Check default values
                        checkDefaultValue(Actions, Col, CMeta);

                        // Check arrays
                        if (CheckArrays(DBMeta, Errors, Col, CMeta) == false)
                          continue;

                        if (Col.getType() == ColumnType.NUMERIC
                        && (CMeta._Precision != Col._Precision && (CMeta._Scale != Col._Scale || Col._Scale == 0)))
                          {
                            Actions.add(new ColumnAlterNumericSize(CMeta, Col));
                            NeedsDdlDependencyManagement = true;
                          }

                        boolean condition1 = Col.isCollection() == false
                        && (Col.getType() == ColumnType.BITFIELD && CMeta._TildaType != ColumnType.INTEGER
                        || Col.getType() == ColumnType.JSON && CMeta._TildaType != ColumnType.STRING && CMeta._TildaType != ColumnType.JSON
                        || Col.getType() != ColumnType.BITFIELD && Col.getType() != ColumnType.JSON && Col.getType() != CMeta._TildaType);


                        // We have to check if someone changed goal-posts for VARCHAR and CLOG thresholds.
                        // The case here is that we have a CHAR(10) in the database, and the model still says
                        // STRING/10, but the thresholds have changed in such a way that now, it should be in the DB
                        // as VARCHAR(10). We have to check that the "final" type from the model is consistent with
                        // the type in the DB. The previous set of checks look at fundamental type changes, for example
                        // from INT to STRING etc... But they won't catch an internal change of CHAR to VARCHAR not due to
                        // model changes, but to threshold changes.
                        boolean condition2 = Col.isCollection() == false && Col.getType() == ColumnType.STRING
                        // the database type is CHAR, but the Tilda type is not CHAR (i.e., the goal post for what is CHAR Vs VARCHAR changed)
                        && (CMeta._TypeSql.equals("CHAR") == true && C.getDBStringType(CMeta._Size) != DBStringType.CHARACTER
                        // the database type is VARCHAR but the Tilda type is CHAR (i.e., the goal post for what is CHAR Vs VARCHAR changed)
                        || CMeta._TypeSql.equals("VARCHAR") == true && C.getDBStringType(CMeta._Size) == DBStringType.CHARACTER
                        // the database type is TEXT but the Tilda type is not TEXT
                        || CMeta._TypeSql.equals("VARCHAR") == true && CMeta._TypeName.equals("text") == true && C.getDBStringType(CMeta._Size) != DBStringType.TEXT);

                        if (condition1 || condition2)
                          {
                            // Are the to/from types compatible?
                            if (Col.getType().isDBCompatible(CMeta._TildaType) == false)
                              throw new Exception("Type incompatbility requested for an alter column " + Col.getShortName() + ": cannot alter from " + CMeta._TildaType + " to " + Col.getType() + ".");

                            CAM.addColumnAlterType(CMeta, Col);
                            NeedsDdlDependencyManagement = true;
                          }
                        // Else, we could still have a size change and stay within a single STRING DB type
                        else if (!condition2 && Col.isCollection() == false && Col.getType() == ColumnType.STRING)
                          {
                            // The size-based types don't match
                            if (C.getDBStringType(CMeta._Size).equals(C.getDBStringType(Col._Size)) == false
                            // or they match and they are different sizes, except for TEXT
                            || C.getDBStringType(CMeta._Size).equals(C.getDBStringType(Col._Size)) == true
                            && CMeta._Size != Col._Size
                            // Unless it's a size change but remains within TEXT
                            && (CMeta._TypeSql.equals("VARCHAR") == false || CMeta._TypeName.equals("text") == false))
                              {
                                CAM.addColumnAlterStringSize(CMeta, Col);
                                NeedsDdlDependencyManagement = true;
                              }
                          }
                        if (CMeta._Nullable == 1 && Col._Nullable == false || CMeta._Nullable == 0 && Col._Nullable == true)
                          Actions.add(new ColumnAlterNull(Col));
                      }
                  }
                if (CAM.isEmpty() == false)
                  Actions.add(CAM);

                if (NeedsDdlDependencyManagement == true)
                  {
                    DDLDependencyManager DdlDepMan = new DDLDependencyManager(Obj._ParentSchema._Name, Obj._Name, TildaList);
                    MigrationAction A = new DDLDependencyPreManagement(DdlDepMan);
                    if (A.isNeeded(C, DBMeta) == true)
                      {
                        Actions.add(DddlManagementPos, A);
                        Actions.add(new DDLDependencyPostManagement(DdlDepMan));
                      }
                  }
                if (Obj._PrimaryKey != null && Obj._PrimaryKey._Autogen == true && KeysManager.hasKey(Obj.getShortName().toUpperCase()) == false)
                  Actions.add(new TableKeyCreate(Obj));
                Set<String> DroppedFKs = new HashSet<String>();
                if (DifferentPrimaryKeys(Obj._PrimaryKey, TMeta._PrimaryKey) == true)
                  {
                    for (FKMeta fk : TMeta._ForeignKeysIn.values())
                      {
                        Object OtherObj = CheckForeignKeys(TildaList, Errors, Obj, fk);
                        if (OtherObj == null)
                          continue;
                        Actions.add(new TableFKDrop(OtherObj, fk));
                        DroppedFKs.add(fk.getSignature());
                      }
                    Actions.add(new TablePKReplace(Obj, TMeta));
                  }

                // Checking any FK defined in the DB which are not in the Model, so they can be dropped.
                for (FKMeta fk : TMeta._ForeignKeysOut.values())
                  {
                    boolean Found = false;
                    String Sig = fk.getSignature();
                    // LOG.debug("Checking db FK " + Sig + ".");
                    for (ForeignKey FK : Obj._ForeignKeys)
                      {
                        // LOG.debug("Checking model FK " + FK.getSignature() + ".");
                        if (Sig.equals(FK.getSignature()) == true)
                          {
                            Found = true;
                            break;
                          }
                      }
                    if (Found == false && DroppedFKs.contains(fk.getSignature()) == false)
                      Actions.add(new TableFKDrop(Obj, fk));
                  }
                // Checking any FK defined in the Model which are not in the DB, so they can be added.
                for (ForeignKey FK : Obj._ForeignKeys)
                  {
                    boolean Found = false;
                    String Sig = FK.getSignature();
                    for (FKMeta fk : TMeta._ForeignKeysOut.values())
                      if (Sig.equals(fk.getSignature()) == true)
                        {
                          Found = true;
                          break;
                        }
                    if (Found == false)
                      Actions.add(new TableFKAdd(FK));
                  }

                /*
                 * for (String c : Obj._DropOldColumns)
                 * {
                 * ColumnMeta CI = TMeta.getColumnMeta(c);
                 * Column Col = Obj.getColumn(c);
                 * if (Col == null && CI != null)
                 * Actions.add(new ColumnDrop(Obj, c));
                 * }
                 */
                // if (XXX != Actions.size())
                // Actions.add(new CommitPoint());

                // Cleaning any Indices that share the same signature, but differing names. Cleaning up Indices that are not unique, but share a name defined in the schema.
                Set<String> DroppedSignatures = new HashSet<String>(); // Dropped Signatures
                for (Index IX : Obj._Indices)
                  {
                    if (IX == null || IX._Db == false)
                      continue;
                    for (IndexMeta ix : TMeta._Indices.values())
                      {
                        if (IX.getSignature().equals(ix.getSignature())
                        && !ix._Name.toLowerCase().equals(TMeta._TableName.toLowerCase() + "_pkey"))
                          {
                            if (ix._Unique
                            && (ix._Name.equals(ix._Name.toLowerCase()) == false
                            || ix._Name.equalsIgnoreCase(IX.getName()) == false))
                              // The actual rename will happen in the next loop, so we just mark the index signature as dropped.
                              DroppedSignatures.add(ix.getSignature());
                            // catches duplicate signatures by different names in db. First will be renamed below
                            else if (DroppedSignatures.add(ix.getSignature()) == false)
                              Actions.add(new TableIndexDrop(Obj, ix));
                          }
                      }
                  }

                // Checking any Indices which are not in the DB, so they can be added.
                for (Index IX : Obj._Indices)
                  {
                    if (IX == null || IX._Db == false)
                      continue;
                    boolean Found = false;
                    String Sig = IX.getSignature();

                    for (IndexMeta ix : TMeta._Indices.values())
                      {
                        if (!ix._Name.toLowerCase().equals(TMeta._TableName.toLowerCase() + "_pkey"))
                          {
                            String Sig1 = ix.getSignature();

                            if (Sig.equals(Sig1) == true && DroppedSignatures.add(ix.getSignature()) == false)
                              {
                                Found = true;
                                if (ix._Name.equals(ix._Name.toLowerCase()) == false // name in the DB is not lowercase, i.e., case insensitive
                                || ix._Name.equalsIgnoreCase(IX.getName()) == false // same sig, but new index name
                                )
                                  {
                                    if (TMeta._Indices.containsKey(IX.getName().toLowerCase()))
                                      Errors.add("Index " + ix._Name + " is attempting to be renamed to " + IX.getName() + " but an index with that name already exists with a different signature in the database");

                                    Actions.add(new TableIndexRename(Obj, ix._Name, IX.getName()));
                                  }
                                break;
                              }
                          }
                      }
                    if (Found == false)
                      {
                        IndexMeta IMeta = TMeta.getIndexMeta(IX.getName()); // Try case-sensitive fashion
                        IndexMeta IMeta2 = TMeta.getIndexMeta(IX.getName().toLowerCase()); // Try case-insensitive fashion
                        if (IMeta != null && IMeta2 != null)
                          Actions.add(new TableIndexDrop(Obj, IMeta));
                        if (IMeta2 != null)
                          Actions.add(new TableIndexDrop(Obj, IMeta2));
                        Actions.add(new TableIndexAdd(IX));
                      }
                  }
              }
          }
        for (View V : S._Views)
          {
            if (V == null)
              continue;

            ViewMeta VMeta = DBMeta.getViewMeta(V._ParentSchema._Name, V._Name);
            if (VMeta == null)
              {
                // The view doesn't exist, but maybe parallel dependencies do, most of the time
                // when a migration failed for whatever reason. Even though we just tested whether
                // the view exists, we still want to drop it. The drop implementation does do an
                // "if exists" so it's safe.
                Actions.add(new ViewDrop(V));
                Actions.add(new ViewCreate(V));
              }
            else
              {
                StringBuilderWriter Out = new StringBuilderWriter();
                CGSQL.genDDL(new PrintWriter(Out), V);
                String ViewDef = Out.toString();
                Out.close();
                if (VMeta._Descr == null || VMeta._Descr.replace("\r\n", " ").replace("\n", " ").trim().equals(ViewDef.replace("\r\n", " ").replace("\n", " ").trim()) == false)
                  {
                    // If this view depends on another realized view, either directly or indirectly, then a parallel *_R view
                    // was created. When migrating, we have to take care of those 2 views.

                    // Main view
                    DDLDependencyManager DdlDepMan = null;
                    DdlDepMan = new DDLDependencyManager(V._ParentSchema._Name, V._Name, TildaList);
                    MigrationAction A = new DDLDependencyPreManagement(DdlDepMan);
                    if (A.isNeeded(C, DBMeta) == true)
                      Actions.add(A);
                    else
                      DdlDepMan = null;

                    /*
                     * // Test if there is an _R view
                     * DDLDependencyManager DdlDepMan_R = null;
                     * if (V.hasAncestorRealizedViews() == true)
                     * {
                     * DdlDepMan_R = new DDLDependencyManager(V.getViewSubRealizeSchemaName(), V.getViewSubRealizeViewName());
                     * A = new DDLDependencyPreManagement(DdlDepMan_R);
                     * if (A.isNeeded(C, DBMeta) == true)
                     * Actions.add(A);
                     * else // _R view was not there (maybe a previous failure, or some other weird thing)
                     * DdlDepMan_R = null;
                     * }
                     */
                    Actions.add(new ViewDrop(V));
                    Actions.add(new ViewCreate(V));

                    if (DdlDepMan != null)
                      Actions.add(new DDLDependencyPostManagement(DdlDepMan));
                    // if (DdlDepMan_R != null)
                    // Actions.add(new DDLDependencyPostManagement(DdlDepMan_R));
                  }
              }
          }

        if (S._ExtraDDL != null && S._ExtraDDL._After != null)
          for (String ddl : S._ExtraDDL._After)
            {
              MigrationAction A = new TildaExtraDDL(S, ddl);
              if (A.isNeeded(C, DBMeta) == true)
                Actions.add(A);
            }

        if (Helpers == true)
          {
            Actions.add(new TildaHelpersAddEnd());
          }

        if (Errors.isEmpty() == false)
          {
            StringBuilder Str = new StringBuilder();
            Str.append("\n\nDatabase couldn't be migrated because of errors found:\n");
            for (int i = 0; i < Errors.size(); ++i)
              Str.append("     " + (i + 1) + ": " + Errors.get(i) + ".\n");
            throw new Exception(Str.toString());
          }
        return Actions;
      }


    private static List<MigrationDrops> getDropScripts(Connection C, CodeGenSql SQlCodeGen, Schema s, DatabaseMeta DBMeta)
      {
        List<MigrationDrops> drops = new ArrayList<MigrationDrops>();
        if (s._Dynamic == true)
          return drops;
        SchemaMeta sm = DBMeta.getSchemaMeta(s.getShortName());
        if (sm != null)
          {
            for (TableMeta tm : sm.getTableMetas())
              {
                Object obj = s.getObject(tm._TableName);
                if (obj == null)
                  drops.add(new tilda.migration.drops.TableDrop(tm));
                else
                  {
                    // for (IndexMeta im : tm.getIndexMetas())
                    // if (obj.getIndex(im._Name) == null)
                    // drops.add(new tilda.migration.drops.IndexDrop(im));
                    for (ColumnMeta cm : tm.getColumnMetaList())
                      if (obj.getColumn(cm._NameOriginal) == null)
                        drops.add(new tilda.migration.drops.ColumnDrop(cm));
                  }
              }
            for (ViewMeta vm : sm.getViewMetas())
              if (s.getView(vm._ViewName) == null)
                drops.add(new tilda.migration.drops.ViewDrop(vm));
          }
        return drops;
      }


    private static void checkDefaultValue(List<MigrationAction> Actions, Column Col, ColumnMeta CMeta)
    throws Exception
      {
        // Default values are a pain because (1) typing, and (2) the DB often rewrites the values. Therefore
        // we have to some unholy gymnastics here. It's also hard-coded to Postgres knowledge here, which should be
        // fixed when going multi-db.
        String defaultValue = Col._DefaultCreateValue == null
        ? null
        : Col.getType() == ColumnType.DATE || Col.getType() == ColumnType.DATETIME || Col.getType() == ColumnType.CHAR || Col.getType() == ColumnType.STRING
        ? ValueHelper.printValue(Col.getName(), Col.getType(), Col._DefaultCreateValue._Value)
        : Col._DefaultCreateValue._Value;
        String defaultValueDB = CMeta._Default;
        if (defaultValueDB != null)
          {
            // This section seems to be fairly Postgres-specific. This would need to eventually be abstracted away
            // to support other databases' possible formats of default values.
            int i = defaultValueDB.lastIndexOf("::");
            if (i != -1)
              defaultValueDB = defaultValueDB.substring(0, i);
            if (ColumnType.isNumber(Col.getType()) == true)
              {
                if (defaultValueDB.startsWith("'") == true)
                  defaultValueDB = defaultValueDB.substring(1);
                if (defaultValueDB.endsWith("'") == true)
                  defaultValueDB = defaultValueDB.substring(0, defaultValueDB.length() - 1);
              }
          }
        // The "UNDEFINED" value is 1111-11-11, but with timezones, it can change inside the database. So we truncate to 9 characters so we get '1111-11-1'
        if (Col.getType() == ColumnType.DATE || Col.getType() == ColumnType.DATETIME)
          if (Col._DefaultCreateValue != null && Col._DefaultCreateValue._Value.equalsIgnoreCase("UNDEFINED") == true && defaultValueDB != null && defaultValueDB.length() > 9)
            {
              defaultValue = defaultValue.substring(0, 10);
              defaultValueDB = defaultValueDB.substring(0, 10);
            }
        if (defaultValue == null && defaultValueDB != null
        || defaultValue != null && defaultValue.equals(defaultValueDB) == false)
          Actions.add(new ColumnDefault(Col));
      }

    private static Object CheckForeignKeys(List<Schema> TildaList, List<String> Errors, Object Obj, FKMeta fk)
      {
        Object OtherObj = Schema.getObject(TildaList, fk._OtherSchema, fk._OtherTable);
        if (OtherObj == null)
          {
            Errors.add("The table " + Obj.getFullName() + " is changing its primary key, and a dependent table " + fk._OtherSchema + "." + fk._OtherTable + " seems to exist in the database outside of the application's data model. As a reult, migration cannot happen automatically for that dependent table.");
            return null;
          }
        return OtherObj;
      }

    private static boolean CheckArrays(DatabaseMeta DBMeta, List<String> Errors, Column Col, ColumnMeta CMeta)
      {
        if (DBMeta.supportsArrays() == true)
          {
            if (CMeta.isArray() == false && Col.isCollection() == true && Col.getType() != ColumnType.JSON)
              {
                Errors.add("The application's data model defines the column '" + Col.getShortName() + "' as an array, but it's not an array in the DB. The database needs to be migrated manually.");
                return false;
              }
            else if (CMeta.isArray() == true && (Col.isCollection() == false || Col.getType() == ColumnType.JSON))
              {
                Errors.add("The application's data model defines the column '" + Col.getShortName() + "' as an base type, but it's an array in the DB. The database needs to be migrated manually.");
                return false;
              }
          }
        return true;
      }

    private static boolean DifferentPrimaryKeys(PrimaryKey PK1, PKMeta PK2)
      {
        if (PK1 == null && PK2 == null) // No PKs
          return false;

        if (PK1 == null || PK2 == null) // Adding or removing a PK
          return true;

        if (PK1._Columns.length != PK2._Columns.size()) // Different size PKs
          return true;

        for (int i = 0; i < PK1._Columns.length; ++i)
          if (PK1._Columns[i].equals(PK2._Columns.get(i)) == false)
            return true; // different column

        return false; // same PKs
      }
  }
