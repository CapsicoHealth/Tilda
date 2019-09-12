/*
 Tilda V1.0 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_TestingView</B> mapped to the table <B>TILDATEST.TestingView</B>.
@see tilda.data_test._Tilda.TILDA__TESTINGVIEW
*/
public class TestingView_Factory extends tilda.data_test._Tilda.TILDA__TESTINGVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TestingView_Factory.class.getName());

   protected TestingView_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
