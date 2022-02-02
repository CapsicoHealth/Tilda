
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
public class TILDA__ZONEINFO_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__ZONEINFO_Factory.class.getName());

   protected TILDA__ZONEINFO_Factory() { }

   public static final Class<TILDA__ZONEINFO> DATA_CLASS= TILDA__ZONEINFO.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.print("ZoneInfo", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDA.ZoneInfo", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "ZoneInfo"); }

   public static final class COLS_BASE
    {
      private COLS_BASE() { }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ZoneInfo.id -> TILDA.ZoneInfo."id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ZoneInfo.id of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ZoneInfo.id of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The id for this enumeration.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        ID           = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "id"           , 0/*0*/, "The id for this enumeration.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ZoneInfo.value -> TILDA.ZoneInfo."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ZoneInfo.value of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ZoneInfo.value of type varchar(50)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>50</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The value for this enumeration.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        VALUE        = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "value"        , 1/*1*/, "The value for this enumeration.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ZoneInfo.label -> TILDA.ZoneInfo."label"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ZoneInfo.label of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ZoneInfo.label of type varchar(254)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>254</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The label for this enumeration.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>ABSOLUTE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitive        LABEL        = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "label"        , 2/*2*/, "The label for this enumeration.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ZoneInfo.deactivatedTZ -> TILDA.ZoneInfo."deactivatedTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ZoneInfo.deactivatedTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ZoneInfo.deactivatedTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'deactivated'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_StringPrimitiveNull    DEACTIVATEDTZ= new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "deactivatedTZ", 3/*3*/, "Generated helper column to hold the time zone ID for 'deactivated'.", null, null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ZoneInfo.deactivated -> TILDA.ZoneInfo."deactivated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ZoneInfo.deactivated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ZoneInfo.deactivated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The label for this enumeration.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  DEACTIVATED  = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deactivated"  , 4/*4*/, "The label for this enumeration.", null, null, DEACTIVATEDTZ);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ZoneInfo.created -> TILDA.ZoneInfo."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ZoneInfo.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ZoneInfo.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDA.ZoneInfo)</TD></TR>
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
     public final Type_DatetimePrimitive      CREATED      = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"      , 5/*5*/, "The timestamp for when the record was created. (TILDA.ZoneInfo)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ZoneInfo.lastUpdated -> TILDA.ZoneInfo."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ZoneInfo.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ZoneInfo.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDA.ZoneInfo)</TD></TR>
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
     public final Type_DatetimePrimitive      LASTUPDATED  = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"  , 6/*6*/, "The timestamp for when the record was last updated. (TILDA.ZoneInfo)", null, null);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.ZoneInfo.deleted -> TILDA.ZoneInfo."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.ZoneInfo.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.ZoneInfo.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDA.ZoneInfo)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public final Type_DatetimePrimitiveNull  DELETED      = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"      , 7/*7*/, "The timestamp for when the record was deleted. (TILDA.ZoneInfo)", null, null);
   }

   public static COLS_BASE COLS = new COLS_BASE();
   public static final ColumnDefinition[] COLUMNS = new ColumnDefinition[] { COLS.ID,COLS.VALUE,COLS.LABEL,COLS.DEACTIVATEDTZ,COLS.DEACTIVATED,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = new ColumnDefinition[] { COLS.ID };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = new ColumnDefinition[][]{ 
                   {COLS.ID}
                   ,{COLS.VALUE}
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
              initMappings(C);
              tilda.data.ZoneInfo_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.ZoneInfo_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.ZoneInfo_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.ZoneInfo_Data> _OP;
       protected ArrayListResults<tilda.data.ZoneInfo_Data> _L = null;
       public void    start  ()                              throws Exception { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) throws Exception { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.ZoneInfo_Data Obj = new tilda.data.ZoneInfo_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__ZONEINFO)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.data.ZoneInfo_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__ZONEINFO Obj, Object ExtraParams, int start, int size) throws Exception
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
          C.getFullColumnVarList(S, TILDA__ZONEINFO_Factory.COLUMNS);
          S.append(" from "); C.getFullTableVar(S, "TILDA", "ZoneInfo");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 3: // Index 'All'
                S.append(" order by "); C.getFullColumnVar(S, "TILDA", "ZoneInfo", "id"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDA.ZoneInfo", Q, null);
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
             case 3: {  // Index 'All'
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
          tilda.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__ZONEINFO_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.data.ZoneInfo_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       String[] vals = null;

       vals = Values.get("id");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("id", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _id = ParseUtil.parseString("id", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_id != null) Obj.setId(_id);

       vals = Values.get("value");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("value", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _value = ParseUtil.parseString("value", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_value != null) Obj.setValue(_value);

       vals = Values.get("label");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("label", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _label = ParseUtil.parseString("label", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_label != null) Obj.setLabel(_label);

       vals = Values.get("deactivated");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("deactivated", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       ZonedDateTime _deactivated = ParseUtil.parseZonedDateTime("deactivated", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_deactivated != null) Obj.setDeactivated(_deactivated);


       return (tilda.data.ZoneInfo_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param id            (max size 5) The id for this enumeration.
 @param value         (max size 50) The value for this enumeration.
 @param label         (max size 254) The label for this enumeration.
*/
   static public tilda.data.ZoneInfo_Data create(String id, String value, String label) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setId           (id           );
       Obj.setValue        (value        );
       Obj.setLabel        (label        );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.ZoneInfo_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.data.ZoneInfo_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__ZONEINFO lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__ZONEINFO) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__ZONEINFO) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.ZoneInfo_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__ZONEINFO) d);

               if (((TILDA__ZONEINFO) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.ZoneInfo_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__ZONEINFO_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__ZONEINFO) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.ZoneInfo_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__ZONEINFO_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__ZONEINFO) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.ZoneInfo_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__ZONEINFO_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__ZONEINFO) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.ZoneInfo_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__ZONEINFO_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.ZoneInfo_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'ZoneInfo_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__1_0.handleFinally(PS, T0, TILDA__ZONEINFO_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

/**
Lookup one record by the primary key: id.
*/
   static public tilda.data.ZoneInfo_Data lookupByPrimaryKey(String id) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForLookup(0);

       Obj.setId           (id           ); Obj.__Saved_id            = Obj._id           ;

       return (tilda.data.ZoneInfo_Data) Obj;
     }

/**
Lookup one record by the unique index 'Id': id.
*/
   static public tilda.data.ZoneInfo_Data lookupById(String id) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForLookup(1);

       Obj.setId           (id           ); Obj.__Saved_id            = Obj._id           ;

       return (tilda.data.ZoneInfo_Data) Obj;
     }

/**
Lookup one record by the unique index 'Value': value.
*/
   static public tilda.data.ZoneInfo_Data lookupByValue(String value) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForLookup(2);

       Obj.setValue        (value        ); 

       return (tilda.data.ZoneInfo_Data) Obj;
     }

/**
Lookup records by the index 'All' over  .<BR>The results are ordered by: id asc
*/
   static public ListResults<tilda.data.ZoneInfo_Data> lookupWhereAll(Connection C, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 3, RPI, Obj, null, start, size);
       return RPI._L;
     }

/**
Lookup records by the index 'All' over  .<BR>The results are ordered by: id asc
*/
   static public void lookupWhereAll(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.ZoneInfo_Data> OP, int start, int size) throws Exception
     {
       tilda.data._Tilda.TILDA__ZONEINFO Obj = new tilda.data.ZoneInfo_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);



       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 3, RPI, Obj, null, start, size);
     }




   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.ZoneInfo_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.ZoneInfo_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


   protected static Map<String, tilda.data.ZoneInfo_Data> __ENUMERATIONS_BY_ID    = new HashMap<String, tilda.data.ZoneInfo_Data>();
   protected static Map<String, tilda.data.ZoneInfo_Data> __ENUMERATIONS_BY_VALUE = new HashMap<String, tilda.data.ZoneInfo_Data>();
   public static void initMappings(Connection C) throws Exception
     {
       __ENUMERATIONS_BY_ID   .clear();
       __ENUMERATIONS_BY_VALUE.clear();
       ListResults<tilda.data.ZoneInfo_Data> L = lookupWhereAll(C, 0, -1);
       for (tilda.data.ZoneInfo_Data obj : L)
        {
          __ENUMERATIONS_BY_ID   .put(obj.getId   (), obj);
          __ENUMERATIONS_BY_VALUE.put(obj.getValue(), obj);
        }
     }

   public static tilda.data.ZoneInfo_Data getEnumerationById(String Id)
     {
       return Id == null ? null : __ENUMERATIONS_BY_ID.get(Id);
     }

   public static tilda.data.ZoneInfo_Data getEnumerationByValue(String Value)
     {
       return Value == null ? null : __ENUMERATIONS_BY_VALUE.get(Value);
     }

   public static String getCSVHeader()
    {
      return "\"id\",\"value\",\"label\",\"deactivatedTZ\",\"deactivated\",\"created\",\"lastUpdated\",\"deleted\"";
    }

   public static void toCSV(java.io.Writer out, List<tilda.data.ZoneInfo_Data> L, boolean includeHeader) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      if (includeHeader == true)
        out.write(getCSVHeader() + "\n");
      for (tilda.data.ZoneInfo_Data O : L)
       if (O!=null)
        {
          toCSV(out, O);
          out.write("\n");
        }
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }

   public static void toCSV(java.io.Writer out, tilda.data.ZoneInfo_Data obj) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      StringBuilder Str = new StringBuilder();

      TextUtil.escapeDoubleQuoteForCSV(Str, obj.getId());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, obj.getValue());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, obj.getLabel());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, obj.getDeactivatedTZ());
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(obj.getDeactivated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(obj.getCreated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(obj.getLastUpdated()));
      Str.append(",");
      TextUtil.escapeDoubleQuoteForCSV(Str, DateTimeUtil.printDateTimeForSQL(obj.getDeleted()));
      out.write(Str.toString());
      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);
    }
   public static void toJSON(java.io.Writer out, List<tilda.data.ZoneInfo_Data> L, String lead, boolean fullList) throws java.io.IOException
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
      for (tilda.data.ZoneInfo_Data O : L)
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

   public static void toJSON(java.io.Writer out, tilda.data.ZoneInfo_Data obj, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, "", fullObject, false);
    }

   public static void toJSON(java.io.Writer out, tilda.data.ZoneInfo_Data obj, String lead, boolean fullObject) throws java.io.IOException
    {
      toJSON(out, obj, lead, fullObject, false);
    }

   public static void toJSON(java.io.Writer outWriter, tilda.data.ZoneInfo_Data obj, String lead, boolean fullObject, boolean noNullArrays) throws java.io.IOException
    {
      long T0 = System.nanoTime();
      org.apache.commons.io.output.StringBuilderWriter out = new org.apache.commons.io.output.StringBuilderWriter();
      tilda.data._Tilda.TILDA__ZONEINFO Obj = (tilda.data._Tilda.TILDA__ZONEINFO) obj;
      if (fullObject == true)
       {
          out.write(lead);
          out.write("{");
       }

      int i = -1;
        JSONUtil.print(out, "id", ++i==0, Obj.getId());

        JSONUtil.print(out, "value", ++i==0, Obj.getValue());

        JSONUtil.print(out, "label", ++i==0, Obj.getLabel());

      if (Obj.isDeactivatedTZNull() == false && Obj.getDeactivatedTZ() != null)
        JSONUtil.print(out, "deactivatedTZ", ++i==0, Obj.getDeactivatedTZ());

      if (Obj.isDeactivatedNull() == false && Obj.getDeactivated() != null)
        JSONUtil.print(out, "deactivated", ++i==0, Obj.getDeactivated());

        JSONUtil.print(out, "created", ++i==0, Obj.getCreated());

        JSONUtil.print(out, "lastUpdated", ++i==0, Obj.getLastUpdated());

      if (Obj.isDeletedNull() == false && Obj.getDeleted() != null)
        JSONUtil.print(out, "deleted", ++i==0, Obj.getDeleted());

      if (fullObject == true)
       out.write(" }\n");

      outWriter.append(out.getBuilder().toString());
      out.close();

      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);
    }

 }
