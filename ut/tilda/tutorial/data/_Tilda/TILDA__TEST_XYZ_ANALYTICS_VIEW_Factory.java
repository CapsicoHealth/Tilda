
package tilda.tutorial.data._Tilda;

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
public class TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.class.getName());

   protected TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory() { }

   public static final Class<TILDA__TEST_XYZ_ANALYTICS_VIEW> DATA_CLASS= TILDA__TEST_XYZ_ANALYTICS_VIEW.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATUTORIAL", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Test_XYZ_Analytics_View", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATUTORIAL.Test_XYZ_Analytics_View", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_View."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          FORMREFNUM            = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formRefnum"            , 0/*0*/, "The primary key for this record", null, null, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType -> TILDATUTORIAL.Test_XYZ_Analytics_View."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formType of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        FORMTYPE              = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "formType"              , 1/*1*/, "Form template type", null, null, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    FORMFILLDATETZ        = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "formFillDateTZ"        , 2/*2*/, "Generated helper column to hold the time zone ID for 'formFillDate'.", null, null, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  FORMFILLDATE          = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "formFillDate"          , 3/*3*/, "The date the form was filled", null, null, FORMFILLDATETZ);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_View."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          FORMUSERREFNUM        = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formUserRefnum"        , 4/*4*/, "The primary key for this record", null, null, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_View."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        FORMUSEREMAIL         = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "formUserEmail"         , 5/*5*/, "The user's email", null, null, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_View."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          FORMCOUNTCORRECT      = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formCountCorrect"      , 6/*6*/, "Whether the answer is correct or not", null, null, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_View."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          FORMTIMEMILLISTOTAL   = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formTimeMillisTotal"   , 7/*7*/, "Time in milliseconds for the time spent answering the question", null, null, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_View."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          TESTCOUNT             = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "testCount"             , 8/*8*/, "The primary key for this record", null, null, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_View."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          TESTANSWERCOUNTCORRECT= new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "testAnswerCountCorrect", 9/*9*/, "Whether the answer is correct or not", null, null, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_View."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoublePrimitive        TESTTIMEMILLISAVG     = new Type_DoublePrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "testTimeMillisAvg"     , 10/*10*/, "Time in milliseconds for the time spent answering the question", null, null, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_View."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formCountCorrect >= 2</PRE>
</TD></TR>

</TABLE>
*/
     public static Type_IntegerPrimitiveNull   ISPASSED              = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "isPassed"              , 11/*11*/, "<B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.", new String[] {"formCountCorrect >= 2"}, new String[] {"formCountCorrect"}, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_View."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formTimeMillisTotal > testTimeMillisAvg</PRE>
</TD></TR>

</TABLE>
*/
     public static Type_IntegerPrimitiveNull   TOOKLONGERTHANAVERAGE = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "tookLongerThanAverage" , 12/*12*/, "<B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.", new String[] {"formTimeMillisTotal > testTimeMillisAvg"}, new String[] {"formTimeMillisTotal", "testTimeMillisAvg"}, null);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_View."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL></TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>    isPassed=1
AND testAnswerCountCorrect < testCount*3/2</PRE>
</TD></TR>

</TABLE>
*/
     public static Type_IntegerPrimitiveNull   WASCHALLENGING        = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "wasChallenging"        , 13/*13*/, "<B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL>", new String[] {"    isPassed=1", "AND testAnswerCountCorrect < testCount*3/2"}, new String[] {"testAnswerCountCorrect", "testCount", "isPassed"}, null);
;
   }

   public static final ColumnDefinition[] COLUMNS = { COLS.FORMREFNUM,COLS.FORMTYPE,COLS.FORMFILLDATETZ,COLS.FORMFILLDATE,COLS.FORMUSERREFNUM,COLS.FORMUSEREMAIL,COLS.FORMCOUNTCORRECT,COLS.FORMTIMEMILLISTOTAL,COLS.TESTCOUNT,COLS.TESTANSWERCOUNTCORRECT,COLS.TESTTIMEMILLISAVG,COLS.ISPASSED,COLS.TOOKLONGERTHANAVERAGE,COLS.WASCHALLENGING };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = {  };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = { 
        };

   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = {};

   private static Boolean  __INITIALIZED = false;
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED == false)
        synchronized(__INITIALIZED)
         {
           if (__INITIALIZED == false)
            {
              tilda.tutorial.data.Test_XYZ_Analytics_View_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.tutorial.data.Test_XYZ_Analytics_View_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Analytics_View_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Analytics_View_Data> _OP;
       protected ArrayListResults<tilda.tutorial.data.Test_XYZ_Analytics_View_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.tutorial.data.Test_XYZ_Analytics_View_Data Obj = new tilda.tutorial.data.Test_XYZ_Analytics_View_Data();
          boolean OK = ((tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_VIEW)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.tutorial.data.Test_XYZ_Analytics_View_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_VIEW Obj, Object ExtraParams, int start, int size) throws Exception
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
          S.append(" "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formType");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formFillDateTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formFillDate");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formUserRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formUserEmail");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formCountCorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formTimeMillisTotal");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "testCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "testAnswerCountCorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "testTimeMillisAvg");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "isPassed");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "tookLongerThanAverage");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "wasChallenging");
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
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
       QueryDetails.logQuery("TILDATUTORIAL.Test_XYZ_Analytics_View", Q, null);
       java.sql.PreparedStatement PS=null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          if (size < 0 || size > 5000)
           PS.setFetchSize(5000);
          switch (LookupId)
           {
             case -77:
             case -7:
                break;
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   static public tilda.tutorial.data.Test_XYZ_Analytics_View_Data lookupByAll() throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_VIEW Obj = new tilda.tutorial.data.Test_XYZ_Analytics_View_Data();
       Obj.initForLookup(0);


       return (tilda.tutorial.data.Test_XYZ_Analytics_View_Data) Obj;
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.tutorial.data.Test_XYZ_Analytics_View_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Analytics_View_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }


   public static String getCSVHeader()
    {
      return "\"formRefnum\",\"formType\",\"formFillDateTZ\",\"formFillDate\",\"formUserRefnum\",\"formUserEmail\",\"formCountCorrect\",\"formTimeMillisTotal\",\"testCount\",\"testAnswerCountCorrect\",\"testTimeMillisAvg\",\"isPassed\",\"tookLongerThanAverage\",\"wasChallenging\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.tutorial.data.Test_XYZ_Analytics_View_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.tutorial.data.Test_XYZ_Analytics_View_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.tutorial.data.Test_XYZ_Analytics_View_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + obj.getFormRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, obj.getFormType());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, obj.getFormFillDateTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(obj.getFormFillDate()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + obj.getFormUserRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, obj.getFormUserEmail());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + obj.getFormCountCorrect());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + obj.getFormTimeMillisTotal());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + obj.getTestCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + obj.getTestAnswerCountCorrect());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + obj.getTestTimeMillisAvg());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + obj.getIsPassed());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + obj.getTookLongerThanAverage());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + obj.getWasChallenging());
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.tutorial.data.Test_XYZ_Analytics_View_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.tutorial.data.Test_XYZ_Analytics_View_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.tutorial.data.Test_XYZ_Analytics_View_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.tutorial.data.Test_XYZ_Analytics_View_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.tutorial.data.Test_XYZ_Analytics_View_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter();
      tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_VIEW Obj = (tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_VIEW) obj;
      if (fullObject == true)
       {
          out.write(lead);
          out.write("{");
       }

      int i = -1;
        JSONUtil.print(out, "formRefnum", ++i==0, Obj.getFormRefnum());

        JSONUtil.print(out, "formType", ++i==0, Obj.getFormType());

      if (Obj.isFormFillDateTZNull() == false && Obj.getFormFillDateTZ() != null)
        JSONUtil.print(out, "formFillDateTZ", ++i==0, Obj.getFormFillDateTZ());

      if (Obj.isFormFillDateNull() == false && Obj.getFormFillDate() != null)
        JSONUtil.print(out, "formFillDate", ++i==0, Obj.getFormFillDate());

        JSONUtil.print(out, "formUserRefnum", ++i==0, Obj.getFormUserRefnum());

        JSONUtil.print(out, "formUserEmail", ++i==0, Obj.getFormUserEmail());

        JSONUtil.print(out, "formCountCorrect", ++i==0, Obj.getFormCountCorrect());

        JSONUtil.print(out, "formTimeMillisTotal", ++i==0, Obj.getFormTimeMillisTotal());

        JSONUtil.print(out, "testCount", ++i==0, Obj.getTestCount());

        JSONUtil.print(out, "testAnswerCountCorrect", ++i==0, Obj.getTestAnswerCountCorrect());

        JSONUtil.print(out, "testTimeMillisAvg", ++i==0, Obj.getTestTimeMillisAvg());

      if (Obj.isIsPassedNull() == false)
        JSONUtil.print(out, "isPassed", ++i==0, Obj.getIsPassed());

      if (Obj.isTookLongerThanAverageNull() == false)
        JSONUtil.print(out, "tookLongerThanAverage", ++i==0, Obj.getTookLongerThanAverage());

      if (Obj.isWasChallengingNull() == false)
        JSONUtil.print(out, "wasChallenging", ++i==0, Obj.getWasChallenging());

      if (fullObject == true)
       out.write(" }\n");

      outWriter.append(out.getBuilder().toString());
      out.close();

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
