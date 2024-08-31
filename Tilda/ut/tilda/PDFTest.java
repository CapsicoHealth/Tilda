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

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;
import tilda.utils.TextUtil;

public class PDFTest
  {
    protected static final Logger LOG = LogManager.getLogger(PDFTest.class.getName());

    protected static final int    MAX = 250;
    
    protected static boolean filteredIn(String[] filters, String filePath)
     {
       if (filters.length == 0)
        return true;
       for (int i = 0; i < filters.length; ++i)
         if (filePath.endsWith(filters[i]) == true)
          return true;
       return false;
     }

    public static void main(String[] args) throws Exception
      {
        String path = "C:\\Users\\LaurentHasson\\Downloads\\cardiac-docs\\";
        String[] filter = {
//            "A Review and Meta Analysis of the Safety and Efficacy of Using Glucagon like Peptide 1 Receptor Agonists.pdf"
//                           ,"Annual prognostic factors in chronic heart failure in patients over 80 years old..pdf"
        };

        File dir = new File(path);
        File[] files = dir.listFiles();
        long TS = System.nanoTime();
        int count = 0;
        System.out.println("Processing "+files.length+" documents");
        for (File f : files)
          {
            if (f.getName().toLowerCase().endsWith(".pdf") == true)
              {
                if (filteredIn(filter, f.getName()) == false)
                 continue;
                if (count % 20 == 0)
                  System.out.println("So far, processed "+count+" documents in "+DurationUtil.printDuration(System.nanoTime()-TS)+" ("+DurationUtil.perMinute(System.nanoTime()-TS, count)+" docs/mn)");
                ++count;
                String txt = TextUtil.PDF2TXT(f);
                if (filter.length == 0)
                 continue;
                System.out.println("\n\n"+f.getName()+"\n");
                System.out.println(txt);
              }
          }
        TS = System.nanoTime() - TS;
        System.out.println("Documents processed: "+count);
        System.out.println("Total time: "+DurationUtil.printDuration(TS)+" ("+DurationUtil.perMinute(TS, count)+" docs/mn)");
      }
 }
