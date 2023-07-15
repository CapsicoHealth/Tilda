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

import tilda.enums.ColumnMode;
import tilda.enums.FrameworkSourcedType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;

import com.google.gson.annotations.SerializedName;

public class PrimaryKey
  {
    /*@formatter:off*/
    @SerializedName("columns"  )  public String[] _Columns;
    @SerializedName("autogen"  )  public Boolean  _Autogen  = Boolean.FALSE;
    @SerializedName("keyBatch" )  public Integer  _KeyBatch;
    /*@formatter:on*/

    public PrimaryKey()
      {
      }

    public PrimaryKey(PrimaryKey pk)
      {
        _Columns = pk._Columns;
        _Autogen = pk._Autogen;
        _KeyBatch = pk._KeyBatch;
      }

    public transient List<Column> _ColumnObjs = new ArrayList<Column>();
    public transient Object       _ParentObject;

    public boolean validate(ParserSession PS, Object obj)
      {
        int Errs = PS.getErrorCount();
        _ParentObject = obj;

        if (_Autogen == null && _Columns == null)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a primary key without any column or autogen setting: it needs one or the other.");

        if (_Autogen == false && (_Columns == null || _Columns.length == 0))
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a custom primary key (autogen is false) but doesn't have any columns listed.");

        if (_Autogen == true && _Columns != null)
          PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining an autogen primary key and also a list of columns. It's either one or the other.");

        if (_Autogen == true)
          {
            _Columns = new String[] { obj._ParentSchema.getConventionPrimaryKeyName()
            };
            if (_KeyBatch == null)
              _KeyBatch = 250;
          }
        else
          {
            if (_KeyBatch != null)
              return PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a keyBatch which is not valid for a non autogen primary key.");
          }
        _ColumnObjs = ValidationHelper.ProcessColumn(PS, obj, "a primary key", _Columns, new ValidationHelper.Processor()
          {
            @Override
            public boolean process(ParserSession PS, Base ParentObject, String What, Column C)
              {
                if (C._ParentObject._FST == FrameworkSourcedType.VIEW)
                  return true;

                if (C._Nullable == true)
                  PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a primary key with column '" + C.getName() + "' which is nullable.");
                if (C._Invariant == false)
                 C._Invariant = true;
//                  PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a primary key with column '" + C.getName() + "' which is not an invariant.");
                if (C._Mode == ColumnMode.CALCULATED)
                  PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a primary key with column '" + C.getName() + "' which is calculated.");
                C._PrimaryKey = true;
                return true;
              }
          });

        return Errs == PS.getErrorCount();
      }

  }
