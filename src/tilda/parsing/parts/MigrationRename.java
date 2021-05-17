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

public class MigrationRename
  {
    /*@formatter:off*/
    @SerializedName("object"  ) public String    _ObjectName;
    @SerializedName("view"    ) public String    _ViewName  ;
    @SerializedName("column"  ) public String    _ColumnName;
    @SerializedName("oldNames") public String[]  _OldNames;
    /*@formatter:on*/

    public transient Schema _Schema;
    public transient Object _Object;
    public transient View   _View;
    public transient Column _Column;

    public boolean Validate(ParserSession PS, Schema Parent)
      {
        int Errs = PS.getErrorCount();
        _Schema = Parent;

        if (TextUtil.isNullOrEmpty(_ObjectName) == true && TextUtil.isNullOrEmpty(_ViewName) == true)
          PS.AddError("A migration definition in schema '"+_Schema._Name+"' for renames is missing either an object or a view name: only one must be provided.");

        if (TextUtil.isNullOrEmpty(_ObjectName) == false && TextUtil.isNullOrEmpty(_ViewName) == false)
          PS.AddError("A migration definition in schema '"+_Schema._Name+"' for renames is including both an object and a view name: only one must be provided.");
        
        if (TextUtil.isNullOrEmpty(_ViewName) == false && TextUtil.isNullOrEmpty(_ColumnName) == false)
          PS.AddError("A migration definition in schema '"+_Schema._Name+"' for renames on view '"+_ViewName+"' is also defining a column name, which is not allowed.");
        
        if (TextUtil.isNullOrEmpty(_OldNames) == true)
          PS.AddError("A migration definition in schema '"+_Schema._Name+"' for renames is not defining at least one value for 'oldNames'.");

        if (PS.getErrorCount() > Errs)
          return false;

        if (TextUtil.isNullOrEmpty(_ObjectName) == false)
          {
            _Object = Parent.getObject(_ObjectName);
            if (_Object == null)
              PS.AddError("Migration definition for renames of object '" + _Schema.getShortName() + "." + _ObjectName + "' which cannot be found.");
            else if (TextUtil.isNullOrEmpty(_ColumnName) == false)
              {
                _Column = _Object.getColumn(_ColumnName);
                if (_Column == null)
                  PS.AddError("Migration definition for renames of column '" + _Schema.getShortName() + "." + _ObjectName + "." + _ColumnName + "' which cannot be found.");
              }
          }
        if (TextUtil.isNullOrEmpty(_ViewName) == false)
          {
            _View = Parent.getView(_ViewName);
            if (_View == null)
              PS.AddError("Migration definition for renames of view '" + _Schema.getShortName() + "." + _ViewName + "' which cannot be found.");
          }

        return Errs == PS.getErrorCount();
      }

  }
