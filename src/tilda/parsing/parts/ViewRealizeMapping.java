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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class ViewRealizeMapping
  {
    static final Logger LOG          = LogManager.getLogger(ViewRealizeMapping.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String   _Name        = null;
    @SerializedName("mapper"     ) public String   _Mapper      = null;
    @SerializedName("description") public String   _Description = null;
    /*@formatter:on*/


    public ViewRealizeMapping()
      {
      }

    public transient View _ParentView;

    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("A realize-mapping for '" + _ParentView.getFullName() + "' is being defined without a column.");

        // if (_ParentView.getColumn(_Name) == null && _ParentView.getFormula(_Name) == null)
        // return PS.AddError("A realize-mapping for '" + _ParentView.getFullName() + "' is being defined for column/formula '" + _Name + "' which cannot be found.");

        if (TextUtil.isNullOrEmpty(_Mapper) == true)
          return PS.AddError("A realize-mapping for '" + _ParentView.getFullName() + "' is being defined for column '" + _Name + "' without a mapper.");

        if (TextUtil.isNullOrEmpty(_Description) == true)
          return PS.AddError("A realize-mapping for '" + _ParentView.getFullName() + "' is being defined for column '" + _Name + "' without a description.");

        return Errs == PS.getErrorCount();
      }

    public String printMapping()
      {
        Matcher M = _ParentView._ViewColumnsRegEx.matcher(_Mapper);
        StringBuffer Str = new StringBuffer();
        while (M.find() == true)
          {
            M.appendReplacement(Str, '"' + M.group(1) + '"');
          }
        M.appendTail(Str);

        if (_ParentView._FormulasRegEx != null)
          {
            M = _ParentView._FormulasRegEx.matcher(Str.toString());
            Str.setLength(0);
            while (M.find() == true)
              {
                M.appendReplacement(Str, '"' + M.group(1) + '"');
              }
            M.appendTail(Str);
          }
        return Str + " as " + "\"" + _Name + "\"";
      }

  }
