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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
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
    @SchemaDoc(description = "Database-specific object/view routing rules for this schema.")
    @SerializedName("targets"   ) public List<DBCompatibilityTarget> _Targets = new ArrayList<DBCompatibilityTarget>();
    /*@formatter:on*/

    transient public Set<String> _ResolvedDefaultTargets = Collections.emptySet();
    transient public Boolean    _Validated               = null;

    public boolean validate(ParserSession PS, Schema parentSchema)
      {
        if (_Validated != null)
          return _Validated;

        int Errs = PS.getErrorCount();
        Set<String> Defaults = new LinkedHashSet<String>();

        if (parentSchema._DependencySchemas != null)
          for (Schema Dependency : parentSchema._DependencySchemas)
            if (Dependency != null && Dependency._DBCompatibility != null)
              Defaults.addAll(Dependency._DBCompatibility._ResolvedDefaultTargets);

        boolean IsCoreTilda = parentSchema.isCoreTildaSchema();
        if (IsCoreTilda == true && _Targets != null && _Targets.isEmpty() == false)
          for (DBCompatibilityTarget Target : _Targets)
            if (Target != null && (Boolean.FALSE.equals(Target._Only) == false || Target._Objects == null || Target._Objects.length != 1 || "MaintenanceLog".equalsIgnoreCase(Target._Objects[0]) == false || Target._Views == null || Target._Views.length != 0))
              PS.AddError("Core TILDA schema '" + parentSchema.getFullName() + "' may only add non-exclusive dbCompatibility targets for the MaintenanceLog object.");
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

        _ResolvedDefaultTargets = Collections.unmodifiableSet(Defaults);
        if (_Targets == null)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines dbCompatibility.targets as null; it must be an array.");
        else
          {
            Set<String> RouteKeys = new HashSet<String>();
            for (DBCompatibilityTarget Target : _Targets)
              if (Target != null)
                {
                  Target.validate(PS, parentSchema);
                  if (Target._ResolvedDB != null && Target._Only != null)
                    {
                      String Key = Target._ResolvedDB + "|" + Target._Only;
                      if (RouteKeys.add(Key) == false)
                        PS.AddError("Schema '" + parentSchema.getFullName() + "' defines more than one dbCompatibility target route for database '" + Target._ResolvedDB + "' and only=" + Target._Only + ". Combine their object/view patterns into one route.");
                      if ("postgres".equals(Target._ResolvedDB) == true && Target._Only == false)
                        PS.AddError("Schema '" + parentSchema.getFullName() + "' defines a redundant PostgreSQL additive route; PostgreSQL is already the inherited default. Use only=true only when overriding another exclusive route.");
                    }
                }

            for (DBCompatibilityTarget Target : _Targets)
              if (Target == null)
                PS.AddError("Schema '" + parentSchema.getFullName() + "' defines a null entry in dbCompatibility.targets.");
          }

        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }

    private static Set<String> validateBackendIds(ParserSession PS, Schema parentSchema, String fieldName, String[] Values)
      {
        Set<String> Validated = new LinkedHashSet<String>();
        for (String Value : Values)
          {
            String Target = resolveBackendId(Value);
            if (Target == null)
              PS.AddError("Schema '" + parentSchema.getFullName() + "' defines invalid database ID '" + Value + "' in dbCompatibility." + fieldName + ". Valid IDs are " + getRegisteredBackendIds() + ".");
            else if (Validated.add(Target) == false)
              PS.AddError("Schema '" + parentSchema.getFullName() + "' defines database '" + Target + "' more than once in dbCompatibility." + fieldName + ".");
          }
        return Validated;
      }

    public void resolveEntityTargets(ParserSession PS, Schema parentSchema)
      {
        if (_Validated != Boolean.TRUE)
          return;

        List<Base> Entities = new ArrayList<Base>();
        if (parentSchema._Objects != null)
          Entities.addAll(parentSchema._Objects);
        if (parentSchema._Views != null)
          Entities.addAll(parentSchema._Views);

        for (Base Entity : Entities)
          {
            if (Entity == null)
              continue;

            Set<String> Additive = new LinkedHashSet<String>();
            Set<String> Exclusive = new LinkedHashSet<String>();
            Set<String> ExplicitAdditive = new HashSet<String>();
            boolean ExplicitExclusive = false;
            for (DBCompatibilityTarget Target : _Targets)
              if (Target != null && Target._Validated == Boolean.TRUE)
                {
                  boolean Matches = Entity instanceof View == true ? Target.matchesView(Entity._Name) : Target.matchesObject(Entity._Name);
                  if (Matches == true)
                    {
                      boolean Explicit = Entity instanceof View == true ? Target.explicitlyMatchesView(Entity._Name) : Target.explicitlyMatchesObject(Entity._Name);
                      if (Target._Only == true)
                        {
                          Exclusive.add(Target._ResolvedDB);
                          ExplicitExclusive = ExplicitExclusive || Explicit;
                        }
                      else
                        {
                          Additive.add(Target._ResolvedDB);
                          if (Explicit == true)
                            ExplicitAdditive.add(Target._ResolvedDB);
                        }
                    }
                }

            Set<String> Effective = new LinkedHashSet<String>();
            if (Exclusive.size() > 1)
              PS.AddError("Schema '" + parentSchema.getFullName() + "' routes " + (Entity instanceof View == true ? "view '" : "object '") + Entity._Name + "' exclusively to multiple databases " + Exclusive + ".");
            else if (Exclusive.isEmpty() == false)
              {
                String ExclusiveDB = Exclusive.iterator().next();
                boolean ExplicitConflict = ExplicitExclusive;
                for (String DB : ExplicitAdditive)
                  if (ExclusiveDB.equals(DB) == false)
                    ExplicitConflict = true;
                if (ExplicitConflict == true)
                  {
                    PS.AddError("Schema '" + parentSchema.getFullName() + "' explicitly names " + (Entity instanceof View == true ? "view '" : "object '") + Entity._Name + "' in a route conflicting with only=true; use wildcard selectors for exclusive overrides.");
                    Effective.addAll(_ResolvedDefaultTargets);
                    Effective.addAll(Additive);
                  }
                else
                  Effective.addAll(Exclusive);
              }
            else
              {
                Effective.addAll(_ResolvedDefaultTargets);
                Effective.addAll(Additive);
              }
            Entity._DBCompatibilityTargets = Collections.unmodifiableSet(Effective);
          }
      }

    public void validateIndexDetails(ParserSession PS, Schema parentSchema)
      {
        if (_Validated != Boolean.TRUE || parentSchema._Objects == null)
          return;

        for (Object O : parentSchema._Objects)
          if (O != null && O._Indices != null)
            for (Index IX : O._Indices)
              if (IX != null && IX._Db == true && IX.isVectorIndex() == true)
                for (DBType DB : DBType._DBTypes)
                  if (O._DBCompatibilityTargets.contains(canonicalizeBackendId(DB.getName())) == true)
                    if (DB.supportsVectorIndices() == false)
                      PS.AddError("Object '" + O.getFullName() + "' index '" + IX._Name + "' is a physical vector index, but database '" + DB.getName() + "' does not support vector indices.");
                    else
                      try
                        {
                          if (IX.getDetails(DB) == null)
                            PS.AddError("Object '" + O.getFullName() + "' index '" + IX._Name + "' targets database '" + DB.getName() + "' but has no matching vector.details entry.");
                        }
                      catch (Exception e)
                      {
                        PS.AddError(e.getMessage());
                      }
      }

    public void validateForeignKeysAndViewDependencies(ParserSession PS, Schema parentSchema)
      {
        if (_Validated != Boolean.TRUE)
          return;

        Set<String> ExceptionKeys = new HashSet<String>();
        if (_Targets != null)
          for (DBCompatibilityTarget Target : _Targets)
            if (Target != null && Target._Validated == Boolean.TRUE && Target._ResolvedDB != null && Target._FKEnforcementExceptions != null)
              for (String FKReference : Target._FKEnforcementExceptions)
              {
                String[] Parts = FKReference.split("\\.", -1);
                Object Source = parentSchema.getObject(Parts[0]);
                if (Source == null)
                  {
                    PS.AddError("Schema '" + parentSchema.getFullName() + "' lists foreign key '" + FKReference + "' in dbCompatibility.targets for database '" + Target._ResolvedDB + "', but source object '" + Parts[0] + "' is not declared in this schema.");
                    continue;
                  }
                if (Target.matchesObject(Source._Name) == false || Source._DBCompatibilityTargets.contains(Target._ResolvedDB) == false)
                  {
                    PS.AddError("Schema '" + parentSchema.getFullName() + "' lists foreign key exception '" + FKReference + "' for database '" + Target._ResolvedDB + "', but its source object is not included in that target route.");
                    continue;
                  }

                List<ForeignKey> ForeignKeys = new ArrayList<ForeignKey>();
                if (Parts.length == 1)
                  {
                    if (Source._ForeignKeys != null)
                      for (ForeignKey FK : Source._ForeignKeys)
                        if (FK != null)
                          ForeignKeys.add(FK);
                    if (ForeignKeys.isEmpty() == true)
                      {
                        PS.AddError("Schema '" + parentSchema.getFullName() + "' lists object '" + Parts[0] + "' in dbCompatibility.targets.fkEnforcementExceptions, but it declares no foreign keys.");
                        continue;
                      }
                  }
                else
                  {
                    ForeignKey Match = null;
                    if (Source._ForeignKeys != null)
                      for (ForeignKey Candidate : Source._ForeignKeys)
                        if (Candidate != null && Candidate._Name != null && Candidate._Name.equalsIgnoreCase(Parts[1]) == true)
                          {
                            Match = Candidate;
                            break;
                          }
                    if (Match == null)
                      {
                        PS.AddError("Schema '" + parentSchema.getFullName() + "' lists unknown foreign key '" + FKReference + "' in dbCompatibility.targets for database '" + Target._ResolvedDB + "'.");
                        continue;
                      }
                    ForeignKeys.add(Match);
                  }

                for (ForeignKey FK : ForeignKeys)
                  {
                    if (FK._DestObjectObj == null)
                      continue;
                    if (FK._DestObjectObj._DBCompatibilityTargets.contains(Target._ResolvedDB) == true)
                      {
                        PS.AddError("Schema '" + parentSchema.getFullName() + "' lists foreign key '" + Source._Name + "." + FK._Name + "' as an enforcement exception for database '" + Target._ResolvedDB + "', but its destination is present there; remove the unnecessary exception.");
                        continue;
                      }
                    String Key = getForeignKeyKey(Target._ResolvedDB, Source, FK);
                    if (ExceptionKeys.add(Key) == false)
                      {
                        PS.AddError("Schema '" + parentSchema.getFullName() + "' repeats foreign key '" + Source._Name + "." + FK._Name + "' as an enforcement exception for database '" + Target._ResolvedDB + "'.");
                        continue;
                      }
                    FK._EnforcementExceptionDBs.add(Target._ResolvedDB);
                  }
              }

        if (parentSchema._Objects != null)
          for (Object Source : parentSchema._Objects)
            if (Source != null && Source._ForeignKeys != null)
              for (ForeignKey FK : Source._ForeignKeys)
                if (FK != null && FK._DestObjectObj != null)
                  for (String DB : Source._DBCompatibilityTargets)
                    if (FK._DestObjectObj._DBCompatibilityTargets.contains(DB) == false && FK._EnforcementExceptionDBs.contains(DB) == false)
                      PS.AddError("Foreign key '" + Source.getShortName() + "." + FK._Name + "' targets '" + FK._DestObjectObj.getShortName() + "', which is not available on database '" + DB + "'. Add this FK, or its source object to exempt all its FKs, in the matching dbCompatibility.targets entry only if it is a logical cross-database relationship.");

        if (parentSchema._Views != null)
          for (View V : parentSchema._Views)
            if (V != null)
              {
                Set<Base> Dependencies = new LinkedHashSet<Base>();
                if (V._Dependencies != null)
                  Dependencies.addAll(V._Dependencies.values());
                if (V._Joins != null)
                  for (ViewJoin Join : V._Joins)
                    if (Join != null && Join._ObjectObj != null)
                      Dependencies.add(Join._ObjectObj);
                for (Base Dependency : Dependencies)
                  if (Dependency != null)
                  for (String DB : V._DBCompatibilityTargets)
                    if (Dependency._DBCompatibilityTargets.contains(DB) == false)
                      PS.AddError("View '" + V.getShortName() + "' depends on '" + Dependency.getShortName() + "', which is not available on database '" + DB + "'. Route the view only to databases where all its dependencies are available.");
              }
      }

    private static String getForeignKeyKey(String db, Object source, ForeignKey foreignKey)
      {
        return db.toLowerCase(Locale.ROOT) + "|" + source._Name.toLowerCase(Locale.ROOT) + "." + foreignKey._Name.toLowerCase(Locale.ROOT);
      }

    public static String resolveBackendId(String value)
      {
        if (value == null || value.equals(value.trim()) == false)
          return null;
        for (DBType Type : DBType._DBTypes)
          {
            String Canonical = canonicalizeBackendId(Type.getName());
            if (value.equalsIgnoreCase(Type.getName()) == true || value.equalsIgnoreCase(Canonical) == true
            || "postgres".equals(Canonical) == true && value.equalsIgnoreCase("postgresql") == true
            || "sqlserver".equals(Canonical) == true && value.equalsIgnoreCase("mssql") == true)
              return Canonical;
          }
        return null;
      }

    public static String canonicalizeBackendId(String value)
      {
        if (value == null)
          return null;
        if (value.equalsIgnoreCase("postgres") == true || value.equalsIgnoreCase("postgresql") == true)
          return "postgres";
        if (value.equalsIgnoreCase("bigquery") == true)
          return "bigquery";
        if (value.equalsIgnoreCase("sqlserver") == true || value.equalsIgnoreCase("mssql") == true)
          return "sqlserver";
        return value.toLowerCase(Locale.ROOT);
      }

    public static Set<String> getRegisteredBackendIds()
      {
        Set<String> Ids = new LinkedHashSet<String>();
        for (DBType Type : DBType._DBTypes)
          Ids.add(canonicalizeBackendId(Type.getName()));
        return Ids;
      }
  }