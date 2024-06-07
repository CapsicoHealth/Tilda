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

import java.io.Writer;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.metadata.ColumnMeta;
import tilda.db.metadata.TableMeta;
import tilda.db.metadata.TableViewMeta;
import tilda.utils.TextUtil;
import tilda.utils.json.JSONUtil;

public class ExporterRecordProcessorCSVJSON extends ExporterRecordProcessor
  {
    protected static final Logger LOG = LogManager.getLogger(ExporterRecordProcessorCSVJSON.class.getName());

    public ExporterRecordProcessorCSVJSON(Connection C, Writer out, String outName, long logFreq, TableViewMeta tvm, String type, boolean CSVHeader)
      throws Exception
      {
        super(out, outName, logFreq);
        init(C, tvm, type, CSVHeader);
      }

    public ExporterRecordProcessorCSVJSON(Connection C, String outFile, long logFreq, TableMeta tvm, String type, boolean CSVHeader)
      throws Exception
      {
        super(outFile, logFreq);
        init(C, tvm, type, CSVHeader);
      }

    protected void init(Connection C, TableViewMeta tvm, String type, boolean CSVHeader)
    throws Exception
      {
        _C = C;
        type = type == null ? "" : type.toLowerCase();
        if (type.equals("csv") == true)
          _type = 1;
        else if (type.equals("jsonl") == true)
          _type = 2;
        else
          throw new Exception("ExporterRecordProcessorCSVJSON instantiated with type not being 'csv' or 'jsonl': it must be one or the other.");

        if (CSVHeader == true && _type != 1)
          throw new Exception("ExporterRecordProcessorCSVJSON instantiated with CSVHeader set to true, but type is not 'csv'.");

        _CSVHeader = CSVHeader;
        _tvm = tvm;
      }

    protected Connection    _C;
    protected int           _type;
    protected boolean       _CSVHeader;
    protected TableViewMeta _tvm;

    @Override
    public void start()
    throws Exception
      {
        super.start();
        if (_type == 1 && _CSVHeader == true)
          {
            boolean first = true;
            for (ColumnMeta cm : _tvm.getColumnMetaList())
              {
                if (first == false)
                  _out.append(",");
                else
                  first = false;
                _out.append(TextUtil.escapeDoubleQuoteForCSV(cm._NameOriginal));
              }
            _out.append("\n");
          }
      }

    @Override
    public boolean process(int count, ResultSet RS)
    throws Exception
      {
        super.process(count);
        if (_type == 2)
          _out.append("{");
        int idx = 0;
        for (ColumnMeta cm : _tvm.getColumnMetaList())
          {
            ++idx;
            if (_type == 1)
              {
                if (idx > 1)
                  _out.append(",");
                String val = RS.getString(idx);
                _out.append(TextUtil.escapeDoubleQuoteForCSV(val));
              }
            else
              {
                JSONUtil.print(_out, cm._NameOriginal, RS, idx, cm, true);
              }
          }
        if (_type == 2)
          _out.append("}");
        _out.append("\n");
        return true;
      }

  }
