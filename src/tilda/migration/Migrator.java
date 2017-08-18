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

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.KeysManager;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.DatabaseMeta;
import tilda.db.metadata.TableMeta;
import tilda.db.metadata.ViewMeta;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.migration.actions.ColumnAdd;
import tilda.migration.actions.ColumnAlterNull;
import tilda.migration.actions.ColumnAlterStringSize;
import tilda.migration.actions.ColumnAlterType;
import tilda.migration.actions.ColumnComment;
import tilda.migration.actions.SchemaCreate;
import tilda.migration.actions.SchemaViewsDrop;
import tilda.migration.actions.TableComment;
import tilda.migration.actions.TableCreate;
import tilda.migration.actions.TableKeyCreate;
import tilda.migration.actions.TildaHelpersAdd;
import tilda.migration.actions.ViewCreate;
import tilda.migration.actions.ViewUpdate;
import tilda.parsing.Parser;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;

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

//        if (CheckOnly == false)
//          {
//            new TildaHelpersAdd().process(C);
//            C.commit();
//          }

        LOG.info("Analyzing differences between the database and the application's expected data model...");
        MigrationScript InitScript = new MigrationScript(null, new ArrayList<MigrationAction>());
        for (Schema S : TildaList)
          if (S._Views.isEmpty() == false)
            InitScript._Actions.add(new SchemaViewsDrop(S));
        Scripts.add(InitScript);
        for (Schema S : TildaList)
          {
            List<MigrationAction> L = Migrator.getMigrationActions(C.getSQlCodeGen(), S, DBMeta);
            for (MigrationAction MA : L)
              if (MA._isDependency == false)
                ++ActionCount;
            if (S._Name.equalsIgnoreCase("TILDA") == true)
             L.add(new TildaHelpersAdd());
            Scripts.add(new MigrationScript(S, L));
          }

        if (ActionCount > 0)
          {
            LOG.warn("There were " + ActionCount + " discrepencies found in the database Vs. the application's required data model:");
            int xxx = 0;
            for (MigrationScript S : Scripts)
              for (MigrationAction MA : S._Actions)
                {
                  if (MA._isDependency == false)
                    LOG.warn("    " + (++xxx) + " - " + MA.getDescription() + ".");
                  else
                    LOG.debug("    - (dependency) " + MA.getDescription() + ".");
                }
            if (CheckOnly == false)
              {
                LOG.info("!!! THIS UTILITY IS ABOUT TO CHANGE DATA IN YOUR DATABASE. MAKE SURE YOU HAVE A BACKUP. !!!");
                LOG.info(" ===> " + C.getURL());
                LOG.info("");
                LOG.info("Press 'yes' followed by enter to continue.");
                Scanner scanner = null;
                try
                  {
                    scanner = new Scanner(System.in);
                    String answer = scanner.next();
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
                finally
                  {
                    if (scanner != null)
                      scanner.close();
                  }
                LOG.info("Applying migration actions.");
                for (MigrationScript S : Scripts)
                  {
                    if (S._Actions.isEmpty() == true)
                      continue;
                    for (MigrationAction A : S._Actions)
                      {
                        if (A.process(C) == false)
                          throw new Exception("There was an error with the action '" + A.getDescription() + "'.");
                        C.commit();
                      }
                    // C.commit();
                  }
              }
          }

        if (ActionCount == 0)
          {
            new TildaHelpersAdd().process(C);
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
        else
          {
            LOG.warn("");
            LOG.warn("");
            LOG.warn("==========================================================================================================");
            LOG.warn("===  The database DOES NOT match the Application's data model. The application may NOT run properly!   ===");
            LOG.warn("==========================================================================================================");
            LOG.warn("");
          }
      }

    protected static List<MigrationAction> getMigrationActions(CodeGenSql CGSQL, Schema S, DatabaseMeta DBMeta)
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
                if (Obj._Description.equalsIgnoreCase(TMeta._Descr) == false)
                  Actions.add(new TableComment(Obj));
                if (Obj._PrimaryKey != null && Obj._PrimaryKey._Autogen == true && KeysManager.hasKey(Obj.getShortName()) == false)
                  Actions.add(new TableKeyCreate(Obj));
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

                        if (CMeta._Nullable == 1 && Col._Nullable == false || CMeta._Nullable == 0 && Col._Nullable == true)
                          Actions.add(new ColumnAlterNull(Col));

                        if (DBMeta.supportsArrays() == true)
                          {
                            if (CMeta.isArray() == false && Col.isCollection() == true && Col.getType() != ColumnType.JSON)
                              throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as an array, but it's not an array in the DB. The database needs to be migrated manually.");
                            else if (CMeta.isArray() == true && (Col.isCollection() == false || Col.getType() == ColumnType.JSON))
                              throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as an base type, but it's an array in the DB. The database needs to be migrated manually.");
                          }

                        if (Col.getType() == ColumnType.STRING && Col.isCollection() == false
                        && (CMeta._Size < DBMeta.getCLOBThreshhold() && CMeta._Size != Col._Size
                        || CMeta._Size >= DBMeta.getCLOBThreshhold() && Col._Size < DBMeta.getCLOBThreshhold()))
                          Actions.add(new ColumnAlterStringSize(Col, CMeta._Size));

                        if (Col.isCollection() == false
                        && (Col.getType() == ColumnType.BITFIELD && CMeta._TildaType != ColumnType.INTEGER
                        || Col.getType() == ColumnType.JSON && CMeta._TildaType != ColumnType.STRING && CMeta._TildaType != ColumnType.JSON
                        || Col.getType() != ColumnType.BITFIELD && Col.getType() != ColumnType.JSON && Col.getType() != CMeta._TildaType))
                          Actions.add(new ColumnAlterType(Col, CMeta._TildaType));
                      }
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
              }
          }
        for (View V : S._Views)
          {
            if (V == null)
              continue;
            ViewMeta VMeta = DBMeta.getViewMeta(V._ParentSchema._Name, V._Name);
            if (VMeta == null)
              Actions.add(new ViewCreate(V, false));
            else
              {
                StringBuilderWriter Out = new StringBuilderWriter();
                String ViewDef = CGSQL.genDDL(new PrintWriter(Out), V);
                Out.close();
                if (VMeta._Descr == null || VMeta._Descr.replace("\r\n", " ").replace("\n", " ").trim().equals(ViewDef.replace("\r\n", " ").replace("\n", " ").trim()) == false)
                  Actions.add(new ViewUpdate(V, false));
                else
                  Actions.add(new ViewUpdate(V, true));
              }
          }

        return Actions;
      }
  }
