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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.StringBuilderWriter;

import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.NVPSourceType;
import tilda.enums.ObjectLifecycle;
import tilda.enums.OutputFormatType;
import tilda.enums.TildaType;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenTildaFactory;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OutputMapping;
import tilda.parsing.parts.PrimaryKey;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.SubWhereClause;
import tilda.utils.SystemValues;
import tilda.utils.TextUtil;

public class TildaFactory implements CodeGenTildaFactory
  {
    protected static final Logger LOG = LogManager.getLogger(TildaFactory.class.getName());

    @Override
    public String getFileName(Base O)
      {
        return O._BaseClassName + "_Factory.java";
      }


    @Override
    public void genFileStart(PrintWriter Out, Object O)
    throws Exception
      {
        Out.println("package " + O._ParentSchema._Package + "." + Helper.TILDA_GEN_PACKAGE + ";");
        Out.println();
        Out.println("import java.math.*;");
        Out.println("import java.util.*;");
        Out.println("import java.time.*;");
        Out.println();
        Out.println("import org.apache.logging.log4j.*;");
        Out.println();
        Out.println("import com.google.gson.annotations.*;");
        Out.println();
        Out.println("import tilda.db.*;");
        Out.println("import tilda.enums.*;");
        Out.println("import tilda.performance.*;");
        Out.println("import tilda.types.*;");
        Out.println("import tilda.utils.*;");
        Out.println("import tilda.utils.json.*;");
        Out.println("import tilda.utils.pairs.*;");
        Out.println();
      }


    @Override
    public void genClassStart(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        Out.println("@SuppressWarnings({ \"unused\" })");
        Out.println("public class " + O._BaseClassName + "_Factory");
        Out.println(" {");
        Out.println("   protected static final Logger LOG = LogManager.getLogger(" + O._BaseClassName + "_Factory.class.getName());");
        Out.println();
        Out.println("   protected " + O._BaseClassName + "_Factory() { }");
        Out.println();
        Out.println("   public static final Class<" + O._BaseClassName + "> DATA_CLASS= " + O._BaseClassName + ".class;");
        Out.println("   public static final String SCHEMA_LABEL = TextUtil.print(" + TextUtil.escapeDoubleQuoteWithSlash(O._ParentSchema.getShortName()) + ", \"\");");
        Out.println("   public static final String TABLENAME_LABEL = TextUtil.print(" + TextUtil.escapeDoubleQuoteWithSlash(O.getBaseName()) + ", \"\");");
        Out.println("   public static final String SCHEMA_TABLENAME_LABEL = TextUtil.print(" + TextUtil.escapeDoubleQuoteWithSlash(O.getShortName()) + ", \"\");");
        Out.println("   public static void getFullTableNameVar(Connection C, StringBuilder S) { " + Helper.getFullTableVarAtRuntime(O) + "; }");
        Out.println();
        Out.println("   public static abstract class COLS {");
        int Counter = -1;
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String ColumnPad = O._PadderColumnNames.getPad(C.getName());
              String TypePad = C.getType().getPad();
              if (C._Nullable == false)
                TypePad += "    ";
              if (C.isCollection() == false)
                TypePad += " ";
              // String ColVarFull = TextUtil.escapeDoubleQuoteWithSlash(G.getSql().getFullColumnVar(C), "", false);
              // String ColVarShort = TextUtil.escapeDoubleQuoteWithSlash(G.getSql().getShortColumnVar(C), "", false);
              // String ColVarOthers = TextUtil.escapeDoubleQuoteWithSlash(G.getSql().getShortColumnVar(C), "", false);
              String ColumnTypeClassName = "Type_" + TextUtil.normalCapitalization(C.getType().name()) + (C.isCollection() ? "Collection" : "Primitive") + (C._Nullable == true ? "Null" : "");
              G.getGenDocs().docField(Out, G, C, "column definition");
              Out.print("     public static " + ColumnTypeClassName + TypePad + " " + C.getName().toUpperCase() + ColumnPad + "= new " + ColumnTypeClassName + TypePad + "(SCHEMA_LABEL, TABLENAME_LABEL, \"" + C.getName() + "\"" + ColumnPad + ", " + (++Counter) + "/*" + C.getSequenceOrder() + "*/, " + TextUtil.escapeDoubleQuoteWithSlash(C._Description));
              if (C.getType() == ColumnType.DATETIME && C.needsTZ() == true && O.getColumn(C.getName() + "TZ") != null)
                {
                  Out.print(", " + C.getName().toUpperCase() + "TZ");
                }
              Out.println(");");
            }
        Out.println(";");
        Out.println("   }");
        Out.println();
        Out.print("   public static final ColumnDefinition[] COLUMNS = { ");
        Counter = -1;
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              if (++Counter > 0)
                Out.print(",");
              Out.print("COLS." + C.getName().toUpperCase());
            }
        Out.println(" };");

        Out.println();
        String FirstIdentityColumns = null;
        Out.print("   public static final ColumnDefinition[] COLUMNS_PRIMARY = { ");
        Counter = -1;
        for (Column C : O._Columns)
          if (C != null && C.isPrimaryKey() == true)
            {
              if (++Counter > 0)
                Out.print(",");
              Out.print("COLS." + C.getName().toUpperCase());
            }
        Out.println(" };");
        Out.println();
        if (Counter > 0)
          FirstIdentityColumns = "COLUMNS_PRIMARY";

        Out.println("   public static final ColumnDefinition[][] COLUMNS_UNIQUE_INDICES = { ");
        Counter = -1;
        for (Index I : O._Indices)
          if (I != null && I._Unique == true)
            {
              Out.print("                   ");
              if (++Counter > 0)
                Out.print(",");
              Out.print("{");
              int counter2 = -1;
              for (Column C : I._ColumnObjs)
                if (C != null)
                  {
                    if (++counter2 > 0)
                      Out.print(",");
                    Out.print("COLS." + C.getName().toUpperCase());
                  }
              Out.println("}");
              if (FirstIdentityColumns == null)
                FirstIdentityColumns = "COLUMNS_UNIQUE_INDICES[0]";
            }
        Out.println("        };");
        Out.println();
        Out.println("   public static final ColumnDefinition[] COLUMNS_FIRST_IDENTITY = " + (FirstIdentityColumns == null ? "{}" : FirstIdentityColumns) + ";");
        Out.println();

        if (O._TenantInit == false)
          {
            Out.println("   private static Boolean  __INITIALIZED = false;");
            Out.println("   protected static void initObject(Connection C) throws Exception");
            Out.println("     {");
            Out.println("       if (__INITIALIZED == false)");
            Out.println("        synchronized(__INITIALIZED)");
            Out.println("         {");
            Out.println("           if (__INITIALIZED == false)");
            Out.println("            {");
            if (O._FST == FrameworkSourcedType.ENUMERATION || O._FST == FrameworkSourcedType.MAPPER)
              Out.println("              initMappings(C);");
            Out.println("              " + Helper.getFullAppFactoryClassName(O) + ".init(C);");
            Out.println("              __INITIALIZED = true;");
            Out.println("            }");
            Out.println("         }");
            Out.println("     }");
          }
        else
          {
            Out.println("   private static Set<String>  __INITIALIZED = new HashSet<String>();");
            Out.println("   protected static void initObject(Connection C) throws Exception");
            Out.println("     {");
            Out.println("       if (__INITIALIZED.contains(C.getURL()) == false)");
            Out.println("        synchronized(__INITIALIZED)");
            Out.println("         {");
            Out.println("           if (__INITIALIZED.contains(C.getURL()) == false)");
            Out.println("            {");
            Out.println("              __INITIALIZED.add(C.getURL());");
            if (O._FST == FrameworkSourcedType.ENUMERATION || O._FST == FrameworkSourcedType.MAPPER)
              Out.println("              initMappings(C);");
            Out.println("              " + Helper.getFullAppFactoryClassName(O) + ".init(C);");
            Out.println("            }");
            Out.println("         }");
            Out.println("     }");
          }
        Out.println("   private static class RecordProcessorInternal implements tilda.db.processors.RecordProcessor");
        Out.println("     {");
        Out.println("       public RecordProcessorInternal(Connection C, int start)");
        Out.println("         {");
        Out.println("           _C = C;");
        Out.println("           _L = new ArrayListResults<" + Helper.getFullAppDataClassName(O) + ">(start);");
        Out.println("         }");
        Out.println("       public RecordProcessorInternal(Connection C, tilda.db.processors.ObjectProcessor<" + Helper.getFullAppDataClassName(O) + "> OP)");
        Out.println("         {");
        Out.println("           _C = C;");
        Out.println("           _OP = OP;");
        Out.println("         }");
        Out.println("       protected Connection _C = null;");
        Out.println("       protected tilda.db.processors.ObjectProcessor<" + Helper.getFullAppDataClassName(O) + "> _OP;");
        Out.println("       protected ArrayListResults<" + Helper.getFullAppDataClassName(O) + "> _L = null;");
        Out.println("       public void    start  () { if (_OP != null) _OP.start(); }");
        Out.println("       public void    end    (boolean hasMore, int maxCount) { if (_OP == null) _L.wrapup(hasMore, maxCount); else _OP.end(hasMore, maxCount); }");
        Out.println("       public boolean process(int count, java.sql.ResultSet RS) throws Exception");
        Out.println("        {");
        Out.println("          " + Helper.getFullAppDataClassName(O) + " Obj = new " + Helper.getFullAppDataClassName(O) + "();");
        Out.println("          boolean OK = ((" + Helper.getFullBaseClassName(O) + ")Obj).init(_C, RS);");
        Out.println("          if (OK == true)");
        Out.println("           {");
        Out.println("             if (_OP == null)");
        Out.println("              _L.add(Obj);");
        Out.println("             else");
        Out.println("              _OP.process(count, Obj);");
        Out.println("           }");
        Out.println("          return OK;");
        Out.println("        }");
        Out.println("     }");
        Out.println();
        Out.println("   protected static final void processMany(Connection C, String fullSelectQuery, int start, int size, tilda.db.processors.RecordProcessor RP) throws Exception");
        Out.println("     {");
        Out.println("       readMany(C, -77, RP, null, fullSelectQuery, start, size);");
        Out.println("     }");

        Out.println("   protected static final ListResults<" + Helper.getFullAppDataClassName(O) + "> readMany(Connection C, String fullSelectQuery, int start, int size) throws Exception");
        Out.println("     {");
        Out.println("       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);");
        Out.println("       readMany(C, -77, RPI, null, fullSelectQuery, start, size);");
        Out.println("       return RPI._L;");
        Out.println("     }");
        Out.println();
        Out.println("   private static final void readMany(Connection C, int LookupId, tilda.db.processors.RecordProcessor RP, "
        + Helper.getFullBaseClassName(O) + " Obj, Object ExtraParams, int start, int size) throws Exception");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        Out.println("       StringBuilder S = new StringBuilder(1024);");
        Out.println("       if (LookupId == -77)");
        Out.println("        {");
        Out.println("          S.append((String)ExtraParams);");
        Out.println("        }");
        Out.println("       else");
        Out.println("        {");
        Helper.SelectFrom(Out, O);
        Helper.SwitchLookupIdWhereClauses(Out, G, O, "          ", false);
        Out.println("        }");
        Out.println();
        if (G.getSql().supportsSelectLimit() == true || G.getSql().supportsSelectOffset() == true)
          Out.println("       String Q = S.toString() + C.getSelectLimitClause(start, size+1);");
        else
          Out.println("       String Q = S.toString();");
        Out.println("       S.setLength(0);");
        Out.println("       S = null;");
        Out.println("       QueryDetails.setLastQuery(SCHEMA_TABLENAME_LABEL, Q);");
        Out.println("       QueryDetails.logQuery(\"" + O.getShortName() + "\", Q, null);");
        Out.println("       java.sql.PreparedStatement PS=null;");
        // Out.println(" java.sql.ResultSet RS=null;");
        for (Column C : O._Columns)
          if (C != null && C.isCollection() == true)
            {
              Out.println("       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();");
              break;
            }
        Out.println("       int count = 0;");
        Out.println("       try");
        Out.println("        {");
        Out.println("          PS = C.prepareStatement(Q);");
        StringBuilderWriter SBW = new StringBuilderWriter();
        Helper.SwitchLookupIdPreparedStatement(new PrintWriter(SBW), G, O, "          ", false, true);
        if (SBW.getBuilder().indexOf("++i") != -1)
          Out.println("          int i = 0;");
        Out.println(SBW.getBuilder().toString());
        Out.println();
        Out.println("          count = JDBCHelper.process(PS.executeQuery(), RP, start, " + G.getSql().supportsSelectOffset() + ", size, " + G.getSql().supportsSelectOffset() + ");");
        Out.println("        }");
        Helper.CatchFinallyBlock(Out, O, "selected", "StatementType.SELECT", false, true);
        Out.println();
        Out.println("    }");
      }

    @Override
    public void genMethodCreate(PrintWriter Out, GeneratorSession G, Object O, List<Column> CreateColumns, List<Column> DefaultColumns)
    throws Exception
      {
        Out.print("   static public " + Helper.getFullAppDataClassName(O) + " create(");
        boolean First = true;
        for (Column C : CreateColumns)
          if (C != null && (C._PrimaryKey == false || O._PrimaryKey._Autogen == false))
            {
              if (First == true)
                First = false;
              else
                Out.print(", ");
              Out.print(JavaJDBCType.getFieldType(C) + " " + C.getName());
            }
        Out.println(") throws Exception");
        Out.println("     {");
        Out.println("       " + Helper.getFullBaseClassName(O) + " Obj = new " + Helper.getFullAppDataClassName(O) + "();");
        Out.println("       Obj.initForCreate();");
        Out.println();
        if (O._PrimaryKey != null && O._PrimaryKey._Autogen == true)
          {
            Out.println();
            Out.println("       // Auto PK");
            Column PK = O._PrimaryKey._ColumnObjs.get(0);
            Out.println("       Obj.set" + TextUtil.capitalizeFirstCharacter(PK.getName()) + "(tilda.db.KeysManager.getKey(" + TextUtil.escapeDoubleQuoteWithSlash(O.getShortName().toUpperCase()) + "));");
          }
        if (CreateColumns != null && CreateColumns.isEmpty() == false)
          {
            Out.println();
            Out.println("       // Explicit setters");
            for (Column C : CreateColumns)
              {
                String Pad = O._PadderColumnNames.getPad(C.getName());
                Out.println("       Obj.set" + TextUtil.capitalizeFirstCharacter(C.getName()) + Pad + "(" + C.getName() + Pad + ");");
              }
          }

        if (DefaultColumns != null && DefaultColumns.isEmpty() == false)
          {
            Out.println();
            Out.println("       // Default Create-time setters");
            Helper.SetDefaultValues(Out, DefaultColumns, "       Obj.");
          }

        Out.println();
        Out.println("       return (" + Helper.getFullAppDataClassName(O) + ") Obj;");
        Out.println("     }");
        Out.println();


        Out.println("   static public " + Helper.getFullAppDataClassName(O) + " create(Map<String, String> Values, List<StringStringPair> Errors)");
        Out.println("   throws Exception");
        Out.println("     {");
        Out.println("       int IncomingErrors = Errors.size();");
        Out.println();
        for (Column C : O._Columns)
          if (C != null)
            {
              if (C.getType() == ColumnType.BINARY)
                {
                  Out.println("       if (Values.get(" + TextUtil.escapeDoubleQuoteWithSlash(C.getName()) + ") != null)");
                  Out.println("        Errors.add(new StringStringPair(" + TextUtil.escapeDoubleQuoteWithSlash(C.getName()) + ", \"Parameter is of a binary type and cannot be passed as a string value.\"));");
                  continue;
                }
              if (C._FCT.isManaged() == true || C._Mode != ColumnMode.NORMAL)
                continue;
              String Pad = C._ParentObject.getColumnPad(C.getName());
              Out.print("       " + (C.isCollection() == true && C._JsonSchema == null ? JavaJDBCType.getFieldType(C) : JavaJDBCType.getFieldTypeBaseClass(C) + "      ")
              + "  _" + C.getName() + Pad
              + " = " + (C.isList() == true && C._JsonSchema == null ? "CollectionUtil.toList("
              : C.isSet() == true && C._JsonSchema == null ? "CollectionUtil.toSet ("
              : "                      ")
              + "ParseUtil.parse" + JavaJDBCType.getFieldTypeBaseClass(C)
              + "(" + TextUtil.escapeDoubleQuoteWithSlash(C.getName()) + Pad
              + ", " + (C._Nullable == true ? "false" : "true ")
              + ", Values.get(" + TextUtil.escapeDoubleQuoteWithSlash(C.getName()) + Pad + ")");
              if (C.isCollection() == true && C._JsonSchema == null)
                Out.print(", " + TextUtil.escapeDoubleQuoteWithSlash(SystemValues.DEFAULT_SEPARATOR1_BACKQUOTES));
              Out.println(", Errors"
              + (C.isCollection() == true && C._JsonSchema == null ? ")" : " ")
              + ");");
            }
        Out.println();
        Out.println("       if (IncomingErrors != Errors.size())");
        Out.println("        return null;");
        Out.println();
        Out.print("      " + Helper.getFullAppDataClassName(O) + " Obj = " + Helper.getFullAppFactoryClassName(O) + ".create(");
        First = true;
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
        Out.println();
        for (Column C : O._Columns)
          if (C != null && C.getType() != ColumnType.BINARY && C._FCT.isManaged() == false && C._Mode == ColumnMode.NORMAL && CreateColumns.contains(C) == false)
            {
              String Pad = O._PadderColumnNames.getPad(C.getName());
              Out.println("      if (_" + C.getName() + Pad + "!= null) Obj.set" + TextUtil.capitalizeFirstCharacter(C.getName()) + Pad + "(_" + C.getName() + Pad + ");");
            }
        Out.println();
        Out.println("      return Obj;");
        Out.println("     }");

      }



    @Override
    public void genMethodLookupByPrimaryKey(PrintWriter Out, GeneratorSession G, PrimaryKey PK, long LookupId)
      {
        Out.print("   static public " + Helper.getFullAppDataClassName(PK._ParentObject) + " lookupByPrimaryKey(");
        boolean First = true;
        for (Column C : PK._ColumnObjs)
          if (C != null)
            {
              if (First == true)
                First = false;
              else
                Out.print(", ");
              Out.print(JavaJDBCType.getFieldType(C) + " " + C.getName());
            }
        Out.println(") throws Exception");
        Out.println("     {");
        Out.println("       " + Helper.getFullBaseClassName(PK._ParentObject) + " Obj = new " + Helper.getFullAppDataClassName(PK._ParentObject) + "();");
        Out.println("       Obj.initForLookup(" + LookupId + ");");
        Out.println();
        for (Column C : PK._ColumnObjs)
          if (C != null)
            {
              String Pad = C._ParentObject.getColumnPad(C.getName());
              Out.print("       Obj.set" + TextUtil.capitalizeFirstCharacter(C.getName()) + Pad + "(" + C.getName() + Pad + "); ");
              if (PK._ParentObject.getLifecycle() != ObjectLifecycle.READONLY)
                Out.print("Obj.__Saved_" + C.getName() + Pad + " = Obj._" + C.getName() + Pad + ";");
              Out.println();
            }
        Out.println();
        Out.println("       return (" + Helper.getFullAppDataClassName(PK._ParentObject) + ") Obj;");
        Out.println("     }");
      }

    @Override
    public void genMethodLookupByUniqueIndex(PrintWriter Out, GeneratorSession G, Index I, long LookupId)
      {
        if (I._Unique == false)
          throw new Error("ERROR: called genMethodLookupByUniqueIndex with a non-Unique Index");

        Out.print("   static public " + Helper.getFullAppDataClassName(I._Parent) + " lookupBy" + I._Name + "(");
        boolean First = true;
        for (Column C : I._ColumnObjs)
          if (C != null)
            {
              if (First == true)
                First = false;
              else
                Out.print(", ");
              Out.print(JavaJDBCType.getFieldType(C) + " " + C.getName());
            }
        Out.println(") throws Exception");
        Out.println("     {");
        Out.println("       " + Helper.getFullBaseClassName(I._Parent) + " Obj = new " + Helper.getFullAppDataClassName(I._Parent) + "();");
        Out.println("       Obj.initForLookup(" + LookupId + ");");
        Out.println();
        for (Column C : I._ColumnObjs)
          if (C != null)
            {
              String Pad = C._ParentObject.getColumnPad(C.getName());
              Out.print("       Obj.set" + TextUtil.capitalizeFirstCharacter(C.getName()) + Pad + "(" + C.getName() + Pad + "); ");
              if (C._PrimaryKey == true && I._Parent.getLifecycle() != ObjectLifecycle.READONLY)
                Out.print("Obj.__Saved_" + C.getName() + Pad + " = Obj._" + C.getName() + Pad + ";");
              Out.println();
            }
        Out.println();
        Out.println("       return (" + Helper.getFullAppDataClassName(I._Parent) + ") Obj;");
        Out.println("     }");
      }


    private static void genMethodLookupWhereIndexSignature(PrintWriter Out, GeneratorSession G, Index I, Query q)
      {
        for (Column C : I._ColumnObjs)
          if (C != null)
            Out.print(", " + JavaJDBCType.getFieldType(C) + " " + C.getName());
        if (q != null)
          {
            Set<String> VarNameSet = new HashSet<String>();
            for (Query.Attribute A : q._Attributes)
              {
                if (VarNameSet.add(A._VarName) == false)
                  continue;
                Out.print(", " + JavaJDBCType.getFieldTypeParam(A._Col, A._Multi) + " " + A._VarName);
              }
          }
        Out.println(", int start, int size) throws Exception");

      }

    private static void genMethodLookupWhereIndexPreamble(PrintWriter Out, Index I, Query q, String MethodName)
      {
        Out.println("       " + Helper.getFullBaseClassName(I._Parent) + " Obj = new " + Helper.getFullAppDataClassName(I._Parent) + "();");
        Out.println("       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);");
        Out.println();
        for (Column C : I._ColumnObjs)
          if (C != null)
            {
              String Pad = C._ParentObject.getColumnPad(C.getName());
              Out.println("       Obj.set" + TextUtil.capitalizeFirstCharacter(C.getName()) + Pad + "(" + C.getName() + Pad + ");");
            }
        Out.println();
        if (q != null && q._Attributes.isEmpty() == false)
          {
            Out.print("       " + MethodName + "Params P = new " + MethodName + "Params(");
            boolean First = true;
            Set<String> VarNameSet = new HashSet<String>();
            for (Query.Attribute A : q._Attributes)
              {
                String v = A._VarName.replace('.', '_');
                if (VarNameSet.add(v) == false)
                  continue;
                if (First == true)
                  First = false;
                else
                  Out.print(", ");
                Out.print(v);
              }
            Out.println(");");
          }
      }

    @Override
    public void genMethodLookupWhereIndex(PrintWriter Out, GeneratorSession G, Index I, int LookupId)
      {
        if (I._Unique == true)
          throw new Error("ERROR: called genMethodLookupWhereIndex with a Unique Index");

        Query q = I._SubQuery == null ? null : I._SubQuery.getQuery(G.getSql());

        String MethodName = "lookupWhere" + I._Name;

        if (q != null && q._Attributes.isEmpty() == false)
          Helper.MakeParamStaticClass(Out, q._Attributes, MethodName);
        Out.println();
        
        Out.print("   static public ListResults<" + Helper.getFullAppDataClassName(I._Parent) + "> " + MethodName + "(Connection C");
        genMethodLookupWhereIndexSignature(Out, G, I, q);
        Out.println("     {");
        genMethodLookupWhereIndexPreamble(Out, I, q, MethodName);
        Out.println();
        Out.println("       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);");
        Out.println("       readMany(C, " + LookupId + ", RPI, Obj, " + (q != null && q._Attributes.isEmpty() == false ? "P" : "null") + ", start, size);");
        Out.println("       return RPI._L;");
        Out.println("     }");
        Out.println();
        Out.print("   static public void " + MethodName + "(Connection C, tilda.db.processors.ObjectProcessor<" + Helper.getFullAppDataClassName(I._Parent) + "> OP");
        genMethodLookupWhereIndexSignature(Out, G, I, q);
        Out.println("     {");
        genMethodLookupWhereIndexPreamble(Out, I, q, MethodName);
        Out.println();
        Out.println("       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);");
        Out.println("       readMany(C, " + LookupId + ", RPI, Obj, " + (q != null && q._Attributes.isEmpty() == false ? "P" : "null") + ", start, size);");
        Out.println("     }");
        Out.println();
      }



    private static void genMethodLookupWhereQuerySignature(PrintWriter Out, GeneratorSession G, SubWhereClause Q)
      {
        Set<String> VarNameSet = new HashSet<String>();
        for (Query.Attribute A : Q._Attributes)
          {
            if (VarNameSet.add(A._VarName) == false)
              continue;
            Out.print(", " + JavaJDBCType.getFieldTypeParam(A._Col, A._Multi) + " " + A._VarName);
          }
        Out.println(", int start, int size) throws Exception");
      }

    private static void genMethodLookupWhereQueryPreamble(PrintWriter Out, SubWhereClause Q, String MethodName)
      {
        Out.println("       " + Helper.getFullBaseClassName(Q._ParentObject) + " Obj = new " + Helper.getFullAppDataClassName(Q._ParentObject) + "();");
        Out.println("       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);");
        Out.println();
        if (Q._Attributes.isEmpty() == false)
          {
            Out.print("       " + MethodName + "Params P = new " + MethodName + "Params(");
            boolean First = true;
            Set<String> VarNameSet = new HashSet<String>();
            for (Query.Attribute A : Q._Attributes)
              {
                String v = A._VarName.replace('.', '_');
                if (VarNameSet.add(v) == false)
                  continue;
                if (First == true)
                  First = false;
                else
                  Out.print(", ");
                Out.print(v);
              }
            Out.println(");");
          }
      }


    @Override
    public void genMethodLookupWhereQuery(PrintWriter Out, GeneratorSession G, SubWhereClause SWC, int LookupId)
      {
        if (SWC._Unique == true)
          throw new Error("ERROR: called genMethodLookupWhereQuery with a Unique SubWhereclause");

        String MethodName = "lookupWhere" + SWC._Name;
        
        if (SWC._Attributes.isEmpty() == false)
          Helper.MakeParamStaticClass(Out, SWC._Attributes, MethodName);
        Out.println();
        Out.print("   static public ListResults<" + Helper.getFullAppDataClassName(SWC._ParentObject) + "> " + MethodName + "(Connection C");
        genMethodLookupWhereQuerySignature(Out, G, SWC);
/*
        Set<String> VarNameSet = new HashSet<String>();
        for (Query.Attribute A : SWC._Attributes)
          {
            String v = A._VarName.replace('.', '_');
            if (VarNameSet.add(v) == false)
              continue;
            Out.print(", " + JavaJDBCType.getFieldTypeParam(A._Col, A._Multi) + " " + v);
          }
        Out.println(", int start, int size) throws Exception");
*/
        Out.println("     {");
        genMethodLookupWhereQueryPreamble(Out, SWC, MethodName);
/*        
        Out.println("       " + Helper.getFullBaseClassName(SWC._ParentObject) + " Obj = new " + Helper.getFullAppDataClassName(SWC._ParentObject) + "();");
        Out.println("       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);");
        Out.println();
        if (SWC._Attributes.isEmpty() == false)
          {
            Out.print("       " + MethodName + "Params P = new " + MethodName + "Params(");
            boolean First = true;
            VarNameSet.clear();
            for (Query.Attribute A : SWC._Attributes)
              {
                String v = A._VarName.replace('.', '_');
                if (VarNameSet.add(v) == false)
                  continue;
                if (First == true)
                  First = false;
                else
                  Out.print(", ");
                Out.print(v);
              }
            Out.println(");");
          }
*/
        Out.println();
        Out.println("       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);");
        Out.println("       readMany(C, " + LookupId + ", RPI, Obj, " + (SWC._Attributes.isEmpty() == false ? "P" : "null") + ", start, size);");
        Out.println("       return RPI._L;");
        Out.println("     }");
        Out.println();
        Out.println();
        Out.print("   static public void " + MethodName + "(Connection C, tilda.db.processors.ObjectProcessor<" + Helper.getFullAppDataClassName(SWC._ParentObject) + "> OP");
        genMethodLookupWhereQuerySignature(Out, G, SWC);
        Out.println("     {");
        genMethodLookupWhereQueryPreamble(Out, SWC, MethodName);
        Out.println();
        Out.println("       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);");
        Out.println("       readMany(C, " + LookupId + ", RPI, Obj, " + (SWC != null && SWC._Attributes.isEmpty() == false ? "P" : "null") + ", start, size);");
        Out.println("     }");
        Out.println();
      }


    @Override
    public void genMethodLookupByUniqueQuery(PrintWriter Out, GeneratorSession G, SubWhereClause SWC, int LookupId)
      {
        if (SWC._Unique == false)
          throw new Error("ERROR: called genMethodLookupByUniqueQuery with a non-Unique SubWhereclause");

        String MethodName = "lookupBy" + SWC._Name;
        Out.print("   static public " + Helper.getFullAppDataClassName(SWC._ParentObject) + " " + MethodName + "(");
        boolean First = true;
        for (Query.Attribute A : SWC._Attributes)
          if (A != null && A._Col != null)
            {
              if (First == true)
                First = false;
              else
                Out.print(", ");
              Out.print(JavaJDBCType.getFieldTypeParam(A._Col, A._Multi) + " " + A._Col.getName());
            }
        Out.println(") throws Exception");
        Out.println("     {");
        Out.println("       " + Helper.getFullBaseClassName(SWC._ParentObject) + " Obj = new " + Helper.getFullAppDataClassName(SWC._ParentObject) + "();");
        Out.println("       Obj.initForLookup(" + LookupId + ");");
        Out.println();
        for (Query.Attribute A : SWC._Attributes)
          if (A != null && A._Col != null)
            {
              String Pad = A._Col._ParentObject.getColumnPad(A._Col.getName());
              Out.print("       Obj.set" + TextUtil.capitalizeFirstCharacter(A._Col.getName()) + Pad + "(" + A._Col.getName() + Pad + "); ");
              if (A._Col._PrimaryKey == true && SWC._ParentObject.getLifecycle() != ObjectLifecycle.READONLY)
                Out.print("Obj.__Saved_" + A._Col.getName() + Pad + " = Obj._" + A._Col.getName() + Pad + ";");
              Out.println();
            }
        Out.println();
        Out.println("       return (" + Helper.getFullAppDataClassName(SWC._ParentObject) + ") Obj;");
        Out.println("     }");
        Out.println();
      }

    @Override
    public void genMethodLookupParent(PrintWriter Out, GeneratorSession G, ForeignKey FK)
      {
        // TODO Auto-generated method stub
      }

    @Override
    public void genQueryHelper(PrintWriter Out, GeneratorSession G, Object O)
      {
        Out.println("   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, true); }");
        Out.println("   public static SelectQuery newWhereQuery (Connection C) throws Exception { return new SelectQuery(C, SCHEMA_LABEL, TABLENAME_LABEL, false); }");
        Out.println("   public static ListResults<" + Helper.getFullAppDataClassName(O) + "> runSelect(Connection C, SelectQuery Q, int start, int size) throws Exception");
        Out.println("     {");
        Out.println("       RecordProcessorInternal RPI = new RecordProcessorInternal(C, start);");
        Out.println("       readMany(C, -7, RPI, null, Q, start, size);");
        Out.println("       return RPI._L;");
        Out.println("     }");
        Out.println("   public static void runSelect(Connection C, SelectQuery Q, tilda.db.processors.ObjectProcessor<" + Helper.getFullAppDataClassName(O) + "> OP, int start, int size) throws Exception");
        Out.println("     {");
        Out.println("       RecordProcessorInternal RPI = new RecordProcessorInternal(C, OP);");
        Out.println("       readMany(C, -7, RPI, null, Q, start, size);");
        Out.println("     }");
        if (O._LC == ObjectLifecycle.NORMAL)
          {
            Out.println("   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }");
            Out.println("   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, SCHEMA_LABEL, TABLENAME_LABEL); }");
          }
        Out.println();
      }


    @Override
    public void genMappingSupport(PrintWriter Out, GeneratorSession G, Object O)
      {
        StringBuilder FuncParams = new StringBuilder();
        boolean First = true;
        for (Column C : O._PrimaryKey._ColumnObjs)
          if (C != null)
            {
              if (First == true)
                First = false;
              else
                FuncParams.append(", ");
              FuncParams.append(JavaJDBCType.getFieldType(C)).append(" ").append(C.getName());
            }

        StringBuilder CallParams = new StringBuilder();
        First = true;
        for (Column C : O._PrimaryKey._ColumnObjs)
          if (C != null)
            {
              if (First == true)
                First = false;
              else
                CallParams.append(", ");
              CallParams.append(C.getName());
            }


        Out.println("   protected static Map<String, " + Helper.getFullAppDataClassName(O) + "> __MAPPINGS = new HashMap<String, " + Helper.getFullAppDataClassName(O) + ">();");
        Out.println("   public static void initMappings(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       __MAPPINGS.clear();");
        Out.println("       ListResults<" + Helper.getFullAppDataClassName(O) + "> L = lookupWhereAll(C, 0, -1);");
        Out.println("       StringBuilder Str = new StringBuilder();");
        Out.println("       for (" + Helper.getFullAppDataClassName(O) + " obj : L)");
        Out.println("        {");
        if (O.getColumn("group") != null)
          {
            Out.println("          if (TextUtil.findElement(" + Helper.getFullAppDataClassName(O) + "._group_Values, obj.getGroup(), 0, true, 0) == -1)");
            Out.println("           {");
            Out.println("             if (Str.length() != 0)");
            Out.println("              Str.append(\", \");");
            Out.println("             Str.append(obj.getGroup());");
            Out.println("           }");
          }
        Out.print("          __MAPPINGS.put(");
        First = true;
        for (Column C : O._PrimaryKey._ColumnObjs)
          if (C != null)
            {
              if (First == true)
                First = false;
              else
                Out.print(" + \"``\" + ");
              Out.print("obj.get" + TextUtil.capitalizeFirstCharacter(C.getName()) + "()");
            }
        Out.println(", obj);");
        Out.println("        }");
        Out.println("       if (Str.length() == 0)");
        Out.println("        LOG.warn(\"Could not validate some mapping group values for " + O.getFullName() + " against the model.\\nInvalid group value(s): \"+Str.toString()+\"\\nCurrently modeled values are: \"+TextUtil.print(" + Helper.getFullAppDataClassName(O) + "._group_Values, 0)+\".\");");
        Out.println("     }");

        Out.println("   private static " + Helper.getFullAppDataClassName(O) + " getMapping(" + FuncParams + ")");
        Out.println("     {");
        Out.print("       " + Helper.getFullAppDataClassName(O) + " Obj = __MAPPINGS.get(");
        First = true;
        for (Column C : O._PrimaryKey._ColumnObjs)
          if (C != null)
            {
              if (First == true)
                First = false;
              else
                Out.print(" + \"``\" + ");
              Out.print(C.getName());
            }
        Out.println(");");

        for (int i = O._PrimaryKey._ColumnObjs.size() - 2; i >= 0; --i)
          {
            Out.println("       if (Obj == null)");
            Out.print("        Obj = __MAPPINGS.get(");
            First = true;
            int count = 0;
            for (Column C : O._PrimaryKey._ColumnObjs)
              if (C != null)
                {
                  if (First == true)
                    First = false;
                  else
                    Out.print(" + \"``\" + ");
                  Out.print(count >= i && count != O._PrimaryKey._ColumnObjs.size() - 1 ? "\"*\"" : C.getName());
                  ++count;
                }
            Out.println(");");
          }
        Out.println("       return Obj;");
        Out.println("     }");

        if (O.getColumn("name") != null)
          {
            Out.println("   public static String getMappedName(" + FuncParams + ")");
            Out.println("     {");
            Out.println("       " + Helper.getFullAppDataClassName(O) + " Obj = getMapping(" + CallParams + ");");
            Out.println("       return Obj == null ? " + O._PrimaryKey._ColumnObjs.get(O._PrimaryKey._ColumnObjs.size() - 1).getName() + " : Obj.getName();");
            Out.println("     }");
          }
        if (O.getColumn("group") != null)
          {
            Out.println("   public static String getMappedGroup(" + FuncParams + ")");
            Out.println("     {");
            Out.println("       " + Helper.getFullAppDataClassName(O) + " Obj = getMapping(" + CallParams + ");");
            Out.println("       return Obj == null ? " + O._PrimaryKey._ColumnObjs.get(O._PrimaryKey._ColumnObjs.size() - 1).getName() + " : Obj.getGroup();");
            Out.println("     }");
          }
      }

    @Override
    public void genEnumerationSupport(PrintWriter Out, GeneratorSession G, Object O)
      {
        StringBuilder FuncParams = new StringBuilder();
        boolean First = true;
        for (Column C : O._PrimaryKey._ColumnObjs)
          if (C != null)
            {
              if (First == true)
                First = false;
              else
                FuncParams.append(", ");
              FuncParams.append(JavaJDBCType.getFieldType(C)).append(" ").append(C.getName());
            }

        StringBuilder CallParams = new StringBuilder();
        First = true;
        for (Column C : O._PrimaryKey._ColumnObjs)
          if (C != null)
            {
              if (First == true)
                First = false;
              else
                CallParams.append(", ");
              CallParams.append(C.getName());
            }


        Out.println("   protected static Map<String, " + Helper.getFullAppDataClassName(O) + "> __ENUMERATIONS_BY_ID    = new HashMap<String, " + Helper.getFullAppDataClassName(O) + ">();");
        Out.println("   protected static Map<String, " + Helper.getFullAppDataClassName(O) + "> __ENUMERATIONS_BY_VALUE = new HashMap<String, " + Helper.getFullAppDataClassName(O) + ">();");
        Out.println("   public static void initMappings(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       __ENUMERATIONS_BY_ID   .clear();");
        Out.println("       __ENUMERATIONS_BY_VALUE.clear();");
        Out.println("       ListResults<" + Helper.getFullAppDataClassName(O) + "> L = lookupWhereAll(C, 0, -1);");
        Out.println("       for (" + Helper.getFullAppDataClassName(O) + " obj : L)");
        Out.println("        {");
        Out.println("          __ENUMERATIONS_BY_ID   .put(obj.getId   (), obj);");
        Out.println("          __ENUMERATIONS_BY_VALUE.put(obj.getValue(), obj);");
        Out.println("        }");
        Out.println("     }");
        Out.println();
        Out.println("   public static " + Helper.getFullAppDataClassName(O) + " getEnumerationById(String Id)");
        Out.println("     {");
        Out.println("       return Id == null ? null : __ENUMERATIONS_BY_ID.get(Id);");
        Out.println("     }");
        Out.println();
        Out.println("   public static " + Helper.getFullAppDataClassName(O) + " getEnumerationByValue(String Value)");
        Out.println("     {");
        Out.println("       return Value == null ? null : __ENUMERATIONS_BY_VALUE.get(Value);");
        Out.println("     }");
      }

    @Override
    public void genClassEnd(PrintWriter Out, GeneratorSession G)
    throws Exception
      {
        Out.println(" }");
      }


    @Override
    public void genBatchWrite(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        Out.println("   public static int writeBatch(Connection C, List<" + Helper.getFullAppDataClassName(O) + "> L, int batchSize, int commitSize) throws Exception");
        Out.println("     {");
        Out.println("       long T0 = System.nanoTime();");
        Out.println();
        Out.println("       if (L == null || L.isEmpty() == true)");
        Out.println("         return -1;");
        Out.println();
        Out.println("       java.sql.PreparedStatement PS = null;");
        Out.println("       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();");
        Out.println("       int count = 0;");
        Out.println("       int batchStart = 0;");
        Out.println("       " + O._BaseClassName + " lastObj = null;");
        Out.println("       BitSet firstChangeList = (BitSet) ((" + O._BaseClassName + ") L.get(0)).__Changes.clone();");
        Out.println("       String firstTimeStampSignature = ((" + O._BaseClassName + ") L.get(0)).getTimeStampSignature();");
        Out.println();
        Out.println("       try");
        Out.println("         {");
        if (G.getSql().needsSavepoint() == true)
          Out.println("           C.setSavepoint();");
        Out.println("           String Q = L.get(0).getWriteQuery(C);");
        Out.println("           PS = C.prepareStatement(Q);");
        Out.println("           int insertCount = 0;");
        Out.println();
        Out.println("           int index = -1;");
        Out.println("           for (" + Helper.getFullAppDataClassName(O) + " d : L)");
        Out.println("             {");
        Out.println("               ++index;");
        Out.println("               if (d == null || d.hasChanged() == false)");
        Out.println("                 continue;");
        Out.println();
        Out.println("               lastObj = ((" + O._BaseClassName + ") d);");
        Out.println();
        Out.println("               if (((" + O._BaseClassName + ") d).__Init != InitMode.CREATE)");
        Out.println("                 {");
        Out.println("                   LOG.debug(QueryDetails._LOGGING_HEADER + \"The '" + Helper.getFullAppDataClassName(O) + "' object at positon #\" + index + \" was not in an insertable state. Only inserts are allowed in batch writes (i.e., no updates).\");");
        Out.println("                   QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("                   return index;");
        Out.println("                 }");
        Out.println();
        Out.println("               if (((" + O._BaseClassName + ") d).beforeWrite(C) == false)");
        Out.println("                 {");
        Out.println("                   LOG.debug(QueryDetails._LOGGING_HEADER + \"The '" + Helper.getFullAppDataClassName(O) + "' object at positon #\" + index + \" failed in its beforeWrite() method.\");");
        Out.println("                   QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("                   return index;");
        Out.println("                 }");
        Out.println();
        Out.println("               if (firstChangeList.equals(((" + O._BaseClassName + ") d).__Changes) == false)");
        Out.println("                 {");
        Out.println("                   LOG.debug(QueryDetails._LOGGING_HEADER + \"The '" + Helper.getFullAppDataClassName(O) + "' object at positon #\" + index + \" failed matching the list of columns being changed compared to the first object passed.\");");
        Out.println("                   QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("                   return index;");
        Out.println("                 }");
        Out.println();
        Out.println("               if (firstTimeStampSignature.equals(((" + O._BaseClassName + ") d).getTimeStampSignature()) == false)");
        Out.println("                 {");
        Out.println("                   LOG.debug(QueryDetails._LOGGING_HEADER + \"The '" + Helper.getFullAppDataClassName(O) + "' object at positon #\" + index + \" failed matching the list of updated current vs value based timestamps.\");");
        Out.println("                   QueryDetails.setLastQuery(" + O.getBaseClassName() + "_Factory.SCHEMA_TABLENAME_LABEL, \"\");");
        Out.println("                   return index;");
        Out.println("                 }");
        Out.println();
        Out.println("               int i = d.populatePreparedStatement(C, PS, AllocatedArrays);");
        Out.println();
        Out.println("               PS.addBatch();");
        Out.println("               if (index != 0 && (index + 1) % batchSize == 0)");
        Out.println("                 {");
        Out.println("                   int[] results = PS.executeBatch();");
        Out.println("                   int failedRec = JDBCHelper.batchWriteDone(results, batchSize);");
        Out.println("                   if (failedRec != -1)");
        Out.println("                     {");
        Out.println("                       LOG.debug(QueryDetails._LOGGING_HEADER + \"A batch of " + Helper.getFullAppDataClassName(O) + " objects between positions #\" + batchStart + \" and #\" + index + \" failed being written to the database.\");");
        Out.println("                       return insertCount+failedRec;");
        Out.println("                     }");
        Out.println("                   for (int index2 = batchStart; index2 <= index; ++index2)");
        Out.println("                     L.get(index2).stateUpdatePostWrite();");
        Out.println("                   LOG.debug(\"Batch-inserted objects between positions #\" + insertCount + \" and #\" + index + \".\");");
        Out.println("                   batchStart = 0;");
        Out.println("                   insertCount+=batchSize;");
        Out.println("                 }");
        Out.println("               if (commitSize > 0 && index != 0 && (index + 1) % commitSize == 0)");
        Out.println("                 {");
        Out.println("                   C.commit();");
        Out.println("                   LOG.debug(\"Commited \" + commitSize + \" batch records. At insert count \" + (index-commitSize+1));");
        Out.println("                 }");

        Out.println("               PS.clearParameters();");
        Out.println("             }");
        Out.println();
        Out.println("           if ((index + 1) % batchSize != 0)");
        Out.println("             {");
        Out.println("               int[] results = PS.executeBatch();");
        Out.println("               int failedRec = JDBCHelper.batchWriteDone(results, L.size() - insertCount);");
        Out.println("               if (failedRec != -1)");
        Out.println("                 {");
        Out.println("                   LOG.debug(QueryDetails._LOGGING_HEADER + \"A batch of '" + O.getAppDataClassName() + "' objects ending at position #\" + index + \" failed being written to the database.\");");
        Out.println("                   return L.size() - insertCount+failedRec;");
        Out.println("                 }");
        Out.println("               for (int index2 = batchStart; index2 <= index; ++index2)");
        Out.println("                 L.get(index2).stateUpdatePostWrite();");
        Out.println();
        Out.println("               if(commitSize > 0)");
        Out.println("                 {");
        Out.println("                   C.commit();");
        Out.println("                   LOG.debug(\"Commited \" + insertCount + \" batch records.\");");
        Out.println("                 }");
        Out.println("               LOG.debug(\"Final Batch-inserted objects between positions #\" + insertCount + \" and #\" + index + \".\");");
        Out.println("             }");
        Out.println();
        if (G.getSql().needsSavepoint() == true)
          {
            Out.println("           C.releaseSavepoint(true);");
          }
        Out.println("           return -1;");
        Out.println("         }");
        Out.println("       catch (java.sql.SQLException E)");
        Out.println("         {");
        Out.println("           C.releaseSavepoint(false);");
        Out.println("           C.handleCatch(E, \"updated or inserted\");");
        Out.println("           return 1;");
        Out.println("         }");
        Out.println("       finally");
        Out.println("         {");
        Out.println("           TILDA__1_0.handleFinally(PS, T0, " + O._BaseClassName + "_Factory.SCHEMA_TABLENAME_LABEL, lastObj != null && lastObj.__Init == InitMode.CREATE ? StatementType.INSERT : StatementType.UPDATE, count, AllocatedArrays);");
        Out.println("           PS = null;");
        Out.println("           AllocatedArrays = null;");
        Out.println("         }");
        Out.println("       }");
      }


    @Override
    public void genMethodToOutput(PrintWriter Out, GeneratorSession G, OutputMapping OM)
    throws Exception
      {
        for (OutputFormatType OFT : OM._OutputTypes)
          switch (OFT)
            {
              case JSON:
                genMethodToJSON(Out, G, OM);
                break;
              case CSV:
                genMethodToCSV(Out, G, OM);
                break;
              case NVP:
                genMethodToNVP(Out, G, OM);
                break;
              default:
                throw new Error("OutputFormatType " + OFT + " is not supported in the Output methog generation.");
            }
      }


    protected static void genMethodToJSON(PrintWriter Out, GeneratorSession G, OutputMapping J)
    throws Exception
      {
        Out.println("   public static void toJSON" + J._Name + "(java.io.Writer Out, List<" + Helper.getFullAppDataClassName(J._ParentObject) + "> L, String Lead, boolean FullList) throws java.io.IOException");
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
        Out.println("   public static void toJSON" + J._Name + "(java.io.Writer Out, " + Helper.getFullAppDataClassName(J._ParentObject) + " ObjApp, boolean FullObject) throws java.io.IOException");
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
              // if (C.getType() == ColumnType.DATETIME && C.isOCCGenerated() == false)
              // First = JSONExport(Out, First, C._ParentObject.getColumn(C.getName()+"TZ"));
            }
        Out.println("      if (FullObject == true)");
        Out.println("       Out.write(\" }\");");
        Out.println("      PerfTracker.add(TransactionType.TILDA_TOJSON, System.nanoTime() - T0);");
        Out.println("    }");

        if (J._ParentObject.isOCC() == true && (J._ParentObject._TildaType == TildaType.OBJECT || J._ParentObject._TildaType == TildaType.VIEW) && J._Sync == true)
          {
            Out.println();
            Out.println("   public static boolean toJSON" + J._Name + "(java.io.Writer Out, " + Helper.getFullAppDataClassName(J._ParentObject) + " Data, String ElementName, String Lead, ZonedDateTime LastSync)");
            Out.println("   throws java.io.IOException");
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
            Out.println("   public static void toJSON" + J._Name + "(java.io.Writer Out, List<" + Helper.getFullAppDataClassName(J._ParentObject) + "> L, String ElementName, String Lead, ZonedDateTime LastSync)");
            Out.println("   throws java.io.IOException");
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
            Out.println();
          }
      }


    protected static void genMethodToCSV(PrintWriter Out, GeneratorSession G, OutputMapping J)
    throws Exception
      {
        Out.println("   public static String getCSVHeader" + J._Name + "()");
        Out.println("    {");
        StringBuilder header = new StringBuilder();
        for (Column C : J._ColumnObjs)
          if (C != null)
            {
              if (C.getType() == ColumnType.JSON)
                throw new Error("toCSV doesn't support export of JSON columns: this should have have come all the way here.");
              if (header.length() != 0)
                header.append(",");
              header.append(TextUtil.escapeDoubleQuoteForCSV(C.getName()));
            }
        Out.println("      return " + TextUtil.escapeDoubleQuoteWithSlash(header.toString()) + ";");
        Out.println("    }");
        Out.println();
        Out.println("   public static void toCSV" + J._Name + "(java.io.Writer Out, List<" + Helper.getFullAppDataClassName(J._ParentObject) + "> L, boolean includeHeader) throws java.io.IOException");
        Out.println("    {");
        Out.println("      long T0 = System.nanoTime();");
        Out.println("      if (includeHeader == true)");
        Out.println("        Out.write(getCSVHeader" + J._Name + "() + \"\\n\");");
        Out.println("      for (" + Helper.getFullAppDataClassName(J._ParentObject) + " O : L)");
        Out.println("       if (O!=null)");
        Out.println("        {");
        Out.println("          toCSV" + J._Name + "(Out, O);");
        Out.println("          Out.write(\"\\n\");");
        Out.println("        }");
        Out.println("      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);");
        Out.println("    }");

        Out.println();
        Out.println("   public static void toCSV" + J._Name + "(java.io.Writer Out, " + Helper.getFullAppDataClassName(J._ParentObject) + " Data) throws java.io.IOException");
        Out.println("    {");
        Out.println("      long T0 = System.nanoTime();");
        Out.println("      StringBuilder Str = new StringBuilder();");
        Out.println();
        boolean First = true;
        for (Column C : J._ColumnObjs)
          if (C != null)
            {
              First = Helper.CSVExport(Out, First, C);
            }
        Out.println("      Out.write(Str.toString());");
        Out.println("      PerfTracker.add(TransactionType.TILDA_TOCSV, System.nanoTime() - T0);");
        Out.println("    }");
      }




    protected static void genMethodToNVP(PrintWriter Out, GeneratorSession G, OutputMapping J)
    throws Exception
      {
        if (J._NVPSrc.equals(NVPSourceType.ROWS))
          {

            Column nameCol = J._ColumnObjs.get(0);
            Column valCol = J._ColumnObjs.get(1);

            String nameType = TextUtil.normalCapitalization(nameCol.getType().name());
            String valType = TextUtil.normalCapitalization(valCol.getType().name());

            if (nameType.equalsIgnoreCase("Char"))
              nameType = "Character";
            if (valType.equalsIgnoreCase("Char"))
              valType = "Character";

            Out.println("   public static Map<" + nameType + ", " + valType + "> toNVP" + J._Name + "(List<" + Helper.getFullAppDataClassName(J._ParentObject) + "> L) throws Exception");
            Out.println("    {");
            Out.println("      Map<" + nameType + ", " + valType + "> M = new HashMap<" + nameType + ", " + valType + ">();");
            Out.println("      for (" + Helper.getFullAppDataClassName(J._ParentObject) + " D : L)");
            Out.println("        {");
            Out.println("          " + valType + " val = M.get(D.get" + TextUtil.capitalizeFirstCharacter(nameCol.getName()) + "());");
            Out.println("          if(val != null)");
            Out.println("            throw new Exception(\"The key \" + D.get" + TextUtil.capitalizeFirstCharacter(nameCol.getName()) + "() + \" with value \" + String.valueOf(val) + \" already exists in the Map. Key values must be unique.\");");
            if (nameCol.getType().name().equalsIgnoreCase("STRING"))
              Out.println("          if(TextUtil.isNullOrEmpty(D.get" + TextUtil.capitalizeFirstCharacter(nameCol.getName()) + "()) == false)");
            else
              Out.println("          if(D.is" + TextUtil.capitalizeFirstCharacter(nameCol.getName()) + "Null() == false)");
            Out.println("            M.put(D.get" + TextUtil.capitalizeFirstCharacter(nameCol.getName()) + "(), D.get" + TextUtil.capitalizeFirstCharacter(valCol.getName()) + "());");
            Out.println("        }");
            Out.println("      return M;");
            Out.println("    }");
          }
        else
          {
            String valType = TextUtil.normalCapitalization(J._NVPValueTypeStr);

            if (valType.equalsIgnoreCase("Char"))
              valType = "Character";

            Out.println("   public static Map<String, " + valType + "> toNVP" + J._Name + "(" + Helper.getFullAppDataClassName(J._ParentObject) + " D) throws Exception");
            Out.println("    {");
            Out.println("      Map<String, " + valType + "> M = new HashMap<String, " + valType + ">();");
            for (Column C : J._ColumnObjs)
              if (C != null)
                {
                  Out.println("      M.put(\"" + C.getName() + "\", " + Helper.NVPValueCast(C, J._NVPValueType) + ");");
                }
            Out.println("      return M;");
            Out.println("    }");
          }
      }

  }
