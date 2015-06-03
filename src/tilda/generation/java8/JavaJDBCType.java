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

package tilda.generation.java8;

import tilda.enums.ColumnType;
import tilda.parsing.parts.Column;


public enum JavaJDBCType
  {

    /*@formatter:off*/
    STRING  ("String"       , "String       " , "String   ", "CHAR   "                , ColumnType.STRING  ),
    CHAR    ("char"         , "Character    " , "String   ", "CHAR   "                , ColumnType.CHAR    ),
    INTEGER ("int"          , "Integer      " , "Int      ", "INTEGER"                , ColumnType.INTEGER ),
    LONG    ("long"         , "Long         " , "Long     ", "BIGINT "                , ColumnType.LONG    ),
    FLOAT   ("float"        , "Float        " , "Float    ", "FLOAT  "                , ColumnType.FLOAT   ),
    DOUBLE  ("double"       , "Double       " , "Double   ", "DOUBLE "                , ColumnType.DOUBLE  ),
    BOOLEAN ("boolean"      , "Boolean      " , "Boolean  ", "BOOLEAN"                , ColumnType.BOOLEAN ),
    DATETIME("ZonedDateTime", "ZonedDateTime" , "Timestamp", "TIMESTAMP_WITH_TIMEZONE", ColumnType.DATETIME),
    BINARY  ("byte[]"       , "byte[]       " , "Bytes    ", "BINARY "                , ColumnType.BINARY  ),
    BITFIELD("int"          , "Integer      " , "Int      ", "BIGINT "                , ColumnType.BITFIELD);
    /*@formatter:on*/

    static {
      ColumnType.validate(JavaJDBCType.values());
    }
    
    private JavaJDBCType(String JavaType, String JavaClassType, String JDBCType, String JDBCSQLType, ColumnType T)
      {
        _JavaType = JavaType;
        _JavaClassType = JavaClassType;
        _JDBCType = JDBCType;
        _JDBCSQLType = JDBCSQLType;
        _T = T;
      }

    public String     _JavaType;
    public String     _JavaClassType;
    public String     _JDBCType;
    public String     _JDBCSQLType;
    public ColumnType _T;

    public static JavaJDBCType get(ColumnType T)
      {
        for (JavaJDBCType JT : JavaJDBCType.values())
          if (JT._T == T)
            return JT;
        throw new Error("ERROR! Cannot find a " + JavaJDBCType.class.getName() + " matching the  " + ColumnType.class.getName() + " " + T);
      }
    
    public static String getFieldTypeBase(Column C)
      {
        return JavaJDBCType.get(C._Type)._JavaType;
      }
    
    public static String getFieldTypeBaseClass(Column C)
      {
        return JavaJDBCType.get(C._Type)._JavaClassType;
      }

    public static String getFieldType(Column C)
      {
        switch (C._TypeCollection)
          {
            case LIST:
              return "List<" + JavaJDBCType.get(C._Type)._JavaClassType + ">";
            case NONE:
              return JavaJDBCType.get(C._Type)._JavaType;
            case SET:
              return "Set<" + JavaJDBCType.get(C._Type)._JavaClassType + ">";
            default:
              throw new Error("Unhandled case in switch for type '" + C._TypeCollection + "'.");
          }
      }
  }
