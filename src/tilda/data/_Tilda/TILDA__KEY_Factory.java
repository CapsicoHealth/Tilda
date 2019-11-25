
package tilda.data._Tilda;

import java.math.*;
import java.util.*;
import java.time.*;

import org.apache.logging.log4j.*;

import com.google.gson.annotations.*;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.types.*;
import tilda.utils.*;
import tilda.utils.json.*;
import tilda.utils.pairs.*;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@SuppressWarnings({ "unused" })
public class TILDA__KEY_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__KEY_Factory.class.getName());

   protected TILDA__KEY_Factory() { }

   public static final Class<TILDA__KEY> DATA_CLASS= TILDA__KEY.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Key", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.Key", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "Key"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Key.refnum -> TILDA.Key."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Key.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Key.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          REFNUM        = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"        , 0/*0*/, "The primary key for this record");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Key.name -> TILDA.Key."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Key.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Key.name of type varchar(128)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the table/object tracked</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        NAME          = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "name"          , 1/*1*/, "The name of the table/object tracked");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Key.max -> TILDA.Key."max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Key.max of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Key.max of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The pre-allocated max RefNum for this table/object.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          MAX           = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "max"           , 2/*2*/, "The pre-allocated max RefNum for this table/object.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Key.count -> TILDA.Key."count"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Key.count of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Key.count of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The size of the pre-allocation required by this table/object.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitive       COUNT         = new Type_IntegerPrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "count"         , 3/*3*/, "The size of the pre-allocation required by this table/object.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Key.created -> TILDA.Key."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Key.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Key.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>Creation</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>Creation&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Creation time</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public static Type_DatetimePrimitive      CREATED       = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"       , 4/*4*/, "The timestamp for when the record was created.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Key.lastUpdated -> TILDA.Key."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Key.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Key.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>Update</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>Update&nbsp;&nbsp;</TD><TD>ALWAYS&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Last updated time</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public static Type_DatetimePrimitive      LASTUPDATED   = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"   , 5/*5*/, "The timestamp for when the record was last updated.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Key.deleted -> TILDA.Key."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Key.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Key.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DELETED       = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"       , 6/*6*/, "The timestamp for when the record was deleted.");
;
   }

   public static final ColumnDefinition[] COLUMNS = { COLS.REFNUM,COLS.NAME,COLS.MAX,COLS.COUNT,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = { COLS.REFNUM };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = { 
                   {COLS.NAME}
        };

   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = COLUMNS_UNIQUE_INDICES[0];

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
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.Key_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Key_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.Key_Data> _OP;
       protected ArrayListResults<tilda.data.Key_Data> _L = null;
       public void    start  () { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.Key_Data Obj = new tilda.data.Key_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__KEY)Obj).init(_C, RS);
          if (OK == true)
           {
             if (_OP == null)
              _L.add(Obj);
             else
              _OP.process(count, Obj);
           }
          return OK;
        }
     }

   protected static final void processMany(Connection C, String fullSelectQuery, int start, int size, tilda.db.processors.RecordProcessor RP) throws Exception
     {
       readMany(C, -77, RP, null, fullSelectQuery, start, size);
     }
   protected static final ListResults<tilda.data.Key_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__KEY Obj, Object ExtraParams, int start, int size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       if (LookupId == -77)
        {
          S.append((String)ExtraParams);
        }
       else
        {
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDA", "Key", "refnum");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Key", "name");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Key", "max");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Key", "count");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Key", "created");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Key", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Key", "deleted");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "Key");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 2:
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Key", "deleted"); S.append(" is null)");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Key", "name"); S.append(" ASC");
                break;
             case -77: 
             case -666: break;
             default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
           }
        }

       String Q = S.toString() + C.getSelectLimitClause(start, size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.Key", Q, null);
       java.sql.PreparedStatement PS=null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          switch (LookupId)
           {
             case -77:
             case -7:
                break;
             case 2: {
               break;
             }
             case -666: break;
             default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot prepare statement.");
           }


          count = JDBCHelper.process(PS.executeQuery(), RP, start, true, size, true);
        }
       catch (java.sql.SQLException E)
        {
          C.handleCatch(E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__KEY_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param refnum         The primary key for this record
 @param name           (max size 128) The name of the table/object tracked
 @param max            The pre-allocated max RefNum for this table/object.
 @param count          The size of the pre-allocation required by this table/object.
*/
   static public tilda.data.Key_Data create(long refnum, String name, long max, int count) throws Exception
     {
       tilda.data._Tilda.TILDA__KEY Obj = new tilda.data.Key_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setRefnum        (refnum        );
       Obj.setName          (name          );
       Obj.setMax           (max           );
       Obj.setCount         (count         );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.Key_Data) Obj;
     }

   static public tilda.data.Key_Data create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       Long        _refnum         =                       ParseUtil.parseLong("refnum"        , true , Values.get("refnum"        ), Errors );
       String        _name           =                       ParseUtil.parseString("name"          , true , Values.get("name"          ), Errors );
       Long        _max            =                       ParseUtil.parseLong("max"           , true , Values.get("max"           ), Errors );
       Integer        _count          =                       ParseUtil.parseInteger("count"         , true , Values.get("count"         ), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.Key_Data Obj = tilda.data.Key_Factory.create(_refnum, _name, _max, _count);


      return Obj;
     }
   public static int writeBatch(Connection C, List<tilda.data.Key_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__KEY lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__KEY) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__KEY) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.Key_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__KEY) d);

               if (((TILDA__KEY) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Key_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__KEY_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (((TILDA__KEY) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Key_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__KEY_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__KEY) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Key_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__KEY_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__KEY) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Key_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__KEY_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               int i = d.populatePreparedStatement(C, PS, AllocatedArrays);

               PS.addBatch();
               if (index != 0 && (index + 1) % batchSize == 0)
                 {
                   int[] results = PS.executeBatch();
                   int failedRec = JDBCHelper.batchWriteDone(results, batchSize);
                   if (failedRec != -1)
                     {
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.Key_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
                       return insertCount+failedRec;
                     }
                   for (int index2 = batchStart; index2 <= index; ++index2)
                     L.get(index2).stateUpdatePostWrite();
                   LOG.debug("Batch-inserted objects between positions #" + insertCount + " and #" + index + ".");
                   batchStart = 0;
                   insertCount+=batchSize;
                 }
               if (commitSize > 0 && index != 0 && (index + 1) % commitSize == 0)
                 {
                   C.commit();
                   LOG.debug("Commited " + commitSize + " batch records. At insert count " + (index-commitSize+1));
                 }
               PS.clearParameters();
             }

           if ((index + 1) % batchSize != 0)
             {
               int[] results = PS.executeBatch();
               int failedRec = JDBCHelper.batchWriteDone(results, L.size() - insertCount);
               if (failedRec != -1)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'Key_Data' objects ending at position #" + index + " failed being written to the database.");
                   return L.size() - insertCount+failedRec;
                 }
               for (int index2 = batchStart; index2 <= index; ++index2)
                 L.get(index2).stateUpdatePostWrite();

               if(commitSize > 0)
                 {
                   C.commit();
                   LOG.debug("Commited " + insertCount + " batch records.");
                 }
               LOG.debug("Final Batch-inserted objects between positions #" + insertCount + " and #" + index + ".");
             }

           C.releaseSavepoint(true);
           return -1;
         }
       catch (java.sql.SQLException E)
         {
           C.releaseSavepoint(false);
           C.handleCatch(E, "updated or inserted");
           return 1;
         }
       finally
         {
           TILDA__1_0.handleFinally(PS, T0, TILDA__KEY_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

   static public tilda.data.Key_Data lookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__KEY Obj = new tilda.data.Key_Data();
       Obj.initForLookup(0);

       Obj.setRefnum        (refnum        ); Obj.__Saved_refnum         = Obj._refnum        ;

       return (tilda.data.Key_Data) Obj;
     }

   static public tilda.data.Key_Data lookupByName(String name) throws Exception
     {
       tilda.data._Tilda.TILDA__KEY Obj = new tilda.data.Key_Data();
       Obj.initForLookup(1);

       Obj.setName          (name          ); 

       return (tilda.data.Key_Data) Obj;
     }


   static public ListResults<tilda.data.Key_Data> lookupWhereAllByName(Connection C, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__KEY Obj = new tilda.data.Key_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 2, RPI, Obj, null, start, size);
       return RPI._L;
     }

   static public void lookupWhereAllByName(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Key_Data> OP, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__KEY Obj = new tilda.data.Key_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, start, size);
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.Key_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.Key_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


 }
