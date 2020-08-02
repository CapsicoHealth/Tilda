/* ===========================================================================
 * Copyright (C) 2020 CapsicoHealth Inc.
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

package tilda.db.processors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;

public abstract class ExporterObjectProcessor<T> implements ObjectProcessor<T>
  {
    protected static final Logger LOG = LogManager.getLogger(ExporterObjectProcessor.class.getName());

    public ExporterObjectProcessor(PrintWriter out, long logFreq, String name)
      {
        _out = out;
        _totalCount = 0;
        _logFreq = logFreq;
        _name = name;
      }

    public ExporterObjectProcessor(String outFile, long logFreq)
      throws FileNotFoundException
      {
        _out = new PrintWriter(new File(outFile));
        _cleanWriter = true;
        _totalCount = 0;
        _logFreq = logFreq;
        _name = outFile;
      }

    protected PrintWriter _out;
    protected boolean     _cleanWriter = false;
    protected long        _totalCount;
    protected long        _startTs;
    protected long        _endTs;
    protected long        _logFreq;
    protected String      _name;


    public void start()
      {
        _startTs = System.nanoTime();
      }

    public boolean process(int count)
    throws Exception
      {
        ++_totalCount;
        if (count % _logFreq == 0)
          {
            long durationNano = System.nanoTime() - _startTs;
            LOG.info("Saved " + count + " records to CSV in " + DurationUtil.printDuration(durationNano) + " (" + DurationUtil.printPerformancePerMinute(durationNano, count) + " records/min)");
          }
        return true;
      }

    public void end(boolean hasMore, int maxCount)
      {
        if (_cleanWriter == true)
          _out.close();
        _endTs = System.nanoTime();
        long durationNano = _endTs - _startTs;
        LOG.info("\n==========================================================================================================================================\n"
        + "==  " + _name + "\n"
        + "==  " + _totalCount + " records to CSV in " + DurationUtil.printDuration(durationNano) + " (" + DurationUtil.printPerformancePerMinute(durationNano, _totalCount) + " records/min)\n"
        + "==========================================================================================================================================\n");
      }

    public long getTotalCount()
      {
        return _totalCount;
      }

    public long getStartTimeStamp()
      {
        return _startTs;
      }

    public long getEndTimeStamp()
      {
        return _endTs;
      }
  }
