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

import java.time.ZonedDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class SystemValues
  {

    /** Using -1 or 0 for an error value is so boring.... -666 is so much more attention-grabbing. */
    public static final short         EVIL_VALUE      = -666;
    public static final String        EMPTY_STR       = new String("");

    public static final ZonedDateTime STARTUP_DATE    = ZonedDateTime.now();
    public static final String        STARTUP_DATE_STR= DateTimeUtil.printDateTimeSuperCompact(STARTUP_DATE);
    public static final long          STARTUP_DATE_MS = STARTUP_DATE.toInstant().toEpochMilli();

    public static final String        NEWLINE         = System.getProperty("line.separator");
    public static final String        NEWLINEx2       = NEWLINE + NEWLINE;
    public static final String        NEWLINEx3       = NEWLINE + NEWLINE + NEWLINE;
    public static final String        NEWLINEx4       = NEWLINE + NEWLINE + NEWLINE + NEWLINE;

    static final Logger               LOG             = LogManager.getLogger(SystemValues.class.getName());

    static
      {
        System.setProperty("startup", STARTUP_DATE_STR);
        org.apache.logging.log4j.core.LoggerContext ctx = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        ctx.reconfigure();
        LOG.info("System startup on " + DateTimeUtil.printDateTimeFriendly(STARTUP_DATE, true, true));
      }

    public static void autoInit()
      {
      }

    // A rare combination of characters used for separating values in a long string
    public static final String DEFAULT_SEPARATOR1_BACKQUOTES       = "``";
    public static final String DEFAULT_SEPARATOR2_PIPES            = "||";
    public static final String DEFAULT_SEPARATOR3_TILDAS           = "~~";

    public static final String DEFAULT_SEPARATOR1_BACKQUOTES_regex = "\\`\\`";
    public static final String DEFAULT_SEPARATOR2_PIPES_regex      = "\\|\\|";
    public static final String DEFAULT_SEPARATOR3_TILDAS_regex     = "\\~\\~";
  }
