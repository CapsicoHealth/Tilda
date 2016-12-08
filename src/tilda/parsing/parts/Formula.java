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

import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class Formula extends TypeDef
  {
    protected static final Logger LOG = LogManager.getLogger(Formula.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String   _Name       ;
    @SerializedName("formula"    ) public String[] _FormulaStrs;
    @SerializedName("title"      ) public String   _Title      ;
    @SerializedName("id"         ) public String   _Id         ;
    @SerializedName("description") public String[] _Description;
    @SerializedName("values"     ) public Value[] _Values;
    /*@formatter:on*/

    protected transient View      _ParentView;

    public transient Pattern      _ViewColumnsRegEx;
    public transient Pattern      _FormulasRegEx;

    public Formula()
      {
      }

    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();

        _ParentView = ParentView;

        if (TextUtil.isNullOrEmpty(_Name) == true)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula without a name.");

        if (TextUtil.isNullOrEmpty(_TypeStr) == true)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula '" + _Name + "' without a type.");
        else if ((_Type = ColumnType.parse(_TypeStr)) == null)
          PS.AddError("View " + _ParentView.getShortName() + " defined a formula '" + _Name + "' with an invalid type '" + _TypeStr + "'.");

        if (_FormulaStrs == null || _FormulaStrs.length == 0)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula '" + _Name + "' without a formula.");

        if (TextUtil.isNullOrEmpty(_Title) == true)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula '" + _Name + "' without a title.");

        if (_Description == null || _Description.length == 0)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula '" + _Name + "' without a description.");

        if (_Values != null)
          for (Value VPV : _Values)
            VPV.Validate(PS, ParentView, "value for formula '" + _Name + "'");

        super.Validate(PS, "Formula '" + _Name + "' in View "+ParentView.getShortName()+"", true, false);

        if (PS.getErrorCount() != Errs)
          return false;

        // Resolve columns
        StringBuffer Str = new StringBuffer();
        for (ViewColumn VC : ParentView._ViewColumns)
          {
            if (Str.length() != 0)
              Str.append("|");
            Str.append(VC._Name);
          }
        _ViewColumnsRegEx = Pattern.compile("\\b(" + Str.toString() + ")\\b");
        
        Str.setLength(0);
        for (Formula F : ParentView._Formulas)
          {
            if (Str.length() != 0)
              Str.append("|");
            Str.append(F._Name);
          }
        _FormulasRegEx = Pattern.compile("\\b(" + Str.toString() + ")\\b");
                
        return PS.getErrorCount() == Errs;
      }

  }
