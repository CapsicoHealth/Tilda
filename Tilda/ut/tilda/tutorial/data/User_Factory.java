/*
 Tilda V1.0 template application class.
*/

package tilda.tutorial.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_User</B> mapped to the table <B>TILDATUTORIAL.User</B>.
@see tilda.tutorial.data._Tilda.TILDA__USER
*/
public class User_Factory extends tilda.tutorial.data._Tilda.TILDA__USER_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(User_Factory.class.getName());

   protected User_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
