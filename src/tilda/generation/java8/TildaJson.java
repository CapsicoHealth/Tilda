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

import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenTildaJson;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.JsonMapping;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.utils.PaddingUtil;
import tilda.utils.TextUtil;

public class TildaJson implements CodeGenTildaJson
  {
    protected static final Logger LOG = LogManager.getLogger(TildaJson.class.getName());

    @Override
    public String getFileName(Base O)
      {
        return O._BaseClassName + "_Json.java";
      }

    @Override
    public void genFileStart(PrintWriter Out, Schema S)
    throws Exception
      {
        Out.println("package " + S._Package + "." + Helper.TILDA_GEN_PACKAGE + ";");
        Out.println();
        Out.println("import java.io.IOException;");
        Out.println("import java.io.Writer;");
        Out.println("import java.time.ZonedDateTime;");
        Out.println("import java.util.*;");
        Out.println();
        Out.println("import org.apache.logging.log4j.LogManager;");
        Out.println("import org.apache.logging.log4j.Logger;");
        Out.println();
        Out.println("import tilda.db.*;");
        Out.println("import tilda.enums.SyncStatus;");
        Out.println("import tilda.enums.TransactionType;");
        Out.println("import tilda.performance.*;");
        Out.println("import tilda.utils.*;");
        Out.println();
        Out.println("import com.google.gson.annotations.SerializedName;");
      }

    @Override
    public void genClassStart(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        Out.println("@SuppressWarnings({ \"unused\" })");
        Out.println("public class " + O._BaseClassName + "_Json");
        Out.println(" {");
        Out.println("   static final Logger             LOG                = LogManager.getLogger(" + O._BaseClassName + "_Json.class.getName());");
        Out.println();
        Out.println("   protected " + O._BaseClassName + "_Json() { }");
      }

    @Override
    public void genJsonSerializableField(PrintWriter Out, GeneratorSession G, List<Column> Cols)
    throws Exception
      {
        Out.println("   /*@formatter:off*/");
        for (Column C : Cols)
          {
            String Pad = C._ParentObject.getColumnPad(C.getName());
            if (C._Type == ColumnType.DATETIME)
              {
                Out.println("   @SerializedName(\"" + C.getName() + "\"" + Pad + ") public " + (C.isList() == true ? "List<String>" : C.isSet() == true ? "Set<String>" : "String") + "  Str_" + C.getName() + Pad + ";");
                Out.println("   transient          " + PaddingUtil.getPad(C.getName().length()) + Pad + " public " + (C.isCollection() == true ? JavaJDBCType.getFieldType(C) : JavaJDBCType.getFieldTypeBaseClass(C)) + "  _"
                + C.getName() + Pad + ";");
              }
            else if (C._Type == ColumnType.JSON)
              Out.println("   @SerializedName(\"" + C.getName() + "\"" + Pad + ") public com.google.gson.JsonElement _" + C.getName() + Pad + ";");
            else
              Out
              .println("   @SerializedName(\"" + C.getName() + "\"" + Pad + ") public " + (C.isCollection() == true ? JavaJDBCType.getFieldType(C) : JavaJDBCType.getFieldTypeBaseClass(C)) + "  _" + C.getName() + Pad + ";");
          }
        Out.println("   /*@formatter:on*/");
      }


    @Override
    public void genMethodWrite(PrintWriter Out, GeneratorSession G, Object O, List<Column> CreateColumns, List<Column> JsonColumns)
    throws Exception
      {
        Out.println("   public " + Helper.getFullAppDataClassName(O) + " Write(Connection C) throws Exception");
        Out.println("    {");
        for (Column C : JsonColumns)
          {
            String Pad = C._ParentObject.getColumnPad(C.getName());
            if (C._Nullable == false)
              {
                if (C.isCollection() == false && C._Type == ColumnType.STRING)
                  Out.println("      if (TextUtil.isNullOrEmpty(_" + C.getName() + Pad + ") == true)");
                else if (C.isCollection() == false && C._Type == ColumnType.DATETIME)
                  Out.println("      if (TextUtil.isNullOrEmpty(Str_" + C.getName() + Pad + ") == true)");
                else if (C.isCollection() == true)
                  Out.println("      if (_" + C.getName() + Pad + " == null || _" + C.getName() + Pad + ".isEmpty() == true)");
                else
                  Out.println("      if (_" + C.getName() + Pad + " == null)");
                Out.println("       throw new Exception(\"Incoming value for '" + C.getFullName() + "' was null or empty. It's not nullable in the model.\\n\"+toString());");
              }
            if (C._Type == ColumnType.DATETIME)
              {
                if (C._Nullable == true)
                  {
                    Out.println("      if (TextUtil.isNullOrEmpty(Str_" + C.getName() + Pad + ") == false)");
                    Out.println("       {");
                  }
                String ExtraPad = C._Nullable == true ? "   " : "";
                Out.println(ExtraPad + "      _" + C.getName() + Pad + " = DateTimeUtil.parsefromJSON(Str_" + C.getName() + Pad + ");");
                Out.println(ExtraPad + "      if (   _" + C.getName() + Pad + " == null)");
                Out.println(ExtraPad + "       throw new Exception(\"Incoming value for '" + C.getFullName() + "' was not in the expected format. Dates should follow the ISO format.\\n\"+toString());");
                if (C._Nullable == true)
                  {
                    Out.println("       }");
                  }
              }
            if (O._FST == FrameworkSourcedType.MAPPER && C.getName().equals("group") == true)
              {
                Out.println("      if (TextUtil.FindElement(" + Helper.getFullAppDataClassName(O) + "._" + C.getName() + "_Values, _" + C.getName() + ", 0, true, 0) == -1)");
                Out.println("       throw new Exception(\"Invalid value " + C.getName() + "='\"+_" + C.getName() + "+\"'. As per the model, valid values are: \"+TextUtil.Print(" + Helper.getFullAppDataClassName(O) + "._"
                + C.getName() + "_Values, 0)+\".\\n\"+toString());");
              }
          }
        Out.println();
        Out.print("      " + Helper.getFullAppDataClassName(O) + " Obj = " + Helper.getFullAppFactoryClassName(O) + ".Create(");
        boolean First = true;
        for (Column C : CreateColumns)
          if (C != null && (C._PrimaryKey == false || O._PrimaryKey._Autogen == false))
            {
              if (First == true)
                First = false;
              else
                Out.print(", ");
              Out.print("_" + C.getName());
            }
        Out.println(");");
        Out.println("      Update(Obj);");
        Out.println("      if (Obj.Write(C) == false)");
        Out.println("       {");
        List<Column> Cols = null;
        if (O._Indices != null)
          {
            Index FirstGoodIndex = null;
            for (Index I : O._Indices)
              if (I != null && I._Unique == true)
                {
                  // if (FirstGoodIndex == null)
                  // FirstGoodIndex = I;
                  boolean GoodIndex = true;
                  for (Column C : I._ColumnObjs)
                    {
                      // if (C != null && (C._ParentObject.isAutoGenPrimaryKey(C) == true || C._ParentObject.isAutoGenForeignKey(C.getName()) == true))
                      if (C != null && C._ParentObject.isAutoGenPrimaryKey(C) == true)
                      // if (C != null && C._ParentObject.isAutoGenForeignKey(C.getName()) == true)
                        {
                          GoodIndex = false;
                          break;
                        }
                    }
                  if (GoodIndex == true)
                    {
                      FirstGoodIndex = I;
                      break;
                    }
                }
            if (FirstGoodIndex != null)
              {
                Out.print("         Obj = " + Helper.getFullAppFactoryClassName(O) + ".LookupBy" + FirstGoodIndex._Name + "(");
                First = true;
                for (Column C : FirstGoodIndex._ColumnObjs)
                  if (C != null)
                    {
                      if (First == true)
                        First = false;
                      else
                        Out.print(", ");
                      Out.print("_" + C.getName());
                    }
                Out.println(");");
                Cols = FirstGoodIndex._ColumnObjs;
              }

          }
        if (Cols == null && O._PrimaryKey != null && O._PrimaryKey._Autogen == false)
          {
            Out.print("         Obj = " + Helper.getFullAppFactoryClassName(O) + ".LookupByPrimaryKey(");
            First = true;
            for (Column C : O._PrimaryKey._ColumnObjs)
              if (C != null)
                {
                  if (First == true)
                    First = false;
                  else
                    Out.print(", ");
                  Out.print("_" + C.getName());
                }
            Out.println(");");
            Cols = O._PrimaryKey._ColumnObjs;
          }
        if (Cols == null)
          {
            Out.println("         throw new Exception(\"Cannot create the " + O.getFullName() + " object.\\n\"+toString());");
          }
        else
          {
            Out.println("         if (Obj.Read(C) == false)");
            Out.println("          throw new Exception(\"Cannot create the " + O.getFullName() + " object.\\n\"+toString());");
            int count = 0;
            for (Column C : O._Columns)
              if (C != null && C.isJSONColumn() == true && Cols.contains(C) == false)
                {
                  if (C._Invariant == false)
                    {
                      String Pad = O._PadderColumnNames.getPad(C.getName());
                      Out.println(
                      "         if (_" + C.getName() + Pad + "!= null) Obj.set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "(_" + C.getName() + Pad + (C._Type == ColumnType.JSON ? ".toString()" : "") + ");");
                      ++count;
                    }
                  else if (C._PrimaryKey == false)
                    {
                      String Pad = O._PadderColumnNames.getPad(C.getName());
                      if (C.isCollection() == false && C._Type.isPrimitive() == true)
                        Out.println("         if (_" + C.getName() + Pad + "!= Obj.get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "())");
                      else
                        Out.println("         if (_" + C.getName() + Pad + ".equals(Obj.get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "()) == false)");
                      Out.println("          throw new Exception(\"Cannot update the invariant field '" + C.getFullName() + "': \"+Obj.toString());");
                    }
                }
            if (count != 0)
              {
                Out.println("         if (Obj.Write(C) == false)");
                Out.println("          throw new Exception(\"Cannot update the " + O.getFullName() + " object: \"+Obj.toString());");
              }
            else
              {
                Out.println("         LOG.debug(\"Nothing has changed in the object, so no update necessary.\");");
              }
            Out.println();

          }
        Out.println("       }");
        Out.println("      return Obj;");
        Out.println("   }");
        Out.println();
        Out.println("   public void Update(" + Helper.getFullAppDataClassName(O) + " Obj) throws Exception");
        Out.println("    {");
        for (Column C : O._Columns)
          if (C != null && C.isJSONColumn() == true)
            {
              String Pad = O._PadderColumnNames.getPad(C.getName());
              Out.println("      if (_" + C.getName() + Pad + "!= null) Obj.set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "(_" + C.getName() + Pad + (C._Type == ColumnType.JSON ? ".toString()" : "") + ");");
            }
        Out.println("    }");
      }


    @Override
    public void genMethodToJSON(PrintWriter Out, GeneratorSession G, JsonMapping J)
    throws Exception
      {
        Out.println("   public static void toJSON" + J._Name + "(Writer Out, List<" + Helper.getFullAppDataClassName(J._ParentObject) + "> L, String Lead, boolean FullList) throws IOException");
        Out.println("    {");
        Out.println("      if (L == null || L.size() == 0) return;");
        Out.println("      if (FullList == true)");
        Out.println("       Out.write(\"[\\n\");");
        Out.println("      boolean First = true;");
        Out.println("      for (" + Helper.getFullAppDataClassName(J._ParentObject) + " O : L)");
        Out.println("       if (O!=null)");
        Out.println("        {");
        Out.println("          Out.write(Lead);");
        Out.println("          if (First == false) Out.write(\",\"); else { Out.write(\" \"); First = false; }");
        Out.println("          toJSON" + J._Name + "(Out, O, true);");
        Out.println("          Out.write(\"\\n\");");
        Out.println("        }");
        Out.println("      if (FullList == true)");
        Out.println("       { ");
        Out.println("          Out.write(Lead);");
        Out.println("          Out.write(\"]\\n\");");
        Out.println("       } ");
        Out.println("    }");
        Out.println();
        Out.println("   public static void toJSON" + J._Name + "(Writer Out, " + Helper.getFullAppDataClassName(J._ParentObject) + " ObjApp, boolean FullObject) throws IOException");
        Out.println("    {");
        Out.println("      long T0 = System.nanoTime();");
        Out.println("      " + Helper.getFullBaseClassName(J._ParentObject) + " Obj = (" + Helper.getFullBaseClassName(J._ParentObject) + ") ObjApp;");
        Out.println("      if (FullObject == true)");
        Out.println("       Out.write(\"{\");");
        Out.println();
        boolean First = true;
        for (Column C : J._ColumnObjs)
          if (C != null)
            {
              First = Helper.JSONExport(Out, First, C);
              // if (C._Type == ColumnType.DATETIME && C.isOCCGenerated() == false)
              // First = JSONExport(Out, First, C._ParentObject.getColumn(C.getName()+"TZ"));
            }
        Out.println("      if (FullObject == true)");
        Out.println("       Out.write(\" }\\n\");");
        Out.println("      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);");
        Out.println("    }");

        if (J._ParentObject.isOCC() == true && J._Sync == true)
          {
            Out.println();
            Out.println("   public static boolean toJSON" + J._Name + "(Writer Out, " + Helper.getFullAppDataClassName(J._ParentObject) + " Data, String ElementName, String Lead, ZonedDateTime LastSync)");
            Out.println("   throws IOException");
            Out.println("    {");
            Out.println("      SyncStatus s = SyncStatus.get(LastSync, Data);");
            Out.println("      if (s == SyncStatus.OLD)");
            Out.println("       return false;");
            Out.println("      Out.write(Lead);");
            Out.println("      if (ElementName != null)");
            Out.println("       {");
            Out.println("         Out.write(\"\\\"\");");
            Out.println("         Out.write(ElementName);");
            Out.println("         Out.write(\"\\\": \");");
            Out.println("       }");
            Out.println("      Out.write(\" { \\\"__sync\\\": \\\"\");");
            Out.println("      Out.write(s._Status);");
            Out.println("      Out.write(\"\\\", \");");
            Out.println("      toJSON" + J._Name + "(Out, Data, false);");
            Out.println("      Out.write(\" }\\n\");");
            Out.println("      return true;");
            Out.println("    }");
            Out.println();
            Out.println("   public static void toJSON" + J._Name + "(Writer Out, List<" + Helper.getFullAppDataClassName(J._ParentObject) + "> L, String ElementName, String Lead, ZonedDateTime LastSync)");
            Out.println("   throws IOException");
            Out.println("    {");
            Out.println("      Out.write(Lead);");
            Out.println("      if (ElementName != null)");
            Out.println("       {");
            Out.println("         Out.write(\"\\\"\");");
            Out.println("         Out.write(ElementName);");
            Out.println("         Out.write(\"\\\": \");");
            Out.println("       }");
            Out.println("      Out.write(\" [\\n\");");
            Out.println("      boolean First = true;");
            Out.println("      Lead = PaddingUtil.getPad(Lead.length());");
            Out.println("      String LeadFirst = Lead+\"      \";");
            Out.println("      String LeadNext  = Lead+\"    , \";");
            Out.println("      for (" + Helper.getFullAppDataClassName(J._ParentObject) + " Data : L)");
            Out.println("       {");
            Out.println("         if (toJSON" + J._Name + "(Out, Data, null, First == true ? LeadFirst : LeadNext, LastSync) == false)");
            Out.println("          continue;");
            Out.println("         if (First == true)");
            Out.println("          First = false;");
            Out.println("       }");
            Out.println("      Out.write(Lead);");
            Out.println("      Out.write(\"  ]\\n\");");
            Out.println("    }");

          }
      }

    public void genMethodToString(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        Out.println("   public String toString()");
        Out.println("    {");
        Out.println("      return");
        boolean First = true;
        for (Column C : O._Columns)
          if (C != null && C.isJSONColumn() == true)
            {
              String Pad = O._PadderColumnNames.getPad(C.getName());
              Out.print((First == false ? "         + \"; " : "             \"") + C.getName());
              if (First == true)
                First = false;
              Out.print("\"" + Pad + "+ (_" + C.getName() + Pad + " == null ? \": NULL\" : \"");
              if (C._Type == ColumnType.DATETIME)
                {
                  Out.print(": \"+DateTimeUtil.printDateTimeForSQL(_" + C.getName() + ")");
                }
              else if (C._Type == ColumnType.STRING && C.isCollection() == false)
                {
                  if (C._Size != null && C._Size > 100) // test for NULL for CALCULATED fields
                    Out.print("(\" + (_" + C.getName() + Pad + " == null ? 0 : _" + C.getName() + Pad + ".length())+\"): \"+(_" + C.getName() + Pad + " == null || _" + C.getName() + Pad + ".length() < 100 ? _" + C.getName()
                    + Pad + " : _"
                    + C.getName() + Pad + ".substring(0, 100)+\"...\")");
                  else
                    Out.print("(\" + (_" + C.getName() + Pad + " == null ? 0 : _" + C.getName() + Pad + ".length())+\"): \"+_" + C.getName());
                }
              else
                {
                  Out.print(": \" + _" + C.getName() + Pad);
                }
              Out.println(")");
            }
        Out.println("         + \";\";");
        Out.println("    }");
      }

    @Override
    public void genClassEnd(PrintWriter Out, GeneratorSession G)
    throws Exception
      {
        Out.println(" }");
      }
  }
