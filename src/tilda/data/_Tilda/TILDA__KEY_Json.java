
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
public class TILDA__KEY_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__KEY_Json.class.getName());

   protected TILDA__KEY_Json() { }

   /*@formatter:off*/
   @SerializedName("refnum"     ) public Long  _refnum     ;
   @SerializedName("name"       ) public String  _name       ;
   @SerializedName("max"        ) public Long  _max        ;
   @SerializedName("count"      ) public Integer  _count      ;
   /*@formatter:on*/

   public tilda.data.Key_Data Write(Connection C) throws Exception
    {
      if (_refnum      == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.KEY.refnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_name       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.KEY.name' was null or empty. It's not nullable in the model.\n"+toString());
      if (_max         == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.KEY.max' was null or empty. It's not nullable in the model.\n"+toString());
      if (_count       == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.KEY.count' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.Key_Data Obj = tilda.data.Key_Factory.Create(_refnum, _name, _max, _count);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.Key_Factory.LookupByName(_name);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.KEY object.\n"+toString());
         if (_max        != null) Obj.setMax        (_max        );
         if (_count      != null) Obj.setCount      (_count      );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.KEY object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.Key_Data Obj) throws Exception
    {
      if (_refnum     != null) Obj.setRefnum     (_refnum     );
      if (_name       != null) Obj.setName       (_name       );
      if (_max        != null) Obj.setMax        (_max        );
      if (_count      != null) Obj.setCount      (_count      );
    }

   public String toString()
    {
      return
             "refnum"     + (_refnum      == null ? ": NULL" : ": " + _refnum     )
         + "; name"       + (_name        == null ? ": NULL" : "(" + (_name        == null ? 0 : _name       .length())+"): "+(_name        == null || _name       .length() < 100 ? _name        : _name       .substring(0, 100)+"..."))
         + "; max"        + (_max         == null ? ": NULL" : ": " + _max        )
         + "; count"      + (_count       == null ? ": NULL" : ": " + _count      )
         + ";";
    }

 }
