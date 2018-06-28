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

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.enums.NVPSourceType;
import tilda.enums.OutputFormatType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

public class OutputMapping
  {

    public OutputMapping()
      {
      }

    /*@formatter:off*/
    @SerializedName("name"        ) public String   _Name;
    @SerializedName("columns"     ) public String[] _Columns;
    @SerializedName("sync"        ) public boolean  _Sync = false;
    @SerializedName("outTypes"    ) public String[] _OutputTypeStrs;
    @SerializedName("nvpSrc"      ) public String 	_NVPSrcStr;
    @SerializedName("nvpValueType") public String   _NVPValueTypeStr;
    
    /*@formatter:on*/

    public transient List<Column>           _ColumnObjs;
    public transient List<OutputFormatType> _OutputTypes;
    public transient NVPSourceType          _NVPSrc;

    public transient Base                   _ParentObject;

    public boolean Validate(ParserSession PS, Base ParentObject)
      {
        int Errs = PS.getErrorCount();
        _ParentObject = ParentObject;

        _OutputTypes = OutputFormatType.parse(_OutputTypeStrs);
        if (_OutputTypes.isEmpty() == true)
          _OutputTypes.add(OutputFormatType.JSON);
        
        _ColumnObjs = ValidationHelper.ProcessColumn(PS, ParentObject, "OutputMapping '" + _Name + "'", _Columns, new ValidationHelper.Processor()
          {
            @Override
            public boolean process(ParserSession PS, Base ParentObject, String What, Column C)
              {
                if (C._Type == ColumnType.BINARY)
                  PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping with column '" + C.getName() + "' which is a binary. Binaries cannot be JSONed.");
                if (C._Type == ColumnType.JSON && _OutputTypes.contains(OutputFormatType.CSV) == true)
                  PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping with column '" + C.getName() + "' which is a JSON object. JSON objects cannot be exported in CSV format.");
                return true;
              }
          });

        if (_OutputTypes.contains(OutputFormatType.NVP) == true)
          {
        	
        	// TODO: Moved to Column Based since that's really the only place required to have this attribute. Run by LDH.
            //if (TextUtil.isNullOrEmpty(_NVPValueTypeStr))
            //  PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP without an nvpValueType. A column type ('STRING', 'INTEGER', etc.) must be defined.");
        	           
            if (TextUtil.isNullOrEmpty(_NVPSrcStr) == true)
              PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP without an NVP type of ROW or COLUMN. An nvpType attribute must be used with NVP outputMap.");

            _NVPSrc = NVPSourceType.parse(_NVPSrcStr);
            if (_NVPSrc == null)
              PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP with an invalid NVPSrc type '" + _NVPSrcStr + "': must be COLUMNS or ROWS.");

            if (_NVPSrc.equals(NVPSourceType.ROWS))
              {
                if (_ColumnObjs.size() != 2)
                  PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP that is ROWS-based with " + _ColumnObjs.size() + " Columns. Only 2 Columns are allowed.");
                /*
                 * LDH-NOTE: Keep for future performance analysis of the 2 idioms
                 * if (_ParentObject.getColumn(_Key) != null)
                 * if(_ColumnObjs.stream().map(Column::getName).filter(_Key::equals).findFirst().isPresent() == false)
                 * PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP with Key column \"" + _Key +
                 * "\" that is not found in the column mappings.");
                 */
                //if (_ColumnObjs.get(0).getType().equals(ColumnType.STRING) == false)
                //  PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP that is ROWS-based with its 'Name' column \"" + _ColumnObjs.get(0)._Name + "\" that is not a String. The 'Name' columns in the name/value pair structure must be a String.");
                
                // TODO: Not really needed for Row based NVP. Run by LDH.
                //if (_ColumnObjs.get(1).getType().isCompatible(_NVPValueTypeStr) == false)
                //  PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP that is ROWS-based with its 'Value' column \"" + _ColumnObjs.get(1)._Name + "\" that is incompatible with the nvpValueType of '" + _NVPValueTypeStr + "'. Compatible types are " + _ColumnObjs.get(1).getType().getCompatibleTypes(_NVPValueTypeStr));
              }
            else if (_NVPSrc.equals(NVPSourceType.COLUMNS))
              {
                if (TextUtil.isNullOrEmpty(_NVPValueTypeStr))
                    PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP that is COLUMNS-based without an nvpValueType. A column type ('STRING', 'INTEGER', etc.) must be defined.");    
            	
                for (Column C : _ColumnObjs)
                  if (C != null && C.getType().isCompatible(_NVPValueTypeStr) == false)
                    PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping that is COLUMNS-based with column '" + C.getName() + "'  that is incompatible with the nvpValueType of '" + _NVPValueTypeStr + "'. Compatible types are " + C.getType().getCompatibleTypes(_NVPValueTypeStr));
              }
            else
              throw new Error("An Output mapping NVP with a source type '" + _NVPSrc.name() + "' is not handled properly in the code.");
          }
        else if (TextUtil.isNullOrEmpty(_NVPSrcStr) == false)
          PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining an Output mapping with a 'nvpSrc' attribute, but no NVP output type.");

        if (_Sync == true && _ParentObject.isOCC() == false)
          PS.AddError(ParentObject.getWhat() + " '" + _ParentObject.getFullName() + "' is defining a 'sync' Output mapping but the parent object is not OCC.");

        return Errs == PS.getErrorCount();
      }
  }
