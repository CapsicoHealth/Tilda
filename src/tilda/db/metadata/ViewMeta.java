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

package tilda.db.metadata;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.utils.PaddingTracker;

public class ViewMeta
  {
    static final Logger LOG = LogManager.getLogger(ViewMeta.class.getName());

    public ViewMeta(String SchemaName, String ViewName, String Descr)
      {
        _SchemaName = SchemaName;
        _ViewName = ViewName;
        _Descr = Descr;
      }

    public String                     _SchemaName;
    public String                     _ViewName;
    public final String               _Descr;

    protected Map<String, ColumnMeta> _DBColumns         = new HashMap<String, ColumnMeta>();
    public List<ColumnMeta>           _ColumnsList       = new ArrayList<ColumnMeta>();
    public PaddingTracker             _PadderColumnNames = new PaddingTracker();

    /*
     * public void load(Connection C)
     * throws Exception
     * {
     * long TS = System.nanoTime();
     * // LOG.debug("View: " + _SchemaName + "." + _ViewName);
     * DatabaseMetaData meta = C.getMetaData();
     * ResultSet RS = meta.getColumns(null, _SchemaName.toLowerCase(), _ViewName.toLowerCase(), null);
     * while (RS.next() != false)
     * {
     * ColumnMeta CI = new ColumnMeta(C, RS, null, this);
     * _DBColumns.put(CI._Name, CI);
     * ++MetaPerformance._ViewColumnCount;
     * }
     * MetaPerformance._ViewColumnNano+=(System.nanoTime()-TS);
     * }
     */
  }
