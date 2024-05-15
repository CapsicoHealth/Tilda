
package tilda.data_test._Tilda;

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
public class TILDA__TESTINGTIMESTAMPS_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTINGTIMESTAMPS_Factory.class.getName());

   protected TILDA__TESTINGTIMESTAMPS_Factory() { }

   public static final Class<TILDA__TESTINGTIMESTAMPS> DATA_CLASS= TILDA__TESTINGTIMESTAMPS.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATEST", "");
   public static final String TABLENAME_LABEL = TextUtil.print("TestingTimestamps", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATEST.TestingTimestamps", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATEST", "TestingTimestamps"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.refnum -> TILDATEST.TestingTimestamps."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>refnum of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.refnum of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.refnum</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitive                REFNUM     = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"     , 0/*0*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.id -> TILDATEST.TestingTimestamps."id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>id of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.id of type varchar(20)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.id</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>20</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              ID         = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "id"         , 1/*1*/, 20, "Medical system unique enterprise id", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt1TZ -> TILDATEST.TestingTimestamps."dt1TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt1TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt1TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          DT1TZ      = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "dt1TZ"      , 2/*2*/, 5, "Generated helper column to hold the time zone ID for 'dt1'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt1 -> TILDATEST.TestingTimestamps."dt1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt1 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt1</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull        DT1        = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "dt1"        , 3/*3*/, "The blah", null, null, DT1TZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt1nTZ -> TILDATEST.TestingTimestamps."dt1nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt1nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt1nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          DT1NTZ     = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "dt1nTZ"     , 4/*4*/, 5, "Generated helper column to hold the time zone ID for 'dt1n'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt1n -> TILDATEST.TestingTimestamps."dt1n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt1n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt1n</TD></TR>

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
     public final Type_DatetimePrimitiveNull        DT1N       = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "dt1n"       , 5/*5*/, "The blah", null, null, DT1NTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt1uTZ -> TILDATEST.TestingTimestamps."dt1uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt1uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt1uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          DT1UTZ     = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "dt1uTZ"     , 6/*6*/, 5, "Generated helper column to hold the time zone ID for 'dt1u'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt1u -> TILDATEST.TestingTimestamps."dt1u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt1u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt1u</TD></TR>

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
     public final Type_DatetimePrimitiveNull        DT1U       = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "dt1u"       , 7/*7*/, "The blah", null, null, DT1UTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt1aTZ -> TILDATEST.TestingTimestamps."dt1aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt1a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt1aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt1aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringCollectionNull         DT1ATZ     = new Type_StringCollectionNull        (SCHEMA_LABEL, TABLENAME_LABEL, "dt1aTZ"     , 8/*8*/, "Generated helper column to hold the time zone ID for 'dt1a'.", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt1a -> TILDATEST.TestingTimestamps."dt1a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt1a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt1a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt1a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimeCollectionNull       DT1A       = new Type_DatetimeCollectionNull      (SCHEMA_LABEL, TABLENAME_LABEL, "dt1a"       , 9/*9*/, "The blah", null, null, DT1ATZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.rowTZ -> TILDATEST.TestingTimestamps."rowTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rowTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.rowTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.rowTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          ROWTZ      = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "rowTZ"      , 10/*10*/, 5, "Generated helper column to hold the time zone ID for 1 or more columns at the TILDATEST.TestingTimestamps row level: dt2, dt2n, dt2u, dt2a, dt4, dt4n, dt4u, dt4a.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt2 -> TILDATEST.TestingTimestamps."dt2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt2 of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt2</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull        DT2        = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "dt2"        , 11/*11*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt2n -> TILDATEST.TestingTimestamps."dt2n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt2n of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt2n</TD></TR>

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
     public final Type_DatetimePrimitiveNull        DT2N       = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "dt2n"       , 12/*12*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt2u -> TILDATEST.TestingTimestamps."dt2u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt2u of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt2u</TD></TR>

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
     public final Type_DatetimePrimitiveNull        DT2U       = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "dt2u"       , 13/*13*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt2a -> TILDATEST.TestingTimestamps."dt2a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt2a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt2a of type timestamptz[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt2a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimeCollectionNull       DT2A       = new Type_DatetimeCollectionNull      (SCHEMA_LABEL, TABLENAME_LABEL, "dt2a"       , 14/*14*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt3TZ -> TILDATEST.TestingTimestamps."dt3TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3TZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt3TZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt3TZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          DT3TZ      = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "dt3TZ"      , 15/*15*/, 5, "Generated helper column to hold the time zone ID for 'dt3'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt3 -> TILDATEST.TestingTimestamps."dt3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt3 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt3</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  DT3        = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dt3"        , 16/*16*/, "The blah", null, null, DT3TZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt3nTZ -> TILDATEST.TestingTimestamps."dt3nTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3nTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3n'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt3nTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt3nTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          DT3NTZ     = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "dt3nTZ"     , 17/*17*/, 5, "Generated helper column to hold the time zone ID for 'dt3n'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt3n -> TILDATEST.TestingTimestamps."dt3n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt3n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt3n</TD></TR>

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
     public final Type_DatetimePrimitiveNull  DT3N       = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dt3n"       , 18/*18*/, "The blah", null, null, DT3NTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt3uTZ -> TILDATEST.TestingTimestamps."dt3uTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3uTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3u'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt3uTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt3uTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull          DT3UTZ     = new Type_StringPrimitiveNull         (SCHEMA_LABEL, TABLENAME_LABEL, "dt3uTZ"     , 19/*19*/, 5, "Generated helper column to hold the time zone ID for 'dt3u'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt3u -> TILDATEST.TestingTimestamps."dt3u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt3u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt3u</TD></TR>

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
     public final Type_DatetimePrimitiveNull  DT3U       = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dt3u"       , 20/*20*/, "The blah", null, null, DT3UTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt3aTZ -> TILDATEST.TestingTimestamps."dt3aTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3aTZ of type List&lt;String&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'dt3a'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt3aTZ of type text[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt3aTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>Size not applicable for collections</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringCollectionNull         DT3ATZ     = new Type_StringCollectionNull        (SCHEMA_LABEL, TABLENAME_LABEL, "dt3aTZ"     , 21/*21*/, "Generated helper column to hold the time zone ID for 'dt3a'.", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt3a -> TILDATEST.TestingTimestamps."dt3a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt3a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt3a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt3a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimeCollectionNull DT3A       = new Type_DatetimeCollectionNull(SCHEMA_LABEL, TABLENAME_LABEL, "dt3a"       , 22/*22*/, "The blah", null, null, DT3ATZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt4 -> TILDATEST.TestingTimestamps."dt4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4 of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt4 of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt4</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  DT4        = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dt4"        , 23/*23*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt4n -> TILDATEST.TestingTimestamps."dt4n"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4n of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt4n of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt4n</TD></TR>

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
     public final Type_DatetimePrimitiveNull  DT4N       = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dt4n"       , 24/*24*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt4u -> TILDATEST.TestingTimestamps."dt4u"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4u of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt4u of type timestamp</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt4u</TD></TR>

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
     public final Type_DatetimePrimitiveNull  DT4U       = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "dt4u"       , 25/*25*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.dt4a -> TILDATEST.TestingTimestamps."dt4a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>dt4a of type List&lt;ZonedDateTime&gt; (ordered)</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.dt4a of type timestamp[]</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.dt4a</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimeCollectionNull DT4A       = new Type_DatetimeCollectionNull(SCHEMA_LABEL, TABLENAME_LABEL, "dt4a"       , 26/*26*/, "The blah", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.created -> TILDATEST.TestingTimestamps."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATEST.TestingTimestamps)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.created</TD></TR>

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
     public final Type_DatetimePrimitive            CREATED    = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "created"    , 27/*27*/, "The timestamp for when the record was created. (TILDATEST.TestingTimestamps)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.lastUpdated -> TILDATEST.TestingTimestamps."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.lastUpdated</TD></TR>

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
     public final Type_DatetimePrimitive            LASTUPDATED= new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated", 28/*28*/, "The timestamp for when the record was last updated. (TILDATEST.TestingTimestamps)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.TestingTimestamps.deleted -> TILDATEST.TestingTimestamps."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.TestingTimestamps.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data_test.TILDATEST.TestingTimestamps.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull        DELETED    = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"    , 29/*29*/, "The timestamp for when the record was deleted. (TILDATEST.TestingTimestamps)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.REFNUM,COLS.ID,COLS.DT1TZ,COLS.DT1,COLS.DT1NTZ,COLS.DT1N,COLS.DT1UTZ,COLS.DT1U,COLS.DT1ATZ,COLS.DT1A,COLS.ROWTZ,COLS.DT2,COLS.DT2N,COLS.DT2U,COLS.DT2A,COLS.DT3TZ,COLS.DT3,COLS.DT3NTZ,COLS.DT3N,COLS.DT3UTZ,COLS.DT3U,COLS.DT3ATZ,COLS.DT3A,COLS.DT4,COLS.DT4N,COLS.DT4U,COLS.DT4A,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.REFNUM };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = new ColumnDefinition[][]{ 
        };

   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = {};

   // Short(short) is deprecated, but we do want a new instance here to avoid synchronizing over the same cached instance from valueOf.
   // @SuppressWarnings("deprecation")
   private static final AtomicBoolean __INITIALIZED = new AtomicBoolean(false);
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED.compareAndSet(false, true))
        {
           tilda.data_test.TestingTimestamps_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data_test.TestingTimestamps_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.TestingTimestamps_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data_test.TestingTimestamps_Data> _OP;
       protected ArrayListResults<tilda.data_test.TestingTimestamps_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data_test.TestingTimestamps_Data Obj = new tilda.data_test.TestingTimestamps_Data();
          boolean OK = ((tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data_test.TestingTimestamps_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__TESTINGTIMESTAMPS_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "TestingTimestamps");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Index 'AllByName'
                S.append(" order by "); C.getFullColumnVar(S, "TILDATEST", "TestingTimestamps", "id"); S.append(" ASC");
                break;
             case 2: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATEST", "TestingTimestamps", "refnum"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDATEST.TestingTimestamps", Q, null);
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
             case 1: {  // Index 'AllByName'
               break;
             }
             case 2: { // Query 'All'
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
          tilda.data_test._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__TESTINGTIMESTAMPS_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
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
   static public tilda.data_test.TestingTimestamps_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj = new tilda.data_test.TestingTimestamps_Data();
       String[] vals = null;

       vals = Values.get("refnum");
       // Even though this is a primary key, and is by definition not-null, we nevertheless check it as optional in case
       // this object is being initialized generically for a create.
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("refnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _refnum = ParseUtil.parseLong("refnum", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_refnum != null) Obj.setRefnum(_refnum);

       vals = Values.get("id");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("id", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _id = ParseUtil.parseString("id", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_id != null) Obj.setId(_id);

       vals = Values.get("dt1");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt1", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt1 = ParseUtil.parseZonedDateTime("dt1", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt1 != null) Obj.setDt1(_dt1);

       vals = Values.get("dt1n");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt1n", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt1n = ParseUtil.parseZonedDateTime("dt1n", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt1n != null) Obj.setDt1n(_dt1n);

       vals = Values.get("dt1u");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt1u", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt1u = ParseUtil.parseZonedDateTime("dt1u", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt1u != null) Obj.setDt1u(_dt1u);

       vals = Values.get("dt1a");
       List<ZonedDateTime> _dt1a = CollectionUtil.toList(ParseUtil.parseZonedDateTime("dt1a", false, vals, Errors));
       if (_dt1a != null) Obj.setDt1a(_dt1a);

       vals = Values.get("dt2");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt2", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt2 = ParseUtil.parseZonedDateTime("dt2", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt2 != null) Obj.setDt2(_dt2);

       vals = Values.get("dt2n");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt2n", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt2n = ParseUtil.parseZonedDateTime("dt2n", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt2n != null) Obj.setDt2n(_dt2n);

       vals = Values.get("dt2u");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt2u", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt2u = ParseUtil.parseZonedDateTime("dt2u", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt2u != null) Obj.setDt2u(_dt2u);

       vals = Values.get("dt2a");
       List<ZonedDateTime> _dt2a = CollectionUtil.toList(ParseUtil.parseZonedDateTime("dt2a", false, vals, Errors));
       if (_dt2a != null) Obj.setDt2a(_dt2a);

       vals = Values.get("dt3");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt3", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt3 = ParseUtil.parseZonedDateTime("dt3", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt3 != null) Obj.setDt3(_dt3);

       vals = Values.get("dt3n");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt3n", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt3n = ParseUtil.parseZonedDateTime("dt3n", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt3n != null) Obj.setDt3n(_dt3n);

       vals = Values.get("dt3u");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt3u", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt3u = ParseUtil.parseZonedDateTime("dt3u", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt3u != null) Obj.setDt3u(_dt3u);

       vals = Values.get("dt3a");
       List<ZonedDateTime> _dt3a = CollectionUtil.toList(ParseUtil.parseZonedDateTime("dt3a", false, vals, Errors));
       if (_dt3a != null) Obj.setDt3a(_dt3a);

       vals = Values.get("dt4");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt4", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt4 = ParseUtil.parseZonedDateTime("dt4", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt4 != null) Obj.setDt4(_dt4);

       vals = Values.get("dt4n");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt4n", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt4n = ParseUtil.parseZonedDateTime("dt4n", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt4n != null) Obj.setDt4n(_dt4n);

       vals = Values.get("dt4u");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("dt4u", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _dt4u = ParseUtil.parseZonedDateTime("dt4u", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_dt4u != null) Obj.setDt4u(_dt4u);

       vals = Values.get("dt4a");
       List<ZonedDateTime> _dt4a = CollectionUtil.toList(ParseUtil.parseZonedDateTime("dt4a", false, vals, Errors));
       if (_dt4a != null) Obj.setDt4a(_dt4a);


       return (tilda.data_test.TestingTimestamps_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param id          (max size 20) Medical system unique enterprise id
*/
   static public tilda.data_test.TestingTimestamps_Data create(String id) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj = new tilda.data_test.TestingTimestamps_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDATEST.TESTINGTIMESTAMPS"));

       // Explicit setters
       Obj.setId         (id         );

       // Default Create-time setters
       Obj.setDt1nNow               ();
       Obj.setDt1uUndefined         ();
       Obj.setDt2nNow               ();
       Obj.setDt2uUndefined         ();
       Obj.setDt3nNow               ();
       Obj.setDt3uUndefined         ();
       Obj.setDt4nNow               ();
       Obj.setDt4uUndefined         ();
       Obj.setCreatedNow            ();
       Obj.setLastUpdatedNow        ();

       // Default Nullables
       Obj.__Nulls.or(TILDA__TESTINGTIMESTAMPS_Factory.COLS.DT1._Mask);
       Obj.__Nulls.or(TILDA__TESTINGTIMESTAMPS_Factory.COLS.DT1A._Mask);
       Obj.__Nulls.or(TILDA__TESTINGTIMESTAMPS_Factory.COLS.DT2._Mask);
       Obj.__Nulls.or(TILDA__TESTINGTIMESTAMPS_Factory.COLS.DT2A._Mask);
       Obj.__Nulls.or(TILDA__TESTINGTIMESTAMPS_Factory.COLS.DT3._Mask);
       Obj.__Nulls.or(TILDA__TESTINGTIMESTAMPS_Factory.COLS.DT3A._Mask);
       Obj.__Nulls.or(TILDA__TESTINGTIMESTAMPS_Factory.COLS.DT4._Mask);
       Obj.__Nulls.or(TILDA__TESTINGTIMESTAMPS_Factory.COLS.DT4A._Mask);

       return (tilda.data_test.TestingTimestamps_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data_test.TestingTimestamps_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__TESTINGTIMESTAMPS lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__TESTINGTIMESTAMPS) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__TESTINGTIMESTAMPS) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data_test.TestingTimestamps_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__TESTINGTIMESTAMPS) d);

               if (((TILDA__TESTINGTIMESTAMPS) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.TestingTimestamps_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPS_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__TESTINGTIMESTAMPS) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.TestingTimestamps_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPS_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__TESTINGTIMESTAMPS) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.TestingTimestamps_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPS_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__TESTINGTIMESTAMPS) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.TestingTimestamps_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__TESTINGTIMESTAMPS_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data_test.TestingTimestamps_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'TestingTimestamps_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__2_5.handleFinally(PS, T0, TILDA__TESTINGTIMESTAMPS_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: refnum.
*/
   static public tilda.data_test.TestingTimestamps_Data lookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj = new tilda.data_test.TestingTimestamps_Data();
       Obj.initForLookup(0);

       Obj.setRefnum     (refnum     ); Obj.__Saved_refnum      = Obj._refnum     ;

       return (tilda.data_test.TestingTimestamps_Data) Obj;
     }

/**
Lookup records by the index 'AllByName' over  .<BR>The results are ordered by: id asc
*/
   static public ListResults<tilda.data_test.TestingTimestamps_Data> lookupWhereAllByName(Connection C, int __start__, int __size__) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj = new tilda.data_test.TestingTimestamps_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, __start__);
       readMany(C, 1, RPI, Obj, null, __start__, __size__);
       return RPI._L;
     }

/**
Lookup records by the index 'AllByName' over  .<BR>The results are ordered by: id asc
*/
   static public void lookupWhereAllByName(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.TestingTimestamps_Data> OP, int __start__, int __size__) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj = new tilda.data_test.TestingTimestamps_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, __start__, __size__);
     }



/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: refnum asc
*/   static public ListResults<tilda.data_test.TestingTimestamps_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj = new tilda.data_test.TestingTimestamps_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 2, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: refnum asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.TestingTimestamps_Data> OP, int start, int size) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj = new tilda.data_test.TestingTimestamps_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, start, size);
     }










   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data_test.TestingTimestamps_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data_test.TestingTimestamps_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


   public static void toJSONAAA(java.io.Writer out, List<tilda.data_test.TestingTimestamps_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data_test.TestingTimestamps_Data O : L)
       if (O!=null)
        {
          out.write(lead);
          toJSONAAA(out, O, First == true ? "   " : "  ,", true);
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

   public static void toJSONAAA(java.io.Writer out, tilda.data_test.TestingTimestamps_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSONAAA(out, obj, "", fullObject, false);
    }

   public static void toJSONAAA(java.io.Writer out, tilda.data_test.TestingTimestamps_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSONAAA(out, obj, lead, fullObject, false);
    }

   public static void toJSONAAA(java.io.Writer outWriter, tilda.data_test.TestingTimestamps_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj = (tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "refnum", ++i==0, Obj.getRefnum());

        JSONUtil.print(out, "id", ++i==0, Obj.getId());

      if (Obj.isNullDt1TZ() == false && Obj.getDt1TZ() != null)
        JSONUtil.print(out, "dt1TZ", ++i==0, Obj.getDt1TZ());

      if (Obj.isNullDt1() == false && Obj.getDt1() != null)
        JSONUtil.print(out, "dt1", ++i==0, Obj.getDt1());

      if (Obj.isNullDt1nTZ() == false && Obj.getDt1nTZ() != null)
        JSONUtil.print(out, "dt1nTZ", ++i==0, Obj.getDt1nTZ());

      if (Obj.isNullDt1n() == false && Obj.getDt1n() != null)
        JSONUtil.print(out, "dt1n", ++i==0, Obj.getDt1n());

      if (Obj.isNullDt1uTZ() == false && Obj.getDt1uTZ() != null)
        JSONUtil.print(out, "dt1uTZ", ++i==0, Obj.getDt1uTZ());

      if (Obj.isNullDt1u() == false && Obj.getDt1u() != null)
        JSONUtil.print(out, "dt1u", ++i==0, Obj.getDt1u());

      if (Obj.isNullDt1aTZ() == false && Obj.getDt1aTZ() != null)
        JSONUtil.print(out, "dt1aTZ", ++i==0, Obj.getDt1aTZAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt1aTZ", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt1a() == false && Obj.getDt1a() != null)
        JSONUtil.print(out, "dt1a", ++i==0, Obj.getDt1aAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt1a", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullRowTZ() == false && Obj.getRowTZ() != null)
        JSONUtil.print(out, "rowTZ", ++i==0, Obj.getRowTZ());

      if (Obj.isNullDt2() == false && Obj.getDt2() != null)
        JSONUtil.print(out, "dt2", ++i==0, Obj.getDt2());

      if (Obj.isNullDt2n() == false && Obj.getDt2n() != null)
        JSONUtil.print(out, "dt2n", ++i==0, Obj.getDt2n());

      if (Obj.isNullDt2u() == false && Obj.getDt2u() != null)
        JSONUtil.print(out, "dt2u", ++i==0, Obj.getDt2u());

      if (Obj.isNullDt2a() == false && Obj.getDt2a() != null)
        JSONUtil.print(out, "dt2a", ++i==0, Obj.getDt2aAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt2a", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt3TZ() == false && Obj.getDt3TZ() != null)
        JSONUtil.print(out, "dt3TZ", ++i==0, Obj.getDt3TZ());

      if (Obj.isNullDt3() == false && Obj.getDt3() != null)
        JSONUtil.print(out, "dt3", ++i==0, Obj.getDt3());

      if (Obj.isNullDt3nTZ() == false && Obj.getDt3nTZ() != null)
        JSONUtil.print(out, "dt3nTZ", ++i==0, Obj.getDt3nTZ());

      if (Obj.isNullDt3n() == false && Obj.getDt3n() != null)
        JSONUtil.print(out, "dt3n", ++i==0, Obj.getDt3n());

      if (Obj.isNullDt3uTZ() == false && Obj.getDt3uTZ() != null)
        JSONUtil.print(out, "dt3uTZ", ++i==0, Obj.getDt3uTZ());

      if (Obj.isNullDt3u() == false && Obj.getDt3u() != null)
        JSONUtil.print(out, "dt3u", ++i==0, Obj.getDt3u());

      if (Obj.isNullDt3aTZ() == false && Obj.getDt3aTZ() != null)
        JSONUtil.print(out, "dt3aTZ", ++i==0, Obj.getDt3aTZAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt3aTZ", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt3a() == false && Obj.getDt3a() != null)
        JSONUtil.print(out, "dt3a", ++i==0, Obj.getDt3aAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt3a", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt4() == false && Obj.getDt4() != null)
        JSONUtil.print(out, "dt4", ++i==0, Obj.getDt4());

      if (Obj.isNullDt4n() == false && Obj.getDt4n() != null)
        JSONUtil.print(out, "dt4n", ++i==0, Obj.getDt4n());

      if (Obj.isNullDt4u() == false && Obj.getDt4u() != null)
        JSONUtil.print(out, "dt4u", ++i==0, Obj.getDt4u());

      if (Obj.isNullDt4a() == false && Obj.getDt4a() != null)
        JSONUtil.print(out, "dt4a", ++i==0, Obj.getDt4aAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt4a", ++i==0);
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

   public static String getCSVHeader()
    {
      return "\"refnum\",\"id\",\"dt1TZ\",\"dt1\",\"dt1nTZ\",\"dt1n\",\"dt1uTZ\",\"dt1u\",\"dt1aTZ\",\"dt1a\",\"rowTZ\",\"dt2\",\"dt2n\",\"dt2u\",\"dt2a\",\"dt3TZ\",\"dt3\",\"dt3nTZ\",\"dt3n\",\"dt3uTZ\",\"dt3u\",\"dt3aTZ\",\"dt3a\",\"dt4\",\"dt4n\",\"dt4u\",\"dt4a\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data_test.TestingTimestamps_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data_test.TestingTimestamps_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data_test.TestingTimestamps_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj = (tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getId());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDt1TZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt1()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDt1nTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt1n()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDt1uTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt1u()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDt1aTZ(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDt1a(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getRowTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt2()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt2n()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt2u()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDt2a(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDt3TZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt3()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDt3nTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt3n()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDt3uTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt3u()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDt3aTZ(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDt3a(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt4()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt4n()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDt4u()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, TextUtil.print(Obj.getDt4a(), ","));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data_test.TestingTimestamps_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data_test.TestingTimestamps_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data_test.TestingTimestamps_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data_test.TestingTimestamps_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data_test.TestingTimestamps_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS Obj = (tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "refnum", ++i==0, Obj.getRefnum());

        JSONUtil.print(out, "id", ++i==0, Obj.getId());

      if (Obj.isNullDt1TZ() == false && Obj.getDt1TZ() != null)
        JSONUtil.print(out, "dt1TZ", ++i==0, Obj.getDt1TZ());

      if (Obj.isNullDt1() == false && Obj.getDt1() != null)
        JSONUtil.print(out, "dt1", ++i==0, Obj.getDt1());

      if (Obj.isNullDt1nTZ() == false && Obj.getDt1nTZ() != null)
        JSONUtil.print(out, "dt1nTZ", ++i==0, Obj.getDt1nTZ());

      if (Obj.isNullDt1n() == false && Obj.getDt1n() != null)
        JSONUtil.print(out, "dt1n", ++i==0, Obj.getDt1n());

      if (Obj.isNullDt1uTZ() == false && Obj.getDt1uTZ() != null)
        JSONUtil.print(out, "dt1uTZ", ++i==0, Obj.getDt1uTZ());

      if (Obj.isNullDt1u() == false && Obj.getDt1u() != null)
        JSONUtil.print(out, "dt1u", ++i==0, Obj.getDt1u());

      if (Obj.isNullDt1aTZ() == false && Obj.getDt1aTZ() != null)
        JSONUtil.print(out, "dt1aTZ", ++i==0, Obj.getDt1aTZAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt1aTZ", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt1a() == false && Obj.getDt1a() != null)
        JSONUtil.print(out, "dt1a", ++i==0, Obj.getDt1aAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt1a", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullRowTZ() == false && Obj.getRowTZ() != null)
        JSONUtil.print(out, "rowTZ", ++i==0, Obj.getRowTZ());

      if (Obj.isNullDt2() == false && Obj.getDt2() != null)
        JSONUtil.print(out, "dt2", ++i==0, Obj.getDt2());

      if (Obj.isNullDt2n() == false && Obj.getDt2n() != null)
        JSONUtil.print(out, "dt2n", ++i==0, Obj.getDt2n());

      if (Obj.isNullDt2u() == false && Obj.getDt2u() != null)
        JSONUtil.print(out, "dt2u", ++i==0, Obj.getDt2u());

      if (Obj.isNullDt2a() == false && Obj.getDt2a() != null)
        JSONUtil.print(out, "dt2a", ++i==0, Obj.getDt2aAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt2a", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt3TZ() == false && Obj.getDt3TZ() != null)
        JSONUtil.print(out, "dt3TZ", ++i==0, Obj.getDt3TZ());

      if (Obj.isNullDt3() == false && Obj.getDt3() != null)
        JSONUtil.print(out, "dt3", ++i==0, Obj.getDt3());

      if (Obj.isNullDt3nTZ() == false && Obj.getDt3nTZ() != null)
        JSONUtil.print(out, "dt3nTZ", ++i==0, Obj.getDt3nTZ());

      if (Obj.isNullDt3n() == false && Obj.getDt3n() != null)
        JSONUtil.print(out, "dt3n", ++i==0, Obj.getDt3n());

      if (Obj.isNullDt3uTZ() == false && Obj.getDt3uTZ() != null)
        JSONUtil.print(out, "dt3uTZ", ++i==0, Obj.getDt3uTZ());

      if (Obj.isNullDt3u() == false && Obj.getDt3u() != null)
        JSONUtil.print(out, "dt3u", ++i==0, Obj.getDt3u());

      if (Obj.isNullDt3aTZ() == false && Obj.getDt3aTZ() != null)
        JSONUtil.print(out, "dt3aTZ", ++i==0, Obj.getDt3aTZAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt3aTZ", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt3a() == false && Obj.getDt3a() != null)
        JSONUtil.print(out, "dt3a", ++i==0, Obj.getDt3aAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt3a", ++i==0);
          out.write("[]");
        }

      if (Obj.isNullDt4() == false && Obj.getDt4() != null)
        JSONUtil.print(out, "dt4", ++i==0, Obj.getDt4());

      if (Obj.isNullDt4n() == false && Obj.getDt4n() != null)
        JSONUtil.print(out, "dt4n", ++i==0, Obj.getDt4n());

      if (Obj.isNullDt4u() == false && Obj.getDt4u() != null)
        JSONUtil.print(out, "dt4u", ++i==0, Obj.getDt4u());

      if (Obj.isNullDt4a() == false && Obj.getDt4a() != null)
        JSONUtil.print(out, "dt4a", ++i==0, Obj.getDt4aAsArray());
      else if (noNullArrays == true)
        {
          JSONUtil.print(out, "dt4a", ++i==0);
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

 }
