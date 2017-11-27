
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


public class TILDA__JOBMESSAGE_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__JOBMESSAGE_Json.class.getName());

   protected TILDA__JOBMESSAGE_Json() { }

   /*@formatter:off*/
   @SerializedName("jobRefnum"    ) public Long  _jobRefnum    ;
   @SerializedName("jobFileRefnum") public Long  _jobFileRefnum;
   @SerializedName("message"      ) public String  _message      ;
   @SerializedName("isError"      ) public Boolean  _isError      ;
   /*@formatter:on*/

   public tilda.data.JobMessage_Data Write(Connection C) throws Exception
    {
      if (_jobRefnum     == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOBMESSAGE.jobRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (_jobFileRefnum == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOBMESSAGE.jobFileRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_message      ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOBMESSAGE.message' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.JobMessage_Data Obj = tilda.data.JobMessage_Factory.Create(_jobRefnum, _jobFileRefnum, _message);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         throw new Exception("Cannot create the tilda.data.TILDA.JOBMESSAGE object.\n"+toString());
       }
      return Obj;
   }

   public void Update(tilda.data.JobMessage_Data Obj) throws Exception
    {
      if (_jobRefnum    != null) Obj.setJobRefnum    (_jobRefnum    );
      if (_jobFileRefnum!= null) Obj.setJobFileRefnum(_jobFileRefnum);
      if (_message      != null) Obj.setMessage      (_message      );
      if (_isError      != null) Obj.setIsError      (_isError      );
    }

   public String toString()
    {
      return
             "jobRefnum"    + (_jobRefnum     == null ? ": NULL" : ": " + _jobRefnum    )
         + "; jobFileRefnum"+ (_jobFileRefnum == null ? ": NULL" : ": " + _jobFileRefnum)
         + "; message"      + (_message       == null ? ": NULL" : "(" + (_message       == null ? 0 : _message      .length())+"): "+(_message       == null || _message      .length() < 100 ? _message       : _message      .substring(0, 100)+"..."))
         + "; isError"      + (_isError       == null ? ": NULL" : ": " + _isError      )
         + ";";
    }

   public static void toJSON(Writer Out, List<tilda.data.JobMessage_Data> L, String Lead, boolean FullList) throws IOException
    {
      if (L == null || L.size() == 0) return;
      if (FullList == true)
       Out.write("[\n");
      boolean First = true;
      for (tilda.data.JobMessage_Data O : L)
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

   public static void toJSON(Writer Out, tilda.data.JobMessage_Data ObjApp, boolean FullObject) throws IOException
    {
      long T0 = System.nanoTime();
      tilda.data._Tilda.TILDA__JOBMESSAGE Obj = (tilda.data._Tilda.TILDA__JOBMESSAGE) ObjApp;
      if (FullObject == true)
       Out.write("{");

        JSONUtil.Print(Out, "jobFileRefnum", true, Obj.getJobFileRefnum());

        JSONUtil.Print(Out, "message", false, Obj.getMessage());

        JSONUtil.Print(Out, "created", false, Obj.getCreated());

      if (Obj.isNullIsError() == false)
        JSONUtil.Print(Out, "isError", false, Obj.getIsError());

      if (FullObject == true)
       Out.write(" }");
      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
