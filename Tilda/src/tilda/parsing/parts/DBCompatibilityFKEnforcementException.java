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
import java.util.Locale;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

import tilda.annotations.SchemaDoc;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;

public class DBCompatibilityFKEnforcementException
  {
    /*@formatter:off*/
    @SchemaDoc(description = "Database where listed foreign-key declarations may be omitted when their destination objects are unavailable.", required = true)
    @SerializedName("db" ) public String   _DB  ;
    @SchemaDoc(description = "Source object and foreign-key names in ObjectName.ForeignKeyName form.", required = true)
    @SerializedName("fks") public String[] _FKs = new String[] { };
    /*@formatter:on*/

    transient public String  _ResolvedDB;
    transient public Boolean _Validated = null;

    public boolean validate(ParserSession PS, Schema parentSchema)
      {
        if (_Validated != null)
          return _Validated;

        int Errs = PS.getErrorCount();
        _ResolvedDB = DBCompatibility.resolveBackendId(_DB);
        if (_DB == null || _DB.isEmpty() == true || _ResolvedDB == null)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines an invalid or missing database ID '" + _DB + "' in dbCompatibility.fkEnforcementExceptions. Valid IDs are " + DBCompatibility.getRegisteredBackendIds() + ".");
        if (_FKs == null)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines null 'fks' in dbCompatibility.fkEnforcementExceptions; it must be an array.");
        else if (_FKs.length == 0)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines an empty 'fks' list in dbCompatibility.fkEnforcementExceptions.");
        else
          {
            Set<String> Seen = new HashSet<String>();
            for (String FK : _FKs)
              {
                String[] Parts = FK == null ? new String[0] : FK.split("\\.", -1);
                if (FK == null || FK.trim().equals(FK) == false || Parts.length != 2 || ValidationHelper.isValidIdentifier(Parts[0]) == false || ValidationHelper.isValidIdentifier(Parts[1]) == false)
                  PS.AddError("Schema '" + parentSchema.getFullName() + "' defines invalid FK reference '" + FK + "' in dbCompatibility.fkEnforcementExceptions; use ObjectName.ForeignKeyName.");
                else if (Seen.add(FK.toLowerCase(Locale.ROOT)) == false)
                  PS.AddError("Schema '" + parentSchema.getFullName() + "' repeats FK reference '" + FK + "' in dbCompatibility.fkEnforcementExceptions.");
              }
          }

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }
  }