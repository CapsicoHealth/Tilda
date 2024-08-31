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

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class JsonField extends TypeDef
  {
    public JsonField()
      {
      }

    /*@formatter:off*/
    @SerializedName("name"       ) public String  _Name       ;
    @SerializedName("nullable"   ) public Boolean _Nullable   ;
    @SerializedName("description") public String  _Description;
    /*@formatter:on*/

    public JsonField(JsonField jf)
      {
        super(jf);
        _Name = jf._Name;
        _Nullable = jf._Nullable;
        _Description = jf._Description;
      }

    public boolean validate(ParserSession PS, Column C)
      {
        if (TextUtil.isNullOrEmpty(_Name) == true)
          {
            PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema with a field without name.");
            return false;
          }

        if (_Nullable == null)
          _Nullable = Boolean.TRUE;

        if (TextUtil.isNullOrEmpty(_Description) == true)
          PS.AddError("Column '" + C.getFullName() + " defined a jsonSchema with field '" + _Name + "' without a description.");

        if (super.validate(PS, "JsonSchema field", true, true, C._ParentObject._FST) == false)
          return false;

        return true;
      }
  }
