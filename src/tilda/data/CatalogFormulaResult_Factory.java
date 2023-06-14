/*
 Tilda V2.3 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_CatalogFormulaResult</B> mapped to the table <B>TILDA.CatalogFormulaResult</B>.
@see tilda.data._Tilda.TILDA__CATALOGFORMULARESULT
*/
public class CatalogFormulaResult_Factory extends tilda.data._Tilda.TILDA__CATALOGFORMULARESULT_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(CatalogFormulaResult_Factory.class.getName());

   protected CatalogFormulaResult_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
