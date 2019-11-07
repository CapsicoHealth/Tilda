/*
 Tilda V1.0 template application class.
*/

package tilda.tutorial.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Test_XYZ_PivotView</B> mapped to the table <B>TILDATUTORIAL.Test_XYZ_PivotView</B>.
@see tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_PIVOTVIEW
*/
public class Test_XYZ_PivotView_Factory extends tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_PIVOTVIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Test_XYZ_PivotView_Factory.class.getName());

   protected Test_XYZ_PivotView_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
