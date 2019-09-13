/*
 Tilda V1.0 template application class.
*/

package tilda.data_tutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Test_XYZ_Analytics_Realized</B> mapped to the table <B>TILDATUTORIAL.Test_XYZ_Analytics_Realized</B>.
@see tilda.data_tutorial._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED
*/
public class Test_XYZ_Analytics_Realized_Factory extends tilda.data_tutorial._Tilda.TILDA__TEST_XYZ_ANALYTICS_REALIZED_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Test_XYZ_Analytics_Realized_Factory.class.getName());

   protected Test_XYZ_Analytics_Realized_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
