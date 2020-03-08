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
