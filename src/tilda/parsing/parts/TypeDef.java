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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.enums.DefaultType;
import tilda.enums.MultiType;
import tilda.parsing.ParserSession;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

import com.google.gson.annotations.SerializedName;

public class TypeDef
  {
    static final Logger         LOG             = LogManager.getLogger(Mapper.class.getName());

    /*@formatter:off*/
    @SerializedName("type" ) public String         _TypeStr    ;
    @SerializedName("size" ) public Integer        _Size       ;
    /*@formatter:on*/

    public transient ColumnType _Type;
    public transient String     _TypeSep;
    public transient MultiType  _TypeCollection = MultiType.NONE;


    public TypeDef()
      {
      }

    public TypeDef(String Type, Integer Size)
      {
        _TypeStr = Type;
        _Size = Size;
      }

    protected static final Pattern _PList = Pattern.compile(".*\\[(.+)\\]");
    protected static final Pattern _PSet  = Pattern.compile(".*\\{(.+)\\}");

    public boolean Validate(ParserSession PS, String What, boolean AllowArrays, boolean StringSizeOptional)
      {
        int Errs = PS.getErrorCount();

        if (_TypeStr == null)
          return PS.AddError(What + " didn't define a 'type'. It is mandatory.");
        else
          {
            Matcher M = Column._PList.matcher(_TypeStr);
            if (M.matches() == true)
              {
                _TypeCollection = MultiType.LIST;
                _TypeSep = M.group(1);
                _TypeStr = _TypeStr.substring(0, M.start(1) - 1);
              }
            else
              {
                M = Column._PSet.matcher(_TypeStr);
                if (M.matches() == true)
                  {
                    _TypeCollection = MultiType.SET;
                    _TypeSep = M.group(1);
                    _TypeStr = _TypeStr.substring(0, M.start(1) - 1);
                  }

              }
            if ((_Type = ColumnType.parse(_TypeStr)) == null)
              return PS.AddError(What + " defined an invalid 'type' '" + _TypeStr + "'.");
            if (isCollection() == true)
              {
                if (AllowArrays == false)
                  return PS.AddError(What + " is defined as an array type which is not supported in this context");
                if (_Type.isArrayCompatible() == false)
                  return PS.AddError(What + "is defined as a 'type' '" + _Type + "' which is not supported as an Array.");
              }
          }

        if (_Type == ColumnType.STRING)
          {
            if (isCollection() == true)
              {
                if (_Size != null)
                  PS.AddError(What + " is defined as a '" + _Type + "' Array and also defines a size. Size is not valid for array types.");
              }
            else
              {
                if (_Size == null)
                  {
                    if (StringSizeOptional == false)
                      PS.AddError(What + " is defined as a '" + _Type + "' but doesn't define a size.");
                  }
                else if (_Size < 2)
                  PS.AddError(What + " is defined as a '" + _Type + "' but doesn't define a size >= 2.");
              }
          }
        else
          {
            if (_Size != null)
              PS.AddError(What + " is defined as a '" + _Type + "' with a 'size'. Only String columns should have a 'size' defined.");
          }

        return Errs == PS.getErrorCount();
      }

    public boolean isCollection()
      {
        return _TypeCollection != MultiType.NONE;
      }

    public boolean isSet()
      {
        return _TypeCollection == MultiType.SET;
      }

    public boolean isList()
      {
        return _TypeCollection == MultiType.LIST;
      }

    public boolean CheckValueType(ParserSession PS, String What, String Value, boolean DateTimeAllowed, DefaultType Default)
      throws Error
      {
        switch (_Type)
          {
            case BINARY:
            case BITFIELD:
            case BOOLEAN:
              PS.AddError(What + " is a '" + _Type + "' which is not allowed.");
              return false;
            case DATETIME:
              if (DateTimeAllowed == false)
                return PS.AddError(What + " is a '" + _Type + "' which is not allowed.");
              if (Value.equalsIgnoreCase("NOW") == false && Value.equalsIgnoreCase("UNDEFINED") == false)
                return PS.AddError(What + " has a value '" + Value + "' which is not a default NOW or UNDEFINED value. Only these pre-defined values are allowed for timestamps.");
              if (Default == DefaultType.NONE)
                return PS.AddError(What + " has a value '" + Value + "' which is not set as a default. Only default values are allowed for timestamps.");
              break;
            case CHAR:
              if (Value.length() != 1)
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case DOUBLE:
              if (TextUtil.parseDouble(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case FLOAT:
              if (TextUtil.parseFloat(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case INTEGER:
              if (TextUtil.parseInt(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case LONG:
              if (TextUtil.parseLong(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case STRING:
              if (Value.length() > _Size)
                return PS.AddError(What + " has a value '" + Value + "' which is larger than the defined String size '" + _Size + "'.");
              break;
            default:
              throw new Error("Unhandled case in switch for type '" + _Type + "'.");
          }

        return true;
      }
  }
