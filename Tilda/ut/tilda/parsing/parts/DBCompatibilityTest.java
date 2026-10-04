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

        Schema NoViews = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"*\"],\"views\":[\"*\"]}]}}", "test.data", "NOVIEWS");
        NoViews._DependencySchemas.add(Core);
        addObject(NoViews, "TableOnly");
        ParserSession NoViewsPS = new ParserSession(NoViews, null);
        NoViewsPS.addDependencySchema(Core);
        if (NoViews._DBCompatibility.validate(NoViewsPS, NoViews) == false)
          throw new IllegalStateException("A wildcard view target did not validate for a schema with no views: " + NoViewsPS.getErrors());

        Schema EmptySchema = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[],\"views\":[\"*\"]}]}}", "test.data", "EMPTY");
        EmptySchema._DependencySchemas.add(Core);
        ParserSession EmptySchemaPS = new ParserSession(EmptySchema, null);
        EmptySchemaPS.addDependencySchema(Core);
        if (EmptySchema._DBCompatibility.validate(EmptySchemaPS, EmptySchema) == false)
          throw new IllegalStateException("An empty schema wildcard target did not validate: " + EmptySchemaPS.getErrors());

        Schema MissingVectorDetails = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"VectorTable\"],\"views\":[]}]}}", "test.data", "MISSINGVECTORDETAILS");
        MissingVectorDetails._DependencySchemas.add(Core);
        Object VectorTable = addObject(MissingVectorDetails, "VectorTable");
        Index VectorIndex = new Index();
        VectorIndex._Name = "Embedding";
        VectorIndex._Parent = VectorTable;
        VectorIndex._ColumnObjs.add(new VectorTestColumn("embedding"));
        VectorIndex._Vector = new Index.Vector();
        Index.Details PostgresDetail = new Index.Details();
        PostgresDetail._Db = "postgres";
        VectorIndex._Vector._Details = java.util.Collections.singletonList(PostgresDetail);
        VectorTable._Indices.add(VectorIndex);
        ParserSession MissingVectorDetailsPS = new ParserSession(MissingVectorDetails, null);
        MissingVectorDetailsPS.addDependencySchema(Core);
        MissingVectorDetails._DBCompatibility.validate(MissingVectorDetailsPS, MissingVectorDetails);
        MissingVectorDetails._DBCompatibility.resolveEntityTargets(MissingVectorDetailsPS, MissingVectorDetails);
        MissingVectorDetails._DBCompatibility.validateIndexDetails(MissingVectorDetailsPS, MissingVectorDetails);
        if (MissingVectorDetailsPS.getErrors().stream().anyMatch(error -> error.contains("database 'BigQuery'") && error.contains("no details")) == false)
          throw new IllegalStateException("A missing BigQuery vector detail was not reported during schema validation: " + MissingVectorDetailsPS.getErrors());

        Schema UnsupportedVectorBackend = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"sqlserver\",\"objects\":[\"VectorTable\"],\"views\":[]}]}}", "test.data", "UNSUPPORTEDVECTORBACKEND");
        UnsupportedVectorBackend._DependencySchemas.add(Core);
        Object UnsupportedVectorTable = addObject(UnsupportedVectorBackend, "VectorTable");
        Index UnsupportedVectorIndex = new Index();
        UnsupportedVectorIndex._Name = "Embedding";
        UnsupportedVectorIndex._Parent = UnsupportedVectorTable;
        UnsupportedVectorIndex._ColumnObjs.add(new VectorTestColumn("embedding"));
        UnsupportedVectorIndex._Vector = new Index.Vector();
        Index.Details SupportedPostgresDetail = new Index.Details();
        SupportedPostgresDetail._Db = "postgres";
        UnsupportedVectorIndex._Vector._Details = java.util.Collections.singletonList(SupportedPostgresDetail);
        UnsupportedVectorTable._Indices.add(UnsupportedVectorIndex);
        ParserSession UnsupportedVectorBackendPS = new ParserSession(UnsupportedVectorBackend, null);
        UnsupportedVectorBackendPS.addDependencySchema(Core);
        UnsupportedVectorBackend._DBCompatibility.validate(UnsupportedVectorBackendPS, UnsupportedVectorBackend);
        UnsupportedVectorBackend._DBCompatibility.resolveEntityTargets(UnsupportedVectorBackendPS, UnsupportedVectorBackend);
        UnsupportedVectorBackend._DBCompatibility.validateIndexDetails(UnsupportedVectorBackendPS, UnsupportedVectorBackend);
        if (UnsupportedVectorBackendPS.getErrors().stream().anyMatch(error -> error.contains("does not support vector indices")) == false
        || UnsupportedVectorBackendPS.getErrors().stream().anyMatch(error -> error.contains("no details for database")) == true)
          throw new IllegalStateException("An unsupported vector-index backend was not reported distinctly: " + UnsupportedVectorBackendPS.getErrors());

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

        Schema Excepted = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"CohortMartX\"],\"views\":[],\"fkEnforcementExceptions\":[\"CohortMartX.CohortDefinitionFK\"]}]}}", "test.data", "EXCEPTED");
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

        Schema ExceptedAll = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"Source\"],\"views\":[],\"fkEnforcementExceptions\":[\"Source\"]}]}}", "test.data", "EXCEPTEDALL");
        ExceptedAll._DependencySchemas.add(Core);
        Object AllSource = addObject(ExceptedAll, "Source");
        Object AllDestination1 = addObject(ExceptedAll, "Destination1");
        Object AllDestination2 = addObject(ExceptedAll, "Destination2");
        ForeignKey AllFK1 = addForeignKey(AllSource, "RefFK1", AllDestination1);
        ForeignKey AllFK2 = addForeignKey(AllSource, "RefFK2", AllDestination2);
        ParserSession ExceptedAllPS = new ParserSession(ExceptedAll, null);
        ExceptedAllPS.addDependencySchema(Core);
        if (ExceptedAll._DBCompatibility.validate(ExceptedAllPS, ExceptedAll) == false)
          throw new IllegalStateException("Object-wide FK exception did not validate: " + ExceptedAllPS.getErrors());
        ExceptedAll._DBCompatibility.resolveEntityTargets(ExceptedAllPS, ExceptedAll);
        ExceptedAll._DBCompatibility.validateForeignKeysAndViewDependencies(ExceptedAllPS, ExceptedAll);
        if (ExceptedAllPS.getErrorCount() != 0 || AllFK1._EnforcementExceptionDBs.contains("bigquery") == false || AllFK2._EnforcementExceptionDBs.contains("bigquery") == false)
          throw new IllegalStateException("Object-wide FK exception did not expand to every FK: " + ExceptedAllPS.getErrors());

        Schema Overlapping = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"Source\"],\"views\":[],\"fkEnforcementExceptions\":[\"Source\",\"Source.RefFK\"]}]}}", "test.data", "OVERLAPPING");
        Overlapping._DependencySchemas.add(Core);
        Object OverlappingSource = addObject(Overlapping, "Source");
        Object OverlappingDestination = addObject(Overlapping, "Destination");
        addForeignKey(OverlappingSource, "RefFK", OverlappingDestination);
        ParserSession OverlappingPS = new ParserSession(Overlapping, null);
        OverlappingPS.addDependencySchema(Core);
        Overlapping._DBCompatibility.validate(OverlappingPS, Overlapping);
        Overlapping._DBCompatibility.resolveEntityTargets(OverlappingPS, Overlapping);
        Overlapping._DBCompatibility.validateForeignKeysAndViewDependencies(OverlappingPS, Overlapping);
        if (OverlappingPS.getErrors().stream().anyMatch(error -> error.contains("repeats foreign key 'Source.RefFK'")) == false)
          throw new IllegalStateException("An object-wide and explicit duplicate FK exception was not rejected: " + OverlappingPS.getErrors());

        Schema NoFK = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"Source\"],\"views\":[],\"fkEnforcementExceptions\":[\"Source\"]}]}}", "test.data", "NOFK");
        NoFK._DependencySchemas.add(Core);
        addObject(NoFK, "Source");
        ParserSession NoFKPS = new ParserSession(NoFK, null);
        NoFKPS.addDependencySchema(Core);
        NoFK._DBCompatibility.validate(NoFKPS, NoFK);
        NoFK._DBCompatibility.resolveEntityTargets(NoFKPS, NoFK);
        NoFK._DBCompatibility.validateForeignKeysAndViewDependencies(NoFKPS, NoFK);
        if (NoFKPS.getErrors().stream().anyMatch(error -> error.contains("declares no foreign keys")) == false)
          throw new IllegalStateException("Object shorthand without foreign keys was not rejected: " + NoFKPS.getErrors());

        Schema Redundant = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"Source\",\"Destination\"],\"views\":[],\"fkEnforcementExceptions\":[\"Source.RefFK\"]}]}}", "test.data", "REDUNDANT");
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

        Schema UnknownFK = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"Source\"],\"views\":[],\"fkEnforcementExceptions\":[\"Source.MissingFK\"]}]}}", "test.data", "UNKNOWNFK");
        UnknownFK._DependencySchemas.add(Core);
        addObject(UnknownFK, "Source");
        ParserSession UnknownFKPS = new ParserSession(UnknownFK, null);
        UnknownFKPS.addDependencySchema(Core);
        UnknownFK._DBCompatibility.validate(UnknownFKPS, UnknownFK);
        UnknownFK._DBCompatibility.resolveEntityTargets(UnknownFKPS, UnknownFK);
        UnknownFK._DBCompatibility.validateForeignKeysAndViewDependencies(UnknownFKPS, UnknownFK);
        if (UnknownFKPS.getErrorCount() == 0)
          throw new IllegalStateException("An exception naming an unknown FK was not rejected.");

        Schema RouteMismatch = parseSchema("{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"Other\"],\"views\":[],\"fkEnforcementExceptions\":[\"Source.RefFK\"]}]}}", "test.data", "ROUTEMISMATCH");
        RouteMismatch._DependencySchemas.add(Core);
        Object RouteSource = addObject(RouteMismatch, "Source");
        addObject(RouteMismatch, "Other");
        Object RouteDestination = addObject(RouteMismatch, "Destination");
        ForeignKey RouteFK = new ForeignKey();
        RouteFK._Name = "RefFK";
        RouteFK._ParentObject = RouteSource;
        RouteFK._DestObjectObj = RouteDestination;
        RouteSource._ForeignKeys.add(RouteFK);
        ParserSession RouteMismatchPS = new ParserSession(RouteMismatch, null);
        RouteMismatchPS.addDependencySchema(Core);
        RouteMismatch._DBCompatibility.validate(RouteMismatchPS, RouteMismatch);
        RouteMismatch._DBCompatibility.resolveEntityTargets(RouteMismatchPS, RouteMismatch);
        RouteMismatch._DBCompatibility.validateForeignKeysAndViewDependencies(RouteMismatchPS, RouteMismatch);
        if (RouteMismatchPS.getErrorCount() == 0)
          throw new IllegalStateException("An FK exception whose source is outside its target route was not rejected.");

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
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[],\"views\":[\"MissingView\"]}]}}", "unmatched exact view");
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"*\"],\"views\":[]},{\"db\":\"bigquery\",\"objects\":[\"A\"],\"views\":[]}]}}", "duplicate db/only route");
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"only\":true,\"objects\":[\"A\"],\"views\":[]},{\"db\":\"sqlserver\",\"only\":true,\"objects\":[\"A\"],\"views\":[]}]}}", "conflicting exclusive routes");
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"only\":true,\"objects\":[\"A\"],\"views\":[]}]}}", "exact only route");
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"only\":true,\"objects\":[\"A*\"],\"views\":[]},{\"db\":\"sqlserver\",\"objects\":[\"A\"],\"views\":[]}]}}", "exact route conflicting with wildcard only");
        assertInvalid(Core, "{\"dbCompatibility\":{\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"*\"],\"views\":[],\"fkEnforcementExceptions\":[\"Bad-Object.FK\"]}]}}", "invalid FK exception identifier");
        assertInvalid(Core, "{\"dbCompatibility\":{\"default\":[\"bigquery\"]}}", "dependent default override");

        Schema InvalidCore = parseSchema("{\"dbCompatibility\":{\"default\":[\"postgres\"],\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"*\"],\"views\":[]}]}}", "tilda.data", "TILDA");
        addObject(InvalidCore, "CoreObject");
        ParserSession InvalidCorePS = new ParserSession(InvalidCore, null);
        if (InvalidCore._DBCompatibility.validate(InvalidCorePS, InvalidCore) == true || InvalidCorePS.getErrorCount() == 0)
          throw new IllegalStateException("Core TILDA was allowed to declare non-baseline routes.");

        Schema RoutedCore = parseSchema("{\"dbCompatibility\":{\"default\":[\"postgres\"],\"targets\":[{\"db\":\"bigquery\",\"objects\":[\"MaintenanceLog\"],\"views\":[]}]}}", "tilda.data", "TILDA");
        RoutedCore._ResourceName = Schema._BASE_TILDA_SCHEMA_RESOURCE;
        Object MaintenanceLog = addObject(RoutedCore, "MaintenanceLog");
        ParserSession RoutedCorePS = new ParserSession(RoutedCore, null);
        if (RoutedCore._DBCompatibility.validate(RoutedCorePS, RoutedCore) == false)
          throw new IllegalStateException("Core TILDA could not route MaintenanceLog additively: " + RoutedCorePS.getErrors());
        RoutedCore._DBCompatibility.resolveEntityTargets(RoutedCorePS, RoutedCore);
        assertTargets(MaintenanceLog, "postgres", "bigquery");
      }

    private static Object addObject(Schema schema, String name)
      {
        Object O = new Object();
        O._Name = name;
        schema._Objects.add(O);
        return O;
      }

    private static ForeignKey addForeignKey(Object source, String name, Object destination)
      {
        ForeignKey FK = new ForeignKey();
        FK._Name = name;
        FK._ParentObject = source;
        FK._DestObjectObj = destination;
        source._ForeignKeys.add(FK);
        return FK;
      }

    private static View addView(Schema schema, String name)
      {
        View V = new View();
        V._Name = name;
        schema._Views.add(V);
        return V;
      }

    private static class VectorTestColumn extends Column
      {
        VectorTestColumn(String name)
          {
            _Name = name;
          }

        @Override
        public tilda.enums.ColumnType getType()
          {
            return tilda.enums.ColumnType.VECTOR;
          }
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