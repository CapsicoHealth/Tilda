
package tilda.data._Tilda;

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
public class TILDA__REFILLPERF_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__REFILLPERF_Factory.class.getName());

   protected TILDA__REFILLPERF_Factory() { }

   public static final Class<TILDA__REFILLPERF> DATA_CLASS= TILDA__REFILLPERF.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("RefillPerf", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.RefillPerf", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "RefillPerf"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.schemaName -> TILDA.RefillPerf."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema tracked</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.schemaName of type varchar(64)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.schemaName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              SCHEMANAME    = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "schemaName"    , 0/*0*/, 64, "The name of the schema tracked", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.objectName -> TILDA.RefillPerf."objectName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>objectName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the table/object tracked</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.objectName of type varchar(64)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.objectName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              OBJECTNAME    = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "objectName"    , 1/*1*/, 64, "The name of the table/object tracked", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.startDateIncr -> TILDA.RefillPerf."startDateIncr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startDateIncr of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date passed in for incremental refills.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.startDateIncr of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.startDateIncr</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatePrimitiveNull            STARTDATEINCR = new Type_DatePrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "startDateIncr" , 2/*2*/, "The date passed in for incremental refills.", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.startTimeTZ -> TILDA.RefillPerf."startTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startTimeTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startTime'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.startTimeTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.startTimeTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              STARTTIMETZ   = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "startTimeTZ"   , 3/*3*/, 5, "Generated helper column to hold the time zone ID for 'startTime'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.startTime -> TILDA.RefillPerf."startTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startTime of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the refill started.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.startTime of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.startTime</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'startTimeTZ'</LI>
</TD></TR>

</TABLE>
*/
     public final Type_DatetimePrimitive            STARTTIME     = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "startTime"     , 4/*4*/, "The timestamp for when the refill started.", null, null, STARTTIMETZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.endTimeTZ -> TILDA.RefillPerf."endTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endTimeTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endTime'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.endTimeTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.endTimeTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              ENDTIMETZ     = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "endTimeTZ"     , 5/*5*/, 5, "Generated helper column to hold the time zone ID for 'endTime'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.endTime -> TILDA.RefillPerf."endTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endTime of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the refill ended.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.endTime of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.endTime</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endTimeTZ'</LI>
</TD></TR>

</TABLE>
*/
     public final Type_DatetimePrimitive            ENDTIME       = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "endTime"       , 6/*6*/, "The timestamp for when the refill ended.", null, null, ENDTIMETZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.timeInsertSec -> TILDA.RefillPerf."timeInsertSec"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeInsertSec of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The time, in seconds, the inserts took.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.timeInsertSec of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.timeInsertSec</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                TIMEINSERTSEC = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "timeInsertSec" , 7/*7*/, "The time, in seconds, the inserts took.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.timeDeleteSec -> TILDA.RefillPerf."timeDeleteSec"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeDeleteSec of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The time, in seconds, the deletes took.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.timeDeleteSec of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.timeDeleteSec</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                TIMEDELETESEC = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "timeDeleteSec" , 8/*8*/, "The time, in seconds, the deletes took.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.timeAnalyzeSec -> TILDA.RefillPerf."timeAnalyzeSec"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeAnalyzeSec of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The time, in seconds, the analyze took.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.timeAnalyzeSec of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.timeAnalyzeSec</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                TIMEANALYZESEC= new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "timeAnalyzeSec", 9/*9*/, "The time, in seconds, the analyze took.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.timeTotalSec -> TILDA.RefillPerf."timeTotalSec"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>timeTotalSec of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The time, in seconds, the analyze took.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.timeTotalSec of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.timeTotalSec</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>timeTotalSec_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>timeTotalSec_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>timeTotalSec_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                TIMETOTALSEC  = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "timeTotalSec"  , 10/*10*/, "The time, in seconds, the analyze took.", null, null, new String[][] {{"0","timeTotalSec_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.insertCount -> TILDA.RefillPerf."insertCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertCount of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The count of inserted rows.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.insertCount of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.insertCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                INSERTCOUNT   = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "insertCount"   , 11/*11*/, "The count of inserted rows.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.deleteCount -> TILDA.RefillPerf."deleteCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteCount of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The count of rows deleted.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.deleteCount of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.deleteCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                DELETECOUNT   = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "deleteCount"   , 12/*12*/, "The count of rows deleted.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.created -> TILDA.RefillPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.RefillPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.created</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
     public final Type_DatetimePrimitive            CREATED       = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "created"       , 13/*13*/, "The timestamp for when the record was created. (TILDA.RefillPerf)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.lastUpdated -> TILDA.RefillPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.RefillPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.lastUpdated</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
     public final Type_DatetimePrimitive            LASTUPDATED   = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"   , 14/*14*/, "The timestamp for when the record was last updated. (TILDA.RefillPerf)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.RefillPerf.deleted -> TILDA.RefillPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.RefillPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.RefillPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.RefillPerf.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull        DELETED       = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"       , 15/*15*/, "The timestamp for when the record was deleted. (TILDA.RefillPerf)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.SCHEMANAME,COLS.OBJECTNAME,COLS.STARTDATEINCR,COLS.STARTTIMETZ,COLS.STARTTIME,COLS.ENDTIMETZ,COLS.ENDTIME,COLS.TIMEINSERTSEC,COLS.TIMEDELETESEC,COLS.TIMEANALYZESEC,COLS.TIMETOTALSEC,COLS.INSERTCOUNT,COLS.DELETECOUNT,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.SCHEMANAME,COLS.OBJECTNAME,COLS.STARTTIME };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = new ColumnDefinition[][]{ 
        };

   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = COLUMNS_PRIMARY;

   // Short(short) is deprecated, but we do want a new instance here to avoid synchronizing over the same cached instance from valueOf.
   // @SuppressWarnings("deprecation")
   private static final AtomicBoolean __INITIALIZED = new AtomicBoolean(false);
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED.compareAndSet(false, true))
        {
           tilda.data.RefillPerf_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.RefillPerf_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.RefillPerf_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.RefillPerf_Data> _OP;
       protected ArrayListResults<tilda.data.RefillPerf_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.RefillPerf_Data Obj = new tilda.data.RefillPerf_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__REFILLPERF)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.RefillPerf_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__REFILLPERF Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__REFILLPERF_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "RefillPerf");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Index 'SchemaByObjectStart'
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "RefillPerf", "schemaName"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "RefillPerf", "objectName"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "RefillPerf", "startTime"); S.append(" DESC");
                break;
             case 2: // Index 'SchemaObjectByStart'
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "RefillPerf", "schemaName"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "RefillPerf", "objectName"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "RefillPerf", "startTime"); S.append(" DESC");
                break;
             case 3: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "RefillPerf", "schemaName"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "RefillPerf", "objectName"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "RefillPerf", "startTime"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDA.RefillPerf", Q, null);
       java.sql.PreparedStatement PS=null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          if (size < 0 || size > 5000)
           PS.setFetchSize(5000);
          int i = 0;
          switch (LookupId)
           {
             case -77:
             case -7:
                break;
             case 1: {  // Index 'SchemaByObjectStart'
               PS.setString    (++i, Obj._schemaName    );
               break;
             }
             case 2: {  // Index 'SchemaObjectByStart'
               PS.setString    (++i, Obj._schemaName    );
               PS.setString    (++i, Obj._objectName    );
               break;
             }
             case 3: { // Query 'All'
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__REFILLPERF_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.data.RefillPerf_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data._Tilda.TILDA__REFILLPERF Obj = new tilda.data.RefillPerf_Data();
       String[] vals = null;

       vals = Values.get("schemaName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("schemaName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _schemaName = ParseUtil.parseString("schemaName", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_schemaName != null) Obj.setSchemaName(_schemaName);

       vals = Values.get("objectName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("objectName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _objectName = ParseUtil.parseString("objectName", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_objectName != null) Obj.setObjectName(_objectName);

       vals = Values.get("startDateIncr");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("startDateIncr", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       LocalDate _startDateIncr = ParseUtil.parseLocalDate("startDateIncr", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_startDateIncr != null) Obj.setStartDateIncr(_startDateIncr);

       vals = Values.get("startTime");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("startTime", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _startTime = ParseUtil.parseZonedDateTime("startTime", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_startTime != null) Obj.setStartTime(_startTime);

       vals = Values.get("endTime");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("endTime", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _endTime = ParseUtil.parseZonedDateTime("endTime", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_endTime != null) Obj.setEndTime(_endTime);

       vals = Values.get("timeInsertSec");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("timeInsertSec", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _timeInsertSec = ParseUtil.parseLong("timeInsertSec", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_timeInsertSec != null) Obj.setTimeInsertSec(_timeInsertSec);

       vals = Values.get("timeDeleteSec");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("timeDeleteSec", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _timeDeleteSec = ParseUtil.parseLong("timeDeleteSec", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_timeDeleteSec != null) Obj.setTimeDeleteSec(_timeDeleteSec);

       vals = Values.get("timeAnalyzeSec");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("timeAnalyzeSec", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _timeAnalyzeSec = ParseUtil.parseLong("timeAnalyzeSec", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_timeAnalyzeSec != null) Obj.setTimeAnalyzeSec(_timeAnalyzeSec);

       vals = Values.get("timeTotalSec");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("timeTotalSec", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _timeTotalSec = ParseUtil.parseLong("timeTotalSec", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_timeTotalSec != null) Obj.setTimeTotalSec(_timeTotalSec);

       vals = Values.get("insertCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("insertCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _insertCount = ParseUtil.parseLong("insertCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_insertCount != null) Obj.setInsertCount(_insertCount);

       vals = Values.get("deleteCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("deleteCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _deleteCount = ParseUtil.parseLong("deleteCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_deleteCount != null) Obj.setDeleteCount(_deleteCount);


       return (tilda.data.RefillPerf_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param schemaName     (max size 64) The name of the schema tracked
 @param objectName     (max size 64) The name of the table/object tracked
 @param startDateIncr  The date passed in for incremental refills.
 @param startTime      The timestamp for when the refill started.
 @param endTime        The timestamp for when the refill ended.
 @param timeInsertSec  The time, in seconds, the inserts took.
 @param timeDeleteSec  The time, in seconds, the deletes took.
 @param timeAnalyzeSec The time, in seconds, the analyze took.
 @param insertCount    The count of inserted rows.
 @param deleteCount    The count of rows deleted.
*/
   static public tilda.data.RefillPerf_Data create(String schemaName, String objectName, LocalDate startDateIncr, ZonedDateTime startTime, ZonedDateTime endTime, long timeInsertSec, long timeDeleteSec, long timeAnalyzeSec, long insertCount, long deleteCount) throws Exception
     {
       tilda.data._Tilda.TILDA__REFILLPERF Obj = new tilda.data.RefillPerf_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setSchemaName    (schemaName    );
       Obj.setObjectName    (objectName    );
       Obj.setStartDateIncr (startDateIncr );
       Obj.setStartTime     (startTime     );
       Obj.setEndTime       (endTime       );
       Obj.setTimeInsertSec (timeInsertSec );
       Obj.setTimeDeleteSec (timeDeleteSec );
       Obj.setTimeAnalyzeSec(timeAnalyzeSec);
       Obj.setInsertCount   (insertCount   );
       Obj.setDeleteCount   (deleteCount   );

       // Default Create-time setters
       Obj.setTimeTotalSecTimeTotalSec_CreateDefault();
       Obj.setCreatedNow                            ();
       Obj.setLastUpdatedNow                        ();

       return (tilda.data.RefillPerf_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data.RefillPerf_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__REFILLPERF lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__REFILLPERF) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__REFILLPERF) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.RefillPerf_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__REFILLPERF) d);

               if (((TILDA__REFILLPERF) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.RefillPerf_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__REFILLPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__REFILLPERF) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.RefillPerf_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__REFILLPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__REFILLPERF) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.RefillPerf_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__REFILLPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__REFILLPERF) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.RefillPerf_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__REFILLPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.RefillPerf_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'RefillPerf_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__2_5.handleFinally(PS, T0, TILDA__REFILLPERF_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: schemaName, objectName, startTime.
*/
   static public tilda.data.RefillPerf_Data lookupByPrimaryKey(String schemaName, String objectName, ZonedDateTime startTime) throws Exception
     {
       tilda.data._Tilda.TILDA__REFILLPERF Obj = new tilda.data.RefillPerf_Data();
       Obj.initForLookup(0);

       Obj.setSchemaName    (schemaName    ); Obj.__Saved_schemaName     = Obj._schemaName    ;
       Obj.setObjectName    (objectName    ); Obj.__Saved_objectName     = Obj._objectName    ;
       Obj.setStartTime     (startTime     ); Obj.__Saved_startTime      = Obj._startTime     ;

       return (tilda.data.RefillPerf_Data) Obj;
     }

/**
Lookup records by the index 'SchemaByObjectStart' over  schemaName.<BR>The results are ordered by: objectName asc, startTime desc
*/
   static public ListResults<tilda.data.RefillPerf_Data> lookupWhereSchemaByObjectStart(Connection C, String schemaName, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__REFILLPERF Obj = new tilda.data.RefillPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName    (schemaName    );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, __start__);
       readMany(C, 1, RPI, Obj, null, __start__, __size__);
       return RPI._L;
     }

/**
Lookup records by the index 'SchemaByObjectStart' over  schemaName.<BR>The results are ordered by: objectName asc, startTime desc
*/
   static public void lookupWhereSchemaByObjectStart(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.RefillPerf_Data> OP, String schemaName, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__REFILLPERF Obj = new tilda.data.RefillPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName    (schemaName    );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, __start__, __size__);
     }



/**
Lookup records by the index 'SchemaObjectByStart' over  schemaName, objectName.<BR>The results are ordered by: startTime desc
*/
   static public ListResults<tilda.data.RefillPerf_Data> lookupWhereSchemaObjectByStart(Connection C, String schemaName, String objectName, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__REFILLPERF Obj = new tilda.data.RefillPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName    (schemaName    );
       Obj.setObjectName    (objectName    );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, __start__);
       readMany(C, 2, RPI, Obj, null, __start__, __size__);
       return RPI._L;
     }

/**
Lookup records by the index 'SchemaObjectByStart' over  schemaName, objectName.<BR>The results are ordered by: startTime desc
*/
   static public void lookupWhereSchemaObjectByStart(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.RefillPerf_Data> OP, String schemaName, String objectName, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__REFILLPERF Obj = new tilda.data.RefillPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName    (schemaName    );
       Obj.setObjectName    (objectName    );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, __start__, __size__);
     }



/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: schemaName asc, objectName asc, startTime asc
*/   static public ListResults<tilda.data.RefillPerf_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__REFILLPERF Obj = new tilda.data.RefillPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 3, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: schemaName asc, objectName asc, startTime asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.RefillPerf_Data> OP, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__REFILLPERF Obj = new tilda.data.RefillPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 3, RPI, Obj, null, start, size);
     }





   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.RefillPerf_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.RefillPerf_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


   public static String getCSVHeader()
    {
      return "\"schemaName\",\"objectName\",\"startDateIncr\",\"startTimeTZ\",\"startTime\",\"endTimeTZ\",\"endTime\",\"timeInsertSec\",\"timeDeleteSec\",\"timeAnalyzeSec\",\"timeTotalSec\",\"insertCount\",\"deleteCount\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.RefillPerf_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.RefillPerf_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.RefillPerf_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__REFILLPERF Obj = (tilda.data._Tilda.TILDA__REFILLPERF) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getSchemaName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getObjectName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDate(Obj.getStartDateIncr()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getStartTimeTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getStartTime()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getEndTimeTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getEndTime()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeInsertSec());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeDeleteSec());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeAnalyzeSec());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTimeTotalSec());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getInsertCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDeleteCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.RefillPerf_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data.RefillPerf_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data.RefillPerf_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.RefillPerf_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.RefillPerf_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__REFILLPERF Obj = (tilda.data._Tilda.TILDA__REFILLPERF) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "schemaName", ++i==0, Obj.getSchemaName());

        JSONUtil.print(out, "objectName", ++i==0, Obj.getObjectName());

      if (Obj.isNullStartDateIncr() == false && Obj.getStartDateIncr() != null)
        JSONUtil.print(out, "startDateIncr", ++i==0, Obj.getStartDateIncr());

        JSONUtil.print(out, "startTimeTZ", ++i==0, Obj.getStartTimeTZ());

        JSONUtil.print(out, "startTime", ++i==0, Obj.getStartTime());

        JSONUtil.print(out, "endTimeTZ", ++i==0, Obj.getEndTimeTZ());

        JSONUtil.print(out, "endTime", ++i==0, Obj.getEndTime());

        JSONUtil.print(out, "timeInsertSec", ++i==0, Obj.getTimeInsertSec());

        JSONUtil.print(out, "timeDeleteSec", ++i==0, Obj.getTimeDeleteSec());

        JSONUtil.print(out, "timeAnalyzeSec", ++i==0, Obj.getTimeAnalyzeSec());

        JSONUtil.print(out, "timeTotalSec", ++i==0, Obj.getTimeTotalSec());

        JSONUtil.print(out, "insertCount", ++i==0, Obj.getInsertCount());

        JSONUtil.print(out, "deleteCount", ++i==0, Obj.getDeleteCount());

        JSONUtil.print(out, "created", ++i==0, Obj.getCreated());

        JSONUtil.print(out, "lastUpdated", ++i==0, Obj.getLastUpdated());

      if (Obj.isNullDeleted() == false && Obj.getDeleted() != null)
        JSONUtil.print(out, "deleted", ++i==0, Obj.getDeleted());

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
