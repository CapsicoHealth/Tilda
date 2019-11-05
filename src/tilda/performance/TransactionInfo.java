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

package tilda.performance;

import java.util.concurrent.atomic.AtomicLong;

import tilda.enums.TransactionType;
import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;

public class TransactionInfo implements Info
  {
    public TransactionInfo(TransactionType TT)
      {
        _Name = getName(TT);
      }

    public static String getName(TransactionType TT)
      {
        return "--" + TT + "--";
      }

    protected String     _Name;
    protected AtomicLong _Nano  = new AtomicLong(0);
    protected AtomicLong _Count = new AtomicLong(0);

    protected void add(long nano)
      {
        _Nano.addAndGet(nano);
        _Count.incrementAndGet();
      }

    @Override
    public String getName()
      {
        return _Name;
      }

    @Override
    public long getRecordsTotal()
      {
        return 0;
      }

    @Override
    public long getCountTotal()
      {
        return _Count.get();
      }

    @Override
    public long getNanoTotal()
      {
        return _Nano.get();
      }

    @Override
    public void print(StringBuilder Str, long SuperCount, long SuperRecords, long SuperNano)
      {
        long TotalCount = getCountTotal();
        long TotalNano = getNanoTotal();
        Str.append("<TR style=\"background-color: #EFEFFF;\" valign=\"top\">")
            .append("<TD COLSPAN=\"2\">").append(_Name).append("&nbsp;&nbsp;&nbsp;</TD>")
            .append("<TD>").append(DurationUtil.printDurationMilliSeconds(TotalNano)).append("&nbsp;(").append(NumberFormatUtil.printPercentWith2Dec(SuperNano, TotalNano)).append("%)").append("</TD>")
            .append("<TD>").append(TotalCount).append("&nbsp;(").append(NumberFormatUtil.printPercentWith2Dec(SuperCount, TotalCount)).append("%)").append("</TD>")
            .append("<TD>").append(DurationUtil.printPerformancePerSecond(TotalNano, TotalCount)).append("q/s\r\n").append("</TD>")
            .append("<TD>&nbsp;</TD>")
            .append("</TR>\r\n");
        Str.append("<TR style=\"font-size: 50%;\"><TD colspan=\"6\">&nbsp;</TD></TR>\r\n");
      }

  }
