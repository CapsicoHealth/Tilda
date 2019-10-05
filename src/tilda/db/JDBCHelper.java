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
import tilda.enums.StatementType;
import tilda.enums.TransactionType;
import tilda.performance.PerfTracker;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class JDBCHelper
  {
    static final Logger LOG = LogManager.getLogger(JDBCHelper.class.getName());

    /**
     * Closes the statement
     * 
     * @param s the Statement. Can be null (it will be ignored)
     * @return an SQException (instead of throwing) if one happens.
     */
    public static SQLException closeStatement(Statement s)
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


    public static int process(ResultSet RS, RecordProcessor RP, int Start, boolean Offsetted, int Size)
    throws Exception
      {
        return process(RS, RP, Start, Offsetted, Size, false);
      }

    public static int process(ResultSet RS, RecordProcessor RP, int Start, boolean Offsetted, int Size, boolean CountAll)
    throws Exception
      {
        RP.start();
        int count = 0;
        if (Offsetted == false && Start > 0 && RS.relative(Start) == false)
          return -1;
        while (Size <= -1 || count < Size)
          {
            if (RS.next() == false)
              break;
            if (RP.process(count, RS) == false)
              return -1;
            ++count;
          }
        boolean More = RS.next();
        int MaxCount = CountAll == true && RS.last() == true ? RS.getRow() : SystemValues.EVIL_VALUE;
        RP.end(More, MaxCount);
        return count;
      }


    /**
     * Executes a query with a record processor, starting at Start (0 is beginning), and for Size records.
     */
    public static int executeSelect(Connection C, String SchemaName, String TableName, String Query, RecordProcessor RP, int Start, boolean Offsetted, int Size, boolean CountAll)
    throws Exception
      {
        TableName = SchemaName + "." + TableName;
        QueryDetails.logQuery(TableName, Query, null);
        Statement S = null;
        try
          {
            long T0 = System.nanoTime();
            QueryDetails.setLastQuery(TableName, Query);
            S = C.createStatement();
            ResultSet RS = S.executeQuery(Query);
            int count = JDBCHelper.process(RS, RP, Start, Offsetted, Size, CountAll);
            PerfTracker.add(TableName, StatementType.SELECT, System.nanoTime() - T0, count);
            return count;
          }
        finally
          {
            JDBCHelper.closeStatement(S);
          }
      }

    public static int executeUpdate(Connection C, String SchemaName, String TableName, String Query)
    throws Exception
      {
        TableName = SchemaName + "." + TableName;
        QueryDetails.logQuery(TableName, Query, null);
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
            JDBCHelper.closeStatement(S);
          }
      }

    public static int executeDelete(Connection C, String SchemaName, String TableName, String Query)
    throws Exception
      {
        TableName = SchemaName + "." + TableName;
        QueryDetails.logQuery(TableName, Query, null);
        Statement S = null;
        try
          {
            long T0 = System.nanoTime();
            QueryDetails.setLastQuery(TableName, Query);
            S = C.createStatement();
            int count = S.executeUpdate(Query);
            PerfTracker.add(TableName, StatementType.DELETE, System.nanoTime() - T0, count);
            return count;
          }
        finally
          {
            JDBCHelper.closeStatement(S);
          }
      }

    public static boolean executeDDL(Connection C, String SchemaName, String TableName, String Query)
    throws Exception
      {
        TableName = SchemaName + "." + TableName;
        QueryDetails.logQuery(TableName, Query, null);
        Statement S = null;
        try
          {
            long T0 = System.nanoTime();
            QueryDetails.setLastQuery(TableName, Query);
            S = C.createStatement();
            S.execute(Query);
            while (S.getMoreResults() == true || S.getUpdateCount() != -1)
              S.getResultSet();
            PerfTracker.add(TableName, StatementType.UPDATE, System.nanoTime() - T0, 1);
            return true;
          }
        finally
          {
            JDBCHelper.closeStatement(S);
          }
      }


    public static int executeInsert(Connection C, String SchemaName, String TableName, String Query)
    throws Exception
      {
        TableName = SchemaName + "." + TableName;
        QueryDetails.logQuery(TableName, Query, null);
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
            JDBCHelper.closeStatement(S);
          }
      }


    public static String printResultSet(ResultSet RS)
    throws SQLException
      {
        int count = RS.getMetaData().getColumnCount();
        StringBuilder Str = new StringBuilder();
        for (int i = 1; i <= count; ++i)
          {
            String Name = RS.getMetaData().getColumnName(i);
            String Val = RS.getString(i);
            Str.append(Name).append("=").append(TextUtil.toMaxLength(Val, 50)).append("; ");
          }
        return Str.toString();
      }
    
    public static int batchWriteDone(int[] results, int size)
    throws Exception
      {
        if(results.length != size)
          return 0;
        
        for(int i = 0 ; i < results.length ; i++)
            if(results[i] != -2 && results[i] <= 0)
              return i;
    
        return -1;
      }
  }
