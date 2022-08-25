/* ===========================================================================
 * Copyright (C) 2022 CapsicoHealth Inc.
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

package tilda.enums;

public enum ConventionNaming
  {
    /**
     * No convention set
     */
    NONE, 
    
    /**
     * Traditional Java/JS variable naming convention [a-z][a-zA-Z0-9]+ such as "nameTitle", "nameFirst" "dbType" etc...
     */
    CAMEL_CASE_JS,
    
    /**
     * Traditional database-style naming convention [a-z][a-zA-Z0-9_]+ such as "name_title", "name_first", "db_type"
     */
    UNDERSCORE_LOWER_DB;

    public static ConventionNaming parse(String Str)
      {
        for (ConventionNaming e : ConventionNaming.values())
          if (Str.equalsIgnoreCase(e.name()) == true)
            return e;
        return null;
      }

  }
