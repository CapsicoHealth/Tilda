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

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.interfaces.JSONable;

public class ExporterJSONObjectProcessor<T extends JSONable> extends ExporterObjectProcessor<T>
  {
    protected static final Logger LOG = LogManager.getLogger(ExporterObjectProcessor.class.getName());

    public ExporterJSONObjectProcessor(PrintWriter out, long logFreq, String name, boolean jsonLines)
      {
        super(out, logFreq, name);
        _jsonLines = jsonLines;
      }

    public ExporterJSONObjectProcessor(String outFile, long logFreq, boolean jsonLines)
      throws FileNotFoundException
      {
        super(outFile, logFreq);
        _jsonLines = jsonLines;
      }

    protected boolean _jsonLines;

    @Override
    public void start()
      {
        super.start();
        if (_jsonLines == false)
          _out.println("[");
      }

    @Override
    public boolean process(int count, T obj)
    throws Exception
      {
        if (_jsonLines == false)
          obj.toJSON(_out, "", count == 0 ? "   " : "  ,", true, true);
        else
          obj.toJSON(_out, "", "", true, true);
        return super.process(count);
      }

    @Override
    public void end(boolean hasMore, int maxCount)
      {
        if (_jsonLines == false)
          _out.println("]");
        super.end(hasMore, maxCount);
      }
  }
