/*
 Tilda V1.0 template application class.
*/

package tilda.tutorial.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Test_View</B> mapped to the table <B>TILDATUTORIAL.Test_View</B>.
@see tilda.tutorial.data._Tilda.TILDA__TEST_VIEW
*/
public class Test_View_Factory extends tilda.tutorial.data._Tilda.TILDA__TEST_VIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Test_View_Factory.class.getName());

   protected Test_View_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
