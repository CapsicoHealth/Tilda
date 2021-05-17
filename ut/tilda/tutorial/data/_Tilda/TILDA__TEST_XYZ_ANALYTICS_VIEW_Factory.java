
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
     public static Type_LongPrimitive          FORMREFNUM            = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formRefnum"            , 0/*0*/, "The primary key for this record");
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
     public static Type_StringPrimitive        FORMTYPE              = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "formType"              , 1/*1*/, "Form template type");
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
     public static Type_StringPrimitiveNull    FORMFILLDATETZ        = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "formFillDateTZ"        , 2/*2*/, "Generated helper column to hold the time zone ID for 'formFillDate'.");
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
     public static Type_DatetimePrimitiveNull  FORMFILLDATE          = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "formFillDate"          , 3/*3*/, "The date the form was filled", FORMFILLDATETZ);
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
     public static Type_LongPrimitive          FORMUSERREFNUM        = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formUserRefnum"        , 4/*4*/, "The primary key for this record");
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
     public static Type_StringPrimitive        FORMUSEREMAIL         = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "formUserEmail"         , 5/*5*/, "The user's email");
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
     public static Type_LongPrimitive          FORMCOUNTCORRECT      = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formCountCorrect"      , 6/*6*/, "Whether the answer is correct or not");
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
     public static Type_LongPrimitive          FORMTIMEMILLISTOTAL   = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formTimeMillisTotal"   , 7/*7*/, "Time in milliseconds for the time spent answering the question");
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
     public static Type_LongPrimitive          TESTCOUNT             = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "testCount"             , 8/*8*/, "The primary key for this record");
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
     public static Type_LongPrimitive          TESTANSWERCOUNTCORRECT= new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "testAnswerCountCorrect", 9/*9*/, "Whether the answer is correct or not");
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
     public static Type_DoublePrimitive        TESTTIMEMILLISAVG     = new Type_DoublePrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "testTimeMillisAvg"     , 10/*10*/, "Time in milliseconds for the time spent answering the question");
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
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Passed</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   ISPASSED              = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "isPassed"              , 11/*11*/, "Formula column '<B>Test Passed</B>'");
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
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Took Longer Than Average</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   TOOKLONGERTHANAVERAGE = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "tookLongerThanAverage" , 12/*12*/, "Formula column '<B>Test Took Longer Than Average</B>'");
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
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Was Challenging</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   WASCHALLENGING        = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "wasChallenging"        , 13/*13*/, "Formula column '<B>Test Was Challenging</B>'");
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


 }
