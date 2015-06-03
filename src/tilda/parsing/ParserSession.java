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

package tilda.parsing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;

public class ParserSession
  {
    protected static final Logger LOG = LogManager.getLogger(ParserSession.class.getName());

    public ParserSession(Schema Main, CodeGenSql CGSql)
      {
        _Main = Main;
        _CGSql = CGSql;
      }

    public Schema          _Main;
    public CodeGenSql      _CGSql;
    protected List<Schema> _Dependencies     = new ArrayList<Schema>();
    protected Set<String>  _ValidatedSchemas = new HashSet<String>();
    protected List<String> _Errors           = new ArrayList<String>();


    public Schema getDependency(String PackageName, String SchemaName)
      {
        String FullName = PackageName+"."+SchemaName;
        for (Schema S : _Dependencies)
         if (S.getFullName().equalsIgnoreCase(FullName) == true)
          return S;
        return null;
      }

    public void addDependency(Schema D)
      {
        Schema S = getDependency(D._Package, D._Name);
        if (S == null)
         _Dependencies.add(D);
      }

    public Iterator<Schema> getDependencies()
      {
        return _Dependencies.iterator();
      }

    public boolean hasDependencies()
     {
       return _Dependencies.isEmpty()==false;
     }



    public boolean hasSchemaBeenValidated(Schema S)
      {
        return _ValidatedSchemas.contains(S.getFullName());
      }

    public void ValidateSchema(Schema S)
      {
        _ValidatedSchemas.add(S.getFullName());
      }

    public Schema getSchema(String PackageName, String SchemaName)
      {
        return getDependency(PackageName, SchemaName);
      }

    public Object getObject(String PackageName, String SchemaName, String ObjectName)
      {
        Schema S = getSchema(PackageName, SchemaName);
        return S == null ? null : S.getObject(ObjectName);
      }

    public Column getColumn(String PackageName, String SchemaName, String ObjectName, String ColumnName)
      {
        Schema S = getSchema(PackageName, SchemaName);
        return S == null ? null : S.getColumn(ObjectName, ColumnName);
      }

    public boolean AddError(String Err)
      {
        _Errors.add(Err);
        LOG.error("Error #"+_Errors.size()+": "+Err);
        return false;
      }

    public List<String> getErrors()
      {
        return _Errors;
      }
    
    public int getErrorCount()
    {
      return _Errors.size();
    }
    

  }
