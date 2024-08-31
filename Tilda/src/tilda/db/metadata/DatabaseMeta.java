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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.utils.TextUtil;

public class DatabaseMeta
  {
    protected static final Logger LOG = LogManager.getLogger(DatabaseMeta.class.getName());

    public DatabaseMeta()
      {
      }

    protected Map<String, SchemaMeta> _DBSchemas = new HashMap<String, SchemaMeta>();
    protected boolean                 _SupportsArrays;

    public void load(Connection C, String SchemaPattern, String TablePattern)
    throws Exception
      {
        load(C, SchemaPattern, TablePattern, null);
      }
    public void load(Connection C, String SchemaPattern, String TablePattern, String[] excludedSchemas)
    throws Exception
      {
        DatabaseMetaData meta = C.getMetaData();

        long TS = System.nanoTime();
        ResultSet RS = meta.getSchemas(null, SchemaPattern == null ? SchemaPattern : SchemaPattern.toLowerCase());
        while (RS.next() != false)
          {
            String SchemaName = RS.getString("TABLE_SCHEM").toLowerCase();
            if (excludedSchemas != null && TextUtil.contains(excludedSchemas, SchemaName, true, 0) == true)
             continue;
            LOG.debug("Reading metadata for schema '" + SchemaName + "'.");
            SchemaMeta S = _DBSchemas.get(SchemaName);
            if (S == null)
              S = new SchemaMeta(SchemaName);
            _DBSchemas.put(SchemaName, S);
            MetaPerformance._SchemaNano += (System.nanoTime() - TS);
            S.load(C, TablePattern);
            TS = System.nanoTime();
            ++MetaPerformance._SchemaCount;
          }
        RS.close();
        _SupportsArrays = C.supportsArrays();
      }

    public void load(Connection C, String SchemaPattern)
    throws Exception
      {
        load(C, SchemaPattern, null);
      }

    public SchemaMeta getSchemaMeta(String SchemaName)
      {
        return _DBSchemas.get(SchemaName.toLowerCase());
      }
    public Collection<SchemaMeta> getSchemaMetas()
      {
        return _DBSchemas.values();
      }
    /**
     * This method returns the sorted list of schema names. Since it sorts that list each time this method is called
     * the caller should cache the results if needed multiple times.
     * @return
     */
    public String[] getSchemaNamesSorted()
      {
        String[] names = (String[])_DBSchemas.keySet().toArray();
        Arrays.sort(names);
        return names;
      }

    public TableMeta getTableMeta(String SchemaName, String TableName)
      {
        SchemaMeta S = getSchemaMeta(SchemaName);
        if (S == null)
          return null;
        return S.getTableMeta(TableName);
      }

    public ViewMeta getViewMeta(String SchemaName, String ViewName)
      {
        SchemaMeta S = getSchemaMeta(SchemaName);
        if (S == null)
          return null;
        return S.getViewMeta(ViewName);
      }

    public boolean supportsArrays()
      {
        return _SupportsArrays;
      }

    public boolean addSchema(String SchemaName)
      {
        return _DBSchemas.put(SchemaName.toLowerCase(), new SchemaMeta(SchemaName)) == null;
      }

  }
