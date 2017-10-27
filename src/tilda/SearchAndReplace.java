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

import java.io.BufferedReader;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;
import tilda.utils.FileUtil;
import tilda.utils.NumberFormatUtil;

public class SearchAndReplace
  {
    protected static final Logger LOG = LogManager.getLogger(SearchAndReplace.class.getName());

    public static void main(String[] args)
      {
        try
          {
            if (args.length != 4)
              {
                System.err.println("Program needs 4 arguments: <source_file> <dest_file> <search_regex> <replace_str>.");
                System.exit(-1);
              }
            if (args[0].equalsIgnoreCase(args[1]) == true)
              {
                System.err.println("The source and destination files ar ethe same.");
                System.exit(-1);
              }
            
            LOG.info("Replacing '"+args[2]+"' with '"+args[3]+"'.");

            BufferedReader In = new BufferedReader(FileUtil.getReaderFromFileOrResource(args[0]));
            PrintWriter Out = FileUtil.getBufferedPrintWriter(args[1], false);
            int i = 0;
            long TS = System.nanoTime();
            try
              {
                String line = In.readLine();
                while (line != null)
                  {
                    String newLine = line.replaceAll(args[2], args[3]);
                    Out.println(newLine);
                    ++i;
                    if (i % 1000000 == 0)
                      LOG.info("Processed "+NumberFormatUtil.PrintWith000Sep(i)+" lines so far at "+NumberFormatUtil.PrintWith1DecAnd000Sep(DurationUtil.perSecond(System.nanoTime()-TS, i))+" lines/s.");
                    line = In.readLine();
                  }
              }
            finally
              {
                In.close();
                Out.flush();
                Out.close();
              }
            TS = System.nanoTime()-TS;
            LOG.info("Processed "+NumberFormatUtil.PrintWith000Sep(i)+" lines in total in "+DurationUtil.PrintDuration(TS)+" ("+NumberFormatUtil.PrintWith1DecAnd000Sep(DurationUtil.perSecond(TS, i))+" lines/s).");
          }
        catch (Throwable T)
          {
            T.printStackTrace();
          }
        LOG.info("DONE");
      }
  }
