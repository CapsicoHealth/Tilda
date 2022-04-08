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

public class PswdHash
  {
    public static void main(String[] args)
      {
        System.out.println("PswdHash: This programs takes one parameter representing a clear password and returns a hash.");
        try
          {
            if (args.length != 1)
              {
                System.err.println("Program needs one argument: the password to hash.");
                System.exit(-1);
              }
            System.out.println(tilda.utils.EncryptionUtil.hash(args[0]));
          }
        catch (Throwable T)
          {
            T.printStackTrace();
          }
      }
  }
