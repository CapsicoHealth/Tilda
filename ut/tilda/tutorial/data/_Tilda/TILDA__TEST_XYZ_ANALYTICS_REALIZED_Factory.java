
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
public class TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.class.getName());

   protected TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory() { }

   public static final Class<TILDA__TEST_XYZ_ANALYTICS_REALIZED> DATA_CLASS= TILDA__TEST_XYZ_ANALYTICS_REALIZED.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATUTORIAL", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Test_XYZ_Analytics_Realized", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATUTORIAL.Test_XYZ_Analytics_Realized", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive          FORMREFNUM            = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formRefnum"            , 0/*0*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type varchar(40)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    FORMTYPE              = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "formType"              , 1/*1*/, 40, "Form template type", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formFillDateTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type varchar(10)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    FORMFILLDATETZ        = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "formFillDateTZ"        , 2/*2*/, 10, "Generated helper column to hold the time zone ID for 'formFillDate'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formFillDate of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  FORMFILLDATE          = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "formFillDate"          , 3/*3*/, "The date the form was filled", null, null, FORMFILLDATETZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formUserRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      FORMUSERREFNUM        = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "formUserRefnum"        , 4/*4*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formUserEmail of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type varchar(255)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    FORMUSEREMAIL         = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "formUserEmail"         , 5/*5*/, 255, "The user's email", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formCountCorrect of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      FORMCOUNTCORRECT      = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "formCountCorrect"      , 6/*6*/, "Whether the answer is correct or not", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formTimeMillisTotal of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      FORMTIMEMILLISTOTAL   = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "formTimeMillisTotal"   , 7/*7*/, "Time in milliseconds for the time spent answering the question", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>testCount of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      TESTCOUNT             = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "testCount"             , 8/*8*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>testAnswerCountCorrect of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      TESTANSWERCOUNTCORRECT= new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "testAnswerCountCorrect", 9/*9*/, "Whether the answer is correct or not", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>testTimeMillisAvg of type double</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double precision</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DoublePrimitiveNull    TESTTIMEMILLISAVG     = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "testTimeMillisAvg"     , 10/*10*/, "Time in milliseconds for the time spent answering the question", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>isPassed of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formCountCorrect >= 2</PRE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitiveNull   ISPASSED              = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "isPassed"              , 11/*11*/, "<B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.", new String[] {"formCountCorrect >= 2"}, new String[] {"formCountCorrect"}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tookLongerThanAverage of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formTimeMillisTotal > testTimeMillisAvg</PRE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitiveNull   TOOKLONGERTHANAVERAGE = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "tookLongerThanAverage" , 12/*12*/, "<B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.", new String[] {"formTimeMillisTotal > testTimeMillisAvg"}, new String[] {"formTimeMillisTotal", "testTimeMillisAvg"}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>wasChallenging of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>    isPassed=1
AND testAnswerCountCorrect < testCount*3/2</PRE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitiveNull   WASCHALLENGING        = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "wasChallenging"        , 13/*13*/, "<B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL>", new String[] {"    isPassed=1", "AND testAnswerCountCorrect < testCount*3/2"}, new String[] {"testAnswerCountCorrect", "testCount", "isPassed"}, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.FORMREFNUM,COLS.FORMTYPE,COLS.FORMFILLDATETZ,COLS.FORMFILLDATE,COLS.FORMUSERREFNUM,COLS.FORMUSEREMAIL,COLS.FORMCOUNTCORRECT,COLS.FORMTIMEMILLISTOTAL,COLS.TESTCOUNT,COLS.TESTANSWERCOUNTCORRECT,COLS.TESTTIMEMILLISAVG,COLS.ISPASSED,COLS.TOOKLONGERTHANAVERAGE,COLS.WASCHALLENGING };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.FORMREFNUM };

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
           tilda.tutorial.data.Test_XYZ_Analytics_Realized_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> _OP;
       protected ArrayListResults<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data Obj = new tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data();
          boolean OK = ((tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Index 'User'
                S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formUserRefnum"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formFillDate"); S.append(" DESC");
                break;
             case 2: // Index 'Type'
                S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formType"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formFillDate"); S.append(" DESC");
                break;
             case 3: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formRefnum"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDATUTORIAL.Test_XYZ_Analytics_Realized", Q, null);
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
             case 1: {  // Index 'User'
               if (Obj.isNullFormUserRefnum() == true) PS.setNull(++i, java.sql.Types.BIGINT    );  else PS.setLong      (++i, Obj._formUserRefnum        );
               break;
             }
             case 2: {  // Index 'Type'
               if (Obj.isNullFormType() == true) PS.setNull(++i, java.sql.Types.VARCHAR   );  else PS.setString    (++i, Obj._formType              );
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
          tilda.tutorial.data._Tilda.TILDA__2_3.handleFinally(PS, T0, TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data();
       String[] vals = null;

       vals = Values.get("formRefnum");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("formRefnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _formRefnum = ParseUtil.parseLong("formRefnum", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_formRefnum != null) Obj.setFormRefnum(_formRefnum);

       vals = Values.get("formType");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("formType", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _formType = ParseUtil.parseString("formType", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_formType != null) Obj.setFormType(_formType);

       vals = Values.get("formFillDate");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("formFillDate", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _formFillDate = ParseUtil.parseZonedDateTime("formFillDate", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_formFillDate != null) Obj.setFormFillDate(_formFillDate);

       vals = Values.get("formUserRefnum");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("formUserRefnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _formUserRefnum = ParseUtil.parseLong("formUserRefnum", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_formUserRefnum != null) Obj.setFormUserRefnum(_formUserRefnum);

       vals = Values.get("formUserEmail");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("formUserEmail", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _formUserEmail = ParseUtil.parseString("formUserEmail", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_formUserEmail != null) Obj.setFormUserEmail(_formUserEmail);

       vals = Values.get("formCountCorrect");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("formCountCorrect", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _formCountCorrect = ParseUtil.parseLong("formCountCorrect", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_formCountCorrect != null) Obj.setFormCountCorrect(_formCountCorrect);

       vals = Values.get("formTimeMillisTotal");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("formTimeMillisTotal", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _formTimeMillisTotal = ParseUtil.parseLong("formTimeMillisTotal", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_formTimeMillisTotal != null) Obj.setFormTimeMillisTotal(_formTimeMillisTotal);

       vals = Values.get("testCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("testCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _testCount = ParseUtil.parseLong("testCount", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_testCount != null) Obj.setTestCount(_testCount);

       vals = Values.get("testAnswerCountCorrect");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("testAnswerCountCorrect", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _testAnswerCountCorrect = ParseUtil.parseLong("testAnswerCountCorrect", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_testAnswerCountCorrect != null) Obj.setTestAnswerCountCorrect(_testAnswerCountCorrect);

       vals = Values.get("testTimeMillisAvg");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("testTimeMillisAvg", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Double _testTimeMillisAvg = ParseUtil.parseDouble("testTimeMillisAvg", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_testTimeMillisAvg != null) Obj.setTestTimeMillisAvg(_testTimeMillisAvg);


       return (tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param formRefnum             The primary key for this record
*/
   static public tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data create(long formRefnum) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setFormRefnum            (formRefnum            );

       // Default Nullables
       Obj.__Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask);

       return (tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__TEST_XYZ_ANALYTICS_REALIZED lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__TEST_XYZ_ANALYTICS_REALIZED) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__TEST_XYZ_ANALYTICS_REALIZED) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__TEST_XYZ_ANALYTICS_REALIZED) d);

               if (((TILDA__TEST_XYZ_ANALYTICS_REALIZED) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (((TILDA__TEST_XYZ_ANALYTICS_REALIZED) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__TEST_XYZ_ANALYTICS_REALIZED) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__TEST_XYZ_ANALYTICS_REALIZED) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'Test_XYZ_Analytics_Realized_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__2_3.handleFinally(PS, T0, TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: formRefnum.
*/
   static public tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data lookupByPrimaryKey(long formRefnum) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data();
       Obj.initForLookup(0);

       Obj.setFormRefnum            (formRefnum            ); Obj.__Saved_formRefnum             = Obj._formRefnum            ;

       return (tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data) Obj;
     }

/**
Lookup records by the index 'User' over  formUserRefnum.<BR>The results are ordered by: formFillDate desc
*/
   static public ListResults<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> lookupWhereUser(Connection C, long formUserRefnum, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setFormUserRefnum        (formUserRefnum        );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }

/**
Lookup records by the index 'User' over  formUserRefnum.<BR>The results are ordered by: formFillDate desc
*/
   static public void lookupWhereUser(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> OP, long formUserRefnum, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setFormUserRefnum        (formUserRefnum        );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }



/**
Lookup records by the index 'Type' over  formType.<BR>The results are ordered by: formFillDate desc
*/
   static public ListResults<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> lookupWhereType(Connection C, String formType, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setFormType              (formType              );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 2, RPI, Obj, null, start, size);
       return RPI._L;
     }

/**
Lookup records by the index 'Type' over  formType.<BR>The results are ordered by: formFillDate desc
*/
   static public void lookupWhereType(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> OP, String formType, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setFormType              (formType              );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, start, size);
     }



/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: formRefnum asc
*/   static public ListResults<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 3, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: formRefnum asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> OP, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 3, RPI, Obj, null, start, size);
     }





   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


   public static String getCSVHeader()
    {
      return "\"formRefnum\",\"formType\",\"formFillDateTZ\",\"formFillDate\",\"formUserRefnum\",\"formUserEmail\",\"formCountCorrect\",\"formTimeMillisTotal\",\"testCount\",\"testAnswerCountCorrect\",\"testTimeMillisAvg\",\"isPassed\",\"tookLongerThanAverage\",\"wasChallenging\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = (tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getFormRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getFormType());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getFormFillDateTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getFormFillDate()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getFormUserRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getFormUserEmail());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getFormCountCorrect());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getFormTimeMillisTotal());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTestCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTestAnswerCountCorrect());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTestTimeMillisAvg());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getIsPassed());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTookLongerThanAverage());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getWasChallenging());
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.tutorial.data.Test_XYZ_Analytics_Realized_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Obj = (tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "formRefnum", ++i==0, Obj.getFormRefnum());

      if (Obj.isNullFormType() == false && Obj.getFormType() != null)
        JSONUtil.print(out, "formType", ++i==0, Obj.getFormType());

      if (Obj.isNullFormFillDateTZ() == false && Obj.getFormFillDateTZ() != null)
        JSONUtil.print(out, "formFillDateTZ", ++i==0, Obj.getFormFillDateTZ());

      if (Obj.isNullFormFillDate() == false && Obj.getFormFillDate() != null)
        JSONUtil.print(out, "formFillDate", ++i==0, Obj.getFormFillDate());

      if (Obj.isNullFormUserRefnum() == false)
        JSONUtil.print(out, "formUserRefnum", ++i==0, Obj.getFormUserRefnum());

      if (Obj.isNullFormUserEmail() == false && Obj.getFormUserEmail() != null)
        JSONUtil.print(out, "formUserEmail", ++i==0, Obj.getFormUserEmail());

      if (Obj.isNullFormCountCorrect() == false)
        JSONUtil.print(out, "formCountCorrect", ++i==0, Obj.getFormCountCorrect());

      if (Obj.isNullFormTimeMillisTotal() == false)
        JSONUtil.print(out, "formTimeMillisTotal", ++i==0, Obj.getFormTimeMillisTotal());

      if (Obj.isNullTestCount() == false)
        JSONUtil.print(out, "testCount", ++i==0, Obj.getTestCount());

      if (Obj.isNullTestAnswerCountCorrect() == false)
        JSONUtil.print(out, "testAnswerCountCorrect", ++i==0, Obj.getTestAnswerCountCorrect());

      if (Obj.isNullTestTimeMillisAvg() == false)
        JSONUtil.print(out, "testTimeMillisAvg", ++i==0, Obj.getTestTimeMillisAvg());

      if (Obj.isNullIsPassed() == false)
        JSONUtil.print(out, "isPassed", ++i==0, Obj.getIsPassed());

      if (Obj.isNullTookLongerThanAverage() == false)
        JSONUtil.print(out, "tookLongerThanAverage", ++i==0, Obj.getTookLongerThanAverage());

      if (Obj.isNullWasChallenging() == false)
        JSONUtil.print(out, "wasChallenging", ++i==0, Obj.getWasChallenging());

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
