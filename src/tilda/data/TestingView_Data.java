/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_TestingView</B> mapped to the table <B>TILDA.TestingView</B>.
@see tilda.data._Tilda.TILDA__TESTINGVIEW
*/
public class TestingView_Data extends tilda.data._Tilda.TILDA__TESTINGVIEW
 {
   protected static final Logger LOG = LogManager.getLogger(TestingView_Data.class.getName());

   public TestingView_Data() { }

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
