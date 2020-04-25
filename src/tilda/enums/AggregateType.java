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

import tilda.parsing.parts.ViewColumn;

public enum AggregateType
  {
  SUM,

  AVG,

  MIN,

  FIRST,

  MAX,

  LAST,

  DEV,

  VAR,

  COUNT,

  ARRAY,

  ARRAYCAT;

    public static AggregateType parse(String Str)
      {
        for (AggregateType e : AggregateType.values())
          if (Str.equalsIgnoreCase(e.name()) == true)
            return e;
        return null;
      }

    public ColumnType getType(ColumnType T)
      {
        // This method needs to be kept in sync with
        switch (this)
          {
            case ARRAY:
            case ARRAYCAT:
              return T;
            case AVG:
            case DEV:
            case VAR:
              if (T == ColumnType.FLOAT || T == ColumnType.DOUBLE || T == ColumnType.INTEGER || T == ColumnType.LONG)
                return ColumnType.DOUBLE;
              break;
            case COUNT:
              return ColumnType.LONG;
            case MIN:
            case MAX:
              if (T != ColumnType.DATETIME)
                return T;
              break;
            case FIRST:
            case LAST:
              return T;
            case SUM:
              if (T == ColumnType.FLOAT || T == ColumnType.DOUBLE)
                return ColumnType.DOUBLE;
              if (T == ColumnType.INTEGER || T == ColumnType.LONG)
                return ColumnType.LONG;
              break;
            default:
              throw new Error("Incomplete Switch statment: unknown Aggregate " + this.name() + ";");
          }
        throw new Error("Cannot do a " + name() + " aggregate on type " + T.name() + ".");
      }

    public String isCompatible(ViewColumn VC)
      {
        try
          {
            getType(VC._SameAsObj.getType());
            return null;
          }
        catch (Throwable T)
          {
            StringBuilder Str = new StringBuilder("View Column '" + VC.getFullName() + "' declares a nonsensical aggregate " + VC._Aggregate.name() + " over type " + VC._SameAsObj.getType().name() + ".");
            if (VC._SameAsObj.getType() == ColumnType.DATETIME && (this == AggregateType.MIN || this == AggregateType.MAX))
              Str.append(" Because of the way ZonedDateTimes are represented in the database as two columns, Min/Max are not supported as aggregates but you can use First/Last with orderBy instead to the same effect.");
            return Str.toString();
          }

      }


    public boolean isComposable()
      {
        switch (this)
          {
            case ARRAY:
            case COUNT:
            case MIN:
            case FIRST:
            case MAX:
            case LAST:
            case SUM:
              return true;
            case AVG:
            case DEV:
            case VAR:
              return false;
            default:
              throw new Error("Incomplete Switch statment: unknown ColumnType " + this.name() + ";");
          }
      }

    public AggregateType getComposedAggregate()
      {
        if (isComposable() == false)
          return null;

        return this == COUNT ? SUM : this;
      }

    public boolean isOrderable()
      {
        switch (this)
          {
            case ARRAY:
            case ARRAYCAT:
            case FIRST:
            case LAST:
              return true;
            case COUNT:
            case MIN:
            case MAX:
            case SUM:
            case AVG:
            case DEV:
            case VAR:
              return false;
            default:
              throw new Error("Incomplete Switch statment: unknown ColumnType " + this.name() + ";");
          }
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
        return isOrderable() == true;
      }

    public boolean isCollection()
      {
        return this == ARRAY || this == ARRAYCAT;
      }

  }
