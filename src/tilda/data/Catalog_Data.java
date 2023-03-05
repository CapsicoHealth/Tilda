/*
 Tilda V2.3 template application class.
*/

package tilda.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

/**
 * This is the application class <B>Data_Catalog</B> mapped to the table <B>TILDA.Catalog</B>.
 * 
 * @see tilda.data._Tilda.TILDA__CATALOG
 */
public class Catalog_Data extends tilda.data._Tilda.TILDA__CATALOG
  {
    protected static final Logger LOG = LogManager.getLogger(Catalog_Data.class.getName());

    public Catalog_Data()
      {
      }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Implement your customizations, if any, below.
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    protected boolean beforeWrite(Connection C)
    throws Exception
      {
        // Do things before writing the object to disk, for example, take care of AUTO fields.
        return true;
      }

    @Override
    protected boolean afterRead(Connection C)
    throws Exception
      {
        // Do things after an object has just been read form the data store, for example, take care of AUTO fields.
        return true;
      }


    public Catalog_Data(String schemaName, String tableViewName, String columnName, String type, String description)
      throws Exception
      {
        setSchemaName(schemaName);
        setTableViewName(tableViewName);
        setColumnName(columnName);
        setType(type);
        setDescription(description);
      }


  }
