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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.interfaces.PatternObject;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Formula;
import tilda.parsing.parts.View;
import tilda.utils.TextUtil;

public class Flagging implements PatternObject
  {
    protected static final Logger LOG     = LogManager.getLogger(Flagging.class.getName());

    /*@formatter:off*/
    @SerializedName("column" ) public String _Column ;
    @SerializedName("type"   ) public String _TypeStr ;
    @SerializedName("ranges" ) public List<FlaggingRange> _Ranges = new ArrayList<FlaggingRange>();
    /*@formatter:on*/

    protected transient View      _ParentView;

    private ColumnType            _Type;

    public Flagging()
      {
      }

    public Flagging(Flagging F)
      {
        _Column = F._Column;
        _TypeStr = F._TypeStr;
        _Ranges = F._Ranges;
      }

    public View getParentView()
      {
        return this._ParentView;
      }

    public String getShortName()
      {
        return this._ParentView.getShortName() + "." + this._Column;
      }

    public String getColumnName()
      {
        return this._Column;
      }

    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        if (TextUtil.isNullOrEmpty(_Column) == true)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern on Column '" + _Column + "'is defining a formula pattern without a Column. You must define a Column for the Formula to use.");

        if (_Ranges.size() == 0)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern without any Ranges. You must define at least one Range with 'values' and a 'name'.");

        if (TextUtil.isNullOrEmpty(_TypeStr) == true)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern on Column '" + _Column + "' without a type.");
        else if ((_Type = ColumnType.parse(_TypeStr)) == null)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern on Column '" + _Column + "' with an invalid type '" + _TypeStr + "'.");

        HashSet<String> set = new HashSet<>();
        for (FlaggingRange FR : _Ranges)
          if (set.add(FR._Name) == false)
            PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern column '" + _Column + "' range name '" + FR._Name + "' that has a Name defined multiple times: '" + FR._Name + "'. Range Names must be unique.");

        for (FlaggingRange FR : _Ranges)
          {

            FR.Validate(PS, _ParentView, this);

            Formula F = new Formula();

            F._Name = _Column + "_" + FR._Name;
            F._Id = _Column + "_" + FR._Name;

            String values = FR.GetValuesString();

            String[] desc = new String[1];
            if (FR._Values.length > 1)
              desc[0] = "This formula checks whether the column '" + _Column + "' " + (FR._Exclude == true ? "does not contain " : "contains ") + "the values " + values + " for the View " + _ParentView.getShortName() + ".";
            else
              desc[0] = "This formula checks whether the column '" + _Column + "' " + (FR._Exclude == true ? "does not equal " : "equals ") + "the value " + values + " for the View " + _ParentView.getShortName() + ".";
            F._Description = desc;

            F._TypeStr = _TypeStr;

            String[] formulaStr = new String[1];
            if (FR._Values.length > 1)
              formulaStr[0] = "case when " + _Column + " " + (FR._Exclude == true ? " not" : "") + " in (" + values + ") then 1 else 0 end";
            else
              formulaStr[0] = "case when " + _Column + " " + (FR._Exclude == true ? " <> " : " = ") + values + " then 1 else 0 end";
            F._FormulaStrs = formulaStr;

            F._Title = _Column + "_" + FR._Name + " Title";

            // Check existing formulas
            for (Formula VF : _ParentView._Formulas)
              if (VF._Name.equals(F._Name))
                PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern generated column name '" + F._Name + "' with the same name as a user defined formula column " + VF._Name + ". Formula column names must be unique.");

            F._FormulaTemplate = true;

            _ParentView._Formulas.add(F);
          }
        return PS.getErrorCount() == Errs;
      }
  }
