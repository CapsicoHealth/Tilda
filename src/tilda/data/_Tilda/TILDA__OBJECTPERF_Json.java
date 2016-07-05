
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
public class TILDA__OBJECTPERF_Json
 {
   static final Logger             LOG                = LogManager.getLogger(TILDA__OBJECTPERF_Json.class.getName());

   protected TILDA__OBJECTPERF_Json() { }

   /*@formatter:off*/
   @SerializedName("schemaName"   ) public String  _schemaName   ;
   @SerializedName("objectName"   ) public String  _objectName   ;
   @SerializedName("startPeriod"  ) public String  Str_startPeriod  ;
   transient                        public ZonedDateTime  _startPeriod  ;
   @SerializedName("endPeriod"    ) public String  Str_endPeriod    ;
   transient                        public ZonedDateTime  _endPeriod    ;
   @SerializedName("selectNano"   ) public Long  _selectNano   ;
   @SerializedName("selectCount"  ) public Long  _selectCount  ;
   @SerializedName("selectRecords") public Long  _selectRecords;
   @SerializedName("insertNano"   ) public Long  _insertNano   ;
   @SerializedName("insertCount"  ) public Long  _insertCount  ;
   @SerializedName("insertRecords") public Long  _insertRecords;
   @SerializedName("updateNano"   ) public Long  _updateNano   ;
   @SerializedName("updateCount"  ) public Long  _updateCount  ;
   @SerializedName("updateRecords") public Long  _updateRecords;
   @SerializedName("deleteNano"   ) public Long  _deleteNano   ;
   @SerializedName("deleteCount"  ) public Long  _deleteCount  ;
   @SerializedName("deleteRecords") public Long  _deleteRecords;
   /*@formatter:on*/

   public tilda.data.ObjectPerf_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_schemaName   ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.schemaName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_objectName   ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.objectName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_startPeriod  ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.startPeriod' was null or empty. It's not nullable in the model.\n"+toString());
      _startPeriod   = DateTimeUtil.parsefromJSON(Str_startPeriod  );
      if (   _startPeriod   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.startPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_endPeriod    ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.endPeriod' was null or empty. It's not nullable in the model.\n"+toString());
      _endPeriod     = DateTimeUtil.parsefromJSON(Str_endPeriod    );
      if (   _endPeriod     == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.endPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (_selectNano    == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.selectNano' was null or empty. It's not nullable in the model.\n"+toString());
      if (_selectCount   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.selectCount' was null or empty. It's not nullable in the model.\n"+toString());
      if (_selectRecords == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.selectRecords' was null or empty. It's not nullable in the model.\n"+toString());
      if (_insertNano    == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.insertNano' was null or empty. It's not nullable in the model.\n"+toString());
      if (_insertCount   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.insertCount' was null or empty. It's not nullable in the model.\n"+toString());
      if (_insertRecords == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.insertRecords' was null or empty. It's not nullable in the model.\n"+toString());
      if (_updateNano    == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.updateNano' was null or empty. It's not nullable in the model.\n"+toString());
      if (_updateCount   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.updateCount' was null or empty. It's not nullable in the model.\n"+toString());
      if (_updateRecords == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.updateRecords' was null or empty. It's not nullable in the model.\n"+toString());
      if (_deleteNano    == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.deleteNano' was null or empty. It's not nullable in the model.\n"+toString());
      if (_deleteCount   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.deleteCount' was null or empty. It's not nullable in the model.\n"+toString());
      if (_deleteRecords == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.OBJECTPERF.deleteRecords' was null or empty. It's not nullable in the model.\n"+toString());

      tilda.data.ObjectPerf_Data Obj = tilda.data.ObjectPerf_Factory.Create(_schemaName, _objectName, _startPeriod, _endPeriod, _selectNano, _selectCount, _selectRecords, _insertNano, _insertCount, _insertRecords, _updateNano, _updateCount, _updateRecords, _deleteNano, _deleteCount, _deleteRecords);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.ObjectPerf_Factory.LookupByPrimaryKey(_schemaName, _objectName, _startPeriod);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.OBJECTPERF object.\n"+toString());
         if (_endPeriod    != null) Obj.setEndPeriod    (_endPeriod    );
         if (_selectNano   != null) Obj.setSelectNano   (_selectNano   );
         if (_selectCount  != null) Obj.setSelectCount  (_selectCount  );
         if (_selectRecords!= null) Obj.setSelectRecords(_selectRecords);
         if (_insertNano   != null) Obj.setInsertNano   (_insertNano   );
         if (_insertCount  != null) Obj.setInsertCount  (_insertCount  );
         if (_insertRecords!= null) Obj.setInsertRecords(_insertRecords);
         if (_updateNano   != null) Obj.setUpdateNano   (_updateNano   );
         if (_updateCount  != null) Obj.setUpdateCount  (_updateCount  );
         if (_updateRecords!= null) Obj.setUpdateRecords(_updateRecords);
         if (_deleteNano   != null) Obj.setDeleteNano   (_deleteNano   );
         if (_deleteCount  != null) Obj.setDeleteCount  (_deleteCount  );
         if (_deleteRecords!= null) Obj.setDeleteRecords(_deleteRecords);
         if (Obj.Write(C) == false)
          throw new Exception("Cannot update the tilda.data.TILDA.OBJECTPERF object: "+Obj.toString());

       }
      return Obj;
   }

   public void Update(tilda.data.ObjectPerf_Data Obj) throws Exception
    {
      if (_schemaName   != null) Obj.setSchemaName   (_schemaName   );
      if (_objectName   != null) Obj.setObjectName   (_objectName   );
      if (_startPeriod  != null) Obj.setStartPeriod  (_startPeriod  );
      if (_endPeriod    != null) Obj.setEndPeriod    (_endPeriod    );
      if (_selectNano   != null) Obj.setSelectNano   (_selectNano   );
      if (_selectCount  != null) Obj.setSelectCount  (_selectCount  );
      if (_selectRecords!= null) Obj.setSelectRecords(_selectRecords);
      if (_insertNano   != null) Obj.setInsertNano   (_insertNano   );
      if (_insertCount  != null) Obj.setInsertCount  (_insertCount  );
      if (_insertRecords!= null) Obj.setInsertRecords(_insertRecords);
      if (_updateNano   != null) Obj.setUpdateNano   (_updateNano   );
      if (_updateCount  != null) Obj.setUpdateCount  (_updateCount  );
      if (_updateRecords!= null) Obj.setUpdateRecords(_updateRecords);
      if (_deleteNano   != null) Obj.setDeleteNano   (_deleteNano   );
      if (_deleteCount  != null) Obj.setDeleteCount  (_deleteCount  );
      if (_deleteRecords!= null) Obj.setDeleteRecords(_deleteRecords);
    }

   public String toString()
    {
      return
             "schemaName"   + (_schemaName    == null ? ": NULL" : "(" + (_schemaName    == null ? 0 : _schemaName   .length())+"): "+_schemaName)
         + "; objectName"   + (_objectName    == null ? ": NULL" : "(" + (_objectName    == null ? 0 : _objectName   .length())+"): "+_objectName)
         + "; startPeriod"  + (_startPeriod   == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_startPeriod))
         + "; endPeriod"    + (_endPeriod     == null ? ": NULL" : ": "+DateTimeUtil.printDateTimeForSQL(_endPeriod))
         + "; selectNano"   + (_selectNano    == null ? ": NULL" : ": " + _selectNano   )
         + "; selectCount"  + (_selectCount   == null ? ": NULL" : ": " + _selectCount  )
         + "; selectRecords"+ (_selectRecords == null ? ": NULL" : ": " + _selectRecords)
         + "; insertNano"   + (_insertNano    == null ? ": NULL" : ": " + _insertNano   )
         + "; insertCount"  + (_insertCount   == null ? ": NULL" : ": " + _insertCount  )
         + "; insertRecords"+ (_insertRecords == null ? ": NULL" : ": " + _insertRecords)
         + "; updateNano"   + (_updateNano    == null ? ": NULL" : ": " + _updateNano   )
         + "; updateCount"  + (_updateCount   == null ? ": NULL" : ": " + _updateCount  )
         + "; updateRecords"+ (_updateRecords == null ? ": NULL" : ": " + _updateRecords)
         + "; deleteNano"   + (_deleteNano    == null ? ": NULL" : ": " + _deleteNano   )
         + "; deleteCount"  + (_deleteCount   == null ? ": NULL" : ": " + _deleteCount  )
         + "; deleteRecords"+ (_deleteRecords == null ? ": NULL" : ": " + _deleteRecords)
         + ";";
    }

 }
