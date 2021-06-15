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

import java.io.Writer;
import java.lang.reflect.Constructor;
import java.time.ZonedDateTime;
import java.util.BitSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.Connection;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.interfaces.JSONable;
import tilda.utils.TextUtil;
import tilda.utils.json.JSONUtil;

public class ColumnDefinition implements JSONable
  {
    protected static final Logger LOG = LogManager.getLogger(ColumnDefinition.class.getName());

    public ColumnDefinition(String SchemaName, String TableName, String ColumnName, int Count, ColumnType Type, boolean Collection, String Description, String[] expressionStrs, String[] expressionDependencyColumnNames)
      {
        _SchemaName = SchemaName;
        _TableName = TableName;
        _ColumnName = ColumnName;
        _Type = Type;
        _Collection = Collection;
        _Mask.set(Count);
        if (Count > _MAX_COL_COUNT)
          throw new Error("Trying to instanciate a column that requires a _Mask with more than " + _MAX_COL_COUNT + " bits.");
        _Description = Description;
        _expressionStrs = expressionStrs;
        _expressionDependencyColumnNames = expressionDependencyColumnNames;
      }

    public static final int _MAX_COL_COUNT = 512;

    final String            _SchemaName;
    final String            _TableName;
    final String            _ColumnName;
    final String            _Description;
    final String[]          _expressionStrs;
    final String[]          _expressionDependencyColumnNames;
    final ColumnType        _Type;
    final boolean           _Collection;
    public final BitSet     _Mask          = new BitSet(64);

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


    public void getColumnType(Connection C, StringBuilder Str, ColumnType T, Integer S, ColumnMode M, boolean Collection, Integer Precision, Integer Scale)
      {
        C.getColumnType(Str, T, S, M, Collection, Precision, Scale);
      }

    public String getColumnType(Connection C, ColumnType T, Integer S, ColumnMode M, boolean Collection, Integer Precision, Integer Scale)
      {
        StringBuilder Str = new StringBuilder();
        getColumnType(C, Str, T, S, M, Collection, Precision, Scale);
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

    public ColumnType getType()
      {
        return _Type;
      }

    public boolean isNullable()
      {
        return this instanceof Nullable;
      }

    public boolean isCollection()
      {
        return _Collection;
      }

    public String getDescription()
      {
        return _Description;
      }

    public String[] getExpression()
      {
        return _expressionStrs;
      }

    public String[] getExpressionDependencies()
      {
        return _expressionDependencyColumnNames;
      }

    public static ColumnDefinition create(String SchemaName, String TableName, String ColumnName, ColumnType Type, boolean Collection, boolean Nullable, String Description)
      {
        String ClassName = "tilda.types.Type_" + Type._SimpleName + (Collection == true ? "Collection" : "Primitive") + (Nullable == true ? "Null" : "");
        try
          {
            Class<?> C = Class.forName(ClassName);
            Constructor<?> cons = C.getConstructor(String.class, String.class, String.class, Integer.TYPE, String.class, String[].class, String[].class);
            return (ColumnDefinition) cons.newInstance(SchemaName, TableName, ColumnName, 0, Description, null, null);
          }
        catch (Exception E)
          {
            LOG.error("Cannot instanciate type '" + ClassName + " as a ColumnDefinition descendant with a proper constructor'\n", E);
            return null;
          }
      }

    public static String printColumns(Connection C, ColumnDefinition[] A, boolean shortName, String templateStr)
      {
        StringBuilder Str = new StringBuilder();
        printColumns(C, A, shortName, templateStr, Str);
        return Str.toString();
      }

    /*
     * Returns a string that includes a comma-separated list of column names in short of long (with the table name) form.
     * If templateStr is provided, all instances of the character '?' will be replaced with the column name.
     */
    public static void printColumns(Connection C, ColumnDefinition[] A, boolean shortName, String templateStr, StringBuilder Str)
      {
        boolean First = true;
        if (A == null || A.length == 0)
          return;

        // Two implementations depending on whether we have the templateStr or not. Without it, the method is quite faster.
        if (TextUtil.isNullOrEmpty(templateStr) == true)
          for (ColumnDefinition cd : A)
            {
              if (First == true)
                First = false;
              else
                Str.append(", ");
              if (shortName == true)
                cd.getShortColumnVarForSelect(C, Str);
              else
                cd.getFullColumnVarForSelect(C, Str);
            }
        else
          for (ColumnDefinition cd : A)
            {
              if (First == true)
                First = false;
              else
                Str.append(", ");
              String Name = shortName == true ? cd.getShortColumnVarForSelect(C) : cd.getFullColumnVarForSelect(C);
              Str.append(templateStr.replaceAll("\\?", Name));
            }

      }

    public static String[] getColumnNames(ColumnDefinition[] A)
      {
        if (A == null)
          return null;

        String[] Names = new String[A.length];

        for (int i = 0; i < A.length; ++i)
          Names[i] = A[i]._ColumnName;

        return Names;
      }

    @Override
    public void toJSON(Writer out, String jsonExportName, String lead, boolean fullObject)
    throws Exception
      {
        toJSON(out, jsonExportName, lead, fullObject, false);
      }

    @Override
    public void toJSON(Writer out, String jsonExportName, String lead, boolean fullObject, ZonedDateTime lastsync)
    throws Exception
      {
        toJSON(out, jsonExportName, lead, fullObject, false);
      }

    @Override
    public void toJSON(Writer out, String jsonExportName, String lead, boolean fullObject, boolean noNullArrays)
    throws Exception
      {
        if (fullObject == true)
          {
            out.write(lead);
            out.write("{");
          }

        int i = -1;
        JSONUtil.print(out, "schemaName", ++i == 0, getSchemaName());
        JSONUtil.print(out, "tableName", ++i == 0, getTableName());
        JSONUtil.print(out, "columnName", ++i == 0, getName());
        JSONUtil.print(out, "nullable", ++i == 0, isNullable());
        JSONUtil.print(out, "collection", ++i == 0, isCollection());
        JSONUtil.print(out, "type", ++i == 0, getType().name());
        JSONUtil.print(out, "description", ++i == 0, getDescription());
        JSONUtil.print(out, "formula", ++i == 0, getExpression());

        if (fullObject == true)
          out.write(" }\n");
      }
  }
