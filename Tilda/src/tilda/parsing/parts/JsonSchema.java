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

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

import tilda.enums.FrameworkSourcedType;
import tilda.enums.ValidationStatus;
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
    @SerializedName("description") public String         _Description;
    @SerializedName("fields"     ) public JsonField[]    _Fields     ;
    @SerializedName("validation" ) public JsonValidation _Validation ;
    /*@formatter:on*/

    private transient ValidationStatus _Validated = ValidationStatus.NONE;
    transient public Column            _parentColumn;
    transient public JsonSchema        _reusedJsonSchema;

    public JsonSchema(JsonSchema js)
      {
        _TypeName = js._TypeName;
        _Descr = js._Descr;
        if (js._Fields != null)
          {
            _Fields = new JsonField[js._Fields.length];
            for (int i = 0; i < js._Fields.length; ++i)
              _Fields[i] = new JsonField(js._Fields[i]);
          }
        if (js._Validation != null)
          _Validation = new JsonValidation(js._Validation);
      }

    public boolean validate(ParserSession PS, Column C)
      {
        if (_Validated != ValidationStatus.NONE)
          return _Validated == ValidationStatus.SUCCESS;

        boolean Success = true;

        _parentColumn = C;


        if (TextUtil.isNullOrEmpty(_Description) == false && TextUtil.isNullOrEmpty(_Descr) == false)
          {
            PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema with both 'descr' and 'description': only one is valid.");
            Success = false;
          }
        else if (TextUtil.isNullOrEmpty(_Description) == false)
          _Descr = _Description;

        if (TextUtil.isNullOrEmpty(_TypeName) == true)
          {
            PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema without a typeName.");
            Success = false;
          }

        // With views, the jsonSchema is reused. If "reused" has been set already, don't do it again!
        if (_reusedJsonSchema == null)
          {
            _reusedJsonSchema = getReusedJsonFieldTypeColumn(C, _TypeName);
            if (_reusedJsonSchema == this)
              _reusedJsonSchema = null;
          }
        if (_reusedJsonSchema != null)
          {
            if (TextUtil.isNullOrEmpty(_Descr) == true)
              _Descr = _reusedJsonSchema._Descr;

            if (_Fields != null && _Fields.length > 0)
              {
                PS.AddError("Column '" + C.getFullName() + "' is reusing jsonSchema '" + _TypeName + "' and cannot re-define fields.");
                Success = false;
              }
            // If we are referring to another type in another object in this schema, we need to clean up the json type name itself.
            String prefix = _reusedJsonSchema._parentColumn._ParentObject.getBaseName() + ".";
            if (_TypeName.startsWith(prefix) == true)
              _TypeName = _TypeName.substring(prefix.length());
          }
        else if (_Fields == null || _Fields.length == 0)
          {
            PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema '" + _TypeName + "' without any fields.");
            Success = false;
          }
        else
          {
            Set<String> fieldNames = new HashSet<String>();
            Set<String> jsonSchemaTypeNames = new HashSet<String>();
            for (JsonField f : _Fields)
              {
                if (f != null && f.validate(PS, C) == false)
                  Success = false;
                else if (fieldNames.add(f._Name) == false)
                  {
                    PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema '" + _TypeName + "' with duplicate field name '" + f._Name + "'.");
                    Success = false;
                  }
                if (f._JsonSchema != null)
                  {
                    if (f._JsonSchema.validate(PS, C) == false)
                      Success = false;
                    else if (f._JsonSchema._reusedJsonSchema == null && jsonSchemaTypeNames.add(f._JsonSchema._TypeName) == false)
                      {
                        PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema '" + _TypeName + "' with duplicate field jsonSchema type name '" + f._JsonSchema._TypeName + "'.");
                        Success = false;
                      }
                  }
              }
          }

        if (TextUtil.isNullOrEmpty(_Descr) == true)
          {
            PS.AddError("Column '" + C.getFullName() + "' defined a jsonSchema '" + _TypeName + "' without a description.");
            Success = false;
          }

        if (Success == true)
          {
            if (_Validation != null && _Validation.validate(PS, C, this) == false)
              Success = false;
          }

        _Validated = Success ? ValidationStatus.SUCCESS : ValidationStatus.FAIL;

        return Success;
      }

    /**
     * First, we check if the column itself is already referring to a jsonSchema with the
     * same type name. This is to allow multiple columns in the same object to refer to the
     * same jsonSchema without having to declare it on each column. Then, we check the
     * other columns in the same object, and finally we check the columns in the other
     * objects in the same schema. We also allow referring to a jsonSchema declared in
     * another object by prefixing the type name with the object name (e.g. "OtherObject.JsonTypeName").
     * 
     * @param col
     * @param typeName
     * @return
     */
    protected static JsonSchema getReusedJsonFieldTypeColumn(Column col, String typeName)
      {
        if (col != null && col._JsonSchema != null)
          {
            JsonSchema js = checkJsonSchemaTypeName(col._JsonSchema, typeName, true);
            if (js != null)
              return js;
          }

        for (Column c : col._ParentObject._Columns)
          {
            if (c == null)
              continue;
            if (c == col)
              break;
            if (c != null && c._JsonSchema != null)
              {
                JsonSchema js = checkJsonSchemaTypeName(c._JsonSchema, typeName, false);
                if (js != null)
                  return js;
              }

          }
        for (Object obj : col._ParentObject._ParentSchema._Objects)
          {
            if (obj == null || obj._FST != FrameworkSourcedType.NONE)
              continue;
            if (typeName.startsWith(obj.getBaseName() + ".") == false)
              continue;
            for (Column c : obj._Columns)
              if (c != null && c._JsonSchema != null)
                {
                  JsonSchema js = checkJsonSchemaTypeName(c._JsonSchema, typeName, false);
                  if (js != null)
                    return js;
                }
            if (obj == col._ParentObject)
              break;
          }
        return null;
      }

    private static JsonSchema checkJsonSchemaTypeName(JsonSchema jsonSchema, String typeName, boolean self)
      {
        if (self == false)
          if (jsonSchema._TypeName.equals(typeName) == true || (jsonSchema._parentColumn != null && typeName.equals(jsonSchema._parentColumn._ParentObject.getBaseName() + "." + jsonSchema._TypeName) == true))
            return jsonSchema;

        if (jsonSchema._Fields != null)
          for (JsonField f : jsonSchema._Fields)
            if (f != null && f._JsonSchema != null)
              {
                JsonSchema js = checkJsonSchemaTypeName(f._JsonSchema, typeName, false);
                // if there is a recursive pattern here, then there can be a field that references the same jsonSchema type name 
                // as the parent, so we need to check for that and not return it. A proper reuse means the fields are empty, 
                // so we check for that. Checking otherwise for js != jsonSchema is dangerous because it can be a different 
                // instance of the same jsonSchema type name, which is valid.
                if (js != null && (js._Fields == null || js._Fields.length == 0) == false)
                  return js;
              }
        return null;
      }
  }

