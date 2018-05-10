
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
public class TILDA__FORMULA_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__FORMULA_Json.class.getName());

   protected TILDA__FORMULA_Json() { }

   /*@formatter:off*/
   @SerializedName("location"   ) public String  _location   ;
   @SerializedName("location2"  ) public String  _location2  ;
   @SerializedName("name"       ) public String  _name       ;
   @SerializedName("type"       ) public String  _type       ;
   @SerializedName("title"      ) public String  _title      ;
   @SerializedName("description") public String  _description;
   @SerializedName("formula"    ) public String  _formula    ;
   @SerializedName("htmlDoc"    ) public String  _htmlDoc    ;
   /*@formatter:on*/

   public tilda.data.Formula_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_location   ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Formula.location' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_location2  ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Formula.location2' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_name       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Formula.name' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_type       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Formula.type' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_title      ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Formula.title' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_description) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.Formula.description' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.Formula_Data Obj = tilda.data.Formula_Factory.Create(_location, _location2, _name, _type, _title, _description);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.Formula_Factory.LookupByFormula(_location, _name);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.Formula object.\n"+toString());
         if (_location2  .equals(Obj.getLocation2  ()) == false)
          throw new Exception("Cannot update the invariant field 'tilda.data.TILDA.Formula.location2' from '"+Obj.getLocation2()+"' to '"+_location2+"': "+Obj.toString());
         if (_type       != null) Obj.setType       (_type       );
         if (_title      != null) Obj.setTitle      (_title      );
         if (_description!= null) Obj.setDescription(_description);
         if (_formula    != null) Obj.setFormula    (_formula    );
         if (_htmlDoc    != null) Obj.setHtmlDoc    (_htmlDoc    );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.Formula object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.Formula_Data Obj) throws Exception
    {
      if (_location   != null) Obj.setLocation   (_location   );
      if (_location2  != null) Obj.setLocation2  (_location2  );
      if (_name       != null) Obj.setName       (_name       );
      if (_type       != null) Obj.setType       (_type       );
      if (_title      != null) Obj.setTitle      (_title      );
      if (_description!= null) Obj.setDescription(_description);
      if (_formula    != null) Obj.setFormula    (_formula    );
      if (_htmlDoc    != null) Obj.setHtmlDoc    (_htmlDoc    );
    }

   public String toString()
    {
      return
             "location"   + (_location    == null ? ": NULL" : "(" + (_location    == null ? 0 : _location   .length())+"): "+_location)
         + "; location2"  + (_location2   == null ? ": NULL" : "(" + (_location2   == null ? 0 : _location2  .length())+"): "+_location2)
         + "; name"       + (_name        == null ? ": NULL" : "(" + (_name        == null ? 0 : _name       .length())+"): "+_name)
         + "; type"       + (_type        == null ? ": NULL" : "(" + (_type        == null ? 0 : _type       .length())+"): "+_type)
         + "; title"      + (_title       == null ? ": NULL" : "(" + (_title       == null ? 0 : _title      .length())+"): "+(_title       == null || _title      .length() < 100 ? _title       : _title      .substring(0, 100)+"..."))
         + "; description"+ (_description == null ? ": NULL" : "(" + (_description == null ? 0 : _description.length())+"): "+(_description == null || _description.length() < 100 ? _description : _description.substring(0, 100)+"..."))
         + "; formula"    + (_formula     == null ? ": NULL" : "(" + (_formula     == null ? 0 : _formula    .length())+"): "+(_formula     == null || _formula    .length() < 100 ? _formula     : _formula    .substring(0, 100)+"..."))
         + "; htmlDoc"    + (_htmlDoc     == null ? ": NULL" : "(" + (_htmlDoc     == null ? 0 : _htmlDoc    .length())+"): "+(_htmlDoc     == null || _htmlDoc    .length() < 100 ? _htmlDoc     : _htmlDoc    .substring(0, 100)+"..."))
         + ";";
    }

 }
