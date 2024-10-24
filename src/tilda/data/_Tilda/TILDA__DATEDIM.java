/*
 Tilda V2.5 data object.

 Code is generated: do not modify! Instead, create a derived class and override desired functionality
*/

package tilda.data._Tilda;

import java.time.*;
import java.sql.Timestamp;
import java.util.*;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import org.apache.logging.log4j.*;

import com.google.gson.*;
import com.google.gson.annotations.*;
import java.math.*;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
<TABLE id="DateDim_DIV" class="tables">
<SCRIPT>registerStickyHeader("DateDim_DIV");</SCRIPT>
<TR valign="top"><TD><H2>DateDim&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#DateDim_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="DateDim_CNT" class="content">
The Table TILDA.DateDim :<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>DateDim_Factory</B>, <B>DateDim_Data</B> in the package <B>tilda.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Has the following identity:<UL><LI>Primary Key: dt</LI>
</UL></LI>
</UL>
<B>Description</B>:<BLOCKQUOTE style="border-left: 1px solid #EEE;padding-left: 5px;">The Date dimension, capturing pre-calculated metrics on dates</BLOCKQUOTE>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="DateDim_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid #BBB;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">TZ</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-dt_DIV' class='columns'>dt</B>&nbsp;&nbsp;</TD>
<TD>LocalDate&nbsp;/&nbsp;date&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The Date date</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-epoch_DIV' class='columns'>epoch</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The epoch date</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-dayName_DIV' class='columns'>dayName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(255)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Day name (i.e., Monday, Tuesday...) of the date</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-dayOfWeek_DIV' class='columns'>dayOfWeek</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>ISO 8601 day of the week (Monday=1 to Sunday=7) of the date</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-dayOfMonth_DIV' class='columns'>dayOfMonth</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>ISO 8601 day of the month (starting with 1) of the date</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-dayOfQuarter_DIV' class='columns'>dayOfQuarter</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>ISO 8601 day of the quarter (starting with 1) of the date</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-dayOfYear_DIV' class='columns'>dayOfYear</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>ISO 8601 day of the year (starting with 1) of the date</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-weekOfMonth_DIV' class='columns'>weekOfMonth</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>ISO 8601 week of the month (starting with 1) of the date</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-weekOfYear_DIV' class='columns'>weekOfYear</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>ISO 8601 week of the year (starting with 1) of the date</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-month_DIV' class='columns'>month</B>&nbsp;&nbsp;</TD>
<TD>LocalDate&nbsp;/&nbsp;date&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Month-truncated date.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-monthOfYear_DIV' class='columns'>monthOfYear</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>ISO 8601 month of the year (starting with 1) of the date</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-monthName_DIV' class='columns'>monthName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(255)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Month name (i.e., January, February...) of the date.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-monthNameShort_DIV' class='columns'>monthNameShort</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(255)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Monday short name (i.e., Jan, Feb...) of the date.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-quarterOfYear_DIV' class='columns'>quarterOfYear</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>ISO 8601 quarter of the year (starting with 1) of the date.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-quarterName_DIV' class='columns'>quarterName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(255)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Quarter name (i.e., Q1, Q2...) of the date.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-year_DIV' class='columns'>year</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>ISO 8601 year (1.e., 2018) of the date.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-mmyyyy_DIV' class='columns'>mmyyyy</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(6)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The mmyyyy printable version of a date.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-mmddyyyy_DIV' class='columns'>mmddyyyy</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(8)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The mmddyyyy printable version of a date.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-yyyymmdd_DIV' class='columns'>yyyymmdd</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(8)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The yyyymmdd sortable printable version of a date.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>20&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-isWeekend_DIV' class='columns'>isWeekend</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>1 if this is a weekend day, 0 otherwise.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>21&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-isBusinessDay_DIV' class='columns'>isBusinessDay</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>1 if this is a business day, 0 otherwise.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>22&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-isHoliday_DIV' class='columns'>isHoliday</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>1 if this is a holiday, 0 otherwise.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>23&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-holidayName_DIV' class='columns'>holidayName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(255)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the holiday if applicable.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>24&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created. (TILDA.DateDim)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>25&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDA.DateDim)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>26&nbsp;&nbsp;</TD>
<TD align="right"><B id='DateDim-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted. (TILDA.DateDim)</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__DATEDIM implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__DATEDIM.class.getName());

   public transient static final Class<TILDA__DATEDIM_Factory> FACTORY_CLASS= TILDA__DATEDIM_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDA.DateDim", "");

   protected TILDA__DATEDIM() { }

   transient InitMode __Init        = null;
   transient BitSet   __Nulls       = new BitSet(64);
   transient BitSet   __Changes     = new BitSet(64);
   transient boolean  __NewlyCreated= false;
   transient int      __LookupId;

   public  boolean hasChanged    () { return __Changes.isEmpty() == false; }
   public  boolean isNewlyCreated() { return __NewlyCreated; }

   void initForCreate()
     {
       __Init         = InitMode.CREATE;
       __NewlyCreated = true ;
       __LookupId     = SystemValues.EVIL_VALUE;
     }
   void initForLookup(int LookupId)
     {
       __Init     = InitMode.LOOKUP;
       __LookupId = LookupId       ;
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dt -> TILDA.DateDim."dt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("dt")
   LocalDate _dt=null;
   protected LocalDate __Saved_dt;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dt -> TILDA.DateDim."dt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final LocalDate getDt()
      { return _dt; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dt -> TILDA.DateDim."dt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   protected void setDt(LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.dt to null: it's not nullable.");
       else if (v.equals(_dt) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.DateDim.dt' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DT._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DT._Mask);
       _dt = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field dt doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initDt(LocalDate v) throws Exception
     {
       setDt(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.epoch -> TILDA.DateDim."epoch"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("epoch")
   Long _epoch=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.epoch -> TILDA.DateDim."epoch"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final long getEpoch()
      { return _epoch==null?0l:_epoch; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.epoch -> TILDA.DateDim."epoch"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setEpoch(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _epoch == null || v != _epoch)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.EPOCH._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.EPOCH._Mask);
       _epoch = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.epoch -> TILDA.DateDim."epoch"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedEpoch()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.EPOCH._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayName -> TILDA.DateDim."dayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("dayName")
   String _dayName=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayName -> TILDA.DateDim."dayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final String getDayName()
      { return _dayName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayName -> TILDA.DateDim."dayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullDayName()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayName -> TILDA.DateDim."dayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setDayName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDayName();
        }
       else if (v.length() > 255)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.dayName: the size "+v.length()+" is larger than the max allowed of 255: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dayName) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask);
       _dayName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayName -> TILDA.DateDim."dayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullDayName()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask);
       _dayName=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayName -> TILDA.DateDim."dayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedDayName()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfWeek -> TILDA.DateDim."dayOfWeek"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("dayOfWeek")
   Integer _dayOfWeek=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfWeek -> TILDA.DateDim."dayOfWeek"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getDayOfWeek()
      { return _dayOfWeek==null?0:_dayOfWeek; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfWeek -> TILDA.DateDim."dayOfWeek"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullDayOfWeek()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfWeek -> TILDA.DateDim."dayOfWeek"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setDayOfWeek(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _dayOfWeek == null || v != _dayOfWeek)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask);
       _dayOfWeek = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfWeek -> TILDA.DateDim."dayOfWeek"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullDayOfWeek()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask);
       _dayOfWeek=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfWeek -> TILDA.DateDim."dayOfWeek"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedDayOfWeek()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfMonth -> TILDA.DateDim."dayOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("dayOfMonth")
   Integer _dayOfMonth=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfMonth -> TILDA.DateDim."dayOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getDayOfMonth()
      { return _dayOfMonth==null?0:_dayOfMonth; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfMonth -> TILDA.DateDim."dayOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullDayOfMonth()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfMonth -> TILDA.DateDim."dayOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setDayOfMonth(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _dayOfMonth == null || v != _dayOfMonth)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask);
       _dayOfMonth = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfMonth -> TILDA.DateDim."dayOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullDayOfMonth()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask);
       _dayOfMonth=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfMonth -> TILDA.DateDim."dayOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedDayOfMonth()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfQuarter -> TILDA.DateDim."dayOfQuarter"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("dayOfQuarter")
   Integer _dayOfQuarter=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfQuarter -> TILDA.DateDim."dayOfQuarter"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getDayOfQuarter()
      { return _dayOfQuarter==null?0:_dayOfQuarter; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfQuarter -> TILDA.DateDim."dayOfQuarter"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullDayOfQuarter()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfQuarter -> TILDA.DateDim."dayOfQuarter"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setDayOfQuarter(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _dayOfQuarter == null || v != _dayOfQuarter)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask);
       _dayOfQuarter = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfQuarter -> TILDA.DateDim."dayOfQuarter"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullDayOfQuarter()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask);
       _dayOfQuarter=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfQuarter -> TILDA.DateDim."dayOfQuarter"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedDayOfQuarter()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfYear -> TILDA.DateDim."dayOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("dayOfYear")
   Integer _dayOfYear=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfYear -> TILDA.DateDim."dayOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getDayOfYear()
      { return _dayOfYear==null?0:_dayOfYear; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfYear -> TILDA.DateDim."dayOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullDayOfYear()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfYear -> TILDA.DateDim."dayOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setDayOfYear(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _dayOfYear == null || v != _dayOfYear)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask);
       _dayOfYear = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfYear -> TILDA.DateDim."dayOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullDayOfYear()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask);
       _dayOfYear=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.dayOfYear -> TILDA.DateDim."dayOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedDayOfYear()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfMonth -> TILDA.DateDim."weekOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("weekOfMonth")
   Integer _weekOfMonth=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfMonth -> TILDA.DateDim."weekOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getWeekOfMonth()
      { return _weekOfMonth==null?0:_weekOfMonth; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfMonth -> TILDA.DateDim."weekOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullWeekOfMonth()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfMonth -> TILDA.DateDim."weekOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setWeekOfMonth(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _weekOfMonth == null || v != _weekOfMonth)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask);
       _weekOfMonth = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfMonth -> TILDA.DateDim."weekOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullWeekOfMonth()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask);
       _weekOfMonth=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfMonth -> TILDA.DateDim."weekOfMonth"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedWeekOfMonth()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfYear -> TILDA.DateDim."weekOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("weekOfYear")
   Integer _weekOfYear=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfYear -> TILDA.DateDim."weekOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getWeekOfYear()
      { return _weekOfYear==null?0:_weekOfYear; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfYear -> TILDA.DateDim."weekOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullWeekOfYear()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfYear -> TILDA.DateDim."weekOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setWeekOfYear(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _weekOfYear == null || v != _weekOfYear)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask);
       _weekOfYear = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfYear -> TILDA.DateDim."weekOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullWeekOfYear()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask);
       _weekOfYear=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.weekOfYear -> TILDA.DateDim."weekOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedWeekOfYear()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.month -> TILDA.DateDim."month"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("month")
   LocalDate _month=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.month -> TILDA.DateDim."month"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final LocalDate getMonth()
      { return _month; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.month -> TILDA.DateDim."month"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullMonth()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.month -> TILDA.DateDim."month"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setMonth(LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullMonth();
        }
       else if (v.equals(_month) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTH._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MONTH._Mask);
       _month = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.month -> TILDA.DateDim."month"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullMonth()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTH._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTH._Mask);
       _month=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.month -> TILDA.DateDim."month"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedMonth()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthOfYear -> TILDA.DateDim."monthOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("monthOfYear")
   Integer _monthOfYear=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthOfYear -> TILDA.DateDim."monthOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getMonthOfYear()
      { return _monthOfYear==null?0:_monthOfYear; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthOfYear -> TILDA.DateDim."monthOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullMonthOfYear()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthOfYear -> TILDA.DateDim."monthOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setMonthOfYear(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _monthOfYear == null || v != _monthOfYear)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask);
       _monthOfYear = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthOfYear -> TILDA.DateDim."monthOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullMonthOfYear()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask);
       _monthOfYear=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthOfYear -> TILDA.DateDim."monthOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedMonthOfYear()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthName -> TILDA.DateDim."monthName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("monthName")
   String _monthName=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthName -> TILDA.DateDim."monthName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final String getMonthName()
      { return _monthName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthName -> TILDA.DateDim."monthName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullMonthName()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthName -> TILDA.DateDim."monthName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setMonthName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullMonthName();
        }
       else if (v.length() > 255)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.monthName: the size "+v.length()+" is larger than the max allowed of 255: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_monthName) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask);
       _monthName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthName -> TILDA.DateDim."monthName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullMonthName()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask);
       _monthName=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthName -> TILDA.DateDim."monthName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedMonthName()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthNameShort -> TILDA.DateDim."monthNameShort"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("monthNameShort")
   String _monthNameShort=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthNameShort -> TILDA.DateDim."monthNameShort"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final String getMonthNameShort()
      { return _monthNameShort; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthNameShort -> TILDA.DateDim."monthNameShort"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullMonthNameShort()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthNameShort -> TILDA.DateDim."monthNameShort"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setMonthNameShort(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullMonthNameShort();
        }
       else if (v.length() > 255)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.monthNameShort: the size "+v.length()+" is larger than the max allowed of 255: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_monthNameShort) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask);
       _monthNameShort = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthNameShort -> TILDA.DateDim."monthNameShort"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullMonthNameShort()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask);
       _monthNameShort=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.monthNameShort -> TILDA.DateDim."monthNameShort"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedMonthNameShort()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterOfYear -> TILDA.DateDim."quarterOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("quarterOfYear")
   Integer _quarterOfYear=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterOfYear -> TILDA.DateDim."quarterOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getQuarterOfYear()
      { return _quarterOfYear==null?0:_quarterOfYear; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterOfYear -> TILDA.DateDim."quarterOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullQuarterOfYear()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterOfYear -> TILDA.DateDim."quarterOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setQuarterOfYear(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _quarterOfYear == null || v != _quarterOfYear)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask);
       _quarterOfYear = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterOfYear -> TILDA.DateDim."quarterOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullQuarterOfYear()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask);
       _quarterOfYear=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterOfYear -> TILDA.DateDim."quarterOfYear"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedQuarterOfYear()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterName -> TILDA.DateDim."quarterName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("quarterName")
   String _quarterName=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterName -> TILDA.DateDim."quarterName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final String getQuarterName()
      { return _quarterName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterName -> TILDA.DateDim."quarterName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullQuarterName()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterName -> TILDA.DateDim."quarterName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setQuarterName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullQuarterName();
        }
       else if (v.length() > 255)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.quarterName: the size "+v.length()+" is larger than the max allowed of 255: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_quarterName) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask);
       _quarterName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterName -> TILDA.DateDim."quarterName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullQuarterName()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask);
       _quarterName=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.quarterName -> TILDA.DateDim."quarterName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedQuarterName()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.year -> TILDA.DateDim."year"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("year")
   Integer _year=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.year -> TILDA.DateDim."year"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getYear()
      { return _year==null?0:_year; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.year -> TILDA.DateDim."year"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullYear()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.YEAR._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.year -> TILDA.DateDim."year"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setYear(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _year == null || v != _year)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.YEAR._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.YEAR._Mask);
       _year = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.year -> TILDA.DateDim."year"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullYear()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.YEAR._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.YEAR._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.YEAR._Mask);
       _year=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.year -> TILDA.DateDim."year"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedYear()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.YEAR._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmyyyy -> TILDA.DateDim."mmyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("mmyyyy")
   String _mmyyyy=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmyyyy -> TILDA.DateDim."mmyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final String getMmyyyy()
      { return _mmyyyy; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmyyyy -> TILDA.DateDim."mmyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullMmyyyy()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmyyyy -> TILDA.DateDim."mmyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setMmyyyy(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullMmyyyy();
        }
       else if (v.length() > 6)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.mmyyyy: the size "+v.length()+" is larger than the max allowed of 6: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_mmyyyy) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask);
       _mmyyyy = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmyyyy -> TILDA.DateDim."mmyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullMmyyyy()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask);
       _mmyyyy=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmyyyy -> TILDA.DateDim."mmyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedMmyyyy()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmddyyyy -> TILDA.DateDim."mmddyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("mmddyyyy")
   String _mmddyyyy=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmddyyyy -> TILDA.DateDim."mmddyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final String getMmddyyyy()
      { return _mmddyyyy; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmddyyyy -> TILDA.DateDim."mmddyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullMmddyyyy()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmddyyyy -> TILDA.DateDim."mmddyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setMmddyyyy(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullMmddyyyy();
        }
       else if (v.length() > 8)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.mmddyyyy: the size "+v.length()+" is larger than the max allowed of 8: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_mmddyyyy) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask);
       _mmddyyyy = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmddyyyy -> TILDA.DateDim."mmddyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullMmddyyyy()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask);
       _mmddyyyy=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.mmddyyyy -> TILDA.DateDim."mmddyyyy"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedMmddyyyy()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.yyyymmdd -> TILDA.DateDim."yyyymmdd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("yyyymmdd")
   String _yyyymmdd=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.yyyymmdd -> TILDA.DateDim."yyyymmdd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final String getYyyymmdd()
      { return _yyyymmdd; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.yyyymmdd -> TILDA.DateDim."yyyymmdd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullYyyymmdd()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.yyyymmdd -> TILDA.DateDim."yyyymmdd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setYyyymmdd(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullYyyymmdd();
        }
       else if (v.length() > 8)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.yyyymmdd: the size "+v.length()+" is larger than the max allowed of 8: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_yyyymmdd) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask);
       _yyyymmdd = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.yyyymmdd -> TILDA.DateDim."yyyymmdd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullYyyymmdd()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask);
       _yyyymmdd=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.yyyymmdd -> TILDA.DateDim."yyyymmdd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedYyyymmdd()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isWeekend -> TILDA.DateDim."isWeekend"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("isWeekend")
   Integer _isWeekend=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isWeekend -> TILDA.DateDim."isWeekend"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getIsWeekend()
      { return _isWeekend==null?0:_isWeekend; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isWeekend -> TILDA.DateDim."isWeekend"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullIsWeekend()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isWeekend -> TILDA.DateDim."isWeekend"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setIsWeekend(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _isWeekend == null || v != _isWeekend)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask);
       _isWeekend = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isWeekend -> TILDA.DateDim."isWeekend"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullIsWeekend()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask);
       _isWeekend=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isWeekend -> TILDA.DateDim."isWeekend"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedIsWeekend()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isBusinessDay -> TILDA.DateDim."isBusinessDay"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("isBusinessDay")
   Integer _isBusinessDay=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isBusinessDay -> TILDA.DateDim."isBusinessDay"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getIsBusinessDay()
      { return _isBusinessDay==null?0:_isBusinessDay; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isBusinessDay -> TILDA.DateDim."isBusinessDay"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullIsBusinessDay()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isBusinessDay -> TILDA.DateDim."isBusinessDay"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setIsBusinessDay(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _isBusinessDay == null || v != _isBusinessDay)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask);
       _isBusinessDay = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isBusinessDay -> TILDA.DateDim."isBusinessDay"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullIsBusinessDay()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask);
       _isBusinessDay=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isBusinessDay -> TILDA.DateDim."isBusinessDay"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedIsBusinessDay()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isHoliday -> TILDA.DateDim."isHoliday"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("isHoliday")
   Integer _isHoliday=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isHoliday -> TILDA.DateDim."isHoliday"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final int getIsHoliday()
      { return _isHoliday==null?0:_isHoliday; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isHoliday -> TILDA.DateDim."isHoliday"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullIsHoliday()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isHoliday -> TILDA.DateDim."isHoliday"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setIsHoliday(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _isHoliday == null || v != _isHoliday)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask);
       _isHoliday = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isHoliday -> TILDA.DateDim."isHoliday"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullIsHoliday()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask);
       _isHoliday=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.isHoliday -> TILDA.DateDim."isHoliday"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedIsHoliday()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.holidayName -> TILDA.DateDim."holidayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   @SerializedName("holidayName")
   String _holidayName=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.holidayName -> TILDA.DateDim."holidayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final String getHolidayName()
      { return _holidayName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.holidayName -> TILDA.DateDim."holidayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullHolidayName()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.holidayName -> TILDA.DateDim."holidayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public void setHolidayName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullHolidayName();
        }
       else if (v.length() > 255)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.holidayName: the size "+v.length()+" is larger than the max allowed of 255: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_holidayName) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask);
       _holidayName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.holidayName -> TILDA.DateDim."holidayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public void setNullHolidayName()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask);
       _holidayName=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.holidayName -> TILDA.DateDim."holidayName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedHolidayName()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.created -> TILDA.DateDim."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   transient ZonedDateTime _created = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.created -> TILDA.DateDim."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final ZonedDateTime getCreated()
      { return _created; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.created -> TILDA.DateDim."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   protected void setCreated(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.DateDim.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__DATEDIM_Factory.COLS.CREATED._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.CREATED._Mask);
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.created -> TILDA.DateDim."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
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
   protected final void setCreatedNow() throws Exception
    {
      setCreated(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.created -> TILDA.DateDim."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
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
   protected final void setCreatedUndefined() throws Exception
    {
      setCreated(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.created -> TILDA.DateDim."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
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
   protected final void setCreated(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setCreated(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.created -> TILDA.DateDim."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedCreated()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.CREATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.lastUpdated -> TILDA.DateDim."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   transient ZonedDateTime _lastUpdated = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.lastUpdated -> TILDA.DateDim."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final ZonedDateTime getLastUpdated()
      { return _lastUpdated; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.lastUpdated -> TILDA.DateDim."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public final void setLastUpdated(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.DateDim.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.lastUpdated -> TILDA.DateDim."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
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
   public final void setLastUpdatedNow() throws Exception
    {
      setLastUpdated(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.lastUpdated -> TILDA.DateDim."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
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
   public final void setLastUpdatedUndefined() throws Exception
    {
      setLastUpdated(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.lastUpdated -> TILDA.DateDim."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
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
   public final void setLastUpdated(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setLastUpdated(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.lastUpdated -> TILDA.DateDim."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedLastUpdated()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
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
   transient ZonedDateTime _deleted = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
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
   public final ZonedDateTime getDeleted()
      { return _deleted; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
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
   public final boolean isNullDeleted()
     { return __Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
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
   public final void setDeleted(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDeleted();
        }
       else if (v.equals(_deleted) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DELETED._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DELETED._Mask);
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
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
   public final void setNullDeleted()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__DATEDIM_Factory.COLS.DELETED._Mask);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__DATEDIM_Factory.COLS.DELETED._Mask);
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
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
   public final void setDeletedNow() throws Exception
    {
      setDeleted(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
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
   public final void setDeletedUndefined() throws Exception
    {
      setDeleted(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
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
   public final void setDeleted(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDeleted(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateDim.deleted -> TILDA.DateDim."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
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
   public boolean hasChangedDeleted()
     { return __Changes.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.data._Tilda.TILDA__DATEDIM Dst) throws Exception
     {
       if (_epoch          != null)
        Dst.setEpoch         (_epoch         );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask) == true || _dayName       ==null)
        Dst.setNullDayName       ();
       else
        Dst.setDayName       (_dayName       );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask) == true || _dayOfWeek     ==null)
        Dst.setNullDayOfWeek     ();
       else
        Dst.setDayOfWeek     (_dayOfWeek     );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask) == true || _dayOfMonth    ==null)
        Dst.setNullDayOfMonth    ();
       else
        Dst.setDayOfMonth    (_dayOfMonth    );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask) == true || _dayOfQuarter  ==null)
        Dst.setNullDayOfQuarter  ();
       else
        Dst.setDayOfQuarter  (_dayOfQuarter  );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask) == true || _dayOfYear     ==null)
        Dst.setNullDayOfYear     ();
       else
        Dst.setDayOfYear     (_dayOfYear     );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask) == true || _weekOfMonth   ==null)
        Dst.setNullWeekOfMonth   ();
       else
        Dst.setWeekOfMonth   (_weekOfMonth   );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask) == true || _weekOfYear    ==null)
        Dst.setNullWeekOfYear    ();
       else
        Dst.setWeekOfYear    (_weekOfYear    );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask) == true || _month         ==null)
        Dst.setNullMonth         ();
       else
        Dst.setMonth         (_month         );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask) == true || _monthOfYear   ==null)
        Dst.setNullMonthOfYear   ();
       else
        Dst.setMonthOfYear   (_monthOfYear   );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask) == true || _monthName     ==null)
        Dst.setNullMonthName     ();
       else
        Dst.setMonthName     (_monthName     );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask) == true || _monthNameShort==null)
        Dst.setNullMonthNameShort();
       else
        Dst.setMonthNameShort(_monthNameShort);
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask) == true || _quarterOfYear ==null)
        Dst.setNullQuarterOfYear ();
       else
        Dst.setQuarterOfYear (_quarterOfYear );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask) == true || _quarterName   ==null)
        Dst.setNullQuarterName   ();
       else
        Dst.setQuarterName   (_quarterName   );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.YEAR._Mask) == true || _year          ==null)
        Dst.setNullYear          ();
       else
        Dst.setYear          (_year          );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask) == true || _mmyyyy        ==null)
        Dst.setNullMmyyyy        ();
       else
        Dst.setMmyyyy        (_mmyyyy        );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask) == true || _mmddyyyy      ==null)
        Dst.setNullMmddyyyy      ();
       else
        Dst.setMmddyyyy      (_mmddyyyy      );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask) == true || _yyyymmdd      ==null)
        Dst.setNullYyyymmdd      ();
       else
        Dst.setYyyymmdd      (_yyyymmdd      );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask) == true || _isWeekend     ==null)
        Dst.setNullIsWeekend     ();
       else
        Dst.setIsWeekend     (_isWeekend     );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask) == true || _isBusinessDay ==null)
        Dst.setNullIsBusinessDay ();
       else
        Dst.setIsBusinessDay (_isBusinessDay );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask) == true || _isHoliday     ==null)
        Dst.setNullIsHoliday     ();
       else
        Dst.setIsHoliday     (_isHoliday     );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask) == true || _holidayName   ==null)
        Dst.setNullHolidayName   ();
       else
        Dst.setHolidayName   (_holidayName   );
       if (__Init == InitMode.CREATE && _created        != null)
        Dst.setCreated       (_created       );
       if (_lastUpdated    != null)
        Dst.setLastUpdated   (_lastUpdated   );
       if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask) == true || _deleted       ==null)
        Dst.setNullDeleted       ();
       else
        Dst.setDeleted       (_deleted       );
     }


   public tilda.data.DateDim_Data copy() throws Exception
     {
       tilda.data.DateDim_Data dst = new tilda.data.DateDim_Data();
       copyTo(dst);
       return dst;
     }

/**
 Sets the 'lastUpdated' column to now and causes a Write to occur to update the object in the data store.
*/
   public final boolean touch(Connection C) throws Exception
     {
       setLastUpdatedNow();
       return write(C);
     }

/**
 Writes the object to the data store if any changes has occurred since the object was initially
 read from the data store or last written. 
 If the object was deserialized (i.e., not created via the factory lookup() or create() methods, 
 then this method assumes a create() and will check that all non-null columns have been provided. If you 
 need more flexibility for an upsert, use the upsert(Connection, boolean) version of write 
 which will try a combination of insert/update to get the object to the DB. 
 Note that if you use write() right after a create, lookup or deserialization initialization, only the
 template fields (not null, natural identity and/or any field set prior to calling this method) exist 
  in memory. Call refresh() to force a select and retrieve all the fields for that record.
*/
   public final boolean write(Connection C) throws Exception
     {
       long T0 = System.nanoTime();

       if (__Init == null && __LookupId==0) // Loaded via some other mechamism, e.g., Json or CSV loader
        {
          validateDeserialization();
          initForCreate();
        }

       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.DateDim has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }


       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.DateDim object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
          return false;
        }

       String Q = getWriteQuery(C);

       java.sql.PreparedStatement PS = null;
       int count = 0;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       try
        {
          PS = C.prepareStatement(Q);
          int i = populatePreparedStatement(C, PS, AllocatedArrays);

          switch (__LookupId)
           {
             case 0: // PK
               PS.setDate(++i, new java.sql.Date(_dt.getYear()-1900, _dt.getMonthValue()-1, _dt.getDayOfMonth()));
               break;
             case -666: if (__Init == InitMode.CREATE) break;
             default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
           }

          C.setSavepoint();
          count = PS.executeUpdate();
          C.releaseSavepoint(true);
          if (count == 0)
           return false;
        }
       catch (java.sql.SQLException E)
        {
          C.releaseSavepoint(false);
          return C.handleCatch(E, "updated or inserted");
        }
       finally
        {
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (_dt == null)
        throw new Exception("Incoming value for 'tilda.data.TILDA.DateDim.dt' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DT._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DT._Mask);

       if (_epoch == null)
        throw new Exception("Incoming value for 'tilda.data.TILDA.DateDim.epoch' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__DATEDIM_Factory.COLS.EPOCH._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.EPOCH._Mask);

       if (TextUtil.isNullOrEmpty(_dayName) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask);
        }

       if (_dayOfWeek != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask);
        }

       if (_dayOfMonth != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask);
        }

       if (_dayOfQuarter != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask);
        }

       if (_dayOfYear != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask);
        }

       if (_weekOfMonth != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask);
        }

       if (_weekOfYear != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask);
        }

       if (_month != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTH._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MONTH._Mask);
        }

       if (_monthOfYear != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask);
        }

       if (TextUtil.isNullOrEmpty(_monthName) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask);
        }

       if (TextUtil.isNullOrEmpty(_monthNameShort) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask);
        }

       if (_quarterOfYear != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask);
        }

       if (TextUtil.isNullOrEmpty(_quarterName) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask);
        }

       if (_year != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.YEAR._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.YEAR._Mask);
        }

       if (TextUtil.isNullOrEmpty(_mmyyyy) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask);
        }

       if (TextUtil.isNullOrEmpty(_mmddyyyy) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask);
        }

       if (TextUtil.isNullOrEmpty(_yyyymmdd) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask);
        }

       if (_isWeekend != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask);
        }

       if (_isBusinessDay != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask);
        }

       if (_isHoliday != null)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask);
        }

       if (TextUtil.isNullOrEmpty(_holidayName) == false)
        {
          __Changes.or(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask);
          __Nulls.andNot(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask);
        }
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.CREATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_created) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_deleted) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "DateDim");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DT._Mask) == true) { TILDA__DATEDIM_Factory.COLS.DT.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DT._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt) == true ? C.getCommaCurrentDateTime() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.EPOCH._Mask) == true) { TILDA__DATEDIM_Factory.COLS.EPOCH.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask) == true) { TILDA__DATEDIM_Factory.COLS.DAYNAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask) == true) { TILDA__DATEDIM_Factory.COLS.DAYOFWEEK.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask) == true) { TILDA__DATEDIM_Factory.COLS.DAYOFMONTH.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask) == true) { TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask) == true) { TILDA__DATEDIM_Factory.COLS.DAYOFYEAR.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask) == true) { TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask) == true) { TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask) == true) { TILDA__DATEDIM_Factory.COLS.MONTH.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask) == false && DateTimeUtil.isNowPlaceholder(_month) == true ? C.getCommaCurrentDateTime() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask) == true) { TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask) == true) { TILDA__DATEDIM_Factory.COLS.MONTHNAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask) == true) { TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask) == true) { TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask) == true) { TILDA__DATEDIM_Factory.COLS.QUARTERNAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.YEAR._Mask) == true) { TILDA__DATEDIM_Factory.COLS.YEAR.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask) == true) { TILDA__DATEDIM_Factory.COLS.MMYYYY.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask) == true) { TILDA__DATEDIM_Factory.COLS.MMDDYYYY.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask) == true) { TILDA__DATEDIM_Factory.COLS.YYYYMMDD.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask) == true) { TILDA__DATEDIM_Factory.COLS.ISWEEKEND.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask) == true) { TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask) == true) { TILDA__DATEDIM_Factory.COLS.ISHOLIDAY.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask) == true) { TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.CREATED._Mask) == true) { TILDA__DATEDIM_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__DATEDIM_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__DATEDIM_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__DATEDIM_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask) == true) { TILDA__DATEDIM_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDA", "DateDim"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DT._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DT._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt) == true)
              { TILDA__DATEDIM_Factory.COLS.DT.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentDateTime()); }
             else
              TILDA__DATEDIM_Factory.COLS.DT.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.EPOCH._Mask) == true) TILDA__DATEDIM_Factory.COLS.EPOCH.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask) == true) TILDA__DATEDIM_Factory.COLS.DAYNAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask) == true) TILDA__DATEDIM_Factory.COLS.DAYOFWEEK.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask) == true) TILDA__DATEDIM_Factory.COLS.DAYOFMONTH.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask) == true) TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask) == true) TILDA__DATEDIM_Factory.COLS.DAYOFYEAR.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask) == true) TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask) == true) TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask) == false && DateTimeUtil.isNowPlaceholder(_month) == true)
              { TILDA__DATEDIM_Factory.COLS.MONTH.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentDateTime()); }
             else
              TILDA__DATEDIM_Factory.COLS.MONTH.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask) == true) TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask) == true) TILDA__DATEDIM_Factory.COLS.MONTHNAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask) == true) TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask) == true) TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask) == true) TILDA__DATEDIM_Factory.COLS.QUARTERNAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.YEAR._Mask) == true) TILDA__DATEDIM_Factory.COLS.YEAR.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask) == true) TILDA__DATEDIM_Factory.COLS.MMYYYY.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask) == true) TILDA__DATEDIM_Factory.COLS.MMDDYYYY.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask) == true) TILDA__DATEDIM_Factory.COLS.YYYYMMDD.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask) == true) TILDA__DATEDIM_Factory.COLS.ISWEEKEND.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask) == true) TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask) == true) TILDA__DATEDIM_Factory.COLS.ISHOLIDAY.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask) == true) TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.CREATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__DATEDIM_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__DATEDIM_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__DATEDIM_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__DATEDIM_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__DATEDIM_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__DATEDIM_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__DATEDIM_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0: // PK
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "DateDim", "dt"); S.append("=?");  S.append(")");
                break;
             case -77: 
             case -666: if (__Init == InitMode.CREATE) break;
             default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
           }
          S.setCharAt(Pos, ' ');
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.DateDim", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DT._Mask) == true) PS.setNull(++i, java.sql.Types.DATE); else if (DateTimeUtil.isNowPlaceholder(_dt) == false)  PS.setDate(++i, java.sql.Date.valueOf(_dt));
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.EPOCH._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.EPOCH._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _epoch);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _dayName);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _dayOfWeek);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _dayOfMonth);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _dayOfQuarter);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _dayOfYear);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _weekOfMonth);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _weekOfYear);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask) == true) PS.setNull(++i, java.sql.Types.DATE); else if (DateTimeUtil.isNowPlaceholder(_month) == false)  PS.setDate(++i, java.sql.Date.valueOf(_month));
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _monthOfYear);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _monthName);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _monthNameShort);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _quarterOfYear);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _quarterName);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.YEAR._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.YEAR._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _year);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _mmyyyy);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _mmddyyyy);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _yyyymmdd);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _isWeekend);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _isBusinessDay);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _isHoliday);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _holidayName);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.CREATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_created.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_lastUpdated.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_deleted.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       return i;
     }
   protected void stateUpdatePostWrite() throws Exception
     {
       if (__Init == InitMode.CREATE)
        {
          __Init = InitMode.WRITTEN;
          __LookupId = 0;
        }
       else
        {
          __Init = __Init == InitMode.READ ? InitMode.READ_WRITTEN : InitMode.WRITTEN;
        }

       switch (__LookupId)
        {
          case 0:
             __Saved_dt             = _dt            ;
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
        }

       __Changes.clear();
     }
/**
 Writes the object to the data store using an upsert approach and assumes the object is either
 in create or deserialized mode. 
 The parameter createFirst controls whether the logic should do an insert first and if it fails, then do 
 an update, or the opposite (update first and if it fails, then an insert). This is necessary for databases
 without a robust upsert SQL syntax where separate insert/update statements must be issued.
 The method will figure out based on the fields set which natural identity (a unique index) is applicable for
 the lookup operation.
 Note that when you use upsert() (right after a create or deserialization initialization), only the template
 fields (not null, natural identity and/or any field set prior to calling this method) exist in memory. Call
 refresh() to force a select and retrieve all the fields for that record.
*/
   public final boolean upsert(Connection C, boolean updateFirst) throws Exception
     {
       boolean OK =    __Init == InitMode.CREATE && __NewlyCreated == true && __LookupId == SystemValues.EVIL_VALUE // Create() through factory
                    || __Init == null && __LookupId==0 // Loaded via some deserialization mechamism, e.g., Json or CSV loader
               ;
       if (OK == false)
        throw new Exception("Object has not been instanciated via deserialization or the factory create() method: __Init:"+__Init+"; __NewlyCreated:"+__NewlyCreated+"; __LookupId: "+__LookupId+";");

       if (__Init == null && __LookupId==0)  // object deserialized
        validateDeserialization();

       int lookupId = getFirstValidLookupBy();
       if (lookupId == SystemValues.EVIL_VALUE)
        throw new Exception("Object has not been intialized with sufficient data for any natural key to be available for a lookup.");

       if (updateFirst == true)
        {
          initForLookup(lookupId);
          if (write(C) == false)
           {
             initForCreate();
             return write(C);
           }
        }
       else
        {
          initForCreate();
          if (write(C) == false)
           {
             initForLookup(lookupId);
             return write(C);
           }
        }

       return true;
     }

   /**
   * Returns the first satisfied natural identify (i.e., unique indices), or if defined, the PK. by 'satisfied',
   * we mean an identity whose columns have all been provided (i.e., not null). We prioritize natural identities
   * over the PK since PKs are typically not stable across systems. For example, one might model a user with a PK
   * but also an identify over an email address for example. That email address for a given logical user should be
   * constant across multiple environments (e.g., a dev, staging or prod), where as a PK might be generated based
   * on dynamic factors that are very likely to be different across systems.
   */
   protected int getFirstValidLookupBy() throws Exception
     {

       // Testing if primary key has been set - Id: 0
       if (_dt != null)
        return 0;

       return SystemValues.EVIL_VALUE;
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   public final boolean refresh(Connection C) throws Exception
     {
       return readOne(C, true);
     }

   public final boolean read(Connection C) throws Exception
     {
       return readOne(C, false);
     }

   private final boolean readOne(Connection C, boolean Force) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE)
        throw new Exception("This TILDA.DateDim object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.DateDim object has already been read.");
          QueryDetails.setLastQuery(TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__DATEDIM_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "DateDim");
       switch (__LookupId)
        {
          case 0: // PK
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "DateDim", "dt"); S.append("=?");  S.append(")");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.DateDim", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       int count = 0;

       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
          switch (__LookupId)
           {
             case 0: // PK
               PS.setDate(++i, new java.sql.Date(_dt.getYear()-1900, _dt.getMonthValue()-1, _dt.getDayOfMonth()));
               break;
             case -666: if (__Init == InitMode.CREATE) break;
             default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
           }


          RS = PS.executeQuery();
          if (RS.next() == false)
            {
              LOG.debug(QueryDetails._LOGGING_HEADER + "   No record was read.");
              return false;
            }
          count = 1;
          return init(C, RS);
        }
       catch (java.sql.SQLException E)
        {
          return C.handleCatch(E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__DATEDIM_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_dt             = _dt             = DateTimeUtil.toLocalDate(RS.getDate(++i)); if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.DT._Mask            ); _dt = null; }
                               _epoch          =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.EPOCH._Mask         ); _epoch = null; }
                               _dayName        = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask       ); _dayName = null; }
                               _dayOfWeek      =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask     ); _dayOfWeek = null; }
                               _dayOfMonth     =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask    ); _dayOfMonth = null; }
                               _dayOfQuarter   =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask  ); _dayOfQuarter = null; }
                               _dayOfYear      =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask     ); _dayOfYear = null; }
                               _weekOfMonth    =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask   ); _weekOfMonth = null; }
                               _weekOfYear     =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask    ); _weekOfYear = null; }
                               _month          = DateTimeUtil.toLocalDate(RS.getDate(++i)); if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTH._Mask         ); _month = null; }
                               _monthOfYear    =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask   ); _monthOfYear = null; }
                               _monthName      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask     ); _monthName = null; }
                               _monthNameShort = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask); _monthNameShort = null; }
                               _quarterOfYear  =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask ); _quarterOfYear = null; }
                               _quarterName    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask   ); _quarterName = null; }
                               _year           =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.YEAR._Mask          ); _year = null; }
                               _mmyyyy         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask        ); _mmyyyy = null; } else _mmyyyy         = _mmyyyy        .trim();
                               _mmddyyyy       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask      ); _mmddyyyy = null; } else _mmddyyyy       = _mmddyyyy      .trim();
                               _yyyymmdd       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask      ); _yyyymmdd = null; } else _yyyymmdd       = _yyyymmdd      .trim();
                               _isWeekend      =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask     ); _isWeekend = null; }
                               _isBusinessDay  =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask ); _isBusinessDay = null; }
                               _isHoliday      =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask     ); _isHoliday = null; }
                               _holidayName    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask   ); _holidayName = null; }
                               _created        = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.CREATED._Mask       ); _created = null; }
                               _lastUpdated    = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.LASTUPDATED._Mask   ); _lastUpdated = null; }
                               _deleted        = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__DATEDIM_Factory.COLS.DELETED._Mask       ); _deleted = null; }
     __LookupId = 0;
     __Init     = InitMode.READ;
     __Changes.clear();

     return afterRead(C);
   }

   protected abstract boolean afterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "dt: "                                                                                                     +                                   getDt            ()
               + "; epoch: "                                                                                                  +                                   getEpoch         ()
               + "; dayName"          + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYNAME._Mask       ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDayName       ()))
               + "; dayOfWeek"        + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFWEEK._Mask     ) == true ? ": NULL" : ": " +                                   getDayOfWeek     ())
               + "; dayOfMonth"       + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFMONTH._Mask    ) == true ? ": NULL" : ": " +                                   getDayOfMonth    ())
               + "; dayOfQuarter"     + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFQUARTER._Mask  ) == true ? ": NULL" : ": " +                                   getDayOfQuarter  ())
               + "; dayOfYear"        + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DAYOFYEAR._Mask     ) == true ? ": NULL" : ": " +                                   getDayOfYear     ())
               + "; weekOfMonth"      + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFMONTH._Mask   ) == true ? ": NULL" : ": " +                                   getWeekOfMonth   ())
               + "; weekOfYear"       + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.WEEKOFYEAR._Mask    ) == true ? ": NULL" : ": " +                                   getWeekOfYear    ())
               + "; month"            + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTH._Mask         ) == true ? ": NULL" : ": " +                                   getMonth         ())
               + "; monthOfYear"      + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHOFYEAR._Mask   ) == true ? ": NULL" : ": " +                                   getMonthOfYear   ())
               + "; monthName"        + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAME._Mask     ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getMonthName     ()))
               + "; monthNameShort"   + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MONTHNAMESHORT._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getMonthNameShort()))
               + "; quarterOfYear"    + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.QUARTEROFYEAR._Mask ) == true ? ": NULL" : ": " +                                   getQuarterOfYear ())
               + "; quarterName"      + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.QUARTERNAME._Mask   ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getQuarterName   ()))
               + "; year"             + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.YEAR._Mask          ) == true ? ": NULL" : ": " +                                   getYear          ())
               + "; mmyyyy"           + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MMYYYY._Mask        ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getMmyyyy        ()))
               + "; mmddyyyy"         + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.MMDDYYYY._Mask      ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getMmddyyyy      ()))
               + "; yyyymmdd"         + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.YYYYMMDD._Mask      ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getYyyymmdd      ()))
               + "; isWeekend"        + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISWEEKEND._Mask     ) == true ? ": NULL" : ": " +                                   getIsWeekend     ())
               + "; isBusinessDay"    + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISBUSINESSDAY._Mask ) == true ? ": NULL" : ": " +                                   getIsBusinessDay ())
               + "; isHoliday"        + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.ISHOLIDAY._Mask     ) == true ? ": NULL" : ": " +                                   getIsHoliday     ())
               + "; holidayName"      + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.HOLIDAYNAME._Mask   ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getHolidayName   ()))
               + "; created: "                                                                                                + DateTimeUtil.printDateTimeForJSON(getCreated       ())
               + "; lastUpdated: "                                                                                            + DateTimeUtil.printDateTimeForJSON(getLastUpdated   ())
               + "; deleted"          + (__Nulls.intersects(TILDA__DATEDIM_Factory.COLS.DELETED._Mask       ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDeleted       ()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

   public void toJSON(java.io.Writer out, String exportName, boolean fullObject) throws Exception
    {
      toJSON(out, exportName, "", fullObject, false);
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject) throws Exception
    {
      toJSON(out, exportName, lead, fullObject, false);
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, boolean noNullArrays) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data.DateDim_Factory.toJSON(out, (tilda.data.DateDim_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data.DateDim_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data.DateDim_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data.DateDim_Factory.toCSV(out, (tilda.data.DateDim_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data.DateDim_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data.DateDim_Factory");
    }
 }
