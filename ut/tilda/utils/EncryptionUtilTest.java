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

public class EncryptionUtilTest
  {
    protected static final Logger LOG = LogManager.getLogger(EncryptionUtilTest.class.getName());

    public static void main(String[] args)
      {
        Test1();
        LOG.debug("END");
      }

    private static void Test1()
      {
        LOG.debug("First column is AlphaNum only, while second column is all characters, and third column is default (which should be ALL characters as well)");
        for (int i = 0; i < 10; ++i)
         LOG.debug(EncryptionUtil.getToken(8, true) + "   -   "+EncryptionUtil.getToken(8, false)+ "   -   "+EncryptionUtil.getToken(8));
      }

  }
