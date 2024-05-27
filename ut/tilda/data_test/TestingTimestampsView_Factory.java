/*
 Tilda V2.5 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_TestingTimestampsView</B> mapped to the table <B>TILDATEST.TestingTimestampsView</B>.
@see tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW
*/
public class TestingTimestampsView_Factory extends tilda.data_test._Tilda.TILDA__TESTINGTIMESTAMPSVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TestingTimestampsView_Factory.class.getName());

   protected TestingTimestampsView_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
