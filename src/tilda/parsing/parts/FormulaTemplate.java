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

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import tilda.enums.FormulaPatternType;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class FormulaTemplate
  {
    protected static final Logger   LOG             = LogManager.getLogger(FormulaTemplate.class.getName());

    /*@formatter:off*/
    @SerializedName("name"   ) public String            _Name   ;
    @SerializedName("pattern") public String            _PatternStr;
    @SerializedName("impls"  ) public List<JsonObject>  _Impls = new ArrayList<JsonObject>();
    /*@formatter:on*/
    
    public FormulaPatternType _Pattern;

    protected transient View  _ParentView;

    public FormulaTemplate()
      {
      }

    public FormulaTemplate(FormulaTemplate FT)
      {
        _Name = FT._Name;
        _PatternStr = FT._PatternStr;
        _Impls = FT._Impls;
      }

    public View getParentView()
      {
        return this._ParentView;
      }

    public String getShortName()
      {
        return this._ParentView.getShortName() + "." + this._Name;
      }

    public boolean validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();

        _ParentView = ParentView;

        if (TextUtil.isNullOrEmpty(_Name) == true)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula template without a name.");

        if (TextUtil.isNullOrEmpty(_PatternStr) == true)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula template '" + _Name + "' without a pattern.");
        else if ((_Pattern = FormulaPatternType.parse(_PatternStr)) == null)
          PS.AddError("View " + _ParentView.getShortName() + " defined a formula template '" + _Name + "' with an invalid PatternType '" + _PatternStr + "'.");
        if (_Impls.isEmpty() == true)
          PS.AddError("View " + _ParentView.getShortName() + " defined a formula template '" + _Name + "' with an empty list of implementations.");

        return Errs == PS.getErrorCount();
      }

  }
