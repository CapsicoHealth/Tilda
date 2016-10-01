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

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.ZoneInfo_Factory;
import tilda.db.Connection;
import tilda.db.KeysManager;
import tilda.db.MasterFactory;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.DatabaseMeta;
import tilda.db.metadata.TableMeta;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.Parser;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.utils.AnsiUtil;

public class Migrator
  {
    protected static final Logger LOG                 = LogManager.getLogger(Parser.class.getName());

    public static final String    TILDA_VERSION       = "1.0";
    public static final String    TILDA_VERSION_VAROK = "1_0";

    public static void logMigrationWarning()
      {
        LOG.warn("     " + AnsiUtil.NEGATIVE + "Migration was not activated in the tilda.config file: THE APPLICATION MAY NOT FUNCTION PROPERLY" + AnsiUtil.NEGATIVE_OFF + "!");
      }

    public static int migrate(Connection C, Schema S, DatabaseMeta DBMeta, boolean Migrate)
    throws Exception
      {
        LOG.debug("");
        LOG.debug("");
        LOG.debug("Evaluating differences between the application data model and the existing data schema in the database");
        CodeGenSql Sql = C.getSQlCodeGen();
        ParserSession PS = new ParserSession(S, Sql);
        int warnings = 0;

        if (Parser.loadDependencies(PS, S) == true)
          {
            // Some DBs, such as Postgres, don't allow to alter a column that's reused as part of a view. So in order to
            // prepare, we can drop all views.
            if (Migrate == true)
              {
                boolean DbAction = false;
                for (View V : S._Views)
                  {
                    if (DBMeta.getViewMeta(V._ParentSchema._Name, V._Name) != null)
                      {
                        if (C.dropView(V) == false)
                          throw new Exception("Cannot upgrade schema by dropping the old view '" + V.getShortName() + "'.");
                        DbAction = true;
                      }
                  }
                if (DbAction == true)
                  C.commit();
              }
            else
              {
                for (View V : S._Views)
                  {
                    if (DBMeta.getViewMeta(V._ParentSchema._Name, V._Name) != null)
                      {
                        LOG.info("The application's data model defines the view '" + V.getShortName() + "' which cannot be found in the database. Trying to create it...");
                        logMigrationWarning();
                        ++warnings;
                      }
                  }
              }
            for (Object Obj : S._Objects)
              {
                MasterFactory.register(S._Package, Obj);
                if (Obj._FST == FrameworkSourcedType.VIEW)
                  continue;
                if (DBMeta.getTableMeta(Obj._ParentSchema._Name, Obj._Name) == null)
                  {
                    LOG.info("The application's data model defines the table '" + Obj.getShortName() + "' which cannot be found in the database. Trying to create it...");
                    if (Migrate == false)
                      {
                        logMigrationWarning();
                        ++warnings;
                        continue;
                      }
                    else if (C.createTable(Obj) == false)
                      throw new Exception("Cannot upgrade schema by adding the new table '" + Obj.getShortName() + "'.");
                    C.commit();
                    DBMeta.load(C, Obj._ParentSchema._Name, Obj._Name);
                  }
                else if (Obj._PrimaryKey != null && Obj._PrimaryKey._Autogen == true && KeysManager.hasKey(Obj.getShortName()) == false)
                  {
                    LOG.info("The application's data model defines the table '" + Obj.getShortName() + "' with an auto-gen primary key but no entry in the TILDA.KEY table to track it can be found. Trying to create it...");
                    if (Migrate == false)
                      {
                        logMigrationWarning();
                        ++warnings;
                      }
                    else
                      {
                        if (C.createKeysEntry(Obj) == false)
                          throw new Exception("Cannot upgrade the schema by adding a new entry for '" + Obj.getShortName() + "' in the TILDA.KEY table.");
                      }
                  }
                TableMeta TMeta = DBMeta.getTableMeta(Obj._ParentSchema._Name, Obj._Name);
                for (Column Col : Obj._Columns)
                  {
                    if (Col == null)
                      continue;
                    if (Col._Mode == ColumnMode.CALCULATED)
                      continue;
                    ColumnMeta CI = TMeta.getColumnMeta(Col.getName());
                    boolean didSomething = false;
                    if (CI == null)
                      {
                        LOG.info("The application's data model defines the column '" + Col.getShortName() + "' which cannot be found in the database. Trying to create it...");
                        if (Migrate == false)
                          {
                            logMigrationWarning();
                            ++warnings;
                            continue;
                          }
                        else if (C.alterTableAddColumn(Col, Col._DefaultCreateValue == null ? null : Col._DefaultCreateValue._Value) == false)
                          throw new Exception("Cannot upgrade table '" + Obj.getShortName() + "' by adding the new required column '" + Col.getShortName() + "'.");
                        didSomething = true;
                      }
                    else
                      {
                        if (CI._Nullable == 1 && Col._Nullable == false)
                          {
                            LOG.info("The application's data model defines the column '" + Col.getShortName() + "' as not nullable, but it's nullable in the DB. Trying to alter it...");
                            if (Migrate == false)
                              {
                                logMigrationWarning();
                                ++warnings;
                                continue;
                              }
                            else if (C.alterTableAlterColumnNull(Col, Col._DefaultCreateValue == null ? null : Col._DefaultCreateValue._Value) == false)
                              throw new Exception("Cannot upgrade table '" + Obj.getShortName() + "' by updating the column '" + Col.getShortName() + "' from nullable to not nullable.");
                            didSomething = true;
                          }
                        else if (CI._Nullable == 0 && Col._Nullable == true)
                          {
                            LOG.info("The application's data model defines the column '" + Col.getShortName() + "' as nullable, but it's not nullable in the DB. Trying to alter it...");
                            if (Migrate == false)
                              {
                                logMigrationWarning();
                                ++warnings;
                                continue;
                              }
                            else if (C.alterTableAlterColumnNull(Col, null) == false)
                              throw new Exception("Cannot upgrade table '" + Obj.getShortName() + "' by updating the column '" + Col.getShortName() + "' from not nullable to nullable.");
                            didSomething = true;
                          }

                        if (C.supportsArrays() == true)
                          {
                            if (CI.isArray() == false && Col.isCollection() == true && Col._Type != ColumnType.JSON)
                              {
                                throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as an array, but it's not an array in the DB. The database needs to be migrated manually.");
                              }
                            else if (CI.isArray() == true && (Col.isCollection() == false || Col._Type == ColumnType.JSON))
                              {
                                throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as an base type, but it's an array in the DB. The database needs to be migrated manually.");
                              }
                          }

                        if (Col._Type == ColumnType.STRING && Col.isCollection() == false && (CI._Size < C.getCLOBThreshhold() && CI._Size != Col._Size || CI._Size >= C.getCLOBThreshhold() && Col._Size < C.getCLOBThreshhold()))
                          {
                            LOG.info("The application's data model has changed the size of the column '" + Col.getShortName() + "' to " + Col._Size + ". Trying to alter it...");
                            if (Migrate == false)
                              {
                                logMigrationWarning();
                                ++warnings;
                                continue;
                              }
                            else if (C.alterTableAlterColumnStringSize(Col, CI._Size) == false)
                              throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as a String of size " + Col._Size + ", but it's " + CI._Size + " in the DB and failed migration. The database needs to be migrated manually.");
                            didSomething = true;
                          }
                        if (Col.isCollection() == false
                        && (Col._Type == ColumnType.BITFIELD && CI._TildaType != ColumnType.INTEGER
                        || Col._Type == ColumnType.JSON && CI._TildaType != ColumnType.STRING && CI._TildaType != ColumnType.JSON
                        || Col._Type != ColumnType.BITFIELD && Col._Type != ColumnType.JSON && Col._Type != CI._TildaType))
                          {
                            LOG.info("The application's data model has changed the type of the column '" + Col.getShortName() + "' to " + Col._Type + ". Trying to alter it...");
                            if (Migrate == false)
                              {
                                logMigrationWarning();
                                ++warnings;
                                continue;
                              }
                            else if (C.alterTableAlterColumnType(CI._TildaType, Col, ZoneInfo_Factory.getEnumerationById("UTC")) == false)
                              throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as '" + Col._Type + "' which cannot be changed from '" + CI._Type + "/" + CI._TypeSql + "/" + CI._TildaType + "' currently in the database. The database needs to be migrated manually.");
                            didSomething = true;
                          }
                      }
                    if (didSomething == true)
                      C.commit();
                  }
                for (String c : Obj._DropOldColumns)
                  {
                    ColumnMeta CI = TMeta.getColumnMeta(c);
                    if (CI != null)
                      {
                        LOG.info("The application's data model has excplicitely asked to drop the column '" + c + ". Trying to alter the table...");
                        if (Migrate == false)
                          {
                            logMigrationWarning();
                            ++warnings;
                            continue;
                          }
                        else if (C.alterTableDropColumn(Obj, CI) == false)
                          throw new Exception("The application's data model has asked to drop column '" + Obj.getFullName() + "." + c + "' which could not be accomplished.");
                        C.commit();
                      }
                  }
              }

            if (Migrate == true)
              {
                for (View V : S._Views)
                  {
                    if (C.createView(V) == false)
                      throw new Exception("Cannot upgrade schema by adding the new view '" + V.getShortName() + "'.");
                  }
                C.commit();
              }
          }
        if (PS.getErrorCount() > 0)
          {
            LOG.error("==============================================================================================");
            LOG.error("There were " + PS.getErrorCount() + " errors when trying to validate the schema set");
            int i = 0;
            for (String Err : PS.getErrors())
              LOG.error("    " + (++i) + " - " + Err);
            throw new Exception("Cannot validate the application model against the database");
          }
        return warnings;
      }


  }
