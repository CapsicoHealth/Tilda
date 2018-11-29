/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
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
import tilda.utils.TextUtil;

public class ViewPivotAggregate
  {
    static final Logger LOG             = LogManager.getLogger(ViewPivotAggregate.class.getName());

    /*@formatter:off*/
	@SerializedName("name"  ) public String  _Name;
    @SerializedName("prefix") public String  _Prefix;
    @SerializedName("suffix") public String  _Suffix;
    /*@formatter:on*/
    
    public transient ViewPivot _ParentPivot;

    public ViewPivotAggregate()
      {
      }

    public boolean Validate(ParserSession PS, ViewPivot ParentPivot)
      {
        int Errs = PS.getErrorCount();
        _ParentPivot = ParentPivot;
        
        if (TextUtil.isNullOrEmpty(_Name) == true)
         return PS.AddError("View '" + ParentPivot._ParentView.getFullName() + "' is defining a pivot on '"+_ParentPivot._ColumnName+"' with an aggregate without any 'name' column specified.");
        
        return Errs == PS.getErrorCount();
      }    

    public String makeName(Value V)
      {
        StringBuilder Str = new StringBuilder();
        if (TextUtil.isNullOrEmpty(_Prefix) == false)
         Str.append(_Prefix);
        Str.append(TextUtil.CapitalizeFirstCharacter(TextUtil.Print(V._Name, V._Value)));
        if (TextUtil.isNullOrEmpty(_Suffix) == false)
          Str.append(_Suffix);
        return Str.toString();
      }

  }
