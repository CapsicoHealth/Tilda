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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class View extends Base
  {


    static final Logger              LOG                = LogManager.getLogger(View.class.getName());

    /*@formatter:off*/
    @SerializedName("columns" ) public List<ViewColumn>     _ViewColumns= new ArrayList<ViewColumn    >();
    @SerializedName("subWhere") public String               _SubWhere;
    @SerializedName("subQuery") public SubWhereClause       _SubQuery;
    /*@formatter:on*/

    @Override
    public Column getColumn(String name)
      {
        for (ViewColumn C : _ViewColumns)
          if (C != null && C._Name != null && C._Name.equalsIgnoreCase(name) == true)
            return C._SameAsObj;
        return null;
      }

    @Override
    public ObjectLifecycle getLifecycle()
      {
        return ObjectLifecycle.READONLY;
      }

    @Override
    public boolean isOCC()
      {
        return false;
      }

    @Override
    public String getWhat()
      {
        return "View";
      }

    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        if (super.Validate(PS, ParentSchema) == false)
          return false;

        int Errs = PS.getErrorCount();

        if (_ViewColumns == null || _ViewColumns.isEmpty() == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring a view without any columns.");

        for (ViewColumn C : _ViewColumns)
          C.Validate(PS, this);

        if (TextUtil.isNullOrEmpty(_SubWhere) == false && _SubQuery != null)
          PS.AddError("View '" + getFullName() + "' is defining both a subWhere AND a subQuery: only one is allowed.");
        else
          {
            if (TextUtil.isNullOrEmpty(_SubWhere) == false)
             _SubQuery = new SubWhereClause(_SubWhere);

            if (_SubQuery != null)
              {
                if (_SubQuery._From != null && _SubQuery._From.length > 0)
                  PS.AddError("View '" + getFullName() + "' is defining a subQuery with a from clause: that is not allowed for views.");
                if (_SubQuery._OrderBy != null && _SubQuery._OrderBy.length > 0)
                  PS.AddError("View '" + getFullName() + "' is defining a subQuery with an orderBy: that is not allowed for views.");
                
                _SubQuery.Validate(PS, this, "View " + getFullName() + "'s "+(TextUtil.isNullOrEmpty(_SubWhere)==false?"subWhere":"subQuery"), false);
                
                if (_SubQuery._ColumnObjs.isEmpty() == false)
                 PS.AddError("View '" + getFullName() + "' is defining a subQuery with parameters: that is not allowed for views.");
              }
          }
        
        super.ValidateJsonMapping(PS);
        
        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }
  }
