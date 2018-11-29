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
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.interfaces.PatternObject;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Formula;
import tilda.parsing.parts.View;
import tilda.utils.TextUtil;

public class Template extends Formula implements PatternObject
  {
    protected static final Logger  LOG     = LogManager.getLogger(Template.class.getName());

    /*@formatter:off*/
    @SerializedName("expansions" ) public List<TemplateExpansion> _Expansions = new ArrayList<TemplateExpansion>();
    /*@formatter:on*/

    protected transient View       _ParentView;

    public Template()
      {
      }

    public String getColumnName()
      {
        return this._Name;
      }

    @Override
    public boolean Validate(ParserSession PS, View ParentView)
      {
        _ParentView = ParentView;
        int Errs = PS.getErrorCount();

        if (super.Validate(PS, ParentView) == false)
         return false;

        if (_Expansions.size() == 0)
          PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern "+_Name+" without any expansion. You must define at least one expansion.");

        Set<String> Names = new HashSet<String>();
        Set<String> Titles= new HashSet<String>();
        for (TemplateExpansion TE : _Expansions)
          {
            TE.Validate(PS, _ParentView, this);
            if (Names.add(TE._Name) == false)
              PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern '"+_Name+"' with a duplicate name '"+TE._Name+"'.");
            if (Titles.add(TE._Title) == false)
              PS.AddError("View " + _ParentView.getShortName() + " is defining a formula pattern '"+_Name+"' with a duplicate title '"+TE._Title+"'.");

            Formula F = new Formula();
            F._Name = TextUtil.SearchReplace(_Name, "?", TE._Name);
            F._Id = F._Name;
            F._Description = new String[_Description.length];
            for (int i = 0; i < _Description.length; ++i)
             F._Description[i] = TextUtil.SearchReplace(_Description[i], "?", TE._Description);
            F._TypeStr = _TypeStr;
            F._Size = _Size;
            F._FormulaStrs = new String[_FormulaStrs.length];
            for (int i = 0; i < _FormulaStrs.length; ++i)
             F._FormulaStrs[i] = TextUtil.SearchReplace(_FormulaStrs[i], "?", TE._Expression);
            F._Title = TextUtil.SearchReplace(_Title, "?", TE._Title);

            F._FormulaTemplate = true;

            _ParentView._Formulas.add(F);
          }
        return PS.getErrorCount() == Errs;
      }
  }
