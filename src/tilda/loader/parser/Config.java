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

package tilda.loader.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import tilda.utils.FileUtil;

public class Config
  {
    protected static final Logger LOG = LogManager.getLogger(Config.class.getName());
    
    @SerializedName("objects"     ) public List<DataObject     > _CmsData     = new ArrayList<DataObject     >();
    
    public transient String _RootFolder = null;
    
    public static Config fromFile(String FilePath)
      {
        Reader R = null;        
        try
          {
            LOG.debug("Looking for data definition file or resource "+FilePath+".");
            R = FileUtil.getReaderFromFileOrResource(FilePath);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Config Cfg = gson.fromJson(R, Config.class);
            Cfg._RootFolder = FileUtil.getBasePathFromFileOrResource(FilePath);
            //  -silentMode=0 ${project_loc:CMSData}/config.CMS.json
            return Cfg;
          }
        catch (Throwable T)
          {
            LOG.error("Cannot load from file '" + FilePath + "'.", T);
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
