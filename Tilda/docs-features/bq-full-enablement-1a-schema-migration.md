# BigQuery Enablement: Phase 1a, Schema and Migration

## Goal

Make the existing PostgreSQL-first assumption explicit, then let application schemas opt into BigQuery additively and have Tilda automate schema creation and migration there. Today BigQuery SQL artifacts are generated mainly for debugging and DBAdmin-led manual creation; Phase 1a is specifically about moving that manual schema-management workflow into Tilda's migration utility. Generated-object runtime reads are Phase 1b; Phase 1a does not enable BigQuery reads/writes through generated factories.

This phase keeps PostgreSQL as the stable inherited baseline and preserves established applications, while allowing a schema to explicitly add BigQuery as a migration target. It must support tables/views that target PostgreSQL only, PostgreSQL plus BigQuery, or BigQuery only. The initial goal is BigQuery schema lifecycle automation, not a claim of portable application runtime behavior across relational databases.

## Scope and Boundaries

In scope:

- A stable inherited PostgreSQL baseline declared centrally by the required core TILDA schema; adding backend support to Tilda must not expand this default.
- A distinction between backends implemented by Tilda and backends each application schema has explicitly opted into.
- Additive schema-level BigQuery opt-in and per-table/view routing among PostgreSQL-only, PostgreSQL-plus-BigQuery, and BigQuery-only.
- Parsing, validation, cross-schema/reference checking, and per-target migration object selection.
- Automated application and tracking of BigQuery schema DDL, replacing manual execution of generated BigQuery SQL for opted-in objects.
- BigQuery metadata acquisition and schema migration planning/application.
- BigQuery constraints and capability diagnostics.
- A bounded BigQuery SQL/JDBC connectivity and dependency spike needed to support schema DDL/metadata operations.

Not in scope:

- Generated-object BigQuery read APIs and runtime row mapping; see [Phase 1b](bq-full-enablement-1b-readonly-runtime.md).
- BigQuery inserts, updates, deletes, key allocation, or OLTP behavior.
- SQL Server implementation. The model must be generic enough to support SQL Server later.
- Automatic table recreation or data-copy migrations for unsupported schema changes.

## Compatibility Contract

Declare the platform baseline in the core TILDA schema, which application schemas already load as a required dependency. The TILDA schema sets `dbCompatibility.default` to `["postgres"]`. Application schemas inherit this baseline without restating it. This makes the current assumption explicit in the next Tilda version while leaving existing application definitions unchanged. Treat this as a stable compatibility policy, not as a list of every backend Tilda can implement: introducing SQL Server support in Tilda must not change the core default to `["postgres", "sqlserver"]` or otherwise make dependent schemas implicitly claim SQL Server compatibility.

Backend implementation availability and schema compatibility are separate. Tilda's backend registry/capabilities describe which stores Tilda can generate for or operate against. Each application schema must explicitly opt into non-default backends it intends to use; having a configured connection or using a Tilda release that implements a backend is not an opt-in. BigQuery is the first such opt-in in this phase. An application schema can add BigQuery as a schema-level target, and individual tables/views choose among:

- The inherited default only (PostgreSQL).
- The inherited default plus BigQuery (PostgreSQL and BigQuery).
- BigQuery only (an explicit replacement of the object's inherited targets).

The initial schema-level contract uses `dbCompatibility.default` for the stable core baseline and `dbCompatibility.additional` for local opt-ins. The core TILDA schema declares only `default: ["postgres"]`; dependencies supply the inherited default, while `additional` is never inherited. The initial POJO validates IDs against backends registered in Tilda and rejects non-core default declarations. Object-level `include`/`only` routing remains the next compatibility-model slice. The conceptual shape is:

```json
{
  "dbCompatibility": {
    "additional": ["bigquery"]
  },
  "objects": [
    { "name": "PG_TABLE", "columns": [] },
    { "name": "SHARED_TABLE", "dbCompatibility": { "include": ["bigquery"] }, "columns": [] },
    { "name": "BQ_ONLY_TABLE", "dbCompatibility": { "only": ["bigquery"] }, "columns": [] }
  ]
}
```

The TILDA-schema PostgreSQL baseline should flow to dependent schemas through the existing schema dependency graph (see `Schema.setDefaultDependencies` and `Schema._DependencySchemas`), not through runtime `tilda.config.json`. Do not inherit future backend availability as schema compatibility. A child explicitly opts into additional targets such as BigQuery, then routes its objects; the per-object `only` form is the narrow exception that replaces the object's inherited PostgreSQL target to allow a BQ-only object. Define deterministic handling of object compatibility across other schema dependencies without allowing a dependency's newly implemented backend to silently broaden the child's compatibility.

Canonical backend IDs must map consistently to Tilda's `DBType` registry and JDBC URL handling. Establish values such as `postgres` and `bigquery` from current backend names before fixing the JSON contract. Keep the registry of implemented backends distinct from the schema's explicit compatibility targets. Do not infer model compatibility from arbitrary URL strings.

Keep schema placement distinct from runtime portability certification. The inherited PostgreSQL default makes the current baseline explicit; it does not prove every application view clause, expression, aggregate, or custom SQL string works on another backend. In particular, PostgreSQL-to-SQL-Server support requires certifying Tilda's required schemas and runtime paths, as well as application-defined database-specific artifacts. Phase 1a's BigQuery opt-in means that schema DDL/migration is managed for selected objects; it does not certify generated-object reads or all application queries on BigQuery.

For legacy schemas with no new declarations, preserve current PostgreSQL-first behavior. Define a clear migration/adoption rule for declarations that opt into the new contract. Validate duplicate/unknown backend IDs, duplicate/missing object names, invalid route combinations, and references to objects unavailable on a target. A view or foreign key must not silently depend on an omitted table/view; apply the same checks across schema dependencies.

Runtime `tilda.config.json` serves a different role: it supplies concrete connections for runtime operations and is not guaranteed during generation. At migration runtime, resolve configured connection URLs to actual `DBType`s and intersect those available targets with the schema/object targets. A connection does not opt a schema into a backend. If a migration explicitly requests BigQuery but no BigQuery connection exists, fail clearly; do not silently skip it. Existing empty PostgreSQL development databases remain useful: objects declared BigQuery-only are excluded from PostgreSQL migration, while PostgreSQL-only/shared objects remain visible to PostgreSQL development and validation.

## Schema Generation

BigQuery SQL files are currently generated mainly as DBAdmin/debug artifacts for manual application. Keep those artifacts available, but make the migration utility able to apply and track the same supported BigQuery changes for explicitly opted-in objects. Schema generation is already mostly present: inventory its PostgreSQL and BigQuery outputs and then make only changes needed for routing and migration parity.

- Resolve each table/view's effective targets from the stable inherited PostgreSQL baseline, explicitly opted-in schema-level additional targets, and object-level include/only routing. Never add a backend to effective targets merely because a later Tilda release implements it.
- Preserve existing generated output for legacy schemas that have not adopted the new declaration.
- Do not require a PostgreSQL connection/database to exist for a BQ-only object. A local PostgreSQL development database can continue to host the PG-only/shared portion of an opted-in schema.
- Keep generated Java objects as generated output; edit templates and source model definitions, then regenerate.
- Do not conflate an object's global lifecycle (`lc`) with database compatibility. Lifecycle/API behavior is handled at runtime in Phase 1b.
- Ensure database-specific key/index/constraint DDL is emitted only where the backend supports it.

## BigQuery Constraints and DDL

BigQuery supports primary and foreign key declarations only as `NOT ENFORCED`. Preserve these declarations when the Tilda model includes them and BigQuery supports their representation. Capture, compare, create, and drop them during migration. They remain metadata/optimizer declarations, not database-enforced primary-key uniqueness or referential integrity.

GoogleSQL's table-constraint grammar has no general `UNIQUE` constraint. Therefore:

- Never translate a Tilda UNIQUE index into an alleged BigQuery unique constraint.
- Never report physical uniqueness enforcement as successful on BigQuery.
- Preserve logical unique/index metadata for Tilda validation or query planning only where useful, and explicitly report unsupported physical behavior.
- Distinguish BigQuery search/vector indexes from ordinary Tilda relational indexes.

Audit `supportsPrimaryKeys`, `supportsForeignKeys`, `supportsIndices`, migration `handleKeys`/`handleIndices`, and BigQuery's existing DDL generation. An unsupported request must not return success without applying the behavior, nor recur indefinitely as a migration no-op.

Implement capability-aware planning for BigQuery-supported schema changes, including dataset/table/view creation, nullable/repeated-column additions, required-to-nullable relaxation, supported type widening, descriptions/defaults, allowed renames/drops, and NOT ENFORCED PK/FK changes. Report unsupported cases explicitly. Examples include adding a required column to an existing table, restrictive type changes, nested-field drops, renaming constrained columns, and physical unique constraints.

Permanent BigQuery DDL is not a transactionally atomic migration. Each action must be observable, independently applicable, safe to retry/re-analyze, and recoverable after partial failure. Do not claim PostgreSQL transaction semantics for a series of permanent DDL statements. Defer automatic table recreation/data movement until a separate policy covers data preservation, cost, and operational approval.

## Metadata Strategy

Keep the existing normalized Tilda metadata model as the migration boundary where practical:

1. Use JDBC `DatabaseMetaData` only for metadata shown to be accurate for the selected BigQuery driver and object type.
2. Add BigQuery `INFORMATION_SCHEMA` or native API acquisition for incomplete JDBC metadata, especially constraints and table/view properties.
3. Normalize into current database/table/column/PK/FK/index metadata classes.
4. Keep BigQuery-specific queries and API calls behind a provider/capability boundary; do not spread them throughout migration comparison logic.
5. Compare only objects compatible with the current target database.

A JDBC metadata call returning successfully is not proof its result is complete or equivalent to PostgreSQL. Verify against a credentialed test dataset.

## Work Sequence

### 1. Inventory Existing Generation and Migration

Inspect the generator's PostgreSQL/BigQuery schema output, parser conventions, metadata model, and current BigQuery migration hooks. Record which operations already work and which currently no-op or produce invalid DDL. Keep the audit limited to this phase's owning abstractions.

### 2. Verify BigQuery SQL Connectivity and Dependencies

Determine how Tilda will execute BigQuery DDL and read metadata. Evaluate Google's JDBC driver `com.google.cloud:google-cloud-bigquery-jdbc:1.4.0` through the actual Tilda connection path; compare against existing native BigQuery APIs for migration needs. If adding the driver, put it in [TildaGradleDependencies/build.gradle](../../TildaGradleDependencies/build.gradle) under the existing `com.google.cloud:libraries-bom:26.45.0` platform unless dependency resolution proves otherwise. This is the migration tool's execution-path decision, not generated BigQuery application runtime support.

The published JDBC implementation includes BigQuery/Storage clients, Arrow, gRPC, HTTP, and telemetry components. Tilda already uses BigQuery/Storage clients, so measure the incremental resolved and packaged size instead of summing the driver's published dependencies. Check version convergence, conflicts, duplicate jars, and the project's dependency-copy/package output. Do not change the BOM or choose an all-in-one classifier without evidence. Phase 1b will reuse the result for generated reads.

### 3. Add Compatibility Model and Validation

Add the stable `default: ["postgres"]` baseline to the core TILDA schema and implement its inheritance through schema dependencies. Keep backend implementation availability separate from that inherited baseline. Add an explicit BigQuery opt-in for application schemas and per-object/view target choices for inherited-default-only, inherited-default-plus-BigQuery, and BigQuery-only. Test legacy schemas, baseline inheritance, explicit opt-in, object routing, conflicts, and store-specific references before migration changes. Include a regression test/model proving that adding a backend to Tilda's implementation registry does not implicitly add it to dependent application schemas.

### 4. Route Schema Generation and Migration

Pass the actual migration target and each object's resolved membership into schema generation and migration. At runtime, use configured connections only to discover executable targets; require an explicit migration selection when multiple target classes are configured, and report requested-but-unavailable targets. Ensure only compatible objects are migrated on a store. Preserve legacy behavior when compatibility is unspecified.

### 5. Normalize Metadata and Implement Migration Actions

Add or refine BigQuery metadata providers and DDL actions. Support safe operations, preserve `NOT ENFORCED` PK/FK metadata, and emit clear diagnostics for unsupported changes. Ensure operations are idempotent or report partial application accurately.

### 6. Test and Document

Add tests for inherited default resolution, BigQuery opt-in, per-object routing, cross-store dependencies, legacy compatibility, metadata normalization, constraint planning, supported DDL, unsupported operations, and migration re-analysis. Include credentialed integration checks for BigQuery metadata and actual DDL. Demonstrate adoption of a representative schema that was previously created/migrated manually from generated BQ SQL. Keep PostgreSQL schema-generation and migration regressions green.

## Repository Entry Points

These are expected ownership boundaries; verify exact call sites during implementation.

- [TildaJsonSchema.json](../src/tilda/TildaJsonSchema.json), [Schema.java](../src/tilda/parsing/parts/Schema.java), [Object.java](../src/tilda/parsing/parts/Object.java): JSON shape, compatibility model, parsing and semantic validation.
- [DBType.java](../src/tilda/db/stores/DBType.java), [BigQuery.java](../src/tilda/db/stores/BigQuery.java), [CommonStoreImpl.java](../src/tilda/db/stores/CommonStoreImpl.java), [PostgreSQL.java](../src/tilda/db/stores/PostgreSQL.java): backend capabilities, dialect DDL and store-specific operations.
- [Generator.java](../src/tilda/generation/Generator.java), [Sql.java](../src/tilda/generation/bigquery/Sql.java): target-specific schema generation and BigQuery DDL.
- [DatabaseMeta.java](../src/tilda/db/metadata/DatabaseMeta.java), [TableMeta.java](../src/tilda/db/metadata/TableMeta.java), and other metadata types under `src/tilda/db/metadata/`: normalized migration input.
- [Migrator.java](../src/tilda/migration/Migrator.java) and migration actions under `src/tilda/migration/actions/`: target filtering, comparison, action planning/application and unsupported-operation reporting.
- [BQHelper.java](../src/tilda/utils/gcp/BQHelper.java), [Export.java](../src/tilda/Export.java): native BigQuery helpers and existing transfer paths.
- `Tilda/src/tilda/data/_tilda.Tilda.json`: source model examples. Do not edit generated classes under `Tilda/src/tilda/data/_Tilda/` directly.
- [MigrateTest.java](../ut/tilda/MigrateTest.java), [BQJDBCTest.java](../ut/tilda/db/BQJDBCTest.java): existing migration/JDBC test references.

## Acceptance Criteria

- The core TILDA schema declares the stable PostgreSQL platform baseline, and application schemas inherit it through existing schema dependencies without repeating it.
- Backend implementation availability is distinct from schema compatibility: adding a backend to Tilda does not silently add it to the core default or to dependent application schemas; an application must explicitly opt in.
- BigQuery opt-in is additive and does not remove PostgreSQL from the inherited default.
- Each opted-in table/view can target PostgreSQL only, PostgreSQL plus BigQuery, or BigQuery only. BQ-only objects are not required to exist in a local PostgreSQL development database.
- Legacy application schemas without compatibility declarations retain their current PostgreSQL-first behavior.
- Invalid/unknown backend IDs, conflicting inheritance, malformed routes, nonexistent objects, and unavailable cross-store dependencies produce useful diagnostics.
- `tilda.config.json` supplies runtime migration connections only. Generation works without it; migration selects/validates available connections against declared targets and fails clearly for an explicitly requested but unavailable backend.
- The migration utility applies and tracks BigQuery schema changes for opted-in objects, replacing the prior manual execution workflow for supported changes.
- Generation and migration analyze only compatible objects for each target database.
- BigQuery PK/FK constraints are preserved and round-trip as `NOT ENFORCED`; tests do not mistake them for enforced integrity.
- Physical UNIQUE constraints/indexes are explicitly unsupported, never emitted as invalid DDL or reported as applied.
- Supported migration actions apply successfully, and a second analysis is clean. Unsupported cases are diagnosed; interrupted migrations can be resumed/re-analyzed without false success.
- Dependency graph/package effects for the chosen DDL/metadata access path are measured and recorded.
- Existing PostgreSQL generation and migration regressions pass.

## Deferred/Open Decisions

- Exact representation and semantics for per-object include/only routes and their interaction with cross-schema object dependencies.
- How object compatibility is resolved across non-core schema dependencies; dependencies must not silently broaden a child's targets when Tilda adds backend support.
- Compatibility semantics for objects in dependent schema files and all view/FK dependency types.
- JDBC versus `INFORMATION_SCHEMA` versus native API on a metadata-type-by-type basis; choose based on tested results.
- Whether DDL should be executed by the JDBC driver or native BigQuery jobs API; decide based on a small spike and operational needs.
- Safe automatic table recreation/data-copy policy for unsupported changes.
- SQL Server support, which should use the same compatibility contract but is not part of this phase.

## Resume Checklist

1. Check current branch/worktree and determine whether compatibility/migration work has already begun.
2. Inventory existing BigQuery SQL artifact generation and migration behavior; identify the manual admin workflow, concrete no-ops, and invalid DDL.
3. Confirm that the core TILDA schema is injected as a dependency for every application schema, then resolve stable-baseline inheritance, explicit additive opt-in, and object-routing semantics before parser changes. Verify backend implementation registration cannot expand inherited application targets.
4. Verify the BigQuery DDL/metadata access path and measure dependency/package impact.
5. Implement stable PostgreSQL baseline inheritance, explicit BigQuery opt-in, compatibility validation, and per-store generation/migration filtering without coupling schema defaults to backend registration.
6. Add normalized metadata, PK/FK handling, and explicit unsupported-operation diagnostics.
7. Adopt one formerly manual BigQuery schema and run focused unit, BigQuery integration, and PostgreSQL regression checks before declaring Phase 1a complete.
8. Only then begin [Phase 1b](bq-full-enablement-1b-readonly-runtime.md).

## References

- [GoogleSQL DDL reference](https://docs.cloud.google.com/bigquery/docs/reference/standard-sql/data-definition-language): table constraints and supported DDL.
- [BigQuery primary and foreign keys](https://docs.cloud.google.com/bigquery/docs/primary-foreign-keys): `NOT ENFORCED` semantics and optimizer use.
