package tilda.parsing.parts;

import com.google.gson.annotations.SerializedName;

public class ExtraDDL
  {
    @SerializedName("before") public String[] _Before = null;
    @SerializedName("after" ) public String[] _After  = null;
  }
