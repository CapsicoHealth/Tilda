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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import tilda.Migrate;
import tilda.db.metadata.DatabaseMeta;
import tilda.enums.TransactionType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.migration.Migrator;
import tilda.parsing.Parser;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.performance.PerfTracker;
import tilda.utils.ClassStaticInit;
import tilda.utils.FileUtil;
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
        @SerializedName("smtp"   ) public String _SMTP    = null;
        @SerializedName("userId" ) public String _UserId  = null;
        @SerializedName("pswd"   ) public String _Pswd    = null;
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


    static final Logger                           LOG               = LogManager.getLogger(ConnectionPool.class.getName());

    protected static Map<String, BasicDataSource> _DataSourcesById  = new HashMap<String, BasicDataSource>();
    protected static Map<String, BasicDataSource> _DataSourcesBySig = new HashMap<String, BasicDataSource>();
    protected static Map<String, String>          _SchemaPackage    = new HashMap<String, String>();

    public static void autoInit()
      {
        SystemValues.autoInit();
      }

    static
      {
        Connection C = null;
        try
          {
            InitBootstrappers();
            ReadConfig();
            if (isTildaEnabled() == true)
              {
                C = get("MAIN");
                List<Schema> TildaList = LoadTildaResources(C);
                DatabaseMeta DBMeta = LoadDatabaseMetaData(C, TildaList);
                MigrateDatabase(C, Migrate.isMigrationActive(), TildaList, DBMeta);
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
              }
            catch (SQLException E)
              {
                LOG.error("Cannot initialize Tilda\n", E);
                System.exit(-1);
              }
          }
      }

    private static void ReadConfig()
    throws Exception
      {
        LOG.info("Initializing Tilda: loading configuration file '/tilda.config.json'.");
        Reader R = null;
        try
          {
            InputStream In = FileUtil.getResourceAsStream("tilda.config.json");
            if (In == null)
              throw new Exception("Cannot find Tilda configuration file '/tilda.config.json'.");
            R = new BufferedReader(new InputStreamReader(In));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ConnDefs Defs = gson.fromJson(R, ConnDefs.class);
            if (Defs.validate() == true)
              {
                for (Conn Co : Defs._Conns)
                  {
                    if (_DataSourcesById.get(Co._Id) == null)
                      synchronized (_DataSourcesById)
                        {
                          if (_DataSourcesById.get(Co._Id) == null) // Definitely no connection pool by that name
                            {
                              String Sig = Co._DB + "``" + Co._User;
                              BasicDataSource BDS = _DataSourcesBySig.get(Sig); // Let's see if that DB definition is already there
                              if (BDS == null)
                                {
                                  LOG.info("Initializing a fresh pool for Id=" + Co._Id + ", DB=" + Co._DB + ", User=" + Co._User + ", and Pswd=Shhhhhhh!");
                                  BDS = new BasicDataSource();
                                  BDS.setDriverClassName(Co._Driver);
                                  BDS.setUrl(Co._DB);
                                  if (TextUtil.isNullOrEmpty(Co._Pswd) == false && TextUtil.isNullOrEmpty(Co._User) == false)
                                    {
                                      BDS.setUsername(Co._User);
                                      BDS.setPassword(Co._Pswd);
                                    }
                                  BDS.setInitialSize(Co._Initial);
                                  BDS.setMaxTotal(Co._Max);
                                  BDS.setDefaultAutoCommit(false);
                                  BDS.setDefaultTransactionIsolation(java.sql.Connection.TRANSACTION_READ_COMMITTED);
                                  BDS.setDefaultQueryTimeout(20000);
                                  _DataSourcesBySig.put(Sig, BDS);
                                }
                              else
                                {
                                  LOG.info("Merging pool with ID " + Co._Id + " into prexisting pool " + Sig);
                                  if (BDS.getInitialSize() < Co._Initial)
                                    BDS.setInitialSize(Co._Initial);
                                  if (BDS.getMaxTotal() < Co._Max)
                                    BDS.setMaxTotal(Co._Max);

                                }
                              _DataSourcesById.put(Co._Id, BDS);
                            }
                        }

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

    private static DatabaseMeta LoadDatabaseMetaData(Connection C, List<Schema> TildaList)
    throws Exception
      {
        DatabaseMeta DBMeta = new DatabaseMeta();
        LOG.info("Loading database metadata for found Schemas:");
        for (Schema S : TildaList)
          {
            LOG.debug("   " + S._Name);
            DBMeta.load(C, S._Name);
          }
        return DBMeta;
      }

    private static List<Schema> LoadTildaResources(Connection C)
    throws Exception
      {
        Reader R = null;
        InputStream In = null;
        Enumeration<URL> resEnum = ConnectionPool.class.getClassLoader().getResources(JarFile.MANIFEST_NAME);
        List<Schema> TildaList = new ArrayList<Schema>();
        Schema BaseTildaSchema = null;
        while (resEnum.hasMoreElements())
          {
            URL url = (URL) resEnum.nextElement();
            In = url.openStream();
            if (In != null)
              {
                Manifest Man = new Manifest();
                Man.read(In);
                In.close();
                String Tildas = Man.getMainAttributes().getValue("Tilda");
                if (TextUtil.isNullOrEmpty(Tildas) == false)
                  {
                    LOG.info("Found Tilda definition files in " + url.toString());
                    String[] parts = Tildas.split(";");
                    if (parts != null)
                      for (String p : parts)
                        {
                          if (TextUtil.isNullOrEmpty(p) == true)
                            continue;
                          p = p.trim();
                          In = FileUtil.getResourceAsStream(p);
                          if (In == null)
                            throw new Exception("Tilda schema definition '" + p + "' could not be found in the classpath.");
                          LOG.debug("   Reading " + p);
                          R = new BufferedReader(new InputStreamReader(In));
                          Gson gson = new GsonBuilder().setPrettyPrinting().create();
                          Schema S = gson.fromJson(R, Schema.class);
                          S.setOrigin(p);
                          if (p.equals(Parser._BASE_TILDA_SCHEMA_RESOURCE) == true)
                            BaseTildaSchema = S;
                          TildaList.add(S);
                          LOG.debug("   Parsed definition for Schema " + S._Package + "::" + S._Name);
                          In.close();
                        }
                  }
              }
          }
        ReorderTildaListWithDependencies(TildaList);

        if (BaseTildaSchema == null)
          throw new Exception("Tilda cannot start as we didn't find the base Tilda schema resource " + Parser._BASE_TILDA_SCHEMA_RESOURCE);

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
                          if (D._Validated != true)
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
                PS.addDependencySchema(BaseTildaSchema);
                PS.addDependencySchema(S);
              }
            S._DependencySchemas.add(BaseTildaSchema);
            if (S.Validate(PS) == false)
              throw new Exception("Schema " + S._Name + " from resource " + S._ResourceName + " failed validation.");
          }

        return TildaList;
      }

    private static int MigrateDatabase(Connection C, boolean Migrate, List<Schema> TildaList, DatabaseMeta DBMeta)
    throws Exception
      {
        int warnings = 0;

        // Some DBs, such as Postgres, don't allow to alter a column that's reused as part of a view. So in order to
        // prepare, we can drop all views.
        if (Migrate == true)
          {
            boolean DbAction = false;
            for (Schema S : TildaList)
              {
                for (View V : S._Views)
                  {
                    if (DBMeta.getViewMeta(V._ParentSchema._Name, V._Name) != null)
                      {
                        if (C.dropView(V) == false)
                          throw new Exception("Cannot upgrade schema by dropping the old view '" + V.getShortName() + "'.");
                        DbAction = true;
                      }
                  }
              }
            if (DbAction == true)
              C.commit();
          }

        for (Schema S : TildaList)
          {
            int w = Migrator.migrate(C, S, DBMeta, Migrate);
            if (w != 0 && Migrate == false)
              {
                warnings += w;
                LOG.warn("There were " + w + " warning(s) issued because schema discrepencies were found but not fixed.");
                Migrator.logMigrationWarning();
              }
            LOG.debug("Initializing Schema objects");
            Method M = Class.forName(tilda.generation.java8.Helper.getSupportClassFullName(S)).getMethod("initSchema", Connection.class);
            M.invoke(null, C);
            _SchemaPackage.put(S._Name.toUpperCase(), S._Package);
            C.commit();
          }
        LOG.debug("");
        LOG.debug("Creating/updating Tilda helper stored procedures.");
        if (Migrate == false)
          {
            // ++warnings;
          }
        else if (C.addHelperFunctions() == false)
          throw new Exception("Cannot upgrade schema by adding the Tilda helper functions.");

        if (warnings != 0 && Migrate == false)
          {
            LOG.error("");
            LOG.error("");
            LOG.error("*************************************************************************************************************************************");
            LOG.warn("There were a total of " + warnings + " warning(s) and/or error(s) issued because schema discrepencies were found but not fixed.");
            Migrator.logMigrationWarning();
            LOG.error("*************************************************************************************************************************************");
          }
        else
          {
            LOG.info("");
            LOG.info("====================================================================");
            LOG.info("===  Woohoo! The database matches the Application's data model.  ===");
            LOG.info("====================================================================");
            LOG.info("");
          }

        C.commit();
        if (Migrate == true)
          KeysManager.reloadAll();
        return warnings;
      }

    private static boolean isTildaEnabled()
      {
        return _DataSourcesById.get("MAIN") != null && _DataSourcesById.get("KEYS") != null;
      }

    private static void ReorderTildaListWithDependencies(List<Schema> L)
      {
        for (int i = 0; i < L.size(); ++i)
          {
            Schema Si = L.get(i);
            int minIndex = 0;
            // LOG.debug("Checking dependencies for "+Si._ResourceNameShort);
            if (Si._Dependencies != null)
              for (String Dep : Si._Dependencies)
                {
                  // LOG.debug(" Checking dependency "+Dep);
                  for (int j = 0; j < i; ++j)
                    {
                      Schema Sj = L.get(j);
                      // LOG.debug(" Comparing "+Dep+" Vs. "+Sj._ResourceNameShort);
                      if (Sj._ResourceNameShort.equals(Dep) == true && minIndex < j + 1)
                        {
                          minIndex = j + 1;
                          // LOG.debug(" Found dependency. Setting minIndex="+minIndex);
                        }
                    }
                }
            if (L.get(0)._ResourceNameShort.equals("tilda/data/_tilda.Tilda.json") == true && minIndex == 0)
              minIndex = 1;
            // LOG.debug(" minIndex="+minIndex);
            Schema S = L.remove(i);
            L.add(minIndex, S);

          }
      }


    public static Connection get(String Id)
    throws Exception
      {
        LOG.info("-------  G E T T I N G   C O N N E C T I O N  -----  " + Id);
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
        LOG.info("         G O T           C O N N E C T I O N  -----  " + Conn._PoolId + ", " + BDS.getNumActive() + "/" + BDS.getNumIdle() + "/" + BDS.getMaxTotal());
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
  }
