
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
public class TILDA__JOB_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__JOB_Json.class.getName());

   protected TILDA__JOB_Json() { }

   /*@formatter:off*/
   @SerializedName("name"       ) public String  _name       ;
   @SerializedName("start"      ) public String  Str_start      ;
   transient                      public ZonedDateTime  _start      ;
   @SerializedName("end"        ) public String  Str_end        ;
   transient                      public ZonedDateTime  _end        ;
   @SerializedName("status"     ) public Boolean  _status     ;
   @SerializedName("msg"        ) public String  _msg        ;
   /*@formatter:on*/

   public tilda.data.Job_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_name       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Job.name' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_start      ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Job.start' was null or empty. It's not nullable in the model.\n"+toString());
      _start       = DateTimeUtil.parsefromJSON(Str_start      );
      if (   _start       == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Job.start' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_end        ) == false)
       {
         _end         = DateTimeUtil.parsefromJSON(Str_end        );
         if (   _end         == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.Job.end' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }

      tilda.data.Job_Data Obj = tilda.data.Job_Factory.Create(_name, _start);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         throw new Exception("Cannot create the tilda.data.TILDA.Job object.\n"+toString());
       }
      return Obj;
   }

   public void Update(tilda.data.Job_Data Obj) throws Exception
    {
      if (_name       != null) Obj.setName       (_name       );
      if (_start      != null) Obj.setStart      (_start      );
      if (_end        != null) Obj.setEnd        (_end        );
      if (_status     != null) Obj.setStatus     (_status     );
      if (_msg        != null) Obj.setMsg        (_msg        );
    }

   public String toString()
    {
      return
             "name"       + (_name        == null ? ": NULL" : "(" + (_name        == null ? 0 : _name       .length())+"): "+(_name        == null || _name       .length() < 100 ? _name        : _name       .substring(0, 100)+"..."))
         + "; start"      + (_start       == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_start))
         + "; end"        + (_end         == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_end))
         + "; status"     + (_status      == null ? ": NULL" : ": " + _status     )
         + "; msg"        + (_msg         == null ? ": NULL" : "(" + (_msg         == null ? 0 : _msg        .length())+"): "+(_msg         == null || _msg        .length() < 100 ? _msg         : _msg        .substring(0, 100)+"..."))
         + ";";
    }

 }
