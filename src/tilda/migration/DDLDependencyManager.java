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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.data.FailedDependencyDDLScripts_Data;
import tilda.data.FailedDependencyDDLScripts_Factory;
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

    protected String                                _SchemaName;
    protected String                                _TableViewName;
    protected List<Schema>                          _TildaList;
    protected List<FailedDependencyDDLScripts_Data> _Scripts;
    protected List<FailedDependencyDDLScripts_Data> _FailedUnmanagedViewScripts = new ArrayList<FailedDependencyDDLScripts_Data>();


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
        _Scripts = FailedDependencyDDLScripts_Factory.lookupDDLDependencies(C, _SchemaName, _TableViewName);
        boolean Error = false;
        for (FailedDependencyDDLScripts_Data S : _Scripts)
          {
            if (TextUtil.isNullOrEmpty(S.getRestoreScript()) == true)
              {
                LOG.error("Couldn't get a restore script for view " + S.getDepSchemaName() + "." + S.getDepViewName() + ".");
                Error = true;
              }
          }


        // if (Error == false)
        // for (FailedDependencyDDLScripts_Data S : _Scripts)
        // {
        // FailedDependencyDDLScripts_Data S2 = FailedDependencyDDLScripts_Factory.create(S.getSrcSchemaName(), S.getSrcTVName(), S.getSeq(), S.getDepSchemaName(), S.getDepViewName(),
        // S.getRestoreScript());
        // if (S2.write(C) == false)
        // Error = true;
        // }

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
        for (FailedDependencyDDLScripts_Data S : _Scripts)
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
        Iterator<FailedDependencyDDLScripts_Data> I = new ReverseIterator<FailedDependencyDDLScripts_Data>(_Scripts);
        while (I.hasNext() == true)
          {
            FailedDependencyDDLScripts_Data S = I.next();
            boolean OK = false;
            try
              {
                OK = C.executeDDL(S.getDepSchemaName(), S.getDepViewName(), S.getRestoreScript());
              }
            catch (Exception E)
              {
                LOG.error("A database error occurred:\n", E);
                OK = false;
              }
            if (OK == false)
              {
                StringBuilder Str = new StringBuilder();
                Str.append("\n\n###############################################################################################################################\n");
                Str.append("##\n");
                Str.append("##  Database error restoring view " + S.getDepSchemaName() + "." + S.getDepViewName() + " that was\n");
                Str.append("##  dependent on " + _SchemaName + "." + _TableViewName + ".\n");
                Str.append("##\n");
                Str.append("##  Could not restore " + S.getDepSchemaName() + "." + S.getDepViewName() + " due likely to a removed column that had dependencies\n");
                Str.append("##  (i.e., a schema-breaking change, see exception above). You have to rerun Migrate. The dependent views\n");
                Str.append("##  are as follows:\n");
                I = new ReverseIterator<FailedDependencyDDLScripts_Data>(_Scripts);
                while (I.hasNext() == true)
                  {
                    S = I.next();
                    if (Schema.getView(_TildaList, S.getDepSchemaName(), S.getDepViewName()) == null)
                      {
                        _FailedUnmanagedViewScripts.add(S);
                        Str.append("##      X ").append(S.getDepSchemaName()).append(".").append(S.getDepViewName()).append("   [NOT TILDA-MANAGED]\n");
                      }
                    else
                      Str.append("##      - ").append(S.getDepSchemaName()).append(".").append(S.getDepViewName()).append("\n");
                  }
                Str.append("##\n");
                if (_FailedUnmanagedViewScripts.isEmpty() == false)
                  {
                    Str.append("##  NOTE: There were " + _FailedUnmanagedViewScripts.size() + " dependent view(s) found that are not managed through Tilda\n");
                    Str.append("##       (marked as such above if any). They must be re-created separately. Their captured DDL will\n");
                    Str.append("##       be saved and retrievable as follows:\n");
                    Str.append("            select * from Tilda.FailedDependencyDDLScripts\n");
                    Str.append("             where ");
                    FailedDependencyDDLScripts_Factory.COLS.SRCSCHEMANAME.getShortColumnVarForSelect(C, Str);
                    Str.append(" = ").append(TextUtil.escapeSingleQuoteForSQL(_SchemaName))
                    .append("\n               and ");
                    FailedDependencyDDLScripts_Factory.COLS.SRCTVNAME.getShortColumnVarForSelect(C, Str);
                    Str.append(" = ").append(TextUtil.escapeSingleQuoteForSQL(_TableViewName))
                    .append("\n             order by \"created\" desc, seq\n");
                    Str.append("##\n");
                    Str.append("##  NOTE: If you rerun Migrate and it still fails, you have to manually drop-cascade:\n");
                  }
                else
                  {
                    Str.append("##  NOTE: All those views are managed by Tilda and will be re-created automatically in the next Migrate. You can \n");
                    Str.append("         safely perform a manual drop-cascade:\n");
                  }
                Str.append("            - drop view ").append(_SchemaName).append(".").append(_TableViewName).append(" cascade.\n");
                Str.append("##\n");
                Str.append("###############################################################################################################################\n");
                ++Error;
                throw new Exception(Str.toString());
              }
          }
        if (Error != 0)
          LOG.debug("There were " + Error + " out of " + _Scripts.size() + " views which couldn't be re-created.");
      }

    public void errorHandling(Connection C)
    throws Exception
      {
        if (_FailedUnmanagedViewScripts.isEmpty() == true)
          return;
        
        for (FailedDependencyDDLScripts_Data S : _FailedUnmanagedViewScripts)
          {
            FailedDependencyDDLScripts_Data S2 = FailedDependencyDDLScripts_Factory.create(S.getSrcSchemaName(), S.getSrcTVName(), S.getSeq(), S.getDepSchemaName(), S.getDepViewName(), S.getRestoreScript());
            if (S2.write(C) == false)
              throw new Exception("Cannot save a restore script for " + S.getDepSchemaName() + "." + S.getDepViewName() + ".");
          }
      }

    public String getDependencyNames()
      {
        if (_Scripts == null)
          return "";
        StringBuilder Str = new StringBuilder();
        Iterator<FailedDependencyDDLScripts_Data> I = new ReverseIterator<FailedDependencyDDLScripts_Data>(_Scripts);
        while (I.hasNext() == true)
          {
            FailedDependencyDDLScripts_Data S = I.next();
            if (Str.length() != 0)
              Str.append(", ");
            Str.append(S.getDepSchemaName() + "." + S.getDepViewName());
          }
        return Str.toString();
      }

  }
