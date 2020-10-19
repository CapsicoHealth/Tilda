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

package tilda.parsing.parts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;

public class ViewPivotValue extends Value
  {
    static final Logger LOG = LogManager.getLogger(ViewPivotValue.class.getName());

    /*@formatter:off*/
    @SerializedName("type"      ) public String  _TypeStr   ;
    @SerializedName("size"      ) public Integer _Size      ;
    @SerializedName("expression") public String  _Expression;
    @SerializedName("scale"     ) public Integer _Scale     ;
    @SerializedName("precision" ) public Integer _Precision ;
    /*@formatter:on*/

    public transient TypeDef _Type;    

    public ViewPivotValue()
      {
      }
    
    public boolean Validate(ParserSession PS, View ParentView, String What)
      {
        int Errs = PS.getErrorCount();
        
        super.Validate(PS, ParentView, What);
        
        if (_TypeStr != null)
          {
            _Type = new TypeDef(_TypeStr, _Size, _Scale, _Precision);
            _Type.Validate(PS, What, true, false);
          }
                
        return Errs == PS.getErrorCount();
      }

  }
