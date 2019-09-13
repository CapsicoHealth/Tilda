/*
 Tilda V1.0 template application class.
*/

package tilda.data_tutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_TestAnswer</B> mapped to the table <B>TILDATUTORIAL.TestAnswer</B>.
@see tilda.data_tutorial._Tilda.TILDA__TESTANSWER
*/
public class TestAnswer_Data extends tilda.data_tutorial._Tilda.TILDA__TESTANSWER
 {
   protected static final Logger LOG = LogManager.getLogger(TestAnswer_Data.class.getName());

   public TestAnswer_Data() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Override
   protected boolean BeforeWrite(Connection C) throws Exception
     {
       // Do things before writing the object to disk, for example, take care of AUTO fields.
       return true;
     }

   @Override
   protected boolean AfterRead(Connection C) throws Exception
     {
       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
       return true;
     }

 }
