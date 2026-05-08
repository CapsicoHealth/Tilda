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

public class MigrationConversion
  {
    /*@formatter:off*/
    @SerializedName("object"    ) public String  _ObjectName;
    @SerializedName("column"    ) public String  _ColumnName;
    @SerializedName("conversion") public String  _Conversion;
    /*@formatter:on*/

    public transient Schema _Schema;
    public transient Object _Object;
    public transient Column _Column;

    public MigrationConversion()
      {

      }

    public MigrationConversion(MigrationConversion m)
      {
        this._ObjectName = m._ObjectName;
        this._ColumnName = m._ColumnName;
        this._Conversion = m._Conversion;
      }

    public boolean validate(ParserSession PS, Schema Parent)
      {
        int Errs = PS.getErrorCount();
        _Schema = Parent;

        if (TextUtil.isNullOrEmpty(_ObjectName) == true)
          PS.AddError("A migration definition in schema '" + _Schema._Name + "' for conversions is missing an object name.");

        if (TextUtil.isNullOrEmpty(_ColumnName) == true)
          PS.AddError("A migration definition for '" + _Schema._Name + "." + _ObjectName + "' for conversions is not defining a 'column' value.");

        if (TextUtil.isNullOrEmpty(_Conversion) == true)
          PS.AddError("A migration definition for '" + _Schema._Name + "." + _ObjectName + "' for conversions is missing a conversion expression.");

        if (PS.getErrorCount() > Errs)
          return false;

        if (TextUtil.isNullOrEmpty(_ObjectName) == false)
          {
            _Object = Parent.getObject(_ObjectName);
            if (_Object == null)
              PS.AddError("Migration definition for not nulls of object '" + _Schema.getShortName() + "." + _ObjectName + "', which cannot be found in this schema.");
            else if (TextUtil.isNullOrEmpty(_ColumnName) == false)
              {
                Column c = _Object.getColumn(_ColumnName);
                if (c == null)
                  PS.AddError("Migration definition for conversion of column '" + _Schema.getShortName() + "." + _ObjectName + "." + _ColumnName + "', which cannot be found in the object.");
                else
                  _Column = c;

                String p = _Object.getColumnsRegex().pattern();
                _Conversion = _Conversion.trim().replaceAll(p, _Object.getShortName() + ".\"$1\"");
              }
          }

        return Errs == PS.getErrorCount();
      }
  }
