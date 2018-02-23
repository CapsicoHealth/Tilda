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

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;

public class ViewRealizeUpsert
  {
    static final Logger             LOG       = LogManager.getLogger(ViewRealizeUpsert.class.getName());

    /*@formatter:off*/
    @SerializedName("columns"   ) public String[]  _Columns    = new String[] { };
    @SerializedName("timestamps") public String[]  _Timestamps = new String[] { };
    /*@formatter:on*/


    public ViewRealizeUpsert()
      {
      }

    public transient View             _ParentView;
    public transient Base             _ParentRealized;
    public transient List<ViewColumn> _ViewColumns;
    public transient boolean          _FailedValidation = false;


    public boolean Validate(ParserSession PS, View ParentView, Base ParentRealized)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;
        _ParentRealized = ParentRealized;

        for (String col : _Columns)
          if (_ParentView.getColumn(col) == null)
           PS.AddError("View '" + _ParentView.getFullName() + "' is defining an upsert column '" + col + "' which cannot be found.");
           
        for (String col : _Timestamps)
          if (_ParentView.getColumn(col) == null)
           PS.AddError("View '" + _ParentView.getFullName() + "' is defining an upsert timestamp '" + col + "' which cannot be found.");

        return Errs == PS.getErrorCount();
      }

  }
