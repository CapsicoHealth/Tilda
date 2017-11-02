
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

public class TILDA__JOBFILE_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__JOBFILE_Factory.class.getName());

   protected TILDA__JOBFILE_Factory() { }

   public static final Class<TILDA__JOBFILE> DATA_CLASS= TILDA__JOBFILE.class;
   public static final String SCHEMA_LABEL = TextUtil.Print("TILDA", "");
   public static final String TABLENAME_LABEL = TextUtil.Print("JOBFILE", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.Print("TILDA.JOBFILE", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDA", "JOBFILE"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.refnum -> TILDA.JOBFILE."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          REFNUM                = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"                , 0/*0*/, "The primary key for this record");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.jobRefnum -> TILDA.JOBFILE."jobRefnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.jobRefnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.jobRefnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Job Foreign key</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          JOBREFNUM             = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "jobRefnum"             , 1/*1*/, "Job Foreign key");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileName -> TILDA.JOBFILE."fileName"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileName of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileName of type varchar(200)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>200</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Zip FileName</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        FILENAME              = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "fileName"              , 2/*2*/, "Zip FileName");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileRecords -> TILDA.JOBFILE."fileRecords"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileRecords of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileRecords of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Number of records loaded into DB</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitiveNull      FILERECORDS           = new Type_LongPrimitiveNull     (SCHEMA_LABEL, TABLENAME_LABEL, "fileRecords"           , 3/*3*/, "Number of records loaded into DB");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ -> TILDA.JOBFILE."fileProcessStartTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessStartTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    FILEPROCESSSTARTTIMETZ= new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "fileProcessStartTimeTZ", 4/*4*/, "Generated helper column to hold the time zone ID for 'fileProcessStartTime'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessStartTime -> TILDA.JOBFILE."fileProcessStartTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessStartTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessStartTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessStartTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  FILEPROCESSSTARTTIME  = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "fileProcessStartTime"  , 5/*5*/, "FileProcessStartTime");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ -> TILDA.JOBFILE."fileProcessEndTimeTZ"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTimeTZ of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTimeTZ of type character(5)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>5</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Generated helper column to hold the time zone ID for 'fileProcessEndTime'.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitiveNull    FILEPROCESSENDTIMETZ  = new Type_StringPrimitiveNull   (SCHEMA_LABEL, TABLENAME_LABEL, "fileProcessEndTimeTZ"  , 6/*6*/, "Generated helper column to hold the time zone ID for 'fileProcessEndTime'.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.fileProcessEndTime -> TILDA.JOBFILE."fileProcessEndTime"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.fileProcessEndTime of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.fileProcessEndTime of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>FileProcessEndTime</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  FILEPROCESSENDTIME    = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "fileProcessEndTime"    , 7/*7*/, "FileProcessEndTime");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.created -> TILDA.JOBFILE."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.created of type timestamptz</TD></TR>

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
     public static Type_DatetimePrimitive      CREATED               = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"               , 8/*8*/, "The timestamp for when the record was created.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.lastUpdated -> TILDA.JOBFILE."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.lastUpdated of type timestamptz</TD></TR>

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
     public static Type_DatetimePrimitive      LASTUPDATED           = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"           , 9/*9*/, "The timestamp for when the record was last updated.");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.data.TILDA.JOBFILE.deleted -> TILDA.JOBFILE."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.data.TILDA.JOBFILE.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDA.JOBFILE.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted.</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DELETED               = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"               , 10/*10*/, "The timestamp for when the record was deleted.");
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
              tilda.data.JobFile_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int Start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.data.JobFile_Data>(Start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.data.JobFile_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.data.JobFile_Data> _OP;
       protected ArrayListResults<tilda.data.JobFile_Data> _L = null;
       public void    Start  () { }
       public void    End    (boolean HasMore, int Max) { if (_OP == null) _L.wrapup(HasMore, Max); }
       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception
        {
          tilda.data.JobFile_Data Obj = new tilda.data.JobFile_Data();
          boolean OK = ((tilda.data._Tilda.TILDA__JOBFILE)Obj).Init(_C, RS);
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

   private static final void ReadMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.data._Tilda.TILDA__JOBFILE Obj, Object ExtraParams, int Start, int Size) throws Exception
     {
       long T0 = System.nanoTime();
       StringBuilder S = new StringBuilder(1024);
       S.append("select ");
       S.append(" "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "refnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "jobRefnum");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileName");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileRecords");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileProcessStartTimeTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileProcessStartTime");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileProcessEndTimeTZ");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "fileProcessEndTime");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "created");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "lastUpdated");
       S.append(", "); C.getFullColumnVar(S, "TILDA", "JOBFILE", "deleted");
       S.append(" from "); C.getFullTableVar(S, "TILDA", "JOBFILE");
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
       QueryDetails.logQuery("TILDA.JOBFILE", Q, null);
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
          tilda.data._Tilda.TILDA__1_0.HandleFinally(PS, T0, TILDA__JOBFILE_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
          PS = null;
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// THIS CODE IS GENERATED AND **MUST NOT** BE MODIFIED
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 Creates a new object in memory, which you can subsequently {@link #Write()} to the data store.
 current object to the destination. 
 @param jobRefnum              Job Foreign key
 @param fileName               (max size 200) Zip FileName
*/
   static public tilda.data.JobFile_Data Create(long jobRefnum, String fileName) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBFILE Obj = new tilda.data.JobFile_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDA.JOBFILE"));

       // Explicit setters
       Obj.setJobRefnum             (jobRefnum             );
       Obj.setFileName              (fileName              );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.data.JobFile_Data) Obj;
     }

   static public tilda.data.JobFile_Data Create(Map<String, String> Values, List<StringStringPair> Errors)
   throws Exception
     {
       int IncomingErrors = Errors.size();

       Long        _refnum                 =                       ParseUtil.parseLong("refnum"                , true , Values.get("refnum"                ), Errors );
       Long        _jobRefnum              =                       ParseUtil.parseLong("jobRefnum"             , true , Values.get("jobRefnum"             ), Errors );
       String        _fileName               =                       ParseUtil.parseString("fileName"              , true , Values.get("fileName"              ), Errors );
       Long        _fileRecords            =                       ParseUtil.parseLong("fileRecords"           , false, Values.get("fileRecords"           ), Errors );
       ZonedDateTime        _fileProcessStartTime   =                       ParseUtil.parseZonedDateTime("fileProcessStartTime"  , false, Values.get("fileProcessStartTime"  ), Errors );
       ZonedDateTime        _fileProcessEndTime     =                       ParseUtil.parseZonedDateTime("fileProcessEndTime"    , false, Values.get("fileProcessEndTime"    ), Errors );

       if (IncomingErrors != Errors.size())
        return null;

      tilda.data.JobFile_Data Obj = tilda.data.JobFile_Factory.Create(_jobRefnum, _fileName);

      if (_refnum                != null) Obj.setRefnum                (_refnum                );
      if (_fileRecords           != null) Obj.setFileRecords           (_fileRecords           );
      if (_fileProcessStartTime  != null) Obj.setFileProcessStartTime  (_fileProcessStartTime  );
      if (_fileProcessEndTime    != null) Obj.setFileProcessEndTime    (_fileProcessEndTime    );

      return Obj;
     }

   static public tilda.data.JobFile_Data LookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBFILE Obj = new tilda.data.JobFile_Data();
       Obj.initForLookup(0);

       Obj.setRefnum                (refnum                ); Obj.__Saved_refnum                 = Obj._refnum                ;

       return (tilda.data.JobFile_Data) Obj;
     }

   static public tilda.data.JobFile_Data LookupByJob_Refnum(long jobRefnum) throws Exception
     {
       tilda.data._Tilda.TILDA__JOBFILE Obj = new tilda.data.JobFile_Data();
       Obj.initForLookup(1);

       Obj.setJobRefnum             (jobRefnum             ); 

       return (tilda.data.JobFile_Data) Obj;
     }



   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.data.JobFile_Data> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, Start);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.data.JobFile_Data> OP, int Start, int Size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       ReadMany(C, -7, RPI, null, Q, Start, Size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }

 }
