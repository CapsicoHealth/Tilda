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

package tilda.annotations;

/**
 * Marks a {@link SchemaDoc}-annotated field as a cross-reference into another part of the TILDA DSL
 * document (or another schema file), so that tilda.generation.jsonschema.TildaJsonSchemaGenerator can
 * document the relationship in the generated JSON Schema's "description".
 * <P>
 * JSON Schema has no mechanism to structurally validate these relationships (i.e., that a referenced
 * name actually exists elsewhere in the document); that validation remains exclusively the
 * responsibility of tilda.parsing.ParserSession and the parsing POJOs' validate(...) methods. This enum
 * is documentation metadata only and has no effect on Gson (de)serialization or on parsing/validation.
 */
public enum SchemaRefKind
  {
    NONE                  (null),
    COLUMN_IN_SAME_OBJECT ("Must match the name of a column defined in this object's \"columns\" array."),
    COLUMN_REFERENCE      ("Must resolve to a column, optionally qualified as \"package.schema.object.column\" (each segment defaulting to the current one); may also resolve to a view column where applicable."),
    OBJECT_IN_SCHEMA      ("Must match the name of an object defined in this schema or one of its dependencies."),
    VIEW_IN_SCHEMA        ("Must match the name of a view defined in this schema or one of its dependencies."),
    ENUM_IN_SCHEMA        ("Must match the name of an enumeration defined in this schema or one of its dependencies."),
    SCHEMA_REFERENCE      ("Must resolve to another already-loaded Tilda schema, referenced as \"package.schemaName\"."),
    SCHEMA_FILE_DEPENDENCY("Must resolve to another Tilda schema JSON file's resource path, relative to the classpath root.");

    private final String _DescriptionSuffix;

    private SchemaRefKind(String descriptionSuffix)
      {
        _DescriptionSuffix = descriptionSuffix;
      }

    public String getDescriptionSuffix()
      {
        return _DescriptionSuffix;
      }
  }
