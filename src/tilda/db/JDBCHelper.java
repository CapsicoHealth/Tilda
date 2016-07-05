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

package tilda.db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.processors.RecordProcessor;
import tilda.performance.PerfTracker;
import tilda.enums.StatementType;
import tilda.enums.TransactionType;
import tilda.utils.AnsiUtil;
import tilda.utils.SystemValues;

public class JDBCHelper
  {
    static final Logger LOG = LogManager.getLogger(JDBCHelper.class.getName());

    /**
     * Closes the statement
     * 
     * @param s the Statement. Can be null (it will be ignored)
     * @return an SQException (instead of throwing) if one happens.
     */
    public static SQLException CloseStatement(Statement s)
      {
        if (s != null)
          try
            {
              long T0 = System.nanoTime();
              s.close();
              PerfTracker.add(TransactionType.STATEMENT_CLOSE, System.nanoTime() - T0);
            }
          catch (SQLException E)
            {
              LOG.error("Error: Cannot close a statement", E);
              return E;
            }
        return null;
      }


    public static int Process(ResultSet RS, RecordProcessor RP, int Start, boolean Offsetted, int Size, boolean Limited)
    throws Exception
      {
        return Process(RS, RP, Start, Offsetted, Size, Limited, false);
      }

    public static int Process(ResultSet RS, RecordProcessor RP, int Start, boolean Offsetted, int Size, boolean Limited, boolean CountAll)
    throws Exception
      {
        RP.Start();
        int count = 0;
        if (Offsetted == false && Start > 0 && RS.relative(Start) == false)
          return -1;
        while (Size <= -1 || count < Size)
          {
            if (RS.next() == false)
              break;
            if (RP.Process(count, RS) == false)
              return -1;
            ++count;
          }
        boolean More = RS.next();
        int MaxCount = CountAll == true && RS.last() == true ? RS.getRow() : SystemValues.EVIL_VALUE;
        RP.End(More, MaxCount);
        return count;
      }

    public static int ExecuteSelect(Connection C, String SchemaName, String TableName, String Query, RecordProcessor RP)
    throws Exception
      {
        return ExecuteSelect(C, SchemaName, TableName, Query, RP, 0, false, -1, false, false);
      }

    /**
     * Executes a query with a record processor, starting at Start (0 is beginning), and for Size records.
     */
    public static int ExecuteSelect(Connection C, String SchemaName, String TableName, String Query, RecordProcessor RP, int Start, boolean Offsetted, int Size, boolean Limited)
    throws Exception
      {
        return ExecuteSelect(C, SchemaName, TableName, Query, RP, Start, Offsetted, Size, Limited, false);
      }

    /**
     * Executes a query with a record processor, starting at Start (0 is beginning), and for Size records.
     */
    public static int ExecuteSelect(Connection C, String SchemaName, String TableName, String Query, RecordProcessor RP, int Start, boolean Offsetted, int Size, boolean Limited, boolean CountAll)
    throws Exception
      {
        TableName = SchemaName+"."+TableName;
        LOG.debug("TILDA(" + AnsiUtil.NEGATIVE + TableName + AnsiUtil.NEGATIVE_OFF + "): " + Query);
        Statement S = null;
        try
          {
            long T0 = System.nanoTime();
            QueryDetails.setLastQuery(TableName, Query);
            S = C.createStatement();
            ResultSet RS = S.executeQuery(Query);
            int count = JDBCHelper.Process(RS, RP, Start, Offsetted, Size, Limited, CountAll);
            PerfTracker.add(TableName, StatementType.SELECT, System.nanoTime() - T0, count);
            return count;
          }
        finally
          {
            JDBCHelper.CloseStatement(S);
          }
      }

    public static int ExecuteUpdate(Connection C, String SchemaName, String TableName, String Query)
    throws Exception
      {
        TableName = SchemaName+"."+TableName;
        LOG.debug("TILDA(" + AnsiUtil.NEGATIVE + TableName + AnsiUtil.NEGATIVE_OFF + "): " + Query);
        Statement S = null;
        try
          {
            long T0 = System.nanoTime();
            QueryDetails.setLastQuery(TableName, Query);
            S = C.createStatement();
            int count = S.executeUpdate(Query);
            PerfTracker.add(TableName, StatementType.UPDATE, System.nanoTime() - T0, count);
            return count;
          }
        finally
          {
            JDBCHelper.CloseStatement(S);
          }
      }
    
    public static void ExecuteDDL(Connection C, String SchemaName, String TableName, String Query)
    throws Exception
      {
        TableName = SchemaName+"."+TableName;
        LOG.debug("TILDA(" + AnsiUtil.NEGATIVE + TableName + AnsiUtil.NEGATIVE_OFF + "): " + Query);
        Statement S = null;
        try
          {
            long T0 = System.nanoTime();
            QueryDetails.setLastQuery(TableName, Query);
            S = C.createStatement();
            if (S.execute(Query) == false)
             while (S.getMoreResults() == true || S.getUpdateCount() != -1)
               S.getResultSet();
            PerfTracker.add(TableName, StatementType.UPDATE, System.nanoTime() - T0, 1);
          }
        finally
          {
            JDBCHelper.CloseStatement(S);
          }
      }
    

    public static int ExecuteInsert(Connection C, String SchemaName, String TableName, String Query)
    throws Exception
      {
        TableName = SchemaName+"."+TableName;
        LOG.debug("TILDA(" + AnsiUtil.NEGATIVE + TableName + AnsiUtil.NEGATIVE_OFF + "): " + Query);
        Statement S = null;
        try
          {
            long T0 = System.nanoTime();
            QueryDetails.setLastQuery(TableName, Query);
            S = C.createStatement();
            int count = S.executeUpdate(Query);
            PerfTracker.add(TableName, StatementType.INSERT, System.nanoTime() - T0, count);
            return count;
          }
        finally
          {
            JDBCHelper.CloseStatement(S);
          }
      }

  }
