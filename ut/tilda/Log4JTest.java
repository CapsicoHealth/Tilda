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
import tilda.utils.NumberFormatUtil;
import tilda.utils.SystemValues;

public class Log4JTest
  {
    protected static final Logger Log = LogManager.getLogger(Log4JTest.class.getName());
    
    protected static final int MAX = 400;

    public static void main(String[] args)
      {
        SystemValues.autoInit(); // Important to initialize several pieces of infrastructure, including logging
        long T0 = System.nanoTime();
        for (int i = 0; i < MAX; ++i)
          {
            for (int j = 0; j < MAX; ++j)
              {
                Log.fatal("Fatal i=" + i + "; j=" + j + ";");
                Log.error("Error i=" + i + "; j=" + j + ";");
                Log.warn("Warn  i=" + i + "; j=" + j + ";");
                Log.info("Info  i=" + i + "; j=" + j + ";");
                Log.debug("Debug i=" + i + "; j=" + j + ";");
                Log.trace("Trace i=" + i + "; j=" + j + ";");
              }
          }
        System.out.println("Printed " + NumberFormatUtil.PrintWith000Sep(MAX * MAX * 6)
            + " records to the log file in " + DurationUtil.PrintDurationSeconds(System.nanoTime() - T0) 
            + " ("+DurationUtil.PrintPerformancePerSecond(System.nanoTime() - T0, MAX * MAX * 6)+" msg/s).");
      }
  }
