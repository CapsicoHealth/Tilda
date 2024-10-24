/* ===========================================================================
 * Copyright (C) 2017 CapsicoHealth Inc.
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

import tilda.enums.FrameworkColumnType;
import tilda.parsing.ParserSession;

public class ViewDistinctOn
  {
    static final Logger               LOG          = LogManager.getLogger(ViewDistinctOn.class.getName());

    /*@formatter:off*/
    @SerializedName("columns" ) public String[]       _Columns;
    @SerializedName("orderBy" ) public String[]       _OrderBy;
    /*@formatter:on*/

    public transient List<ViewColumn> _ColumnObjs  = new ArrayList<ViewColumn>();
    public transient List<OrderBy>    _OrderByObjs = new ArrayList<OrderBy>();


    public ViewDistinctOn()
      {
      }

    public transient View _ParentView;

    public boolean validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        if (_Columns == null || _Columns.length == 0)
          return PS.AddError("View '" + _ParentView.getFullName() + "' is defining distinctOn without columns.");

        _ColumnObjs = ParseColumns(PS, _ParentView, _Columns);

        int offset = 0;
        for (int i = 0; i < _ColumnObjs.size(); ++i)
          {
            if (ParentView._ViewColumns.get(i)._FCT == FrameworkColumnType.TZ == true)
              ++offset;
            if (_ColumnObjs.get(i)._Name.equalsIgnoreCase(ParentView._ViewColumns.get(i + offset)._Name) == false)
              return PS.AddError("View '" + _ParentView.getFullName() + "' is defining distinctOn with columns not matching the initial columns of the view: expecting '" + ParentView._ViewColumns.get(i + offset)._Name + "' in position " + i + " but got '" + _ColumnObjs.get(i)._Name + "' instead.");
          }

        if (_OrderBy != null && _OrderBy.length > 0)
          {
            _OrderByObjs = OrderBy.processOrderBys(PS, "Object '" + _ParentView.getFullName() + "' defines distinctOn", _ParentView, _OrderBy, true);
          }
        return Errs == PS.getErrorCount();
      }

    public static List<ViewColumn> ParseColumns(ParserSession PS, View ParentView, String[] Columns)
      {
        List<ViewColumn> L = new ArrayList<ViewColumn>();
        for (String s : Columns)
          {
            ViewColumn VC = ParentView.getViewColumn(s);
            if (VC == null)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining distinctOn with column '" + s + "' which cannot be found.");
            else
              L.add(VC);
          }
        return L;
      }


  }
