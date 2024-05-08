/*
 Tilda V2.3 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_TestingTimestamps</B> mapped to the table <B>TILDATEST.TestingTimestamps</B>.
@see tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS
*/
public class TestingTimestamps_Factory extends tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPS_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TestingTimestamps_Factory.class.getName());

   protected TestingTimestamps_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
