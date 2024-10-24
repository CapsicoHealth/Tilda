
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
public class TILDA__DATEDIM_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__DATEDIM_Factory.class.getName());

   protected TILDA__DATEDIM_Factory() { }

   public static final Class<TILDA__DATEDIM> DATA_CLASS= TILDA__DATEDIM.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("DateDim", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.DateDim", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "DateDim"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dt -> TILDA.DateDim."dt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The Date date</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dt of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.dt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatePrimitive                DT            = new Type_DatePrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "dt"            , 0/*0*/, "The Date date", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.epoch -> TILDA.DateDim."epoch"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>epoch of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The epoch date</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.epoch of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.epoch</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                EPOCH         = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "epoch"         , 1/*1*/, "The epoch date", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayName -> TILDA.DateDim."dayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dayName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Day name (i.e., Monday, Tuesday...) of the date</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dayName of type varchar(255)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.dayName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          DAYNAME       = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "dayName"       , 2/*2*/, 255, "Day name (i.e., Monday, Tuesday...) of the date", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfWeek -> TILDA.DateDim."dayOfWeek"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dayOfWeek of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 day of the week (Monday=1 to Sunday=7) of the date</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dayOfWeek of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.dayOfWeek</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         DAYOFWEEK     = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "dayOfWeek"     , 3/*3*/, "ISO 8601 day of the week (Monday=1 to Sunday=7) of the date", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfMonth -> TILDA.DateDim."dayOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dayOfMonth of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 day of the month (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dayOfMonth of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.dayOfMonth</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         DAYOFMONTH    = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "dayOfMonth"    , 4/*4*/, "ISO 8601 day of the month (starting with 1) of the date", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfQuarter -> TILDA.DateDim."dayOfQuarter"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dayOfQuarter of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 day of the quarter (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dayOfQuarter of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.dayOfQuarter</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         DAYOFQUARTER  = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "dayOfQuarter"  , 5/*5*/, "ISO 8601 day of the quarter (starting with 1) of the date", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfYear -> TILDA.DateDim."dayOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dayOfYear of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 day of the year (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.dayOfYear of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.dayOfYear</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         DAYOFYEAR     = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "dayOfYear"     , 6/*6*/, "ISO 8601 day of the year (starting with 1) of the date", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfMonth -> TILDA.DateDim."weekOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>weekOfMonth of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 week of the month (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.weekOfMonth of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.weekOfMonth</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         WEEKOFMONTH   = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "weekOfMonth"   , 7/*7*/, "ISO 8601 week of the month (starting with 1) of the date", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfYear -> TILDA.DateDim."weekOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>weekOfYear of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 week of the year (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.weekOfYear of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.weekOfYear</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         WEEKOFYEAR    = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "weekOfYear"    , 8/*8*/, "ISO 8601 week of the year (starting with 1) of the date", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.month -> TILDA.DateDim."month"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>month of type LocalDate</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Month-truncated date.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.month of type date</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.month</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatePrimitiveNull            MONTH         = new Type_DatePrimitiveNull           (SCHEMA_LABEL, TABLENAME_LABEL, "month"         , 9/*9*/, "Month-truncated date.", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthOfYear -> TILDA.DateDim."monthOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>monthOfYear of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 month of the year (starting with 1) of the date</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.monthOfYear of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.monthOfYear</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         MONTHOFYEAR   = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "monthOfYear"   , 10/*10*/, "ISO 8601 month of the year (starting with 1) of the date", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthName -> TILDA.DateDim."monthName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>monthName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Month name (i.e., January, February...) of the date.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.monthName of type varchar(255)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.monthName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          MONTHNAME     = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "monthName"     , 11/*11*/, 255, "Month name (i.e., January, February...) of the date.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthNameShort -> TILDA.DateDim."monthNameShort"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>monthNameShort of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Monday short name (i.e., Jan, Feb...) of the date.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.monthNameShort of type varchar(255)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.monthNameShort</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          MONTHNAMESHORT= new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "monthNameShort", 12/*12*/, 255, "Monday short name (i.e., Jan, Feb...) of the date.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterOfYear -> TILDA.DateDim."quarterOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>quarterOfYear of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 quarter of the year (starting with 1) of the date.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.quarterOfYear of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.quarterOfYear</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         QUARTEROFYEAR = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "quarterOfYear" , 13/*13*/, "ISO 8601 quarter of the year (starting with 1) of the date.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterName -> TILDA.DateDim."quarterName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>quarterName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Quarter name (i.e., Q1, Q2...) of the date.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.quarterName of type varchar(255)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.quarterName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          QUARTERNAME   = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "quarterName"   , 14/*14*/, 255, "Quarter name (i.e., Q1, Q2...) of the date.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.year -> TILDA.DateDim."year"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>year of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>ISO 8601 year (1.e., 2018) of the date.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.year of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.year</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         YEAR          = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "year"          , 15/*15*/, "ISO 8601 year (1.e., 2018) of the date.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmyyyy -> TILDA.DateDim."mmyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>mmyyyy of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The mmyyyy printable version of a date.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.mmyyyy of type character(6)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.mmyyyy</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>6</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          MMYYYY        = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "mmyyyy"        , 16/*16*/, 6, "The mmyyyy printable version of a date.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmddyyyy -> TILDA.DateDim."mmddyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>mmddyyyy of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The mmddyyyy printable version of a date.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.mmddyyyy of type character(8)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.mmddyyyy</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          MMDDYYYY      = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "mmddyyyy"      , 17/*17*/, 8, "The mmddyyyy printable version of a date.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.yyyymmdd -> TILDA.DateDim."yyyymmdd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>yyyymmdd of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The yyyymmdd sortable printable version of a date.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.yyyymmdd of type character(8)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.yyyymmdd</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          YYYYMMDD      = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "yyyymmdd"      , 18/*18*/, 8, "The yyyymmdd sortable printable version of a date.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isWeekend -> TILDA.DateDim."isWeekend"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>isWeekend of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>1 if this is a weekend day, 0 otherwise.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.isWeekend of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.isWeekend</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         ISWEEKEND     = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "isWeekend"     , 19/*19*/, "1 if this is a weekend day, 0 otherwise.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isBusinessDay -> TILDA.DateDim."isBusinessDay"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>isBusinessDay of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>1 if this is a business day, 0 otherwise.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.isBusinessDay of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.isBusinessDay</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         ISBUSINESSDAY = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "isBusinessDay" , 20/*20*/, "1 if this is a business day, 0 otherwise.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isHoliday -> TILDA.DateDim."isHoliday"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>isHoliday of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>1 if this is a holiday, 0 otherwise.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.isHoliday of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.isHoliday</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull         ISHOLIDAY     = new Type_IntegerPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "isHoliday"     , 21/*21*/, "1 if this is a holiday, 0 otherwise.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.holidayName -> TILDA.DateDim."holidayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>holidayName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the holiday if applicable.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.holidayName of type varchar(255)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.holidayName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          HOLIDAYNAME   = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "holidayName"   , 22/*22*/, 255, "The name of the holiday if applicable.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.created -> TILDA.DateDim."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.DateDim)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.created</TD></TR>

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
     public final Type_DatetimePrimitive            CREATED       = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "created"       , 23/*23*/, "The timestamp for when the record was created. (TILDA.DateDim)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.lastUpdated -> TILDA.DateDim."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.DateDim)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.lastUpdated</TD></TR>

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
     public final Type_DatetimePrimitive            LASTUPDATED   = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"   , 24/*24*/, "The timestamp for when the record was last updated. (TILDA.DateDim)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.DateDim)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateDim.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.DateDim.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull        DELETED       = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"       , 25/*25*/, "The timestamp for when the record was deleted. (TILDA.DateDim)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.DT,COLS.EPOCH,COLS.DAYNAME,COLS.DAYOFWEEK,COLS.DAYOFMONTH,COLS.DAYOFQUARTER,COLS.DAYOFYEAR,COLS.WEEKOFMONTH,COLS.WEEKOFYEAR,COLS.MONTH,COLS.MONTHOFYEAR,COLS.MONTHNAME,COLS.MONTHNAMESHORT,COLS.QUARTEROFYEAR,COLS.QUARTERNAME,COLS.YEAR,COLS.MMYYYY,COLS.MMDDYYYY,COLS.YYYYMMDD,COLS.ISWEEKEND,COLS.ISBUSINESSDAY,COLS.ISHOLIDAY,COLS.HOLIDAYNAME,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.DT };

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
           tilda.data.DateDim_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.DateDim_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.DateDim_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.DateDim_Data> _OP;
       protected ArrayListResults<tilda.data.DateDim_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.DateDim_Data Obj = new tilda.data.DateDim_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__DATEDIM)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.DateDim_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__DATEDIM Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__DATEDIM_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "DateDim");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "DateDim", "dt"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDA.DateDim", Q, null);
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.data.DateDim_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data._Tilda.TILDA__DATEDIM Obj = new tilda.data.DateDim_Data();
       String[] vals = null;

       vals = Values.get("dt");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       LocalDate _dt = ParseUtil.parseLocalDate("dt", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt != null) Obj.setDt(_dt);

       vals = Values.get("epoch");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("epoch", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _epoch = ParseUtil.parseLong("epoch", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_epoch != null) Obj.setEpoch(_epoch);

       vals = Values.get("dayName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dayName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _dayName = ParseUtil.parseString("dayName", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dayName != null) Obj.setDayName(_dayName);

       vals = Values.get("dayOfWeek");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dayOfWeek", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _dayOfWeek = ParseUtil.parseInteger("dayOfWeek", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dayOfWeek != null) Obj.setDayOfWeek(_dayOfWeek);

       vals = Values.get("dayOfMonth");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dayOfMonth", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _dayOfMonth = ParseUtil.parseInteger("dayOfMonth", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dayOfMonth != null) Obj.setDayOfMonth(_dayOfMonth);

       vals = Values.get("dayOfQuarter");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dayOfQuarter", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _dayOfQuarter = ParseUtil.parseInteger("dayOfQuarter", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dayOfQuarter != null) Obj.setDayOfQuarter(_dayOfQuarter);

       vals = Values.get("dayOfYear");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dayOfYear", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _dayOfYear = ParseUtil.parseInteger("dayOfYear", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dayOfYear != null) Obj.setDayOfYear(_dayOfYear);

       vals = Values.get("weekOfMonth");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("weekOfMonth", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _weekOfMonth = ParseUtil.parseInteger("weekOfMonth", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_weekOfMonth != null) Obj.setWeekOfMonth(_weekOfMonth);

       vals = Values.get("weekOfYear");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("weekOfYear", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _weekOfYear = ParseUtil.parseInteger("weekOfYear", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_weekOfYear != null) Obj.setWeekOfYear(_weekOfYear);

       vals = Values.get("month");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("month", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       LocalDate _month = ParseUtil.parseLocalDate("month", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_month != null) Obj.setMonth(_month);

       vals = Values.get("monthOfYear");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("monthOfYear", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _monthOfYear = ParseUtil.parseInteger("monthOfYear", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_monthOfYear != null) Obj.setMonthOfYear(_monthOfYear);

       vals = Values.get("monthName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("monthName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _monthName = ParseUtil.parseString("monthName", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_monthName != null) Obj.setMonthName(_monthName);

       vals = Values.get("monthNameShort");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("monthNameShort", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _monthNameShort = ParseUtil.parseString("monthNameShort", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_monthNameShort != null) Obj.setMonthNameShort(_monthNameShort);

       vals = Values.get("quarterOfYear");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("quarterOfYear", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _quarterOfYear = ParseUtil.parseInteger("quarterOfYear", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_quarterOfYear != null) Obj.setQuarterOfYear(_quarterOfYear);

       vals = Values.get("quarterName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("quarterName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _quarterName = ParseUtil.parseString("quarterName", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_quarterName != null) Obj.setQuarterName(_quarterName);

       vals = Values.get("year");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("year", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _year = ParseUtil.parseInteger("year", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_year != null) Obj.setYear(_year);

       vals = Values.get("mmyyyy");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("mmyyyy", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _mmyyyy = ParseUtil.parseString("mmyyyy", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_mmyyyy != null) Obj.setMmyyyy(_mmyyyy);

       vals = Values.get("mmddyyyy");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("mmddyyyy", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _mmddyyyy = ParseUtil.parseString("mmddyyyy", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_mmddyyyy != null) Obj.setMmddyyyy(_mmddyyyy);

       vals = Values.get("yyyymmdd");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("yyyymmdd", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _yyyymmdd = ParseUtil.parseString("yyyymmdd", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_yyyymmdd != null) Obj.setYyyymmdd(_yyyymmdd);

       vals = Values.get("isWeekend");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("isWeekend", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _isWeekend = ParseUtil.parseInteger("isWeekend", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_isWeekend != null) Obj.setIsWeekend(_isWeekend);

       vals = Values.get("isBusinessDay");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("isBusinessDay", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _isBusinessDay = ParseUtil.parseInteger("isBusinessDay", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_isBusinessDay != null) Obj.setIsBusinessDay(_isBusinessDay);

       vals = Values.get("isHoliday");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("isHoliday", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _isHoliday = ParseUtil.parseInteger("isHoliday", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_isHoliday != null) Obj.setIsHoliday(_isHoliday);

       vals = Values.get("holidayName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("holidayName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _holidayName = ParseUtil.parseString("holidayName", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_holidayName != null) Obj.setHolidayName(_holidayName);


       return (tilda.data.DateDim_Data) Obj;
     }

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

       // Default Nullables
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTH._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.YEAR._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask);
       Obj.__Nulls.or(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask);

       return (tilda.data.DateDim_Data) Obj;
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
               ++count;

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
           TILDA__2_5.handleFinally(PS, T0, TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: dt.
*/
   static public tilda.data.DateDim_Data lookupByPrimaryKey(LocalDate dt) throws Exception
     {
       tilda.data._Tilda.TILDA__DATEDIM Obj = new tilda.data.DateDim_Data();
       Obj.initForLookup(0);

       Obj.setDt            (dt            ); Obj.__Saved_dt             = Obj._dt            ;

       return (tilda.data.DateDim_Data) Obj;
     }

/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: dt asc
*/   static public ListResults<tilda.data.DateDim_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__DATEDIM Obj = new tilda.data.DateDim_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: dt asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.DateDim_Data> OP, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__DATEDIM Obj = new tilda.data.DateDim_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.DateDim_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.DateDim_Data> OP, int start, int size) throws Exception
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
      return "\"dt\",\"epoch\",\"dayName\",\"dayOfWeek\",\"dayOfMonth\",\"dayOfQuarter\",\"dayOfYear\",\"weekOfMonth\",\"weekOfYear\",\"month\",\"monthOfYear\",\"monthName\",\"monthNameShort\",\"quarterOfYear\",\"quarterName\",\"year\",\"mmyyyy\",\"mmddyyyy\",\"yyyymmdd\",\"isWeekend\",\"isBusinessDay\",\"isHoliday\",\"holidayName\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.DateDim_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.DateDim_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.DateDim_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__DATEDIM Obj = (tilda.data._Tilda.TILDA__DATEDIM) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDate(Obj.getDt()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getEpoch());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDayName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDayOfWeek());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDayOfMonth());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDayOfQuarter());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDayOfYear());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getWeekOfMonth());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getWeekOfYear());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDate(Obj.getMonth()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getMonthOfYear());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getMonthName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getMonthNameShort());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getQuarterOfYear());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getQuarterName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getYear());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getMmyyyy());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getMmddyyyy());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getYyyymmdd());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getIsWeekend());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getIsBusinessDay());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getIsHoliday());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getHolidayName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.DateDim_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data.DateDim_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data.DateDim_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.DateDim_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.DateDim_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__DATEDIM Obj = (tilda.data._Tilda.TILDA__DATEDIM) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "dt", ++i==0, Obj.getDt());

        JSONUtil.print(out, "epoch", ++i==0, Obj.getEpoch());

      if (Obj.isNullDayName() == false && Obj.getDayName() != null)
        JSONUtil.print(out, "dayName", ++i==0, Obj.getDayName());

      if (Obj.isNullDayOfWeek() == false)
        JSONUtil.print(out, "dayOfWeek", ++i==0, Obj.getDayOfWeek());

      if (Obj.isNullDayOfMonth() == false)
        JSONUtil.print(out, "dayOfMonth", ++i==0, Obj.getDayOfMonth());

      if (Obj.isNullDayOfQuarter() == false)
        JSONUtil.print(out, "dayOfQuarter", ++i==0, Obj.getDayOfQuarter());

      if (Obj.isNullDayOfYear() == false)
        JSONUtil.print(out, "dayOfYear", ++i==0, Obj.getDayOfYear());

      if (Obj.isNullWeekOfMonth() == false)
        JSONUtil.print(out, "weekOfMonth", ++i==0, Obj.getWeekOfMonth());

      if (Obj.isNullWeekOfYear() == false)
        JSONUtil.print(out, "weekOfYear", ++i==0, Obj.getWeekOfYear());

      if (Obj.isNullMonth() == false && Obj.getMonth() != null)
        JSONUtil.print(out, "month", ++i==0, Obj.getMonth());

      if (Obj.isNullMonthOfYear() == false)
        JSONUtil.print(out, "monthOfYear", ++i==0, Obj.getMonthOfYear());

      if (Obj.isNullMonthName() == false && Obj.getMonthName() != null)
        JSONUtil.print(out, "monthName", ++i==0, Obj.getMonthName());

      if (Obj.isNullMonthNameShort() == false && Obj.getMonthNameShort() != null)
        JSONUtil.print(out, "monthNameShort", ++i==0, Obj.getMonthNameShort());

      if (Obj.isNullQuarterOfYear() == false)
        JSONUtil.print(out, "quarterOfYear", ++i==0, Obj.getQuarterOfYear());

      if (Obj.isNullQuarterName() == false && Obj.getQuarterName() != null)
        JSONUtil.print(out, "quarterName", ++i==0, Obj.getQuarterName());

      if (Obj.isNullYear() == false)
        JSONUtil.print(out, "year", ++i==0, Obj.getYear());

      if (Obj.isNullMmyyyy() == false && Obj.getMmyyyy() != null)
        JSONUtil.print(out, "mmyyyy", ++i==0, Obj.getMmyyyy());

      if (Obj.isNullMmddyyyy() == false && Obj.getMmddyyyy() != null)
        JSONUtil.print(out, "mmddyyyy", ++i==0, Obj.getMmddyyyy());

      if (Obj.isNullYyyymmdd() == false && Obj.getYyyymmdd() != null)
        JSONUtil.print(out, "yyyymmdd", ++i==0, Obj.getYyyymmdd());

      if (Obj.isNullIsWeekend() == false)
        JSONUtil.print(out, "isWeekend", ++i==0, Obj.getIsWeekend());

      if (Obj.isNullIsBusinessDay() == false)
        JSONUtil.print(out, "isBusinessDay", ++i==0, Obj.getIsBusinessDay());

      if (Obj.isNullIsHoliday() == false)
        JSONUtil.print(out, "isHoliday", ++i==0, Obj.getIsHoliday());

      if (Obj.isNullHolidayName() == false && Obj.getHolidayName() != null)
        JSONUtil.print(out, "holidayName", ++i==0, Obj.getHolidayName());

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
