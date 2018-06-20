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
import java.util.Optional;

import tilda.enums.ColumnType;
import tilda.enums.NVPType;
import tilda.enums.OutputFormatType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.helpers.ValidationHelper;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class OutputMapping
  {

    public OutputMapping()
      {
      }

    /*@formatter:off*/
    @SerializedName("name"    ) public String   _Name;
    @SerializedName("columns" ) public String[] _Columns;
    @SerializedName("sync"    ) public boolean  _Sync = false;
    @SerializedName("outTypes") public String[] _OutputTypeStrs;
    @SerializedName("key"     ) public String 	_Key;
    @SerializedName("nvpType" ) public String 	_NVPTypeStr;
    /*@formatter:on*/

    public transient List<Column> _ColumnObjs;
    public transient List<OutputFormatType> _OutputTypes;
    public transient NVPType _NVPType;
    
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
        
        if(_OutputTypes.contains(OutputFormatType.NVP) == true)
          {            
        	if(TextUtil.isNullOrEmpty(_NVPTypeStr) == true)
              PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP without an NVP type of ROW or COLUMN. An nvpType attribute must be used with NVP outputMap.");  
            
        	_NVPType = NVPType.parse(_NVPTypeStr);
        	
        	if(_NVPType == null)
        		PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP without a invalid NVP. An nvpType allowed attribute values are ROW or COLUMN.");
        	
        	if(_NVPType.equals(NVPType.COLUMN))
        	{
              if(_ColumnObjs.size() != 2)
        	    PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP with " + _ColumnObjs.size() + " Columns. Only two Columns are allowed for NVP Column Types.");             
        	  if(TextUtil.isNullOrEmpty(_Key) == true)
        		PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP without a Key column. The key attribute value must be one of the columns selected for output.");
        	  else if(_ColumnObjs.stream().map(Column::getName).filter(_Key::equals).findFirst().isPresent() == false)
        	    PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP with Key column \"" + _Key + "\" that is not found in the column mappings.");
        	  
        	  // UGH there's a better way for this below. This is temporary until we can get the dynamic map datatypes in.
        	  Column keyCol = null;
        	  Column valCol = null;
        	  
        	  for(Column C : _ColumnObjs)
        	    {
        		  if(C.getName().equals(_Key))
        			  keyCol = C;
        		  else
        			  valCol = C;
        	    }
        	  
        	  if(keyCol.getType() != ColumnType.STRING)
        	    PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP with Key column \"" + _Key + "\" that is not a String. Key columns must be String datatypes.");
        	  if(valCol.getType() != ColumnType.DOUBLE)
          	    PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP with Val column \"" + valCol.getName() + "\" that is not a Double. Value columns must be Double datatypes."); 	  
        	}

        	if(_NVPType.equals(NVPType.ROW))
        	  {
        		if(TextUtil.isNullOrEmpty(_Key) != true)   
        		  PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping NVP with Key column " + _Key + " For NVP Type ROW. This is not used for Row.");  
        		
          	  // UGH- again, this is temporary until we can get the dynamic map datatypes in.  
          	  for(Column C : _ColumnObjs)
          	    {
          		  if(C.getType() != ColumnType.DOUBLE)
          		    {
          			  PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining an Output mapping with column '" + C.getName() + "' which is NOT a Double datatype. Only Double datatypes are supported in NVP ROW exports at this time.");
          		    }  
          	    }
        	  }
          }
          
        if (_Sync == true && _ParentObject.isOCC() == false)
          PS.AddError(ParentObject.getWhat()+" '" + _ParentObject.getFullName() + "' is defining a 'sync' Output mapping but the parent object is not OCC.");

        return Errs == PS.getErrorCount();
      }
  }
