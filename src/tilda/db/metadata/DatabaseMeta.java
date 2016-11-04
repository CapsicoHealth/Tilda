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
import java.util.HashMap;
import java.util.Map;

import tilda.db.Connection;

public class DatabaseMeta
  {
    public DatabaseMeta()
      {
      }

    protected Map<String, SchemaMeta> _DBSchemas = new HashMap<String, SchemaMeta>();
    protected boolean _SupportsArrays;
    protected int _CLOBThreshhold;

    public void load(Connection C, String SchemaPattern, String TablePattern) throws Exception
      {
        DatabaseMetaData meta = C.getMetaData();
        ResultSet RS = meta.getSchemas(null, SchemaPattern==null?SchemaPattern:SchemaPattern.toLowerCase());
        while (RS.next() != false)
          {
            String SchemaName = RS.getString("TABLE_SCHEM").toLowerCase();
            SchemaMeta S = _DBSchemas.get(SchemaName);
            if (S == null)
             S = new SchemaMeta(SchemaName);
            S.load(C, TablePattern);
            _DBSchemas.put(SchemaName, S);
          }
        RS.close();
        _SupportsArrays = C.supportsArrays();
        _CLOBThreshhold = C.getCLOBThreshhold();
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

    public Integer getCLOBThreshhold()
      {
        return _CLOBThreshhold;
      }
  }
