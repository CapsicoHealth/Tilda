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

import tilda.enums.AggregateType;
import tilda.enums.ColumnMapperMode;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.MultiType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.OutputFormatType;
import tilda.enums.ProtectionType;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenTildaData;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.JsonField;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OutputMapping;
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
            if (C.getType() == ColumnType.DATETIME || C.getType() == ColumnType.DATE)
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
        Out.println("import org.apache.logging.log4j.LogManager;");
        Out.println("import org.apache.logging.log4j.Logger;");
        for (Column C : O._Columns)
          if (C._JsonSchema != null)
            {
              Out.println();
              Out.println("import com.google.gson.Gson;");
              Out.println("import com.google.gson.GsonBuilder;");
              Out.println("import com.google.gson.annotations.SerializedName;");
              break;
            }
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
        if (O.isOCC() == true)
          Out.print(", tilda.interfaces.OCCObject");
        if (O.isJsonable() == true)
          Out.print(", tilda.interfaces.JSONable");
        Out.println();
        Out.println(" {");
        Out.println("   protected static final Logger LOG = LogManager.getLogger(" + O._BaseClassName + ".class.getName());");
        Out.println();
        Out.println("   public static final Class<" + O._BaseClassName + "_Factory> FACTORY_CLASS= " + O._BaseClassName + "_Factory.class;");
        Out.println("   public static final String TABLENAME = TextUtil.Print(" + TextUtil.EscapeDoubleQuoteWithSlash(O.getShortName()) + ", \"\");");
        Out.println();
        Out.println("   protected " + O._BaseClassName + "() { }");
        Out.println();
        Out.println("   private InitMode __Init        = null;");
        Out.println("   private BitSet   __Nulls       = new BitSet(64);");
        Out.println("   private BitSet   __Changes     = new BitSet(64);");
        Out.println("   private boolean  __NewlyCreated= false;");
        Out.println("   private int      __LookupId;");
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
            Out.println("   String _" + C.getName() + ";");
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
                Out.println("         return " + TextUtil.EscapeDoubleQuoteWithSlash(C._JsonSchema._Validation._Descr) + ";");
              }
            else
              {
                Out.println("          return null;");
              }
            Out.println("       }");
            Out.println("    }");
          }
        else
          {
            Out.print("   " + JavaJDBCType.getFieldType(C) + " _" + C.getName());
            if (C.isCollection() == false)
              switch (C.getType())
                {
                  case BINARY:
                  case BITFIELD:
                  case BOOLEAN:
                    break;
                  case CHAR:
                    Out.print("= Character.UNASSIGNED");
                    break;
                  case DOUBLE:
                  case FLOAT:
                  case INTEGER:
                  case LONG:
                    Out.print("= SystemValues.EVIL_VALUE");
                    break;
                  case DATETIME:
                  case STRING:
                  case JSON:
                    break;
                  default:
                    break;
                }
            else if (C._Nullable == false)
              {
                if (C.isList() == true)
                  Out.print("= new ArrayList<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">()");
                else if (C.isSet() == true)
                  Out.print("= new TreeSet<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">()");
              }
            Out.println(";");
            if (C.isSavedField() == true)
              Out.println("   protected " + JavaJDBCType.getFieldType(C) + " __Saved_" + C.getName() + ";");
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
                  Out.print("{ " + TextUtil.EscapeDoubleQuoteWithSlash(V._Value) + C._PadderValueValues.getPad(V._Value) + ", " + TextUtil.EscapeDoubleQuoteWithSlash(V._Label) + ", " + TextUtil.EscapeDoubleQuoteWithSlash(V._Description));
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
          }

        for (ColumnValue V : C._Values)
          if (V != null)
            {
              if (C._MapperDef != null)
                {
                  Out.println("   public static final " + JavaJDBCType.getFieldTypeBase(C._MapperDef._ParentColumn)
                  + " _" + C.getName() + TextUtil.CapitalizeFirstCharacter(V._Name) + C._PadderValueNames.getPad(V._Name)
                  + " = " + Helper.getFullAppDataClassName(C._MapperDef._DestObjectObj) + "._group" + V._Name + ";");
                }
              else
                {
                  Out.print("   public static final " + JavaJDBCType.getFieldTypeBase(C) + " _" + C.getName() + TextUtil.CapitalizeFirstCharacter(V._Name) + C._PadderValueNames.getPad(V._Name) + " = ");
                  Out.print(PrintColumnValue(V._ParentColumn, V._Value));
                  Out.println(";");
                }
            }


      }

    public static String PrintColumnValue(Column C, String V)
    throws Error
      {
        switch (C.getType())
          {
            case BOOLEAN:
            case DOUBLE:
            case FLOAT:
            case INTEGER:
            case LONG:
              return V;
            case CHAR:
              return TextUtil.EscapeSingleQuoteForSQL(V);
            case DATETIME:
              if (V.equalsIgnoreCase("NOW") == true)
                return "DateTimeUtil.NOW_PLACEHOLDER_ZDT";
              else if (V.equalsIgnoreCase("UNDEFINED") == true)
                return "DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT";
              return "DateTimeUtil.toCalendarNoThrow(" + TextUtil.EscapeDoubleQuoteWithSlash(V) + ")";
            case DATE:
              if (V.equalsIgnoreCase("NOW") == true)
                return "DateTimeUtil.NOW_PLACEHOLDER_D";
              else if (V.equalsIgnoreCase("UNDEFINED") == true)
                return "DateTimeUtil.UNDEFINED_PLACEHOLDER_D";
              return "DateTimeUtil.parseDate(" + TextUtil.EscapeDoubleQuoteWithSlash(V) + ", \"yyyy-MM-dd\")";
            case STRING:
            case JSON:
              return TextUtil.EscapeDoubleQuoteWithSlash(V);
            case BINARY:
            case BITFIELD:
              throw new Error("An invalid type '" + C.getType() + "' was assigned column values for code gen.");
            default:
              throw new Error("Unhandled case in switch for type '" + C.getType() + "'.");
          }
      }


    @Override
    public void genMethodGet(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        if (C._Mode == ColumnMode.CALCULATED && C._MapperDef == null)
          Out.println("   public abstract " + JavaJDBCType.getFieldType(C) + " get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "();");
        else if (C.getType() == ColumnType.JSON && C._JsonSchema != null)
          {
            if (C.isCollection() == false)
              {
                Out.println("   public final " + C._JsonSchema._TypeName + " get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
                Out.println("      {");
                Out.println("        return _" + C.getName() + "Obj;");
                Out.println("      }");
              }
            else
              {
                Out.println("   public final List<" + C._JsonSchema._TypeName + "> get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
                Out.println("      {");
                Out.println("        return _" + C.getName() + "Obj;");
                Out.println("      }");
              }
          }
        else if (C.isCollection() == false)
          {
            Out.println("   public final " + JavaJDBCType.getFieldType(C) + " get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
            Out.println("      { return _" + C.getName() + "; }");
          }
        else
          {
            Out.println("   public final " + JavaJDBCType.getFieldTypeBaseClass(C) + "[] get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "AsArray()");
            Out.println("      { return _" + C.getName() + "==null? null : _" + C.getName() + ".toArray(new " + JavaJDBCType.getFieldTypeBaseClass(C) + "[_" + C.getName() + ".size()]); }");
            Out.println("   public final Iterator<" + JavaJDBCType.getFieldTypeBaseClass(C) + "> get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
            Out.println("      { return _" + C.getName() + "==null? null : _" + C.getName() + ".iterator(); }");
            Out.println("   public final boolean has" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldTypeBase(C) + " v)");
            Out.println("      { return _" + C.getName() + "==null? false : _" + C.getName() + ".contains(v); }");
          }
      }

    @Override
    public void genMethodIs(PrintWriter Out, GeneratorSession G, ColumnValue V)
      {
        String ValueNameVar = "_" + V._ParentColumn.getName() + TextUtil.CapitalizeFirstCharacter(V._Name);
        Out.println("   public final boolean is" + TextUtil.CapitalizeFirstCharacter(V._ParentColumn.getName()) + TextUtil.CapitalizeFirstCharacter(V._Name) + "()");
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
              case LONG:
                Out.println("      { return _" + V._ParentColumn.getName() + " == " + ValueNameVar + "; }");
                break;
              case DATETIME:
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
                throw new Error("An invalid type '" + V._ParentColumn.getType() + "' was assigned column values for code gen.");
              default:
                throw new Error("Unhandled case in switch for type '" + V._ParentColumn.getType() + "'.");
            }
      }

    @Override
    public void genMethodSet(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        String Mask = Helper.getRuntimeMask(C);
        String Visibility = Helper.getVisibility(C, true);
        if (C._JsonSchema != null && C.isCollection() == true)
          {
            Out.println("   protected static final java.lang.reflect.Type LIST_TYPE_" + C._JsonSchema._TypeName + " = new com.google.gson.reflect.TypeToken<ArrayList<" + C._JsonSchema._TypeName + ">>(){}.getType();");
          }

        if (C.isCollection() == true)
          {
            if (C._JsonSchema == null)
              Out.println("   " + Visibility + " void set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldType(C) + " v) throws Exception");
            else
              Out.println("   " + Visibility + " void set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(String v) throws Exception");

            Out.println("     {");
            Out.println("       long T0 = System.nanoTime();");
            if (C._Invariant == true || C._ParentObject.getLifecycle() != ObjectLifecycle.NORMAL)
              {
                Out.println("       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)");
                Out.println("        throw new Exception(\"Cannot set field '" + C.getFullName() + "' that is invariant, or part of a read-only or pre-existing WORM object.\");");
              }
            Out.println("       if (v == null " + (C._Nullable == true ? " || v.isEmpty() == true" : "") + ")");
            if (C._Nullable == true)
              Out.println("        setNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "();");
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
                Out.println("             _" + C.getName() + " = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<" + JavaJDBCType.getFieldTypeBaseClass(C) + ">();");
                if (C.getType() == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
                  Out.println("             _" + C.getName() + "TZ = new " + (C.isList() == true ? "ArrayList" : "TreeSet") + "<String>();");
                Out.println("           }");
                Out.println("          else");
                Out.println("           {");
                Out.println("             _" + C.getName() + ".clear();");
                if (C.getType() == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
                  Out.println("             _" + C.getName() + "TZ.clear();");
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
                if (C.getType() == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
                  {
                    if (C.isList() == false)
                      throw new Error("ERROR: Cannot have Sets of DateTimes!");
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
                if (C.getType() == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
                  {
                    Out.println("             tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(i.getZone().getId());");
                    Out.println("             if (ZI == null)");
                    Out.println("              throw new Exception(\"Cannot set field '" + C.getFullName() + "' because the timezone value '\"+i.getZone().getId()+\"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
                    Out.println("             addTo" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "TZ(k, ZI.getId());");
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
                        Str.append("get" + TextUtil.CapitalizeFirstCharacter(col.getName()) + "()");
                      }
                    if (C._Mapper._Name != ColumnMapperMode.NONE)
                      Out.println("             _" + C.getName() + "MappedName.add(" + ClassName + ".getMappedName(" + Str + ", i));");
                    if (C._Mapper._Group != ColumnMapperMode.NONE)
                      Out.println("             _" + C.getName() + "MappedGroup.add(" + ClassName + ".getMappedGroup(" + Str + ", i));");
                  }
                Out.println("           }");
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
              Out.println("   " + Visibility + " void addTo" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(int pos, " + JavaJDBCType.getFieldTypeBase(C) + " v) throws Exception");
            else if (C.isSet() == true)
              Out.println("   " + Visibility + " void addTo" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldTypeBase(C) + " v) throws Exception");
            else
              Out.println("   " + Visibility + (C.isOCCDeleted() || C.isOCCLastUpdated() ? " final" : "") + " void set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldType(C) + " v) throws Exception");
            Out.println("     {");
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
                  Out.println("          " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.CapitalizeFirstCharacter(C.getName()) + "EnumValue(e.getValue());");
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
                case INTEGER:
                  if (C.isSet() == true)
                    Out.println("       if (_" + C.getName() + ".contains(v) == false)");
                  else if (C.isList() == true)
                    Out.println("       if (pos >= _" + C.getName() + ".size() || _" + C.getName() + ".get(pos).equals(v) == false)");
                  else
                    Out.println("       if (v != _" + C.getName() + ")");
                  Out.println("        {");
                  break;
                case DATE:
                case DATETIME:
                case STRING:
                case JSON:
                  Out.println("       if (v == null)");
                  if (C._Nullable == true)
                    {
                      Out.println("        {");
                      if (C._Mode == ColumnMode.CALCULATED && C._MapperDef != null)
                        Out.println("          _" + C.getName() + " = null;");
                      else
                        Out.println("          setNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "();");
                      Out.println("        }");
                    }
                  else
                    Out.println("        throw new Exception(\"Cannot set " + C.getFullName() + " to null: it's not nullable.\");");
                  if (C.getType() == ColumnType.STRING && C.isCollection() == false)
                    {
                      Out.println("       else if (v.length() > " + C._Size + ")");
                      Out.println("        throw new Exception(\"Cannot set " + C.getFullName() + ": the value \"+TextUtil.EscapeDoubleQuoteWithSlash(v)+\" is larger than the max size allowed " + C._Size + ".\");");
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
                        Out.println("          v = HTMLFilter.CleanAbsolute(v);");
                      else if (C._Protect == ProtectionType.SMART)
                        Out.println("          v = HTMLFilter.CleanSmart(" + TextUtil.EscapeDoubleQuoteWithSlash(C.getFullName()) + ",v);");
                    }
                  break;
                case BINARY:
                  break;
                default:
                  throw new Error("ERROR! Cannot match ColumnType " + C.getType() + " when generating a setter");
              }

            if (C._Invariant == true || C._ParentObject.getLifecycle() != ObjectLifecycle.NORMAL)
              {
                Out.println("          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)");
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
                    Str.append("get" + TextUtil.CapitalizeFirstCharacter(col.getName()) + "()");
                  }

                if (C._Mapper._Name != ColumnMapperMode.NONE)
                  Out.println("          " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.CapitalizeFirstCharacter(C.getName()) + "MappedName(" + ClassName + ".getMappedName(" + Str + ", v));");
                if (C._Mapper._Group != ColumnMapperMode.NONE)
                  Out.println("          " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.CapitalizeFirstCharacter(C.getName()) + "MappedGroup(" + ClassName + ".getMappedGroup(" + Str + ", v));");
              }
            if (C.getType() == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
              {
                Out.println("          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());");
                Out.println("          if (ZI == null)");
                Out.println("           throw new Exception(\"Cannot set field '" + C.getFullName() + "' because the timezone value '\"+v.getZone().getId()+\"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
                if (C.isCollection() == true)
                  Out.println("          addTo" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "TZ(pos, ZI.getId());");
                else
                  Out.println("          set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "TZ(ZI.getId());");
              }
            if (C.getType() != ColumnType.BINARY)
              Out.println("        }");
            Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
            Out.println("     }");

            if (C.isCollection() == true)
              {
                Out.println("   " + Visibility + " void removeFrom" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldTypeBaseClass(C) + " v) throws Exception");
                Out.println("     {");
                Out.println("       long T0 = System.nanoTime();");
                if (C._Mode != ColumnMode.CALCULATED)
                  {
                    if (C.getType() == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
                      {
                        Out.println("       int i = _" + C.getName() + ".indexOf(v);");
                        Out.println("       if (1 != -1)");
                        Out.println("        {");
                        Out.println("          _" + C.getName() + ".remove(i);");
                        Out.println("          removeFrom" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "TZ(i);");
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
                Out.println("   " + Visibility + " void removeFrom" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(int pos) throws Exception");
                Out.println("     {");
                Out.println("       long T0 = System.nanoTime();");
                if (C._Mode != ColumnMode.CALCULATED)
                  {
                    Out.println("       if (_" + C.getName() + ".remove(pos) != null)");
                    Out.println("        {");
                    Out.println("          __Changes.or(" + Mask + ");");
                    if (C.getType() == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
                      Out.println("          removeFrom" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "TZ(pos);");
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
              Out.println("   " + Visibility + " void set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(List<" + C._JsonSchema._TypeName + "> v) throws Exception");
            else
              Out.println("   " + Visibility + " void set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(" + C._JsonSchema._TypeName + " v) throws Exception");
            Out.println("     {");
            Out.println("       long T0 = System.nanoTime();");
            if (C._Invariant == true || C._ParentObject.getLifecycle() != ObjectLifecycle.NORMAL)
              {
                Out.println("       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)");
                Out.println("        throw new Exception(\"Cannot set field '" + C.getFullName() + "' that is invariant, or part of a read-only or pre-existing WORM object.\");");
              }
            Out.println("       if (v == null " + (C.isCollection() == true && C._Nullable == true ? " || v.isEmpty() == true" : "") + ")");
            if (C._Nullable == true)
              Out.println("        setNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "();");
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
      }

    @Override
    public void genMethodSetAs(PrintWriter Out, GeneratorSession G, ColumnValue V)
      {
        String ValueNameVar = "_" + V._ParentColumn.getName() + TextUtil.CapitalizeFirstCharacter(V._Name);
        Out.println("   public void set" + TextUtil.CapitalizeFirstCharacter(V._ParentColumn.getName()) + TextUtil.CapitalizeFirstCharacter(V._Name) + "() throws Exception");
        switch (V._ParentColumn.getType())
          {
            case BOOLEAN:
            case CHAR:
            case DOUBLE:
            case FLOAT:
            case INTEGER:
            case LONG:
            case STRING:
              if (V._ParentColumn.isCollection() == false)
                Out.println("      { set" + TextUtil.CapitalizeFirstCharacter(V._ParentColumn.getName()) + "(" + ValueNameVar + "); }");
              else
                Out.println("      { addTo" + TextUtil.CapitalizeFirstCharacter(V._ParentColumn.getName()) + "(" + ValueNameVar + "); }");
              break;
            case DATETIME:
            case DATE:
              if (V._ParentColumn.isCollection() == false)
                {
                  Out.println("      { set" + TextUtil.CapitalizeFirstCharacter(V._ParentColumn.getName()) + "(" + ValueNameVar + "); }");
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
        Out.println("   " + Visibility + " final void set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "Now() throws Exception");
        Out.println("    {");
        Out.println("      set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(DateTimeUtil.NOW_PLACEHOLDER_ZDT);");
        Out.println("    }");
      }

    @Override
    public void genMethodSetDateTimeUndefined(PrintWriter Out, GeneratorSession G, Column C)
      {
        String Visibility = Helper.getVisibility(C, true);
        Out.println("   " + Visibility + " final void set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "Undefined() throws Exception");
        Out.println("    {");
        Out.println("      set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT);");
        Out.println("    }");
      }

    @Override
    public void genMethodSetDateTimeExplicit(PrintWriter Out, GeneratorSession G, Column C)
      {
        String Visibility = Helper.getVisibility(C, true);
        Out.println("   " + Visibility + " final void set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(int year, int month, int date, int hourOfDay, int minute, int second, int millis, ZoneId z) throws Exception");
        Out.println("    {");
        Out.println("      set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(DateTimeUtil.New(year, month, date, hourOfDay, minute, second, millis, z));");
        Out.println("    }");
      }


    @Override
    public void genMethodSetNull(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        String Mask = Helper.getRuntimeMask(C);
        String Visibility = Helper.getVisibility(C, true);

        Out.println("   " + Visibility + (C.isOCCDeleted() || C.isOCCLastUpdated() ? " final" : "") + " void setNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        if (C._Mode != ColumnMode.CALCULATED)
          {
            Out.println("       if (__Nulls.intersects(" + Mask + ") == true) // already NULL");
            Out.println("        return;");
            Out.println("       __Changes.or(" + Mask + ");");
            Out.println("       __Nulls.or(" + Mask + ");");
          }

        if (C.isCollection() == true)
          Out.println("       _" + C.getName() + "=null;");
        else
          switch (C.getType())
            {
              case CHAR:
                Out.println("       _" + C.getName() + "=Character.UNASSIGNED;");
                break;
              case BOOLEAN:
                Out.println("       _" + C.getName() + "=false;");
                break;
              case DOUBLE:
              case LONG:
                Out.println("       _" + C.getName() + "=0L;");
                break;
              case FLOAT:
              case BITFIELD:
              case INTEGER:
                Out.println("       _" + C.getName() + "=0;");
                break;
              case DATETIME:
              case DATE:
              case STRING:
              case JSON:
              case BINARY:
                Out.println("       _" + C.getName() + "=null;");
                break;
              default:
                throw new Error("ERROR! Cannot match ColumnType " + C.getType() + " when generating a null setter");
            }
        if (C.getType() == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
          {
            Out.println("       setNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "TZ();");
          }
        Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
        Out.println("     }");
      }

    @Override
    public void genMethodHasChanged(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        String Mask = Helper.getRuntimeMask(C);
        Out.println("   public boolean hasChanged" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
        Out.println("     { return __Changes.intersects(" + Mask + "); }");
      }

    @Override
    public void genMethodIsNull(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        String Mask = Helper.getRuntimeMask(C);
        Out.println("   public final boolean isNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
        Out.println("     { return __Nulls.intersects(" + Mask + "); }");
      }

    @Override
    public void genMethodTouch(PrintWriter Out, GeneratorSession G, Column C)
    throws Exception
      {
        Out.println("   public final boolean Touch(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "Now();");
        Out.println("       return Write(C);");
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
              if (C.getType() == ColumnType.DATETIME)
                Out.println();
              Out.print("          if (__Changes.intersects(" + Mask + ") == true) { " + Helper.getRuntimeInsertStr(C) + ";");
              switch (C.getType())
                {
                  case DATE:
                  case DATETIME:
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
                  case LONG:
                  case STRING:
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
              if (C.getType() == ColumnType.DATETIME)
                Out.println();
              switch (C.getType())
                {
                  case DATE:
                  case DATETIME:
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
                  case LONG:
                  case STRING:
                    if (C._DefaultUpdateValue == null)
                      Out.println("          if (__Changes.intersects(" + Mask + ") == true) " + Helper.getRuntimeUpdateStr(C) + ";");
                    else
                      {
                        String MethodName = TextUtil.CapitalizeFirstCharacter(C.getName()) + TextUtil.CapitalizeFirstCharacter(C._DefaultUpdateValue._Name);
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
    
    
    private void genWritePreparedStatementPopulation(PrintWriter Out, Object O)
    throws Error
      {
        Out.println("   protected int populatePreparedStatement(Connection C, java.sql.PreparedStatement PS, List<java.sql.Array> AllocatedArrays) throws Exception");
        Out.println("     {");
        Out.println("       int i = 0;");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String Mask = Helper.getRuntimeMask(C);
//              String Pad = O._PadderColumnNames.getPad(C.getName());
              Out.println("       if (__Changes.intersects(" + Mask + ") == true) ");
              Out.println("        { ");
              Out.print  ("          if (__Nulls.intersects(" + Mask + ") == true) PS.setNull(++i, " + (C.isCollection() == true ? "C.supportsArrays()?java.sql.Types.ARRAY:" : "") + "java.sql.Types." + JavaJDBCType.get(C.getType())._JDBCSQLType + ");");
              switch (C.getType())
                {
                  case DATE:
                    Out.print(" else ");
                    if (C.isCollection() == false)
                      Out.println("if (DateTimeUtil.isNowPlaceholder(_" + C.getName() + ") == false)  PS.setDate(++i, new java.sql.Date(_" + C.getName() + ".getYear()-1900, _" + C.getName() + ".getMonthValue()-1, _" + C.getName() + ".getDayOfMonth()));");
                    else
                      Out.println("C.setArray(PS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + "._Type, AllocatedArrays, _" + C.getName() + ");");
                    break;
                  case DATETIME:
                    Out.print(" else ");
                    if (C.isCollection() == false)
                      Out.println("if (DateTimeUtil.isNowPlaceholder(_" + C.getName() + ") == false) PS.setTimestamp(++i, new java.sql.Timestamp(_" + C.getName() + ".toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);");
                    else
                      Out.println("C.setArray(PS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + "._Type, AllocatedArrays, DateTimeUtil.toSQLTimeStamps(_" + C.getName() + "));");
                    break;
                  case JSON:
                    Out.println(" else PS.set" + JavaJDBCType.get(C.getType())._JDBCType + "(++i, " + (C.getType() == ColumnType.CHAR ? "\"\"+" : "") + "_" + C.getName() + ");");
                    break;
                  case BINARY:
                  case BITFIELD:
                  case BOOLEAN:
                  case DOUBLE:
                  case FLOAT:
                  case INTEGER:
                  case LONG:
                  case CHAR:
                  case STRING:
                    Out.print(" else ");
                    if (C.isCollection() == false)
                      Out.println("PS.set" + JavaJDBCType.get(C.getType())._JDBCType + "(++i, " + (C.getType() == ColumnType.CHAR ? "\"\"+" : "") + "_" + C.getName() + ");");
                    else
                      Out.println("C.setArray(PS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + "._Type, AllocatedArrays, _" + C.getName() + ");");
                    break;
                  default:
                    throw new Error("ERROR! Cannot match ColumnType " + C.getType() + " when generating a Write method");
                }
              Out.println("        } ");
            }
        Out.println("       return i;");
        Out.println("     }");
      }
    
    private void genPostWriteObjectStateUpdate(PrintWriter Out, Object O)
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
        Out.println("       __Nulls.clear();");
        Out.println("     }");
      }
    
    

    @Override
    public void genMethodWrite(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        genWriteQuery(Out, G, O);
        genWritePreparedStatementPopulation(Out, O);
        genPostWriteObjectStateUpdate(Out, O);
        Out.println("   public final boolean Write(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        Out.println("       if (hasChanged() == false)");
        Out.println("        {");
        Out.println("          LOG.debug(QueryDetails._LOGGING_HEADER + \"The " + O.getFullName() + " has not changed: no writing will occur.\");");
        Out.println("          QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("          return true;");
        Out.println("        }");
        Out.println();
        Out.println("       if (BeforeWrite(C) == false)");
        Out.println("        {");
        Out.println("          LOG.debug(QueryDetails._LOGGING_HEADER + \"The " + O.getFullName() + " object's BeforeWrite() failed.\");");
        Out.println("          QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("          return false;");
        Out.println("        }");
        Out.println();
        Out.println("       String Q = getWriteQuery(C);");
        Out.println();
        Out.println("       java.sql.PreparedStatement PS = null;");
        Out.println("       int count = 0;");
        for (Column C : O._Columns)
          if (C != null && C.isCollection() == true)
            {
              Out.println("       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();");
              break;
            }
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
        Out.println("   protected abstract boolean BeforeWrite(Connection C) throws Exception;");
      }



    @Override
    public void genMethodCopyTo(PrintWriter Out, GeneratorSession G, Object O, List<Column> CopyToColumns)
    throws Exception
      {
        Out.println("   public void CopyTo(" + Helper.getFullBaseClassName(O) + " Dst) throws Exception");
        Out.println("     {");
        for (Column C : CopyToColumns)
          if (C != null)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              if (C._Nullable == true)
                Out.print("       if (__Changes.intersects(" + Mask + ") == true) Dst.setNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "(); else ");
              Out.println("       Dst.set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "(_" + C.getName() + Pad + ");");
            }
        Out.println("     }");
      }

    @Override
    public void genMethodRefresh(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println("   public final boolean Refresh(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       return ReadOne(C, true);");
        Out.println("     }");
      }

    @Override
    public void genMethodRead(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println("   public final boolean Read(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       return ReadOne(C, false);");
        Out.println("     }");
        Out.println();
        Out.println("   private final boolean ReadOne(Connection C, boolean Force) throws Exception");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        Out.println("       if (__Init == InitMode.CREATE)");
        Out.println("        throw new Exception(\"This " + O.getShortName() + " object is being Read() after a Create(), which doesn't make sense.\");");
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
        for (Column C : O._Columns)
          if (C != null && C.isCollection() == true)
            {
              Out.println("       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();");
              break;
            }
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
        Out.println("          return Init(C, RS);");
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
        Out.println("   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception");
        Out.println("    {");
        Out.println("      int i = 0;");
        Out.println("     __Init = InitMode.LOOKUP;");
        for (Column C : O._Columns)
          if (C != null && C._JsonSchema != null)
            {
              Out.println("     Gson gson = new GsonBuilder().setPrettyPrinting().create();");
              break;
            }

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
                    Out.println(Header + " if (_" + C.getName() + " != null)");
                    Out.println(Header + "  {");
                    Out.println(Header + "    " + C._JsonSchema._TypeName + "[] tmp = gson.fromJson(_" + C.getName() + ", " + C._JsonSchema._TypeName + "[].class);");
                    Out.println(Header + "    _" + C.getName() + "Obj = CollectionUtil.toList(tmp);");
                    Out.println(Header + "  }");
                    break;
                  case DOUBLE:
                  case FLOAT:
                  case INTEGER:
                  case LONG:
                  case BINARY:
                  case BITFIELD:
                  case BOOLEAN:
                  case CHAR:
                  case STRING:
                    if (C.isCollection() == true)
                      Out.print("_" + C.getName() + " = (" + (C.isSet() == true ? "Set<" : "List<") + JavaJDBCType.get(C.getType())._JavaClassType + ">) C.getArray(RS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + "._Type, " + C.isSet() + ");");
                    else if (C.getType() == ColumnType.CHAR)
                      Out.print("_" + C.getName() + Pad + " = ParseUtil.parseCharacter    (RS.get" + JavaJDBCType.get(C.getType())._JDBCType + "(++i)); ");
                    else if (C.getType() == ColumnType.STRING)
                      Out.print("_" + C.getName() + Pad + " = TextUtil.Trim               (RS.get" + JavaJDBCType.get(C.getType())._JDBCType + "(++i)) ; ");
                    else
                      Out.print("_" + C.getName() + Pad + " =                              RS.get" + JavaJDBCType.get(C.getType())._JDBCType + "(++i) ; ");
                    break;
                  case DATE:
                    if (C.isCollection() == true)
                      Out.print("_" + C.getName() + " = (" + (C.isSet() == true ? "Set<" : "List<") + JavaJDBCType.get(C.getType())._JavaClassType + ">) C.getArray(RS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + "._Type, " + C.isSet() + ");");
                    // Out.print("_" + C.getName() + Pad + " = " + SerializeArray(G) + "((" + JavaJDBCType.get(C.getType())._JavaClassType + "[])RS.getArray(++i).getArray());");
                    // throw new Error("Cannot do Date arrays yet!");
                    else
                      Out.print("_" + C.getName() + Pad + " = DateTimeUtil.toLocalDate(RS.getDate(++i));");
                    break;
                  case DATETIME:
                    if (C.isCollection() == true)
                      Out.print("_" + C.getName() + Pad + " = ProcessZDTs(C, _" + C.getName() + "TZ" + Pad + ", \"" + C.getFullName() + "\"" + Pad + ", RS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + Pad + ", " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + "TZ" + Pad + ");");
                    // Out.print("_" + C.getName() + Pad + " = " + SerializeArray(G) + "((" + JavaJDBCType.get(C.getType())._JavaClassType + "[])RS.getArray(++i).getArray());");
                    // throw new Error("Cannot do DateTime arrays yet!");
                    else if (C.isOCCGenerated() == false)
                      Out.print("_" + C.getName() + Pad + " = ProcessZDT(_" + C.getName() + "TZ" + Pad + ", \"" + C.getFullName() + "\"" + Pad + ", RS, ++i, " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + Pad + ", " + O._BaseClassName + "_Factory.COLS." + C.getName().toUpperCase() + "TZ" + Pad + ");");
                    else
                      Out.print("_" + C.getName() + Pad + " = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), " + (Object.isOCCColumn(C) == true ? "null" : "_" + C.getName() + "TZ") + ");");
                    break;
                  default:
                    throw new Error("ERROR! Cannot match ColumnType " + C.getType() + " when generating the Read method");
                }

              Out.print(" if (RS.wasNull() == true) __Nulls.or(" + Mask + Pad + ");");
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
                      Str.append("get" + TextUtil.CapitalizeFirstCharacter(col.getName()) + "()");
                    }
                  if (C._Mapper._Name == ColumnMapperMode.MEMORY)
                    Out.println(Header + "    " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.CapitalizeFirstCharacter(C.getName()) + "MappedName(" + ClassName + ".getMappedName(" + Str + ", " + VarName + "));");
                  if (C._Mapper._Group == ColumnMapperMode.MEMORY)
                    Out.println(Header + "    " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.CapitalizeFirstCharacter(C.getName()) + "MappedGroup(" + ClassName + ".getMappedGroup(" + Str + ", " + VarName + "));");
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
                      Out.println(Header + "    " + (C.isCollection() == true ? "addTo" : "set") + TextUtil.CapitalizeFirstCharacter(C.getName()) + "EnumValue(e.getValue());");
                    }
                  if (C.isCollection() == true)
                    {
                      Out.println(Header + "  }");
                    }

                }
              if (C._Aggregate == AggregateType.ARRAY && C.getTypeCollection() == MultiType.LIST && C.getType() == ColumnType.STRING)
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
        Out.println("     return AfterRead(C);");
        Out.println("   }");
        for (Column C : O._Columns)
          if (C != null && C.getType() == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
            {
              Out.println();
              Out.println("  private final ZonedDateTime ProcessZDT(String TimezoneId, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)");
              Out.println("  throws Exception");
              Out.println("   {");
              Out.println("     tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(TimezoneId);");
              Out.println("     if (ZI == null && TextUtil.isNullOrEmpty(TimezoneId) == false)");
              Out.println("      throw new Exception(\"Cannot set field '\"+DTFieldName+\"' because the timezone Id '\" + TimezoneId + \"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
              Out.println("     ZonedDateTime ZDT = DateTimeUtil.toZonedDateTime(RS.getTimestamp(ColumnPos, DateTimeUtil._UTC_CALENDAR), ZI == null ? \"null\" : ZI.getValue());");
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
          if (C != null && C.getType() == ColumnType.DATETIME && Object.isOCCColumn(C) == false && C.isCollection() == true)
            {
              Out.println("  private final List<ZonedDateTime> ProcessZDTs(Connection C, List<String> TimezoneIds, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)");
              Out.println("  throws Exception");
              Out.println("   {");
              Out.println("     List<Timestamp> L = (List<Timestamp>) C.getArray(RS, ColumnPos, DTField._Type, false);");
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
        Out.println();
        Out.println("   protected abstract boolean AfterRead(Connection C) throws Exception;");
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
          if (C != null && C._FrameworkManaged == false)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              boolean Nullable = C._Nullable == true && C._Mode != ColumnMode.CALCULATED;

              Out.print((First == false ? "               + \"; " : "                   \"") + C.getName());

              if (Nullable)
                Out.print("\"" + Pad + "   + (__Nulls.intersects(" + Mask + ") == true ? \": NULL\" : \"");

              String Lead = Nullable == true ? "" : PaddingUtil.getPad(Mask.length() + Pad.length() * 2) + "                                        ";
              if (C.isCollection() == false)
                {
                  if (C.getType() == ColumnType.DATETIME)
                    {
                      Out.print(": \"" + Lead + " + DateTimeUtil.printDateTimeForJSON(get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "())");
                    }
                  else if (C.getType() == ColumnType.JSON)
                    {
                      Out.print(": \"" + Lead + " + TextUtil.PrintVariableStr        (_" + C.getName() + ")");
                    }
                  else if (C.getType() == ColumnType.STRING)
                    {
                      Out.print(": \"" + Lead + " + TextUtil.PrintVariableStr        (get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "())");
                    }
                  else
                    {
                      Out.print(": \"" + Lead + " +                                   get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "() ");
                    }
                }
              else
                {
                  if (C.getType() == ColumnType.JSON)
                    Out.print(": \"" + Lead + " + TextUtil.PrintVariableStr        (_" + C.getName() + ")");
                  else
                    Out.print(": \"" + Lead + " + TextUtil.Print                   (get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "())");
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
        boolean JSONDone = false;
        boolean CSVDone = false;
        for (OutputMapping OM : O._OutputMaps)
          {
            if (OM._OutputTypes.contains(OutputFormatType.JSON) == true && JSONDone == false)
              {
                JSONDone = true;
                Out.println("   public void toJSON(java.io.Writer Out, String ExportName, boolean FullObject) throws Exception");
                Out.println("    {");
                Out.println("      switch (ExportName)");
                Out.println("        { ");
                for (OutputMapping OM2 : O._OutputMaps)
                  if (OM2 != null && OM2._OutputTypes.contains(OutputFormatType.JSON) == true)
                    Out.println("          case \"" + OM2._Name + "\": " + Helper.getFullAppJsonClassName(O) + ".toJSON" + OM2._Name + "(Out, (" + Helper.getFullAppDataClassName(O) + ") this, FullObject); break;");
                Out.println("          default: throw new Exception(\"Unknown JSON exporter '\"+ExportName+\"' for " + Helper.getFullAppJsonClassName(O) + "\");");
                Out.println("        } ");
                Out.println("    }");
              }
            else if (OM._OutputTypes.contains(OutputFormatType.CSV) == true && CSVDone == false)
              {
                CSVDone = true;
                Out.println("   public void toCSV(java.io.Writer Out, String ExportName) throws Exception");
                Out.println("    {");
                Out.println("      switch (ExportName)");
                Out.println("        { ");
                for (OutputMapping OM2 : O._OutputMaps)
                  if (OM2 != null && OM2._OutputTypes.contains(OutputFormatType.CSV) == true)
                    Out.println("          case \"" + OM2._Name + "\": " + Helper.getFullAppJsonClassName(O) + ".toCSV" + OM2._Name + "(Out, (" + Helper.getFullAppDataClassName(O) + ") this); break;");
                Out.println("          default: throw new Exception(\"Unknown CSV exporter '\"+ExportName+\"' for " + Helper.getFullAppJsonClassName(O) + "\");");
                Out.println("        } ");
                Out.println("    }");
              }
            for (OutputFormatType OTF : OM._OutputTypes)
              if (OTF != OutputFormatType.JSON && OTF != OutputFormatType.CSV && OTF != OutputFormatType.NVP)
                throw new Error("Object '" + O.getFullName() + "' is defining an output mapping '" + O._Name + "' with an unsupported output format type " + OTF.name() + ".");
          }
      }


  }
