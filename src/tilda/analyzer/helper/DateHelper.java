package tilda.analyzer.helper;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper
  {
    private static transient final String Formatter = "yyyy-MM-dd HH:mm:ss";
    private static transient final String TimezoneId = "US/Eastern";
    
    
    public static String getTimeNow()
    {
      ZonedDateTime ZDT1 = ZonedDateTime.now(ZoneId.of(TimezoneId));
      return ZDT1.format(DateTimeFormatter.ofPattern(Formatter));
    }
    
  }
