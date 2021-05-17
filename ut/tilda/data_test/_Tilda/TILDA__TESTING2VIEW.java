/*
 Tilda V1.0 data object.

 Code is generated: do not modify! Instead, create a derived class and override desired functionality
*/

package tilda.data_test._Tilda;

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
<TABLE id="Testing2View_DIV" class="tables">
<SCRIPT>registerStickyHeader("Testing2View_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Testing2View&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Testing2View_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Testing2View_CNT" class="content">
The View TILDATEST.Testing2View:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Testing2View_Factory</B>, <B>Testing2View_Data</B> in the package <B>tilda.data_test</B>.
<LI>Configured to be Realized to <B><A href="TILDA___Docs.TILDATEST.html#Testing2Realized_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2Realized</A></B> through DB function <B>TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Refill_Testing2Realized()</B>.</LI>
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Defines a foreign key to <A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A> </LI>
</UL>
<B>Description</B>: A test view to test .* and exclude and block.<BR>
<BR>
This view depends on the following filter(s), sub-view(s), and/or root table(s):
<BLOCKQUOTE><TABLE class="TreeTable Rowed" border="0px" cellspacing="0px" cellpadding="2px"><TR><TD><PRE><A href="TILDA___Docs.TILDATEST.html#Testing2View_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View</A></PRE></TD><TD>Active test records<PRE>Testing.deleted is null</PRE></TD></TR>
<TR><TD><PRE>    <A href="TILDA___Docs.TILDATEST.html#Testing_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing</A></PRE></TD><TD><PRE>Root table for the view TILDATEST.Testing2View</PRE></TD></TR>
</TABLE></BLOCKQUOTE>
This View contains the following columns:<BLOCKQUOTE>
 <TABLE id="Testing2View_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left" nowrap><label>Realized<input type="checkbox" onchange="filterTable('Testing2View_TBL', 'R')", id="Testing2View_TBL_R"></label>&nbsp;</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description/<label>Formula<input type="checkbox" onchange="filterTable('Testing2View_TBL', 'F')", id="Testing2View_TBL_F"></label></TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-refnum_DIV' class='columns realizedcolumns'>refnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-refnum_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-name_DIV' class='columns realizedcolumns'>name</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Medical system unique enterprise id<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-name_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>name</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-lastUpdated_DIV' class='columns realizedcolumns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDATEST.Testing)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-lastUpdated_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>lastUpdated</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-xxxLastUpdated_DIV' class='columns realizedcolumns'>xxxLastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDATEST.Testing)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-lastUpdated_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>lastUpdated</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a1_DIV' class='columns realizedcolumns'>a1</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;INTEGER&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a1_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a1</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a3b_DIV' class='columns realizedcolumns'>a3b</B>&nbsp;&nbsp;</TD>
<TD>List<Boolean> List<>&nbsp;/&nbsp;boolean[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a3b_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a3b</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a4_DIV' class='columns realizedcolumns'>a4</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a4_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a4</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a4b_DIV' class='columns realizedcolumns'>a4b</B>&nbsp;&nbsp;</TD>
<TD>List<Double> List<>&nbsp;/&nbsp;double precision[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a4b_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a4b</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a5_DIV' class='columns realizedcolumns'>a5</B>&nbsp;&nbsp;</TD>
<TD>float&nbsp;/&nbsp;real&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a5_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a5</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a5b_DIV' class='columns realizedcolumns'>a5b</B>&nbsp;&nbsp;</TD>
<TD>List<Float> List<>&nbsp;/&nbsp;real[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a5b_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a5b</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a7_DIV' class='columns realizedcolumns'>a7</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a7_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a7</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a7b_DIV' class='columns realizedcolumns'>a7b</B>&nbsp;&nbsp;</TD>
<TD>List<Integer> List<>&nbsp;/&nbsp;integer[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a7b_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a7b</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a8_DIV' class='columns realizedcolumns'>a8</B>&nbsp;&nbsp;</TD>
<TD>byte[]&nbsp;/&nbsp;BYTEA&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a8_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a8</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a8bTZ_DIV' class='columns realizedcolumns'>a8bTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'a8b'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a8bTZ_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a8bTZ</A><BR>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo-id_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo<B>&nbsp;&#8226;&nbsp;</B>id</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a8b_DIV' class='columns realizedcolumns'>a8b</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a8b_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a8b</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a10a_DIV' class='columns realizedcolumns'>a10a</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a10a_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a10a</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a10b_DIV' class='columns realizedcolumns'>a10b</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a10b_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a10b</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a10c_DIV' class='columns realizedcolumns'>a10c</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a10c_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a10c</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a11_DIV' class='columns realizedcolumns'>a11</B>&nbsp;&nbsp;</TD>
<TD>BigDecimal&nbsp;/&nbsp;numeric(8,4)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a11_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a11</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>20&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a11b_DIV' class='columns realizedcolumns'>a11b</B>&nbsp;&nbsp;</TD>
<TD>List<BigDecimal> List<>&nbsp;/&nbsp;numeric(6,3)[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a11b_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a11b</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>21&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a11c_DIV' class='columns realizedcolumns'>a11c</B>&nbsp;&nbsp;</TD>
<TD>BigDecimal&nbsp;/&nbsp;numeric(5,0)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a11c_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a11c</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>22&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a12_DIV' class='columns realizedcolumns'>a12</B>&nbsp;&nbsp;</TD>
<TD>short&nbsp;/&nbsp;smallint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a12_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a12</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>23&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a12b_DIV' class='columns realizedcolumns'>a12b</B>&nbsp;&nbsp;</TD>
<TD>List<Short> List<>&nbsp;/&nbsp;smallint[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a12b_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a12b</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>24&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a13_DIV' class='columns realizedcolumns'>a13</B>&nbsp;&nbsp;</TD>
<TD>UUID&nbsp;/&nbsp;UUID&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a13_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a13</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>25&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a13b_DIV' class='columns realizedcolumns'>a13b</B>&nbsp;&nbsp;</TD>
<TD>List<UUID> List<>&nbsp;/&nbsp;UUID[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a13b_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a13b</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>26&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-description_DIV' class='columns realizedcolumns'>description</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-description_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>description</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>27&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-desc2_DIV' class='columns realizedcolumns'>desc2</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(3000)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-desc2_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>desc2</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>28&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-desc3_DIV' class='columns realizedcolumns'>desc3</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-desc3_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>desc3</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>29&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-desc4_DIV' class='columns realizedcolumns'>desc4</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-desc4_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>desc4</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>30&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-desc5_DIV' class='columns realizedcolumns'>desc5</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-desc5_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>desc5</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>31&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-desc6_DIV' class='columns realizedcolumns'>desc6</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">SMART&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-desc6_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>desc6</A></DIV><BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>32&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a3_DIV' class='formulae realizedformulae'>a3</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Not A3</B>'</TD></TR>
  <TR valign="top" style="background-color:#FFFFFF"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>Blah...</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">NOT <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a3_DIV">a3</A></PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a3_DIV">a3</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a3_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a3</A>
</DIV>
<DIV style="padding-left:10px;">The blah</DIV>
</TD></TR>
</TABLE>
<DIV id='Testing2View-a3_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Testing2View-a3_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Formula Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
</table>
</DIV></DIV>
<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a3_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a3</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>33&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-bastille_DIV' class='formulae realizedformulae'>bastille</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2)"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>Blah...</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">'1789-07-14'</PRE></TD><TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>34&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-toto_DIV' class='formulae realizedformulae'>toto</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR valign="top" style="background-color:#FFFFFF"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>Blah...</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">'2018-08-10'</PRE></TD><TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>35&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-desc2_Cat1_DIV' class='formulae realizedformulae'>desc2_Cat1</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2)"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">case when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-desc2_DIV">desc2</A>  in ('a', 'b', 'c') then 1 else 0 end</PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-desc2_DIV">desc2</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-desc2_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>desc2</A>
</DIV>
<DIV style="padding-left:10px;">The title for a person, i.e., Mr, Miss, Mrs...</DIV>
</TD></TR>
</TABLE>
<DIV id='Testing2View-desc2_Cat1_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Testing2View-desc2_Cat1_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Formula Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
</table>
</DIV></DIV>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>36&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-desc2_Cat2_DIV' class='formulae realizedformulae'>desc2_Cat2</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR valign="top" style="background-color:#FFFFFF"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">case when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-desc2_DIV">desc2</A>  in ('x', 'y', 'z') then 1 else 0 end</PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-desc2_DIV">desc2</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-desc2_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>desc2</A>
</DIV>
<DIV style="padding-left:10px;">The title for a person, i.e., Mr, Miss, Mrs...</DIV>
</TD></TR>
</TABLE>
<DIV id='Testing2View-desc2_Cat2_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Testing2View-desc2_Cat2_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Formula Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
</table>
</DIV></DIV>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>37&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-desc2_Cat3_DIV' class='formulae realizedformulae'>desc2_Cat3</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2)"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">case when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-desc2_DIV">desc2</A>  in ('x', 'y', 'z') then 1 else 0 end</PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-desc2_DIV">desc2</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-desc2_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>desc2</A>
</DIV>
<DIV style="padding-left:10px;">The title for a person, i.e., Mr, Miss, Mrs...</DIV>
</TD></TR>
</TABLE>
<DIV id='Testing2View-desc2_Cat3_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Testing2View-desc2_Cat3_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Formula Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
</table>
</DIV></DIV>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>38&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a7_Cat4_DIV' class='formulae realizedformulae'>a7_Cat4</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR valign="top" style="background-color:#FFFFFF"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>This formula checks whether the column 'a7' value falls in the range of 0.0 and 10.0.</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">case when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a7_DIV">a7</A> >= 0.0 and <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a7_DIV">a7</A> < 10.0 then 1 else 0 end</PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a7_DIV">a7</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a7_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a7</A>
</DIV>
<DIV style="padding-left:10px;">The blah</DIV>
</TD></TR>
</TABLE>
<DIV id='Testing2View-a7_Cat4_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Testing2View-a7_Cat4_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Formula Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
</table>
</DIV></DIV>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>39&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a7_Cat5_DIV' class='formulae realizedformulae'>a7_Cat5</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2)"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>This formula checks whether the column 'a7' value falls in the range of 10.0 and 20.0.</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">case when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a7_DIV">a7</A> >= 10.0 and <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a7_DIV">a7</A> < 20.0 then 1 else 0 end</PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a7_DIV">a7</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a7_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a7</A>
</DIV>
<DIV style="padding-left:10px;">The blah</DIV>
</TD></TR>
</TABLE>
<DIV id='Testing2View-a7_Cat5_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Testing2View-a7_Cat5_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Formula Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
</table>
</DIV></DIV>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>40&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a5_null_DIV' class='formulae realizedformulae'>a5_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR valign="top" style="background-color:#FFFFFF"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>Whether a5 is null or not</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">case when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a5_DIV">a5</A> is null then 1
     when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a5_DIV">a5</A> is not null then 0
end</PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a5_DIV">a5</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a5_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a5</A>
</DIV>
<DIV style="padding-left:10px;">The blah</DIV>
</TD></TR>
</TABLE>
<DIV id='Testing2View-a5_null_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Testing2View-a5_null_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Formula Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
</table>
</DIV></DIV>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>41&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a6_null_DIV' class='formulae realizedformulae'>a6_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2)"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>Whether a6 is null or not</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">case when a6 is null then 1
     when a6 is not null then 0
end</PRE></TD><TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>42&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a7_null_DIV' class='formulae realizedformulae'>a7_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR valign="top" style="background-color:#FFFFFF"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>Whether a7 is null or not</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">case when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a7_DIV">a7</A> is null then 1
     when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a7_DIV">a7</A> is not null then 0
end</PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a7_DIV">a7</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a7_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a7</A>
</DIV>
<DIV style="padding-left:10px;">The blah</DIV>
</TD></TR>
</TABLE>
<DIV id='Testing2View-a7_null_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Testing2View-a7_null_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Formula Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
</table>
</DIV></DIV>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>43&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing2View-a8_null_DIV' class='formulae realizedformulae'>a8_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2)"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Description</B></TD><TD>Whether a8 is null or not</TD></TR><TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">case when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a8_DIV">a8</A> is null then 1
     when <A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a8_DIV">a8</A> is not null then 0
end</PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="TILDA___Docs.TILDATEST.html#Testing2View-a8_DIV">a8</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing-a8_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a8</A>
</DIV>
<DIV style="padding-left:10px;">The blah</DIV>
</TD></TR>
</TABLE>
<DIV id='Testing2View-a8_null_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Testing2View-a8_null_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Formula Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
</table>
</DIV></DIV>
</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TESTING2VIEW implements tilda.interfaces.ReaderObject
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__TESTING2VIEW.class.getName());

   public transient static final Class<TILDA__TESTING2VIEW_Factory> FACTORY_CLASS= TILDA__TESTING2VIEW_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDATEST.Testing2View", "");

   protected TILDA__TESTING2VIEW() { }

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
//   Field tilda.data_test.TILDATEST.Testing2View.refnum -> TILDATEST.Testing2View."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("refnum")
   Long _refnum=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.refnum -> TILDATEST.Testing2View."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getRefnum()
      { return _refnum==null?0l:_refnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.refnum -> TILDATEST.Testing2View."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _refnum == null || v != _refnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.refnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.REFNUM._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.REFNUM._Mask);
       _refnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field refnum doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initRefnum(long v) throws Exception
     {
       setRefnum(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.name -> TILDATEST.Testing2View."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("name")
   String _name=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.name -> TILDATEST.Testing2View."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getName()
      { return _name; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.name -> TILDATEST.Testing2View."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.name to null: it's not nullable.");
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.name: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_name) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.name' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.NAME._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.NAME._Mask);
       _name = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.lastUpdated -> TILDATEST.Testing2View."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing2View.lastUpdated -> TILDATEST.Testing2View."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing2View.lastUpdated -> TILDATEST.Testing2View."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing)</TD></TR>
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
    final void setLastUpdated(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.lastUpdated' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.xxxLastUpdated -> TILDATEST.Testing2View."xxxLastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.xxxLastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.xxxLastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing)</TD></TR>
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
   transient ZonedDateTime _xxxLastUpdated = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.xxxLastUpdated -> TILDATEST.Testing2View."xxxLastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.xxxLastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.xxxLastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing)</TD></TR>
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
   public final ZonedDateTime getXxxLastUpdated()
      { return _xxxLastUpdated; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.xxxLastUpdated -> TILDATEST.Testing2View."xxxLastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.xxxLastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.xxxLastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing)</TD></TR>
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
    final void setXxxLastUpdated(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.xxxLastUpdated to null: it's not nullable.");
       else if (v.equals(_xxxLastUpdated) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.xxxLastUpdated' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.XXXLASTUPDATED._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.XXXLASTUPDATED._Mask);
       _xxxLastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a1 -> TILDATEST.Testing2View."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a1")
   Integer _a1=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a1 -> TILDATEST.Testing2View."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA1()
      { return _a1; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a1 -> TILDATEST.Testing2View."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA1Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A1._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a1 -> TILDATEST.Testing2View."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA1(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a1 == null || v != _a1)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a1' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A1._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A1._Mask);
       _a1 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a1 -> TILDATEST.Testing2View."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA1Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A1._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A1._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A1._Mask);
       _a1=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a3b -> TILDATEST.Testing2View."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a3b")
   List<Boolean> _a3b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a3b -> TILDATEST.Testing2View."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final Boolean[] getA3bAsArray()
      { return _a3b==null? null : _a3b.toArray(new Boolean[_a3b.size()]); }
   public final Iterator<Boolean> getA3b()
      { return _a3b==null? null : _a3b.iterator(); }
   public final boolean hasA3b(boolean v)
      { return _a3b==null? false : _a3b.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a3b -> TILDATEST.Testing2View."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA3bNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a3b -> TILDATEST.Testing2View."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA3b(List<Boolean> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a3b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setA3bNull();
       else if (CollectionUtil.equals(v, _a3b) == false)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask);
          if (_a3b == null)
           {
             _a3b = new ArrayList<Boolean>();
           }
          else
           {
             _a3b.clear();
           }
          for (boolean i : v)
           {
             _a3b.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA3b(int pos, boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a3b == null)
        _a3b = new ArrayList<Boolean>();
       if (pos >= _a3b.size() || _a3b.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a3b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask);
          _a3b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA3b(Boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a3b.remove(v) == true)
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA3b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a3b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a3b -> TILDATEST.Testing2View."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA3bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask);
       _a3b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a4 -> TILDATEST.Testing2View."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a4")
   Double _a4=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a4 -> TILDATEST.Testing2View."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getA4()
      { return _a4==null?0d:_a4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a4 -> TILDATEST.Testing2View."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA4Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a4 -> TILDATEST.Testing2View."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA4(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a4 == null || v != _a4)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a4' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A4._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A4._Mask);
       _a4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a4 -> TILDATEST.Testing2View."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA4Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A4._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A4._Mask);
       _a4=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a4b -> TILDATEST.Testing2View."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a4b")
   List<Double> _a4b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a4b -> TILDATEST.Testing2View."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final Double[] getA4bAsArray()
      { return _a4b==null? null : _a4b.toArray(new Double[_a4b.size()]); }
   public final Iterator<Double> getA4b()
      { return _a4b==null? null : _a4b.iterator(); }
   public final boolean hasA4b(double v)
      { return _a4b==null? false : _a4b.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a4b -> TILDATEST.Testing2View."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA4bNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a4b -> TILDATEST.Testing2View."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA4b(List<Double> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a4b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setA4bNull();
       else if (CollectionUtil.equals(v, _a4b) == false)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask);
          if (_a4b == null)
           {
             _a4b = new ArrayList<Double>();
           }
          else
           {
             _a4b.clear();
           }
          for (double i : v)
           {
             _a4b.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA4b(int pos, double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a4b == null)
        _a4b = new ArrayList<Double>();
       if (pos >= _a4b.size() || _a4b.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a4b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask);
          _a4b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA4b(Double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a4b.remove(v) == true)
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA4b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a4b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a4b -> TILDATEST.Testing2View."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA4bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask);
       _a4b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5 -> TILDATEST.Testing2View."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a5")
   Float _a5=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5 -> TILDATEST.Testing2View."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final float getA5()
      { return _a5==null?0f:_a5; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5 -> TILDATEST.Testing2View."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA5Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5 -> TILDATEST.Testing2View."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA5(float v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a5 == null || v != _a5)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a5' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A5._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A5._Mask);
       _a5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5 -> TILDATEST.Testing2View."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA5Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A5._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A5._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A5._Mask);
       _a5=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5b -> TILDATEST.Testing2View."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a5b")
   List<Float> _a5b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5b -> TILDATEST.Testing2View."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final Float[] getA5bAsArray()
      { return _a5b==null? null : _a5b.toArray(new Float[_a5b.size()]); }
   public final Iterator<Float> getA5b()
      { return _a5b==null? null : _a5b.iterator(); }
   public final boolean hasA5b(float v)
      { return _a5b==null? false : _a5b.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5b -> TILDATEST.Testing2View."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA5bNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5b -> TILDATEST.Testing2View."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA5b(List<Float> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a5b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setA5bNull();
       else if (CollectionUtil.equals(v, _a5b) == false)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask);
          if (_a5b == null)
           {
             _a5b = new ArrayList<Float>();
           }
          else
           {
             _a5b.clear();
           }
          for (float i : v)
           {
             _a5b.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA5b(int pos, float v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a5b == null)
        _a5b = new ArrayList<Float>();
       if (pos >= _a5b.size() || _a5b.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a5b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask);
          _a5b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA5b(Float v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a5b.remove(v) == true)
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA5b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a5b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5b -> TILDATEST.Testing2View."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA5bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask);
       _a5b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7 -> TILDATEST.Testing2View."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a7")
   Integer _a7=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7 -> TILDATEST.Testing2View."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA7()
      { return _a7==null?0:_a7; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7 -> TILDATEST.Testing2View."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7 -> TILDATEST.Testing2View."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a7 == null || v != _a7)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a7' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A7._Mask);
       _a7 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7 -> TILDATEST.Testing2View."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A7._Mask);
       _a7=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7b -> TILDATEST.Testing2View."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a7b")
   List<Integer> _a7b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7b -> TILDATEST.Testing2View."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final Integer[] getA7bAsArray()
      { return _a7b==null? null : _a7b.toArray(new Integer[_a7b.size()]); }
   public final Iterator<Integer> getA7b()
      { return _a7b==null? null : _a7b.iterator(); }
   public final boolean hasA7b(int v)
      { return _a7b==null? false : _a7b.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7b -> TILDATEST.Testing2View."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7bNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7b -> TILDATEST.Testing2View."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7b(List<Integer> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a7b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setA7bNull();
       else if (CollectionUtil.equals(v, _a7b) == false)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask);
          if (_a7b == null)
           {
             _a7b = new ArrayList<Integer>();
           }
          else
           {
             _a7b.clear();
           }
          for (int i : v)
           {
             _a7b.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA7b(int pos, int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a7b == null)
        _a7b = new ArrayList<Integer>();
       if (pos >= _a7b.size() || _a7b.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a7b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask);
          _a7b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA7b(Integer v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a7b.remove(v) == true)
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA7b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a7b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7b -> TILDATEST.Testing2View."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask);
       _a7b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8 -> TILDATEST.Testing2View."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a8")
   byte[] _a8=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8 -> TILDATEST.Testing2View."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final byte[] getA8()
      { return _a8; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8 -> TILDATEST.Testing2View."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8 -> TILDATEST.Testing2View."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8(byte[] v) throws Exception
     {
       long T0 = System.nanoTime();
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a8' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A8._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A8._Mask);
       _a8 = v;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8 -> TILDATEST.Testing2View."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A8._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A8._Mask);
       _a8=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8bTZ -> TILDATEST.Testing2View."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _a8bTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8bTZ -> TILDATEST.Testing2View."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getA8bTZ()
      { return _a8bTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8bTZ -> TILDATEST.Testing2View."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8bTZNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8BTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8bTZ -> TILDATEST.Testing2View."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8bTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA8bTZNull();
        }
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.a8bTZ: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_a8bTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a8bTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A8BTZ._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A8BTZ._Mask);
       _a8bTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8bTZ -> TILDATEST.Testing2View."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8bTZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8BTZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A8BTZ._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A8BTZ._Mask);
       _a8bTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8b -> TILDATEST.Testing2View."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a8b")
   String  Str_a8b;
   public void initA8b(String v) { Str_a8b = v; }
   public String initA8bVal() { return Str_a8b; }
   transient ZonedDateTime _a8b = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8b -> TILDATEST.Testing2View."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getA8b()
      { return _a8b; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8b -> TILDATEST.Testing2View."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8bNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8b -> TILDATEST.Testing2View."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8b(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA8bNull();
        }
       else if (v.equals(_a8b) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a8b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A8B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A8B._Mask);
       _a8b = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a8b' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA8bTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8b -> TILDATEST.Testing2View."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A8B._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A8B._Mask);
       _a8b=null;
       setA8bTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10a -> TILDATEST.Testing2View."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a10a")
   Integer _a10a=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10a -> TILDATEST.Testing2View."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA10a()
      { return _a10a==null?0:_a10a; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10a -> TILDATEST.Testing2View."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA10aNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A10A._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10a -> TILDATEST.Testing2View."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA10a(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a10a == null || v != _a10a)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a10a' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A10A._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A10A._Mask);
       _a10a = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10a -> TILDATEST.Testing2View."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA10aNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A10A._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A10A._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A10A._Mask);
       _a10a=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10b -> TILDATEST.Testing2View."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a10b")
   String _a10b=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10b -> TILDATEST.Testing2View."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getA10b()
      { return _a10b; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10b -> TILDATEST.Testing2View."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA10bNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A10B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10b -> TILDATEST.Testing2View."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA10b(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA10bNull();
        }
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.a10b: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_a10b) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a10b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A10B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A10B._Mask);
       _a10b = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10b -> TILDATEST.Testing2View."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA10bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A10B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A10B._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A10B._Mask);
       _a10b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10c -> TILDATEST.Testing2View."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a10c")
   Integer _a10c=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10c -> TILDATEST.Testing2View."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA10c()
      { return _a10c==null?0:_a10c; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10c -> TILDATEST.Testing2View."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA10cNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A10C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10c -> TILDATEST.Testing2View."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA10c(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a10c == null || v != _a10c)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a10c' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A10C._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A10C._Mask);
       _a10c = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a10c -> TILDATEST.Testing2View."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA10cNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A10C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A10C._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A10C._Mask);
       _a10c=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11 -> TILDATEST.Testing2View."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a11")
   BigDecimal _a11=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11 -> TILDATEST.Testing2View."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final BigDecimal getA11()
      { return _a11; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11 -> TILDATEST.Testing2View."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA11Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A11._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11 -> TILDATEST.Testing2View."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA11(BigDecimal v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a11 == null || v != _a11)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a11' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A11._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A11._Mask);
       _a11 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11 -> TILDATEST.Testing2View."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA11Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A11._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A11._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A11._Mask);
       _a11=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11b -> TILDATEST.Testing2View."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a11b")
   List<BigDecimal> _a11b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11b -> TILDATEST.Testing2View."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final BigDecimal[] getA11bAsArray()
      { return _a11b==null? null : _a11b.toArray(new BigDecimal[_a11b.size()]); }
   public final Iterator<BigDecimal> getA11b()
      { return _a11b==null? null : _a11b.iterator(); }
   public final boolean hasA11b(BigDecimal v)
      { return _a11b==null? false : _a11b.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11b -> TILDATEST.Testing2View."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA11bNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11b -> TILDATEST.Testing2View."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA11b(List<BigDecimal> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a11b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setA11bNull();
       else if (CollectionUtil.equals(v, _a11b) == false)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask);
          if (_a11b == null)
           {
             _a11b = new ArrayList<BigDecimal>();
           }
          else
           {
             _a11b.clear();
           }
          for (BigDecimal i : v)
           {
             _a11b.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA11b(int pos, BigDecimal v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a11b == null)
        _a11b = new ArrayList<BigDecimal>();
       if (pos >= _a11b.size() || _a11b.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a11b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask);
          _a11b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA11b(BigDecimal v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a11b.remove(v) == true)
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA11b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a11b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11b -> TILDATEST.Testing2View."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA11bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask);
       _a11b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11c -> TILDATEST.Testing2View."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a11c")
   BigDecimal _a11c=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11c -> TILDATEST.Testing2View."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final BigDecimal getA11c()
      { return _a11c; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11c -> TILDATEST.Testing2View."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA11cNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A11C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11c -> TILDATEST.Testing2View."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA11c(BigDecimal v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a11c == null || v != _a11c)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a11c' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A11C._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A11C._Mask);
       _a11c = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a11c -> TILDATEST.Testing2View."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA11cNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A11C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A11C._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A11C._Mask);
       _a11c=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a12 -> TILDATEST.Testing2View."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a12")
   Short _a12=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a12 -> TILDATEST.Testing2View."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final short getA12()
      { return _a12==null?0:_a12; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a12 -> TILDATEST.Testing2View."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA12Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A12._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a12 -> TILDATEST.Testing2View."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA12(short v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a12 == null || v != _a12)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a12' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A12._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A12._Mask);
       _a12 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a12 -> TILDATEST.Testing2View."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA12Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A12._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A12._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A12._Mask);
       _a12=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a12b -> TILDATEST.Testing2View."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a12b")
   List<Short> _a12b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a12b -> TILDATEST.Testing2View."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final Short[] getA12bAsArray()
      { return _a12b==null? null : _a12b.toArray(new Short[_a12b.size()]); }
   public final Iterator<Short> getA12b()
      { return _a12b==null? null : _a12b.iterator(); }
   public final boolean hasA12b(short v)
      { return _a12b==null? false : _a12b.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a12b -> TILDATEST.Testing2View."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA12bNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a12b -> TILDATEST.Testing2View."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA12b(List<Short> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a12b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setA12bNull();
       else if (CollectionUtil.equals(v, _a12b) == false)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask);
          if (_a12b == null)
           {
             _a12b = new ArrayList<Short>();
           }
          else
           {
             _a12b.clear();
           }
          for (short i : v)
           {
             _a12b.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA12b(int pos, short v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a12b == null)
        _a12b = new ArrayList<Short>();
       if (pos >= _a12b.size() || _a12b.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a12b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask);
          _a12b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA12b(Short v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a12b.remove(v) == true)
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA12b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a12b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a12b -> TILDATEST.Testing2View."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA12bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask);
       _a12b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a13 -> TILDATEST.Testing2View."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a13")
   UUID _a13=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a13 -> TILDATEST.Testing2View."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final UUID getA13()
      { return _a13; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a13 -> TILDATEST.Testing2View."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA13Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A13._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a13 -> TILDATEST.Testing2View."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA13(UUID v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA13Null();
        }
       else if (v.equals(_a13) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a13' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A13._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A13._Mask);
       _a13 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a13 -> TILDATEST.Testing2View."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA13Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A13._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A13._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A13._Mask);
       _a13=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a13b -> TILDATEST.Testing2View."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a13b")
   List<UUID> _a13b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a13b -> TILDATEST.Testing2View."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final UUID[] getA13bAsArray()
      { return _a13b==null? null : _a13b.toArray(new UUID[_a13b.size()]); }
   public final Iterator<UUID> getA13b()
      { return _a13b==null? null : _a13b.iterator(); }
   public final boolean hasA13b(UUID v)
      { return _a13b==null? false : _a13b.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a13b -> TILDATEST.Testing2View."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA13bNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a13b -> TILDATEST.Testing2View."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA13b(List<UUID> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a13b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setA13bNull();
       else if (CollectionUtil.equals(v, _a13b) == false)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask);
          if (_a13b == null)
           {
             _a13b = new ArrayList<UUID>();
           }
          else
           {
             _a13b.clear();
           }
          for (UUID i : v)
           {
             _a13b.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA13b(int pos, UUID v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a13b == null)
        _a13b = new ArrayList<UUID>();
       if (v == null)
        {
          setA13bNull();
        }
       else if (pos >= _a13b.size() || _a13b.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a13b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask);
          _a13b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA13b(UUID v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a13b.remove(v) == true)
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA13b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a13b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a13b -> TILDATEST.Testing2View."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA13bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask);
       _a13b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.description -> TILDATEST.Testing2View."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("description")
   String _description=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.description -> TILDATEST.Testing2View."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDescription()
      { return _description; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.description -> TILDATEST.Testing2View."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDescriptionNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESCRIPTION._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.description -> TILDATEST.Testing2View."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDescription(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDescriptionNull();
        }
       else if (v.length() > 250)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.description: the size "+v.length()+" is larger than the max allowed of 250: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_description) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.description' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.DESCRIPTION._Mask);
       _description = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.description -> TILDATEST.Testing2View."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDescriptionNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESCRIPTION._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESCRIPTION._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESCRIPTION._Mask);
       _description=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2 -> TILDATEST.Testing2View."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("desc2")
   String _desc2=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2 -> TILDATEST.Testing2View."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDesc2()
      { return _desc2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2 -> TILDATEST.Testing2View."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc2Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2 -> TILDATEST.Testing2View."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDesc2Null();
        }
       else if (v.length() > 3000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.desc2: the size "+v.length()+" is larger than the max allowed of 3000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc2) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.desc2' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.DESC2._Mask);
       _desc2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2 -> TILDATEST.Testing2View."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2._Mask);
       _desc2=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc3 -> TILDATEST.Testing2View."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("desc3")
   String _desc3=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc3 -> TILDATEST.Testing2View."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDesc3()
      { return _desc3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc3 -> TILDATEST.Testing2View."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc3Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc3 -> TILDATEST.Testing2View."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc3(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDesc3Null();
        }
       else if (v.length() > 5000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.desc3: the size "+v.length()+" is larger than the max allowed of 5000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc3) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.desc3' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC3._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.DESC3._Mask);
       _desc3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc3 -> TILDATEST.Testing2View."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc3Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC3._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC3._Mask);
       _desc3=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc4 -> TILDATEST.Testing2View."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("desc4")
   String _desc4=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc4 -> TILDATEST.Testing2View."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDesc4()
      { return _desc4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc4 -> TILDATEST.Testing2View."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc4Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc4 -> TILDATEST.Testing2View."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc4(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDesc4Null();
        }
       else if (v.length() > 9000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.desc4: the size "+v.length()+" is larger than the max allowed of 9000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc4) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.desc4' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC4._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.DESC4._Mask);
       _desc4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc4 -> TILDATEST.Testing2View."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc4Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC4._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC4._Mask);
       _desc4=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc5 -> TILDATEST.Testing2View."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("desc5")
   String _desc5=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc5 -> TILDATEST.Testing2View."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDesc5()
      { return _desc5; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc5 -> TILDATEST.Testing2View."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc5Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc5 -> TILDATEST.Testing2View."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc5(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDesc5Null();
        }
       else if (v.length() > 17000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.desc5: the size "+v.length()+" is larger than the max allowed of 17000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc5) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.desc5' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC5._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.DESC5._Mask);
       _desc5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc5 -> TILDATEST.Testing2View."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc5Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC5._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC5._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC5._Mask);
       _desc5=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc6 -> TILDATEST.Testing2View."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("desc6")
   String _desc6=null;
/**
These are the enumerated values for tilda.data_test.TILDATEST.Testing2View.desc6, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
*/
   public static final String[][] _desc6_Values = {
                                               { "STR", "String", "String", "" }
                                             , { "DTM", "DateTime", "DateTime", "" }
                                  };
   public static final String _desc6String   = "STR";
   public static final String _desc6DateTime = "DTM";

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc6 -> TILDATEST.Testing2View."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final String getDesc6()
      { return _desc6; }

/**
This is the value is-a for tilda.data_test.TILDATEST.Testing2View.desc6:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>String</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>STR</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>String</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>String</TD></TR>
</TABLE>
*/
   public final boolean isDesc6String()
      { return _desc6 != null && _desc6.equals(_desc6String); }

/**
This is the value is-a for tilda.data_test.TILDATEST.Testing2View.desc6:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>DateTime</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>DTM</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>DateTime</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>DateTime</TD></TR>
</TABLE>
*/
   public final boolean isDesc6DateTime()
      { return _desc6 != null && _desc6.equals(_desc6DateTime); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc6 -> TILDATEST.Testing2View."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isDesc6Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC6._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc6 -> TILDATEST.Testing2View."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
    void setDesc6(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDesc6Null();
        }
       else if (v.length() > 33000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing2View.desc6: the size "+v.length()+" is larger than the max allowed of 33000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc6) == false)
        {
          v = HTMLFilter.cleanSmart("tilda.data_test.TILDATEST.Testing2View.desc6",v);
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.desc6' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC6._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.DESC6._Mask);
       _desc6 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc6 -> TILDATEST.Testing2View."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
    void setDesc6Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC6._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC6._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC6._Mask);
       _desc6=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a3 -> TILDATEST.Testing2View."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Not A3</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a3")
   Boolean _a3=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a3 -> TILDATEST.Testing2View."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Not A3</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getA3()
      { return _a3==null?false:_a3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a3 -> TILDATEST.Testing2View."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Not A3</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA3Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a3 -> TILDATEST.Testing2View."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Not A3</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA3(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a3 == null || v != _a3)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a3' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A3._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A3._Mask);
       _a3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field a3 doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initA3(boolean v) throws Exception
     {
       setA3(v);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a3 -> TILDATEST.Testing2View."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Not A3</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA3Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A3._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A3._Mask);
       _a3=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.bastille -> TILDATEST.Testing2View."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _bastille = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.bastille -> TILDATEST.Testing2View."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getBastille()
      { return _bastille; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.bastille -> TILDATEST.Testing2View."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isBastilleNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.BASTILLE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.bastille -> TILDATEST.Testing2View."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setBastille(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setBastilleNull();
        }
       else if (v.equals(_bastille) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.bastille' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.BASTILLE._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.BASTILLE._Mask);
       _bastille = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.bastille -> TILDATEST.Testing2View."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setBastilleNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.BASTILLE._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.BASTILLE._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.BASTILLE._Mask);
       _bastille=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.toto -> TILDATEST.Testing2View."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _toto = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.toto -> TILDATEST.Testing2View."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getToto()
      { return _toto; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.toto -> TILDATEST.Testing2View."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTotoNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.TOTO._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.toto -> TILDATEST.Testing2View."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setToto(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setTotoNull();
        }
       else if (v.equals(_toto) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.toto' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.TOTO._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.TOTO._Mask);
       _toto = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.toto -> TILDATEST.Testing2View."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTotoNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.TOTO._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.TOTO._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.TOTO._Mask);
       _toto=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat1 -> TILDATEST.Testing2View."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Double _desc2_Cat1=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat1 -> TILDATEST.Testing2View."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getDesc2_Cat1()
      { return _desc2_Cat1==null?0d:_desc2_Cat1; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat1 -> TILDATEST.Testing2View."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc2_Cat1Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT1._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat1 -> TILDATEST.Testing2View."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat1(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _desc2_Cat1 == null || v != _desc2_Cat1)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.desc2_Cat1' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT1._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT1._Mask);
       _desc2_Cat1 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat1 -> TILDATEST.Testing2View."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat1Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT1._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT1._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT1._Mask);
       _desc2_Cat1=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat2 -> TILDATEST.Testing2View."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Double _desc2_Cat2=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat2 -> TILDATEST.Testing2View."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getDesc2_Cat2()
      { return _desc2_Cat2==null?0d:_desc2_Cat2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat2 -> TILDATEST.Testing2View."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc2_Cat2Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat2 -> TILDATEST.Testing2View."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat2(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _desc2_Cat2 == null || v != _desc2_Cat2)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.desc2_Cat2' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT2._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT2._Mask);
       _desc2_Cat2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat2 -> TILDATEST.Testing2View."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat2Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT2._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT2._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT2._Mask);
       _desc2_Cat2=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat3 -> TILDATEST.Testing2View."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Double _desc2_Cat3=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat3 -> TILDATEST.Testing2View."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getDesc2_Cat3()
      { return _desc2_Cat3==null?0d:_desc2_Cat3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat3 -> TILDATEST.Testing2View."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc2_Cat3Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat3 -> TILDATEST.Testing2View."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat3(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _desc2_Cat3 == null || v != _desc2_Cat3)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.desc2_Cat3' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT3._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT3._Mask);
       _desc2_Cat3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.desc2_Cat3 -> TILDATEST.Testing2View."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat3Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT3._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT3._Mask);
       _desc2_Cat3=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_Cat4 -> TILDATEST.Testing2View."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Double _a7_Cat4=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_Cat4 -> TILDATEST.Testing2View."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getA7_Cat4()
      { return _a7_Cat4==null?0d:_a7_Cat4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_Cat4 -> TILDATEST.Testing2View."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7_Cat4Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_Cat4 -> TILDATEST.Testing2View."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_Cat4(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a7_Cat4 == null || v != _a7_Cat4)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a7_Cat4' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT4._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT4._Mask);
       _a7_Cat4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_Cat4 -> TILDATEST.Testing2View."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_Cat4Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT4._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT4._Mask);
       _a7_Cat4=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_Cat5 -> TILDATEST.Testing2View."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Double _a7_Cat5=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_Cat5 -> TILDATEST.Testing2View."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getA7_Cat5()
      { return _a7_Cat5==null?0d:_a7_Cat5; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_Cat5 -> TILDATEST.Testing2View."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7_Cat5Null()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_Cat5 -> TILDATEST.Testing2View."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_Cat5(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a7_Cat5 == null || v != _a7_Cat5)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a7_Cat5' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT5._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT5._Mask);
       _a7_Cat5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_Cat5 -> TILDATEST.Testing2View."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_Cat5Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT5._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT5._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT5._Mask);
       _a7_Cat5=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5_null -> TILDATEST.Testing2View."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Integer _a5_null=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5_null -> TILDATEST.Testing2View."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA5_null()
      { return _a5_null==null?0:_a5_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5_null -> TILDATEST.Testing2View."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA5_nullNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A5_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5_null -> TILDATEST.Testing2View."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA5_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a5_null == null || v != _a5_null)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a5_null' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A5_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A5_NULL._Mask);
       _a5_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a5_null -> TILDATEST.Testing2View."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA5_nullNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A5_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A5_NULL._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A5_NULL._Mask);
       _a5_null=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a6_null -> TILDATEST.Testing2View."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Integer _a6_null=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a6_null -> TILDATEST.Testing2View."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA6_null()
      { return _a6_null==null?0:_a6_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a6_null -> TILDATEST.Testing2View."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA6_nullNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A6_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a6_null -> TILDATEST.Testing2View."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA6_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a6_null == null || v != _a6_null)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a6_null' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A6_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A6_NULL._Mask);
       _a6_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a6_null -> TILDATEST.Testing2View."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA6_nullNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A6_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A6_NULL._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A6_NULL._Mask);
       _a6_null=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_null -> TILDATEST.Testing2View."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Integer _a7_null=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_null -> TILDATEST.Testing2View."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA7_null()
      { return _a7_null==null?0:_a7_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_null -> TILDATEST.Testing2View."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7_nullNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_null -> TILDATEST.Testing2View."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a7_null == null || v != _a7_null)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a7_null' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A7_NULL._Mask);
       _a7_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a7_null -> TILDATEST.Testing2View."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_nullNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A7_NULL._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A7_NULL._Mask);
       _a7_null=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8_null -> TILDATEST.Testing2View."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Integer _a8_null=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8_null -> TILDATEST.Testing2View."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA8_null()
      { return _a8_null==null?0:_a8_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8_null -> TILDATEST.Testing2View."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8_nullNull()
     { return __Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8_null -> TILDATEST.Testing2View."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a8_null == null || v != _a8_null)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing2View.a8_null' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A8_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING2VIEW_Factory.COLS.A8_NULL._Mask);
       _a8_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2View.a8_null -> TILDATEST.Testing2View."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2View.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2View.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8_nullNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING2VIEW_Factory.COLS.A8_NULL._Mask);
       __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A8_NULL._Mask);
       _a8_null=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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
        throw new Exception("This TILDATEST.Testing2View object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATEST.Testing2View object has already been read.");
          QueryDetails.setLastQuery(TILDA__TESTING2VIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "refnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "name");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "xxxLastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a1");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a3b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a4b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a5b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a7");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a7b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a8");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a8bTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a8b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a10a");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a10b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a10c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a11");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a11b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a11c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a12");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a12b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a13");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a13b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "description");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "desc2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "desc3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "desc4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "desc5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "desc6");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "bastille");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "toto");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "desc2_Cat1");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "desc2_Cat2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "desc2_Cat3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a7_Cat4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a7_Cat5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a5_null");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a6_null");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a7_null");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2View", "a8_null");
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "Testing2View");
       switch (__LookupId)
        {
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TESTING2VIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATEST.Testing2View", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;

       try
        {
          PS = C.prepareStatement(Q);
          switch (__LookupId)
           {
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
          tilda.data_test._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TESTING2VIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }
    }

   @SuppressWarnings("unchecked")
   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                               _refnum         =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.REFNUM._Mask        ); _refnum = null; }
                               _name           = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.NAME._Mask          ); _name = null; }
                               _lastUpdated    = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.LASTUPDATED._Mask   ); _lastUpdated = null; }
                               _xxxLastUpdated = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.XXXLASTUPDATED._Mask); _xxxLastUpdated = null; }
                               _a1             =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A1._Mask            ); _a1 = null; }
                               _a3b = (List<Boolean>) C.getArray(RS, ++i, TILDA__TESTING2VIEW_Factory.COLS.A3B._Type, false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask           ); _a3b = null; }
                               _a4             =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A4._Mask            ); _a4 = null; }
                               _a4b = (List<Double>) C.getArray(RS, ++i, TILDA__TESTING2VIEW_Factory.COLS.A4B._Type, false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask           ); _a4b = null; }
                               _a5             =                              RS.getFloat     (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A5._Mask            ); _a5 = null; }
                               _a5b = (List<Float>) C.getArray(RS, ++i, TILDA__TESTING2VIEW_Factory.COLS.A5B._Type, false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask           ); _a5b = null; }
                               _a7             =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A7._Mask            ); _a7 = null; }
                               _a7b = (List<Integer>) C.getArray(RS, ++i, TILDA__TESTING2VIEW_Factory.COLS.A7B._Type, false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask           ); _a7b = null; }
                               _a8             =                              RS.getBytes     (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A8._Mask            ); _a8 = null; }
                               _a8bTZ          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A8BTZ._Mask         ); _a8bTZ = null; }
                               _a8b            = processZDT(_a8bTZ           , "tilda.data_test.TILDATEST.Testing2View.a8b"           , RS, ++i, TILDA__TESTING2VIEW_Factory.COLS.A8B           , TILDA__TESTING2VIEW_Factory.COLS.A8BTZ           ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A8B._Mask           ); _a8b = null; }
                               _a10a           =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A10A._Mask          ); _a10a = null; }
                               _a10b           = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A10B._Mask          ); _a10b = null; }
                               _a10c           =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A10C._Mask          ); _a10c = null; }
                               _a11            =                              RS.getBigDecimal(++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A11._Mask           ); _a11 = null; }
                               _a11b = (List<BigDecimal>) C.getArray(RS, ++i, TILDA__TESTING2VIEW_Factory.COLS.A11B._Type, false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask          ); _a11b = null; }
                               _a11c           =                              RS.getBigDecimal(++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A11C._Mask          ); _a11c = null; }
                               _a12            =                              RS.getShort     (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A12._Mask           ); _a12 = null; }
                               _a12b = (List<Short>) C.getArray(RS, ++i, TILDA__TESTING2VIEW_Factory.COLS.A12B._Type, false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask          ); _a12b = null; }
                               _a13            =                              (java.util.UUID) RS.getObject(++i);  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A13._Mask           ); _a13 = null; }
                               _a13b = (List<UUID>) C.getArray(RS, ++i, TILDA__TESTING2VIEW_Factory.COLS.A13B._Type, false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask          ); _a13b = null; }
                               _description    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESCRIPTION._Mask   ); _description = null; }
                               _desc2          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2._Mask         ); _desc2 = null; }
                               _desc3          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC3._Mask         ); _desc3 = null; }
                               _desc4          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC4._Mask         ); _desc4 = null; }
                               _desc5          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC5._Mask         ); _desc5 = null; }
                               _desc6          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC6._Mask         ); _desc6 = null; }
                               _a3             =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A3._Mask            ); _a3 = null; }
                               _bastille       = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.BASTILLE._Mask      ); _bastille = null; }
                               _toto           = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.TOTO._Mask          ); _toto = null; }
                               _desc2_Cat1     =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT1._Mask    ); _desc2_Cat1 = null; }
                               _desc2_Cat2     =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT2._Mask    ); _desc2_Cat2 = null; }
                               _desc2_Cat3     =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT3._Mask    ); _desc2_Cat3 = null; }
                               _a7_Cat4        =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT4._Mask       ); _a7_Cat4 = null; }
                               _a7_Cat5        =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT5._Mask       ); _a7_Cat5 = null; }
                               _a5_null        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A5_NULL._Mask       ); _a5_null = null; }
                               _a6_null        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A6_NULL._Mask       ); _a6_null = null; }
                               _a7_null        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A7_NULL._Mask       ); _a7_null = null; }
                               _a8_null        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTING2VIEW_Factory.COLS.A8_NULL._Mask       ); _a8_null = null; }
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
                   "refnum: "                                                                                                      +                                   getRefnum        () 
               + "; name: "                                                                                                        + TextUtil.printVariableStr        (getName          ())
               + "; lastUpdated: "                                                                                                 + DateTimeUtil.printDateTimeForJSON(getLastUpdated   ())
               + "; xxxLastUpdated: "                                                                                              + DateTimeUtil.printDateTimeForJSON(getXxxLastUpdated())
               + "; a1"               + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A1._Mask) == true ? ": NULL" : ": " +                                   getA1            () )
               + "; a3b"              + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A3B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA3b           ()))
               + "; a4"               + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A4._Mask) == true ? ": NULL" : ": " +                                   getA4            () )
               + "; a4b"              + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A4B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA4b           ()))
               + "; a5"               + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A5._Mask) == true ? ": NULL" : ": " +                                   getA5            () )
               + "; a5b"              + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A5B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA5b           ()))
               + "; a7"               + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7._Mask) == true ? ": NULL" : ": " +                                   getA7            () )
               + "; a7b"              + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA7b           ()))
               + "; a8"               + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8._Mask) == true ? ": NULL" : ": " +                                   getA8            () )
               + "; a8b"              + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8B._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getA8b           ()))
               + "; a10a"             + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A10A._Mask) == true ? ": NULL" : ": " +                                   getA10a          () )
               + "; a10b"             + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A10B._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getA10b          ()))
               + "; a10c"             + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A10C._Mask) == true ? ": NULL" : ": " +                                   getA10c          () )
               + "; a11"              + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A11._Mask) == true ? ": NULL" : ": " +                                   getA11           () )
               + "; a11b"             + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A11B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA11b          ()))
               + "; a11c"             + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A11C._Mask) == true ? ": NULL" : ": " +                                   getA11c          () )
               + "; a12"              + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A12._Mask) == true ? ": NULL" : ": " +                                   getA12           () )
               + "; a12b"             + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A12B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA12b          ()))
               + "; a13"              + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A13._Mask) == true ? ": NULL" : ": " +                                   getA13           () )
               + "; a13b"             + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A13B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA13b          ()))
               + "; description"      + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESCRIPTION._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDescription   ()))
               + "; desc2"            + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc2         ()))
               + "; desc3"            + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC3._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc3         ()))
               + "; desc4"            + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC4._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc4         ()))
               + "; desc5"            + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC5._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc5         ()))
               + "; desc6"            + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC6._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc6         ()))
               + "; a3"               + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A3._Mask) == true ? ": NULL" : ": " +                                   getA3            () )
               + "; bastille"         + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.BASTILLE._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getBastille      ()))
               + "; toto"             + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.TOTO._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getToto          ()))
               + "; desc2_Cat1"       + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT1._Mask) == true ? ": NULL" : ": " +                                   getDesc2_Cat1    () )
               + "; desc2_Cat2"       + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT2._Mask) == true ? ": NULL" : ": " +                                   getDesc2_Cat2    () )
               + "; desc2_Cat3"       + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.DESC2_CAT3._Mask) == true ? ": NULL" : ": " +                                   getDesc2_Cat3    () )
               + "; a7_Cat4"          + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT4._Mask) == true ? ": NULL" : ": " +                                   getA7_Cat4       () )
               + "; a7_Cat5"          + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7_CAT5._Mask) == true ? ": NULL" : ": " +                                   getA7_Cat5       () )
               + "; a5_null"          + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A5_NULL._Mask) == true ? ": NULL" : ": " +                                   getA5_null       () )
               + "; a6_null"          + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A6_NULL._Mask) == true ? ": NULL" : ": " +                                   getA6_null       () )
               + "; a7_null"          + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A7_NULL._Mask) == true ? ": NULL" : ": " +                                   getA7_null       () )
               + "; a8_null"          + (__Nulls.intersects(TILDA__TESTING2VIEW_Factory.COLS.A8_NULL._Mask) == true ? ": NULL" : ": " +                                   getA8_null       () )
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
