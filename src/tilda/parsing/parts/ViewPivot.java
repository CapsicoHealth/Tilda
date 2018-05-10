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

import java.util.Arrays;
import java.util.Comparator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

public class ViewPivot
  {
    static final Logger             LOG                = LogManager.getLogger(ViewPivot.class.getName());

    /*@formatter:off*/
	@SerializedName("on"       ) public String  _ColumnName;
    @SerializedName("for"      ) public String  _AggregateNames;
    @SerializedName("values"   ) public Value[] _Values    ;
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

        ReferenceHelper R = ReferenceHelper.parseObjectReference(_ColumnName, ParentView._ParentSchema);
        if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot column " + _ColumnName + " with an incorrect syntax. It should be '((package\\.)?schema\\.)?object\\.\\*'.");
        
        _VC = _ParentView.getViewColumn(_ColumnName);
        if (_VC == null)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot with an unknown 'on' colunn '"+_ColumnName+"'.");
        
        if (_ParentView._ViewColumns.get(_ParentView._ViewColumns.size()-2) != _VC)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot with an unknown 'on' colunn '"+_ColumnName+"' which is not the last column specified in the column list.");

//        if (TextUtil.isNullOrEmpty(_ParentView._CountStar) == true)
//          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot without having defined a 'countStar' column.");
          
//        ViewColumn CountCol = _ParentView._ViewColumns.get(_ParentView._ViewColumns.size()-1);
//        if (CountCol._Aggregate != AggregateType.COUNT)
//          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot but the 'countStar' column did not validate properly.");
        
        // Need Pivot values to be sorted because of how Pivot tables are constructed.
        Arrays.sort(_Values, new Comparator<Value>()
          {
            @Override
            public int compare(Value arg0, Value arg1)
              {
                return arg0._Value.compareTo(arg1._Value);
              }
          });
        
        return Errs == PS.getErrorCount();
      }
    
    public boolean hasValue(String searchValue) {
    	for(Value value : _Values) {
    		if(value._Name.equals(searchValue))
    			return true;
    	}
    	return false;
    }

  }
