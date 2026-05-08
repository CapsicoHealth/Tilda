/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.processors.RecordProcessor;

public class PKMeta
  {
    static final Logger LOG = LogManager.getLogger(PKMeta.class.getName());

    protected PKMeta(String schemaName, String tableName, String pkName, String columnName, boolean identity)
      throws Exception
      {
        _SchemaName = schemaName;
        _TableName = tableName;
        _PKName = pkName;
        _Identity = identity;
        _Columns.add(columnName);
      }

    public final String       _SchemaName;
    public final String       _TableName;
    public final String       _PKName;
    public final boolean      _Identity;
    public final List<String> _Columns = new ArrayList<String>();

    public String toString()
      {
        StringBuilder Str = new StringBuilder();
        for (String PKCol : _Columns)
          {
            if (Str.length() != 0)
              Str.append(", ");
            Str.append(PKCol);
          }
        return "Name: " + _PKName + "(" + Str.toString() + ");";
      }

    protected static class PKProcessor implements RecordProcessor
      {
        public Map<String, PKMeta> _Map = new HashMap<String, PKMeta>();

        @Override
        public boolean process(int count, ResultSet RS)
        throws Exception
          {
            String schemaName = RS.getString("table_schema");
            String tableName = RS.getString("table_name");
            String pkName = RS.getString("primary_key_name");
            String columnName = RS.getString("column_name");
            boolean identity = RS.getBoolean("is_identity");

            PKMeta pk = _Map.get(tableName.toLowerCase());
            if (pk != null)
              pk._Columns.add(columnName);
            else
              _Map.put(tableName.toLowerCase(), new PKMeta(schemaName, tableName, pkName, columnName, identity));

            return true;
          }
      }

    public static Map<String, PKMeta> loadSchemaPrimaryKeys(Connection C, String schemaName)
    throws Exception
      {
        String q = """
        SELECT kcu.table_schema, kcu.table_name, tc.constraint_name AS primary_key_name, kcu.column_name, c.is_identity, c.identity_generation
          FROM information_schema.table_constraints tc
             JOIN information_schema.key_column_usage kcu ON tc.constraint_schema = kcu.constraint_schema AND tc.constraint_name = kcu.constraint_name
             JOIN information_schema.columns c ON c.table_schema = kcu.table_schema AND c.table_name = kcu.table_name AND c.column_name = kcu.column_name
         WHERE tc.constraint_type = 'PRIMARY KEY'
           AND kcu.table_schema = '%s'
         ORDER BY kcu.table_name, kcu.ordinal_position
        """.formatted(schemaName);

        PKProcessor pkp = new PKProcessor();
        C.executeSelect(schemaName, null, q, pkp);
        return pkp._Map;
      }
  }
