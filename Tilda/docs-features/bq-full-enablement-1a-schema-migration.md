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

The schema-level contract uses one `dbCompatibility` object. The core TILDA schema declares only `default: ["postgres"]`; application schemas inherit that stable PostgreSQL baseline and must not redeclare it. Additional databases are selected centrally by route entries. `only` defaults to false: a normal route adds the named database while retaining PostgreSQL. `only: true` may replace inherited/additive targets only when an entity matched through a wildcard selector. An exact entity selector that conflicts with an exclusive route is an error. Adding a backend to Tilda does not add it to any schema automatically.

```json
{
  "dbCompatibility": {
    "targets": [
      { "db": "bigquery", "objects": ["*"], "views": ["*"] },
      { "db": "bigquery", "only": true, "objects": ["C*"], "views": [] }
    ],
    "fkEnforcementExceptions": [
      { "db": "bigquery", "fks": ["CohortMartX.CohortDefinitionFK"] }
    ]
  },
  "objects": [
    { "name": "A", "columns": [] },
    { "name": "B", "columns": [] },
    { "name": "C", "columns": [] }
  ]
}
```

The TILDA-schema PostgreSQL baseline flows to dependent schemas through the existing schema dependency graph (see `Schema.setDefaultDependencies` and `Schema._DependencySchemas`), not through runtime `tilda.config.json`. Route patterns select objects/views in the declaring schema; support exact names, `*`, prefix patterns such as `a*`, and suffix patterns such as `*a`, case-insensitively. A normal route adds its database to the PostgreSQL baseline. An `only: true` route replaces the baseline for wildcard-matched entities; exact selectors that conflict with that override and overlapping exclusive routes are errors. Use a wildcard selector, even when it expands to one entity, to carve out a BigQuery-only entity. Do not inherit target routes from dependencies or infer compatibility from backend availability.

Database placement and FK enforcement are separate. A foreign key whose source and destination are both present on a target follows normal backend behavior. If the source is present but its destination is not, validation fails unless that specific FK is listed under `fkEnforcementExceptions` for that database. The exception retains the logical relationship but omits physical FK DDL on that database; it does not mean `NOT ENFORCED`. For example, a mart can retain a real PostgreSQL FK to `CohortDefinition` while the BigQuery mart stores only `cohortRefnum`. If both ends become available on that database, an exception is invalid/redundant and normal FK handling applies. View dependencies must be compatible with every target on which the view is routed; no view exception is defined in Phase 1a.

Canonical backend IDs must map consistently to Tilda's `DBType` registry and JDBC URL handling. Establish values such as `postgres` and `bigquery` from current backend names before fixing the JSON contract. Keep the registry of implemented backends distinct from the schema's explicit compatibility targets. Do not infer model compatibility from arbitrary URL strings.

Keep schema placement distinct from runtime portability certification. The inherited PostgreSQL default makes the current baseline explicit; it does not prove every application view clause, expression, aggregate, or custom SQL string works on another backend. In particular, PostgreSQL-to-SQL-Server support requires certifying Tilda's required schemas and runtime paths, as well as application-defined database-specific artifacts. Phase 1a's BigQuery opt-in means that schema DDL/migration is managed for selected objects; it does not certify generated-object reads or all application queries on BigQuery.

For legacy schemas with no new declarations, preserve current PostgreSQL-first behavior. Define a clear migration/adoption rule for declarations that opt into the new contract. Validate duplicate/unknown backend IDs, duplicate/missing object names, invalid route combinations, and references to objects unavailable on a target. A view or foreign key must not silently depend on an omitted table/view; apply the same checks across schema dependencies.

Runtime `tilda.config.json` serves a different role: it supplies concrete connections for runtime operations and is not guaranteed during generation. At migration runtime, resolve configured connection URLs to actual `DBType`s and intersect those available targets with the schema/object targets. A connection does not opt a schema into a backend. If a migration explicitly requests BigQuery but no BigQuery connection exists, fail clearly; do not silently skip it. Existing empty PostgreSQL development databases remain useful: objects declared BigQuery-only are excluded from PostgreSQL migration, while PostgreSQL-only/shared objects remain visible to PostgreSQL development and validation.

## Generation and Migration Boundaries

`Gen` and `Migrate` have different inputs and responsibilities. `Gen` receives explicit TILDA JSON definition file paths, loads and validates their dependencies, and generates artifacts for those requested schemas. It must not scan the classpath for all schemas or depend on runtime connection configuration. `Migrate` discovers schemas from the runtime classpath and applies changes to the unique datasource pools configured in `tilda.config.json`.

For `Gen`, preserve the existing Java and PostgreSQL generation behavior. After compatibility validation succeeds, filter only BigQuery artifacts by each entity's resolved target:

- Generate the existing per-entity BigQuery schema JSON files under `_tilda/bigquery/` only for entities routed to BigQuery. Do not create these files for PostgreSQL-only entities.
- Generate `TILDA___Schema.<schema>.BigQuery.sql` with DDL only for BigQuery-routed objects and views. Do not include PostgreSQL-only entities in this file.
- Do not generate BigQuery artifacts for entities not routed to BigQuery. If no entities in a schema target BigQuery, do not leave a stale BigQuery artifact from an earlier generation.
- Run the existing strict `dbCompatibility` and cross-entity validation before writing generated artifacts. Any validation error fails `Gen` for that requested schema; do not generate a partially valid result.
- Continue to generate Java model classes as today. Compatibility controls database schema artifacts, not the global generated API surface or lifecycle (`lc`); BigQuery runtime reads remain Phase 1b.
- Preserve PostgreSQL output for legacy schemas using the inherited PostgreSQL baseline. Do not require a PostgreSQL database or connection for a BigQuery-only entity.

For `Migrate`, `tilda.config.json` is the complete source of configured migration connections; do not add CLI target selection. `ConnectionPool` iterates its unique datasource IDs, deduplicating connection aliases that resolve to the same pool (for example, `MAIN` and `KEYS` when they share a datasource signature). Each distinct pool is handled independently. Its connection URL/driver determines the actual DB type; declared entity compatibility determines which schemas and entities that connection may migrate. Do not infer compatibility from the connection ID or let a configured connection opt a schema into a backend.

- Keep the existing no-argument CLI and config-driven datasource iteration. Do not introduce connection-ID arguments or make `MAIN` the sole implicit target.
- Migrate each unique configured datasource pool independently, using its detected DB type and only compatible schema entities. A configured connection does not opt schemas into that backend.
- Preserve classpath discovery and validation of TILDA schemas; runtime connections are migration execution targets, not schema-discovery inputs.
- Ensure each configured BigQuery datasource runs dataset-level schema planning/application for compatible objects and views, while PostgreSQL datasources continue through the existing PostgreSQL migration path.

## BigQuery Constraints and DDL

BigQuery supports primary and foreign key declarations only as `NOT ENFORCED`. Preserve these declarations when the Tilda model includes them and BigQuery supports their representation. Capture, compare, create, and drop them during migration. They remain metadata/optimizer declarations, not database-enforced primary-key uniqueness or referential integrity.

GoogleSQL's table-constraint grammar has no general `UNIQUE` constraint. Therefore:

- Never translate a Tilda UNIQUE index into an alleged BigQuery unique constraint.
- Never report physical uniqueness enforcement as successful on BigQuery.
- Preserve logical unique/index metadata for Tilda validation or query planning only where useful, and explicitly report unsupported physical behavior.
### VECTOR Columns and Indexes

TILDA already models `VECTOR(n)` columns and requires each vector column to be covered by an index. The current index declaration can also carry PostgreSQL-specific vector settings in a column modifier. PostgreSQL turns these into pgvector indexes (`ivfflat` or `hnsw`) with PostgreSQL-specific operator classes and options.

BigQuery has a related but not equivalent use case: TILDA emits vector columns as `ARRAY<FLOAT64>`, while BigQuery creates a separate `CREATE VECTOR INDEX` using IVF or TreeAH and options such as distance type, index-specific configuration, stored columns, and optional partitioning. PostgreSQL settings must not be silently translated to BigQuery settings; for example, PostgreSQL `hnsw` does not imply BigQuery TreeAH.

Phase 1a should consider BigQuery vector-column and vector-index support, but the JSON contract and compatibility behavior are not decided. One likely direction is optional database-specific index details, preserving the common index declaration while attaching backend-specific options, analogous to TILDA's database-aware SQL/where-clause variants in view and query definitions. Compare this with a typed, portable index model plus backend option blocks before choosing.

Review backward compatibility before choosing: existing PostgreSQL index JSON and modifier behavior must continue unchanged; decide whether BigQuery vector indexes need explicit backend settings, a portable subset/defaults, or a clear missing-settings diagnostic; and include backend-specific kind/options in migration comparisons. Keep database-only indexes non-destructive. BigQuery's physical `ARRAY<FLOAT64>` metadata must also normalize as TILDA `VECTOR`, not an ordinary collection, and vector-index metadata should be acquired at dataset scope where possible rather than forced into ordinary JDBC index metadata.

Do not implement a new JSON shape or claim BigQuery vector-index support complete until the options and PostgreSQL backward-compatibility effects have been reviewed.

Audit `supportsPrimaryKeys`, `supportsForeignKeys`, `supportsIndices`, migration `handleKeys`/`handleIndices`, and BigQuery's existing DDL generation. An unsupported request must not return success without applying the behavior, nor recur indefinitely as a migration no-op.

Implement capability-aware planning for BigQuery-supported schema changes, including dataset/table/view creation, nullable/repeated-column additions, required-to-nullable relaxation, supported type widening, descriptions/defaults, allowed renames/drops, and NOT ENFORCED PK/FK changes. Report unsupported cases explicitly. Examples include adding a required column to an existing table, restrictive type changes, nested-field drops, renaming constrained columns, and physical unique constraints.

Permanent BigQuery DDL is not a transactionally atomic migration. Each action must be observable, independently applicable, safe to retry/re-analyze, and recoverable after partial failure. Do not claim PostgreSQL transaction semantics for a series of permanent DDL statements. Defer automatic table recreation/data movement until a separate policy covers data preservation, cost, and operational approval.

## Metadata Strategy

Keep the existing normalized Tilda metadata model as the migration boundary where practical:

1. Use JDBC `DatabaseMetaData` only for metadata shown to be accurate for the selected BigQuery driver and object type.
2. Add BigQuery `INFORMATION_SCHEMA` or native API acquisition for incomplete JDBC metadata, especially constraints and table/view properties.
3. Normalize into current database/table/column/PK/FK/index metadata classes where they represent source semantics; use a BigQuery-specific vector-index representation if generic index metadata would lose index kind/options.
4. Keep BigQuery-specific queries and API calls behind a provider/capability boundary; do not spread them throughout migration comparison logic.
5. Compare only objects compatible with the current target database.

A JDBC metadata call returning successfully is not proof its result is complete or equivalent to PostgreSQL. Verify against a credentialed test dataset.

## Work Sequence

Implement the remaining Phase 1a work in this order. Finish and validate each stage before starting the next.

### 1. Complete the Gen Utility Path

The compatibility model and strict validation are in place. First finish the `Gen` integration, without changing its explicit-file input model:

1. Confirm compatibility validation errors terminate generation before output is written.
2. Keep existing Java and PostgreSQL outputs unchanged.
3. Emit the existing per-entity BigQuery schema JSON only for BigQuery-routed objects/views under `_tilda/bigquery/`.
4. Emit the BigQuery SQL file only when there are BigQuery-routed entities, and include only those objects and views.
5. Verify repeated generation removes stale BigQuery files when routes change or no entities remain BigQuery-compatible.
6. Test exact, wildcard, additive, wildcard-exclusive, and invalid routes against both generated artifact sets.

Do not modify migration connection selection or BigQuery metadata/actions during this stage.

### 2. Integrate the Existing Config-Driven Migrate Path

After the `Gen` path is stable, keep the existing no-argument CLI and datasource iteration. `tilda.config.json` remains the ground truth for which unique pools Migrate processes:

1. Preserve iteration over unique datasource IDs assembled by `ConnectionPool`; do not add CLI target arguments or change the configured target set.
2. Preserve existing pool deduplication. If `MAIN` and `KEYS` resolve to the same datasource signature, migrate that pool once; distinct datasource pools are handled independently.
3. For every pool, detect the actual backend from its established connection/dialect path and filter schema migration by effective entity compatibility.
4. Load and validate classpath schemas independently of the datasource iteration, then build and apply a plan for each distinct pool.
5. Keep connection presence independent of schema opt-in: a configured BigQuery pool does not route any entities to BigQuery by itself.

Regression coverage must include a normal `MAIN` PostgreSQL setup, a shared `MAIN`/`KEYS` pool, distinct configured pools, and a configured BigQuery pool.

### 3. Implement BigQuery Dataset Migration

Add the BigQuery migration path for compatible entities on each configured BigQuery datasource:

1. Determine the supported DDL execution path and verify each configured BigQuery connection can execute it.
2. Acquire and normalize BigQuery dataset/table/view/column/constraint metadata.
3. Before implementing vector-index actions, review and decide the database-specific index-details contract described above; keep the current PostgreSQL JSON form backward compatible.
4. If approved for Phase 1a, acquire BigQuery vector-index definitions/options and plan/apply dataset-level DDL without translating PostgreSQL-specific index settings.
5. Plan and apply other dataset-level schema changes using the existing migration action boundary where practical.
6. Preserve `NOT ENFORCED` PK/FK metadata and omit only FK constraints explicitly excepted for that BigQuery target.
7. Support safe, idempotent actions; report unsupported operations and partial permanent-DDL application accurately.
8. Confirm a second migration analysis is clean after supported changes.

### 4. Validate End to End

Test `Gen` first, then config-driven Migrate iteration, then the BigQuery migration actions. Cover route filtering, stale artifact cleanup, validation failures, all configured unique datasource pools, `MAIN`/`KEYS` shared-pool deduplication, distinct configured connections, actual backend detection, metadata normalization, supported/unsupported DDL, cross-store FKs, and re-analysis. Run credentialed BigQuery integration checks where available and preserve PostgreSQL generation/migration regressions. Adopt a representative schema previously managed manually from generated BigQuery SQL.

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
- BigQuery opt-in is additive by default; only wildcard `only: true` routes can replace PostgreSQL for matched entities.
- Each table/view resolves to PostgreSQL by default unless wildcard-matched by an exclusive route; exact-name conflicts with exclusive routes are errors. BigQuery-only objects are not required to exist in a local PostgreSQL development database.
- Wildcards and exact routes resolve deterministically, and invalid/overlapping target declarations produce useful diagnostics.
- Foreign keys require source and destination co-location on each target unless the exact FK is listed in that database's `fkEnforcementExceptions`; exceptions suppress physical FK DDL only where the destination is absent.
- View dependencies must be available on every database target assigned to the view.
- Legacy application schemas without compatibility declarations retain their current PostgreSQL-first behavior.
- Invalid/unknown backend IDs, conflicting inheritance, malformed routes, nonexistent objects, and unavailable cross-store dependencies produce useful diagnostics.
- `Gen` continues to consume only explicitly supplied TILDA definition paths and dependencies; it does not scan runtime connections. It writes BigQuery schema JSON only for BigQuery-routed entities and BigQuery SQL only for BigQuery-routed objects/views; compatibility errors fail generation before output is written.
- `Migrate` keeps its existing no-argument CLI and processes all unique datasource pools configured in `tilda.config.json`; aliases sharing one datasource pool are processed once. The config remains the target list.
- For each configured datasource pool, Tilda detects the actual DB type and analyzes only compatible entities. Classpath schema discovery/validation remains independent of datasource iteration, and a configured BigQuery connection does not itself opt schemas into BigQuery.
- The migration utility applies and tracks BigQuery schema changes for opted-in objects, replacing the prior manual execution workflow for supported changes.
- Generation and migration analyze only compatible objects for each target database.
- BigQuery PK/FK constraints are preserved and round-trip as `NOT ENFORCED`; tests do not mistake them for enforced integrity.
- Physical UNIQUE constraints/indexes are explicitly unsupported, never emitted as invalid DDL or reported as applied.
- BigQuery VECTOR columns and vector indexes have a reviewed compatibility contract before implementation; existing PostgreSQL vector declarations remain backward compatible, and backend-specific settings are never silently cross-translated.
- Supported migration actions apply successfully, and a second analysis is clean. Unsupported cases are diagnosed; interrupted migrations can be resumed/re-analyzed without false success.
- Dependency graph/package effects for the chosen DDL/metadata access path are measured and recorded.
- Existing PostgreSQL generation and migration regressions pass.

## Deferred/Open Decisions

- BigQuery VECTOR index schema design: compare database-specific index details with typed portable fields plus backend option blocks; decide how existing PostgreSQL modifiers coexist, what BigQuery defaults are valid, and how backend-specific options participate in migration comparison. Leave unresolved until backward compatibility has been reviewed.
- Whether Phase 1a supports route patterns that refer to objects in dependent schema files; initial implementation scopes route patterns to the declaring schema.
- Whether cross-store logical FK relationships need a richer model than explicit DDL-suppression exceptions.
- JDBC versus `INFORMATION_SCHEMA` versus native API on a metadata-type-by-type basis; choose based on tested results.
- Whether DDL should be executed by the JDBC driver or native BigQuery jobs API; decide based on a small spike and operational needs.
- Safe automatic table recreation/data-copy policy for unsupported changes.
- SQL Server support, which should use the same compatibility contract but is not part of this phase.

## Resume Checklist

1. Check current branch/worktree and determine which compatibility and migration changes are already present.
2. Complete the `Gen` utility path first: verify strict compatibility validation, preserve Java/PostgreSQL output, filter per-entity BigQuery JSON and SQL by resolved entity routes, and test stale output cleanup.
3. Only after Gen is stable, integrate route filtering into the existing no-argument, config-driven Migrate path. Keep `tilda.config.json` as the target list and preserve unique-pool deduplication, including shared `MAIN`/`KEYS` datasources.
4. For each configured unique datasource pool, detect the actual database type, load/validate classpath schemas independently, and filter migration planning by compatibility.
5. Verify the BigQuery DDL/metadata access path and measure dependency/package impact, then implement dataset-level planning, metadata, safe migration actions, and explicit unsupported-operation reporting.
6. Test the full sequence: Gen route/output cases, config-driven migration across distinct pools, `MAIN`/`KEYS` deduplication, BigQuery integration and re-analysis, and PostgreSQL regressions. Adopt one formerly manual BigQuery schema.
7. Only then begin [Phase 1b](bq-full-enablement-1b-readonly-runtime.md).

## References

- [GoogleSQL DDL reference](https://docs.cloud.google.com/bigquery/docs/reference/standard-sql/data-definition-language): table constraints and supported DDL.
- [BigQuery primary and foreign keys](https://docs.cloud.google.com/bigquery/docs/primary-foreign-keys): `NOT ENFORCED` semantics and optimizer use.
