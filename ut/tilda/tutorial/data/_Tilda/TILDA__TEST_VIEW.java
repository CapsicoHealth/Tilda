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
<TABLE id="Test_View_DIV" class="tables">
<SCRIPT>registerStickyHeader("Test_View_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Test_View&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Test_View_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Test_View_CNT" class="content">
The View TILDATUTORIAL.Test_View:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Test_View_Factory</B>, <B>Test_View_Data</B> in the package <B>tilda.tutorial.data</B>.
<LI>Configured to be Realized to <B><A href="TILDA___Docs.TILDATUTORIAL.html#Test_Realized_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_Realized</A></B> through DB function <B>TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Refill_Test_Realized()</B>.</LI>
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Defines foreign key(s) to <A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A> </LI>
</UL>
<B>Description</B>: A pivoted view of SAT_01 forms<BR>
<BR>
This view depends on the following filter(s), sub-view(s), and/or root table(s):
<BLOCKQUOTE><TABLE class="TreeTable Rowed" border="0px" cellspacing="0px" cellpadding="2px"><TR><TD><PRE><A href="TILDA___Docs.TILDATUTORIAL.html#Test_View_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_View</A></PRE></TD><TD>Look at all forms and answers that have not been deleted.<PRE>    Form.deleted is null
and TestAnswer.deleted is null</PRE></TD></TR>
<TR><TD><PRE>    <A href="TILDA___Docs.TILDATUTORIAL.html#Form_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form</A></PRE></TD><TD><PRE>Root table for the view TILDATUTORIAL.Test_View</PRE></TD></TR>
<TR><TD><PRE>    <A href="TILDA___Docs.TILDATUTORIAL.html#User_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>User</A></PRE></TD><TD><PRE>Standard join</PRE></TD></TR>
<TR><TD><PRE>    <A href="TILDA___Docs.TILDATUTORIAL.html#TestAnswer_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer</A></PRE></TD><TD><PRE>Standard join</PRE></TD></TR>
</TABLE></BLOCKQUOTE>
This View contains the following columns:<BLOCKQUOTE>
 <TABLE id="Test_View_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left" nowrap><label>Realized<input type="checkbox" onchange="filterTable('Test_View_TBL', 'R')", id="Test_View_TBL_R"></label>&nbsp;</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-type_DIV' class='columns realizedcolumns'>type</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(40)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Form template type<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Form-type_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>type</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-testCount_DIV' class='columns realizedcolumns'>testCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Form-refnum_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-testFirstTZ_DIV' class='columns realizedcolumns'>testFirstTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'testFirst'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Form-fillDateTZ_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>fillDateTZ</A><BR>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo-id_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo<B>&nbsp;&#8226;&nbsp;</B>id</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-testFirst_DIV' class='columns realizedcolumns'>testFirst</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The date the form was filled<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Form-fillDate_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>fillDate</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-testLastTZ_DIV' class='columns realizedcolumns'>testLastTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'testLast'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Form-fillDateTZ_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>fillDateTZ</A><BR>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo-id_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo<B>&nbsp;&#8226;&nbsp;</B>id</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-testLast_DIV' class='columns realizedcolumns'>testLast</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The date the form was filled<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Form-fillDate_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>fillDate</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-userCount_DIV' class='columns realizedcolumns'>userCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#User-refnum_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>User<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-answerCount_DIV' class='columns realizedcolumns'>answerCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#TestAnswer-correct_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>correct</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-answerCountCorrect_DIV' class='columns realizedcolumns'>answerCountCorrect</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#TestAnswer-correct_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>correct</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-answerCountIncorrect_DIV' class='columns realizedcolumns'>answerCountIncorrect</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#TestAnswer-correct_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>correct</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-timeMillisTotal_DIV' class='columns realizedcolumns'>timeMillisTotal</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#TestAnswer-timeMillis_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>timeMillis</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-timeMillisAvg_DIV' class='columns realizedcolumns'>timeMillisAvg</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#TestAnswer-timeMillis_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>timeMillis</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-timeMillisMin_DIV' class='columns realizedcolumns'>timeMillisMin</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#TestAnswer-timeMillis_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>timeMillis</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_View-timeMillisMax_DIV' class='columns realizedcolumns'>timeMillisMax</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;<!--R-->&nbsp;&nbsp;</TD><TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#TestAnswer-timeMillis_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>TestAnswer<B>&nbsp;&#8226;&nbsp;</B>timeMillis</A></DIV></TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TEST_VIEW implements tilda.interfaces.ReaderObject
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__TEST_VIEW.class.getName());

   public transient static final Class<TILDA__TEST_VIEW_Factory> FACTORY_CLASS= TILDA__TEST_VIEW_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDATUTORIAL.Test_View", "");

   protected TILDA__TEST_VIEW() { }

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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.type -> TILDATUTORIAL.Test_View."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.type of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("type")
   String _type=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.type -> TILDATUTORIAL.Test_View."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.type of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getType()
      { return _type; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.type -> TILDATUTORIAL.Test_View."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.type of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setType(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_View.type to null: it's not nullable.");
       else if (v.length() > 40)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_View.type: the size "+v.length()+" is larger than the max allowed of 40: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_type) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.type' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TYPE._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.TYPE._Mask);
       _type = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testCount -> TILDATUTORIAL.Test_View."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testCount of type bigint</TD></TR>

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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testCount -> TILDATUTORIAL.Test_View."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testCount of type bigint</TD></TR>

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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testCount -> TILDATUTORIAL.Test_View."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testCount of type bigint</TD></TR>

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
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.testCount' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TESTCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.TESTCOUNT._Mask);
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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ -> TILDATUTORIAL.Test_View."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _testFirstTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ -> TILDATUTORIAL.Test_View."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getTestFirstTZ()
      { return _testFirstTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ -> TILDATUTORIAL.Test_View."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestFirstTZNull()
     { return __Nulls.intersects(TILDA__TEST_VIEW_Factory.COLS.TESTFIRSTTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ -> TILDATUTORIAL.Test_View."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestFirstTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setTestFirstTZNull();
        }
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_testFirstTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TESTFIRSTTZ._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.TESTFIRSTTZ._Mask);
       _testFirstTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ -> TILDATUTORIAL.Test_View."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestFirstTZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_VIEW_Factory.COLS.TESTFIRSTTZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TESTFIRSTTZ._Mask);
       __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TESTFIRSTTZ._Mask);
       _testFirstTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst -> TILDATUTORIAL.Test_View."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("testFirst")
   String  Str_testFirst;
   public void initTestFirst(String v) { Str_testFirst = v; }
   public String initTestFirstVal() { return Str_testFirst; }
   transient ZonedDateTime _testFirst = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst -> TILDATUTORIAL.Test_View."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getTestFirst()
      { return _testFirst; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst -> TILDATUTORIAL.Test_View."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestFirstNull()
     { return __Nulls.intersects(TILDA__TEST_VIEW_Factory.COLS.TESTFIRST._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst -> TILDATUTORIAL.Test_View."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestFirst(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setTestFirstNull();
        }
       else if (v.equals(_testFirst) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TESTFIRST._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.TESTFIRST._Mask);
       _testFirst = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setTestFirstTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst -> TILDATUTORIAL.Test_View."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestFirstNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_VIEW_Factory.COLS.TESTFIRST._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TESTFIRST._Mask);
       __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TESTFIRST._Mask);
       _testFirst=null;
       setTestFirstTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ -> TILDATUTORIAL.Test_View."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _testLastTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ -> TILDATUTORIAL.Test_View."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getTestLastTZ()
      { return _testLastTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ -> TILDATUTORIAL.Test_View."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestLastTZNull()
     { return __Nulls.intersects(TILDA__TEST_VIEW_Factory.COLS.TESTLASTTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ -> TILDATUTORIAL.Test_View."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestLastTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setTestLastTZNull();
        }
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_testLastTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TESTLASTTZ._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.TESTLASTTZ._Mask);
       _testLastTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ -> TILDATUTORIAL.Test_View."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestLastTZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_VIEW_Factory.COLS.TESTLASTTZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TESTLASTTZ._Mask);
       __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TESTLASTTZ._Mask);
       _testLastTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast -> TILDATUTORIAL.Test_View."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("testLast")
   String  Str_testLast;
   public void initTestLast(String v) { Str_testLast = v; }
   public String initTestLastVal() { return Str_testLast; }
   transient ZonedDateTime _testLast = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast -> TILDATUTORIAL.Test_View."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getTestLast()
      { return _testLast; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast -> TILDATUTORIAL.Test_View."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestLastNull()
     { return __Nulls.intersects(TILDA__TEST_VIEW_Factory.COLS.TESTLAST._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast -> TILDATUTORIAL.Test_View."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestLast(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setTestLastNull();
        }
       else if (v.equals(_testLast) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TESTLAST._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.TESTLAST._Mask);
       _testLast = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setTestLastTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast -> TILDATUTORIAL.Test_View."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestLastNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_VIEW_Factory.COLS.TESTLAST._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TESTLAST._Mask);
       __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TESTLAST._Mask);
       _testLast=null;
       setTestLastTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.userCount -> TILDATUTORIAL.Test_View."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.userCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.userCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("userCount")
   Long _userCount=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.userCount -> TILDATUTORIAL.Test_View."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.userCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.userCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getUserCount()
      { return _userCount==null?0l:_userCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.userCount -> TILDATUTORIAL.Test_View."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.userCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.userCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setUserCount(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _userCount == null || v != _userCount)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.userCount' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.USERCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.USERCOUNT._Mask);
       _userCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field userCount doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initUserCount(long v) throws Exception
     {
       setUserCount(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCount -> TILDATUTORIAL.Test_View."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.answerCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("answerCount")
   Long _answerCount=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCount -> TILDATUTORIAL.Test_View."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.answerCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getAnswerCount()
      { return _answerCount==null?0l:_answerCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCount -> TILDATUTORIAL.Test_View."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.answerCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setAnswerCount(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _answerCount == null || v != _answerCount)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCount' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.ANSWERCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.ANSWERCOUNT._Mask);
       _answerCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountCorrect -> TILDATUTORIAL.Test_View."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.answerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("answerCountCorrect")
   Long _answerCountCorrect=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountCorrect -> TILDATUTORIAL.Test_View."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.answerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getAnswerCountCorrect()
      { return _answerCountCorrect==null?0l:_answerCountCorrect; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountCorrect -> TILDATUTORIAL.Test_View."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.answerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setAnswerCountCorrect(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _answerCountCorrect == null || v != _answerCountCorrect)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountCorrect' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.ANSWERCOUNTCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.ANSWERCOUNTCORRECT._Mask);
       _answerCountCorrect = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountIncorrect -> TILDATUTORIAL.Test_View."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountIncorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.answerCountIncorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("answerCountIncorrect")
   Long _answerCountIncorrect=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountIncorrect -> TILDATUTORIAL.Test_View."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountIncorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.answerCountIncorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getAnswerCountIncorrect()
      { return _answerCountIncorrect==null?0l:_answerCountIncorrect; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountIncorrect -> TILDATUTORIAL.Test_View."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountIncorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.answerCountIncorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setAnswerCountIncorrect(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _answerCountIncorrect == null || v != _answerCountIncorrect)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.answerCountIncorrect' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.ANSWERCOUNTINCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.ANSWERCOUNTINCORRECT._Mask);
       _answerCountIncorrect = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisTotal -> TILDATUTORIAL.Test_View."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("timeMillisTotal")
   Long _timeMillisTotal=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisTotal -> TILDATUTORIAL.Test_View."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getTimeMillisTotal()
      { return _timeMillisTotal==null?0l:_timeMillisTotal; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisTotal -> TILDATUTORIAL.Test_View."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTimeMillisTotal(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _timeMillisTotal == null || v != _timeMillisTotal)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisTotal' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISTOTAL._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISTOTAL._Mask);
       _timeMillisTotal = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisAvg -> TILDATUTORIAL.Test_View."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("timeMillisAvg")
   Double _timeMillisAvg=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisAvg -> TILDATUTORIAL.Test_View."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getTimeMillisAvg()
      { return _timeMillisAvg==null?0d:_timeMillisAvg; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisAvg -> TILDATUTORIAL.Test_View."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTimeMillisAvg(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _timeMillisAvg == null || v != _timeMillisAvg)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisAvg' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISAVG._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISAVG._Mask);
       _timeMillisAvg = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMin -> TILDATUTORIAL.Test_View."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMin of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisMin of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("timeMillisMin")
   Integer _timeMillisMin=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMin -> TILDATUTORIAL.Test_View."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMin of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisMin of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getTimeMillisMin()
      { return _timeMillisMin==null?0:_timeMillisMin; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMin -> TILDATUTORIAL.Test_View."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMin of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisMin of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTimeMillisMin(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _timeMillisMin == null || v != _timeMillisMin)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMin' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISMIN._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISMIN._Mask);
       _timeMillisMin = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMax -> TILDATUTORIAL.Test_View."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMax of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisMax of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("timeMillisMax")
   Integer _timeMillisMax=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMax -> TILDATUTORIAL.Test_View."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMax of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisMax of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getTimeMillisMax()
      { return _timeMillisMax==null?0:_timeMillisMax; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMax -> TILDATUTORIAL.Test_View."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMax of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_View.timeMillisMax of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTimeMillisMax(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _timeMillisMax == null || v != _timeMillisMax)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_View.timeMillisMax' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISMAX._Mask);
          __Nulls.andNot(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISMAX._Mask);
       _timeMillisMax = v;
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
        throw new Exception("This TILDATUTORIAL.Test_View object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATUTORIAL.Test_View object has already been read.");
          QueryDetails.setLastQuery(TILDA__TEST_VIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "type");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "testCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "testFirstTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "testFirst");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "testLastTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "testLast");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "userCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "answerCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "answerCountCorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "answerCountIncorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "timeMillisTotal");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "timeMillisAvg");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "timeMillisMin");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_View", "timeMillisMax");
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_View");
       switch (__LookupId)
        {
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TEST_VIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATUTORIAL.Test_View", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TEST_VIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                                     _type                 = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TYPE._Mask                );
                                     _testCount            =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TESTCOUNT._Mask           );
                                     _testFirstTZ          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TESTFIRSTTZ._Mask         );
                                     _testFirst            = processZDT(_testFirstTZ           , "tilda.tutorial.data.TILDATUTORIAL.Test_View.testFirst"           , RS, ++i, TILDA__TEST_VIEW_Factory.COLS.TESTFIRST           , TILDA__TEST_VIEW_Factory.COLS.TESTFIRSTTZ           ); if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TESTFIRST._Mask           );
                                     _testLastTZ           = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TESTLASTTZ._Mask          );
                                     _testLast             = processZDT(_testLastTZ            , "tilda.tutorial.data.TILDATUTORIAL.Test_View.testLast"            , RS, ++i, TILDA__TEST_VIEW_Factory.COLS.TESTLAST            , TILDA__TEST_VIEW_Factory.COLS.TESTLASTTZ            ); if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TESTLAST._Mask            );
                                     _userCount            =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.USERCOUNT._Mask           );
                                     _answerCount          =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.ANSWERCOUNT._Mask         );
                                     _answerCountCorrect   =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.ANSWERCOUNTCORRECT._Mask  );
                                     _answerCountIncorrect =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.ANSWERCOUNTINCORRECT._Mask);
                                     _timeMillisTotal      =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISTOTAL._Mask     );
                                     _timeMillisAvg        =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISAVG._Mask       );
                                     _timeMillisMin        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISMIN._Mask       );
                                     _timeMillisMax        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TEST_VIEW_Factory.COLS.TIMEMILLISMAX._Mask       );
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
                   "type: "                                                                                                                 + TextUtil.printVariableStr        (getType                ())
               + "; testCount: "                                                                                                            +                                   getTestCount           () 
               + "; testFirst"              + (__Nulls.intersects(TILDA__TEST_VIEW_Factory.COLS.TESTFIRST._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getTestFirst           ()))
               + "; testLast"               + (__Nulls.intersects(TILDA__TEST_VIEW_Factory.COLS.TESTLAST._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getTestLast            ()))
               + "; userCount: "                                                                                                            +                                   getUserCount           () 
               + "; answerCount: "                                                                                                          +                                   getAnswerCount         () 
               + "; answerCountCorrect: "                                                                                                   +                                   getAnswerCountCorrect  () 
               + "; answerCountIncorrect: "                                                                                                 +                                   getAnswerCountIncorrect() 
               + "; timeMillisTotal: "                                                                                                      +                                   getTimeMillisTotal     () 
               + "; timeMillisAvg: "                                                                                                        +                                   getTimeMillisAvg       () 
               + "; timeMillisMin: "                                                                                                        +                                   getTimeMillisMin       () 
               + "; timeMillisMax: "                                                                                                        +                                   getTimeMillisMax       () 
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
