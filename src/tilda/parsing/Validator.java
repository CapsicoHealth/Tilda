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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Deque;
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
    protected static final Logger  LOG                = LogManager.getLogger(Validator.class.getName());

    protected final static int     _INDENT_MULTIPLIER = 3;
    protected final static boolean _TEST_LNE          = false;
    protected final static boolean _TEST_COL          = false;
    protected final static boolean _TEST_PAD          = true;

    protected static class Column
      {
        Column(String str, int group)
          {
            _str = str;
            _group = group;
          }

        protected String _str;
        protected int    _group;

        public String toString()
          {
            return "group: " + _group + "; str: " + _str;
          }
      }

    protected static class Line
      {
        protected List<Column> _columns              = new ArrayList<Column>();
        int                    _subColumnGroupStart  = 0;
        boolean                _subColumnGroupMulti  = false;
        boolean                _subColumnGroupObject = false;
        boolean                _flatObjectOverhead   = false;
        protected List<Line>   _subColumns           = new ArrayList<Line>();
        protected int          _folded               = -1;

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

        public void fold()
          {
            _folded = _columns.size() - 1;
            for (Line l : _subColumns)
              for (Column c : l._columns)
                add(c._str, 0);
            _subColumns.clear();
          }

        public static boolean hasSubColumnGroupMulti(List<Line> table, int startIndex)
          {
            if (table != null)
              for (int i = startIndex; i < table.size(); ++i)
                if (table.get(i)._subColumnGroupMulti == true)
                  return true;
            return false;
          }

        public static boolean contains(List<Line> table, String val)
          {
            if (table != null)
              for (int i = 0; i < table.size(); ++i)
                if (table.get(i).join("\n").indexOf(val) >= 0)
                  return true;
            return false;

          }
      }

    public static void validateCodeModel(List<Line> table, JsonObject tildaDef, Class<?> tildaPartClass, TildaLayoutDef[] tildaLayoutDefs, boolean parentFlatPrint, boolean top)
    throws IOException
      {
        if (tildaDef == null)
          return;
        Line line = new Line();
        line = validateCodeModel(table, tildaPartClass, tildaLayoutDefs, parentFlatPrint, tildaDef, line, false, top);
        // There are cases for flat-printing where no new line is added, and the line is already added in validateCodeModel
        // There are other cases where one line is wrapped, and a new line is created in validateCodeModel in the last loop
        // and so the line needs to be added here.
        // This is definitely hacky.
        if (TextUtil.isNullOrEmpty(line.join("")) == false)
          {
            boolean found = false;
            for (Line l : table)
              if (l == line)
                {
                  found = true;
                  break;
                }
            if (found == false)
              table.add(line);
          }
      }

    public static void validateCodeModel(List<Line> table, JsonArray tildaDef, Class<?> tildaPartClass, TildaLayoutDef[] tildaLayoutDefs, boolean parentFlatPrint, boolean top)
    throws IOException
      {
        if (tildaDef == null || tildaDef.size() == 0)
          return;
        int tableBaseIndex = 0;
        for (int i = 0; i < tildaDef.size(); ++i)
          {
            if (tildaDef.get(i) == null || tildaDef.get(i).isJsonNull() == true)
              continue;
            JsonObject e = tildaDef.get(i).getAsJsonObject();
            Line line = new Line();
            line.add(/* (parentFlatPrint == true ? PaddingUtil.getPad(level) : "") + */ (i == 0 ? " {" : ",{"), 0);
            line = validateCodeModel(table, tildaPartClass, tildaLayoutDefs, parentFlatPrint, e, line, true, top);
            // There are cases for flat-printing where no new line is added, and the line is already added in validateCodeModel
            // There are other cases where one line is wrapped, and a new line is created in validateCodeModel in the last loop
            // and so the line needs to be added here.
            // This is definitely hacky.
            if (TextUtil.isNullOrEmpty(line.join("")) == false)
              {
                boolean found = false;
                for (Line l : table)
                  if (l == line)
                    {
                      found = true;
                      break;
                    }
                if (found == false)
                  table.add(line);
              }
            // If not flat-printing, need to wrap to a new line.
            if (parentFlatPrint == false || Line.hasSubColumnGroupMulti(table, tableBaseIndex) == true)
              {
                line = new Line();
                table.add(line);
              }
            line.add(" }", 1000);
            tableBaseIndex = table.size();
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

    private static TildaLayoutDef getField(TildaLayoutDef[] tildaLayoutDefs, SerializedName a)
      {
        for (TildaLayoutDef tld : tildaLayoutDefs)
          if (a.value().equals(tld._prop) == true)
            return tld;
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


    protected static Line validateCodeModel(List<Line> table, Class<?> tildaPartClass, TildaLayoutDef[] tildaLayoutDefs, boolean parentFlatPrint, JsonObject e, Line line, boolean objectArray, boolean top)
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
                if (firstElement == false && parentFlatPrint == false)
                  {
                    line = new Line();
                    if (objectArray == true)
                      {
                        line.add("", 0);
                        if (parentFlatPrint == true)
                         line._flatObjectOverhead = true;
                      }
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
                if (tld._prop.equals("subWhereX") == true)
                  LOG.debug("XXX");
                Line arrayWrapupLine = null;
                if (tildaPart == false)
                  {
                    if (tld._nextLine == true)
                      {
                        table.add(line);
                        line = new Line();
                        // line.add("", tld._group);
                      }
                    if (multi == true)
                      {
                        // if (parentFlatPrint == false)
                        // line.add(" ", 0);
                        arrayWrapupLine = printArray(table, line, tld._prop, ee.getAsJsonArray(), tld._flatPrint, firstElement, t, tld._group);
                      }
                    else
                      printValue(line, tld._prop, ee.getAsJsonPrimitive(), firstElement, t, parentFlatPrint || tld._flatPrint, tld._group);
                    // if (parentFlatPrint == false && tld._flatPrint == false && line._subColumnGroupStart == 0)
                    // line._subColumnGroupStart++;
                  }
                else if (tld != null)
                  {
                    if (tld._nextLine == true)
                      {
                        table.add(line);
                        line = new Line();
                        // line.add("", tld._group);
                      }
                    if (tld._nextLine == true || parentFlatPrint == true)
                      line.add((firstElement == true ? "   " : " , ") + "\"" + tld._prop + "\"", tld._group);
                    else
                      line.add((firstElement == true ? " " : ",") + "\"" + tld._prop + "\"", tld._group);
                    line.add(": ", tld._group);
                    line.add(multi == true ? "[" : "{", tld._group);
                    if (multi == true)
                      {
                        if (parentFlatPrint == false && tld._flatPrint == false)
                          {
                            table.add(line);
                            line = new Line();
                          }
                        if (tld._nextLine == true)
                          line._subColumnGroupStart = tld._group;
                        if (tld._flatPrint == true)
                          line._subColumnGroupMulti = true;
                        validateCodeModel(line._subColumns, ee.getAsJsonArray(), t, tld._subProps, tld._flatPrint, false);
                      }
                    else
                      {
                        if (tld._flatPrint == true && parentFlatPrint == true)
                          line._subColumnGroupMulti = true;
                        line._subColumnGroupObject = true;
                        validateCodeModel(line._subColumns, ee.getAsJsonObject(), t, tld._subProps, tld._flatPrint, false);
                      }
                    if (parentFlatPrint == false && tld._flatPrint == false || multi == true && objectArray == true || tld._flatPrint == true && multi == true)
                      {
                        table.add(line);
                        line = new Line();
                        if (multi == true && objectArray == true || top == false && parentFlatPrint == false && tld._flatPrint == false)
                          line.add("", 0);
                      }
                    else if (tld._flatPrint == true && multi == false)
                      {
                        line.fold();
                      }
                    line.add(multi == true && parentFlatPrint == true ? "   ]" : multi == true ? "  ]" : "  }", tld._group);
                  }
                if (parentFlatPrint == false)
                  {
                    table.add(line);
                    if (arrayWrapupLine != null)
                      table.add(arrayWrapupLine);
                    if (multi == true && objectArray == true)
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
              out.append(PaddingUtil.getPad(pad, _TEST_PAD ? '+' : ' '));
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

        for (int i = 0; i < table.size(); ++i)
          {
            Line row = table.get(i);
            String line = row.join("").trim();
            if (line.indexOf("tilda.DataMart.postgres.helpers-before.sql") >= 0)
              LOG.debug("XXX");
            int padding = 0;
            int groupPadding = 0;
            if (TextUtil.isNullOrEmpty(line) == false)
              {
                if (row._subColumnGroupStart > 0)
                  groupPadding = GroupCol.getCatchUpPad(L, 0, 0, row._subColumnGroupStart) + 1;
                padding += extraPad + groupPadding + level * _INDENT_MULTIPLIER/* + extraPad */;
                if (_TEST_LNE == true)
                  out.append(">>column group line: level=" + level + ", extraPad=" + /* extraPad + */ ", padding=" + padding + ", row._subColumnGroupStart=" + row._subColumnGroupStart + ", row._subColumnGroupMulti=" + row._subColumnGroupMulti + "\n");
                out.append(PaddingUtil.getPad(padding, _TEST_PAD ? '.' : ' '));
                int prevGroup = -1;
                int colNum = -1;
                boolean lineStart = true;
                for (int j = 0; j < row._columns.size() - 1; ++j)
                  {
                    Column col = row._columns.get(j);
                    if (col._group != prevGroup)
                      {
                        GroupCol.catchUp(out, L, prevGroup, colNum, col._group);
                        colNum = -1;
                        prevGroup = col._group;
                      }
                    ++colNum;
                    String testingStr = !_TEST_COL ? "" : "|" + col._group + "-" + colNum;
                    int pad = row._folded > 0 && j >= row._folded ? col._str.length() + 1 : GroupCol.getMaxWidth(L, col._group, colNum);
                    if (col._str.length() == 0)
                      {
                        if (lineStart == true)
                          ; // groupPadding += pad;
                      }
                    else
                      lineStart = false;
                    out.append(testingStr + PaddingUtil.pad(col._str, pad, _TEST_PAD ? '+' : ' '));
                  }
                ++colNum;
                Column col = row._columns.get(row._columns.size() - 1);
                if (col._group != prevGroup)
                  {
                    GroupCol.catchUp(out, L, prevGroup, colNum, col._group);
                    colNum = 0;
                    prevGroup = col._group;
                  }
                String testingStr = !_TEST_COL ? "" : "|" + col._group + "-" + colNum;
                out.append(testingStr + col._str.stripTrailing());
                out.append("\n");
                out.flush();
                // System.out.print(out);
              }
            if (row._subColumns.isEmpty() == false)
              {
                if (_TEST_LNE == true)
                  out.append(">>new column group: level=" + level + ", extraPad=" + /* extraPad + ", xxx=" + xxx + */", padding=" + padding + ", row._subColumnGroupStart=" + row._subColumnGroupStart + ", row._subColumnGroupMulti=" + row._subColumnGroupMulti + "\n");
                printColAligned(out, row._subColumns, level + (level > 0 && (row._subColumnGroupMulti == true || row._subColumnGroupMulti == false && row._subColumnGroupObject == true) ? 2 : 1), groupPadding);
              }
          }
      }

    protected static Line printArray(List<Line> table, Line out, /* int level, */ String name, JsonArray val, boolean flatPrint, boolean firstElement, Class type, int colGroup)
    throws IOException
      {
        out.add((firstElement == true ? " " : flatPrint == true ? ", " : ",") + "\"" + name + "\"", colGroup);
        out.add(": ", colGroup);
        if (val == null || val.isJsonNull() == true)
          out.add("null", colGroup);
        else if (val.size() == 0)
          out.add("[]", colGroup);
        else
          {
            StringBuilderWriter w = new StringBuilderWriter();
            JSONUtil.print(w, 0/* level * _INDENT_MULTIPLIER */, name, firstElement, val, type, flatPrint);
            String[] parts = w.toString().split("\\\"\\s*\\:\\s*");
            // if flat-print, then the whole aray was printed on a single line.
            if (flatPrint == true)
              out.add(parts[1], colGroup);
            else
              { // if not flatprint, then the array was printed across multiple lines, and we have to "unroll", i.e.,
                // first line will be the "[", then the next lines are the array values, and the last line will be "]"
                parts = parts[1].split("\n");
                out.add(parts[0], colGroup);
                for (int i = 1; i < parts.length - 1; ++i)
                  {
                    Line ln = new Line();
                    ln.add(parts[i], 1);
                    out._subColumns.add(ln);
                  }
                Line ln = new Line();
                ln.add(parts[parts.length - 1], 1);
                // We can do this here. Because it's not a flatprint, the next piece of code will wrap all up line-wise.
                return ln;
              }
          }
        return null;
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

        // final int _INITIAL_INDENT = 1;
        List<Line> table = new ArrayList<Line>();
        try
          {
            validateCodeModel(table, j, Schema.class, TLDL, false, true);
          }
        catch (Throwable T)
          {
            LOG.error("\n", T);
          }
        StringBuilderWriter out = new StringBuilderWriter();
        printColAligned(out, table, 1, 0);
        LOG.debug("\n" + out.toString());

        LOG.debug("\n\n\n"
        + "--------------------------------------------------------------------------------------------------------------\n"
        + "-- Mismatched properties between the Tilda class-based model and TildaLayoutDef");


        // Deque<String> q = new ArrayDeque<String>();
        // q.push("Schema");
        // StringBuilder str = new StringBuilder();
        // checkTildaDefVsClasses(q, str, TLDL, Schema.class);
        // LOG.debug("\n\n\n"
        // + "--------------------------------------------------------------------------------------------------------------\n"
        // + "-- Template full TildaLayoutDef\n"
        // + str.toString());

      }

    private static String printPath(Deque<String> q, String nextElement)
      {
        StringBuilder str = new StringBuilder();
        for (String s : q)
          {
            if (str.isEmpty() == false)
              str.append(".");
            str.append(s);
          }
        if (nextElement != null)
          {
            if (str.isEmpty() == false)
              str.append(".");
            str.append(nextElement);
          }
        return str.toString();
      }

    private static void checkTildaDefVsClasses(Deque<String> q, StringBuilder str, TildaLayoutDef[] tildaLayoutDefs, Class<?> tildaPartClass)
      {
        List<Field> fields = new ArrayList<Field>();
        ClassUtils.getAllDeclaredFields(fields, tildaPartClass);

        boolean first = true;
        for (Field f : fields)
          {
            SerializedName a = f.getAnnotation(SerializedName.class);
            if (a == null)
              continue;
            TildaLayoutDef tld = tildaLayoutDefs == null ? null : getField(tildaLayoutDefs, a);
            if (tld == null)
              {
                LOG.debug(PaddingUtil.getPad(q.size() * 3 - 3) + "Serializable class property '" + printPath(q, a.value()) + "' not found in TLD definition.");
                // continue;
              }
            // else if (tld._prop.equals("wheres") == true)
            // LOG.debug("XXX");
            Type gt = f.getGenericType();
            Class<?> t = f.getType().isArray() == true ? f.getType().arrayType().getComponentType().getComponentType()
            : ParameterizedType.class.isAssignableFrom(gt.getClass()) == true ? (Class<?>) ((ParameterizedType) gt).getActualTypeArguments()[0]
            : f.getType();
            boolean tildaPart = t.getName().startsWith("tilda.parsing.parts.") == true;
            str.append(PaddingUtil.getPad(q.size() * 3 - 3, _TEST_PAD ? '#' : ' ') + (first == true ? " " : ",") + "{\"prop\":\"" + a.value() + "\", \"flatPrint\":false, \"label\":\"\"" + (tildaPart == true ? "\n" : " }\n"));
            first = false;
            if (tildaPart == true)
              {
                str.append(PaddingUtil.getPad(q.size() * 3 - 3, _TEST_PAD ? '@' : ' ') + " ,\"subProps\":[\n");
                q.addLast(a.value());
                checkTildaDefVsClasses(q, str, tld == null ? null : tld._subProps, t);
                q.pollLast();
                str.append(PaddingUtil.getPad(q.size() * 3 - 3, _TEST_PAD ? '@' : ' ') + "   ]\n");
                str.append(PaddingUtil.getPad(q.size() * 3 - 3, _TEST_PAD ? '@' : ' ') + " }\n");
              }
          }

        if (tildaLayoutDefs != null)
          for (TildaLayoutDef tld : tildaLayoutDefs)
            {
              Field f = getField(fields, tld._prop);
              if (f == null)
                LOG.debug(PaddingUtil.getPad(q.size() * 3 - 3, _TEST_PAD ? '$' : ' ') + "TLD Property '" + printPath(q, tld._prop) + "' not found in class '" + tildaPartClass.getCanonicalName() + "'.");
            }

      }
  }
