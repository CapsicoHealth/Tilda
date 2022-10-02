
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
public class TILDA__TESTING4REALIZED_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTING4REALIZED_Factory.class.getName());

   protected TILDA__TESTING4REALIZED_Factory() { }

   public static final Class<TILDA__TESTING4REALIZED> DATA_CLASS= TILDA__TESTING4REALIZED.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATEST", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Testing4Realized", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATEST.Testing4Realized", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATEST", "Testing4Realized"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.refnum -> TILDATEST.Testing4Realized."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_LongPrimitiveNull      REFNUM     = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"     , 0/*0*/, "The primary key for this record", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.name -> TILDATEST.Testing4Realized."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.name of type varchar(10)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>10</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Medical system unique enterprise id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    NAME       = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "name"       , 1/*1*/, "Medical system unique enterprise id", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.description -> TILDATEST.Testing4Realized."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.description of type varchar(250)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>250</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    DESCRIPTION= new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "description", 2/*2*/, "The title for a person, i.e., Mr, Miss, Mrs...", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2 -> TILDATEST.Testing4Realized."desc2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2 of type varchar(3000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>3000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    DESC2      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc2"      , 3/*3*/, "The title for a person, i.e., Mr, Miss, Mrs...", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc3 -> TILDATEST.Testing4Realized."desc3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc3 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc3 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    DESC3      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc3"      , 4/*4*/, "The title for a person, i.e., Mr, Miss, Mrs...", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc4 -> TILDATEST.Testing4Realized."desc4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc4 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc4 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>9000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    DESC4      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc4"      , 5/*5*/, "The title for a person, i.e., Mr, Miss, Mrs...", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc5 -> TILDATEST.Testing4Realized."desc5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc5 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc5 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>17000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    DESC5      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc5"      , 6/*6*/, "The title for a person, i.e., Mr, Miss, Mrs...", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc6 -> TILDATEST.Testing4Realized."desc6"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc6 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc6 of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>33000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title for a person, i.e., Mr, Miss, Mrs...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>SMART</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    DESC6      = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc6"      , 7/*7*/, "The title for a person, i.e., Mr, Miss, Mrs...", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.bastille -> TILDATEST.Testing4Realized."bastille"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.bastille of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.bastille of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Bastille Day</B>: Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  BASTILLE   = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "bastille"   , 8/*8*/, "<B>Bastille Day</B>: Blah...", new String[] {}, new String[] {});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.toto -> TILDATEST.Testing4Realized."toto"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.toto of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.toto of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Last Updated</B>: Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  TOTO       = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "toto"       , 9/*9*/, "<B>Last Updated</B>: Blah...", new String[] {}, new String[] {});


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 -> TILDATEST.Testing4Realized."desc2_Cat1"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat1 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat1 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>desc2_Cat1 Title</B>: This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DoublePrimitiveNull    DESC2_CAT1 = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc2_Cat1" , 10/*10*/, "<B>desc2_Cat1 Title</B>: This formula checks whether the column 'desc2' contains the values 'a', 'b', 'c' for the View TILDATEST.Testing2View.", new String[] {}, new String[] {}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 -> TILDATEST.Testing4Realized."desc2_Cat2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat2 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat2 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>desc2_Cat2 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DoublePrimitiveNull    DESC2_CAT2 = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc2_Cat2" , 11/*11*/, "<B>desc2_Cat2 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.", new String[] {}, new String[] {}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 -> TILDATEST.Testing4Realized."desc2_Cat3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.desc2_Cat3 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.desc2_Cat3 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>desc2_Cat3 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DoublePrimitiveNull    DESC2_CAT3 = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "desc2_Cat3" , 12/*12*/, "<B>desc2_Cat3 Title</B>: This formula checks whether the column 'desc2' contains the values 'x', 'y', 'z' for the View TILDATEST.Testing2View.", new String[] {}, new String[] {}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 -> TILDATEST.Testing4Realized."a7_Cat4"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat4 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat4 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>a7_Cat4 Title</B>: This formula checks whether the column 'a7' value falls in the range of 0.0 and 10.0.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DoublePrimitiveNull    A7_CAT4    = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a7_Cat4"    , 13/*13*/, "<B>a7_Cat4 Title</B>: This formula checks whether the column 'a7' value falls in the range of 0.0 and 10.0.", new String[] {}, new String[] {}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 -> TILDATEST.Testing4Realized."a7_Cat5"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_Cat5 of type double</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_Cat5 of type double precision</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>a7_Cat5 Title</B>: This formula checks whether the column 'a7' value falls in the range of 10.0 and 20.0.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DoublePrimitiveNull    A7_CAT5    = new Type_DoublePrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "a7_Cat5"    , 14/*14*/, "<B>a7_Cat5 Title</B>: This formula checks whether the column 'a7' value falls in the range of 10.0 and 20.0.", new String[] {}, new String[] {}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a5_null -> TILDATEST.Testing4Realized."a5_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a5_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a5_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Null a5</B>: Whether a5 is null or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull   A5_NULL    = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a5_null"    , 15/*15*/, "<B>Null a5</B>: Whether a5 is null or not", new String[] {}, new String[] {}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a6_null -> TILDATEST.Testing4Realized."a6_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a6_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a6_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Null a6</B>: Whether a6 is null or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull   A6_NULL    = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a6_null"    , 16/*16*/, "<B>Null a6</B>: Whether a6 is null or not", new String[] {}, new String[] {}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a7_null -> TILDATEST.Testing4Realized."a7_null"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a7_null of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a7_null of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Null a7</B>: Whether a7 is null or not</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_IntegerPrimitiveNull   A7_NULL    = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a7_null"    , 17/*17*/, "<B>Null a7</B>: Whether a7 is null or not", new String[] {}, new String[] {}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.a3 -> TILDATEST.Testing4Realized."a3"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.a3 of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Always True</B>: Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>NOT a3 OR A3</PRE>
</TD></TR>

</TABLE>
*/
     public final Type_BooleanPrimitiveNull   A3         = new Type_BooleanPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "a3"         , 18/*18*/, "<B>Always True</B>: Blah...", new String[] {"NOT a3 OR A3"}, new String[] {"a3"}, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data_test.TILDATEST.Testing4Realized.lastUpdated -> TILDATEST.Testing4Realized."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data_test.TILDATEST.Testing4Realized.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATEST.Testing4Realized.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD><B>Always True</B>: Blah...</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
  <TR valign="top"><TD align="right"><B>Formula</B></TD><TD>

<PRE>GREATEST(lastUpdated, xxxLastUpdated)</PRE>
</TD></TR>

</TABLE>
*/
     public final Type_DatetimePrimitiveNull  LASTUPDATED= new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated", 19/*19*/, "<B>Always True</B>: Blah...", new String[] {"GREATEST(lastUpdated, xxxLastUpdated)"}, new String[] {"lastUpdated", "xxxLastUpdated"});
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.REFNUM,COLS.NAME,COLS.DESCRIPTION,COLS.DESC2,COLS.DESC3,COLS.DESC4,COLS.DESC5,COLS.DESC6,COLS.BASTILLE,COLS.TOTO,COLS.DESC2_CAT1,COLS.DESC2_CAT2,COLS.DESC2_CAT3,COLS.A7_CAT4,COLS.A7_CAT5,COLS.A5_NULL,COLS.A6_NULL,COLS.A7_NULL,COLS.A3,COLS.LASTUPDATED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] {  };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = new ColumnDefinition[][]{ 
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
              tilda.data_test.Testing4Realized_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data_test.Testing4Realized_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.Testing4Realized_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data_test.Testing4Realized_Data> _OP;
       protected ArrayListResults<tilda.data_test.Testing4Realized_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data_test.Testing4Realized_Data Obj = new tilda.data_test.Testing4Realized_Data();
          boolean OK = ((tilda.data_test._Tilda.TILDA__TESTING4REALIZED)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data_test.Testing4Realized_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data_test._Tilda.TILDA__TESTING4REALIZED Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__TESTING4REALIZED_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDATEST", "Testing4Realized");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 1: // Index 'LastUpdated'
                S.append(" order by "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "lastUpdated"); S.append(" DESC");
                break;
             case 2: // Query 'All'
                S.append(" where (");  S.append("1=1");  S.append(")");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATEST", "Testing4Realized", "refnum"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDATEST.Testing4Realized", Q, null);
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
             case 1: {  // Index 'LastUpdated'
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
          tilda.data_test._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.data_test.Testing4Realized_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING4REALIZED Obj = new tilda.data_test.Testing4Realized_Data();
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


       return (tilda.data_test.Testing4Realized_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
*/
   static public tilda.data_test.Testing4Realized_Data create() throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING4REALIZED Obj = new tilda.data_test.Testing4Realized_Data();
       Obj.initForCreate();


       return (tilda.data_test.Testing4Realized_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data_test.Testing4Realized_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__TESTING4REALIZED lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__TESTING4REALIZED) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__TESTING4REALIZED) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data_test.Testing4Realized_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__TESTING4REALIZED) d);

               if (((TILDA__TESTING4REALIZED) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.Testing4Realized_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (((TILDA__TESTING4REALIZED) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.Testing4Realized_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__TESTING4REALIZED) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.Testing4Realized_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__TESTING4REALIZED) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data_test.Testing4Realized_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data_test.Testing4Realized_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'Testing4Realized_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__1_0.handleFinally(PS, T0, TILDA__TESTING4REALIZED_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the unique index 'Refnum': refnum.
*/
   static public tilda.data_test.Testing4Realized_Data lookupByRefnum(long refnum) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING4REALIZED Obj = new tilda.data_test.Testing4Realized_Data();
       Obj.initForLookup(0);

       Obj.setRefnum     (refnum     ); 

       return (tilda.data_test.Testing4Realized_Data) Obj;
     }

/**
Lookup records by the index 'LastUpdated' over  .<BR>The results are ordered by: lastUpdated desc
*/
   static public ListResults<tilda.data_test.Testing4Realized_Data> lookupWhereLastUpdated(Connection C, int start, int size) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING4REALIZED Obj = new tilda.data_test.Testing4Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 1, RPI, Obj, null, start, size);
       return RPI._L;
     }

/**
Lookup records by the index 'LastUpdated' over  .<BR>The results are ordered by: lastUpdated desc
*/
   static public void lookupWhereLastUpdated(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.Testing4Realized_Data> OP, int start, int size) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING4REALIZED Obj = new tilda.data_test.Testing4Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 1, RPI, Obj, null, start, size);
     }



/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: refnum asc
*/   static public ListResults<tilda.data_test.Testing4Realized_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING4REALIZED Obj = new tilda.data_test.Testing4Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 2, RPI, Obj, null, start, size);
       return RPI._L;
     }


/**
Lookup records by the query 'All' over 
.<BR>
The results are ordered by: refnum asc
*/   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data_test.Testing4Realized_Data> OP, int start, int size) throws Exception
     {
       tilda.data_test._Tilda.TILDA__TESTING4REALIZED Obj = new tilda.data_test.Testing4Realized_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, start, size);
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data_test.Testing4Realized_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data_test.Testing4Realized_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


   public static String getCSVHeader()
    {
      return "\"refnum\",\"name\",\"description\",\"desc2\",\"desc3\",\"desc4\",\"desc5\",\"desc6\",\"bastille\",\"toto\",\"desc2_Cat1\",\"desc2_Cat2\",\"desc2_Cat3\",\"a7_Cat4\",\"a7_Cat5\",\"a5_null\",\"a6_null\",\"a7_null\",\"a3\",\"lastUpdated\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data_test.Testing4Realized_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data_test.Testing4Realized_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data_test.Testing4Realized_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
     tilda.data_test._Tilda.TILDA__TESTING4REALIZED Obj = (tilda.data_test._Tilda.TILDA__TESTING4REALIZED) obj;
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getRefnum());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getName());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDescription());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDesc2());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDesc3());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDesc4());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDesc5());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, Obj.getDesc6());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getBastille()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getToto()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDesc2_Cat1());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDesc2_Cat2());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getDesc2_Cat3());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getA7_Cat4());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getA7_Cat5());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getA5_null());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getA6_null());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getA7_null());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, "" + Obj.getA3());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(Obj.getLastUpdated()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data_test.Testing4Realized_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data_test.Testing4Realized_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data_test.Testing4Realized_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data_test.Testing4Realized_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data_test.Testing4Realized_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      try(org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter())
       {
        tilda.data_test._Tilda.TILDA__TESTING4REALIZED Obj = (tilda.data_test._Tilda.TILDA__TESTING4REALIZED) obj;
        if (fullObject == true)
         {
           out.write(lead);
           out.write("{");
         }

        int i = -1;
      if (Obj.isRefnumNull() == false)
        JSONUtil.print(out, "refnum", ++i==0, Obj.getRefnum());

      if (Obj.isNameNull() == false && Obj.getName() != null)
        JSONUtil.print(out, "name", ++i==0, Obj.getName());

      if (Obj.isDescriptionNull() == false && Obj.getDescription() != null)
        JSONUtil.print(out, "description", ++i==0, Obj.getDescription());

      if (Obj.isDesc2Null() == false && Obj.getDesc2() != null)
        JSONUtil.print(out, "desc2", ++i==0, Obj.getDesc2());

      if (Obj.isDesc3Null() == false && Obj.getDesc3() != null)
        JSONUtil.print(out, "desc3", ++i==0, Obj.getDesc3());

      if (Obj.isDesc4Null() == false && Obj.getDesc4() != null)
        JSONUtil.print(out, "desc4", ++i==0, Obj.getDesc4());

      if (Obj.isDesc5Null() == false && Obj.getDesc5() != null)
        JSONUtil.print(out, "desc5", ++i==0, Obj.getDesc5());

      if (Obj.isDesc6Null() == false && Obj.getDesc6() != null)
        JSONUtil.print(out, "desc6", ++i==0, Obj.getDesc6());

      if (Obj.isBastilleNull() == false && Obj.getBastille() != null)
        JSONUtil.print(out, "bastille", ++i==0, Obj.getBastille());

      if (Obj.isTotoNull() == false && Obj.getToto() != null)
        JSONUtil.print(out, "toto", ++i==0, Obj.getToto());

      if (Obj.isDesc2_Cat1Null() == false)
        JSONUtil.print(out, "desc2_Cat1", ++i==0, Obj.getDesc2_Cat1());

      if (Obj.isDesc2_Cat2Null() == false)
        JSONUtil.print(out, "desc2_Cat2", ++i==0, Obj.getDesc2_Cat2());

      if (Obj.isDesc2_Cat3Null() == false)
        JSONUtil.print(out, "desc2_Cat3", ++i==0, Obj.getDesc2_Cat3());

      if (Obj.isA7_Cat4Null() == false)
        JSONUtil.print(out, "a7_Cat4", ++i==0, Obj.getA7_Cat4());

      if (Obj.isA7_Cat5Null() == false)
        JSONUtil.print(out, "a7_Cat5", ++i==0, Obj.getA7_Cat5());

      if (Obj.isA5_nullNull() == false)
        JSONUtil.print(out, "a5_null", ++i==0, Obj.getA5_null());

      if (Obj.isA6_nullNull() == false)
        JSONUtil.print(out, "a6_null", ++i==0, Obj.getA6_null());

      if (Obj.isA7_nullNull() == false)
        JSONUtil.print(out, "a7_null", ++i==0, Obj.getA7_null());

      if (Obj.isA3Null() == false)
        JSONUtil.print(out, "a3", ++i==0, Obj.getA3());

      if (Obj.isLastUpdatedNull() == false && Obj.getLastUpdated() != null)
        JSONUtil.print(out, "lastUpdated", ++i==0, Obj.getLastUpdated());

        if (fullObject == true)
         out.write(" }\n");

        outWriter.append(out.getBuilder().toString());
       }

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
