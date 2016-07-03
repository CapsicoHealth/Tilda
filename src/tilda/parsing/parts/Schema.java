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

package tilda.parsing.parts;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.ParserSession;

import com.google.gson.annotations.SerializedName;

public class Schema
  {
    protected static final Logger  LOG                = LogManager.getLogger(Schema.class.getName());

    /*@formatter:off*/
    @SerializedName("package"      ) public String            _Package;
    @SerializedName("documentation") public Documentation     _Documentation = new Documentation();
    @SerializedName("dependencies" ) public String[]          _Dependencies;
    @SerializedName("interfaces"   ) public List<Interface  > _Interfaces  = new ArrayList<Interface  >();
    @SerializedName("enumerations" ) public List<Enumeration> _Enumerations= new ArrayList<Enumeration>();
    @SerializedName("mappers"      ) public List<Mapper     > _Mappers     = new ArrayList<Mapper     >();
    @SerializedName("objects"      ) public List<Object     > _Objects     = new ArrayList<Object     >();
    @SerializedName("views"        ) public List<View       > _Views       = new ArrayList<View       >();
    @SerializedName("importers"    ) public List<Importer   > _Importers   = new ArrayList<Importer   >();
    /*@formatter:on*/

    transient public String        _Name;
    transient public String        _ResourceName;
    transient public String        _ResourceNameShort;
    transient public String        _ProjectRoot;
    transient public List<Schema>  _DependencySchemas = new ArrayList<Schema>();

    protected static final Pattern P                  = Pattern.compile("_tilda\\.(\\w+)\\.json");

    public void setOrigin(String ResourceName)
      throws Exception
      {
        _ResourceName = ResourceName;
        String Pack = _Package.replaceAll("\\.", "/");
        ResourceName = ResourceName.replaceAll(File.separatorChar == '\\' ? "\\\\" : "\\" + File.separatorChar, "/");
        int i = ResourceName.indexOf(Pack);
        if (i == -1)
          throw new Exception("The Schema being loaded from resource '" + ResourceName + "' does not match its package declaration '" + _Package + "'.");

        _ProjectRoot = ResourceName.substring(0,  i);
        _ResourceNameShort = ResourceName.substring(i);
        String res = ResourceName.substring(i+Pack.length()+1);
        Matcher M = P.matcher(res);
        while (M.matches() == true)
          {
            _Name = M.group(1).toUpperCase();
            return;
          }
        throw new Exception("Cannot parse out the Tilda schema name out of the resource/file name '" + ResourceName + "'.");
      }

    /**
     * 
     * @return the FULL name of the schema (including the package name).
     */
    public String getFullName()
      {
        return _Package + "." + _Name;
      }

    /**
     * 
     * @return simply the name of the schema.
     */
    public String getShortName()
      {
        return _Name;
      }

    public Object getObject(String Name)
      {
        for (Object O : _Objects)
          if (O != null && O._Name != null && O._Name.equalsIgnoreCase(Name) == true)
            return O;
        return null;
      }
    
    public boolean isDefinedInOrder(Object FirstObj, Object SecondObj)
      {
        int i = _Objects.indexOf(FirstObj);
        int j = _Objects.indexOf(SecondObj);
        return i != -1 && j != -1 && i <= j; 
      }

    public View getView(String Name)
      {
        for (View V : _Views)
          if (V != null && V._Name != null && V._Name.equalsIgnoreCase(Name) == true)
            return V;
        return null;
      }

    public Mapper getMapper(String Name)
      {
        for (Mapper M : _Mappers)
          if (M != null && M._Name != null && M._Name.equalsIgnoreCase(Name) == true)
            return M;
        return null;
      }

    public Column getColumn(String ObjectName, String ColumnName)
      {
        Object O = getObject(ObjectName);
        return O == null ? null : O.getColumn(ColumnName);
      }


    public boolean Validate(ParserSession PS)
      {
        LOG.info("Validating Tilda Schema '" + getFullName() + "'.");
        int Errs = PS.getErrorCount();
        int i = -1;
        for (Enumeration E : _Enumerations)
          if (E != null)
            {
              E.Validate(PS, this, ++i);
            }
        for (Mapper M : _Mappers)
          if (M != null)
            {
              M.Validate(PS, this, ++i);
            }
        Set<String> ThingNames = new HashSet<String>();
        for (Object O : _Objects)
          if (O != null)
            {
              if (ThingNames.add(O._Name.toUpperCase()) == false)
                PS.AddError("The Object '" + O._Name + "' conflicts with another Thing already defined with the same name in Schema '" + getFullName() + "'.");
              O.Validate(PS, this);
            }
        
        for (View V : _Views)
          if (V != null)
            {
              if (ThingNames.add(V._Name.toUpperCase()) == false)
                PS.AddError("The View '" + V._Name + "' conflicts with another Thing already defined with the same name in Schema '" + getFullName() + "'.");
              V.Validate(PS, this);
            }
        
        return Errs == PS.getErrorCount();
      }
    public Documentation getDocumentation(){
    	if(_Documentation == null){
    		_Documentation = new Documentation();
    	}
    	return _Documentation;
    }

  }
