package tilda.loader.parser;

import com.google.gson.annotations.SerializedName;

import tilda.utils.TextUtil;

public class ColumnHeader
  {
    @SerializedName("column"               ) public String    _Column;
    @SerializedName("header"               ) public String    _Header;
    @SerializedName("multi"                ) public boolean   _Multi = false ;
    @SerializedName("multiHeaderDelimeter" ) public String    _MultiHeaderDelimeter;
    @SerializedName("multiValueDelimeter"  ) public String    _MultiValueDelimeter;
    @SerializedName("index"                ) public int       _Index = -1;
    @SerializedName("start"                ) public int       _Start = -1;
    @SerializedName("split"                ) public boolean   _Split = false;
    @SerializedName("SplitStartIndex"      ) public int       _SplitStartIndex;
    @SerializedName("SplitEndIndex"        ) public int       _SplitEndIndex=-1;
    @SerializedName("operator"             ) public String    _Operator;
    @SerializedName("sum"                  ) public boolean   _Sum = false ;
    @SerializedName("constant"             ) public String    _Constant;
    
    public void validate()
    throws Exception
      {
        if (_Index != -1 && _Start != -1)
          throw new Exception("column definition is incorrect for multi-value header.");
        if (TextUtil.isNullOrEmpty(_Header) == true)
          _Header = _Column;
      }
  }
