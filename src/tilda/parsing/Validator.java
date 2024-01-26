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

package tilda.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;

import tilda.parsing.parts.Schema;
import tilda.utils.ClassUtils;
import tilda.utils.FileUtil;
import tilda.utils.PaddingUtil;
import tilda.utils.TextUtil;
import tilda.utils.json.JSONUtil;

public abstract class Validator
  {
    protected static final Logger LOG                = LogManager.getLogger(Validator.class.getName());

    protected static int          _INDENT_MULTIPLIER = 3;

    protected static class Column
      {
        Column(String str, int group)
          {
            _str = str;
            _group = group;
          }

        protected String _str;
        protected int    _group;
      }

    protected static class Line
      {
        protected List<Column> _columns             = new ArrayList<Column>();
        int                    _subColumnGroupStart = 0;
        protected List<Line>   _subColumns          = new ArrayList<Line>();

        protected void add(String columnStr, int columnGroup)
          {
            _columns.add(new Column(columnStr, columnGroup));
          }

        public String join(String separator)
          {
            StringBuilder str = new StringBuilder();
            boolean first = true;
            for (Column c : _columns)
              {
                if (first == false)
                 str.append(separator);
                else
                 first = false;
                str.append(c._str);
              }
            return str.toString();
          }
      }

    public static void validateCodeModel(List<Line> table, JsonObject tildaDef, Class tildaPartClass, TildaLayoutDef[] tildaLayoutDefs, int level, boolean parentFlatPrint)
    throws IOException
      {
        if (tildaDef == null)
          return;
        Line line = new Line();
        line = validateCodeModel(table, tildaPartClass, tildaLayoutDefs, level, parentFlatPrint, tildaDef, line, false);
      }

    public static void validateCodeModel(List<Line> table, JsonArray tildaDef, Class tildaPartClass, TildaLayoutDef[] tildaLayoutDefs, int level, boolean parentFlatPrint)
    throws IOException
      {
        if (tildaDef == null || tildaDef.size() == 0)
          return;
        for (int i = 0; i < tildaDef.size(); ++i)
          {
            JsonObject e = tildaDef.get(i).getAsJsonObject();
            Line line = new Line();
            line.add((parentFlatPrint == true ? PaddingUtil.getPad(level) : "") + (i == 0 ? " {" : ",{"), 0);
            line = validateCodeModel(table, tildaPartClass, tildaLayoutDefs, level, parentFlatPrint, e, line, true);
            // There are cases for flat-printing where no new line is added, and the line is already added in validateCodeModel
            // There are other cases where one line is wrapped, and a new line is created in validateCodeModel in the last loop
            // and so the line needs to be added here.
            // This is definitely hacky.
            boolean found = true;
            for (Line l : table)
              if (l == line)
                {
                  found = true;
                  break;
                }
            if (found == false)
              table.add(line);
            // If not flat-printing, need to wrap to a new line.
            if (parentFlatPrint == false)
              {
                line = new Line();
                table.add(line);
              }
            line.add(" }", 1000);
          }
      }


    private static Field getField(List<Field> fields, String prop)
      {
        for (Field f : fields)
          {
            SerializedName a = f.getAnnotation(SerializedName.class);
            if (a != null && a.value().equals(prop) == true)
              return f;
          }
        return null;
      }

    private static boolean isNullOrEmpty(JsonElement e)
      {
        if (e == null || e.isJsonNull() == true)
          return true;

        if (e.isJsonArray() == true && e.getAsJsonArray().size() == 0)
          return true;

        return false;
      }

    protected static JsonElement getElementCaseInsensitive(JsonObject e, String propName)
      {
        for (String s : e.keySet())
          {
            if (s != null && s.equalsIgnoreCase(propName) == true)
              return e.get(s);
          }
        return null;
      }


    protected static Line validateCodeModel(List<Line> table, Class tildaPartClass, TildaLayoutDef[] tildaLayoutDefs, int level, boolean parentFlatPrint, JsonObject e, Line line, boolean objectArray)
    throws IOException
      {
        boolean firstElement = true;
        List<Field> fields = new ArrayList<Field>();
        ClassUtils.getAllDeclaredFields(fields, tildaPartClass);
        int colGroup = -1;
        for (TildaLayoutDef tld : tildaLayoutDefs)
          {
            Field f = getField(fields, tld._prop);
            if (f != null)
              {
                Class t = f.getType();
                boolean multi = false;
                // if (tld._prop.equals("sameAs") == true)
                // LOG.debug("XXX");
                if (firstElement == false && parentFlatPrint == false)
                  {
                    line = new Line();
                    colGroup = -1;
                    if (objectArray == true)
                      line.add("", ++colGroup);
                  }
                if (t.isArray() == true)
                  {
                    multi = true;
                    t = t.arrayType().getComponentType().getComponentType();
                  }
                else if (List.class.isAssignableFrom(t) == true)
                  {
                    multi = true;
                    t = (Class<?>) ((ParameterizedType) f.getGenericType()).getActualTypeArguments()[0];
                  }
                JsonElement ee = getElementCaseInsensitive(e, tld._prop);
                if (isNullOrEmpty(ee) == true)
                  continue;
                boolean tildaPart = t.getName().startsWith("tilda.parsing.parts.");
                if (tildaPart == false)
                  {
                    if (multi == true)
                      printArray(line, level + 1, tld._prop, ee.getAsJsonArray(), tld._flatPrint, firstElement, t, tld._group > 0 ? tld._group : ++colGroup);
                    else
                      printValue(line, tld._prop, ee.getAsJsonPrimitive(), firstElement, t, parentFlatPrint || tld._flatPrint, tld._group > 0 ? tld._group : ++colGroup);
                  }
                else if (tld != null)
                  {
                    if (tld._nextLine == true)
                      {
                        table.add(line);
                        line = new Line();
                        colGroup = tld._alignOn - 1;
                        line.add("", ++colGroup);
                      }
                    line.add((firstElement == true ? " " : tld._nextLine == true ? ", " : ",") + "\"" + tld._prop + "\"", tld._group > 0 ? tld._group : ++colGroup);
                    line.add(": ", tld._group > 0 ? tld._group : ++colGroup);
                    line.add(multi == true ? "[" : "{", tld._group > 0 ? tld._group : ++colGroup);
                    if (parentFlatPrint == false && tld._flatPrint == false)
                      {
                        table.add(line);
                        line = new Line();
                      }
                    if (multi == true)
                      {
                        if (tld._nextLine == true)
                          line._subColumnGroupStart = tld._alignOn;
                        validateCodeModel(line._subColumns, ee.getAsJsonArray(), t, tld._subProps, level + 1, tld._flatPrint);
                      }
                    else
                      validateCodeModel(line._subColumns, ee.getAsJsonObject(), t, tld._subProps, level, tld._flatPrint);
                    if (parentFlatPrint == false && tld._flatPrint == false || multi == true && objectArray == true)
                      {
                        table.add(line);
                        line = new Line();
                        colGroup = -1;
                        if (multi == true && objectArray == true)
                          line.add("", ++colGroup);
                      }
                    line.add(PaddingUtil.getPad(4) + (multi == true ? "]" : "}"), tld._group > 0 ? tld._group : ++colGroup);
                  }
                if (firstElement == true || parentFlatPrint == false)
                  table.add(line);
                firstElement = false;
              }
          }
        return line;
      }

    protected static void printColAligned(Writer out, List<Line> table, int level)
    throws IOException
      {
        int maxColumns = 0;
        for (int i = 0; i < table.size(); ++i)
          if (table.get(i)._columns.size() > maxColumns)
            maxColumns = table.get(i)._columns.size();

//        List<Integer> groups = new ArrayList<Integer>;
        int[] maxWidths = new int[maxColumns];
        for (int i = 0; i < table.size(); ++i)
          {
            Line row = table.get(i);
            for (int j = 0; j < row._columns.size(); ++j)
              {
                int len = row._columns.get(j) == null ? 0 : row._columns.get(j)._str.length();
                if (maxWidths[j] < len)
                  maxWidths[j] = len;
              }
          }
        for (int i = 0; i < table.size(); ++i)
          {
            Line row = table.get(i);
            String line = row.join("").trim();
            // if (line.indexOf("cloneFrom") != -1)
            // LOG.debug("XXX");
            if (TextUtil.isNullOrEmpty(line) == false)
              {
                out.append(PaddingUtil.getPad(level * _INDENT_MULTIPLIER));
                for (int j = 0; j < row._columns.size() - 1; ++j)
                  out.append("|"+row._columns.get(j)._group + PaddingUtil.pad(row._columns.get(j)._str, maxWidths[j]));
                out.append("|"+row._columns.get(row._columns.size() - 1)._group + row._columns.get(row._columns.size() - 1)._str.stripTrailing());
                out.append("\n");
              }
            if (row._subColumns.isEmpty() == false)
              printColAligned(out, row._subColumns, level + 1);
          }
      }

    protected static void printArray(Line out, int level, String name, JsonArray val, boolean flatPrint, boolean first, Class type, int colGroup)
    throws IOException
      {
        out.add((first == true ? " " : ",") + "\"" + name + "\"", colGroup);
        out.add(": ", colGroup);
        if (val == null || val.isJsonNull() == true)
          out.add("null", colGroup);
        else if (val.size() == 0)
          out.add("[]", colGroup);
        else
          {
            StringBuilderWriter w = new StringBuilderWriter();
            JSONUtil.print(w, level * _INDENT_MULTIPLIER, name, first, val, type, flatPrint);
            String[] parts = w.toString().split("\\\"\\s*\\:\\s*");
            out.add(parts[1], colGroup);
          }
      }

    protected static void printValue(Line out, String name, JsonPrimitive val, boolean firstElement, Class<?> type, boolean flatPrint, int colGroup)
    throws IOException
      {
        out.add((firstElement == true ? " " : flatPrint == true ? ", " : ",") + "\"" + name + "\"", colGroup);
        out.add(": ", colGroup);
        out.add(val == null || val.isJsonNull() == true ? "null"
        : val.isString() == true ? TextUtil.escapeDoubleQuoteWithSlash(val.getAsString())
        : val.isBoolean() == true ? Boolean.toString(val.getAsBoolean())
        : type.isAssignableFrom(Long.class) ? Long.toString(val.getAsLong())
        : type.isAssignableFrom(Integer.class) ? Integer.toString(val.getAsInt())
        : type.isAssignableFrom(Short.class) ? Short.toString(val.getAsShort())
        : type.isAssignableFrom(Double.class) ? Double.toString(val.getAsDouble())
        : type.isAssignableFrom(Float.class) ? Float.toString(val.getAsFloat())
        : "XXXXXXXXXX__UNKNOWN___" + type
        , colGroup);
      }

    public static void main(String[] args)
    throws IOException
      {
        BufferedReader R = FileUtil.getReaderFromFileOrResource(args[0]);
        JsonObject j = JSONUtil.fromJSONObj(R);
        R.close();

        R = FileUtil.getReaderFromFileOrResource("tilda/parsing/JSONPrinterColumnFormatter.json");
        Gson gson = new GsonBuilder().create();
        TildaLayoutDef[] TLDL = gson.fromJson(R, TildaLayoutDef[].class);
        R.close();

        final int _INITIAL_INDENT = 1;
        List<Line> table = new ArrayList<Line>();
        try
          {
            validateCodeModel(table, j, Schema.class, TLDL, _INITIAL_INDENT, false);
          }
        catch (Throwable T)
          {
            LOG.error("\n", T);
          }
        StringBuilderWriter out = new StringBuilderWriter();
        printColAligned(out, table, _INITIAL_INDENT);
        LOG.debug("\n" + out.toString());
      }
  }
