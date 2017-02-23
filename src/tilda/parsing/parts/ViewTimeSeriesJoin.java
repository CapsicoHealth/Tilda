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

import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ReferenceHelper;
import tilda.utils.TextUtil;

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

    public transient View         _ParentView;
    public transient Object       _ObjectObj;
    public transient List<Column> _RangeColStart    = new ArrayList<Column>();
    public transient List<Column> _RangeColEnd      = new ArrayList<Column>();
    public transient boolean      _FailedValidation = false;


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
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a Time Series with a 'range' containing more than 2 sets of columns. A start and optional end are required.");

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

        _RangeColStart = ParseColumns(PS, _Range[0]);
        if (_Range.length == 2)
          _RangeColEnd = ParseColumns(PS, _Range[1]);

        return Errs == PS.getErrorCount();
      }


    private List<Column> ParseColumns(ParserSession PS, String Str)
      {
        String[] parts = Str.split("\\s*,\\s*");
        List<Column> L = new ArrayList<Column>();
        for (int i = 0; i < parts.length; ++i)
          {
            ReferenceHelper R = ReferenceHelper.parseColumnReference(parts[i], _ObjectObj);
            if (TextUtil.isNullOrEmpty(R._S) == true || TextUtil.isNullOrEmpty(R._O) == true)
              PS.AddError("View '" + _ParentView.getFullName() + "' declares a Time Series range column '" + parts[i] + "' with an incorrect syntax. It should be '(((package\\.)?schema\\.)?object.)?column'.");
            Column C = PS.getColumn(R._P, R._S, R._O, R._C);
            if (C == null)
              {
                PS.AddError("View '" + _ParentView.getFullName() + "' declares Time Series range column '" + parts[i] + "' resolving to '" + R.getFullName() + "' which cannot be found.");
                return null;
              }
            if (C.hasBeenValidatedSuccessfully() == false)
              {
                PS.AddError("View '" + _ParentView.getFullName() + "' declares Time Series range column '" + parts[i] + "' which has failed validation.");
                return null;
              }
            L.add(C);
          }
        return L;
      }

  }
