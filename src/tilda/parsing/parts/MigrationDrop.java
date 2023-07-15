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

import com.google.gson.annotations.SerializedName;

import tilda.parsing.ParserSession;

public class MigrationDrop
  {
    /*@formatter:off*/
    @SerializedName("object")  public String    _ObjectName ;
    @SerializedName("columns") public String[]  _Columns    ;
    @SerializedName("objects") public String[]  _ObjectNames;
    @SerializedName("views")   public String[]  _ViewNames  ;
    /*@formatter:on*/

    public transient Schema _Parent;

    public boolean validate(ParserSession PS, Schema Parent)
      {
        int Errs = PS.getErrorCount();
        _Parent = Parent;


        return Errs == PS.getErrorCount();
      }

  }
