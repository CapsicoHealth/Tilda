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

import tilda.enums.ColumnMode;
import tilda.enums.FrameworkSourcedType;
import tilda.enums.ObjectLifecycle;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenTildaFactory;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.PrimaryKey;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.SubWhereClause;
import tilda.utils.AnsiUtil;
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
        Out.println("import tilda.db.SelectQuery;");
        Out.println("import tilda.db.UpdateQuery;");
        Out.println("import tilda.db.DeleteQuery;");
        Out.println("import tilda.db.processors.RecordProcessor;");
        Out.println("import tilda.enums.ColumnType;");
        Out.println("import tilda.enums.StatementType;");
        Out.println("import tilda.enums.TransactionType;");
        Out.println("import tilda.performance.PerfTracker;");
        Out.println("import tilda.types.*;");
        Out.println("import tilda.utils.CollectionUtil;");
        Out.println("import tilda.utils.DateTimeUtil;");
        Out.println("import tilda.utils.DurationUtil;");
        Out.println("import tilda.utils.HTMLFilter;");
        Out.println("import tilda.utils.JSONUtil;");
        Out.println("import tilda.utils.SystemValues;");
        Out.println("import tilda.utils.TextUtil;");
      }


    @Override
    public void genClassStart(PrintWriter Out, GeneratorSession G, Object O)
      throws Exception
      {
        Out.println("@SuppressWarnings({ \"unchecked\", \"unused\" })");
        Out.println("public class " + O._BaseClassName + "_Factory");
        Out.println(" {");
        Out.println("   protected static final Logger LOG = LogManager.getLogger(" + O._BaseClassName + "_Factory.class.getName());");
        Out.println();
        Out.println("   protected " + O._BaseClassName + "_Factory() { }");
        Out.println();
        Out.println("   public static final String TABLENAME = TextUtil.Print(" + TextUtil.EscapeDoubleQuoteWithSlash(O.getShortName()) + ", \"\");");
        Out.println();
        Out.println("   protected static abstract class COLS {");
        int Counter = -1;
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              String ColumnPad = O._PadderColumnNames.getPad(C.getName());
              String TypePad   = C._Type.getPad();
              if (C._Nullable == true)
               TypePad+="   ";
              if (C.isCollection() == false)
                TypePad+="   ";
              
//              String ColVarFull = TextUtil.EscapeDoubleQuoteWithSlash(G.getSql().getFullColumnVar(C), "", false);
//              String ColVarShort = TextUtil.EscapeDoubleQuoteWithSlash(G.getSql().getShortColumnVar(C), "", false);
//              String ColVarOthers = TextUtil.EscapeDoubleQuoteWithSlash(G.getSql().getShortColumnVar(C), "", false);
              String ColumnTypeClassName = "Type_"+TextUtil.NormalCapitalization(C._Type.name())+(C.isCollection()?"Collection":"Single")+(C._Nullable==true?"Null":"NotNull");
              Out.println("     public static "+ColumnTypeClassName+TypePad+" " + C.getName().toUpperCase() + ColumnPad + "= new "+ColumnTypeClassName+TypePad+"(\"" + C._ParentObject.getShortName() + "\", \"" + C.getShortName() + "\"" + ColumnPad + ", " + (++Counter) +");");
            }
        Out.println(";");
        Out.println("   }");
        Out.println();
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
        Out.println("   private static class RecordProcessorList implements RecordProcessor");
        Out.println("     {");
        Out.println("       public RecordProcessorList(Connection C, int Start)");
        Out.println("         {");
        Out.println("           _L = new ArrayListResults<" + Helper.getFullAppDataClassName(O) + ">(Start);");
        Out.println("           _C = C;");
        Out.println("         }");
        Out.println("       protected ArrayListResults<" + Helper.getFullAppDataClassName(O) + "> _L = null;");
        Out.println("       protected Connection _C = null;");
        Out.println("       public void    Start  () { }");
        Out.println("       public void    End    (boolean HasMore, int Max) { _L.wrapup(HasMore, Max); }");
        Out.println("       public boolean Process(int Index, java.sql.ResultSet RS) throws Exception");
        Out.println("        {");
        Out.println("          " + Helper.getFullAppDataClassName(O) + " Obj = new " + Helper.getFullAppDataClassName(O) + "();");
        Out.println("          boolean OK = ((" + Helper.getFullBaseClassName(O) + ")Obj).Init(_C, RS);");
        Out.println("          if (OK == true)");
        Out.println("           _L.add(Obj);");
        Out.println("          return OK;");
        Out.println("        }");
        Out.println("     }");
        Out.println();
        Out.println("   private static final ListResults<" + Helper.getFullAppDataClassName(O) + "> ReadMany(Connection C, int LookupId, " + Helper.getFullBaseClassName(O)
            + " Obj, Object ExtraParams, int Start, int Size) throws Exception");
        Out.println("     {");

        Out.println("       long T0 = System.nanoTime();");
        Out.println("       StringBuilder S = new StringBuilder(1024);");
        StringBuilder Str = new StringBuilder();
        Str.append("selec");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            Str.append(", ").append(G.getSql().getFullColumnVar(C));
        Str.setCharAt("selec".length(), 't');
        Str.append(" from ").append(G.getSql().getFullTableVar(O));
        Out.println("       S.append(" + TextUtil.EscapeDoubleQuoteWithSlash(Str.toString()) + ");");
        Helper.SwitchLookupIdWhereClauses(Out, G, O, "       ", false);
        Out.println();
        if (G.getSql().supportsSelectSubsetting() == true)
          {
            Out.println("       C.getSelectSubsettingClause(S, Start, Size+1);");
          }
        Out.println("       String Q = S.toString();");
        Out.println("       S.setLength(0);");
        Out.println("       S = null;");
        Out.println("       QueryDetails.setLastQuery(TABLENAME, Q);");
        Out.println("       LOG.debug(\"TILDA(" + AnsiUtil.NEGATIVE + O.getShortName() + AnsiUtil.NEGATIVE_OFF + "): \"+Q.replaceAll(TABLENAME+\"\\\\.\",\"\"));");
        Out.println("       java.sql.PreparedStatement PS=null;");
        Out.println("       java.sql.ResultSet RS=null;");
        Out.println("       List<java.sql.Array> AllocatedArrays = new ArrayList<java.sql.Array>();");
        Out.println("       int count = 0;");
        Out.println("       RecordProcessorList RPL = new RecordProcessorList(C, Start);");
        Out.println("       try");
        Out.println("        {");
        Out.println("          PS = C.prepareStatement(Q);");
        Out.println("          int i = 0;");
        Helper.SwitchLookupIdPreparedStatement(Out, O, "          ", false, true);
        Out.println();
        Out.println("          count = JDBCHelper.Process(PS.executeQuery(), RPL, " + (G.getSql().supportsSelectSubsetting() == true ? "0" : "Start") + ", Size);");
        Out.println("        }");
        Helper.CatchFinallyBlock(Out, O, "selected", "StatementType.SELECT", false, true);
        Out.println();
        Out.println("      return RPL._L;");
        Out.println("    }");
      }

    @Override
    public void genMethodCreate(PrintWriter Out, GeneratorSession G, Object O, List<Column> CreateColumns, List<Column> DefaultColumns)
      throws Exception
      {
        Out.print("   static public " + Helper.getFullAppDataClassName(O) + " Create(");
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
            Out.println("       Obj.set" + TextUtil.CapitalizeFirstCharacter(PK.getName()) + "(tilda.db.KeysManager.getKey(" + TextUtil.EscapeDoubleQuoteWithSlash(O.getShortName()) + "));");
          }
        if (CreateColumns != null && CreateColumns.isEmpty() == false)
          {
            Out.println();
            Out.println("       // Explicit setters");
            for (Column C : CreateColumns)
              {
                String Pad = O._PadderColumnNames.getPad(C.getName());
                Out.println("       Obj.set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "(" + C.getName() + Pad + ");");
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
      }



    @Override
    public void genMethodLookupByPrimaryKey(PrintWriter Out, GeneratorSession G, PrimaryKey PK, long LookupId)
      {
        Out.print("   static public " + Helper.getFullAppDataClassName(PK._ParentObject) + " LookupByPrimaryKey(");
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
              Out.print("       Obj.set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "(" + C.getName() + Pad + "); ");
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
        
        Out.print("   static public " + Helper.getFullAppDataClassName(I._ParentObject) + " LookupBy" + I._Name + "(");
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
        Out.println("       " + Helper.getFullBaseClassName(I._ParentObject) + " Obj = new " + Helper.getFullAppDataClassName(I._ParentObject) + "();");
        Out.println("       Obj.initForLookup(" + LookupId + ");");
        Out.println();
        for (Column C : I._ColumnObjs)
          if (C != null)
            {
              String Pad = C._ParentObject.getColumnPad(C.getName());
              Out.print("       Obj.set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "(" + C.getName() + Pad + "); ");
              if (I._ParentObject.getLifecycle() != ObjectLifecycle.READONLY)
               Out.print("Obj.__Saved_" + C.getName() + Pad + " = Obj._" + C.getName() + Pad + ";");
              Out.println();
            }
        Out.println();
        Out.println("       return (" + Helper.getFullAppDataClassName(I._ParentObject) + ") Obj;");
        Out.println("     }");
      }

    @Override
    public void genMethodLookupWhereIndex(PrintWriter Out, GeneratorSession G, Index I, int LookupId)
      {
        if (I._Unique == true)
          throw new Error("ERROR: called genMethodLookupWhereIndex with a Unique Index");

        String MethodName = "LookupWhere" + I._Name;
        Out.print("   static public ListResults<" + Helper.getFullAppDataClassName(I._ParentObject) + "> " + MethodName + "(Connection C");
        for (Column C : I._ColumnObjs)
          if (C != null)
            Out.print(", " + JavaJDBCType.getFieldType(C) + " " + C.getName());
        Query q = I._SubQuery == null ? null : I._SubQuery.getQuery(G.getSql());
        if (q != null)
          {
            for (int i = 0; i < q._ColumnObjs.size(); ++i)
              {
                Column c = q._ColumnObjs.get(i);
                String v = q._VarNames.get(i);
                Out.print(", " + JavaJDBCType.getFieldType(c) + " " + v);
              }
          }
        Out.println(", int Start, int Size) throws Exception");
        Out.println("     {");
        Out.println("       " + Helper.getFullBaseClassName(I._ParentObject) + " Obj = new " + Helper.getFullAppDataClassName(I._ParentObject) + "();");
        Out.println("       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);");
        Out.println();
        for (Column C : I._ColumnObjs)
          if (C != null)
            {
              String Pad = C._ParentObject.getColumnPad(C.getName());
              Out.println("       Obj.set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "(" + C.getName() + Pad + ");");
            }
        Out.println();
        if (q != null && q._ColumnObjs.isEmpty() == false)
          {
            Out.print("       " + MethodName + "Params P = new " + MethodName + "Params(");
            boolean First = true;
            for (int i = 0; i < q._ColumnObjs.size(); ++i)
              {
                // Column c = q._ColumnObjs.get(i);
                String v = q._VarNames.get(i);
                if (First == true)
                  First = false;
                else
                  Out.print(", ");
                Out.print(v);
              }
            Out.println(");");
          }
        Out.println();
        Out.println("       return ReadMany(C, " + LookupId + ", Obj, " + (q != null && q._ColumnObjs.isEmpty() == false ? "P" : "null") + ", Start, Size);");
        Out.println("     }");
        Out.println();
        if (q != null && q._ColumnObjs.isEmpty() == false)
          Helper.MakeParamStaticClass(Out, q._ColumnObjs, q._VarNames, MethodName);
      }


    @Override
    public void genMethodLookupWhereQuery(PrintWriter Out, GeneratorSession G, SubWhereClause SWC, int LookupId)
      {
        if (SWC._Unique == true)
          throw new Error("ERROR: called genMethodLookupWhereQuery with a Unique SubWhereclause");
        
        String MethodName = "LookupWhere" + SWC._Name;
        Out.print("   static public ListResults<" + Helper.getFullAppDataClassName(SWC._ParentObject) + "> " + MethodName
            + "(Connection C");
        for (int i = 0; i < SWC._ColumnObjs.size(); ++i)
          {
            Column c = SWC._ColumnObjs.get(i);
            String v = SWC._VarNames.get(i);
            Out.print(", " + JavaJDBCType.getFieldType(c) + " " + v);
          }
        Out.println(", int Start, int Size) throws Exception");
        Out.println("     {");
        Out.println("       " + Helper.getFullBaseClassName(SWC._ParentObject) + " Obj = new " + Helper.getFullAppDataClassName(SWC._ParentObject) + "();");
        Out.println("       Obj.initForLookup(tilda.utils.SystemValues.EVIL_VALUE);");
        Out.println();
        if (SWC._ColumnObjs.isEmpty() == false)
          {
            Out.print("       " + MethodName + "Params P = new " + MethodName + "Params(");
            boolean First = true;
            for (int i = 0; i < SWC._ColumnObjs.size(); ++i)
              {
                // Column c = q._ColumnObjs.get(i);
                String v = SWC._VarNames.get(i);
                if (First == true)
                  First = false;
                else
                  Out.print(", ");
                Out.print(v);
              }
            Out.println(");");
          }
        Out.println();
        Out.println("       return ReadMany(C, " + LookupId + ", Obj, " + (SWC._ColumnObjs.isEmpty() == false ? "P" : "null") + ", Start, Size);");
        Out.println("     }");
        Out.println();
        if (SWC._ColumnObjs.isEmpty() == false)
          Helper.MakeParamStaticClass(Out, SWC._ColumnObjs, SWC._VarNames, MethodName);
      }


    @Override
    public void genMethodLookupByUniqueQuery(PrintWriter Out, GeneratorSession G, SubWhereClause SWC, int LookupId)
      {
        if (SWC._Unique == false)
          throw new Error("ERROR: called genMethodLookupByUniqueQuery with a non-Unique SubWhereclause");
        
        String MethodName = "LookupBy" + SWC._Name;
        Out.print("   static public " + Helper.getFullAppDataClassName(SWC._ParentObject) + " " + MethodName + "(");
        boolean First = true;
        for (Column C : SWC._ColumnObjs)
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
        Out.println("       " + Helper.getFullBaseClassName(SWC._ParentObject) + " Obj = new " + Helper.getFullAppDataClassName(SWC._ParentObject) + "();");
        Out.println("       Obj.initForLookup(" + LookupId + ");");
        Out.println();
        for (Column C : SWC._ColumnObjs)
          if (C != null)
            {
              String Pad = C._ParentObject.getColumnPad(C.getName());
              Out.print("       Obj.set" + TextUtil.CapitalizeFirstCharacter(C.getName()) + Pad + "(" + C.getName() + Pad + "); ");
              if (SWC._ParentObject.getLifecycle() != ObjectLifecycle.READONLY)
               Out.print("Obj.__Saved_" + C.getName() + Pad + " = Obj._" + C.getName() + Pad + ";");
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
        Out.println("   public static SelectQuery newSelectQuery(Connection C) throws Exception { return new SelectQuery(C   , " + O.getBaseClassName() + "_Factory.TABLENAME); }");
        Out.println("   public static SelectQuery newWhereQuery (            ) throws Exception { return new SelectQuery(null, " + O.getBaseClassName() + "_Factory.TABLENAME); }");
        Out.println("   public static ListResults<" + Helper.getFullAppDataClassName(O) + "> runSelect(Connection C, SelectQuery Q, int Start, int Size) throws Exception");
        Out.println("     {");
        Out.println("       return ReadMany(C, -7, null, Q, Start, Size);");
        Out.println("     }");
        if (O._LC == ObjectLifecycle.NORMAL)
          {
            Out.println("   public static UpdateQuery newUpdateQuery(Connection C) throws Exception { return new UpdateQuery(C, " + O.getBaseClassName() + "_Factory.TABLENAME); }");
            Out.println("   public static DeleteQuery newDeleteQuery(Connection C) throws Exception { return new DeleteQuery(C, " + O.getBaseClassName() + "_Factory.TABLENAME); }");
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
        Out.println("       ListResults<" + Helper.getFullAppDataClassName(O) + "> L = LookupWhereAll(C, 0, -1);");
        Out.println("       for (" + Helper.getFullAppDataClassName(O) + " obj : L)");
        Out.println("        {");
        if (O.getColumn("group") != null)
          {
            Out.println("          if (TextUtil.FindElement(" + Helper.getFullAppDataClassName(O) + "._group_Values, obj.getGroup(), 0, true, 0) == -1)");
            Out.println("           throw new Exception(\"Could not validate against the model. Invalid group value in object \"+obj+\". Allowed values are: \"+TextUtil.Print(" + Helper.getFullAppDataClassName(O)
                + "._group_Values, 0)+\".\");");
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
              Out.print("obj.get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
            }
        Out.println(", obj);");
        Out.println("        }");
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
        Out.println("       ListResults<" + Helper.getFullAppDataClassName(O) + "> L = LookupWhereAll(C, 0, -1);");
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

  }
