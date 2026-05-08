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

public enum DefaultType
{
  /**
   * Not a default value
   */
  NONE,

  /**
   * A masking value
   */
  MASK,

  /**
   * A default value only at create time
   */
  CREATE,
  
  /**
   * A default value only at update time
   */
  UPDATE,
  
  /**
   * A default value both at create and update time
   */
  ALWAYS;
  
  public static DefaultType parse(String Str)
    {
      for (DefaultType e : DefaultType.values())
        if (Str.equalsIgnoreCase(e.name()) == true)
          return e;
      return null;
    }

}
