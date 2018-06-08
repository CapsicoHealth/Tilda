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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;

public class ParserSession
  {
    protected static final Logger LOG = LogManager.getLogger(ParserSession.class.getName());

    public ParserSession(Schema Main, CodeGenSql CGSql)
      {
        _Main = Main;
        _CGSql = CGSql;
      }

    public Schema                 _Main;
    public CodeGenSql             _CGSql;
    protected Map<String, Schema> _Dependencies     = new HashMap<String, Schema>();
    protected Set<String>         _ValidatedSchemas = new HashSet<String>();
    protected List<String>        _Errors           = new ArrayList<String>();
    public List<String>           _Notes            = new ArrayList<String>();

    public Iterator<Schema> getDependenciesIterator()
      {
        return _Dependencies.values().iterator();
      }

    public boolean hasDependencies()
      {
        return _Dependencies.isEmpty() == false;
      }

    public boolean addDependencySchema(Schema S)
      {
        return _Dependencies.put(S.getFullName(), S) == null;
      }

    public boolean hasSchemaBeenValidated(Schema S)
      {
        return _ValidatedSchemas.contains(S.getFullName());
      }

    public void addValidatedSchema(Schema S)
      {
        _ValidatedSchemas.add(S.getFullName());
      }

    public Schema getSchema(String PackageName, String SchemaName)
      {
//        Schema.PrintSchemaList(CollectionUtil.toList(_Dependencies.values().iterator()), true);
        String FullName = PackageName + "." + SchemaName;
        Schema S = _Dependencies.get(FullName);
        if (S == null)
          LOG.debug("Schema " + FullName + " cannot be found out of the current schema list ["+getSchemaList()+"].");
        return S;
      }

    public Schema getSchemaForDependency(String PackageName, String SchemaName)
    {
      String FullName = PackageName + "." + SchemaName;
      Schema S = _Dependencies.get(FullName);
      if (S == null)
        LOG.debug("Schema "+ FullName +" has not been found in the schema dependency list.");
      return S;
    }    
    
    public String getSchemaList()
      {
        StringBuilder Str = new StringBuilder();
        for (Schema S : _Dependencies.values())
          {
            if (Str.length() != 0)
              Str.append(", ");
            Str.append(S.getFullName());
          }
        return Str.toString();
      }

    public Object getObject(String PackageName, String SchemaName, String ObjectName)
      {
        Schema S = getSchema(PackageName, SchemaName);
        return S == null ? null : S.getObject(ObjectName);
      }

    public View getView(String PackageName, String SchemaName, String ViewName)
      {
        Schema S = getSchema(PackageName, SchemaName);
        return S == null ? null : S.getView(ViewName);
      }

    public Column getColumn(String PackageName, String SchemaName, String ObjectName, String ColumnName)
      {
        Schema S = getSchema(PackageName, SchemaName);
        return S == null ? null : S.getColumn(ObjectName, ColumnName);
      }

    public boolean AddError(String Err)
      {
        _Errors.add(Err);
        LOG.error("Error #" + _Errors.size() + ": " + Err);
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

    public boolean printErrors()
    {
      LOG.error("==============================================================================================");
      LOG.error("There were " + getErrorCount() + " errors when trying to validate the schema set");
      int i = 0;
      for (String Err : _Errors)
        LOG.error("    " + (++i) + " - " + Err);
      return false;
    }

    public List<String> getNotes()
      {
        return _Notes;
      }

    public int getNoteCount()
      {
        return _Notes.size();
      }

    public boolean AddNote(String Note)
    {
      _Notes.add(Note);
      LOG.info("Note #" + _Notes.size() + ": " + Note);
      return false;
    }
  
    public boolean printNotes()
      {
        
        LOG.info("==============================================================================================");
        LOG.info("There were " + getNoteCount() + " notes when trying to validate the schema set");
        int i = 0;
        for (String Note : _Notes)
          LOG.info("    " + (++i) + " - " + Note);
        return false;
      }
  }
