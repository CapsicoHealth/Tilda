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

package tilda.migration;

/**
 * Tilda migration is non destructive by design. We want to separate drop scripts which we do not execute
 * against a DB from other migration actions.
 * @author Laurent Hasson
 *
 */
public abstract class MigrationDrops
  {

    protected MigrationDrops(String SchemaName, String TableViewName)
      {
        _SchemaName = SchemaName;
        _TableViewName = TableViewName;
      }

    protected final String _SchemaName;
    protected final String _TableViewName;

    public abstract String process()
    throws Exception;

    public String getSchema()
      {
        return _SchemaName;
      }

    public String getTableViewName()
      {
        return _TableViewName;
      }
  }
