package tilda.parsing.parts;

import com.google.gson.annotations.SerializedName;

public class Documentation
  {
    @SerializedName("graph") public String _Graph = "simple";
    @SerializedName("description") public String[] _Description = null;
    @SerializedName("exportPublish") public Boolean _ExportPublish = false;
  }
