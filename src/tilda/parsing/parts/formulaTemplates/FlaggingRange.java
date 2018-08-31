/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
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

package tilda.parsing.parts.formulaTemplates;

import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.View;

public class FlaggingRange
  {
    protected static final Logger LOG = LogManager.getLogger(FlaggingRange.class.getName());

    /*@formatter:off*/
    @SerializedName("values" ) public String[] _Values;
    @SerializedName("name"   ) public String   _Name  ;
    @SerializedName("exclude") public boolean _Exclude = false;
    /*@formatter:on*/

    protected transient View      _ParentView;
    
    public FlaggingRange()
      {
      }

    public FlaggingRange(FlaggingRange FR)
      {
        _Values = FR._Values;
        _Name = FR._Name;
        _Exclude = FR._Exclude;
      }
    
    public String GetValuesString()
    {
      String values = "";
      
      for(String V : _Values)
        {
          if(values.length() > 0)
            values += ", ";
          values += "'" + V + "'";
        }
      
      return values;
    }


    public void Validate(ParserSession PS, View ParentView, Flagging F)
      {        
        _ParentView = ParentView;
        
        HashSet<String> set = new HashSet<>();
        for(String V : _Values)
          if(set.add(V) == false)
            PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern column '" + F._Column + "' range '" + _Name + "' that has duplicate values defined: '" + V + "'.");
      }

  }
