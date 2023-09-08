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
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

public class ColumnMapper
  {

    /*@formatter:off*/
    @SerializedName("srcColumns") public String[]          _SrcColumns ;
    @SerializedName("destObject") public String            _DestObject ;
    @SerializedName("name"      ) public ColumnMapperMode  _Name   = ColumnMapperMode.MEMORY;
    @SerializedName("group"     ) public ColumnMapperMode  _Group  = ColumnMapperMode.DB;
    @SerializedName("multi"     ) public MultiType         _Multi  = MultiType.NONE;
    /*@formatter:on*/

    public transient List<Column>      _SrcColumnObjs = new ArrayList<Column>();
    public transient Object            _DestObjectObj;
    public transient Column            _ParentColumn;

    private transient ValidationStatus _Validation    = ValidationStatus.NONE;

    public ColumnMapper()
      {
      }

    public ColumnMapper(ColumnMapper CM)
      {
        this(CM._SrcColumns, CM._DestObject, CM._Name, CM._Group, CM._Multi);
      }

    public ColumnMapper(String[] SrcColumns, String DestObject, ColumnMapperMode Name, ColumnMapperMode Group, MultiType Multi)
      {
        _SrcColumns = SrcColumns;
        _DestObject = DestObject;
        _Name = Name;
        _Group = Group;
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
        if (validateSourceColumns(PS) == false)
          return;
        _SrcColumnObjs.add(_ParentColumn);

        if (_Name == ColumnMapperMode.NONE && _Group == ColumnMapperMode.NONE)
          PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper where both 'name' and 'group' are set to NONE. Why is a mapper defined then? At least one must not be NONE.");

        if (ForeignKey.CheckForeignKeyMapping(PS, _ParentColumn._ParentObject, _SrcColumnObjs, _DestObjectObj, "mapper") == false)
          return;

        if (_DestObjectObj.getColumn("name") == null && _Name != ColumnMapperMode.NONE)
          {
            PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper for 'name' but the mapper object '" + _DestObjectObj.getFullName() + "' doesn't define a 'name' column.");
            return;
          }

        if (_DestObjectObj.getColumn("group") == null && _Group != ColumnMapperMode.NONE)
          {
            PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper for 'group' but the mapper object '" + _DestObjectObj.getFullName() + "' doesn't define a 'group' column.");
            return;
          }

        if (_Group != ColumnMapperMode.NONE)
          {
            Column C = _ParentColumn._ParentObject.getColumn(_ParentColumn.getName() + "MappedGroup");
            if (C != null)
              {
                // For views and realized tables, it's possible for generated columns to have already been brought in, so no need
                // to bring them in again.
                if (C._FCT.isManaged() == false) // || _ParentColumn._ParentObject._FST == FrameworkSourcedType.VIEW == false && _ParentColumn._ParentObject._FST == FrameworkSourcedType.REALIZED == false)
                  PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper which automatically adds the column '" + _ParentColumn.getName() + "MappedGroup'. That column has already been defined.");
              }
            else
              {
                Column Col = new Column(_ParentColumn.getName() + "MappedGroup", null, 0, _ParentColumn._Nullable, _Group == ColumnMapperMode.DB ? ColumnMode.AUTO : ColumnMode.CALCULATED,
                false, null, "Mapped group for '" + _ParentColumn.getName() + "' through '" + _DestObjectObj.getFullName() + "'.", _ParentColumn._Precision, _ParentColumn._Scale, null, _ParentColumn._TzMode);
                Col._SameAs = _DestObjectObj.getColumn("group").getFullName();
                Col._FCT = FrameworkColumnType.MAPPER_GROUP;
                Col._MapperDef = this;
                _ParentColumn._ParentObject.AddColumnAfter(_ParentColumn, Col);
              }
          }
        if (_Name != ColumnMapperMode.NONE)
          {
            Column C = _ParentColumn._ParentObject.getColumn(_ParentColumn.getName() + "MappedName");
            if (C != null)
              {
                // For views and realized tables, it's possible for generated columns to hav already been brought in, so no need
                // to bring them in again.
                if (C._FCT.isManaged() == false)
                  PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper which automatically adds the column '" + _ParentColumn.getName() + "MappedName'. That name clashes with an already defined column.");
              }
            else
              {
                Column Col = new Column(_ParentColumn.getName() + "MappedName", null, 0, _ParentColumn._Nullable, _Name == ColumnMapperMode.DB ? ColumnMode.AUTO : ColumnMode.CALCULATED,
                _ParentColumn._Invariant, null, "Mapped name for '" + _ParentColumn.getName() + "' through '" + _DestObjectObj.getFullName() + "'.", _ParentColumn._Precision, _ParentColumn._Scale, null, _ParentColumn._TzMode);
                Col._SameAs = _DestObjectObj.getColumn("name").getFullName();
                Col._FCT = FrameworkColumnType.MAPPER_NAME;
                Col._MapperDef = this;
                _ParentColumn._ParentObject.AddColumnAfter(_ParentColumn, Col);
              }
          }

      }

    private boolean validateSourceColumns(ParserSession PS)
      {
        if (_SrcColumns == null || _SrcColumns.length == 0)
          return PS.AddError("Column '" + _ParentColumn.getFullName() + "' is defining a mapper without any source column.");

        _SrcColumnObjs = ValidationHelper.ProcessColumn(PS, _ParentColumn._ParentObject, "mapper", _SrcColumns, null);

        return true;
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
