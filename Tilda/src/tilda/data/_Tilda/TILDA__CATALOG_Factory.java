
package tilda.data._Tilda;

import java.math.*;
import java.util.*;
import java.time.*;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.logging.log4j.*;

import com.google.gson.annotations.*;

import tilda.db.*;
import tilda.enums.*;
import tilda.performance.*;
import tilda.types.*;
import tilda.utils.*;
import tilda.utils.json.*;
import tilda.utils.pairs.*;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

@SuppressWarnings({ "unused" })
public class TILDA__CATALOG_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__CATALOG_Factory.class.getName());

   protected TILDA__CATALOG_Factory() { }

   public static final Class<TILDA__CATALOG> DATA_CLASS= TILDA__CATALOG.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Catalog", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.Catalog", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "Catalog"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.refnum -> TILDA.Catalog."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_LongPrimitive                REFNUM            = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"            , 0/*0*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.schemaName -> TILDA.Catalog."schemaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringPrimitive              SCHEMANAME        = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "schemaName"        , 1/*1*/, 128, "The name of the schema this column is defined in.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName -> TILDA.Catalog."tableViewName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringPrimitive              TABLEVIEWNAME     = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "tableViewName"     , 2/*2*/, 128, "The name of the primary table/view this column is defined in.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.columnName -> TILDA.Catalog."columnName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringPrimitive              COLUMNNAME        = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "columnName"        , 3/*3*/, 128, "The name of the column.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.type -> TILDA.Catalog."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringPrimitive              TYPE              = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "type"              , 4/*4*/, 128, "The type of the column.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.nullable -> TILDA.Catalog."nullable"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_BooleanPrimitiveNull         NULLABLE          = new Type_BooleanPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "nullable"          , 5/*5*/, "Whether the collumn is a nullable or not null.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.collection -> TILDA.Catalog."collection"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_BooleanPrimitiveNull         COLLECTION        = new Type_BooleanPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "collection"        , 6/*6*/, "Whether the collumn is a collection/array.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.description -> TILDA.Catalog."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringPrimitive              DESCRIPTION       = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "description"       , 7/*7*/, 32000, "The description of the column.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.tableViewName2 -> TILDA.Catalog."tableViewName2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringPrimitiveNull          TABLEVIEWNAME2    = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "tableViewName2"    , 8/*8*/, 128, "The name of the secondary table/view (a derived view, a realized table), if applicable.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.aggregate -> TILDA.Catalog."aggregate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringPrimitiveNull          AGGREGATE         = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "aggregate"         , 9/*9*/, 128, "The aggregate type of the column, if any.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.title -> TILDA.Catalog."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringPrimitiveNull          TITLE             = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "title"             , 10/*10*/, 128, "The title of the formula/expression that may be associated with this column.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.formula -> TILDA.Catalog."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringPrimitiveNull          FORMULA           = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "formula"           , 11/*11*/, 32000, "The expression/formula that may be associated with this column.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.measure -> TILDA.Catalog."measure"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_BooleanPrimitiveNull         MEASURE           = new Type_BooleanPrimitiveNull        (SCHEMA_LABEL, TABLENAME_LABEL, "measure"           , 12/*12*/, "Whether this column is a formula defined as a measure or not.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.htmlDoc -> TILDA.Catalog."htmlDoc"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringPrimitiveNull          HTMLDOC           = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "htmlDoc"           , 13/*13*/, 32000, "Pre-rendered html fragment with the full documentation for this formula.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedColumns -> TILDA.Catalog."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringCollectionNull         REFERENCEDCOLUMNS = new Type_StringCollectionNull        (SCHEMA_LABEL, TABLENAME_LABEL, "referencedColumns" , 14/*14*/, "The list of columns this formula depends on.", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.referencedFormulas -> TILDA.Catalog."referencedFormulas"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_StringCollectionNull         REFERENCEDFORMULAS= new Type_StringCollectionNull        (SCHEMA_LABEL, TABLENAME_LABEL, "referencedFormulas", 15/*15*/, "The list of columns this formula depends on.", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.created -> TILDA.Catalog."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_DatetimePrimitive            CREATED           = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "created"           , 16/*16*/, "The timestamp for when the record was created. (TILDA.Catalog)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.lastUpdated -> TILDA.Catalog."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_DatetimePrimitive            LASTUPDATED       = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"       , 17/*17*/, "The timestamp for when the record was last updated. (TILDA.Catalog)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Catalog.deleted -> TILDA.Catalog."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
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
     public final Type_DatetimePrimitiveNull        DELETED           = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"           , 18/*18*/, "The timestamp for when the record was deleted. (TILDA.Catalog)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.REFNUM,COLS.SCHEMANAME,COLS.TABLEVIEWNAME,COLS.COLUMNNAME,COLS.TYPE,COLS.NULLABLE,COLS.COLLECTION,COLS.DESCRIPTION,COLS.TABLEVIEWNAME2,COLS.AGGREGATE,COLS.TITLE,COLS.FORMULA,COLS.MEASURE,COLS.HTMLDOC,COLS.REFERENCEDCOLUMNS,COLS.REFERENCEDFORMULAS,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.REFNUM };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = new ColumnDefinition[][]{ 
                   {COLS.SCHEMANAME,COLS.TABLEVIEWNAME,COLS.COLUMNNAME}
        };

   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = COLUMNS_UNIQUE_INDICES[0];

   // Short(short) is deprecated, but we do want a new instance here to avoid synchronizing over the same cached instance from valueOf.
   // @SuppressWarnings("deprecation")
   private static final AtomicBoolean __INITIALIZED = new AtomicBoolean(false);
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED.compareAndSet(false, true))
        {
           tilda.data.Catalog_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.Catalog_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Catalog_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.Catalog_Data> _OP;
       protected ArrayListResults<tilda.data.Catalog_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.Catalog_Data Obj = new tilda.data.Catalog_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__CATALOG)Obj).init(_C, RS);
          if (OK == true)
           {
             if (_OP == null)
              _L.add(Obj);
             else
              _OP.process(count, Obj);
           }
          return OK;
        }
     }

   protected static final void processMany(Connection C, String fullSelectQuery, int start, int size, tilda.db.processors.RecordProcessor RP) throws Exception
     {
       readMany(C, -77, RP, null, fullSelectQuery, start, size);
     }
   protected static final ListResults<tilda.data.Catalog_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__CATALOG Obj, Object ExtraParams, int start, int size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       if (LookupId == -77)
        {
          S.append((String)ExtraParams);
        }
       else
        {
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__CATALOG_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "Catalog");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 2: // Index 'RefColumns'
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Catalog", "referencedColumns"); S.append(" ASC");
                break;
             case 3: // Index 'RefFormulas'
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Catalog", "referencedFormulas"); S.append(" ASC");
                break;
             case 4: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Catalog", "schemaName"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "Catalog", "tableViewName"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "Catalog", "columnName"); S.append(" ASC");
                break;
             case -77: 
             case -666: break;
             default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
           }
        }

       String Q = S.toString() + C.getSelectLimitClause(start, size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.Catalog", Q, null);
       java.sql.PreparedStatement PS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          if (size < 0 || size > 5000)
           PS.setFetchSize(5000);
          switch (LookupId)
           {
             case -77:
             case -7:
                break;
             case 2: {  // Index 'RefColumns'
               break;
             }
             case 3: {  // Index 'RefFormulas'
               break;
             }
             case 4: { // Query 'All'
               break;
             }
             case -666: break;
             default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot prepare statement.");
           }


          count = JDBCHelper.process(PS.executeQuery(), RP, start, true, size, true);
        }
       catch (java.sql.SQLException E)
        {
          C.handleCatch(E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
The generic init method is typically run when there is a general data structure of data available, for example, a CSV
data file read in memory, or run from a servlet using a Map<String, String[]> object obtained from an ServletRequest
object. The generic init method defaults to this general data structure as a genegic representation.
*/
   static public tilda.data.Catalog_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data._Tilda.TILDA__CATALOG Obj = new tilda.data.Catalog_Data();
       String[] vals = null;

       vals = Values.get("refnum");
       // Even though this is a primary key, and is by definition not-null, we nevertheless check it as optional in case
       // this object is being initialized generically for a create.
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("refnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _refnum = ParseUtil.parseLong("refnum", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_refnum != null) Obj.setRefnum(_refnum);

       vals = Values.get("schemaName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("schemaName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _schemaName = ParseUtil.parseString("schemaName", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_schemaName != null) Obj.setSchemaName(_schemaName);

       vals = Values.get("tableViewName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("tableViewName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _tableViewName = ParseUtil.parseString("tableViewName", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_tableViewName != null) Obj.setTableViewName(_tableViewName);

       vals = Values.get("columnName");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("columnName", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _columnName = ParseUtil.parseString("columnName", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_columnName != null) Obj.setColumnName(_columnName);

       vals = Values.get("type");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("type", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _type = ParseUtil.parseString("type", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_type != null) Obj.setType(_type);

       vals = Values.get("nullable");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("nullable", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Boolean _nullable = ParseUtil.parseBoolean("nullable", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_nullable != null) Obj.setNullable(_nullable);

       vals = Values.get("collection");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("collection", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Boolean _collection = ParseUtil.parseBoolean("collection", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_collection != null) Obj.setCollection(_collection);

       vals = Values.get("description");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("description", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _description = ParseUtil.parseString("description", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_description != null) Obj.setDescription(_description);

       vals = Values.get("tableViewName2");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("tableViewName2", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _tableViewName2 = ParseUtil.parseString("tableViewName2", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_tableViewName2 != null) Obj.setTableViewName2(_tableViewName2);

       vals = Values.get("aggregate");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("aggregate", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _aggregate = ParseUtil.parseString("aggregate", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_aggregate != null) Obj.setAggregate(_aggregate);

       vals = Values.get("title");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("title", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _title = ParseUtil.parseString("title", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_title != null) Obj.setTitle(_title);

       vals = Values.get("formula");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("formula", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _formula = ParseUtil.parseString("formula", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_formula != null) Obj.setFormula(_formula);

       vals = Values.get("measure");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("measure", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Boolean _measure = ParseUtil.parseBoolean("measure", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_measure != null) Obj.setMeasure(_measure);

       vals = Values.get("htmlDoc");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("htmlDoc", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _htmlDoc = ParseUtil.parseString("htmlDoc", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_htmlDoc != null) Obj.setHtmlDoc(_htmlDoc);

       vals = Values.get("referencedColumns");
       List<String> _referencedColumns = CollectionUtil.toList(ParseUtil.parseString("referencedColumns", false, vals, Errors));
       if (_referencedColumns != null) Obj.setReferencedColumns(_referencedColumns);

       vals = Values.get("referencedFormulas");
       List<String> _referencedFormulas = CollectionUtil.toList(ParseUtil.parseString("referencedFormulas", false, vals, Errors));
       if (_referencedFormulas != null) Obj.setReferencedFormulas(_referencedFormulas);


       return (tilda.data.Catalog_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param schemaName         (max size 128) The name of the schema this column is defined in.
 @param tableViewName      (max size 128) The name of the primary table/view this column is defined in.
 @param columnName         (max size 128) The name of the column.
 @param type               (max size 128) The type of the column.
 @param description        (max size 32000) The description of the column.
*/
   static public tilda.data.Catalog_Data create(String schemaName, String tableViewName, String columnName, String type, String description) throws Exception
     {
       tilda.data._Tilda.TILDA__CATALOG Obj = new tilda.data.Catalog_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDA.CATALOG"));

       // Explicit setters
       Obj.setSchemaName        (schemaName        );
       Obj.setTableViewName     (tableViewName     );
       Obj.setColumnName        (columnName        );
       Obj.setType              (type              );
       Obj.setDescription       (description       );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       // Default Nullables
       Obj.__Nulls.or(TILDA__CATALOG_Factory.COLS.NULLABLE._Mask);
       Obj.__Nulls.or(TILDA__CATALOG_Factory.COLS.COLLECTION._Mask);
       Obj.__Nulls.or(TILDA__CATALOG_Factory.COLS.TABLEVIEWNAME2._Mask);
       Obj.__Nulls.or(TILDA__CATALOG_Factory.COLS.AGGREGATE._Mask);
       Obj.__Nulls.or(TILDA__CATALOG_Factory.COLS.TITLE._Mask);
       Obj.__Nulls.or(TILDA__CATALOG_Factory.COLS.FORMULA._Mask);
       Obj.__Nulls.or(TILDA__CATALOG_Factory.COLS.MEASURE._Mask);
       Obj.__Nulls.or(TILDA__CATALOG_Factory.COLS.HTMLDOC._Mask);
       Obj.__Nulls.or(TILDA__CATALOG_Factory.COLS.REFERENCEDCOLUMNS._Mask);
       Obj.__Nulls.or(TILDA__CATALOG_Factory.COLS.REFERENCEDFORMULAS._Mask);

       return (tilda.data.Catalog_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data.Catalog_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__CATALOG lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__CATALOG) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__CATALOG) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.Catalog_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__CATALOG) d);

               if (((TILDA__CATALOG) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Catalog_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__CATALOG) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Catalog_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__CATALOG) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Catalog_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__CATALOG) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Catalog_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               int i = d.populatePreparedStatement(C, PS, AllocatedArrays);

               PS.addBatch();
               ++count;

               if (index != 0 && (index + 1) % batchSize == 0)
                 {
                   int[] results = PS.executeBatch();
                   int failedRec = JDBCHelper.batchWriteDone(results, batchSize);
                   if (failedRec != -1)
                     {
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.Catalog_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
                       return insertCount+failedRec;
                     }
                   for (int index2 = batchStart; index2 <= index; ++index2)
                     L.get(index2).stateUpdatePostWrite();
                   LOG.debug("Batch-inserted objects between positions #" + insertCount + " and #" + index + ".");
                   batchStart = 0;
                   insertCount+=batchSize;
                 }
               if (commitSize > 0 && index != 0 && (index + 1) % commitSize == 0)
                 {
                   C.commit();
                   LOG.debug("Commited " + commitSize + " batch records. At insert count " + (index-commitSize+1));
                 }
               PS.clearParameters();
             }

           if ((index + 1) % batchSize != 0)
             {
               int[] results = PS.executeBatch();
               int failedRec = JDBCHelper.batchWriteDone(results, L.size() - insertCount);
               if (failedRec != -1)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'Catalog_Data' objects ending at position #" + index + " failed being written to the database.");
                   return L.size() - insertCount+failedRec;
                 }
               for (int index2 = batchStart; index2 <= index; ++index2)
                 L.get(index2).stateUpdatePostWrite();

               if(commitSize > 0)
                 {
                   C.commit();
                 }
               LOG.debug("Final Batch-inserted objects between positions #" + insertCount + " and #" + index + ".");
             }

           C.releaseSavepoint(true);
           return -1;
         }
       catch (java.sql.SQLException E)
         {
           C.releaseSavepoint(false);
           C.handleCatch(E, "updated or inserted");
           return 1;
         }
       finally
         {
           TILDA__2_5.handleFinally(PS, T0, TILDA__CATALOG_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: refnum.
*/
   static public tilda.data.Catalog_Data lookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__CATALOG Obj = new tilda.data.Catalog_Data();
       Obj.initForLookup(0);

       Obj.setRefnum            (refnum            ); Obj.__Saved_refnum             = Obj._refnum            ;

       return (tilda.data.Catalog_Data) Obj;
     }

/**
Lookup one record by the unique index 'Column': schemaName, tableViewName, columnName.
*/
   static public tilda.data.Catalog_Data lookupByColumn(String schemaName, String tableViewName, String columnName) throws Exception
     {
       tilda.data._Tilda.TILDA__CATALOG Obj = new tilda.data.Catalog_Data();
       Obj.initForLookup(1);

       Obj.setSchemaName        (schemaName        ); 
       Obj.setTableViewName     (tableViewName     ); 
       Obj.setColumnName        (columnName        ); 

       return (tilda.data.Catalog_Data) Obj;
     }

/**
Lookup records by the index 'RefColumns' over  .<BR>The results are ordered by: referencedColumns asc
*/
   static public ListResults<tilda.data.Catalog_Data> lookupWhereRefColumns(Connection C, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__CATALOG Obj = new tilda.data.Catalog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, __start__);
       readMany(C, 2, RPI, Obj, null, __start__, __size__);
       return RPI._L;
     }

/**
Lookup records by the index 'RefColumns' over  .<BR>The results are ordered by: referencedColumns asc
*/
   static public void lookupWhereRefColumns(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Catalog_Data> OP, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__CATALOG Obj = new tilda.data.Catalog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, __start__, __size__);
     }



/**
Lookup records by the index 'RefFormulas' over  .<BR>The results are ordered by: referencedFormulas asc
*/
   static public ListResults<tilda.data.Catalog_Data> lookupWhereRefFormulas(Connection C, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__CATALOG Obj = new tilda.data.Catalog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, __start__);
       readMany(C, 3, RPI, Obj, null, __start__, __size__);
       return RPI._L;
     }

/**
Lookup records by the index 'RefFormulas' over  .<BR>The results are ordered by: referencedFormulas asc
*/
   static public void lookupWhereRefFormulas(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Catalog_Data> OP, int __start__, int __size__) throws Exception
     {
       tilda.data._Tilda.TILDA__CATALOG Obj = new tilda.data.Catalog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 3, RPI, Obj, null, __start__, __size__);
     }



/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: schemaName asc, tableViewName asc, columnName asc
*/   static public ListResults<tilda.data.Catalog_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__CATALOG Obj = new tilda.data.Catalog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 4, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: schemaName asc, tableViewName asc, columnName asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Catalog_Data> OP, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__CATALOG Obj = new tilda.data.Catalog_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 4, RPI, Obj, null, start, size);
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.Catalog_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.Catalog_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


   public static String getCSVHeader()
    {
      return "\"refnum\",\"schemaName\",\"tableViewName\",\"columnName\",\"type\",\"nullable\",\"collection\",\"description\",\"tableViewName2\",\"aggregate\",\"title\",\"formula\",\"measure\",\"htmlDoc\",\"referencedColumns\",\"referencedFormulas\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.Catalog_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.Catalog_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.Catalog_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__CATALOG Obj = (tilda.data._Tilda.TILDA__CATALOG) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getSchemaName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getTableViewName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getColumnName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getType());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getNullable());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getCollection());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDescription());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getTableViewName2());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getAggregate());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getTitle());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getFormula());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getMeasure());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getHtmlDoc());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getReferencedColumns(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getReferencedFormulas(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.Catalog_Data> L, String lead, boolean fullList) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (fullList == true)
        {
          if (L == null)
           {
             out.write("null\n");
             return;
           }
          if (L.isEmpty() == true)
           {
             out.write("[]\n");
             return;
           }
          out.write("[\n");
        }
      boolean First = true;
      for (tilda.data.Catalog_Data O : L)
       if (O!=null)
        {
          out.write(lead);
          toJSON(out, O, First == true ? "   " : "  ,", true);
          if (First == true)
           First = false;
        }
      if (fullList == true)
       { 
          out.write(lead);
          out.write("]\n");
       } 
      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

   public static void toJSON(java.io.Writer out, tilda.data.Catalog_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.Catalog_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.Catalog_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__CATALOG Obj = (tilda.data._Tilda.TILDA__CATALOG) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "refnum", ++i==0, Obj.getRefnum());

        JSONUtil.print(out, "schemaName", ++i==0, Obj.getSchemaName());

        JSONUtil.print(out, "tableViewName", ++i==0, Obj.getTableViewName());

        JSONUtil.print(out, "columnName", ++i==0, Obj.getColumnName());

        JSONUtil.print(out, "type", ++i==0, Obj.getType());

      if (Obj.isNullNullable() == false)
        JSONUtil.print(out, "nullable", ++i==0, Obj.getNullable());

      if (Obj.isNullCollection() == false)
        JSONUtil.print(out, "collection", ++i==0, Obj.getCollection());

        JSONUtil.print(out, "description", ++i==0, Obj.getDescription());

      if (Obj.isNullTableViewName2() == false && Obj.getTableViewName2() != null)
        JSONUtil.print(out, "tableViewName2", ++i==0, Obj.getTableViewName2());

      if (Obj.isNullAggregate() == false && Obj.getAggregate() != null)
        JSONUtil.print(out, "aggregate", ++i==0, Obj.getAggregate());

      if (Obj.isNullTitle() == false && Obj.getTitle() != null)
        JSONUtil.print(out, "title", ++i==0, Obj.getTitle());

      if (Obj.isNullFormula() == false && Obj.getFormula() != null)
        JSONUtil.print(out, "formula", ++i==0, Obj.getFormula());

      if (Obj.isNullMeasure() == false)
        JSONUtil.print(out, "measure", ++i==0, Obj.getMeasure());

      if (Obj.isNullHtmlDoc() == false && Obj.getHtmlDoc() != null)
        JSONUtil.print(out, "htmlDoc", ++i==0, Obj.getHtmlDoc());

      if (Obj.isNullReferencedColumns() == false && Obj.getReferencedColumns() != null)
        JSONUtil.print(out, "referencedColumns", ++i==0, Obj.getReferencedColumnsAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "referencedColumns", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullReferencedFormulas() == false && Obj.getReferencedFormulas() != null)
        JSONUtil.print(out, "referencedFormulas", ++i==0, Obj.getReferencedFormulasAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "referencedFormulas", ++i==0);
          out.write("[]");
        }

        JSONUtil.print(out, "created", ++i==0, Obj.getCreated());

        JSONUtil.print(out, "lastUpdated", ++i==0, Obj.getLastUpdated());

      if (Obj.isNullDeleted() == false && Obj.getDeleted() != null)
        JSONUtil.print(out, "deleted", ++i==0, Obj.getDeleted());

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

   public static String getCSVHeaderSimple()
    {
      return "\"schemaName\",\"tableViewName\",\"columnName\",\"type\",\"nullable\",\"collection\",\"description\",\"aggregate\",\"measure\",\"formula\",\"referencedColumns\",\"referencedFormulas\"";
    }

   public static void toCSVSimple(java.io.Writer out, List<tilda.data.Catalog_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeaderSimple() + "\n");
      for (tilda.data.Catalog_Data O : L)
       if (O!=null)
        {
          toCSVSimple(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSVSimple(java.io.Writer out, tilda.data.Catalog_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__CATALOG Obj = (tilda.data._Tilda.TILDA__CATALOG) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getSchemaName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getTableViewName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getColumnName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getType());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getNullable());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getCollection());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDescription());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getAggregate());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getMeasure());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getFormula());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getReferencedColumns(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getReferencedFormulas(), ","));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSONSimple(java.io.Writer out, List<tilda.data.Catalog_Data> L, String lead, boolean fullList) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (fullList == true)
        {
          if (L == null)
           {
             out.write("null\n");
             return;
           }
          if (L.isEmpty() == true)
           {
             out.write("[]\n");
             return;
           }
          out.write("[\n");
        }
      boolean First = true;
      for (tilda.data.Catalog_Data O : L)
       if (O!=null)
        {
          out.write(lead);
          toJSONSimple(out, O, First == true ? "   " : "  ,", true);
          if (First == true)
           First = false;
        }
      if (fullList == true)
       { 
          out.write(lead);
          out.write("]\n");
       } 
      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

   public static void toJSONSimple(java.io.Writer out, tilda.data.Catalog_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSONSimple(out, obj, "", fullObject, false);
    }

   public static void toJSONSimple(java.io.Writer out, tilda.data.Catalog_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSONSimple(out, obj, lead, fullObject, false);
    }

   public static void toJSONSimple(java.io.Writer outWriter, tilda.data.Catalog_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__CATALOG Obj = (tilda.data._Tilda.TILDA__CATALOG) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "schemaName", ++i==0, Obj.getSchemaName());

        JSONUtil.print(out, "tableViewName", ++i==0, Obj.getTableViewName());

        JSONUtil.print(out, "columnName", ++i==0, Obj.getColumnName());

        JSONUtil.print(out, "type", ++i==0, Obj.getType());

      if (Obj.isNullNullable() == false)
        JSONUtil.print(out, "nullable", ++i==0, Obj.getNullable());

      if (Obj.isNullCollection() == false)
        JSONUtil.print(out, "collection", ++i==0, Obj.getCollection());

        JSONUtil.print(out, "description", ++i==0, Obj.getDescription());

      if (Obj.isNullAggregate() == false && Obj.getAggregate() != null)
        JSONUtil.print(out, "aggregate", ++i==0, Obj.getAggregate());

      if (Obj.isNullMeasure() == false)
        JSONUtil.print(out, "measure", ++i==0, Obj.getMeasure());

      if (Obj.isNullFormula() == false && Obj.getFormula() != null)
        JSONUtil.print(out, "formula", ++i==0, Obj.getFormula());

      if (Obj.isNullReferencedColumns() == false && Obj.getReferencedColumns() != null)
        JSONUtil.print(out, "referencedColumns", ++i==0, Obj.getReferencedColumnsAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "referencedColumns", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullReferencedFormulas() == false && Obj.getReferencedFormulas() != null)
        JSONUtil.print(out, "referencedFormulas", ++i==0, Obj.getReferencedFormulasAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "referencedFormulas", ++i==0);
          out.write("[]");
        }

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
