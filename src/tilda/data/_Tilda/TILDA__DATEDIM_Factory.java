
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
public class TILDA__DATEDIM_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__DATEDIM_Factory.class.getName());

   protected TILDA__DATEDIM_Factory() { }

   public static final Class<TILDA__DATEDIM> DATA_CLASS= TILDA__DATEDIM.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("DateDim", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.DateDim", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "DateDim"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dt -> TILDA.DateDim."dt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.dt of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dt of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The Date date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatePrimitive          DT            = new Type_DatePrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "dt"            , 0/*0*/, "The Date date");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.epoch -> TILDA.DateDim."epoch"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.epoch of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.epoch of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The epoch date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          EPOCH         = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "epoch"         , 1/*1*/, "The epoch date");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayName -> TILDA.DateDim."dayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.dayName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dayName of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Day name (i.e., Monday, Tuesday...) of the date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DAYNAME       = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "dayName"       , 2/*2*/, "Day name (i.e., Monday, Tuesday...) of the date");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfWeek -> TILDA.DateDim."dayOfWeek"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.dayOfWeek of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dayOfWeek of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 day of the week (Monday=1 to Sunday=7) of the date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   DAYOFWEEK     = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "dayOfWeek"     , 3/*3*/, "ISO 8601 day of the week (Monday=1 to Sunday=7) of the date");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfMonth -> TILDA.DateDim."dayOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.dayOfMonth of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dayOfMonth of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 day of the month (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   DAYOFMONTH    = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "dayOfMonth"    , 4/*4*/, "ISO 8601 day of the month (starting with 1) of the date");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfQuarter -> TILDA.DateDim."dayOfQuarter"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.dayOfQuarter of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dayOfQuarter of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 day of the quarter (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   DAYOFQUARTER  = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "dayOfQuarter"  , 5/*5*/, "ISO 8601 day of the quarter (starting with 1) of the date");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfYear -> TILDA.DateDim."dayOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.dayOfYear of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dayOfYear of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 day of the year (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   DAYOFYEAR     = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "dayOfYear"     , 6/*6*/, "ISO 8601 day of the year (starting with 1) of the date");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfMonth -> TILDA.DateDim."weekOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.weekOfMonth of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.weekOfMonth of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 week of the month (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   WEEKOFMONTH   = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "weekOfMonth"   , 7/*7*/, "ISO 8601 week of the month (starting with 1) of the date");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfYear -> TILDA.DateDim."weekOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.weekOfYear of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.weekOfYear of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 week of the year (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   WEEKOFYEAR    = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "weekOfYear"    , 8/*8*/, "ISO 8601 week of the year (starting with 1) of the date");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthOfYear -> TILDA.DateDim."monthOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.monthOfYear of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.monthOfYear of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 month of the year (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   MONTHOFYEAR   = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "monthOfYear"   , 9/*9*/, "ISO 8601 month of the year (starting with 1) of the date");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthName -> TILDA.DateDim."monthName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.monthName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.monthName of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Month name (i.e., January, February...) of the date.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    MONTHNAME     = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "monthName"     , 10/*10*/, "Month name (i.e., January, February...) of the date.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthNameShort -> TILDA.DateDim."monthNameShort"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.monthNameShort of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.monthNameShort of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Monday short name (i.e., Jan, Feb...) of the date.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    MONTHNAMESHORT= new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "monthNameShort", 11/*11*/, "Monday short name (i.e., Jan, Feb...) of the date.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterOfYear -> TILDA.DateDim."quarterOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.quarterOfYear of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.quarterOfYear of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 quarter of the year (starting with 1) of the date.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   QUARTEROFYEAR = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "quarterOfYear" , 12/*12*/, "ISO 8601 quarter of the year (starting with 1) of the date.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterName -> TILDA.DateDim."quarterName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.quarterName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.quarterName of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Quarter name (i.e., Q1, Q2...) of the date.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    QUARTERNAME   = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "quarterName"   , 13/*13*/, "Quarter name (i.e., Q1, Q2...) of the date.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.year -> TILDA.DateDim."year"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.year of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.year of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 year (1.e., 2018) of the date.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   YEAR          = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "year"          , 14/*14*/, "ISO 8601 year (1.e., 2018) of the date.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmyyyy -> TILDA.DateDim."mmyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.mmyyyy of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.mmyyyy of type character(6)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>6</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The mmyyyy printable version of a date.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    MMYYYY        = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "mmyyyy"        , 15/*15*/, "The mmyyyy printable version of a date.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmddyyyy -> TILDA.DateDim."mmddyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.mmddyyyy of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.mmddyyyy of type character(8)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The mmddyyyy printable version of a date.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    MMDDYYYY      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "mmddyyyy"      , 16/*16*/, "The mmddyyyy printable version of a date.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.yyyymmdd -> TILDA.DateDim."yyyymmdd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.yyyymmdd of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.yyyymmdd of type character(8)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The yyyymmdd sortable printable version of a date.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    YYYYMMDD      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "yyyymmdd"      , 17/*17*/, "The yyyymmdd sortable printable version of a date.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isWeekend -> TILDA.DateDim."isWeekend"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.isWeekend of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.isWeekend of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>1 if this is a weekend day, 0 otherwise.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   ISWEEKEND     = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "isWeekend"     , 18/*18*/, "1 if this is a weekend day, 0 otherwise.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isBusinessDay -> TILDA.DateDim."isBusinessDay"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.isBusinessDay of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.isBusinessDay of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>1 if this is a business day, 0 otherwise.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   ISBUSINESSDAY = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "isBusinessDay" , 19/*19*/, "1 if this is a business day, 0 otherwise.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isHoliday -> TILDA.DateDim."isHoliday"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.isHoliday of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.isHoliday of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>1 if this is a holiday, 0 otherwise.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   ISHOLIDAY     = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "isHoliday"     , 20/*20*/, "1 if this is a holiday, 0 otherwise.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.holidayName -> TILDA.DateDim."holidayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.holidayName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.holidayName of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the holiday if applicable.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    HOLIDAYNAME   = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "holidayName"   , 21/*21*/, "The name of the holiday if applicable.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.created -> TILDA.DateDim."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.DateDim)</TD></TR>
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
     public static Type_DatetimePrimitive      CREATED       = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"       , 22/*22*/, "The timestamp for when the record was created. (TILDA.DateDim)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.lastUpdated -> TILDA.DateDim."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.DateDim)</TD></TR>
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
     public static Type_DatetimePrimitive      LASTUPDATED   = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"   , 23/*23*/, "The timestamp for when the record was last updated. (TILDA.DateDim)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateDim.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.DateDim)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DELETED       = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"       , 24/*24*/, "The timestamp for when the record was deleted. (TILDA.DateDim)");
;
   }

   public static final ColumnDefinition[] COLUMNS = { COLS.DT,COLS.EPOCH,COLS.DAYNAME,COLS.DAYOFWEEK,COLS.DAYOFMONTH,COLS.DAYOFQUARTER,COLS.DAYOFYEAR,COLS.WEEKOFMONTH,COLS.WEEKOFYEAR,COLS.MONTHOFYEAR,COLS.MONTHNAME,COLS.MONTHNAMESHORT,COLS.QUARTEROFYEAR,COLS.QUARTERNAME,COLS.YEAR,COLS.MMYYYY,COLS.MMDDYYYY,COLS.YYYYMMDD,COLS.ISWEEKEND,COLS.ISBUSINESSDAY,COLS.ISHOLIDAY,COLS.HOLIDAYNAME,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = { COLS.DT };

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
              tilda.data.DateDim_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.DateDim_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.DateDim_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.DateDim_Data> _OP;
       protected ArrayListResults<tilda.data.DateDim_Data> _L = null;
       public void    start  () { }
       public void    end    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.DateDim_Data Obj = new tilda.data.DateDim_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__DATEDIM)Obj).init(_C, RS);
          if (OK == true)
           {
             if (_OP == null)
              _L.add(Obj);
             else
              _OP.process(Index, Obj);
           }
          return OK;
        }
     }

   protected static final void processMany(Connection C, String FullSelectQuery, int Start, int Size, tilda.db.processors.RecordProcessor RP) throws Exception
     {
       readMany(C, -77, RP, null, FullSelectQuery, Start, Size);
     }
   protected static final ListResults<tilda.data.DateDim_Data> readMany(Connection C, String FullSelectQuery, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       readMany(C, -77, RPI, null, FullSelectQuery, Start, Size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__DATEDIM Obj, Object ExtraParams, int Start, int Size) throws Exception
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
          S.append(" "); C.getFullColumnVar(S, "TILDA", "DateDim", "dt");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "epoch");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "dayName");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "dayOfWeek");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "dayOfMonth");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "dayOfQuarter");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "dayOfYear");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "weekOfMonth");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "weekOfYear");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "monthOfYear");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "monthName");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "monthNameShort");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "quarterOfYear");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "quarterName");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "year");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "mmyyyy");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "mmddyyyy");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "yyyymmdd");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "isWeekend");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "isBusinessDay");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "isHoliday");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "holidayName");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "created");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateDim", "deleted");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "DateDim");
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

       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.DateDim", Q, null);
       java.sql.PreparedStatement PS=null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          switch (LookupId)
           {
             case -77:
             case -7:
                break;
             case -666: break;
             default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot prepare statement.");
           }


          count = JDBCHelper.process(PS.executeQuery(), RP, Start, true, Size, true);
        }
       catch (java.sql.SQLException E)
        {
          C.handleCatch(E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param dt             The Date date
 @param epoch          The epoch date
*/
   static public tilda.data.DateDim_Data create(LocalDate dt, long epoch) throws Exception
     {
       tilda.data._Tilda.TILDA__DATEDIM Obj = new tilda.data.DateDim_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setDt            (dt            );
       Obj.setEpoch         (epoch         );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.DateDim_Data) Obj;
     }

   static public tilda.data.DateDim_Data create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       LocalDate        _dt             =                       ParseUtil.parseLocalDate("dt"            , true , Values.get("dt"            ), Errors );
       Long        _epoch          =                       ParseUtil.parseLong("epoch"         , true , Values.get("epoch"         ), Errors );
       String        _dayName        =                       ParseUtil.parseString("dayName"       , false, Values.get("dayName"       ), Errors );
       Integer        _dayOfWeek      =                       ParseUtil.parseInteger("dayOfWeek"     , false, Values.get("dayOfWeek"     ), Errors );
       Integer        _dayOfMonth     =                       ParseUtil.parseInteger("dayOfMonth"    , false, Values.get("dayOfMonth"    ), Errors );
       Integer        _dayOfQuarter   =                       ParseUtil.parseInteger("dayOfQuarter"  , false, Values.get("dayOfQuarter"  ), Errors );
       Integer        _dayOfYear      =                       ParseUtil.parseInteger("dayOfYear"     , false, Values.get("dayOfYear"     ), Errors );
       Integer        _weekOfMonth    =                       ParseUtil.parseInteger("weekOfMonth"   , false, Values.get("weekOfMonth"   ), Errors );
       Integer        _weekOfYear     =                       ParseUtil.parseInteger("weekOfYear"    , false, Values.get("weekOfYear"    ), Errors );
       Integer        _monthOfYear    =                       ParseUtil.parseInteger("monthOfYear"   , false, Values.get("monthOfYear"   ), Errors );
       String        _monthName      =                       ParseUtil.parseString("monthName"     , false, Values.get("monthName"     ), Errors );
       String        _monthNameShort =                       ParseUtil.parseString("monthNameShort", false, Values.get("monthNameShort"), Errors );
       Integer        _quarterOfYear  =                       ParseUtil.parseInteger("quarterOfYear" , false, Values.get("quarterOfYear" ), Errors );
       String        _quarterName    =                       ParseUtil.parseString("quarterName"   , false, Values.get("quarterName"   ), Errors );
       Integer        _year           =                       ParseUtil.parseInteger("year"          , false, Values.get("year"          ), Errors );
       String        _mmyyyy         =                       ParseUtil.parseString("mmyyyy"        , false, Values.get("mmyyyy"        ), Errors );
       String        _mmddyyyy       =                       ParseUtil.parseString("mmddyyyy"      , false, Values.get("mmddyyyy"      ), Errors );
       String        _yyyymmdd       =                       ParseUtil.parseString("yyyymmdd"      , false, Values.get("yyyymmdd"      ), Errors );
       Integer        _isWeekend      =                       ParseUtil.parseInteger("isWeekend"     , false, Values.get("isWeekend"     ), Errors );
       Integer        _isBusinessDay  =                       ParseUtil.parseInteger("isBusinessDay" , false, Values.get("isBusinessDay" ), Errors );
       Integer        _isHoliday      =                       ParseUtil.parseInteger("isHoliday"     , false, Values.get("isHoliday"     ), Errors );
       String        _holidayName    =                       ParseUtil.parseString("holidayName"   , false, Values.get("holidayName"   ), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.DateDim_Data Obj = tilda.data.DateDim_Factory.create(_dt, _epoch);

      if (_dayName       != null) Obj.setDayName       (_dayName       );
      if (_dayOfWeek     != null) Obj.setDayOfWeek     (_dayOfWeek     );
      if (_dayOfMonth    != null) Obj.setDayOfMonth    (_dayOfMonth    );
      if (_dayOfQuarter  != null) Obj.setDayOfQuarter  (_dayOfQuarter  );
      if (_dayOfYear     != null) Obj.setDayOfYear     (_dayOfYear     );
      if (_weekOfMonth   != null) Obj.setWeekOfMonth   (_weekOfMonth   );
      if (_weekOfYear    != null) Obj.setWeekOfYear    (_weekOfYear    );
      if (_monthOfYear   != null) Obj.setMonthOfYear   (_monthOfYear   );
      if (_monthName     != null) Obj.setMonthName     (_monthName     );
      if (_monthNameShort!= null) Obj.setMonthNameShort(_monthNameShort);
      if (_quarterOfYear != null) Obj.setQuarterOfYear (_quarterOfYear );
      if (_quarterName   != null) Obj.setQuarterName   (_quarterName   );
      if (_year          != null) Obj.setYear          (_year          );
      if (_mmyyyy        != null) Obj.setMmyyyy        (_mmyyyy        );
      if (_mmddyyyy      != null) Obj.setMmddyyyy      (_mmddyyyy      );
      if (_yyyymmdd      != null) Obj.setYyyymmdd      (_yyyymmdd      );
      if (_isWeekend     != null) Obj.setIsWeekend     (_isWeekend     );
      if (_isBusinessDay != null) Obj.setIsBusinessDay (_isBusinessDay );
      if (_isHoliday     != null) Obj.setIsHoliday     (_isHoliday     );
      if (_holidayName   != null) Obj.setHolidayName   (_holidayName   );

      return Obj;
     }
   public static int writeBatch(Connection C, List<tilda.data.DateDim_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__DATEDIM lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__DATEDIM) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__DATEDIM) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.DateDim_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__DATEDIM) d);

               if (((TILDA__DATEDIM) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.DateDim_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (((TILDA__DATEDIM) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.DateDim_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__DATEDIM) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.DateDim_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__DATEDIM) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.DateDim_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.DateDim_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'DateDim_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__1_0.handleFinally(PS, T0, TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

   static public tilda.data.DateDim_Data lookupByPrimaryKey(LocalDate dt) throws Exception
     {
       tilda.data._Tilda.TILDA__DATEDIM Obj = new tilda.data.DateDim_Data();
       Obj.initForLookup(0);

       Obj.setDt            (dt            ); Obj.__Saved_dt             = Obj._dt            ;

       return (tilda.data.DateDim_Data) Obj;
     }

   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.DateDim_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       readMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.DateDim_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


 }
