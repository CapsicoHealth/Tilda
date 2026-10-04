# BigQuery Enablement Plan

The BigQuery enablement work is split into two implementation phases. Phase 1a makes the existing PostgreSQL baseline explicit, adds opt-in/additive BigQuery object routing, and automates BigQuery schema migration that is currently managed from generated SQL artifacts. Phase 1b adds generated BigQuery read access and runtime rejection of writes on read-only connections.

## Phases

- [Phase 1a: Schema and Migration](bq-full-enablement-1a-schema-migration.md) has an initial implementation of the inherited PostgreSQL baseline, opt-in BigQuery routing, route-filtered generation, config-driven migration, and BigQuery metadata/DDL. Phase 1a is not complete: BigQuery `NOT ENFORCED` PK/FK migration and broader reproducible verification remain outstanding.
- [Phase 1b: Read-Only Runtime](bq-full-enablement-1b-readonly-runtime.md) builds on 1a to use generated Tilda objects for BigQuery reads, add a queryable connection/store write-capability flag, and reject generated writes before query submission.

## Shared Decisions

- The core TILDA schema declares the stable `dbCompatibility.default: ["postgres"]`. Application schemas inherit PostgreSQL and use schema-level `dbCompatibility.targets` routes (`db`, `only`, `objects`, `views`) to add other databases or make wildcard-matched objects/views exclusive; exact-name conflicts with `only: true` are errors. `*`, prefix, and suffix patterns are supported. Registering a backend does not add it to schemas automatically.
- Foreign keys require source/destination co-location for each target unless the exact FK is listed in that database's `fkEnforcementExceptions`. Such an exception keeps the logical relationship but omits physical FK DDL only where the destination is absent; view dependencies have no such exception.
- `tilda.config.json` declares runtime connections available to perform work; it does not define compatibility or generated support. A deployment may configure only a subset of a schema's supported targets, and a configured backend may have no compatible active schemas. Migration operates on the intersection of configured connections and declared schema/object targets; this is intentional and is not an error.
- PostgreSQL as the inherited baseline records current platform behavior; it does not certify arbitrary application expressions or raw SQL as portable to another engine. SQL Server or another relational backend requires separate certification.
- Preserve existing behavior for schemas that have not opted into the new compatibility contract, and provide an adoption/migration path for previously manual BigQuery schemas.
- `lc` remains global and describes the maximum generated API surface. Do not add backend-specific lifecycle attributes. A store's runtime write capability is checked at write-operation time, never in setters.
- BigQuery primary and foreign keys are retained as `NOT ENFORCED` declarations; they do not enforce integrity. General physical `UNIQUE` constraints are not supported and must not be claimed as applied.
- The first BigQuery runtime target is read-only. BigQuery writes and Tilda key allocation are deferred. SQL Server implementation is deferred, but the compatibility model should support it.
- IAM read-only credentials provide the security boundary; generated API shape and runtime checks are not a replacement for permissions.

## Suggested Order

1. Gen compatibility validation and route-filtered BigQuery entity JSON/SQL output are implemented. Add repeatable output-level regression tests for routing and stale-artifact cleanup.
2. Initial Migrate integration uses the no-argument CLI, unique configured datasource pools, actual DB type, and compatible entities. Expand repeatable pool-selection and BigQuery migration coverage.
3. Complete BigQuery `NOT ENFORCED` PK/FK metadata and migration handling, then verify supported changes with a clean second analysis and adopt a formerly manual schema.
4. Complete Phase 1b using the driver/access-path decision and compatibility model from Phase 1a.
5. Consider SQL Server and any BigQuery write support only as separate follow-on work.

This is a planning document; see [Phase 1a status](bq-full-enablement-1a-schema-migration.md#current-status) for implemented milestones and remaining work. Implementation status does not imply that all acceptance criteria or credentialed integration checks are complete.
