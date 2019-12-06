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

import tilda.enums.StatementType;
import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;

public class TableInfo implements Info
  {
    public TableInfo(String Name)
      {
        _Name = Name;
      }
    
    protected final String     _Name;
    protected       AtomicLong _SelectNano   = new AtomicLong(0);
    protected       AtomicLong _SelectCount  = new AtomicLong(0);
    protected       AtomicLong _SelectRecords= new AtomicLong(0);
    protected       AtomicLong _InsertNano   = new AtomicLong(0);
    protected       AtomicLong _InsertCount  = new AtomicLong(0);
    protected       AtomicLong _InsertRecords= new AtomicLong(0);
    protected       AtomicLong _UpdateNano   = new AtomicLong(0);
    protected       AtomicLong _UpdateCount  = new AtomicLong(0);
    protected       AtomicLong _UpdateRecords= new AtomicLong(0);
    protected       AtomicLong _DeleteNano   = new AtomicLong(0);
    protected       AtomicLong _DeleteCount  = new AtomicLong(0);
    protected       AtomicLong _DeleteRecords= new AtomicLong(0);
    
    protected void addSelect(long nano, int Count)
      {
        _SelectNano.addAndGet(nano);
        _SelectRecords.addAndGet(Count);
        _SelectCount.incrementAndGet();
      }
    protected void addInsert(long nano, int Count)
      {
        _InsertNano.addAndGet(nano);
        _InsertRecords.addAndGet(Count);
        _InsertCount.incrementAndGet();
      }
    protected void addUpdate(long nano, int Count)
      {
        _UpdateNano.addAndGet(nano);
        _UpdateRecords.addAndGet(Count);
        _UpdateCount.incrementAndGet();
      }
    protected void addDelete(long nano, int Count)
      {
        _DeleteNano.addAndGet(nano);
        _DeleteRecords.addAndGet(Count);
        _DeleteCount.incrementAndGet();
      }
    
    public void add(StatementType Type, long nano, int Count)
      {
        switch(Type)
         {
           case SELECT  : addSelect(nano, Count); break;
           case INSERT  : addInsert(nano, Count); break;
           case UPDATE  : addUpdate(nano, Count); break;
           case DELETE  : addDelete(nano, Count); break;
           default : throw new Error("BUG!!!! Statement.TYPE "+Type.toString()+" is not accounted for in the performance management code.");
         }
      }
    
    @Override
    public String getName()
      {
        return _Name;
      }
    
    @Override
    public long getCountTotal()
      {
        return _InsertCount.get()+_SelectCount.get()+_UpdateCount.get()+_DeleteCount.get();
      }

    @Override
    public long getRecordsTotal()
      {
        return _InsertRecords.get()+_SelectRecords.get()+_UpdateRecords.get()+_DeleteRecords.get();
      }

    @Override
    public long getNanoTotal()
      {
        return _InsertNano.get()+_SelectNano.get()+_UpdateNano.get()+_DeleteNano.get();
      }

    public static void printHelper(Writer out, String statementType, long count, long records, long nano, long totalCount, long totalRecords, long totalNano)
    throws Exception
     {
       if (count == 0)
        return;
       out.append("<TR style=\"font-size: 80%;\">")
          .append("<TD>&nbsp;</TD><TD align=\"right\">").append(statementType).append("&nbsp;&nbsp;&nbsp;</TD>")
          .append("<TD>").append(DurationUtil.printDurationMilliSeconds(nano)).append(" (").append(NumberFormatUtil.printPercentWith2Dec(totalNano, nano)).append("%)").append("</TD>")
          .append("<TD>").append(NumberFormatUtil.printWith000Sep(count)  ).append(" (").append(NumberFormatUtil.printPercentWith2Dec(totalCount  , count  )).append("%)").append("</TD>")
          .append("<TD>").append(DurationUtil.printPerformancePerSecond(nano, count)).append("q/s\r\n").append("</TD>")
          .append("<TD>").append(NumberFormatUtil.printWith000Sep(records)).append(" (").append(NumberFormatUtil.printPercentWith2Dec(totalRecords, records)).append("%)").append("</TD>")
          .append("</TR>\r\n");
     }
    
    @Override
    public void print(Writer out, long superCount, long superRecords, long superNano)
    throws Exception
      {
        long totalCount  = getCountTotal   ();
        long totalRecords= getRecordsTotal ();
        long totalNano   = getNanoTotal    ();
        out.append("<TR style=\"background-color: #EFEFFF;\" valign=\"top\">")
           .append("<TD COLSPAN=\"2\">").append(_Name).append("&nbsp;&nbsp;&nbsp;</TD>")
           .append("<TD>").append(DurationUtil.printDurationMilliSeconds(totalNano)).append("&nbsp;(").append(NumberFormatUtil.printPercentWith2Dec(superNano, totalNano)).append("%)").append("</TD>")
           .append("<TD>").append(NumberFormatUtil.printWith000Sep(totalCount)).append("&nbsp;(").append(NumberFormatUtil.printPercentWith2Dec(superCount  , totalCount  )).append("%)").append("</TD>")
           .append("<TD>").append(DurationUtil.printPerformancePerSecond(totalNano, totalCount)).append("q/s\r\n").append("</TD>")
           .append("<TD>").append(NumberFormatUtil.printWith000Sep(totalRecords)).append("&nbsp;(").append(NumberFormatUtil.printPercentWith2Dec(superRecords, totalRecords)).append("%)").append("</TD>")
           .append("</TR>\r\n");
        printHelper(out, "INSERT", _InsertCount.get(), _InsertCount  .get(), _InsertNano.get(), totalCount, totalRecords, totalNano);
        printHelper(out, "SELECT", _SelectCount.get(), _SelectRecords.get(), _SelectNano.get(), totalCount, totalRecords, totalNano);
        printHelper(out, "UPDATE", _UpdateCount.get(), _UpdateRecords.get(), _UpdateNano.get(), totalCount, totalRecords, totalNano);
        printHelper(out, "DELETE", _DeleteCount.get(), _DeleteRecords.get(), _DeleteNano.get(), totalCount, totalRecords, totalNano);
        out.append("<TR style=\"font-size: 60%;\"><TD colspan=\"6\">&nbsp;</TD></TR>\r\n");
      }
  }
