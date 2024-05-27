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
<TD align="right"><B id='TestingTimestampsView-dt3_max_DIV' class='columns'>dt3_max</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamp&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt3_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt3</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestampsView-dt4_max_DIV' class='columns'>dt4_max</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamp&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('TestingTimestamps-dt4_DIV', -50)">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps<B>&nbsp;&#8226;&nbsp;</B>dt4</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
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
    <TD>7&nbsp;&nbsp;</TD>
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
    <TD>8&nbsp;&nbsp;</TD>
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
    <TD>9&nbsp;&nbsp;</TD>
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
    <TD>10&nbsp;&nbsp;</TD>
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
    <TD>11&nbsp;&nbsp;</TD>
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
    <TD>12&nbsp;&nbsp;</TD>
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
    <TD>13&nbsp;&nbsp;</TD>
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
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max -> TILDATEST.TestingTimestampsView."dt3_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt3_max")
   String  Str_dt3_max;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt3_max(String v) { Str_dt3_max = v; }
   public String initDt3_maxVal() { return Str_dt3_max; }
   transient ZonedDateTime _dt3_max = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max -> TILDATEST.TestingTimestampsView."dt3_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDt3_max()
      { return _dt3_max; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max -> TILDATEST.TestingTimestampsView."dt3_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt3_max()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_MAX._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max -> TILDATEST.TestingTimestampsView."dt3_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt3_max(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt3_max();
        }
       else if (v.equals(_dt3_max) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_MAX._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_MAX._Mask);
       _dt3_max = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max -> TILDATEST.TestingTimestampsView."dt3_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt3_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt3_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt3_max()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_MAX._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_MAX._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_MAX._Mask);
       _dt3_max=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max -> TILDATEST.TestingTimestampsView."dt4_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt4_max")
   String  Str_dt4_max;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt4_max(String v) { Str_dt4_max = v; }
   public String initDt4_maxVal() { return Str_dt4_max; }
   transient ZonedDateTime _dt4_max = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max -> TILDATEST.TestingTimestampsView."dt4_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDt4_max()
      { return _dt4_max; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max -> TILDATEST.TestingTimestampsView."dt4_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt4_max()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_MAX._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max -> TILDATEST.TestingTimestampsView."dt4_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt4_max(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt4_max();
        }
       else if (v.equals(_dt4_max) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_MAX._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_MAX._Mask);
       _dt4_max = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max -> TILDATEST.TestingTimestampsView."dt4_max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4_max of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestampsView.dt4_max of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestampsView.dt4_max</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt4_max()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_MAX._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_MAX._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_MAX._Mask);
       _dt4_max=null;
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
             // GOTTA Check if we are setting a null ROWTZ but there are still row timestamps that are not null
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
             // GOTTA Check if we are setting a null ROWTZ but there are still row timestamps that are not null
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
             // GOTTA Check if we are setting a null ROWTZ but there are still row timestamps that are not null
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
             // GOTTA Check if we are setting a null ROWTZ but there are still row timestamps that are not null
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
                        _id      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.ID._Mask     ); _id = null; }
                        _dt1_max = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), _dt1_max); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_MAX._Mask); _dt1_max = null; }
                        _dt2_max = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), _dt2_max); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_MAX._Mask); _dt2_max = null; }
                        _dt3_max = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), _dt3_max); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_MAX._Mask); _dt3_max = null; }
                        _dt4_max = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), _dt4_max); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_MAX._Mask); _dt4_max = null; }
                        _dt1_cnt =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_CNT._Mask); _dt1_cnt = null; }
                        _dt2_cnt =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_CNT._Mask); _dt2_cnt = null; }
                        _dt3_cnt =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_CNT._Mask); _dt3_cnt = null; }
                        _dt4_cnt =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_CNT._Mask); _dt4_cnt = null; }
                        _dt1_arr = (List<String>) JDBCHelper.getArray(RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask); _dt1_arr = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_dt1_arr != null && _dt1_arr.size() == 1 && _dt1_arr.get(0) == null)
                               {
                                 _dt1_arr = new ArrayList<String>();
                                 __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask);
                               }
                        _dt2_arr = (List<String>) JDBCHelper.getArray(RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask); _dt2_arr = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_dt2_arr != null && _dt2_arr.size() == 1 && _dt2_arr.get(0) == null)
                               {
                                 _dt2_arr = new ArrayList<String>();
                                 __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask);
                               }
                        _dt3_arr = (List<String>) JDBCHelper.getArray(RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask); _dt3_arr = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_dt3_arr != null && _dt3_arr.size() == 1 && _dt3_arr.get(0) == null)
                               {
                                 _dt3_arr = new ArrayList<String>();
                                 __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask);
                               }
                        _dt4_arr = (List<String>) JDBCHelper.getArray(RS, ++i, TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask); _dt4_arr = null; }
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
                   "id: "                                                                                                     + TextUtil.printVariableStr        (getId     ())
               + "; dt1_max"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_MAX._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt1_max()))
               + "; dt2_max"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_MAX._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt2_max()))
               + "; dt3_max"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_MAX._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt3_max()))
               + "; dt4_max"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_MAX._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt4_max()))
               + "; dt1_cnt"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_CNT._Mask) == true ? ": NULL" : ": " +                                   getDt1_cnt())
               + "; dt2_cnt"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_CNT._Mask) == true ? ": NULL" : ": " +                                   getDt2_cnt())
               + "; dt3_cnt"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_CNT._Mask) == true ? ": NULL" : ": " +                                   getDt3_cnt())
               + "; dt4_cnt"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_CNT._Mask) == true ? ": NULL" : ": " +                                   getDt4_cnt())
               + "; dt1_arr"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT1_ARR._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getDt1_arr()))
               + "; dt2_arr"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT2_ARR._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getDt2_arr()))
               + "; dt3_arr"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT3_ARR._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getDt3_arr()))
               + "; dt4_arr"   + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPSVIEW_Factory.COLS.DT4_ARR._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getDt4_arr()))
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
