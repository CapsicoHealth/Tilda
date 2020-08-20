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

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.JDBCHelper;
import tilda.enums.TimeSeriesType;

public class DateTimeUtil
  {
    protected static final Logger     LOG                 = LogManager.getLogger(JDBCHelper.class.getName());

    protected static final ZoneId     _UTC                = ZoneId.of("Etc/UTC");

    public static final ZonedDateTime NOW_PLACEHOLDER_ZDT = newUTC(999, 12, 31, 23, 59, 0, 0);
    public static final LocalDate     NOW_PLACEHOLDER_D   = LocalDate.of(999, 12, 31);

    public static boolean isNowPlaceholder(ZonedDateTime ZDT)
      {
        return ZDT != null && ZDT.equals(NOW_PLACEHOLDER_ZDT);
      }

    public static boolean isNowPlaceholder(LocalDate D)
      {
        return D != null && D.equals(NOW_PLACEHOLDER_D);
      }


    public static final ZonedDateTime UNDEFINED_PLACEHOLDER_ZDT = newUTC(1111, 11, 11, 0, 0, 0, 0);
    public static final LocalDate     UNDEFINED_PLACEHOLDER_D   = LocalDate.of(1111, 11, 11);

    public static boolean isUndefinedPlaceholder(ZonedDateTime ZDT)
      {
        return ZDT != null && ZDT.equals(UNDEFINED_PLACEHOLDER_ZDT);
      }

    public static boolean isUndefinedPlaceholder(LocalDate D)
      {
        return D != null && D.equals(UNDEFINED_PLACEHOLDER_D);
      }


    public static final Calendar _UTC_CALENDAR = Calendar.getInstance(java.util.TimeZone.getTimeZone(_UTC.getId()));

    /**
     * Returns a new ZonedDateTime object in the UTC timezone, based on the information provided using
     * the ZonedDateTime class conventions.
     */
    public static ZonedDateTime newUTC(int Year, int Month, int Day, int Hour, int Minutes, int Seconds, int Milliseconds)
      {
        return newTZ(Year, Month, Day, Hour, Minutes, Seconds, Milliseconds * 1000000, _UTC);
      }

    /**
     * Returns a new ZonedDateTime object based on the information provided using
     * the ZonedDateTime class conventions.
     */
    public static ZonedDateTime newTZ(int Year, int Month, int Day, int Hour, int Minutes, int Seconds, int Milliseconds, ZoneId Z)
      {
        return ZonedDateTime.of(Year, Month, Day, Hour, Minutes, Seconds, Milliseconds * 1000000, Z);
      }

    public static ZonedDateTime newTZ(int Year, int Month, int Day, int Hour, int Minutes, int Seconds, int Milliseconds, DateTimeZone Z)
      {
        return ZonedDateTime.of(Year, Month, Day, Hour, Minutes, Seconds, Milliseconds * 1000000, Z._ZoneId);
      }

    public static LocalDate newYMD(int Year, int Month, int Day)
      {
        return LocalDate.of(Year, Month, Day);
      }


    public static String getCurrentZoneOffset()
      {
        return ZonedDateTime.now().getOffset().getId();
      }

    public static ZonedDateTime nowLocal()
      {
        return ZonedDateTime.now();
      }

    public static ZonedDateTime nowUTC()
      {
        return ZonedDateTime.now(_UTC);
      }

    public static ZonedDateTime nowTZ(ZoneId Z)
      {
        return ZonedDateTime.now(Z);
      }

    public static ZonedDateTime nowTZ(DateTimeZone Z)
      {
        return ZonedDateTime.now(Z._ZoneId);
      }

    public static LocalDate nowLocalDate()
      {
        return LocalDate.now();
      }


    public static ZonedDateTime oldest(ZonedDateTime ZDT1, ZonedDateTime ZDT2)
      {
        return ZDT1 == null ? ZDT2 : ZDT2 == null ? ZDT1 : ZDT1.compareTo(ZDT2) < 0 ? ZDT1 : ZDT2;
      }

    public static ZonedDateTime youngest(ZonedDateTime ZDT1, ZonedDateTime ZDT2)
      {
        return ZDT1 == null ? ZDT2 : ZDT2 == null ? ZDT1 : ZDT1.compareTo(ZDT2) > 0 ? ZDT1 : ZDT2;
      }

    private static final DateTimeFormatter HTTPDateFormater = DateTimeFormatter.ofPattern("EEE, d MMM yyyy kk:mm:ss z");

    public static String printDateTimeForHTTP(ZonedDateTime ZDT)
      {
        return ZDT.format(HTTPDateFormater);
      }

    /**
     * Simple method to get a ZonedDateTime object out of a string and a pattern
     */
    public static ZonedDateTime parse(String DateTimeStr, String Pattern)
      {
        if (TextUtil.isNullOrEmpty(DateTimeStr) == true)
          return null;
        try
          {
            return ZonedDateTime.parse(DateTimeStr, DateTimeFormatter.ofPattern(Pattern));
          }
        catch (DateTimeParseException E)
          {
            LOG.warn("Cannot parse " + DateTimeStr + " with pattern " + Pattern + ": " + E.getMessage());
            return null;
          }
      }

    /**
     * Simple method to get a LocalDate object out of a string and a pattern.
     * <P>
     * This method returns a LocalDate based on a string value and a standard pattern. It avoids throwing an exception
     * if the data cannot be parsed and will return NULL instead with a warning in the logs.
     * 
     * @return a LocalDate object if the string could be parsed, or null otherwise.
     */
    public static LocalDate parseDate(String dateStr, String Pattern)
      {
        if (TextUtil.isNullOrEmpty(dateStr) == true)
          return null;
        try
          {
            return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(Pattern));
          }
        catch (DateTimeParseException E)
          {
            LOG.warn("Cannot parse " + dateStr + " with pattern " + Pattern + ": " + E.getMessage());
            return null;
          }
      }

    /**
     * Simple method to get a LocalDate object out of a string for the default pattern 'yyyy-MM-dd'.
     * <P>
     * This method returns a LocalDate based on a string value and a standard pattern. It avoids throwing an exception
     * if the data cannot be parsed and will return NULL instead with a warning in the logs.
     * 
     * @return a LocalDate object if the string could be parsed, or null otherwise.
     */
    public static LocalDate parseDate(String dateStr)
      {
        return parseDate(dateStr, "yyyy-MM-dd");
      }

    public static java.sql.Timestamp parseToSqlTimestamp(String DateTimeStr, String Pattern)
      {
        return new java.sql.Timestamp(parse(DateTimeStr, Pattern).toInstant().toEpochMilli());
      }

    public static String printDateTime(ZonedDateTime ZDT, String Pattern)
      {
        return ZDT.format(DateTimeFormatter.ofPattern(Pattern));
      }

    public static String printDateTime(ZonedDateTime ZDT)
      {
        return ZDT.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
      }

    public static String printDateTime(List<ZonedDateTime> L)
      {
        StringBuilder Str = new StringBuilder();
        boolean First = true;
        for (ZonedDateTime d : L)
          {
            if (First == true)
              First = false;
            else
              Str.append(", ");
            Str.append(DateTimeUtil.printDateTime(d));
          }
        return Str.toString();
      }

    public static String printDateTimeForSQL(ZonedDateTime ZDT)
      {
        return ZDT == null ? null : ZDT.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
      }

    public static String printDateForSQL(LocalDate DT)
      {
        return DT == null ? null : DT.format(DateTimeFormatter.ISO_DATE);
      }

    public static List<String> printDateTimeForSQL(List<ZonedDateTime> ZDTs)
      {
        if (ZDTs == null)
          return null;
        List<String> L = new ArrayList<String>();
        for (ZonedDateTime ZDT : ZDTs)
          L.add(printDateTimeForSQL(ZDT));
        return L;
      }

    public static String printDateTimeForJSON(ZonedDateTime ZDT)
      {
        return printDateTimeForJSON(ZDT, false);
      }

    public static String printDateTimeForJSON(ZonedDateTime ZDT, boolean forceISOZDT)
      {
        // LDH-NOTE: Not understanding why ISO_OFFSET_DATE_TIME doesn't deliver formatting like yyyy-MM-dd'T'HH:mm:ss.SSSXXX which it is supposed to be.
        return ZDT == null ? null : forceISOZDT == true ? ZDT.format(DateTimeFormatter.ISO_ZONED_DATE_TIME) : ZDT.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSxxx")); // DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                                                                                                                                                                                     // //ISO_ZONED_DATE_TIME);
      }

    public static String printDate(LocalDate D)
      {
        return D == null ? null : D.format(DateTimeFormatter.ISO_DATE);
      }

    public static String printDateForJSON(LocalDate D)
      {
        return D == null ? null : D.format(DateTimeFormatter.ISO_DATE);
      }

    public static String printDate(List<LocalDate> L)
      {
        StringBuilder Str = new StringBuilder();
        boolean First = true;
        for (LocalDate d : L)
          {
            if (First == true)
              First = false;
            else
              Str.append(", ");
            Str.append(DateTimeUtil.printDate(d));
          }
        return Str.toString();
      }


    /**
     * Will parse an ISO string, even if partially done. It will auto-complete as per {@link #parseWithoutZone(String)}.
     * <UL>
     * <LI>yyyy-dd-mm -> yyy-mm-ddT00:00:00+04:00 (for EDT timezone)</LI>
     * <LI>yyyy-dd-mmThh:mm -> yyy-mm-ddThh:mm:00+04:00</LI>
     * <LI>yyyy-dd-mmThh:mm -> yyy-mm-ddThh:mm:00+04:00</LI>
     * <LI>yyyy-dd-mmThh:mm:ss -> yyy-mm-ddThh:mm:ss+04:00</LI>
     * <LI>yyyy-dd-mmThh:mm:ss+hh:mm -> yyy-mm-ddThh:mm:ss+hh:mm</LI>
     * </UL>
     * 
     * @param DateTimeStr
     * @return a ZonedDateTime object, or null if an error occurred (doesn't throw but will log exception if one occurred)
     */
    public static ZonedDateTime parsefromJSON(String DateTimeStr)
      {
        if (TextUtil.isNullOrEmpty(DateTimeStr) == true)
          return null;
        ZonedDateTime ZDT = null;
        if (DateTimeStr.length() < 25)
          ZDT = parseWithoutZone(DateTimeStr);
        if (ZDT == null)
          try
            {
              return ZonedDateTime.parse(DateTimeStr, DateTimeFormatter.ISO_ZONED_DATE_TIME);
            }
          catch (Exception E)
            {
              LOG.catching(E);
            }
        return ZDT;
      }

    public static List<ZonedDateTime> parsefromJSON(List<String> DateTimeStr)
      {
        if (TextUtil.isNullOrEmpty(DateTimeStr) == true)
          return null;
        List<ZonedDateTime> L = new ArrayList<ZonedDateTime>();
        for (String Str : DateTimeStr)
          L.add(parsefromJSON(Str));
        return L;
      }


    public static LocalDate parseDateFromJSON(String DateStr)
      {
        if (TextUtil.isNullOrEmpty(DateStr) == true)
          return null;
        try
          {
            return LocalDate.parse(DateStr, DateTimeFormatter.ISO_DATE);
          }
        catch (Exception E)
          {
            LOG.catching(E);
          }
        return null;
      }


    private static Pattern _ISO_NOZONE_DATETIME = Pattern.compile("(\\d{4}).(\\d{2}).(\\d{2}).(\\d{2}).(\\d{2}).(\\d{2})");

    /**
     * Takes a zone-less timestamp and returns a ZonedDateTime based on the system zone.
     * It will auto-complete with 0's if hours, minutes and/or seconds are missing and use
     * the appropriate offset as per the system ZoneId.
     * <UL>
     * <LI>yyyy-dd-mm -> yyy-mm-dd 00:00:00</LI>
     * <LI>yyyy-dd-mm hh:mm -> yyy-mm-dd hh:mm:00</LI>
     * <LI>yyyy-dd-mm hh:mm:ss -> yyy-mm-dd hh:mm:ss</LI>
     * </UL>
     * 
     * @param DateTimeStr
     * @return a ZonedDateTime object, or null if an error occurred (doesn't throw but will log exception if one occurred)
     */
    public static ZonedDateTime parseWithoutZone(String DateTimeStr)
      {
        if (TextUtil.isNullOrEmpty(DateTimeStr) == true)
          return null;

        if (DateTimeStr.length() == 10)
          DateTimeStr += " 00:00:00";
        else if (DateTimeStr.length() == 16)
          DateTimeStr += ":00";

        Matcher M = _ISO_NOZONE_DATETIME.matcher(DateTimeStr);
        if (M.matches() == false)
          return null;

        int year = Integer.parseInt(M.group(1));
        int month = Integer.parseInt(M.group(2));
        int day = Integer.parseInt(M.group(3));
        int hours = Integer.parseInt(M.group(4));
        int minutes = Integer.parseInt(M.group(5));
        int seconds = Integer.parseInt(M.group(6));

        try
          {
            return newTZ(year, month, day, hours, minutes, seconds, 0, ZoneId.systemDefault());
          }
        catch (Exception E)
          {
            LOG.catching(E);
          }
        return null;
      }


    private static final DateTimeFormatter GeneralFormater        = DateTimeFormatter.ofPattern("MMM d yyyy");
    private static final DateTimeFormatter GeneralFormaterTime    = DateTimeFormatter.ofPattern("MMM d yyyy, HH:mmz");
    private static final DateTimeFormatter GeneralFormaterTimeSec = DateTimeFormatter.ofPattern("MMM d yyyy, HH:mm:ssz");

    public static String printDateTimeFriendly(ZonedDateTime ZDT, boolean PrintTime, boolean PrintSeconds)
      {
        return ZDT == null ? "NA" : ZDT.format(PrintTime == true ? PrintSeconds == true ? GeneralFormaterTimeSec : GeneralFormaterTime : GeneralFormater);
      }

    private static final DateTimeFormatter CompactFormater        = DateTimeFormatter.ofPattern("YYYY.MM.dd");
    private static final DateTimeFormatter CompactFormaterTime    = DateTimeFormatter.ofPattern("YYYY.MM.dd_HH:mmz");
    private static final DateTimeFormatter CompactFormaterTimeSec = DateTimeFormatter.ofPattern("YYYY.MM.dd_HH:mm:ssz");

    public static String printDateTimeCompact(ZonedDateTime ZDT, boolean PrintTime, boolean PrintSeconds)
      {
        return ZDT == null ? "NA" : ZDT.format(PrintTime == true ? PrintSeconds == true ? CompactFormaterTimeSec : CompactFormaterTime : CompactFormater);
      }

    private static final DateTimeFormatter SuperCompactFormater = DateTimeFormatter.ofPattern("YYYY-MM-dd_HH-mm-ss");

    public static String printDateTimeSuperCompact(ZonedDateTime ZDT)
      {
        return ZDT == null ? "NA" : ZDT.format(SuperCompactFormater);
      }

    private static final DateTimeFormatter Time24HFormater = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static String printTime24(ZonedDateTime ZDT)
      {
        return ZDT == null ? "NA" : ZDT.format(Time24HFormater);
      }


    private static final DateTimeFormatter DayTimeFormater = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter WeekFormater    = DateTimeFormatter.ofPattern("EEEE d, HH:mm");

    /**
     * Compute a contextual date based on now. For example, if the date passed is from today, will print only
     * "10:54am today". If yesterday, will print "4:24pm yesterday". If within a week, will print
     * "last/this Monday 1:30pm". If
     * the date is older, will simply print "March 23" or "March 23, 12:30pm" if AlwaysPrintTime is true.<BR>
     * This method is not localized.
     * 
     * @param ZDT The date whose value to print
     * @param AlwaysPrintTime Whether Time should be printed for "beyond the week" dates
     * @return a stringwith the printed date.
     */
    public static String printDateTimeContextual(ZonedDateTime ZDT, boolean PrintTime, boolean PrintSeconds)
      {
        if (ZDT == null)
          return "N/A";
        int Days = computeDaysToNow(ZDT);
        if (Days > -8 && Days < -1) // last week
          return ZDT.format(WeekFormater);
        else if (Days == -1) // yesterday
          return ZDT.format(DayTimeFormater) + " yesterday";
        else if (Days == 0) // today
          return ZDT.format(DayTimeFormater) + " today";
        else if (Days == 1) // tomorrow
          return ZDT.format(DayTimeFormater) + " tomorrow";
        else if (Days > 1 && Days < 8) // this week
          return ZDT.format(WeekFormater);
        return printDateTimeFriendly(ZDT, PrintTime, PrintSeconds);
      }



    /**
     * Expects a TimeStanmp object directly form the database, typically in local time,
     * and converts it to the right date and time in the supplied timezone ZoneStr. If
     * ZoneStr is null of invalid, the returned Zon3dDateTime will be in UTC.
     * 
     * @param T
     * @param ZoneStr
     * @return
     */
    public static ZonedDateTime toZonedDateTime(java.sql.Timestamp T, String ZoneStr)
      {
        if (T == null)
          return null;

        ZonedDateTime ZDT = ZonedDateTime.of(T.toLocalDateTime(), ZoneId.systemDefault());
        try
          {
            return ZDT.withZoneSameInstant(ZoneStr == null ? _UTC : ZoneId.of(ZoneStr));
          }
        catch (Exception E)
          {
            LOG.warn("Invalid zone id '" + ZoneStr + "'. Used zone offset instead");
          }
        return ZDT.withZoneSameInstant(_UTC);
      }

    public static ZonedDateTime toZonedDateTime(LocalDate dt, String zoneStr)
      {
        if (dt == null)
          return null;

        ZonedDateTime ZDT = ZonedDateTime.of(dt.atStartOfDay(), ZoneId.systemDefault());
        try
          {
            return ZDT.withZoneSameInstant(zoneStr == null ? _UTC : ZoneId.of(zoneStr));
          }
        catch (Exception E)
          {
            LOG.warn("Invalid zone id '" + zoneStr + "'. Used zone offset instead");
          }
        return ZDT.withZoneSameInstant(_UTC);
      }


    public static LocalDate toLocalDate(java.sql.Date D)
      {
        // LOG.debug("y: "+D.getYear()+"; m: "+D.getMonth()+"; d: "+D.getDate());
        return D == null ? null : LocalDate.of(D.getYear() + 1900, D.getMonth() + 1, D.getDate());
      }

    public static List<LocalDate> toLocalDates(List<java.sql.Date> D)
      {
        List<LocalDate> L = new ArrayList<LocalDate>();
        for (java.sql.Date d : D)
          L.add(toLocalDate(d));
        return L;
      }

    public static Set<LocalDate> toLocalDates(Set<java.sql.Date> D)
      {
        Set<LocalDate> S = new HashSet<LocalDate>();
        for (java.sql.Date d : D)
          S.add(toLocalDate(d));
        return S;
      }


    /**
     * Adds/substract randomly between minDays and maxDays number of days to this date
     * and sets the hours within the range prescribed (min/maxHours), and a randomly selected minute between 0 and 60.
     */
    public static ZonedDateTime addRandomDeltaDays(ZonedDateTime ZDT, int minDays, int maxDays, int minHour, int maxHour)
      {
        if (ZDT == null)
          return null;

        int days = (int) Math.floor((Math.random() * (maxDays - minDays)) + minDays);
        int hours = (int) Math.floor((Math.random() * (maxHour - minHour)) + minHour);
        int minutes = (int) Math.floor((Math.random() * 60));

        return ZDT.plusDays(days).withHour(hours).withMinute(minutes);
      }

    /**
     * Adds/substract randomly between min/maxHours number of hours to this date, and a randomly selected minute between 0 and 60.
     */
    public static ZonedDateTime addRandomDeltaHours(ZonedDateTime ZDT, int minHour, int maxHour)
      {
        if (ZDT == null)
          return null;

        int hours = (int) Math.floor((Math.random() * (maxHour - minHour)) + minHour);
        int minutes = (int) Math.floor((Math.random() * 60));

        return ZDT.plusHours(hours).withMinute(minutes);
      }

    /**
     * Adds/substract randomly between min/maxMinutes number of minutes to this date.
     */
    public static ZonedDateTime addRandomDeltaMinutes(ZonedDateTime ZDT, int minMinutes, int maxMinutes)
      {
        if (ZDT == null)
          return null;

        int minutes = (int) Math.round((Math.random() * (minMinutes - minMinutes)) + minMinutes);

        return ZDT.plusMinutes(minutes);
      }


    public static int computeAgeNow(ZonedDateTime BirthDate)
      {
        return computeAgeWhen(BirthDate, ZonedDateTime.now());
      }

    public static int computeAgeWhen(ZonedDateTime BirthDate, ZonedDateTime When)
      {
        if (BirthDate == null)
          return -1;
        return Period.between(BirthDate.toLocalDate(), When.toLocalDate()).getYears();
      }

    public static int computeDaysToNow(ZonedDateTime Start)
      {
        return computeDays(Start, ZonedDateTime.now());
      }

    /**
     * Compute the number of days using the midnight rule, i.e., from 23:59 Monday night to 00:01 Tuesday morning, that
     * counts as one day.
     * 
     * @param Start
     * @param End
     * @return
     */
    public static int computeDays(ZonedDateTime Start, ZonedDateTime End)
      {
        if (Start == null || End == null)
          return -1;
        int days = (int) ChronoUnit.DAYS.between(Start, End);
        if (secondsSinceMidnight(Start) > secondsSinceMidnight(End))
          ++days;
        return days;
      }



    private static int secondsSinceMidnight(ZonedDateTime ZDT)
      {
        // LOG.debug("hour: "+ZDT.getHour()+"; minute: "+ZDT.getMinute()+"; second: "+ZDT.getSecond()+";");
        return ZDT.getHour() * 60 * 60 + ZDT.getMinute() * 60 + ZDT.getSecond();
      }

    /**
     * Returns a ZonedDateTime for the very beginning of Today at 00:00:00:0000 if Start == true,
     * or 23:59:59:999999999 is Start == false.
     * 
     * @return
     */
    public static ZonedDateTime getTodayTimestamp(boolean Start)
      {
        return Start == true ? ZonedDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0)
        : ZonedDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);
      }

    /**
     * Returns a ZonedDateTime for the very beginning of Yesterday at 00:00:00:0000 or
     * 23:59:59:999999999 depending on whether Start == true or false respectively.
     * 
     * @return
     */
    public static ZonedDateTime getYesterdayTimestamp(boolean Start)
      {
        return getIthDayTimestamp(Start, -1);
      }


    /**
     * Returns a ZonedDateTime for the very beginning of tomorrow at 00:00:00:0000 or
     * 23:59:59:999999999 depending on whether Start == true or false respectively.
     * 
     * @return
     */
    public static ZonedDateTime getTomorrowTimestamp(boolean Start)
      {
        return getIthDayTimestamp(Start, 1);
      }


    /**
     * Returns a ZonedDateTime for the very beginning of the ith day from today at 00:00:00:0000 or
     * 23:59:59:999999999 depending on whether Start == true or false respectively. +1 for example gives
     * tomorrow, while -1 gets yesterday.
     * 
     * @return
     */
    public static ZonedDateTime getIthDayTimestamp(boolean Start, int i)
      {
        return getTodayTimestamp(Start).plusDays(i);
      }


    public static ZonedDateTime getThisMonthTimestamp(boolean Start)
      {
        return getTodayTimestamp(Start).with(Start == true ? TemporalAdjusters.firstDayOfMonth() : TemporalAdjusters.lastDayOfMonth());
      }

    public static ZonedDateTime getIthMonthTimestamp(boolean Start, int i)
      {
        return getTodayTimestamp(Start).plusMonths(1).with(Start == true ? TemporalAdjusters.firstDayOfMonth() : TemporalAdjusters.lastDayOfMonth());
      }

    private static Pattern _DELTA_DATETIME = Pattern.compile("(\\+|\\-)(\\d{2})y(\\d{2})m(\\d{2})d\\s([01][0-9]|2[0-4])\\:([0-5][0-9])");

    /**
     * If the string passed in is not null and of exactly 16 characters in the form of "(+|-)(\d{2})y(\d{2})m(\d{2})d\s([01][0-9]|2[0-4])\:([0-5][0-9])",
     * will return a JSON text representation of the baseTimeMarker with the delta specified by the pattern. For example if the date time passed is
     * <B>2015-02-10</B> (irrespective of the time specified)<BR>
     * <UL>
     * <LI>"-01y00m05d 10:50" -> 2014-02-05 10:50:00</LI>
     * <LI>"+00y00m04d 14:50" -> 2015-02-14 14:50:00</LI>
     * </UL>
     * 
     * @param Val
     * @param baseTimeMarker
     * @return
     */
    public static String preProcess(String Val, ZonedDateTime BaseTimeMarker)
      {
        if (Val == null || Val.length() != 16)
          return Val;

        Matcher M = _DELTA_DATETIME.matcher(Val);
        if (M.matches() == false)
          return Val;

        boolean Plus = M.group(1).equals("+");
        int years = Integer.parseInt(M.group(2));
        int months = Integer.parseInt(M.group(3));
        int days = Integer.parseInt(M.group(4));
        int hour = Integer.parseInt(M.group(5));
        int minute = Integer.parseInt(M.group(6));
        Period P = Period.of(years, months, days);
        BaseTimeMarker = Plus ? BaseTimeMarker.plus(P) : BaseTimeMarker.minus(P);
        BaseTimeMarker = BaseTimeMarker.withHour(hour).withMinute(minute);

        return printDateTimeForJSON(BaseTimeMarker, true);
      }

    public static boolean validateBoundary(TimeSeriesType Type, boolean Start, ZonedDateTime ZDT)
      {
        Month m = ZDT.getMonth();
        int d = ZDT.getDayOfMonth();
        long dMax = ZDT.range(ChronoField.DAY_OF_MONTH).getMaximum();
        switch (Type)
          {
            case YEARLY:
              return Start == true && m == Month.JANUARY && d == 1
              || Start == false && m == Month.DECEMBER && d == dMax;
            case QUARTERLY:
              return Start == true && (m == Month.JANUARY || m == Month.APRIL || m == Month.JULY || m == Month.OCTOBER) && d == 1
              || Start == false && (m == Month.MARCH || m == Month.JUNE || m == Month.SEPTEMBER || m == Month.DECEMBER) && d == dMax;
            case MONTHLY:
              return Start == true && d == 1
              || Start == false && d == dMax;
            case DAILY:
              return true;
            default:
              throw new Error("Switch statement on TimeSeriesType does not handle the case '" + Type + "'.");
          }
      }

    public static List<java.sql.Timestamp> toSQLTimeStamps(List<ZonedDateTime> L)
      {
        if (L == null)
          return null;
        List<java.sql.Timestamp> newL = new ArrayList<java.sql.Timestamp>();
        for (ZonedDateTime ZDT : L)
          {
            newL.add(ZDT == null ? null : new java.sql.Timestamp(ZDT.toInstant().toEpochMilli()));
          }
        LOG.debug("L: " + TextUtil.print(L.iterator()));
        LOG.debug("newL: " + TextUtil.print(newL.iterator()));
        return newL;
      }
  }
