
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
public class TILDA__FORMULADEPENDENCY_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__FORMULADEPENDENCY_Json.class.getName());

   protected TILDA__FORMULADEPENDENCY_Json() { }

   /*@formatter:off*/
   @SerializedName("formulaRefnum"   ) public Long  _formulaRefnum   ;
   @SerializedName("dependencyRefnum") public Long  _dependencyRefnum;
   /*@formatter:on*/

   public tilda.data.FormulaDependency_Data Write(Connection C) throws Exception
    {
      if (_formulaRefnum    == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.FormulaDependency.formulaRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (_dependencyRefnum == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.FormulaDependency.dependencyRefnum' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.FormulaDependency_Data Obj = tilda.data.FormulaDependency_Factory.Create(_formulaRefnum, _dependencyRefnum);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.FormulaDependency_Factory.LookupByPrimaryKey(_formulaRefnum, _dependencyRefnum);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.FormulaDependency object.\n"+toString());
         LOG.debug("Nothing has changed in the object, so no update necessary.");

       }
      return Obj;
   }

   public void Update(tilda.data.FormulaDependency_Data Obj) throws Exception
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
