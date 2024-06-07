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
<TABLE id="Catalog_DIV" class="tables">
<SCRIPT>registerStickyHeader("Catalog_DIV");</SCRIPT>
<TR valign="top"><TD><H2>Catalog&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#Catalog_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="Catalog_CNT" class="content">
The Table TILDA.Catalog :<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>Catalog_Factory</B>, <B>Catalog_Data</B> in the package <B>tilda.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Has the following identities:<UL><LI>Primary Key: refnum</LI>
<LI>Unique Index: schemaName, tableViewName, columnName</LI>
</UL></LI>
<LI>Has the following indices:<UL><LI>referencedColumns asc
</LI>
<LI>referencedFormulas asc
</LI>
</UL></LI>
</UL>
<B>Description</B>:<BLOCKQUOTE style="border-left: 1px solid #EEE;padding-left: 5px;">Master catalog information</BLOCKQUOTE>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="Catalog_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid #BBB;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">TZ</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-refnum_DIV' class='columns'>refnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-schemaName_DIV' class='columns'>schemaName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the schema this column is defined in.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-tableViewName_DIV' class='columns'>tableViewName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the primary table/view this column is defined in.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-columnName_DIV' class='columns'>columnName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the column.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-type_DIV' class='columns'>type</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The type of the column.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-nullable_DIV' class='columns'>nullable</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the collumn is a nullable or not null.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-collection_DIV' class='columns'>collection</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether the collumn is a collection/array.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-description_DIV' class='columns'>description</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The description of the column.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-tableViewName2_DIV' class='columns'>tableViewName2</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the secondary table/view (a derived view, a realized table), if applicable.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-aggregate_DIV' class='columns'>aggregate</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The aggregate type of the column, if any.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-title_DIV' class='columns'>title</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title of the formula/expression that may be associated with this column.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-formula_DIV' class='columns'>formula</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The expression/formula that may be associated with this column.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-measure_DIV' class='columns'>measure</B>&nbsp;&nbsp;</TD>
<TD>boolean&nbsp;/&nbsp;boolean&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Whether this column is a formula defined as a measure or not.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-htmlDoc_DIV' class='columns'>htmlDoc</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Pre-rendered html fragment with the full documentation for this formula.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-referencedColumns_DIV' class='columns'>referencedColumns</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The list of columns this formula depends on.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-referencedFormulas_DIV' class='columns'>referencedFormulas</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The list of columns this formula depends on.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created. (TILDA.Catalog)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDA.Catalog)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='Catalog-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left"><SPAN style="font-weight:bold;font-size:10px">AUTO</SPAN>&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted. (TILDA.Catalog)</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__CATALOG implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__CATALOG.class.getName());

   public transient static final Class<TILDA__CATALOG_Factory> FACTORY_CLASS= TILDA__CATALOG_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDA.Catalog", "");

   protected TILDA__CATALOG() { }

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
//   Field tilda.data.TILDA.Catalog.refnum -> TILDA.Catalog."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   Long _refnum=null;
   protected Long __Saved_refnum;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.refnum -> TILDA.Catalog."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getRefnum()
      { return _refnum==null?0l:_refnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.refnum -> TILDA.Catalog."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
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
           throw new Exception("Cannot set field 'tilda.data.TILDA.Catalog.refnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFNUM._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.REFNUM._Mask);
       _refnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.schemaName -> TILDA.Catalog."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.schemaName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.schemaName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("schemaName")
   String _schemaName=null;
   protected String __Saved_schemaName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.schemaName -> TILDA.Catalog."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.schemaName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.schemaName</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.schemaName -> TILDA.Catalog."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.schemaName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.schemaName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setSchemaName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.schemaName to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.schemaName: the size "+v.length()+" is larger than the max allowed of 128: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_schemaName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Catalog.schemaName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__CATALOG_Factory.COLS.SCHEMANAME._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.SCHEMANAME._Mask);
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.schemaName -> TILDA.Catalog."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>schemaName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the schema this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.schemaName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.schemaName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedSchemaName()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.SCHEMANAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName -> TILDA.Catalog."tableViewName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.tableViewName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.tableViewName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("tableViewName")
   String _tableViewName=null;
   protected String __Saved_tableViewName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName -> TILDA.Catalog."tableViewName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.tableViewName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.tableViewName</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.tableViewName -> TILDA.Catalog."tableViewName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.tableViewName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.tableViewName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setTableViewName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.tableViewName to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.tableViewName: the size "+v.length()+" is larger than the max allowed of 128: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_tableViewName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Catalog.tableViewName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME._Mask);
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName -> TILDA.Catalog."tableViewName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this column is defined in.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.tableViewName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.tableViewName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTableViewName()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.columnName -> TILDA.Catalog."columnName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>columnName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.columnName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.columnName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("columnName")
   String _columnName=null;
   protected String __Saved_columnName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.columnName -> TILDA.Catalog."columnName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>columnName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.columnName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.columnName</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.columnName -> TILDA.Catalog."columnName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>columnName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.columnName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.columnName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   protected void setColumnName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.columnName to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.columnName: the size "+v.length()+" is larger than the max allowed of 128: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_columnName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Catalog.columnName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__CATALOG_Factory.COLS.COLUMNNAME._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.COLUMNNAME._Mask);
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.columnName -> TILDA.Catalog."columnName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>columnName of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.columnName of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.columnName</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedColumnName()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.COLUMNNAME._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.type -> TILDA.Catalog."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The type of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.type of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("type")
   String _type=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.type -> TILDA.Catalog."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The type of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.type of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getType()
      { return _type; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.type -> TILDA.Catalog."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The type of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.type of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setType(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.type to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.type: the size "+v.length()+" is larger than the max allowed of 128: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_type) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.TYPE._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.TYPE._Mask);
       _type = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.type -> TILDA.Catalog."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>type of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The type of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.type of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.type</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedType()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.TYPE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.nullable -> TILDA.Catalog."nullable"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>nullable of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a nullable or not null.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.nullable of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.nullable</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("nullable")
   Boolean _nullable=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.nullable -> TILDA.Catalog."nullable"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>nullable of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a nullable or not null.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.nullable of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.nullable</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getNullable()
      { return _nullable==null?false:_nullable; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.nullable -> TILDA.Catalog."nullable"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>nullable of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a nullable or not null.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.nullable of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.nullable</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullNullable()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.nullable -> TILDA.Catalog."nullable"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>nullable of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a nullable or not null.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.nullable of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.nullable</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullable(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _nullable == null || v != _nullable)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask);
       _nullable = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.nullable -> TILDA.Catalog."nullable"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>nullable of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a nullable or not null.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.nullable of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.nullable</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullNullable()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask);
       _nullable=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.nullable -> TILDA.Catalog."nullable"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>nullable of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a nullable or not null.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.nullable of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.nullable</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedNullable()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.collection -> TILDA.Catalog."collection"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>collection of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a collection/array.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.collection of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.collection</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("collection")
   Boolean _collection=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.collection -> TILDA.Catalog."collection"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>collection of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a collection/array.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.collection of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.collection</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getCollection()
      { return _collection==null?false:_collection; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.collection -> TILDA.Catalog."collection"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>collection of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a collection/array.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.collection of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.collection</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullCollection()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.collection -> TILDA.Catalog."collection"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>collection of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a collection/array.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.collection of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.collection</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setCollection(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _collection == null || v != _collection)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask);
       _collection = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.collection -> TILDA.Catalog."collection"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>collection of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a collection/array.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.collection of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.collection</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullCollection()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask);
       _collection=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.collection -> TILDA.Catalog."collection"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>collection of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the collumn is a collection/array.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.collection of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.collection</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedCollection()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.description -> TILDA.Catalog."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.description</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.description -> TILDA.Catalog."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.description</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.description -> TILDA.Catalog."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.description</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.description to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 32000)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.description: the size "+v.length()+" is larger than the max allowed of 32000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_description) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.DESCRIPTION._Mask);
       _description = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.description -> TILDA.Catalog."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>description of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.description of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.description</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDescription()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.DESCRIPTION._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName2 -> TILDA.Catalog."tableViewName2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the secondary table/view (a derived view, a realized table), if applicable.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.tableViewName2 of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.tableViewName2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("tableViewName2")
   String _tableViewName2=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName2 -> TILDA.Catalog."tableViewName2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the secondary table/view (a derived view, a realized table), if applicable.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.tableViewName2 of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.tableViewName2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getTableViewName2()
      { return _tableViewName2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName2 -> TILDA.Catalog."tableViewName2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the secondary table/view (a derived view, a realized table), if applicable.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.tableViewName2 of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.tableViewName2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullTableViewName2()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName2 -> TILDA.Catalog."tableViewName2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the secondary table/view (a derived view, a realized table), if applicable.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.tableViewName2 of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.tableViewName2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTableViewName2(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullTableViewName2();
        }
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.tableViewName2: the size "+v.length()+" is larger than the max allowed of 128: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_tableViewName2) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask);
       _tableViewName2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName2 -> TILDA.Catalog."tableViewName2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the secondary table/view (a derived view, a realized table), if applicable.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.tableViewName2 of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.tableViewName2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullTableViewName2()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask);
       _tableViewName2=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName2 -> TILDA.Catalog."tableViewName2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tableViewName2 of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the secondary table/view (a derived view, a realized table), if applicable.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.tableViewName2 of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.tableViewName2</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTableViewName2()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.aggregate -> TILDA.Catalog."aggregate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>aggregate of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The aggregate type of the column, if any.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.aggregate of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.aggregate</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("aggregate")
   String _aggregate=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.aggregate -> TILDA.Catalog."aggregate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>aggregate of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The aggregate type of the column, if any.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.aggregate of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.aggregate</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getAggregate()
      { return _aggregate; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.aggregate -> TILDA.Catalog."aggregate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>aggregate of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The aggregate type of the column, if any.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.aggregate of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.aggregate</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullAggregate()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.aggregate -> TILDA.Catalog."aggregate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>aggregate of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The aggregate type of the column, if any.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.aggregate of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.aggregate</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setAggregate(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullAggregate();
        }
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.aggregate: the size "+v.length()+" is larger than the max allowed of 128: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_aggregate) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask);
       _aggregate = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.aggregate -> TILDA.Catalog."aggregate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>aggregate of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The aggregate type of the column, if any.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.aggregate of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.aggregate</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullAggregate()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask);
       _aggregate=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.aggregate -> TILDA.Catalog."aggregate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>aggregate of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The aggregate type of the column, if any.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.aggregate of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.aggregate</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedAggregate()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.title -> TILDA.Catalog."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>title of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title of the formula/expression that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.title of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.title</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("title")
   String _title=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.title -> TILDA.Catalog."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>title of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title of the formula/expression that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.title of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.title</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getTitle()
      { return _title; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.title -> TILDA.Catalog."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>title of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title of the formula/expression that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.title of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.title</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullTitle()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.TITLE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.title -> TILDA.Catalog."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>title of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title of the formula/expression that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.title of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.title</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setTitle(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullTitle();
        }
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.title: the size "+v.length()+" is larger than the max allowed of 128: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_title) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.TITLE._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.TITLE._Mask);
       _title = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.title -> TILDA.Catalog."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>title of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title of the formula/expression that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.title of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.title</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullTitle()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.TITLE._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.TITLE._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.TITLE._Mask);
       _title=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.title -> TILDA.Catalog."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>title of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title of the formula/expression that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.title of type varchar(128)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.title</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedTitle()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.TITLE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.formula -> TILDA.Catalog."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formula of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The expression/formula that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.formula of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.formula</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formula")
   String _formula=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.formula -> TILDA.Catalog."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formula of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The expression/formula that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.formula of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.formula</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormula()
      { return _formula; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.formula -> TILDA.Catalog."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formula of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The expression/formula that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.formula of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.formula</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFormula()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.FORMULA._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.formula -> TILDA.Catalog."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formula of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The expression/formula that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.formula of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.formula</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setFormula(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullFormula();
        }
       else if (v.length() > 32000)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.formula: the size "+v.length()+" is larger than the max allowed of 32000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_formula) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.FORMULA._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.FORMULA._Mask);
       _formula = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.formula -> TILDA.Catalog."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formula of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The expression/formula that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.formula of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.formula</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullFormula()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.FORMULA._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.FORMULA._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.FORMULA._Mask);
       _formula=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.formula -> TILDA.Catalog."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>formula of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The expression/formula that may be associated with this column.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.formula of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.formula</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedFormula()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.FORMULA._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.measure -> TILDA.Catalog."measure"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>measure of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether this column is a formula defined as a measure or not.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.measure of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.measure</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("measure")
   Boolean _measure=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.measure -> TILDA.Catalog."measure"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>measure of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether this column is a formula defined as a measure or not.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.measure of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.measure</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean getMeasure()
      { return _measure==null?false:_measure; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.measure -> TILDA.Catalog."measure"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>measure of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether this column is a formula defined as a measure or not.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.measure of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.measure</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullMeasure()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.MEASURE._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.measure -> TILDA.Catalog."measure"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>measure of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether this column is a formula defined as a measure or not.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.measure of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.measure</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setMeasure(boolean v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _measure == null || v != _measure)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.MEASURE._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.MEASURE._Mask);
       _measure = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.measure -> TILDA.Catalog."measure"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>measure of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether this column is a formula defined as a measure or not.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.measure of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.measure</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullMeasure()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.MEASURE._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.MEASURE._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.MEASURE._Mask);
       _measure=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.measure -> TILDA.Catalog."measure"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>measure of type boolean</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether this column is a formula defined as a measure or not.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.measure of type boolean</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.measure</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedMeasure()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.MEASURE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.htmlDoc -> TILDA.Catalog."htmlDoc"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>htmlDoc of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Pre-rendered html fragment with the full documentation for this formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.htmlDoc of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.htmlDoc</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("htmlDoc")
   String _htmlDoc=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.htmlDoc -> TILDA.Catalog."htmlDoc"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>htmlDoc of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Pre-rendered html fragment with the full documentation for this formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.htmlDoc of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.htmlDoc</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getHtmlDoc()
      { return _htmlDoc; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.htmlDoc -> TILDA.Catalog."htmlDoc"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>htmlDoc of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Pre-rendered html fragment with the full documentation for this formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.htmlDoc of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.htmlDoc</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullHtmlDoc()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.htmlDoc -> TILDA.Catalog."htmlDoc"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>htmlDoc of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Pre-rendered html fragment with the full documentation for this formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.htmlDoc of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.htmlDoc</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setHtmlDoc(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullHtmlDoc();
        }
       else if (v.length() > 32000)
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.htmlDoc: the size "+v.length()+" is larger than the max allowed of 32000: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_htmlDoc) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask);
       _htmlDoc = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.htmlDoc -> TILDA.Catalog."htmlDoc"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>htmlDoc of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Pre-rendered html fragment with the full documentation for this formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.htmlDoc of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.htmlDoc</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullHtmlDoc()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask);
       _htmlDoc=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.htmlDoc -> TILDA.Catalog."htmlDoc"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>htmlDoc of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Pre-rendered html fragment with the full documentation for this formula.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.htmlDoc of type text</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.htmlDoc</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedHtmlDoc()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedColumns -> TILDA.Catalog."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedColumns of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedColumns of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedColumns</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("referencedColumns")
   List<String> _referencedColumns;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedColumns -> TILDA.Catalog."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedColumns of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedColumns of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedColumns</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getReferencedColumnsAsArray()
      { return _referencedColumns==null? null : _referencedColumns.toArray(new String[_referencedColumns.size()]); }
   public final Iterator<String> getReferencedColumns()
      { return _referencedColumns==null? null : _referencedColumns.iterator(); }
   public final boolean hasReferencedColumns(String v)
      { return _referencedColumns==null? false : _referencedColumns.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedColumns -> TILDA.Catalog."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedColumns of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedColumns of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedColumns</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullReferencedColumns()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedColumns -> TILDA.Catalog."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedColumns of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedColumns of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedColumns</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setReferencedColumns(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setNullReferencedColumns();
       else if (CollectionUtil.equals(v, _referencedColumns) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
          if (_referencedColumns == null)
           {
             // GOTTA Check if we are setting a null ROWTZ but there are still row timestamps that are not null
             _referencedColumns = new ArrayList<String>();
           }
          else
           {
             _referencedColumns.clear();
           }
          for (String i : v)
           {
             _referencedColumns.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToReferencedColumns(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_referencedColumns == null)
        _referencedColumns = new ArrayList<String>();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullReferencedColumns();
        }
       else if (pos >= _referencedColumns.size() || _referencedColumns.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
          _referencedColumns.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromReferencedColumns(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_referencedColumns.remove(v) == true)
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromReferencedColumns(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_referencedColumns.remove(pos) != null)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedColumns -> TILDA.Catalog."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedColumns of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedColumns of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedColumns</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullReferencedColumns()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
       _referencedColumns=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedColumns -> TILDA.Catalog."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedColumns of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedColumns of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedColumns</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedReferencedColumns()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedFormulas -> TILDA.Catalog."referencedFormulas"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedFormulas of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedFormulas of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedFormulas</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("referencedFormulas")
   List<String> _referencedFormulas;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedFormulas -> TILDA.Catalog."referencedFormulas"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedFormulas of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedFormulas of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedFormulas</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getReferencedFormulasAsArray()
      { return _referencedFormulas==null? null : _referencedFormulas.toArray(new String[_referencedFormulas.size()]); }
   public final Iterator<String> getReferencedFormulas()
      { return _referencedFormulas==null? null : _referencedFormulas.iterator(); }
   public final boolean hasReferencedFormulas(String v)
      { return _referencedFormulas==null? false : _referencedFormulas.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedFormulas -> TILDA.Catalog."referencedFormulas"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedFormulas of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedFormulas of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedFormulas</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullReferencedFormulas()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedFormulas -> TILDA.Catalog."referencedFormulas"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedFormulas of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedFormulas of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedFormulas</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setReferencedFormulas(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setNullReferencedFormulas();
       else if (CollectionUtil.equals(v, _referencedFormulas) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
          if (_referencedFormulas == null)
           {
             // GOTTA Check if we are setting a null ROWTZ but there are still row timestamps that are not null
             _referencedFormulas = new ArrayList<String>();
           }
          else
           {
             _referencedFormulas.clear();
           }
          for (String i : v)
           {
             _referencedFormulas.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToReferencedFormulas(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_referencedFormulas == null)
        _referencedFormulas = new ArrayList<String>();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullReferencedFormulas();
        }
       else if (pos >= _referencedFormulas.size() || _referencedFormulas.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
          _referencedFormulas.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromReferencedFormulas(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_referencedFormulas.remove(v) == true)
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromReferencedFormulas(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_referencedFormulas.remove(pos) != null)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedFormulas -> TILDA.Catalog."referencedFormulas"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedFormulas of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedFormulas of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedFormulas</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullReferencedFormulas()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
       _referencedFormulas=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedFormulas -> TILDA.Catalog."referencedFormulas"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>referencedFormulas of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.referencedFormulas of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.referencedFormulas</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedReferencedFormulas()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.created -> TILDA.Catalog."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.created</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.created -> TILDA.Catalog."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.created</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.created -> TILDA.Catalog."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.created</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.Catalog.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__CATALOG_Factory.COLS.CREATED._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.CREATED._Mask);
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.created -> TILDA.Catalog."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.created</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.created -> TILDA.Catalog."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.created</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.created -> TILDA.Catalog."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.created</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.created -> TILDA.Catalog."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.created</TD></TR>

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
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.CREATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.lastUpdated -> TILDA.Catalog."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.lastUpdated -> TILDA.Catalog."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.lastUpdated -> TILDA.Catalog."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.lastUpdated</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.Catalog.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.lastUpdated -> TILDA.Catalog."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.lastUpdated -> TILDA.Catalog."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.lastUpdated -> TILDA.Catalog."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.lastUpdated</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.lastUpdated -> TILDA.Catalog."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.lastUpdated</TD></TR>

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
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.deleted -> TILDA.Catalog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _deleted = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.deleted -> TILDA.Catalog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.deleted</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.deleted -> TILDA.Catalog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDeleted()
     { return __Nulls.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.deleted -> TILDA.Catalog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.deleted</TD></TR>

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
          __Changes.or(TILDA__CATALOG_Factory.COLS.DELETED._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.DELETED._Mask);
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.deleted -> TILDA.Catalog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setNullDeleted()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__CATALOG_Factory.COLS.DELETED._Mask);
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__CATALOG_Factory.COLS.DELETED._Mask);
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.deleted -> TILDA.Catalog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.deleted</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.deleted -> TILDA.Catalog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.deleted</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.deleted -> TILDA.Catalog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.deleted</TD></TR>

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
//   Field tilda.data.TILDA.Catalog.deleted -> TILDA.Catalog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Catalog)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Catalog.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.Catalog.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleted()
     { return __Changes.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.data._Tilda.TILDA__CATALOG Dst) throws Exception
     {
       if (__Init == InitMode.CREATE && _schemaName         != null)
        Dst.setSchemaName        (_schemaName        );
       if (__Init == InitMode.CREATE && _tableViewName      != null)
        Dst.setTableViewName     (_tableViewName     );
       if (__Init == InitMode.CREATE && _columnName         != null)
        Dst.setColumnName        (_columnName        );
       if (_type               != null)
        Dst.setType              (_type              );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask) == true || _nullable          ==null)
        Dst.setNullNullable          ();
       else
        Dst.setNullable          (_nullable          );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask) == true || _collection        ==null)
        Dst.setNullCollection        ();
       else
        Dst.setCollection        (_collection        );
       if (_description        != null)
        Dst.setDescription       (_description       );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask) == true || _tableViewName2    ==null)
        Dst.setNullTableViewName2    ();
       else
        Dst.setTableViewName2    (_tableViewName2    );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask) == true || _aggregate         ==null)
        Dst.setNullAggregate         ();
       else
        Dst.setAggregate         (_aggregate         );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.TITLE._Mask) == true || _title             ==null)
        Dst.setNullTitle             ();
       else
        Dst.setTitle             (_title             );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.FORMULA._Mask) == true || _formula           ==null)
        Dst.setNullFormula           ();
       else
        Dst.setFormula           (_formula           );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.MEASURE._Mask) == true || _measure           ==null)
        Dst.setNullMeasure           ();
       else
        Dst.setMeasure           (_measure           );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask) == true || _htmlDoc           ==null)
        Dst.setNullHtmlDoc           ();
       else
        Dst.setHtmlDoc           (_htmlDoc           );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask) == true || _referencedColumns ==null)
        Dst.setNullReferencedColumns ();
       else
        Dst.setReferencedColumns (_referencedColumns );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask) == true || _referencedFormulas==null)
        Dst.setNullReferencedFormulas();
       else
        Dst.setReferencedFormulas(_referencedFormulas);
       if (__Init == InitMode.CREATE && _created            != null)
        Dst.setCreated           (_created           );
       if (_lastUpdated        != null)
        Dst.setLastUpdated       (_lastUpdated       );
       if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask) == true || _deleted           ==null)
        Dst.setNullDeleted           ();
       else
        Dst.setDeleted           (_deleted           );
     }


   public tilda.data.Catalog_Data copy() throws Exception
     {
       tilda.data.Catalog_Data dst = new tilda.data.Catalog_Data();
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
          // Auto PK
          setRefnum(tilda.db.KeysManager.getKey("TILDA.CATALOG"));
        }

       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.Catalog has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }


       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.Catalog object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, "");
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
               PS.setLong      (++i, _refnum            );
               break;
             case 1: // Unique Index 'Column'
               PS.setString    (++i, _schemaName        );
               PS.setString    (++i, _tableViewName     );
               PS.setString    (++i, _columnName        );
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (TextUtil.isNullOrEmpty(_schemaName) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.Catalog.schemaName' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__CATALOG_Factory.COLS.SCHEMANAME._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.SCHEMANAME._Mask);

       if (TextUtil.isNullOrEmpty(_tableViewName) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.Catalog.tableViewName' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME._Mask);

       if (TextUtil.isNullOrEmpty(_columnName) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.Catalog.columnName' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__CATALOG_Factory.COLS.COLUMNNAME._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.COLUMNNAME._Mask);

       if (TextUtil.isNullOrEmpty(_type) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.Catalog.type' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__CATALOG_Factory.COLS.TYPE._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.TYPE._Mask);

       if (_nullable != null)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask);
        }

       if (_collection != null)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask);
        }

       if (TextUtil.isNullOrEmpty(_description) == true)
        throw new Exception("Incoming value for 'tilda.data.TILDA.Catalog.description' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__CATALOG_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.DESCRIPTION._Mask);

       if (TextUtil.isNullOrEmpty(_tableViewName2) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask);
        }

       if (TextUtil.isNullOrEmpty(_aggregate) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask);
        }

       if (TextUtil.isNullOrEmpty(_title) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.TITLE._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.TITLE._Mask);
        }

       if (TextUtil.isNullOrEmpty(_formula) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.FORMULA._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.FORMULA._Mask);
        }

       if (_measure != null)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.MEASURE._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.MEASURE._Mask);
        }

       if (TextUtil.isNullOrEmpty(_htmlDoc) == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask);
        }

       if (_referencedColumns != null && _referencedColumns.isEmpty() == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
        }

       if (_referencedFormulas != null && _referencedFormulas.isEmpty() == false)
        {
          __Changes.or(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
          __Nulls.andNot(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
        }
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.CREATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_created) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_deleted) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "Catalog");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.REFNUM._Mask) == true) { TILDA__CATALOG_Factory.COLS.REFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.SCHEMANAME._Mask) == true) { TILDA__CATALOG_Factory.COLS.SCHEMANAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME._Mask) == true) { TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.COLUMNNAME._Mask) == true) { TILDA__CATALOG_Factory.COLS.COLUMNNAME.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TYPE._Mask) == true) { TILDA__CATALOG_Factory.COLS.TYPE.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask) == true) { TILDA__CATALOG_Factory.COLS.NULLABLE.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask) == true) { TILDA__CATALOG_Factory.COLS.COLLECTION.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.DESCRIPTION._Mask) == true) { TILDA__CATALOG_Factory.COLS.DESCRIPTION.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask) == true) { TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask) == true) { TILDA__CATALOG_Factory.COLS.AGGREGATE.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TITLE._Mask) == true) { TILDA__CATALOG_Factory.COLS.TITLE.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.FORMULA._Mask) == true) { TILDA__CATALOG_Factory.COLS.FORMULA.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.MEASURE._Mask) == true) { TILDA__CATALOG_Factory.COLS.MEASURE.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask) == true) { TILDA__CATALOG_Factory.COLS.HTMLDOC.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask) == true) { TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask) == true) { TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS.getFullColumnVarForInsert(C, S); V.append(tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.CREATED._Mask) == true) { TILDA__CATALOG_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__CATALOG_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__CATALOG_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__CATALOG_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__CATALOG_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask) == true) { TILDA__CATALOG_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__2_5._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDA", "Catalog"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.REFNUM._Mask) == true) TILDA__CATALOG_Factory.COLS.REFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.SCHEMANAME._Mask) == true) TILDA__CATALOG_Factory.COLS.SCHEMANAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME._Mask) == true) TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.COLUMNNAME._Mask) == true) TILDA__CATALOG_Factory.COLS.COLUMNNAME.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TYPE._Mask) == true) TILDA__CATALOG_Factory.COLS.TYPE.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask) == true) TILDA__CATALOG_Factory.COLS.NULLABLE.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask) == true) TILDA__CATALOG_Factory.COLS.COLLECTION.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.DESCRIPTION._Mask) == true) TILDA__CATALOG_Factory.COLS.DESCRIPTION.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask) == true) TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask) == true) TILDA__CATALOG_Factory.COLS.AGGREGATE.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TITLE._Mask) == true) TILDA__CATALOG_Factory.COLS.TITLE.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.FORMULA._Mask) == true) TILDA__CATALOG_Factory.COLS.FORMULA.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.MEASURE._Mask) == true) TILDA__CATALOG_Factory.COLS.MEASURE.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask) == true) TILDA__CATALOG_Factory.COLS.HTMLDOC.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask) == true) TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask) == true) TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.CREATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__CATALOG_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__CATALOG_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__CATALOG_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__CATALOG_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__CATALOG_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__CATALOG_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__CATALOG_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0: // PK
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Catalog", "refnum"); S.append("=?");  S.append(")");
                break;
             case 1: // Unique Index 'Column'
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Catalog", "schemaName"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "Catalog", "tableViewName"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "Catalog", "columnName"); S.append("=?");  S.append(")");
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
       QueryDetails.setLastQuery(TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.Catalog", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.REFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _refnum);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.SCHEMANAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.SCHEMANAME._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _schemaName);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _tableViewName);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.COLUMNNAME._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.COLUMNNAME._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _columnName);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TYPE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.TYPE._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _type);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask) == true) PS.setNull(++i, java.sql.Types.BOOLEAN   ); else PS.setBoolean   (++i, _nullable);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask) == true) PS.setNull(++i, java.sql.Types.BOOLEAN   ); else PS.setBoolean   (++i, _collection);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.DESCRIPTION._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.DESCRIPTION._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _description);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _tableViewName2);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _aggregate);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.TITLE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.TITLE._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _title);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.FORMULA._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.FORMULA._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _formula);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.MEASURE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.MEASURE._Mask) == true) PS.setNull(++i, java.sql.Types.BOOLEAN   ); else PS.setBoolean   (++i, _measure);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _htmlDoc);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.VARCHAR   ); else C.setArray(PS, ++i, TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS.getType(), AllocatedArrays, _referencedColumns);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.VARCHAR   ); else C.setArray(PS, ++i, TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS.getType(), AllocatedArrays, _referencedFormulas);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.CREATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_created.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_lastUpdated.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_deleted.toInstant()), DateTimeUtil._UTC_CALENDAR);
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
             __Saved_refnum             = _refnum            ;
             break;
          case 1:
             __Saved_schemaName         = _schemaName        ;
             __Saved_tableViewName      = _tableViewName     ;
             __Saved_columnName         = _columnName        ;
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
             // Auto PK
             setRefnum(tilda.db.KeysManager.getKey("TILDA.CATALOG"));
             return write(C);
           }
        }
       else
        {
          initForCreate();
          // Auto PK
          setRefnum(tilda.db.KeysManager.getKey("TILDA.CATALOG"));
          if (write(C) == false)
           {
             initForLookup(lookupId);
              // Undo auto PK
              __Changes.andNot(TILDA__CATALOG_Factory.COLS.REFNUM._Mask);
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

       // Testing if cols for unique index Column were set - Id: 1
       if (TextUtil.isNullOrEmpty(_schemaName) == false && TextUtil.isNullOrEmpty(_tableViewName) == false && TextUtil.isNullOrEmpty(_columnName) == false)
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
        throw new Exception("This TILDA.Catalog object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.Catalog object has already been read.");
          QueryDetails.setLastQuery(TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__CATALOG_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "Catalog");
       switch (__LookupId)
        {
          case 0: // PK
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Catalog", "refnum"); S.append("=?");  S.append(")");
             break;
          case 1: // Unique Index 'Column'
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Catalog", "schemaName"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "Catalog", "tableViewName"); S.append("=?");  S.append(" AND "); C.getFullColumnVar(S, "TILDA", "Catalog", "columnName"); S.append("=?");  S.append(")");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.Catalog", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;

       try
        {
          PS = C.prepareStatement(Q);
          int i = 0;
          switch (__LookupId)
           {
             case 0: // PK
               PS.setLong      (++i, _refnum            );
               break;
             case 1: // Unique Index 'Column'
               PS.setString    (++i, _schemaName        );
               PS.setString    (++i, _tableViewName     );
               PS.setString    (++i, _columnName        );
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }
    }

   @SuppressWarnings("unchecked")
   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_refnum             = _refnum             =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.REFNUM._Mask            ); _refnum = null; }
      __Saved_schemaName         = _schemaName         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.SCHEMANAME._Mask        ); _schemaName = null; }
      __Saved_tableViewName      = _tableViewName      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME._Mask     ); _tableViewName = null; }
      __Saved_columnName         = _columnName         = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.COLUMNNAME._Mask        ); _columnName = null; }
                                   _type               = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.TYPE._Mask              ); _type = null; }
                                   _nullable           =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask          ); _nullable = null; }
                                   _collection         =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask        ); _collection = null; }
                                   _description        = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.DESCRIPTION._Mask       ); _description = null; }
                                   _tableViewName2     = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask    ); _tableViewName2 = null; }
                                   _aggregate          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask         ); _aggregate = null; }
                                   _title              = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.TITLE._Mask             ); _title = null; }
                                   _formula            = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.FORMULA._Mask           ); _formula = null; }
                                   _measure            =                              RS.getBoolean   (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.MEASURE._Mask           ); _measure = null; }
                                   _htmlDoc            = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask           ); _htmlDoc = null; }
                                   _referencedColumns = (List<String>) JDBCHelper.getArray(RS, ++i, TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask ); _referencedColumns = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_referencedColumns != null && _referencedColumns.size() == 1 && _referencedColumns.get(0) == null)
                               {
                                 _referencedColumns = new ArrayList<String>();
                                 __Nulls.or(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
                               }
                                   _referencedFormulas = (List<String>) JDBCHelper.getArray(RS, ++i, TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask); _referencedFormulas = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_referencedFormulas != null && _referencedFormulas.size() == 1 && _referencedFormulas.get(0) == null)
                               {
                                 _referencedFormulas = new ArrayList<String>();
                                 __Nulls.or(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);
                               }
                                   _created            = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.CREATED._Mask           ); _created = null; }
                                   _lastUpdated        = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.LASTUPDATED._Mask       ); _lastUpdated = null; }
                                   _deleted            = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__CATALOG_Factory.COLS.DELETED._Mask           ); _deleted = null; }
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
                   "refnum: "                                                                                                         +                                   getRefnum            ()
               + "; schemaName: "                                                                                                     + TextUtil.printVariableStr        (getSchemaName        ())
               + "; tableViewName: "                                                                                                  + TextUtil.printVariableStr        (getTableViewName     ())
               + "; columnName: "                                                                                                     + TextUtil.printVariableStr        (getColumnName        ())
               + "; type: "                                                                                                           + TextUtil.printVariableStr        (getType              ())
               + "; nullable"             + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask          ) == true ? ": NULL" : ": " +                                   getNullable          ())
               + "; collection"           + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask        ) == true ? ": NULL" : ": " +                                   getCollection        ())
               + "; description: "                                                                                                    + TextUtil.printVariableStr        (getDescription       ())
               + "; tableViewName2"       + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask    ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getTableViewName2    ()))
               + "; aggregate"            + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask         ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getAggregate         ()))
               + "; title"                + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.TITLE._Mask             ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getTitle             ()))
               + "; formula"              + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.FORMULA._Mask           ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getFormula           ()))
               + "; measure"              + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.MEASURE._Mask           ) == true ? ": NULL" : ": " +                                   getMeasure           ())
               + "; htmlDoc"              + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask           ) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getHtmlDoc           ()))
               + "; referencedColumns"    + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask ) == true ? ": NULL" : ": " + TextUtil.print                   (getReferencedColumns ()))
               + "; referencedFormulas"   + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getReferencedFormulas()))
               + "; created: "                                                                                                        + DateTimeUtil.printDateTimeForJSON(getCreated           ())
               + "; lastUpdated: "                                                                                                    + DateTimeUtil.printDateTimeForJSON(getLastUpdated       ())
               + "; deleted"              + (__Nulls.intersects(TILDA__CATALOG_Factory.COLS.DELETED._Mask           ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDeleted           ()))
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
          case "": tilda.data.Catalog_Factory.toJSON(out, (tilda.data.Catalog_Data) this, lead, fullObject, noNullArrays); break;
          case "Simple": tilda.data.Catalog_Factory.toJSONSimple(out, (tilda.data.Catalog_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data.Catalog_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data.Catalog_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data.Catalog_Factory.toCSV(out, (tilda.data.Catalog_Data) this); break;
          case "Simple": tilda.data.Catalog_Factory.toCSVSimple(out, (tilda.data.Catalog_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data.Catalog_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data.Catalog_Factory");
    }
 }
