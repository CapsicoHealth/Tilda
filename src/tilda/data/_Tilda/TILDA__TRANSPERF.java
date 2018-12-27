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
<TABLE id="TransPerf_DIV" class="tables">
<SCRIPT>registerStickyHeader("TransPerf_DIV");</SCRIPT>
<TR valign="top"><TD><H2>TransPerf&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#TransPerf_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="TransPerf_CNT" class="content">
The Table TILDA.TransPerf:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>TransPerf_Factory</B>, <B>TransPerf_Data</B> in the package <B>tilda.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Defines foreign key(s) to <A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A> </LI>
<LI>Has the following identity:<UL><LI>Primary Key: startPeriod</LI>
</UL></LI>
</UL>
<B>Description</B>: Performance logs for the Tilda framework<BR>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="TransPerf_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('TransPerf-startPeriodTZ')" align="right"><B id='TransPerf-startPeriodTZ_DIV' class='columns dotted_underline cursor_pointer'>startPeriodTZ</B>&nbsp;&nbsp;</TD>
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
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-startPeriod_DIV' class='columns'>startPeriod</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('TransPerf-endPeriodTZ')" align="right"><B id='TransPerf-endPeriodTZ_DIV' class='columns dotted_underline cursor_pointer'>endPeriodTZ</B>&nbsp;&nbsp;</TD>
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
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-endPeriod_DIV' class='columns'>endPeriod</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-commitNano_DIV' class='columns'>commitNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>commitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-commitCount_DIV' class='columns'>commitCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>commitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-rollbackNano_DIV' class='columns'>rollbackNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>rollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-rollbackCount_DIV' class='columns'>rollbackCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>rollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-savepointSetNano_DIV' class='columns'>savepointSetNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-savepointSetCount_DIV' class='columns'>savepointSetCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-savepointCommitNano_DIV' class='columns'>savepointCommitNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-savepointCommitCount_DIV' class='columns'>savepointCommitCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-savepointRollbackNano_DIV' class='columns'>savepointRollbackNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-savepointRollbackCount_DIV' class='columns'>savepointRollbackCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-statementCloseNano_DIV' class='columns'>statementCloseNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-statementCloseCount_DIV' class='columns'>statementCloseCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-connectionCloseNano_DIV' class='columns'>connectionCloseNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-connectionCloseCount_DIV' class='columns'>connectionCloseCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-connectionGetNano_DIV' class='columns'>connectionGetNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>20&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-connectionGetCount_DIV' class='columns'>connectionGetCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>21&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-tildaSetterNano_DIV' class='columns'>tildaSetterNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>22&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-tildaSetterCount_DIV' class='columns'>tildaSetterCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>23&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-tildaToStringNano_DIV' class='columns'>tildaToStringNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>24&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-tildaToStringCount_DIV' class='columns'>tildaToStringCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>25&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-tildaToJsonNano_DIV' class='columns'>tildaToJsonNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>26&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-tildaToJsonCount_DIV' class='columns'>tildaToJsonCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>27&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-tildaToCsvNano_DIV' class='columns'>tildaToCsvNano</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>28&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-tildaToCsvCount_DIV' class='columns'>tildaToCsvCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Blah...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>29&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created. (TILDA.TransPerf)</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>30&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDA.TransPerf)</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>31&nbsp;&nbsp;</TD>
<TD align="right"><B id='TransPerf-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD>
</TR>
</TABLE></BLOCKQUOTE>
<DIV id='TransPerf-startPeriodTZ_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-startPeriodTZ_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-startPeriodTZ_DIV'>startPeriodTZ</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo_DIV'>ZoneInfo</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo-id_DIV'>id</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-startPeriod_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-startPeriod_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-startPeriod_DIV'>startPeriod</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-endPeriodTZ_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-endPeriodTZ_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-endPeriodTZ_DIV'>endPeriodTZ</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo_DIV'>ZoneInfo</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#ZoneInfo-id_DIV'>id</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-endPeriod_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-endPeriod_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-endPeriod_DIV'>endPeriod</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-commitNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-commitNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-commitNano_DIV'>commitNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-commitCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-commitCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-commitCount_DIV'>commitCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-rollbackNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-rollbackNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-rollbackNano_DIV'>rollbackNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-rollbackCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-rollbackCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-rollbackCount_DIV'>rollbackCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-savepointSetNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-savepointSetNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-savepointSetNano_DIV'>savepointSetNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-savepointSetCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-savepointSetCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-savepointSetCount_DIV'>savepointSetCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-savepointCommitNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-savepointCommitNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-savepointCommitNano_DIV'>savepointCommitNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-savepointCommitCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-savepointCommitCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-savepointCommitCount_DIV'>savepointCommitCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-savepointRollbackNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-savepointRollbackNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-savepointRollbackNano_DIV'>savepointRollbackNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-savepointRollbackCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-savepointRollbackCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-savepointRollbackCount_DIV'>savepointRollbackCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-statementCloseNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-statementCloseNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-statementCloseNano_DIV'>statementCloseNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-statementCloseCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-statementCloseCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-statementCloseCount_DIV'>statementCloseCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-connectionCloseNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-connectionCloseNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-connectionCloseNano_DIV'>connectionCloseNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-connectionCloseCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-connectionCloseCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-connectionCloseCount_DIV'>connectionCloseCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-connectionGetNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-connectionGetNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-connectionGetNano_DIV'>connectionGetNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-connectionGetCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-connectionGetCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-connectionGetCount_DIV'>connectionGetCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-tildaSetterNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-tildaSetterNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-tildaSetterNano_DIV'>tildaSetterNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-tildaSetterCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-tildaSetterCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-tildaSetterCount_DIV'>tildaSetterCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-tildaToStringNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-tildaToStringNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-tildaToStringNano_DIV'>tildaToStringNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-tildaToStringCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-tildaToStringCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-tildaToStringCount_DIV'>tildaToStringCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-tildaToJsonNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-tildaToJsonNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-tildaToJsonNano_DIV'>tildaToJsonNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-tildaToJsonCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-tildaToJsonCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-tildaToJsonCount_DIV'>tildaToJsonCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-tildaToCsvNano_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-tildaToCsvNano_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-tildaToCsvNano_DIV'>tildaToCsvNano</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-tildaToCsvCount_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-tildaToCsvCount_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-tildaToCsvCount_DIV'>tildaToCsvCount</a> -- INTEGER</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-created_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-created_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-created_DIV'>created</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-lastUpdated_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-lastUpdated_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-lastUpdated_DIV'>lastUpdated</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TransPerf-deleted_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TransPerf-deleted_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf_DIV'>TransPerf</a></td>
<td><a href='TILDA___Docs.TILDA.html#TransPerf-deleted_DIV'>deleted</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
</DIV>

 @author   Tilda code gen for Java 8/PostgreSQL
 @version  Tilda 1.0
 @generated Dec 27 2018, 11:57:00EST
*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TRANSPERF implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TRANSPERF.class.getName());

   public static final Class<TILDA__TRANSPERF_Factory> FACTORY_CLASS= TILDA__TRANSPERF_Factory.class;
   public static final String TABLENAME = TextUtil.Print("TILDA.TransPerf", "");

   protected TILDA__TRANSPERF() { }

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
//   Field tilda.data.TILDA.TransPerf.startPeriodTZ -> TILDA.TransPerf."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.startPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.startPeriodTZ of type character(5)</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.startPeriodTZ -> TILDA.TransPerf."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.startPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.startPeriodTZ of type character(5)</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.startPeriodTZ -> TILDA.TransPerf."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.startPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.startPeriodTZ of type character(5)</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.TransPerf.startPeriodTZ to null: it's not nullable.");
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.TransPerf.startPeriodTZ: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5.");
       else if (v.equals(_startPeriodTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TransPerf.startPeriodTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ._Mask);
       _startPeriodTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.startPeriodTZ -> TILDA.TransPerf."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.startPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.startPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedStartPeriodTZ()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.startPeriod -> TILDA.TransPerf."startPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.startPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.startPeriod of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.startPeriod -> TILDA.TransPerf."startPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.startPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.startPeriod of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.startPeriod -> TILDA.TransPerf."startPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.startPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.startPeriod of type timestamptz</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.TransPerf.startPeriod to null: it's not nullable.");
       else if (v.equals(_startPeriod) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TransPerf.startPeriod' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.STARTPERIOD._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.STARTPERIOD._Mask);
       _startPeriod = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TransPerf.startPeriod' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setStartPeriodTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.endPeriodTZ -> TILDA.TransPerf."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriodTZ of type character(5)</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.endPeriodTZ -> TILDA.TransPerf."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriodTZ of type character(5)</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.endPeriodTZ -> TILDA.TransPerf."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriodTZ of type character(5)</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.TransPerf.endPeriodTZ to null: it's not nullable.");
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.TransPerf.endPeriodTZ: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5.");
       else if (v.equals(_endPeriodTZ) == false)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ._Mask);
       _endPeriodTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.endPeriodTZ -> TILDA.TransPerf."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriodTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriodTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedEndPeriodTZ()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.endPeriod -> TILDA.TransPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriod of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.endPeriod -> TILDA.TransPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriod of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.endPeriod -> TILDA.TransPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriod of type timestamptz</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.TransPerf.endPeriod to null: it's not nullable.");
       else if (v.equals(_endPeriod) == false)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask);
       _endPeriod = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TransPerf.endPeriod' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setEndPeriodTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.endPeriod -> TILDA.TransPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriod of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.endPeriod -> TILDA.TransPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriod of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.endPeriod -> TILDA.TransPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriod of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.TransPerf.endPeriod -> TILDA.TransPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriod of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriod of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedEndPeriod()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.commitNano -> TILDA.TransPerf."commitNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.commitNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.commitNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _commitNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.commitNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _commitNano_Values = {
                                               { "0", "commitNano_CreateDefault", "commitNano_CreateDefault", "" }
                                  };
   public static final long _commitNanoCommitNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.commitNano -> TILDA.TransPerf."commitNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.commitNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.commitNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getCommitNano()
      { return _commitNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.commitNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>commitNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>commitNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>commitNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isCommitNanoCommitNano_CreateDefault()
      { return _commitNano == _commitNanoCommitNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.commitNano -> TILDA.TransPerf."commitNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.commitNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.commitNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setCommitNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _commitNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.COMMITNANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.COMMITNANO._Mask);
       _commitNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.commitNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>commitNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>commitNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>commitNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setCommitNanoCommitNano_CreateDefault() throws Exception
      { setCommitNano(_commitNanoCommitNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.commitNano -> TILDA.TransPerf."commitNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.commitNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.commitNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedCommitNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.COMMITNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.commitCount -> TILDA.TransPerf."commitCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.commitCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.commitCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _commitCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.commitCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _commitCount_Values = {
                                               { "0", "commitCount_CreateDefault", "commitCount_CreateDefault", "" }
                                  };
   public static final int _commitCountCommitCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.commitCount -> TILDA.TransPerf."commitCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.commitCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.commitCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getCommitCount()
      { return _commitCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.commitCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>commitCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>commitCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>commitCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isCommitCountCommitCount_CreateDefault()
      { return _commitCount == _commitCountCommitCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.commitCount -> TILDA.TransPerf."commitCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.commitCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.commitCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setCommitCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _commitCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.COMMITCOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.COMMITCOUNT._Mask);
       _commitCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.commitCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>commitCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>commitCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>commitCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setCommitCountCommitCount_CreateDefault() throws Exception
      { setCommitCount(_commitCountCommitCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.commitCount -> TILDA.TransPerf."commitCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.commitCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.commitCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedCommitCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.COMMITCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.rollbackNano -> TILDA.TransPerf."rollbackNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.rollbackNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.rollbackNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _rollbackNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.rollbackNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _rollbackNano_Values = {
                                               { "0", "rollbackNano_CreateDefault", "rollbackNano_CreateDefault", "" }
                                  };
   public static final long _rollbackNanoRollbackNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.rollbackNano -> TILDA.TransPerf."rollbackNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.rollbackNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.rollbackNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getRollbackNano()
      { return _rollbackNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.rollbackNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rollbackNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>rollbackNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>rollbackNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isRollbackNanoRollbackNano_CreateDefault()
      { return _rollbackNano == _rollbackNanoRollbackNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.rollbackNano -> TILDA.TransPerf."rollbackNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.rollbackNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.rollbackNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setRollbackNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _rollbackNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.ROLLBACKNANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.ROLLBACKNANO._Mask);
       _rollbackNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.rollbackNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rollbackNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>rollbackNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>rollbackNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setRollbackNanoRollbackNano_CreateDefault() throws Exception
      { setRollbackNano(_rollbackNanoRollbackNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.rollbackNano -> TILDA.TransPerf."rollbackNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.rollbackNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.rollbackNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedRollbackNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ROLLBACKNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.rollbackCount -> TILDA.TransPerf."rollbackCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.rollbackCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.rollbackCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _rollbackCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.rollbackCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _rollbackCount_Values = {
                                               { "0", "rollbackCount_CreateDefault", "rollbackCount_CreateDefault", "" }
                                  };
   public static final int _rollbackCountRollbackCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.rollbackCount -> TILDA.TransPerf."rollbackCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.rollbackCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.rollbackCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getRollbackCount()
      { return _rollbackCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.rollbackCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rollbackCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>rollbackCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>rollbackCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isRollbackCountRollbackCount_CreateDefault()
      { return _rollbackCount == _rollbackCountRollbackCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.rollbackCount -> TILDA.TransPerf."rollbackCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.rollbackCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.rollbackCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setRollbackCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _rollbackCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.ROLLBACKCOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.ROLLBACKCOUNT._Mask);
       _rollbackCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.rollbackCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rollbackCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>rollbackCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>rollbackCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setRollbackCountRollbackCount_CreateDefault() throws Exception
      { setRollbackCount(_rollbackCountRollbackCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.rollbackCount -> TILDA.TransPerf."rollbackCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.rollbackCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.rollbackCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedRollbackCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ROLLBACKCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointSetNano -> TILDA.TransPerf."savepointSetNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointSetNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointSetNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _savepointSetNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.savepointSetNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _savepointSetNano_Values = {
                                               { "0", "savepointSetNano_CreateDefault", "savepointSetNano_CreateDefault", "" }
                                  };
   public static final long _savepointSetNanoSavepointSetNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointSetNano -> TILDA.TransPerf."savepointSetNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointSetNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointSetNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getSavepointSetNano()
      { return _savepointSetNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.savepointSetNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointSetNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointSetNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointSetNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isSavepointSetNanoSavepointSetNano_CreateDefault()
      { return _savepointSetNano == _savepointSetNanoSavepointSetNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointSetNano -> TILDA.TransPerf."savepointSetNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointSetNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointSetNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setSavepointSetNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _savepointSetNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETNANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETNANO._Mask);
       _savepointSetNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.savepointSetNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointSetNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointSetNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointSetNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setSavepointSetNanoSavepointSetNano_CreateDefault() throws Exception
      { setSavepointSetNano(_savepointSetNanoSavepointSetNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointSetNano -> TILDA.TransPerf."savepointSetNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointSetNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointSetNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedSavepointSetNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointSetCount -> TILDA.TransPerf."savepointSetCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointSetCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointSetCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _savepointSetCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.savepointSetCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _savepointSetCount_Values = {
                                               { "0", "savepointSetCount_CreateDefault", "savepointSetCount_CreateDefault", "" }
                                  };
   public static final int _savepointSetCountSavepointSetCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointSetCount -> TILDA.TransPerf."savepointSetCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointSetCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointSetCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getSavepointSetCount()
      { return _savepointSetCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.savepointSetCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointSetCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointSetCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointSetCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isSavepointSetCountSavepointSetCount_CreateDefault()
      { return _savepointSetCount == _savepointSetCountSavepointSetCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointSetCount -> TILDA.TransPerf."savepointSetCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointSetCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointSetCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setSavepointSetCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _savepointSetCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETCOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETCOUNT._Mask);
       _savepointSetCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.savepointSetCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointSetCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointSetCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointSetCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setSavepointSetCountSavepointSetCount_CreateDefault() throws Exception
      { setSavepointSetCount(_savepointSetCountSavepointSetCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointSetCount -> TILDA.TransPerf."savepointSetCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointSetCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointSetCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedSavepointSetCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointCommitNano -> TILDA.TransPerf."savepointCommitNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointCommitNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointCommitNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _savepointCommitNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.savepointCommitNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _savepointCommitNano_Values = {
                                               { "0", "savepointCommitNano_CreateDefault", "savepointCommitNano_CreateDefault", "" }
                                  };
   public static final long _savepointCommitNanoSavepointCommitNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointCommitNano -> TILDA.TransPerf."savepointCommitNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointCommitNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointCommitNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getSavepointCommitNano()
      { return _savepointCommitNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.savepointCommitNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointCommitNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointCommitNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointCommitNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isSavepointCommitNanoSavepointCommitNano_CreateDefault()
      { return _savepointCommitNano == _savepointCommitNanoSavepointCommitNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointCommitNano -> TILDA.TransPerf."savepointCommitNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointCommitNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointCommitNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setSavepointCommitNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _savepointCommitNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITNANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITNANO._Mask);
       _savepointCommitNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.savepointCommitNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointCommitNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointCommitNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointCommitNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setSavepointCommitNanoSavepointCommitNano_CreateDefault() throws Exception
      { setSavepointCommitNano(_savepointCommitNanoSavepointCommitNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointCommitNano -> TILDA.TransPerf."savepointCommitNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointCommitNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointCommitNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedSavepointCommitNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointCommitCount -> TILDA.TransPerf."savepointCommitCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointCommitCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointCommitCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _savepointCommitCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.savepointCommitCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _savepointCommitCount_Values = {
                                               { "0", "savepointCommitCount_CreateDefault", "savepointCommitCount_CreateDefault", "" }
                                  };
   public static final int _savepointCommitCountSavepointCommitCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointCommitCount -> TILDA.TransPerf."savepointCommitCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointCommitCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointCommitCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getSavepointCommitCount()
      { return _savepointCommitCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.savepointCommitCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointCommitCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointCommitCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointCommitCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isSavepointCommitCountSavepointCommitCount_CreateDefault()
      { return _savepointCommitCount == _savepointCommitCountSavepointCommitCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointCommitCount -> TILDA.TransPerf."savepointCommitCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointCommitCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointCommitCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setSavepointCommitCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _savepointCommitCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITCOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITCOUNT._Mask);
       _savepointCommitCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.savepointCommitCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointCommitCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointCommitCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointCommitCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setSavepointCommitCountSavepointCommitCount_CreateDefault() throws Exception
      { setSavepointCommitCount(_savepointCommitCountSavepointCommitCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointCommitCount -> TILDA.TransPerf."savepointCommitCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointCommitCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointCommitCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedSavepointCommitCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointRollbackNano -> TILDA.TransPerf."savepointRollbackNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointRollbackNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointRollbackNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _savepointRollbackNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.savepointRollbackNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _savepointRollbackNano_Values = {
                                               { "0", "savepointRollbackNano_CreateDefault", "savepointRollbackNano_CreateDefault", "" }
                                  };
   public static final long _savepointRollbackNanoSavepointRollbackNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointRollbackNano -> TILDA.TransPerf."savepointRollbackNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointRollbackNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointRollbackNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getSavepointRollbackNano()
      { return _savepointRollbackNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.savepointRollbackNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isSavepointRollbackNanoSavepointRollbackNano_CreateDefault()
      { return _savepointRollbackNano == _savepointRollbackNanoSavepointRollbackNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointRollbackNano -> TILDA.TransPerf."savepointRollbackNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointRollbackNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointRollbackNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setSavepointRollbackNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _savepointRollbackNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKNANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKNANO._Mask);
       _savepointRollbackNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.savepointRollbackNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setSavepointRollbackNanoSavepointRollbackNano_CreateDefault() throws Exception
      { setSavepointRollbackNano(_savepointRollbackNanoSavepointRollbackNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointRollbackNano -> TILDA.TransPerf."savepointRollbackNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointRollbackNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointRollbackNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedSavepointRollbackNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointRollbackCount -> TILDA.TransPerf."savepointRollbackCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointRollbackCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointRollbackCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _savepointRollbackCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.savepointRollbackCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _savepointRollbackCount_Values = {
                                               { "0", "savepointRollbackCount_CreateDefault", "savepointRollbackCount_CreateDefault", "" }
                                  };
   public static final int _savepointRollbackCountSavepointRollbackCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointRollbackCount -> TILDA.TransPerf."savepointRollbackCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointRollbackCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointRollbackCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getSavepointRollbackCount()
      { return _savepointRollbackCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.savepointRollbackCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isSavepointRollbackCountSavepointRollbackCount_CreateDefault()
      { return _savepointRollbackCount == _savepointRollbackCountSavepointRollbackCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointRollbackCount -> TILDA.TransPerf."savepointRollbackCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointRollbackCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointRollbackCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setSavepointRollbackCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _savepointRollbackCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKCOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKCOUNT._Mask);
       _savepointRollbackCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.savepointRollbackCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setSavepointRollbackCountSavepointRollbackCount_CreateDefault() throws Exception
      { setSavepointRollbackCount(_savepointRollbackCountSavepointRollbackCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointRollbackCount -> TILDA.TransPerf."savepointRollbackCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointRollbackCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointRollbackCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedSavepointRollbackCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.statementCloseNano -> TILDA.TransPerf."statementCloseNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.statementCloseNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.statementCloseNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _statementCloseNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.statementCloseNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _statementCloseNano_Values = {
                                               { "0", "statementCloseNano_CreateDefault", "statementCloseNano_CreateDefault", "" }
                                  };
   public static final long _statementCloseNanoStatementCloseNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.statementCloseNano -> TILDA.TransPerf."statementCloseNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.statementCloseNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.statementCloseNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getStatementCloseNano()
      { return _statementCloseNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.statementCloseNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>statementCloseNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>statementCloseNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>statementCloseNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isStatementCloseNanoStatementCloseNano_CreateDefault()
      { return _statementCloseNano == _statementCloseNanoStatementCloseNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.statementCloseNano -> TILDA.TransPerf."statementCloseNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.statementCloseNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.statementCloseNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setStatementCloseNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _statementCloseNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSENANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSENANO._Mask);
       _statementCloseNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.statementCloseNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>statementCloseNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>statementCloseNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>statementCloseNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setStatementCloseNanoStatementCloseNano_CreateDefault() throws Exception
      { setStatementCloseNano(_statementCloseNanoStatementCloseNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.statementCloseNano -> TILDA.TransPerf."statementCloseNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.statementCloseNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.statementCloseNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedStatementCloseNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSENANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.statementCloseCount -> TILDA.TransPerf."statementCloseCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.statementCloseCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.statementCloseCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _statementCloseCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.statementCloseCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _statementCloseCount_Values = {
                                               { "0", "statementCloseCount_CreateDefault", "statementCloseCount_CreateDefault", "" }
                                  };
   public static final int _statementCloseCountStatementCloseCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.statementCloseCount -> TILDA.TransPerf."statementCloseCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.statementCloseCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.statementCloseCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getStatementCloseCount()
      { return _statementCloseCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.statementCloseCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>statementCloseCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>statementCloseCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>statementCloseCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isStatementCloseCountStatementCloseCount_CreateDefault()
      { return _statementCloseCount == _statementCloseCountStatementCloseCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.statementCloseCount -> TILDA.TransPerf."statementCloseCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.statementCloseCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.statementCloseCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setStatementCloseCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _statementCloseCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSECOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSECOUNT._Mask);
       _statementCloseCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.statementCloseCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>statementCloseCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>statementCloseCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>statementCloseCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setStatementCloseCountStatementCloseCount_CreateDefault() throws Exception
      { setStatementCloseCount(_statementCloseCountStatementCloseCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.statementCloseCount -> TILDA.TransPerf."statementCloseCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.statementCloseCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.statementCloseCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedStatementCloseCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSECOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionCloseNano -> TILDA.TransPerf."connectionCloseNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionCloseNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionCloseNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _connectionCloseNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.connectionCloseNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _connectionCloseNano_Values = {
                                               { "0", "connectionCloseNano_CreateDefault", "connectionCloseNano_CreateDefault", "" }
                                  };
   public static final long _connectionCloseNanoConnectionCloseNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionCloseNano -> TILDA.TransPerf."connectionCloseNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionCloseNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionCloseNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getConnectionCloseNano()
      { return _connectionCloseNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.connectionCloseNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionCloseNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>connectionCloseNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>connectionCloseNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isConnectionCloseNanoConnectionCloseNano_CreateDefault()
      { return _connectionCloseNano == _connectionCloseNanoConnectionCloseNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionCloseNano -> TILDA.TransPerf."connectionCloseNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionCloseNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionCloseNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setConnectionCloseNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _connectionCloseNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSENANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSENANO._Mask);
       _connectionCloseNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.connectionCloseNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionCloseNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>connectionCloseNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>connectionCloseNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setConnectionCloseNanoConnectionCloseNano_CreateDefault() throws Exception
      { setConnectionCloseNano(_connectionCloseNanoConnectionCloseNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionCloseNano -> TILDA.TransPerf."connectionCloseNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionCloseNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionCloseNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedConnectionCloseNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSENANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionCloseCount -> TILDA.TransPerf."connectionCloseCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionCloseCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionCloseCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _connectionCloseCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.connectionCloseCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _connectionCloseCount_Values = {
                                               { "0", "connectionCloseCount_CreateDefault", "connectionCloseCount_CreateDefault", "" }
                                  };
   public static final int _connectionCloseCountConnectionCloseCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionCloseCount -> TILDA.TransPerf."connectionCloseCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionCloseCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionCloseCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getConnectionCloseCount()
      { return _connectionCloseCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.connectionCloseCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionCloseCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>connectionCloseCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>connectionCloseCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isConnectionCloseCountConnectionCloseCount_CreateDefault()
      { return _connectionCloseCount == _connectionCloseCountConnectionCloseCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionCloseCount -> TILDA.TransPerf."connectionCloseCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionCloseCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionCloseCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setConnectionCloseCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _connectionCloseCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSECOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSECOUNT._Mask);
       _connectionCloseCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.connectionCloseCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionCloseCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>connectionCloseCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>connectionCloseCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setConnectionCloseCountConnectionCloseCount_CreateDefault() throws Exception
      { setConnectionCloseCount(_connectionCloseCountConnectionCloseCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionCloseCount -> TILDA.TransPerf."connectionCloseCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionCloseCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionCloseCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedConnectionCloseCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSECOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionGetNano -> TILDA.TransPerf."connectionGetNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionGetNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionGetNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _connectionGetNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.connectionGetNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _connectionGetNano_Values = {
                                               { "0", "connectionGetNano_CreateDefault", "connectionGetNano_CreateDefault", "" }
                                  };
   public static final long _connectionGetNanoConnectionGetNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionGetNano -> TILDA.TransPerf."connectionGetNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionGetNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionGetNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getConnectionGetNano()
      { return _connectionGetNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.connectionGetNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionGetNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>connectionGetNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>connectionGetNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isConnectionGetNanoConnectionGetNano_CreateDefault()
      { return _connectionGetNano == _connectionGetNanoConnectionGetNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionGetNano -> TILDA.TransPerf."connectionGetNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionGetNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionGetNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setConnectionGetNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _connectionGetNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETNANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETNANO._Mask);
       _connectionGetNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.connectionGetNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionGetNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>connectionGetNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>connectionGetNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setConnectionGetNanoConnectionGetNano_CreateDefault() throws Exception
      { setConnectionGetNano(_connectionGetNanoConnectionGetNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionGetNano -> TILDA.TransPerf."connectionGetNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionGetNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionGetNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedConnectionGetNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionGetCount -> TILDA.TransPerf."connectionGetCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionGetCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionGetCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _connectionGetCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.connectionGetCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _connectionGetCount_Values = {
                                               { "0", "connectionGetCount_CreateDefault", "connectionGetCount_CreateDefault", "" }
                                  };
   public static final int _connectionGetCountConnectionGetCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionGetCount -> TILDA.TransPerf."connectionGetCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionGetCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionGetCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getConnectionGetCount()
      { return _connectionGetCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.connectionGetCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionGetCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>connectionGetCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>connectionGetCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isConnectionGetCountConnectionGetCount_CreateDefault()
      { return _connectionGetCount == _connectionGetCountConnectionGetCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionGetCount -> TILDA.TransPerf."connectionGetCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionGetCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionGetCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setConnectionGetCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _connectionGetCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETCOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETCOUNT._Mask);
       _connectionGetCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.connectionGetCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionGetCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>connectionGetCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>connectionGetCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setConnectionGetCountConnectionGetCount_CreateDefault() throws Exception
      { setConnectionGetCount(_connectionGetCountConnectionGetCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionGetCount -> TILDA.TransPerf."connectionGetCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionGetCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionGetCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedConnectionGetCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaSetterNano -> TILDA.TransPerf."tildaSetterNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaSetterNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaSetterNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _tildaSetterNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.tildaSetterNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _tildaSetterNano_Values = {
                                               { "0", "tildaSetterNano_CreateDefault", "tildaSetterNano_CreateDefault", "" }
                                  };
   public static final long _tildaSetterNanoTildaSetterNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaSetterNano -> TILDA.TransPerf."tildaSetterNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaSetterNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaSetterNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getTildaSetterNano()
      { return _tildaSetterNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.tildaSetterNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaSetterNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaSetterNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaSetterNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isTildaSetterNanoTildaSetterNano_CreateDefault()
      { return _tildaSetterNano == _tildaSetterNanoTildaSetterNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaSetterNano -> TILDA.TransPerf."tildaSetterNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaSetterNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaSetterNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setTildaSetterNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _tildaSetterNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.TILDASETTERNANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.TILDASETTERNANO._Mask);
       _tildaSetterNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.tildaSetterNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaSetterNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaSetterNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaSetterNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setTildaSetterNanoTildaSetterNano_CreateDefault() throws Exception
      { setTildaSetterNano(_tildaSetterNanoTildaSetterNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaSetterNano -> TILDA.TransPerf."tildaSetterNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaSetterNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaSetterNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedTildaSetterNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDASETTERNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaSetterCount -> TILDA.TransPerf."tildaSetterCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaSetterCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaSetterCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _tildaSetterCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.tildaSetterCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _tildaSetterCount_Values = {
                                               { "0", "tildaSetterCount_CreateDefault", "tildaSetterCount_CreateDefault", "" }
                                  };
   public static final int _tildaSetterCountTildaSetterCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaSetterCount -> TILDA.TransPerf."tildaSetterCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaSetterCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaSetterCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getTildaSetterCount()
      { return _tildaSetterCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.tildaSetterCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaSetterCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaSetterCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaSetterCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isTildaSetterCountTildaSetterCount_CreateDefault()
      { return _tildaSetterCount == _tildaSetterCountTildaSetterCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaSetterCount -> TILDA.TransPerf."tildaSetterCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaSetterCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaSetterCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setTildaSetterCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _tildaSetterCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.TILDASETTERCOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.TILDASETTERCOUNT._Mask);
       _tildaSetterCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.tildaSetterCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaSetterCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaSetterCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaSetterCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setTildaSetterCountTildaSetterCount_CreateDefault() throws Exception
      { setTildaSetterCount(_tildaSetterCountTildaSetterCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaSetterCount -> TILDA.TransPerf."tildaSetterCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaSetterCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaSetterCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedTildaSetterCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDASETTERCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToStringNano -> TILDA.TransPerf."tildaToStringNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToStringNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToStringNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _tildaToStringNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.tildaToStringNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _tildaToStringNano_Values = {
                                               { "0", "tildaToStringNano_CreateDefault", "tildaToStringNano_CreateDefault", "" }
                                  };
   public static final long _tildaToStringNanoTildaToStringNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToStringNano -> TILDA.TransPerf."tildaToStringNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToStringNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToStringNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getTildaToStringNano()
      { return _tildaToStringNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.tildaToStringNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToStringNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToStringNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToStringNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isTildaToStringNanoTildaToStringNano_CreateDefault()
      { return _tildaToStringNano == _tildaToStringNanoTildaToStringNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToStringNano -> TILDA.TransPerf."tildaToStringNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToStringNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToStringNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setTildaToStringNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _tildaToStringNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGNANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGNANO._Mask);
       _tildaToStringNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.tildaToStringNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToStringNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToStringNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToStringNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setTildaToStringNanoTildaToStringNano_CreateDefault() throws Exception
      { setTildaToStringNano(_tildaToStringNanoTildaToStringNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToStringNano -> TILDA.TransPerf."tildaToStringNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToStringNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToStringNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedTildaToStringNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToStringCount -> TILDA.TransPerf."tildaToStringCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToStringCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToStringCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _tildaToStringCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.tildaToStringCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _tildaToStringCount_Values = {
                                               { "0", "tildaToStringCount_CreateDefault", "tildaToStringCount_CreateDefault", "" }
                                  };
   public static final int _tildaToStringCountTildaToStringCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToStringCount -> TILDA.TransPerf."tildaToStringCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToStringCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToStringCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getTildaToStringCount()
      { return _tildaToStringCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.tildaToStringCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToStringCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToStringCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToStringCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isTildaToStringCountTildaToStringCount_CreateDefault()
      { return _tildaToStringCount == _tildaToStringCountTildaToStringCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToStringCount -> TILDA.TransPerf."tildaToStringCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToStringCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToStringCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setTildaToStringCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _tildaToStringCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGCOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGCOUNT._Mask);
       _tildaToStringCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.tildaToStringCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToStringCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToStringCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToStringCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setTildaToStringCountTildaToStringCount_CreateDefault() throws Exception
      { setTildaToStringCount(_tildaToStringCountTildaToStringCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToStringCount -> TILDA.TransPerf."tildaToStringCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToStringCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToStringCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedTildaToStringCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToJsonNano -> TILDA.TransPerf."tildaToJsonNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToJsonNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToJsonNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _tildaToJsonNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.tildaToJsonNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _tildaToJsonNano_Values = {
                                               { "0", "tildaToJsonNano_CreateDefault", "tildaToJsonNano_CreateDefault", "" }
                                  };
   public static final long _tildaToJsonNanoTildaToJsonNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToJsonNano -> TILDA.TransPerf."tildaToJsonNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToJsonNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToJsonNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getTildaToJsonNano()
      { return _tildaToJsonNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.tildaToJsonNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isTildaToJsonNanoTildaToJsonNano_CreateDefault()
      { return _tildaToJsonNano == _tildaToJsonNanoTildaToJsonNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToJsonNano -> TILDA.TransPerf."tildaToJsonNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToJsonNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToJsonNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setTildaToJsonNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _tildaToJsonNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONNANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONNANO._Mask);
       _tildaToJsonNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.tildaToJsonNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setTildaToJsonNanoTildaToJsonNano_CreateDefault() throws Exception
      { setTildaToJsonNano(_tildaToJsonNanoTildaToJsonNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToJsonNano -> TILDA.TransPerf."tildaToJsonNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToJsonNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToJsonNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedTildaToJsonNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToJsonCount -> TILDA.TransPerf."tildaToJsonCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToJsonCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToJsonCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _tildaToJsonCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.tildaToJsonCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _tildaToJsonCount_Values = {
                                               { "0", "tildaToJsonCount_CreateDefault", "tildaToJsonCount_CreateDefault", "" }
                                  };
   public static final int _tildaToJsonCountTildaToJsonCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToJsonCount -> TILDA.TransPerf."tildaToJsonCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToJsonCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToJsonCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getTildaToJsonCount()
      { return _tildaToJsonCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.tildaToJsonCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isTildaToJsonCountTildaToJsonCount_CreateDefault()
      { return _tildaToJsonCount == _tildaToJsonCountTildaToJsonCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToJsonCount -> TILDA.TransPerf."tildaToJsonCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToJsonCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToJsonCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setTildaToJsonCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _tildaToJsonCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONCOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONCOUNT._Mask);
       _tildaToJsonCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.tildaToJsonCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setTildaToJsonCountTildaToJsonCount_CreateDefault() throws Exception
      { setTildaToJsonCount(_tildaToJsonCountTildaToJsonCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToJsonCount -> TILDA.TransPerf."tildaToJsonCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToJsonCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToJsonCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedTildaToJsonCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToCsvNano -> TILDA.TransPerf."tildaToCsvNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToCsvNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToCsvNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   long _tildaToCsvNano= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.tildaToCsvNano, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _tildaToCsvNano_Values = {
                                               { "0", "tildaToCsvNano_CreateDefault", "tildaToCsvNano_CreateDefault", "" }
                                  };
   public static final long _tildaToCsvNanoTildaToCsvNano_CreateDefault = 0l;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToCsvNano -> TILDA.TransPerf."tildaToCsvNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToCsvNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToCsvNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final long getTildaToCsvNano()
      { return _tildaToCsvNano; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.tildaToCsvNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isTildaToCsvNanoTildaToCsvNano_CreateDefault()
      { return _tildaToCsvNano == _tildaToCsvNanoTildaToCsvNano_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToCsvNano -> TILDA.TransPerf."tildaToCsvNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToCsvNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToCsvNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setTildaToCsvNano(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _tildaToCsvNano)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVNANO._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVNANO._Mask);
       _tildaToCsvNano = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.tildaToCsvNano:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
</TABLE>
*/
   public void setTildaToCsvNanoTildaToCsvNano_CreateDefault() throws Exception
      { setTildaToCsvNano(_tildaToCsvNanoTildaToCsvNano_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToCsvNano -> TILDA.TransPerf."tildaToCsvNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToCsvNano of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToCsvNano of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedTildaToCsvNano()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVNANO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToCsvCount -> TILDA.TransPerf."tildaToCsvCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToCsvCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToCsvCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   int _tildaToCsvCount= SystemValues.EVIL_VALUE;
/**
These are the enumerated values for tilda.data.TILDA.TransPerf.tildaToCsvCount, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
</TABLE>
*/
   public static final String[][] _tildaToCsvCount_Values = {
                                               { "0", "tildaToCsvCount_CreateDefault", "tildaToCsvCount_CreateDefault", "" }
                                  };
   public static final int _tildaToCsvCountTildaToCsvCount_CreateDefault = 0;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToCsvCount -> TILDA.TransPerf."tildaToCsvCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToCsvCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToCsvCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final int getTildaToCsvCount()
      { return _tildaToCsvCount; }

/**
This is the value is-a for tilda.data.TILDA.TransPerf.tildaToCsvCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
</TABLE>
*/
   public final boolean isTildaToCsvCountTildaToCsvCount_CreateDefault()
      { return _tildaToCsvCount == _tildaToCsvCountTildaToCsvCount_CreateDefault; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToCsvCount -> TILDA.TransPerf."tildaToCsvCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToCsvCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToCsvCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setTildaToCsvCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _tildaToCsvCount)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVCOUNT._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVCOUNT._Mask);
       _tildaToCsvCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data.TILDA.TransPerf.tildaToCsvCount:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>CREATE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
</TABLE>
*/
   public void setTildaToCsvCountTildaToCsvCount_CreateDefault() throws Exception
      { setTildaToCsvCount(_tildaToCsvCountTildaToCsvCount_CreateDefault); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToCsvCount -> TILDA.TransPerf."tildaToCsvCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToCsvCount of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToCsvCount of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedTildaToCsvCount()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.created -> TILDA.TransPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.created -> TILDA.TransPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.created -> TILDA.TransPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.TransPerf)</TD></TR>
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
        throw new Exception("Cannot set tilda.data.TILDA.TransPerf.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TransPerf.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask);
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.created -> TILDA.TransPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.created -> TILDA.TransPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.created -> TILDA.TransPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.created -> TILDA.TransPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.TransPerf)</TD></TR>
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
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.lastUpdated -> TILDA.TransPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.lastUpdated -> TILDA.TransPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.lastUpdated -> TILDA.TransPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.TransPerf)</TD></TR>
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
        throw new Exception("Cannot set tilda.data.TILDA.TransPerf.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.lastUpdated -> TILDA.TransPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.lastUpdated -> TILDA.TransPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.lastUpdated -> TILDA.TransPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.lastUpdated -> TILDA.TransPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.TransPerf)</TD></TR>
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
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.deleted -> TILDA.TransPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _deleted;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.deleted -> TILDA.TransPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDeleted()
      { return _deleted; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.deleted -> TILDA.TransPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDeleted()
     { return __Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.deleted -> TILDA.TransPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD></TR>
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
          __Changes.or(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask);
          __Nulls.andNot(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask);
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.deleted -> TILDA.TransPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setNullDeleted()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask);
       __Nulls.or(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask);
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.deleted -> TILDA.TransPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.deleted -> TILDA.TransPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.deleted -> TILDA.TransPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD></TR>
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
//   Field tilda.data.TILDA.TransPerf.deleted -> TILDA.TransPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TransPerf.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleted()
     { return __Changes.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void CopyTo(tilda.data._Tilda.TILDA__TRANSPERF Dst) throws Exception
     {
       Dst.setEndPeriodTZ           (_endPeriodTZ           );
       Dst.setEndPeriod             (_endPeriod             );
       Dst.setCommitNano            (_commitNano            );
       Dst.setCommitCount           (_commitCount           );
       Dst.setRollbackNano          (_rollbackNano          );
       Dst.setRollbackCount         (_rollbackCount         );
       Dst.setSavepointSetNano      (_savepointSetNano      );
       Dst.setSavepointSetCount     (_savepointSetCount     );
       Dst.setSavepointCommitNano   (_savepointCommitNano   );
       Dst.setSavepointCommitCount  (_savepointCommitCount  );
       Dst.setSavepointRollbackNano (_savepointRollbackNano );
       Dst.setSavepointRollbackCount(_savepointRollbackCount);
       Dst.setStatementCloseNano    (_statementCloseNano    );
       Dst.setStatementCloseCount   (_statementCloseCount   );
       Dst.setConnectionCloseNano   (_connectionCloseNano   );
       Dst.setConnectionCloseCount  (_connectionCloseCount  );
       Dst.setConnectionGetNano     (_connectionGetNano     );
       Dst.setConnectionGetCount    (_connectionGetCount    );
       Dst.setTildaSetterNano       (_tildaSetterNano       );
       Dst.setTildaSetterCount      (_tildaSetterCount      );
       Dst.setTildaToStringNano     (_tildaToStringNano     );
       Dst.setTildaToStringCount    (_tildaToStringCount    );
       Dst.setTildaToJsonNano       (_tildaToJsonNano       );
       Dst.setTildaToJsonCount      (_tildaToJsonCount      );
       Dst.setTildaToCsvNano        (_tildaToCsvNano        );
       Dst.setTildaToCsvCount       (_tildaToCsvCount       );
       Dst.setLastUpdated           (_lastUpdated           );
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask) == true) Dst.setNullDeleted               (); else        Dst.setDeleted               (_deleted               );
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
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIOD._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_startPeriod) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_endPeriod) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_created) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_deleted) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "TransPerf");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIOD._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.STARTPERIOD.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIOD._Mask) == false && DateTimeUtil.isNowPlaceholder(_startPeriod) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.ENDPERIOD.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask) == false && DateTimeUtil.isNowPlaceholder(_endPeriod) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.COMMITNANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.COMMITNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.COMMITCOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.COMMITCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ROLLBACKNANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.ROLLBACKNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ROLLBACKCOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.ROLLBACKCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETNANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETCOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITNANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITCOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKNANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKCOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSENANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSENANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSECOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSECOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSENANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSENANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSECOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSECOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETNANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETCOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDASETTERNANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.TILDASETTERNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDASETTERCOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.TILDASETTERCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGNANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGCOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONNANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.TILDATOJSONNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONCOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.TILDATOJSONCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVNANO._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.TILDATOCSVNANO.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVCOUNT._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.TILDATOCSVCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__TRANSPERF_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__TRANSPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask) == true) { TILDA__TRANSPERF_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDA", "TransPerf"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIOD._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIOD._Mask) == false && DateTimeUtil.isNowPlaceholder(_startPeriod) == true)
              { TILDA__TRANSPERF_Factory.COLS.STARTPERIOD.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TRANSPERF_Factory.COLS.STARTPERIOD.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask) == false && DateTimeUtil.isNowPlaceholder(_endPeriod) == true)
              { TILDA__TRANSPERF_Factory.COLS.ENDPERIOD.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TRANSPERF_Factory.COLS.ENDPERIOD.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.COMMITNANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.COMMITNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.COMMITCOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.COMMITCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ROLLBACKNANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.ROLLBACKNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ROLLBACKCOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.ROLLBACKCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETNANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETCOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITNANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITCOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKNANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKCOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSENANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSENANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSECOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSECOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSENANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSENANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSECOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSECOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETNANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETCOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDASETTERNANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.TILDASETTERNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDASETTERCOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.TILDASETTERCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGNANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGCOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONNANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.TILDATOJSONNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONCOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.TILDATOJSONCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVNANO._Mask) == true) TILDA__TRANSPERF_Factory.COLS.TILDATOCSVNANO.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVCOUNT._Mask) == true) TILDA__TRANSPERF_Factory.COLS.TILDATOCSVCOUNT.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__TRANSPERF_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TRANSPERF_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__TRANSPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TRANSPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__TRANSPERF_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__TRANSPERF_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TRANSPERF_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0:
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "TransPerf", "startPeriod"); S.append("=?)");
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
       QueryDetails.setLastQuery(TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.TransPerf", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _startPeriodTZ);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIOD._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.STARTPERIOD._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_startPeriod) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_startPeriod.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR   ); else PS.setString   (++i, _endPeriodTZ);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_endPeriod) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_endPeriod.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.COMMITNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.COMMITNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _commitNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.COMMITCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.COMMITCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _commitCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ROLLBACKNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.ROLLBACKNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _rollbackNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.ROLLBACKCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.ROLLBACKCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _rollbackCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _savepointSetNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _savepointSetCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _savepointCommitNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _savepointCommitCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _savepointRollbackNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _savepointRollbackCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSENANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSENANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _statementCloseNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSECOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSECOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _statementCloseCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSENANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSENANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _connectionCloseNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSECOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSECOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _connectionCloseCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _connectionGetNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _connectionGetCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDASETTERNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.TILDASETTERNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _tildaSetterNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDASETTERCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.TILDASETTERCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _tildaSetterCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _tildaToStringNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _tildaToStringCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _tildaToJsonNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _tildaToJsonCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVNANO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVNANO._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT ); else PS.setLong     (++i, _tildaToCsvNano);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER); else PS.setInt      (++i, _tildaToCsvCount);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_created.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_lastUpdated.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, new java.sql.Timestamp(_deleted.toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);
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
             __Saved_startPeriod            = _startPeriod           ;
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
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.TransPerf has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }

       if (BeforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.TransPerf object's BeforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
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
        throw new Exception("This TILDA.TransPerf object is being Read() after a Create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.TransPerf object has already been read.");
          QueryDetails.setLastQuery(TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDA", "TransPerf", "startPeriodTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "startPeriod");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "endPeriodTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "endPeriod");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "commitNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "commitCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "rollbackNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "rollbackCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "savepointSetNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "savepointSetCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "savepointCommitNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "savepointCommitCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "savepointRollbackNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "savepointRollbackCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "statementCloseNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "statementCloseCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "connectionCloseNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "connectionCloseCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "connectionGetNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "connectionGetCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "tildaSetterNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "tildaSetterCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "tildaToStringNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "tildaToStringCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "tildaToJsonNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "tildaToJsonCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "tildaToCsvNano");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "tildaToCsvCount");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "created");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "TransPerf", "deleted");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "TransPerf");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "TransPerf", "startPeriod"); S.append("=?)");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.TransPerf", Q, toString());
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                                       _startPeriodTZ          = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ._Mask         ); else _startPeriodTZ          = _startPeriodTZ         .trim();
      __Saved_startPeriod            = _startPeriod            = ProcessZDT(_startPeriodTZ           , "tilda.data.TILDA.TransPerf.startPeriod"           , RS, ++i, TILDA__TRANSPERF_Factory.COLS.STARTPERIOD           , TILDA__TRANSPERF_Factory.COLS.STARTPERIODTZ           ); if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.STARTPERIOD._Mask           );
                                       _endPeriodTZ            = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ._Mask           ); else _endPeriodTZ            = _endPeriodTZ           .trim();
                                       _endPeriod              = ProcessZDT(_endPeriodTZ             , "tilda.data.TILDA.TransPerf.endPeriod"             , RS, ++i, TILDA__TRANSPERF_Factory.COLS.ENDPERIOD             , TILDA__TRANSPERF_Factory.COLS.ENDPERIODTZ             ); if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.ENDPERIOD._Mask             );
                                       _commitNano             =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.COMMITNANO._Mask            );
                                       _commitCount            =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.COMMITCOUNT._Mask           );
                                       _rollbackNano           =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.ROLLBACKNANO._Mask          );
                                       _rollbackCount          =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.ROLLBACKCOUNT._Mask         );
                                       _savepointSetNano       =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETNANO._Mask      );
                                       _savepointSetCount      =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTSETCOUNT._Mask     );
                                       _savepointCommitNano    =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITNANO._Mask   );
                                       _savepointCommitCount   =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTCOMMITCOUNT._Mask  );
                                       _savepointRollbackNano  =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKNANO._Mask );
                                       _savepointRollbackCount =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.SAVEPOINTROLLBACKCOUNT._Mask);
                                       _statementCloseNano     =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSENANO._Mask    );
                                       _statementCloseCount    =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.STATEMENTCLOSECOUNT._Mask   );
                                       _connectionCloseNano    =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSENANO._Mask   );
                                       _connectionCloseCount   =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.CONNECTIONCLOSECOUNT._Mask  );
                                       _connectionGetNano      =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETNANO._Mask     );
                                       _connectionGetCount     =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.CONNECTIONGETCOUNT._Mask    );
                                       _tildaSetterNano        =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.TILDASETTERNANO._Mask       );
                                       _tildaSetterCount       =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.TILDASETTERCOUNT._Mask      );
                                       _tildaToStringNano      =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGNANO._Mask     );
                                       _tildaToStringCount     =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.TILDATOSTRINGCOUNT._Mask    );
                                       _tildaToJsonNano        =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONNANO._Mask       );
                                       _tildaToJsonCount       =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.TILDATOJSONCOUNT._Mask      );
                                       _tildaToCsvNano         =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVNANO._Mask        );
                                       _tildaToCsvCount        =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.TILDATOCSVCOUNT._Mask       );
                                       _created                = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.CREATED._Mask               );
                                       _lastUpdated            = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.LASTUPDATED._Mask           );
                                       _deleted                = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask               );
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
                   "startPeriod: "                                                                                                              + DateTimeUtil.printDateTimeForJSON(getStartPeriod           ())
               + "; endPeriod: "                                                                                                                + DateTimeUtil.printDateTimeForJSON(getEndPeriod             ())
               + "; commitNano: "                                                                                                               +                                   getCommitNano            () 
               + "; commitCount: "                                                                                                              +                                   getCommitCount           () 
               + "; rollbackNano: "                                                                                                             +                                   getRollbackNano          () 
               + "; rollbackCount: "                                                                                                            +                                   getRollbackCount         () 
               + "; savepointSetNano: "                                                                                                         +                                   getSavepointSetNano      () 
               + "; savepointSetCount: "                                                                                                        +                                   getSavepointSetCount     () 
               + "; savepointCommitNano: "                                                                                                      +                                   getSavepointCommitNano   () 
               + "; savepointCommitCount: "                                                                                                     +                                   getSavepointCommitCount  () 
               + "; savepointRollbackNano: "                                                                                                    +                                   getSavepointRollbackNano () 
               + "; savepointRollbackCount: "                                                                                                   +                                   getSavepointRollbackCount() 
               + "; statementCloseNano: "                                                                                                       +                                   getStatementCloseNano    () 
               + "; statementCloseCount: "                                                                                                      +                                   getStatementCloseCount   () 
               + "; connectionCloseNano: "                                                                                                      +                                   getConnectionCloseNano   () 
               + "; connectionCloseCount: "                                                                                                     +                                   getConnectionCloseCount  () 
               + "; connectionGetNano: "                                                                                                        +                                   getConnectionGetNano     () 
               + "; connectionGetCount: "                                                                                                       +                                   getConnectionGetCount    () 
               + "; tildaSetterNano: "                                                                                                          +                                   getTildaSetterNano       () 
               + "; tildaSetterCount: "                                                                                                         +                                   getTildaSetterCount      () 
               + "; tildaToStringNano: "                                                                                                        +                                   getTildaToStringNano     () 
               + "; tildaToStringCount: "                                                                                                       +                                   getTildaToStringCount    () 
               + "; tildaToJsonNano: "                                                                                                          +                                   getTildaToJsonNano       () 
               + "; tildaToJsonCount: "                                                                                                         +                                   getTildaToJsonCount      () 
               + "; tildaToCsvNano: "                                                                                                           +                                   getTildaToCsvNano        () 
               + "; tildaToCsvCount: "                                                                                                          +                                   getTildaToCsvCount       () 
               + "; created: "                                                                                                                  + DateTimeUtil.printDateTimeForJSON(getCreated               ())
               + "; lastUpdated: "                                                                                                              + DateTimeUtil.printDateTimeForJSON(getLastUpdated           ())
               + "; deleted"                  + (__Nulls.intersects(TILDA__TRANSPERF_Factory.COLS.DELETED._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDeleted               ()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
