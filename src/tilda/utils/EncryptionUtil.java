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

import java.security.MessageDigest;
import java.security.SecureRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;

public class EncryptionUtil
  {

    protected static final Logger LOG = LogManager.getLogger(EncryptionUtil.class.getName());

    public static String hash(String plaintext)
      {
        if (TextUtil.isNullOrEmpty(plaintext) == true)
          return null;
        try
          {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(plaintext.getBytes("UTF-8"));
            return new String((new Base64()).encode(md.digest()));
          }
        catch (Exception e)
          {
            LOG.error(e);
            return null;
          }
      }


    public static String getToken(int size)
      {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[size < 16 ? 16 : size];
        random.nextBytes(bytes);
        return bytes.toString();
      }
  }
