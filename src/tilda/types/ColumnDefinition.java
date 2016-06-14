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

import tilda.enums.ColumnType;
import tilda.enums.StatementType;

public class ColumnDefinition
  {
    protected static final Logger LOG = LogManager.getLogger(ColumnDefinition.class.getName());

    public ColumnDefinition(String TableName, String ColumnName, long Count, ColumnType Type, boolean Collection)
      {
        _TableName = TableName;
        _ColumnName = ColumnName;
        _Short = "\"" + ColumnName + "\"";
        _Full = TableName + "." + _Short;
        _Insert = ", " + _Short;
        _Update = ", " + _Short + "=?";
        _Type = Type;
        _Collection = Collection;
        _Mask = 1L << Count;
      }

    final String            _TableName;
    final String            _Full;
    final String            _Short;
    final String            _ColumnName;

    public final String     _Insert;
    public final String     _Update;

    public final ColumnType _Type;
    public final boolean    _Collection;
    public final long       _Mask;

    public final String toString()
      {
        return _Short;
      }

    public final String toString(StatementType ST)
      {
        return ST == StatementType.SELECT ? _Full : _Short;
      }

    public String getName()
      {
        return _ColumnName;
      }

    public static ColumnDefinition Create(String Name, String BaseType, boolean Collection, boolean Nullable)
      {
        String ClassName = "tilda.types.Type_" + BaseType + (Collection == true ? "Collection" : "Primitive") + (Nullable == true ? "Null" : "");
        try
          {
            Class<?> C = Class.forName(ClassName);
            Constructor<?> cons = C.getConstructor(String.class, String.class, Long.TYPE );
            return (ColumnDefinition) cons.newInstance("?", Name, 0);
          }
        catch (Exception E)
          {
            LOG.error("Cannot instanciate type '" + ClassName + " as a ColumnDefinition descendant with a proper constructor'\n", E);
            return null;
          }
      }
  }
