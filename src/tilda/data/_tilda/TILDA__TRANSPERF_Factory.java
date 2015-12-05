
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
public class TILDA__TRANSPERF_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TRANSPERF_Factory.class.getName());

   protected TILDA__TRANSPERF_Factory() { }

   public static final String TABLENAME = TextUtil.Print("TILDA.TRANSPERF", "");

   protected static abstract class COLS {
     public static Type_StringPrimitive         SCHEMANAME   = new Type_StringPrimitive        ("TILDA.TRANSPERF", "schemaName"   , 0);
     public static Type_StringPrimitive         OBJECTNAME   = new Type_StringPrimitive        ("TILDA.TRANSPERF", "objectName"   , 1);
     public static Type_StringPrimitive         STARTPERIODTZ= new Type_StringPrimitive        ("TILDA.TRANSPERF", "startPeriodTZ", 2);
     public static Type_DatetimePrimitive       STARTPERIOD  = new Type_DatetimePrimitive      ("TILDA.TRANSPERF", "startPeriod"  , 3);
     public static Type_StringPrimitive         ENDPERIODTZ  = new Type_StringPrimitive        ("TILDA.TRANSPERF", "endPeriodTZ"  , 4);
     public static Type_DatetimePrimitive       ENDPERIOD    = new Type_DatetimePrimitive      ("TILDA.TRANSPERF", "endPeriod"    , 5);
     public static Type_LongPrimitive           COMMITNANO   = new Type_LongPrimitive          ("TILDA.TRANSPERF", "commitNano"   , 6);
     public static Type_LongPrimitive           COMMITCOUNT  = new Type_LongPrimitive          ("TILDA.TRANSPERF", "commitCount"  , 7);
     public static Type_LongPrimitive           ROLLBACKNANO = new Type_LongPrimitive          ("TILDA.TRANSPERF", "rollbackNano" , 8);
     public static Type_LongPrimitive           ROLLBACKCOUNT= new Type_LongPrimitive          ("TILDA.TRANSPERF", "rollbackCount", 9);
     public static Type_DatetimePrimitive       CREATED      = new Type_DatetimePrimitive      ("TILDA.TRANSPERF", "created"      , 10);
     public static Type_DatetimePrimitive       LASTUPDATED  = new Type_DatetimePrimitive      ("TILDA.TRANSPERF", "lastUpdated"  , 11);
     public static Type_DatetimePrimitiveNull   DELETED      = new Type_DatetimePrimitiveNull  ("TILDA.TRANSPERF", "deleted"      , 12);
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
              tilda.data.TransPerf_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorList implements RecordProcessor
     {
       public RecordProcessorList(Connection C, int Start)
         {
           _L = new ArrayListResults<tilda.data.TransPerf_Data>(Start);
           _C = C;
         }
       protected ArrayListResults<tilda.data.TransPerf_Data> _L = null;
       protected Connection _C = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.TransPerf_Data Obj = new tilda.data.TransPerf_Data();
          boolean OK = ((tilda.data._tilda.TILDA__TRANSPERF)Obj).Init(_C, RS);
          if (OK == true)
           _L.add(Obj);
          return OK;
        }
     }

   private static final ListResults<tilda.data.TransPerf_Data> ReadMany(Connection C, int LookupId, tilda.data._tilda.TILDA__TRANSPERF Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select TILDA.TRANSPERF.\"schemaName\", TILDA.TRANSPERF.\"objectName\", TILDA.TRANSPERF.\"startPeriodTZ\", TILDA.TRANSPERF.\"startPeriod\", TILDA.TRANSPERF.\"endPeriodTZ\", TILDA.TRANSPERF.\"endPeriod\", TILDA.TRANSPERF.\"commitNano\", TILDA.TRANSPERF.\"commitCount\", TILDA.TRANSPERF.\"rollbackNano\", TILDA.TRANSPERF.\"rollbackCount\", TILDA.TRANSPERF.\"created\", TILDA.TRANSPERF.\"lastUpdated\", TILDA.TRANSPERF.\"deleted\" from TILDA.TRANSPERF");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(" where ").append(clause);
             break;
          case 1:
             S.append(" where (TILDA.TRANSPERF.\"schemaName\"=?)");
             S.append(" order by TILDA.TRANSPERF.\"objectName\" ASC, TILDA.TRANSPERF.\"startPeriod\" DESC");
             break;
          case 2:
             S.append(" where (TILDA.TRANSPERF.\"schemaName\"=? AND TILDA.TRANSPERF.\"objectName\"=?)");
             S.append(" order by TILDA.TRANSPERF.\"startPeriod\" DESC");
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TABLENAME, Q);
       LOG.debug("TILDA([7mTILDA.TRANSPERF[27m): "+Q.replaceAll(TABLENAME+"\\.",""));
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
          tilda.data._tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TRANSPERF_Factory.TABLENAME, StatementType.SELECT, count, AllocatedArrays);
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
 @param commitNano    Blah...
 @param commitCount   Blah...
 @param rollbackNano  Blah...
 @param rollbackCount Blah...
*/
   static public tilda.data.TransPerf_Data Create(String schemaName, String objectName, ZonedDateTime startPeriod, ZonedDateTime endPeriod, long commitNano, long commitCount, long rollbackNano, long rollbackCount) throws Exception
     {
       tilda.data._tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setSchemaName   (schemaName   );
       Obj.setObjectName   (objectName   );
       Obj.setStartPeriod  (startPeriod  );
       Obj.setEndPeriod    (endPeriod    );
       Obj.setCommitNano   (commitNano   );
       Obj.setCommitCount  (commitCount  );
       Obj.setRollbackNano (rollbackNano );
       Obj.setRollbackCount(rollbackCount);

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.TransPerf_Data) Obj;
     }

   static public tilda.data.TransPerf_Data Create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       String               _schemaName    =                       ParseUtil.parseString       ("schemaName"   , true , Values.get("schemaName"   ), Errors );
       String               _objectName    =                       ParseUtil.parseString       ("objectName"   , true , Values.get("objectName"   ), Errors );
       ZonedDateTime        _startPeriod   =                       ParseUtil.parseZonedDateTime("startPeriod"  , true , Values.get("startPeriod"  ), Errors );
       ZonedDateTime        _endPeriod     =                       ParseUtil.parseZonedDateTime("endPeriod"    , true , Values.get("endPeriod"    ), Errors );
       Long                 _commitNano    =                       ParseUtil.parseLong         ("commitNano"   , true , Values.get("commitNano"   ), Errors );
       Long                 _commitCount   =                       ParseUtil.parseLong         ("commitCount"  , true , Values.get("commitCount"  ), Errors );
       Long                 _rollbackNano  =                       ParseUtil.parseLong         ("rollbackNano" , true , Values.get("rollbackNano" ), Errors );
       Long                 _rollbackCount =                       ParseUtil.parseLong         ("rollbackCount", true , Values.get("rollbackCount"), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.TransPerf_Data Obj = tilda.data.TransPerf_Factory.Create(_schemaName, _objectName, _startPeriod, _endPeriod, _commitNano, _commitCount, _rollbackNano, _rollbackCount);


      return Obj;
     }

   static public tilda.data.TransPerf_Data LookupByPrimaryKey(String schemaName, String objectName, ZonedDateTime startPeriod) throws Exception
     {
       tilda.data._tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(0);

       Obj.setSchemaName   (schemaName   ); Obj.__Saved_schemaName    = Obj._schemaName   ;
       Obj.setObjectName   (objectName   ); Obj.__Saved_objectName    = Obj._objectName   ;
       Obj.setStartPeriod  (startPeriod  ); Obj.__Saved_startPeriod   = Obj._startPeriod  ;

       return (tilda.data.TransPerf_Data) Obj;
     }

   static public ListResults<tilda.data.TransPerf_Data> LookupWhereAllBySchemaName(Connection C, String schemaName, int Start, int Size) throws Exception
     {
       tilda.data._tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );


       return ReadMany(C, 1, Obj, null, Start, Size);
     }


   static public ListResults<tilda.data.TransPerf_Data> LookupWhereAllByObjectName(Connection C, String schemaName, String objectName, int Start, int Size) throws Exception
     {
       tilda.data._tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );
       Obj.setObjectName   (objectName   );


       return ReadMany(C, 2, Obj, null, Start, Size);
     }




   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C   , TILDA__TRANSPERF_Factory.TABLENAME); }
   public static SelectQuery newWhereQuery (            ) throws Exception { return new SelectQuery(null, TILDA__TRANSPERF_Factory.TABLENAME); }
   public static ListResults<tilda.data.TransPerf_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       return ReadMany(C, -7, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, TILDA__TRANSPERF_Factory.TABLENAME); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, TILDA__TRANSPERF_Factory.TABLENAME); }

 }
