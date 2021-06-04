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
import java.io.Writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.DurationUtil;
import tilda.utils.NumberFormatUtil;

public abstract class ExporterObjectProcessor<T> implements ObjectProcessor<T>
  {
    protected static final Logger LOG = LogManager.getLogger(ExporterObjectProcessor.class.getName());

    /**
     * 
     * @param out
     * @param outName The name of the Writer
     * @param logFreq
     */
    public ExporterObjectProcessor(Writer out, String outName, long logFreq)
      {
        _out = out;
        _totalCount = 0;
        _logFreq = logFreq;
        _outName = outName;
      }

    /**
     * 
     * @param outFile
     * @param logFreq
     * @throws FileNotFoundException
     */
    public ExporterObjectProcessor(String outFile, long logFreq)
      throws FileNotFoundException
      {
        _out = new PrintWriter(new File(outFile));
        _cleanWriter = true;
        _totalCount = 0;
        _logFreq = logFreq;
        _outName = outFile;
      }

    protected Writer  _out;
    protected String  _outName;
    protected boolean _cleanWriter = false;
    protected long    _totalCount;
    protected long    _startTs;
    protected long    _endTs;
    protected long    _logFreq;


    public void start()
    throws Exception
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
            LOG.info("Saved " + NumberFormatUtil.printWith000Sep(count) + " records in " + DurationUtil.printDuration(durationNano) + " (" + DurationUtil.printPerformancePerMinute(durationNano, count) + " records/min)");
          }
        return true;
      }

    public void end(boolean hasMore, int maxCount)
    throws Exception
      {
        if (_cleanWriter == true)
          _out.close();
        _endTs = System.nanoTime();
        long durationNano = _endTs - _startTs;
        LOG.info("\n==========================================================================================================================================\n"
        + "==  " + _outName + "\n"
        + "==  " + NumberFormatUtil.printWith000Sep(_totalCount) + " records in " + DurationUtil.printDuration(durationNano) + " (" + DurationUtil.printPerformancePerMinute(durationNano, _totalCount) + " records/min)\n"
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
