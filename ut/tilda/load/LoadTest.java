package tilda.load;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.Load;
import tilda.LoadJob;
import tilda.db.ConnectionPool;

public class LoadTest
  {
    
    protected static final Logger LOG = LogManager.getLogger(LoadTest.class.getName());

    public static void main(String[] args)
      {
        LOG.info("\n*************************************************************************************************************************************");
        ConnectionPool.autoInit();
        LOG.info("\n*************************************************************************************************************************************\n");

        long JOBREFNUM = 123;
        String statusConId = "JOBS";
        
        LoadJob.process(statusConId, JOBREFNUM);
      
      }
  }
