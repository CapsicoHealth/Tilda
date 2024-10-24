
package tilda.data_test._Tilda;

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
public class TILDA__TESTINGVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTINGVIEW_Factory.class.getName());

   protected TILDA__TESTINGVIEW_Factory() { }

   public static final Class<TILDA__TESTINGVIEW> DATA_CLASS= TILDA__TESTINGVIEW.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATEST", "");
   public static final String TABLENAME_LABEL = TextUtil.print("TestingView", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATEST.TestingView", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATEST", "TestingView"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingView.name -> TILDATEST.TestingView."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>name of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingView.name of type varchar(10)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingView.name</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              NAME   = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "name"   , 0/*0*/, 10, "Medical system unique enterprise id", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingView.refnum -> TILDATEST.TestingView."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingView.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingView.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                REFNUM = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "refnum" , 1/*1*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingView.a2Min -> TILDATEST.TestingView."a2Min"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>a2Min of type char</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingView.a2Min of type character</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingView.a2Min</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_CharPrimitiveNull            A2MIN  = new Type_CharPrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "a2Min"  , 2/*2*/, "The blah", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingView.a2Max -> TILDATEST.TestingView."a2Max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>a2Max of type char</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingView.a2Max of type character</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingView.a2Max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_CharPrimitiveNull            A2MAX  = new Type_CharPrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "a2Max"  , 3/*3*/, "The blah", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingView.a9TZ -> TILDATEST.TestingView."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>a9TZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingView.a9TZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingView.a9TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringCollectionNull         A9TZ   = new Type_StringCollectionNull        (SCHEMA_LABEL, TABLENAME_LABEL, "a9TZ"   , 4/*4*/, "Generated helper column to hold the time zone ID for 'a9'.", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingView.a9 -> TILDATEST.TestingView."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>a9 of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingView.a9 of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingView.a9</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'a9TZ'</LI>
</TD></TR>

  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>a9_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_DatetimeCollectionNull       A9     = new Type_DatetimeCollectionNull      (SCHEMA_LABEL, TABLENAME_LABEL, "a9"     , 5/*5*/, "The blah", null, null, A9TZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingView.a9c -> TILDATEST.TestingView."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>a9c of type List&lt;LocalDate&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingView.a9c of type date[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingView.a9c</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DateCollectionNull           A9C    = new Type_DateCollectionNull          (SCHEMA_LABEL, TABLENAME_LABEL, "a9c"    , 6/*6*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingView.a6First -> TILDATEST.TestingView."a6First"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>a6First of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingView.a6First of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingView.a6First</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull            A6FIRST= new Type_LongPrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "a6First", 7/*7*/, "The blah", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingView.a6Last -> TILDATEST.TestingView."a6Last"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>a6Last of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingView.a6Last of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingView.a6Last</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull            A6LAST = new Type_LongPrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "a6Last" , 8/*8*/, "The blah", null, null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.NAME,COLS.REFNUM,COLS.A2MIN,COLS.A2MAX,COLS.A9TZ,COLS.A9,COLS.A9C,COLS.A6FIRST,COLS.A6LAST };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] {  };

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
           tilda.data_test.TestingView_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data_test.TestingView_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.TestingView_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data_test.TestingView_Data> _OP;
       protected ArrayListResults<tilda.data_test.TestingView_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data_test.TestingView_Data Obj = new tilda.data_test.TestingView_Data();
          boolean OK = ((tilda.data_test._Tilda.TILDA__TESTINGVIEW)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data_test.TestingView_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data_test._Tilda.TILDA__TESTINGVIEW Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__TESTINGVIEW_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "TestingView");
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
       QueryDetails.logQuery("TILDATEST.TestingView", Q, null);
       java.sql.PreparedStatement PS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
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
          tilda.data_test._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__TESTINGVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
Lookup records by the query 'All' over 
.<BR>
*/
   static public tilda.data_test.TestingView_Data lookupByAll() throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTINGVIEW Obj = new tilda.data_test.TestingView_Data();
       Obj.initForLookup(0);


       return (tilda.data_test.TestingView_Data) Obj;
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data_test.TestingView_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data_test.TestingView_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
     }


   public static String getCSVHeader()
    {
      return "\"name\",\"refnum\",\"a2Min\",\"a2Max\",\"a9TZ\",\"a9\",\"a9c\",\"a6First\",\"a6Last\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data_test.TestingView_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data_test.TestingView_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data_test.TestingView_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data_test._Tilda.TILDA__TESTINGVIEW Obj = (tilda.data_test._Tilda.TILDA__TESTINGVIEW) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getA2Min());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getA2Max());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getA9TZ(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getA9(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getA9c(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getA6First());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getA6Last());
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data_test.TestingView_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data_test.TestingView_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data_test.TestingView_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data_test.TestingView_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data_test.TestingView_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data_test._Tilda.TILDA__TESTINGVIEW Obj = (tilda.data_test._Tilda.TILDA__TESTINGVIEW) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "name", ++i==0, Obj.getName());

        JSONUtil.print(out, "refnum", ++i==0, Obj.getRefnum());

      if (Obj.isNullA2Min() == false)
        JSONUtil.print(out, "a2Min", ++i==0, Obj.getA2Min());

      if (Obj.isNullA2Max() == false)
        JSONUtil.print(out, "a2Max", ++i==0, Obj.getA2Max());

      if (Obj.isNullA9TZ() == false && Obj.getA9TZ() != null)
        JSONUtil.print(out, "a9TZ", ++i==0, Obj.getA9TZAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "a9TZ", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullA9() == false && Obj.getA9() != null)
        JSONUtil.print(out, "a9", ++i==0, Obj.getA9AsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "a9", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullA9c() == false && Obj.getA9c() != null)
        JSONUtil.print(out, "a9c", ++i==0, Obj.getA9cAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "a9c", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullA6First() == false)
        JSONUtil.print(out, "a6First", ++i==0, Obj.getA6First());

      if (Obj.isNullA6Last() == false)
        JSONUtil.print(out, "a6Last", ++i==0, Obj.getA6Last());

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
