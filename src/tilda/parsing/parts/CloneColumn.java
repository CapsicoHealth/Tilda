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

public class CloneColumn
  {
    static final Logger LOG          = LogManager.getLogger(CloneColumn.class.getName());

    /*@formatter:off*/
    @SerializedName("sameAs"      ) public String   _SameAs       ;
    @SerializedName("exclude"     ) public String[] _Exclude      = new String[] { };
	@SerializedName("name"        ) public String   _Name         ;
    @SerializedName("description" ) public String   _Description  = null;
    /*@formatter:on*/

    public CloneColumn()
      {
      }

    public CloneColumn(String sameAs)
      {
        _SameAs = sameAs;
      }

    public CloneColumn(CloneColumn cc)
      {
        _Name = cc._Name;
        _SameAs = cc._SameAs;
        _Exclude = cc._Exclude.clone();
        _Description = cc._Description;
      }

    public transient View   _ParentView;
    public transient Column _SameAsObj;
    public transient View   _SameAsView;

    public boolean validate(ParserSession PS, Object parentObject)
      {
        boolean flag = true;
        
        if (TextUtil.isNullOrEmpty(_SameAs) == true)
          return PS.AddError("Object '" + parentObject.getFullName() + "' defines a cloneFrom with a source column without a sameAs: it is mandatory.");
        
        if (_SameAs.indexOf(".") != -1)
          return PS.AddError("Object '" + parentObject.getFullName() + "' defines a cloneFrom with a source column sameAs '"+_SameAs+"' which contains a '.' character: for cloning, only column names are allowed, or partial names ending in '*' since the source table is fixed.");
          
          
        if (_SameAs.endsWith("*") == true && TextUtil.isNullOrEmpty(_Name) == false)
          flag = PS.AddError("Object '" + parentObject.getFullName() + "' defines a cloneFrom with a source column sameAs '" + _SameAs + "' which ends in a '*' character and also defines a name. Defining a name allows to override a single name in a sameAs and so is not compatible with a .* expansion.");
        if (_SameAs.endsWith("*") == true && TextUtil.isNullOrEmpty(_Description) == false)
          flag = PS.AddError("Object '" + parentObject.getFullName() + "' defines a cloneFrom with a source column sameAs '" + _SameAs + "' which ends in a '*' character and also defines a description: With a .* expansions, you cannot redefine descriptions.");
        if (_SameAs.endsWith("*") == false && _Exclude.length > 0)
          flag = PS.AddError("Object '" + parentObject.getFullName() + "' defines a cloneFrom with a source column sameAs '" + _SameAs + "' which doesn't end in a '*' character and an exclude '" + TextUtil.print(_Exclude) + "'. You cannot use an exclude statement unless you use a * expansion.");
        
        if (TextUtil.isNullOrEmpty(_Description) == true)
          _Description = "?{}";
        
        return flag;
      }
  }
