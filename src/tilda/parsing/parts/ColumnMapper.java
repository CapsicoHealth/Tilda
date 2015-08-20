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

import tilda.enums.ColumnMapperMode;
import tilda.enums.ColumnMode;
import tilda.enums.MultiType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class ColumnMapper
  {

    /*@formatter:off*/
    @SerializedName("srcColumns") public String[]          _SrcColumns ;
    @SerializedName("destObject") public String            _DestObject ;
    @SerializedName("name"      ) public ColumnMapperMode  _Name   = ColumnMapperMode.MEMORY;
    @SerializedName("group"     ) public ColumnMapperMode  _Group  = ColumnMapperMode.DB;
    @SerializedName("multi"     ) public MultiType         _Multi  = MultiType.NONE;
    /*@formatter:on*/

    public transient List<Column> _SrcColumnObjs = new ArrayList<Column>();
    public transient Object       _DestObjectObj;
    
    public transient Column  _ParentColumn ;

    public boolean Validate(ParserSession PS, Column C)
      {
        int Errs = PS.getErrorCount();

        _ParentColumn = C;
        
        ValidateDestinationObject(PS);
        ValidateSourceColumns(PS);
        _SrcColumnObjs.add(_ParentColumn);

        if (_Name == ColumnMapperMode.NONE && _Group == ColumnMapperMode.NONE)
         PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper where both 'name' and 'group' are set to NONE. Why is a mapper defined then? At least one must not be NONE.");
        
        if (Errs != PS.getErrorCount())
          return false;

        ForeignKey.CheckForeignKeyMapping(PS, _ParentColumn._ParentObject, _SrcColumnObjs, _DestObjectObj, "mapper");
        
        if (_DestObjectObj.getColumn("name") == null && _Name != ColumnMapperMode.NONE)
         return PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper for 'name' but the mapper object '"+_DestObjectObj.getFullName()+"' doesn't define a 'name' column.");

        if (_DestObjectObj.getColumn("group") == null && _Group != ColumnMapperMode.NONE)
          return PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper for 'group' but the mapper object '"+_DestObjectObj.getFullName()+"' doesn't define a 'group' column.");
        
        if (_Group != ColumnMapperMode.NONE)
          {
            if (_ParentColumn._ParentObject.getColumn(_ParentColumn.getName()+"MappedGroup") != null)
             PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper which automatically adds the column '"+_ParentColumn.getName()+"MappedGroup'. That column has already been defined.");
            else
              {
                Column Col = new Column(_ParentColumn.getName()+"MappedGroup", null, 0, _ParentColumn._Nullable, _Group == ColumnMapperMode.DB ? ColumnMode.AUTO : ColumnMode.CALCULATED, 
                                        false, null, "Mapped group for '"+C.getName()+"' through '"+_DestObjectObj.getFullName()+"'.");
                Col._SameAs = _DestObjectObj.getColumn("group").getFullName();
                Col._FrameworkManaged = true;
                Col._MapperDef = this;
                _ParentColumn._ParentObject.AddColumnAfter(_ParentColumn, Col);
              }
          }
        if (_Name != ColumnMapperMode.NONE)
          {
            if (_ParentColumn._ParentObject.getColumn(_ParentColumn.getName()+"MappedName") != null)
             PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares a mapper which automatically adds the column '"+_ParentColumn.getName()+"MappedName'. That name clashes with an already defined column.");
            else
              {
                Column Col = new Column(_ParentColumn.getName()+"MappedName", null, 0, _ParentColumn._Nullable, _Name == ColumnMapperMode.DB ? ColumnMode.AUTO : ColumnMode.CALCULATED, 
                                        _ParentColumn._Invariant, null, "Mapped name for '"+C.getName()+"' through '"+_DestObjectObj.getFullName()+"'.");
                Col._SameAs = _DestObjectObj.getColumn("name").getFullName();
                Col._FrameworkManaged = true;
                Col._MapperDef = this;
                _ParentColumn._ParentObject.AddColumnAfter(_ParentColumn, Col);
              }
          }

        return Errs == PS.getErrorCount();
      }

    private boolean ValidateSourceColumns(ParserSession PS)
      {
        if (_SrcColumns == null || _SrcColumns.length == 0)
          return PS.AddError("Column '" + _ParentColumn.getFullName() + "' is defining a mapper without any source column.");

        _SrcColumnObjs = ValidationHelper.ProcessColumn(PS, _ParentColumn._ParentObject, "mapper", _SrcColumns, null);

        return true;
      }
    
    private boolean ValidateDestinationObject(ParserSession PS)
      {
        if (TextUtil.isNullOrEmpty(_DestObject) == true)
          return PS.AddError("Column '" + _ParentColumn.getFullName() + "' is defining a mapper without a destination object.");

        ReferenceHelper R = ReferenceHelper.parseObjectReference(_DestObject, _ParentColumn._ParentObject.getSchema());
        if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
         return PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares mapper with an incorrect syntax for the destination object '" + _DestObject + "'. It should be '((package\\.)?schema\\.)?object'.");
        
        _DestObjectObj = PS.getObject(R._P, R._S, R._O);
        if (_DestObjectObj == null)
         return PS.AddError("Column '" + _ParentColumn.getFullName() + "' declares mapper with destination Object '" + _DestObject + "' resolving to '"+R.getFullName()+"' which cannot be found.");

        return true;
      }
    
  }
