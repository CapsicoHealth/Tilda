/*
 Tilda V1.0 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Test_XYZ_Analytics_View</B> mapped to the table <B>TILDATEST.Test_XYZ_Analytics_View</B>.
@see tilda.data_test._Tilda.TILDA__TEST_XYZ_ANALYTICS_VIEW
*/
public class Test_XYZ_Analytics_View_Factory extends tilda.data_test._Tilda.TILDA__TEST_XYZ_ANALYTICS_VIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Test_XYZ_Analytics_View_Factory.class.getName());

   protected Test_XYZ_Analytics_View_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
