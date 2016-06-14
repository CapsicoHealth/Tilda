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

import tilda.enums.ColumnMode;
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
        protected ObjectMetaData(String PackageName, Object Obj) throws Exception
          {
            String FactoryClassName = Helper.getFullBaseClassName(Obj) + "_Factory";
            _FactoryClass = Class.forName(FactoryClassName);
            
            _ObjectName = Obj.getShortName();

            String ColsClassName = Helper.getFullBaseClassName(Obj) + "_Factory$COLS";
            Class<?> _ColsClass = Class.forName(ColsClassName);

            for (Column C : Obj._Columns)
              if (C != null && C._FrameworkManaged == false && C._Mode != ColumnMode.CALCULATED)
                {
                  Field F = _ColsClass.getDeclaredField(C.getName().toUpperCase());
                  ColumnDefinition CD = (ColumnDefinition) F.get(null);
                  _Cols.add(CD);
                }

            _RunSelectMethod = _FactoryClass.getMethod("runSelect", Connection.class, SelectQuery.class, Integer.TYPE, Integer.TYPE);
          }
        public final String   _ObjectName;
        public final Class<?> _FactoryClass;
        public final Method   _RunSelectMethod;
        public final List<ColumnDefinition> _Cols = new ArrayList<ColumnDefinition>();
      }

    protected static Map<String, ObjectMetaData> _M = new HashMap<String, ObjectMetaData>();

    public static void register(String PackageName, Object Obj)
    throws Exception
      {
        String Key = Obj.getShortName();
        if (_M.get(Key) != null)
          throw new Exception("Trying to register Tilda Object " + Key + " more than once!");

        ObjectMetaData OMD = new ObjectMetaData(PackageName, Obj);
        _M.put(Key, OMD);
      }

    public static List<?> LookupWhere(Connection C, String ObjectName, String WhereClause, int Start, int Size) throws Exception
      {
        ObjectMetaData OMD = _M.get(ObjectName);
        if (OMD == null)
         {
           LOG.error("Unknown Tilda object "+ObjectName);
           return null;
         }
        SelectQueryParsedAndValidated SQPV = new SelectQueryParsedAndValidated(OMD, WhereClause);
        return SQPV.execute(C, Start, Size);
      }
  }
