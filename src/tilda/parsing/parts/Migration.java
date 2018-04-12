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

import tilda.enums.MigrationType;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class Migration
  {
    /*@formatter:off*/
    @SerializedName("type"    ) public MigrationType  _Type       ;
    @SerializedName("columns" ) public String[]       _ColumnNames;
    @SerializedName("value"   ) public String         _Value      ;
    /*@formatter:on*/

    public transient Base _Parent;

    public boolean Validate(ParserSession PS, Base Parent, int i)
      {
        int Errs = PS.getErrorCount();
        _Parent = Parent;

        if (_ColumnNames == null || _ColumnNames.length == 0)
          return PS.AddError("Object '" + _Parent.getFullName() + "' is defining migration #" + i + " without columns.");

        if (_Type == MigrationType.ADDNULL)
          {
            if (TextUtil.isNullOrEmpty(_Value) == false)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining ADDNULL migration #" + i + " with no value.");
          }

        if (_Type == MigrationType.RENAME)
          {
            if (_ColumnNames.length != 1)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining RENAME migration #" + i + " with more than one column: only one column is meaningful per migration step.");

            if (TextUtil.isNullOrEmpty(_Value) == false)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining RENAME migration #" + i + " with no value.");
          }

        Set<String> Names = new HashSet<String>();
        for (String Name : _ColumnNames)
          {
            if (TextUtil.isNullOrEmpty(Name) == true)
             continue;
            if (Names.add(Name) == false)
              {
                PS.AddError("Object '" + _Parent.getFullName() + "' is defining migration #" + i + " with duplicate column '" + Name + "'.");
                continue;
              }
            if (_Type == MigrationType.DROP && Parent.getColumn(Name) != null)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining DROP migration #" + i + " with column '" + Name + "' which is still defined as part of the object.");
            else if (_Type == MigrationType.ADDNULL)
              {
                Column C = Parent.getColumn(Name);
                if (C == null)
                  PS.AddError("Object '" + _Parent.getFullName() + "' is defining ADDNULL migration #" + i + " with column '" + Name + "' which is not defined in the object.");
                else if (C._Nullable == true)
                  PS.AddError("Object '" + _Parent.getFullName() + "' is defining ADDNULL migration #" + i + " with column '" + Name + "' which is nullable.");
              }
            else if (_Type == MigrationType.RENAME && Parent.getColumn(_Value) == null)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining RENAME migration #" + i + " with value '" + _Value + "' which cannot be found as a column in the object.");
            return true;
          }

        return Errs == PS.getErrorCount();
      }

  }
