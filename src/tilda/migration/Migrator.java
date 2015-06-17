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
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.enums.ColumnMode;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.Parser;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
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
                Iterator<Schema> I = PS.getDependencies();
                while (I.hasNext() == true)
                  if (I.next().Validate(PS) == false)
                    break;
                if (PS.getErrorCount() == 0)
                  {
                    if (PS.getDependency(S._Package, S._Name) == null)
                      PS.addDependency(S);
                    S.Validate(PS);
                    LogUtil.setLogLevel(LogLevel);
                    DatabaseMetaData meta = C.getMetaData();

                    RS = meta.getSchemas();
                    Set<String> DBSchemas = new HashSet<String>();
                    while (RS.next() != false)
                     DBSchemas.add(RS.getString("TABLE_SCHEM").toLowerCase());
                    RS.close();
                    
                    if (DBSchemas.contains(S._Name.toLowerCase()) == false)
                      {
                        LOG.info("The application's data model defines the schema '"+S.getShortName()+"' which cannot be found in the database. Trying to create it...");
                        if (C.createSchema(S) == false)
                         throw new Exception("Cannot upgrade database by adding the new schema '" + S.getShortName() + "'.");
                        C.commit();
                      }
                    
                    RS = meta.getTables(null,  S._Name.toLowerCase(), null, null);
                    Set<String> DBTables = new HashSet<String>();
                    Set<String> DBViews  = new HashSet<String>();
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
                     if (DBTables.contains(Obj._Name.toLowerCase()) == false)
                       {
                         LOG.info("The application's data model defines the table '"+Obj.getShortName()+"' which cannot be found in the database. Trying to create it...");
                         if (C.createTable(Obj) == false)
                          throw new Exception("Cannot upgrade schema by adding the new table '" + Obj.getShortName() + "'.");
                         didSomething = true;
                       }
                    if (didSomething == true)
                     C.commit();
                    
                    for (Object Obj : S._Objects)
                      {
                        RS = meta.getColumns(null, S._Name.toLowerCase(), Obj._Name.toLowerCase(), null);
                        Set<String> DBColumns = new HashSet<String>();
                        while (RS.next() != false)
                          DBColumns.add(RS.getString("COLUMN_NAME").toLowerCase());
                        RS.close();
                        if (DBColumns.isEmpty() == true)
                         throw new Exception("Cannot retrieve columns for table '"+Obj.getShortName()+"'.");
                        didSomething = false;
                        for (Column Col : Obj._Columns)
                         {
                           if (Col._Mode != ColumnMode.CALCULATED && DBColumns.contains(Col._Name.toLowerCase()) == false)
                            {
                              LOG.info("The application's data model defines the column '"+Col.getShortName()+"' which cannot be found in the database. Trying to create it...");
                              if (C.alterTableAddColumn(Col, null) == false)
                               throw new Exception("Cannot upgrade table '" + Obj.getShortName() + "' by adding the new required column '" + Col.getShortName() + "'.");
                              didSomething = true;
                            }
                         }
                        if (didSomething == true)
                         C.commit();
                      }
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
            return Str.length() == 0 ? null : Str.toString();
          }
        finally
          {
            RS.close();
            LogUtil.setLogLevel(LogLevel);
          }
      }


  }
