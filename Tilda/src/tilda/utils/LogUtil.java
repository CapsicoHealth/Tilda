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

    protected static java.util.Map<LoggerConfig, Level> _originalLogLevels = null;

    /**
     * Sets the level on the root logger AND all explicitly configured loggers (which would otherwise
     * ignore the root level), remembering the original levels so they can be restored by resetLogLevel().
     */
    public static synchronized void setLogLevel(Level NewLevel)
      {
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        if (_originalLogLevels == null)
          {
            _originalLogLevels = new java.util.IdentityHashMap<LoggerConfig, Level>();
            _originalLogLevels.put(config.getRootLogger(), config.getRootLogger().getLevel());
            for (LoggerConfig lc : config.getLoggers().values())
              _originalLogLevels.put(lc, lc.getLevel());
          }
        for (LoggerConfig lc : _originalLogLevels.keySet())
          lc.setLevel(NewLevel);
        ctx.updateLoggers(); // This causes all Loggers to refetch information from their LoggerConfig.
      }

    public static synchronized void resetLogLevel()
      {
        if (_originalLogLevels != null)
          {
            LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
            for (java.util.Map.Entry<LoggerConfig, Level> e : _originalLogLevels.entrySet())
              e.getKey().setLevel(e.getValue());
            _originalLogLevels = null;
            ctx.updateLoggers();
          }
      }


    /**
     * Logs the Throwable using the provided Logger, then logs the throwable causes up to causeLevel. If causeLevel is 0, then
     * no sub-causes are logged. If there are no sub-causes, then causeLevel is ignored.
     * 
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

    public static String logError(Logger l, String msg)
      {
        l.error(msg);
        return msg;
      }
  }
