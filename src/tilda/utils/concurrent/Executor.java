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
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;


public class Executor
  {
    protected static final Logger LOG = LogManager.getLogger(Executor.class);

    public Executor(int MaxThreadCount)
      {
        _Executor = Executors.newFixedThreadPool(MaxThreadCount);
      }

    protected List<Exception>      _Exceptions = new ArrayList<Exception>();
    protected List<SimpleRunnable> _Runnables  = new ArrayList<SimpleRunnable>();
    protected ExecutorService      _Executor;

    public void addException(Exception E)
      {
        synchronized (_Exceptions)
          {
            _Exceptions.add(E);
          }
      }

    public void addRunnable(SimpleRunnable R)
    throws Exception
      {
        if (R._Executor != null)
          throw new Exception("Runnable " + R._TaskName + " is already fregistered to an Orchestrator.");
        synchronized (_Runnables)
          {
            _Runnables.add(R);
            R._Executor = this;
          }
      }

    public List<Exception> run()
      {
        long T0 = System.nanoTime();
        for (SimpleRunnable R : _Runnables)
          _Executor.execute(R);
        _Executor.shutdown();
        // Wait until all threads are finish
        while (!_Executor.isTerminated())
          {
            try
              {
                Thread.sleep(5000);
              }
            catch (InterruptedException e)
              {
                LOG.error("Interrupted task\n", e);
              }
          }

        long seqTimeNano = 0;
        for (SimpleRunnable R : _Runnables)
          seqTimeNano+=R._taskTimeNano;
        long duration = System.nanoTime() - T0;
        LOG.debug("\n\n*******************************************************************************************\n"
        + "** Executed " + _Runnables.size() + " tasks in " + DurationUtil.printDuration(duration) + ".\n"
        + "** Sequential time would have been around " + DurationUtil.printDuration(seqTimeNano) + " or "+NumberFormatUtil.printPercentWith1Dec(duration, seqTimeNano)+"% of the time.\n"
        + "*******************************************************************************************\n\n");
        return _Exceptions;
      }

    public void clean()
      {
        _Exceptions.clear();
        _Runnables.clear();
      }

  }
