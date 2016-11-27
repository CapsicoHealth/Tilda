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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

public class ViewJoinSimple
  {
    static final Logger         LOG = LogManager.getLogger(ViewJoinSimple.class.getName());

    /*@formatter:off*/
	@SerializedName("from") public String  _From;
    @SerializedName("to"  ) public String  _To  ;
    /*@formatter:on*/

    public transient View       _ParentView;
    public transient ViewColumn _FromCol;
    public transient ViewColumn _ToCol;

    public ViewJoinSimple()
      {
      }

    public boolean Validate(ParserSession PS, View ParentView, View Source)
      {
        int Errs = PS.getErrorCount();
        _ParentView = ParentView;

        if (TextUtil.isNullOrEmpty(_From) == true)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining pivot columns from " + Source.getFullName() + " with a join expression with an empty 'from'.");
        else
          {
            _FromCol = Source.getViewColumn(_From);
            if (_FromCol == null)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining pivot columns from " + Source.getFullName() + " with a join 'from' of '"+_From+"' which cannot be resolved.");
          }

        if (TextUtil.isNullOrEmpty(_To) == true)
          PS.AddError("View '" + ParentView.getFullName() + "' is defining pivot columns from " + Source.getFullName() + " with a join expression with an empty 'to'.");
        else
          {
            _ToCol = _ParentView.getViewColumn(_To);
            if (_ToCol == null)
              PS.AddError("View '" + ParentView.getFullName() + "' is defining pivot columns from " + Source.getFullName() + " with a join 'to' of '"+_To+"' which cannot be resolved.");
          }

        return Errs == PS.getErrorCount();
      }
  }
