/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_Testing2Realized</B> mapped to the table <B>TILDA.Testing2Realized</B>.
@see tilda.data._Tilda.TILDA__TESTING2REALIZED
*/
public class Testing2Realized_Data extends tilda.data._Tilda.TILDA__TESTING2REALIZED
 {
   protected static final Logger LOG = LogManager.getLogger(Testing2Realized_Data.class.getName());

   public Testing2Realized_Data() { }

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
