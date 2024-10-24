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
<TABLE id="JobPart_DIV" class="tables">
<SCRIPT>registerStickyHeader("JobPart_DIV");</SCRIPT>
<TR valign="top"><TD><H2>JobPart&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#JobPart_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="JobPart_CNT" class="content">
The Table TILDA.JobPart :<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>JobPart_Factory</B>, <B>JobPart_Data</B> in the package <B>tilda.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Defines a foreign key:<BR>
<TABLE style="margin-left: 25px; border:1px solid #BBB;" cellspacing="0px" cellpadding="5px" border="0px">
<TR style="background-color:#DDD; font-weight:bold;"><TD></TD><TD>Source Columns</TD><TD>Destination Object</TD><TD>Destination Columns</TD><TD>Notes</TD></TR>
<TR ><TD>1</TD><TD>jobRefnum</TD><TD><A href="TILDA___Docs.TILDA.html#Job_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job</A></TD><TD>refnum</TD><TD>&nbsp;</TD></TR>
</TABLE></LI>
<LI>Has the following identity:<UL><LI>Primary Key: refnum</LI>
</UL></LI>
<LI>Has the following indices:<UL><LI>jobRefnum, start desc
</LI>
<LI>name, start desc
</LI>
<LI>type, start desc
</LI>
</UL></LI>
</UL>
<B>Description</B>:<BLOCKQUOTE style="border-left: 1px solid #EEE;padding-left: 5px;">Job part details</BLOCKQUOTE>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="JobPart_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid #BBB;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">TZ</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-refnum_DIV' class='columns'>refnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-jobRefnum_DIV' class='columns'>jobRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Parent Job Refnum<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Job_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job</A>: refnum</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-name_DIV' class='columns'>name</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job part name</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-type_DIV' class='columns'>type</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job part type</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-dataStartTZ_DIV' class='columns'>dataStartTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dataStart'.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-dataStart_DIV' class='columns'>dataStart</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center"><SPAN style="font-weight:bold;font-size:10px">COLUMN</SPAN>&nbsp;&nbsp;</TD>
<TD>Job part data start</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-dataEndTZ_DIV' class='columns'>dataEndTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dataEnd'.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-dataEnd_DIV' class='columns'>dataEnd</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center"><SPAN style="font-weight:bold;font-size:10px">COLUMN</SPAN>&nbsp;&nbsp;</TD>
<TD>Job part data end</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-startTZ_DIV' class='columns'>startTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'start'.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-start_DIV' class='columns'>start</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center"><SPAN style="font-weight:bold;font-size:10px">COLUMN</SPAN>&nbsp;&nbsp;</TD>
<TD>Job part execution start</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-endTZ_DIV' class='columns'>endTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'end'.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-end_DIV' class='columns'>end</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center"><SPAN style="font-weight:bold;font-size:10px">COLUMN</SPAN>&nbsp;&nbsp;</TD>
<TD>Job part execution end</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-recordsCount_DIV' class='columns'>recordsCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>count of database or file or ... records.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-status_DIV' class='columns'>status</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Status flag, i.e., success=true and failure-false</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created. (TILDA.JobPart)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDA.JobPart)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobPart-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__JOBPART implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__JOBPART.class.getName());

   public transient static final Class<TILDA__JOBPART_Factory> FACTORY_CLASS= TILDA__JOBPART_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDA.JobPart", "");

   protected TILDA__JOBPART() { }

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
//   Field tilda.data.TILDA.JobPart.refnum -> TILDA.JobPart."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Long _refnum=null;
   protected Long __Saved_refnum;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.refnum -> TILDA.JobPart."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getRefnum()
      { return _refnum==null?0l:_refnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.refnum -> TILDA.JobPart."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _refnum == null || v != _refnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobPart.refnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBPART_Factory.COLS.REFNUM._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.REFNUM._Mask);
       _refnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.jobRefnum -> TILDA.JobPart."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Parent Job Refnum</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.jobRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.jobRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobRefnum")
   Long _jobRefnum=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.jobRefnum -> TILDA.JobPart."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Parent Job Refnum</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.jobRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.jobRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getJobRefnum()
      { return _jobRefnum==null?0l:_jobRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.jobRefnum -> TILDA.JobPart."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Parent Job Refnum</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.jobRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.jobRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setJobRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _jobRefnum == null || v != _jobRefnum)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.JOBREFNUM._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.JOBREFNUM._Mask);
       _jobRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.jobRefnum -> TILDA.JobPart."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Parent Job Refnum</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.jobRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.jobRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedJobRefnum()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.JOBREFNUM._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.name -> TILDA.JobPart."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>name of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.name of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.name</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("name")
   String _name=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.name -> TILDA.JobPart."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>name of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.name of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.name</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getName()
      { return _name; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.name -> TILDA.JobPart."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>name of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.name of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.name</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.name to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 250)
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.name: the size "+v.length()+" is larger than the max allowed of 250: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_name) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.NAME._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.NAME._Mask);
       _name = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.name -> TILDA.JobPart."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>name of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.name of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.name</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedName()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.NAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.type -> TILDA.JobPart."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.type of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("type")
   String _type=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.type -> TILDA.JobPart."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.type of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getType()
      { return _type; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.type -> TILDA.JobPart."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.type of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullType()
     { return __Nulls.intersects(TILDA__JOBPART_Factory.COLS.TYPE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.type -> TILDA.JobPart."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.type of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setType(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullType();
        }
       else if (v.length() > 250)
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.type: the size "+v.length()+" is larger than the max allowed of 250: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_type) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.TYPE._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.TYPE._Mask);
       _type = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.type -> TILDA.JobPart."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.type of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullType()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBPART_Factory.COLS.TYPE._Mask);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.TYPE._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBPART_Factory.COLS.TYPE._Mask);
       _type=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.type -> TILDA.JobPart."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.type of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedType()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.TYPE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStartTZ -> TILDA.JobPart."dataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _dataStartTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStartTZ -> TILDA.JobPart."dataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDataStartTZ()
      { return _dataStartTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStartTZ -> TILDA.JobPart."dataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDataStartTZ()
     { return __Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStartTZ -> TILDA.JobPart."dataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDataStartTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDataStartTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.dataStartTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dataStartTZ) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask);
       _dataStartTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStartTZ -> TILDA.JobPart."dataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDataStartTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask);
       _dataStartTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStartTZ -> TILDA.JobPart."dataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDataStartTZ()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStart -> TILDA.JobPart."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataStartTZ'</LI>
</TD></TR>

</TABLE>
*/
   @SerializedName("dataStart")
   String  Str_dataStart;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_DataStart(String v) { Str_dataStart = v; }
   public String initDataStartVal() { return Str_dataStart; }
   transient ZonedDateTime _dataStart = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStart -> TILDA.JobPart."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataStartTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDataStart()
      { return _dataStart; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStart -> TILDA.JobPart."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataStartTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDataStart()
     { return __Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStart -> TILDA.JobPart."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataStartTZ'</LI>
</TD></TR>

</TABLE>
*/
   public void setDataStart(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDataStart();
        }
       else if (v.equals(_dataStart) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.DATASTART._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.DATASTART._Mask);
       _dataStart = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobPart.dataStart' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDataStartTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStart -> TILDA.JobPart."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataStartTZ'</LI>
</TD></TR>

</TABLE>
*/
   public void setNullDataStart()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBPART_Factory.COLS.DATASTART._Mask);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBPART_Factory.COLS.DATASTART._Mask);
       _dataStart=null;
       setNullDataStartTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStart -> TILDA.JobPart."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataStartTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setDataStartNow() throws Exception
    {
      setDataStart(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStart -> TILDA.JobPart."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataStartTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setDataStartUndefined() throws Exception
    {
      setDataStart(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStart -> TILDA.JobPart."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataStartTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setDataStart(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDataStart(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataStart -> TILDA.JobPart."dataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataStartTZ'</LI>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedDataStart()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEndTZ -> TILDA.JobPart."dataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _dataEndTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEndTZ -> TILDA.JobPart."dataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDataEndTZ()
      { return _dataEndTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEndTZ -> TILDA.JobPart."dataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDataEndTZ()
     { return __Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEndTZ -> TILDA.JobPart."dataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDataEndTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDataEndTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.dataEndTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dataEndTZ) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask);
       _dataEndTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEndTZ -> TILDA.JobPart."dataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDataEndTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask);
       _dataEndTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEndTZ -> TILDA.JobPart."dataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDataEndTZ()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEnd -> TILDA.JobPart."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataEndTZ'</LI>
</TD></TR>

</TABLE>
*/
   @SerializedName("dataEnd")
   String  Str_dataEnd;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_DataEnd(String v) { Str_dataEnd = v; }
   public String initDataEndVal() { return Str_dataEnd; }
   transient ZonedDateTime _dataEnd = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEnd -> TILDA.JobPart."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataEndTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDataEnd()
      { return _dataEnd; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEnd -> TILDA.JobPart."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataEndTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDataEnd()
     { return __Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEnd -> TILDA.JobPart."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataEndTZ'</LI>
</TD></TR>

</TABLE>
*/
   public void setDataEnd(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDataEnd();
        }
       else if (v.equals(_dataEnd) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.DATAEND._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.DATAEND._Mask);
       _dataEnd = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobPart.dataEnd' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDataEndTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEnd -> TILDA.JobPart."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataEndTZ'</LI>
</TD></TR>

</TABLE>
*/
   public void setNullDataEnd()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBPART_Factory.COLS.DATAEND._Mask);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBPART_Factory.COLS.DATAEND._Mask);
       _dataEnd=null;
       setNullDataEndTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEnd -> TILDA.JobPart."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataEndTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setDataEndNow() throws Exception
    {
      setDataEnd(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEnd -> TILDA.JobPart."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataEndTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setDataEndUndefined() throws Exception
    {
      setDataEnd(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEnd -> TILDA.JobPart."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataEndTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setDataEnd(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDataEnd(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.dataEnd -> TILDA.JobPart."dataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.dataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.dataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dataEndTZ'</LI>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedDataEnd()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.startTZ -> TILDA.JobPart."startTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'start'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.startTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.startTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _startTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.startTZ -> TILDA.JobPart."startTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'start'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.startTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.startTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getStartTZ()
      { return _startTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.startTZ -> TILDA.JobPart."startTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'start'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.startTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.startTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setStartTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.startTZ to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.startTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_startTZ) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.STARTTZ._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.STARTTZ._Mask);
       _startTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.startTZ -> TILDA.JobPart."startTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'start'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.startTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.startTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedStartTZ()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.STARTTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.start -> TILDA.JobPart."start"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>start of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.start of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.start</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'startTZ'</LI>
</TD></TR>

</TABLE>
*/
   @SerializedName("start")
   String  Str_start;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Start(String v) { Str_start = v; }
   public String initStartVal() { return Str_start; }
   transient ZonedDateTime _start = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.start -> TILDA.JobPart."start"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>start of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.start of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.start</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'startTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getStart()
      { return _start; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.start -> TILDA.JobPart."start"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>start of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.start of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.start</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'startTZ'</LI>
</TD></TR>

</TABLE>
*/
   public void setStart(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.start to null: it's not nullable.");
       else if (v.equals(_start) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.START._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.START._Mask);
       _start = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobPart.start' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setStartTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.start -> TILDA.JobPart."start"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>start of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.start of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.start</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'startTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setStartNow() throws Exception
    {
      setStart(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.start -> TILDA.JobPart."start"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>start of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.start of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.start</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'startTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setStartUndefined() throws Exception
    {
      setStart(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.start -> TILDA.JobPart."start"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>start of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.start of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.start</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'startTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setStart(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setStart(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.start -> TILDA.JobPart."start"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>start of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.start of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.start</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'startTZ'</LI>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedStart()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.START._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.endTZ -> TILDA.JobPart."endTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'end'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.endTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.endTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _endTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.endTZ -> TILDA.JobPart."endTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'end'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.endTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.endTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getEndTZ()
      { return _endTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.endTZ -> TILDA.JobPart."endTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'end'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.endTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.endTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullEndTZ()
     { return __Nulls.intersects(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.endTZ -> TILDA.JobPart."endTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'end'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.endTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.endTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setEndTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullEndTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.endTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_endTZ) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask);
       _endTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.endTZ -> TILDA.JobPart."endTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'end'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.endTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.endTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullEndTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask);
       _endTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.endTZ -> TILDA.JobPart."endTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'end'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.endTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.endTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedEndTZ()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.end -> TILDA.JobPart."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>end of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.end of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.end</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endTZ'</LI>
</TD></TR>

</TABLE>
*/
   @SerializedName("end")
   String  Str_end;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_End(String v) { Str_end = v; }
   public String initEndVal() { return Str_end; }
   transient ZonedDateTime _end = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.end -> TILDA.JobPart."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>end of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.end of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.end</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getEnd()
      { return _end; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.end -> TILDA.JobPart."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>end of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.end of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.end</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final boolean isNullEnd()
     { return __Nulls.intersects(TILDA__JOBPART_Factory.COLS.END._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.end -> TILDA.JobPart."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>end of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.end of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.end</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endTZ'</LI>
</TD></TR>

</TABLE>
*/
   public void setEnd(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullEnd();
        }
       else if (v.equals(_end) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.END._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.END._Mask);
       _end = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobPart.end' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setEndTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.end -> TILDA.JobPart."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>end of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.end of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.end</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endTZ'</LI>
</TD></TR>

</TABLE>
*/
   public void setNullEnd()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBPART_Factory.COLS.END._Mask);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.END._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBPART_Factory.COLS.END._Mask);
       _end=null;
       setNullEndTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.end -> TILDA.JobPart."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>end of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.end of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.end</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setEndNow() throws Exception
    {
      setEnd(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.end -> TILDA.JobPart."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>end of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.end of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.end</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setEndUndefined() throws Exception
    {
      setEnd(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.end -> TILDA.JobPart."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>end of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.end of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.end</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final void setEnd(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setEnd(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.end -> TILDA.JobPart."end"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>end of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.end of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.end</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endTZ'</LI>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedEnd()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.END._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.recordsCount -> TILDA.JobPart."recordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>recordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.recordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.recordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("recordsCount")
   Integer _recordsCount=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.recordsCount -> TILDA.JobPart."recordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>recordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.recordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.recordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getRecordsCount()
      { return _recordsCount==null?0:_recordsCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.recordsCount -> TILDA.JobPart."recordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>recordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.recordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.recordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullRecordsCount()
     { return __Nulls.intersects(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.recordsCount -> TILDA.JobPart."recordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>recordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.recordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.recordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setRecordsCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _recordsCount == null || v != _recordsCount)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask);
       _recordsCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.recordsCount -> TILDA.JobPart."recordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>recordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.recordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.recordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullRecordsCount()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask);
       _recordsCount=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.recordsCount -> TILDA.JobPart."recordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>recordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.recordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.recordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedRecordsCount()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.status -> TILDA.JobPart."status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>status of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.status of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.status</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("status")
   Boolean _status=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.status -> TILDA.JobPart."status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>status of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.status of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.status</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getStatus()
      { return _status==null?false:_status; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.status -> TILDA.JobPart."status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>status of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.status of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.status</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullStatus()
     { return __Nulls.intersects(TILDA__JOBPART_Factory.COLS.STATUS._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.status -> TILDA.JobPart."status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>status of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.status of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.status</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setStatus(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _status == null || v != _status)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.STATUS._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.STATUS._Mask);
       _status = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.status -> TILDA.JobPart."status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>status of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.status of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.status</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullStatus()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBPART_Factory.COLS.STATUS._Mask);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.STATUS._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBPART_Factory.COLS.STATUS._Mask);
       _status=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.status -> TILDA.JobPart."status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>status of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.status of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.status</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedStatus()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.STATUS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.created -> TILDA.JobPart."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.created</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.created -> TILDA.JobPart."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.created</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.created -> TILDA.JobPart."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.created</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobPart.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBPART_Factory.COLS.CREATED._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.CREATED._Mask);
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.created -> TILDA.JobPart."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.created</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.created -> TILDA.JobPart."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.created</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.created -> TILDA.JobPart."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.created</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.created -> TILDA.JobPart."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.created</TD></TR>

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
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.CREATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.lastUpdated -> TILDA.JobPart."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.lastUpdated -> TILDA.JobPart."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.lastUpdated -> TILDA.JobPart."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.lastUpdated</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.JobPart.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.lastUpdated -> TILDA.JobPart."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.lastUpdated -> TILDA.JobPart."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.lastUpdated -> TILDA.JobPart."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.lastUpdated -> TILDA.JobPart."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.lastUpdated</TD></TR>

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
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.deleted -> TILDA.JobPart."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _deleted = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.deleted -> TILDA.JobPart."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.deleted</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.deleted -> TILDA.JobPart."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDeleted()
     { return __Nulls.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.deleted -> TILDA.JobPart."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.deleted</TD></TR>

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
          __Changes.or(TILDA__JOBPART_Factory.COLS.DELETED._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.DELETED._Mask);
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.deleted -> TILDA.JobPart."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setNullDeleted()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBPART_Factory.COLS.DELETED._Mask);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBPART_Factory.COLS.DELETED._Mask);
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobPart.deleted -> TILDA.JobPart."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.deleted</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.deleted -> TILDA.JobPart."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.deleted</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.deleted -> TILDA.JobPart."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.deleted</TD></TR>

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
//   Field tilda.data.TILDA.JobPart.deleted -> TILDA.JobPart."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.JobPart)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobPart.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobPart.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleted()
     { return __Changes.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.data._Tilda.TILDA__JOBPART Dst) throws Exception
     {
       if (_jobRefnum    != null)
        Dst.setJobRefnum   (_jobRefnum   );
       if (_name         != null)
        Dst.setName        (_name        );
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.TYPE._Mask) == true || _type        ==null)
        Dst.setNullType        ();
       else
        Dst.setType        (_type        );
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask) == true || _dataStartTZ ==null)
        Dst.setNullDataStartTZ ();
       else
        Dst.setDataStartTZ (_dataStartTZ );
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask) == true || _dataStart   ==null)
        Dst.setNullDataStart   ();
       else
        Dst.setDataStart   (_dataStart   );
       Dst.Str_dataStart = Str_dataStart;
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask) == true || _dataEndTZ   ==null)
        Dst.setNullDataEndTZ   ();
       else
        Dst.setDataEndTZ   (_dataEndTZ   );
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask) == true || _dataEnd     ==null)
        Dst.setNullDataEnd     ();
       else
        Dst.setDataEnd     (_dataEnd     );
       Dst.Str_dataEnd = Str_dataEnd;
       if (_startTZ      != null)
        Dst.setStartTZ     (_startTZ     );
       if (_start        != null)
        Dst.setStart       (_start       );
       Dst.Str_start = Str_start;
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask) == true || _endTZ       ==null)
        Dst.setNullEndTZ       ();
       else
        Dst.setEndTZ       (_endTZ       );
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.END._Mask) == true || _end         ==null)
        Dst.setNullEnd         ();
       else
        Dst.setEnd         (_end         );
       Dst.Str_end = Str_end;
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask) == true || _recordsCount==null)
        Dst.setNullRecordsCount();
       else
        Dst.setRecordsCount(_recordsCount);
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.STATUS._Mask) == true || _status      ==null)
        Dst.setNullStatus      ();
       else
        Dst.setStatus      (_status      );
       if (__Init == InitMode.CREATE && _created      != null)
        Dst.setCreated     (_created     );
       if (_lastUpdated  != null)
        Dst.setLastUpdated (_lastUpdated );
       if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask) == true || _deleted     ==null)
        Dst.setNullDeleted     ();
       else
        Dst.setDeleted     (_deleted     );
     }


   public tilda.data.JobPart_Data copy() throws Exception
     {
       tilda.data.JobPart_Data dst = new tilda.data.JobPart_Data();
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
          // Auto PK
          setRefnum(tilda.db.KeysManager.getKey("TILDA.JOBPART"));
        }

       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.JobPart has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }


       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.JobPart object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, "");
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
               PS.setLong      (++i, _refnum      );
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (_jobRefnum == null)
        throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.jobRefnum' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__JOBPART_Factory.COLS.JOBREFNUM._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.JOBREFNUM._Mask);

       if (TextUtil.isNullOrEmpty(_name) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.name' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__JOBPART_Factory.COLS.NAME._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.NAME._Mask);

       if (TextUtil.isNullOrEmpty(_type) == false)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.TYPE._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.TYPE._Mask);
        }

       if (TextUtil.isNullOrEmpty(Str_dataStart) == false)
        {
          _dataStart = DateTimeUtil.parsefromJSON(Str_dataStart);
          if (   _dataStart == null)
           throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.dataStart' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__JOBPART_Factory.COLS.DATASTART._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.DATASTART._Mask);
          String zoneId = _dataStart.getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobPart.dataStart' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDataStartTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dataEnd) == false)
        {
          _dataEnd = DateTimeUtil.parsefromJSON(Str_dataEnd);
          if (   _dataEnd == null)
           throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.dataEnd' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__JOBPART_Factory.COLS.DATAEND._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.DATAEND._Mask);
          String zoneId = _dataEnd.getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobPart.dataEnd' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDataEndTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_start) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.start' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__JOBPART_Factory.COLS.START._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.START._Mask);
        {
       _start = DateTimeUtil.parsefromJSON(Str_start);
       if (   _start == null)
        throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.start' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       __Changes.or(TILDA__JOBPART_Factory.COLS.START._Mask);
       __Nulls.andNot(TILDA__JOBPART_Factory.COLS.START._Mask);
       String zoneId = _start.getZone().getId();
       tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
       if (ZI == null)
        throw new Exception("Cannot set field 'tilda.data.TILDA.JobPart.start' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setStartTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_end) == false)
        {
          _end = DateTimeUtil.parsefromJSON(Str_end);
          if (   _end == null)
           throw new Exception("Incoming value for 'tilda.data.TILDA.JobPart.end' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__JOBPART_Factory.COLS.END._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.END._Mask);
          String zoneId = _end.getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobPart.end' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setEndTZ(ZI.getId());
        }

       if (_recordsCount != null)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask);
        }

       if (_status != null)
        {
          __Changes.or(TILDA__JOBPART_Factory.COLS.STATUS._Mask);
          __Nulls.andNot(TILDA__JOBPART_Factory.COLS.STATUS._Mask);
        }
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dataStart) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dataEnd) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.START._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_start) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.END._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_end) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.CREATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_created) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_deleted) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "JobPart");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.REFNUM._Mask) == true) { TILDA__JOBPART_Factory.COLS.REFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.JOBREFNUM._Mask) == true) { TILDA__JOBPART_Factory.COLS.JOBREFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.NAME._Mask) == true) { TILDA__JOBPART_Factory.COLS.NAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.TYPE._Mask) == true) { TILDA__JOBPART_Factory.COLS.TYPE.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask) == true) { TILDA__JOBPART_Factory.COLS.DATASTARTTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask) == true) { TILDA__JOBPART_Factory.COLS.DATASTART.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask) == false && DateTimeUtil.isNowPlaceholder(_dataStart) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask) == true) { TILDA__JOBPART_Factory.COLS.DATAENDTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask) == true) { TILDA__JOBPART_Factory.COLS.DATAEND.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask) == false && DateTimeUtil.isNowPlaceholder(_dataEnd) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.STARTTZ._Mask) == true) { TILDA__JOBPART_Factory.COLS.STARTTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.START._Mask) == true) { TILDA__JOBPART_Factory.COLS.START.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOBPART_Factory.COLS.START._Mask) == false && DateTimeUtil.isNowPlaceholder(_start) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask) == true) { TILDA__JOBPART_Factory.COLS.ENDTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.END._Mask) == true) { TILDA__JOBPART_Factory.COLS.END.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOBPART_Factory.COLS.END._Mask) == false && DateTimeUtil.isNowPlaceholder(_end) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask) == true) { TILDA__JOBPART_Factory.COLS.RECORDSCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.STATUS._Mask) == true) { TILDA__JOBPART_Factory.COLS.STATUS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.CREATED._Mask) == true) { TILDA__JOBPART_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOBPART_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__JOBPART_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__JOBPART_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__JOBPART_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask) == true) { TILDA__JOBPART_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDA", "JobPart"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.REFNUM._Mask) == true) TILDA__JOBPART_Factory.COLS.REFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.JOBREFNUM._Mask) == true) TILDA__JOBPART_Factory.COLS.JOBREFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.NAME._Mask) == true) TILDA__JOBPART_Factory.COLS.NAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.TYPE._Mask) == true) TILDA__JOBPART_Factory.COLS.TYPE.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask) == true) TILDA__JOBPART_Factory.COLS.DATASTARTTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask) == false && DateTimeUtil.isNowPlaceholder(_dataStart) == true)
              { TILDA__JOBPART_Factory.COLS.DATASTART.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBPART_Factory.COLS.DATASTART.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask) == true) TILDA__JOBPART_Factory.COLS.DATAENDTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask) == false && DateTimeUtil.isNowPlaceholder(_dataEnd) == true)
              { TILDA__JOBPART_Factory.COLS.DATAEND.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBPART_Factory.COLS.DATAEND.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.STARTTZ._Mask) == true) TILDA__JOBPART_Factory.COLS.STARTTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.START._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.START._Mask) == false && DateTimeUtil.isNowPlaceholder(_start) == true)
              { TILDA__JOBPART_Factory.COLS.START.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBPART_Factory.COLS.START.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask) == true) TILDA__JOBPART_Factory.COLS.ENDTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.END._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.END._Mask) == false && DateTimeUtil.isNowPlaceholder(_end) == true)
              { TILDA__JOBPART_Factory.COLS.END.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBPART_Factory.COLS.END.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask) == true) TILDA__JOBPART_Factory.COLS.RECORDSCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.STATUS._Mask) == true) TILDA__JOBPART_Factory.COLS.STATUS.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.CREATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__JOBPART_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBPART_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__JOBPART_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBPART_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__JOBPART_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__JOBPART_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBPART_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0: // PK
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JobPart", "refnum"); S.append("=?");  S.append(")");
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
       QueryDetails.setLastQuery(TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.JobPart", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.REFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.REFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _refnum);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.JOBREFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.JOBREFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _jobRefnum);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.NAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.NAME._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _name);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.TYPE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.TYPE._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _type);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _dataStartTZ);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_dataStart) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dataStart.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _dataEndTZ);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_dataEnd) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dataEnd.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.STARTTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.STARTTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _startTZ);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.START._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.START._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_start) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_start.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _endTZ);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.END._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.END._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_end) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_end.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _recordsCount);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.STATUS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.STATUS._Mask) == true) PS.setNull(++i, java.sql.Types.BOOLEAN   ); else PS.setBoolean   (++i, _status);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.CREATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_created.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_lastUpdated.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_deleted.toInstant()), DateTimeUtil._UTC_CALENDAR);
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
             __Saved_refnum       = _refnum      ;
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
        }

       __Changes.clear();
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
        throw new Exception("This TILDA.JobPart object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.JobPart object has already been read.");
          QueryDetails.setLastQuery(TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__JOBPART_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "JobPart");
       switch (__LookupId)
        {
          case 0: // PK
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JobPart", "refnum"); S.append("=?");  S.append(")");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.JobPart", Q, toString());
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
               PS.setLong      (++i, _refnum      );
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__JOBPART_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_refnum       = _refnum       =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.REFNUM._Mask      ); _refnum = null; }
                             _jobRefnum    =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.JOBREFNUM._Mask   ); _jobRefnum = null; }
                             _name         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.NAME._Mask        ); _name = null; }
                             _type         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.TYPE._Mask        ); _type = null; }
                             _dataStartTZ  = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.DATASTARTTZ._Mask ); _dataStartTZ = null; } else _dataStartTZ  = _dataStartTZ .trim();
                             _dataStart    = JDBCHelper.processZDT(_dataStartTZ   , "tilda.data.TILDA.JobPart.dataStart"   , RS, ++i, TILDA__JOBPART_Factory.COLS.DATASTART   , TILDA__JOBPART_Factory.COLS.DATASTARTTZ   , __Nulls); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.DATASTART._Mask   ); _dataStart = null; }
                             _dataEndTZ    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.DATAENDTZ._Mask   ); _dataEndTZ = null; } else _dataEndTZ    = _dataEndTZ   .trim();
                             _dataEnd      = JDBCHelper.processZDT(_dataEndTZ     , "tilda.data.TILDA.JobPart.dataEnd"     , RS, ++i, TILDA__JOBPART_Factory.COLS.DATAEND     , TILDA__JOBPART_Factory.COLS.DATAENDTZ     , __Nulls); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.DATAEND._Mask     ); _dataEnd = null; }
                             _startTZ      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.STARTTZ._Mask     ); _startTZ = null; } else _startTZ      = _startTZ     .trim();
                             _start        = JDBCHelper.processZDT(_startTZ       , "tilda.data.TILDA.JobPart.start"       , RS, ++i, TILDA__JOBPART_Factory.COLS.START       , TILDA__JOBPART_Factory.COLS.STARTTZ       , __Nulls); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.START._Mask       ); _start = null; }
                             _endTZ        = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.ENDTZ._Mask       ); _endTZ = null; } else _endTZ        = _endTZ       .trim();
                             _end          = JDBCHelper.processZDT(_endTZ         , "tilda.data.TILDA.JobPart.end"         , RS, ++i, TILDA__JOBPART_Factory.COLS.END         , TILDA__JOBPART_Factory.COLS.ENDTZ         , __Nulls); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.END._Mask         ); _end = null; }
                             _recordsCount =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask); _recordsCount = null; }
                             _status       =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.STATUS._Mask      ); _status = null; }
                             _created      = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.CREATED._Mask     ); _created = null; }
                             _lastUpdated  = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.LASTUPDATED._Mask ); _lastUpdated = null; }
                             _deleted      = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBPART_Factory.COLS.DELETED._Mask     ); _deleted = null; }
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
                   "refnum: "                                                                                             +                                   getRefnum      ()
               + "; jobRefnum: "                                                                                          +                                   getJobRefnum   ()
               + "; name: "                                                                                               + TextUtil.printVariableStr        (getName        ())
               + "; type"           + (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.TYPE._Mask        ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getType        ()))
               + "; dataStart"      + (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATASTART._Mask   ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDataStart   ()))
               + "; dataEnd"        + (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DATAEND._Mask     ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDataEnd     ()))
               + "; start: "                                                                                              + DateTimeUtil.printDateTimeForJSON(getStart       ())
               + "; end"            + (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.END._Mask         ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getEnd         ()))
               + "; recordsCount"   + (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.RECORDSCOUNT._Mask) == true ? ": NULL" : ": " +                                   getRecordsCount())
               + "; status"         + (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.STATUS._Mask      ) == true ? ": NULL" : ": " +                                   getStatus      ())
               + "; created: "                                                                                            + DateTimeUtil.printDateTimeForJSON(getCreated     ())
               + "; lastUpdated: "                                                                                        + DateTimeUtil.printDateTimeForJSON(getLastUpdated ())
               + "; deleted"        + (__Nulls.intersects(TILDA__JOBPART_Factory.COLS.DELETED._Mask     ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDeleted     ()))
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
          case "": tilda.data.JobPart_Factory.toJSON(out, (tilda.data.JobPart_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data.JobPart_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data.JobPart_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data.JobPart_Factory.toCSV(out, (tilda.data.JobPart_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data.JobPart_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data.JobPart_Factory");
    }
 }
