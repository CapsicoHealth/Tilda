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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;
import tilda.utils.FileUtil;
import tilda.utils.NumberFormatUtil;

public class LineCount
  {
    protected static final Logger LOG = LogManager.getLogger(LineCount.class.getName());

    public static void main(String[] args)
      {
        try
          {
            if (args.length < 1)
              {
                System.err.println("Program needs at least 1 argument: <source_file>+.");
                System.exit(-1);
              }

            for (String fileName : args)
              {
                BufferedReader In = null;
                long TS = System.nanoTime();
                int i = 0;
                try
                  {
                    LOG.info("Counting lines in '" + fileName + "'.");
                    In = new BufferedReader(FileUtil.getReaderFromFileOrResource(fileName));
                    String line = In.readLine();
                    while (line != null)
                      {
                        ++i;
                        if (i % 5_000_000 == 0)
                          LOG.info("Processed " + NumberFormatUtil.PrintWith000Sep(i) + " lines so far at " + NumberFormatUtil.PrintWith1DecAnd000Sep(DurationUtil.perSecond(System.nanoTime() - TS, i)) + " lines/s.");
                        line = In.readLine();
                      }
                  }
                finally
                  {
                    if (In != null)
                     In.close();
                  }
                TS = System.nanoTime() - TS;
                LOG.info("Processed " + NumberFormatUtil.PrintWith000Sep(i) + " lines for '" + fileName + "' in " + DurationUtil.PrintDuration(TS) + " (" + NumberFormatUtil.PrintWith1DecAnd000Sep(DurationUtil.perSecond(TS, i)) + " lines/s).");
              }
          }
        catch (Throwable T)
          {
            T.printStackTrace();
          }
        LOG.info("DONE");
      }
  }
