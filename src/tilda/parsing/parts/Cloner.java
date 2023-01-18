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
import tilda.utils.TextUtil;

public class Cloner
  {
    public Cloner()
      {
      }

    /*@formatter:off*/
    @SerializedName("name"        ) public String  _Name       ;
    @SerializedName("fullName"    ) public boolean _FullName   = false;
    @SerializedName("referenceUrl") public String  _ReferenceUrl;
    @SerializedName("description" ) public String  _Description;
    @SerializedName("tag"         ) public String  _Tag;
    /*@formatter:on*/

    public transient Object _ParentObject;

    public Cloner(Cloner c)
      {
        _Name = c._Name;
        _Description = c._Description;
      }

    public boolean Validate(ParserSession PS, Object parentObject)
      {
        _ParentObject = parentObject;
        if (TextUtil.isNullOrEmpty(_Name) == true)
          {
            PS.AddError("Object '" + parentObject.getFullName() + "' defined a cloneAs without a name.");
            return false;
          }
        if (_FullName == false)
         _Name = parentObject._Name + "_" + _Name;
        
        if (TextUtil.isNullOrEmpty(_Description) == true)
          _Description = "?{}";
        _Description = _Description.replace("?{}", parentObject._OriginalDescription) + " (cloned from "+parentObject.getShortName()+")";

        return true;
      }
  }
