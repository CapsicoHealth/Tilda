/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
 * ===========================================================================
 */
package tilda.utils.gcp;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.cloud.bigquery.BigQueryError;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.Job;

public class JobHelper
  {
    protected static final Logger LOG = LogManager.getLogger(JobHelper.class.getName());

    public static Job completeJob(Job job)
      {
        return completeJob(job, null);
      }
    /**
     * 
     * @param job
     * @return
     * @throws InterruptedException
     */
    public static Job completeJob(Job job, List<String> errorMessages)
      {
        List<BigQueryError> errs = null;
        if (job == null)
          {
            errorMessages.add("Job is null.");
            return null;
          }
        try
          {
            LOG.info("Waiting for the BQ job to complete...");
            Job completedJob = job.waitFor();
            if (completedJob == null)
              {
                LOG.error("BigQuery job was not executed, or no longer exists.\n" + job.getStatus().getError());
                return null;
              }
            job = completedJob;
            errs = completedJob.getStatus().getExecutionErrors();
          }
        catch (BigQueryException E)
          {
            errs = new ArrayList<BigQueryError>();
            try
              {
                errs = E.getErrors();
              }
            catch (Exception X)
              {
                errs.add(E.getError());
              }
          }
        catch (InterruptedException E)
          {
            LOG.error("Error waiting for the job\n", E);
            return null;
          }
        if (errs != null && errs.isEmpty() == false)
          {
            StringBuilder str = new StringBuilder();
            int errorCount = 0;
            for (BigQueryError err : errs)
              {
                // LDH-NOTE: MAJOR HACK HERE!!!!!! We are getting back warning messages in the error list, and so we
                // think the job failed when it actually succeeded (we checked on the BQ side). So for now
                // we exclude explicit messages. Clearly a horrible thing to be doing!
                if (err.getMessage().indexOf("The input data has NULL values in one or more columns") == -1)
                  {
                    ++errorCount;
                  }
                String msg = err.getMessage() + ": " + err.getReason();
                if (errorMessages != null)
                 errorMessages.add(msg);
                str.append(" - " + msg + "\n");
              }
            LOG.error("BigQuery job was unable to load data to the table due to an error: \n" + str.toString());
            if (errorCount > 0)
              return null;
          }
        String stats = null;
        try // Bad Google... job.getStatistics can throw nullptr on their own internal API calls.
          {
            stats = job.getStatistics().toString();
          }
        catch (Exception E)
          {
            LOG.warn("job.getStatistics() threw an exception:\n", E);
            stats = E.getMessage();
          }
        LOG.info("BigQuery job completed successfully.\n" + stats + "\n");
        return job;
      }


  }
