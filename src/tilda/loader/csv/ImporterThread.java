package tilda.loader.csv;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.loader.csv.stores.CSVImporter;
import tilda.loader.csv.stores.CSVImporter.Results;
import tilda.loader.parser.DataObject;

public class ImporterThread implements Callable<List<Results>>
  {
    protected static final Logger LOG                = LogManager.getLogger(ImporterThread.class.getName());

    String connectionId, rootFolder;
    DataObject dataObject;
    
    public ImporterThread(String connectionId, String rootFolder, DataObject dataObject)
      {
        this.connectionId = connectionId;
        this.rootFolder = rootFolder;
        this.dataObject = dataObject;
      }
    
    @Override
    public List<Results> call() throws Exception
      {
        Connection C = null;
        List<Results> result = null;
        try
          {
            C = ConnectionPool.get(this.connectionId);
            CSVImporter importer = CSVImporterFactory.newInstance(C, this.rootFolder, this.dataObject);            
            result = importer.process();
            if (result == null)
              throw new Exception("An error occurred processing one or more files from '"+this.rootFolder+"' for '"+this.dataObject._SchemaName+"."+this.dataObject._TableName+'.');
          }
        catch(Throwable T) 
          {
            LOG.error("Exception in one of ImporterThread execution.\n", T);
            result = new ArrayList<Results>();
            for (String file : this.dataObject._FileList)
             result.add(new Results(this.rootFolder+File.separatorChar+file, this.dataObject._SchemaName, this.dataObject._TableName, 0, 0));
          }
        finally
          {
            try
              {
                if (C != null)
                  C.close();
              }
            catch (SQLException e)
              {
                LOG.error("Error in the closing db connection: ", e);
              }
          }
        return result;
      }

  }
