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

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.DependencyDDLDummyTable_Data;
import tilda.data.DependencyDDLDummyTable_Factory;
import tilda.db.Connection;
import tilda.utils.ReverseIterator;
import tilda.utils.TextUtil;

public class DDLDependencyManager
  {
    protected static final Logger LOG = LogManager.getLogger(DDLDependencyManager.class.getName());

    public DDLDependencyManager(String SchemaName, String TableViewName)
      {
        _SchemaName = SchemaName;
        _TableViewName = TableViewName;
      }

    protected String                                        _SchemaName;
    protected String                                        _TableViewName;
    protected List<tilda.data.DependencyDDLDummyTable_Data> _Scripts;

    public String getSchemaName()
      {
        return _SchemaName;
      }

    public String getTableViewName()
      {
        return _TableViewName;
      }

    public boolean fetchDependencies(Connection C)
    throws Exception
      {
        _Scripts = DependencyDDLDummyTable_Factory.LookupDDLDependencies(C, _SchemaName, _TableViewName);
        boolean Error = false;
        for (DependencyDDLDummyTable_Data S : _Scripts)
          {
            if (TextUtil.isNullOrEmpty(S.getRestoreScript()) == true)
              {
                LOG.error("Couldn't get a restore script for view " + S.getDepSchemaName() + "." + S.getDepViewName() + ".");
                Error = true;
              }
          }
        if (Error == true)
          {
            _Scripts = null;
            return false;
          }
        return true;
      }

    public boolean hasDependencies()
      {
        return _Scripts != null && _Scripts.isEmpty() == false;
      }

    public void dropDependencies(Connection C)
    throws Exception
      {
        if (_Scripts.isEmpty() == true)
          {
            LOG.debug("Table/View " + _SchemaName + "." + _TableViewName + " has no dependencies to drop.");
            return;
          }
        StringBuilder Str = new StringBuilder();
        for (DependencyDDLDummyTable_Data S : _Scripts)
          Str.append("\nDROP VIEW " + S.getDepSchemaName() + "." + S.getDepViewName() + ";");
        if (C.ExecuteDDL(_SchemaName, _TableViewName, Str.toString()) == false)
          throw new Exception("Database error dropping views dependent on " + _SchemaName + "." + _TableViewName + ".");
      }

    public void restoreDependencies(Connection C)
    throws Exception
      {
        if (_Scripts.isEmpty() == true)
          {
            LOG.debug("Table/View " + _SchemaName + "." + _TableViewName + " has no dependencies to restore.");
            return;
          }
        Iterator<DependencyDDLDummyTable_Data> I = new ReverseIterator<DependencyDDLDummyTable_Data>(_Scripts);
        while (I.hasNext() == true)
          {
            DependencyDDLDummyTable_Data S = I.next();
            if (C.ExecuteDDL(S.getDepSchemaName(), S.getDepViewName(), S.getRestoreScript()) == false)
              throw new Exception("Database error restoring view " + S.getDepSchemaName() + "." + S.getDepViewName() + " that was dependent on " + _SchemaName + "." + _TableViewName + ".");
          }
      }

    public String getDependencyNames()
      {
        StringBuilder Str = new StringBuilder();
        Iterator<DependencyDDLDummyTable_Data> I = new ReverseIterator<DependencyDDLDummyTable_Data>(_Scripts);
        while (I.hasNext() == true)
          {
            DependencyDDLDummyTable_Data S = I.next();
            if (Str.length() != 0)
             Str.append(", ");
            Str.append(S.getDepSchemaName()+"."+S.getDepViewName());
          }
        return Str.toString();
      }

  }
