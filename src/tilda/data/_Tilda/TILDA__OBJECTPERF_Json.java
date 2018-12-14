
package tilda.data._Tilda;

import java.time.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.*;
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
   @SerializedName("selectCount"  ) public Integer  _selectCount  ;
   @SerializedName("selectRecords") public Integer  _selectRecords;
   @SerializedName("insertNano"   ) public Long  _insertNano   ;
   @SerializedName("insertCount"  ) public Integer  _insertCount  ;
   @SerializedName("insertRecords") public Integer  _insertRecords;
   @SerializedName("updateNano"   ) public Long  _updateNano   ;
   @SerializedName("updateCount"  ) public Integer  _updateCount  ;
   @SerializedName("updateRecords") public Integer  _updateRecords;
   @SerializedName("deleteNano"   ) public Long  _deleteNano   ;
   @SerializedName("deleteCount"  ) public Integer  _deleteCount  ;
   @SerializedName("deleteRecords") public Integer  _deleteRecords;
   /*@formatter:on*/

   public tilda.data.ObjectPerf_Data Write(Connection C) throws Exception
    {
      if (TextUtil.isNullOrEmpty(_schemaName   ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.schemaName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(_objectName   ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.objectName' was null or empty. It's not nullable in the model.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_startPeriod  ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.startPeriod' was null or empty. It's not nullable in the model.\n"+toString());
      _startPeriod   = DateTimeUtil.parsefromJSON(Str_startPeriod  );
      if (   _startPeriod   == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.startPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (TextUtil.isNullOrEmpty(Str_endPeriod    ) == true)
       throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.endPeriod' was null or empty. It's not nullable in the model.\n"+toString());
      _endPeriod     = DateTimeUtil.parsefromJSON(Str_endPeriod    );
      if (   _endPeriod     == null)
       throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.endPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
      if (_selectNano    == null)
       _selectNano=0l;
      if (_selectCount   == null)
       _selectCount=0;
      if (_selectRecords == null)
       _selectRecords=0;
      if (_insertNano    == null)
       _insertNano=0l;
      if (_insertCount   == null)
       _insertCount=0;
      if (_insertRecords == null)
       _insertRecords=0;
      if (_updateNano    == null)
       _updateNano=0l;
      if (_updateCount   == null)
       _updateCount=0;
      if (_updateRecords == null)
       _updateRecords=0;
      if (_deleteNano    == null)
       _deleteNano=0l;
      if (_deleteCount   == null)
       _deleteCount=0;
      if (_deleteRecords == null)
       _deleteRecords=0;

      tilda.data.ObjectPerf_Data Obj = tilda.data.ObjectPerf_Factory.Create(_schemaName, _objectName, _startPeriod, _endPeriod);
      Update(Obj);
      if (Obj.Write(C) == false)
       {
         Obj = tilda.data.ObjectPerf_Factory.LookupByPrimaryKey(_schemaName, _objectName, _startPeriod);
         if (Obj.Read(C) == false)
          throw new Exception("Cannot create the tilda.data.TILDA.ObjectPerf object.\n"+toString());
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
          throw new Exception("Cannot update the tilda.data.TILDA.ObjectPerf object: "+Obj.toString());

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
