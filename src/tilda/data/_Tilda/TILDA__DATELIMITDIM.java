/*
 Tilda V1.0 data object.

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
<TABLE id="DateLimitDim_DIV" class="tables">
<SCRIPT>registerStickyHeader("DateLimitDim_DIV");</SCRIPT>
<TR valign="top"><TD><H2>DateLimitDim&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#DateLimitDim_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="DateLimitDim_CNT" class="content">
The Table TILDA.DateLimitDim:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>DateLimitDim_Factory</B>, <B>DateLimitDim_Data</B> in the package <B>tilda.data</B>.
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
<LI>Defines foreign key(s) to <A href="TILDA___Docs.TILDA.html#DateDim_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>DateDim</A> </LI>
<LI>Has the following identity:<UL><LI>Unique Index: invalidDate</LI>
</UL></LI>
</UL>
<B>Description</B>: A single row for min, max and invalid dates for the Date_Dim<BR>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="DateLimitDim_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('DateLimitDim-invalidDate')" align="right"><B id='DateLimitDim-invalidDate_DIV' class='columns dotted_underline cursor_pointer'>invalidDate</B>&nbsp;&nbsp;</TD>
<TD>LocalDate&nbsp;/&nbsp;date&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The invalid date<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#DateDim_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>DateDim</A>: dt</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('DateLimitDim-minDate')" align="right"><B id='DateLimitDim-minDate_DIV' class='columns dotted_underline cursor_pointer'>minDate</B>&nbsp;&nbsp;</TD>
<TD>LocalDate&nbsp;/&nbsp;date&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The min date<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#DateDim_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>DateDim</A>: dt</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('DateLimitDim-maxDate')" align="right"><B id='DateLimitDim-maxDate_DIV' class='columns dotted_underline cursor_pointer'>maxDate</B>&nbsp;&nbsp;</TD>
<TD>LocalDate&nbsp;/&nbsp;date&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The max date<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#DateDim_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>DateDim</A>: dt</TD></TR>
</TABLE>
</TD>
</TR>
</TABLE></BLOCKQUOTE>
<DIV id='DateLimitDim-invalidDate_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('DateLimitDim-invalidDate_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#DateLimitDim_DIV'>DateLimitDim</a></td>
<td><a href='TILDA___Docs.TILDA.html#DateLimitDim-invalidDate_DIV'>invalidDate</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#DateDim_DIV'>DateDim</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#DateDim-dt_DIV'>dt</a> -- DATE</td>
</tr>
</table>
</DIV></DIV>
<DIV id='DateLimitDim-minDate_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('DateLimitDim-minDate_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#DateLimitDim_DIV'>DateLimitDim</a></td>
<td><a href='TILDA___Docs.TILDA.html#DateLimitDim-minDate_DIV'>minDate</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#DateDim_DIV'>DateDim</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#DateDim-dt_DIV'>dt</a> -- DATE</td>
</tr>
</table>
</DIV></DIV>
<DIV id='DateLimitDim-maxDate_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('DateLimitDim-maxDate_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#DateLimitDim_DIV'>DateLimitDim</a></td>
<td><a href='TILDA___Docs.TILDA.html#DateLimitDim-maxDate_DIV'>maxDate</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#DateDim_DIV'>DateDim</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#DateDim-dt_DIV'>dt</a> -- DATE</td>
</tr>
</table>
</DIV></DIV>
</DIV>

 @author   Tilda code gen for Java 8/PostgreSQL
 @version  Tilda 1.0
 @generated Jan 18 2019, 15:32:16EST
*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__DATELIMITDIM implements tilda.interfaces.WriterObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__DATELIMITDIM.class.getName());

   public static final Class<TILDA__DATELIMITDIM_Factory> FACTORY_CLASS= TILDA__DATELIMITDIM_Factory.class;
   public static final String TABLENAME = TextUtil.Print("TILDA.DateLimitDim", "");

   protected TILDA__DATELIMITDIM() { }

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
//   Field tilda.data.TILDA.DateLimitDim.invalidDate -> TILDA.DateLimitDim."invalidDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.invalidDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.invalidDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The invalid date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   LocalDate _invalidDate;
   protected LocalDate __Saved_invalidDate;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.invalidDate -> TILDA.DateLimitDim."invalidDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.invalidDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.invalidDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The invalid date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final LocalDate getInvalidDate()
      { return _invalidDate; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.invalidDate -> TILDA.DateLimitDim."invalidDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.invalidDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.invalidDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The invalid date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setInvalidDate(LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.DateLimitDim.invalidDate to null: it's not nullable.");
       else if (v.equals(_invalidDate) == false)
        {
          __Changes.or(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask);
          __Nulls.andNot(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask);
       _invalidDate = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.invalidDate -> TILDA.DateLimitDim."invalidDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.invalidDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.invalidDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The invalid date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedInvalidDate()
     { return __Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.minDate -> TILDA.DateLimitDim."minDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.minDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.minDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The min date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   LocalDate _minDate;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.minDate -> TILDA.DateLimitDim."minDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.minDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.minDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The min date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final LocalDate getMinDate()
      { return _minDate; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.minDate -> TILDA.DateLimitDim."minDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.minDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.minDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The min date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setMinDate(LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.DateLimitDim.minDate to null: it's not nullable.");
       else if (v.equals(_minDate) == false)
        {
          __Changes.or(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask);
          __Nulls.andNot(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask);
       _minDate = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.minDate -> TILDA.DateLimitDim."minDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.minDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.minDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The min date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedMinDate()
     { return __Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.maxDate -> TILDA.DateLimitDim."maxDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.maxDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.maxDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The max date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   LocalDate _maxDate;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.maxDate -> TILDA.DateLimitDim."maxDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.maxDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.maxDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The max date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final LocalDate getMaxDate()
      { return _maxDate; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.maxDate -> TILDA.DateLimitDim."maxDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.maxDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.maxDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The max date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setMaxDate(LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.DateLimitDim.maxDate to null: it's not nullable.");
       else if (v.equals(_maxDate) == false)
        {
          __Changes.or(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask);
          __Nulls.andNot(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask);
       _maxDate = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.DateLimitDim.maxDate -> TILDA.DateLimitDim."maxDate"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.DateLimitDim.maxDate of type LocalDate</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.DateLimitDim.maxDate of type date</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The max date</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedMaxDate()
     { return __Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void CopyTo(tilda.data._Tilda.TILDA__DATELIMITDIM Dst) throws Exception
     {
       Dst.setInvalidDate(_invalidDate);
       Dst.setMinDate    (_minDate    );
       Dst.setMaxDate    (_maxDate    );
     }

/**
 Writes the object to the data store if any changes has occurred since the object was initially
 read from the data store or last written. 
*/
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDA", "DateLimitDim");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == true) { TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_invalidDate) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == true) { TILDA__DATELIMITDIM_Factory.COLS.MINDATE.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_minDate) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == true) { TILDA__DATELIMITDIM_Factory.COLS.MAXDATE.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_maxDate) == true ? C.getCommaCurrentTimestamp() : tilda.data._Tilda.TILDA__1_0._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDA", "DateLimitDim"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_invalidDate) == true)
              { TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_minDate) == true)
              { TILDA__DATELIMITDIM_Factory.COLS.MINDATE.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__DATELIMITDIM_Factory.COLS.MINDATE.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == false && DateTimeUtil.isNowPlaceholder(_maxDate) == true)
              { TILDA__DATELIMITDIM_Factory.COLS.MAXDATE.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__DATELIMITDIM_Factory.COLS.MAXDATE.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0:
                S.append(" where ("); C.getFullColumnVar(S, "TILDA", "DateLimitDim", "invalidDate"); S.append("=?)");
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
       QueryDetails.setLastQuery(TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.DateLimitDim", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask) == true) PS.setNull(++i, java.sql.Types.DATE); else if (DateTimeUtil.isNowPlaceholder(_invalidDate) == false)  PS.setDate(++i, new java.sql.Date(_invalidDate.getYear()-1900, _invalidDate.getMonthValue()-1, _invalidDate.getDayOfMonth()));
        } 
       if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask) == true) PS.setNull(++i, java.sql.Types.DATE); else if (DateTimeUtil.isNowPlaceholder(_minDate) == false)  PS.setDate(++i, new java.sql.Date(_minDate.getYear()-1900, _minDate.getMonthValue()-1, _minDate.getDayOfMonth()));
        } 
       if (__Changes.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask) == true) PS.setNull(++i, java.sql.Types.DATE); else if (DateTimeUtil.isNowPlaceholder(_maxDate) == false)  PS.setDate(++i, new java.sql.Date(_maxDate.getYear()-1900, _maxDate.getMonthValue()-1, _maxDate.getDayOfMonth()));
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
             __Saved_invalidDate = _invalidDate;
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
        }

       __Changes.clear();
       __Nulls.clear();
     }
   public final boolean Write(Connection C) throws Exception
     {
       long T0 = System.nanoTime();
       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.DateLimitDim has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }

       if (BeforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data.TILDA.DateLimitDim object's BeforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
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
               PS.setDate(++i, new java.sql.Date(_invalidDate.getYear(), _invalidDate.getMonthValue(), _invalidDate.getDayOfMonth()));
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
          return tilda.data._Tilda.TILDA__1_0.HandleCatch(C, E, "updated or inserted");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, null);
          PS = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean BeforeWrite(Connection C) throws Exception;



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
        throw new Exception("This TILDA.DateLimitDim object is being Read() after a Create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.DateLimitDim object has already been read.");
          QueryDetails.setLastQuery(TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          S.append(" "); C.getFullColumnVar(S, "TILDA", "DateLimitDim", "invalidDate");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateLimitDim", "minDate");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "DateLimitDim", "maxDate");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "DateLimitDim");
       switch (__LookupId)
        {
          case 0:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "DateLimitDim", "invalidDate"); S.append("=?)");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.DateLimitDim", Q, toString());
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
               PS.setDate(++i, new java.sql.Date(_invalidDate.getYear(), _invalidDate.getMonthValue(), _invalidDate.getDayOfMonth()));
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__DATELIMITDIM_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_invalidDate = _invalidDate = DateTimeUtil.toLocalDate(RS.getDate(++i)); if (RS.wasNull() == true) __Nulls.or(TILDA__DATELIMITDIM_Factory.COLS.INVALIDDATE._Mask);
                            _minDate     = DateTimeUtil.toLocalDate(RS.getDate(++i)); if (RS.wasNull() == true) __Nulls.or(TILDA__DATELIMITDIM_Factory.COLS.MINDATE._Mask    );
                            _maxDate     = DateTimeUtil.toLocalDate(RS.getDate(++i)); if (RS.wasNull() == true) __Nulls.or(TILDA__DATELIMITDIM_Factory.COLS.MAXDATE._Mask    );
     __LookupId = 0;
     __Init     = InitMode.READ;
     __Changes.clear();
     return AfterRead(C);
   }

   protected abstract boolean AfterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "invalidDate: "                                                                                           +                                   getInvalidDate() 
               + "; minDate: "                                                                                               +                                   getMinDate    () 
               + "; maxDate: "                                                                                               +                                   getMaxDate    () 
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
