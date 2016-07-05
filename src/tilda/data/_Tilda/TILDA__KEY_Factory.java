
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
public class TILDA__KEY_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__KEY_Factory.class.getName());

   protected TILDA__KEY_Factory() { }

   public static final Class<TILDA__KEY> DATA_CLASS= TILDA__KEY.class;
   public static final String SCHEMA_LABEL = TextUtil.Print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.Print("KEY", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.Print("TILDA.KEY", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "KEY"); }

   protected static abstract class COLS {
     public static Type_LongPrimitive           REFNUM     = new Type_LongPrimitive          (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"     , 0, "The primary key for this record");
     public static Type_StringPrimitive         NAME       = new Type_StringPrimitive        (SCHEMA_LABEL, TABLENAME_LABEL, "name"       , 1, "The name of the table/object tracked");
     public static Type_LongPrimitive           MAX        = new Type_LongPrimitive          (SCHEMA_LABEL, TABLENAME_LABEL, "max"        , 2, "The pre-allocated max RefNum for this table/object.");
     public static Type_IntegerPrimitive        COUNT      = new Type_IntegerPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "count"      , 3, "The size of the pre-allocation required by this table/object.");
     public static Type_DatetimePrimitive       CREATED    = new Type_DatetimePrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "created"    , 4, "The timestamp for when the record was created.");
     public static Type_DatetimePrimitive       LASTUPDATED= new Type_DatetimePrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated", 5, "The timestamp for when the record was last updated.");
     public static Type_DatetimePrimitiveNull   DELETED    = new Type_DatetimePrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"    , 6, "The timestamp for when the record was deleted.");
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
              tilda.data.Key_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.Key_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Key_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.Key_Data> _OP;
       protected ArrayListResults<tilda.data.Key_Data> _L = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.Key_Data Obj = new tilda.data.Key_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__KEY)Obj).Init(_C, RS);
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

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__KEY Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "KEY", "refnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "KEY", "name");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "KEY", "max");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "KEY", "count");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "KEY", "created");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "KEY", "lastUpdated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "KEY", "deleted");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "KEY");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
             break;
          case 2:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "KEY", "deleted"); S.append(" is null)");
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "KEY", "name"); S.append(" ASC");
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       LOG.debug("TILDA([7mTILDA.KEY[27m): "+Q);
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
             case 2: {
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__KEY_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
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
 @param refnum      The primary key for this record
 @param name        (max size 128) The name of the table/object tracked
 @param max         The pre-allocated max RefNum for this table/object.
 @param count       The size of the pre-allocation required by this table/object.
*/
   static public tilda.data.Key_Data Create(long refnum, String name, long max, int count) throws Exception
     {
       tilda.data._Tilda.TILDA__KEY Obj = new tilda.data.Key_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setRefnum     (refnum     );
       Obj.setName       (name       );
       Obj.setMax        (max        );
       Obj.setCount      (count      );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.Key_Data) Obj;
     }

   static public tilda.data.Key_Data Create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       Long        _refnum      =                       ParseUtil.parseLong("refnum"     , true , Values.get("refnum"     ), Errors );
       String        _name        =                       ParseUtil.parseString("name"       , true , Values.get("name"       ), Errors );
       Long        _max         =                       ParseUtil.parseLong("max"        , true , Values.get("max"        ), Errors );
       Integer        _count       =                       ParseUtil.parseInteger("count"      , true , Values.get("count"      ), Errors );
       ZonedDateTime        _deleted     =                       ParseUtil.parseZonedDateTime("deleted"    , false, Values.get("deleted"    ), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.Key_Data Obj = tilda.data.Key_Factory.Create(_refnum, _name, _max, _count);

      if (_deleted    != null) Obj.setDeleted    (_deleted    );

      return Obj;
     }

   static public tilda.data.Key_Data LookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__KEY Obj = new tilda.data.Key_Data();
       Obj.initForLookup(0);

       Obj.setRefnum     (refnum     ); Obj.__Saved_refnum      = Obj._refnum     ;

       return (tilda.data.Key_Data) Obj;
     }

   static public tilda.data.Key_Data LookupByName(String name) throws Exception
     {
       tilda.data._Tilda.TILDA__KEY Obj = new tilda.data.Key_Data();
       Obj.initForLookup(1);

       Obj.setName       (name       ); 

       return (tilda.data.Key_Data) Obj;
     }

   static public ListResults<tilda.data.Key_Data> LookupWhereAllByName(Connection C, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__KEY Obj = new tilda.data.Key_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 2, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAllByName(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Key_Data> OP, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__KEY Obj = new tilda.data.Key_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 2, RPI, Obj, null, Start, Size);
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.Key_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.Key_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }

 }
