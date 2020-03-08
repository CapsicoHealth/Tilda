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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.analyzer.parser.AnalyzerData;
import com.google.gson.annotations.SerializedName;

import tilda.db.Connection;
import tilda.utils.NumberFormatUtil;

public class Schema implements DBObject
  {
    protected static final Logger LOG = LogManager.getLogger(Schema.class.getName());

    private boolean               Completed;
    boolean                       Started;

    /*@formatter:off*/
    @SerializedName("name"    ) public final String           _Name;
    @SerializedName("created" ) public String           _Created;
    /*@formatter:on*/
    
    public List<Table> _TableList = new ArrayList<Table>();
    public List<View>  _ViewList  = new ArrayList<View>();

    public Schema(String Name)
      {
        _Name = Name;
      }


    
    public List<String> getTableNames()
    {
      List<String> TableNamesList = new ArrayList<String>();
      for(Table T : _TableList)
        {
          TableNamesList.add(T.getName());
        }
      return TableNamesList;
    }
    

    public void loadTablesAndViews(Connection C, AnalyzerData data, Map<String, DBObject> DBMap)
    throws Exception
      {
        DatabaseMetaData meta = C.getMetaData();
        ResultSet RS = meta.getTables(null, _Name.toLowerCase(), null, null);

        LOG.debug("Loading tables definition for the schema : " + _Name);

        while (RS.next() != false)
          {
            String Type = RS.getString("TABLE_TYPE");
            String Name = RS.getString("TABLE_NAME");

            LOG.debug("Database object name " + Name + " , Type " + Type);

            if (data.AnalyzeTable(_Name, Name))
              {
                if ("view".equalsIgnoreCase(Type) == true)
                  {
                    View view = new View(_Name, Name);
                    DBMap.put(_Name + "." + Name, view);
                    view.loadColumnInfo(C, _Name, DBMap);
                    _ViewList.add(view);
                  }
                else if ("table".equalsIgnoreCase(Type) == true)
                  {
                    LOG.debug("Creating table object for " + Name);

                    Table table = new Table(_Name, Name);
                    DBMap.put(_Name + "." + Name, table);
                    table.loadColumnInfo(C, _Name, DBMap);
                    _TableList.add(table);
                  }
              }
          }
        RS.close();

        if (_TableList.size() > 0)
          {
            Collections.sort(_TableList, new Comparator<Table>()
              {
                @Override
                public int compare(final Table object1, final Table object2)
                  {
                    return object1._TableName.compareTo(object2._TableName);
                  }
              });
          }
        if (_ViewList.size() > 0)
          {
            Collections.sort(_ViewList, new Comparator<View>()
              {
                @Override
                public int compare(final View object1, final View object2)
                  {
                    return object1._TableName.compareTo(object2._TableName);
                  }
              });
          }

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
        return _Name;
      }

    @Override
    public String getFullyQualifiedName()
      {
        return _Name;
      }

    @Override
    public boolean performTask(Connection C)
      {

        return true;
      }

    @Override
    public String getFileName(int part)
      {
        return "SCHEMA." + getFullyQualifiedName() + "."+NumberFormatUtil.leadingZero1(part)+".html";
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

    @Override
    public String getJsonFileName()
      {
        return "Json"+File.separatorChar + "SCHEMA." + getFullyQualifiedName() + "."+"json";
      }
    public String getHTMLFileName()
      {
        return "html"+File.separatorChar + "SCHEMA." + getFullyQualifiedName() + "."+"html";
      }
  
  }
