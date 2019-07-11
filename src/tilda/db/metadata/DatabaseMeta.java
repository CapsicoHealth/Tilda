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
import tilda.utils.concurrent.Executor;
import tilda.utils.concurrent.SimpleRunnableDB;

public class DatabaseMeta
  {
    static final Logger LOG = LogManager.getLogger(DatabaseMeta.class.getName());

    public DatabaseMeta()
      {
      }

    protected Map<String, SchemaMeta> _DBSchemas = new HashMap<String, SchemaMeta>();
    protected boolean                 _SupportsArrays;

    protected static class SchemaRunnable extends SimpleRunnableDB
      {
        public SchemaRunnable(String PoolId, DatabaseMeta DBMeta, String SchemaPattern)
          {
            super("DBMETA " + SchemaPattern, PoolId);
            _DBMeta = DBMeta;
            _SchemaPattern = SchemaPattern;
          }

        protected DatabaseMeta _DBMeta;
        protected String       _SchemaPattern;

        @Override
        public void doRun(Connection C)
        throws Exception
          {
            LOG.debug("   " + _SchemaPattern);
            _DBMeta.load(C, _SchemaPattern);
          }
      }


    public void load(Connection C, String SchemaPattern, String TablePattern)
    throws Exception
      {
        DatabaseMetaData meta = C.getMetaData();
        LOG.debug("      meta.getSchemas "+SchemaPattern+".");
        ResultSet RS = meta.getSchemas(null, SchemaPattern == null ? null : SchemaPattern.toLowerCase());
        LOG.debug("      meta.getSchemas "+SchemaPattern+" -- RS OBTAINED");
        List<SchemaMeta> L = new ArrayList<SchemaMeta>();
        while (RS.next() != false)
          {
            String SchemaName = RS.getString("TABLE_SCHEM").toLowerCase();
            synchronized (_DBSchemas)
              {
                if (_DBSchemas.get(SchemaName) == null)
                  {
                    SchemaMeta S = new SchemaMeta(SchemaName);
                    _DBSchemas.put(SchemaName, S);
                    L.add(S);
                  }

              }
          }
        LOG.debug("      meta.getSchemas "+SchemaPattern+" -- RS PROCESSED");
        RS.close();
        LOG.debug("      meta.getSchemas "+SchemaPattern+" -- RS CLOSED");
        _SupportsArrays = C.supportsArrays();

        for (SchemaMeta S : L)
          S.load(C, meta, TablePattern);
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
  }
