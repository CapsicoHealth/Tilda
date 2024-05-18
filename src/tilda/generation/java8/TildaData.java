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

package tilda.generation.java8;

import java.io.PrintWriter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.StringBuilderWriter;

import tilda.enums.ColumnMapperMode;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.MultiType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.OutputFormatType;
import tilda.enums.ProtectionType;
import tilda.enums.TZMode;
import tilda.enums.VisibilityType;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenTildaData;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.JsonField;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OutputMap;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.utils.AnsiUtil;
import tilda.utils.PaddingUtil;
import tilda.utils.TextUtil;

public class TildaData implements CodeGenTildaData
  {
    protected static final Logger LOG = LogManager.getLogger(TildaData.class.getName());

    @Override
    public String getFileName(Base O)
      {
        return O._BaseClassName + ".java";
      }

    @Override
    public void genFileStart(PrintWriter Out, Object O)
    throws Exception
      {
        Out.println("package " + O._ParentSchema._Package + "." + Helper.TILDA_GEN_PACKAGE + ";");
        Out.println();
        for (Column C : O._Columns)
          {
            if (C == null)
              continue;
            if (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN || C.getType() == ColumnType.DATE)
              {
                Out.println("import java.time.*;");
                Out.println("import java.sql.Timestamp;");
                break;
              }
          }
        Out.println("import java.util.*;");
        Out.println();
        Out.println("import tilda.db.*;");
        Out.println("import tilda.enums.*;");
        Out.println("import tilda.performance.*;");
        Out.println("import tilda.utils.*;");
        Out.println();
        Out.println("import org.apache.logging.log4j.*;");
        Out.println();
        Out.println("import com.google.gson.*;");
        Out.println("import com.google.gson.annotations.*;");
        Out.println("import java.math.*;");
        Out.println();
      }


    @Override
    public void genClassStart(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        Out.println("@SuppressWarnings({ \"unused\" })");
        Out.print("public abstract class " + O._BaseClassName + " implements");
        if (O._LC == ObjectLifecycle.READONLY)
          Out.print(" tilda.interfaces.ReaderObject");
        else
          Out.print(" tilda.interfaces.WriterObject");
        if (O.isOCC() == true && (O._FST == FrameworkSourcedType.NONE || O._FST == FrameworkSourcedType.VIEW || O._FST == FrameworkSourcedType.CLONED))
          Out.print(", tilda.interfaces.OCCObject");
        if (O.isJsonable() == true)
          Out.print(", tilda.interfaces.JSONable");
        if (O.isCSVable() == true)
          Out.print(", tilda.interfaces.CSVable");
        Out.println();
        Out.println(" {");
        Out.println("   protected transient static final Logger LOG = LogManager.getLogger(" + O._BaseClassName + ".class.getName());");
        Out.println();
        Out.println("   public transient static final Class<" + O._BaseClassName + "_Factory> FACTORY_CLASS= " + O._BaseClassName + "_Factory.class;");
        Out.println("   public transient static final String TABLENAME = TextUtil.print(" + TextUtil.escapeDoubleQuoteWithSlash(O.getShortName()) + ", \"\");");
        Out.println();
        Out.println("   protected " + O._BaseClassName + "() { }");
        Out.println();
        Out.println("   transient InitMode __Init        = null;");
        Out.println("   transient BitSet   __Nulls       = new BitSet(64);");
        Out.println("   transient BitSet   __Changes     = new BitSet(64);");
        Out.println("   transient boolean  __NewlyCreated= false;");
        Out.println("   transient int      __LookupId;");
        if (O.hasMasking() == true)
          Out.println("   transient boolean  __MaskMode = QueryDetails.getThreadMaskMode();");
        Out.println();
        Out.println("   public  boolean hasChanged    () { return __Changes.isEmpty() == false; }");
        Out.println("   public  boolean isNewlyCreated() { return __NewlyCreated; }");
        Out.println();
        Out.println("   void initForCreate()");
        Out.println("     {");
        Out.println("       __Init         = InitMode.CREATE;");
        Out.println("       __NewlyCreated = true ;");
        Out.println("       __LookupId     = SystemValues.EVIL_VALUE;");
        Out.println("     }");
        Out.println("   void initForLookup(int LookupId)");
        Out.println("     {");
        Out.println("       __Init     = InitMode.LOOKUP;");
        Out.println("       __LookupId = LookupId       ;");
        Out.println("     }");
      }

    @Override
    public void genField(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        // String Visibility = Helper.getVisibility(C, true);

        if (C.getType() == ColumnType.JSON && C._JsonSchema != null)
          {
            Out.println("   transient String _" + C.getName() + ";");
            if (C.isJSONColumn() == true)
              Out.println("   @SerializedName(\"" + C.getName() + "\"" + ")");
            if (C.isCollection() == false)
              Out.println("   " + C._JsonSchema._TypeName + " _" + C.getName() + "Obj;");
            else
              Out.println("   List<" + C._JsonSchema._TypeName + "> _" + C.getName() + "Obj = new ArrayList<" + C._JsonSchema._TypeName + ">();");
            Out.println("   public static class " + C._JsonSchema._TypeName);
            Out.println("    {");
            for (JsonField f : C._JsonSchema._Fields)
              {
                Out.println("      @SerializedName(\"" + f._Name + "\") public " + JavaJDBCType.getJsonFieldType(f) + " _" + f._Name + ";");
              }

            Out.println("      public String validate()");
            Out.println("       {");
            if (C._JsonSchema._Validation != null && TextUtil.isNullOrEmpty(C._JsonSchema._Validation._JavaCodeGenStr) == false)
              {
                Out.println("         if (" + C._JsonSchema._Validation._JavaCodeGenStr + ")");
                Out.println("          return null;");
                Out.println("         return " + TextUtil.escapeDoubleQuoteWithSlash(C._JsonSchema._Validation._Descr) + ";");
              }
            else
              {
                Out.println("          return null;");
              }
            Out.println("       }");
            Out.println("    }");
          }
        else if (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN)
          {
            if (C.isJSONColumn() == true)
              {
                Out.println("   @SerializedName(\"" + C.getName() + "\"" + ")");
                Out.println("   " + (C.isList() == true ? "List<String>" : C.isSet() == true ? "Set<String>" : "String") + "  Str_" + C.getName() + ";");
                Out.println("   /** Pre-init the field as it would come from a JSON stream, in text form, e.g., timestamps. */");
                Out.println("   public void initJson_" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(" + (C.isList() == true ? "List<String>" : C.isSet() == true ? "Set<String>" : "String") + " v) { Str_" + C.getName() + " = v; }");
                Out.println("   public " + (C.isList() == true ? "List<String>" : C.isSet() == true ? "Set<String>" : "String") + " init" + TextUtil.capitalizeFirstCharacter(C.getName()) + "Val(" + ") { return Str_" + C.getName() + "; }");
              }
            Out.println("   transient " + JavaJDBCType.getFieldType(C) + " _" + C.getName() + " = null;");
            if (C.isSavedField() == true)
              Out.println("   transient " + JavaJDBCType.getFieldType(C) + " __Saved_" + C.getName() + ";");
          }
        else
          {
            if (C.isJSONColumn() == true)
              Out.println("   @SerializedName(\"" + C.getName() + "\"" + ")");
            if (C.isCollection() == true)
              Out.print("   " + JavaJDBCType.getFieldType(C) + " _" + C.getName());
            else
              Out.print("   " + JavaJDBCType.getFieldTypeBaseClass(C) + " _" + C.getName());

            if (C.isCollection() == false)
              Out.print("=null"); // " + C.getType().getDefaultNullValue() + ";");
            else if (C._Nullable == false)
              {
                if (C.isList() == true)
                  Out.print("= new ArrayList<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">()");
                else if (C.isSet() == true)
                  Out.print("= new TreeSet<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">()");
              }
            Out.println(";");
            if (C.isSavedField() == true)
              Out.println("   protected " + JavaJDBCType.getFieldTypeBaseClass(C) + " __Saved_" + C.getName() + ";");
          }

      }

    @Override
    public void genFieldValues(PrintWriter Out, GeneratorSession G, Column C)
      {
        if (C._MapperDef != null)
          {
            Out.println("   public static final String[][] _" + C.getName() + "_Values = " + Helper.getFullAppDataClassName(C._MapperDef._DestObjectObj) + "._group_Values;");
          }
        else
          {
            Out.println("   public static final String[][] _" + C.getName() + "_Values = {");
            boolean First = true;
            for (ColumnValue V : C._Values)
              if (V != null)
                {
                  if (First == true)
                    {
                      Out.print("                                               ");
                      First = false;
                    }
                  else
                    Out.print("                                             , ");
                  Out.print("{ " + TextUtil.escapeDoubleQuoteWithSlash(V._Value) + C._PadderValueValues.getPad(V._Value) + ", " + TextUtil.escapeDoubleQuoteWithSlash(V._Label) + ", " + TextUtil.escapeDoubleQuoteWithSlash(V._Description));
                  Out.print(", \"");
                  if (V._Groupings != null && V._Groupings.length != 0)
                    {
                      First = true;
                      for (String g : V._Groupings)
                        {
                          if (First == true)
                            First = false;
                          else
                            Out.print("``");
                          Out.print(g.toUpperCase());
                        }
                    }
                  Out.println("\" }");
                }
            Out.println("                                  };");

            Out.println("   public static final boolean check" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldType(C) + " v)");
            Out.println("    {");
            if (C.isCollection() == true)
              {
                Out.println("      for (int i = 0; i < v.size(); ++ i)");
                Out.println("        for (String[] val : _" + C.getName() + "_Values)");
                if (C.getType() == ColumnType.CHAR)
                  Out.println("         if (val[0].charAt(0) != v.get(i))");
                else
                  Out.println("         if (val[0].equals(v.get(i).toString()) == false)");
                Out.println("          return false;");
                Out.println("      return true;");
              }
            else
              {
                Out.println("      for (String[] a : _" + C.getName() + "_Values)");
                if (C.getType() == ColumnType.CHAR)
                  Out.println("       if (a[0].charAt(0) == v)");
                else if (C.getType().isNumber())
                  Out.println("       if (a[0].equals(String.valueOf(v)) == true)");
                else
                  Out.println("       if (a[0].equals(v) == true)");
                Out.println("        return true;");
                Out.println("      return false;");
              }
            Out.println("    }");
            String type = C.getType() == ColumnType.CHAR ? "Character" : "String";
            if (C.isCollection() == true)
              {
                Out.println("   public static final List<" + type + "> map" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldType(C) + " v)");
                Out.println("    {");
                Out.println("      List<" + type + "> descriptions = new ArrayList<" + type + ">();");
                Out.println("      for (int i = 0; i < v.size(); ++ i)");
                Out.println("        for (String[] a : _" + C.getName() + "_Values)");
                if (C.getType() == ColumnType.CHAR)
                  {
                    Out.println("          if (a[0].charAt(0) == v.get(i))");
                    Out.println("           descriptions.add(a[2].charAt(0));");
                    Out.println("          else");
                    Out.println("           descriptions.add(v.get(i));");
                  }
                else
                  {
                    Out.println("          if (a[0].equals(v.get(i).toString()) == true)");
                    Out.println("           descriptions.add(a[2]);");
                    Out.println("          else");
                    Out.println("           descriptions.add(v.get(i).toString());");
                  }
                Out.println("      return descriptions;");
                Out.println("    }");
              }
            else
              {
                Out.println("   public static final " + type + " map" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldType(C) + " v)");
                Out.println("    {");
                Out.println("      for (String[] a : _" + C.getName() + "_Values)");
                if (C.getType() == ColumnType.CHAR)
                  {
                    Out.println("       if (a[0].charAt(0) == v)");
                    Out.println("        return a[2].charAt(0);");
                  }
                else
                  {
                    if (C.getType().isNumber())
                      Out.println("       if (a[0].equals(String.valueOf(v)) == true)");
                    else
                      Out.println("       if (a[0].equals(v) == true)");
                    Out.println("        return a[2];");
                  }
                Out.println("      return null;");
                Out.println("    }");
              }
          }

        for (ColumnValue V : C._Values)
          if (V != null)
            {
              if (C._MapperDef != null)
                {
                  Out.println("   public static final " + JavaJDBCType.getFieldTypeBase(C._MapperDef._ParentColumn)
                  + " _" + C.getName() + TextUtil.capitalizeFirstCharacter(V._Name) + C._PadderValueNames.getPad(V._Name)
                  + " = " + Helper.getFullAppDataClassName(C._MapperDef._DestObjectObj) + "._group" + V._Name + ";");
                }
              else
                {
                  Out.print("   public static final " + JavaJDBCType.getFieldTypeBase(C) + " _" + C.getName() + TextUtil.capitalizeFirstCharacter(V._Name) + C._PadderValueNames.getPad(V._Name) + " = ");
                  Out.print(ValueHelper.printValueJava(V._ParentColumn.getName(), V._ParentColumn.getType(), V._ParentColumn.isCollection(), V._Value, V._ParentColumn.getName()));
                  Out.println(";");
                }
            }


      }

    @Override
    public void genMethodGet(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        // Generated columns
        if (C._Mode == ColumnMode.CALCULATED && C._MapperDef == null)
          Out.println("   public abstract " + JavaJDBCType.getFieldType(C) + " get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "();");
        // JSON column without a schema
        else if (C.getType() == ColumnType.JSON && C._JsonSchema != null)
          {
            if (C.isCollection() == false)
              {
                Out.println("   public final " + C._JsonSchema._TypeName + " get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "()");
                Out.println("      {");
                Out.println("        return _" + C.getName() + "Obj;");
                Out.println("      }");
              }
            else
              {
                Out.println("   public final List<" + C._JsonSchema._TypeName + "> get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "()");
                Out.println("      {");
                Out.println("        return _" + C.getName() + "Obj;");
                Out.println("      }");
              }
          }
        // Other non-collection columns
        else if (C.isCollection() == false)
          {
            Out.println("   public final " + JavaJDBCType.getFieldType(C) + " get" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "()");
            if (C.getType() == ColumnType.BOOLEAN)
              Out.println("      { return _" + C.getName() + "==null?false:_" + C.getName() + "; }");
            else if (C.getType() == ColumnType.SHORT || C.getType() == ColumnType.INTEGER)
              Out.println("      { return _" + C.getName() + "==null?0:_" + C.getName() + "; }");
            else if (C.getType() == ColumnType.LONG)
              Out.println("      { return _" + C.getName() + "==null?0l:_" + C.getName() + "; }");
            else if (C.getType() == ColumnType.FLOAT)
              Out.println("      { return _" + C.getName() + "==null?0f:_" + C.getName() + "; }");
            else if (C.getType() == ColumnType.DOUBLE)
              Out.println("      { return _" + C.getName() + "==null?0d:_" + C.getName() + "; }");
            else if (C.getType() == ColumnType.CHAR)
              Out.println("      { return _" + C.getName() + "==null?(char)Character.UNASSIGNED:_" + C.getName() + "; }");
            else
              Out.println("      { return _" + C.getName() + "; }");
          }
        // Collection columns
        else
          {
            Out.println("   public final " + JavaJDBCType.getFieldTypeBaseClass(C) + "[] get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "AsArray()");
            Out.println("      { return _" + C.getName() + "==null? null : _" + C.getName() + ".toArray(new " + JavaJDBCType.getFieldTypeBaseClass(C) + "[_" + C.getName() + ".size()]); }");
            Out.println("   public final Iterator<" + JavaJDBCType.getFieldTypeBaseClass(C) + "> get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "()");
            Out.println("      { return _" + C.getName() + "==null? null : _" + C.getName() + ".iterator(); }");
            Out.println("   public final boolean has" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldTypeBase(C) + " v)");
            Out.println("      { return _" + C.getName() + "==null? false : _" + C.getName() + ".contains(v); }");
          }
      }

    @Override
    public void genMethodIs(PrintWriter Out, GeneratorSession G, ColumnValue V)
      {
        String ValueNameVar = "_" + V._ParentColumn.getName() + TextUtil.capitalizeFirstCharacter(V._Name);
        Out.println("   public final boolean is" + TextUtil.capitalizeFirstCharacter(V._ParentColumn.getName()) + TextUtil.capitalizeFirstCharacter(V._Name) + "()");
        if (V._ParentColumn.isCollection() == true)
          Out.println("      { return  _" + V._ParentColumn.getName() + " != null && _" + V._ParentColumn.getName() + ".contains(" + ValueNameVar + ") == true; }");
        else
          switch (V._ParentColumn.getType())
            {
              case BOOLEAN:
              case CHAR:
              case DOUBLE:
              case FLOAT:
              case INTEGER:
              case SHORT:
              case LONG:
              case NUMERIC:
              case UUID:
                Out.println("      { return _" + V._ParentColumn.getName() + " != null && _" + V._ParentColumn.getName() + ".equals(" + ValueNameVar + "); }");
                break;
              case DATETIME:
              case DATETIME_PLAIN:
              case DATE:
                if (V._Value.equalsIgnoreCase("NOW") == true)
                  Out.println("      { return DateTimeUtil.isNowPlaceholder(_" + V._ParentColumn.getName() + "); }");
                else if (V._Value.equalsIgnoreCase("UNDEFINED") == true)
                  Out.println("      { return DateTimeUtil.isUndefinedPlaceHolder(_" + V._ParentColumn.getName() + "); }");
                else
                  Out.println("      { return _" + V._ParentColumn.getName() + " != null && _" + V._ParentColumn.getName() + ".equals(" + ValueNameVar + "); }");
                break;
              case STRING:
              case JSON:
                Out.println("      { return _" + V._ParentColumn.getName() + " != null && _" + V._ParentColumn.getName() + ".equals(" + ValueNameVar + "); }");
                break;
              case BINARY:
              case BITFIELD:
              case VECTOR:
                throw new Error("An invalid type '" + V._ParentColumn.getType() + "' was assigned column values for code gen.");
              default:
                throw new Error("Unhandled case in switch for type '" + V._ParentColumn.getType() + "'.");
            }
      }

    @Override
    public void genMethodSet(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        
        if (C._Mode == ColumnMode.AUTO && C._MapperDef == null && C._FCT.isManaged() == false)
          {
            Out.println("   /**");
            Out.println("    * Internal setter for auto field " + C.getName());
            Out.println("    */");
            Out.println("   protected abstract void set" + TextUtil.capitalizeFirstCharacter(C.getName()) + "() throws Exception;");
            Out.println();
          }

        String Mask = Helper.getRuntimeMask(C);
        String Visibility = Helper.getVisibility(C, true);
        if (C._JsonSchema != null && C.isCollection() == true)
          {
            Out.println("   protected static final java.lang.reflect.Type LIST_TYPE_" + C._JsonSchema._TypeName + " = new com.google.gson.reflect.TypeToken<ArrayList<" + C._JsonSchema._TypeName + ">>(){}.getType();");
            Out.println();
          }
        
        if (C.isCollection() == true)
          {
            if (C._JsonSchema == null)
              Out.println("   " + Visibility + " void set" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldType(C) + " v) throws Exception");
            else
              Out.println("   " + Visibility + " void set" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(String v) throws Exception");

            Out.println("     {");
            
            Out.println("       long T0 = System.nanoTime();");
            if (C._Invariant == true || C._ParentObject.getLifecycle() != ObjectLifecycle.NORMAL)
              {
                Out.println("       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)");
                Out.println("        throw new Exception(\"Cannot set field '" + C.getFullName() + "' that is invariant, or part of a read-only or pre-existing WORM object.\");");
              }
            Out.println("       if (v == null " + (C._Nullable == true && C._AllowEmpty == false ? " || v.isEmpty() == true" : "") + ")");
            if (C._Nullable == true)
              Out.println("        setNull" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "();");
            else
              Out.println("        throw new Exception(\"Cannot set " + C.getFullName() + " to null: it's not nullable.\");");
            if (C._JsonSchema == null)
              Out.println("       else if (CollectionUtil.equals(v, _" + C.getName() + ") == false)");
            else
              Out.println("       else if (v.equals(_" + C.getName() + ") == false)");
            Out.println("        {");
            if (C._MapperDef == null)
              {
                Out.println("          __Changes.or(" + Mask + ");");
                Out.println("          __Nulls.andNot(" + Mask + ");");
                if (C._Mapper != null)
                  {
                    if (C._Mapper._Name == ColumnMapperMode.DB)
                      {
                        Column SecondaryC = C._ParentObject.getColumn(C.getName() + "MappedName");
                        String SecondaryMask = Helper.getRuntimeMask(SecondaryC);
                        Out.println("          __Changes.or(" + SecondaryMask + ");");
                        Out.println("          __Nulls.andNot(" + SecondaryMask + ");");
                      }
                    if (C._Mapper._Group == ColumnMapperMode.DB)
                      {
                        Column SecondaryC = C._ParentObject.getColumn(C.getName() + "MappedGroup");
                        String SecondaryMask = Helper.getRuntimeMask(SecondaryC);
                        Out.println("          __Changes.or(" + SecondaryMask + ");");
                        Out.println("          __Nulls.andNot(" + SecondaryMask + ");");
                      }
                  }
              }
            if (C._JsonSchema == null)
              {
                Out.println("          if (_" + C.getName() + " == null)");
                Out.println("           {");                
                Out.println("             // GOTTA Check if we are setting a null ROWTZ but there are still row timestamps that are not null");
                Out.println("             _" + C.getName() + " = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">();");
                if (C.needsTZ() == true && C._TzMode.isColumn() == true)
                  Out.println("             _" + C.getTZName() + " = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<String>();");
                Out.println("           }");
                Out.println("          else");
                Out.println("           {");
                Out.println("             _" + C.getName() + ".clear();");
                if (C.needsTZ() == true && C._TzMode.isColumn() == true)
                  Out.println("             _" + C.getTZName() + ".clear();");
                Out.println("           }");
                if (C._Mapper != null)
                  {
                    if (C._Mapper._Name != ColumnMapperMode.NONE)
                      {
                        Out.println("          if (_" + C.getName() + "MappedName == null)");
                        Out.println("           _" + C.getName() + "MappedName = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">();");
                        Out.println("          else");
                        Out.println("           _" + C.getName() + "MappedName.clear();");
                      }
                    if (C._Mapper._Group != ColumnMapperMode.NONE)
                      {
                        Out.println("          if (_" + C.getName() + "MappedGroup == null)");
                        Out.println("           _" + C.getName() + "MappedGroup = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">();");
                        Out.println("          else");
                        Out.println("           _" + C.getName() + "MappedGroup.clear();");
                      }
                  }
                if (C.needsTZ() == true)
                  {
                    if (C.isList() == false)
                      throw new Error("ERROR: Cannot have Sets of DateTimes!");
                    if (C._TzMode.isRow() == true)
                      Out.println("          tilda.data.ZoneInfo_Data ZIPrev = null;");
                    Out.println("          for (int k = 0; k < v.size(); ++k)");
                    Out.println("           {");
                    Out.println("             " + JavaJDBCType.getFieldTypeBase(C) + " i = v.get(k);");
                  }
                else
                  {
                    Out.println("          for (" + JavaJDBCType.getFieldTypeBase(C) + " i : v)");
                    Out.println("           {");
                  }
                if (C._Enum != null)
                  {
                    String FactoryClassName = Helper.getFullAppFactoryClassName(C._Enum._DestObjectObj);
                    String DataClassName = Helper.getFullAppDataClassName(C._Enum._DestObjectObj);
                    Out.println("             " + DataClassName + " e = " + FactoryClassName + ".getEnumerationById(i);");
                    Out.println("             if (e == null)");
                    Out.println("              throw new Exception(\"Cannot set " + C.getFullName() + ": the value \'\"+i+\"\' is not a valid Enumerated value as per \'" + FactoryClassName + "\'.\");");
                    Out.println("             _" + C.getName() + ".add(e.getId());");
                  }
                else
                  Out.println("             _" + C.getName() + ".add(i);");
                if (C.needsTZ() == true)
                  {
                    Out.println("             tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(i.getZone().getId());");
                    Out.println("             if (ZI == null)");
                    Out.println("              throw new Exception(\"Cannot set field '" + C.getFullName() + "' because the timezone value '\"+i.getZone().getId()+\"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
                    if (C._TzMode.isRow() == true)
                      {
                        Out.println("             if (ZIPrev == null)");
                        Out.println("              ZIPrev = ZI;");
                        Out.println("             else if (ZIPrev.getId().equals(ZI.getId()) == false)");
                        Out.println("              throw new Exception(\"Cannot set field '" + C.getFullName() + "' because the timezone value '\"+i.getZone().getId()+\"' is inconsistent with previous value '\"+ZIPrev.getId()+\"' and the tzMode is row-based. Timestamps covered by a row-based timezone must all be set within the same exact timezone.\");");
                      }
                    else
                      Out.println("             addTo" + TextUtil.capitalizeFirstCharacter(C.getTZName()) + "(k, ZI.getId());");
                  }
                if (C._Mapper != null)
                  {
                    String ClassName = Helper.getFullAppFactoryClassName(C._Mapper._DestObjectObj);
                    StringBuilder Str = new StringBuilder();
                    for (int c = 0; c < C._Mapper._SrcColumnObjs.size() - 1; ++c)
                      {
                        Column col = C._Mapper._SrcColumnObjs.get(c);
                        if (c != 0)
                          Str.append(", ");
                        Str.append("get" + TextUtil.capitalizeFirstCharacter(col.getName()) + "()");
                      }
                    if (C._Mapper._Name != ColumnMapperMode.NONE)
                      Out.println("             _" + C.getName() + "MappedName.add(" + ClassName + ".getMappedName(" + Str + ", i));");
                    if (C._Mapper._Group != ColumnMapperMode.NONE)
                      Out.println("             _" + C.getName() + "MappedGroup.add(" + ClassName + ".getMappedGroup(" + Str + ", i));");
                  }
                Out.println("           }");
                if (C.needsTZ() == true && C._TzMode.isRow() == true)
                  {
                    Out.println("        set" + TextUtil.capitalizeFirstCharacter(C.getTZName()) + "(ZIPrev.getId());");
                  }
              }
            else
              {
                Out.println("          Gson gson = new GsonBuilder().setPrettyPrinting().create();");
                Out.println("          _" + C.getName() + "Obj = gson.fromJson(v, LIST_TYPE_" + C._JsonSchema._TypeName + ");");
                Out.println("          _" + C.getName() + " = v;");
              }
            Out.println("        }");
            Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
            Out.println("     }");
          }


        if (C._JsonSchema == null)
          {
            if (C.isList() == true)
              Out.println("   " + Visibility + " void addTo" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(int pos, " + JavaJDBCType.getFieldTypeBase(C) + " v) throws Exception");
            else if (C.isSet() == true)
              Out.println("   " + Visibility + " void addTo" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldTypeBase(C) + " v) throws Exception");
            else
              Out.println("   " + Visibility + (C._FCT == FrameworkColumnType.OCC_DELETED || C._FCT == FrameworkColumnType.OCC_LASTUPDATED ? " final" : "") + " void set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "(" + JavaJDBCType.getFieldType(C) + " v) throws Exception");
            Out.println("     {");
            
            if (C._TzCol == true && C._TzMode == TZMode.ROW)
              Out.println("       // DOING RowTz setter. Need additional logic");
            
            Out.println("       long T0 = System.nanoTime();");
            if (C.isCollection() == true)
              {
                Out.println("       if (_" + C.getName() + " == null)");
                Out.println("        _" + C.getName() + " = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">();");
              }
            if (C._Enum != null)
              {
                String FactoryClassName = Helper.getFullAppFactoryClassName(C._Enum._DestObjectObj);
                String DataClassName = Helper.getFullAppDataClassName(C._Enum._DestObjectObj);
                Out.println("       if (v != null)");
                Out.println("        {");
                Out.println("          " + DataClassName + " e = " + FactoryClassName + ".getEnumerationById(v);");
                Out.println("          if (e == null)");
                Out.println("           throw new Exception(\"Cannot set " + C.getFullName() + ": the value \'\"+v+\"\' is not a valid Enumerated value as per \'" + FactoryClassName + "\'.\");");
                Out.println("          v = e.getId();");
                if (C._Enum._Name != ColumnMapperMode.NONE)
                  Out.println("          " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.capitalizeFirstCharacter(C.getName()) + "EnumValue(" + (C.isList() ? "pos, " : "") + "e.getValue());");
                Out.println("        }");
              }
            switch (C.getType())
              {
                case BITFIELD:
                case CHAR:
                case BOOLEAN:
                case DOUBLE:
                case FLOAT:
                case LONG:
                case SHORT:
                case INTEGER:
                case NUMERIC:
                  if (C.isSet() == true)
                    Out.println("       if (_" + C.getName() + ".contains(v) == false)");
                  else if (C.isList() == true)
                    Out.println("       if (pos >= _" + C.getName() + ".size() || _" + C.getName() + ".get(pos).equals(v) == false)");
                  else
                    Out.println("       if (__Init == InitMode.CREATE || _" + C.getName() + " == null || v != _" + C.getName() + ")");
                  Out.println("        {");
                  break;
                case UUID:
                case DATE:
                case DATETIME:
                case DATETIME_PLAIN:
                case STRING:
                case JSON:
                case VECTOR:
                  if (C.getType() == ColumnType.STRING && C._AllowEmpty == false)
                    Out.println("       if (TextUtil.isNullOrEmpty(v) == true)");
                  else
                    Out.println("       if (v == null)");
                  if (C._Nullable == true)
                    {
                      Out.println("        {");
                      if (C._Mode == ColumnMode.CALCULATED && C._MapperDef != null)
                        Out.println("          _" + C.getName() + " = null;");
                      else
                        Out.println("          setNull" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "();");
                      Out.println("        }");
                    }
                  else if (C.getType() == ColumnType.STRING && C._AllowEmpty == false)
                    Out.println("        throw new Exception(\"Cannot set " + C.getFullName() + " to null or an empty value: it's not nullable and empty values are not allowed.\");");
                  else
                    Out.println("        throw new Exception(\"Cannot set " + C.getFullName() + " to null: it's not nullable.\");");
                  if (C.getType() == ColumnType.STRING && C.isCollection() == false)
                    {
                      Out.println("       else if (v.length() > " + C._Size + ")");
                      Out.println("        throw new Exception(\"Cannot set " + C.getFullName() + ": the size \"+v.length()+\" is larger than the max allowed of " + C._Size + ": \"+TextUtil.escapeDoubleQuoteWithSlash(TextUtil.toMaxLength(v, 250)));");
                    }
                  if (C.isSet() == true)
                    Out.println("       else if (_" + C.getName() + ".contains(v) == false)");
                  else if (C.isList() == true)
                    Out.println("       else if (pos >= _" + C.getName() + ".size() || _" + C.getName() + ".get(pos).equals(v) == false)");
                  else
                    Out.println("       else if (v.equals(_" + C.getName() + ") == false)");
                  Out.println("        {");
                  if (C.getType() == ColumnType.STRING && C.isCollection() == false)
                    {
                      if (C._Protect == ProtectionType.ABSOLUTE)
                        Out.println("          v = HTMLFilter.cleanAbsolute(v);");
                      else if (C._Protect == ProtectionType.SMART)
                        Out.println("          v = HTMLFilter.cleanSmart(" + TextUtil.escapeDoubleQuoteWithSlash(C.getFullName()) + ",v);");
                    }
                  break;
                case BINARY:
                  break;
                default:
                  throw new Error("ERROR! Cannot match ColumnType " + C.getType() + " when generating a setter");
              }

            if (C._Invariant == true || C._ParentObject.getLifecycle() != ObjectLifecycle.NORMAL)
              {
                Out.println("          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)");
                Out.println("           throw new Exception(\"Cannot set field '" + C.getFullName() + "' that is invariant, or part of a read-only or pre-existing WORM object.\");");
              }
            if (C._Mode != ColumnMode.CALCULATED)
              {
                Out.println("          __Changes.or(" + Mask + ");");
                Out.println("          __Nulls.andNot(" + Mask + ");");
              }
            if (C.isCollection() == false)
             Out.println("       _" + C.getName() + " = v;");
            else if (C.isList() == true)
              Out.println("          _" + C.getName() + ".add(pos, v);");
            else if (C.isSet() == true)
              Out.println("          _" + C.getName() + ".add(v);");
            if (C._Mapper != null)
              {
                String ClassName = Helper.getFullAppFactoryClassName(C._Mapper._DestObjectObj);
                StringBuilder Str = new StringBuilder();
                for (int c = 0; c < C._Mapper._SrcColumnObjs.size() - 1; ++c)
                  {
                    Column col = C._Mapper._SrcColumnObjs.get(c);
                    if (c != 0)
                      Str.append(", ");
                    Str.append("get" + TextUtil.capitalizeFirstCharacter(col.getName()) + "()");
                  }

                if (C._Mapper._Name != ColumnMapperMode.NONE)
                  Out.println("          " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.capitalizeFirstCharacter(C.getName()) + "MappedName(" + ClassName + ".getMappedName(" + Str + ", v));");
                if (C._Mapper._Group != ColumnMapperMode.NONE)
                  Out.println("          " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.capitalizeFirstCharacter(C.getName()) + "MappedGroup(" + ClassName + ".getMappedGroup(" + Str + ", v));");
              }
            if (C.needsTZ() == true)
              {
                Out.println("          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());");
                Out.println("          if (ZI == null)");
                Out.println("           throw new Exception(\"Cannot set field '" + C.getFullName() + "' because the timezone value '\"+v.getZone().getId()+\"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
                if (C.isCollection() == true && C._TzMode.isColumn() == true)
                  Out.println("          addTo" + TextUtil.capitalizeFirstCharacter(C.getTZName()) + "(pos, ZI.getId());");
                else
                  Out.println("          set" + TextUtil.capitalizeFirstCharacter(C.getTZName()) + "(ZI.getId());");
              }
            if (C.getType() != ColumnType.BINARY)
              Out.println("        }");
            Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
            Out.println("     }");

            if (C.isCollection() == true)
              {
                Out.println("   " + Visibility + " void removeFrom" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldTypeBaseClass(C) + " v) throws Exception");
                Out.println("     {");
                Out.println("       long T0 = System.nanoTime();");
                if (C._Mode != ColumnMode.CALCULATED)
                  {
                    if (C.needsTZ() == true)
                      {
                        Out.println("       int i = _" + C.getName() + ".indexOf(v);");
                        Out.println("       if (1 != -1)");
                        Out.println("        {");
                        Out.println("          _" + C.getName() + ".remove(i);");
                        if (C._TzMode.isColumn() == true)
                          Out.println("          removeFrom" + TextUtil.capitalizeFirstCharacter(C.getTZName()) + "(i);");
                        Out.println("          __Changes.or(" + Mask + ");");
                        Out.println("        }");
                      }
                    else
                      {
                        Out.println("       if (_" + C.getName() + ".remove(v) == true)");
                        Out.println("          __Changes.or(" + Mask + ");");
                      }
                  }
                else
                  Out.println("       _" + C.getName() + ".remove(v);");
                Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
                Out.println("     }");
              }
            if (C.isList() == true)
              {
                Out.println("   " + Visibility + " void removeFrom" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(int pos) throws Exception");
                Out.println("     {");
                Out.println("       long T0 = System.nanoTime();");
                if (C._Mode != ColumnMode.CALCULATED)
                  {
                    Out.println("       if (_" + C.getName() + ".remove(pos) != null)");
                    Out.println("        {");
                    Out.println("          __Changes.or(" + Mask + ");");
                    if (C.needsTZ() == true && C._TzMode.isColumn() == true)
                      Out.println("          removeFrom" + TextUtil.capitalizeFirstCharacter(C.getTZName()) + "(pos);");
                    Out.println("        }");
                  }
                else
                  Out.println("       _" + C.getName() + ".remove(pos);");
                Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
                Out.println("     }");
              }
          }
        else
          {
            if (C.isCollection() == true)
              Out.println("   " + Visibility + " void set" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(List<" + C._JsonSchema._TypeName + "> v) throws Exception");
            else
              Out.println("   " + Visibility + " void set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "(" + C._JsonSchema._TypeName + " v) throws Exception");
            Out.println("     {");
            Out.println("       long T0 = System.nanoTime();");
            if (C._Invariant == true || C._ParentObject.getLifecycle() != ObjectLifecycle.NORMAL)
              {
                Out.println("       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP && __Init != null)");
                Out.println("        throw new Exception(\"Cannot set field '" + C.getFullName() + "' that is invariant, or part of a read-only or pre-existing WORM object.\");");
              }
            Out.println("       if (v == null " + (C.isCollection() == true && C._Nullable == true ? " || v.isEmpty() == true" : "") + ")");
            if (C._Nullable == true)
              Out.println("        setNull" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "();");
            else
              Out.println("        throw new Exception(\"Cannot set " + C.getFullName() + " to null: it's not nullable.\");");
            Out.println("       else");
            Out.println("        {");
            Out.println("          __Changes.or(" + Mask + ");");
            Out.println("          __Nulls.andNot(" + Mask + ");");
            Out.println("          Gson gson = new GsonBuilder().setPrettyPrinting().create();");
            Out.println("          _" + C.getName() + " = gson.toJson(v, LIST_TYPE_" + C._JsonSchema._TypeName + ");");
            Out.println("          _" + C.getName() + "Obj = v;");
            Out.println("        }");
            Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
            Out.println("     }");
          }

        if (C.isJSONColumn() == true && C.getVisibility() != VisibilityType.PUBLIC && C._Invariant == true)
          {
            Out.println();
            Out.println("   /**");
            Out.println("    * Being invariant, the field " + C.getName() + " doesn't have a public setter. To support deserialization however, ");
            Out.println("    * we may need to set that field after a create/deserialization and before any write. The init methods allows");
            Out.println("    * to do so.");
            Out.println("   */");
            Out.println("   public void init" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldType(C) + " v) throws Exception");
            Out.println("     {");
            Out.println("       set" + TextUtil.capitalizeFirstCharacter(C.getName()) + "(v);");
            Out.println("     }");
          }
      }

    @Override
    public void genMethodSetAs(PrintWriter Out, GeneratorSession G, ColumnValue V)
      {
        String ValueNameVar = "_" + V._ParentColumn.getName() + TextUtil.capitalizeFirstCharacter(V._Name);
        Out.println("   public void set" + TextUtil.capitalizeFirstCharacter(V._ParentColumn.getName()) + TextUtil.capitalizeFirstCharacter(V._Name) + "() throws Exception");
        switch (V._ParentColumn.getType())
          {
            case BOOLEAN:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INTEGER:
            case SHORT:
            case NUMERIC:
            case LONG:
            case STRING:
            case UUID:
              if (V._ParentColumn.isCollection() == false)
                Out.println("      { set" + TextUtil.capitalizeFirstCharacter(V._ParentColumn.getName()) + "(" + ValueNameVar + "); }");
              else
                Out.println("      { addTo" + TextUtil.capitalizeFirstCharacter(V._ParentColumn.getName()) + "(" + ValueNameVar + "); }");
              break;
            case DATETIME:
            case DATE:
              if (V._ParentColumn.isCollection() == false)
                {
                  Out.println("      { set" + TextUtil.capitalizeFirstCharacter(V._ParentColumn.getName()) + "(" + ValueNameVar + "); }");
                  break;
                }
              throw new Error("An invalid type '" + V._ParentColumn.getType() + "' was assigned column values for code gen for column " + V._ParentColumn.getName() + " as a SET or LIST.");
            case BINARY:
            case BITFIELD:
            case JSON:
              throw new Error("An invalid type '" + V._ParentColumn.getType() + "' was assigned column values for code gen for column " + V._ParentColumn.getName() + ".");
            default:
              throw new Error("Unhandled case in switch for type '" + V._ParentColumn.getType() + "'.");
          }
      }


    @Override
    public void genMethodSetDateTimeNow(PrintWriter Out, GeneratorSession G, Column C)
      {
        String Visibility = Helper.getVisibility(C, true);
        Out.println("   " + Visibility + " final void set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "Now() throws Exception");
        Out.println("    {");
        Out.println("      set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "(DateTimeUtil.NOW_PLACEHOLDER_ZDT);");
        Out.println("    }");
      }

    @Override
    public void genMethodSetDateTimeUndefined(PrintWriter Out, GeneratorSession G, Column C)
      {
        String Visibility = Helper.getVisibility(C, true);
        Out.println("   " + Visibility + " final void set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "Undefined() throws Exception");
        Out.println("    {");
        Out.println("      set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);");
        Out.println("    }");
      }

    @Override
    public void genMethodSetDateTimeExplicit(PrintWriter Out, GeneratorSession G, Column C)
      {
        String Visibility = Helper.getVisibility(C, true);
        Out.println("   " + Visibility + " final void set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception");
        Out.println("    {");
        Out.println("      set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "(DateTimeUtil.newTZ(year, month, date, hourOfDay, minute, second, millis, z));");
        Out.println("    }");
      }


    @Override
    public void genMethodSetNull(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        String Mask = Helper.getRuntimeMask(C);
        String Visibility = Helper.getVisibility(C, true);

        Out.println("   " + Visibility + (C._FCT == FrameworkColumnType.OCC_DELETED || C._FCT == FrameworkColumnType.OCC_LASTUPDATED ? " final" : "") + " void setNull" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "()");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        if (C._Mode != ColumnMode.CALCULATED)
          {
            // If the set method was called explicitly, we have to make sure the "changes" flag is set, even if the column was null by default.
            Out.println("       __Changes.or(" + Mask + ");");
            Out.println("       if (__Nulls.intersects(" + Mask + ") == true) // already NULL");
            Out.println("        return;");
            Out.println("       __Nulls.or(" + Mask + ");");
          }

        // if (C.isCollection() == true)
        Out.println("       _" + C.getName() + "=null;");
        // else
        // Out.println(" _" + C.getName() + "=" + C.getType().getDefaultNullValue() + ";");
        if (C.needsTZ() == true)
          if (C._TzMode.isColumn() == true)
            Out.println("       setNull" + TextUtil.capitalizeFirstCharacter(C.getTZName()) + "();");
          else
            Out.println("    // setNull" + TextUtil.capitalizeFirstCharacter(C.getTZName()) + "(); // row TZs are shared, so can't just null it!");
        Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
        Out.println("     }");
      }

    @Override
    public void genMethodHasChanged(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        String Mask = Helper.getRuntimeMask(C);
        Out.println("   public boolean hasChanged" + TextUtil.capitalizeFirstCharacter(C.getName()) + "()");
        Out.println("     { return __Changes.intersects(" + Mask + "); }");
      }

    @Override
    public void genMethodIsNull(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        String Mask = Helper.getRuntimeMask(C);
        Out.println("   public final boolean isNull" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "()");
        Out.println("     { return __Nulls.intersects(" + Mask + "); }");
      }

    @Override
    public void genMethodTouch(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        if (C != null)
          {
            Out.println("   public final boolean touch(Connection C) throws Exception");
            Out.println("     {");
            Out.println("       set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + "Now();");
            Out.println("       return write(C);");
            Out.println("     }");
          }
        else
          {
            Out.println("   public abstract boolean touch(Connection C) throws Exception;");
          }
      }

    public void genTimestampSignature(PrintWriter Out, Object O)
      {
        Out.println("   protected String getTimeStampSignature() throws Exception");
        Out.println("     {");
        Out.println("       StringBuilder S = new StringBuilder(1024);");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED && (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN) && C.isCollection() == false)
            {
              String Mask = Helper.getRuntimeMask(C);
              Out.println("       if (__Changes.intersects(" + Mask + ") == true) S.append(DateTimeUtil.isNowPlaceholder(_" + C.getName() + ") == true ? \"C\" : \"X\");");
            }
        Out.println("       return S.toString();");
        Out.println("     }");
      }


    protected static void genWriteQuery(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println("   protected String getWriteQuery(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       StringBuilder S = new StringBuilder(1024);");
        Out.println();
        Out.println("       if (__Init == InitMode.CREATE)");
        Out.println("        {");
        Out.println("          StringBuilder V = new StringBuilder(1024);");
        Out.println("          S.append(\"insert into \"); " + Helper.getFullTableVarAtRuntime(O) + ";");
        Out.println("          int Pos = S.length();");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              if (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN)
                Out.println();
              Out.print("          if (__Changes.intersects(" + Mask + ") == true) { " + Helper.getRuntimeInsertStr(C) + ";");
              switch (C.getType())
                {
                  case DATE:
                  case DATETIME:
                  case DATETIME_PLAIN:
                    Out.println();
                    Out.println("             V.append(" + (C.isCollection() == false ? "__Nulls.intersects(" + Mask + ") == false && DateTimeUtil.isNowPlaceholder(_" + C.getName() + ") == true ? C.getCommaCurrentTimestamp() : " : "") + Helper.getSupportClassFullName(O._ParentSchema) + "._COMMAQUESTION);");
                    Out.println("           }");
                    if (C._DefaultCreateValue != null)
                      {
                        Out.print("          else { " + Helper.getRuntimeInsertStr(C) + "; V.append(" + Helper.getTimestampDefaultComma(C, C._DefaultCreateValue) + "); }");
                      }
                    break;
                  case JSON:
                    Out.println(" V.append(\",\").append(C.getJsonParametrizedQueryPlaceHolder()); }");
                    break;
                  case BINARY:
                  case BITFIELD:
                  case BOOLEAN:
                  case CHAR:
                  case DOUBLE:
                  case FLOAT:
                  case INTEGER:
                  case SHORT:
                  case LONG:
                  case STRING:
                  case NUMERIC:
                  case UUID:
                    Out.println(" V.append(" + Helper.getSupportClassFullName(O._ParentSchema) + "._COMMAQUESTION);  }");
                    break;
                  default:
                    throw new Error("ERROR! Cannot match ColumnType " + C.getType() + " when generating a Write method");
                }
            }
        Out.println();
        Out.println("          S.setCharAt(Pos, '(');");
        Out.println("          V.setCharAt(0, '(');");
        Out.println("          S.append(\") values \").append(V).append(')');");
        Out.println("          V.setLength(0);");
        Out.println("          V = null;");
        Out.println("        }");
        Out.println("       else // InitMode can be anything else");
        Out.println("        {");
        Out.println("          S.append(\"update \"); " + Helper.getFullTableVarAtRuntime(O) + "; S.append(\" set\");");
        Out.println("          int Pos = S.length();");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              if (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN)
                Out.println();
              switch (C.getType())
                {
                  case DATE:
                  case DATETIME:
                  case DATETIME_PLAIN:
                    Out.println("          if (__Changes.intersects(" + Mask + ") == true)");
                    Out.println("           {");
                    if (C.isCollection() == false)
                      {
                        Out.println("             if (__Nulls.intersects(" + Mask + ") == false && DateTimeUtil.isNowPlaceholder(_" + C.getName() + ") == true)");
                        Out.println("              { " + Helper.getRuntimeInsertStr(C) + "; S.append(C.getEqualCurrentTimestamp()); }");
                        Out.println("             else");
                      }
                    Out.println("              " + Helper.getRuntimeUpdateStr(C) + ";");
                    Out.println("           }");
                    if (C._DefaultUpdateValue != null)
                      {
                        Out.println("          else ");
                        Out.println("           {");
                        Out.println("             " + Helper.getRuntimeInsertStr(C) + "; S.append(" + Helper.getTimestampDefaultEqual(C, C._DefaultUpdateValue) + ");");
                        Out.println("             " + Helper.getTimestampDefaultSetter(C, C._DefaultUpdateValue));
                        Out.println("           }");
                      }
                    break;
                  case JSON:
                    // String MethodName = TextUtil.CapitalizeFirstCharacter(C.getName()) + TextUtil.CapitalizeFirstCharacter(C._DefaultUpdateValue._Name);
                    // Out.println(" if ((" + Mask + Pad + " & __Changes) == 0L) set" + MethodName + "();");
                    // Out.println(" S.append(" + Helper.getRuntimeUpdateStr(C) + ");");
                    // Out.println(" V.append(\",cast(? as "+G.getSql().getColumnTypeRaw(C, false)+")\"); }");
                    // break;
                  case BINARY:
                  case BITFIELD:
                  case BOOLEAN:
                  case CHAR:
                  case FLOAT:
                  case DOUBLE:
                  case INTEGER:
                  case SHORT:
                  case NUMERIC:
                  case LONG:
                  case STRING:
                  case UUID:
                    if (C._DefaultUpdateValue == null)
                      Out.println("          if (__Changes.intersects(" + Mask + ") == true) " + Helper.getRuntimeUpdateStr(C) + ";");
                    else
                      {
                        String MethodName = TextUtil.capitalizeFirstCharacter(C.getName()) + TextUtil.capitalizeFirstCharacter(C._DefaultUpdateValue._Name);
                        Out.println("          if (__Changes.intersects(" + Mask + ") == false) set" + MethodName + "();");
                        Out.println("          " + Helper.getRuntimeUpdateStr(C) + ";");
                      }

                    break;
                  default:
                    throw new Error("ERROR! Cannot match ColumnType " + C.getType() + " when generating a Write method");
                }
            }
        Out.println();
        Helper.SwitchLookupIdWhereClauses(Out, G, O, "          ", true);
        Out.println("          S.setCharAt(Pos, ' ');");
        Out.println("        }");
        Out.println();
        Out.println("       String Q = S.toString();");
        Out.println("       S.setLength(0);");
        Out.println("       S = null;");
        Out.println("       QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, Q);");
        Out.println("       QueryDetails.logQuery(\"" + O.getShortName() + "\", Q, toString());");
        Out.println();
        Out.println("       return Q;");
        Out.println("     }");
      }

    private static void genWritePreparedStatementPopulation(PrintWriter Out, Object O)
    throws Error
      {
        Out.println("   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception");
        Out.println("     {");
        Out.println("       int i = 0;");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String Mask = Helper.getRuntimeMask(C);
              // String Pad = O._PadderColumnNames.getPad(C.getName());
              Out.println("       if (__Changes.intersects(" + Mask + ") == true) ");
              Out.println("        { ");
              Out.print("          if (__Nulls.intersects(" + Mask + ") == true) PS.setNull(++i, " + (C.isCollection() == true ? "C.supportsArrays()?java.sql.Types.ARRAY:" : "") + "java.sql.Types." + JavaJDBCType.get(C.getType())._JDBCSQLType + ");");
              switch (C.getType())
                {
                  case DATE:
                    Out.print(" else ");
                    if (C.isCollection() == false)
                      Out.println("if (DateTimeUtil.isNowPlaceholder(_" + C.getName() + ") == false)  PS.setDate(++i, java.sql.Date.valueOf(_" + C.getName() + "));");
                    else
                      Out.println("C.setArray(PS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + ".getType(), AllocatedArrays, _" + C.getName() + ");");
                    break;
                  case DATETIME:
                    Out.print(" else ");
                    if (C.isCollection() == false)
                      Out.println("if (DateTimeUtil.isNowPlaceholder(_" + C.getName() + ") == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_" + C.getName() + ".toInstant()), DateTimeUtil._UTC_CALENDAR);");
                    else
                      Out.println("C.setArray(PS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + ".getType(), AllocatedArrays, DateTimeUtil.toSQLTimeStamps(_" + C.getName() + "));");
                    break;
                  case DATETIME_PLAIN:
                    Out.print(" else ");
                    if (C.isCollection() == false)
                      Out.println("if (DateTimeUtil.isNowPlaceholder(_" + C.getName() + ") == false) PS.setTimestamp(++i, java.sql.Timestamp.from(_" + C.getName() + ".toInstant()));");
                    else
                      Out.println("C.setArray(PS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + ".getType(), AllocatedArrays, DateTimeUtil.toSQLTimeStamps(_" + C.getName() + "));");
                    break;
                  case JSON:
                  case VECTOR:
                    Out.println(" else PS.set" + JavaJDBCType.get(C.getType())._JDBCType + "(++i, " + (C.getType() == ColumnType.CHAR ? "\"\"+" : "") + "_" + C.getName() + ");");
                    break;
                  case UUID:
                    Out.print(" else ");
                    if (C.isCollection() == false)
                      Out.println("PS.set" + JavaJDBCType.get(C.getType())._JDBCType + "(++i, _" + C.getName() + ", java.sql.Types." + JavaJDBCType.get(C.getType())._JDBCSQLType + ");");
                    else
                      Out.println("C.setArray(PS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + ".getType(), AllocatedArrays, _" + C.getName() + ");");
                    break;
                  case BINARY:
                  case BITFIELD:
                  case BOOLEAN:
                  case DOUBLE:
                  case FLOAT:
                  case SHORT:
                  case NUMERIC:
                  case INTEGER:
                  case LONG:
                  case CHAR:
                  case STRING:
                    Out.print(" else ");
                    if (C.isCollection() == false)
                      Out.println("PS.set" + JavaJDBCType.get(C.getType())._JDBCType + "(++i, " + (C.getType() == ColumnType.CHAR ? "\"\"+" : "") + "_" + C.getName() + ");");
                    else
                      Out.println("C.setArray(PS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + ".getType(), AllocatedArrays, _" + C.getName() + ");");
                    break;
                  default:
                    throw new Error("ERROR! Cannot match ColumnType " + C.getType() + " when generating a Write method");
                }
              Out.println("        } ");
            }
        Out.println("       return i;");
        Out.println("     }");
      }

    private static void genPostWriteObjectStateUpdate(PrintWriter Out, Object O)
      {
        Out.println("   protected void stateUpdatePostWrite() throws Exception");
        Out.println("     {");
        Out.println("       if (__Init == InitMode.CREATE)");
        Out.println("        {");
        Out.println("          __Init = InitMode.WRITTEN;");
        Out.println("          __LookupId = 0;");
        Out.println("        }");
        Out.println("       else");
        Out.println("        {");
        Out.println("          __Init = __Init == InitMode.READ ? InitMode.READ_WRITTEN : InitMode.WRITTEN;");
        Out.println("        }");
        Out.println();
        Helper.setSavedFields(Out, O);
        Out.println();
        Out.println("       __Changes.clear();");
        // Out.println(" __Nulls.clear();");
        Out.println("     }");
      }


    private void genValidateDeserialization(PrintWriter Out, Object O)
      {
        Out.println("   protected void validateDeserialization() throws Exception");
        Out.println("     {");
        for (Column C : O._Columns)
          {
            if (C == null || C.isJSONColumn() == false)
              continue;

            String Mask = Helper.getRuntimeMask(C);
            Out.println();

            if (C._Nullable == false)
              {
                if (C.isCollection() == false && C.getType() == ColumnType.STRING)
                  {
                    if (C._AllowEmpty == true)
                      Out.println("       if (_" + C.getName() + " == null)");
                    else
                      Out.println("       if (TextUtil.isNullOrEmpty(_" + C.getName() + ") == true)");
                  }
                else if (C.isCollection() == false && (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN))
                  Out.println("       if (TextUtil.isNullOrEmpty(Str_" + C.getName() + ") == true)");
                else if (C.isCollection() == true)
                  Out.println("       if (_" + C.getName() + (C._JsonSchema == null ? "" : "Obj") + " == null || _" + C.getName() + (C._JsonSchema == null ? "" : "Obj") + ".isEmpty() == true)");
                else
                  Out.println("       if (_" + C.getName() + (C._JsonSchema == null ? "" : "Obj") + " == null)"); // || _" + C.getName() + " == " +
                                                                                                                  // C.getType().getDefaultNullValue() + ")");

                if (C._DefaultCreateValue == null)
                  Out.println("        throw new Exception(\"Incoming value for '" + C.getFullName() + "' was null or empty. It's not nullable in the model.\\n\"+toString());");
                else
                  Out.println("        _" + C.getName() + "=" + ValueHelper.printValueJava(C.getName(), C.getType(), C.isCollection(), C._DefaultCreateValue._Value, C.getName()) + ";");
                validateHousekeeping(Out, C, Mask);
              }

            if (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN)
              {
                if (C._Nullable == true)
                  {
                    Out.println("       if (TextUtil.isNullOrEmpty(Str_" + C.getName() + ") == false)");
                  }
                Out.println("        {");
                String ExtraPad = C._Nullable == true ? "   " : "";
                Out.println(ExtraPad + "       _" + C.getName() + " = DateTimeUtil.parsefromJSON(Str_" + C.getName() + ");");
                Out.println(ExtraPad + "       if (   _" + C.getName() + " == null)");
                Out.println(ExtraPad + "        throw new Exception(\"Incoming value for '" + C.getFullName() + "' was not in the expected format. Dates should follow the ISO format.\\n\"+toString());");
                Out.println(ExtraPad + "       __Changes.or(" + Mask + ");");
                Out.println(ExtraPad + "       __Nulls.andNot(" + Mask + ");");
                if (C.needsTZ() == true)
                  {
                    if (C.isCollection() == true)
                      {
                        Out.println(ExtraPad + "       for (int pos = 0; pos < _" + C.getName() + ".size(); ++pos)");
                        Out.println(ExtraPad + "         {");
                      }
                    if (C.getType() == ColumnType.DATETIME)
                      Out.println(ExtraPad + "       String zoneId = _" + C.getName() + (C.isCollection() == true ? ".get(pos)" : "") + ".getZone().getId();");
                    else
                      Out.println(ExtraPad + "       String zoneId = _" + C.getTZName() + (C.isCollection() == true && C._TzMode.isColumn() == true ? ".get(pos)" : "") + ";");

                    Out.println(ExtraPad + "       tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(zoneId);");
                    Out.println(ExtraPad + "       if (ZI == null)");
                    Out.println(ExtraPad + "        throw new Exception(\"Cannot set field '" + C.getFullName() + "' because the timezone value '\"+zoneId+\"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
                    if (C.isCollection() == true && C._TzMode.isColumn() == true)
                      Out.println("          addTo" + TextUtil.capitalizeFirstCharacter(C.getTZName()) + "(pos, ZI.getId());");
                    else
                      Out.println("          set" + TextUtil.capitalizeFirstCharacter(C.getTZName()) + "(ZI.getId());");
                    if (C.isCollection() == true)
                      {
                        Out.println(ExtraPad + "         }");
                      }
                  }
                Out.println("        }");
              }
            else if (C._Nullable == true)
              {
                if (C.isCollection() == false && C.getType() == ColumnType.STRING)
                  Out.println("       if (TextUtil.isNullOrEmpty(_" + C.getName() + ") == false)");
                else if (C.isCollection() == false && (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN))
                  Out.println("       if (TextUtil.isNullOrEmpty(Str_" + C.getName() + ") == false)");
                else if (C.isCollection() == true)
                  Out.println("       if (_" + C.getName() + (C._JsonSchema == null ? "" : "Obj") + " != null && _" + C.getName() + (C._JsonSchema == null ? "" : "Obj") + ".isEmpty() == false)");
                else
                  Out.println("       if (_" + C.getName() + (C._JsonSchema == null ? "" : "Obj") + " != null)");
                Out.println("        {");
                validateHousekeeping(Out, C, Mask);
                Out.println("        }");
              }
            if (O._FST == FrameworkSourcedType.MAPPER && C.getName().equals("group") == true)
              {
                Out.println("       if (TextUtil.findElement(" + Helper.getFullAppDataClassName(O) + "._" + C.getName() + "_Values, _" + C.getName() + ", 0, true, 0) == -1)");
                Out.println("        throw new Exception(\"Invalid value " + C.getName() + "='\"+_" + C.getName() + "+\"'. As per the model, valid values are: \"+TextUtil.print(" + Helper.getFullAppDataClassName(O) + "._"
                + C.getName() + "_Values, 0)+\".\\n\"+toString());");
              }
          }
        Out.println("     }");
      }

    protected void validateHousekeeping(PrintWriter Out, Column C, String Mask)
      {
        Out.println("          __Changes.or(" + Mask + ");");
        Out.println("          __Nulls.andNot(" + Mask + ");");
        if (C._JsonSchema != null)
          {
            Out.println("          Gson gson = new GsonBuilder().setPrettyPrinting().create();");
            Out.println("          _" + C.getName() + " = gson.toJson(_" + C.getName() + "Obj, LIST_TYPE_" + C._JsonSchema._TypeName + ");");
          }
        if (C._Mapper != null)
          {
            if (C._Mapper._Name == ColumnMapperMode.DB)
              {
                Column SecondaryC = C._ParentObject.getColumn(C.getName() + "MappedName");
                String SecondaryMask = Helper.getRuntimeMask(SecondaryC);
                Out.println("          __Changes.or(" + SecondaryMask + ");");
                Out.println("          __Nulls.andNot(" + SecondaryMask + ");");
              }
            if (C._Mapper._Group == ColumnMapperMode.DB)
              {
                Column SecondaryC = C._ParentObject.getColumn(C.getName() + "MappedGroup");
                String SecondaryMask = Helper.getRuntimeMask(SecondaryC);
                Out.println("          __Changes.or(" + SecondaryMask + ");");
                Out.println("          __Nulls.andNot(" + SecondaryMask + ");");
              }
            if (C.isCollection() == true)
              {
                if (C._Mapper._Name != ColumnMapperMode.NONE)
                  Out.println("          _" + C.getName() + "MappedName = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">();");
                if (C._Mapper._Group != ColumnMapperMode.NONE)
                  Out.println("          _" + C.getName() + "MappedGroup = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">();");
              }

            String ClassName = Helper.getFullAppFactoryClassName(C._Mapper._DestObjectObj);
            StringBuilder Str = new StringBuilder();
            for (int c = 0; c < C._Mapper._SrcColumnObjs.size() - 1; ++c)
              {
                Column col = C._Mapper._SrcColumnObjs.get(c);
                if (c != 0)
                  Str.append(", ");
                Str.append("get" + TextUtil.capitalizeFirstCharacter(col.getName()) + "()");
              }
            if (C.isCollection() == true)
              {
                Out.println("          for (" + JavaJDBCType.getFieldTypeBase(C) + " i : _" + C.getName() + ")");
                Out.println("           {");
              }
            if (C._Mapper._Name != ColumnMapperMode.NONE)
              Out.println("             " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.capitalizeFirstCharacter(C.getName()) + "MappedName(" + ClassName + ".getMappedName(" + Str + ", " + (C.isCollection() == true ? "i" : "_" + C.getName()) + "));");
            if (C._Mapper._Group != ColumnMapperMode.NONE)
              Out.println("             " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.capitalizeFirstCharacter(C.getName()) + "MappedGroup(" + ClassName + ".getMappedGroup(" + Str + ", " + (C.isCollection() == true ? "i" : "_" + C.getName()) + "));");
            if (C.isCollection() == true)
              {
                Out.println("           }");
              }
          }
        if (C._Enum != null && C._Enum._Name != ColumnMapperMode.NONE)
          {
            if (C._Enum._Name == ColumnMapperMode.DB)
              {
                Column SecondaryC = C._ParentObject.getColumn(C.getName() + "EnumValue");
                String SecondaryMask = Helper.getRuntimeMask(SecondaryC);
                Out.println("          __Changes.or(" + SecondaryMask + ");");
                Out.println("          __Nulls.andNot(" + SecondaryMask + ");");
              }
            String ClassNameFactory = Helper.getFullAppFactoryClassName(C._Enum._DestObjectObj);
            String ClassNameData = Helper.getFullAppDataClassName(C._Enum._DestObjectObj);
            if (C.isList() == true)
              {
                Out.println("          _" + C.getName() + "EnumValue = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">();");
                Out.println("          for (int i = 0; i < _" + C.getName() + ".size(); ++i)");
                Out.println("           {");
                Out.println("             String v = _" + C.getName() + ".get(i);");
                Out.println("             " + ClassNameData + " d = " + ClassNameFactory + ".getEnumerationById(v);");
                Out.println("             if (d == null)");
                Out.println("              throw new Exception(\"Cannot set " + C.getFullName() + ": the value \'\"+v+\"\' is not a valid Enumerated value as per \'" + ClassNameFactory + "\'.\");");
                Out.println("             addTo" + TextUtil.capitalizeFirstCharacter(C.getName()) + "EnumValue(i, d.getValue());");
                Out.println("           }");
              }
            else if (C.isSet() == true)
              {
                Out.println("          _" + C.getName() + "EnumValue = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">();");
                Out.println("          for (String v : _" + C.getName() + ")");
                Out.println("           {");
                Out.println("             " + ClassNameData + " d = " + ClassNameFactory + ".getEnumerationById(v);");
                Out.println("             if (d == null)");
                Out.println("              throw new Exception(\"Cannot set " + C.getFullName() + ": the value \'\"+v+\"\' is not a valid Enumerated value as per \'" + ClassNameFactory + "\'.\");");
                Out.println("             addTo" + TextUtil.capitalizeFirstCharacter(C.getName()) + "EnumValue(d.getValue());");
                Out.println("           }");
              }
            else
              {
                Out.println("          " + ClassNameData + " d = " + ClassNameFactory + ".getEnumerationById(_" + C.getName() + ");");
                Out.println("          if (d == null)");
                Out.println("           throw new Exception(\"Cannot set " + C.getFullName() + ": the value \'\"+_" + C.getName() + "+\"\' is not a valid Enumerated value as per \'" + ClassNameFactory + "\'.\");");
                Out.println("          set" + TextUtil.capitalizeFirstCharacter(C.getName()) + "EnumValue(d.getValue());");
              }
          }
        /*
         * for (int i = 0; i < _categories.size(); ++i)
         * {
         * String v = _categories.get(i);
         * com.capsico.forms.data.FormCategory_Data d = com.capsico.forms.data.FormCategory_Factory.getEnumerationById(v);
         * if (d == null)
         * throw new Exception("ccccc");
         * addToCategoriesEnumValue(i, v);
         * }
         * 
         */

      }

    private static void genColumnTestBoolean(PrintWriter Out, List<Column> cols)
      {
        boolean first = true;
        for (Column C : cols)
          if (C != null)
            {
              if (first == true)
                first = false;
              else
                Out.print(" && ");
              if (C.isCollection() == false && C.getType() == ColumnType.STRING)
                Out.print("TextUtil.isNullOrEmpty(_" + C.getName() + ") == false");
              else if (C.isCollection() == false && (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN))
                {
                  if (C.isJSONColumn() == true)
                    Out.print("TextUtil.isNullOrEmpty(Str_" + C.getName() + ") == false");
                  else
                    Out.print("_" + C.getName() + " != null");
                }
              else if (C.isCollection() == true)
                Out.print("_" + C.getName() + " != null && _" + C.getName() + ".isEmpty() == false");
              else
                Out.print("_" + C.getName() + " != null");
            }
      }

    private static void genLookupByCheck(PrintWriter Out, Object O)
      {
        Out.println("   /**");
        Out.println("   * Returns the first satisfied natural identify (i.e., unique indices), or if defined, the PK. by 'satisfied',");
        Out.println("   * we mean an identity whose columns have all been provided (i.e., not null). We prioritize natural identities");
        Out.println("   * over the PK since PKs are typically not stable across systems. For example, one might model a user with a PK");
        Out.println("   * but also an identify over an email address for example. That email address for a given logical user should be");
        Out.println("   * constant across multiple environments (e.g., a dev, staging or prod), where as a PK might be generated based");
        Out.println("   * on dynamic factors that are very likely to be different across systems.");
        Out.println("   */");
        Out.println("   protected int getFirstValidLookupBy() throws Exception");
        Out.println("     {");

        // If there is a primary key, it comes first (id=0), but we output the check for the PK if it exists, last.
        int LookupId = O._PrimaryKey == null ? -1 : 0;
        if (O._Indices != null)
          for (Index I : O._Indices)
            if (I != null && I._Unique == true)
              {
                Out.println();
                Out.println("       // Testing if cols for unique index " + I._Name + " were set - Id: " + (++LookupId));
                Out.print("       if (");
                genColumnTestBoolean(Out, I._ColumnObjs);
                Out.println(")");
                Out.println("        return " + LookupId + ";");
              }
        if (O._PrimaryKey != null)
          {
            Out.println();
            Out.println("       // Testing if primary key has been set - Id: 0"); // The primary key would always be the lkookip id 0
            Out.print("       if (");
            genColumnTestBoolean(Out, O._PrimaryKey._ColumnObjs);
            Out.println(")");
            Out.println("        return " + 0 + ";");
          }
        Out.println();
        Out.println("       return SystemValues.EVIL_VALUE;");
        Out.println("     }");
      }


    @Override
    public void genMethodWrite(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        Out.println("   public final boolean write(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        Out.println();
        Out.println("       if (__Init == null && __LookupId==0) // Loaded via some other mechamism, e.g., Json or CSV loader");
        Out.println("        {");
        Out.println("          validateDeserialization();");
        Out.println("          initForCreate();");
        if (O._PrimaryKey != null && O._PrimaryKey._Autogen == true)
          {
            Out.println("          // Auto PK");
            Column PK = O._PrimaryKey._ColumnObjs.get(0);
            Out.println("          set" + TextUtil.capitalizeFirstCharacter(PK.getName()) + "(tilda.db.KeysManager.getKey(" + TextUtil.escapeDoubleQuoteWithSlash(O.getShortName().toUpperCase()) + "));");
          }
        Out.println("        }");
        Out.println();
        Out.println("       if (hasChanged() == false)");
        Out.println("        {");
        Out.println("          LOG.debug(QueryDetails._LOGGING_HEADER + \"The " + O.getFullName() + " has not changed: no writing will occur.\");");
        Out.println("          QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("          return true;");
        Out.println("        }");
        if (O.hasAutos() == true)
          {
            Out.println();
            for (Column C : O._Columns)
              if (C != null && C._Mode == ColumnMode.AUTO && C._MapperDef == null && C._FCT.isManaged() == false)
                Out.println("       set" + TextUtil.capitalizeFirstCharacter(C.getName()) + "();");
          }
        Out.println();
        Out.println("       if (beforeWrite(C) == false)");
        Out.println("        {");
        Out.println("          LOG.debug(QueryDetails._LOGGING_HEADER + \"The " + O.getFullName() + " object's beforeWrite() failed.\");");
        Out.println("          QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("          return false;");
        Out.println("        }");
        Out.println();
        Out.println("       String Q = getWriteQuery(C);");
        Out.println();
        Out.println("       java.sql.PreparedStatement PS = null;");
        Out.println("       int count = 0;");
        Out.println("       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();");
        Out.println("       try");
        Out.println("        {");
        Out.println("          PS = C.prepareStatement(Q);");
        Out.println("          int i = populatePreparedStatement(C, PS, AllocatedArrays);");
        Out.println();
        Helper.SwitchLookupIdPreparedStatement(Out, G, O, "          ", true, false);
        Out.println();
        if (G.getSql().needsSavepoint() == true)
          {
            Out.println("          C.setSavepoint();");
          }
        Out.println("          count = PS.executeUpdate();");
        if (G.getSql().needsSavepoint() == true)
          {
            Out.println("          C.releaseSavepoint(true);");
          }
        Out.println("          if (count == 0)");
        Out.println("           return false;");
        Out.println("        }");
        Helper.CatchFinallyBlock(Out, O, "updated or inserted", "__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE", G.getSql().needsSavepoint(), false);
        Out.println();
        Out.println("       stateUpdatePostWrite();");
        Out.println("       return true;");
        Out.println("     }");
        Out.println();
        Out.println("   protected abstract boolean beforeWrite(Connection C) throws Exception;");
        Out.println();
        genValidateDeserialization(Out, O);
        genTimestampSignature(Out, O);
        genWriteQuery(Out, G, O);
        genWritePreparedStatementPopulation(Out, O);
        genPostWriteObjectStateUpdate(Out, O);
      }


    @Override
    public void genMethodUpsert(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        Out.println("   public final boolean upsert(Connection C, boolean updateFirst) throws Exception");
        Out.println("     {");
        Out.println("       boolean OK =    __Init == InitMode.CREATE && __NewlyCreated == true && __LookupId == SystemValues.EVIL_VALUE // Create() through factory");
        Out.println("                    || __Init == null && __LookupId==0 // Loaded via some deserialization mechamism, e.g., Json or CSV loader");
        Out.println("               ;");
        Out.println("       if (OK == false)");
        Out.println("        throw new Exception(\"Object has not been instanciated via deserialization or the factory create() method: __Init:\"+__Init+\"; __NewlyCreated:\"+__NewlyCreated+\"; __LookupId: \"+__LookupId+\";\");");
        Out.println();
        Out.println("       if (__Init == null && __LookupId==0)  // object deserialized");
        Out.println("        validateDeserialization();");
        Out.println();
        Out.println("       int lookupId = getFirstValidLookupBy();");
        Out.println("       if (lookupId == SystemValues.EVIL_VALUE)");
        Out.println("        throw new Exception(\"Object has not been intialized with sufficient data for any natural key to be available for a lookup.\");");
        Out.println();
        Out.println("       if (updateFirst == true)");
        Out.println("        {");
        Out.println("          initForLookup(lookupId);");
        Out.println("          if (write(C) == false)");
        Out.println("           {");
        Out.println("             initForCreate();");
        if (O._PrimaryKey != null && O._PrimaryKey._Autogen == true)
          {
            Out.println("             // Auto PK");
            Column PK = O._PrimaryKey._ColumnObjs.get(0);
            Out.println("             set" + TextUtil.capitalizeFirstCharacter(PK.getName()) + "(tilda.db.KeysManager.getKey(" + TextUtil.escapeDoubleQuoteWithSlash(O.getShortName().toUpperCase()) + "));");
          }
        Out.println("             return write(C);");
        Out.println("           }");
        Out.println("        }");
        Out.println("       else");
        Out.println("        {");
        Out.println("          initForCreate();");
        if (O._PrimaryKey != null && O._PrimaryKey._Autogen == true)
          {
            Out.println("          // Auto PK");
            Column PK = O._PrimaryKey._ColumnObjs.get(0);
            Out.println("          set" + TextUtil.capitalizeFirstCharacter(PK.getName()) + "(tilda.db.KeysManager.getKey(" + TextUtil.escapeDoubleQuoteWithSlash(O.getShortName().toUpperCase()) + "));");
          }
        Out.println("          if (write(C) == false)");
        Out.println("           {");
        Out.println("             initForLookup(lookupId);");
        if (O._PrimaryKey != null && O._PrimaryKey._Autogen == true)
          {
            Out.println("              // Undo auto PK");
            Column PK = O._PrimaryKey._ColumnObjs.get(0);
            Out.println("              __Changes.andNot(" + Helper.getRuntimeMask(PK) + ");");
          }
        Out.println("             return write(C);");
        Out.println("           }");
        Out.println("        }");
        Out.println();
        Out.println("       return true;");
        Out.println("     }");
        Out.println();
        genLookupByCheck(Out, O);
        Out.println();
      }


    @Override
    public void genMethodCopyTo(PrintWriter Out, GeneratorSession G, Object O, List<Column> CopyToColumns)
    throws Exception
      {
        Out.println("   public void copyTo(" + Helper.getFullBaseClassName(O) + " Dst) throws Exception");
        Out.println("     {");
        for (Column C : CopyToColumns)
          if (C != null)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              if (C._Nullable == true)
                Out.print("       if (__Nulls.intersects(" + Mask + ") == true || _" + C.getName() + Pad + "==null)\n"
                + "        Dst.setNull" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + Pad + "();\n"
                + "       else\n "); // extra space to indent next line
              else if (true == C._Invariant)
                {
                  Out.print("       if (__Init == InitMode.CREATE && _" + C.getName() + Pad + " != null)\n "); // extra space to indent next line
                }
              else
                {
                  Out.print("       if (_" + C.getName() + Pad + " != null)\n "); // extra space to indent next line
                }
              Out.println("       Dst.set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + Pad + "(_" + C.getName() + Pad + ");");

              if ((C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN) && C.isJSONColumn() == true)
                Out.println("       Dst.Str_" + C.getName() + " = Str_" + C.getName() + ";");
            }
        Out.println("     }");
        Out.println("\n");
        Out.println("   public " + Helper.getFullAppDataClassName(O) + " copy() throws Exception");
        Out.println("     {");
        Out.println("       " + Helper.getFullAppDataClassName(O) + " dst = new " + Helper.getFullAppDataClassName(O) + "();");
        Out.println("       copyTo(dst);");
        Out.println("       return dst;");
        Out.println("     }");
      }

    @Override
    public void genMethodCopyForHistory(PrintWriter Out, GeneratorSession G, Object obj, Object histObj)
    throws Exception
      {

        Out.println("   public " + Helper.getFullAppDataClassName(histObj) + " copyForHistory() throws Exception");
        Out.println("     {");
        Out.println("       boolean sigChanges = false;");
        Out.println();
        boolean first = true;
        for (Column C : obj._History._SignatureColumnObjs)
          if (C != null && C.isCopyToColumn() == true)
            {
              if (first == true)
                {
                  Out.print("            if");
                  first = false;
                }
              else
                Out.print("       else if");

              Out.println(" (hasChanged" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + obj._PadderColumnNames.getPad(C.getName()) + "() == true) sigChanges = true;");
            }
        Out.println();
        Out.println("       if (sigChanges == false)");
        Out.println("        return null;");
        Out.println();
        Out.print("       " + Helper.getFullAppDataClassName(histObj) + " dst = " + Helper.getFullAppFactoryClassName(histObj) + ".create(");
        boolean First = true;
        for (Column C : histObj.getCreateColumns())
          if (C != null && (C._PrimaryKey == false || histObj._PrimaryKey._Autogen == false))
            {
              if (First == true)
                First = false;
              else
                Out.print(", ");
              Out.print("_" + C.getName());
            }
        Out.println(");");

        for (Column C : histObj._Columns)
          if (C != null)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = histObj._PadderColumnNames.getPad(C.getName());
              if (C._Nullable == true)
                Out.print("       if (__Nulls.intersects(" + Mask + ") == true || _" + C.getName() + Pad + "==null)\n"
                + "        dst.setNull" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + Pad + "();\n"
                + "       else\n "); // extra space to indent next line
              else if (true == C._Invariant)
                {
                  Out.print("       if (__Init == InitMode.CREATE && _" + C.getName() + Pad + " != null)\n "); // extra space to indent next line
                }
              else
                {
                  Out.print("       if (_" + C.getName() + Pad + " != null)\n "); // extra space to indent next line
                }
              Out.println("       dst.set" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + Pad + "(_" + C.getName() + Pad + ");");

              if ((C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN) && C.isJSONColumn() == true)
                Out.println("       dst.Str_" + C.getName() + " = Str_" + C.getName() + ";");
            }
        Out.println("       return dst;");
        Out.println("     }");
        Out.println("\n");
      }

    @Override
    public void genMethodMask(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        Out.println("   public void maskMode(boolean val)");
        Out.println("     {");
        Out.println("       __MaskMode = val;");
        Out.println("     }");
        Out.println("   public boolean maskMode()");
        Out.println("     {");
        Out.println("       return __MaskMode;");
        Out.println("     }");

        /*
         * for (Column c : O._Columns)
         * if (TextUtil.isNullOrEmpty(c._Mask) == false)
         * {
         * String Pad = O._PadderColumnNames.getPad(c.getName());
         * Out.println("       set" + TextUtil.capitalizeFirstCharacter(c.getName()) + Pad + "(" + ValueHelper.printValueJava(c.getName(), c.getType(), c.isCollection(), c._Mask) +
         * ");");
         * }
         */
      }


    @Override
    public void genMethodRefresh(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println("   public final boolean refresh(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       return readOne(C, true);");
        Out.println("     }");
      }

    @Override
    public void genMethodRead(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println("   public final boolean read(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       return readOne(C, false);");
        Out.println("     }");
        Out.println();
        Out.println("   private final boolean readOne(Connection C, boolean Force) throws Exception");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        Out.println("       if (__Init == InitMode.CREATE)");
        Out.println("        throw new Exception(\"This " + O.getShortName() + " object is being read() after a create(), which doesn't make sense.\");");
        Out.println("       if (__Init == InitMode.READ == true && Force == false && hasChanged()==false)");
        Out.println("        {");
        Out.println("          LOG.debug(QueryDetails._LOGGING_HEADER + \"This " + O.getShortName() + " object has already been read.\");");
        Out.println("          QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("          return true;");
        Out.println("        }");
        Out.println("       StringBuilder S = new StringBuilder(1024);");
        Helper.SelectFrom(Out, O);
        Helper.SwitchLookupIdWhereClauses(Out, G, O, "       ", true);
        Out.println();
        Out.println("       String Q = S.toString();");
        Out.println("       S.setLength(0);");
        Out.println("       S = null;");
        Out.println("       QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, Q);");
        Out.println("       QueryDetails.logQuery(\"" + O.getShortName() + "\", Q, toString());");
        Out.println("       java.sql.PreparedStatement PS=null;");
        Out.println("       java.sql.ResultSet RS=null;");
        if (O.hasCollectionColumn() == true || O.hasCollectionQuery() == true)
          Out.println("       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();");
        Out.println("       int count = 0;");
        Out.println();
        Out.println("       try");
        Out.println("        {");
        Out.println("          PS = C.prepareStatement(Q);");

        StringBuilderWriter SBW = new StringBuilderWriter();
        Helper.SwitchLookupIdPreparedStatement(new PrintWriter(SBW), G, O, "          ", true, false);
        if (SBW.getBuilder().indexOf("++i") != -1)
          Out.println("          int i = 0;");
        Out.println(SBW.getBuilder().toString());
        Out.println();
        Out.println("          RS = PS.executeQuery();");
        Out.println("          if (RS.next() == false)");
        Out.println("            {");
        Out.println("              LOG.debug(QueryDetails._LOGGING_HEADER + \"   " + AnsiUtil.BOLD + "No record was read." + AnsiUtil.BOLD_OFF + "\");");
        Out.println("              return false;");
        Out.println("            }");
        Out.println("          count = 1;");
        Out.println("          return init(C, RS);");
        Out.println("        }");
        Helper.CatchFinallyBlock(Out, O, "selected", "StatementType.SELECT", false, false);
        Out.println("    }");
        Out.println();
        for (Column C : O._Columns)
          if (C != null && C.isCollection() == true)
            {
              Out.println("   @SuppressWarnings(\"unchecked\")");
              break;
            }
        Out.println("   boolean init(Connection C, java.sql.ResultSet RS) throws Exception");
        Out.println("    {");
        Out.println("      int i = 0;");
        Out.println("     __Init = InitMode.LOOKUP;");
        for (Column C : O._Columns)
          if (C != null && C._JsonSchema != null)
            {
              Out.println("     Gson gson = new GsonBuilder().setPrettyPrinting().create();");
              break;
            }

        boolean rowTZ = false;
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              String Header = (C.isCollection() == true ? "             " : "          ") + PaddingUtil.getPad(C.getName().length() + Pad.length()) + "   ";
              Out.print("      ");
              if (C._PrimaryKey == true || C._UniqueIndex == true)
                Out.print("__Saved_" + C.getName() + Pad + " = ");
              else
                Out.print("        " + PaddingUtil.getPad(C.getName().length() + Pad.length()) + "   ");
              switch (C.getType())
                {
                  case JSON:
                    Out.println("_" + C.getName() + Pad + " =                              RS.get" + JavaJDBCType.get(C.getType())._JDBCType + "(++i) ; ");
                    if (C._JsonSchema != null)
                      {
                        Out.println(Header + " if (_" + C.getName() + " != null)");
                        Out.println(Header + "  {");
                        Out.println(Header + "    " + C._JsonSchema._TypeName + "[] tmp = gson.fromJson(_" + C.getName() + ", " + C._JsonSchema._TypeName + "[].class);");
                        Out.println(Header + "    _" + C.getName() + "Obj = CollectionUtil.toList(tmp);");
                        Out.println(Header + "  }");
                      }
                    break;
                  case UUID:
                    if (C.isCollection() == true)
                      Out.print("_" + C.getName() + " = (" + (C.isSet() == true ? "Set<" : "List<") + JavaJDBCType.get(C.getType())._JavaClassType + ">) C.getArray(RS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + ".getType(), " + C.isSet() + ");");
                    else
                      Out.print("_" + C.getName() + Pad + " =                              (java.util.UUID) RS.getObject(++i); ");
                    break;
                  case DOUBLE:
                  case FLOAT:
                  case INTEGER:
                  case SHORT:
                  case NUMERIC:
                  case LONG:
                  case BINARY:
                  case BITFIELD:
                  case BOOLEAN:
                  case CHAR:
                  case STRING:
                    if (C.isCollection() == true)
                      Out.print("_" + C.getName() + " = (" + (C.isSet() == true ? "Set<" : "List<") + JavaJDBCType.get(C.getType())._JavaClassType + ">) C.getArray(RS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + ".getType(), " + C.isSet() + ");");
                    else if (C.getType() == ColumnType.CHAR)
                      Out.print("_" + C.getName() + Pad + " = ParseUtil.parseCharacter    (RS.get" + JavaJDBCType.get(C.getType())._JDBCType + "(++i)); ");
                    else if (C.getType() == ColumnType.STRING)
                      Out.print("_" + C.getName() + Pad + " = TextUtil.trim               (RS.get" + JavaJDBCType.get(C.getType())._JDBCType + "(++i)) ; ");
                    else
                      Out.print("_" + C.getName() + Pad + " =                              RS.get" + JavaJDBCType.get(C.getType())._JDBCType + "(++i) ; ");
                    break;
                  case DATE:
                    if (C.isCollection() == true)
                      Out.print("_" + C.getName() + Pad + " = DateTimeUtil.toLocalDates((" + (C.isSet() == true ? "Set<" : "List<") + "java.sql.Date>) C.getArray(RS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + ".getType(), " + C.isSet() + "));");
                    else
                      Out.print("_" + C.getName() + Pad + " = DateTimeUtil.toLocalDate(RS.getDate(++i));");
                    break;
                  case DATETIME:
                  case DATETIME_PLAIN:
                    if (C.needsTZ() == true)
                      {
                        String ColName = C.getTZName();
                        String COLSName = ColName.toUpperCase();
                        if (C.isCollection() == true)
                          Out.print("_" + C.getName() + Pad + " = processZDTs(C, _" + ColName + Pad + ", \"" + C.getFullName() + "\"" + Pad + ", RS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + Pad + ", " + O._BaseClassName + "_Factory.COLS." + COLSName + Pad + ");");
                        else
                          Out.print("_" + C.getName() + Pad + " = processZDT(_" + ColName + Pad + ", \"" + C.getFullName() + "\"" + Pad + ", RS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + Pad + ", " + O._BaseClassName + "_Factory.COLS." + COLSName + Pad + ");");
                      }
                    else
                      {
                        if (C.isCollection() == true)
                          Out.print("_" + C.getName() + Pad + " = DateTimeUtil.toZonedDateTimes((" + (C.isSet() == true ? "Set<" : "List<") + "java.sql.Timestamp>) C.getArray(RS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + ".getType(), " + C.isSet() + "), null);");
                        else
                          Out.print("_" + C.getName() + Pad + " = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i), " + (C._FCT.isManaged() == true ? "null" : "_" + C.getName()) + ");");
                      }
                    break;
                  default:
                    throw new Error("ERROR! Cannot match ColumnType " + C.getType() + " when generating the Read method");
                }

              Out.print(" if (RS.wasNull() == true) { __Nulls.or(" + Mask + Pad + "); _" + C.getName() + " = null; }");
              if (G.getSql().stringNeedsTrim(C) == true)
                Out.print(" else _" + C.getName() + Pad + " = _" + C.getName() + Pad + ".trim();");
              Out.println();
              if (C._Mapper != null && C._Mapper._Name == ColumnMapperMode.MEMORY)
                {
                  if (C.isCollection() == true)
                    {
                      Out.println(Header + " if (_" + C.getName() + " != null) for (" + JavaJDBCType.getFieldTypeBase(C) + " v : _" + C.getName() + ")");
                      Out.println(Header + "  {");
                    }
                  String ClassName = Helper.getFullAppFactoryClassName(C._Mapper._DestObjectObj);
                  String VarName = C.isCollection() == true ? "v" : "_" + C.getName();
                  StringBuilder Str = new StringBuilder();
                  for (int c = 0; c < C._Mapper._SrcColumnObjs.size() - 1; ++c)
                    {
                      Column col = C._Mapper._SrcColumnObjs.get(c);
                      if (c != 0)
                        Str.append(", ");
                      Str.append("get" + TextUtil.capitalizeFirstCharacter(col.getName()) + "()");
                    }
                  if (C._Mapper._Name == ColumnMapperMode.MEMORY)
                    Out.println(Header + "    " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.capitalizeFirstCharacter(C.getName()) + "MappedName(" + ClassName + ".getMappedName(" + Str + ", " + VarName + "));");
                  if (C._Mapper._Group == ColumnMapperMode.MEMORY)
                    Out.println(Header + "    " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.capitalizeFirstCharacter(C.getName()) + "MappedGroup(" + ClassName + ".getMappedGroup(" + Str + ", " + VarName + "));");
                  if (C.isCollection() == true)
                    {
                      Out.println(Header + "  }");
                    }
                }
              else if (C._Enum != null && C._Enum._Name == ColumnMapperMode.MEMORY)
                {
                  if (C.isCollection() == true)
                    {
                      Out.println(Header + " if (_" + C.getName() + " != null) for (" + JavaJDBCType.getFieldTypeBase(C) + " v : _" + C.getName() + ")");
                      Out.println(Header + "  {");
                    }
                  // String ClassName = Helper.getFullAppFactoryClassName(C._Enum._DestObjectObj);
                  String VarName = C.isCollection() == true ? "v" : "_" + C.getName();
                  if (C._Enum._Name == ColumnMapperMode.MEMORY)
                    {
                      String FactoryClassName = Helper.getFullAppFactoryClassName(C._Enum._DestObjectObj);
                      String DataClassName = Helper.getFullAppDataClassName(C._Enum._DestObjectObj);
                      Out.println(Header + "    " + DataClassName + " e = " + FactoryClassName + ".getEnumerationById(" + VarName + ");");
                      Out.println(Header + "    if (e == null)");
                      Out.println(Header + "     throw new Exception(\"Cannot set " + C.getFullName() + ": the value \'\"+" + VarName + "+\"\' is not a valid Enumerated value as per \'" + FactoryClassName + "\'.\");");
                      Out.println(Header + "    " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.capitalizeFirstCharacter(C.getName()) + "EnumValue(e.getValue());");
                    }
                  if (C.isCollection() == true)
                    {
                      Out.println(Header + "  }");
                    }

                }
              if (/* C._Aggregate == AggregateType.ARRAY && */ C.getTypeCollection() == MultiType.LIST && C.getType() == ColumnType.STRING)
                {
                  Out.println("                             //This looks weird, but with array aggregates on strings, gotta watch out on left joins with NULL values.");
                  Out.println("                             //Those values show up as a [null] array (1 element, which is null).");
                  Out.println("                             if (_" + C.getName() + " != null && _" + C.getName() + ".size() == 1 && _" + C.getName() + ".get(0) == null)");
                  Out.println("                               {");
                  Out.println("                                 _" + C.getName() + " = new " + (C.isSet() == true ? "HashSet<" : "ArrayList<") + "String>();");
                  Out.println("                                 __Nulls.or(" + Mask + ");");
                  Out.println("                               }");

                }
            }
        Out.println("     __LookupId = 0;");
        Out.println("     __Init     = InitMode.READ;");
        Out.println("     __Changes.clear();");

        // LDH-NOTE: Auto fields are written to the database, i.e., they are associated to a column and so will be read already.
        // It is therefore useless to call the auto setters here.

        // if (O.hasAutos() == true)
        // {
        // Out.println();
        // for (Column C : O._Columns)
        // if (C != null && C._Mode == ColumnMode.AUTO && C._MapperDef == null && C._FCT.isManaged() == false)
        // Out.println(" set" + TextUtil.capitalizeFirstCharacter(C.getName()) + "();");
        // }

        Out.println();
        Out.println("     return afterRead(C);");
        Out.println("   }");
        for (Column C : O._Columns)
          if (C != null && C.needsTZ() == true)
            {
              Out.println();
              Out.println("  private final ZonedDateTime processZDT(String TimezoneId, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)");
              Out.println("  throws Exception");
              Out.println("   {");
              Out.println("     tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(TimezoneId);");
              Out.println("     if (ZI == null && TextUtil.isNullOrEmpty(TimezoneId) == false)");
              Out.println("      throw new Exception(\"Cannot set field '\"+DTFieldName+\"' because the timezone Id '\" + TimezoneId + \"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
              Out.println("     ZonedDateTime ZDT = DTField.getType() == ColumnType.DATETIME_PLAIN");
              Out.println("          ? DateTimeUtil.toZonedDateTime(RS.getTimestamp(ColumnPos), ZI == null ? null : ZI.getValue())");
              Out.println("          : DateTimeUtil.toZonedDateTime(RS.getTimestamp(ColumnPos, DateTimeUtil._UTC_CALENDAR), ZI == null ? null : ZI.getValue())");
              Out.println("          ;");
              Out.println("     boolean DTNull = false;");
              Out.println("     if (RS.wasNull() == true)");
              Out.println("      {");
              Out.println("         __Nulls.or(DTField._Mask);");
              Out.println("         DTNull = true;");
              Out.println("      }");
              Out.println("     boolean TZNull = __Nulls.intersects(TZField._Mask);");
              Out.println("     if (DTNull == false && TZNull == true)");
              Out.println("      throw new Exception(\"The field \"+DTFieldName+\" is not null while its associated timezone field '\"+DTFieldName+\"TZ' is null. A TZ is mandatory for not null timestamps.\");");
              Out.println("     return ZDT;");
              Out.println("   }");
              break;
            }
        for (Column C : O._Columns)
          if (C != null && C.needsTZ() == true && C.isCollection() == true && C._TzMode.isColumn() == true)
            {
              Out.println("  private final List<ZonedDateTime> processZDTs(Connection C, List<String> TimezoneIds, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)");
              Out.println("  throws Exception");
              Out.println("   {");
              Out.println("     List<Timestamp> L = (List<Timestamp>) C.getArray(RS, ColumnPos, DTField.getType(), false);");
              Out.println("     boolean DTNull = false;");
              Out.println("     if (RS.wasNull() == true)");
              Out.println("      {");
              Out.println("         __Nulls.or(DTField._Mask);");
              Out.println("         DTNull = true;");
              Out.println("      }");
              Out.println("     boolean TZNull = __Nulls.intersects(TZField._Mask);");
              Out.println("     if (DTNull == false && TZNull == true)");
              Out.println("      throw new Exception(\"The field \"+DTFieldName+\" is not null while its associated timezone field '\"+DTFieldName+\"TZ' is null. A TZ is mandatory for not null timestamps.\");");
              Out.println("     if (DTNull == true)");
              Out.println("      return null;");
              Out.println();
              Out.println("     List<ZonedDateTime> ZDTs = new ArrayList<ZonedDateTime>();");
              Out.println("     for (int i = 0; i < TimezoneIds.size(); ++i)");
              Out.println("       {");
              Out.println("         String TimezoneId = TimezoneIds.get(i);");
              Out.println("         tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(TimezoneId);");
              Out.println("         if (ZI == null && TextUtil.isNullOrEmpty(TimezoneId) == false)");
              Out.println("          throw new Exception(\"Cannot set field '\"+DTFieldName+\"' because the timezone Id '\" + TimezoneId + \"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
              Out.println("         ZonedDateTime ZDT = DateTimeUtil.toZonedDateTime(L.get(i), ZI == null ? \"null\" : ZI.getValue());");
              Out.println("         ZDTs.add(ZDT);");
              Out.println("       }");
              Out.println("     return ZDTs;");
              Out.println("   }");
              break;
            }
        for (Column C : O._Columns)
          if (C != null && C.needsTZ() == true && C.isCollection() == true && C._TzMode.isRow() == true)
            {
              Out.println("  private final List<ZonedDateTime> processZDTs(Connection C, String rowTimezoneId, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)");
              Out.println("  throws Exception");
              Out.println("   {");
              Out.println("     List<Timestamp> L = (List<Timestamp>) C.getArray(RS, ColumnPos, DTField.getType(), false);");
              Out.println("     boolean DTNull = false;");
              Out.println("     if (RS.wasNull() == true)");
              Out.println("      {");
              Out.println("         __Nulls.or(DTField._Mask);");
              Out.println("         DTNull = true;");
              Out.println("      }");
              Out.println("     boolean TZNull = __Nulls.intersects(TZField._Mask);");
              Out.println("     if (DTNull == false && TZNull == true)");
              Out.println("      throw new Exception(\"The field \"+DTFieldName+\" is not null while its associated timezone field '\"+TZField.getName()+\"' is null. A TZ is mandatory for not null timestamps.\");");
              Out.println("     if (DTNull == true)");
              Out.println("      return null;");
              Out.println();
              Out.println("     tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(rowTimezoneId);");
              Out.println("     if (ZI == null && TextUtil.isNullOrEmpty(rowTimezoneId) == false)");
              Out.println("      throw new Exception(\"Cannot set field '\"+DTFieldName+\"' because the timezone Id '\" + rowTimezoneId + \"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
              Out.println("     List<ZonedDateTime> ZDTs = new ArrayList<ZonedDateTime>();");
              Out.println("     for (int i = 0; i < L.size(); ++i)");
              Out.println("       {");
              Out.println("         ZonedDateTime ZDT = DateTimeUtil.toZonedDateTime(L.get(i), ZI == null ? \"null\" : ZI.getValue());");
              Out.println("         ZDTs.add(ZDT);");
              Out.println("       }");
              Out.println("     return ZDTs;");
              Out.println("   }");
              break;
            }
        Out.println();
        Out.println("   protected abstract boolean afterRead(Connection C) throws Exception;");
      }

    @Override
    public void genMethodToString(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println("   public String toString()");
        Out.println("    {");
        Out.println("      long T0 = System.nanoTime();");
        Out.println("      String Str = ");
        boolean First = true;
        for (Column C : O._Columns)
          if (C != null && C._FCT != FrameworkColumnType.TZ)
            {
              // LOG.debug("Col "+C.getFullName());
              // if (C.getName().equals("a8bTZ") == true)
              // LOG.debug("zzzzzzzzzzzzzzz");
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              boolean Nullable = C._Nullable == true && C._Mode != ColumnMode.CALCULATED;

              Out.print((First == false ? "               + \"; " : "                   \"") + C.getName());

              if (Nullable)
                Out.print("\"" + Pad + "   + (__Nulls.intersects(" + Mask + Pad + ") == true ? \": NULL\" : \"");

              String Lead = Nullable == true ? "" : PaddingUtil.getPad(Mask.length() + Pad.length() * 2) + "                                        ";
              if (C.isCollection() == false)
                {
                  if (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATETIME_PLAIN)
                    {
                      Out.print(": \"" + Lead + " + DateTimeUtil.printDateTimeForJSON(" + Helper.printGetterCode("", "get" + TextUtil.capitalizeFirstCharacter(Helper.getSystemMappedColumnName(C)) + Pad + "()", C.getName(), C.getType(), C.isCollection(), C._MaskDef) + ")");
                    }
                  else if (C.getType() == ColumnType.JSON)
                    {
                      Out.print(": \"" + Lead + " + TextUtil.printVariableStr        (" + Helper.printGetterCode("", "_" + C.getName() + Pad, C.getName(), C.getType(), C.isCollection(), C._MaskDef) + ")");
                    }
                  else if (C.getType() == ColumnType.STRING)
                    {
                      Out.print(": \"" + Lead + " + TextUtil.printVariableStr        (" + Helper.printGetterCode("", "get" + TextUtil.capitalizeFirstCharacter(C.getName()) + Pad + "()", C.getName(), C.getType(), C.isCollection(), C._MaskDef) + ")");
                    }
                  else
                    {
                      Out.print(": \"" + Lead + " +                                   " + Helper.printGetterCode("", "get" + TextUtil.capitalizeFirstCharacter(C.getName()) + Pad + "()", C.getName(), C.getType(), C.isCollection(), C._MaskDef));
                    }
                }
              else
                {
                  if (C.getType() == ColumnType.JSON)
                    Out.print(": \"" + Lead + " + TextUtil.printVariableStr        (" + Helper.printGetterCode("", "_" + C.getName() + Pad, C.getName(), C.getType(), C.isCollection(), C._MaskDef) + ")");
                  else
                    Out.print(": \"" + Lead + " + TextUtil.print                   (" + Helper.printGetterCode("", "get" + TextUtil.capitalizeFirstCharacter(C.getName()) + Pad + "()", C.getName(), C.getType(), C.isCollection(), C._MaskDef) + ")");
                }

              if (C._Nullable == true && C._Mode != ColumnMode.CALCULATED)
                Out.print(")");
              Out.println();
              if (First == true)
                First = false;
            }
        Out.println("         + \";\";");
        Out.println("      PerfTracker.add(TransactionType.TILDA_TOSTRING, System.nanoTime() - T0);");
        Out.println("      return Str;");
        Out.println("    }");
      }


    @Override
    public void genClassEnd(PrintWriter Out, GeneratorSession G)
    throws Exception
      {
        Out.println(" }");
      }

    @Override
    public void genMethodOutput(PrintWriter Out, GeneratorSession G, Object O)
      {
        boolean JSON = false;
        boolean JSONSync = false;
        boolean CSV = false;
        boolean CSVSync = false;
        for (OutputMap OM : O._OutputMaps)
          {
            if (OM._OutputTypes.contains(OutputFormatType.JSON) == true)
              {
                JSON = true;
                if (OM._Sync == true)
                  JSONSync = true;
              }
            if (OM._OutputTypes.contains(OutputFormatType.CSV) == true)
              {
                CSV = true;
                if (OM._Sync == true)
                  CSVSync = true;
              }
          }

        if (JSON == true)
          {
            Out.println("   public void toJSON(java.io.Writer out, String exportName, boolean fullObject) throws Exception");
            Out.println("    {");
            Out.println("      toJSON(out, exportName, \"\", fullObject, false);");
            Out.println("    }");
            Out.println("   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject) throws Exception");
            Out.println("    {");
            Out.println("      toJSON(out, exportName, lead, fullObject, false);");
            Out.println("    }");
            Out.println("   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, boolean noNullArrays) throws Exception");
            Out.println("    {");
            Out.println("      switch (exportName)");
            Out.println("        { ");
            for (OutputMap OM : O._OutputMaps)
              if (OM != null && OM._OutputTypes.contains(OutputFormatType.JSON) == true)
                Out.println("          case \"" + OM._Name + "\": " + Helper.getFullAppFactoryClassName(O) + ".toJSON" + OM._Name + "(out, (" + Helper.getFullAppDataClassName(O) + ") this, lead, fullObject, noNullArrays); break;");
            Out.println("          default: throw new Exception(\"Unknown JSON exporter '\"+exportName+\"' for " + Helper.getFullAppFactoryClassName(O) + "\");");
            Out.println("        } ");
            Out.println("    }");
            if (JSONSync == true)
              {
                Out.println("   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception");
                Out.println("    {");
                Out.println("      switch (exportName)");
                Out.println("        { ");
                for (OutputMap OM : O._OutputMaps)
                  if (OM != null && OM._OutputTypes.contains(OutputFormatType.JSON) == true && OM._Sync == true)
                    Out.println("          case \"" + OM._Name + "\": " + Helper.getFullAppFactoryClassName(O) + ".toJSON" + OM._Name + "(out, (" + Helper.getFullAppDataClassName(O) + ") this, lead, fullObject, lastsync); break;");
                Out.println("          default: throw new Exception(\"Unknown JSON sync exporter '\"+exportName+\"' for " + Helper.getFullAppFactoryClassName(O) + "\");");
                Out.println("        } ");
                Out.println("    }");
              }
            else
              {
                Out.println("   public void toJSON(java.io.Writer out, String exportName, String lead, boolean fullObject, java.time.ZonedDateTime lastsync) throws Exception");
                Out.println("    {");
                Out.println("      throw new Exception(\"Unknown JSON sync exporter '\"+exportName+\"' for " + Helper.getFullAppFactoryClassName(O) + "\");");
                Out.println("    }");

              }
          }

        if (CSV == true)
          {
            Out.println("   public void toCSV(java.io.Writer out, String exportName) throws Exception");
            Out.println("    {");
            Out.println("      switch (exportName)");
            Out.println("        { ");
            for (OutputMap OM : O._OutputMaps)
              if (OM != null && OM._OutputTypes.contains(OutputFormatType.CSV) == true)
                Out.println("          case \"" + OM._Name + "\": " + Helper.getFullAppFactoryClassName(O) + ".toCSV" + OM._Name + "(out, (" + Helper.getFullAppDataClassName(O) + ") this); break;");
            Out.println("          default: throw new Exception(\"Unknown CSV exporter '\"+exportName+\"' for " + Helper.getFullAppFactoryClassName(O) + "\");");
            Out.println("        } ");
            Out.println("    }");
            if (CSVSync == true)
              {
                Out.println("   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception");
                Out.println("    {");
                Out.println("      switch (exportName)");
                Out.println("        { ");
                for (OutputMap OM : O._OutputMaps)
                  if (OM != null && OM._OutputTypes.contains(OutputFormatType.CSV) == true)
                    Out.println("          case \"" + OM._Name + "\": " + Helper.getFullAppFactoryClassName(O) + ".toCSV" + OM._Name + "(out, (" + Helper.getFullAppDataClassName(O) + ") this, lastsync); break;");
                Out.println("          default: throw new Exception(\"Unknown CSV sync exporter '\"+exportName+\"' for " + Helper.getFullAppFactoryClassName(O) + "\");");
                Out.println("        } ");
                Out.println("    }");
              }
            else
              {
                Out.println("   public void toCSV(java.io.Writer out, String exportName, java.time.ZonedDateTime lastsync) throws Exception");
                Out.println("    {");
                Out.println("      throw new Exception(\"Unknown CSV sync exporter '\"+exportName+\"' for " + Helper.getFullAppFactoryClassName(O) + "\");");
                Out.println("    }");

              }
          }
      }


  }
