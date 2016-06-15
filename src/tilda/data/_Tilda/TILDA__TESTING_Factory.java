
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

   public static final String TABLENAME = TextUtil.Print("TILDA.TESTING", "");

   protected static abstract class COLS {
     public static Type_LongPrimitive           REFNUM     = new Type_LongPrimitive          ("TILDA.TESTING", "refnum"     , 0);
     public static Type_LongCollection         REFNUM2    = new Type_LongCollection        ("TILDA.TESTING", "refnum2"    , 1);
     public static Type_StringPrimitive         NAME       = new Type_StringPrimitive        ("TILDA.TESTING", "name"       , 2);
     public static Type_StringPrimitiveNull     DESCRIPTION= new Type_StringPrimitiveNull    ("TILDA.TESTING", "description", 3);
     public static Type_StringPrimitiveNull     DESC2      = new Type_StringPrimitiveNull    ("TILDA.TESTING", "desc2"      , 4);
     public static Type_StringPrimitiveNull     DESC3      = new Type_StringPrimitiveNull    ("TILDA.TESTING", "desc3"      , 5);
     public static Type_StringPrimitiveNull     DESC4      = new Type_StringPrimitiveNull    ("TILDA.TESTING", "desc4"      , 6);
     public static Type_StringPrimitiveNull     DESC5      = new Type_StringPrimitiveNull    ("TILDA.TESTING", "desc5"      , 7);
     public static Type_StringPrimitiveNull     DESC6      = new Type_StringPrimitiveNull    ("TILDA.TESTING", "desc6"      , 8);
     public static Type_StringCollectionNull   TOPS       = new Type_StringCollectionNull  ("TILDA.TESTING", "tops"       , 9);
     public static Type_StringCollectionNull   TOPS2      = new Type_StringCollectionNull  ("TILDA.TESTING", "tops2"      , 10);
     public static Type_BitfieldPrimitiveNull   A1         = new Type_BitfieldPrimitiveNull  ("TILDA.TESTING", "a1"         , 11);
     public static Type_CharPrimitiveNull       A2         = new Type_CharPrimitiveNull      ("TILDA.TESTING", "a2"         , 12);
     public static Type_CharCollectionNull     A2B        = new Type_CharCollectionNull    ("TILDA.TESTING", "a2b"        , 13);
     public static Type_CharCollectionNull     A2C        = new Type_CharCollectionNull    ("TILDA.TESTING", "a2c"        , 14);
     public static Type_BooleanPrimitiveNull    A3         = new Type_BooleanPrimitiveNull   ("TILDA.TESTING", "a3"         , 15);
     public static Type_BooleanCollectionNull  A3B        = new Type_BooleanCollectionNull ("TILDA.TESTING", "a3b"        , 16);
     public static Type_DoublePrimitiveNull     A4         = new Type_DoublePrimitiveNull    ("TILDA.TESTING", "a4"         , 17);
     public static Type_DoubleCollectionNull   A4B        = new Type_DoubleCollectionNull  ("TILDA.TESTING", "a4b"        , 18);
     public static Type_FloatPrimitiveNull      A5         = new Type_FloatPrimitiveNull     ("TILDA.TESTING", "a5"         , 19);
     public static Type_FloatCollectionNull    A5B        = new Type_FloatCollectionNull   ("TILDA.TESTING", "a5b"        , 20);
     public static Type_LongPrimitiveNull       A6         = new Type_LongPrimitiveNull      ("TILDA.TESTING", "a6"         , 21);
     public static Type_LongCollectionNull     A6B        = new Type_LongCollectionNull    ("TILDA.TESTING", "a6b"        , 22);
     public static Type_LongCollectionNull     A6C        = new Type_LongCollectionNull    ("TILDA.TESTING", "a6c"        , 23);
     public static Type_IntegerPrimitiveNull    A7         = new Type_IntegerPrimitiveNull   ("TILDA.TESTING", "a7"         , 24);
     public static Type_IntegerCollectionNull  A7B        = new Type_IntegerCollectionNull ("TILDA.TESTING", "a7b"        , 25);
     public static Type_BinaryPrimitiveNull     A8         = new Type_BinaryPrimitiveNull    ("TILDA.TESTING", "a8"         , 26);
     public static Type_StringPrimitiveNull     A9TZ       = new Type_StringPrimitiveNull    ("TILDA.TESTING", "a9TZ"       , 27);
     public static Type_DatetimePrimitiveNull   A9         = new Type_DatetimePrimitiveNull  ("TILDA.TESTING", "a9"         , 28);
     public static Type_DatetimePrimitive       CREATED    = new Type_DatetimePrimitive      ("TILDA.TESTING", "created"    , 29);
     public static Type_DatetimePrimitive       LASTUPDATED= new Type_DatetimePrimitive      ("TILDA.TESTING", "lastUpdated", 30);
     public static Type_DatetimePrimitiveNull   DELETED    = new Type_DatetimePrimitiveNull  ("TILDA.TESTING", "deleted"    , 31);
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
   private static class RecordProcessorList implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorList(Connection C, int Start)
         {
           _L = new ArrayListResults<tilda.data.Testing_Data>(Start);
           _C = C;
         }
       protected ArrayListResults<tilda.data.Testing_Data> _L = null;
       protected Connection _C = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.Testing_Data Obj = new tilda.data.Testing_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__TESTING)Obj).Init(_C, RS);
          if (OK == true)
            _L.add(Obj);
          return OK;
        }
     }
   private static class RecordProcessorObject implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorObject(Connection C, int Start, ObjectProcessor OP)
         {
           _OP = OP;
           _C = C;
         }
       protected ObjectProcessor _OP;
       protected Connection _C = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.Testing_Data Obj = new tilda.data.Testing_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__TESTING)Obj).Init(_C, RS);
          if (OK == true)
           _OP.Process(Index, Obj);
          return OK;
        }
     }
   public interface ObjectProcessor
     {
       public boolean Process(int Index, tilda.data.Testing_Data Obj) throws Exception;
     }

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__TESTING Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select TILDA.TESTING.\"refnum\", TILDA.TESTING.\"refnum2\", TILDA.TESTING.\"name\", TILDA.TESTING.\"description\", TILDA.TESTING.\"desc2\", TILDA.TESTING.\"desc3\", TILDA.TESTING.\"desc4\", TILDA.TESTING.\"desc5\", TILDA.TESTING.\"desc6\", TILDA.TESTING.\"tops\", TILDA.TESTING.\"tops2\", TILDA.TESTING.\"a1\", TILDA.TESTING.\"a2\", TILDA.TESTING.\"a2b\", TILDA.TESTING.\"a2c\", TILDA.TESTING.\"a3\", TILDA.TESTING.\"a3b\", TILDA.TESTING.\"a4\", TILDA.TESTING.\"a4b\", TILDA.TESTING.\"a5\", TILDA.TESTING.\"a5b\", TILDA.TESTING.\"a6\", TILDA.TESTING.\"a6b\", TILDA.TESTING.\"a6c\", TILDA.TESTING.\"a7\", TILDA.TESTING.\"a7b\", TILDA.TESTING.\"a8\", TILDA.TESTING.\"a9TZ\", TILDA.TESTING.\"a9\", TILDA.TESTING.\"created\", TILDA.TESTING.\"lastUpdated\", TILDA.TESTING.\"deleted\" from TILDA.TESTING");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
             break;
          case 1:
             S.append(" order by TILDA.TESTING.\"name\" ASC");
             break;
          case 2:
             S.append(", TILDA.OBJECTPERF"); // Additional From's from the subwhereclause.
             S.append(" where (TILDA.TESTING.\"deleted\" is null and TILDA.TESTING.\"desc2\" >= ? and TILDA.TESTING.\"a5\" < ? or TILDA.TESTING.\"name\" = ? and TILDA.TESTING.\"created\" > ?)");
             S.append(" order by TILDA.TESTING.\"name\" ASC");
             break;
          case 3:
             S.append(" where (TILDA.TESTING.\"deleted\" is null and TILDA.TESTING.\"name\" = ? and TILDA.TESTING.\"created\" > ?)");
             S.append(" order by TILDA.TESTING.\"name\" ASC");
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TABLENAME, Q);
       LOG.debug("TILDA([7mTILDA.TESTING[27m): "+Q.replaceAll(TABLENAME+"\\.",""));
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TESTING_Factory.TABLENAME, StatementType.SELECT, count, AllocatedArrays);
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
   static public tilda.data.Testing_Data Create(List<Long         > refnum2, String name) throws Exception
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

       Long                 _refnum      =                       ParseUtil.parseLong         ("refnum"     , true , Values.get("refnum"     ), Errors );
       List<Long         >  _refnum2     = CollectionUtil.toList(ParseUtil.parseLong         ("refnum2"    , true , Values.get("refnum2"    ), "``", Errors));
       String               _name        =                       ParseUtil.parseString       ("name"       , true , Values.get("name"       ), Errors );
       String               _description =                       ParseUtil.parseString       ("description", false, Values.get("description"), Errors );
       String               _desc2       =                       ParseUtil.parseString       ("desc2"      , false, Values.get("desc2"      ), Errors );
       String               _desc3       =                       ParseUtil.parseString       ("desc3"      , false, Values.get("desc3"      ), Errors );
       String               _desc4       =                       ParseUtil.parseString       ("desc4"      , false, Values.get("desc4"      ), Errors );
       String               _desc5       =                       ParseUtil.parseString       ("desc5"      , false, Values.get("desc5"      ), Errors );
       String               _desc6       =                       ParseUtil.parseString       ("desc6"      , false, Values.get("desc6"      ), Errors );
       List<String       >  _tops        = CollectionUtil.toList(ParseUtil.parseString       ("tops"       , false, Values.get("tops"       ), ",", Errors));
       Set <String       >  _tops2       = CollectionUtil.toSet (ParseUtil.parseString       ("tops2"      , false, Values.get("tops2"      ), ",", Errors));
       Integer              _a1          =                       ParseUtil.parseInteger      ("a1"         , false, Values.get("a1"         ), Errors );
       Character            _a2          =                       ParseUtil.parseCharacter    ("a2"         , false, Values.get("a2"         ), Errors );
       List<Character    >  _a2b         = CollectionUtil.toList(ParseUtil.parseCharacter    ("a2b"        , false, Values.get("a2b"        ), ",", Errors));
       Set <Character    >  _a2c         = CollectionUtil.toSet (ParseUtil.parseCharacter    ("a2c"        , false, Values.get("a2c"        ), ",", Errors));
       Boolean              _a3          =                       ParseUtil.parseBoolean      ("a3"         , false, Values.get("a3"         ), Errors );
       List<Boolean      >  _a3b         = CollectionUtil.toList(ParseUtil.parseBoolean      ("a3b"        , false, Values.get("a3b"        ), ",", Errors));
       Double               _a4          =                       ParseUtil.parseDouble       ("a4"         , false, Values.get("a4"         ), Errors );
       List<Double       >  _a4b         = CollectionUtil.toList(ParseUtil.parseDouble       ("a4b"        , false, Values.get("a4b"        ), ",", Errors));
       Float                _a5          =                       ParseUtil.parseFloat        ("a5"         , false, Values.get("a5"         ), Errors );
       List<Float        >  _a5b         = CollectionUtil.toList(ParseUtil.parseFloat        ("a5b"        , false, Values.get("a5b"        ), ",", Errors));
       Long                 _a6          =                       ParseUtil.parseLong         ("a6"         , false, Values.get("a6"         ), Errors );
       List<Long         >  _a6b         = CollectionUtil.toList(ParseUtil.parseLong         ("a6b"        , false, Values.get("a6b"        ), ",", Errors));
       Set <Long         >  _a6c         = CollectionUtil.toSet (ParseUtil.parseLong         ("a6c"        , false, Values.get("a6c"        ), ",", Errors));
       Integer              _a7          =                       ParseUtil.parseInteger      ("a7"         , false, Values.get("a7"         ), Errors );
       List<Integer      >  _a7b         = CollectionUtil.toList(ParseUtil.parseInteger      ("a7b"        , false, Values.get("a7b"        ), ",", Errors));
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



       RecordProcessorList RPL = new RecordProcessorList(C, Start);
       ReadMany(C, 1, RPL, Obj, null, Start, Size);
       return RPL._L;
     }

   static public void LookupWhereAllByName(Connection C, ObjectProcessor OP, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorObject RPL = new RecordProcessorObject(C, Start, OP);
       ReadMany(C, 1, RPL, Obj, null, Start, Size);
     }


   static public ListResults<tilda.data.Testing_Data> LookupWhereAllByName2(Connection C, String desc2Lower, float a5Upper, String name, ZonedDateTime created, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       LookupWhereAllByName2Params P = new LookupWhereAllByName2Params(desc2Lower, a5Upper, name, created);

       RecordProcessorList RPL = new RecordProcessorList(C, Start);
       ReadMany(C, 2, RPL, Obj, P, Start, Size);
       return RPL._L;
     }

   static public void LookupWhereAllByName2(Connection C, ObjectProcessor OP, String desc2Lower, float a5Upper, String name, ZonedDateTime created, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       LookupWhereAllByName2Params P = new LookupWhereAllByName2Params(desc2Lower, a5Upper, name, created);

       RecordProcessorObject RPL = new RecordProcessorObject(C, Start, OP);
       ReadMany(C, 2, RPL, Obj, P, Start, Size);
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

       RecordProcessorList RPL = new RecordProcessorList(C, Start);
       ReadMany(C, 3, RPL, Obj, P, Start, Size);
       return RPL._L;
     }

   static public void LookupWhereAllByName3(Connection C, ObjectProcessor OP, String name, ZonedDateTime created, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       LookupWhereAllByName3Params P = new LookupWhereAllByName3Params(name, created);

       RecordProcessorObject RPL = new RecordProcessorObject(C, Start, OP);
       ReadMany(C, 3, RPL, Obj, P, Start, Size);
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


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C   , TILDA__TESTING_Factory.TABLENAME); }
   public static SelectQuery newWhereQuery (            ) throws Exception { return new SelectQuery(null, TILDA__TESTING_Factory.TABLENAME); }
   public static ListResults<tilda.data.Testing_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorList RPL = new RecordProcessorList(C, Start);
       ReadMany(C, -7, RPL, null, Q, Start, Size);
       return RPL._L;
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, TILDA__TESTING_Factory.TABLENAME); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, TILDA__TESTING_Factory.TABLENAME); }

 }
