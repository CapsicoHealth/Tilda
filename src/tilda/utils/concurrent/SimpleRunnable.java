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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;

public abstract class SimpleRunnable implements Runnable
  {
    protected static final Logger LOG = LogManager.getLogger(SimpleRunnable.class);

    public SimpleRunnable(String TaskName)
      {
        _TaskName = TaskName;
      }

    String   _TaskName;
    Executor _Executor;
    long     _taskTimeNano = 0;

    @Override
    public void run()
      {
        long T0 = System.nanoTime();
        try
          {
            doRun();
            _taskTimeNano = System.nanoTime() - T0;
            LOG.debug("\n\n*******************************************************************************************\n"
            + "** Task " + _TaskName + " ran in " + DurationUtil.printDuration(_taskTimeNano) + ".\n"
            + "*******************************************************************************************\n\n");
          }
        catch (Exception E)
          {
            LOG.error("An error occurred in the thread\n", E);
            _Executor.addException(E);
            _taskTimeNano = System.nanoTime() - T0;
          }
      }

    public abstract void doRun()
    throws Exception;

  }
