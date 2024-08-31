
package tilda.tutorial.data._Tilda;

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
public class TILDA__TESTANSWER_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTANSWER_Factory.class.getName());

   protected TILDA__TESTANSWER_Factory() { }

   public static final Class<TILDA__TESTANSWER> DATA_CLASS= TILDA__TESTANSWER.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATUTORIAL", "");
   public static final String TABLENAME_LABEL = TextUtil.print("TestAnswer", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATUTORIAL.TestAnswer", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATUTORIAL", "TestAnswer"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.refnum -> TILDATUTORIAL.TestAnswer."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                REFNUM     = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"     , 0/*0*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum -> TILDATUTORIAL.TestAnswer."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The form's refnum</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.formRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                FORMREFNUM = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "formRefnum" , 1/*1*/, "The form's refnum", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId -> TILDATUTORIAL.TestAnswer."questionId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>questionId of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.questionId of type varchar(60)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              QUESTIONID = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "questionId" , 2/*2*/, 60, "Question id", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId -> TILDATUTORIAL.TestAnswer."answerId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>answerId of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Answer value</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.answerId of type varchar(60)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          ANSWERID   = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "answerId"   , 3/*3*/, 60, "Answer value", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis -> TILDATUTORIAL.TestAnswer."timeMillis"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeMillis of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.timeMillis of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitive             TIMEMILLIS = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillis" , 4/*4*/, "Time in milliseconds for the time spent answering the question", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct -> TILDATUTORIAL.TestAnswer."correct"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>correct of type short</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.correct of type smallint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_ShortPrimitive               CORRECT    = new Type_ShortPrimitive              (SCHEMA_LABEL, TABLENAME_LABEL, "correct"    , 5/*5*/, "Whether the answer is correct or not", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created -> TILDATUTORIAL.TestAnswer."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created</TD></TR>

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
     public final Type_DatetimePrimitive            CREATED    = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "created"    , 6/*6*/, "The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated -> TILDATUTORIAL.TestAnswer."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated</TD></TR>

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
     public final Type_DatetimePrimitive            LASTUPDATED= new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated", 7/*7*/, "The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted -> TILDATUTORIAL.TestAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull        DELETED    = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"    , 8/*8*/, "The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.REFNUM,COLS.FORMREFNUM,COLS.QUESTIONID,COLS.ANSWERID,COLS.TIMEMILLIS,COLS.CORRECT,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.REFNUM };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = new ColumnDefinition[][]{ 
                   {COLS.FORMREFNUM,COLS.QUESTIONID}
        };

   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = COLUMNS_UNIQUE_INDICES[0];

   // Short(short) is deprecated, but we do want a new instance here to avoid synchronizing over the same cached instance from valueOf.
   // @SuppressWarnings("deprecation")
   private static final AtomicBoolean __INITIALIZED = new AtomicBoolean(false);
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED.compareAndSet(false, true))
        {
           tilda.tutorial.data.TestAnswer_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.tutorial.data.TestAnswer_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.TestAnswer_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.tutorial.data.TestAnswer_Data> _OP;
       protected ArrayListResults<tilda.tutorial.data.TestAnswer_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.tutorial.data.TestAnswer_Data Obj = new tilda.tutorial.data.TestAnswer_Data();
          boolean OK = ((tilda.tutorial.data._Tilda.TILDA__TESTANSWER)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.tutorial.data.TestAnswer_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__TESTANSWER_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "TestAnswer");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 2: // Index 'Form'
                S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "formRefnum"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "questionId"); S.append(" ASC");
                break;
             case 3: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "formRefnum"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "questionId"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDATUTORIAL.TestAnswer", Q, null);
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
             case 2: {  // Index 'Form'
               PS.setLong      (++i, Obj._formRefnum );
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
          tilda.tutorial.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.tutorial.data.TestAnswer_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj = new tilda.tutorial.data.TestAnswer_Data();
       String[] vals = null;

       vals = Values.get("refnum");
       // Even though this is a primary key, and is by definition not-null, we nevertheless check it as optional in case
       // this object is being initialized generically for a create.
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("refnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _refnum = ParseUtil.parseLong("refnum", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_refnum != null) Obj.setRefnum(_refnum);

       vals = Values.get("formRefnum");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("formRefnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _formRefnum = ParseUtil.parseLong("formRefnum", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_formRefnum != null) Obj.setFormRefnum(_formRefnum);

       vals = Values.get("questionId");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("questionId", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _questionId = ParseUtil.parseString("questionId", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_questionId != null) Obj.setQuestionId(_questionId);

       vals = Values.get("answerId");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("answerId", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _answerId = ParseUtil.parseString("answerId", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_answerId != null) Obj.setAnswerId(_answerId);

       vals = Values.get("timeMillis");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("timeMillis", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _timeMillis = ParseUtil.parseInteger("timeMillis", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_timeMillis != null) Obj.setTimeMillis(_timeMillis);

       vals = Values.get("correct");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("correct", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Short _correct = ParseUtil.parseShort("correct", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_correct != null) Obj.setCorrect(_correct);


       return (tilda.tutorial.data.TestAnswer_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param formRefnum  The form's refnum
 @param questionId  (max size 60) Question id
 @param timeMillis  Time in milliseconds for the time spent answering the question
 @param correct     Whether the answer is correct or not
*/
   static public tilda.tutorial.data.TestAnswer_Data create(long formRefnum, String questionId, int timeMillis, short correct) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj = new tilda.tutorial.data.TestAnswer_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDATUTORIAL.TESTANSWER"));

       // Explicit setters
       Obj.setFormRefnum (formRefnum );
       Obj.setQuestionId (questionId );
       Obj.setTimeMillis (timeMillis );
       Obj.setCorrect    (correct    );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       // Default Nullables
       Obj.__Nulls.or(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask);

       return (tilda.tutorial.data.TestAnswer_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.tutorial.data.TestAnswer_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__TESTANSWER lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__TESTANSWER) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__TESTANSWER) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.tutorial.data.TestAnswer_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__TESTANSWER) d);

               if (((TILDA__TESTANSWER) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.TestAnswer_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__TESTANSWER) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.TestAnswer_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__TESTANSWER) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.TestAnswer_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__TESTANSWER) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.TestAnswer_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.tutorial.data.TestAnswer_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'TestAnswer_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__2_5.handleFinally(PS, T0, TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: refnum.
*/
   static public tilda.tutorial.data.TestAnswer_Data lookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj = new tilda.tutorial.data.TestAnswer_Data();
       Obj.initForLookup(0);

       Obj.setRefnum     (refnum     ); Obj.__Saved_refnum      = Obj._refnum     ;

       return (tilda.tutorial.data.TestAnswer_Data) Obj;
     }

/**
Lookup one record by the unique index 'FormAnswer': formRefnum, questionId.
*/
   static public tilda.tutorial.data.TestAnswer_Data lookupByFormAnswer(long formRefnum, String questionId) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj = new tilda.tutorial.data.TestAnswer_Data();
       Obj.initForLookup(1);

       Obj.setFormRefnum (formRefnum ); 
       Obj.setQuestionId (questionId ); 

       return (tilda.tutorial.data.TestAnswer_Data) Obj;
     }

/**
Lookup records by the index 'Form' over  formRefnum.<BR>The results are ordered by: questionId asc
*/
   static public ListResults<tilda.tutorial.data.TestAnswer_Data> lookupWhereForm(Connection C, long formRefnum, int __start__, int __size__) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj = new tilda.tutorial.data.TestAnswer_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setFormRefnum (formRefnum );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, __start__);
       readMany(C, 2, RPI, Obj, null, __start__, __size__);
       return RPI._L;
     }

/**
Lookup records by the index 'Form' over  formRefnum.<BR>The results are ordered by: questionId asc
*/
   static public void lookupWhereForm(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.TestAnswer_Data> OP, long formRefnum, int __start__, int __size__) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj = new tilda.tutorial.data.TestAnswer_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setFormRefnum (formRefnum );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, __start__, __size__);
     }



/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: formRefnum asc, questionId asc
*/   static public ListResults<tilda.tutorial.data.TestAnswer_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj = new tilda.tutorial.data.TestAnswer_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 3, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: formRefnum asc, questionId asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.TestAnswer_Data> OP, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj = new tilda.tutorial.data.TestAnswer_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 3, RPI, Obj, null, start, size);
     }




   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.tutorial.data.TestAnswer_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.TestAnswer_Data> OP, int start, int size) throws Exception
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
      return "\"refnum\",\"formRefnum\",\"questionId\",\"answerId\",\"timeMillis\",\"correct\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.tutorial.data.TestAnswer_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.tutorial.data.TestAnswer_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.tutorial.data.TestAnswer_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj = (tilda.tutorial.data._Tilda.TILDA__TESTANSWER) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getFormRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getQuestionId());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getAnswerId());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeMillis());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getCorrect());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.tutorial.data.TestAnswer_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.tutorial.data.TestAnswer_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.tutorial.data.TestAnswer_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.tutorial.data.TestAnswer_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.tutorial.data.TestAnswer_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.tutorial.data._Tilda.TILDA__TESTANSWER Obj = (tilda.tutorial.data._Tilda.TILDA__TESTANSWER) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "refnum", ++i==0, Obj.getRefnum());

        JSONUtil.print(out, "formRefnum", ++i==0, Obj.getFormRefnum());

        JSONUtil.print(out, "questionId", ++i==0, Obj.getQuestionId());

      if (Obj.isNullAnswerId() == false && Obj.getAnswerId() != null)
        JSONUtil.print(out, "answerId", ++i==0, Obj.getAnswerId());

        JSONUtil.print(out, "timeMillis", ++i==0, Obj.getTimeMillis());

        JSONUtil.print(out, "correct", ++i==0, Obj.getCorrect());

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
