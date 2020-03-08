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

import tilda.enums.ColumnType;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class ViewRealizeUpsert
  {
    static final Logger LOG            = LogManager.getLogger(ViewRealizeUpsert.class.getName());

    /*@formatter:off*/
    @SerializedName("lastUpdatedTS") public String _LastUpdatedTS  = null;
    @SerializedName("deleteTS")      public String _DeleteTS       = null;
    /*@formatter:on*/


    public ViewRealizeUpsert()
      {
      }

    public transient View             _ParentView;
    public transient Base             _ParentRealized;
    public transient ViewColumn       _UpsertTSColumnObj;
    public transient ViewColumn       _DeleteTSColumnObj;
    public transient List<ViewColumn> _IdentityViewColumns;
    public transient boolean          _FailedValidation = false;


    public boolean Validate(ParserSession PS, View ParentView, Base ParentRealized, List<Column> FirstIdentity)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;
        _ParentRealized = ParentRealized;

        // Gotta define an upsert timestamp
        if (TextUtil.isNullOrEmpty(_LastUpdatedTS) == true)
          PS.AddError("View '" + _ParentView.getFullName() + "' is defining an upserted realization with no 'upsertTS' value.");

        // Gotta define a delete timestamp
        if (TextUtil.isNullOrEmpty(_DeleteTS) == true)
          PS.AddError("View '" + _ParentView.getFullName() + "' is defining an upserted realization with no 'deleteTS' value.");

        // Upsert timestamp must be a valid column and a date or timestamp
        _UpsertTSColumnObj = _ParentView.getViewColumn(_LastUpdatedTS);
        if (_UpsertTSColumnObj == null)
          PS.AddError("View '" + _ParentView.getFullName() + "' is defining an upserted realization with an upsert timestamp column '" + _LastUpdatedTS + "' which cannot be found.");
        else if (_UpsertTSColumnObj._SameAsObj.getType() != ColumnType.DATE && _UpsertTSColumnObj._SameAsObj.getType() != ColumnType.DATETIME)
          PS.AddError("View '" + _ParentView.getFullName() + "' is defining an upserted realization with an upsert timestamp column '" + _LastUpdatedTS + "' which is not a date or timestamp.");

        // Delete timestamp must be a valid column and a date or timestamp
        _DeleteTSColumnObj = _ParentView.getViewColumn(_DeleteTS);
        if (_DeleteTSColumnObj == null)
          PS.AddError("View '" + _ParentView.getFullName() + "' is defining an upserted realization with a delete timestamp column '" + _DeleteTS + "' which cannot be found.");
        else if (_DeleteTSColumnObj._SameAsObj.getType() != ColumnType.DATE && _DeleteTSColumnObj._SameAsObj.getType() != ColumnType.DATETIME)
          PS.AddError("View '" + _ParentView.getFullName() + "' is defining an upserted realization with an upsert timestamp column '" + _DeleteTS + "' which is not a date or timestamp.");

        // The realized table must have an identity
        if (FirstIdentity == null || FirstIdentity.isEmpty() == true)
          PS.AddError("View '" + _ParentView.getFullName() + "' is defining an upserted realization but the realized table did not define any identity.");
        else // The realized table must have an identity whose columns are all matched from the parent view
          {
            _IdentityViewColumns = new ArrayList<ViewColumn>();
            for (Column C : FirstIdentity)
              {
                ViewColumn VC = ParentView.getViewColumn(C._Name);
                if (VC == null)
                  PS.AddError("View '" + _ParentView.getFullName() + "' is defining an upserted realization with a realized table whose identity column '" + C._Name + "' cannot be found in the parent view.");
                else
                  _IdentityViewColumns.add(VC);
              }
          }

        return Errs == PS.getErrorCount();
      }

  }
