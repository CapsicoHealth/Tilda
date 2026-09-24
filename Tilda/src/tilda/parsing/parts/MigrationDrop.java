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

import tilda.annotations.SchemaDoc;
import tilda.annotations.SchemaRefKind;
import tilda.parsing.ParserSession;

public class MigrationDrop
  {
    /*@formatter:off*/
    @SchemaDoc(description = "Object from which columns are dropped.", refKind = SchemaRefKind.OBJECT_IN_SCHEMA)
    @SerializedName("object")  public String    _ObjectName ;
    @SchemaDoc(description = "Column names to drop from the selected object.", refKind = SchemaRefKind.COLUMN_IN_SAME_OBJECT)
    @SerializedName("columns") public String[]  _Columns    ;
    @SchemaDoc(description = "Object names to drop.", refKind = SchemaRefKind.OBJECT_IN_SCHEMA)
    @SerializedName("objects") public String[]  _ObjectNames;
    @SchemaDoc(description = "View names to drop.", refKind = SchemaRefKind.VIEW_IN_SCHEMA)
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
