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
      tilda.data._Tilda.TILDA__ZONEINFO_Factory.initObject(C);
      tilda.data._Tilda.TILDA__KEY_Factory.initObject(C);
      tilda.data._Tilda.TILDA__CATALOG_Factory.initObject(C);
      tilda.data._Tilda.TILDA__CATALOGFORMULARESULT_Factory.initObject(C);
      tilda.data._Tilda.TILDA__MAINTENANCELOG_Factory.initObject(C);
      tilda.data._Tilda.TILDA__TRANSPERF_Factory.initObject(C);
      tilda.data._Tilda.TILDA__REFILLPERF_Factory.initObject(C);
      tilda.data._Tilda.TILDA__MAPPING_Factory.initObject(C);
      tilda.data._Tilda.TILDA__CONNECTION_Factory.initObject(C);
      tilda.data._Tilda.TILDA__JOB_Factory.initObject(C);
      tilda.data._Tilda.TILDA__JOBPART_Factory.initObject(C);
      tilda.data._Tilda.TILDA__JOBPARTMESSAGE_Factory.initObject(C);
      tilda.data._Tilda.TILDA__OBJECTPERF_Factory.initObject(C);
      tilda.data._Tilda.TILDA__FAILEDDEPENDENCYDDLSCRIPTS_Factory.initObject(C);
      tilda.data._Tilda.TILDA__DATEDIM_Factory.initObject(C);
      tilda.data._Tilda.TILDA__DATELIMITDIM_Factory.initObject(C);
      tilda.data._Tilda.TILDA__FORMULARESULTVIEW_Factory.initObject(C);
      tilda.data._Tilda.TILDA__JOBVIEW_Factory.initObject(C);
    }

 }
