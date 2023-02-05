
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
public class TILDA__MAINTENANCELOG_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__MAINTENANCELOG_Factory.class.getName());

   protected TILDA__MAINTENANCELOG_Factory() { }

   public static final Class<TILDA__MAINTENANCELOG> DATA_CLASS= TILDA__MAINTENANCELOG.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("MaintenanceLog", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.MaintenanceLog", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "MaintenanceLog"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.refnum -> TILDA.MaintenanceLog."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive          REFNUM     = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"     , 0/*0*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.type -> TILDA.MaintenanceLog."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.type of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The type of maintenance, e.g., Migration, Reorg...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>Migration</B>&nbsp;&nbsp;</TD><TD>Migration&nbsp;&nbsp;</TD><TD>Migration&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>A migration operation</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>Optimize</B>&nbsp;&nbsp;</TD><TD>Optimize&nbsp;&nbsp;</TD><TD>Optimize&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>A vaccuum/reorg operation typically</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_StringPrimitive        TYPE       = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "type"       , 1/*1*/, 64, "The type of maintenance, e.g., Migration, Reorg...", null, null, new String[][] {{"Migration","A migration operation"}, {"Optimize","A vaccuum/reorg operation typically"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.schemaName -> TILDA.MaintenanceLog."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.schemaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.schemaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema for the resource.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        SCHEMANAME = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "schemaName" , 2/*2*/, 64, "The name of the schema for the resource.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.objectName -> TILDA.MaintenanceLog."objectName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.objectName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.objectName of type varchar(1024)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>1024</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the resource.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    OBJECTNAME = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "objectName" , 3/*3*/, 1024, "The name of the resource.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.objectType -> TILDA.MaintenanceLog."objectType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.objectType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.objectType of type varchar(128)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The type of the resource.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>Table</B>&nbsp;&nbsp;</TD><TD>Table&nbsp;&nbsp;</TD><TD>Table&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>A table</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>View</B>&nbsp;&nbsp;</TD><TD>View&nbsp;&nbsp;</TD><TD>View&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>A view</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>Column</B>&nbsp;&nbsp;</TD><TD>Column&nbsp;&nbsp;</TD><TD>Column&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>A column</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Index</B>&nbsp;&nbsp;</TD><TD>Index&nbsp;&nbsp;</TD><TD>Index&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>An index.</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Function</B>&nbsp;&nbsp;</TD><TD>Function&nbsp;&nbsp;</TD><TD>Function&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>A function</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Procedure</B>&nbsp;&nbsp;</TD><TD>Procedure&nbsp;&nbsp;</TD><TD>Procedure&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>A procedure</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Script</B>&nbsp;&nbsp;</TD><TD>Script&nbsp;&nbsp;</TD><TD>Script&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>A script</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_StringPrimitiveNull    OBJECTTYPE = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "objectType" , 4/*4*/, 128, "The type of the resource.", null, null, new String[][] {{"Table","A table"}, {"View","A view"}, {"Column","A column"}, {"Index","An index."}, {"Function","A function"}, {"Procedure","A procedure"}, {"Script","A script"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.startTimeTZ -> TILDA.MaintenanceLog."startTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.startTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.startTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        STARTTIMETZ= new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "startTimeTZ", 5/*5*/, 5, "Generated helper column to hold the time zone ID for 'startTime'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.startTime -> TILDA.MaintenanceLog."startTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.startTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.startTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the refill started.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitive      STARTTIME  = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "startTime"  , 6/*6*/, "The timestamp for when the refill started.", null, null, STARTTIMETZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.endTimeTZ -> TILDA.MaintenanceLog."endTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.endTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.endTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    ENDTIMETZ  = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "endTimeTZ"  , 7/*7*/, 5, "Generated helper column to hold the time zone ID for 'endTime'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.endTime -> TILDA.MaintenanceLog."endTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.endTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.endTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the refill ended.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  ENDTIME    = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "endTime"    , 8/*8*/, "The timestamp for when the refill ended.", null, null, ENDTIMETZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.statement -> TILDA.MaintenanceLog."statement"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.statement of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.statement of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>256000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The value of the maintenance resource to track.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    STATEMENT  = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "statement"  , 9/*9*/, 256000, "The value of the maintenance resource to track.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.action -> TILDA.MaintenanceLog."action"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.action of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.action of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the maintenance resource to track.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>Execute</B>&nbsp;&nbsp;</TD><TD>Execute&nbsp;&nbsp;</TD><TD>Execute&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Execute</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>Create</B>&nbsp;&nbsp;</TD><TD>Create&nbsp;&nbsp;</TD><TD>Create&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Create</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>Update</B>&nbsp;&nbsp;</TD><TD>Update&nbsp;&nbsp;</TD><TD>Update&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Update</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Drop</B>&nbsp;&nbsp;</TD><TD>Drop&nbsp;&nbsp;</TD><TD>Drop&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Drop</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Rename</B>&nbsp;&nbsp;</TD><TD>Rename&nbsp;&nbsp;</TD><TD>Rename&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Rename</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Optimize</B>&nbsp;&nbsp;</TD><TD>Optimize&nbsp;&nbsp;</TD><TD>Optimize&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Optimize</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Vacuum</B>&nbsp;&nbsp;</TD><TD>Vacuum&nbsp;&nbsp;</TD><TD>Vacuum&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Vacuum</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Reorg</B>&nbsp;&nbsp;</TD><TD>Reorg&nbsp;&nbsp;</TD><TD>Reorg&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Reorg</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>Cluster</B>&nbsp;&nbsp;</TD><TD>Cluster&nbsp;&nbsp;</TD><TD>Cluster&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Cluster</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_StringPrimitiveNull    ACTION     = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "action"     , 10/*10*/, 64, "The name of the maintenance resource to track.", null, null, new String[][] {{"Execute","Execute"}, {"Create","Create"}, {"Update","Update"}, {"Drop","Drop"}, {"Rename","Rename"}, {"Optimize","Optimize"}, {"Vacuum","Vacuum"}, {"Reorg","Reorg"}, {"Cluster","Cluster"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.descr -> TILDA.MaintenanceLog."descr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.descr of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.descr of type varchar(2048)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>2048</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the maintenance resource to track.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    DESCR      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "descr"      , 11/*11*/, 2048, "The name of the maintenance resource to track.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.created -> TILDA.MaintenanceLog."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.MaintenanceLog)</TD></TR>
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
     public final Type_DatetimePrimitive      CREATED    = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"    , 12/*12*/, "The timestamp for when the record was created. (TILDA.MaintenanceLog)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.lastUpdated -> TILDA.MaintenanceLog."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.MaintenanceLog)</TD></TR>
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
     public final Type_DatetimePrimitive      LASTUPDATED= new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated", 13/*13*/, "The timestamp for when the record was last updated. (TILDA.MaintenanceLog)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MaintenanceLog.deleted -> TILDA.MaintenanceLog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MaintenanceLog.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MaintenanceLog.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.MaintenanceLog)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  DELETED    = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"    , 14/*14*/, "The timestamp for when the record was deleted. (TILDA.MaintenanceLog)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.REFNUM,COLS.TYPE,COLS.SCHEMANAME,COLS.OBJECTNAME,COLS.OBJECTTYPE,COLS.STARTTIMETZ,COLS.STARTTIME,COLS.ENDTIMETZ,COLS.ENDTIME,COLS.STATEMENT,COLS.ACTION,COLS.DESCR,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.REFNUM };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = new ColumnDefinition[][]{ 
        };

   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = {};

   // Short(short) is deprecated, but we do want a new instance here to avoid synchronizing over the same cached instance from valueOf.
   // @SuppressWarnings("deprecation")
   private static Short __INITIALIZED = new Short(RandomUtil.pickNonZeroShort());
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED != 0)
        synchronized(__INITIALIZED)
         {
           if (__INITIALIZED != 0)
            {
              tilda.data.MaintenanceLog_Factory.init(C);
              __INITIALIZED = 0;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.MaintenanceLog_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.MaintenanceLog_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.MaintenanceLog_Data> _OP;
       protected ArrayListResults<tilda.data.MaintenanceLog_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.MaintenanceLog_Data Obj = new tilda.data.MaintenanceLog_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__MAINTENANCELOG)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.MaintenanceLog_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__MAINTENANCELOG Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__MAINTENANCELOG_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "MaintenanceLog");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Index 'SchemaObjectStart'
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "MaintenanceLog", "schemaName"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "MaintenanceLog", "objectName"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "MaintenanceLog", "startTime"); S.append(" DESC");
                break;
             case 2: // Index 'TypeStart'
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "MaintenanceLog", "type"); S.append("=?");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "MaintenanceLog", "startTime"); S.append(" DESC");
                break;
             case 3: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "MaintenanceLog", "refnum"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDA.MaintenanceLog", Q, null);
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
             case 1: {  // Index 'SchemaObjectStart'
               PS.setString    (++i, Obj._schemaName );
               if (Obj.isObjectNameNull() == true) PS.setNull(++i, java.sql.Types.VARCHAR   );  else PS.setString    (++i, Obj._objectName );
               break;
             }
             case 2: {  // Index 'TypeStart'
               PS.setString    (++i, Obj._type       );
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
          tilda.data._Tilda.TILDA__2_3.handleFinally(PS, T0, TILDA__MAINTENANCELOG_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.data.MaintenanceLog_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = new tilda.data.MaintenanceLog_Data();
       String[] vals = null;

       vals = Values.get("refnum");
       // Even though this is a primary key, and is by definition not-null, we nevertheless check it as optional in case
       // this object is being initialized generically for a create.
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("refnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _refnum = ParseUtil.parseLong("refnum", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_refnum != null) Obj.setRefnum(_refnum);

       vals = Values.get("type");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("type", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _type = ParseUtil.parseString("type", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_type != null) Obj.setType(_type);

       vals = Values.get("schemaName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("schemaName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _schemaName = ParseUtil.parseString("schemaName", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_schemaName != null) Obj.setSchemaName(_schemaName);

       vals = Values.get("objectName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("objectName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _objectName = ParseUtil.parseString("objectName", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_objectName != null) Obj.setObjectName(_objectName);

       vals = Values.get("objectType");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("objectType", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _objectType = ParseUtil.parseString("objectType", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_objectType != null) Obj.setObjectType(_objectType);

       vals = Values.get("startTime");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("startTime", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _startTime = ParseUtil.parseZonedDateTime("startTime", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_startTime != null) Obj.setStartTime(_startTime);

       vals = Values.get("endTime");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("endTime", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _endTime = ParseUtil.parseZonedDateTime("endTime", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_endTime != null) Obj.setEndTime(_endTime);

       vals = Values.get("statement");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("statement", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _statement = ParseUtil.parseString("statement", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_statement != null) Obj.setStatement(_statement);

       vals = Values.get("action");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("action", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _action = ParseUtil.parseString("action", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_action != null) Obj.setAction(_action);

       vals = Values.get("descr");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("descr", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _descr = ParseUtil.parseString("descr", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_descr != null) Obj.setDescr(_descr);


       return (tilda.data.MaintenanceLog_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param type        (max size 64) The type of maintenance, e.g., Migration, Reorg...
 @param schemaName  (max size 64) The name of the schema for the resource.
 @param startTime   The timestamp for when the refill started.
*/
   static public tilda.data.MaintenanceLog_Data create(String type, String schemaName, ZonedDateTime startTime) throws Exception
     {
       tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = new tilda.data.MaintenanceLog_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDA.MAINTENANCELOG"));

       // Explicit setters
       Obj.setType       (type       );
       Obj.setSchemaName (schemaName );
       Obj.setStartTime  (startTime  );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       // Default Nullables
       Obj.__Nulls.or(TILDA__MAINTENANCELOG_Factory.COLS.OBJECTNAME._Mask);
       Obj.__Nulls.or(TILDA__MAINTENANCELOG_Factory.COLS.OBJECTTYPE._Mask);
       Obj.__Nulls.or(TILDA__MAINTENANCELOG_Factory.COLS.ENDTIME._Mask);
       Obj.__Nulls.or(TILDA__MAINTENANCELOG_Factory.COLS.STATEMENT._Mask);
       Obj.__Nulls.or(TILDA__MAINTENANCELOG_Factory.COLS.ACTION._Mask);
       Obj.__Nulls.or(TILDA__MAINTENANCELOG_Factory.COLS.DESCR._Mask);

       return (tilda.data.MaintenanceLog_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data.MaintenanceLog_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__MAINTENANCELOG lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__MAINTENANCELOG) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__MAINTENANCELOG) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.MaintenanceLog_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__MAINTENANCELOG) d);

               if (((TILDA__MAINTENANCELOG) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.MaintenanceLog_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__MAINTENANCELOG_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__MAINTENANCELOG) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.MaintenanceLog_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__MAINTENANCELOG_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__MAINTENANCELOG) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.MaintenanceLog_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__MAINTENANCELOG_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__MAINTENANCELOG) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.MaintenanceLog_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__MAINTENANCELOG_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.MaintenanceLog_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'MaintenanceLog_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__2_3.handleFinally(PS, T0, TILDA__MAINTENANCELOG_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: refnum.
*/
   static public tilda.data.MaintenanceLog_Data lookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = new tilda.data.MaintenanceLog_Data();
       Obj.initForLookup(0);

       Obj.setRefnum     (refnum     ); Obj.__Saved_refnum      = Obj._refnum     ;

       return (tilda.data.MaintenanceLog_Data) Obj;
     }

/**
Lookup records by the index 'SchemaObjectStart' over  schemaName, objectName.<BR>The results are ordered by: startTime desc
*/
   static public ListResults<tilda.data.MaintenanceLog_Data> lookupWhereSchemaObjectStart(Connection C, String schemaName, String objectName, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = new tilda.data.MaintenanceLog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName (schemaName );
       Obj.setObjectName (objectName );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }

/**
Lookup records by the index 'SchemaObjectStart' over  schemaName, objectName.<BR>The results are ordered by: startTime desc
*/
   static public void lookupWhereSchemaObjectStart(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.MaintenanceLog_Data> OP, String schemaName, String objectName, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = new tilda.data.MaintenanceLog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setSchemaName (schemaName );
       Obj.setObjectName (objectName );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }



/**
Lookup records by the index 'TypeStart' over  type.<BR>The results are ordered by: startTime desc
*/
   static public ListResults<tilda.data.MaintenanceLog_Data> lookupWhereTypeStart(Connection C, String type, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = new tilda.data.MaintenanceLog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setType       (type       );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 2, RPI, Obj, null, start, size);
       return RPI._L;
     }

/**
Lookup records by the index 'TypeStart' over  type.<BR>The results are ordered by: startTime desc
*/
   static public void lookupWhereTypeStart(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.MaintenanceLog_Data> OP, String type, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = new tilda.data.MaintenanceLog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setType       (type       );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, start, size);
     }



/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: refnum asc
*/   static public ListResults<tilda.data.MaintenanceLog_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = new tilda.data.MaintenanceLog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 3, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: refnum asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.MaintenanceLog_Data> OP, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = new tilda.data.MaintenanceLog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 3, RPI, Obj, null, start, size);
     }





   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.MaintenanceLog_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.MaintenanceLog_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }


   public static String getCSVHeader()
    {
      return "\"refnum\",\"type\",\"schemaName\",\"objectName\",\"objectType\",\"startTimeTZ\",\"startTime\",\"endTimeTZ\",\"endTime\",\"statement\",\"action\",\"descr\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.MaintenanceLog_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.MaintenanceLog_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.MaintenanceLog_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = (tilda.data._Tilda.TILDA__MAINTENANCELOG) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getType());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getSchemaName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getObjectName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getObjectType());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getStartTimeTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getStartTime()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getEndTimeTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getEndTime()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getStatement());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getAction());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDescr());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.MaintenanceLog_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data.MaintenanceLog_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data.MaintenanceLog_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.MaintenanceLog_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.MaintenanceLog_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__MAINTENANCELOG Obj = (tilda.data._Tilda.TILDA__MAINTENANCELOG) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "refnum", ++i==0, Obj.getRefnum());

        JSONUtil.print(out, "type", ++i==0, Obj.getType());

        JSONUtil.print(out, "schemaName", ++i==0, Obj.getSchemaName());

      if (Obj.isObjectNameNull() == false && Obj.getObjectName() != null)
        JSONUtil.print(out, "objectName", ++i==0, Obj.getObjectName());

      if (Obj.isObjectTypeNull() == false && Obj.getObjectType() != null)
        JSONUtil.print(out, "objectType", ++i==0, Obj.getObjectType());

        JSONUtil.print(out, "startTimeTZ", ++i==0, Obj.getStartTimeTZ());

        JSONUtil.print(out, "startTime", ++i==0, Obj.getStartTime());

      if (Obj.isEndTimeTZNull() == false && Obj.getEndTimeTZ() != null)
        JSONUtil.print(out, "endTimeTZ", ++i==0, Obj.getEndTimeTZ());

      if (Obj.isEndTimeNull() == false && Obj.getEndTime() != null)
        JSONUtil.print(out, "endTime", ++i==0, Obj.getEndTime());

      if (Obj.isStatementNull() == false && Obj.getStatement() != null)
        JSONUtil.print(out, "statement", ++i==0, Obj.getStatement());

      if (Obj.isActionNull() == false && Obj.getAction() != null)
        JSONUtil.print(out, "action", ++i==0, Obj.getAction());

      if (Obj.isDescrNull() == false && Obj.getDescr() != null)
        JSONUtil.print(out, "descr", ++i==0, Obj.getDescr());

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
