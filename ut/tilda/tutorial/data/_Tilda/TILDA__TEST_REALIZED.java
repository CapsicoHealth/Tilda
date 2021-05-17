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
<TABLE id="Test_Realized_DIV" class="tables">
<SCRIPT>registerStickyHeader("Test_Realized_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Test_Realized&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Test_Realized_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Test_Realized_CNT" class="content">
The Table TILDATUTORIAL.Test_Realized:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Test_Realized_Factory</B>, <B>Test_Realized_Data</B> in the package <B>tilda.tutorial.data</B>.
<LI>Is Realized from <B><A href="TILDA___Docs.TILDATUTORIAL.html#Test_View_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Test_View</A></B> through DB function <B>TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Refill_Test_Realized()</B>.</LI>
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Has the following identity:<UL><LI>Primary Key: type</LI>
</UL></LI>
</UL>
<B>Description</B>: Realized table for view TILDATUTORIAL.Test_View: A pivoted view of SAT_01 forms<BR>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="Test_Realized_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-type_DIV' class='columns'>type</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(40)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Form template type (from TILDATUTORIAL.Test_View.type)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-testCount_DIV' class='columns'>testCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record (from TILDATUTORIAL.Test_View.testCount)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-testFirstTZ_DIV' class='columns'>testFirstTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'testFirst'. (from TILDATUTORIAL.Test_View.testFirstTZ)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-testFirst_DIV' class='columns'>testFirst</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-testLastTZ_DIV' class='columns'>testLastTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'testLast'. (from TILDATUTORIAL.Test_View.testLastTZ)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-testLast_DIV' class='columns'>testLast</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-userCount_DIV' class='columns'>userCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record (from TILDATUTORIAL.Test_View.userCount)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-answerCount_DIV' class='columns'>answerCount</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-answerCountCorrect_DIV' class='columns'>answerCountCorrect</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-answerCountIncorrect_DIV' class='columns'>answerCountIncorrect</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-timeMillisTotal_DIV' class='columns'>timeMillisTotal</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-timeMillisAvg_DIV' class='columns'>timeMillisAvg</B>&nbsp;&nbsp;</TD>
<TD>double&nbsp;/&nbsp;double precision&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-timeMillisMin_DIV' class='columns'>timeMillisMin</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='Test_Realized-timeMillisMax_DIV' class='columns'>timeMillisMax</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TEST_REALIZED implements tilda.interfaces.WriterObject
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__TEST_REALIZED.class.getName());

   public transient static final Class<TILDA__TEST_REALIZED_Factory> FACTORY_CLASS= TILDA__TEST_REALIZED_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDATUTORIAL.Test_Realized", "");

   protected TILDA__TEST_REALIZED() { }

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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type -> TILDATUTORIAL.Test_Realized."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.type of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type (from TILDATUTORIAL.Test_View.type)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("type")
   String _type=null;
   protected String __Saved_type;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type -> TILDATUTORIAL.Test_Realized."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.type of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type (from TILDATUTORIAL.Test_View.type)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getType()
      { return _type; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type -> TILDATUTORIAL.Test_Realized."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.type of type varchar(40)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>40</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type (from TILDATUTORIAL.Test_View.type)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setType(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type to null: it's not nullable.");
       else if (v.length() > 40)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type: the size "+v.length()+" is larger than the max allowed of 40: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_type) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TYPE._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TYPE._Mask);
       _type = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field type doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initType(String v) throws Exception
     {
       setType(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount -> TILDATUTORIAL.Test_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("testCount")
   Long _testCount=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount -> TILDATUTORIAL.Test_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getTestCount()
      { return _testCount==null?0l:_testCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount -> TILDATUTORIAL.Test_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestCountNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount -> TILDATUTORIAL.Test_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.testCount)</TD></TR>
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
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask);
       _testCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount -> TILDATUTORIAL.Test_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestCountNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask);
       _testCount=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount -> TILDATUTORIAL.Test_Realized."testCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.testCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTestCount()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ -> TILDATUTORIAL.Test_Realized."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'. (from TILDATUTORIAL.Test_View.testFirstTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _testFirstTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ -> TILDATUTORIAL.Test_Realized."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'. (from TILDATUTORIAL.Test_View.testFirstTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getTestFirstTZ()
      { return _testFirstTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ -> TILDATUTORIAL.Test_Realized."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'. (from TILDATUTORIAL.Test_View.testFirstTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestFirstTZNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ -> TILDATUTORIAL.Test_Realized."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'. (from TILDATUTORIAL.Test_View.testFirstTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
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
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_testFirstTZ) == false)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask);
       _testFirstTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ -> TILDATUTORIAL.Test_Realized."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'. (from TILDATUTORIAL.Test_View.testFirstTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestFirstTZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask);
       _testFirstTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ -> TILDATUTORIAL.Test_Realized."testFirstTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirstTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirstTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testFirst'. (from TILDATUTORIAL.Test_View.testFirstTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTestFirstTZ()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getTestFirst()
      { return _testFirst; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestFirstNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestFirst(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setTestFirstNull();
        }
       else if (v.equals(_testFirst) == false)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask);
       _testFirst = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setTestFirstTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestFirstNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask);
       _testFirst=null;
       setTestFirstTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setTestFirstNow() throws Exception
    {
      setTestFirst(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setTestFirstUndefined() throws Exception
    {
      setTestFirst(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setTestFirst(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setTestFirst(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst -> TILDATUTORIAL.Test_Realized."testFirst"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testFirst of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testFirst)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTestFirst()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ -> TILDATUTORIAL.Test_Realized."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'. (from TILDATUTORIAL.Test_View.testLastTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _testLastTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ -> TILDATUTORIAL.Test_Realized."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'. (from TILDATUTORIAL.Test_View.testLastTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getTestLastTZ()
      { return _testLastTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ -> TILDATUTORIAL.Test_Realized."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'. (from TILDATUTORIAL.Test_View.testLastTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestLastTZNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ -> TILDATUTORIAL.Test_Realized."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'. (from TILDATUTORIAL.Test_View.testLastTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
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
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ: the size "+v.length()+" is larger than the max allowed of 10: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_testLastTZ) == false)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask);
       _testLastTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ -> TILDATUTORIAL.Test_Realized."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'. (from TILDATUTORIAL.Test_View.testLastTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTestLastTZNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask);
       _testLastTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ -> TILDATUTORIAL.Test_Realized."testLastTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLastTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLastTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'testLast'. (from TILDATUTORIAL.Test_View.testLastTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTestLastTZ()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getTestLast()
      { return _testLast; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTestLastNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestLast(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setTestLastNull();
        }
       else if (v.equals(_testLast) == false)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask);
       _testLast = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setTestLastTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTestLastNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask);
       _testLast=null;
       setTestLastTZNull();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setTestLastNow() throws Exception
    {
      setTestLast(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setTestLastUndefined() throws Exception
    {
      setTestLast(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setTestLast(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setTestLast(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast -> TILDATUTORIAL.Test_Realized."testLast"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.testLast of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled (from TILDATUTORIAL.Test_View.testLast)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTestLast()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount -> TILDATUTORIAL.Test_Realized."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.userCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.userCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("userCount")
   Long _userCount=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount -> TILDATUTORIAL.Test_Realized."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.userCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.userCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getUserCount()
      { return _userCount==null?0l:_userCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount -> TILDATUTORIAL.Test_Realized."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.userCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.userCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isUserCountNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount -> TILDATUTORIAL.Test_Realized."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.userCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.userCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setUserCount(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _userCount == null || v != _userCount)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask);
       _userCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount -> TILDATUTORIAL.Test_Realized."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.userCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.userCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setUserCountNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask);
       _userCount=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount -> TILDATUTORIAL.Test_Realized."userCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.userCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.userCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATUTORIAL.Test_View.userCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedUserCount()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount -> TILDATUTORIAL.Test_Realized."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("answerCount")
   Long _answerCount=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount -> TILDATUTORIAL.Test_Realized."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getAnswerCount()
      { return _answerCount==null?0l:_answerCount; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount -> TILDATUTORIAL.Test_Realized."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isAnswerCountNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount -> TILDATUTORIAL.Test_Realized."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setAnswerCount(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _answerCount == null || v != _answerCount)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask);
       _answerCount = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount -> TILDATUTORIAL.Test_Realized."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setAnswerCountNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask);
       _answerCount=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount -> TILDATUTORIAL.Test_Realized."answerCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCount of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCount of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCount)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedAnswerCount()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect -> TILDATUTORIAL.Test_Realized."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("answerCountCorrect")
   Long _answerCountCorrect=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect -> TILDATUTORIAL.Test_Realized."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getAnswerCountCorrect()
      { return _answerCountCorrect==null?0l:_answerCountCorrect; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect -> TILDATUTORIAL.Test_Realized."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isAnswerCountCorrectNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect -> TILDATUTORIAL.Test_Realized."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setAnswerCountCorrect(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _answerCountCorrect == null || v != _answerCountCorrect)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask);
       _answerCountCorrect = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect -> TILDATUTORIAL.Test_Realized."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setAnswerCountCorrectNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask);
       _answerCountCorrect=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect -> TILDATUTORIAL.Test_Realized."answerCountCorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountCorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountCorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountCorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedAnswerCountCorrect()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect -> TILDATUTORIAL.Test_Realized."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountIncorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("answerCountIncorrect")
   Long _answerCountIncorrect=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect -> TILDATUTORIAL.Test_Realized."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountIncorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getAnswerCountIncorrect()
      { return _answerCountIncorrect==null?0l:_answerCountIncorrect; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect -> TILDATUTORIAL.Test_Realized."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountIncorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isAnswerCountIncorrectNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect -> TILDATUTORIAL.Test_Realized."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountIncorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setAnswerCountIncorrect(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _answerCountIncorrect == null || v != _answerCountIncorrect)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask);
       _answerCountIncorrect = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect -> TILDATUTORIAL.Test_Realized."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountIncorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setAnswerCountIncorrectNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask);
       _answerCountIncorrect=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect -> TILDATUTORIAL.Test_Realized."answerCountIncorrect"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.answerCountIncorrect of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.answerCountIncorrect of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not (from TILDATUTORIAL.Test_View.answerCountIncorrect)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedAnswerCountIncorrect()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal -> TILDATUTORIAL.Test_Realized."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("timeMillisTotal")
   Long _timeMillisTotal=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal -> TILDATUTORIAL.Test_Realized."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getTimeMillisTotal()
      { return _timeMillisTotal==null?0l:_timeMillisTotal; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal -> TILDATUTORIAL.Test_Realized."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTimeMillisTotalNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal -> TILDATUTORIAL.Test_Realized."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTimeMillisTotal(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _timeMillisTotal == null || v != _timeMillisTotal)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask);
       _timeMillisTotal = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal -> TILDATUTORIAL.Test_Realized."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTimeMillisTotalNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask);
       _timeMillisTotal=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal -> TILDATUTORIAL.Test_Realized."timeMillisTotal"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisTotal of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisTotal of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisTotal)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTimeMillisTotal()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg -> TILDATUTORIAL.Test_Realized."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("timeMillisAvg")
   Double _timeMillisAvg=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg -> TILDATUTORIAL.Test_Realized."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final double getTimeMillisAvg()
      { return _timeMillisAvg==null?0d:_timeMillisAvg; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg -> TILDATUTORIAL.Test_Realized."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTimeMillisAvgNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg -> TILDATUTORIAL.Test_Realized."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTimeMillisAvg(double v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _timeMillisAvg == null || v != _timeMillisAvg)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask);
       _timeMillisAvg = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg -> TILDATUTORIAL.Test_Realized."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTimeMillisAvgNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask);
       _timeMillisAvg=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg -> TILDATUTORIAL.Test_Realized."timeMillisAvg"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisAvg of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisAvg of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisAvg)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTimeMillisAvg()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin -> TILDATUTORIAL.Test_Realized."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMin of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("timeMillisMin")
   Integer _timeMillisMin=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin -> TILDATUTORIAL.Test_Realized."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMin of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getTimeMillisMin()
      { return _timeMillisMin==null?0:_timeMillisMin; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin -> TILDATUTORIAL.Test_Realized."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMin of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTimeMillisMinNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin -> TILDATUTORIAL.Test_Realized."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMin of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTimeMillisMin(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _timeMillisMin == null || v != _timeMillisMin)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask);
       _timeMillisMin = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin -> TILDATUTORIAL.Test_Realized."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMin of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTimeMillisMinNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask);
       _timeMillisMin=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin -> TILDATUTORIAL.Test_Realized."timeMillisMin"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMin of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMin of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMin)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTimeMillisMin()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax -> TILDATUTORIAL.Test_Realized."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMax of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("timeMillisMax")
   Integer _timeMillisMax=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax -> TILDATUTORIAL.Test_Realized."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMax of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getTimeMillisMax()
      { return _timeMillisMax==null?0:_timeMillisMax; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax -> TILDATUTORIAL.Test_Realized."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMax of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isTimeMillisMaxNull()
     { return __Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax -> TILDATUTORIAL.Test_Realized."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMax of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTimeMillisMax(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _timeMillisMax == null || v != _timeMillisMax)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask);
       _timeMillisMax = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax -> TILDATUTORIAL.Test_Realized."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMax of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTimeMillisMaxNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask);
       __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask);
       _timeMillisMax=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax -> TILDATUTORIAL.Test_Realized."timeMillisMax"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.Test_Realized.timeMillisMax of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.Test_Realized.timeMillisMax of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question (from TILDATUTORIAL.Test_View.timeMillisMax)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTimeMillisMax()
     { return __Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.tutorial.data._Tilda.TILDA__TEST_REALIZED Dst) throws Exception
     {
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) Dst.setTestCountNull           (); else        Dst.setTestCount           (_testCount           );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask) == true) Dst.setTestFirstTZNull         (); else        Dst.setTestFirstTZ         (_testFirstTZ         );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask) == true) Dst.setTestFirstNull           (); else        Dst.setTestFirst           (_testFirst           );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask) == true) Dst.setTestLastTZNull          (); else        Dst.setTestLastTZ          (_testLastTZ          );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask) == true) Dst.setTestLastNull            (); else        Dst.setTestLast            (_testLast            );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask) == true) Dst.setUserCountNull           (); else        Dst.setUserCount           (_userCount           );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask) == true) Dst.setAnswerCountNull         (); else        Dst.setAnswerCount         (_answerCount         );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask) == true) Dst.setAnswerCountCorrectNull  (); else        Dst.setAnswerCountCorrect  (_answerCountCorrect  );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask) == true) Dst.setAnswerCountIncorrectNull(); else        Dst.setAnswerCountIncorrect(_answerCountIncorrect);
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask) == true) Dst.setTimeMillisTotalNull     (); else        Dst.setTimeMillisTotal     (_timeMillisTotal     );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask) == true) Dst.setTimeMillisAvgNull       (); else        Dst.setTimeMillisAvg       (_timeMillisAvg       );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask) == true) Dst.setTimeMillisMinNull       (); else        Dst.setTimeMillisMin       (_timeMillisMin       );
       if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask) == true) Dst.setTimeMillisMaxNull       (); else        Dst.setTimeMillisMax       (_timeMillisMax       );
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
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.tutorial.data.TILDATUTORIAL.Test_Realized has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }

       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.tutorial.data.TILDATUTORIAL.Test_Realized object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
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
               PS.setString    (++i, _type                );
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (TextUtil.isNullOrEmpty(_type) == true)
        throw new Exception("Incoming value for 'tilda.tutorial.data.TILDATUTORIAL.Test_Realized.type' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TYPE._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TYPE._Mask);

       if (_testCount != null)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask);
        }

       if (TextUtil.isNullOrEmpty(Str_testFirst) == false)
        {
          _testFirst = DateTimeUtil.parsefromJSON(Str_testFirst);
          if (   _testFirst == null)
           throw new Exception("Incoming value for 'tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_testFirst.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst' because the timezone value '"+_testFirst.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setTestFirstTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_testLast) == false)
        {
          _testLast = DateTimeUtil.parsefromJSON(Str_testLast);
          if (   _testLast == null)
           throw new Exception("Incoming value for 'tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(_testLast.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast' because the timezone value '"+_testLast.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setTestLastTZ(ZI.getId());
        }

       if (_userCount != null)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask);
        }

       if (_answerCount != null)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask);
        }

       if (_answerCountCorrect != null)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask);
        }

       if (_answerCountIncorrect != null)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask);
        }

       if (_timeMillisTotal != null)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask);
        }

       if (_timeMillisAvg != null)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask);
        }

       if (_timeMillisMin != null)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask);
        }

       if (_timeMillisMax != null)
        {
          __Changes.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask);
          __Nulls.andNot(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask);
        }
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_testFirst) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_testLast) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_Realized");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TYPE._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.TYPE.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask) == false && DateTimeUtil.isNowPlaceholder(_testFirst) == true ? C.getCommaCurrentTimestamp() : tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.TESTLAST.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask) == false && DateTimeUtil.isNowPlaceholder(_testLast) == true ? C.getCommaCurrentTimestamp() : tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask) == true) { TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_Realized"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TYPE._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.TYPE.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask) == false && DateTimeUtil.isNowPlaceholder(_testFirst) == true)
              { TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask) == false && DateTimeUtil.isNowPlaceholder(_testLast) == true)
              { TILDA__TEST_REALIZED_Factory.COLS.TESTLAST.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TEST_REALIZED_Factory.COLS.TESTLAST.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask) == true) TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX.getFullColumnVarForUpdate(C, S);

          switch (__LookupId)
           {
             case 0:
                S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "type"); S.append("=?)");
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
       QueryDetails.setLastQuery(TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATUTORIAL.Test_Realized", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TYPE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TYPE._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _type);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _testCount);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _testFirstTZ);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_testFirst) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_testFirst.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _testLastTZ);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_testLast) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_testLast.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _userCount);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _answerCount);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _answerCountCorrect);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _answerCountIncorrect);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _timeMillisTotal);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask) == true) PS.setNull(++i, java.sql.Types.DOUBLE    ); else PS.setDouble    (++i, _timeMillisAvg);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _timeMillisMin);
        } 
       if (__Changes.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _timeMillisMax);
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
             __Saved_type                 = _type                ;
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
       if (TextUtil.isNullOrEmpty(_type) == false)
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
        throw new Exception("This TILDATUTORIAL.Test_Realized object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATUTORIAL.Test_Realized object has already been read.");
          QueryDetails.setLastQuery(TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "type");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "testCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "testFirstTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "testFirst");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "testLastTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "testLast");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "userCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "answerCount");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "answerCountCorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "answerCountIncorrect");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "timeMillisTotal");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "timeMillisAvg");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "timeMillisMin");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "timeMillisMax");
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "Test_Realized");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "Test_Realized", "type"); S.append("=?)");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATUTORIAL.Test_Realized", Q, toString());
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
               PS.setString    (++i, _type                );
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TEST_REALIZED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_type                 = _type                 = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TYPE._Mask                ); _type = null; }
                                     _testCount            =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask           ); _testCount = null; }
                                     _testFirstTZ          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ._Mask         ); _testFirstTZ = null; }
                                     _testFirst            = processZDT(_testFirstTZ           , "tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testFirst"           , RS, ++i, TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST           , TILDA__TEST_REALIZED_Factory.COLS.TESTFIRSTTZ           ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask           ); _testFirst = null; }
                                     _testLastTZ           = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ._Mask          ); _testLastTZ = null; }
                                     _testLast             = processZDT(_testLastTZ            , "tilda.tutorial.data.TILDATUTORIAL.Test_Realized.testLast"            , RS, ++i, TILDA__TEST_REALIZED_Factory.COLS.TESTLAST            , TILDA__TEST_REALIZED_Factory.COLS.TESTLASTTZ            ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask            ); _testLast = null; }
                                     _userCount            =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask           ); _userCount = null; }
                                     _answerCount          =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask         ); _answerCount = null; }
                                     _answerCountCorrect   =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask  ); _answerCountCorrect = null; }
                                     _answerCountIncorrect =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask); _answerCountIncorrect = null; }
                                     _timeMillisTotal      =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask     ); _timeMillisTotal = null; }
                                     _timeMillisAvg        =                              RS.getDouble    (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask       ); _timeMillisAvg = null; }
                                     _timeMillisMin        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask       ); _timeMillisMin = null; }
                                     _timeMillisMax        =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask       ); _timeMillisMax = null; }
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
                   "type: "                                                                                                                     + TextUtil.printVariableStr        (getType                ())
               + "; testCount"              + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTCOUNT._Mask) == true ? ": NULL" : ": " +                                   getTestCount           () )
               + "; testFirst"              + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTFIRST._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getTestFirst           ()))
               + "; testLast"               + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TESTLAST._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getTestLast            ()))
               + "; userCount"              + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.USERCOUNT._Mask) == true ? ": NULL" : ": " +                                   getUserCount           () )
               + "; answerCount"            + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNT._Mask) == true ? ": NULL" : ": " +                                   getAnswerCount         () )
               + "; answerCountCorrect"     + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTCORRECT._Mask) == true ? ": NULL" : ": " +                                   getAnswerCountCorrect  () )
               + "; answerCountIncorrect"   + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.ANSWERCOUNTINCORRECT._Mask) == true ? ": NULL" : ": " +                                   getAnswerCountIncorrect() )
               + "; timeMillisTotal"        + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISTOTAL._Mask) == true ? ": NULL" : ": " +                                   getTimeMillisTotal     () )
               + "; timeMillisAvg"          + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISAVG._Mask) == true ? ": NULL" : ": " +                                   getTimeMillisAvg       () )
               + "; timeMillisMin"          + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMIN._Mask) == true ? ": NULL" : ": " +                                   getTimeMillisMin       () )
               + "; timeMillisMax"          + (__Nulls.intersects(TILDA__TEST_REALIZED_Factory.COLS.TIMEMILLISMAX._Mask) == true ? ": NULL" : ": " +                                   getTimeMillisMax       () )
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
