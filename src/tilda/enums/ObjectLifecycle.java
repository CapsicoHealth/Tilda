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

public enum ObjectLifecycle
  {
    /**
     * A normal object
     */
    NORMAL,
    
    /**
     * A readonly object: the generated code will not include create, update, delete and setters. It is assumed the
     * object is created separately from the application and shoulnd't be modified.
     */
    READONLY,
    
    /**
     * An object which can be initially created in the application, but cannot be updated thereafter. This is useful for logs
     * for example. 
     */
    WORM;
    
    public static ObjectLifecycle parse(String str)
      {
        for (ObjectLifecycle e : ObjectLifecycle.values())
          if (e.name().equalsIgnoreCase(str) == true)
            return e;
        return null;
      }
    
  }
