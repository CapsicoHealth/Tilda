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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.QueryDetails;
import tilda.enums.StatementType;
import tilda.enums.TransactionType;
import tilda.utils.AnsiUtil;
import tilda.utils.DurationUtil;

public abstract class PerfTracker
  {
    protected static final Logger LOG = LogManager.getLogger(PerfTracker.class.getName());
    
    protected static Map<String, Info> _M = new HashMap<String, Info>();

    /**
     * Adds new perf information for the named table.
     * @param TableName
     * @param Query
     * @param Type
     * @param DurationNano
     * @param Records
     */
    public static void add(String TableName, StatementType Type, long DurationNano, int Count)
      {
        TableInfo I = (TableInfo) _M.get(TableName);
        if (I == null)
          synchronized (_M)
            {
              I = (TableInfo) _M.get(TableName);
              if (I == null)
                {
                  I = new TableInfo(TableName);
                  _M.put(TableName, I);
                }
            }
        I.add(Type, DurationNano, Count);
        if (Count == 0)
         LOG.warn(QueryDetails._LOGGING_HEADER+"   "+AnsiUtil.UNDERLINE+"No record "+Type._PP+" "+AnsiUtil.UNDERLINE_OFF+" in "+DurationUtil.PrintDurationMilliSeconds(DurationNano));
        else
         LOG.debug(QueryDetails._LOGGING_HEADER+"   "+Type._PP+" "+Count+" records in "+DurationUtil.PrintDurationMilliSeconds(DurationNano));
      }

    /**
     * Adds new perf information for transactional things such as COMMIT, ROLLBACK, CLOSE, SAVEPOINT...
     * @param TT
     * @param DurationNano
     */
    public static void add(TransactionType TT, long DurationNano)
      {
        TransactionInfo I = (TransactionInfo) _M.get(TT.getName());
        if (I == null)
          synchronized (_M)
            {
              I = (TransactionInfo) _M.get(TT.getName());
              if (I == null)
                {
                  I = new TransactionInfo(TT);
                  _M.put(TT.getName(), I);
                }
            }
        I.add(DurationNano);
//        LOG.debug("   query time: "+DurationUtil.PrintDurationMilliSeconds(DurationNano));
      }

    public static void print(StringBuilder Str)
      {
        Info[] C = null;
        synchronized (_M)
          {
            C = _M.values().toArray(new Info[] {});
          }
        Arrays.sort(C, new TableInfoByTime());
        long TotalCount = 0;
        long TotalRecords = 0;
        long TotalNano = 0;
        int MaxTableNameLength = 0;
        for (Info T : C)
          {
            TotalCount += T.getCountTotal();
            TotalRecords += T.getRecordsTotal();
            TotalNano += T.getNanoTotal();
            if (T.getName().length() > MaxTableNameLength)
              MaxTableNameLength = T.getName().length();
          }
        Str.append("<BR>\r\n\r\n")
            .append("=========================================================================================================================<BR>\r\n")
            .append("==  Summary database performance numbers<BR>\r\n")
            .append("==  # of queries=").append(TotalCount).append("; # affected records=").append(TotalRecords).append("; time=").append(DurationUtil.PrintDuration(TotalNano))
            .append("; perf=").append(DurationUtil.PrintPerformancePerSecond(TotalNano, TotalCount)).append("q/s ")
            .append("; perf=").append(DurationUtil.PrintDurationMilliSeconds(TotalCount == 0 ? 0 : TotalNano / TotalCount)).append("/q; ").append("<BR>\r\n")
            .append("=========================================================================================================================<BR>\r\n")
            .append("<TABLE style=\"font-size: 70%;\" cellpadding=\"3px\" cellspacing=\"0px\" border=\"0px\">\r\n")
            .append("<TR style=\"background-color: #000; color: #FFF; font-weight: bold;\">\r\n")
            .append("<TD>Table</TD><TD>Operation</TD><TD>Time</TD><TD>Count</TD><TD>Perf</TD><TD>Records</TD>\r\n")
            .append("</TR>\r\n");
        for (Info T : C)
          T.print(Str, TotalCount, TotalRecords, TotalNano);
        Str.append("</TABLE>\r\n");
      }
  }
