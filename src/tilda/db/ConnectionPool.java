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

import tilda.enums.TransactionType;
import tilda.migration.Migrator;
import tilda.parsing.parts.Schema;
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
       @SerializedName("connections"   ) public Conn  []  _Conns       = new Conn[0];
       @SerializedName("email"         ) public EmailConfig  _EmailConfig;
       @SerializedName("auto-migration") public boolean _AutoMigrate = false;
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
      @SerializedName("id"     ) public String _Id      = null;
      @SerializedName("driver" ) public String _Driver  = null;
      @SerializedName("db"     ) public String _DB      = null;
      @SerializedName("user"   ) public String _User    = null;
      @SerializedName("pswd"   ) public String _Pswd    = null;
      @SerializedName("initial") public int    _Initial =  3;
      @SerializedName("max"    ) public int    _Max     = 30;
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
        Reader R = null;
        Connection C = null;
        try
          {
            LOG.info("Initializing Tilda: loading configuration file '/tilda.bootstrappers.config.json'.");
            InputStream In = FileUtil.getResourceAsStream("tilda.bootstrappers.config.json");
            if (In != null)
              {
                R = new BufferedReader(new InputStreamReader(In));
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Bootstrappers Bs = gson.fromJson(R, Bootstrappers.class);
                if (Bs._classNames != null)
                  for (String className : Bs._classNames)
                    ClassStaticInit.initClass(className);
                R.close();
                R = null;
              }

            LOG.info("Initializing Tilda: loading configuration file '/tilda.config.json'.");
            In = FileUtil.getResourceAsStream("tilda.config.json");
            if (In == null)
              throw new Exception("Cannot find Tilda configuration file '/tilda.config.json'.");
            R = new BufferedReader(new InputStreamReader(In));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            ConnDefs Defs = gson.fromJson(R, ConnDefs.class);
            if (Defs.validate() == true)
              {
                for (Conn Co : Defs._Conns)
                  init(Co._Id, Co._Driver, Co._DB, Co._User, Co._Pswd, Co._Initial, Co._Max);
              }

            C = get("MAIN");
            LoadTildaResources(C, Defs._AutoMigrate);
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
                if (R != null)
                  R.close();
                if (C != null)
                  C.close();
              }
            catch (IOException | SQLException E)
              {
                LOG.error("Cannot initialize Tilda\n", E);
                System.exit(-1);
              }
          }
      }

    private static void LoadTildaResources(Connection C, boolean Migrate)
    throws Exception
      {
        Reader R = null;
        InputStream In = null;
        Enumeration<URL> resEnum = ConnectionPool.class.getClassLoader().getResources(JarFile.MANIFEST_NAME);
        List<Schema> TildaList = new ArrayList<Schema>();
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
                    LOG.debug("Found Tilda(s) " + Tildas + " in " + url.toString());
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
                          LOG.info("Inspecting " + p);
                          R = new BufferedReader(new InputStreamReader(In));
                          Gson gson = new GsonBuilder().setPrettyPrinting().create();
                          Schema S = gson.fromJson(R, Schema.class);
                          S.setOrigin(p);
                          TildaList.add(S);
                          In.close();
                        }
                  }
              }
          }
        ReorderTildaListWithDependencies(TildaList);
        // LOG.debug("All Tildas in order of dependencies:");
        // for (Schema S : TildaList)
        // LOG.debug(" "+S._ResourceNameShort);
        if (Migrate == false)
          Migrator.logMigrationWarning();
        int warnings = 0;
        for (Schema S : TildaList)
          {
            int w = Migrator.migrate(C, S, Migrate);
            if (w != 0 && Migrate == false)
              {
                warnings += w;
                LOG.warn("There were " + w + " warning(s) issued because schema discrepencies were found but not fixed.");
                Migrator.logMigrationWarning();
                continue;
              }
            LOG.debug("Initializing Schema objects");
            Method M = Class.forName(tilda.generation.java8.Helper.getSupportClassFullName(S)).getMethod("initSchema", Connection.class);
            M.invoke(null, C);
            _SchemaPackage.put(S._Name, S._Package);
            C.commit();
          }
        LOG.debug("");
        LOG.debug("Creating/updating Tilda helper stored procedures.");
        if (Migrate == false)
          Migrator.logMigrationWarning();
        else if (C.addHelperFunctions() == false)
          throw new Exception("Cannot upgrade schema by adding the Tilda helper functions.");

        if (warnings != 0 && Migrate == false)
          {
            LOG.warn("");
            LOG.warn("");
            LOG.warn("There were a total of " + warnings + " warning(s) issued because schema discrepencies were found but not fixed.");
            Migrator.logMigrationWarning();
          }

        C.commit();
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
        LOG.info("-------- Getting a connection --------------------------------------------------------------------------------------------");
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
                LOG.error("   - Attempt #"+i+" failed to obtain a connection: "+E.getMessage());
                if (i == 1)
                 LOG.error("     (Sleeping for 30 seconds, and will re-try again, for a max of 100 times)");
                Thread.sleep(1000*30);
              }
          }
        if (C == null)
         throw new Exception("Failed obtaining a connection after numerous tries.");
        Connection Conn = new Connection(C, Id);
        LOG.info("-------- O B T A I N E D   C O N N E C T I O N --------- " + Conn._PoolId + " ---- (" + BDS.getNumActive() + "/" + BDS.getNumIdle() + "/" + BDS.getMaxTotal() + ")   ----------");
        return Conn;
      }

    public static String getSchemaPackage(String SchemaName)
      {
        return _SchemaPackage.get(SchemaName.toUpperCase());
      }
  }
