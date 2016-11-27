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
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

public class ViewPivotColumn
  {
    static final Logger         LOG   = LogManager.getLogger(ViewPivotColumn.class.getName());

    /*@formatter:off*/
	@SerializedName("source"   ) public String  _SourceStr;
    @SerializedName("prefix"   ) public String  _Prefix;
    @SerializedName("join"     ) public List<ViewJoinSimple> _Join = new ArrayList<ViewJoinSimple>();
    /*@formatter:on*/

    public ViewPivotColumn()
      {
      }

    public transient View _ParentView;
    public transient View _Source;



    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        // Mandatories
        if (TextUtil.isNullOrEmpty(_SourceStr) == true)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot column without any 'source' pivot view specified.");

        if (_Join.isEmpty() == true)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot column without any 'join' information.");

        ReferenceHelper R = ReferenceHelper.parseObjectReference(_SourceStr, _ParentView._ParentSchema);
        if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot column with a source '" + _SourceStr + "' with an incorrect syntax. It should be '((package\\.)?schema\\.)?object'.");
        else
          {
            _Source = PS.getView(R._P, R._S, R._O);
            if (_Source == null)
              return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot column with a source '" + _SourceStr + "' resolving to '" + R.getFullName() + "' which cannot be found.");
            if (_Source._Pivot == null)
              return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot column with a source '" + _SourceStr + "' which is not a pivot view.");
            if (_Source._Validated == false)
              return PS.AddError("View '" + ParentView.getFullName() + "' is defining a pivot column with a source '" + _SourceStr + "' which has failed validation.");
          }
        
        
        for (ViewJoinSimple J : _Join)
          {
            J.Validate(PS, _ParentView, _Source);
          }

        return Errs == PS.getErrorCount();
      }

  }
