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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.DBType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;
import tilda.annotations.SchemaDoc;
import tilda.annotations.SchemaRefKind;

public class SubWhereClause
  {
    protected static final Logger          LOG          = LogManager.getLogger(SubWhereClause.class.getName());

    /*@formatter:off*/
    @SchemaDoc(description = "Name of this reusable query/sub-where definition; required when declared at object/view level.")
    @SerializedName("name"       ) public String   _Name       ;
    @SchemaDoc(description = "Description of this reusable query; required when declared at object/view level.")
    @SerializedName("description") public String   _Description;
    @SchemaDoc(description = "Objects participating in the query's FROM clause; references are resolved in the current schema/dependency context.", refKind = SchemaRefKind.OBJECT_IN_SCHEMA)
    @SerializedName("from"       ) public String[] _From   = { };
    @SchemaDoc(description = "Database-specific query clauses; at least one query is required.", required = true)
    @SerializedName("wheres"     ) public Query [] _Wheres = { };
    @SchemaDoc(description = "Column expressions controlling result ordering.", refKind = SchemaRefKind.COLUMN_REFERENCE)
    @SerializedName("orderBy"    ) public String[] _OrderBy= { };
    @SchemaDoc(description = "Table fulltext index used by this view lookup; mutually exclusive with 'vector'.")
    @SerializedName("fulltext"   ) public String   _FullTextIndex;
    @SchemaDoc(description = "Table vector index used by this view lookup; mutually exclusive with 'fulltext'.")
    @SerializedName("vector"     ) public String   _VectorIndex;
    /*@formatter:on*/

    public transient List<Query.Attribute> _Attributes  = new ArrayList<Query.Attribute>();
    public transient List<Object>          _FromObj     = new ArrayList<Object>();
    public transient List<OrderBy>         _OrderByObjs = new ArrayList<OrderBy>();
    public transient boolean               _Unique;
    public transient Index                  _ResolvedSearchIndex;
    public transient Object                 _SearchSourceObject;
    public transient ViewColumn             _SearchIdentityViewColumn;
    public transient String                 _SearchArtifactColumnName;
    public transient String                 _SearchArtifactExpression;
    public transient int                    _SearchArtifactOrdinal;


    public transient Base                  _ParentObject;

    public SubWhereClause()
      {
      }

    public SubWhereClause(String subWhere)
      {
        _Wheres = new Query[] { new Query(subWhere)
        };
      }

    public SubWhereClause(SubWhereClause SWC)
      {
        _Name = SWC._Name;
        _Description = SWC._Description;
        _From = Arrays.copyOf(SWC._From, SWC._From.length);
        _Wheres = new Query[SWC._Wheres.length];
        for (int i = 0; i < SWC._Wheres.length; ++i)
          _Wheres[i] = new Query(SWC._Wheres[i]);
        _OrderBy = Arrays.copyOf(SWC._OrderBy, SWC._OrderBy.length);
        _FullTextIndex = SWC._FullTextIndex;
        _VectorIndex = SWC._VectorIndex;
        _ResolvedSearchIndex = SWC._ResolvedSearchIndex;
        _SearchSourceObject = SWC._SearchSourceObject;
        _SearchIdentityViewColumn = SWC._SearchIdentityViewColumn;
        _SearchArtifactColumnName = SWC._SearchArtifactColumnName;
        _SearchArtifactExpression = SWC._SearchArtifactExpression;
        _SearchArtifactOrdinal = SWC._SearchArtifactOrdinal;
      }

    public boolean validate(ParserSession PS, Base ParentObject, String What, boolean TopLevel)
      {
        _ParentObject = ParentObject;
        int Errs = PS.getErrorCount();
        
        // Does it have a name?
        if (TopLevel == true && TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError(What + " is defining a SubWhereClause without a name.");

        if (TopLevel == true && TextUtil.isNullOrEmpty(_Description) == true)
          return PS.AddError(What + " is defining a SubWhereClause '" + _Name + "' without a description.");

        boolean hasFullText = TextUtil.isNullOrEmpty(_FullTextIndex) == false;
        boolean hasVector = TextUtil.isNullOrEmpty(_VectorIndex) == false;
        if (hasFullText == true || hasVector == true)
          {
            if (TopLevel == false || ParentObject instanceof View == false)
              PS.AddError(What + " query '" + _Name + "' may use 'fulltext' or 'vector' only as a top-level named view query.");
            if (hasFullText == true && hasVector == true)
              PS.AddError(What + " is defining query '" + _Name + "' with both 'fulltext' and 'vector'; only one search index is allowed.");
            if (_Wheres != null && _Wheres.length != 0)
              PS.AddError(What + " is defining index search query '" + _Name + "' with 'wheres'; fulltext/vector queries cannot define a WHERE clause.");
            if (_From != null && _From.length != 0)
              PS.AddError(What + " is defining index search query '" + _Name + "' with 'from'; the source table is determined by the index reference.");
            if (_OrderBy != null && _OrderBy.length != 0)
              PS.AddError(What + " is defining index search query '" + _Name + "' with 'orderBy'; results are ordered by relevance or vector distance.");
            _Attributes.clear();
            _Unique = false;
            return Errs == PS.getErrorCount();
          }

        if (_Wheres == null || _Wheres.length == 0)
          {
            PS.AddError(What + " is defining a SubWhereClause without any queries.");
            return true;
          }

        Set<String> DBs = new HashSet<String>();
        for (Query q : _Wheres)
          {
            if (DBs.add(q._DB) == false)
              PS.AddError(What + " is defining a SubWhereClause with a duplicate DB value '" + q._DB + ".");
            q.validate(PS, _ParentObject, What);
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
                  PS.AddError(What + " is defining SubWhereClauses with a duplicate from table '" + s + "'.");
                else if (O == _ParentObject)
                  PS.AddError(What + " is defining SubWhereClauses with a from '" + s + "' refering to itself.");
                else
                  _FromObj.add(O);
              }
          }

        _OrderByObjs = OrderBy.processOrderBys(PS, "Object '" + _ParentObject.getFullName() + "' defines Query '" + _Name + "'", _ParentObject, _OrderBy, true);

        _Unique = _OrderBy == null || _OrderBy.length == 0;

        return Errs == PS.getErrorCount();
      }

    public Query getQuery(DBType Db)
      {
        return Query.getQuery(_Wheres, Db);
      }

  }
