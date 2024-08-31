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

package tilda.db.config;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.utils.TextUtil;

public class ConnDefs
  {
    /*@formatter:off*/
    @SerializedName("connections"      ) public Conn[]      _Conns       = new Conn[0];
    @SerializedName("email"            ) public EmailConfig _EmailConfig;
    @SerializedName("initDebug"        ) public boolean     _InitDebug = false;
    @SerializedName("skipValidation"   ) public boolean     _SkipValidation = false;
    @SerializedName("dependencySchemas") public String[]    _DependencySchemas = {};
    /*@formatter:on*/
    
    /**
     * Can be set to true right before activating any connection to skip Tilda infrastructure initialization.
     */
    public static boolean _SKIP_TILDA_LOADING = false;

    static final Logger LOG             = LogManager.getLogger(ConnDefs.class.getName());

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
