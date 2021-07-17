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

package tilda.utils.json;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import tilda.db.JDBCHelper;
import tilda.interfaces.JSONable;
import tilda.utils.DateTimeUtil;
import tilda.utils.HttpStatus;
import tilda.utils.ParseUtil;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class JSONUtil
  {
    protected static final Logger LOG = LogManager.getLogger(JDBCHelper.class.getName());

    protected static void printString(Writer Out, String v)
    throws IOException
      {
        if (v == null || v.equals("null") == true || v.equals("undefined") == true)
          {
            Out.write("null");
            return;
          }
        Out.write("\"");
        for (int i = 0; i < v.length(); ++i)
          {
            char c = v.charAt(i);
            Out.write(c == '\n' ? "\\n" : c == '\r' ? "\\r" : c == '"' ? "\\\"" : c == '\\' ? "\\\\" : "" + c);
          }
        Out.write("\"");
      }

    protected static void printZonedDateTime(Writer Out, ZonedDateTime v)
    throws IOException
      {
        if (v == null)
          {
            Out.write("null");
            return;
          }
        Out.write("\"");
        Out.write(DateTimeUtil.printDateTimeForJSON(v));
        Out.write("\"");
      }

    protected static void printLocalDate(Writer Out, LocalDate v)
    throws IOException
      {
        if (v == null)
          {
            Out.write("null");
            return;
          }
        Out.write("\"");
        Out.write(DateTimeUtil.printDateForJSON(v));
        Out.write("\"");
      }

    protected static void printChar(Writer Out, char v)
    throws IOException
      {
        if (v == Character.UNASSIGNED)
          Out.write("null");
        else
          {
            Out.write("\"");
            Out.write(v == '"' ? "\\\"" : Character.toString(v));
            Out.write("\"");
          }
      }

    protected static void printFloat(Writer Out, float v)
    throws IOException
      {
        Out.write(v == Float.NaN ? "null" : Float.toString(v));
      }

    protected static void printDouble(Writer Out, double v)
    throws IOException
      {
        Out.write(v == Double.NaN ? "null" : Double.toString(v));
      }

    public static void print(Writer Out, String Name, boolean FirstElement)
    throws IOException
      {
        Out.write(FirstElement == false ? ", " : " ");
        if (Name != null)
          {
            Out.write("\"");
            Out.write(Name);
            Out.write("\":");
          }
      }

    public static void printSubJson(Writer Out, String Name, boolean FirstElement, String v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        Out.write(TextUtil.isNullOrEmpty(v) == true ? "null" : v);
      }

    public static void print(Writer Out, String Name, boolean FirstElement, String v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        printString(Out, v);
      }

    public static void print(Writer Out, String Name, boolean FirstElement, char v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        printChar(Out, v);
      }

    public static void print(Writer Out, String Name, boolean FirstElement, ZonedDateTime v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        printZonedDateTime(Out, v);
      }

    public static void print(Writer Out, String Name, boolean FirstElement, LocalDate v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        printLocalDate(Out, v);
      }

    public static void print(Writer Out, String Name, boolean FirstElement, boolean v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        Out.write(Boolean.toString(v));
      }

    public static void print(Writer Out, String Name, boolean FirstElement, int v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        Out.write(Integer.toString(v));
      }

    public static void print(Writer Out, String Name, boolean FirstElement, long v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        Out.write(Long.toString(v));
      }

    public static void print(Writer Out, String Name, boolean FirstElement, float v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        printFloat(Out, v);
      }

    public static void print(Writer Out, String Name, boolean FirstElement, double v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        printDouble(Out, v);
      }


    public static void print(Writer Out, String Name, boolean FirstElement, boolean[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (boolean i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            Out.write(((Boolean) i).toString());
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, Boolean[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (Boolean i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            Out.write(i == null ? "null" : i.toString());
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, int[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (int i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            Out.write(((Integer) i).toString());
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, Integer[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (Integer i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            Out.write(i == null ? "null" : i.toString());
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, long[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (long i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            Out.write(((Long) i).toString());
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, Long[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (Long i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            Out.write(i == null ? "null" : i.toString());
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, char[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (char i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            printChar(Out, i);
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, Character[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (Character i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            if (i == null)
              Out.write("null");
            else
              printChar(Out, i);
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, float[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (float i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            printFloat(Out, i);
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, Float[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (Float i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            if (i == null)
              Out.write("null");
            else
              printFloat(Out, i);
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, double[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (double i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            printDouble(Out, i);
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, Double[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (Double i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            if (i == null)
              Out.write("null");
            else
              printDouble(Out, i);
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, String[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (String i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            printString(Out, i);
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, ZonedDateTime[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (ZonedDateTime i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            printZonedDateTime(Out, i);
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, LocalDate[] a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (LocalDate i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            printLocalDate(Out, i);
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, Collection<String> a)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (a == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (String i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            printString(Out, i);
          }
        Out.write("]");
      }


    public static void print(Writer Out, String Name, boolean FirstElement, Map<String, String> M)
    throws IOException
      {
        print(Out, Name, FirstElement);
        if (M == null)
          {
            Out.write("null");
            return;
          }
        Out.write("[");
        boolean First = true;
        for (Map.Entry<String, String> e : M.entrySet())
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            Out.write("[");
            printString(Out, e.getKey());
            Out.write(", ");
            printString(Out, e.getValue());
            Out.write("]");
          }
        Out.write("]");
      }


    /**
     * Starts the standard JSON header for payload, i.e., {code:xxx,data:}
     * 
     * @param Out
     * @param openObjectOrArray A character for '{' or '[' depending on whether an object is output, or an array of objects.
     * @throws IOException
     */
    public static void startOK(Writer Out, char openObjectOrArray)
    throws IOException
      {
        Out.write("{\"code\":");
        Out.write(Integer.toString(HttpStatus.OK._Code));
        Out.write(",\"data\": ");
        Out.write(openObjectOrArray);
        Out.write("\n");
      }

    public static void printArrayStart(Writer Out, String Name, boolean FirstElement, String Header)
    throws IOException
      {
        Out.write(Header);
        print(Out, Name, FirstElement);
        startend(Out, '[');
      }

    public static void printElementStart(Writer Out, String Name, boolean FirstElement, String Header)
    throws IOException
      {
        Out.write(Header);
        print(Out, Name, FirstElement);
        startend(Out, '{');
      }

    public static void startend(Writer Out, char startChar)
    throws IOException
      {
        Out.write(startChar);
      }

    public static void newline(Writer Out)
    throws IOException
      {
        Out.write('\n');
      }

    public static void end(Writer Out, char closeObjectOrArray)
    throws IOException
      {
        Out.write(closeObjectOrArray);
        Out.write("}\n");
      }

    public static void response(Writer Out, String JsonExportName, JSONable Obj)
    throws Exception
      {
        if (Obj == null)
          {
            Out.write("{\"code\":");
            Out.write(Integer.toString(HttpStatus.OK._Code));
            Out.write(",\"data\": null}");
          }
        else
          {
            startOK(Out, '{');
            Obj.toJSON(Out, JsonExportName, "", false);
            end(Out, '}');
          }
      }

    /**
     * When using client-side frameworks such as Dojo that may use an iFrame for ajax-contents, the protocol
     * is typically to return the json data packaged inside a textarea. This function does that. It is exactly
     * equivalent to the "plain" response method except the jsonable object is output inside a textarea and the
     * writer is expected to be set up as an HTML one.
     * 
     * @param Out
     * @param JsonExportName
     * @param Obj
     * @throws Exception
     */
    public static void responseDojoMultipartConfig(Writer Out, String JsonExportName, JSONable Obj)
    throws Exception
      {
        Out.write("<textarea>\n");
        response(Out, JsonExportName, Obj);
        Out.write("</textarea>\n");
      }


    public static void response(Writer Out, String JsonExportName, List<? extends JSONable> L)
    throws Exception
      {
        Out.write("{\"code\":");
        Out.write(Integer.toString(HttpStatus.OK._Code));
        print(Out, "data", JsonExportName, false, L, " ");
        end(Out, ' ');
      }

    public static void response(Writer Out, String[][] groupValues)
    throws IOException
      {
        Out.write("{\"code\":");
        Out.write(Integer.toString(HttpStatus.OK._Code));
        print(Out, "data", false, groupValues, "");
        end(Out, ' ');
      }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> fromJSON(String JsonStr)
      {
        Map<String, Object> Filter = new HashMap<String, Object>();
        Gson gson = new Gson();
        return (Map<String, Object>) gson.fromJson(JsonStr, Filter.getClass());
      }

    public static void print(Writer Out, String elementName, String JsonExportName, boolean firstElement, List<? extends JSONable> L, String Header)
    throws Exception
      {
        Out.write(Header);
        print(Out, elementName, firstElement);


        if (L == null)
          {
            Out.write(" null ");
            return;
          }
        if (L.isEmpty() == true)
          {
            Out.write(" [ ] ");
            return;
          }
        Out.write(" [\n");
        boolean First = true;
        for (JSONable Obj : L)
          {
            if (Obj == null)
              continue;
            Out.write(Header);
            if (First == true)
              {
                Out.write(Header + "   ");
                First = false;
              }
            else
              Out.write(Header + "  ,");
            Obj.toJSON(Out, JsonExportName, "", true);
            // Out.write("\n");
          }
        Out.write(Header + "  ]\n");
      }

    public static void print(Writer Out, String elementName, String JsonExportName, boolean firstElement, List<? extends JSONable> L, String Header, ZonedDateTime lastSync)
    throws Exception
      {
        Out.write(Header);
        print(Out, elementName, firstElement);

        if (L == null)
          {
            Out.write(" null ");
            return;
          }
        if (L.isEmpty() == true)
          {
            Out.write(" [ ] ");
            return;
          }
        Out.write(" [\n");
        boolean First = true;
        for (JSONable Obj : L)
          {
            if (Obj == null)
              continue;
            Out.write(Header);
            if (First == true)
              {
                Out.write(Header + "   ");
                First = false;
              }
            else
              Out.write(Header + "  ,");
            Obj.toJSON(Out, JsonExportName, "", true, lastSync);
          }
        Out.write(Header + "  ]\n");
      }


    public static void print(Writer Out, String elementName, String JsonExportName, boolean firstElement, JSONable Obj, String Header)
    throws Exception
      {
        Out.write(Header);
        print(Out, elementName, firstElement);
        if (Obj == null)
          Out.write(" null ");
        else
          Obj.toJSON(Out, JsonExportName, "", true);
      }

    public static void print(Writer Out, String elementName, boolean firstElement, String[][] Values, String Header)
    throws IOException
      {
        Out.write(Header);
        print(Out, elementName, firstElement);
        Out.write(" [ ");
        boolean First = true;
        for (String[] Value : Values)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            Out.write("[");
            boolean First2 = true;
            for (String s : Value)
              {
                if (First2 == true)
                  First2 = false;
                else
                  Out.write(", ");
                printString(Out, s);
              }
            Out.write("]");
          }
        Out.write(" ]\n");
      }

    /**
     * Prints a raw json object. It's assumed to be properly formed.
     * 
     * @param out
     * @param name
     * @param firstElement
     * @param rawJsonObject
     * @throws IOException
     */
    public static void printRawObject(Writer out, String name, boolean firstElement, String rawJsonObject)
    throws IOException
      {
        JSONUtil.print(out, name, firstElement);
        out.write(rawJsonObject);
      }

    /**
     * Prints a raw json object. It's assumed to be properly formed.
     * 
     * @param out
     * @param name
     * @param firstElement
     * @param rawJsonObject
     * @throws IOException
     */
    public static void printRawArray(Writer out, String name, boolean firstElement, List<String> rawJsonObjects)
    throws IOException
      {
        JSONUtil.print(out, name, firstElement);
        out.write("[\n");
        boolean first = true;
        for (String s : rawJsonObjects)
          {
            if (first == true)
              first = false;
            else
              out.write("   , ");
            out.write(s);
            out.write("\n");
          }
        out.write("]\n");
      }


    /**
     * Follows the JsonPath syntax more or less... similar to how you'd access a value in JavaScript, i.e., obj.someItem.someOtherItem.someArray[0].someItem.<BR>
     * <UL>
     * <LI>If an element in the path chain doesn't exist in the JSON object or is null, null will be returned.</LI>
     * <LI>Array must be subscripted with a positive integer. If not, will throw an exception.</LI>
     * <LI>If an element is subscripted like an array, but is not an array in the source object, will throw an exception.</LI>
     * </UL>
     * For the future, should add the ability to lookup in arrays by value and the ability to return a list of objects if the last property
     * of the path is off an array.
     * @param json
     * @param path
     * @return
     * @throws Exception 
     */
    public static JsonElement getJsonElementFromPath(JsonElement e, String path) throws Exception
      {
        String[] parts = path.split("\\s*\\.\\s*");
        for (String name : parts)
          {
            if (TextUtil.isNullOrEmpty(name) == true)
              throw new Exception("Empty element name from " + parts + ".");
            
            int i1 = name.indexOf("[");
            int i2 = name.lastIndexOf("]");
            if (i1 != -1 && i2 == name.length()-1) // array subscripting found
              {
                int index =  ParseUtil.parseInteger(name.substring(i1+1, i2), SystemValues.EVIL_VALUE);
                if (index < 0)
                 throw new Exception("Invalid array subscripting expression in path at '"+name+"'.");
                name = name.substring(0, i1);
                e = ((JsonObject) e).get(name);
                if (e == null || e.isJsonNull() == true)
                  return null;
                if (e.isJsonArray() == false)
                  throw new Exception("Property '"+name+"' in path is indexed as an array but is not an array in the JSON object.");
                e = e.getAsJsonArray().get(index);
              }
            else // a simple property
              {
                e = ((JsonObject) e).get(name);
                if (e == null || e.isJsonNull() == true)
                 return null;
              }
          }

        return e;
      }


  }
