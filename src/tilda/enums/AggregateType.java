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

public enum AggregateType
  {
  SUM,

  AVG,

  MAX,

  MIN,

  DEV,

  VAR,

  COUNT,

  ARRAY;

    public static AggregateType parse(String Str)
      {
        for (AggregateType e : AggregateType.values())
          if (Str.equalsIgnoreCase(e.name()) == true)
            return e;
        return null;
      }

    public ColumnType getType(ColumnType T)
      {
        switch (this)
          {
            case ARRAY:
              return T;
            case AVG:
              if (T == ColumnType.FLOAT || T == ColumnType.DOUBLE || T == ColumnType.INTEGER || T == ColumnType.LONG)
                return ColumnType.DOUBLE;
              break;
            case COUNT:
              return ColumnType.LONG;
            case DEV:
              if (T == ColumnType.FLOAT || T == ColumnType.DOUBLE || T == ColumnType.INTEGER || T == ColumnType.LONG)
                return ColumnType.DOUBLE;
              break;
            case MAX:
            case MIN:
              return T;
            case SUM:
              if (T == ColumnType.FLOAT || T == ColumnType.DOUBLE)
                return ColumnType.DOUBLE;
              if (T == ColumnType.INTEGER || T == ColumnType.LONG)
                return ColumnType.LONG;
              break;
            case VAR:
              if (T == ColumnType.FLOAT || T == ColumnType.DOUBLE || T == ColumnType.INTEGER || T == ColumnType.LONG)
                return ColumnType.DOUBLE;
              break;
            default:
              throw new Error("Incomplete Switch statment: unknown ColumnType " + this.name() + ";");
          }
        throw new Error("Cannot do a " + name() + " aggregate on type " + T.name() + ".");
      }

    public boolean isComposable()
      {
        switch (this)
          {
            case ARRAY:
            case COUNT:
            case MAX:
            case MIN:
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

  }
