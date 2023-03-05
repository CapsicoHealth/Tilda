
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
public class TILDA__JOBVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__JOBVIEW_Factory.class.getName());

   protected TILDA__JOBVIEW_Factory() { }

   public static final Class<TILDA__JOBVIEW> DATA_CLASS= TILDA__JOBVIEW.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("JobView", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.JobView", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "JobView"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobRefnum -> TILDA.JobView."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive          JOBREFNUM          = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "jobRefnum"          , 0/*0*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobName -> TILDA.JobView."jobName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobName of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        JOBNAME            = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "jobName"            , 1/*1*/, 250, "Name", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobType -> TILDA.JobView."jobType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    JOBTYPE            = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "jobType"            , 2/*2*/, 250, "Job type", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobUserId -> TILDA.JobView."jobUserId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobUserId of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job user Id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobUserId of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobUserId</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    JOBUSERID          = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "jobUserId"          , 3/*3*/, 250, "Job user Id", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStartTZ -> TILDA.JobView."jobDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    JOBDATASTARTTZ     = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "jobDataStartTZ"     , 4/*4*/, 5, "Generated helper column to hold the time zone ID for 'jobDataStart'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStart -> TILDA.JobView."jobDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  JOBDATASTART       = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "jobDataStart"       , 5/*5*/, "StartTime", null, null, JOBDATASTARTTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEndTZ -> TILDA.JobView."jobDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    JOBDATAENDTZ       = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "jobDataEndTZ"       , 6/*6*/, 5, "Generated helper column to hold the time zone ID for 'jobDataEnd'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEnd -> TILDA.JobView."jobDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  JOBDATAEND         = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "jobDataEnd"         , 7/*7*/, "StartTime", null, null, JOBDATAENDTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStartTZ -> TILDA.JobView."jobStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        JOBSTARTTZ         = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "jobStartTZ"         , 8/*8*/, 5, "Generated helper column to hold the time zone ID for 'jobStart'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStart -> TILDA.JobView."jobStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitive      JOBSTART           = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "jobStart"           , 9/*9*/, "StartTime", null, null, JOBSTARTTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEndTZ -> TILDA.JobView."jobEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    JOBENDTZ           = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "jobEndTZ"           , 10/*10*/, 5, "Generated helper column to hold the time zone ID for 'jobEnd'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEnd -> TILDA.JobView."jobEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>EndTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  JOBEND             = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "jobEnd"             , 11/*11*/, "EndTime", null, null, JOBENDTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStatus -> TILDA.JobView."jobStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_BooleanPrimitiveNull   JOBSTATUS          = new Type_BooleanPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "jobStatus"          , 12/*12*/, "Status", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobMsg -> TILDA.JobView."jobMsg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobMsg of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobMsg of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobMsg</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    JOBMSG             = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "jobMsg"             , 13/*13*/, 8192, "Message details", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartName -> TILDA.JobView."jobPartName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartName of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        JOBPARTNAME        = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartName"        , 14/*14*/, 250, "Job part name", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartType -> TILDA.JobView."jobPartType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    JOBPARTTYPE        = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartType"        , 15/*15*/, 250, "Job part type", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStartTZ -> TILDA.JobView."jobPartDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    JOBPARTDATASTARTTZ = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartDataStartTZ" , 16/*16*/, 5, "Generated helper column to hold the time zone ID for 'jobPartDataStart'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStart -> TILDA.JobView."jobPartDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  JOBPARTDATASTART   = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartDataStart"   , 17/*17*/, "Job part data start", null, null, JOBPARTDATASTARTTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEndTZ -> TILDA.JobView."jobPartDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    JOBPARTDATAENDTZ   = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartDataEndTZ"   , 18/*18*/, 5, "Generated helper column to hold the time zone ID for 'jobPartDataEnd'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEnd -> TILDA.JobView."jobPartDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  JOBPARTDATAEND     = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartDataEnd"     , 19/*19*/, "Job part data end", null, null, JOBPARTDATAENDTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStartTZ -> TILDA.JobView."jobPartStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        JOBPARTSTARTTZ     = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartStartTZ"     , 20/*20*/, 5, "Generated helper column to hold the time zone ID for 'jobPartStart'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStart -> TILDA.JobView."jobPartStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitive      JOBPARTSTART       = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartStart"       , 21/*21*/, "Job part execution start", null, null, JOBPARTSTARTTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEndTZ -> TILDA.JobView."jobPartEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    JOBPARTENDTZ       = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartEndTZ"       , 22/*22*/, 5, "Generated helper column to hold the time zone ID for 'jobPartEnd'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEnd -> TILDA.JobView."jobPartEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  JOBPARTEND         = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartEnd"         , 23/*23*/, "Job part execution end", null, null, JOBPARTENDTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartRecordsCount -> TILDA.JobView."jobPartRecordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartRecordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartRecordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartRecordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull   JOBPARTRECORDSCOUNT= new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartRecordsCount", 24/*24*/, "count of database or file or ... records.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStatus -> TILDA.JobView."jobPartStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_BooleanPrimitiveNull   JOBPARTSTATUS      = new Type_BooleanPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartStatus"      , 25/*25*/, "Status flag, i.e., success=true and failure-false", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartNotify -> TILDA.JobView."jobPartNotify"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartNotify of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Notification flag</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartNotify of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartNotify</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_BooleanPrimitive       JOBPARTNOTIFY      = new Type_BooleanPrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartNotify"      , 26/*26*/, "Notification flag", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartMessage -> TILDA.JobView."jobPartMessage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartMessage of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartMessage of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartMessage</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        JOBPARTMESSAGE     = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "jobPartMessage"     , 27/*27*/, 8192, "Message details", null, null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.JOBREFNUM,COLS.JOBNAME,COLS.JOBTYPE,COLS.JOBUSERID,COLS.JOBDATASTARTTZ,COLS.JOBDATASTART,COLS.JOBDATAENDTZ,COLS.JOBDATAEND,COLS.JOBSTARTTZ,COLS.JOBSTART,COLS.JOBENDTZ,COLS.JOBEND,COLS.JOBSTATUS,COLS.JOBMSG,COLS.JOBPARTNAME,COLS.JOBPARTTYPE,COLS.JOBPARTDATASTARTTZ,COLS.JOBPARTDATASTART,COLS.JOBPARTDATAENDTZ,COLS.JOBPARTDATAEND,COLS.JOBPARTSTARTTZ,COLS.JOBPARTSTART,COLS.JOBPARTENDTZ,COLS.JOBPARTEND,COLS.JOBPARTRECORDSCOUNT,COLS.JOBPARTSTATUS,COLS.JOBPARTNOTIFY,COLS.JOBPARTMESSAGE };

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
           tilda.data.JobView_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.JobView_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.JobView_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.JobView_Data> _OP;
       protected ArrayListResults<tilda.data.JobView_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.JobView_Data Obj = new tilda.data.JobView_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__JOBVIEW)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.JobView_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__JOBVIEW Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__JOBVIEW_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "JobView");
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
       QueryDetails.logQuery("TILDA.JobView", Q, null);
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
          tilda.data._Tilda.TILDA__2_3.handleFinally(PS, T0, TILDA__JOBVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
Lookup records by the query 'All' over 
.<BR>
*/
   static public tilda.data.JobView_Data lookupByAll() throws Exception
     {
       tilda.data._Tilda.TILDA__JOBVIEW Obj = new tilda.data.JobView_Data();
       Obj.initForLookup(0);


       return (tilda.data.JobView_Data) Obj;
     }










   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.JobView_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.JobView_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }


   public static String getCSVHeader()
    {
      return "\"jobRefnum\",\"jobName\",\"jobType\",\"jobUserId\",\"jobDataStartTZ\",\"jobDataStart\",\"jobDataEndTZ\",\"jobDataEnd\",\"jobStartTZ\",\"jobStart\",\"jobEndTZ\",\"jobEnd\",\"jobStatus\",\"jobMsg\",\"jobPartName\",\"jobPartType\",\"jobPartDataStartTZ\",\"jobPartDataStart\",\"jobPartDataEndTZ\",\"jobPartDataEnd\",\"jobPartStartTZ\",\"jobPartStart\",\"jobPartEndTZ\",\"jobPartEnd\",\"jobPartRecordsCount\",\"jobPartStatus\",\"jobPartNotify\",\"jobPartMessage\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.JobView_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.JobView_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.JobView_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__JOBVIEW Obj = (tilda.data._Tilda.TILDA__JOBVIEW) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getJobRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobType());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobUserId());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobDataStartTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getJobDataStart()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobDataEndTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getJobDataEnd()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobStartTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getJobStart()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobEndTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getJobEnd()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getJobStatus());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobMsg());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobPartName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobPartType());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobPartDataStartTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getJobPartDataStart()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobPartDataEndTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getJobPartDataEnd()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobPartStartTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getJobPartStart()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobPartEndTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getJobPartEnd()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getJobPartRecordsCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getJobPartStatus());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getJobPartNotify());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getJobPartMessage());
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.JobView_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data.JobView_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data.JobView_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.JobView_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.JobView_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__JOBVIEW Obj = (tilda.data._Tilda.TILDA__JOBVIEW) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "jobRefnum", ++i==0, Obj.getJobRefnum());

        JSONUtil.print(out, "jobName", ++i==0, Obj.getJobName());

      if (Obj.isJobTypeNull() == false && Obj.getJobType() != null)
        JSONUtil.print(out, "jobType", ++i==0, Obj.getJobType());

      if (Obj.isJobUserIdNull() == false && Obj.getJobUserId() != null)
        JSONUtil.print(out, "jobUserId", ++i==0, Obj.getJobUserId());

      if (Obj.isJobDataStartTZNull() == false && Obj.getJobDataStartTZ() != null)
        JSONUtil.print(out, "jobDataStartTZ", ++i==0, Obj.getJobDataStartTZ());

      if (Obj.isJobDataStartNull() == false && Obj.getJobDataStart() != null)
        JSONUtil.print(out, "jobDataStart", ++i==0, Obj.getJobDataStart());

      if (Obj.isJobDataEndTZNull() == false && Obj.getJobDataEndTZ() != null)
        JSONUtil.print(out, "jobDataEndTZ", ++i==0, Obj.getJobDataEndTZ());

      if (Obj.isJobDataEndNull() == false && Obj.getJobDataEnd() != null)
        JSONUtil.print(out, "jobDataEnd", ++i==0, Obj.getJobDataEnd());

        JSONUtil.print(out, "jobStartTZ", ++i==0, Obj.getJobStartTZ());

        JSONUtil.print(out, "jobStart", ++i==0, Obj.getJobStart());

      if (Obj.isJobEndTZNull() == false && Obj.getJobEndTZ() != null)
        JSONUtil.print(out, "jobEndTZ", ++i==0, Obj.getJobEndTZ());

      if (Obj.isJobEndNull() == false && Obj.getJobEnd() != null)
        JSONUtil.print(out, "jobEnd", ++i==0, Obj.getJobEnd());

      if (Obj.isJobStatusNull() == false)
        JSONUtil.print(out, "jobStatus", ++i==0, Obj.getJobStatus());

      if (Obj.isJobMsgNull() == false && Obj.getJobMsg() != null)
        JSONUtil.print(out, "jobMsg", ++i==0, Obj.getJobMsg());

        JSONUtil.print(out, "jobPartName", ++i==0, Obj.getJobPartName());

      if (Obj.isJobPartTypeNull() == false && Obj.getJobPartType() != null)
        JSONUtil.print(out, "jobPartType", ++i==0, Obj.getJobPartType());

      if (Obj.isJobPartDataStartTZNull() == false && Obj.getJobPartDataStartTZ() != null)
        JSONUtil.print(out, "jobPartDataStartTZ", ++i==0, Obj.getJobPartDataStartTZ());

      if (Obj.isJobPartDataStartNull() == false && Obj.getJobPartDataStart() != null)
        JSONUtil.print(out, "jobPartDataStart", ++i==0, Obj.getJobPartDataStart());

      if (Obj.isJobPartDataEndTZNull() == false && Obj.getJobPartDataEndTZ() != null)
        JSONUtil.print(out, "jobPartDataEndTZ", ++i==0, Obj.getJobPartDataEndTZ());

      if (Obj.isJobPartDataEndNull() == false && Obj.getJobPartDataEnd() != null)
        JSONUtil.print(out, "jobPartDataEnd", ++i==0, Obj.getJobPartDataEnd());

        JSONUtil.print(out, "jobPartStartTZ", ++i==0, Obj.getJobPartStartTZ());

        JSONUtil.print(out, "jobPartStart", ++i==0, Obj.getJobPartStart());

      if (Obj.isJobPartEndTZNull() == false && Obj.getJobPartEndTZ() != null)
        JSONUtil.print(out, "jobPartEndTZ", ++i==0, Obj.getJobPartEndTZ());

      if (Obj.isJobPartEndNull() == false && Obj.getJobPartEnd() != null)
        JSONUtil.print(out, "jobPartEnd", ++i==0, Obj.getJobPartEnd());

      if (Obj.isJobPartRecordsCountNull() == false)
        JSONUtil.print(out, "jobPartRecordsCount", ++i==0, Obj.getJobPartRecordsCount());

      if (Obj.isJobPartStatusNull() == false)
        JSONUtil.print(out, "jobPartStatus", ++i==0, Obj.getJobPartStatus());

        JSONUtil.print(out, "jobPartNotify", ++i==0, Obj.getJobPartNotify());

        JSONUtil.print(out, "jobPartMessage", ++i==0, Obj.getJobPartMessage());

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
