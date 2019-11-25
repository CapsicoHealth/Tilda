
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
public class TILDA__JOBPART_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__JOBPART_Factory.class.getName());

   protected TILDA__JOBPART_Factory() { }

   public static final Class<TILDA__JOBPART> DATA_CLASS= TILDA__JOBPART.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("JobPart", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.JobPart", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "JobPart"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.refnum -> TILDA.JobPart."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          REFNUM      = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"      , 0/*0*/, "The primary key for this record");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.jobRefnum -> TILDA.JobPart."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.jobRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.jobRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Parent Job Refnum</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          JOBREFNUM   = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "jobRefnum"   , 1/*1*/, "Parent Job Refnum");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.name -> TILDA.JobPart."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.name of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part name</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        NAME        = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "name"        , 2/*2*/, "Job part name");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.type -> TILDA.JobPart."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.type of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    TYPE        = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "type"        , 3/*3*/, "Job part type");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStartTZ -> TILDA.JobPart."dataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStartTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStartTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataStart'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DATASTARTTZ = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "dataStartTZ" , 4/*4*/, "Generated helper column to hold the time zone ID for 'dataStart'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStart -> TILDA.JobPart."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStart of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStart of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DATASTART   = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dataStart"   , 5/*5*/, "Job part data start", DATASTARTTZ);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEndTZ -> TILDA.JobPart."dataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEndTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEndTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataEnd'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DATAENDTZ   = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "dataEndTZ"   , 6/*6*/, "Generated helper column to hold the time zone ID for 'dataEnd'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEnd -> TILDA.JobPart."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEnd of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEnd of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DATAEND     = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dataEnd"     , 7/*7*/, "Job part data end", DATAENDTZ);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.startTZ -> TILDA.JobPart."startTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.startTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.startTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'start'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        STARTTZ     = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "startTZ"     , 8/*8*/, "Generated helper column to hold the time zone ID for 'start'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.start -> TILDA.JobPart."start"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.start of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.start of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitive      START       = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "start"       , 9/*9*/, "Job part execution start", STARTTZ);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.endTZ -> TILDA.JobPart."endTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.endTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.endTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'end'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    ENDTZ       = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "endTZ"       , 10/*10*/, "Generated helper column to hold the time zone ID for 'end'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.end -> TILDA.JobPart."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.end of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.end of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  END         = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "end"         , 11/*11*/, "Job part execution end", ENDTZ);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.recordsCount -> TILDA.JobPart."recordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.recordsCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.recordsCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   RECORDSCOUNT= new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "recordsCount", 12/*12*/, "count of database or file or ... records.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.status -> TILDA.JobPart."status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.status of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.status of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_BooleanPrimitiveNull   STATUS      = new Type_BooleanPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "status"      , 13/*13*/, "Status flag, i.e., success=true and failure-false");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.created -> TILDA.JobPart."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.JobPart)</TD></TR>
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
     public static Type_DatetimePrimitive      CREATED     = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"     , 14/*14*/, "The timestamp for when the record was created. (TILDA.JobPart)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.lastUpdated -> TILDA.JobPart."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.JobPart)</TD></TR>
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
     public static Type_DatetimePrimitive      LASTUPDATED = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated" , 15/*15*/, "The timestamp for when the record was last updated. (TILDA.JobPart)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.deleted -> TILDA.JobPart."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JobPart.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DELETED     = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"     , 16/*16*/, "The timestamp for when the record was deleted. (TILDA.JobPart)");
;
   }

   public static final ColumnDefinition[] COLUMNS = { COLS.REFNUM,COLS.JOBREFNUM,COLS.NAME,COLS.TYPE,COLS.DATASTARTTZ,COLS.DATASTART,COLS.DATAENDTZ,COLS.DATAEND,COLS.STARTTZ,COLS.START,COLS.ENDTZ,COLS.END,COLS.RECORDSCOUNT,COLS.STATUS,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = { COLS.REFNUM };

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
              tilda.data.JobPart_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.JobPart_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.JobPart_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.JobPart_Data> _OP;
       protected ArrayListResults<tilda.data.JobPart_Data> _L = null;
       public void    start  () { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.JobPart_Data Obj = new tilda.data.JobPart_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__JOBPART)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.JobPart_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__JOBPART Obj, Object ExtraParams, int start, int size) throws Exception
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
          S.append(" "); C.getFullColumnVar(S, "TILDA", "JobPart", "refnum");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "jobRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "name");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "type");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "dataStartTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "dataStart");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "dataEndTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "dataEnd");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "startTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "start");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "endTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "end");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "recordsCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "status");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "created");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "JobPart", "deleted");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "JobPart");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1:
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JobPart", "jobRefnum"); S.append("=?)");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "JobPart", "start"); S.append(" DESC");
                break;
             case 2:
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JobPart", "name"); S.append("=?)");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "JobPart", "start"); S.append(" DESC");
                break;
             case 3:
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JobPart", "type"); S.append("=?)");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "JobPart", "start"); S.append(" DESC");
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
       QueryDetails.logQuery("TILDA.JobPart", Q, null);
       java.sql.PreparedStatement PS=null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
          switch (LookupId)
           {
             case -77:
             case -7:
                break;
             case 1: {
               PS.setLong      (++i, Obj._jobRefnum   );
               break;
             }
             case 2: {
               PS.setString    (++i, Obj._name        );
               break;
             }
             case 3: {
               if (Obj.isTypeNull() == true) PS.setNull(++i, java.sql.Types.CHAR      );  else PS.setString    (++i, Obj._type        );
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
          tilda.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param jobRefnum    Parent Job Refnum
 @param name         (max size 250) Job part name
 @param start        Job part execution start
*/
   static public tilda.data.JobPart_Data create(long jobRefnum, String name, ZonedDateTime start) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPART Obj = new tilda.data.JobPart_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDA.JOBPART"));

       // Explicit setters
       Obj.setJobRefnum   (jobRefnum   );
       Obj.setName        (name        );
       Obj.setStart       (start       );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.JobPart_Data) Obj;
     }

   static public tilda.data.JobPart_Data create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       Long        _refnum       =                       ParseUtil.parseLong("refnum"      , true , Values.get("refnum"      ), Errors );
       Long        _jobRefnum    =                       ParseUtil.parseLong("jobRefnum"   , true , Values.get("jobRefnum"   ), Errors );
       String        _name         =                       ParseUtil.parseString("name"        , true , Values.get("name"        ), Errors );
       String        _type         =                       ParseUtil.parseString("type"        , false, Values.get("type"        ), Errors );
       ZonedDateTime        _dataStart    =                       ParseUtil.parseZonedDateTime("dataStart"   , false, Values.get("dataStart"   ), Errors );
       ZonedDateTime        _dataEnd      =                       ParseUtil.parseZonedDateTime("dataEnd"     , false, Values.get("dataEnd"     ), Errors );
       ZonedDateTime        _start        =                       ParseUtil.parseZonedDateTime("start"       , true , Values.get("start"       ), Errors );
       ZonedDateTime        _end          =                       ParseUtil.parseZonedDateTime("end"         , false, Values.get("end"         ), Errors );
       Integer        _recordsCount =                       ParseUtil.parseInteger("recordsCount", false, Values.get("recordsCount"), Errors );
       Boolean        _status       =                       ParseUtil.parseBoolean("status"      , false, Values.get("status"      ), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.JobPart_Data Obj = tilda.data.JobPart_Factory.create(_jobRefnum, _name, _start);

      if (_refnum      != null) Obj.setRefnum      (_refnum      );
      if (_type        != null) Obj.setType        (_type        );
      if (_dataStart   != null) Obj.setDataStart   (_dataStart   );
      if (_dataEnd     != null) Obj.setDataEnd     (_dataEnd     );
      if (_end         != null) Obj.setEnd         (_end         );
      if (_recordsCount!= null) Obj.setRecordsCount(_recordsCount);
      if (_status      != null) Obj.setStatus      (_status      );

      return Obj;
     }
   public static int writeBatch(Connection C, List<tilda.data.JobPart_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__JOBPART lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__JOBPART) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__JOBPART) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.JobPart_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__JOBPART) d);

               if (((TILDA__JOBPART) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.JobPart_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (((TILDA__JOBPART) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.JobPart_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__JOBPART) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.JobPart_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__JOBPART) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.JobPart_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.JobPart_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'JobPart_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__1_0.handleFinally(PS, T0, TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

   static public tilda.data.JobPart_Data lookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPART Obj = new tilda.data.JobPart_Data();
       Obj.initForLookup(0);

       Obj.setRefnum      (refnum      ); Obj.__Saved_refnum       = Obj._refnum      ;

       return (tilda.data.JobPart_Data) Obj;
     }


   static public ListResults<tilda.data.JobPart_Data> lookupWhereJob(Connection C, long jobRefnum, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPART Obj = new tilda.data.JobPart_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setJobRefnum   (jobRefnum   );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }

   static public void lookupWhereJob(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.JobPart_Data> OP, long jobRefnum, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPART Obj = new tilda.data.JobPart_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setJobRefnum   (jobRefnum   );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }



   static public ListResults<tilda.data.JobPart_Data> lookupWhereJobPartName(Connection C, String name, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPART Obj = new tilda.data.JobPart_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setName        (name        );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 2, RPI, Obj, null, start, size);
       return RPI._L;
     }

   static public void lookupWhereJobPartName(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.JobPart_Data> OP, String name, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPART Obj = new tilda.data.JobPart_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setName        (name        );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, start, size);
     }



   static public ListResults<tilda.data.JobPart_Data> lookupWhereJobPartType(Connection C, String type, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPART Obj = new tilda.data.JobPart_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setType        (type        );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 3, RPI, Obj, null, start, size);
       return RPI._L;
     }

   static public void lookupWhereJobPartType(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.JobPart_Data> OP, String type, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBPART Obj = new tilda.data.JobPart_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setType        (type        );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 3, RPI, Obj, null, start, size);
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.JobPart_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.JobPart_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


 }
