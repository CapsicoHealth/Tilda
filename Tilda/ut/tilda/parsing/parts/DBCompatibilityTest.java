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

import com.google.gson.Gson;

import tilda.parsing.ParserSession;

public class DBCompatibilityTest
  {
    public static void main(String[] args)
    throws Exception
      {
        Schema Core = parseSchema("{\"dbCompatibility\":{\"default\":[\"postgres\"]}}", "tilda.data", "TILDA");
        Core._ResourceName = Schema._BASE_TILDA_SCHEMA_RESOURCE;
        ParserSession CorePS = new ParserSession(Core, null);
        if (Core.validate(CorePS) == false)
          throw new IllegalStateException("Core TILDA compatibility declaration did not validate: " + CorePS.getErrors());

        Schema App = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"*\"],\"views\":[\"*\"]},{\"db\":\"bigquery\",\"only\":true,\"objects\":[\"C*\"],\"views\":[]}]}}", "test.data", "APP");
        App._ResourceName = "test/data/_tilda.APP.json";
        App._DependencySchemas.add(Core);
        addObject(App, "A");
        addObject(App, "B");
        addObject(App, "C");
        addView(App, "SummaryView");
        ParserSession AppPS = new ParserSession(App, null);
        AppPS.addDependencySchema(Core);
        if (App._DBCompatibility.validate(AppPS, App) == false)
          throw new IllegalStateException("Application compatibility declaration did not validate: " + AppPS.getErrors());
        App._DBCompatibility.resolveEntityTargets(AppPS, App);
        assertTargets(App.getObject("A"), "postgres", "bigquery");
        assertTargets(App.getObject("B"), "postgres", "bigquery");
        assertTargets(App.getObject("C"), "bigquery");
        assertTargets(App.getView("SummaryView"), "postgres", "bigquery");

        Schema Suffix = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"*Object\"],\"views\":[]}]}}", "test.data", "SUFFIX");
        Suffix._DependencySchemas.add(Core);
        Object ShortObject = addObject(Suffix, "A");
        Object LongObject = addObject(Suffix, "LongObject");
        ParserSession SuffixPS = new ParserSession(Suffix, null);
        SuffixPS.addDependencySchema(Core);
        if (Suffix._DBCompatibility.validate(SuffixPS, Suffix) == false)
          throw new IllegalStateException("Suffix wildcard declaration did not validate: " + SuffixPS.getErrors());
        Suffix._DBCompatibility.resolveEntityTargets(SuffixPS, Suffix);
        assertTargets(ShortObject, "postgres");
        assertTargets(LongObject, "postgres", "bigquery");

        Schema CrossStore = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"CohortMartX\"],\"views\":[]}]}}", "test.data", "CROSSSTORE");
        CrossStore._DependencySchemas.add(Core);
        Object Mart = addObject(CrossStore, "CohortMartX");
        Object Cohort = addObject(CrossStore, "CohortDefinition");
        ForeignKey FK = new ForeignKey();
        FK._Name = "CohortDefinitionFK";
        FK._ParentObject = Mart;
        FK._DestObjectObj = Cohort;
        Mart._ForeignKeys.add(FK);
        ParserSession CrossStorePS = new ParserSession(CrossStore, null);
        CrossStorePS.addDependencySchema(Core);
        if (CrossStore._DBCompatibility.validate(CrossStorePS, CrossStore) == false)
          throw new IllegalStateException("Cross-store schema targets did not validate: " + CrossStorePS.getErrors());
        CrossStore._DBCompatibility.resolveEntityTargets(CrossStorePS, CrossStore);
        CrossStore._DBCompatibility.validateForeignKeysAndViewDependencies(CrossStorePS, CrossStore);
        if (CrossStorePS.getErrorCount() == 0)
          throw new IllegalStateException("A cross-database FK without an exception was not rejected.");

        Schema Excepted = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"CohortMartX\"],\"views\":[]}],\"fkEnforcementExceptions\":[{\"db\":\"bigquery\",\"fks\":[\"CohortMartX.CohortDefinitionFK\"]}]}}", "test.data", "EXCEPTED");
        Excepted._DependencySchemas.add(Core);
        Object ExceptedMart = addObject(Excepted, "CohortMartX");
        Object ExceptedCohort = addObject(Excepted, "CohortDefinition");
        ForeignKey ExceptedFK = new ForeignKey();
        ExceptedFK._Name = "CohortDefinitionFK";
        ExceptedFK._ParentObject = ExceptedMart;
        ExceptedFK._DestObjectObj = ExceptedCohort;
        ExceptedMart._ForeignKeys.add(ExceptedFK);
        ParserSession ExceptedPS = new ParserSession(Excepted, null);
        ExceptedPS.addDependencySchema(Core);
        if (Excepted._DBCompatibility.validate(ExceptedPS, Excepted) == false)
          throw new IllegalStateException("FK exception declaration did not validate: " + ExceptedPS.getErrors());
        Excepted._DBCompatibility.resolveEntityTargets(ExceptedPS, Excepted);
        Excepted._DBCompatibility.validateForeignKeysAndViewDependencies(ExceptedPS, Excepted);
        if (ExceptedPS.getErrorCount() != 0 || ExceptedFK._EnforcementExceptionDBs.contains("bigquery") == false)
          throw new IllegalStateException("A valid cross-store FK exception did not resolve: " + ExceptedPS.getErrors());

        Schema Redundant = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"Source\",\"Destination\"],\"views\":[]}],\"fkEnforcementExceptions\":[{\"db\":\"bigquery\",\"fks\":[\"Source.RefFK\"]}]}}", "test.data", "REDUNDANT");
        Redundant._DependencySchemas.add(Core);
        Object RedundantSource = addObject(Redundant, "Source");
        Object RedundantDestination = addObject(Redundant, "Destination");
        ForeignKey RedundantFK = new ForeignKey();
        RedundantFK._Name = "RefFK";
        RedundantFK._ParentObject = RedundantSource;
        RedundantFK._DestObjectObj = RedundantDestination;
        RedundantSource._ForeignKeys.add(RedundantFK);
        ParserSession RedundantPS = new ParserSession(Redundant, null);
        RedundantPS.addDependencySchema(Core);
        Redundant._DBCompatibility.validate(RedundantPS, Redundant);
        Redundant._DBCompatibility.resolveEntityTargets(RedundantPS, Redundant);
        Redundant._DBCompatibility.validateForeignKeysAndViewDependencies(RedundantPS, Redundant);
        if (RedundantPS.getErrorCount() == 0)
          throw new IllegalStateException("A redundant FK enforcement exception was not rejected.");

        Schema UnknownFK = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"Source\"],\"views\":[]}],\"fkEnforcementExceptions\":[{\"db\":\"bigquery\",\"fks\":[\"Source.MissingFK\"]}]}}", "test.data", "UNKNOWNFK");
        UnknownFK._DependencySchemas.add(Core);
        addObject(UnknownFK, "Source");
        ParserSession UnknownFKPS = new ParserSession(UnknownFK, null);
        UnknownFKPS.addDependencySchema(Core);
        UnknownFK._DBCompatibility.validate(UnknownFKPS, UnknownFK);
        UnknownFK._DBCompatibility.resolveEntityTargets(UnknownFKPS, UnknownFK);
        UnknownFK._DBCompatibility.validateForeignKeysAndViewDependencies(UnknownFKPS, UnknownFK);
        if (UnknownFKPS.getErrorCount() == 0)
          throw new IllegalStateException("An exception naming an unknown FK was not rejected.");

        Schema ViewMismatch = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"Mart\"],\"views\":[\"SummaryView\"]}]}}", "test.data", "VIEWMISMATCH");
        ViewMismatch._DependencySchemas.add(Core);
        Object ViewSource = addObject(ViewMismatch, "Source");
        addObject(ViewMismatch, "Mart");
        View MismatchedView = addView(ViewMismatch, "SummaryView");
        MismatchedView._Dependencies.put("SOURCE", ViewSource);
        ParserSession ViewMismatchPS = new ParserSession(ViewMismatch, null);
        ViewMismatchPS.addDependencySchema(Core);
        ViewMismatch._DBCompatibility.validate(ViewMismatchPS, ViewMismatch);
        ViewMismatch._DBCompatibility.resolveEntityTargets(ViewMismatchPS, ViewMismatch);
        ViewMismatch._DBCompatibility.validateForeignKeysAndViewDependencies(ViewMismatchPS, ViewMismatch);
        if (ViewMismatchPS.getErrorCount() == 0)
          throw new IllegalStateException("A view routed to a database without its dependency was not rejected.");

        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"post-gres\",\"objects\":[\"*\"],\"views\":[]}]}}", "punctuated backend ID");
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"missing*\"],\"views\":[]}]}}", "unmatched wildcard");
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"*\"],\"views\":[]},{\"db\":\"bigquery\",\"objects\":[\"A\"],\"views\":[]}]}}", "duplicate db/only route");
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"only\":true,\"objects\":[\"A\"],\"views\":[]},{\"db\":\"sqlserver\",\"only\":true,\"objects\":[\"A\"],\"views\":[]}]}}", "conflicting exclusive routes");
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"only\":true,\"objects\":[\"A\"],\"views\":[]}]}}", "exact only route");
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"only\":true,\"objects\":[\"A*\"],\"views\":[]},{\"db\":\"sqlserver\",\"objects\":[\"A\"],\"views\":[]}]}}", "exact route conflicting with wildcard only");
        assertInvalid(Core, "{\"dbCompatibility\":{\"fkEnforcementExceptions\":[{\"db\":\"bigquery\",\"fks\":[\"Bad-Object.FK\"]}]}}", "invalid FK exception identifier");
        assertInvalid(Core, "{\"dbCompatibility\":{\"default\":[\"bigquery\"]}}", "dependent default override");

        Schema InvalidCore = parseSchema("{\"dbCompatibility\":{\"default\":[\"postgres\"],\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"*\"],\"views\":[]}]}}", "tilda.data", "TILDA");
        addObject(InvalidCore, "CoreObject");
        ParserSession InvalidCorePS = new ParserSession(InvalidCore, null);
        if (InvalidCore._DBCompatibility.validate(InvalidCorePS, InvalidCore) == true || InvalidCorePS.getErrorCount() == 0)
          throw new IllegalStateException("Core TILDA was allowed to declare non-baseline routes.");
      }

    private static Object addObject(Schema schema, String name)
      {
        Object O = new Object();
        O._Name = name;
        schema._Objects.add(O);
        return O;
      }

    private static View addView(Schema schema, String name)
      {
        View V = new View();
        V._Name = name;
        schema._Views.add(V);
        return V;
      }

    private static void assertTargets(Base entity, String... expected)
      {
        java.util.Set<String> Expected = new java.util.HashSet<String>(java.util.Arrays.asList(expected));
        if (entity._DBCompatibilityTargets.equals(Expected) == false)
          throw new IllegalStateException("Unexpected effective targets for '" + entity._Name + "': " + entity._DBCompatibilityTargets + "; expected " + Expected);
      }

    private static void assertInvalid(Schema core, String json, String what)
      {
        Schema Invalid = parseSchema(json, "test.data", "INVALID");
        Invalid._DependencySchemas.add(core);
        if (what.contains("wildcard") == true || what.contains("exclusive") == true || what.contains("route") == true || what.contains("only") == true)
          {
            addObject(Invalid, "A");
            addObject(Invalid, "B");
          }
        ParserSession PS = new ParserSession(Invalid, null);
        PS.addDependencySchema(core);
        Invalid._DBCompatibility.validate(PS, Invalid);
        Invalid._DBCompatibility.resolveEntityTargets(PS, Invalid);
        if (PS.getErrorCount() == 0)
          throw new IllegalStateException("Invalid " + what + " was not rejected.");
      }

    private static Schema parseSchema(String json, String packageName, String schemaName)
      {
        Schema S = new Gson().fromJson(json, Schema.class);
        S._Package = packageName;
        S._Name = schemaName;
        return S;
      }
  }