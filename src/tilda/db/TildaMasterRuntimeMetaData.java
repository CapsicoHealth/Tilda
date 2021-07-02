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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.processors.ObjectProcessor;
import tilda.enums.ObjectMode;
import tilda.parsing.parts.Object;

/**
 * <B>LDH-NOTE</B>
 * This class provides runtime meta-data access about all Tilda objects/views currently active in the system. For example, it
 * helps issue an arbitrary select queries, or get runtime columns from objects. Although its main method
 * takes in a String, it is validated against the TildaSQL grammar and will not execute unless it passes parsing + validation.
 * 
 * @author ldh
 *
 */
public class TildaMasterRuntimeMetaData
  {
    protected static final Logger LOG = LogManager.getLogger(TildaMasterRuntimeMetaData.class.getName());

    protected static Map<String, TildaObjectMetaData> _M = new HashMap<String, TildaObjectMetaData>();

    public static TildaObjectMetaData getTableObject(String SchemaName, String TableName)
      {
        if (_M.get(SchemaName.toUpperCase() + "." + TableName) != null)
          return _M.get(SchemaName.toUpperCase() + "." + TableName);
        return null;
      }

    public static String getDefaultCreateValue(String SchemaName, String TableName, String ColumnName)
      {
        TildaObjectMetaData omd = getTableObject(SchemaName, TableName);

        String defaultCreateValue = omd.getColumnDefaultCreateValue(ColumnName);
        if (defaultCreateValue != null)
          return defaultCreateValue;

        LOG.error("No default create value found for " + SchemaName + "." + TableName + "." + ColumnName);
        return null;
      }

    public static String getDefaultUpdateValue(String SchemaName, String TableName, String ColumnName)
      {
        TildaObjectMetaData omd = getTableObject(SchemaName, TableName);

        String defaultUpdateValue = omd.getColumnDefaultUpdateValue(ColumnName);
        if (defaultUpdateValue != null)
          return defaultUpdateValue;

        LOG.error("No default update value found for " + SchemaName + "." + TableName + "." + ColumnName);
        return null;
      }


    public static void register(String PackageName, Object Obj, List<String> warnings)
    throws Exception
      {
        String Key = Obj.getShortName();
        if (_M.get(Key) != null)
          {
            throw new Exception("Trying to register Tilda Object " + Key + " more than once!");
          }

        if (Obj._Mode != ObjectMode.DB_ONLY)
          {
            TildaObjectMetaData OMD = new TildaObjectMetaData(PackageName, Obj, warnings);
            _M.put(Key, OMD);
          }
      }

    public static <T> List<T> lookupWhere(Connection C, Class<T> DataClass, String WhereClause, int Start, int Size)
    throws Exception
      {
        String ObjectName = (String) DataClass.getField("TABLENAME").get(null);
        TildaObjectMetaData OMD = _M.get(ObjectName);
        if (OMD == null)
          {
            LOG.error("Unknown Tilda object " + ObjectName);
            return null;
          }
        SelectQueryParsedAndValidated SQPV = new SelectQueryParsedAndValidated(OMD, WhereClause);
        return SQPV.execute(C, Start, Size);
      }

    public static <T> void lookupWhere(Connection C, Class<T> DataClass, ObjectProcessor<T> OP, String WhereClause, int Start, int Size)
    throws Exception
      {
        String ObjectName = (String) DataClass.getField("TABLENAME").get(null);
        TildaObjectMetaData OMD = _M.get(ObjectName);
        if (OMD == null)
          {
            LOG.error("Unknown Tilda object " + ObjectName);
            return;
          }
        SelectQueryParsedAndValidated SQPV = new SelectQueryParsedAndValidated(OMD, WhereClause);
        SQPV.execute(C, OP, Start, Size);
      }

  }
