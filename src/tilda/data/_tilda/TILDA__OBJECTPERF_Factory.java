
package tilda.data._tilda;

import java.io.IOException;
import java.io.Writer;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.ArrayListResults;
import tilda.db.Connection;
import tilda.db.InitMode;
import tilda.db.JDBCHelper;
import tilda.db.ListResults;
import tilda.db.QueryDetails;
import tilda.db.SelectQuery;
import tilda.db.UpdateQuery;
import tilda.db.DeleteQuery;
import tilda.db.processors.RecordProcessor;
import tilda.enums.ColumnType;
import tilda.enums.StatementType;
import tilda.enums.TransactionType;
import tilda.performance.PerfTracker;
import tilda.types.*;
import tilda.utils.CollectionUtil;
import tilda.utils.DateTimeUtil;
import tilda.utils.DurationUtil;
import tilda.utils.HTMLFilter;
import tilda.utils.JSONUtil;
import tilda.utils.ParseUtil;
import tilda.utils.pairs.StringStringPair;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@SuppressWarnings({ "unchecked", "unused" })
public class TILDA__OBJECTPERF_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__OBJECTPERF_Factory.class.getName());

   protected TILDA__OBJECTPERF_Factory() { }

   public static final String TABLENAME = TextUtil.Print("TILDA.OBJECTPERF", "");

   protected static abstract class COLS {
     public static Type_StringPrimitive         SCHEMANAME   = new Type_StringPrimitive        ("TILDA.OBJECTPERF", "schemaName"   , 0);
     public static Type_StringPrimitive         OBJECTNAME   = new Type_StringPrimitive        ("TILDA.OBJECTPERF", "objectName"   , 1);
     public static Type_StringPrimitive         STARTPERIODTZ= new Type_StringPrimitive        ("TILDA.OBJECTPERF", "startPeriodTZ", 2);
     public static Type_DatetimePrimitive       STARTPERIOD  = new Type_DatetimePrimitive      ("TILDA.OBJECTPERF", "startPeriod"  , 3);
     public static Type_StringPrimitive         ENDPERIODTZ  = new Type_StringPrimitive        ("TILDA.OBJECTPERF", "endPeriodTZ"  , 4);
     public static Type_DatetimePrimitive       ENDPERIOD    = new Type_DatetimePrimitive      ("TILDA.OBJECTPERF", "endPeriod"    , 5);
     public static Type_LongPrimitive           SELECTNANO   = new Type_LongPrimitive          ("TILDA.OBJECTPERF", "selectNano"   , 6);
     public static Type_LongPrimitive           SELECTCOUNT  = new Type_LongPrimitive          ("TILDA.OBJECTPERF", "selectCount"  , 7);
     public static Type_LongPrimitive           SELECTRECORDS= new Type_LongPrimitive          ("TILDA.OBJECTPERF", "selectRecords", 8);
     public static Type_LongPrimitive           INSERTNANO   = new Type_LongPrimitive          ("TILDA.OBJECTPERF", "insertNano"   , 9);
     public static Type_LongPrimitive           INSERTCOUNT  = new Type_LongPrimitive          ("TILDA.OBJECTPERF", "insertCount"  , 10);
     public static Type_LongPrimitive           INSERTRECORDS= new Type_LongPrimitive          ("TILDA.OBJECTPERF", "insertRecords", 11);
     public static Type_LongPrimitive           UPDATENANO   = new Type_LongPrimitive          ("TILDA.OBJECTPERF", "updateNano"   , 12);
     public static Type_LongPrimitive           UPDATECOUNT  = new Type_LongPrimitive          ("TILDA.OBJECTPERF", "updateCount"  , 13);
     public static Type_LongPrimitive           UPDATERECORDS= new Type_LongPrimitive          ("TILDA.OBJECTPERF", "updateRecords", 14);
     public static Type_LongPrimitive           DELETENANO   = new Type_LongPrimitive          ("TILDA.OBJECTPERF", "deleteNano"   , 15);
     public static Type_LongPrimitive           DELETECOUNT  = new Type_LongPrimitive          ("TILDA.OBJECTPERF", "deleteCount"  , 16);
     public static Type_LongPrimitive           DELETERECORDS= new Type_LongPrimitive          ("TILDA.OBJECTPERF", "deleteRecords", 17);
     public static Type_DatetimePrimitive       CREATED      = new Type_DatetimePrimitive      ("TILDA.OBJECTPERF", "created"      , 18);
     public static Type_DatetimePrimitive       LASTUPDATED  = new Type_DatetimePrimitive      ("TILDA.OBJECTPERF", "lastUpdated"  , 19);
     public static Type_DatetimePrimitiveNull   DELETED      = new Type_DatetimePrimitiveNull  ("TILDA.OBJECTPERF", "deleted"      , 20);
;
   }

   private static Boolean  __INITIALIZED = false;
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED == false)
        synchronized(__INITIALIZED)
         {
           if (__INITIALIZED == false)
            {
              tilda.data.ObjectPerf_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorList implements RecordProcessor
     {
       public RecordProcessorList(Connection C, int Start)
         {
           _L = new ArrayListResults<tilda.data.ObjectPerf_Data>(Start);
           _C = C;
         }
       protected ArrayListResults<tilda.data.ObjectPerf_Data> _L = null;
       protected Connection _C = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.ObjectPerf_Data Obj = new tilda.data.ObjectPerf_Data();
          boolean OK = ((tilda.data._tilda.TILDA__OBJECTPERF)Obj).Init(_C, RS);
          if (OK == true)
           _L.add(Obj);
          return OK;
        }
     }

   private static final ListResults<tilda.data.ObjectPerf_Data> ReadMany(Connection C, int LookupId, tilda.data._tilda.TILDA__OBJECTPERF Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select TILDA.OBJECTPERF.\"schemaName\", TILDA.OBJECTPERF.\"objectName\", TILDA.OBJECTPERF.\"startPeriodTZ\", TILDA.OBJECTPERF.\"startPeriod\", TILDA.OBJECTPERF.\"endPeriodTZ\", TILDA.OBJECTPERF.\"endPeriod\", TILDA.OBJECTPERF.\"selectNano\", TILDA.OBJECTPERF.\"selectCount\", TILDA.OBJECTPERF.\"selectRecords\", TILDA.OBJECTPERF.\"insertNano\", TILDA.OBJECTPERF.\"insertCount\", TILDA.OBJECTPERF.\"insertRecords\", TILDA.OBJECTPERF.\"updateNano\", TILDA.OBJECTPERF.\"updateCount\", TILDA.OBJECTPERF.\"updateRecords\", TILDA.OBJECTPERF.\"deleteNano\", TILDA.OBJECTPERF.\"deleteCount\", TILDA.OBJECTPERF.\"deleteRecords\", TILDA.OBJECTPERF.\"created\", TILDA.OBJECTPERF.\"lastUpdated\", TILDA.OBJECTPERF.\"deleted\" from TILDA.OBJECTPERF");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(" where ").append(clause);
             break;
          case 1:
             S.append(" where (TILDA.OBJECTPERF.\"schemaName\"=?)");
             S.append(" order by TILDA.OBJECTPERF.\"objectName\" ASC, TILDA.OBJECTPERF.\"startPeriod\" DESC");
             break;
          case 2:
             S.append(" where (TILDA.OBJECTPERF.\"schemaName\"=? AND TILDA.OBJECTPERF.\"objectName\"=?)");
             S.append(" order by TILDA.OBJECTPERF.\"startPeriod\" DESC");
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TABLENAME, Q);
       LOG.debug("TILDA([7mTILDA.OBJECTPERF[27m): "+Q.replaceAll(TABLENAME+"\\.",""));
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       RecordProcessorList RPL = new RecordProcessorList(C, Start);
       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
          switch (LookupId)
           {
             case -7:
                break;
             case 1: {
               PS.setString   (++i, Obj._schemaName   );
               break;
             }
             case 2: {
               PS.setString   (++i, Obj._schemaName   );
               PS.setString   (++i, Obj._objectName   );
               break;
             }
             case -666: break;
             default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot prepare statement.");
           }

          count = JDBCHelper.Process(PS.executeQuery(), RPL, Start, true, Size, true);
        }
       catch (java.sql.SQLException E)
        {
          tilda.data._tilda.TILDA__1_0.HandleCatch(C, E, "selected");
        }
       finally
        {
          tilda.data._tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__OBJECTPERF_Factory.TABLENAME, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

      return RPL._L;
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Creates a new object in memory, which you can subsequently {@link #Write()} to the data store.
 current object to the destination. 
 @param schemaName    (max size 64) The name of the schema tracked
 @param objectName    (max size 64) The name of the table/object tracked
 @param startPeriod   The timestamp for when the record was created.
 @param endPeriod     The timestamp for when the record was created.
 @param selectNano    Blah...
 @param selectCount   Blah...
 @param selectRecords Blah...
 @param insertNano    Blah...
 @param insertCount   Blah...
 @param insertRecords Blah...
 @param updateNano    Blah...
 @param updateCount   Blah...
 @param updateRecords Blah...
 @param deleteNano    Blah...
 @param deleteCount   Blah...
 @param deleteRecords Blah...
*/
   static public tilda.data.ObjectPerf_Data Create(String schemaName, String objectName, ZonedDateTime startPeriod, ZonedDateTime endPeriod, long selectNano, long selectCount, long selectRecords, long insertNano, long insertCount, long insertRecords, long updateNano, long updateCount, long updateRecords, long deleteNano, long deleteCount, long deleteRecords) throws Exception
     {
       tilda.data._tilda.TILDA__OBJECTPERF Obj = new tilda.data.ObjectPerf_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setSchemaName   (schemaName   );
       Obj.setObjectName   (objectName   );
       Obj.setStartPeriod  (startPeriod  );
       Obj.setEndPeriod    (endPeriod    );
       Obj.setSelectNano   (selectNano   );
       Obj.setSelectCount  (selectCount  );
       Obj.setSelectRecords(selectRecords);
       Obj.setInsertNano   (insertNano   );
       Obj.setInsertCount  (insertCount  );
       Obj.setInsertRecords(insertRecords);
       Obj.setUpdateNano   (updateNano   );
       Obj.setUpdateCount  (updateCount  );
       Obj.setUpdateRecords(updateRecords);
       Obj.setDeleteNano   (deleteNano   );
       Obj.setDeleteCount  (deleteCount  );
       Obj.setDeleteRecords(deleteRecords);

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.ObjectPerf_Data) Obj;
     }

   static public tilda.data.ObjectPerf_Data Create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       String               _schemaName    =                       ParseUtil.parseString       ("schemaName"   , true , Values.get("schemaName"   ), Errors );
       String               _objectName    =                       ParseUtil.parseString       ("objectName"   , true , Values.get("objectName"   ), Errors );
       ZonedDateTime        _startPeriod   =                       ParseUtil.parseZonedDateTime("startPeriod"  , true , Values.get("startPeriod"  ), Errors );
       ZonedDateTime        _endPeriod     =                       ParseUtil.parseZonedDateTime("endPeriod"    , true , Values.get("endPeriod"    ), Errors );
       Long                 _selectNano    =                       ParseUtil.parseLong         ("selectNano"   , true , Values.get("selectNano"   ), Errors );
       Long                 _selectCount   =                       ParseUtil.parseLong         ("selectCount"  , true , Values.get("selectCount"  ), Errors );
       Long                 _selectRecords =                       ParseUtil.parseLong         ("selectRecords", true , Values.get("selectRecords"), Errors );
       Long                 _insertNano    =                       ParseUtil.parseLong         ("insertNano"   , true , Values.get("insertNano"   ), Errors );
       Long                 _insertCount   =                       ParseUtil.parseLong         ("insertCount"  , true , Values.get("insertCount"  ), Errors );
       Long                 _insertRecords =                       ParseUtil.parseLong         ("insertRecords", true , Values.get("insertRecords"), Errors );
       Long                 _updateNano    =                       ParseUtil.parseLong         ("updateNano"   , true , Values.get("updateNano"   ), Errors );
       Long                 _updateCount   =                       ParseUtil.parseLong         ("updateCount"  , true , Values.get("updateCount"  ), Errors );
       Long                 _updateRecords =                       ParseUtil.parseLong         ("updateRecords", true , Values.get("updateRecords"), Errors );
       Long                 _deleteNano    =                       ParseUtil.parseLong         ("deleteNano"   , true , Values.get("deleteNano"   ), Errors );
       Long                 _deleteCount   =                       ParseUtil.parseLong         ("deleteCount"  , true , Values.get("deleteCount"  ), Errors );
       Long                 _deleteRecords =                       ParseUtil.parseLong         ("deleteRecords", true , Values.get("deleteRecords"), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.ObjectPerf_Data Obj = tilda.data.ObjectPerf_Factory.Create(_schemaName, _objectName, _startPeriod, _endPeriod, _selectNano, _selectCount, _selectRecords, _insertNano, _insertCount, _insertRecords, _updateNano, _updateCount, _updateRecords, _deleteNano, _deleteCount, _deleteRecords);


      return Obj;
     }

   static public tilda.data.ObjectPerf_Data LookupByPrimaryKey(String schemaName, String objectName, ZonedDateTime startPeriod) throws Exception
     {
       tilda.data._tilda.TILDA__OBJECTPERF Obj = new tilda.data.ObjectPerf_Data();
       Obj.initForLookup(0);

       Obj.setSchemaName   (schemaName   ); Obj.__Saved_schemaName    = Obj._schemaName   ;
       Obj.setObjectName   (objectName   ); Obj.__Saved_objectName    = Obj._objectName   ;
       Obj.setStartPeriod  (startPeriod  ); Obj.__Saved_startPeriod   = Obj._startPeriod  ;

       return (tilda.data.ObjectPerf_Data) Obj;
     }

   static public ListResults<tilda.data.ObjectPerf_Data> LookupWhereSchemaByObjectStart(Connection C, String schemaName, int Start, int Size) throws Exception
     {
       tilda.data._tilda.TILDA__OBJECTPERF Obj = new tilda.data.ObjectPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );


       return ReadMany(C, 1, Obj, null, Start, Size);
     }


   static public ListResults<tilda.data.ObjectPerf_Data> LookupWhereSchemaObjectByStart(Connection C, String schemaName, String objectName, int Start, int Size) throws Exception
     {
       tilda.data._tilda.TILDA__OBJECTPERF Obj = new tilda.data.ObjectPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );
       Obj.setObjectName   (objectName   );


       return ReadMany(C, 2, Obj, null, Start, Size);
     }




   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C   , TILDA__OBJECTPERF_Factory.TABLENAME); }
   public static SelectQuery newWhereQuery (            ) throws Exception { return new SelectQuery(null, TILDA__OBJECTPERF_Factory.TABLENAME); }
   public static ListResults<tilda.data.ObjectPerf_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       return ReadMany(C, -7, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, TILDA__OBJECTPERF_Factory.TABLENAME); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, TILDA__OBJECTPERF_Factory.TABLENAME); }

 }
