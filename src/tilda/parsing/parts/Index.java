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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.enums.ColumnMode;
import tilda.enums.OrderType;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class Index
  {
    /*@formatter:off*/
    @SerializedName("name"    ) public String         _Name   ;
    @SerializedName("columns" ) public String[]       _Columns;
    @SerializedName("orderBy" ) public String[]       _OrderBy;
    @SerializedName("db"      ) public boolean        _Db     = true;
    @SerializedName("subWhere") public String         _SubWhere;
    @SerializedName("subQuery") public SubWhereClause _SubQuery;
    /*@formatter:on*/

    public transient List<Column>    _ColumnObjs    = new ArrayList<Column>();
    public transient List<Column>    _OrderByObjs   = new ArrayList<Column>();
    public transient List<OrderType> _OrderByOrders = new ArrayList<OrderType>();
    public transient boolean         _Unique;

    public transient Object          _ParentObject;

    public boolean Validate(ParserSession PS, Object ParentObject)
      {
        int Errs = PS.getErrorCount();
        _ParentObject = ParentObject;

        // Does it have a name?
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining an index without a name.");

        if ((_Columns == null || _Columns.length == 0) && (_OrderBy == null || _OrderBy.length == 0))
          return PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining index '"+_Name+"' without columns and/or order by.");

        _Unique = _OrderBy == null || _OrderBy.length == 0;

        _ColumnObjs = ValidationHelper.ProcessColumn(PS, _ParentObject, "index '" + _Name + "'", _Columns, new ValidationHelper.Processor() {
          @Override
          public boolean process(ParserSession PS, Object ParentObject, String What, Column C)
            {
              if (C._Mode == ColumnMode.CALCULATED)
                PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining an index with column '" + C._Name + "' which is calculated.");
              else if (_Unique == true && C._Nullable == true)
                PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining a unique index with column '" + C._Name + "' which is nullable.");
              else
                {
                  if (_Unique == true)
                    C._UniqueIndex = true;
                }
              return true;
            }
        });
        
        

        if (_Unique == false)
          {
            Set<String> Names = new HashSet<String>();
            if (_ColumnObjs != null)
             for (Column C : _ColumnObjs)
              Names.add(C._Name.toUpperCase());
            
            processOrderBy(PS, "Object '" + _ParentObject.getFullName() + "' defines index '" + _Name + "'", Names, _ParentObject, _OrderBy, _OrderByObjs, _OrderByOrders);
            
            if (TextUtil.isNullOrEmpty(_SubWhere) == false && _SubQuery != null)
              PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining unique index '" + _Name + "' with both a subWhere AND a subQuery: only one is allowed.");
            else
              {
                if (_SubWhere != null)
                 _SubQuery = new SubWhereClause(_SubWhere);
                
                if (_SubQuery != null)
                  {
                    if (_SubQuery._OrderBy != null && _SubQuery._OrderBy.length != 0)
                      PS.AddError("Object '" + _ParentObject.getFullName() + "' defines index '" + _Name + "' with a subQuery that contains an orderBy: this is not allowed as the index already defines one.");
                    _SubQuery.Validate(PS, _ParentObject, "Object " + _ParentObject.getFullName() + "'s index '" + _Name + "'", false);
                  }
              }
          }
        else
          {
            if (_SubQuery != null)
              PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining unique index '" + _Name + "' with a subQuery, which is not allowed.");
            if (TextUtil.isNullOrEmpty(_SubWhere) == false)
              PS.AddError("Object '" + _ParentObject.getFullName() + "' is defining unique index '" + _Name + "' with a subWhere, which is not allowed.");
          }


        return Errs == PS.getErrorCount();
      }

    public static void processOrderBy(ParserSession PS, String What, Set<String> Names, Object ParentObject, String[] OrderBy, List<Column> OrderByObjs, List<OrderType> OrderByOrders)
      {
        for (String ob : OrderBy)
          {
            if (TextUtil.isNullOrEmpty(ob) == true)
              continue;
            String[] parts = ob.split("\\s");
            if (parts.length > 2)
              {
                PS.AddError(What + " with an orderBy '" + ob + "' that is formatted incorrectly.");
                continue;
              }
            String Col = parts[0];
            OrderType Order = OrderType.parse(parts.length == 2 ? parts[1] : "ASC");
            if (Order == null)
              {
                PS.AddError(What + " with an orderBy '" + ob + "' that is formatted incorrectly: asc or desc expected.");
                continue;
              }
            Column C = ParentObject.getColumn(Col);
            if (C == null)
              {
                PS.AddError(What + " with orderby '" + Col + "' which cannot be found.");
                continue;
              }
            if (Names.add(Col.toUpperCase()) == false)
              {
                PS.AddError(What + " with duplicated orderby '" + Col + "'.");
                continue;
              }
            if (C._Mode == ColumnMode.CALCULATED)
              PS.AddError(What + " with orderby '" + Col + "' which is calculated.");
            else
              {
                OrderByObjs.add(C);
                OrderByOrders.add(Order);
              }
          }
      }
  }
