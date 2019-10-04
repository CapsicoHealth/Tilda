/*
 Tilda V1.0 template application class.
*/

package tilda.data_tutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_Test_Realized</B> mapped to the table <B>TILDATUTORIAL.Test_Realized</B>.
@see tilda.data_tutorial._Tilda.TILDA__TEST_REALIZED
*/
public class Test_Realized_Data extends tilda.data_tutorial._Tilda.TILDA__TEST_REALIZED
 {
   protected static final Logger LOG = LogManager.getLogger(Test_Realized_Data.class.getName());

   public Test_Realized_Data() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Override
   protected boolean afterRead(Connection C) throws Exception
     {
       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
       return true;
     }

 }
