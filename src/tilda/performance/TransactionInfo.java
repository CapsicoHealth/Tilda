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

import java.io.Writer;
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
    public void print(Writer out, long superCount, long superRecords, long superNano)
    throws Exception
      {
        long totalCount = getCountTotal();
        long totalNano = getNanoTotal();
        out.append("<TR style=\"background-color: #EFEFFF;\" valign=\"top\">")
            .append("<TD COLSPAN=\"2\">").append(_Name).append("&nbsp;&nbsp;&nbsp;</TD>")
            .append("<TD>").append(DurationUtil.printDurationMilliSeconds(totalNano)).append("&nbsp;(").append(NumberFormatUtil.printPercentWith2Dec(superNano, totalNano)).append("%)").append("</TD>")
            .append("<TD>").append(NumberFormatUtil.printWith000Sep(totalCount)).append("&nbsp;(").append(NumberFormatUtil.printPercentWith2Dec(superCount, totalCount)).append("%)").append("</TD>")
            .append("<TD>").append(DurationUtil.printPerformancePerSecond(totalNano, totalCount)).append("q/s\r\n").append("</TD>")
            .append("<TD>&nbsp;</TD>")
            .append("</TR>\r\n");
        out.append("<TR style=\"font-size: 50%;\"><TD colspan=\"6\">&nbsp;</TD></TR>\r\n");
      }

  }
