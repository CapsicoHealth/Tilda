package tilda;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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
import tilda.loader.csv.UnZip;
import tilda.utils.TextUtil;

public class LoadJob
  {
    protected static final Logger LOG               = LogManager.getLogger(LoadJob.class.getName());
    
    public static void process(String statusConId, long jobRefnum)
      {
        Connection statusCon = null;
        String extractedPath = null, processedPath = null;
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
            
            zipFile = new File(job.getZipFile());
            String zipFileName = FilenameUtils.getBaseName(zipFile.getName());
            extractedPath = zipFile.getParent() + File.separator + zipFileName;
            processedPath = zipFile.getParent() + File.separator + "processed";
            
            if ( (zipFile.exists() && zipFile.isFile()) == false )
              {
                throw new Exception("Unable to find Zip file");
              }
            
            String jsonFilePath = zipFile.getParent() + File.separator + "config.UnifiedClaims.json";
            // TODO: Remove JSON file hard code.
            File jsonFile = new File(jsonFilePath);
            if ( (jsonFile.exists() && jsonFile.isFile()) == false)
              {
                throw new Exception("Unable to read JSON Config file");
              }
            
            UnZip unzipper = new UnZip();
            unzipper.unZipIt(job.getZipFile(), extractedPath);             

            ListResults<JobFile_Data> jobFiles = JobFile_Factory.getJobFilesByJobRefnum(statusCon, job.getRefnum(), 0, 100);
            Iterator<JobFile_Data> filesIterator = jobFiles.iterator();
            while (filesIterator.hasNext())
              {
                jobFile = filesIterator.next();
                if (jobFile.Read(statusCon) == false) 
                  {
                    throw new Exception("Unable to read Job file from Database");
                  }
                
                String csvFilePath = extractedPath + File.separator + jobFile.getFileName();
                
                jobFile.setStatusRunning();
                jobFile.setFileProcessStartTimeNow();
                jobFile.Write(statusCon);
                statusCon.commit();
                
                String filename = jobFile.getFileName();
                String[] values = TextUtil.Split(filename, "\\.");

                Load.processLoadJob(job.getConnectionId(), job.getThreadsCount(), jsonFilePath, values[0], values[1], csvFilePath, job.getIsInsert(), job.getTruncateTable(), statusConId, jobFile);
            
                jobFile.setStatusSuccess();
                jobFile.setFileProcessEndTimeNow();
                jobFile.Write(statusCon);
                statusCon.commit();
              }
            
            FileUtils.moveFileToDirectory(zipFile, new File(processedPath), true);
          }
        catch(Throwable T)
          {
            LOG.error("Exception while processing a Job", T);
            if (statusCon != null && jobFile != null)
              {
                try
                  {
                    jobFile.setStatusFailure();
                    jobFile.Write(statusCon);
                    
                    JobMessage_Data jobMessage = JobMessage_Factory.Create(jobFile.getRefnum(), T.getMessage());
                    jobMessage.setIsError(true);
                    jobMessage.Write(statusCon);
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
            moveFileToProcessedFolder(zipFile, processedPath);
            deleteExtractedFolder(extractedPath);
            closeDBConnection(statusCon);
          }
        
      }

    private static void moveFileToProcessedFolder(File zipFile, String processedPath)
      {
        try
          {
            if (zipFile != null && zipFile.exists() && zipFile.isFile())
              FileUtils.moveFileToDirectory(zipFile, new File(processedPath), true);
          }
        catch (Exception e)
          {
            LOG.error("Failed to move zipFile "+zipFile.getName()+" to processed folder", e);
          }
      }

    private static void deleteExtractedFolder(String extractedPath)
      {
        try
          {
            if (extractedPath != null)
              FileUtils.deleteDirectory(new File(extractedPath));
          }
        catch (IOException e)
          {
            LOG.error("Failed to delete extracted folder: "+extractedPath, e);
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
