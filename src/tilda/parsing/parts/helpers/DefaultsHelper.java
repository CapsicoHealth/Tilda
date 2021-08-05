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

package tilda.parsing.parts.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.OutputMap;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.SubWhereClause;


public class DefaultsHelper
  {
    static final Logger LOG = LogManager.getLogger(DefaultsHelper.class.getName());

    public static void defaultOutputmap(ParserSession PS, Base b)
      {
      }

    /**
     * Must be called after parent object has been validated.
     * @param PS
     * @param b
     */
    public static void defaultAllQuery(ParserSession PS, Base b)
      {
        if (b.getQuery("All") != null)
         return;
        
        if (b instanceof tilda.parsing.parts.Object) // we also need to check indices for clashing names.
          {
            if (((tilda.parsing.parts.Object)b).getIndex("All") != null)
             return;
          }
        
        SubWhereClause swc = new SubWhereClause();
        swc._Name = "All";
        swc._Description = "Default generated 'All' query";
        swc._Wheres = new Query[] { new Query("1=1") };
        swc._OrderBy = b.getFirstIdentityColumnNames(true);
        
        b._Queries.add(swc);
      }

    public static void defaultOutputMap(ParserSession PS, Base b)
      {
        OutputMap om = b.getOutputMap("");
        if (om != null)
         return;
        
        om = new OutputMap();
        om._Name = "";
        om._Columns=new String[] {"*"};
        om._OutputTypeStrs = new String[] {"CSV","JSON"};
        
        b._OutputMaps.add(om);
      }
    
  }
