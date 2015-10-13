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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
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
import tilda.utils.LogUtil;

public class Migrator
  {
    protected static final Logger LOG                 = LogManager.getLogger(Parser.class.getName());

    public static final String    TILDA_VERSION       = "1.0";
    public static final String    TILDA_VERSION_VAROK = "1_0";

    public static String migrate(Connection C, Schema S)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        CodeGenSql Sql = C.getSQlCodeGen();
        ParserSession PS = new ParserSession(S, Sql);
        ResultSet RS = null;
        Level LogLevel = LogUtil.setLogLevel(Level.INFO);
        try
          {
            if (Parser.loadDependencies(PS, S) == true)
              {
                LogUtil.setLogLevel(LogLevel);
                DatabaseMetaData meta = C.getMetaData();

                RS = meta.getSchemas();
                Set<String> DBSchemas = new HashSet<String>();
                while (RS.next() != false)
                  DBSchemas.add(RS.getString("TABLE_SCHEM").toLowerCase());
                RS.close();

                if (DBSchemas.contains(S._Name.toLowerCase()) == false)
                  {
                    LOG.info("The application's data model defines the schema '" + S.getShortName() + "' which cannot be found in the database. Trying to create it...");
                    if (C.createSchema(S) == false)
                      throw new Exception("Cannot upgrade database by adding the new schema '" + S.getShortName() + "'.");
                    C.commit();
                  }

                RS = meta.getTables(null, S._Name.toLowerCase(), null, null);
                Set<String> DBTables = new HashSet<String>();
                Set<String> DBViews = new HashSet<String>();
                while (RS.next() != false)
                  {
                    String Type = RS.getString("TABLE_TYPE");
                    String Name = RS.getString("TABLE_NAME");
                    if ("view".equalsIgnoreCase(Type) == true)
                      DBViews.add(Name.toLowerCase());
                    else
                      DBTables.add(Name.toLowerCase());
                  }
                RS.close();
                boolean didSomething = false;
                for (Object Obj : S._Objects)
                  {
                    if (Obj._FST == FrameworkSourcedType.VIEW)
                      continue;
                    if (DBTables.contains(Obj._Name.toLowerCase()) == false)
                      {
                        LOG.info("The application's data model defines the table '" + Obj.getShortName() + "' which cannot be found in the database. Trying to create it...");
                        if (C.createTable(Obj) == false)
                          throw new Exception("Cannot upgrade schema by adding the new table '" + Obj.getShortName() + "'.");
                        didSomething = true;
                      }
                    RS = meta.getColumns(null, S._Name.toLowerCase(), Obj._Name.toLowerCase(), null);
                    Map<String, ColInfo> DBColumns = new HashMap<String, ColInfo>();
                    while (RS.next() != false)
                      {
                        ColInfo CI = new ColInfo(RS);
                        DBColumns.put(CI._Name, CI);
                      }
                    RS.close();
                    if (DBColumns.isEmpty() == true)
                      throw new Exception("Cannot retrieve columns for table '" + Obj.getShortName() + "'.");
                    didSomething = false;
                    for (Column Col : Obj._Columns)
                      {
                        if (Col._Mode == ColumnMode.CALCULATED)
                          continue;
                        ColInfo CI = DBColumns.get(Col.getName().toLowerCase());
                        if (CI == null)
                          {
                            LOG.info("The application's data model defines the column '" + Col.getShortName() + "' which cannot be found in the database. Trying to create it...");
                            if (C.alterTableAddColumn(Col, Col._DefaultCreateValue == null ? null : Col._DefaultCreateValue._Value) == false)
                              throw new Exception("Cannot upgrade table '" + Obj.getShortName() + "' by adding the new required column '" + Col.getShortName() + "'.");
                            didSomething = true;
                          }
                        else
                          {
                            if (CI._Nullable == 1 && Col._Nullable == false)
                              {
                                LOG.info("The application's data model defines the column '" + Col.getShortName() + "' as not nullable, but it's nullable in the DB. Trying to alter it...");
                                if (C.alterTableAlterColumnNull(Col, Col._DefaultCreateValue == null ? null : Col._DefaultCreateValue._Value) == false)
                                  throw new Exception("Cannot upgrade table '" + Obj.getShortName() + "' by updating the column '" + Col.getShortName() + "' from nullable to not nullable.");
                                didSomething = true;
                              }
                            else if (CI._Nullable == 0 && Col._Nullable == true)
                              {
                                LOG.info("The application's data model defines the column '" + Col.getShortName() + "' as nullable, but it's not nullable in the DB. Trying to alter it...");
                                if (C.alterTableAlterColumnNull(Col, null) == false)
                                  throw new Exception("Cannot upgrade table '" + Obj.getShortName() + "' by updating the column '" + Col.getShortName() + "' from not nullable to nullable.");
                                didSomething = true;
                              }

                            if (CI.isArray() == false && Col.isCollection() == true)
                              {
                                throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as an array, but it's not an array in the DB. The database needs to be migrated manually.");
                              }
                            else if (CI.isArray() == true && Col.isCollection() == false)
                              {
                                throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as an base type, but it's an array in the DB. The database needs to be migrated manually.");
                              }

                            if (Col._Type == ColumnType.STRING && Col.isCollection() == false
                            && (CI._Size < C.getCLOBThreshhold() && CI._Size != Col._Size || CI._Size >= C.getCLOBThreshhold() && Col._Size < C.getCLOBThreshhold()))
                              {
                                if (C.alterTableAlterColumnStringSize(Col, CI._Size) == false)
                                  throw new Exception("The application's data model defines the column '" + Col.getShortName() + "' as a String of size " + Col._Size + ", but it's " + CI._Size
                                  + " in the DB and failed migration. The database needs to be migrated manually.");
                                didSomething = true;
                              }
                          }
                      }
                  }
                if (didSomething == true)
                  C.commit();

                didSomething = false;
                for (View V : S._Views)
                  {
                    boolean Drop = DBViews.contains(V._Name.toLowerCase());
                    if (Drop == false)
                     LOG.info("The application's data model defines the view '" + V.getShortName() + "' which cannot be found in the database. Trying to create it...");
                    else
                      LOG.info("The application's data model defines the view '" + V.getShortName() + "' which needs to be re-created...");
                    if (C.createView(V, Drop) == false)
                      throw new Exception("Cannot upgrade schema by adding the new view '" + V.getShortName() + "'.");
                    didSomething = true;
                  }
                if (didSomething == true)
                  C.commit();

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
            return Str.length() == 0 ? null : Str.toString();
          }
        finally
          {
            RS.close();
            LogUtil.setLogLevel(LogLevel);
          }
      }


  }
