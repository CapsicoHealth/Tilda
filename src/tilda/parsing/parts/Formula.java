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
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.DBType;
import tilda.enums.ColumnType;
import tilda.enums.OrderType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

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

    protected transient View         _ParentView;

    public transient ColumnType      _Type;
    public transient String          _Formula;

    public Formula()
      {
      }

    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        
        _ParentView = ParentView;

        if (TextUtil.isNullOrEmpty(_Name) == true)
         PS.AddError("View "+_ParentView.getShortName() + " is defining a formula without a name.");

        if (TextUtil.isNullOrEmpty(_TypeStr) == true)
         PS.AddError("View "+_ParentView.getShortName() + " is defining a formula without a type.");
        else if ((_Type = ColumnType.parse(_TypeStr)) == null)
         PS.AddError("View "+_ParentView.getShortName() + " defined an invalid 'type' '" + _TypeStr + "'.");

        if (_FormulaStrs == null || _FormulaStrs.length == 0)
          PS.AddError("View "+_ParentView.getShortName() + " is defining a SubWhereX without a formula.");
        else
          _Formula = String.join("\n", _FormulaStrs);

        if (_Description == null || _Description.length == 0)
          PS.AddError("View "+_ParentView.getShortName() + " is defining a SubWhereX without a description.");
        
        if (PS.getErrorCount() != Errs)
         return false;
        
        StringBuilder Str = new StringBuilder();
        for (ViewColumn VC : ParentView._ViewColumns)
          {
            if (Str.length() != 0)
             Str.append("|");
            Str.append(VC._Name);
          }

        Pattern P = Pattern.compile("\\b("+Str.toString()+")\\b");
        
        return PS.getErrorCount() == Errs;
      }

  }
