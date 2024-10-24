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

import java.util.Map;

import tilda.enums.ColumnType;
import tilda.enums.DefaultType;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.ParserSession;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ViewColumn;
import tilda.utils.DateTimeUtil;
import tilda.utils.ParseUtil;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;
import tilda.utils.json.JSONUtil;

public class ValueHelper
  {
    public static void CheckColumnValue(ParserSession PS, ViewColumn Col, String Name, String Value, DefaultType Default)
    throws Error
      {
        CheckColumnValue(PS, "ViewColumn", Col.getFullName(), Col.getType(), Col.isCollection(), Col._Size, Name, Value, Default);
      }

    public static void CheckColumnValue(ParserSession PS, Column Col, String Name, String Value, DefaultType Default)
    throws Error
      {
        CheckColumnValue(PS, "Column", Col.getFullName(), Col.getType(), Col.isCollection(), Col._Size==null?0:Col._Size, Name, Value, Default);
      }

    public static void CheckColumnValue(ParserSession PS, String Label, Column Col, String Name, String Value, DefaultType Default)
    throws Error
      {
        CheckColumnValue(PS, Label, Col.getFullName(), Col.getType(), Col.isCollection(), Col._Size==null?0:Col._Size, Name, Value, Default);
      }

    protected static void CheckColumnValue(ParserSession PS, String Label, String ColFullName, ColumnType ColType, boolean ColCollection, int ColSize, String Name, String Value, DefaultType Default)
    throws Error
      {
        if (isSuported(ColType) == false)
          {
            PS.AddError(Label+" '" + ColFullName + "' defines values which is not allowed for type '" + ColType + "'.");
            return;
          }

        String defaultErr = Label+" '" + ColFullName + "' defines Value '" + (TextUtil.isNullOrEmpty(Name)==true ? "" : Name+"' with value '") + Value + "' which is incompatible with type '" + ColType + "'.";
        boolean isEvil = Value != null && Value.trim().equals("-666") == true;
        switch (ColType)
          {
            case BOOLEAN:
              if (ParseUtil.parseBoolean(Value, null) == null)
                PS.AddError(defaultErr);
              break;
            case SHORT:
              if (isEvil == false && ParseUtil.parseShort(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                PS.AddError(defaultErr);
              break;
            case INTEGER:
              if (isEvil == false && ParseUtil.parseInteger(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                PS.AddError(defaultErr);
              break;
            case LONG:
              if (isEvil == false && ParseUtil.parseLong(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                PS.AddError(defaultErr);
              break;
            case FLOAT:
              if (isEvil == false && ParseUtil.parseFloat(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                PS.AddError(defaultErr);
              break;
            case DOUBLE:
              if (isEvil == false && ParseUtil.parseDouble(Value, SystemValues.EVIL_VALUE) == SystemValues.EVIL_VALUE)
                PS.AddError(defaultErr);
              break;
            case NUMERIC:
              if (isEvil == false && ParseUtil.parseBigDecimal(Value, null) == null)
                PS.AddError(defaultErr);
              break;
            case CHAR:
              if (Value.length() != 1)
                PS.AddError(defaultErr);
              break;
            case STRING:
              if (ColCollection == false && Value.length() > ColSize)
                PS.AddError(Label+" '" + ColFullName + "' defines Value '" + Name + "' with value '" + Value + "' larger than the defined size=" + ColSize + ".");
              break;
            case DATETIME:
            case DATETIME_PLAIN:
              if (   Value.equalsIgnoreCase("NOW") == false
                  && Value.equalsIgnoreCase("UNDEFINED") == false
                  && (Default == DefaultType.MASK && Value.equals("Y") == false 
                                                  && Value.equals("Q") == false 
                                                  && Value.equals("M") == false)
                  && DateTimeUtil.parseDate(Value, "yyyy-MM-dd") == null
                 )
                PS.AddError(Label+" '" + ColFullName + "' defines Value '" + Name + "->" + Value + "' which is not a default NOW, UNDEFINED, valid YYYY-MM-DD value, or, in the case of a mask, Y/Q/M to truncate dates to Year, Quarter or Month.");
              if (Default == DefaultType.NONE)
                PS.AddError(Label+" '" + ColFullName + "' defines Value '" + Name + "' which is not set as a default. Only default values are allowed for timestamps.");
              break;
            case DATE:
              if (   Value.equalsIgnoreCase("NOW") == false 
                  && Value.equalsIgnoreCase("UNDEFINED") == false 
                  && (Default == DefaultType.MASK && Value.equals("Y") == false 
                                                  && Value.equals("Q") == false 
                                                  && Value.equals("M") == false)
                  && DateTimeUtil.parseDate(Value, "yyyy-MM-dd") == null
                 )
                PS.AddError(Label+" '" + ColFullName + "' defines Value '" + Name + "->" + Value + "' which is not a default NOW or UNDEFINED, valid yyyy-MM-dd value, or, in the case of a mask, Y/Q/M to truncate dates to Year, Quarter or Month.");
              if (Default == DefaultType.NONE)
                PS.AddError(Label+" '" + ColFullName + "' defines Value '" + Name + "' which is not set as a default. Only default values are allowed for Dates.");
              break;
            case JSON:
              Map<String, Object> M = null;
              try {
                 M = JSONUtil.fromJSON(Value);
               }
              catch (Exception X)
                {
                }
              if (M == null)
               PS.AddError(Label+" '" + ColFullName + "' defines Value '" + Name + "' with value '" + Value + "' which is not a JSON object.");
              break; 
            case BINARY:
            case BITFIELD:
            case UUID:
            default:
              throw new Error("Unhandled switch case for type '" + ColType + "'.");
          }
      }

    public static String printValueSQL(CodeGenSql sqlGen, String colName, ColumnType colType, boolean isCollection, String val)
    throws Exception
      {
        if (isSuported(colType) == false)
          throw new Exception("Column '" + colName + "' defines default value '" + val + "' which is not allowed for type '" + colType + "'.");
          
        if (isCollection == true)
          {
            // Coalesce default values will be literals
            return val;
          }
        switch (colType)
          {
            case BOOLEAN:
            case SHORT:
            case INTEGER:
            case LONG:
            case DOUBLE:
            case FLOAT:
            case NUMERIC:
              return val;
            case CHAR:
            case STRING:
              return TextUtil.escapeSingleQuoteForSQL(val);
            case DATE:
            case DATETIME:
            case DATETIME_PLAIN:
              if (val.equalsIgnoreCase("now") == true)
                return colType==ColumnType.DATETIME ? sqlGen.getCurrentTimestampStr() : sqlGen.getCurrentDateTimeStr();
              else if (val.equalsIgnoreCase("undefined") == true)
                return "'" + DateTimeUtil.printDateTimeForSQL(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT) + "'";
              else
                return TextUtil.escapeSingleQuoteForSQL(val);
            case JSON:
              return TextUtil.escapeSingleQuoteForSQL(val);
            case BINARY:
            case BITFIELD:
            case UUID:
            default:
              throw new Error("Unhandled switch case for type '" + colType + "'.");
          }
      }
    
    public static String printValueJava(String colName, ColumnType colType, boolean isCollection, String val, String getterStr)
    throws Error
      {
        switch (colType)
          {
            case BOOLEAN:
            case SHORT:
            case INTEGER:
              return val;
            case FLOAT:
              return val + "f";
            case LONG:
              return val + "l";
            case NUMERIC:
              return "new BigDecimal("+val+"d)";
            case DOUBLE:
              return val + "d";
            case CHAR:
              return TextUtil.escapeSingleQuoteForSQL(val);
            case DATETIME:
            case DATETIME_PLAIN:
              String truncateToFuncName = isCollection == true ? "truncateToZDT" : "truncateTo";
              if (val.equalsIgnoreCase("NOW") == true)
                return "DateTimeUtil.NOW_PLACEHOLDER_ZDT";
              else if (val.equalsIgnoreCase("UNDEFINED") == true)
                return "DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT";
              else if (val.equalsIgnoreCase("Y") == true)
                return "DateTimeUtil."+truncateToFuncName+"(" + getterStr + ", TimeSeriesType.YEARLY)";
              else if (val.equalsIgnoreCase("Q") == true)
                return "DateTimeUtil."+truncateToFuncName+"(" + getterStr + ", TimeSeriesType.QUARTERLY)";
              else if (val.equalsIgnoreCase("M") == true)
                return "DateTimeUtil."+truncateToFuncName+"(" + getterStr + ", TimeSeriesType.MONTHLY)";
              return "DateTimeUtil.parseWithoutZone(" + TextUtil.escapeDoubleQuoteWithSlash(val) + ")";
            case DATE:
              truncateToFuncName = isCollection == true ? "truncateToLD" : "truncateTo";
              if (val.equalsIgnoreCase("NOW") == true)
                return "DateTimeUtil.NOW_PLACEHOLDER_D";
              else if (val.equalsIgnoreCase("UNDEFINED") == true)
                return "DateTimeUtil.UNDEFINED_PLACEHOLDER_D";
              else if (val.equalsIgnoreCase("Y") == true)
                return "DateTimeUtil."+truncateToFuncName+"(" + getterStr + ", TimeSeriesType.YEARLY)";
              else if (val.equalsIgnoreCase("Q") == true)
                return "DateTimeUtil."+truncateToFuncName+"(" + getterStr + ", TimeSeriesType.QUARTERLY)";
              else if (val.equalsIgnoreCase("M") == true)
                return "DateTimeUtil."+truncateToFuncName+"(" + getterStr + ", TimeSeriesType.MONTHLY)";
              return "DateTimeUtil.parseDate(" + TextUtil.escapeDoubleQuoteWithSlash(val) + ", \"yyyy-MM-dd\")";
            case JSON:
            case STRING:
            case UUID:
              return TextUtil.escapeDoubleQuoteWithSlash(val);
            case BINARY:
            case BITFIELD:
              throw new Error("An invalid type '" + colType + "' was assigned column values for code gen.");
            default:
              throw new Error("Unhandled case in switch for type '" + colType + "'.");
          }
      }
    

    public static boolean isSuported(ColumnType colType)
      {
        switch (colType)
          {
            case BINARY:
            case BITFIELD:
            case UUID:
              return false;
            case JSON:
            case NUMERIC:
            case BOOLEAN:
            case SHORT:
            case INTEGER:
            case LONG:
            case DOUBLE:
            case FLOAT:
            case CHAR:
            case STRING:
            case DATE:
            case DATETIME:
            case DATETIME_PLAIN:
              return true;
            default:
              throw new Error("Unhandled switch case for type '" + colType + "'.");
          }
      }
  }
