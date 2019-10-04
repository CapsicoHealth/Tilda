/*
 Tilda V1.0 data object.

 Code is generated: do not modify! Instead, create a derived class and override desired functionality
*/

package tilda.data._Tilda;

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
<TABLE id="MeasureFormulaView_DIV" class="tables">
<SCRIPT>registerStickyHeader("MeasureFormulaView_DIV");</SCRIPT>
<TR valign="top"><TD><H2>MeasureFormulaView&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#MeasureFormulaView_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="MeasureFormulaView_CNT" class="content">
The View TILDA.MeasureFormulaView:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>MeasureFormulaView_Factory</B>, <B>MeasureFormulaView_Data</B> in the package <B>tilda.data</B>.
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
</UL>
<B>Description</B>: A view of formulas and their dependencies.<BR>
<BR>
This view depends on the following filter(s), sub-view(s), and/or root table(s):
<BLOCKQUOTE><TABLE class="TreeTable Rowed" border="0px" cellspacing="0px" cellpadding="2px"></TABLE></BLOCKQUOTE>
This View contains the following columns:<BLOCKQUOTE>
 <TABLE id="MeasureFormulaView_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-measureRefnum_DIV' class='columns'>measureRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The measure.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#MeasureFormula-measureRefnum_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>MeasureFormula<B>&nbsp;&#8226;&nbsp;</B>measureRefnum</A><BR>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Measure-refnum_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Measure<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-measureSchema_DIV' class='columns'>measureSchema</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The Schema wher ethe measure is defined.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Measure-schema_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Measure<B>&nbsp;&#8226;&nbsp;</B>schema</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-measureName_DIV' class='columns'>measureName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the measure.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Measure-name_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Measure<B>&nbsp;&#8226;&nbsp;</B>name</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-formulaRefnum_DIV' class='columns'>formulaRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-refnum_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-formulaLocation_DIV' class='columns'>formulaLocation</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the primary table/view this formula is defined in.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-location_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>location</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-formulaLocation2_DIV' class='columns'>formulaLocation2</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the secondary table/view (a derived view, a realized table), if appropriate.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-location2_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>location2</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-formulaName_DIV' class='columns'>formulaName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the formula/column.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-name_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>name</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-title_DIV' class='columns'>title</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title of the formula/column.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-title_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>title</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-description_DIV' class='columns'>description</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The description of the formula/column.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-description_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>description</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-type_DIV' class='columns'>type</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(3)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The type of the formula/column value/outcome.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-type_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>type</A></DIV><BR>This column has defined a number of constant values:
<BLOCKQUOTE>
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#fff6fc"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>Character</B>&nbsp;&nbsp;</TD><TD>CHR&nbsp;&nbsp;</TD><TD>Character&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Character</TD></TR>
  <TR bgcolor="#fff6fc"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Boolean</B>&nbsp;&nbsp;</TD><TD>BOL&nbsp;&nbsp;</TD><TD>Boolean&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Boolean</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Short</B>&nbsp;&nbsp;</TD><TD>SHT&nbsp;&nbsp;</TD><TD>Short&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Short</TD></TR>
  <TR bgcolor="#fff6fc"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#fff6fc"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#fff6fc"><TD>9&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>10&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
  <TR bgcolor="#fff6fc"><TD>11&nbsp;&nbsp;</TD><TD align="right"><B>Numeric</B>&nbsp;&nbsp;</TD><TD>NUM&nbsp;&nbsp;</TD><TD>Numeric&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Numeric</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>12&nbsp;&nbsp;</TD><TD align="right"><B>Uuid</B>&nbsp;&nbsp;</TD><TD>UI&nbsp;&nbsp;</TD><TD>Uuid&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Uuid</TD></TR>
</TABLE>
</BLOCKQUOTE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='MeasureFormulaView-formula_DIV' class='columns'>formula</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The formula.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-formula_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>formula</A></DIV></TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__MEASUREFORMULAVIEW implements tilda.interfaces.ReaderObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__MEASUREFORMULAVIEW.class.getName());

   public static final Class<TILDA__MEASUREFORMULAVIEW_Factory> FACTORY_CLASS= TILDA__MEASUREFORMULAVIEW_Factory.class;
   public static final String TABLENAME = TextUtil.print("TILDA.MeasureFormulaView", "");

   protected TILDA__MEASUREFORMULAVIEW() { }

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
//   Field tilda.data.TILDA.MeasureFormulaView.measureRefnum -> TILDA.MeasureFormulaView."measureRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.measureRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.measureRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The measure.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _measureRefnum= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.measureRefnum -> TILDA.MeasureFormulaView."measureRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.measureRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.measureRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The measure.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getMeasureRefnum()
      { return _measureRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.measureRefnum -> TILDA.MeasureFormulaView."measureRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.measureRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.measureRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The measure.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setMeasureRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _measureRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.measureRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASUREREFNUM._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASUREREFNUM._Mask);
       _measureRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.measureSchema -> TILDA.MeasureFormulaView."measureSchema"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.measureSchema of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.measureSchema of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The Schema wher ethe measure is defined.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _measureSchema;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.measureSchema -> TILDA.MeasureFormulaView."measureSchema"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.measureSchema of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.measureSchema of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The Schema wher ethe measure is defined.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getMeasureSchema()
      { return _measureSchema; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.measureSchema -> TILDA.MeasureFormulaView."measureSchema"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.measureSchema of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.measureSchema of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The Schema wher ethe measure is defined.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setMeasureSchema(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.measureSchema to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.measureSchema: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_measureSchema) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.measureSchema' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURESCHEMA._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURESCHEMA._Mask);
       _measureSchema = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.measureName -> TILDA.MeasureFormulaView."measureName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.measureName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.measureName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the measure.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _measureName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.measureName -> TILDA.MeasureFormulaView."measureName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.measureName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.measureName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the measure.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getMeasureName()
      { return _measureName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.measureName -> TILDA.MeasureFormulaView."measureName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.measureName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.measureName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the measure.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setMeasureName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.measureName to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.measureName: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_measureName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.measureName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURENAME._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURENAME._Mask);
       _measureName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaRefnum -> TILDA.MeasureFormulaView."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _formulaRefnum= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaRefnum -> TILDA.MeasureFormulaView."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormulaRefnum()
      { return _formulaRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaRefnum -> TILDA.MeasureFormulaView."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormulaRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || v != _formulaRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.formulaRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULAREFNUM._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULAREFNUM._Mask);
       _formulaRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaLocation -> TILDA.MeasureFormulaView."formulaLocation"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaLocation of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaLocation of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _formulaLocation;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaLocation -> TILDA.MeasureFormulaView."formulaLocation"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaLocation of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaLocation of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormulaLocation()
      { return _formulaLocation; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaLocation -> TILDA.MeasureFormulaView."formulaLocation"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaLocation of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaLocation of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormulaLocation(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.formulaLocation to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.formulaLocation: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_formulaLocation) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.formulaLocation' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION._Mask);
       _formulaLocation = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaLocation2 -> TILDA.MeasureFormulaView."formulaLocation2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaLocation2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaLocation2 of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the secondary table/view (a derived view, a realized table), if appropriate.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _formulaLocation2;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaLocation2 -> TILDA.MeasureFormulaView."formulaLocation2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaLocation2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaLocation2 of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the secondary table/view (a derived view, a realized table), if appropriate.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormulaLocation2()
      { return _formulaLocation2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaLocation2 -> TILDA.MeasureFormulaView."formulaLocation2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaLocation2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaLocation2 of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the secondary table/view (a derived view, a realized table), if appropriate.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormulaLocation2(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.formulaLocation2 to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.formulaLocation2: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_formulaLocation2) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.formulaLocation2' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION2._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION2._Mask);
       _formulaLocation2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaName -> TILDA.MeasureFormulaView."formulaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _formulaName;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaName -> TILDA.MeasureFormulaView."formulaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormulaName()
      { return _formulaName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formulaName -> TILDA.MeasureFormulaView."formulaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formulaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formulaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormulaName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.formulaName to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.formulaName: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_formulaName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.formulaName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULANAME._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULANAME._Mask);
       _formulaName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.title -> TILDA.MeasureFormulaView."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.title of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.title of type varchar(128)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _title;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.title -> TILDA.MeasureFormulaView."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.title of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.title of type varchar(128)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getTitle()
      { return _title; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.title -> TILDA.MeasureFormulaView."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.title of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.title of type varchar(128)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setTitle(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.title to null: it's not nullable.");
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.title: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 128.");
       else if (v.equals(_title) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.title' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.TITLE._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.TITLE._Mask);
       _title = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.description -> TILDA.MeasureFormulaView."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.description of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _description;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.description -> TILDA.MeasureFormulaView."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.description of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDescription()
      { return _description; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.description -> TILDA.MeasureFormulaView."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.description of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDescription(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.description to null: it's not nullable.");
       else if (v.length() > 32000)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.description: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 32000.");
       else if (v.equals(_description) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.description' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.DESCRIPTION._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.DESCRIPTION._Mask);
       _description = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.type -> TILDA.MeasureFormulaView."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.type of type character(3)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The type of the formula/column value/outcome.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>Character</B>&nbsp;&nbsp;</TD><TD>CHR&nbsp;&nbsp;</TD><TD>Character&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Character</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>Boolean</B>&nbsp;&nbsp;</TD><TD>BOL&nbsp;&nbsp;</TD><TD>Boolean&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Boolean</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Short</B>&nbsp;&nbsp;</TD><TD>SHT&nbsp;&nbsp;</TD><TD>Short&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Short</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>9&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>10&nbsp;&nbsp;</TD><TD align="right"><B>Numeric</B>&nbsp;&nbsp;</TD><TD>NUM&nbsp;&nbsp;</TD><TD>Numeric&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Numeric</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>11&nbsp;&nbsp;</TD><TD align="right"><B>Uuid</B>&nbsp;&nbsp;</TD><TD>UI&nbsp;&nbsp;</TD><TD>Uuid&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Uuid</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   String _type;
/**
These are the enumerated values for tilda.data.TILDA.MeasureFormulaView.type, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>Character</B>&nbsp;&nbsp;</TD><TD>CHR&nbsp;&nbsp;</TD><TD>Character&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Character</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>Boolean</B>&nbsp;&nbsp;</TD><TD>BOL&nbsp;&nbsp;</TD><TD>Boolean&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Boolean</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Short</B>&nbsp;&nbsp;</TD><TD>SHT&nbsp;&nbsp;</TD><TD>Short&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Short</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>9&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>10&nbsp;&nbsp;</TD><TD align="right"><B>Numeric</B>&nbsp;&nbsp;</TD><TD>NUM&nbsp;&nbsp;</TD><TD>Numeric&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Numeric</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>11&nbsp;&nbsp;</TD><TD align="right"><B>Uuid</B>&nbsp;&nbsp;</TD><TD>UI&nbsp;&nbsp;</TD><TD>Uuid&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Uuid</TD></TR>
</TABLE>
*/
   public static final String[][] _type_Values = {
                                               { "STR", "String", "String", "" }
                                             , { "CHR", "Character", "Character", "" }
                                             , { "BOL", "Boolean", "Boolean", "" }
                                             , { "SHT", "Short", "Short", "" }
                                             , { "INT", "Integer", "Integer", "" }
                                             , { "LNG", "Long", "Long", "" }
                                             , { "FLT", "Float", "Float", "" }
                                             , { "DBL", "Double", "Double", "" }
                                             , { "DT" , "Date", "Date", "" }
                                             , { "DTM", "DateTime", "DateTime", "" }
                                             , { "NUM", "Numeric", "Numeric", "" }
                                             , { "UI" , "Uuid", "Uuid", "" }
                                  };
   public static final String _typeString    = "STR";
   public static final String _typeCharacter = "CHR";
   public static final String _typeBoolean   = "BOL";
   public static final String _typeShort     = "SHT";
   public static final String _typeInteger   = "INT";
   public static final String _typeLong      = "LNG";
   public static final String _typeFloat     = "FLT";
   public static final String _typeDouble    = "DBL";
   public static final String _typeDate      = "DT";
   public static final String _typeDateTime  = "DTM";
   public static final String _typeNumeric   = "NUM";
   public static final String _typeUuid      = "UI";

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.type -> TILDA.MeasureFormulaView."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.type of type character(3)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The type of the formula/column value/outcome.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>Character</B>&nbsp;&nbsp;</TD><TD>CHR&nbsp;&nbsp;</TD><TD>Character&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Character</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>Boolean</B>&nbsp;&nbsp;</TD><TD>BOL&nbsp;&nbsp;</TD><TD>Boolean&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Boolean</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Short</B>&nbsp;&nbsp;</TD><TD>SHT&nbsp;&nbsp;</TD><TD>Short&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Short</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>9&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>10&nbsp;&nbsp;</TD><TD align="right"><B>Numeric</B>&nbsp;&nbsp;</TD><TD>NUM&nbsp;&nbsp;</TD><TD>Numeric&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Numeric</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>11&nbsp;&nbsp;</TD><TD align="right"><B>Uuid</B>&nbsp;&nbsp;</TD><TD>UI&nbsp;&nbsp;</TD><TD>Uuid&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Uuid</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final String getType()
      { return _type; }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>String</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>STR</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>String</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>String</TD></TR>
</TABLE>
*/
   public final boolean isTypeString()
      { return _type != null && _type.equals(_typeString); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>Character</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>CHR</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>Character</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Character</TD></TR>
</TABLE>
*/
   public final boolean isTypeCharacter()
      { return _type != null && _type.equals(_typeCharacter); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>Boolean</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>BOL</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>Boolean</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Boolean</TD></TR>
</TABLE>
*/
   public final boolean isTypeBoolean()
      { return _type != null && _type.equals(_typeBoolean); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>Short</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>SHT</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>Short</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Short</TD></TR>
</TABLE>
*/
   public final boolean isTypeShort()
      { return _type != null && _type.equals(_typeShort); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>Integer</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>INT</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>Integer</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Integer</TD></TR>
</TABLE>
*/
   public final boolean isTypeInteger()
      { return _type != null && _type.equals(_typeInteger); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>Long</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>LNG</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>Long</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Long</TD></TR>
</TABLE>
*/
   public final boolean isTypeLong()
      { return _type != null && _type.equals(_typeLong); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>Float</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>FLT</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>Float</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Float</TD></TR>
</TABLE>
*/
   public final boolean isTypeFloat()
      { return _type != null && _type.equals(_typeFloat); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>Double</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>DBL</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>Double</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Double</TD></TR>
</TABLE>
*/
   public final boolean isTypeDouble()
      { return _type != null && _type.equals(_typeDouble); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>Date</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>DT</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>Date</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Date</TD></TR>
</TABLE>
*/
   public final boolean isTypeDate()
      { return _type != null && _type.equals(_typeDate); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>DateTime</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>DTM</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>DateTime</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>DateTime</TD></TR>
</TABLE>
*/
   public final boolean isTypeDateTime()
      { return _type != null && _type.equals(_typeDateTime); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>Numeric</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>NUM</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>Numeric</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Numeric</TD></TR>
</TABLE>
*/
   public final boolean isTypeNumeric()
      { return _type != null && _type.equals(_typeNumeric); }

/**
This is the value is-a for tilda.data.TILDA.MeasureFormulaView.type:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>Uuid</TD></TR>
  <TR><TD align="right"><B>Value</B></TD><TD>UI</TD></TR>
  <TR><TD align="right"><B>Default</B></TD><TD>NONE</TD></TR>
  <TR><TD align="right"><B>Label</B></TD><TD>Uuid</TD></TR>
  <TR><TD align="right"><B>Groupings</B></TD><TD></TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Uuid</TD></TR>
</TABLE>
*/
   public final boolean isTypeUuid()
      { return _type != null && _type.equals(_typeUuid); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.type -> TILDA.MeasureFormulaView."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.type of type character(3)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The type of the formula/column value/outcome.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>Character</B>&nbsp;&nbsp;</TD><TD>CHR&nbsp;&nbsp;</TD><TD>Character&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Character</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>Boolean</B>&nbsp;&nbsp;</TD><TD>BOL&nbsp;&nbsp;</TD><TD>Boolean&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Boolean</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Short</B>&nbsp;&nbsp;</TD><TD>SHT&nbsp;&nbsp;</TD><TD>Short&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Short</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>9&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>10&nbsp;&nbsp;</TD><TD align="right"><B>Numeric</B>&nbsp;&nbsp;</TD><TD>NUM&nbsp;&nbsp;</TD><TD>Numeric&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Numeric</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>11&nbsp;&nbsp;</TD><TD align="right"><B>Uuid</B>&nbsp;&nbsp;</TD><TD>UI&nbsp;&nbsp;</TD><TD>Uuid&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Uuid</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
    void setType(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.type to null: it's not nullable.");
       else if (v.length() > 3)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.type: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 3.");
       else if (v.equals(_type) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.type' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.TYPE._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.TYPE._Mask);
       _type = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formula -> TILDA.MeasureFormulaView."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formula of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _formula;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formula -> TILDA.MeasureFormulaView."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formula of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getFormula()
      { return _formula; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formula -> TILDA.MeasureFormulaView."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formula of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isFormulaNull()
     { return __Nulls.intersects(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formula -> TILDA.MeasureFormulaView."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formula of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormula(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setFormulaNull();
        }
       else if (v.length() > 32000)
        throw new Exception("Cannot set tilda.data.TILDA.MeasureFormulaView.formula: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 32000.");
       else if (v.equals(_formula) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MeasureFormulaView.formula' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask);
          __Nulls.andNot(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask);
       _formula = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MeasureFormulaView.formula -> TILDA.MeasureFormulaView."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MeasureFormulaView.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MeasureFormulaView.formula of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormulaNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask);
       __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask);
       _formula=null;
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
        throw new Exception("This TILDA.MeasureFormulaView object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.MeasureFormulaView object has already been read.");
          QueryDetails.setLastQuery(TILDA__MEASUREFORMULAVIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "measureRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "measureSchema");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "measureName");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "formulaRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "formulaLocation");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "formulaLocation2");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "formulaName");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "title");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "description");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "type");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "MeasureFormulaView", "formula");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "MeasureFormulaView");
       switch (__LookupId)
        {
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__MEASUREFORMULAVIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.MeasureFormulaView", Q, toString());
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
          tilda.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__MEASUREFORMULAVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                                 _measureRefnum    =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASUREREFNUM._Mask   );
                                 _measureSchema    = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURESCHEMA._Mask   );
                                 _measureName      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURENAME._Mask     );
                                 _formulaRefnum    =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULAREFNUM._Mask   );
                                 _formulaLocation  = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION._Mask );
                                 _formulaLocation2 = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION2._Mask);
                                 _formulaName      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULANAME._Mask     );
                                 _title            = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.TITLE._Mask           );
                                 _description      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.DESCRIPTION._Mask     );
                                 _type             = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.TYPE._Mask            ); else _type             = _type            .trim();
                                 _formula          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask         );
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
                   "measureRefnum: "                                                                                                         +                                   getMeasureRefnum   () 
               + "; measureSchema: "                                                                                                         + TextUtil.printVariableStr        (getMeasureSchema   ())
               + "; measureName: "                                                                                                           + TextUtil.printVariableStr        (getMeasureName     ())
               + "; formulaRefnum: "                                                                                                         +                                   getFormulaRefnum   () 
               + "; formulaLocation: "                                                                                                       + TextUtil.printVariableStr        (getFormulaLocation ())
               + "; formulaLocation2: "                                                                                                      + TextUtil.printVariableStr        (getFormulaLocation2())
               + "; formulaName: "                                                                                                           + TextUtil.printVariableStr        (getFormulaName     ())
               + "; title: "                                                                                                                 + TextUtil.printVariableStr        (getTitle           ())
               + "; description: "                                                                                                           + TextUtil.printVariableStr        (getDescription     ())
               + "; type: "                                                                                                                  + TextUtil.printVariableStr        (getType            ())
               + "; formula"            + (__Nulls.intersects(TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask) == true ? ": NULL" : ": " + TextUtil.printVariableStr        (getFormula         ()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
