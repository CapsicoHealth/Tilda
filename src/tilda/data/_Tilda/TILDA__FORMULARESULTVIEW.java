/*
 Tilda V2.5 data object.

 Code is generated: do not modify! Instead, create a derived class and override desired functionality
*/

package tilda.data._Tilda;

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
<TABLE id="FormulaResultView_DIV" class="tables">
<SCRIPT>registerStickyHeader("FormulaResultView_DIV");</SCRIPT>
<TR valign="top"><TD><H2>FormulaResultView&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#FormulaResultView_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="FormulaResultView_CNT" class="content">
The View TILDA.FormulaResultView :<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>FormulaResultView_Factory</B>, <B>FormulaResultView_Data</B> in the package <B>tilda.data</B>.
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
</UL>
<B>Description</B>:<BLOCKQUOTE style="border-left: 1px solid #EEE;padding-left: 5px;">A view of formulas and their values.</BLOCKQUOTE>
<BR>
This view depends on the following filter(s), sub-view(s), and/or root table(s):
<BLOCKQUOTE><TABLE class="TreeTable Rowed" border="0px" cellspacing="0px" cellpadding="2px"></TABLE></BLOCKQUOTE>
This View contains the following columns:<BLOCKQUOTE>
 <TABLE id="FormulaResultView_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid #BBB;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">TZ</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaResultView-formulaRefnum_DIV' class='columns'>formulaRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The parent formula.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('CatalogFormulaResult-formulaRefnum_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>CatalogFormulaResult<B>&nbsp;&#8226;&nbsp;</B>formulaRefnum</A><BR>&rarr;&nbsp;<A href="javascript:openDiv('Catalog-refnum_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Catalog<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaResultView-value_DIV' class='columns'>value</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(100)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The result value.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('CatalogFormulaResult-value_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>CatalogFormulaResult<B>&nbsp;&#8226;&nbsp;</B>value</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaResultView-description_DIV' class='columns'>description</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The description of the result value.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('CatalogFormulaResult-description_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>CatalogFormulaResult<B>&nbsp;&#8226;&nbsp;</B>description</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaResultView-schemaName_DIV' class='columns'>schemaName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the schema this column is defined in.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Catalog-schemaName_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Catalog<B>&nbsp;&#8226;&nbsp;</B>schemaName</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaResultView-tableViewName_DIV' class='columns'>tableViewName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the primary table/view this column is defined in.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Catalog-tableViewName_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Catalog<B>&nbsp;&#8226;&nbsp;</B>tableViewName</A></DIV></TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaResultView-columnName_DIV' class='columns'>columnName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the column.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="javascript:openDiv('Catalog-columnName_DIV', -50)">TILDA<B>&nbsp;&#8226;&nbsp;</B>Catalog<B>&nbsp;&#8226;&nbsp;</B>columnName</A></DIV></TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__FORMULARESULTVIEW implements tilda.interfaces.ReaderObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__FORMULARESULTVIEW.class.getName());

   public transient static final Class<TILDA__FORMULARESULTVIEW_Factory> FACTORY_CLASS= TILDA__FORMULARESULTVIEW_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDA.FormulaResultView", "");

   protected TILDA__FORMULARESULTVIEW() { }

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
//   Field tilda.data.TILDA.FormulaResultView.formulaRefnum -> TILDA.FormulaResultView."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formulaRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.formulaRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.formulaRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formulaRefnum")
   Long _formulaRefnum=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.formulaRefnum -> TILDA.FormulaResultView."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formulaRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.formulaRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.formulaRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormulaRefnum()
      { return _formulaRefnum==null?0l:_formulaRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.formulaRefnum -> TILDA.FormulaResultView."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formulaRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.formulaRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.formulaRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormulaRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _formulaRefnum == null || v != _formulaRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaResultView.formulaRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULARESULTVIEW_Factory.COLS.FORMULAREFNUM._Mask);
          __Nulls.andNot(TILDA__FORMULARESULTVIEW_Factory.COLS.FORMULAREFNUM._Mask);
       _formulaRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field formulaRefnum doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initFormulaRefnum(long v) throws Exception
     {
       setFormulaRefnum(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.value -> TILDA.FormulaResultView."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>value of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.value of type varchar(100)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.value</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("value")
   String _value=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.value -> TILDA.FormulaResultView."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>value of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.value of type varchar(100)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.value</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getValue()
      { return _value; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.value -> TILDA.FormulaResultView."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>value of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.value of type varchar(100)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.value</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setValue(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaResultView.value to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 100)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaResultView.value: the size "+v.length()+" is larger than the max allowed of 100: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_value) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaResultView.value' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULARESULTVIEW_Factory.COLS.VALUE._Mask);
          __Nulls.andNot(TILDA__FORMULARESULTVIEW_Factory.COLS.VALUE._Mask);
       _value = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field value doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initValue(String v) throws Exception
     {
       setValue(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.description -> TILDA.FormulaResultView."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.description</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("description")
   String _description=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.description -> TILDA.FormulaResultView."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.description</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDescription()
      { return _description; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.description -> TILDA.FormulaResultView."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.description</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDescription(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaResultView.description to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 32000)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaResultView.description: the size "+v.length()+" is larger than the max allowed of 32000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_description) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaResultView.description' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULARESULTVIEW_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__FORMULARESULTVIEW_Factory.COLS.DESCRIPTION._Mask);
       _description = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.schemaName -> TILDA.FormulaResultView."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.schemaName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.schemaName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("schemaName")
   String _schemaName=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.schemaName -> TILDA.FormulaResultView."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.schemaName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.schemaName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getSchemaName()
      { return _schemaName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.schemaName -> TILDA.FormulaResultView."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.schemaName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.schemaName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setSchemaName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaResultView.schemaName to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaResultView.schemaName: the size "+v.length()+" is larger than the max allowed of 128: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_schemaName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaResultView.schemaName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULARESULTVIEW_Factory.COLS.SCHEMANAME._Mask);
          __Nulls.andNot(TILDA__FORMULARESULTVIEW_Factory.COLS.SCHEMANAME._Mask);
       _schemaName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field schemaName doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initSchemaName(String v) throws Exception
     {
       setSchemaName(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.tableViewName -> TILDA.FormulaResultView."tableViewName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.tableViewName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.tableViewName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("tableViewName")
   String _tableViewName=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.tableViewName -> TILDA.FormulaResultView."tableViewName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.tableViewName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.tableViewName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getTableViewName()
      { return _tableViewName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.tableViewName -> TILDA.FormulaResultView."tableViewName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.tableViewName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.tableViewName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTableViewName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaResultView.tableViewName to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaResultView.tableViewName: the size "+v.length()+" is larger than the max allowed of 128: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_tableViewName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaResultView.tableViewName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULARESULTVIEW_Factory.COLS.TABLEVIEWNAME._Mask);
          __Nulls.andNot(TILDA__FORMULARESULTVIEW_Factory.COLS.TABLEVIEWNAME._Mask);
       _tableViewName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field tableViewName doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initTableViewName(String v) throws Exception
     {
       setTableViewName(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.columnName -> TILDA.FormulaResultView."columnName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>columnName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.columnName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.columnName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("columnName")
   String _columnName=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.columnName -> TILDA.FormulaResultView."columnName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>columnName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.columnName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.columnName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getColumnName()
      { return _columnName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResultView.columnName -> TILDA.FormulaResultView."columnName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>columnName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResultView.columnName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.FormulaResultView.columnName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setColumnName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaResultView.columnName to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaResultView.columnName: the size "+v.length()+" is larger than the max allowed of 128: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_columnName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaResultView.columnName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULARESULTVIEW_Factory.COLS.COLUMNNAME._Mask);
          __Nulls.andNot(TILDA__FORMULARESULTVIEW_Factory.COLS.COLUMNNAME._Mask);
       _columnName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field columnName doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initColumnName(String v) throws Exception
     {
       setColumnName(v);
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
        throw new Exception("This TILDA.FormulaResultView object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.FormulaResultView object has already been read.");
          QueryDetails.setLastQuery(TILDA__FORMULARESULTVIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__FORMULARESULTVIEW_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "FormulaResultView");
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
       QueryDetails.setLastQuery(TILDA__FORMULARESULTVIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.FormulaResultView", Q, toString());
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__FORMULARESULTVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                              _formulaRefnum =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__FORMULARESULTVIEW_Factory.COLS.FORMULAREFNUM._Mask); _formulaRefnum = null; }
                              _value         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__FORMULARESULTVIEW_Factory.COLS.VALUE._Mask        ); _value = null; }
                              _description   = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__FORMULARESULTVIEW_Factory.COLS.DESCRIPTION._Mask  ); _description = null; }
                              _schemaName    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__FORMULARESULTVIEW_Factory.COLS.SCHEMANAME._Mask   ); _schemaName = null; }
                              _tableViewName = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__FORMULARESULTVIEW_Factory.COLS.TABLEVIEWNAME._Mask); _tableViewName = null; }
                              _columnName    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__FORMULARESULTVIEW_Factory.COLS.COLUMNNAME._Mask   ); _columnName = null; }
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
                   "formulaRefnum: "                                                                                                  +                                   getFormulaRefnum()
               + "; value: "                                                                                                          + TextUtil.printVariableStr        (getValue        ())
               + "; description: "                                                                                                    + TextUtil.printVariableStr        (getDescription  ())
               + "; schemaName: "                                                                                                     + TextUtil.printVariableStr        (getSchemaName   ())
               + "; tableViewName: "                                                                                                  + TextUtil.printVariableStr        (getTableViewName())
               + "; columnName: "                                                                                                     + TextUtil.printVariableStr        (getColumnName   ())
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
          case "": tilda.data.FormulaResultView_Factory.toJSON(out, (tilda.data.FormulaResultView_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data.FormulaResultView_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data.FormulaResultView_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data.FormulaResultView_Factory.toCSV(out, (tilda.data.FormulaResultView_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data.FormulaResultView_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data.FormulaResultView_Factory");
    }
 }
