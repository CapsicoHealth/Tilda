
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
public class TILDA__MAPPING_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__MAPPING_Json.class.getName());

   protected TILDA__MAPPING_Json() { }

   /*@formatter:off*/
   @SerializedName("type"       ) public String  _type       ;
   @SerializedName("src"        ) public String  _src        ;
   @SerializedName("dst"        ) public String  _dst        ;
   /*@formatter:on*/

   public tilda.data.Mapping_Data write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_type       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Mapping.type' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_src        ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Mapping.src' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_dst        ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Mapping.dst' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.Mapping_Data Obj = tilda.data.Mapping_Factory.create(_type, _src, _dst);
      update(Obj);
      if (Obj.write(C) == false)
       {
         Obj = tilda.data.Mapping_Factory.lookupByTypeSrcDst(_type, _src, _dst);
         update(Obj);
         if (Obj.write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.Mapping object: "+Obj.toString());

       }
      return Obj;
   }

   public void update(tilda.data.Mapping_Data Obj) throws Exception
    {
      if (_type       != null) Obj.setType       (_type       );
      if (_src        != null) Obj.setSrc        (_src        );
      if (_dst        != null) Obj.setDst        (_dst        );
    }

   public String toString()
    {
      return
             "type"       + (_type        == null ? ": NULL" : "(" + (_type        == null ? 0 : _type       .length())+"): "+_type)
         + "; src"        + (_src         == null ? ": NULL" : "(" + (_src         == null ? 0 : _src        .length())+"): "+(_src         == null || _src        .length() < 100 ? _src         : _src        .substring(0, 100)+"..."))
         + "; dst"        + (_dst         == null ? ": NULL" : "(" + (_dst         == null ? 0 : _dst        .length())+"): "+(_dst         == null || _dst        .length() < 100 ? _dst         : _dst        .substring(0, 100)+"..."))
         + ";";
    }

 }
