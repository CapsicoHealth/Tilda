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

package tilda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;
import tilda.utils.HTMLFilter;
import tilda.utils.TextUtil;

public class HTMLFilterTest
  {
    protected static final Logger Log = LogManager.getLogger(HTMLFilterTest.class.getName());
    
    
    private static String CleanAbsolute2(String Str)
      {
        // If Str is null or empty, there is nothing to do.
        if (TextUtil.isNullOrEmpty(Str) == true)
          return Str;

        // Cleanup all
        StringBuilder X = new StringBuilder(128);
        int i = 0;
        while (true)
          {
            int j1 = Str.indexOf('<', i);
            int j2 = Str.indexOf('>', i);
            if (j1 == -1 && j2 == -1)
             break;
            if (j1 != -1 && j1 < j2)
              {
                X.append(Str.substring(i, j1)).append("&lt;");
                i = j1+1;
              }
            else
              {
                X.append(Str.substring(i, j2)).append("&gt;");
                i = j2+1;
              }
          }
        X.append(Str.substring(i));
        return X.toString();
      }
    
    public static final String TestHTML="This is a <B>test</B> to see how it all <I>works</I>, also with <IMG src=\"toto.jpg\"> and <A href=\"/blah.html\">links</A>";
    
    public static void main(String[] args)
    {
      long T0 = System.nanoTime();
      for (int i = 0; i < 10000000; ++i)
        {
          HTMLFilter.cleanAbsolute(TestHTML);
        }
      System.out.println("FilterCleanAbsolute: "+DurationUtil.printDuration(System.nanoTime()-T0));
      
      T0 = System.nanoTime();
      for (int i = 0; i < 10000000; ++i)
        {
          CleanAbsolute2(TestHTML);
        }
      System.out.println("FilterCleanAbsolute2: "+DurationUtil.printDuration(System.nanoTime()-T0));
      
      T0 = System.nanoTime();
      for (int i = 0; i < 10000000; ++i)
        {
          TestHTML.replaceAll("\\<", "&lt;").replaceAll("\\>", "&gt;");
        }
      System.out.println("replaceAll: "+DurationUtil.printDuration(System.nanoTime()-T0));
      
      T0 = System.nanoTime();
      for (int i = 0; i < 10000000; ++i)
        {
          HTMLFilter.cleanSmart("blah", TestHTML);
        }
      System.out.println("FilterCleanSmart: "+DurationUtil.printDuration(System.nanoTime()-T0));
    }
  }
