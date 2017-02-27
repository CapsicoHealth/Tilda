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

public enum JoinType
  {
    INNER, 
    
    LEFT,
    
    RIGHT,

    OUTER;

    public static JoinType parse(String Str)
      {
        for (JoinType e : JoinType.values())
          if (Str.equalsIgnoreCase(e.name()) == true)
            return e;
        return null;
      }
    
    public static String printJoinType(JoinType JT)
     {
       return JT == null || JT==JoinType.INNER ? "inner join" : JT == JoinType.LEFT ? "left  join" : JT == JoinType.RIGHT ? "right join" : "full join";
     }

  }
