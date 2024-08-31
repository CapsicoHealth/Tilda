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

import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class MigrationMove
  {
    /*@formatter:off*/
    @SerializedName("schema" )  public String    _Schema ;
    @SerializedName("objects")  public String[]  _ObjectNames;
    @SerializedName("views"  )  public String[]  _ViewNames  ;
    /*@formatter:on*/

    public transient Schema       _Parent;
    public transient List<Object> _Objects = new ArrayList<Object>();
    public transient List<View>   _Views = new ArrayList<View>();

    public boolean validate(ParserSession PS, Schema Parent)
      {
        int Errs = PS.getErrorCount();
        _Parent = Parent;

        if (TextUtil.isNullOrEmpty(_Schema) == true)
          PS.AddError("A migration definition for changed schemas is missing the schema name");

        if (_ObjectNames != null)
          for (String n : _ObjectNames)
            {
              Object obj = Parent.getObject(n);
              if (obj == null)
                PS.AddError("Migration definition for changed schema '" + _Schema + "' is defining an object '" + n + "' in this schema '" + Parent._Name + "' which cannot be found.");
              else
                _Objects.add(obj);
            }

        if (_ViewNames != null)
          for (String n : _ViewNames)
            {
              View v = Parent.getView(n);
              if (v == null)
                PS.AddError("Migration definition for changed schema '" + _Schema + "' is defining a view '" + n + "' in this schema '" + Parent._Name + "' which cannot be found.");
              else
                _Views.add(v);
            }

        return Errs == PS.getErrorCount();
      }

  }
