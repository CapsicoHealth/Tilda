/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
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

package tilda.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MapTest
  {
    protected static final Logger LOG = LogManager.getLogger(MapTest.class.getName());

    public static void main(String[] args)
      {
        LOG.info("Start");
        try
          {
            Test1();
          }
        catch (IOException e)
          {
            e.printStackTrace();
          }
        LOG.info("End");
        LOG.info("Stream.map looks to perform in line with manual looping, which makes Stream.map a solid implementation choice.");
      }

    protected static class Dummy
      {
        public final int    _i = RandomUtil.pick(0, 1_000_000);
        public final String _s = EncryptionUtil.getToken(10);
      }

    private static void Test1()
    throws IOException
      {
        final int size = 1_000_000;
        final int loop = 5;
        List<Dummy> L = new ArrayList<Dummy>();
        long ts = System.nanoTime();
        for (int i = 0; i < size; ++i)
          L.add(new Dummy());
        ts = System.nanoTime() - ts;
        LOG.debug("Initialization of " + size + " elements took " + DurationUtil.printDuration(ts) + " (" + DurationUtil.printPerformancePerSecond(ts, size) + "/s).");

        ts = System.nanoTime();
        for (int x = 0; x < loop; ++x)
          {
            String[] ids = L.stream().map(e -> e._s).toArray(String[]::new);
//            LOG.debug(ids[10]);
          }
        ts = System.nanoTime() - ts;
        LOG.debug("Stream Test of " + size + " elements "+loop+" times took " + DurationUtil.printDuration(ts) + " (" + DurationUtil.printPerformancePerSecond(ts, loop*size) + "/s).");

        ts = System.nanoTime();
        for (int x = 0; x < loop; ++x)
          {
            String[] ids = new String[L.size()];
            for (int i = 0; i < L.size(); ++i)
              ids[i] = L.get(i)._s;
//            LOG.debug(ids[10]);
          }
        ts = System.nanoTime() - ts;
        LOG.debug("ListToArray Test of " + size + " elements "+loop+" times took " + DurationUtil.printDuration(ts) + " (" + DurationUtil.printPerformancePerSecond(ts, loop*size) + "/s).");
      }
  }
