/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Testing4View</B> mapped to the table <B>TILDA.Testing4View</B>.
@see tilda.data._Tilda.TILDA__TESTING4VIEW
*/
public class Testing4View_Factory extends tilda.data._Tilda.TILDA__TESTING4VIEW_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Testing4View_Factory.class.getName());

   protected Testing4View_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
