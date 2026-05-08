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

package tilda.generation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import tilda.utils.PaddingUtil;

/**
 * Utility class for formatting Tilda JSON schema files with columnar layout.
 * <p>
 * This formatter produces nicely aligned JSON output matching the Tilda schema
 * formatting conventions:
 * <ul>
 * <li>Leading comma style (comma before the element, not after)</li>
 * <li>Columnar alignment for arrays of objects (columns, foreign keys, indices, etc.)</li>
 * <li>Padded key names for alignment (e.g., "type :" vs "sameas:")</li>
 * <li>Nested values arrays formatted inline with proper alignment</li>
 * </ul>
 */
public class TildaSchemaFormatter
  {
    // Standard column ordering for various element types
    private static final List<String> COLUMN_KEY_ORDER        = Arrays.asList(
    "name", "sameAs", "sameas", "type", "nullable", "invariant", "default", "description", "values", "jsonSchema");

    private static final List<String> FOREIGN_KEY_ORDER       = Arrays.asList(
    "name", "srcColumns", "destObject");

    private static final List<String> INDEX_KEY_ORDER         = Arrays.asList(
    "name", "columns", "orderBy", "db");

    private static final List<String> QUERY_KEY_ORDER         = Arrays.asList(
    "name", "description", "from", "wheres", "orderBy");

    private static final List<String> OUTPUT_MAP_KEY_ORDER    = Arrays.asList(
    "name", "outTypes", "columns");

    private static final List<String> VALUE_KEY_ORDER         = Arrays.asList(
    "name", "value", "description", "default");

    private static final List<String> WHERE_KEY_ORDER         = Arrays.asList(
    "db", "clause");

    private static final List<String> JOIN_KEY_ORDER          = Arrays.asList(
    "object", "joinType", "on");

    private static final List<String> OBJECT_KEY_ORDER        = Arrays.asList(
    "name", "lc", "description", "columns", "primary", "foreign", "indices", "queries", "outputMaps", "history");

    private static final List<String> ROOT_KEY_ORDER          = Arrays.asList(
    "package", "dependencies", "extraDDL", "objects", "views", "migrations");

    private static final Set<String>  COLUMNAR_ARRAYS         = new HashSet<>(Arrays.asList(
    "columns", "foreign", "indices", "queries", "outputMaps", "values", "fields", "wheres", "joins"));

    private static final Set<String>  MULTILINE_OBJECT_ARRAYS = new HashSet<>(Arrays.asList(
    "objects", "views", "queries"));

    /**
     * Formats a Tilda JSON schema string with proper columnar alignment.
     * 
     * @param json The input JSON string (can be minified/non-pretty)
     * @return The formatted JSON string with columnar layout
     */
    public static String format(String json)
      {
        JsonElement root = JsonParser.parseString(json);
        StringWriter writer = new StringWriter();
        try
          {
            formatRoot(writer, root.getAsJsonObject());
          }
        catch (IOException e)
          {
            throw new RuntimeException("Error formatting JSON", e);
          }
        return writer.toString();
      }

    /**
     * Formats a Tilda JSON schema file and writes the output to another file.
     * 
     * @param inputPath Path to the input JSON file
     * @param outputPath Path to the output formatted JSON file
     * @throws IOException If there's an error reading or writing files
     */
    public static void formatFile(String inputPath, String outputPath)
    throws IOException
      {
        String content = new String(Files.readAllBytes(Paths.get(inputPath)));
        String formatted = format(content);
        try (FileWriter writer = new FileWriter(outputPath))
          {
            writer.write(formatted);
          }
      }

    // =========================================================================
    // ROOT LEVEL FORMATTING
    // =========================================================================

    private static void formatRoot(Writer out, JsonObject root)
    throws IOException
      {
        out.write("{\n");

        List<String> keys = getOrderedKeys(root, ROOT_KEY_ORDER);
        boolean first = true;

        for (String key : keys)
          {
            JsonElement value = root.get(key);

            if (first)
              out.write("  ");
            else
              out.write("\n ,");

            out.write("\"" + key + "\":");

            if (key.equals("objects") || key.equals("views"))
              {
                formatObjectsArray(out, value.getAsJsonArray(), key);
              }
            else if (key.equals("dependencies"))
              {
                formatDependenciesArray(out, value.getAsJsonArray());
              }
            else if (value.isJsonArray())
              {
                formatSimpleArray(out, value.getAsJsonArray());
              }
            else if (value.isJsonObject())
              {
                formatGenericObject(out, value.getAsJsonObject(), 1);
              }
            else
              {
                formatPrimitive(out, value);
              }

            first = false;
          }

        out.write("\n   \n}\n");
      }

    private static void formatDependenciesArray(Writer out, JsonArray arr)
    throws IOException
      {
        out.write("[");
        boolean first = true;
        for (JsonElement elem : arr)
          {
            if (!first)
              out.write("\n                 ,");
            formatPrimitive(out, elem);
            first = false;
          }
        out.write("\n                 ]");
      }

    // =========================================================================
    // OBJECTS/VIEWS ARRAY FORMATTING
    // =========================================================================

    private static void formatObjectsArray(Writer out, JsonArray arr, String context)
    throws IOException
      {
        out.write("[\n");

        boolean first = true;
        for (JsonElement elem : arr)
          {
            if (elem.isJsonObject())
              {
                formatSchemaObject(out, elem.getAsJsonObject(), first, context);
              }
            first = false;
          }

        out.write("\n   ]");
      }

    private static void formatSchemaObject(Writer out, JsonObject obj, boolean first, String context)
    throws IOException
      {
        String indent = "    ";

        if (first)
          out.write(indent + " ");
        else
          out.write("\n\n" + indent + ",");

        out.write("{ ");

        List<String> keyOrder = context.equals("views")
        ? Arrays.asList("name", "description", "columns", "joins", "subWhere", "queries", "outputMaps")
        : OBJECT_KEY_ORDER;
        List<String> keys = getOrderedKeys(obj, keyOrder);

        boolean firstKey = true;
        for (String key : keys)
          {
            JsonElement value = obj.get(key);

            if (!firstKey)
              out.write("\n" + indent + " ,");

            out.write("\"" + key + "\":");

            if (key.equals("columns") || key.equals("fields"))
              {
                formatColumnsArray(out, value.getAsJsonArray(), indent);
              }
            else if (key.equals("foreign"))
              {
                formatForeignArray(out, value.getAsJsonArray(), indent);
              }
            else if (key.equals("indices"))
              {
                formatIndicesArray(out, value.getAsJsonArray(), indent);
              }
            else if (key.equals("queries"))
              {
                formatQueriesArray(out, value.getAsJsonArray(), indent);
              }
            else if (key.equals("outputMaps"))
              {
                formatOutputMapsArray(out, value.getAsJsonArray(), indent);
              }
            else if (key.equals("joins"))
              {
                formatJoinsArray(out, value.getAsJsonArray(), indent);
              }
            else if (key.equals("primary"))
              {
                out.write(" ");
                formatInlineObject(out, value.getAsJsonObject());
              }
            else if (key.equals("history"))
              {
                formatGenericObject(out, value.getAsJsonObject(), 4);
              }
            else if (value.isJsonArray())
              {
                formatSimpleArray(out, value.getAsJsonArray());
              }
            else if (value.isJsonObject())
              {
                formatGenericObject(out, value.getAsJsonObject(), 4);
              }
            else
              {
                formatPrimitive(out, value);
              }

            firstKey = false;
          }

        out.write("\n" + indent + " }");
      }

    // =========================================================================
    // COLUMNS ARRAY FORMATTING (with columnar alignment)
    // =========================================================================

    private static void formatColumnsArray(Writer out, JsonArray arr, String baseIndent)
    throws IOException
      {
        out.write("[\n");

        // Calculate column widths
        int maxNameLen = 0;
        int maxTypeOrSameAsLen = 0;
        int maxTypeOrSameAsKeyLen = 0; // "type" vs "sameAs" vs "sameas"

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject col = elem.getAsJsonObject();

            if (col.has("name"))
              maxNameLen = Math.max(maxNameLen, col.get("name").getAsString().length());

            String typeKey = col.has("type") ? "type" : (col.has("sameAs") ? "sameAs" : (col.has("sameas") ? "sameas" : ""));
            maxTypeOrSameAsKeyLen = Math.max(maxTypeOrSameAsKeyLen, typeKey.length());

            if (col.has("type"))
              maxTypeOrSameAsLen = Math.max(maxTypeOrSameAsLen, primitiveToString(col.get("type")).length());
            else if (col.has("sameAs"))
              maxTypeOrSameAsLen = Math.max(maxTypeOrSameAsLen, primitiveToString(col.get("sameAs")).length());
            else if (col.has("sameas"))
              maxTypeOrSameAsLen = Math.max(maxTypeOrSameAsLen, primitiveToString(col.get("sameas")).length());
          }

        String rowIndent = baseIndent + "      ";
        boolean first = true;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject col = elem.getAsJsonObject();

            if (first)
              out.write(rowIndent + "  ");
            else
              out.write("\n" + rowIndent + " ,");

            out.write("{ ");
            formatColumnRow(out, col, maxNameLen, maxTypeOrSameAsLen, maxTypeOrSameAsKeyLen, rowIndent);
            out.write(" }");

            first = false;
          }

        out.write("\n" + rowIndent + "]");
      }

    private static void formatColumnRow(Writer out, JsonObject col, int maxNameLen, int maxTypeLen, int maxTypeKeyLen, String indent)
    throws IOException
      {
        List<String> keys = getOrderedKeys(col, COLUMN_KEY_ORDER);

        boolean firstKey = true;
        for (String key : keys)
          {
            JsonElement value = col.get(key);

            if (!firstKey)
              out.write(", ");

            // Handle special padding for name, type/sameAs
            if (key.equals("name"))
              {
                out.write("\"name\":");
                String nameVal = primitiveToString(value);
                out.write(PaddingUtil.pad(nameVal, maxNameLen + 2));
              }
            else if (key.equals("type") || key.equals("sameAs") || key.equals("sameas"))
              {
                out.write("\"" + PaddingUtil.pad(key + "\"", maxTypeKeyLen + 1) + ":");
                String typeVal = primitiveToString(value);
                out.write(PaddingUtil.pad(typeVal, maxTypeLen));
              }
            else if (key.equals("values"))
              {
                out.write("\"values\":");
                formatValuesArray(out, value.getAsJsonArray(), indent);
              }
            else if (key.equals("jsonSchema"))
              {
                out.write("\"jsonSchema\": ");
                formatJsonSchemaObject(out, value.getAsJsonObject(), indent);
              }
            else if (value.isJsonArray())
              {
                out.write("\"" + key + "\":");
                formatSimpleArray(out, value.getAsJsonArray());
              }
            else
              {
                out.write("\"" + key + "\":");
                formatPrimitive(out, value);
              }

            firstKey = false;
          }
      }

    // =========================================================================
    // VALUES ARRAY FORMATTING (inline with alignment)
    // =========================================================================

    private static void formatValuesArray(Writer out, JsonArray arr, String baseIndent)
    throws IOException
      {
        if (arr.size() == 0)
          {
            out.write(" []");
            return;
          }

        // Calculate column widths for values
        int maxNameLen = 0;
        int maxValueLen = 0;
        int maxDescLen = 0;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject val = elem.getAsJsonObject();
            if (val.has("name"))
              maxNameLen = Math.max(maxNameLen, primitiveToString(val.get("name")).length());
            if (val.has("value"))
              maxValueLen = Math.max(maxValueLen, primitiveToString(val.get("value")).length());
            if (val.has("description"))
              maxDescLen = Math.max(maxDescLen, primitiveToString(val.get("description")).length());
          }

        out.write(" [ ");
        String valuesIndent = baseIndent + "                                        ";

        boolean first = true;
        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject val = elem.getAsJsonObject();

            if (!first)
              out.write("\n" + valuesIndent + ",");

            out.write("{ ");
            formatValueRow(out, val, maxNameLen, maxValueLen, maxDescLen);
            out.write(" }");

            first = false;
          }

        out.write("\n" + valuesIndent + "]");
      }

    private static void formatValueRow(Writer out, JsonObject val, int maxNameLen, int maxValueLen, int maxDescLen)
    throws IOException
      {
        List<String> keys = getOrderedKeys(val, VALUE_KEY_ORDER);

        boolean firstKey = true;
        for (String key : keys)
          {
            JsonElement value = val.get(key);

            if (!firstKey)
              out.write(", ");

            out.write("\"" + key + "\":");

            if (key.equals("name"))
              out.write(PaddingUtil.pad(primitiveToString(value), maxNameLen));
            else if (key.equals("value"))
              out.write(PaddingUtil.pad(primitiveToString(value), maxValueLen));
            else if (key.equals("description"))
              out.write(PaddingUtil.pad(primitiveToString(value), maxDescLen));
            else
              formatPrimitive(out, value);

            firstKey = false;
          }
      }

    // =========================================================================
    // FOREIGN KEYS ARRAY FORMATTING
    // =========================================================================

    private static void formatForeignArray(Writer out, JsonArray arr, String baseIndent)
    throws IOException
      {
        out.write(" [\n");

        // Calculate column widths
        int maxNameLen = 0;
        int maxSrcColsLen = 0;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject fk = elem.getAsJsonObject();
            if (fk.has("name"))
              maxNameLen = Math.max(maxNameLen, primitiveToString(fk.get("name")).length());
            if (fk.has("srcColumns"))
              maxSrcColsLen = Math.max(maxSrcColsLen, arrayToString(fk.get("srcColumns").getAsJsonArray()).length());
          }

        String rowIndent = baseIndent + "      ";
        boolean first = true;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject fk = elem.getAsJsonObject();

            if (first)
              out.write(rowIndent + "  ");
            else
              out.write("\n" + rowIndent + " ,");

            out.write("{ ");

            // Format: { "name":"Creator" , "srcColumns":["creatorRefnum"] , "destObject":"wanda.data.WANDA.User" }
            if (fk.has("name"))
              {
                out.write("\"name\":");
                out.write(PaddingUtil.pad(primitiveToString(fk.get("name")), maxNameLen));
              }
            if (fk.has("srcColumns"))
              {
                out.write(", \"srcColumns\":");
                out.write(PaddingUtil.pad(arrayToString(fk.get("srcColumns").getAsJsonArray()), maxSrcColsLen));
              }
            if (fk.has("destObject"))
              {
                out.write(", \"destObject\":");
                formatPrimitive(out, fk.get("destObject"));
              }

            out.write(" }");
            first = false;
          }

        out.write("\n" + rowIndent + "]");
      }

    // =========================================================================
    // INDICES ARRAY FORMATTING
    // =========================================================================

    private static void formatIndicesArray(Writer out, JsonArray arr, String baseIndent)
    throws IOException
      {
        out.write(" [\n");

        // Calculate column widths
        int maxNameLen = 0;
        int maxColsLen = 0;
        int maxOrderByLen = 0;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject idx = elem.getAsJsonObject();
            if (idx.has("name"))
              maxNameLen = Math.max(maxNameLen, primitiveToString(idx.get("name")).length());
            if (idx.has("columns"))
              maxColsLen = Math.max(maxColsLen, arrayToString(idx.get("columns").getAsJsonArray()).length());
            if (idx.has("orderBy"))
              maxOrderByLen = Math.max(maxOrderByLen, arrayToString(idx.get("orderBy").getAsJsonArray()).length());
          }

        String rowIndent = baseIndent + "      ";
        boolean first = true;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject idx = elem.getAsJsonObject();

            if (first)
              out.write(rowIndent + "  ");
            else
              out.write("\n" + rowIndent + " ,");

            out.write("{ ");
            formatIndexRow(out, idx, maxNameLen, maxColsLen, maxOrderByLen);
            out.write(" }");

            first = false;
          }

        out.write("\n" + rowIndent + "]");
      }

    private static void formatIndexRow(Writer out, JsonObject idx, int maxNameLen, int maxColsLen, int maxOrderByLen)
    throws IOException
      {
        boolean firstKey = true;

        if (idx.has("name"))
          {
            out.write("\"name\": ");
            out.write(PaddingUtil.pad(primitiveToString(idx.get("name")), maxNameLen));
            firstKey = false;
          }
        if (idx.has("columns"))
          {
            if (!firstKey)
              out.write(", ");
            out.write("\"columns\": ");
            out.write(PaddingUtil.pad(arrayToString(idx.get("columns").getAsJsonArray()), maxColsLen));
            firstKey = false;
          }
        if (idx.has("orderBy"))
          {
            if (!firstKey)
              out.write(", ");
            out.write("\"orderBy\":");
            out.write(PaddingUtil.pad(arrayToString(idx.get("orderBy").getAsJsonArray()), maxOrderByLen));
            firstKey = false;
          }
        if (idx.has("db"))
          {
            if (!firstKey)
              out.write(", ");
            out.write("\"db\":");
            formatPrimitive(out, idx.get("db"));
          }
      }

    // =========================================================================
    // QUERIES ARRAY FORMATTING
    // =========================================================================

    private static void formatQueriesArray(Writer out, JsonArray arr, String baseIndent)
    throws IOException
      {
        out.write(" [\n");

        String rowIndent = baseIndent + "      ";
        boolean first = true;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject query = elem.getAsJsonObject();

            if (first)
              out.write(rowIndent + "  ");
            else
              out.write("\n" + rowIndent + " ,");

            out.write("{ ");
            formatQueryObject(out, query, rowIndent);
            out.write("\n" + rowIndent + "  }");

            first = false;
          }

        out.write("\n" + rowIndent + "]");
      }

    private static void formatQueryObject(Writer out, JsonObject query, String baseIndent)
    throws IOException
      {
        List<String> keys = getOrderedKeys(query, QUERY_KEY_ORDER);
        String propIndent = baseIndent + "   ";

        boolean firstKey = true;
        for (String key : keys)
          {
            JsonElement value = query.get(key);

            if (!firstKey)
              out.write("\n" + propIndent + ",");

            // Pad key names for alignment
            if (key.equals("name"))
              out.write("\"name\"  : ");
            else
              out.write("\"" + key + "\": ");

            if (key.equals("wheres"))
              {
                formatWheresArray(out, value.getAsJsonArray(), propIndent);
              }
            else if (value.isJsonArray())
              {
                formatSimpleArray(out, value.getAsJsonArray());
              }
            else
              {
                formatPrimitive(out, value);
              }

            firstKey = false;
          }
      }

    private static void formatWheresArray(Writer out, JsonArray arr, String baseIndent)
    throws IOException
      {
        out.write("[\n");

        String rowIndent = baseIndent + "    ";
        boolean first = true;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject where = elem.getAsJsonObject();

            if (first)
              out.write(rowIndent + "    ");
            else
              out.write("\n" + rowIndent + "   ,");

            out.write("{ ");

            if (where.has("db"))
              {
                out.write("\"db\": ");
                formatPrimitive(out, where.get("db"));
              }
            if (where.has("clause"))
              {
                out.write(", \"clause\": ");
                formatPrimitive(out, where.get("clause"));
              }

            out.write(" }");
            first = false;
          }

        out.write("\n" + rowIndent + " ]");
      }

    // =========================================================================
    // OUTPUT MAPS ARRAY FORMATTING
    // =========================================================================

    private static void formatOutputMapsArray(Writer out, JsonArray arr, String baseIndent)
    throws IOException
      {
        out.write(" [\n");

        // Calculate widths
        int maxNameLen = 0;
        int maxOutTypesLen = 0;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject om = elem.getAsJsonObject();
            if (om.has("name"))
              maxNameLen = Math.max(maxNameLen, primitiveToString(om.get("name")).length());
            if (om.has("outTypes"))
              maxOutTypesLen = Math.max(maxOutTypesLen, arrayToString(om.get("outTypes").getAsJsonArray()).length());
          }

        String rowIndent = baseIndent + "      ";
        boolean first = true;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject om = elem.getAsJsonObject();

            if (first)
              out.write(rowIndent + "  ");
            else
              out.write("\n" + rowIndent + " ,");

            out.write("{ ");

            if (om.has("name"))
              {
                out.write("\"name\": ");
                out.write(PaddingUtil.pad(primitiveToString(om.get("name")), maxNameLen));
              }
            if (om.has("outTypes"))
              {
                out.write(", \"outTypes\":");
                out.write(arrayToString(om.get("outTypes").getAsJsonArray()));
              }
            if (om.has("columns"))
              {
                out.write(", \"columns\": ");
                formatSimpleArray(out, om.get("columns").getAsJsonArray());
              }

            out.write(" }");
            first = false;
          }

        out.write("\n" + rowIndent + "]");
      }

    // =========================================================================
    // JOINS ARRAY FORMATTING (for views)
    // =========================================================================

    private static void formatJoinsArray(Writer out, JsonArray arr, String baseIndent)
    throws IOException
      {
        out.write(" [\n");

        String rowIndent = baseIndent + "      ";
        boolean first = true;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject join = elem.getAsJsonObject();

            if (first)
              out.write(rowIndent + "  ");
            else
              out.write("\n" + rowIndent + " ,");

            out.write("{ ");
            formatJoinRow(out, join, rowIndent);
            out.write(" }");

            first = false;
          }

        out.write("\n" + rowIndent + "]");
      }

    private static void formatJoinRow(Writer out, JsonObject join, String indent)
    throws IOException
      {
        List<String> keys = getOrderedKeys(join, JOIN_KEY_ORDER);

        boolean firstKey = true;
        for (String key : keys)
          {
            JsonElement value = join.get(key);

            if (!firstKey)
              out.write(", ");

            out.write("\"" + key + "\": ");

            if (key.equals("on"))
              {
                formatOnArray(out, value.getAsJsonArray(), indent);
              }
            else if (value.isJsonArray())
              {
                formatSimpleArray(out, value.getAsJsonArray());
              }
            else
              {
                formatPrimitive(out, value);
              }

            firstKey = false;
          }
      }

    private static void formatOnArray(Writer out, JsonArray arr, String baseIndent)
    throws IOException
      {
        out.write("[ ");
        boolean first = true;
        for (JsonElement elem : arr)
          {
            if (!first)
              out.write(", ");
            if (elem.isJsonObject())
              {
                out.write("{ ");
                JsonObject on = elem.getAsJsonObject();
                boolean firstProp = true;
                for (String key : on.keySet())
                  {
                    if (!firstProp)
                      out.write(", ");
                    out.write("\"" + key + "\":");
                    formatPrimitive(out, on.get(key));
                    firstProp = false;
                  }
                out.write(" }");
              }
            first = false;
          }
        out.write(" ]");
      }

    // =========================================================================
    // JSON SCHEMA FORMATTING
    // =========================================================================

    private static void formatJsonSchemaObject(Writer out, JsonObject schema, String baseIndent)
    throws IOException
      {
        out.write("{\n");

        String propIndent = baseIndent + "                                             ";
        boolean first = true;

        for (String key : schema.keySet())
          {
            JsonElement value = schema.get(key);

            if (first)
              out.write(propIndent + " ");
            else
              out.write("\n" + propIndent + ",");

            out.write("\"" + key + "\": ");

            if (key.equals("fields"))
              {
                formatFieldsArray(out, value.getAsJsonArray(), propIndent);
              }
            else if (value.isJsonArray())
              {
                formatSimpleArray(out, value.getAsJsonArray());
              }
            else
              {
                formatPrimitive(out, value);
              }

            first = false;
          }

        out.write("\n" + propIndent + "}");
      }

    private static void formatFieldsArray(Writer out, JsonArray arr, String baseIndent)
    throws IOException
      {
        out.write("[\n");

        // Calculate widths
        int maxNameLen = 0;
        int maxTypeLen = 0;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject field = elem.getAsJsonObject();
            if (field.has("name"))
              maxNameLen = Math.max(maxNameLen, primitiveToString(field.get("name")).length());
            if (field.has("type"))
              maxTypeLen = Math.max(maxTypeLen, primitiveToString(field.get("type")).length());
          }

        String rowIndent = baseIndent + "    ";
        boolean first = true;

        for (JsonElement elem : arr)
          {
            if (!elem.isJsonObject())
              continue;
            JsonObject field = elem.getAsJsonObject();

            if (first)
              out.write(rowIndent + "    ");
            else
              out.write("\n" + rowIndent + "   ,");

            out.write("{");

            if (field.has("name"))
              {
                out.write("\"name\":");
                out.write(PaddingUtil.pad(primitiveToString(field.get("name")), maxNameLen));
              }
            if (field.has("type"))
              {
                out.write(", \"type\":");
                out.write(PaddingUtil.pad(primitiveToString(field.get("type")), maxTypeLen));
              }
            if (field.has("description"))
              {
                out.write(", \"description\":");
                formatPrimitive(out, field.get("description"));
              }

            out.write(" }");
            first = false;
          }

        out.write("\n" + rowIndent + "  ]");
      }

    // =========================================================================
    // GENERIC/UTILITY FORMATTING METHODS
    // =========================================================================

    private static void formatGenericObject(Writer out, JsonObject obj, int indentLevel)
    throws IOException
      {
        String indent = PaddingUtil.getPad(indentLevel * 3);
        out.write("{\n");

        boolean first = true;
        for (String key : obj.keySet())
          {
            JsonElement value = obj.get(key);

            if (first)
              out.write(indent + "   ");
            else
              out.write("\n" + indent + "  ,");

            out.write("\"" + key + "\":");

            if (value.isJsonArray())
              formatSimpleArray(out, value.getAsJsonArray());
            else if (value.isJsonObject())
              formatGenericObject(out, value.getAsJsonObject(), indentLevel + 1);
            else
              formatPrimitive(out, value);

            first = false;
          }

        out.write("\n" + indent + " }");
      }

    private static void formatInlineObject(Writer out, JsonObject obj)
    throws IOException
      {
        out.write("{ ");
        boolean first = true;
        for (String key : obj.keySet())
          {
            if (!first)
              out.write(", ");
            out.write("\"" + key + "\": ");
            JsonElement val = obj.get(key);
            if (val.isJsonPrimitive())
              formatPrimitive(out, val);
            else if (val.isJsonNull())
              out.write("null");
            else if (val.isJsonArray())
              formatSimpleArray(out, val.getAsJsonArray());
            first = false;
          }
        out.write(" }");
      }

    private static void formatSimpleArray(Writer out, JsonArray arr)
    throws IOException
      {
        out.write("[");
        boolean first = true;
        for (JsonElement elem : arr)
          {
            if (!first)
              out.write(",");
            if (elem.isJsonPrimitive())
              formatPrimitive(out, elem);
            else if (elem.isJsonNull())
              out.write("null");
            else if (elem.isJsonObject())
              formatInlineObject(out, elem.getAsJsonObject());
            first = false;
          }
        out.write("]");
      }

    private static void formatPrimitive(Writer out, JsonElement elem)
    throws IOException
      {
        if (elem.isJsonNull())
          {
            out.write("null");
            return;
          }
        if (!elem.isJsonPrimitive())
          {
            out.write(elem.toString());
            return;
          }

        JsonPrimitive prim = elem.getAsJsonPrimitive();
        if (prim.isString())
          out.write("\"" + escapeString(prim.getAsString()) + "\"");
        else if (prim.isBoolean())
          out.write(prim.getAsBoolean() ? "true" : "false");
        else if (prim.isNumber())
          out.write(prim.getAsNumber().toString());
      }

    private static String primitiveToString(JsonElement elem)
      {
        if (elem == null || elem.isJsonNull())
          return "null";
        if (!elem.isJsonPrimitive())
          return elem.toString();

        JsonPrimitive prim = elem.getAsJsonPrimitive();
        if (prim.isString())
          return "\"" + escapeString(prim.getAsString()) + "\"";
        else if (prim.isBoolean())
          return prim.getAsBoolean() ? "true" : "false";
        else
          return prim.getAsNumber().toString();
      }

    private static String arrayToString(JsonArray arr)
      {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (JsonElement elem : arr)
          {
            if (!first)
              sb.append(",");
            sb.append(primitiveToString(elem));
            first = false;
          }
        sb.append("]");
        return sb.toString();
      }

    private static String escapeString(String s)
      {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
          {
            switch (c)
              {
                case '"':
                  sb.append("\\\"");
                  break;
                case '\\':
                  sb.append("\\\\");
                  break;
                case '\n':
                  sb.append("\\n");
                  break;
                case '\r':
                  sb.append("\\r");
                  break;
                case '\t':
                  sb.append("\\t");
                  break;
                default:
                  sb.append(c);
              }
          }
        return sb.toString();
      }

    private static List<String> getOrderedKeys(JsonObject obj, List<String> keyOrder)
      {
        List<String> result = new ArrayList<>();

        // First add keys in preferred order
        for (String key : keyOrder)
          {
            if (obj.has(key))
              result.add(key);
          }

        // Then add remaining keys
        for (String key : obj.keySet())
          {
            if (!result.contains(key))
              result.add(key);
          }

        return result;
      }

    /**
     * Main method for command-line usage.
     * Usage: java TildaSchemaFormatter <input-file> [output-file]
     * If output-file is not specified, the formatted JSON is printed to stdout.
     */
    public static void main(String[] args)
      {
        if (args.length < 1)
          {
            System.err.println("Usage: java TildaSchemaFormatter <input-file> [output-file]");
            System.exit(1);
          }

        try
          {
            String inputPath = args[0];
            String content = new String(Files.readAllBytes(Paths.get(inputPath)));
            String formatted = format(content);

            if (args.length >= 2)
              {
                try (FileWriter writer = new FileWriter(args[1]))
                  {
                    writer.write(formatted);
                  }
                System.out.println("Formatted JSON written to: " + args[1]);
              }
            else
              {
                System.out.println(formatted);
              }
          }
        catch (Exception e)
          {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
          }
      }
  }
