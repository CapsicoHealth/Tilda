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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <A href="http://en.wikipedia.org/wiki/ANSI_escape_code">http://en.wikipedia.org/wiki/ANSI_escape_code</A>
 * @author ldh
 *
 */
public class AnsiUtil
  {
    protected static final Logger LOG = LogManager.getLogger(AnsiUtil.class.getName());

    public static final String RESET  = ""; //\u001B[0m";
    public static final String BLACK  = ""; //\u001B[30m";
    public static final String RED    = ""; //\u001B[31m";
    public static final String GREEN  = ""; //\u001B[32m";
    public static final String YELLOW = ""; //\u001B[33m";
    public static final String BLUE   = ""; //\u001B[34m";
    public static final String PURPLE = ""; //\u001B[35m";
    public static final String CYAN   = ""; //\u001B[36m";
    public static final String WHITE  = ""; //\u001B[37m";
    
    public static final String BOLD          = ""; //\u001B[1m";
    public static final String BOLD_OFF      = ""; //\u001B[22m";
    public static final String ITALIC        = ""; //\u001B[3m";
    public static final String ITALIC_OFF    = ""; //\u001B[23m";
    public static final String NEGATIVE      = ""; //\u001B[7m";
    public static final String NEGATIVE_OFF  = ""; //\u001B[27m";
    public static final String UNDERLINE     = ""; //\u001B[4m";
    public static final String UNDERLINE_OFF = ""; //\u001B[24m";
    public static final String OVERLINED     = ""; //\u001B[53m";
    public static final String OVERLINED_OFF = ""; //\u001B[55m";
    
  }
