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
import tilda.migration.actions.ColumnAdd;
import tilda.migration.actions.SchemaCreate;
import tilda.migration.actions.TableCreate;
import tilda.migration.actions.TableKeyCreate;
import tilda.parsing.Parser;
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

    public static List<MigrationAction> getMigrationActions(Schema S, DatabaseMeta DBMeta)
    throws Exception
      {
        LOG.info("");
        LOG.info("Comparing the application's data model with the database's for "+S.getFullName());

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

        return Actions;
      }


  }
