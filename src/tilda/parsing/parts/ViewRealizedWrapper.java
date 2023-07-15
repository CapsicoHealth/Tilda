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
import tilda.enums.TildaType;
import tilda.parsing.ParserSession;

public class ViewRealizedWrapper extends Base
  {
    static final Logger LOG = LogManager.getLogger(ViewRealizedWrapper.class.getName());

    public ViewRealizedWrapper(Object O, View V)
      {
        super(TildaType.REALIZED_VIEW);
        _O = O;
        _Name = V.getRealizedTableName(false);
        _Description = "Realized table for view "+V.getShortName()+": "+ _O._Description;
        _OriginalName = _Name;
        _ParentSchema = O.getSchema();
      }

    public Object _O;

    public transient boolean         _Validated         = false;
    
    protected boolean validate(ParserSession PS, Schema ParentSchema)
      {
        return super.validate(PS, ParentSchema);
      }


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

    @Override
    public Schema getSchema()
      {
        return _O._ParentSchema;
      }


    @Override
    public String[] getFirstIdentityColumnNames(boolean naturalIdentitiesFirst)
      {
        return _O.getFirstIdentityColumnNames(naturalIdentitiesFirst);
      }
  }
