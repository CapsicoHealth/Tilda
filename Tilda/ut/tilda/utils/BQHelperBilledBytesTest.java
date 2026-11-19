package tilda.utils;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import com.google.api.services.bigquery.model.JobConfiguration;
import com.google.api.services.bigquery.model.JobConfigurationQuery;
import com.google.api.services.bigquery.model.JobReference;
import com.google.api.services.bigquery.model.JobStatistics;
import com.google.api.services.bigquery.model.JobStatistics2;
import com.google.api.services.bigquery.model.JobStatus;
import com.google.cloud.NoCredentials;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.QueryJobConfiguration;

import tilda.utils.gcp.BQHelper;
import tilda.utils.gcp.BQHelper.BilledBytesTracker;

public class BQHelperBilledBytesTest
  {
    private static BigQuery bigQuery() throws Exception
      {
        Map<String, String> jobs = new ConcurrentHashMap<String, String>();
        Method fromPb = Job.class.getDeclaredMethod("fromPb", BigQuery.class, com.google.api.services.bigquery.model.Job.class);
        fromPb.setAccessible(true);
        BigQueryOptions options = BigQueryOptions.newBuilder().setProjectId("test").setCredentials(NoCredentials.getInstance()).build();
        return (BigQuery) Proxy.newProxyInstance(BQHelperBilledBytesTest.class.getClassLoader(), new Class<?>[] { BigQuery.class }, (proxy, method, args) -> {
          if (method.getName().equals("getOptions"))
            return options;
          if (method.getName().equals("query"))
            {
              if (args.length == 3)
                {
                  JobId id = (JobId) args[1];
                  assertNotNull("tracked queries need an assigned job ID", id.getJob());
                  String query = ((QueryJobConfiguration) args[0]).getQuery();
                  jobs.put(id.getJob(), query);
                  if (query.equals("fail"))
                    throw new IllegalStateException("query failed");
                }
              return null;
            }
          if (method.getName().equals("getJob"))
            {
              JobId id = (JobId) args[0];
              String query = jobs.get(id.getJob());
              if (query == null || query.equals("missing"))
                return null;
              Long bytes = query.equals("fail") ? Long.valueOf(7) : Long.valueOf(query);
              com.google.api.services.bigquery.model.Job job = new com.google.api.services.bigquery.model.Job()
              .setJobReference(new JobReference().setProjectId("test").setJobId(id.getJob()).setLocation("US"))
              .setConfiguration(new JobConfiguration().setQuery(new JobConfigurationQuery().setQuery("select 1")))
              .setStatus(new JobStatus().setState("DONE"))
              .setStatistics(new JobStatistics().setQuery(new JobStatistics2().setTotalBytesBilled(bytes)));
              try
                {
                  return fromPb.invoke(null, proxy, job);
                }
              catch (ReflectiveOperationException E)
                {
                  throw new AssertionError(E.getCause());
                }
            }
          throw new UnsupportedOperationException(method.getName());
        });
      }

    @Test
    public void collectsIncludingFailedJobsAndZero() throws Exception
      {
        BigQuery bq = bigQuery();
        BilledBytesTracker tracker = new BilledBytesTracker();
        assertEquals(Long.valueOf(0), tracker.getBytesBilled());
        assertEquals(0L, tracker.getJobCount());
        BQHelper.runQuery(bq, "0", true, tracker);
        BQHelper.runQuery(bq, "13", true, tracker);
        assertNotNull(BQHelper.runQuery(bq, "fail", true, tracker)._e);
        assertEquals(Long.valueOf(20), tracker.getBytesBilled());
        assertEquals(Long.valueOf(20), tracker.getBytesBilled());
        assertEquals(3L, tracker.getJobCount());
      }

    @Test
    public void missingStatisticsMakesTotalUnknown() throws Exception
      {
        BigQuery bq = bigQuery();
        BilledBytesTracker tracker = new BilledBytesTracker();
        BQHelper.runQuery(bq, "missing", true, tracker);
        BQHelper.runQuery(bq, "4", true, tracker);
        assertNull(tracker.getBytesBilled());
        assertEquals(2L, tracker.getJobCount());
      }

    @Test
    public void overflowMakesTotalUnknown() throws Exception
      {
        BigQuery bq = bigQuery();
        BilledBytesTracker tracker = new BilledBytesTracker();
        BQHelper.runQuery(bq, Long.toString(Long.MAX_VALUE), true, tracker);
        BQHelper.runQuery(bq, "1", true, tracker);
        assertNull(tracker.getBytesBilled());
        assertEquals(2L, tracker.getJobCount());
      }

    @Test
    public void workersShareExplicitTracker() throws Exception
      {
        BigQuery bq = bigQuery();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        try
          {
            BilledBytesTracker tracker = new BilledBytesTracker();
            List<Future<?>> work = new ArrayList<Future<?>>();
            for (int i = 0; i < 30; ++i)
              work.add(pool.submit(() -> BQHelper.runQuery(bq, "3", true, tracker)));
            for (Future<?> future : work)
              future.get();
            assertEquals(Long.valueOf(90), tracker.getBytesBilled());
            assertEquals(30L, tracker.getJobCount());
          }
        finally
          {
            pool.shutdownNow();
          }
      }

    @Test
    public void concurrentCollectionsAreIndependentAndUntrackedQueriesStayUntracked() throws Exception
      {
        BigQuery bq = bigQuery();
        assertNull(BQHelper.runQuery(bq, "untracked"));
        ExecutorService pool = Executors.newFixedThreadPool(2);
        try
          {
            Future<Long> first = pool.submit(() -> {
              BilledBytesTracker tracker = new BilledBytesTracker();
              BQHelper.runQuery(bq, "11", true, tracker);
              assertEquals(1L, tracker.getJobCount());
              return tracker.getBytesBilled();
            });
            Future<Long> second = pool.submit(() -> {
              BilledBytesTracker tracker = new BilledBytesTracker();
              BQHelper.runQuery(bq, "23", true, tracker);
              assertEquals(1L, tracker.getJobCount());
              return tracker.getBytesBilled();
            });
            assertEquals(Long.valueOf(11), first.get());
            assertEquals(Long.valueOf(23), second.get());
          }
        finally
          {
            pool.shutdownNow();
          }
      }
  }