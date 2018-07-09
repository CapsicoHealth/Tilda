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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class Field extends TypeDef
  {
    static final Logger             LOG                = LogManager.getLogger(Field.class.getName());

    /*@formatter:off*/
	@SerializedName("name"       ) public String         _Name       ;

    @SerializedName("nullable"   ) public Boolean        _Nullable   ;
    @SerializedName("description") public String         _Description;
    /*@formatter:on*/

    public transient ColumnType     _Type;
    public transient String         _TypeSep;
    public transient Interface         _ParentInterface;

    public String getFullName()
      {
        return _ParentInterface.getFullName() + "." + _Name;
      }

    public String getShortName()
      {
        return _ParentInterface.getShortName() + "." + _Name;
      }
    
    protected static final Pattern P = Pattern.compile(".*\\[(.+)\\]");

    public boolean Validate(ParserSession PS, Interface I)
      {
        int Errs = PS.getErrorCount();
        _ParentInterface = I;
        LOG.debug("    Validating Field " + getFullName() + ".");

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Field '" + getFullName() + "' didn't define a 'name'. It is mandatory.");

        if (super.Validate(PS, "Column '" + getFullName() + "'", true, false) == false)
          return false;

        if (_Nullable == null)
          _Nullable = Boolean.TRUE;

        if (TextUtil.isNullOrEmpty(_Description) == true)
          PS.AddError("Field '" + getFullName() + "' didn't define a 'description'. It is mandatory.");

        if (_Type != ColumnType.STRING && _Size != null)
          {
              PS.AddError("Field '" + getFullName() + "' is defined as a '" + _Type + "' with a 'size'. Only String fields should have a 'size' defined.");
          }

        return Errs == PS.getErrorCount();
      }


    public boolean isArray()
      {
        return TextUtil.isNullOrEmpty(_TypeSep) == false;
      }
    

  }
