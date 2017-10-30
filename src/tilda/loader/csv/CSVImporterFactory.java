package tilda.loader.csv;

import tilda.db.Connection;
import tilda.loader.csv.stores.CSVImporter;
import tilda.loader.csv.stores.IBMDB2CSVImporter;
import tilda.loader.csv.stores.MSSQLCSVImporter;
import tilda.loader.csv.stores.PostgreSQLCSVImporter;
import tilda.loader.parser.DataObject;

public class CSVImporterFactory
  {
    
    public static CSVImporter newInstance(Connection C, Connection main, String rootFolder, DataObject cmsDO, long jobRefnum) 
    throws Exception
      {
        switch(C.getDBTypeName())
        {
          case "PostgreSQL":
            return new PostgreSQLCSVImporter(C, main, rootFolder, cmsDO, jobRefnum);
          case "IBMDB2":
            return new IBMDB2CSVImporter(C, main, rootFolder, cmsDO, jobRefnum);
          case "MSSQL":
            return new MSSQLCSVImporter(C, main, rootFolder, cmsDO, jobRefnum);
        }
        throw new Exception("CSVImporter is not defined for DB Type: "+C.getDBTypeName());
      }
    
  }
