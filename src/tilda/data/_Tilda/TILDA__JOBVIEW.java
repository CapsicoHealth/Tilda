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
<TABLE id="JobView_DIV" class="tables">
<SCRIPT>registerStickyHeader("JobView_DIV");</SCRIPT>
<TR valign="top"><TD><H2>JobView&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#JobView_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="JobView_CNT" class="content">
The View TILDA.JobView :<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>JobView_Factory</B>, <B>JobView_Data</B> in the package <B>tilda.data</B>.
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Defines 8 foreign key(s):<BR>
<TABLE style="margin-left: 25px; border:1px solid #BBB;" cellspacing="0px" cellpadding="5px" border="0px">
<TR style="background-color:#DDD; font-weight:bold;"><TD></TD><TD>Source Columns</TD><TD>Destination Object</TD><TD>Destination Columns</TD><TD>Notes</TD></TR>
<TR ><TD>1</TD><TD>jobDataStartTZ</TD><TD><A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A></TD><TD>id</TD><TD>&nbsp;</TD></TR>
</TABLE></LI>
</UL>
<B>Description</B>:<BLOCKQUOTE style="border-left: 1px solid #EEE;padding-left: 5px;">A view of the job data.</BLOCKQUOTE>
<BR>
This view depends on the following filter(s), sub-view(s), and/or root table(s):
<BLOCKQUOTE><TABLE class="TreeTable Rowed" border="0px" cellspacing="0px" cellpadding="2px"></TABLE></BLOCKQUOTE>
This View contains the following columns:<BLOCKQUOTE>
 <TABLE id="JobView_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid #BBB;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobRefnum_DIV' class='columns'>jobRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-refnum_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobName_DIV' class='columns'>jobName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Name<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-name_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>name</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobType_DIV' class='columns'>jobType</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job type<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-type_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>type</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobUserId_DIV' class='columns'>jobUserId</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job user Id<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-userId_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>userId</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobDataStartTZ_DIV' class='columns'>jobDataStartTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'jobDataStart'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-dataStartTZ_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>dataStartTZ</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobDataStart_DIV' class='columns'>jobDataStart</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>StartTime<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-dataStart_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>dataStart</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobDataEndTZ_DIV' class='columns'>jobDataEndTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'jobDataEnd'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-dataEndTZ_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>dataEndTZ</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobDataEnd_DIV' class='columns'>jobDataEnd</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>StartTime<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-dataEnd_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>dataEnd</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobStartTZ_DIV' class='columns'>jobStartTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'jobStart'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-startTZ_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>startTZ</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobStart_DIV' class='columns'>jobStart</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>StartTime<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-start_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>start</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobEndTZ_DIV' class='columns'>jobEndTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'jobEnd'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-endTZ_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>endTZ</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobEnd_DIV' class='columns'>jobEnd</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>EndTime<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-end_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>end</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobStatus_DIV' class='columns'>jobStatus</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Status<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-status_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>status</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobMsg_DIV' class='columns'>jobMsg</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Message details<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Job-msg_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Job<B>&nbsp;&#8226;&nbsp;</B>msg</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartName_DIV' class='columns'>jobPartName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job part name<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-name_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>name</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartType_DIV' class='columns'>jobPartType</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(250)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job part type<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-type_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>type</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartDataStartTZ_DIV' class='columns'>jobPartDataStartTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'jobPartDataStart'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-dataStartTZ_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>dataStartTZ</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartDataStart_DIV' class='columns'>jobPartDataStart</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job part data start<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-dataStart_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>dataStart</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartDataEndTZ_DIV' class='columns'>jobPartDataEndTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'jobPartDataEnd'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-dataEndTZ_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>dataEndTZ</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>20&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartDataEnd_DIV' class='columns'>jobPartDataEnd</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job part data end<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-dataEnd_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>dataEnd</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>21&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartStartTZ_DIV' class='columns'>jobPartStartTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'jobPartStart'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-startTZ_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>startTZ</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>22&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartStart_DIV' class='columns'>jobPartStart</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job part execution start<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-start_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>start</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>23&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartEndTZ_DIV' class='columns'>jobPartEndTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'jobPartEnd'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-endTZ_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>endTZ</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>24&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartEnd_DIV' class='columns'>jobPartEnd</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Job part execution end<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-end_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>end</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>25&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartRecordsCount_DIV' class='columns'>jobPartRecordsCount</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>count of database or file or ... records.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-recordsCount_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>recordsCount</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>26&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartStatus_DIV' class='columns'>jobPartStatus</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Status flag, i.e., success=true and failure-false<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPart-status_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPart<B>&nbsp;&#8226;&nbsp;</B>status</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>27&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartNotify_DIV' class='columns'>jobPartNotify</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Notification flag<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPartMessage-notify_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPartMessage<B>&nbsp;&#8226;&nbsp;</B>notify</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>28&nbsp;&nbsp;</TD>
<TD align="right"><B id='JobView-jobPartMessage_DIV' class='columns'>jobPartMessage</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Message details<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('JobPartMessage-msg_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>JobPartMessage<B>&nbsp;&#8226;&nbsp;</B>msg</A></DIV></TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__JOBVIEW implements tilda.interfaces.ReaderObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__JOBVIEW.class.getName());

   public transient static final Class<TILDA__JOBVIEW_Factory> FACTORY_CLASS= TILDA__JOBVIEW_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDA.JobView", "");

   protected TILDA__JOBVIEW() { }

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
//   Field tilda.data.TILDA.JobView.jobRefnum -> TILDA.JobView."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobRefnum")
   Long _jobRefnum=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobRefnum -> TILDA.JobView."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getJobRefnum()
      { return _jobRefnum==null?0l:_jobRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobRefnum -> TILDA.JobView."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _jobRefnum == null || v != _jobRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBREFNUM._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBREFNUM._Mask);
       _jobRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field jobRefnum doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initJobRefnum(long v) throws Exception
     {
       setJobRefnum(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobName -> TILDA.JobView."jobName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobName of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobName")
   String _jobName=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobName -> TILDA.JobView."jobName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobName of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobName()
      { return _jobName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobName -> TILDA.JobView."jobName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobName of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobName to null: it's not nullable.");
       else if (v.length() > 250)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobName: the size "+v.length()+" is larger than the max allowed of 250: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBNAME._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBNAME._Mask);
       _jobName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobType -> TILDA.JobView."jobType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobType")
   String _jobType=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobType -> TILDA.JobView."jobType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobType()
      { return _jobType; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobType -> TILDA.JobView."jobType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobTypeNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBTYPE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobType -> TILDA.JobView."jobType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobType(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobTypeNull();
        }
       else if (v.length() > 250)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobType: the size "+v.length()+" is larger than the max allowed of 250: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobType) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobType' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBTYPE._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBTYPE._Mask);
       _jobType = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobType -> TILDA.JobView."jobType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobTypeNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBTYPE._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBTYPE._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBTYPE._Mask);
       _jobType=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobUserId -> TILDA.JobView."jobUserId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobUserId of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job user Id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobUserId of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobUserId</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobUserId")
   String _jobUserId=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobUserId -> TILDA.JobView."jobUserId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobUserId of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job user Id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobUserId of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobUserId</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobUserId()
      { return _jobUserId; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobUserId -> TILDA.JobView."jobUserId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobUserId of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job user Id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobUserId of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobUserId</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobUserIdNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBUSERID._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobUserId -> TILDA.JobView."jobUserId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobUserId of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job user Id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobUserId of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobUserId</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobUserId(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobUserIdNull();
        }
       else if (v.length() > 250)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobUserId: the size "+v.length()+" is larger than the max allowed of 250: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobUserId) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobUserId' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBUSERID._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBUSERID._Mask);
       _jobUserId = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobUserId -> TILDA.JobView."jobUserId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobUserId of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job user Id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobUserId of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobUserId</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobUserIdNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBUSERID._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBUSERID._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBUSERID._Mask);
       _jobUserId=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStartTZ -> TILDA.JobView."jobDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _jobDataStartTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStartTZ -> TILDA.JobView."jobDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobDataStartTZ()
      { return _jobDataStartTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStartTZ -> TILDA.JobView."jobDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobDataStartTZNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBDATASTARTTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStartTZ -> TILDA.JobView."jobDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobDataStartTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobDataStartTZNull();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobDataStartTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobDataStartTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobDataStartTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBDATASTARTTZ._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBDATASTARTTZ._Mask);
       _jobDataStartTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStartTZ -> TILDA.JobView."jobDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobDataStartTZNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBDATASTARTTZ._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBDATASTARTTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBDATASTARTTZ._Mask);
       _jobDataStartTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStart -> TILDA.JobView."jobDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobDataStart")
   String  Str_jobDataStart;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_JobDataStart(String v) { Str_jobDataStart = v; }
   public String initJobDataStartVal() { return Str_jobDataStart; }
   transient ZonedDateTime _jobDataStart = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStart -> TILDA.JobView."jobDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getJobDataStart()
      { return _jobDataStart; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStart -> TILDA.JobView."jobDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobDataStartNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBDATASTART._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStart -> TILDA.JobView."jobDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobDataStart(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobDataStartNull();
        }
       else if (v.equals(_jobDataStart) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobDataStart' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBDATASTART._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBDATASTART._Mask);
       _jobDataStart = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobDataStart' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setJobDataStartTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataStart -> TILDA.JobView."jobDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobDataStartNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBDATASTART._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBDATASTART._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBDATASTART._Mask);
       _jobDataStart=null;
       setJobDataStartTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEndTZ -> TILDA.JobView."jobDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _jobDataEndTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEndTZ -> TILDA.JobView."jobDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobDataEndTZ()
      { return _jobDataEndTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEndTZ -> TILDA.JobView."jobDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobDataEndTZNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBDATAENDTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEndTZ -> TILDA.JobView."jobDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobDataEndTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobDataEndTZNull();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobDataEndTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobDataEndTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobDataEndTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBDATAENDTZ._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBDATAENDTZ._Mask);
       _jobDataEndTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEndTZ -> TILDA.JobView."jobDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobDataEndTZNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBDATAENDTZ._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBDATAENDTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBDATAENDTZ._Mask);
       _jobDataEndTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEnd -> TILDA.JobView."jobDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobDataEnd")
   String  Str_jobDataEnd;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_JobDataEnd(String v) { Str_jobDataEnd = v; }
   public String initJobDataEndVal() { return Str_jobDataEnd; }
   transient ZonedDateTime _jobDataEnd = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEnd -> TILDA.JobView."jobDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getJobDataEnd()
      { return _jobDataEnd; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEnd -> TILDA.JobView."jobDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobDataEndNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBDATAEND._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEnd -> TILDA.JobView."jobDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobDataEnd(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobDataEndNull();
        }
       else if (v.equals(_jobDataEnd) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobDataEnd' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBDATAEND._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBDATAEND._Mask);
       _jobDataEnd = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobDataEnd' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setJobDataEndTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobDataEnd -> TILDA.JobView."jobDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobDataEndNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBDATAEND._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBDATAEND._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBDATAEND._Mask);
       _jobDataEnd=null;
       setJobDataEndTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStartTZ -> TILDA.JobView."jobStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _jobStartTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStartTZ -> TILDA.JobView."jobStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobStartTZ()
      { return _jobStartTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStartTZ -> TILDA.JobView."jobStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobStartTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobStartTZ to null: it's not nullable.");
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobStartTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobStartTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobStartTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBSTARTTZ._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBSTARTTZ._Mask);
       _jobStartTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStart -> TILDA.JobView."jobStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobStart")
   String  Str_jobStart;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_JobStart(String v) { Str_jobStart = v; }
   public String initJobStartVal() { return Str_jobStart; }
   transient ZonedDateTime _jobStart = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStart -> TILDA.JobView."jobStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getJobStart()
      { return _jobStart; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStart -> TILDA.JobView."jobStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>StartTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobStart(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobStart to null: it's not nullable.");
       else if (v.equals(_jobStart) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobStart' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBSTART._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBSTART._Mask);
       _jobStart = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobStart' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setJobStartTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEndTZ -> TILDA.JobView."jobEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _jobEndTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEndTZ -> TILDA.JobView."jobEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobEndTZ()
      { return _jobEndTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEndTZ -> TILDA.JobView."jobEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobEndTZNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBENDTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEndTZ -> TILDA.JobView."jobEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobEndTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobEndTZNull();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobEndTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobEndTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobEndTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBENDTZ._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBENDTZ._Mask);
       _jobEndTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEndTZ -> TILDA.JobView."jobEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobEndTZNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBENDTZ._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBENDTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBENDTZ._Mask);
       _jobEndTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEnd -> TILDA.JobView."jobEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>EndTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobEnd")
   String  Str_jobEnd;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_JobEnd(String v) { Str_jobEnd = v; }
   public String initJobEndVal() { return Str_jobEnd; }
   transient ZonedDateTime _jobEnd = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEnd -> TILDA.JobView."jobEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>EndTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getJobEnd()
      { return _jobEnd; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEnd -> TILDA.JobView."jobEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>EndTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobEndNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBEND._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEnd -> TILDA.JobView."jobEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>EndTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobEnd(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobEndNull();
        }
       else if (v.equals(_jobEnd) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobEnd' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBEND._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBEND._Mask);
       _jobEnd = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobEnd' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setJobEndTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobEnd -> TILDA.JobView."jobEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>EndTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobEndNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBEND._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBEND._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBEND._Mask);
       _jobEnd=null;
       setJobEndTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStatus -> TILDA.JobView."jobStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobStatus")
   Boolean _jobStatus=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStatus -> TILDA.JobView."jobStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getJobStatus()
      { return _jobStatus==null?false:_jobStatus; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStatus -> TILDA.JobView."jobStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobStatusNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBSTATUS._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStatus -> TILDA.JobView."jobStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobStatus(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _jobStatus == null || v != _jobStatus)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobStatus' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBSTATUS._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBSTATUS._Mask);
       _jobStatus = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobStatus -> TILDA.JobView."jobStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobStatusNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBSTATUS._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBSTATUS._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBSTATUS._Mask);
       _jobStatus=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobMsg -> TILDA.JobView."jobMsg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobMsg of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobMsg of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobMsg</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobMsg")
   String _jobMsg=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobMsg -> TILDA.JobView."jobMsg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobMsg of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobMsg of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobMsg</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobMsg()
      { return _jobMsg; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobMsg -> TILDA.JobView."jobMsg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobMsg of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobMsg of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobMsg</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobMsgNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBMSG._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobMsg -> TILDA.JobView."jobMsg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobMsg of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobMsg of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobMsg</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobMsg(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobMsgNull();
        }
       else if (v.length() > 8192)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobMsg: the size "+v.length()+" is larger than the max allowed of 8192: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobMsg) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobMsg' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBMSG._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBMSG._Mask);
       _jobMsg = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobMsg -> TILDA.JobView."jobMsg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobMsg of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobMsg of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobMsg</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobMsgNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBMSG._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBMSG._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBMSG._Mask);
       _jobMsg=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartName -> TILDA.JobView."jobPartName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartName of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobPartName")
   String _jobPartName=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartName -> TILDA.JobView."jobPartName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartName of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobPartName()
      { return _jobPartName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartName -> TILDA.JobView."jobPartName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part name</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartName of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartName to null: it's not nullable.");
       else if (v.length() > 250)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartName: the size "+v.length()+" is larger than the max allowed of 250: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobPartName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTNAME._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTNAME._Mask);
       _jobPartName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartType -> TILDA.JobView."jobPartType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobPartType")
   String _jobPartType=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartType -> TILDA.JobView."jobPartType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobPartType()
      { return _jobPartType; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartType -> TILDA.JobView."jobPartType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobPartTypeNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTTYPE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartType -> TILDA.JobView."jobPartType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartType(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobPartTypeNull();
        }
       else if (v.length() > 250)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartType: the size "+v.length()+" is larger than the max allowed of 250: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobPartType) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartType' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTTYPE._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTTYPE._Mask);
       _jobPartType = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartType -> TILDA.JobView."jobPartType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartType of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part type</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartType of type varchar(250)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartType</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartTypeNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTTYPE._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTTYPE._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTTYPE._Mask);
       _jobPartType=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStartTZ -> TILDA.JobView."jobPartDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _jobPartDataStartTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStartTZ -> TILDA.JobView."jobPartDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobPartDataStartTZ()
      { return _jobPartDataStartTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStartTZ -> TILDA.JobView."jobPartDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobPartDataStartTZNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTARTTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStartTZ -> TILDA.JobView."jobPartDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartDataStartTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobPartDataStartTZNull();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartDataStartTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobPartDataStartTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartDataStartTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTARTTZ._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTARTTZ._Mask);
       _jobPartDataStartTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStartTZ -> TILDA.JobView."jobPartDataStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartDataStartTZNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTARTTZ._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTARTTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTARTTZ._Mask);
       _jobPartDataStartTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStart -> TILDA.JobView."jobPartDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobPartDataStart")
   String  Str_jobPartDataStart;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_JobPartDataStart(String v) { Str_jobPartDataStart = v; }
   public String initJobPartDataStartVal() { return Str_jobPartDataStart; }
   transient ZonedDateTime _jobPartDataStart = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStart -> TILDA.JobView."jobPartDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getJobPartDataStart()
      { return _jobPartDataStart; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStart -> TILDA.JobView."jobPartDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobPartDataStartNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTART._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStart -> TILDA.JobView."jobPartDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartDataStart(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobPartDataStartNull();
        }
       else if (v.equals(_jobPartDataStart) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartDataStart' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTART._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTART._Mask);
       _jobPartDataStart = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartDataStart' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setJobPartDataStartTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataStart -> TILDA.JobView."jobPartDataStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartDataStartNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTART._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTART._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTART._Mask);
       _jobPartDataStart=null;
       setJobPartDataStartTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEndTZ -> TILDA.JobView."jobPartDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _jobPartDataEndTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEndTZ -> TILDA.JobView."jobPartDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobPartDataEndTZ()
      { return _jobPartDataEndTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEndTZ -> TILDA.JobView."jobPartDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobPartDataEndTZNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAENDTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEndTZ -> TILDA.JobView."jobPartDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartDataEndTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobPartDataEndTZNull();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartDataEndTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobPartDataEndTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartDataEndTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAENDTZ._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAENDTZ._Mask);
       _jobPartDataEndTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEndTZ -> TILDA.JobView."jobPartDataEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartDataEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartDataEndTZNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAENDTZ._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAENDTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAENDTZ._Mask);
       _jobPartDataEndTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEnd -> TILDA.JobView."jobPartDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobPartDataEnd")
   String  Str_jobPartDataEnd;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_JobPartDataEnd(String v) { Str_jobPartDataEnd = v; }
   public String initJobPartDataEndVal() { return Str_jobPartDataEnd; }
   transient ZonedDateTime _jobPartDataEnd = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEnd -> TILDA.JobView."jobPartDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getJobPartDataEnd()
      { return _jobPartDataEnd; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEnd -> TILDA.JobView."jobPartDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobPartDataEndNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAEND._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEnd -> TILDA.JobView."jobPartDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartDataEnd(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobPartDataEndNull();
        }
       else if (v.equals(_jobPartDataEnd) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartDataEnd' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAEND._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAEND._Mask);
       _jobPartDataEnd = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartDataEnd' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setJobPartDataEndTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartDataEnd -> TILDA.JobView."jobPartDataEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartDataEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part data end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartDataEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartDataEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartDataEndNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAEND._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAEND._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAEND._Mask);
       _jobPartDataEnd=null;
       setJobPartDataEndTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStartTZ -> TILDA.JobView."jobPartStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _jobPartStartTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStartTZ -> TILDA.JobView."jobPartStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobPartStartTZ()
      { return _jobPartStartTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStartTZ -> TILDA.JobView."jobPartStartTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStartTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartStart'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStartTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStartTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartStartTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartStartTZ to null: it's not nullable.");
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartStartTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobPartStartTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartStartTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTARTTZ._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTARTTZ._Mask);
       _jobPartStartTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStart -> TILDA.JobView."jobPartStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobPartStart")
   String  Str_jobPartStart;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_JobPartStart(String v) { Str_jobPartStart = v; }
   public String initJobPartStartVal() { return Str_jobPartStart; }
   transient ZonedDateTime _jobPartStart = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStart -> TILDA.JobView."jobPartStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getJobPartStart()
      { return _jobPartStart; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStart -> TILDA.JobView."jobPartStart"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStart of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution start</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStart of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStart</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartStart(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartStart to null: it's not nullable.");
       else if (v.equals(_jobPartStart) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartStart' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTART._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTART._Mask);
       _jobPartStart = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartStart' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setJobPartStartTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEndTZ -> TILDA.JobView."jobPartEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _jobPartEndTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEndTZ -> TILDA.JobView."jobPartEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobPartEndTZ()
      { return _jobPartEndTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEndTZ -> TILDA.JobView."jobPartEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobPartEndTZNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTENDTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEndTZ -> TILDA.JobView."jobPartEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartEndTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobPartEndTZNull();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartEndTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobPartEndTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartEndTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTENDTZ._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTENDTZ._Mask);
       _jobPartEndTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEndTZ -> TILDA.JobView."jobPartEndTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEndTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'jobPartEnd'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEndTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEndTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartEndTZNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTENDTZ._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTENDTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTENDTZ._Mask);
       _jobPartEndTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEnd -> TILDA.JobView."jobPartEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobPartEnd")
   String  Str_jobPartEnd;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_JobPartEnd(String v) { Str_jobPartEnd = v; }
   public String initJobPartEndVal() { return Str_jobPartEnd; }
   transient ZonedDateTime _jobPartEnd = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEnd -> TILDA.JobView."jobPartEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getJobPartEnd()
      { return _jobPartEnd; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEnd -> TILDA.JobView."jobPartEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobPartEndNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTEND._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEnd -> TILDA.JobView."jobPartEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartEnd(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setJobPartEndNull();
        }
       else if (v.equals(_jobPartEnd) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartEnd' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTEND._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTEND._Mask);
       _jobPartEnd = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartEnd' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setJobPartEndTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartEnd -> TILDA.JobView."jobPartEnd"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartEnd of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job part execution end</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartEnd of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartEnd</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartEndNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTEND._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTEND._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTEND._Mask);
       _jobPartEnd=null;
       setJobPartEndTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartRecordsCount -> TILDA.JobView."jobPartRecordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartRecordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartRecordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartRecordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobPartRecordsCount")
   Integer _jobPartRecordsCount=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartRecordsCount -> TILDA.JobView."jobPartRecordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartRecordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartRecordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartRecordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getJobPartRecordsCount()
      { return _jobPartRecordsCount==null?0:_jobPartRecordsCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartRecordsCount -> TILDA.JobView."jobPartRecordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartRecordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartRecordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartRecordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobPartRecordsCountNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTRECORDSCOUNT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartRecordsCount -> TILDA.JobView."jobPartRecordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartRecordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartRecordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartRecordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartRecordsCount(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _jobPartRecordsCount == null || v != _jobPartRecordsCount)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartRecordsCount' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTRECORDSCOUNT._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTRECORDSCOUNT._Mask);
       _jobPartRecordsCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartRecordsCount -> TILDA.JobView."jobPartRecordsCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartRecordsCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>count of database or file or ... records.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartRecordsCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartRecordsCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartRecordsCountNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTRECORDSCOUNT._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTRECORDSCOUNT._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTRECORDSCOUNT._Mask);
       _jobPartRecordsCount=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStatus -> TILDA.JobView."jobPartStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobPartStatus")
   Boolean _jobPartStatus=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStatus -> TILDA.JobView."jobPartStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getJobPartStatus()
      { return _jobPartStatus==null?false:_jobPartStatus; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStatus -> TILDA.JobView."jobPartStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isJobPartStatusNull()
     { return __Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTATUS._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStatus -> TILDA.JobView."jobPartStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartStatus(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _jobPartStatus == null || v != _jobPartStatus)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartStatus' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTATUS._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTATUS._Mask);
       _jobPartStatus = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartStatus -> TILDA.JobView."jobPartStatus"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartStatus of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status flag, i.e., success=true and failure-false</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartStatus of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartStatus</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartStatusNull()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTATUS._Mask);
       if (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTATUS._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTATUS._Mask);
       _jobPartStatus=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartNotify -> TILDA.JobView."jobPartNotify"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartNotify of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Notification flag</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartNotify of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartNotify</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobPartNotify")
   Boolean _jobPartNotify=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartNotify -> TILDA.JobView."jobPartNotify"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartNotify of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Notification flag</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartNotify of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartNotify</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getJobPartNotify()
      { return _jobPartNotify==null?false:_jobPartNotify; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartNotify -> TILDA.JobView."jobPartNotify"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartNotify of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Notification flag</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartNotify of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartNotify</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartNotify(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _jobPartNotify == null || v != _jobPartNotify)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartNotify' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTNOTIFY._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTNOTIFY._Mask);
       _jobPartNotify = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartMessage -> TILDA.JobView."jobPartMessage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartMessage of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartMessage of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartMessage</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("jobPartMessage")
   String _jobPartMessage=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartMessage -> TILDA.JobView."jobPartMessage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartMessage of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartMessage of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartMessage</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getJobPartMessage()
      { return _jobPartMessage; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JobView.jobPartMessage -> TILDA.JobView."jobPartMessage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>jobPartMessage of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Message details</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JobView.jobPartMessage of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.JobView.jobPartMessage</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>8192</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setJobPartMessage(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartMessage to null: it's not nullable.");
       else if (v.length() > 8192)
        throw new Exception("Cannot set tilda.data.TILDA.JobView.jobPartMessage: the size "+v.length()+" is larger than the max allowed of 8192: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_jobPartMessage) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.JobView.jobPartMessage' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTMESSAGE._Mask);
          __Nulls.andNot(TILDA__JOBVIEW_Factory.COLS.JOBPARTMESSAGE._Mask);
       _jobPartMessage = v;
        }
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
        throw new Exception("This TILDA.JobView object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.JobView object has already been read.");
          QueryDetails.setLastQuery(TILDA__JOBVIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__JOBVIEW_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "JobView");
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
       QueryDetails.setLastQuery(TILDA__JOBVIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.JobView", Q, toString());
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
          tilda.data._Tilda.TILDA__2_3.handleFinally(PS, T0, TILDA__JOBVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                                    _jobRefnum           =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBREFNUM._Mask          ); _jobRefnum = null; }
                                    _jobName             = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBNAME._Mask            ); _jobName = null; }
                                    _jobType             = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBTYPE._Mask            ); _jobType = null; }
                                    _jobUserId           = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBUSERID._Mask          ); _jobUserId = null; }
                                    _jobDataStartTZ      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBDATASTARTTZ._Mask     ); _jobDataStartTZ = null; } else _jobDataStartTZ      = _jobDataStartTZ     .trim();
                                    _jobDataStart        = processZDT(_jobDataStartTZ       , "tilda.data.TILDA.JobView.jobDataStart"       , RS, ++i, TILDA__JOBVIEW_Factory.COLS.JOBDATASTART       , TILDA__JOBVIEW_Factory.COLS.JOBDATASTARTTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBDATASTART._Mask       ); _jobDataStart = null; }
                                    _jobDataEndTZ        = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBDATAENDTZ._Mask       ); _jobDataEndTZ = null; } else _jobDataEndTZ        = _jobDataEndTZ       .trim();
                                    _jobDataEnd          = processZDT(_jobDataEndTZ         , "tilda.data.TILDA.JobView.jobDataEnd"         , RS, ++i, TILDA__JOBVIEW_Factory.COLS.JOBDATAEND         , TILDA__JOBVIEW_Factory.COLS.JOBDATAENDTZ         ); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBDATAEND._Mask         ); _jobDataEnd = null; }
                                    _jobStartTZ          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBSTARTTZ._Mask         ); _jobStartTZ = null; } else _jobStartTZ          = _jobStartTZ         .trim();
                                    _jobStart            = processZDT(_jobStartTZ           , "tilda.data.TILDA.JobView.jobStart"           , RS, ++i, TILDA__JOBVIEW_Factory.COLS.JOBSTART           , TILDA__JOBVIEW_Factory.COLS.JOBSTARTTZ           ); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBSTART._Mask           ); _jobStart = null; }
                                    _jobEndTZ            = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBENDTZ._Mask           ); _jobEndTZ = null; } else _jobEndTZ            = _jobEndTZ           .trim();
                                    _jobEnd              = processZDT(_jobEndTZ             , "tilda.data.TILDA.JobView.jobEnd"             , RS, ++i, TILDA__JOBVIEW_Factory.COLS.JOBEND             , TILDA__JOBVIEW_Factory.COLS.JOBENDTZ             ); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBEND._Mask             ); _jobEnd = null; }
                                    _jobStatus           =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBSTATUS._Mask          ); _jobStatus = null; }
                                    _jobMsg              = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBMSG._Mask             ); _jobMsg = null; }
                                    _jobPartName         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTNAME._Mask        ); _jobPartName = null; }
                                    _jobPartType         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTTYPE._Mask        ); _jobPartType = null; }
                                    _jobPartDataStartTZ  = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTARTTZ._Mask ); _jobPartDataStartTZ = null; } else _jobPartDataStartTZ  = _jobPartDataStartTZ .trim();
                                    _jobPartDataStart    = processZDT(_jobPartDataStartTZ   , "tilda.data.TILDA.JobView.jobPartDataStart"   , RS, ++i, TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTART   , TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTARTTZ   ); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTART._Mask   ); _jobPartDataStart = null; }
                                    _jobPartDataEndTZ    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAENDTZ._Mask   ); _jobPartDataEndTZ = null; } else _jobPartDataEndTZ    = _jobPartDataEndTZ   .trim();
                                    _jobPartDataEnd      = processZDT(_jobPartDataEndTZ     , "tilda.data.TILDA.JobView.jobPartDataEnd"     , RS, ++i, TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAEND     , TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAENDTZ     ); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAEND._Mask     ); _jobPartDataEnd = null; }
                                    _jobPartStartTZ      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTARTTZ._Mask     ); _jobPartStartTZ = null; } else _jobPartStartTZ      = _jobPartStartTZ     .trim();
                                    _jobPartStart        = processZDT(_jobPartStartTZ       , "tilda.data.TILDA.JobView.jobPartStart"       , RS, ++i, TILDA__JOBVIEW_Factory.COLS.JOBPARTSTART       , TILDA__JOBVIEW_Factory.COLS.JOBPARTSTARTTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTART._Mask       ); _jobPartStart = null; }
                                    _jobPartEndTZ        = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTENDTZ._Mask       ); _jobPartEndTZ = null; } else _jobPartEndTZ        = _jobPartEndTZ       .trim();
                                    _jobPartEnd          = processZDT(_jobPartEndTZ         , "tilda.data.TILDA.JobView.jobPartEnd"         , RS, ++i, TILDA__JOBVIEW_Factory.COLS.JOBPARTEND         , TILDA__JOBVIEW_Factory.COLS.JOBPARTENDTZ         ); if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTEND._Mask         ); _jobPartEnd = null; }
                                    _jobPartRecordsCount =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTRECORDSCOUNT._Mask); _jobPartRecordsCount = null; }
                                    _jobPartStatus       =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTATUS._Mask      ); _jobPartStatus = null; }
                                    _jobPartNotify       =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTNOTIFY._Mask      ); _jobPartNotify = null; }
                                    _jobPartMessage      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__JOBVIEW_Factory.COLS.JOBPARTMESSAGE._Mask     ); _jobPartMessage = null; }
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
                   "jobRefnum: "                                                                                                        +                                   getJobRefnum          ()
               + "; jobName: "                                                                                                          + TextUtil.printVariableStr        (getJobName            ())
               + "; jobType"               + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBTYPE._Mask            ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getJobType            ()))
               + "; jobUserId"             + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBUSERID._Mask          ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getJobUserId          ()))
               + "; jobDataStart"          + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBDATASTART._Mask       ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getJobDataStart       ()))
               + "; jobDataEnd"            + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBDATAEND._Mask         ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getJobDataEnd         ()))
               + "; jobStart: "                                                                                                         + DateTimeUtil.printDateTimeForJSON(getJobStart           ())
               + "; jobEnd"                + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBEND._Mask             ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getJobEnd             ()))
               + "; jobStatus"             + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBSTATUS._Mask          ) == true ? ": NULL" : ": " +                                   getJobStatus          ())
               + "; jobMsg"                + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBMSG._Mask             ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getJobMsg             ()))
               + "; jobPartName: "                                                                                                      + TextUtil.printVariableStr        (getJobPartName        ())
               + "; jobPartType"           + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTTYPE._Mask        ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getJobPartType        ()))
               + "; jobPartDataStart"      + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATASTART._Mask   ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getJobPartDataStart   ()))
               + "; jobPartDataEnd"        + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTDATAEND._Mask     ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getJobPartDataEnd     ()))
               + "; jobPartStart: "                                                                                                     + DateTimeUtil.printDateTimeForJSON(getJobPartStart       ())
               + "; jobPartEnd"            + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTEND._Mask         ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getJobPartEnd         ()))
               + "; jobPartRecordsCount"   + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTRECORDSCOUNT._Mask) == true ? ": NULL" : ": " +                                   getJobPartRecordsCount())
               + "; jobPartStatus"         + (__Nulls.intersects(TILDA__JOBVIEW_Factory.COLS.JOBPARTSTATUS._Mask      ) == true ? ": NULL" : ": " +                                   getJobPartStatus      ())
               + "; jobPartNotify: "                                                                                                    +                                   getJobPartNotify      ()
               + "; jobPartMessage: "                                                                                                   + TextUtil.printVariableStr        (getJobPartMessage     ())
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
          case "": tilda.data.JobView_Factory.toJSON(out, (tilda.data.JobView_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data.JobView_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data.JobView_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data.JobView_Factory.toCSV(out, (tilda.data.JobView_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data.JobView_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data.JobView_Factory");
    }
 }
