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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;

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
        load(C, C.getMetaData(), TablePattern);
      }

    public void load(Connection C, DatabaseMetaData meta, String TablePattern)
    throws Exception
      {
        LOG.debug("      meta.getTables "+_SchemaName+"."+TablePattern+".");
        ResultSet RS = meta.getTables(null, _SchemaName.toLowerCase(), TablePattern == null ? null : TablePattern.toLowerCase(), null);
        LOG.debug("      meta.getTables "+_SchemaName+"."+TablePattern+" -- RS OBTAINED");
        while (RS.next() != false)
          {
            String Type = RS.getString("TABLE_TYPE");
            String Name = RS.getString("TABLE_NAME").toLowerCase();
            String Descr = RS.getString("REMARKS");
            // LOG.debug("Type: "+Type+"; Name: "+Name+";");
            if ("table".equalsIgnoreCase(Type) == true || "system table".equalsIgnoreCase(Type) == true)
              {
                TableMeta T = new TableMeta(_SchemaName, Name, Descr);
                _DBTables.put(Name, T);
              }
            else if ("view".equalsIgnoreCase(Type) == true || "system view".equalsIgnoreCase(Type) == true)
              {
                ViewMeta V = new ViewMeta(_SchemaName, Name, Descr);
                // for (int i = 0; i < RS.getMetaData().getColumnCount(); ++i)
                // {
                // LOG.debug(" column: "+RS.getMetaData().getColumnName(i+1)+"; value: "+RS.getString(RS.getMetaData().getColumnName(i+1))+";");
                // }
                _DBViews.put(Name, V);
              }
          }
        LOG.debug("      meta.getTables "+_SchemaName+"."+TablePattern+" -- RS PROCESSED");
        RS.close();
        LOG.debug("      meta.getTables "+_SchemaName+"."+TablePattern+" -- RS CLOSED");

        for (TableMeta T : _DBTables.values())
          T.load(C, meta);

        for (ViewMeta V : _DBViews.values())
          V.load(C, meta);

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
  }
