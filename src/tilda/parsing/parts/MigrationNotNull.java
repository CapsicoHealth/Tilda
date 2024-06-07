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
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.utils.TextUtil;

public class MigrationNotNull
  {
    /*@formatter:off*/
    @SerializedName("object"  ) public String    _ObjectName;
    @SerializedName("columns" ) public String[]  _ColumnNames;
    @SerializedName("default" ) public String    _Default;
    /*@formatter:on*/

    public transient Schema       _Schema;
    public transient Object       _Object;
    public transient List<Column> _Columns = new ArrayList<Column>();

    public MigrationNotNull()
      {

      }

    public MigrationNotNull(MigrationNotNull m)
      {
        this._ObjectName = m._ObjectName;
        this._ColumnNames = m._ColumnNames == null ? null : Arrays.copyOf(m._ColumnNames, m._ColumnNames.length);
        this._Default = m._Default;
      }

    public boolean validate(ParserSession PS, Schema Parent)
      {
        int Errs = PS.getErrorCount();
        _Schema = Parent;

        if (TextUtil.isNullOrEmpty(_ObjectName) == true)
          PS.AddError("A migration definition in schema '" + _Schema._Name + "' for not nulls is missing an object name.");

        if (TextUtil.isNullOrEmpty(_ColumnNames) == true)
          PS.AddError("A migration definition in schema '" + _Schema._Name + "' for not nulls is not defining at least one value for 'columns'.");

        if (_Default == null)
          PS.AddError("A migration definition in schema '" + _Schema._Name + "' for not nulls is missing a default value.");

        if (PS.getErrorCount() > Errs)
          return false;

        if (TextUtil.isNullOrEmpty(_ObjectName) == false)
          {
            _Object = Parent.getObject(_ObjectName);
            if (_Object == null)
              PS.AddError("Migration definition for not nulls of object '" + _Schema.getShortName() + "." + _ObjectName + "', which cannot be found in this schema.");
            else if (TextUtil.isNullOrEmpty(_ColumnNames) == false)
              {
                ColumnType type = null;
                for (String col : _ColumnNames)
                  {
                    Column c = _Object.getColumn(col);
                    if (c == null)
                      PS.AddError("Migration definition for not nulls of column '" + _Schema.getShortName() + "." + _ObjectName + "." + col + "', which cannot be found in the object.");
                    else if (c._Nullable == true)
                      PS.AddError("Migration definition for not nulls of column '" + _Schema.getShortName() + "." + _ObjectName + "." + col + "', which was defined as nullable.");
                    else if (c._DefaultCreateValue != null)
                      PS.AddError("Migration definition for not nulls of column '" + _Schema.getShortName() + "." + _ObjectName + "." + col + "', which was defined already with a default value.");
                    else
                      {
                        _Columns.add(c);
                        if (type == null)
                          type = c.getType();
                        else if (c.getType() != type)
                          PS.AddError("Migration definition for not nulls of column '" + _Schema.getShortName() + "." + _ObjectName + "." + col + "' of type '" + c.getType() + "' is different from the type of previous columns as '" + type + "'.");
                      }
                  }
                _Default = _Default.trim();
                String match = getColumnName(_Default);
                if (match == XXX_INALID_DEFAULT_VALUE_XXX)
                  PS.AddError("Migration definition for not nulls of column '" + _Columns.get(0).getShortName() + "' defines default value of '" + _Default + "' which is invalid: it should either be a single column in the form of '${colName}' or a constant value.");
                else if (match != null)
                  {
                    Column c = _Object.getColumn(match);
                    if (c == null)
                      PS.AddError("Migration definition for not nulls for '" + _Schema.getShortName() + "." + _ObjectName + "' defines a default value referring to column '" + match + "', which cannot be found in the object.");
                    if (c.getType() != type)
                      PS.AddError("Migration definition for not nulls for '" + _Schema.getShortName() + "." + _ObjectName + "' defined a default value referring to column '" + match + "', which is not of type '" + type + "'.");
                  }
                else
                  ValueHelper.CheckColumnValue(PS, "Migration definition for not nulls for ", _Columns.get(0), null, _Default, null);
              }
          }

        return Errs == PS.getErrorCount();
      }

    private static final String XXX_INALID_DEFAULT_VALUE_XXX = "XXX_INALID_DEFAULT_VALUE_XXX";

    protected static final Pattern P = Pattern.compile("\\$\\{([a-zA-Z_]\\w+)\\}");

    public static String getColumnName(String defaultValue)
      {
        Matcher M = P.matcher(defaultValue);
        if (M.find() == true)
          {
            String match = M.group(1);
            // We must check that this is the one and only value in the default. It's either
            // something that looks like a column placeholder, or something else altogether.
            if (match.length()+3 == defaultValue.length())
             return match;
            else
             return XXX_INALID_DEFAULT_VALUE_XXX;
          }
        return null;
      }

  }
