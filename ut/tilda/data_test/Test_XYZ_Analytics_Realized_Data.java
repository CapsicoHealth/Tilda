/*
 Tilda V1.0 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_Test_XYZ_Analytics_Realized</B> mapped to the table <B>TILDATEST.Test_XYZ_Analytics_Realized</B>.
@see tilda.data_test._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED
*/
public class Test_XYZ_Analytics_Realized_Data extends tilda.data_test._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED
 {
   protected static final Logger LOG = LogManager.getLogger(Test_XYZ_Analytics_Realized_Data.class.getName());

   public Test_XYZ_Analytics_Realized_Data() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Override
   protected boolean AfterRead(Connection C) throws Exception
     {
       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
       return true;
     }

 }
