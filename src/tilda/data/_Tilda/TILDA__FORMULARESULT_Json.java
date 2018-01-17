
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


public class TILDA__FORMULARESULT_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__FORMULARESULT_Json.class.getName());

   protected TILDA__FORMULARESULT_Json() { }

   /*@formatter:off*/
   @SerializedName("formulaRefnum") public Long  _formulaRefnum;
   @SerializedName("value"        ) public String  _value        ;
   @SerializedName("description"  ) public String  _description  ;
   /*@formatter:on*/

   public tilda.data.FormulaResult_Data Write(Connection C) throws Exception
    {
      if (_formulaRefnum == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.FORMULARESULT.formulaRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_value        ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.FORMULARESULT.value' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_description  ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.FORMULARESULT.description' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.FormulaResult_Data Obj = tilda.data.FormulaResult_Factory.Create(_formulaRefnum, _value, _description);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.FormulaResult_Factory.LookupByValue(_formulaRefnum, _value);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.FORMULARESULT object.\n"+toString());
         if (_description  != null) Obj.setDescription  (_description  );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.FORMULARESULT object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.FormulaResult_Data Obj) throws Exception
    {
      if (_formulaRefnum!= null) Obj.setFormulaRefnum(_formulaRefnum);
      if (_value        != null) Obj.setValue        (_value        );
      if (_description  != null) Obj.setDescription  (_description  );
    }

   public String toString()
    {
      return
             "formulaRefnum"+ (_formulaRefnum == null ? ": NULL" : ": " + _formulaRefnum)
         + "; value"        + (_value         == null ? ": NULL" : "(" + (_value         == null ? 0 : _value        .length())+"): "+_value)
         + "; description"  + (_description   == null ? ": NULL" : "(" + (_description   == null ? 0 : _description  .length())+"): "+(_description   == null || _description  .length() < 100 ? _description   : _description  .substring(0, 100)+"..."))
         + ";";
    }

 }
