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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class ViewPivot
  {
    static final Logger LOG             = LogManager.getLogger(ViewPivot.class.getName());

    /*@formatter:off*/
	@SerializedName("on"        ) public String                    _ColumnName;
    @SerializedName("aggregates") public List<ViewPivotAggregate>  _Aggregates=new ArrayList<ViewPivotAggregate>();
    @SerializedName("values"    ) public ViewPivotValue[]          _Values    ;
    /*@formatter:on*/


    public ViewPivot()
      {
      }

    public transient View       _ParentView;
    public transient ViewColumn _VC;
    public transient boolean    _FailedValidation = false;


    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_ColumnName) == true)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot without any 'on' column specified.");

        if (_Values == null || _Values.length == 0)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot without any 'values' specified.");

        for (Value VPV : _Values)
          VPV.Validate(PS, ParentView, "pivot value");

        _VC = new ViewColumn();
        _VC._SameAs = _ColumnName;
        _VC.Validate(PS, _ParentView);

        
        Set<String> AggregateNames = new HashSet<String>();        
        for (ViewPivotAggregate A : _Aggregates)
          {
            if (A == null)
             continue;
             if (A.Validate(PS, this) == false)
              continue;
            ViewColumn VC = ParentView.getViewColumn(A._Name);
            if (VC == null)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot on " + _ColumnName + " for an aggregate " + A._Name + " which cannot be found in the view.");
            else if (VC._Aggregate == null)
              return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot on " + _ColumnName + " for " + A._Name + " which is not an aggregate.");

            if (AggregateNames.add(A._Name) == false)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining a Pivot on column " + _VC.getShortName() + " with a duplicate aggregate name '"+A._Name+"'.");
          }
        if (AggregateNames.isEmpty() == true)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining a Pivot on column " + _VC.getShortName() + " without specifying any aggregate targets.");

        return Errs == PS.getErrorCount();
      }

    public boolean hasValue(String searchValue)
      {
        for (Value value : _Values)
          {
            if (value._Name.equals(searchValue))
              return true;
          }
        return false;
      }
  }
