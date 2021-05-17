
package tilda.data_test._Tilda;

import java.math.*;
import java.util.*;
import java.time.*;

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
public class TILDA__TESTING2REALIZED_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTING2REALIZED_Factory.class.getName());

   protected TILDA__TESTING2REALIZED_Factory() { }

   public static final Class<TILDA__TESTING2REALIZED> DATA_CLASS= TILDA__TESTING2REALIZED.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATEST", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Testing2Realized", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATEST.Testing2Realized", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATEST", "Testing2Realized"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.refnum -> TILDATEST.Testing2Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record (from TILDATEST.Testing2View.refnum)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitiveNull      REFNUM        = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"        , 0/*0*/, "The primary key for this record (from TILDATEST.Testing2View.refnum)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.name -> TILDATEST.Testing2Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id (from TILDATEST.Testing2View.name)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    NAME          = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "name"          , 1/*1*/, "Medical system unique enterprise id (from TILDATEST.Testing2View.name)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.lastUpdated -> TILDATEST.Testing2Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing2View.lastUpdated)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  LASTUPDATED   = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"   , 2/*2*/, "The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing2View.lastUpdated)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.xxxLastUpdated -> TILDATEST.Testing2Realized."xxxLastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.xxxLastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.xxxLastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing2View.xxxLastUpdated)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  XXXLASTUPDATED= new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "xxxLastUpdated", 3/*3*/, "The timestamp for when the record was last updated. (TILDATEST.Testing) (from TILDATEST.Testing2View.xxxLastUpdated)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a1 -> TILDATEST.Testing2Realized."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_BitfieldPrimitiveNull  A1            = new Type_BitfieldPrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "a1"            , 4/*4*/, "The blah (from TILDATEST.Testing2View.a1)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a3b -> TILDATEST.Testing2Realized."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a3b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_BooleanCollectionNull  A3B           = new Type_BooleanCollectionNull (SCHEMA_LABEL, TABLENAME_LABEL, "a3b"           , 5/*5*/, "The blah (from TILDATEST.Testing2View.a3b)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a4 -> TILDATEST.Testing2Realized."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoublePrimitiveNull    A4            = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a4"            , 6/*6*/, "The blah (from TILDATEST.Testing2View.a4)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a4b -> TILDATEST.Testing2Realized."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a4b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoubleCollectionNull   A4B           = new Type_DoubleCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a4b"           , 7/*7*/, "The blah (from TILDATEST.Testing2View.a4b)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a5 -> TILDATEST.Testing2Realized."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_FloatPrimitiveNull     A5            = new Type_FloatPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a5"            , 8/*8*/, "The blah (from TILDATEST.Testing2View.a5)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a5b -> TILDATEST.Testing2Realized."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a5b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_FloatCollectionNull    A5B           = new Type_FloatCollectionNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a5b"           , 9/*9*/, "The blah (from TILDATEST.Testing2View.a5b)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a7 -> TILDATEST.Testing2Realized."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a7)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   A7            = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a7"            , 10/*10*/, "The blah (from TILDATEST.Testing2View.a7)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a7b -> TILDATEST.Testing2Realized."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a7b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerCollectionNull  A7B           = new Type_IntegerCollectionNull (SCHEMA_LABEL, TABLENAME_LABEL, "a7b"           , 11/*11*/, "The blah (from TILDATEST.Testing2View.a7b)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a8 -> TILDATEST.Testing2Realized."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a8)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_BinaryPrimitiveNull    A8            = new Type_BinaryPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a8"            , 12/*12*/, "The blah (from TILDATEST.Testing2View.a8)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a8bTZ -> TILDATEST.Testing2Realized."a8bTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a8bTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a8bTZ of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing2View.a8bTZ)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    A8BTZ         = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a8bTZ"         , 13/*13*/, "Generated helper column to hold the time zone ID for 'a8b'. (from TILDATEST.Testing2View.a8bTZ)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a8b -> TILDATEST.Testing2Realized."a8b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a8b of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a8b of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a8b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  A8B           = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "a8b"           , 14/*14*/, "The blah (from TILDATEST.Testing2View.a8b)", A8BTZ);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a10a -> TILDATEST.Testing2Realized."a10a"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a10a of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a10a of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a10a)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   A10A          = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a10a"          , 15/*15*/, "The blah (from TILDATEST.Testing2View.a10a)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a10b -> TILDATEST.Testing2Realized."a10b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a10b of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a10b of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a10b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    A10B          = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a10b"          , 16/*16*/, "The blah (from TILDATEST.Testing2View.a10b)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a10c -> TILDATEST.Testing2Realized."a10c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a10c of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a10c of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a10c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   A10C          = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a10c"          , 17/*17*/, "The blah (from TILDATEST.Testing2View.a10c)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a11 -> TILDATEST.Testing2Realized."a11"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a11 of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a11 of type numeric(8,4)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a11)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_NumericPrimitiveNull   A11           = new Type_NumericPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a11"           , 18/*18*/, "The blah (from TILDATEST.Testing2View.a11)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a11b -> TILDATEST.Testing2Realized."a11b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a11b of type List<BigDecimal></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a11b of type numeric(6,3)[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a11b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_NumericCollectionNull  A11B          = new Type_NumericCollectionNull (SCHEMA_LABEL, TABLENAME_LABEL, "a11b"          , 19/*19*/, "The blah (from TILDATEST.Testing2View.a11b)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a11c -> TILDATEST.Testing2Realized."a11c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a11c of type BigDecimal</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a11c of type numeric(5,0)</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a11c)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_NumericPrimitiveNull   A11C          = new Type_NumericPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a11c"          , 20/*20*/, "The blah (from TILDATEST.Testing2View.a11c)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a12 -> TILDATEST.Testing2Realized."a12"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a12 of type short</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a12 of type smallint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a12)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_ShortPrimitiveNull     A12           = new Type_ShortPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a12"           , 21/*21*/, "The blah (from TILDATEST.Testing2View.a12)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a12b -> TILDATEST.Testing2Realized."a12b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a12b of type List<Short></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a12b of type smallint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a12b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_ShortCollectionNull    A12B          = new Type_ShortCollectionNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a12b"          , 22/*22*/, "The blah (from TILDATEST.Testing2View.a12b)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a13 -> TILDATEST.Testing2Realized."a13"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a13 of type UUID</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a13 of type UUID</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a13)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_UuidPrimitiveNull      A13           = new Type_UuidPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "a13"           , 23/*23*/, "The blah (from TILDATEST.Testing2View.a13)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a13b -> TILDATEST.Testing2Realized."a13b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a13b of type List<UUID></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a13b of type UUID[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah (from TILDATEST.Testing2View.a13b)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_UuidCollectionNull     A13B          = new Type_UuidCollectionNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a13b"          , 24/*24*/, "The blah (from TILDATEST.Testing2View.a13b)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.description -> TILDATEST.Testing2Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.description)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESCRIPTION   = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "description"   , 25/*25*/, "The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.description)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.desc2 -> TILDATEST.Testing2Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESC2         = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc2"         , 26/*26*/, "The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc2)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.desc3 -> TILDATEST.Testing2Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESC3         = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc3"         , 27/*27*/, "The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc3)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.desc4 -> TILDATEST.Testing2Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESC4         = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc4"         , 28/*28*/, "The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc4)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.desc5 -> TILDATEST.Testing2Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESC5         = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc5"         , 29/*29*/, "The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc5)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.desc6 -> TILDATEST.Testing2Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc6)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESC6         = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc6"         , 30/*30*/, "The title for a person, i.e., Mr, Miss, Mrs... (from TILDATEST.Testing2View.desc6)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a3 -> TILDATEST.Testing2Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Not A3</B>' (from TILDATEST.Testing2View.a3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_BooleanPrimitiveNull   A3            = new Type_BooleanPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a3"            , 31/*31*/, "Formula column '<B>Not A3</B>' (from TILDATEST.Testing2View.a3)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.bastille -> TILDATEST.Testing2Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing2View.bastille)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  BASTILLE      = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "bastille"      , 32/*32*/, "Formula column '<B>Bastille Day</B>' (from TILDATEST.Testing2View.bastille)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.toto -> TILDATEST.Testing2Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Last Updated</B>' (from TILDATEST.Testing2View.toto)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  TOTO          = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "toto"          , 33/*33*/, "Formula column '<B>Last Updated</B>' (from TILDATEST.Testing2View.toto)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.desc2_Cat1 -> TILDATEST.Testing2Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing2View.desc2_Cat1)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoublePrimitiveNull    DESC2_CAT1    = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc2_Cat1"    , 34/*34*/, "Formula column '<B>desc2_Cat1 Title</B>' (from TILDATEST.Testing2View.desc2_Cat1)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.desc2_Cat2 -> TILDATEST.Testing2Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing2View.desc2_Cat2)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoublePrimitiveNull    DESC2_CAT2    = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc2_Cat2"    , 35/*35*/, "Formula column '<B>desc2_Cat2 Title</B>' (from TILDATEST.Testing2View.desc2_Cat2)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.desc2_Cat3 -> TILDATEST.Testing2Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing2View.desc2_Cat3)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoublePrimitiveNull    DESC2_CAT3    = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc2_Cat3"    , 36/*36*/, "Formula column '<B>desc2_Cat3 Title</B>' (from TILDATEST.Testing2View.desc2_Cat3)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a7_Cat4 -> TILDATEST.Testing2Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing2View.a7_Cat4)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoublePrimitiveNull    A7_CAT4       = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a7_Cat4"       , 37/*37*/, "Formula column '<B>a7_Cat4 Title</B>' (from TILDATEST.Testing2View.a7_Cat4)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a7_Cat5 -> TILDATEST.Testing2Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing2View.a7_Cat5)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoublePrimitiveNull    A7_CAT5       = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a7_Cat5"       , 38/*38*/, "Formula column '<B>a7_Cat5 Title</B>' (from TILDATEST.Testing2View.a7_Cat5)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a5_null -> TILDATEST.Testing2Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a5</B>' (from TILDATEST.Testing2View.a5_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   A5_NULL       = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a5_null"       , 39/*39*/, "Formula column '<B>Null a5</B>' (from TILDATEST.Testing2View.a5_null)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a6_null -> TILDATEST.Testing2Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a6</B>' (from TILDATEST.Testing2View.a6_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   A6_NULL       = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a6_null"       , 40/*40*/, "Formula column '<B>Null a6</B>' (from TILDATEST.Testing2View.a6_null)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a7_null -> TILDATEST.Testing2Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a7</B>' (from TILDATEST.Testing2View.a7_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   A7_NULL       = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a7_null"       , 41/*41*/, "Formula column '<B>Null a7</B>' (from TILDATEST.Testing2View.a7_null)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing2Realized.a8_null -> TILDATEST.Testing2Realized."a8_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing2Realized.a8_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing2Realized.a8_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Formula column '<B>Null a8</B>' (from TILDATEST.Testing2View.a8_null)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   A8_NULL       = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a8_null"       , 42/*42*/, "Formula column '<B>Null a8</B>' (from TILDATEST.Testing2View.a8_null)");
;
   }

   public static final ColumnDefinition[] COLUMNS = { COLS.REFNUM,COLS.NAME,COLS.LASTUPDATED,COLS.XXXLASTUPDATED,COLS.A1,COLS.A3B,COLS.A4,COLS.A4B,COLS.A5,COLS.A5B,COLS.A7,COLS.A7B,COLS.A8,COLS.A8BTZ,COLS.A8B,COLS.A10A,COLS.A10B,COLS.A10C,COLS.A11,COLS.A11B,COLS.A11C,COLS.A12,COLS.A12B,COLS.A13,COLS.A13B,COLS.DESCRIPTION,COLS.DESC2,COLS.DESC3,COLS.DESC4,COLS.DESC5,COLS.DESC6,COLS.A3,COLS.BASTILLE,COLS.TOTO,COLS.DESC2_CAT1,COLS.DESC2_CAT2,COLS.DESC2_CAT3,COLS.A7_CAT4,COLS.A7_CAT5,COLS.A5_NULL,COLS.A6_NULL,COLS.A7_NULL,COLS.A8_NULL };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = {  };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = { 
                   {COLS.REFNUM}
        };

   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = COLUMNS_UNIQUE_INDICES[0];

   private static Boolean  __INITIALIZED = false;
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED == false)
        synchronized(__INITIALIZED)
         {
           if (__INITIALIZED == false)
            {
              tilda.data_test.Testing2Realized_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data_test.Testing2Realized_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.Testing2Realized_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data_test.Testing2Realized_Data> _OP;
       protected ArrayListResults<tilda.data_test.Testing2Realized_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data_test.Testing2Realized_Data Obj = new tilda.data_test.Testing2Realized_Data();
          boolean OK = ((tilda.data_test._Tilda.TILDA__TESTING2REALIZED)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data_test.Testing2Realized_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data_test._Tilda.TILDA__TESTING2REALIZED Obj, Object ExtraParams, int start, int size) throws Exception
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
          S.append(" "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "refnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "name");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "xxxLastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a1");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a3b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a4b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a5b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a7");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a7b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a8");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a8bTZ");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a8b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a10a");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a10b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a10c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a11");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a11b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a11c");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a12");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a12b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a13");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a13b");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "description");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "desc2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "desc3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "desc4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "desc5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "desc6");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "bastille");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "toto");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "desc2_Cat1");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "desc2_Cat2");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "desc2_Cat3");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a7_Cat4");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a7_Cat5");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a5_null");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a6_null");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a7_null");
          S.append(", "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "a8_null");
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "Testing2Realized");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1:
                S.append(" order by "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "lastUpdated"); S.append(" DESC");
                break;
             case 2:
                S.append(" where (1=1)");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATEST", "Testing2Realized", "refnum"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDATEST.Testing2Realized", Q, null);
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
             case 1: {
               break;
             }
             case 2: {
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
          tilda.data_test._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TESTING2REALIZED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
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
   static public tilda.data_test.Testing2Realized_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING2REALIZED Obj = new tilda.data_test.Testing2Realized_Data();
       String[] vals = null;

       vals = Values.get("refnum");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("refnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _refnum = ParseUtil.parseLong("refnum", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_refnum != null) Obj.setRefnum(_refnum);

       vals = Values.get("name");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("name", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _name = ParseUtil.parseString("name", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_name != null) Obj.setName(_name);

       vals = Values.get("a1");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a1", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _a1 = ParseUtil.parseInteger("a1", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a1 != null) Obj.setA1(_a1);

       vals = Values.get("a3b");
       List<Boolean> _a3b = CollectionUtil.toList(ParseUtil.parseBoolean("a3b", false, vals, Errors));
       if (_a3b != null) Obj.setA3b(_a3b);

       vals = Values.get("a4");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a4", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Double _a4 = ParseUtil.parseDouble("a4", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a4 != null) Obj.setA4(_a4);

       vals = Values.get("a4b");
       List<Double> _a4b = CollectionUtil.toList(ParseUtil.parseDouble("a4b", false, vals, Errors));
       if (_a4b != null) Obj.setA4b(_a4b);

       vals = Values.get("a5");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a5", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Float _a5 = ParseUtil.parseFloat("a5", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a5 != null) Obj.setA5(_a5);

       vals = Values.get("a5b");
       List<Float> _a5b = CollectionUtil.toList(ParseUtil.parseFloat("a5b", false, vals, Errors));
       if (_a5b != null) Obj.setA5b(_a5b);

       vals = Values.get("a7");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a7", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _a7 = ParseUtil.parseInteger("a7", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a7 != null) Obj.setA7(_a7);

       vals = Values.get("a7b");
       List<Integer> _a7b = CollectionUtil.toList(ParseUtil.parseInteger("a7b", false, vals, Errors));
       if (_a7b != null) Obj.setA7b(_a7b);

       vals = Values.get("a8");
       if (vals != null)
        throw new Exception("Column 'a8' is of a binary type and cannot be initialized with a generic String value.");
       vals = Values.get("a8b");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a8b", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _a8b = ParseUtil.parseZonedDateTime("a8b", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a8b != null) Obj.setA8b(_a8b);

       vals = Values.get("a10a");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a10a", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _a10a = ParseUtil.parseInteger("a10a", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a10a != null) Obj.setA10a(_a10a);

       vals = Values.get("a10b");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a10b", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _a10b = ParseUtil.parseString("a10b", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a10b != null) Obj.setA10b(_a10b);

       vals = Values.get("a10c");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a10c", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _a10c = ParseUtil.parseInteger("a10c", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a10c != null) Obj.setA10c(_a10c);

       vals = Values.get("a11");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a11", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       BigDecimal _a11 = ParseUtil.parseBigDecimal("a11", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a11 != null) Obj.setA11(_a11);

       vals = Values.get("a11b");
       List<BigDecimal> _a11b = CollectionUtil.toList(ParseUtil.parseBigDecimal("a11b", false, vals, Errors));
       if (_a11b != null) Obj.setA11b(_a11b);

       vals = Values.get("a11c");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a11c", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       BigDecimal _a11c = ParseUtil.parseBigDecimal("a11c", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a11c != null) Obj.setA11c(_a11c);

       vals = Values.get("a12");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a12", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Short _a12 = ParseUtil.parseShort("a12", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a12 != null) Obj.setA12(_a12);

       vals = Values.get("a12b");
       List<Short> _a12b = CollectionUtil.toList(ParseUtil.parseShort("a12b", false, vals, Errors));
       if (_a12b != null) Obj.setA12b(_a12b);

       vals = Values.get("a13");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a13", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       UUID _a13 = ParseUtil.parseUUID("a13", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a13 != null) Obj.setA13(_a13);

       vals = Values.get("a13b");
       List<UUID> _a13b = CollectionUtil.toList(ParseUtil.parseUUID("a13b", false, vals, Errors));
       if (_a13b != null) Obj.setA13b(_a13b);

       vals = Values.get("description");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("description", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _description = ParseUtil.parseString("description", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_description != null) Obj.setDescription(_description);

       vals = Values.get("desc2");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("desc2", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _desc2 = ParseUtil.parseString("desc2", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_desc2 != null) Obj.setDesc2(_desc2);

       vals = Values.get("desc3");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("desc3", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _desc3 = ParseUtil.parseString("desc3", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_desc3 != null) Obj.setDesc3(_desc3);

       vals = Values.get("desc4");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("desc4", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _desc4 = ParseUtil.parseString("desc4", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_desc4 != null) Obj.setDesc4(_desc4);

       vals = Values.get("desc5");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("desc5", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _desc5 = ParseUtil.parseString("desc5", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_desc5 != null) Obj.setDesc5(_desc5);

       vals = Values.get("desc6");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("desc6", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _desc6 = ParseUtil.parseString("desc6", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_desc6 != null) Obj.setDesc6(_desc6);

       vals = Values.get("a3");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("a3", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Boolean _a3 = ParseUtil.parseBoolean("a3", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_a3 != null) Obj.setA3(_a3);


       return (tilda.data_test.Testing2Realized_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
*/
   static public tilda.data_test.Testing2Realized_Data create() throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING2REALIZED Obj = new tilda.data_test.Testing2Realized_Data();
       Obj.initForCreate();


       return (tilda.data_test.Testing2Realized_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data_test.Testing2Realized_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__TESTING2REALIZED lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__TESTING2REALIZED) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__TESTING2REALIZED) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data_test.Testing2Realized_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__TESTING2REALIZED) d);

               if (((TILDA__TESTING2REALIZED) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.Testing2Realized_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__TESTING2REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (((TILDA__TESTING2REALIZED) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.Testing2Realized_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__TESTING2REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__TESTING2REALIZED) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.Testing2Realized_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__TESTING2REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__TESTING2REALIZED) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.Testing2Realized_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__TESTING2REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               int i = d.populatePreparedStatement(C, PS, AllocatedArrays);

               PS.addBatch();
               if (index != 0 && (index + 1) % batchSize == 0)
                 {
                   int[] results = PS.executeBatch();
                   int failedRec = JDBCHelper.batchWriteDone(results, batchSize);
                   if (failedRec != -1)
                     {
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data_test.Testing2Realized_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'Testing2Realized_Data' objects ending at position #" + index + " failed being written to the database.");
                   return L.size() - insertCount+failedRec;
                 }
               for (int index2 = batchStart; index2 <= index; ++index2)
                 L.get(index2).stateUpdatePostWrite();

               if(commitSize > 0)
                 {
                   C.commit();
                   LOG.debug("Commited " + insertCount + " batch records.");
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
           TILDA__1_0.handleFinally(PS, T0, TILDA__TESTING2REALIZED_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

   static public tilda.data_test.Testing2Realized_Data lookupByRefnum(long refnum) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING2REALIZED Obj = new tilda.data_test.Testing2Realized_Data();
       Obj.initForLookup(0);

       Obj.setRefnum        (refnum        ); 

       return (tilda.data_test.Testing2Realized_Data) Obj;
     }


   static public ListResults<tilda.data_test.Testing2Realized_Data> lookupWhereLastUpdated(Connection C, int start, int size) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING2REALIZED Obj = new tilda.data_test.Testing2Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }

   static public void lookupWhereLastUpdated(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.Testing2Realized_Data> OP, int start, int size) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING2REALIZED Obj = new tilda.data_test.Testing2Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }



   static public ListResults<tilda.data_test.Testing2Realized_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING2REALIZED Obj = new tilda.data_test.Testing2Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 2, RPI, Obj, null, start, size);
       return RPI._L;
     }


   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.Testing2Realized_Data> OP, int start, int size) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING2REALIZED Obj = new tilda.data_test.Testing2Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, start, size);
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data_test.Testing2Realized_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data_test.Testing2Realized_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


 }
