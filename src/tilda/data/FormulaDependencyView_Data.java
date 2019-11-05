/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_FORMULADEPENDENCYVIEW</B> mapped to the table <B>TILDA.FORMULADEPENDENCYVIEW</B>.
@see tilda.data._Tilda.TILDA__FORMULADEPENDENCYVIEW
*/
public class FormulaDependencyView_Data extends tilda.data._Tilda.TILDA__FORMULADEPENDENCYVIEW
 {
   protected static final Logger LOG = LogManager.getLogger(FormulaDependencyView_Data.class.getName());

   public FormulaDependencyView_Data() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   @Override
   protected boolean afterRead(Connection C) throws Exception
     {
       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
       return true;
     }

 }
