/*
 Tilda V2.3 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.*;

/**
This is the application class <B>Data_Catalog</B> mapped to the table <B>TILDA.Catalog</B>.
@see tilda.data._Tilda.TILDA__CATALOG
*/
public class Catalog_Factory extends tilda.data._Tilda.TILDA__CATALOG_Factory
 {
   protected static final Logger LOG = LogManager.getLogger(Catalog_Factory.class.getName());

   protected Catalog_Factory() { }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Implement your customizations, if any, below.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


   public static void init(Connection C) throws Exception
    {
      // Add logic to initialize your object, for example, caching some values, or validating some things.
    }

 }
