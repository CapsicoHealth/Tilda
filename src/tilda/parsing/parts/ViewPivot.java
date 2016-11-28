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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.DBType;
import tilda.enums.AggregateType;
import tilda.enums.JoinType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class ViewPivot
  {
    static final Logger             LOG                = LogManager.getLogger(ViewPivot.class.getName());

    /*@formatter:off*/
	@SerializedName("on"       ) public String           _ColumnName;
    @SerializedName("values"   ) public ViewPivotValue[] _Values    ;
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
        
        for (ViewPivotValue VPV : _Values)
         VPV.Validate(PS, ParentView);

        _VC = _ParentView.getViewColumn(_ColumnName);
        if (_VC == null)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot with an unknown 'on' colunn '"+_ColumnName+"'.");
        
        if (_ParentView._ViewColumns.get(_ParentView._ViewColumns.size()-2) != _VC)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot with an unknown 'on' colunn '"+_ColumnName+"' which is not the las column specified in the column list.");

        if (TextUtil.isNullOrEmpty(_ParentView._CountStar) == true)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot without having defined a 'countStar' column.");
          
        ViewColumn CountCol = _ParentView._ViewColumns.get(_ParentView._ViewColumns.size()-1);
        if (CountCol._Aggregate != AggregateType.COUNT)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot but the 'countStar' column did not validate properl.");
        
        return Errs == PS.getErrorCount();
      }

  }