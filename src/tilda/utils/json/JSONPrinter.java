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
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.JDBCHelper;
import tilda.interfaces.JSONable;
import tilda.utils.json.elements.ElementBoolean;
import tilda.utils.json.elements.ElementBooleanArray;
import tilda.utils.json.elements.ElementDef;
import tilda.utils.json.elements.ElementDouble;
import tilda.utils.json.elements.ElementDoubleArray;
import tilda.utils.json.elements.ElementList;
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
      }

    protected List<ElementDef> _Elements = new ArrayList<ElementDef>();

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

//    public JSONPrinter addElement(String Name, List<? extends JSONable> L, String JsonExportName, ZonedDateTime SyncToken)
//      {
//        _Elements.add(new ElementList(Name, L, JsonExportName, SyncToken));
//        return this;
//      }
    
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
    
    public JSONPrinter addElementRaw(String Name, String JsonRawValue)
      {
        _Elements.add(new ElementRaw(Name, JsonRawValue));
        return this;
      }


    public void print(Writer Out)
    throws Exception
      {
        JSONUtil.startOK(Out, '{');
        printRaw(Out);
        JSONUtil.end(Out, '}');
      }

    public void printRawObj(Writer Out)
    throws Exception
      {
        Out.append("{\n");
        printRaw(Out);
        Out.append("\n}");
      }

    protected void printRaw(Writer Out)
    throws Exception
      {
        boolean First = true;
        for (ElementDef e : _Elements)
          {
            e.print(Out, First, "    ");
            First = false;
          }
      }
    
  }
