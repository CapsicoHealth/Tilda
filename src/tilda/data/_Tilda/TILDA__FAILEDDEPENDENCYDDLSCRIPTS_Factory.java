
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
public class TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory.class.getName());

   protected TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory() { }

   public static final Class<TILDA__FAILEDDEPENDENCYDDLSCRIPTS> DATA_CLASS= TILDA__FAILEDDEPENDENCYDDLSCRIPTS.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("FailedDependencyDDLScripts", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.FailedDependencyDDLScripts", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "FailedDependencyDDLScripts"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FailedDependencyDDLScripts.srcSchemaName -> TILDA.FailedDependencyDDLScripts."srcSchemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FailedDependencyDDLScripts.srcSchemaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FailedDependencyDDLScripts.srcSchemaName of type varchar(100)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        SRCSCHEMANAME= new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "srcSchemaName", 0/*0*/, "The result value.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FailedDependencyDDLScripts.srcTVName -> TILDA.FailedDependencyDDLScripts."srcTVName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FailedDependencyDDLScripts.srcTVName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FailedDependencyDDLScripts.srcTVName of type varchar(100)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        SRCTVNAME    = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "srcTVName"    , 1/*1*/, "The result value.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FailedDependencyDDLScripts.seq -> TILDA.FailedDependencyDDLScripts."seq"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FailedDependencyDDLScripts.seq of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FailedDependencyDDLScripts.seq of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitive       SEQ          = new Type_IntegerPrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "seq"          , 2/*2*/, "The blah", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FailedDependencyDDLScripts.depSchemaName -> TILDA.FailedDependencyDDLScripts."depSchemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FailedDependencyDDLScripts.depSchemaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FailedDependencyDDLScripts.depSchemaName of type varchar(100)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        DEPSCHEMANAME= new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "depSchemaName", 3/*3*/, "The result value.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FailedDependencyDDLScripts.depViewName -> TILDA.FailedDependencyDDLScripts."depViewName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FailedDependencyDDLScripts.depViewName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FailedDependencyDDLScripts.depViewName of type varchar(100)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        DEPVIEWNAME  = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "depViewName"  , 4/*4*/, "The result value.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FailedDependencyDDLScripts.restoreScript -> TILDA.FailedDependencyDDLScripts."restoreScript"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FailedDependencyDDLScripts.restoreScript of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FailedDependencyDDLScripts.restoreScript of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>500000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        RESTORESCRIPT= new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "restoreScript", 5/*5*/, "The result value.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FailedDependencyDDLScripts.created -> TILDA.FailedDependencyDDLScripts."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FailedDependencyDDLScripts.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FailedDependencyDDLScripts.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.FailedDependencyDDLScripts)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>Creation</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>Creation&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Creation time</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_DatetimePrimitive      CREATED      = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"      , 6/*6*/, "The timestamp for when the record was created. (TILDA.FailedDependencyDDLScripts)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FailedDependencyDDLScripts.lastUpdated -> TILDA.FailedDependencyDDLScripts."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FailedDependencyDDLScripts.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FailedDependencyDDLScripts.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.FailedDependencyDDLScripts)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>Update</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>Update&nbsp;&nbsp;</TD><TD>ALWAYS&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Last updated time</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_DatetimePrimitive      LASTUPDATED  = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"  , 7/*7*/, "The timestamp for when the record was last updated. (TILDA.FailedDependencyDDLScripts)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FailedDependencyDDLScripts.deleted -> TILDA.FailedDependencyDDLScripts."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FailedDependencyDDLScripts.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FailedDependencyDDLScripts.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.FailedDependencyDDLScripts)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  DELETED      = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"      , 8/*8*/, "The timestamp for when the record was deleted. (TILDA.FailedDependencyDDLScripts)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.SRCSCHEMANAME,COLS.SRCTVNAME,COLS.SEQ,COLS.DEPSCHEMANAME,COLS.DEPVIEWNAME,COLS.RESTORESCRIPT,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] {  };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = new ColumnDefinition[][]{ 
                   {COLS.SRCSCHEMANAME,COLS.SRCTVNAME,COLS.CREATED,COLS.SEQ}
        };

   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = COLUMNS_UNIQUE_INDICES[0];

   private static Boolean  __INITIALIZED = false;
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED == false)
        synchronized(__INITIALIZED)
         {
           if (__INITIALIZED == false)
            {
              tilda.data.FailedDependencyDDLScripts_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.FailedDependencyDDLScripts_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.FailedDependencyDDLScripts_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.FailedDependencyDDLScripts_Data> _OP;
       protected ArrayListResults<tilda.data.FailedDependencyDDLScripts_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.FailedDependencyDDLScripts_Data Obj = new tilda.data.FailedDependencyDDLScripts_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.FailedDependencyDDLScripts_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "FailedDependencyDDLScripts");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "FailedDependencyDDLScripts", "srcSchemaName"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "FailedDependencyDDLScripts", "srcTVName"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "FailedDependencyDDLScripts", "created"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "FailedDependencyDDLScripts", "seq"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDA.FailedDependencyDDLScripts", Q, null);
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
          tilda.data._Tilda.TILDA__2_3.handleFinally(PS, T0, TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.data.FailedDependencyDDLScripts_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS Obj = new tilda.data.FailedDependencyDDLScripts_Data();
       String[] vals = null;

       vals = Values.get("srcSchemaName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("srcSchemaName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _srcSchemaName = ParseUtil.parseString("srcSchemaName", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_srcSchemaName != null) Obj.setSrcSchemaName(_srcSchemaName);

       vals = Values.get("srcTVName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("srcTVName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _srcTVName = ParseUtil.parseString("srcTVName", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_srcTVName != null) Obj.setSrcTVName(_srcTVName);

       vals = Values.get("seq");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("seq", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _seq = ParseUtil.parseInteger("seq", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_seq != null) Obj.setSeq(_seq);

       vals = Values.get("depSchemaName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("depSchemaName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _depSchemaName = ParseUtil.parseString("depSchemaName", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_depSchemaName != null) Obj.setDepSchemaName(_depSchemaName);

       vals = Values.get("depViewName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("depViewName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _depViewName = ParseUtil.parseString("depViewName", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_depViewName != null) Obj.setDepViewName(_depViewName);

       vals = Values.get("restoreScript");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("restoreScript", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _restoreScript = ParseUtil.parseString("restoreScript", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_restoreScript != null) Obj.setRestoreScript(_restoreScript);


       return (tilda.data.FailedDependencyDDLScripts_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param srcSchemaName (max size 100) The result value.
 @param srcTVName     (max size 100) The result value.
 @param seq           The blah
 @param depSchemaName (max size 100) The result value.
 @param depViewName   (max size 100) The result value.
 @param restoreScript (max size 500000) The result value.
*/
   static public tilda.data.FailedDependencyDDLScripts_Data create(String srcSchemaName, String srcTVName, int seq, String depSchemaName, String depViewName, String restoreScript) throws Exception
     {
       tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS Obj = new tilda.data.FailedDependencyDDLScripts_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setSrcSchemaName(srcSchemaName);
       Obj.setSrcTVName    (srcTVName    );
       Obj.setSeq          (seq          );
       Obj.setDepSchemaName(depSchemaName);
       Obj.setDepViewName  (depViewName  );
       Obj.setRestoreScript(restoreScript);

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.FailedDependencyDDLScripts_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data.FailedDependencyDDLScripts_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__FAILEDDEPENDENCYDDLSCRIPTS lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__FAILEDDEPENDENCYDDLSCRIPTS) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__FAILEDDEPENDENCYDDLSCRIPTS) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.FailedDependencyDDLScripts_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__FAILEDDEPENDENCYDDLSCRIPTS) d);

               if (((TILDA__FAILEDDEPENDENCYDDLSCRIPTS) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FailedDependencyDDLScripts_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__FAILEDDEPENDENCYDDLSCRIPTS) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FailedDependencyDDLScripts_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__FAILEDDEPENDENCYDDLSCRIPTS) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FailedDependencyDDLScripts_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__FAILEDDEPENDENCYDDLSCRIPTS) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FailedDependencyDDLScripts_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.FailedDependencyDDLScripts_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'FailedDependencyDDLScripts_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__2_3.handleFinally(PS, T0, TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the unique index 'DepedencySequence': srcSchemaName, srcTVName, created, seq.
*/
   static public tilda.data.FailedDependencyDDLScripts_Data lookupByDepedencySequence(String srcSchemaName, String srcTVName, ZonedDateTime created, int seq) throws Exception
     {
       tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS Obj = new tilda.data.FailedDependencyDDLScripts_Data();
       Obj.initForLookup(0);

       Obj.setSrcSchemaName(srcSchemaName); 
       Obj.setSrcTVName    (srcTVName    ); 
       Obj.setCreated      (created      ); 
       Obj.setSeq          (seq          ); 

       return (tilda.data.FailedDependencyDDLScripts_Data) Obj;
     }

/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: srcSchemaName asc, srcTVName asc, created asc, seq asc
*/   static public ListResults<tilda.data.FailedDependencyDDLScripts_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS Obj = new tilda.data.FailedDependencyDDLScripts_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: srcSchemaName asc, srcTVName asc, created asc, seq asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.FailedDependencyDDLScripts_Data> OP, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS Obj = new tilda.data.FailedDependencyDDLScripts_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.FailedDependencyDDLScripts_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.FailedDependencyDDLScripts_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


   public static String getCSVHeader()
    {
      return "\"srcSchemaName\",\"srcTVName\",\"seq\",\"depSchemaName\",\"depViewName\",\"restoreScript\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.FailedDependencyDDLScripts_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.FailedDependencyDDLScripts_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.FailedDependencyDDLScripts_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS Obj = (tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getSrcSchemaName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getSrcTVName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getSeq());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDepSchemaName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDepViewName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getRestoreScript());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.FailedDependencyDDLScripts_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data.FailedDependencyDDLScripts_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data.FailedDependencyDDLScripts_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.FailedDependencyDDLScripts_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.FailedDependencyDDLScripts_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS Obj = (tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "srcSchemaName", ++i==0, Obj.getSrcSchemaName());

        JSONUtil.print(out, "srcTVName", ++i==0, Obj.getSrcTVName());

        JSONUtil.print(out, "seq", ++i==0, Obj.getSeq());

        JSONUtil.print(out, "depSchemaName", ++i==0, Obj.getDepSchemaName());

        JSONUtil.print(out, "depViewName", ++i==0, Obj.getDepViewName());

        JSONUtil.print(out, "restoreScript", ++i==0, Obj.getRestoreScript());

        JSONUtil.print(out, "created", ++i==0, Obj.getCreated());

        JSONUtil.print(out, "lastUpdated", ++i==0, Obj.getLastUpdated());

      if (Obj.isDeletedNull() == false && Obj.getDeleted() != null)
        JSONUtil.print(out, "deleted", ++i==0, Obj.getDeleted());

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
