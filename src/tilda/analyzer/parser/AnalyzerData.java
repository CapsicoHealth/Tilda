package tilda.analyzer.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.db.Connection;
import tilda.utils.TextUtil;

public class AnalyzerData
  {
    protected static final Logger LOG              = LogManager.getLogger(AnalyzerData.class.getName());
    
    @SerializedName("regex")
    public List<RegexData>        _Regex           = new ArrayList<RegexData>();
    @SerializedName("DirectoryPath")
    public String                 _DirectoryPath   = null;
    @SerializedName("formatRules")
    public List<Rule>             _FormatRules     = new ArrayList<Rule>();
    @SerializedName("validationRules")
    public List<Validation>       _ValidationRules = new ArrayList<Validation>();
    @SerializedName("renderOnly")
    public boolean        _RenderOnly           = false;





    public boolean AnalyzeTable(String SchemaName, String TableName)
      {
        LOG.debug("Analyzing data for Schema " + SchemaName + " , table " + TableName);
        boolean value = false;
        for (RegexData RD : _Regex)
          {
            List<String> SchemaList = RD._SchemaList;
            List<String> TableList = RD._TableList;

            if (SchemaList == null || TableList == null || SchemaList.size() == 0 || TableList.size() == 0)
              {
                value = true;
                break;
              }

            if (SchemaList.contains(SchemaName.toLowerCase()))
              {
                for (String tablePattern : TableList)
                  {
                    if (TableName.toLowerCase().matches(tablePattern.toLowerCase()))
                      {
                        value = true;
                        break;
                      }
                  }
              }
          }
        return value;
      }

    public boolean FilterSchemas(String SchemaName)
      {
        LOG.debug("Filtering Schema " + SchemaName);

        for (RegexData RD : _Regex)
          {
            List<String> SL = RD._SchemaList;
            for (String SName : SL)
              {
                if (SchemaName.toLowerCase().matches(SName.toLowerCase()))
                  {
                    LOG.debug(" Matched filtering Schema " + SName);
                    return true;
                  }
              }
          }
        LOG.debug("Filtering not matched for the Schema " + SchemaName);
        return false;
      }

    public void ValidateAndLoadRules(Connection C, Map<String, List<String>> Map, Map<String, List<Rule>> RuleMap)
      throws Exception
      {
        LOG.debug("Validation rules started.");
        for (Validation V : _ValidationRules)
          {
            String Key = V._Schema + "." + V._Table;
            LOG.debug("Validating Rule : " + V._Name + " for the table " + Key);
            V.validateRules(C);
            Map.put(Key.toLowerCase(), V._Rules);
          }
        LOG.debug("Validation rules completed.");

        loadFormatRules(RuleMap);

      }

    private void loadFormatRules(Map<String, List<Rule>> Map)
      throws Exception
      {
        for (Rule R : _FormatRules)
          {
            List<String> Columns = R._Columns;
            for (String C : Columns)
              {
                if (TextUtil.isNullOrEmpty(C) == false)
                  {
                    String FC[] = C.split("\\.");
                    if (FC.length != 3)
                      throw new Exception("Invalid column definitioin : " + C);
                    String FullColumnName = FC[0] + "." + FC[1] + "." + FC[2];
                    
                    List<Rule> RL = Map.get(FullColumnName);
                    if(Map.get(FullColumnName.toLowerCase()) != null)
                      {
                        RL.add(R);
                      }
                    else
                      {
                        RL = new ArrayList<Rule>();
                        RL.add(R);
                        Map.put(FullColumnName.toLowerCase(),RL);
                      }
                  }
              }
          }
      }
  }
