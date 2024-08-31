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

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncryptionUtil
  {

    protected static final Logger LOG = LogManager.getLogger(EncryptionUtil.class.getName());

    /**
     * For text-base hashing, for example for a password to be saved in a database text field, this method
     * uses the strongest available SHA function (i.e., at this time, SHA-512). You are responsible for
     * salting the plaintext for stronger pswd protection. A Base64 String is returned.
     * 
     * @param plaintext The plaintext password.
     * @param salt The salt, which could be empty, or null (for no salt).
     * @return
     */
    public static String hash(String plaintext, String salt)
      {
        return hashStr(plaintext, salt, "SHA-512");
      }

    /**
     * Returns a byte array for a SHA-256 digest derived from plaintext. This is meant primarily to be used
     * as a key to an AES256 encryption algorithm.<BR>
     * For text-base hashing, for example for a password to be saved in a database text field, make sure you
     * use the plain {@link #hash(String)}.
     * 
     * @param plaintext
     * @return
     */
    public static byte[] hash256(String plaintext, String salt)
      {
        return hashByteArrray(plaintext, salt, "SHA-256");
      }

    protected static String hashStr(String plaintext, String salt, String algo)
      {
        byte[] hash = hashByteArrray(plaintext, salt, algo);
        return hash == null ? null : new String(Base64.getEncoder().encodeToString(hash));
      }

    protected static byte[] hashByteArrray(String plainText, String salt, String shaAlgo)
      {
        if (TextUtil.isNullOrEmpty(plainText) == true)
          return null;
        try
          {
            MessageDigest md5 = MessageDigest.getInstance(shaAlgo);
            byte[] digest = md5.digest((TextUtil.print(salt,"")+plainText).getBytes("UTF-8"));
            return digest;
          }
        catch (Exception e)
          {
            LOG.error("Exception in hashByteArrray()", e);
            return null;
          }
      }

    /**
     * A short-hand version of {@link #getToken(int, boolean)} with alphaNumOnly set to false
     * 
     * @param size The size of the returned String. If size is < 8, then it will be changed to 8. If it's > 254, it will be changed to 254.
     * @return A string of random characters of a minimum size of 8, and maximum size of 254.
     */
    public static String getToken(int size)
      {
        return getToken(size, false);
      }

    /**
     * Generates a random string with "size" characters.
     * 
     * @param size The size of the returned String. If size is < 8, then it will be changed to 8. If it's > 254, it will be changed to 254.
     * @param alphaNumOnly Whether the returned random string should only contain alphanumeric characters or not.
     * @return A string of random characters of a minimum size of 8, and maximum size of 254.
     */
    public static String getToken(int size, boolean alphaNumOnly)
      {
        if (size < 8)
          size = 8;
        else if (size > 254)
          size = 254;
        char[] possibleCharacters = (new String(alphaNumOnly == true ? "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?")).toCharArray();
        return RandomStringUtils.random(size, 0, possibleCharacters.length - 1, false, false, possibleCharacters, new SecureRandom());
      }


    public static String bytesToHex(byte[] digest)
      {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; ++i)
          {
            sb.append(Integer.toHexString((digest[i] & 0xFF) | 0x100).substring(1, 3));
          }
        return sb.toString();
      }

    public static String aes(String plaintext, String aesKeyStr)
      {
        try
          {
            byte[] aesKeyBytes = EncryptionUtil.hash256(aesKeyStr, ""); // no salt
            SecretKey aesKeySpec = new SecretKeySpec(aesKeyBytes, "AES");
            IvParameterSpec firstIV = new IvParameterSpec(new byte[16]);

            final Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, aesKeySpec, firstIV);
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes("UTF-8"));
            return EncryptionUtil.bytesToHex(encryptedBytes);
          }
        catch (Exception e)
          {
            LOG.error("Exception in aes()", e);
            return null;
          }
      }
    

    public static String hmacSHA1(String plaintext, String key)
    throws Exception
      {
        return hmac(plaintext, key, "HmacSHA1");
      }

    public static String hmacSHA256(String plaintext, String key)
    throws Exception
      {
        return hmac(plaintext, key, "HmacSHA256");
      }

    protected static String hmac(String plaintext, String key, String algo)
    throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException
      {
        byte[] keyBytes = key.getBytes();
        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, algo);
        Mac mac = Mac.getInstance(algo);
        mac.init(signingKey);
        byte[] rawHmac = Base64.getEncoder().encode(mac.doFinal(plaintext.getBytes("UTF-8")));
        return new String(rawHmac, "UTF-8");
      }  
  }
