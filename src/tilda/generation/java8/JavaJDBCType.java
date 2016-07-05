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

import java.time.ZonedDateTime;

import tilda.enums.ColumnType;
import tilda.parsing.parts.Column;


public enum JavaJDBCType
  {

    /*@formatter:off*/
    STRING  ("String"       , String.class       , "String   ", "CHAR   "                , ColumnType.STRING  ),
    JSON    ("String"       , String.class       , "String   ", "CHAR   "                , ColumnType.JSON    ),
    CHAR    ("char"         , Character.class    , "String   ", "CHAR   "                , ColumnType.CHAR    ),
    INTEGER ("int"          , Integer.class      , "Int      ", "INTEGER"                , ColumnType.INTEGER ),
    LONG    ("long"         , Long.class         , "Long     ", "BIGINT "                , ColumnType.LONG    ),
    FLOAT   ("float"        , Float.class        , "Float    ", "FLOAT  "                , ColumnType.FLOAT   ),
    DOUBLE  ("double"       , Double.class       , "Double   ", "DOUBLE "                , ColumnType.DOUBLE  ),
    BOOLEAN ("boolean"      , Boolean.class      , "Boolean  ", "BOOLEAN"                , ColumnType.BOOLEAN ),
    DATETIME("ZonedDateTime", ZonedDateTime.class, "Timestamp", "TIMESTAMP_WITH_TIMEZONE", ColumnType.DATETIME),
    BINARY  ("byte[]"       , byte[].class       , "Bytes    ", "BINARY "                , ColumnType.BINARY  ),
    BITFIELD("int"          , Integer.class      , "Int      ", "BIGINT "                , ColumnType.BITFIELD);
    /*@formatter:on*/

    static {
      ColumnType.validate(JavaJDBCType.values());
    }
    
    private JavaJDBCType(String JavaType, Class<?> JavaClassClass, String JDBCType, String JDBCSQLType, ColumnType T)
      {
        _JavaType = JavaType;
        _JavaClassClass = JavaClassClass;
        _JavaClassType = JavaClassClass.getSimpleName();
        _JDBCType = JDBCType;
        _JDBCSQLType = JDBCSQLType;
        _T = T;
      }

    public String     _JavaType;
    public Class<?>   _JavaClassClass;
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
        return getFieldTypeBaseClass(C._Type);
      }
    public static String getFieldTypeBaseClass(ColumnType T)
      {
        return JavaJDBCType.get(T)._JavaClassType;
      }
    public static Class<?> getFieldTypeBaseClassClass(ColumnType T)
      {
        return JavaJDBCType.get(T)._JavaClassClass;
      }
    

    public static String getFieldTypeParam(Column C, boolean Multi)
      {
        return  JavaJDBCType.get(C._Type)._JavaType + (Multi==true?"[]":"");
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
              return "Set <" + JavaJDBCType.get(C._Type)._JavaClassType + ">";
            default:
              throw new Error("Unhandled case in switch for type '" + C._TypeCollection + "'.");
          }
      }
  }
