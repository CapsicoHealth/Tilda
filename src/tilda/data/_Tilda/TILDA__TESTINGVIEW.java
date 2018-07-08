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
<TABLE id="TestingView_DIV" class="tables">
<SCRIPT>registerStickyHeader("TestingView_DIV");</SCRIPT>
<TR valign="top"><TD><H2>TestingView&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#TestingView_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="TestingView_CNT" class="content">
The View TILDA.TestingView:<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>TestingView_Factory</B>, <B>TestingView_Data</B> in the package <B>tilda.data</B>.
<LI>Is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
</UL>
<B>Description</B>: A view of formulas and their dependencies.<BR>
<BR>
This view depends on the following filter(s), sub-view(s), and/or root table(s):
<BLOCKQUOTE><TABLE class="TreeTable Rowed" border="0px" cellspacing="0px" cellpadding="2px"></TABLE></BLOCKQUOTE>
This View contains the following columns:<BLOCKQUOTE>
 <TABLE id="TestingView_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description/<label>Formula<input type="checkbox" onchange="filterTable('TestingView_TBL', 'F')", id="TestingView_TBL_F"></label></TH></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('TestingView-name')" align="right"><B id='TestingView-name_DIV' class='columns dotted_underline cursor_pointer'>name</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(10)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Medical system unique enterprise id<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing-name_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>name</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('TestingView-refnum')" align="right"><B id='TestingView-refnum_DIV' class='columns dotted_underline cursor_pointer'>refnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing-refnum_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>refnum</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('TestingView-a2Min')" align="right"><B id='TestingView-a2Min_DIV' class='columns dotted_underline cursor_pointer'>a2Min</B>&nbsp;&nbsp;</TD>
<TD>char&nbsp;/&nbsp;character&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing-a2_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a2</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>4&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('TestingView-a2Max')" align="right"><B id='TestingView-a2Max_DIV' class='columns dotted_underline cursor_pointer'>a2Max</B>&nbsp;&nbsp;</TD>
<TD>char&nbsp;/&nbsp;character&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing-a2_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a2</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingView-a9TZ_DIV' class='columns'>a9TZ</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'a9'.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>6&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('TestingView-a9')" align="right"><B id='TestingView-a9_DIV' class='columns dotted_underline cursor_pointer'>a9</B>&nbsp;&nbsp;</TD>
<TD>List<ZonedDateTime> List<>&nbsp;/&nbsp;timestamptz[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing-a9_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a9</A></DIV></TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>7&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('TestingView-a9c')" align="right"><B id='TestingView-a9c_DIV' class='columns dotted_underline cursor_pointer'>a9c</B>&nbsp;&nbsp;</TD>
<TD>List<LocalDate> List<>&nbsp;/&nbsp;date[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah<DIV style="margin:0px;margin-left:20px;font-size:75%;">&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#Testing-a9c_DIV">TILDA<B>&nbsp;&#8226;&nbsp;</B>Testing<B>&nbsp;&#8226;&nbsp;</B>a9c</A></DIV></TD>
</TR>
</TABLE></BLOCKQUOTE>
<DIV id='TestingView-name_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TestingView-name_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView_DIV'>TestingView</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView-name_DIV'>name</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing_DIV'>Testing</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing-name_DIV'>name</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TestingView-refnum_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TestingView-refnum_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView_DIV'>TestingView</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView-refnum_DIV'>refnum</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing_DIV'>Testing</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing-refnum_DIV'>refnum</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TestingView-a2Min_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TestingView-a2Min_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView_DIV'>TestingView</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView-a2Min_DIV'>a2Min</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing_DIV'>Testing</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing-a2_DIV'>a2</a> -- CHAR</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TestingView-a2Max_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TestingView-a2Max_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView_DIV'>TestingView</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView-a2Max_DIV'>a2Max</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing_DIV'>Testing</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing-a2_DIV'>a2</a> -- CHAR</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TestingView-a9TZ_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TestingView-a9TZ_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView_DIV'>TestingView</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView-a9TZ_DIV'>a9TZ</a> -- STRING[]</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TestingView-a9_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TestingView-a9_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView_DIV'>TestingView</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView-a9_DIV'>a9</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing_DIV'>Testing</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing-a9_DIV'>a9</a> -- DATETIME</td>
</tr>
</table>
</DIV></DIV>
<DIV id='TestingView-a9c_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('TestingView-a9c_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView_DIV'>TestingView</a></td>
<td><a href='TILDA___Docs.TILDA.html#TestingView-a9c_DIV'>a9c</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing_DIV'>Testing</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#Testing-a9c_DIV'>a9c</a> -- DATE</td>
</tr>
</table>
</DIV></DIV>
</DIV>

 @author   Tilda code gen for Java 8/PostgreSQL
 @version  Tilda 1.0
 @generated Jul 8 2018, 00:16:31EDT
*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TESTINGVIEW implements tilda.interfaces.ReaderObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTINGVIEW.class.getName());

   public static final Class<TILDA__TESTINGVIEW_Factory> FACTORY_CLASS= TILDA__TESTINGVIEW_Factory.class;
   public static final String TABLENAME = TextUtil.Print("TILDA.TestingView", "");

   protected TILDA__TESTINGVIEW() { }

   private InitMode __Init        = null;
   private BitSet   __Nulls       = new BitSet(64);
   private BitSet   __Changes     = new BitSet(64);
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
//   Field tilda.data.TILDA.TestingView.name -> TILDA.TestingView."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _name;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.name -> TILDA.TestingView."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getName()
      { return _name; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.name -> TILDA.TestingView."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setName(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.TestingView.name to null: it's not nullable.");
       else if (v.length() > 10)
        throw new Exception("Cannot set tilda.data.TILDA.TestingView.name: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 10.");
       else if (v.equals(_name) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.name' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.NAME._Mask);
          __Nulls.andNot(TILDA__TESTINGVIEW_Factory.COLS.NAME._Mask);
       _name = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.refnum -> TILDA.TestingView."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   long _refnum= SystemValues.EVIL_VALUE;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.refnum -> TILDA.TestingView."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final long getRefnum()
      { return _refnum; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.refnum -> TILDA.TestingView."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setRefnum(long v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _refnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.refnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.REFNUM._Mask);
          __Nulls.andNot(TILDA__TESTINGVIEW_Factory.COLS.REFNUM._Mask);
       _refnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Min -> TILDA.TestingView."a2Min"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Min of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Min of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   char _a2Min= Character.UNASSIGNED;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Min -> TILDA.TestingView."a2Min"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Min of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Min of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final char getA2Min()
      { return _a2Min; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Min -> TILDA.TestingView."a2Min"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Min of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Min of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA2Min()
     { return __Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A2MIN._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Min -> TILDA.TestingView."a2Min"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Min of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Min of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA2Min(char v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _a2Min)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.a2Min' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A2MIN._Mask);
          __Nulls.andNot(TILDA__TESTINGVIEW_Factory.COLS.A2MIN._Mask);
       _a2Min = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Min -> TILDA.TestingView."a2Min"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Min of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Min of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA2Min()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A2MIN._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A2MIN._Mask);
       __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.A2MIN._Mask);
       _a2Min=Character.UNASSIGNED;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Max -> TILDA.TestingView."a2Max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Max of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Max of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   char _a2Max= Character.UNASSIGNED;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Max -> TILDA.TestingView."a2Max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Max of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Max of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final char getA2Max()
      { return _a2Max; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Max -> TILDA.TestingView."a2Max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Max of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Max of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA2Max()
     { return __Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A2MAX._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Max -> TILDA.TestingView."a2Max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Max of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Max of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA2Max(char v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v != _a2Max)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.a2Max' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A2MAX._Mask);
          __Nulls.andNot(TILDA__TESTINGVIEW_Factory.COLS.A2MAX._Mask);
       _a2Max = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a2Max -> TILDA.TestingView."a2Max"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a2Max of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a2Max of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA2Max()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A2MAX._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A2MAX._Mask);
       __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.A2MAX._Mask);
       _a2Max=Character.UNASSIGNED;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9TZ -> TILDA.TestingView."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9TZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9TZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   List<String> _a9TZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9TZ -> TILDA.TestingView."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9TZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9TZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getA9TZAsArray()
      { return _a9TZ==null? null : _a9TZ.toArray(new String[_a9TZ.size()]); }
   public final Iterator<String> getA9TZ()
      { return _a9TZ==null? null : _a9TZ.iterator(); }
   public final boolean hasA9TZ(String v)
      { return _a9TZ==null? false : _a9TZ.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9TZ -> TILDA.TestingView."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9TZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9TZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA9TZ()
     { return __Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9TZ -> TILDA.TestingView."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9TZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9TZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA9TZ(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
        throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.a9TZ' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullA9TZ();
       else if (CollectionUtil.equals(v, _a9TZ) == false)
        {
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask);
          __Nulls.andNot(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask);
          if (_a9TZ == null)
           _a9TZ = new ArrayList<String>();
          else
           _a9TZ.clear();
          for (String i : v)
           {
             _a9TZ.add(i);
          }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA9TZ(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9TZ == null)
        _a9TZ = new ArrayList<String>();
       if (v == null)
        {
          setNullA9TZ();
        }
       else if (_a9TZ.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.a9TZ' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask);
          __Nulls.andNot(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask);
          _a9TZ.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA9TZ(String v) throws Exception
     {
       if (_a9TZ.remove(v) == true)
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask);
     }
    void removeFromA9TZ(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9TZ.remove(pos) != null)
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9TZ -> TILDA.TestingView."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9TZ of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9TZ of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>0</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA9TZ()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask);
       __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask);
       _a9TZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9 -> TILDA.TestingView."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9 of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9 of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   List<ZonedDateTime> _a9;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9 -> TILDA.TestingView."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9 of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9 of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime[] getA9AsArray()
      { return _a9==null? null : _a9.toArray(new ZonedDateTime[_a9.size()]); }
   public final Iterator<ZonedDateTime> getA9()
      { return _a9==null? null : _a9.iterator(); }
   public final boolean hasA9(ZonedDateTime v)
      { return _a9==null? false : _a9.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9 -> TILDA.TestingView."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9 of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9 of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA9()
     { return __Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9 -> TILDA.TestingView."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9 of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9 of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA9(List<ZonedDateTime> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
        throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.a9' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullA9();
       else if (CollectionUtil.equals(v, _a9) == false)
        {
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask);
          __Nulls.andNot(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask);
          if (_a9 == null)
           _a9 = new ArrayList<ZonedDateTime>();
          else
           _a9.clear();
          for (ZonedDateTime i : v)
           {
             _a9.add(i);
          }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA9(int pos, ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9 == null)
        _a9 = new ArrayList<ZonedDateTime>();
       if (v == null)
        {
          setNullA9();
          setNullA9TZ();
        }
       else if (_a9.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.a9' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask);
          __Nulls.andNot(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask);
          _a9.add(pos, v);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.a9' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          addToA9TZ(pos, ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA9(ZonedDateTime v) throws Exception
     {
       if (_a9.remove(v) == true)
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask);
     }
    void removeFromA9(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9.remove(pos) != null)
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9 -> TILDA.TestingView."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9 of type List<ZonedDateTime></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9 of type timestamptz[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA9()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask);
       __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask);
       _a9=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9c -> TILDA.TestingView."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9c of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9c of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   List<LocalDate> _a9c;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9c -> TILDA.TestingView."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9c of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9c of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final LocalDate[] getA9cAsArray()
      { return _a9c==null? null : _a9c.toArray(new LocalDate[_a9c.size()]); }
   public final Iterator<LocalDate> getA9c()
      { return _a9c==null? null : _a9c.iterator(); }
   public final boolean hasA9c(LocalDate v)
      { return _a9c==null? false : _a9c.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9c -> TILDA.TestingView."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9c of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9c of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullA9c()
     { return __Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9c -> TILDA.TestingView."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9c of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9c of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setA9c(List<LocalDate> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
        throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.a9c' that is invariant, or part of a read-only or pre-existing WORM object.");
       if (v == null  || v.isEmpty() == true)
        setNullA9c();
       else if (CollectionUtil.equals(v, _a9c) == false)
        {
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask);
          __Nulls.andNot(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask);
          if (_a9c == null)
           _a9c = new ArrayList<LocalDate>();
          else
           _a9c.clear();
          for (LocalDate i : v)
           {
             _a9c.add(i);
          }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToA9c(int pos, LocalDate v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9c == null)
        _a9c = new ArrayList<LocalDate>();
       if (v == null)
        {
          setNullA9c();
        }
       else if (_a9c.get(pos).equals(v) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.TestingView.a9c' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask);
          __Nulls.andNot(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask);
          _a9c.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromA9c(LocalDate v) throws Exception
     {
       if (_a9c.remove(v) == true)
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask);
     }
    void removeFromA9c(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_a9c.remove(pos) != null)
          __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TestingView.a9c -> TILDA.TestingView."a9c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.TestingView.a9c of type List<LocalDate></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TestingView.a9c of type date[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullA9c()
     {
       long T0 = System.nanoTime();
       if (__Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask) == true) // already NULL
        return;
       __Changes.or(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask);
       __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask);
       _a9c=null;
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
        throw new Exception("This TILDA.TestingView object is being Read() after a Create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.TestingView object has already been read.");
          QueryDetails.setLastQuery(TILDA__TESTINGVIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "TestingView", "name");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "refnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "a2Min");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "a2Max");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "a9TZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "a9");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "TestingView", "a9c");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "TestingView");
       switch (__LookupId)
        {
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TESTINGVIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.TestingView", Q, toString());
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
          return Init(C, RS);
        }
       catch (java.sql.SQLException E)
        {
          return tilda.data._Tilda.TILDA__1_0.HandleCatch(C, E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TESTINGVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }
    }

   @SuppressWarnings("unchecked")
   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                       _name   = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.NAME._Mask  );
                       _refnum =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.REFNUM._Mask);
                       _a2Min  = ParseUtil.parseCharacter    (RS.getString   (++i));  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.A2MIN._Mask );
                       _a2Max  = ParseUtil.parseCharacter    (RS.getString   (++i));  if (RS.wasNull() == true) __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.A2MAX._Mask );
                       _a9TZ = (List<String>) C.getArray(RS, ++i, TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.A9TZ._Mask  );
                       _a9     = ProcessZDTs(C, _a9TZ    , "tilda.data.TILDA.TestingView.a9"    , RS, ++i, TILDA__TESTINGVIEW_Factory.COLS.A9    , TILDA__TESTINGVIEW_Factory.COLS.A9TZ    ); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask    );
                       _a9c = (List<LocalDate>) C.getArray(RS, ++i, TILDA__TESTINGVIEW_Factory.COLS.A9C._Type, false); if (RS.wasNull() == true) __Nulls.or(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask   );
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
  private final List<ZonedDateTime> ProcessZDTs(Connection C, List<String> TimezoneIds, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)
  throws Exception
   {
     List<Timestamp> L = (List<Timestamp>) C.getArray(RS, ColumnPos, DTField._Type, false);
     boolean DTNull = false;
     if (RS.wasNull() == true)
      {
         __Nulls.or(DTField._Mask);
         DTNull = true;
      }
     boolean TZNull = __Nulls.intersects(TZField._Mask);
     if (DTNull == false && TZNull == true)
      throw new Exception("The field "+DTFieldName+" is not null while its associated timezone field '"+DTFieldName+"TZ' is null. A TZ is mandatory for not null timestamps.");
     if (DTNull == true)
      return null;

     List<ZonedDateTime> ZDTs = new ArrayList<ZonedDateTime>();
     for (int i = 0; i < TimezoneIds.size(); ++i)
       {
         String TimezoneId = TimezoneIds.get(i);
         tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(TimezoneId);
         if (ZI == null && TextUtil.isNullOrEmpty(TimezoneId) == false)
          throw new Exception("Cannot set field '"+DTFieldName+"' because the timezone Id '" + TimezoneId + "' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
         ZonedDateTime ZDT = DateTimeUtil.toZonedDateTime(L.get(i), ZI == null ? "null" : ZI.getValue());
         ZDTs.add(ZDT);
       }
     return ZDTs;
   }

   protected abstract boolean AfterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "name: "                                                                                       + TextUtil.PrintVariableStr        (getName  ())
               + "; refnum: "                                                                                     +                                   getRefnum() 
               + "; a2Min"    + (__Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A2MIN._Mask) == true ? ": NULL" : ": " +                                   getA2Min () )
               + "; a2Max"    + (__Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A2MAX._Mask) == true ? ": NULL" : ": " +                                   getA2Max () )
               + "; a9"       + (__Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A9._Mask) == true ? ": NULL" : ": " + TextUtil.Print                   (getA9    ()))
               + "; a9c"      + (__Nulls.intersects(TILDA__TESTINGVIEW_Factory.COLS.A9C._Mask) == true ? ": NULL" : ": " + TextUtil.Print                   (getA9c   ()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }

 }
