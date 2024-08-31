/*
 Tilda V1.0 template application class.
*/

package tilda.data_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Testing3View</B> mapped to the table <B>TILDATEST.Testing3View</B>.
@see tilda.data_test._Tilda.TILDA__TESTING3VIEW
*/
public class Testing3View_Factory extends tilda.data_test._Tilda.TILDA__TESTING3VIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Testing3View_Factory.class.getName());

   protected Testing3View_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
