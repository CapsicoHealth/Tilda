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

package tilda.analyzer.data;

import java.util.ArrayList;
import java.util.List;

import tilda.analyzer.bean.Column;
import tilda.analyzer.bean.Database;
import tilda.analyzer.helper.DateHelper;
import tilda.analyzer.parser.Rule;
import com.google.gson.annotations.SerializedName;

import tilda.db.Connection;
import tilda.db.processors.RegexMatchingRP;
import tilda.enums.ColumnType;
import tilda.utils.pairs.StringLongPair;

public class ColumnContentDetails
  {
    /*@formatter:off*/
    @SerializedName("name"    ) public String _Name;
    @SerializedName("created" ) public String _Created;
    @SerializedName("type"    ) public String _Type;
    @SerializedName("typename"    ) public String _TypeName;
    @SerializedName("size"    ) public int _Size;
    @SerializedName("timingNS"    )public long  _Timing;
    @SerializedName("totalrows"    )public long _TotalRows;
    @SerializedName("totalnulls"    )public long _TotalNulls;
    @SerializedName("totalnotnulls"    )public long _TotalNotNulls;
    @SerializedName("toprowslist"    )public List<String> _TopRowsList = new ArrayList<String>();
    @SerializedName("noruleshistlist"    )public List<StringLongPair> _NoRulesHistList = new ArrayList<StringLongPair>();
    /*@formatter:on*/
    
      public ColumnContentDetails(String Name, String TypeName, int Size, long TotalRows)
      {
        _Name = Name;
        _Created = DateHelper.getTimeNow();
        _TypeName = TypeName;
        _Size = Size;
        _TotalRows = TotalRows;
      }
      public void setContentDetails(Connection C, Column Col, Database DB,long T0) throws Exception
      {
        long AllNullCount = Col.getNullCount(C, null);
        _TotalNulls = AllNullCount;
        _TotalNotNulls = _TotalRows - AllNullCount;
        
        if (Col._TildaType == ColumnType.STRING && _Size > 256)
          {
              _TopRowsList = Col.getTopResults(C, 50);
          }
        else
          {
            _NoRulesHistList = Col.getHistogram(C, null);
          }
        
        String fullQualifiedColumnName = Col.getFullyQualifiedName().toLowerCase();
        List<Rule> ColumnFormatRules = DB._RuleMap.get(fullQualifiedColumnName);

        if (ColumnFormatRules != null)
          for (int i = 0; i < ColumnFormatRules.size(); ++i)
            {
              List<String> Regexes = ColumnFormatRules.get(i)._Regexes;

              if (Regexes != null && Regexes.size() > 0)
                {
                  List<RegexMatchingRP.RegexDef> RDFList = new ArrayList<RegexMatchingRP.RegexDef>();
                  for (String Regex : Regexes)
                    {
                      RegexMatchingRP.RegexDef RDF = new RegexMatchingRP.RegexDef(Regex);
                      RDFList.add(RDF);
                    }
                }
            }        
        
        _Timing = System.nanoTime() - T0;
      }
  }
