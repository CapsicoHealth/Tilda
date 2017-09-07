
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

public class TILDA__JOB_DETAIL_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__JOB_DETAIL_Factory.class.getName());

   protected TILDA__JOB_DETAIL_Factory() { }

   public static final Class<TILDA__JOB_DETAIL> DATA_CLASS= TILDA__JOB_DETAIL.class;
   public static final String SCHEMA_LABEL = TextUtil.Print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.Print("JOB_DETAIL", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.Print("TILDA.JOB_DETAIL", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "JOB_DETAIL"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.Id -> TILDA.JOB_DETAIL."Id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.Id of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.Id of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitive       ID                    = new Type_IntegerPrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "Id"                    , 0/*0*/, "Id");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.Job_Id -> TILDA.JOB_DETAIL."Job_Id"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.Job_Id of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.Job_Id of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job Id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitive       JOB_ID                = new Type_IntegerPrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "Job_Id"                , 1/*1*/, "Job Id");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.FileName -> TILDA.JOB_DETAIL."FileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.FileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.FileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    FILENAME              = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "FileName"              , 2/*2*/, "FileName");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.FileRecords -> TILDA.JOB_DETAIL."FileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.FileRecords of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.FileRecords of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileRecords</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitiveNull   FILERECORDS           = new Type_IntegerPrimitiveNull  (SCHEMA_LABEL, TABLENAME_LABEL, "FileRecords"           , 3/*3*/, "FileRecords");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.FileProcessStartTimeTZ -> TILDA.JOB_DETAIL."FileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.FileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.FileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    FILEPROCESSSTARTTIMETZ= new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "FileProcessStartTimeTZ", 4/*4*/, "Generated helper column to hold the time zone ID for 'FileProcessStartTime'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.FileProcessStartTime -> TILDA.JOB_DETAIL."FileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.FileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.FileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  FILEPROCESSSTARTTIME  = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "FileProcessStartTime"  , 5/*5*/, "FileProcessStartTime");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.FileProcessEndTimeTZ -> TILDA.JOB_DETAIL."FileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.FileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.FileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'FileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    FILEPROCESSENDTIMETZ  = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "FileProcessEndTimeTZ"  , 6/*6*/, "Generated helper column to hold the time zone ID for 'FileProcessEndTime'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.FileProcessEndTime -> TILDA.JOB_DETAIL."FileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.FileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.FileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  FILEPROCESSENDTIME    = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "FileProcessEndTime"    , 7/*7*/, "FileProcessEndTime");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.Status -> TILDA.JOB_DETAIL."Status"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.Status of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.Status of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Status</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    STATUS                = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "Status"                , 8/*8*/, "Status");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.Error -> TILDA.JOB_DETAIL."Error"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.Error of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.Error of type varchar(1000)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>1000</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Error</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    ERROR                 = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "Error"                 , 9/*9*/, "Error");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.created -> TILDA.JOB_DETAIL."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.created of type timestamptz</TD></TR>

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
     public static Type_DatetimePrimitive      CREATED               = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"               , 10/*10*/, "The timestamp for when the record was created.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.lastUpdated -> TILDA.JOB_DETAIL."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.lastUpdated of type timestamptz</TD></TR>

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
     public static Type_DatetimePrimitive      LASTUPDATED           = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"           , 11/*11*/, "The timestamp for when the record was last updated.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOB_DETAIL.deleted -> TILDA.JOB_DETAIL."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOB_DETAIL.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOB_DETAIL.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DELETED               = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"               , 12/*12*/, "The timestamp for when the record was deleted.");
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
              tilda.data.Job_Detail_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.Job_Detail_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.Job_Detail_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.Job_Detail_Data> _OP;
       protected ArrayListResults<tilda.data.Job_Detail_Data> _L = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.Job_Detail_Data Obj = new tilda.data.Job_Detail_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__JOB_DETAIL)Obj).Init(_C, RS);
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

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__JOB_DETAIL Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "Id");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "Job_Id");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "FileName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "FileRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "FileProcessStartTimeTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "FileProcessStartTime");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "FileProcessEndTimeTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "FileProcessEndTime");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "Status");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "Error");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "created");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "lastUpdated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOB_DETAIL", "deleted");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "JOB_DETAIL");
       switch (LookupId)
        {
          case -7:
             String clause = ((SelectQuery)ExtraParams).getWhereClause();
             if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
             break;
          case -666: break;
          default: throw new Exception("Invalid LookupId "+LookupId+" found. Cannot create where clause.");
        }

       
       String Q = S.toString() + C.getSelectLimitClause(Start, Size+1);
       S.setLength(0);
       S = null;
       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);
       QueryDetails.logQuery("TILDA.JOB_DETAIL", Q, null);
       java.sql.PreparedStatement PS=null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          switch (LookupId)
           {
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__JOB_DETAIL_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Creates a new object in memory, which you can subsequently {@link #Write()} to the data store.
 current object to the destination. 
 @param Id                     Id
 @param Job_Id                 Job Id
*/
   static public tilda.data.Job_Detail_Data Create(int Id, int Job_Id) throws Exception
     {
       tilda.data._Tilda.TILDA__JOB_DETAIL Obj = new tilda.data.Job_Detail_Data();
       Obj.initForCreate();


       // Explicit setters
       Obj.setId                    (Id                    );
       Obj.setJob_Id                (Job_Id                );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.Job_Detail_Data) Obj;
     }

   static public tilda.data.Job_Detail_Data Create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       Integer        _Id                     =                       ParseUtil.parseInteger("Id"                    , true , Values.get("Id"                    ), Errors );
       Integer        _Job_Id                 =                       ParseUtil.parseInteger("Job_Id"                , true , Values.get("Job_Id"                ), Errors );
       String        _FileName               =                       ParseUtil.parseString("FileName"              , false, Values.get("FileName"              ), Errors );
       Integer        _FileRecords            =                       ParseUtil.parseInteger("FileRecords"           , false, Values.get("FileRecords"           ), Errors );
       ZonedDateTime        _FileProcessStartTime   =                       ParseUtil.parseZonedDateTime("FileProcessStartTime"  , false, Values.get("FileProcessStartTime"  ), Errors );
       ZonedDateTime        _FileProcessEndTime     =                       ParseUtil.parseZonedDateTime("FileProcessEndTime"    , false, Values.get("FileProcessEndTime"    ), Errors );
       String        _Status                 =                       ParseUtil.parseString("Status"                , false, Values.get("Status"                ), Errors );
       String        _Error                  =                       ParseUtil.parseString("Error"                 , false, Values.get("Error"                 ), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.Job_Detail_Data Obj = tilda.data.Job_Detail_Factory.Create(_Id, _Job_Id);

      if (_FileName              != null) Obj.setFileName              (_FileName              );
      if (_FileRecords           != null) Obj.setFileRecords           (_FileRecords           );
      if (_FileProcessStartTime  != null) Obj.setFileProcessStartTime  (_FileProcessStartTime  );
      if (_FileProcessEndTime    != null) Obj.setFileProcessEndTime    (_FileProcessEndTime    );
      if (_Status                != null) Obj.setStatus                (_Status                );
      if (_Error                 != null) Obj.setError                 (_Error                 );

      return Obj;
     }

   static public tilda.data.Job_Detail_Data LookupByJob_File_Id(int Id, int Job_Id) throws Exception
     {
       tilda.data._Tilda.TILDA__JOB_DETAIL Obj = new tilda.data.Job_Detail_Data();
       Obj.initForLookup(0);

       Obj.setId                    (Id                    ); 
       Obj.setJob_Id                (Job_Id                ); 

       return (tilda.data.Job_Detail_Data) Obj;
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.Job_Detail_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.Job_Detail_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }

 }
