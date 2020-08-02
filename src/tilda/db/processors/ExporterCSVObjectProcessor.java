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
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.interfaces.CSVable;

public class ExporterCSVObjectProcessor<T extends CSVable> extends ExporterObjectProcessor<T>
  {
    protected static final Logger LOG = LogManager.getLogger(ExporterCSVObjectProcessor.class.getName());

    public ExporterCSVObjectProcessor(PrintWriter out, long logFreq, String name, Class<?> factoryClass)
      {
        super(out, logFreq, name);
        _factoryClass = factoryClass;
      }

    public ExporterCSVObjectProcessor(String outFile, long logFreq, Class<?> factoryClass)
      throws FileNotFoundException
      {
        super(outFile, logFreq);
        _factoryClass = factoryClass;
      }

    protected Class<?> _factoryClass;

    @Override
    public void start()
      {
        super.start();
        try
          {
            Method M = _factoryClass.getMethod("getCSVHeader");
            _out.println((String) M.invoke(null));
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
        _out.println();
        return super.process(count);
      }

  }
