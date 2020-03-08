package tilda.analyzer.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RegexData
  {
    @SerializedName("schema" )        public List<String>       _SchemaList = new ArrayList<String>();
    @SerializedName("table" )         public List<String>       _TableList  = new ArrayList<String>();
    
    
  }
