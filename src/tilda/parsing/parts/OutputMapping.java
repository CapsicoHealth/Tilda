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

import java.util.List;

import tilda.enums.ColumnType;
import tilda.enums.OutputFormatType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;

import com.google.gson.annotations.SerializedName;

public class OutputMapping
  {

    public OutputMapping()
      {
      }

    /*@formatter:off*/
    @SerializedName("name"   ) public String   _Name;
    @SerializedName("columns") public String[] _Columns;
    @SerializedName("sync"   ) public boolean  _Sync = false;
    @SerializedName("outTypes") public String[] _OutputTypeStrs;
    /*@formatter:on*/

    public transient List<Column> _ColumnObjs;
    public transient List<OutputFormatType> _OutputTypes;

    public transient Base       _ParentObject;

    public boolean Validate(ParserSession PS, Base ParentObject)
      {
        int Errs = PS.getErrorCount();
        _ParentObject = ParentObject;

        _OutputTypes = OutputFormatType.parse(_OutputTypeStrs);
        if (_OutputTypes.isEmpty() == true)
          _OutputTypes.add(OutputFormatType.JSON);       
        
        _ColumnObjs = ValidationHelper.ProcessColumn(PS, ParentObject, "OutputMapping '" + _Name + "'", _Columns
         , new ValidationHelper.Processor() {
           @Override
           public boolean process(ParserSession PS, Base ParentObject, String What, Column C)
            {
              if (C._Type == ColumnType.BINARY)
                PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping with column '" + C.getName() + "' which is a binary. Binaries cannot be JSONed.");
              if (C._Type == ColumnType.JSON && _OutputTypes.contains(OutputFormatType.CSV) == true)
                PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping with column '" + C.getName() + "' which is a JSON object. JSON objects cannot be exported in CSV format.");
              return true;
            }
        });
        
        if(_OutputTypes.contains(OutputFormatType.NVP) == true &&  ParentObject.getWhat().equals("Object"))
          if(_ColumnObjs.size() != 2)
        	PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP with " + _ColumnObjs.size() + " Columns. Only two Columns are allowed for NVP on table defintions.");
        
        if (_Sync == true && _ParentObject.isOCC() == false)
          PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining a 'sync' Output mapping but the parent object is not OCC.");

        return Errs == PS.getErrorCount();
      }
  }
