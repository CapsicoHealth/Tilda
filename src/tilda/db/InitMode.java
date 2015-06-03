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

package tilda.db;

public enum InitMode
  {
    /**
     * The object was instanciated via a lookup call
     */
    LOOKUP, 
    
    /**
     * The object was instanciated via a create call
     */
    CREATE,
    
    /**
     * The object was Write()
     */
    WRITTEN, 
    
    /**
     * The object was Read()
     */
    READ,
    
    /**
     * The object was Read() and then Write()
     */
    READ_WRITTEN; 
    

    public static InitMode parse(String Str)
      {
        for (InitMode e : InitMode.values())
          if (Str.equalsIgnoreCase(e.name()) == true)
            return e;
        return null;
      }

  }
