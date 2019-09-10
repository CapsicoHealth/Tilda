
package tilda.data_test._Tilda;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;


@SuppressWarnings({ "unused" })
public class TILDA__TESTVIEW_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__TESTVIEW_Json.class.getName());

   protected TILDA__TESTVIEW_Json() { }


   public static void toJSON(java.io.Writer Out, List<tilda.data_test.TestView_Data> L, String Lead, boolean FullList) throws java.io.IOException
    {
      if (L == null || L.size() == 0) return;
      if (FullList == true)
       Out.write("[\n");
      boolean First = true;
      for (tilda.data_test.TestView_Data O : L)
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

   public static void toJSON(java.io.Writer Out, tilda.data_test.TestView_Data ObjApp, boolean FullObject) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      tilda.data_test._Tilda.TILDA__TESTVIEW Obj = (tilda.data_test._Tilda.TILDA__TESTVIEW) ObjApp;
      if (FullObject == true)
       Out.write("{");

        JSONUtil.Print(Out, "refnum", true, Obj.getRefnum());

        JSONUtil.Print(Out, "name", false, Obj.getName());

      if (FullObject == true)
       Out.write(" }");
      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
