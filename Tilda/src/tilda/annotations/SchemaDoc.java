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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Documentation/generation metadata for a field of a tilda.parsing.parts POJO, consumed by
 * tilda.generation.jsonschema.TildaJsonSchemaGenerator when producing tilda.schema.json.
 * <P>
 * This annotation has no effect on Gson (de)serialization or on tilda.parsing.ParserSession validation;
 * it exists purely to enrich the generated JSON Schema's "description" and "required" metadata. The
 * POJOs (and their validate(...) methods) remain the sole source of truth for actual DSL behavior.
 *
 * @see SchemaRefKind
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SchemaDoc
  {
    /** Human-readable description surfaced as the JSON Schema property's "description". */
    String description() default "";

    /** Whether this property should be added to its parent's JSON Schema "required" array. */
    boolean required() default false;

    /** If this field is a cross-reference to another named element, the kind of reference it is. */
    SchemaRefKind refKind() default SchemaRefKind.NONE;
  }
