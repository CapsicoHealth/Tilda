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

import tilda.enums.ColumnType;

public class Type_ShortPrimitive extends ColumnDefinition
  {
    public Type_ShortPrimitive(String SchemaName, String TableName, String ColumnName, int Count, String Description, String[] expressionStrs, String[] expressionsDependencies, String[][] values)
      {
        super(SchemaName, TableName, ColumnName, Count, ColumnType.SHORT, false, Description, expressionStrs, expressionsDependencies, values);
      }
    
  }
