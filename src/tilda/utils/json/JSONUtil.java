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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import tilda.db.Connection;
import tilda.db.JDBCHelper;
import tilda.db.metadata.ColumnMeta;
import tilda.interfaces.JSONable;
import tilda.utils.CollectionUtil;
import tilda.utils.DateTimeUtil;
import tilda.utils.HttpStatus;
import tilda.utils.PaddingUtil;
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
            Out.write(c == '\n' ? "\\n" : c == '\r' ? "\\r" : c == '\t' ? "\\t" : c == '"' ? "\\\"" : c == '\\' ? "\\\\" : "" + c);
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

    protected static void printUUID(Writer Out, UUID v)
    throws IOException
      {
        if (v == null)
          {
            Out.write("null");
            return;
          }
        Out.write("\"");
        Out.write(v.toString());
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
        Out.write(FirstElement == false ? "," : " ");
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

    public static void print(Writer Out, String Name, boolean FirstElement, UUID v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        printString(Out, v.toString());
      }

    public static void print(Writer Out, String Name, boolean FirstElement, boolean v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        Out.write(Boolean.toString(v));
      }

    public static void print(Writer Out, String Name, boolean FirstElement, short v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        Out.write(Short.toString(v));
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

    public static void print(Writer Out, String Name, boolean FirstElement, BigDecimal v)
    throws IOException
      {
        print(Out, Name, FirstElement);
        printString(Out, v.toString());
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
            Out.write(Boolean.toString(i));
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

    public static void print(Writer Out, String Name, boolean FirstElement, short[] a)
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
        for (short i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            Out.write(Short.toString(i));
          }
        Out.write("]");
      }

    public static void print(Writer Out, String Name, boolean FirstElement, Short[] a)
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
        for (Short i : a)
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
            Out.write(Integer.toString(i));
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
            Out.write(Long.toString(i));
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

    public static void print(Writer Out, String Name, boolean FirstElement, BigDecimal[] a)
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
        for (BigDecimal i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            if (i == null)
              Out.write("null");
            else
              printString(Out, i.toString());
          }
        Out.write("]");
      }

    public static void print(Writer out, String name, boolean first, String[] a)
    throws IOException
      {
        print(out, name, first, a, 0, true);
      }

    public static void print(Writer Out, String Name, boolean FirstElement, String[] a, int padding, boolean flatPrint)
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
            if (flatPrint == false)
              Out.write("\n"+PaddingUtil.getPad(padding));
            if (First == true)
              {
                First = false;
                if (flatPrint == false)
                  Out.write(" ");
              }
            else
              Out.write(",");
            printString(Out, i);
          }
        if (flatPrint == false)
          Out.write("\n"+PaddingUtil.getPad(padding+2));
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

    public static void print(Writer Out, String Name, boolean FirstElement, UUID[] a)
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
        for (UUID i : a)
          {
            if (First == true)
              First = false;
            else
              Out.write(", ");
            if (i == null)
              Out.write("null");
            else
              printString(Out, i.toString());
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

    public static void print(Writer out, int padding, String name, boolean first, JsonArray val, Class type, boolean flatPrint)
    throws IOException
      {
        out.write(PaddingUtil.getPad(padding));
        if (val == null || val.isJsonNull() == true)
          {
            print(out, name, first);
            out.write("null");
            return;
          }
        if (val.size() == 0)
          {
            print(out, name, first);
            out.write("[]");
            return;

          }
        JsonElement e = null;
        for (int i = 0; i < val.size(); ++i)
          if (val.get(i).isJsonNull() == false)
            {
              e = val.get(i);
              break;
            }
        if (e == null)
          throw new IOException("Element array '" + name + "' only contains NULL values and type cannot be infered.");
        if (e.isJsonPrimitive() == false)
          throw new IOException("Element array '" + name + "' not of primitive types");
        JsonPrimitive p = e.getAsJsonPrimitive();
        if (p.isString() == true)
          {
            String[] arr = new String[val.size()];
            for (int i = 0; i < val.size(); ++i)
              arr[i] = val.get(i).isJsonNull()==true ? null : val.get(i).getAsJsonPrimitive().getAsString();
            print(out, name, first, arr, padding, flatPrint);
          }
        else if (p.isBoolean() == true)
          {
            boolean[] arr = new boolean[val.size()];
            for (int i = 0; i < val.size(); ++i)
              arr[i] = val.get(i).getAsJsonPrimitive().getAsBoolean();
            print(out, name, first, arr);
          }
        else if (p.isNumber() == true)
          {
            if (type.isAssignableFrom(Short.class) == true)
              {
                long[] arr = new long[val.size()];
                for (int i = 0; i < val.size(); ++i)
                  arr[i] = val.get(i).getAsJsonPrimitive().getAsLong();
                print(out, name, first, arr);
              }
            else if (type.isAssignableFrom(Float.class) == true)
              {
                double[] arr = new double[val.size()];
                for (int i = 0; i < val.size(); ++i)
                  arr[i] = val.get(i).getAsJsonPrimitive().getAsDouble();
                print(out, name, first, arr);
              }
            else
              throw new IOException("Invalid json array number type '" + type + "': must be of interger or float types");
          }
        else
          throw new IOException("Invalid json array type with values '" + p + "': must be of json primitives");

      }


    /**
     * Starts the standard JSON header for payload, i.e., {code:xxx,data:}
     * 
     * @param Out
     * @param openObjectOrArray A character for '{' or '[' depending on whether an object is output, or an array of objects.
     * @throws IOException
     */
    public static void startOK(Writer Out, char openObjectOrArray, String perfMessage)
    throws IOException
      {
        Out.write("{\"code\":");
        Out.write(Integer.toString(HttpStatus.OK._Code));
        if (TextUtil.isNullOrEmpty(perfMessage) == false)
          {
            Out.write(",\"perfMessage\": ");
            printString(Out, perfMessage);
          }
        Out.write(",\"data\": ");
        Out.write(openObjectOrArray);
        Out.write("\n");
      }

    public static void startOK(Writer Out, char openObjectOrArray)
    throws IOException
      {
        startOK(Out, openObjectOrArray, null);
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

    public static void response(Writer Out, String JsonExportName, JSONable Obj, String perfMessage)
    throws Exception
      {
        if (Obj == null)
          {
            Out.write("{\"code\":");
            Out.write(Integer.toString(HttpStatus.OK._Code));
            if (TextUtil.isNullOrEmpty(perfMessage) == false)
              {
                Out.write(",\"perfMessage\": ");
                printString(Out, perfMessage);
              }
            Out.write(",\"data\": null}");
          }
        else
          {
            startOK(Out, '{');
            Obj.toJSON(Out, JsonExportName, "", false);
            end(Out, '}');
          }
      }

    public static void response(Writer Out, String JsonExportName, JSONable Obj)
    throws Exception
      {
        response(Out, JsonExportName, Obj, null);
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
    public static void responseDojoMultipartConfig(Writer Out, String JsonExportName, JSONable Obj, String perfMessage)
    throws Exception
      {
        Out.write("<textarea>\n");
        response(Out, JsonExportName, Obj);
        Out.write("</textarea>\n");
      }

    public static void responseDojoMultipartConfig(Writer Out, String JsonExportName, JSONable Obj)
    throws Exception
      {
        responseDojoMultipartConfig(Out, JsonExportName, Obj, null);
      }

    public static void response(Writer Out, String JsonExportName, List<? extends JSONable> L, String perfMessage)
    throws Exception
      {
        Out.write("{\"code\":");
        Out.write(Integer.toString(HttpStatus.OK._Code));
        if (TextUtil.isNullOrEmpty(perfMessage) == false)
          {
            Out.write(",\"perfMessage\": ");
            printString(Out, perfMessage);
          }
        print(Out, "data", JsonExportName, false, L, " ");
        end(Out, ' ');
      }

    public static void response(Writer Out, String JsonExportName, List<? extends JSONable> L)
    throws Exception
      {
        response(Out, JsonExportName, L, null);
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

    public static JsonObject fromJSONObj(String JsonStr)
      {
        return new Gson().fromJson(JsonStr.toString(), JsonObject.class);
      }

    public static JsonObject fromJSONObj(BufferedReader R)
      {
        return new Gson().fromJson(R, JsonObject.class);
      }

    public static void print(Writer Out, String elementName, String JsonExportName, boolean firstElement, List<? extends JSONable> L, String Header)
    throws Exception
      {
        print(Out, elementName, JsonExportName, firstElement, L, Header, null);
      }

    public static void print(Writer Out, String elementName, String JsonExportName, boolean firstElement, List<? extends JSONable> L, String Header, ZonedDateTime lastSync)
    throws Exception
      {
        Out.write(Header);
        print(Out, elementName, firstElement);
        print(Out, JsonExportName, L, Header, null);
      }

    public static void print(Writer Out, String JsonExportName, List<? extends JSONable> L, String Header, ZonedDateTime lastSync)
    throws Exception
      {
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
            if (lastSync != null)
              Obj.toJSON(Out, JsonExportName, "", true, lastSync);
            else
              Obj.toJSON(Out, JsonExportName, "", true);
          }
        Out.write(Header + "  ]\n");
      }


    public static void print(Writer Out, String elementName, String JsonExportName, boolean firstElement, JSONable Obj, String Header)
    throws Exception
      {
        print(Out, elementName, JsonExportName, firstElement, Obj, Header, true);
      }
    
    public static void print(Writer Out, String elementName, String JsonExportName, boolean firstElement, JSONable Obj, String Header, boolean fullObject)
    throws Exception
      {
        Out.write(Header);
        print(Out, elementName, firstElement);
        if (Obj == null)
          Out.write(" null ");
        Obj.toJSON(Out, JsonExportName, "", fullObject);
      }

    public static void print(Writer Out, String elementName, boolean firstElement, String[][] Values, String Header)
    throws IOException
      {
        Out.write(Header);
        print(Out, elementName, firstElement);

        if (Values == null)
          {
            Out.write(" null ");
            return;
          }
        if (Values.length == 0)
          {
            Out.write(" [ ] ");
            return;
          }

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
        out.write(TextUtil.isNullOrEmpty(rawJsonObject) == true ? "null" : rawJsonObject);
      }

    /**
     * Prints a raw json object as a property. It's assumed to be properly formed.
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
        printRawArray(out, rawJsonObjects);
      }

    /**
     * Prints a raw json object. It's assumed to be properly formed.
     * 
     * @param out
     * @param rawJsonObject
     * @throws IOException
     */
    public static void printRawArray(Writer out, List<String> rawJsonObjects)
    throws IOException
      {
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
     * 
     * @param json
     * @param path
     * @return
     * @throws Exception
     */
    public static JsonElement getJsonElementFromPath(JsonElement e, String path)
    throws Exception
      {
        String[] parts = path.split("\\s*\\.\\s*");
        for (String name : parts)
          {
            if (TextUtil.isNullOrEmpty(name) == true)
              throw new Exception("Empty element name from " + parts + ".");

            int i1 = name.indexOf("[");
            int i2 = name.lastIndexOf("]");
            if (i1 != -1 && i2 == name.length() - 1) // array subscripting found
              {
                int index = ParseUtil.parseInteger(name.substring(i1 + 1, i2), SystemValues.EVIL_VALUE);
                if (index < 0)
                  throw new Exception("Invalid array subscripting expression in path at '" + name + "'.");
                name = name.substring(0, i1);
                e = ((JsonObject) e).get(name);
                if (e == null || e.isJsonNull() == true)
                  return null;
                if (e.isJsonArray() == false)
                  throw new Exception("Property '" + name + "' in path is indexed as an array but is not an array in the JSON object.");
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


    public static String prettyPrint(JsonObject e)
      {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(e);
      }

    public static void print(Writer out, String elementName, ResultSet RS, int idx, ColumnMeta cm)
    throws Exception
      {
        print(out, elementName, RS, idx, cm, false);
      }

    public static void print(Writer out, String elementName, ResultSet RS, int idx, ColumnMeta cm, boolean trimStrings)
    throws Exception
      {
        switch (cm._TildaType)
          {
            case BINARY:
            case BITFIELD:
              throw new Exception("Column Type '" + cm._TildaType.name() + "' is not supported for a json export.");
            case BOOLEAN:
              if (cm.isArray() == true)
                {
                  List<Boolean> v_bool = (List<Boolean>) JDBCHelper.getArray(RS, idx, cm._TildaType, false);
                  if (RS.wasNull() == true)
                    v_bool = null;
                  print(out, elementName, idx == 1, CollectionUtil.toObjectArray(Boolean.class, v_bool));
                }
              else
                {
                  boolean v_bool = RS.getBoolean(idx);
                  if (RS.wasNull())
                    print(out, elementName, idx == 1, (String) null);
                  else
                    print(out, elementName, idx == 1, v_bool);
                }
              break;
            case CHAR:
            case STRING:
            case JSON:
              if (cm.isArray() == true)
                {
                  List<String> v_str = (List<String>) JDBCHelper.getArray(RS, idx, cm._TildaType, false);
                  if (RS.wasNull() == true)
                    v_str = null;
                  print(out, elementName, idx == 1, CollectionUtil.toStringArray(v_str));
                }
              else
                {
                  String v_str = RS.getString(idx);
                  print(out, elementName, idx == 1, RS.wasNull() == true ? null : trimStrings == true ? v_str.trim() : v_str);
                }
              break;
            case DATE:
              if (cm.isArray() == true)
                {
                  List<LocalDate> v_ld = DateTimeUtil.toLocalDates((List<java.sql.Date>) JDBCHelper.getArray(RS, idx, cm._TildaType, false));
                  if (RS.wasNull() == true)
                    v_ld = null;
                  print(out, elementName, idx == 1, CollectionUtil.toObjectArray(LocalDate.class, v_ld));
                }
              else
                {
                  LocalDate v_ld = DateTimeUtil.toLocalDate(RS.getDate(idx));
                  print(out, elementName, idx == 1, RS.wasNull() == true ? null : v_ld);
                }
              break;
            case DATETIME:
            case DATETIME_PLAIN:
              // most Tilda tables have a 'TZ' column accompanying a datetime column, but not all. Also,
              // if this is used for a plain table, we have to assume that the Tz info is not there and
              // use UTC as a default.
              if (cm.isArray() == true)
                {
                  ColumnMeta tzCol = cm.getTZCol();
                  List<String> v_tz = null;
                  if (tzCol != null)
                    {
                      v_tz = (List<String>) JDBCHelper.getArray(RS, tzCol._NameOriginal, tzCol._TildaType, false);
                      if (RS.wasNull() == true)
                        v_tz = null;
                    }

                  List<Timestamp> v_ts = (List<Timestamp>) JDBCHelper.getArray(RS, idx, cm._TildaType, false);
                  if (RS.wasNull() == true)
                    v_ts = null;

                  List<ZonedDateTime> v_zdt = new ArrayList<ZonedDateTime>();
                  if (v_ts != null)
                    for (int i = 0; i < v_ts.size(); ++i)
                      {
                        String TimezoneId = v_tz != null && i < v_tz.size() && v_tz.get(i) != v_tz.get(i) ? v_tz.get(i) : "UTC";
                        tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(TimezoneId);
                        ZonedDateTime ZDT = DateTimeUtil.toZonedDateTime(v_ts.get(i), ZI.getValue());
                        v_zdt.add(ZDT);
                      }
                  print(out, elementName, idx == 1, CollectionUtil.toObjectArray(ZonedDateTime.class, v_zdt));
                }
              else
                {
                  ColumnMeta tzCol = cm.getTZCol();
                  String v_tz = null;
                  if (tzCol != null)
                    {
                      v_tz = RS.getString(tzCol._NameOriginal);
                      if (RS.wasNull() == true)
                        v_tz = null;
                    }
                  tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(v_tz);
                  // No timezone and v_tz was also null
                  if (ZI == null && TextUtil.isNullOrEmpty(v_tz) == true)
                    ZI = tilda.data.ZoneInfo_Factory.getEnumerationById("UTC"); // assume UTC
                  ZonedDateTime v_zdt = DateTimeUtil.toZonedDateTime(RS.getTimestamp(idx, DateTimeUtil._UTC_CALENDAR), ZI == null ? "null" : ZI.getValue());
                  if (RS.wasNull() == true)
                    v_zdt = null;
                  print(out, elementName, idx == 1, RS.wasNull() == true ? null : v_zdt);
                }
              break;
            case DOUBLE:
              if (cm.isArray() == true)
                {
                  List<Double> v = (List<Double>) JDBCHelper.getArray(RS, idx, cm._TildaType, false);
                  if (RS.wasNull() == true)
                    v = null;
                  print(out, elementName, idx == 1, CollectionUtil.toObjectArray(Double.class, v));
                }
              else
                {
                  double v = RS.getDouble(idx);
                  if (RS.wasNull() == true)
                    print(out, elementName, idx == 1, (String) null);
                  else
                    print(out, elementName, idx == 1, v);
                }
              break;
            case FLOAT:
              if (cm.isArray() == true)
                {
                  List<Float> v = (List<Float>) JDBCHelper.getArray(RS, idx, cm._TildaType, false);
                  if (RS.wasNull() == true)
                    v = null;
                  print(out, elementName, idx == 1, CollectionUtil.toObjectArray(Float.class, v));
                }
              else
                {
                  float v = RS.getFloat(idx);
                  if (RS.wasNull() == true)
                    print(out, elementName, idx == 1, (String) null);
                  else
                    print(out, elementName, idx == 1, v);
                }
              break;
            case INTEGER:
              if (cm.isArray() == true)
                {
                  List<Integer> v = (List<Integer>) JDBCHelper.getArray(RS, idx, cm._TildaType, false);
                  if (RS.wasNull() == true)
                    v = null;
                  print(out, elementName, idx == 1, CollectionUtil.toObjectArray(Integer.class, v));
                }
              else
                {
                  int v = RS.getInt(idx);
                  if (RS.wasNull() == true)
                    print(out, elementName, idx == 1, (String) null);
                  else
                    print(out, elementName, idx == 1, v);
                }
              break;
            case LONG:
              if (cm.isArray() == true)
                {
                  List<Long> v = (List<Long>) JDBCHelper.getArray(RS, idx, cm._TildaType, false);
                  if (RS.wasNull() == true)
                    v = null;
                  print(out, elementName, idx == 1, CollectionUtil.toObjectArray(Long.class, v));
                }
              else
                {
                  long v = RS.getLong(idx);
                  if (RS.wasNull() == true)
                    print(out, elementName, idx == 1, (String) null);
                  else
                    print(out, elementName, idx == 1, v);
                }
              break;
            case SHORT:
              if (cm.isArray() == true)
                {
                  List<Short> v = (List<Short>) JDBCHelper.getArray(RS, idx, cm._TildaType, false);
                  if (RS.wasNull() == true)
                    v = null;
                  print(out, elementName, idx == 1, CollectionUtil.toObjectArray(Short.class, v));
                }
              else
                {
                  short v = RS.getShort(idx);
                  if (RS.wasNull() == true)
                    print(out, elementName, idx == 1, (String) null);
                  else
                    print(out, elementName, idx == 1, v);

                }
              break;
            case NUMERIC:
              if (cm.isArray() == true)
                {
                  List<BigDecimal> v = (List<BigDecimal>) JDBCHelper.getArray(RS, idx, cm._TildaType, false);
                  if (RS.wasNull() == true)
                    v = null;
                  print(out, elementName, idx == 1, CollectionUtil.toObjectArray(BigDecimal.class, v));
                }
              else
                {
                  BigDecimal v = RS.getBigDecimal(idx);
                  print(out, elementName, idx == 1, RS.wasNull() == true ? null : v);
                }
              break;
            case UUID:
              if (cm.isArray() == true)
                {
                  List<UUID> v = (List<UUID>) JDBCHelper.getArray(RS, idx, cm._TildaType, false);
                  if (RS.wasNull() == true)
                    v = null;
                  print(out, elementName, idx == 1, CollectionUtil.toObjectArray(UUID.class, v));
                }
              else
                {
                  UUID v = (java.util.UUID) RS.getObject(idx);
                  print(out, elementName, idx == 1, RS.wasNull() == true ? null : v);
                }
              break;
            default:
              throw new Exception("Unhandle switch case for '" + cm._TildaType.name() + "'.");
          }
      }

  }
