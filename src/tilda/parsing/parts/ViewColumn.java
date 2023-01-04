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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.AggregateType;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.JoinType;
import tilda.enums.TildaType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.ParseUtil;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class ViewColumn
  {
    static final Logger LOG          = LogManager.getLogger(ViewColumn.class.getName());

    /*@formatter:off*/
	@SerializedName("name"       ) public String         _Name         ;
	@SerializedName("sameas"     ) public String         _Sameas_DEPRECATED;
    @SerializedName("sameAs"     ) public String         _SameAs       ;
    @SerializedName("as"         ) public String         _As           ;
    @SerializedName("expression" ) public String         _Expression   ;
    @SerializedName("type"       ) public String         _TypeStr      ;
    @SerializedName("precision"  ) public Integer        _Precision    ;
    @SerializedName("scale"      ) public Integer        _Scale        ;
    @SerializedName("size"       ) public Integer        _Size         ;
    @SerializedName("prefix"     ) public String         _Prefix       ;
    @SerializedName("postfix"    ) public String         _Postfix      ;
    @SerializedName("exclude"    ) public String[]       _Exclude       = new String[] { };
    @SerializedName("block"      ) public String[]       _Block         = new String[] { };
    @SerializedName("joinType"   ) public String         _JoinStr      ;
    @SerializedName("formulaOnly") public boolean        _FormulaOnly   = false;
    @SerializedName("joinOnly"   ) public boolean        _JoinOnly      = false;
    @SerializedName("aggregate"  ) public String         _AggregateStr ;
    @SerializedName("orderBy"    ) public String[]       _OrderBy      ;
    @SerializedName("partitionBy") public String[]       _PartitionBy  ;
    @SerializedName("range"      ) public String         _Range        ;
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

    public transient View                _ParentView;
    public transient Column              _SameAsObj;                                  // The column this ViewColumn matches to, which could be to an object column OR a view
                                                                                      // column.
    public transient View                _SameAsView;                                 // If a View column, this is the view from which it came. Otherwise.
                                                                                      // _SameAsObj._ParentObject is the source object.
    public transient JoinType            _Join;
    public transient AggregateType       _Aggregate;
    public transient List<OrderBy>       _OrderByObjs      = new ArrayList<OrderBy>();
    public transient List<Column>        _partitionByObjs  = new ArrayList<Column>();
    public transient TypeDef             _Type;
    public transient String              _NameInner;                                  // The name of the column when used in an inner query fashion, like for pivots.
    public transient String              _MaskDef;

    public transient boolean             _FailedValidation = false;

    public transient FrameworkColumnType _FCT              = FrameworkColumnType.NONE;

    public transient Column              _ProxyCol         = null;                    // The column generated for the proxy object representing the parent view.

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

    /**
     * Returns the final type of the view column, which is the expression's type if defined, or else sameAs' type.
     * Additionally, It takes into account whether an aggregate has been defined and how the type will be modified.
     * 
     * @return
     */
    public ColumnType getType()
      {
        // A Type is allowed in a view column only if there is an expression, in which case, it will override the type of the sameAs.
        ColumnType baseLineType = _Type != null ? _Type._Type : _SameAsObj != null ? _SameAsObj.getType() : null;

        // No aggregates, so no change
        if (_Aggregate == null)
          return baseLineType;

        return baseLineType == null ? null : _Aggregate.getType(baseLineType, needsTZ());
      }

    /**
     * If the ViewColumn defines an expression and type, returns that. Otherwise, it returns the aggregate or original type.
     * 
     * @return
     */
    public int getSize()
      {
        return _Size != null ? _Size : _SameAsObj != null && _SameAsObj._Size != null ? _SameAsObj._Size : 0;
      }


    /**
     * if it's not an aggregate, returns the type if an expression is specified, of the type of the sameAs obj, otherwise, returns the aggregate type.
     * 
     * @return
     */
    // public ColumnType getAggregateType()
    // {
    // return getType();
    // ` }


    /**
     * Handles deprecated "sameas" and replaces with "sameAs" if appropriate.
     * 
     * @param PS
     * @return
     */
    public boolean FixSameAs(ParserSession PS)
      {
        if (TextUtil.isNullOrEmpty(_Sameas_DEPRECATED) == false)
          {
            if (TextUtil.isNullOrEmpty(_SameAs) == false)
              return PS.AddError("View column '" + getFullName() + "' defined both a 'sameAs' and a 'sameas'. Only one is allowed, and preferrably 'sameAs' since 'sameas' has been deprecated.");
            _SameAs = _Sameas_DEPRECATED;
            _Sameas_DEPRECATED = null;
          }
        _SameAs = _SameAs.trim();
        return true;
      }

    static protected final Pattern _RANGEREGEX = Pattern.compile("((UNBOUNDED|\\d+|CURRENT)\\s+(PRECEDING|FOLLOWING|ROW))\\s+AND\\s+((UNBOUNDED|\\d+|CURRENT)\\s+(PRECEDING|FOLLOWING|ROW))", Pattern.CASE_INSENSITIVE);

    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        if (FixSameAs(PS) == false)
          return false;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_SameAs) == true)
          return PS.AddError("View column '" + getFullName() + "' didn't define a 'sameAs'. It is mandatory.");
        else if (_FCT != FrameworkColumnType.TS)
          {
            _SameAsObj = ValidateSameAs(PS, getFullName(), _SameAs, _ParentView);
            if (_SameAsObj == null)
              return false;
            if (_FCT != FrameworkColumnType.PIVOT)
              _FCT = _SameAsObj._FCT;
            _SameAsView = _SameAsObj._ParentObject._ParentSchema.getView(_SameAsObj._ParentObject._Name);
          }

        if (TextUtil.isNullOrEmpty(_Name) == true)
          {
            _Name = _SameAsObj.getName();
          }

        ValidationHelper.validateColumnName(PS, "View", _Name, getFullName(), _ParentView._ParentSchema._Conventions);

        if (_JoinStr != null)
          if ((_Join = JoinType.parse(_JoinStr)) == null)
            return PS.AddError("View Column '" + getFullName() + "' defined an invalid 'joinType' '" + _JoinStr + "'.");

        if (_AggregateStr != null)
          {
            if ((_Aggregate = AggregateType.parse(_AggregateStr)) == null)
              return PS.AddError("View Column '" + getFullName() + "' defined an invalid 'aggregate' '" + _AggregateStr + "'.");

            if (_SameAsObj != null)
              {
                String Str = _Aggregate.isCompatible(this);
                if (Str != null)
                  PS.AddError(Str.toString());
              }
          }

        if (_Aggregate == null)
          {
            if (_Distinct == true)
              return PS.AddError("View Column '" + getFullName() + "' defined a distinct value without specifying an aggregate. Distincts without aggregates make no sense.");
            if (TextUtil.isNullOrEmpty(_Filter) == false)
              return PS.AddError("View Column '" + getFullName() + "' defined a filter without specifying an aggregate. Filters are only valid with aggregates.");
          }

        if (_SameAsObj != null)
          {
            if (TextUtil.isNullOrEmpty(_Description) == true)
              _Description = _SameAsObj._Description;
            else
              _Description = TextUtil.searchReplace(_Description, "${DESCRIPTION}", _SameAsObj._Description);
          }

        if (_OrderBy != null && _OrderBy.length > 0)
          {
            if (_Aggregate == null)
              PS.AddError("View Column '" + getFullName() + "' defined an orderBy value without specifying an aggregate. OrderBys are meant only for ARRAY, FIRST or LAST aggregates.");
            else if (_Aggregate.getOrderable() == AggregateType.OrderableType.NONE)
              PS.AddError("View Column '" + getFullName() + "' defined an orderBy value without specifying an orderable aggregate (such as FIRST/LAST/ARRAY/ROW_NUMBER... OrderBys are meant only for orderable aggregates.");
            // else if (_Distinct == true)
            // PS.AddError("View Column '" + getFullName() + "' defined an orderBy value in a Distinct aggregate, which is not supported.");
            _OrderByObjs = OrderBy.processOrderBys(PS, "View Column '" + getFullName() + "' array aggregate", ParentView, _OrderBy, true);
          }

        if (_PartitionBy != null && _PartitionBy.length > 0)
          {
            if (_Aggregate == null)
              PS.AddError("View Column '" + getFullName() + "' defined a partitionBy value without specifying an aggregate.");
            Set<String> names = new HashSet<String>();
            for (String pb : _PartitionBy)
              {
                if (names.add(pb) == false)
                  {
                    PS.AddError("View Column '" + getFullName() + "' defined a duplicate partitionBy value '" + pb + "'.");
                    continue;
                  }
                Column col = Column.deepColumnSearch(PS, ParentView, pb);
                if (col == null)
                  {
                    PS.AddError("View Column '" + getFullName() + "' defined a partitionBy column '" + pb + "' which cannot be found. Try bringing that column as a 'joinOnly=true' viewcolumn.");
                    continue;
                  }
                _partitionByObjs.add(col);
              }
          }

        if (TextUtil.isNullOrEmpty(_Range) == false)
          {
            _Range = _Range.trim();
            if (_Aggregate == null)
              PS.AddError("View Column '" + getFullName() + "' defined a window range '" + _Range + "' without defining an aggregate: you cannot define a range without an aggregate.");
            if (_OrderByObjs == null || _OrderByObjs.isEmpty() == true)
              PS.AddError("View Column '" + getFullName() + "' defined a window range '" + _Range + "' without defining an orderBy: you cannot define a range without an aggregate ordering.");

            validateRange(PS, getFullName(), _Range);

          }

        // Check extra rules if an aggregate has been defined, such as orderability
        if (_Aggregate != null)
          {
            if (_FCT != FrameworkColumnType.PIVOT && _Aggregate.getOrderable() == AggregateType.OrderableType.REQUIRED && _OrderByObjs.isEmpty() == true)
              PS.AddError("View Column '" + getFullName() + "' defined an aggregate '" + _Aggregate.name() + "' without defining an orderBy element: this aggregate requires an order by to be semanticaly correct.");
          }

        if (_Exclude.length > 0 || _Block.length > 0)
          if (_SameAs.endsWith("*") == true)
            PS.AddError("View Column '" + getFullName() + "' defined an 'exclude' or 'block' attribute but the column is not a .*.");

        // Parsing the extra type information if present.
        if (_TypeStr != null)
          {
            _Type = new TypeDef(_TypeStr, _Size, _Precision, _Scale);
            _Type.Validate(PS, "View Column '" + getFullName() + "'", true, false);
          }
        // Checking that type information is only present when expression is specified and vice-versa.
        if (TextUtil.isNullOrEmpty(_Expression) == false && _Type == null)
          PS.AddError("View Column '" + getFullName() + "' defined an 'expression' but neglected to specify type information and optionally, size.");
        if (TextUtil.isNullOrEmpty(_Expression) == true && _Type != null && _FCT != FrameworkColumnType.TS)
          PS.AddError("View Column '" + getFullName() + "' defined extra type/size information without an 'expression': type and size are for expressions only.");

        // if (TextUtil.isNullOrEmpty(_Mask) == false)
        // ValueHelper.CheckColumnValue(PS, this, _Name, _Mask, DefaultType.NONE);

        return Errs == PS.getErrorCount();
      }

    public static boolean validateRange(ParserSession PS, String viewColumnName, String range)
      {
        // if (range.equals("current row and 10 preceding") == true)
        // LOG.debug("xxx");
        int errCount = PS.getErrorCount();
        // Let's check that the range matches the syntax required and that the first part is technically before the second part logically speaking.
        // for example, something like "10 following and 10 preceding" is not valid.
        Matcher M = _RANGEREGEX.matcher(range);
        if (M.matches() == false)
          {
            PS.AddError("View Column '" + viewColumnName + "' defined a window range '" + range + "' which is syntactically incorrect. Allowed pattern is '(((UNBOUNDED|<number>) PRECEDING)|CURRENT ROW) AND (((UNBOUNDED|<number>) FOLLOWING)|CURRENT ROW)'.");
            return false;
          }
        // for (int i = 0; i <= M.groupCount(); ++i)
        // LOG.debug(i+": "+M.group(i));
        String quantity1 = M.group(2).toUpperCase();
        String direction1 = M.group(3).toUpperCase();
        String quantity2 = M.group(5).toUpperCase();
        String direction2 = M.group(6).toUpperCase();
        if (quantity1.equals("CURRENT") == true && direction1.equals("ROW") == false
        || quantity1.equals("CURRENT") == false && direction1.equals("ROW") == true
        || quantity2.equals("CURRENT") == true && direction2.equals("ROW") == false
        || quantity2.equals("CURRENT") == false && direction2.equals("ROW") == true)
          PS.AddError("View Column '" + viewColumnName + "' defined a window range '" + range + "' with incorrect syntax: 'CURRENT ROW' must stand together.");
        else if (quantity1.equals("CURRENT") == true && quantity2.equals("CURRENT") == true)
          PS.AddError("View Column '" + viewColumnName + "' defined a window range '" + range + "' which goes between current row and current row, which doesn't make much sense.");
        else if (direction1.equals(direction2) == true || quantity1.equals("CURRENT") == true || quantity2.equals("CURRENT") == true)
          {
            long q1 = quantity1.equals("CURRENT") == true ? 0 : ParseUtil.parseLong(quantity1, SystemValues.EVIL_VALUE);
            long q2 = quantity2.equals("CURRENT") == true ? 0 : ParseUtil.parseLong(quantity2, SystemValues.EVIL_VALUE);

            if (quantity1.equals("UNBOUNDED") == false && q1 == SystemValues.EVIL_VALUE)
              PS.AddError("View Column '" + viewColumnName + "' defined a window range '" + range + "' with a 'from' value that isn't a positive integer or UNBOUNDED.");
            if (quantity2.equals("UNBOUNDED") == false && q2 == SystemValues.EVIL_VALUE)
              PS.AddError("View Column '" + viewColumnName + "' defined a window range '" + range + "' with a 'to' value that isn't a positive integer or UNBOUNDED.");

            if (quantity1.equals("UNBOUNDED") == true)
              q1 = direction1.equals("PRECEDING") == true ? Long.MIN_VALUE : Long.MAX_VALUE;
            else if (direction1.equals("PRECEDING") == true)
              q1 = -q1;

            if (quantity2.equals("UNBOUNDED") == true)
              q2 = direction2.equals("PRECEDING") == true ? Long.MIN_VALUE : Long.MAX_VALUE;
            else if (direction2.equals("PRECEDING") == true)
              q2 = -q2;

            if (q1 >= q2)
              PS.AddError("View Column '" + viewColumnName + "' defined a window range '" + range + "' with a 'from' value '" + q1 + "' which is not smaller than the 'to' value '" + q2 + "'.");
          }
        return errCount == PS.getErrorCount();
      }


    public static Column ValidateSameAs(ParserSession PS, String ColFullName, String SameAs, View ParentView)
      {
        ReferenceHelper R = ReferenceHelper.parseColumnReference(SameAs, ParentView);
        Column Col = R.resolveAsColumn(PS, "View column '" + ColFullName + "'", "sameAs '" + SameAs + "'", false);
        if (Col == null)
          return null;

        // If the view is realized, it should not have direct dependencies on other realized views since the system can handle automatically these dependencies
        if (ParentView._Realize != null && (Col._ParentObject._TildaType == TildaType.REALIZED_VIEW || Col._ParentObject._FST == FrameworkSourcedType.REALIZED))
          {
            PS.AddError("View column '" + ColFullName + "' is declaring sameas '" + SameAs + "' resolving to a realized view '" + R.getFullObjectName() + "', which is not allowed. Refills automatically handle cases when realized views reference other realized views. If you want to break the chain, create an intermediate unrealized view.");
            return null;
          }

        return Col;
      }

    @Override
    public String toString()
      {
        return getClass().getName() + ":" + _ParentView != null ? getFullName() : _Sameas_DEPRECATED != null ? _Sameas_DEPRECATED : _SameAs;
      }

    public boolean isSameAsLitteral()
      {
        return _SameAs != null && _SameAsObj == null && _FCT.isManaged() == true;
      }

    /**
     * returns a comma-separated string containing the <B>unescaped</B> column short names
     * 
     * @param L
     * @return
     */
    public static String PrintColumnList(List<ViewColumn> L)
      {
        StringBuilder Str = new StringBuilder();
        for (ViewColumn VC : L)
          Str.append(Str.length() == 0 ? "" : ", ").append(VC.getShortName());
        return Str.toString();
      }

    /**
     * A view column of type 'DATETIME' needs an extra timezone support field if the underlying column needs one, and the
     * view column is not an aggregate, and does not have an expression unless it's of type datetime, and is a
     * non-framework-generated column.
     * 
     * @return
     */
    public boolean needsTZ()
      {
        return (_SameAsObj == null || _SameAsObj.needsTZ() == true)
        && (_Aggregate == null || _Aggregate.isZonedDateTimeCompatible() == true)
        && (TextUtil.isNullOrEmpty(_Expression) == true || (_Type != null ? _Type._Type : _SameAsObj._Type) == ColumnType.DATETIME)
        && (_FCT == FrameworkColumnType.NONE || _FCT == FrameworkColumnType.PIVOT);
      }

    public boolean isList()
      {
        return _SameAsObj != null && _SameAsObj.isList() == true || _Aggregate != null && _Aggregate.isList() == true;
      }

    public boolean isSet()
      {
        return _SameAsObj != null && _SameAsObj.isSet() == true && _Aggregate == null;
      }

    public boolean isCollection()
      {
        return _SameAsObj != null && _SameAsObj.isCollection() == true || _Aggregate != null && _Aggregate.isList() == true;
      }

  }
