
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
public class TILDA__TEST2_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__TEST2_Json.class.getName());

   protected TILDA__TEST2_Json() { }

   /*@formatter:off*/
   @SerializedName("name"       ) public String  _name       ;
   @SerializedName("test_fk"    ) public Long  _test_fk    ;
   /*@formatter:on*/

   public tilda.data_test.Test2_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_name       ) == true)
       throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Test2.name' was null or empty. It's not nullable in the model.\n"+toString());
      if (_test_fk     == null)
       throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Test2.test_fk' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data_test.Test2_Data Obj = tilda.data_test.Test2_Factory.Create(_name, _test_fk);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data_test.Test2_Factory.LookupByName(_name);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data_test.TILDATEST.Test2 object.\n"+toString());
         if (_test_fk    != Obj.getTest_fk    ())
          throw new Exception("Cannot update the invariant field 'tilda.data_test.TILDATEST.Test2.test_fk' from '"+Obj.getTest_fk()+"' to '"+_test_fk+"': "+Obj.toString());
         LOG.debug("Nothing has changed in the object, so no update necessary.");

       }
      return Obj;
   }

   public void Update(tilda.data_test.Test2_Data Obj) throws Exception
    {
      if (_name       != null) Obj.setName       (_name       );
      if (_test_fk    != null) Obj.setTest_fk    (_test_fk    );
    }

   public String toString()
    {
      return
             "name"       + (_name        == null ? ": NULL" : "(" + (_name        == null ? 0 : _name       .length())+"): "+(_name        == null || _name       .length() < 100 ? _name        : _name       .substring(0, 100)+"..."))
         + "; test_fk"    + (_test_fk     == null ? ": NULL" : ": " + _test_fk    )
         + ";";
    }

   public static void toJSON(java.io.Writer Out, List<tilda.data_test.Test2_Data> L, String Lead, boolean FullList) throws java.io.IOException
    {
      if (L == null || L.size() == 0) return;
      if (FullList == true)
       Out.write("[\n");
      boolean First = true;
      for (tilda.data_test.Test2_Data O : L)
       if (O!=null)
        {
          Out.write(Lead);
          if (First == false) Out.write(","); else { Out.write(" "); First = false; }
          toJSON(Out, O, true);
          Out.write("\n");
        }
      if (FullList == true)
       { 
          Out.write(Lead);
          Out.write("]\n");
       } 
    }

   public static void toJSON(java.io.Writer Out, tilda.data_test.Test2_Data ObjApp, boolean FullObject) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      tilda.data_test._Tilda.TILDA__TEST2 Obj = (tilda.data_test._Tilda.TILDA__TEST2) ObjApp;
      if (FullObject == true)
       Out.write("{");

        JSONUtil.Print(Out, "refnum", true, Obj.getRefnum());

        JSONUtil.Print(Out, "name", false, Obj.getName());

      if (FullObject == true)
       Out.write(" }");
      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
