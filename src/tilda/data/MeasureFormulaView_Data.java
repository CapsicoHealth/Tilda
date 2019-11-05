/*
 Tilda V1.0 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_MEASUREFORMULAVIEW</B> mapped to the table <B>TILDA.MEASUREFORMULAVIEW</B>.
@see tilda.data._Tilda.TILDA__MEASUREFORMULAVIEW
*/
public class MeasureFormulaView_Data extends tilda.data._Tilda.TILDA__MEASUREFORMULAVIEW
 {
   protected static final Logger LOG = LogManager.getLogger(MeasureFormulaView_Data.class.getName());

   public MeasureFormulaView_Data() { }

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
