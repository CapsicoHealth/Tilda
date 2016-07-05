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

import tilda.enums.ColumnMapperMode;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.ProtectionType;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenTildaData;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ColumnValue;
import tilda.parsing.parts.JsonMapping;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
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
    public void genFileStart(PrintWriter Out, Schema S)
      throws Exception
      {
        Out.println("package " + S._Package + "." + Helper.TILDA_GEN_PACKAGE + ";");
        Out.println();
        Out.println("import java.io.IOException;");
        Out.println("import java.io.Writer;");
        Out.println("import java.time.OffsetDateTime;");
        Out.println("import java.time.ZoneId;");
        Out.println("import java.time.ZonedDateTime;");
        Out.println("import java.util.ArrayList;");
        Out.println("import java.util.Arrays;");
        Out.println("import java.util.HashMap;");
        Out.println("import java.util.TreeSet;");
        Out.println("import java.util.Iterator;");
        Out.println("import java.util.List;");
        Out.println("import java.util.Map;");
        Out.println("import java.util.Set;");
        Out.println();
        Out.println("import org.apache.logging.log4j.LogManager;");
        Out.println("import org.apache.logging.log4j.Logger;");
        Out.println();
        Out.println("import tilda.db.ArrayListResults;");
        Out.println("import tilda.db.Connection;");
        Out.println("import tilda.db.InitMode;");
        Out.println("import tilda.db.JDBCHelper;");
        Out.println("import tilda.db.ListResults;");
        Out.println("import tilda.db.QueryDetails;");
        Out.println("import tilda.db.QueryHelper;");
        Out.println("import tilda.db.processors.RecordProcessor;");
        Out.println("import tilda.enums.ColumnType;");
        Out.println("import tilda.enums.StatementType;");
        Out.println("import tilda.enums.TransactionType;");
        Out.println("import tilda.performance.PerfTracker;");
        Out.println("import tilda.utils.CollectionUtil;");
        Out.println("import tilda.utils.DateTimeUtil;");
        Out.println("import tilda.utils.DurationUtil;");
        Out.println("import tilda.utils.HTMLFilter;");
        Out.println("import tilda.utils.ParseUtil;");
        Out.println("import tilda.utils.JSONUtil;");
        Out.println("import tilda.utils.SystemValues;");
        Out.println("import tilda.utils.TextUtil;");
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
        if (O._Json.isEmpty() == false)
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
        Out.println("   private InitMode __Init   = null;");
        Out.println("   private long     __Nulls  = 0L;");
        Out.println("   private int      __LookupId;");
        Out.println("   private boolean  __NewlyCreated = false;");
        Out.println();
        Out.println("   private long     __Changes= 0L;");
        Out.println();
        Out.println("   public  boolean hasChanged    () { return __Changes != 0L; }");
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

        Out.print("   " + JavaJDBCType.getFieldType(C) + " _" + C.getName());
        if (C.isCollection() == false)
         switch (C._Type)
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
              Out.print("= new ArrayList<"+JavaJDBCType.getFieldTypeBaseClass(C)+">()");
            else if (C.isSet() == true)
              Out.print("= new TreeSet<"+JavaJDBCType.getFieldTypeBaseClass(C)+">()");
          }
          
        Out.println(";");
        if (C.isSavedField() == true)
          Out.println("   protected " + JavaJDBCType.getFieldType(C) + " __Saved_" + C.getName() + ";");
      }

    @Override
    public void genFieldValues(PrintWriter Out, GeneratorSession G, Column C)
      {
        if (C._MapperDef != null)
          {
            Out.println("   public static final String[][] _" + C.getName() + "_Values = "+Helper.getFullAppDataClassName(C._MapperDef._DestObjectObj)+"._group_Values;");
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
                          if (First == true) First = false; else Out.print("``");
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
                            + " = " + Helper.getFullAppDataClassName(C._MapperDef._DestObjectObj) + "._group" + V._Name+";");
                }
              else
                {
                  Out.print("   public static final " + JavaJDBCType.getFieldTypeBase(C) + " _" + C.getName() + TextUtil.CapitalizeFirstCharacter(V._Name) + C._PadderValueNames.getPad(V._Name) + " = ");
                  switch (V._ParentColumn._Type)
                    {
                      case BOOLEAN:
                      case DOUBLE:
                      case FLOAT:
                      case INTEGER:
                      case LONG:
                        Out.print(V._Value);
                        break;
                      case CHAR:
                        Out.print(TextUtil.EscapeSingleQuoteForSQL(V._Value));
                        break;
                      case DATETIME:
                        if (V._Value.equalsIgnoreCase("NOW") == true)
                          Out.print("DateTimeUtil.NOW_PLACEHOLDER_ZDT");
                        else if (V._Value.equalsIgnoreCase("UNDEFINED") == true)
                          Out.print("DateTimeUtil.UNDEFINED_PLACEHOLDER_ZDT");
                        else
                          Out.print("DateTimeUtil.toCalendarNoThrow(" + TextUtil.EscapeDoubleQuoteWithSlash(V._Value) + ")");
                        break;
                      case STRING:
                      case JSON:
                        Out.print(TextUtil.EscapeDoubleQuoteWithSlash(V._Value));
                        break;
                      case BINARY:
                      case BITFIELD:
                        throw new Error("An invalid type '" + V._ParentColumn._Type + "' was assigned column values for code gen.");
                      default:
                        throw new Error("Unhandled case in switch for type '" + V._ParentColumn._Type + "'.");
                    }
                  Out.println(";");
                }
            }


      }


    @Override
    public void genMethodGet(PrintWriter Out, GeneratorSession G, Column C)
      throws Exception
      {
        if (C._Mode == ColumnMode.CALCULATED && C._MapperDef == null)
          Out.println("   public abstract " + JavaJDBCType.getFieldType(C) + " get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "();");
        else if (C.isCollection() == false)
          {
            Out.println("   public final " + JavaJDBCType.getFieldType(C) + " get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
            Out.println("      { return _" + C.getName() + "; }");
          }
        else
          {
            Out.println("   public final Iterator<" + JavaJDBCType.getFieldTypeBaseClass(C) + "> get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
            Out.println("      { return _" + C.getName() + "==null? null : _" + C.getName() + ".iterator(); }");
            Out.println("   public final boolean has" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "("+ JavaJDBCType.getFieldTypeBase(C) +" v)");
            Out.println("      { return _" + C.getName() + "==null? false : _" + C.getName() + ".contains(v); }");
          }
      }

    @Override
    public void genMethodIs(PrintWriter Out, GeneratorSession G, ColumnValue V)
      {
        String ValueNameVar = "_"+ V._ParentColumn.getName() + TextUtil.CapitalizeFirstCharacter(V._Name);
        Out.println("   public final boolean is" + TextUtil.CapitalizeFirstCharacter(V._ParentColumn.getName()) + TextUtil.CapitalizeFirstCharacter(V._Name) + "()");
        if (V._ParentColumn.isCollection() == true)
         Out.println("      { return  _" + V._ParentColumn.getName() +" != null && _" + V._ParentColumn.getName()+".contains(" + ValueNameVar + ") == true; }");
        else switch (V._ParentColumn._Type)
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
              throw new Error("An invalid type '" + V._ParentColumn._Type + "' was assigned column values for code gen.");
            default:
              throw new Error("Unhandled case in switch for type '" + V._ParentColumn._Type + "'.");
          }
      }

    @Override
    public void genMethodSet(PrintWriter Out, GeneratorSession G, Column C)
      throws Exception
      {
        String Mask = Helper.getRuntimeMask(C);
        String Visibility = Helper.getVisibility(C, true);
        
        if (C.isCollection() == true)
          {
            Out.println("   "+Visibility+" void set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldType(C) + " v) throws Exception");
            Out.println("     {");
            Out.println("       long T0 = System.nanoTime();");
            if (C._Invariant == true || C._ParentObject.getLifecycle() != ObjectLifecycle.NORMAL)
              {
                Out.println("       if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)");
                Out.println("        throw new Exception(\"Cannot set field '" + C.getFullName() + "' that is invariant, or part of a read-only or pre-existing WORM object.\");");
              }
            Out.println("       if (v == null)");
            if (C._Nullable == true)
              Out.println("        setNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "();");
            else
              Out.println("        throw new Exception(\"Cannot set " + C.getFullName() + " to null: it's not nullable.\");");
            Out.println("       else if (CollectionUtil.equals(v, _"+C.getName()+") == false)");
            Out.println("        {");
            if (C._MapperDef == null)
              {
                Out.println("          __Changes |= " + Mask + ";");
                Out.println("          __Nulls   &= ~" + Mask + ";");
                if (C._Mapper != null)
                  {
                    if (C._Mapper._Name == ColumnMapperMode.DB)
                      {
                        Out.println("          __Changes |= " +  Helper.getRuntimeMask(C._ParentObject.getColumn(C.getName() +"MappedName")) + ";");
                        Out.println("          __Nulls   &= ~" +  Helper.getRuntimeMask(C._ParentObject.getColumn(C.getName() +"MappedName")) + ";");
                      }
                    if (C._Mapper._Group == ColumnMapperMode.DB)
                      {
                        Out.println("          __Changes |= " +  Helper.getRuntimeMask(C._ParentObject.getColumn(C.getName() +"MappedGroup")) + ";");
                        Out.println("          __Nulls   &= ~" +  Helper.getRuntimeMask(C._ParentObject.getColumn(C.getName() +"MappedGroup")) + ";");
                      }
                  }
              }
            Out.println("          if (_" + C.getName() + " == null)");
            Out.println("           _" + C.getName() + " = new "+(C.isList() == true ? "ArrayList": "TreeSet")+"<"+ JavaJDBCType.getFieldTypeBaseClass(C)+">();");
            Out.println("          else");
            Out.println("           _"+C.getName()+".clear();");
            if (C._Mapper != null)
              {
                if (C._Mapper._Name != ColumnMapperMode.NONE)
                 {
                   Out.println("          if (_" + C.getName() +"MappedName == null)");
                   Out.println("           _" + C.getName() + "MappedName = new "+(C.isList() == true ? "ArrayList": "TreeSet")+"<"+ JavaJDBCType.getFieldTypeBaseClass(C)+">();");
                   Out.println("          else");
                   Out.println("           _" + C.getName() +"MappedName.clear();");
                 }
                if (C._Mapper._Group != ColumnMapperMode.NONE)
                  {
                    Out.println("          if (_" + C.getName() +"MappedGroup == null)");
                    Out.println("           _" + C.getName() + "MappedGroup = new "+(C.isList() == true ? "ArrayList": "TreeSet")+"<"+ JavaJDBCType.getFieldTypeBaseClass(C)+">();");
                    Out.println("          else");
                    Out.println("           _" + C.getName() +"MappedGroup.clear();");
                  }
              }
            Out.println("          for ("+ JavaJDBCType.getFieldTypeBase(C)+" i : v)");
            Out.println("           {");
            if (C._Enum != null)
              {
                String FactoryClassName = Helper.getFullAppFactoryClassName(C._Enum._DestObjectObj);
                String DataClassName    = Helper.getFullAppDataClassName(C._Enum._DestObjectObj);
                Out.println("             "+ DataClassName +" e = "+FactoryClassName+".getEnumerationById(i);");
                Out.println("             if (e == null)");
                Out.println("              throw new Exception(\"Cannot set " + C.getFullName() + ": the value \'\"+i+\"\' is not a valid Enumerated value as per \'"+FactoryClassName+"\'.\");");
                Out.println("             _" + C.getName() + ".add(e.getId());");
              }
            else
              Out.println("             _" + C.getName() + ".add(i);");
            if (C._Mapper != null)
              {
                String ClassName = Helper.getFullAppFactoryClassName(C._Mapper._DestObjectObj);
                StringBuilder Str = new StringBuilder();
                for (int c = 0; c < C._Mapper._SrcColumnObjs.size()-1; ++c)
                  {
                    Column col = C._Mapper._SrcColumnObjs.get(c);
                    if (c != 0) Str.append(", ");
                    Str.append("get" + TextUtil.CapitalizeFirstCharacter(col.getName()) + "()");
                  }
                if (C._Mapper._Name != ColumnMapperMode.NONE)
                  Out.println("             _" + C.getName() + "MappedName.add("+ClassName+".getMappedName("+Str+", i));");
                if (C._Mapper._Group != ColumnMapperMode.NONE)
                  Out.println("             _" + C.getName() + "MappedGroup.add("+ClassName+".getMappedGroup("+Str+", i));");
              }
            Out.println("          }");
            Out.println("        }");
            Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
            Out.println("     }");
          }
        

        if (C.isList() == true)
         Out.println("   " + Visibility + " void addTo" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(int pos, " + JavaJDBCType.getFieldTypeBase(C) + " v) throws Exception");
        else if (C.isSet() == true)
         Out.println("   " + Visibility + " void addTo" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldTypeBase(C) + " v) throws Exception");
        else
         Out.println("   " + Visibility + " void set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldType(C) + " v) throws Exception");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        if (C.isCollection() == true)
          {
            Out.println("       if (_" + C.getName() + " == null)");
            Out.println("        _" + C.getName() + " = new "+(C.isList() == true ? "ArrayList": "TreeSet")+"<"+ JavaJDBCType.getFieldTypeBaseClass(C)+">();");
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
             Out.println("          "+(C.isCollection() == true ? "addTo":"set")+TextUtil.CapitalizeFirstCharacter(C.getName())+"EnumValue(e.getValue());");
            Out.println("        }");
          }
        switch (C._Type)
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
                Out.println("       if (_" + C.getName() + ".get(pos).equals(v) == false)");
              else
                Out.println("       if (v != _" + C.getName() + ")");
              Out.println("        {");
              break;
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
                  if (C._Type == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
                    {
                      Out.println("          setNull"+TextUtil.CapitalizeFirstCharacter(C.getName())+"TZ();");
                    }
                  Out.println("        }");
                }
              else
                Out.println("        throw new Exception(\"Cannot set " + C.getFullName() + " to null: it's not nullable.\");");
              if (C._Type == ColumnType.STRING && C.isCollection() == false)
                {
                  Out.println("       else if (v.length() > " + C._Size + ")");
                  Out.println("        throw new Exception(\"Cannot set " + C.getFullName() + ": the value \"+TextUtil.EscapeDoubleQuoteWithSlash(v)+\" is larger than the max size allowed " + C._Size + ".\");");
                }
              if (C.isSet() == true)
                Out.println("       else if (_" + C.getName() + ".contains(v) == false)");
              else if (C.isList() == true)
                Out.println("       else if (_" + C.getName() + ".get(pos).equals(v) == false)");
              else
                Out.println("       else if (v.equals(_" + C.getName() + ") == false)");
              Out.println("        {");
              if (C._Type == ColumnType.STRING && C.isCollection() == false)
                {
                  if (C._Protect == ProtectionType.ABSOLUTE)
                    Out.println("          v = HTMLFilter.CleanAbsolute(v);");
                  else if (C._Protect == ProtectionType.SMART)
                    Out.println("          v = HTMLFilter.CleanSmart(v);");
                }
              break;
            case BINARY:
              break;
            default:
              throw new Error("ERROR! Cannot match ColumnType " + C._Type + " when generating a setter");
          }

        if (C._Invariant == true || C._ParentObject.getLifecycle() != ObjectLifecycle.NORMAL)
          {
            Out.println("          if (__Init != InitMode.CREATE && __Init != InitMode.LOOKUP)");
            Out.println("           throw new Exception(\"Cannot set field '" + C.getFullName() + "' that is invariant, or part of a read-only or pre-existing WORM object.\");");
          }
        if (C._Mode != ColumnMode.CALCULATED)
         {
           Out.println("          __Changes |= " + Mask + ";");
           Out.println("          __Nulls   &= ~" + Mask + ";");
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
           for (int c = 0; c < C._Mapper._SrcColumnObjs.size()-1; ++c)
             {
               Column col = C._Mapper._SrcColumnObjs.get(c);
               if (c != 0) Str.append(", ");
               Str.append("get" + TextUtil.CapitalizeFirstCharacter(col.getName()) + "()");
             }

           if (C._Mapper._Name != ColumnMapperMode.NONE)
            Out.println("          "+(C.isCollection()==true?"addTo":"set") + TextUtil.CapitalizeFirstCharacter(C.getName()) +"MappedName("+ClassName+".getMappedName("+Str+", v));");
           if (C._Mapper._Group != ColumnMapperMode.NONE)
            Out.println("          "+(C.isCollection()==true?"addTo":"set") + TextUtil.CapitalizeFirstCharacter(C.getName()) +"MappedGroup("+ClassName+".getMappedGroup("+Str+", v));");
         }
        if (C._Type == ColumnType.DATETIME && Object.isOCCColumn(C) == false)
          {
            Out.println("          tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationByValue(v.getZone().getId());");
            Out.println("          if (ZI == null)");
            Out.println("           throw new Exception(\"Cannot set field '" + C.getFullName() + "' because the timezone value '\"+v.getZone().getId()+\"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
            Out.println("          set"+TextUtil.CapitalizeFirstCharacter(C.getName())+"TZ(ZI.getId());");
          }
        if (C._Type != ColumnType.BINARY)
          Out.println("        }");
        Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
        Out.println("     }");

        if (C.isCollection() == true)
          {
            Out.println("   " + Visibility + " void removeFrom" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "(" + JavaJDBCType.getFieldTypeBaseClass(C) + " v) throws Exception");
            Out.println("     {");
            if (C._Mode != ColumnMode.CALCULATED)
             {
               Out.println("       if (_" + C.getName() + ".remove(v) == true)");
               Out.println("          __Changes |= " + Mask + ";");
             }
            else
              Out.println("       _" + C.getName() + ".remove(v);");
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
                Out.println("          __Changes |= " + Mask + ";");
              }
             else
               Out.println("       _" + C.getName() + ".remove(pos);");
            Out.println("       PerfTracker.add(TransactionType.TILDA_SETTER, System.nanoTime() - T0);");
            Out.println("     }");
          }
      }

    @Override
    public void genMethodSetAs(PrintWriter Out, GeneratorSession G, ColumnValue V)
      {
        String ValueNameVar = "_"+ V._ParentColumn.getName() + TextUtil.CapitalizeFirstCharacter(V._Name);
        Out.println("   public void set" + TextUtil.CapitalizeFirstCharacter(V._ParentColumn.getName()) + TextUtil.CapitalizeFirstCharacter(V._Name) + "() throws Exception");
        switch (V._ParentColumn._Type)
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
            case BINARY:
            case BITFIELD:
            case JSON:
              throw new Error("An invalid type '" + V._ParentColumn._Type + "' was assigned column values for code gen.");
            default:
              throw new Error("Unhandled case in switch for type '" + V._ParentColumn._Type + "'.");
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

        Out.println("   " + Visibility + " void setNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        if (C._Mode != ColumnMode.CALCULATED)
         {
            Out.println("       if ((" + Mask + " & __Nulls) != 0L)");
            Out.println("        return;");
            Out.println("       __Changes |= " + Mask + ";");
            Out.println("       __Nulls   |= " + Mask + ";");
         }

        if (C.isCollection() == true)
          Out.println("       _" + C.getName() + "=null;");
        else
          switch (C._Type)
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
              case STRING:
              case JSON:
              case BINARY:
                Out.println("       _" + C.getName() + "=null;");
                break;
              default:
                throw new Error("ERROR! Cannot match ColumnType " + C._Type + " when generating a null setter");
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
        Out.println("     { return (" + Mask + " & __Changes) != 0L; }");
      }

    @Override
    public void genMethodIsNull(PrintWriter Out, GeneratorSession G, Column C)
      throws Exception
      {
        String Mask = Helper.getRuntimeMask(C);
        Out.println("   public final boolean isNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
        Out.println("     { return (" + Mask + " & __Nulls) != 0L; }");
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

    @Override
    public void genMethodWrite(PrintWriter Out, GeneratorSession G, Object O)
      throws Exception
      {
        Out.println("   public final boolean Write(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        Out.println("       if (__Changes == 0L)");
        Out.println("        {");
        Out.println("          LOG.debug(\"The " + O.getFullName() + " has not changed: no writing will occur.\");");
        Out.println("          QueryDetails.setLastQuery("+O.getBaseClassName()+"_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("          return true;");
        Out.println("        }");
        Out.println();
        Out.println("       StringBuilder S = new StringBuilder(1024);");
        Out.println();
        Out.println("       if (BeforeWrite(C) == false)");
        Out.println("        {");
        Out.println("          LOG.debug(\"The " + O.getFullName() + " object's BeforeWrite() failed.\");");
        Out.println("          QueryDetails.setLastQuery("+O.getBaseClassName()+"_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("          return false;");
        Out.println("        }");
        Out.println();
        Out.println("       if (__Init == InitMode.CREATE)");
        Out.println("        {");
        Out.println("          StringBuilder V = new StringBuilder(1024);");
        Out.println("          S.append(\"insert into \"); "+Helper.getFullTableVarAtRuntime(O)+";");
        Out.println("          int Pos = S.length();");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              if (C._Type == ColumnType.DATETIME)
                Out.println();
              Out.print("          if ((" + Mask + Pad + " & __Changes) != 0L) { " + Helper.getRuntimeInsertStr(C) + ";");
              switch (C._Type)
                {
                  case DATETIME:
                    Out.println();
                    Out.println("             V.append((" + Mask + " & __Nulls) == 0L && DateTimeUtil.isNowPlaceholder(_" + C.getName() + ") == true ? C.getCommaCurrentTimestamp() : "+Helper.getSupportClassFullName(O._ParentSchema)+"._COMMAQUESTION);");
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
                    Out.println(" V.append("+Helper.getSupportClassFullName(O._ParentSchema)+"._COMMAQUESTION);  }");
                    break;
                  default:
                    throw new Error("ERROR! Cannot match ColumnType " + C._Type + " when generating a Write method");
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
        Out.println("          S.append(\"update \"); "+Helper.getFullTableVarAtRuntime(O)+"; S.append(\" set\");");
        Out.println("          int Pos = S.length();");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              if (C._Type == ColumnType.DATETIME)
                Out.println();
              switch (C._Type)
                {
                  case DATETIME:
                    Out.println("          if ((" + Mask + " & __Changes) != 0L)");
                    Out.println("           {");
                    Out.println("             if ((" + Mask + " & __Nulls) == 0L && DateTimeUtil.isNowPlaceholder(_" + C.getName() + ") == true)");
                    Out.println("              { " + Helper.getRuntimeInsertStr(C) + "; S.append(C.getEqualCurrentTimestamp()); }");
                    Out.println("             else");
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
//                    String MethodName = TextUtil.CapitalizeFirstCharacter(C.getName()) + TextUtil.CapitalizeFirstCharacter(C._DefaultUpdateValue._Name);
//                    Out.println("          if ((" + Mask + Pad + " & __Changes) == 0L) set" + MethodName + "();");
//                    Out.println("          S.append(" + Helper.getRuntimeUpdateStr(C) + ");");
//                    Out.println(" V.append(\",cast(? as "+G.getSql().getColumnTypeRaw(C, false)+")\");  }");
//                    break;
                  case BINARY:
                  case BITFIELD:
                  case BOOLEAN:
                  case CHAR:
                  case DOUBLE:
                  case FLOAT:
                  case INTEGER:
                  case LONG:
                  case STRING:
                    if (C._DefaultUpdateValue == null)
                      Out.println("          if ((" + Mask + Pad + " & __Changes) != 0L) " + Helper.getRuntimeUpdateStr(C) + ";");
                    else
                      {
                        String MethodName = TextUtil.CapitalizeFirstCharacter(C.getName()) + TextUtil.CapitalizeFirstCharacter(C._DefaultUpdateValue._Name);
                        Out.println("          if ((" + Mask + Pad + " & __Changes) == 0L) set" + MethodName + "();");
                        Out.println("          " + Helper.getRuntimeUpdateStr(C) + ";");
                      }

                    break;
                  default:
                    throw new Error("ERROR! Cannot match ColumnType " + C._Type + " when generating a Write method");
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
        Out.println("       QueryDetails.setLastQuery("+O.getBaseClassName()+"_Factory.SCHEMA_TABLENAME_LABEL, Q);");
        Out.println("       LOG.debug(\"TILDA(" + AnsiUtil.NEGATIVE + O.getShortName() + AnsiUtil.NEGATIVE_OFF + "): \"+Q);");
        Out.println("       LOG.debug(\"   \"+toString());");
        Out.println("       java.sql.PreparedStatement PS = null;");
        Out.println("       int count = 0;");
        Out.println("       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();");
        Out.println("       try");
        Out.println("        {");
        Out.println("          PS = C.prepareStatement(Q);");
        Out.println("          int i = 0;");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              Out.println("               if ((" + Mask + Pad + " & __Changes) != 0L) ");
              Out.println("                { ");
              Out.print  ("                  if ((" + Mask + Pad + " & __Nulls  ) != 0L) PS.setNull(++i, java.sql.Types." + JavaJDBCType.get(C._Type)._JDBCSQLType + ");");
//              if (C.isCollection() == true && C._Type == ColumnType.FLOAT)
//                {
//                  int xxx = 0;
//                  ++xxx;
//                  LOG.debug("SQL Raw type: "+G.getSql().getColumnTypeRaw(C, false));
//                }
              switch (C._Type)
                {
                  case DATETIME:
                    Out.print(" else if (DateTimeUtil.isNowPlaceholder(_"+C.getName()+") == false) ");
                    if (C.isCollection() == false)
                      Out.println("PS.setTimestamp(++i, new java.sql.Timestamp(_" + C.getName() + ".toInstant().toEpochMilli()), DateTimeUtil._UTC_CALENDAR);");
                    else 
                      Out.println("C.setArray(PS, ++i, "+O._BaseClassName+"_Factory.COLS."+C.getName().toUpperCase()+"._Type, AllocatedArrays, _" + C.getName() + ");");
//                      Out.println("{ java.sql.Array A = C.createArrayOf(\"" + G.getSql().getColumnTypeRaw(C, false) + "\", _" + C.getName() + "); AllocatedArrays.add(A); PS.setArray(++i, A); }");
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
                  case JSON:
                    Out.print(" else ");
                    if (C.isCollection() == false)
                      Out.println("PS.set" + JavaJDBCType.get(C._Type)._JDBCType + "(++i, " + (C._Type == ColumnType.CHAR ? "\"\"+" : "") + "_" + C.getName() + ");");
                    else
                      Out.println("C.setArray(PS, ++i, "+O._BaseClassName+"_Factory.COLS."+C.getName().toUpperCase()+"._Type, AllocatedArrays, _" + C.getName() + ");");
//                      Out.println("{ java.sql.Array A = C.createArrayOf(\"" + G.getSql().getColumnTypeRaw(C, false) + "\", " + (C._Type == ColumnType.STRING ? "" : Helper.DeSerializeArray(G)) + "(_" + C.getName()
//                          + ")); AllocatedArrays.add(A); PS.setArray(++i, A); }");
                    break;
                  default:
                    throw new Error("ERROR! Cannot match ColumnType " + C._Type + " when generating a Write method");
                }
              Out.println("                } ");
            }
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
        Out.println("       __Changes= 0L   ;");
        Out.println("       __Nulls  = 0L   ;");
        Out.println();
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
               Out.print("       if ((" + Mask + Pad + " & __Nulls) != 0L) Dst.setNull" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad+ "(); else ");
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
        Out.println("       if (__Init == InitMode.READ == true && Force == false && __Changes == 0L)");
        Out.println("        {");
        Out.println("          LOG.debug(\"This " + O.getShortName() + " object has already been read.\");");
        Out.println("          QueryDetails.setLastQuery("+O.getBaseClassName()+"_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("          return true;");
        Out.println("        }");
        Out.println("       StringBuilder S = new StringBuilder(1024);");
        Helper.SelectFrom(Out, O);
        Helper.SwitchLookupIdWhereClauses(Out, G, O, "       ", true);
        Out.println();
        Out.println("       String Q = S.toString();");
        Out.println("       S.setLength(0);");
        Out.println("       S = null;");
        Out.println("       QueryDetails.setLastQuery("+O.getBaseClassName()+"_Factory.SCHEMA_TABLENAME_LABEL, Q);");
        Out.println("       LOG.debug(\"TILDA(" + AnsiUtil.NEGATIVE + O.getShortName() + AnsiUtil.NEGATIVE_OFF + "): \"+Q);");
        Out.println("       LOG.debug(\"   \"+toString());");
        Out.println("       java.sql.PreparedStatement PS=null;");
        Out.println("       java.sql.ResultSet RS=null;");
        Out.println("       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();");
        Out.println("       int count = 0;");
        Out.println();
        Out.println("       try");
        Out.println("        {");
        Out.println("          PS = C.prepareStatement(Q);");
        Out.println("          int i = 0;");
        Helper.SwitchLookupIdPreparedStatement(Out, G, O, "          ", true, false);
        Out.println();
        Out.println("          RS = PS.executeQuery();");
        Out.println("          if (RS.next() == false)");
        Out.println("            {");
        Out.println("              LOG.debug(\"   " + AnsiUtil.BOLD + "No record was read." + AnsiUtil.BOLD_OFF + "\");");
        Out.println("              return false;");
        Out.println("            }");
        Out.println("          count = 1;");
        Out.println("          return Init(C, RS);");
        Out.println("        }");
        Helper.CatchFinallyBlock(Out, O, "selected", "StatementType.SELECT", false, false);
        Out.println("    }");
        Out.println();
        Out.println("   @SuppressWarnings(\"unchecked\")");
        Out.println("   boolean Init(Connection C, java.sql.ResultSet RS) throws Exception");
        Out.println("    {");
        Out.println("      int i = 0;");
//        Out.println("      java.sql.Array A;");
        Out.println("      tilda.data.ZoneInfo_Data ZI;");
        Out.println("      boolean DateTimeFieldNull;");
        Out.println("      boolean ZoneFieldNull;");
        Out.println("     __Init = InitMode.LOOKUP;");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String Mask = Helper.getRuntimeMask(C);
              String Pad = O._PadderColumnNames.getPad(C.getName());
              Out.print("      ");
              if (C._PrimaryKey == true || C._UniqueIndex == true)
                Out.print("__Saved_" + C.getName() + Pad + " = ");
              else
                Out.print("        " + PaddingUtil.getPad(C.getName().length() + Pad.length()) + "   ");
              switch (C._Type)
                {
                  case DOUBLE:
                  case FLOAT:
                  case INTEGER:
                  case LONG:
                  case BINARY:
                  case BITFIELD:
                  case BOOLEAN:
                  case CHAR:
                  case STRING:
                  case JSON:
                    if (C.isCollection() == true)
                     Out.print("_" + C.getName() +" = ("+(C.isSet()==true?"Set<":"List<")+JavaJDBCType.get(C._Type)._JavaClassType+">) C.getArray(RS, ++i, "+O._BaseClassName+"_Factory.COLS."+C.getName().toUpperCase()+"._Type, "+C.isSet()+");");
//                     Out.print("A = RS.getArray(++i); _" + C.getName() + Pad + " = A==null?null:CollectionUtil.to"+(C.isList()==true?"List":"Set ")+"(("+ JavaJDBCType.getFieldTypeBaseClass(C)+"[])A.getArray()); if (A != null) A.free();");
                    else if (C._Type == ColumnType.CHAR)
                      Out.print("_" + C.getName() + Pad + " = ParseUtil.parseCharacter    (RS.get" + JavaJDBCType.get(C._Type)._JDBCType + "(++i)); ");
                    else
                      Out.print("_" + C.getName() + Pad + " =                              RS.get" + JavaJDBCType.get(C._Type)._JDBCType + "(++i) ; ");
                    Out.print(" if (RS.wasNull() == true) __Nulls |= " + Mask + Pad + ";");
                    break;
                  case DATETIME:
                    if (C.isCollection() == true)
                      // Out.print("_" + C.getName() + Pad + " = " + SerializeArray(G) + "((" + JavaJDBCType.get(C._Type)._JavaClassType + "[])RS.getArray(++i).getArray());");
                      throw new Error("Cannot do DateTime arrays yet!");
                    else if (C.isOCCGenerated() == false)
                      Out.print  ("_" + C.getName() + Pad + " = ProcessZDT(_"+C.getName()+"TZ"+Pad+", \""+C.getFullName()+"\""+Pad+", RS, ++i, "+O._BaseClassName+"_Factory.COLS."+C.getName().toUpperCase()+Pad+", "+O._BaseClassName+"_Factory.COLS."+C.getName().toUpperCase()+"TZ"+Pad+");");
                    else
                      Out.print  ("_" + C.getName() + Pad + " = DateTimeUtil.toZonedDateTime(RS.getTimestamp(++i, DateTimeUtil._UTC_CALENDAR), "+(Object.isOCCColumn(C) == true ? "null":"_"+C.getName()+"TZ")+");");
                    break;
                  default:
                    throw new Error("ERROR! Cannot match ColumnType " + C._Type + " when generating the Read method");
                }
              if (G.getSql().stringNeedsTrim(C) == true)
               Out.print(" else _"+C.getName()+Pad+" = _"+C.getName()+Pad+".trim();");
              Out.println();
              if (C._Mapper != null && C._Mapper._Name == ColumnMapperMode.MEMORY)
                {
                  String Header = (C.isCollection() == true ? "             " : "          ") + PaddingUtil.getPad(C.getName().length() + Pad.length()) + "   ";
                  if (C.isCollection() == true)
                   {
                     Out.println(Header+" if (_"+C.getName()+" != null) for ("+ JavaJDBCType.getFieldTypeBase(C)+" v : _"+C.getName()+")");
                     Out.println(Header+"  {");
                   }
                  String ClassName = Helper.getFullAppFactoryClassName(C._Mapper._DestObjectObj);
                  String VarName = C.isCollection() == true ? "v" : "_"+C.getName();
                  StringBuilder Str = new StringBuilder();
                  for (int c = 0; c < C._Mapper._SrcColumnObjs.size()-1; ++c)
                    {
                      Column col = C._Mapper._SrcColumnObjs.get(c);
                      if (c != 0) Str.append(", ");
                      Str.append("get" + TextUtil.CapitalizeFirstCharacter(col.getName()) + "()");
                    }
                  if (C._Mapper._Name == ColumnMapperMode.MEMORY)
                   Out.println(Header+"    "+(C.isCollection()==true?"addTo":"set") + TextUtil.CapitalizeFirstCharacter(C.getName()) +"MappedName("+ClassName+".getMappedName("+Str+", "+VarName+"));");
                  if (C._Mapper._Group == ColumnMapperMode.MEMORY)
                   Out.println(Header+"    "+(C.isCollection()==true?"addTo":"set") + TextUtil.CapitalizeFirstCharacter(C.getName()) +"MappedGroup("+ClassName+".getMappedGroup("+Str+", "+VarName+"));");
                  if (C.isCollection() == true)
                    {
                      Out.println(Header+"  }");
                    }
                 }
              else if (C._Enum != null && C._Enum._Name == ColumnMapperMode.MEMORY)
                {
                  String Header = (C.isCollection() == true ? "             " : "          ") + PaddingUtil.getPad(C.getName().length() + Pad.length()) + "   ";
                  if (C.isCollection() == true)
                   {
                     Out.println(Header+" if (_"+C.getName()+" != null) for ("+ JavaJDBCType.getFieldTypeBase(C)+" v : _"+C.getName()+")");
                     Out.println(Header+"  {");
                   }
                  //String ClassName = Helper.getFullAppFactoryClassName(C._Enum._DestObjectObj);
                  String VarName = C.isCollection() == true ? "v" : "_"+C.getName();
                  if (C._Enum._Name == ColumnMapperMode.MEMORY)
                    {
                      String FactoryClassName = Helper.getFullAppFactoryClassName(C._Enum._DestObjectObj);
                      String DataClassName    = Helper.getFullAppDataClassName(C._Enum._DestObjectObj);
                      Out.println(Header+"    "+ DataClassName +" e = "+FactoryClassName+".getEnumerationById("+VarName+");");
                      Out.println(Header+"    if (e == null)");
                      Out.println(Header+"     throw new Exception(\"Cannot set " + C.getFullName() + ": the value \'\"+"+VarName+"+\"\' is not a valid Enumerated value as per \'"+FactoryClassName+"\'.\");");
                      Out.println(Header+"    "+(C.isCollection()==true?"addTo":"set") + TextUtil.CapitalizeFirstCharacter(C.getName()) +"EnumValue(e.getValue());");
                    }
                  if (C.isCollection() == true)
                    {
                      Out.println(Header+"  }");
                    }
                  
                }
            }
        Out.println("     __LookupId = 0;");
        Out.println("     __Init     = InitMode.READ;");
        Out.println("     __Changes  = 0L;");
        Out.println("     return AfterRead(C);");
        Out.println("   }");
        Out.println();
        Out.println("  private final ZonedDateTime ProcessZDT(String TimezoneId, String DTFieldName, java.sql.ResultSet RS, int ColumnPos, tilda.types.ColumnDefinition DTField, tilda.types.ColumnDefinition TZField)");
        Out.println("  throws Exception");
        Out.println("   {");
        Out.println("     tilda.data.ZoneInfo_Data ZI = tilda.data.ZoneInfo_Factory.getEnumerationById(TimezoneId);");
        Out.println("     if (ZI == null && TextUtil.isNullOrEmpty(TimezoneId) == false)");
        Out.println("      throw new Exception(\"Cannot set field '\"+DTFieldName+\"' because the timezone Id '\" + TimezoneId + \"' is unknown. Make sure it is mapped properly in the ZoneInfo table.\");");
        Out.println("     ZonedDateTime ZDT = DateTimeUtil.toZonedDateTime(RS.getTimestamp(ColumnPos, DateTimeUtil._UTC_CALENDAR), ZI == null ? \"null\" : ZI.getValue());");
        Out.println("     if (RS.wasNull() == true)");
        Out.println("      __Nulls |= DTField._Mask;");
        Out.println("     boolean DTNull = (__Nulls & DTField._Mask) != 0L;");
        Out.println("     boolean TZNull = (__Nulls & TZField._Mask) != 0L;");
        Out.println("     if (DTNull == false && TZNull == true)");
        Out.println("      throw new Exception(\"The field \"+DTFieldName+\" is not null while its associated timezone field '\"+DTFieldName+\"TZ' is null. A TZ is mandatory for not null timestamps.\");");
        Out.println("     return ZDT;");
        Out.println("   }");
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
                Out.print("\""+Pad+"   + ((" + Mask + Pad +" & __Nulls) != 0L ? \": NULL\" : \"");

              String Lead = Nullable==true ? "" : PaddingUtil.getPad(Mask.length() + Pad.length()*2)+"                                        ";
              if (C.isCollection() == false)
                {
                  if (C._Type == ColumnType.DATETIME)
                    {
                      Out.print(": \"" +Lead+" + DateTimeUtil.printDateTimeForJSON(get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "())");
                    }
                  else if (C._Type == ColumnType.STRING)
                    {
                      Out.print(": \"" +Lead+" + TextUtil.PrintVariableStr        (get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "())");
                    }
                  else
                    {
                      Out.print(": \"" +Lead+" +                                   get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "() ");
                    }
                }
              else
                      Out.print(": \"" +Lead+" + TextUtil.Print                   (get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "())");
                
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
    public void genMethodToJSON(PrintWriter Out, GeneratorSession G, Object O)
      {
//        Out.println("   public void toJSON(Writer Out, String JsonExportName, List<" + Helper.getFullAppDataClassName(O) + "> L, boolean FullList) throws Exception");
//        Out.println("    {");
//        Out.println("      switch (JsonExportName)");
//        Out.println("        { ");
//        for (JsonMapping j : O._Json)
//          Out.println("          case \""+j._Name+"\": "+Helper.getFullAppJsonClassName(O)+".toJson"+j._Name+"(Out, L, \"   \", FullList); break;");
//        Out.println("          default: throw new Exception(\"Unknown JSON exporter '\"+\"' for "+Helper.getFullAppJsonClassName(O)+"\");");
//        Out.println("        } ");
//        Out.println("    }");
        Out.println("   public void toJSON(Writer Out, String JsonExportName, boolean FullObject) throws Exception");
        Out.println("    {");
        Out.println("      switch (JsonExportName)");
        Out.println("        { ");
        for (JsonMapping j : O._Json)
          Out.println("          case \""+j._Name+"\": "+Helper.getFullAppJsonClassName(O)+".toJSON"+j._Name+"(Out, ("+Helper.getFullAppDataClassName(O)+") this, FullObject); break;");
        Out.println("          default: throw new Exception(\"Unknown JSON exporter '\"+JsonExportName+\"' for "+Helper.getFullAppJsonClassName(O)+"\");");
        Out.println("        } ");
        Out.println("    }");
      }

  }
