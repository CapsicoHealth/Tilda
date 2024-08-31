/*
 Tilda V1.0 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_TestView</B> mapped to the table <B>TILDATEST.TestView</B>.
@see tilda.data_test._Tilda.TILDA__TESTVIEW
*/
public class TestView_Factory extends tilda.data_test._Tilda.TILDA__TESTVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TestView_Factory.class.getName());

   protected TestView_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
