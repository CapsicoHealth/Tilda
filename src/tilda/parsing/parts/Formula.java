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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.TZMode;
import tilda.parsing.ParserSession;
import tilda.utils.CollectionUtil;
import tilda.utils.TextUtil;

public class Formula extends TypeDef
  {
    protected static final Logger LOG              = LogManager.getLogger(Formula.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String   _Name       ;
    @SerializedName("measure"    ) public Boolean  _Measure    = Boolean.FALSE;
    @SerializedName("formula"    ) public String[] _FormulaStrs;
    @SerializedName("title"      ) public String   _Title      ;
    @SerializedName("id"         ) public String   _Id         ;
    @SerializedName("description") public String[] _Description;
    @SerializedName("values"     ) public Value[]  _Values;
    @SerializedName("coalesceNumbers" ) public boolean  _CoalesceNumbers = Boolean.TRUE;
    /*@formatter:on*/

    public transient View         _ParentView;
    public transient boolean      _FormulaTemplate = false;
    public transient Column       _ProxyCol;

    public Formula()
      {
      }

    public Formula(Formula F)
      {
        super(F._TypeStr, F._Size, F._Scale, F._Precision);
        _Name = F._Name;
        _FormulaStrs = F._FormulaStrs;
        _Title = F._Title;
        _Id = F._Id;
        _Description = F._Description;
        if (F._Values != null)
          {
            _Values = new Value[F._Values.length];
            for (int i = 0; i < F._Values.length; ++i)
              _Values[i] = new Value(F._Values[i]);
          }
        _FormulaTemplate = F._FormulaTemplate;
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
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula without a name.");
        else if (_Name.length() > PS._CGSql.getMaxColumnNameSize())
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula '" + _Name + "' with a name that's too long: max allowed by your database is " + PS._CGSql.getMaxColumnNameSize() + " vs " + _Name.length() + " for this identifier.");

        // if (TextUtil.isNullOrEmpty(_TypeStr) == true)
        // PS.AddError("View " + _ParentView.getShortName() + " is defining a formula '" + _Name + "' without a type.");
        // else if ((_Type = ColumnType.parse(_TypeStr)) == null)
        // PS.AddError("View " + _ParentView.getShortName() + " defined a formula '" + _Name + "' with an invalid type '" + _TypeStr + "'.");

        if (_FormulaStrs == null || _FormulaStrs.length == 0)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula '" + _Name + "' without a formula.");

        if (TextUtil.isNullOrEmpty(_Title) == true)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula '" + _Name + "' without a title.");

        else if (_Title.length() > 128)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula '" + _Name + "' with a title that is too long. 128 characters maximum.");

        if (_Description == null || _Description.length == 0)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula '" + _Name + "' without a description.");

        if (_Values != null)
          for (Value VPV : _Values)
            VPV.validate(PS, ParentView, "value for formula '" + _Name + "'");

        super.validate(PS, "Formula '" + _Name + "' in View " + ParentView.getShortName() + "", true, false, FrameworkSourcedType.VIEW);

        return PS.getErrorCount() == Errs;
      }

    public List<ViewColumn> getDependencyColumns()
      {
        List<ViewColumn> L = new ArrayList<ViewColumn>();
        if (getParentView()._ViewColumnsRegEx == null)
          return L;
        Matcher M = getParentView()._ViewColumnsRegEx.matcher(String.join("\n", _FormulaStrs));
        Set<String> Names = new HashSet<String>();
        while (M.find() == true)
          {
            String s = M.group(1);
            if (Names.add(s) == false)
              continue;
            ViewColumn vc = getParentView().getViewColumn(s);
            if (vc != null)
              L.add(vc);
          }
        return L;
      }

    public List<Formula> getDependencyFormulas()
      {
        List<Formula> L = new ArrayList<Formula>();
        if (getParentView()._FormulasRegEx == null)
          return L;
        Matcher M = getParentView()._FormulasRegEx.matcher(String.join("\n", _FormulaStrs));
        Set<String> Names = new HashSet<String>();
        while (M.find() == true)
          {
            String s = M.group(1);
            if (Names.add(s) == false)
              continue;
            Formula f = getParentView().getFormula(s);
            if (f != null)
              L.add(f);
          }
        return L;
      }

    protected static String[] getDependencyColumnNames(String formulaStr, Object obj, Pattern viewColumnsRegEx, Pattern formulasRegEx)
      {
        List<String> L = new ArrayList<String>();
        Set<String> Names = new HashSet<String>();
        Matcher[] matchers = new Matcher[] { viewColumnsRegEx == null ? null : viewColumnsRegEx.matcher(formulaStr), formulasRegEx == null ? null : formulasRegEx.matcher(formulaStr)
        };
        for (Matcher M : matchers)
          if (M != null)
            while (M.find() == true)
              {
                String s = M.group(1);
                if (Names.add(s) == false)
                  continue;
                Column c = obj.getColumn(s);
                if (s != null)
                  L.add(s);
              }
        return CollectionUtil.toStringArray(L);
      }
  }
