/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    @SerializedName("defaultValue"         ) public String    _DefaultValue;
    @SerializedName("coaleaseCol"          ) public String    _CoalesceCol;
    
    public void validate()
    throws Exception
      {
        if (_Index != -1 && _Start != -1)
          throw new Exception("column definition is incorrect for multi-value header.");
        if (TextUtil.isNullOrEmpty(_Header) == true)
          _Header = _Column;
      }
  }
