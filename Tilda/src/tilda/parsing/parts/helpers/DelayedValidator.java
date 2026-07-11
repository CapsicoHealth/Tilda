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

package tilda.parsing.parts.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.ParserSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;


public class DelayedValidator
  {
    protected static final Logger LOG = LogManager.getLogger(DelayedValidator.class.getName());

    public DelayedValidator(ParserSession PS, Column srcCol, Object destObj, String destColName)
      {
        _PS = PS;
        _srcCol = srcCol;
        _destObj = destObj;
        _destColName = destColName;
      }

    public final ParserSession _PS;
    public final Column        _srcCol;
    public final Object        _destObj;
    public final String        _destColName;

    public static Column preCreateDestPK(ParserSession PS, Column srcCol, Object destObj, String destColName)
      {
        if (srcCol.isForeignKeyPreParse() == true && destObj._Validated == false)
          {
            if (destObj.createAutogenPK(PS, false) == true)
              return srcCol._ParentObject._Columns.get(0);
//          return new DelayedValidator(PS, srcCol, destObj, destColName);
          }
        return null;
      }

    public boolean matches(Object completedObject)
      {
        return completedObject.getFullName().equals(_destObj.getFullName());
      }

    public void apply()
      {
        Column col = _destObj.getColumn(_destColName);
        if (col == null)
          {
            _PS.AddError("Column '"+_srcCol.getFullName() + "' declared a forward sameAs to column to '" + _destObj.getFullName()+"."+_destColName + "' which still cannot be found after having processed all objects in this schema.");
            ReferenceHelper.logErrorKnownColumns(_destObj, _destColName);
            return;
          }
        if (col.hasBeenValidatedSuccessfully() == false)
          {
            _PS.AddError("Column '"+_srcCol.getFullName() + "' declared a forward sameAs to column '"+col.getFullName()+"' which has failed validation.");
            return;
          }
        
      }

  }
