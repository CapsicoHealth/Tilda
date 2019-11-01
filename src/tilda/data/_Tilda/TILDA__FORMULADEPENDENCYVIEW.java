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

import org.apache.logging.log4j.*;

import com.google.gson.*;
import com.google.gson.annotations.*;
import java.math.*;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
<TABLE id="FormulaDependencyView_DIV" class="tables">
<SCRIPT>registerStickyHeader("FormulaDependencyView_DIV");</SCRIPT>
<TR valign="top"><TD><H2>FormulaDependencyView&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#FormulaDependencyView_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="FormulaDependencyView_CNT" class="content">
The View TILDA.FormulaDependencyView:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>FormulaDependencyView_Factory</B>, <B>FormulaDependencyView_Data</B> in the package <B>tilda.data</B>.
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
</UL>
<B>Description</B>: A view of formulas and their direct dependencies.<BR>
<BR>
This view depends on the following filter(s), sub-view(s), and/or root table(s):
<BLOCKQUOTE><TABLE class="TreeTable Rowed" border="0px" cellspacing="0px" cellpadding="2px"></TABLE></BLOCKQUOTE>
This View contains the following columns:<BLOCKQUOTE>
 <TABLE id="FormulaDependencyView_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaDependencyView-formulaRefnum_DIV' class='columns'>formulaRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The parent formula.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#FormulaDependency-formulaRefnum_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>FormulaDependency<B>&nbsp;&#8226;&nbsp;</B>formulaRefnum</A><BR>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-refnum_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaDependencyView-location_DIV' class='columns'>location</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the primary table/view this formula is defined in.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-location_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>location</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaDependencyView-name_DIV' class='columns'>name</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the formula/column.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-name_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>name</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaDependencyView-referencedColumns_DIV' class='columns'>referencedColumns</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The list of columns this formula depends on.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-referencedColumns_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>referencedColumns</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaDependencyView-dependencyRefnum_DIV' class='columns'>dependencyRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The dependent formula.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#FormulaDependency-dependencyRefnum_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>FormulaDependency<B>&nbsp;&#8226;&nbsp;</B>dependencyRefnum</A><BR>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-refnum_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaDependencyView-dependentFormulaName_DIV' class='columns'>dependentFormulaName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the formula/column.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-name_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>name</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaDependencyView-dependentFormulaLocation_DIV' class='columns'>dependentFormulaLocation</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the primary table/view this formula is defined in.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-location_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>location</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='FormulaDependencyView-dependentReferencedColumns_DIV' class='columns'>dependentReferencedColumns</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The list of columns this formula depends on.<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Formula-referencedColumns_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Formula<B>&nbsp;&#8226;&nbsp;</B>referencedColumns</A></DIV></TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__FORMULADEPENDENCYVIEW implements tilda.interfaces.ReaderObject
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__FORMULADEPENDENCYVIEW.class.getName());

   public transient static final Class<TILDA__FORMULADEPENDENCYVIEW_Factory> FACTORY_CLASS= TILDA__FORMULADEPENDENCYVIEW_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDA.FormulaDependencyView", "");

   protected TILDA__FORMULADEPENDENCYVIEW() { }

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
//   Field tilda.data.TILDA.FormulaDependencyView.formulaRefnum -> TILDA.FormulaDependencyView."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.formulaRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("formulaRefnum")
   Long _formulaRefnum=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.formulaRefnum -> TILDA.FormulaDependencyView."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.formulaRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getFormulaRefnum()
      { return _formulaRefnum==null?0l:_formulaRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.formulaRefnum -> TILDA.FormulaDependencyView."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.formulaRefnum of type bigint</TD></TR>

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
       if (__Init == InitMode.CREATE || _formulaRefnum == null || v != _formulaRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaDependencyView.formulaRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.FORMULAREFNUM._Mask);
          __Nulls.andNot(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.FORMULAREFNUM._Mask);
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
//   Field tilda.data.TILDA.FormulaDependencyView.location -> TILDA.FormulaDependencyView."location"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.location of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.location of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("location")
   String _location=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.location -> TILDA.FormulaDependencyView."location"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.location of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.location of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.FormulaDependencyView.location -> TILDA.FormulaDependencyView."location"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.location of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.location of type varchar(64)</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.FormulaDependencyView.location to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaDependencyView.location: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_location) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaDependencyView.location' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.LOCATION._Mask);
          __Nulls.andNot(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.LOCATION._Mask);
       _location = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field location doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initLocation(String v) throws Exception
     {
       setLocation(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.name -> TILDA.FormulaDependencyView."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.name of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("name")
   String _name=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.name -> TILDA.FormulaDependencyView."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.name of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.FormulaDependencyView.name -> TILDA.FormulaDependencyView."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.name of type varchar(64)</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.FormulaDependencyView.name to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaDependencyView.name: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_name) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaDependencyView.name' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.NAME._Mask);
          __Nulls.andNot(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.NAME._Mask);
       _name = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.referencedColumns -> TILDA.FormulaDependencyView."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.referencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.referencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("referencedColumns")
   List<String> _referencedColumns;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.referencedColumns -> TILDA.FormulaDependencyView."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.referencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.referencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
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
//   Field tilda.data.TILDA.FormulaDependencyView.referencedColumns -> TILDA.FormulaDependencyView."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.referencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.referencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isReferencedColumnsNull()
     { return __Nulls.intersects(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.referencedColumns -> TILDA.FormulaDependencyView."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.referencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.referencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setReferencedColumns(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaDependencyView.referencedColumns' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setReferencedColumnsNull();
       else if (CollectionUtil.equals(v, _referencedColumns) == false)
        {
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask);
          __Nulls.andNot(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask);
          if (_referencedColumns == null)
           {
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
    void addToReferencedColumns(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_referencedColumns == null)
        _referencedColumns = new ArrayList<String>();
       if (v == null)
        {
          setReferencedColumnsNull();
        }
       else if (pos >= _referencedColumns.size() || _referencedColumns.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaDependencyView.referencedColumns' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask);
          __Nulls.andNot(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask);
          _referencedColumns.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromReferencedColumns(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_referencedColumns.remove(v) == true)
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromReferencedColumns(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_referencedColumns.remove(pos) != null)
        {
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.referencedColumns -> TILDA.FormulaDependencyView."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.referencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.referencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setReferencedColumnsNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask);
       __Nulls.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask);
       _referencedColumns=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependencyRefnum -> TILDA.FormulaDependencyView."dependencyRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependencyRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependencyRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The dependent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dependencyRefnum")
   Long _dependencyRefnum=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependencyRefnum -> TILDA.FormulaDependencyView."dependencyRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependencyRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependencyRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The dependent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getDependencyRefnum()
      { return _dependencyRefnum==null?0l:_dependencyRefnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependencyRefnum -> TILDA.FormulaDependencyView."dependencyRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependencyRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependencyRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The dependent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDependencyRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init == InitMode.CREATE || _dependencyRefnum == null || v != _dependencyRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaDependencyView.dependencyRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENCYREFNUM._Mask);
          __Nulls.andNot(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENCYREFNUM._Mask);
       _dependencyRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field dependencyRefnum doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initDependencyRefnum(long v) throws Exception
     {
       setDependencyRefnum(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentFormulaName -> TILDA.FormulaDependencyView."dependentFormulaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentFormulaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentFormulaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dependentFormulaName")
   String _dependentFormulaName=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentFormulaName -> TILDA.FormulaDependencyView."dependentFormulaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentFormulaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentFormulaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDependentFormulaName()
      { return _dependentFormulaName; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentFormulaName -> TILDA.FormulaDependencyView."dependentFormulaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentFormulaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentFormulaName of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDependentFormulaName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaDependencyView.dependentFormulaName to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaDependencyView.dependentFormulaName: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_dependentFormulaName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaDependencyView.dependentFormulaName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTFORMULANAME._Mask);
          __Nulls.andNot(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTFORMULANAME._Mask);
       _dependentFormulaName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation -> TILDA.FormulaDependencyView."dependentFormulaLocation"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentFormulaLocation of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dependentFormulaLocation")
   String _dependentFormulaLocation=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation -> TILDA.FormulaDependencyView."dependentFormulaLocation"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentFormulaLocation of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDependentFormulaLocation()
      { return _dependentFormulaLocation; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation -> TILDA.FormulaDependencyView."dependentFormulaLocation"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentFormulaLocation of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDependentFormulaLocation(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation: the value "+TextUtil.escapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_dependentFormulaLocation) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaDependencyView.dependentFormulaLocation' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTFORMULALOCATION._Mask);
          __Nulls.andNot(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTFORMULALOCATION._Mask);
       _dependentFormulaLocation = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

   /**
    * Being invariant, the field dependentFormulaLocation doesn't have a public setter. To support deserialization however, 
    * we may need to set that field after a create/deserialization and before any write. The init methods allows
    * to do so.
   */
   public void initDependentFormulaLocation(String v) throws Exception
     {
       setDependentFormulaLocation(v);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns -> TILDA.FormulaDependencyView."dependentReferencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentReferencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dependentReferencedColumns")
   List<String> _dependentReferencedColumns;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns -> TILDA.FormulaDependencyView."dependentReferencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentReferencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getDependentReferencedColumnsAsArray()
      { return _dependentReferencedColumns==null? null : _dependentReferencedColumns.toArray(new String[_dependentReferencedColumns.size()]); }
   public final Iterator<String> getDependentReferencedColumns()
      { return _dependentReferencedColumns==null? null : _dependentReferencedColumns.iterator(); }
   public final boolean hasDependentReferencedColumns(String v)
      { return _dependentReferencedColumns==null? false : _dependentReferencedColumns.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns -> TILDA.FormulaDependencyView."dependentReferencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentReferencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isDependentReferencedColumnsNull()
     { return __Nulls.intersects(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns -> TILDA.FormulaDependencyView."dependentReferencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentReferencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDependentReferencedColumns(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
        throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setDependentReferencedColumnsNull();
       else if (CollectionUtil.equals(v, _dependentReferencedColumns) == false)
        {
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask);
          __Nulls.andNot(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask);
          if (_dependentReferencedColumns == null)
           {
             _dependentReferencedColumns = new ArrayList<String>();
           }
          else
           {
             _dependentReferencedColumns.clear();
           }
          for (String i : v)
           {
             _dependentReferencedColumns.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToDependentReferencedColumns(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dependentReferencedColumns == null)
        _dependentReferencedColumns = new ArrayList<String>();
       if (v == null)
        {
          setDependentReferencedColumnsNull();
        }
       else if (pos >= _dependentReferencedColumns.size() || _dependentReferencedColumns.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask);
          __Nulls.andNot(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask);
          _dependentReferencedColumns.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDependentReferencedColumns(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dependentReferencedColumns.remove(v) == true)
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDependentReferencedColumns(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dependentReferencedColumns.remove(pos) != null)
        {
          __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns -> TILDA.FormulaDependencyView."dependentReferencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaDependencyView.dependentReferencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaDependencyView.dependentReferencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDependentReferencedColumnsNull()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask);
       __Nulls.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask);
       _dependentReferencedColumns=null;
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
        throw new Exception("This TILDA.FormulaDependencyView object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.FormulaDependencyView object has already been read.");
          QueryDetails.setLastQuery(TILDA__FORMULADEPENDENCYVIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDA", "FormulaDependencyView", "formulaRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaDependencyView", "location");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaDependencyView", "name");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaDependencyView", "referencedColumns");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaDependencyView", "dependencyRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaDependencyView", "dependentFormulaName");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaDependencyView", "dependentFormulaLocation");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaDependencyView", "dependentReferencedColumns");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "FormulaDependencyView");
       switch (__LookupId)
        {
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__FORMULADEPENDENCYVIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.FormulaDependencyView", Q, toString());
       java.sql.PreparedStatement PS=null;
       java.sql.ResultSet RS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
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
          tilda.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__FORMULADEPENDENCYVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }
    }

   @SuppressWarnings("unchecked")
   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                                           _formulaRefnum              =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.FORMULAREFNUM._Mask             );
                                           _location                   = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.LOCATION._Mask                  );
                                           _name                       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.NAME._Mask                      );
                                           _referencedColumns = (List<String>) C.getArray(RS, ++i, TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask         );
                                           _dependencyRefnum           =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENCYREFNUM._Mask          );
                                           _dependentFormulaName       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTFORMULANAME._Mask      );
                                           _dependentFormulaLocation   = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTFORMULALOCATION._Mask  );
                                           _dependentReferencedColumns = (List<String>) C.getArray(RS, ++i, TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask);
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
                   "formulaRefnum: "                                                                                                                                +                                   getFormulaRefnum             () 
               + "; location: "                                                                                                                                     + TextUtil.printVariableStr        (getLocation                  ())
               + "; name: "                                                                                                                                         + TextUtil.printVariableStr        (getName                      ())
               + "; referencedColumns"            + (__Nulls.intersects(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.REFERENCEDCOLUMNS._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getReferencedColumns         ()))
               + "; dependencyRefnum: "                                                                                                                             +                                   getDependencyRefnum          () 
               + "; dependentFormulaName: "                                                                                                                         + TextUtil.printVariableStr        (getDependentFormulaName      ())
               + "; dependentFormulaLocation: "                                                                                                                     + TextUtil.printVariableStr        (getDependentFormulaLocation  ())
               + "; dependentReferencedColumns"   + (__Nulls.intersects(TILDA__FORMULADEPENDENCYVIEW_Factory.COLS.DEPENDENTREFERENCEDCOLUMNS._Mask) == true ? ": NULL" : ": " + TextUtil.print                   (getDependentReferencedColumns()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
