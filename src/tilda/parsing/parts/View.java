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

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;

import com.google.gson.annotations.SerializedName;

public class View extends Base
  {
    static final Logger              LOG                = LogManager.getLogger(View.class.getName());

    /*@formatter:off*/
    @SerializedName("columns"    ) public List<ViewColumn>     _ViewColumns= new ArrayList<ViewColumn    >();
    /*@formatter:on*/

    public transient List<Column>         _Columns = new ArrayList<Column>();
    
    @Override
    public Column getColumn(String name)
      {
        for (Column C : _Columns)
          if (C != null && C._Name != null && C._Name.equalsIgnoreCase(name) == true)
           return C;
        return null;
      }

    @Override
    public ObjectLifecycle getLifecycle()
      {
        return ObjectLifecycle.READONLY;
      }
    
    @Override
    public boolean isOCC()
      {
        return false;
      }
    
    @Override
    public String getWhat()
      {
        return "View";
      }
    
    public boolean Validate(ParserSession PS, Schema ParentSchema)
      {
        if (super.Validate(PS, ParentSchema) == false)
          return false;

        int Errs = PS.getErrorCount();

        if (_ViewColumns == null || _ViewColumns.isEmpty() == true)
          return PS.AddError("Schema '" + _ParentSchema.getFullName() + "' is declaring a view without any columns.");
         
        for (ViewColumn C : _ViewColumns)
         C.Validate(PS, this);
        
        super.ValidateJsonMapping(PS);
        
        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }
  }
