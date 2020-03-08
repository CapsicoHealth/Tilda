package tilda.analyzer.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.db.Connection;
import tilda.db.SelectQuery;
import tilda.db.processors.ScalarRP;

public class Validation
  {
    @SerializedName("name") public String _Name     = null;
    @SerializedName("table") public String _Table     = null;
    @SerializedName("schema") public String _Schema     = null;
    @SerializedName("rules") public List<String> _Rules     = new ArrayList<String>();
    protected static final Logger LOG = LogManager.getLogger(Validation.class.getName());
    
    public void validateRules(Connection C) throws Exception
    {
      // Need to create an arbitrary select value instead of column.
      String Rule = null;
      try
        {

          for(String SubWhereClause : _Rules)
            {
              SelectQuery SQ = new SelectQuery(C, _Schema, _Table, true);
              SQ.selectCountStar().from(_Schema, _Table);
              Rule = SubWhereClause;
              SQ.where().subWhere(SubWhereClause);
              ScalarRP RP = new ScalarRP();
              SQ.execute(RP, 0, 1);
            }
        }
      catch(Exception E)
        {
           LOG.debug("Error in rule definition with sub where cluase :"+Rule, E);
           throw E;
        }
    }
    
  }
