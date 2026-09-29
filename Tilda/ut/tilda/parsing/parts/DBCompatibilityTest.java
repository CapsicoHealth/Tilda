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

        Schema App = parseSchema("{\"dbCompatibility\":{\"additional\":[\"bigquery\"]}}", "test.data", "APP");
        App._ResourceName = "test/data/_tilda.APP.json";
        App._DependencySchemas.add(Core);
        ParserSession AppPS = new ParserSession(App, null);
        AppPS.addDependencySchema(Core);
        if (App.validate(AppPS) == false)
          throw new IllegalStateException("Application compatibility declaration did not validate: " + AppPS.getErrors());
        if (App._DBCompatibility._ResolvedDefaultTargets.contains("postgres") == false
        || App._DBCompatibility._ResolvedTargets.contains("bigquery") == false
        || App._DBCompatibility._ResolvedTargets.contains("sqlserver") == true)
          throw new IllegalStateException("Unexpected inherited/additional targets: " + App._DBCompatibility._ResolvedTargets);

        Schema Child = parseSchema("{}", "test.data", "CHILD");
        Child._ResourceName = "test/data/_tilda.CHILD.json";
        Child._DependencySchemas.add(App);
        ParserSession ChildPS = new ParserSession(Child, null);
        ChildPS.addDependencySchema(App);
        ChildPS.addDependencySchema(Core);
        if (Child.validate(ChildPS) == false)
          throw new IllegalStateException("Dependent schema did not validate: " + ChildPS.getErrors());
        if (Child._DBCompatibility._ResolvedDefaultTargets.contains("bigquery") == true
        || Child._DBCompatibility._ResolvedTargets.contains("bigquery") == true)
          throw new IllegalStateException("A dependency's additional target leaked into its child's defaults: " + Child._DBCompatibility._ResolvedTargets);

        Schema Invalid = parseSchema("{\"dbCompatibility\":{\"additional\":[\"mysql\"]}}", "test.data", "INVALID");
        Invalid._ResourceName = "test/data/_tilda.INVALID.json";
        Invalid._DependencySchemas.add(Core);
        ParserSession InvalidPS = new ParserSession(Invalid, null);
        InvalidPS.addDependencySchema(Core);
        if (Invalid.validate(InvalidPS) == true || InvalidPS.getErrorCount() == 0)
          throw new IllegalStateException("An unregistered backend ID was not rejected.");

        Schema InvalidDefault = parseSchema("{\"dbCompatibility\":{\"default\":[\"bigquery\"]}}", "test.data", "INVALIDDEFAULT");
        InvalidDefault._ResourceName = "test/data/_tilda.INVALIDDEFAULT.json";
        InvalidDefault._DependencySchemas.add(Core);
        ParserSession InvalidDefaultPS = new ParserSession(InvalidDefault, null);
        InvalidDefaultPS.addDependencySchema(Core);
        if (InvalidDefault.validate(InvalidDefaultPS) == true || InvalidDefaultPS.getErrorCount() == 0)
          throw new IllegalStateException("A dependent schema's default override was not rejected.");

        Schema InvalidNull = parseSchema("{\"dbCompatibility\":{\"additional\":null}}", "test.data", "INVALIDNULL");
        InvalidNull._ResourceName = "test/data/_tilda.INVALIDNULL.json";
        InvalidNull._DependencySchemas.add(Core);
        ParserSession InvalidNullPS = new ParserSession(InvalidNull, null);
        InvalidNullPS.addDependencySchema(Core);
        if (InvalidNull.validate(InvalidNullPS) == true || InvalidNullPS.getErrorCount() == 0)
          throw new IllegalStateException("An explicit null additional target list was not rejected.");
      }

    private static Schema parseSchema(String json, String packageName, String schemaName)
      {
        Schema S = new Gson().fromJson(json, Schema.class);
        S._Package = packageName;
        S._Name = schemaName;
        return S;
      }
  }