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
import tilda.utils.ParseUtil;
import tilda.utils.SystemValues;

public class LinePrint
  {
    protected static final Logger LOG = LogManager.getLogger(LinePrint.class.getName());

    public static void main(String[] args)
      {
        try
          {
            System.err.println("LinePrint exract specific lines from line-oriented text files. It's useful for example to");
            System.err.println("see line #78763 from a large CSV file causing an error in a loading program when the CSV");
            System.err.println("file is too large to load in any regular editor.");
            System.err.println();
            System.err.println("LinePrint needs 3 argument: <source_file> <start_line> <end_line>?.");
            System.err.println("  - The source file");
            System.err.println("  - The start line number, starting from line 0");
            System.err.println("  - Optionally an end line number of a block of lines are to be printed (inclusive)");
            System.err.println();
            System.err.println("Note: if your file is very large and you are looking for a line near the end, the utiliry will");
            System.err.println("     have to scan theentire file, which might take some time.");
            System.err.println("Note: if you are printing a large number of lines, i.e., the number of lines between start");
            System.err.println("     and end is large, the utility might take some longer time, and the output might not be");
            System.err.println("     very useful.");
            System.err.println("Note: If you are looking at a block of lines, it should be easy to pipe the output to a temporary");
            System.err.println("     file that you can then open in any regular text editor.");

            if (args.length < 2)
              {
                System.err.println();
                System.err.println("ERROR: Only " + args.length + " parameters were found. At least 2 were expected.");
                System.exit(-1);
              }

            String fileName = args[0];
            int lineStart = ParseUtil.parseInteger(args[1], SystemValues.EVIL_VALUE);
            int lineEnd = args.length == 2 ? lineStart : ParseUtil.parseInteger(args[2], SystemValues.EVIL_VALUE);

            if (lineStart < 0)
              {
                System.err.println();
                System.err.println("ERROR: the second argument <start_line> is '" + args[1] + "' which is not an integer value.");
                System.exit(-1);
              }
            if (lineEnd < lineStart)
              {
                System.err.println();
                System.err.println("ERROR: the third argument <end_line> is '" + args[1] + "' which is not an integer value or a vallue less than <start_line>.");
                System.exit(-1);
              }

            BufferedReader In = null;
            long TS = System.nanoTime();
            int i = 0;
            try
              {
                In = new BufferedReader(FileUtil.getReaderFromFileOrResource(fileName));
                LOG.info("Counting lines in '" + fileName + "'.");
                String line = In.readLine();
                while (line != null)
                  {
                    if (i >= lineStart && i <= lineEnd)
                     System.out.println(line);
                    else if (i % 5_000_000 == 0)
                     LOG.info("Processed " + NumberFormatUtil.printWith000Sep(i) + " lines so far at " + NumberFormatUtil.printWith1DecAnd000Sep(DurationUtil.perSecond(System.nanoTime() - TS, i)) + " lines/s.");
                    ++i;
                    if (i > lineEnd)
                     break;
                    line = In.readLine();
                  }
              }
            finally
              {
                if (In != null)
                  In.close();
              }
            TS = System.nanoTime() - TS;
            LOG.info("Processed " + NumberFormatUtil.printWith000Sep(i) + " lines for '" + fileName + "' in " + DurationUtil.printDuration(TS) + " (" + NumberFormatUtil.printWith1DecAnd000Sep(DurationUtil.perSecond(TS, i)) + " lines/s).");
          }
        catch (Throwable T)
          {
            T.printStackTrace();
          }
        LOG.info("DONE");
      }
  }
