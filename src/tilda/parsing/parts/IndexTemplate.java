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

import tilda.enums.ColumnMode;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.CollectionUtil;
import tilda.utils.TextUtil;

public class IndexTemplate
  {
    /*@formatter:off*/
    @SerializedName("name"    ) public String         _Name;
    @SerializedName("columns" ) public String[]       _Columns;
    @SerializedName("orderBy" ) public String[]       _OrderBy;
    @SerializedName("subWhere") public String         _SubWhere;
    @SerializedName("subQuery") public SubWhereClause _SubQuery;
    /*@formatter:on*/

    public transient Base         _Parent;

    public IndexTemplate()
      {
      }

    public IndexTemplate(IndexTemplate I)
      {
        _Name = I._Name;
        _Columns = I._Columns;
        _OrderBy = I._OrderBy;
        _SubWhere = I._SubWhere;
        if (I._SubQuery != null)
          _SubQuery = new SubWhereClause(I._SubQuery);
      }

    public boolean Validate(ParserSession PS, Base Parent)
      {
        int Errs = PS.getErrorCount();
        _Parent = Parent;

        // Does it have a name?
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Object '" + _Parent.getFullName() + "' is defining an index template without a name.");

        if (_Columns != null && _Columns.length > 0)
          _Columns = CollectionUtil.toStringArray(_Parent.expandColumnNames(_Columns, PS, "indexTemplate", _Name));

        if ((_Columns == null || _Columns.length == 0) && (_OrderBy == null || _OrderBy.length == 0))
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' without columns and/or order by.");

        return Errs == PS.getErrorCount();
      }
  }
