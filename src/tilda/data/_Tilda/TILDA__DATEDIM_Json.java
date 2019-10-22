
package tilda.data._Tilda;

import java.time.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;
import tilda.utils.json.*;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings({ "unused" })
public class TILDA__DATEDIM_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__DATEDIM_Json.class.getName());

   protected TILDA__DATEDIM_Json() { }

   /*@formatter:off*/
   @SerializedName("dt"            ) public LocalDate  _dt            ;
   @SerializedName("epoch"         ) public Long  _epoch         ;
   @SerializedName("dayName"       ) public String  _dayName       ;
   @SerializedName("dayOfWeek"     ) public Integer  _dayOfWeek     ;
   @SerializedName("dayOfMonth"    ) public Integer  _dayOfMonth    ;
   @SerializedName("dayOfQuarter"  ) public Integer  _dayOfQuarter  ;
   @SerializedName("dayOfYear"     ) public Integer  _dayOfYear     ;
   @SerializedName("weekOfMonth"   ) public Integer  _weekOfMonth   ;
   @SerializedName("weekOfYear"    ) public Integer  _weekOfYear    ;
   @SerializedName("monthOfYear"   ) public Integer  _monthOfYear   ;
   @SerializedName("monthName"     ) public String  _monthName     ;
   @SerializedName("monthNameShort") public String  _monthNameShort;
   @SerializedName("quarterOfYear" ) public Integer  _quarterOfYear ;
   @SerializedName("quarterName"   ) public String  _quarterName   ;
   @SerializedName("year"          ) public Integer  _year          ;
   @SerializedName("mmyyyy"        ) public String  _mmyyyy        ;
   @SerializedName("mmddyyyy"      ) public String  _mmddyyyy      ;
   @SerializedName("yyyymmdd"      ) public String  _yyyymmdd      ;
   @SerializedName("isWeekend"     ) public Integer  _isWeekend     ;
   @SerializedName("isBusinessDay" ) public Integer  _isBusinessDay ;
   @SerializedName("isHoliday"     ) public Integer  _isHoliday     ;
   @SerializedName("holidayName"   ) public String  _holidayName   ;
   /*@formatter:on*/

   public tilda.data.DateDim_Data write(Connection C) throws Exception
    {
      if (_dt             == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.DateDim.dt' was null or empty. It's not nullable in the model.\n"+toString());
      if (_epoch          == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.DateDim.epoch' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.DateDim_Data Obj = tilda.data.DateDim_Factory.create(_dt, _epoch);
      update(Obj);
      if (Obj.write(C) == false)
       {
         Obj = tilda.data.DateDim_Factory.lookupByPrimaryKey(_dt);
         update(Obj);
         if (Obj.write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.DateDim object: "+Obj.toString());

       }
      return Obj;
   }

   public void update(tilda.data.DateDim_Data Obj) throws Exception
    {
      if (_dt            != null) Obj.setDt            (_dt            );
      if (_epoch         != null) Obj.setEpoch         (_epoch         );
      if (_dayName       != null) Obj.setDayName       (_dayName       );
      if (_dayOfWeek     != null) Obj.setDayOfWeek     (_dayOfWeek     );
      if (_dayOfMonth    != null) Obj.setDayOfMonth    (_dayOfMonth    );
      if (_dayOfQuarter  != null) Obj.setDayOfQuarter  (_dayOfQuarter  );
      if (_dayOfYear     != null) Obj.setDayOfYear     (_dayOfYear     );
      if (_weekOfMonth   != null) Obj.setWeekOfMonth   (_weekOfMonth   );
      if (_weekOfYear    != null) Obj.setWeekOfYear    (_weekOfYear    );
      if (_monthOfYear   != null) Obj.setMonthOfYear   (_monthOfYear   );
      if (_monthName     != null) Obj.setMonthName     (_monthName     );
      if (_monthNameShort!= null) Obj.setMonthNameShort(_monthNameShort);
      if (_quarterOfYear != null) Obj.setQuarterOfYear (_quarterOfYear );
      if (_quarterName   != null) Obj.setQuarterName   (_quarterName   );
      if (_year          != null) Obj.setYear          (_year          );
      if (_mmyyyy        != null) Obj.setMmyyyy        (_mmyyyy        );
      if (_mmddyyyy      != null) Obj.setMmddyyyy      (_mmddyyyy      );
      if (_yyyymmdd      != null) Obj.setYyyymmdd      (_yyyymmdd      );
      if (_isWeekend     != null) Obj.setIsWeekend     (_isWeekend     );
      if (_isBusinessDay != null) Obj.setIsBusinessDay (_isBusinessDay );
      if (_isHoliday     != null) Obj.setIsHoliday     (_isHoliday     );
      if (_holidayName   != null) Obj.setHolidayName   (_holidayName   );
    }

   public String toString()
    {
      return
             "dt"            + (_dt             == null ? ": NULL" : ": " + _dt            )
         + "; epoch"         + (_epoch          == null ? ": NULL" : ": " + _epoch         )
         + "; dayName"       + (_dayName        == null ? ": NULL" : "(" + (_dayName        == null ? 0 : _dayName       .length())+"): "+(_dayName        == null || _dayName       .length() < 100 ? _dayName        : _dayName       .substring(0, 100)+"..."))
         + "; dayOfWeek"     + (_dayOfWeek      == null ? ": NULL" : ": " + _dayOfWeek     )
         + "; dayOfMonth"    + (_dayOfMonth     == null ? ": NULL" : ": " + _dayOfMonth    )
         + "; dayOfQuarter"  + (_dayOfQuarter   == null ? ": NULL" : ": " + _dayOfQuarter  )
         + "; dayOfYear"     + (_dayOfYear      == null ? ": NULL" : ": " + _dayOfYear     )
         + "; weekOfMonth"   + (_weekOfMonth    == null ? ": NULL" : ": " + _weekOfMonth   )
         + "; weekOfYear"    + (_weekOfYear     == null ? ": NULL" : ": " + _weekOfYear    )
         + "; monthOfYear"   + (_monthOfYear    == null ? ": NULL" : ": " + _monthOfYear   )
         + "; monthName"     + (_monthName      == null ? ": NULL" : "(" + (_monthName      == null ? 0 : _monthName     .length())+"): "+(_monthName      == null || _monthName     .length() < 100 ? _monthName      : _monthName     .substring(0, 100)+"..."))
         + "; monthNameShort"+ (_monthNameShort == null ? ": NULL" : "(" + (_monthNameShort == null ? 0 : _monthNameShort.length())+"): "+(_monthNameShort == null || _monthNameShort.length() < 100 ? _monthNameShort : _monthNameShort.substring(0, 100)+"..."))
         + "; quarterOfYear" + (_quarterOfYear  == null ? ": NULL" : ": " + _quarterOfYear )
         + "; quarterName"   + (_quarterName    == null ? ": NULL" : "(" + (_quarterName    == null ? 0 : _quarterName   .length())+"): "+(_quarterName    == null || _quarterName   .length() < 100 ? _quarterName    : _quarterName   .substring(0, 100)+"..."))
         + "; year"          + (_year           == null ? ": NULL" : ": " + _year          )
         + "; mmyyyy"        + (_mmyyyy         == null ? ": NULL" : "(" + (_mmyyyy         == null ? 0 : _mmyyyy        .length())+"): "+_mmyyyy)
         + "; mmddyyyy"      + (_mmddyyyy       == null ? ": NULL" : "(" + (_mmddyyyy       == null ? 0 : _mmddyyyy      .length())+"): "+_mmddyyyy)
         + "; yyyymmdd"      + (_yyyymmdd       == null ? ": NULL" : "(" + (_yyyymmdd       == null ? 0 : _yyyymmdd      .length())+"): "+_yyyymmdd)
         + "; isWeekend"     + (_isWeekend      == null ? ": NULL" : ": " + _isWeekend     )
         + "; isBusinessDay" + (_isBusinessDay  == null ? ": NULL" : ": " + _isBusinessDay )
         + "; isHoliday"     + (_isHoliday      == null ? ": NULL" : ": " + _isHoliday     )
         + "; holidayName"   + (_holidayName    == null ? ": NULL" : "(" + (_holidayName    == null ? 0 : _holidayName   .length())+"): "+(_holidayName    == null || _holidayName   .length() < 100 ? _holidayName    : _holidayName   .substring(0, 100)+"..."))
         + ";";
    }

 }
