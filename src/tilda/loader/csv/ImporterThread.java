package tilda.loader.csv;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.loader.csv.CSVImporter;
import tilda.loader.csv.CSVImporter.Results;
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
            result = CSVImporter.process(C, rootFolder, this.dataObject);
          }
        catch(Exception e) 
          {
            LOG.error("Exception in one of ImporterThread execution.", e);
            result = null;
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
