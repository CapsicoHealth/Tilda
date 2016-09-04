
package tilda.data._Tilda;

import java.time.*;
import java.util.*;

import tilda.db.*;
import tilda.enums.*;
import tilda.types.*;
import tilda.utils.*;
import tilda.utils.pairs.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class TILDA__OBJECTPERF_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__OBJECTPERF_Factory.class.getName());

   protected TILDA__OBJECTPERF_Factory() { }

   public static final Class<TILDA__OBJECTPERF> DATA_CLASS= TILDA__OBJECTPERF.class;
   public static final String SCHEMA_LABEL = TextUtil.Print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.Print("OBJECTPERF", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.Print("TILDA.OBJECTPERF", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "OBJECTPERF"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.schemaName -> TILDA.OBJECTPERF."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.schemaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.schemaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema tracked</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        SCHEMANAME   = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "schemaName"   , 0, "The name of the schema tracked");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.objectName -> TILDA.OBJECTPERF."objectName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.objectName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.objectName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the table/object tracked</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        OBJECTNAME   = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "objectName"   , 1, "The name of the table/object tracked");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.startPeriodTZ -> TILDA.OBJECTPERF."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.startPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.startPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        STARTPERIODTZ= new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "startPeriodTZ", 2, "Generated helper column to hold the time zone ID for 'startPeriod'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.startPeriod -> TILDA.OBJECTPERF."startPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.startPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.startPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitive      STARTPERIOD  = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "startPeriod"  , 3, "The timestamp for when the record was created.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.endPeriodTZ -> TILDA.OBJECTPERF."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.endPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.endPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        ENDPERIODTZ  = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "endPeriodTZ"  , 4, "Generated helper column to hold the time zone ID for 'endPeriod'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.endPeriod -> TILDA.OBJECTPERF."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.endPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitive      ENDPERIOD    = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "endPeriod"    , 5, "The timestamp for when the record was created.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.selectNano -> TILDA.OBJECTPERF."selectNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.selectNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.selectNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          SELECTNANO   = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "selectNano"   , 6, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.selectCount -> TILDA.OBJECTPERF."selectCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.selectCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.selectCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          SELECTCOUNT  = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "selectCount"  , 7, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.selectRecords -> TILDA.OBJECTPERF."selectRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.selectRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.selectRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          SELECTRECORDS= new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "selectRecords", 8, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.insertNano -> TILDA.OBJECTPERF."insertNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.insertNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.insertNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          INSERTNANO   = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "insertNano"   , 9, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.insertCount -> TILDA.OBJECTPERF."insertCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.insertCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.insertCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          INSERTCOUNT  = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "insertCount"  , 10, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.insertRecords -> TILDA.OBJECTPERF."insertRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.insertRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.insertRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          INSERTRECORDS= new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "insertRecords", 11, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.updateNano -> TILDA.OBJECTPERF."updateNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.updateNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.updateNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          UPDATENANO   = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "updateNano"   , 12, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.updateCount -> TILDA.OBJECTPERF."updateCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.updateCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.updateCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          UPDATECOUNT  = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "updateCount"  , 13, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.updateRecords -> TILDA.OBJECTPERF."updateRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.updateRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.updateRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          UPDATERECORDS= new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "updateRecords", 14, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.deleteNano -> TILDA.OBJECTPERF."deleteNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.deleteNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.deleteNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          DELETENANO   = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "deleteNano"   , 15, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.deleteCount -> TILDA.OBJECTPERF."deleteCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.deleteCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.deleteCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          DELETECOUNT  = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "deleteCount"  , 16, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.deleteRecords -> TILDA.OBJECTPERF."deleteRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.deleteRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.deleteRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          DELETERECORDS= new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "deleteRecords", 17, "Blah...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.created -> TILDA.OBJECTPERF."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
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
     public static Type_DatetimePrimitive      CREATED      = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"      , 18, "The timestamp for when the record was created.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.lastUpdated -> TILDA.OBJECTPERF."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated.</TD></TR>
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
     public static Type_DatetimePrimitive      LASTUPDATED  = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"  , 19, "The timestamp for when the record was last updated.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.OBJECTPERF.deleted -> TILDA.OBJECTPERF."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.OBJECTPERF.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.OBJECTPERF.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DELETED      = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"      , 20, "The timestamp for when the record was deleted.");
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
              tilda.data.ObjectPerf_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.ObjectPerf_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.ObjectPerf_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.ObjectPerf_Data> _OP;
       protected ArrayListResults<tilda.data.ObjectPerf_Data> _L = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.ObjectPerf_Data Obj = new tilda.data.ObjectPerf_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__OBJECTPERF)Obj).Init(_C, RS);
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

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__OBJECTPERF Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "schemaName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "objectName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "startPeriodTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "startPeriod");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "endPeriodTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "endPeriod");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "selectNano");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "selectCount");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "selectRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "insertNano");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "insertCount");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "insertRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "updateNano");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "updateCount");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "updateRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "deleteNano");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "deleteCount");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "deleteRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "created");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "lastUpdated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "deleted");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "OBJECTPERF");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
             break;
          case 1:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "schemaName"); S.append("=?)");
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "objectName"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "startPeriod"); S.append(" DESC");
             break;
          case 2:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "schemaName"); S.append("=? AND "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "objectName"); S.append("=?)");
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "OBJECTPERF", "startPeriod"); S.append(" DESC");
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       LOG.debug("TILDA([7mTILDA.OBJECTPERF[27m): "+Q);
       java.sql.PreparedStatement PS=null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
          switch (LookupId)
           {
             case -7:
                break;
             case 1: {
               PS.setString   (++i, Obj._schemaName   );
               break;
             }
             case 2: {
               PS.setString   (++i, Obj._schemaName   );
               PS.setString   (++i, Obj._objectName   );
               break;
             }
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Creates a new object in memory, which you can subsequently {@link #Write()} to the data store.
 current object to the destination. 
 @param schemaName    (max size 64) The name of the schema tracked
 @param objectName    (max size 64) The name of the table/object tracked
 @param startPeriod   The timestamp for when the record was created.
 @param endPeriod     The timestamp for when the record was created.
 @param selectNano    Blah...
 @param selectCount   Blah...
 @param selectRecords Blah...
 @param insertNano    Blah...
 @param insertCount   Blah...
 @param insertRecords Blah...
 @param updateNano    Blah...
 @param updateCount   Blah...
 @param updateRecords Blah...
 @param deleteNano    Blah...
 @param deleteCount   Blah...
 @param deleteRecords Blah...
*/
   static public tilda.data.ObjectPerf_Data Create(String schemaName, String objectName, ZonedDateTime startPeriod, ZonedDateTime endPeriod, long selectNano, long selectCount, long selectRecords, long insertNano, long insertCount, long insertRecords, long updateNano, long updateCount, long updateRecords, long deleteNano, long deleteCount, long deleteRecords) throws Exception
     {
       tilda.data._Tilda.TILDA__OBJECTPERF Obj = new tilda.data.ObjectPerf_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setSchemaName   (schemaName   );
       Obj.setObjectName   (objectName   );
       Obj.setStartPeriod  (startPeriod  );
       Obj.setEndPeriod    (endPeriod    );
       Obj.setSelectNano   (selectNano   );
       Obj.setSelectCount  (selectCount  );
       Obj.setSelectRecords(selectRecords);
       Obj.setInsertNano   (insertNano   );
       Obj.setInsertCount  (insertCount  );
       Obj.setInsertRecords(insertRecords);
       Obj.setUpdateNano   (updateNano   );
       Obj.setUpdateCount  (updateCount  );
       Obj.setUpdateRecords(updateRecords);
       Obj.setDeleteNano   (deleteNano   );
       Obj.setDeleteCount  (deleteCount  );
       Obj.setDeleteRecords(deleteRecords);

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.ObjectPerf_Data) Obj;
     }

   static public tilda.data.ObjectPerf_Data Create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       String        _schemaName    =                       ParseUtil.parseString("schemaName"   , true , Values.get("schemaName"   ), Errors );
       String        _objectName    =                       ParseUtil.parseString("objectName"   , true , Values.get("objectName"   ), Errors );
       ZonedDateTime        _startPeriod   =                       ParseUtil.parseZonedDateTime("startPeriod"  , true , Values.get("startPeriod"  ), Errors );
       ZonedDateTime        _endPeriod     =                       ParseUtil.parseZonedDateTime("endPeriod"    , true , Values.get("endPeriod"    ), Errors );
       Long        _selectNano    =                       ParseUtil.parseLong("selectNano"   , true , Values.get("selectNano"   ), Errors );
       Long        _selectCount   =                       ParseUtil.parseLong("selectCount"  , true , Values.get("selectCount"  ), Errors );
       Long        _selectRecords =                       ParseUtil.parseLong("selectRecords", true , Values.get("selectRecords"), Errors );
       Long        _insertNano    =                       ParseUtil.parseLong("insertNano"   , true , Values.get("insertNano"   ), Errors );
       Long        _insertCount   =                       ParseUtil.parseLong("insertCount"  , true , Values.get("insertCount"  ), Errors );
       Long        _insertRecords =                       ParseUtil.parseLong("insertRecords", true , Values.get("insertRecords"), Errors );
       Long        _updateNano    =                       ParseUtil.parseLong("updateNano"   , true , Values.get("updateNano"   ), Errors );
       Long        _updateCount   =                       ParseUtil.parseLong("updateCount"  , true , Values.get("updateCount"  ), Errors );
       Long        _updateRecords =                       ParseUtil.parseLong("updateRecords", true , Values.get("updateRecords"), Errors );
       Long        _deleteNano    =                       ParseUtil.parseLong("deleteNano"   , true , Values.get("deleteNano"   ), Errors );
       Long        _deleteCount   =                       ParseUtil.parseLong("deleteCount"  , true , Values.get("deleteCount"  ), Errors );
       Long        _deleteRecords =                       ParseUtil.parseLong("deleteRecords", true , Values.get("deleteRecords"), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.ObjectPerf_Data Obj = tilda.data.ObjectPerf_Factory.Create(_schemaName, _objectName, _startPeriod, _endPeriod, _selectNano, _selectCount, _selectRecords, _insertNano, _insertCount, _insertRecords, _updateNano, _updateCount, _updateRecords, _deleteNano, _deleteCount, _deleteRecords);


      return Obj;
     }

   static public tilda.data.ObjectPerf_Data LookupByPrimaryKey(String schemaName, String objectName, ZonedDateTime startPeriod) throws Exception
     {
       tilda.data._Tilda.TILDA__OBJECTPERF Obj = new tilda.data.ObjectPerf_Data();
       Obj.initForLookup(0);

       Obj.setSchemaName   (schemaName   ); Obj.__Saved_schemaName    = Obj._schemaName   ;
       Obj.setObjectName   (objectName   ); Obj.__Saved_objectName    = Obj._objectName   ;
       Obj.setStartPeriod  (startPeriod  ); Obj.__Saved_startPeriod   = Obj._startPeriod  ;

       return (tilda.data.ObjectPerf_Data) Obj;
     }

   static public ListResults<tilda.data.ObjectPerf_Data> LookupWhereSchemaByObjectStart(Connection C, String schemaName, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__OBJECTPERF Obj = new tilda.data.ObjectPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 1, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereSchemaByObjectStart(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.ObjectPerf_Data> OP, String schemaName, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__OBJECTPERF Obj = new tilda.data.ObjectPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 1, RPI, Obj, null, Start, Size);
     }


   static public ListResults<tilda.data.ObjectPerf_Data> LookupWhereSchemaObjectByStart(Connection C, String schemaName, String objectName, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__OBJECTPERF Obj = new tilda.data.ObjectPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );
       Obj.setObjectName   (objectName   );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 2, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereSchemaObjectByStart(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.ObjectPerf_Data> OP, String schemaName, String objectName, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__OBJECTPERF Obj = new tilda.data.ObjectPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName   (schemaName   );
       Obj.setObjectName   (objectName   );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 2, RPI, Obj, null, Start, Size);
     }




   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.ObjectPerf_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.ObjectPerf_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }

 }
