/*
 Tilda V1.0 data object.

 Code is generated: do not modify! Instead, create a derived class and override desired functionality
*/

package tilda.data._Tilda;

import java.time.*;
import java.io.Writer;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.utils.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
<DIV>
<DIV id='JOBFILE_DIV' class='tables'>
<H2>JOBFILE&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 60%;"><A href="#">top</A></SUP></H2>
</DIV>
The generated Java 8/PostgreSQL Tilda data class <B>Data_JOBFILE</B> is mapped to the Table <B>TILDA.JOBFILE</B>.
<UL>

<LI>The Table has normal <B>read/write</B> capabilities.</LI>
<LI>The Table is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
</UL>
<B>Description</B>: Job File Info<BR>
<BR>

It contains the following columns:<BR>
 <TABLE border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><!--TH align="left">Column</TH--><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>

  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='JOBFILE-refnum_DIV' class='columns'>refnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;&nbsp;</TD>
<TD>bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='JOBFILE-jobRefnum_DIV' class='columns'>jobRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;&nbsp;</TD>
<TD>bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job Foreign key</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='JOBFILE-fileName_DIV' class='columns'>fileName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;&nbsp;</TD>
<TD>varchar(200)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Zip FileName</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='JOBFILE-fileRecords_DIV' class='columns'>fileRecords</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;&nbsp;</TD>
<TD>integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Number of records loaded into DB</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('JOBFILE-fileProcessStartTimeTZ')" align="right"><B id='JOBFILE-fileProcessStartTimeTZ_DIV' class='columns dotted_underline cursor_pointer'>fileProcessStartTimeTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;&nbsp;</TD>
<TD>character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'fileProcessStartTime'.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='JOBFILE-fileProcessStartTime_DIV' class='columns'>fileProcessStartTime</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;&nbsp;</TD>
<TD>timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>FileProcessStartTime</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>7&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('JOBFILE-fileProcessEndTimeTZ')" align="right"><B id='JOBFILE-fileProcessEndTimeTZ_DIV' class='columns dotted_underline cursor_pointer'>fileProcessEndTimeTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;&nbsp;</TD>
<TD>character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'fileProcessEndTime'.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='JOBFILE-fileProcessEndTime_DIV' class='columns'>fileProcessEndTime</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;&nbsp;</TD>
<TD>timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>FileProcessEndTime</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='JOBFILE-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;&nbsp;</TD>
<TD>timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created.</TD>
</TR>
  <TR bgcolor="#DFECF8"><TD></TD><TD></TD><TD colspan="10" align="center">
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFF2CC"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>Creation</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>Creation&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Creation time</TD></TR>
</TABLE>
</TD></TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='JOBFILE-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;&nbsp;</TD>
<TD>timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated.</TD>
</TR>
  <TR bgcolor="#FFFFFF"><TD></TD><TD></TD><TD colspan="10" align="center">
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFF2CC"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>Update</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>Update&nbsp;&nbsp;</TD><TD>ALWAYS&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Last updated time</TD></TR>
</TABLE>
</TD></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='JOBFILE-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;&nbsp;</TD>
<TD>timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted.</TD>
</TR>
</TABLE>
<DIV id='JOBFILE-refnum_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-refnum_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-refnum_DIV'>refnum</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='JOBFILE-jobRefnum_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-jobRefnum_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-jobRefnum_DIV'>jobRefnum</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='JOBFILE-fileName_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-fileName_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-fileName_DIV'>fileName</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='JOBFILE-fileRecords_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-fileRecords_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-fileRecords_DIV'>fileRecords</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='JOBFILE-fileProcessStartTimeTZ_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-fileProcessStartTimeTZ_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-fileProcessStartTimeTZ_DIV'>fileProcessStartTimeTZ</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZONEINFO_DIV'>ZoneInfo</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZONEINFO-id_DIV'>id</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='JOBFILE-fileProcessStartTime_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-fileProcessStartTime_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-fileProcessStartTime_DIV'>fileProcessStartTime</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='JOBFILE-fileProcessEndTimeTZ_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-fileProcessEndTimeTZ_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-fileProcessEndTimeTZ_DIV'>fileProcessEndTimeTZ</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZONEINFO_DIV'>ZoneInfo</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZONEINFO-id_DIV'>id</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='JOBFILE-fileProcessEndTime_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-fileProcessEndTime_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-fileProcessEndTime_DIV'>fileProcessEndTime</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='JOBFILE-created_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-created_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-created_DIV'>created</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='JOBFILE-lastUpdated_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-lastUpdated_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-lastUpdated_DIV'>lastUpdated</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='JOBFILE-deleted_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('JOBFILE-deleted_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE_DIV'>JobFile</a></td>
<td><a href='TILDA___Docs.TILDA.html#JOBFILE-deleted_DIV'>deleted</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
</DIV>

 @author   Tilda code gen for Java 8/PostgreSQL
 @version  Tilda 1.0
 @generated Oct 30 2017, 11:42:02IST
*/
public abstract class TILDA__JOBFILE implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__JOBFILE.class.getName());

   public static final Class<TILDA__JOBFILE_Factory> FACTORY_CLASS= TILDA__JOBFILE_Factory.class;
   public static final String TABLENAME = TextUtil.Print("TILDA.JOBFILE", "");

   protected TILDA__JOBFILE() { }

   private InitMode __Init        = null;
   private long     __Nulls1      = 0L;
   private long     __Nulls2      = 0L;
   private long     __Nulls3      = 0L;
   private long     __Nulls4      = 0L;
   private long     __Changes1    = 0L;
   private long     __Changes2    = 0L;
   private long     __Changes3    = 0L;
   private long     __Changes4    = 0L;
   private boolean  __NewlyCreated= false;
   private int      __LookupId;

   public  boolean hasChanged    () { return __Changes1 != 0L || __Changes2 != 0L || __Changes3 != 0L || __Changes4 != 0L; }
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
//   Field tilda.data.TILDA.JOBFILE.refnum -> TILDA.JOBFILE."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _refnum= SystemValues.EVIL_VALUE;
   protected long __Saved_refnum;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.refnum -> TILDA.JOBFILE."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getRefnum()
      { return _refnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.refnum -> TILDA.JOBFILE."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _refnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JOBFILE.refnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.REFNUM._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.REFNUM._Mask1;
       _refnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.jobRefnum -> TILDA.JOBFILE."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.jobRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.jobRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job Foreign key</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _jobRefnum= SystemValues.EVIL_VALUE;
   protected long __Saved_jobRefnum;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.jobRefnum -> TILDA.JOBFILE."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.jobRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.jobRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job Foreign key</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getJobRefnum()
      { return _jobRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.jobRefnum -> TILDA.JOBFILE."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.jobRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.jobRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job Foreign key</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setJobRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _jobRefnum)
        {
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.JOBREFNUM._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.JOBREFNUM._Mask1;
       _jobRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.jobRefnum -> TILDA.JOBFILE."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.jobRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.jobRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job Foreign key</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedJobRefnum()
     { return (TILDA__JOBFILE_Factory.COLS.JOBREFNUM._Mask1 & __Changes1) != 0L; }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileName -> TILDA.JOBFILE."fileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Zip FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _fileName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileName -> TILDA.JOBFILE."fileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Zip FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFileName()
      { return _fileName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileName -> TILDA.JOBFILE."fileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Zip FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFileName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JOBFILE.fileName to null: it's not nullable.");
       else if (v.length() > 200)
        throw new Exception("Cannot set tilda.data.TILDA.JOBFILE.fileName: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 200.");
       else if (v.equals(_fileName) == false)
        {
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILENAME._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.FILENAME._Mask1;
       _fileName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileName -> TILDA.JOBFILE."fileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Zip FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileName()
     { return (TILDA__JOBFILE_Factory.COLS.FILENAME._Mask1 & __Changes1) != 0L; }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileRecords -> TILDA.JOBFILE."fileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Number of records loaded into DB</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _fileRecords= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileRecords -> TILDA.JOBFILE."fileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Number of records loaded into DB</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getFileRecords()
      { return _fileRecords; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileRecords -> TILDA.JOBFILE."fileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Number of records loaded into DB</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileRecords()
     { return (TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1 & __Nulls1) != 0L; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileRecords -> TILDA.JOBFILE."fileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Number of records loaded into DB</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFileRecords(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _fileRecords)
        {
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1;
       _fileRecords = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileRecords -> TILDA.JOBFILE."fileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Number of records loaded into DB</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullFileRecords()
     {
       long T0 = System.nanoTime();
       if ((TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1 & __Nulls1) != 0L)
        return;
       __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1;
       __Nulls1   |= TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1;
       _fileRecords=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileRecords -> TILDA.JOBFILE."fileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Number of records loaded into DB</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileRecords()
     { return (TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1 & __Changes1) != 0L; }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ -> TILDA.JOBFILE."fileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _fileProcessStartTimeTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ -> TILDA.JOBFILE."fileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFileProcessStartTimeTZ()
      { return _fileProcessStartTimeTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ -> TILDA.JOBFILE."fileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileProcessStartTimeTZ()
     { return (TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1 & __Nulls1) != 0L; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ -> TILDA.JOBFILE."fileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFileProcessStartTimeTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullFileProcessStartTimeTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5.");
       else if (v.equals(_fileProcessStartTimeTZ) == false)
        {
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1;
       _fileProcessStartTimeTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ -> TILDA.JOBFILE."fileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullFileProcessStartTimeTZ()
     {
       long T0 = System.nanoTime();
       if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1 & __Nulls1) != 0L)
        return;
       __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1;
       __Nulls1   |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1;
       _fileProcessStartTimeTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ -> TILDA.JOBFILE."fileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileProcessStartTimeTZ()
     { return (TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1 & __Changes1) != 0L; }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTime -> TILDA.JOBFILE."fileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _fileProcessStartTime;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTime -> TILDA.JOBFILE."fileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getFileProcessStartTime()
      { return _fileProcessStartTime; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTime -> TILDA.JOBFILE."fileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileProcessStartTime()
     { return (TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1 & __Nulls1) != 0L; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTime -> TILDA.JOBFILE."fileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFileProcessStartTime(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullFileProcessStartTime();
          setNullFileProcessStartTimeTZ();
        }
       else if (v.equals(_fileProcessStartTime) == false)
        {
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1;
       _fileProcessStartTime = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JOBFILE.fileProcessStartTime' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setFileProcessStartTimeTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTime -> TILDA.JOBFILE."fileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullFileProcessStartTime()
     {
       long T0 = System.nanoTime();
       if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1 & __Nulls1) != 0L)
        return;
       __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1;
       __Nulls1   |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1;
       _fileProcessStartTime=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTime -> TILDA.JOBFILE."fileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setFileProcessStartTimeNow() throws Exception
    {
      setFileProcessStartTime(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTime -> TILDA.JOBFILE."fileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setFileProcessStartTimeUndefined() throws Exception
    {
      setFileProcessStartTime(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTime -> TILDA.JOBFILE."fileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setFileProcessStartTime(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setFileProcessStartTime(DateTimeUtil.New(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTime -> TILDA.JOBFILE."fileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileProcessStartTime()
     { return (TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1 & __Changes1) != 0L; }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ -> TILDA.JOBFILE."fileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _fileProcessEndTimeTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ -> TILDA.JOBFILE."fileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFileProcessEndTimeTZ()
      { return _fileProcessEndTimeTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ -> TILDA.JOBFILE."fileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileProcessEndTimeTZ()
     { return (TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1 & __Nulls1) != 0L; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ -> TILDA.JOBFILE."fileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFileProcessEndTimeTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullFileProcessEndTimeTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5.");
       else if (v.equals(_fileProcessEndTimeTZ) == false)
        {
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1;
       _fileProcessEndTimeTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ -> TILDA.JOBFILE."fileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullFileProcessEndTimeTZ()
     {
       long T0 = System.nanoTime();
       if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1 & __Nulls1) != 0L)
        return;
       __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1;
       __Nulls1   |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1;
       _fileProcessEndTimeTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ -> TILDA.JOBFILE."fileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileProcessEndTimeTZ()
     { return (TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1 & __Changes1) != 0L; }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTime -> TILDA.JOBFILE."fileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _fileProcessEndTime;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTime -> TILDA.JOBFILE."fileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getFileProcessEndTime()
      { return _fileProcessEndTime; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTime -> TILDA.JOBFILE."fileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileProcessEndTime()
     { return (TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1 & __Nulls1) != 0L; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTime -> TILDA.JOBFILE."fileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFileProcessEndTime(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullFileProcessEndTime();
          setNullFileProcessEndTimeTZ();
        }
       else if (v.equals(_fileProcessEndTime) == false)
        {
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1;
       _fileProcessEndTime = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JOBFILE.fileProcessEndTime' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setFileProcessEndTimeTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTime -> TILDA.JOBFILE."fileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullFileProcessEndTime()
     {
       long T0 = System.nanoTime();
       if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1 & __Nulls1) != 0L)
        return;
       __Changes1 |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1;
       __Nulls1   |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1;
       _fileProcessEndTime=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTime -> TILDA.JOBFILE."fileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setFileProcessEndTimeNow() throws Exception
    {
      setFileProcessEndTime(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTime -> TILDA.JOBFILE."fileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setFileProcessEndTimeUndefined() throws Exception
    {
      setFileProcessEndTime(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTime -> TILDA.JOBFILE."fileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setFileProcessEndTime(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setFileProcessEndTime(DateTimeUtil.New(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTime -> TILDA.JOBFILE."fileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileProcessEndTime()
     { return (TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1 & __Changes1) != 0L; }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.created -> TILDA.JOBFILE."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.created of type timestamptz</TD></TR>

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
   ZonedDateTime _created;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.created -> TILDA.JOBFILE."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.created of type timestamptz</TD></TR>

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
   public final ZonedDateTime getCreated()
      { return _created; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.created -> TILDA.JOBFILE."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.created of type timestamptz</TD></TR>

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
    void setCreated(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JOBFILE.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JOBFILE.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.CREATED._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.CREATED._Mask1;
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.created -> TILDA.JOBFILE."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.created of type timestamptz</TD></TR>

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
    final void setCreatedNow() throws Exception
    {
      setCreated(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.created -> TILDA.JOBFILE."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.created of type timestamptz</TD></TR>

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
    final void setCreatedUndefined() throws Exception
    {
      setCreated(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.created -> TILDA.JOBFILE."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.created of type timestamptz</TD></TR>

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
    final void setCreated(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setCreated(DateTimeUtil.New(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.created -> TILDA.JOBFILE."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.created of type timestamptz</TD></TR>

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
   public boolean hasChangedCreated()
     { return (TILDA__JOBFILE_Factory.COLS.CREATED._Mask1 & __Changes1) != 0L; }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.lastUpdated -> TILDA.JOBFILE."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.lastUpdated of type timestamptz</TD></TR>

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
   ZonedDateTime _lastUpdated;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.lastUpdated -> TILDA.JOBFILE."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.lastUpdated of type timestamptz</TD></TR>

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
   public final ZonedDateTime getLastUpdated()
      { return _lastUpdated; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.lastUpdated -> TILDA.JOBFILE."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.lastUpdated of type timestamptz</TD></TR>

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
    void setLastUpdated(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JOBFILE.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.LASTUPDATED._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.LASTUPDATED._Mask1;
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.lastUpdated -> TILDA.JOBFILE."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.lastUpdated of type timestamptz</TD></TR>

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
    final void setLastUpdatedNow() throws Exception
    {
      setLastUpdated(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.lastUpdated -> TILDA.JOBFILE."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.lastUpdated of type timestamptz</TD></TR>

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
    final void setLastUpdatedUndefined() throws Exception
    {
      setLastUpdated(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.lastUpdated -> TILDA.JOBFILE."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.lastUpdated of type timestamptz</TD></TR>

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
    final void setLastUpdated(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setLastUpdated(DateTimeUtil.New(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.lastUpdated -> TILDA.JOBFILE."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.lastUpdated of type timestamptz</TD></TR>

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
   public boolean hasChangedLastUpdated()
     { return (TILDA__JOBFILE_Factory.COLS.LASTUPDATED._Mask1 & __Changes1) != 0L; }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.deleted -> TILDA.JOBFILE."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _deleted;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.deleted -> TILDA.JOBFILE."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDeleted()
      { return _deleted; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.deleted -> TILDA.JOBFILE."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDeleted()
     { return (TILDA__JOBFILE_Factory.COLS.DELETED._Mask1 & __Nulls1) != 0L; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.deleted -> TILDA.JOBFILE."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDeleted(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDeleted();
        }
       else if (v.equals(_deleted) == false)
        {
          __Changes1 |= TILDA__JOBFILE_Factory.COLS.DELETED._Mask1;
          __Nulls1   &= ~TILDA__JOBFILE_Factory.COLS.DELETED._Mask1;
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.deleted -> TILDA.JOBFILE."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDeleted()
     {
       long T0 = System.nanoTime();
       if ((TILDA__JOBFILE_Factory.COLS.DELETED._Mask1 & __Nulls1) != 0L)
        return;
       __Changes1 |= TILDA__JOBFILE_Factory.COLS.DELETED._Mask1;
       __Nulls1   |= TILDA__JOBFILE_Factory.COLS.DELETED._Mask1;
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.deleted -> TILDA.JOBFILE."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setDeletedNow() throws Exception
    {
      setDeleted(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.deleted -> TILDA.JOBFILE."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setDeletedUndefined() throws Exception
    {
      setDeleted(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.deleted -> TILDA.JOBFILE."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setDeleted(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDeleted(DateTimeUtil.New(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.deleted -> TILDA.JOBFILE."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleted()
     { return (TILDA__JOBFILE_Factory.COLS.DELETED._Mask1 & __Changes1) != 0L; }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void CopyTo(tilda.data._Tilda.TILDA__JOBFILE Dst) throws Exception
     {
       Dst.setJobRefnum             (_jobRefnum             );
       Dst.setFileName              (_fileName              );
       if ((TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1            & __Nulls1) != 0L) Dst.setNullFileRecords           (); else        Dst.setFileRecords           (_fileRecords           );
       if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1 & __Nulls1) != 0L) Dst.setNullFileProcessStartTimeTZ(); else        Dst.setFileProcessStartTimeTZ(_fileProcessStartTimeTZ);
       if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1   & __Nulls1) != 0L) Dst.setNullFileProcessStartTime  (); else        Dst.setFileProcessStartTime  (_fileProcessStartTime  );
       if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1   & __Nulls1) != 0L) Dst.setNullFileProcessEndTimeTZ  (); else        Dst.setFileProcessEndTimeTZ  (_fileProcessEndTimeTZ  );
       if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1     & __Nulls1) != 0L) Dst.setNullFileProcessEndTime    (); else        Dst.setFileProcessEndTime    (_fileProcessEndTime    );
       Dst.setLastUpdated           (_lastUpdated           );
       if ((TILDA__JOBFILE_Factory.COLS.DELETED._Mask1                & __Nulls1) != 0L) Dst.setNullDeleted               (); else        Dst.setDeleted               (_deleted               );
     }

/**
 Sets the 'lastUpdated' column to now and causes a Write to occur to update the object in the data store.
*/
   public final boolean Touch(Connection C) throws Exception
     {
       setLastUpdatedNow();
       return Write(C);
     }

/**
 Writes the object to the data store if any changes has occurred since the object was initially
 read from the data store or last written. 
*/
   public final boolean Write(Connection C) throws Exception
     {
       long T0 = System.nanoTime();
       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.JOBFILE has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__JOBFILE_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }

       StringBuilder S = new StringBuilder(1024);

       if (BeforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.JOBFILE object's BeforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__JOBFILE_Factory.SCHEMA_TABLENAME_LABEL, "");
          return false;
        }

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "JOBFILE");
          int Pos = S.length();
          if ((TILDA__JOBFILE_Factory.COLS.REFNUM._Mask1                 & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.REFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if ((TILDA__JOBFILE_Factory.COLS.JOBREFNUM._Mask1              & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.JOBREFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if ((TILDA__JOBFILE_Factory.COLS.FILENAME._Mask1               & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.FILENAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if ((TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1            & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.FILERECORDS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1 & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1   & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME.getFullColumnVarForInsert(C, S);
             V.append((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1 & __Nulls1) == 0L && DateTimeUtil.isNowPlaceholder(_fileProcessStartTime) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1   & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1     & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME.getFullColumnVarForInsert(C, S);
             V.append((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1 & __Nulls1) == 0L && DateTimeUtil.isNowPlaceholder(_fileProcessEndTime) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }

          if ((TILDA__JOBFILE_Factory.COLS.CREATED._Mask1                & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append((TILDA__JOBFILE_Factory.COLS.CREATED._Mask1 & __Nulls1) == 0L && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__JOBFILE_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if ((TILDA__JOBFILE_Factory.COLS.LASTUPDATED._Mask1            & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append((TILDA__JOBFILE_Factory.COLS.LASTUPDATED._Mask1 & __Nulls1) == 0L && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__JOBFILE_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if ((TILDA__JOBFILE_Factory.COLS.DELETED._Mask1                & __Changes1) != 0L) { TILDA__JOBFILE_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append((TILDA__JOBFILE_Factory.COLS.DELETED._Mask1 & __Nulls1) == 0L && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDA", "JOBFILE"); S.append(" set");
          int Pos = S.length();
          if ((TILDA__JOBFILE_Factory.COLS.REFNUM._Mask1                 & __Changes1) != 0L) TILDA__JOBFILE_Factory.COLS.REFNUM.getFullColumnVarForUpdate(C, S);
          if ((TILDA__JOBFILE_Factory.COLS.JOBREFNUM._Mask1              & __Changes1) != 0L) TILDA__JOBFILE_Factory.COLS.JOBREFNUM.getFullColumnVarForUpdate(C, S);
          if ((TILDA__JOBFILE_Factory.COLS.FILENAME._Mask1               & __Changes1) != 0L) TILDA__JOBFILE_Factory.COLS.FILENAME.getFullColumnVarForUpdate(C, S);
          if ((TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1            & __Changes1) != 0L) TILDA__JOBFILE_Factory.COLS.FILERECORDS.getFullColumnVarForUpdate(C, S);
          if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1 & __Changes1) != 0L) TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ.getFullColumnVarForUpdate(C, S);

          if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1 & __Changes1) != 0L)
           {
             if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1 & __Nulls1) == 0L && DateTimeUtil.isNowPlaceholder(_fileProcessStartTime) == true)
              { TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME.getFullColumnVarForUpdate(C, S);
           }
          if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1   & __Changes1) != 0L) TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ.getFullColumnVarForUpdate(C, S);

          if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1 & __Changes1) != 0L)
           {
             if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1 & __Nulls1) == 0L && DateTimeUtil.isNowPlaceholder(_fileProcessEndTime) == true)
              { TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME.getFullColumnVarForUpdate(C, S);
           }

          if ((TILDA__JOBFILE_Factory.COLS.CREATED._Mask1 & __Changes1) != 0L)
           {
             if ((TILDA__JOBFILE_Factory.COLS.CREATED._Mask1 & __Nulls1) == 0L && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__JOBFILE_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBFILE_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if ((TILDA__JOBFILE_Factory.COLS.LASTUPDATED._Mask1 & __Changes1) != 0L)
           {
             if ((TILDA__JOBFILE_Factory.COLS.LASTUPDATED._Mask1 & __Nulls1) == 0L && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__JOBFILE_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBFILE_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__JOBFILE_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if ((TILDA__JOBFILE_Factory.COLS.DELETED._Mask1 & __Changes1) != 0L)
           {
             if ((TILDA__JOBFILE_Factory.COLS.DELETED._Mask1 & __Nulls1) == 0L && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__JOBFILE_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOBFILE_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0:
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JOBFILE", "refnum"); S.append("=?)");
                break;
             case 1:
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JOBFILE", "jobRefnum"); S.append("=?)");
                break;
             case -666: if (__Init == InitMode.CREATE) break;
             default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
           }
          S.setCharAt(Pos, ' ');
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__JOBFILE_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.JOBFILE", Q, toString());
       java.sql.PreparedStatement PS = null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
               if ((TILDA__JOBFILE_Factory.COLS.REFNUM._Mask1                 & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.REFNUM._Mask1                 & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _refnum);
                } 
               if ((TILDA__JOBFILE_Factory.COLS.JOBREFNUM._Mask1              & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.JOBREFNUM._Mask1              & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _jobRefnum);
                } 
               if ((TILDA__JOBFILE_Factory.COLS.FILENAME._Mask1               & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.FILENAME._Mask1               & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _fileName);
                } 
               if ((TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1            & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1            & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _fileRecords);
                } 
               if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1 & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1 & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _fileProcessStartTimeTZ);
                } 
               if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1   & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1   & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_fileProcessStartTime) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_fileProcessStartTime.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
                } 
               if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1   & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1   & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _fileProcessEndTimeTZ);
                } 
               if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1     & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1     & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_fileProcessEndTime) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_fileProcessEndTime.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
                } 
               if ((TILDA__JOBFILE_Factory.COLS.CREATED._Mask1                & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.CREATED._Mask1                & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_created.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
                } 
               if ((TILDA__JOBFILE_Factory.COLS.LASTUPDATED._Mask1            & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.LASTUPDATED._Mask1            & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_lastUpdated.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
                } 
               if ((TILDA__JOBFILE_Factory.COLS.DELETED._Mask1                & __Changes1) != 0L) 
                { 
                  if ((TILDA__JOBFILE_Factory.COLS.DELETED._Mask1                & __Nulls1  ) != 0L) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_deleted.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
                } 

          switch (__LookupId)
           {
             case 0:
               PS.setLong     (++i, _refnum                );
               break;
             case 1:
               PS.setLong     (++i, _jobRefnum             );
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
          return tilda.data._Tilda.TILDA__1_0.HandleCatch(C, E, "updated or inserted");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__JOBFILE_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

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
             __Saved_refnum                 = _refnum                ;
             break;
          case 1:
             __Saved_jobRefnum              = _jobRefnum             ;
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
        }

       __Changes1= __Changes2= __Changes3= __Changes4= __Nulls1= __Nulls2= __Nulls3= __Nulls4= 0L;
       return true;
     }

   protected abstract boolean BeforeWrite(Connection C) throws Exception;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   public final boolean Refresh(Connection C) throws Exception
     {
       return ReadOne(C, true);
     }

   public final boolean Read(Connection C) throws Exception
     {
       return ReadOne(C, false);
     }

   private final boolean ReadOne(Connection C, boolean Force) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE)
        throw new Exception("This TILDA.JOBFILE object is being Read() after a Create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.JOBFILE object has already been read.");
          QueryDetails.setLastQuery(TILDA__JOBFILE_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "refnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "jobRefnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileProcessStartTimeTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileProcessStartTime");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileProcessEndTimeTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileProcessEndTime");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "created");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "lastUpdated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "deleted");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "JOBFILE");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JOBFILE", "refnum"); S.append("=?)");
             break;
          case 1:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "JOBFILE", "jobRefnum"); S.append("=?)");
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__JOBFILE_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.JOBFILE", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       int count = 0;

       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
          switch (__LookupId)
           {
             case 0:
               PS.setLong     (++i, _refnum                );
               break;
             case 1:
               PS.setLong     (++i, _jobRefnum             );
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
          return Init(C, RS);
        }
       catch (java.sql.SQLException E)
        {
          return tilda.data._Tilda.TILDA__1_0.HandleCatch(C, E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__JOBFILE_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_refnum                 = _refnum                 =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__JOBFILE_Factory.COLS.REFNUM._Mask1                ;
      __Saved_jobRefnum              = _jobRefnum              =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__JOBFILE_Factory.COLS.JOBREFNUM._Mask1             ;
                                       _fileName               = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__JOBFILE_Factory.COLS.FILENAME._Mask1              ;
                                       _fileRecords            =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1           ;
                                       _fileProcessStartTimeTZ = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask1; else _fileProcessStartTimeTZ = _fileProcessStartTimeTZ.trim();
                                       _fileProcessStartTime   = ProcessZDT(_fileProcessStartTimeTZ  , "tilda.data.TILDA.JOBFILE.fileProcessStartTime"  , RS, ++i, TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME  , TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIMETZ  );
                                       _fileProcessEndTimeTZ   = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ._Mask1  ; else _fileProcessEndTimeTZ   = _fileProcessEndTimeTZ  .trim();
                                       _fileProcessEndTime     = ProcessZDT(_fileProcessEndTimeTZ    , "tilda.data.TILDA.JOBFILE.fileProcessEndTime"    , RS, ++i, TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME    , TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIMETZ    );
                                       _created                = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null);
                                       _lastUpdated            = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null);
                                       _deleted                = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null);
     __LookupId = 0;
     __Init     = InitMode.READ;
     __Changes1  = 0L;
     __Changes2  = 0L;
     __Changes3  = 0L;
     __Changes4  = 0L;
     return AfterRead(C);
   }

  private final ZonedDateTime ProcessZDT(String TimezoneId, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)
  throws Exception
   {
     tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(TimezoneId);
     if (ZI == null && TextUtil.isNullOrEmpty(TimezoneId) == false)
      throw new Exception("Cannot set field '"+DTFieldName+"' because the timezone Id '" + TimezoneId + "' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
     ZonedDateTime ZDT = DateTimeUtil.toZonedDateTime(RS.getTimestamp(ColumnPos, DateTimeUtil._UTC_CALENDAR), ZI == null ? "null" : ZI.getValue());
     if (RS.wasNull() == true)
      if (DTField._MaskId == 1)
       __Nulls1 |= DTField._Mask1;
      else if (DTField._MaskId == 2)
       __Nulls2 |= DTField._Mask2;
      else if (DTField._MaskId == 3)
       __Nulls3 |= DTField._Mask3;
      else if (DTField._MaskId == 4)
       __Nulls4 |= DTField._Mask4;
      else
       throw new Error("RUNTIME TILDA ERROR: Invalid MaskId="+DTField._MaskId+" for column "+DTFieldName+". Values should be between 1 and 4.");
     boolean DTNull = DTField._MaskId == 1 ? (__Nulls1 & DTField._Mask1) != 0L
                    : DTField._MaskId == 2 ? (__Nulls2 & DTField._Mask2) != 0L
                    : DTField._MaskId == 3 ? (__Nulls3 & DTField._Mask3) != 0L
                                           : (__Nulls4 & DTField._Mask4) != 0L
                                           ;
     boolean TZNull = TZField._MaskId == 1 ? (__Nulls1 & TZField._Mask1) != 0L
                    : TZField._MaskId == 2 ? (__Nulls2 & TZField._Mask2) != 0L
                    : TZField._MaskId == 3 ? (__Nulls3 & TZField._Mask3) != 0L
                                           : (__Nulls4 & TZField._Mask4) != 0L
                                           ;
     if (DTNull == false && TZNull == true)
      throw new Exception("The field "+DTFieldName+" is not null while its associated timezone field '"+DTFieldName+"TZ' is null. A TZ is mandatory for not null timestamps.");
     return ZDT;
   }

   protected abstract boolean AfterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "refnum: "                                                                                                                  +                                   getRefnum                () 
               + "; jobRefnum: "                                                                                                               +                                   getJobRefnum             () 
               + "; fileName: "                                                                                                                + TextUtil.PrintVariableStr        (getFileName              ())
               + "; fileRecords"              + ((TILDA__JOBFILE_Factory.COLS.FILERECORDS._Mask1            & __Nulls1) != 0L ? ": NULL" : ": " +                                   getFileRecords           () )
               + "; fileProcessStartTime"     + ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSSTARTTIME._Mask1   & __Nulls1) != 0L ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getFileProcessStartTime  ()))
               + "; fileProcessEndTime"       + ((TILDA__JOBFILE_Factory.COLS.FILEPROCESSENDTIME._Mask1     & __Nulls1) != 0L ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getFileProcessEndTime    ()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }
 }
