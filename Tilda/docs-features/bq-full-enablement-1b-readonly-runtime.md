# BigQuery Enablement: Phase 1b, Read-Only Runtime

## Goal

Use generated Tilda objects to read BigQuery data, replacing application-level hand-written queries where the Tilda model is a good fit. Reuse Tilda's JDBC-oriented generated factories through Google's BigQuery JDBC driver if the Phase 1a driver spike confirms the required connection, query, and result-mapping behavior.

This phase depends on Phase 1a's schema compatibility model and target-specific generated schema/migration support. It does not add BigQuery write support or key allocation.

## Scope and Boundaries

In scope:

- BigQuery JDBC driver integration through Tilda's normal connection/pooling path.
- Generated-object reads against BigQuery, including parameter binding and row hydration.
- A queryable runtime write-capability flag on the selected store/connection.
- Runtime rejection of generated write operations when the selected connection is read-only, at operation entry and before query submission.
- Tests and operational visibility for read behavior, query costs, and driver limitations.

Not in scope:

- BigQuery insert, update, delete, soft-delete, or batch-write support. The guard rejects those operations on BigQuery.
- Tilda client-side key-counter allocation for BigQuery.
- General redesign of generated JDBC code or a second execution stack unless the driver fails a concrete required behavior.
- SQL Server runtime implementation.

## Prerequisite: Phase 1a

Before starting this phase, Phase 1a should provide:

- A validated schema-level `dbCompatibility` contract and canonical database IDs.
- The core TILDA schema's inherited PostgreSQL default, additive BigQuery opt-in, and per-object routing for PostgreSQL-only, shared, or BigQuery-only tables/views.
- Per-store object selection for migration, preserving PostgreSQL-first behavior for legacy schemas and excluding BigQuery-only objects from PostgreSQL targets.
- BigQuery schemas/tables/views that can be migrated and introspected for the selected objects.
- An established BigQuery DDL/metadata access path and a recorded JDBC driver dependency/package assessment, if the spike selects the driver. Runtime `tilda.config.json` provides available connections; it does not define compatibility.

See [Phase 1a: Schema and Migration](bq-full-enablement-1a-schema-migration.md). If Phase 1a's driver spike rules out the JDBC driver for reads, resolve that blocker and select an alternate execution path before modifying generated runtime code.

## Lifecycle and Store Capability

Keep `lc` global and use it to generate the maximum API surface defined by the Tilda model:

- An object with `lc: READONLY` continues to generate reader interfaces and omit writer methods.
- An object with a writable lifecycle continues to generate writer methods.
- Do not add per-database `lc` fields or litter model JSON with BigQuery-only runtime attributes.
- A selected connection/store independently reports whether it supports writes. Expose this as a queryable runtime capability for callers and diagnostics.
- Each generated persistence operation checks the selected connection's capability immediately before work that can submit a mutation. A rejected call must fail before SQL is prepared/submitted.
- Setters and in-memory object changes do not consult store capability.

This supports a shared generated type that is writable through PostgreSQL but read-only through BigQuery. A BigQuery connection rejects its generated writer calls while the same methods remain functional on PostgreSQL. A BigQuery-only schema may still declare `lc: READONLY` and avoid exposing writer methods in the first place.

Cover every path that can persist state: object insert/create, update, delete, soft-delete, batch APIs, helper methods, and persistence through views or related abstractions where applicable. Centralize the check at an owning store/connection or shared execution boundary where possible, but ensure it happens before any mutation query is submitted. Avoid a check in every setter or only hiding methods in generated code.

The runtime flag is an API behavior contract, not a security boundary. BigQuery service credentials should be configured with read-only IAM permissions for applications that must not mutate data, especially when raw query execution is available.

## Driver and Connection Integration

Use the driver coordinate selected and pinned in Phase 1a. The current evaluation target is:

```text
com.google.cloud:google-cloud-bigquery-jdbc:1.4.0
```

Do not repeat Phase 1a's full dependency investigation unless the artifact/configuration changes. Reconfirm that the resolved and packaged dependency graph from that phase is still the one consumed by runtime. The driver is a JDBC adapter, not evidence that BigQuery has PostgreSQL transaction, constraint, indexing, or DML semantics.

Integrate through the existing `Connection`/`ConnectionPool` path where possible. Verify:

- JDBC URL parsing and database-store selection for the official driver.
- Credential discovery and secure credential configuration.
- Pool acquisition, validation, close/release, and timeouts.
- Prepared statement parameter types and result-set behavior used by generated factories.
- Cancellation and exception translation.
- BigQuery job identity/location and query bytes/billing visibility needed to diagnose application reads.

Use native BigQuery APIs only where a concrete JDBC gap requires them, such as metadata or operational properties. Do not hand-edit generated classes or add branches throughout generated output. Fix generator templates and shared runtime/store abstractions, then regenerate representative classes.

## Generated Read Compatibility

Generated factories use JDBC `PreparedStatement`/`ResultSet` patterns and shared row hydration helpers. Validate representative Tilda object reads end to end before broadening support. Include:

- Parameterized single-row and multi-row reads, filters, ordering, limits/offset behavior where supported, and joins/views.
- Null handling and Tilda scalar conversions, especially numeric precision, dates, times, timestamps, booleans, UUID/string representations, JSON, and binary values used by real models.
- Repeated/array column handling and any nested values used by the selected schema.
- Resource lifecycle and behavior for empty results, multiple rows, SQL errors, timeouts, and cancellation.
- BigQuery-specific identifier quoting, type mappings, and query syntax generated by the current dialect.

The milestone is the set of read features used by the selected application models, not blanket JDBC or PostgreSQL parity. Record unsupported query patterns rather than silently returning wrong data.

## Work Sequence

### 1. Confirm the Phase 1a Driver Result

Review the selected DDL/metadata connection strategy, pinned driver version, dependency graph, and package result. Re-run only the relevant connection check if the runtime artifact differs from the one assessed in Phase 1a.

### 2. Establish a Generated Read Baseline

Choose one representative BigQuery-compatible object and one generated read factory path. Run it through Tilda's actual connection pool against a credentialed test dataset. Capture query/job identifiers, bytes processed, latency, row counts, and mappings. Resolve concrete driver incompatibilities at the owning runtime boundary.

### 3. Expose Store Write Capability

Add a queryable capability on the selected connection/store representing whether writes are allowed/supported. Keep database identity and capability distinct: the backend may support writes generally while a particular connection is configured read-only. Define how that flag is determined from backend policy and runtime connection configuration.

### 4. Guard Persistence Entry Points

Use a common guard where the call flow permits; add targeted guards only for paths that bypass it. Reject persistence through a read-only connection before statement creation/submission, and provide a stable, actionable error. Verify PostgreSQL behavior remains unchanged. Setters must remain independent of this flag.

### 5. Validate Generated Reads and Runtime Policy

Exercise all reads needed by the selected model set and test each mutation pathway against a BigQuery connection. Keep read-path changes and write guards narrowly scoped; avoid making writes appear available just because the driver exposes JDBC mutation methods.

### 6. Document Operations and Limits

Document credential/IAM setup, BigQuery location configuration, query cost observability, supported type/query mappings, and known gaps for the first application rollout. Keep generated `READONLY` lifecycle distinct from IAM authorization.

## Repository Entry Points

Confirm exact call sites when implementation begins.

- [Connection.java](../src/tilda/db/Connection.java), [ConnectionPool.java](../src/tilda/db/ConnectionPool.java): URL selection, connection lifecycle, runtime capability access and pooling.
- [DBType.java](../src/tilda/db/stores/DBType.java), [BigQuery.java](../src/tilda/db/stores/BigQuery.java): selected backend capabilities, BigQuery dialect behavior and connection integration. Audit BigQuery cancellation/error behavior rather than assuming PostgreSQL driver internals apply.
- [TildaFactory.java](../src/tilda/generation/java8/TildaFactory.java), [TildaData.java](../src/tilda/generation/java8/TildaData.java), [Generator.java](../src/tilda/generation/Generator.java): generated reader/writer API surface, row hydration, runtime write guard placement and generated store availability.
- `Tilda/src/tilda/db/JDBCHelper.java` and row/type helpers under `Tilda/src/tilda/db/`: JDBC parameter/result conversion used by generated runtime.
- [BQJDBCTest.java](../ut/tilda/db/BQJDBCTest.java): existing BigQuery JDBC test reference. Prefer focused automated tests around shared pool/runtime behavior over relying solely on a manual test harness.
- Generated examples under `Tilda/src/tilda/data/_Tilda/` can help confirm output shape, but must be regenerated from templates/model sources rather than edited directly.
- [TildaGradleDependencies/build.gradle](../../TildaGradleDependencies/build.gradle): dependency location if the Phase 1a spike did not add the selected driver yet.

## Validation and Completion Criteria

### Driver and Read Path

- A credentialed BigQuery connection is obtained/released successfully through Tilda's actual pool.
- A generated factory executes parameterized reads against BigQuery and correctly hydrates representative Tilda types, nulls, repeated values, and empty/multiple-row results.
- Query failures, timeouts, and cancellation produce understandable Tilda errors and release resources correctly.
- Query job/location and bytes processed can be inspected so costs are diagnosable.
- Supported patterns and driver/type limitations are documented; no incorrect value conversion is accepted as a successful read.

### Runtime Write Policy

- The store/connection write capability is queryable and has a deterministic value for PostgreSQL and BigQuery configurations.
- Setters and object mutation in memory do not invoke the capability guard.
- Generated create/insert, update, delete, soft-delete, batch, and other persistence entry points reject BigQuery writes before SQL submission.
- A shared writable-lifecycle object can still write through PostgreSQL.
- `lc: READONLY` objects still expose no writer methods.
- IAM remains read-only for applications where the operational requirement is genuinely read-only access.

### Scope and Operations

- The first supported application models use generated Tilda reads rather than hand-written application queries for covered entities.
- No BigQuery key-counter lookups or writes occur in the read-only runtime.
- Measure representative job latency and billed bytes; do not report only client-side elapsed time.
- Existing PostgreSQL runtime and generated-code tests pass after shared changes.

## Deferred/Open Decisions

- Exact source and precedence for a connection's runtime write-capability flag: backend intrinsic support, explicit read-only connection configuration, or both. Define this without adding backend-specific lifecycle properties to schema JSON.
- Exact exception type/message and whether callers can preflight write support in addition to receiving the operation-time rejection.
- The required read/query feature subset for the first application model and its actual Tilda types/views.
- Whether driver cancellation and job metadata need a native client side channel.
- BigQuery write semantics, key allocation, idempotency, concurrency, and DML cost are intentionally deferred to a separate future phase.

## Resume Checklist

1. Verify [Phase 1a](bq-full-enablement-1a-schema-migration.md) is complete enough to create/migrate the selected BigQuery model and provides a measured driver decision.
2. Confirm the current runtime/build artifacts match the assessed driver dependency graph.
3. Run one generated BigQuery read through Tilda's real connection pool and record query/job/cost details.
4. Define and expose the selected connection's write capability.
5. Add operation-time guards to all persistence paths without changing setters or PostgreSQL write behavior.
6. Add focused generated-read, mapping, resource, and write-rejection tests; validate with credentials against BigQuery.
7. Document supported runtime reads and known limitations for the consuming application.

## References

- [Google Cloud BigQuery JDBC/ODBC drivers](https://cloud.google.com/bigquery/docs/reference/odbc-jdbc-drivers): driver guidance; verify the current Maven version and artifact behavior against the pinned Phase 1a result.
- [GoogleSQL DDL reference](https://docs.cloud.google.com/bigquery/docs/reference/standard-sql/data-definition-language): BigQuery schema capabilities and limits.
