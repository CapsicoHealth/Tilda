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

import com.google.gson.annotations.SerializedName;

import tilda.enums.AggregateType;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.JoinType;
import tilda.enums.OrderType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

public class ViewColumn
  {
    static final Logger LOG          = LogManager.getLogger(ViewColumn.class.getName());

    /*@formatter:off*/
	@SerializedName("name"       ) public String         _Name         ;
	@SerializedName("sameas"     ) public String         _Sameas_DEPRECATED;
    @SerializedName("sameAs"     ) public String         _SameAs       ;
    @SerializedName("as"         ) public String         _As           ;
    @SerializedName("prefix"     ) public String         _Prefix       ;
    @SerializedName("exclude"    ) public String[]       _Exclude       = new String[] { };
    @SerializedName("block"      ) public String[]       _Block         = new String[] { };
    @SerializedName("joinType"   ) public String         _JoinStr      ;
    @SerializedName("formulaOnly") public boolean        _FormulaOnly   = false;
    @SerializedName("joinOnly"   ) public boolean        _JoinOnly      = false;
    @SerializedName("aggregate"  ) public String         _AggregateStr ;
    @SerializedName("orderBy"    ) public String[]       _OrderBy;
    @SerializedName("coalesce"   ) public String         _Coalesce     = null;
    @SerializedName("distinct"   ) public Boolean        _Distinct     = false;
    @SerializedName("filter"     ) public String         _Filter       ;
    @SerializedName("useMapper"  ) public boolean        _UseMapper     = false;
    @SerializedName("useEnum"    ) public boolean        _UseEnum       = false;
    @SerializedName("description") public String         _Description   = null;
    /*@formatter:on*/




    public ViewColumn()
      {
      }
    /*
     * public ViewColumn(String Name, String SameAs, JoinType Join, boolean JoinOnly, AggregateType Aggregate)
     * {
     * _Name = Name;
     * _SameAs = SameAs;
     * _Join = Join;
     * _JoinOnly = JoinOnly;
     * _Aggregate = Aggregate;
     * }
     */

    public transient View            _ParentView;
    public transient Column          _SameAsObj;
    public transient JoinType        _Join;
    public transient AggregateType   _Aggregate;
    public transient List<Column>    _OrderByObjs   = new ArrayList<Column>();
    public transient List<OrderType> _OrderByOrders = new ArrayList<OrderType>();

    public transient boolean       _FailedValidation   = false;

    public boolean                 _FrameworkGenerated = false;


    public String getFullName()
      {
        return _ParentView.getFullName() + "." + _Name;
      }

    public String getShortName()
      {
        return _ParentView.getShortName() + "." + _Name;
      }

    public String getName()
      {
        return _Name;
      }

    public String getAggregateName()
      {
        if (_Aggregate == null)
          return getName();
        if (_Aggregate == AggregateType.COUNT && _SameAsObj == null)
          return _Distinct == true ? "COUNT(DISTINCT " + getName() + ")" : "COUNT(*)";
        return _Aggregate.name() + (_Distinct == true ? "(DISTINCT " : "(") + (_SameAsObj == null ? getShortName() : _SameAsObj.getShortName()) + ")";
      }

    public ColumnType getAggregateType()
      {
        return _Aggregate == null ? _SameAsObj.getType()
        : _Aggregate == AggregateType.COUNT && _SameAsObj == null ? ColumnType.LONG
        : _Aggregate.getType(_SameAsObj.getType());
      }

    
    public boolean FixSameAs(ParserSession PS)
      {
        if (TextUtil.isNullOrEmpty(_Sameas_DEPRECATED) == false)
          {
            if (TextUtil.isNullOrEmpty(_SameAs) == false)
              return PS.AddError("View column '" + getFullName() + "' defined both a 'sameAs' and a 'sameas'. Only one is allowed, and preferrably 'sameAs' since 'sameas' has been deprecated.");
            _SameAs = _Sameas_DEPRECATED;
            _Sameas_DEPRECATED = null;
          }
        return true;
      }
    
    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        if (FixSameAs(PS) == false)
         return false;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_SameAs) == true)
          return PS.AddError("View column '" + getFullName() + "' didn't define a 'sameAs'. It is mandatory.");

        if (TextUtil.isNullOrEmpty(_SameAs) == false)
          {
            _SameAsObj = ValidateSameAs(PS, getFullName(), _SameAs, _ParentView);
            if (_SameAsObj == null)
              return false;
            _FrameworkGenerated = _SameAsObj._FrameworkManaged;
          }

        if (TextUtil.isNullOrEmpty(_Name) == true)
          {
            _Name = _SameAsObj.getName();
          }

        if (_JoinStr != null)
          if ((_Join = JoinType.parse(_JoinStr)) == null)
            return PS.AddError("View Column '" + getFullName() + "' defined an invalid 'joinType' '" + _JoinStr + "'.");

        if (_AggregateStr != null)
          {
            if ((_Aggregate = AggregateType.parse(_AggregateStr)) == null)
              return PS.AddError("View Column '" + getFullName() + "' defined an invalid 'aggregate' '" + _AggregateStr + "'.");
            // if (_SameAsObj != null && _SameAsObj._Type == ColumnType.DATETIME)
            // return PS.AddError("View Column '" + getFullName() + "' defined an aggregate on DATETIME column '" + _SameAsObj.getName() + "' which is not supported as timezone
            // information would not be retrievable.");
          }
        if (_Aggregate == null)
          {
            if (_Distinct == true)
              return PS.AddError("View Column '" + getFullName() + "' defined a distinct value without specifying an aggregate. Distincts without aggregates make no sense.");
            if (TextUtil.isNullOrEmpty(_Filter) == false)
              return PS.AddError("View Column '" + getFullName() + "' defined a filter without specifying an aggregate. Filters are only valid with aggregates.");
          }

        if (TextUtil.isNullOrEmpty(_Description) == true && _SameAsObj != null)
          _Description = _SameAsObj._Description;
        
        if (_OrderBy!=null && _OrderBy.length > 0)
          {
            if (_Aggregate == null)
              PS.AddError("View Column '" + getFullName() + "' defined an orderBy value without specifying an aggregate. OrderBys are meant only for ARRAY, FIRST or LAST aggregates.");
            else if (_Aggregate.isOrderable() == false)
             PS.AddError("View Column '" + getFullName() + "' defined an orderBy value without specifying an ARRAY/FIRST/LAST aggregate. OrderBys are meant only for ARRAY, FIRST or LAST aggregates.");
            else if (_Distinct == true)
              PS.AddError("View Column '" + getFullName() + "' defined an orderBy value in a Distinct aggregate, which is not supported.");
            Set<String> Names = new HashSet<String>();
            Index.processOrderBy(PS, "View Column '" + getFullName() + "' array aggregate", Names, ParentView, _OrderBy, _OrderByObjs, _OrderByOrders);
          }
        
        if (_Exclude.length > 0 || _Block.length > 0)
          if (_SameAs.endsWith("*") == true)
            PS.AddError("View Column '" + getFullName() + "' defined an 'exclude' or 'block' attribute but the column is not a .*.");

        return Errs == PS.getErrorCount();
      }


    public static Column ValidateSameAs(ParserSession PS, String ColFullName, String SameAs, View ParentView)
      {
        ReferenceHelper R = ReferenceHelper.parseColumnReference(SameAs, ParentView);

        if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true || TextUtil.isNullOrEmpty(R._C) == true)
          PS.AddError("Column '" + ColFullName + "' is declaring sameas '" + SameAs + "' with an incorrect syntax. It should be '(((package\\.)?schema\\.)?object\\.)?column'.");
        else
          {
            Column Col = null;
            Schema S = PS.getSchema(R._P, R._S);
            if (S == null)
              PS.AddError("Column '" + ColFullName + "' is declaring sameas '" + SameAs + "' resolving to '" + R.getFullName() + "' where schema '" + R._P + "." + R._S + "' cannot be found.");
            else
              {
                Object O = S.getObject(R._O);
                if (O == null)
                  R.LogErrorKnownObjects(S);
                else
                  {
                    Col = O.getColumn(R._C);
                    if (Col == null)
                      R.LogErrorKnownColumns(O);
                  }
              }
            if (Col == null)
              PS.AddError("Column '" + ColFullName + "' is declaring sameas '" + SameAs + "' resolving to '" + R.getFullName() + "' which cannot be found.");
            else
              return Col;
          }

        return null;
      }

    public Column getSameAsRoot()
      {
        // LOG.debug("SameAs Root for " + getShortName() + ": " + _SameAsObj.getShortName());
        if (_SameAsObj != null && _SameAsObj._ParentObject._FST == FrameworkSourcedType.VIEW)
          {
            View SubV = _ParentView._ParentSchema.getSourceView(_SameAsObj._ParentObject);
            if (SubV == null)
              return null;
            // LOG.debug("SameAs is part of a sub-view " + SubV.getShortName());
            ViewColumn VC = SubV.getViewColumn(_SameAsObj.getName());
            if (VC != null)
              return VC.getSameAsRoot();
            else
              {
                // LOG.error("Could not find column " + _SameAsObj.getShortName() + " in view " + SubV.getShortName());
                return null;
              }
          }
        return _SameAsObj;
      }

    public List<Column> getSameAsLineage()
      {
        return getSameAsLineage(this);
      }

    public static List<Column> getSameAsLineage(ViewColumn VC)
      {
        List<Column> L = new ArrayList<Column>();
        Column C = VC._SameAsObj;
        while (C != null)
          {
            L.add(C);
            if (C.isForeignKey() == true || C._ParentObject._FST == FrameworkSourcedType.VIEW)
              C = C._SameAsObj;
            else
              break;
          }
        return L;
      }


    public String toString()
      {
        return getClass().getName() + ":" + getFullName();
      }
  }
