/*
 Tilda V2.3 data object.

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
<TABLE id="ObjectPerf_DIV" class="tables">
<SCRIPT>registerStickyHeader("ObjectPerf_DIV");</SCRIPT>
<TR valign="top"><TD><H2>ObjectPerf&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#ObjectPerf_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="ObjectPerf_CNT" class="content">
The Table TILDA.ObjectPerf :<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>ObjectPerf_Factory</B>, <B>ObjectPerf_Data</B> in the package <B>tilda.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Defines 2 foreign key(s):<BR>
<TABLE style="margin-left: 25px; border:1px solid #BBB;" cellspacing="0px" cellpadding="5px" border="0px">
<TR style="background-color:#DDD; font-weight:bold;"><TD></TD><TD>Source Columns</TD><TD>Destination Object</TD><TD>Destination Columns</TD><TD>Notes</TD></TR>
<TR ><TD>1</TD><TD>startPeriodTZ</TD><TD><A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A></TD><TD>id</TD><TD>&nbsp;</TD></TR>
</TABLE></LI>
<LI>Has the following identity:<UL><LI>Primary Key: schemaName, objectName, startPeriod</LI>
</UL></LI>
<LI>Has the following indices:<UL><LI>schemaNameobjectName asc, startPeriod desc
</LI>
<LI>schemaName, objectNamestartPeriod desc
 <B><I>(Application-side Only)</I></B></LI>
</UL></LI>
</UL>
<B>Description</B>:<BLOCKQUOTE style="border-left: 1px solid #EEE;padding-left: 5px;">Performance logs for the Tilda framework</BLOCKQUOTE>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="ObjectPerf_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid #BBB;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-schemaName_DIV' class='columns'>schemaName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the schema tracked</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-objectName_DIV' class='columns'>objectName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the table/object tracked</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-startPeriodTZ_DIV' class='columns'>startPeriodTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'startPeriod'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-startPeriod_DIV' class='columns'>startPeriod</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-endPeriodTZ_DIV' class='columns'>endPeriodTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'endPeriod'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-endPeriod_DIV' class='columns'>endPeriod</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-selectNano_DIV' class='columns'>selectNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>selectNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-selectCount_DIV' class='columns'>selectCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>selectCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-selectRecords_DIV' class='columns'>selectRecords</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>selectRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-insertNano_DIV' class='columns'>insertNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>insertNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-insertCount_DIV' class='columns'>insertCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>insertCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-insertRecords_DIV' class='columns'>insertRecords</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>insertRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-updateNano_DIV' class='columns'>updateNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>updateNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-updateCount_DIV' class='columns'>updateCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>updateCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-updateRecords_DIV' class='columns'>updateRecords</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>updateRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-deleteNano_DIV' class='columns'>deleteNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>deleteNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-deleteCount_DIV' class='columns'>deleteCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>deleteCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-deleteRecords_DIV' class='columns'>deleteRecords</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #BBB;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>deleteRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created. (TILDA.ObjectPerf)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>20&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDA.ObjectPerf)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>21&nbsp;&nbsp;</TD>
<TD align="right"><B id='ObjectPerf-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted. (TILDA.ObjectPerf)</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__OBJECTPERF implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__OBJECTPERF.class.getName());

   public transient static final Class<TILDA__OBJECTPERF_Factory> FACTORY_CLASS= TILDA__OBJECTPERF_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDA.ObjectPerf", "");

   protected TILDA__OBJECTPERF() { }

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
//   Field tilda.data.TILDA.ObjectPerf.schemaName -> TILDA.ObjectPerf."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema tracked</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.schemaName of type varchar(64)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.schemaName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("schemaName")
   String _schemaName=null;
   protected String __Saved_schemaName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.schemaName -> TILDA.ObjectPerf."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema tracked</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.schemaName of type varchar(64)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.schemaName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema tracked</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.schemaName of type varchar(64)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.schemaName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.schemaName: the size "+v.length()+" is larger than the max allowed of 64: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_schemaName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.schemaName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask);
       _schemaName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field schemaName doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initSchemaName(String v) throws Exception
     {
       setSchemaName(v);
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
  <TR><TD align="right"><B>Name</B></TD><TD>objectName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the table/object tracked</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.objectName of type varchar(64)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.objectName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("objectName")
   String _objectName=null;
   protected String __Saved_objectName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.objectName -> TILDA.ObjectPerf."objectName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>objectName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the table/object tracked</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.objectName of type varchar(64)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.objectName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>objectName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the table/object tracked</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.objectName of type varchar(64)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.objectName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.objectName: the size "+v.length()+" is larger than the max allowed of 64: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_objectName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.objectName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask);
       _objectName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field objectName doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initObjectName(String v) throws Exception
     {
       setObjectName(v);
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
  <TR><TD align="right"><B>Name</B></TD><TD>startPeriodTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriodTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriodTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _startPeriodTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.startPeriodTZ -> TILDA.ObjectPerf."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startPeriodTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriodTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriodTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>startPeriodTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriodTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriodTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.startPeriodTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_startPeriodTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
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
  <TR><TD align="right"><B>Name</B></TD><TD>startPeriodTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriodTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriodTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>startPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("startPeriod")
   String  Str_startPeriod;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_StartPeriod(String v) { Str_startPeriod = v; }
   public String initStartPeriodVal() { return Str_startPeriod; }
   transient ZonedDateTime _startPeriod = null;
   transient ZonedDateTime __Saved_startPeriod;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.startPeriod -> TILDA.ObjectPerf."startPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>startPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.startPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.startPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
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

   /**
    * Being invariant, the field startPeriod doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initStartPeriod(ZonedDateTime v) throws Exception
     {
       setStartPeriod(v);
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
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriodTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriodTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriodTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _endPeriodTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriodTZ -> TILDA.ObjectPerf."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriodTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriodTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriodTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriodTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriodTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriodTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.endPeriodTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
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
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriodTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriodTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriodTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("endPeriod")
   String  Str_endPeriod;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_EndPeriod(String v) { Str_endPeriod = v; }
   public String initEndPeriodVal() { return Str_endPeriod; }
   transient ZonedDateTime _endPeriod = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriod -> TILDA.ObjectPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setEndPeriod(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setEndPeriod(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.endPeriod -> TILDA.ObjectPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.endPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.endPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
  <TR><TD align="right"><B>Name</B></TD><TD>selectNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("selectNano")
   Long _selectNano=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.selectNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _selectNano_Values = {
                                               { "0", "selectNano_CreateDefault", "selectNano_CreateDefault", "" }
                                  };
   public static final boolean checkSelectNano(long v)
    {
      for (String[] a : _selectNano_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapSelectNano(long v)
    {
      for (String[] a : _selectNano_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final long _selectNanoSelectNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectNano -> TILDA.ObjectPerf."selectNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getSelectNano()
      { return _selectNano==null?0l:_selectNano; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.selectNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>selectNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>selectNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isSelectNanoSelectNano_CreateDefault()
      { return _selectNano != null && _selectNano.equals(_selectNanoSelectNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectNano -> TILDA.ObjectPerf."selectNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setSelectNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _selectNano == null || v != _selectNano)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask);
       _selectNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.selectNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>selectNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>selectNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setSelectNanoSelectNano_CreateDefault() throws Exception
      { setSelectNano(_selectNanoSelectNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectNano -> TILDA.ObjectPerf."selectNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>selectCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("selectCount")
   Integer _selectCount=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.selectCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _selectCount_Values = {
                                               { "0", "selectCount_CreateDefault", "selectCount_CreateDefault", "" }
                                  };
   public static final boolean checkSelectCount(int v)
    {
      for (String[] a : _selectCount_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapSelectCount(int v)
    {
      for (String[] a : _selectCount_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final int _selectCountSelectCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectCount -> TILDA.ObjectPerf."selectCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getSelectCount()
      { return _selectCount==null?0:_selectCount; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.selectCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>selectCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>selectCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isSelectCountSelectCount_CreateDefault()
      { return _selectCount != null && _selectCount.equals(_selectCountSelectCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectCount -> TILDA.ObjectPerf."selectCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setSelectCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _selectCount == null || v != _selectCount)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask);
       _selectCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.selectCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>selectCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>selectCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setSelectCountSelectCount_CreateDefault() throws Exception
      { setSelectCount(_selectCountSelectCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectCount -> TILDA.ObjectPerf."selectCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>selectRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("selectRecords")
   Integer _selectRecords=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.selectRecords, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _selectRecords_Values = {
                                               { "0", "selectRecords_CreateDefault", "selectRecords_CreateDefault", "" }
                                  };
   public static final boolean checkSelectRecords(int v)
    {
      for (String[] a : _selectRecords_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapSelectRecords(int v)
    {
      for (String[] a : _selectRecords_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final int _selectRecordsSelectRecords_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectRecords -> TILDA.ObjectPerf."selectRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getSelectRecords()
      { return _selectRecords==null?0:_selectRecords; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.selectRecords:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>selectRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>selectRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isSelectRecordsSelectRecords_CreateDefault()
      { return _selectRecords != null && _selectRecords.equals(_selectRecordsSelectRecords_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectRecords -> TILDA.ObjectPerf."selectRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setSelectRecords(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _selectRecords == null || v != _selectRecords)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask);
       _selectRecords = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.selectRecords:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>selectRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>selectRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public void setSelectRecordsSelectRecords_CreateDefault() throws Exception
      { setSelectRecords(_selectRecordsSelectRecords_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.selectRecords -> TILDA.ObjectPerf."selectRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>selectRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.selectRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.selectRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>selectRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>selectRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>insertNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("insertNano")
   Long _insertNano=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.insertNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _insertNano_Values = {
                                               { "0", "insertNano_CreateDefault", "insertNano_CreateDefault", "" }
                                  };
   public static final boolean checkInsertNano(long v)
    {
      for (String[] a : _insertNano_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapInsertNano(long v)
    {
      for (String[] a : _insertNano_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final long _insertNanoInsertNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertNano -> TILDA.ObjectPerf."insertNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getInsertNano()
      { return _insertNano==null?0l:_insertNano; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.insertNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>insertNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>insertNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isInsertNanoInsertNano_CreateDefault()
      { return _insertNano != null && _insertNano.equals(_insertNanoInsertNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertNano -> TILDA.ObjectPerf."insertNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setInsertNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _insertNano == null || v != _insertNano)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask);
       _insertNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.insertNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>insertNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>insertNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setInsertNanoInsertNano_CreateDefault() throws Exception
      { setInsertNano(_insertNanoInsertNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertNano -> TILDA.ObjectPerf."insertNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>insertCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("insertCount")
   Integer _insertCount=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.insertCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _insertCount_Values = {
                                               { "0", "insertCount_CreateDefault", "insertCount_CreateDefault", "" }
                                  };
   public static final boolean checkInsertCount(int v)
    {
      for (String[] a : _insertCount_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapInsertCount(int v)
    {
      for (String[] a : _insertCount_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final int _insertCountInsertCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertCount -> TILDA.ObjectPerf."insertCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getInsertCount()
      { return _insertCount==null?0:_insertCount; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.insertCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>insertCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>insertCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isInsertCountInsertCount_CreateDefault()
      { return _insertCount != null && _insertCount.equals(_insertCountInsertCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertCount -> TILDA.ObjectPerf."insertCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setInsertCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _insertCount == null || v != _insertCount)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask);
       _insertCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.insertCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>insertCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>insertCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setInsertCountInsertCount_CreateDefault() throws Exception
      { setInsertCount(_insertCountInsertCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertCount -> TILDA.ObjectPerf."insertCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>insertRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("insertRecords")
   Integer _insertRecords=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.insertRecords, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _insertRecords_Values = {
                                               { "0", "insertRecords_CreateDefault", "insertRecords_CreateDefault", "" }
                                  };
   public static final boolean checkInsertRecords(int v)
    {
      for (String[] a : _insertRecords_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapInsertRecords(int v)
    {
      for (String[] a : _insertRecords_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final int _insertRecordsInsertRecords_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertRecords -> TILDA.ObjectPerf."insertRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getInsertRecords()
      { return _insertRecords==null?0:_insertRecords; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.insertRecords:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>insertRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>insertRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isInsertRecordsInsertRecords_CreateDefault()
      { return _insertRecords != null && _insertRecords.equals(_insertRecordsInsertRecords_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertRecords -> TILDA.ObjectPerf."insertRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setInsertRecords(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _insertRecords == null || v != _insertRecords)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask);
       _insertRecords = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.insertRecords:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>insertRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>insertRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public void setInsertRecordsInsertRecords_CreateDefault() throws Exception
      { setInsertRecords(_insertRecordsInsertRecords_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.insertRecords -> TILDA.ObjectPerf."insertRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>insertRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.insertRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.insertRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>insertRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>insertRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>updateNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("updateNano")
   Long _updateNano=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.updateNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _updateNano_Values = {
                                               { "0", "updateNano_CreateDefault", "updateNano_CreateDefault", "" }
                                  };
   public static final boolean checkUpdateNano(long v)
    {
      for (String[] a : _updateNano_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapUpdateNano(long v)
    {
      for (String[] a : _updateNano_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final long _updateNanoUpdateNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateNano -> TILDA.ObjectPerf."updateNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getUpdateNano()
      { return _updateNano==null?0l:_updateNano; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.updateNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>updateNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>updateNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isUpdateNanoUpdateNano_CreateDefault()
      { return _updateNano != null && _updateNano.equals(_updateNanoUpdateNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateNano -> TILDA.ObjectPerf."updateNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setUpdateNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _updateNano == null || v != _updateNano)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask);
       _updateNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.updateNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>updateNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>updateNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setUpdateNanoUpdateNano_CreateDefault() throws Exception
      { setUpdateNano(_updateNanoUpdateNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateNano -> TILDA.ObjectPerf."updateNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>updateCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("updateCount")
   Integer _updateCount=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.updateCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _updateCount_Values = {
                                               { "0", "updateCount_CreateDefault", "updateCount_CreateDefault", "" }
                                  };
   public static final boolean checkUpdateCount(int v)
    {
      for (String[] a : _updateCount_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapUpdateCount(int v)
    {
      for (String[] a : _updateCount_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final int _updateCountUpdateCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateCount -> TILDA.ObjectPerf."updateCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getUpdateCount()
      { return _updateCount==null?0:_updateCount; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.updateCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>updateCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>updateCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isUpdateCountUpdateCount_CreateDefault()
      { return _updateCount != null && _updateCount.equals(_updateCountUpdateCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateCount -> TILDA.ObjectPerf."updateCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setUpdateCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _updateCount == null || v != _updateCount)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask);
       _updateCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.updateCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>updateCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>updateCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setUpdateCountUpdateCount_CreateDefault() throws Exception
      { setUpdateCount(_updateCountUpdateCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateCount -> TILDA.ObjectPerf."updateCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>updateRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("updateRecords")
   Integer _updateRecords=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.updateRecords, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _updateRecords_Values = {
                                               { "0", "updateRecords_CreateDefault", "updateRecords_CreateDefault", "" }
                                  };
   public static final boolean checkUpdateRecords(int v)
    {
      for (String[] a : _updateRecords_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapUpdateRecords(int v)
    {
      for (String[] a : _updateRecords_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final int _updateRecordsUpdateRecords_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateRecords -> TILDA.ObjectPerf."updateRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getUpdateRecords()
      { return _updateRecords==null?0:_updateRecords; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.updateRecords:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>updateRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>updateRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isUpdateRecordsUpdateRecords_CreateDefault()
      { return _updateRecords != null && _updateRecords.equals(_updateRecordsUpdateRecords_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateRecords -> TILDA.ObjectPerf."updateRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setUpdateRecords(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _updateRecords == null || v != _updateRecords)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask);
       _updateRecords = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.updateRecords:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>updateRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>updateRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public void setUpdateRecordsUpdateRecords_CreateDefault() throws Exception
      { setUpdateRecords(_updateRecordsUpdateRecords_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.updateRecords -> TILDA.ObjectPerf."updateRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>updateRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.updateRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.updateRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>updateRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>updateRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>deleteNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("deleteNano")
   Long _deleteNano=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.deleteNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _deleteNano_Values = {
                                               { "0", "deleteNano_CreateDefault", "deleteNano_CreateDefault", "" }
                                  };
   public static final boolean checkDeleteNano(long v)
    {
      for (String[] a : _deleteNano_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapDeleteNano(long v)
    {
      for (String[] a : _deleteNano_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final long _deleteNanoDeleteNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteNano -> TILDA.ObjectPerf."deleteNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getDeleteNano()
      { return _deleteNano==null?0l:_deleteNano; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.deleteNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>deleteNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>deleteNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isDeleteNanoDeleteNano_CreateDefault()
      { return _deleteNano != null && _deleteNano.equals(_deleteNanoDeleteNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteNano -> TILDA.ObjectPerf."deleteNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDeleteNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _deleteNano == null || v != _deleteNano)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask);
       _deleteNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.deleteNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>deleteNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>deleteNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setDeleteNanoDeleteNano_CreateDefault() throws Exception
      { setDeleteNano(_deleteNanoDeleteNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteNano -> TILDA.ObjectPerf."deleteNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>deleteCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("deleteCount")
   Integer _deleteCount=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.deleteCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _deleteCount_Values = {
                                               { "0", "deleteCount_CreateDefault", "deleteCount_CreateDefault", "" }
                                  };
   public static final boolean checkDeleteCount(int v)
    {
      for (String[] a : _deleteCount_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapDeleteCount(int v)
    {
      for (String[] a : _deleteCount_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final int _deleteCountDeleteCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteCount -> TILDA.ObjectPerf."deleteCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getDeleteCount()
      { return _deleteCount==null?0:_deleteCount; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.deleteCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>deleteCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>deleteCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isDeleteCountDeleteCount_CreateDefault()
      { return _deleteCount != null && _deleteCount.equals(_deleteCountDeleteCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteCount -> TILDA.ObjectPerf."deleteCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDeleteCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _deleteCount == null || v != _deleteCount)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask);
       _deleteCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.deleteCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>deleteCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>deleteCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setDeleteCountDeleteCount_CreateDefault() throws Exception
      { setDeleteCount(_deleteCountDeleteCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteCount -> TILDA.ObjectPerf."deleteCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>deleteRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("deleteRecords")
   Integer _deleteRecords=null;
/**
These are the enumerated values for tilda.data.TILDA.ObjectPerf.deleteRecords, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _deleteRecords_Values = {
                                               { "0", "deleteRecords_CreateDefault", "deleteRecords_CreateDefault", "" }
                                  };
   public static final boolean checkDeleteRecords(int v)
    {
      for (String[] a : _deleteRecords_Values)
       if (a[0].equals(v) == true)
        return true;
      return false;
    }
   public static final String mapDeleteRecords(int v)
    {
      for (String[] a : _deleteRecords_Values)
       if (a[0].equals(v) == true)
        return a[2];
      return null;
    }
   public static final int _deleteRecordsDeleteRecords_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteRecords -> TILDA.ObjectPerf."deleteRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getDeleteRecords()
      { return _deleteRecords==null?0:_deleteRecords; }

/**
This is the value is-a for tilda.data.TILDA.ObjectPerf.deleteRecords:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>deleteRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>deleteRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isDeleteRecordsDeleteRecords_CreateDefault()
      { return _deleteRecords != null && _deleteRecords.equals(_deleteRecordsDeleteRecords_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteRecords -> TILDA.ObjectPerf."deleteRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDeleteRecords(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _deleteRecords == null || v != _deleteRecords)
        {
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask);
       _deleteRecords = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.ObjectPerf.deleteRecords:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>deleteRecords_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>deleteRecords_CreateDefault</TD></TR>
</TABLE>
*/
   public void setDeleteRecordsDeleteRecords_CreateDefault() throws Exception
      { setDeleteRecords(_deleteRecordsDeleteRecords_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleteRecords -> TILDA.ObjectPerf."deleteRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleteRecords of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleteRecords of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleteRecords</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>deleteRecords_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>deleteRecords_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.ObjectPerf.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
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
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.created -> TILDA.ObjectPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.created</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.lastUpdated -> TILDA.ObjectPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.lastUpdated</TD></TR>

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
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _deleted = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDeletedNull()
     { return __Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted</TD></TR>

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
          setDeletedNull();
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
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDeletedNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask);
       if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
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
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted</TD></TR>

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
//   Field tilda.data.TILDA.ObjectPerf.deleted -> TILDA.ObjectPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.ObjectPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ObjectPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.ObjectPerf.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
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
   public void copyTo(tilda.data._Tilda.TILDA__OBJECTPERF Dst) throws Exception
     {
       if (__Init == InitMode.CREATE && _startPeriodTZ != null)
        Dst.setStartPeriodTZ(_startPeriodTZ);
       if (_endPeriodTZ   != null)
        Dst.setEndPeriodTZ  (_endPeriodTZ  );
       if (_endPeriod     != null)
        Dst.setEndPeriod    (_endPeriod    );
       Dst.Str_endPeriod = Str_endPeriod;
       if (_selectNano    != null)
        Dst.setSelectNano   (_selectNano   );
       if (_selectCount   != null)
        Dst.setSelectCount  (_selectCount  );
       if (_selectRecords != null)
        Dst.setSelectRecords(_selectRecords);
       if (_insertNano    != null)
        Dst.setInsertNano   (_insertNano   );
       if (_insertCount   != null)
        Dst.setInsertCount  (_insertCount  );
       if (_insertRecords != null)
        Dst.setInsertRecords(_insertRecords);
       if (_updateNano    != null)
        Dst.setUpdateNano   (_updateNano   );
       if (_updateCount   != null)
        Dst.setUpdateCount  (_updateCount  );
       if (_updateRecords != null)
        Dst.setUpdateRecords(_updateRecords);
       if (_deleteNano    != null)
        Dst.setDeleteNano   (_deleteNano   );
       if (_deleteCount   != null)
        Dst.setDeleteCount  (_deleteCount  );
       if (_deleteRecords != null)
        Dst.setDeleteRecords(_deleteRecords);
       if (__Init == InitMode.CREATE && _created       != null)
        Dst.setCreated      (_created      );
       if (_lastUpdated   != null)
        Dst.setLastUpdated  (_lastUpdated  );
       if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true || _deleted      ==null)
        Dst.setDeletedNull      ();
       else
        Dst.setDeleted      (_deleted      );
     }


   public tilda.data.ObjectPerf_Data copy() throws Exception
     {
       tilda.data.ObjectPerf_Data dst = new tilda.data.ObjectPerf_Data();
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
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.ObjectPerf has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }


       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.ObjectPerf object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
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
               PS.setString    (++i, _schemaName   );
               PS.setString    (++i, _objectName   );
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
          return C.handleCatch(E, "updated or inserted");
        }
       finally
        {
          tilda.data._Tilda.TILDA__2_3.handleFinally(PS, T0, TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (TextUtil.isNullOrEmpty(_schemaName) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.schemaName' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask);

       if (TextUtil.isNullOrEmpty(_objectName) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.objectName' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask);

       if (TextUtil.isNullOrEmpty(Str_startPeriod) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.startPeriod' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask);
        {
       _startPeriod = DateTimeUtil.parsefromJSON(Str_startPeriod);
       if (   _startPeriod == null)
        throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.startPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       __Changes.or(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask);
       __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask);
       tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_startPeriod.getZone().getId());
       if (ZI == null)
        throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.startPeriod' because the timezone value '"+_startPeriod.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setStartPeriodTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_endPeriod) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.endPeriod' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask);
        {
       _endPeriod = DateTimeUtil.parsefromJSON(Str_endPeriod);
       if (   _endPeriod == null)
        throw new Exception("Incoming value for 'tilda.data.TILDA.ObjectPerf.endPeriod' was not in the expected format. Dates should follow the ISO format.\n"+toString());
       __Changes.or(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask);
       __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask);
       tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_endPeriod.getZone().getId());
       if (ZI == null)
        throw new Exception("Cannot set field 'tilda.data.TILDA.ObjectPerf.endPeriod' because the timezone value '"+_endPeriod.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setEndPeriodTZ(ZI.getId());
        }

       if (_selectNano == null)
        _selectNano=0l;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask);

       if (_selectCount == null)
        _selectCount=0;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask);

       if (_selectRecords == null)
        _selectRecords=0;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask);

       if (_insertNano == null)
        _insertNano=0l;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask);

       if (_insertCount == null)
        _insertCount=0;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask);

       if (_insertRecords == null)
        _insertRecords=0;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask);

       if (_updateNano == null)
        _updateNano=0l;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask);

       if (_updateCount == null)
        _updateCount=0;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask);

       if (_updateRecords == null)
        _updateRecords=0;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask);

       if (_deleteNano == null)
        _deleteNano=0l;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask);

       if (_deleteCount == null)
        _deleteCount=0;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask);

       if (_deleteRecords == null)
        _deleteRecords=0;
          __Changes.or(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask);
          __Nulls.andNot(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask);
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_startPeriod) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_endPeriod) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_created) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_deleted) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "ObjectPerf");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == false && DateTimeUtil.isNowPlaceholder(_startPeriod) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == false && DateTimeUtil.isNowPlaceholder(_endPeriod) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.SELECTNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.INSERTNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.UPDATENANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.DELETENANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);
           }
          else { TILDA__OBJECTPERF_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);
           }
          else { TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true) { TILDA__OBJECTPERF_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_3._COMMAQUESTION);
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
             case 0: // PK
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "schemaName"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "objectName"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "startPeriod"); S.append("=?");  S.append(")");
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
       QueryDetails.setLastQuery(TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.ObjectPerf", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _schemaName);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _objectName);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _startPeriodTZ);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_startPeriod) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_startPeriod.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _endPeriodTZ);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_endPeriod) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_endPeriod.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _selectNano);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _selectCount);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _selectRecords);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _insertNano);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _insertCount);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _insertRecords);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _updateNano);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _updateCount);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _updateRecords);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _deleteNano);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _deleteCount);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _deleteRecords);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_created.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_lastUpdated.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_deleted.toInstant()), DateTimeUtil._UTC_CALENDAR);
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
             __Saved_schemaName    = _schemaName   ;
             __Saved_objectName    = _objectName   ;
             __Saved_startPeriod   = _startPeriod  ;
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
       if (TextUtil.isNullOrEmpty(_schemaName) == false && TextUtil.isNullOrEmpty(_objectName) == false && TextUtil.isNullOrEmpty(Str_startPeriod) == false)
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
        throw new Exception("This TILDA.ObjectPerf object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.ObjectPerf object has already been read.");
          QueryDetails.setLastQuery(TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__OBJECTPERF_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "ObjectPerf");
       switch (__LookupId)
        {
          case 0: // PK
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "schemaName"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "objectName"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "ObjectPerf", "startPeriod"); S.append("=?");  S.append(")");
             break;
          case -77: 
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
             case 0: // PK
               PS.setString    (++i, _schemaName   );
               PS.setString    (++i, _objectName   );
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
          return init(C, RS);
        }
       catch (java.sql.SQLException E)
        {
          return C.handleCatch(E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__2_3.handleFinally(PS, T0, TILDA__OBJECTPERF_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_schemaName    = _schemaName    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.SCHEMANAME._Mask   ); _schemaName = null; }
      __Saved_objectName    = _objectName    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.OBJECTNAME._Mask   ); _objectName = null; }
                              _startPeriodTZ = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ._Mask); _startPeriodTZ = null; } else _startPeriodTZ = _startPeriodTZ.trim();
      __Saved_startPeriod   = _startPeriod   = processZDT(_startPeriodTZ  , "tilda.data.TILDA.ObjectPerf.startPeriod"  , RS, ++i, TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD  , TILDA__OBJECTPERF_Factory.COLS.STARTPERIODTZ  ); if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.STARTPERIOD._Mask  ); _startPeriod = null; }
                              _endPeriodTZ   = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ._Mask  ); _endPeriodTZ = null; } else _endPeriodTZ   = _endPeriodTZ  .trim();
                              _endPeriod     = processZDT(_endPeriodTZ    , "tilda.data.TILDA.ObjectPerf.endPeriod"    , RS, ++i, TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD    , TILDA__OBJECTPERF_Factory.COLS.ENDPERIODTZ    ); if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.ENDPERIOD._Mask    ); _endPeriod = null; }
                              _selectNano    =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.SELECTNANO._Mask   ); _selectNano = null; }
                              _selectCount   =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.SELECTCOUNT._Mask  ); _selectCount = null; }
                              _selectRecords =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.SELECTRECORDS._Mask); _selectRecords = null; }
                              _insertNano    =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.INSERTNANO._Mask   ); _insertNano = null; }
                              _insertCount   =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.INSERTCOUNT._Mask  ); _insertCount = null; }
                              _insertRecords =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.INSERTRECORDS._Mask); _insertRecords = null; }
                              _updateNano    =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.UPDATENANO._Mask   ); _updateNano = null; }
                              _updateCount   =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.UPDATECOUNT._Mask  ); _updateCount = null; }
                              _updateRecords =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.UPDATERECORDS._Mask); _updateRecords = null; }
                              _deleteNano    =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.DELETENANO._Mask   ); _deleteNano = null; }
                              _deleteCount   =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.DELETECOUNT._Mask  ); _deleteCount = null; }
                              _deleteRecords =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.DELETERECORDS._Mask); _deleteRecords = null; }
                              _created       = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.CREATED._Mask      ); _created = null; }
                              _lastUpdated   = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.LASTUPDATED._Mask  ); _lastUpdated = null; }
                              _deleted       = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask      ); _deleted = null; }
     __LookupId = 0;
     __Init     = InitMode.READ;
     __Changes.clear();

     return afterRead(C);
   }

  private final ZonedDateTime processZDT(String TimezoneId, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)
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

   protected abstract boolean afterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "schemaName: "                                                                                              + TextUtil.printVariableStr        (getSchemaName   ())
               + "; objectName: "                                                                                              + TextUtil.printVariableStr        (getObjectName   ())
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
               + "; created: "                                                                                                 + DateTimeUtil.printDateTimeForJSON(getCreated      ())
               + "; lastUpdated: "                                                                                             + DateTimeUtil.printDateTimeForJSON(getLastUpdated  ())
               + "; deleted"         + (__Nulls.intersects(TILDA__OBJECTPERF_Factory.COLS.DELETED._Mask      ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDeleted      ()))
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
          case "": tilda.data.ObjectPerf_Factory.toJSON(out, (tilda.data.ObjectPerf_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data.ObjectPerf_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data.ObjectPerf_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data.ObjectPerf_Factory.toCSV(out, (tilda.data.ObjectPerf_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data.ObjectPerf_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data.ObjectPerf_Factory");
    }
 }
