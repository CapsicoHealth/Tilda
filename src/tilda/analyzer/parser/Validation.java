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

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.db.Connection;
import tilda.db.SelectQuery;
import tilda.db.processors.ScalarRP;

public class Validation
  {
    @SerializedName("name") public String _Name     = null;
    @SerializedName("table") public String _Table     = null;
    @SerializedName("schema") public String _Schema     = null;
    @SerializedName("rules") public List<String> _Rules     = new ArrayList<String>();
    protected static final Logger LOG = LogManager.getLogger(Validation.class.getName());
    
    public void validateRules(Connection C) throws Exception
    {
      // Need to create an arbitrary select value instead of column.
      String Rule = null;
      try
        {

          for(String SubWhereClause : _Rules)
            {
              SelectQuery SQ = new SelectQuery(C, _Schema, _Table, true);
              SQ.selectCountStar().from(_Schema, _Table);
              Rule = SubWhereClause;
              SQ.where().subWhere(SubWhereClause);
              ScalarRP RP = new ScalarRP();
              SQ.execute(RP, 0, 1);
            }
        }
      catch(Exception E)
        {
           LOG.debug("Error in rule definition with sub where cluase :"+Rule, E);
           throw E;
        }
    }
    
  }
