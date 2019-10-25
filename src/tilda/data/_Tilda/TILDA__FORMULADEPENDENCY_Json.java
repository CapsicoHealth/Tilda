
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
public class TILDA__FORMULADEPENDENCY_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__FORMULADEPENDENCY_Json.class.getName());

   protected TILDA__FORMULADEPENDENCY_Json() { }

   /*@formatter:off*/
   @SerializedName("formulaRefnum"   ) public Long  _formulaRefnum   ;
   @SerializedName("dependencyRefnum") public Long  _dependencyRefnum;
   /*@formatter:on*/

   public tilda.data.FormulaDependency_Data write(Connection C) throws Exception
    {
      if (_formulaRefnum    == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.FormulaDependency.formulaRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (_dependencyRefnum == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.FormulaDependency.dependencyRefnum' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.FormulaDependency_Data Obj = tilda.data.FormulaDependency_Factory.create(_formulaRefnum, _dependencyRefnum);
      update(Obj);
      if (Obj.write(C) == false)
       {
         Obj = tilda.data.FormulaDependency_Factory.lookupByPrimaryKey(_formulaRefnum, _dependencyRefnum);
         update(Obj);
         if (Obj.write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.FormulaDependency object: "+Obj.toString());

       }
      return Obj;
   }

   public void update(tilda.data.FormulaDependency_Data Obj) throws Exception
    {
      if (_formulaRefnum   != null) Obj.setFormulaRefnum   (_formulaRefnum   );
      if (_dependencyRefnum!= null) Obj.setDependencyRefnum(_dependencyRefnum);
    }

   public String toString()
    {
      return
             "formulaRefnum"   + (_formulaRefnum    == null ? ": NULL" : ": " + _formulaRefnum   )
         + "; dependencyRefnum"+ (_dependencyRefnum == null ? ": NULL" : ": " + _dependencyRefnum)
         + ";";
    }

 }
