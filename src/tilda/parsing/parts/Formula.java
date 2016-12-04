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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class Formula
  {
    protected static final Logger LOG = LogManager.getLogger(Formula.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String   _Name       ;
    @SerializedName("id"         ) public String   _Id         ;
    @SerializedName("type"       ) public String   _TypeStr    ;
    @SerializedName("formula"    ) public String[] _FormulaStrs;
    @SerializedName("description") public String[] _Description;
    /*@formatter:on*/

    protected transient View      _ParentView;

    public transient ColumnType   _Type;
    public transient String       _Formula;

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
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula without a type.");
        else if ((_Type = ColumnType.parse(_TypeStr)) == null)
          PS.AddError("View " + _ParentView.getShortName() + " defined an invalid 'type' '" + _TypeStr + "'.");

        if (_FormulaStrs == null || _FormulaStrs.length == 0)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a SubWhereX without a formula.");
        else
          {
            StringBuilder Str = new StringBuilder();
            for (int i = 0; i < _FormulaStrs.length; ++i)
              {
                if (i != 0)
                 Str.append(" ");
                Str.append(_FormulaStrs[i].trim());
              }
            _Formula = Str.toString();
          }

        if (_Description == null || _Description.length == 0)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a SubWhereX without a description.");

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
        Pattern P = Pattern.compile("\\b(" + Str.toString() + ")\\b");
        Matcher M = P.matcher(_Formula);
        Str.setLength(0);
        while (M.find() == true)
          {
            String s = M.group(1);
            if (_Formula.substring(M.start()).toLowerCase().matches("^\\s*is\\s+null") == true)
              {
                M.appendReplacement(Str, '"' + M.group(1) + '"');
                continue;
              }
            for (ViewColumn VC : ParentView._ViewColumns)
              if (s.equals(VC._Name) == true)
                {
                  ColumnType T = VC._SameAsObj._Type;
                  if (T == ColumnType.INTEGER || T == ColumnType.LONG || T == ColumnType.FLOAT || T == ColumnType.DOUBLE)
                    {
                      M.appendReplacement(Str, "coalesce(\"" + M.group(1) + "\", 0)");
                      break;
                    }
                  M.appendReplacement(Str, '"' + M.group(1) + '"');
                  break;
                }
          }
        M.appendTail(Str);
        _Formula = Str.toString();

        // Resolve sub-formulas
        Str.setLength(0);
        for (Formula F : ParentView._Formulas)
          {
            if (Str.length() != 0)
              Str.append("|");
            Str.append(F._Name);
          }
        P = Pattern.compile("\\b(" + Str.toString() + ")\\b");
        M = P.matcher(_Formula);
        Str.setLength(0);
        while (M.find() == true)
          {
            String s = M.group(1);
            for (Formula F : ParentView._Formulas)
              if (s.equals(F._Name) == true)
                {
                  M.appendReplacement(Str, "(" + F._Formula + ")::int");
                  break;
                }
          }
        M.appendTail(Str);
        _Formula = Str.toString();

        return PS.getErrorCount() == Errs;
      }

  }
