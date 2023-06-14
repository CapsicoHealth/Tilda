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

package tilda.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tilda.parsing.parts.ViewColumn;
import tilda.utils.TextUtil;

public enum AggregateType
  {
//@formatter:off
     SUM         (false, true , OrderableType.NONE    , TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,AVG         (false, false, OrderableType.NONE    , TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,MIN         (false, true , OrderableType.NONE    , TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,MAX         (false, true , OrderableType.NONE    , TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,FIRST       (false, true , OrderableType.REQUIRED, TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,LAST        (false, true , OrderableType.REQUIRED, TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,DEV         (false, false, OrderableType.NONE    , TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,VAR         (false, false, OrderableType.NONE    , TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,COUNT       (false, true , OrderableType.NONE    , TargetColumnType.OPTIONAL, ParameterSetting.NONE)
    ,ARRAY       (false, true , OrderableType.OPTIONAL, TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,STRING      (false, true , OrderableType.OPTIONAL, TargetColumnType.REQUIRED, ParameterSetting.REQUIRED)
    ,ARRAYCAT    (false, false, OrderableType.OPTIONAL, TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,ROW_NUMBER  (true , false, OrderableType.REQUIRED, TargetColumnType.NONE    , ParameterSetting.NONE)
    ,RANK        (true , false, OrderableType.REQUIRED, TargetColumnType.NONE    , ParameterSetting.NONE)
    ,PERCENT_RANK(true , false, OrderableType.REQUIRED, TargetColumnType.NONE    , ParameterSetting.NONE)
    ,LEAD        (true , false, OrderableType.REQUIRED, TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,LAG         (true , false, OrderableType.REQUIRED, TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ,NTH_VALUE   (true , false, OrderableType.REQUIRED, TargetColumnType.REQUIRED, ParameterSetting.NONE)
    ;
//@formatter:on
    
    /**
     * For STRING aggregates, we can't reuse the size of the source column, so we set a default here of 10B which hopefully is enough
     * 10MB = 10*1024*1024
     */
    public static final Integer _DEFAULT_STRING_AGG_SIZE = 10*1024*1024;


    public static enum TargetColumnType
      {
      REQUIRED, OPTIONAL, NONE
      };

    public static enum OrderableType
      {
      REQUIRED, OPTIONAL, NONE
      };

    public static enum ParameterSetting
      {
      REQUIRED, OPTIONAL, NONE
      };

    private AggregateType(boolean windowOnly, boolean composable, OrderableType orderable, TargetColumnType targetColumn, ParameterSetting paramSetting)
      {
        _windowOnly = windowOnly;
        _composable = composable;
        _orderable = orderable;
        _targetColumn = targetColumn;
        _paramSetting = paramSetting;
      }

    protected final boolean          _windowOnly;
    protected final boolean          _composable;
    protected final OrderableType    _orderable;
    protected final TargetColumnType _targetColumn;
    protected final ParameterSetting _paramSetting;

    public boolean isWindowOnly()
      {
        return _windowOnly;
      }

    public boolean isComposable()
      {
        return _composable;
      }

    public OrderableType getOrderable()
      {
        return _orderable;
      }

    public ParameterSetting getParameterSetting()
      {
        return _paramSetting;
      }

    public TargetColumnType isTargetColumnRequired()
      {
        return _targetColumn;
      }

//@formatter:off
    protected static String[][] _ALIASES = {{"ROW_NUM"     , "ROW_NUMBER"   }
                                           ,{"ROWNUMBER"   , "ROW_NUMBER"   }
                                           ,{"ROWNUM"      , "ROW_NUMBER"   }
                                           ,{"ARRAY_AGG"   , "ARRAY"        }
                                           ,{"ARRAY_CAT"   , "ARRAYCAT"     }
                                           ,{"STRING_CAT"  , "STRING"       }
                                           ,{"STRING_AGG"  , "STRING"       }
                                           ,{"PERCENTRANK" , "PERCENT_RANK" }
                                           ,{"PCT_RANK"    , "PERCENT_RANK" }
                                           ,{"PCTRANK"     , "PERCENT_RANK" }
                                           ,{"RANK_PERCENT", "PERCENT_RANK" }
                                           ,{"RANKPERCENT" , "PERCENT_RANK" }
                                           ,{"RANK_PCT"    , "PERCENT_RANK" }
                                           ,{"RANKPCT"     , "PERCENT_RANK" }
                                           ,{"NTH"         , "NTH_VALUE"    }
                                           ,{"NTHVALUE"    , "NTH_VALUE"    }
                                           };
//@formatter:on


    /**
     * Pattern for an aggregate with params, e.g., "abced(param1, ...)".
     */
    protected final static Pattern _AGG_REGEX = Pattern.compile("\\s*(\\w+)\\s*(\\(([^\\)]+)\\))?\\s*");

    public static AggregateType parse(String str)
      {
        Matcher M = _AGG_REGEX.matcher(str);
        if (M.matches() == false)
          return null;

        str = M.group(1);
        if (TextUtil.isNullOrEmpty(str) == true)
          return null;

        str = str.trim().toUpperCase();
        for (String[] alias : _ALIASES)
          if (str.equals(alias[0]) == true)
            {
              str = alias[1];
              break;
            }

        for (AggregateType e : AggregateType.values())
          if (str.equals(e.name()) == true)
            return e;

        return null;
      }


    /**
     * Parses an attribute part of an aggregate, for example STRING(','). Minimum syntax check is performed, i.e., checks that
     * there is an open and close parenthesis at the beginning and end, and that what's inside is a standard list of comma-separated parameters
     * 
     * @param aggregateStr
     * @return null if an error occurred, otherwise, the emoty string if no attributes were found,
     */
    public static String parseAttributes(String aggregateStr)
      {
        Matcher M = _AGG_REGEX.matcher(aggregateStr);
        if (M.matches() == false)
          return null;
        String params = M.group(3);
        if (TextUtil.isNullOrEmpty(params) == true)
          return "";
        return params.trim();
      }

    public ColumnType getType(ColumnType T, boolean needsTZ)
      {
        // This method needs to be kept in sync with the types defined
        switch (this)
          {
            case ARRAY:
            case ARRAYCAT:
              return T;
            case AVG:
            case DEV:
            case VAR:
              if (T == ColumnType.FLOAT || T == ColumnType.DOUBLE || T == ColumnType.INTEGER || T == ColumnType.LONG || T == ColumnType.SHORT)
                return ColumnType.DOUBLE;
              if (T == ColumnType.NUMERIC)
                return ColumnType.NUMERIC;
              break;
            case STRING:
              return ColumnType.STRING;
            case COUNT:
              return ColumnType.LONG;
            case MIN:
            case MAX:
              if (T != ColumnType.DATETIME || needsTZ == false)
                return T;
              break;
            case FIRST:
            case LAST:
            case LEAD:
            case LAG:
            case NTH_VALUE:
              return T;
            case SUM:
              if (T == ColumnType.FLOAT || T == ColumnType.DOUBLE)
                return ColumnType.DOUBLE;
              if (T == ColumnType.INTEGER || T == ColumnType.LONG || T == ColumnType.SHORT)
                return ColumnType.LONG;
              if (T == ColumnType.NUMERIC)
                return ColumnType.NUMERIC;
              break;
            case ROW_NUMBER:
            case RANK:
              return ColumnType.LONG;
            case PERCENT_RANK:
              return ColumnType.DOUBLE;
            default:
              throw new Error("Incomplete Switch statment: unknown Aggregate " + this.name() + ";");
          }
        throw new Error("Cannot do a " + name() + " aggregate on type " + T.name() + ".");
      }

    public String isCompatible(ViewColumn VC)
      {
        if (isCompatible(VC.getType(), VC.needsTZ()) == true)
          return null;

        StringBuilder Str = new StringBuilder("View Column '" + VC.getFullName() + "' declares a nonsensical aggregate " + VC._Aggregate.name() + " over type " + VC._SameAsObj.getType().name() + ".");
        if (VC.getType() == ColumnType.DATETIME && (this == AggregateType.MIN || this == AggregateType.MAX))
          Str.append(" Because of the way ZonedDateTimes are represented in the database as two columns, Min/Max are not supported as aggregates but you can use First/Last with orderBy instead to the same effect.");
        return Str.toString();
      }

    public boolean isCompatible(ColumnType type, boolean needsTZ)
      {
        try
          {
            getType(type, needsTZ);
            return true;
          }
        catch (Throwable T)
          {
          }
        return false;
      }

    public AggregateType getComposedAggregate()
      {
        if (isComposable() == false)
          return null;

        return this == COUNT ? SUM : this;
      }


    /**
     * Tests whether an aggregate is friendly with DateTime columns. Because DateTime columns have a companion
     * TZ column to maintain the timezone information, aggregates that cannot be ordered essentially are not usable.
     * This method simply wraps isOrderable() in case we later need to make some modifications, i.e., the
     * isTimeZoneCompatible is semantically different enough from isOrderable that we didn't want to alias them.
     * 
     * @return
     */
    public boolean isZonedDateTimeCompatible()
      {
        return getOrderable() != OrderableType.NONE;
      }

    public boolean isList()
      {
        return this == ARRAY || this == ARRAYCAT;
      }

    public boolean areParametersAllowed()
      {
        return getParameterSetting() != ParameterSetting.NONE;
      }

  }
