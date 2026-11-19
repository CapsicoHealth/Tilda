# Full-Text Search

## Goal and Scope

Add PostgreSQL full-text index support to Tilda for PostgreSQL 15 and later. The index definition owns a hidden generated `tsvector` column and its GIN index. The artifact is managed by Tilda but is not a normal application-visible or writable Tilda column.

This phase supports PostgreSQL only. BigQuery and SQL Server are future backends, not silently accepted configurations. The index owns a hidden generated `tsvector` column and a GIN index; Java lookup methods search that artifact and return ranked model records.

## JSON Contract

Add a `fulltext` object with backend-specific details on an index:

```json
{
  "name": "DocumentSearch",
  "columns": ["documentTitle", "documentDescription"],
  "fulltext": {
    "details": [
      { "db": "postgres", "tsvectorColumn": "search_tsv", "configuration": "english" }
    ]
  }
}
```

The ordered `columns` array is the full-text source list. The index `name` remains the physical GIN index name.

Fields and defaults:

- `details` is a non-empty array of backend-specific settings. Its `db` is required and must be exactly `postgres` in this phase. Reject duplicate entries, `*`, aliases, BigQuery, SQL Server, and all other values.
- `tsvectorColumn` is required and names the PostgreSQL generated artifact column.
- `columns` is required and must contain one or more distinct scalar STRING source columns from the same Tilda object, in source order. Modifiers are not allowed.
- `configuration` defaults to `english`. Document `simple`, `english`, and other PostgreSQL text-search configurations available on the target database. Use an explicit configuration in generated SQL; do not rely on session `default_text_search_config`.

A fulltext index is a separate index kind, not an ordinary index modifier. Reject a definition containing both `fulltext` and `vector`. For v1, require a database-backed index and reject incompatible ordinary-index semantics such as uniqueness, ordering, clustering, nulls-not-distinct, and partial predicates unless a later requirement justifies them.

## Validation

`Index.validate()`:

- Reject simultaneous `vector` and `fulltext` settings.
- Requires `db`, `tsvectorColumn`, and a non-empty `columns` list; normalizes a missing `configuration` to `english`.
- Reject any backend other than `postgres`.
- Resolves every source name against the parent object. Requires scalar STRING columns; rejects collections, VECTOR/JSON/other types, calculated columns, duplicate names, and unresolved references. Nullable STRING sources are allowed and generated SQL coalesces them to empty strings.
- Validate `tsvectorColumn` as a legal identifier and reject collisions with declared columns, framework-managed columns, and artifact names from other indexes on the same table.
- Keep full-text opt-in explicit. STRING columns without a fulltext definition remain ordinary columns/indexes.
- Ensure the generated artifact is omitted from normal Java/application fields and writes, while remaining visible to database DDL and index metadata handling.

Do not add `TSVECTOR` to the general Tilda `ColumnType` enum. This is an index-owned PostgreSQL implementation artifact, not a cross-database business data type.

## Generated Java Lookup

For an index named `DocumentSearch`, the generated factory exposes `lookupWhereDocumentSearch(Connection C, String query, int maxCount)`. It returns `ListResults<DocumentData>` ordered by descending `ts_rank`, using PostgreSQL `websearch_to_tsquery` with the index's configured text-search configuration. Query text is bound as a prepared-statement value; `maxCount` must be nonnegative and less than `Integer.MAX_VALUE`, and limits the returned list. The hidden `tsvector` and rank score are not added to the model's visible fields.

## View-Level Search

A view query may use a table index marker instead of `from`, `wheres`, and `orderBy`:

```json
{
  "name": "DocumentSearch",
  "description": "Search documents visible through this view",
  "fulltext": "Document.DocumentSearch"
}
```

The referenced table must be a direct source of the view. The view must project a complete primary key or database-guaranteed unique key from that table as non-aggregated columns. Tilda adds the index value as an internal database-view column; it is not exposed as a Tilda view field. Pivot views and cascaded view sources are not supported.

The generated view factory exposes `lookupWhereDocumentSearch(Connection C, String query, int maxCount)` and returns results ranked by the referenced index. Vector markers use the same structure (`"vector": "Document.DocumentEmbedding"`), expose a `float[]` query parameter, and return the nearest rows according to the index's configured PostgreSQL distance metric. Both forms reject ordinary `from`, `wheres`, or `orderBy` clauses.

## PostgreSQL DDL

For each fulltext index, generate a hidden `tsvector` column in PostgreSQL table DDL:

```sql
"search_tsv" tsvector GENERATED ALWAYS AS (
  to_tsvector(
    'english'::regconfig,
    coalesce("documentTitle", '') || ' ' ||
    coalesce("documentDescription", '')
  )
) STORED
```

The configuration and all identifiers must be escaped/quoted safely. Join sources in declared order with spaces, coalescing each source. Explicit `STORED` is mandatory for the PostgreSQL 15+ target; virtual generated columns are not available before PostgreSQL 18.

Generate the full-text index as:

```sql
CREATE INDEX IF NOT EXISTS "DocumentSearch"
ON "DocLib_Doc" USING GIN ("search_tsv");
```

Keep the generated column and GIN index coupled to the fulltext index definition. The DDL owner should be the index-maintenance path, including the ALTER/migration flow, rather than a user-maintained SQL helper or a normal app column.

## Tilda Integration Points

- `Tilda/src/tilda/parsing/parts/Index.java`: model, validation, helper for identifying a fulltext index, and fulltext-specific definition signature.
- `Tilda/src/tilda/parsing/parts/IndexTemplate.java` and `ViewRealize.java`: copy/realize the configuration if templates are supported. Recommended v1: defer index-template support until artifact naming for expansions is unambiguous.
- `Tilda/src/tilda/parsing/parts/DBCompatibility.java`: table targets are independent of fulltext index details; a PostgreSQL index is active only when its table targets PostgreSQL.
- `Tilda/src/tilda/generation/Generator.java` and `Tilda/src/tilda/generation/postgres9/Sql.java`: create-table DDL and index DDL. Keep ordinary and vector index generation unchanged.
- `Tilda/src/tilda/db/stores/PostgreSQL.java` and narrowly scoped common store capability/methods: PostgreSQL-specific artifact and GIN generation, add/drop behavior, and introspection.
- `Tilda/src/tilda/db/metadata/IndexMeta.java`, `IndexColumnMeta.java`, `TableMeta.java`, and possibly `SchemaMeta.java`: represent discovered fulltext metadata without pretending it is a regular column-only index.
- `Tilda/src/tilda/migration/Migrator.java` and a narrowly scoped migration action if needed: reconcile the definition and order artifact-column/index changes safely.
- `Tilda/src/tilda/TildaJsonSchema.json` and `Tilda/docs-features/tilda-json-syntax-object-indices.md`: publish the syntax, defaults, constraints, and generated-artifact behavior.

## Metadata and Drift Detection

Tilda's current JDBC `DatabaseMetaData.getIndexInfo()` captures index names and key columns, but not the generated expression or its text-search configuration. PostgreSQL catalogs expose the needed facts:

- `pg_index`, `pg_class`, and `pg_am` identify the index, its name, access method, and key column.
- `pg_attribute.attgenerated` identifies a generated column and its stored/virtual kind.
- `pg_attrdef` together with `pg_get_expr(adbin, adrelid)` exposes the generated expression.
- `pg_get_indexdef()` returns PostgreSQL's deparsed index definition.

The current loading pattern is not a PostgreSQL schema-wide index query. `SchemaMeta.loadColumns()` does preload columns in bulk, but `TableMeta.load()` calls JDBC `getIndexInfo()` separately for each regular-index-capable table. BigQuery has its own schema-wide vector-index metadata query; PostgreSQL does not currently have an equivalent bulk regular-index query in Tilda. The existing per-table JDBC metadata includes an index name and key column such as `search_tsv`, but `IndexMeta` does not retain the access method as GIN, nor the generated-column expression/configuration.

Because fulltext indexes are expected to be uncommon, keep the current regular-index loading architecture. When a model table declares a fulltext index, issue one narrow PostgreSQL catalog query for that table/artifact to obtain the generated expression/configuration and confirm that the matching index uses GIN. Avoid adding an unconditional schema-wide query for every table. The query can join the index/catalog metadata to the generated-column metadata and return the index name, method, artifact key, generated kind, and `pg_get_expr()` result together.

Prefer exact dependency metadata from `pg_depend` for source-column references if PostgreSQL records the generated expression's source dependencies in a useful form. Confirm this with an integration test. Use `pg_get_expr()` as the authoritative deparsed expression and extract/compare the configuration from it. If exact dependency metadata is unavailable or unsuitable, use the requested small identifier-aware regex against the deparsed expression as a fallback; escape identifiers and test quoted names, underscores, and overlapping names. Do not build a general SQL parser or compare unnormalized raw SQL text.

Include the ordered source list and configuration in the fulltext signature. Any source-order or configuration change is definition drift. Changing the database's text-search dictionaries without changing the model is not visible as model drift; document that such changes may require `REINDEX`.

## Migration Behavior

Preserve Tilda's non-destructive migration semantics:

1. A fulltext index/artifact found in the database but absent from the model is left untouched by routine migration.
2. A fulltext definition in the model with no matching database artifact/index schedules creation, in dependency order: generated column first, GIN index second.
3. Matching artifact, GIN method, generated expression, sources, and configuration is a no-op. For this definition-level match, the physical index name need not equal Tilda's canonical generated name: if the existing index is structurally equivalent, preserve its current name and do not rename, drop, or recreate it. When Tilda creates a new index, it may use its normal generated naming convention.
4. A changed source list/order or configuration schedules a controlled rebuild of the index-owned generated column and GIN index. PostgreSQL does not provide a simple ALTER operation to replace a generated expression; plan for drop/re-add of the artifact and dependent index.
5. If the requested artifact or index name is already occupied by an unrelated physical object, report a clear conflict and do not overwrite it.
6. If only one half exists (artifact without expected GIN index, or GIN index without the expected generated artifact), report/repair only when metadata proves ownership; otherwise fail safely with a diagnostic.

Ordinary migration currently compares model-defined columns and does not drop unmatched database columns. Separately, the generated drop-script flow can list unmatched physical columns. Ensure a declared index-owned artifact is excluded from that column-drop list. Do not make removal of a fulltext declaration destructive: dropping an index/artifact because it disappeared from JSON would violate the requested behavior. Any explicit fulltext teardown should be a separately reviewed operation.

## Production Rollout Note

Adding a STORED generated column and building a GIN index on an existing populated table has known backfill, I/O, storage, and locking costs. Those costs are understood by Tilda users and are not an open design question or a reason to require a separate provisioning mechanism in this plan. Keep them documented as expected migration behavior. Do not expand v1 to add special concurrent-build machinery unless separately requested.

## Tests and Acceptance Criteria

- Parser/schema tests: omitted configuration defaults to `english`; `simple` and other values pass model validation; absent required fields, unsupported backends, invalid source columns/types, collisions, incompatible settings, and vector+fulltext are rejected.
- DDL tests: exact STORED generated-column and GIN DDL; source ordering, NULL handling, quoting, and SQL-literal escaping; artifact is absent from application-generated fields and writes.
- Metadata tests against PostgreSQL: deparsed expression, generated status, GIN method, English/simple configuration, quoted identifiers, multiple/overlapping source names, and partial/mismatched artifact states.
- Migration tests: database-only definition is preserved; missing model-defined index is added; unchanged definition is a no-op; source/config drift rebuilds; unrelated name conflicts fail without destructive action. Include the supplied `genai_embeddings.doclib_doc` shape: `search_tsv` is generated from `documentTitle` and `documentDescription` using `english`, and `idx_doclib_doc_search_tsv` is a GIN index on it. Defining the equivalent fulltext index in JSON must schedule no DDL, including no index rename merely to impose Tilda's canonical physical name.
- Drop-script tests: declared artifacts are not emitted as ordinary missing-column drops; removed JSON definitions do not silently drop physical fulltext artifacts.
- Operational review: exercise DDL on a representative PostgreSQL 15+ database and measure/assess rewrite, lock, backfill, disk, and GIN build impact before production rollout.

Existing test references include `Tilda/ut/tilda/db/stores/PostgreSQLVectorIndexTest.java`, `Tilda/ut/tilda/migration/MigratorIndexTest.java`, and `Tilda/ut/tilda/parsing/parts/DBCompatibilityTest.java`.

## Out of Scope for V1

- BigQuery or SQL Server execution, including analyzer or native full-text backend details.
- Shared application-level search-query API, ranking helpers, query parsing safeguards, and rate/statement-timeout policy.
- URL filename extraction or weighted sources.
- Collections, JSON/nested source paths, multiple text configurations per index, arbitrary PostgreSQL options, and generalized expression parsing.
- Automatic destructive cleanup when a fulltext declaration is removed from JSON.
