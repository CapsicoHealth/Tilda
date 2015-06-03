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

package tilda.parsing.parts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SubWhereClauseTest
  {
    protected static final Logger LOG = LogManager.getLogger(SubWhereClauseTest.class.getName());

    public static void main(String[] args)
      {
        Pattern P = Pattern.compile("\\W([a-zA-Z_]\\w*)\\W*\\?\\(\\s*([a-z_A-Z]\\w*)\\s*\\)");
//        Pattern P = Pattern.compile("([a-zA-Z_]\\w*)");
        
        String Query = "deleted is null and max >= ?(Lower) and max < ?(Upper)";
        
        Matcher M = P.matcher(Query);
        
        while (M.find() == true)
          {
            LOG.debug("match: "+M.group());
            String col = M.group(1);
            String var = M.group(2);
            LOG.debug("col: "+col+"; var: "+var);
          }
            
         
      }
  }
