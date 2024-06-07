
package tilda.data._Tilda;

import java.math.*;
import java.util.*;
import java.time.*;
import java.util.concurrent.atomic.AtomicBoolean;

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
public class TILDA__JOBPARTMESSAGE_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__JOBPARTMESSAGE_Factory.class.getName());

   protected TILDA__JOBPARTMESSAGE_Factory() { }

   public static final Class<TILDA__JOBPARTMESSAGE> DATA_CLASS= TILDA__JOBPARTMESSAGE.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("JobPartMessage", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.JobPartMessage", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "JobPartMessage"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPartMessage.refnum -> TILDA.JobPartMessage."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPartMessage.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPartMessage.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                REFNUM       = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"       , 0/*0*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPartMessage.jobRefnum -> TILDA.JobPartMessage."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Parent Job Refnum</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPartMessage.jobRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPartMessage.jobRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                JOBREFNUM    = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "jobRefnum"    , 1/*1*/, "Parent Job Refnum", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPartMessage.jobPartRefnum -> TILDA.JobPartMessage."jobPartRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Parent Job Part Refnum</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPartMessage.jobPartRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPartMessage.jobPartRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull            JOBPARTREFNUM= new Type_LongPrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartRefnum", 2/*2*/, "Parent Job Part Refnum", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPartMessage.notify -> TILDA.JobPartMessage."notify"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>notify of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Notification flag</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPartMessage.notify of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPartMessage.notify</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_BooleanPrimitive             NOTIFY       = new Type_BooleanPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "notify"       , 3/*3*/, "Notification flag", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPartMessage.msg -> TILDA.JobPartMessage."msg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>msg of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPartMessage.msg of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPartMessage.msg</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              MSG          = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "msg"          , 4/*4*/, 8192, "Message details", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPartMessage.created -> TILDA.JobPartMessage."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.JobPartMessage)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPartMessage.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPartMessage.created</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
     public final Type_DatetimePrimitive            CREATED      = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "created"      , 5/*5*/, "The timestamp for when the record was created. (TILDA.JobPartMessage)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPartMessage.lastUpdated -> TILDA.JobPartMessage."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.JobPartMessage)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPartMessage.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPartMessage.lastUpdated</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
     public final Type_DatetimePrimitive            LASTUPDATED  = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"  , 6/*6*/, "The timestamp for when the record was last updated. (TILDA.JobPartMessage)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPartMessage.deleted -> TILDA.JobPartMessage."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPartMessage)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPartMessage.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPartMessage.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull        DELETED      = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"      , 7/*7*/, "The timestamp for when the record was deleted. (TILDA.JobPartMessage)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.REFNUM,COLS.JOBREFNUM,COLS.JOBPARTREFNUM,COLS.NOTIFY,COLS.MSG,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.REFNUM };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = new ColumnDefinition[][]{ 
        };

   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = {};

   // Short(short) is deprecated, but we do want a new instance here to avoid synchronizing over the same cached instance from valueOf.
   // @SuppressWarnings("deprecation")
   private static final AtomicBoolean __INITIALIZED = new AtomicBoolean(false);
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED.compareAndSet(false, true))
        {
           tilda.data.JobPartMessage_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.JobPartMessage_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.JobPartMessage_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.JobPartMessage_Data> _OP;
       protected ArrayListResults<tilda.data.JobPartMessage_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.JobPartMessage_Data Obj = new tilda.data.JobPartMessage_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__JOBPARTMESSAGE)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.JobPartMessage_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__JOBPARTMESSAGE_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "JobPartMessage");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Index 'Job'
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JobPartMessage", "jobRefnum"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "JobPartMessage", "created"); S.append(" DESC");
                break;
             case 2: // Index 'JobPart'
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JobPartMessage", "jobPartRefnum"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "JobPartMessage", "created"); S.append(" DESC");
                break;
             case 3: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "JobPartMessage", "refnum"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDA.JobPartMessage", Q, null);
       java.sql.PreparedStatement PS=null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          if (size < 0 || size > 5000)
           PS.setFetchSize(5000);
          int i = 0;
          switch (LookupId)
           {
             case -77:
             case -7:
                break;
             case 1: {  // Index 'Job'
               PS.setLong      (++i, Obj._jobRefnum    );
               break;
             }
             case 2: {  // Index 'JobPart'
               if (Obj.isNullJobPartRefnum() == true) PS.setNull(++i, java.sql.Types.BIGINT    );  else PS.setLong      (++i, Obj._jobPartRefnum);
               break;
             }
             case 3: { // Query 'All'
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__JOBPARTMESSAGE_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
The generic init method is typically run when there is a general data structure of data available, for example, a CSV
data file read in memory, or run from a servlet using a Map<String, String[]> object obtained from an ServletRequest
object. The generic init method defaults to this general data structure as a genegic representation.
*/
   static public tilda.data.JobPartMessage_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = new tilda.data.JobPartMessage_Data();
       String[] vals = null;

       vals = Values.get("refnum");
       // Even though this is a primary key, and is by definition not-null, we nevertheless check it as optional in case
       // this object is being initialized generically for a create.
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("refnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _refnum = ParseUtil.parseLong("refnum", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_refnum != null) Obj.setRefnum(_refnum);

       vals = Values.get("jobRefnum");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("jobRefnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _jobRefnum = ParseUtil.parseLong("jobRefnum", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_jobRefnum != null) Obj.setJobRefnum(_jobRefnum);

       vals = Values.get("jobPartRefnum");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("jobPartRefnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _jobPartRefnum = ParseUtil.parseLong("jobPartRefnum", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_jobPartRefnum != null) Obj.setJobPartRefnum(_jobPartRefnum);

       vals = Values.get("notify");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("notify", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Boolean _notify = ParseUtil.parseBoolean("notify", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_notify != null) Obj.setNotify(_notify);

       vals = Values.get("msg");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("msg", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _msg = ParseUtil.parseString("msg", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_msg != null) Obj.setMsg(_msg);


       return (tilda.data.JobPartMessage_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param jobRefnum     Parent Job Refnum
 @param notify        Notification flag
 @param msg           (max size 8192) Message details
*/
   static public tilda.data.JobPartMessage_Data create(long jobRefnum, boolean notify, String msg) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = new tilda.data.JobPartMessage_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDA.JOBPARTMESSAGE"));

       // Explicit setters
       Obj.setJobRefnum    (jobRefnum    );
       Obj.setNotify       (notify       );
       Obj.setMsg          (msg          );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       // Default Nullables
       Obj.__Nulls.or(TILDA__JOBPARTMESSAGE_Factory.COLS.JOBPARTREFNUM._Mask);

       return (tilda.data.JobPartMessage_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data.JobPartMessage_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__JOBPARTMESSAGE lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__JOBPARTMESSAGE) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__JOBPARTMESSAGE) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.JobPartMessage_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__JOBPARTMESSAGE) d);

               if (((TILDA__JOBPARTMESSAGE) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.JobPartMessage_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__JOBPARTMESSAGE_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__JOBPARTMESSAGE) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.JobPartMessage_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__JOBPARTMESSAGE_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__JOBPARTMESSAGE) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.JobPartMessage_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__JOBPARTMESSAGE_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__JOBPARTMESSAGE) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.JobPartMessage_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__JOBPARTMESSAGE_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               int i = d.populatePreparedStatement(C, PS, AllocatedArrays);

               PS.addBatch();
               ++count;

               if (index != 0 && (index + 1) % batchSize == 0)
                 {
                   int[] results = PS.executeBatch();
                   int failedRec = JDBCHelper.batchWriteDone(results, batchSize);
                   if (failedRec != -1)
                     {
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.JobPartMessage_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'JobPartMessage_Data' objects ending at position #" + index + " failed being written to the database.");
                   return L.size() - insertCount+failedRec;
                 }
               for (int index2 = batchStart; index2 <= index; ++index2)
                 L.get(index2).stateUpdatePostWrite();

               if(commitSize > 0)
                 {
                   C.commit();
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
           TILDA__2_5.handleFinally(PS, T0, TILDA__JOBPARTMESSAGE_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: refnum.
*/
   static public tilda.data.JobPartMessage_Data lookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = new tilda.data.JobPartMessage_Data();
       Obj.initForLookup(0);

       Obj.setRefnum       (refnum       ); Obj.__Saved_refnum        = Obj._refnum       ;

       return (tilda.data.JobPartMessage_Data) Obj;
     }

/**
Lookup records by the index 'Job' over  jobRefnum.<BR>The results are ordered by: created desc
*/
   static public ListResults<tilda.data.JobPartMessage_Data> lookupWhereJob(Connection C, long jobRefnum, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = new tilda.data.JobPartMessage_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setJobRefnum    (jobRefnum    );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, __start__);
       readMany(C, 1, RPI, Obj, null, __start__, __size__);
       return RPI._L;
     }

/**
Lookup records by the index 'Job' over  jobRefnum.<BR>The results are ordered by: created desc
*/
   static public void lookupWhereJob(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.JobPartMessage_Data> OP, long jobRefnum, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = new tilda.data.JobPartMessage_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setJobRefnum    (jobRefnum    );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, __start__, __size__);
     }



/**
Lookup records by the index 'JobPart' over  jobPartRefnum.<BR>The results are ordered by: created desc
*/
   static public ListResults<tilda.data.JobPartMessage_Data> lookupWhereJobPart(Connection C, long jobPartRefnum, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = new tilda.data.JobPartMessage_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setJobPartRefnum(jobPartRefnum);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, __start__);
       readMany(C, 2, RPI, Obj, null, __start__, __size__);
       return RPI._L;
     }

/**
Lookup records by the index 'JobPart' over  jobPartRefnum.<BR>The results are ordered by: created desc
*/
   static public void lookupWhereJobPart(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.JobPartMessage_Data> OP, long jobPartRefnum, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = new tilda.data.JobPartMessage_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setJobPartRefnum(jobPartRefnum);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, __start__, __size__);
     }



/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: refnum asc
*/   static public ListResults<tilda.data.JobPartMessage_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = new tilda.data.JobPartMessage_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 3, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: refnum asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.JobPartMessage_Data> OP, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = new tilda.data.JobPartMessage_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 3, RPI, Obj, null, start, size);
     }





   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.JobPartMessage_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.JobPartMessage_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


   public static String getCSVHeader()
    {
      return "\"refnum\",\"jobRefnum\",\"jobPartRefnum\",\"notify\",\"msg\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.JobPartMessage_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.JobPartMessage_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.JobPartMessage_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = (tilda.data._Tilda.TILDA__JOBPARTMESSAGE) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getJobRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getJobPartRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getNotify());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getMsg());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.JobPartMessage_Data> L, String lead, boolean fullList) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (fullList == true)
        {
          if (L == null)
           {
             out.write("null\n");
             return;
           }
          if (L.isEmpty() == true)
           {
             out.write("[]\n");
             return;
           }
          out.write("[\n");
        }
      boolean First = true;
      for (tilda.data.JobPartMessage_Data O : L)
       if (O!=null)
        {
          out.write(lead);
          toJSON(out, O, First == true ? "   " : "  ,", true);
          if (First == true)
           First = false;
        }
      if (fullList == true)
       { 
          out.write(lead);
          out.write("]\n");
       } 
      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

   public static void toJSON(java.io.Writer out, tilda.data.JobPartMessage_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.JobPartMessage_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.JobPartMessage_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__JOBPARTMESSAGE Obj = (tilda.data._Tilda.TILDA__JOBPARTMESSAGE) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "refnum", ++i==0, Obj.getRefnum());

        JSONUtil.print(out, "jobRefnum", ++i==0, Obj.getJobRefnum());

      if (Obj.isNullJobPartRefnum() == false)
        JSONUtil.print(out, "jobPartRefnum", ++i==0, Obj.getJobPartRefnum());

        JSONUtil.print(out, "notify", ++i==0, Obj.getNotify());

        JSONUtil.print(out, "msg", ++i==0, Obj.getMsg());

        JSONUtil.print(out, "created", ++i==0, Obj.getCreated());

        JSONUtil.print(out, "lastUpdated", ++i==0, Obj.getLastUpdated());

      if (Obj.isNullDeleted() == false && Obj.getDeleted() != null)
        JSONUtil.print(out, "deleted", ++i==0, Obj.getDeleted());

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
