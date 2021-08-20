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

public class ViewRealizeIncremental
  {
    static final Logger LOG            = LogManager.getLogger(ViewRealizeIncremental.class.getName());

    /*@formatter:off*/
    @SerializedName("deleteFirst") public Boolean _deleteFirst  = null;
    @SerializedName("whereClause") public String  _whereClause  = null;
    /*@formatter:on*/


    public ViewRealizeIncremental()
      {
      }

    public transient View             _ParentView;
    public transient Base             _ParentRealized;
//    public transient ViewColumn       _LastUpdatedTSColumnObj;
//    public transient ViewColumn       _DeleteTSColumnObj;
    public transient List<ViewColumn> _IdentityViewColumns;
    public transient boolean          _FailedValidation = false;
    public transient SubWhereClause   _SubQuery;

    public boolean Validate(ParserSession PS, View ParentView, Base ParentRealized, List<Column> FirstIdentity)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;
        _ParentRealized = ParentRealized;

        // Gotta define an upsert timestamp
        if (TextUtil.isNullOrEmpty(_whereClause) == true)
          PS.AddError("View '" + _ParentView.getFullName() + "' is defining an incremental realization with no 'whereClause' value.");

        // The realized table must have an identity
        if (FirstIdentity == null || FirstIdentity.isEmpty() == true)
          PS.AddError("View '" + _ParentView.getFullName() + "' is defining an incremental realization but the realized table did not define any identity.");
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
        
        _SubQuery = new SubWhereClause(_whereClause);
        _SubQuery.Validate(PS, ParentView, "Realized View", false);
        
        return Errs == PS.getErrorCount();
      }

  }
