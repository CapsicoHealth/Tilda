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
import tilda.db.metadata.TableMeta;
import tilda.db.metadata.ViewMeta;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
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
import tilda.migration.actions.TableFKAdd;
import tilda.migration.actions.TableFKDrop;
import tilda.migration.actions.TableIndexAdd;
import tilda.migration.actions.TableIndexDrop;
import tilda.migration.actions.TableIndexRename;
import tilda.migration.actions.TableKeyCreate;
import tilda.migration.actions.TablePKReplace;
import tilda.migration.actions.TildaAclAdd;
import tilda.migration.actions.TildaExtraDDL;
import tilda.migration.actions.TildaHelpersAdd;
import tilda.migration.actions.ViewCreate;
import tilda.migration.actions.ViewUpdate;
import tilda.parsing.Parser;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.PrimaryKey;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.utils.AsciiArt;
import tilda.utils.FileUtil;

public class Migrator
  {
    protected static final Logger LOG                 = LogManager.getLogger(Parser.class.getName());

    public static final String    TILDA_VERSION       = "1.0";
    public static final String    TILDA_VERSION_VAROK = "1_0";

    public static void MigrateDatabase(Connection C, boolean CheckOnly, List<Schema> TildaList, DatabaseMeta DBMeta, boolean first, List<String> connectionUrls)
    throws Exception
      {
        MigrationDataModel migrationData = Migrator.AnalyzeDatabase(C, CheckOnly, TildaList, DBMeta);

        if (migrationData.getActionCount() == 0)
          {
            if (CheckOnly == false)
              {
                MigrationAction A = new TildaHelpersAdd();
                if (A.isNeeded(C, DBMeta) == true)
                  {
                    A.process(C);
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
            PrintDiscrepancies(C, migrationData);
            confirmMigration(C);
            applyMigration(C, migrationData);
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

    public static void PrintDiscrepancies(Connection C, MigrationDataModel migrationData)
      {
        LOG.info("");
        LOG.warn("There were " + migrationData.getActionCount() + " discrepencies found between the application's required data model and the database " + C.getPoolName() + ".");
        LOG.info("");
        int counter = 0;
        for (MigrationScript S : migrationData.getMigrationScripts())
          for (MigrationAction MA : S._Actions)
            {
              if (MA._isDependency == false)
                LOG.warn("    " + (++counter) + " - " + MA.getDescription() + ".");
              else
                LOG.debug("    - (dependency) " + MA.getDescription() + ".");
            }
      }

    public static MigrationDataModel AnalyzeDatabase(Connection C, boolean CheckOnly, List<Schema> TildaList, DatabaseMeta DBMeta)
    throws Exception
      {
        List<MigrationScript> Scripts = new ArrayList<MigrationScript>();
        int ActionCount = 0;

        // if (CheckOnly == false && Migrate.isTesting() == false)
        // AddTildaHelpers(C, TildaList, DBMeta);

        LOG.info("===> Analyzing DB ( Url: " + C.getPoolName() + " )");
        LOG.info("Analyzing differences between the database and the application's expected data model...");
        MigrationScript InitScript = new MigrationScript(null, new ArrayList<MigrationAction>());
        for (Schema S : TildaList)
          if (S._Views.isEmpty() == false)
            InitScript._Actions.add(new SchemaViewsDrop(S));
        Scripts.add(InitScript);
        for (Schema S : TildaList)
          {
            if (S.getShortName().contentEquals("PATIENTS") == true)
              LOG.debug("xxx");
            List<MigrationAction> L = Migrator.getMigrationActions(C, C.getSQlCodeGen(), S, TildaList, DBMeta);
            for (MigrationAction MA : L)
              if (MA._isDependency == false)
                ++ActionCount;
            if (S._Name.equalsIgnoreCase("TILDA") == true)
              {
                MigrationAction A = new TildaHelpersAdd();
                if (A.isNeeded(C, DBMeta) == true)
                  L.add(A);
              }
            if (S._ExtraDDL != null && S._ExtraDDL._After != null)
              for (String ddl : S._ExtraDDL._After)
                {
                  MigrationAction A = new TildaExtraDDL(S, ddl);
                  if (A.isNeeded(C, DBMeta) == true)
                    L.add(A);
                }
            Scripts.add(new MigrationScript(S, L));
          }
        return new MigrationDataModel(ActionCount, Scripts);
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

    protected static void applyMigration(Connection C, MigrationDataModel migrationData)
    throws Exception
      {
        LOG.info("===> Migrating DB ( Url: " + C.getURL() + " )");
        LOG.info("Applying migration actions.");
        for (MigrationScript S : migrationData.getMigrationScripts())
          {
            if (S._Actions.isEmpty() == true)
              continue;
            for (MigrationAction A : S._Actions)
              {
                if (A.process(C) == false)
                  throw new Exception("There was an error with the action '" + A.getDescription() + "'.");
                if (Migrate.isTesting() == false)
                  C.commit();
              }
          }
      }

    protected static List<MigrationAction> getMigrationActions(Connection C, CodeGenSql CGSQL, Schema S, List<Schema> TildaList, DatabaseMeta DBMeta)
    throws Exception
      {
        LOG.info("Comparing the application's data model with the database's for " + S.getFullName());

        List<MigrationAction> Actions = new ArrayList<MigrationAction>();
        List<String> Errors = new ArrayList<String>();

        if (DBMeta.getSchemaMeta(S._Name) == null)
          Actions.add(new SchemaCreate(S));

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
            if (Obj._FST == FrameworkSourcedType.VIEW)
              continue;
            TableMeta TMeta = DBMeta.getTableMeta(Obj._ParentSchema._Name, Obj._Name);
            if (TMeta == null)
              Actions.add(new TableCreate(Obj));
            else
              {
                if (Obj._Description.equalsIgnoreCase(TMeta._Descr) == false)
                  Actions.add(new TableComment(Obj));
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

                        if (CheckArrays(DBMeta, Errors, Col, CMeta) == false)
                          continue;

                        if (Col.isCollection() == false
                        && (Col.getType() == ColumnType.BITFIELD && CMeta._TildaType != ColumnType.INTEGER
                        || Col.getType() == ColumnType.JSON && CMeta._TildaType != ColumnType.STRING && CMeta._TildaType != ColumnType.JSON
                        || Col.getType() != ColumnType.BITFIELD && Col.getType() != ColumnType.JSON && Col.getType() != CMeta._TildaType))
                          Actions.add(new ColumnAlterType(C, CMeta, Col));

                        // We have to check if someone changed goal-posts for VARCHAR and CLOG threasholds.
                        // The case here is that we have a CHAR(10) in the database, and the model still says
                        // STRING/10, but the thresholds have changed in such a way that now, it should be in the DB
                        // as VARCHAR(10). We have to check that the "final" type from the model is consistent with
                        // the type in the DB. The previous set of checks look at fundamental type changes, for example
                        // from INT to STRING etc... But they won't catch an internal change of CHAR to VARCHAR not due to
                        // model changes, but to threshold changes.
                        if (Col.isCollection() == false && Col.getType() == ColumnType.STRING
                        && (CMeta._TypeSql.equals("CHAR") == true && C.getDBStringType(Col._Size) != DBStringType.CHARACTER
                        || CMeta._TypeSql.equals("VARCHAR") == true && C.getDBStringType(CMeta._Size) == DBStringType.CHARACTER))
                          Actions.add(new ColumnAlterType(C, CMeta, Col));
                        // Else, we could still have a size change and stay within a single STRING DB type
                        else if (Col.isCollection() == false && Col.getType() == ColumnType.STRING)
                          {
                            DBStringType DBStrType = C.getDBStringType(CMeta._Size);
                            if (DBStrType != DBStringType.TEXT && CMeta._Size != Col._Size)
                              Actions.add(new ColumnAlterStringSize(CMeta, Col));
                          }
                        if (CMeta._Nullable == 1 && Col._Nullable == false || CMeta._Nullable == 0 && Col._Nullable == true)
                          Actions.add(new ColumnAlterNull(Col));
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
                        Actions.add(new TableFKDrop(OtherObj, Obj, fk));
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
                      Actions.add(new TableFKDrop(Obj, null, fk));
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
                Set<String> Signatures = new HashSet<String>();
                for (Index IX : Obj._Indices)
                  {
                    if (IX._Db)
                      {
                        for (IndexMeta ix : TMeta._Indices.values())
                          {
                            if (IX.getSignature().equals(ix.getSignature())
                            && !ix._Name.toLowerCase().equals(TMeta._TableName.toLowerCase() + "_pkey"))
                              {
                                if (ix._Unique
                                && (ix._Name.equals(ix._Name.toLowerCase()) == false
                                || ix._Name.equalsIgnoreCase(IX.getName()) == false))
                                  {
                                    Errors.add("Index " + ix._Name + " is unique and contains the same signature as " + IX.getName() + " in the " + IX._Parent._Name + " schema definition");
                                  }
                                else if (Signatures.add(ix.getSignature()) == false) // catches duplicate signatures by different names in db. First will be renamed below
                                  Actions.add(new TableIndexDrop(Obj, ix));
                              }
                          }
                      }
                  }

                // Checking any Indices which are not in the DB, so they can be added.
                for (Index IX : Obj._Indices)
                  {
                    if (IX._Db)
                      {
                        boolean Found = false;
                        String Sig = IX.getSignature();

                        for (IndexMeta ix : TMeta._Indices.values())
                          {
                            if (!ix._Name.toLowerCase().equals(TMeta._TableName.toLowerCase() + "_pkey"))
                              {
                                String Sig1 = ix.getSignature();

                                if (Sig.equals(Sig1) == true)
                                  {
                                    Found = true;
                                    if (ix._Name.equals(ix._Name.toLowerCase()) == false // name in the DB is not lowercase, i.e., case insensitive
                                    || ix._Name.equalsIgnoreCase(IX.getName()) == false // same sig, but new index name
                                    )
                                      {
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
                CGSQL.genDDL(new PrintWriter(Out), V);
                String ViewDef = Out.toString();
                Out.close();
                if (VMeta._Descr == null || VMeta._Descr.replace("\r\n", " ").replace("\n", " ").trim().equals(ViewDef.replace("\r\n", " ").replace("\n", " ").trim()) == false)
                  Actions.add(new ViewUpdate(V, false));
                else
                  Actions.add(new ViewUpdate(V, true));
              }
          }

        if (Errors.isEmpty() == false)
          {
            LOG.error("Errors were found when putting together a migration script:");
            for (int i = 0; i < Errors.size(); ++i)
              LOG.error("   " + (i + 1) + ": " + Errors.get(i) + ".");
            throw new Exception("Database couldn't be migrated.");
          }
        return Actions;
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
