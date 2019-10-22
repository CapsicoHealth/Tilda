
package tilda.data._Tilda;

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
public class TILDA__MEASURE_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__MEASURE_Json.class.getName());

   protected TILDA__MEASURE_Json() { }

   /*@formatter:off*/
   @SerializedName("schema"     ) public String  _schema     ;
   @SerializedName("name"       ) public String  _name       ;
   /*@formatter:on*/

   public tilda.data.Measure_Data write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_schema     ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Measure.schema' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_name       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Measure.name' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.Measure_Data Obj = tilda.data.Measure_Factory.create(_schema, _name);
      update(Obj);
      if (Obj.write(C) == false)
       {
         Obj = tilda.data.Measure_Factory.lookupByMeasure(_schema, _name);
         update(Obj);
         if (Obj.write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.Measure object: "+Obj.toString());

       }
      return Obj;
   }

   public void update(tilda.data.Measure_Data Obj) throws Exception
    {
      if (_schema     != null) Obj.setSchema     (_schema     );
      if (_name       != null) Obj.setName       (_name       );
    }

   public String toString()
    {
      return
             "schema"     + (_schema      == null ? ": NULL" : "(" + (_schema      == null ? 0 : _schema     .length())+"): "+_schema)
         + "; name"       + (_name        == null ? ": NULL" : "(" + (_name        == null ? 0 : _name       .length())+"): "+_name)
         + ";";
    }

 }
