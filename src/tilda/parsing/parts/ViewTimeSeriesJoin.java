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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.DBType;
import tilda.enums.JoinType;
import tilda.enums.ValidationStatus;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class ViewTimeSeriesJoin
  {
    static final Logger LOG = LogManager.getLogger(ViewTimeSeriesJoin.class.getName());

    /*@formatter:off*/
	@SerializedName("object") public String    _Object ;
    @SerializedName("range" ) public String[]  _Range  ;
    /*@formatter:on*/


    public ViewTimeSeriesJoin()
      {
      }

    public transient View     _ParentView;
    public transient Object   _ObjectObj;
    public transient Column[] _RangeCols = new Column[2];
    public transient boolean  _FailedValidation = false;


    public boolean Validate(ParserSession PS, View ParentView)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        if (_Object.equalsIgnoreCase("patients.score") == true)
          {
            LOG.debug("xxx");
          }

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Object) == true)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a join without any 'object' specified.");

        if (_Range == null || _Range.length == 0)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a Time Series without any 'range' specified.");

        if (_Range.length > 2)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a Time Series with a 'range' contanng more than 2 columns. A start and optional end are required.");

        ReferenceHelper R = ReferenceHelper.parseObjectReference(_Object, ParentView._ParentSchema);
        if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
          PS.AddError("View '" + ParentView.getFullName() + "' declares a Time Series object '" + _Object + "' with an incorrect syntax. It should be '((package\\.)?schema\\.)?object'.");
        else
          {
            _ObjectObj = PS.getObject(R._P, R._S, R._O);
            if (_ObjectObj == null)
              return PS.AddError("View '" + ParentView.getFullName() + "' declares Time Series object '" + _Object + "' resolving to '" + R.getFullName() + "' which cannot be found.");
            if (_ObjectObj._Validated == false)
              return PS.AddError("View '" + ParentView.getFullName() + "' declares Time Series object '" + _Object + "' which has failed validation.");
          }

        for (int i = 0; i < _Range.length; ++i)
          {
            R = ReferenceHelper.parseColumnReference(_Range[i], _ObjectObj);
            if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
              PS.AddError("View '" + ParentView.getFullName() + "' declares a Time Series range column '" + _Range[i] + "' with an incorrect syntax. It should be '(((package\\.)?schema\\.)?object.)?column'.");
            
            Column C = PS.getColumn(R._P, R._S, R._O, R._C);
            if (C == null)
              return PS.AddError("View '" + ParentView.getFullName() + "' declares Time Series range column '" + _Range[i] + "' resolving to '" + R.getFullName() + "' which cannot be found.");
            if (C.hasBeenValidatedSuccessfully() == false)
              return PS.AddError("View '" + ParentView.getFullName() + "' declares Time Series range column '" + _Range[i] + "' which has failed validation.");
            _RangeCols[i] = C;
          }

        return Errs == PS.getErrorCount();
      }

  }
