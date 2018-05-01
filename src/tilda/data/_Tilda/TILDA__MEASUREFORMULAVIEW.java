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
<DIV id='MEASUREFORMULAVIEW_DIV' class='tables'>
<H2>MEASUREFORMULAVIEW&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 60%;"><A href="#">top</A></SUP></H2>
</DIV>
The generated Java 8/PostgreSQL Tilda data class <B>Data_MEASUREFORMULAVIEW</B> is mapped to the View <B>TILDA.MEASUREFORMULAVIEW</B>.
<UL>

<LI>That View is not OCC-Enabled. No record lifecycle columns (created/updated/deleted) have been generated.</LI>
</UL>
<B>Description</B>: A view of formulas and their dependencies.<BR>
<BR>

<BLOCKQUOTE>That view is filtered: <BLOCKQUOTE><PRE>Formula.deleted is null and Measure.deleted is null</PRE>Active formulas and their sub-formulas</BLOCKQUOTE>
It contains the following columns:<BR>
 <TABLE border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid grey;">
   <TR><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>1&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-measureRefnum')" align="right"><B id='MEASUREFORMULAVIEW-measureRefnum_DIV' class='columns dotted_underline cursor_pointer'>measureRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The measure.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>2&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-measureSchema')" align="right"><B id='MEASUREFORMULAVIEW-measureSchema_DIV' class='columns dotted_underline cursor_pointer'>measureSchema</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The Schema wher ethe measure is defined.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>3&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-measureName')" align="right"><B id='MEASUREFORMULAVIEW-measureName_DIV' class='columns dotted_underline cursor_pointer'>measureName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the measure.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>4&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-formulaRefnum')" align="right"><B id='MEASUREFORMULAVIEW-formulaRefnum_DIV' class='columns dotted_underline cursor_pointer'>formulaRefnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>5&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-formulaLocation')" align="right"><B id='MEASUREFORMULAVIEW-formulaLocation_DIV' class='columns dotted_underline cursor_pointer'>formulaLocation</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the primary table/view this formula is defined in.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>6&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-formulaLocation2')" align="right"><B id='MEASUREFORMULAVIEW-formulaLocation2_DIV' class='columns dotted_underline cursor_pointer'>formulaLocation2</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the secondary table/view (a derived view, a realized table), if appropriate.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>7&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-formulaName')" align="right"><B id='MEASUREFORMULAVIEW-formulaName_DIV' class='columns dotted_underline cursor_pointer'>formulaName</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(64)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The name of the formula/column.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>8&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-title')" align="right"><B id='MEASUREFORMULAVIEW-title_DIV' class='columns dotted_underline cursor_pointer'>title</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(128)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The title of the formula/column.</TD>
</TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>9&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-description')" align="right"><B id='MEASUREFORMULAVIEW-description_DIV' class='columns dotted_underline cursor_pointer'>description</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The description of the formula/column.</TD>
</TR>
  <TR valign="top" bgcolor="#FFFFFF">
    <TD>10&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-type')" align="right"><B id='MEASUREFORMULAVIEW-type_DIV' class='columns dotted_underline cursor_pointer'>type</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(3)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The type of the formula/column value/outcome.</TD>
</TR>
  <TR bgcolor="#FFFFFF"><TD></TD><TD></TD><TD colspan="10" align="center">
<TABLE border="0px" cellpadding="2px" cellspacing="0px" style="border:1px solid #999;">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFF2CC"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>Character</B>&nbsp;&nbsp;</TD><TD>CHR&nbsp;&nbsp;</TD><TD>Character&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Character</TD></TR>
  <TR bgcolor="#FFF2CC"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Boolean</B>&nbsp;&nbsp;</TD><TD>BOL&nbsp;&nbsp;</TD><TD>Boolean&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Boolean</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#FFF2CC"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#FFF2CC"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#FFF2CC"><TD>9&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</TD></TR>
  <TR valign="top" bgcolor="#DFECF8">
    <TD>11&nbsp;&nbsp;</TD>
<TD onclick="onModalShowClicked('MEASUREFORMULAVIEW-formula')" align="right"><B id='MEASUREFORMULAVIEW-formula_DIV' class='columns dotted_underline cursor_pointer'>formula</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;text&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The formula.</TD>
</TR>
</TABLE>
<DIV id='MEASUREFORMULAVIEW-measureRefnum_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-measureRefnum_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-measureRefnum_DIV'>measureRefnum</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#MEASUREFORMULA_DIV'>MeasureFormula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#MEASUREFORMULA-measureRefnum_DIV'>measureRefnum</a></td>
</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#MEASURE_DIV'>Measure</a></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#MEASURE-refnum_DIV'>refnum</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='MEASUREFORMULAVIEW-measureSchema_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-measureSchema_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-measureSchema_DIV'>measureSchema</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#MEASURE_DIV'>Measure</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#MEASURE-schema_DIV'>schema</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='MEASUREFORMULAVIEW-measureName_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-measureName_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-measureName_DIV'>measureName</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#MEASURE_DIV'>Measure</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#MEASURE-name_DIV'>name</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='MEASUREFORMULAVIEW-formulaRefnum_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-formulaRefnum_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-formulaRefnum_DIV'>formulaRefnum</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-refnum_DIV'>refnum</a> -- LONG</td>
</tr>
</table>
</DIV></DIV>
<DIV id='MEASUREFORMULAVIEW-formulaLocation_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-formulaLocation_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-formulaLocation_DIV'>formulaLocation</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-location_DIV'>location</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='MEASUREFORMULAVIEW-formulaLocation2_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-formulaLocation2_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-formulaLocation2_DIV'>formulaLocation2</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-location2_DIV'>location2</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='MEASUREFORMULAVIEW-formulaName_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-formulaName_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-formulaName_DIV'>formulaName</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-name_DIV'>name</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='MEASUREFORMULAVIEW-title_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-title_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-title_DIV'>title</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-title_DIV'>title</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='MEASUREFORMULAVIEW-description_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-description_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-description_DIV'>description</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-description_DIV'>description</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='MEASUREFORMULAVIEW-type_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-type_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-type_DIV'>type</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-type_DIV'>type</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
<DIV id='MEASUREFORMULAVIEW-formula_MODAL' class='modal'>
<DIV class='modal-content'>
<SPAN onclick="onModalCloseClicked('MEASUREFORMULAVIEW-formula_MODAL')" class='close'>&times;</SPAN>
<DIV><CENTER><H2>Column Dependencies</H2></CENTER></DIV>
<table style='margin: auto;'> 
  <tr> 
    <th align='left' width="300em">Schema</th> 
    <th align='left' width="400em">Table/View</th> 
    <th align='left' >Column/Formula</th> 
  </tr> 
<tr bgcolor="#a3c8eb">
<td><a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW_DIV'>MeasureFormulaView</a></td>
<td><a href='TILDA___Docs.TILDA.html#MEASUREFORMULAVIEW-formula_DIV'>formula</a></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr bgcolor="#DFECF8">
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html'>TILDA</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA_DIV'>Formula</a></td>
<td>&#9492;&#9472;<a href='TILDA___Docs.TILDA.html#FORMULA-formula_DIV'>formula</a> -- STRING</td>
</tr>
</table>
</DIV></DIV>
</DIV>

 @author   Tilda code gen for Java 8/PostgreSQL
 @version  Tilda 1.0
 @generated May 1 2018, 10:22:53IST
*/
public abstract class TILDA__MEASUREFORMULAVIEW implements tilda.interfaces.ReaderObject
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__MEASUREFORMULAVIEW.class.getName());

   public static final Class<TILDA__MEASUREFORMULAVIEW_Factory> FACTORY_CLASS= TILDA__MEASUREFORMULAVIEW_Factory.class;
   public static final String TABLENAME = TextUtil.Print("TILDA.MEASUREFORMULAVIEW", "");

   protected TILDA__MEASUREFORMULAVIEW() { }

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.measureRefnum -> TILDA.MEASUREFORMULAVIEW."measureRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.measureRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.measureRefnum of type bigint</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.measureRefnum -> TILDA.MEASUREFORMULAVIEW."measureRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.measureRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.measureRefnum of type bigint</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.measureRefnum -> TILDA.MEASUREFORMULAVIEW."measureRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.measureRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.measureRefnum of type bigint</TD></TR>

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
       if (v != _measureRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.measureRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASUREREFNUM._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASUREREFNUM._Mask1;
       _measureRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.measureSchema -> TILDA.MEASUREFORMULAVIEW."measureSchema"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.measureSchema of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.measureSchema of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.measureSchema -> TILDA.MEASUREFORMULAVIEW."measureSchema"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.measureSchema of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.measureSchema of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.measureSchema -> TILDA.MEASUREFORMULAVIEW."measureSchema"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.measureSchema of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.measureSchema of type varchar(64)</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.measureSchema to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.measureSchema: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_measureSchema) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.measureSchema' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURESCHEMA._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURESCHEMA._Mask1;
       _measureSchema = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.measureName -> TILDA.MEASUREFORMULAVIEW."measureName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.measureName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.measureName of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.measureName -> TILDA.MEASUREFORMULAVIEW."measureName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.measureName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.measureName of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.measureName -> TILDA.MEASUREFORMULAVIEW."measureName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.measureName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.measureName of type varchar(64)</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.measureName to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.measureName: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_measureName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.measureName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURENAME._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURENAME._Mask1;
       _measureName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaRefnum -> TILDA.MEASUREFORMULAVIEW."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaRefnum of type bigint</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaRefnum -> TILDA.MEASUREFORMULAVIEW."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaRefnum of type bigint</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaRefnum -> TILDA.MEASUREFORMULAVIEW."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaRefnum of type bigint</TD></TR>

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
       if (v != _formulaRefnum)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.formulaRefnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULAREFNUM._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULAREFNUM._Mask1;
       _formulaRefnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation -> TILDA.MEASUREFORMULAVIEW."formulaLocation"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaLocation of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation -> TILDA.MEASUREFORMULAVIEW."formulaLocation"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaLocation of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation -> TILDA.MEASUREFORMULAVIEW."formulaLocation"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaLocation of type varchar(64)</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_formulaLocation) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION._Mask1;
       _formulaLocation = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation2 -> TILDA.MEASUREFORMULAVIEW."formulaLocation2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaLocation2 of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation2 -> TILDA.MEASUREFORMULAVIEW."formulaLocation2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaLocation2 of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation2 -> TILDA.MEASUREFORMULAVIEW."formulaLocation2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaLocation2 of type varchar(64)</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation2 to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation2: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_formulaLocation2) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.formulaLocation2' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION2._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION2._Mask1;
       _formulaLocation2 = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaName -> TILDA.MEASUREFORMULAVIEW."formulaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaName of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaName -> TILDA.MEASUREFORMULAVIEW."formulaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaName of type varchar(64)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formulaName -> TILDA.MEASUREFORMULAVIEW."formulaName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formulaName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formulaName of type varchar(64)</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.formulaName to null: it's not nullable.");
       else if (v.length() > 64)
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.formulaName: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 64.");
       else if (v.equals(_formulaName) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.formulaName' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULANAME._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULANAME._Mask1;
       _formulaName = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.title -> TILDA.MEASUREFORMULAVIEW."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.title of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.title of type varchar(128)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.title -> TILDA.MEASUREFORMULAVIEW."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.title of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.title of type varchar(128)</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.title -> TILDA.MEASUREFORMULAVIEW."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.title of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.title of type varchar(128)</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.title to null: it's not nullable.");
       else if (v.length() > 128)
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.title: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 128.");
       else if (v.equals(_title) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.title' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.TITLE._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.TITLE._Mask1;
       _title = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.description -> TILDA.MEASUREFORMULAVIEW."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.description of type text</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.description -> TILDA.MEASUREFORMULAVIEW."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.description of type text</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.description -> TILDA.MEASUREFORMULAVIEW."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.description of type text</TD></TR>

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
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.description to null: it's not nullable.");
       else if (v.length() > 32000)
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.description: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 32000.");
       else if (v.equals(_description) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.description' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.DESCRIPTION._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.DESCRIPTION._Mask1;
       _description = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.type -> TILDA.MEASUREFORMULAVIEW."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.type of type character(3)</TD></TR>

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
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   String _type;
/**
These are the enumerated values for tilda.data.TILDA.MEASUREFORMULAVIEW.type, which can be used to seed UI elements such as drop downs, checkboxe, radio buttons etc...<BR>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>String</B>&nbsp;&nbsp;</TD><TD>STR&nbsp;&nbsp;</TD><TD>String&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>String</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>1&nbsp;&nbsp;</TD><TD align="right"><B>Character</B>&nbsp;&nbsp;</TD><TD>CHR&nbsp;&nbsp;</TD><TD>Character&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Character</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>2&nbsp;&nbsp;</TD><TD align="right"><B>Boolean</B>&nbsp;&nbsp;</TD><TD>BOL&nbsp;&nbsp;</TD><TD>Boolean&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Boolean</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
*/
   public static final String[][] _type_Values = {
                                               { "STR", "String", "String", "" }
                                             , { "CHR", "Character", "Character", "" }
                                             , { "BOL", "Boolean", "Boolean", "" }
                                             , { "INT", "Integer", "Integer", "" }
                                             , { "LNG", "Long", "Long", "" }
                                             , { "FLT", "Float", "Float", "" }
                                             , { "DBL", "Double", "Double", "" }
                                             , { "DT" , "Date", "Date", "" }
                                             , { "DTM", "DateTime", "DateTime", "" }
                                  };
   public static final String _typeString    = "STR";
   public static final String _typeCharacter = "CHR";
   public static final String _typeBoolean   = "BOL";
   public static final String _typeInteger   = "INT";
   public static final String _typeLong      = "LNG";
   public static final String _typeFloat     = "FLT";
   public static final String _typeDouble    = "DBL";
   public static final String _typeDate      = "DT";
   public static final String _typeDateTime  = "DTM";

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.type -> TILDA.MEASUREFORMULAVIEW."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.type of type character(3)</TD></TR>

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
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final String getType()
      { return _type; }

/**
This is the value is-a for tilda.data.TILDA.MEASUREFORMULAVIEW.type:<BR>
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
This is the value is-a for tilda.data.TILDA.MEASUREFORMULAVIEW.type:<BR>
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
This is the value is-a for tilda.data.TILDA.MEASUREFORMULAVIEW.type:<BR>
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
This is the value is-a for tilda.data.TILDA.MEASUREFORMULAVIEW.type:<BR>
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
This is the value is-a for tilda.data.TILDA.MEASUREFORMULAVIEW.type:<BR>
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
This is the value is-a for tilda.data.TILDA.MEASUREFORMULAVIEW.type:<BR>
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
This is the value is-a for tilda.data.TILDA.MEASUREFORMULAVIEW.type:<BR>
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
This is the value is-a for tilda.data.TILDA.MEASUREFORMULAVIEW.type:<BR>
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
This is the value is-a for tilda.data.TILDA.MEASUREFORMULAVIEW.type:<BR>
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.type -> TILDA.MEASUREFORMULAVIEW."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.type of type character(3)</TD></TR>

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
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
    void setType(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.type to null: it's not nullable.");
       else if (v.length() > 3)
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.type: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 3.");
       else if (v.equals(_type) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.type' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.TYPE._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.TYPE._Mask1;
       _type = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formula -> TILDA.MEASUREFORMULAVIEW."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formula of type text</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formula -> TILDA.MEASUREFORMULAVIEW."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formula of type text</TD></TR>

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
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formula -> TILDA.MEASUREFORMULAVIEW."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formula of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullFormula()
     { return (TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask1 & __Nulls1) != 0L; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formula -> TILDA.MEASUREFORMULAVIEW."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formula of type text</TD></TR>

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
          setNullFormula();
        }
       else if (v.length() > 32000)
        throw new Exception("Cannot set tilda.data.TILDA.MEASUREFORMULAVIEW.formula: the value "+TextUtil.EscapeDoubleQuoteWithSlash(v)+" is larger than the max size allowed 32000.");
       else if (v.equals(_formula) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)
           throw new Exception("Cannot set field 'tilda.data.TILDA.MEASUREFORMULAVIEW.formula' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask1;
          __Nulls1   &= ~TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask1;
       _formula = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.MEASUREFORMULAVIEW.formula -> TILDA.MEASUREFORMULAVIEW."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.MEASUREFORMULAVIEW.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.MEASUREFORMULAVIEW.formula of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullFormula()
     {
       long T0 = System.nanoTime();
       if ((TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask1 & __Nulls1) != 0L)
        return;
       __Changes1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask1;
       __Nulls1   |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask1;
       _formula=null;
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
        throw new Exception("This TILDA.MEASUREFORMULAVIEW object is being Read() after a Create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDA.MEASUREFORMULAVIEW object has already been read.");
          QueryDetails.setLastQuery(TILDA__MEASUREFORMULAVIEW_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "measureRefnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "measureSchema");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "measureName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "formulaRefnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "formulaLocation");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "formulaLocation2");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "formulaName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "title");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "description");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "type");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "MEASUREFORMULAVIEW", "formula");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "MEASUREFORMULAVIEW");
       switch (__LookupId)
        {
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__MEASUREFORMULAVIEW_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.MEASUREFORMULAVIEW", Q, toString());
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
          return Init(C, RS);
        }
       catch (java.sql.SQLException E)
        {
          return tilda.data._Tilda.TILDA__1_0.HandleCatch(C, E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__MEASUREFORMULAVIEW_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }
    }

   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
                                 _measureRefnum    =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASUREREFNUM._Mask1   ;
                                 _measureSchema    = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURESCHEMA._Mask1   ;
                                 _measureName      = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.MEASURENAME._Mask1     ;
                                 _formulaRefnum    =                              RS.getLong     (++i) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULAREFNUM._Mask1   ;
                                 _formulaLocation  = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION._Mask1 ;
                                 _formulaLocation2 = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULALOCATION2._Mask1;
                                 _formulaName      = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULANAME._Mask1     ;
                                 _title            = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.TITLE._Mask1           ;
                                 _description      = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.DESCRIPTION._Mask1     ;
                                 _type             = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.TYPE._Mask1            ; else _type             = _type            .trim();
                                 _formula          = TextUtil.Trim               (RS.getString   (++i)) ;  if (RS.wasNull() == true) __Nulls1 |= TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask1         ;
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
                   "measureRefnum: "                                                                                                          +                                   getMeasureRefnum   () 
               + "; measureSchema: "                                                                                                          + TextUtil.PrintVariableStr        (getMeasureSchema   ())
               + "; measureName: "                                                                                                            + TextUtil.PrintVariableStr        (getMeasureName     ())
               + "; formulaRefnum: "                                                                                                          +                                   getFormulaRefnum   () 
               + "; formulaLocation: "                                                                                                        + TextUtil.PrintVariableStr        (getFormulaLocation ())
               + "; formulaLocation2: "                                                                                                       + TextUtil.PrintVariableStr        (getFormulaLocation2())
               + "; formulaName: "                                                                                                            + TextUtil.PrintVariableStr        (getFormulaName     ())
               + "; title: "                                                                                                                  + TextUtil.PrintVariableStr        (getTitle           ())
               + "; description: "                                                                                                            + TextUtil.PrintVariableStr        (getDescription     ())
               + "; type: "                                                                                                                   + TextUtil.PrintVariableStr        (getType            ())
               + "; formula"            + ((TILDA__MEASUREFORMULAVIEW_Factory.COLS.FORMULA._Mask1          & __Nulls1) != 0L ? ": NULL" : ": " + TextUtil.PrintVariableStr        (getFormula         ()))
         + ";";
      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);
      return Str;
    }
 }
