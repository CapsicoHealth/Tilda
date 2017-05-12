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

import java.time.ZonedDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.TimeSeriesType;
import tilda.parsing.ParserSession;
import tilda.utils.DateTimeUtil;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class ViewTimeSeries
  {
    static final Logger       LOG       = LogManager.getLogger(ViewTimeSeries.class.getName());

    /*@formatter:off*/
	@SerializedName("name"      ) public String             _Name    ;
    @SerializedName("type"      ) public TimeSeriesType     _Type    ;
    @SerializedName("lookback"  ) public int                _Lookback = SystemValues.EVIL_VALUE;
    @SerializedName("between"   ) public String[]           _Between;
    @SerializedName("join"      ) public ViewTimeSeriesJoin _Join;
    /*@formatter:on*/


    public ViewTimeSeries()
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
        if (TextUtil.isNullOrEmpty(_Name) == true)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series without any name.");

        if (_Type == null)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series without any type.");

        if (_Lookback < 1 && _Between == null)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series without a valid lookback or a between: one or the other is required.");

        if (_Lookback >= 1 && _Between != null)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series with both a lookback and a between: one or the other is required.");

        if (_Between != null)
          {
            if (_Between.length != 2)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series with a between that doesn't have exactly 2 values.");
            else
              {
                if (_Between[0] != null)
                  {
                    ZonedDateTime Start = DateTimeUtil.parseWithoutZone(_Between[0]);
                    if (Start == null)
                      PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series with a between's start date '" + _Between[0] + "' that cannot be parsed as 'YYYY-mm-dd'.");
                    else if (DateTimeUtil.validateBoundary(_Type, true, Start) == false)
                      PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series with a between's start date '" + _Between[0] + "' that is not a valid 1st day boundary for a " + _Type + " type.");
                  }

                if (_Between[1] != null)
                  {
                    ZonedDateTime End = DateTimeUtil.parseWithoutZone(_Between[1]);
                    if (End == null)
                      PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series with a between's end date '" + _Between[1] + "' that cannot be parsed as 'YYYY-mm-dd'.");
                    else if (DateTimeUtil.validateBoundary(_Type, false, End) == false)
                      PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series with a between's end date '" + _Between[1] + "' that is not a valid last-day boundary for a " + _Type + " type.");
                  }
              }
          }

        if (_Join == null)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series without specifying a join.");
        else
          _Join.Validate(PS, ParentView);

        return Errs == PS.getErrorCount();
      }
  }
