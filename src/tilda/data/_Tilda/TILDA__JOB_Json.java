
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


public class TILDA__JOB_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__JOB_Json.class.getName());

   protected TILDA__JOB_Json() { }

   /*@formatter:off*/
   @SerializedName("name"         ) public String  _name         ;
   @SerializedName("startTime"    ) public String  Str_startTime    ;
   transient                        public ZonedDateTime  _startTime    ;
   @SerializedName("endTime"      ) public String  Str_endTime      ;
   transient                        public ZonedDateTime  _endTime      ;
   @SerializedName("totalRecords" ) public Long  _totalRecords ;
   @SerializedName("status"       ) public String  _status       ;
   @SerializedName("error"        ) public String  _error        ;
   @SerializedName("threadsCount" ) public Integer  _threadsCount ;
   @SerializedName("isInsert"     ) public Boolean  _isInsert     ;
   @SerializedName("truncateTable") public Boolean  _truncateTable;
   @SerializedName("connectionId" ) public String  _connectionId ;
   @SerializedName("zipFile"      ) public String  _zipFile      ;
   /*@formatter:on*/

   public tilda.data.Job_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(Str_startTime    ) == false)
       {
         _startTime     = DateTimeUtil.parsefromJSON(Str_startTime    );
         if (   _startTime     == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.JOB.startTime' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }
      if (TextUtil.isNullOrEmpty(Str_endTime      ) == false)
       {
         _endTime       = DateTimeUtil.parsefromJSON(Str_endTime      );
         if (   _endTime       == null)
          throw new Exception("Incoming value for 'tilda.data.TILDA.JOB.endTime' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       }
      if (TextUtil.isNullOrEmpty(_status       ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB.status' was null or empty. It's not nullable in the model.\n"+toString());
      if (_threadsCount  == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB.threadsCount' was null or empty. It's not nullable in the model.\n"+toString());
      if (_isInsert      == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB.isInsert' was null or empty. It's not nullable in the model.\n"+toString());
      if (_truncateTable == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB.truncateTable' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_connectionId ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB.connectionId' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_zipFile      ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.JOB.zipFile' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.Job_Data Obj = tilda.data.Job_Factory.Create(_isInsert, _truncateTable, _connectionId, _zipFile);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.Job_Factory.LookupByStatusIndex(_status);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.JOB object.\n"+toString());
         if (_name         != null) Obj.setName         (_name         );
         if (_startTime    != null) Obj.setStartTime    (_startTime    );
         if (_endTime      != null) Obj.setEndTime      (_endTime      );
         if (_totalRecords != null) Obj.setTotalRecords (_totalRecords );
         if (_error        != null) Obj.setError        (_error        );
         if (_threadsCount != null) Obj.setThreadsCount (_threadsCount );
         if (_isInsert     != null) Obj.setIsInsert     (_isInsert     );
         if (_truncateTable!= null) Obj.setTruncateTable(_truncateTable);
         if (_connectionId != null) Obj.setConnectionId (_connectionId );
         if (_zipFile      != null) Obj.setZipFile      (_zipFile      );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.JOB object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.Job_Data Obj) throws Exception
    {
      if (_name         != null) Obj.setName         (_name         );
      if (_startTime    != null) Obj.setStartTime    (_startTime    );
      if (_endTime      != null) Obj.setEndTime      (_endTime      );
      if (_totalRecords != null) Obj.setTotalRecords (_totalRecords );
      if (_status       != null) Obj.setStatus       (_status       );
      if (_error        != null) Obj.setError        (_error        );
      if (_threadsCount != null) Obj.setThreadsCount (_threadsCount );
      if (_isInsert     != null) Obj.setIsInsert     (_isInsert     );
      if (_truncateTable!= null) Obj.setTruncateTable(_truncateTable);
      if (_connectionId != null) Obj.setConnectionId (_connectionId );
      if (_zipFile      != null) Obj.setZipFile      (_zipFile      );
    }

   public String toString()
    {
      return
             "name"         + (_name          == null ? ": NULL" : "(" + (_name          == null ? 0 : _name         .length())+"): "+_name)
         + "; startTime"    + (_startTime     == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_startTime))
         + "; endTime"      + (_endTime       == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_endTime))
         + "; totalRecords" + (_totalRecords  == null ? ": NULL" : ": " + _totalRecords )
         + "; status"       + (_status        == null ? ": NULL" : "(" + (_status        == null ? 0 : _status       .length())+"): "+_status)
         + "; error"        + (_error         == null ? ": NULL" : "(" + (_error         == null ? 0 : _error        .length())+"): "+(_error         == null || _error        .length() < 100 ? _error         : _error        .substring(0, 100)+"..."))
         + "; threadsCount" + (_threadsCount  == null ? ": NULL" : ": " + _threadsCount )
         + "; isInsert"     + (_isInsert      == null ? ": NULL" : ": " + _isInsert     )
         + "; truncateTable"+ (_truncateTable == null ? ": NULL" : ": " + _truncateTable)
         + "; connectionId" + (_connectionId  == null ? ": NULL" : "(" + (_connectionId  == null ? 0 : _connectionId .length())+"): "+_connectionId)
         + "; zipFile"      + (_zipFile       == null ? ": NULL" : "(" + (_zipFile       == null ? 0 : _zipFile      .length())+"): "+(_zipFile       == null || _zipFile      .length() < 100 ? _zipFile       : _zipFile      .substring(0, 100)+"..."))
         + ";";
    }

 }
