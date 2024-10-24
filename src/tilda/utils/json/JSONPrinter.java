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

import java.io.Writer;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.JDBCHelper;
import tilda.interfaces.JSONable;
import tilda.utils.PaddingUtil;
import tilda.utils.TextUtil;
import tilda.utils.json.elements.ArrayElementEnd;
import tilda.utils.json.elements.ArrayElementStart;
import tilda.utils.json.elements.ElementArrayEnd;
import tilda.utils.json.elements.ElementArrayStart;
import tilda.utils.json.elements.ElementBoolean;
import tilda.utils.json.elements.ElementBooleanArray;
import tilda.utils.json.elements.ElementDef;
import tilda.utils.json.elements.ElementDef.NestingStatus;
import tilda.utils.json.elements.ElementDouble;
import tilda.utils.json.elements.ElementDoubleArray;
import tilda.utils.json.elements.ElementEnd;
import tilda.utils.json.elements.ElementStart;
import tilda.utils.json.elements.ElementList;
import tilda.utils.json.elements.ElementLocalDate;
import tilda.utils.json.elements.ElementLocalDateArray;
import tilda.utils.json.elements.ElementLong;
import tilda.utils.json.elements.ElementLongArray;
import tilda.utils.json.elements.ElementObj;
import tilda.utils.json.elements.ElementRaw;
import tilda.utils.json.elements.ElementString;
import tilda.utils.json.elements.ElementStringArray;
import tilda.utils.json.elements.ElementStringArrayDouble;
import tilda.utils.json.elements.ElementZonedDateTime;
import tilda.utils.json.elements.ElementZonedDateTimeArray;

public class JSONPrinter
  {
    protected static final Logger LOG = LogManager.getLogger(JDBCHelper.class.getName());

    public JSONPrinter()
      {
        this(false);
      }

    protected static final String ROOT_ARRAY_MARKER = "Array:___ROOT____";

    public JSONPrinter(boolean array)
      {
        _array = array;
        if (array == true)
          {
            _NestingStack.push(ROOT_ARRAY_MARKER);
          }
      }

    protected List<ElementDef> _Elements     = new ArrayList<ElementDef>();
    protected Deque<String>    _NestingStack = new ArrayDeque<String>();
    protected final boolean    _array;

    public JSONPrinter addElement(String Name, JSONable Obj, String JsonExportName)
      {
        _Elements.add(new ElementObj(Name, Obj, JsonExportName));
        return this;
      }

    public JSONPrinter addElement(String Name, List<? extends JSONable> L, String JsonExportName)
      {
        _Elements.add(new ElementList(Name, L, JsonExportName));
        return this;
      }

    public JSONPrinter addElement(String Name, List<? extends JSONable> L)
      {
        return addElement(Name, L, "");
      }

    // public JSONPrinter addElement(String Name, List<? extends JSONable> L, String JsonExportName, ZonedDateTime SyncToken)
    // {
    // _Elements.add(new ElementList(Name, L, JsonExportName, SyncToken));
    // return this;
    // }

    public JSONPrinter addElement(String Name, String Val)
      {
        _Elements.add(new ElementString(Name, Val));
        return this;
      }

    public JSONPrinter addElement(String Name, String[] Vals)
      {
        _Elements.add(new ElementStringArray(Name, Vals));
        return this;
      }

    public JSONPrinter addElement(String Name, String[][] Vals)
      {
        _Elements.add(new ElementStringArrayDouble(Name, Vals));
        return this;
      }


    public JSONPrinter addElement(String Name, boolean Val)
      {
        _Elements.add(new ElementBoolean(Name, Val));
        return this;
      }

    public JSONPrinter addElement(String Name, boolean[] Val)
      {
        _Elements.add(new ElementBooleanArray(Name, Val));
        return this;
      }

    public JSONPrinter addElement(String Name, long Val)
      {
        _Elements.add(new ElementLong(Name, Val));
        return this;
      }

    public JSONPrinter addElement(String Name, long[] Val)
      {
        _Elements.add(new ElementLongArray(Name, Val));
        return this;
      }

    public JSONPrinter addElement(String Name, double Val)
      {
        _Elements.add(new ElementDouble(Name, Val));
        return this;
      }

    public JSONPrinter addElement(String Name, double[] Val)
      {
        _Elements.add(new ElementDoubleArray(Name, Val));
        return this;
      }

    public JSONPrinter addElement(String Name, ZonedDateTime Val)
      {
        _Elements.add(new ElementZonedDateTime(Name, Val));
        return this;
      }

    public JSONPrinter addElement(String Name, ZonedDateTime[] Val)
      {
        _Elements.add(new ElementZonedDateTimeArray(Name, Val));
        return this;
      }

    public JSONPrinter addElement(String Name, LocalDate Val)
      {
        _Elements.add(new ElementLocalDate(Name, Val));
        return this;
      }

    public JSONPrinter addElement(String Name, LocalDate[] Val)
      {
        _Elements.add(new ElementLocalDateArray(Name, Val));
        return this;
      }

    public JSONPrinter addElementRaw(String Name, String JsonRawValue)
      {
        _Elements.add(new ElementRaw(Name, JsonRawValue));
        return this;
      }

    public JSONPrinter addArrayElementStart()
    throws Exception
      {
        String poppedName = _NestingStack.getFirst();
        if (poppedName.startsWith("Array:") == false)
          throw new Exception("JSON Nesting error: starting an array element off a non array '" + poppedName + "'.");

        _Elements.add(new ArrayElementStart("ArrayElement:" + poppedName));
        _NestingStack.push("ArrayElement:" + poppedName);
        return this;
      }

    public JSONPrinter addArrayElementClose()
    throws Exception
      {
        String poppedName = _NestingStack.pop();
        if (poppedName.startsWith("ArrayElement:") == false)
          throw new Exception("JSON Nesting error: closing array element on non array element '" + poppedName + "'.");
        poppedName = poppedName.substring("ArrayElement:".length());
        _Elements.add(new ArrayElementEnd(poppedName));
        return this;
      }

    public JSONPrinter addElementStart(String Name)
      {
        _Elements.add(new ElementStart(Name));
        _NestingStack.push("Element:" + Name);
        return this;
      }

    public JSONPrinter addElementClose(String Name)
    throws Exception
      {
        _Elements.add(new ElementEnd(Name));
        String poppedName = _NestingStack.pop();
        if (poppedName.equals("Element:" + Name) == false)
          throw new Exception("JSON Nesting error: closed element '" + Name + "' but '" + poppedName + "' was the most recently started.");
        return this;
      }

    public JSONPrinter addArrayStart(String Name)
      {
        _Elements.add(new ElementArrayStart(Name));
        _NestingStack.push("Array:" + Name);
        return this;
      }

    public JSONPrinter addArrayClose(String Name)
    throws Exception
      {
        _Elements.add(new ElementArrayEnd(Name));
        String poppedName = _NestingStack.pop();
        if (poppedName.equals("Array:" + Name) == false)
          throw new Exception("JSON Nesting error: closed array '" + Name + "' but '" + poppedName + "' was the most recently started.");
        return this;
      }

    private void testNestingStack()
    throws Exception
      {
        // If the stack is empty we are good!
        if (_NestingStack.isEmpty() == true)
          return;

        // If the stack only has one element and that element is the root marker and the json is actually an array, we are ok too
        String poppedName = _NestingStack.peekFirst();
        if (_NestingStack.size() == 1 && poppedName.equals(ROOT_ARRAY_MARKER) == true && _array == true)
          return;

        // Something is left dangling.
        throw new Exception("A JSON object is being printed out with unclosed elements or arrays: " + TextUtil.print(_NestingStack.iterator()));
      }

    public void print(Writer Out, String perfMessage)
    throws Exception
      {
        JSONUtil.startOK(Out, _array==true?'[':'{', perfMessage);
        printRaw(Out);
        JSONUtil.end(Out, _array==true?']':'}');
      }
    public void print(Writer Out)
    throws Exception
      {
        print(Out, null);
      }
    
    public void printRawObj(Writer Out)
    throws Exception
      {
        Out.append("{\n");
        printRaw(Out);
        Out.append("\n}");
      }

    public void printRawArray(Writer Out)
    throws Exception
      {
        Out.append("[\n");
        printRaw(Out);
        Out.append("\n]");
      }

    public void printRaw(Writer Out)
    throws Exception
      {
        testNestingStack();
        Deque<Boolean> _FirstElementStatusStack = new ArrayDeque<Boolean>();
        _FirstElementStatusStack.push(true);
        int level = 0;
        for (ElementDef e : _Elements)
          {
            boolean first = _FirstElementStatusStack.peek();
            e.print(Out, first, PaddingUtil.getPad(level*2));
            if (first == true)
              {
                _FirstElementStatusStack.pop();
                _FirstElementStatusStack.push(false);
              }
            if (e.getNestingStatus() == NestingStatus.START)
              {
                _FirstElementStatusStack.push(true);
                ++level;
              }
            else if (e.getNestingStatus() == NestingStatus.END)
              {
                _FirstElementStatusStack.pop();
                --level;
              }
          }
      }

  }
