
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

@SuppressWarnings({ "unused" })
public class TILDA__FORMULARESULT_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__FORMULARESULT_Factory.class.getName());

   protected TILDA__FORMULARESULT_Factory() { }

   public static final Class<TILDA__FORMULARESULT> DATA_CLASS= TILDA__FORMULARESULT.class;
   public static final String SCHEMA_LABEL = TextUtil.Print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.Print("FormulaResult", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.Print("TILDA.FormulaResult", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "FormulaResult"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResult.formulaRefnum -> TILDA.FormulaResult."formulaRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaResult.formulaRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResult.formulaRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The parent formula.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          FORMULAREFNUM= new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "formulaRefnum", 0/*0*/, "The parent formula.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResult.value -> TILDA.FormulaResult."value"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaResult.value of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResult.value of type varchar(100)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>100</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        VALUE        = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "value"        , 1/*1*/, "The result value.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResult.description -> TILDA.FormulaResult."description"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaResult.description of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResult.description of type text</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>32000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The description of the result value.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        DESCRIPTION  = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "description"  , 2/*2*/, "The description of the result value.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResult.created -> TILDA.FormulaResult."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaResult.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResult.created of type timestamptz</TD></TR>

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
     public static Type_DatetimePrimitive      CREATED      = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"      , 3/*3*/, "The timestamp for when the record was created.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResult.lastUpdated -> TILDA.FormulaResult."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaResult.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResult.lastUpdated of type timestamptz</TD></TR>

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
     public static Type_DatetimePrimitive      LASTUPDATED  = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"  , 4/*4*/, "The timestamp for when the record was last updated.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.FormulaResult.deleted -> TILDA.FormulaResult."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.FormulaResult.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.FormulaResult.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DELETED      = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"      , 5/*5*/, "The timestamp for when the record was deleted.");
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
              tilda.data.FormulaResult_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.FormulaResult_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.FormulaResult_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.FormulaResult_Data> _OP;
       protected ArrayListResults<tilda.data.FormulaResult_Data> _L = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.FormulaResult_Data Obj = new tilda.data.FormulaResult_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__FORMULARESULT)Obj).Init(_C, RS);
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

   protected static final ListResults<tilda.data.FormulaResult_Data> ReadMany(Connection C, String FullSelectQuery, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -77, RPI, null, FullSelectQuery, Start, Size);
       return RPI._L;
     }

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__FORMULARESULT Obj, Object ExtraParams, int Start, int Size) throws Exception
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
          S.append(" "); C.getFullColumnVar(S, "TILDA", "FormulaResult", "formulaRefnum");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaResult", "value");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaResult", "description");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaResult", "created");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaResult", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDA", "FormulaResult", "deleted");
          S.append(" from "); C.getFullTableVar(S, "TILDA", "FormulaResult");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
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
       QueryDetails.logQuery("TILDA.FormulaResult", Q, null);
       java.sql.PreparedStatement PS=null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          switch (LookupId)
           {
             case -77:
             case -7:
                break;
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Creates a new object in memory, which you can subsequently {@link #Write()} to the data store.
 current object to the destination. 
 @param formulaRefnum The parent formula.
 @param value         (max size 100) The result value.
 @param description   (max size 32000) The description of the result value.
*/
   static public tilda.data.FormulaResult_Data Create(long formulaRefnum, String value, String description) throws Exception
     {
       tilda.data._Tilda.TILDA__FORMULARESULT Obj = new tilda.data.FormulaResult_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setFormulaRefnum(formulaRefnum);
       Obj.setValue        (value        );
       Obj.setDescription  (description  );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.FormulaResult_Data) Obj;
     }

   static public tilda.data.FormulaResult_Data Create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       Long        _formulaRefnum =                       ParseUtil.parseLong("formulaRefnum", true , Values.get("formulaRefnum"), Errors );
       String        _value         =                       ParseUtil.parseString("value"        , true , Values.get("value"        ), Errors );
       String        _description   =                       ParseUtil.parseString("description"  , true , Values.get("description"  ), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.FormulaResult_Data Obj = tilda.data.FormulaResult_Factory.Create(_formulaRefnum, _value, _description);


      return Obj;
     }
   public static int WriteBatch(Connection C, List<tilda.data.FormulaResult_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__FORMULARESULT lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__FORMULARESULT) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__FORMULARESULT) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.data.FormulaResult_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__FORMULARESULT) d);

               if (((TILDA__FORMULARESULT) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FormulaResult_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (((TILDA__FORMULARESULT) d).BeforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FormulaResult_Data' object at positon #" + index + " failed in its BeforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__FORMULARESULT) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FormulaResult_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__FORMULARESULT) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FormulaResult_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               int i = d.populatePreparedStatement(C, PS, AllocatedArrays);

               PS.addBatch();
               if (index != 0 && (index + 1) % batchSize == 0)
                 {
                   int[] results = PS.executeBatch();
                   if (JDBCHelper.BatchWriteDone(results, batchSize) == false)
                     {
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.data.FormulaResult_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
                       return index;
                     }
                   for (int index2 = batchStart; index2 <= index; ++index2)
                     L.get(index2).stateUpdatePostWrite();
                   LOG.debug("Batch-inserted objects between positions #" + batchStart + " and #" + index + ".");
                   batchStart = 0;
                   insertCount+=batchSize;

                   if (insertCount % commitSize == 0 && commitSize > 0)
                     {
                       C.commit();
                       LOG.debug("Commited " + commitSize + " batch records. At insert count " + insertCount);
                     }
                 }
               PS.clearParameters();
             }

           if (index != 0 && (index + 1) % batchSize != 0)
             {
               int[] results = PS.executeBatch();
               if (JDBCHelper.BatchWriteDone(results, L.size() - insertCount) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'FormulaResult_Data' objects ending at position #" + index + " failed being written to the database.");
                   return index;
                 }
               for (int index2 = batchStart; index2 <= index; ++index2)
                 L.get(index2).stateUpdatePostWrite();

               if(commitSize > 0)
                 {
                   C.commit();
                   LOG.debug("Commited " + insertCount + " batch records.");
                 }
               LOG.debug("Final Batch-inserted objects between positions #" + batchStart + " and #" + index + ".");
             }

           C.releaseSavepoint(true);
           return -1;
         }
       catch (java.sql.SQLException E)
         {
           C.releaseSavepoint(false);
           TILDA__1_0.HandleCatch(C, E, "updated or inserted");
           return 1;
         }
       finally
         {
           TILDA__1_0.HandleFinally(PS, T0, TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }


   public static int WriteBatch(Connection C, List<tilda.data.FormulaResult_Data> L, int logOffset) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       TILDA__FORMULARESULT lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__FORMULARESULT) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__FORMULARESULT) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;
           int indexOffset = 0;

           int index = -1;
           for (tilda.data.FormulaResult_Data d : L)
             {
               ++index;
               indexOffset = index  + logOffset;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__FORMULARESULT) d);

               if (((TILDA__FORMULARESULT) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FormulaResult_Data' object at positon #" + indexOffset + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return indexOffset;
                 }

               if (((TILDA__FORMULARESULT) d).BeforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FormulaResult_Data' object at positon #" + indexOffset + " failed in its BeforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return indexOffset;
                 }

               if (firstChangeList.equals(((TILDA__FORMULARESULT) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FormulaResult_Data' object at positon #" + indexOffset + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return indexOffset;
                 }

               if (firstTimeStampSignature.equals(((TILDA__FORMULARESULT) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.data.FormulaResult_Data' object at positon #" + indexOffset + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return indexOffset;
                 }

               int i = d.populatePreparedStatement(C, PS, AllocatedArrays);

               PS.addBatch();
               PS.clearParameters();
             }

           int[] results = PS.executeBatch();
           if (JDBCHelper.BatchWriteDone(results, L.size() - insertCount) == false)
             {
               LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'FormulaResult_Data' objects ending at position #" + indexOffset + " failed being written to the database.");
               return indexOffset;
             }
           for (int index2 = 0; index2 <= index; ++index2)
             L.get(index2).stateUpdatePostWrite();
           LOG.debug("Final Batch-inserted objects between positions #" + logOffset + " and #" + indexOffset + ".");

         C.releaseSavepoint(true);
           return -1;
         }
       catch (java.sql.SQLException E)
         {
           C.releaseSavepoint(false);
           TILDA__1_0.HandleCatch(C, E, "updated or inserted");
           return 1;
         }
       finally
         {
           TILDA__1_0.HandleFinally(PS, T0, TILDA__FORMULARESULT_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

   static public tilda.data.FormulaResult_Data LookupByPrimaryKey(long formulaRefnum, String value) throws Exception
     {
       tilda.data._Tilda.TILDA__FORMULARESULT Obj = new tilda.data.FormulaResult_Data();
       Obj.initForLookup(0);

       Obj.setFormulaRefnum(formulaRefnum); Obj.__Saved_formulaRefnum = Obj._formulaRefnum;
       Obj.setValue        (value        ); Obj.__Saved_value         = Obj._value        ;

       return (tilda.data.FormulaResult_Data) Obj;
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.FormulaResult_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.FormulaResult_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }

 }
