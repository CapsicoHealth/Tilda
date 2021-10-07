/*
 Tilda V1.0 data object.

 Code is generated: do not modify! Instead, create a derived class and override desired functionality
*/

package tilda.tutorial.data._Tilda;

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
<TABLE id="Test_XYZ_Analytics_View_DIV" class="tables">
<SCRIPT>registerStickyHeader("Test_XYZ_Analytics_View_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Test_XYZ_Analytics_View&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Test_XYZ_Analytics_View_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Test_XYZ_Analytics_View_CNT" class="content">
The View TILDATUTORIAL.Test_XYZ_Analytics_View:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Test_XYZ_Analytics_View_Factory</B>, <B>Test_XYZ_Analytics_View_Data</B> in the package <B>tilda.tutorial.data</B>.
<LI>Configured to be Realized to <B><A href="TILDA___Docs.TILDATUTORIAL.html#Test_XYZ_Analytics_Realized_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_Analytics_Realized</A></B> through DB function <B>TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Refill_Test_XYZ_Analytics_Realized()</B>.</LI>
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Defines a foreign key to <A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A> </LI>
</UL>
<B>Description</B>: A view of XYZ forms with analytics<BR>
<BR>
This view depends on the following filter(s), sub-view(s), and/or root table(s):
<BLOCKQUOTE><TABLE class="TreeTable Rowed" border="0px" cellspacing="0px" cellpadding="2px"><TR><TD><PRE><A href="TILDA___Docs.TILDATUTORIAL.html#Test_XYZ_Analytics_View_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_Analytics_View</A></PRE></TD><TD><PRE>Unfiltered</PRE></TD></TR>
<TR><TD><PRE>    <A href="TILDA___Docs.TILDATUTORIAL.html#Test_XYZ_PivotView_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView</A></PRE></TD><TD>Only look at XYZ forms and answers that have not been deleted.<PRE>    Form.type = 'XYZ'
and Form.deleted is null
and TestAnswer.deleted is null</PRE></TD></TR>
<TR><TD><PRE>        <A href="TILDA___Docs.TILDATUTORIAL.html#Form_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form</A></PRE></TD><TD><PRE>Root table for the view TILDATUTORIAL.Test_XYZ_PivotView</PRE></TD></TR>
<TR><TD><PRE>        <A href="TILDA___Docs.TILDATUTORIAL.html#User_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>User</A></PRE></TD><TD><PRE>Standard join</PRE></TD></TR>
<TR><TD><PRE>        <A href="TILDA___Docs.TILDATUTORIAL.html#TestAnswer_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer</A></PRE></TD><TD><PRE>Standard join</PRE></TD></TR>
<TR><TD><PRE>    <A href="TILDA___Docs.TILDATUTORIAL.html#Test_View_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_View</A></PRE></TD><TD>Look at all forms and answers that have not been deleted.<PRE>    Form.deleted is null
and TestAnswer.deleted is null</PRE></TD></TR>
<TR><TD><PRE>        <A href="TILDA___Docs.TILDATUTORIAL.html#Form_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form</A></PRE></TD><TD><PRE>Root table for the view TILDATUTORIAL.Test_View</PRE></TD></TR>
<TR><TD><PRE>        <A href="TILDA___Docs.TILDATUTORIAL.html#TestAnswer_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer</A></PRE></TD><TD><PRE>Standard join</PRE></TD></TR>
</TABLE></BLOCKQUOTE>
This View contains the following columns:<BLOCKQUOTE>
 <TABLE id="Test_XYZ_Analytics_View_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left" nowrap><label>Realized<input type="checkbox" onchange="filterTable('Test_XYZ_Analytics_View_TBL', 'R')", id="Test_XYZ_Analytics_View_TBL_R"></label>&nbsp;</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description/<label>Formula<input type="checkbox" onchange="filterTable('Test_XYZ_Analytics_View_TBL', 'F')", id="Test_XYZ_Analytics_View_TBL_F"></label></TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-formRefnum_DIV' class='columns realizedcolumns'>formRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_XYZ_PivotView-formRefnum_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView<B>&nbsp;&#8226;&nbsp;</B>formRefnum</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('Form-refnum_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-formType_DIV' class='columns realizedcolumns'>formType</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(40)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Form template type<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_XYZ_PivotView-formType_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView<B>&nbsp;&#8226;&nbsp;</B>formType</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('Form-type_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>type</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-formFillDateTZ_DIV' class='columns realizedcolumns'>formFillDateTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'formFillDate'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_XYZ_PivotView-formFillDateTZ_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView<B>&nbsp;&#8226;&nbsp;</B>formFillDateTZ</A><BR>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo-id_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo<B>&nbsp;&#8226;&nbsp;</B>id</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-formFillDate_DIV' class='columns realizedcolumns'>formFillDate</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The date the form was filled<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_XYZ_PivotView-formFillDate_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView<B>&nbsp;&#8226;&nbsp;</B>formFillDate</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('Form-fillDate_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>fillDate</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-formUserRefnum_DIV' class='columns realizedcolumns'>formUserRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_XYZ_PivotView-formUserRefnum_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView<B>&nbsp;&#8226;&nbsp;</B>formUserRefnum</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('User-refnum_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>User<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-formUserEmail_DIV' class='columns realizedcolumns'>formUserEmail</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(255)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The user's email<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_XYZ_PivotView-formUserEmail_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView<B>&nbsp;&#8226;&nbsp;</B>formUserEmail</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('User-email_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>User<B>&nbsp;&#8226;&nbsp;</B>email</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-formCountCorrect_DIV' class='columns realizedcolumns'>formCountCorrect</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_XYZ_PivotView-countCorrect_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView<B>&nbsp;&#8226;&nbsp;</B>countCorrect</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('TestAnswer-correct_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>correct</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-formTimeMillisTotal_DIV' class='columns realizedcolumns'>formTimeMillisTotal</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_XYZ_PivotView-timeMillisTotal_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView<B>&nbsp;&#8226;&nbsp;</B>timeMillisTotal</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('TestAnswer-timeMillis_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>timeMillis</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-testCount_DIV' class='columns realizedcolumns'>testCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_View-testCount_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_View<B>&nbsp;&#8226;&nbsp;</B>testCount</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('Form-refnum_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-testAnswerCountCorrect_DIV' class='columns realizedcolumns'>testAnswerCountCorrect</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_View-answerCountCorrect_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_View<B>&nbsp;&#8226;&nbsp;</B>answerCountCorrect</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('TestAnswer-correct_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>correct</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-testTimeMillisAvg_DIV' class='columns realizedcolumns'>testTimeMillisAvg</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Test_View-timeMillisAvg_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_View<B>&nbsp;&#8226;&nbsp;</B>timeMillisAvg</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('TestAnswer-timeMillis_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>timeMillis</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-isPassed_DIV' class='formulae realizedformulae'>isPassed</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD><B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.</TD></TR>
  <TR valign="top" style="background-color:#FFFFFF"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;"><A style="color:#00AA00; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-formCountCorrect_DIV', -50)">formCountCorrect</A> >= 2</PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-formCountCorrect_DIV', -50)">formCountCorrect</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="javascript:openDiv('Test_XYZ_PivotView-countCorrect_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView<B>&nbsp;&#8226;&nbsp;</B>countCorrect</A>
&nbsp;&nbsp;&rarr;&nbsp;<A href="javascript:openDiv('TestAnswer-correct_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>correct</A>
</DIV>
<DIV style="padding-left:10px;">Whether the answer is correct or not</DIV>
</TD></TR>
</TABLE>&nbsp;
<DIV id='Test_XYZ_Analytics_View-isPassed_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Test_XYZ_Analytics_View-isPassed_MODAL')" class='close'>&times;</SPAN>
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
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-tookLongerThanAverage_DIV' class='formulae realizedformulae'>tookLongerThanAverage</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD><B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.</TD></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2)"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;"><A style="color:#00AA00; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-formTimeMillisTotal_DIV', -50)">formTimeMillisTotal</A> > <A style="color:#00AA00; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-testTimeMillisAvg_DIV', -50)">testTimeMillisAvg</A></PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-formTimeMillisTotal_DIV', -50)">formTimeMillisTotal</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="javascript:openDiv('Test_XYZ_PivotView-timeMillisTotal_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_PivotView<B>&nbsp;&#8226;&nbsp;</B>timeMillisTotal</A>
&nbsp;&nbsp;&rarr;&nbsp;<A href="javascript:openDiv('TestAnswer-timeMillis_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>timeMillis</A>
</DIV>
<DIV style="padding-left:10px;">Time in milliseconds for the time spent answering the question</DIV>
<A style="color:#00AA00; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-testTimeMillisAvg_DIV', -50)">testTimeMillisAvg</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="javascript:openDiv('Test_View-timeMillisAvg_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_View<B>&nbsp;&#8226;&nbsp;</B>timeMillisAvg</A>
&nbsp;&nbsp;&rarr;&nbsp;<A href="javascript:openDiv('TestAnswer-timeMillis_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>timeMillis</A>
</DIV>
<DIV style="padding-left:10px;">Time in milliseconds for the time spent answering the question</DIV>
</TD></TR>
</TABLE>&nbsp;
<DIV id='Test_XYZ_Analytics_View-tookLongerThanAverage_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Test_XYZ_Analytics_View-tookLongerThanAverage_MODAL')" class='close'>&times;</SPAN>
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
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_View-wasChallenging_DIV' class='formulae realizedformulae'>wasChallenging</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD><B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL></TD></TR>
  <TR valign="top" style="background-color:#FFFFFF"><TD colspan="2"></TD><TD colspan="7">
<TABLE border="1px" style="border-collapse:collapse; border: 1px solid #AAA;" cellspacing="0px" cellpadding="2px" width="98%">
<TR valign="top"><TD width="1px" align="right"><B>Formula</B></TD><TD><PRE style="padding-top: 3px; font-size:110%;">    <A style="color:#0000AA; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-isPassed_DIV', -50)">isPassed</A>=1
AND <A style="color:#00AA00; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-testAnswerCountCorrect_DIV', -50)">testAnswerCountCorrect</A> < <A style="color:#00AA00; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-testCount_DIV', -50)">testCount</A>*3/2</PRE></TD><TR>
<TR valign="top"><TD width="1px" align="right"><B>Values</B></TD><TD><TABLE border="0px">
<TR valign="top"><TD>0</TD><TD>The test was not challenging</TD><TR>
<TR valign="top"><TD>1</TD><TD>The test was challenging</TD><TR>
</TABLE></TD></TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Columns</B></TD><TD>
<A style="color:#00AA00; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-testAnswerCountCorrect_DIV', -50)">testAnswerCountCorrect</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="javascript:openDiv('Test_View-answerCountCorrect_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_View<B>&nbsp;&#8226;&nbsp;</B>answerCountCorrect</A>
&nbsp;&nbsp;&rarr;&nbsp;<A href="javascript:openDiv('TestAnswer-correct_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>correct</A>
</DIV>
<DIV style="padding-left:10px;">Whether the answer is correct or not</DIV>
<A style="color:#00AA00; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-testCount_DIV', -50)">testCount</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="javascript:openDiv('Test_View-testCount_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_View<B>&nbsp;&#8226;&nbsp;</B>testCount</A>
&nbsp;&nbsp;&rarr;&nbsp;<A href="javascript:openDiv('Form-refnum_DIV', -50)">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>refnum</A>
</DIV>
<DIV style="padding-left:10px;">The primary key for this record</DIV>
</TD></TR>
<TR valign="top"><TD width="1px" align="right"><B>Ref&nbsp;Formulas</B></TD><TD>
<A style="color:#0000AA; font-weight: bold;" href="javascript:openDiv('Test_XYZ_Analytics_View-isPassed_DIV', -50)">isPassed</A><BR>
<DIV style="padding-left:10px; font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Test_XYZ_Analytics_View-isPassed_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_Analytics_View<B>&nbsp;&#8226;&nbsp;</B>isPassed</A></DIV>
<DIV style="padding-left:10px;">Whether the test was passed or not by answering at least 2 out of the 3 questions.</DIV>
</TD></TR>
</TABLE>&nbsp;
<DIV id='Test_XYZ_Analytics_View-wasChallenging_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('Test_XYZ_Analytics_View-wasChallenging_MODAL')" class='close'>&times;</SPAN>
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
public abstract class TILDA__TEST_XYZ_ANALYTICS_VIEW implements tilda.interfaces.ReaderObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__TEST_XYZ_ANALYTICS_VIEW.class.getName());

   public transient static final Class<TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory> FACTORY_CLASS= TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDATUTORIAL.Test_XYZ_Analytics_View", "");

   protected TILDA__TEST_XYZ_ANALYTICS_VIEW() { }

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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_View."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formRefnum")
   Long _formRefnum=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_View."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormRefnum()
      { return _formRefnum==null?0l:_formRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_View."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _formRefnum == null || v != _formRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMREFNUM._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMREFNUM._Mask);
       _formRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field formRefnum doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initFormRefnum(long v) throws Exception
     {
       setFormRefnum(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType -> TILDATUTORIAL.Test_XYZ_Analytics_View."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formType of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formType")
   String _formType=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType -> TILDATUTORIAL.Test_XYZ_Analytics_View."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formType of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormType()
      { return _formType; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType -> TILDATUTORIAL.Test_XYZ_Analytics_View."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formType of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormType(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType to null: it's not nullable.");
       else if (v.length() > 40)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType: the size "+v.length()+" is larger than the max allowed of 40: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_formType) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formType' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMTYPE._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMTYPE._Mask);
       _formType = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _formFillDateTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormFillDateTZ()
      { return _formFillDateTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isFormFillDateTZNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATETZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormFillDateTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setFormFillDateTZNull();
        }
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_formFillDateTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATETZ._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATETZ._Mask);
       _formFillDateTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormFillDateTZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATETZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATETZ._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATETZ._Mask);
       _formFillDateTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formFillDate")
   String  Str_formFillDate;
   public void initFormFillDate(String v) { Str_formFillDate = v; }
   public String initFormFillDateVal() { return Str_formFillDate; }
   transient ZonedDateTime _formFillDate = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getFormFillDate()
      { return _formFillDate; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isFormFillDateNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormFillDate(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setFormFillDateNull();
        }
       else if (v.equals(_formFillDate) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATE._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATE._Mask);
       _formFillDate = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setFormFillDateTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_View."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormFillDateNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATE._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATE._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATE._Mask);
       _formFillDate=null;
       setFormFillDateTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_View."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formUserRefnum")
   Long _formUserRefnum=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_View."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormUserRefnum()
      { return _formUserRefnum==null?0l:_formUserRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_View."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormUserRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _formUserRefnum == null || v != _formUserRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMUSERREFNUM._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMUSERREFNUM._Mask);
       _formUserRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field formUserRefnum doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initFormUserRefnum(long v) throws Exception
     {
       setFormUserRefnum(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_View."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formUserEmail")
   String _formUserEmail=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_View."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormUserEmail()
      { return _formUserEmail; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_View."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormUserEmail(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail to null: it's not nullable.");
       else if (v.length() > 255)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail: the size "+v.length()+" is larger than the max allowed of 255: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_formUserEmail) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMUSEREMAIL._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMUSEREMAIL._Mask);
       _formUserEmail = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_View."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formCountCorrect")
   Long _formCountCorrect=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_View."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormCountCorrect()
      { return _formCountCorrect==null?0l:_formCountCorrect; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_View."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormCountCorrect(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _formCountCorrect == null || v != _formCountCorrect)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMCOUNTCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMCOUNTCORRECT._Mask);
       _formCountCorrect = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_View."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formTimeMillisTotal")
   Long _formTimeMillisTotal=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_View."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormTimeMillisTotal()
      { return _formTimeMillisTotal==null?0l:_formTimeMillisTotal; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_View."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormTimeMillisTotal(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _formTimeMillisTotal == null || v != _formTimeMillisTotal)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMTIMEMILLISTOTAL._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMTIMEMILLISTOTAL._Mask);
       _formTimeMillisTotal = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_View."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("testCount")
   Long _testCount=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_View."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getTestCount()
      { return _testCount==null?0l:_testCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_View."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestCount(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _testCount == null || v != _testCount)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testCount' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TESTCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TESTCOUNT._Mask);
       _testCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field testCount doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initTestCount(long v) throws Exception
     {
       setTestCount(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_View."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("testAnswerCountCorrect")
   Long _testAnswerCountCorrect=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_View."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getTestAnswerCountCorrect()
      { return _testAnswerCountCorrect==null?0l:_testAnswerCountCorrect; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_View."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestAnswerCountCorrect(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _testAnswerCountCorrect == null || v != _testAnswerCountCorrect)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask);
       _testAnswerCountCorrect = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_View."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("testTimeMillisAvg")
   Double _testTimeMillisAvg=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_View."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getTestTimeMillisAvg()
      { return _testTimeMillisAvg==null?0d:_testTimeMillisAvg; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_View."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestTimeMillisAvg(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _testTimeMillisAvg == null || v != _testTimeMillisAvg)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TESTTIMEMILLISAVG._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TESTTIMEMILLISAVG._Mask);
       _testTimeMillisAvg = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_View."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formCountCorrect >= 2</PRE>
</TD></TR>

</TABLE>
*/
   Integer _isPassed=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_View."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formCountCorrect >= 2</PRE>
</TD></TR>

</TABLE>
*/
   public final int getIsPassed()
      { return _isPassed==null?0:_isPassed; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_View."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formCountCorrect >= 2</PRE>
</TD></TR>

</TABLE>
*/
   public final boolean isIsPassedNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.ISPASSED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_View."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formCountCorrect >= 2</PRE>
</TD></TR>

</TABLE>
*/
    void setIsPassed(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _isPassed == null || v != _isPassed)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.ISPASSED._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.ISPASSED._Mask);
       _isPassed = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_View."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Passed</B>: Whether the test was passed or not by answering at least 2 out of the 3 questions.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formCountCorrect >= 2</PRE>
</TD></TR>

</TABLE>
*/
    void setIsPassedNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.ISPASSED._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.ISPASSED._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.ISPASSED._Mask);
       _isPassed=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_View."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formTimeMillisTotal > testTimeMillisAvg</PRE>
</TD></TR>

</TABLE>
*/
   Integer _tookLongerThanAverage=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_View."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formTimeMillisTotal > testTimeMillisAvg</PRE>
</TD></TR>

</TABLE>
*/
   public final int getTookLongerThanAverage()
      { return _tookLongerThanAverage==null?0:_tookLongerThanAverage; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_View."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formTimeMillisTotal > testTimeMillisAvg</PRE>
</TD></TR>

</TABLE>
*/
   public final boolean isTookLongerThanAverageNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_View."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formTimeMillisTotal > testTimeMillisAvg</PRE>
</TD></TR>

</TABLE>
*/
    void setTookLongerThanAverage(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _tookLongerThanAverage == null || v != _tookLongerThanAverage)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask);
       _tookLongerThanAverage = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_View."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Took Longer Than Average</B>: Whether the test took longer that the average time spent across all tests.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>formTimeMillisTotal > testTimeMillisAvg</PRE>
</TD></TR>

</TABLE>
*/
    void setTookLongerThanAverageNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask);
       _tookLongerThanAverage=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_View."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL></TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>    isPassed=1
AND testAnswerCountCorrect < testCount*3/2</PRE>
</TD></TR>

</TABLE>
*/
   Integer _wasChallenging=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_View."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL></TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>    isPassed=1
AND testAnswerCountCorrect < testCount*3/2</PRE>
</TD></TR>

</TABLE>
*/
   public final int getWasChallenging()
      { return _wasChallenging==null?0:_wasChallenging; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_View."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL></TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>    isPassed=1
AND testAnswerCountCorrect < testCount*3/2</PRE>
</TD></TR>

</TABLE>
*/
   public final boolean isWasChallengingNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.WASCHALLENGING._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_View."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL></TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>    isPassed=1
AND testAnswerCountCorrect < testCount*3/2</PRE>
</TD></TR>

</TABLE>
*/
    void setWasChallenging(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _wasChallenging == null || v != _wasChallenging)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.WASCHALLENGING._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.WASCHALLENGING._Mask);
       _wasChallenging = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_View."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Test Was Challenging</B>: Whether the test was challenging in that:<LI>   <LI>it was passed,</LI>   <LI>and overall, less than a third of answers across all tests were answered correctly.</LI> </UL></TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>    isPassed=1
AND testAnswerCountCorrect < testCount*3/2</PRE>
</TD></TR>

</TABLE>
*/
    void setWasChallengingNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.WASCHALLENGING._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.WASCHALLENGING._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.WASCHALLENGING._Mask);
       _wasChallenging=null;
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
        throw new Exception("This TILDATUTORIAL.Test_XYZ_Analytics_View object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATUTORIAL.Test_XYZ_Analytics_View object has already been read.");
          QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formType");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formFillDateTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formFillDate");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formUserRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formUserEmail");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formCountCorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "formTimeMillisTotal");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "testCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "testAnswerCountCorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "testTimeMillisAvg");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "isPassed");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "tookLongerThanAverage");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View", "wasChallenging");
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_View");
       switch (__LookupId)
        {
          case 0: // Unique Query 'All'
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATUTORIAL.Test_XYZ_Analytics_View", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       int count = 0;

       try
        {
          PS = C.prepareStatement(Q);
          switch (__LookupId)
           {
             case 0: // Unique Query 'All'
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                                       _formRefnum             =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMREFNUM._Mask            ); _formRefnum = null; }
                                       _formType               = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMTYPE._Mask              ); _formType = null; }
                                       _formFillDateTZ         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATETZ._Mask        ); _formFillDateTZ = null; }
                                       _formFillDate           = processZDT(_formFillDateTZ          , "tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate"          , RS, ++i, TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATE          , TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATETZ          ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATE._Mask          ); _formFillDate = null; }
                                       _formUserRefnum         =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMUSERREFNUM._Mask        ); _formUserRefnum = null; }
                                       _formUserEmail          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMUSEREMAIL._Mask         ); _formUserEmail = null; }
                                       _formCountCorrect       =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMCOUNTCORRECT._Mask      ); _formCountCorrect = null; }
                                       _formTimeMillisTotal    =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMTIMEMILLISTOTAL._Mask   ); _formTimeMillisTotal = null; }
                                       _testCount              =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TESTCOUNT._Mask             ); _testCount = null; }
                                       _testAnswerCountCorrect =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask); _testAnswerCountCorrect = null; }
                                       _testTimeMillisAvg      =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TESTTIMEMILLISAVG._Mask     ); _testTimeMillisAvg = null; }
                                       _isPassed               =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.ISPASSED._Mask              ); _isPassed = null; }
                                       _tookLongerThanAverage  =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask ); _tookLongerThanAverage = null; }
                                       _wasChallenging         =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.WASCHALLENGING._Mask        ); _wasChallenging = null; }
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
                   "formRefnum: "                                                                                                                             +                                   getFormRefnum            () 
               + "; formType: "                                                                                                                               + TextUtil.printVariableStr        (getFormType              ())
               + "; formFillDate"             + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.FORMFILLDATE._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getFormFillDate          ()))
               + "; formUserRefnum: "                                                                                                                         +                                   getFormUserRefnum        () 
               + "; formUserEmail: "                                                                                                                          + TextUtil.printVariableStr        (getFormUserEmail         ())
               + "; formCountCorrect: "                                                                                                                       +                                   getFormCountCorrect      () 
               + "; formTimeMillisTotal: "                                                                                                                    +                                   getFormTimeMillisTotal   () 
               + "; testCount: "                                                                                                                              +                                   getTestCount             () 
               + "; testAnswerCountCorrect: "                                                                                                                 +                                   getTestAnswerCountCorrect() 
               + "; testTimeMillisAvg: "                                                                                                                      +                                   getTestTimeMillisAvg     () 
               + "; isPassed"                 + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.ISPASSED._Mask) == true ? ": NULL" : ": " +                                   getIsPassed              () )
               + "; tookLongerThanAverage"    + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask) == true ? ": NULL" : ": " +                                   getTookLongerThanAverage () )
               + "; wasChallenging"           + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory.COLS.WASCHALLENGING._Mask) == true ? ": NULL" : ": " +                                   getWasChallenging        () )
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
          case "": tilda.tutorial.data.Test_XYZ_Analytics_View_Factory.toJSON(out, (tilda.tutorial.data.Test_XYZ_Analytics_View_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.tutorial.data.Test_XYZ_Analytics_View_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.tutorial.data.Test_XYZ_Analytics_View_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.tutorial.data.Test_XYZ_Analytics_View_Factory.toCSV(out, (tilda.tutorial.data.Test_XYZ_Analytics_View_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.tutorial.data.Test_XYZ_Analytics_View_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.tutorial.data.Test_XYZ_Analytics_View_Factory");
    }
 }
