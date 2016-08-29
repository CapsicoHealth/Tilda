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

public class NumberFormatUtil
  {
    protected static final NumberFormat F1a = new DecimalFormat("#0.0");

    public static final String PrintWith1Dec(double Number)
      {
        return F1a.format(Number);
      }

    protected static final NumberFormat F1b = new DecimalFormat("#0.00");

    public static final String PrintWith2Dec(double Number)
      {
        return F1b.format(Number);
      }

    protected static final NumberFormat F1c = new DecimalFormat("#0.000");

    public static final String PrintWith3Decimals(double Number)
      {
        return F1c.format(Number);
      }

    public static final String PrintPercentWith1Dec(long Total, long Sub)
      {
        return F1a.format(100.0d * ((Sub * 1.0d) / (Total * 1.0d)));
      }

    public static final String PrintPercentWith2Dec(long Total, long Sub)
      {
        return F1b.format(100.0d * ((Sub * 1.0d) / (Total * 1.0d)));
      }

    public static final String PrintPercentWith3Dec(long Total, long Sub)
      {
        return F1c.format(100.0d * ((Sub * 1.0d) / (Total * 1.0d)));
      }

    protected static final NumberFormat F2a = new DecimalFormat("###,###");

    public static final String PrintWith000Sep(long Number)
      {
        return F2a.format(Number);
      }

    protected static final NumberFormat F2b = new DecimalFormat("###,###.0");

    public static final String PrintWith1DecAnd000Sep(double Number)
      {
        return F2b.format(Number);
      }

    protected static final NumberFormat F2c = new DecimalFormat("###,###.00");

    public static final String PrintWith2DecAnd000Sep(double Number)
      {
        return F2c.format(Number);
      }
    
    public static final String LeadingZero1(long X)
      {
        return X >= 10 || X <= -10 ? Long.toString(X) 
             : X >= 0 ? "0"+X 
             : "-0"+(-X);
      }

    public static final String LeadingZero2(long X)
      {
        return X >= 100 || X <= -100 ? Long.toString(X) 
             : X > -100 && X <= -10 ? "-0"+(-X)
             : X > -10 && X < 0 ? "-00"+(-X) 
             : X >= 0 && X < 10 ? "00"+X
             : "0"+X;
      }

    public static final String LeadingZero3(long X)
      {
        return X >=  1000 || X <= -1000 ? Long.toString(X) 
             : X >  -1000 && X <=  -100 ?   "-0"+(-X) 
             : X >   -100 && X <=   -10 ?  "-00"+(-X)
             : X >    -10 && X <      0 ? "-000"+(-X) 
             : X >=     0 && X <     10 ?  "000"+X
             : X >=    10 && X <    100 ?   "00"+X
             : "0"+X;
      }
    
  }
