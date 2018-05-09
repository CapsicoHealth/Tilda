
package tilda.data._Tilda;

import java.time.*;
import java.util.*;

import tilda.db.*;
import tilda.enums.*;
import tilda.types.*;
import tilda.utils.*;
import tilda.utils.pairs.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class TILDA__TESTING_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTING_Factory.class.getName());

   protected TILDA__TESTING_Factory() { }

   public static final Class<TILDA__TESTING> DATA_CLASS= TILDA__TESTING.class;
   public static final String SCHEMA_LABEL = TextUtil.Print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.Print("Testing", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.Print("TILDA.Testing", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "Testing"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.refnum -> TILDA.Testing."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          REFNUM     = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"     , 0/*0*/, "The primary key for this record");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.refnum2 -> TILDA.Testing."refnum2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.refnum2 of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.refnum2 of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The person's primary key</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongCollection         REFNUM2    = new Type_LongCollection        (SCHEMA_LABEL, TABLENAME_LABEL, "refnum2"    , 1/*1*/, "The person's primary key");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.name -> TILDA.Testing."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.name of type character(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        NAME       = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "name"       , 2/*2*/, "Medical system unique enterprise id");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.description -> TILDA.Testing."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESCRIPTION= new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "description", 3/*3*/, "The title for a person, i.e., Mr, Miss, Mrs...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.desc2 -> TILDA.Testing."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESC2      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc2"      , 4/*4*/, "The title for a person, i.e., Mr, Miss, Mrs...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.desc3 -> TILDA.Testing."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESC3      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc3"      , 5/*5*/, "The title for a person, i.e., Mr, Miss, Mrs...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.desc4 -> TILDA.Testing."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESC4      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc4"      , 6/*6*/, "The title for a person, i.e., Mr, Miss, Mrs...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.desc5 -> TILDA.Testing."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESC5      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc5"      , 7/*7*/, "The title for a person, i.e., Mr, Miss, Mrs...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.desc6 -> TILDA.Testing."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    DESC6      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc6"      , 8/*8*/, "The title for a person, i.e., Mr, Miss, Mrs...");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.tops -> TILDA.Testing."tops"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.tops of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.tops of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringCollectionNull   TOPS       = new Type_StringCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "tops"       , 9/*9*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.tops2 -> TILDA.Testing."tops2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.tops2 of type Set <String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.tops2 of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringCollectionNull   TOPS2      = new Type_StringCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "tops2"      , 10/*10*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a1 -> TILDA.Testing."a1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a1 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a1 of type INTEGER</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_BitfieldPrimitiveNull  A1         = new Type_BitfieldPrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "a1"         , 11/*11*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a2 -> TILDA.Testing."a2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a2 of type char</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a2 of type character</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_CharPrimitiveNull      A2         = new Type_CharPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "a2"         , 12/*12*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a2b -> TILDA.Testing."a2b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a2b of type List<Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a2b of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_CharCollectionNull     A2B        = new Type_CharCollectionNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a2b"        , 13/*13*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a2c -> TILDA.Testing."a2c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a2c of type Set <Character></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a2c of type character[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_CharCollectionNull     A2C        = new Type_CharCollectionNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a2c"        , 14/*14*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a3 -> TILDA.Testing."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_BooleanPrimitiveNull   A3         = new Type_BooleanPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a3"         , 15/*15*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a3b -> TILDA.Testing."a3b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a3b of type List<Boolean></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a3b of type boolean[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_BooleanCollectionNull  A3B        = new Type_BooleanCollectionNull (SCHEMA_LABEL, TABLENAME_LABEL, "a3b"        , 16/*16*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a4 -> TILDA.Testing."a4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoublePrimitiveNull    A4         = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a4"         , 17/*17*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a4b -> TILDA.Testing."a4b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a4b of type List<Double></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a4b of type double precision[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DoubleCollectionNull   A4B        = new Type_DoubleCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a4b"        , 18/*18*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a5 -> TILDA.Testing."a5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a5 of type float</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a5 of type real</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_FloatPrimitiveNull     A5         = new Type_FloatPrimitiveNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a5"         , 19/*19*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a5b -> TILDA.Testing."a5b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a5b of type List<Float></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a5b of type real[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_FloatCollectionNull    A5B        = new Type_FloatCollectionNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a5b"        , 20/*20*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a6 -> TILDA.Testing."a6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a6 of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a6 of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitiveNull      A6         = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "a6"         , 21/*21*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a6b -> TILDA.Testing."a6b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a6b of type List<Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a6b of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongCollectionNull     A6B        = new Type_LongCollectionNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a6b"        , 22/*22*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a6c -> TILDA.Testing."a6c"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a6c of type Set <Long></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a6c of type bigint[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongCollectionNull     A6C        = new Type_LongCollectionNull    (SCHEMA_LABEL, TABLENAME_LABEL, "a6c"        , 23/*23*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a7 -> TILDA.Testing."a7"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a7 of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a7 of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   A7         = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a7"         , 24/*24*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a7b -> TILDA.Testing."a7b"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a7b of type List<Integer></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a7b of type integer[]</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerCollectionNull  A7B        = new Type_IntegerCollectionNull (SCHEMA_LABEL, TABLENAME_LABEL, "a7b"        , 25/*25*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a8 -> TILDA.Testing."a8"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a8 of type byte[]</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a8 of type BYTEA</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_BinaryPrimitiveNull    A8         = new Type_BinaryPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a8"         , 26/*26*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a9TZ -> TILDA.Testing."a9TZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a9TZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a9TZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'a9'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    A9TZ       = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a9TZ"       , 27/*27*/, "Generated helper column to hold the time zone ID for 'a9'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.a9 -> TILDA.Testing."a9"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.a9 of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.a9 of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The blah</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  A9         = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "a9"         , 28/*28*/, "The blah");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.created -> TILDA.Testing."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created.</TD></TR>
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
     public static Type_DatetimePrimitive      CREATED    = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"    , 29/*29*/, "The timestamp for when the record was created.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.lastUpdated -> TILDA.Testing."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated.</TD></TR>
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
     public static Type_DatetimePrimitive      LASTUPDATED= new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated", 30/*30*/, "The timestamp for when the record was last updated.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Testing.deleted -> TILDA.Testing."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Testing.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Testing.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DELETED    = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"    , 31/*31*/, "The timestamp for when the record was deleted.");
;
   }

   private static Boolean  __INITIALIZED = false;
   protected static void initObject(Connection C) throws Exception
     {
       if (__INITIALIZED == false)
        synchronized(__INITIALIZED)
         {
           if (__INITIALIZED == false)
            {
              tilda.data.Testing_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.Testing_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> _OP;
       protected ArrayListResults<tilda.data.Testing_Data> _L = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.Testing_Data Obj = new tilda.data.Testing_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__TESTING)Obj).Init(_C, RS);
          if (OK == true)
           {
             if (_OP == null)
              _L.add(Obj);
             else
              _OP.Process(Index, Obj);
           }
          return OK;
        }
     }

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__TESTING Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "Testing", "refnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "refnum2");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "name");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "description");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "desc2");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "desc3");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "desc4");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "desc5");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "desc6");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "tops");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "tops2");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a1");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a2");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a2b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a2c");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a3");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a3b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a4");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a4b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a5");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a5b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a6");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a6b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a6c");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a7");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a7b");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a8");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a9TZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "a9");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "created");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "lastUpdated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "deleted");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "Testing");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
             break;
          case 1:
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Testing", "name"); S.append(" ASC");
             break;
          case 2:
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Testing", "name"); S.append(" ASC");
             break;
          case 3:
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Testing", "name"); S.append(" DESC");
             break;
          case 4:
             S.append(" where ("); C.getFullColumnVar(S, "TILDA", "Testing", "deleted"); S.append(" is null and "); C.getFullColumnVar(S, "TILDA", "Testing", "name"); S.append(" = 'Hello' and "); C.getFullColumnVar(S, "TILDA", "Testing", "created"); S.append(" > '2018-01-01')");
             S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Testing", "name"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDA", "Testing", "description"); S.append(" DESC");
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.Testing", Q, null);
       java.sql.PreparedStatement PS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          switch (LookupId)
           {
             case -7:
                break;
             case 1: {
               break;
             }
             case 2: {
               break;
             }
             case 3: {
               break;
             }
             case 4: {
               break;
             }
             case -666: break;
             default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot prepare statement.");
           }


          count = JDBCHelper.Process(PS.executeQuery(), RP, Start, true, Size, true);
        }
       catch (java.sql.SQLException E)
        {
          tilda.data._Tilda.TILDA__1_0.HandleCatch(C, E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__TESTING_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Creates a new object in memory, which you can subsequently {@link #Write()} to the data store.
 current object to the destination. 
 @param refnum2     The person's primary key
 @param name        (max size 10) Medical system unique enterprise id
*/
   static public tilda.data.Testing_Data Create(List<Long> refnum2, String name) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDA.TESTING"));

       // Explicit setters
       Obj.setRefnum2    (refnum2    );
       Obj.setName       (name       );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.Testing_Data) Obj;
     }

   static public tilda.data.Testing_Data Create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       Long        _refnum      =                       ParseUtil.parseLong("refnum"     , true , Values.get("refnum"     ), Errors );
       List<Long>  _refnum2     = CollectionUtil.toList(ParseUtil.parseLong("refnum2"    , true , Values.get("refnum2"    ), "``", Errors));
       String        _name        =                       ParseUtil.parseString("name"       , true , Values.get("name"       ), Errors );
       String        _description =                       ParseUtil.parseString("description", false, Values.get("description"), Errors );
       String        _desc2       =                       ParseUtil.parseString("desc2"      , false, Values.get("desc2"      ), Errors );
       String        _desc3       =                       ParseUtil.parseString("desc3"      , false, Values.get("desc3"      ), Errors );
       String        _desc4       =                       ParseUtil.parseString("desc4"      , false, Values.get("desc4"      ), Errors );
       String        _desc5       =                       ParseUtil.parseString("desc5"      , false, Values.get("desc5"      ), Errors );
       String        _desc6       =                       ParseUtil.parseString("desc6"      , false, Values.get("desc6"      ), Errors );
       List<String>  _tops        = CollectionUtil.toList(ParseUtil.parseString("tops"       , false, Values.get("tops"       ), "``", Errors));
       Set <String>  _tops2       = CollectionUtil.toSet (ParseUtil.parseString("tops2"      , false, Values.get("tops2"      ), "``", Errors));
       Integer        _a1          =                       ParseUtil.parseInteger("a1"         , false, Values.get("a1"         ), Errors );
       Character        _a2          =                       ParseUtil.parseCharacter("a2"         , false, Values.get("a2"         ), Errors );
       List<Character>  _a2b         = CollectionUtil.toList(ParseUtil.parseCharacter("a2b"        , false, Values.get("a2b"        ), "``", Errors));
       Set <Character>  _a2c         = CollectionUtil.toSet (ParseUtil.parseCharacter("a2c"        , false, Values.get("a2c"        ), "``", Errors));
       Boolean        _a3          =                       ParseUtil.parseBoolean("a3"         , false, Values.get("a3"         ), Errors );
       List<Boolean>  _a3b         = CollectionUtil.toList(ParseUtil.parseBoolean("a3b"        , false, Values.get("a3b"        ), "``", Errors));
       Double        _a4          =                       ParseUtil.parseDouble("a4"         , false, Values.get("a4"         ), Errors );
       List<Double>  _a4b         = CollectionUtil.toList(ParseUtil.parseDouble("a4b"        , false, Values.get("a4b"        ), "``", Errors));
       Float        _a5          =                       ParseUtil.parseFloat("a5"         , false, Values.get("a5"         ), Errors );
       List<Float>  _a5b         = CollectionUtil.toList(ParseUtil.parseFloat("a5b"        , false, Values.get("a5b"        ), "``", Errors));
       Long        _a6          =                       ParseUtil.parseLong("a6"         , false, Values.get("a6"         ), Errors );
       List<Long>  _a6b         = CollectionUtil.toList(ParseUtil.parseLong("a6b"        , false, Values.get("a6b"        ), "``", Errors));
       Set <Long>  _a6c         = CollectionUtil.toSet (ParseUtil.parseLong("a6c"        , false, Values.get("a6c"        ), "``", Errors));
       Integer        _a7          =                       ParseUtil.parseInteger("a7"         , false, Values.get("a7"         ), Errors );
       List<Integer>  _a7b         = CollectionUtil.toList(ParseUtil.parseInteger("a7b"        , false, Values.get("a7b"        ), "``", Errors));
       if (Values.get("a8") != null)
        Errors.add(new StringStringPair("a8", "Parameter is of a binary type and cannot be passed as a string value."));
       ZonedDateTime        _a9          =                       ParseUtil.parseZonedDateTime("a9"         , false, Values.get("a9"         ), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.Testing_Data Obj = tilda.data.Testing_Factory.Create(_refnum2, _name);

      if (_refnum     != null) Obj.setRefnum     (_refnum     );
      if (_description!= null) Obj.setDescription(_description);
      if (_desc2      != null) Obj.setDesc2      (_desc2      );
      if (_desc3      != null) Obj.setDesc3      (_desc3      );
      if (_desc4      != null) Obj.setDesc4      (_desc4      );
      if (_desc5      != null) Obj.setDesc5      (_desc5      );
      if (_desc6      != null) Obj.setDesc6      (_desc6      );
      if (_tops       != null) Obj.setTops       (_tops       );
      if (_tops2      != null) Obj.setTops2      (_tops2      );
      if (_a1         != null) Obj.setA1         (_a1         );
      if (_a2         != null) Obj.setA2         (_a2         );
      if (_a2b        != null) Obj.setA2b        (_a2b        );
      if (_a2c        != null) Obj.setA2c        (_a2c        );
      if (_a3         != null) Obj.setA3         (_a3         );
      if (_a3b        != null) Obj.setA3b        (_a3b        );
      if (_a4         != null) Obj.setA4         (_a4         );
      if (_a4b        != null) Obj.setA4b        (_a4b        );
      if (_a5         != null) Obj.setA5         (_a5         );
      if (_a5b        != null) Obj.setA5b        (_a5b        );
      if (_a6         != null) Obj.setA6         (_a6         );
      if (_a6b        != null) Obj.setA6b        (_a6b        );
      if (_a6c        != null) Obj.setA6c        (_a6c        );
      if (_a7         != null) Obj.setA7         (_a7         );
      if (_a7b        != null) Obj.setA7b        (_a7b        );
      if (_a9         != null) Obj.setA9         (_a9         );

      return Obj;
     }

   static public tilda.data.Testing_Data LookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(0);

       Obj.setRefnum     (refnum     ); Obj.__Saved_refnum      = Obj._refnum     ;

       return (tilda.data.Testing_Data) Obj;
     }

   static public ListResults<tilda.data.Testing_Data> LookupWhereAllByName(Connection C, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 1, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAllByName(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 1, RPI, Obj, null, Start, Size);
     }


   static public ListResults<tilda.data.Testing_Data> LookupWhereAllByName2(Connection C, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 2, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAllByName2(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 2, RPI, Obj, null, Start, Size);
     }


   static public ListResults<tilda.data.Testing_Data> LookupWhereAllByName3(Connection C, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 3, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAllByName3(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 3, RPI, Obj, null, Start, Size);
     }


   static public ListResults<tilda.data.Testing_Data> LookupWhereAllByName4(Connection C, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, 4, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void LookupWhereAllByName4(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__TESTING Obj = new tilda.data.Testing_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, 4, RPI, Obj, null, Start, Size);
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.Testing_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.Testing_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }

 }
