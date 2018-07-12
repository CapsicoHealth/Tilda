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

package tilda.parsing.parts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ObjectLifecycle;

public class ViewRealizedWrapper extends Base
  {
    static final Logger LOG = LogManager.getLogger(ViewRealizedWrapper.class.getName());

    public ViewRealizedWrapper(Object O)
      {
        _O = O;
        _Name = _O._Name.substring(0, _O._Name.length()-4)+"Realized";
        _OriginalName = _O._OriginalName.substring(0, _O._OriginalName.length()-4)+"Realized";
      }

    public Object _O;

    @Override
    public Column getColumn(String name)
      {
        return _O.getColumn(name);
      }

    @Override
    public String[] getColumnNames()
      {
        return _O.getColumnNames();
      }

    @Override
    public ObjectLifecycle getLifecycle()
      {
        return _O.getLifecycle();
      }

    @Override
    public boolean isOCC()
      {
        return _O.isOCC();
      }

    @Override
    public String getWhat()
      {
        return "Realized"+_O.getWhat();
      }

    @Override
    public String getBaseName()
      {
        return _Name;
      }

    @Override
    public String getShortName()
      {
        return _O._ParentSchema.getShortName() + "." + _Name;
      }

    @Override
    public String getFullName()
      {
        return _O._ParentSchema.getFullName() + "." + _Name;
      }

  }
