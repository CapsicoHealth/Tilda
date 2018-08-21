/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_Testing4View</B> mapped to the table <B>TILDA.Testing4View</B>.
@see tilda.data._Tilda.TILDA__TESTING4VIEW
*/
public class Testing4View_Data extends tilda.data._Tilda.TILDA__TESTING4VIEW
 {
   protected static final Logger LOG = LogManager.getLogger(Testing4View_Data.class.getName());

   public Testing4View_Data() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Override
   protected boolean AfterRead(Connection C) throws Exception
     {
       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
       return true;
     }

 }
