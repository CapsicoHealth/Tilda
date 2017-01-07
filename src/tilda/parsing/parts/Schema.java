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

import com.google.gson.annotations.SerializedName;

import tilda.enums.ColumnType;
import tilda.enums.ObjectLifecycle;
import tilda.parsing.ParserSession;
import tilda.utils.TextUtil;

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
    
    protected static final Pattern P                  = Pattern.compile("/?_tilda\\.(\\w+)\\.json");

    public void setOrigin(String ResourceName)
      throws Exception
      {
        _ResourceName = ResourceName;
        ResourceName = "/"+ResourceName; 
        
        String Pack = "/"+_Package.replaceAll("\\.", "/")+"/";
        ResourceName = ResourceName.replaceAll(File.separatorChar == '\\' ? "\\\\" : "\\" + File.separatorChar, "/");
        int i = ResourceName.indexOf(Pack);
        if (i == -1)
          throw new Exception("The Schema being loaded from resource '" + ResourceName + "' does not match its package declaration '" + _Package + "'.");

        _ProjectRoot = ResourceName.substring(i==0?0:1,  i);
        _ResourceNameShort = ResourceName.substring(i+1);
        String res = ResourceName.substring(i+Pack.length()-1);
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

    public Object getObject(String SchemaName, String ObjectName)
      {
        if (_Name.equals(SchemaName) == true)
         return getObject(ObjectName);
        for (Schema S : _DependencySchemas)
          {
            if (S._Name.equals(SchemaName) == true)
             return S.getObject(ObjectName);
          }
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
    
    public View getSourceView(Object O)
      {
        if (_Name.equals(O._ParentSchema._Name) == true)
         return getView(O._Name);
        for (Schema S : _DependencySchemas)
          {
            if (S._Name.equals(O._ParentSchema._Name) == true)
             return S.getView(O._Name);
          }
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
        boolean hasFormulas = false;
        for (View V : _Views)
          if (V != null)
            {
              if (ThingNames.add(V._Name.toUpperCase()) == false)
                PS.AddError("The View '" + V._Name + "' conflicts with another Thing already defined with the same name in Schema '" + getFullName() + "'.");
              V.Validate(PS, this);
              if (V._Formulas != null && V._Formulas.isEmpty() == false)
               hasFormulas = true;
            }
        if (hasFormulas == true)
         CreateFormulaDocumentationTables(PS);
        
        _Validated = Errs == PS.getErrorCount();
        return _Validated;
      }
    private void CreateFormulaDocumentationTables(ParserSession PS)
      {
        Object O = new Object();
        O._Name = "TildaFormula";
        O._Description = "Generated table to hold documentation meta-data about formulas defined in this schema";
        O._LCStr = ObjectLifecycle.READONLY.name();
        O._OCC = true;
       
        Column C = new Column("viewName", ColumnType.STRING.name(), 64, false, null, true, null, "The name of the view this formula is defined in");
        O._Columns.add(C);
        C = new Column("realizedTableName", ColumnType.STRING.name(), 64, true, null, true, null, "The name of the realized table, if appropriate");
        O._Columns.add(C);
        C = new Column("name", ColumnType.STRING.name(), 64, false, null, true, null, "The name of the formula/column");
        O._Columns.add(C);
        C = new Column("title", ColumnType.STRING.name(), 64, false, null, true, null, "The title of the formula/column");
        O._Columns.add(C);
        C = new Column("description", ColumnType.STRING.name(), 4096, false, null, true, null, "The description of the formula/column");
        O._Columns.add(C);
        C = new Column("formula", ColumnType.STRING.name(), 4096, false, null, true, null, "The formula");
        O._Columns.add(C);
        C = new Column("html", ColumnType.STRING.name(), 4096, false, null, true, null, "A pre-rendered html fragment with the full documentation for this formula");
        O._Columns.add(C);

        O._PrimaryKey = new PrimaryKey();
        O._PrimaryKey._Columns = new String[] { "viewName", "name"};
        
        O._Indices = new ArrayList<Index>();
        Index I = new Index();
        I._Name = "ViewName";
        I._Columns = new String[] { "viewName" };
        I._OrderBy = new String[] { "name asc" };
        I._Db = false;
        O._Indices.add(I);
        
        O._Json = new ArrayList<JsonMapping>();
        JsonMapping J = new JsonMapping();
        J._Name = "";
        J._Columns = new String[] { "viewName", "realizedTableName", "name", "title", "description", "formula", "html", "created", "lastUpdated"}; 
        O._Json.add(J);

        _Objects.add(O);
        O.Validate(PS, this);
        

        O = new Object();
        O._Name = "TildaFormulaValue";
        O._Description = "Generated table to hold documentation meta-data about the values for the formulas defined in this schema";
        O._LCStr = ObjectLifecycle.READONLY.name();
        O._OCC = true;
       
        C = new Column("viewName", ColumnType.STRING.name(), 64, false, null, true, null, "The name of the view this formula value is defined in");
        O._Columns.add(C);
        C = new Column("formulaName", ColumnType.STRING.name(), 64, false, null, true, null, "The name of the formula/column this value is defined for");
        O._Columns.add(C);
        C = new Column("value", ColumnType.STRING.name(), 64, false, null, true, null, "The value");
        O._Columns.add(C);
        C = new Column("description", ColumnType.STRING.name(), 4096, false, null, true, null, "The description of the value");
        O._Columns.add(C);
        
        O._PrimaryKey = new PrimaryKey();
        O._PrimaryKey._Columns = new String[] { "viewName", "formulaName", "value"};
        
        O._ForeignKeys = new ArrayList<ForeignKey>();
        ForeignKey FK = new ForeignKey();
        FK._Name = "Formula";
        FK._DestObject = "TildaFormula";
        FK._SrcColumns= new String[] { "viewName", "formulaName" };
        
        O._Indices = new ArrayList<Index>();
        I = new Index();
        I._Name = "ViewFormula";
        I._Columns = new String[] { "viewName", "formulaName" };
        I._OrderBy = new String[] { "value asc" };
        I._Db = false;
        O._Indices.add(I);
        
        O._Json = new ArrayList<JsonMapping>();
        J = new JsonMapping();
        J._Name = "";
        J._Columns = new String[] { "viewName", "formulaName", "value", "description", "created", "lastUpdated"}; 
        O._Json.add(J);

        _Objects.add(O);
        O.Validate(PS, this);

        O = new Object();
        O._Name = "TildaFormulaReference";
        O._Description = "Generated table to hold documentation meta-data about the columns and other formulas referenced by a formula";
        O._LCStr = ObjectLifecycle.READONLY.name();
        O._OCC = true;
       
        C = new Column("viewName", ColumnType.STRING.name(), 64, false, null, true, null, "The name of the view this formula references is defined in");
        O._Columns.add(C);
        C = new Column("formulaName", ColumnType.STRING.name(), 64, false, null, true, null, "The name of the formula/column this value is defined for");
        O._Columns.add(C);
        C = new Column("referenceName", ColumnType.STRING.name(), 64, false, null, true, null, "The name of the column or other formula refence");
        O._Columns.add(C);
        C = new Column("referenceType", ColumnType.STRING.name(), 4, false, null, true, null, "The type of the refence");
        C._Values = new ColumnValue[2];
        C._Values[0] = new ColumnValue();
        C._Values[0]._Name = "Column";
        C._Values[0]._Value = "CLMN";
        C._Values[0]._Description = "A referenced column";
        C._Values[1] = new ColumnValue();
        C._Values[1]._Name = "formula";
        C._Values[1]._Value = "FRML";
        C._Values[1]._Description = "A referenced Formula";
        O._Columns.add(C);
        C = new Column("description", ColumnType.STRING.name(), 4096, false, null, true, null, "The description of the reference");
        O._Columns.add(C);
        
        O._PrimaryKey = new PrimaryKey();
        O._PrimaryKey._Columns = new String[] { "viewName", "formulaName", "referenceName", "referenceType"};

        O._ForeignKeys = new ArrayList<ForeignKey>();
        FK = new ForeignKey();
        FK._Name = "Formula";
        FK._DestObject = "TildaFormula";
        FK._SrcColumns= new String[] { "viewName", "formulaName" };
        
        O._Indices = new ArrayList<Index>();
        I = new Index();
        I._Name = "ViewFormula";
        I._Columns = new String[] { "viewName", "formulaName" };
        I._OrderBy = new String[] { "referenceName asc" };
        I._Db = false;
        O._Indices.add(I);
        
        O._Json = new ArrayList<JsonMapping>();
        J = new JsonMapping();
        J._Name = "";
        J._Columns = new String[] { "viewName", "formulaName", "referenceName", "referenceType", "description", "created", "lastUpdated"}; 
        O._Json.add(J);

        _Objects.add(O);
        O.Validate(PS, this);

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

//        LOG.info("Reordered Schemas based on dependencies");
//        PrintSchemaList(L);

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
