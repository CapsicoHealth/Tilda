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

package tilda.analyzer.bean;

import java.io.File;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.db.SelectQuery;
import tilda.db.processors.ScalarRP;

public class Table implements DBObject
  {
    protected static final Logger LOG = LogManager.getLogger(Table.class.getName());

    public Table(String SchemaName, String TableName)
      {
        _SchemaName = SchemaName;
        _TableName = TableName;
      }

    public final String       _SchemaName;
    public final String       _TableName;
    public final List<String> FkOutList   = new ArrayList<String>();
    public final List<String> FkInList    = new ArrayList<String>();
    public List<Column>       _ColumnList = new ArrayList<Column>();

    private boolean           Completed;
    private boolean           Started;

    public void loadColumnInfo(Connection C, String SchemaName, Map<String, DBObject> DBMap)
    throws Exception
      {
        _ColumnList = Column.getColumnInfo(C, DBMap, SchemaName, _TableName, true);
        DatabaseMetaData meta = C.getMetaData();

        ResultSet rsOut = meta.getExportedKeys(null, SchemaName, _TableName);
        while (rsOut.next())
          {
            String TableName = rsOut.getString("FKTABLE_NAME");
            FkOutList.add(TableName);
          }
        rsOut.close();

        Collections.sort(FkOutList);
      }

    @Override
    public void setCompleted()
      {
        Completed = true;
      }

    @Override
    public boolean getCompleted()
      {
        return Completed;
      }

    @Override
    public String getName()
      {
        return _TableName;
      }

    @Override
    public String getFullyQualifiedName()
      {
        return _SchemaName + "." + _TableName;
      }


    @Override
    public boolean performTask(Connection C)
      {
        return true;
      }

    @Override
    public String getFileName(int tableFilePart)
      {
        return _SchemaName + File.separatorChar + _TableName + ".html";
      }

    @Override
    public boolean getStarted()
      {
        return Started;
      }

    @Override
    public void setStarted()
      {
        Started = true;
      }

    public long getRowCount(Connection C)
    throws Exception
      {
        try
          {
            SelectQuery SQ = new SelectQuery(C, _SchemaName, _TableName, true);
            SQ.selectCountStar().from(_SchemaName, _TableName);
            ScalarRP RP = new ScalarRP();
            SQ.execute(RP, 0, -1);
            return RP.getResult();
          }
        catch (SQLException E)
          {
            LOG.error("Failed getting row count for " + _SchemaName + "." + _TableName + ".\n", E);
            return 0;
          }
      }

    public long getRuleRowCount(Connection C, String Rule)
    throws Exception
      {
        try
          {
            SelectQuery SQ = new SelectQuery(C, _SchemaName, _TableName, true);
            SQ.selectCountStar().from(_SchemaName, _TableName).where().subWhere(Rule);
            ScalarRP RP = new ScalarRP();
            SQ.execute(RP, 0, -1);
            return RP.getResult();
          }
        catch (SQLException E)
          {
            LOG.error("Failed getting rules row count for " + _SchemaName + "." + _TableName + ".\n", E);
            return 0;
          }
      }

    public String getRulesData(Connection C, long RowCount, Map<String, List<String>> Map)
    throws Exception
      {
        StringBuilder Str = new StringBuilder();
        List<String> Rules = Map.get(getFullyQualifiedName().toLowerCase());

        if (RowCount == 0 || Rules == null || Rules.size() == 0)
          return Str.append("Number of Rows: ").append(RowCount).toString();

        Str.append("<ul>");
        Str.append("<li>").append("All rows").append("</li>");
        for (int i = 0; i < Rules.size(); ++i)
          {
            Str.append("<li>").append("Rule ").append(i + 1).append(" : ").append(Rules.get(i)).append("</li>");
          }
        Str.append("</ul>");


        Str.append("<table border=\"1px\"><tbody><tr><th></th><th>All</th>");
        for (int i = 0; i < Rules.size(); ++i)
          {
            Str.append("<th>").append("Rule ").append(i + 1).append("</th>");
          }
        Str.append("</tr><tr><td>Number of rows</td>");

        Str.append("<td>").append(RowCount).append("</td>");
        for (int i = 0; i < Rules.size(); ++i)
          {
            Str.append("<td>").append(getRuleRowCount(C, Rules.get(i))).append("</td>");
          }

        Str.append("</tr></tbody></table>");

        return Str.toString();
      }

    @Override
    public String getJsonFileName()
      {
        return "Json" + File.separatorChar + _SchemaName + File.separatorChar + _TableName + ".json";
      }


    public String getHTMLFileName()
      {
        return "html" + File.separatorChar + _SchemaName + File.separatorChar + _TableName + ".html";
      }

    public List<String> getColumnNames()
      {
        List<String> ColNames = new ArrayList<String>();
        for (Column C : _ColumnList)
          {
            ColNames.add(C.getName());
          }
        return ColNames;
      }

    public void doInFK(Database Db)
      {
        for (String s : FkOutList)
          {
            Table T = Db.getTable(_SchemaName, s);
            if (T != null)
              T.FkInList.add(_TableName);
          }

      }
  }
