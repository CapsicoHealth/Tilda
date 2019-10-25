
package tilda.data._Tilda;

import java.time.*;
import java.util.*;
import java.math.*;

import org.apache.logging.log4j.*;
import com.google.gson.annotations.*;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;
import tilda.utils.json.*;


@SuppressWarnings({ "unused" })
public class TILDA__MAINTENANCE_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__MAINTENANCE_Json.class.getName());

   protected TILDA__MAINTENANCE_Json() { }

   /*@formatter:off*/
   @SerializedName("type"       ) public String  _type       ;
   @SerializedName("name"       ) public String  _name       ;
   @SerializedName("value"      ) public String  _value      ;
   /*@formatter:on*/

   public tilda.data.Maintenance_Data write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_type       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Maintenance.type' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_name       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Maintenance.name' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.Maintenance_Data Obj = tilda.data.Maintenance_Factory.create(_type, _name);
      update(Obj);
      if (Obj.write(C) == false)
       {
         Obj = tilda.data.Maintenance_Factory.lookupByPrimaryKey(_type, _name);
         update(Obj);
         if (Obj.write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.Maintenance object: "+Obj.toString());

       }
      return Obj;
   }

   public void update(tilda.data.Maintenance_Data Obj) throws Exception
    {
      if (_type       != null) Obj.setType       (_type       );
      if (_name       != null) Obj.setName       (_name       );
      if (_value      != null) Obj.setValue      (_value      );
    }

   public String toString()
    {
      return
             "type"       + (_type        == null ? ": NULL" : "(" + (_type        == null ? 0 : _type       .length())+"): "+_type)
         + "; name"       + (_name        == null ? ": NULL" : "(" + (_name        == null ? 0 : _name       .length())+"): "+(_name        == null || _name       .length() < 100 ? _name        : _name       .substring(0, 100)+"..."))
         + "; value"      + (_value       == null ? ": NULL" : "(" + (_value       == null ? 0 : _value      .length())+"): "+(_value       == null || _value      .length() < 100 ? _value       : _value      .substring(0, 100)+"..."))
         + ";";
    }

 }
