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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

public class NumberFormatUtil
  {
    protected static final NumberFormat F1a = new DecimalFormat("#0.0");

    public static final String printWith1Dec(double Number)
      {
        return F1a.format(Number);
      }

    protected static final NumberFormat F1b = new DecimalFormat("#0.00");

    public static final String printWith2Dec(double Number)
      {
        return F1b.format(Number);
      }

    protected static final NumberFormat F1c = new DecimalFormat("#0.000");

    public static final String printWith3Decimals(double Number)
      {
        return F1c.format(Number);
      }

    public static final String printPercentWith1Dec(long Total, long Sub)
      {
        return F1a.format(100.0d * ((Sub * 1.0d) / (Total * 1.0d)));
      }

    public static final String printPercentWith2Dec(long Total, long Sub)
      {
        return F1b.format(100.0d * ((Sub * 1.0d) / (Total * 1.0d)));
      }

    public static final String printPercentWith3Dec(long Total, long Sub)
      {
        return F1c.format(100.0d * ((Sub * 1.0d) / (Total * 1.0d)));
      }

    protected static final NumberFormat F2a = new DecimalFormat("###,###");

    public static final String printWith000Sep(long Number)
      {
        return F2a.format(Number);
      }

    protected static final NumberFormat F2b = new DecimalFormat("###,###.0");

    public static final String printWith1DecAnd000Sep(double Number)
      {
        return F2b.format(Number);
      }

    protected static final NumberFormat F2c = new DecimalFormat("###,###.00");

    public static final String printWith2DecAnd000Sep(double Number)
      {
        return F2c.format(Number);
      }

    public static final String leadingZero1(long X)
      {
        return X >= 10 || X <= -10 ? Long.toString(X)
        : X >= 0 ? "0" + X
        : "-0" + (-X);
      }

    public static final String leadingZero2(long X)
      {
        return X >= 100 || X <= -100 ? Long.toString(X)
        : X > -100 && X <= -10 ? "-0" + (-X)
        : X > -10 && X < 0 ? "-00" + (-X)
        : X >= 0 && X < 10 ? "00" + X
        : "0" + X;
      }

    public static final String leadingZero3(long X)
      {
        return X >= 1000 || X <= -1000 ? Long.toString(X)
        : X > -1000 && X <= -100 ? "-0" + (-X)
        : X > -100 && X <= -10 ? "-00" + (-X)
        : X > -10 && X < 0 ? "-000" + (-X)
        : X >= 0 && X < 10 ? "000" + X
        : X >= 10 && X < 100 ? "00" + X
        : "0" + X;
      }

    public static final String leadingZeros(long x, int count)
      {
        String str = Long.toString(x >= 0 ? x : -x);
        int fill = count - str.length();
        if (fill >= 0)
          {
            char[] c = new char[fill];
            Arrays.fill(c, '0');
            return (x <= 0 ? "-" : "") + new String(c) + str;
          }
        return (x <= 0 ? "-" : "") + str;
      }

    public static final String leadingSpace(long X, int spaces)
      {
        int length = String.valueOf(X).length();
        return (length < spaces ? PaddingUtil.getPad(spaces - length) : "") + X;
      }

    public static final String printDataSize(long bytes)
      {
        return bytes < 1024 ? printWith000Sep(bytes) + "B"
        : bytes < 1024 * 1024 ? printWith2DecAnd000Sep(bytes / 1024.0) + "KB"
        : bytes < 1024 * 1024 * 1024 ? printWith2DecAnd000Sep(bytes / (1024.0 * 1024.0)) + "MB"
        : printWith2DecAnd000Sep(bytes / (1024.0 * 1024.0 * 1024.0)) + "GB";
      }


  }
