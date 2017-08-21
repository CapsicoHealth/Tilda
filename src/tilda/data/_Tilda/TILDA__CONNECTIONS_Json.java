
package tilda.data._Tilda;

import java.io.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;


public class TILDA__CONNECTIONS_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__CONNECTIONS_Json.class.getName());

   protected TILDA__CONNECTIONS_Json() { }

   /*@formatter:off*/
   @SerializedName("id"         ) public String  _id         ;
   @SerializedName("driver"     ) public String  _driver     ;
   @SerializedName("db"         ) public String  _db         ;
   @SerializedName("user"       ) public String  _user       ;
   @SerializedName("pswd"       ) public String  _pswd       ;
   @SerializedName("initial"    ) public Integer  _initial    ;
   @SerializedName("max"        ) public Integer  _max        ;
   @SerializedName("schemas"    ) public List<String>  _schemas    ;
   /*@formatter:on*/

   public tilda.data.Connections_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_id         ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.CONNECTIONS.id' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_driver     ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.CONNECTIONS.driver' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_db         ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.CONNECTIONS.db' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_user       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.CONNECTIONS.user' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_pswd       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.CONNECTIONS.pswd' was null or empty. It's not nullable in the model.\n"+toString());
      if (_initial     == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.CONNECTIONS.initial' was null or empty. It's not nullable in the model.\n"+toString());
      if (_max         == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.CONNECTIONS.max' was null or empty. It's not nullable in the model.\n"+toString());
      if (_schemas     == null || _schemas    .isEmpty() == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.CONNECTIONS.schemas' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.Connections_Data Obj = tilda.data.Connections_Factory.Create(_id, _driver, _db, _user, _pswd, _initial, _max, _schemas);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.Connections_Factory.LookupByPrimaryKey(_id);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.CONNECTIONS object.\n"+toString());
         if (_driver     != null) Obj.setDriver     (_driver     );
         if (_db         != null) Obj.setDb         (_db         );
         if (_user       != null) Obj.setUser       (_user       );
         if (_pswd       != null) Obj.setPswd       (_pswd       );
         if (_initial    != null) Obj.setInitial    (_initial    );
         if (_max        != null) Obj.setMax        (_max        );
         if (_schemas    != null) Obj.setSchemas    (_schemas    );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.CONNECTIONS object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.Connections_Data Obj) throws Exception
    {
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
             "id"         + (_id          == null ? ": NULL" : "(" + (_id          == null ? 0 : _id         .length())+"): "+_id)
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
