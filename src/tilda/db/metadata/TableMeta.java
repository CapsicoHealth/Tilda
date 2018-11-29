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

    public final String            _SchemaName;
    public final String            _TableName;
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
        ResultSet RS = meta.getColumns(null, _SchemaName.toLowerCase(), _TableName.toLowerCase(), null);
        while (RS.next() != false)
          {
            ColumnMeta CI = new ColumnMeta(C, RS, this, null);
            _ColumnsMap.put(CI._Name.toLowerCase(), CI);
            _ColumnsList.add(CI);
            _PadderColumnNames.track(CI._Name);
          }

        RS = meta.getIndexInfo(null, _SchemaName.toLowerCase(), _TableName.toLowerCase(), true, true);
        loadIndices(RS);
        RS = meta.getIndexInfo(null, _SchemaName.toLowerCase(), _TableName.toLowerCase(), false, true);
        loadIndices(RS);

        RS = meta.getImportedKeys(null, _SchemaName.toLowerCase(), _TableName.toLowerCase());
        loadForeignKeys(RS, _ForeignKeysOut, true, this);

        RS = meta.getExportedKeys(null, _SchemaName.toLowerCase(), _TableName.toLowerCase());
        loadForeignKeys(RS, _ForeignKeysIn, false, this);

        RS = meta.getPrimaryKeys(null, _SchemaName.toLowerCase(), _TableName.toLowerCase());
        if (RS.next() == true)
          _PrimaryKey = new PKMeta(RS);
      }

    private void loadIndices(ResultSet RS)
    throws SQLException, Exception
      {
        while (RS.next() != false)
          {
            IndexMeta IM = new IndexMeta(RS, this);
            IndexMeta prevIM = _Indices.get(IM._Name);
            if (prevIM == null)
              _Indices.put(IM._Name, IM);
            else
              IM = prevIM;
            IM.addColumn(RS);
          }
      }


    private static void loadForeignKeys(ResultSet RS, Map<String, FKMeta> FKKeyList, boolean Outgoing, TableMeta parentTable)
    throws SQLException, Exception
      {
        while (RS.next() != false)
          {
            FKMeta FKM = new FKMeta(RS, Outgoing, parentTable);
            FKMeta prevFKM = FKKeyList.get(FKM._Name);
            if (prevFKM == null)
              FKKeyList.put(FKM._Name, FKM);
            else
              FKM = prevFKM;
            FKM.addColumn(RS);
          }
      }


    public ColumnMeta getColumnMeta(String ColumnName)
      {
        return _ColumnsMap.get(ColumnName.toLowerCase());
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
  }
