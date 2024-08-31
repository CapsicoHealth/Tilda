/*
 Tilda V2.5 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_TestingTimestampsView</B> mapped to the table <B>TILDATEST.TestingTimestampsView</B>.
@see tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW
*/
public class TestingTimestampsView_Data extends tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW
 {
   protected static final Logger LOG = LogManager.getLogger(TestingTimestampsView_Data.class.getName());

   public TestingTimestampsView_Data() { }

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
