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

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class DurationUtil
  {
    public static final long      MILLISECS_PER_SECOND     = 1000;
    public static final long      MILLISECS_PER_MINUTE     = 60 * MILLISECS_PER_SECOND;
    public static final long      MILLISECS_PER_HOUR       = 60 * MILLISECS_PER_MINUTE;
    public static final long      MILLISECS_PER_DAY        = 24 * MILLISECS_PER_HOUR;

    public static final long      NANOSECS_PER_MILLISECOND = 1000000;
    public static final long      NANOSECS_PER_SECOND      = MILLISECS_PER_SECOND * NANOSECS_PER_MILLISECOND;
    public static final long      NANOSECS_PER_MINUTE      = MILLISECS_PER_MINUTE * NANOSECS_PER_MILLISECOND;
    public static final long      NANOSECS_PER_HOUR        = MILLISECS_PER_HOUR * NANOSECS_PER_MILLISECOND;
    public static final long      NANOSECS_PER_DAY         = MILLISECS_PER_DAY * NANOSECS_PER_MILLISECOND;
    
    public static enum IntervalEnum
      {
        YEARS, MONTHS, DAYS, HOURS, MINUTES, SECONDS
      }
    


    static protected NumberFormat F1                       = new DecimalFormat("###,###.00");

    public static String printDurationMilliSeconds(long NanoSeconds)
      {
        return F1.format(NanoSeconds / NANOSECS_PER_MILLISECOND) + "ms";
      }

    public static String printDurationSeconds(long NanoSeconds)
      {
        return F1.format(NanoSeconds / NANOSECS_PER_SECOND) + "s";
      }

    public static String printDurationMinutes(long NanoSeconds)
      {
        return F1.format(NanoSeconds / NANOSECS_PER_MINUTE) + "mn";
      }

    public static String printDurationHours(long NanoSeconds)
      {
        return F1.format(NanoSeconds / NANOSECS_PER_HOUR) + "h";
      }

    public static double getDurationSeconds(long NanoSeconds)
      {
        return 1.0 * NanoSeconds / NANOSECS_PER_SECOND;
      }

    public static double getDurationMinutes(long NanoSeconds)
      {
        return 1.0 * NanoSeconds / NANOSECS_PER_MINUTE;
      }

    public static String printDuration(long NanoSeconds)
      {
        long d = (long) Math.floor(NanoSeconds / (24 * 60 * 60 * 1000000000.0));
        NanoSeconds -= d * 24 * 60 * 60 * 1000000000;
        long h = (long) Math.floor(NanoSeconds / (60 * 60 * 1000000000.0));
        NanoSeconds -= h * 60 * 60 * 1000000000;
        long mn = (long) Math.floor(NanoSeconds / (60 * 1000000000.0));
        NanoSeconds -= mn * 60 * 1000000000;
        long s = (long) Math.floor(NanoSeconds / 1000000000.0);
        NanoSeconds -= s * 1000000000;
        long ms = NanoSeconds / 1000000;
        
        StringBuilder Str = new StringBuilder();
        if (d != 0)
          Str.append(d).append("d");
        if (h != 0 || Str.length() != 0)
          Str.append(Str.length() != 0 ? " " : "").append(h).append("h");
        if (mn != 0 || Str.length() != 0)
          Str.append(Str.length() != 0 ? " " : "").append(mn).append("mn");
        if (s != 0 || Str.length() != 0)
          Str.append(Str.length() != 0 ? " " : "").append(s).append("s");
        if (ms != 0)
          Str.append(Str.length() != 0 ? " " : "").append(ms).append("ms");
        
        return Str.length() > 0 ? Str.toString() : "0ms";
      }

    /**
     * Given a length of elapsed time represented in ms, convert to a
     * user friendly translation into [days] [hours] [minutes] seconds 
     * (minutes, hours and days only printed if necessary)
     */
    public static String printDurationConciseFromMs(long MilliSeconds)
      {
        int d = (int) Math.floor(MilliSeconds / (24 * 60 * 60 * 1000.0));
        MilliSeconds -= d * 24 * 60 * 60 * 1000;
        int h = (int) Math.floor(MilliSeconds / (60 * 60 * 1000.0));
        MilliSeconds -= h * 60 * 60 * 1000;
        int mn = (int) Math.floor(MilliSeconds / (60 * 1000.0));
        MilliSeconds -= mn * 60 * 1000;
        int s = (int) Math.round(MilliSeconds/1000.0);

        StringBuilder Str = new StringBuilder();
        if (d != 0)
          Str.append(d).append("d");
        if (h != 0)
          Str.append(Str.length() != 0 ? " " : "").append(h).append("h");
        if (mn != 0 || Str.length() == 0)
          Str.append(Str.length() != 0 ? " " : "").append(mn).append("mn");
        
        Str.append(Str.length() != 0 ? " " : "").append(s).append("s");

        return Str.toString();
      }
    
    
    public static String printPerformancePerSecond(long DurationNano, double Count)
      {
        return NumberFormatUtil.printWith2DecAnd000Sep(1000000000.0 * Count / DurationNano);
      }

    public static String printPerformancePerMinute(long DurationNano, double Count)
      {
        return NumberFormatUtil.printWith2DecAnd000Sep(60 * 1000000000.0 * Count / DurationNano);
      }

    public static String printPerformancePerHour(long DurationNano, double Count)
      {
        return NumberFormatUtil.printWith2DecAnd000Sep(60 * 60 * 1000000000.0 * Count / DurationNano);
      }

    public static String printPerformancePerDay(long DurationNano, double Count)
      {
        return NumberFormatUtil.printWith2DecAnd000Sep(24 * 60 * 60 * 1000000000.0 * Count / DurationNano);
      }

    public static String printExpectedRemainingTimeInMinutes(long DurationNano, int Count, int Total)
      {
        return NumberFormatUtil.printWith2DecAnd000Sep((Total - Count) / (60 * 1000000000.0 * Count / DurationNano));
      }
    
    
//    /**
//     * Start and end must not be null.
//     * 
//     * @param Start
//     * @param End
//     * @return
//     */
//    public static int numberOfDays(Calendar Start, Calendar End)
//      {
//        if (Start == null || End == null)
//          return -1;
//        Start = (Calendar) Start.clone();
//        Start.set(Calendar.HOUR_OF_DAY, 0);
//        Start.set(Calendar.MINUTE, 0);
//        Start.set(Calendar.SECOND, 0);
//        Start.set(Calendar.MILLISECOND, 0);
//        End = (Calendar) End.clone();
//        End.set(Calendar.HOUR_OF_DAY, 0);
//        End.set(Calendar.MINUTE, 0);
//        End.set(Calendar.SECOND, 0);
//        End.set(Calendar.MILLISECOND, 0);
//
//        long startL = Start.getTimeInMillis() + Start.getTimeZone().getOffset(Start.getTimeInMillis());
//        long endL = End.getTimeInMillis() + End.getTimeZone().getOffset(End.getTimeInMillis());
//        return (int) ((endL - startL) / MILLISECS_PER_DAY) + 1;
//      }

//    public static int numberOfHours(Calendar Start, Calendar End)
//      {
//        long startL = Start.getTimeInMillis() + Start.getTimeZone().getOffset(Start.getTimeInMillis());
//        long endL = End.getTimeInMillis() + End.getTimeZone().getOffset(End.getTimeInMillis());
//        return (int) ((endL - startL) / MILLISECS_PER_HOUR);
//      }

//    public static int numberOfMinutes(Calendar Start, Calendar End)
//      {
//        long startL = Start.getTimeInMillis() + Start.getTimeZone().getOffset(Start.getTimeInMillis());
//        long endL = End.getTimeInMillis() + End.getTimeZone().getOffset(End.getTimeInMillis());
//        return (int) ((endL - startL) / MILLISECS_PER_MINUTE);
//      }
    
    public static double perSecond(long DurationNano, int Count)
      {
        return 1.0 * NANOSECS_PER_SECOND * Count / DurationNano;
      }

    public static double perMinute(long DurationNano, int Count)
      {
        return 1.0 * NANOSECS_PER_MINUTE * Count / DurationNano;
      }

    public static double perHour(long DurationNano, int Count)
      {
        return 1.0 * NANOSECS_PER_HOUR * Count / DurationNano;
      }

    public static long getDurationNano(Calendar Start, Calendar End)
      {
        return (End.getTimeInMillis() - Start.getTimeInMillis()) * NANOSECS_PER_MILLISECOND;
      }

    public static long getDurationMillis(ZonedDateTime Start, ZonedDateTime End)
      {
        return (End.toEpochSecond() - Start.toEpochSecond())*1000;
      }
  }
