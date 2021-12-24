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

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.PivotHelper;
import tilda.utils.TextUtil;

public class ViewPivotValue extends Value
  {
    static final Logger LOG = LogManager.getLogger(ViewPivotValue.class.getName());

    /*@formatter:off*/
    @SerializedName("expression") public String  _Expression;
    @SerializedName("type"      ) public String  _TypeStr   ;
    @SerializedName("size"      ) public Integer _Size      ;
    @SerializedName("scale"     ) public Integer _Scale     ;
    @SerializedName("precision" ) public Integer _Precision ;
    /*@formatter:on*/

    public transient TypeDef _Type;

    public ViewPivotValue()
      {
      }
    
    public boolean Validate(ParserSession PS, View ParentView, ViewPivot pivots, List<ViewPivotAggregate> aggregates)
      {
        int Errs = PS.getErrorCount();
        
        String what = "pivot value '"+_Value+"'";
        super.Validate(PS, ParentView, what);
        
        if (_TypeStr != null)
          {
            _Type = new TypeDef(_TypeStr, _Size, _Scale, _Precision);
            _Type.Validate(PS, what, true, false);
          }

        if (TextUtil.isNullOrEmpty(_Expression) == true)
          {
            if (_Type != null)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining a "+what+" with a type without an 'expression': type is for expressions only.");
            if (_Size != null)
             PS.AddError("View '" + ParentView.getFullName() + "' is defining a "+what+" with a size without an 'expression': size is for expressions only.");
            if (_Scale != null)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining a "+what+" with a scale without an 'expression': scale is for expressions only.");
            if (_Precision != null)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining a "+what+" with a precision without an 'expression': precision is for expressions only.");
          }
        else 
          {
            if (_Type == null)
             PS.AddError("View '" + ParentView.getFullName() + "' is defining a "+what+" with an expression but doesn't specify a type: type is required for expressions.");
            if (aggregates.size() != 1)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining a "+what+" with an expression but the pivot is over multiple aggregates: this is not allowed.");
            else 
              {
                ViewPivotAggregate vpa = aggregates.get(0);
                if (TextUtil.isNullOrEmpty(vpa._Coalesce) == false)
                  {
                    String ValueTypeStr = PivotHelper.getPivotedViewColumnTypeStr(vpa._VC, vpa, this);
                    String AggregateTypeStr = PivotHelper.getPivotedViewColumnTypeStr(vpa._VC, vpa, null);
                    if (AggregateTypeStr == null)
                      AggregateTypeStr = vpa.getTypeStr();
                    if (ValueTypeStr != null && AggregateTypeStr != null && ValueTypeStr.equalsIgnoreCase(AggregateTypeStr) == false)
                      PS.AddError("View '" + ParentView.getFullName() + "' is defining a "+what+" with an expression of type '"+ValueTypeStr+"' but a coalesce is defined at the aggregate level of type "+AggregateTypeStr+". The two must match.");
                  }
              }
          }
                
        return Errs == PS.getErrorCount();
      }

  }
