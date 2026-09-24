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

package tilda.generation.jsonschema;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import tilda.annotations.SchemaDoc;
import tilda.annotations.SchemaRefKind;
import tilda.parsing.parts.Schema;

/**
 * Reflects over the tilda.parsing.parts POJOs, rooted at {@link Schema}, and produces a JSON Schema
 * (Draft 2020-12) document describing the TILDA DSL (<CODE>_tilda.*.json</CODE> files).
 * <P>
 * Only fields carrying Gson's {@code @SerializedName} are considered (matching exactly what Gson itself
 * would (de)serialize); {@code transient}/{@code static} fields are skipped. Nested POJOs declared in the
 * {@code tilda.parsing.parts} package are emitted as reusable {@code $defs} entries and referenced via
 * {@code $ref}; everything else is mapped to the closest JSON Schema primitive/array/object shape.
 * <P>
 * Output is deterministic: {@code $defs} entries are sorted alphabetically by name, object properties
 * follow the field declaration order of their owning class (walking from the root superclass down), and
 * {@code enum} value lists follow the declaring Java enum's {@code values()} order. Re-running this
 * generator against unchanged POJOs always produces byte-identical output.
 * <P>
 * Structural constraints beyond type/shape (required-ness, enum value lists, cross-reference
 * documentation) are only as complete as the {@link SchemaDoc} annotations present on the POJO fields;
 * see the "Maintaining the Schema" section of <CODE>docs-features/tilda-schema-plan.md</CODE> for the
 * process of adding them incrementally as DSL features are added/changed.
 * <P>
 * A field's JSON Schema "default" is derived automatically (no annotation needed) by constructing a
 * plain instance of its owning class and reading the field's initialized value back via reflection, i.e.,
 * whatever value Gson would leave in place if the JSON simply omitted that property. This is only emitted
 * for scalar/enum-backed fields and for collection/array fields whose default is empty; a non-null default
 * referencing another POJO (e.g. a nested config object initialized to avoid null-checks in Java) is
 * intentionally not expanded, to avoid misleadingly implying a meaningful default where the real default
 * is just "an empty shell" of that type.
 *
 * @see SchemaDoc
 * @see SchemaRefKind
 */
public class TildaJsonSchemaGenerator
  {
    private static final String                  MODEL_PACKAGE = "tilda.parsing.parts";

    private final Map<Class<?>, String>          _DefNames     = new HashMap<Class<?>, String>();
    private final TreeMap<String, JsonObject>     _Defs         = new TreeMap<String, JsonObject>();
    private final Deque<Class<?>>                _Queue        = new LinkedList<Class<?>>();
    private final Set<Class<?>>                  _Queued       = new HashSet<Class<?>>();

    public JsonObject generate()
      {
        JsonObject root = new JsonObject();
        root.addProperty("$schema", "https://json-schema.org/draft/2020-12/schema");
        root.addProperty("$id", "https://github.com/CapsicoHealth/Tilda/tilda.schema.json");
        root.addProperty("title", "TILDA Database Schema Definition DSL");
        root.addProperty("type", "object");

        JsonObject rootProps = new JsonObject();
        JsonArray rootRequired = new JsonArray();
        populateObjectProperties(Schema.class, rootProps, rootRequired);
        root.add("properties", rootProps);
        if (rootRequired.size() > 0)
          root.add("required", rootRequired);

        while (_Queue.isEmpty() == false)
          {
            Class<?> C = _Queue.poll();
            JsonObject def = new JsonObject();
            def.addProperty("type", "object");
            JsonObject props = new JsonObject();
            JsonArray required = new JsonArray();
            populateObjectProperties(C, props, required);
            def.add("properties", props);
            if (required.size() > 0)
              def.add("required", required);
            _Defs.put(_DefNames.get(C), def);
          }

        JsonObject defsOut = new JsonObject();
        for (Map.Entry<String, JsonObject> e : _Defs.entrySet()) // TreeMap: always alphabetical
          defsOut.add(e.getKey(), e.getValue());
        root.add("$defs", defsOut);

        return root;
      }

    private void populateObjectProperties(Class<?> clazz, JsonObject props, JsonArray required)
      {
        Object instance = tryNewInstance(clazz); // best-effort: used only to read each field's initialized (default) value

        for (Field f : getOrderedFields(clazz))
          {
            SerializedName sn = f.getAnnotation(SerializedName.class);
            if (sn == null || Modifier.isStatic(f.getModifiers()) == true || Modifier.isTransient(f.getModifiers()) == true)
              continue;

            String jsonName = sn.value();
            JsonObject fieldSchema = schemaForType(f.getGenericType());

            SchemaDoc doc = f.getAnnotation(SchemaDoc.class);
            String description = null;
            if (doc != null && doc.description().isEmpty() == false)
              description = doc.description();
            if (doc != null && doc.refKind() != SchemaRefKind.NONE)
              {
                String suffix = doc.refKind().getDescriptionSuffix();
                description = description == null ? suffix : description + " " + suffix;
              }
            if (description != null)
              fieldSchema.addProperty("description", description);

            addDefaultIfKnown(fieldSchema, f, instance);

            props.add(jsonName, fieldSchema);
            if (doc != null && doc.required() == true)
              required.add(jsonName);
          }
      }

    private static Object tryNewInstance(Class<?> clazz)
      {
        try
          {
            Constructor<?> ctor = clazz.getDeclaredConstructor();
            ctor.setAccessible(true);
            return ctor.newInstance();
          }
        catch (Throwable T)
          {
            // Abstract class, no no-arg constructor, or construction failed: simply skip default-value detection for it.
            return null;
          }
      }

    /**
     * Reads the field's already-initialized value off of instance (i.e., what Gson would leave in place if
     * the JSON omitted this property) and, for scalar/enum/empty-collection shapes only, records it as the
     * field schema's "default".
     */
    private static void addDefaultIfKnown(JsonObject fieldSchema, Field f, Object instance)
      {
        if (instance == null)
          return;

        Object value;
        try
          {
            f.setAccessible(true);
            value = f.get(instance);
          }
        catch (Throwable T)
          {
            return;
          }
        if (value == null)
          return;

        String type = fieldSchema.has("type") == true ? fieldSchema.get("type").getAsString() : null;

        if ("array".equals(type) == true)
          {
            int size;
            if (value.getClass().isArray() == true)
              size = Array.getLength(value);
            else if (value instanceof Collection<?>)
              size = ((Collection<?>) value).size();
            else
              return; // unrecognized collection shape: skip rather than guess

            if (size == 0) // non-empty defaults aren't expanded, to avoid recursively serializing nested POJOs
              fieldSchema.add("default", new JsonArray());
            return;
          }

        if (fieldSchema.has("$ref") == true || "object".equals(type) == true)
          return; // nested POJO/map defaults are intentionally not expanded; see class Javadoc

        if ("boolean".equals(type) == true && value instanceof Boolean)
          fieldSchema.addProperty("default", (Boolean) value);
        else if (("integer".equals(type) == true || "number".equals(type) == true) && value instanceof Number)
          fieldSchema.addProperty("default", (Number) value);
        else if ("string".equals(type) == true)
          fieldSchema.addProperty("default", value instanceof Enum<?> ? ((Enum<?>) value).name() : value.toString());
      }

    /**
     * @return the fields of clazz and all its superclasses (excluding java.lang.Object), ordered from the
     *         root-most superclass down to clazz itself, and in declaration order within each class.
     */
    private static List<Field> getOrderedFields(Class<?> clazz)
      {
        LinkedList<Class<?>> chain = new LinkedList<Class<?>>();
        for (Class<?> c = clazz; c != null && c != Object.class; c = c.getSuperclass())
          chain.addFirst(c);

        List<Field> fields = new ArrayList<Field>();
        for (Class<?> c : chain)
          for (Field f : c.getDeclaredFields())
            fields.add(f);
        return fields;
      }

    private JsonObject schemaForType(Type type)
      {
        if (type instanceof ParameterizedType)
          {
            ParameterizedType pt = (ParameterizedType) type;
            Class<?> raw = (Class<?>) pt.getRawType();
            if (Map.class.isAssignableFrom(raw) == true)
              {
                JsonObject o = new JsonObject();
                o.addProperty("type", "object");
                o.add("additionalProperties", schemaForType(pt.getActualTypeArguments()[1]));
                return o;
              }
            if (Collection.class.isAssignableFrom(raw) == true)
              {
                JsonObject o = new JsonObject();
                o.addProperty("type", "array");
                o.add("items", schemaForType(pt.getActualTypeArguments()[0]));
                return o;
              }
            return schemaForClass(raw);
          }

        if (type instanceof GenericArrayType)
          {
            GenericArrayType gat = (GenericArrayType) type;
            JsonObject o = new JsonObject();
            o.addProperty("type", "array");
            o.add("items", schemaForType(gat.getGenericComponentType()));
            return o;
          }

        if (type instanceof Class<?>)
          return schemaForClass((Class<?>) type);

        // Unresolvable generic (e.g. a bare type variable): fall back to an unconstrained string.
        return simple("string");
      }

    private JsonObject schemaForClass(Class<?> clazz)
      {
        if (clazz.isArray() == true)
          {
            JsonObject o = new JsonObject();
            o.addProperty("type", "array");
            o.add("items", schemaForClass(clazz.getComponentType()));
            return o;
          }

        if (clazz == String.class || CharSequence.class.isAssignableFrom(clazz) == true)
          return simple("string");
        if (clazz == Boolean.class || clazz == boolean.class)
          return simple("boolean");
        if (clazz == Integer.class || clazz == int.class || clazz == Short.class || clazz == short.class || clazz == Long.class || clazz == long.class)
          return simple("integer");
        if (clazz == Double.class || clazz == double.class || clazz == Float.class || clazz == float.class || BigDecimal.class.isAssignableFrom(clazz) == true)
          return simple("number");

        if (clazz.isEnum() == true)
          {
            JsonObject o = simple("string");
            JsonArray values = new JsonArray();
            for (Object v : clazz.getEnumConstants()) // declaration order, per Section 3's determinism requirement
              values.add(((Enum<?>) v).name());
            o.add("enum", values);
            return o;
          }

        if (Collection.class.isAssignableFrom(clazz) == true) // raw collection type, no generic info available
          {
            JsonObject o = new JsonObject();
            o.addProperty("type", "array");
            return o;
          }
        if (Map.class.isAssignableFrom(clazz) == true) // raw map type, no generic info available
          {
            JsonObject o = new JsonObject();
            o.addProperty("type", "object");
            return o;
          }

        if (clazz.getPackage() != null && MODEL_PACKAGE.equals(clazz.getPackage().getName()) == true)
          {
            JsonObject o = new JsonObject();
            o.addProperty("$ref", "#/$defs/" + registerDef(clazz));
            return o;
          }

        // Unknown/unsupported type reachable from a @SerializedName field: fall back rather than fail generation.
        return simple("string");
      }

    private String registerDef(Class<?> clazz)
      {
        String name = _DefNames.get(clazz);
        if (name != null)
          return name;

        name = "tilda" + clazz.getSimpleName();
        _DefNames.put(clazz, name);
        if (_Queued.add(clazz) == true)
          _Queue.add(clazz);
        return name;
      }

    private static JsonObject simple(String type)
      {
        JsonObject o = new JsonObject();
        o.addProperty("type", type);
        return o;
      }
  }
