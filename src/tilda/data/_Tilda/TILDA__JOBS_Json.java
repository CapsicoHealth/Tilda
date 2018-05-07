
package tilda.data._Tilda;

import java.io.*;
import java.time.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;


public class TILDA__JOBS_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__JOBS_Json.class.getName());

   protected TILDA__JOBS_Json() { }

   /*@formatter:off*/
   @SerializedName("Id"          ) public Integer  _Id          ;
   @SerializedName("Name"        ) public String  _Name        ;
   @SerializedName("StartTime"   ) public String  Str_StartTime   ;
   transient                       public ZonedDateTime  _StartTime   ;
   @SerializedName("EndTime"     ) public String  Str_EndTime     ;
   transient                       public ZonedDateTime  _EndTime     ;
   @SerializedName("TotalRecords") public Integer  _TotalRecords;
   @SerializedName("Status"      ) public String  _Status      ;
   @SerializedName("Error"       ) public String  _Error       ;
   /*@formatter:on*/

   public tilda.data.Jobs_Data Write(Connection C) throws Exception
    {
      if (_Id           == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Jobs.Id' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_StartTime   ) == false)
       {
         _StartTime    = DateTimeUtil.parsefromJSON(Str_StartTime   );
         if (   _StartTime    == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.Jobs.StartTime' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }
      if (TextUtil.isNullOrEmpty(Str_EndTime     ) == false)
       {
         _EndTime      = DateTimeUtil.parsefromJSON(Str_EndTime     );
         if (   _EndTime      == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.Jobs.EndTime' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }

      tilda.data.Jobs_Data Obj = tilda.data.Jobs_Factory.Create(_Id);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.Jobs_Factory.LookupByJob_Id(_Id);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.Jobs object.\n"+toString());
         if (_Name        != null) Obj.setName        (_Name        );
         if (_StartTime   != null) Obj.setStartTime   (_StartTime   );
         if (_EndTime     != null) Obj.setEndTime     (_EndTime     );
         if (_TotalRecords!= null) Obj.setTotalRecords(_TotalRecords);
         if (_Status      != null) Obj.setStatus      (_Status      );
         if (_Error       != null) Obj.setError       (_Error       );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.Jobs object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.Jobs_Data Obj) throws Exception
    {
      if (_Id          != null) Obj.setId          (_Id          );
      if (_Name        != null) Obj.setName        (_Name        );
      if (_StartTime   != null) Obj.setStartTime   (_StartTime   );
      if (_EndTime     != null) Obj.setEndTime     (_EndTime     );
      if (_TotalRecords!= null) Obj.setTotalRecords(_TotalRecords);
      if (_Status      != null) Obj.setStatus      (_Status      );
      if (_Error       != null) Obj.setError       (_Error       );
    }

   public String toString()
    {
      return
             "Id"          + (_Id           == null ? ": NULL" : ": " + _Id          )
         + "; Name"        + (_Name         == null ? ": NULL" : "(" + (_Name         == null ? 0 : _Name        .length())+"): "+(_Name         == null || _Name        .length() < 100 ? _Name         : _Name        .substring(0, 100)+"..."))
         + "; StartTime"   + (_StartTime    == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_StartTime))
         + "; EndTime"     + (_EndTime      == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_EndTime))
         + "; TotalRecords"+ (_TotalRecords == null ? ": NULL" : ": " + _TotalRecords)
         + "; Status"      + (_Status       == null ? ": NULL" : "(" + (_Status       == null ? 0 : _Status      .length())+"): "+(_Status       == null || _Status      .length() < 100 ? _Status       : _Status      .substring(0, 100)+"..."))
         + "; Error"       + (_Error        == null ? ": NULL" : "(" + (_Error        == null ? 0 : _Error       .length())+"): "+(_Error        == null || _Error       .length() < 100 ? _Error        : _Error       .substring(0, 100)+"..."))
         + ";";
    }

 }
