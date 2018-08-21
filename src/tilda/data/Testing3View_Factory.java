/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Testing3View</B> mapped to the table <B>TILDA.Testing3View</B>.
@see tilda.data._Tilda.TILDA__TESTING3VIEW
*/
public class Testing3View_Factory extends tilda.data._Tilda.TILDA__TESTING3VIEW_Factory
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
