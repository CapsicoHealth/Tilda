/*
 Tilda V1.0 template application class.
*/

package tilda.data_tutorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_TestQuestionAnswer</B> mapped to the table <B>TILDATUTORIAL.TestQuestionAnswer</B>.
@see tilda.data_tutorial._Tilda.TILDA__TESTQUESTIONANSWER
*/
public class TestQuestionAnswer_Data extends tilda.data_tutorial._Tilda.TILDA__TESTQUESTIONANSWER
 {
   protected static final Logger LOG = LogManager.getLogger(TestQuestionAnswer_Data.class.getName());

   public TestQuestionAnswer_Data() { }

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
