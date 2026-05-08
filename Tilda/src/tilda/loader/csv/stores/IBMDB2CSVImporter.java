/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
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

package tilda.loader.csv.stores;

import java.util.Map;

import org.apache.commons.csv.CSVRecord;

import tilda.db.Connection;
import tilda.db.metadata.ColumnMeta;
import tilda.loader.parser.ColumnHeader;
import tilda.loader.parser.DataObject;

public class IBMDB2CSVImporter extends CSVImporter
  {

    public IBMDB2CSVImporter(Connection C, String rootFolder, DataObject cmsDO)
      {
        this.C = C;
        this.rootFolder = rootFolder;
        this.cmsDO = cmsDO;
      }    
    
    @Override
    protected long insertData(boolean isUpsert, long t0, Map<String, ColumnMeta> DBColumns, boolean withHeader, Iterable<CSVRecord> records, StringBuilder Str, String schemaName, String tableName, String[] headers, String[] columns, Map<String, ColumnHeader> columnMap, String[] completeHeaders, String[] uniqueColumns, String DateTimePattern, String DateTimeZoneInfoId, String DatePattern) 
      {
        return 0;
      }
  
    @Override
    protected StringBuilder GenerateSQL(boolean isUpsert, String schemaName, String tableName, String[] columns, Map<String, ColumnMeta> DBColumns, String[] uniqueColumns)
      {
        StringBuilder Str = GenerateInsertSQL(schemaName, tableName, columns, DBColumns);
        return Str;
      }
    
  }
