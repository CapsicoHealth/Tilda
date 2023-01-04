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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.utils.PaddingTracker;

public class TableMeta
  {
    static final Logger LOG = LogManager.getLogger(TableMeta.class.getName());

    public TableMeta(String SchemaName, String TableName, String Descr)
      {
        _SchemaName = SchemaName;
        _TableName = TableName;
        _Descr = Descr;
      }

    public String                  _SchemaName;
    public String                  _TableName;
    public final String            _Descr;
    public Map<String, ColumnMeta> _ColumnsMap        = new HashMap<String, ColumnMeta>();
    public List<ColumnMeta>        _ColumnsList       = new ArrayList<ColumnMeta>();
    public Map<String, IndexMeta>  _Indices           = new HashMap<String, IndexMeta>();
    public Map<String, FKMeta>     _ForeignKeysOut    = new HashMap<String, FKMeta>();
    public Map<String, FKMeta>     _ForeignKeysIn     = new HashMap<String, FKMeta>();
    public PKMeta                  _PrimaryKey;
    public PaddingTracker          _PadderColumnNames = new PaddingTracker();

    public void load(Connection C)
    throws Exception
      {
        DatabaseMetaData meta = C.getMetaData();
        
        // Loading unique indices
        long TS = System.nanoTime();
        ResultSet RS = meta.getIndexInfo(null, _SchemaName.toLowerCase(), _TableName.toLowerCase(), true, true);
        loadIndices(RS);
        RS.close();

        // Loading non-unique indices
        RS = meta.getIndexInfo(null, _SchemaName.toLowerCase(), _TableName.toLowerCase(), false, true);
        loadIndices(RS);
        RS.close();
        MetaPerformance._IndexNano+=(System.nanoTime()-TS);
        MetaPerformance._IndexCount += _Indices.size();
        
        // Loading primary keys
        TS = System.nanoTime();
        RS = meta.getPrimaryKeys(null, _SchemaName.toLowerCase(), _TableName.toLowerCase());
        if (RS.next() == true)
          _PrimaryKey = new PKMeta(RS);
        MetaPerformance._PKNano+=(System.nanoTime()-TS);
        MetaPerformance._PKCount++;
      }

    private void loadIndices(ResultSet RS)
    throws SQLException, Exception
      {
        int indexCount = 0;
        while (RS.next() != false)
          {
            IndexMeta IM = new IndexMeta(RS, this/*, indexCount*/);
            if (IM._Name == null)
             continue;
            IndexMeta prevIM = _Indices.get(IM._Name);
            if (prevIM == null)
              {
                _Indices.put(IM._Name, IM);
                ++indexCount;
              }
            else
              IM = prevIM;
            IM.addColumn(RS);
          }
      }

    public ColumnMeta getColumnMeta(String ColumnName, boolean caseSensitive)
      {
        ColumnMeta cm = _ColumnsMap.get(ColumnName.toLowerCase());
        if (cm == null || caseSensitive == true && cm._NameOriginal.equals(ColumnName) == false)
         return null;
        return cm;
      }

    public List<ColumnMeta> getColumnMetaList()
      {
        return _ColumnsList;
      }

    public Map<String, ColumnMeta> getColumnMetaMap()
      {
        return _ColumnsMap;
      }


    public IndexMeta getIndexMeta(String[] Columns, boolean Unique)
      {
        for (Map.Entry<String, IndexMeta> entry : _Indices.entrySet())
          {
            IndexMeta IM = entry.getValue();
            if (IM._Columns.size() != Columns.length)
              continue;

            if (IM._Unique != Unique)
              continue;

            if (IM.getColumnNames().containsAll(Arrays.asList(Columns)) == true)
              return IM;
          }
        return null;
      }

    public IndexMeta getIndexMeta(String Name)
      {
        return _Indices.get(Name);
      }
    
    public Collection<IndexMeta> getIndexMetas()
      {
        return _Indices.values();
      }
    
  }
