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
<TABLE id="Test_XYZ_Analytics_Realized_DIV" class="tables">
<SCRIPT>registerStickyHeader("Test_XYZ_Analytics_Realized_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Test_XYZ_Analytics_Realized&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Test_XYZ_Analytics_Realized_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Test_XYZ_Analytics_Realized_CNT" class="content">
The Table TILDATUTORIAL.Test_XYZ_Analytics_Realized:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Test_XYZ_Analytics_Realized_Factory</B>, <B>Test_XYZ_Analytics_Realized_Data</B> in the package <B>tilda.tutorial.data</B>.
<LI>Is Realized from <B><A href="TILDA___Docs.TILDATUTORIAL.html#Test_XYZ_Analytics_View_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_Analytics_View</A></B> through DB function <B>TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Refill_Test_XYZ_Analytics_Realized()</B>.</LI>
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Defines foreign key(s) to <A href="TILDA___Docs.TILDATUTORIAL.html#Form_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form</A>, <A href="TILDA___Docs.TILDATUTORIAL.html#User_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>User</A> </LI>
<LI>Has the following identity:<UL><LI>Primary Key: formRefnum</LI>
</UL></LI>
</UL>
<B>Description</B>: Realized table for view TILDATUTORIAL.Test_XYZ_Analytics_View: A view of XYZ forms with analytics<BR>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="Test_XYZ_Analytics_Realized_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-formRefnum_DIV' class='columns'>formRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-formType_DIV' class='columns'>formType</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(40)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Form template type (from TILDATUTORIAL.Test_XYZ_Analytics_View.formType)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-formFillDateTZ_DIV' class='columns'>formFillDateTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'formFillDate'. (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-formFillDate_DIV' class='columns'>formFillDate</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-formUserRefnum_DIV' class='columns'>formUserRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-formUserEmail_DIV' class='columns'>formUserEmail</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(255)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The user's email (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-formCountCorrect_DIV' class='columns'>formCountCorrect</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-formTimeMillisTotal_DIV' class='columns'>formTimeMillisTotal</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-testCount_DIV' class='columns'>testCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.testCount)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-testAnswerCountCorrect_DIV' class='columns'>testAnswerCountCorrect</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-testTimeMillisAvg_DIV' class='columns'>testTimeMillisAvg</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-isPassed_DIV' class='columns'>isPassed</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Test Passed</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Test_XYZ_Analytics_View-isPassed_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_Analytics_View<B>&nbsp;&#8226;&nbsp;</B>isPassed</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-tookLongerThanAverage_DIV' class='columns'>tookLongerThanAverage</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Test Took Longer Than Average</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Test_XYZ_Analytics_View-tookLongerThanAverage_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_Analytics_View<B>&nbsp;&#8226;&nbsp;</B>tookLongerThanAverage</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_XYZ_Analytics_Realized-wasChallenging_DIV' class='columns'>wasChallenging</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Formula column '<B>Test Was Challenging</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging)<DIV style="margin:0px;margin-left:20px;font-size:75%;">&nbsp;&nbsp;&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Test_XYZ_Analytics_View-wasChallenging_DIV">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_XYZ_Analytics_View<B>&nbsp;&#8226;&nbsp;</B>wasChallenging</A></DIV></TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TEST_XYZ_ANALYTICS_REALIZED implements tilda.interfaces.WriterObject
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__TEST_XYZ_ANALYTICS_REALIZED.class.getName());

   public transient static final Class<TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory> FACTORY_CLASS= TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDATUTORIAL.Test_XYZ_Analytics_Realized", "");

   protected TILDA__TEST_XYZ_ANALYTICS_REALIZED() { }

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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formRefnum")
   Long _formRefnum=null;
   protected Long __Saved_formRefnum;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormRefnum()
      { return _formRefnum==null?0l:_formRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formRefnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setFormRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _formRefnum == null || v != _formRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM._Mask);
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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type (from TILDATUTORIAL.Test_XYZ_Analytics_View.formType)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formType")
   String _formType=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type (from TILDATUTORIAL.Test_XYZ_Analytics_View.formType)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormType()
      { return _formType; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type (from TILDATUTORIAL.Test_XYZ_Analytics_View.formType)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isFormTypeNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type (from TILDATUTORIAL.Test_XYZ_Analytics_View.formType)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormType(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setFormTypeNull();
        }
       else if (v.length() > 40)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType: the size "+v.length()+" is larger than the max allowed of 40: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_formType) == false)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask);
       _formType = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type (from TILDATUTORIAL.Test_XYZ_Analytics_View.formType)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormTypeNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask);
       _formType=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formType"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formType of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type (from TILDATUTORIAL.Test_XYZ_Analytics_View.formType)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFormType()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'. (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _formFillDateTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'. (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormFillDateTZ()
      { return _formFillDateTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'. (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isFormFillDateTZNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'. (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
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
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_formFillDateTZ) == false)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask);
       _formFillDateTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'. (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormFillDateTZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask);
       _formFillDateTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDateTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'. (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDateTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFormFillDateTZ()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getFormFillDate()
      { return _formFillDate; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isFormFillDateNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormFillDate(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setFormFillDateNull();
        }
       else if (v.equals(_formFillDate) == false)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask);
       _formFillDate = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setFormFillDateTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormFillDateNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask);
       _formFillDate=null;
       setFormFillDateTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setFormFillDateNow() throws Exception
    {
      setFormFillDate(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setFormFillDateUndefined() throws Exception
    {
      setFormFillDate(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setFormFillDate(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setFormFillDate(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_XYZ_Analytics_View.formFillDate)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFormFillDate()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formUserRefnum")
   Long _formUserRefnum=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormUserRefnum()
      { return _formUserRefnum==null?0l:_formUserRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isFormUserRefnumNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormUserRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _formUserRefnum == null || v != _formUserRefnum)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask);
       _formUserRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormUserRefnumNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask);
       _formUserRefnum=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserRefnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFormUserRefnum()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formUserEmail")
   String _formUserEmail=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormUserEmail()
      { return _formUserEmail; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isFormUserEmailNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormUserEmail(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setFormUserEmailNull();
        }
       else if (v.length() > 255)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail: the size "+v.length()+" is larger than the max allowed of 255: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_formUserEmail) == false)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask);
       _formUserEmail = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormUserEmailNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask);
       _formUserEmail=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email (from TILDATUTORIAL.Test_XYZ_Analytics_View.formUserEmail)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFormUserEmail()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formCountCorrect")
   Long _formCountCorrect=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormCountCorrect()
      { return _formCountCorrect==null?0l:_formCountCorrect; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isFormCountCorrectNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormCountCorrect(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _formCountCorrect == null || v != _formCountCorrect)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask);
       _formCountCorrect = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormCountCorrectNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask);
       _formCountCorrect=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.formCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFormCountCorrect()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formTimeMillisTotal")
   Long _formTimeMillisTotal=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormTimeMillisTotal()
      { return _formTimeMillisTotal==null?0l:_formTimeMillisTotal; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isFormTimeMillisTotalNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormTimeMillisTotal(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _formTimeMillisTotal == null || v != _formTimeMillisTotal)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask);
       _formTimeMillisTotal = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormTimeMillisTotalNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask);
       _formTimeMillisTotal=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."formTimeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.formTimeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.formTimeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFormTimeMillisTotal()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("testCount")
   Long _testCount=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getTestCount()
      { return _testCount==null?0l:_testCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestCountNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestCount(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _testCount == null || v != _testCount)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask);
       _testCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestCountNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask);
       _testCount=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_XYZ_Analytics_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTestCount()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("testAnswerCountCorrect")
   Long _testAnswerCountCorrect=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getTestAnswerCountCorrect()
      { return _testAnswerCountCorrect==null?0l:_testAnswerCountCorrect; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestAnswerCountCorrectNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestAnswerCountCorrect(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _testAnswerCountCorrect == null || v != _testAnswerCountCorrect)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask);
       _testAnswerCountCorrect = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestAnswerCountCorrectNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask);
       _testAnswerCountCorrect=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testAnswerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testAnswerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_XYZ_Analytics_View.testAnswerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTestAnswerCountCorrect()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("testTimeMillisAvg")
   Double _testTimeMillisAvg=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getTestTimeMillisAvg()
      { return _testTimeMillisAvg==null?0d:_testTimeMillisAvg; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestTimeMillisAvgNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestTimeMillisAvg(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _testTimeMillisAvg == null || v != _testTimeMillisAvg)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask);
       _testTimeMillisAvg = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestTimeMillisAvgNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask);
       _testTimeMillisAvg=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."testTimeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.testTimeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_XYZ_Analytics_View.testTimeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTestTimeMillisAvg()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Passed</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("isPassed")
   Integer _isPassed=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Passed</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getIsPassed()
      { return _isPassed==null?0:_isPassed; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Passed</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isIsPassedNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Passed</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setIsPassed(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _isPassed == null || v != _isPassed)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask);
       _isPassed = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Passed</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setIsPassedNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask);
       _isPassed=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."isPassed"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.isPassed of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Passed</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.isPassed)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedIsPassed()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Took Longer Than Average</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("tookLongerThanAverage")
   Integer _tookLongerThanAverage=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Took Longer Than Average</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getTookLongerThanAverage()
      { return _tookLongerThanAverage==null?0:_tookLongerThanAverage; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Took Longer Than Average</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTookLongerThanAverageNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Took Longer Than Average</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTookLongerThanAverage(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _tookLongerThanAverage == null || v != _tookLongerThanAverage)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask);
       _tookLongerThanAverage = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Took Longer Than Average</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTookLongerThanAverageNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask);
       _tookLongerThanAverage=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."tookLongerThanAverage"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.tookLongerThanAverage of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Took Longer Than Average</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.tookLongerThanAverage)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTookLongerThanAverage()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Was Challenging</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("wasChallenging")
   Integer _wasChallenging=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Was Challenging</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getWasChallenging()
      { return _wasChallenging==null?0:_wasChallenging; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Was Challenging</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isWasChallengingNull()
     { return __Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Was Challenging</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setWasChallenging(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _wasChallenging == null || v != _wasChallenging)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask);
       _wasChallenging = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Was Challenging</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setWasChallengingNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask);
       __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask);
       _wasChallenging=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging -> TILDATUTORIAL.Test_XYZ_Analytics_Realized."wasChallenging"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_XYZ_Analytics_Realized.wasChallenging of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Test Was Challenging</B>' (from TILDATUTORIAL.Test_XYZ_Analytics_View.wasChallenging)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedWasChallenging()
     { return __Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED Dst) throws Exception
     {
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask) == true) Dst.setFormTypeNull              (); else        Dst.setFormType              (_formType              );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask) == true) Dst.setFormFillDateTZNull        (); else        Dst.setFormFillDateTZ        (_formFillDateTZ        );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask) == true) Dst.setFormFillDateNull          (); else        Dst.setFormFillDate          (_formFillDate          );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask) == true) Dst.setFormUserRefnumNull        (); else        Dst.setFormUserRefnum        (_formUserRefnum        );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask) == true) Dst.setFormUserEmailNull         (); else        Dst.setFormUserEmail         (_formUserEmail         );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask) == true) Dst.setFormCountCorrectNull      (); else        Dst.setFormCountCorrect      (_formCountCorrect      );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask) == true) Dst.setFormTimeMillisTotalNull   (); else        Dst.setFormTimeMillisTotal   (_formTimeMillisTotal   );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) Dst.setTestCountNull             (); else        Dst.setTestCount             (_testCount             );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask) == true) Dst.setTestAnswerCountCorrectNull(); else        Dst.setTestAnswerCountCorrect(_testAnswerCountCorrect);
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask) == true) Dst.setTestTimeMillisAvgNull     (); else        Dst.setTestTimeMillisAvg     (_testTimeMillisAvg     );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask) == true) Dst.setIsPassedNull              (); else        Dst.setIsPassed              (_isPassed              );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask) == true) Dst.setTookLongerThanAverageNull (); else        Dst.setTookLongerThanAverage (_tookLongerThanAverage );
       if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask) == true) Dst.setWasChallengingNull        (); else        Dst.setWasChallenging        (_wasChallenging        );
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
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }

       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
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
               PS.setLong      (++i, _formRefnum            );
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (_formRefnum == null)
        throw new Exception("Incoming value for 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formRefnum' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM._Mask);

       if (TextUtil.isNullOrEmpty(_formType) == false)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask);
        }

       if (TextUtil.isNullOrEmpty(Str_formFillDate) == false)
        {
          _formFillDate = DateTimeUtil.parsefromJSON(Str_formFillDate);
          if (   _formFillDate == null)
           throw new Exception("Incoming value for 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_formFillDate.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate' because the timezone value '"+_formFillDate.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setFormFillDateTZ(ZI.getId());
        }

       if (_formUserRefnum != null)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask);
        }

       if (TextUtil.isNullOrEmpty(_formUserEmail) == false)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask);
        }

       if (_formCountCorrect != null)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask);
        }

       if (_formTimeMillisTotal != null)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask);
        }

       if (_testCount != null)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask);
        }

       if (_testAnswerCountCorrect != null)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask);
        }

       if (_testTimeMillisAvg != null)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask);
        }

       if (_isPassed != null)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask);
        }

       if (_tookLongerThanAverage != null)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask);
        }

       if (_wasChallenging != null)
        {
          __Changes.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask);
          __Nulls.andNot(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask);
        }
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_formFillDate) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_formFillDate) == true ? C.getCommaCurrentTimestamp() : tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask) == true) { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_formFillDate) == true)
              { TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask) == true) TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING.getFullColumnVarForUpdate(C, S);

          switch (__LookupId)
           {
             case 0:
                S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formRefnum"); S.append("=?)");
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
       QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATUTORIAL.Test_XYZ_Analytics_Realized", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _formRefnum);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _formType);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _formFillDateTZ);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_formFillDate) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_formFillDate.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _formUserRefnum);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _formUserEmail);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _formCountCorrect);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _formTimeMillisTotal);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _testCount);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _testAnswerCountCorrect);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask) == true) PS.setNull(++i, java.sql.Types.DOUBLE    ); else PS.setDouble    (++i, _testTimeMillisAvg);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _isPassed);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _tookLongerThanAverage);
        } 
       if (__Changes.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _wasChallenging);
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
             __Saved_formRefnum             = _formRefnum            ;
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
        }

       __Changes.clear();
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

       if (__Init == null && __LookupId==0)  // object deserialized
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

       // Testing if primary key has been set - Id: 0
       if (_formRefnum != null)
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
        throw new Exception("This TILDATUTORIAL.Test_XYZ_Analytics_Realized object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATUTORIAL.Test_XYZ_Analytics_Realized object has already been read.");
          QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formType");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formFillDateTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formFillDate");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formUserRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formUserEmail");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formCountCorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formTimeMillisTotal");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "testCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "testAnswerCountCorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "testTimeMillisAvg");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "isPassed");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "tookLongerThanAverage");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "wasChallenging");
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_XYZ_Analytics_Realized", "formRefnum"); S.append("=?)");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATUTORIAL.Test_XYZ_Analytics_Realized", Q, toString());
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
               PS.setLong      (++i, _formRefnum            );
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_formRefnum             = _formRefnum             =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMREFNUM._Mask            ); _formRefnum = null; }
                                       _formType               = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask              ); _formType = null; }
                                       _formFillDateTZ         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ._Mask        ); _formFillDateTZ = null; }
                                       _formFillDate           = processZDT(_formFillDateTZ          , "tilda.tutorial.data.TILDATUTORIAL.Test_XYZ_Analytics_Realized.formFillDate"          , RS, ++i, TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE          , TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATETZ          ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask          ); _formFillDate = null; }
                                       _formUserRefnum         =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask        ); _formUserRefnum = null; }
                                       _formUserEmail          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask         ); _formUserEmail = null; }
                                       _formCountCorrect       =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask      ); _formCountCorrect = null; }
                                       _formTimeMillisTotal    =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask   ); _formTimeMillisTotal = null; }
                                       _testCount              =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask             ); _testCount = null; }
                                       _testAnswerCountCorrect =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask); _testAnswerCountCorrect = null; }
                                       _testTimeMillisAvg      =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask     ); _testTimeMillisAvg = null; }
                                       _isPassed               =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask              ); _isPassed = null; }
                                       _tookLongerThanAverage  =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask ); _tookLongerThanAverage = null; }
                                       _wasChallenging         =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask        ); _wasChallenging = null; }
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
                   "formRefnum: "                                                                                                                                 +                                   getFormRefnum            () 
               + "; formType"                 + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTYPE._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getFormType              ()))
               + "; formFillDate"             + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMFILLDATE._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getFormFillDate          ()))
               + "; formUserRefnum"           + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSERREFNUM._Mask) == true ? ": NULL" : ": " +                                   getFormUserRefnum        () )
               + "; formUserEmail"            + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMUSEREMAIL._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getFormUserEmail         ()))
               + "; formCountCorrect"         + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMCOUNTCORRECT._Mask) == true ? ": NULL" : ": " +                                   getFormCountCorrect      () )
               + "; formTimeMillisTotal"      + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.FORMTIMEMILLISTOTAL._Mask) == true ? ": NULL" : ": " +                                   getFormTimeMillisTotal   () )
               + "; testCount"                + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true ? ": NULL" : ": " +                                   getTestCount             () )
               + "; testAnswerCountCorrect"   + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTANSWERCOUNTCORRECT._Mask) == true ? ": NULL" : ": " +                                   getTestAnswerCountCorrect() )
               + "; testTimeMillisAvg"        + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TESTTIMEMILLISAVG._Mask) == true ? ": NULL" : ": " +                                   getTestTimeMillisAvg     () )
               + "; isPassed"                 + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.ISPASSED._Mask) == true ? ": NULL" : ": " +                                   getIsPassed              () )
               + "; tookLongerThanAverage"    + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.TOOKLONGERTHANAVERAGE._Mask) == true ? ": NULL" : ": " +                                   getTookLongerThanAverage () )
               + "; wasChallenging"           + (__Nulls.intersects(TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory.COLS.WASCHALLENGING._Mask) == true ? ": NULL" : ": " +                                   getWasChallenging        () )
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
