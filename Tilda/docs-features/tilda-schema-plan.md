# Blueprint: Formal JSON Schema Definition for TILDA DSL

This blueprint outlines the execution strategy to build, test, and integrate a formal JSON Schema (`tilda.schema.json`) for the CapsicoHealth TILDA DSL. 

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

### IntelliJ IDEA Integration
1. Navigate to **File** ➔ **Settings** ➔ **Languages & Frameworks** ➔ **Schemas and DTDs** ➔ **JSON Schema Mappings**.
2. Click the **+** (Add) icon.
3. Name your layout definition: `TILDA Schema Mapper`.
4. In the **Schema file or URL** directory path, select the local path pointing directly to your `tilda.schema.json` template file.
5. Choose **JSON Schema Version:** `Schema version 2020-12`.
6. Under the **Mappings** layout configuration grid, click **+** and add a **File path pattern**: `**/_tilda.*.json`.
