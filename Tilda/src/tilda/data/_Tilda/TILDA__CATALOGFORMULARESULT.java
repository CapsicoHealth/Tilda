/*
 Tilda V2.5 data object.

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
<TABLE id="CatalogFormulaResult_DIV" class="tables">
<SCRIPT>registerStickyHeader("CatalogFormulaResult_DIV");</SCRIPT>
<TR valign="top"><TD><H2>CatalogFormulaResult&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#CatalogFormulaResult_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="CatalogFormulaResult_CNT" class="content">
The Table TILDA.CatalogFormulaResult :<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>CatalogFormulaResult_Factory</B>, <B>CatalogFormulaResult_Data</B> in the package <B>tilda.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Defines a foreign key:<BR>
<TABLE style="margin-left: 25px; border:1px solid #BBB;" cellspacing="0px" cellpadding="5px" border="0px">
<TR style="background-color:#DDD; font-weight:bold;"><TD></TD><TD>Source Columns</TD><TD>Destination Object</TD><TD>Destination Columns</TD><TD>Notes</TD></TR>
<TR ><TD>1</TD><TD>formulaRefnum</TD><TD><A href="TILDA___Docs.TILDA.html#Catalog_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>Catalog</A></TD><TD>refnum</TD><TD>&nbsp;</TD></TR>
</TABLE></LI>
<LI>Has the following identity:<UL><LI>Primary Key: formulaRefnum, value</LI>
</UL></LI>
</UL>
<B>Description</B>:<BLOCKQUOTE style="border-left: 1px solid #EEE;padding-left: 5px;">Master formula result information, if applicable. Some formulas may not yield an enumeratable value (e.g., returning a date)</BLOCKQUOTE>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="CatalogFormulaResult_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid #BBB;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">TZ</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='CatalogFormulaResult-formulaRefnum_DIV' class='columns'>formulaRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The parent formula.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Catalog_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>Catalog</A>: refnum</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='CatalogFormulaResult-value_DIV' class='columns'>value</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(100)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The result value.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='CatalogFormulaResult-description_DIV' class='columns'>description</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The description of the result value.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='CatalogFormulaResult-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created. (TILDA.CatalogFormulaResult)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='CatalogFormulaResult-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDA.CatalogFormulaResult)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='CatalogFormulaResult-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__CATALOGFORMULARESULT implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__CATALOGFORMULARESULT.class.getName());

   public transient static final Class<TILDA__CATALOGFORMULARESULT_Factory> FACTORY_CLASS= TILDA__CATALOGFORMULARESULT_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDA.CatalogFormulaResult", "");

   protected TILDA__CATALOGFORMULARESULT() { }

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
//   Field tilda.data.TILDA.CatalogFormulaResult.formulaRefnum -> TILDA.CatalogFormulaResult."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formulaRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.formulaRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.formulaRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formulaRefnum")
   Long _formulaRefnum=null;
   protected Long __Saved_formulaRefnum;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.formulaRefnum -> TILDA.CatalogFormulaResult."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formulaRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.formulaRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.formulaRefnum</TD></TR>

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
//   Field tilda.data.TILDA.CatalogFormulaResult.formulaRefnum -> TILDA.CatalogFormulaResult."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formulaRefnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.formulaRefnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.formulaRefnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setFormulaRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _formulaRefnum == null || v != _formulaRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.CatalogFormulaResult.formulaRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM._Mask);
          __Nulls.andNot(TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM._Mask);
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
//   Field tilda.data.TILDA.CatalogFormulaResult.value -> TILDA.CatalogFormulaResult."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>value of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.value of type varchar(100)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.value</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("value")
   String _value=null;
   protected String __Saved_value;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.value -> TILDA.CatalogFormulaResult."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>value of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.value of type varchar(100)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.value</TD></TR>

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
//   Field tilda.data.TILDA.CatalogFormulaResult.value -> TILDA.CatalogFormulaResult."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>value of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.value of type varchar(100)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.value</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setValue(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.CatalogFormulaResult.value to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 100)
        throw new Exception("Cannot set tilda.data.TILDA.CatalogFormulaResult.value: the size "+v.length()+" is larger than the max allowed of 100: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_value) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.CatalogFormulaResult.value' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE._Mask);
          __Nulls.andNot(TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE._Mask);
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
//   Field tilda.data.TILDA.CatalogFormulaResult.description -> TILDA.CatalogFormulaResult."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.description</TD></TR>

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
//   Field tilda.data.TILDA.CatalogFormulaResult.description -> TILDA.CatalogFormulaResult."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.description</TD></TR>

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
//   Field tilda.data.TILDA.CatalogFormulaResult.description -> TILDA.CatalogFormulaResult."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.description</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDescription(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.CatalogFormulaResult.description to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 32000)
        throw new Exception("Cannot set tilda.data.TILDA.CatalogFormulaResult.description: the size "+v.length()+" is larger than the max allowed of 32000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_description) == false)
        {
          __Changes.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION._Mask);
       _description = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.description -> TILDA.CatalogFormulaResult."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.description</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDescription()
     { return __Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.created -> TILDA.CatalogFormulaResult."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.created</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
//   Field tilda.data.TILDA.CatalogFormulaResult.created -> TILDA.CatalogFormulaResult."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.created</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
//   Field tilda.data.TILDA.CatalogFormulaResult.created -> TILDA.CatalogFormulaResult."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.created</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
   protected void setCreated(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.CatalogFormulaResult.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.CatalogFormulaResult.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask);
          __Nulls.andNot(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask);
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.created -> TILDA.CatalogFormulaResult."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.created</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
   protected final void setCreatedNow() throws Exception
    {
      setCreated(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.created -> TILDA.CatalogFormulaResult."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.created</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
   protected final void setCreatedUndefined() throws Exception
    {
      setCreated(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.created -> TILDA.CatalogFormulaResult."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.created</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
   protected final void setCreated(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setCreated(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.created -> TILDA.CatalogFormulaResult."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.created</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
     { return __Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.lastUpdated -> TILDA.CatalogFormulaResult."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.lastUpdated</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
//   Field tilda.data.TILDA.CatalogFormulaResult.lastUpdated -> TILDA.CatalogFormulaResult."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.lastUpdated</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
//   Field tilda.data.TILDA.CatalogFormulaResult.lastUpdated -> TILDA.CatalogFormulaResult."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.lastUpdated</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
        throw new Exception("Cannot set tilda.data.TILDA.CatalogFormulaResult.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.lastUpdated -> TILDA.CatalogFormulaResult."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.lastUpdated</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
//   Field tilda.data.TILDA.CatalogFormulaResult.lastUpdated -> TILDA.CatalogFormulaResult."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.lastUpdated</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
//   Field tilda.data.TILDA.CatalogFormulaResult.lastUpdated -> TILDA.CatalogFormulaResult."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.lastUpdated</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
//   Field tilda.data.TILDA.CatalogFormulaResult.lastUpdated -> TILDA.CatalogFormulaResult."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.lastUpdated</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
     { return __Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.deleted -> TILDA.CatalogFormulaResult."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _deleted = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.deleted -> TILDA.CatalogFormulaResult."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDeleted()
      { return _deleted; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.deleted -> TILDA.CatalogFormulaResult."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDeleted()
     { return __Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.deleted -> TILDA.CatalogFormulaResult."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
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
          setNullDeleted();
        }
       else if (v.equals(_deleted) == false)
        {
          __Changes.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask);
          __Nulls.andNot(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask);
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.deleted -> TILDA.CatalogFormulaResult."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setNullDeleted()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask);
       if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask);
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.CatalogFormulaResult.deleted -> TILDA.CatalogFormulaResult."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
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
//   Field tilda.data.TILDA.CatalogFormulaResult.deleted -> TILDA.CatalogFormulaResult."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
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
//   Field tilda.data.TILDA.CatalogFormulaResult.deleted -> TILDA.CatalogFormulaResult."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
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
//   Field tilda.data.TILDA.CatalogFormulaResult.deleted -> TILDA.CatalogFormulaResult."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.CatalogFormulaResult)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.CatalogFormulaResult.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.CatalogFormulaResult.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleted()
     { return __Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.data._Tilda.TILDA__CATALOGFORMULARESULT Dst) throws Exception
     {
       if (_description   != null)
        Dst.setDescription  (_description  );
       if (__Init == InitMode.CREATE && _created       != null)
        Dst.setCreated      (_created      );
       if (_lastUpdated   != null)
        Dst.setLastUpdated  (_lastUpdated  );
       if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask) == true || _deleted      ==null)
        Dst.setNullDeleted      ();
       else
        Dst.setDeleted      (_deleted      );
     }


   public tilda.data.CatalogFormulaResult_Data copy() throws Exception
     {
       tilda.data.CatalogFormulaResult_Data dst = new tilda.data.CatalogFormulaResult_Data();
       copyTo(dst);
       return dst;
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
        }

       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.CatalogFormulaResult has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__CATALOGFORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }


       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.CatalogFormulaResult object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__CATALOGFORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
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
             case 0: // PK
               PS.setLong      (++i, _formulaRefnum);
               PS.setString    (++i, _value        );
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__CATALOGFORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (_formulaRefnum == null)
        throw new Exception("Incoming value for 'tilda.data.TILDA.CatalogFormulaResult.formulaRefnum' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM._Mask);
          __Nulls.andNot(TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM._Mask);

       if (TextUtil.isNullOrEmpty(_value) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.CatalogFormulaResult.value' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE._Mask);
          __Nulls.andNot(TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE._Mask);

       if (TextUtil.isNullOrEmpty(_description) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.CatalogFormulaResult.description' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION._Mask);
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_created) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_deleted) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "CatalogFormulaResult");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM._Mask) == true) { TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE._Mask) == true) { TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION._Mask) == true) { TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask) == true) { TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask) == true) { TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDA", "CatalogFormulaResult"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM._Mask) == true) TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE._Mask) == true) TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION._Mask) == true) TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0: // PK
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "CatalogFormulaResult", "formulaRefnum"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "CatalogFormulaResult", "value"); S.append("=?");  S.append(")");
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
       QueryDetails.setLastQuery(TILDA__CATALOGFORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.CatalogFormulaResult", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _formulaRefnum);
        } 
       if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _value);
        } 
       if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _description);
        } 
       if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_created.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_lastUpdated.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_deleted.toInstant()), DateTimeUtil._UTC_CALENDAR);
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
             __Saved_formulaRefnum = _formulaRefnum;
             __Saved_value         = _value        ;
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
        throw new Exception("Object has not been instanciated via deserialization or the factory create() method: __Init:"+__Init+"; __NewlyCreated:"+__NewlyCreated+"; __LookupId: "+__LookupId+";");

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
       if (_formulaRefnum != null && TextUtil.isNullOrEmpty(_value) == false)
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
        throw new Exception("This TILDA.CatalogFormulaResult object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.CatalogFormulaResult object has already been read.");
          QueryDetails.setLastQuery(TILDA__CATALOGFORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__CATALOGFORMULARESULT_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "CatalogFormulaResult");
       switch (__LookupId)
        {
          case 0: // PK
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "CatalogFormulaResult", "formulaRefnum"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "CatalogFormulaResult", "value"); S.append("=?");  S.append(")");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__CATALOGFORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.CatalogFormulaResult", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       int count = 0;

       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
          switch (__LookupId)
           {
             case 0: // PK
               PS.setLong      (++i, _formulaRefnum);
               PS.setString    (++i, _value        );
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__CATALOGFORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_formulaRefnum = _formulaRefnum =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.FORMULAREFNUM._Mask); _formulaRefnum = null; }
      __Saved_value         = _value         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.VALUE._Mask        ); _value = null; }
                              _description   = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.DESCRIPTION._Mask  ); _description = null; }
                              _created       = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.CREATED._Mask      ); _created = null; }
                              _lastUpdated   = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.LASTUPDATED._Mask  ); _lastUpdated = null; }
                              _deleted       = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask      ); _deleted = null; }
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
                   "formulaRefnum: "                                                                                                     +                                   getFormulaRefnum()
               + "; value: "                                                                                                             + TextUtil.printVariableStr        (getValue        ())
               + "; description: "                                                                                                       + TextUtil.printVariableStr        (getDescription  ())
               + "; created: "                                                                                                           + DateTimeUtil.printDateTimeForJSON(getCreated      ())
               + "; lastUpdated: "                                                                                                       + DateTimeUtil.printDateTimeForJSON(getLastUpdated  ())
               + "; deleted"         + (__Nulls.intersects(TILDA__CATALOGFORMULARESULT_Factory.COLS.DELETED._Mask      ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDeleted      ()))
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
          case "": tilda.data.CatalogFormulaResult_Factory.toJSON(out, (tilda.data.CatalogFormulaResult_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data.CatalogFormulaResult_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data.CatalogFormulaResult_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data.CatalogFormulaResult_Factory.toCSV(out, (tilda.data.CatalogFormulaResult_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data.CatalogFormulaResult_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data.CatalogFormulaResult_Factory");
    }
 }
