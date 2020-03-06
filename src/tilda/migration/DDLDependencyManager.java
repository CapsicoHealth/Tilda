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
import tilda.parsing.parts.Schema;
import tilda.utils.ReverseIterator;
import tilda.utils.TextUtil;

public class DDLDependencyManager
  {
    protected static final Logger LOG = LogManager.getLogger(DDLDependencyManager.class.getName());

    public DDLDependencyManager(String SchemaName, String TableViewName, List<Schema> TildaList)
      {
        _SchemaName = SchemaName;
        _TableViewName = TableViewName;
        _TildaList = TildaList;
      }

    protected String                                        _SchemaName;
    protected String                                        _TableViewName;
    protected List<Schema>                                  _TildaList;
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
        _Scripts = DependencyDDLDummyTable_Factory.lookupDDLDependencies(C, _SchemaName, _TableViewName);
        boolean Error = false;
        for (DependencyDDLDummyTable_Data S : _Scripts)
          {
            if (TextUtil.isNullOrEmpty(S.getRestoreScript()) == true)
              {
                LOG.error("Couldn't get a restore script for view " + S.getDepSchemaName() + "." + S.getDepViewName() + ".");
                Error = true;
              }
          }

        
//        if (Error == false)
//          for (DependencyDDLDummyTable_Data S : _Scripts)
//            {
//              DependencyDDLDummyTable_Data S2 = DependencyDDLDummyTable_Factory.create(S.getSrcSchemaName(), S.getSrcTVName(), S.getSeq(), S.getDepSchemaName(), S.getDepViewName(), S.getRestoreScript());
//              if (S2.write(C) == false)
//                Error = true;
//            }

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
          Str.append("\nDROP VIEW IF EXISTS " + S.getDepSchemaName() + "." + S.getDepViewName() + " CASCADE;");
        if (C.executeDDL(_SchemaName, _TableViewName, Str.toString()) == false)
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
        int Error = 0;
        Iterator<DependencyDDLDummyTable_Data> I = new ReverseIterator<DependencyDDLDummyTable_Data>(_Scripts);
        while (I.hasNext() == true)
          {
            DependencyDDLDummyTable_Data S = I.next();
            boolean OK = false;
            try
              {
//                C.setSavepoint();
                OK = C.executeDDL(S.getDepSchemaName(), S.getDepViewName(), S.getRestoreScript());
//                C.releaseSavepoint(true);
              }
            catch (Exception E)
              {
                LOG.error("A database error occurred:\n",  E);
//                C.releaseSavepoint(false);
                OK = false;
              }
            if (OK == false)
              {
                StringBuilder Str = new StringBuilder();
                Str.append("\n\n\n###############################################################################################################################\n");
                Str.append("##\n");
                Str.append("##  Could not restore "+S.getDepSchemaName()+"."+S.getDepViewName()+" due likely to a removed column that had dependencies\n");
                Str.append("##  (i.e., a schema-breaking change). You have to rerun Migrate. The dependent views are as follows:\n");
                I = new ReverseIterator<DependencyDDLDummyTable_Data>(_Scripts);
                int notManagedCount = 0;
                while (I.hasNext() == true)
                  {
                    S = I.next();
                    Str.append("##     - ").append(S.getDepSchemaName()).append(".").append(S.getDepViewName());
                    if (Schema.getView(_TildaList, S.getDepSchemaName(), S.getDepViewName()) == null)
                      {
                        Str.append("   [NOT TILDA-MANAGED]");
                        ++notManagedCount;
                      }
                    Str.append("\n");
                  }
                Str.append("##\n");
                if (notManagedCount > 0)
                  {
                    Str.append("##  NOTE: There were "+notManagedCount+" dependent view(s) found that are not managed through Tilda (marked\n");
                    Str.append("##       as such above if any). they must be re-created separately. Their captured DDL was saved in the\n");
                    Str.append("##       table Tilda.XXX.\n");
                  }
                else
                  {
                    Str.append("##  NOTE: All those views are managed by Tilda and will be re-created automatically in the next Migrate.\n");
                  }
                Str.append("##\n");
                Str.append("##  NOTE: If the Migrate still fails, you may have to manually drop-cascade ").append(_SchemaName).append(".").append(_TableViewName).append(".\n");
                Str.append("##\n");
                Str.append("###############################################################################################################################\n\n\n");
                LOG.warn(Str.toString());
                ++Error;
                // This is not nice... For some reason, we can't set multiple savepoints.
                // Needs more investigation.
                throw new Exception("Database error restoring view " + S.getDepSchemaName() + "." + S.getDepViewName() + " that was dependent on " + _SchemaName + "." + _TableViewName + ": you have to drop the view manually and rerun migration. any view not managed through Tilda would have to be re-created separately.");
              }
          }
        if (Error != 0)
         LOG.debug("There were "+Error+" out of "+_Scripts.size()+" views which couldn't be re-created.");
      }

    public String getDependencyNames()
      {
        if (_Scripts == null)
          return "";
        StringBuilder Str = new StringBuilder();
        Iterator<DependencyDDLDummyTable_Data> I = new ReverseIterator<DependencyDDLDummyTable_Data>(_Scripts);
        while (I.hasNext() == true)
          {
            DependencyDDLDummyTable_Data S = I.next();
            if (Str.length() != 0)
              Str.append(", ");
            Str.append(S.getDepSchemaName() + "." + S.getDepViewName());
          }
        return Str.toString();
      }

  }
