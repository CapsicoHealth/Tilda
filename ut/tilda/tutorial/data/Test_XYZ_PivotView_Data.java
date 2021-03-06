/*
 Tilda V1.0 template application class.
*/

package tilda.tutorial.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_Test_XYZ_PivotView</B> mapped to the table <B>TILDATUTORIAL.Test_XYZ_PivotView</B>.
@see tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_PIVOTVIEW
*/
public class Test_XYZ_PivotView_Data extends tilda.tutorial.data._Tilda.TILDA__TEST_XYZ_PIVOTVIEW
 {
   protected static final Logger LOG = LogManager.getLogger(Test_XYZ_PivotView_Data.class.getName());

   public Test_XYZ_PivotView_Data() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Override
   protected boolean afterRead(Connection C) throws Exception
     {
       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
       return true;
     }

 }
