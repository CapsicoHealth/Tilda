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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.JDBCHelper;

public class SchemaMeta
  {
    static final Logger LOG = LogManager.getLogger(SchemaMeta.class.getName());

    public SchemaMeta(String SchemaName)
      {
        _SchemaName = SchemaName;
      }

    public String                    _SchemaName;
    protected Map<String, TableMeta> _DBTables = new HashMap<String, TableMeta>();
    protected Map<String, ViewMeta>  _DBViews  = new HashMap<String, ViewMeta>();

    public void load(Connection C, String TablePattern)
    throws Exception
      {
        long TS = System.nanoTime();
        DatabaseMetaData meta = C.getMetaData();

        Map<String, FKMeta> outFKs = loadForeignKeys(meta, _SchemaName, TablePattern, true);
        Map<String, FKMeta> inFKs = loadForeignKeys(meta, _SchemaName, TablePattern, false);
        Map<String, Map<String, Map<String, ColumnMeta>>> columns = loadColumns(C, meta, _SchemaName, TablePattern);

        ResultSet RS = meta.getTables(null, _SchemaName.toLowerCase(), TablePattern == null ? null : TablePattern.toLowerCase(), null);
        while (RS.next() != false)
          {
            String Type = RS.getString("TABLE_TYPE");
            String Name = RS.getString("TABLE_NAME").toLowerCase();
            String Descr = RS.getString("REMARKS");
            if ("table".equalsIgnoreCase(Type) == true)
              {
                TableMeta T = new TableMeta(_SchemaName, Name, Descr);
                setColumns(columns, T);
                setFKs(inFKs, outFKs, T);
                MetaPerformance._TableNano += (System.nanoTime() - TS);
                ++MetaPerformance._TableCount;
                if (_DBTables.get(Name) != null)
                  LOG.warn("        The table '" + Name + "' seems to have come more than once through the information schema query !!! " + JDBCHelper.printResultSet(RS));
                else
                  {
                    _DBTables.put(Name, T);
                    T.load(C);
                  }
              }
            else if ("view".equalsIgnoreCase(Type) == true)
              {
                ViewMeta V = new ViewMeta(_SchemaName, Name, Descr);
                setColumns(columns, V);
                ++MetaPerformance._ViewCount;
                MetaPerformance._ViewNano += (System.nanoTime() - TS);
                if (_DBViews.get(Name) != null)
                  LOG.warn("        The view '" + Name + "' seems to have come more than once through the information schema query !!! " + JDBCHelper.printResultSet(RS));
                else
                  {
                    _DBViews.put(Name, V);
                    // V.load(C);
                  }
              }
            TS = System.nanoTime();
          }
        RS.close();
      }

    /**
     * Load columns for the whole db, schema or table. It is encouraged for larger databases to read ALL columns
     * across the entire database, and then assign them to specific tables. This performs 5-10x better than looking up for
     * each table.
     * 
     * @param C
     * @param meta
     * @param SchemaName
     * @param TableName
     * @return
     * @throws Exception
     */
    protected static Map<String, Map<String, Map<String, ColumnMeta>>> loadColumns(Connection C, DatabaseMetaData meta, String SchemaName, String TableName)
    throws Exception
      {
        long TS = System.nanoTime();
        Map<String, Map<String, Map<String, ColumnMeta>>> columns = new HashMap<String, Map<String, Map<String, ColumnMeta>>>();
        ResultSet RS = meta.getColumns(null, SchemaName == null ? null : SchemaName.toLowerCase(), TableName == null ? null : TableName.toLowerCase(), null);
        while (RS.next() != false)
          {
            if (RS.getString("TABLE_SCHEM").equalsIgnoreCase("information_schema") == true)
              continue;
            ColumnMeta CI = new ColumnMeta(C, RS);
            Map<String, Map<String, ColumnMeta>> schema = columns.get(CI._SrcSchema.toLowerCase());
            if (schema == null)
              {
                schema = new HashMap<String, Map<String, ColumnMeta>>();
                columns.put(CI._SrcSchema.toLowerCase(), schema);
              }
            Map<String, ColumnMeta> table = schema.get(CI._SrcTable.toLowerCase());
            if (table == null)
              {
                table = new HashMap<String, ColumnMeta>();
                schema.put(CI._SrcTable.toLowerCase(), table);
              }
            table.put(CI._Name.toLowerCase(), CI);
          }
        RS.close();

        MetaPerformance._TableColumnNano += (System.nanoTime() - TS);
        for (Map<String, Map<String, ColumnMeta>> schema : columns.values())
          for (Map<String, ColumnMeta> tables : schema.values())
            MetaPerformance._TableColumnCount += tables.size();

        return columns;
      }

    private void setColumns(Map<String, Map<String, Map<String, ColumnMeta>>> columns, TableMeta T)
    throws Exception
      {
        Map<String, Map<String, ColumnMeta>> schema = columns.get(T._SchemaName.toLowerCase());
        if (schema == null)
          throw new Exception("Cannot find any columns for table " + T._SchemaName + "." + T._TableName + ": schema not found in whole column map.");
        Map<String, ColumnMeta> table = schema.get(T._TableName.toLowerCase());
        if (table == null)
          throw new Exception("Cannot find any columns for table " + T._SchemaName + "." + T._TableName + ": table not found in whole column map.");

        T._ColumnsMap = table;
        for (ColumnMeta col : table.values())
          {
            col.attachToTable(T);
            T._ColumnsList.add(col);
            T._PadderColumnNames.track(col._Name);
          }
      }

    private void setColumns(Map<String, Map<String, Map<String, ColumnMeta>>> columns, ViewMeta V)
    throws Exception
      {
        Map<String, Map<String, ColumnMeta>> schema = columns.get(V._SchemaName.toLowerCase());
        if (schema == null)
          throw new Exception("Cannot find any columns for view " + V._SchemaName + "." + V._ViewName + ": schema not found in whole column map.");
        Map<String, ColumnMeta> view = schema.get(V._ViewName.toLowerCase());
        if (view == null)
          throw new Exception("Cannot find any columns for table " + V._SchemaName + "." + V._ViewName + ": table not found in whole column map.");

        V._DBColumns = view;
        for (ColumnMeta col : view.values())
          {
            col.attachToView(V);
            V._ColumnsList.add(col);
            V._PadderColumnNames.track(col._Name);
          }
      }


    /**
     * Load outgoing/incoming FKs for the whole db, schema or table. It is encouraged for larger databases to read ALL foreign keys
     * across the entire database, and then assign them to specific tables. This performs 5-10x better than looking up for
     * each table.
     *
     * @param meta
     * @param SchemaName
     * @param TableName
     * @param Outgoing
     * @return
     * @throws SQLException
     * @throws Exception
     */
    protected static Map<String, FKMeta> loadForeignKeys(DatabaseMetaData meta, String SchemaName, String TableName, boolean Outgoing)
    throws SQLException, Exception
      {
        long TS = System.nanoTime();
        Map<String, FKMeta> FKs = new HashMap<String, FKMeta>();
        ResultSet RS = Outgoing == true ? meta.getImportedKeys(null, SchemaName == null ? null : SchemaName.toLowerCase(), TableName == null ? null : TableName.toLowerCase())
                                        : meta.getExportedKeys(null, SchemaName == null ? null : SchemaName.toLowerCase(), TableName == null ? null : TableName.toLowerCase());
        while (RS.next() != false)
          {
            FKMeta FKM = new FKMeta(RS, Outgoing);
            String key = FKM._SrcSchema + "." + FKM._SrcTable + "." + FKM._Name;
            FKMeta prevFKM = FKs.get(key);
            if (prevFKM == null)
              FKs.put(key, FKM);
            else
              FKM = prevFKM;
            FKM.addColumn(RS);
          }
        RS.close();
        if (Outgoing == true)
          {
            MetaPerformance._FKOutNano += (System.nanoTime() - TS);
            MetaPerformance._FKOutCount += FKs.size();
          }
        else
          {
            MetaPerformance._FKInNano += (System.nanoTime() - TS);
            MetaPerformance._FKInCount += FKs.size();
          }
        return FKs;
      }

    private static void setFKs(Map<String, FKMeta> inFKs, Map<String, FKMeta> outFKs, TableMeta T)
      {
        for (FKMeta fk : inFKs.values())
          if (fk._SrcSchema.equals(T._SchemaName) == true && fk._SrcTable.equals(T._TableName) == true)
            {
              fk.attachToTable(T);
              T._ForeignKeysIn.put(fk._Name, fk);
            }
        for (FKMeta fk : outFKs.values())
          if (fk._SrcSchema.equals(T._SchemaName) == true && fk._SrcTable.equals(T._TableName) == true)
            {
              fk.attachToTable(T);
              T._ForeignKeysOut.put(fk._Name, fk);
            }
      }


    public TableMeta getTableMeta(String TableName)
      {
        return _DBTables.get(TableName.toLowerCase());
      }

    public Collection<TableMeta> getTableMetas()
      {
        return _DBTables.values();
      }

    public ViewMeta getViewMeta(String ViewName)
      {
        return _DBViews.get(ViewName.toLowerCase());
      }

    public boolean moveTableMetaFromOtherSchema(DatabaseMeta DBMeta, TableMeta src)
      {
        DBMeta.getSchemaMeta(src._SchemaName)._DBTables.remove(src._TableName.toLowerCase());
        src._SchemaName = _SchemaName;
        return _DBTables.put(src._TableName.toLowerCase(), src) == null;
      }

    public boolean renameTable(DatabaseMeta DBMeta, TableMeta src, String newName)
      {
        DBMeta.getSchemaMeta(_SchemaName)._DBTables.remove(src._TableName.toLowerCase());
        src._TableName = newName;
        return _DBTables.put(src._TableName.toLowerCase(), src) == null;
      }

    public boolean renameTableColumn(DatabaseMeta DBMeta, TableMeta src, String colName, String newName)
      {
        ColumnMeta CM = src.getColumnMeta(colName);
        CM._Name = newName;
        src._ColumnsMap.remove(colName);
        return src._ColumnsMap.put(CM._Name.toLowerCase(), CM) == null;
      }

    public boolean moveViewMetaFromOtherSchema(DatabaseMeta DBMeta, ViewMeta src)
      {
        DBMeta.getSchemaMeta(src._SchemaName)._DBViews.remove(src._ViewName.toLowerCase());
        src._SchemaName = _SchemaName;
        return _DBViews.put(src._ViewName.toLowerCase(), src) == null;
      }

    public boolean renameView(DatabaseMeta DBMeta, ViewMeta src, String newName)
      {
        DBMeta.getSchemaMeta(_SchemaName)._DBViews.remove(src._ViewName.toLowerCase());
        src._ViewName = newName;
        return _DBViews.put(src._ViewName.toLowerCase(), src) == null;
      }

    public Collection<ViewMeta> getViewMetas()
      {
        return _DBViews.values();
      }
  }



//
// pre-optimization
// ==========================================
// Schemas: 23 in 42.00ms or 0.2%
// Tables: 312 in 4.00ms or 0.0%
// TableColumns: 6293 in 2,478.00ms or 12.6%
// PK: 308 in 1,381.00ms or 7.0%
// FK-Out: 381 in 7,186.00ms or 36.5%
// FK-In: 378 in 6,656.00ms or 33.8%
// Indices: 823 in 1,915.00ms or 9.7%
// Views: 362 in 22.00ms or 0.1%
// ------------------------------------------
// Total: 19,667.00ms
//
//
//
// post-optimization
// ==========================================
// Schemas: 23 in 38.00ms or 0.7%
// Tables: 308 in 13.00ms or 0.2%
// TableColumns: 17917 in 643.00ms or 11.1%
// PK: 308 in 1,293.00ms or 22.3%
// FK-Out: 381 in 1,215.00ms or 20.9%
// FK-In: 378 in 697.00ms or 12.0%
// Indices: 823 in 1,907.00ms or 32.8%
// Views: 362 in 113.00ms or 1.9%
// ----------------------------------------------------------------------------
// Total: 5,809.00ms
//

