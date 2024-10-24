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

package tilda.generation.postgres9;

import tilda.enums.ColumnType;

public enum PostgresType
  {
    /*@formatter:off*/
    STRING  ("varchar"         , "varchar"    , ColumnType.STRING    ),
    JSON    ("jsonb"           , null         , ColumnType.JSON      ),
    VECTOR  ("vector"          , null         , ColumnType.VECTOR    ),
    CHAR    ("character"       , "bpchar"     , ColumnType.CHAR      ),
    SHORT   ("smallint"        , "int2"       , ColumnType.SHORT     ),
    INTEGER ("integer"         , "int4"       , ColumnType.INTEGER   ),
    LONG    ("bigint"          , "int8"       , ColumnType.LONG      ),
    FLOAT   ("real"            , "float4"     , ColumnType.FLOAT     ),
    DOUBLE  ("double precision", "float8"     , ColumnType.DOUBLE    ),
    NUMERIC ("numeric"         , "numeric"    , ColumnType.NUMERIC   ),
    BOOLEAN ("boolean"         , "bool"       , ColumnType.BOOLEAN   ),
    DATE    ("date"            , "date"       , ColumnType.DATE      ),
    DATETIME("timestamptz"     , "timestamptz", ColumnType.DATETIME  ),
    DATETIME_PLAIN("timestamp" , "timestamp"  , ColumnType.DATETIME_PLAIN  ),
    BINARY  ("BYTEA"           , null         , ColumnType.BINARY    ),
    BITFIELD("INTEGER"         , "int4"       , ColumnType.BITFIELD  ),
    UUID    ("UUID"            , "uuid"       , ColumnType.UUID      );
    /*@formatter:on*/

    static
      {
        ColumnType.validate(PostgresType.values(), "PostgresType");
      }

    private PostgresType(String SQLType, String SQLArrayType, ColumnType T)
      {
        _SQLType = SQLType;
        _SQLArrayType = SQLArrayType;
        _T = T;
      }

    public String     _SQLType;
    public String     _SQLArrayType;
    public ColumnType _T;

    public static PostgresType get(ColumnType T)
      {
        for (PostgresType JT : PostgresType.values())
          if (JT._T == T)
            return JT;
        throw new Error("ERROR! Cannot find a " + PostgresType.class.getName() + " matching the  " + ColumnType.class.getName() + " " + T);
      }

  }
