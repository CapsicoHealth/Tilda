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
import tilda.utils.TextUtil;

public class ViewJoinSimple
  {
    static final Logger               LOG      = LogManager.getLogger(ViewJoinSimple.class.getName());

    /*@formatter:off*/
	@SerializedName("from") public String[]  _From;
    @SerializedName("to"  ) public String[]  _To  ;
    /*@formatter:on*/

    public transient View             _ParentView;
    public transient List<ViewColumn> _FromCol = new ArrayList<ViewColumn>();
    public transient List<ViewColumn> _ToCol   = new ArrayList<ViewColumn>();

    public ViewJoinSimple()
      {
      }

    public boolean validate(ParserSession PS, View ParentView, View Source)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        if (TextUtil.isNullOrEmpty(_From) == true)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining pivot columns from " + Source.getFullName() + " with a join expression with an empty 'from'.");
        else
          {
            for (String str : _From)
              {
                ViewColumn VC = Source.getViewColumn(str);
                if (VC == null)
                  {
                    PS.AddError("View '" + ParentView.getFullName() + "' is defining pivot columns from " + Source.getFullName() + " with a join 'from' of '" + str + "' which cannot be resolved.");
                    PrintKnownColumns(Source);
                  }
                else
                  {
                    _FromCol.add(VC);
                  }
              }
          }

        if (TextUtil.isNullOrEmpty(_To) == true)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining pivot columns from " + Source.getFullName() + " with a join expression with an empty 'to'.");
        else
          {
            for (String str : _To)
              {
                ViewColumn VC = ParentView.getViewColumn(str);
                if (VC == null)
                  {
                    PS.AddError("View '" + ParentView.getFullName() + "' is defining pivot columns from " + Source.getFullName() + " with a join 'to' of '" + str + "' which cannot be resolved.");
                    PrintKnownColumns(_ParentView);
                  }
                else
                  {
                    _ToCol.add(VC);
                  }
              }
          }

        return Errs == PS.getErrorCount();
      }

    private static void PrintKnownColumns(View Source)
      {
        LOG.debug("Known columns from view " + Source.getFullName() + ":");
        for (ViewColumn c : Source._ViewColumns)
          LOG.debug("   - " + c._Name + " (from " + c._SameAsObj.getShortName() + ")");
      }
  }
