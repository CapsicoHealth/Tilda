
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
public class TILDA__TESTING_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTING_Factory.class.getName());

   protected TILDA__TESTING_Factory() { }

   public static final Class<TILDA__TESTING> DATA_CLASS= TILDA__TESTING.class;
   public static final String SCHEMA_LABEL = TextUtil.Print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.Print("TESTING", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.Print("TILDA.TESTING", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "TESTING"); }

   protected static abstract class COLS {
     public static Type_LongPrimitive           REFNUM     = new Type_LongPrimitive          (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"     , 0, "The primary key for this record");
     public static Type_LongCollection         REFNUM2    = new Type_LongCollection        (SCHEMA_LABEL, TABLENAME_LABEL, "refnum2"    , 1, "The person's primary key");
     public static Type_StringPrimitive         NAME       = new Type_StringPrimitive        (SCHEMA_LABEL, TABLENAME_LABEL, "name"       , 2, "Medical system unique enterprise id");
     public static Type_StringPrimitiveNull     DESCRIPTION= new Type_StringPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "description", 3, "The title for a person, i.e., Mr, Miss, Mrs...");
     public static Type_StringPrimitiveNull     DESC2      = new Type_StringPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "desc2"      , 4, "The title for a person, i.e., Mr, Miss, Mrs...");
     public static Type_StringPrimitiveNull     DESC3      = new Type_StringPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "desc3"      , 5, "The title for a person, i.e., Mr, Miss, Mrs...");
     public static Type_StringPrimitiveNull     DESC4      = new Type_StringPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "desc4"      , 6, "The title for a person, i.e., Mr, Miss, Mrs...");
     public static Type_StringPrimitiveNull     DESC5      = new Type_StringPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "desc5"      , 7, "The title for a person, i.e., Mr, Miss, Mrs...");
     public static Type_StringPrimitiveNull     DESC6      = new Type_StringPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "desc6"      , 8, "The title for a person, i.e., Mr, Miss, Mrs...");
     public static Type_StringCollectionNull   TOPS       = new Type_StringCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "tops"       , 9, "The blah");
     public static Type_StringCollectionNull   TOPS2      = new Type_StringCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "tops2"      , 10, "The blah");
     public static Type_BitfieldPrimitiveNull   A1         = new Type_BitfieldPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a1"         , 11, "The blah");
     public static Type_CharPrimitiveNull       A2         = new Type_CharPrimitiveNull      (SCHEMA_LABEL, TABLENAME_LABEL, "a2"         , 12, "The blah");
     public static Type_CharCollectionNull     A2B        = new Type_CharCollectionNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a2b"        , 13, "The blah");
     public static Type_CharCollectionNull     A2C        = new Type_CharCollectionNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a2c"        , 14, "The blah");
     public static Type_BooleanPrimitiveNull    A3         = new Type_BooleanPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a3"         , 15, "The blah");
     public static Type_BooleanCollectionNull  A3B        = new Type_BooleanCollectionNull (SCHEMA_LABEL, TABLENAME_LABEL, "a3b"        , 16, "The blah");
     public static Type_DoublePrimitiveNull     A4         = new Type_DoublePrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a4"         , 17, "The blah");
     public static Type_DoubleCollectionNull   A4B        = new Type_DoubleCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a4b"        , 18, "The blah");
     public static Type_FloatPrimitiveNull      A5         = new Type_FloatPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "a5"         , 19, "The blah");
     public static Type_FloatCollectionNull    A5B        = new Type_FloatCollectionNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a5b"        , 20, "The blah");
     public static Type_LongPrimitiveNull       A6         = new Type_LongPrimitiveNull      (SCHEMA_LABEL, TABLENAME_LABEL, "a6"         , 21, "The blah");
     public static Type_LongCollectionNull     A6B        = new Type_LongCollectionNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a6b"        , 22, "The blah");
     public static Type_LongCollectionNull     A6C        = new Type_LongCollectionNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a6c"        , 23, "The blah");
     public static Type_IntegerPrimitiveNull    A7         = new Type_IntegerPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a7"         , 24, "The blah");
     public static Type_IntegerCollectionNull  A7B        = new Type_IntegerCollectionNull (SCHEMA_LABEL, TABLENAME_LABEL, "a7b"        , 25, "The blah");
     public static Type_BinaryPrimitiveNull     A8         = new Type_BinaryPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a8"         , 26, "The blah");
     public static Type_StringPrimitiveNull     A9TZ       = new Type_StringPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a9TZ"       , 27, "Generated helper column to hold the time zone ID for 'a9'.");
     public static Type_DatetimePrimitiveNull   A9         = new Type_DatetimePrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a9"         , 28, "The blah");
     public static Type_DatetimePrimitive       CREATED    = new Type_DatetimePrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "created"    , 29, "The timestamp for when the record was created.");
     public static Type_DatetimePrimitive       LASTUPDATED= new Type_DatetimePrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated", 30, "The timestamp for when the record was last updated.");
     public static Type_DatetimePrimitiveNull   DELETED    = new Type_DatetimePrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"    , 31, "The timestamp for when the record was deleted.");
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
              tilda.data.Testing_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.Testing_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> _OP;
       protected ArrayListResults<tilda.data.Testing_Data> _L = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.Testing_Data Obj = new tilda.data.Testing_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__TESTING)Obj).Init(_C, RS);
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

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__TESTING Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "TESTING", "refnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "refnum2");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "name");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "description");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "desc2");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "desc3");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "desc4");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "desc5");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "desc6");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "tops");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "tops2");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a1");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a2");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a2b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a2c");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a3");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a3b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a4");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a4b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a5");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a5b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a6");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a6b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a6c");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a7");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a7b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a8");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a9TZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "a9");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "created");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "lastUpdated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TESTING", "deleted");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "TESTING");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
             break;
          case 1:
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "TESTING", "name"); S.append(" ASC");
             break;
          case 2:
             S.append(", TILDA.OBJECTPERF"); // Additional From's from the subwhereclause.
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "TESTING", "deleted"); S.append(" is null and "); C.getFullColumnVar(S, "TILDA", "TESTING", "desc2"); S.append(" >= ").append("?").append(" and "); C.getFullColumnVar(S, "TILDA", "TESTING", "a5"); S.append(" < ").append("?").append(" or "); C.getFullColumnVar(S, "TILDA", "TESTING", "name"); S.append(" = ").append("?").append(" and "); C.getFullColumnVar(S, "TILDA", "TESTING", "created"); S.append(" > ").append("?").append(")");
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "TESTING", "name"); S.append(" ASC");
             break;
          case 3:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "TESTING", "deleted"); S.append(" is null and "); C.getFullColumnVar(S, "TILDA", "TESTING", "name"); S.append(" = ").append("?").append(" and "); C.getFullColumnVar(S, "TILDA", "TESTING", "created"); S.append(" > ").append("?").append(")");
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "TESTING", "name"); S.append(" ASC");
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       LOG.debug("TILDA([7mTILDA.TESTING[27m): "+Q);
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
               break;
             }
             case 2: {
               LookupWhereAllByName2Params P = (LookupWhereAllByName2Params) ExtraParams;
               LOG.debug("  " + P.toString());
               if (P._desc2Lower==null) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, P._desc2Lower      );
               PS.setFloat    (++i, P._a5Upper         );
               if (P._name==null) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, P._name       );
               if (P._created==null) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else PS.setTimestamp(++i, new java.sql.Timestamp(P._created.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
               break;
             }
             case 3: {
               LookupWhereAllByName3Params P = (LookupWhereAllByName3Params) ExtraParams;
               LOG.debug("  " + P.toString());
               if (P._name==null) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, P._name       );
               if (P._created==null) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else PS.setTimestamp(++i, new java.sql.Timestamp(P._created.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TESTING_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
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
 @param refnum2     The person's primary key
 @param name        (max size 10) Medical system unique enterprise id
*/
   static public tilda.data.Testing_Data Create(List<Long> refnum2, String name) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDA.TESTING"));

       // Explicit setters
       Obj.setRefnum2    (refnum2    );
       Obj.setName       (name       );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.Testing_Data) Obj;
     }

   static public tilda.data.Testing_Data Create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       Long        _refnum      =                       ParseUtil.parseLong("refnum"     , true , Values.get("refnum"     ), Errors );
       List<Long>  _refnum2     = CollectionUtil.toList(ParseUtil.parseLong("refnum2"    , true , Values.get("refnum2"    ), "``", Errors));
       String        _name        =                       ParseUtil.parseString("name"       , true , Values.get("name"       ), Errors );
       String        _description =                       ParseUtil.parseString("description", false, Values.get("description"), Errors );
       String        _desc2       =                       ParseUtil.parseString("desc2"      , false, Values.get("desc2"      ), Errors );
       String        _desc3       =                       ParseUtil.parseString("desc3"      , false, Values.get("desc3"      ), Errors );
       String        _desc4       =                       ParseUtil.parseString("desc4"      , false, Values.get("desc4"      ), Errors );
       String        _desc5       =                       ParseUtil.parseString("desc5"      , false, Values.get("desc5"      ), Errors );
       String        _desc6       =                       ParseUtil.parseString("desc6"      , false, Values.get("desc6"      ), Errors );
       List<String>  _tops        = CollectionUtil.toList(ParseUtil.parseString("tops"       , false, Values.get("tops"       ), ",", Errors));
       Set <String>  _tops2       = CollectionUtil.toSet (ParseUtil.parseString("tops2"      , false, Values.get("tops2"      ), ",", Errors));
       Integer        _a1          =                       ParseUtil.parseInteger("a1"         , false, Values.get("a1"         ), Errors );
       Character        _a2          =                       ParseUtil.parseCharacter("a2"         , false, Values.get("a2"         ), Errors );
       List<Character>  _a2b         = CollectionUtil.toList(ParseUtil.parseCharacter("a2b"        , false, Values.get("a2b"        ), ",", Errors));
       Set <Character>  _a2c         = CollectionUtil.toSet (ParseUtil.parseCharacter("a2c"        , false, Values.get("a2c"        ), ",", Errors));
       Boolean        _a3          =                       ParseUtil.parseBoolean("a3"         , false, Values.get("a3"         ), Errors );
       List<Boolean>  _a3b         = CollectionUtil.toList(ParseUtil.parseBoolean("a3b"        , false, Values.get("a3b"        ), ",", Errors));
       Double        _a4          =                       ParseUtil.parseDouble("a4"         , false, Values.get("a4"         ), Errors );
       List<Double>  _a4b         = CollectionUtil.toList(ParseUtil.parseDouble("a4b"        , false, Values.get("a4b"        ), ",", Errors));
       Float        _a5          =                       ParseUtil.parseFloat("a5"         , false, Values.get("a5"         ), Errors );
       List<Float>  _a5b         = CollectionUtil.toList(ParseUtil.parseFloat("a5b"        , false, Values.get("a5b"        ), ",", Errors));
       Long        _a6          =                       ParseUtil.parseLong("a6"         , false, Values.get("a6"         ), Errors );
       List<Long>  _a6b         = CollectionUtil.toList(ParseUtil.parseLong("a6b"        , false, Values.get("a6b"        ), ",", Errors));
       Set <Long>  _a6c         = CollectionUtil.toSet (ParseUtil.parseLong("a6c"        , false, Values.get("a6c"        ), ",", Errors));
       Integer        _a7          =                       ParseUtil.parseInteger("a7"         , false, Values.get("a7"         ), Errors );
       List<Integer>  _a7b         = CollectionUtil.toList(ParseUtil.parseInteger("a7b"        , false, Values.get("a7b"        ), ",", Errors));
       if (Values.get("a8") != null)
        Errors.add(new StringStringPair("a8", "Parameter is of a binary type and cannot be passed as a string value."));
       ZonedDateTime        _a9          =                       ParseUtil.parseZonedDateTime("a9"         , false, Values.get("a9"         ), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.Testing_Data Obj = tilda.data.Testing_Factory.Create(_refnum2, _name);

      if (_refnum     != null) Obj.setRefnum     (_refnum     );
      if (_description!= null) Obj.setDescription(_description);
      if (_desc2      != null) Obj.setDesc2      (_desc2      );
      if (_desc3      != null) Obj.setDesc3      (_desc3      );
      if (_desc4      != null) Obj.setDesc4      (_desc4      );
      if (_desc5      != null) Obj.setDesc5      (_desc5      );
      if (_desc6      != null) Obj.setDesc6      (_desc6      );
      if (_tops       != null) Obj.setTops       (_tops       );
      if (_tops2      != null) Obj.setTops2      (_tops2      );
      if (_a1         != null) Obj.setA1         (_a1         );
      if (_a2         != null) Obj.setA2         (_a2         );
      if (_a2b        != null) Obj.setA2b        (_a2b        );
      if (_a2c        != null) Obj.setA2c        (_a2c        );
      if (_a3         != null) Obj.setA3         (_a3         );
      if (_a3b        != null) Obj.setA3b        (_a3b        );
      if (_a4         != null) Obj.setA4         (_a4         );
      if (_a4b        != null) Obj.setA4b        (_a4b        );
      if (_a5         != null) Obj.setA5         (_a5         );
      if (_a5b        != null) Obj.setA5b        (_a5b        );
      if (_a6         != null) Obj.setA6         (_a6         );
      if (_a6b        != null) Obj.setA6b        (_a6b        );
      if (_a6c        != null) Obj.setA6c        (_a6c        );
      if (_a7         != null) Obj.setA7         (_a7         );
      if (_a7b        != null) Obj.setA7b        (_a7b        );
      if (_a9         != null) Obj.setA9         (_a9         );

      return Obj;
     }

   static public tilda.data.Testing_Data LookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(0);

       Obj.setRefnum     (refnum     ); Obj.__Saved_refnum      = Obj._refnum     ;

       return (tilda.data.Testing_Data) Obj;
     }

   static public ListResults<tilda.data.Testing_Data> LookupWhereAllByName(Connection C, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 1, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAllByName(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 1, RPI, Obj, null, Start, Size);
     }


   static public ListResults<tilda.data.Testing_Data> LookupWhereAllByName2(Connection C, String desc2Lower, float a5Upper, String name, ZonedDateTime created, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       LookupWhereAllByName2Params P = new LookupWhereAllByName2Params(desc2Lower, a5Upper, name, created);

       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 2, RPI, Obj, P, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAllByName2(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP, String desc2Lower, float a5Upper, String name, ZonedDateTime created, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       LookupWhereAllByName2Params P = new LookupWhereAllByName2Params(desc2Lower, a5Upper, name, created);

       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 2, RPI, Obj, P, Start, Size);
     }

    private static class LookupWhereAllByName2Params
     {
       protected LookupWhereAllByName2Params(String desc2Lower, float a5Upper, String name, ZonedDateTime created)
         {
           _desc2Lower = desc2Lower;
           _a5Upper = a5Upper;
           _name = name;
           _created = created;
         }
        protected final String _desc2Lower;
        protected final float _a5Upper;
        protected final String _name;
        protected final ZonedDateTime _created;
       public String toString()
        {
          long T0 = System.nanoTime();
          String Str = ""
                  + "desc2Lower: " + _desc2Lower + ";"
                  + "a5Upper: " + _a5Upper + ";"
                  + "name: " + _name + ";"
                  + "created: " + _created + ";"
                 ; 
          PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
          return Str;
        }
     }

   static public ListResults<tilda.data.Testing_Data> LookupWhereAllByName3(Connection C, String name, ZonedDateTime created, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       LookupWhereAllByName3Params P = new LookupWhereAllByName3Params(name, created);

       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 3, RPI, Obj, P, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAllByName3(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP, String name, ZonedDateTime created, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       LookupWhereAllByName3Params P = new LookupWhereAllByName3Params(name, created);

       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 3, RPI, Obj, P, Start, Size);
     }

    private static class LookupWhereAllByName3Params
     {
       protected LookupWhereAllByName3Params(String name, ZonedDateTime created)
         {
           _name = name;
           _created = created;
         }
        protected final String _name;
        protected final ZonedDateTime _created;
       public String toString()
        {
          long T0 = System.nanoTime();
          String Str = ""
                  + "name: " + _name + ";"
                  + "created: " + _created + ";"
                 ; 
          PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
          return Str;
        }
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.Testing_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }

 }
