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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Clock;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.ConnectionPool;

public class DateTimeUtilTest
  {
    protected static final Logger LOG = LogManager.getLogger(DateTimeUtilTest.class.getName());

    public static void main(String[] args)
      {
        try
          {
//            Test1();
            Test2();
            Test3();
            Test4();
            Test5();
          }
        catch (Exception e)
          {
            LOG.catching(e);
          }
      }

/*
    private static void Test1()
    throws Exception
      {
        Calendar Cal = Calendar.getInstance();
        String CalStr = DateTimeUtil.PrintSQLTimestamp(Cal);
        System.out.println("Right now as SQL    : " + CalStr);
        long T0 = System.nanoTime();
        for (int i = 0; i < 1000000; ++i)
          {
            DateTimeUtil.PrintSQLTimestamp(Cal);
          }
        System.out.println("CalendarUtil.PrintSQLTimestamp: " + DurationUtil.PrintDuration(System.nanoTime() - T0));

        Cal = DateTimeUtil.parseDefault(CalStr);
        System.out.println("Roundtrip conversion: " + DateTimeUtil.PrintSQLTimestamp(Cal));

        String CalStr2 = DateTimeUtil.toHTTPDate(Cal);
        System.out.println("Right now as HTTP   : " + CalStr2);

        DateFormat F = new SimpleDateFormat("MMM d yyyy, HH:mm:ss:SSSZ");
        System.out.println("Right with formatter: " + F.format(Cal.getTime()));
        T0 = System.nanoTime();
        for (int i = 0; i < 1000000; ++i)
          {
            F.format(Cal.getTime());
          }
        System.out.println("SimpleDateFormat: " + DurationUtil.PrintDuration(System.nanoTime() - T0));

        Cal.setTimeZone(TimeZone.getTimeZone("IST"));
        CalStr = DateTimeUtil.PrintSQLTimestamp(Cal);
        System.out.println("Right now IST as SQL    : " + CalStr);
      }
*/

    private static void Test2()
    throws Exception
      {
        LOG.info("ZoneId.SHORT_IDs: " + ZoneId.SHORT_IDS.size());
        for (Map.Entry<String, String> z : ZoneId.SHORT_IDS.entrySet())
          LOG.info("     " + z.getKey() + ": " + z.getValue());
        LOG.info("ZoneId.getAvailableZoneIds(): " + ZoneId.getAvailableZoneIds().size());
        String[] TimeZones = (String[]) ZoneId.getAvailableZoneIds().toArray(new String[] {});
        Arrays.sort(TimeZones);
        for (String z : TimeZones)
          LOG.info("     " + z + " -> " + ZonedDateTime.now(ZoneId.of(z)).getOffset());

        // Calendar Cal0 = Calendar.getInstance();
        // Calendar Cal1 = Calendar.getInstance();
        // Calendar Cal2 = Calendar.getInstance(TimeZone.getTimeZone("IST"));
        // Calendar Cal3 = Calendar.getInstance();
        // Calendar Cal4 = Calendar.getInstance();

        Instant Ins0 = Instant.now();
        Instant Ins1 = Instant.now();
        Instant Ins2 = Clock.system(ZoneId.of("Asia/Kolkata")).instant();
        Instant Ins2b = Clock.system(ZoneId.of("US/Central")).instant();
        Instant Ins2c = Clock.system(ZoneId.of("US/Pacific-New")).instant();
        Instant Ins3 = Instant.now();
        Instant Ins4 = Instant.now();

        ZonedDateTime ZDT0 = ZonedDateTime.now();
        ZonedDateTime ZDT1 = ZonedDateTime.now();
        ZonedDateTime ZDT2 = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime ZDT2b = ZonedDateTime.now(ZoneId.of("US/Central"));
        ZonedDateTime ZDT2c = ZonedDateTime.now(ZoneId.of("US/Pacific-New"));
        ZonedDateTime ZDT3 = ZonedDateTime.now();
        ZonedDateTime ZDT4 = ZonedDateTime.now();

        OffsetDateTime ODT0 = OffsetDateTime.now();
        OffsetDateTime ODT1 = OffsetDateTime.now();
        OffsetDateTime ODT2 = OffsetDateTime.now(ZoneId.of("Asia/Kolkata"));
        OffsetDateTime ODT2b = OffsetDateTime.now(ZoneId.of("US/Central"));
        OffsetDateTime ODT2c = OffsetDateTime.now(ZoneId.of("US/Pacific-New"));
        OffsetDateTime ODT3 = OffsetDateTime.now();
        OffsetDateTime ODT4 = OffsetDateTime.now();


        // LOG.info("Cal0 : "+DateTimeUtil.PrintDateTimeWithMilliSeconds(Cal0));
        // LOG.info("Cal1 : "+DateTimeUtil.PrintDateTimeWithMilliSeconds(Cal1));
        // LOG.info("Cal2 : "+DateTimeUtil.PrintDateTimeWithMilliSeconds(Cal2));
        // LOG.info("Cal3 : "+DateTimeUtil.PrintDateTimeWithMilliSeconds(Cal3));
        // LOG.info("Cal4 : "+DateTimeUtil.PrintDateTimeWithMilliSeconds(Cal4));

        LOG.info("Ins0 : " + Ins0.toString());
        LOG.info("Ins1 : " + Ins1.toString());
        LOG.info("Ins2 : " + Ins2.toString());
        LOG.info("Ins2b: " + Ins2b.toString());
        LOG.info("Ins2c: " + Ins2c.toString());
        LOG.info("Ins3 : " + Ins3.toString());
        LOG.info("Ins4 : " + Ins4.toString());

        LOG.info("ZDT0 : " + ZDT0.toString());
        LOG.info("ZDT1 : " + ZDT1.toString());
        LOG.info("ZDT2 : " + ZDT2.toString());
        LOG.info("ZDT2b: " + ZDT2b.toString());
        LOG.info("ZDT2c: " + ZDT2c.toString());
        LOG.info("ZDT3 : " + ZDT3.toString());
        LOG.info("ZDT4 : " + ZDT4.toString());

        LOG.info("ODT0 : " + ODT0.toString());
        LOG.info("ODT1 : " + ODT1.toString());
        LOG.info("ODT2 : " + ODT2.toString());
        LOG.info("ODT2b: " + ODT2b.toString());
        LOG.info("ODT2c: " + ODT2c.toString());
        LOG.info("ODT3 : " + ODT3.toString());
        LOG.info("ODT4 : " + ODT4.toString());

        OffsetDateTime ODT = ZonedDateTime.of(2015, 3, 1, 13, 1, 2, 3, ZoneId.of("US/Eastern")).toOffsetDateTime();
        LOG.info("ODT : " + ODT.toString());
        ODT = ZonedDateTime.of(2015, 4, 1, 13, 1, 2, 3, ZoneId.of("US/Eastern")).toOffsetDateTime();
        LOG.info("ODT : " + ODT.toString());
        ODT = ZonedDateTime.of(2015, 5, 1, 13, 1, 2, 3000000, ZoneId.of("US/Eastern")).toOffsetDateTime();
        LOG.info("ODT : " + ODT.toString());
        ODT = ZonedDateTime.of(2015, 5, 1, 13, 1, 2, 30000000, ZoneId.of("US/Eastern")).toOffsetDateTime();
        LOG.info("ODT : " + ODT.toString());
        ODT = ZonedDateTime.of(2015, 5, 1, 13, 1, 2, 300000000, ZoneId.of("US/Eastern")).toOffsetDateTime();
        LOG.info("ODT : " + ODT.toString());

      }

    protected static final String format(OffsetDateTime ODT)
      {
        int offsetSeconds = ODT.getOffset().getTotalSeconds();
        char PlusMinus = ' ';
        if (offsetSeconds < 0)
          {
            PlusMinus = '-';
            offsetSeconds = -offsetSeconds;
          }
        else
          {
            PlusMinus = '+';
          }

        int offsetHours = offsetSeconds / 3600;
        int offsetMinutes = offsetSeconds / 60 - offsetHours * 60;

        return ODT.getYear() + "-"
        + NumberFormatUtil.LeadingZero1(ODT.getMonthValue())
        + "-"
        + NumberFormatUtil.LeadingZero1(ODT.getDayOfMonth())
        + "T"
        + NumberFormatUtil.LeadingZero1(ODT.getHour())
        + ":"
        + NumberFormatUtil.LeadingZero1(ODT.getMinute())
        + ":"
        + NumberFormatUtil.LeadingZero1(ODT.getSecond())
        + "."
        + NumberFormatUtil.LeadingZero2(ODT.getNano() / 1000000)
        + PlusMinus
        + NumberFormatUtil.LeadingZero1(offsetHours)
        + ":"
        + NumberFormatUtil.LeadingZero1(offsetMinutes);
      }

    private static void Test3()
    throws Exception
      {
        ZonedDateTime ZDT1 = ZonedDateTime.now(ZoneId.of("US/Eastern"));
        ZonedDateTime ZDT2 = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        ZonedDateTime ZDT3 = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        LOG.debug("Eastern times:");
        LOG.debug("      ZonedDateTime  / OFFSET: " + ZDT1.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        LOG.debug("      ZonedDateTime  / ZONED : " + ZDT1.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        LOG.debug("      OffsetDateTime / OFFSET: " + ZDT1.toOffsetDateTime().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        LOG.debug("      OffsetDateTime / ZONED : " + ZDT1.toOffsetDateTime().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        LOG.debug("      OffsetDateTime / CUSTOM: " + format(ZDT1.toOffsetDateTime()));

        LOG.debug("Pacific times:");
        LOG.debug("      ZonedDateTime  / OFFSET: " + ZDT2.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        LOG.debug("      ZonedDateTime  / ZONED : " + ZDT2.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        LOG.debug("      OffsetDateTime / OFFSET: " + ZDT2.toOffsetDateTime().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        LOG.debug("      OffsetDateTime / ZONED : " + ZDT2.toOffsetDateTime().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        LOG.debug("      OffsetDateTime / CUSTOM: " + format(ZDT2.toOffsetDateTime()));

        LOG.debug("India times:");
        LOG.debug("      ZonedDateTime  / OFFSET: " + ZDT3.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        LOG.debug("      ZonedDateTime  / ZONED : " + ZDT3.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        LOG.debug("      OffsetDateTime / OFFSET: " + ZDT3.toOffsetDateTime().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        LOG.debug("      OffsetDateTime / ZONED : " + ZDT3.toOffsetDateTime().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        LOG.debug("      OffsetDateTime / CUSTOM: " + format(ZDT3.toOffsetDateTime()));

        final int count = 1000000;
        OffsetDateTime ODT1 = ZDT1.toOffsetDateTime();
        long T0 = System.nanoTime();
        for (int i = 0; i < count; ++i)
          {
            String s = ODT1.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            if (s == null)
             s = "Error";
          }
        long T1 = System.nanoTime() - T0;
        LOG.info("DateTimeFormatter did " + DurationUtil.PrintPerformancePerSecond(T1, count) + " iterations/s.");

        T0 = System.nanoTime();
        for (int i = 0; i < count; ++i)
          {
            String s = format(ODT1);
            if (s == null)
              s = "Error";
          }
        long T2 = System.nanoTime() - T0;
        LOG.info("Custom format did " + DurationUtil.PrintPerformancePerSecond(T2, count) + " iterations/s.");

        if (T2 > T1)
          LOG.info("Beat the JDK implementation :)");
        else
          LOG.info("DID NOT beat the JDK implementation! :(");

      }

    public static void Test4()
    throws Exception
      {
        Connection C = ConnectionPool.get("MAIN");
        Calendar UTC_CALENDAR = Calendar.getInstance(java.util.TimeZone.getTimeZone(DateTimeZone.ZULU._ZoneId.getId()));

        String Q = "insert into TILDA.ZONEINFO (\"id\", \"value\", \"label\", \"created\", \"lastUpdated\") values (?, ?, ?, ?, statement_timestamp())";
        PreparedStatement PS = C.prepareStatement(Q);
        PS.setString(1, "toto");
        PS.setString(2, "tata");
        PS.setString(3, "etc/zulu");
        ZoneId Z = DateTimeZone.USPacific._ZoneId;
        LOG.debug("Zone: " + Z.getId());
        ZonedDateTime ZDT = DateTimeUtil.New(2000, 1, 1, 1, 0, 0, 0, Z);
        LOG.debug("ZDT: " + DateTimeUtil.printDateTimeForSQL(ZDT));
        PS.setTimestamp(4, new java.sql.Timestamp(ZDT.toInstant().toEpochMilli()), UTC_CALENDAR);
        LOG.debug(Q);
        int count = PS.executeUpdate();
        if (count == 0)
          throw new Exception("The insert failed");

        Q = "select \"created\", \"lastUpdated\" from TILDA.ZONEINFO where \"id\"='toto'";
        LOG.debug(Q);
        PS = C.prepareStatement(Q);
        ResultSet RS = PS.executeQuery();
        if (RS.next() == false)
          {
            LOG.debug("   No record was read.");
          }
        else
          {
            java.sql.Timestamp T = RS.getTimestamp(1, UTC_CALENDAR);
            ZonedDateTime ZDTDB = DateTimeUtil.toZonedDateTime(T, Z.getId());
            LOG.debug("ZDTDB: " + DateTimeUtil.printDateTimeForSQL(ZDTDB));

            if (ZDTDB.equals(ZDT) == false)
              throw new Exception("The timestamps are not equal!!!");

            T = RS.getTimestamp(2, UTC_CALENDAR);
            ZonedDateTime CTSDB = DateTimeUtil.toZonedDateTime(T, Z.getId());
            LOG.debug("current timestamp DB: " + DateTimeUtil.printDateTimeForSQL(CTSDB));

          }

        C.rollback();
      }

    public static void Test5()
      {
        ZonedDateTime ZDT1 = DateTimeUtil.getYesterdayTimestamp(true).plusHours(10);
        ZonedDateTime ZDT2 = DateTimeUtil.getTomorrowTimestamp(true).plusHours(9);
        LOG.debug(DateTimeUtil.printDateTime(ZDT1));
        LOG.debug(DateTimeUtil.printDateTime(ZDT2));
        LOG.debug("Days between: " + DateTimeUtil.computeDays(ZDT1, ZDT2));

        ZDT1 = DateTimeUtil.getYesterdayTimestamp(true).plusHours(10);
        ZDT2 = DateTimeUtil.getTomorrowTimestamp(true).plusHours(11);
        LOG.debug(DateTimeUtil.printDateTime(ZDT1));
        LOG.debug(DateTimeUtil.printDateTime(ZDT2));
        LOG.debug("Days between: " + DateTimeUtil.computeDays(ZDT1, ZDT2));

      }
  }
