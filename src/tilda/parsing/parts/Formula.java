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
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.AggregateType;
import tilda.enums.ColumnType;
import tilda.enums.MultiType;
import tilda.grammar.ErrorList;
import tilda.grammar.TildaSQLValidator;
import tilda.grammar.WhereClauseCodeGenJavaOnJson;
import tilda.parsing.ParserSession;
import tilda.types.ColumnDefinition;
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

    public Formula(Formula F)
      {
        super(F._TypeStr, F._Size);
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

        super.Validate(PS, "Formula '" + _Name + "' in View " + ParentView.getShortName() + "", true, false);

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

    public static boolean ValidateFormulaCode(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();

        List<ColumnDefinition> ColDefs = new ArrayList<ColumnDefinition>();
        for (ViewColumn VC : ParentView._ViewColumns)
          {
            ColumnDefinition Col = ColumnDefinition.Create(null, null, VC._Name,
            VC._Aggregate == AggregateType.COUNT ? ColumnType.INTEGER : VC._SameAsObj.getType(),
            VC._Aggregate != AggregateType.COUNT && VC._SameAsObj._TypeCollection != MultiType.NONE, 
            VC._Aggregate == AggregateType.COUNT ? false : VC._SameAsObj._Nullable,
            VC._Aggregate == AggregateType.COUNT ? "count" : VC._SameAsObj._Description);
            ColDefs.add(Col);
          }
        for (Formula F : ParentView._Formulas)
          {
            ColumnDefinition Col = ColumnDefinition.Create(null, null, F._Name, F._Type, F._TypeCollection != MultiType.NONE, true, F._Title);
            ColDefs.add(Col);
          }

        for (Formula F : ParentView._Formulas)
          {
            TildaSQLValidator SQLValidator = new TildaSQLValidator(String.join("\n", F._FormulaStrs), false);
            if (SQLValidator.getParserSyntaxErrors() != 0)
              {
                PS.AddError("View " + ParentView.getShortName() + " is defining a formula '" + F._Name + "' with an invalid formula.");
                return false;
              }

            SQLValidator.setColumnEnvironment(ColDefs);
            SQLValidator.validate();
            Iterator<ErrorList.Error> I = SQLValidator.getValidationErrors().getErrors();
            if (I != null)
              while (I.hasNext() == true)
                PS.AddError("View " + ParentView.getShortName() + " is defining a formula '" + F._Name + "' with an invalid formula: " + I.next());
          }

        return PS.getErrorCount() == Errs;
      }

  }
