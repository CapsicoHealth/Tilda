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
    protected static final Logger LOG = LogManager.getLogger(Log4JTest.class.getName());

    protected static final int    MAX = 250;

    public static void main(String[] args)
      {
        SystemValues.autoInit(); // Important to initialize several pieces of infrastructure, including logging
        long T2 = test2_log();
        long T3 = test3_out();
        System.out.println("Time T2_LOG: "+DurationUtil.printDurationMilliSeconds(T2));
        System.out.println("Time T3_OUT: "+DurationUtil.printDurationMilliSeconds(T3));
      }

    protected static void test1()
      {
        long T0 = System.nanoTime();
        long count = 0;
        for (int i = 0; i < MAX; ++i)
          {
            for (int j = 0; j < MAX; ++j)
              {
                LOG.fatal("Fatal i=" + i + "; j=" + j + ";");
                LOG.error("Error i=" + i + "; j=" + j + ";");
                LOG.warn("Warn   i=" + i + "; j=" + j + ";");
                LOG.info("Info   i=" + i + "; j=" + j + ";");
                LOG.debug("Debug i=" + i + "; j=" + j + ";");
                LOG.trace("Trace i=" + i + "; j=" + j + ";");
                count += 6;
              }
          }
        T0 = System.nanoTime() - T0;
        LOG.info("Printed " + NumberFormatUtil.printWith000Sep(count)
        + " records to the log file in " + DurationUtil.printDuration(T0)
        + " (" + DurationUtil.printPerformancePerSecond(T0, count) + " msg/s).");
      }

    public static long test2_log()
      {
        long TS = System.nanoTime();
        System.out.println("Hello!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        for (int i = 0; i < 10000; ++i)
         LOG.debug("   - "+i);
        return System.nanoTime() - TS;
      }

    public static long test3_out()
      {
        long TS = System.nanoTime();
        System.out.println("Hello!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        for (int i = 0; i < 10000; ++i)
          System.out.println("   - "+i);
        return System.nanoTime() - TS;
      }
 }

/*
 * CONSOLE: <pattern>%d{MMdd.HHmmss.SSS}#%-3t %level{length=1} %15.15c{1}| %m%ex{20}%n</pattern>
 * - 160K msg/s
 * 
 * CONSOLE: <pattern>%highlight{%d{MMdd.HHmmss.SSS}#%-3t %level{length=1} %15.15c{1}| %m%ex{20}%n}</pattern>
 * - 2.1K msg/s
 * 
 * 
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
 * <Configuration status="info">
 * <Properties>
 * <Property name="log-path">C:\Projects\TomcatDevServer\logs\</Property>
 * <Property name="now">${sys:startup}</Property>
 * </Properties>
 * <Appenders>
 * <RollingFile name="FILES" fileName="${log-path}/aaa.log" filePattern="${log-path}/aaa.${now}.%i.log.gz">
 * <PatternLayout>
 * <pattern>%d{MMdd.HHmmss.SSS}#%-3t %level{length=1} %15.15c{1}| %m%ex{20}%n</pattern>
 * </PatternLayout>
 * <Policies>
 * <SizeBasedTriggeringPolicy size="100 MB" />
 * </Policies>
 * <DefaultRolloverStrategy max="99999" compressionLevel="6"/>
 * </RollingFile>
 * <Async name="ASYNC">
 * <AppenderRef ref="FILES" />
 * </Async>
 * <Console name="Console" target="SYSTEM_OUT">
 * <PatternLayout>
 * <pattern>%d{MMdd.HHmmss.SSS}#%-3t %level{length=1} %15.15c{1}| %m%ex{20}%n</pattern>
 * <!--
 * <pattern>%highlight{%d{MMdd.HHmmss.SSS}#%-3t %level{length=1} %15.15c{1}| %m%ex{20}%n}</pattern>
 * -->
 * </PatternLayout>
 * </Console>
 * </Appenders>
 * <Loggers>
 * <Root level="debug">
 * <AppenderRef ref="Console" />
 * <!--
 * <AppenderRef ref="ASYNC" />
 * <AppenderRef ref="Console" />
 * -->
 * </Root>
 * </Loggers>
 * </Configuration>
 * 
 */
