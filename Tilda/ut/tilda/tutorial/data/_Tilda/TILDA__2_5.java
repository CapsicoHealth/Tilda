package tilda.tutorial.data._Tilda;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.StatementType;
import tilda.performance.*;
import tilda.utils.*;


/** @author    Tilda code gen for Java 8/PostgreSQL
    @version   Tilda 1.0
*/
public final class TILDA__2_5
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__2_5.class.getName());

   protected static final String _COMMAQUESTION            =TextUtil.identity(",?");
   protected static final String _EQUALQUESTION            =TextUtil.identity("=?");

   protected static void handleFinally(java.sql.PreparedStatement PS, long T0, String TableName, StatementType ST, int count, List<java.sql.Array> AllocatedArrays) throws java.sql.SQLException
     {
       if (PS != null)
        PS.close();
       PerfTracker.add(TableName, ST, System.nanoTime()-T0, count);
       if (AllocatedArrays != null)
        {
          for (java.sql.Array A : AllocatedArrays)
           A.free();
          AllocatedArrays.clear();
        }
     }

   public static void initSchema(Connection C) throws Exception
    {
      tilda.tutorial.data._Tilda.TILDA__USER_Factory.initObject(C);
      tilda.tutorial.data._Tilda.TILDA__FORM_Factory.initObject(C);
      tilda.tutorial.data._Tilda.TILDA__FORMANSWER_Factory.initObject(C);
      tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER_Factory.initObject(C);
      tilda.tutorial.data._Tilda.TILDA__TESTANSWER_Factory.initObject(C);
      tilda.tutorial.data._Tilda.TILDA__FORM_SAT01_PIVOTVIEW_Factory.initObject(C);
    }

 }
