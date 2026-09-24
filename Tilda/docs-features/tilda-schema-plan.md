# Blueprint: Formal JSON Schema Definition for TILDA DSL

This blueprint outlines the execution strategy to build, test, and integrate a formal JSON Schema (`tilda.schema.json`) for the CapsicoHealth TILDA DSL.

---

## 0. Source of Truth: The Parsing POJOs

The TILDA DSL (`_tilda.*.json` files) is parsed by Gson directly into a tree of plain Java objects rooted at [Schema.java](../src/tilda/parsing/parts/Schema.java). **Every field of the JSON Schema must be derived from, and kept in sync with, these POJOs** — they are the single source of truth, not the sample document below. The `@SerializedName` annotation on each field gives the exact JSON property name, and each class's `validate(...)` method encodes the semantic rules (required-ness, enums, cross-field constraints) that a hand-authored JSON Schema needs to reproduce as best it can.

Key classes under [src/tilda/parsing/parts/](../src/tilda/parsing/parts/):

| JSON concept | POJO |
| --- | --- |
| Root schema document | [Schema.java](../src/tilda/parsing/parts/Schema.java) |
| Table/object definition | [Object.java](../src/tilda/parsing/parts/Object.java) (extends [Base.java](../src/tilda/parsing/parts/Base.java)) |
| Column definition | [Column.java](../src/tilda/parsing/parts/Column.java) |
| Enumerations | [Enumeration.java](../src/tilda/parsing/parts/Enumeration.java), [Value.java](../src/tilda/parsing/parts/Value.java) |
| Mappers | [Mapper.java](../src/tilda/parsing/parts/Mapper.java), [MappingColumn.java](../src/tilda/parsing/parts/MappingColumn.java), [ColumnMapper.java](../src/tilda/parsing/parts/ColumnMapper.java) |
| Primary/foreign keys & indices | [PrimaryKey.java](../src/tilda/parsing/parts/PrimaryKey.java), [ForeignKey.java](../src/tilda/parsing/parts/ForeignKey.java), [Index.java](../src/tilda/parsing/parts/Index.java), [IndexTemplate.java](../src/tilda/parsing/parts/IndexTemplate.java) |
| Views (incl. pivots, time-series, joins) | [View.java](../src/tilda/parsing/parts/View.java), [ViewColumn.java](../src/tilda/parsing/parts/ViewColumn.java), [ViewJoin.java](../src/tilda/parsing/parts/ViewJoin.java), [ViewJoinSimple.java](../src/tilda/parsing/parts/ViewJoinSimple.java), [ViewPivot.java](../src/tilda/parsing/parts/ViewPivot.java), [ViewPivotAggregate.java](../src/tilda/parsing/parts/ViewPivotAggregate.java), [ViewPivotColumn.java](../src/tilda/parsing/parts/ViewPivotColumn.java), [ViewPivotValue.java](../src/tilda/parsing/parts/ViewPivotValue.java), [ViewTimeSeries.java](../src/tilda/parsing/parts/ViewTimeSeries.java), [ViewTimeSeriesJoin.java](../src/tilda/parsing/parts/ViewTimeSeriesJoin.java), [ViewRealize.java](../src/tilda/parsing/parts/ViewRealize.java), [ViewRealizeIncremental.java](../src/tilda/parsing/parts/ViewRealizeIncremental.java), [ViewRealizeMapping.java](../src/tilda/parsing/parts/ViewRealizeMapping.java), [ViewDistinctOn.java](../src/tilda/parsing/parts/ViewDistinctOn.java) |
| JSON-typed columns | [JsonSchema.java](../src/tilda/parsing/parts/JsonSchema.java), [JsonField.java](../src/tilda/parsing/parts/JsonField.java), [JsonValidation.java](../src/tilda/parsing/parts/JsonValidation.java) |
| History/temporal tables | [History.java](../src/tilda/parsing/parts/History.java) |
| Migrations | [Migration.java](../src/tilda/parsing/parts/Migration.java), [MigrationRename.java](../src/tilda/parsing/parts/MigrationRename.java), [MigrationMove.java](../src/tilda/parsing/parts/MigrationMove.java), [MigrationDrop.java](../src/tilda/parsing/parts/MigrationDrop.java), [MigrationNotNull.java](../src/tilda/parsing/parts/MigrationNotNull.java), [MigrationConversion.java](../src/tilda/parsing/parts/MigrationConversion.java) |
| Queries, ordering, where clauses | [Query.java](../src/tilda/parsing/parts/Query.java), [OrderBy.java](../src/tilda/parsing/parts/OrderBy.java), [SubWhereClause.java](../src/tilda/parsing/parts/SubWhereClause.java), [SubWhereX.java](../src/tilda/parsing/parts/SubWhereX.java) |
| Conventions, HTTP mappings, extra DDL, docs | [Convention.java](../src/tilda/parsing/parts/Convention.java), [HttpMapping.java](../src/tilda/parsing/parts/HttpMapping.java), [ExtraDDL.java](../src/tilda/parsing/parts/ExtraDDL.java), [Documentation.java](../src/tilda/parsing/parts/Documentation.java) |
| Shared type definition (base for columns/fields) | [TypeDef.java](../src/tilda/parsing/parts/TypeDef.java) |

Supporting enums that back many of the `enum`/string-constrained properties live under [src/tilda/enums/](../src/tilda/enums/) (e.g. `ColumnType`, `ColumnMode`, `ObjectMode`, `ObjectLifecycle`, `TZMode`, `FrameworkColumnType`) and should be used to generate the `"enum"` arrays in the schema rather than hard-coding them.

> The sample schema fragment in Section 1 below is illustrative only and does not yet fully reflect every property exposed by the POJOs above (e.g. `dynamic`, `entityClasses`, `enumerations`, `mappers`, `migrations`, per-object `primary`/`foreign`/`indices`/`http`/`history`, and the richer `View`/`ViewPivot`/`ViewTimeSeries` structures). Section 4 describes the process for closing these gaps incrementally as the schema is built out and kept current.

### Permanent limitations (not gaps to "fix")

Two things are structurally out of reach for a JSON Schema, no matter how carefully it's authored or generated, and should not be treated as TODOs:

- **Cross-references are not enforceable.** Fields like `Column._SameAs`, `ForeignKey._DestObject`, `Index._Columns`, and `Schema._Dependencies` are plain strings/arrays at the POJO level; the fact that they *reference* another column/object/schema file only exists in resolution logic (e.g. [SameAsHelper.java](../src/tilda/parsing/parts/helpers/SameAsHelper.java), `validate(...)`). JSON Schema has no vocabulary for "this value must match a name found elsewhere in this document" — `enum`/`const` require a static, schema-authoring-time list, and `$ref` resolves schema shape, not data values. These relationships remain exclusively the responsibility of the Java parser/`validate()` pipeline; the JSON Schema only ever provides structural validation (types, required-ness, enums of *known* values, shape of nesting).
- **Source formatting is invisible to JSON Schema.** Validation operates on the parsed value tree, after whitespace, key order, and alignment are gone — there's no way to "encode" the canonical columnar layout used in [_tilda.Tilda.json](../src/tilda/data/_tilda.Tilda.json) via a schema. Protecting that layout is a formatting concern, not a validation concern — see the IDE integration notes in Section 2, and the existing [TildaSchemaFormatter.java](../src/tilda/generation/TildaSchemaFormatter.java) pretty-printer, which is the intended tool for producing/re-producing that layout.

---

## 1. Schema Specifications (Draft 2020-12)

The target JSON schema must validate the root-level configuration files (`_tilda.*.json`) used by the framework to drive compile-time Java generation and PostgreSQL 18 mappings.

### Core Structure Mapping

```json
{
  "\$schema": "https://json-schema.org",
  "\$id": "https://github.io",
  "title": "TILDA Database Schema Definition DSL",
  "type": "object",
  "required": ["package", "objects"],
  "properties": {
    "package": {
      "type": "string",
      "description": "The target Java package for generated classes."
    },
    "dependencies": {
      "type": "array",
      "items": { "type": "string" },
      "description": "Dependent TILDA schema files needed for cross-object references."
    },
    "objects": {
      "type": "array",
      "description": "Table definitions mapping to physical database entities.",
      "items": { "\(ref": "#/\)defs/tildaObject" }
    },
    "views": {
      "type": "array",
      "description": "Complex declarative views, time-series transformations, and analytical aggregates.",
      "items": { "\(ref": "#/\)defs/tildaView" }
    }
  },
  "\$defs": {
    "tildaObject": {
      "type": "object",
      "required": ["name", "columns"],
      "properties": {
        "name": { "type": "string" },
        "description": { "type": "string" },
        "history": {
          "type": "boolean",
          "description": "Automatically generates secondary bi-temporal shadow tables and temporal triggers."
        },
        "columns": {
          "type": "array",
          "items": { "\(ref": "#/\)defs/tildaColumn" }
        }
      }
    },
    "tildaColumn": {
      "type": "object",
      "required": ["name", "type"],
      "properties": {
        "name": { "type": "string" },
        "type": {
          "type": "string",
          "enum": ["STRING", "INTEGER", "LONG", "FLOAT", "DOUBLE", "BOOLEAN", "DATETIME", "UUID"]
        },
        "nullable": { "type": "boolean" },
        "mask": {
          "type": "string",
          "enum": ["NONE", "PARTIAL", "FULL"],
          "description": "Built-in de-identification filter strategy for sensitive column values."
        }
      }
    },
    "tildaView": {
      "type": "object",
      "required": ["name", "columns"],
      "properties": {
        "name": { "type": "string" },
        "description": { "type": "string" },
        "pivot": {
          "type": "object",
          "description": "Declarative multi-dimensional pivot logic compiled to database structures."
        }
      }
    }
  }
}
```

---

## 2. IDE Integration Guides

To enforce real-time auto-complete and clear property descriptions directly during developer onboarding, map the created schema locally.

> **Do not enable "Format Document"/format-on-save for `_tilda.*.json` files.** Generic JSON formatters (including each IDE's built-in one) will reflow the deliberate columnar/aligned layout used across TILDA schema files into a single generic style, destroying readability. The schema mappings below only add validation/auto-complete — they do not affect formatting. If a file needs to be reformatted, use the project's own [TildaSchemaFormatter.java](../src/tilda/generation/TildaSchemaFormatter.java) pretty-printer instead of the IDE's generic JSON formatter.

### Visual Studio Code Integration
Add the following configuration block to your local `.vscode/settings.json` project configuration file:

```json
{
  "json.schemas": [
    {
      "fileMatch": [
        "**/_tilda.*.json"
      ],
      "url": "./tilda.schema.json"
    }
  ]
}
```

The built-in JSON language support (via the `vscode.json-language-features` extension, enabled by default) picks this up automatically — no extra extension install is required. Restart VS Code (or run **Developer: Reload Window**) after adding the mapping to see auto-complete, hovers, and validation squiggles in `_tilda.*.json` files.

### Eclipse Integration
Eclipse's JSON editor does not ship with a native JSON Schema mapping UI, so schema support is provided by the **[JSON Editor Plugin](https://marketplace.eclipse.org/content/json-editor)** (or a similarly featured JSON tooling plugin from the Eclipse Marketplace) that supports the `json.schemas`-style configuration:

1. Install a JSON editing plugin with schema support from **Help** ➔ **Eclipse Marketplace** (search for "JSON Editor").
2. Open **Window** ➔ **Preferences** ➔ **JSON** ➔ **JSON Schema Mappings** (path may vary slightly by plugin version).
3. Click **Add**, then browse to the project's `tilda.schema.json` file.
4. Add a **File pattern** mapping of `_tilda.*.json` so the schema is associated with any TILDA definition file in the workspace.
5. Apply and restart the JSON editor (close/reopen affected files) to pick up validation and content-assist.

If the installed plugin only supports the JSON draft-07/draft-04 dialects, keep a draft-07-compatible fallback copy of `tilda.schema.json` (see Section 4) so Eclipse users still get useful validation.

### IntelliJ IDEA Integration
1. Navigate to **File** ➔ **Settings** ➔ **Languages & Frameworks** ➔ **Schemas and DTDs** ➔ **JSON Schema Mappings**.
2. Click the **+** (Add) icon.
3. Name your layout definition: `TILDA Schema Mapper`.
4. In the **Schema file or URL** directory path, select the local path pointing directly to your `tilda.schema.json` template file.
5. Choose **JSON Schema Version:** `Schema version 2020-12`.
6. Under the **Mappings** layout configuration grid, click **+** and add a **File path pattern**: `**/_tilda.*.json`.

---

## 3. Generating the Schema from the POJOs

Rather than hand-maintaining `tilda.schema.json` as a document independent from the code, the schema is generated directly from the [tilda.parsing.parts](../src/tilda/parsing/parts/) POJOs via a reflection walker over the `@SerializedName` annotations (custom-built rather than a generic library such as [victools/jsonschema-generator](https://github.com/victools/jsonschema-generator), since Tilda's required-ness/enum/cross-field rules live in hand-written `validate(...)` methods, not annotations a generic tool would recognize), plus the enum classes in [tilda.enums](../src/tilda/enums/) for the `"enum"` value lists.

This is implemented by [TildaJsonSchemaGenerator.java](../src/tilda/generation/jsonschema/TildaJsonSchemaGenerator.java) and exposed as a standalone command-line utility, [GenTildaJsonSchema.java](../src/tilda/GenTildaJsonSchema.java), following the same `main(String[])` pattern as `tilda.Gen`/`tilda.Docs`:

```
tilda.GenTildaJsonSchema C:/projects/Xyz/tilda.schema.json
```

It takes exactly one mandatory parameter — the destination file path — creates parent directories as needed, and overwrites any existing file there. Because the generator only ever reads `@SerializedName`/`@SchemaDoc` annotations and enum declarations reflectively, the quality of the output (descriptions, `required` arrays, reference documentation) improves incrementally as those annotations are backfilled onto the POJOs (see Section 4); it never needs to be re-run on any particular schedule beyond "whenever someone wants a fresh copy."

`tilda.schema.json` is a checked-in, version-controlled asset read by every contributor's IDE, so its output must be **deterministic**, both when hand-edited and once the generator exists:

- `$defs` entries are ordered alphabetically by definition name.
- Properties within an object definition are ordered to match the declaration order of the fields in the source POJO (i.e. `getDeclaredFields()` order, not alphabetical or hashmap-iteration order).
- `"enum"` value lists follow the declaration order of the backing Java `enum` (`EnumClass.values()`), not alphabetical order.
- Re-running the generator against unchanged POJOs must produce byte-for-byte identical output.

This keeps diffs of `tilda.schema.json` minimal and reviewable (only the actual change shows up), and makes the file easy to scan since its structure predictably mirrors the POJO source it was derived from.

### Documenting references via annotation metadata

As noted in Section 0, JSON Schema cannot enforce cross-references (`sameAs`, `destObject`, index `columns`, `dependencies`, etc.) — that stays exclusively in the Java `validate(...)`/helper logic. However, the [SchemaDoc.java](../src/tilda/annotations/SchemaDoc.java) annotation used to drive generation should still capture *what kind* of reference a field represents, purely as documentation metadata, via [SchemaRefKind.java](../src/tilda/annotations/SchemaRefKind.java), e.g.:

```java
@SchemaDoc(description = "Name of the destination object this foreign key points to.",
           refKind = SchemaRefKind.OBJECT_IN_SCHEMA)
@SerializedName("destObject") public String _DestObject;
```

The generator uses `refKind` only to append a clarifying sentence to the property's `"description"` (e.g. "Must match the name of an object defined in this schema or one of its dependencies.") so IDE tooltips explain the relationship even though the schema can't validate it. `refKind` has no structural/validation effect on the emitted JSON Schema.

---

## 4. Maintaining the Schema When Adding New Features

Because `tilda.schema.json` is generated (Section 3), it is **never hand-edited**. Every change that adds, renames, or removes a DSL feature just needs to update the POJOs (and, optionally, their `@SchemaDoc` metadata) and re-run `tilda.GenTildaJsonSchema`. Follow this checklist:

1. **Change the POJO first.** Add/modify the field on the relevant class under [src/tilda/parsing/parts/](../src/tilda/parsing/parts/) with its `@SerializedName`, and update its `validate(ParserSession, ...)` method with any new required-ness/enum/cross-field rules. This remains the source of truth; the generator will automatically pick up the new/changed field and, if it's a reference to a POJO in [tilda.parsing.parts](../src/tilda/parsing/parts/), emit a new `$defs` entry for it (named `tilda<ClassName>`) with no extra step required.
2. **Add `@SchemaDoc` metadata for the field.** This is what actually improves the generated schema's usefulness — the generator alone can only infer structural shape (type/array/object/`$ref`) and, for genuinely `enum`-typed fields, the `"enum"` value list:
   - Set `description` to a short explanation (reuse the intent of any Javadoc/validation error message, so IDE tooltips stay meaningful).
   - Set `required = true` if `validate(...)` rejects the document when the field is missing/null.
   - Set `refKind` if the field is a cross-reference (`sameAs`, `destObject`, index/foreign-key `columns`, `dependencies`, etc.) — see the annotation guidance above.
3. **Regenerate.** Run `tilda.GenTildaJsonSchema <path-to>/tilda.schema.json` and diff the result to confirm the new/changed property shows up as expected (see Section 3 for the determinism guarantees that make this diff meaningful).
4. **Update sample/test fixtures.** Add or update a representative `_tilda.*.json` sample (see [ut/tilda/data_test/_tilda.TildaTest.json](../ut/tilda/data_test/_tilda.TildaTest.json) and [src/tilda/data/_tilda.Tilda.json](../src/tilda/data/_tilda.Tilda.json)) that exercises the new/changed property, and validate it against the updated schema.
5. **Validate the schema itself.** Run it through a JSON Schema validator (e.g. `ajv` CLI, or the IDE integrations from Section 2) against both valid and intentionally invalid fixtures to confirm the new constraints behave as expected.
6. **Keep parity notes current.** If the change closes one of the gaps called out in the callout at the end of Section 0, remove it from that list; if it introduces a new known gap (e.g. a feature intentionally not yet modeled), add it there instead so the document never silently drifts from the code.
7. **Bump `$id`/version if published externally.** If `tilda.schema.json` is consumed outside this repo (e.g. published to a URL referenced by `$id`), treat breaking changes (new required fields, removed properties, narrowed enums) as requiring a version bump so downstream consumers aren't broken silently.

This keeps the POJOs as the sole authority for behavior while the generated schema stays a reliable, IDE-consumable, always-in-sync projection of that behavior.

> **TODO / follow-up:** [TildaSchemaFormatter.java](../src/tilda/generation/TildaSchemaFormatter.java) (referenced in Section 2 as the intended canonical formatter for `_tilda.*.json` files) hasn't been exercised in a long time and its correctness/coverage against current file conventions is unverified. Before recommending it as the safe alternative to IDE auto-formatting, it needs a proper pass: run it against the existing `_tilda.*.json` fixtures (e.g. [src/tilda/data/_tilda.Tilda.json](../src/tilda/data/_tilda.Tilda.json), [ut/tilda/data_test/_tilda.TildaTest.json](../ut/tilda/data_test/_tilda.TildaTest.json)), confirm the output is idempotent and matches the intended columnar layout, and add/repair unit test coverage. Tracked here for later; not blocking this schema effort.
