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
<TABLE id="Testing4Realized_DIV" class="tables">
<SCRIPT>registerStickyHeader("Testing4Realized_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Testing4Realized&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Testing4Realized_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Testing4Realized_CNT" class="content">
The Table TILDA.Testing4Realized:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Testing4Realized_Factory</B>, <B>Testing4Realized_Data</B> in the package <B>tilda.data</B>.
<LI>Is Realized from <B><A href="TILDA___Docs.TILDA.html#Testing4View_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing4View</A></B> through DB function <B>TILDA<B>&nbsp;&#8226;&nbsp;</B>Refill_Testing4Realized()</B>.</LI>
<LI>Is configured for <B>ReadOnly</B> access.</LI>
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Has the following identity:<UL><LI>Unique Index: refnum</LI>
</UL></LI>
</UL>
<B>Description</B>: Realized table for view TILDA.Testing4View: A test view to test .* and exclude and block.<BR>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="Testing4Realized_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-refnum_DIV' class='columns'>refnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-name_DIV' class='columns'>name</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Medical system unique enterprise id</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a1_DIV' class='columns'>a1</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;INTEGER&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a3b_DIV' class='columns'>a3b</B>&nbsp;&nbsp;</TD>
<TD>List<Boolean> List<>&nbsp;/&nbsp;boolean[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a4_DIV' class='columns'>a4</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a4b_DIV' class='columns'>a4b</B>&nbsp;&nbsp;</TD>
<TD>List<Double> List<>&nbsp;/&nbsp;double precision[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a5_DIV' class='columns'>a5</B>&nbsp;&nbsp;</TD>
<TD>float&nbsp;/&nbsp;real&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a5b_DIV' class='columns'>a5b</B>&nbsp;&nbsp;</TD>
<TD>List<Float> List<>&nbsp;/&nbsp;real[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a7_DIV' class='columns'>a7</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a7b_DIV' class='columns'>a7b</B>&nbsp;&nbsp;</TD>
<TD>List<Integer> List<>&nbsp;/&nbsp;integer[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a8_DIV' class='columns'>a8</B>&nbsp;&nbsp;</TD>
<TD>byte[]&nbsp;/&nbsp;BYTEA&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a8bTZ_DIV' class='columns'>a8bTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'a8b'.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a8b_DIV' class='columns'>a8b</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a10a_DIV' class='columns'>a10a</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a10b_DIV' class='columns'>a10b</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a10c_DIV' class='columns'>a10c</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-description_DIV' class='columns'>description</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc2_DIV' class='columns'>desc2</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(3000)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc3_DIV' class='columns'>desc3</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>20&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc4_DIV' class='columns'>desc4</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>21&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc5_DIV' class='columns'>desc5</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>22&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc6_DIV' class='columns'>desc6</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">SMART&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...<BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>23&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-bastille_DIV' class='columns'>bastille</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Bastille Day</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-bastille_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>bastille</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>24&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-toto_DIV' class='columns'>toto</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Last Updated</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-toto_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>toto</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>25&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc2_Cat1_DIV' class='columns'>desc2_Cat1</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>desc2_Cat1 Title</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-desc2_Cat1_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>desc2_Cat1</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>26&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc2_Cat2_DIV' class='columns'>desc2_Cat2</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>desc2_Cat2 Title</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-desc2_Cat2_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>desc2_Cat2</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>27&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc2_Cat3_DIV' class='columns'>desc2_Cat3</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>desc2_Cat3 Title</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-desc2_Cat3_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>desc2_Cat3</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>28&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a7_Cat4_DIV' class='columns'>a7_Cat4</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>a7_Cat4 Title</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-a7_Cat4_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a7_Cat4</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>29&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a7_Cat5_DIV' class='columns'>a7_Cat5</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>a7_Cat5 Title</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-a7_Cat5_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a7_Cat5</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>30&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a5_null_DIV' class='columns'>a5_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a5</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-a5_null_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a5_null</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>31&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a6_null_DIV' class='columns'>a6_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a6</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-a6_null_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a6_null</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>32&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a7_null_DIV' class='columns'>a7_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a7</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-a7_null_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a7_null</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>33&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a8_null_DIV' class='columns'>a8_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a8</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing2View-a8_null_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a8_null</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>34&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a3_DIV' class='columns'>a3</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Always True</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing4View-a3_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing4View<B>&nbsp;&#8226;&nbsp;</B>a3</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>35&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Always True</B>'<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing4View-lastUpdated_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing4View<B>&nbsp;&#8226;&nbsp;</B>lastUpdated</A></DIV></TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TESTING4REALIZED implements tilda.interfaces.ReaderObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTING4REALIZED.class.getName());

   public static final Class<TILDA__TESTING4REALIZED_Factory> FACTORY_CLASS= TILDA__TESTING4REALIZED_Factory.class;
   public static final String TABLENAME = TextUtil.Print("TILDA.Testing4Realized", "");

   protected TILDA__TESTING4REALIZED() { }

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
//   Field tilda.data.TILDA.Testing4Realized.refnum -> TILDA.Testing4Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _refnum= SystemValues.EVIL_VALUE;
   protected long __Saved_refnum;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.refnum -> TILDA.Testing4Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getRefnum()
      { return _refnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.refnum -> TILDA.Testing4Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _refnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.refnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask);
       _refnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.name -> TILDA.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _name;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.name -> TILDA.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
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
//   Field tilda.data.TILDA.Testing4Realized.name -> TILDA.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullName()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.name -> TILDA.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
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
        {
          setNullName();
        }
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.data.TILDA.Testing4Realized.name: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 10.");
       else if (v.equals(_name) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.name' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask);
       _name = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.name -> TILDA.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullName()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask);
       _name=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a1 -> TILDA.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _a1;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a1 -> TILDA.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a1 of type INTEGER</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.a1 -> TILDA.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA1()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a1 -> TILDA.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a1 of type INTEGER</TD></TR>

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
       if (__Init == InitMode.CREATE || v != _a1)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a1' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask);
       _a1 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a1 -> TILDA.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA1()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask);
       _a1=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a3b -> TILDA.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   List<Boolean> _a3b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a3b -> TILDA.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a3b of type boolean[]</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.a3b -> TILDA.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA3b()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a3b -> TILDA.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a3b of type boolean[]</TD></TR>

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
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
        throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a3b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullA3b();
       else if (CollectionUtil.equals(v, _a3b) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
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
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a3b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
          _a3b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA3b(Boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a3b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA3b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a3b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a3b -> TILDA.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA3b()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
       _a3b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a4 -> TILDA.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   double _a4= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a4 -> TILDA.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getA4()
      { return _a4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a4 -> TILDA.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA4()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a4 -> TILDA.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a4 of type double precision</TD></TR>

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
       if (__Init == InitMode.CREATE || v != _a4)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a4' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask);
       _a4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a4 -> TILDA.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA4()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask);
       _a4=0L;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a4b -> TILDA.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   List<Double> _a4b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a4b -> TILDA.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a4b of type double precision[]</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.a4b -> TILDA.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA4b()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a4b -> TILDA.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a4b of type double precision[]</TD></TR>

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
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
        throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a4b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullA4b();
       else if (CollectionUtil.equals(v, _a4b) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
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
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a4b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
          _a4b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA4b(Double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a4b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA4b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a4b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a4b -> TILDA.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA4b()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
       _a4b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5 -> TILDA.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   float _a5= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5 -> TILDA.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final float getA5()
      { return _a5; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5 -> TILDA.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA5()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5 -> TILDA.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5 of type real</TD></TR>

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
       if (__Init == InitMode.CREATE || v != _a5)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a5' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask);
       _a5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5 -> TILDA.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA5()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask);
       _a5=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5b -> TILDA.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   List<Float> _a5b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5b -> TILDA.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5b of type real[]</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.a5b -> TILDA.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA5b()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5b -> TILDA.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5b of type real[]</TD></TR>

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
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
        throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a5b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullA5b();
       else if (CollectionUtil.equals(v, _a5b) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
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
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a5b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
          _a5b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA5b(Float v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a5b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA5b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a5b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5b -> TILDA.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA5b()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
       _a5b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7 -> TILDA.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _a7= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7 -> TILDA.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA7()
      { return _a7; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7 -> TILDA.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA7()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7 -> TILDA.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7 of type integer</TD></TR>

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
       if (__Init == InitMode.CREATE || v != _a7)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a7' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask);
       _a7 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7 -> TILDA.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA7()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask);
       _a7=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7b -> TILDA.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   List<Integer> _a7b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7b -> TILDA.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7b of type integer[]</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.a7b -> TILDA.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA7b()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7b -> TILDA.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7b of type integer[]</TD></TR>

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
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
        throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a7b' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullA7b();
       else if (CollectionUtil.equals(v, _a7b) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
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
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a7b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
          _a7b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA7b(Integer v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a7b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA7b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a7b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7b -> TILDA.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA7b()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
       _a7b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8 -> TILDA.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   byte[] _a8;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8 -> TILDA.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8 of type BYTEA</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.a8 -> TILDA.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA8()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8 -> TILDA.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8 of type BYTEA</TD></TR>

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
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a8' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask);
       _a8 = v;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8 -> TILDA.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA8()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask);
       _a8=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8bTZ -> TILDA.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _a8bTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8bTZ -> TILDA.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getA8bTZ()
      { return _a8bTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8bTZ -> TILDA.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA8bTZ()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8bTZ -> TILDA.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8bTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullA8bTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.Testing4Realized.a8bTZ: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5.");
       else if (v.equals(_a8bTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a8bTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask);
       _a8bTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8bTZ -> TILDA.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA8bTZ()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask);
       _a8bTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8b -> TILDA.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _a8b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8b -> TILDA.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8b of type timestamptz</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.a8b -> TILDA.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA8b()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8b -> TILDA.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8b of type timestamptz</TD></TR>

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
          setNullA8b();
        }
       else if (v.equals(_a8b) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a8b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask);
       _a8b = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a8b' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA8bTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8b -> TILDA.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA8b()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask);
       _a8b=null;
       setNullA8bTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10a -> TILDA.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _a10a= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10a -> TILDA.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA10a()
      { return _a10a; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10a -> TILDA.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA10a()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10a -> TILDA.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10a of type integer</TD></TR>

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
       if (__Init == InitMode.CREATE || v != _a10a)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a10a' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask);
       _a10a = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10a -> TILDA.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA10a()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask);
       _a10a=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10b -> TILDA.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _a10b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10b -> TILDA.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10b of type varchar(10)</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.a10b -> TILDA.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA10b()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10b -> TILDA.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10b of type varchar(10)</TD></TR>

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
          setNullA10b();
        }
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.data.TILDA.Testing4Realized.a10b: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 10.");
       else if (v.equals(_a10b) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a10b' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask);
       _a10b = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10b -> TILDA.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA10b()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask);
       _a10b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10c -> TILDA.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _a10c= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10c -> TILDA.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA10c()
      { return _a10c; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10c -> TILDA.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA10c()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10c -> TILDA.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10c of type integer</TD></TR>

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
       if (__Init == InitMode.CREATE || v != _a10c)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a10c' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask);
       _a10c = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a10c -> TILDA.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA10c()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask);
       _a10c=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.description -> TILDA.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _description;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.description -> TILDA.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.description of type varchar(250)</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.description -> TILDA.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDescription()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.description -> TILDA.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.description of type varchar(250)</TD></TR>

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
          setNullDescription();
        }
       else if (v.length() > 250)
        throw new Exception("Cannot set tilda.data.TILDA.Testing4Realized.description: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 250.");
       else if (v.equals(_description) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.description' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask);
       _description = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.description -> TILDA.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDescription()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask);
       _description=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2 -> TILDA.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _desc2;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2 -> TILDA.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.desc2 -> TILDA.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDesc2()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2 -> TILDA.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

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
          setNullDesc2();
        }
       else if (v.length() > 3000)
        throw new Exception("Cannot set tilda.data.TILDA.Testing4Realized.desc2: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 3000.");
       else if (v.equals(_desc2) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.desc2' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask);
       _desc2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2 -> TILDA.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDesc2()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask);
       _desc2=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc3 -> TILDA.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _desc3;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc3 -> TILDA.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc3 of type text</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.desc3 -> TILDA.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDesc3()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc3 -> TILDA.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc3 of type text</TD></TR>

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
          setNullDesc3();
        }
       else if (v.length() > 5000)
        throw new Exception("Cannot set tilda.data.TILDA.Testing4Realized.desc3: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5000.");
       else if (v.equals(_desc3) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.desc3' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask);
       _desc3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc3 -> TILDA.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDesc3()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask);
       _desc3=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc4 -> TILDA.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _desc4;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc4 -> TILDA.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc4 of type text</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.desc4 -> TILDA.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDesc4()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc4 -> TILDA.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc4 of type text</TD></TR>

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
          setNullDesc4();
        }
       else if (v.length() > 9000)
        throw new Exception("Cannot set tilda.data.TILDA.Testing4Realized.desc4: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 9000.");
       else if (v.equals(_desc4) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.desc4' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask);
       _desc4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc4 -> TILDA.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDesc4()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask);
       _desc4=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc5 -> TILDA.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _desc5;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc5 -> TILDA.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc5 of type text</TD></TR>

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
//   Field tilda.data.TILDA.Testing4Realized.desc5 -> TILDA.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDesc5()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc5 -> TILDA.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc5 of type text</TD></TR>

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
          setNullDesc5();
        }
       else if (v.length() > 17000)
        throw new Exception("Cannot set tilda.data.TILDA.Testing4Realized.desc5: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 17000.");
       else if (v.equals(_desc5) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.desc5' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask);
       _desc5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc5 -> TILDA.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDesc5()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask);
       _desc5=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc6 -> TILDA.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc6 of type text</TD></TR>

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
   String _desc6;
/**
These are the enumerated values for tilda.data.TILDA.Testing4Realized.desc6, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

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
//   Field tilda.data.TILDA.Testing4Realized.desc6 -> TILDA.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc6 of type text</TD></TR>

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
This is the value is-a for tilda.data.TILDA.Testing4Realized.desc6:<BR>
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
This is the value is-a for tilda.data.TILDA.Testing4Realized.desc6:<BR>
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
//   Field tilda.data.TILDA.Testing4Realized.desc6 -> TILDA.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc6 of type text</TD></TR>

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
   public final boolean isNullDesc6()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc6 -> TILDA.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc6 of type text</TD></TR>

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
          setNullDesc6();
        }
       else if (v.length() > 33000)
        throw new Exception("Cannot set tilda.data.TILDA.Testing4Realized.desc6: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 33000.");
       else if (v.equals(_desc6) == false)
        {
          v = HTMLFilter.CleanSmart("tilda.data.TILDA.Testing4Realized.desc6",v);
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.desc6' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask);
       _desc6 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc6 -> TILDA.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc6 of type text</TD></TR>

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
    void setNullDesc6()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask);
       _desc6=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.bastille -> TILDA.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _bastille;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.bastille -> TILDA.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getBastille()
      { return _bastille; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.bastille -> TILDA.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullBastille()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.bastille -> TILDA.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setBastille(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullBastille();
        }
       else if (v.equals(_bastille) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.bastille' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask);
       _bastille = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.bastille -> TILDA.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullBastille()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask);
       _bastille=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.toto -> TILDA.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _toto;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.toto -> TILDA.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getToto()
      { return _toto; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.toto -> TILDA.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullToto()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.toto -> TILDA.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setToto(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullToto();
        }
       else if (v.equals(_toto) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.toto' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask);
       _toto = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.toto -> TILDA.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullToto()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask);
       _toto=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat1 -> TILDA.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   double _desc2_Cat1= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat1 -> TILDA.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getDesc2_Cat1()
      { return _desc2_Cat1; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat1 -> TILDA.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDesc2_Cat1()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat1 -> TILDA.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat1(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _desc2_Cat1)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.desc2_Cat1' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask);
       _desc2_Cat1 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat1 -> TILDA.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDesc2_Cat1()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask);
       _desc2_Cat1=0L;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat2 -> TILDA.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   double _desc2_Cat2= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat2 -> TILDA.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getDesc2_Cat2()
      { return _desc2_Cat2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat2 -> TILDA.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDesc2_Cat2()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat2 -> TILDA.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat2(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _desc2_Cat2)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.desc2_Cat2' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask);
       _desc2_Cat2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat2 -> TILDA.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDesc2_Cat2()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask);
       _desc2_Cat2=0L;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat3 -> TILDA.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   double _desc2_Cat3= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat3 -> TILDA.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getDesc2_Cat3()
      { return _desc2_Cat3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat3 -> TILDA.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDesc2_Cat3()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat3 -> TILDA.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat3(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _desc2_Cat3)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.desc2_Cat3' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask);
       _desc2_Cat3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.desc2_Cat3 -> TILDA.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDesc2_Cat3()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask);
       _desc2_Cat3=0L;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_Cat4 -> TILDA.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   double _a7_Cat4= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_Cat4 -> TILDA.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getA7_Cat4()
      { return _a7_Cat4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_Cat4 -> TILDA.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA7_Cat4()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_Cat4 -> TILDA.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_Cat4(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _a7_Cat4)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a7_Cat4' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask);
       _a7_Cat4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_Cat4 -> TILDA.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA7_Cat4()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask);
       _a7_Cat4=0L;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_Cat5 -> TILDA.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   double _a7_Cat5= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_Cat5 -> TILDA.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getA7_Cat5()
      { return _a7_Cat5; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_Cat5 -> TILDA.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA7_Cat5()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_Cat5 -> TILDA.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_Cat5(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _a7_Cat5)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a7_Cat5' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask);
       _a7_Cat5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_Cat5 -> TILDA.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA7_Cat5()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask);
       _a7_Cat5=0L;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5_null -> TILDA.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _a5_null= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5_null -> TILDA.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA5_null()
      { return _a5_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5_null -> TILDA.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA5_null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5_null -> TILDA.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA5_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _a5_null)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a5_null' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask);
       _a5_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a5_null -> TILDA.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA5_null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask);
       _a5_null=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a6_null -> TILDA.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _a6_null= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a6_null -> TILDA.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA6_null()
      { return _a6_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a6_null -> TILDA.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA6_null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a6_null -> TILDA.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA6_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _a6_null)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a6_null' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask);
       _a6_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a6_null -> TILDA.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA6_null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask);
       _a6_null=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_null -> TILDA.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _a7_null= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_null -> TILDA.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA7_null()
      { return _a7_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_null -> TILDA.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA7_null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_null -> TILDA.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _a7_null)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a7_null' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask);
       _a7_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a7_null -> TILDA.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA7_null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask);
       _a7_null=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8_null -> TILDA.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _a8_null= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8_null -> TILDA.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA8_null()
      { return _a8_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8_null -> TILDA.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA8_null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8_null -> TILDA.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _a8_null)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a8_null' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask);
       _a8_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a8_null -> TILDA.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA8_null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask);
       _a8_null=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a3 -> TILDA.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   boolean _a3;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a3 -> TILDA.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getA3()
      { return _a3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a3 -> TILDA.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA3()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a3 -> TILDA.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA3(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _a3)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.a3' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask);
       _a3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.a3 -> TILDA.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA3()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask);
       _a3=false;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.lastUpdated -> TILDA.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _lastUpdated;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.lastUpdated -> TILDA.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getLastUpdated()
      { return _lastUpdated; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.lastUpdated -> TILDA.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullLastUpdated()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.lastUpdated -> TILDA.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setLastUpdated(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullLastUpdated();
        }
       else if (v.equals(_lastUpdated) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Testing4Realized.lastUpdated' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing4Realized.lastUpdated -> TILDA.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>'</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullLastUpdated()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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
        throw new Exception("This TILDA.Testing4Realized object is being Read() after a Create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.Testing4Realized object has already been read.");
          QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "refnum");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "name");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a1");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a3b");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a4");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a4b");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a5");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a5b");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a7");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a7b");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a8");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a8bTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a8b");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a10a");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a10b");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a10c");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "description");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "desc2");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "desc3");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "desc4");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "desc5");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "desc6");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "bastille");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "toto");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "desc2_Cat1");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "desc2_Cat2");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "desc2_Cat3");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a7_Cat4");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a7_Cat5");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a5_null");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a6_null");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a7_null");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a8_null");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "a3");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "lastUpdated");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "Testing4Realized");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Testing4Realized", "refnum"); S.append("=?)");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.Testing4Realized", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;

       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
          switch (__LookupId)
           {
             case 0:
               PS.setLong     (++i, _refnum     );
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }
    }

   @SuppressWarnings("unchecked")
   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_refnum      = _refnum      =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask     );
                            _name        = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask       );
                            _a1          =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask         );
                            _a3b = (List<Boolean>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A3B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask        );
                            _a4          =                              RS.getDouble   (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask         );
                            _a4b = (List<Double>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A4B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask        );
                            _a5          =                              RS.getFloat    (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask         );
                            _a5b = (List<Float>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A5B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask        );
                            _a7          =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask         );
                            _a7b = (List<Integer>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A7B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask        );
                            _a8          =                              RS.getBytes    (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask         );
                            _a8bTZ       = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask      ); else _a8bTZ       = _a8bTZ      .trim();
                            _a8b         = ProcessZDT(_a8bTZ        , "tilda.data.TILDA.Testing4Realized.a8b"        , RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A8B        , TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ        ); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask        );
                            _a10a        =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask       );
                            _a10b        = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask       );
                            _a10c        =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask       );
                            _description = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask);
                            _desc2       = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask      );
                            _desc3       = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask      );
                            _desc4       = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask      );
                            _desc5       = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask      );
                            _desc6       = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask      );
                            _bastille    = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask   );
                            _toto        = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask       );
                            _desc2_Cat1  =                              RS.getDouble   (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask );
                            _desc2_Cat2  =                              RS.getDouble   (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask );
                            _desc2_Cat3  =                              RS.getDouble   (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask );
                            _a7_Cat4     =                              RS.getDouble   (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask    );
                            _a7_Cat5     =                              RS.getDouble   (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask    );
                            _a5_null     =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask    );
                            _a6_null     =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask    );
                            _a7_null     =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask    );
                            _a8_null     =                              RS.getInt      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask    );
                            _a3          =                              RS.getBoolean  (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask         );
                            _lastUpdated = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask);
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
                   "refnum: "                                                                                                    +                                   getRefnum     () 
               + "; name"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getName       ()))
               + "; a1"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask) == true ? ": NULL" : ": " +                                   getA1         () )
               + "; a3b"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask) == true ? ": NULL" : ": " + TextUtil.Print                   (getA3b        ()))
               + "; a4"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask) == true ? ": NULL" : ": " +                                   getA4         () )
               + "; a4b"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask) == true ? ": NULL" : ": " + TextUtil.Print                   (getA4b        ()))
               + "; a5"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask) == true ? ": NULL" : ": " +                                   getA5         () )
               + "; a5b"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask) == true ? ": NULL" : ": " + TextUtil.Print                   (getA5b        ()))
               + "; a7"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask) == true ? ": NULL" : ": " +                                   getA7         () )
               + "; a7b"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask) == true ? ": NULL" : ": " + TextUtil.Print                   (getA7b        ()))
               + "; a8"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask) == true ? ": NULL" : ": " +                                   getA8         () )
               + "; a8b"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getA8b        ()))
               + "; a10a"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask) == true ? ": NULL" : ": " +                                   getA10a       () )
               + "; a10b"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getA10b       ()))
               + "; a10c"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask) == true ? ": NULL" : ": " +                                   getA10c       () )
               + "; description"   + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getDescription()))
               + "; desc2"         + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getDesc2      ()))
               + "; desc3"         + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getDesc3      ()))
               + "; desc4"         + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getDesc4      ()))
               + "; desc5"         + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getDesc5      ()))
               + "; desc6"         + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getDesc6      ()))
               + "; bastille"      + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getBastille   ()))
               + "; toto"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getToto       ()))
               + "; desc2_Cat1"    + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask) == true ? ": NULL" : ": " +                                   getDesc2_Cat1 () )
               + "; desc2_Cat2"    + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask) == true ? ": NULL" : ": " +                                   getDesc2_Cat2 () )
               + "; desc2_Cat3"    + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask) == true ? ": NULL" : ": " +                                   getDesc2_Cat3 () )
               + "; a7_Cat4"       + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask) == true ? ": NULL" : ": " +                                   getA7_Cat4    () )
               + "; a7_Cat5"       + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask) == true ? ": NULL" : ": " +                                   getA7_Cat5    () )
               + "; a5_null"       + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask) == true ? ": NULL" : ": " +                                   getA5_null    () )
               + "; a6_null"       + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask) == true ? ": NULL" : ": " +                                   getA6_null    () )
               + "; a7_null"       + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask) == true ? ": NULL" : ": " +                                   getA7_null    () )
               + "; a8_null"       + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask) == true ? ": NULL" : ": " +                                   getA8_null    () )
               + "; a3"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask) == true ? ": NULL" : ": " +                                   getA3         () )
               + "; lastUpdated"   + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getLastUpdated()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
