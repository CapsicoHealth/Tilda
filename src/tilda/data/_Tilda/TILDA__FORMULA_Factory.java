
package tilda.data._Tilda;

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
public class TILDA__FORMULA_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__FORMULA_Factory.class.getName());

   protected TILDA__FORMULA_Factory() { }

   public static final Class<TILDA__FORMULA> DATA_CLASS= TILDA__FORMULA.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("Formula", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.Formula", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "Formula"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.refnum -> TILDA.Formula."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          REFNUM           = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"           , 0/*0*/, "The primary key for this record");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.location -> TILDA.Formula."location"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.location of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.location of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the primary table/view this formula is defined in.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        LOCATION         = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "location"         , 1/*1*/, "The name of the primary table/view this formula is defined in.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.location2 -> TILDA.Formula."location2"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.location2 of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.location2 of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the secondary table/view (a derived view, a realized table), if appropriate.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        LOCATION2        = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "location2"        , 2/*2*/, "The name of the secondary table/view (a derived view, a realized table), if appropriate.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.name -> TILDA.Formula."name"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.name of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.name of type varchar(64)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>64</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The name of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        NAME             = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "name"             , 3/*3*/, "The name of the formula/column.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.type -> TILDA.Formula."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.type of type character(3)</TD></TR>

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
  <TR bgcolor="#EEEEEE"><TD>3&nbsp;&nbsp;</TD><TD align="right"><B>Short</B>&nbsp;&nbsp;</TD><TD>SHT&nbsp;&nbsp;</TD><TD>Short&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Short</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>4&nbsp;&nbsp;</TD><TD align="right"><B>Integer</B>&nbsp;&nbsp;</TD><TD>INT&nbsp;&nbsp;</TD><TD>Integer&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Integer</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>5&nbsp;&nbsp;</TD><TD align="right"><B>Long</B>&nbsp;&nbsp;</TD><TD>LNG&nbsp;&nbsp;</TD><TD>Long&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Long</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>6&nbsp;&nbsp;</TD><TD align="right"><B>Float</B>&nbsp;&nbsp;</TD><TD>FLT&nbsp;&nbsp;</TD><TD>Float&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Float</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>7&nbsp;&nbsp;</TD><TD align="right"><B>Double</B>&nbsp;&nbsp;</TD><TD>DBL&nbsp;&nbsp;</TD><TD>Double&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Double</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>8&nbsp;&nbsp;</TD><TD align="right"><B>Date</B>&nbsp;&nbsp;</TD><TD>DT&nbsp;&nbsp;</TD><TD>Date&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Date</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>9&nbsp;&nbsp;</TD><TD align="right"><B>DateTime</B>&nbsp;&nbsp;</TD><TD>DTM&nbsp;&nbsp;</TD><TD>DateTime&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>DateTime</TD></TR>
  <TR bgcolor="#FFFFFF"><TD>10&nbsp;&nbsp;</TD><TD align="right"><B>Numeric</B>&nbsp;&nbsp;</TD><TD>NUM&nbsp;&nbsp;</TD><TD>Numeric&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Numeric</TD></TR>
  <TR bgcolor="#EEEEEE"><TD>11&nbsp;&nbsp;</TD><TD align="right"><B>Uuid</B>&nbsp;&nbsp;</TD><TD>UI&nbsp;&nbsp;</TD><TD>Uuid&nbsp;&nbsp;</TD><TD>NONE&nbsp;&nbsp;</TD><TD>&nbsp;&nbsp;</TD><TD>Uuid</TD></TR>
</TABLE>
</TD></TR>

</TABLE>
*/
     public static Type_StringPrimitive        TYPE             = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "type"             , 4/*4*/, "The type of the formula/column value/outcome.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.title -> TILDA.Formula."title"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.title of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.title of type varchar(128)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>128</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The title of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        TITLE            = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "title"            , 5/*5*/, "The title of the formula/column.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.description -> TILDA.Formula."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.description of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the formula/column.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        DESCRIPTION      = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "description"      , 6/*6*/, "The description of the formula/column.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.formula -> TILDA.Formula."formula"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.formula of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.formula of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    FORMULA          = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "formula"          , 7/*7*/, "The formula.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.htmlDoc -> TILDA.Formula."htmlDoc"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.htmlDoc of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.htmlDoc of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Pre-rendered html fragment with the full documentation for this formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    HTMLDOC          = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "htmlDoc"          , 8/*8*/, "Pre-rendered html fragment with the full documentation for this formula.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.referencedColumns -> TILDA.Formula."referencedColumns"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.referencedColumns of type List<String></TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.referencedColumns of type text[]</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>null</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The list of columns this formula depends on.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringCollectionNull   REFERENCEDCOLUMNS= new Type_StringCollectionNull  (SCHEMA_LABEL, TABLENAME_LABEL, "referencedColumns", 9/*9*/, "The list of columns this formula depends on.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.created -> TILDA.Formula."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.Formula)</TD></TR>
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
     public static Type_DatetimePrimitive      CREATED          = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"          , 10/*10*/, "The timestamp for when the record was created. (TILDA.Formula)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.lastUpdated -> TILDA.Formula."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.Formula)</TD></TR>
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
     public static Type_DatetimePrimitive      LASTUPDATED      = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"      , 11/*11*/, "The timestamp for when the record was last updated. (TILDA.Formula)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.Formula.deleted -> TILDA.Formula."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.Formula.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.Formula.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.Formula)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DELETED          = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"          , 12/*12*/, "The timestamp for when the record was deleted. (TILDA.Formula)");
;
   }

   public static final ColumnDefinition[] COLUMNS = { COLS.REFNUM,COLS.LOCATION,COLS.LOCATION2,COLS.NAME,COLS.TYPE,COLS.TITLE,COLS.DESCRIPTION,COLS.FORMULA,COLS.HTMLDOC,COLS.REFERENCEDCOLUMNS,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = { COLS.REFNUM };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = { 
                   {COLS.LOCATION,COLS.NAME}
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
              tilda.data.Formula_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.Formula_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Formula_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.Formula_Data> _OP;
       protected ArrayListResults<tilda.data.Formula_Data> _L = null;
       public void    start  () { }
       public void    end    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.Formula_Data Obj = new tilda.data.Formula_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__FORMULA)Obj).init(_C, RS);
          if (OK == true)
           {
             if (_OP == null)
              _L.add(Obj);
             else
              _OP.process(Index, Obj);
           }
          return OK;
        }
     }

   protected static final void processMany(Connection C, String FullSelectQuery, int Start, int Size, tilda.db.processors.RecordProcessor RP) throws Exception
     {
       readMany(C, -77, RP, null, FullSelectQuery, Start, Size);
     }
   protected static final ListResults<tilda.data.Formula_Data> readMany(Connection C, String FullSelectQuery, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       readMany(C, -77, RPI, null, FullSelectQuery, Start, Size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__FORMULA Obj, Object ExtraParams, int Start, int Size) throws Exception
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
          S.append(" "); C.getFullColumnVar(S, "TILDA", "Formula", "refnum");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "location");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "location2");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "name");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "type");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "title");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "description");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "formula");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "htmlDoc");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "referencedColumns");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "created");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "Formula", "deleted");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "Formula");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 2:
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "Formula", "referencedColumns"); S.append(" ASC");
                break;
             case -77: 
             case -666: break;
             default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
           }
        }

       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.Formula", Q, null);
       java.sql.PreparedStatement PS=null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          switch (LookupId)
           {
             case -77:
             case -7:
                break;
             case 2: {
               break;
             }
             case -666: break;
             default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot prepare statement.");
           }


          count = JDBCHelper.process(PS.executeQuery(), RP, Start, true, Size, true);
        }
       catch (java.sql.SQLException E)
        {
          C.handleCatch(E, "selected");
        }
       finally
        {
          tilda.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__FORMULA_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, AllocatedArrays);
          PS = null;
          AllocatedArrays = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param location          (max size 64) The name of the primary table/view this formula is defined in.
 @param location2         (max size 64) The name of the secondary table/view (a derived view, a realized table), if appropriate.
 @param name              (max size 64) The name of the formula/column.
 @param type              (max size 3) The type of the formula/column value/outcome.
 @param title             (max size 128) The title of the formula/column.
 @param description       (max size 32000) The description of the formula/column.
*/
   static public tilda.data.Formula_Data create(String location, String location2, String name, String type, String title, String description) throws Exception
     {
       tilda.data._Tilda.TILDA__FORMULA Obj = new tilda.data.Formula_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDA.FORMULA"));

       // Explicit setters
       Obj.setLocation         (location         );
       Obj.setLocation2        (location2        );
       Obj.setName             (name             );
       Obj.setType             (type             );
       Obj.setTitle            (title            );
       Obj.setDescription      (description      );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.Formula_Data) Obj;
     }

   static public tilda.data.Formula_Data create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       Long        _refnum            =                       ParseUtil.parseLong("refnum"           , true , Values.get("refnum"           ), Errors );
       String        _location          =                       ParseUtil.parseString("location"         , true , Values.get("location"         ), Errors );
       String        _location2         =                       ParseUtil.parseString("location2"        , true , Values.get("location2"        ), Errors );
       String        _name              =                       ParseUtil.parseString("name"             , true , Values.get("name"             ), Errors );
       String        _type              =                       ParseUtil.parseString("type"             , true , Values.get("type"             ), Errors );
       String        _title             =                       ParseUtil.parseString("title"            , true , Values.get("title"            ), Errors );
       String        _description       =                       ParseUtil.parseString("description"      , true , Values.get("description"      ), Errors );
       String        _formula           =                       ParseUtil.parseString("formula"          , false, Values.get("formula"          ), Errors );
       String        _htmlDoc           =                       ParseUtil.parseString("htmlDoc"          , false, Values.get("htmlDoc"          ), Errors );
       List<String>  _referencedColumns = CollectionUtil.toList(ParseUtil.parseString("referencedColumns", false, Values.get("referencedColumns"), "``", Errors));

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.Formula_Data Obj = tilda.data.Formula_Factory.create(_location, _location2, _name, _type, _title, _description);

      if (_refnum           != null) Obj.setRefnum           (_refnum           );
      if (_formula          != null) Obj.setFormula          (_formula          );
      if (_htmlDoc          != null) Obj.setHtmlDoc          (_htmlDoc          );
      if (_referencedColumns!= null) Obj.setReferencedColumns(_referencedColumns);

      return Obj;
     }
   public static int writeBatch(Connection C, List<tilda.data.Formula_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__FORMULA lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__FORMULA) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__FORMULA) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.Formula_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__FORMULA) d);

               if (((TILDA__FORMULA) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Formula_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__FORMULA_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (((TILDA__FORMULA) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Formula_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__FORMULA_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__FORMULA) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Formula_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__FORMULA_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__FORMULA) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.Formula_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__FORMULA_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.Formula_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'Formula_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__1_0.handleFinally(PS, T0, TILDA__FORMULA_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

   static public tilda.data.Formula_Data lookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__FORMULA Obj = new tilda.data.Formula_Data();
       Obj.initForLookup(0);

       Obj.setRefnum           (refnum           ); Obj.__Saved_refnum            = Obj._refnum           ;

       return (tilda.data.Formula_Data) Obj;
     }

   static public tilda.data.Formula_Data lookupByFormula(String location, String name) throws Exception
     {
       tilda.data._Tilda.TILDA__FORMULA Obj = new tilda.data.Formula_Data();
       Obj.initForLookup(1);

       Obj.setLocation         (location         ); 
       Obj.setName             (name             ); 

       return (tilda.data.Formula_Data) Obj;
     }

   static public ListResults<tilda.data.Formula_Data> lookupWhereRefCols(Connection C, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__FORMULA Obj = new tilda.data.Formula_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       readMany(C, 2, RPI, Obj, null, Start, Size);
       return RPI._L;
     }

   static public void lookupWhereRefCols(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Formula_Data> OP, int Start, int Size) throws Exception
     {
       tilda.data._Tilda.TILDA__FORMULA Obj = new tilda.data.Formula_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, Start, Size);
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.Formula_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       readMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.Formula_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


 }
