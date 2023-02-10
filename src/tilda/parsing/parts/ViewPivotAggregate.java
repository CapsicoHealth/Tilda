/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
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

import com.google.gson.annotations.SerializedName;

import tilda.enums.AggregateType;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class ViewPivotAggregate
  {
    static final Logger            LOG            = LogManager.getLogger(ViewPivotAggregate.class.getName());

    /*@formatter:off*/
	@SerializedName("name"  )    public String   _Name;
    @SerializedName("prefix")    public String   _Prefix;
    @SerializedName("suffix")    public String   _Suffix;
    @SerializedName("aggregate") public String   _AggregateStr ;
    @SerializedName("orderBy"  ) public String[] _OrderByStr;
    @SerializedName("distinct" ) public Boolean  _Distinct = false;
    @SerializedName("coalesce" ) public String   _Coalesce     = null;
    /*@formatter:on*/

    public transient ViewPivot     _ParentPivot;
    // aggregate column from parent view.
    public transient ViewColumn    _VC;
    public transient String        _CompositeName = null;
    public transient AggregateType _Aggregate;
    public transient String        _AggregateAttributes;
    public transient List<OrderBy> _OrderByObjs   = new ArrayList<OrderBy>();

    public ViewPivotAggregate()
      {
      }

    public ViewPivotAggregate(ViewPivotAggregate from)
      {
        _Name = from._Name;
        _Prefix = from._Prefix;
        _Suffix = from._Suffix;
        _AggregateStr = from._AggregateStr;
        _OrderByStr = from._OrderByStr;
        _Distinct = from._Distinct;
        _Coalesce = from._Coalesce;
      }

    public boolean Validate(ParserSession PS, ViewPivot ParentPivot)
      {
        int Errs = PS.getErrorCount();
        _ParentPivot = ParentPivot;

        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("View '" + ParentPivot._ParentView.getFullName() + "' is defining a pivot on '" + _ParentPivot._ColumnName + "' with an aggregate without any 'name' column specified.");

        _VC = ParentPivot._ParentView.getViewColumn(_Name);
        if (_VC == null)
          return PS.AddError("View '" + ParentPivot._ParentView.getFullName() + "' is defining a pivot on " + ParentPivot._ColumnName + " for an aggregate " + _Name + " which cannot be found in the view.");

        // Hide pivoted columns from being folded in final query.
        _VC._FormulaOnly = true;
        if (_VC.needsTZ() == true)
          {
            ViewColumn TZ = ParentPivot._ParentView.getViewColumn(_Name + "TZ");
            if (TZ != null)
              TZ._FormulaOnly = true;
          }

        if (_AggregateStr != null)
          {
            if ((_Aggregate = AggregateType.parse(_AggregateStr)) == null)
              return PS.AddError("View '" + ParentPivot._ParentView.getFullName() + "' is defining a pivot on " + ParentPivot._ColumnName + " for an aggregate " + _Name + " using '" + _AggregateStr + "' which is not a valid aggregate or syntax: aggregates should be of the form \"ARRAY\" or \"STRING(',')\".");

            if ((_AggregateAttributes = AggregateType.parseAttributes(_AggregateStr)) == null)
              return PS.AddError("View '" + ParentPivot._ParentView.getFullName() + "' is defining a pivot on " + ParentPivot._ColumnName + " for a wrong aggregate '" + _AggregateStr + "' or syntax: aggregates should be of the form \"ARRAY\" or \"STRING(',')\".");

            if (_AggregateAttributes.isEmpty() == true)
              {
                if (_Aggregate.getParameterSetting() == AggregateType.ParameterSetting.REQUIRED)
                  return PS.AddError("View '" + ParentPivot._ParentView.getFullName() + "' is defining a pivot on " + ParentPivot._ColumnName + " for an 'aggregate' '" + _AggregateStr + "' without parameters: this aggregate requires parameters.");
                _AggregateAttributes = null;
              }
            else if (_Aggregate.areParametersAllowed() == false)
              return PS.AddError("View '" + ParentPivot._ParentView.getFullName() + "' is defining a pivot on " + ParentPivot._ColumnName + " for an 'aggregate' '" + _AggregateStr + "' with some parameters: this aggregate does not support parameters.");

            if (_VC._SameAsObj != null)
              {
                String Str = _Aggregate.isCompatible(_VC);
                if (Str != null)
                  PS.AddError(Str.toString());
              }
          }

        if (_VC._Aggregate == null && _Aggregate == null)
          return PS.AddError("View '" + ParentPivot._ParentView.getFullName() + "' is defining a pivot on " + ParentPivot._ColumnName + " for " + _Name + " which is not an aggregate, nor does it define a local aggregate.");

        if (_Aggregate == null)
          _Aggregate = _VC._Aggregate;

        if (_Distinct == null)
          _Distinct = _VC._Distinct;

        if (_Coalesce == null)
          _Coalesce = _VC._Coalesce;

        _OrderByObjs = OrderBy.processOrderBys(PS, "View Column '" + _VC.getFullName() + "' aggregate orderby's", ParentPivot._ParentView, _OrderByStr, true);

        if (_OrderByObjs == null || _OrderByObjs.isEmpty() == true)
          _OrderByObjs = _VC._OrderByObjs;

        return Errs == PS.getErrorCount();
      }

    public String getCompositeName()
      {
        if (_CompositeName == null)
          {
            StringBuilder Str = new StringBuilder();
            if (TextUtil.isNullOrEmpty(_Prefix) == false)
              Str.append(_Prefix);
            Str.append(_Name);
            if (TextUtil.isNullOrEmpty(_Suffix) == false)
              Str.append(_Suffix);
            _CompositeName = Str.toString();
          }
        return _CompositeName;
      }


    public String makeName(Value V)
      {
        StringBuilder Str = new StringBuilder();
        if (TextUtil.isNullOrEmpty(_Prefix) == false)
          Str.append(_Prefix);
        Str.append(TextUtil.capitalizeFirstCharacter(TextUtil.print(V._Name, V._Value)));
        if (TextUtil.isNullOrEmpty(_Suffix) == false)
          Str.append(_Suffix);
        return Str.toString();
      }

    public String getTypeStr()
      {
        return _VC.getType().name() + (_Aggregate != null && _Aggregate.isList() == true ? "[]" : "");
      }

  }
