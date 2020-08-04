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
<TABLE id="TestAnswer_DIV" class="tables">
<SCRIPT>registerStickyHeader("TestAnswer_DIV");</SCRIPT>
<TR valign="top"><TD><H2>TestAnswer&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#TestAnswer_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="TestAnswer_CNT" class="content">
The Table TILDATUTORIAL.TestAnswer:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>TestAnswer_Factory</B>, <B>TestAnswer_Data</B> in the package <B>tilda.tutorial.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Defines a foreign key to <A href="TILDA___Docs.TILDATUTORIAL.html#Form_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form</A> </LI>
<LI>Has the following identities:<UL><LI>Primary Key: refnum</LI>
<LI>Unique Index: formRefnum, questionId</LI>
</UL></LI>
</UL>
<B>Description</B>: Test answers<BR>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="TestAnswer_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestAnswer-refnum_DIV' class='columns'>refnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestAnswer-formRefnum_DIV' class='columns'>formRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The form's refnum<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDATUTORIAL.html#Form_CNT">TILDATUTORIAL<B>&nbsp;&#8226;&nbsp;</B>Form</A>: refnum</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestAnswer-questionId_DIV' class='columns'>questionId</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(60)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Question id</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestAnswer-answerId_DIV' class='columns'>answerId</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(60)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Answer value</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestAnswer-timeMillis_DIV' class='columns'>timeMillis</B>&nbsp;&nbsp;</TD>
<TD>int&nbsp;/&nbsp;integer&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Time in milliseconds for the time spent answering the question</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestAnswer-correct_DIV' class='columns'>correct</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the answer is correct or not</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestAnswer-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestAnswer-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestAnswer-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TESTANSWER implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__TESTANSWER.class.getName());

   public transient static final Class<TILDA__TESTANSWER_Factory> FACTORY_CLASS= TILDA__TESTANSWER_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDATUTORIAL.TestAnswer", "");

   protected TILDA__TESTANSWER() { }

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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.refnum -> TILDATUTORIAL.TestAnswer."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.refnum of type bigint</TD></TR>

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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.refnum -> TILDATUTORIAL.TestAnswer."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.refnum of type bigint</TD></TR>

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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.refnum -> TILDATUTORIAL.TestAnswer."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.refnum of type bigint</TD></TR>

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
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.TestAnswer.refnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.REFNUM._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.REFNUM._Mask);
       _refnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum -> TILDATUTORIAL.TestAnswer."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The form's refnum</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum -> TILDATUTORIAL.TestAnswer."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The form's refnum</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormRefnum()
      { return _formRefnum==null?0l:_formRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum -> TILDATUTORIAL.TestAnswer."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The form's refnum</TD></TR>
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
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.FORMREFNUM._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.FORMREFNUM._Mask);
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum -> TILDATUTORIAL.TestAnswer."formRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.formRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The form's refnum</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFormRefnum()
     { return __Changes.intersects(TILDA__TESTANSWER_Factory.COLS.FORMREFNUM._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId -> TILDATUTORIAL.TestAnswer."questionId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.questionId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("questionId")
   String _questionId=null;
   protected String __Saved_questionId;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId -> TILDATUTORIAL.TestAnswer."questionId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.questionId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getQuestionId()
      { return _questionId; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId -> TILDATUTORIAL.TestAnswer."questionId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.questionId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setQuestionId(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId to null: it's not nullable.");
       else if (v.length() > 60)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId: the size "+v.length()+" is larger than the max allowed of 60: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_questionId) == false)
        {
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.QUESTIONID._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.QUESTIONID._Mask);
       _questionId = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId -> TILDATUTORIAL.TestAnswer."questionId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.questionId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedQuestionId()
     { return __Changes.intersects(TILDA__TESTANSWER_Factory.COLS.QUESTIONID._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId -> TILDATUTORIAL.TestAnswer."answerId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.answerId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Answer value</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("answerId")
   String _answerId=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId -> TILDATUTORIAL.TestAnswer."answerId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.answerId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Answer value</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getAnswerId()
      { return _answerId; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId -> TILDATUTORIAL.TestAnswer."answerId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.answerId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Answer value</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isAnswerIdNull()
     { return __Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId -> TILDATUTORIAL.TestAnswer."answerId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.answerId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Answer value</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setAnswerId(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setAnswerIdNull();
        }
       else if (v.length() > 60)
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId: the size "+v.length()+" is larger than the max allowed of 60: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_answerId) == false)
        {
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask);
       _answerId = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId -> TILDATUTORIAL.TestAnswer."answerId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.answerId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Answer value</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setAnswerIdNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask);
       __Nulls.or(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask);
       _answerId=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId -> TILDATUTORIAL.TestAnswer."answerId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.answerId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.answerId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Answer value</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedAnswerId()
     { return __Changes.intersects(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis -> TILDATUTORIAL.TestAnswer."timeMillis"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.timeMillis of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("timeMillis")
   Integer _timeMillis=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis -> TILDATUTORIAL.TestAnswer."timeMillis"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.timeMillis of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final int getTimeMillis()
      { return _timeMillis==null?0:_timeMillis; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis -> TILDATUTORIAL.TestAnswer."timeMillis"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.timeMillis of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTimeMillis(int v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _timeMillis == null || v != _timeMillis)
        {
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS._Mask);
       _timeMillis = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis -> TILDATUTORIAL.TestAnswer."timeMillis"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.timeMillis of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Time in milliseconds for the time spent answering the question</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTimeMillis()
     { return __Changes.intersects(TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct -> TILDATUTORIAL.TestAnswer."correct"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.correct of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("correct")
   Boolean _correct=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct -> TILDATUTORIAL.TestAnswer."correct"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.correct of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getCorrect()
      { return _correct==null?false:_correct; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct -> TILDATUTORIAL.TestAnswer."correct"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.correct of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setCorrect(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _correct == null || v != _correct)
        {
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.CORRECT._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.CORRECT._Mask);
       _correct = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct -> TILDATUTORIAL.TestAnswer."correct"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.correct of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is correct or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedCorrect()
     { return __Changes.intersects(TILDA__TESTANSWER_Factory.COLS.CORRECT._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created -> TILDATUTORIAL.TestAnswer."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created -> TILDATUTORIAL.TestAnswer."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created -> TILDATUTORIAL.TestAnswer."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask);
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created -> TILDATUTORIAL.TestAnswer."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created -> TILDATUTORIAL.TestAnswer."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created -> TILDATUTORIAL.TestAnswer."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created -> TILDATUTORIAL.TestAnswer."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
     { return __Changes.intersects(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated -> TILDATUTORIAL.TestAnswer."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated -> TILDATUTORIAL.TestAnswer."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated -> TILDATUTORIAL.TestAnswer."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
        throw new Exception("Cannot set tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated -> TILDATUTORIAL.TestAnswer."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated -> TILDATUTORIAL.TestAnswer."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated -> TILDATUTORIAL.TestAnswer."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated -> TILDATUTORIAL.TestAnswer."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
     { return __Changes.intersects(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted -> TILDATUTORIAL.TestAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _deleted = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted -> TILDATUTORIAL.TestAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDeleted()
      { return _deleted; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted -> TILDATUTORIAL.TestAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDeletedNull()
     { return __Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted -> TILDATUTORIAL.TestAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask);
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted -> TILDATUTORIAL.TestAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDeletedNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask);
       __Nulls.or(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask);
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted -> TILDATUTORIAL.TestAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted -> TILDATUTORIAL.TestAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted -> TILDATUTORIAL.TestAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD></TR>
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
//   Field tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted -> TILDATUTORIAL.TestAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestAnswer.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestAnswer.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestAnswer)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleted()
     { return __Changes.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.tutorial.data._Tilda.TILDA__TESTANSWER Dst) throws Exception
     {
       Dst.setQuestionId (_questionId );
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask) == true) Dst.setAnswerIdNull   (); else        Dst.setAnswerId   (_answerId   );
       Dst.setTimeMillis (_timeMillis );
       Dst.setCorrect    (_correct    );
       Dst.setLastUpdated(_lastUpdated);
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask) == true) Dst.setDeletedNull    (); else        Dst.setDeleted    (_deleted    );
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
          setRefnum(tilda.db.KeysManager.getKey("TILDATUTORIAL.TESTANSWER"));
        }

       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.tutorial.data.TILDATUTORIAL.TestAnswer has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }


       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.tutorial.data.TILDATUTORIAL.TestAnswer object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
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
             case 1:
               PS.setLong      (++i, _formRefnum );
               PS.setString    (++i, _questionId );
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (_formRefnum == null)
        throw new Exception("Incoming value for 'tilda.tutorial.data.TILDATUTORIAL.TestAnswer.formRefnum' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.FORMREFNUM._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.FORMREFNUM._Mask);

       if (TextUtil.isNullOrEmpty(_questionId) == true)
        throw new Exception("Incoming value for 'tilda.tutorial.data.TILDATUTORIAL.TestAnswer.questionId' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.QUESTIONID._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.QUESTIONID._Mask);

       if (TextUtil.isNullOrEmpty(_answerId) == false)
        {
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask);
        }

       if (_timeMillis == null)
        throw new Exception("Incoming value for 'tilda.tutorial.data.TILDATUTORIAL.TestAnswer.timeMillis' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS._Mask);

       if (_correct == null)
        throw new Exception("Incoming value for 'tilda.tutorial.data.TILDATUTORIAL.TestAnswer.correct' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__TESTANSWER_Factory.COLS.CORRECT._Mask);
          __Nulls.andNot(TILDA__TESTANSWER_Factory.COLS.CORRECT._Mask);
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_created) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_deleted) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDATUTORIAL", "TestAnswer");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.REFNUM._Mask) == true) { TILDA__TESTANSWER_Factory.COLS.REFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.FORMREFNUM._Mask) == true) { TILDA__TESTANSWER_Factory.COLS.FORMREFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.QUESTIONID._Mask) == true) { TILDA__TESTANSWER_Factory.COLS.QUESTIONID.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask) == true) { TILDA__TESTANSWER_Factory.COLS.ANSWERID.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS._Mask) == true) { TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.CORRECT._Mask) == true) { TILDA__TESTANSWER_Factory.COLS.CORRECT.getFullColumnVarForInsert(C, S); V.append(tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask) == true) { TILDA__TESTANSWER_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__TESTANSWER_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__TESTANSWER_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          else { TILDA__TESTANSWER_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask) == true) { TILDA__TESTANSWER_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.tutorial.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDATUTORIAL", "TestAnswer"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.REFNUM._Mask) == true) TILDA__TESTANSWER_Factory.COLS.REFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.FORMREFNUM._Mask) == true) TILDA__TESTANSWER_Factory.COLS.FORMREFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.QUESTIONID._Mask) == true) TILDA__TESTANSWER_Factory.COLS.QUESTIONID.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask) == true) TILDA__TESTANSWER_Factory.COLS.ANSWERID.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS._Mask) == true) TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.CORRECT._Mask) == true) TILDA__TESTANSWER_Factory.COLS.CORRECT.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__TESTANSWER_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTANSWER_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__TESTANSWER_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTANSWER_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__TESTANSWER_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__TESTANSWER_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTANSWER_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0:
                S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "refnum"); S.append("=?)");
                break;
             case 1:
                S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "formRefnum"); S.append("=? AND "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "questionId"); S.append("=?)");
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
       QueryDetails.setLastQuery(TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATUTORIAL.TestAnswer", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.REFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.REFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _refnum);
        } 
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.FORMREFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.FORMREFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _formRefnum);
        } 
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.QUESTIONID._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.QUESTIONID._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _questionId);
        } 
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask) == true) PS.setNull(++i, java.sql.Types.CHAR      ); else PS.setString    (++i, _answerId);
        } 
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS._Mask) == true) PS.setNull(++i, java.sql.Types.INTEGER   ); else PS.setInt       (++i, _timeMillis);
        } 
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.CORRECT._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.CORRECT._Mask) == true) PS.setNull(++i, java.sql.Types.BOOLEAN   ); else PS.setBoolean   (++i, _correct);
        } 
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_created.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_lastUpdated.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_deleted.toInstant()), DateTimeUtil._UTC_CALENDAR);
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
          case 1:
             __Saved_formRefnum  = _formRefnum ;
             __Saved_questionId  = _questionId ;
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
             // Auto PK
             setRefnum(tilda.db.KeysManager.getKey("TILDATUTORIAL.TESTANSWER"));
             return write(C);
           }
        }
       else
        {
          initForCreate();
          // Auto PK
          setRefnum(tilda.db.KeysManager.getKey("TILDATUTORIAL.TESTANSWER"));
          if (write(C) == false)
           {
             initForLookup(lookupId);
              // Undo auto PK
              __Changes.andNot(TILDA__TESTANSWER_Factory.COLS.REFNUM._Mask);
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

       // Testing if cols for unique index FormAnswer were set - Id: 1
       if (_formRefnum != null && TextUtil.isNullOrEmpty(_questionId) == false)
        return 1;

       // Testing if primary key has been set - Id: 0
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
        throw new Exception("This TILDATUTORIAL.TestAnswer object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATUTORIAL.TestAnswer object has already been read.");
          QueryDetails.setLastQuery(TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "refnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "formRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "questionId");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "answerId");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "timeMillis");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "correct");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "created");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "deleted");
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "TestAnswer");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "refnum"); S.append("=?)");
             break;
          case 1:
             S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "formRefnum"); S.append("=? AND "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestAnswer", "questionId"); S.append("=?)");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATUTORIAL.TestAnswer", Q, toString());
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
               PS.setLong      (++i, _refnum     );
               break;
             case 1:
               PS.setLong      (++i, _formRefnum );
               PS.setString    (++i, _questionId );
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TESTANSWER_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_refnum      = _refnum      =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTANSWER_Factory.COLS.REFNUM._Mask     );
      __Saved_formRefnum  = _formRefnum  =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTANSWER_Factory.COLS.FORMREFNUM._Mask );
      __Saved_questionId  = _questionId  = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTANSWER_Factory.COLS.QUESTIONID._Mask );
                            _answerId    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask   );
                            _timeMillis  =                              RS.getInt       (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTANSWER_Factory.COLS.TIMEMILLIS._Mask );
                            _correct     =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTANSWER_Factory.COLS.CORRECT._Mask    );
                            _created     = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTANSWER_Factory.COLS.CREATED._Mask    );
                            _lastUpdated = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTANSWER_Factory.COLS.LASTUPDATED._Mask);
                            _deleted     = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask    );
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
                   "refnum: "                                                                                              +                                   getRefnum     () 
               + "; formRefnum: "                                                                                          +                                   getFormRefnum () 
               + "; questionId: "                                                                                          + TextUtil.printVariableStr        (getQuestionId ())
               + "; answerId"      + (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.ANSWERID._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getAnswerId   ()))
               + "; timeMillis: "                                                                                          +                                   getTimeMillis () 
               + "; correct: "                                                                                             +                                   getCorrect    () 
               + "; created: "                                                                                             + DateTimeUtil.printDateTimeForJSON(getCreated    ())
               + "; lastUpdated: "                                                                                         + DateTimeUtil.printDateTimeForJSON(getLastUpdated())
               + "; deleted"       + (__Nulls.intersects(TILDA__TESTANSWER_Factory.COLS.DELETED._Mask) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDeleted    ()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
