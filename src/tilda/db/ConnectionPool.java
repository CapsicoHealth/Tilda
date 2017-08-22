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
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.concurrent.TimeUnit;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.util.PSQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import tilda.Migrate;
import tilda.data.Connections_Data;
import tilda.data.Connections_Factory;
import tilda.db.metadata.DatabaseMeta;
import tilda.enums.TransactionType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.migration.Migrator;
import tilda.parsing.Loader;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.performance.PerfTracker;
import tilda.utils.ClassStaticInit;
import tilda.utils.FileUtil;
import tilda.utils.LogUtil;
import tilda.utils.MigrationDataModel;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;


public class ConnectionPool
  {
    private ConnectionPool()
      {
      }

    private static class ConnDefs
      {
        /*@formatter:off*/
       @SerializedName("connections"   ) public Conn[]      _Conns       = new Conn[0];
       @SerializedName("email"         ) public EmailConfig _EmailConfig;
       @SerializedName("initDebug"     ) public boolean     _InitDebug = false;
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
            return OK;
          }
      }

    private static class EmailConfig
      {
        /*@formatter:off*/
        @SerializedName("smtp"        ) public String _SMTP      = null;
        @SerializedName("userId"      ) public String _UserId    = null;
        @SerializedName("pswd"        ) public String _Pswd      = null;
        /*@formatter:on*/
      }

    private static class Conn
      {
      /*@formatter:off*/
      @SerializedName("id"     ) public String   _Id      = null;
      @SerializedName("driver" ) public String   _Driver  = null;
      @SerializedName("db"     ) public String   _DB      = null;
      @SerializedName("user"   ) public String   _User    = null;
      @SerializedName("pswd"   ) public String   _Pswd    = null;
      @SerializedName("initial") public int      _Initial =  3;
      @SerializedName("max"    ) public int      _Max     = 30;
      @SerializedName("schemas") public String[] _Schemas = new String[]{};
      /*@formatter:on*/
      }

    private static class Bootstrappers
      {
        /*@formatter:off*/
        @SerializedName("classNames") public String[]  _classNames = { };
        /*@formatter:on*/
      }


    static final Logger                           LOG                   = LogManager.getLogger(ConnectionPool.class.getName());

    protected static ArrayList<String>            _UniqueDataSourceIds  = new ArrayList<>();
    protected static Map<String, BasicDataSource> _DataSourcesById      = new HashMap<String, BasicDataSource>();
    protected static Map<String, BasicDataSource> _DataSourcesBySig     = new HashMap<String, BasicDataSource>();
    protected static Map<String, String>          _SchemaPackage        = new HashMap<String, String>();
    protected static Map<String, String>          _EmailConfigDetails   = null;
    protected static boolean                      _InitDebug            = false;

    public static void autoInit()
      {
        SystemValues.autoInit();
      }

    static
      {
        Connection C = null;
        Connection Keys = null;
        try
          {
            InitBootstrappers();
            ReadConfig();
            if (_InitDebug == false && Migrate.isMigrationActive() == false)
              {
                LOG.info("The initDebug flag in the tilda.config.json file is set to false, and so detailed debugging is turned off during system initialization");
                LogUtil.setLogLevel(Level.INFO);
              }
            if (isTildaEnabled() == true)
              {
                Keys = get("KEYS");
                if (Keys == null){
                  throw new Exception("Must define atleast one KEYS Connection in /tilda.config.json");
                }                  
                ReadConnections(Keys);                
                
                List<MigrationDataModel> migrationDataList = new ArrayList<>();
                Iterator<String> connectionIds = _UniqueDataSourceIds.iterator();
                List<Schema> TildaList = null;
                boolean first = true;
               
                while(connectionIds.hasNext())
                  {
                    C = get(connectionIds.next());
                    if (TildaList == null) 
                      TildaList = LoadTildaResources(C);
                    DatabaseMeta DBMeta = LoadDatabaseMetaData(C, TildaList);

                    MigrationDataModel migrationData = Migrator.AnalyzeDatabase(C, Migrate.isMigrationActive() == false, TildaList, DBMeta);
                    migrationDataList.add(migrationData);
                    if (first == true && Migrate.isMigrationActive() == false)
                      {
                        LOG.info("Initializing Schemas.");
                        for (Schema S : TildaList)
                          {
                            LOG.debug("  " + S.getFullName());
                            Method M = Class.forName(tilda.generation.java8.Helper.getSupportClassFullName(S)).getMethod("initSchema", Connection.class);
                            M.invoke(null, C);
                            _SchemaPackage.put(S._Name.toUpperCase(), S._Package);
                          }
                        first = false;
                      }
                    C.commit();
                  }
                
                // Migrate Databases
                Migrator.MigrateDatabase(migrationDataList, Migrate.isMigrationActive() == false);
                // Close Connections
                Iterator<MigrationDataModel> dataIterator = migrationDataList.iterator();
                while(dataIterator.hasNext())
                  {
                    C = dataIterator.next().getConnection();
                    C.close();
                    C = null;
                  }
              }
          }
        catch (Throwable T)
          {
            LOG.error("Cannot initialize Tilda\n", T);
            System.exit(-1);
          }
        finally
          {
            try
              {
                if (C != null)
                  C.close();
                if (Keys != null)
                  Keys.close();
              }
            catch (SQLException E)
              {
                LOG.error("Cannot initialize Tilda\n", E);
                System.exit(-1);
              }
          }
        if (_InitDebug == false && Migrate.isMigrationActive() == false)
          LogUtil.resetLogLevel();
      }

    private static void ReadConnections(Connection Keys)
    throws Exception
      {
        LOG.info("Adding Connections from tilda.CONNECTIONS table to Pool");
        
        Connections_Data connection = null;
        ListResults<Connections_Data> connections = null;
        try 
          {
            connections = Connections_Factory.LookupWhereAllButDeleted(Keys, 0, 10000);
          } 
        catch (Exception e) 
           {
             LOG.error("Database level connections list is not available. Skipping ... \n", e);
             return;
           }
        Iterator<Connections_Data> iterator = connections.iterator();
        while(iterator.hasNext())
          {
            connection = iterator.next();
            AddDatasource(connection.getId(), connection.getDriver(), connection.getDb(), connection.getUser(), connection.getPswd(), connection.getInitial(), connection.getMax());
          }
        LOG.info("Completed Adding Connections from tilda.CONNECTIONS table to Pool");
      }
    
    private static void ReadConfig()
    throws Exception
      {
        LOG.info("Initializing Tilda: loading configuration file '/tilda.config.json'.");
        Reader R = null;
        try
          {
            boolean Secondary = false;
            InputStream In = FileUtil.getResourceAsStream("/tilda.config.json");
            if (In == null)
              {
                LOG.debug("Cannot read the config file. Trying a secondary source as 'tilda.config.json'");
                In = FileUtil.getResourceAsStream("tilda.config.json");
                Secondary = true;
              }
            if (In == null)
              throw new Exception("Cannot find the Tilda configuration file '/tilda.config.json' in the classpath.");

            Enumeration<URL> resEnum = ConnectionPool.class.getClassLoader().getResources(Secondary == false ? "/tilda.config.json" : "tilda.config.json");
            while (resEnum.hasMoreElements())
              {
                URL url = (URL) resEnum.nextElement();
                LOG.info("   Found tilda.config.json file in " + url.toString());
                break;
              }

            R = new BufferedReader(new InputStreamReader(In));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ConnDefs Defs = gson.fromJson(R, ConnDefs.class);
            if (Defs.validate() == true)
              {
                _InitDebug = Defs._InitDebug;
                for (Conn Co : Defs._Conns)
                  {
                    AddDatasource(Co._Id, Co._Driver, Co._DB, Co._User, Co._Pswd, Co._Initial, Co._Max);
                  }
                if (Defs._EmailConfig != null)
                  {
                    _EmailConfigDetails = new HashMap<String, String>();
                    _EmailConfigDetails.put("SMTP", Defs._EmailConfig._SMTP);
                    _EmailConfigDetails.put("UserId", Defs._EmailConfig._UserId);
                    _EmailConfigDetails.put("Pswd", Defs._EmailConfig._Pswd);
                  }
              }
          }
        finally
          {
            if (R != null)
              R.close();
          }
      }

    private static void InitBootstrappers()
    throws IOException
      {
        LOG.info("Initializing Tilda: loading configuration file '/tilda.bootstrappers.config.json'.");
        Reader R = null;
        try
          {
            InputStream In = FileUtil.getResourceAsStream("tilda.bootstrappers.config.json");
            if (In != null)
              {
                R = new BufferedReader(new InputStreamReader(In));
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Bootstrappers Bs = gson.fromJson(R, Bootstrappers.class);
                if (Bs._classNames != null)
                  for (String className : Bs._classNames)
                    ClassStaticInit.initClass(className);
              }
          }
        finally
          {
            if (R != null)
              R.close();
          }
      }

    private static void AddDatasource(String id, String driver, String db, String user, String pswd, int initial, int max) 
    throws Exception 
      {
        if (_DataSourcesById.get(id) != null)
          throw new Exception("Connection with Id: "+id+" is defined in the database but has been defined in /tilda.config.json.");
        
        synchronized (_DataSourcesById)
          {
            if (_DataSourcesById.get(id) == null) // Definitely no connection pool by that name
              {
                String Sig = db + "``" + user;
                BasicDataSource BDS = _DataSourcesBySig.get(Sig); // Let's see if that DB definition is already there
                if (BDS == null)
                  {
                    LOG.info("Initializing a fresh pool for Id=" + id + ", DB=" + db + ", User=" + user + ", and Pswd=Shhhhhhh!");
                    BDS = new BasicDataSource();
                    BDS.setDriverClassName(driver);
                    BDS.setUrl(db);
                    if (TextUtil.isNullOrEmpty(pswd) == false && TextUtil.isNullOrEmpty(user) == false)
                      {
                        BDS.setUsername(user);
                        BDS.setPassword(pswd);
                      }
                    BDS.setInitialSize(initial);
                    BDS.setMaxTotal(max);
                    BDS.setDefaultAutoCommit(false);
                    BDS.setDefaultTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);
                    BDS.setDefaultQueryTimeout(20000);
                    _UniqueDataSourceIds.add(id);
                    _DataSourcesBySig.put(Sig, BDS);
                  }
                else
                  {
                    LOG.info("Merging pool with ID " + id + " into prexisting pool " + Sig);
                    if (BDS.getInitialSize() < initial)
                      BDS.setInitialSize(initial);
                    if (BDS.getMaxTotal() < max)
                      BDS.setMaxTotal(max);
                  }
                _DataSourcesById.put(id, BDS);
              }
          }
      }
    
    private static DatabaseMeta LoadDatabaseMetaData(Connection C, List<Schema> TildaList)
    throws Exception
      {
        DatabaseMeta DBMeta = new DatabaseMeta();
        LOG.info("Loading database metadata for found Schemas.");
        for (Schema S : TildaList)
          {
            LOG.debug("  " + S._Name);
            DBMeta.load(C, S._Name);
          }
        return DBMeta;
      }

    private static List<Schema> LoadTildaResources(Connection C)
    throws Exception
      {
        List<Schema> TildaList = Loader.LoadTildaResources();
        if (TildaList == null)
          throw new Exception("Tilda cannot start as we didn't find the necessary Tilda resources.");

        for (Schema S : TildaList)
          {
            CodeGenSql Sql = C.getSQlCodeGen();
            ParserSession PS = new ParserSession(S, Sql);
            if (S._Dependencies != null)
              for (String DepdencySchemaName : S._Dependencies)
                {
                  boolean Found = false;
                  for (Schema D : TildaList)
                    {
                      if (DepdencySchemaName.equals(D._ResourceName) == true)
                        {
                          if (D._Validated != Boolean.TRUE)
                            throw new Exception("Schema " + S._Name + " depends on " + D._Name + " which hasn't been validated properly.");
                          Found = true;
                          S._DependencySchemas.add(D);
                        }
                      PS.addDependencySchema(D);
                    }
                  if (Found == false)
                    throw new Exception("Schema " + S._Name + " depends on " + DepdencySchemaName + " which hasn't been loaded.");
                }
            else
              {
                PS.addDependencySchema(TildaList.get(0));
                PS.addDependencySchema(S);
              }
            S._DependencySchemas.add(TildaList.get(0));
            if (S.Validate(PS) == false)
              throw new Exception("Schema " + S._Name + " from resource " + S._ResourceName + " failed validation.");
            for (Object Obj : S._Objects)
              if (Obj != null)
                MasterFactory.register(S._Package, Obj);
          }

        return TildaList;
      }


    private static boolean isTildaEnabled()
      {
        return _DataSourcesById.get("MAIN") != null && _DataSourcesById.get("KEYS") != null;
      }

    public static Connection get(String Id)
    throws Exception
      {
        LOG.info(QueryDetails._LOGGING_HEADER + "G E T T I N G   C O N N E C T I O N  -----  " + Id);
        BasicDataSource BDS = _DataSourcesById.get(Id);
        if (BDS == null)
          throw new Exception("Cannot find a connection pool for " + Id);
        java.sql.Connection C = null;
        for (int i = 1; i < 100; ++i)
          {
            try
              {
                long T0 = System.nanoTime();
                C = BDS.getConnection();
                PerfTracker.add(TransactionType.CONNECTION_GET, System.nanoTime() - T0);
                break;
              }
            catch (SQLException E)
              {
                LOG.error("   - Attempt #" + i + " failed to obtain a connection: " + E.getMessage());
                if (i == 1)
                  LOG.error("     (Sleeping for 30 seconds, and will re-try again, for a max of 100 times)");
                Thread.sleep(1000 * 30);
              }
          }
        if (C == null)
          throw new Exception("Failed obtaining a connection after numerous tries.");
        Connection Conn = new Connection(C, Id);
        LOG.info(QueryDetails._LOGGING_HEADER + "G O T           C O N N E C T I O N  -----  " + Conn._PoolId + ", " + BDS.getNumActive() + "/" + BDS.getNumIdle() + "/" + BDS.getMaxTotal());
        return Conn;
      }

    public static String getDBDetails(String Id)
      {
        BasicDataSource BDS = _DataSourcesById.get(Id);
        if (BDS == null)
          return null;
        return BDS.getUrl();
      }

    public static String getSchemaPackage(String SchemaName)
      {
        return _SchemaPackage.get(SchemaName.toUpperCase());
      }

    public static Map<String, String> getEmailConfig()
      {
        return _EmailConfigDetails;
      }
    
    public static ArrayList<String> getUniqueDataSourceIds()
      {
        return _UniqueDataSourceIds;
      }
  }
