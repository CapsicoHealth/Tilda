
package tilda.data._Tilda;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings({ "unused" })
public class TILDA__CONNECTION_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__CONNECTION_Json.class.getName());

   protected TILDA__CONNECTION_Json() { }

   /*@formatter:off*/
   @SerializedName("active"     ) public Boolean  _active     ;
   @SerializedName("id"         ) public String  _id         ;
   @SerializedName("driver"     ) public String  _driver     ;
   @SerializedName("db"         ) public String  _db         ;
   @SerializedName("user"       ) public String  _user       ;
   @SerializedName("pswd"       ) public String  _pswd       ;
   @SerializedName("initial"    ) public Integer  _initial    ;
   @SerializedName("max"        ) public Integer  _max        ;
   @SerializedName("schemas"    ) public List<String>  _schemas    ;
   /*@formatter:on*/

   public tilda.data.Connection_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_id         ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Connection.id' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_driver     ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Connection.driver' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_db         ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Connection.db' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_user       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Connection.user' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_pswd       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Connection.pswd' was null or empty. It's not nullable in the model.\n"+toString());
      if (_initial     == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Connection.initial' was null or empty. It's not nullable in the model.\n"+toString());
      if (_max         == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Connection.max' was null or empty. It's not nullable in the model.\n"+toString());
      if (_schemas     == null || _schemas    .isEmpty() == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Connection.schemas' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.Connection_Data Obj = tilda.data.Connection_Factory.Create(_id, _driver, _db, _user, _pswd, _initial, _max, _schemas);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.Connection_Factory.LookupByPrimaryKey(_id);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.Connection object.\n"+toString());
         if (_active     != null) Obj.setActive     (_active     );
         if (_driver     != null) Obj.setDriver     (_driver     );
         if (_db         != null) Obj.setDb         (_db         );
         if (_user       != null) Obj.setUser       (_user       );
         if (_pswd       != null) Obj.setPswd       (_pswd       );
         if (_initial    != null) Obj.setInitial    (_initial    );
         if (_max        != null) Obj.setMax        (_max        );
         if (_schemas    != null) Obj.setSchemas    (_schemas    );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.Connection object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.Connection_Data Obj) throws Exception
    {
      if (_active     != null) Obj.setActive     (_active     );
      if (_id         != null) Obj.setId         (_id         );
      if (_driver     != null) Obj.setDriver     (_driver     );
      if (_db         != null) Obj.setDb         (_db         );
      if (_user       != null) Obj.setUser       (_user       );
      if (_pswd       != null) Obj.setPswd       (_pswd       );
      if (_initial    != null) Obj.setInitial    (_initial    );
      if (_max        != null) Obj.setMax        (_max        );
      if (_schemas    != null) Obj.setSchemas    (_schemas    );
    }

   public String toString()
    {
      return
             "active"     + (_active      == null ? ": NULL" : ": " + _active     )
         + "; id"         + (_id          == null ? ": NULL" : "(" + (_id          == null ? 0 : _id         .length())+"): "+_id)
         + "; driver"     + (_driver      == null ? ": NULL" : "(" + (_driver      == null ? 0 : _driver     .length())+"): "+_driver)
         + "; db"         + (_db          == null ? ": NULL" : "(" + (_db          == null ? 0 : _db         .length())+"): "+(_db          == null || _db         .length() < 100 ? _db          : _db         .substring(0, 100)+"..."))
         + "; user"       + (_user        == null ? ": NULL" : "(" + (_user        == null ? 0 : _user       .length())+"): "+_user)
         + "; pswd"       + (_pswd        == null ? ": NULL" : "(" + (_pswd        == null ? 0 : _pswd       .length())+"): "+_pswd)
         + "; initial"    + (_initial     == null ? ": NULL" : ": " + _initial    )
         + "; max"        + (_max         == null ? ": NULL" : ": " + _max        )
         + "; schemas"    + (_schemas     == null ? ": NULL" : ": " + _schemas    )
         + ";";
    }

 }
