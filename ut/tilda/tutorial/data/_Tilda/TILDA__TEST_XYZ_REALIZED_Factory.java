
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
public class TILDA__TEST_XYZ_REALIZED_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TEST_XYZ_REALIZED_Factory.class.getName());

   protected TILDA__TEST_XYZ_REALIZED_Factory() { }

   public static final Class<TILDA__TEST_XYZ_REALIZED> DATA_CLASS= TILDA__TEST_XYZ_REALIZED.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATUTORIAL", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Test_XYZ_Realized", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATUTORIAL.Test_XYZ_Realized", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATUTORIAL", "Test_XYZ_Realized"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formRefnum -> TILDATUTORIAL.Test_XYZ_Realized."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.formRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive          FORMREFNUM     = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formRefnum"     , 0/*0*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formType -> TILDATUTORIAL.Test_XYZ_Realized."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.formType of type varchar(40)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    FORMTYPE       = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "formType"       , 1/*1*/, 40, "Form template type", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Realized."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formFillDateTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.formFillDateTZ of type varchar(10)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formFillDateTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    FORMFILLDATETZ = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "formFillDateTZ" , 2/*2*/, 10, "Generated helper column to hold the time zone ID for 'formFillDate'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formFillDate of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.formFillDate of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formFillDate</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  FORMFILLDATE   = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "formFillDate"   , 3/*3*/, "The date the form was filled", null, null, FORMFILLDATETZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Realized."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formUserRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.formUserRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formUserRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      FORMUSERREFNUM = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "formUserRefnum" , 4/*4*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formUserEmail -> TILDATUTORIAL.Test_XYZ_Realized."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formUserEmail of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.formUserEmail of type varchar(255)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.formUserEmail</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    FORMUSEREMAIL  = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "formUserEmail"  , 5/*5*/, 255, "The user's email", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.countCorrect -> TILDATUTORIAL.Test_XYZ_Realized."countCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>countCorrect of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.countCorrect of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.countCorrect</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      COUNTCORRECT   = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "countCorrect"   , 6/*6*/, "Whether the answer is correct or not", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.countIncorrect -> TILDATUTORIAL.Test_XYZ_Realized."countIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>countIncorrect of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.countIncorrect of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.countIncorrect</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      COUNTINCORRECT = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "countIncorrect" , 7/*7*/, "Whether the answer is correct or not", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.timeMillisTotal -> TILDATUTORIAL.Test_XYZ_Realized."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeMillisTotal of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.timeMillisTotal of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.timeMillisTotal</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      TIMEMILLISTOTAL= new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisTotal", 8/*8*/, "Time in milliseconds for the time spent answering the question", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.timeMillisAvg -> TILDATUTORIAL.Test_XYZ_Realized."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeMillisAvg of type double</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.timeMillisAvg of type double precision</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.timeMillisAvg</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DoublePrimitiveNull    TIMEMILLISAVG  = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisAvg"  , 9/*9*/, "Time in milliseconds for the time spent answering the question", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.timeMillisMin -> TILDATUTORIAL.Test_XYZ_Realized."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeMillisMin of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.timeMillisMin of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.timeMillisMin</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull   TIMEMILLISMIN  = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisMin"  , 10/*10*/, "Time in milliseconds for the time spent answering the question", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QX_correct -> TILDATUTORIAL.Test_XYZ_Realized."QX_correct"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>QX_correct of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question X (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QX')</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.QX_correct of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QX_correct</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_BooleanPrimitiveNull   QX_CORRECT     = new Type_BooleanPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "QX_correct"     , 11/*11*/, "Question X (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QX')", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QX_timeMillis -> TILDATUTORIAL.Test_XYZ_Realized."QX_timeMillis"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>QX_timeMillis of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question X (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QX')</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.QX_timeMillis of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QX_timeMillis</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull   QX_TIMEMILLIS  = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "QX_timeMillis"  , 12/*12*/, "Question X (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QX')", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QY_correct -> TILDATUTORIAL.Test_XYZ_Realized."QY_correct"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>QY_correct of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question Y (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QY')</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.QY_correct of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QY_correct</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_BooleanPrimitiveNull   QY_CORRECT     = new Type_BooleanPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "QY_correct"     , 13/*13*/, "Question Y (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QY')", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QY_timeMillis -> TILDATUTORIAL.Test_XYZ_Realized."QY_timeMillis"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>QY_timeMillis of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question Y (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QY')</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.QY_timeMillis of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QY_timeMillis</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull   QY_TIMEMILLIS  = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "QY_timeMillis"  , 14/*14*/, "Question Y (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QY')", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QZ_correct -> TILDATUTORIAL.Test_XYZ_Realized."QZ_correct"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>QZ_correct of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question Z (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QZ')</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.QZ_correct of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QZ_correct</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_BooleanPrimitiveNull   QZ_CORRECT     = new Type_BooleanPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "QZ_correct"     , 15/*15*/, "Question Z (pivot of MIN(TILDATUTORIAL.TestAnswer.correct) on TILDATUTORIAL.TestAnswer.questionId='QZ')", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QZ_timeMillis -> TILDATUTORIAL.Test_XYZ_Realized."QZ_timeMillis"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>QZ_timeMillis of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question Z (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QZ')</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Realized.QZ_timeMillis of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Realized.QZ_timeMillis</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull   QZ_TIMEMILLIS  = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "QZ_timeMillis"  , 16/*16*/, "Question Z (pivot of MAX(TILDATUTORIAL.TestAnswer.timeMillis) on TILDATUTORIAL.TestAnswer.questionId='QZ')", null, null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.FORMREFNUM,COLS.FORMTYPE,COLS.FORMFILLDATETZ,COLS.FORMFILLDATE,COLS.FORMUSERREFNUM,COLS.FORMUSEREMAIL,COLS.COUNTCORRECT,COLS.COUNTINCORRECT,COLS.TIMEMILLISTOTAL,COLS.TIMEMILLISAVG,COLS.TIMEMILLISMIN,COLS.QX_CORRECT,COLS.QX_TIMEMILLIS,COLS.QY_CORRECT,COLS.QY_TIMEMILLIS,COLS.QZ_CORRECT,COLS.QZ_TIMEMILLIS };

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
           tilda.tutorial.data.Test_XYZ_Realized_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.tutorial.data.Test_XYZ_Realized_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Realized_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Realized_Data> _OP;
       protected ArrayListResults<tilda.tutorial.data.Test_XYZ_Realized_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.tutorial.data.Test_XYZ_Realized_Data Obj = new tilda.tutorial.data.Test_XYZ_Realized_Data();
          boolean OK = ((tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.tutorial.data.Test_XYZ_Realized_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__TEST_XYZ_REALIZED_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_XYZ_Realized");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Index 'User'
                S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Realized", "formUserRefnum"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Realized", "formFillDate"); S.append(" DESC");
                break;
             case 2: // Index 'Type'
                S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Realized", "formType"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Realized", "formFillDate"); S.append(" DESC");
                break;
             case 3: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Realized", "formRefnum"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDATUTORIAL.Test_XYZ_Realized", Q, null);
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
               if (Obj.isNullFormUserRefnum() == true) PS.setNull(++i, java.sql.Types.BIGINT    );  else PS.setLong      (++i, Obj._formUserRefnum );
               break;
             }
             case 2: {  // Index 'Type'
               if (Obj.isNullFormType() == true) PS.setNull(++i, java.sql.Types.VARCHAR   );  else PS.setString    (++i, Obj._formType       );
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
          tilda.tutorial.data._Tilda.TILDA__2_3.handleFinally(PS, T0, TILDA__TEST_XYZ_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.tutorial.data.Test_XYZ_Realized_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Realized_Data();
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

       vals = Values.get("countCorrect");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("countCorrect", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _countCorrect = ParseUtil.parseLong("countCorrect", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_countCorrect != null) Obj.setCountCorrect(_countCorrect);

       vals = Values.get("countIncorrect");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("countIncorrect", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _countIncorrect = ParseUtil.parseLong("countIncorrect", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_countIncorrect != null) Obj.setCountIncorrect(_countIncorrect);

       vals = Values.get("timeMillisTotal");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("timeMillisTotal", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _timeMillisTotal = ParseUtil.parseLong("timeMillisTotal", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_timeMillisTotal != null) Obj.setTimeMillisTotal(_timeMillisTotal);

       vals = Values.get("timeMillisAvg");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("timeMillisAvg", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Double _timeMillisAvg = ParseUtil.parseDouble("timeMillisAvg", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_timeMillisAvg != null) Obj.setTimeMillisAvg(_timeMillisAvg);

       vals = Values.get("timeMillisMin");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("timeMillisMin", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _timeMillisMin = ParseUtil.parseInteger("timeMillisMin", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_timeMillisMin != null) Obj.setTimeMillisMin(_timeMillisMin);

       vals = Values.get("QX_correct");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("QX_correct", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Boolean _QX_correct = ParseUtil.parseBoolean("QX_correct", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_QX_correct != null) Obj.setQX_correct(_QX_correct);

       vals = Values.get("QX_timeMillis");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("QX_timeMillis", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _QX_timeMillis = ParseUtil.parseInteger("QX_timeMillis", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_QX_timeMillis != null) Obj.setQX_timeMillis(_QX_timeMillis);

       vals = Values.get("QY_correct");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("QY_correct", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Boolean _QY_correct = ParseUtil.parseBoolean("QY_correct", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_QY_correct != null) Obj.setQY_correct(_QY_correct);

       vals = Values.get("QY_timeMillis");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("QY_timeMillis", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _QY_timeMillis = ParseUtil.parseInteger("QY_timeMillis", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_QY_timeMillis != null) Obj.setQY_timeMillis(_QY_timeMillis);

       vals = Values.get("QZ_correct");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("QZ_correct", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Boolean _QZ_correct = ParseUtil.parseBoolean("QZ_correct", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_QZ_correct != null) Obj.setQZ_correct(_QZ_correct);

       vals = Values.get("QZ_timeMillis");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("QZ_timeMillis", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _QZ_timeMillis = ParseUtil.parseInteger("QZ_timeMillis", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_QZ_timeMillis != null) Obj.setQZ_timeMillis(_QZ_timeMillis);


       return (tilda.tutorial.data.Test_XYZ_Realized_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param formRefnum      The primary key for this record
*/
   static public tilda.tutorial.data.Test_XYZ_Realized_Data create(long formRefnum) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Realized_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setFormRefnum     (formRefnum     );

       // Default Nullables
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.FORMTYPE._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.FORMFILLDATE._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.COUNTCORRECT._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.COUNTINCORRECT._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.QX_CORRECT._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.QX_TIMEMILLIS._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.QY_CORRECT._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.QY_TIMEMILLIS._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.QZ_CORRECT._Mask);
       Obj.__Nulls.or(TILDA__TEST_XYZ_REALIZED_Factory.COLS.QZ_TIMEMILLIS._Mask);

       return (tilda.tutorial.data.Test_XYZ_Realized_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.tutorial.data.Test_XYZ_Realized_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__TEST_XYZ_REALIZED lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__TEST_XYZ_REALIZED) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__TEST_XYZ_REALIZED) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.tutorial.data.Test_XYZ_Realized_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__TEST_XYZ_REALIZED) d);

               if (((TILDA__TEST_XYZ_REALIZED) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_XYZ_Realized_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__TEST_XYZ_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (((TILDA__TEST_XYZ_REALIZED) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_XYZ_Realized_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__TEST_XYZ_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__TEST_XYZ_REALIZED) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_XYZ_Realized_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__TEST_XYZ_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__TEST_XYZ_REALIZED) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_XYZ_Realized_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__TEST_XYZ_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.tutorial.data.Test_XYZ_Realized_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'Test_XYZ_Realized_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__2_3.handleFinally(PS, T0, TILDA__TEST_XYZ_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: formRefnum.
*/
   static public tilda.tutorial.data.Test_XYZ_Realized_Data lookupByPrimaryKey(long formRefnum) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Realized_Data();
       Obj.initForLookup(0);

       Obj.setFormRefnum     (formRefnum     ); Obj.__Saved_formRefnum      = Obj._formRefnum     ;

       return (tilda.tutorial.data.Test_XYZ_Realized_Data) Obj;
     }

/**
Lookup records by the index 'User' over  formUserRefnum.<BR>The results are ordered by: formFillDate desc
*/
   static public ListResults<tilda.tutorial.data.Test_XYZ_Realized_Data> lookupWhereUser(Connection C, long formUserRefnum, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setFormUserRefnum (formUserRefnum );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }

/**
Lookup records by the index 'User' over  formUserRefnum.<BR>The results are ordered by: formFillDate desc
*/
   static public void lookupWhereUser(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Realized_Data> OP, long formUserRefnum, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setFormUserRefnum (formUserRefnum );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }



/**
Lookup records by the index 'Type' over  formType.<BR>The results are ordered by: formFillDate desc
*/
   static public ListResults<tilda.tutorial.data.Test_XYZ_Realized_Data> lookupWhereType(Connection C, String formType, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setFormType       (formType       );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 2, RPI, Obj, null, start, size);
       return RPI._L;
     }

/**
Lookup records by the index 'Type' over  formType.<BR>The results are ordered by: formFillDate desc
*/
   static public void lookupWhereType(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Realized_Data> OP, String formType, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setFormType       (formType       );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, start, size);
     }



/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: formRefnum asc
*/   static public ListResults<tilda.tutorial.data.Test_XYZ_Realized_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 3, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: formRefnum asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Realized_Data> OP, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = new tilda.tutorial.data.Test_XYZ_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 3, RPI, Obj, null, start, size);
     }





   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.tutorial.data.Test_XYZ_Realized_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_XYZ_Realized_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


   public static String getCSVHeader()
    {
      return "\"formRefnum\",\"formType\",\"formFillDateTZ\",\"formFillDate\",\"formUserRefnum\",\"formUserEmail\",\"countCorrect\",\"countIncorrect\",\"timeMillisTotal\",\"timeMillisAvg\",\"timeMillisMin\",\"QX_correct\",\"QX_timeMillis\",\"QY_correct\",\"QY_timeMillis\",\"QZ_correct\",\"QZ_timeMillis\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.tutorial.data.Test_XYZ_Realized_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.tutorial.data.Test_XYZ_Realized_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.tutorial.data.Test_XYZ_Realized_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = (tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED) obj;
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
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getCountCorrect());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getCountIncorrect());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeMillisTotal());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeMillisAvg());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeMillisMin());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getQX_correct());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getQX_timeMillis());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getQY_correct());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getQY_timeMillis());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getQZ_correct());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getQZ_timeMillis());
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.tutorial.data.Test_XYZ_Realized_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.tutorial.data.Test_XYZ_Realized_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.tutorial.data.Test_XYZ_Realized_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.tutorial.data.Test_XYZ_Realized_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.tutorial.data.Test_XYZ_Realized_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED Obj = (tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_REALIZED) obj;
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

      if (Obj.isNullCountCorrect() == false)
        JSONUtil.print(out, "countCorrect", ++i==0, Obj.getCountCorrect());

      if (Obj.isNullCountIncorrect() == false)
        JSONUtil.print(out, "countIncorrect", ++i==0, Obj.getCountIncorrect());

      if (Obj.isNullTimeMillisTotal() == false)
        JSONUtil.print(out, "timeMillisTotal", ++i==0, Obj.getTimeMillisTotal());

      if (Obj.isNullTimeMillisAvg() == false)
        JSONUtil.print(out, "timeMillisAvg", ++i==0, Obj.getTimeMillisAvg());

      if (Obj.isNullTimeMillisMin() == false)
        JSONUtil.print(out, "timeMillisMin", ++i==0, Obj.getTimeMillisMin());

      if (Obj.isNullQX_correct() == false)
        JSONUtil.print(out, "QX_correct", ++i==0, Obj.getQX_correct());

      if (Obj.isNullQX_timeMillis() == false)
        JSONUtil.print(out, "QX_timeMillis", ++i==0, Obj.getQX_timeMillis());

      if (Obj.isNullQY_correct() == false)
        JSONUtil.print(out, "QY_correct", ++i==0, Obj.getQY_correct());

      if (Obj.isNullQY_timeMillis() == false)
        JSONUtil.print(out, "QY_timeMillis", ++i==0, Obj.getQY_timeMillis());

      if (Obj.isNullQZ_correct() == false)
        JSONUtil.print(out, "QZ_correct", ++i==0, Obj.getQZ_correct());

      if (Obj.isNullQZ_timeMillis() == false)
        JSONUtil.print(out, "QZ_timeMillis", ++i==0, Obj.getQZ_timeMillis());

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
