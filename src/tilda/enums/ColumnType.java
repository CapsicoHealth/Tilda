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
    STRING         (true , true , false, "STR"  , false),
    JSON           (true , false, false, "JSN"  , false),
    VECTOR         (false, false, false, "VCTR" , false),
    CHAR           (true , true , true , "CHR"  , false),
    SHORT          (true , true , true , "SHT"  , false),
    INTEGER        (true , true , true , "INT"  , false),
    LONG           (true , true , true , "LNG"  , false),
    FLOAT          (true , true , true , "FLT"  , false),
    DOUBLE         (true , true , true , "DBL"  , false),
    NUMERIC        (true , true , false, "NUM"  , false),
    BOOLEAN        (true , true , true , "BOL"  , false),
    DATE           (true , true , false, "DT"   , false),
    /**
     *  All Datetimes are stored as 2 columns in the DB, so SETs are not allowed because they are unordered.<BR>
     *  Datetimes with timezones are stored as TIMESTAMPTZ in UTC and readjusted to ZonedDateTime in the app, and the TZ field
     *  is updated as appropriate during a set.
     */
    DATETIME       (true , false, false, "DTMTZ", false),
    /**
     *  All Datetimes are stored as 2 columns in the DB, so SETs are not allowed because they are unordered.<BR>
     *  Datetimes without timezones (plain) are stored as DATETIME and readjusted to ZonedDateTime in the app based on the stored TZ field which
     *  is then managed explicitly in the app.<BR>
     *  DATETIME_PLAIN is an internal type and is not available in the markup so that datetimes are enforced as being handled uniformly and always
     *  with a timezone. The difference is whether the timezone is baked in the timestamptz or managed manually along with a datetime. The internal
     *  implementation differences are driven by tzMode.
     */
    DATETIME_PLAIN (true , false, false, "DTM"  , true ),
    BINARY         (false, false, false, "BIN"  , false),
    BITFIELD       (false, true , true , "BF"   , false),
    UUID           (true , true , false, "UI"   , false);
    /*@formatter:on*/

    private ColumnType(boolean ArrayCompatible, boolean SetCompatible, boolean Primitive, String shortName, boolean internalOnly)
      {
        _ArrayCompatible = ArrayCompatible;
        _SetCompatible = SetCompatible;
        _Primitive = Primitive;
        _SimpleName = TextUtil.capitalizeFirstCharacter(name().toLowerCase());
        _ShortName = shortName;
        _InternalOnly = internalOnly;
      }

    public static PaddingTracker       _PadderTypeNames = new PaddingTracker();
    public final boolean               _ArrayCompatible;
    public final boolean               _SetCompatible;
    public final boolean               _Primitive;
    public final boolean               _InternalOnly;
    public final String                _SimpleName;
    public final String                _ShortName;
    public final static ColumnType[][] _CompatibleTypes;
    public final static ColumnType[][] _CompatibleDBTypes;


    static
      {
        for (ColumnType T : ColumnType.values())

          _PadderTypeNames.track(T.name());

        _CompatibleTypes = new ColumnType[][] {
            { STRING, JSON, VECTOR, CHAR, INTEGER, LONG, FLOAT, DOUBLE, BOOLEAN, DATE, DATETIME, DATETIME_PLAIN, BITFIELD, SHORT, UUID, NUMERIC
            } // STRING
            , { JSON, STRING
            } // JSON
            , { VECTOR, STRING
            } // VECTOR
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
            , { DATETIME_PLAIN, DATE
            } // DATETIME
            , { BINARY
            } // BINARY
            , { BITFIELD
            } // BITFIELD
            , { UUID, STRING
            } // UUID
        };

        // Whether the first element of each row can be converted to any of the elements following
        _CompatibleDBTypes = new ColumnType[][] {
            { STRING, JSON, VECTOR, CHAR, INTEGER, LONG, FLOAT, DOUBLE, BOOLEAN, DATE, DATETIME, DATETIME_PLAIN, BITFIELD, SHORT, NUMERIC, UUID
            } // STRING
            , { JSON, STRING
            } // JSON
            , { VECTOR, STRING
            } // JSON
            , { CHAR, STRING, BOOLEAN
            } // CHAR
            , { SHORT, BOOLEAN, STRING, INTEGER, LONG, DOUBLE, FLOAT, NUMERIC, BITFIELD
            } // SHORT TODO:CHECK
            , { INTEGER, BOOLEAN, STRING, SHORT, LONG, FLOAT, DOUBLE, NUMERIC, BITFIELD
            } // INTEGER
            , { LONG, STRING, SHORT, INTEGER, FLOAT, DOUBLE, NUMERIC
            } // LONG
            , { FLOAT, STRING, DOUBLE, NUMERIC
            } // FLOAT
            , { DOUBLE, STRING, NUMERIC
            } // DOUBLE
            , { NUMERIC, STRING
            } // NUMERIC TODO:CHECK
            , { BOOLEAN, STRING, DOUBLE, SHORT, INTEGER, LONG, CHAR, FLOAT, DOUBLE
            } // BOOLEAN
            , { DATE, DATETIME, DATETIME_PLAIN, STRING
            } // DATE
            , { DATETIME, STRING
            } // DATETIME
            , { DATETIME_PLAIN, STRING
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
        ColumnType.validate(colsToValidate, "CompatibleTypes");

        ColumnType[] dbColsToValidate = new ColumnType[_CompatibleDBTypes.length];
        for (int i = 0; i < _CompatibleDBTypes.length; i++)
          {
            dbColsToValidate[i] = _CompatibleDBTypes[i][0];
          }
        ColumnType.validate(dbColsToValidate, "CompatibleDBTypes");

      }

//@formatter:off
    protected static String[][] _ALIASES = {{"BIGINT"     , "LONG"    }
                                           ,{"SMALLINT"   , "SHORT"   }
                                           ,{"VARCHAR"    , "STRING"  }
                                           ,{"TEXT"       , "STRING"  }
// Because we want to automate the way date-times are handled uniformly, these aliases break the 
//encapsulation and shouldn't be used. modeTZ is the way.
//                                           ,{"TIMESTAMPTZ", "DATETIME"}
//                                           ,{"DATETIMETZ" , "DATETIME"}
                                           };
//@formatter:on

    public static ColumnType parse(String str)
      {
        if (str == null)
          return null;
        for (String[] alias : _ALIASES)
          if (str.equals(alias[0]) == true)
            {
              str = alias[1];
              break;
            }
        for (ColumnType e : ColumnType.values())
          if (str.equalsIgnoreCase(e.name()) == true)
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

    public static String getCompatibleTypesString(ColumnType Type)
      {
        String compatibleTypes = Type.name();
        for (int i = 0; i < _CompatibleTypes.length; i++)
          if (_CompatibleTypes[i][0] == Type)
            for (int j = 1; j < _CompatibleTypes[i].length; j++)
              compatibleTypes += (compatibleTypes.length() > 0 ? ", " + _CompatibleTypes[i][j].name() : _CompatibleTypes[i][j].name());

        return compatibleTypes;
      }

    public static String getCompatibleDBTypesString(ColumnType Type)
      {
        String compatibleTypes = Type.name();
        for (int i = 0; i < _CompatibleDBTypes.length; i++)
          if (_CompatibleDBTypes[i][0] == Type)
            for (int j = 1; j < _CompatibleDBTypes[i].length; j++)
              compatibleTypes += (compatibleTypes.length() > 0 ? ", " + _CompatibleDBTypes[i][j].name() : _CompatibleDBTypes[i][j].name());

        return compatibleTypes;
      }

    public static <T> void validate(T[] Enums, String typeName)
      {
        ColumnType[] Vals = ColumnType.values();

        if (Vals.length != Enums.length)
          throw new Error("Error! The matching between " + ColumnType.class.getName() + " (" + Vals.length + ") and " + typeName + " (" + Enums.length + ") failed: the counts didn't match.");
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
            case DATETIME_PLAIN:
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

    public String getBigQueryType()
      {
        switch (this)
          {
            case STRING:
            case CHAR:
            case UUID:
              return "STRING";
            case BOOLEAN:
              return "BOOL";
            case DOUBLE:
            case FLOAT:
              return "FLOAT64";
            case SHORT:
            case INTEGER:
            case LONG:
              return "INT64";
            case NUMERIC:
              return "NUMERIC";
            case DATE:
              return "DATE";
            case DATETIME:
              return "TIMESTAMP";
            case DATETIME_PLAIN:
              return "DATETIME";
            case JSON:
              return "STRING";
            case BINARY:
            case BITFIELD:
              return "BYTES";
            default:
              throw new Error("Incomplete switch in getBigQueryType() on ColumnType " + this.name());
          }
      }

    public int getSQLType()
      {
        switch (this)
          {
            case STRING:
            case CHAR:
            case UUID:
            case JSON:
              return java.sql.Types.VARCHAR;
            case BOOLEAN:
              return java.sql.Types.BOOLEAN;
            case DOUBLE:
              return java.sql.Types.DOUBLE;
            case FLOAT:
              return java.sql.Types.FLOAT;
            case SHORT:
              return java.sql.Types.SMALLINT;
            case INTEGER:
              return java.sql.Types.INTEGER;
            case LONG:
              return java.sql.Types.BIGINT;
            case NUMERIC:
              return java.sql.Types.NUMERIC;
            case DATE:
              return java.sql.Types.DATE;
            case DATETIME:
              return java.sql.Types.TIMESTAMP_WITH_TIMEZONE;
            case DATETIME_PLAIN:
              return java.sql.Types.TIMESTAMP;
            case BINARY:
              return java.sql.Types.VARBINARY;
            case BITFIELD:
              return java.sql.Types.BINARY;
            default:
              throw new Error("Incomplete switch in getSQLType() on ColumnType " + this.name());
          }
      }

    public String getMappedName()
      {
        return name();
      }

  }
