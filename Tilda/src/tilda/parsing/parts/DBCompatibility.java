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

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

import tilda.annotations.SchemaDoc;
import tilda.db.stores.DBType;
import tilda.parsing.ParserSession;

public class DBCompatibility
  {
    /*@formatter:off*/
    @SchemaDoc(description = "Stable platform database baseline. Declared only by the core TILDA schema and inherited by dependent schemas.")
    @SerializedName("default"   ) public String[] _Default    ;
    @SchemaDoc(description = "Additional database targets explicitly enabled for this schema; these are not inherited by dependent schemas.")
    @SerializedName("additional") public String[] _Additional = new String[] { };
    /*@formatter:on*/

    transient public Set<String> _ResolvedDefaultTargets = Collections.emptySet();
    transient public Set<String> _ResolvedTargets        = Collections.emptySet();
    transient public Boolean    _Validated               = null;

    public boolean validate(ParserSession PS, Schema parentSchema)
      {
        if (_Validated != null)
          return _Validated;

        int Errs = PS.getErrorCount();
        Set<String> Defaults = new LinkedHashSet<String>();
        Set<String> Targets = new LinkedHashSet<String>();

        if (parentSchema._DependencySchemas != null)
          for (Schema Dependency : parentSchema._DependencySchemas)
            if (Dependency != null && Dependency._DBCompatibility != null)
              Defaults.addAll(Dependency._DBCompatibility._ResolvedDefaultTargets);

        boolean IsCoreTilda = parentSchema.isCoreTildaSchema();
        if (_Default != null)
          {
            if (IsCoreTilda == false)
              PS.AddError("Schema '" + parentSchema.getFullName() + "' cannot define dbCompatibility.default; the platform baseline is declared by the core TILDA schema and inherited through dependencies.");
            Set<String> DeclaredDefaults = validateBackendIds(PS, parentSchema, "default", _Default);
            if (IsCoreTilda == true)
              {
                if (DeclaredDefaults.contains("postgres") == false || DeclaredDefaults.size() != 1)
                  PS.AddError("Core TILDA schema '" + parentSchema.getFullName() + "' must keep dbCompatibility.default as [\"postgres\"]. Other backends must be explicitly opted into by application schemas.");
                Defaults.addAll(DeclaredDefaults);
              }
          }
        else if (IsCoreTilda == true)
          PS.AddError("Core TILDA schema '" + parentSchema.getFullName() + "' must declare dbCompatibility.default as [\"postgres\"].");

        Targets.addAll(Defaults);
        Set<String> Additional = Collections.emptySet();
        if (_Additional == null)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines dbCompatibility.additional as null; it must be an array of database IDs.");
        else
          Additional = validateBackendIds(PS, parentSchema, "additional", _Additional);
        for (String Target : Additional)
          if (Targets.add(Target) == false)
            PS.AddError("Schema '" + parentSchema.getFullName() + "' lists database '" + Target + "' in dbCompatibility.additional, but it is already inherited as a default target.");

        _ResolvedDefaultTargets = Collections.unmodifiableSet(Defaults);
        _ResolvedTargets = Collections.unmodifiableSet(Targets);
        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }

    private static Set<String> validateBackendIds(ParserSession PS, Schema parentSchema, String fieldName, String[] Values)
      {
        Set<String> Validated = new LinkedHashSet<String>();
        if (Values == null)
          return Validated;

        for (String Value : Values)
          {
            String Target = getRegisteredBackendId(Value);
            if (Target == null)
              PS.AddError("Schema '" + parentSchema.getFullName() + "' defines invalid database ID '" + Value + "' in dbCompatibility." + fieldName + ". Valid IDs are " + getRegisteredBackendIds() + ".");
            else if (Validated.add(Target) == false)
              PS.AddError("Schema '" + parentSchema.getFullName() + "' defines database '" + Target + "' more than once in dbCompatibility." + fieldName + ".");
          }
        return Validated;
      }

    private static String getRegisteredBackendId(String value)
      {
        if (value == null)
          return null;

        String Normalized = normalizeBackendId(value);
        for (DBType Type : DBType._DBTypes)
          if (normalizeBackendId(Type.getName()).equals(Normalized) == true || canonicalBackendId(Type.getName()).equals(canonicalBackendId(value)) == true)
            return canonicalBackendId(Type.getName());
        return null;
      }

    private static String canonicalBackendId(String value)
      {
        String Normalized = normalizeBackendId(value);
        if (Normalized.equals("postgres") == true || Normalized.equals("postgresql") == true)
          return "postgres";
        if (Normalized.equals("bigquery") == true)
          return "bigquery";
        if (Normalized.equals("sqlserver") == true || Normalized.equals("mssql") == true)
          return "sqlserver";
        return Normalized;
      }

    private static String normalizeBackendId(String value)
      {
        return value == null ? "" : value.replaceAll("[^A-Za-z0-9]", "").toLowerCase(java.util.Locale.ROOT);
      }

    private static Set<String> getRegisteredBackendIds()
      {
        Set<String> Ids = new LinkedHashSet<String>();
        for (DBType Type : DBType._DBTypes)
          Ids.add(canonicalBackendId(Type.getName()));
        return Ids;
      }
  }