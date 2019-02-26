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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import tilda.Migrate;
import tilda.data.Connection_Data;
import tilda.data.Connection_Factory;
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
       @SerializedName("skipValidation") public boolean     _SkipValidation = false;
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


    static final Logger                           LOG                  = LogManager.getLogger(ConnectionPool.class.getName());

    // _UniqueDataSourceIds is a helper object. Used mainly to retrieve Unique ConnectionID's
    // contains ConnectionId & Connection URL in each entry.
    protected static Map<String, String>          _UniqueDataSourceIds = new HashMap<String, String>();


    protected static Map<String, BasicDataSource> _DataSourcesById     = new HashMap<String, BasicDataSource>();
    protected static Map<String, BasicDataSource> _DataSourcesBySig    = new HashMap<String, BasicDataSource>();
    protected static Map<String, Schema>          _Schemas             = new HashMap<String, Schema>();
    protected static Map<String, String>          _EmailConfigDetails  = null;
    protected static boolean                      _InitDebug           = false;
    protected static boolean                      _SkipValidation      = false;

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
                ReadConnections(Keys);

                if (Migrate.isMigrationActive() == true)
                  {
                    LOG.info("\n");
                    LOG.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    LOG.info("!!! A MIGRATION HAS BEEN REQUESTED. AS A RESULT, DATA IN YOUR DATABASE MAY BE CHANGED.");
                    LOG.info("!!!     ______ ____  ______   ____   ___    ______ __ __ __  __ ____  _____    ___   ");
                    LOG.info("!!!    / ____// __ \\/_  __/  / __ ) /   |  / ____// //_// / / // __ \\/ ___/   /__ \\ ");
                    LOG.info("!!!   / / __ / / / / / /    / __  |/ /| | / /    / ,<  / / / // /_/ /\\__ \\     / _/ ");
                    LOG.info("!!!  / /_/ // /_/ / / /    / /_/ // ___ |/ /___ / /| |/ /_/ // ____/___/ /    /_/   ");
                    LOG.info("!!!  \\____/ \\____/ /_/    /_____//_/  |_|\\____//_/ |_|\\____//_/    /____/    (_)    ");
                    LOG.info("!!!");
                    LOG.info("!!! THE FOLLOWING DATABASE(S) WILL BE ANALYZED:");
                    Iterator<String> I = getUniqueDataSourceIds().keySet().iterator();
                    while (I.hasNext())
                      {
                        String Id = I.next();
                        BasicDataSource BDS = _DataSourcesById.get(Id);
                        LOG.info("!!!     ===> " + Id + ": " + BDS.getUrl() + "USER=" + BDS.getUsername());
                      }
                    LOG.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    LOG.info("\n");
                    LOG.info("Press 'y' followed by enter to continue.");
                    String answer = FileUtil.readlnFromStdIn(false);
                    if (answer.toLowerCase().equals("y") == false)
                      throw new Exception("User asked to exit.");
                    LOG.info("OK! Starting the database analysis...");
                    LOG.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    LOG.info("\n");
                  }


                boolean first = true;
                List<Schema> TildaList = null;
                Iterator<String> connectionIds = getUniqueDataSourceIds().keySet().iterator();
                List<String> connectionUrls = new ArrayList<>(getUniqueDataSourceIds().values());
                while (connectionIds.hasNext())
                  {
                    String connectionId = connectionIds.next();
                    C = get(connectionId);
                    if (TildaList == null)
                      TildaList = LoadTildaResources(C);
                    if (C.isSuperUser() == true)
                      {
                        LOG.warn("###################################################################################################################");
                        LOG.warn("###                                                                                                             ###");
                        LOG.warn("###  W A R N I N G :   T H I S   C O N N E C T I O N   U S E S   A   S U P E R U S E R   A C C O U N T   ! ! !  ###");
                        LOG.warn("###  =========================================================================================================  ###");
                        LOG.warn("###                                                                                                             ###");
                        LOG.warn("###  _|    _|    _|    _|_|_|       _|         _|_|    _|      _|    _|_|       _|_|_|  _|_|    _|_|_|    _|    ###");
                        LOG.warn("###  _|_|  _|  _|  _|    _|       _|  _|     _|      _|  _|  _|  _|  _|  _|       _|    _|  _|  _|      _|  _|  ###");
                        LOG.warn("###  _|  _|_|  _|  _|    _|       _|_|_|     _|  _|  _|  _|  _|  _|  _|  _|       _|    _|  _|  _|_|    _|_|_|  ###");
                        LOG.warn("###  _|    _|  _|  _|    _|       _|  _|     _|  _|  _|  _|  _|  _|  _|  _|       _|    _|  _|  _|      _|  _|  ###");
                        LOG.warn("###  _|    _|    _|      _|       _|  _|       _|_|    _|      _|    _|_|       _|_|_|  _|_|    _|_|_|  _|  _|  ###");
                        LOG.warn("###                                                                                                             ###");
                        LOG.warn("###################################################################################################################");
                      }

                    if (Migrate.isMigrationActive() == true || _SkipValidation == false)
                      {
                        DatabaseMeta DBMeta = LoadDatabaseMetaData(C, TildaList);
                        Migrator.MigrateDatabase(C, Migrate.isMigrationActive() == false, TildaList, DBMeta, first, connectionUrls);
                      }
                    if (/*first == true &&*/ Migrate.isMigrationActive() == false)
                      {
                        LOG.info("Initializing Schemas.");
                        for (Schema S : TildaList)
                          {
                            LOG.debug("  " + S.getFullName());
                            Method M = Class.forName(tilda.generation.java8.Helper.getSupportClassFullName(S)).getMethod("initSchema", Connection.class);
                            M.invoke(null, C);
                            if (_Schemas.get(S._Name.toUpperCase()) == null)
                              _Schemas.put(S._Name.toUpperCase(), S);
                          }
                      }
                    first = false;
                    if (Migrate.isTesting() == false)
                      C.commit();
                    C.close();
                    C = null;
                    LOG.info("\n\n\n\n\n\n\n");
                  }
              }
          }
        catch (Throwable T)
          {
            LOG.error("Cannot initialize Tilda\n", T);
            throw new Error(T);
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
                throw new Error(E);
              }
          }
        if (_InitDebug == false && Migrate.isMigrationActive() == false)
          LogUtil.resetLogLevel();
      }

    private static void ReadConnections(Connection Keys)
    throws Exception
      {
        LOG.info("Adding Connections from tilda.CONNECTIONS table to Pool");

        Connection_Data connection = null;
        ListResults<Connection_Data> connections = null;
        try
          {
            connections = Connection_Factory.LookupWhereActive(Keys, 0, 10000);
          }
        catch (Exception e)
          {
            LOG.error("Database level connections list is not available. Skipping ... \n", e);
            return;
          }
        Iterator<Connection_Data> iterator = connections.iterator();
        while (iterator.hasNext())
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
                _SkipValidation = Defs._SkipValidation;
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

    private static BasicDataSource newDataSource(String id, String driver, String db, String user, String pswd, int initial, int max)
      {
        LOG.info("Initializing a fresh pool for Id=" + id + ", DB=" + db + ", User=" + user + ", and Pswd=Shhhhhhh!");
        BasicDataSource BDS = new BasicDataSource();
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
        return BDS;
      }

    private static void AddDatasource(String id, String driver, String db, String user, String pswd, int initial, int max)
    throws Exception
      {
        if (_DataSourcesById.get(id) != null)
          throw new Exception("Connection with Id: " + id + " is defined in the database but has been defined in /tilda.config.json.");

        synchronized (_DataSourcesById)
          {
            if (_DataSourcesById.get(id) == null) // Definitely no connection pool by that name
              {
                String Sig = db + "``" + user;
                BasicDataSource BDS = _DataSourcesBySig.get(Sig); // Let's see if that DB definition is already there
                if (BDS == null)
                  {
                    BDS = newDataSource(id, driver, db, user, pswd, initial, max);
                    _UniqueDataSourceIds.put(id, BDS.getUrl());
                    _DataSourcesBySig.put(Sig, BDS);
                  }
                else
                  {
                    if ("MAIN".equalsIgnoreCase(id))
                      {
                        String keyToReplace = null;
                        Iterator<String> uniqueKeys = _UniqueDataSourceIds.keySet().iterator();
                        while (uniqueKeys.hasNext())
                          {
                            String key = uniqueKeys.next();
                            if (_UniqueDataSourceIds.get(key).equalsIgnoreCase(BDS.getUrl()))
                              keyToReplace = key;
                          }

                        if (keyToReplace != null)
                          {
                            _UniqueDataSourceIds.put("MAIN", BDS.getUrl());
                            _UniqueDataSourceIds.remove(keyToReplace);
                          }
                      }

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
        LOG.info("Loading database metadata for found Schemas from " + C.getPoolName() + ".");
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
            if (S._Name.equalsIgnoreCase("LDAP") == true)
              LOG.error("XXX");
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
                      else if (DepdencySchemaName.equalsIgnoreCase(D._ResourceName) == true)
                        throw new Exception("Schema " + S._Name + " depends on " + D._Name + " which has been compiled with improper casing. Can happen on Windows systems that are case insensitive at build time in an IDE, but case sensitive when deployed at runtime.");

                      PS.addDependencySchema(D);
                    }
                  if (Found == false)
                    {
                      throw new Exception("Schema " + S._Name + " depends on " + DepdencySchemaName + " which hasn't been loaded.");
                    }
                }
            else //if (S._Name.equals("TILDATMP") == false)
              {
                PS.addDependencySchema(TildaList.get(0));
                PS.addDependencySchema(TildaList.get(1));
                PS.addDependencySchema(S);
              }
            if (S._Name.equals("TILDA") == false && S._Name.equals("TILDATMP") == false)
             S._DependencySchemas.add(TildaList.get(1));
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
        return get(Id, null, null);
      }

    public static Connection get(String Id, String userId, String userPswd)
    throws Exception
      {
        if (userId == null)
          LOG.info(QueryDetails._LOGGING_HEADER + "G E T T I N G   C O N N E C T I O N  -----  " + Id);
        else
          LOG.info(QueryDetails._LOGGING_HEADER + "G E T T I N G   U N P O O L E D   C O N N E C T I O N   W I T H   U S E R   O V E R R I D E  (" + userId + ")-----  " + Id);
        BasicDataSource BDS = _DataSourcesById.get(Id);
        if (BDS == null)
          throw new Exception("Cannot find a connection pool for " + Id);

        java.sql.Connection C = null;
        for (int i = 1; i < 100; ++i)
          {
            try
              {
                long T0 = System.nanoTime();
                if (userId == null)
                  C = BDS.getConnection();
                else
                  {
                    Class.forName(BDS.getDriverClassName());
                    C = DriverManager.getConnection(BDS.getUrl(), userId, userPswd);
                    C.setAutoCommit(false);
                    C.setTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);
                    C.setClientInfo("defaultRowFetchSize", "1000");
                  }
                PerfTracker.add(TransactionType.CONNECTION_GET, System.nanoTime() - T0);
                break;
              }
            catch (SQLException E)
              {
                LOG.error("   - Attempt #" + i + " failed to obtain a connection: " + E.getMessage());
                if (Migrate.isTesting() == true)
                  {
                    if (C != null)
                      C.close();
                    throw E;
                  }
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
        Schema S = _Schemas.get(SchemaName.toUpperCase());
        return S == null ? null : S._Package;
      }

    public static Map<String, String> getEmailConfig()
      {
        return _EmailConfigDetails;
      }

    private static Map<String, String> getUniqueDataSourceIds()
      {
        return _UniqueDataSourceIds;
      }

    // Same as _UniqueDataSourceIds. But, Excludes KEYS
    private static Map<String, String> _AllDataSourceIds = null;

    public static Map<String, String> getAllDataSourceIds()
      {
        if (_AllDataSourceIds == null)
          {
            _AllDataSourceIds = new HashMap<>(getUniqueDataSourceIds());
            // In Development, We might point KEYS and MAIN to the same DB.
            // _UniqueDataSourceIds will not have MAIN as key.
            // By Deleting KEYS, We'll make _AllDataSourceIds empty.
            if (_AllDataSourceIds.containsKey("MAIN"))
              _AllDataSourceIds.remove("KEYS");
          }
        return _AllDataSourceIds;
      }

    // Same as _UniqueDataSourceIds. But, Excludes KEYS & MAIN
    private static Map<String, String> _AllTenantDataSourceIds = null;

    public static Map<String, String> getAllTenantDataSourceIds()
      {
        if (_AllTenantDataSourceIds == null)
          {
            _AllTenantDataSourceIds = new HashMap<>(getUniqueDataSourceIds());
            _AllTenantDataSourceIds.remove("MAIN");
            _AllTenantDataSourceIds.remove("KEYS");
          }
        return _AllTenantDataSourceIds;
      }

    public static boolean isMultiTenant()
      {
        return getAllTenantDataSourceIds().size() > 0;
      }

    public static DatabaseMeta getDBMeta(String string)
      {
        // TODO Auto-generated method stub
        return null;
      }
  }
