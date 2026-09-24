package tilda.parsing.parts;

import com.google.gson.annotations.SerializedName;

import tilda.annotations.SchemaDoc;

public class ExtraDDL
  {
    @SchemaDoc(description = "Paths to SQL script resources executed before this schema's generated DDL.")
    @SerializedName("before") public String[] _Before = null;
    @SchemaDoc(description = "Paths to SQL script resources executed after this schema's generated DDL.")
    @SerializedName("after" ) public String[] _After  = null;
  }
