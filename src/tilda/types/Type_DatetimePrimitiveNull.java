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

package tilda.types;


public class Type_DatetimePrimitiveNull extends Type_DatetimePrimitive implements Nullable
  {
    public Type_DatetimePrimitiveNull(String SchemaName, String TableName, String ColumnName, int Count, String Description)
      {
        this(SchemaName, TableName, ColumnName, Count, Description, null);
      }
    public Type_DatetimePrimitiveNull(String SchemaName, String TableName, String ColumnName, int Count, String Description, Type_StringPrimitive TZCol)
      {
        super(SchemaName, TableName, ColumnName, Count, Description, TZCol);
      }
    
  }
