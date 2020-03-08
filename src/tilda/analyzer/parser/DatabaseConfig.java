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

package tilda.analyzer.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DatabaseConfig
  {
    protected static final Logger LOG = LogManager.getLogger(DatabaseConfig.class.getName());

    public static AnalyzerData fromFile(String FilePath)
      {
        Reader R = null;
        try
          {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            File f = new File(FilePath);
            if (f.exists() == false)
              {
                LOG.error("Cannot find file '" + FilePath + "'.");
                return null;
              }
            R = new FileReader(FilePath);
            return gson.fromJson(R, AnalyzerData.class);
          }
        catch (Throwable T)
          {
            LOG.error("Cannot load from file '" + FilePath + "' because the JSON format is invalid.", T);
            return null;
          }
        finally
          {
            if (R != null)
              try
                {
                  R.close();
                }
              catch (IOException e)
                {
                }
          }
      }

  }
