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

import java.util.List;
import java.util.Random;


public class RandomUtil
  {
    public static boolean flip()
      {
        return Math.random() >= 0.5;
      }

    public static <T> T pick(List<T> L)
      {
        if (L == null || L.isEmpty() == true)
          return null;
        return L.get((int) (Math.floor(Math.random() * L.size())));
      }

    public static <T> T pick(T[] A)
      {
        if (A == null || A.length == 0)
          return null;
        return A[(int) (Math.random() * A.length)];
      }

    public static int pick(int Min, int Max)
      {
        return (int) Math.round((Math.random() * (Max - Min)) + Min);
      }

    /**
     * picks a random number and returns true if that is < Odds, or false otherwise. So,
     * calling with 0.75 means a 75% chance true Vs. false
     * 
     * @param Odds a number between 0 and 1
     * @return
     */
    public static boolean pick(double Odds)
      {
        return Math.random() < Odds;
      }


    public static double pick(double Min, double Max)
      {
        return Math.random() * (Max - Min) + Min;
      }

    protected static Random _R = new Random();

    public static short pickNonZeroShort()
      {
        short s = (short) _R.nextInt(1 << 16);
        return s == 0 ? SystemValues.EVIL_VALUE : s;
      }
  }
