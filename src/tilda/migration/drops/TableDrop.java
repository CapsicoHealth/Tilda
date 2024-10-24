/* ===========================================================================
 * Copyright (C) 2021 CapsicoHealth Inc.
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

package tilda.migration.drops;

import tilda.db.metadata.TableMeta;
import tilda.migration.MigrationDrops;

public class TableDrop extends MigrationDrops
  {
    public TableDrop(TableMeta table)
      {
        super(table._SchemaName, table._TableName);
      }


    @Override
    public String process()
    throws Exception
      {
        return "DROP TABLE "+_SchemaName+"."+_TableViewName+";";
      }
  }
