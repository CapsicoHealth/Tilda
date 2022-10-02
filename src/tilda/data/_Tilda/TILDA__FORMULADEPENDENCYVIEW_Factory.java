
package tilda.data._Tilda;

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
public class TILDA__FORMULADEPENDENCYVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__FORMULADEPENDENCYVIEW_Factory.class.getName());

   protected TILDA__FORMULADEPENDENCYVIEW_Factory() { }

   public static final Class<TILDA__FORMULADEPENDENCYVIEW> DATA_CLASS= TILDA__FORMULADEPENDENCYVIEW.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("FormulaDependencyView", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.FormulaDependencyView", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "FormulaDependencyView"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.formulaRefnum -> TILDA.FormulaDependencyView."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.formulaRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive          FORMULAREFNUM             = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formulaRefnum"             , 0/*0*/, "The parent formula.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.location -> TILDA.FormulaDependencyView."location"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.location of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.location of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        LOCATION                  = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "location"                  , 1/*1*/, "The name of the primary table/view this formula is defined in.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.name -> TILDA.FormulaDependencyView."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.name of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        NAME                      = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "name"                      , 2/*2*/, "The name of the formula/column.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.referencedColumns -> TILDA.FormulaDependencyView."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.referencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.referencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringCollectionNull   REFERENCEDCOLUMNS         = new Type_StringCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "referencedColumns"         , 3/*3*/, "The list of columns this formula depends on.", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependencyRefnum -> TILDA.FormulaDependencyView."dependencyRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependencyRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependencyRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The dependent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive          DEPENDENCYREFNUM          = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "dependencyRefnum"          , 4/*4*/, "The dependent formula.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentFormulaName -> TILDA.FormulaDependencyView."dependentFormulaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentFormulaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentFormulaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        DEPENDENTFORMULANAME      = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "dependentFormulaName"      , 5/*5*/, "The name of the formula/column.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation -> TILDA.FormulaDependencyView."dependentFormulaLocation"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentFormulaLocation of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        DEPENDENTFORMULALOCATION  = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "dependentFormulaLocation"  , 6/*6*/, "The name of the primary table/view this formula is defined in.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns -> TILDA.FormulaDependencyView."dependentReferencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentReferencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringCollectionNull   DEPENDENTREFERENCEDCOLUMNS= new Type_StringCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "dependentReferencedColumns", 7/*7*/, "The list of columns this formula depends on.", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.FORMULAREFNUM,COLS.LOCATION,COLS.NAME,COLS.REFERENCEDCOLUMNS,COLS.DEPENDENCYREFNUM,COLS.DEPENDENTFORMULANAME,COLS.DEPENDENTFORMULALOCATION,COLS.DEPENDENTREFERENCEDCOLUMNS };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] {  };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = new ColumnDefinition[][]{ 
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
              tilda.data.FormulaDependencyView_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.FormulaDependencyView_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.FormulaDependencyView_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.FormulaDependencyView_Data> _OP;
       protected ArrayListResults<tilda.data.FormulaDependencyView_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.FormulaDependencyView_Data Obj = new tilda.data.FormulaDependencyView_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__FORMULADEPENDENCYVIEW)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.FormulaDependencyView_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__FORMULADEPENDENCYVIEW Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__FORMULADEPENDENCYVIEW_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "FormulaDependencyView");
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
       QueryDetails.logQuery("TILDA.FormulaDependencyView", Q, null);
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
          tilda.data._Tilda.TILDA__2_2.handleFinally(PS, T0, TILDA__FORMULADEPENDENCYVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
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
   static public tilda.data.FormulaDependencyView_Data lookupByAll() throws Exception
     {
       tilda.data._Tilda.TILDA__FORMULADEPENDENCYVIEW Obj = new tilda.data.FormulaDependencyView_Data();
       Obj.initForLookup(0);


       return (tilda.data.FormulaDependencyView_Data) Obj;
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.FormulaDependencyView_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.FormulaDependencyView_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }


   public static String getCSVHeader()
    {
      return "\"formulaRefnum\",\"location\",\"name\",\"referencedColumns\",\"dependencyRefnum\",\"dependentFormulaName\",\"dependentFormulaLocation\",\"dependentReferencedColumns\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.FormulaDependencyView_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.FormulaDependencyView_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.FormulaDependencyView_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__FORMULADEPENDENCYVIEW Obj = (tilda.data._Tilda.TILDA__FORMULADEPENDENCYVIEW) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getFormulaRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getLocation());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getReferencedColumns(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDependencyRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDependentFormulaName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDependentFormulaLocation());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDependentReferencedColumns(), ","));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.FormulaDependencyView_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data.FormulaDependencyView_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data.FormulaDependencyView_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.FormulaDependencyView_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.FormulaDependencyView_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__FORMULADEPENDENCYVIEW Obj = (tilda.data._Tilda.TILDA__FORMULADEPENDENCYVIEW) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "formulaRefnum", ++i==0, Obj.getFormulaRefnum());

        JSONUtil.print(out, "location", ++i==0, Obj.getLocation());

        JSONUtil.print(out, "name", ++i==0, Obj.getName());

      if (Obj.isReferencedColumnsNull() == false && Obj.getReferencedColumns() != null)
        JSONUtil.print(out, "referencedColumns", ++i==0, Obj.getReferencedColumnsAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "referencedColumns", ++i==0);
          out.write("[]");
        }

        JSONUtil.print(out, "dependencyRefnum", ++i==0, Obj.getDependencyRefnum());

        JSONUtil.print(out, "dependentFormulaName", ++i==0, Obj.getDependentFormulaName());

        JSONUtil.print(out, "dependentFormulaLocation", ++i==0, Obj.getDependentFormulaLocation());

      if (Obj.isDependentReferencedColumnsNull() == false && Obj.getDependentReferencedColumns() != null)
        JSONUtil.print(out, "dependentReferencedColumns", ++i==0, Obj.getDependentReferencedColumnsAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dependentReferencedColumns", ++i==0);
          out.write("[]");
        }

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
