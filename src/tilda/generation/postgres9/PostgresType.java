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
    STRING  ("varchar"         , ColumnType.STRING  ),
    CHAR    ("character"       , ColumnType.CHAR    ),
    INTEGER ("integer"         , ColumnType.INTEGER ),
    LONG    ("bigint"          , ColumnType.LONG    ),
    FLOAT   ("real"            , ColumnType.FLOAT   ),
    DOUBLE  ("double precision", ColumnType.DOUBLE  ),
    BOOLEAN ("boolean"         , ColumnType.BOOLEAN ),
    DATETIME("timestamptz"     , ColumnType.DATETIME),
    BINARY  ("BYTEA"           , ColumnType.BINARY  ),
    BITFIELD("INTEGER"         , ColumnType.BITFIELD);
    /*@formatter:on*/

    static {
      ColumnType.validate(PostgresType.values());
    }
    
    private PostgresType(String SQLType, ColumnType T)
      {
        _SQLType = SQLType;
        _T = T;
      }

    public String     _SQLType;
    public ColumnType _T;

    public static PostgresType get(ColumnType T)
      {
        for (PostgresType JT : PostgresType.values())
          if (JT._T == T)
            return JT;
        throw new Error("ERROR! Cannot find a " + PostgresType.class.getName() + " matching the  " + ColumnType.class.getName() + " " + T);
      }

  }
