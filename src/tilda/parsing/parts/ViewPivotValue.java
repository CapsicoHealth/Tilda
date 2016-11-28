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

public class ViewPivotValue
  {
    static final Logger             LOG                = LogManager.getLogger(ViewPivotValue.class.getName());

    /*@formatter:off*/
	@SerializedName("value"      ) public String _Value;
    @SerializedName("description") public String _Description;
    /*@formatter:on*/
	
    
    public ViewPivotValue()
     {
     }

    public transient View       _ParentView;
    
    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Value) == true)
         PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot value with a null or empty value.");

        if (TextUtil.isNullOrEmpty(_Value) == true)
         PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot value with a null or empty description.");
        
        return Errs == PS.getErrorCount();
      }

  }
