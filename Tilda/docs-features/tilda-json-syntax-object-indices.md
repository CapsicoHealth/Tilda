<-- [[Object Syntax|Tilda JSON Syntax: Objects]]

# Indices

Indices define methods of optimized access for tables. One cay say they are preferred as they represent natural orderings of the data for optimized access. In Tilda, you can create:
* unique indices by specifying a list of 1 or more "columns"
* regular indices by also specifying an "orderBy" list of 1 or more columns
* indices that exist in the database (if the target database supports indices), or only at the application level with "db":true|false.
* partial indices (with a subwhere clause)

An object can define zero or more indices in its `indices` array:

```json
  // Within an Object definition, you can define any number of indices (or none).
  "indices": [
     // a unique index on externalId
    ,{ "name": "UniqueExternalId" , "columns": ["externalId"]                                 , "db": true  }
     // a regular index on customerRefnum, created desc
     { "name": "ByCustomerAndDate", "columns": ["customerRefnum"], "orderBy": ["created desc"], "db": true  }
     // an application-only (no database) "unique index"
    ,{ "name": "ApplicationSearch", "columns": ["status"]                                     , "db": false }
     // a partial unique index on id for rows where deleted is null
    ,{ "name": "AppId"            , "columns": ["id"], "subWhere":"deleted is null"           , "db": true  }
  ]
```

## Index Fields

- `name` (required): Index name. Tilda derives the final database identifier from the object and index names; the final name must fit the target database's identifier limits.
- `columns`: Columns that make up the index. A column may include an index modifier, as described below.
- `orderBy`: Optional ordered columns, with optional `asc` or `desc` direction. An index with one or more `orderBy` entries is non-unique. `columns` and `orderBy` may be used together.
- `db` (default `true`): Whether the index should be emitted as a database index. When `false`, it is application-level only. Physical index support and behavior depend on the target database.
- `cluster` (default `false`): Request clustering of the table on this index where supported. A clustered index must be a database index and cannot be partial.
- `nullsNotDistinct` (default `false`): Request unique-index semantics in which NULL values compare as not distinct, where supported.
- `subWhere`: Raw partial-index predicate.
- `subQuery`: Structured partial-index predicate. Use either `subWhere` or `subQuery`, not both.
- `vector`: VECTOR-index semantics, including the shared distance and algorithm plus backend-specific `details`; see [VECTOR Indexes](#vector-indexes).

:balloon: **NOTE**: An index definition requires at least 1 column defined in either "columns" or "orderBy".

:balloon: **NOTE**: Tilda will not warn you if you create a frivolous index. For example, an index on a, b and another on a, b and c. Avoid creating more physical indices than needed as they do put extra weight in **all** insert/update/delete operations.

:balloon: **NOTE**: All objects must have at least one identity. That can be supplied via a [[Primary Key|Tilda JSON Syntax: Object Primary Key]], or a unique index. Tilda will enforce that either one or the other are defined. An object/table can of course have multiple identities.

:balloon: **NOTE**: Tilda will use regular indices for most cases, but will use text-based indices when dealing with collection of STRING values. In Postgres, this means using a gin index when the covered columns include a STRING collection.

## Column Modifiers

A column in `columns` may use the `lal` modifier for left-anchored `LIKE` searches:

```json
{ "name": "ByCodePrefix", "columns": ["code lal"], "db": true }
```

`lal` is valid only for STRING columns. PostgreSQL emits the corresponding `text_pattern_ops` operator class. It has no effect for an application-level index (`"db": false`).

## VECTOR Indexes

A VECTOR index is declared in the ordinary `indices` array. Its `columns` entry names the VECTOR column, and its `vector` field contains the distance, algorithm, and backend-specific details:

```json
{ "name": "EmbeddingByCosine", "columns": ["embedding"], "db": true,
  "vector": { "distance": "cosine", "algorithm": "ivf", "details": [
     { "db": "postgres", "options": [
                                         { "option": "m"              , "value": "16" }
                                        ,{ "option": "ef_construction", "value": "200" }
                                       ]
     }
  ]
}
```

A VECTOR index may cover only one VECTOR column. Do not combine a VECTOR column with other index columns.

### Database Selection

Each `vector.details` entry has:

- `db` (required): A registered database backend identifier, such as `postgres`, or `"*"` for a configuration shared by all databases.
- `algorithm`: An optional database-specific algorithm.
- `options`: An optional array of `{ "option": "...", "value": "..." }` pairs interpreted for this database and its algorithm.

`vector.algorithm` is shared by all selected backends and must be supported by every database in `vector.details`. Alternatively, omit it and specify `algorithm` on every detail. Do not specify both shared and detail-level algorithms. If no algorithm is specified anywhere, PostgreSQL and BigQuery use their IVF-family defaults. `vector.distance` is also shared. For "db", Use either one wildcard entry or one or more database-specific entries. Do not mix `"*"` with named database entries. A backend may appear only once; aliases that resolve to the same backend count as duplicates. Options are selected and validated for the target backend.

The distance defaults to `euclidean`. If no algorithm is specified at either level, each backend uses its own default algorithm.

For example, a wildcard entry can apply backend defaults to all generation targets while sharing one distance:

```json
"vector": { "details": [{ "db": "*" }] }
```

Alternatively, provide separate entries for the database targets that need different settings:

```json
"vector": { "distance": "cosine", "details": [
  { "db": "postgres", "algorithm": "hnsw", "options": [
                                                        { "option": "m", "value": "16" }
                                                      ]
  }
  ,{ "db": "bigquery", "algorithm": "tree_ah", "options": [
                                                            { "option": "leaf_node_embedding_count", "value": "500" }
                                                          ]
   }
] }
```

:balloon: **NOTE**: As of this writing, Tilda only supports Postgresql and BigQuery and therefore, vector indices only for those database backends.


:balloon: **NOTE**: A vector index requires a `vector.details` entry for each target database. `vector.distance` may be omitted and defaults to `euclidean`. To use each backend's default algorithm:
```json
"vector": { "details": [
  { "db": "postgres" },
  { "db": "bigquery" }
] }
```



### PostgreSQL Settings

PostgreSQL is currently a valid implemented VECTOR-index generation target. The `vector` object supports:

- `distance`: The shared distance metric. The default is `euclidean`; valid choices depend on the VECTOR column's type modifier and selected algorithm.
- `algorithm`: The shared form accepts `ivf` or `hnsw`; `ivf` maps to PostgreSQL's native `ivfflat`. In database-specific details, PostgreSQL accepts `ivf`, `ivfflat`, or `hnsw`.

The PostgreSQL `vector.details[]` entries support `db`, an optional `algorithm`, and an optional `options` array of `{ "option": "...", "value": "..." }` pairs. Values are strings, including numeric values. Option names are interpreted for the chosen algorithm. If no algorithm is specified at either level, PostgreSQL defaults to `ivfflat`.

#### pgvector Index Methods and Operator Classes

The following is the native pgvector v0.8.7 index-method matrix. Each operator class selects the distance used by queries against that index. `<#>` is negative inner product, as PostgreSQL index scans order ascending.

| Method | Indexed value type | Operator classes and distances |
| --- | --- | --- |
| `hnsw` | `vector` (up to 2,000 dimensions) | `vector_l2_ops` (L2, `<->`); `vector_ip_ops` (inner product, `<#>`); `vector_cosine_ops` (cosine, `<=>`); `vector_l1_ops` (L1, `<+>`) |
| `hnsw` | `halfvec` (up to 4,000 dimensions) | `halfvec_l2_ops` (L2); `halfvec_ip_ops` (inner product); `halfvec_cosine_ops` (cosine); `halfvec_l1_ops` (L1) |
| `hnsw` | `bit` (up to 64,000 dimensions) | `bit_hamming_ops` (Hamming, `<~>`); `bit_jaccard_ops` (Jaccard, `<%>`) |
| `hnsw` | `sparsevec` (up to 1,000 non-zero elements) | `sparsevec_l2_ops` (L2); `sparsevec_ip_ops` (inner product); `sparsevec_cosine_ops` (cosine); `sparsevec_l1_ops` (L1) |
| `ivfflat` | `vector` (up to 2,000 dimensions) | `vector_l2_ops` (L2, `<->`); `vector_ip_ops` (inner product, `<#>`); `vector_cosine_ops` (cosine, `<=>`) |
| `ivfflat` | `halfvec` (up to 4,000 dimensions) | `halfvec_l2_ops` (L2); `halfvec_ip_ops` (inner product); `halfvec_cosine_ops` (cosine) |
| `ivfflat` | `bit` (up to 64,000 dimensions) | `bit_hamming_ops` (Hamming, `<~>`) |

Native index-build options and defaults are:

| Method | Index options | pgvector defaults |
| --- | --- | --- |
| `hnsw` | `m`, `ef_construction` | `m` = `16`; `ef_construction` = `64` |
| `ivfflat` | `lists` | `lists` = `100` |

#### Tilda PostgreSQL VECTOR Configuration

Tilda selects the pgvector operator class from the VECTOR column's type modifier and configured distance. The modifier defaults to `vector`; supported modifiers are `vector`, `halfvec`, `bit`, and `sparsevec`. The supported distance combinations are:

| Tilda type modifier | `hnsw` distances | `ivfflat` distances |
| --- | --- | --- |
| `vector` | `euclidean`, `dot`, `cosine`, `l1` | `euclidean`, `dot`, `cosine` |
| `halfvec` | `euclidean`, `dot`, `cosine`, `l1` | `euclidean`, `dot`, `cosine` |
| `bit` | `hamming`, `jaccard` | `hamming` |
| `sparsevec` | `euclidean`, `dot`, `cosine`, `l1` | Not supported |

For example, a `VECTOR(1536 halfvec)` column with `distance: "cosine"` selects `halfvec_cosine_ops`; a `VECTOR(1024 bit)` column with `distance: "hamming"` selects `bit_hamming_ops`. Unsupported type, algorithm, and distance combinations cause PostgreSQL code generation to fail with a diagnostic.

Tilda accepts only the index-build options listed for each method. Option values must be positive integers. Options not supported by the selected method, duplicate options, unsupported methods, and unsupported distances cause PostgreSQL code generation to fail with a diagnostic.

| Tilda algorithm | Tilda options | Tilda defaults when omitted |
| --- | --- | --- |
| `ivfflat` (default) | `lists` | `lists` = `1000` |
| `hnsw` | `m`, `ef_construction` | `m` = `16`; `ef_construction` = `200` |

Settings can be omitted to use Tilda's defaults. A PostgreSQL VECTOR index requires a `vector.details` entry for PostgreSQL or a wildcard. Missing or mismatched configuration is reported during code generation.

pgvector native reference: [v0.8.7 README](https://github.com/pgvector/pgvector/blob/v0.8.7/README.md)






### BigQuery Settings

BigQuery is a valid implemented VECTOR-index generation target. `vector.distance` is shared across backends and accepts `euclidean`, `dot`, or `cosine`; it defaults to `euclidean`, corresponding to BigQuery's `EUCLIDEAN`, `DOT_PRODUCT`, or `COSINE` distance type.

The shared and BigQuery-specific `algorithm` fields support:

- `ivf` or `tree_ah`. `ivf` is the common algorithm supported by both current backends; `tree_ah` is BigQuery-specific. If no algorithm is specified at either level, BigQuery uses `ivf`.

BigQuery `vector.details[]` entries support an optional `algorithm` and `options` array of `{ "option": "...", "value": "..." }` pairs. Values are strings, including numeric values. Option names are interpreted for the selected algorithm.

Defaults and supported options:

| Algorithm | Options | Tilda defaults |
| --- | --- | --- |
| `ivf` (default) | `num_lists` | `num_lists` = `1000` |
| `tree_ah` | `leaf_node_embedding_count`, `normalization_type` | BigQuery defaults apply to omitted TreeAH options |

For `ivf`, `num_lists` must be an integer from `1` through `5000`. For `tree_ah`, `leaf_node_embedding_count` must be at least `500`, and `normalization_type` must be `NONE` or `L2`. Options not supported by the selected algorithm, duplicate options, unsupported algorithms, and unsupported distances cause BigQuery code generation to fail with a diagnostic.

The index-level `vector.distance` may be omitted to use `euclidean`, and options may be omitted to use Tilda's default options. A BigQuery VECTOR index still requires a `vector.details` entry for `bigquery` (or a wildcard entry).






## Index Templates

Realized-view `indexTemplates` use the same index-template fields, including the nested `vector.details`. The selected configuration is copied to the realized index and validated by the target backend during code generation.

