package tilda.loader.csv;

import tilda.data.JobFile_Data;
import tilda.db.Connection;
import tilda.loader.csv.stores.CSVImporter;
import tilda.loader.csv.stores.IBMDB2CSVImporter;
import tilda.loader.csv.stores.MSSQLCSVImporter;
import tilda.loader.csv.stores.PostgreSQLCSVImporter;
import tilda.loader.parser.DataObject;

public class CSVImporterFactory
  {
    
    public static CSVImporter newInstance(Connection C, String rootFolder, DataObject cmsDO, Connection status, JobFile_Data jobFile) 
    throws Exception
      {
        switch(C.getDBTypeName())
        {
          case "PostgreSQL":
            return new PostgreSQLCSVImporter(C, rootFolder, cmsDO, status, jobFile);
          case "IBMDB2":
            return new IBMDB2CSVImporter(C, rootFolder, cmsDO, status, jobFile);
          case "MSSQL":
            return new MSSQLCSVImporter(C, rootFolder, cmsDO, status, jobFile);
        }
        throw new Exception("CSVImporter is not defined for DB Type: "+C.getDBTypeName());
      }
    
  }
