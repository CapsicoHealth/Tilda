/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_FORMULADEPENDENCY</B> mapped to the table <B>TILDA.FORMULADEPENDENCY</B>.
@see tilda.data._Tilda.TILDA__FORMULADEPENDENCY
*/
public class FormulaDependency_Data extends tilda.data._Tilda.TILDA__FORMULADEPENDENCY
 {
   protected static final Logger LOG = LogManager.getLogger(FormulaDependency_Data.class.getName());

   public FormulaDependency_Data() { }

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
