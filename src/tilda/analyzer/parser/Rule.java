package tilda.analyzer.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Rule
  {
    @SerializedName("name") public String _Name     = null;
    @SerializedName("regexes") public List<String> _Regexes     = new ArrayList<String>();
    @SerializedName("columns") public List<String> _Columns     = new ArrayList<String>();
  }
