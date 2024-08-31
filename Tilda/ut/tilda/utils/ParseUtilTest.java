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

public class ParseUtilTest
  {
    protected static final Logger LOG = LogManager.getLogger(ParseUtilTest.class.getName());

    public static void main(String[] args)
      {
        Test1();
      }

    private static void Test1()
      {
        int i = ParseUtil.parseInteger(null, SystemValues.EVIL_VALUE);
        LOG.debug("null -> "+i);

        i = ParseUtil.parseInteger("", SystemValues.EVIL_VALUE);
        LOG.debug("'' -> "+i);
        
        i = ParseUtil.parseInteger("aaa", SystemValues.EVIL_VALUE);
        LOG.debug("'aaa' -> "+i);
        
        i = ParseUtil.parseInteger("123", SystemValues.EVIL_VALUE);
        LOG.debug("'123' -> "+i);
        
        double f = ParseUtil.parseDouble("1e+05", SystemValues.EVIL_VALUE);
        LOG.debug("(double)'1e+05' -> "+f);
        
        i = ParseUtil.parseIntegerFlexible("1e+05", SystemValues.EVIL_VALUE);
        LOG.debug("(int)'1e+05' -> "+i);
        
        long l = ParseUtil.parseLongFlexible("92233720368547758e+02", SystemValues.EVIL_VALUE);
        LOG.debug("(long)'1e+10' -> "+l);
      }

  }
