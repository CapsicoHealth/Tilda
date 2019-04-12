
package tilda.data._Tilda;

import java.time.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings({ "unused" })
public class TILDA__JOBPART_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__JOBPART_Json.class.getName());

   protected TILDA__JOBPART_Json() { }

   /*@formatter:off*/
   @SerializedName("jobRefnum"   ) public Long  _jobRefnum   ;
   @SerializedName("name"        ) public String  _name        ;
   @SerializedName("start"       ) public String  Str_start       ;
   transient                       public ZonedDateTime  _start       ;
   @SerializedName("end"         ) public String  Str_end         ;
   transient                       public ZonedDateTime  _end         ;
   @SerializedName("recordsCount") public Integer  _recordsCount;
   @SerializedName("status"      ) public Boolean  _status      ;
   @SerializedName("msg"         ) public String  _msg         ;
   /*@formatter:on*/

   public tilda.data.JobPart_Data Write(Connection C) throws Exception
    {
      if (_jobRefnum    == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.jobRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_name        ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.name' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_start       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.start' was null or empty. It's not nullable in the model.\n"+toString());
      _start        = DateTimeUtil.parsefromJSON(Str_start       );
      if (   _start        == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.start' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_end         ) == false)
       {
         _end          = DateTimeUtil.parsefromJSON(Str_end         );
         if (   _end          == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.end' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }

      tilda.data.JobPart_Data Obj = tilda.data.JobPart_Factory.Create(_jobRefnum, _name, _start);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         throw new Exception("Cannot create the tilda.data.TILDA.JobPart object.\n"+toString());
       }
      return Obj;
   }

   public void Update(tilda.data.JobPart_Data Obj) throws Exception
    {
      if (_jobRefnum   != null) Obj.setJobRefnum   (_jobRefnum   );
      if (_name        != null) Obj.setName        (_name        );
      if (_start       != null) Obj.setStart       (_start       );
      if (_end         != null) Obj.setEnd         (_end         );
      if (_recordsCount!= null) Obj.setRecordsCount(_recordsCount);
      if (_status      != null) Obj.setStatus      (_status      );
      if (_msg         != null) Obj.setMsg         (_msg         );
    }

   public String toString()
    {
      return
             "jobRefnum"   + (_jobRefnum    == null ? ": NULL" : ": " + _jobRefnum   )
         + "; name"        + (_name         == null ? ": NULL" : "(" + (_name         == null ? 0 : _name        .length())+"): "+(_name         == null || _name        .length() < 100 ? _name         : _name        .substring(0, 100)+"..."))
         + "; start"       + (_start        == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_start))
         + "; end"         + (_end          == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_end))
         + "; recordsCount"+ (_recordsCount == null ? ": NULL" : ": " + _recordsCount)
         + "; status"      + (_status       == null ? ": NULL" : ": " + _status      )
         + "; msg"         + (_msg          == null ? ": NULL" : "(" + (_msg          == null ? 0 : _msg         .length())+"): "+(_msg          == null || _msg         .length() < 100 ? _msg          : _msg         .substring(0, 100)+"..."))
         + ";";
    }

 }
