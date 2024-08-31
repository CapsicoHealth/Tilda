/* ===========================================================================
 b * Copyright (C) 2016 CapsicoHealth Inc.
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
    static final Logger             LOG         = LogManager.getLogger(ViewPivot.class.getName());

    /*@formatter:off*/
	@SerializedName("on"        ) public String                    _ColumnName;
    @SerializedName("aggregates") public List<ViewPivotAggregate>  _Aggregates=new ArrayList<ViewPivotAggregate>();
    @SerializedName("interleave") public boolean                   _Interleave = false;
    @SerializedName("globals"   ) public boolean                   _Globals = true;
    @SerializedName("values"    ) public ViewPivotValue[]          _Values    ;
    /*@formatter:on*/


    public ViewPivot()
      {
      }

    public transient View       _ParentView;
    public transient ViewColumn _VC;
    public transient boolean    _FailedValidation = false;


    public boolean validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_ColumnName) == true)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot without any 'on' column specified.");

        if (_Values == null || _Values.length == 0)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot without any 'values' specified.");

        _VC = new ViewColumn();
        _VC._FormulaOnly = true; // the folded pivot columns shouldn't not be output in the final result.
        _VC._SameAs = _ColumnName;
        _VC.validate(PS, _ParentView);

        Set<String> AggregateNames = new HashSet<String>();
        for (int i = 0; i < _Aggregates.size(); ++i)
          {
            ViewPivotAggregate A = _Aggregates.get(i);
            if (A == null)
              continue;
            if (A.validate(PS, this) == false)
              continue;
            if (AggregateNames.add(A.getCompositeName()) == false)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining a Pivot on column " + _VC.getShortName() + " with a duplicate aggregate named '" + A.getCompositeName() + "'.");
            // LDH-NOTE: The logic to handle fields that need TZ is automated in the general process, so no need to do it here.
          }
        if (AggregateNames.isEmpty() == true)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining a Pivot on column " + _VC.getShortName() + " without specifying any aggregate targets.");

        for (ViewPivotValue VPV : _Values)
          if (VPV != null)
            VPV.validate(PS, ParentView, this, _Aggregates);

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
