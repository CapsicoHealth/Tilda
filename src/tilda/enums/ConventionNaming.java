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

import java.util.regex.Pattern;

public enum ConventionNaming
  {
  /**
   * No convention set
   */
  NONE(null),

  /**
   * Traditional Java/JS variable naming convention [a-z][a-zA-Z0-9]+ such as "nameTitle", "nameFirst" "dbType" etc...
   */
  CAMEL_CASE_JS(Pattern.compile("[a-z][a-zA-Z0-9]")),

  /**
   * Traditional database-style naming convention [a-z][a-zA-Z0-9_]+ such as "name_title", "name_first", "db_type"
   */
  UNDERSCORE_LOWER_DB(Pattern.compile("[a-z][a-z0-9_]"));

    private ConventionNaming(Pattern p)
      {
        _p = p;
      }

    protected final Pattern _p;

    public static ConventionNaming parse(String Str)
      {
        for (ConventionNaming e : ConventionNaming.values())
          if (Str.equalsIgnoreCase(e.name()) == true)
            return e;
        return null;
      }

    public boolean validateColumnName(String name)
      {
        return _p == null ? true : _p.matcher(name).matches();
      }

    /*
    public static String toCamelCase(String str)
      {
        CaseUtils.class x =  CaseUtils();
        
        return str;
      }
    */
  }
