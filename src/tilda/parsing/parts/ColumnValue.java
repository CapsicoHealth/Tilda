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

import tilda.enums.DefaultType;
import tilda.enums.ValidationStatus;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class ColumnValue
  {

    /*@formatter:off*/
    @SerializedName("name"       ) public String      _Name;
    @SerializedName("value"      ) public String      _Value;
    @SerializedName("label"      ) public String      _Label;
    @SerializedName("description") public String      _Description;
    @SerializedName("groupings"  ) public String[]    _Groupings;
    @SerializedName("default"    ) public DefaultType _Default = DefaultType.NONE;
//    @SerializedName("raw"        ) public boolean     _Raw     = false;
    /*@formatter:on*/

    public transient Column            _ParentColumn;

    private transient ValidationStatus _Validation = ValidationStatus.NONE;

    public ColumnValue()
      {
      }

    private ColumnValue(String Name, String Value, String Label, String Description, String[] Groupings, DefaultType Default)
      {
        _Name        = Name;
        _Value       = Value;
        _Label       = Label;
        _Description = Description;
        _Groupings   = Groupings;
        _Default     = Default;
      }

    public boolean Validate(ParserSession PS, Column C)
      {
        if (_Validation != ValidationStatus.NONE)
          return _Validation == ValidationStatus.SUCCESS;
        int Errs = PS.getErrorCount();
        ValidateBase(PS, C);
        _Validation = Errs == PS.getErrorCount() ? ValidationStatus.SUCCESS : ValidationStatus.FAIL;
        return _Validation == ValidationStatus.SUCCESS;
      }

    private void ValidateBase(ParserSession PS, Column ParentColumn)
      {
        _ParentColumn = ParentColumn;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Name) == true)
          {
            PS.AddError("Column '" + _ParentColumn.getFullName() + "' defines a Value without a 'variable'.");
            return;
          }

        if (ValidationHelper.isValidIdentifier(_Name) == false)
          {
            PS.AddError("Column '" + _ParentColumn.getFullName() + "' defines a value with a name '" + _Name + "' which is not valid. " + ValidationHelper._ValidIdentifierMessage);
            return;
          }

        if (TextUtil.isNullOrEmpty(_Value) == true)
          _Value = _Name;

        if (TextUtil.isNullOrEmpty(_Description) == true)
         {
           if (TextUtil.isNullOrEmpty(_Label) == false)
             _Description = _Label;
           else
             PS.AddError("Column '" + _ParentColumn.getFullName() + "' defines a Value without a 'description' or a 'label'.");
         }

        if (TextUtil.isNullOrEmpty(_Label) == true)
          _Label = _Name;

        // if (_Raw == false)
        ValueHelper.CheckColumnValue(PS, _ParentColumn, _Name, _Value, _Default);
      }

    public static ColumnValue[] deepCopy(ColumnValue[] _Values)
      {
        if (_Values == null)
          return null;
        ColumnValue[] A = new ColumnValue[_Values.length];
        for (int i = 0; i < _Values.length; ++i)
          {
            ColumnValue v = _Values[i];
            if (v != null)
             {
               A[i] = new ColumnValue(v._Name, v._Value, v._Label, v._Description, v._Groupings, v._Default);
             }
          }
        return A;
      }
  }
