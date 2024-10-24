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
import java.util.List;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnMapperMode;
import tilda.enums.ColumnMode;
import tilda.enums.FrameworkColumnType;
import tilda.enums.MultiType;
import tilda.enums.ValidationStatus;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

public class ColumnEnum
  {

    /*@formatter:off*/
    @SerializedName("destObject") public String            _DestObject ;
    @SerializedName("name"      ) public ColumnMapperMode  _Name   = ColumnMapperMode.MEMORY;
    @SerializedName("multi"     ) public MultiType         _Multi  = MultiType.NONE;
    /*@formatter:on*/

    public transient Object            _DestObjectObj;
    public transient Column            _ParentColumn;

    private transient ValidationStatus _Validation    = ValidationStatus.NONE;

    public ColumnEnum()
      {
      }
    public ColumnEnum(ColumnEnum CE)
      {
        this(CE._DestObject, CE._Multi);
      }
    public ColumnEnum(String DestObject, MultiType Multi)
      {
        _DestObject = DestObject;
        _Multi = Multi;
      }

    public boolean validate(ParserSession PS, Column ParentColumn)
      {
        if (_Validation != ValidationStatus.NONE)
          return _Validation == ValidationStatus.SUCCESS;
        int Errs = PS.getErrorCount();
        validateBase(PS, ParentColumn);
        _Validation = Errs == PS.getErrorCount() ? ValidationStatus.SUCCESS : ValidationStatus.FAIL;
        return _Validation == ValidationStatus.SUCCESS;
      }

    private void validateBase(ParserSession PS, Column ParentColumn)
      {
        _ParentColumn = ParentColumn;

        if (validateDestinationObject(PS) == false)
          return;

        List<Column> SrcColumnObjs = new ArrayList<Column>();
        SrcColumnObjs.add(_ParentColumn);

        ForeignKey.CheckForeignKeyMapping(PS, _ParentColumn._ParentObject, SrcColumnObjs, _DestObjectObj, "enum");
        
        if (_Name != ColumnMapperMode.NONE)
          {
            if (_ParentColumn._ParentObject.getColumn(_ParentColumn.getName()+"MappedName") != null)
             PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper which automatically adds the column '"+_ParentColumn.getName()+"MappedName'. That name clashes with an already defined column.");
            else
              {
                Column Col = new Column(_ParentColumn.getName()+"EnumValue", null, 0, _ParentColumn._Nullable, _ParentColumn._AllowEmpty, _Name == ColumnMapperMode.DB ? ColumnMode.AUTO : ColumnMode.CALCULATED, 
                                        _ParentColumn._Invariant, null, "Enum value for '"+_ParentColumn.getName()+"' through '"+_DestObjectObj.getFullName()+"'.", _ParentColumn._Precision, _ParentColumn._Scale, null, _ParentColumn._TzMode);
                Col._SameAs = _DestObjectObj.getColumn("value").getFullName();
                Col._FCT = FrameworkColumnType.MAPPER_NAME;
                Col._MapperDef = new ColumnMapper(new String[] { _ParentColumn.getName() }, _DestObject, _Name, null, _Multi);
                _ParentColumn._ParentObject.AddColumnAfter(_ParentColumn, Col);
              }
          }
      }

    private boolean validateDestinationObject(ParserSession PS)
      {
        if (TextUtil.isNullOrEmpty(_DestObject) == true)
          return PS.AddError("Column '" + _ParentColumn.getFullName() + "' is defining a mapper without a destination object.");

        ReferenceHelper R = ReferenceHelper.parseObjectReference(_DestObject, _ParentColumn._ParentObject.getSchema());
        if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
          return PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares mapper with an incorrect syntax for the destination object '" + _DestObject + "'. It should be '((package\\.)?schema\\.)?object'.");

        _DestObjectObj = PS.getObject(R._P, R._S, R._O);
        if (_DestObjectObj == null)
          return PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares mapper with destination Object '" + _DestObject + "' resolving to '" + R.getFullName() + "' which cannot be found.");

        return true;
      }

  }
