/*
 Tilda V2.5 data object.

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
<TABLE id="TestingTimestampsView_DIV" class="tables">
<SCRIPT>registerStickyHeader("TestingTimestampsView_DIV");</SCRIPT>
<TR valign="top"><TD><H2>TestingTimestampsView&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#TestingTimestampsView_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="TestingTimestampsView_CNT" class="content">
The View TILDATEST.TestingTimestampsView :<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>TestingTimestampsView_Factory</B>, <B>TestingTimestampsView_Data</B> in the package <B>tilda.data_test</B>.
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Defines 4 foreign key(s):<BR>
<TABLE style="margin-left: 25px; border:1px solid #BBB;" cellspacing="0px" cellpadding="5px" border="0px">
<TR style="background-color:#DDD; font-weight:bold;"><TD></TD><TD>Source Columns</TD><TD>Destination Object</TD><TD>Destination Columns</TD><TD>Notes</TD></TR>
<TR ><TD>1</TD><TD>dt1_firstTZ</TD><TD><A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A></TD><TD>id</TD><TD>&nbsp;</TD></TR>
</TABLE></LI>
</UL>
<B>Description</B>:<BLOCKQUOTE style="border-left: 1px solid #EEE;padding-left: 5px;">A test view to test aggregates.</BLOCKQUOTE>
<BR>
This view depends on the following filter(s), sub-view(s), and/or root table(s):
<BLOCKQUOTE><TABLE class="TreeTable Rowed" border="0px" cellspacing="0px" cellpadding="2px"><TR><TD><PRE><A href="TILDA___Docs.TILDATEST.html#TestingTimestampsView_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestampsView</A></PRE></TD><TD><PRE>Unfiltered</PRE></TD></TR>
<TR><TD><PRE>    <A href="TILDA___Docs.TILDATEST.html#TestingTimestamps_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps</A></PRE></TD><TD><PRE>Root table for the view TILDATEST.TestingTimestampsView</PRE></TD></TR>
</TABLE></BLOCKQUOTE>
This View contains the following columns:<BLOCKQUOTE>
 <TABLE id="TestingTimestampsView_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid #BBB;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">TZ</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-id_DIV' class='columns'>id</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(20)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Medical system unique enterprise id<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-id_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>id</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt1_max_DIV' class='columns'>dt1_max</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt1_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt1</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt2_max_DIV' class='columns'>dt2_max</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt2_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt2</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt1_firstTZ_DIV' class='columns'>dt1_firstTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dt1_first'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt1TZ_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt1TZ</A><BR>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo-id_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo<B>&nbsp;&#8226;&nbsp;</B>id</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt1_first_DIV' class='columns'>dt1_first</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center"><SPAN style="font-weight:bold;font-size:10px">COLUMN</SPAN>&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt1_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt1</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2_DIV' class='columns'>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt2_first.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt2_first_DIV' class='columns'>dt2_first</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center"><SPAN style="font-weight:bold;font-size:10px">ROW</SPAN>&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt2_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt2</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt3_firstTZ_DIV' class='columns'>dt3_firstTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dt3_first'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt3TZ_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt3TZ</A><BR>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo-id_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo<B>&nbsp;&#8226;&nbsp;</B>id</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt3_first_DIV' class='columns'>dt3_first</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamp&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center"><SPAN style="font-weight:bold;font-size:10px">COLUMN_NO_TZ</SPAN>&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt3_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt3</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4_DIV' class='columns'>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt4_first.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt4_first_DIV' class='columns'>dt4_first</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamp&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center"><SPAN style="font-weight:bold;font-size:10px">ROW_NO_TZ</SPAN>&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt4_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt4</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt1_cnt_DIV' class='columns'>dt1_cnt</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt1_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt1</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt2_cnt_DIV' class='columns'>dt2_cnt</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt2_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt2</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt3_cnt_DIV' class='columns'>dt3_cnt</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt3_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt3</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt4_cnt_DIV' class='columns'>dt4_cnt</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt4_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt4</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt1_arr_DIV' class='columns'>dt1_arr</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt1_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt1</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt2_arr_DIV' class='columns'>dt2_arr</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt2_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt2</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt3_arr_DIV' class='columns'>dt3_arr</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt3_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt3</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt4_arr_DIV' class='columns'>dt4_arr</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt4_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt4</A></DIV></TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TESTINGTIMESTAMPSVIEW implements tilda.interfaces.ReaderObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__TESTINGTIMESTAMPSVIEW.class.getName());

   public transient static final Class<TILDA__TESTINGTIMESTAMPSVIEW_Factory> FACTORY_CLASS= TILDA__TESTINGTIMESTAMPSVIEW_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDATEST.TestingTimestampsView", "");

   protected TILDA__TESTINGTIMESTAMPSVIEW() { }

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
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.id -> TILDATEST.TestingTimestampsView."id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>id of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.id of type varchar(20)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.id</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>20</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("id")
   String _id=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.id -> TILDATEST.TestingTimestampsView."id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>id of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.id of type varchar(20)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.id</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>20</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getId()
      { return _id; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.id -> TILDATEST.TestingTimestampsView."id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>id of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.id of type varchar(20)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.id</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>20</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setId(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestampsView.id to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 20)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestampsView.id: the size "+v.length()+" is larger than the max allowed of 20: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_id) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.id' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ID._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ID._Mask);
       _id = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max -> TILDATEST.TestingTimestampsView."dt1_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt1_max")
   String  Str_dt1_max;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt1_max(String v) { Str_dt1_max = v; }
   public String initDt1_maxVal() { return Str_dt1_max; }
   transient ZonedDateTime _dt1_max = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max -> TILDATEST.TestingTimestampsView."dt1_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDt1_max()
      { return _dt1_max; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max -> TILDATEST.TestingTimestampsView."dt1_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt1_max()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_MAX._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max -> TILDATEST.TestingTimestampsView."dt1_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt1_max(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt1_max();
        }
       else if (v.equals(_dt1_max) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_MAX._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_MAX._Mask);
       _dt1_max = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max -> TILDATEST.TestingTimestampsView."dt1_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt1_max()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_MAX._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_MAX._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_MAX._Mask);
       _dt1_max=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max -> TILDATEST.TestingTimestampsView."dt2_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt2_max")
   String  Str_dt2_max;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt2_max(String v) { Str_dt2_max = v; }
   public String initDt2_maxVal() { return Str_dt2_max; }
   transient ZonedDateTime _dt2_max = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max -> TILDATEST.TestingTimestampsView."dt2_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDt2_max()
      { return _dt2_max; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max -> TILDATEST.TestingTimestampsView."dt2_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt2_max()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_MAX._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max -> TILDATEST.TestingTimestampsView."dt2_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt2_max(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt2_max();
        }
       else if (v.equals(_dt2_max) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_MAX._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_MAX._Mask);
       _dt2_max = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max -> TILDATEST.TestingTimestampsView."dt2_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_max of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt2_max()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_MAX._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_MAX._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_MAX._Mask);
       _dt2_max=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ -> TILDATEST.TestingTimestampsView."dt1_firstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_firstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1_first'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_firstTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _dt1_firstTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ -> TILDATEST.TestingTimestampsView."dt1_firstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_firstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1_first'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_firstTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDt1_firstTZ()
      { return _dt1_firstTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ -> TILDATEST.TestingTimestampsView."dt1_firstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_firstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1_first'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_firstTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt1_firstTZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRSTTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ -> TILDATEST.TestingTimestampsView."dt1_firstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_firstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1_first'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_firstTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt1_firstTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt1_firstTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dt1_firstTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRSTTZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRSTTZ._Mask);
       _dt1_firstTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ -> TILDATEST.TestingTimestampsView."dt1_firstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_firstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1_first'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_firstTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_firstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt1_firstTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRSTTZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRSTTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRSTTZ._Mask);
       _dt1_firstTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first -> TILDATEST.TestingTimestampsView."dt1_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_first of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dt1_firstTZ'</LI>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt1_first")
   String  Str_dt1_first;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt1_first(String v) { Str_dt1_first = v; }
   public String initDt1_firstVal() { return Str_dt1_first; }
   transient ZonedDateTime _dt1_first = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first -> TILDATEST.TestingTimestampsView."dt1_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_first of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dt1_firstTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt1_first()
      { return _dt1_first; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first -> TILDATEST.TestingTimestampsView."dt1_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_first of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dt1_firstTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt1_first()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRST._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first -> TILDATEST.TestingTimestampsView."dt1_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_first of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dt1_firstTZ'</LI>
</TD></TR>

</TABLE>
*/
    void setDt1_first(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt1_first();
        }
       else if (v.equals(_dt1_first) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRST._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRST._Mask);
       _dt1_first = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt1_firstTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first -> TILDATEST.TestingTimestampsView."dt1_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_first of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'dt1_firstTZ'</LI>
</TD></TR>

</TABLE>
*/
    void setNullDt1_first()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRST._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRST._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRST._Mask);
       _dt1_first=null;
       setNullDt1_firstTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 -> TILDATEST.TestingTimestampsView."rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt2_first.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 -> TILDATEST.TestingTimestampsView."rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt2_first.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2()
      { return _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 -> TILDATEST.TestingTimestampsView."rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt2_first.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 -> TILDATEST.TestingTimestampsView."rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt2_first.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2) == false)
        {
           // This is a rowTZ setter, so needs additional logic because it is shared across possibly multipel columns.
           // Here, we need to check that there is no inconsistency, i.e., setRowTZ i sbeing called with a different value than already set.
           if (TextUtil.isNullOrEmpty(_rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2) == false)
            throw new Exception("Cannot change a rowTZ column once set. It is currently '"+_rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2+"' and the new value is '"+v+"'.");
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT2._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT2._Mask);
       _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 -> TILDATEST.TestingTimestampsView."rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt2_first.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2()
     {
       long T0 = System.nanoTime();
       // This is a rowTZ null setter, so needs additional logic because it is shared across possibly multipel columns.
       // Only set to NULL if all rowTz columns are also null.
       boolean allRowTxColsAreNull = true;
       if (_dt2_first != null) allRowTxColsAreNull = false;
       else if (_dt4_first != null) allRowTxColsAreNull = false;
       if (allRowTxColsAreNull == false)
        return;
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT2._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT2._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT2._Mask);
       _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first -> TILDATEST.TestingTimestampsView."dt2_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_first of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2'</LI>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt2_first")
   String  Str_dt2_first;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt2_first(String v) { Str_dt2_first = v; }
   public String initDt2_firstVal() { return Str_dt2_first; }
   transient ZonedDateTime _dt2_first = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first -> TILDATEST.TestingTimestampsView."dt2_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_first of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2'</LI>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt2_first()
      { return _dt2_first; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first -> TILDATEST.TestingTimestampsView."dt2_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_first of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2'</LI>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt2_first()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_FIRST._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first -> TILDATEST.TestingTimestampsView."dt2_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_first of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2'</LI>
</TD></TR>

</TABLE>
*/
    void setDt2_first(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt2_first();
        }
       else if (v.equals(_dt2_first) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_FIRST._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_FIRST._Mask);
       _dt2_first = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first -> TILDATEST.TestingTimestampsView."dt2_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_first of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2'</LI>
</TD></TR>

</TABLE>
*/
    void setNullDt2_first()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_FIRST._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_FIRST._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_FIRST._Mask);
       _dt2_first=null;
    // setNullRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2(); // row TZs are shared, so can't just null it!
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ -> TILDATEST.TestingTimestampsView."dt3_firstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_firstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3_first'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_firstTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _dt3_firstTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ -> TILDATEST.TestingTimestampsView."dt3_firstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_firstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3_first'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_firstTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDt3_firstTZ()
      { return _dt3_firstTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ -> TILDATEST.TestingTimestampsView."dt3_firstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_firstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3_first'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_firstTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt3_firstTZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRSTTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ -> TILDATEST.TestingTimestampsView."dt3_firstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_firstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3_first'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_firstTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt3_firstTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt3_firstTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dt3_firstTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRSTTZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRSTTZ._Mask);
       _dt3_firstTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ -> TILDATEST.TestingTimestampsView."dt3_firstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_firstTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3_first'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_firstTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_firstTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt3_firstTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRSTTZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRSTTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRSTTZ._Mask);
       _dt3_firstTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first -> TILDATEST.TestingTimestampsView."dt3_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_first of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp without timezone</LI>
<LI>Timezone information stored in 'dt3_firstTZ'</LI>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt3_first")
   String  Str_dt3_first;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt3_first(String v) { Str_dt3_first = v; }
   public String initDt3_firstVal() { return Str_dt3_first; }
   transient ZonedDateTime _dt3_first = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first -> TILDATEST.TestingTimestampsView."dt3_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_first of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp without timezone</LI>
<LI>Timezone information stored in 'dt3_firstTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt3_first()
      { return _dt3_first; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first -> TILDATEST.TestingTimestampsView."dt3_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_first of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp without timezone</LI>
<LI>Timezone information stored in 'dt3_firstTZ'</LI>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt3_first()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRST._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first -> TILDATEST.TestingTimestampsView."dt3_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_first of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp without timezone</LI>
<LI>Timezone information stored in 'dt3_firstTZ'</LI>
</TD></TR>

</TABLE>
*/
    void setDt3_first(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt3_first();
        }
       else if (v.equals(_dt3_first) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRST._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRST._Mask);
       _dt3_first = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt3_firstTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first -> TILDATEST.TestingTimestampsView."dt3_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_first of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp without timezone</LI>
<LI>Timezone information stored in 'dt3_firstTZ'</LI>
</TD></TR>

</TABLE>
*/
    void setNullDt3_first()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRST._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRST._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRST._Mask);
       _dt3_first=null;
       setNullDt3_firstTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 -> TILDATEST.TestingTimestampsView."rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt4_first.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 -> TILDATEST.TestingTimestampsView."rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt4_first.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4()
      { return _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 -> TILDATEST.TestingTimestampsView."rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt4_first.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 -> TILDATEST.TestingTimestampsView."rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt4_first.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT4._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT4._Mask);
       _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 -> TILDATEST.TestingTimestampsView."rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestampsView row level: dt4_first.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT4._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT4._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT4._Mask);
       _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first -> TILDATEST.TestingTimestampsView."dt4_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_first of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp without timezone</LI>
<LI>Timezone information stored in 'rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4'</LI>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt4_first")
   String  Str_dt4_first;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt4_first(String v) { Str_dt4_first = v; }
   public String initDt4_firstVal() { return Str_dt4_first; }
   transient ZonedDateTime _dt4_first = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first -> TILDATEST.TestingTimestampsView."dt4_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_first of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp without timezone</LI>
<LI>Timezone information stored in 'rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4'</LI>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt4_first()
      { return _dt4_first; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first -> TILDATEST.TestingTimestampsView."dt4_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_first of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp without timezone</LI>
<LI>Timezone information stored in 'rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4'</LI>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt4_first()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_FIRST._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first -> TILDATEST.TestingTimestampsView."dt4_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_first of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp without timezone</LI>
<LI>Timezone information stored in 'rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4'</LI>
</TD></TR>

</TABLE>
*/
    void setDt4_first(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt4_first();
        }
       else if (v.equals(_dt4_first) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_FIRST._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_FIRST._Mask);
       _dt4_first = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first -> TILDATEST.TestingTimestampsView."dt4_first"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_first of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_first of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp without timezone</LI>
<LI>Timezone information stored in 'rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4'</LI>
</TD></TR>

</TABLE>
*/
    void setNullDt4_first()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_FIRST._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_FIRST._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_FIRST._Mask);
       _dt4_first=null;
    // setNullRowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4(); // row TZs are shared, so can't just null it!
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt -> TILDATEST.TestingTimestampsView."dt1_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt1_cnt")
   Long _dt1_cnt=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt -> TILDATEST.TestingTimestampsView."dt1_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getDt1_cnt()
      { return _dt1_cnt==null?0l:_dt1_cnt; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt -> TILDATEST.TestingTimestampsView."dt1_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt1_cnt()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_CNT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt -> TILDATEST.TestingTimestampsView."dt1_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt1_cnt(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _dt1_cnt == null || v != _dt1_cnt)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_CNT._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_CNT._Mask);
       _dt1_cnt = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt -> TILDATEST.TestingTimestampsView."dt1_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt1_cnt()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_CNT._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_CNT._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_CNT._Mask);
       _dt1_cnt=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt -> TILDATEST.TestingTimestampsView."dt2_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt2_cnt")
   Long _dt2_cnt=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt -> TILDATEST.TestingTimestampsView."dt2_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getDt2_cnt()
      { return _dt2_cnt==null?0l:_dt2_cnt; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt -> TILDATEST.TestingTimestampsView."dt2_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt2_cnt()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_CNT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt -> TILDATEST.TestingTimestampsView."dt2_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt2_cnt(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _dt2_cnt == null || v != _dt2_cnt)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_CNT._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_CNT._Mask);
       _dt2_cnt = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt -> TILDATEST.TestingTimestampsView."dt2_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt2_cnt()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_CNT._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_CNT._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_CNT._Mask);
       _dt2_cnt=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt -> TILDATEST.TestingTimestampsView."dt3_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt3_cnt")
   Long _dt3_cnt=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt -> TILDATEST.TestingTimestampsView."dt3_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getDt3_cnt()
      { return _dt3_cnt==null?0l:_dt3_cnt; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt -> TILDATEST.TestingTimestampsView."dt3_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt3_cnt()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_CNT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt -> TILDATEST.TestingTimestampsView."dt3_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt3_cnt(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _dt3_cnt == null || v != _dt3_cnt)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_CNT._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_CNT._Mask);
       _dt3_cnt = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt -> TILDATEST.TestingTimestampsView."dt3_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt3_cnt()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_CNT._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_CNT._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_CNT._Mask);
       _dt3_cnt=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt -> TILDATEST.TestingTimestampsView."dt4_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt4_cnt")
   Long _dt4_cnt=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt -> TILDATEST.TestingTimestampsView."dt4_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getDt4_cnt()
      { return _dt4_cnt==null?0l:_dt4_cnt; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt -> TILDATEST.TestingTimestampsView."dt4_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt4_cnt()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_CNT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt -> TILDATEST.TestingTimestampsView."dt4_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt4_cnt(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _dt4_cnt == null || v != _dt4_cnt)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_CNT._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_CNT._Mask);
       _dt4_cnt = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt -> TILDATEST.TestingTimestampsView."dt4_cnt"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_cnt of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_cnt of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_cnt</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt4_cnt()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_CNT._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_CNT._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_CNT._Mask);
       _dt4_cnt=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr -> TILDATEST.TestingTimestampsView."dt1_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt1_arr")
   List<String> _dt1_arr;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr -> TILDATEST.TestingTimestampsView."dt1_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getDt1_arrAsArray()
      { return _dt1_arr==null? null : _dt1_arr.toArray(new String[_dt1_arr.size()]); }
   public final Iterator<String> getDt1_arr()
      { return _dt1_arr==null? null : _dt1_arr.iterator(); }
   public final boolean hasDt1_arr(String v)
      { return _dt1_arr==null? false : _dt1_arr.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr -> TILDATEST.TestingTimestampsView."dt1_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt1_arr()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr -> TILDATEST.TestingTimestampsView."dt1_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt1_arr(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullDt1_arr();
       else if (CollectionUtil.equals(v, _dt1_arr) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask);
          if (_dt1_arr == null)
           {
             _dt1_arr = new ArrayList<String>();
           }
          else
           {
             _dt1_arr.clear();
           }
          for (String i : v)
           {
             _dt1_arr.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToDt1_arr(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt1_arr == null)
        _dt1_arr = new ArrayList<String>();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt1_arr();
        }
       else if (pos >= _dt1_arr.size() || _dt1_arr.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask);
          _dt1_arr.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt1_arr(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt1_arr.remove(v) == true)
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt1_arr(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt1_arr.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr -> TILDATEST.TestingTimestampsView."dt1_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt1_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt1_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt1_arr()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask);
       _dt1_arr=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr -> TILDATEST.TestingTimestampsView."dt2_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt2_arr")
   List<String> _dt2_arr;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr -> TILDATEST.TestingTimestampsView."dt2_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getDt2_arrAsArray()
      { return _dt2_arr==null? null : _dt2_arr.toArray(new String[_dt2_arr.size()]); }
   public final Iterator<String> getDt2_arr()
      { return _dt2_arr==null? null : _dt2_arr.iterator(); }
   public final boolean hasDt2_arr(String v)
      { return _dt2_arr==null? false : _dt2_arr.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr -> TILDATEST.TestingTimestampsView."dt2_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt2_arr()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr -> TILDATEST.TestingTimestampsView."dt2_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt2_arr(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullDt2_arr();
       else if (CollectionUtil.equals(v, _dt2_arr) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask);
          if (_dt2_arr == null)
           {
             _dt2_arr = new ArrayList<String>();
           }
          else
           {
             _dt2_arr.clear();
           }
          for (String i : v)
           {
             _dt2_arr.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToDt2_arr(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt2_arr == null)
        _dt2_arr = new ArrayList<String>();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt2_arr();
        }
       else if (pos >= _dt2_arr.size() || _dt2_arr.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask);
          _dt2_arr.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt2_arr(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt2_arr.remove(v) == true)
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt2_arr(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt2_arr.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr -> TILDATEST.TestingTimestampsView."dt2_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt2_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt2_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt2_arr()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask);
       _dt2_arr=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr -> TILDATEST.TestingTimestampsView."dt3_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt3_arr")
   List<String> _dt3_arr;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr -> TILDATEST.TestingTimestampsView."dt3_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getDt3_arrAsArray()
      { return _dt3_arr==null? null : _dt3_arr.toArray(new String[_dt3_arr.size()]); }
   public final Iterator<String> getDt3_arr()
      { return _dt3_arr==null? null : _dt3_arr.iterator(); }
   public final boolean hasDt3_arr(String v)
      { return _dt3_arr==null? false : _dt3_arr.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr -> TILDATEST.TestingTimestampsView."dt3_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt3_arr()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr -> TILDATEST.TestingTimestampsView."dt3_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt3_arr(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullDt3_arr();
       else if (CollectionUtil.equals(v, _dt3_arr) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask);
          if (_dt3_arr == null)
           {
             _dt3_arr = new ArrayList<String>();
           }
          else
           {
             _dt3_arr.clear();
           }
          for (String i : v)
           {
             _dt3_arr.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToDt3_arr(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt3_arr == null)
        _dt3_arr = new ArrayList<String>();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt3_arr();
        }
       else if (pos >= _dt3_arr.size() || _dt3_arr.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask);
          _dt3_arr.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt3_arr(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt3_arr.remove(v) == true)
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt3_arr(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt3_arr.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr -> TILDATEST.TestingTimestampsView."dt3_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt3_arr()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask);
       _dt3_arr=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr -> TILDATEST.TestingTimestampsView."dt4_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt4_arr")
   List<String> _dt4_arr;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr -> TILDATEST.TestingTimestampsView."dt4_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getDt4_arrAsArray()
      { return _dt4_arr==null? null : _dt4_arr.toArray(new String[_dt4_arr.size()]); }
   public final Iterator<String> getDt4_arr()
      { return _dt4_arr==null? null : _dt4_arr.iterator(); }
   public final boolean hasDt4_arr(String v)
      { return _dt4_arr==null? false : _dt4_arr.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr -> TILDATEST.TestingTimestampsView."dt4_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt4_arr()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr -> TILDATEST.TestingTimestampsView."dt4_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt4_arr(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullDt4_arr();
       else if (CollectionUtil.equals(v, _dt4_arr) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask);
          if (_dt4_arr == null)
           {
             _dt4_arr = new ArrayList<String>();
           }
          else
           {
             _dt4_arr.clear();
           }
          for (String i : v)
           {
             _dt4_arr.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToDt4_arr(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt4_arr == null)
        _dt4_arr = new ArrayList<String>();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt4_arr();
        }
       else if (pos >= _dt4_arr.size() || _dt4_arr.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask);
          _dt4_arr.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt4_arr(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt4_arr.remove(v) == true)
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt4_arr(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt4_arr.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr -> TILDATEST.TestingTimestampsView."dt4_arr"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_arr of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_arr of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_arr</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt4_arr()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask);
       _dt4_arr=null;
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
        throw new Exception("This TILDATEST.TestingTimestampsView object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATEST.TestingTimestampsView object has already been read.");
          QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPSVIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "TestingTimestampsView");
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
       QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPSVIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATEST.TestingTimestampsView", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
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
          tilda.data_test._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__TESTINGTIMESTAMPSVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }
    }

   @SuppressWarnings("unchecked")
   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                                                                _id                                              = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ID._Mask                                             ); _id = null; }
                                                                _dt1_max                                         = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_MAX._Mask                                        ); _dt1_max = null; }
                                                                _dt2_max                                         = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_MAX._Mask                                        ); _dt2_max = null; }
                                                                _dt1_firstTZ                                     = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRSTTZ._Mask                                    ); _dt1_firstTZ = null; } else _dt1_firstTZ                                     = _dt1_firstTZ                                    .trim();
                                                                _dt1_first                                       = JDBCHelper.processZDT(_dt1_firstTZ                                      , "tilda.data_test.TILDATEST.TestingTimestampsView.dt1_first"                                      , RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRST                                      , TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRSTTZ                                      , __Nulls); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRST._Mask                                      ); _dt1_first = null; }
                                                                _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT2._Mask); _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 = null; } else _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2 = _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2.trim();
                                                                _dt2_first                                       = JDBCHelper.processZDT(_rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt2                                      , "tilda.data_test.TILDATEST.TestingTimestampsView.dt2_first"                                      , RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_FIRST                                      , TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT2                                      , __Nulls); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_FIRST._Mask                                      ); _dt2_first = null; }
                                                                _dt3_firstTZ                                     = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRSTTZ._Mask                                    ); _dt3_firstTZ = null; } else _dt3_firstTZ                                     = _dt3_firstTZ                                    .trim();
                                                                _dt3_first                                       = JDBCHelper.processZDT(_dt3_firstTZ                                      , "tilda.data_test.TILDATEST.TestingTimestampsView.dt3_first"                                      , RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRST                                      , TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRSTTZ                                      , __Nulls); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRST._Mask                                      ); _dt3_first = null; }
                                                                _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT4._Mask); _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 = null; } else _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4 = _rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4.trim();
                                                                _dt4_first                                       = JDBCHelper.processZDT(_rowTZ_TILDATEST_TestingTimestampsView_FIRST_dt4                                      , "tilda.data_test.TILDATEST.TestingTimestampsView.dt4_first"                                      , RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_FIRST                                      , TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ROWTZ_TILDATEST_TESTINGTIMESTAMPSVIEW_FIRST_DT4                                      , __Nulls); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_FIRST._Mask                                      ); _dt4_first = null; }
                                                                _dt1_cnt                                         =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_CNT._Mask                                        ); _dt1_cnt = null; }
                                                                _dt2_cnt                                         =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_CNT._Mask                                        ); _dt2_cnt = null; }
                                                                _dt3_cnt                                         =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_CNT._Mask                                        ); _dt3_cnt = null; }
                                                                _dt4_cnt                                         =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_CNT._Mask                                        ); _dt4_cnt = null; }
                                                                _dt1_arr = (List<String>) JDBCHelper.getArray(RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask                                        ); _dt1_arr = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_dt1_arr != null && _dt1_arr.size() == 1 && _dt1_arr.get(0) == null)
                               {
                                 _dt1_arr = new ArrayList<String>();
                                 __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask);
                               }
                                                                _dt2_arr = (List<String>) JDBCHelper.getArray(RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask                                        ); _dt2_arr = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_dt2_arr != null && _dt2_arr.size() == 1 && _dt2_arr.get(0) == null)
                               {
                                 _dt2_arr = new ArrayList<String>();
                                 __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask);
                               }
                                                                _dt3_arr = (List<String>) JDBCHelper.getArray(RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask                                        ); _dt3_arr = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_dt3_arr != null && _dt3_arr.size() == 1 && _dt3_arr.get(0) == null)
                               {
                                 _dt3_arr = new ArrayList<String>();
                                 __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask);
                               }
                                                                _dt4_arr = (List<String>) JDBCHelper.getArray(RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask                                        ); _dt4_arr = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_dt4_arr != null && _dt4_arr.size() == 1 && _dt4_arr.get(0) == null)
                               {
                                 _dt4_arr = new ArrayList<String>();
                                 __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask);
                               }
     __LookupId = 0;
     __Init     = InitMode.READ;
     __Changes.clear();

     return afterRead(C);
   }

   protected abstract boolean afterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "id: "                                                                                                                                                                                     + TextUtil.printVariableStr        (getId                                             ())
               + "; dt1_max"                                           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_MAX._Mask                                        ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt1_max                                        ()))
               + "; dt2_max"                                           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_MAX._Mask                                        ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt2_max                                        ()))
               + "; dt1_first"                                         + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_FIRST._Mask                                      ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt1_first                                      ()))
               + "; dt2_first"                                         + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_FIRST._Mask                                      ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt2_first                                      ()))
               + "; dt3_first"                                         + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_FIRST._Mask                                      ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt3_first                                      ()))
               + "; dt4_first"                                         + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_FIRST._Mask                                      ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt4_first                                      ()))
               + "; dt1_cnt"                                           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_CNT._Mask                                        ) == true ? ": NULL" : ": " +                                   getDt1_cnt                                        ())
               + "; dt2_cnt"                                           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_CNT._Mask                                        ) == true ? ": NULL" : ": " +                                   getDt2_cnt                                        ())
               + "; dt3_cnt"                                           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_CNT._Mask                                        ) == true ? ": NULL" : ": " +                                   getDt3_cnt                                        ())
               + "; dt4_cnt"                                           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_CNT._Mask                                        ) == true ? ": NULL" : ": " +                                   getDt4_cnt                                        ())
               + "; dt1_arr"                                           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask                                        ) == true ? ": NULL" : ": " + TextUtil.print                   (getDt1_arr                                        ()))
               + "; dt2_arr"                                           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask                                        ) == true ? ": NULL" : ": " + TextUtil.print                   (getDt2_arr                                        ()))
               + "; dt3_arr"                                           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask                                        ) == true ? ": NULL" : ": " + TextUtil.print                   (getDt3_arr                                        ()))
               + "; dt4_arr"                                           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask                                        ) == true ? ": NULL" : ": " + TextUtil.print                   (getDt4_arr                                        ()))
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
          case "": tilda.data_test.TestingTimestampsView_Factory.toJSON(out, (tilda.data_test.TestingTimestampsView_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data_test.TestingTimestampsView_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data_test.TestingTimestampsView_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data_test.TestingTimestampsView_Factory.toCSV(out, (tilda.data_test.TestingTimestampsView_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data_test.TestingTimestampsView_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data_test.TestingTimestampsView_Factory");
    }
 }
