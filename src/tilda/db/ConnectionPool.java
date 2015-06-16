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

package tilda.db;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnMode;
import tilda.enums.TransactionType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.Parser;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.performance.PerfTracker;
import tilda.utils.CollectionUtil;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class ConnectionPool
  {
    private static class ConnDefs
      {
        /*@formatter:off*/
       @SerializedName("connections") public Conn  []  _Conns   = new Conn[0];
       @SerializedName("schemas"    ) public String[]  _Schemas = new String[0];
       /*@formatter:on*/

        public boolean validate()
          {
            if (_Conns == null || _Conns.length == 0)
              {
                LOG.error("No connections were defined in the Tilda configuration file");
                return false;
              }
            Set<String> IDs = new HashSet<String>();
            boolean OK = true;
            for (Conn C : _Conns)
              {
                if (IDs.add(C._Id) == false)
                  {
                    LOG.error("A duplicate connection with id=" + C._Id + " has been defined.");
                    OK = false;
                  }
                if (TextUtil.isNullOrEmpty(C._Driver) == true)
                  {
                    LOG.error("Connection id=" + C._Id + " didn't define a driver!");
                    OK = false;
                  }
                if (TextUtil.isNullOrEmpty(C._DB) == true)
                  {
                    LOG.error("Connection id=" + C._Id + " didn't define a DB connection string!");
                    OK = false;
                  }
              }
            
            if (_Schemas == null || _Schemas.length == 0)
              {
                LOG.error("No active schema was defined in the Tilda configuration file. At least one must be defined for initialization.");
                return false;
              }
            for (String name : _Schemas)
              {
                if (FileUtil.getResourceAsStream(name) == null)
                  {
                    LOG.error("Tilda schema definition '" + name + "' could not be found in the classpath.");
                    OK = false;
                  }
              }
            
            return OK;
          }
      }

    private static class Conn
      {

      /*@formatter:off*/
      @SerializedName("id"     ) public String _Id      = null;
      @SerializedName("driver" ) public String _Driver  = null;
      @SerializedName("db"     ) public String _DB      = null;
      @SerializedName("user"   ) public String _User    = null;
      @SerializedName("pswd"   ) public String _Pswd    = null;
      @SerializedName("initial") public int    _Initial =  3;
      @SerializedName("max"    ) public int    _Max     = 30;
      /*@formatter:on*/
      }

    static final Logger                           LOG               = LogManager.getLogger(ConnectionPool.class.getName());

    protected static Map<String, BasicDataSource> _DataSourcesById  = new HashMap<String, BasicDataSource>();
    protected static Map<String, BasicDataSource> _DataSourcesBySig = new HashMap<String, BasicDataSource>();
    protected static Map<String, String         > _SchemaPackage    = new HashMap<String, String         >();

    public static void autoInit() { }

    static
      {
        Reader R = null;
        Connection C = null;
        try
          {
            LOG.info("Initializing Tilda.");
            InputStream In = FileUtil.getResourceAsStream("tilda.config.json");
            if (In == null)
              {
                LOG.error("Cannot find Tilda configuration file '/tilda.config.json'.");
              }
            else
              {
                R = new BufferedReader(new InputStreamReader(In));
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                ConnDefs Defs = gson.fromJson(R, ConnDefs.class);
                if (Defs.validate() == true)
                  for (Conn Co : Defs._Conns)
                    init(Co._Id, Co._Driver, Co._DB, Co._User, Co._Pswd, Co._Initial, Co._Max);

                LOG.info("Initializing registered Tilda schemas");
                C = get("MAIN");
                final String TildaJSON = "tilda/data/_tilda.Tilda.json";
                if (TextUtil.FindElement(Defs._Schemas, TildaJSON, true, 0) == -1)
                  Defs._Schemas = CollectionUtil.prepend(Defs._Schemas, TildaJSON);
                
                for (String name : Defs._Schemas)
                  {
                    LOG.info("Initializing "+name);
                    R = new BufferedReader(new InputStreamReader(FileUtil.getResourceAsStream(name)));
                    gson = new GsonBuilder().setPrettyPrinting().create();
                    Schema S = gson.fromJson(R, Schema.class);
                    S.setOrigin(name);
                    CodeGenSql Sql = (CodeGenSql) Class.forName("tilda.generation.postgres9.Sql" ).newInstance();
                    ParserSession PS = new ParserSession(S, Sql);
                    if (Parser.loadDependencies(PS, S) == true)
                     {
                       Iterator<Schema> I = PS.getDependencies();
                       while (I.hasNext() == true)
                         if (I.next().Validate(PS) == false)
                           break;
                       if (PS.getErrorCount() == 0)
                         {
                           if (PS.getDependency(S._Package,  S._Name) == null)
                             PS.addDependency(S);
                           S.Validate(PS);
                           for (Object Obj : S._Objects)
                             {
                               DatabaseMetaData meta = C._C.getMetaData();
                               LOG.debug("Getting columns for table "+S._Name+"."+Obj._Name+".");
                               ResultSet RS = meta.getColumns(null, S._Name.toLowerCase(), Obj._Name.toLowerCase(), null);
                               Set<String> DBColumns = new HashSet<String>();
                               while (RS.next() != false)
                                 DBColumns.add(RS.getString("COLUMN_NAME").toLowerCase());
                               for (Column Col : Obj._Columns)
                                 {
                                   if (Col._Mode != ColumnMode.CALCULATED && DBColumns.contains(Col._Name.toLowerCase()) == false)
                                    if (C.alterTableAddColumn(Col) == false)
                                     throw new Exception("Cannot upgrade table '"+Obj.getShortName()+"' by adding the new required column '"+Col.getShortName()+"'.");
                                 }
                               C.commit();
                             }
                         }
                       LOG.debug("\n");
                       LOG.debug("Initializing Schema objects");
                       Method M = Class.forName(tilda.generation.java8.Helper.getSupportClassFullName(S)).getMethod("initSchema", Connection.class);
                       M.invoke(null, C);
                       C.commit();
                       _SchemaPackage.put(S._Name, S._Package);
                     }
                    if (PS.getErrorCount() > 0)
                      {
                        LOG.error("==============================================================================================");
                        LOG.error("There were " + PS.getErrorCount() + " errors when trying to validate the schema set");
                        int i = 0;
                        for (String Err : PS.getErrors())
                          LOG.error("    "+(++i)+" - "+Err);
                      }
                  }
              }
          }
        catch (Throwable T)
          {
            LOG.error("Cannot initialize Tilda", T);
            System.exit(1);
          }
        finally
          {
            if (R != null)
              try
                {
                  R.close();
                }
              catch (IOException E)
                {
                  LOG.error("Cannot initialize Tilda", E);
                  System.exit(1);
                }
            if (C != null)
              try
                {
                  C.close();
                }
              catch (SQLException e)
                {
                  System.exit(1);
                }
          }
      }

    public static void init(String Id, String Driver, String DB, String User, String Pswd, int InitialSize, int MaxSize)
      {
        if (_DataSourcesById.get(Id) == null)
          synchronized (_DataSourcesById)
            {
              if (_DataSourcesById.get(Id) == null) // Definitely no connection pool by that name
                {
                  String Sig = DB + "``" + User;
                  BasicDataSource BDS = _DataSourcesBySig.get(Sig); // Let's see if that DB definition is already there
                  if (BDS == null)
                    {
                      LOG.info("Initializing a fresh pool for Id=" + Id + ", DB=" + DB + ", User=" + User + ", and Pswd=Shhhhhhh!");
                      BDS = new BasicDataSource();
                      BDS.setDriverClassName(Driver);
                      BDS.setUrl(DB);
                      if (TextUtil.isNullOrEmpty(Pswd) == false && TextUtil.isNullOrEmpty(User) == false)
                        {
                          BDS.setUsername(User);
                          BDS.setPassword(Pswd);
                        }
                      BDS.setInitialSize(InitialSize);
                      BDS.setMaxTotal(MaxSize);
                      BDS.setDefaultAutoCommit(false);
                      BDS.setDefaultTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);
                      BDS.setDefaultQueryTimeout(20000);
                      _DataSourcesBySig.put(Sig, BDS);
                    }
                  else
                    {
                      LOG.info("Merging pool with ID " + Id + " into prexisting pool " + Sig);
                      if (BDS.getInitialSize() < InitialSize)
                        BDS.setInitialSize(InitialSize);
                      if (BDS.getMaxTotal() < MaxSize)
                        BDS.setMaxTotal(MaxSize);

                    }
                  _DataSourcesById.put(Id, BDS);
                }
            }
      }

    public static Connection get(String Id)
      throws Exception
      {
        BasicDataSource BDS = _DataSourcesById.get(Id);
        if (BDS == null)
          throw new Exception("Cannot find a connection pool for " + Id);
        long T0 = System.nanoTime();
        java.sql.Connection C = BDS.getConnection();
        Connection Conn = new Connection(C, Id);
        PerfTracker.add(TransactionType.CONNECTION_GET, System.nanoTime() - T0);
        LOG.info("-------- O B T A I N E D   C O N N E C T I O N --------- " + Conn._PoolId + " ---- (" + BDS.getNumActive() + "/" + BDS.getNumIdle() + "/" + BDS.getMaxTotal() + ")   ----------");
        return Conn;
      }
    
    public static String getSchemaPackage(String SchemaName)
     {
       return _SchemaPackage.get(SchemaName.toUpperCase());
     }
  }
