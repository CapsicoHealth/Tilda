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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
<TABLE id="Form_SAT01_PivotView_DIV" class="tables">
<SCRIPT>registerStickyHeader("Form_SAT01_PivotView_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Form_SAT01_PivotView&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Form_SAT01_PivotView_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Form_SAT01_PivotView_CNT" class="content">
The View TILDATEST.Form_SAT01_PivotView:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Form_SAT01_PivotView_Factory</B>, <B>Form_SAT01_PivotView_Data</B> in the package <B>tilda.data_test</B>.
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Defines a foreign key to <A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A> </LI>
</UL>
<B>Description</B>: A pivoted view of SAT_01 forms<BR>
<BR>
This view depends on the following filter(s), sub-view(s), and/or root table(s):
<BLOCKQUOTE><TABLE class="TreeTable Rowed" border="0px" cellspacing="0px" cellpadding="2px"><TR><TD><PRE><A href="TILDA___Docs.TILDATEST.html#Form_SAT01_PivotView_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Form_SAT01_PivotView</A></PRE></TD><TD>Only look at SAT_01 forms and answers that have not been deleted.<PRE>    Form.type = 'SAT_01'
and Form.deleted is null
and FormAnswer.deleted is null</PRE></TD></TR>
<TR><TD><PRE>    <A href="TILDA___Docs.TILDATEST.html#Form_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Form</A></PRE></TD><TD><PRE>Root table for the view TILDATEST.Form_SAT01_PivotView</PRE></TD></TR>
<TR><TD><PRE>    <A href="TILDA___Docs.TILDATEST.html#User_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>User</A></PRE></TD><TD><PRE>Standard join</PRE></TD></TR>
<TR><TD><PRE>    <A href="TILDA___Docs.TILDATEST.html#FormAnswer_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>FormAnswer</A></PRE></TD><TD><PRE>Standard join</PRE></TD></TR>
</TABLE></BLOCKQUOTE>
A pivot was done as part of this view explicitly on the following columns and values:<BLOCKQUOTE><PRE><TABLE class="Rowed" cellspacing="0px" border="0px">
<TR valign="top" class="RowedSection"><TD><B>field</B></TD><TD colspan="2">question/field id</TD></TR>
<TR><TD></TD><TD>Q1</TD><TD>Q1</TD></TR>
<TR><TD></TD><TD>Q2</TD><TD>Q2</TD></TR>
<TR><TD></TD><TD>Q3</TD><TD>Q3</TD></TR>
<TR><TD></TD><TD>Q4</TD><TD>Q4</TD></TR>
</TABLE></PRE></BLOCKQUOTE>
This View contains the following columns:<BLOCKQUOTE>
 <TABLE id="Form_SAT01_PivotView_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Form_SAT01_PivotView-formRefnum_DIV' class='columns'>formRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Form-refnum_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Form_SAT01_PivotView-formFillDateTZ_DIV' class='columns'>formFillDateTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'formFillDate'.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Form-fillDateTZ_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>fillDateTZ</A><BR>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo-id_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo<B>&nbsp;&#8226;&nbsp;</B>id</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Form_SAT01_PivotView-formFillDate_DIV' class='columns'>formFillDate</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The date the form was filled<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#Form-fillDate_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>Form<B>&nbsp;&#8226;&nbsp;</B>fillDate</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Form_SAT01_PivotView-formUserRefnum_DIV' class='columns'>formUserRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#User-refnum_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>User<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='Form_SAT01_PivotView-formUserEmail_DIV' class='columns'>formUserEmail</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(255)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The user's email<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDATEST.html#User-email_DIV">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>User<B>&nbsp;&#8226;&nbsp;</B>email</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Form_SAT01_PivotView-Q1_DIV' class='columns'>Q1</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Q1 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q1')</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='Form_SAT01_PivotView-Q2_DIV' class='columns'>Q2</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Q2 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q2')</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Form_SAT01_PivotView-Q3_DIV' class='columns'>Q3</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Q3 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q3')</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Form_SAT01_PivotView-Q4_DIV' class='columns'>Q4</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(4000)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Q4 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q4')</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__FORM_SAT01_PIVOTVIEW implements tilda.interfaces.ReaderObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__FORM_SAT01_PIVOTVIEW.class.getName());

   public static final Class<TILDA__FORM_SAT01_PIVOTVIEW_Factory> FACTORY_CLASS= TILDA__FORM_SAT01_PIVOTVIEW_Factory.class;
   public static final String TABLENAME = TextUtil.Print("TILDATEST.Form_SAT01_PivotView", "");

   protected TILDA__FORM_SAT01_PIVOTVIEW() { }

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
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formRefnum -> TILDATEST.Form_SAT01_PivotView."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _formRefnum= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formRefnum -> TILDATEST.Form_SAT01_PivotView."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormRefnum()
      { return _formRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formRefnum -> TILDATEST.Form_SAT01_PivotView."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formRefnum of type bigint</TD></TR>

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
       if (__Init == InitMode.CREATE || v != _formRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Form_SAT01_PivotView.formRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMREFNUM._Mask);
          __Nulls.andNot(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMREFNUM._Mask);
       _formRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ -> TILDATEST.Form_SAT01_PivotView."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formFillDateTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _formFillDateTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ -> TILDATEST.Form_SAT01_PivotView."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formFillDateTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
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
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ -> TILDATEST.Form_SAT01_PivotView."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formFillDateTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFormFillDateTZ()
     { return __Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATETZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ -> TILDATEST.Form_SAT01_PivotView."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formFillDateTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
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
          setNullFormFillDateTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 5.");
       else if (v.equals(_formFillDateTZ) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATETZ._Mask);
          __Nulls.andNot(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATETZ._Mask);
       _formFillDateTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ -> TILDATEST.Form_SAT01_PivotView."formFillDateTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDateTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formFillDateTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'formFillDate'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullFormFillDateTZ()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATETZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATETZ._Mask);
       __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATETZ._Mask);
       _formFillDateTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate -> TILDATEST.Form_SAT01_PivotView."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   ZonedDateTime _formFillDate;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate -> TILDATEST.Form_SAT01_PivotView."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formFillDate of type timestamptz</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate -> TILDATEST.Form_SAT01_PivotView."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFormFillDate()
     { return __Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate -> TILDATEST.Form_SAT01_PivotView."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formFillDate of type timestamptz</TD></TR>

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
          setNullFormFillDate();
        }
       else if (v.equals(_formFillDate) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATE._Mask);
          __Nulls.andNot(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATE._Mask);
       _formFillDate = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setFormFillDateTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate -> TILDATEST.Form_SAT01_PivotView."formFillDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formFillDate of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The date the form was filled</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullFormFillDate()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATE._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATE._Mask);
       __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATE._Mask);
       _formFillDate=null;
       setNullFormFillDateTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserRefnum -> TILDATEST.Form_SAT01_PivotView."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _formUserRefnum= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserRefnum -> TILDATEST.Form_SAT01_PivotView."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formUserRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormUserRefnum()
      { return _formUserRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserRefnum -> TILDATEST.Form_SAT01_PivotView."formUserRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formUserRefnum of type bigint</TD></TR>

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
       if (__Init == InitMode.CREATE || v != _formUserRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMUSERREFNUM._Mask);
          __Nulls.andNot(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMUSERREFNUM._Mask);
       _formUserRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserEmail -> TILDATEST.Form_SAT01_PivotView."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formUserEmail of type varchar(255)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>255</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The user's email</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _formUserEmail;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserEmail -> TILDATEST.Form_SAT01_PivotView."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formUserEmail of type varchar(255)</TD></TR>

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
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserEmail -> TILDATEST.Form_SAT01_PivotView."formUserEmail"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserEmail of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.formUserEmail of type varchar(255)</TD></TR>

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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserEmail to null: it's not nullable.");
       else if (v.length() > 255)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserEmail: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 255.");
       else if (v.equals(_formUserEmail) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Form_SAT01_PivotView.formUserEmail' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMUSEREMAIL._Mask);
          __Nulls.andNot(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMUSEREMAIL._Mask);
       _formUserEmail = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1 -> TILDATEST.Form_SAT01_PivotView."Q1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q1 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q1 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q1')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _Q1= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1 -> TILDATEST.Form_SAT01_PivotView."Q1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q1 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q1 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q1')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getQ1()
      { return _Q1; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1 -> TILDATEST.Form_SAT01_PivotView."Q1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q1 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q1 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q1')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullQ1()
     { return __Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q1._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1 -> TILDATEST.Form_SAT01_PivotView."Q1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q1 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q1 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q1')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setQ1(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _Q1)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q1._Mask);
          __Nulls.andNot(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q1._Mask);
       _Q1 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1 -> TILDATEST.Form_SAT01_PivotView."Q1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q1 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q1 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q1')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullQ1()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q1._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q1._Mask);
       __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q1._Mask);
       _Q1=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2 -> TILDATEST.Form_SAT01_PivotView."Q2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q2 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q2 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q2')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _Q2= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2 -> TILDATEST.Form_SAT01_PivotView."Q2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q2 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q2 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q2')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getQ2()
      { return _Q2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2 -> TILDATEST.Form_SAT01_PivotView."Q2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q2 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q2 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q2')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullQ2()
     { return __Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2 -> TILDATEST.Form_SAT01_PivotView."Q2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q2 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q2 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q2')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setQ2(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _Q2)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q2._Mask);
          __Nulls.andNot(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q2._Mask);
       _Q2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2 -> TILDATEST.Form_SAT01_PivotView."Q2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q2 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q2 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q2 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q2')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullQ2()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q2._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q2._Mask);
       __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q2._Mask);
       _Q2=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3 -> TILDATEST.Form_SAT01_PivotView."Q3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q3 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q3 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q3')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   int _Q3= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3 -> TILDATEST.Form_SAT01_PivotView."Q3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q3 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q3 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q3')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getQ3()
      { return _Q3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3 -> TILDATEST.Form_SAT01_PivotView."Q3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q3 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q3 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q3')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullQ3()
     { return __Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3 -> TILDATEST.Form_SAT01_PivotView."Q3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q3 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q3 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q3')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setQ3(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _Q3)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q3._Mask);
          __Nulls.andNot(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q3._Mask);
       _Q3 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3 -> TILDATEST.Form_SAT01_PivotView."Q3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q3 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q3 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q3 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q3')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullQ3()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q3._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q3._Mask);
       __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q3._Mask);
       _Q3=0;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4 -> TILDATEST.Form_SAT01_PivotView."Q4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q4 of type varchar(4000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>4000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q4 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q4')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _Q4;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4 -> TILDATEST.Form_SAT01_PivotView."Q4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q4 of type varchar(4000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>4000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q4 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q4')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getQ4()
      { return _Q4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4 -> TILDATEST.Form_SAT01_PivotView."Q4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q4 of type varchar(4000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>4000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q4 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q4')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullQ4()
     { return __Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4 -> TILDATEST.Form_SAT01_PivotView."Q4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q4 of type varchar(4000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>4000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q4 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q4')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setQ4(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullQ4();
        }
       else if (v.length() > 4000)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 4000.");
       else if (v.equals(_Q4) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q4._Mask);
          __Nulls.andNot(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q4._Mask);
       _Q4 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4 -> TILDATEST.Form_SAT01_PivotView."Q4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Form_SAT01_PivotView.Q4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Form_SAT01_PivotView.Q4 of type varchar(4000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>4000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Q4 (pivot of MAX(TILDATEST.FormAnswer.value) on TILDATEST.FormAnswer.field='Q4')</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullQ4()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q4._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q4._Mask);
       __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q4._Mask);
       _Q4=null;
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
        throw new Exception("This TILDATEST.Form_SAT01_PivotView object is being Read() after a Create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATEST.Form_SAT01_PivotView object has already been read.");
          QueryDetails.setLastQuery(TILDA__FORM_SAT01_PIVOTVIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDATEST", "Form_SAT01_PivotView", "formRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Form_SAT01_PivotView", "formFillDateTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Form_SAT01_PivotView", "formFillDate");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Form_SAT01_PivotView", "formUserRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Form_SAT01_PivotView", "formUserEmail");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Form_SAT01_PivotView", "Q1");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Form_SAT01_PivotView", "Q2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Form_SAT01_PivotView", "Q3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Form_SAT01_PivotView", "Q4");
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "Form_SAT01_PivotView");
       switch (__LookupId)
        {
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__FORM_SAT01_PIVOTVIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATEST.Form_SAT01_PivotView", Q, toString());
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
          return Init(C, RS);
        }
       catch (java.sql.SQLException E)
        {
          return C.handleCatch(E, "selected");
        }
       finally
        {
          tilda.data_test._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__FORM_SAT01_PIVOTVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                               _formRefnum     =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMREFNUM._Mask    );
                               _formFillDateTZ = TextUtil.Trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATETZ._Mask); else _formFillDateTZ = _formFillDateTZ.trim();
                               _formFillDate   = ProcessZDT(_formFillDateTZ  , "tilda.data_test.TILDATEST.Form_SAT01_PivotView.formFillDate"  , RS, ++i, TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATE  , TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATETZ  ); if (RS.wasNull() == true) __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATE._Mask  );
                               _formUserRefnum =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMUSERREFNUM._Mask);
                               _formUserEmail  = TextUtil.Trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMUSEREMAIL._Mask );
                               _Q1             =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q1._Mask            );
                               _Q2             =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q2._Mask            );
                               _Q3             =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q3._Mask            );
                               _Q4             = TextUtil.Trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q4._Mask            );
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
                   "formRefnum: "                                                                                                          +                                   getFormRefnum    () 
               + "; formFillDate"     + (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.FORMFILLDATE._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getFormFillDate  ()))
               + "; formUserRefnum: "                                                                                                      +                                   getFormUserRefnum() 
               + "; formUserEmail: "                                                                                                       + TextUtil.PrintVariableStr        (getFormUserEmail ())
               + "; Q1"               + (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q1._Mask) == true ? ": NULL" : ": " +                                   getQ1            () )
               + "; Q2"               + (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q2._Mask) == true ? ": NULL" : ": " +                                   getQ2            () )
               + "; Q3"               + (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q3._Mask) == true ? ": NULL" : ": " +                                   getQ3            () )
               + "; Q4"               + (__Nulls.intersects(TILDA__FORM_SAT01_PIVOTVIEW_Factory.COLS.Q4._Mask) == true ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getQ4            ()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
