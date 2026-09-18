/* ===========================================================================
 * Copyright (C) 2018 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tilda.utils.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;

/**
 * Long-lived fixed thread pool for producer/consumer workloads. Unlike {@link Executor},
 * {@link #run} does <B>not</B> shut the pool down, so a single instance can be held as a
 * static singleton and used concurrently by multiple callers. Each {@link #run} waits only
 * for the batch it was given; other in-flight batches on the same pool are unaffected.
 * <p>
 * Optional {@code maxConcurrent} throttles how many tasks actually execute at once (for
 * example 12 pool threads with 10 in-flight remote jobs). Extra pool threads simply block
 * on the throttle until a slot frees up.
 */
public class ExecutorPool
  {
    protected static final Logger        LOG         = LogManager.getLogger(ExecutorPool.class);
    protected static final AtomicInteger _INSTANCE   = new AtomicInteger(0);

    protected final int                  _MaxThreadCount;
    protected final int                  _MaxConcurrent;
    protected final ExecutorService      _Executor;
    protected final Semaphore            _Throttle;

    public ExecutorPool(int MaxThreadCount)
      {
        this(MaxThreadCount, MaxThreadCount);
      }

    public ExecutorPool(int MaxThreadCount, int MaxConcurrent)
      {
        if (MaxThreadCount < 1)
          throw new IllegalArgumentException("MaxThreadCount must be >= 1");
        if (MaxConcurrent < 1)
          throw new IllegalArgumentException("MaxConcurrent must be >= 1");
        _MaxThreadCount = MaxThreadCount;
        _MaxConcurrent = MaxConcurrent > MaxThreadCount ? MaxThreadCount : MaxConcurrent;
        final int instance = _INSTANCE.incrementAndGet();
        final AtomicInteger threadSeq = new AtomicInteger(0);
        _Executor = Executors.newFixedThreadPool(MaxThreadCount, new ThreadFactory()
          {
            @Override
            public Thread newThread(Runnable r)
              {
                Thread t = new Thread(r, "Tilda-ExecutorPool-" + instance + "-" + threadSeq.incrementAndGet());
                t.setDaemon(true);
                return t;
              }
          });
        // Only need an extra throttle when concurrency is strictly below the pool size.
        _Throttle = _MaxConcurrent < _MaxThreadCount ? new Semaphore(_MaxConcurrent, true) : null;
      }

    /**
     * Execute this batch on the shared pool and wait until every task in <B>this</B> batch
     * has finished. Concurrent callers each pass their own list. Does not shut the pool down.
     */
    public List<Exception> run(SimpleRunnable... Runnables)
    throws Exception
      {
        return run(Runnables == null ? null : Arrays.asList(Runnables));
      }

    /**
     * Execute this batch on the shared pool and wait until every task in <B>this</B> batch
     * has finished. Concurrent callers each pass their own list. Does not shut the pool down.
     */
    public List<Exception> run(List<SimpleRunnable> Runnables)
    throws Exception
      {
        BatchCollector collector = new BatchCollector();
        if (Runnables == null || Runnables.isEmpty() == true)
          return collector._Exceptions;

        long T0 = System.nanoTime();
        List<Callable<Object>> calls = new ArrayList<Callable<Object>>(Runnables.size());
        for (SimpleRunnable R : Runnables)
          {
            if (R._executor != null)
              throw new Exception("Runnable " + R._name + " is already registered to an Orchestrator.");
            R._executor = collector;
            calls.add(new ThrottledTask(R));
          }

        try
          {
            _Executor.invokeAll(calls);
          }
        catch (InterruptedException E)
          {
            LOG.error("Interrupted waiting for ExecutorPool batch\n", E);
            Thread.currentThread().interrupt();
            collector.addException(E);
          }

        long duration = System.nanoTime() - T0;
        long seqTimeNano = 0;
        long totalCount = 0;
        for (SimpleRunnable R : Runnables)
          {
            seqTimeNano += R._taskTimeNano;
            totalCount += R._totalCount;
          }
        boolean faster = duration < seqTimeNano;
        String perf = faster == true ? "faster by " + NumberFormatUtil.printWith1Dec(1.0 * seqTimeNano / duration) + "x"
        : "slower by " + NumberFormatUtil.printPercentWith1Dec(seqTimeNano, duration) + "%";
        LOG.debug("\n\n*******************************************************************************************\n"
        + "** ExecutorPool executed " + Runnables.size() + " tasks in " + DurationUtil.printDuration(duration)
        + " over " + _MaxThreadCount + " threads"
        + (_Throttle != null ? " (max concurrent " + _MaxConcurrent + ")" : "") + ".\n"
        + (totalCount == 0 ? "" : "** Processed " + totalCount + " records (" + DurationUtil.printPerformancePerMinute(duration, totalCount) + " records/min).\n")
        + "** Sequential time would have been around " + DurationUtil.printDuration(seqTimeNano) + " (" + perf + ".)\n"
        + "*******************************************************************************************\n\n");
        return collector._Exceptions;
      }

    /**
     * Optional orderly shutdown. Not needed for a process-lifetime static instance.
     */
    public void shutdown()
      {
        _Executor.shutdown();
      }

    protected class ThrottledTask implements Callable<Object>
      {
        protected ThrottledTask(SimpleRunnable R)
          {
            _R = R;
          }

        protected final SimpleRunnable _R;

        @Override
        public Object call()
        throws InterruptedException
          {
            if (_Throttle != null)
              _Throttle.acquire();
            try
              {
                _R.run();
              }
            finally
              {
                if (_Throttle != null)
                  _Throttle.release();
              }
            return null;
          }
      }

    protected static class BatchCollector implements ExceptionCollector
      {
        protected final List<Exception> _Exceptions = new ArrayList<Exception>();

        @Override
        public void addException(Exception E)
          {
            synchronized (_Exceptions)
              {
                _Exceptions.add(E);
              }
          }
      }
  }
