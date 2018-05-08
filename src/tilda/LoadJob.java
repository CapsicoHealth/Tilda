package tilda;

import java.io.File;
import java.sql.SQLException;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.JobFile_Data;
import tilda.data.JobFile_Factory;
import tilda.data.JobMessage_Data;
import tilda.data.JobMessage_Factory;
import tilda.data.Job_Data;
import tilda.data.Job_Factory;
import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.ListResults;
import tilda.utils.FileUtil;
import tilda.utils.TextUtil;

public class LoadJob
  {
    protected static final Logger LOG               = LogManager.getLogger(LoadJob.class.getName());
    
    public static void process(String statusConId, long jobRefnum)
      {
        Connection statusCon = null;
        String processedPath = null;
        File zipFile = null;
        Job_Data job = null;
        JobFile_Data jobFile = null;
        try
          {
            statusCon = ConnectionPool.get(statusConId);
            job = Job_Factory.LookupByPrimaryKey(jobRefnum);
            if (job.Read(statusCon) == false) 
              {
                throw new Exception("Unable to read JOB from database");
              }
            
            zipFile = FileUtil.getFileOrResource(job.getZipFile());
            processedPath = zipFile.getParent() + File.separator + "processed";
            
            if ( (zipFile.exists() && zipFile.isFile()) == false )
              {
                throw new Exception("Unable to find Zip file");
              }
            
            // TODO: Remove JSON file hard code.
            File jsonFile = FileUtil.getFileOrResource("config.Load.json");
            if ( (jsonFile.exists() && jsonFile.isFile()) == false)
              {
                throw new Exception("Unable to read JSON Config file");
              }
           
            ListResults<JobFile_Data> jobFiles = JobFile_Factory.getJobFilesByJobRefnum(statusCon, job.getRefnum(), 0, 100);
            Iterator<JobFile_Data> filesIterator = jobFiles.iterator();
            while (filesIterator.hasNext())
              {
                jobFile = filesIterator.next();
                if (jobFile.Read(statusCon) == false) 
                  {
                    throw new Exception("Unable to read Job file from Database");
                  }
                
                jobFile.setStatusRunning();
                jobFile.setFileProcessStartTimeNow();
                jobFile.Write(statusCon);
                statusCon.commit();
                
                String filename = jobFile.getFileName();
                String[] values = TextUtil.Split(filename, "\\.");

                Load.processLoadJob(job.getConnectionId(), job.getThreadsCount(), jsonFile.getAbsolutePath(), values[0], values[1], job.getZipFile(), filename, job.getLoadMode(), false, statusConId, jobFile);
                
                jobFile.Refresh(statusCon);
                if(jobFile.isStatusFailure() == true)
                  {
                    throw new Exception("Failed to process JobFile: "+jobFile.getRefnum());
                  }
            
                jobFile.setStatusSuccess();
                jobFile.setFileProcessEndTimeNow();
                jobFile.Write(statusCon);
                statusCon.commit();
              }
            moveFileToProcessedFolder(jobRefnum, zipFile, processedPath);
          }
        catch(Throwable T)
          {
            LOG.error("Exception while processing a Job", T);
            if(statusCon != null)
              {
                try
                  {
                    if (jobFile != null)
                      {
                        jobFile.setStatusFailure();
                        jobFile.Write(statusCon);
                        
                        JobMessage_Data jobMessage = JobMessage_Factory.Create(jobFile.getJobRefnum(), jobFile.getRefnum(), T.getMessage());
                        jobMessage.setIsError(true);
                        jobMessage.Write(statusCon);                        
                      }
//                    if(job != null)
//                      {
//                        job.setError(T.getMessage());
//                        job.setStatusDone();
//                        job.Write(statusCon);
//                      }
                    statusCon.commit();
                  }
                catch(Exception E)
                  {
                    LOG.error("Exception while copying Exception message to JobMessage", E);
                  }
              }
          }
        finally
          {
            closeDBConnection(statusCon);            
          }
        
      }

    private static void moveFileToProcessedFolder(long jobRefnum, File zipFile, String processedPath)
      {
        try
          {
            if (zipFile != null && zipFile.exists() && zipFile.isFile()) {
              String newName = zipFile.getParentFile().getAbsolutePath() + File.separator + jobRefnum + "_" + zipFile.getName();
              zipFile.renameTo(new File(newName));
              zipFile = new File(newName);
              FileUtils.moveFileToDirectory(zipFile, new File(processedPath), true);
            }
          }
        catch (Exception e)
          {
            LOG.error("Failed to move zipFile "+zipFile.getName()+" to processed folder", e);
          }
      }

    private static void closeDBConnection(Connection C)
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
