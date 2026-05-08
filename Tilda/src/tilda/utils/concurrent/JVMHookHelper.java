/* ===========================================================================
 * Copyright (C) 2025 CapsicoHealth Inc.
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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class JVMHookHelper
  {
    protected static final Logger LOG = LogManager.getLogger(JVMHookHelper.class);

    public static void addShutdownHook(ExecutorService execService, String id, int delayWaitSeconds)
      {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
          LOG.info("JVM Shutdown Hook triggered: Shutting down ExecutorService '" + id + "'...");
          if (!execService.isShutdown())
            {
              execService.shutdown(); // Stop accepting new tasks
              try
                {
                  // Give current tasks up to delayWaitSeconds seconds to finish database commits if any
                  if (!execService.awaitTermination(delayWaitSeconds, TimeUnit.SECONDS))
                    {
                      LOG.warn("Timeout reached. Forcing ExecutorService shutdown.");
                      execService.shutdownNow(); // Force kill if they take too long
                    }
                }
              catch (InterruptedException e)
                {
                  LOG.error("ExecutorService '" + id + "' shutdown interrupted. Forcing shutdown now.", e);
                  execService.shutdownNow();
                  Thread.currentThread().interrupt();
                }
            }
          LOG.info("ExecutorService '" + id + "' shutdown complete.");
        }));
      }
  }
