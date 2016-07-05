
package tilda.data._Tilda;

import java.io.IOException;
import java.io.Writer;
import java.time.ZonedDateTime;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.SyncStatus;
import tilda.enums.TransactionType;
import tilda.performance.*;
import tilda.utils.*;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings({ "unused" })
public class TILDA__TRANSPERF_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__TRANSPERF_Json.class.getName());

   protected TILDA__TRANSPERF_Json() { }

   /*@formatter:off*/
   @SerializedName("schemaName"   ) public String  _schemaName   ;
   @SerializedName("objectName"   ) public String  _objectName   ;
   @SerializedName("startPeriod"  ) public String  Str_startPeriod  ;
   transient                        public ZonedDateTime  _startPeriod  ;
   @SerializedName("endPeriod"    ) public String  Str_endPeriod    ;
   transient                        public ZonedDateTime  _endPeriod    ;
   @SerializedName("commitNano"   ) public Long  _commitNano   ;
   @SerializedName("commitCount"  ) public Long  _commitCount  ;
   @SerializedName("rollbackNano" ) public Long  _rollbackNano ;
   @SerializedName("rollbackCount") public Long  _rollbackCount;
   /*@formatter:on*/

   public tilda.data.TransPerf_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_schemaName   ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TRANSPERF.schemaName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_objectName   ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TRANSPERF.objectName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_startPeriod  ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TRANSPERF.startPeriod' was null or empty. It's not nullable in the model.\n"+toString());
      _startPeriod   = DateTimeUtil.parsefromJSON(Str_startPeriod  );
      if (   _startPeriod   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TRANSPERF.startPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_endPeriod    ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TRANSPERF.endPeriod' was null or empty. It's not nullable in the model.\n"+toString());
      _endPeriod     = DateTimeUtil.parsefromJSON(Str_endPeriod    );
      if (   _endPeriod     == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TRANSPERF.endPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (_commitNano    == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TRANSPERF.commitNano' was null or empty. It's not nullable in the model.\n"+toString());
      if (_commitCount   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TRANSPERF.commitCount' was null or empty. It's not nullable in the model.\n"+toString());
      if (_rollbackNano  == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TRANSPERF.rollbackNano' was null or empty. It's not nullable in the model.\n"+toString());
      if (_rollbackCount == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.TRANSPERF.rollbackCount' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.TransPerf_Data Obj = tilda.data.TransPerf_Factory.Create(_schemaName, _objectName, _startPeriod, _endPeriod, _commitNano, _commitCount, _rollbackNano, _rollbackCount);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.TransPerf_Factory.LookupByPrimaryKey(_schemaName, _objectName, _startPeriod);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.TRANSPERF object.\n"+toString());
         if (_endPeriod    != null) Obj.setEndPeriod    (_endPeriod    );
         if (_commitNano   != null) Obj.setCommitNano   (_commitNano   );
         if (_commitCount  != null) Obj.setCommitCount  (_commitCount  );
         if (_rollbackNano != null) Obj.setRollbackNano (_rollbackNano );
         if (_rollbackCount!= null) Obj.setRollbackCount(_rollbackCount);
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.TRANSPERF object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.TransPerf_Data Obj) throws Exception
    {
      if (_schemaName   != null) Obj.setSchemaName   (_schemaName   );
      if (_objectName   != null) Obj.setObjectName   (_objectName   );
      if (_startPeriod  != null) Obj.setStartPeriod  (_startPeriod  );
      if (_endPeriod    != null) Obj.setEndPeriod    (_endPeriod    );
      if (_commitNano   != null) Obj.setCommitNano   (_commitNano   );
      if (_commitCount  != null) Obj.setCommitCount  (_commitCount  );
      if (_rollbackNano != null) Obj.setRollbackNano (_rollbackNano );
      if (_rollbackCount!= null) Obj.setRollbackCount(_rollbackCount);
    }

   public String toString()
    {
      return
             "schemaName"   + (_schemaName    == null ? ": NULL" : "(" + (_schemaName    == null ? 0 : _schemaName   .length())+"): "+_schemaName)
         + "; objectName"   + (_objectName    == null ? ": NULL" : "(" + (_objectName    == null ? 0 : _objectName   .length())+"): "+_objectName)
         + "; startPeriod"  + (_startPeriod   == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_startPeriod))
         + "; endPeriod"    + (_endPeriod     == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_endPeriod))
         + "; commitNano"   + (_commitNano    == null ? ": NULL" : ": " + _commitNano   )
         + "; commitCount"  + (_commitCount   == null ? ": NULL" : ": " + _commitCount  )
         + "; rollbackNano" + (_rollbackNano  == null ? ": NULL" : ": " + _rollbackNano )
         + "; rollbackCount"+ (_rollbackCount == null ? ": NULL" : ": " + _rollbackCount)
         + ";";
    }

 }
