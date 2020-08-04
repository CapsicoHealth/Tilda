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
<TABLE id="Testing_Cloned_DIV" class="tables">
<SCRIPT>registerStickyHeader("Testing_Cloned_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Testing_Cloned&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Testing_Cloned_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Testing_Cloned_CNT" class="content">
The Table TILDATEST.Testing_Cloned:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Testing_Cloned_Factory</B>, <B>Testing_Cloned_Data</B> in the package <B>tilda.data_test</B>.
<LI>Is Cloned from <B><A href="TILDA___Docs.TILDATEST.html#Testing_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing</A></B>.</LI>
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Defines foreign key(s) to <A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A> </LI>
<LI>Has the following identity:<UL><LI>Primary Key: refnum</LI>
</UL></LI>
</UL>
<B>Description</B>: blah blah - Ready for publishing (cloned from TILDATEST.Testing)<BR>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="Testing_Cloned_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-refnum_DIV' class='columns'>refnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-refnum2_DIV' class='columns'>refnum2</B>&nbsp;&nbsp;</TD>
<TD>List<Long> List<>&nbsp;/&nbsp;bigint[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The person's primary key</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-name_DIV' class='columns'>name</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Medical system unique enterprise id</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-description_DIV' class='columns'>description</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-desc2_DIV' class='columns'>desc2</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(3000)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-desc3_DIV' class='columns'>desc3</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-desc4_DIV' class='columns'>desc4</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-desc5_DIV' class='columns'>desc5</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs...</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-desc6_DIV' class='columns'>desc6</B>&nbsp;&nbsp;</TD>
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
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-tops_DIV' class='columns'>tops</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-tops2_DIV' class='columns'>tops2</B>&nbsp;&nbsp;</TD>
<TD>Set <String> Set<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a1_DIV' class='columns'>a1</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;INTEGER&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a2_DIV' class='columns'>a2</B>&nbsp;&nbsp;</TD>
<TD>char&nbsp;/&nbsp;character&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a2b_DIV' class='columns'>a2b</B>&nbsp;&nbsp;</TD>
<TD>List<Character> List<>&nbsp;/&nbsp;character[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a2c_DIV' class='columns'>a2c</B>&nbsp;&nbsp;</TD>
<TD>Set <Character> Set<>&nbsp;/&nbsp;character[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a3_DIV' class='columns'>a3</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a3b_DIV' class='columns'>a3b</B>&nbsp;&nbsp;</TD>
<TD>List<Boolean> List<>&nbsp;/&nbsp;boolean[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a4_DIV' class='columns'>a4</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a4b_DIV' class='columns'>a4b</B>&nbsp;&nbsp;</TD>
<TD>List<Double> List<>&nbsp;/&nbsp;double precision[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>20&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a5_DIV' class='columns'>a5</B>&nbsp;&nbsp;</TD>
<TD>float&nbsp;/&nbsp;real&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>21&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a5b_DIV' class='columns'>a5b</B>&nbsp;&nbsp;</TD>
<TD>List<Float> List<>&nbsp;/&nbsp;real[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>22&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a6_DIV' class='columns'>a6</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>23&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a6b_DIV' class='columns'>a6b</B>&nbsp;&nbsp;</TD>
<TD>List<Long> List<>&nbsp;/&nbsp;bigint[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>24&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a6c_DIV' class='columns'>a6c</B>&nbsp;&nbsp;</TD>
<TD>Set <Long> Set<>&nbsp;/&nbsp;bigint[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>25&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a6dTZ_DIV' class='columns'>a6dTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'a6d'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>26&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a6d_DIV' class='columns'>a6d</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>27&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a7_DIV' class='columns'>a7</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>28&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a7b_DIV' class='columns'>a7b</B>&nbsp;&nbsp;</TD>
<TD>List<Integer> List<>&nbsp;/&nbsp;integer[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>29&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a8_DIV' class='columns'>a8</B>&nbsp;&nbsp;</TD>
<TD>byte[]&nbsp;/&nbsp;BYTEA&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>30&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a8bTZ_DIV' class='columns'>a8bTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'a8b'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>31&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a8b_DIV' class='columns'>a8b</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>32&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a9TZ_DIV' class='columns'>a9TZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'a9'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>33&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a9_DIV' class='columns'>a9</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>34&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a9a1TZ_DIV' class='columns'>a9a1TZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'a9a1'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>35&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a9a1_DIV' class='columns'>a9a1</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>36&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a9bTZ_DIV' class='columns'>a9bTZ</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'a9b'.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>37&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a9b_DIV' class='columns'>a9b</B>&nbsp;&nbsp;</TD>
<TD>List<ZonedDateTime> List<>&nbsp;/&nbsp;timestamptz[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>38&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a9c_DIV' class='columns'>a9c</B>&nbsp;&nbsp;</TD>
<TD>LocalDate&nbsp;/&nbsp;date&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>39&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a9d_DIV' class='columns'>a9d</B>&nbsp;&nbsp;</TD>
<TD>List<LocalDate> List<>&nbsp;/&nbsp;date[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>40&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a10a_DIV' class='columns'>a10a</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>41&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a10b_DIV' class='columns'>a10b</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>42&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a10c_DIV' class='columns'>a10c</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>43&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a11_DIV' class='columns'>a11</B>&nbsp;&nbsp;</TD>
<TD>BigDecimal&nbsp;/&nbsp;numeric(8,4)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>44&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a11b_DIV' class='columns'>a11b</B>&nbsp;&nbsp;</TD>
<TD>List<BigDecimal> List<>&nbsp;/&nbsp;numeric(6,3)[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>45&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a11c_DIV' class='columns'>a11c</B>&nbsp;&nbsp;</TD>
<TD>BigDecimal&nbsp;/&nbsp;numeric(5,0)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>46&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a12_DIV' class='columns'>a12</B>&nbsp;&nbsp;</TD>
<TD>short&nbsp;/&nbsp;smallint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>47&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a12b_DIV' class='columns'>a12b</B>&nbsp;&nbsp;</TD>
<TD>List<Short> List<>&nbsp;/&nbsp;smallint[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>48&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a13_DIV' class='columns'>a13</B>&nbsp;&nbsp;</TD>
<TD>UUID&nbsp;/&nbsp;UUID&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>49&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-a13b_DIV' class='columns'>a13b</B>&nbsp;&nbsp;</TD>
<TD>List<UUID> List<>&nbsp;/&nbsp;UUID[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>50&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created. (TILDATEST.Testing_Cloned)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>51&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>52&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing_Cloned-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TESTING_CLONED implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__TESTING_CLONED.class.getName());

   public transient static final Class<TILDA__TESTING_CLONED_Factory> FACTORY_CLASS= TILDA__TESTING_CLONED_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDATEST.Testing_Cloned", "");

   protected TILDA__TESTING_CLONED() { }

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.refnum -> TILDATEST.Testing_Cloned."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Long _refnum=null;
   protected Long __Saved_refnum;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.refnum -> TILDATEST.Testing_Cloned."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.refnum of type bigint</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.refnum -> TILDATEST.Testing_Cloned."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.refnum of type bigint</TD></TR>

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
       if (__Init == InitMode.CREATE || _refnum == null || v != _refnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.refnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.REFNUM._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.REFNUM._Mask);
       _refnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.refnum2 -> TILDATEST.Testing_Cloned."refnum2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.refnum2 of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.refnum2 of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The person's primary key</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("refnum2")
   List<Long> _refnum2= new ArrayList<Long>();

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.refnum2 -> TILDATEST.Testing_Cloned."refnum2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.refnum2 of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.refnum2 of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The person's primary key</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final Long[] getRefnum2AsArray()
      { return _refnum2==null? null : _refnum2.toArray(new Long[_refnum2.size()]); }
   public final Iterator<Long> getRefnum2()
      { return _refnum2==null? null : _refnum2.iterator(); }
   public final boolean hasRefnum2(long v)
      { return _refnum2==null? false : _refnum2.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.refnum2 -> TILDATEST.Testing_Cloned."refnum2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.refnum2 of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.refnum2 of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The person's primary key</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setRefnum2(List<Long> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.refnum2' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null )
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.refnum2 to null: it's not nullable.");
       else if (CollectionUtil.equals(v, _refnum2) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask);
          if (_refnum2 == null)
           {
             _refnum2 = new ArrayList<Long>();
           }
          else
           {
             _refnum2.clear();
           }
          for (long i : v)
           {
             _refnum2.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   protected void addToRefnum2(int pos, long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_refnum2 == null)
        _refnum2 = new ArrayList<Long>();
       if (pos >= _refnum2.size() || _refnum2.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.refnum2' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask);
          _refnum2.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   protected void removeFromRefnum2(Long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_refnum2.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   protected void removeFromRefnum2(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_refnum2.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field refnum2 doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initRefnum2(List<Long> v) throws Exception
     {
       setRefnum2(v);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.refnum2 -> TILDATEST.Testing_Cloned."refnum2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.refnum2 of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.refnum2 of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The person's primary key</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedRefnum2()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.name -> TILDATEST.Testing_Cloned."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.name of type varchar(10)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.name -> TILDATEST.Testing_Cloned."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.name of type varchar(10)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.name -> TILDATEST.Testing_Cloned."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.name to null: it's not nullable.");
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.name: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_name) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.NAME._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.NAME._Mask);
       _name = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.name -> TILDATEST.Testing_Cloned."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedName()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.NAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.description -> TILDATEST.Testing_Cloned."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.description of type varchar(250)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.description -> TILDATEST.Testing_Cloned."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.description of type varchar(250)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.description -> TILDATEST.Testing_Cloned."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDescriptionNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.description -> TILDATEST.Testing_Cloned."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDescription(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDescriptionNull();
        }
       else if (v.length() > 250)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.description: the size "+v.length()+" is larger than the max allowed of 250: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_description) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask);
       _description = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.description -> TILDATEST.Testing_Cloned."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDescriptionNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask);
       _description=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.description -> TILDATEST.Testing_Cloned."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDescription()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc2 -> TILDATEST.Testing_Cloned."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc2 of type varchar(3000)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc2 -> TILDATEST.Testing_Cloned."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc2 of type varchar(3000)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc2 -> TILDATEST.Testing_Cloned."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc2Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc2 -> TILDATEST.Testing_Cloned."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc2(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDesc2Null();
        }
       else if (v.length() > 3000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.desc2: the size "+v.length()+" is larger than the max allowed of 3000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc2) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask);
       _desc2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc2 -> TILDATEST.Testing_Cloned."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc2Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask);
       _desc2=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc2 -> TILDATEST.Testing_Cloned."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc2()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc3 -> TILDATEST.Testing_Cloned."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc3 of type text</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc3 -> TILDATEST.Testing_Cloned."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc3 of type text</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc3 -> TILDATEST.Testing_Cloned."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc3Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc3 -> TILDATEST.Testing_Cloned."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc3(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDesc3Null();
        }
       else if (v.length() > 5000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.desc3: the size "+v.length()+" is larger than the max allowed of 5000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc3) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask);
       _desc3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc3 -> TILDATEST.Testing_Cloned."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc3Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask);
       _desc3=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc3 -> TILDATEST.Testing_Cloned."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc3()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc4 -> TILDATEST.Testing_Cloned."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc4 of type text</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc4 -> TILDATEST.Testing_Cloned."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc4 of type text</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc4 -> TILDATEST.Testing_Cloned."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc4Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc4 -> TILDATEST.Testing_Cloned."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc4(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDesc4Null();
        }
       else if (v.length() > 9000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.desc4: the size "+v.length()+" is larger than the max allowed of 9000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc4) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask);
       _desc4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc4 -> TILDATEST.Testing_Cloned."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc4Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask);
       _desc4=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc4 -> TILDATEST.Testing_Cloned."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc4()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc5 -> TILDATEST.Testing_Cloned."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc5 of type text</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc5 -> TILDATEST.Testing_Cloned."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc5 of type text</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc5 -> TILDATEST.Testing_Cloned."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc5Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc5 -> TILDATEST.Testing_Cloned."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc5(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDesc5Null();
        }
       else if (v.length() > 17000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.desc5: the size "+v.length()+" is larger than the max allowed of 17000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc5) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask);
       _desc5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc5 -> TILDATEST.Testing_Cloned."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc5Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask);
       _desc5=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc5 -> TILDATEST.Testing_Cloned."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc5()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc6 -> TILDATEST.Testing_Cloned."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc6 of type text</TD></TR>

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
These are the enumerated values for tilda.data_test.TILDATEST.Testing_Cloned.desc6, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc6 -> TILDATEST.Testing_Cloned."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc6 of type text</TD></TR>

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
This is the value is-a for tilda.data_test.TILDATEST.Testing_Cloned.desc6:<BR>
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
This is the value is-a for tilda.data_test.TILDATEST.Testing_Cloned.desc6:<BR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc6 -> TILDATEST.Testing_Cloned."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc6 of type text</TD></TR>

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
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc6 -> TILDATEST.Testing_Cloned."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc6 of type text</TD></TR>

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
   public void setDesc6(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setDesc6Null();
        }
       else if (v.length() > 33000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.desc6: the size "+v.length()+" is larger than the max allowed of 33000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc6) == false)
        {
          v = HTMLFilter.cleanSmart("tilda.data_test.TILDATEST.Testing_Cloned.desc6",v);
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask);
       _desc6 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc6 -> TILDATEST.Testing_Cloned."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc6 of type text</TD></TR>

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
   public void setDesc6Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask);
       _desc6=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/**
This is the value setter-as for tilda.data_test.TILDATEST.Testing_Cloned.desc6:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>String</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>STR</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>String</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>String</TD></TR>
</TABLE>
*/
   public void setDesc6String() throws Exception
      { setDesc6(_desc6String); }

/**
This is the value setter-as for tilda.data_test.TILDATEST.Testing_Cloned.desc6:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>DateTime</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>DTM</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>DateTime</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>DateTime</TD></TR>
</TABLE>
*/
   public void setDesc6DateTime() throws Exception
      { setDesc6(_desc6DateTime); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.desc6 -> TILDATEST.Testing_Cloned."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.desc6 of type text</TD></TR>

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
   public boolean hasChangedDesc6()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops -> TILDATEST.Testing_Cloned."tops"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("tops")
   List<String> _tops;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops -> TILDATEST.Testing_Cloned."tops"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getTopsAsArray()
      { return _tops==null? null : _tops.toArray(new String[_tops.size()]); }
   public final Iterator<String> getTops()
      { return _tops==null? null : _tops.iterator(); }
   public final boolean hasTops(String v)
      { return _tops==null? false : _tops.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops -> TILDATEST.Testing_Cloned."tops"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTopsNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops -> TILDATEST.Testing_Cloned."tops"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTops(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setTopsNull();
       else if (CollectionUtil.equals(v, _tops) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask);
          if (_tops == null)
           {
             _tops = new ArrayList<String>();
           }
          else
           {
             _tops.clear();
           }
          for (String i : v)
           {
             _tops.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToTops(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_tops == null)
        _tops = new ArrayList<String>();
       if (v == null)
        {
          setTopsNull();
        }
       else if (pos >= _tops.size() || _tops.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask);
          _tops.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromTops(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_tops.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromTops(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_tops.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops -> TILDATEST.Testing_Cloned."tops"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTopsNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask);
       _tops=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops -> TILDATEST.Testing_Cloned."tops"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTops()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops2 -> TILDATEST.Testing_Cloned."tops2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops2 of type Set <String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops2 of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("tops2")
   Set <String> _tops2;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops2 -> TILDATEST.Testing_Cloned."tops2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops2 of type Set <String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops2 of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getTops2AsArray()
      { return _tops2==null? null : _tops2.toArray(new String[_tops2.size()]); }
   public final Iterator<String> getTops2()
      { return _tops2==null? null : _tops2.iterator(); }
   public final boolean hasTops2(String v)
      { return _tops2==null? false : _tops2.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops2 -> TILDATEST.Testing_Cloned."tops2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops2 of type Set <String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops2 of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTops2Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops2 -> TILDATEST.Testing_Cloned."tops2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops2 of type Set <String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops2 of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTops2(Set <String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setTops2Null();
       else if (CollectionUtil.equals(v, _tops2) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask);
          if (_tops2 == null)
           {
             _tops2 = new TreeSet<String>();
           }
          else
           {
             _tops2.clear();
           }
          for (String i : v)
           {
             _tops2.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToTops2(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_tops2 == null)
        _tops2 = new TreeSet<String>();
       if (v == null)
        {
          setTops2Null();
        }
       else if (_tops2.contains(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask);
          _tops2.add(v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromTops2(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_tops2.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops2 -> TILDATEST.Testing_Cloned."tops2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops2 of type Set <String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops2 of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTops2Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask);
       _tops2=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.tops2 -> TILDATEST.Testing_Cloned."tops2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.tops2 of type Set <String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.tops2 of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTops2()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a1 -> TILDATEST.Testing_Cloned."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a1 of type INTEGER</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a1 -> TILDATEST.Testing_Cloned."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a1 of type INTEGER</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a1 -> TILDATEST.Testing_Cloned."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA1Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a1 -> TILDATEST.Testing_Cloned."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA1(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a1 == null || v != _a1)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask);
       _a1 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a1 -> TILDATEST.Testing_Cloned."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA1Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask);
       _a1=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a1 -> TILDATEST.Testing_Cloned."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA1()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2 -> TILDATEST.Testing_Cloned."a2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2 of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2 of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a2")
   Character _a2=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2 -> TILDATEST.Testing_Cloned."a2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2 of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2 of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final char getA2()
      { return _a2==null?(char)Character.UNASSIGNED:_a2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2 -> TILDATEST.Testing_Cloned."a2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2 of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2 of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA2Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2 -> TILDATEST.Testing_Cloned."a2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2 of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2 of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA2(char v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a2 == null || v != _a2)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask);
       _a2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2 -> TILDATEST.Testing_Cloned."a2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2 of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2 of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA2Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask);
       _a2=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2 -> TILDATEST.Testing_Cloned."a2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2 of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2 of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA2()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2b -> TILDATEST.Testing_Cloned."a2b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2b of type List<Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2b of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a2b")
   List<Character> _a2b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2b -> TILDATEST.Testing_Cloned."a2b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2b of type List<Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2b of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final Character[] getA2bAsArray()
      { return _a2b==null? null : _a2b.toArray(new Character[_a2b.size()]); }
   public final Iterator<Character> getA2b()
      { return _a2b==null? null : _a2b.iterator(); }
   public final boolean hasA2b(char v)
      { return _a2b==null? false : _a2b.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2b -> TILDATEST.Testing_Cloned."a2b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2b of type List<Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2b of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA2bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2b -> TILDATEST.Testing_Cloned."a2b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2b of type List<Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2b of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA2b(List<Character> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA2bNull();
       else if (CollectionUtil.equals(v, _a2b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask);
          if (_a2b == null)
           {
             _a2b = new ArrayList<Character>();
           }
          else
           {
             _a2b.clear();
           }
          for (char i : v)
           {
             _a2b.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToA2b(int pos, char v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a2b == null)
        _a2b = new ArrayList<Character>();
       if (pos >= _a2b.size() || _a2b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask);
          _a2b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA2b(Character v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a2b.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA2b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a2b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2b -> TILDATEST.Testing_Cloned."a2b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2b of type List<Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2b of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA2bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask);
       _a2b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2b -> TILDATEST.Testing_Cloned."a2b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2b of type List<Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2b of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA2b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2c -> TILDATEST.Testing_Cloned."a2c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2c of type Set <Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2c of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a2c")
   Set <Character> _a2c;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2c -> TILDATEST.Testing_Cloned."a2c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2c of type Set <Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2c of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final Character[] getA2cAsArray()
      { return _a2c==null? null : _a2c.toArray(new Character[_a2c.size()]); }
   public final Iterator<Character> getA2c()
      { return _a2c==null? null : _a2c.iterator(); }
   public final boolean hasA2c(char v)
      { return _a2c==null? false : _a2c.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2c -> TILDATEST.Testing_Cloned."a2c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2c of type Set <Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2c of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA2cNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2c -> TILDATEST.Testing_Cloned."a2c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2c of type Set <Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2c of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA2c(Set <Character> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA2cNull();
       else if (CollectionUtil.equals(v, _a2c) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask);
          if (_a2c == null)
           {
             _a2c = new TreeSet<Character>();
           }
          else
           {
             _a2c.clear();
           }
          for (char i : v)
           {
             _a2c.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToA2c(char v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a2c == null)
        _a2c = new TreeSet<Character>();
       if (_a2c.contains(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask);
          _a2c.add(v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA2c(Character v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a2c.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2c -> TILDATEST.Testing_Cloned."a2c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2c of type Set <Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2c of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA2cNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask);
       _a2c=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a2c -> TILDATEST.Testing_Cloned."a2c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a2c of type Set <Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a2c of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA2c()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3 -> TILDATEST.Testing_Cloned."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a3")
   Boolean _a3=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3 -> TILDATEST.Testing_Cloned."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getA3()
      { return _a3==null?false:_a3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3 -> TILDATEST.Testing_Cloned."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA3Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3 -> TILDATEST.Testing_Cloned."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA3(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a3 == null || v != _a3)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask);
       _a3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3 -> TILDATEST.Testing_Cloned."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA3Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask);
       _a3=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3 -> TILDATEST.Testing_Cloned."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA3()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3b -> TILDATEST.Testing_Cloned."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3b of type boolean[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3b -> TILDATEST.Testing_Cloned."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3b of type boolean[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3b -> TILDATEST.Testing_Cloned."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA3bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3b -> TILDATEST.Testing_Cloned."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA3b(List<Boolean> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA3bNull();
       else if (CollectionUtil.equals(v, _a3b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask);
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
   public void addToA3b(int pos, boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a3b == null)
        _a3b = new ArrayList<Boolean>();
       if (pos >= _a3b.size() || _a3b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask);
          _a3b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA3b(Boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a3b.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA3b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a3b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3b -> TILDATEST.Testing_Cloned."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA3bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask);
       _a3b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a3b -> TILDATEST.Testing_Cloned."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA3b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4 -> TILDATEST.Testing_Cloned."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4 of type double precision</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4 -> TILDATEST.Testing_Cloned."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4 of type double precision</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4 -> TILDATEST.Testing_Cloned."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA4Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4 -> TILDATEST.Testing_Cloned."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA4(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a4 == null || v != _a4)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask);
       _a4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4 -> TILDATEST.Testing_Cloned."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA4Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask);
       _a4=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4 -> TILDATEST.Testing_Cloned."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA4()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4b -> TILDATEST.Testing_Cloned."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4b of type double precision[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4b -> TILDATEST.Testing_Cloned."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4b of type double precision[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4b -> TILDATEST.Testing_Cloned."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA4bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4b -> TILDATEST.Testing_Cloned."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA4b(List<Double> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA4bNull();
       else if (CollectionUtil.equals(v, _a4b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask);
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
   public void addToA4b(int pos, double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a4b == null)
        _a4b = new ArrayList<Double>();
       if (pos >= _a4b.size() || _a4b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask);
          _a4b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA4b(Double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a4b.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA4b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a4b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4b -> TILDATEST.Testing_Cloned."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA4bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask);
       _a4b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a4b -> TILDATEST.Testing_Cloned."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA4b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5 -> TILDATEST.Testing_Cloned."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5 of type real</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5 -> TILDATEST.Testing_Cloned."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5 of type real</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5 -> TILDATEST.Testing_Cloned."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA5Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5 -> TILDATEST.Testing_Cloned."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA5(float v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a5 == null || v != _a5)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask);
       _a5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5 -> TILDATEST.Testing_Cloned."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA5Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask);
       _a5=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5 -> TILDATEST.Testing_Cloned."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA5()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5b -> TILDATEST.Testing_Cloned."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5b of type real[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5b -> TILDATEST.Testing_Cloned."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5b of type real[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5b -> TILDATEST.Testing_Cloned."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA5bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5b -> TILDATEST.Testing_Cloned."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA5b(List<Float> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA5bNull();
       else if (CollectionUtil.equals(v, _a5b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask);
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
   public void addToA5b(int pos, float v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a5b == null)
        _a5b = new ArrayList<Float>();
       if (pos >= _a5b.size() || _a5b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask);
          _a5b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA5b(Float v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a5b.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA5b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a5b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5b -> TILDATEST.Testing_Cloned."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA5bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask);
       _a5b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a5b -> TILDATEST.Testing_Cloned."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA5b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6 -> TILDATEST.Testing_Cloned."a6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6 of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6 of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a6")
   Long _a6=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6 -> TILDATEST.Testing_Cloned."a6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6 of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6 of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getA6()
      { return _a6==null?0l:_a6; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6 -> TILDATEST.Testing_Cloned."a6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6 of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6 of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA6Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6 -> TILDATEST.Testing_Cloned."a6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6 of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6 of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA6(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a6 == null || v != _a6)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask);
       _a6 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6 -> TILDATEST.Testing_Cloned."a6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6 of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6 of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA6Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask);
       _a6=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6 -> TILDATEST.Testing_Cloned."a6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6 of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6 of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA6()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6b -> TILDATEST.Testing_Cloned."a6b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6b of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6b of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a6b")
   List<Long> _a6b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6b -> TILDATEST.Testing_Cloned."a6b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6b of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6b of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final Long[] getA6bAsArray()
      { return _a6b==null? null : _a6b.toArray(new Long[_a6b.size()]); }
   public final Iterator<Long> getA6b()
      { return _a6b==null? null : _a6b.iterator(); }
   public final boolean hasA6b(long v)
      { return _a6b==null? false : _a6b.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6b -> TILDATEST.Testing_Cloned."a6b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6b of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6b of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA6bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6b -> TILDATEST.Testing_Cloned."a6b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6b of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6b of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA6b(List<Long> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA6bNull();
       else if (CollectionUtil.equals(v, _a6b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask);
          if (_a6b == null)
           {
             _a6b = new ArrayList<Long>();
           }
          else
           {
             _a6b.clear();
           }
          for (long i : v)
           {
             _a6b.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToA6b(int pos, long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a6b == null)
        _a6b = new ArrayList<Long>();
       if (pos >= _a6b.size() || _a6b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask);
          _a6b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA6b(Long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a6b.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA6b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a6b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6b -> TILDATEST.Testing_Cloned."a6b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6b of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6b of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA6bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask);
       _a6b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6b -> TILDATEST.Testing_Cloned."a6b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6b of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6b of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA6b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6c -> TILDATEST.Testing_Cloned."a6c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6c of type Set <Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6c of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a6c")
   Set <Long> _a6c;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6c -> TILDATEST.Testing_Cloned."a6c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6c of type Set <Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6c of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final Long[] getA6cAsArray()
      { return _a6c==null? null : _a6c.toArray(new Long[_a6c.size()]); }
   public final Iterator<Long> getA6c()
      { return _a6c==null? null : _a6c.iterator(); }
   public final boolean hasA6c(long v)
      { return _a6c==null? false : _a6c.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6c -> TILDATEST.Testing_Cloned."a6c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6c of type Set <Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6c of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA6cNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6c -> TILDATEST.Testing_Cloned."a6c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6c of type Set <Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6c of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA6c(Set <Long> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA6cNull();
       else if (CollectionUtil.equals(v, _a6c) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask);
          if (_a6c == null)
           {
             _a6c = new TreeSet<Long>();
           }
          else
           {
             _a6c.clear();
           }
          for (long i : v)
           {
             _a6c.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToA6c(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a6c == null)
        _a6c = new TreeSet<Long>();
       if (_a6c.contains(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask);
          _a6c.add(v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA6c(Long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a6c.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6c -> TILDATEST.Testing_Cloned."a6c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6c of type Set <Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6c of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA6cNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask);
       _a6c=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6c -> TILDATEST.Testing_Cloned."a6c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6c of type Set <Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6c of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA6c()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ -> TILDATEST.Testing_Cloned."a6dTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6dTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a6d'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _a6dTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ -> TILDATEST.Testing_Cloned."a6dTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6dTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a6d'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getA6dTZ()
      { return _a6dTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ -> TILDATEST.Testing_Cloned."a6dTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6dTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a6d'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA6dTZNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ -> TILDATEST.Testing_Cloned."a6dTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6dTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a6d'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA6dTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA6dTZNull();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_a6dTZ) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask);
       _a6dTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ -> TILDATEST.Testing_Cloned."a6dTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6dTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a6d'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA6dTZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask);
       _a6dTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ -> TILDATEST.Testing_Cloned."a6dTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6dTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6dTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a6d'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA6dTZ()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6d -> TILDATEST.Testing_Cloned."a6d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6d of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6d of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a6d")
   String  Str_a6d;
   public void initA6d(String v) { Str_a6d = v; }
   public String initA6dVal() { return Str_a6d; }
   transient ZonedDateTime _a6d = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6d -> TILDATEST.Testing_Cloned."a6d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6d of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6d of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getA6d()
      { return _a6d; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6d -> TILDATEST.Testing_Cloned."a6d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6d of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6d of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA6dNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6d -> TILDATEST.Testing_Cloned."a6d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6d of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6d of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA6d(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA6dNull();
        }
       else if (v.equals(_a6d) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask);
       _a6d = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a6d' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA6dTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6d -> TILDATEST.Testing_Cloned."a6d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6d of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6d of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA6dNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask);
       _a6d=null;
       setA6dTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6d -> TILDATEST.Testing_Cloned."a6d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6d of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6d of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setA6dNow() throws Exception
    {
      setA6d(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6d -> TILDATEST.Testing_Cloned."a6d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6d of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6d of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setA6dUndefined() throws Exception
    {
      setA6d(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6d -> TILDATEST.Testing_Cloned."a6d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6d of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6d of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setA6d(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setA6d(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a6d -> TILDATEST.Testing_Cloned."a6d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a6d of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a6d of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA6d()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7 -> TILDATEST.Testing_Cloned."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7 of type integer</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7 -> TILDATEST.Testing_Cloned."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7 of type integer</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7 -> TILDATEST.Testing_Cloned."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7 -> TILDATEST.Testing_Cloned."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA7(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a7 == null || v != _a7)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask);
       _a7 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7 -> TILDATEST.Testing_Cloned."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA7Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask);
       _a7=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7 -> TILDATEST.Testing_Cloned."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA7()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7b -> TILDATEST.Testing_Cloned."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7b of type integer[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7b -> TILDATEST.Testing_Cloned."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7b of type integer[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7b -> TILDATEST.Testing_Cloned."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7b -> TILDATEST.Testing_Cloned."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA7b(List<Integer> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA7bNull();
       else if (CollectionUtil.equals(v, _a7b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask);
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
   public void addToA7b(int pos, int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a7b == null)
        _a7b = new ArrayList<Integer>();
       if (pos >= _a7b.size() || _a7b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask);
          _a7b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA7b(Integer v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a7b.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA7b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a7b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7b -> TILDATEST.Testing_Cloned."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA7bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask);
       _a7b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a7b -> TILDATEST.Testing_Cloned."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA7b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8 -> TILDATEST.Testing_Cloned."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8 of type BYTEA</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8 -> TILDATEST.Testing_Cloned."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8 of type BYTEA</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8 -> TILDATEST.Testing_Cloned."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8 -> TILDATEST.Testing_Cloned."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA8(byte[] v) throws Exception
     {
       long T0 = System.nanoTime();
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask);
       _a8 = v;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8 -> TILDATEST.Testing_Cloned."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA8Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask);
       _a8=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8 -> TILDATEST.Testing_Cloned."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA8()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ -> TILDATEST.Testing_Cloned."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ -> TILDATEST.Testing_Cloned."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ -> TILDATEST.Testing_Cloned."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8bTZNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ -> TILDATEST.Testing_Cloned."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
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
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_a8bTZ) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask);
       _a8bTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ -> TILDATEST.Testing_Cloned."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
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
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask);
       _a8bTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ -> TILDATEST.Testing_Cloned."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8bTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA8bTZ()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8b -> TILDATEST.Testing_Cloned."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8b of type timestamptz</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8b -> TILDATEST.Testing_Cloned."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8b of type timestamptz</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8b -> TILDATEST.Testing_Cloned."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8b -> TILDATEST.Testing_Cloned."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA8b(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA8bNull();
        }
       else if (v.equals(_a8b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask);
       _a8b = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a8b' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA8bTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8b -> TILDATEST.Testing_Cloned."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA8bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask);
       _a8b=null;
       setA8bTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8b -> TILDATEST.Testing_Cloned."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setA8bNow() throws Exception
    {
      setA8b(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8b -> TILDATEST.Testing_Cloned."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setA8bUndefined() throws Exception
    {
      setA8b(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8b -> TILDATEST.Testing_Cloned."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setA8b(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setA8b(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a8b -> TILDATEST.Testing_Cloned."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA8b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9TZ -> TILDATEST.Testing_Cloned."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _a9TZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9TZ -> TILDATEST.Testing_Cloned."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getA9TZ()
      { return _a9TZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9TZ -> TILDATEST.Testing_Cloned."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA9TZNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9TZ -> TILDATEST.Testing_Cloned."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA9TZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA9TZNull();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.a9TZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_a9TZ) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask);
       _a9TZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9TZ -> TILDATEST.Testing_Cloned."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA9TZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask);
       _a9TZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9TZ -> TILDATEST.Testing_Cloned."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA9TZ()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9 -> TILDATEST.Testing_Cloned."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>a9_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("a9")
   String  Str_a9;
   public void initA9(String v) { Str_a9 = v; }
   public String initA9Val() { return Str_a9; }
   transient ZonedDateTime _a9 = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9 -> TILDATEST.Testing_Cloned."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>a9_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getA9()
      { return _a9; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9 -> TILDATEST.Testing_Cloned."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>a9_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isA9Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9 -> TILDATEST.Testing_Cloned."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>a9_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setA9(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA9Null();
        }
       else if (v.equals(_a9) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask);
       _a9 = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a9' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA9TZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9 -> TILDATEST.Testing_Cloned."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>a9_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setA9Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask);
       _a9=null;
       setA9TZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9 -> TILDATEST.Testing_Cloned."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>a9_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setA9Now() throws Exception
    {
      setA9(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9 -> TILDATEST.Testing_Cloned."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>a9_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setA9Undefined() throws Exception
    {
      setA9(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9 -> TILDATEST.Testing_Cloned."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>a9_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setA9(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setA9(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9 -> TILDATEST.Testing_Cloned."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>a9_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedA9()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ -> TILDATEST.Testing_Cloned."a9a1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9a1'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _a9a1TZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ -> TILDATEST.Testing_Cloned."a9a1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9a1'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getA9a1TZ()
      { return _a9a1TZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ -> TILDATEST.Testing_Cloned."a9a1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9a1'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA9a1TZNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ -> TILDATEST.Testing_Cloned."a9a1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9a1'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA9a1TZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA9a1TZNull();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_a9a1TZ) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask);
       _a9a1TZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ -> TILDATEST.Testing_Cloned."a9a1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9a1'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA9a1TZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask);
       _a9a1TZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ -> TILDATEST.Testing_Cloned."a9a1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9a1'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA9a1TZ()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1 -> TILDATEST.Testing_Cloned."a9a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9a1_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("a9a1")
   String  Str_a9a1;
   public void initA9a1(String v) { Str_a9a1 = v; }
   public String initA9a1Val() { return Str_a9a1; }
   transient ZonedDateTime _a9a1 = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1 -> TILDATEST.Testing_Cloned."a9a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9a1_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getA9a1()
      { return _a9a1; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1 -> TILDATEST.Testing_Cloned."a9a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9a1_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isA9a1Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1 -> TILDATEST.Testing_Cloned."a9a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9a1_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setA9a1(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA9a1Null();
        }
       else if (v.equals(_a9a1) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask);
       _a9a1 = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a9a1' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA9a1TZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1 -> TILDATEST.Testing_Cloned."a9a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9a1_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setA9a1Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask);
       _a9a1=null;
       setA9a1TZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1 -> TILDATEST.Testing_Cloned."a9a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9a1_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setA9a1Now() throws Exception
    {
      setA9a1(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1 -> TILDATEST.Testing_Cloned."a9a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9a1_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setA9a1Undefined() throws Exception
    {
      setA9a1(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1 -> TILDATEST.Testing_Cloned."a9a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9a1_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setA9a1(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setA9a1(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9a1 -> TILDATEST.Testing_Cloned."a9a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9a1 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9a1 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>a9a1_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>a9a1_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedA9a1()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ -> TILDATEST.Testing_Cloned."a9bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9bTZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   List<String> _a9bTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ -> TILDATEST.Testing_Cloned."a9bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9bTZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getA9bTZAsArray()
      { return _a9bTZ==null? null : _a9bTZ.toArray(new String[_a9bTZ.size()]); }
   public final Iterator<String> getA9bTZ()
      { return _a9bTZ==null? null : _a9bTZ.iterator(); }
   public final boolean hasA9bTZ(String v)
      { return _a9bTZ==null? false : _a9bTZ.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ -> TILDATEST.Testing_Cloned."a9bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9bTZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA9bTZNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ -> TILDATEST.Testing_Cloned."a9bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9bTZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA9bTZ(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA9bTZNull();
       else if (CollectionUtil.equals(v, _a9bTZ) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask);
          if (_a9bTZ == null)
           {
             _a9bTZ = new ArrayList<String>();
           }
          else
           {
             _a9bTZ.clear();
           }
          for (String i : v)
           {
             _a9bTZ.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA9bTZ(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9bTZ == null)
        _a9bTZ = new ArrayList<String>();
       if (v == null)
        {
          setA9bTZNull();
        }
       else if (pos >= _a9bTZ.size() || _a9bTZ.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask);
          _a9bTZ.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA9bTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9bTZ.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA9bTZ(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9bTZ.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ -> TILDATEST.Testing_Cloned."a9bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9bTZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA9bTZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask);
       _a9bTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ -> TILDATEST.Testing_Cloned."a9bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9bTZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9bTZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9b'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA9bTZ()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9b -> TILDATEST.Testing_Cloned."a9b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9b of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9b of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a9b")
   List<String>  Str_a9b;
   public void initA9b(List<String> v) { Str_a9b = v; }
   public List<String> initA9bVal() { return Str_a9b; }
   transient List<ZonedDateTime> _a9b = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9b -> TILDATEST.Testing_Cloned."a9b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9b of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9b of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime[] getA9bAsArray()
      { return _a9b==null? null : _a9b.toArray(new ZonedDateTime[_a9b.size()]); }
   public final Iterator<ZonedDateTime> getA9b()
      { return _a9b==null? null : _a9b.iterator(); }
   public final boolean hasA9b(ZonedDateTime v)
      { return _a9b==null? false : _a9b.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9b -> TILDATEST.Testing_Cloned."a9b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9b of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9b of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA9bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9b -> TILDATEST.Testing_Cloned."a9b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9b of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9b of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA9b(List<ZonedDateTime> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA9bNull();
       else if (CollectionUtil.equals(v, _a9b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask);
          if (_a9b == null)
           {
             _a9b = new ArrayList<ZonedDateTime>();
             _a9bTZ = new ArrayList<String>();
           }
          else
           {
             _a9b.clear();
             _a9bTZ.clear();
           }
          for (int k = 0; k < v.size(); ++k)
           {
             ZonedDateTime i = v.get(k);
             _a9b.add(i);
             tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(i.getZone().getId());
             if (ZI == null)
              throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a9b' because the timezone value '"+i.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
             addToA9bTZ(k, ZI.getId());
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToA9b(int pos, ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9b == null)
        _a9b = new ArrayList<ZonedDateTime>();
       if (v == null)
        {
          setA9bNull();
        }
       else if (pos >= _a9b.size() || _a9b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask);
          _a9b.add(pos, v);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a9b' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          addToA9bTZ(pos, ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA9b(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       int i = _a9b.indexOf(v);
       if (1 != -1)
        {
          _a9b.remove(i);
          removeFromA9bTZ(i);
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA9b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask);
          removeFromA9bTZ(pos);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9b -> TILDATEST.Testing_Cloned."a9b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9b of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9b of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA9bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask);
       _a9b=null;
       setA9bTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9b -> TILDATEST.Testing_Cloned."a9b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9b of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9b of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA9b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9c -> TILDATEST.Testing_Cloned."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9c of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9c of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a9c")
   LocalDate _a9c=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9c -> TILDATEST.Testing_Cloned."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9c of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9c of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final LocalDate getA9c()
      { return _a9c; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9c -> TILDATEST.Testing_Cloned."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9c of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9c of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA9cNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9c -> TILDATEST.Testing_Cloned."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9c of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9c of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA9c(LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA9cNull();
        }
       else if (v.equals(_a9c) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask);
       _a9c = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9c -> TILDATEST.Testing_Cloned."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9c of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9c of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA9cNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask);
       _a9c=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9c -> TILDATEST.Testing_Cloned."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9c of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9c of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA9c()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9d -> TILDATEST.Testing_Cloned."a9d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9d of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9d of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a9d")
   List<LocalDate> _a9d;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9d -> TILDATEST.Testing_Cloned."a9d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9d of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9d of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final LocalDate[] getA9dAsArray()
      { return _a9d==null? null : _a9d.toArray(new LocalDate[_a9d.size()]); }
   public final Iterator<LocalDate> getA9d()
      { return _a9d==null? null : _a9d.iterator(); }
   public final boolean hasA9d(LocalDate v)
      { return _a9d==null? false : _a9d.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9d -> TILDATEST.Testing_Cloned."a9d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9d of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9d of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA9dNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9d -> TILDATEST.Testing_Cloned."a9d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9d of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9d of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA9d(List<LocalDate> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA9dNull();
       else if (CollectionUtil.equals(v, _a9d) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask);
          if (_a9d == null)
           {
             _a9d = new ArrayList<LocalDate>();
           }
          else
           {
             _a9d.clear();
           }
          for (LocalDate i : v)
           {
             _a9d.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToA9d(int pos, LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9d == null)
        _a9d = new ArrayList<LocalDate>();
       if (v == null)
        {
          setA9dNull();
        }
       else if (pos >= _a9d.size() || _a9d.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask);
          _a9d.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA9d(LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9d.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA9d(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9d.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9d -> TILDATEST.Testing_Cloned."a9d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9d of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9d of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA9dNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask);
       _a9d=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a9d -> TILDATEST.Testing_Cloned."a9d"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a9d of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a9d of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA9d()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10a -> TILDATEST.Testing_Cloned."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10a of type integer</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10a -> TILDATEST.Testing_Cloned."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10a of type integer</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10a -> TILDATEST.Testing_Cloned."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA10aNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10a -> TILDATEST.Testing_Cloned."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA10a(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a10a == null || v != _a10a)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask);
       _a10a = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10a -> TILDATEST.Testing_Cloned."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA10aNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask);
       _a10a=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10a -> TILDATEST.Testing_Cloned."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA10a()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10b -> TILDATEST.Testing_Cloned."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10b of type varchar(10)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10b -> TILDATEST.Testing_Cloned."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10b of type varchar(10)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10b -> TILDATEST.Testing_Cloned."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA10bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10b -> TILDATEST.Testing_Cloned."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA10b(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA10bNull();
        }
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.a10b: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_a10b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask);
       _a10b = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10b -> TILDATEST.Testing_Cloned."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA10bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask);
       _a10b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10b -> TILDATEST.Testing_Cloned."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA10b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10c -> TILDATEST.Testing_Cloned."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10c of type integer</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10c -> TILDATEST.Testing_Cloned."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10c of type integer</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10c -> TILDATEST.Testing_Cloned."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA10cNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10c -> TILDATEST.Testing_Cloned."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA10c(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a10c == null || v != _a10c)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask);
       _a10c = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10c -> TILDATEST.Testing_Cloned."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA10cNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask);
       _a10c=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a10c -> TILDATEST.Testing_Cloned."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA10c()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11 -> TILDATEST.Testing_Cloned."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11 of type numeric(8,4)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11 -> TILDATEST.Testing_Cloned."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11 of type numeric(8,4)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11 -> TILDATEST.Testing_Cloned."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA11Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11 -> TILDATEST.Testing_Cloned."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA11(BigDecimal v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a11 == null || v != _a11)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask);
       _a11 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11 -> TILDATEST.Testing_Cloned."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA11Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask);
       _a11=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11 -> TILDATEST.Testing_Cloned."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA11()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11b -> TILDATEST.Testing_Cloned."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11b of type numeric(6,3)[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11b -> TILDATEST.Testing_Cloned."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11b of type numeric(6,3)[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11b -> TILDATEST.Testing_Cloned."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA11bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11b -> TILDATEST.Testing_Cloned."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA11b(List<BigDecimal> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA11bNull();
       else if (CollectionUtil.equals(v, _a11b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask);
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
   public void addToA11b(int pos, BigDecimal v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a11b == null)
        _a11b = new ArrayList<BigDecimal>();
       if (pos >= _a11b.size() || _a11b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask);
          _a11b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA11b(BigDecimal v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a11b.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA11b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a11b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11b -> TILDATEST.Testing_Cloned."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA11bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask);
       _a11b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11b -> TILDATEST.Testing_Cloned."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA11b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11c -> TILDATEST.Testing_Cloned."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11c of type numeric(5,0)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11c -> TILDATEST.Testing_Cloned."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11c of type numeric(5,0)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11c -> TILDATEST.Testing_Cloned."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA11cNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11c -> TILDATEST.Testing_Cloned."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA11c(BigDecimal v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a11c == null || v != _a11c)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask);
       _a11c = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11c -> TILDATEST.Testing_Cloned."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA11cNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask);
       _a11c=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a11c -> TILDATEST.Testing_Cloned."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA11c()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12 -> TILDATEST.Testing_Cloned."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12 of type smallint</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12 -> TILDATEST.Testing_Cloned."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12 of type smallint</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12 -> TILDATEST.Testing_Cloned."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA12Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12 -> TILDATEST.Testing_Cloned."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA12(short v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a12 == null || v != _a12)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask);
       _a12 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12 -> TILDATEST.Testing_Cloned."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA12Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask);
       _a12=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12 -> TILDATEST.Testing_Cloned."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA12()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12b -> TILDATEST.Testing_Cloned."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12b of type smallint[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12b -> TILDATEST.Testing_Cloned."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12b of type smallint[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12b -> TILDATEST.Testing_Cloned."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA12bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12b -> TILDATEST.Testing_Cloned."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA12b(List<Short> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA12bNull();
       else if (CollectionUtil.equals(v, _a12b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask);
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
   public void addToA12b(int pos, short v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a12b == null)
        _a12b = new ArrayList<Short>();
       if (pos >= _a12b.size() || _a12b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask);
          _a12b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA12b(Short v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a12b.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA12b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a12b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12b -> TILDATEST.Testing_Cloned."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA12bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask);
       _a12b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a12b -> TILDATEST.Testing_Cloned."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA12b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13 -> TILDATEST.Testing_Cloned."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13 -> TILDATEST.Testing_Cloned."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13 -> TILDATEST.Testing_Cloned."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA13Null()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13 -> TILDATEST.Testing_Cloned."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA13(UUID v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setA13Null();
        }
       else if (v.equals(_a13) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask);
       _a13 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13 -> TILDATEST.Testing_Cloned."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA13Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask);
       _a13=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13 -> TILDATEST.Testing_Cloned."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA13()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13b -> TILDATEST.Testing_Cloned."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13b of type UUID[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13b -> TILDATEST.Testing_Cloned."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13b of type UUID[]</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13b -> TILDATEST.Testing_Cloned."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA13bNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13b -> TILDATEST.Testing_Cloned."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA13b(List<UUID> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setA13bNull();
       else if (CollectionUtil.equals(v, _a13b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask);
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
   public void addToA13b(int pos, UUID v) throws Exception
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
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask);
          _a13b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA13b(UUID v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a13b.remove(v) == true)
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA13b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a13b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13b -> TILDATEST.Testing_Cloned."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA13bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask);
       _a13b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.a13b -> TILDATEST.Testing_Cloned."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA13b()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.created -> TILDATEST.Testing_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.created -> TILDATEST.Testing_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.created -> TILDATEST.Testing_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.Testing_Cloned)</TD></TR>
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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask);
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.created -> TILDATEST.Testing_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.created -> TILDATEST.Testing_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.created -> TILDATEST.Testing_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.Testing_Cloned)</TD></TR>
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
      setCreated(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.created -> TILDATEST.Testing_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.Testing_Cloned)</TD></TR>
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
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated -> TILDATEST.Testing_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated -> TILDATEST.Testing_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated -> TILDATEST.Testing_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)</TD></TR>
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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated -> TILDATEST.Testing_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated -> TILDATEST.Testing_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated -> TILDATEST.Testing_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated -> TILDATEST.Testing_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing_Cloned)</TD></TR>
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
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.deleted -> TILDATEST.Testing_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _deleted = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.deleted -> TILDATEST.Testing_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDeleted()
      { return _deleted; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.deleted -> TILDATEST.Testing_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDeletedNull()
     { return __Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.deleted -> TILDATEST.Testing_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)</TD></TR>
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
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask);
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.deleted -> TILDATEST.Testing_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDeletedNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask);
       __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask);
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing_Cloned.deleted -> TILDATEST.Testing_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.deleted -> TILDATEST.Testing_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.deleted -> TILDATEST.Testing_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing_Cloned.deleted -> TILDATEST.Testing_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing_Cloned.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing_Cloned.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.Testing_Cloned)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleted()
     { return __Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.data_test._Tilda.TILDA__TESTING_CLONED Dst) throws Exception
     {
       Dst.setName       (_name       );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask) == true) Dst.setDescriptionNull(); else        Dst.setDescription(_description);
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask) == true) Dst.setDesc2Null      (); else        Dst.setDesc2      (_desc2      );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask) == true) Dst.setDesc3Null      (); else        Dst.setDesc3      (_desc3      );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask) == true) Dst.setDesc4Null      (); else        Dst.setDesc4      (_desc4      );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask) == true) Dst.setDesc5Null      (); else        Dst.setDesc5      (_desc5      );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask) == true) Dst.setDesc6Null      (); else        Dst.setDesc6      (_desc6      );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask) == true) Dst.setTopsNull       (); else        Dst.setTops       (_tops       );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask) == true) Dst.setTops2Null      (); else        Dst.setTops2      (_tops2      );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask) == true) Dst.setA1Null         (); else        Dst.setA1         (_a1         );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask) == true) Dst.setA2Null         (); else        Dst.setA2         (_a2         );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask) == true) Dst.setA2bNull        (); else        Dst.setA2b        (_a2b        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask) == true) Dst.setA2cNull        (); else        Dst.setA2c        (_a2c        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask) == true) Dst.setA3Null         (); else        Dst.setA3         (_a3         );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask) == true) Dst.setA3bNull        (); else        Dst.setA3b        (_a3b        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask) == true) Dst.setA4Null         (); else        Dst.setA4         (_a4         );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask) == true) Dst.setA4bNull        (); else        Dst.setA4b        (_a4b        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask) == true) Dst.setA5Null         (); else        Dst.setA5         (_a5         );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask) == true) Dst.setA5bNull        (); else        Dst.setA5b        (_a5b        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask) == true) Dst.setA6Null         (); else        Dst.setA6         (_a6         );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask) == true) Dst.setA6bNull        (); else        Dst.setA6b        (_a6b        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask) == true) Dst.setA6cNull        (); else        Dst.setA6c        (_a6c        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask) == true) Dst.setA6dTZNull      (); else        Dst.setA6dTZ      (_a6dTZ      );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask) == true) Dst.setA6dNull        (); else        Dst.setA6d        (_a6d        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask) == true) Dst.setA7Null         (); else        Dst.setA7         (_a7         );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask) == true) Dst.setA7bNull        (); else        Dst.setA7b        (_a7b        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask) == true) Dst.setA8Null         (); else        Dst.setA8         (_a8         );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask) == true) Dst.setA8bTZNull      (); else        Dst.setA8bTZ      (_a8bTZ      );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask) == true) Dst.setA8bNull        (); else        Dst.setA8b        (_a8b        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask) == true) Dst.setA9TZNull       (); else        Dst.setA9TZ       (_a9TZ       );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask) == true) Dst.setA9Null         (); else        Dst.setA9         (_a9         );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask) == true) Dst.setA9a1TZNull     (); else        Dst.setA9a1TZ     (_a9a1TZ     );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask) == true) Dst.setA9a1Null       (); else        Dst.setA9a1       (_a9a1       );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask) == true) Dst.setA9bTZNull      (); else        Dst.setA9bTZ      (_a9bTZ      );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask) == true) Dst.setA9bNull        (); else        Dst.setA9b        (_a9b        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask) == true) Dst.setA9cNull        (); else        Dst.setA9c        (_a9c        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask) == true) Dst.setA9dNull        (); else        Dst.setA9d        (_a9d        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask) == true) Dst.setA10aNull       (); else        Dst.setA10a       (_a10a       );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask) == true) Dst.setA10bNull       (); else        Dst.setA10b       (_a10b       );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask) == true) Dst.setA10cNull       (); else        Dst.setA10c       (_a10c       );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask) == true) Dst.setA11Null        (); else        Dst.setA11        (_a11        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask) == true) Dst.setA11bNull       (); else        Dst.setA11b       (_a11b       );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask) == true) Dst.setA11cNull       (); else        Dst.setA11c       (_a11c       );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask) == true) Dst.setA12Null        (); else        Dst.setA12        (_a12        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask) == true) Dst.setA12bNull       (); else        Dst.setA12b       (_a12b       );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask) == true) Dst.setA13Null        (); else        Dst.setA13        (_a13        );
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask) == true) Dst.setA13bNull       (); else        Dst.setA13b       (_a13b       );
       Dst.setLastUpdated(_lastUpdated);
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask) == true) Dst.setDeletedNull    (); else        Dst.setDeleted    (_deleted    );
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
          setRefnum(tilda.db.KeysManager.getKey("TILDATEST.TESTING_CLONED"));
        }

       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data_test.TILDATEST.Testing_Cloned has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__TESTING_CLONED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }


       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data_test.TILDATEST.Testing_Cloned object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__TESTING_CLONED_Factory.SCHEMA_TABLENAME_LABEL, "");
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
               PS.setLong      (++i, _refnum     );
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
          tilda.data_test._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TESTING_CLONED_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (_refnum2 == null || _refnum2.isEmpty() == true)
        throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Testing_Cloned.refnum2' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask);

       if (TextUtil.isNullOrEmpty(_name) == true)
        throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Testing_Cloned.name' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.NAME._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.NAME._Mask);

       if (TextUtil.isNullOrEmpty(_description) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask);
        }

       if (TextUtil.isNullOrEmpty(_desc2) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask);
        }

       if (TextUtil.isNullOrEmpty(_desc3) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask);
        }

       if (TextUtil.isNullOrEmpty(_desc4) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask);
        }

       if (TextUtil.isNullOrEmpty(_desc5) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask);
        }

       if (TextUtil.isNullOrEmpty(_desc6) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask);
        }

       if (_tops != null && _tops.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask);
        }

       if (_tops2 != null && _tops2.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask);
        }

       if (_a1 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask);
        }

       if (_a2 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask);
        }

       if (_a2b != null && _a2b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask);
        }

       if (_a2c != null && _a2c.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask);
        }

       if (_a3 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask);
        }

       if (_a3b != null && _a3b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask);
        }

       if (_a4 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask);
        }

       if (_a4b != null && _a4b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask);
        }

       if (_a5 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask);
        }

       if (_a5b != null && _a5b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask);
        }

       if (_a6 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask);
        }

       if (_a6b != null && _a6b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask);
        }

       if (_a6c != null && _a6c.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask);
        }

       if (TextUtil.isNullOrEmpty(Str_a6d) == false)
        {
          _a6d = DateTimeUtil.parsefromJSON(Str_a6d);
          if (   _a6d == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Testing_Cloned.a6d' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_a6d.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a6d' because the timezone value '"+_a6d.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA6dTZ(ZI.getId());
        }

       if (_a7 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask);
        }

       if (_a7b != null && _a7b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask);
        }

       if (_a8 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask);
        }

       if (TextUtil.isNullOrEmpty(Str_a8b) == false)
        {
          _a8b = DateTimeUtil.parsefromJSON(Str_a8b);
          if (   _a8b == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Testing_Cloned.a8b' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_a8b.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a8b' because the timezone value '"+_a8b.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA8bTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_a9) == false)
        {
          _a9 = DateTimeUtil.parsefromJSON(Str_a9);
          if (   _a9 == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Testing_Cloned.a9' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_a9.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a9' because the timezone value '"+_a9.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA9TZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_a9a1) == false)
        {
          _a9a1 = DateTimeUtil.parsefromJSON(Str_a9a1);
          if (   _a9a1 == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Testing_Cloned.a9a1' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_a9a1.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a9a1' because the timezone value '"+_a9a1.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA9a1TZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_a9b) == false)
        {
          _a9b = DateTimeUtil.parsefromJSON(Str_a9b);
          if (   _a9b == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Testing_Cloned.a9b' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask);
          for (int pos = 0; pos < _a9b.size(); ++pos)
            {
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_a9b.get(pos).getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing_Cloned.a9b' because the timezone value '"+_a9b.get(pos).getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          addToA9bTZ(pos, ZI.getId());
            }
        }

       if (_a9c != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask);
        }

       if (_a9d != null && _a9d.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask);
        }

       if (_a10a != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask);
        }

       if (TextUtil.isNullOrEmpty(_a10b) == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask);
        }

       if (_a10c != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask);
        }

       if (_a11 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask);
        }

       if (_a11b != null && _a11b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask);
        }

       if (_a11c != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask);
        }

       if (_a12 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask);
        }

       if (_a12b != null && _a12b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask);
        }

       if (_a13 != null)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask);
        }

       if (_a13b != null && _a13b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask);
          __Nulls.andNot(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask);
        }
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_a6d) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_a8b) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_a9) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_a9a1) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_created) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_deleted) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDATEST", "Testing_Cloned");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.REFNUM._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.REFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.REFNUM2.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.NAME._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.NAME.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.DESC2.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.DESC3.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.DESC4.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.DESC5.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.DESC6.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.TOPS.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.TOPS2.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A1.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A2.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A2B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A2C.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A3.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A3B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A4.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A4B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A5.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A5B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A6.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A6B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A6C.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A6DTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A6D.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask) == false && DateTimeUtil.isNowPlaceholder(_a6d) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A7.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A7B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A8.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A8BTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A8B.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask) == false && DateTimeUtil.isNowPlaceholder(_a8b) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A9TZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A9.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask) == false && DateTimeUtil.isNowPlaceholder(_a9) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__TESTING_CLONED_Factory.COLS.A9.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A9A1.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask) == false && DateTimeUtil.isNowPlaceholder(_a9a1) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__TESTING_CLONED_Factory.COLS.A9A1.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION); }          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A9BTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A9B.getFullColumnVarForInsert(C, S);
             V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A9C.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask) == false && DateTimeUtil.isNowPlaceholder(_a9c) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A9D.getFullColumnVarForInsert(C, S);
             V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A10A.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A10B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A10C.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A11.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A11B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A11C.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A12.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A12B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A13.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.A13B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__TESTING_CLONED_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask) == true) { TILDA__TESTING_CLONED_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDATEST", "Testing_Cloned"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.REFNUM._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.REFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.REFNUM2.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.NAME._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.NAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.DESC2.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.DESC3.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.DESC4.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.DESC5.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.DESC6.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.TOPS.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.TOPS2.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A1.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A2.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A2B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A2C.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A3.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A3B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A4.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A4B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A5.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A5B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A6.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A6B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A6C.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A6DTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask) == false && DateTimeUtil.isNowPlaceholder(_a6d) == true)
              { TILDA__TESTING_CLONED_Factory.COLS.A6D.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING_CLONED_Factory.COLS.A6D.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A7.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A7B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A8.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A8BTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask) == false && DateTimeUtil.isNowPlaceholder(_a8b) == true)
              { TILDA__TESTING_CLONED_Factory.COLS.A8B.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING_CLONED_Factory.COLS.A8B.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A9TZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask) == false && DateTimeUtil.isNowPlaceholder(_a9) == true)
              { TILDA__TESTING_CLONED_Factory.COLS.A9.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING_CLONED_Factory.COLS.A9.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask) == false && DateTimeUtil.isNowPlaceholder(_a9a1) == true)
              { TILDA__TESTING_CLONED_Factory.COLS.A9A1.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING_CLONED_Factory.COLS.A9A1.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A9BTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask) == true)
           {
              TILDA__TESTING_CLONED_Factory.COLS.A9B.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask) == false && DateTimeUtil.isNowPlaceholder(_a9c) == true)
              { TILDA__TESTING_CLONED_Factory.COLS.A9C.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING_CLONED_Factory.COLS.A9C.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask) == true)
           {
              TILDA__TESTING_CLONED_Factory.COLS.A9D.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A10A.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A10B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A10C.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A11.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A11B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A11C.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A12.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A12B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A13.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask) == true) TILDA__TESTING_CLONED_Factory.COLS.A13B.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__TESTING_CLONED_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING_CLONED_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__TESTING_CLONED_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING_CLONED_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0:
                S.append(" where ("); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "refnum"); S.append("=?)");
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
       QueryDetails.setLastQuery(TILDA__TESTING_CLONED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATEST.Testing_Cloned", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.REFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.REFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _refnum);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.BIGINT    ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Type, AllocatedArrays, _refnum2);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.NAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.NAME._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _name);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _description);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _desc2);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _desc3);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _desc4);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _desc5);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _desc6);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.CHAR      ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.TOPS._Type, AllocatedArrays, _tops);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.CHAR      ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Type, AllocatedArrays, _tops2);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setInt       (++i, _a1);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, ""+_a2);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.CHAR      ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A2B._Type, AllocatedArrays, _a2b);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.CHAR      ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A2C._Type, AllocatedArrays, _a2c);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask) == true) PS.setNull(++i, java.sql.Types.BOOLEAN   ); else PS.setBoolean   (++i, _a3);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.BOOLEAN   ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A3B._Type, AllocatedArrays, _a3b);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask) == true) PS.setNull(++i, java.sql.Types.DOUBLE    ); else PS.setDouble    (++i, _a4);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.DOUBLE    ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A4B._Type, AllocatedArrays, _a4b);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask) == true) PS.setNull(++i, java.sql.Types.FLOAT     ); else PS.setFloat     (++i, _a5);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.FLOAT     ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A5B._Type, AllocatedArrays, _a5b);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _a6);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.BIGINT    ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A6B._Type, AllocatedArrays, _a6b);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.BIGINT    ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A6C._Type, AllocatedArrays, _a6c);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _a6dTZ);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_a6d) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_a6d.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _a7);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.INTEGER   ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A7B._Type, AllocatedArrays, _a7b);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask) == true) PS.setNull(++i, java.sql.Types.BINARY    ); else PS.setBytes     (++i, _a8);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _a8bTZ);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_a8b) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_a8b.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _a9TZ);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_a9) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_a9.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _a9a1TZ);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_a9a1) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_a9a1.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.CHAR      ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Type, AllocatedArrays, _a9bTZ);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A9B._Type, AllocatedArrays, DateTimeUtil.toSQLTimeStamps(_a9b));
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask) == true) PS.setNull(++i, java.sql.Types.DATE); else if (DateTimeUtil.isNowPlaceholder(_a9c) == false)  PS.setDate(++i, java.sql.Date.valueOf(_a9c));
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.DATE); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A9D._Type, AllocatedArrays, _a9d);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _a10a);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _a10b);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _a10c);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask) == true) PS.setNull(++i, java.sql.Types.NUMERIC   ); else PS.setBigDecimal(++i, _a11);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.NUMERIC   ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A11B._Type, AllocatedArrays, _a11b);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask) == true) PS.setNull(++i, java.sql.Types.NUMERIC   ); else PS.setBigDecimal(++i, _a11c);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask) == true) PS.setNull(++i, java.sql.Types.SMALLINT  ); else PS.setShort     (++i, _a12);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.SMALLINT  ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A12B._Type, AllocatedArrays, _a12b);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask) == true) PS.setNull(++i, java.sql.Types.OTHER     ); else PS.setObject    (++i, _a13, java.sql.Types.OTHER     );
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.OTHER     ); else C.setArray(PS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A13B._Type, AllocatedArrays, _a13b);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_created.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_lastUpdated.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_deleted.toInstant()), DateTimeUtil._UTC_CALENDAR);
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
             __Saved_refnum      = _refnum     ;
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
        }

       __Changes.clear();
       __Nulls.clear();
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
        throw new Exception("This TILDATEST.Testing_Cloned object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATEST.Testing_Cloned object has already been read.");
          QueryDetails.setLastQuery(TILDA__TESTING_CLONED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "refnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "refnum2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "name");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "description");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "desc2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "desc3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "desc4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "desc5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "desc6");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "tops");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "tops2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a1");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a2b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a2c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a3b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a4b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a5b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a6");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a6b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a6c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a6dTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a6d");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a7");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a7b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a8");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a8bTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a8b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a9TZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a9");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a9a1TZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a9a1");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a9bTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a9b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a9c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a9d");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a10a");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a10b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a10c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a11");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a11b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a11c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a12");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a12b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a13");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "a13b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "created");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "deleted");
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "Testing_Cloned");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDATEST", "Testing_Cloned", "refnum"); S.append("=?)");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TESTING_CLONED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATEST.Testing_Cloned", Q, toString());
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
               PS.setLong      (++i, _refnum     );
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
          tilda.data_test._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TESTING_CLONED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }
    }

   @SuppressWarnings("unchecked")
   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_refnum      = _refnum      =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.REFNUM._Mask     );
                            _refnum2 = (List<Long>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.REFNUM2._Mask    );
                            _name        = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.NAME._Mask       );
                            _description = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask);
                            _desc2       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask      );
                            _desc3       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask      );
                            _desc4       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask      );
                            _desc5       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask      );
                            _desc6       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask      );
                            _tops = (List<String>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.TOPS._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask       );
                            _tops2 = (Set<String>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Type, true); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask      );
                            _a1          =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask         );
                            _a2          = ParseUtil.parseCharacter    (RS.getString    (++i));  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask         );
                            _a2b = (List<Character>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A2B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask        );
                            _a2c = (Set<Character>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A2C._Type, true); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask        );
                            _a3          =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask         );
                            _a3b = (List<Boolean>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A3B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask        );
                            _a4          =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask         );
                            _a4b = (List<Double>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A4B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask        );
                            _a5          =                              RS.getFloat     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask         );
                            _a5b = (List<Float>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A5B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask        );
                            _a6          =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask         );
                            _a6b = (List<Long>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A6B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask        );
                            _a6c = (Set<Long>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A6C._Type, true); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask        );
                            _a6dTZ       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A6DTZ._Mask      ); else _a6dTZ       = _a6dTZ      .trim();
                            _a6d         = processZDT(_a6dTZ        , "tilda.data_test.TILDATEST.Testing_Cloned.a6d"        , RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A6D        , TILDA__TESTING_CLONED_Factory.COLS.A6DTZ        ); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask        );
                            _a7          =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask         );
                            _a7b = (List<Integer>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A7B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask        );
                            _a8          =                              RS.getBytes     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask         );
                            _a8bTZ       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A8BTZ._Mask      ); else _a8bTZ       = _a8bTZ      .trim();
                            _a8b         = processZDT(_a8bTZ        , "tilda.data_test.TILDATEST.Testing_Cloned.a8b"        , RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A8B        , TILDA__TESTING_CLONED_Factory.COLS.A8BTZ        ); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask        );
                            _a9TZ        = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9TZ._Mask       ); else _a9TZ        = _a9TZ       .trim();
                            _a9          = processZDT(_a9TZ         , "tilda.data_test.TILDATEST.Testing_Cloned.a9"         , RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A9         , TILDA__TESTING_CLONED_Factory.COLS.A9TZ         ); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask         );
                            _a9a1TZ      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ._Mask     ); else _a9a1TZ      = _a9a1TZ     .trim();
                            _a9a1        = processZDT(_a9a1TZ       , "tilda.data_test.TILDATEST.Testing_Cloned.a9a1"       , RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A9A1       , TILDA__TESTING_CLONED_Factory.COLS.A9A1TZ       ); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask       );
                            _a9bTZ = (List<String>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9BTZ._Mask      );
                            _a9b         = processZDTs(C, _a9bTZ        , "tilda.data_test.TILDATEST.Testing_Cloned.a9b"        , RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A9B        , TILDA__TESTING_CLONED_Factory.COLS.A9BTZ        ); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask        );
                            _a9c         = DateTimeUtil.toLocalDate(RS.getDate(++i)); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask        );
                            _a9d         = DateTimeUtil.toLocalDates((List<java.sql.Date>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A9D._Type, false)); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask        );
                            _a10a        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask       );
                            _a10b        = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask       );
                            _a10c        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask       );
                            _a11         =                              RS.getBigDecimal(++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask        );
                            _a11b = (List<BigDecimal>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A11B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask       );
                            _a11c        =                              RS.getBigDecimal(++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask       );
                            _a12         =                              RS.getShort     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask        );
                            _a12b = (List<Short>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A12B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask       );
                            _a13         =                              (java.util.UUID) RS.getObject(++i);  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask        );
                            _a13b = (List<UUID>) C.getArray(RS, ++i, TILDA__TESTING_CLONED_Factory.COLS.A13B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask       );
                            _created     = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.CREATED._Mask    );
                            _lastUpdated = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.LASTUPDATED._Mask);
                            _deleted     = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask    );
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
  private final List<ZonedDateTime> processZDTs(Connection C, List<String> TimezoneIds, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)
  throws Exception
   {
     List<Timestamp> L = (List<Timestamp>) C.getArray(RS, ColumnPos, DTField._Type, false);
     boolean DTNull = false;
     if (RS.wasNull() == true)
      {
         __Nulls.or(DTField._Mask);
         DTNull = true;
      }
     boolean TZNull = __Nulls.intersects(TZField._Mask);
     if (DTNull == false && TZNull == true)
      throw new Exception("The field "+DTFieldName+" is not null while its associated timezone field '"+DTFieldName+"TZ' is null. A TZ is mandatory for not null timestamps.");
     if (DTNull == true)
      return null;

     List<ZonedDateTime> ZDTs = new ArrayList<ZonedDateTime>();
     for (int i = 0; i < TimezoneIds.size(); ++i)
       {
         String TimezoneId = TimezoneIds.get(i);
         tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(TimezoneId);
         if (ZI == null && TextUtil.isNullOrEmpty(TimezoneId) == false)
          throw new Exception("Cannot set field '"+DTFieldName+"' because the timezone Id '" + TimezoneId + "' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
         ZonedDateTime ZDT = DateTimeUtil.toZonedDateTime(L.get(i), ZI == null ? "null" : ZI.getValue());
         ZDTs.add(ZDT);
       }
     return ZDTs;
   }

   protected abstract boolean afterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "refnum: "                                                                                                  +                                   getRefnum     () 
               + "; refnum2: "                                                                                                 + TextUtil.print                   (getRefnum2    ())
               + "; name: "                                                                                                    + TextUtil.printVariableStr        (getName       ())
               + "; description"   + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESCRIPTION._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDescription()))
               + "; desc2"         + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC2._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc2      ()))
               + "; desc3"         + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC3._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc3      ()))
               + "; desc4"         + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC4._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc4      ()))
               + "; desc5"         + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC5._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc5      ()))
               + "; desc6"         + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DESC6._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc6      ()))
               + "; tops"          + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getTops       ()))
               + "; tops2"         + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.TOPS2._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getTops2      ()))
               + "; a1"            + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A1._Mask) == true ? ": NULL" : ": " +                                   getA1         () )
               + "; a2"            + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2._Mask) == true ? ": NULL" : ": " +                                   getA2         () )
               + "; a2b"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA2b        ()))
               + "; a2c"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A2C._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA2c        ()))
               + "; a3"            + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3._Mask) == true ? ": NULL" : ": " +                                   getA3         () )
               + "; a3b"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A3B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA3b        ()))
               + "; a4"            + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4._Mask) == true ? ": NULL" : ": " +                                   getA4         () )
               + "; a4b"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A4B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA4b        ()))
               + "; a5"            + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5._Mask) == true ? ": NULL" : ": " +                                   getA5         () )
               + "; a5b"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A5B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA5b        ()))
               + "; a6"            + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6._Mask) == true ? ": NULL" : ": " +                                   getA6         () )
               + "; a6b"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA6b        ()))
               + "; a6c"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6C._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA6c        ()))
               + "; a6d"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A6D._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getA6d        ()))
               + "; a7"            + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7._Mask) == true ? ": NULL" : ": " +                                   getA7         () )
               + "; a7b"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A7B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA7b        ()))
               + "; a8"            + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8._Mask) == true ? ": NULL" : ": " +                                   getA8         () )
               + "; a8b"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A8B._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getA8b        ()))
               + "; a9"            + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getA9         ()))
               + "; a9a1"          + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9A1._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getA9a1       ()))
               + "; a9b"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA9b        ()))
               + "; a9c"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9C._Mask) == true ? ": NULL" : ": " +                                   getA9c        () )
               + "; a9d"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A9D._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA9d        ()))
               + "; a10a"          + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10A._Mask) == true ? ": NULL" : ": " +                                   getA10a       () )
               + "; a10b"          + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10B._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getA10b       ()))
               + "; a10c"          + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A10C._Mask) == true ? ": NULL" : ": " +                                   getA10c       () )
               + "; a11"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11._Mask) == true ? ": NULL" : ": " +                                   getA11        () )
               + "; a11b"          + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA11b       ()))
               + "; a11c"          + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A11C._Mask) == true ? ": NULL" : ": " +                                   getA11c       () )
               + "; a12"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12._Mask) == true ? ": NULL" : ": " +                                   getA12        () )
               + "; a12b"          + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A12B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA12b       ()))
               + "; a13"           + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13._Mask) == true ? ": NULL" : ": " +                                   getA13        () )
               + "; a13b"          + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.A13B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA13b       ()))
               + "; created: "                                                                                                 + DateTimeUtil.printDateTimeForJSON(getCreated    ())
               + "; lastUpdated: "                                                                                             + DateTimeUtil.printDateTimeForJSON(getLastUpdated())
               + "; deleted"       + (__Nulls.intersects(TILDA__TESTING_CLONED_Factory.COLS.DELETED._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDeleted    ()))
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
      toJSON(out, exportName, "", fullObject, false);
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, boolean noNullArrays) throws Exception
    {
      switch (exportName)
        { 
          case "CCC": tilda.data_test.Testing_Cloned_Factory.toJSONCCC(out, (tilda.data_test.Testing_Cloned_Data) this, lead, fullObject, noNullArrays); break;
          case "AAA": tilda.data_test.Testing_Cloned_Factory.toJSONAAA(out, (tilda.data_test.Testing_Cloned_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data_test.Testing_Cloned_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data_test.Testing_Cloned_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "CCC": tilda.data_test.Testing_Cloned_Factory.toCSVCCC(out, (tilda.data_test.Testing_Cloned_Data) this); break;
          case "BBB": tilda.data_test.Testing_Cloned_Factory.toCSVBBB(out, (tilda.data_test.Testing_Cloned_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data_test.Testing_Cloned_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data_test.Testing_Cloned_Factory");
    }
 }
