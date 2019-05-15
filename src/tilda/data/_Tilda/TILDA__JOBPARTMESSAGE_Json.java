
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
public class TILDA__JOBPARTMESSAGE_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__JOBPARTMESSAGE_Json.class.getName());

   protected TILDA__JOBPARTMESSAGE_Json() { }

   /*@formatter:off*/
   @SerializedName("jobRefnum"    ) public Long  _jobRefnum    ;
   @SerializedName("jobPartRefnum") public Long  _jobPartRefnum;
   @SerializedName("notify"       ) public Boolean  _notify       ;
   @SerializedName("msg"          ) public String  _msg          ;
   /*@formatter:on*/

   public tilda.data.JobPartMessage_Data Write(Connection C) throws Exception
    {
      if (_jobRefnum     == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JobPartMessage.jobRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (_notify        == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JobPartMessage.notify' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_msg          ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JobPartMessage.msg' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.JobPartMessage_Data Obj = tilda.data.JobPartMessage_Factory.Create(_jobRefnum, _notify, _msg);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         throw new Exception("Cannot create the tilda.data.TILDA.JobPartMessage object.\n"+toString());
       }
      return Obj;
   }

   public void Update(tilda.data.JobPartMessage_Data Obj) throws Exception
    {
      if (_jobRefnum    != null) Obj.setJobRefnum    (_jobRefnum    );
      if (_jobPartRefnum!= null) Obj.setJobPartRefnum(_jobPartRefnum);
      if (_notify       != null) Obj.setNotify       (_notify       );
      if (_msg          != null) Obj.setMsg          (_msg          );
    }

   public String toString()
    {
      return
             "jobRefnum"    + (_jobRefnum     == null ? ": NULL" : ": " + _jobRefnum    )
         + "; jobPartRefnum"+ (_jobPartRefnum == null ? ": NULL" : ": " + _jobPartRefnum)
         + "; notify"       + (_notify        == null ? ": NULL" : ": " + _notify       )
         + "; msg"          + (_msg           == null ? ": NULL" : "(" + (_msg           == null ? 0 : _msg          .length())+"): "+(_msg           == null || _msg          .length() < 100 ? _msg           : _msg          .substring(0, 100)+"..."))
         + ";";
    }

 }
