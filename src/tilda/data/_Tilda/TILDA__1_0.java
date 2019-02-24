package tilda.data._Tilda;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.StatementType;
import tilda.performance.*;
import tilda.utils.*;


/** @author    Tilda code gen for Java 8/PostgreSQL
    @version   Tilda 1.0
    @generated Feb 23 2019, 22:23:34EST
*/
public final class TILDA__1_0
 {
   protected static final Logger LOG = LogManager.getLogger(TILDA__1_0.class.getName());

   protected static final String _COMMAQUESTION            =TextUtil.Identity(",?");
   protected static final String _EQUALQUESTION            =TextUtil.Identity("=?");

   protected static boolean HandleCatch(Connection C, java.sql.SQLException E, String OperationDebugStr) throws java.sql.SQLException
     {
       if (C.isLockOrConnectionError(E) == true)
        QueryDetails.setLastQueryDeadlocked();
       else if (E.getSQLState() == null)
        {
          LOG.warn("JDBC Error: No row "+OperationDebugStr+": SQLState is null, ErrorCode="+E.getErrorCode());
          LOG.warn("JDBC Message: "+E.getMessage());
          return false;
        }
       else if (C.isErrNoData(E.getSQLState(), E.getErrorCode()) == true)
        {
          LOG.warn("JDBC Error: No row "+OperationDebugStr+": SQLState="+E.getSQLState()+", ErrorCode="+E.getErrorCode());
          LOG.warn("JDBC Message: "+E.getMessage());
          return false;
        }
       LOG.error("JDBC Error: Fatal sql error: SQLState="+E.getSQLState()+", ErrorCode="+E.getErrorCode());
       LOG.catching(E);
       throw E;
     }

   protected static void HandleFinally(java.sql.PreparedStatement PS, long T0, String TableName, StatementType ST, int count, List<java.sql.Array> AllocatedArrays) throws java.sql.SQLException
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
      tilda.data._Tilda.TILDA__ZONEINFO_Factory.initObject(C);
      tilda.data._Tilda.TILDA__KEY_Factory.initObject(C);
      tilda.data._Tilda.TILDA__MAPPING_Factory.initObject(C);
      tilda.data._Tilda.TILDA__OBJECTPERF_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TRANSPERF_Factory.initObject(C);
      tilda.data._Tilda.TILDA__CONNECTION_Factory.initObject(C);
      tilda.data._Tilda.TILDA__JOBS_Factory.initObject(C);
      tilda.data._Tilda.TILDA__JOB_DETAIL_Factory.initObject(C);
      tilda.data._Tilda.TILDA__REFILLPERF_Factory.initObject(C);
      tilda.data._Tilda.TILDA__MAINTENANCE_Factory.initObject(C);
      tilda.data._Tilda.TILDA__FORMULA_Factory.initObject(C);
      tilda.data._Tilda.TILDA__MEASURE_Factory.initObject(C);
      tilda.data._Tilda.TILDA__MEASUREFORMULA_Factory.initObject(C);
      tilda.data._Tilda.TILDA__FORMULADEPENDENCY_Factory.initObject(C);
      tilda.data._Tilda.TILDA__FORMULARESULT_Factory.initObject(C);
      tilda.data._Tilda.TILDA__DEPENDENCYDDLDUMMYTABLE_Factory.initObject(C);
      tilda.data._Tilda.TILDA__DATEDIM_Factory.initObject(C);
      tilda.data._Tilda.TILDA__DATELIMITDIM_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TESTING_Factory.initObject(C);
      tilda.data._Tilda.TILDA__FORMULARESULTVIEW_Factory.initObject(C);
      tilda.data._Tilda.TILDA__FORMULADEPENDENCYVIEW_Factory.initObject(C);
      tilda.data._Tilda.TILDA__MEASUREFORMULAVIEW_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TESTINGVIEW_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TESTING2VIEW_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TESTING2REALIZED_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TESTING3VIEW_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TESTING3REALIZED_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TESTING4VIEW_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TESTING4REALIZED_Factory.initObject(C);
    }

 }
