package tilda.loader.csv;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.JobFile_Data;
import tilda.data.JobFile_Factory;
import tilda.data.JobMessage_Data;
import tilda.data.JobMessage_Factory;
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
    long jobFileRefnum = -666;
    
    public ImporterThread(String connectionId, DataObject dataObject, String statusConId, long jobFileRefnum)
      {
        this.connectionId = connectionId;
        this.dataObject = dataObject;
        this.statusConId = statusConId;
        this.jobFileRefnum = jobFileRefnum;
      }
    
    @Override
    public List<Results> call() throws Exception
      {
        Connection C            = null;
        Connection statusCon    = null;
        JobFile_Data jobFile    = null;
        List<Results> result    = null;
        try
          {
            // If we are working on a Job, we need a connection to update status
            if(jobFileRefnum > 0)
              statusCon = ConnectionPool.get(statusConId);            
            
            if (statusCon != null)
              {
                jobFile = JobFile_Factory.LookupByPrimaryKey(jobFileRefnum);
                jobFile.Read(statusCon);
              }
            
            C = ConnectionPool.get(this.connectionId);
            CSVImporter importer = CSVImporterFactory.newInstance(C, this.dataObject, statusCon, jobFile);            
            result = importer.process();
          }
        catch(Throwable T) 
          {
            LOG.error("Error while importing CSV Data\n", T);            
            if (C != null)
              {
                try
                  {
                    C.rollback();
                  }
                catch (Exception E)
                  {
                    LOG.error("Cannot rollback???\n", E);
                  }
              }
            if (statusCon != null && jobFile != null)
              {
                try
                  {
                    jobFile.setStatusFailure();
                    jobFile.Write(statusCon);
                    
                    JobMessage_Data jobMessage = JobMessage_Factory.Create(jobFile.getJobRefnum(), jobFile.getRefnum(), T.getMessage());
                    jobMessage.setIsError(true);
                    jobMessage.Write(statusCon);
                    statusCon.commit();
                  }
                catch(Exception E)
                  {
                    LOG.error("Exception while copying Exception message to JobMessage", E);
                    throw E;
                  }
              }
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
