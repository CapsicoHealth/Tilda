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

package tilda.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

/**
 * <A href="http://en.wikipedia.org/wiki/ANSI_escape_code">http://en.wikipedia.org/wiki/ANSI_escape_code</A>
 * 
 * @author ldh
 *
 */
public class LogUtil
  {
    protected static final Logger LOG               = LogManager.getLogger(LogUtil.class.getName());

    protected static Level        _originalLogLevel = null;

    public static void setLogLevel(Level NewLevel)
      {
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
        Level OldLevel = loggerConfig.getLevel();
        if (OldLevel != NewLevel)
          {
            loggerConfig.setLevel(NewLevel);
            ctx.updateLoggers(); // This causes all Loggers to refetch information from their LoggerConfig.
          }
        if (_originalLogLevel == null)
          _originalLogLevel = OldLevel;
      }

    public static void resetLogLevel()
      {
        if (_originalLogLevel != null)
          {
            setLogLevel(_originalLogLevel);
            _originalLogLevel = null;
          }
      }


    /**
     * Logs the Throwable using the provided Logger, then logs the throwable causes up to causeLevel. If causeLevel is 0, then
     * no sub-causes are logged. If there are no sub-causes, then causeLevel is ignored.
     * @param log the Logger to log the Throwable against, using catching()
     * @param T the Throwable to log
     * @param causeLevel the number of levels deep to also log the Throwable's sub causes if any.
     */
    public static final void logThrowables(Logger log, Throwable T, int causeLevel)
      {
        log.catching(T);
        while (causeLevel > 0)
          {
            T = T.getCause();
            if (T == null)
             return;
            log.catching(T);
            --causeLevel;
          }
      }
  }
