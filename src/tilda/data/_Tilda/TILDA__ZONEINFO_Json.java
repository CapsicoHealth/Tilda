
package tilda.data._Tilda;

import java.io.IOException;
import java.io.Writer;
import java.time.ZonedDateTime;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.SyncStatus;
import tilda.enums.TransactionType;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings({ "unused" })
public class TILDA__ZONEINFO_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__ZONEINFO_Json.class.getName());

   protected TILDA__ZONEINFO_Json() { }

   /*@formatter:off*/
   @SerializedName("id"           ) public String  _id           ;
   @SerializedName("value"        ) public String  _value        ;
   @SerializedName("label"        ) public String  _label        ;
   /*@formatter:on*/

   public tilda.data.ZoneInfo_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_id           ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.ZONEINFO.id' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_value        ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.ZONEINFO.value' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_label        ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.ZONEINFO.label' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.ZoneInfo_Data Obj = tilda.data.ZoneInfo_Factory.Create(_id, _value, _label);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.ZoneInfo_Factory.LookupById(_id);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.ZONEINFO object.\n"+toString());
         if (_value        .equals(Obj.getValue        ()) == false)
          throw new Exception("Cannot update the invariant field 'tilda.data.TILDA.ZONEINFO.value': "+Obj.toString());
         if (_label        != null) Obj.setLabel        (_label        );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.ZONEINFO object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.ZoneInfo_Data Obj) throws Exception
    {
      if (_id           != null) Obj.setId           (_id           );
      if (_value        != null) Obj.setValue        (_value        );
      if (_label        != null) Obj.setLabel        (_label        );
    }

   public String toString()
    {
      return
             "id"           + (_id            == null ? ": NULL" : "(" + (_id            == null ? 0 : _id           .length())+"): "+_id)
         + "; value"        + (_value         == null ? ": NULL" : "(" + (_value         == null ? 0 : _value        .length())+"): "+_value)
         + "; label"        + (_label         == null ? ": NULL" : "(" + (_label         == null ? 0 : _label        .length())+"): "+(_label         == null || _label        .length() < 100 ? _label         : _label        .substring(0, 100)+"..."))
         + ";";
    }

 }
