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

package tilda;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.Key_Data;
import tilda.data.Key_Factory;
import tilda.data.ObjectPerf_Factory;
import tilda.data.Testing_Data;
import tilda.data.Testing_Factory;
import tilda.data.TransPerf_Data;
import tilda.data.TransPerf_Factory;
import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.JDBCHelper;
import tilda.db.KeysManager;
import tilda.db.ListResults;
import tilda.performance.PerfTracker;
import tilda.utils.DateTimeUtil;
import tilda.utils.DurationUtil;
import tilda.utils.DateTimeZone;
import tilda.utils.NumberFormatUtil;
import tilda.utils.TextUtil;

public class DBTest
  {
    protected static final Logger LOG = LogManager.getLogger(DBTest.class.getName());

    public static void main(String[] args)
      {

        Connection C = null;
        try
          {
            C = ConnectionPool.get("MAIN");
            // Test1(C);
            // Test2(C);
            // Test3(C);
            // Test4(C);
            // Test5(C);
            //Test_Batch(C);
            Test_Batch2(C);
            //Test_Batch3(C);
          }
        catch (Exception E)
          {
            LOG.error("An exception occurred", E);
          }
        finally
          {
            if (C != null)
              try
                {
                  C.rollback();
                  C.close();
                }
              catch (SQLException E)
                {
                }
          }
      }
    
    private static void Test_Batch4(Connection C)
    throws Exception
      {
        
        List<Long> LongList = new ArrayList<Long>();
        LongList.add((long) 1); // Yeah, could have written 1l, but just spent 5mn of my life looking at this and thinking it was "11".
        LongList.add((long) 10);
        LongList.add((long) 100);
        List<Testing_Data> L = new ArrayList<Testing_Data>();
        for (int i = 0; i < 1000; ++i)
          L.add(Testing_Factory.Create(LongList, "aaa-"+Integer.toString(i)));
        
        for(Testing_Data d : L)
          {
            StringBuilder SB = new StringBuilder();
            SB.append("INSERT INTO tilda.testing (\"refnum2\",\"name\",\"created\",\"lastUpdated\")");
            SB.append("VALUES (").append(d.getRefnum2()).append(",").append(d.getName()).append(",").append(DateTimeUtil.NowLocal()).append(",").append(DateTimeUtil.NowLocal());
            //JDBCHelper.ExecuteInsert(C._C, "tilda", "testing", SB.toString());
          }
        
      }
    
    
    

    private static void Test_Batch(Connection C)
    throws Exception
      {
        List<Long> LongList = new ArrayList<Long>();
        LongList.add((long) 1); // Yeah, could have written 1l, but just spent 5mn of my life looking at this and thinking it was "11".
        LongList.add((long) 10);
        LongList.add((long) 100);
        List<Testing_Data> L = new ArrayList<Testing_Data>();
        for (int i = 0; i < 1000000; ++i)
          L.add(Testing_Factory.Create(LongList, "aaa-"+Integer.toString(i)));

        int errIndex = (Testing_Factory.WriteBatch(C, L, 1000, 10000));
        if (errIndex != -1)
          {
           LOG.debug("Failed obj: "+L.get(errIndex).toString());
          }
        
      }
    
    private static void Test_Batch2(Connection C)
    throws Exception
      {
        List<Long> LongList = new ArrayList<Long>();
        LongList.add((long) 1); // Yeah, could have written 1l, but just spent 5mn of my life looking at this and thinking it was "11".
        LongList.add((long) 10);
        LongList.add((long) 100);
        List<Testing_Data> L = new ArrayList<Testing_Data>();
        for (int i = 0; i < 1000000; ++i)
          L.add(Testing_Factory.Create(LongList, "aaa-"+Integer.toString(i)));
        
        int batchSize = 1000;
        int commitSize = 10000;
        int writeCount = 0;
        int totalCount = 0;
        
        long T0 = System.nanoTime();
        
        for (int i = 0; i < L.size(); i+=batchSize)
          {
            
            int errIndex = (Testing_Factory.WriteBatch(C, L.subList(i, i+batchSize), totalCount));
            
            writeCount+=batchSize;
            LOG.debug("WriteCount: " + writeCount);
            if (errIndex != -1)
              {
               LOG.debug("Failed obj: "+L.get(errIndex).toString());
              }
            if(writeCount >= commitSize)
              {
                C.commit();
                LOG.debug("Commited: " + writeCount + " records");
                totalCount+=writeCount;
                writeCount = 0;
              }
          }
          if(writeCount != 0)
            C.commit();      
          T0 = System.nanoTime() - T0;
          LOG.info("Took " + DurationUtil.PrintDuration(T0) + " or " + DurationUtil.PrintPerformancePerSecond(T0, totalCount) + " records/s");
      }


    private static void Test_Batch3(Connection C)
    throws Exception
      {
        List<Long> LongList = new ArrayList<Long>();
        LongList.add((long) 1); // Yeah, could have written 1l, but just spent 5mn of my life looking at this and thinking it was "11".
        LongList.add((long) 10);
        LongList.add((long) 100);
        List<Testing_Data> L = new ArrayList<Testing_Data>();
        
        Testing_Data D = Testing_Factory.Create(LongList, "aaa-0");
        D.setA9(DateTimeUtil.NowLocal());
        L.add(D);
        D = Testing_Factory.Create(LongList, "aaa-1");
        D.setA2('X');
        L.add(D);        
        
        int errIndex = Testing_Factory.WriteBatch(C, L, 400, 1200);
        if (errIndex != -1)
          {
           LOG.debug("Failed obj: "+L.get(errIndex).toString());
          }
      }

    
    private static void Test5(Connection C)
    throws Exception
      {
        List<Long> L = new ArrayList<Long>();
        L.add((long) 1); // Yeah, could have written 1l, but just spent 5mn of my life looking at this and thinking it was "11".
        L.add((long) 10);
        L.add((long) 100);
        Testing_Data D = Testing_Factory.Create(L, "Blah");
        if (D.Write(C) == false)
          throw new Exception("Bad stuff!");

        List<Character> Lc = new ArrayList<Character>();
        Lc.add('A');
        Lc.add('B');
        D.setA2b(Lc);

        List<Boolean> Lb = new ArrayList<Boolean>();
        Lb.add(true);
        Lb.add(true);
        Lb.add(false);
        D.setA3b(Lb);

        D.setA1(777);
        D.setA2('G');
        D.setDesc2("blah blah blah blah blah blah blah");

        if (D.Write(C) == false)
          throw new Exception("Bad stuff!");

        D.setNullA1();
        D.setNullA2();
        if (D.Write(C) == false)
          throw new Exception("Bad stuff!");

        ZonedDateTime Now = DateTimeUtil.NowLocal();
        D.setA9(Now);
        LOG.debug("A9 null?: " + D.isNullA9());
        List<ZonedDateTime> ZDTs = new ArrayList<ZonedDateTime>();
        ZDTs.add(DateTimeUtil.NewUTC(2018, 1, 1, 0, 0, 0, 0));
        ZDTs.add(DateTimeUtil.NewUTC(2018, 2, 1, 0, 0, 0, 0));
        ZDTs.add(DateTimeUtil.NewUTC(2018, 3, 1, 0, 0, 0, 0));
        ZDTs.add(Now);
        D.setA9b(ZDTs);
        LOG.debug("A9b: " + TextUtil.Print(D.getA9b()));
        LOG.debug("A9bTZ: " + TextUtil.Print(D.getA9bTZ()));
        if (D.Write(C) == false)
          throw new Exception("Bad stuff!");

        LocalDate Today = DateTimeUtil.NowLocalDate();
        D.setA9c(Today);
        LOG.debug("A9c null?: " + D.isNullA9c());
        List<LocalDate> LDs = new ArrayList<LocalDate>();
        LDs.add(DateTimeUtil.New(2018, 4, 1));
        LDs.add(DateTimeUtil.New(2018, 5, 1));
        LDs.add(DateTimeUtil.New(2018, 6, 1));
        LDs.add(Today);
        D.setA9d(LDs);
        if (D.Write(C) == false)
          throw new Exception("Bad stuff!");
        C.commit();

        D = Testing_Factory.LookupByPrimaryKey(D.getRefnum());
        if (D.Read(C) == false)
          throw new Exception("Bad stuff!");
        LOG.debug("A9: " + D.getA9());
        LOG.debug("A9b: " + TextUtil.Print(D.getA9b()));
        LOG.debug("A9bTZ: " + TextUtil.Print(D.getA9bTZ()));
        LOG.debug("A9c: " + D.getA9c());
        LOG.debug("A9d: " + TextUtil.Print(D.getA9d()));

        D.setNullA9();
        D.setNullA9b();
        D.setNullA9c();
        D.setNullA9d();
        if (D.Write(C) == false)
          throw new Exception("Bad stuff!");

        C.commit();
      }

    private static void Test4(Connection C)
    throws Exception
      {
        List<Long> L = new ArrayList<Long>();
        L.add(1l);
        L.add(10l);
        L.add(100l);
        Testing_Data D = Testing_Factory.Create(L, "Blah");

        List<Character> Lc = new ArrayList<Character>();
        Lc.add('A');
        Lc.add('B');
        D.setA2b(Lc);

        List<Boolean> Lb = new ArrayList<Boolean>();
        Lb.add(true);
        Lb.add(true);
        Lb.add(false);
        D.setA3b(Lb);

        List<Double> Ld = new ArrayList<Double>();
        Ld.add(2.3);
        Ld.add(6.3);
        D.setA4b(Ld);

        List<Float> Lf = new ArrayList<Float>();
        Lf.add(2.3f);
        Lf.add(6.3f);
        D.setA5b(Lf);

        List<Long> Ll = new ArrayList<Long>();
        Ll.add(1111111111111l);
        Ll.add(5555555555555l);
        D.setA6b(Ll);

        List<Integer> Li = new ArrayList<Integer>();
        Li.add(33333);
        Li.add(77777);
        D.setA7b(Li);


        if (D.Write(C) == false)
          throw new Exception("Bad stuff!");
        C.commit();

        D.setA1(777);
        D.setA2('G');
        D.setDesc2("blah blah blah blah blah blah blah");
        if (D.Write(C) == false)
          throw new Exception("Bad stuff!");
        C.commit();

      }


    private static void Test3(Connection C)
    throws Exception
      {
        LOG.debug("\n");
        LOG.debug("0, 0");
        ListResults<Key_Data> L = Key_Factory.LookupWhereAllByName(C, 0, 0);
        PrintDetails(L);

        LOG.debug("\n");
        LOG.debug("0, -1");
        L = Key_Factory.LookupWhereAllByName(C, 0, -1);
        PrintDetails(L);

        LOG.debug("\n");
        LOG.debug("5, -1");
        L = Key_Factory.LookupWhereAllByName(C, 5, -1);
        PrintDetails(L);

        LOG.debug("\n");
        LOG.debug("5, 5");
        L = Key_Factory.LookupWhereAllByName(C, 5, 5);
        PrintDetails(L);

        LOG.debug("\n");
        LOG.debug("10, 10");
        L = Key_Factory.LookupWhereAllByName(C, 10, 10);
        PrintDetails(L);

        LOG.debug("\n");
        LOG.debug("100, 100");
        L = Key_Factory.LookupWhereAllByName(C, 100, 100);
        PrintDetails(L);
      }

    private static void PrintDetails(ListResults<Key_Data> L)
      {
        LOG.debug("Size: " + L.size() + "; Start: " + L.getStart() + "; End: " + L.getEnd() + "; Max: " + L.getMax() + "; More: " + L.hasMore() + ";");
        LOG.debug("Keys:");
        for (Key_Data k : L)
          LOG.debug("   " + NumberFormatUtil.LeadingZero3(k.getRefnum()) + " / " + k.getName());
      }

    private static void Test2(Connection C)
    throws Exception
      {
        LOG.info("----------------------------------------------------------------------------------------------------------------------");
        LOG.info("- Local timezone date time");
        ZonedDateTime ZDTStart = DateTimeUtil.Now(ZoneId.systemDefault()).withMinute(0).withSecond(0).withNano(0);
        ZonedDateTime ZDTEnd = ZDTStart.plusHours(1);
        LOG.debug("Start (App): " + DateTimeUtil.printDateTime(ZDTStart));
        LOG.debug("End   (App): " + DateTimeUtil.printDateTime(ZDTEnd));
        TransPerf_Data TP = TransPerf_Factory.Create(TransPerf_Factory.SCHEMA_LABEL, TransPerf_Factory.TABLENAME_LABEL, ZDTStart, ZDTEnd, 10, 10, 10, 10);
        if (TP.Write(C) == false)
          throw new Exception("Cannot write TransPerf_Data Object");
        TP = TransPerf_Factory.LookupByPrimaryKey(TransPerf_Factory.SCHEMA_LABEL, TransPerf_Factory.TABLENAME_LABEL, ZDTStart);
        if (TP.Read(C) == false)
          throw new Exception("Cannot write TransPerf_Data Object");
        LOG.debug("Start (DB): " + DateTimeUtil.printDateTime(TP.getStartPeriod()));
        LOG.debug("End   (DB): " + DateTimeUtil.printDateTime(TP.getEndPeriod()));

        LOG.info("----------------------------------------------------------------------------------------------------------------------");
        LOG.info("- US/Pacific date time");
        ZDTStart = DateTimeUtil.Now(DateTimeZone.USPacific).withMinute(0).withSecond(0).withNano(0);
        ZDTEnd = ZDTStart.plusHours(1);
        LOG.debug("Start (App): " + DateTimeUtil.printDateTime(ZDTStart));
        LOG.debug("End   (App): " + DateTimeUtil.printDateTime(ZDTEnd));
        TP = TransPerf_Factory.Create(ObjectPerf_Factory.SCHEMA_LABEL, ObjectPerf_Factory.TABLENAME_LABEL, ZDTStart, ZDTEnd, 10, 10, 10, 10);
        if (TP.Write(C) == false)
          throw new Exception("Cannot write TransPerf_Data Object");
        TP = TransPerf_Factory.LookupByPrimaryKey(ObjectPerf_Factory.SCHEMA_LABEL, ObjectPerf_Factory.TABLENAME_LABEL, ZDTStart);
        if (TP.Read(C) == false)
          throw new Exception("Cannot write TransPerf_Data Object");
        LOG.debug("Start (DB): " + DateTimeUtil.printDateTime(TP.getStartPeriod()));
        LOG.debug("End   (DB): " + DateTimeUtil.printDateTime(TP.getEndPeriod()));

      }

    protected static void Test1()
    throws Exception
      {
        long T0 = System.nanoTime();
        for (int i = 0; i < 1000; ++i)
          LOG.debug("Getting key for TESTESTEST: " + KeysManager.getKey("TESTESTEST"));
        T0 = System.nanoTime() - T0;
        LOG.info("Took " + DurationUtil.PrintDuration(T0) + " or " + DurationUtil.PrintPerformancePerSecond(T0, 1000) + " keys/s");

        StringBuilder Str = new StringBuilder();
        PerfTracker.print(Str);
        LOG.debug(Str);

        /*
         * CK = ConnectionPool.get("KEYS");
         * 
         * Key k = Key.Create(CK, -2, "TESTESTEST", 0, 200);
         * if (k.Write() == false)
         * {
         * LOG.debug("Key " + k.getRefnum() + "/" + k.getName() + " already exists");
         * k = Key.Create(CK, -3, "TESTESTEST", 0, 200);
         * if (k.Write() == false)
         * LOG.debug("Key " + k.getRefnum() + "/" + k.getName() + " already exists");
         * }
         * else
         * {
         * k.setMax(500);
         * if (k.Write() == false)
         * throw new Exception("Cannot write the key");
         * }
         * 
         * CK.commit();
         * 
         * k = Key.LookupByPrimaryKey(CK, -2);
         * if (k.Read() == false)
         * throw new Exception("Cannot read the key");
         * 
         * k = Key.LookupByPrimaryKey(CK, -5653);
         * if (k.Read() == false)
         * {
         * k = Key.LookupByName(CK, "TILDA.TESTING");
         * if (k.Read() == false)
         * throw new Exception("Cannot read the key");
         * }
         * 
         * 
         * LOG.debug("k: " + k.toString());
         * 
         * CM = ConnectionPool.get("MAIN");
         * CK.rollback();
         */
      }
  }
