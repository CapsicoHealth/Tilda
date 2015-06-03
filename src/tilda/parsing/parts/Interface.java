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

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.utils.PaddingTracker;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class Interface
  {
    static final Logger              LOG                = LogManager.getLogger(Object.class.getName());

    /*@formatter:off*/
    @SerializedName("name"       ) public String          _Name       ;
    @SerializedName("description") public String          _Description;
	
    @SerializedName("columns"    ) public Field[]         _Fields = { };
    /*@formatter:on*/

    public transient ObjectLifecycle _LC;
    public transient Schema          _ParentSchema;
    public transient PaddingTracker  _PadderFieldNames = new PaddingTracker();
    public transient String          _OriginalName;
    public transient String          _BaseClassName;
    public transient String          _AppClassName;


    public Field getField(String name)
      {
        for (Field F : _Fields)
          if (F != null && F._Name != null && F._Name.equalsIgnoreCase(name) == true)
            return F;
        return null;
      }

    public String getFullName()
      {
        return _ParentSchema.getFullName() + "." + _Name;
      }

    public String getShortName()
      {
        return _ParentSchema.getShortName() + "." + _Name;
      }

    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        int Errs = PS.getErrorCount();
        _ParentSchema = ParentSchema;
        LOG.debug("  Validating Object " + getFullName() + ".");

        // Mandatories
        if (TextUtil.isNullOrEmpty(_Name) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring an interface without a name.");
        if (TextUtil.isNullOrEmpty(_Description) == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring an interface without a description name.");

        _OriginalName = _Name;
        _Name = _Name.toUpperCase();

        _BaseClassName = "TILDA__" + _Name;
        _AppClassName = _OriginalName;


        if (_Fields == null || _Fields.length == 0)
          PS.AddError("Interface '" + getFullName() + "' doesn't define any columns!");
        else
          {
            Set<String> FieldNames = new HashSet<String>();
            for (Field F : _Fields)
              {
                if (F == null)
                  continue;
                else
                  {
                    _PadderFieldNames.track(F._Name);
                    if (F.Validate(PS, this) == true)
                      if (FieldNames.add(F._Name.toUpperCase()) == false)
                        PS.AddError("Field '" + F.getFullName() + "' is defined more than once in Interface '" + getFullName() + "'.");
                  }
              }
          }

        return Errs == PS.getErrorCount();
      }
  }
