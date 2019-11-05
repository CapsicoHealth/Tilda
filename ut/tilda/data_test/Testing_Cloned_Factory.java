/*
 Tilda V1.0 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Testing_Cloned</B> mapped to the table <B>TILDATEST.Testing_Cloned</B>.
@see tilda.data_test._Tilda.TILDA__TESTING_CLONED
*/
public class Testing_Cloned_Factory extends tilda.data_test._Tilda.TILDA__TESTING_CLONED_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Testing_Cloned_Factory.class.getName());

   protected Testing_Cloned_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
