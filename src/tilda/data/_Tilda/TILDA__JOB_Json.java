
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
   @SerializedName("type"       ) public String  _type       ;
   @SerializedName("userId"     ) public String  _userId     ;
   @SerializedName("dataStart"  ) public String  Str_dataStart  ;
   transient                      public ZonedDateTime  _dataStart  ;
   @SerializedName("dataEnd"    ) public String  Str_dataEnd    ;
   transient                      public ZonedDateTime  _dataEnd    ;
   @SerializedName("start"      ) public String  Str_start      ;
   transient                      public ZonedDateTime  _start      ;
   @SerializedName("end"        ) public String  Str_end        ;
   transient                      public ZonedDateTime  _end        ;
   @SerializedName("status"     ) public Boolean  _status     ;
   @SerializedName("msg"        ) public String  _msg        ;
   /*@formatter:on*/

   public tilda.data.Job_Data write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_name       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Job.name' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_dataStart  ) == false)
       {
         _dataStart   = DateTimeUtil.parsefromJSON(Str_dataStart  );
         if (   _dataStart   == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.Job.dataStart' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }
      if (TextUtil.isNullOrEmpty(Str_dataEnd    ) == false)
       {
         _dataEnd     = DateTimeUtil.parsefromJSON(Str_dataEnd    );
         if (   _dataEnd     == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.Job.dataEnd' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }
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

      tilda.data.Job_Data Obj = tilda.data.Job_Factory.create(_name, _start);
      update(Obj);
      if (Obj.write(C) == false)
       {
         throw new Exception("Cannot create the tilda.data.TILDA.Job object.\n"+toString());
       }
      return Obj;
   }

   public void update(tilda.data.Job_Data Obj) throws Exception
    {
      if (_name       != null) Obj.setName       (_name       );
      if (_type       != null) Obj.setType       (_type       );
      if (_userId     != null) Obj.setUserId     (_userId     );
      if (_dataStart  != null) Obj.setDataStart  (_dataStart  );
      if (_dataEnd    != null) Obj.setDataEnd    (_dataEnd    );
      if (_start      != null) Obj.setStart      (_start      );
      if (_end        != null) Obj.setEnd        (_end        );
      if (_status     != null) Obj.setStatus     (_status     );
      if (_msg        != null) Obj.setMsg        (_msg        );
    }

   public String toString()
    {
      return
             "name"       + (_name        == null ? ": NULL" : "(" + (_name        == null ? 0 : _name       .length())+"): "+(_name        == null || _name       .length() < 100 ? _name        : _name       .substring(0, 100)+"..."))
         + "; type"       + (_type        == null ? ": NULL" : "(" + (_type        == null ? 0 : _type       .length())+"): "+(_type        == null || _type       .length() < 100 ? _type        : _type       .substring(0, 100)+"..."))
         + "; userId"     + (_userId      == null ? ": NULL" : "(" + (_userId      == null ? 0 : _userId     .length())+"): "+(_userId      == null || _userId     .length() < 100 ? _userId      : _userId     .substring(0, 100)+"..."))
         + "; dataStart"  + (_dataStart   == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_dataStart))
         + "; dataEnd"    + (_dataEnd     == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_dataEnd))
         + "; start"      + (_start       == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_start))
         + "; end"        + (_end         == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_end))
         + "; status"     + (_status      == null ? ": NULL" : ": " + _status     )
         + "; msg"        + (_msg         == null ? ": NULL" : "(" + (_msg         == null ? 0 : _msg        .length())+"): "+(_msg         == null || _msg        .length() < 100 ? _msg         : _msg        .substring(0, 100)+"..."))
         + ";";
    }

 }
