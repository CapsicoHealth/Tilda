package tilda.utils.gcp;

import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.TableResult;

public class JobResults
  {
    protected JobResults(Job j, TableResult r)
      {
        _j = j;
        _r = r;
      }

    public final Job         _j;
    public final TableResult _r;
  }
