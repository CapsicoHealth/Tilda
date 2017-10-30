package tilda;

import java.io.File;

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
    
    public static void process(long jobRefnum)
      {
        Connection C = null;
        try
          {
            C = ConnectionPool.get("MAIN");
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
            if (zipFile.exists() && zipFile.isFile()) 
              {
                String extractedPath = zipFile.getParent() + File.separator + zipFileName;
                
                UnZip unzipper = new UnZip();
                unzipper.unZipIt(filePath, extractedPath);              
                 
                String jsonFilePath = extractedPath + File.separator + zipFileName + ".json";
                File jsonFile = new File(jsonFilePath);
                if ( jsonFile.exists() && jsonFile.isFile() )
                  {
                    // Call tilda.LoadCLI
                  }
                else
                  {
                    throw new Exception("Unable to read JSON File in zip");
                  }
              }
            else 
              {
                throw new Exception("Unable to find Zip file");
              }
          }
        catch(Throwable T)
          {
            LOG.error("Exception while processing a Job", T);
          }
        finally
          {
            try {
              if(C != null)
                C.close();
            } catch (Exception E) { 
              // Do Nothing
            }
          }
        
        
        
      }
  }
