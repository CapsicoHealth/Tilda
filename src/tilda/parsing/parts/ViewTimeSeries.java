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

import com.google.gson.annotations.SerializedName;

import tilda.enums.TimeSeriesType;
import tilda.parsing.ParserSession;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class ViewTimeSeries
  {
    static final Logger             LOG       = LogManager.getLogger(ViewTimeSeries.class.getName());

    /*@formatter:off*/
	@SerializedName("name"      ) public String             _Name    ;
    @SerializedName("type"      ) public TimeSeriesType     _Type    ;
    @SerializedName("lookback"  ) public int                _Lookback = SystemValues.EVIL_VALUE;
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
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series without any name.");

        if (_Type == null)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series without any type.");

        if (_Lookback < 1)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series without a valid lookback: it is required and must be > 0.");

        if (_Join == null)
          return PS.AddError("View '" + ParentView.getFullName() + "' is defining a time Series without specifying a join.");

        _Join.Validate(PS, ParentView);

        return Errs == PS.getErrorCount();
      }

  }
