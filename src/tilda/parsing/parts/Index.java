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

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnMode;
import tilda.enums.OrderType;
import tilda.enums.TildaType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

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

    public transient Base            _Parent;

    public Index()
      {
      }

    public Index(Index I)
      {
        _Name = I._Name;
        _Columns = I._Columns;
        _OrderBy = I._OrderBy;
        _Db = I._Db;
        _SubWhere = I._SubWhere;
        if (I._SubQuery != null)
         _SubQuery = new SubWhereClause(I._SubQuery);
      }

    public String getName()
      {
        return _Parent._OriginalName + "_" + _Name;
      }

    public boolean Validate(ParserSession PS, Base Parent)
      {
        int Errs = PS.getErrorCount();
        _Parent = Parent;

        // Does it have a name?
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Object '" + _Parent.getFullName() + "' is defining an index without a name.");

        if (getName().length() > PS._CGSql.getMaxColumnNameSize())
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' with a final name '"+getName()+"' that's too long: max allowed by your database is "+PS._CGSql.getMaxColumnNameSize()+" vs "+getName().length()+" for this identifier.");
        if (_Name.equals(TextUtil.sanitizeName(_Name)) == false)
         PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' with a name containing invalid characters (must all be alphanumeric or underscore).");
        if (TextUtil.isJavaIdentifier(_Name) == false)
         PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' with a name that is imcompatible with standard identifier convensions (for example, Java, JavaScript since Foreign Keys have programmatic equivalents in those languages).");

        if ((_Columns == null || _Columns.length == 0) && (_OrderBy == null || _OrderBy.length == 0))
         PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' without columns and/or order by.");

        _Unique = _OrderBy == null || _OrderBy.length == 0;

        _ColumnObjs = ValidationHelper.ProcessColumn(PS, _Parent, "index '" + _Name + "'", _Columns, new ValidationHelper.Processor()
          {
            @Override
            public boolean process(ParserSession PS, Base ParentObject, String What, Column C)
              {
                if (C._Mode == ColumnMode.CALCULATED)
                  PS.AddError("Object '" + _Parent.getFullName() + "' is defining an index with column '" + C.getName() + "' which is calculated.");
// We think it's OK to have indices on null columns. Postgres will be smart about it for example, and SQLServer seems to handle it properly too.                
//                else if (_Unique == true && C._Nullable == true && _Columns.length > 1)
//                  PS.AddError("Object '" + _Parent.getFullName() + "' is using nullable column '" + C.getName() + "' in a multi-column unique index.");
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
                Names.add(C.getName().toUpperCase());

            _OrderByObjs.clear();
            _OrderByOrders.clear();
            processOrderBy(PS, "Object '" + _Parent.getFullName() + "' defines index '" + _Name + "'", Names, _Parent, _OrderBy, _OrderByObjs, _OrderByOrders);

            if (TextUtil.isNullOrEmpty(_SubWhere) == false && _SubQuery != null)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining unique index '" + _Name + "' with both a subWhere AND a subQuery: only one is allowed.");
            else
              {
                if (_SubWhere != null)
                  _SubQuery = new SubWhereClause(_SubWhere);

                if (_SubQuery != null)
                  {
                    if (_SubQuery._OrderBy != null && _SubQuery._OrderBy.length != 0)
                      PS.AddError("Object '" + _Parent.getFullName() + "' defines index '" + _Name + "' with a subQuery that contains an orderBy: this is not allowed as the index already defines one.");
                    if (_SubQuery._From.length != 0)
                      PS.AddError("Object '" + _Parent.getFullName() + "' defines index '" + _Name + "' with a subQuery that contains a \"From\" clause: this is not allowed in an Index SubQuery.");
                    for (Query SubWhere : _SubQuery._Wheres)
                      {
                        if (SubWhere._Clause.contains("?"))
                          PS.AddError("Object '" + _Parent.getFullName() + "' defines index '" + _Name + "' with a subQuery that contains a \"?\" variable placeholder: this is not allowed in an Index SubQuery.");
                      }
                    _SubQuery.Validate(PS, _Parent, "Object " + _Parent.getFullName() + "'s index '" + _Name + "'", false);
                  }
              }
          }
        else
          {
            if (_SubQuery != null)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining unique index '" + _Name + "' with a subQuery, which is not allowed.");
            if (TextUtil.isNullOrEmpty(_SubWhere) == false)
              PS.AddError("Object '" + _Parent.getFullName() + "' is defining unique index '" + _Name + "' with a subWhere, which is not allowed.");
          }


        return Errs == PS.getErrorCount();
      }

    public static void processOrderBy(ParserSession PS, String What, Set<String> Names, Base ParentObject, String[] OrderBy, List<Column> OrderByObjs, List<OrderType> OrderByOrders)
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
            if (Names.add(Col.toUpperCase()) == false)
              {
                PS.AddError(What + " with duplicated orderby '" + Col + "'.");
                continue;
              }
            Column C = ParentObject.getColumn(Col);
            if (C == null)
              {
                PS.AddError(What + " with orderby '" + Col + "' which cannot be found."+(ParentObject._TildaType!=TildaType.VIEW?"":" If you do need that column for the orderBy but do not want it in the final view, add it with \"joinOnly\"=true."));
                continue;
              }
            if (C._Mode == ColumnMode.CALCULATED)
              {
                PS.AddError(What + " with orderby '" + Col + "' which is calculated and therefore, not available at the database level.");
                continue;
              }
            OrderByObjs.add(C);
            OrderByOrders.add(Order);
          }
      }

    public String getSignature()
      {
        StringBuilder Str = new StringBuilder();
        // Defined Columns
        for (Column C : _ColumnObjs)
          {
            if (Str.length() != 0)
              {
                Str.append("|");
              }
            Str.append(C._Name).append("|asc");
          }
        // Defined Order Bys
        for (int i = 0; i < _OrderByObjs.size(); ++i)
          {
            Column C = _OrderByObjs.get(i);
            OrderType O = _OrderByOrders.get(i);
            if (Str.length() != 0)
              {
                Str.append("|");
              }
            Str.append(C._Name).append("|").append(O.name().toLowerCase());
          }
        return (_Unique ? "u" : "") + "i|" + Str.toString();
      }
  }
