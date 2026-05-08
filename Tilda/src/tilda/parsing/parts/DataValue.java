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

import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class DataValue
  {

    /*@formatter:off*/
    @SerializedName("id"         ) public String      _Id   ;
    @SerializedName("value"      ) public String      _Value;
    @SerializedName("label"      ) public String      _Label;
    /*@formatter:on*/

    public transient Enumeration _ParentEnumeration;

    public DataValue()
      {
      }

    public DataValue(String Id, String Value, String Label)
      {
        _Id    = Id   ;
        _Value = Value;
        _Label = Label;
      }

    public boolean validate(ParserSession PS, Enumeration E)
      {
        int Errs = PS.getErrorCount();

        _ParentEnumeration = E;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Id) == true)
          PS.AddError("Enumeration '" + _ParentEnumeration._Name + "' defines a data value without an 'id'.");

        if (TextUtil.isNullOrEmpty(_Value) == false)
          PS.AddError("Enumeration '" + _ParentEnumeration._Name + "' defines a data value without a 'value'.");

        if (TextUtil.isNullOrEmpty(_Label) == false)
          PS.AddError("Enumeration '" + _ParentEnumeration._Name + "' defines a data value without a 'label'.");

        _ParentEnumeration._Id   .checkValueType(PS, "Enumeration '" + _ParentEnumeration._Name + "' data value 'id'"   , _Id   , false, null);
        _ParentEnumeration._Value.checkValueType(PS, "Enumeration '" + _ParentEnumeration._Name + "' data value 'value'", _Value, false, null);

        return Errs == PS.getErrorCount();
      }
  }
