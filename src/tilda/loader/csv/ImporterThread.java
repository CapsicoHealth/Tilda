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

    String connectionId, rootFolder;
    DataObject dataObject;
    long jobRefnum = -666;
    
    public ImporterThread(String connectionId, String rootFolder, DataObject dataObject, long jobRefnum)
      {
        this.connectionId = connectionId;
        this.rootFolder = rootFolder;
        this.dataObject = dataObject;
        this.jobRefnum = jobRefnum;
      }  
    
    
    @Override
    public List<Results> call() throws Exception
      {
        Connection C    = null;
        Connection main = null;
        List<Results> result = null;
        try
          {
            if(jobRefnum > 0)
              main = ConnectionPool.get("MAIN");
            
            C = ConnectionPool.get(this.connectionId);
            CSVImporter importer = CSVImporterFactory.newInstance(C, main, this.rootFolder, this.dataObject, jobRefnum);            
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
            closeDBConnection(main);
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
