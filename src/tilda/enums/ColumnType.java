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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import tilda.utils.CollectionUtil;
import tilda.utils.PaddingTracker;
import tilda.utils.ParseUtil;
import tilda.utils.TextUtil;
import tilda.utils.pairs.StringStringPair;

public enum ColumnType
  {

    /*@formatter:off*/
    STRING     (true , true , false, "STR"),
    JSON       (true , false, false, "JSN"),
    CHAR       (true , true , true , "CHR"),
    SHORT      (true , true , true , "SHT"),
    INTEGER    (true , true , true , "INT"),
    LONG       (true , true , true , "LNG"),
    FLOAT      (true , true , true , "FLT"),
    DOUBLE     (true , true , true , "DBL"),
    NUMERIC    (true , true , false, "NUM"),
    BOOLEAN    (true , true , true , "BOL"),
    DATE       (true , true , false, "DT" ),
    DATETIME   (true , false, false, "DTM"), // Datetimes are stored as 2 columns in the DB, so SETs are not allowed because they are unordered.
    BINARY     (false, false, false, "BIN"),
    BITFIELD   (false, true , true , "BF" ),
    UUID       (true , true , false, "UI" );
    /*@formatter:on*/

    private ColumnType(boolean ArrayCompatible, boolean SetCompatible, boolean Primitive, String shortName)
      {
        _ArrayCompatible = ArrayCompatible;
        _SetCompatible = SetCompatible;
        _Primitive = Primitive;
        _SimpleName = TextUtil.capitalizeFirstCharacter(name().toLowerCase());
        _ShortName = shortName;
      }

    public static PaddingTracker       _PadderTypeNames = new PaddingTracker();
    public final boolean               _ArrayCompatible;
    public final boolean               _SetCompatible;
    public final boolean               _Primitive;
    public final String                _SimpleName;
    public final String                _ShortName;
    public final static ColumnType[][] _CompatibleTypes;
    public final static ColumnType[][] _CompatibleDBTypes;


    static
      {
        for (ColumnType T : ColumnType.values())

          _PadderTypeNames.track(T.name());

        _CompatibleTypes = new ColumnType[][] {
            { STRING, JSON, CHAR, INTEGER, LONG, FLOAT, DOUBLE, BOOLEAN, DATE, DATETIME, BITFIELD, SHORT, UUID, NUMERIC
            } // STRING
            , { JSON
            } // JSON
            , { CHAR, STRING
            } // CHAR
            , { SHORT
            } // SHORT
            , { INTEGER, SHORT
            } // INTEGER
            , { LONG, INTEGER, SHORT
            } // LONG
            , { FLOAT, INTEGER, SHORT
            } // FLOAT
            , { DOUBLE, FLOAT, INTEGER, LONG, SHORT
            } // DOUBLE
            , { NUMERIC, DOUBLE, FLOAT, INTEGER, LONG, SHORT
            } // NUMERIC
            , { BOOLEAN
            } // BOOLEAN
            , { DATE
            } // DATE
            , { DATETIME, DATE
            } // DATETIME
            , { BINARY
            } // BINARY
            , { BITFIELD
            } // BITFIELD
            , { UUID, STRING
            } // UUID
        };

        _CompatibleDBTypes = new ColumnType[][] {
            { STRING, JSON, CHAR, INTEGER, LONG, FLOAT, DOUBLE, BOOLEAN, DATE, DATETIME, BITFIELD, SHORT, NUMERIC, UUID
            } // STRING
            , { JSON, STRING
            } // JSON
            , { CHAR, STRING, BOOLEAN
            } // CHAR
            , { SHORT, BOOLEAN, STRING
            } // SHORT TODO:CHECK
            , { INTEGER, BOOLEAN, STRING, LONG, DOUBLE, FLOAT, SHORT, NUMERIC, BITFIELD
            } // INTEGER
            , { LONG, BOOLEAN, STRING, INTEGER, DOUBLE, FLOAT
            } // LONG
            , { FLOAT, BOOLEAN, STRING, INTEGER, DOUBLE, LONG
            } // FLOAT
            , { DOUBLE, FLOAT, INTEGER, LONG, BOOLEAN, STRING
            } // DOUBLE
            , { NUMERIC, DOUBLE, FLOAT, INTEGER, LONG, BOOLEAN, STRING
            } // NUMERIC TODO:CHECK
            , { BOOLEAN, DOUBLE, FLOAT, LONG, INTEGER, CHAR, STRING
            } // BOOLEAN
            , { DATE, STRING
            } // DATE
            , { DATETIME, DATE, STRING
            } // DATETIME
            , { BINARY
            } // BINARY
            , { BITFIELD
            } // BITFIELD
            , { UUID, STRING
            } // UUID
        };

        ColumnType[] colsToValidate = new ColumnType[_CompatibleTypes.length];
        for (int i = 0; i < _CompatibleTypes.length; i++)
          {
            colsToValidate[i] = _CompatibleTypes[i][0];
          }
        ColumnType.validate(colsToValidate);

        ColumnType[] dbColsToValidate = new ColumnType[_CompatibleDBTypes.length];
        for (int i = 0; i < _CompatibleDBTypes.length; i++)
          {
            dbColsToValidate[i] = _CompatibleDBTypes[i][0];
          }
        ColumnType.validate(dbColsToValidate);

      }

    public static ColumnType parse(String Str)
      {
        if (Str == null)
          return null;
        for (ColumnType e : ColumnType.values())
          if (Str.equalsIgnoreCase(e.name()) == true)
            return e;
        return null;
      }

    public boolean isCollectionCompatible(MultiType CollectionType)
      {
        return CollectionType == MultiType.LIST ? _ArrayCompatible
        : CollectionType == MultiType.SET ? _SetCompatible
        : false;
      }

    public boolean isPrimitive()
      {
        return _Primitive;
      }

    public boolean isCompatible(ColumnType Type)
      {
        if (Type != null)
          {
            if (Type == this)
              return true;

            for (int i = 0; i < _CompatibleTypes.length; i++)
              if (_CompatibleTypes[i][0] == Type)
                for (int j = 1; j < _CompatibleTypes[i].length; j++)
                  if (_CompatibleTypes[i][j] == this)
                    return true;
          }

        return false;
      }

    public boolean isDBCompatible(ColumnType Type)
      {
        if (Type != null)
          {
            if (Type == this)
              return true;

            for (int i = 0; i < _CompatibleDBTypes.length; i++)
              if (_CompatibleDBTypes[i][0] == Type)
                for (int j = 1; j < _CompatibleDBTypes[i].length; j++)
                  if (_CompatibleDBTypes[i][j] == this)
                    return true;
          }

        return false;
      }

    public String getCompatibleTypesString(ColumnType Type)
      {
        String compatibleTypes = Type.name();
        for (int i = 0; i < _CompatibleTypes.length; i++)
          if (_CompatibleTypes[i][0] == Type)
            for (int j = 1; j < _CompatibleTypes[i].length; j++)
              compatibleTypes += (compatibleTypes.length() > 0 ? ", " + _CompatibleTypes[i][j].name() : _CompatibleTypes[i][j].name());

        return compatibleTypes;
      }

    public String getCompatibleDBTypesString(ColumnType Type)
      {
        String compatibleTypes = Type.name();
        for (int i = 0; i < _CompatibleDBTypes.length; i++)
          if (_CompatibleDBTypes[i][0] == Type)
            for (int j = 1; j < _CompatibleDBTypes[i].length; j++)
              compatibleTypes += (compatibleTypes.length() > 0 ? ", " + _CompatibleDBTypes[i][j].name() : _CompatibleDBTypes[i][j].name());

        return compatibleTypes;
      }

    public static <T> void validate(T[] Enums)
      {
        ColumnType[] Vals = ColumnType.values();

        if (Vals.length != Enums.length)
          throw new Error("Error! The matching between " + ColumnType.class.getName() + " (" + Vals.length + ") and "
          + Enums[0].getClass().getName() + " (" + Enums.length + ") failed: the counts didn't match.");
        for (int i = 0; i < Vals.length; ++i)
          if (Vals[i].toString().equals(Enums[i].toString()) == false)
            throw new Error("Error! The enum " + ColumnType.class.getName() + "." + Vals[i].toString() + " did not match on position " + i + " against "
            + Enums[0].getClass().getName() + "." + Enums[i].toString() + ".");
      }

    public String getPad()
      {
        return _PadderTypeNames.getPad(name());
      }

    public Collection<?> parse(boolean isSet, String[] parts)
    throws Exception
      {
        List<StringStringPair> Errors = new ArrayList<StringStringPair>();
        switch (this)
          {
            case BOOLEAN:
              {
                boolean[] val = ParseUtil.parseBoolean("SQLBooleanArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case CHAR:
              {
                char[] val = ParseUtil.parseCharacter("SQLCharArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case DATETIME:
              {
                ZonedDateTime[] val = ParseUtil.parseZonedDateTime("SQLZonedDateTimeArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case DATE:
              {
                LocalDate[] val = ParseUtil.parseLocalDate("SQLDateArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case DOUBLE:
              {
                double[] val = ParseUtil.parseDouble("SQLDoubleArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case FLOAT:
              {
                float[] val = ParseUtil.parseFloat("SQLFloatArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case SHORT:
              {
                short[] val = ParseUtil.parseShort("SQLShortArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case INTEGER:
              {
                int[] val = ParseUtil.parseInteger("SQLIntegerArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case LONG:
              {
                long[] val = ParseUtil.parseLong("SQLLongArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case NUMERIC:
              {
                BigDecimal[] val = ParseUtil.parseBigDecimal("SQLNumericArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case UUID:
              {
                UUID[] val = ParseUtil.parseUUID("SQLUUIDArray", true, parts, Errors);
                if (Errors.isEmpty() == false)
                  throw new Exception(Errors.get(0)._V);
                return isSet == true ? CollectionUtil.toSet(val) : CollectionUtil.toList(val);
              }
            case JSON:
            case STRING:
              return isSet == true ? CollectionUtil.toSet(parts) : CollectionUtil.toList(parts);
            case BINARY:
            case BITFIELD:
            default:
              throw new Exception("Cannot handle getArray() with a column type '" + this.name() + "'.");
          }
      }

    public boolean isNumber()
      {
        return this == DOUBLE || this == FLOAT || this == INTEGER || this == LONG || this == NUMERIC || this == SHORT;
      }


    public static boolean isNumber(ColumnType Type)
      {
        return Type == null ? false : Type.isNumber();
      }

    /*
     * public String getDefaultNullValue()
     * {
     * switch (this)
     * {
     * case BOOLEAN:
     * return "Boolean.FALSE";
     * case CHAR:
     * return "Character.UNASSIGNED";
     * case DOUBLE:
     * return "Double.valueOf(SystemValues.EVIL_VALUE)";
     * case FLOAT:
     * return "Float.valueOf(SystemValues.EVIL_VALUE)";
     * case INTEGER:
     * return "Integer.valueOf(SystemValues.EVIL_VALUE)";
     * case SHORT:
     * return "Short.valueOf(SystemValues.EVIL_VALUE)";
     * case LONG:
     * return "Long.valueOf(SystemValues.EVIL_VALUE)";
     * case NUMERIC:
     * case DATE:
     * case DATETIME:
     * case UUID:
     * case STRING:
     * case JSON:
     * case BINARY:
     * case BITFIELD:
     * return "null";
     * default:
     * throw new Error("Incomplete switch on ColumnType "+this.name());
     * }
     * }
     */
  }
