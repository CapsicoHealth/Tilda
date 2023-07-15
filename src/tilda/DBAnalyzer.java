/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

package tilda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.analyzer.DBProcessor;
import tilda.analyzer.HTMLRenderer;
import tilda.analyzer.bean.DBStatus;
import tilda.analyzer.bean.Database;
import tilda.analyzer.helper.FileHelper;
import tilda.analyzer.parser.AnalyzerData;
import tilda.analyzer.parser.DatabaseConfig;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.utils.TextUtil;

public class DBAnalyzer
  {
    protected static final Logger LOG = LogManager.getLogger(DBAnalyzer.class.getName());

    public static void main(String args[])
    throws Exception
      {
        AnalyzerData Data = InitConfig(args);
        FileHelper FH = new FileHelper(Data._DirectoryPath);
        Connection C = ConnectionPool.get("MAIN");

        LOG.debug("Getting the database meta data object.");
        Database DB = new Database(C, Data);
        DB.sortSchemas();
        DB.loadTablesAndViews(C, Data);
        
        
        DB.validateAndLoadRules(C, Data);
        

        LOG.debug("Initializing the status tracker object.");
        DBStatus DBS = new DBStatus(Data._DirectoryPath);
        DBS.Load(DB);


        while (true)
          {
            try
              {
                if (Data._RenderOnly == false)
                 DBProcessor.process(C, FH, DB);
                break;
              }
            catch (Exception E)
              {
                LOG.error("Error", E);
                if (C.isLockOrConnectionError(E) == false)
                  {
                    LOG.error("This appears to not have been a DB connectivity issue, so we are ending the program now.");
                    throw E;
                  }
                LOG.debug("Retrying the db analzyer because we lost our connection or had a deadlock");
                C.close();
                C = ConnectionPool.get("MAIN");
              }
          }
        
        HTMLRenderer.render(FH, DB);

        LOG.debug("Analyzing database completed.");
      }




    private static AnalyzerData InitConfig(String[] args)
      {
        if (args != null && args.length != 1)
          {
            LOG.debug("Usage DBAnalyzer analyzer.config.json ");
            System.exit(-1);
          }
        String ConfigFileName = args[0];
        AnalyzerData Data = DatabaseConfig.fromFile(ConfigFileName);
        if (Data == null)
          {
            LOG.debug("The configuration file could not be found or processed.");
            System.exit(-1);
          }
        if (TextUtil.isNullOrEmpty(Data._DirectoryPath))
          {
            LOG.debug("Database Status path is not defined in the config.");
            System.exit(-1);
          }

        return Data;
      }
  }
