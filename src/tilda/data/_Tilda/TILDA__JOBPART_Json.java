
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
public class TILDA__JOBPART_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__JOBPART_Json.class.getName());

   protected TILDA__JOBPART_Json() { }

   /*@formatter:off*/
   @SerializedName("jobRefnum"   ) public Long  _jobRefnum   ;
   @SerializedName("name"        ) public String  _name        ;
   @SerializedName("type"        ) public String  _type        ;
   @SerializedName("dataStart"   ) public String  Str_dataStart   ;
   transient                       public ZonedDateTime  _dataStart   ;
   @SerializedName("dataEnd"     ) public String  Str_dataEnd     ;
   transient                       public ZonedDateTime  _dataEnd     ;
   @SerializedName("start"       ) public String  Str_start       ;
   transient                       public ZonedDateTime  _start       ;
   @SerializedName("end"         ) public String  Str_end         ;
   transient                       public ZonedDateTime  _end         ;
   @SerializedName("recordsCount") public Integer  _recordsCount;
   @SerializedName("status"      ) public Boolean  _status      ;
   /*@formatter:on*/

   public tilda.data.JobPart_Data write(Connection C) throws Exception
    {
      if (_jobRefnum    == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.jobRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_name        ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.name' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_dataStart   ) == false)
       {
         _dataStart    = DateTimeUtil.parsefromJSON(Str_dataStart   );
         if (   _dataStart    == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.dataStart' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }
      if (TextUtil.isNullOrEmpty(Str_dataEnd     ) == false)
       {
         _dataEnd      = DateTimeUtil.parsefromJSON(Str_dataEnd     );
         if (   _dataEnd      == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.dataEnd' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }
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

      tilda.data.JobPart_Data Obj = tilda.data.JobPart_Factory.create(_jobRefnum, _name, _start);
      update(Obj);
      if (Obj.write(C) == false)
       {
         throw new Exception("Cannot create the tilda.data.TILDA.JobPart object.\n"+toString());
       }
      return Obj;
   }

   public void update(tilda.data.JobPart_Data Obj) throws Exception
    {
      if (_jobRefnum   != null) Obj.setJobRefnum   (_jobRefnum   );
      if (_name        != null) Obj.setName        (_name        );
      if (_type        != null) Obj.setType        (_type        );
      if (_dataStart   != null) Obj.setDataStart   (_dataStart   );
      if (_dataEnd     != null) Obj.setDataEnd     (_dataEnd     );
      if (_start       != null) Obj.setStart       (_start       );
      if (_end         != null) Obj.setEnd         (_end         );
      if (_recordsCount!= null) Obj.setRecordsCount(_recordsCount);
      if (_status      != null) Obj.setStatus      (_status      );
    }

   public String toString()
    {
      return
             "jobRefnum"   + (_jobRefnum    == null ? ": NULL" : ": " + _jobRefnum   )
         + "; name"        + (_name         == null ? ": NULL" : "(" + (_name         == null ? 0 : _name        .length())+"): "+(_name         == null || _name        .length() < 100 ? _name         : _name        .substring(0, 100)+"..."))
         + "; type"        + (_type         == null ? ": NULL" : "(" + (_type         == null ? 0 : _type        .length())+"): "+(_type         == null || _type        .length() < 100 ? _type         : _type        .substring(0, 100)+"..."))
         + "; dataStart"   + (_dataStart    == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_dataStart))
         + "; dataEnd"     + (_dataEnd      == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_dataEnd))
         + "; start"       + (_start        == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_start))
         + "; end"         + (_end          == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_end))
         + "; recordsCount"+ (_recordsCount == null ? ": NULL" : ": " + _recordsCount)
         + "; status"      + (_status       == null ? ": NULL" : ": " + _status      )
         + ";";
    }

 }
