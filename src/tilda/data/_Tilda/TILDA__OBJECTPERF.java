/*
 Tilda V1.0 data object.

 Code is generated: do not modify! Instead, create a derived class and override desired functionality
*/

package tilda.data._Tilda;

import java.time.*;
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
<TABLE id="ObjectPerf_DIV" class="tables">
<SCRIPT>registerStickyHeader("ObjectPerf_DIV");</SCRIPT>
<TR valign="top"><TD><H2>ObjectPerf&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#ObjectPerf_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="ObjectPerf_CNT" class="content">
The Table TILDA.ObjectPerf:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>ObjectPerf_Factory</B>, <B>ObjectPerf_Data</B> in the package <B>tilda.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Defines foreign key(s) to <A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A> </LI>
<LI>Has the following identity:<UL><LI>Primary Key: schemaName, objectName, startPeriod</LI>
</UL></LI>
</UL>
<B>Description</B>: Performance logs for the Tilda framework<BR>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="ObjectPerf_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-schemaName_DIV' class='columns'>schemaName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the schema tracked</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-objectName_DIV' class='columns'>objectName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the table/object tracked</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('ObjectPerf-startPeriodTZ')" align="right"><B id='ObjectPerf-startPeriodTZ_DIV' class='columns dotted_underline cursor_pointer'>startPeriodTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'startPeriod'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-startPeriod_DIV' class='columns'>startPeriod</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('ObjectPerf-endPeriodTZ')" align="right"><B id='ObjectPerf-endPeriodTZ_DIV' class='columns dotted_underline cursor_pointer'>endPeriodTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'endPeriod'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-endPeriod_DIV' class='columns'>endPeriod</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-selectNano_DIV' class='columns'>selectNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-selectCount_DIV' class='columns'>selectCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-selectRecords_DIV' class='columns'>selectRecords</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-insertNano_DIV' class='columns'>insertNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-insertCount_DIV' class='columns'>insertCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-insertRecords_DIV' class='columns'>insertRecords</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-updateNano_DIV' class='columns'>updateNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-updateCount_DIV' class='columns'>updateCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-updateRecords_DIV' class='columns'>updateRecords</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-deleteNano_DIV' class='columns'>deleteNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-deleteCount_DIV' class='columns'>deleteCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-deleteRecords_DIV' class='columns'>deleteRecords</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>20&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>21&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted.</TD>
</TR>
</TABLE></BLOCKQUOTE>
<DIV id='ObjectPerf-schemaName_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-schemaName_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-schemaName_DIV'>schemaName</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-objectName_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-objectName_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-objectName_DIV'>objectName</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-startPeriodTZ_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-startPeriodTZ_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-startPeriodTZ_DIV'>startPeriodTZ</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo_DIV'>ZoneInfo</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo-id_DIV'>id</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-startPeriod_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-startPeriod_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-startPeriod_DIV'>startPeriod</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-endPeriodTZ_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-endPeriodTZ_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-endPeriodTZ_DIV'>endPeriodTZ</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo_DIV'>ZoneInfo</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo-id_DIV'>id</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-endPeriod_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-endPeriod_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-endPeriod_DIV'>endPeriod</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-selectNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-selectNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-selectNano_DIV'>selectNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-selectCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-selectCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-selectCount_DIV'>selectCount</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-selectRecords_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-selectRecords_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-selectRecords_DIV'>selectRecords</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-insertNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-insertNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-insertNano_DIV'>insertNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-insertCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-insertCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-insertCount_DIV'>insertCount</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-insertRecords_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-insertRecords_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-insertRecords_DIV'>insertRecords</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-updateNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-updateNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-updateNano_DIV'>updateNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-updateCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-updateCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-updateCount_DIV'>updateCount</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-updateRecords_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-updateRecords_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-updateRecords_DIV'>updateRecords</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-deleteNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-deleteNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-deleteNano_DIV'>deleteNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-deleteCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-deleteCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-deleteCount_DIV'>deleteCount</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-deleteRecords_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-deleteRecords_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-deleteRecords_DIV'>deleteRecords</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-created_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-created_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-created_DIV'>created</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-lastUpdated_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-lastUpdated_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-lastUpdated_DIV'>lastUpdated</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='ObjectPerf-deleted_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('ObjectPerf-deleted_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf_DIV'>ObjectPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#ObjectPerf-deleted_DIV'>deleted</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
</DIV>

 @author   Tilda code gen for Java 8/PostgreSQL
 @version  Tilda 1.0
 @generated Jun 14 2018, 23:17:30EDT
*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__OBJECTPERF implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__OBJECTPERF.class.getName());

   public static final Class<TILDA__OBJECTPERF_Factory> FACTORY_CLASS= TILDA__OBJECTPERF_Factory.class;
   public static final String TABLENAME = TextUtil.Print("TILDA.ObjectPerf", "");

   protected TILDA__OBJECTPERF() { }

   private InitMode __Init        = null;
   private BitSet   __Nulls       = new BitSet(64);
   private BitSet   __Changes     = new BitSet(64);
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
//   Field tilda.data.TILDA.ObjectPerf.schemaName -> TILDA.ObjectPerf."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.schemaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.schemaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema tracked</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _schemaName;
   protected String __Saved_schemaName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.schemaName -> TILDA.ObjectPerf."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.schemaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.schemaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema tracked</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getSchemaName()
      { return _schemaName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.schemaName -> TILDA.ObjectPerf."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.schemaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.schemaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema tracked</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setSchemaName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.schemaName to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.schemaName: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_schemaName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.schemaName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask);
       _schemaName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.objectName -> TILDA.ObjectPerf."objectName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.objectName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.objectName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the table/object tracked</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _objectName;
   protected String __Saved_objectName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.objectName -> TILDA.ObjectPerf."objectName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.objectName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.objectName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the table/object tracked</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getObjectName()
      { return _objectName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.objectName -> TILDA.ObjectPerf."objectName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.objectName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.objectName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the table/object tracked</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setObjectName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.objectName to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.objectName: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_objectName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.objectName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask);
       _objectName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.startPeriodTZ -> TILDA.ObjectPerf."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _startPeriodTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.startPeriodTZ -> TILDA.ObjectPerf."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getStartPeriodTZ()
      { return _startPeriodTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.startPeriodTZ -> TILDA.ObjectPerf."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setStartPeriodTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.startPeriodTZ to null: it's not nullable.");
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.startPeriodTZ: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5.");
       else if (v.equals(_startPeriodTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.startPeriodTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask);
       _startPeriodTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.startPeriodTZ -> TILDA.ObjectPerf."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedStartPeriodTZ()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.startPeriod -> TILDA.ObjectPerf."startPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _startPeriod;
   protected ZonedDateTime __Saved_startPeriod;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.startPeriod -> TILDA.ObjectPerf."startPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getStartPeriod()
      { return _startPeriod; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.startPeriod -> TILDA.ObjectPerf."startPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setStartPeriod(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.startPeriod to null: it's not nullable.");
       else if (v.equals(_startPeriod) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.startPeriod' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask);
       _startPeriod = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.startPeriod' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setStartPeriodTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriodTZ -> TILDA.ObjectPerf."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _endPeriodTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriodTZ -> TILDA.ObjectPerf."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getEndPeriodTZ()
      { return _endPeriodTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriodTZ -> TILDA.ObjectPerf."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setEndPeriodTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.endPeriodTZ to null: it's not nullable.");
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.endPeriodTZ: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5.");
       else if (v.equals(_endPeriodTZ) == false)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask);
       _endPeriodTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriodTZ -> TILDA.ObjectPerf."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedEndPeriodTZ()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriod -> TILDA.ObjectPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _endPeriod;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriod -> TILDA.ObjectPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getEndPeriod()
      { return _endPeriod; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriod -> TILDA.ObjectPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setEndPeriod(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.endPeriod to null: it's not nullable.");
       else if (v.equals(_endPeriod) == false)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask);
       _endPeriod = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.endPeriod' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setEndPeriodTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriod -> TILDA.ObjectPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setEndPeriodNow() throws Exception
    {
      setEndPeriod(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriod -> TILDA.ObjectPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setEndPeriodUndefined() throws Exception
    {
      setEndPeriod(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriod -> TILDA.ObjectPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setEndPeriod(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setEndPeriod(DateTimeUtil.New(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriod -> TILDA.ObjectPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedEndPeriod()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectNano -> TILDA.ObjectPerf."selectNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _selectNano= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectNano -> TILDA.ObjectPerf."selectNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getSelectNano()
      { return _selectNano; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectNano -> TILDA.ObjectPerf."selectNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setSelectNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _selectNano)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask);
       _selectNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectNano -> TILDA.ObjectPerf."selectNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedSelectNano()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectCount -> TILDA.ObjectPerf."selectCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _selectCount= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectCount -> TILDA.ObjectPerf."selectCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getSelectCount()
      { return _selectCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectCount -> TILDA.ObjectPerf."selectCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setSelectCount(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _selectCount)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask);
       _selectCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectCount -> TILDA.ObjectPerf."selectCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedSelectCount()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectRecords -> TILDA.ObjectPerf."selectRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _selectRecords= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectRecords -> TILDA.ObjectPerf."selectRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getSelectRecords()
      { return _selectRecords; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectRecords -> TILDA.ObjectPerf."selectRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setSelectRecords(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _selectRecords)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask);
       _selectRecords = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectRecords -> TILDA.ObjectPerf."selectRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedSelectRecords()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertNano -> TILDA.ObjectPerf."insertNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _insertNano= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertNano -> TILDA.ObjectPerf."insertNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getInsertNano()
      { return _insertNano; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertNano -> TILDA.ObjectPerf."insertNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setInsertNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _insertNano)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask);
       _insertNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertNano -> TILDA.ObjectPerf."insertNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedInsertNano()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertCount -> TILDA.ObjectPerf."insertCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _insertCount= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertCount -> TILDA.ObjectPerf."insertCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getInsertCount()
      { return _insertCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertCount -> TILDA.ObjectPerf."insertCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setInsertCount(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _insertCount)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask);
       _insertCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertCount -> TILDA.ObjectPerf."insertCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedInsertCount()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertRecords -> TILDA.ObjectPerf."insertRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _insertRecords= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertRecords -> TILDA.ObjectPerf."insertRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getInsertRecords()
      { return _insertRecords; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertRecords -> TILDA.ObjectPerf."insertRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setInsertRecords(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _insertRecords)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask);
       _insertRecords = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertRecords -> TILDA.ObjectPerf."insertRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedInsertRecords()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateNano -> TILDA.ObjectPerf."updateNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _updateNano= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateNano -> TILDA.ObjectPerf."updateNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getUpdateNano()
      { return _updateNano; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateNano -> TILDA.ObjectPerf."updateNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setUpdateNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _updateNano)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask);
       _updateNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateNano -> TILDA.ObjectPerf."updateNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedUpdateNano()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateCount -> TILDA.ObjectPerf."updateCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _updateCount= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateCount -> TILDA.ObjectPerf."updateCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getUpdateCount()
      { return _updateCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateCount -> TILDA.ObjectPerf."updateCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setUpdateCount(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _updateCount)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask);
       _updateCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateCount -> TILDA.ObjectPerf."updateCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedUpdateCount()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateRecords -> TILDA.ObjectPerf."updateRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _updateRecords= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateRecords -> TILDA.ObjectPerf."updateRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getUpdateRecords()
      { return _updateRecords; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateRecords -> TILDA.ObjectPerf."updateRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setUpdateRecords(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _updateRecords)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask);
       _updateRecords = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateRecords -> TILDA.ObjectPerf."updateRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedUpdateRecords()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteNano -> TILDA.ObjectPerf."deleteNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _deleteNano= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteNano -> TILDA.ObjectPerf."deleteNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getDeleteNano()
      { return _deleteNano; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteNano -> TILDA.ObjectPerf."deleteNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDeleteNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _deleteNano)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask);
       _deleteNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteNano -> TILDA.ObjectPerf."deleteNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleteNano()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteCount -> TILDA.ObjectPerf."deleteCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _deleteCount= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteCount -> TILDA.ObjectPerf."deleteCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getDeleteCount()
      { return _deleteCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteCount -> TILDA.ObjectPerf."deleteCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDeleteCount(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _deleteCount)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask);
       _deleteCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteCount -> TILDA.ObjectPerf."deleteCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleteCount()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteRecords -> TILDA.ObjectPerf."deleteRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _deleteRecords= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteRecords -> TILDA.ObjectPerf."deleteRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getDeleteRecords()
      { return _deleteRecords; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteRecords -> TILDA.ObjectPerf."deleteRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDeleteRecords(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _deleteRecords)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask);
       _deleteRecords = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteRecords -> TILDA.ObjectPerf."deleteRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleteRecords()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask);
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>

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
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>

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
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDeleted()
     { return __Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>

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
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask);
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>

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
       if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask);
       __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask);
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleted()
     { return __Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void CopyTo(tilda.data._Tilda.TILDA__OBJECTPERF Dst) throws Exception
     {
       Dst.setEndPeriodTZ  (_endPeriodTZ  );
       Dst.setEndPeriod    (_endPeriod    );
       Dst.setSelectNano   (_selectNano   );
       Dst.setSelectCount  (_selectCount  );
       Dst.setSelectRecords(_selectRecords);
       Dst.setInsertNano   (_insertNano   );
       Dst.setInsertCount  (_insertCount  );
       Dst.setInsertRecords(_insertRecords);
       Dst.setUpdateNano   (_updateNano   );
       Dst.setUpdateCount  (_updateCount  );
       Dst.setUpdateRecords(_updateRecords);
       Dst.setDeleteNano   (_deleteNano   );
       Dst.setDeleteCount  (_deleteCount  );
       Dst.setDeleteRecords(_deleteRecords);
       Dst.setLastUpdated  (_lastUpdated  );
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true) Dst.setNullDeleted      (); else        Dst.setDeleted      (_deleted      );
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
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.ObjectPerf has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }

       StringBuilder S = new StringBuilder(1024);

       if (BeforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.ObjectPerf object's BeforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
          return false;
        }

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "ObjectPerf");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == false && DateTimeUtil.isNowPlaceholder(_startPeriod) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == false && DateTimeUtil.isNowPlaceholder(_endPeriod) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.SELECTNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.INSERTNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.UPDATENANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.DELETENANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__OBJECTPERF_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDA", "ObjectPerf"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == false && DateTimeUtil.isNowPlaceholder(_startPeriod) == true)
              { TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == false && DateTimeUtil.isNowPlaceholder(_endPeriod) == true)
              { TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.SELECTNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.INSERTNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.UPDATENANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.DELETENANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask) == true) TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__OBJECTPERF_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__OBJECTPERF_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__OBJECTPERF_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__OBJECTPERF_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0:
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "schemaName"); S.append("=? AND "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "objectName"); S.append("=? AND "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "startPeriod"); S.append("=?)");
                break;
             case -666: if (__Init == InitMode.CREATE) break;
             default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
           }
          S.setCharAt(Pos, ' ');
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.ObjectPerf", Q, toString());
       java.sql.PreparedStatement PS = null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _schemaName);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _objectName);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _startPeriodTZ);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_startPeriod) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_startPeriod.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _endPeriodTZ);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_endPeriod) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_endPeriod.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _selectNano);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _selectCount);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _selectRecords);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _insertNano);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _insertCount);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _insertRecords);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _updateNano);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _updateCount);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _updateRecords);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _deleteNano);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _deleteCount);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _deleteRecords);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_created.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_lastUpdated.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
                } 
               if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true) 
                { 
                  if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_deleted.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
                } 

          switch (__LookupId)
           {
             case 0:
               PS.setString   (++i, _schemaName   );
               PS.setString   (++i, _objectName   );
               PS.setTimestamp(++i, new java.sql.Timestamp(_startPeriod.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
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
             __Saved_schemaName    = _schemaName   ;
             __Saved_objectName    = _objectName   ;
             __Saved_startPeriod   = _startPeriod  ;
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
        }

       __Changes.clear();
       __Nulls.clear();
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
        throw new Exception("This TILDA.ObjectPerf object is being Read() after a Create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.ObjectPerf object has already been read.");
          QueryDetails.setLastQuery(TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "schemaName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "objectName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "startPeriodTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "startPeriod");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "endPeriodTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "endPeriod");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "selectNano");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "selectCount");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "selectRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "insertNano");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "insertCount");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "insertRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "updateNano");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "updateCount");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "updateRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "deleteNano");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "deleteCount");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "deleteRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "created");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "lastUpdated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "deleted");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "ObjectPerf");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "schemaName"); S.append("=? AND "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "objectName"); S.append("=? AND "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "startPeriod"); S.append("=?)");
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.ObjectPerf", Q, toString());
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
               PS.setString   (++i, _schemaName   );
               PS.setString   (++i, _objectName   );
               PS.setTimestamp(++i, new java.sql.Timestamp(_startPeriod.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_schemaName    = _schemaName    = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask   );
      __Saved_objectName    = _objectName    = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask   );
                              _startPeriodTZ = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask); else _startPeriodTZ = _startPeriodTZ.trim();
      __Saved_startPeriod   = _startPeriod   = ProcessZDT(_startPeriodTZ  , "tilda.data.TILDA.ObjectPerf.startPeriod"  , RS, ++i, TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD  , TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ  );
                              _endPeriodTZ   = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask  ); else _endPeriodTZ   = _endPeriodTZ  .trim();
                              _endPeriod     = ProcessZDT(_endPeriodTZ    , "tilda.data.TILDA.ObjectPerf.endPeriod"    , RS, ++i, TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD    , TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ    );
                              _selectNano    =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask   );
                              _selectCount   =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask  );
                              _selectRecords =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask);
                              _insertNano    =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask   );
                              _insertCount   =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask  );
                              _insertRecords =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask);
                              _updateNano    =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask   );
                              _updateCount   =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask  );
                              _updateRecords =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask);
                              _deleteNano    =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask   );
                              _deleteCount   =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask  );
                              _deleteRecords =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask);
                              _created       = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null);
                              _lastUpdated   = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null);
                              _deleted       = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null);
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
      {;
         __Nulls.or(DTField._Mask);
         DTNull = true;
      };
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
                   "schemaName: "                                                                                              + TextUtil.PrintVariableStr        (getSchemaName   ())
               + "; objectName: "                                                                                              + TextUtil.PrintVariableStr        (getObjectName   ())
               + "; startPeriod: "                                                                                             + DateTimeUtil.printDateTimeForJSON(getStartPeriod  ())
               + "; endPeriod: "                                                                                               + DateTimeUtil.printDateTimeForJSON(getEndPeriod    ())
               + "; selectNano: "                                                                                              +                                   getSelectNano   () 
               + "; selectCount: "                                                                                             +                                   getSelectCount  () 
               + "; selectRecords: "                                                                                           +                                   getSelectRecords() 
               + "; insertNano: "                                                                                              +                                   getInsertNano   () 
               + "; insertCount: "                                                                                             +                                   getInsertCount  () 
               + "; insertRecords: "                                                                                           +                                   getInsertRecords() 
               + "; updateNano: "                                                                                              +                                   getUpdateNano   () 
               + "; updateCount: "                                                                                             +                                   getUpdateCount  () 
               + "; updateRecords: "                                                                                           +                                   getUpdateRecords() 
               + "; deleteNano: "                                                                                              +                                   getDeleteNano   () 
               + "; deleteCount: "                                                                                             +                                   getDeleteCount  () 
               + "; deleteRecords: "                                                                                           +                                   getDeleteRecords() 
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
