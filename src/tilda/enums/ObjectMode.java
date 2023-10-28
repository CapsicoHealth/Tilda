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

package tilda.enums;

public enum ObjectMode
  {
    /**
     * Normal Object, i.e., generate both DB and Code artifacts
     */
    NORMAL, 
    
    /**
     * Only the database-side artifacts are generated (could be a temporary table needed for a database-side model, but no need for 
     * code being generated on the Java side (for example)
     */
    DB_ONLY,
    
    /**
     * Only the code-side artifacts are generated and nothing is defined in the DB. This is useful to customize a complex query where
     * columns are known in advance and reuse JDBC Row handling, queries, JSON formatting etc on the code-side.
     */
    CODE_ONLY,

    /**
     * No code or database assets is generated at all. The object exists purely as meta-data, for example, to map to a custom table/view not defined in Tilda per se.
     */
    NONE;
    
    public static ObjectMode parse(String Str)
      {
        for (ObjectMode e : ObjectMode.values())
          if (Str.equalsIgnoreCase(e.name()) == true)
            return e;
        return null;
      }

  }
