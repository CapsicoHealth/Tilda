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

        public String toString()
          {
            return join("");
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
                    if (objectArray == true)
                      line.add("", 0);
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
                      printArray(line, level + 1, tld._prop, ee.getAsJsonArray(), tld._flatPrint, firstElement, t, tld._group);
                    else
                      printValue(line, tld._prop, ee.getAsJsonPrimitive(), firstElement, t, parentFlatPrint || tld._flatPrint, tld._group);
                  }
                else if (tld != null)
                  {
                    if (tld._nextLine == true)
                      {
                        // table.add(line);
                        line = new Line();
                        // line.add("", tld._group);
                      }
                    if (tld._prop.equals("values") == true)
                      LOG.debug("XXX");
                    line.add((firstElement == true ? " " : tld._nextLine == true ? ", " : ",") + "\"" + tld._prop + "\"", tld._group);
                    line.add(": ", tld._group);
                    line.add(multi == true ? "[" : "{", tld._group);
                    if (parentFlatPrint == false && tld._flatPrint == false)
                      {
                        table.add(line);
                        line = new Line();
                      }
                    if (multi == true)
                      {
                        if (tld._nextLine == true)
                          line._subColumnGroupStart = tld._group;
                        validateCodeModel(line._subColumns, ee.getAsJsonArray(), t, tld._subProps, level + 1, tld._flatPrint);
                      }
                    else
                      validateCodeModel(line._subColumns, ee.getAsJsonObject(), t, tld._subProps, level, tld._flatPrint);
                    if (parentFlatPrint == false && tld._flatPrint == false || multi == true && objectArray == true)
                      {
                        table.add(line);
                        line = new Line();
                        if (multi == true && objectArray == true)
                          line.add("", 0);
                      }
                    line.add(PaddingUtil.getPad(2) + (multi == true ? "]" : "}"), tld._group);
                  }
                if (firstElement == true || parentFlatPrint == false)
                  {
                    table.add(line);
                  }
                else if (multi == true && objectArray == true)
                  {
                    table.add(line);
                    line = new Line();
                  }
                firstElement = false;
              }
          }
        return line;
      }

    static class GroupCol
      {
        GroupCol(int group, int maxCols)
          {
            _group = group;
            _maxCols = maxCols;
          }

        int   _group;
        int   _maxCols;
        int[] _maxWidths = new int[25];

        public static void addCol(List<GroupCol> L, int group, int colNum, int len)
          {
            GroupCol current = null;
            for (int i = 0; i < L.size(); ++i)
              {
                // The group already exists, let's add a columns
                if (L.get(i)._group == group)
                  {
                    current = L.get(i);
                    if (current._maxCols < colNum)
                      current._maxCols = colNum;
                    break;
                  }
                else if (L.get(i)._group > group)
                  {
                    for (int j = i; j < group; ++j)
                      {
                        current = new GroupCol(j, j < group - 1 ? 0 : colNum);
                        L.add(j, current);
                      }
                    break;
                  }
              }
            while (L.size() <= group)
              {
                current = new GroupCol(L.size(), L.size() < group - 1 ? 0 : colNum);
                L.add(current);
              }

            if (current != null && current._maxWidths[colNum] < len)
              current._maxWidths[colNum] = len;
          }

        public static int getMaxWidth(List<GroupCol> L, int groupNum, int colNum)
          {
            return L.get(groupNum)._maxWidths[colNum];
          }

        public static void print(List<GroupCol> L)
          {
            for (GroupCol gc : L)
              System.out.println("group: " + gc._group + ", maxCols:" + gc._maxCols + ", maxWidths:" + TextUtil.print(gc._maxWidths, null));
          }

        public static int getCatchUpPad(List<GroupCol> L, int prevGroup, int prevColNum, int nextGroup)
        throws IOException
          {
            int pad = 0;
            if (prevGroup < 0)
              return pad;
            while (prevGroup < nextGroup)
              {
                GroupCol gc = L.get(prevGroup);
                while (++prevColNum <= gc._maxCols)
                  pad += gc._maxWidths[prevColNum];
                prevColNum = -1;
                ++prevGroup;
              }
            return pad;
          }

        public static void catchUp(Writer out, List<GroupCol> L, int prevGroup, int prevColNum, int nextGroup)
        throws IOException
          {
            int pad = getCatchUpPad(L, prevGroup, prevColNum, nextGroup);
            if (pad > 0)
              out.append(PaddingUtil.getPad(pad));
          }
      }


    protected static void printColAligned(Writer out, List<Line> table, int level, int extraPad)
    throws IOException
      {
        List<GroupCol> L = new ArrayList<GroupCol>();
        for (Line ln : table)
          {
            int prevGroup = -1;
            int colNum = -1;
            for (Column col : ln._columns)
              {
                if (col._group != prevGroup)
                  {
                    colNum = -1;
                    prevGroup = col._group;
                  }
                int len = col == null ? 0 : col._str.length();
                GroupCol.addCol(L, col._group, ++colNum, len);
              }
          }
        // GroupCol.print(L);

        final boolean testing = false;
        for (int i = 0; i < table.size(); ++i)
          {
            Line row = table.get(i);
            String line = row.join("").trim();
            // if (line.indexOf("cloneFrom") != -1)
            // LOG.debug("XXX");
            if (TextUtil.isNullOrEmpty(line) == false)
              {
                int superPad = 0;
                if (row._subColumnGroupStart > 0)
                  superPad = GroupCol.getCatchUpPad(L, 0, 0, row._subColumnGroupStart) + 2 * _INDENT_MULTIPLIER - 1;
                out.append(PaddingUtil.getPad(level * _INDENT_MULTIPLIER + extraPad + superPad));
                int prevGroup = -1;
                int colNum = -1;
                for (int j = 0; j < row._columns.size() - 1; ++j)
                  {
                    Column col = row._columns.get(j);
                    if (col._group != prevGroup)
                      {
                        // if (prevGroup==3 && colNum==2 && col._group == 7)
                        // System.out.println("prevGroup: "+prevGroup+"; colNum: "+colNum+"; col._group: "+col._group+";");
                        GroupCol.catchUp(out, L, prevGroup, colNum, col._group);
                        colNum = -1;
                        prevGroup = col._group;
                      }
                    ++colNum;
                    out.append((!testing ? "" : "|" + col._group + "|" + colNum) + PaddingUtil.pad(col._str, GroupCol.getMaxWidth(L, col._group, colNum)));
                  }
                ++colNum;
                Column col = row._columns.get(row._columns.size() - 1);
                out.append((!testing ? "" : "|" + col._group + "|" + colNum) + col._str.stripTrailing());
                out.append("\n");
              }
            if (row._subColumns.isEmpty() == false)
              {
                int pad = GroupCol.getCatchUpPad(L, 0, 0, row._subColumnGroupStart) + 2;
                printColAligned(out, row._subColumns, level + 1, pad);
              }
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
        : "XXXXXXXXXX__UNKNOWN___" + type, colGroup);
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
        printColAligned(out, table, _INITIAL_INDENT, 0);
        LOG.debug("\n" + out.toString());
      }
  }
