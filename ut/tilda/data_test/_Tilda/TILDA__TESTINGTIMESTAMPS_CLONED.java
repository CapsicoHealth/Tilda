/*
 Tilda V2.5 data object.

 Code is generated: do not modify! Instead, create a derived class and override desired functionality
*/

package tilda.data_test._Tilda;

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
<TABLE id="TestingTimestamps_Cloned_DIV" class="tables">
<SCRIPT>registerStickyHeader("TestingTimestamps_Cloned_DIV");</SCRIPT>
<TR valign="top"><TD><H2>TestingTimestamps_Cloned&nbsp;&nbsp;&nbsp;&nbsp;<SUP style="font-size: 70%;"><SPAN class="BackToDetails"><A href="#TestingTimestamps_Cloned_CNT">details</A>&nbsp;&nbsp;&nbsp;&nbsp;</SPAN><A href="#">top</A></SUP></H2></TD><TD align="right"></TD></TR>
</TABLE>
<DIV id="TestingTimestamps_Cloned_CNT" class="content">
The Table TILDATEST.TestingTimestamps_Cloned :<UL>
<LI>Is mapped to the generated Java 8/PostgreSQL Tilda classes <B>TestingTimestamps_Cloned_Factory</B>, <B>TestingTimestamps_Cloned_Data</B> in the package <B>tilda.data_test</B>.
<LI>Is Cloned from <B><A href="TILDA___Docs.TILDATEST.html#TestingTimestamps_CNT">TILDATEST<B>&nbsp;&#8226;&nbsp;</B>TestingTimestamps</A></B>.</LI>
<LI>Is configured for normal <B>read/write</B> access.</LI>
<LI>Is OCC-enabled. Default created/lastUpdated/deleted columns have been automatically generated.</LI>
<LI>Defines 7 foreign key(s):<BR>
<TABLE style="margin-left: 25px; border:1px solid #BBB;" cellspacing="0px" cellpadding="5px" border="0px">
<TR style="background-color:#DDD; font-weight:bold;"><TD></TD><TD>Source Columns</TD><TD>Destination Object</TD><TD>Destination Columns</TD><TD>Notes</TD></TR>
<TR ><TD>1</TD><TD>dt1TZ</TD><TD><A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A></TD><TD>id</TD><TD>&nbsp;</TD></TR>
</TABLE></LI>
<LI>Has the following identity:<UL><LI>Primary Key: refnum</LI>
</UL></LI>
<LI>Has the following index:<UL><LI>id asc
 <B><I>(Application-side Only)</I></B></LI>
</UL></LI>
</UL>
<B>Description</B>:<BLOCKQUOTE style="border-left: 1px solid #EEE;padding-left: 5px;">blah blah - Ready for publishing (cloned from TILDATEST.TestingTimestamps)</BLOCKQUOTE>
<BR>
This Table contains the following columns:<BLOCKQUOTE>
 <TABLE id="TestingTimestamps_Cloned_TBL" border="0px" cellpadding="3px" cellspacing="0px" style="border:1px solid #BBB;">
   <TR valign="bottom"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH align="left">Type</TH><TH align="left">Nullable</TH><TH align="left">Mode</TH><TH align="left">Invariant</TH><TH align="left">Protect</TH><TH align="left">Description</TH></TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>1&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-refnum_DIV' class='columns'>refnum</B>&nbsp;&nbsp;</TD>
<TD>long&nbsp;/&nbsp;bigint&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The primary key for this record</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>2&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-id_DIV' class='columns'>id</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;varchar(20)&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Medical system unique enterprise id</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>3&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt1TZ_DIV' class='columns'>dt1TZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dt1'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>4&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt1_DIV' class='columns'>dt1</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>5&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt1nTZ_DIV' class='columns'>dt1nTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dt1n'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>6&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt1n_DIV' class='columns'>dt1n</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>7&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt1uTZ_DIV' class='columns'>dt1uTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dt1u'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>8&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt1u_DIV' class='columns'>dt1u</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>9&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt1aTZ_DIV' class='columns'>dt1aTZ</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dt1a'.</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>10&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt1a_DIV' class='columns'>dt1a</B>&nbsp;&nbsp;</TD>
<TD>List<ZonedDateTime> List<>&nbsp;/&nbsp;timestamptz[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>11&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-rowTZ_DIV' class='columns'>rowTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps_Cloned row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>12&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt2_DIV' class='columns'>dt2</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>13&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt2n_DIV' class='columns'>dt2n</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>14&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt2u_DIV' class='columns'>dt2u</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>15&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt2a_DIV' class='columns'>dt2a</B>&nbsp;&nbsp;</TD>
<TD>List<ZonedDateTime> List<>&nbsp;/&nbsp;timestamptz[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>16&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt3TZ_DIV' class='columns'>dt3TZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dt3'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>17&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt3_DIV' class='columns'>dt3</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamp&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>18&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt3nTZ_DIV' class='columns'>dt3nTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dt3n'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>19&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt3n_DIV' class='columns'>dt3n</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamp&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>20&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt3uTZ_DIV' class='columns'>dt3uTZ</B>&nbsp;&nbsp;</TD>
<TD>String&nbsp;/&nbsp;character(5)&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dt3u'.<TABLE border="0px" style="margin:0px;margin-left:20px;font-size:75%;"><TR><TD><B style="color:white;background-color:fuchsia;">FK</B></TD><TD>&rarr;&nbsp;<A href="TILDA___Docs.TILDA.html#ZoneInfo_CNT">TILDA<B>&nbsp;&#8226;&nbsp;</B>ZoneInfo</A>: id</TD></TR>
</TABLE>
</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>21&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt3u_DIV' class='columns'>dt3u</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamp&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>22&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt3aTZ_DIV' class='columns'>dt3aTZ</B>&nbsp;&nbsp;</TD>
<TD>List<String> List<>&nbsp;/&nbsp;text[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>Generated helper column to hold the time zone ID for 'dt3a'.</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>23&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt3a_DIV' class='columns'>dt3a</B>&nbsp;&nbsp;</TD>
<TD>List<ZonedDateTime> List<>&nbsp;/&nbsp;timestamp[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>24&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt4_DIV' class='columns'>dt4</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamp&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>25&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt4n_DIV' class='columns'>dt4n</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamp&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>26&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt4u_DIV' class='columns'>dt4u</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamp&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>27&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-dt4a_DIV' class='columns'>dt4a</B>&nbsp;&nbsp;</TD>
<TD>List<ZonedDateTime> List<>&nbsp;/&nbsp;timestamp[]&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">-&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The blah</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>28&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-created_DIV' class='columns'>created</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was created. (TILDATEST.TestingTimestamps_Cloned)</TD>
</TR>
  <TR valign="top" style="background-color:rgba(160, 199, 234, 0.2);">
    <TD>29&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-lastUpdated_DIV' class='columns'>lastUpdated</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps_Cloned)</TD>
</TR>
  <TR valign="top" style="background-color:#FFFFFF;">
    <TD>30&nbsp;&nbsp;</TD>
<TD align="right"><B id='TestingTimestamps_Cloned-deleted_DIV' class='columns'>deleted</B>&nbsp;&nbsp;</TD>
<TD>ZonedDateTime&nbsp;/&nbsp;timestamptz&nbsp;&nbsp;</TD>
<TD align="center">&#x2611;&nbsp;&nbsp;</TD>
<TD align="left">AUTO&nbsp;&nbsp;</TD>
<TD align="center">&#x2610&nbsp;&nbsp;</TD>
<TD align="center">-&nbsp;&nbsp;</TD>
<TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)</TD>
</TR>
</TABLE></BLOCKQUOTE>
</DIV>

*/
@SuppressWarnings({ "unused" })
public abstract class TILDA__TESTINGTIMESTAMPS_CLONED implements tilda.interfaces.WriterObject, tilda.interfaces.OCCObject, tilda.interfaces.JSONable, tilda.interfaces.CSVable
 {
   protected transient static final Logger LOG = LogManager.getLogger(TILDA__TESTINGTIMESTAMPS_CLONED.class.getName());

   public transient static final Class<TILDA__TESTINGTIMESTAMPS_CLONED_Factory> FACTORY_CLASS= TILDA__TESTINGTIMESTAMPS_CLONED_Factory.class;
   public transient static final String TABLENAME = TextUtil.print("TILDATEST.TestingTimestamps_Cloned", "");

   protected TILDA__TESTINGTIMESTAMPS_CLONED() { }

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.refnum -> TILDATEST.TestingTimestamps_Cloned."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.refnum</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.refnum -> TILDATEST.TestingTimestamps_Cloned."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.refnum</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.refnum -> TILDATEST.TestingTimestamps_Cloned."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.refnum</TD></TR>

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
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.refnum' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.REFNUM._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.REFNUM._Mask);
       _refnum = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id -> TILDATEST.TestingTimestamps_Cloned."id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>id of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.id of type varchar(20)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>20</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("id")
   String _id=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id -> TILDATEST.TestingTimestamps_Cloned."id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>id of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.id of type varchar(20)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>20</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getId()
      { return _id; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id -> TILDATEST.TestingTimestamps_Cloned."id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>id of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.id of type varchar(20)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>20</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setId(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id to null or an empty value: it's not nullable and empty values are not allowed.");
       else if (v.length() > 20)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id: the size "+v.length()+" is larger than the max allowed of 20: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_id) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID._Mask);
       _id = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id -> TILDATEST.TestingTimestamps_Cloned."id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>id of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.id of type varchar(20)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>20</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedId()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ -> TILDATEST.TestingTimestamps_Cloned."dt1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _dt1TZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ -> TILDATEST.TestingTimestamps_Cloned."dt1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDt1TZ()
      { return _dt1TZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ -> TILDATEST.TestingTimestamps_Cloned."dt1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt1TZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ -> TILDATEST.TestingTimestamps_Cloned."dt1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt1TZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt1TZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dt1TZ) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask);
       _dt1TZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ -> TILDATEST.TestingTimestamps_Cloned."dt1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt1TZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask);
       _dt1TZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ -> TILDATEST.TestingTimestamps_Cloned."dt1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt1TZ()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1 -> TILDATEST.TestingTimestamps_Cloned."dt1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt1")
   String  Str_dt1;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt1(String v) { Str_dt1 = v; }
   public String initDt1Val() { return Str_dt1; }
   transient ZonedDateTime _dt1 = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1 -> TILDATEST.TestingTimestamps_Cloned."dt1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDt1()
      { return _dt1; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1 -> TILDATEST.TestingTimestamps_Cloned."dt1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt1()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1 -> TILDATEST.TestingTimestamps_Cloned."dt1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDt1(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt1();
        }
       else if (v.equals(_dt1) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask);
       _dt1 = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt1TZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1 -> TILDATEST.TestingTimestamps_Cloned."dt1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullDt1()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask);
       _dt1=null;
       setNullDt1TZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1 -> TILDATEST.TestingTimestamps_Cloned."dt1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt1Now() throws Exception
    {
      setDt1(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1 -> TILDATEST.TestingTimestamps_Cloned."dt1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt1Undefined() throws Exception
    {
      setDt1(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1 -> TILDATEST.TestingTimestamps_Cloned."dt1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt1(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt1(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1 -> TILDATEST.TestingTimestamps_Cloned."dt1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt1()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ -> TILDATEST.TestingTimestamps_Cloned."dt1nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _dt1nTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ -> TILDATEST.TestingTimestamps_Cloned."dt1nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDt1nTZ()
      { return _dt1nTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ -> TILDATEST.TestingTimestamps_Cloned."dt1nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt1nTZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ -> TILDATEST.TestingTimestamps_Cloned."dt1nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt1nTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt1nTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dt1nTZ) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask);
       _dt1nTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ -> TILDATEST.TestingTimestamps_Cloned."dt1nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt1nTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask);
       _dt1nTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ -> TILDATEST.TestingTimestamps_Cloned."dt1nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt1nTZ()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n -> TILDATEST.TestingTimestamps_Cloned."dt1n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt1n")
   String  Str_dt1n;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt1n(String v) { Str_dt1n = v; }
   public String initDt1nVal() { return Str_dt1n; }
   transient ZonedDateTime _dt1n = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n -> TILDATEST.TestingTimestamps_Cloned."dt1n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt1n()
      { return _dt1n; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n -> TILDATEST.TestingTimestamps_Cloned."dt1n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt1n()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n -> TILDATEST.TestingTimestamps_Cloned."dt1n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDt1n(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt1n();
        }
       else if (v.equals(_dt1n) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask);
       _dt1n = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt1nTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n -> TILDATEST.TestingTimestamps_Cloned."dt1n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setNullDt1n()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask);
       _dt1n=null;
       setNullDt1nTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n -> TILDATEST.TestingTimestamps_Cloned."dt1n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt1nNow() throws Exception
    {
      setDt1n(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n -> TILDATEST.TestingTimestamps_Cloned."dt1n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt1nUndefined() throws Exception
    {
      setDt1n(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n -> TILDATEST.TestingTimestamps_Cloned."dt1n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt1n(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt1n(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n -> TILDATEST.TestingTimestamps_Cloned."dt1n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedDt1n()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ -> TILDATEST.TestingTimestamps_Cloned."dt1uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _dt1uTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ -> TILDATEST.TestingTimestamps_Cloned."dt1uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDt1uTZ()
      { return _dt1uTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ -> TILDATEST.TestingTimestamps_Cloned."dt1uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt1uTZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ -> TILDATEST.TestingTimestamps_Cloned."dt1uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt1uTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt1uTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dt1uTZ) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask);
       _dt1uTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ -> TILDATEST.TestingTimestamps_Cloned."dt1uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt1uTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask);
       _dt1uTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ -> TILDATEST.TestingTimestamps_Cloned."dt1uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt1uTZ()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u -> TILDATEST.TestingTimestamps_Cloned."dt1u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt1u")
   String  Str_dt1u;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt1u(String v) { Str_dt1u = v; }
   public String initDt1uVal() { return Str_dt1u; }
   transient ZonedDateTime _dt1u = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u -> TILDATEST.TestingTimestamps_Cloned."dt1u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt1u()
      { return _dt1u; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u -> TILDATEST.TestingTimestamps_Cloned."dt1u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt1u()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u -> TILDATEST.TestingTimestamps_Cloned."dt1u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDt1u(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt1u();
        }
       else if (v.equals(_dt1u) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask);
       _dt1u = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt1uTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u -> TILDATEST.TestingTimestamps_Cloned."dt1u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setNullDt1u()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask);
       _dt1u=null;
       setNullDt1uTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u -> TILDATEST.TestingTimestamps_Cloned."dt1u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt1uNow() throws Exception
    {
      setDt1u(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u -> TILDATEST.TestingTimestamps_Cloned."dt1u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt1uUndefined() throws Exception
    {
      setDt1u(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u -> TILDATEST.TestingTimestamps_Cloned."dt1u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt1u(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt1u(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u -> TILDATEST.TestingTimestamps_Cloned."dt1u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt1u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt1u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedDt1u()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ -> TILDATEST.TestingTimestamps_Cloned."dt1aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   List<String> _dt1aTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ -> TILDATEST.TestingTimestamps_Cloned."dt1aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getDt1aTZAsArray()
      { return _dt1aTZ==null? null : _dt1aTZ.toArray(new String[_dt1aTZ.size()]); }
   public final Iterator<String> getDt1aTZ()
      { return _dt1aTZ==null? null : _dt1aTZ.iterator(); }
   public final boolean hasDt1aTZ(String v)
      { return _dt1aTZ==null? false : _dt1aTZ.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ -> TILDATEST.TestingTimestamps_Cloned."dt1aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt1aTZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ -> TILDATEST.TestingTimestamps_Cloned."dt1aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt1aTZ(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setNullDt1aTZ();
       else if (CollectionUtil.equals(v, _dt1aTZ) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask);
          if (_dt1aTZ == null)
           {
             _dt1aTZ = new ArrayList<String>();
           }
          else
           {
             _dt1aTZ.clear();
           }
          for (String i : v)
           {
             _dt1aTZ.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToDt1aTZ(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt1aTZ == null)
        _dt1aTZ = new ArrayList<String>();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt1aTZ();
        }
       else if (pos >= _dt1aTZ.size() || _dt1aTZ.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask);
          _dt1aTZ.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt1aTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt1aTZ.remove(v) == true)
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt1aTZ(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt1aTZ.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ -> TILDATEST.TestingTimestamps_Cloned."dt1aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt1aTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask);
       _dt1aTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ -> TILDATEST.TestingTimestamps_Cloned."dt1aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt1aTZ()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a -> TILDATEST.TestingTimestamps_Cloned."dt1a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt1a")
   List<String>  Str_dt1a;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt1a(List<String> v) { Str_dt1a = v; }
   public List<String> initDt1aVal() { return Str_dt1a; }
   transient List<ZonedDateTime> _dt1a = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a -> TILDATEST.TestingTimestamps_Cloned."dt1a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime[] getDt1aAsArray()
      { return _dt1a==null? null : _dt1a.toArray(new ZonedDateTime[_dt1a.size()]); }
   public final Iterator<ZonedDateTime> getDt1a()
      { return _dt1a==null? null : _dt1a.iterator(); }
   public final boolean hasDt1a(ZonedDateTime v)
      { return _dt1a==null? false : _dt1a.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a -> TILDATEST.TestingTimestamps_Cloned."dt1a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt1a()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a -> TILDATEST.TestingTimestamps_Cloned."dt1a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDt1a(List<ZonedDateTime> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setNullDt1a();
       else if (CollectionUtil.equals(v, _dt1a) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask);
          if (_dt1a == null)
           {
             _dt1a = new ArrayList<ZonedDateTime>();
             _dt1aTZ = new ArrayList<String>();
           }
          else
           {
             _dt1a.clear();
             _dt1aTZ.clear();
           }
          for (int k = 0; k < v.size(); ++k)
           {
             ZonedDateTime i = v.get(k);
             _dt1a.add(i);
             tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(i.getZone().getId());
             if (ZI == null)
              throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a' because the timezone value '"+i.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
             addToDt1aTZ(k, ZI.getId());
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToDt1a(int pos, ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt1a == null)
        _dt1a = new ArrayList<ZonedDateTime>();
       if (v == null)
        {
          setNullDt1a();
        }
       else if (pos >= _dt1a.size() || _dt1a.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask);
          _dt1a.add(pos, v);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          addToDt1aTZ(pos, ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromDt1a(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       int i = _dt1a.indexOf(v);
       if (1 != -1)
        {
          _dt1a.remove(i);
          removeFromDt1aTZ(i);
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromDt1a(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt1a.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask);
          removeFromDt1aTZ(pos);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a -> TILDATEST.TestingTimestamps_Cloned."dt1a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullDt1a()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask);
       _dt1a=null;
       setNullDt1aTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a -> TILDATEST.TestingTimestamps_Cloned."dt1a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt1a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt1a()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ -> TILDATEST.TestingTimestamps_Cloned."rowTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps_Cloned row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.rowTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _rowTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ -> TILDATEST.TestingTimestamps_Cloned."rowTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps_Cloned row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.rowTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getRowTZ()
      { return _rowTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ -> TILDATEST.TestingTimestamps_Cloned."rowTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps_Cloned row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.rowTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullRowTZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ -> TILDATEST.TestingTimestamps_Cloned."rowTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps_Cloned row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.rowTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setRowTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullRowTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_rowTZ) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask);
       _rowTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ -> TILDATEST.TestingTimestamps_Cloned."rowTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps_Cloned row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.rowTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullRowTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask);
       _rowTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ -> TILDATEST.TestingTimestamps_Cloned."rowTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps_Cloned row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.rowTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.rowTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedRowTZ()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2 -> TILDATEST.TestingTimestamps_Cloned."dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt2")
   String  Str_dt2;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt2(String v) { Str_dt2 = v; }
   public String initDt2Val() { return Str_dt2; }
   transient ZonedDateTime _dt2 = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2 -> TILDATEST.TestingTimestamps_Cloned."dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDt2()
      { return _dt2; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2 -> TILDATEST.TestingTimestamps_Cloned."dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt2()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2 -> TILDATEST.TestingTimestamps_Cloned."dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDt2(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt2();
        }
       else if (v.equals(_dt2) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask);
       _dt2 = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2 -> TILDATEST.TestingTimestamps_Cloned."dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullDt2()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask);
       _dt2=null;
    // setNullRowTZ(); // row TZs are shared, so can't just null it!
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2 -> TILDATEST.TestingTimestamps_Cloned."dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt2Now() throws Exception
    {
      setDt2(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2 -> TILDATEST.TestingTimestamps_Cloned."dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt2Undefined() throws Exception
    {
      setDt2(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2 -> TILDATEST.TestingTimestamps_Cloned."dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt2(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt2(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2 -> TILDATEST.TestingTimestamps_Cloned."dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt2()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n -> TILDATEST.TestingTimestamps_Cloned."dt2n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt2n")
   String  Str_dt2n;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt2n(String v) { Str_dt2n = v; }
   public String initDt2nVal() { return Str_dt2n; }
   transient ZonedDateTime _dt2n = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n -> TILDATEST.TestingTimestamps_Cloned."dt2n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt2n()
      { return _dt2n; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n -> TILDATEST.TestingTimestamps_Cloned."dt2n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt2n()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n -> TILDATEST.TestingTimestamps_Cloned."dt2n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDt2n(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt2n();
        }
       else if (v.equals(_dt2n) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask);
       _dt2n = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n -> TILDATEST.TestingTimestamps_Cloned."dt2n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setNullDt2n()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask);
       _dt2n=null;
    // setNullRowTZ(); // row TZs are shared, so can't just null it!
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n -> TILDATEST.TestingTimestamps_Cloned."dt2n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt2nNow() throws Exception
    {
      setDt2n(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n -> TILDATEST.TestingTimestamps_Cloned."dt2n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt2nUndefined() throws Exception
    {
      setDt2n(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n -> TILDATEST.TestingTimestamps_Cloned."dt2n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt2n(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt2n(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n -> TILDATEST.TestingTimestamps_Cloned."dt2n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedDt2n()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u -> TILDATEST.TestingTimestamps_Cloned."dt2u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt2u")
   String  Str_dt2u;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt2u(String v) { Str_dt2u = v; }
   public String initDt2uVal() { return Str_dt2u; }
   transient ZonedDateTime _dt2u = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u -> TILDATEST.TestingTimestamps_Cloned."dt2u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt2u()
      { return _dt2u; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u -> TILDATEST.TestingTimestamps_Cloned."dt2u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt2u()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u -> TILDATEST.TestingTimestamps_Cloned."dt2u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDt2u(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt2u();
        }
       else if (v.equals(_dt2u) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask);
       _dt2u = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u -> TILDATEST.TestingTimestamps_Cloned."dt2u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setNullDt2u()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask);
       _dt2u=null;
    // setNullRowTZ(); // row TZs are shared, so can't just null it!
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u -> TILDATEST.TestingTimestamps_Cloned."dt2u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt2uNow() throws Exception
    {
      setDt2u(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u -> TILDATEST.TestingTimestamps_Cloned."dt2u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt2uUndefined() throws Exception
    {
      setDt2u(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u -> TILDATEST.TestingTimestamps_Cloned."dt2u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt2u(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt2u(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u -> TILDATEST.TestingTimestamps_Cloned."dt2u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt2u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt2u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedDt2u()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a -> TILDATEST.TestingTimestamps_Cloned."dt2a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt2a")
   List<String>  Str_dt2a;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt2a(List<String> v) { Str_dt2a = v; }
   public List<String> initDt2aVal() { return Str_dt2a; }
   transient List<ZonedDateTime> _dt2a = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a -> TILDATEST.TestingTimestamps_Cloned."dt2a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime[] getDt2aAsArray()
      { return _dt2a==null? null : _dt2a.toArray(new ZonedDateTime[_dt2a.size()]); }
   public final Iterator<ZonedDateTime> getDt2a()
      { return _dt2a==null? null : _dt2a.iterator(); }
   public final boolean hasDt2a(ZonedDateTime v)
      { return _dt2a==null? false : _dt2a.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a -> TILDATEST.TestingTimestamps_Cloned."dt2a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt2a()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a -> TILDATEST.TestingTimestamps_Cloned."dt2a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDt2a(List<ZonedDateTime> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setNullDt2a();
       else if (CollectionUtil.equals(v, _dt2a) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask);
          if (_dt2a == null)
           {
             _dt2a = new ArrayList<ZonedDateTime>();
           }
          else
           {
             _dt2a.clear();
           }
          tilda.data.ZoneInfo_Data ZIPrev = null;
          for (int k = 0; k < v.size(); ++k)
           {
             ZonedDateTime i = v.get(k);
             _dt2a.add(i);
             tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(i.getZone().getId());
             if (ZI == null)
              throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a' because the timezone value '"+i.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
             if (ZIPrev == null)
              ZIPrev = ZI;
             else if (ZIPrev.getId().equals(ZI.getId()) == false)
              throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a' because the timezone value '"+i.getZone().getId()+"' is inconsistent with previous value '"+ZIPrev.getId()+"' and the tzMode is row-based. Timestamps covered by a row-based timezone must all be set within the same exact timezone.");
           }
        setRowTZ(ZIPrev.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToDt2a(int pos, ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt2a == null)
        _dt2a = new ArrayList<ZonedDateTime>();
       if (v == null)
        {
          setNullDt2a();
        }
       else if (pos >= _dt2a.size() || _dt2a.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask);
          _dt2a.add(pos, v);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromDt2a(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       int i = _dt2a.indexOf(v);
       if (1 != -1)
        {
          _dt2a.remove(i);
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromDt2a(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt2a.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a -> TILDATEST.TestingTimestamps_Cloned."dt2a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullDt2a()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask);
       _dt2a=null;
    // setNullRowTZ(); // row TZs are shared, so can't just null it!
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a -> TILDATEST.TestingTimestamps_Cloned."dt2a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt2a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt2a()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ -> TILDATEST.TestingTimestamps_Cloned."dt3TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _dt3TZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ -> TILDATEST.TestingTimestamps_Cloned."dt3TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDt3TZ()
      { return _dt3TZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ -> TILDATEST.TestingTimestamps_Cloned."dt3TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt3TZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ -> TILDATEST.TestingTimestamps_Cloned."dt3TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt3TZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt3TZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dt3TZ) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask);
       _dt3TZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ -> TILDATEST.TestingTimestamps_Cloned."dt3TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt3TZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask);
       _dt3TZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ -> TILDATEST.TestingTimestamps_Cloned."dt3TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt3TZ()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3 -> TILDATEST.TestingTimestamps_Cloned."dt3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt3")
   String  Str_dt3;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt3(String v) { Str_dt3 = v; }
   public String initDt3Val() { return Str_dt3; }
   transient ZonedDateTime _dt3 = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3 -> TILDATEST.TestingTimestamps_Cloned."dt3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDt3()
      { return _dt3; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3 -> TILDATEST.TestingTimestamps_Cloned."dt3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt3()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3 -> TILDATEST.TestingTimestamps_Cloned."dt3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDt3(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt3();
        }
       else if (v.equals(_dt3) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask);
       _dt3 = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt3TZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3 -> TILDATEST.TestingTimestamps_Cloned."dt3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullDt3()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask);
       _dt3=null;
       setNullDt3TZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3 -> TILDATEST.TestingTimestamps_Cloned."dt3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt3Now() throws Exception
    {
      setDt3(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3 -> TILDATEST.TestingTimestamps_Cloned."dt3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt3Undefined() throws Exception
    {
      setDt3(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3 -> TILDATEST.TestingTimestamps_Cloned."dt3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt3(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt3(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3 -> TILDATEST.TestingTimestamps_Cloned."dt3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt3()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ -> TILDATEST.TestingTimestamps_Cloned."dt3nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _dt3nTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ -> TILDATEST.TestingTimestamps_Cloned."dt3nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDt3nTZ()
      { return _dt3nTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ -> TILDATEST.TestingTimestamps_Cloned."dt3nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt3nTZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ -> TILDATEST.TestingTimestamps_Cloned."dt3nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt3nTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt3nTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dt3nTZ) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask);
       _dt3nTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ -> TILDATEST.TestingTimestamps_Cloned."dt3nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt3nTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask);
       _dt3nTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ -> TILDATEST.TestingTimestamps_Cloned."dt3nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt3nTZ()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n -> TILDATEST.TestingTimestamps_Cloned."dt3n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt3n")
   String  Str_dt3n;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt3n(String v) { Str_dt3n = v; }
   public String initDt3nVal() { return Str_dt3n; }
   transient ZonedDateTime _dt3n = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n -> TILDATEST.TestingTimestamps_Cloned."dt3n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt3n()
      { return _dt3n; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n -> TILDATEST.TestingTimestamps_Cloned."dt3n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt3n()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n -> TILDATEST.TestingTimestamps_Cloned."dt3n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDt3n(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt3n();
        }
       else if (v.equals(_dt3n) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask);
       _dt3n = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt3nTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n -> TILDATEST.TestingTimestamps_Cloned."dt3n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setNullDt3n()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask);
       _dt3n=null;
       setNullDt3nTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n -> TILDATEST.TestingTimestamps_Cloned."dt3n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt3nNow() throws Exception
    {
      setDt3n(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n -> TILDATEST.TestingTimestamps_Cloned."dt3n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt3nUndefined() throws Exception
    {
      setDt3n(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n -> TILDATEST.TestingTimestamps_Cloned."dt3n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt3n(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt3n(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n -> TILDATEST.TestingTimestamps_Cloned."dt3n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedDt3n()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ -> TILDATEST.TestingTimestamps_Cloned."dt3uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   String _dt3uTZ=null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ -> TILDATEST.TestingTimestamps_Cloned."dt3uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String getDt3uTZ()
      { return _dt3uTZ; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ -> TILDATEST.TestingTimestamps_Cloned."dt3uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt3uTZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ -> TILDATEST.TestingTimestamps_Cloned."dt3uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt3uTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt3uTZ();
        }
       else if (v.length() > 5)
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ: the size "+v.length()+" is larger than the max allowed of 5: "+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));
       else if (v.equals(_dt3uTZ) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask);
       _dt3uTZ = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ -> TILDATEST.TestingTimestamps_Cloned."dt3uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt3uTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask);
       _dt3uTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ -> TILDATEST.TestingTimestamps_Cloned."dt3uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt3uTZ()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u -> TILDATEST.TestingTimestamps_Cloned."dt3u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt3u")
   String  Str_dt3u;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt3u(String v) { Str_dt3u = v; }
   public String initDt3uVal() { return Str_dt3u; }
   transient ZonedDateTime _dt3u = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u -> TILDATEST.TestingTimestamps_Cloned."dt3u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt3u()
      { return _dt3u; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u -> TILDATEST.TestingTimestamps_Cloned."dt3u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt3u()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u -> TILDATEST.TestingTimestamps_Cloned."dt3u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDt3u(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt3u();
        }
       else if (v.equals(_dt3u) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask);
       _dt3u = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt3uTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u -> TILDATEST.TestingTimestamps_Cloned."dt3u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setNullDt3u()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask);
       _dt3u=null;
       setNullDt3uTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u -> TILDATEST.TestingTimestamps_Cloned."dt3u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt3uNow() throws Exception
    {
      setDt3u(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u -> TILDATEST.TestingTimestamps_Cloned."dt3u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt3uUndefined() throws Exception
    {
      setDt3u(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u -> TILDATEST.TestingTimestamps_Cloned."dt3u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt3u(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt3u(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u -> TILDATEST.TestingTimestamps_Cloned."dt3u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt3u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt3u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedDt3u()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ -> TILDATEST.TestingTimestamps_Cloned."dt3aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   List<String> _dt3aTZ;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ -> TILDATEST.TestingTimestamps_Cloned."dt3aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final String[] getDt3aTZAsArray()
      { return _dt3aTZ==null? null : _dt3aTZ.toArray(new String[_dt3aTZ.size()]); }
   public final Iterator<String> getDt3aTZ()
      { return _dt3aTZ==null? null : _dt3aTZ.iterator(); }
   public final boolean hasDt3aTZ(String v)
      { return _dt3aTZ==null? false : _dt3aTZ.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ -> TILDATEST.TestingTimestamps_Cloned."dt3aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt3aTZ()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ -> TILDATEST.TestingTimestamps_Cloned."dt3aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setDt3aTZ(List<String> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setNullDt3aTZ();
       else if (CollectionUtil.equals(v, _dt3aTZ) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask);
          if (_dt3aTZ == null)
           {
             _dt3aTZ = new ArrayList<String>();
           }
          else
           {
             _dt3aTZ.clear();
           }
          for (String i : v)
           {
             _dt3aTZ.add(i);
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void addToDt3aTZ(int pos, String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt3aTZ == null)
        _dt3aTZ = new ArrayList<String>();
       if (TextUtil.isNullOrEmpty(v) == true)
        {
          setNullDt3aTZ();
        }
       else if (pos >= _dt3aTZ.size() || _dt3aTZ.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask);
          _dt3aTZ.add(pos, v);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt3aTZ(String v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt3aTZ.remove(v) == true)
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask);
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
    void removeFromDt3aTZ(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt3aTZ.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ -> TILDATEST.TestingTimestamps_Cloned."dt3aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
    void setNullDt3aTZ()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask);
       _dt3aTZ=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ -> TILDATEST.TestingTimestamps_Cloned."dt3aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt3aTZ()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a -> TILDATEST.TestingTimestamps_Cloned."dt3a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt3a")
   List<String>  Str_dt3a;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt3a(List<String> v) { Str_dt3a = v; }
   public List<String> initDt3aVal() { return Str_dt3a; }
   transient List<ZonedDateTime> _dt3a = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a -> TILDATEST.TestingTimestamps_Cloned."dt3a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime[] getDt3aAsArray()
      { return _dt3a==null? null : _dt3a.toArray(new ZonedDateTime[_dt3a.size()]); }
   public final Iterator<ZonedDateTime> getDt3a()
      { return _dt3a==null? null : _dt3a.iterator(); }
   public final boolean hasDt3a(ZonedDateTime v)
      { return _dt3a==null? false : _dt3a.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a -> TILDATEST.TestingTimestamps_Cloned."dt3a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt3a()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a -> TILDATEST.TestingTimestamps_Cloned."dt3a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDt3a(List<ZonedDateTime> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setNullDt3a();
       else if (CollectionUtil.equals(v, _dt3a) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask);
          if (_dt3a == null)
           {
             _dt3a = new ArrayList<ZonedDateTime>();
             _dt3aTZ = new ArrayList<String>();
           }
          else
           {
             _dt3a.clear();
             _dt3aTZ.clear();
           }
          for (int k = 0; k < v.size(); ++k)
           {
             ZonedDateTime i = v.get(k);
             _dt3a.add(i);
             tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(i.getZone().getId());
             if (ZI == null)
              throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a' because the timezone value '"+i.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
             addToDt3aTZ(k, ZI.getId());
           }
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToDt3a(int pos, ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt3a == null)
        _dt3a = new ArrayList<ZonedDateTime>();
       if (v == null)
        {
          setNullDt3a();
        }
       else if (pos >= _dt3a.size() || _dt3a.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask);
          _dt3a.add(pos, v);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          addToDt3aTZ(pos, ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromDt3a(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       int i = _dt3a.indexOf(v);
       if (1 != -1)
        {
          _dt3a.remove(i);
          removeFromDt3aTZ(i);
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromDt3a(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt3a.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask);
          removeFromDt3aTZ(pos);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a -> TILDATEST.TestingTimestamps_Cloned."dt3a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullDt3a()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask);
       _dt3a=null;
       setNullDt3aTZ();
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a -> TILDATEST.TestingTimestamps_Cloned."dt3a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt3a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt3a()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4 -> TILDATEST.TestingTimestamps_Cloned."dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt4")
   String  Str_dt4;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt4(String v) { Str_dt4 = v; }
   public String initDt4Val() { return Str_dt4; }
   transient ZonedDateTime _dt4 = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4 -> TILDATEST.TestingTimestamps_Cloned."dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime getDt4()
      { return _dt4; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4 -> TILDATEST.TestingTimestamps_Cloned."dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt4()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4 -> TILDATEST.TestingTimestamps_Cloned."dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDt4(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt4();
        }
       else if (v.equals(_dt4) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask);
       _dt4 = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4 -> TILDATEST.TestingTimestamps_Cloned."dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullDt4()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask);
       _dt4=null;
    // setNullRowTZ(); // row TZs are shared, so can't just null it!
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4 -> TILDATEST.TestingTimestamps_Cloned."dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt4Now() throws Exception
    {
      setDt4(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4 -> TILDATEST.TestingTimestamps_Cloned."dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt4Undefined() throws Exception
    {
      setDt4(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4 -> TILDATEST.TestingTimestamps_Cloned."dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setDt4(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt4(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4 -> TILDATEST.TestingTimestamps_Cloned."dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt4()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n -> TILDATEST.TestingTimestamps_Cloned."dt4n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt4n")
   String  Str_dt4n;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt4n(String v) { Str_dt4n = v; }
   public String initDt4nVal() { return Str_dt4n; }
   transient ZonedDateTime _dt4n = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n -> TILDATEST.TestingTimestamps_Cloned."dt4n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt4n()
      { return _dt4n; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n -> TILDATEST.TestingTimestamps_Cloned."dt4n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt4n()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n -> TILDATEST.TestingTimestamps_Cloned."dt4n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDt4n(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt4n();
        }
       else if (v.equals(_dt4n) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask);
       _dt4n = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n -> TILDATEST.TestingTimestamps_Cloned."dt4n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setNullDt4n()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask);
       _dt4n=null;
    // setNullRowTZ(); // row TZs are shared, so can't just null it!
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n -> TILDATEST.TestingTimestamps_Cloned."dt4n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt4nNow() throws Exception
    {
      setDt4n(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n -> TILDATEST.TestingTimestamps_Cloned."dt4n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt4nUndefined() throws Exception
    {
      setDt4n(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n -> TILDATEST.TestingTimestamps_Cloned."dt4n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt4n(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt4n(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n -> TILDATEST.TestingTimestamps_Cloned."dt4n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4n_CreateDefault</B>&nbsp;&nbsp;</TD><TD>NOW&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4n_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedDt4n()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u -> TILDATEST.TestingTimestamps_Cloned."dt4u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   @SerializedName("dt4u")
   String  Str_dt4u;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt4u(String v) { Str_dt4u = v; }
   public String initDt4uVal() { return Str_dt4u; }
   transient ZonedDateTime _dt4u = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u -> TILDATEST.TestingTimestamps_Cloned."dt4u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final ZonedDateTime getDt4u()
      { return _dt4u; }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u -> TILDATEST.TestingTimestamps_Cloned."dt4u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final boolean isNullDt4u()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u -> TILDATEST.TestingTimestamps_Cloned."dt4u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setDt4u(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null)
        {
          setNullDt4u();
        }
       else if (v.equals(_dt4u) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask);
       _dt4u = v;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u -> TILDATEST.TestingTimestamps_Cloned."dt4u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public void setNullDt4u()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask);
       _dt4u=null;
    // setNullRowTZ(); // row TZs are shared, so can't just null it!
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u -> TILDATEST.TestingTimestamps_Cloned."dt4u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt4uNow() throws Exception
    {
      setDt4u(DateTimeUtil.NOW_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u -> TILDATEST.TestingTimestamps_Cloned."dt4u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt4uUndefined() throws Exception
    {
      setDt4u(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u -> TILDATEST.TestingTimestamps_Cloned."dt4u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public final void setDt4u(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception
    {
      setDt4u(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u -> TILDATEST.TestingTimestamps_Cloned."dt4u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>dt4u_CreateDefault</B>&nbsp;&nbsp;</TD><TD>UNDEFINED&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>dt4u_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
   public boolean hasChangedDt4u()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a -> TILDATEST.TestingTimestamps_Cloned."dt4a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   @SerializedName("dt4a")
   List<String>  Str_dt4a;
   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */
   public void initJson_Dt4a(List<String> v) { Str_dt4a = v; }
   public List<String> initDt4aVal() { return Str_dt4a; }
   transient List<ZonedDateTime> _dt4a = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a -> TILDATEST.TestingTimestamps_Cloned."dt4a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final ZonedDateTime[] getDt4aAsArray()
      { return _dt4a==null? null : _dt4a.toArray(new ZonedDateTime[_dt4a.size()]); }
   public final Iterator<ZonedDateTime> getDt4a()
      { return _dt4a==null? null : _dt4a.iterator(); }
   public final boolean hasDt4a(ZonedDateTime v)
      { return _dt4a==null? false : _dt4a.contains(v); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a -> TILDATEST.TestingTimestamps_Cloned."dt4a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDt4a()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a -> TILDATEST.TestingTimestamps_Cloned."dt4a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setDt4a(List<ZonedDateTime> v) throws Exception
     {
       long T0 = System.nanoTime();
       if (v == null  || v.isEmpty() == true)
        setNullDt4a();
       else if (CollectionUtil.equals(v, _dt4a) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask);
          if (_dt4a == null)
           {
             _dt4a = new ArrayList<ZonedDateTime>();
           }
          else
           {
             _dt4a.clear();
           }
          tilda.data.ZoneInfo_Data ZIPrev = null;
          for (int k = 0; k < v.size(); ++k)
           {
             ZonedDateTime i = v.get(k);
             _dt4a.add(i);
             tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(i.getZone().getId());
             if (ZI == null)
              throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a' because the timezone value '"+i.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
             if (ZIPrev == null)
              ZIPrev = ZI;
             else if (ZIPrev.getId().equals(ZI.getId()) == false)
              throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a' because the timezone value '"+i.getZone().getId()+"' is inconsistent with previous value '"+ZIPrev.getId()+"' and the tzMode is row-based. Timestamps covered by a row-based timezone must all be set within the same exact timezone.");
           }
        setRowTZ(ZIPrev.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void addToDt4a(int pos, ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt4a == null)
        _dt4a = new ArrayList<ZonedDateTime>();
       if (v == null)
        {
          setNullDt4a();
        }
       else if (pos >= _dt4a.size() || _dt4a.get(pos).equals(v) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask);
          _dt4a.add(pos, v);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a' because the timezone value '"+v.getZone().getId()+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromDt4a(ZonedDateTime v) throws Exception
     {
       long T0 = System.nanoTime();
       int i = _dt4a.indexOf(v);
       if (1 != -1)
        {
          _dt4a.remove(i);
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }
   public void removeFromDt4a(int pos) throws Exception
     {
       long T0 = System.nanoTime();
       if (_dt4a.remove(pos) != null)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask);
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a -> TILDATEST.TestingTimestamps_Cloned."dt4a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public void setNullDt4a()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask);
       _dt4a=null;
    // setNullRowTZ(); // row TZs are shared, so can't just null it!
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a -> TILDATEST.TestingTimestamps_Cloned."dt4a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.dt4a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDt4a()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created -> TILDATEST.TestingTimestamps_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created -> TILDATEST.TestingTimestamps_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created -> TILDATEST.TestingTimestamps_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created</TD></TR>

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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created to null: it's not nullable.");
       else if (v.equals(_created) == false)
        {
          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created' that is invariant, or part of a read-only or pre-existing WORM object.");
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask);
       _created = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created -> TILDATEST.TestingTimestamps_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created -> TILDATEST.TestingTimestamps_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created -> TILDATEST.TestingTimestamps_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created -> TILDATEST.TestingTimestamps_Cloned."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.created</TD></TR>

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
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated -> TILDATEST.TestingTimestamps_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated -> TILDATEST.TestingTimestamps_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated -> TILDATEST.TestingTimestamps_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated</TD></TR>

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
        throw new Exception("Cannot set tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated to null: it's not nullable.");
       else if (v.equals(_lastUpdated) == false)
        {
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask);
       _lastUpdated = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated -> TILDATEST.TestingTimestamps_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated -> TILDATEST.TestingTimestamps_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated -> TILDATEST.TestingTimestamps_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated -> TILDATEST.TestingTimestamps_Cloned."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.lastUpdated</TD></TR>

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
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask); }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted -> TILDATEST.TestingTimestamps_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   transient ZonedDateTime _deleted = null;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted -> TILDATEST.TestingTimestamps_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the getter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted -> TILDATEST.TestingTimestamps_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the isNull for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final boolean isNullDeleted()
     { return __Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask); }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted -> TILDATEST.TestingTimestamps_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted</TD></TR>

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
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask);
       _deleted = v;
        }
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted -> TILDATEST.TestingTimestamps_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the null setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public final void setNullDeleted()
     {
       long T0 = System.nanoTime();
       __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask) == true) // already NULL
        return;
       __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask);
       _deleted=null;
       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);
     }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted -> TILDATEST.TestingTimestamps_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the NOW setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted -> TILDATEST.TestingTimestamps_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the UNDEFINED setter for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted -> TILDATEST.TestingTimestamps_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the explicit setter %%CALENDAR_SETTER%% for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted</TD></TR>

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
//   Field tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted -> TILDATEST.TestingTimestamps_Cloned."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the hasChanged for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps_Cloned)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps_Cloned.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps_Cloned.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
   public boolean hasChangedDeleted()
     { return __Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask); }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Copies all the field which are not part of the primary key, not are CALCULATED and not invariant, from the 
 current object to the destination. 
*/
   public void copyTo(tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS_CLONED Dst) throws Exception
     {
       if (_id          != null)
        Dst.setId         (_id         );
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask) == true || _dt1TZ      ==null)
        Dst.setNullDt1TZ      ();
       else
        Dst.setDt1TZ      (_dt1TZ      );
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask) == true || _dt1        ==null)
        Dst.setNullDt1        ();
       else
        Dst.setDt1        (_dt1        );
       Dst.Str_dt1 = Str_dt1;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask) == true || _dt1nTZ     ==null)
        Dst.setNullDt1nTZ     ();
       else
        Dst.setDt1nTZ     (_dt1nTZ     );
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask) == true || _dt1n       ==null)
        Dst.setNullDt1n       ();
       else
        Dst.setDt1n       (_dt1n       );
       Dst.Str_dt1n = Str_dt1n;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask) == true || _dt1uTZ     ==null)
        Dst.setNullDt1uTZ     ();
       else
        Dst.setDt1uTZ     (_dt1uTZ     );
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask) == true || _dt1u       ==null)
        Dst.setNullDt1u       ();
       else
        Dst.setDt1u       (_dt1u       );
       Dst.Str_dt1u = Str_dt1u;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask) == true || _dt1aTZ     ==null)
        Dst.setNullDt1aTZ     ();
       else
        Dst.setDt1aTZ     (_dt1aTZ     );
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask) == true || _dt1a       ==null)
        Dst.setNullDt1a       ();
       else
        Dst.setDt1a       (_dt1a       );
       Dst.Str_dt1a = Str_dt1a;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask) == true || _rowTZ      ==null)
        Dst.setNullRowTZ      ();
       else
        Dst.setRowTZ      (_rowTZ      );
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask) == true || _dt2        ==null)
        Dst.setNullDt2        ();
       else
        Dst.setDt2        (_dt2        );
       Dst.Str_dt2 = Str_dt2;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask) == true || _dt2n       ==null)
        Dst.setNullDt2n       ();
       else
        Dst.setDt2n       (_dt2n       );
       Dst.Str_dt2n = Str_dt2n;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask) == true || _dt2u       ==null)
        Dst.setNullDt2u       ();
       else
        Dst.setDt2u       (_dt2u       );
       Dst.Str_dt2u = Str_dt2u;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask) == true || _dt2a       ==null)
        Dst.setNullDt2a       ();
       else
        Dst.setDt2a       (_dt2a       );
       Dst.Str_dt2a = Str_dt2a;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask) == true || _dt3TZ      ==null)
        Dst.setNullDt3TZ      ();
       else
        Dst.setDt3TZ      (_dt3TZ      );
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask) == true || _dt3        ==null)
        Dst.setNullDt3        ();
       else
        Dst.setDt3        (_dt3        );
       Dst.Str_dt3 = Str_dt3;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask) == true || _dt3nTZ     ==null)
        Dst.setNullDt3nTZ     ();
       else
        Dst.setDt3nTZ     (_dt3nTZ     );
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask) == true || _dt3n       ==null)
        Dst.setNullDt3n       ();
       else
        Dst.setDt3n       (_dt3n       );
       Dst.Str_dt3n = Str_dt3n;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask) == true || _dt3uTZ     ==null)
        Dst.setNullDt3uTZ     ();
       else
        Dst.setDt3uTZ     (_dt3uTZ     );
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask) == true || _dt3u       ==null)
        Dst.setNullDt3u       ();
       else
        Dst.setDt3u       (_dt3u       );
       Dst.Str_dt3u = Str_dt3u;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask) == true || _dt3aTZ     ==null)
        Dst.setNullDt3aTZ     ();
       else
        Dst.setDt3aTZ     (_dt3aTZ     );
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask) == true || _dt3a       ==null)
        Dst.setNullDt3a       ();
       else
        Dst.setDt3a       (_dt3a       );
       Dst.Str_dt3a = Str_dt3a;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask) == true || _dt4        ==null)
        Dst.setNullDt4        ();
       else
        Dst.setDt4        (_dt4        );
       Dst.Str_dt4 = Str_dt4;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask) == true || _dt4n       ==null)
        Dst.setNullDt4n       ();
       else
        Dst.setDt4n       (_dt4n       );
       Dst.Str_dt4n = Str_dt4n;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask) == true || _dt4u       ==null)
        Dst.setNullDt4u       ();
       else
        Dst.setDt4u       (_dt4u       );
       Dst.Str_dt4u = Str_dt4u;
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask) == true || _dt4a       ==null)
        Dst.setNullDt4a       ();
       else
        Dst.setDt4a       (_dt4a       );
       Dst.Str_dt4a = Str_dt4a;
       if (__Init == InitMode.CREATE && _created     != null)
        Dst.setCreated    (_created    );
       if (_lastUpdated != null)
        Dst.setLastUpdated(_lastUpdated);
       if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask) == true || _deleted    ==null)
        Dst.setNullDeleted    ();
       else
        Dst.setDeleted    (_deleted    );
     }


   public tilda.data_test.TestingTimestamps_Cloned_Data copy() throws Exception
     {
       tilda.data_test.TestingTimestamps_Cloned_Data dst = new tilda.data_test.TestingTimestamps_Cloned_Data();
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
          setRefnum(tilda.db.KeysManager.getKey("TILDATEST.TESTINGTIMESTAMPS_CLONED"));
        }

       if (hasChanged() == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data_test.TILDATEST.TestingTimestamps_Cloned has not changed: no writing will occur.");
          QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }


       if (beforeWrite(C) == false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "The tilda.data_test.TILDATEST.TestingTimestamps_Cloned object's beforeWrite() failed.");
          QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.SCHEMA_TABLENAME_LABEL, "");
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
               PS.setLong      (++i, _refnum     );
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
          tilda.data_test._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.SCHEMA_TABLENAME_LABEL, __Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

       stateUpdatePostWrite();
       return true;
     }

   protected abstract boolean beforeWrite(Connection C) throws Exception;

   protected void validateDeserialization() throws Exception
     {

       if (TextUtil.isNullOrEmpty(_id) == true)
        throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.id' was null or empty. It's not nullable in the model.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID._Mask);

       if (TextUtil.isNullOrEmpty(Str_dt1) == false)
        {
          _dt1 = DateTimeUtil.parsefromJSON(Str_dt1);
          if (   _dt1 == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask);
          String zoneId = _dt1.getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt1TZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt1n) == false)
        {
          _dt1n = DateTimeUtil.parsefromJSON(Str_dt1n);
          if (   _dt1n == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask);
          String zoneId = _dt1n.getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt1nTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt1u) == false)
        {
          _dt1u = DateTimeUtil.parsefromJSON(Str_dt1u);
          if (   _dt1u == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask);
          String zoneId = _dt1u.getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt1uTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt1a) == false)
        {
          _dt1a = DateTimeUtil.parsefromJSON(Str_dt1a);
          if (   _dt1a == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask);
          for (int pos = 0; pos < _dt1a.size(); ++pos)
            {
          String zoneId = _dt1a.get(pos).getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          addToDt1aTZ(pos, ZI.getId());
            }
        }

       if (TextUtil.isNullOrEmpty(Str_dt2) == false)
        {
          _dt2 = DateTimeUtil.parsefromJSON(Str_dt2);
          if (   _dt2 == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask);
          String zoneId = _dt2.getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt2n) == false)
        {
          _dt2n = DateTimeUtil.parsefromJSON(Str_dt2n);
          if (   _dt2n == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask);
          String zoneId = _dt2n.getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt2u) == false)
        {
          _dt2u = DateTimeUtil.parsefromJSON(Str_dt2u);
          if (   _dt2u == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask);
          String zoneId = _dt2u.getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt2a) == false)
        {
          _dt2a = DateTimeUtil.parsefromJSON(Str_dt2a);
          if (   _dt2a == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask);
          for (int pos = 0; pos < _dt2a.size(); ++pos)
            {
          String zoneId = _dt2a.get(pos).getZone().getId();
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
            }
        }

       if (TextUtil.isNullOrEmpty(Str_dt3) == false)
        {
          _dt3 = DateTimeUtil.parsefromJSON(Str_dt3);
          if (   _dt3 == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask);
          String zoneId = _dt3TZ;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt3TZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt3n) == false)
        {
          _dt3n = DateTimeUtil.parsefromJSON(Str_dt3n);
          if (   _dt3n == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask);
          String zoneId = _dt3nTZ;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt3nTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt3u) == false)
        {
          _dt3u = DateTimeUtil.parsefromJSON(Str_dt3u);
          if (   _dt3u == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask);
          String zoneId = _dt3uTZ;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setDt3uTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt3a) == false)
        {
          _dt3a = DateTimeUtil.parsefromJSON(Str_dt3a);
          if (   _dt3a == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask);
          for (int pos = 0; pos < _dt3a.size(); ++pos)
            {
          String zoneId = _dt3aTZ.get(pos);
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          addToDt3aTZ(pos, ZI.getId());
            }
        }

       if (TextUtil.isNullOrEmpty(Str_dt4) == false)
        {
          _dt4 = DateTimeUtil.parsefromJSON(Str_dt4);
          if (   _dt4 == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask);
          String zoneId = _rowTZ;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt4n) == false)
        {
          _dt4n = DateTimeUtil.parsefromJSON(Str_dt4n);
          if (   _dt4n == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask);
          String zoneId = _rowTZ;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt4u) == false)
        {
          _dt4u = DateTimeUtil.parsefromJSON(Str_dt4u);
          if (   _dt4u == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask);
          String zoneId = _rowTZ;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
        }

       if (TextUtil.isNullOrEmpty(Str_dt4a) == false)
        {
          _dt4a = DateTimeUtil.parsefromJSON(Str_dt4a);
          if (   _dt4a == null)
           throw new Exception("Incoming value for 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a' was not in the expected format. Dates should follow the ISO format.\n"+toString());
          __Changes.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask);
          __Nulls.andNot(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask);
          for (int pos = 0; pos < _dt4a.size(); ++pos)
            {
          String zoneId = _rowTZ;
          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);
          if (ZI == null)
           throw new Exception("Cannot set field 'tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a' because the timezone value '"+zoneId+"' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
          setRowTZ(ZI.getId());
            }
        }
     }
   protected String getTimeStampSignature() throws Exception
     {
       StringBuilder S = new StringBuilder(1024);
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt1) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt1n) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt1u) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt2) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt2n) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt2u) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt3) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt3n) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt3u) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt4) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt4n) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_dt4u) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_created) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? "C" : "X");
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask) == true) S.append(DateTimeUtil.isNowPlaceholder(_deleted) == true ? "C" : "X");
       return S.toString();
     }
   protected String getWriteQuery(Connection C) throws Exception
     {
       StringBuilder S = new StringBuilder(1024);

       if (__Init == InitMode.CREATE)
        {
          StringBuilder V = new StringBuilder(1024);
          S.append("insert into "); C.getFullTableVar(S, "TILDATEST", "TestingTimestamps_Cloned");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.REFNUM._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.REFNUM.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt1) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt1n) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt1u) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION); }          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A.getFullColumnVarForInsert(C, S);
             V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt2) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt2n) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt2u) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION); }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A.getFullColumnVarForInsert(C, S);
             V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt3) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt3n) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt3u) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION); }          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);  }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A.getFullColumnVarForInsert(C, S);
             V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt4) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt4n) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt4u) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U.getFullColumnVarForInsert(C, S); V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION); }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A.getFullColumnVarForInsert(C, S);
             V.append(tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }
          else { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); V.append(C.getCommaCurrentTimestamp()); }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask) == true) { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S);
             V.append(__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true ? C.getCommaCurrentTimestamp() : tilda.data_test._Tilda.TILDA__2_5._COMMAQUESTION);
           }

          S.setCharAt(Pos, '(');
          V.setCharAt(0, '(');
          S.append(") values ").append(V).append(')');
          V.setLength(0);
          V = null;
        }
       else // InitMode can be anything else
        {
          S.append("update "); C.getFullTableVar(S, "TILDATEST", "TestingTimestamps_Cloned"); S.append(" set");
          int Pos = S.length();
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.REFNUM._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.REFNUM.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID.getFullColumnVarForUpdate(C, S);
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt1) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt1n) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt1u) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask) == true)
           {
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt2) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt2n) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt2u) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask) == true)
           {
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt3) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt3n) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt3u) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U.getFullColumnVarForUpdate(C, S);
           }
          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask) == true) TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ.getFullColumnVarForUpdate(C, S);

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask) == true)
           {
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt4) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt4n) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask) == false && DateTimeUtil.isNowPlaceholder(_dt4u) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask) == true)
           {
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_created) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED.getFullColumnVarForUpdate(C, S);
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask) == false && DateTimeUtil.isNowPlaceholder(_lastUpdated) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED.getFullColumnVarForUpdate(C, S);
           }
          else 
           {
             TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp());
             setLastUpdatedNow();
           }

          if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask) == true)
           {
             if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask) == false && DateTimeUtil.isNowPlaceholder(_deleted) == true)
              { TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED.getFullColumnVarForInsert(C, S); S.append(C.getEqualCurrentTimestamp()); }
             else
              TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED.getFullColumnVarForUpdate(C, S);
           }

          switch (__LookupId)
           {
             case 0: // PK
                S.append(" where ("); C.getFullColumnVar(S, "TILDATEST", "TestingTimestamps_Cloned", "refnum"); S.append("=?");  S.append(")");
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
       QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATEST.TestingTimestamps_Cloned", Q, toString());

       return Q;
     }
   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception
     {
       int i = 0;
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.REFNUM._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.REFNUM._Mask) == true) PS.setNull(++i, java.sql.Types.BIGINT    ); else PS.setLong      (++i, _refnum);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _id);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _dt1TZ);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_dt1) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt1.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _dt1nTZ);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_dt1n) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt1n.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _dt1uTZ);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_dt1u) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt1u.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.VARCHAR   ); else C.setArray(PS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ.getType(), AllocatedArrays, _dt1aTZ);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else C.setArray(PS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A.getType(), AllocatedArrays, DateTimeUtil.toSQLTimeStamps(_dt1a));
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _rowTZ);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_dt2) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt2.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_dt2n) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt2n.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_dt2u) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt2u.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else C.setArray(PS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A.getType(), AllocatedArrays, DateTimeUtil.toSQLTimeStamps(_dt2a));
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _dt3TZ);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP ); else if (DateTimeUtil.isNowPlaceholder(_dt3) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt3.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _dt3nTZ);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP ); else if (DateTimeUtil.isNowPlaceholder(_dt3n) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt3n.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask) == true) PS.setNull(++i, java.sql.Types.VARCHAR   ); else PS.setString    (++i, _dt3uTZ);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP ); else if (DateTimeUtil.isNowPlaceholder(_dt3u) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt3u.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.VARCHAR   ); else C.setArray(PS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ.getType(), AllocatedArrays, _dt3aTZ);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.TIMESTAMP ); else C.setArray(PS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A.getType(), AllocatedArrays, DateTimeUtil.toSQLTimeStamps(_dt3a));
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP ); else if (DateTimeUtil.isNowPlaceholder(_dt4) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt4.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP ); else if (DateTimeUtil.isNowPlaceholder(_dt4n) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt4n.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP ); else if (DateTimeUtil.isNowPlaceholder(_dt4u) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_dt4u.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask) == true) PS.setNull(++i, C.supportsArrays()?java.sql.Types.ARRAY:java.sql.Types.TIMESTAMP ); else C.setArray(PS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A.getType(), AllocatedArrays, DateTimeUtil.toSQLTimeStamps(_dt4a));
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_created) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_created.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_lastUpdated) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_lastUpdated.toInstant()), DateTimeUtil._UTC_CALENDAR);
        } 
       if (__Changes.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask) == true) 
        { 
          if (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask) == true) PS.setNull(++i, java.sql.Types.TIMESTAMP_WITH_TIMEZONE); else if (DateTimeUtil.isNowPlaceholder(_deleted) == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_deleted.toInstant()), DateTimeUtil._UTC_CALENDAR);
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
             __Saved_refnum      = _refnum     ;
             break;
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot prepare statement.");
        }

       __Changes.clear();
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
        throw new Exception("This TILDATEST.TestingTimestamps_Cloned object is being read() after a create(), which doesn't make sense.");
       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)
        {
          LOG.debug(QueryDetails._LOGGING_HEADER + "This TILDATEST.TestingTimestamps_Cloned object has already been read.");
          QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.SCHEMA_TABLENAME_LABEL, "");
          return true;
        }
       StringBuilder S = new StringBuilder(1024);
          S.append("select ");
          C.getFullColumnVarList(S, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "TestingTimestamps_Cloned");
       switch (__LookupId)
        {
          case 0: // PK
             S.append(" where ("); C.getFullColumnVar(S, "TILDATEST", "TestingTimestamps_Cloned", "refnum"); S.append("=?");  S.append(")");
             break;
          case -77: 
          case -666: if (__Init == InitMode.CREATE) break;
          default: throw new Exception("Invalid LookupId "+__LookupId+" found. Cannot create where clause.");
        }

       String Q = S.toString();
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDATEST.TestingTimestamps_Cloned", Q, toString());
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
               PS.setLong      (++i, _refnum     );
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
          tilda.data_test._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }
    }

   @SuppressWarnings("unchecked")
   boolean init(Connection C, java.sql.ResultSet RS) throws Exception
    {
      int i = 0;
     __Init = InitMode.LOOKUP;
      __Saved_refnum      = _refnum      =                              RS.getLong      (++i) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.REFNUM._Mask     ); _refnum = null; }
                            _id          = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ID._Mask         ); _id = null; }
                            _dt1TZ       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ._Mask      ); _dt1TZ = null; } else _dt1TZ       = _dt1TZ      .trim();
                            _dt1         = processZDT(_dt1TZ        , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1"        , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1        , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1TZ        ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask        ); _dt1 = null; }
                            _dt1nTZ      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ._Mask     ); _dt1nTZ = null; } else _dt1nTZ      = _dt1nTZ     .trim();
                            _dt1n        = processZDT(_dt1nTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1n"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1NTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask       ); _dt1n = null; }
                            _dt1uTZ      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ._Mask     ); _dt1uTZ = null; } else _dt1uTZ      = _dt1uTZ     .trim();
                            _dt1u        = processZDT(_dt1uTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1u"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1UTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask       ); _dt1u = null; }
                            _dt1aTZ = (List<String>) C.getArray(RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask     ); _dt1aTZ = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_dt1aTZ != null && _dt1aTZ.size() == 1 && _dt1aTZ.get(0) == null)
                               {
                                 _dt1aTZ = new ArrayList<String>();
                                 __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ._Mask);
                               }
                            _dt1a        = processZDTs(C, _dt1aTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt1a"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1ATZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask       ); _dt1a = null; }
                            _rowTZ       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ._Mask      ); _rowTZ = null; } else _rowTZ       = _rowTZ      .trim();
                            _dt2         = processZDT(_rowTZ        , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2"        , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2        , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ        ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask        ); _dt2 = null; }
                            _dt2n        = processZDT(_rowTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2n"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask       ); _dt2n = null; }
                            _dt2u        = processZDT(_rowTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2u"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask       ); _dt2u = null; }
                            _dt2a        = processZDTs(C, _rowTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt2a"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask       ); _dt2a = null; }
                            _dt3TZ       = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ._Mask      ); _dt3TZ = null; } else _dt3TZ       = _dt3TZ      .trim();
                            _dt3         = processZDT(_dt3TZ        , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3"        , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3        , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3TZ        ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask        ); _dt3 = null; }
                            _dt3nTZ      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ._Mask     ); _dt3nTZ = null; } else _dt3nTZ      = _dt3nTZ     .trim();
                            _dt3n        = processZDT(_dt3nTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3n"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3NTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask       ); _dt3n = null; }
                            _dt3uTZ      = TextUtil.trim               (RS.getString    (++i)) ;  if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ._Mask     ); _dt3uTZ = null; } else _dt3uTZ      = _dt3uTZ     .trim();
                            _dt3u        = processZDT(_dt3uTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3u"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3UTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask       ); _dt3u = null; }
                            _dt3aTZ = (List<String>) C.getArray(RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ.getType(), false); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask     ); _dt3aTZ = null; }
                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.
                             //Those values show up as a [null] array (1 element, which is null).
                             if (_dt3aTZ != null && _dt3aTZ.size() == 1 && _dt3aTZ.get(0) == null)
                               {
                                 _dt3aTZ = new ArrayList<String>();
                                 __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ._Mask);
                               }
                            _dt3a        = processZDTs(C, _dt3aTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt3a"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3ATZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask       ); _dt3a = null; }
                            _dt4         = processZDT(_rowTZ        , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4"        , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4        , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ        ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask        ); _dt4 = null; }
                            _dt4n        = processZDT(_rowTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4n"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask       ); _dt4n = null; }
                            _dt4u        = processZDT(_rowTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4u"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask       ); _dt4u = null; }
                            _dt4a        = processZDTs(C, _rowTZ       , "tilda.data_test.TILDATEST.TestingTimestamps_Cloned.dt4a"       , RS, ++i, TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A       , TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.ROWTZ       ); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask       ); _dt4a = null; }
                            _created     = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.CREATED._Mask    ); _created = null; }
                            _lastUpdated = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.LASTUPDATED._Mask); _lastUpdated = null; }
                            _deleted     = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), null); if (RS.wasNull() == true) { __Nulls.or(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask    ); _deleted = null; }
     __LookupId = 0;
     __Init     = InitMode.READ;
     __Changes.clear();

     return afterRead(C);
   }

  private final ZonedDateTime processZDT(String TimezoneId, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)
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
  private final List<ZonedDateTime> processZDTs(Connection C, List<String> TimezoneIds, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)
  throws Exception
   {
     List<Timestamp> L = (List<Timestamp>) C.getArray(RS, ColumnPos, DTField.getType(), false);
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
  private final List<ZonedDateTime> processZDTs(Connection C, String rowTimezoneId, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)
  throws Exception
   {
     List<Timestamp> L = (List<Timestamp>) C.getArray(RS, ColumnPos, DTField.getType(), false);
     boolean DTNull = false;
     if (RS.wasNull() == true)
      {
         __Nulls.or(DTField._Mask);
         DTNull = true;
      }
     boolean TZNull = __Nulls.intersects(TZField._Mask);
     if (DTNull == false && TZNull == true)
      throw new Exception("The field "+DTFieldName+" is not null while its associated timezone field '"+TZField.getName()+"' is null. A TZ is mandatory for not null timestamps.");
     if (DTNull == true)
      return null;

     tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(rowTimezoneId);
     if (ZI == null && TextUtil.isNullOrEmpty(rowTimezoneId) == false)
      throw new Exception("Cannot set field '"+DTFieldName+"' because the timezone Id '" + rowTimezoneId + "' is unknown. Make sure it is mapped properly in the ZoneInfo table.");
     List<ZonedDateTime> ZDTs = new ArrayList<ZonedDateTime>();
     for (int i = 0; i < L.size(); ++i)
       {
         ZonedDateTime ZDT = DateTimeUtil.toZonedDateTime(L.get(i), ZI == null ? "null" : ZI.getValue());
         ZDTs.add(ZDT);
       }
     return ZDTs;
   }

   protected abstract boolean afterRead(Connection C) throws Exception;

   public String toString()
    {
      long T0 = System.nanoTime();
      String Str = 
                   "refnum: "                                                                                                            +                                   getRefnum     ()
               + "; id: "                                                                                                                + TextUtil.printVariableStr        (getId         ())
               + "; dt1"           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1._Mask        ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt1        ()))
               + "; dt1n"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1N._Mask       ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt1n       ()))
               + "; dt1u"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1U._Mask       ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt1u       ()))
               + "; dt1a"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT1A._Mask       ) == true ? ": NULL" : ": " + TextUtil.print                   (getDt1a       ()))
               + "; dt2"           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2._Mask        ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt2        ()))
               + "; dt2n"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2N._Mask       ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt2n       ()))
               + "; dt2u"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2U._Mask       ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt2u       ()))
               + "; dt2a"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT2A._Mask       ) == true ? ": NULL" : ": " + TextUtil.print                   (getDt2a       ()))
               + "; dt3"           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3._Mask        ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt3        ()))
               + "; dt3n"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3N._Mask       ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt3n       ()))
               + "; dt3u"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3U._Mask       ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt3u       ()))
               + "; dt3a"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT3A._Mask       ) == true ? ": NULL" : ": " + TextUtil.print                   (getDt3a       ()))
               + "; dt4"           + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4._Mask        ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt4        ()))
               + "; dt4n"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4N._Mask       ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt4n       ()))
               + "; dt4u"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4U._Mask       ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDt4u       ()))
               + "; dt4a"          + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DT4A._Mask       ) == true ? ": NULL" : ": " + TextUtil.print                   (getDt4a       ()))
               + "; created: "                                                                                                           + DateTimeUtil.printDateTimeForJSON(getCreated    ())
               + "; lastUpdated: "                                                                                                       + DateTimeUtil.printDateTimeForJSON(getLastUpdated())
               + "; deleted"       + (__Nulls.intersects(TILDA__TESTINGTIMESTAMPS_CLONED_Factory.COLS.DELETED._Mask    ) == true ? ": NULL" : ": " + DateTimeUtil.printDateTimeForJSON(getDeleted    ()))
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
          case "AAA": tilda.data_test.TestingTimestamps_Cloned_Factory.toJSONAAA(out, (tilda.data_test.TestingTimestamps_Cloned_Data) this, lead, fullObject, noNullArrays); break;
          case "": tilda.data_test.TestingTimestamps_Cloned_Factory.toJSON(out, (tilda.data_test.TestingTimestamps_Cloned_Data) this, lead, fullObject, noNullArrays); break;
          default: throw new Exception("Unknown JSON exporter '"+exportName+"' for tilda.data_test.TestingTimestamps_Cloned_Factory");
        } 
    }
   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown JSON sync exporter '"+exportName+"' for tilda.data_test.TestingTimestamps_Cloned_Factory");
    }
   public void toCSV(java.io.Writer out, String exportName) throws Exception
    {
      switch (exportName)
        { 
          case "": tilda.data_test.TestingTimestamps_Cloned_Factory.toCSV(out, (tilda.data_test.TestingTimestamps_Cloned_Data) this); break;
          default: throw new Exception("Unknown CSV exporter '"+exportName+"' for tilda.data_test.TestingTimestamps_Cloned_Factory");
        } 
    }
   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception
    {
      throw new Exception("Unknown CSV sync exporter '"+exportName+"' for tilda.data_test.TestingTimestamps_Cloned_Factory");
    }
 }
