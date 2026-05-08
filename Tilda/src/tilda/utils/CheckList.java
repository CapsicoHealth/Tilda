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
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.interfaces.JSONable;
import tilda.utils.json.JSONUtil;

/**
 * 
 * @author ldh
 *
 */
public class CheckList
  {
    protected static final Logger LOG = LogManager.getLogger(CheckList.class.getName());

    protected static class Item implements JSONable
      {
        protected Item(boolean flag, String message)
          {
            _flag = flag;
            _message = message;
          }

        protected boolean _flag;
        protected String  _message;

        public boolean getFlag()
          {
            return _flag;
          }

        public String getMessage()
          {
            return _message;
          }

        @Override
        public void toJSON(Writer out, String jsonExportName, String lead, boolean fullObject)
        throws Exception
          {
            if (fullObject == true)
              out.write("{");
            JSONUtil.print(out, "flag", true, _flag);
            JSONUtil.print(out, "msg", false, _message);
            if (fullObject == true)
              out.write("}");
          }

        @Override
        public void toJSON(Writer out, String jsonExportName, String lead, boolean fullObject, boolean noNullArrays)
        throws Exception
          {
            toJSON(out, jsonExportName, lead, fullObject, false);
          }

        @Override
        public void toJSON(Writer out, String jsonExportName, String lead, boolean fullObject, ZonedDateTime lastsync)
        throws Exception
          {
            toJSON(out, jsonExportName, lead, fullObject, false);
          }

      }

    protected List<Item> _items     = new ArrayList<Item>();
    protected boolean    _hasErrors = false;

    public void addItem(boolean flag, String message)
      {
        _items.add(new Item(flag, message));
        if (flag == false)
          _hasErrors = true;
      }

    public List<Item> getItems()
      {
        return _items;
      }

    public boolean isEmpty()
      {
        return _items.isEmpty();
      }

    public boolean hasErrors()
      {
        return _hasErrors;
      }
  }
