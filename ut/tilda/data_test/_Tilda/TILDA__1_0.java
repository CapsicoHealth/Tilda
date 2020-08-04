package tilda.data_test._Tilda;

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
public final class TILDA__1_0
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__1_0.class.getName());

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
      tilda.data_test._Tilda.TILDA__TEST_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TEST2_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TESTING_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TESTING_CLONED_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TESTVIEW_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TESTINGVIEW_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TESTING2VIEW_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TESTING2REALIZED_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TESTING3VIEW_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TESTING3REALIZED_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TESTING4VIEW_Factory.initObject(C);
      tilda.data_test._Tilda.TILDA__TESTING4REALIZED_Factory.initObject(C);
    }

 }
