
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


public class TILDA__JOB_DETAIL_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__JOB_DETAIL_Json.class.getName());

   protected TILDA__JOB_DETAIL_Json() { }

   /*@formatter:off*/
   @SerializedName("Id"                    ) public Integer  _Id                    ;
   @SerializedName("Job_Id"                ) public Integer  _Job_Id                ;
   @SerializedName("FileName"              ) public String  _FileName              ;
   @SerializedName("FileRecords"           ) public Integer  _FileRecords           ;
   @SerializedName("FileProcessStartTime"  ) public String  Str_FileProcessStartTime  ;
   transient                                 public ZonedDateTime  _FileProcessStartTime  ;
   @SerializedName("FileProcessEndTime"    ) public String  Str_FileProcessEndTime    ;
   transient                                 public ZonedDateTime  _FileProcessEndTime    ;
   @SerializedName("Status"                ) public String  _Status                ;
   @SerializedName("Error"                 ) public String  _Error                 ;
   /*@formatter:on*/

   public tilda.data.Job_Detail_Data Write(Connection C) throws Exception
    {
      if (_Id                     == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB_DETAIL.Id' was null or empty. It's not nullable in the model.\n"+toString());
      if (_Job_Id                 == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB_DETAIL.Job_Id' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_FileProcessStartTime  ) == false)
       {
         _FileProcessStartTime   = DateTimeUtil.parsefromJSON(Str_FileProcessStartTime  );
         if (   _FileProcessStartTime   == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.JOB_DETAIL.FileProcessStartTime' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }
      if (TextUtil.isNullOrEmpty(Str_FileProcessEndTime    ) == false)
       {
         _FileProcessEndTime     = DateTimeUtil.parsefromJSON(Str_FileProcessEndTime    );
         if (   _FileProcessEndTime     == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.JOB_DETAIL.FileProcessEndTime' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }

      tilda.data.Job_Detail_Data Obj = tilda.data.Job_Detail_Factory.Create(_Id, _Job_Id);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.Job_Detail_Factory.LookupByJob_File_Id(_Id, _Job_Id);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.JOB_DETAIL object.\n"+toString());
         if (_FileName              != null) Obj.setFileName              (_FileName              );
         if (_FileRecords           != null) Obj.setFileRecords           (_FileRecords           );
         if (_FileProcessStartTime  != null) Obj.setFileProcessStartTime  (_FileProcessStartTime  );
         if (_FileProcessEndTime    != null) Obj.setFileProcessEndTime    (_FileProcessEndTime    );
         if (_Status                != null) Obj.setStatus                (_Status                );
         if (_Error                 != null) Obj.setError                 (_Error                 );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.JOB_DETAIL object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.Job_Detail_Data Obj) throws Exception
    {
      if (_Id                    != null) Obj.setId                    (_Id                    );
      if (_Job_Id                != null) Obj.setJob_Id                (_Job_Id                );
      if (_FileName              != null) Obj.setFileName              (_FileName              );
      if (_FileRecords           != null) Obj.setFileRecords           (_FileRecords           );
      if (_FileProcessStartTime  != null) Obj.setFileProcessStartTime  (_FileProcessStartTime  );
      if (_FileProcessEndTime    != null) Obj.setFileProcessEndTime    (_FileProcessEndTime    );
      if (_Status                != null) Obj.setStatus                (_Status                );
      if (_Error                 != null) Obj.setError                 (_Error                 );
    }

   public String toString()
    {
      return
             "Id"                    + (_Id                     == null ? ": NULL" : ": " + _Id                    )
         + "; Job_Id"                + (_Job_Id                 == null ? ": NULL" : ": " + _Job_Id                )
         + "; FileName"              + (_FileName               == null ? ": NULL" : "(" + (_FileName               == null ? 0 : _FileName              .length())+"): "+(_FileName               == null || _FileName              .length() < 100 ? _FileName               : _FileName              .substring(0, 100)+"..."))
         + "; FileRecords"           + (_FileRecords            == null ? ": NULL" : ": " + _FileRecords           )
         + "; FileProcessStartTime"  + (_FileProcessStartTime   == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_FileProcessStartTime))
         + "; FileProcessEndTime"    + (_FileProcessEndTime     == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_FileProcessEndTime))
         + "; Status"                + (_Status                 == null ? ": NULL" : "(" + (_Status                 == null ? 0 : _Status                .length())+"): "+(_Status                 == null || _Status                .length() < 100 ? _Status                 : _Status                .substring(0, 100)+"..."))
         + "; Error"                 + (_Error                  == null ? ": NULL" : "(" + (_Error                  == null ? 0 : _Error                 .length())+"): "+(_Error                  == null || _Error                 .length() < 100 ? _Error                  : _Error                 .substring(0, 100)+"..."))
         + ";";
    }

 }
