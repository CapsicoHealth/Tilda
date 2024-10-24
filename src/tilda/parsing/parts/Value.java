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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class Value
  {
    static final Logger LOG = LogManager.getLogger(Value.class.getName());

    /*@formatter:off*/
	@SerializedName("value"      ) public String _Value;
    @SerializedName("name"       ) public String _Name;
    @SerializedName("description") public String _Description;
    /*@formatter:on*/


    public Value()
      {
      }

    public Value(Value V)
      {
        _Value = V._Value;
        _Description = V._Description;
      }
    
    public transient View _ParentView;

    public boolean validate(ParserSession PS, View ParentView, String What)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Value) == true)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining a " + What + " with a null or empty value.");

        if (TextUtil.isNullOrEmpty(_Description) == true)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining a " + What + " with a null or empty description.");

        if (TextUtil.isNullOrEmpty(_Name) == true)
         _Name = _Value;

        return Errs == PS.getErrorCount();
      }

  }
