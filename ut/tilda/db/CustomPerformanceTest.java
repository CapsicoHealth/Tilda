/* ===========================================================================
 * Copyright (C) 2018 CapsicoHealth Inc.
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

import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.sql.*;
import java.util.*;
import org.postgresql.*;
import org.postgresql.copy.*;
import tilda.utils.FileUtil;

public class CustomPerformanceTest
  {
    public static class Data
      {
        public Data(String type, int commitSize, int batchSize, double rowsPerSecond)
          {
            _type = type;
            _commitSize = commitSize;
            _batchSize = batchSize;
            _rowsPerSecond = rowsPerSecond;
          }

        public final String _type;
        public final int    _commitSize;
        public final int    _batchSize;
        public final double _rowsPerSecond;
      }

    public static void main(String args[])
    throws Exception
      {
        Connection conn = ConnectionPool.get("MAIN");
        if (JDBCHelper.executeDDL(conn._C, "public", "toto", "CREATE TABLE IF NOT EXISTS public.TOTO (c1 int, c2 int, c3 int, c4 timestamp, c5 varchar, c6 text, c7 float, c8 char(10), c9 date )") == false)
          throw new Exception("Cannot execute...");

        List<Data> L = new ArrayList<Data>();
        // for (int i = 0; i < 5; ++i)
        // L.add(test(conn, 50_000, 0));
        // for (int i = 0; i < 5; ++i)
        // L.add(test(conn, 25_000, 0));
        // for (int i = 0; i < 5; ++i)
        // L.add(test(conn, 10_000, 0));
        // for (int i = 0; i < 5; ++i)
        // L.add(test(conn, 5_000, 0));

        for (int i = 0; i < 5; ++i)
          L.add(test(conn, 10_000, 100));
        for (int i = 0; i < 5; ++i)
          L.add(test(conn, 10_000, 500));
        for (int i = 0; i < 5; ++i)
          L.add(test(conn, 10_000, 1000));
        for (int i = 0; i < 5; ++i)
          L.add(test(conn, 10_000, 2500));
        for (int i = 0; i < 5; ++i)
          L.add(test(conn, 10_000, 5000));
        for (int i = 0; i < 5; ++i)
          L.add(test(conn, 10_000, 7500));
        for (int i = 0; i < 5; ++i)
          L.add(test(conn, 10_000, 10000));

        // for (int i = 0; i < 5; ++i)
        // L.add(test2(conn, 10_000, 100));
        // for (int i = 0; i < 5; ++i)
        // L.add(test2(conn, 10_000, 500));
        // for (int i = 0; i < 5; ++i)
        // L.add(test2(conn, 10_000, 1000));
        // for (int i = 0; i < 5; ++i)
        // L.add(test2(conn, 10_000, 2500));

        boolean rewrite = conn.getURL().indexOf("reWriteBatchedInserts=true") != -1;
        PrintWriter Out = FileUtil.getBufferedPrintWriter("C:\\Users\\Laurent Hasson\\Desktop\\jdbc_postgres_insert_perf.csv", true);
        Out.println("commitSize,batchSize,rowsPerSecond,type,rewrite");
        for (Data d : L)
          Out.println(d._commitSize + "," + d._batchSize + "," + d._rowsPerSecond + "," + d._type + "," + (rewrite == true ? 1 : 0));
        Out.close();
        conn.close();
      }

    static final int _TOTAL = 500_000;

    public static Data test(Connection conn, int commitSize, int batchSize)
    throws Exception
      {
        if (JDBCHelper.executeDDL(conn._C, "public", "toto", "TRUNCATE TABLE public.TOTO") == false)
          throw new Exception("Cannot execute...");

        // System.out.println("commitSize: " + commitSize + "; batchSize: " + batchSize + ";");
        String query = "insert into public.toto(c1,c2,c3,c4,c5,c6,c7,c8,c9) values(?,?,?,?,?,?,?,?,?)";
        long lStartTime = System.currentTimeMillis();
        int size = 0;
        int commitCount = 0;
        int batchCount = 0;

        try (PreparedStatement ps = conn.prepareStatement(query))
          {
            long now = System.currentTimeMillis();
            for (int row = 0; row < _TOTAL; row++)
              {
                ps.setInt(1, row + _TOTAL);
                ps.setInt(2, 1);
                ps.setInt(3, 12);
                ps.setTimestamp(4, new Timestamp(now));
                ps.setString(5, "boe" + row + "kingdetail" + row);
                ps.setString(6, "boe" + row + "kingdetail" + row + "boe" + row + "kingdetail" + row + "boe" + row + "kingdetail" + row);
                ps.setFloat(7, 12);
                ps.setString(8, "boe" + row);
                ps.setDate(9, new Date(120, 7, 11));
                size++;
                commitCount++;
                batchCount++;

                if (batchSize <= 0)
                  {
                    ps.executeUpdate();
                    if (commitCount > commitSize)
                      {
                        commitCount = 0;
                        conn.commit();
                      }
                  }
                else
                  {
                    batchCount++;
                    ps.addBatch();
                    if (batchCount >= batchSize)
                      {
                        ps.executeBatch();
                        batchCount = 0;

                        if (commitCount > commitSize)
                          {
                            commitCount = 0;
                            conn.commit();
                          }
                      }
                  }
              }

            if (batchSize > 0 && batchCount > 0)
              {
                ps.executeBatch();
              }
          }
        conn.commit();

        long lEndTime = System.currentTimeMillis();
        long difference = lEndTime - lStartTime;
        double rps = (double) size / ((double) difference / 1000);
        System.out.println("Inserted " + size + " rows in " + difference + " milliseconds, " + rps + " rows per second");
        return new Data("STANDARD", commitSize, batchSize, rps);
      }

    public static Data test2(Connection conn, int commitSize, int batchSize)
    throws Exception
      {
        if (JDBCHelper.executeDDL(conn._C, "public", "toto", "TRUNCATE TABLE public.TOTO") == false)
          throw new Exception("Cannot execute...");

        System.out.println("commitSize: " + commitSize + "; batchSize: " + batchSize + ";");
        long lStartTime = System.currentTimeMillis();
        int count = 0;

        PreparedStatement ps = null;

        long now = System.currentTimeMillis();
        while (count < _TOTAL)
          {
            StringBuilder query = new StringBuilder("insert into public.toto(c1,c2,c3,c4,c5,c6,c7,c8,c9) values(?,?,?,?,?,?,?,?,?)");
            int target = count + batchSize > _TOTAL ? _TOTAL : count + batchSize;
            for (int i = count + 1; i < target; ++i)
              query.append(",(?,?,?,?,?,?,?,?,?)");
            ps = conn.prepareStatement(query.toString());
            boolean doCommit = false;
            System.out.println("count: " + count + "; target: " + target + ";");
            int i = -1;
            while (count < target)
              {
                ++i;
                ps.setInt(i * 9 + 1, count + _TOTAL);
                ps.setInt(i * 9 + 2, 1);
                ps.setInt(i * 9 + 3, 12);
                ps.setTimestamp(i * 9 + 4, new Timestamp(now));
                ps.setString(i * 9 + 5, "boe" + count + "kingdetail" + count);
                ps.setString(i * 9 + 6, "boe" + count + "kingdetail" + count + "boe" + count + "kingdetail" + count + "boe" + count + "kingdetail" + count);
                ps.setFloat(i * 9 + 7, 12);
                ps.setString(i * 9 + 8, "boe" + count);
                ps.setDate(i * 9 + 9, new Date(120, 7, 11));
                if (++count % commitSize == 0)
                  doCommit = true;
              }
            ps.executeUpdate();
            if (doCommit == true)
              conn.commit();
            ps.close();
          }
        conn.commit();

        long lEndTime = System.currentTimeMillis();
        long difference = lEndTime - lStartTime;
        double rps = (double) count / ((double) difference / 1000);
        System.out.println("Inserted " + count + " rows in " + difference + " milliseconds, " + rps + " rows per second");
        return new Data("MULTI_VALUE", commitSize, batchSize, rps);
      }





    
    
    

    public static void main2(String args[])
      {
        try
          {
            Class.forName("org.postgresql.Driver");
            String dbURL = "jdbc:postgresql://localhost:5432/datavault_12_tst";
            Properties parameters = new Properties();
            parameters.put("user", "jal");
            parameters.put("password", "jal");

            java.sql.Connection conn = DriverManager.getConnection(dbURL, parameters);
            conn.setAutoCommit(false); // Important

            String query = "insert into datavault.h_test(id_h,source_system_id,organisation_id,load_dts,boekingdetailid) values(?,?,?,?,?)";
            long lStartTime = System.currentTimeMillis();
            int size = 24_000_000;
            int commitSize = 50_000_000;
            int commitCount = 0;
            int batchSize = 10000;
            int batchCount = 0;


            CopyManager cm = ((PGConnection) conn).getCopyAPI();

            cm.copyIn("copy datavault.h_test from stdin with (format text)", new InsertReader(size));
            conn.commit();

            long lEndTime = System.currentTimeMillis();
            long difference = lEndTime - lStartTime;
            double rps = (double) size / ((double) difference / 1000);
            System.out.println("Inserted " + size + " rows in " + difference + " milliseconds, " + rps + " rows per second");
          }
        catch (Exception e)
          {
            e.printStackTrace();
          }
      }

    public static class InsertReader extends Reader
      {
        private final int           m_size;

        private final StringBuilder m_buffer = new StringBuilder();

        private int                 m_bufferIndex;

        private int                 m_count;

        public InsertReader(int count)
          {
            m_size = count;
          }

        @Override
        public int read(char[] cbuf, int off, int len)
        throws IOException
          {
            if (m_count >= m_size)
              return -1;
            int buflen = m_buffer.length();
            int remainder = buflen - m_bufferIndex;
            if (remainder < len)
              {
                generateRecords();
                buflen = m_buffer.length();
                remainder = buflen - m_bufferIndex;
              }

            if (remainder > len)
              remainder = len;
            m_buffer.getChars(m_bufferIndex, m_bufferIndex + remainder, cbuf, off);
            m_bufferIndex += remainder;
            return remainder;
          }

        private void generateRecords()
          {
            m_buffer.replace(0, m_bufferIndex, "");
            m_bufferIndex = 0;
            int left = m_size - m_count;
            if (left > 1000)
              left = 1000;

            while (left-- > 0)
              {
                addRecord(m_count++);
              }
          }

        private void addRecord(int nr)
          {
            m_buffer
            .append(Integer.toString(nr))
            .append("\t")
            .append("1")
            .append("\t")
            .append("12")
            .append("\t")
            .append("2017-06-09 00:00:00")
            .append("\t")
            .append("boe" + nr + "king" + nr)
            .append("\n");
          }

        @Override
        public void close()
        throws IOException
          {
          }
      }

  }
