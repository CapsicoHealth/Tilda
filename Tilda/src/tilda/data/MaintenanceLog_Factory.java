/*
 Tilda V2.3 template application class.
*/

package tilda.data;

import java.time.ZonedDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_MaintenanceLog</B> mapped to the table <B>TILDA.MaintenanceLog</B>.
@see tilda.data._Tilda.TILDA__MAINTENANCELOG
*/
public class MaintenanceLog_Factory extends tilda.data._Tilda.TILDA__MAINTENANCELOG_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(MaintenanceLog_Factory.class.getName());

   protected MaintenanceLog_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

  public static MaintenanceLog_Data create(Connection C, String type, String schemaLabel, String objectName, ZonedDateTime startZDT, ZonedDateTime endZDT, String action, String objectType, String statement, String descr)
  throws Exception
    {
      MaintenanceLog_Data M = MaintenanceLog_Factory.create(type, schemaLabel, startZDT);
      M.setObjectName(objectName);
      M.setEndTime(endZDT);
      M.setAction(action);
      M.setObjectType(objectType);
      M.setStatement(statement);
      M.setDescr(descr);
      return M;
    }

 }
