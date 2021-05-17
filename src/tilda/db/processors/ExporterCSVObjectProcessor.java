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
import java.io.Writer;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.interfaces.CSVable;

public class ExporterCSVObjectProcessor<T extends CSVable> extends ExporterObjectProcessor<T>
  {
    protected static final Logger LOG = LogManager.getLogger(ExporterCSVObjectProcessor.class.getName());

    public ExporterCSVObjectProcessor(Writer out, String outName, long logFreq, Class<?> factoryClass, boolean header)
      {
        super(out, outName, logFreq);
        _factoryClass = factoryClass;
        _header = header;
      }

    public ExporterCSVObjectProcessor(String outFile, long logFreq, Class<?> factoryClass, boolean header)
      throws FileNotFoundException
      {
        super(outFile, logFreq);
        _factoryClass = factoryClass;
        _header = header;
      }

    protected Class<?> _factoryClass;
    protected boolean  _header;

    @Override
    public void start()
    throws Exception
      {
        super.start();
        if (_header == true)
          try
            {
              Method M = _factoryClass.getMethod("getCSVHeader");
              _out.append((String) M.invoke(null)).append(System.lineSeparator());
            }
          catch (Throwable E)
            {
              throw new Error("An error occurred.\n", E);
            }
      }

    @Override
    public boolean process(int count, T obj)
    throws Exception
      {
        obj.toCSV(_out, "");
        _out.append(System.lineSeparator());
        return super.process(count);
      }

  }
