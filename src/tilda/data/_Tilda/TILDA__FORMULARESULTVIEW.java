/*
 Tilda V1.0 data object.

 Code is generated: do not modify! Instead, create a derived class and override desired functionality
*/

package tilda.data._Tilda;

import java.io.Writer;

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
<DIV>
<DIV id='FORMULARESULTVIEW_DIV' class='tables'>
<H2>FORMULARESULTVIEW&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 60%;"><A href="#">top</A></SUP></H2>
</DIV>
The generated Java 8/PostgreSQL Tilda data class <B>Data_FORMULARESULTVIEW</B> is mapped to the View <B>TILDA.FORMULARESULTVIEW</B>.
<UL>

<LI>That View is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
</UL>
<B>Description</B>: A view of formulas and their values.<BR>
<BR>

<BLOCKQUOTE>That view is filtered: <BLOCKQUOTE><PRE>Formula.deleted is null</PRE>Active formulas and their result values</BLOCKQUOTE>
It contains the following columns:<BR>
 <TABLE border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><!--TH align="left">Column</TH--><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>

  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('FORMULARESULTVIEW-formulaRefnum')" align="right"><B id='FORMULARESULTVIEW-formulaRefnum_DIV' class='columns dotted_underline cursor_pointer'>formulaRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;&nbsp;</TD>
<TD>bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The parent formula.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('FORMULARESULTVIEW-value')" align="right"><B id='FORMULARESULTVIEW-value_DIV' class='columns dotted_underline cursor_pointer'>value</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;&nbsp;</TD>
<TD>varchar(100)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The result value.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('FORMULARESULTVIEW-description')" align="right"><B id='FORMULARESULTVIEW-description_DIV' class='columns dotted_underline cursor_pointer'>description</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;&nbsp;</TD>
<TD>text&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The description of the result value.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>4&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('FORMULARESULTVIEW-location')" align="right"><B id='FORMULARESULTVIEW-location_DIV' class='columns dotted_underline cursor_pointer'>location</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;&nbsp;</TD>
<TD>varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the primary table/view this formula is defined in.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('FORMULARESULTVIEW-name')" align="right"><B id='FORMULARESULTVIEW-name_DIV' class='columns dotted_underline cursor_pointer'>name</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;&nbsp;</TD>
<TD>varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the formula/column.</TD>
</TR>
</TABLE>
<DIV id='FORMULARESULTVIEW-formulaRefnum_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('FORMULARESULTVIEW-formulaRefnum_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#FORMULARESULTVIEW_DIV'>FormulaResultView</a></td>
<td><a href='TILDA___Docs.TILDA.html#FORMULARESULTVIEW-formulaRefnum_DIV'>formulaRefnum</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULARESULT_DIV'>FormulaResult</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULARESULT-formulaRefnum_DIV'>formulaRefnum</a></td>
</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-refnum_DIV'>refnum</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='FORMULARESULTVIEW-value_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('FORMULARESULTVIEW-value_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#FORMULARESULTVIEW_DIV'>FormulaResultView</a></td>
<td><a href='TILDA___Docs.TILDA.html#FORMULARESULTVIEW-value_DIV'>value</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULARESULT_DIV'>FormulaResult</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULARESULT-value_DIV'>value</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='FORMULARESULTVIEW-description_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('FORMULARESULTVIEW-description_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#FORMULARESULTVIEW_DIV'>FormulaResultView</a></td>
<td><a href='TILDA___Docs.TILDA.html#FORMULARESULTVIEW-description_DIV'>description</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULARESULT_DIV'>FormulaResult</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULARESULT-description_DIV'>description</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='FORMULARESULTVIEW-location_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('FORMULARESULTVIEW-location_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#FORMULARESULTVIEW_DIV'>FormulaResultView</a></td>
<td><a href='TILDA___Docs.TILDA.html#FORMULARESULTVIEW-location_DIV'>location</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-location_DIV'>location</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='FORMULARESULTVIEW-name_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('FORMULARESULTVIEW-name_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#FORMULARESULTVIEW_DIV'>FormulaResultView</a></td>
<td><a href='TILDA___Docs.TILDA.html#FORMULARESULTVIEW-name_DIV'>name</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-name_DIV'>name</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
</DIV>

 @author   Tilda code gen for Java 8/PostgreSQL
 @version  Tilda 1.0
 @generated Jan 21 2018, 19:00:17EST
*/
public abstract class TILDA__FORMULARESULTVIEW implements tilda.interfaces.ReaderObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__FORMULARESULTVIEW.class.getName());

   public static final Class<TILDA__FORMULARESULTVIEW_Factory> FACTORY_CLASS= TILDA__FORMULARESULTVIEW_Factory.class;
   public static final String TABLENAME = TextUtil.Print("TILDA.FORMULARESULTVIEW", "");

   protected TILDA__FORMULARESULTVIEW() { }

   private InitMode __Init        = null;
   private long     __Nulls1      = 0L;
   private long     __Nulls2      = 0L;
   private long     __Nulls3      = 0L;
   private long     __Nulls4      = 0L;
   private long     __Nulls5      = 0L;
   private long     __Nulls6      = 0L;
   private long     __Changes1    = 0L;
   private long     __Changes2    = 0L;
   private long     __Changes3    = 0L;
   private long     __Changes4    = 0L;
   private long     __Changes5    = 0L;
   private long     __Changes6    = 0L;
   private boolean  __NewlyCreated= false;
   private int      __LookupId;

   public  boolean hasChanged    () { return __Changes1 != 0L || __Changes2 != 0L || __Changes3 != 0L || __Changes4 != 0L || __Changes5 != 0L || __Changes6 != 0L; }
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
//   Field tilda.data.TILDA.FORMULARESULTVIEW.formulaRefnum -> TILDA.FORMULARESULTVIEW."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.formulaRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _formulaRefnum= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.formulaRefnum -> TILDA.FORMULARESULTVIEW."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.formulaRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormulaRefnum()
      { return _formulaRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.formulaRefnum -> TILDA.FORMULARESULTVIEW."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.formulaRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setFormulaRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _formulaRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FORMULARESULTVIEW.formulaRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__FORMULARESULTVIEW_Factory.COLS.FORMULAREFNUM._Mask1;
          __Nulls1   &= ~TILDA__FORMULARESULTVIEW_Factory.COLS.FORMULAREFNUM._Mask1;
       _formulaRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.value -> TILDA.FORMULARESULTVIEW."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.value of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.value of type varchar(100)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _value;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.value -> TILDA.FORMULARESULTVIEW."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.value of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.value of type varchar(100)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getValue()
      { return _value; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.value -> TILDA.FORMULARESULTVIEW."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.value of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.value of type varchar(100)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setValue(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.FORMULARESULTVIEW.value to null: it's not nullable.");
       else if (v.length() > 100)
        throw new Exception("Cannot set tilda.data.TILDA.FORMULARESULTVIEW.value: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 100.");
       else if (v.equals(_value) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FORMULARESULTVIEW.value' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__FORMULARESULTVIEW_Factory.COLS.VALUE._Mask1;
          __Nulls1   &= ~TILDA__FORMULARESULTVIEW_Factory.COLS.VALUE._Mask1;
       _value = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.description -> TILDA.FORMULARESULTVIEW."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.description of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _description;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.description -> TILDA.FORMULARESULTVIEW."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.description of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDescription()
      { return _description; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.description -> TILDA.FORMULARESULTVIEW."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.description of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDescription(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.FORMULARESULTVIEW.description to null: it's not nullable.");
       else if (v.length() > 32000)
        throw new Exception("Cannot set tilda.data.TILDA.FORMULARESULTVIEW.description: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 32000.");
       else if (v.equals(_description) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FORMULARESULTVIEW.description' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__FORMULARESULTVIEW_Factory.COLS.DESCRIPTION._Mask1;
          __Nulls1   &= ~TILDA__FORMULARESULTVIEW_Factory.COLS.DESCRIPTION._Mask1;
       _description = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.location -> TILDA.FORMULARESULTVIEW."location"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.location of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.location of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _location;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.location -> TILDA.FORMULARESULTVIEW."location"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.location of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.location of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getLocation()
      { return _location; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.location -> TILDA.FORMULARESULTVIEW."location"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.location of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.location of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setLocation(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.FORMULARESULTVIEW.location to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.FORMULARESULTVIEW.location: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_location) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FORMULARESULTVIEW.location' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__FORMULARESULTVIEW_Factory.COLS.LOCATION._Mask1;
          __Nulls1   &= ~TILDA__FORMULARESULTVIEW_Factory.COLS.LOCATION._Mask1;
       _location = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.name -> TILDA.FORMULARESULTVIEW."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.name of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _name;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.name -> TILDA.FORMULARESULTVIEW."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.name of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getName()
      { return _name; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FORMULARESULTVIEW.name -> TILDA.FORMULARESULTVIEW."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FORMULARESULTVIEW.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FORMULARESULTVIEW.name of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.FORMULARESULTVIEW.name to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.FORMULARESULTVIEW.name: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_name) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FORMULARESULTVIEW.name' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__FORMULARESULTVIEW_Factory.COLS.NAME._Mask1;
          __Nulls1   &= ~TILDA__FORMULARESULTVIEW_Factory.COLS.NAME._Mask1;
       _name = v;
        }
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
        throw new Exception("This TILDA.FORMULARESULTVIEW object is being Read() after a Create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.FORMULARESULTVIEW object has already been read.");
          QueryDetails.setLastQuery(TILDA__FORMULARESULTVIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "FORMULARESULTVIEW", "formulaRefnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "FORMULARESULTVIEW", "value");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "FORMULARESULTVIEW", "description");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "FORMULARESULTVIEW", "location");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "FORMULARESULTVIEW", "name");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "FORMULARESULTVIEW");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "FORMULARESULTVIEW", "formulaRefnum"); S.append("=? AND "); C.getFullColumnVar(S, "TILDA", "FORMULARESULTVIEW", "value"); S.append("=?)");
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__FORMULARESULTVIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.FORMULARESULTVIEW", Q, toString());
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
               PS.setLong     (++i, _formulaRefnum);
               PS.setString   (++i, _value        );
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
          return Init(C, RS);
        }
       catch (java.sql.SQLException E)
        {
          return tilda.data._Tilda.TILDA__1_0.HandleCatch(C, E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__FORMULARESULTVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                              _formulaRefnum =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__FORMULARESULTVIEW_Factory.COLS.FORMULAREFNUM._Mask1;
                              _value         = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__FORMULARESULTVIEW_Factory.COLS.VALUE._Mask1        ;
                              _description   = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__FORMULARESULTVIEW_Factory.COLS.DESCRIPTION._Mask1  ;
                              _location      = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__FORMULARESULTVIEW_Factory.COLS.LOCATION._Mask1     ;
                              _name          = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__FORMULARESULTVIEW_Factory.COLS.NAME._Mask1         ;
     __LookupId = 0;
     __Init     = InitMode.READ;
     __Changes1 = __Changes2 = __Changes3 = __Changes4 = __Changes5 = __Changes6 = 0L;
     return AfterRead(C);
   }

   protected abstract boolean AfterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "formulaRefnum: "                                                                                                   +                                   getFormulaRefnum() 
               + "; value: "                                                                                                           + TextUtil.PrintVariableStr        (getValue        ())
               + "; description: "                                                                                                     + TextUtil.PrintVariableStr        (getDescription  ())
               + "; location: "                                                                                                        + TextUtil.PrintVariableStr        (getLocation     ())
               + "; name: "                                                                                                            + TextUtil.PrintVariableStr        (getName         ())
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }
 }
