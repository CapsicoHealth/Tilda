/*
 Tilda V1.0 data object.

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
<TABLE id="Job_Detail_DIV" class="tables">
<SCRIPT>registerStickyHeader("Job_Detail_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Job_Detail&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Job_Detail_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Job_Detail_CNT" class="content">
The Table TILDA.Job_Detail:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Job_Detail_Factory</B>, <B>Job_Detail_Data</B> in the package <B>tilda.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Defines foreign key(s) to <A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A> </LI>
<LI>Has the following identity:<UL><LI>Unique Index: Id, Job_Id</LI>
</UL></LI>
</UL>
<B>Description</B>: Job Detail<BR>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="Job_Detail_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-Id_DIV' class='columns'>Id</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Id</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-Job_Id_DIV' class='columns'>Job_Id</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job Id</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-FileName_DIV' class='columns'>FileName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(200)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>FileName</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-FileRecords_DIV' class='columns'>FileRecords</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>FileRecords</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('Job_Detail-FileProcessStartTimeTZ')" align="right"><B id='Job_Detail-FileProcessStartTimeTZ_DIV' class='columns dotted_underline cursor_pointer'>FileProcessStartTimeTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'FileProcessStartTime'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-FileProcessStartTime_DIV' class='columns'>FileProcessStartTime</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>FileProcessStartTime</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>7&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('Job_Detail-FileProcessEndTimeTZ')" align="right"><B id='Job_Detail-FileProcessEndTimeTZ_DIV' class='columns dotted_underline cursor_pointer'>FileProcessEndTimeTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'FileProcessEndTime'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-FileProcessEndTime_DIV' class='columns'>FileProcessEndTime</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>FileProcessEndTime</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-Status_DIV' class='columns'>Status</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(200)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Status</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-Error_DIV' class='columns'>Error</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(1000)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Error</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='Job_Detail-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted.</TD>
</TR>
</TABLE></BLOCKQUOTE>
<DIV id='Job_Detail-Id_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-Id_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-Id_DIV'>Id</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-Job_Id_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-Job_Id_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-Job_Id_DIV'>Job_Id</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-FileName_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-FileName_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-FileName_DIV'>FileName</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-FileRecords_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-FileRecords_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-FileRecords_DIV'>FileRecords</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-FileProcessStartTimeTZ_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-FileProcessStartTimeTZ_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-FileProcessStartTimeTZ_DIV'>FileProcessStartTimeTZ</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo_DIV'>ZoneInfo</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo-id_DIV'>id</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-FileProcessStartTime_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-FileProcessStartTime_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-FileProcessStartTime_DIV'>FileProcessStartTime</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-FileProcessEndTimeTZ_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-FileProcessEndTimeTZ_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-FileProcessEndTimeTZ_DIV'>FileProcessEndTimeTZ</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo_DIV'>ZoneInfo</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo-id_DIV'>id</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-FileProcessEndTime_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-FileProcessEndTime_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-FileProcessEndTime_DIV'>FileProcessEndTime</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-Status_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-Status_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-Status_DIV'>Status</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-Error_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-Error_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-Error_DIV'>Error</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-created_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-created_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-created_DIV'>created</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-lastUpdated_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-lastUpdated_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-lastUpdated_DIV'>lastUpdated</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='Job_Detail-deleted_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Job_Detail-deleted_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail_DIV'>Job_Detail</a></td>
<td><a href='TILDA___Docs.TILDA.html#Job_Detail-deleted_DIV'>deleted</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
</DIV>

 @author   Tilda code gen for Java 8/PostgreSQL
 @version  Tilda 1.0
 @generated Aug 8 2018, 22:43:58EDT
*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__JOB_DETAIL implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__JOB_DETAIL.class.getName());

   public static final Class<TILDA__JOB_DETAIL_Factory> FACTORY_CLASS= TILDA__JOB_DETAIL_Factory.class;
   public static final String TABLENAME = TextUtil.Print("TILDA.Job_Detail", "");

   protected TILDA__JOB_DETAIL() { }

   InitMode __Init        = null;
   private BitSet   __Nulls       = new BitSet(64);
   BitSet   __Changes     = new BitSet(64);
   private boolean  __NewlyCreated= false;
   private int      __LookupId;

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
//   Field tilda.data.TILDA.Job_Detail.Id -> TILDA.Job_Detail."Id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Id of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Id of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _Id= SystemValues.EVIL_VALUE;
   protected int __Saved_Id;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Id -> TILDA.Job_Detail."Id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Id of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Id of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getId()
      { return _Id; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Id -> TILDA.Job_Detail."Id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Id of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Id of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setId(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _Id)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.ID._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.ID._Mask);
       _Id = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Id -> TILDA.Job_Detail."Id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Id of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Id of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedId()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.ID._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Job_Id -> TILDA.Job_Detail."Job_Id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Job_Id of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Job_Id of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job Id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _Job_Id= SystemValues.EVIL_VALUE;
   protected int __Saved_Job_Id;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Job_Id -> TILDA.Job_Detail."Job_Id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Job_Id of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Job_Id of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job Id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getJob_Id()
      { return _Job_Id; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Job_Id -> TILDA.Job_Detail."Job_Id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Job_Id of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Job_Id of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job Id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setJob_Id(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _Job_Id)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.JOB_ID._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.JOB_ID._Mask);
       _Job_Id = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Job_Id -> TILDA.Job_Detail."Job_Id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Job_Id of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Job_Id of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job Id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedJob_Id()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.JOB_ID._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileName -> TILDA.Job_Detail."FileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _FileName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileName -> TILDA.Job_Detail."FileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFileName()
      { return _FileName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileName -> TILDA.Job_Detail."FileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileName()
     { return __Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileName -> TILDA.Job_Detail."FileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFileName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullFileName();
        }
       else if (v.length() > 200)
        throw new Exception("Cannot set tilda.data.TILDA.Job_Detail.FileName: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 200.");
       else if (v.equals(_FileName) == false)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask);
       _FileName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileName -> TILDA.Job_Detail."FileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullFileName()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask);
       __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask);
       _FileName=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileName -> TILDA.Job_Detail."FileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileName()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileRecords -> TILDA.Job_Detail."FileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileRecords</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _FileRecords= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileRecords -> TILDA.Job_Detail."FileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileRecords</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getFileRecords()
      { return _FileRecords; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileRecords -> TILDA.Job_Detail."FileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileRecords</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileRecords()
     { return __Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileRecords -> TILDA.Job_Detail."FileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileRecords</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFileRecords(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _FileRecords)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask);
       _FileRecords = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileRecords -> TILDA.Job_Detail."FileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileRecords</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullFileRecords()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask);
       __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask);
       _FileRecords=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileRecords -> TILDA.Job_Detail."FileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileRecords</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileRecords()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ -> TILDA.Job_Detail."FileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _FileProcessStartTimeTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ -> TILDA.Job_Detail."FileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFileProcessStartTimeTZ()
      { return _FileProcessStartTimeTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ -> TILDA.Job_Detail."FileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileProcessStartTimeTZ()
     { return __Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ -> TILDA.Job_Detail."FileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessStartTime'.</TD></TR>
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
        throw new Exception("Cannot set tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5.");
       else if (v.equals(_FileProcessStartTimeTZ) == false)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask);
       _FileProcessStartTimeTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ -> TILDA.Job_Detail."FileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullFileProcessStartTimeTZ()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask);
       __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask);
       _FileProcessStartTimeTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ -> TILDA.Job_Detail."FileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileProcessStartTimeTZ()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTime -> TILDA.Job_Detail."FileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _FileProcessStartTime;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTime -> TILDA.Job_Detail."FileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getFileProcessStartTime()
      { return _FileProcessStartTime; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTime -> TILDA.Job_Detail."FileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileProcessStartTime()
     { return __Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTime -> TILDA.Job_Detail."FileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTime of type timestamptz</TD></TR>

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
        }
       else if (v.equals(_FileProcessStartTime) == false)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask);
       _FileProcessStartTime = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Job_Detail.FileProcessStartTime' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setFileProcessStartTimeTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTime -> TILDA.Job_Detail."FileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTime of type timestamptz</TD></TR>

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
       if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask);
       __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask);
       _FileProcessStartTime=null;
       setNullFileProcessStartTimeTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTime -> TILDA.Job_Detail."FileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTime of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTime -> TILDA.Job_Detail."FileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTime of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTime -> TILDA.Job_Detail."FileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTime of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.FileProcessStartTime -> TILDA.Job_Detail."FileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileProcessStartTime()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ -> TILDA.Job_Detail."FileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _FileProcessEndTimeTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ -> TILDA.Job_Detail."FileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFileProcessEndTimeTZ()
      { return _FileProcessEndTimeTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ -> TILDA.Job_Detail."FileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileProcessEndTimeTZ()
     { return __Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ -> TILDA.Job_Detail."FileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessEndTime'.</TD></TR>
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
        throw new Exception("Cannot set tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5.");
       else if (v.equals(_FileProcessEndTimeTZ) == false)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask);
       _FileProcessEndTimeTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ -> TILDA.Job_Detail."FileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullFileProcessEndTimeTZ()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask);
       __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask);
       _FileProcessEndTimeTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ -> TILDA.Job_Detail."FileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileProcessEndTimeTZ()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTime -> TILDA.Job_Detail."FileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _FileProcessEndTime;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTime -> TILDA.Job_Detail."FileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getFileProcessEndTime()
      { return _FileProcessEndTime; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTime -> TILDA.Job_Detail."FileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFileProcessEndTime()
     { return __Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTime -> TILDA.Job_Detail."FileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTime of type timestamptz</TD></TR>

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
        }
       else if (v.equals(_FileProcessEndTime) == false)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask);
       _FileProcessEndTime = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Job_Detail.FileProcessEndTime' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setFileProcessEndTimeTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTime -> TILDA.Job_Detail."FileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTime of type timestamptz</TD></TR>

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
       if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask);
       __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask);
       _FileProcessEndTime=null;
       setNullFileProcessEndTimeTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTime -> TILDA.Job_Detail."FileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTime of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTime -> TILDA.Job_Detail."FileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTime of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTime -> TILDA.Job_Detail."FileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTime of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.FileProcessEndTime -> TILDA.Job_Detail."FileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.FileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.FileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFileProcessEndTime()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Status -> TILDA.Job_Detail."Status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Status of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Status of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _Status;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Status -> TILDA.Job_Detail."Status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Status of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Status of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getStatus()
      { return _Status; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Status -> TILDA.Job_Detail."Status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Status of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Status of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullStatus()
     { return __Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Status -> TILDA.Job_Detail."Status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Status of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Status of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setStatus(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullStatus();
        }
       else if (v.length() > 200)
        throw new Exception("Cannot set tilda.data.TILDA.Job_Detail.Status: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 200.");
       else if (v.equals(_Status) == false)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask);
       _Status = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Status -> TILDA.Job_Detail."Status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Status of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Status of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullStatus()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask);
       __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask);
       _Status=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Status -> TILDA.Job_Detail."Status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Status of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Status of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedStatus()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Error -> TILDA.Job_Detail."Error"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Error of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Error of type varchar(1000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>1000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Error</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _Error;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Error -> TILDA.Job_Detail."Error"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Error of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Error of type varchar(1000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>1000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Error</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getError()
      { return _Error; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Error -> TILDA.Job_Detail."Error"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Error of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Error of type varchar(1000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>1000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Error</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullError()
     { return __Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Error -> TILDA.Job_Detail."Error"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Error of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Error of type varchar(1000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>1000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Error</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setError(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullError();
        }
       else if (v.length() > 1000)
        throw new Exception("Cannot set tilda.data.TILDA.Job_Detail.Error: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 1000.");
       else if (v.equals(_Error) == false)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask);
       _Error = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Error -> TILDA.Job_Detail."Error"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Error of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Error of type varchar(1000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>1000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Error</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullError()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask);
       __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask);
       _Error=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.Error -> TILDA.Job_Detail."Error"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.Error of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.Error of type varchar(1000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>1000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Error</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedError()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.created -> TILDA.Job_Detail."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.created of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.created -> TILDA.Job_Detail."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.created of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.created -> TILDA.Job_Detail."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.created of type timestamptz</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.Job_Detail.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Job_Detail.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask);
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.created -> TILDA.Job_Detail."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.created of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.created -> TILDA.Job_Detail."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.created of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.created -> TILDA.Job_Detail."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.created of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.created -> TILDA.Job_Detail."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.created of type timestamptz</TD></TR>

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
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.lastUpdated -> TILDA.Job_Detail."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.lastUpdated of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.lastUpdated -> TILDA.Job_Detail."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.lastUpdated of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.lastUpdated -> TILDA.Job_Detail."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.lastUpdated of type timestamptz</TD></TR>

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
   public final void setLastUpdated(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.Job_Detail.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.lastUpdated -> TILDA.Job_Detail."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.lastUpdated of type timestamptz</TD></TR>

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
   public final void setLastUpdatedNow() throws Exception
    {
      setLastUpdated(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.lastUpdated -> TILDA.Job_Detail."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.lastUpdated of type timestamptz</TD></TR>

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
   public final void setLastUpdatedUndefined() throws Exception
    {
      setLastUpdated(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.lastUpdated -> TILDA.Job_Detail."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.lastUpdated of type timestamptz</TD></TR>

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
   public final void setLastUpdated(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setLastUpdated(DateTimeUtil.New(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.lastUpdated -> TILDA.Job_Detail."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.lastUpdated of type timestamptz</TD></TR>

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
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.deleted -> TILDA.Job_Detail."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.deleted of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.deleted -> TILDA.Job_Detail."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.deleted of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Job_Detail.deleted -> TILDA.Job_Detail."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDeleted()
     { return __Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.deleted -> TILDA.Job_Detail."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
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
          __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask);
          __Nulls.andNot(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask);
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.deleted -> TILDA.Job_Detail."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setNullDeleted()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask);
       __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask);
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.deleted -> TILDA.Job_Detail."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
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
//   Field tilda.data.TILDA.Job_Detail.deleted -> TILDA.Job_Detail."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
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
//   Field tilda.data.TILDA.Job_Detail.deleted -> TILDA.Job_Detail."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDeleted(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDeleted(DateTimeUtil.New(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Job_Detail.deleted -> TILDA.Job_Detail."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Job_Detail.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Job_Detail.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleted()
     { return __Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void CopyTo(tilda.data._Tilda.TILDA__JOB_DETAIL Dst) throws Exception
     {
       Dst.setId                    (_Id                    );
       Dst.setJob_Id                (_Job_Id                );
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask) == true) Dst.setNullFileName              (); else        Dst.setFileName              (_FileName              );
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask) == true) Dst.setNullFileRecords           (); else        Dst.setFileRecords           (_FileRecords           );
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask) == true) Dst.setNullFileProcessStartTimeTZ(); else        Dst.setFileProcessStartTimeTZ(_FileProcessStartTimeTZ);
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask) == true) Dst.setNullFileProcessStartTime  (); else        Dst.setFileProcessStartTime  (_FileProcessStartTime  );
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask) == true) Dst.setNullFileProcessEndTimeTZ  (); else        Dst.setFileProcessEndTimeTZ  (_FileProcessEndTimeTZ  );
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask) == true) Dst.setNullFileProcessEndTime    (); else        Dst.setFileProcessEndTime    (_FileProcessEndTime    );
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask) == true) Dst.setNullStatus                (); else        Dst.setStatus                (_Status                );
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask) == true) Dst.setNullError                 (); else        Dst.setError                 (_Error                 );
       Dst.setLastUpdated           (_lastUpdated           );
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask) == true) Dst.setNullDeleted               (); else        Dst.setDeleted               (_deleted               );
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
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_FileProcessStartTime) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_FileProcessEndTime) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_created) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_deleted) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "Job_Detail");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.ID._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.ID.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.JOB_ID._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.JOB_ID.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.FILENAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask) == false && DateTimeUtil.isNowPlaceholder(_FileProcessStartTime) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask) == false && DateTimeUtil.isNowPlaceholder(_FileProcessEndTime) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.STATUS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.ERROR.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__JOB_DETAIL_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask) == true) { TILDA__JOB_DETAIL_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDA", "Job_Detail"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.ID._Mask) == true) TILDA__JOB_DETAIL_Factory.COLS.ID.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.JOB_ID._Mask) == true) TILDA__JOB_DETAIL_Factory.COLS.JOB_ID.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask) == true) TILDA__JOB_DETAIL_Factory.COLS.FILENAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask) == true) TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask) == true) TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask) == false && DateTimeUtil.isNowPlaceholder(_FileProcessStartTime) == true)
              { TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask) == true) TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask) == false && DateTimeUtil.isNowPlaceholder(_FileProcessEndTime) == true)
              { TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask) == true) TILDA__JOB_DETAIL_Factory.COLS.STATUS.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask) == true) TILDA__JOB_DETAIL_Factory.COLS.ERROR.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__JOB_DETAIL_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOB_DETAIL_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__JOB_DETAIL_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__JOB_DETAIL_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0:
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Job_Detail", "Id"); S.append("=? AND "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "Job_Id"); S.append("=?)");
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
       QueryDetails.setLastQuery(TILDA__JOB_DETAIL_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.Job_Detail", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.ID._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.ID._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _Id);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.JOB_ID._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.JOB_ID._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _Job_Id);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _FileName);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _FileRecords);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _FileProcessStartTimeTZ);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_FileProcessStartTime) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_FileProcessStartTime.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _FileProcessEndTimeTZ);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_FileProcessEndTime) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_FileProcessEndTime.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _Status);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _Error);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_created.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_lastUpdated.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_deleted.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
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
             __Saved_Id                     = _Id                    ;
             __Saved_Job_Id                 = _Job_Id                ;
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
        }

       __Changes.clear();
       __Nulls.clear();
     }
   public final boolean Write(Connection C) throws Exception
     {
       long T0 = System.nanoTime();
       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.Job_Detail has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__JOB_DETAIL_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }

       if (BeforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.Job_Detail object's BeforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__JOB_DETAIL_Factory.SCHEMA_TABLENAME_LABEL, "");
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
             case 0:
               PS.setInt      (++i, _Id                    );
               PS.setInt      (++i, _Job_Id                );
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__JOB_DETAIL_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

       stateUpdatePostWrite();
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
        throw new Exception("This TILDA.Job_Detail object is being Read() after a Create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.Job_Detail object has already been read.");
          QueryDetails.setLastQuery(TILDA__JOB_DETAIL_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "Id");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "Job_Id");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "FileName");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "FileRecords");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "FileProcessStartTimeTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "FileProcessStartTime");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "FileProcessEndTimeTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "FileProcessEndTime");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "Status");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "Error");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "created");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "deleted");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "Job_Detail");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Job_Detail", "Id"); S.append("=? AND "); C.getFullColumnVar(S, "TILDA", "Job_Detail", "Job_Id"); S.append("=?)");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__JOB_DETAIL_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.Job_Detail", Q, toString());
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
               PS.setInt      (++i, _Id                    );
               PS.setInt      (++i, _Job_Id                );
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__JOB_DETAIL_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_Id                     = _Id                     =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.ID._Mask                    );
      __Saved_Job_Id                 = _Job_Id                 =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.JOB_ID._Mask                );
                                       _FileName               = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask              );
                                       _FileRecords            =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask           );
                                       _FileProcessStartTimeTZ = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ._Mask); else _FileProcessStartTimeTZ = _FileProcessStartTimeTZ.trim();
                                       _FileProcessStartTime   = ProcessZDT(_FileProcessStartTimeTZ  , "tilda.data.TILDA.Job_Detail.FileProcessStartTime"  , RS, ++i, TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME  , TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIMETZ  ); if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask  );
                                       _FileProcessEndTimeTZ   = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ._Mask  ); else _FileProcessEndTimeTZ   = _FileProcessEndTimeTZ  .trim();
                                       _FileProcessEndTime     = ProcessZDT(_FileProcessEndTimeTZ    , "tilda.data.TILDA.Job_Detail.FileProcessEndTime"    , RS, ++i, TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME    , TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIMETZ    ); if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask    );
                                       _Status                 = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask                );
                                       _Error                  = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask                 );
                                       _created                = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.CREATED._Mask               );
                                       _lastUpdated            = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.LASTUPDATED._Mask           );
                                       _deleted                = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__JOB_DETAIL_Factory.COLS.DELETED._Mask               );
     __LookupId = 0;
     __Init     = InitMode.READ;
     __Changes.clear();
     return AfterRead(C);
   }

  private final ZonedDateTime ProcessZDT(String TimezoneId, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)
  throws Exception
   {
     tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(TimezoneId);
     if (ZI == null && TextUtil.isNullOrEmpty(TimezoneId) == false)
      throw new Exception("Cannot set field '"+DTFieldName+"' because the timezone Id '" + TimezoneId + "' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
     ZonedDateTime ZDT = DateTimeUtil.toZonedDateTime(RS.getTimestamp(ColumnPos, DateTimeUtil._UTC_CALENDAR), ZI == null ? "null" : ZI.getValue());
     boolean DTNull = false;
     if (RS.wasNull() == true)
      {
         __Nulls.or(DTField._Mask);
         DTNull = true;
      }
     boolean TZNull = __Nulls.intersects(TZField._Mask);
     if (DTNull == false && TZNull == true)
      throw new Exception("The field "+DTFieldName+" is not null while its associated timezone field '"+DTFieldName+"TZ' is null. A TZ is mandatory for not null timestamps.");
     return ZDT;
   }

   protected abstract boolean AfterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "Id: "                                                                                                                        +                                   getId                    () 
               + "; Job_Id: "                                                                                                                    +                                   getJob_Id                () 
               + "; FileName"                 + (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILENAME._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getFileName              ()))
               + "; FileRecords"              + (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILERECORDS._Mask) == true ? ": NULL" : ": " +                                   getFileRecords           () )
               + "; FileProcessStartTime"     + (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSSTARTTIME._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getFileProcessStartTime  ()))
               + "; FileProcessEndTime"       + (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.FILEPROCESSENDTIME._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getFileProcessEndTime    ()))
               + "; Status"                   + (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.STATUS._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getStatus                ()))
               + "; Error"                    + (__Nulls.intersects(TILDA__JOB_DETAIL_Factory.COLS.ERROR._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getError                 ()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
