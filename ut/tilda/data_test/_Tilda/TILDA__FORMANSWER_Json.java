
package tilda.data_test._Tilda;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings({ "unused" })
public class TILDA__FORMANSWER_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__FORMANSWER_Json.class.getName());

   protected TILDA__FORMANSWER_Json() { }

   /*@formatter:off*/
   @SerializedName("formRefnum" ) public Long  _formRefnum ;
   @SerializedName("field"      ) public String  _field      ;
   @SerializedName("value"      ) public String  _value      ;
   /*@formatter:on*/

   public tilda.data_test.FormAnswer_Data Write(Connection C) throws Exception
    {
      if (_formRefnum  == null)
       throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.FormAnswer.formRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_field      ) == true)
       throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.FormAnswer.field' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data_test.FormAnswer_Data Obj = tilda.data_test.FormAnswer_Factory.Create(_formRefnum, _field);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data_test.FormAnswer_Factory.LookupByFormAnswer(_formRefnum, _field);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data_test.TILDATEST.FormAnswer object.\n"+toString());
         if (_value      != null) Obj.setValue      (_value      );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data_test.TILDATEST.FormAnswer object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data_test.FormAnswer_Data Obj) throws Exception
    {
      if (_formRefnum != null) Obj.setFormRefnum (_formRefnum );
      if (_field      != null) Obj.setField      (_field      );
      if (_value      != null) Obj.setValue      (_value      );
    }

   public String toString()
    {
      return
             "formRefnum" + (_formRefnum  == null ? ": NULL" : ": " + _formRefnum )
         + "; field"      + (_field       == null ? ": NULL" : "(" + (_field       == null ? 0 : _field      .length())+"): "+_field)
         + "; value"      + (_value       == null ? ": NULL" : "(" + (_value       == null ? 0 : _value      .length())+"): "+(_value       == null || _value      .length() < 100 ? _value       : _value      .substring(0, 100)+"..."))
         + ";";
    }

 }
