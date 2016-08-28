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

import opennlp.uima.normalizer.NumberUtil;
import tilda.parsing.ParserSession;
import tilda.utils.ParseUtil;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class JsonSchema
  {
    public JsonSchema()
      {
      }

    /*@formatter:off*/
    @SerializedName("typeName"   ) public String         _TypeName   ;
    @SerializedName("fields"     ) public JsonField[]    _Fields     ;
    @SerializedName("cardinality") public String         _Cardinality;
    @SerializedName("validation" ) public JsonValidation _Validation ;
    /*@formatter:on*/

    public transient int  _Min = 0;
    public transient int  _Max = 0;

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

        if (TextUtil.isNullOrEmpty(_Cardinality) == true)
          {
            PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema without a cardinality.");
            Success = false;
          }
        else if (_Cardinality.equals("*") == true)
          {
            _Min = 0;
            _Max = Integer.MAX_VALUE;
          }
        else if (_Cardinality.equals("+") == true)
          {
            _Min = 1;
            _Max = Integer.MAX_VALUE;
          }
        else if (_Cardinality.matches("\\d+\\.\\.\\d+") == true)
          {
            String[] parts = _Cardinality.split("\\.\\.");
            _Min = ParseUtil.parseInteger(parts[0], SystemValues.EVIL_VALUE);
            _Max = ParseUtil.parseInteger(parts[2], SystemValues.EVIL_VALUE);
            if (_Min == SystemValues.EVIL_VALUE || _Max == SystemValues.EVIL_VALUE)
              {
                PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema with an invalid cardinality format. Values accepted are '*', '+', 'x..y' where x and y are integers.");
                Success = false;
              }
            else if (_Min > _Max)
              {
                PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema with an invalid cardinality format. The min value " + _Min + " is greater than the max value '" + _Max + "'.");
                Success = false;
              }
          }
        else
          {
            PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema with an invalid cardinality format. Values accepted are '*', '+', 'x..y' where x and y are integers, and x <= y.");
            Success = false;
          }

        if (Success == true)
          {
            if (_Validation != null && _Validation.Validate(PS, C) == false)
              Success = false;
          }

        return Success;
      }
  }

