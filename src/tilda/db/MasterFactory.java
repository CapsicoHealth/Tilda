/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
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

package tilda.db;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.processors.ObjectProcessor;
import tilda.enums.ColumnMode;
import tilda.enums.ObjectMode;
import tilda.generation.java8.Helper;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.types.ColumnDefinition;

/**
 * <B>LDH-NOTE</B>
 * This class helps issue an arbitrary select query against any object currently active in the system. Although its main method
 * takes in a String, it is validated against the TildaSQL grammar and will not execute unless it passes parsing + validation.
 * 
 * @author ldh
 *
 */
public class MasterFactory
  {
    protected static final Logger LOG = LogManager.getLogger(MasterFactory.class.getName());

    static class ObjectMetaData
      {
        protected ObjectMetaData(String PackageName, Object Obj, List<String> WarningList)
          throws Exception
          {
            _Obj = Obj;

            String FactoryClassName = Helper.getFullBaseClassName(Obj) + "_Factory";
            _FactoryClass = Class.forName(FactoryClassName);

            _ObjectName = Obj.getShortName();

            String ColsClassName = Helper.getFullBaseClassName(Obj) + "_Factory$COLS";
            Class<?> _ColsClass = Class.forName(ColsClassName);

            for (Column C : Obj._Columns)
              if (C != null && C._FCT.isManaged() == false && C._Mode != ColumnMode.CALCULATED)
                {
                  try
                    {
                      Field F = _ColsClass.getDeclaredField(C.getName().toUpperCase());
                      ColumnDefinition CD = (ColumnDefinition) F.get(null);
                      _Cols.add(CD);
                    }
                  catch (Exception E)
                    {
                      LOG.warn("Field "+C.getFullName()+" cannot seem to be resolved from the current binaries. Possibly, someone forgot to Gen?\n", E);
                      WarningList.add("Field "+C.getFullName()+" cannot seem to be resolved from the current binaries. Possibly, someone forgot to Gen?");
                    }
                }

            _RunSelectMethodList = _FactoryClass.getMethod("runSelect", Connection.class, SelectQuery.class, Integer.TYPE, Integer.TYPE);
            _RunSelectMethodOP = _FactoryClass.getMethod("runSelect", Connection.class, SelectQuery.class, ObjectProcessor.class, Integer.TYPE, Integer.TYPE);
          }

        protected final Object              _Obj;
        public final String                 _ObjectName;
        public final Class<?>               _FactoryClass;
        public final Method                 _RunSelectMethodList;
        public final Method                 _RunSelectMethodOP;
        public final List<ColumnDefinition> _Cols = new ArrayList<ColumnDefinition>();

        public String getColumnDefaultCreateValue(String columnName)
          {
            Column Col = _Obj.getColumn(columnName);
            if (Col != null && Col._DefaultCreateValue != null)
              return Col._DefaultCreateValue._Value;
            return null;
          }

        public String getColumnDefaultUpdateValue(String columnName)
          {
            Column Col = _Obj.getColumn(columnName);
            if (Col != null && Col._DefaultUpdateValue != null)
              return Col._DefaultUpdateValue._Value;
            return null;
          }

      }

    protected static Map<String, ObjectMetaData> _M = new HashMap<String, ObjectMetaData>();

    public static ObjectMetaData GetTableObject(String SchemaName, String TableName)
      {
        if (_M.get(SchemaName.toUpperCase() + "." + TableName) != null)
          return _M.get(SchemaName.toUpperCase() + "." + TableName);
        return null;
      }

    public static String GetDefaultCreateValue(String SchemaName, String TableName, String ColumnName)
      {
        ObjectMetaData omd = GetTableObject(SchemaName, TableName);

        String defaultCreateValue = omd.getColumnDefaultCreateValue(ColumnName);
        if (defaultCreateValue != null)
          return defaultCreateValue;

        LOG.error("No default create value found for " + SchemaName + "." + TableName + "." + ColumnName);
        return null;
      }

    public static String GetDefaultUpdateValue(String SchemaName, String TableName, String ColumnName)
      {
        ObjectMetaData omd = GetTableObject(SchemaName, TableName);

        String defaultUpdateValue = omd.getColumnDefaultUpdateValue(ColumnName);
        if (defaultUpdateValue != null)
          return defaultUpdateValue;

        LOG.error("No default update value found for " + SchemaName + "." + TableName + "." + ColumnName);
        return null;
      }


    public static void register(String PackageName, Object Obj, List<String> WarningList)
    throws Exception
      {
        String Key = Obj.getShortName();
        if (_M.get(Key) != null)
          {
            throw new Exception("Trying to register Tilda Object " + Key + " more than once!");
          }

        if (Obj._Mode != ObjectMode.DB_ONLY)
          {
            ObjectMetaData OMD = new ObjectMetaData(PackageName, Obj, WarningList);
            _M.put(Key, OMD);
          }
      }

    public static <T> List<T> LookupWhere(Connection C, Class<T> DataClass, String WhereClause, int Start, int Size)
    throws Exception
      {
        String ObjectName = (String) DataClass.getField("TABLENAME").get(null);
        ObjectMetaData OMD = _M.get(ObjectName);
        if (OMD == null)
          {
            LOG.error("Unknown Tilda object " + ObjectName);
            return null;
          }
        SelectQueryParsedAndValidated SQPV = new SelectQueryParsedAndValidated(OMD, WhereClause);
        return SQPV.execute(C, Start, Size);
      }

    public static <T> void LookupWhere(Connection C, Class<T> DataClass, ObjectProcessor<T> OP, String WhereClause, int Start, int Size)
    throws Exception
      {
        String ObjectName = (String) DataClass.getField("TABLENAME").get(null);
        ObjectMetaData OMD = _M.get(ObjectName);
        if (OMD == null)
          {
            LOG.error("Unknown Tilda object " + ObjectName);
            return;
          }
        SelectQueryParsedAndValidated SQPV = new SelectQueryParsedAndValidated(OMD, WhereClause);
        SQPV.execute(C, OP, Start, Size);
      }

  }
