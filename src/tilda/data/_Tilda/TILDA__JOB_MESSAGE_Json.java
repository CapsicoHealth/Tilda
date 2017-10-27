
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


public class TILDA__JOB_MESSAGE_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__JOB_MESSAGE_Json.class.getName());

   protected TILDA__JOB_MESSAGE_Json() { }

   /*@formatter:off*/
   @SerializedName("jobFileRefnum") public Long  _jobFileRefnum;
   @SerializedName("message"      ) public String  _message      ;
   @SerializedName("isError"      ) public Boolean  _isError      ;
   /*@formatter:on*/

   public tilda.data.Job_Message_Data Write(Connection C) throws Exception
    {
      if (_jobFileRefnum == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB_MESSAGE.jobFileRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_message      ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB_MESSAGE.message' was null or empty. It's not nullable in the model.\n"+toString());
      if (_isError       == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB_MESSAGE.isError' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.Job_Message_Data Obj = tilda.data.Job_Message_Factory.Create(_jobFileRefnum, _message, _isError);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         throw new Exception("Cannot create the tilda.data.TILDA.JOB_MESSAGE object.\n"+toString());
       }
      return Obj;
   }

   public void Update(tilda.data.Job_Message_Data Obj) throws Exception
    {
      if (_jobFileRefnum!= null) Obj.setJobFileRefnum(_jobFileRefnum);
      if (_message      != null) Obj.setMessage      (_message      );
      if (_isError      != null) Obj.setIsError      (_isError      );
    }

   public String toString()
    {
      return
             "jobFileRefnum"+ (_jobFileRefnum == null ? ": NULL" : ": " + _jobFileRefnum)
         + "; message"      + (_message       == null ? ": NULL" : "(" + (_message       == null ? 0 : _message      .length())+"): "+(_message       == null || _message      .length() < 100 ? _message       : _message      .substring(0, 100)+"..."))
         + "; isError"      + (_isError       == null ? ": NULL" : ": " + _isError      )
         + ";";
    }

 }
