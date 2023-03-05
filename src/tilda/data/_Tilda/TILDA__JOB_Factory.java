
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
public class TILDA__JOB_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__JOB_Factory.class.getName());

   protected TILDA__JOB_Factory() { }

   public static final Class<TILDA__JOB> DATA_CLASS= TILDA__JOB.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Job", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.Job", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "Job"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.refnum -> TILDA.Job."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive          REFNUM     = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"     , 0/*0*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.name -> TILDA.Job."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>name of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.name of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.name</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        NAME       = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "name"       , 1/*1*/, 250, "Name", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.type -> TILDA.Job."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.type of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    TYPE       = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "type"       , 2/*2*/, 250, "Job type", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.userId -> TILDA.Job."userId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>userId of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job user Id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.userId of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.userId</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    USERID     = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "userId"     , 3/*3*/, 250, "Job user Id", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.dataStartTZ -> TILDA.Job."dataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.dataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.dataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    DATASTARTTZ= new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "dataStartTZ", 4/*4*/, 5, "Generated helper column to hold the time zone ID for 'dataStart'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.dataStart -> TILDA.Job."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.dataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.dataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  DATASTART  = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dataStart"  , 5/*5*/, "StartTime", null, null, DATASTARTTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.dataEndTZ -> TILDA.Job."dataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.dataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.dataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    DATAENDTZ  = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "dataEndTZ"  , 6/*6*/, 5, "Generated helper column to hold the time zone ID for 'dataEnd'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.dataEnd -> TILDA.Job."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.dataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.dataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  DATAEND    = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dataEnd"    , 7/*7*/, "StartTime", null, null, DATAENDTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.startTZ -> TILDA.Job."startTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'start'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.startTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.startTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        STARTTZ    = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "startTZ"    , 8/*8*/, 5, "Generated helper column to hold the time zone ID for 'start'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.start -> TILDA.Job."start"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>start of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.start of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.start</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitive      START      = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "start"      , 9/*9*/, "StartTime", null, null, STARTTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.endTZ -> TILDA.Job."endTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'end'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.endTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.endTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    ENDTZ      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "endTZ"      , 10/*10*/, 5, "Generated helper column to hold the time zone ID for 'end'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.end -> TILDA.Job."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>end of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>EndTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.end of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.end</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  END        = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "end"        , 11/*11*/, "EndTime", null, null, ENDTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.status -> TILDA.Job."status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>status of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.status of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.status</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_BooleanPrimitiveNull   STATUS     = new Type_BooleanPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "status"     , 12/*12*/, "Status", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.msg -> TILDA.Job."msg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>msg of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.msg of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.msg</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    MSG        = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "msg"        , 13/*13*/, 8192, "Message details", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.created -> TILDA.Job."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.Job)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.created</TD></TR>

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
     public final Type_DatetimePrimitive      CREATED    = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"    , 14/*14*/, "The timestamp for when the record was created. (TILDA.Job)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.lastUpdated -> TILDA.Job."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.Job)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.lastUpdated</TD></TR>

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
     public final Type_DatetimePrimitive      LASTUPDATED= new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated", 15/*15*/, "The timestamp for when the record was last updated. (TILDA.Job)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job.deleted -> TILDA.Job."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Job)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Job.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  DELETED    = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"    , 16/*16*/, "The timestamp for when the record was deleted. (TILDA.Job)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.REFNUM,COLS.NAME,COLS.TYPE,COLS.USERID,COLS.DATASTARTTZ,COLS.DATASTART,COLS.DATAENDTZ,COLS.DATAEND,COLS.STARTTZ,COLS.START,COLS.ENDTZ,COLS.END,COLS.STATUS,COLS.MSG,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.REFNUM };

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
           tilda.data.Job_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.Job_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Job_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.Job_Data> _OP;
       protected ArrayListResults<tilda.data.Job_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.Job_Data Obj = new tilda.data.Job_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__JOB)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.Job_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__JOB Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__JOB_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "Job");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Index 'JobName'
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Job", "name"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Job", "start"); S.append(" DESC");
                break;
             case 2: // Index 'JobType'
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Job", "type"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Job", "start"); S.append(" DESC");
                break;
             case 3: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Job", "refnum"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDA.Job", Q, null);
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
             case 1: {  // Index 'JobName'
               PS.setString    (++i, Obj._name       );
               break;
             }
             case 2: {  // Index 'JobType'
               if (Obj.isTypeNull() == true) PS.setNull(++i, java.sql.Types.VARCHAR   );  else PS.setString    (++i, Obj._type       );
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
          tilda.data._Tilda.TILDA__2_3.handleFinally(PS, T0, TILDA__JOB_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.data.Job_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data._Tilda.TILDA__JOB Obj = new tilda.data.Job_Data();
       String[] vals = null;

       vals = Values.get("refnum");
       // Even though this is a primary key, and is by definition not-null, we nevertheless check it as optional in case
       // this object is being initialized generically for a create.
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("refnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _refnum = ParseUtil.parseLong("refnum", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_refnum != null) Obj.setRefnum(_refnum);

       vals = Values.get("name");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("name", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _name = ParseUtil.parseString("name", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_name != null) Obj.setName(_name);

       vals = Values.get("type");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("type", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _type = ParseUtil.parseString("type", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_type != null) Obj.setType(_type);

       vals = Values.get("userId");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("userId", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _userId = ParseUtil.parseString("userId", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_userId != null) Obj.setUserId(_userId);

       vals = Values.get("dataStart");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dataStart", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dataStart = ParseUtil.parseZonedDateTime("dataStart", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dataStart != null) Obj.setDataStart(_dataStart);

       vals = Values.get("dataEnd");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dataEnd", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dataEnd = ParseUtil.parseZonedDateTime("dataEnd", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dataEnd != null) Obj.setDataEnd(_dataEnd);

       vals = Values.get("start");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("start", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _start = ParseUtil.parseZonedDateTime("start", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_start != null) Obj.setStart(_start);

       vals = Values.get("end");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("end", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _end = ParseUtil.parseZonedDateTime("end", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_end != null) Obj.setEnd(_end);

       vals = Values.get("status");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("status", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Boolean _status = ParseUtil.parseBoolean("status", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_status != null) Obj.setStatus(_status);

       vals = Values.get("msg");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("msg", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _msg = ParseUtil.parseString("msg", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_msg != null) Obj.setMsg(_msg);


       return (tilda.data.Job_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param name        (max size 250) Name
 @param start       StartTime
*/
   static public tilda.data.Job_Data create(String name, ZonedDateTime start) throws Exception
     {
       tilda.data._Tilda.TILDA__JOB Obj = new tilda.data.Job_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDA.JOB"));

       // Explicit setters
       Obj.setName       (name       );
       Obj.setStart      (start      );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       // Default Nullables
       Obj.__Nulls.or(TILDA__JOB_Factory.COLS.TYPE._Mask);
       Obj.__Nulls.or(TILDA__JOB_Factory.COLS.USERID._Mask);
       Obj.__Nulls.or(TILDA__JOB_Factory.COLS.DATASTART._Mask);
       Obj.__Nulls.or(TILDA__JOB_Factory.COLS.DATAEND._Mask);
       Obj.__Nulls.or(TILDA__JOB_Factory.COLS.END._Mask);
       Obj.__Nulls.or(TILDA__JOB_Factory.COLS.STATUS._Mask);
       Obj.__Nulls.or(TILDA__JOB_Factory.COLS.MSG._Mask);

       return (tilda.data.Job_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data.Job_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__JOB lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__JOB) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__JOB) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.Job_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__JOB) d);

               if (((TILDA__JOB) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Job_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__JOB_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__JOB) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Job_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__JOB_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__JOB) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Job_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__JOB_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__JOB) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Job_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__JOB_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.Job_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'Job_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__2_3.handleFinally(PS, T0, TILDA__JOB_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: refnum.
*/
   static public tilda.data.Job_Data lookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__JOB Obj = new tilda.data.Job_Data();
       Obj.initForLookup(0);

       Obj.setRefnum     (refnum     ); Obj.__Saved_refnum      = Obj._refnum     ;

       return (tilda.data.Job_Data) Obj;
     }

/**
Lookup records by the index 'JobName' over  name.<BR>The results are ordered by: start desc
*/
   static public ListResults<tilda.data.Job_Data> lookupWhereJobName(Connection C, String name, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOB Obj = new tilda.data.Job_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setName       (name       );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }

/**
Lookup records by the index 'JobName' over  name.<BR>The results are ordered by: start desc
*/
   static public void lookupWhereJobName(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Job_Data> OP, String name, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOB Obj = new tilda.data.Job_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setName       (name       );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }



/**
Lookup records by the index 'JobType' over  type.<BR>The results are ordered by: start desc
*/
   static public ListResults<tilda.data.Job_Data> lookupWhereJobType(Connection C, String type, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOB Obj = new tilda.data.Job_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setType       (type       );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 2, RPI, Obj, null, start, size);
       return RPI._L;
     }

/**
Lookup records by the index 'JobType' over  type.<BR>The results are ordered by: start desc
*/
   static public void lookupWhereJobType(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Job_Data> OP, String type, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOB Obj = new tilda.data.Job_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setType       (type       );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, start, size);
     }



/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: refnum asc
*/   static public ListResults<tilda.data.Job_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOB Obj = new tilda.data.Job_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 3, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: refnum asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Job_Data> OP, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__JOB Obj = new tilda.data.Job_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 3, RPI, Obj, null, start, size);
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.Job_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.Job_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


   public static String getCSVHeader()
    {
      return "\"refnum\",\"name\",\"type\",\"userId\",\"dataStartTZ\",\"dataStart\",\"dataEndTZ\",\"dataEnd\",\"startTZ\",\"start\",\"endTZ\",\"end\",\"status\",\"msg\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.Job_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.Job_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.Job_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__JOB Obj = (tilda.data._Tilda.TILDA__JOB) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getType());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getUserId());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDataStartTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDataStart()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDataEndTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDataEnd()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getStartTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getStart()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getEndTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getEnd()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getStatus());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getMsg());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.Job_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data.Job_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data.Job_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.Job_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.Job_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__JOB Obj = (tilda.data._Tilda.TILDA__JOB) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "refnum", ++i==0, Obj.getRefnum());

        JSONUtil.print(out, "name", ++i==0, Obj.getName());

      if (Obj.isTypeNull() == false && Obj.getType() != null)
        JSONUtil.print(out, "type", ++i==0, Obj.getType());

      if (Obj.isUserIdNull() == false && Obj.getUserId() != null)
        JSONUtil.print(out, "userId", ++i==0, Obj.getUserId());

      if (Obj.isDataStartTZNull() == false && Obj.getDataStartTZ() != null)
        JSONUtil.print(out, "dataStartTZ", ++i==0, Obj.getDataStartTZ());

      if (Obj.isDataStartNull() == false && Obj.getDataStart() != null)
        JSONUtil.print(out, "dataStart", ++i==0, Obj.getDataStart());

      if (Obj.isDataEndTZNull() == false && Obj.getDataEndTZ() != null)
        JSONUtil.print(out, "dataEndTZ", ++i==0, Obj.getDataEndTZ());

      if (Obj.isDataEndNull() == false && Obj.getDataEnd() != null)
        JSONUtil.print(out, "dataEnd", ++i==0, Obj.getDataEnd());

        JSONUtil.print(out, "startTZ", ++i==0, Obj.getStartTZ());

        JSONUtil.print(out, "start", ++i==0, Obj.getStart());

      if (Obj.isEndTZNull() == false && Obj.getEndTZ() != null)
        JSONUtil.print(out, "endTZ", ++i==0, Obj.getEndTZ());

      if (Obj.isEndNull() == false && Obj.getEnd() != null)
        JSONUtil.print(out, "end", ++i==0, Obj.getEnd());

      if (Obj.isStatusNull() == false)
        JSONUtil.print(out, "status", ++i==0, Obj.getStatus());

      if (Obj.isMsgNull() == false && Obj.getMsg() != null)
        JSONUtil.print(out, "msg", ++i==0, Obj.getMsg());

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
