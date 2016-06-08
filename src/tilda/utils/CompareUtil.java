/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
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

package tilda.utils;

import java.time.ZonedDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompareUtil
  {
    protected static final Logger LOG = LogManager.getLogger(CompareUtil.class.getName());

    public static boolean equals(String Str1, String Str2)
      {
        return Str1 == null ? Str2==null
             : Str2 == null ? Str1==null
             : Str1.equals(Str2);
      }

    public static boolean equals(String Str1, char c)
      {
        return Str1!=null && Str1.length() == 1 && Str1.charAt(0) == c;
      }

    public static boolean equals(ZonedDateTime ZDT1, ZonedDateTime ZDT2)
      {
        return ZDT1 == null ? ZDT2==null
             : ZDT2 == null ? ZDT1==null
             : ZDT1.equals(ZDT2);
      }

    public static int compare(ZonedDateTime ZDT1, ZonedDateTime ZDT2)
      {
        return ZDT1 == null && ZDT2 == null ? 0
             : ZDT1 == null ? -1
             : ZDT2 == null ? 1
             : ZDT1.compareTo(ZDT2);
      }
    
    public static int compare(String Str1, String Str2)
      {
        return Str1 == null && Str2 == null ? 0
             : Str1 == null ? -1
             : Str2 == null ? 1
             : Str1.compareTo(Str2);
      }

    public static boolean like(String Str1, String Str2)
      {
        return Str1 == null || Str2 == null ? false : Str1.matches(Str2.replace("%", ".*").replace('_', '.'));
      }

    public static boolean like(List<String> StrList, String Str2)
      {
        if (StrList == null || StrList.isEmpty() == true || Str2 == null)
         return false;

        Str2 = Str2.replace("%", ".*").replace('_', '.');
        for (String Str : StrList)
         if (Str.matches(Str2) == true)
          return true;
        
        return false;
      }

    public static boolean in(String Str1, String[] Str2Array)
      {
        if (Str1 == null || Str2Array == null || Str2Array.length == 0)
         return false;
        
        for (String Str2 : Str2Array)
          if (Str1.equals(Str2) == true)
           return true;

        return false;
      }
  }
