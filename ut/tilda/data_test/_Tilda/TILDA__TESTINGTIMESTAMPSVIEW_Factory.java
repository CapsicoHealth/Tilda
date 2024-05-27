
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
public class TILDA__TESTINGTIMESTAMPSVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTINGTIMESTAMPSVIEW_Factory.class.getName());

   protected TILDA__TESTINGTIMESTAMPSVIEW_Factory() { }

   public static final Class<TILDA__TESTINGTIMESTAMPSVIEW> DATA_CLASS= TILDA__TESTINGTIMESTAMPSVIEW.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATEST", "");
   public static final String TABLENAME_LABEL = TextUtil.print("TestingTimestampsView", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATEST.TestingTimestampsView", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATEST", "TestingTimestampsView"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.id -> TILDATEST.TestingTimestampsView."id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>id of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.id of type varchar(20)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.id</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>20</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              ID     = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "id"     , 0/*0*/, 20, "Medical system unique enterprise id", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max -> TILDATEST.TestingTimestampsView."dt1_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull        DT1_MAX= new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "dt1_max", 1/*1*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max -> TILDATEST.TestingTimestampsView."dt2_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull        DT2_MAX= new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "dt2_max", 2/*2*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max -> TILDATEST.TestingTimestampsView."dt3_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_Datetime_plainPrimitiveNull  DT3_MAX= new Type_Datetime_plainPrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dt3_max", 3/*3*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max -> TILDATEST.TestingTimestampsView."dt4_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_Datetime_plainPrimitiveNull  DT4_MAX= new Type_Datetime_plainPrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dt4_max", 4/*4*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt -> TILDATEST.TestingTimestampsView."dt1_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull            DT1_CNT= new Type_LongPrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "dt1_cnt", 5/*5*/, "The blah", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt -> TILDATEST.TestingTimestampsView."dt2_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull            DT2_CNT= new Type_LongPrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "dt2_cnt", 6/*6*/, "The blah", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt -> TILDATEST.TestingTimestampsView."dt3_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull            DT3_CNT= new Type_LongPrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "dt3_cnt", 7/*7*/, "The blah", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt -> TILDATEST.TestingTimestampsView."dt4_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull            DT4_CNT= new Type_LongPrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "dt4_cnt", 8/*8*/, "The blah", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr -> TILDATEST.TestingTimestampsView."dt1_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringCollectionNull         DT1_ARR= new Type_StringCollectionNull        (SCHEMA_LABEL, TABLENAME_LABEL, "dt1_arr", 9/*9*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr -> TILDATEST.TestingTimestampsView."dt2_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringCollectionNull         DT2_ARR= new Type_StringCollectionNull        (SCHEMA_LABEL, TABLENAME_LABEL, "dt2_arr", 10/*10*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr -> TILDATEST.TestingTimestampsView."dt3_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringCollectionNull         DT3_ARR= new Type_StringCollectionNull        (SCHEMA_LABEL, TABLENAME_LABEL, "dt3_arr", 11/*11*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr -> TILDATEST.TestingTimestampsView."dt4_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringCollectionNull         DT4_ARR= new Type_StringCollectionNull        (SCHEMA_LABEL, TABLENAME_LABEL, "dt4_arr", 12/*12*/, "The blah", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.ID,COLS.DT1_MAX,COLS.DT2_MAX,COLS.DT3_MAX,COLS.DT4_MAX,COLS.DT1_CNT,COLS.DT2_CNT,COLS.DT3_CNT,COLS.DT4_CNT,COLS.DT1_ARR,COLS.DT2_ARR,COLS.DT3_ARR,COLS.DT4_ARR };

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
           tilda.data_test.TestingTimestampsView_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data_test.TestingTimestampsView_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.TestingTimestampsView_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data_test.TestingTimestampsView_Data> _OP;
       protected ArrayListResults<tilda.data_test.TestingTimestampsView_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data_test.TestingTimestampsView_Data Obj = new tilda.data_test.TestingTimestampsView_Data();
          boolean OK = ((tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data_test.TestingTimestampsView_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "TestingTimestampsView");
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
       QueryDetails.logQuery("TILDATEST.TestingTimestampsView", Q, null);
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
          tilda.data_test._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__TESTINGTIMESTAMPSVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
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
   static public tilda.data_test.TestingTimestampsView_Data lookupByAll() throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW Obj = new tilda.data_test.TestingTimestampsView_Data();
       Obj.initForLookup(0);


       return (tilda.data_test.TestingTimestampsView_Data) Obj;
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data_test.TestingTimestampsView_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data_test.TestingTimestampsView_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
     }


   public static String getCSVHeader()
    {
      return "\"id\",\"dt1_max\",\"dt2_max\",\"dt3_max\",\"dt4_max\",\"dt1_cnt\",\"dt2_cnt\",\"dt3_cnt\",\"dt4_cnt\",\"dt1_arr\",\"dt2_arr\",\"dt3_arr\",\"dt4_arr\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data_test.TestingTimestampsView_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data_test.TestingTimestampsView_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data_test.TestingTimestampsView_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW Obj = (tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getId());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt1_max()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt2_max()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt3_max()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt4_max()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDt1_cnt());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDt2_cnt());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDt3_cnt());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDt4_cnt());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDt1_arr(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDt2_arr(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDt3_arr(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDt4_arr(), ","));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data_test.TestingTimestampsView_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data_test.TestingTimestampsView_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data_test.TestingTimestampsView_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data_test.TestingTimestampsView_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data_test.TestingTimestampsView_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW Obj = (tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "id", ++i==0, Obj.getId());

      if (Obj.isNullDt1_max() == false && Obj.getDt1_max() != null)
        JSONUtil.print(out, "dt1_max", ++i==0, Obj.getDt1_max());

      if (Obj.isNullDt2_max() == false && Obj.getDt2_max() != null)
        JSONUtil.print(out, "dt2_max", ++i==0, Obj.getDt2_max());

      if (Obj.isNullDt3_max() == false && Obj.getDt3_max() != null)
        JSONUtil.print(out, "dt3_max", ++i==0, Obj.getDt3_max());

      if (Obj.isNullDt4_max() == false && Obj.getDt4_max() != null)
        JSONUtil.print(out, "dt4_max", ++i==0, Obj.getDt4_max());

      if (Obj.isNullDt1_cnt() == false)
        JSONUtil.print(out, "dt1_cnt", ++i==0, Obj.getDt1_cnt());

      if (Obj.isNullDt2_cnt() == false)
        JSONUtil.print(out, "dt2_cnt", ++i==0, Obj.getDt2_cnt());

      if (Obj.isNullDt3_cnt() == false)
        JSONUtil.print(out, "dt3_cnt", ++i==0, Obj.getDt3_cnt());

      if (Obj.isNullDt4_cnt() == false)
        JSONUtil.print(out, "dt4_cnt", ++i==0, Obj.getDt4_cnt());

      if (Obj.isNullDt1_arr() == false && Obj.getDt1_arr() != null)
        JSONUtil.print(out, "dt1_arr", ++i==0, Obj.getDt1_arrAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt1_arr", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt2_arr() == false && Obj.getDt2_arr() != null)
        JSONUtil.print(out, "dt2_arr", ++i==0, Obj.getDt2_arrAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt2_arr", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt3_arr() == false && Obj.getDt3_arr() != null)
        JSONUtil.print(out, "dt3_arr", ++i==0, Obj.getDt3_arrAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt3_arr", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt4_arr() == false && Obj.getDt4_arr() != null)
        JSONUtil.print(out, "dt4_arr", ++i==0, Obj.getDt4_arrAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt4_arr", ++i==0);
          out.write("[]");
        }

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
