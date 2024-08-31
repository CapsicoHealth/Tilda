/*
 Tilda V1.0 template application class.
*/

package tilda.tutorial.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_TestAnswer</B> mapped to the table <B>TILDATUTORIAL.TestAnswer</B>.
@see tilda.tutorial.data._Tilda.TILDA__TESTANSWER
*/
public class TestAnswer_Factory extends tilda.tutorial.data._Tilda.TILDA__TESTANSWER_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(TestAnswer_Factory.class.getName());

   protected TestAnswer_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
