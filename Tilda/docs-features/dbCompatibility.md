# Tilda JSON Syntax: dbCompatibility

<-- [Main Schema Syntax](https://github.com/CapsicoHealth/Tilda/wiki/Tilda-JSON-Syntax)

The `dbCompatibility` element declares which database backends a schema's objects and views target. It is defined at the schema level; it does not go inside individual object or view definitions.

## Default Database

The core TILDA schema declares the platform baseline:

```json
"dbCompatibility": {
  "default": ["postgres"]
}
```

Application schemas inherit this baseline through their schema dependencies and must not declare `default` themselves. Objects and views target PostgreSQL unless a matching route changes their targets. Registering a database backend or configuring a connection does not opt a schema into that backend.

## Target Routes

A route adds a database to the matching entities by default. Set `only` to `true` to make wildcard-matched entities exclusive to that database:

```json
"dbCompatibility": {
  "targets": [
    {
      "db": "bigquery",
      "objects": ["*"],
      "views": ["*"]
    },
    {
      "db": "bigquery",
      "only": true,
      "objects": ["CohortMart*"],
      "views": ["Monthly*"]
    }
  ]
}
```

In this example, all declared objects and views target PostgreSQL and BigQuery, except those matched by the second route, which target BigQuery only.

Each `targets` entry has these fields:

- `db` is a required database identifier.
- `only` is optional and defaults to `false`. Only wildcard selectors can use `only: true` to replace inherited or additive targets.
- `objects` is an optional array of object-name selectors.
- `views` is an optional array of view-name selectors.

Selectors match names in the declaring schema, case-insensitively. Supported forms are an exact name, `*` for all names, a prefix such as `Cohort*`, or a suffix such as `*Summary`. Patterns must match at least one declared entity. A selector cannot contain whitespace, multiple `*` characters, or an embedded wildcard such as `Cohort*Summary`.

An exact selector that conflicts with a wildcard `only: true` route is an error. An exact selector cannot itself make an entity exclusive. Use a wildcard selector, even if it currently matches only one entity, when that entity must be exclusive. Review wildcard expansion carefully: a prefix or suffix may match more entities than intended.

A schema may have at most one route for each `(db, only)` pair; combine selectors for that pair in one entry. A route must select at least one object or view. Do not inherit routes from schema dependencies.

## Database Identifiers

Database identifiers are case-insensitive. Use the canonical identifiers `postgres`, `bigquery`, and `sqlserver`. The explicit aliases `postgresql` and `mssql` are also accepted. Punctuation is not normalized, so values such as `post-gres` are invalid. The identifier must refer to a backend registered with Tilda.

## Foreign-Key Exceptions

By default, a foreign key's source and destination must both target each database used by the source object. To retain a logical cross-database relationship where the destination is absent, declare an explicit enforcement exception:

```json
"dbCompatibility": {
  "targets": [
    {
      "db": "bigquery",
      "only": true,
      "objects": ["CohortMart*"],
      "views": [],
      "fkEnforcementExceptions": ["CohortMartX.CohortDefinitionFK", "CohortMart2"]
    }
  ]
}
```

`fkEnforcementExceptions` is an optional array on a target entry. An entry in `SourceObject.ForeignKeyName` form exempts that exact FK; an entry containing only `SourceObject` exempts every FK declared on that object. The source object must be declared in this schema, selected by that target's `objects` patterns, and routed to the target database. The named FK must exist, and object shorthand requires at least one declared FK. Wildcards are not allowed, and an FK may be excepted only once per database, including overlap between object shorthand and exact references.

An exception permits the logical relationship to remain in the Tilda model while omitting physical FK DDL on that database. It is an error if the destination is available on that database, since the exception would be unnecessary. An exception does not change the FK on other databases.

## Dependency Validation

Every view dependency must be available on every database targeted by the view. There is no view-dependency exception. A view or foreign key that points to an entity missing from a target database must either be routed consistently or, for a foreign key only, have a valid `fkEnforcementExceptions` entry.

Compatibility routes describe schema placement; they do not certify that application-specific SQL expressions or queries are portable across database engines. Runtime connections provide databases Tilda can access, but do not change the compatibility declared here.

[Migration syntax](https://github.com/CapsicoHealth/Tilda/wiki/Tilda-JSON-Syntax:-Migration)
