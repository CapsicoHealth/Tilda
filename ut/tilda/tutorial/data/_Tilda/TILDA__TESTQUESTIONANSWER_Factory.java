
package tilda.tutorial.data._Tilda;

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
public class TILDA__TESTQUESTIONANSWER_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__TESTQUESTIONANSWER_Factory.class.getName());

   protected TILDA__TESTQUESTIONANSWER_Factory() { }

   public static final Class<TILDA__TESTQUESTIONANSWER> DATA_CLASS= TILDA__TESTQUESTIONANSWER.class;
   public static final String SCHEMA_LABEL = TextUtil.print("TILDATUTORIAL", "");
   public static final String TABLENAME_LABEL = TextUtil.print("TestQuestionAnswer", "");
   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print("TILDATUTORIAL.TestQuestionAnswer", "");
   public static void getFullTableNameVar(Connection C, StringBuilder S) { C.getFullTableVar(S, "TILDATUTORIAL", "TestQuestionAnswer"); }

   public static abstract class COLS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.refnum -> TILDATUTORIAL.TestQuestionAnswer."refnum"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.refnum of type long</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.refnum of type bigint</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The primary key for this record</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>true</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_LongPrimitive          REFNUM       = new Type_LongPrimitive         (SCHEMA_LABEL, TABLENAME_LABEL, "refnum"       , 0/*0*/, "The primary key for this record");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.type -> TILDATUTORIAL.TestQuestionAnswer."type"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.type of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.type of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Form template type</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        TYPE         = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "type"         , 1/*1*/, "Form template type");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.questionSeq -> TILDATUTORIAL.TestQuestionAnswer."questionSeq"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.questionSeq of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.questionSeq of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Sequence of the question for the test</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitive       QUESTIONSEQ  = new Type_IntegerPrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "questionSeq"  , 2/*2*/, "Sequence of the question for the test");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.questionId -> TILDATUTORIAL.TestQuestionAnswer."questionId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.questionId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.questionId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        QUESTIONID   = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "questionId"   , 3/*3*/, "Question id");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.questionLabel -> TILDATUTORIAL.TestQuestionAnswer."questionLabel"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.questionLabel of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.questionLabel of type varchar(256)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>256</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Question label</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        QUESTIONLABEL= new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "questionLabel", 4/*4*/, "Question label");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.answerSeq -> TILDATUTORIAL.TestQuestionAnswer."answerSeq"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.answerSeq of type int</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.answerSeq of type integer</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Sequence of the answer for the question in the test</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_IntegerPrimitive       ANSWERSEQ    = new Type_IntegerPrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "answerSeq"    , 5/*5*/, "Sequence of the answer for the question in the test");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.answerId -> TILDATUTORIAL.TestQuestionAnswer."answerId"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.answerId of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.answerId of type varchar(60)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>60</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Answer id</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        ANSWERID     = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "answerId"     , 6/*6*/, "Answer id");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.answerLabel -> TILDATUTORIAL.TestQuestionAnswer."answerLabel"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.answerLabel of type String</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.answerLabel of type varchar(256)</TD></TR>

  <TR><TD align="right"><B>Size</B></TD><TD>256</TD></TR>
  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Answer label</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_StringPrimitive        ANSWERLABEL  = new Type_StringPrimitive       (SCHEMA_LABEL, TABLENAME_LABEL, "answerLabel"  , 7/*7*/, "Answer label");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.correct -> TILDATUTORIAL.TestQuestionAnswer."correct"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.correct of type boolean</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.correct of type boolean</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>Whether the answer is a correct one or not for that question (technically, there could be more than one)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>NORMAL</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_BooleanPrimitive       CORRECT      = new Type_BooleanPrimitive      (SCHEMA_LABEL, TABLENAME_LABEL, "correct"      , 8/*8*/, "Whether the answer is a correct one or not for that question (technically, there could be more than one)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.created -> TILDATUTORIAL.TestQuestionAnswer."created"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.created of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.created of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was created. (TILDATUTORIAL.TestQuestionAnswer)</TD></TR>
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
     public static Type_DatetimePrimitive      CREATED      = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "created"      , 9/*9*/, "The timestamp for when the record was created. (TILDATUTORIAL.TestQuestionAnswer)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.lastUpdated -> TILDATUTORIAL.TestQuestionAnswer."lastUpdated"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.lastUpdated of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.lastUpdated of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>false</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was last updated. (TILDATUTORIAL.TestQuestionAnswer)</TD></TR>
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
     public static Type_DatetimePrimitive      LASTUPDATED  = new Type_DatetimePrimitive     (SCHEMA_LABEL, TABLENAME_LABEL, "lastUpdated"  , 10/*10*/, "The timestamp for when the record was last updated. (TILDATUTORIAL.TestQuestionAnswer)");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Field tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.deleted -> TILDATUTORIAL.TestQuestionAnswer."deleted"
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/**
This is the column definition for:<BR>
<TABLE border="0px" cellpadding="3px" cellspacing="0px">
  <TR><TD align="right"><B>Name</B></TD><TD>tilda.tutorial.data.TILDATUTORIAL.TestQuestionAnswer.deleted of type ZonedDateTime</TD></TR>
  <TR><TD align="right"><B>Column</B></TD><TD>TILDATUTORIAL.TestQuestionAnswer.deleted of type timestamptz</TD></TR>

  <TR><TD align="right"><B>Nullable</B></TD><TD>true</TD></TR>
  <TR valign="top"><TD align="right"><B>Description</B></TD><TD>The timestamp for when the record was deleted. (TILDATUTORIAL.TestQuestionAnswer)</TD></TR>
  <TR><TD align="right"><B>Mode</B></TD><TD>AUTO</TD></TR>
  <TR><TD align="right"><B>Invariant</B></TD><TD>false</TD></TR>
  <TR><TD align="right"><B>Protect</B></TD><TD>NONE</TD></TR>
</TABLE>
*/
     public static Type_DatetimePrimitiveNull  DELETED      = new Type_DatetimePrimitiveNull (SCHEMA_LABEL, TABLENAME_LABEL, "deleted"      , 11/*11*/, "The timestamp for when the record was deleted. (TILDATUTORIAL.TestQuestionAnswer)");
;
   }

   public static final ColumnDefinition[] COLUMNS = { COLS.REFNUM,COLS.TYPE,COLS.QUESTIONSEQ,COLS.QUESTIONID,COLS.QUESTIONLABEL,COLS.ANSWERSEQ,COLS.ANSWERID,COLS.ANSWERLABEL,COLS.CORRECT,COLS.CREATED,COLS.LASTUPDATED,COLS.DELETED };

   public static final ColumnDefinition[] COLUMNS_PRIMARY = { COLS.REFNUM };

   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = { 
                   {COLS.TYPE,COLS.QUESTIONID,COLS.ANSWERSEQ}
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
              tilda.tutorial.data.TestQuestionAnswer_Factory.init(C);
              __INITIALIZED = true;
            }
         }
     }
   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor
     {
       public RecordProcessorInternal(Connection C, int start)
         {
           _C = C;
           _L = new ArrayListResults<tilda.tutorial.data.TestQuestionAnswer_Data>(start);
         }
       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.TestQuestionAnswer_Data> OP)
         {
           _C = C;
           _OP = OP;
         }
       protected Connection _C = null;
       protected tilda.db.processors.ObjectProcessor<tilda.tutorial.data.TestQuestionAnswer_Data> _OP;
       protected ArrayListResults<tilda.tutorial.data.TestQuestionAnswer_Data> _L = null;
       public void    start  () { if (_OP != null) _OP.start(); }
       public void    end    (boolean hasMore, int maxCount) { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }
       public boolean process(int count, java.sql.ResultSet RS) throws Exception
        {
          tilda.tutorial.data.TestQuestionAnswer_Data Obj = new tilda.tutorial.data.TestQuestionAnswer_Data();
          boolean OK = ((tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER)Obj).init(_C, RS);
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
   protected static final ListResults<tilda.tutorial.data.TestQuestionAnswer_Data> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -77, RPI, null, fullSelectQuery, start, size);
       return RPI._L;
     }

   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER Obj, Object ExtraParams, int start, int size) throws Exception
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
          S.append(" "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "refnum");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "type");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "questionSeq");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "questionId");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "questionLabel");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "answerSeq");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "answerId");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "answerLabel");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "correct");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "created");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "lastUpdated");
          S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "deleted");
          S.append(" from "); C.getFullTableVar(S, "TILDATUTORIAL", "TestQuestionAnswer");
          switch (LookupId)
           {
             case -7:
                String clause = ((SelectQuery)ExtraParams).getWhereClause();
                if (TextUtil.isNullOrEmpty(clause) == false) S.append(clause);
                break;
             case 2:
                S.append(" where ("); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "type"); S.append("=?)");
                S.append(" order by "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "questionId"); S.append(" ASC");S.append(", "); C.getFullColumnVar(S, "TILDATUTORIAL", "TestQuestionAnswer", "answerSeq"); S.append(" ASC");
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
       QueryDetails.logQuery("TILDATUTORIAL.TestQuestionAnswer", Q, null);
       java.sql.PreparedStatement PS=null;
       int count = 0;
       try
        {
          PS = C.prepareStatement(Q);
          if (size < 0 || size > 5000)
           PS.setFetchSize(5000);
          int i = 0;
          switch (LookupId)
           {
             case -77:
             case -7:
                break;
             case 2: {
               PS.setString    (++i, Obj._type         );
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
          tilda.tutorial.data._Tilda.TILDA__1_0.handleFinally(PS, T0, TILDA__TESTQUESTIONANSWER_Factory.SCHEMA_TABLENAME_LABEL, StatementType.SELECT, count, null);
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
   static public tilda.tutorial.data.TestQuestionAnswer_Data init(Map<String, String[]> Values, List<StringStringPair> Errors)
   throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER Obj = new tilda.tutorial.data.TestQuestionAnswer_Data();
       String[] vals = null;

       vals = Values.get("refnum");
       // Even though this is a primary key, and is by definition not-null, we nevertheless check it as optional in case
       // this object is being initialized generically for a create.
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("refnum", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Long _refnum = ParseUtil.parseLong("refnum", false, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_refnum != null) Obj.setRefnum(_refnum);

       vals = Values.get("type");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("type", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _type = ParseUtil.parseString("type", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_type != null) Obj.setType(_type);

       vals = Values.get("questionSeq");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("questionSeq", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _questionSeq = ParseUtil.parseInteger("questionSeq", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_questionSeq != null) Obj.setQuestionSeq(_questionSeq);

       vals = Values.get("questionId");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("questionId", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _questionId = ParseUtil.parseString("questionId", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_questionId != null) Obj.setQuestionId(_questionId);

       vals = Values.get("questionLabel");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("questionLabel", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _questionLabel = ParseUtil.parseString("questionLabel", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_questionLabel != null) Obj.setQuestionLabel(_questionLabel);

       vals = Values.get("answerSeq");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("answerSeq", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Integer _answerSeq = ParseUtil.parseInteger("answerSeq", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_answerSeq != null) Obj.setAnswerSeq(_answerSeq);

       vals = Values.get("answerId");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("answerId", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _answerId = ParseUtil.parseString("answerId", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_answerId != null) Obj.setAnswerId(_answerId);

       vals = Values.get("answerLabel");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("answerLabel", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       String _answerLabel = ParseUtil.parseString("answerLabel", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_answerLabel != null) Obj.setAnswerLabel(_answerLabel);

       vals = Values.get("correct");
       if (vals!=null && vals.length > 1)
        Errors.add(new StringStringPair("correct", "Parameter is not a list or a set and yet received "+vals.length+" values"));
       Boolean _correct = ParseUtil.parseBoolean("correct", true, vals!=null && vals.length > 0 ? vals[0] : null, Errors);
       if (_correct != null) Obj.setCorrect(_correct);


       return (tilda.tutorial.data.TestQuestionAnswer_Data) Obj;
     }

/**
 Creates a new object in memory, which you can subsequently {@link #write()} to the data store.
 current object to the destination. 
 @param type          (max size 60) Form template type
 @param questionSeq   Sequence of the question for the test
 @param questionId    (max size 60) Question id
 @param questionLabel (max size 256) Question label
 @param answerSeq     Sequence of the answer for the question in the test
 @param answerId      (max size 60) Answer id
 @param answerLabel   (max size 256) Answer label
 @param correct       Whether the answer is a correct one or not for that question (technically, there could be more than one)
*/
   static public tilda.tutorial.data.TestQuestionAnswer_Data create(String type, int questionSeq, String questionId, String questionLabel, int answerSeq, String answerId, String answerLabel, boolean correct) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER Obj = new tilda.tutorial.data.TestQuestionAnswer_Data();
       Obj.initForCreate();


       // Auto PK
       Obj.setRefnum(tilda.db.KeysManager.getKey("TILDATUTORIAL.TESTQUESTIONANSWER"));

       // Explicit setters
       Obj.setType         (type         );
       Obj.setQuestionSeq  (questionSeq  );
       Obj.setQuestionId   (questionId   );
       Obj.setQuestionLabel(questionLabel);
       Obj.setAnswerSeq    (answerSeq    );
       Obj.setAnswerId     (answerId     );
       Obj.setAnswerLabel  (answerLabel  );
       Obj.setCorrect      (correct      );

       // Default Create-time setters
       Obj.setCreatedNow       ();
       Obj.setLastUpdatedNow   ();

       return (tilda.tutorial.data.TestQuestionAnswer_Data) Obj;
     }

   public static int writeBatch(Connection C, List<tilda.tutorial.data.TestQuestionAnswer_Data> L, int batchSize, int commitSize) throws Exception
     {
       long T0 = System.nanoTime();

       if (L == null || L.isEmpty() == true)
         return -1;

       java.sql.PreparedStatement PS = null;
       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();
       int count = 0;
       int batchStart = 0;
       TILDA__TESTQUESTIONANSWER lastObj = null;
       BitSet firstChangeList = (BitSet) ((TILDA__TESTQUESTIONANSWER) L.get(0)).__Changes.clone();
       String firstTimeStampSignature = ((TILDA__TESTQUESTIONANSWER) L.get(0)).getTimeStampSignature();

       try
         {
           C.setSavepoint();
           String Q = L.get(0).getWriteQuery(C);
           PS = C.prepareStatement(Q);
           int insertCount = 0;

           int index = -1;
           for (tilda.tutorial.data.TestQuestionAnswer_Data d : L)
             {
               ++index;
               if (d == null || d.hasChanged() == false)
                 continue;

               lastObj = ((TILDA__TESTQUESTIONANSWER) d);

               if (((TILDA__TESTQUESTIONANSWER) d).__Init != InitMode.CREATE)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.TestQuestionAnswer_Data' object at positon #" + index + " was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).");
                   QueryDetails.setLastQuery(TILDA__TESTQUESTIONANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }


               if (((TILDA__TESTQUESTIONANSWER) d).beforeWrite(C) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.TestQuestionAnswer_Data' object at positon #" + index + " failed in its beforeWrite() method.");
                   QueryDetails.setLastQuery(TILDA__TESTQUESTIONANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstChangeList.equals(((TILDA__TESTQUESTIONANSWER) d).__Changes) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.TestQuestionAnswer_Data' object at positon #" + index + " failed matching the list of columns being changed compared to the first object passed.");
                   QueryDetails.setLastQuery(TILDA__TESTQUESTIONANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
                   return index;
                 }

               if (firstTimeStampSignature.equals(((TILDA__TESTQUESTIONANSWER) d).getTimeStampSignature()) == false)
                 {
                   LOG.debug(QueryDetails._LOGGING_HEADER + "The 'tilda.tutorial.data.TestQuestionAnswer_Data' object at positon #" + index + " failed matching the list of updated current vs value based timestamps.");
                   QueryDetails.setLastQuery(TILDA__TESTQUESTIONANSWER_Factory.SCHEMA_TABLENAME_LABEL, "");
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
                       LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of tilda.tutorial.data.TestQuestionAnswer_Data objects between positions #" + batchStart + " and #" + index + " failed being written to the database.");
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
                   LOG.debug(QueryDetails._LOGGING_HEADER + "A batch of 'TestQuestionAnswer_Data' objects ending at position #" + index + " failed being written to the database.");
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
           TILDA__1_0.handleFinally(PS, T0, TILDA__TESTQUESTIONANSWER_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);
           PS = null;
           AllocatedArrays = null;
         }
       }

   static public tilda.tutorial.data.TestQuestionAnswer_Data lookupByPrimaryKey(long refnum) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER Obj = new tilda.tutorial.data.TestQuestionAnswer_Data();
       Obj.initForLookup(0);

       Obj.setRefnum       (refnum       ); Obj.__Saved_refnum        = Obj._refnum       ;

       return (tilda.tutorial.data.TestQuestionAnswer_Data) Obj;
     }

   static public tilda.tutorial.data.TestQuestionAnswer_Data lookupByFormAnswer(String type, String questionId, int answerSeq) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER Obj = new tilda.tutorial.data.TestQuestionAnswer_Data();
       Obj.initForLookup(1);

       Obj.setType         (type         ); 
       Obj.setQuestionId   (questionId   ); 
       Obj.setAnswerSeq    (answerSeq    ); 

       return (tilda.tutorial.data.TestQuestionAnswer_Data) Obj;
     }


   static public ListResults<tilda.tutorial.data.TestQuestionAnswer_Data> lookupWhereForm(Connection C, String type, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER Obj = new tilda.tutorial.data.TestQuestionAnswer_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setType         (type         );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, 2, RPI, Obj, null, start, size);
       return RPI._L;
     }

   static public void lookupWhereForm(Connection C, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.TestQuestionAnswer_Data> OP, String type, int start, int size) throws Exception
     {
       tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER Obj = new tilda.tutorial.data.TestQuestionAnswer_Data();
       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);

       Obj.setType         (type         );


       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, 2, RPI, Obj, null, start, size);
     }


   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }
   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }
   public static ListResults<tilda.tutorial.data.TestQuestionAnswer_Data> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);
       readMany(C, -7, RPI, null, Q, start, size);
       return RPI._L;
     }
   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<tilda.tutorial.data.TestQuestionAnswer_Data> OP, int start, int size) throws Exception
     {
       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);
       readMany(C, -7, RPI, null, Q, start, size);
     }
   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }
   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }


 }
