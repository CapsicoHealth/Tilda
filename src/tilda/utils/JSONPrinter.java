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

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import tilda.db.JDBCHelper;
import tilda.interfaces.JSONable;

public class JSONPrinter
  {
    protected static final Logger LOG = LogManager.getLogger(JDBCHelper.class.getName());

    public JSONPrinter()
      {
      }

    protected List<ElementDef> _Elements = new ArrayList<ElementDef>();

    protected static interface ElementDef
      {
        public void Print(Writer Out, boolean FirstElement, String Header)
        throws Exception;
      }

    protected static class ElementObj implements ElementDef
      {
        public ElementObj(String Name, JSONable Val, String JsonExportName)
          {
            _Name = Name;
            _Val = Val;
            _JsonExportName = JsonExportName;
          }

        protected final String   _Name;
        protected final JSONable _Val;
        protected final String   _JsonExportName;

        public void Print(Writer Out, boolean FirstElement, String Header)
        throws Exception
          {
            JSONUtil.Print(Out, _Name, _JsonExportName, FirstElement, _Val, Header);
          }
      }

    protected static class ElementList implements ElementDef
      {
        public ElementList(String Name, List<? extends JSONable> Val, String JsonExportName)
          {
            _Name = Name;
            _Val = Val;
            _JsonExportName = JsonExportName;
          }

        protected final String                   _Name;
        protected final List<? extends JSONable> _Val;
        protected final String                   _JsonExportName;

        public void Print(Writer Out, boolean FirstElement, String Header)
        throws Exception
          {
            JSONUtil.Print(Out, _Name, _JsonExportName, FirstElement, _Val, Header);
          }
      }

    protected static class ElementValues implements ElementDef
      {
        public ElementValues(String Name, String[][] Val)
          {
            _Name = Name;
            _Val = Val;
          }

        protected final String     _Name;
        protected final String[][] _Val;

        public void Print(Writer Out, boolean FirstElement, String Header)
        throws Exception
          {
            JSONUtil.Print(Out, _Name, FirstElement, _Val, Header);
          }
      }

    protected static class ElementRaw implements ElementDef
      {
        public ElementRaw(String Name, String JsonRawValue)
          {
            _Name = Name;
            _Val = JsonRawValue;
          }
  
        protected final String _Name;
        protected final String _Val;
  
        public void Print(Writer Out, boolean FirstElement, String Header)
        throws Exception
          {
            JSONUtil.Print(Out, _Name, FirstElement);
            Out.write(_Val);
          }
      }
    
    protected static class ElementBoolean implements ElementDef
      {
        public ElementBoolean(String Name, boolean Val)
          {
            _Name = Name;
            _Val = Val;
          }

        protected final String  _Name;
        protected final boolean _Val;

        public void Print(Writer Out, boolean FirstElement, String Header)
        throws Exception
          {
            Out.write(Header);
            JSONUtil.Print(Out, _Name, FirstElement, _Val);
          }
      }
    protected static class ElementLong implements ElementDef
    {
      public ElementLong(String Name, long Val)
        {
          _Name = Name;
          _Val = Val;
        }

      protected final String  _Name;
      protected final long    _Val;

      public void Print(Writer Out, boolean FirstElement, String Header)
      throws Exception
        {
          Out.write(Header);
          JSONUtil.Print(Out, _Name, FirstElement, _Val);
        }
    }
    protected static class ElementDouble implements ElementDef
    {
      public ElementDouble(String Name, double Val)
        {
          _Name = Name;
          _Val = Val;
        }

      protected final String  _Name;
      protected final double  _Val;

      public void Print(Writer Out, boolean FirstElement, String Header)
      throws Exception
        {
          Out.write(Header);
          JSONUtil.Print(Out, _Name, FirstElement, _Val);
        }
    }

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

    public JSONPrinter addElement(String Name, String[][] Vals)
      {
        _Elements.add(new ElementValues(Name, Vals));
        return this;
      }
    public JSONPrinter addElement(String Name, boolean Val)
      {
        _Elements.add(new ElementBoolean(Name, Val));
        return this;
      }
    public JSONPrinter addElement(String Name, long Val)
      {
        _Elements.add(new ElementLong(Name, Val));
        return this;
      }
    public JSONPrinter addElement(String Name, double Val)
      {
        _Elements.add(new ElementDouble(Name, Val));
        return this;
      }
    
    public JSONPrinter addElementRaw(String Name, String JsonRawValue)
      {
        _Elements.add(new ElementRaw(Name, JsonRawValue));
        return this;
      }
    

    public void Print(Writer Out)
    throws Exception
      {
        JSONUtil.startOK(Out, '{');
        boolean First = true;
        for (ElementDef e : _Elements)
          {
            e.Print(Out, First, "    ");
            First = false;
          }
        JSONUtil.end(Out, '}');
      }

  }
