
package tilda.data._Tilda;

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

@SuppressWarnings({ "unused" })
public class TILDA__TRANSPERF_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TRANSPERF_Factory.class.getName());

   protected TILDA__TRANSPERF_Factory() { }

   public static final Class<TILDA__TRANSPERF> DATA_CLASS= TILDA__TRANSPERF.class;
   public static final String SCHEMA_LABEL = TextUtil.Print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.Print("TRANSPERF", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.Print("TILDA.TRANSPERF", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "TRANSPERF"); }

   protected static abstract class COLS {
     public static Type_StringPrimitive         SCHEMANAME   = new Type_StringPrimitive        (SCHEMA_LABEL, TABLENAME_LABEL, "schemaName"   , 0, "The name of the schema tracked");
     public static Type_StringPrimitive         OBJECTNAME   = new Type_StringPrimitive        (SCHEMA_LABEL, TABLENAME_LABEL, "objectName"   , 1, "The name of the table/object tracked");
     public static Type_StringPrimitive         STARTPERIODTZ= new Type_StringPrimitive        (SCHEMA_LABEL, TABLENAME_LABEL, "startPeriodTZ", 2, "Generated helper column to hold the time zone ID for 'startPeriod'.");
     public static Type_DatetimePrimitive       STARTPERIOD  = new Type_DatetimePrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "startPeriod"  , 3, "The timestamp for when the record was created.");
     public static Type_StringPrimitive         ENDPERIODTZ  = new Type_StringPrimitive        (SCHEMA_LABEL, TABLENAME_LABEL, "endPeriodTZ"  , 4, "Generated helper column to hold the time zone ID for 'endPeriod'.");
     public static Type_DatetimePrimitive       ENDPERIOD    = new Type_DatetimePrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "endPeriod"    , 5, "The timestamp for when the record was created.");
     public static Type_LongPrimitive           COMMITNANO   = new Type_LongPrimitive          (SCHEMA_LABEL, TABLENAME_LABEL, "commitNano"   , 6, "Blah...");
     public static Type_LongPrimitive           COMMITCOUNT  = new Type_LongPrimitive          (SCHEMA_LABEL, TABLENAME_LABEL, "commitCount"  , 7, "Blah...");
     public static Type_LongPrimitive           ROLLBACKNANO = new Type_LongPrimitive          (SCHEMA_LABEL, TABLENAME_LABEL, "rollbackNano" , 8, "Blah...");
     public static Type_LongPrimitive           ROLLBACKCOUNT= new Type_LongPrimitive          (SCHEMA_LABEL, TABLENAME_LABEL, "rollbackCount", 9, "Blah...");
     public static Type_DatetimePrimitive       CREATED      = new Type_DatetimePrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "created"      , 10, "The timestamp for when the record was created.");
     public static Type_DatetimePrimitive       LASTUPDATED  = new Type_DatetimePrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"  , 11, "The timestamp for when the record was last updated.");
     public static Type_DatetimePrimitiveNull   DELETED      = new Type_DatetimePrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"      , 12, "The timestamp for when the record was deleted.");
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
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.TransPerf_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.TransPerf_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.TransPerf_Data> _OP;
       protected ArrayListResults<tilda.data.TransPerf_Data> _L = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.TransPerf_Data Obj = new tilda.data.TransPerf_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__TRANSPERF)Obj).Init(_C, RS);
          if (OK == true)
           {
             if (_OP == null)
              _L.add(Obj);
             else
              _OP.Process(Index, Obj);
           }
          return OK;
        }
     }

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__TRANSPERF Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "schemaName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "objectName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "startPeriodTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "startPeriod");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "endPeriodTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "endPeriod");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "commitNano");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "commitCount");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "rollbackNano");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "rollbackCount");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "created");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "lastUpdated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "deleted");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "TRANSPERF");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
             break;
          case 1:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "schemaName"); S.append("=?)");
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "objectName"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "startPeriod"); S.append(" DESC");
             break;
          case 2:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "schemaName"); S.append("=? AND "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "objectName"); S.append("=?)");
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "TRANSPERF", "startPeriod"); S.append(" DESC");
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       LOG.debug("TILDA([7mTILDA.TRANSPERF[27m): "+Q);
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
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

          count = JDBCHelper.Process(PS.executeQuery(), RP, Start, true, Size, true);
        }
       catch (java.sql.SQLException E)
        {
          tilda.data._Tilda.TILDA__1_0.HandleCatch(C, E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

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
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
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

       String        _schemaName    =                       ParseUtil.parseString("schemaName"   , true , Values.get("schemaName"   ), Errors );
       String        _objectName    =                       ParseUtil.parseString("objectName"   , true , Values.get("objectName"   ), Errors );
       ZonedDateTime        _startPeriod   =                       ParseUtil.parseZonedDateTime("startPeriod"  , true , Values.get("startPeriod"  ), Errors );
       ZonedDateTime        _endPeriod     =                       ParseUtil.parseZonedDateTime("endPeriod"    , true , Values.get("endPeriod"    ), Errors );
       Long        _commitNano    =                       ParseUtil.parseLong("commitNano"   , true , Values.get("commitNano"   ), Errors );
       Long        _commitCount   =                       ParseUtil.parseLong("commitCount"  , true , Values.get("commitCount"  ), Errors );
       Long        _rollbackNano  =                       ParseUtil.parseLong("rollbackNano" , true , Values.get("rollbackNano" ), Errors );
       Long        _rollbackCount =                       ParseUtil.parseLong("rollbackCount", true , Values.get("rollbackCount"), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.TransPerf_Data Obj = tilda.data.TransPerf_Factory.Create(_schemaName, _objectName, _startPeriod, _endPeriod, _commitNano, _commitCount, _rollbackNano, _rollbackCount);


      return Obj;
     }

   static public tilda.data.TransPerf_Data LookupByPrimaryKey(String schemaName, String objectName, ZonedDateTime startPeriod) throws Exception
     {
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(0);

       Obj.setSchemaName   (schemaName   ); Obj.__Saved_schemaName    = Obj._schemaName   ;
       Obj.setObjectName   (objectName   ); Obj.__Saved_objectName    = Obj._objectName   ;
       Obj.setStartPeriod  (startPeriod  ); Obj.__Saved_startPeriod   = Obj._startPeriod  ;

       return (tilda.data.TransPerf_Data) Obj;
     }

   static public ListResults<tilda.data.TransPerf_Data> LookupWhereAllBySchemaName(Connection C, String schemaName, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 1, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAllBySchemaName(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.TransPerf_Data> OP, String schemaName, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 1, RPI, Obj, null, Start, Size);
     }


   static public ListResults<tilda.data.TransPerf_Data> LookupWhereAllByObjectName(Connection C, String schemaName, String objectName, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );
       Obj.setObjectName   (objectName   );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 2, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAllByObjectName(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.TransPerf_Data> OP, String schemaName, String objectName, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );
       Obj.setObjectName   (objectName   );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 2, RPI, Obj, null, Start, Size);
     }




   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.TransPerf_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.TransPerf_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }

 }
