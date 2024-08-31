/*
 Tilda V2.3 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
This is the application class <B>Data_CatalogFormulaResult</B> mapped to the table <B>TILDA.CatalogFormulaResult</B>.
@see tilda.data._Tilda.TILDA__CATALOGFORMULARESULT
*/
public class CatalogFormulaResult_Data extends tilda.data._Tilda.TILDA__CATALOGFORMULARESULT
 {
   protected static final Logger LOG = LogManager.getLogger(CatalogFormulaResult_Data.class.getName());

   public CatalogFormulaResult_Data() { }

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
