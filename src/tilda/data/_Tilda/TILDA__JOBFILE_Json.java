
package tilda.data._Tilda;

import java.io.*;
import java.time.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;


public class TILDA__JOBFILE_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__JOBFILE_Json.class.getName());

   protected TILDA__JOBFILE_Json() { }

   /*@formatter:off*/
   @SerializedName("jobRefnum"             ) public Long  _jobRefnum             ;
   @SerializedName("fileName"              ) public String  _fileName              ;
   @SerializedName("fileRecords"           ) public Integer  _fileRecords           ;
   @SerializedName("fileProcessStartTime"  ) public String  Str_fileProcessStartTime  ;
   transient                                 public ZonedDateTime  _fileProcessStartTime  ;
   @SerializedName("fileProcessEndTime"    ) public String  Str_fileProcessEndTime    ;
   transient                                 public ZonedDateTime  _fileProcessEndTime    ;
   /*@formatter:on*/

   public tilda.data.JobFile_Data Write(Connection C) throws Exception
    {
      if (_jobRefnum              == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOBFILE.jobRefnum' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_fileName              ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOBFILE.fileName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_fileProcessStartTime  ) == false)
       {
         _fileProcessStartTime   = DateTimeUtil.parsefromJSON(Str_fileProcessStartTime  );
         if (   _fileProcessStartTime   == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.JOBFILE.fileProcessStartTime' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }
      if (TextUtil.isNullOrEmpty(Str_fileProcessEndTime    ) == false)
       {
         _fileProcessEndTime     = DateTimeUtil.parsefromJSON(Str_fileProcessEndTime    );
         if (   _fileProcessEndTime     == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.JOBFILE.fileProcessEndTime' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }

      tilda.data.JobFile_Data Obj = tilda.data.JobFile_Factory.Create(_jobRefnum, _fileName);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.JobFile_Factory.LookupByJob_Refnum(_jobRefnum);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.JOBFILE object.\n"+toString());
         if (_fileName              != null) Obj.setFileName              (_fileName              );
         if (_fileRecords           != null) Obj.setFileRecords           (_fileRecords           );
         if (_fileProcessStartTime  != null) Obj.setFileProcessStartTime  (_fileProcessStartTime  );
         if (_fileProcessEndTime    != null) Obj.setFileProcessEndTime    (_fileProcessEndTime    );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.JOBFILE object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.JobFile_Data Obj) throws Exception
    {
      if (_jobRefnum             != null) Obj.setJobRefnum             (_jobRefnum             );
      if (_fileName              != null) Obj.setFileName              (_fileName              );
      if (_fileRecords           != null) Obj.setFileRecords           (_fileRecords           );
      if (_fileProcessStartTime  != null) Obj.setFileProcessStartTime  (_fileProcessStartTime  );
      if (_fileProcessEndTime    != null) Obj.setFileProcessEndTime    (_fileProcessEndTime    );
    }

   public String toString()
    {
      return
             "jobRefnum"             + (_jobRefnum              == null ? ": NULL" : ": " + _jobRefnum             )
         + "; fileName"              + (_fileName               == null ? ": NULL" : "(" + (_fileName               == null ? 0 : _fileName              .length())+"): "+(_fileName               == null || _fileName              .length() < 100 ? _fileName               : _fileName              .substring(0, 100)+"..."))
         + "; fileRecords"           + (_fileRecords            == null ? ": NULL" : ": " + _fileRecords           )
         + "; fileProcessStartTime"  + (_fileProcessStartTime   == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_fileProcessStartTime))
         + "; fileProcessEndTime"    + (_fileProcessEndTime     == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_fileProcessEndTime))
         + ";";
    }

 }
