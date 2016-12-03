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

public class SubWhereX
  {
    protected static final Logger LOG = LogManager.getLogger(SubWhereX.class.getName());

    /*@formatter:off*/
    @SerializedName("clause"     ) public String[] _Clause     ;
    @SerializedName("description") public String[] _Description;
    /*@formatter:on*/

    protected transient Base         _ParentObject;

    protected transient String       _WhereClause;

    public SubWhereX()
      {
      }

    public boolean Validate(ParserSession PS, Base ParentObject, String What)
      {
        int Errs = PS.getErrorCount();

        if (_Clause == null || _Clause.length == 0)
          PS.AddError(What + " is defining a SubWhereX without a clause.");
        else
          _WhereClause = String.join("\n", _Clause);

        if (_Description == null || _Description.length == 0)
          PS.AddError(What + " is defining a SubWhereX without a description.");

        return PS.getErrorCount() == Errs;
      }

    public String getWhereClause()
      {
        return _WhereClause;
      }

  }
