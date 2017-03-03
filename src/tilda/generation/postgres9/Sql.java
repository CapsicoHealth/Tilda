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
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.PostgreSQL;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.JoinType;
import tilda.enums.TimeSeriesType;
import tilda.generation.GeneratorSession;
import tilda.generation.helpers.TotalMess;
import tilda.generation.helpers.TableRankTracker;
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


    private static String getFKStatement(ForeignKey FK, Deque<TableRankTracker> TableStack)
      {
        List<Column> Columns1;
        List<Column> Columns2;

        Columns1 = FK._SrcColumnObjs;
        Columns2 = FK._DestObjectObj._PrimaryKey._ColumnObjs;

        StringBuilder Str = new StringBuilder();
        for (int i = 0; i < Columns1.size(); ++i)
          {
            if (Str.length() > 0)
              Str.append(" and ");
            Column C1 = Columns1.get(i);
            Column C2 = Columns2.get(i);
            TableRankTracker TI1 = TableRankTracker.getElementFromLast(TableStack, C1._ParentObject);
            TableRankTracker TI2 = TableRankTracker.getElementFromLast(TableStack, C2._ParentObject);
            if (TI2 == null)
              throw new Error("Cannot find referenced table " + C2._ParentObject.getFullName());
            Str.append(TI1.getFullName() + ".\"" + C1.getName()).append("\" = ").append(TI2.getFullName() + ".\"" + C2.getName() + "\"");
          }

        return Str.toString();
      }



    private String PrintBaseView(View V)
    throws Exception
      {
        List<TotalMess> FuckList = TotalMess.ScanView(V);

        StringBuilder Str = new StringBuilder();
        Str.append("-- " + TextUtil.EscapeSingleQuoteForSQL(V._Description) + "\n");
        Str.append("select ");
        if (V._DistinctOn != null)
          {
            Str.append("distinct on(");
            boolean First = true;
            for (ViewColumn VC : V._DistinctOn._ColumnObjs)
              {
                if (First == true)
                  First = false;
                else
                  Str.append(", ");
                if (VC._SameAs != null && VC._SameAsObj == null && VC._FrameworkGenerated == true)
                  Str.append(VC._SameAs);
                else
                  {
                    Str.append("\"").append(VC._Name).append("\"");
                  }
              }
            Str.append(")\n");
          }
        StringBuilder FromList = new StringBuilder();
        boolean hasAggregates = false;

        Map<String, TableRankTracker> TableMap = new HashMap<String, TableRankTracker>();
        Deque<TableRankTracker> TableStack = new ArrayDeque<TableRankTracker>();
        int columnCount = -1;
        boolean First = true;
        for (ViewColumn VC : V._ViewColumns)
          {
            ++columnCount;
            TableRankTracker TI = null;
            if (VC._SameAsObj != null && VC._SameAsObj._Mode == ColumnMode.CALCULATED)
              continue;
            if (VC._SameAs != null && VC._SameAsObj != null)
              {
                Object T = VC._SameAsObj._ParentObject;
                TI = TableRankTracker.getElementFromLast(TableStack, T);
                if (TI == null)
                  {
                    TableRankTracker MappedTI = TableMap.remove(T.getShortName());
                    TI = new TableRankTracker(T, MappedTI == null ? 1 : MappedTI._V + 1);
                    TableStack.add(TI);
                    TableMap.put(TI._N, TI);
                    if (TableMap.size() != 1)
                      {
                        ViewJoin VJ = V.getViewjoin(T.getBaseName());
                        if (VJ != null)
                          {
                            FromList.append("     " + JoinType.printJoinType(VJ._Join) + " " + VJ._ObjectObj.getShortName());
                            Query Q = VJ.getQuery(this);
                            if (Q == null)
                              throw new Exception("Cannot generate the view because an 'on' clause matching the active database '" + getName() + "' is not available.");
                            FromList.append(" on " + Q._Clause);
                            TableRankTracker TI2 = TableRankTracker.getElementFromLast(TableStack, VJ._ObjectObj);
                            if (TI2 == null)
                              {
                                throw new Exception("View " + V.getFullName() + " is using " + T.getShortName() + " but cannot find any any valid join definitions.");
                              }
                            for (int i = 2; i <= TI._V; ++i)
                              {
                                FromList.append("\n     " + JoinType.printJoinType(VC._Join) + " " + VJ._ObjectObj.getShortName());
                                FromList.append(" as " + getFullTableVar(VC._SameAsObj._ParentObject, TI._V));
                                FromList.append(" on " + Q._Clause);
                              }
                          }
                        else
                          {
                            // ForeignKey FK = TableRankTracker.getClosestFKTable(TableStack, T, V, columnCount);
                            ForeignKey FK = TotalMess.getClosestFKTable(FuckList, V, T, columnCount);
                            if (FK == null)
                              {
                                throw new Exception("View " + V.getFullName() + " is using " + T.getShortName() + " but cannot find any foreign keys in any tables used so far: " + TableRankTracker.PrintTableNames(TableStack));
                              }
                            else
                              {
                                if (TI._N.equalsIgnoreCase("PATIENTS.SCORE") == true)
                                  {
                                    LOG.debug("xxx");
                                  }
                                String JT = VC._Join != null ? JoinType.printJoinType(VC._Join)
                                : FK._DestObjectObj.getFullName().equals(T.getFullName()) == false || FK._SrcColumnObjs.get(0)._Nullable == true ? "left  join" : "inner join";
                                FromList.append("     " + JT + " " + TI._N + (TI._V == 1 ? " " : " as " + TI.getFullName()) + " on " + getFKStatement(FK, TableStack));
                              }
                          }
                      }
                    else
                      FromList.append(TI._N);
                    FromList.append("\n");
                  }
                else
                  {
                    if (TI != TableStack.peekLast())
                      do
                        {
                          TableStack.pollLast();
                        } while (TI != TableStack.peekLast());
                  }
              }
            if (VC._JoinOnly == false)
              {
                if (First == true)
                  {
                    if (V._Pivot != null && V._ViewColumns.size() > 3)
                      {
                        Str.append("(");
                      }
                    First = false;
                  }
                else
                  Str.append("\n     , ");
                if (PrintViewColumn(Str, VC, TI, V._Pivot != null && V._ViewColumns.size() > 3 && columnCount <= V._ViewColumns.size() - 3) == true)
                  hasAggregates = true;
                if (V._Pivot != null && V._ViewColumns.size() > 3 && columnCount == V._ViewColumns.size() - 3)
                  {
                    Str.append("\n       )::" + V.getShortName() + "_WT as _wt");
                  }
              }
          }

        Str.append("\n  from ").append(FromList);

        if (V._TimeSeries != null)
          {
            String Period = V._TimeSeries._Type == TimeSeriesType.DAILY ? "day"
            : V._TimeSeries._Type == TimeSeriesType.MONTHLY ? "month"
            : V._TimeSeries._Type == TimeSeriesType.QUARTERLY ? "quarter"
            : "year";

            int LookbackNum = V._TimeSeries._Type == TimeSeriesType.QUARTERLY ? V._TimeSeries._Lookback * 3 : V._TimeSeries._Lookback;
            String Lookback = V._TimeSeries._Type == TimeSeriesType.QUARTERLY ? (V._TimeSeries._Lookback * 3) + " month"
            : V._TimeSeries._Lookback + " " + Period;
            String Step = V._TimeSeries._Type == TimeSeriesType.QUARTERLY ? "3 month"
            : "1 " + Period;

//          Str.append("join (select * from generate_series(date_trunc('" + Period + "', current_date) - interval '" + Lookback + "', date_trunc('" + Period + "', current_date), '" + Step + "') as p\n");
            Str.append("join (select (date_trunc('"+Period+"', current_date - interval '"+Lookback+"') + (_t||' "+Period+"')::interval)::date as p from generate_series(0, "+LookbackNum+") as _t\n");

            if (V._TimeSeries._Join._RangeColEnd != null && V._TimeSeries._Join._RangeColEnd.isEmpty() == false)
              {
                // Gotta calculate if the range of the data fetched [s2, e2] overlaps with the range of the time series [s1, s2]
                // It's gotta be: S2 < e1 && E2 >= s1
                String s1 = "_TS.p";
                String e1 = "_TS.p + interval '" + Step + "'";
                String s2v;
                if (V._TimeSeries._Join._RangeColStart.size() == 1)
                  s2v = getFullColumnVar(V._TimeSeries._Join._RangeColStart.get(0));
                else
                  {
                    StringBuilder s = new StringBuilder();
                    for (int i = 0; i < V._TimeSeries._Join._RangeColStart.size() - 1; ++i)
                      {
                        s.append("coalesce(");
                        s.append(getFullColumnVar(V._TimeSeries._Join._RangeColStart.get(i)));
                        s.append(", ");
                      }
                    s.append(getFullColumnVar(V._TimeSeries._Join._RangeColStart.get(V._TimeSeries._Join._RangeColStart.size() - 1)));
                    for (int i = 0; i < V._TimeSeries._Join._RangeColStart.size() - 1; ++i)
                      {
                        s.append(")");
                      }
                    s2v = s.toString();
                  }
                String s2 = "date_trunc('" + Period + "', " + s2v + ")";

                String e2;
                if (V._TimeSeries._Join._RangeColEnd.size() == 1)
                  {
                    String e2v = getFullColumnVar(V._TimeSeries._Join._RangeColEnd.get(0));
                    e2 = e2v + " is null or date_trunc('" + Period + "', " + e2v + ") >= " + s1;
                  }
                else
                  {
                    StringBuilder s = new StringBuilder();
                    s.append("case");
                    for (int i = 0; i < V._TimeSeries._Join._RangeColEnd.size() - 1; ++i)
                      {
                        String e2v = getFullColumnVar(V._TimeSeries._Join._RangeColEnd.get(i));
                        s.append(" when " + e2v + " is not null then date_trunc('" + Period + "', " + e2v + ") >= " + s1);
                      }
                    String e2v = getFullColumnVar(V._TimeSeries._Join._RangeColEnd.get(V._TimeSeries._Join._RangeColEnd.size() - 1));
                    s.append(" else " + e2v + " is null or " + e2v + " >= " + s1);
                    s.append(" end");
                    e2 = s.toString();
                  }

                Str.append("     ) as _TS on " + s2 + " < " + e1 + "\n");
                Str.append("            and (" + e2 + ")\n");
              }
            else if (V._TimeSeries._Join._Range.length == 2)
              Str.append("     ) as _TS on date_trunc('" + Period + "', " + V._TimeSeries._Join._ObjectObj.getShortName() + ".\"" + V._TimeSeries._Join._Range[0] + "\") <= _TS.p\n");
            else
              Str.append("     ) as _TS on date_trunc('" + Period + "', " + V._TimeSeries._Join._ObjectObj.getShortName() + ".\"" + V._TimeSeries._Join._Range[0] + "\") = _TS.p\n");
          }

        if (V._SubQuery != null)
          {
            Query q = V._SubQuery.getQuery(this);
            if (q != null)
              {
                boolean NewLine = q._Clause.indexOf("\n") >= 0;
                Str.append(" where (");
                Str.append(NewLine == true ? q._Clause.replaceAll("\n", "\n        ") : q._Clause);
                Str.append(NewLine == true ? "\n       )" : ")");
              }
            Str.append("\n");
          }
        if (V._Pivot != null)
          {
            if (V._SubQuery == null)
              Str.append(" where ");
            else
              Str.append("   and ");
            if (V._Pivot._VC._SameAsObj.getType() == ColumnType.STRING)
              Str.append("trim(");
            Str.append(getFullColumnVar(V._Pivot._VC._SameAsObj));
            if (V._Pivot._VC._SameAsObj.getType() == ColumnType.STRING)
              Str.append(")");
            Str.append(" in (").append(PrintValueList(V._Pivot)).append(")\n");

          }

        if (hasAggregates == true)
          {
            if (V._Pivot != null)
              {
                Str.append("     group by 1, 2\n");
              }
            else
              {
                Str.append("     group by ");
                First = true;
                for (ViewColumn VC : V._ViewColumns)
                  if (VC != null && VC._Aggregate == null && VC._JoinOnly == false)
                    {
                      if (First == true)
                        First = false;
                      else
                        Str.append(", ");
                      if (VC._SameAsObj == null && VC._SameAs != null && VC._FrameworkGenerated == true)
                        {
                          Str.append(VC._SameAs);
                        }
                      else
                        {
                          Str.append(getFullColumnVar(VC._SameAsObj));
                        }
                    }
                Str.append("\n");
              }
          }
        if (V._Pivot != null)
          {
            Str.append("     order by 1, 2\n");
          }

        if (V._DistinctOn != null)
          {
            Str.append("order by ");
            First = true;
            for (ViewColumn VC : V._DistinctOn._ColumnObjs)
              {
                if (First == true)
                  First = false;
                else
                  Str.append(", ");
                if (VC._SameAs != null && VC._SameAsObj == null && VC._FrameworkGenerated == true)
                  Str.append(VC._SameAs);
                else
                  {
                    Str.append("\"").append(VC._Name).append("\"");
                  }
              }
            for (int i = 0; i < V._DistinctOn._OrderByObjs.size(); ++i)
              {
                Column C = V._DistinctOn._OrderByObjs.get(i);
                Str.append(", ").append(getFullColumnVar(C)).append(" ").append(V._DistinctOn._OrderByOrders.get(i).name());
              }
            Str.append("\n");
          }


        return Str.toString();
      }

    private boolean PrintViewColumn(StringBuilder Str, ViewColumn VC, TableRankTracker TI, boolean NoAs)
      {
        boolean hasAggregates = false;
        if (VC._Aggregate == AggregateType.COUNT)
          {
            Str.append("count(*)");
            hasAggregates = true;
          }
        else if (VC._SameAs != null && VC._SameAsObj == null && VC._FrameworkGenerated == true)
          {
            Str.append(VC._SameAs);
          }
        else
          {
            boolean trimNeeded = VC._Aggregate == AggregateType.ARRAY && VC._SameAsObj.getType() == ColumnType.STRING
            || VC._ParentView._Pivot != null && VC._ParentView._Pivot._ColumnName.equals(VC._Name) == true;
            if (VC._Aggregate != null)
              {
                Str.append(getAggregateStr(VC._Aggregate) + "(");
                hasAggregates = true;
                if (VC._Distinct == Boolean.TRUE)
                  Str.append("distinct ");
              }
            if (trimNeeded)
              Str.append("trim(");
            Str.append(TI.getFullName()/* VC._SameAsObj._ParentObject.getShortName() + (TI._V == 1 ? "" : "_" + TI._V) */ + ".\"" + VC._SameAsObj.getName() + "\"");
            if (trimNeeded)
              Str.append(")");
            if (VC._Aggregate != null)
              {
                Str.append(")");
                if (TextUtil.isNullOrEmpty(VC._Filter) == false)
                  {
                    Str.append(" filter(where ").append(VC._Filter).append(")");
                  }
              }
          }
        if (NoAs == false)
          Str.append(" as \"" + VC.getName() + "\" " + (VC._SameAsObj == null ? "" : "-- " + VC._SameAsObj._Description));
        return hasAggregates;
      }



    @Override
    public String genDDL(PrintWriter OutFinal, View V)
    throws Exception
      {
        String Str = PrintBaseView(V);
        if (V._Pivot != null)
          {
            StringBuilder b = new StringBuilder();
            b.append("select unnest(ARRAY[").append(PrintValueList(V._Pivot)).append("]) as _x order by _x\n");
            // b.append("select distinct ").append(getFullColumnVar(V._Pivot._VC._SameAsObj)).append("\n")
            // .append(" from ").append(V._Pivot._VC._SameAsObj._ParentObject.getShortName()).append("\n")
            // .append(" where ").append(PivotIn(V._Pivot)).append("\n")
            // .append("order by ").append(getFullColumnVar(V._Pivot._VC._SameAsObj)).append("\n");
            StringBuilder SelectStr = new StringBuilder();
            if (V._Pivot != null && V._ViewColumns.size() > 3)
              {
                for (int i = 0; i < V._ViewColumns.size() - 2; ++i)
                  {
                    ViewColumn VC = V._ViewColumns.get(i);
                    if (VC._JoinOnly == true)
                      continue;
                    if (SelectStr.length() != 0)
                      SelectStr.append("\n     , ");
                    SelectStr.append("(_wt).\"" + VC._Name + "\"");
                  }
                for (Value v : V._Pivot._Values)
                  {
                    SelectStr.append("\n     , \"" + v._Name + "\"");
                  }
              }
            else
              SelectStr.append("*");

            Str = "select " + SelectStr.toString() + "\n from crosstab (\n" + TextUtil.EscapeSingleQuoteForSQL(Str) + ",\n"
            + TextUtil.EscapeSingleQuoteForSQL(b.toString()) + ")\n"
            + "as final_result (";
            if (V._Pivot != null && V._ViewColumns.size() > 3)
              {
                Str += "_wt " + V.getShortName() + "_WT";
              }
            else
              for (int i = 0; i < V._ViewColumns.size() - 2; ++i)
                {
                  ViewColumn VC = V._ViewColumns.get(i);
                  if (VC._SameAs.equals("_TS.p") == true)
                    {
                      if (i != 0)
                        Str += "  , ";
                      Str += "\"" + VC.getName() + "\" Date";
                    }
                  else if (VC != null && VC._SameAsObj._Mode != ColumnMode.CALCULATED && VC._JoinOnly == false)
                    {
                      if (i != 0)
                        Str += "  , ";
                      Str += "\"" + VC.getName() + "\" " + getColumnType(VC._SameAsObj);
                    }
                }
            for (int i = 0; i < V._Pivot._Values.length; ++i)
              {
                Str += ", \"" + TextUtil.Print(V._Pivot._Values[i]._Name, V._Pivot._Values[i]._Value) + "\" ";
                if (V._CountStar != null)
                  Str += "integer";
                else
                  Str += getColumnType(V._Pivot._VC._SameAsObj);
              }
            Str += ")\n";
          }
        if (V._Formulas != null && V._Formulas.isEmpty() == false)
          {
            StringBuilder b = new StringBuilder();
            b.append("select *\n");
            for (Formula F : V._Formulas)
              {
                if (F == null)
                  continue;
                String FormulaType = getColumnType(F.getType(), 8192, null, false);
                b.append("     -- ").append(String.join("\n     -- ", F._Description)).append("\n");
                b.append("     , (").append(genFormulaCode(V, F)).append(")::" + FormulaType + " as \"").append(F._Name).append("\"\n");
              }
            b.append("\n from (\n").append(Str).append("\n      ) as T");
            if (V._Realize != null)
              b.append("\n-- Realized as " + genRealizedColumnList(V) + "\n");
            Str = b.toString();
          }
        if (V._Pivot != null && V._ViewColumns.size() > 3)
          {
            OutFinal.println("DROP TYPE IF EXISTS " + V.getShortName() + "_WT cascade;");
            OutFinal.println("CREATE TYPE " + V.getShortName() + "_WT AS (");
            boolean First = true;
            for (int i = 0; i < V._ViewColumns.size() - 2; ++i)
              {
                ViewColumn VC = V._ViewColumns.get(i);
                if (VC._JoinOnly == true)
                  continue;
                if (First == true)
                  {
                    OutFinal.print("      ");
                    First = false;
                  }
                else
                  OutFinal.print("    , ");
                if (VC._SameAs.equals("_TS.p") == true)
                  OutFinal.println("\"p\" date");
                else
                  OutFinal.println("\"" + VC._Name + "\" " + getColumnType(VC._SameAsObj));
              }
            OutFinal.println("   );");
          }

        OutFinal.println("create or replace view " + V._ParentSchema._Name + "." + V._Name + " as ");
        OutFinal.println(Str + ";");
        OutFinal.println();
        OutFinal.println("COMMENT ON VIEW " + V._ParentSchema._Name + "." + V._Name + " IS E" + TextUtil.EscapeSingleQuoteForSQL(Str.replace("\r\n", "\\n").replace("\n", "\\n")) + ";");
        OutFinal.println();
        for (int i = 0; i < V._ViewColumns.size(); ++i)
          {
            ViewColumn VC = V._ViewColumns.get(i);
            if (V._Pivot != null)
              {
                if (VC == V._Pivot._VC // This is the pivot column
                || i == V._ViewColumns.size() - 1 // This is the last column (either count(*) or something else)
                // || VC._Aggregate == AggregateType.COUNT // This is the final count(*) column, so no comment
                )
                  continue; // no comment
              }
            if (VC != null && VC._SameAsObj != null && VC._SameAsObj._Mode != ColumnMode.CALCULATED && VC._JoinOnly == false)
              OutFinal.println("COMMENT ON COLUMN " + V.getShortName() + ".\"" + VC.getName() + "\" IS E" + TextUtil.EscapeSingleQuoteForSQL(VC._SameAsObj._Description) + ";");
          }
        if (V._Pivot != null)
          for (int i = 0; i < V._Pivot._Values.length; ++i)
            OutFinal.println("COMMENT ON COLUMN " + V.getShortName() + ".\"" + TextUtil.Print(V._Pivot._Values[i]._Name, V._Pivot._Values[i]._Value) + "\" IS E"
            + TextUtil.EscapeSingleQuoteForSQL("The pivoted column count from '" + V._Pivot._ColumnName + "'='" + V._Pivot._Values[i]._Value + "', " + V._Pivot._Values[i]._Description)
            + ";");
        if (V._Formulas != null)
          for (Formula F : V._Formulas)
            if (F != null)
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
            + "AS SELECT " + genRealizedColumnList(V) + " FROM " + V._ParentSchema._Name + "." + V._Name + ";\n")
            .append("  return true;\n")
            .append("END; $$\n")
            .append("LANGUAGE PLPGSQL;\n")
            .append("\n")
            .append("\n")
            .append("-- SELECT " + V._ParentSchema._Name + ".Refill_" + TName + "Realized();")
            .append("-- !!! THIS MAY TAKE SEVERAL MINUTES !!! --")
            .append("\n")
            .append("\n");
          }
        if (V._Formulas != null && V._Formulas.isEmpty() == false)
          {
            OutputFormulaInDBDocs(OutFinal, V);
          }

        return Str;
      }

    private String genFormulaCode(View ParentView, Formula F)
      {
        String FormulaStr = TextUtil.JoinTrim(F._FormulaStrs, " ");

        Matcher M = F._ViewColumnsRegEx.matcher(FormulaStr);
        StringBuffer Str = new StringBuffer();
        while (M.find() == true)
          {
            String s = M.group(1);
            if (FormulaStr.substring(M.start()).toLowerCase().matches("^\\s*is\\s+null") == true)
              {
                M.appendReplacement(Str, '"' + M.group(1) + '"');
                continue;
              }
            for (ViewColumn VC : ParentView._ViewColumns)
              if (s.equals(VC._Name) == true)
                {
                  ColumnType T = VC._SameAsObj.getType();
                  if (T == ColumnType.INTEGER || T == ColumnType.LONG || T == ColumnType.FLOAT || T == ColumnType.DOUBLE)
                    {
                      M.appendReplacement(Str, "coalesce(\"" + M.group(1) + "\", 0)");
                      break;
                    }
                  M.appendReplacement(Str, '"' + M.group(1) + '"');
                  break;
                }
          }
        M.appendTail(Str);
        FormulaStr = Str.toString();

        // Resolve sub-formulas
        M = F._FormulasRegEx.matcher(FormulaStr);
        Str.setLength(0);
        while (M.find() == true)
          {
            String s = M.group(1);
            for (Formula F2 : ParentView._Formulas)
              if (s.equals(F2._Name) == true && s.equals(F._Name) == false)
                {
                  String FormulaType = getColumnType(F2.getType(), F2._Size, null, false);
                  M.appendReplacement(Str, "(" + genFormulaCode(ParentView, F2) + ")::" + FormulaType);
                  break;
                }
          }
        M.appendTail(Str);

        return Str.toString();
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
            if (F == null)
              continue;
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
        Out.println("DELETE FROM " + V._ParentSchema._Name + ".TildaFormulaValue where \"viewName\"=" + TextUtil.EscapeSingleQuoteForSQL(V._Name) + ";");
        Out.println("DELETE FROM " + V._ParentSchema._Name + ".TildaFormulaReference where \"viewName\"=" + TextUtil.EscapeSingleQuoteForSQL(V._Name) + ";");
        Out.println("DELETE FROM " + V._ParentSchema._Name + ".TildaFormula where \"viewName\"=" + TextUtil.EscapeSingleQuoteForSQL(V._Name) + ";");

        String RealizedTable = V._Realize == null ? null : V._Name.substring(0, V._Name.length() - (V._Pivot != null ? "PivotView" : "View").length()) + "Realized";
        int count = -1;
        for (Formula F : V._Formulas)
          {
            if (F == null)
              continue;

            if (++count == 0)
              {
                Out.println("INSERT INTO " + V._ParentSchema._Name + ".TildaFormula (\"viewName\", \"realizedTableName\", \"name\", \"title\", \"description\", \"formula\", \"html\", \"created\", \"lastUpdated\")");
                Out.print("    VALUES (");
              }
            else
              {
                Out.print("          ,(");
              }
            Out.print(TextUtil.EscapeSingleQuoteForSQL(V._Name));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(RealizedTable));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(F._Name));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(F._Title));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(String.join("\n", F._Description)));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(String.join("\n", F._FormulaStrs)));
            Out.print(", " + TextUtil.EscapeSingleQuoteForSQL("<B>THIS <U>IS</U> ONLY A TEST <I>HTML</I> FRAGMENT!"));
            Out.println(", current_timestamp, current_timestamp)");
          }
        if (count >= 0)
          Out.println("   ;");

        count = -1;
        for (Formula F : V._Formulas)
          {
            if (F != null && F._Values != null && F._Values.length > 0)
              for (Value Val : F._Values)
                {
                  if (++count == 0)
                    {
                      Out.println("INSERT INTO " + V._ParentSchema._Name + ".TildaFormulaValue (\"viewName\", \"formulaName\", \"value\", \"description\", \"created\", \"lastUpdated\")");
                      Out.print("    VALUES (");
                    }
                  else
                    {
                      Out.print("          ,(");
                    }
                  Out.print(TextUtil.EscapeSingleQuoteForSQL(V._Name));
                  Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(F._Name));
                  Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(Val._Value));
                  Out.print(", " + TextUtil.EscapeSingleQuoteForSQL(Val._Description));
                  Out.println(", current_timestamp, current_timestamp)");
                }
          }
        if (count >= 0)
          Out.println("   ;");

        count = -1;
        for (Formula F : V._Formulas)
          {
            if (F == null)
              continue;
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
                    if (++count == 0)
                      {
                        Out.println("INSERT INTO " + V._ParentSchema._Name + ".TildaFormulaReference (\"viewName\", \"formulaName\", \"referenceName\", \"referenceType\", \"description\", \"created\", \"lastUpdated\")");
                        Out.print("    VALUES (");
                      }
                    else
                      {
                        Out.print("          ,(");
                      }
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
                      if (++count == 0)
                        {
                          Out.println("INSERT INTO " + V._ParentSchema._Name + ".TildaFormulaReference (\"viewName\", \"formulaName\", \"referenceName\", \"referenceType\", \"description\", \"created\", \"lastUpdated\")");
                          Out.print("    VALUES (");
                        }
                      else
                        {
                          Out.print("          ,(");
                        }
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
        if (count >= 0)
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
                // LOG.debug(" . Checking FK " + FK._ParentObject.getBaseName() + " to " + FK._DestObjectObj.getBaseName());
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
