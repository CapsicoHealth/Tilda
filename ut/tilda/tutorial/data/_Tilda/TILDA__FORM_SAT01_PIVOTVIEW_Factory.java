
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
public class TILDA__FORM_SAT01_PIVOTVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__FORM_SAT01_PIVOTVIEW_Factory.class.getName());

   protected TILDA__FORM_SAT01_PIVOTVIEW_Factory() { }

   public static final Class<TILDA__FORM_SAT01_PIVOTVIEW> DATA_CLASS= TILDA__FORM_SAT01_PIVOTVIEW.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATUTORIAL", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Form_SAT01_PivotView", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATUTORIAL.Form_SAT01_PivotView", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.formRefnum -> TILDATUTORIAL.Form_SAT01_PivotView."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Form_SAT01_PivotView.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          FORMREFNUM    = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formRefnum"    , 0/*0*/, "The primary key for this record");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.formFillDateTZ -> TILDATUTORIAL.Form_SAT01_PivotView."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Form_SAT01_PivotView.formFillDateTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    FORMFILLDATETZ= new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "formFillDateTZ", 1/*1*/, "Generated helper column to hold the time zone ID for 'formFillDate'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.formFillDate -> TILDATUTORIAL.Form_SAT01_PivotView."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Form_SAT01_PivotView.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  FORMFILLDATE  = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "formFillDate"  , 2/*2*/, "The date the form was filled", FORMFILLDATETZ);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.formUserRefnum -> TILDATUTORIAL.Form_SAT01_PivotView."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Form_SAT01_PivotView.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          FORMUSERREFNUM= new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formUserRefnum", 3/*3*/, "The primary key for this record");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.formUserEmail -> TILDATUTORIAL.Form_SAT01_PivotView."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Form_SAT01_PivotView.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        FORMUSEREMAIL = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "formUserEmail" , 4/*4*/, "The user's email");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.Q1 -> TILDATUTORIAL.Form_SAT01_PivotView."Q1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.Q1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Form_SAT01_PivotView.Q1 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q1 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field='Q1')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   Q1            = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "Q1"            , 5/*5*/, "Q1 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field='Q1')");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.Q2 -> TILDATUTORIAL.Form_SAT01_PivotView."Q2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.Q2 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Form_SAT01_PivotView.Q2 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q2 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field='Q2')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   Q2            = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "Q2"            , 6/*6*/, "Q2 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field='Q2')");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.Q3 -> TILDATUTORIAL.Form_SAT01_PivotView."Q3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.Q3 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Form_SAT01_PivotView.Q3 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q3 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field='Q3')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   Q3            = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "Q3"            , 7/*7*/, "Q3 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field='Q3')");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.Q4 -> TILDATUTORIAL.Form_SAT01_PivotView."Q4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Form_SAT01_PivotView.Q4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Form_SAT01_PivotView.Q4 of type varchar(4000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>4000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q4 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field='Q4')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    Q4            = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "Q4"            , 8/*8*/, "Q4 (pivot of MAX(TILDATUTORIAL.FormAnswer.value) on TILDATUTORIAL.FormAnswer.field='Q4')");
;
   }

   public static final ColumnDefinition[] COLUMNS = { COLS.FORMREFNUM,COLS.FORMFILLDATETZ,COLS.FORMFILLDATE,COLS.FORMUSERREFNUM,COLS.FORMUSEREMAIL,COLS.Q1,COLS.Q2,COLS.Q3,COLS.Q4 };

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
              tilda.tutorial.data.Form_SAT01_PivotView_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.tutorial.data.Form_SAT01_PivotView_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Form_SAT01_PivotView_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Form_SAT01_PivotView_Data> _OP;
       protected ArrayListResults<tilda.tutorial.data.Form_SAT01_PivotView_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.tutorial.data.Form_SAT01_PivotView_Data Obj = new tilda.tutorial.data.Form_SAT01_PivotView_Data();
          boolean OK = ((tilda.tutorial.data._Tilda.TILDA__FORM_SAT01_PIVOTVIEW)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.tutorial.data.Form_SAT01_PivotView_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.tutorial.data._Tilda.TILDA__FORM_SAT01_PIVOTVIEW Obj, Object ExtraParams, int start, int size) throws Exception
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
          S.append(" "); C.getFullColumnVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView", "formRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView", "formFillDateTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView", "formFillDate");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView", "formUserRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView", "formUserEmail");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView", "Q1");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView", "Q2");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView", "Q3");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView", "Q4");
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "Form_SAT01_PivotView");
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
       QueryDetails.logQuery("TILDATUTORIAL.Form_SAT01_PivotView", Q, null);
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__FORM_SAT01_PIVOTVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.tutorial.data.Form_SAT01_PivotView_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.Form_SAT01_PivotView_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }


 }
