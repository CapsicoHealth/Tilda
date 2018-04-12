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
import tilda.enums.ColumnMode;
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
        if (Count < 64)
          {
            _MaskId = 1;
            _Mask1 = 1L << Count;
            _Mask2 = 0;
            _Mask3 = 0;
            _Mask4 = 0;
            _Mask5 = 0;
            _Mask6 = 0;
          }
        else if (Count < 64*2)
          {
            _MaskId = 2;
            _Mask1 = 0;
            _Mask2 = 1L << Count;
            _Mask3 = 0;
            _Mask4 = 0;
            _Mask5 = 0;
            _Mask6 = 0;
          }
        else if (Count < 64*3)
          {
            _MaskId = 3;
            _Mask1 = 0;
            _Mask2 = 0;
            _Mask3 = 1L << Count;
            _Mask4 = 0;
            _Mask5 = 0;
            _Mask6 = 0;
          }
        else if (Count < 64*4)
          {
            _MaskId = 4;
            _Mask1 = 0;
            _Mask2 = 0;
            _Mask3 = 0;
            _Mask4 = 1L << Count;
            _Mask5 = 0;
            _Mask6 = 0;
          }
        else if (Count < 64*5)
          {
            _MaskId = 5;
            _Mask1 = 0;
            _Mask2 = 0;
            _Mask3 = 0;
            _Mask4 = 0;
            _Mask5 = 1L << Count;
            _Mask6 = 0;
          }
        else if (Count < 64*6)
          {
            _MaskId = 6;
            _Mask1 = 0;
            _Mask2 = 0;
            _Mask3 = 0;
            _Mask4 = 0;
            _Mask5 = 0;
            _Mask6 = 1L << Count;
          }
        else
          {
            throw new Error("Trying to instanciate a column that requires a _Mask with more than 192 bits.");
          }
        _Description = Description;
      }

    final String            _SchemaName;
    final String            _TableName;
    final String            _ColumnName;
    final String            _Description;

    public final ColumnType _Type;
    public final boolean    _Collection;
    public final int        _MaskId;  
    public final long       _Mask1;
    public final long       _Mask2;
    public final long       _Mask3;
    public final long       _Mask4;
    public final long       _Mask5;
    public final long       _Mask6;
    
    public String getSchemaName()
      {
        return _SchemaName;
      }

    public String getTableName()
      {
        return _TableName;
      }

    public void getFullColumnVarForSelect(Connection C, StringBuilder Str)
      {
        C.getFullColumnVar(Str, null, _TableName, _ColumnName);
      }
    public String getFullColumnVarForSelect(Connection C)
      {
        StringBuilder Str = new StringBuilder();
        getFullColumnVarForSelect(C, Str);
        return Str.toString();
      }

    public void getShortColumnVarForSelect(Connection C, StringBuilder Str)
      {
        C.getFullColumnVar(Str, null, null, _ColumnName);
      }
    public String getShortColumnVarForSelect(Connection C)
      {
        StringBuilder Str = new StringBuilder();
        C.getFullColumnVar(Str, null, null, _ColumnName);
        return Str.toString();
      }
    
    
    public void getColumnType(Connection C, StringBuilder Str, ColumnType T, Integer S, ColumnMode M, boolean Collection)
      {
        C.getColumnType(Str, T, S, M, Collection);
      }
    public String getColumnType(Connection C, ColumnType T, Integer S, ColumnMode M, boolean Collection)
      {
        StringBuilder Str = new StringBuilder();
        getColumnType(C, Str, T, S, M, Collection);
        return Str.toString();
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
    
    public boolean isNullable()
     {
       return this instanceof Nullable;
     }

//    public static ColumnDefinition Create(String ColumnName, ColumnType Type, boolean Collection, boolean Nullable, String Description)
//      {
//        return Create(null, null, ColumnName, Type, Collection, Nullable, Description);
//      }

//    public static ColumnDefinition Create(String TableName, String ColumnName, ColumnType Type, boolean Collection, boolean Nullable, String Description)
//      {
//        return Create(null, TableName, ColumnName, Type, Collection, Nullable, Description);
//      }

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
