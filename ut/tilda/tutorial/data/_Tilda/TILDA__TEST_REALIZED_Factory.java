
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
public class TILDA__TEST_REALIZED_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TEST_REALIZED_Factory.class.getName());

   protected TILDA__TEST_REALIZED_Factory() { }

   public static final Class<TILDA__TEST_REALIZED> DATA_CLASS= TILDA__TEST_REALIZED.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATUTORIAL", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Test_Realized", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATUTORIAL.Test_Realized", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATUTORIAL", "Test_Realized"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type -> TILDATUTORIAL.Test_Realized."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.type of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type (from TILDATUTORIAL.Test_View.type)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        TYPE                = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "type"                , 0/*0*/, "Form template type (from TILDATUTORIAL.Test_View.type)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount -> TILDATUTORIAL.Test_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitiveNull      TESTCOUNT           = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "testCount"           , 1/*1*/, "The primary key for this record (from TILDATUTORIAL.Test_View.testCount)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ -> TILDATUTORIAL.Test_Realized."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'. (from TILDATUTORIAL.Test_View.testFirstTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    TESTFIRSTTZ         = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "testFirstTZ"         , 2/*2*/, "Generated helper column to hold the time zone ID for 'testFirst'. (from TILDATUTORIAL.Test_View.testFirstTZ)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  TESTFIRST           = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "testFirst"           , 3/*3*/, "The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)", TESTFIRSTTZ);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ -> TILDATUTORIAL.Test_Realized."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'. (from TILDATUTORIAL.Test_View.testLastTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    TESTLASTTZ          = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "testLastTZ"          , 4/*4*/, "Generated helper column to hold the time zone ID for 'testLast'. (from TILDATUTORIAL.Test_View.testLastTZ)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  TESTLAST            = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "testLast"            , 5/*5*/, "The date the form was filled (from TILDATUTORIAL.Test_View.testLast)", TESTLASTTZ);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount -> TILDATUTORIAL.Test_Realized."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.userCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.userCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitiveNull      USERCOUNT           = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "userCount"           , 6/*6*/, "The primary key for this record (from TILDATUTORIAL.Test_View.userCount)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount -> TILDATUTORIAL.Test_Realized."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitiveNull      ANSWERCOUNT         = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "answerCount"         , 7/*7*/, "Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect -> TILDATUTORIAL.Test_Realized."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitiveNull      ANSWERCOUNTCORRECT  = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "answerCountCorrect"  , 8/*8*/, "Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect -> TILDATUTORIAL.Test_Realized."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountIncorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitiveNull      ANSWERCOUNTINCORRECT= new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "answerCountIncorrect", 9/*9*/, "Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal -> TILDATUTORIAL.Test_Realized."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitiveNull      TIMEMILLISTOTAL     = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisTotal"     , 10/*10*/, "Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg -> TILDATUTORIAL.Test_Realized."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoublePrimitiveNull    TIMEMILLISAVG       = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisAvg"       , 11/*11*/, "Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin -> TILDATUTORIAL.Test_Realized."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMin of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   TIMEMILLISMIN       = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisMin"       , 12/*12*/, "Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax -> TILDATUTORIAL.Test_Realized."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMax of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   TIMEMILLISMAX       = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisMax"       , 13/*13*/, "Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)");
;
   }

   public static final ColumnDefinition[] COLUMNS = { COLS.TYPE,COLS.TESTCOUNT,COLS.TESTFIRSTTZ,COLS.TESTFIRST,COLS.TESTLASTTZ,COLS.TESTLAST,COLS.USERCOUNT,COLS.ANSWERCOUNT,COLS.ANSWERCOUNTCORRECT,COLS.ANSWERCOUNTINCORRECT,COLS.TIMEMILLISTOTAL,COLS.TIMEMILLISAVG,COLS.TIMEMILLISMIN,COLS.TIMEMILLISMAX };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = { COLS.TYPE };

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
              tilda.tutorial.data.Test_Realized_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.tutorial.data.Test_Realized_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_Realized_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_Realized_Data> _OP;
       protected ArrayListResults<tilda.tutorial.data.Test_Realized_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.tutorial.data.Test_Realized_Data Obj = new tilda.tutorial.data.Test_Realized_Data();
          boolean OK = ((tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.tutorial.data.Test_Realized_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj, Object ExtraParams, int start, int size) throws Exception
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
          S.append(" "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "type");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "testCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "testFirstTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "testFirst");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "testLastTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "testLast");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "userCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "answerCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "answerCountCorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "answerCountIncorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "timeMillisTotal");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "timeMillisAvg");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "timeMillisMin");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "timeMillisMax");
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_Realized");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1:
                S.append(" where (1=1)");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "type"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDATUTORIAL.Test_Realized", Q, null);
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
             case 1: {
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.tutorial.data.Test_Realized_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj = new tilda.tutorial.data.Test_Realized_Data();
       String[] vals = null;

       vals = Values.get("type");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("type", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _type = ParseUtil.parseString("type", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_type != null) Obj.setType(_type);

       vals = Values.get("testCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("testCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _testCount = ParseUtil.parseLong("testCount", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_testCount != null) Obj.setTestCount(_testCount);

       vals = Values.get("testFirst");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("testFirst", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _testFirst = ParseUtil.parseZonedDateTime("testFirst", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_testFirst != null) Obj.setTestFirst(_testFirst);

       vals = Values.get("testLast");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("testLast", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _testLast = ParseUtil.parseZonedDateTime("testLast", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_testLast != null) Obj.setTestLast(_testLast);

       vals = Values.get("userCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("userCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _userCount = ParseUtil.parseLong("userCount", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_userCount != null) Obj.setUserCount(_userCount);

       vals = Values.get("answerCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("answerCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _answerCount = ParseUtil.parseLong("answerCount", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_answerCount != null) Obj.setAnswerCount(_answerCount);

       vals = Values.get("answerCountCorrect");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("answerCountCorrect", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _answerCountCorrect = ParseUtil.parseLong("answerCountCorrect", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_answerCountCorrect != null) Obj.setAnswerCountCorrect(_answerCountCorrect);

       vals = Values.get("answerCountIncorrect");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("answerCountIncorrect", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _answerCountIncorrect = ParseUtil.parseLong("answerCountIncorrect", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_answerCountIncorrect != null) Obj.setAnswerCountIncorrect(_answerCountIncorrect);

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

       vals = Values.get("timeMillisMax");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("timeMillisMax", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _timeMillisMax = ParseUtil.parseInteger("timeMillisMax", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_timeMillisMax != null) Obj.setTimeMillisMax(_timeMillisMax);


       return (tilda.tutorial.data.Test_Realized_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param type                 (max size 40) Form template type (from TILDATUTORIAL.Test_View.type)
*/
   static public tilda.tutorial.data.Test_Realized_Data create(String type) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj = new tilda.tutorial.data.Test_Realized_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setType                (type                );

       return (tilda.tutorial.data.Test_Realized_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.tutorial.data.Test_Realized_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__TEST_REALIZED lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__TEST_REALIZED) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__TEST_REALIZED) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.tutorial.data.Test_Realized_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__TEST_REALIZED) d);

               if (((TILDA__TEST_REALIZED) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_Realized_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (((TILDA__TEST_REALIZED) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_Realized_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__TEST_REALIZED) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_Realized_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__TEST_REALIZED) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.Test_Realized_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.tutorial.data.Test_Realized_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'Test_Realized_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__1_0.handleFinally(PS, T0, TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

   static public tilda.tutorial.data.Test_Realized_Data lookupByPrimaryKey(String type) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj = new tilda.tutorial.data.Test_Realized_Data();
       Obj.initForLookup(0);

       Obj.setType                (type                ); Obj.__Saved_type                 = Obj._type                ;

       return (tilda.tutorial.data.Test_Realized_Data) Obj;
     }


   static public ListResults<tilda.tutorial.data.Test_Realized_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj = new tilda.tutorial.data.Test_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }


   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_Realized_Data> OP, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj = new tilda.tutorial.data.Test_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.tutorial.data.Test_Realized_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_Realized_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


 }
