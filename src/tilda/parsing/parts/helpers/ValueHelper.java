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

import tilda.enums.DefaultType;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Column;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class ValueHelper
  {
    public static void CheckColumnValue(ParserSession PS, Column Col, String Name, String Value, DefaultType Default)
        throws Error
        {
          switch (Col._Type)
            {
              case BINARY:
              case BITFIELD:
                PS.AddError("Column '" + Col.getFullName() + "' defines values which is not allowed for type '" + Col._Type + "'.");
                break;
              case BOOLEAN:
                break;
              case CHAR:
                if (Value.length() != 1)
                  PS.AddError("Column '" + Col.getFullName() + "' defines Value '" + Name + "' with value '" + Value + "' which is incompatible with type '" + Col._Type + "'.");
                break;
              case DOUBLE:
                if (TextUtil.parseDouble(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                  PS.AddError("Column '" + Col.getFullName() + "' defines Value '" + Name + "' with value '" + Value + "' which is incompatible with type '" + Col._Type + "'.");
                break;
              case FLOAT:
                if (TextUtil.parseFloat(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                  PS.AddError("Column '" + Col.getFullName() + "' defines Value '" + Name + "' with value '" + Value + "' which is incompatible with type '" + Col._Type + "'.");
                break;
              case INTEGER:
                if (TextUtil.parseInt(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                  PS.AddError("Column '" + Col.getFullName() + "' defines Value '" + Name + "' with value '" + Value + "' which is incompatible with type '" + Col._Type + "'.");
                break;
              case LONG:
                if (TextUtil.parseLong(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                  PS.AddError("Column '" + Col.getFullName() + "' defines Value '" + Name + "' with value '" + Value + "' which is incompatible with type '" + Col._Type + "'.");
                break;
              case STRING:
                if (Col.isCollection() == false && Value.length() > Col._Size)
                  PS.AddError("Column '" + Col.getFullName() + "' defines Value '" + Name + "' with value '" + Value + "' larger than the defined size=" + Col._Size + ".");
                break;
              case DATETIME:
                if (Value.equalsIgnoreCase("NOW") == false && Value.equalsIgnoreCase("UNDEFINED") == false)
                  PS.AddError("Column '" + Col.getFullName() + "' defines Value '" + Name + "' which is not a default NOW or UNDEFINED value. Only these pre-defined values are allowed for timestamps.");
                if (Default == DefaultType.NONE)
                  PS.AddError("Column '" + Col.getFullName() + "' defines Value '" + Name + "' which is not set as a default. Only default values are allowed for timestamps.");
                break;
              default:
                throw new Error("Unhandled case in switch for type '" + Col._Type + "'.");
            }
        }

    public static String printValue(Column Col, String DefaultValue) throws Exception
      {
        switch (Col._Type)
        {
          case BINARY:
          case BITFIELD:
            throw new Exception("Column '" + Col.getFullName() + "' defines default value '"+DefaultValue+"' which is not allowed for type '" + Col._Type + "'.");
          case BOOLEAN:
          case DOUBLE:
          case FLOAT:
          case INTEGER:
          case LONG:
            return DefaultValue;
          case CHAR:
          case STRING:
          case DATETIME:
            return TextUtil.EscapeSingleQuoteForSQL(DefaultValue);
          default:
            throw new Error("Unhandled case in switch for type '" + Col._Type + "'.");
        }
      }
  }
