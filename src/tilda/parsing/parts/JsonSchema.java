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

public class JsonSchema
  {
    public JsonSchema()
      {
      }

    /*@formatter:off*/
    @SerializedName("typeName"   ) public String         _TypeName   ;
    @SerializedName("descr"      ) public String         _Descr      ;
    @SerializedName("fields"     ) public JsonField[]    _Fields     ;
    @SerializedName("validation" ) public JsonValidation _Validation ;
    /*@formatter:on*/

    public boolean Validate(ParserSession PS, Column C)
      {
        boolean Success = true;

        if (TextUtil.isNullOrEmpty(_TypeName) == true)
          {
            PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema without a typeName.");
            Success = false;
          }

        if (_Fields == null || _Fields.length == 0)
          {
            PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema without any fields.");
            Success = false;
          }

        for (JsonField f : _Fields)
          if (f != null && f.Validate(PS, C) == false)
            Success = false;

        if (Success == true)
          {
            if (_Validation != null && _Validation.Validate(PS, C) == false)
              Success = false;
          }

        return Success;
      }
  }

