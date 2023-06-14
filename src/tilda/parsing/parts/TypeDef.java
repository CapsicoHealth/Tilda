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

import java.math.BigDecimal;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.enums.DefaultType;
import tilda.enums.MultiType;
import tilda.enums.ValidationStatus;
import tilda.parsing.ParserSession;
import tilda.utils.ParseUtil;
import tilda.utils.SystemValues;

public class TypeDef
  {
    static final Logger                LOG             = LogManager.getLogger(Mapper.class.getName());

    /*@formatter:off*/
    @SerializedName("type"      ) public String         _TypeStr    ;
    @SerializedName("size"      ) public Integer        _Size       ;
    @SerializedName("precision" ) public Integer        _Precision  = 19; // Default values commonly used for Monetary amounts which is a very common use
    @SerializedName("scale"     ) public Integer        _Scale      =  4; // for numeric. https://stackoverflow.com/questions/224462/storing-money-in-a-decimal-column-what-precision-and-scale
    /*@formatter:on*/

    protected transient ColumnType     _Type;
    protected transient MultiType      _TypeCollection = MultiType.NONE;

    private transient ValidationStatus _Validation     = ValidationStatus.NONE;


    public TypeDef()
      {
      }

    public TypeDef(TypeDef td)
      {
        _TypeStr = td._TypeStr;
        _Size = td._Size;
        _Precision = td._Precision;
        _Scale = td._Scale;
      }

    public TypeDef(String TypeStr, Integer Size, Integer Precision, Integer Scale)
      {
        _TypeStr = TypeStr;
        _Size = Size;
        _Precision = Precision;
        _Scale = Scale;
      }


    public boolean Validate(ParserSession PS, String What, boolean AllowArrays, boolean StringSizeOptional)
      {
        if (_Validation != ValidationStatus.NONE)
          return _Validation == ValidationStatus.SUCCESS;
        int Errs = PS.getErrorCount();
        ValidateBase(PS, What, AllowArrays, StringSizeOptional);
        _Validation = Errs == PS.getErrorCount() ? ValidationStatus.SUCCESS : ValidationStatus.FAIL;
        return _Validation == ValidationStatus.SUCCESS;
      }

    protected static Pattern _P = Pattern.compile("STRING\\s*\\(\\s*(\\d+)\\s*\\)");
    
    private void ValidateBase(ParserSession PS, String What, boolean AllowArrays, boolean StringSizeOptional)
      {
        if (_TypeStr == null)
          {
            PS.AddError(What + " didn't define a 'type'. It is mandatory.");
            return;
          }

        String BaseType = _TypeStr;
        if (_TypeStr.endsWith("[]") == true)
          {
            _TypeCollection = MultiType.LIST;
            BaseType = _TypeStr.substring(0, _TypeStr.length() - 2);
          }
        else if (_TypeStr.endsWith("{}") == true)
          {
            _TypeCollection = MultiType.SET;
            BaseType = _TypeStr.substring(0, _TypeStr.length() - 2);
          }
        else if (_TypeStr.startsWith("STRING(") == true)
          {
            Matcher m = _P.matcher(_TypeStr);
            if (m.find() == true)
             _Size = ParseUtil.parseInteger(m.group(1), SystemValues.EVIL_VALUE);
            if (_Size == SystemValues.EVIL_VALUE)
             {
               PS.AddError(What + " defined an invalid 'type' '" + _TypeStr + "' which was thought to be a String+size, e.g. STRING(250), but cannot parse the size value as an integer.");
               return;
             }
            BaseType = "STRING";
          }

        if ((_Type = ColumnType.parse(BaseType)) == null)
          {
            PS.AddError(What + " defined an invalid 'type' '" + _TypeStr + "'.");
            return;
          }

        if (isCollection() == true)
          {
            if (AllowArrays == false)
              {
                PS.AddError(What + " is defined as an array type which is not supported in this context");
                return;
              }
            if (_Type.isCollectionCompatible(_TypeCollection) == false)
              {
                PS.AddError(What + "is defined as a 'type' '" + _Type + "' which is not supported as an Array.");
                return;
              }
          }

        if (_Type == ColumnType.STRING)
          {
            if (isCollection() == true)
              {
                if (_Size != null && _Size > 0)
                  PS.AddError(What + " is defined as a '" + _Type + "' Array and also defines a size. Size is not valid for array types.");
              }
            else
              {
                if (_Size == null || _Size == 0)
                  {
                    if (StringSizeOptional == false)
                      PS.AddError(What + " is defined as a '" + _Type + "' but doesn't define a size.");
                  }
                else if (_Size < 2)
                  PS.AddError(What + " is defined as a '" + _Type + "' but doesn't define a size >= 2.");
              }
          }
        else if (_Type == ColumnType.NUMERIC)
          {
            if (_Scale != null && _Precision == null)
              {
                PS.AddError(What + " is defined as a '" + _Type + "' and has defined a Scale without a Precision. This is not allowed per Standard SQL.");
              }
            else if (_Precision != null && _Scale != null && _Scale > _Precision)
              {
                PS.AddError(What + " is defined as a '" + _Type + "' and has Scale that is greater than the Precision. This is not allowed per Standard SQL.");
              }
            else if (_Precision == null || _Precision == 0)
              {
                if (StringSizeOptional == false)
                  PS.AddError(What + " is defined as a '" + _Type + "' but doesn't define a Precision.");
              }
            else if (_Precision != null && _Precision < 0)
              {
                PS.AddError(What + " is defined as a '" + _Type + "' and has Precision that is less than 0. This is not allowed per Standard SQL.");
              }
            else if (_Scale != null && _Scale < 0)
              {
                PS.AddError(What + " is defined as a '" + _Type + "' and has Scale that is less than 0. This is not allowed per Standard SQL.");
              }

            // Sets a default of 0 when no scale is defined in schema
            if (_Scale == null)
              _Scale = 0;
          }
        else
          {
            if (_Size != null && _Size > 0)
              PS.AddError(What + " is defined as a '" + _Type + "' with a 'size'. Only String columns should have a 'size' defined.");
          }
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
              if (ParseUtil.parseDouble(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case FLOAT:
              if (ParseUtil.parseFloat(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case NUMERIC:
              if (ParseUtil.parseBigDecimal(Value, new BigDecimal(SystemValues.EVIL_VALUE)) == new BigDecimal(SystemValues.EVIL_VALUE))
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case SHORT:
              if (ParseUtil.parseShort(Value, (short) SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case UUID:
              if (ParseUtil.parseUUID(Value) == new UUID(0L, 0L))
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case INTEGER:
              if (ParseUtil.parseInteger(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                return PS.AddError(What + " has a value '" + Value + "' which is invalid for type '" + _Type + "'.");
              break;
            case LONG:
              if (ParseUtil.parseLong(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
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

    public ColumnType getType()
      {
        return _Type;
      }

    public MultiType getTypeCollection()
      {
        return _TypeCollection;
      }
    
    @Override
    public String toString()
     {
       return _Type==null?"NULL_TYPE"
             :_Type.name()+(isList() ? "[]"
                           :isSet() ? "{}"
                           :_Type == ColumnType.STRING ? "("+_Size+")"
                           : ""
                           );
                           
     }
  }
