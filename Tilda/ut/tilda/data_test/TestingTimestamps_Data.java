/*
 Tilda V2.3 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_TestingTimestamps</B> mapped to the table <B>TILDATEST.TestingTimestamps</B>.
@see tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS
*/
public class TestingTimestamps_Data extends tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS
 {
   protected static final Logger LOG = LogManager.getLogger(TestingTimestamps_Data.class.getName());

   public TestingTimestamps_Data() { }

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
