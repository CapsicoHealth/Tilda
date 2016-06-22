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

package tilda.utils;

import java.io.IOException;
import java.io.Writer;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import tilda.db.JDBCHelper;
import tilda.interfaces.JSONable;

public class JSONUtil
  {
    protected static final Logger LOG = LogManager.getLogger(JDBCHelper.class.getName());

    protected static void PrintString(Writer Out, String v)
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

    protected static void PrintZonedDateTime(Writer Out, ZonedDateTime v)
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

    protected static void PrintChar(Writer Out, char v)
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

    protected static void PrintFloat(Writer Out, float v)
    throws IOException
      {
        Out.write(v == Float.NaN ? "null" : Float.toString(v));
      }

    protected static void PrintDouble(Writer Out, double v)
    throws IOException
      {
        Out.write(v == Double.NaN ? "null" : Double.toString(v));
      }

    protected static void Print(Writer Out, String Name, boolean FirstElement)
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

    public static void PrintSubJson(Writer Out, String Name, boolean FirstElement, String v)
    throws IOException
      {
        Print(Out, Name, FirstElement);
        Out.write(TextUtil.isNullOrEmpty(v) == true ? "null" : v);
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, String v)
    throws IOException
      {
        Print(Out, Name, FirstElement);
        PrintString(Out, v);
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, char v)
    throws IOException
      {
        Print(Out, Name, FirstElement);
        PrintChar(Out, v);
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, ZonedDateTime v)
    throws IOException
      {
        Print(Out, Name, FirstElement);
        PrintZonedDateTime(Out, v);
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, boolean v)
    throws IOException
      {
        Print(Out, Name, FirstElement);
        Out.write(Boolean.toString(v));
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, int v)
    throws IOException
      {
        Print(Out, Name, FirstElement);
        Out.write(Integer.toString(v));
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, long v)
    throws IOException
      {
        Print(Out, Name, FirstElement);
        Out.write(Long.toString(v));
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, float v)
    throws IOException
      {
        Print(Out, Name, FirstElement);
        PrintFloat(Out, v);
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, double v)
    throws IOException
      {
        Print(Out, Name, FirstElement);
        PrintDouble(Out, v);
      }


    public static void Print(Writer Out, String Name, boolean FirstElement, boolean[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            Out.write(((Boolean) i).toString());
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, Boolean[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            Out.write(i == null ? "null" : i.toString());
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, int[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            Out.write(((Integer) i).toString());
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, Integer[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            Out.write(i == null ? "null" : i.toString());
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, long[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            Out.write(((Long) i).toString());
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, Long[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            Out.write(i == null ? "null" : i.toString());
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, char[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            PrintChar(Out, i);
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, Character[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            PrintChar(Out, i);
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, float[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            PrintFloat(Out, i);
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, Float[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            PrintFloat(Out, i);
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, double[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            PrintDouble(Out, i);
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, Double[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            PrintDouble(Out, i);
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, String[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            PrintString(Out, i);
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, Collection<String> a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            PrintString(Out, i);
          }
        Out.write("]");
      }

    public static void Print(Writer Out, String Name, boolean FirstElement, ZonedDateTime[] a)
    throws IOException
      {
        Print(Out, Name, FirstElement);
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
              Out.write(",");
            PrintZonedDateTime(Out, i);
          }
        Out.write("]");
      }

    public static void startOK(Writer Out, char openObjectOrArray)
    throws IOException
      {
        Out.write("{\"code\":");
        Out.write(Integer.toString(HttpStatus.OK._Code));
        Out.write(",\"data\": ");
        Out.write(openObjectOrArray);
        Out.write("\n");
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
            Obj.toJSON(Out, JsonExportName, false);
            end(Out, '}');
          }
      }

    public static void response(Writer Out, String JsonExportName, List<? extends JSONable> L)
    throws Exception
      {
        Out.write("{\"code\":");
        Out.write(Integer.toString(HttpStatus.OK._Code));
        Print(Out, "data", JsonExportName, false, L, " ");
        end(Out, ' ');
      }

    public static void response(Writer Out, String[][] groupValues)
    throws IOException
      {
        Out.write("{\"code\":");
        Out.write(Integer.toString(HttpStatus.OK._Code));
        Print(Out, "data", false, groupValues, "");
        end(Out, ' ');
      }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> fromJSON(String JsonStr)
      {
        Map<String, Object> Filter = new HashMap<String, Object>();
        Gson gson = new Gson();
        return (Map<String, Object>) gson.fromJson(JsonStr, Filter.getClass());
      }

    public static void Print(Writer Out, String elementName, String JsonExportName, boolean firstElement, List<? extends JSONable> L, String Header)
    throws Exception
      {
        Out.write(Header);
        Print(Out, elementName, firstElement);

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
                Out.write(Header+"   ");
                First = false;
              }
            else
              Out.write(Header+"  ,");
            Obj.toJSON(Out, JsonExportName, true);
            Out.write("\n");
          }
        Out.write(Header+"  ]\n");
      }

    public static void Print(Writer Out, String elementName, String JsonExportName, boolean firstElement, JSONable Obj, String Header)
    throws Exception
      {
        Out.write(Header);
        Print(Out, elementName, firstElement);
        if (Obj == null)
          Out.write(" null ");
        else
          Obj.toJSON(Out, JsonExportName, true);
      }
    
    public static void Print(Writer Out, String elementName, boolean firstElement, String[][] Values, String Header)
    throws IOException
      {
        Out.write(Header);
        Print(Out, elementName, firstElement);
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
                PrintString(Out, s);
              }
            Out.write("]");
          }
        Out.write(" ]\n");
      }

  }
