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

import java.time.LocalDate;
import java.time.ZonedDateTime;

import tilda.enums.ColumnType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.JsonField;


public enum JavaJDBCType
  {

    /*@formatter:off*/
    STRING    ("String"       , String.class       , "String    ", "CHAR      "             , ColumnType.STRING  ),
    JSON      ("String"       , String.class       , "String    ", "CHAR      "             , ColumnType.JSON    ),
    CHAR      ("char"         , Character.class    , "String    ", "CHAR      "             , ColumnType.CHAR    ),
    SHORT     ("short"        , Short.class        , "Short     ", "SMALLINT  "             , ColumnType.SHORT   ),
    INTEGER   ("int"          , Integer.class      , "Int       ", "INTEGER   "             , ColumnType.INTEGER ),
    LONG      ("long"         , Long.class         , "Long      ", "BIGINT    "             , ColumnType.LONG    ),
    FLOAT     ("float"        , Float.class        , "Float     ", "FLOAT     "             , ColumnType.FLOAT   ),
    DOUBLE    ("double"       , Double.class       , "Double    ", "DOUBLE    "             , ColumnType.DOUBLE  ),
    BIGDECIMAL("BigDecimal"   , Math.class         , "BigDecimal", "BIGDECIMAL"             , ColumnType.BIGDECIMAL  ),
    BOOLEAN   ("boolean"      , Boolean.class      , "Boolean   ", "BOOLEAN   "             , ColumnType.BOOLEAN ),
    DATE      ("LocalDate"    , LocalDate.class    , "Date      ", "DATE"                   , ColumnType.DATE    ),
    DATETIME  ("ZonedDateTime", ZonedDateTime.class, "Timestamp ", "TIMESTAMP_WITH_TIMEZONE", ColumnType.DATETIME),
    BINARY    ("byte[]"       , byte[].class       , "Bytes     ", "BINARY    "             , ColumnType.BINARY  ),
    BITFIELD  ("int"          , Integer.class      , "Int       ", "BIGINT    "             , ColumnType.BITFIELD);
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
        return JavaJDBCType.get(C.getType())._JavaType;
      }
    
    public static String getFieldTypeBaseClass(Column C)
      {
        return getFieldTypeBaseClass(C.getType());
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
        return  JavaJDBCType.get(C.getType())._JavaType + (Multi==true?"[]":"");
      }
    public static String getFieldType(Column C)
      {
        switch (C.getTypeCollection())
          {
            case LIST:
              return "List<" + JavaJDBCType.get(C.getType())._JavaClassType + ">";
            case NONE:
              return JavaJDBCType.get(C.getType())._JavaType;
            case SET:
              return "Set <" + JavaJDBCType.get(C.getType())._JavaClassType + ">";
            default:
              throw new Error("Unhandled case in switch for ield type '" + C.getTypeCollection() + "'.");
          }
      }
    
    public static String getJsonFieldType(JsonField F)
      {
        switch (F.getTypeCollection())
          {
            case LIST:
            case SET:
              return JavaJDBCType.get(F.getType())._JavaClassType + "[]";
            case NONE:
              return JavaJDBCType.get(F.getType())._JavaType;
            default:
              throw new Error("Unhandled case in switch for json field type '" + F.getTypeCollection() + "'.");
          }
      }
    
  }
