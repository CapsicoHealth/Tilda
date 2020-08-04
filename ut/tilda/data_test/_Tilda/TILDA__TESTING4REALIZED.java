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
<TABLE id="Testing4Realized_DIV" class="tables">
<SCRIPT>registerStickyHeader("Testing4Realized_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Testing4Realized&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Testing4Realized_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Testing4Realized_CNT" class="content">
The Table TILDATEST.Testing4Realized:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Testing4Realized_Factory</B>, <B>Testing4Realized_Data</B> in the package <B>tilda.data_test</B>.
<LI>Is Realized from <B><A href="TILDA___Docs.TILDATEST.html#Testing4View_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing4View</A></B> through DB function <B>TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Refill_Testing4Realized()</B>.</LI>
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Has the following identity:<UL><LI>Unique Index: refnum</LI>
</UL></LI>
</UL>
<B>Description</B>: Realized table for view TILDATEST.Testing4View: A test view to test .* and exclude and block.<BR>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="Testing4Realized_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-refnum_DIV' class='columns'>refnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record (from TILDATEST.Testing4View.refnum)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-name_DIV' class='columns'>name</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Medical system unique enterprise id (from TILDATEST.Testing4View.name)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a1_DIV' class='columns'>a1</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;INTEGER&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a1)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a3b_DIV' class='columns'>a3b</B>&nbsp;&nbsp;</TD>
<TD>List<Boolean> List<>&nbsp;/&nbsp;boolean[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a3b)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a4_DIV' class='columns'>a4</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a4)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a4b_DIV' class='columns'>a4b</B>&nbsp;&nbsp;</TD>
<TD>List<Double> List<>&nbsp;/&nbsp;double precision[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a4b)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a5_DIV' class='columns'>a5</B>&nbsp;&nbsp;</TD>
<TD>float&nbsp;/&nbsp;real&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a5)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a5b_DIV' class='columns'>a5b</B>&nbsp;&nbsp;</TD>
<TD>List<Float> List<>&nbsp;/&nbsp;real[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a5b)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a7_DIV' class='columns'>a7</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a7)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a7b_DIV' class='columns'>a7b</B>&nbsp;&nbsp;</TD>
<TD>List<Integer> List<>&nbsp;/&nbsp;integer[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a7b)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a8_DIV' class='columns'>a8</B>&nbsp;&nbsp;</TD>
<TD>byte[]&nbsp;/&nbsp;BYTEA&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a8)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a8bTZ_DIV' class='columns'>a8bTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing4View.a8bTZ)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a8b_DIV' class='columns'>a8b</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a8b)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a10a_DIV' class='columns'>a10a</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a10a)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a10b_DIV' class='columns'>a10b</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a10b)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a10c_DIV' class='columns'>a10c</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a10c)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a11_DIV' class='columns'>a11</B>&nbsp;&nbsp;</TD>
<TD>BigDecimal&nbsp;/&nbsp;numeric(8,4)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a11)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a11b_DIV' class='columns'>a11b</B>&nbsp;&nbsp;</TD>
<TD>List<BigDecimal> List<>&nbsp;/&nbsp;numeric(6,3)[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a11b)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a11c_DIV' class='columns'>a11c</B>&nbsp;&nbsp;</TD>
<TD>BigDecimal&nbsp;/&nbsp;numeric(5,0)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a11c)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>20&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a12_DIV' class='columns'>a12</B>&nbsp;&nbsp;</TD>
<TD>short&nbsp;/&nbsp;smallint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a12)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>21&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a12b_DIV' class='columns'>a12b</B>&nbsp;&nbsp;</TD>
<TD>List<Short> List<>&nbsp;/&nbsp;smallint[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a12b)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>22&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a13_DIV' class='columns'>a13</B>&nbsp;&nbsp;</TD>
<TD>UUID&nbsp;/&nbsp;UUID&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a13)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>23&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a13b_DIV' class='columns'>a13b</B>&nbsp;&nbsp;</TD>
<TD>List<UUID> List<>&nbsp;/&nbsp;UUID[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah (from TILDATEST.Testing4View.a13b)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>24&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-description_DIV' class='columns'>description</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.description)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>25&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc2_DIV' class='columns'>desc2</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(3000)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc2)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>26&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc3_DIV' class='columns'>desc3</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc3)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>27&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc4_DIV' class='columns'>desc4</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc4)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>28&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc5_DIV' class='columns'>desc5</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc5)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>29&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc6_DIV' class='columns'>desc6</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">SMART&nbsp;&nbsp;</TD>
<TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc6)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>30&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-bastille_DIV' class='columns'>bastille</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-bastille_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>bastille</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>31&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-toto_DIV' class='columns'>toto</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-toto_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>toto</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>32&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc2_Cat1_DIV' class='columns'>desc2_Cat1</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing4View.desc2_Cat1)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-desc2_Cat1_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>desc2_Cat1</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>33&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc2_Cat2_DIV' class='columns'>desc2_Cat2</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing4View.desc2_Cat2)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-desc2_Cat2_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>desc2_Cat2</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>34&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-desc2_Cat3_DIV' class='columns'>desc2_Cat3</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing4View.desc2_Cat3)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-desc2_Cat3_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>desc2_Cat3</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>35&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a7_Cat4_DIV' class='columns'>a7_Cat4</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing4View.a7_Cat4)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-a7_Cat4_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a7_Cat4</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>36&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a7_Cat5_DIV' class='columns'>a7_Cat5</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing4View.a7_Cat5)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-a7_Cat5_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a7_Cat5</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>37&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a5_null_DIV' class='columns'>a5_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a5</B>' (from TILDATEST.Testing4View.a5_null)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-a5_null_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a5_null</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>38&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a6_null_DIV' class='columns'>a6_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a6</B>' (from TILDATEST.Testing4View.a6_null)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-a6_null_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a6_null</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>39&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a7_null_DIV' class='columns'>a7_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a7</B>' (from TILDATEST.Testing4View.a7_null)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-a7_null_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a7_null</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>40&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a8_null_DIV' class='columns'>a8_null</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Null a8</B>' (from TILDATEST.Testing4View.a8_null)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing2View-a8_null_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing2View<B>&nbsp;&#8226;&nbsp;</B>a8_null</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>41&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-a3_DIV' class='columns'>a3</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.a3)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing4View-a3_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing4View<B>&nbsp;&#8226;&nbsp;</B>a3</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>42&nbsp;&nbsp;</TD>
<TD align="right"><B id='Testing4Realized-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Testing4View-lastUpdated_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Testing4View<B>&nbsp;&#8226;&nbsp;</B>lastUpdated</A></DIV></TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TESTING4REALIZED implements tilda.interfaces.WriterObject
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__TESTING4REALIZED.class.getName());

   public transient static final Class<TILDA__TESTING4REALIZED_Factory> FACTORY_CLASS= TILDA__TESTING4REALIZED_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDATEST.Testing4Realized", "");

   protected TILDA__TESTING4REALIZED() { }

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
//   Field tilda.data_test.TILDATEST.Testing4Realized.refnum -> TILDATEST.Testing4Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATEST.Testing4View.refnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("refnum")
   Long _refnum=null;
   protected Long __Saved_refnum;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.refnum -> TILDATEST.Testing4Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATEST.Testing4View.refnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getRefnum()
      { return _refnum==null?0l:_refnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.refnum -> TILDATEST.Testing4Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATEST.Testing4View.refnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isRefnumNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.refnum -> TILDATEST.Testing4Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATEST.Testing4View.refnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _refnum == null || v != _refnum)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask);
       _refnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.refnum -> TILDATEST.Testing4Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATEST.Testing4View.refnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setRefnumNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask);
       _refnum=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.refnum -> TILDATEST.Testing4Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATEST.Testing4View.refnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedRefnum()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.name -> TILDATEST.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id (from TILDATEST.Testing4View.name)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("name")
   String _name=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.name -> TILDATEST.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id (from TILDATEST.Testing4View.name)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getName()
      { return _name; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.name -> TILDATEST.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id (from TILDATEST.Testing4View.name)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNameNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.name -> TILDATEST.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id (from TILDATEST.Testing4View.name)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNameNull();
        }
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing4Realized.name: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_name) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask);
       _name = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.name -> TILDATEST.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id (from TILDATEST.Testing4View.name)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNameNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.name -> TILDATEST.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id (from TILDATEST.Testing4View.name)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedName()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a1 -> TILDATEST.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a1")
   Integer _a1=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a1 -> TILDATEST.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA1()
      { return _a1; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a1 -> TILDATEST.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA1Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a1 -> TILDATEST.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a1)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask);
       _a1 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a1 -> TILDATEST.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA1Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask);
       _a1=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a1 -> TILDATEST.Testing4Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA1()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3b -> TILDATEST.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a3b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a3b")
   List<Boolean> _a3b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3b -> TILDATEST.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a3b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3b -> TILDATEST.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a3b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA3bNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3b -> TILDATEST.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a3b)</TD></TR>
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
   public void addToA3b(int pos, boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a3b == null)
        _a3b = new ArrayList<Boolean>();
       if (pos >= _a3b.size() || _a3b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
          _a3b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA3b(Boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a3b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA3b(int pos) throws Exception
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3b -> TILDATEST.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a3b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA3bNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3b -> TILDATEST.Testing4Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a3b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA3b()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4 -> TILDATEST.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a4")
   Double _a4=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4 -> TILDATEST.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getA4()
      { return _a4==null?0d:_a4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4 -> TILDATEST.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA4Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4 -> TILDATEST.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask);
       _a4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4 -> TILDATEST.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA4Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask);
       _a4=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4 -> TILDATEST.Testing4Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA4()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4b -> TILDATEST.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a4b")
   List<Double> _a4b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4b -> TILDATEST.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4b -> TILDATEST.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA4bNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4b -> TILDATEST.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4b)</TD></TR>
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
   public void addToA4b(int pos, double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a4b == null)
        _a4b = new ArrayList<Double>();
       if (pos >= _a4b.size() || _a4b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
          _a4b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA4b(Double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a4b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA4b(int pos) throws Exception
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4b -> TILDATEST.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA4bNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a4b -> TILDATEST.Testing4Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a4b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA4b()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5 -> TILDATEST.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a5")
   Float _a5=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5 -> TILDATEST.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final float getA5()
      { return _a5==null?0f:_a5; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5 -> TILDATEST.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA5Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5 -> TILDATEST.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask);
       _a5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5 -> TILDATEST.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA5Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask);
       _a5=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5 -> TILDATEST.Testing4Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA5()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5b -> TILDATEST.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a5b")
   List<Float> _a5b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5b -> TILDATEST.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5b -> TILDATEST.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA5bNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5b -> TILDATEST.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5b)</TD></TR>
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
   public void addToA5b(int pos, float v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a5b == null)
        _a5b = new ArrayList<Float>();
       if (pos >= _a5b.size() || _a5b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
          _a5b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA5b(Float v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a5b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA5b(int pos) throws Exception
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5b -> TILDATEST.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA5bNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5b -> TILDATEST.Testing4Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a5b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA5b()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7 -> TILDATEST.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a7")
   Integer _a7=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7 -> TILDATEST.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA7()
      { return _a7==null?0:_a7; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7 -> TILDATEST.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7 -> TILDATEST.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask);
       _a7 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7 -> TILDATEST.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA7Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask);
       _a7=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7 -> TILDATEST.Testing4Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA7()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7b -> TILDATEST.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a7b")
   List<Integer> _a7b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7b -> TILDATEST.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7b -> TILDATEST.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7bNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7b -> TILDATEST.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7b)</TD></TR>
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
   public void addToA7b(int pos, int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a7b == null)
        _a7b = new ArrayList<Integer>();
       if (pos >= _a7b.size() || _a7b.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
          _a7b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA7b(Integer v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a7b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA7b(int pos) throws Exception
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7b -> TILDATEST.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA7bNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7b -> TILDATEST.Testing4Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a7b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA7b()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8 -> TILDATEST.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a8")
   byte[] _a8=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8 -> TILDATEST.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final byte[] getA8()
      { return _a8; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8 -> TILDATEST.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8 -> TILDATEST.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA8(byte[] v) throws Exception
     {
       long T0 = System.nanoTime();
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask);
       _a8 = v;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8 -> TILDATEST.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA8Null()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8 -> TILDATEST.Testing4Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA8()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8bTZ -> TILDATEST.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing4View.a8bTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _a8bTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8bTZ -> TILDATEST.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing4View.a8bTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getA8bTZ()
      { return _a8bTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8bTZ -> TILDATEST.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing4View.a8bTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8bTZNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8bTZ -> TILDATEST.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing4View.a8bTZ)</TD></TR>
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
          setA8bTZNull();
        }
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing4Realized.a8bTZ: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_a8bTZ) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask);
       _a8bTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8bTZ -> TILDATEST.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing4View.a8bTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8bTZNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8bTZ -> TILDATEST.Testing4Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing4View.a8bTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA8bTZ()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8b -> TILDATEST.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8b -> TILDATEST.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getA8b()
      { return _a8b; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8b -> TILDATEST.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8bNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8b -> TILDATEST.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8b)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask);
       _a8b = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing4Realized.a8b' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA8bTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8b -> TILDATEST.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA8bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask);
       _a8b=null;
       setA8bTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8b -> TILDATEST.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8b -> TILDATEST.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8b -> TILDATEST.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8b -> TILDATEST.Testing4Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a8b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA8b()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10a -> TILDATEST.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10a)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a10a")
   Integer _a10a=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10a -> TILDATEST.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10a)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA10a()
      { return _a10a==null?0:_a10a; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10a -> TILDATEST.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10a)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA10aNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10a -> TILDATEST.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10a)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask);
       _a10a = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10a -> TILDATEST.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10a)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA10aNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask);
       _a10a=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10a -> TILDATEST.Testing4Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10a)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA10a()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10b -> TILDATEST.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a10b")
   String _a10b=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10b -> TILDATEST.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getA10b()
      { return _a10b; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10b -> TILDATEST.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA10bNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10b -> TILDATEST.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10b)</TD></TR>
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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing4Realized.a10b: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_a10b) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask);
       _a10b = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10b -> TILDATEST.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA10bNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10b -> TILDATEST.Testing4Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA10b()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10c -> TILDATEST.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a10c")
   Integer _a10c=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10c -> TILDATEST.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA10c()
      { return _a10c==null?0:_a10c; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10c -> TILDATEST.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA10cNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10c -> TILDATEST.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10c)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask);
       _a10c = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10c -> TILDATEST.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA10cNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask);
       _a10c=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a10c -> TILDATEST.Testing4Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a10c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA10c()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11 -> TILDATEST.Testing4Realized."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a11")
   BigDecimal _a11=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11 -> TILDATEST.Testing4Realized."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final BigDecimal getA11()
      { return _a11; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11 -> TILDATEST.Testing4Realized."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA11Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11 -> TILDATEST.Testing4Realized."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask);
       _a11 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11 -> TILDATEST.Testing4Realized."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA11Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask);
       _a11=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11 -> TILDATEST.Testing4Realized."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA11()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11b -> TILDATEST.Testing4Realized."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a11b")
   List<BigDecimal> _a11b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11b -> TILDATEST.Testing4Realized."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11b -> TILDATEST.Testing4Realized."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA11bNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11b -> TILDATEST.Testing4Realized."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11b)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask);
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask);
          _a11b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA11b(BigDecimal v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a11b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA11b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a11b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11b -> TILDATEST.Testing4Realized."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA11bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask);
       _a11b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11b -> TILDATEST.Testing4Realized."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA11b()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11c -> TILDATEST.Testing4Realized."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a11c")
   BigDecimal _a11c=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11c -> TILDATEST.Testing4Realized."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final BigDecimal getA11c()
      { return _a11c; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11c -> TILDATEST.Testing4Realized."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA11cNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11c -> TILDATEST.Testing4Realized."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11c)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask);
       _a11c = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11c -> TILDATEST.Testing4Realized."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA11cNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask);
       _a11c=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a11c -> TILDATEST.Testing4Realized."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a11c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA11c()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12 -> TILDATEST.Testing4Realized."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a12")
   Short _a12=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12 -> TILDATEST.Testing4Realized."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final short getA12()
      { return _a12==null?0:_a12; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12 -> TILDATEST.Testing4Realized."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA12Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12 -> TILDATEST.Testing4Realized."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask);
       _a12 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12 -> TILDATEST.Testing4Realized."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA12Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask);
       _a12=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12 -> TILDATEST.Testing4Realized."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA12()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12b -> TILDATEST.Testing4Realized."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a12b")
   List<Short> _a12b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12b -> TILDATEST.Testing4Realized."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12b -> TILDATEST.Testing4Realized."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA12bNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12b -> TILDATEST.Testing4Realized."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12b)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask);
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask);
          _a12b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA12b(Short v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a12b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA12b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a12b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12b -> TILDATEST.Testing4Realized."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA12bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask);
       _a12b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a12b -> TILDATEST.Testing4Realized."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a12b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA12b()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13 -> TILDATEST.Testing4Realized."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a13")
   UUID _a13=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13 -> TILDATEST.Testing4Realized."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final UUID getA13()
      { return _a13; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13 -> TILDATEST.Testing4Realized."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA13Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13 -> TILDATEST.Testing4Realized."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask);
       _a13 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13 -> TILDATEST.Testing4Realized."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA13Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask);
       _a13=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13 -> TILDATEST.Testing4Realized."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA13()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13b -> TILDATEST.Testing4Realized."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a13b")
   List<UUID> _a13b;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13b -> TILDATEST.Testing4Realized."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13b)</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13b -> TILDATEST.Testing4Realized."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA13bNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13b -> TILDATEST.Testing4Realized."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13b)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask);
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask);
          _a13b.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA13b(UUID v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a13b.remove(v) == true)
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromA13b(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a13b.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13b -> TILDATEST.Testing4Realized."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA13bNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask);
       _a13b=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a13b -> TILDATEST.Testing4Realized."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing4View.a13b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA13b()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.description -> TILDATEST.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.description)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("description")
   String _description=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.description -> TILDATEST.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.description)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDescription()
      { return _description; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.description -> TILDATEST.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.description)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDescriptionNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.description -> TILDATEST.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.description)</TD></TR>
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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing4Realized.description: the size "+v.length()+" is larger than the max allowed of 250: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_description) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask);
       _description = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.description -> TILDATEST.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.description)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDescriptionNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.description -> TILDATEST.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.description)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDescription()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2 -> TILDATEST.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("desc2")
   String _desc2=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2 -> TILDATEST.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDesc2()
      { return _desc2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2 -> TILDATEST.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc2Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2 -> TILDATEST.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc2)</TD></TR>
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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing4Realized.desc2: the size "+v.length()+" is larger than the max allowed of 3000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc2) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask);
       _desc2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2 -> TILDATEST.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc2Null()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2 -> TILDATEST.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc2()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc3 -> TILDATEST.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("desc3")
   String _desc3=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc3 -> TILDATEST.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDesc3()
      { return _desc3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc3 -> TILDATEST.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc3Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc3 -> TILDATEST.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc3)</TD></TR>
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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing4Realized.desc3: the size "+v.length()+" is larger than the max allowed of 5000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc3) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask);
       _desc3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc3 -> TILDATEST.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc3Null()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc3 -> TILDATEST.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc3()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc4 -> TILDATEST.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("desc4")
   String _desc4=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc4 -> TILDATEST.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDesc4()
      { return _desc4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc4 -> TILDATEST.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc4Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc4 -> TILDATEST.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc4)</TD></TR>
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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing4Realized.desc4: the size "+v.length()+" is larger than the max allowed of 9000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc4) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask);
       _desc4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc4 -> TILDATEST.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc4Null()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc4 -> TILDATEST.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc4()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc5 -> TILDATEST.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("desc5")
   String _desc5=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc5 -> TILDATEST.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDesc5()
      { return _desc5; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc5 -> TILDATEST.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc5Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc5 -> TILDATEST.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc5)</TD></TR>
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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing4Realized.desc5: the size "+v.length()+" is larger than the max allowed of 17000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc5) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask);
       _desc5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc5 -> TILDATEST.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDesc5Null()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc5 -> TILDATEST.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc5()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc6 -> TILDATEST.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc6)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
</TABLE>
*/
   @SerializedName("desc6")
   String _desc6=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc6 -> TILDATEST.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc6)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
</TABLE>
*/
   public final String getDesc6()
      { return _desc6; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc6 -> TILDATEST.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc6)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
</TABLE>
*/
   public final boolean isDesc6Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc6 -> TILDATEST.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc6)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Testing4Realized.desc6: the size "+v.length()+" is larger than the max allowed of 33000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_desc6) == false)
        {
          v = HTMLFilter.cleanSmart("tilda.data_test.TILDATEST.Testing4Realized.desc6",v);
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask);
       _desc6 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc6 -> TILDATEST.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc6)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
</TABLE>
*/
   public void setDesc6Null()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc6 -> TILDATEST.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing4View.desc6)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc6()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.bastille -> TILDATEST.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _bastille = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.bastille -> TILDATEST.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getBastille()
      { return _bastille; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.bastille -> TILDATEST.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isBastilleNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.bastille -> TILDATEST.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)</TD></TR>
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
          setBastilleNull();
        }
       else if (v.equals(_bastille) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask);
       _bastille = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.bastille -> TILDATEST.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setBastilleNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.bastille -> TILDATEST.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setBastilleNow() throws Exception
    {
      setBastille(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.bastille -> TILDATEST.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setBastilleUndefined() throws Exception
    {
      setBastille(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.bastille -> TILDATEST.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setBastille(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setBastille(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.bastille -> TILDATEST.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing4View.bastille)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedBastille()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.toto -> TILDATEST.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _toto = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.toto -> TILDATEST.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getToto()
      { return _toto; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.toto -> TILDATEST.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTotoNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.toto -> TILDATEST.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)</TD></TR>
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
          setTotoNull();
        }
       else if (v.equals(_toto) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask);
       _toto = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.toto -> TILDATEST.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTotoNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.toto -> TILDATEST.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setTotoNow() throws Exception
    {
      setToto(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.toto -> TILDATEST.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setTotoUndefined() throws Exception
    {
      setToto(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.toto -> TILDATEST.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setToto(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setToto(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.toto -> TILDATEST.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing4View.toto)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedToto()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 -> TILDATEST.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing4View.desc2_Cat1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Double _desc2_Cat1=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 -> TILDATEST.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing4View.desc2_Cat1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getDesc2_Cat1()
      { return _desc2_Cat1==null?0d:_desc2_Cat1; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 -> TILDATEST.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing4View.desc2_Cat1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc2_Cat1Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 -> TILDATEST.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing4View.desc2_Cat1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat1(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _desc2_Cat1 == null || v != _desc2_Cat1)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask);
       _desc2_Cat1 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 -> TILDATEST.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing4View.desc2_Cat1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat1Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask);
       _desc2_Cat1=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 -> TILDATEST.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing4View.desc2_Cat1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc2_Cat1()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 -> TILDATEST.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing4View.desc2_Cat2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Double _desc2_Cat2=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 -> TILDATEST.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing4View.desc2_Cat2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getDesc2_Cat2()
      { return _desc2_Cat2==null?0d:_desc2_Cat2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 -> TILDATEST.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing4View.desc2_Cat2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc2_Cat2Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 -> TILDATEST.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing4View.desc2_Cat2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat2(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _desc2_Cat2 == null || v != _desc2_Cat2)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask);
       _desc2_Cat2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 -> TILDATEST.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing4View.desc2_Cat2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat2Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask);
       _desc2_Cat2=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 -> TILDATEST.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing4View.desc2_Cat2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc2_Cat2()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 -> TILDATEST.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing4View.desc2_Cat3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Double _desc2_Cat3=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 -> TILDATEST.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing4View.desc2_Cat3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getDesc2_Cat3()
      { return _desc2_Cat3==null?0d:_desc2_Cat3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 -> TILDATEST.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing4View.desc2_Cat3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDesc2_Cat3Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 -> TILDATEST.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing4View.desc2_Cat3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat3(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _desc2_Cat3 == null || v != _desc2_Cat3)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask);
       _desc2_Cat3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 -> TILDATEST.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing4View.desc2_Cat3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDesc2_Cat3Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask);
       _desc2_Cat3=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 -> TILDATEST.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing4View.desc2_Cat3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDesc2_Cat3()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 -> TILDATEST.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing4View.a7_Cat4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Double _a7_Cat4=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 -> TILDATEST.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing4View.a7_Cat4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getA7_Cat4()
      { return _a7_Cat4==null?0d:_a7_Cat4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 -> TILDATEST.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing4View.a7_Cat4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7_Cat4Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 -> TILDATEST.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing4View.a7_Cat4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_Cat4(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a7_Cat4 == null || v != _a7_Cat4)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask);
       _a7_Cat4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 -> TILDATEST.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing4View.a7_Cat4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_Cat4Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask);
       _a7_Cat4=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 -> TILDATEST.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing4View.a7_Cat4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA7_Cat4()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 -> TILDATEST.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing4View.a7_Cat5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Double _a7_Cat5=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 -> TILDATEST.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing4View.a7_Cat5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getA7_Cat5()
      { return _a7_Cat5==null?0d:_a7_Cat5; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 -> TILDATEST.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing4View.a7_Cat5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7_Cat5Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 -> TILDATEST.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing4View.a7_Cat5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_Cat5(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a7_Cat5 == null || v != _a7_Cat5)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask);
       _a7_Cat5 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 -> TILDATEST.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing4View.a7_Cat5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_Cat5Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask);
       _a7_Cat5=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 -> TILDATEST.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing4View.a7_Cat5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA7_Cat5()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5_null -> TILDATEST.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>' (from TILDATEST.Testing4View.a5_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Integer _a5_null=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5_null -> TILDATEST.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>' (from TILDATEST.Testing4View.a5_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA5_null()
      { return _a5_null==null?0:_a5_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5_null -> TILDATEST.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>' (from TILDATEST.Testing4View.a5_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA5_nullNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5_null -> TILDATEST.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>' (from TILDATEST.Testing4View.a5_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA5_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a5_null == null || v != _a5_null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask);
       _a5_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5_null -> TILDATEST.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>' (from TILDATEST.Testing4View.a5_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA5_nullNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask);
       _a5_null=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5_null -> TILDATEST.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>' (from TILDATEST.Testing4View.a5_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA5_null()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a6_null -> TILDATEST.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>' (from TILDATEST.Testing4View.a6_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Integer _a6_null=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a6_null -> TILDATEST.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>' (from TILDATEST.Testing4View.a6_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA6_null()
      { return _a6_null==null?0:_a6_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a6_null -> TILDATEST.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>' (from TILDATEST.Testing4View.a6_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA6_nullNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a6_null -> TILDATEST.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>' (from TILDATEST.Testing4View.a6_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA6_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a6_null == null || v != _a6_null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask);
       _a6_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a6_null -> TILDATEST.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>' (from TILDATEST.Testing4View.a6_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA6_nullNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask);
       _a6_null=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a6_null -> TILDATEST.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>' (from TILDATEST.Testing4View.a6_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA6_null()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_null -> TILDATEST.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>' (from TILDATEST.Testing4View.a7_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Integer _a7_null=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_null -> TILDATEST.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>' (from TILDATEST.Testing4View.a7_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA7_null()
      { return _a7_null==null?0:_a7_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_null -> TILDATEST.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>' (from TILDATEST.Testing4View.a7_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA7_nullNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_null -> TILDATEST.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>' (from TILDATEST.Testing4View.a7_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a7_null == null || v != _a7_null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask);
       _a7_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_null -> TILDATEST.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>' (from TILDATEST.Testing4View.a7_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA7_nullNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask);
       _a7_null=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_null -> TILDATEST.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>' (from TILDATEST.Testing4View.a7_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA7_null()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8_null -> TILDATEST.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>' (from TILDATEST.Testing4View.a8_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Integer _a8_null=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8_null -> TILDATEST.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>' (from TILDATEST.Testing4View.a8_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getA8_null()
      { return _a8_null==null?0:_a8_null; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8_null -> TILDATEST.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>' (from TILDATEST.Testing4View.a8_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA8_nullNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8_null -> TILDATEST.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>' (from TILDATEST.Testing4View.a8_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8_null(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _a8_null == null || v != _a8_null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask);
       _a8_null = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8_null -> TILDATEST.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>' (from TILDATEST.Testing4View.a8_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA8_nullNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask);
       _a8_null=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a8_null -> TILDATEST.Testing4Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>' (from TILDATEST.Testing4View.a8_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA8_null()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3 -> TILDATEST.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.a3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("a3")
   Boolean _a3=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3 -> TILDATEST.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.a3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getA3()
      { return _a3==null?false:_a3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3 -> TILDATEST.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.a3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isA3Null()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3 -> TILDATEST.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.a3)</TD></TR>
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
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask);
       _a3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3 -> TILDATEST.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.a3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setA3Null()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask);
       __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask);
       _a3=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3 -> TILDATEST.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.a3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedA3()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.lastUpdated -> TILDATEST.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _lastUpdated = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.lastUpdated -> TILDATEST.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getLastUpdated()
      { return _lastUpdated; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.lastUpdated -> TILDATEST.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isLastUpdatedNull()
     { return __Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.lastUpdated -> TILDATEST.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)</TD></TR>
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
          setLastUpdatedNull();
        }
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.lastUpdated -> TILDATEST.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setLastUpdatedNull()
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.lastUpdated -> TILDATEST.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setLastUpdatedNow() throws Exception
    {
      setLastUpdated(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.lastUpdated -> TILDATEST.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setLastUpdatedUndefined() throws Exception
    {
      setLastUpdated(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.lastUpdated -> TILDATEST.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    final void setLastUpdated(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setLastUpdated(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.lastUpdated -> TILDATEST.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Always True</B>' (from TILDATEST.Testing4View.lastUpdated)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedLastUpdated()
     { return __Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.data_test._Tilda.TILDA__TESTING4REALIZED Dst) throws Exception
     {
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask) == true) Dst.setRefnumNull     (); else        Dst.setRefnum     (_refnum     );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask) == true) Dst.setNameNull       (); else        Dst.setName       (_name       );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask) == true) Dst.setA1Null         (); else        Dst.setA1         (_a1         );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask) == true) Dst.setA3bNull        (); else        Dst.setA3b        (_a3b        );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask) == true) Dst.setA4Null         (); else        Dst.setA4         (_a4         );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask) == true) Dst.setA4bNull        (); else        Dst.setA4b        (_a4b        );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask) == true) Dst.setA5Null         (); else        Dst.setA5         (_a5         );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask) == true) Dst.setA5bNull        (); else        Dst.setA5b        (_a5b        );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask) == true) Dst.setA7Null         (); else        Dst.setA7         (_a7         );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask) == true) Dst.setA7bNull        (); else        Dst.setA7b        (_a7b        );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask) == true) Dst.setA8Null         (); else        Dst.setA8         (_a8         );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask) == true) Dst.setA8bTZNull      (); else        Dst.setA8bTZ      (_a8bTZ      );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == true) Dst.setA8bNull        (); else        Dst.setA8b        (_a8b        );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask) == true) Dst.setA10aNull       (); else        Dst.setA10a       (_a10a       );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask) == true) Dst.setA10bNull       (); else        Dst.setA10b       (_a10b       );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask) == true) Dst.setA10cNull       (); else        Dst.setA10c       (_a10c       );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask) == true) Dst.setA11Null        (); else        Dst.setA11        (_a11        );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask) == true) Dst.setA11bNull       (); else        Dst.setA11b       (_a11b       );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask) == true) Dst.setA11cNull       (); else        Dst.setA11c       (_a11c       );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask) == true) Dst.setA12Null        (); else        Dst.setA12        (_a12        );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask) == true) Dst.setA12bNull       (); else        Dst.setA12b       (_a12b       );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask) == true) Dst.setA13Null        (); else        Dst.setA13        (_a13        );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask) == true) Dst.setA13bNull       (); else        Dst.setA13b       (_a13b       );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask) == true) Dst.setDescriptionNull(); else        Dst.setDescription(_description);
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask) == true) Dst.setDesc2Null      (); else        Dst.setDesc2      (_desc2      );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask) == true) Dst.setDesc3Null      (); else        Dst.setDesc3      (_desc3      );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask) == true) Dst.setDesc4Null      (); else        Dst.setDesc4      (_desc4      );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask) == true) Dst.setDesc5Null      (); else        Dst.setDesc5      (_desc5      );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask) == true) Dst.setDesc6Null      (); else        Dst.setDesc6      (_desc6      );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask) == true) Dst.setBastilleNull   (); else        Dst.setBastille   (_bastille   );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask) == true) Dst.setTotoNull       (); else        Dst.setToto       (_toto       );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask) == true) Dst.setDesc2_Cat1Null (); else        Dst.setDesc2_Cat1 (_desc2_Cat1 );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask) == true) Dst.setDesc2_Cat2Null (); else        Dst.setDesc2_Cat2 (_desc2_Cat2 );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask) == true) Dst.setDesc2_Cat3Null (); else        Dst.setDesc2_Cat3 (_desc2_Cat3 );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask) == true) Dst.setA7_Cat4Null    (); else        Dst.setA7_Cat4    (_a7_Cat4    );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask) == true) Dst.setA7_Cat5Null    (); else        Dst.setA7_Cat5    (_a7_Cat5    );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask) == true) Dst.setA5_nullNull    (); else        Dst.setA5_null    (_a5_null    );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask) == true) Dst.setA6_nullNull    (); else        Dst.setA6_null    (_a6_null    );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask) == true) Dst.setA7_nullNull    (); else        Dst.setA7_null    (_a7_null    );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask) == true) Dst.setA8_nullNull    (); else        Dst.setA8_null    (_a8_null    );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask) == true) Dst.setA3Null         (); else        Dst.setA3         (_a3         );
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask) == true) Dst.setLastUpdatedNull(); else        Dst.setLastUpdated(_lastUpdated);
     }

/**
 Sets the 'lastUpdated' column to now and causes a Write to occur to update the object in the data store.
*/
   public abstract boolean touch(Connection C) throws Exception;

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
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data_test.TILDATEST.Testing4Realized has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }

       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data_test.TILDATEST.Testing4Realized object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
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
               if (isRefnumNull() == true) PS.setNull(++i, java.sql.Types.BIGINT    );  else PS.setLong      (++i, _refnum     );
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
          tilda.data_test._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (_refnum != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask);
        }

       if (TextUtil.isNullOrEmpty(_name) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask);
        }

       if (_a1 != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask);
        }

       if (_a3b != null && _a3b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask);
        }

       if (_a4 != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask);
        }

       if (_a4b != null && _a4b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask);
        }

       if (_a5 != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask);
        }

       if (_a5b != null && _a5b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask);
        }

       if (_a7 != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask);
        }

       if (_a7b != null && _a7b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask);
        }

       if (_a8 != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask);
        }

       if (TextUtil.isNullOrEmpty(Str_a8b) == false)
        {
          _a8b = DateTimeUtil.parsefromJSON(Str_a8b);
          if (   _a8b == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.Testing4Realized.a8b' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_a8b.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Testing4Realized.a8b' because the timezone value '"+_a8b.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setA8bTZ(ZI.getId());
        }

       if (_a10a != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask);
        }

       if (TextUtil.isNullOrEmpty(_a10b) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask);
        }

       if (_a10c != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask);
        }

       if (_a11 != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask);
        }

       if (_a11b != null && _a11b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask);
        }

       if (_a11c != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask);
        }

       if (_a12 != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask);
        }

       if (_a12b != null && _a12b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask);
        }

       if (_a13 != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask);
        }

       if (_a13b != null && _a13b.isEmpty() == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask);
        }

       if (TextUtil.isNullOrEmpty(_description) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask);
        }

       if (TextUtil.isNullOrEmpty(_desc2) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask);
        }

       if (TextUtil.isNullOrEmpty(_desc3) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask);
        }

       if (TextUtil.isNullOrEmpty(_desc4) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask);
        }

       if (TextUtil.isNullOrEmpty(_desc5) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask);
        }

       if (TextUtil.isNullOrEmpty(_desc6) == false)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask);
        }

       if (_a3 != null)
        {
          __Changes.or(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask);
          __Nulls.andNot(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask);
        }
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_a8b) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_bastille) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_toto) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDATEST", "Testing4Realized");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.REFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.NAME.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A1.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A3B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A4.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A4B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A5.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A5B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A7.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A7B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A8.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A8B.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == false && DateTimeUtil.isNowPlaceholder(_a8b) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A10A.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A10B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A10C.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A11.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A11B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A11C.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A12.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A12B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A13.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A13B.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.DESC2.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.DESC3.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.DESC4.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.DESC5.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.DESC6.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask) == false && DateTimeUtil.isNowPlaceholder(_bastille) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }

          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.TOTO.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask) == false && DateTimeUtil.isNowPlaceholder(_toto) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.A3.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__1_0._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDATEST", "Testing4Realized"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.REFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.NAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A1.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A3B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A4.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A4B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A5.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A5B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A7.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A7B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A8.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == false && DateTimeUtil.isNowPlaceholder(_a8b) == true)
              { TILDA__TESTING4REALIZED_Factory.COLS.A8B.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING4REALIZED_Factory.COLS.A8B.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A10A.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A10B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A10C.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A11.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A11B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A11C.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A12.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A12B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A13.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A13B.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.DESC2.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.DESC3.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.DESC4.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.DESC5.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.DESC6.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask) == false && DateTimeUtil.isNowPlaceholder(_bastille) == true)
              { TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask) == false && DateTimeUtil.isNowPlaceholder(_toto) == true)
              { TILDA__TESTING4REALIZED_Factory.COLS.TOTO.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING4REALIZED_Factory.COLS.TOTO.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask) == true) TILDA__TESTING4REALIZED_Factory.COLS.A3.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0:
                S.append(" where ("); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "refnum"); S.append("=?)");
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
       QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATEST.Testing4Realized", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _refnum);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _name);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setInt       (++i, _a1);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.BOOLEAN   ); else C.setArray(PS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A3B._Type, AllocatedArrays, _a3b);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask) == true) PS.setNull(++i, java.sql.Types.DOUBLE    ); else PS.setDouble    (++i, _a4);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.DOUBLE    ); else C.setArray(PS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A4B._Type, AllocatedArrays, _a4b);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask) == true) PS.setNull(++i, java.sql.Types.FLOAT     ); else PS.setFloat     (++i, _a5);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.FLOAT     ); else C.setArray(PS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A5B._Type, AllocatedArrays, _a5b);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _a7);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.INTEGER   ); else C.setArray(PS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A7B._Type, AllocatedArrays, _a7b);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask) == true) PS.setNull(++i, java.sql.Types.BINARY    ); else PS.setBytes     (++i, _a8);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _a8bTZ);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_a8b) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_a8b.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _a10a);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _a10b);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _a10c);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask) == true) PS.setNull(++i, java.sql.Types.NUMERIC   ); else PS.setBigDecimal(++i, _a11);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.NUMERIC   ); else C.setArray(PS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A11B._Type, AllocatedArrays, _a11b);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask) == true) PS.setNull(++i, java.sql.Types.NUMERIC   ); else PS.setBigDecimal(++i, _a11c);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask) == true) PS.setNull(++i, java.sql.Types.SMALLINT  ); else PS.setShort     (++i, _a12);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.SMALLINT  ); else C.setArray(PS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A12B._Type, AllocatedArrays, _a12b);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask) == true) PS.setNull(++i, java.sql.Types.OTHER     ); else PS.setObject    (++i, _a13, java.sql.Types.OTHER     );
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.OTHER     ); else C.setArray(PS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A13B._Type, AllocatedArrays, _a13b);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _description);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _desc2);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _desc3);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _desc4);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _desc5);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _desc6);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_bastille) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_bastille.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_toto) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_toto.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask) == true) PS.setNull(++i, java.sql.Types.DOUBLE    ); else PS.setDouble    (++i, _desc2_Cat1);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask) == true) PS.setNull(++i, java.sql.Types.DOUBLE    ); else PS.setDouble    (++i, _desc2_Cat2);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask) == true) PS.setNull(++i, java.sql.Types.DOUBLE    ); else PS.setDouble    (++i, _desc2_Cat3);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask) == true) PS.setNull(++i, java.sql.Types.DOUBLE    ); else PS.setDouble    (++i, _a7_Cat4);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask) == true) PS.setNull(++i, java.sql.Types.DOUBLE    ); else PS.setDouble    (++i, _a7_Cat5);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _a5_null);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _a6_null);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _a7_null);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _a8_null);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask) == true) PS.setNull(++i, java.sql.Types.BOOLEAN   ); else PS.setBoolean   (++i, _a3);
        } 
       if (__Changes.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_lastUpdated.toInstant()), DateTimeUtil._UTC_CALENDAR);
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
        throw new Exception("Object has not been instanciated via deserialization or the factory create() method.");

       if (__Init == null && __LookupId==0);  // object deserialized
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

       // Testing if cols for unique index Refnum were set - Id: 0
       if (_refnum != null)
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
        throw new Exception("This TILDATEST.Testing4Realized object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATEST.Testing4Realized object has already been read.");
          QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "refnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "name");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a1");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a3b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a4b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a5b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a7");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a7b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a8");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a8bTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a8b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a10a");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a10b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a10c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a11");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a11b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a11c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a12");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a12b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a13");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a13b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "description");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "desc2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "desc3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "desc4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "desc5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "desc6");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "bastille");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "toto");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "desc2_Cat1");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "desc2_Cat2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "desc2_Cat3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a7_Cat4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a7_Cat5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a5_null");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a6_null");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a7_null");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a8_null");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "a3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "lastUpdated");
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "Testing4Realized");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "refnum"); S.append("=?)");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATEST.Testing4Realized", Q, toString());
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
               if (isRefnumNull() == true) PS.setNull(++i, java.sql.Types.BIGINT    );  else PS.setLong      (++i, _refnum     );
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
          tilda.data_test._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }
    }

   @SuppressWarnings("unchecked")
   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_refnum      = _refnum      =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask     );
                            _name        = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask       );
                            _a1          =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask         );
                            _a3b = (List<Boolean>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A3B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask        );
                            _a4          =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask         );
                            _a4b = (List<Double>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A4B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask        );
                            _a5          =                              RS.getFloat     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask         );
                            _a5b = (List<Float>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A5B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask        );
                            _a7          =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask         );
                            _a7b = (List<Integer>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A7B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask        );
                            _a8          =                              RS.getBytes     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask         );
                            _a8bTZ       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ._Mask      );
                            _a8b         = processZDT(_a8bTZ        , "tilda.data_test.TILDATEST.Testing4Realized.a8b"        , RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A8B        , TILDA__TESTING4REALIZED_Factory.COLS.A8BTZ        ); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask        );
                            _a10a        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask       );
                            _a10b        = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask       );
                            _a10c        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask       );
                            _a11         =                              RS.getBigDecimal(++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask        );
                            _a11b = (List<BigDecimal>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A11B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask       );
                            _a11c        =                              RS.getBigDecimal(++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask       );
                            _a12         =                              RS.getShort     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask        );
                            _a12b = (List<Short>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A12B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask       );
                            _a13         =                              (java.util.UUID) RS.getObject(++i);  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask        );
                            _a13b = (List<UUID>) C.getArray(RS, ++i, TILDA__TESTING4REALIZED_Factory.COLS.A13B._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask       );
                            _description = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask);
                            _desc2       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask      );
                            _desc3       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask      );
                            _desc4       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask      );
                            _desc5       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask      );
                            _desc6       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask      );
                            _bastille    = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.BASTILLE._Mask   );
                            _toto        = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.TOTO._Mask       );
                            _desc2_Cat1  =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT1._Mask );
                            _desc2_Cat2  =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT2._Mask );
                            _desc2_Cat3  =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.DESC2_CAT3._Mask );
                            _a7_Cat4     =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT4._Mask    );
                            _a7_Cat5     =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_CAT5._Mask    );
                            _a5_null     =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A5_NULL._Mask    );
                            _a6_null     =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A6_NULL._Mask    );
                            _a7_null     =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A7_NULL._Mask    );
                            _a8_null     =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A8_NULL._Mask    );
                            _a3          =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.A3._Mask         );
                            _lastUpdated = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTING4REALIZED_Factory.COLS.LASTUPDATED._Mask);
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
                   "refnum"        + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.REFNUM._Mask) == true ? ": NULL" : ": " +                                   getRefnum     () )
               + "; name"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.NAME._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getName       ()))
               + "; a1"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A1._Mask) == true ? ": NULL" : ": " +                                   getA1         () )
               + "; a3b"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A3B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA3b        ()))
               + "; a4"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4._Mask) == true ? ": NULL" : ": " +                                   getA4         () )
               + "; a4b"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A4B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA4b        ()))
               + "; a5"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5._Mask) == true ? ": NULL" : ": " +                                   getA5         () )
               + "; a5b"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A5B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA5b        ()))
               + "; a7"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7._Mask) == true ? ": NULL" : ": " +                                   getA7         () )
               + "; a7b"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A7B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA7b        ()))
               + "; a8"            + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8._Mask) == true ? ": NULL" : ": " +                                   getA8         () )
               + "; a8b"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A8B._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getA8b        ()))
               + "; a10a"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10A._Mask) == true ? ": NULL" : ": " +                                   getA10a       () )
               + "; a10b"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10B._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getA10b       ()))
               + "; a10c"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A10C._Mask) == true ? ": NULL" : ": " +                                   getA10c       () )
               + "; a11"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11._Mask) == true ? ": NULL" : ": " +                                   getA11        () )
               + "; a11b"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA11b       ()))
               + "; a11c"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A11C._Mask) == true ? ": NULL" : ": " +                                   getA11c       () )
               + "; a12"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12._Mask) == true ? ": NULL" : ": " +                                   getA12        () )
               + "; a12b"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A12B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA12b       ()))
               + "; a13"           + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13._Mask) == true ? ": NULL" : ": " +                                   getA13        () )
               + "; a13b"          + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.A13B._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getA13b       ()))
               + "; description"   + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESCRIPTION._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDescription()))
               + "; desc2"         + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC2._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc2      ()))
               + "; desc3"         + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC3._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc3      ()))
               + "; desc4"         + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC4._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc4      ()))
               + "; desc5"         + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC5._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc5      ()))
               + "; desc6"         + (__Nulls.intersects(TILDA__TESTING4REALIZED_Factory.COLS.DESC6._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getDesc6      ()))
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
