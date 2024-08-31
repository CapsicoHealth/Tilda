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
import tilda.utils.ParseUtil;
import tilda.utils.SystemValues;

public class LineSplit
  {
    protected static final Logger LOG = LogManager.getLogger(LinePrint.class.getName());

    public static void main(String[] args)
      {
        try
          {
            System.err.println("LineSplit splits a file into smaller files in chuncks of a specified number of lines.");
            System.err.println();
            System.err.println("LineSplit needs 2 argument: <source_file> <max_lines> {<chunk_start> <chunk_end>?}?.");
            System.err.println("  - The source file");
            System.err.println("  - The number of lines per file (greater than 0)");
            System.err.println("  - The chunk id to start outputing data from (starting with 1)");
            System.err.println("  - The chunk id to end outputing data (inclusive)");
            System.err.println();
            System.err.println("Note: The utility will output files with a partXXX marker.");
            System.err.println("Note: This operation will double the amount of disk space your data effectively takes.");

            if (args.length != 2)
              {
                System.err.println();
                System.err.println("ERROR: " + args.length + " parameters were found when 2 are expected.");
                System.exit(-1);
              }

            String fileName = args[0];
            int max_lines = ParseUtil.parseInteger(args[1], SystemValues.EVIL_VALUE);
            int chunk_start = args.length <= 2 ? 1 : ParseUtil.parseInteger(args[2], SystemValues.EVIL_VALUE);
            int chunk_end = args.length <= 3 ? -1 : ParseUtil.parseInteger(args[3], SystemValues.EVIL_VALUE);

            if (max_lines <= 0)
              {
                System.err.println();
                System.err.println("ERROR: the second argument <max_lines> is '" + args[1] + "' which is not a positive integer value > 0.");
                System.exit(-1);
              }
            if (chunk_start <= 0)
              {
                System.err.println();
                System.err.println("ERROR: the third argument <chunk_start> is '" + args[2] + "' which is not a positive integer value > 0.");
                System.exit(-1);
              }
            if (chunk_end < -1)
              {
                System.err.println();
                System.err.println("ERROR: the third argument <chunk_end> is '" + args[3] + "' which is not an integer value.");
                System.exit(-1);
              }
            if (chunk_end != -1 && chunk_end < chunk_start)
              {
                System.err.println();
                System.err.println("ERROR: the third argument <chunk_end> is '" + args[3] + "' which is smaller than <chunk_start>='"+chunk_start+"'.");
                System.exit(-1);
              }

            BufferedReader In = null;
            long TS = System.nanoTime();
            int i = 0;
            int part = 1;
            PrintWriter out = null;
            try
              {
                In = new BufferedReader(FileUtil.getReaderFromFileOrResource(fileName));
                int period = fileName.lastIndexOf(".");
                String fileNamePart = period == -1 ? fileName : fileName.substring(0, period);
                String fileNameExt = period == -1 ? "" : fileName.substring(period+1);
                if (part >= chunk_start && (chunk_end == -1 || part <= chunk_end))
                 out = new PrintWriter(fileNamePart+".part"+NumberFormatUtil.leadingZero2(part)+"."+fileNameExt);
                LOG.info("Counting lines in '" + fileName + "'.");
                String line = In.readLine();
                while (line != null)
                  {
                    if (out != null)
                     out.println(line);
                    if (i != 0 && i % max_lines == 0)
                      {
                        if (out != null)
                         out.close();
                        ++part;
                        if (part > chunk_end)
                          break;
                        if (part >= chunk_start)
                         out = new PrintWriter(fileNamePart+".part"+NumberFormatUtil.leadingZero2(part)+"."+fileNameExt);
                      }
                    if (i % 5_000_000 == 0)
                     LOG.info("Processed " + NumberFormatUtil.printWith000Sep(i) + " lines so far at " + NumberFormatUtil.printWith1DecAnd000Sep(DurationUtil.perSecond(System.nanoTime() - TS, i)) + " lines/s.");
                    ++i;
                    line = In.readLine();
                  }
              }
            finally
              {
                if (In != null)
                  In.close();
                if (out != null)
                 out.close();
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
