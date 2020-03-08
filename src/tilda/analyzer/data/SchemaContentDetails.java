package tilda.analyzer.data;

import java.util.ArrayList;
import java.util.List;

import tilda.analyzer.helper.DateHelper;
import com.google.gson.annotations.SerializedName;

public class SchemaContentDetails
  {
    
    /*@formatter:off*/
    @SerializedName("name"    ) public final String           _Name;
    @SerializedName("created" ) public final String           _Created ;
    @SerializedName("tables" )  public List<String> _TableList = new ArrayList<String>();    
    /*@formatter:on*/
    
    public SchemaContentDetails(String Name,  List<String> TablesList)
    {
      _Name = Name;
      _Created = DateHelper.getTimeNow();
      _TableList = TablesList;
    }
    
  }
