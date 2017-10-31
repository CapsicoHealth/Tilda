package tilda.loader.csv;

import java.sql.SQLException;
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

    String connectionId, statusConId, rootFolder;
    DataObject dataObject;
    long jobRefnum = -666;
    
    public ImporterThread(String connectionId, String rootFolder, DataObject dataObject, String statusConId, long jobRefnum)
      {
        this.connectionId = connectionId;
        this.rootFolder = rootFolder;
        this.dataObject = dataObject;
        this.statusConId = statusConId;
        this.jobRefnum = jobRefnum;
      }
    
    @Override
    public List<Results> call() throws Exception
      {
        Connection C            = null;
        Connection statusCon    = null;
        List<Results> result    = null;
        try
          {
            if(jobRefnum > 0)
              statusCon = ConnectionPool.get(statusConId);
            
            C = ConnectionPool.get(this.connectionId);
            CSVImporter importer = CSVImporterFactory.newInstance(C, this.rootFolder, this.dataObject, statusCon, jobRefnum);            
            result = importer.process();
          }
        catch(Throwable T) 
          {
            LOG.error("Exception in one of ImporterThread execution.", T);
            result = null;
          }
        finally
          {
            closeDBConnection(C);
            closeDBConnection(statusCon);
          }
        return result;
      }

    private void closeDBConnection(Connection C)
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

  }
