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
import tilda.utils.RandomUtil;
import tilda.utils.SystemValues;

public class PerfTests
  {
    protected static final Logger Log = LogManager.getLogger(PerfTests.class.getName());
    
    protected static final int MAX = 400;

    public static void main(String[] args)
      {
        SystemValues.autoInit(); // Important to initialize several pieces of infrastructure, including logging
        long x1 = (long) (RandomUtil.pick(0.5) == true ? 0 : RandomUtil.pick(0, Long.MAX_VALUE));
        long x2 = (long) (RandomUtil.pick(0.5) == true ? 0 : RandomUtil.pick(0, Long.MAX_VALUE));
        int x = 0;
        final int Max = 1000000000;

        long T0 = System.nanoTime();
        for (int i = 0; i < Max; ++i)
          {
            if (x1+x2 == 0L)
             ++x;
          }
        T0 = System.nanoTime() - T0;
        System.out.println("if (x1+x2 == 0L): " + DurationUtil.PrintDurationSeconds(T0)+ " ("+DurationUtil.PrintPerformancePerSecond(T0, Max)+" loops/s).");
        
        
        T0 = System.nanoTime();
        for (int i = 0; i < Max; ++i)
          {
            if (x1 == 0L && x2 == 0L)
             ++x;
          }
        T0 = System.nanoTime() - T0;
        System.out.println("if (x1 == 0L && x2 == 0L): " + DurationUtil.PrintDurationSeconds(T0)+ " ("+DurationUtil.PrintPerformancePerSecond(T0, Max)+" loops/s).");
        
      }
  }
