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

import java.lang.reflect.Constructor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.enums.ColumnType;

public class ColumnDefinition
  {
    protected static final Logger LOG = LogManager.getLogger(ColumnDefinition.class.getName());

    public ColumnDefinition(String SchemaName, String TableName, String ColumnName, long Count, ColumnType Type, boolean Collection, String Description)
      {
        _SchemaName = SchemaName;
        _TableName = TableName;
        _ColumnName = ColumnName;
        _Type = Type;
        _Collection = Collection;
        _Mask = 1L << Count;
        _Description = Description;
      }

    final String            _SchemaName;
    final String            _TableName;
    final String            _ColumnName;
    final String            _Description;

    public final ColumnType _Type;
    public final boolean    _Collection;
    public final long       _Mask;

    public void getFullColumnVarForSelect(Connection C, StringBuilder Str)
      {
        C.getFullColumnVar(Str, null, _TableName, _ColumnName);
      }

    public void getShortColumnVarForSelect(Connection C, StringBuilder Str)
      {
        C.getFullColumnVar(Str, null, null, _ColumnName);
      }


    public void getFullColumnVarForInsert(Connection C, StringBuilder Str)
      {
        Str.append(",");
        C.getFullColumnVar(Str, null, null, _ColumnName);
      }

    public void getFullColumnVarForUpdate(Connection C, StringBuilder Str)
      {
        Str.append(",");
        C.getFullColumnVar(Str, null, null, _ColumnName);
        Str.append(_Type == ColumnType.JSON ? "=cast(? as jsonb)" : "=?"); // LDH-NOTE: BOOOOO!!!!! HARD-CODED... Won't work on other DBs.. need to clean up!
      }


    public String getName()
      {
        return _ColumnName;
      }

    public static ColumnDefinition Create(String ColumnName, ColumnType Type, boolean Collection, boolean Nullable, String Description)
      {
        return Create(null, null, ColumnName, Type, Collection, Nullable, Description);
      }
    public static ColumnDefinition Create(String TableName, String ColumnName, ColumnType Type, boolean Collection, boolean Nullable, String Description)
      {
        return Create(null, TableName, ColumnName, Type, Collection, Nullable, Description);
      }
    public static ColumnDefinition Create(String SchemaName, String TableName, String ColumnName, ColumnType Type, boolean Collection, boolean Nullable, String Description)
      {
        String ClassName = "tilda.types.Type_" + Type._SimpleName + (Collection == true ? "Collection" : "Primitive") + (Nullable == true ? "Null" : "");
        try
          {
            Class<?> C = Class.forName(ClassName);
            Constructor<?> cons = C.getConstructor(String.class, String.class, String.class, Long.TYPE, String.class);
            return (ColumnDefinition) cons.newInstance(SchemaName, TableName, ColumnName, 0, Description);
          }
        catch (Exception E)
          {
            LOG.error("Cannot instanciate type '" + ClassName + " as a ColumnDefinition descendant with a proper constructor'\n", E);
            return null;
          }

      }
    
  }
