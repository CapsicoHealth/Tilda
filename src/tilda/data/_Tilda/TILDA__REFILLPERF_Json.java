
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


public class TILDA__REFILLPERF_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__REFILLPERF_Json.class.getName());

   protected TILDA__REFILLPERF_Json() { }

   /*@formatter:off*/
   @SerializedName("schemaName"   ) public String  _schemaName   ;
   @SerializedName("objectName"   ) public String  _objectName   ;
   @SerializedName("startPeriod"  ) public String  Str_startPeriod  ;
   transient                        public ZonedDateTime  _startPeriod  ;
   @SerializedName("timeCreateMs" ) public Long  _timeCreateMs ;
   @SerializedName("timeIndexMs"  ) public Long  _timeIndexMs  ;
   @SerializedName("timeAnalyzeMs") public Long  _timeAnalyzeMs;
   @SerializedName("timeTotalMs"  ) public Long  _timeTotalMs  ;
   @SerializedName("columnsMs"    ) public Long  _columnsMs    ;
   /*@formatter:on*/

   public tilda.data.RefillPerf_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_schemaName   ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.RefillPerf.schemaName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_objectName   ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.RefillPerf.objectName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_startPeriod  ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.RefillPerf.startPeriod' was null or empty. It's not nullable in the model.\n"+toString());
      _startPeriod   = DateTimeUtil.parsefromJSON(Str_startPeriod  );
      if (   _startPeriod   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.RefillPerf.startPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (_timeCreateMs  == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.RefillPerf.timeCreateMs' was null or empty. It's not nullable in the model.\n"+toString());
      if (_timeIndexMs   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.RefillPerf.timeIndexMs' was null or empty. It's not nullable in the model.\n"+toString());
      if (_timeAnalyzeMs == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.RefillPerf.timeAnalyzeMs' was null or empty. It's not nullable in the model.\n"+toString());
      if (_timeTotalMs   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.RefillPerf.timeTotalMs' was null or empty. It's not nullable in the model.\n"+toString());
      if (_columnsMs     == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.RefillPerf.columnsMs' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.RefillPerf_Data Obj = tilda.data.RefillPerf_Factory.Create(_schemaName, _objectName, _startPeriod, _timeCreateMs, _timeIndexMs, _timeAnalyzeMs, _timeTotalMs, _columnsMs);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.RefillPerf_Factory.LookupByPrimaryKey(_schemaName, _objectName, _startPeriod);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.RefillPerf object.\n"+toString());
         if (_timeCreateMs != null) Obj.setTimeCreateMs (_timeCreateMs );
         if (_timeIndexMs  != null) Obj.setTimeIndexMs  (_timeIndexMs  );
         if (_timeAnalyzeMs!= null) Obj.setTimeAnalyzeMs(_timeAnalyzeMs);
         if (_timeTotalMs  != null) Obj.setTimeTotalMs  (_timeTotalMs  );
         if (_columnsMs    != null) Obj.setColumnsMs    (_columnsMs    );
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.RefillPerf object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.RefillPerf_Data Obj) throws Exception
    {
      if (_schemaName   != null) Obj.setSchemaName   (_schemaName   );
      if (_objectName   != null) Obj.setObjectName   (_objectName   );
      if (_startPeriod  != null) Obj.setStartPeriod  (_startPeriod  );
      if (_timeCreateMs != null) Obj.setTimeCreateMs (_timeCreateMs );
      if (_timeIndexMs  != null) Obj.setTimeIndexMs  (_timeIndexMs  );
      if (_timeAnalyzeMs!= null) Obj.setTimeAnalyzeMs(_timeAnalyzeMs);
      if (_timeTotalMs  != null) Obj.setTimeTotalMs  (_timeTotalMs  );
      if (_columnsMs    != null) Obj.setColumnsMs    (_columnsMs    );
    }

   public String toString()
    {
      return
             "schemaName"   + (_schemaName    == null ? ": NULL" : "(" + (_schemaName    == null ? 0 : _schemaName   .length())+"): "+_schemaName)
         + "; objectName"   + (_objectName    == null ? ": NULL" : "(" + (_objectName    == null ? 0 : _objectName   .length())+"): "+_objectName)
         + "; startPeriod"  + (_startPeriod   == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_startPeriod))
         + "; timeCreateMs" + (_timeCreateMs  == null ? ": NULL" : ": " + _timeCreateMs )
         + "; timeIndexMs"  + (_timeIndexMs   == null ? ": NULL" : ": " + _timeIndexMs  )
         + "; timeAnalyzeMs"+ (_timeAnalyzeMs == null ? ": NULL" : ": " + _timeAnalyzeMs)
         + "; timeTotalMs"  + (_timeTotalMs   == null ? ": NULL" : ": " + _timeTotalMs  )
         + "; columnsMs"    + (_columnsMs     == null ? ": NULL" : ": " + _columnsMs    )
         + ";";
    }

 }
