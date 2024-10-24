
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
public class TILDA__TRANSPERF_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TRANSPERF_Factory.class.getName());

   protected TILDA__TRANSPERF_Factory() { }

   public static final Class<TILDA__TRANSPERF> DATA_CLASS= TILDA__TRANSPERF.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("TransPerf", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.TransPerf", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "TransPerf"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.startPeriodTZ -> TILDA.TransPerf."startPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startPeriodTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'startPeriod'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.startPeriodTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.startPeriodTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              STARTPERIODTZ         = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "startPeriodTZ"         , 0/*0*/, 5, "Generated helper column to hold the time zone ID for 'startPeriod'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.startPeriod -> TILDA.TransPerf."startPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>startPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.startPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.startPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'startPeriodTZ'</LI>
</TD></TR>

</TABLE>
*/
     public final Type_DatetimePrimitive            STARTPERIOD           = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "startPeriod"           , 1/*1*/, "The timestamp for when the record was created.", null, null, STARTPERIODTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.endPeriodTZ -> TILDA.TransPerf."endPeriodTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriodTZ of type String</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'endPeriod'.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriodTZ of type character(5)</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriodTZ</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive              ENDPERIODTZ           = new Type_StringPrimitive             (SCHEMA_LABEL, TABLENAME_LABEL, "endPeriodTZ"           , 2/*2*/, 5, "Generated helper column to hold the time zone ID for 'endPeriod'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.endPeriod -> TILDA.TransPerf."endPeriod"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>endPeriod of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.endPeriod of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.endPeriod</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>TZMode</B></TD><TD><UL>
<LI>Stored as a timestamp with timezone</LI>
<LI>Timezone information stored in 'endPeriodTZ'</LI>
</TD></TR>

</TABLE>
*/
     public final Type_DatetimePrimitive            ENDPERIOD             = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "endPeriod"             , 3/*3*/, "The timestamp for when the record was created.", null, null, ENDPERIODTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.commitNano -> TILDA.TransPerf."commitNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>commitNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.commitNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.commitNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                COMMITNANO            = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "commitNano"            , 4/*4*/, "Blah...", null, null, new String[][] {{"0","commitNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.commitCount -> TILDA.TransPerf."commitCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>commitCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.commitCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.commitCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>commitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>commitCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             COMMITCOUNT           = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "commitCount"           , 5/*5*/, "Blah...", null, null, new String[][] {{"0","commitCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.rollbackNano -> TILDA.TransPerf."rollbackNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rollbackNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.rollbackNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.rollbackNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                ROLLBACKNANO          = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "rollbackNano"          , 6/*6*/, "Blah...", null, null, new String[][] {{"0","rollbackNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.rollbackCount -> TILDA.TransPerf."rollbackCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>rollbackCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.rollbackCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.rollbackCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>rollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>rollbackCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             ROLLBACKCOUNT         = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "rollbackCount"         , 7/*7*/, "Blah...", null, null, new String[][] {{"0","rollbackCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointSetNano -> TILDA.TransPerf."savepointSetNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointSetNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointSetNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointSetNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                SAVEPOINTSETNANO      = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "savepointSetNano"      , 8/*8*/, "Blah...", null, null, new String[][] {{"0","savepointSetNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointSetCount -> TILDA.TransPerf."savepointSetCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointSetCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointSetCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointSetCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointSetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointSetCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             SAVEPOINTSETCOUNT     = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "savepointSetCount"     , 9/*9*/, "Blah...", null, null, new String[][] {{"0","savepointSetCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointCommitNano -> TILDA.TransPerf."savepointCommitNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointCommitNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointCommitNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointCommitNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                SAVEPOINTCOMMITNANO   = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "savepointCommitNano"   , 10/*10*/, "Blah...", null, null, new String[][] {{"0","savepointCommitNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointCommitCount -> TILDA.TransPerf."savepointCommitCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointCommitCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointCommitCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointCommitCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointCommitCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointCommitCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             SAVEPOINTCOMMITCOUNT  = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "savepointCommitCount"  , 11/*11*/, "Blah...", null, null, new String[][] {{"0","savepointCommitCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointRollbackNano -> TILDA.TransPerf."savepointRollbackNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointRollbackNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointRollbackNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointRollbackNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                SAVEPOINTROLLBACKNANO = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "savepointRollbackNano" , 12/*12*/, "Blah...", null, null, new String[][] {{"0","savepointRollbackNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.savepointRollbackCount -> TILDA.TransPerf."savepointRollbackCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>savepointRollbackCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.savepointRollbackCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.savepointRollbackCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>savepointRollbackCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>savepointRollbackCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             SAVEPOINTROLLBACKCOUNT= new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "savepointRollbackCount", 13/*13*/, "Blah...", null, null, new String[][] {{"0","savepointRollbackCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.statementCloseNano -> TILDA.TransPerf."statementCloseNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>statementCloseNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.statementCloseNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.statementCloseNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                STATEMENTCLOSENANO    = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "statementCloseNano"    , 14/*14*/, "Blah...", null, null, new String[][] {{"0","statementCloseNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.statementCloseCount -> TILDA.TransPerf."statementCloseCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>statementCloseCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.statementCloseCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.statementCloseCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>statementCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>statementCloseCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             STATEMENTCLOSECOUNT   = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "statementCloseCount"   , 15/*15*/, "Blah...", null, null, new String[][] {{"0","statementCloseCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionCloseNano -> TILDA.TransPerf."connectionCloseNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionCloseNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionCloseNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionCloseNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                CONNECTIONCLOSENANO   = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "connectionCloseNano"   , 16/*16*/, "Blah...", null, null, new String[][] {{"0","connectionCloseNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionCloseCount -> TILDA.TransPerf."connectionCloseCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionCloseCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionCloseCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionCloseCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionCloseCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionCloseCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             CONNECTIONCLOSECOUNT  = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "connectionCloseCount"  , 17/*17*/, "Blah...", null, null, new String[][] {{"0","connectionCloseCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionGetNano -> TILDA.TransPerf."connectionGetNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionGetNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionGetNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionGetNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                CONNECTIONGETNANO     = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "connectionGetNano"     , 18/*18*/, "Blah...", null, null, new String[][] {{"0","connectionGetNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.connectionGetCount -> TILDA.TransPerf."connectionGetCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>connectionGetCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.connectionGetCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.connectionGetCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>connectionGetCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>connectionGetCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             CONNECTIONGETCOUNT    = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "connectionGetCount"    , 19/*19*/, "Blah...", null, null, new String[][] {{"0","connectionGetCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaSetterNano -> TILDA.TransPerf."tildaSetterNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaSetterNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaSetterNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaSetterNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                TILDASETTERNANO       = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "tildaSetterNano"       , 20/*20*/, "Blah...", null, null, new String[][] {{"0","tildaSetterNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaSetterCount -> TILDA.TransPerf."tildaSetterCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaSetterCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaSetterCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaSetterCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaSetterCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaSetterCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             TILDASETTERCOUNT      = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "tildaSetterCount"      , 21/*21*/, "Blah...", null, null, new String[][] {{"0","tildaSetterCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToStringNano -> TILDA.TransPerf."tildaToStringNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToStringNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToStringNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToStringNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                TILDATOSTRINGNANO     = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "tildaToStringNano"     , 22/*22*/, "Blah...", null, null, new String[][] {{"0","tildaToStringNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToStringCount -> TILDA.TransPerf."tildaToStringCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToStringCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToStringCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToStringCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToStringCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToStringCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             TILDATOSTRINGCOUNT    = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "tildaToStringCount"    , 23/*23*/, "Blah...", null, null, new String[][] {{"0","tildaToStringCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToJsonNano -> TILDA.TransPerf."tildaToJsonNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToJsonNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToJsonNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToJsonNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                TILDATOJSONNANO       = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "tildaToJsonNano"       , 24/*24*/, "Blah...", null, null, new String[][] {{"0","tildaToJsonNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToJsonCount -> TILDA.TransPerf."tildaToJsonCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToJsonCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToJsonCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToJsonCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToJsonCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToJsonCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             TILDATOJSONCOUNT      = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "tildaToJsonCount"      , 25/*25*/, "Blah...", null, null, new String[][] {{"0","tildaToJsonCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToCsvNano -> TILDA.TransPerf."tildaToCsvNano"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToCsvNano of type long</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToCsvNano of type bigint</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToCsvNano</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvNano_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvNano_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_LongPrimitive                TILDATOCSVNANO        = new Type_LongPrimitive               (SCHEMA_LABEL, TABLENAME_LABEL, "tildaToCsvNano"        , 26/*26*/, "Blah...", null, null, new String[][] {{"0","tildaToCsvNano_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.tildaToCsvCount -> TILDA.TransPerf."tildaToCsvCount"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tildaToCsvCount of type int</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Blah...</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.tildaToCsvCount of type integer</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.tildaToCsvCount</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Values</B></TD><TD>

<TABLE border="0px" cellpadding="2px" cellspacing="0px">   <TR align="left"><TH>&nbsp;</TH><TH align="right">Name&nbsp;&nbsp;</TH><TH>Value&nbsp;&nbsp;</TH><TH>Label&nbsp;&nbsp;</TH><TH>Default&nbsp;&nbsp;</TH><TH>Groupings&nbsp;&nbsp;</TH><TH>Description</TH></TR>
  <TR bgcolor="#FFFFFF"><TD>0&nbsp;&nbsp;</TD><TD align="right"><B>tildaToCsvCount_CreateDefault</B>&nbsp;&nbsp;</TD><TD>0&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault&nbsp;&nbsp;</TD><TD>CREATE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>tildaToCsvCount_CreateDefault</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public final Type_IntegerPrimitive             TILDATOCSVCOUNT       = new Type_IntegerPrimitive            (SCHEMA_LABEL, TABLENAME_LABEL, "tildaToCsvCount"       , 27/*27*/, "Blah...", null, null, new String[][] {{"0","tildaToCsvCount_CreateDefault"}});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.created -> TILDA.TransPerf."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>created of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.TransPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.created of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.created</TD></TR>

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
     public final Type_DatetimePrimitive            CREATED               = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "created"               , 28/*28*/, "The timestamp for when the record was created. (TILDA.TransPerf)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.lastUpdated -> TILDA.TransPerf."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>lastUpdated of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.TransPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.lastUpdated of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.lastUpdated</TD></TR>

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
     public final Type_DatetimePrimitive            LASTUPDATED           = new Type_DatetimePrimitive           (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"           , 29/*29*/, "The timestamp for when the record was last updated. (TILDA.TransPerf)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.TransPerf.deleted -> TILDA.TransPerf."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>deleted of type ZonedDateTime</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.TransPerf)</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.TransPerf.deleted of type timestamptz</TD></TR>
  <TR><TD align="right"><B>Full Name</B></TD><TD>tilda.data.TILDA.TransPerf.deleted</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull        DELETED               = new Type_DatetimePrimitiveNull       (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"               , 30/*30*/, "The timestamp for when the record was deleted. (TILDA.TransPerf)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.STARTPERIODTZ,COLS.STARTPERIOD,COLS.ENDPERIODTZ,COLS.ENDPERIOD,COLS.COMMITNANO,COLS.COMMITCOUNT,COLS.ROLLBACKNANO,COLS.ROLLBACKCOUNT,COLS.SAVEPOINTSETNANO,COLS.SAVEPOINTSETCOUNT,COLS.SAVEPOINTCOMMITNANO,COLS.SAVEPOINTCOMMITCOUNT,COLS.SAVEPOINTROLLBACKNANO,COLS.SAVEPOINTROLLBACKCOUNT,COLS.STATEMENTCLOSENANO,COLS.STATEMENTCLOSECOUNT,COLS.CONNECTIONCLOSENANO,COLS.CONNECTIONCLOSECOUNT,COLS.CONNECTIONGETNANO,COLS.CONNECTIONGETCOUNT,COLS.TILDASETTERNANO,COLS.TILDASETTERCOUNT,COLS.TILDATOSTRINGNANO,COLS.TILDATOSTRINGCOUNT,COLS.TILDATOJSONNANO,COLS.TILDATOJSONCOUNT,COLS.TILDATOCSVNANO,COLS.TILDATOCSVCOUNT,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.STARTPERIOD };

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
           tilda.data.TransPerf_Factory.init(C);
        }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.TransPerf_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.TransPerf_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.TransPerf_Data> _OP;
       protected ArrayListResults<tilda.data.TransPerf_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.TransPerf_Data Obj = new tilda.data.TransPerf_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__TRANSPERF)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.TransPerf_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__TRANSPERF Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__TRANSPERF_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "TransPerf");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "TransPerf", "startPeriod"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDA.TransPerf", Q, null);
       java.sql.PreparedStatement PS=null;
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
             case 1: { // Query 'All'
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
          tilda.data._Tilda.TILDA__2_5.handleFinally(PS, T0, TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
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
   static public tilda.data.TransPerf_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       String[] vals = null;

       vals = Values.get("startPeriod");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("startPeriod", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _startPeriod = ParseUtil.parseZonedDateTime("startPeriod", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_startPeriod != null) Obj.setStartPeriod(_startPeriod);

       vals = Values.get("endPeriod");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("endPeriod", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _endPeriod = ParseUtil.parseZonedDateTime("endPeriod", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_endPeriod != null) Obj.setEndPeriod(_endPeriod);

       vals = Values.get("commitNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("commitNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _commitNano = ParseUtil.parseLong("commitNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_commitNano != null) Obj.setCommitNano(_commitNano);

       vals = Values.get("commitCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("commitCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _commitCount = ParseUtil.parseInteger("commitCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_commitCount != null) Obj.setCommitCount(_commitCount);

       vals = Values.get("rollbackNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("rollbackNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _rollbackNano = ParseUtil.parseLong("rollbackNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_rollbackNano != null) Obj.setRollbackNano(_rollbackNano);

       vals = Values.get("rollbackCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("rollbackCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _rollbackCount = ParseUtil.parseInteger("rollbackCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_rollbackCount != null) Obj.setRollbackCount(_rollbackCount);

       vals = Values.get("savepointSetNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("savepointSetNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _savepointSetNano = ParseUtil.parseLong("savepointSetNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_savepointSetNano != null) Obj.setSavepointSetNano(_savepointSetNano);

       vals = Values.get("savepointSetCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("savepointSetCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _savepointSetCount = ParseUtil.parseInteger("savepointSetCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_savepointSetCount != null) Obj.setSavepointSetCount(_savepointSetCount);

       vals = Values.get("savepointCommitNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("savepointCommitNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _savepointCommitNano = ParseUtil.parseLong("savepointCommitNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_savepointCommitNano != null) Obj.setSavepointCommitNano(_savepointCommitNano);

       vals = Values.get("savepointCommitCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("savepointCommitCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _savepointCommitCount = ParseUtil.parseInteger("savepointCommitCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_savepointCommitCount != null) Obj.setSavepointCommitCount(_savepointCommitCount);

       vals = Values.get("savepointRollbackNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("savepointRollbackNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _savepointRollbackNano = ParseUtil.parseLong("savepointRollbackNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_savepointRollbackNano != null) Obj.setSavepointRollbackNano(_savepointRollbackNano);

       vals = Values.get("savepointRollbackCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("savepointRollbackCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _savepointRollbackCount = ParseUtil.parseInteger("savepointRollbackCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_savepointRollbackCount != null) Obj.setSavepointRollbackCount(_savepointRollbackCount);

       vals = Values.get("statementCloseNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("statementCloseNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _statementCloseNano = ParseUtil.parseLong("statementCloseNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_statementCloseNano != null) Obj.setStatementCloseNano(_statementCloseNano);

       vals = Values.get("statementCloseCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("statementCloseCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _statementCloseCount = ParseUtil.parseInteger("statementCloseCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_statementCloseCount != null) Obj.setStatementCloseCount(_statementCloseCount);

       vals = Values.get("connectionCloseNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("connectionCloseNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _connectionCloseNano = ParseUtil.parseLong("connectionCloseNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_connectionCloseNano != null) Obj.setConnectionCloseNano(_connectionCloseNano);

       vals = Values.get("connectionCloseCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("connectionCloseCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _connectionCloseCount = ParseUtil.parseInteger("connectionCloseCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_connectionCloseCount != null) Obj.setConnectionCloseCount(_connectionCloseCount);

       vals = Values.get("connectionGetNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("connectionGetNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _connectionGetNano = ParseUtil.parseLong("connectionGetNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_connectionGetNano != null) Obj.setConnectionGetNano(_connectionGetNano);

       vals = Values.get("connectionGetCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("connectionGetCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _connectionGetCount = ParseUtil.parseInteger("connectionGetCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_connectionGetCount != null) Obj.setConnectionGetCount(_connectionGetCount);

       vals = Values.get("tildaSetterNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("tildaSetterNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _tildaSetterNano = ParseUtil.parseLong("tildaSetterNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_tildaSetterNano != null) Obj.setTildaSetterNano(_tildaSetterNano);

       vals = Values.get("tildaSetterCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("tildaSetterCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _tildaSetterCount = ParseUtil.parseInteger("tildaSetterCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_tildaSetterCount != null) Obj.setTildaSetterCount(_tildaSetterCount);

       vals = Values.get("tildaToStringNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("tildaToStringNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _tildaToStringNano = ParseUtil.parseLong("tildaToStringNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_tildaToStringNano != null) Obj.setTildaToStringNano(_tildaToStringNano);

       vals = Values.get("tildaToStringCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("tildaToStringCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _tildaToStringCount = ParseUtil.parseInteger("tildaToStringCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_tildaToStringCount != null) Obj.setTildaToStringCount(_tildaToStringCount);

       vals = Values.get("tildaToJsonNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("tildaToJsonNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _tildaToJsonNano = ParseUtil.parseLong("tildaToJsonNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_tildaToJsonNano != null) Obj.setTildaToJsonNano(_tildaToJsonNano);

       vals = Values.get("tildaToJsonCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("tildaToJsonCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _tildaToJsonCount = ParseUtil.parseInteger("tildaToJsonCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_tildaToJsonCount != null) Obj.setTildaToJsonCount(_tildaToJsonCount);

       vals = Values.get("tildaToCsvNano");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("tildaToCsvNano", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _tildaToCsvNano = ParseUtil.parseLong("tildaToCsvNano", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_tildaToCsvNano != null) Obj.setTildaToCsvNano(_tildaToCsvNano);

       vals = Values.get("tildaToCsvCount");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("tildaToCsvCount", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _tildaToCsvCount = ParseUtil.parseInteger("tildaToCsvCount", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_tildaToCsvCount != null) Obj.setTildaToCsvCount(_tildaToCsvCount);


       return (tilda.data.TransPerf_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param startPeriod            The timestamp for when the record was created.
 @param endPeriod              The timestamp for when the record was created.
*/
   static public tilda.data.TransPerf_Data create(ZonedDateTime startPeriod, ZonedDateTime endPeriod) throws Exception
     {
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setStartPeriod           (startPeriod           );
       Obj.setEndPeriod             (endPeriod             );

       // Default Create-time setters
       Obj.setCommitNanoCommitNano_CreateDefault                        ();
       Obj.setCommitCountCommitCount_CreateDefault                      ();
       Obj.setRollbackNanoRollbackNano_CreateDefault                    ();
       Obj.setRollbackCountRollbackCount_CreateDefault                  ();
       Obj.setSavepointSetNanoSavepointSetNano_CreateDefault            ();
       Obj.setSavepointSetCountSavepointSetCount_CreateDefault          ();
       Obj.setSavepointCommitNanoSavepointCommitNano_CreateDefault      ();
       Obj.setSavepointCommitCountSavepointCommitCount_CreateDefault    ();
       Obj.setSavepointRollbackNanoSavepointRollbackNano_CreateDefault  ();
       Obj.setSavepointRollbackCountSavepointRollbackCount_CreateDefault();
       Obj.setStatementCloseNanoStatementCloseNano_CreateDefault        ();
       Obj.setStatementCloseCountStatementCloseCount_CreateDefault      ();
       Obj.setConnectionCloseNanoConnectionCloseNano_CreateDefault      ();
       Obj.setConnectionCloseCountConnectionCloseCount_CreateDefault    ();
       Obj.setConnectionGetNanoConnectionGetNano_CreateDefault          ();
       Obj.setConnectionGetCountConnectionGetCount_CreateDefault        ();
       Obj.setTildaSetterNanoTildaSetterNano_CreateDefault              ();
       Obj.setTildaSetterCountTildaSetterCount_CreateDefault            ();
       Obj.setTildaToStringNanoTildaToStringNano_CreateDefault          ();
       Obj.setTildaToStringCountTildaToStringCount_CreateDefault        ();
       Obj.setTildaToJsonNanoTildaToJsonNano_CreateDefault              ();
       Obj.setTildaToJsonCountTildaToJsonCount_CreateDefault            ();
       Obj.setTildaToCsvNanoTildaToCsvNano_CreateDefault                ();
       Obj.setTildaToCsvCountTildaToCsvCount_CreateDefault              ();
       Obj.setCreatedNow                                                ();
       Obj.setLastUpdatedNow                                            ();

       return (tilda.data.TransPerf_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data.TransPerf_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__TRANSPERF lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__TRANSPERF) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__TRANSPERF) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.TransPerf_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__TRANSPERF) d);

               if (((TILDA__TRANSPERF) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.TransPerf_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__TRANSPERF) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.TransPerf_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__TRANSPERF) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.TransPerf_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__TRANSPERF) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.TransPerf_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.TransPerf_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'TransPerf_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__2_5.handleFinally(PS, T0, TILDA__TRANSPERF_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: startPeriod.
*/
   static public tilda.data.TransPerf_Data lookupByPrimaryKey(ZonedDateTime startPeriod) throws Exception
     {
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(0);

       Obj.setStartPeriod           (startPeriod           ); Obj.__Saved_startPeriod            = Obj._startPeriod           ;

       return (tilda.data.TransPerf_Data) Obj;
     }

/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: startPeriod asc
*/   static public ListResults<tilda.data.TransPerf_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: startPeriod asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.TransPerf_Data> OP, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__TRANSPERF Obj = new tilda.data.TransPerf_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }





   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.TransPerf_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       if (Q.isFullSelectQuery() == true)
        readMany(C, -77, RPI, null, Q.toString(), start, size);
       else
        readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.TransPerf_Data> OP, int start, int size) throws Exception
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
      return "\"startPeriodTZ\",\"startPeriod\",\"endPeriodTZ\",\"endPeriod\",\"commitNano\",\"commitCount\",\"rollbackNano\",\"rollbackCount\",\"savepointSetNano\",\"savepointSetCount\",\"savepointCommitNano\",\"savepointCommitCount\",\"savepointRollbackNano\",\"savepointRollbackCount\",\"statementCloseNano\",\"statementCloseCount\",\"connectionCloseNano\",\"connectionCloseCount\",\"connectionGetNano\",\"connectionGetCount\",\"tildaSetterNano\",\"tildaSetterCount\",\"tildaToStringNano\",\"tildaToStringCount\",\"tildaToJsonNano\",\"tildaToJsonCount\",\"tildaToCsvNano\",\"tildaToCsvCount\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.TransPerf_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.TransPerf_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.TransPerf_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data._Tilda.TILDA__TRANSPERF Obj = (tilda.data._Tilda.TILDA__TRANSPERF) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getStartPeriodTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getStartPeriod()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getEndPeriodTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getEndPeriod()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getCommitNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getCommitCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getRollbackNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getRollbackCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getSavepointSetNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getSavepointSetCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getSavepointCommitNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getSavepointCommitCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getSavepointRollbackNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getSavepointRollbackCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getStatementCloseNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getStatementCloseCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getConnectionCloseNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getConnectionCloseCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getConnectionGetNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getConnectionGetCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTildaSetterNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTildaSetterCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTildaToStringNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTildaToStringCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTildaToJsonNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTildaToJsonCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTildaToCsvNano());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getTildaToCsvCount());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.TransPerf_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data.TransPerf_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data.TransPerf_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.TransPerf_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.TransPerf_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data._Tilda.TILDA__TRANSPERF Obj = (tilda.data._Tilda.TILDA__TRANSPERF) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
        JSONUtil.print(out, "startPeriodTZ", ++i==0, Obj.getStartPeriodTZ());

        JSONUtil.print(out, "startPeriod", ++i==0, Obj.getStartPeriod());

        JSONUtil.print(out, "endPeriodTZ", ++i==0, Obj.getEndPeriodTZ());

        JSONUtil.print(out, "endPeriod", ++i==0, Obj.getEndPeriod());

        JSONUtil.print(out, "commitNano", ++i==0, Obj.getCommitNano());

        JSONUtil.print(out, "commitCount", ++i==0, Obj.getCommitCount());

        JSONUtil.print(out, "rollbackNano", ++i==0, Obj.getRollbackNano());

        JSONUtil.print(out, "rollbackCount", ++i==0, Obj.getRollbackCount());

        JSONUtil.print(out, "savepointSetNano", ++i==0, Obj.getSavepointSetNano());

        JSONUtil.print(out, "savepointSetCount", ++i==0, Obj.getSavepointSetCount());

        JSONUtil.print(out, "savepointCommitNano", ++i==0, Obj.getSavepointCommitNano());

        JSONUtil.print(out, "savepointCommitCount", ++i==0, Obj.getSavepointCommitCount());

        JSONUtil.print(out, "savepointRollbackNano", ++i==0, Obj.getSavepointRollbackNano());

        JSONUtil.print(out, "savepointRollbackCount", ++i==0, Obj.getSavepointRollbackCount());

        JSONUtil.print(out, "statementCloseNano", ++i==0, Obj.getStatementCloseNano());

        JSONUtil.print(out, "statementCloseCount", ++i==0, Obj.getStatementCloseCount());

        JSONUtil.print(out, "connectionCloseNano", ++i==0, Obj.getConnectionCloseNano());

        JSONUtil.print(out, "connectionCloseCount", ++i==0, Obj.getConnectionCloseCount());

        JSONUtil.print(out, "connectionGetNano", ++i==0, Obj.getConnectionGetNano());

        JSONUtil.print(out, "connectionGetCount", ++i==0, Obj.getConnectionGetCount());

        JSONUtil.print(out, "tildaSetterNano", ++i==0, Obj.getTildaSetterNano());

        JSONUtil.print(out, "tildaSetterCount", ++i==0, Obj.getTildaSetterCount());

        JSONUtil.print(out, "tildaToStringNano", ++i==0, Obj.getTildaToStringNano());

        JSONUtil.print(out, "tildaToStringCount", ++i==0, Obj.getTildaToStringCount());

        JSONUtil.print(out, "tildaToJsonNano", ++i==0, Obj.getTildaToJsonNano());

        JSONUtil.print(out, "tildaToJsonCount", ++i==0, Obj.getTildaToJsonCount());

        JSONUtil.print(out, "tildaToCsvNano", ++i==0, Obj.getTildaToCsvNano());

        JSONUtil.print(out, "tildaToCsvCount", ++i==0, Obj.getTildaToCsvCount());

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
