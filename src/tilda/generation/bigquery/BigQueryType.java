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

package tilda.generation.bigquery;

import tilda.enums.ColumnType;

public enum BigQueryType
  {
    /*@formatter:off*/
    STRING  ("STRING"          , "STRING"     , ColumnType.STRING    ),
    JSON    ("JSON"            , null         , ColumnType.JSON      ),
    CHAR    ("STRING"          , "STRING"     , ColumnType.CHAR      ),
    SHORT   ("INT64"           , "INT64"      , ColumnType.SHORT     ),
    INTEGER ("INT64"           , "INT64"      , ColumnType.INTEGER   ),
    LONG    ("INT64"           , "INT64"      , ColumnType.LONG      ),
    FLOAT   ("FLOAT64"         , "FLOAT64"    , ColumnType.FLOAT     ),
    DOUBLE  ("FLOAT64"         , "FLOAT64"    , ColumnType.DOUBLE    ),
    NUMERIC ("NUMERIC"         , "NUMERIC"    , ColumnType.NUMERIC   ),
    BOOLEAN ("BOOLEAN"         , "BOOLEAN"    , ColumnType.BOOLEAN   ),
    DATE    ("DATE"            , "DATE"       , ColumnType.DATE      ),
    DATETIME("TIMESTAMP"       , "TIMESTAMP"  , ColumnType.DATETIME  ),
    BINARY  ("BYTES"           , null         , ColumnType.BINARY    ),
    BITFIELD("INT64"           , "INT64"      , ColumnType.BITFIELD  ),
    UUID    ("STRING"          , "STRING"     , ColumnType.UUID      );
    /*@formatter:on*/

    static
      {
        ColumnType.validate(BigQueryType.values());
      }

    private BigQueryType(String SQLType, String SQLArrayType, ColumnType T)
      {
        _SQLType = SQLType;
        _SQLArrayType = SQLArrayType;
        _T = T;
      }

    public String     _SQLType;
    public String     _SQLArrayType;
    public ColumnType _T;

    public static BigQueryType get(ColumnType T)
      {
        for (BigQueryType BQT : BigQueryType.values())
          if (BQT._T == T)
            return BQT;
        throw new Error("ERROR! Cannot find a " + BigQueryType.class.getName() + " matching the  " + ColumnType.class.getName() + " " + T);
      }

  }
