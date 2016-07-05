
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
public class TILDA__ZONEINFO_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__ZONEINFO_Factory.class.getName());

   protected TILDA__ZONEINFO_Factory() { }

   public static final Class<TILDA__ZONEINFO> DATA_CLASS= TILDA__ZONEINFO.class;
   public static final String SCHEMA_LABEL = TextUtil.Print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.Print("ZONEINFO", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.Print("TILDA.ZONEINFO", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "ZONEINFO"); }

   protected static abstract class COLS {
     public static Type_StringPrimitive         ID           = new Type_StringPrimitive        (SCHEMA_LABEL, TABLENAME_LABEL, "id"           , 0, "The id for this enumeration.");
     public static Type_StringPrimitive         VALUE        = new Type_StringPrimitive        (SCHEMA_LABEL, TABLENAME_LABEL, "value"        , 1, "The value for this enumeration.");
     public static Type_StringPrimitive         LABEL        = new Type_StringPrimitive        (SCHEMA_LABEL, TABLENAME_LABEL, "label"        , 2, "The label for this enumeration.");
     public static Type_StringPrimitiveNull     DEACTIVATEDTZ= new Type_StringPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "deactivatedTZ", 3, "Generated helper column to hold the time zone ID for 'deactivated'.");
     public static Type_DatetimePrimitiveNull   DEACTIVATED  = new Type_DatetimePrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "deactivated"  , 4, "The label for this enumeration.");
     public static Type_DatetimePrimitive       CREATED      = new Type_DatetimePrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "created"      , 5, "The timestamp for when the record was created.");
     public static Type_DatetimePrimitive       LASTUPDATED  = new Type_DatetimePrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"  , 6, "The timestamp for when the record was last updated.");
     public static Type_DatetimePrimitiveNull   DELETED      = new Type_DatetimePrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"      , 7, "The timestamp for when the record was deleted.");
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
              initMappings(C);
              tilda.data.ZoneInfo_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.ZoneInfo_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.ZoneInfo_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.ZoneInfo_Data> _OP;
       protected ArrayListResults<tilda.data.ZoneInfo_Data> _L = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.ZoneInfo_Data Obj = new tilda.data.ZoneInfo_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__ZONEINFO)Obj).Init(_C, RS);
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

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__ZONEINFO Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "ZONEINFO", "id");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ZONEINFO", "value");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ZONEINFO", "label");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ZONEINFO", "deactivatedTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ZONEINFO", "deactivated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ZONEINFO", "created");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ZONEINFO", "lastUpdated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ZONEINFO", "deleted");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "ZONEINFO");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
             break;
          case 3:
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "ZONEINFO", "id"); S.append(" ASC");
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       LOG.debug("TILDA([7mTILDA.ZONEINFO[27m): "+Q);
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
             case 3: {
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__ZONEINFO_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
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
 @param id            (max size 5) The id for this enumeration.
 @param value         (max size 50) The value for this enumeration.
 @param label         (max size 254) The label for this enumeration.
*/
   static public tilda.data.ZoneInfo_Data Create(String id, String value, String label) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setId           (id           );
       Obj.setValue        (value        );
       Obj.setLabel        (label        );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.ZoneInfo_Data) Obj;
     }

   static public tilda.data.ZoneInfo_Data Create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       String        _id            =                       ParseUtil.parseString("id"           , true , Values.get("id"           ), Errors );
       String        _value         =                       ParseUtil.parseString("value"        , true , Values.get("value"        ), Errors );
       String        _label         =                       ParseUtil.parseString("label"        , true , Values.get("label"        ), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.ZoneInfo_Data Obj = tilda.data.ZoneInfo_Factory.Create(_id, _value, _label);


      return Obj;
     }

   static public tilda.data.ZoneInfo_Data LookupByPrimaryKey(String id) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForLookup(0);

       Obj.setId           (id           ); Obj.__Saved_id            = Obj._id           ;

       return (tilda.data.ZoneInfo_Data) Obj;
     }

   static public tilda.data.ZoneInfo_Data LookupById(String id) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForLookup(1);

       Obj.setId           (id           ); Obj.__Saved_id            = Obj._id           ;

       return (tilda.data.ZoneInfo_Data) Obj;
     }

   static public tilda.data.ZoneInfo_Data LookupByValue(String value) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForLookup(2);

       Obj.setValue        (value        ); 

       return (tilda.data.ZoneInfo_Data) Obj;
     }

   static public ListResults<tilda.data.ZoneInfo_Data> LookupWhereAll(Connection C, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 3, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.ZoneInfo_Data> OP, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 3, RPI, Obj, null, Start, Size);
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.ZoneInfo_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.ZoneInfo_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }

   protected static Map<String, tilda.data.ZoneInfo_Data> __ENUMERATIONS_BY_ID    = new HashMap<String, tilda.data.ZoneInfo_Data>();
   protected static Map<String, tilda.data.ZoneInfo_Data> __ENUMERATIONS_BY_VALUE = new HashMap<String, tilda.data.ZoneInfo_Data>();
   public static void initMappings(Connection C) throws Exception
     {
       __ENUMERATIONS_BY_ID   .clear();
       __ENUMERATIONS_BY_VALUE.clear();
       ListResults<tilda.data.ZoneInfo_Data> L = LookupWhereAll(C, 0, -1);
       for (tilda.data.ZoneInfo_Data obj : L)
        {
          __ENUMERATIONS_BY_ID   .put(obj.getId   (), obj);
          __ENUMERATIONS_BY_VALUE.put(obj.getValue(), obj);
        }
     }

   public static tilda.data.ZoneInfo_Data getEnumerationById(String Id)
     {
       return Id == null ? null : __ENUMERATIONS_BY_ID.get(Id);
     }

   public static tilda.data.ZoneInfo_Data getEnumerationByValue(String Value)
     {
       return Value == null ? null : __ENUMERATIONS_BY_VALUE.get(Value);
     }
 }
