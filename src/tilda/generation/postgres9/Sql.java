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

package tilda.generation.postgres9;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.StringBuilderWriter;

import tilda.db.stores.PostgreSQL;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Formula;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.Value;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.parsing.parts.ViewJoin;
import tilda.parsing.parts.ViewPivot;
import tilda.utils.PaddingTracker;
import tilda.utils.TextUtil;

public class Sql extends PostgreSQL implements CodeGenSql
  {
    protected static final Logger LOG = LogManager.getLogger(Sql.class.getName());

    @Override
    public String getFileName(Base O)
      {
        return "TILDA___" + getName() + "." + O.getSchema()._Name + ".sql";
      }

    @Override
    public String getFullTableVar(Object O, int i)
      {
        return O.getSchema()._Name + "_" + O.getBaseName() + i;
      }

    @Override
    public String getFullColumnVar(Column C, int i)
      {
        return C._ParentObject.getSchema()._Name + (i >= 2 ? "_" : ".") + C._ParentObject.getBaseName() + (i >= 2 ? i : "") + ".\"" + C.getName() + "\"";
      }

    @Override
    public String getShortColumnVar(Column C)
      {
        return "\"" + C.getName() + "\"";
      }

    @Override
    public String getColumnType(Column C)
      {
        return getColumnType(C.getType(), C._Size, C._Mode, C.isCollection());
      }

    @Override
    public String getColumnTypeRaw(Column C, boolean MultiOverride)
      {
        return getColumnTypeRaw(C.getType(), C._Size == null ? 0 : C._Size, C._Mode == ColumnMode.CALCULATED, C.isCollection(), MultiOverride);
      }

    @Override
    public String getColumnTypeRaw(ColumnType Type, int Size, boolean isCollection)
      {
        return getColumnTypeRaw(Type, Size, false, isCollection, false);
      }

    public String getColumnTypeRaw(ColumnType Type, int Size, boolean Calculated, boolean isCollection, boolean MultiOverride)
      {
        if (Type == ColumnType.STRING && Calculated == false)
          return isCollection == true || MultiOverride == true ? "text" : Size < 15 ? PostgresType.CHAR._SQLType : Size < 4096 ? PostgresType.STRING._SQLType : "text";
        if (Type == ColumnType.JSON)
          return "jsonb";
        return isCollection == true ? PostgresType.get(Type)._SQLArrayType : PostgresType.get(Type)._SQLType;
      }




    @Override
    public boolean stringNeedsTrim(Column C)
      {
        return C.getType() == ColumnType.STRING && C._Mode != ColumnMode.CALCULATED && C.isCollection() == false && C._Size < 15;
      }


    @Override
    public String getBaseSelectStatement(List<Column> Columns)
      {
        // TODO Auto-generated method stub
        return null;
      }

    @Override
    public boolean supportsArrays()
      {
        return true;
      }

    @Override
    public String getEqualCurentTimestamp()
      {
        return "= statement_timestamp()";
      }

    @Override
    public String getCommaCurentTimestamp()
      {
        return ", statement_timestamp()";
      }

    @Override
    public String getFullTableVar(Object O)
      {
        StringBuilder Str = new StringBuilder();
        super.getFullTableVar(Str, O._ParentSchema._Name, O._Name);
        return Str.toString();
      }

    @Override
    public String getFullColumnVar(Column C)
      {
        StringBuilder Str = new StringBuilder();
        super.getFullColumnVar(Str, C._ParentObject.getSchema()._Name, C._ParentObject.getBaseName(), C.getName());
        return Str.toString();
      }


    @Override
    public void genFileStart(PrintWriter Out, Schema S)
    throws Exception
      {
        Out.println("create schema if not exists " + S._Name + ";");
      }

    @Override
    public void genClassStart(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
      }

    @Override
    public void genDDL(PrintWriter Out, Object O)
      {
        Out.println("create table if not exists " + O._ParentSchema._Name + "." + O._Name + " -- " + O._Description);
        Out.print(" (  ");

        PaddingTracker PadderColumnTypes = new PaddingTracker();
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            PadderColumnTypes.track(getColumnType(C));

        boolean First = true;
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            {
              if (First == true)
                First = false;
              else
                Out.print("  , ");
              Out.print("\"" + C.getName() + "\"" + O._PadderColumnNames.getPad(C.getName()) + "  " + PadderColumnTypes.pad(getColumnType(C)));
              Out.print(C._Nullable == false ? "  not null" : "          ");
              Out.println("   -- " + C._Description);
            }
        if (O._PrimaryKey != null)
          {
            Out.print("  , PRIMARY KEY(");
            PrintColumnList(Out, O._PrimaryKey._ColumnObjs);
            Out.println(")");
          }
        if (O._ForeignKeys != null)
          for (ForeignKey FK : O._ForeignKeys)
            if (FK != null)
              {
                Out.print("  , FOREIGN KEY (");
                PrintColumnList(Out, FK._SrcColumnObjs);
                Out.println(") REFERENCES " + FK._DestObjectObj._ParentSchema._Name + "." + FK._DestObjectObj._Name + " ON DELETE restrict ON UPDATE cascade");
              }
        Out.println(" );");
        Out.println("COMMENT ON TABLE " + O.getShortName() + " IS E" + TextUtil.EscapeSingleQuoteForSQL(O._Description) + ";");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            Out.println("COMMENT ON COLUMN " + O.getShortName() + ".\"" + C.getName() + "\" IS E" + TextUtil.EscapeSingleQuoteForSQL(C._Description) + ";");
      }

    @Override
    public String genDDL(PrintWriter OutFinal, View V)
    throws Exception
      {
        StringBuilderWriter OutStr = new StringBuilderWriter();
        PrintWriter Out = new PrintWriter(OutStr);
        boolean hasAggregates = false;

        Object ObjectMain = V._ViewColumns.get(0)._SameAsObj._ParentObject;
        Out.println("-- " + TextUtil.EscapeSingleQuoteForSQL(V._Description));
        Out.print("select ");
        boolean First = true;
        Map<String, Integer> M = new HashMap<String, Integer>();
        for (ViewColumn VC : V._ViewColumns)
          {
            if (VC == null)
              continue;
            if (VC._Aggregate == AggregateType.COUNT || VC._SameAsObj._Mode != ColumnMode.CALCULATED && VC._JoinOnly == false)
              {
                if (First == true)
                  First = false;
                else
                  Out.print("\n     , ");

                if (VC._Aggregate == AggregateType.COUNT)
                  {
                    Out.print("count(*) as \"" + VC.getName() + "\"");
                    hasAggregates = true;
                  }
                else
                  {
                    if (ObjectMain._Name.equals(VC._SameAsObj._ParentObject._Name) == true)
                      {
                        Object FKObj = VC._SameAsObj.getSingleColFK();
                        if (FKObj != null)
                          {
                            Integer I = M.get(FKObj._Name);
                            I = new Integer(I == null ? 1 : I.intValue() + 1);
                            M.put(FKObj._Name, I);
                          }
                      }

                    if (VC._Aggregate != null)
                      {
                        Out.print(getAggregateStr(VC._Aggregate) + "(");
                        if (VC._Aggregate == AggregateType.ARRAY && VC._SameAsObj.getType() == ColumnType.STRING)
                          Out.print("trim(");
                        hasAggregates = true;
                      }
                    Integer I = M.get(VC._SameAsObj._ParentObject._Name);
                    if (I != null && I.intValue() > 1)
                      {
                        Out.print(getFullColumnVar(VC._SameAsObj, I.intValue()));
                      }
                    else
                      {
                        Out.print(getFullColumnVar(VC._SameAsObj));
                      }
                    if (VC._Aggregate != null)
                      {
                        if (VC._Aggregate == AggregateType.ARRAY && VC._SameAsObj.getType() == ColumnType.STRING)
                          Out.print(")");
                        Out.print(")");
                      }
                    Out.print(" as \"" + VC.getName() + "\" -- " + VC._SameAsObj._Description);
                  }
              }
          }
        Out.println();
        Set<String> Names = new HashSet<String>();
        List<Object> Objects = new ArrayList<Object>();
        Out.println("  from " + ObjectMain.getShortName());
        Names.add(ObjectMain.getFullName());
        Objects.add(ObjectMain);
        for (ViewColumn C : V._ViewColumns)
          if (C != null && C._SameAsObj != null)
            {
              Object T = C._SameAsObj._ParentObject;
              if (Names.add(T.getFullName()) == true)
                {
                  ViewJoin VJ = V.getViewjoin(T.getBaseName());
                  if (VJ != null)
                    {
                      Out.print("  " + (C._Join == null ? "left" : C._Join) + " join " + VJ._ObjectObj.getShortName());
                      Query Q = VJ.getQuery(this);
                      if (Q == null)
                        throw new Exception("Cannot generate the view because an 'on' clause matching the active database '" + getName() + "' is not available.");
                      Out.print(" on " + Q._Clause);
                      Out.println();
                      Integer I = M.get(VJ._ObjectObj._Name);
                      if (I != null)
                        for (int i = 2; i <= I.intValue(); ++i)
                          {
                            Out.print("     " + (C._Join == null ? "left" : C._Join) + " join " + VJ._ObjectObj.getShortName());
                            Out.print(" as " + getFullTableVar(C._SameAsObj._ParentObject, I.intValue()));
                            Out.print(" on " + Q._Clause);
                            Out.println();
                          }
                    }
                  else
                    {
                      Object FoundFK = null;
                      for (Object Obj : Objects)
                        if (CheckFK(Out, Obj, T, C, 1) == true)
                          {
                            if (FoundFK != null)
                              throw new Error("Object " + T.getFullName() + " has an FK to both " + FoundFK.getFullName() + " and " + Obj.getFullName() + ", which makes creating a view ambiguous.");
                            FoundFK = Obj;
                            Integer I = M.get(C._SameAsObj._ParentObject._Name);
                            if (I != null)
                              for (int i = 2; i <= I.intValue(); ++i)
                                CheckFK(Out, Obj, T, C, i);
                          }
                      if (FoundFK == null)
                        throw new Error("Cannot find a FK relationship between " + T.getFullName() + " and " + ObjectMain.getFullName() + ".");
                    }
                  Objects.add(T);
                }
            }
        if (V._SubQuery != null)
          {
            Query q = V._SubQuery.getQuery(this);
            if (q != null)
              {
                boolean NewLine = q._Clause.indexOf("\n") >= 0;
                Out.print(" where (");
                Out.print(NewLine == true ? q._Clause.replaceAll("\n", "\n        ") : q._Clause);
                Out.print(NewLine == true ? "\n       )" : ")");
              }
            Out.println();
          }
        if (V._Pivot != null)
          {
            if (V._SubQuery == null)
              Out.print(" where ");
            else
              Out.print("   and " + getFullColumnVar(V._Pivot._VC._SameAsObj) + " in (" + PrintValueList(V._Pivot) + ")");
          }

        if (hasAggregates == true)
          {
            Out.print("     group by ");
            First = true;
            for (ViewColumn VC : V._ViewColumns)
              if (VC != null && VC._Aggregate == null && VC._JoinOnly == false)
                {
                  if (First == true)
                    First = false;
                  else
                    Out.print(", ");
                  Out.print(getFullColumnVar(VC._SameAsObj));
                }
            Out.println();
          }
        if (V._Pivot != null)
          {
            Out.print("     order by ");
            First = true;
            for (ViewColumn VC : V._ViewColumns)
              if (VC != null && VC._Aggregate == null && VC._JoinOnly == false)
                {
                  if (First == true)
                    First = false;
                  else
                    Out.print(", ");
                  Out.print(getFullColumnVar(VC._SameAsObj));
                }
            Out.println();
          }
        // Out.println(" ;");
        String Str = OutStr.toString();
        if (V._Pivot != null)
          {
            StringBuilder b = new StringBuilder();
            b.append("select unnest(ARRAY[").append(PrintValueList(V._Pivot)).append("]) as _x order by _x\n");
            // b.append("select distinct ").append(getFullColumnVar(V._Pivot._VC._SameAsObj)).append("\n")
            // .append(" from ").append(V._Pivot._VC._SameAsObj._ParentObject.getShortName()).append("\n")
            // .append(" where ").append(PivotIn(V._Pivot)).append("\n")
            // .append("order by ").append(getFullColumnVar(V._Pivot._VC._SameAsObj)).append("\n");
            Str = "select * from crosstab (\n" + TextUtil.EscapeSingleQuoteForSQL(Str) + ",\n"
            + TextUtil.EscapeSingleQuoteForSQL(b.toString()) + ")\n"
            + "as final_result (";

            for (int i = 0; i < V._ViewColumns.size() - 2; ++i)
              {
                ViewColumn VC = V._ViewColumns.get(i);
                if (VC != null && VC._SameAsObj._Mode != ColumnMode.CALCULATED)
                  {
                    if (i != 0)
                      Str += "  , ";
                    Str += "\"" + VC.getName() + "\" " + getColumnType(VC._SameAsObj);
                  }
              }
            for (int i = 0; i < V._Pivot._Values.length; ++i)
              {
                Str += ", \"" + V._Pivot._Values[i]._Value + "\" integer";
              }
            Str += ")\n";
          }
        if (V._Formulas != null && V._Formulas.length > 0)
          {
            StringBuilder b = new StringBuilder();
            b.append("select *\n");
            for (Formula F : V._Formulas)
              {
                b.append("     -- ").append(String.join("\n     -- ", F._Description)).append("\n");
                b.append("     , (").append(F._Formula).append(")::int as \"").append(F._Name).append("\"\n");
              }
            b.append("\n from (\n").append(Str).append("\n      ) as T");
            if (V._Realize != null)
              b.append("\n-- Realized as "+genRealizedColumnList(V)+"\n");
            Str = b.toString();
          }
        OutFinal.println("create or replace view " + V._ParentSchema._Name + "." + V._Name + " as ");
        OutFinal.println(Str + ";");
        OutFinal.println();
        OutFinal.println("COMMENT ON VIEW " + V._ParentSchema._Name + "." + V._Name + " IS E" + TextUtil.EscapeSingleQuoteForSQL(Str.replace("\r\n", "\\n").replace("\n", "\\n")) + ";");
        OutFinal.println();
        for (int i = 0; i < V._ViewColumns.size(); ++i)
          {
            ViewColumn VC = V._ViewColumns.get(i);
            if (V._Pivot != null && VC == V._Pivot._VC)
              continue;
            if (V._Pivot != null && VC._Aggregate == AggregateType.COUNT)
              continue;
            if (VC != null && VC._SameAsObj != null && VC._SameAsObj._Mode != ColumnMode.CALCULATED && VC._JoinOnly == false)
              OutFinal.println("COMMENT ON COLUMN " + V.getShortName() + ".\"" + VC.getName() + "\" IS E" + TextUtil.EscapeSingleQuoteForSQL(VC._SameAsObj._Description) + ";");
          }
        if (V._Pivot != null)
          for (int i = 0; i < V._Pivot._Values.length; ++i)
            OutFinal.println("COMMENT ON COLUMN " + V.getShortName() + ".\"" + V._Pivot._Values[i]._Value + "\" IS E"
            + TextUtil.EscapeSingleQuoteForSQL("The pivoted column count from '" + V._Pivot._ColumnName + "'='" + V._Pivot._Values[i]._Value + "', " + V._Pivot._Values[i]._Description)
            + ";");
        if (V._Formulas != null)
          for (Formula F : V._Formulas)
            OutFinal.println("COMMENT ON COLUMN " + V.getShortName() + ".\"" + F._Name + "\" IS E"
            + TextUtil.EscapeSingleQuoteForSQL("The calculated formula: " + String.join("\\n", F._Description))
            + ";");

        if (V._Realize != null)
          {
            OutFinal.println();
            String TName = V._Name.substring(0, V._Name.length() - (V._Pivot != null ? "PivotView" : "View").length());
            OutFinal.append("DROP FUNCTION IF EXISTS " + V._ParentSchema._Name + ".Refill_" + TName + "Realized();\n")
            .append("CREATE OR REPLACE FUNCTION " + V._ParentSchema._Name + ".Refill_" + TName + "Realized() RETURNS boolean AS $$\n")
            .append("BEGIN\n")
            .append("  DROP TABLE IF EXISTS " + V._ParentSchema._Name + "." + TName + "Realized;\n")
            .append("  CREATE TABLE " + V._ParentSchema._Name + "." + TName + "Realized "
                        +"AS SELECT "+genRealizedColumnList(V)+" FROM " + V._ParentSchema._Name + "." + V._Name + ";\n")
            .append("  return true;\n")
            .append("END; $$\n")
            .append("LANGUAGE PLPGSQL;\n")
            .append("\n")
            .append("\n")
            .append("SELECT " + V._ParentSchema._Name + ".Refill_" + TName + "Realized();")
            .append("-- !!! THIS MAY TAKE SEVERAL MINUTES !!! --")
            .append("\n")
            .append("\n");
          }
        if (V._Formulas != null && V._Formulas.length > 0)
          {
            OutputFormulaInDBDocs(OutFinal, V);
          }


        OutStr.close();
        return Str;
      }

    private String genRealizedColumnList(View V)
      {
        StringBuilder Str = new StringBuilder();
        boolean First = true;
        for (ViewColumn VC : V._ViewColumns)
          {
            if (VC == null || VC._SameAsObj._Mode != ColumnMode.NORMAL || VC._JoinOnly == true)
              continue;
            if (TextUtil.FindElement(V._Realize._Excludes, VC.getName(), true, 0) == -1)
              {
                if (First == false)
                  Str.append(", ");
                else
                  First = false;
                Str.append(V._ParentSchema._Name + "." + V._Name + ".\"" + VC._Name + "\"");
              }
          }
        for (Formula F : V._Formulas)
          {
            if (TextUtil.FindElement(V._Realize._Excludes, F._Name, true, 0) == -1)
              {
                if (First == false)
                  Str.append(", ");
                else
                  First = false;
                Str.append(V._ParentSchema._Name + "." + V._Name + ".\"" + F._Name + "\"");
              }
          }
        return Str.toString();
      }

    private void OutputFormulaInDBDocs(PrintWriter Out, View V)
      {
        Out.println("DELETE FROM " + V._ParentSchema._Name + ".TildaFormulaValue where \"viewName\"=" + TextUtil.EscapeSingleQuoteForSQL(V._Name)+";");
        Out.println("DELETE FROM " + V._ParentSchema._Name + ".TildaFormulaReference where \"viewName\"=" + TextUtil.EscapeSingleQuoteForSQL(V._Name)+";");
        Out.println("DELETE FROM " + V._ParentSchema._Name + ".TildaFormula where \"viewName\"=" + TextUtil.EscapeSingleQuoteForSQL(V._Name)+";");

        String RealizedTable = V._Realize == null ? null : V._Name.substring(0, V._Name.length() - (V._Pivot != null ? "PivotView" : "View").length()) + "Realized";
        Out.println("INSERT INTO " + V._ParentSchema._Name + ".TildaFormula (\"viewName\", \"realizedTableName\", \"name\", \"title\", \"description\", \"formula\", \"html\", \"created\", \"lastUpdated\")");
        Out.print("    VALUES ");
        int count = -1;
        for (Formula F : V._Formulas)
          {
            Out.print(++count == 0 ? "(" : "          ,(");
            Out.print(TextUtil.EscapeSingleQuoteForSQL(V._Name));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(RealizedTable));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(F._Name));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(F._Title));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(String.join("\n", F._Description)));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(String.join("\n", F._FormulaStrs)));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL("<B>THIS <U>IS</U> ONLY A TEST <I>HTML</I> FRAGMENT!"));
            Out.println(", current_timestamp, current_timestamp)");
          }
        Out.println("   ;");

        Out.println("INSERT INTO " + V._ParentSchema._Name + ".TildaFormulaValue (\"viewName\", \"formulaName\", \"value\", \"description\", \"created\", \"lastUpdated\")");
        Out.print("    VALUES ");
        count = -1;
        for (Formula F : V._Formulas)
          {
            if (F._Values != null && F._Values.length > 0)
              for (Value Val : F._Values)
                {
                  Out.print(++count == 0 ? "(" : "          ,(");
                  Out.print(TextUtil.EscapeSingleQuoteForSQL(V._Name));
                  Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(F._Name));
                  Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(Val._Value));
                  Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(Val._Description));
                  Out.println(", current_timestamp, current_timestamp)");
                }
          }
        Out.println("   ;");

        Out.println("INSERT INTO " + V._ParentSchema._Name + ".TildaFormulaReference (\"viewName\", \"formulaName\", \"referenceName\", \"referenceType\", \"description\", \"created\", \"lastUpdated\")");
        Out.print("    VALUES ");
        count = -1;
        for (Formula F : V._Formulas)
          {
            Matcher M = F._ViewColumnsRegEx.matcher(String.join("\n", F._FormulaStrs));
            Set<String> Names = new HashSet<String>();
            while (M.find() == true)
              {
                String s = M.group(1);
                if (Names.add(s) == false)
                  continue;
                ViewColumn VC = V.getViewColumn(s);
                if (VC != null)
                  {
                    Out.print(++count == 0 ? "(" : "          ,(");
                    Out.print(TextUtil.EscapeSingleQuoteForSQL(V._Name));
                    Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(F._Name));
                    Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(VC._Name));
                    Out.print(", 'CLMN'");
                    Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(VC._SameAsObj._Description));
                    Out.println(", current_timestamp, current_timestamp)");
                  }
              }
            Names.clear();
            M = F._FormulasRegEx.matcher(String.join("\n", F._FormulaStrs));
            while (M.find() == true)
              {
                String s = M.group(1);
                if (Names.add(s) == false)
                  continue;
                for (Formula F2 : V._Formulas)
                  if (s.equals(F2._Name) == true)
                    {
                      Out.print(++count == 0 ? "(" : "          ,(");
                      Out.print(TextUtil.EscapeSingleQuoteForSQL(V._Name));
                      Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(F._Name));
                      Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(F2._Name));
                      Out.print(", 'FRML'");
                      Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(String.join("\n", F2._Description)));
                      Out.println(", current_timestamp, current_timestamp)");
                      break;
                    }
              }
          }
        Out.println("   ;");

      }

    private String PrintValueList(ViewPivot P)
      {
        StringBuilder Str = new StringBuilder();
        for (int i = 0; i < P._Values.length; ++i)
          {
            if (i != 0)
              Str.append(", ");
            Str.append(TextUtil.EscapeSingleQuoteForSQL(P._Values[i]._Value));
          }
        return Str.toString();
      }

    private boolean CheckFK(PrintWriter Out, Object Obj1, Object Obj2, ViewColumn C, int JoinIndex)
      {
        boolean Found = false;
        // LOG.debug("Checking FKs to " + Obj1.getBaseName());
        int count = 1;
        for (ForeignKey FK : Obj2._ForeignKeys)
          {
            // LOG.debug(" . Checking FK " + FK._ParentObject.getBaseName() + " to " + FK._DestObjectObj.getBaseName());
            if (FK._DestObjectObj == Obj1)
              {
                if (count == JoinIndex)
                  {
                    Out.print("  " + (C._Join == null ? "left" : C._Join) + " join " + Obj2.getShortName());
                    if (JoinIndex >= 2)
                      Out.print(" as " + getFullTableVar(Obj2, JoinIndex));
                    Out.print(" on ");
                    for (int i = 0; i < FK._SrcColumnObjs.size(); ++i)
                      {
                        if (i != 0)
                          Out.print(" AND ");
                        Out.print(getFullColumnVar(FK._SrcColumnObjs.get(i)) + "=" + getFullColumnVar(Obj1._PrimaryKey._ColumnObjs.get(i), JoinIndex));
                      }
                    Out.println();
                    Found = true;
                    // LOG.debug(" --> FOUND");
                    break;
                  }
                ++count;
              }
          }
        if (Found == false)
          {
            // LOG.debug("Checking FKs to " + Obj2.getBaseName());
            for (ForeignKey FK : Obj1._ForeignKeys)
              {
                // LOG.debug(" . Checking FK "+FK._ParentObject.getBaseName()+" to "+FK._DestObjectObj.getBaseName());
                if (FK._DestObjectObj == Obj2)
                  {
                    if (count == JoinIndex)
                      {
                        Out.print("     " + (C._Join == null ? "inner" : C._Join) + " join " + Obj2.getShortName());
                        if (JoinIndex >= 2)
                          Out.print(" as " + getFullTableVar(Obj2, JoinIndex));
                        Out.print(" on ");
                        for (int i = 0; i < FK._SrcColumnObjs.size(); ++i)
                          {
                            if (i != 0)
                              Out.print(" AND ");
                            Out.print(getFullColumnVar(FK._SrcColumnObjs.get(i)) + "=" + getFullColumnVar(Obj2._PrimaryKey._ColumnObjs.get(i), JoinIndex));
                          }
                        Out.println();
                        Found = true;
                        // LOG.debug(" --> FOUND");
                        break;
                      }
                    ++count;
                  }
              }
          }
        // if (Found == false)
        // LOG.debug(" !!! NOT FOUND !!!");
        return Found;
      }

    @Override
    public void genIndex(PrintWriter Out, Index I)
      {
        if (I._Db == false)
          Out.print("-- app-level index only -- ");
        Out.print("CREATE" + (I._Unique == true ? " UNIQUE" : "") + " INDEX " + I._ParentObject.getBaseName() + "_" + I._Name + " ON " + I._ParentObject.getShortName() + " (");
        if (I._ColumnObjs.isEmpty() == false)
          PrintColumnList(Out, I._ColumnObjs);
        if (I._OrderByObjs.isEmpty() == false)
          {
            boolean First = I._ColumnObjs.isEmpty();
            for (int i = 0; i < I._OrderByObjs.size(); ++i)
              {
                if (First == true)
                  First = false;
                else
                  Out.print(", ");
                Out.print("\"" + I._OrderByObjs.get(i).getName() + "\" " + I._OrderByOrders.get(i));
              }
          }
        Out.println(");");
      }

    @Override
    public void genKeysManagement(PrintWriter Out, Object O)
      {
        Out.println("delete from TILDA.KEY where \"name\" = '" + O._ParentSchema._Name + "." + O._Name + "';");
        Out.println("insert into TILDA.KEY (\"refnum\", \"name\", \"max\", \"count\", \"created\", \"lastUpdated\") values ((select COALESCE(max(\"refnum\"),0)+1 from TILDA.KEY), '"
        + O._ParentSchema._Name + "." + O._Name + "',(select COALESCE(max(\"refnum\"),0)+1 from " + O._ParentSchema._Name + "." + O._Name
        + "), " + O._PrimaryKey._KeyBatch + ", current_timestamp, current_timestamp);");
      }

    private static boolean PrintColumnList(PrintWriter Out, List<Column> Columns)
      {
        boolean First = true;
        for (Column C : Columns)
          {
            if (C == null)
              continue;
            if (First == true)
              First = false;
            else
              Out.print(", ");
            Out.print("\"" + C.getName() + "\"");
          }
        return First != true;
      }

    @Override
    public void genClassEnd(PrintWriter Out, GeneratorSession G)
    throws Exception
      {
      }
  }
