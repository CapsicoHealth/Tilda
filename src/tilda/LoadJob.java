package tilda;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.JobFile_Data;
import tilda.data.JobFile_Factory;
import tilda.data.Job_Data;
import tilda.data.Job_Factory;
import tilda.db.Connection;
import tilda.db.ConnectionPool;
import tilda.db.ListResults;
import tilda.loader.csv.UnZip;

public class LoadJob
  {
    protected static final Logger LOG               = LogManager.getLogger(LoadJob.class.getName());
    
    public static void process(String statusConId, long jobRefnum)
      {
        
        // Get connectionId to pick jobs from instead of hardcoding 'MAIN'
        Connection C = null;
        String extractedPath = null;
        try
          {
            C = ConnectionPool.get(statusConId);
            Job_Data job = Job_Factory.LookupByPrimaryKey(jobRefnum);
            if (job.Read(C) == false) 
              {
                throw new Exception("Unable to read JOB from database");
              }
            
            JobFile_Data jobFile = JobFile_Factory.LookupByJob_Refnum(job.getRefnum());
            if(jobFile.Read(C) == false)
              {
                throw new Exception("Unable to read JOB File from database");
              }

            String filePath = jobFile.getFileName();
            File zipFile = new File(filePath);
            String zipFileName = FilenameUtils.getBaseName(zipFile.getName());
            
            if ( (zipFile.exists() && zipFile.isFile()) == false )
              {
                throw new Exception("Unable to find Zip file");
              }
            
            
            extractedPath = zipFile.getParent() + File.separator + zipFileName;
            String jsonFilePath = extractedPath + File.separator + zipFileName + ".json";
            String csvFilePath = extractedPath + File.separator + zipFileName + ".csv";
            String processedPath = zipFile.getParent() + File.separator + "processed";
            
            UnZip unzipper = new UnZip();
            unzipper.unZipIt(filePath, extractedPath);             

            File jsonFile = new File(jsonFilePath);
            if ( (jsonFile.exists() && jsonFile.isFile()) == false)
              {
                throw new Exception("Unable to read JSON File in zip");
              }
            
            Load.processLoadJob(job.getConnectionId(), job.getThreadsCount(), jsonFilePath, csvFilePath, job.getIsInsert(), job.getTruncateTable(), statusConId, job.getRefnum());
            FileUtils.moveFileToDirectory(zipFile, new File(processedPath), true);           
            
          }
        catch(Throwable T)
          {
            LOG.error("Exception while processing a Job", T);
          }
        finally
          {
            if (extractedPath != null)
                try
                  {
                    FileUtils.deleteDirectory(new File(extractedPath));
                  }
                catch (IOException e)
                  {
                    LOG.error("Failed to delete extracted folder: "+extractedPath, e);
                  }
            
            if(C != null)
              try 
                {
                  C.close();
                } 
              catch (Exception E) 
                { 
                  LOG.error("Failed to close DB Connection", E);
                }
          }
        
        
        
      }
  }
