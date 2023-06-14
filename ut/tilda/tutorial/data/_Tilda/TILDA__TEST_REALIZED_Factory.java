
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
public class TILDA__TEST_REALIZED_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TEST_REALIZED_Factory.class.getName());

   protected TILDA__TEST_REALIZED_Factory() { }

   public static final Class<TILDA__TEST_REALIZED> DATA_CLASS= TILDA__TEST_REALIZED.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATUTORIAL", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Test_Realized", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATUTORIAL.Test_Realized", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATUTORIAL", "Test_Realized"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type -> TILDATUTORIAL.Test_Realized."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.type of type varchar(40)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        TYPE                = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "type"                , 0/*0*/, 40, "Form template type", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount -> TILDATUTORIAL.Test_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>testCount of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testCount of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      TESTCOUNT           = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "testCount"           , 1/*1*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ -> TILDATUTORIAL.Test_Realized."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>testFirstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirstTZ of type varchar(10)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    TESTFIRSTTZ         = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "testFirstTZ"         , 2/*2*/, 10, "Generated helper column to hold the time zone ID for 'testFirst'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>testFirst of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  TESTFIRST           = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "testFirst"           , 3/*3*/, "The date the form was filled", null, null, TESTFIRSTTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ -> TILDATUTORIAL.Test_Realized."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>testLastTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLastTZ of type varchar(10)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    TESTLASTTZ          = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "testLastTZ"          , 4/*4*/, 10, "Generated helper column to hold the time zone ID for 'testLast'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>testLast of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  TESTLAST            = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "testLast"            , 5/*5*/, "The date the form was filled", null, null, TESTLASTTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount -> TILDATUTORIAL.Test_Realized."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>userCount of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.userCount of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      USERCOUNT           = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "userCount"           , 6/*6*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount -> TILDATUTORIAL.Test_Realized."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>answerCount of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCount of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      ANSWERCOUNT         = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "answerCount"         , 7/*7*/, "Whether the answer is correct or not", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect -> TILDATUTORIAL.Test_Realized."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>answerCountCorrect of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountCorrect of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      ANSWERCOUNTCORRECT  = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "answerCountCorrect"  , 8/*8*/, "Whether the answer is correct or not", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect -> TILDATUTORIAL.Test_Realized."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>answerCountIncorrect of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountIncorrect of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      ANSWERCOUNTINCORRECT= new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "answerCountIncorrect", 9/*9*/, "Whether the answer is correct or not", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal -> TILDATUTORIAL.Test_Realized."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeMillisTotal of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisTotal of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      TIMEMILLISTOTAL     = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisTotal"     , 10/*10*/, "Time in milliseconds for the time spent answering the question", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg -> TILDATUTORIAL.Test_Realized."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeMillisAvg of type double</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisAvg of type double precision</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DoublePrimitiveNull    TIMEMILLISAVG       = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisAvg"       , 11/*11*/, "Time in milliseconds for the time spent answering the question", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin -> TILDATUTORIAL.Test_Realized."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeMillisMin of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMin of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull   TIMEMILLISMIN       = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisMin"       , 12/*12*/, "Time in milliseconds for the time spent answering the question", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax -> TILDATUTORIAL.Test_Realized."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeMillisMax of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMax of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull   TIMEMILLISMAX       = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "timeMillisMax"       , 13/*13*/, "Time in milliseconds for the time spent answering the question", null, null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.TYPE,COLS.TESTCOUNT,COLS.TESTFIRSTTZ,COLS.TESTFIRST,COLS.TESTLASTTZ,COLS.TESTLAST,COLS.USERCOUNT,COLS.ANSWERCOUNT,COLS.ANSWERCOUNTCORRECT,COLS.ANSWERCOUNTINCORRECT,COLS.TIMEMILLISTOTAL,COLS.TIMEMILLISAVG,COLS.TIMEMILLISMIN,COLS.TIMEMILLISMAX };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.TYPE };

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
           tilda.tutorial.data.Test_Realized_Factory.init(C);
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
          C.getFullColumnVarList(S, TILDA__TEST_REALIZED_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_Realized");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
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
             case 1: { // Query 'All'
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
          tilda.tutorial.data._Tilda.TILDA__2_3.handleFinally(PS, T0, TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
 @param type                 (max size 40) Form template type
*/
   static public tilda.tutorial.data.Test_Realized_Data create(String type) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj = new tilda.tutorial.data.Test_Realized_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setType                (type                );

       // Default Nullables
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask);
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask);
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask);
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask);
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask);
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask);
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask);
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask);
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask);
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask);
       Obj.__Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask);

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
               ++count;

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
           TILDA__2_3.handleFinally(PS, T0, TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: type.
*/
   static public tilda.tutorial.data.Test_Realized_Data lookupByPrimaryKey(String type) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj = new tilda.tutorial.data.Test_Realized_Data();
       Obj.initForLookup(0);

       Obj.setType                (type                ); Obj.__Saved_type                 = Obj._type                ;

       return (tilda.tutorial.data.Test_Realized_Data) Obj;
     }

/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: type asc
*/   static public ListResults<tilda.tutorial.data.Test_Realized_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj = new tilda.tutorial.data.Test_Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: type asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Test_Realized_Data> OP, int start, int size) throws Exception
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


   public static String getCSVHeader()
    {
      return "\"type\",\"testCount\",\"testFirstTZ\",\"testFirst\",\"testLastTZ\",\"testLast\",\"userCount\",\"answerCount\",\"answerCountCorrect\",\"answerCountIncorrect\",\"timeMillisTotal\",\"timeMillisAvg\",\"timeMillisMin\",\"timeMillisMax\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.tutorial.data.Test_Realized_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.tutorial.data.Test_Realized_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.tutorial.data.Test_Realized_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj = (tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getType());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTestCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getTestFirstTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getTestFirst()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getTestLastTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getTestLast()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getUserCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getAnswerCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getAnswerCountCorrect());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getAnswerCountIncorrect());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeMillisTotal());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeMillisAvg());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeMillisMin());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeMillisMax());
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.tutorial.data.Test_Realized_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.tutorial.data.Test_Realized_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.tutorial.data.Test_Realized_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.tutorial.data.Test_Realized_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.tutorial.data.Test_Realized_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Obj = (tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "type", ++i==0, Obj.getType());

      if (Obj.isNullTestCount() == false)
        JSONUtil.print(out, "testCount", ++i==0, Obj.getTestCount());

      if (Obj.isNullTestFirstTZ() == false && Obj.getTestFirstTZ() != null)
        JSONUtil.print(out, "testFirstTZ", ++i==0, Obj.getTestFirstTZ());

      if (Obj.isNullTestFirst() == false && Obj.getTestFirst() != null)
        JSONUtil.print(out, "testFirst", ++i==0, Obj.getTestFirst());

      if (Obj.isNullTestLastTZ() == false && Obj.getTestLastTZ() != null)
        JSONUtil.print(out, "testLastTZ", ++i==0, Obj.getTestLastTZ());

      if (Obj.isNullTestLast() == false && Obj.getTestLast() != null)
        JSONUtil.print(out, "testLast", ++i==0, Obj.getTestLast());

      if (Obj.isNullUserCount() == false)
        JSONUtil.print(out, "userCount", ++i==0, Obj.getUserCount());

      if (Obj.isNullAnswerCount() == false)
        JSONUtil.print(out, "answerCount", ++i==0, Obj.getAnswerCount());

      if (Obj.isNullAnswerCountCorrect() == false)
        JSONUtil.print(out, "answerCountCorrect", ++i==0, Obj.getAnswerCountCorrect());

      if (Obj.isNullAnswerCountIncorrect() == false)
        JSONUtil.print(out, "answerCountIncorrect", ++i==0, Obj.getAnswerCountIncorrect());

      if (Obj.isNullTimeMillisTotal() == false)
        JSONUtil.print(out, "timeMillisTotal", ++i==0, Obj.getTimeMillisTotal());

      if (Obj.isNullTimeMillisAvg() == false)
        JSONUtil.print(out, "timeMillisAvg", ++i==0, Obj.getTimeMillisAvg());

      if (Obj.isNullTimeMillisMin() == false)
        JSONUtil.print(out, "timeMillisMin", ++i==0, Obj.getTimeMillisMin());

      if (Obj.isNullTimeMillisMax() == false)
        JSONUtil.print(out, "timeMillisMax", ++i==0, Obj.getTimeMillisMax());

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
