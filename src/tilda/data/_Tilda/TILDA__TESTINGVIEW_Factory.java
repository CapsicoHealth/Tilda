
package tilda.data._Tilda;

import java.util.*;

import tilda.db.*;
import tilda.enums.*;
import tilda.types.*;
import tilda.utils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@SuppressWarnings({ "unused" })
public class TILDA__TESTINGVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTINGVIEW_Factory.class.getName());

   protected TILDA__TESTINGVIEW_Factory() { }

   public static final Class<TILDA__TESTINGVIEW> DATA_CLASS= TILDA__TESTINGVIEW.class;
   public static final String SCHEMA_LABEL = TextUtil.Print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.Print("TestingView", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.Print("TILDA.TestingView", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "TestingView"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.name -> TILDA.TestingView."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        NAME  = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "name"  , 0/*0*/, "Medical system unique enterprise id");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.refnum -> TILDA.TestingView."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          REFNUM= new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "refnum", 1/*1*/, "The primary key for this record");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Min -> TILDA.TestingView."a2Min"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Min of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Min of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_CharPrimitiveNull      A2MIN = new Type_CharPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "a2Min" , 2/*2*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Max -> TILDA.TestingView."a2Max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Max of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Max of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_CharPrimitiveNull      A2MAX = new Type_CharPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "a2Max" , 3/*3*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9TZ -> TILDA.TestingView."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9TZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9TZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringCollectionNull   A9TZ  = new Type_StringCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a9TZ"  , 4/*4*/, "Generated helper column to hold the time zone ID for 'a9'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9 -> TILDA.TestingView."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9 of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9 of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimeCollectionNull A9    = new Type_DatetimeCollectionNull(SCHEMA_LABEL, TABLENAME_LABEL, "a9"    , 5/*5*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9c -> TILDA.TestingView."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9c of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9c of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DateCollectionNull     A9C   = new Type_DateCollectionNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a9c"   , 6/*6*/, "The blah");
;
   }

   private static Boolean  __INITIALIZED = false;
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED == false)
        synchronized(__INITIALIZED)
         {
           if (__INITIALIZED == false)
            {
              tilda.data.TestingView_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.TestingView_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.TestingView_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.TestingView_Data> _OP;
       protected ArrayListResults<tilda.data.TestingView_Data> _L = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.TestingView_Data Obj = new tilda.data.TestingView_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__TESTINGVIEW)Obj).Init(_C, RS);
          if (OK == true)
           {
             if (_OP == null)
              _L.add(Obj);
             else
              _OP.Process(Index, Obj);
           }
          return OK;
        }
     }

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__TESTINGVIEW Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "TestingView", "name");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "refnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "a2Min");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "a2Max");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "a9TZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "a9");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "a9c");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "TestingView");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.TestingView", Q, null);
       java.sql.PreparedStatement PS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          switch (LookupId)
           {
             case -7:
                break;
             case -666: break;
             default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot prepare statement.");
           }


          count = JDBCHelper.Process(PS.executeQuery(), RP, Start, true, Size, true);
        }
       catch (java.sql.SQLException E)
        {
          tilda.data._Tilda.TILDA__1_0.HandleCatch(C, E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TESTINGVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.TestingView_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.TestingView_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
     }

 }
