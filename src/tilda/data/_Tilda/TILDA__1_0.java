package tilda.data._Tilda;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;
import tilda.enums.StatementType;
import tilda.performance.*;
import tilda.utils.*;


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
       if (PS != null) PS.close(); 
       PerfTracker.add(TableName, ST, System.nanoTime()-T0, count);
       for (java.sql.Array A : AllocatedArrays)
        A.free();
       AllocatedArrays.clear();
     }

   public static void initSchema(Connection C) throws Exception
    {
      tilda.data._Tilda.TILDA__ZONEINFO_Factory.initObject(C);
      tilda.data._Tilda.TILDA__KEY_Factory.initObject(C);
      tilda.data._Tilda.TILDA__OBJECTPERF_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TRANSPERF_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TESTING_Factory.initObject(C);
    }

 }
