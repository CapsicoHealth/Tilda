/*
 Tilda V1.0 template application class.
*/

package tilda.tutorial.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_TestQuestionAnswer</B> mapped to the table <B>TILDATUTORIAL.TestQuestionAnswer</B>.
@see tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER
*/
public class TestQuestionAnswer_Data extends tilda.tutorial.data._Tilda.TILDA__TESTQUESTIONANSWER
 {
   protected static final Logger LOG = LogManager.getLogger(TestQuestionAnswer_Data.class.getName());

   public TestQuestionAnswer_Data() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Override
   protected boolean beforeWrite(Connection C) throws Exception
     {
       // Do things before writing the object to disk, for example, take care of AUTO fields.
       return true;
     }

   @Override
   protected boolean afterRead(Connection C) throws Exception
     {
       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
       return true;
     }

 }
