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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.DBType;
import tilda.enums.OrderType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class SubWhereClause
  {
    protected static final Logger LOG         = LogManager.getLogger(SubWhereClause.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String   _Name       ;
    @SerializedName("description") public String   _Description;
    @SerializedName("from"       ) public String[] _From   = { };
    @SerializedName("wheres"     ) public Query [] _Wheres = { };
    @SerializedName("orderBy"    ) public String[] _OrderBy= { };
    /*@formatter:on*/

    public transient List<Query.Attribute> _Attributes    = new ArrayList<Query.Attribute>();
    public transient List<Object>          _FromObj       = new ArrayList<Object>();
    public transient List<Column>          _OrderByObjs   = new ArrayList<Column>();
    public transient List<OrderType>       _OrderByOrders = new ArrayList<OrderType>();
    public transient boolean               _Unique;
    

    public transient Base          _ParentObject;
    
    public SubWhereClause()
      {
      }
    public SubWhereClause(String _SubWhere)
      {
        _Wheres = new Query[] { new Query(_SubWhere) };
      }

    public boolean Validate(ParserSession PS, Base ParentObject, String What, boolean TopLevel)
      {
        _ParentObject = ParentObject;
        // Does it have a name?
        if (TopLevel == true && TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError(What + " is defining a SubWhereClause without a name.");

        if (TopLevel == true && TextUtil.isNullOrEmpty(_Description) == true)
          return PS.AddError(What + " is defining a SubWhereClause '"+_Name+"' without a description.");

        if (_Wheres.length == 0)
          {
            PS.AddError(What + " is defining a SubWhereClause without any queries.");
            return true;
          }

        int Errs = PS.getErrorCount();

        Set<String> DBs = new HashSet<String>();
        for (Query q : _Wheres)
          {
            if (DBs.add(q._DB) == false)
              PS.AddError(What + " is defining a SubWhereClause with a duplicate DB value '" + q._DB + ".");
            q.Validate(PS, _ParentObject, What);
          }

        _Attributes = _Wheres[0]._Attributes;
        for (Query q : _Wheres)
          {
            if (_Attributes.size() != q._Attributes.size())
              {
                PS.AddError(What + " is defining SubWhereClauses without the exact same parameter list.");
                continue;
              }

            for (int i = 0; i < _Attributes.size(); ++i)
              {
                Query.Attribute A1 = q._Attributes.get(i);
                Query.Attribute A2 = _Attributes.get(i);
                if (A1._Col.hasBeenValidatedSuccessfully() == false)
                  {
                    PS.AddError(What + " is defining SubWhereClauses with column in position " + i + " " + A1._Col.getFullName() + " which has failed validation previously and cannot be processed any more.");
                    continue;
                  }
                if (A2._Col.hasBeenValidatedSuccessfully() == false)
                  {
                    PS.AddError(What + " is defining SubWhereClauses with column in position " + i + " " + A2._Col.getFullName() + " which has failed validation previously and cannot be processed any more.");
                    continue;
                  }
                if (A1._Col != A2._Col)
                  {
                    PS.AddError(What + " is defining SubWhereClauses with incompatible columns in position " + i + ": " + A1._Col.getFullName() + ", " + A2._Col.getFullName() + ".");
                    continue;
                  }

                if (A1._VarName.equals(A2._VarName) == false)
                  {
                    PS.AddError(What + " is defining SubWhereClauses with incompatible variable name in position " + i + ": " + A1._VarName + ", " + A2._VarName + ".");
                    continue;
                  }
              }
          }

        Query q = getQuery(PS._CGSql);
        if (q == null)
          PS.AddError(What + " is defining SubWhereClauses without a query for active database " + PS._CGSql.getName() + ".");

        if (_From.length != 0)
          {
            Set<String> Froms = new HashSet<String>();
            for (String s : _From)
              {
                if (TextUtil.isNullOrEmpty(s) == true)
                  continue;
                ReferenceHelper R = ReferenceHelper.parseObjectReference(s, _ParentObject.getSchema());
                Object O = PS.getObject(R._P, R._S, R._O);
                if (O == null)
                  {
                    PS.AddError(What + " is defining SubWhereClauses with a from '" + s + "' reference which cannot be found.");
                    continue;
                  }
                if (Froms.add(O.getFullName()) == false)
                  PS.AddError(What + " is defining SubWhereClauses with a duplicate from '" + s + "'.");
                else if (O == _ParentObject)
                  PS.AddError(What + " is defining SubWhereClauses with a from '" + s + "' refering to itself.");
                else
                  _FromObj.add(O);
              }
          }

        Index.processOrderBy(PS, "Object '" + _ParentObject.getFullName() + "' defines Query '" + _Name + "'", new HashSet<String>(), _ParentObject, _OrderBy, _OrderByObjs, _OrderByOrders);

        _Unique = _OrderBy == null || _OrderBy.length == 0;
        
        return Errs == PS.getErrorCount();
      }

    public Query getQuery(DBType Db)
      {
        return Query.getQuery(_Wheres, Db);
      }

  }
