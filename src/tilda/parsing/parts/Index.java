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

public class Index
  {
    /*@formatter:off*/
    @SerializedName("name"    ) public String         _Name   ;
    @SerializedName("columns" ) public String[]       _Columns;
    @SerializedName("cluster" ) public boolean        _Cluster = false;
    @SerializedName("orderBy" ) public String[]       _OrderBy;
    @SerializedName("db"      ) public boolean        _Db     = true;
    @SerializedName("subWhere") public String         _SubWhere;
    @SerializedName("subQuery") public SubWhereClause _SubQuery;
    /*@formatter:on*/

    public transient List<Column>  _ColumnObjs  = new ArrayList<Column>();
    public transient List<OrderBy> _OrderByObjs = new ArrayList<OrderBy>();
    public transient boolean       _Unique;
    public transient String[]      _LALColumns;

    public transient Base          _Parent;

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
        return TextUtil.print(_Parent._Prefix, _Parent._OriginalName) + "_" + _Name;
      }

    public boolean Validate(ParserSession PS, Base Parent)
      {
        int Errs = PS.getErrorCount();
        _Parent = Parent;

        // Does it have a name?
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Object '" + _Parent.getFullName() + "' is defining an index without a name.");

        if (getName().length() > PS._CGSql.getMaxColumnNameSize())
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' with a final name '" + getName() + "' that's too long: max allowed by your database is " + PS._CGSql.getMaxColumnNameSize() + " vs " + getName().length() + " for this identifier.");
        if (_Name.equals(TextUtil.sanitizeName(_Name)) == false)
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' with a name containing invalid characters (must all be alphanumeric or underscore).");
        if (TextUtil.isJavaIdentifier(_Name) == false)
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' with a name that is imcompatible with standard identifier convensions (for example, Java, JavaScript since Foreign Keys have programmatic equivalents in those languages).");

        if ((_Columns == null || _Columns.length == 0) && (_OrderBy == null || _OrderBy.length == 0))
          PS.AddError("Object '" + _Parent.getFullName() + "' is defining index '" + _Name + "' without columns and/or order by.");

        _Unique = _OrderBy == null || _OrderBy.length == 0;

        List<String> LALs = new ArrayList<String>();
        if (_Columns != null)
          for (int i = 0; i < _Columns.length; ++i)
            {
              if (_Columns[i] != null && _Columns[i].toLowerCase().endsWith(" lal") == true)
                {
                  _Columns[i] = _Columns[i].substring(0, _Columns[i].length() - " lal".length());
                  LALs.add(_Columns[i]);
                }
            }
        _LALColumns = CollectionUtil.toStringArray(LALs);

        _ColumnObjs = ValidationHelper.ProcessColumn(PS, _Parent, "index '" + _Name + "'", _Columns, new ValidationHelper.Processor()
          {
            @Override
            public boolean process(ParserSession PS, Base ParentObject, String What, Column C)
              {
                if (C._Mode == ColumnMode.CALCULATED)
                  PS.AddError("Object '" + _Parent.getFullName() + "' is defining an index with column '" + C.getName() + "' which is calculated.");
                // We think it's OK to have indices on null columns. Postgres will be smart about it for example, and SQLServer seems to handle it properly too.
                // else if (_Unique == true && C._Nullable == true && _Columns.length > 1)
                // PS.AddError("Object '" + _Parent.getFullName() + "' is using nullable column '" + C.getName() + "' in a multi-column unique index.");
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
            _OrderByObjs = OrderBy.processOrderBys(PS, "Object '" + _Parent.getFullName() + "' defines index '" + _Name + "'", _Parent, _OrderBy, false);

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
                    _SubQuery.validate(PS, _Parent, "Object " + _Parent.getFullName() + "'s index '" + _Name + "'", false);
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
        
        if (_Cluster == true && _Db == false)
         PS.AddError("Object '" + _Parent.getFullName() + "' is defining a non-database index '" + _Name + "' as clustered. Only database indices can be made clustered.");

        return Errs == PS.getErrorCount();
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
        for (OrderBy OB : _OrderByObjs)
          {
            if (OB == null)
              continue;
            if (Str.length() != 0)
              {
                Str.append("|");
              }
            Str.append(OB._Col._Name).append("|").append(OB._Order.name().toLowerCase());
            if (OB._Nulls != null)
              Str.append("|").append(OB._Nulls.name().toLowerCase());
          }
        return (_Unique ? "ui|" : "i|") + Str.toString();
      }

    @Override
    public String toString()
      {
        return getSignature();
      }
  }
