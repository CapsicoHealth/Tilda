/*
 Tilda V2.3 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_MaintenanceLog</B> mapped to the table <B>TILDA.MaintenanceLog</B>.
@see tilda.data._Tilda.TILDA__MAINTENANCELOG
*/
public class MaintenanceLog_Data extends tilda.data._Tilda.TILDA__MAINTENANCELOG
 {
   protected static final Logger LOG = LogManager.getLogger(MaintenanceLog_Data.class.getName());

   public MaintenanceLog_Data() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Override
   protected boolean beforeWrite(Connection C) throws Exception
     {
       // Do things before writing the object to disk, for example, take care of AUTO fields.
       return true;
     }

   @Override
   protected boolean afterRead(Connection C) throws Exception
     {
       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
       return true;
     }

 }
