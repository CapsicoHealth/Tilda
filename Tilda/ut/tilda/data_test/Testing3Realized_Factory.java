/*
 Tilda V1.0 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Testing3Realized</B> mapped to the table <B>TILDATEST.Testing3Realized</B>.
@see tilda.data_test._Tilda.TILDA__TESTING3REALIZED
*/
public class Testing3Realized_Factory extends tilda.data_test._Tilda.TILDA__TESTING3REALIZED_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Testing3Realized_Factory.class.getName());

   protected Testing3Realized_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
