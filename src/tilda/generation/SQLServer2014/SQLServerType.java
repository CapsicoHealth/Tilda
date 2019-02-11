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

package tilda.generation.SQLServer2014;

import tilda.enums.ColumnType;

public enum SQLServerType
  {
    /*@formatter:off*/
    STRING  ("nvarchar"        , "nvarchar", ColumnType.STRING  ),
    JSON    ("nvarchar(max)"   , null      , ColumnType.JSON    ),
    CHAR    ("character"       , "nvarchar", ColumnType.CHAR    ),
    SHORT   ("smallint"        , "varchar" , ColumnType.SHORT   ),
    INTEGER ("integer"         , "varchar" , ColumnType.INTEGER ),
    LONG    ("bigint"          , "varchar" , ColumnType.LONG    ),
    FLOAT   ("real"            , "varchar" , ColumnType.FLOAT   ),
    DOUBLE  ("double precision", "varchar" , ColumnType.DOUBLE  ),
    BOOLEAN ("bit"             , "integer" , ColumnType.BOOLEAN ),
    DATE    ("date"            , null      , ColumnType.DATE    ),
    DATETIME("datetimeoffset"  , null      , ColumnType.DATETIME),
    BINARY  ("varbinary"       , null      , ColumnType.BINARY  ),
    BITFIELD("integer"         , null      , ColumnType.BITFIELD);
    /*@formatter:on*/

    static {
      ColumnType.validate(SQLServerType.values());
    }
    
    private SQLServerType(String SQLType, String SQLArrayType, ColumnType T)
      {
        _SQLType = SQLType;
        _SQLArrayType = SQLArrayType;
        _T = T;
      }

    public String     _SQLType;
    public String     _SQLArrayType;
    public ColumnType _T;

    public static SQLServerType get(ColumnType T)
      {
        for (SQLServerType JT : SQLServerType.values())
          if (JT._T == T)
            return JT;
        throw new Error("ERROR! Cannot find a " + SQLServerType.class.getName() + " matching the  " + ColumnType.class.getName() + " " + T);
      }

  }
