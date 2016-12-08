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
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

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
    transient public Boolean       _Validated = null;
    
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
        
        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }
    public Documentation getDocumentation(){
    	if(_Documentation == null){
    		_Documentation = new Documentation();
    	}
    	return _Documentation;
    }

    public static int findByResourceName(List<Schema> L, String ResourceName)
      {
        for (int i = 0; i < L.size(); ++i)
          if (L.get(i)._ResourceName.equals(ResourceName) == true)
           return i;
        return -1;
      }

    
    public static void ReorderTildaListWithDependencies(List<Schema> L)
      {
        // LOG.info("Starting with");
        // PrintSchemaList(L);
        Set<String> MovedSchemas = new HashSet<String>();
        for (int i = 0; i < L.size(); ++i)
          {
            Schema S = L.get(i);
            // LOG.info("Checking out " + S._Name + ".");
            if (S._Name.equals("TILDA") == true)
              {
                L.add(0, L.remove(i));
                // LOG.info("Moving " + S._Name + " to the top.");
                // PrintSchemaList(L);
                continue;
              }
            if (TextUtil.isNullOrEmpty(S._Dependencies) == true)
              {
                // LOG.info("Not touching " + S._Name + " since it has no dependency.");
                continue;
              }
            boolean MovedSomething = false;
            for (String Dep : S._Dependencies)
              {
                int j = Schema.findByResourceName(L, Dep);
                if (j > i)
                  {
                    // LOG.info("Moving " + S._Name + "'s dependency " + L.get(j)._Name + " before.");
                    L.add(i, L.remove(j));
                    MovedSomething = true;
                  }
              }
            if (MovedSomething == true)
              {
                if (MovedSchemas.add(S._Name) == false)
                  throw new Error("There is a circular dependency: " + Schema.getCircularPath(S, L));
                // PrintSchemaList(L);
                --i;
              }
          }

        LOG.info("Reordered Schemas based on dependencies");
        PrintSchemaList(L);

        // L.clear();
        // L.addAll(NewL);
        // ReverseIterator<Schema> RI = new ReverseIterator<>(NewL);
        // while (RI.hasNext() == true)
        // L.add(RI.next());

        // LOG.info("Reordered Schemas based on dependencies");
        // for (Schema S : L)
        // LOG.info(" "+S._Name);

        return;
      }

    private static void PrintSchemaList(List<Schema> L)
      {
        for (Schema X : L)
          LOG.info("   " + X._Name);
      }
    
    public static String getCircularPath(Schema S, List<Schema> L)
      {
        StringBuilder Str = new StringBuilder();
        Str.append(S._Name);
        if (TextUtil.isNullOrEmpty(S._Dependencies) == false)
         for (String s : S._Dependencies)
           {
             int j = Schema.findByResourceName(L, s);
             Schema D = L.get(j);
             if (getSubCircularPath(S, D, L, Str) == false)
              break;
           }
        return Str.append(" :)").toString();
      }

    private static boolean getSubCircularPath(Schema Root, Schema S, List<Schema> L, StringBuilder Str)
      {
        Str.append(" --> ").append(S._Name);
        if (Root._Name.equals(S._Name) == true)
         return false;

        if (TextUtil.isNullOrEmpty(S._Dependencies) == false)
         for (String s : S._Dependencies)
           {
             int j = Schema.findByResourceName(L, s);
             Schema D = L.get(j);
             if (getSubCircularPath(Root, D, L, Str) == false)
              return false;
           }
        return true;
      }

  }
