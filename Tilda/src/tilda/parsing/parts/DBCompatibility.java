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
    @SchemaDoc(description = "Explicit exceptions allowing listed foreign-key declarations to be omitted on databases where their destination objects are absent.")
    @SerializedName("fkEnforcementExceptions") public List<DBCompatibilityFKEnforcementException> _FKEnforcementExceptions = new ArrayList<DBCompatibilityFKEnforcementException>();
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
          PS.AddError("Core TILDA schema '" + parentSchema.getFullName() + "' cannot define dbCompatibility.targets; it must provide only the stable PostgreSQL baseline.");
        if (IsCoreTilda == true && _FKEnforcementExceptions != null && _FKEnforcementExceptions.isEmpty() == false)
          PS.AddError("Core TILDA schema '" + parentSchema.getFullName() + "' cannot define dbCompatibility.fkEnforcementExceptions.");
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

        if (_FKEnforcementExceptions == null)
          PS.AddError("Schema '" + parentSchema.getFullName() + "' defines dbCompatibility.fkEnforcementExceptions as null; it must be an array.");
        else
          {
            Set<String> ExceptionDBs = new HashSet<String>();
            for (DBCompatibilityFKEnforcementException Exception : _FKEnforcementExceptions)
              if (Exception == null)
                PS.AddError("Schema '" + parentSchema.getFullName() + "' defines a null entry in dbCompatibility.fkEnforcementExceptions.");
              else
                {
                  Exception.validate(PS, parentSchema);
                  if (Exception._ResolvedDB != null && ExceptionDBs.add(Exception._ResolvedDB) == false)
                    PS.AddError("Schema '" + parentSchema.getFullName() + "' defines more than one fkEnforcementExceptions entry for database '" + Exception._ResolvedDB + "'. Combine the FK references into one entry.");
                }
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

    public void validateForeignKeysAndViewDependencies(ParserSession PS, Schema parentSchema)
      {
        if (_Validated != Boolean.TRUE)
          return;

        Set<String> ExceptionKeys = new HashSet<String>();
        for (DBCompatibilityFKEnforcementException Exception : _FKEnforcementExceptions)
          if (Exception != null && Exception._Validated == Boolean.TRUE && Exception._ResolvedDB != null)
            for (String FKReference : Exception._FKs)
              {
                String[] Parts = FKReference.split("\\.", -1);
                Object Source = parentSchema.getObject(Parts[0]);
                if (Source == null)
                  {
                    PS.AddError("Schema '" + parentSchema.getFullName() + "' lists foreign key '" + FKReference + "' in dbCompatibility.fkEnforcementExceptions, but source object '" + Parts[0] + "' is not declared in this schema.");
                    continue;
                  }
                ForeignKey FK = null;
                if (Source._ForeignKeys != null)
                  for (ForeignKey Candidate : Source._ForeignKeys)
                    if (Candidate != null && Candidate._Name != null && Candidate._Name.equalsIgnoreCase(Parts[1]) == true)
                      {
                        FK = Candidate;
                        break;
                      }
                if (FK == null)
                  {
                    PS.AddError("Schema '" + parentSchema.getFullName() + "' lists unknown foreign key '" + FKReference + "' in dbCompatibility.fkEnforcementExceptions.");
                    continue;
                  }
                if (Source._DBCompatibilityTargets.contains(Exception._ResolvedDB) == false)
                  PS.AddError("Schema '" + parentSchema.getFullName() + "' lists foreign key '" + FKReference + "' for database '" + Exception._ResolvedDB + "', but its source object is not routed to that database.");
                if (FK._DestObjectObj == null)
                  continue;
                if (FK._DestObjectObj._DBCompatibilityTargets.contains(Exception._ResolvedDB) == true)
                  PS.AddError("Schema '" + parentSchema.getFullName() + "' lists foreign key '" + FKReference + "' as an enforcement exception for database '" + Exception._ResolvedDB + "', but its destination is present there; remove the unnecessary exception.");
                String Key = getForeignKeyKey(Exception._ResolvedDB, Source, FK);
                if (ExceptionKeys.add(Key) == false)
                  PS.AddError("Schema '" + parentSchema.getFullName() + "' repeats foreign key '" + FKReference + "' as an enforcement exception for database '" + Exception._ResolvedDB + "'.");
                FK._EnforcementExceptionDBs.add(Exception._ResolvedDB);
              }

        if (parentSchema._Objects != null)
          for (Object Source : parentSchema._Objects)
            if (Source != null && Source._ForeignKeys != null)
              for (ForeignKey FK : Source._ForeignKeys)
                if (FK != null && FK._DestObjectObj != null)
                  for (String DB : Source._DBCompatibilityTargets)
                    if (FK._DestObjectObj._DBCompatibilityTargets.contains(DB) == false && FK._EnforcementExceptionDBs.contains(DB) == false)
                      PS.AddError("Foreign key '" + Source.getShortName() + "." + FK._Name + "' targets '" + FK._DestObjectObj.getShortName() + "', which is not available on database '" + DB + "'. Add this exact FK to dbCompatibility.fkEnforcementExceptions only if it is a logical cross-database relationship.");

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