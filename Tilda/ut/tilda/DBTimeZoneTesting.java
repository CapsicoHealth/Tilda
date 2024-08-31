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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.Key_Factory;
import tilda.data.ZoneInfo_Data;
import tilda.data_test.TestingTimestamps_Data;
import tilda.data_test.TestingTimestamps_Factory;
import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.JDBCHelper;
import tilda.db.processors.RecordProcessor;
import tilda.utils.DateTimeUtil;
import tilda.utils.TextUtil;

public class DBTimeZoneTesting extends Key_Factory
  {
    protected static final Logger LOG = LogManager.getLogger(DBTimeZoneTesting.class.getName());

    protected DBTimeZoneTesting()
      {
      }

    public static void main(String[] args)
      {

        Connection C = null;
        try
          {
            C = ConnectionPool.get("MAIN");

//            testTimestamps();
//            listTimeZones();
            TildaTesting(C);
            //JDBCTesting(C);

            C.commit();
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
                  C.close();
                }
              catch (SQLException E)
                {
                }
          }
        LOG.debug("END");
      }

    private static void listTimeZones()
      {
       Set<String> ZIs = ZoneId.getAvailableZoneIds();
       List<String> sortedList = new ArrayList<String>();
       for (String ziStr : ZIs)
         {
           ZoneId zi = ZoneId.of(ziStr);
           sortedList.add(zi.getDisplayName(TextStyle.SHORT, Locale.US)+" - "+zi.getId());
//           LOG.debug("id: "+zi.getId()
//           +";   displayF: "+zi.getDisplayName(TextStyle.FULL, Locale.US)
//           +";   displayS: "+zi.getDisplayName(TextStyle.SHORT, Locale.US)
//           );
           // Id and Narrow are the same
           if (zi.getId().equals(zi.getDisplayName(TextStyle.NARROW, Locale.US)) == false)
             LOG.debug("        ---> DIFF");
         }
       Collections.sort(sortedList);
       for (String str : sortedList)
         LOG.debug(str);
        
      }

    
    protected static void printTimestamp(ZonedDateTime ZDT)
      {
        Instant inst = ZDT.toInstant();
        java.sql.Timestamp ts1 = java.sql.Timestamp.from(ZDT.toInstant());
        java.sql.Timestamp ts2 = java.sql.Timestamp.from(ZDT.withZoneSameLocal(ZoneOffset.UTC).toInstant());
        java.sql.Timestamp ts3 = java.sql.Timestamp.from(ZDT.withZoneSameLocal(ZoneOffset.systemDefault()).toInstant());
        java.sql.Timestamp ts4 = java.sql.Timestamp.from(ZDT.withZoneSameLocal(DateTimeUtil._LOCAL).toInstant());
        LOG.debug("dt1: "+ZDT); 
        LOG.debug("    - toInstant: "+ts1); 
        LOG.debug("    - withZoneSameLocal.UTC.toInstant: "+ts2); 
        LOG.debug("    - withZoneSameLocal.LOCAL.toInstant: "+ts3); 
      }
    
    
    protected static void testTimestamps()
     {
       printTimestamp(DateTimeUtil.getTodayTimestamp(true));
       printTimestamp(ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("America/New_York")));
       printTimestamp(ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("US/Eastern")));
       printTimestamp(ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("America/Chicago")));        
       printTimestamp(ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("US/Central")));        
       printTimestamp(ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("America/Denver")));        
       printTimestamp(ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("US/Mountain")));        
       printTimestamp(ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("America/Los_Angeles")));
       printTimestamp(ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("US/Pacific")));
       
     }
    
    protected static class DateTimeVariations
      {
        public DateTimeVariations(ResultSet RS, int baseColNum)
          throws Exception
          {
            _dt_tz = getZoneInfo(RS.getString(baseColNum));
            _dt_ts = RS.getTimestamp(baseColNum + 1);
//            _dt_tscal = RS.getTimestamp(baseColNum + 1, DateTimeUtil._UTC_CALENDAR);
//            _dt_odt = RS.getObject(baseColNum + 1, OffsetDateTime.class);
//            _dt_zdt1 = _dt_ts.toInstant().atZone(ZoneId.of(_dt_tz.getValue()));
            _dt_zdt2 = _dt_ts.toLocalDateTime().atZone(ZoneId.of(_dt_tz.getValue()));
            
          }

        public final ZoneInfo_Data      _dt_tz;
        public final java.sql.Timestamp _dt_ts;
//        public final java.sql.Timestamp _dt_tscal;
//        public final OffsetDateTime     _dt_odt;
//        public final ZonedDateTime      _dt_zdt1;
        public final ZonedDateTime      _dt_zdt2;

        private final static ZoneInfo_Data getZoneInfo(String TimezoneId)
        throws Exception
          {
            ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(TimezoneId);
            if (ZI == null && TextUtil.isNullOrEmpty(TimezoneId) == false)
              throw new Exception("Timezone Id '" + TimezoneId + "' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
            return ZI;
          }

        public String toString()
          {
            return "TZ:" + _dt_tz.getId() + "[" + _dt_tz.getValue() + "]"
            + ", TS:" + _dt_ts.toString() +"["+_dt_ts.getTimezoneOffset()+"mn]"
//            + ", TSCAL:" + _dt_tscal.toString()+"["+_dt_tscal.getTimezoneOffset()+"mn]"
//            + ", ODT:" + _dt_odt.toString()+"["+_dt_odt.getOffset().getTotalSeconds()+"s]"
//            + ", ZDT1:" + _dt_zdt1.toString()
            + ", ZDT2:" + _dt_zdt2.toString()
            + ";";
          }

      }

    protected static class TimestampRP implements RecordProcessor
      {

        @Override
        public boolean process(int count, ResultSet RS)
        throws Exception
          {
            LOG.debug("RS:\n"+JDBCHelper.printResultSet(RS));
            DateTimeVariations dt1 = new DateTimeVariations(RS, 1);
            DateTimeVariations dt2 = new DateTimeVariations(RS, 3);
            DateTimeVariations dt3 = new DateTimeVariations(RS, 5);
            DateTimeVariations dt4 = new DateTimeVariations(RS, 7);

            LOG.debug("TD1---> " + dt1.toString());
            LOG.debug("TD2---> " + dt2.toString());
            LOG.debug("TD3---> " + dt3.toString());
            LOG.debug("TD4---> " + dt4.toString());

            return false;
          }

      }

    private static void JDBCTesting(Connection C)
    throws Exception
      {
        String Q = "CREATE TABLE IF NOT EXISTS TILDATEST.TestingJDBCTimestamps (dt1tz varchar, dt1 timestamptz, dt2tz varchar, dt2 timestamp, dt3tz varchar, dt3 timestamptz, dt4tz varchar, dt4 timestamp)";
        C.executeDDL("TILDATEST", "TestingJDBCTimestamps", Q);

        Q = "TRUNCATE TABLE TILDATEST.TestingJDBCTimestamps";
        C.executeDelete("TILDATEST", "TestingJDBCTimestamps", Q);

        Q = "insert into TILDATEST.TestingJDBCTimestamps(dt1, dt1tz, dt2, dt2tz, dt3, dt3tz, dt4, dt4tz)"
        + "       values (statement_timestamp() at time zone 'utc', 'UTC', (statement_timestamp() at time zone 'utc')::timestamp, 'UTC', '2024-05-18T16:05:00.123456-0400', 'USEa', '2024-05-18T16:05:00.123456', 'USEa')";
        C.executeInsert("TILDATEST", "TestingJDBCTimestamps", Q);

        Q = "select dt1tz, dt1, dt2tz, dt2, dt3tz, dt3, dt4tz, dt4 from TILDATEST.TestingJDBCTimestamps";
        C.executeSelect("TILDATEST", "TestingJDBCTimestamps", Q, new TimestampRP());


        
        Q = "TRUNCATE TABLE TILDATEST.TestingJDBCTimestamps";
        C.executeDelete("TILDATEST", "TestingJDBCTimestamps", Q);

        Q = "insert into TILDATEST.TestingJDBCTimestamps(dt1, dt1tz, dt2, dt2tz, dt3, dt3tz, dt4, dt4tz)"
        + "       values (statement_timestamp() at time zone 'utc', 'UTC', (statement_timestamp() at time zone 'utc')::timestamp, 'UTC', ?, 'USEa', ?, 'USEa')";
        java.sql.Connection C2 = C.unwrap(java.sql.Connection.class);
        java.sql.PreparedStatement PS = C2.prepareStatement(Q);
        ZonedDateTime ZDT = DateTimeUtil.nowLocal();
        PS.setTimestamp(1, java.sql.Timestamp.from(ZDT.toInstant()), DateTimeUtil._UTC_CALENDAR);
        PS.setTimestamp(2, java.sql.Timestamp.from(ZDT.toInstant()));
        int count = PS.executeUpdate();
        LOG.debug("count: "+count);
        Q = "select dt1tz, dt1, dt2tz, dt2, dt3tz, dt3, dt4tz, dt4 from TILDATEST.TestingJDBCTimestamps";
        C.executeSelect("TILDATEST", "TestingJDBCTimestamps", Q, new TimestampRP());
      }

    protected static void TildaTesting(Connection C)
    throws Exception
      {
        TestZDTValues(C, "blah", "CurrentTimestamp", DateTimeUtil.NOW_PLACEHOLDER_ZDT);
        TestZDTValues(C, "bleh", "Today's 00:00:00", DateTimeUtil.getTodayTimestamp(true));
        TestZDTValues(C, "blih1", "New York"   , ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("America/New_York")));
        TestZDTValues(C, "blih2", "US Eastern" , ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("US/Eastern")));
        TestZDTValues(C, "bloh1", "Chicago"    , ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("America/Chicago")));        
        TestZDTValues(C, "bloh2", "US Central" , ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("US/Central")));        
        TestZDTValues(C, "bluh1", "Denver"     , ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("America/Denver")));        
        TestZDTValues(C, "bluh2", "US Mountain", ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("US/Mountain")));        
        TestZDTValues(C, "blyh1", "Los Angeles", ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("America/Los_Angeles")));
        TestZDTValues(C, "blyh2", "US Pacific" , ZonedDateTime.of(2024, 5, 18, 16, 55, 30, 123456, ZoneId.of("US/Pacific")));
      }

    protected static void TestZDTValues(Connection C, String dataName, String dataDescription, ZonedDateTime ZDT)
    throws Exception
      {
        TestingTimestamps_Data TT;
        TT = TestingTimestamps_Factory.lookupById(dataName);
        TT.setDt1(ZDT);
        TT.setDt2(ZDT);
        TT.setDt3(ZDT);
        TT.setDt4(ZDT);
        if (TT.write(C) == false)
          {
            TT = TestingTimestamps_Factory.create(dataName);
            TT.setDt1(ZDT);
            TT.setDt2(ZDT);
            TT.setDt3(ZDT);
            TT.setDt4(ZDT);
            if (TT.write(C) == false)
              throw new Exception("Cannot create '"+dataName+"' record");
          }

        TT = TestingTimestamps_Factory.lookupById(dataName);
        if (TT.read(C) == false)
          throw new Exception("Cannot read the record back");

        LOG.debug("");
        LOG.debug("**************************************************************************************************");
        LOG.debug("Dataset '"+dataName+"': "+dataDescription);
        LOG.debug("dt1: " + DateTimeUtil.printDateTime(TT.getDt1()));
        LOG.debug("dt2: " + DateTimeUtil.printDateTime(TT.getDt2()));
        LOG.debug("dt3: " + DateTimeUtil.printDateTime(TT.getDt3()));
        LOG.debug("dt4: " + DateTimeUtil.printDateTime(TT.getDt4()));
        LOG.debug("**************************************************************************************************");
        LOG.debug("");
        LOG.debug("");
        LOG.debug("");
      }
  }
