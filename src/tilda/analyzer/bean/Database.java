package tilda.analyzer.bean;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.analyzer.DBAnalyzer;
import tilda.analyzer.parser.AnalyzerData;
import tilda.analyzer.parser.Rule;

import tilda.db.Connection;

public class Database
  {
    protected static final Logger LOG = LogManager.getLogger(DBAnalyzer.class.getName());

    public Database(Connection C, AnalyzerData Data)
      throws SQLException
      {
        DatabaseMetaData meta = C.getMetaData();
        ResultSet Rs = meta.getSchemas();
        while (Rs.next())
          {
            String Name = Rs.getString("TABLE_SCHEM");
            LOG.debug("Schema Name : " + Name);
            if (Data.FilterSchemas(Name))
              {
                Schema schema = new Schema(Name);
                _DBMap.put(Name, schema);
                addSchema(schema);
              }
          }
        Rs.close();

        for (Schema S : _SchemaList)
          for (Table T : S._TableList)
            T.doInFK(this);
      }

    Map<String, DBObject>            _DBMap        = new HashMap<String, DBObject>();
    public Map<String, List<String>> _TableRuleMap = new HashMap<String, List<String>>();
    public Map<String, List<Rule>>   _RuleMap      = new HashMap<String, List<Rule>>();
    public List<Schema>              _SchemaList   = new ArrayList<Schema>();

    public boolean addSchema(Schema schema)
      {
        return _SchemaList.add(schema);
      }

    public void sortSchemas()
      {
        Collections.sort(_SchemaList, new Comparator<Schema>()
          {
            @Override
            public int compare(final Schema object1, final Schema object2)
              {
                return object1._Name.compareTo(object2._Name);
              }
          });
      }

    public void loadTablesAndViews(Connection C, AnalyzerData data)
    throws Exception
      {
        for (Schema S : _SchemaList)
          {
            S.loadTablesAndViews(C, data, _DBMap);
          }
      }

    public String GetSchemaListString()
      {
        return "";
      }

    public DBObject getDBObject(String value)
      {
        return _DBMap.get(value);
      }

    public void ValidateAndLoadRules(Connection C, AnalyzerData Data)
    throws Exception
      {
        Data.ValidateAndLoadRules(C, _TableRuleMap, _RuleMap);
      }

    public Table getTable(String SchemaName, String TableName)
      {
        for (Schema s : _SchemaList)
          if (s._Name.equalsIgnoreCase(SchemaName) == true)
            for (Table t : s._TableList)
              if (t._TableName.equalsIgnoreCase(TableName) == true)
               return t;
        return null;
      }
  }
