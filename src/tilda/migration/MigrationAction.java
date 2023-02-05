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

import tilda.db.Connection;
import tilda.db.metadata.DatabaseMeta;

public abstract class MigrationAction
  {

    protected MigrationAction(String SchemaName, String TableViewName, boolean isDependencyAction/*, String maintenanceAction, String maintenanceObjectType*/)
      {
        _isDependencyAction = isDependencyAction;
        _SchemaName = SchemaName;
        _TableViewName = TableViewName;
      }

    protected final String  _SchemaName;
    protected final String  _TableViewName;
    protected final boolean _isDependencyAction;
    
    public abstract boolean process(Connection C)
    throws Exception;

    public abstract String getDescription();

    public boolean isNeeded(Connection C, DatabaseMeta DBMeta)
    throws Exception
      {
        return true;
      }
    
    public String getSchema()
      {
        return _SchemaName;
      }

    public String getTableViewName()
      {
        return _TableViewName;
      }

    public boolean isDependencyAction()
      {
        return _isDependencyAction;
      }

    protected void errorHandling(Connection C)
    throws Exception
      {
      }
  }
