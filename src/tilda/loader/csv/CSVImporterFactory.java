package tilda.loader.csv;

import tilda.db.Connection;
import tilda.loader.csv.stores.CSVImporter;
import tilda.loader.csv.stores.IBMDB2CSVImporter;
import tilda.loader.csv.stores.MSSQLCSVImporter;
import tilda.loader.csv.stores.PostgreSQLCSVImporter;
import tilda.loader.parser.DataObject;

public class CSVImporterFactory
  {
    
    public static CSVImporter newInstance(Connection C, String rootFolder, DataObject cmsDO) 
    throws Exception
      {
        switch(C.getDBTypeName())
        {
          case "PostgreSQL":
            return new PostgreSQLCSVImporter(C, rootFolder, cmsDO);
          case "IBMDB2":
            return new IBMDB2CSVImporter(C, rootFolder, cmsDO);
          case "MSSQL":
            return new MSSQLCSVImporter(C, rootFolder, cmsDO);
        }
        throw new Exception("CSVImporter is not defined for DB Type: "+C.getDBTypeName());
      }
    
  }
