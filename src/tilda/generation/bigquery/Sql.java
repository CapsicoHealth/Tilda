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

package tilda.generation.bigquery;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;

import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.BigQuery;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
import tilda.enums.JoinType;
import tilda.enums.TimeSeriesType;
import tilda.generation.GeneratorSession;
import tilda.generation.helpers.TableRankTracker;
import tilda.generation.helpers.TotalMess;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Formula;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.OrderBy;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.parsing.parts.ViewJoin;
import tilda.parsing.parts.ViewPivot;
import tilda.parsing.parts.ViewRealizeIncremental;
import tilda.parsing.parts.helpers.PivotHelper;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.utils.PaddingTracker;
import tilda.utils.PaddingUtil;
import tilda.utils.TextUtil;

public class Sql extends BigQuery implements CodeGenSql
  {
    protected static final Logger LOG = LogManager.getLogger(Sql.class.getName());

    @Override
    public String getFileName(Base O)
      {
        return "TILDA___Schema" + "." + O.getSchema()._Name + "." + getName() + ".sql";
      }



    @Override
    public boolean stringNeedsTrim(Column C)
      {
        return C.getType() == ColumnType.STRING && C._Mode != ColumnMode.CALCULATED && C.isCollection() == false && (C._Size != null && getDBStringType(C._Size) == DBStringType.CHARACTER);
      }

    @Override
    public boolean stringArrayAggNeedsText(ViewColumn VC)
      {
        // We only test for VARCHAR here because we know that CHAR is getting trimmed, which results in TEXT type already.
        return stringNeedsTrim(VC._SameAsObj) == false
        && VC._SameAsObj.getType() == ColumnType.STRING && VC._SameAsObj._Mode != ColumnMode.CALCULATED && VC._SameAsObj.isCollection() == false
        && getDBStringType(VC._SameAsObj._Size) == DBStringType.VARCHAR // is a varchar
        && VC._Aggregate == AggregateType.ARRAY // is an array_agg aggregate that needs to be converted to text[] for operators.
        ;
      }


    @Override
    public String getBaseSelectStatement(List<Column> Columns)
      {
        // TODO Auto-generated method stub
        return null;
      }


    @Override
    public String getEqualCurentTimestamp()
      {
        return "= "+getCurrentTimestampStr();
      }
    @Override
    public String getEqualCurentDateTime()
      {
        return "= "+getCurrentDateTimeStr();
      }

    @Override
    public String getCommaCurentTimestamp()
      {
        return ", "+getCurrentTimestampStr();
      }
    @Override
    public String getCommaCurentDateTime()
      {
        return ", "+getCurrentDateTimeStr();
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
    throws Exception
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
              Out.print(getShortColumnVar(C)+ O._PadderColumnNames.getPad(C.getName()) + "  " + PadderColumnTypes.pad(getColumnType(C)));
              if (C._DefaultCreateValue != null)
                Out.print(" DEFAULT " + ValueHelper.printValueSQL(getSQlCodeGen(), C.getName(), C.getType(), C.isCollection(), C._DefaultCreateValue._Value));
              Out.print(C._Nullable == false ? "  not null" : "          ");
              Out.println("  OPTIONS(description=" + TextUtil.escapeDoubleQuoteWithSlash(C._Description)+")");
            }
        if (O._PrimaryKey != null)
          {
            Out.print("  , PRIMARY KEY(");
            PrintColumnList(Out, O._PrimaryKey._ColumnObjs);
            Out.println(") NOT ENFORCED");
          }
        if (O._ForeignKeys != null)
          for (ForeignKey FK : O._ForeignKeys)
            if (FK != null)
              {
                Out.print("  , FOREIGN KEY (");
                PrintColumnList(Out, FK._SrcColumnObjs);
                Out.print(") REFERENCES " + FK._DestObjectObj._ParentSchema._Name + "." + FK._DestObjectObj._Name+"(");
                PrintColumnList(Out, FK._DestObjectObj._PrimaryKey._ColumnObjs);
                Out.println(") NOT ENFORCED");
              }
        Out.println(" )");
        Out.println("OPTIONS (description=" + TextUtil.escapeDoubleQuoteWithSlash(O._Description)+");");
      }


    private String getFKStatement(ForeignKey FK, Deque<TableRankTracker> TableStack)
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
            TableRankTracker TI1 = TableRankTracker.getElementFromLast(TableStack, C1._ParentObject, null);
            TableRankTracker TI2 = TableRankTracker.getElementFromLast(TableStack, C2._ParentObject, null);
            if (TI1 == null)
              throw new Error("Cannot find source table " + C1._ParentObject.getFullName());
            if (TI2 == null)
              throw new Error("Cannot find referenced table " + C2._ParentObject.getFullName());
            Str.append(TI1.getFullName() + "." + getShortColumnVar(C1.getName())).append(" = ").append(TI2.getFullName() + "." + getShortColumnVar(C2.getName()));
          }

        return Str.toString();
      }

    private String PrintBaseView(View V, boolean OmmitTZs)
    throws Exception
      {
        List<TotalMess> FuckList = TotalMess.ScanView(V); // Sorry for the expletives here, but this code is really messed up in very impolite ways!!!

        StringBuilder Str = new StringBuilder();
        Str.append("-- " + TextUtil.escapeSingleQuoteForSQL(V._Description) + "\n");
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
                if (VC.isSameAsLitteral() == true)
                  Str.append(VC._SameAs);
                else
                  {
                    Str.append(getShortColumnVar(VC._Name));
                  }
              }
            Str.append(")\n       ");
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
                TI = TableRankTracker.getElementFromLast(TableStack, T, VC._As);
                if (TI == null)
                  {
                    TableRankTracker MappedTI = TableMap.remove(T.getShortName());
                    TI = new TableRankTracker(T, MappedTI == null ? 1 : MappedTI._V + 1, VC._As);
                    TableStack.add(TI);
                    TableMap.put(TI._N, TI);
                    if (TableMap.size() != 1)
                      {
                        ViewJoin VJ = V.getViewjoin(T.getBaseName(), VC._As);
                        if (VJ != null)
                          {
                            Query Q = genViewJoin(FromList, VJ);
                            TableRankTracker TI2 = TableRankTracker.getElementFromLast(TableStack, VJ._ObjectObj, VJ._As);
                            if (TI2 == null)
                              {
                                throw new Exception("View " + V.getFullName() + " is using " + T.getShortName() + " but cannot find any any valid join definitions.");
                              }
                            if (TextUtil.isNullOrEmpty(VC._As) == true)
                              for (int i = 2; i <= TI._V; ++i)
                                {
                                  FromList.append("\n     " + JoinType.printJoinType(VC._Join) + " " + VJ._ObjectObj.getShortName());
                                  FromList.append(" as " + getFullTableVar(VC._SameAsObj._ParentObject, TI._V));
                                  FromList.append(" on " + rewriteExpressionColumnQuoting(Q._ClauseStatic));
                                }
                          }
                        else
                          {
                            // ForeignKey FK = TableRankTracker.getClosestFKTable(TableStack, T, V, columnCount);
                            ForeignKey FK = TotalMess.getClosestFKTable(FuckList, V, T, columnCount);
                            if (FK == null)
                              {
                                throw new Exception("View " + V.getFullName() + " is using " + T.getShortName() + " but cannot find any foreign keys in any tables used so far (or found multiple ones, causing ambiguity): " + TableRankTracker.PrintTableNames(TableStack));
                              }
                            else
                              {
                                String JT = VC._Join != null ? JoinType.printJoinType(VC._Join)
                                : FK._DestObjectObj.getFullName().equals(T.getFullName()) == false || FK._SrcColumnObjs.get(0)._Nullable == true ? "left  join" : "inner join";
                                FromList.append("     " + JT + " " + TI._N);
                                if (TI._V > 1 || TextUtil.isNullOrEmpty(TI._As) == false)
                                  FromList.append(" as " + TI.getFullName());
                                FromList.append(" on " + getFKStatement(FK, TableStack));
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

            // LDH-NOTE: Cannot remember why OmitTZs was created, but it prevents the time-series field "p" from getting output properly.
            // For now, we hard-code that field so it gets output.
            if (VC._JoinOnly == false && (VC._SameAs.equals("_TS.p") == true || OmmitTZs == false || OmmitTZs == true && VC._SameAsObj != null && VC._SameAsObj._Mode == ColumnMode.NORMAL))
              {
                if (First == true)
                  First = false;
                else
                  Str.append("\n     , ");
                if (PrintViewColumn(Str, VC, TI, false) == true) // V._Pivot != null && V._ViewColumns.size() > 3 && columnCount <= V._ViewColumns.size() - 3) == true)
                  hasAggregates = true;
              }
          }

        Str.append("\n  from ").append(FromList);

        if (V._TimeSeries != null)
          {
            String Period = V._TimeSeries._Type == TimeSeriesType.DAILY ? "day"
            : V._TimeSeries._Type == TimeSeriesType.MONTHLY ? "month"
            : V._TimeSeries._Type == TimeSeriesType.QUARTERLY ? "quarter"
            : "year";

            String LookbackNum = V._TimeSeries._Between != null
            ? ("Tilda." + Period + "sBetween('" + V._TimeSeries._Between[0] + "', " + (V._TimeSeries._Between[1] == null ? "current_date" : ("'" + V._TimeSeries._Between[1] + "'")) + ")::integer+1")
            : ("" + (V._TimeSeries._Type == TimeSeriesType.QUARTERLY ? V._TimeSeries._Lookback * 3 : V._TimeSeries._Lookback));
            String Lookback = V._TimeSeries._Between != null
            ? ("'" + V._TimeSeries._Between[0] + "'::date")
            : (" current_date - interval '"
            + (V._TimeSeries._Type == TimeSeriesType.QUARTERLY ? (V._TimeSeries._Lookback * 3) + " month"
            : V._TimeSeries._Lookback + " " + Period) + "'");
            String Step = V._TimeSeries._Type == TimeSeriesType.QUARTERLY ? "3 month" : "1 " + Period;

            // Str.append("join (select * from generate_series(date_trunc('" + Period + "', current_date) - interval '" + Lookback + "', date_trunc('" + Period + "', current_date),
            // '" + Step + "') as p\n");
            Str.append("join (select (date_trunc('" + Period + "'," + Lookback + ") + (_t||' " + Period + "')::interval)::date as p from generate_series(0, " + LookbackNum + ") as _t\n");

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
              Str.append("     ) as _TS on date_trunc('" + Period + "', " + V._TimeSeries._Join._ObjectObj.getShortName() + "." + getShortColumnVar(V._TimeSeries._Join._Range[0]) + ") <= _TS.p\n");
            else
              Str.append("     ) as _TS on date_trunc('" + Period + "', " + V._TimeSeries._Join._ObjectObj.getShortName() + "." + getShortColumnVar(V._TimeSeries._Join._Range[0]) + ") = _TS.p\n");
          }

        if (V._SubQuery != null)
          {
            Query q = V._SubQuery.getQuery(this);
            if (q != null)
              {
                boolean NewLine = q._ClauseStatic.indexOf("\n") >= 0;
                Str.append(" where (");
                Str.append(rewriteExpressionColumnQuoting(NewLine == true ? q._ClauseStatic.replaceAll("\n", "\n        ") : q._ClauseStatic));
                Str.append(NewLine == true ? "\n       )" : ")");
              }
            Str.append("\n");
          }
        if (V._Pivots.isEmpty() == false)
          {
            if (V._SubQuery == null)
              Str.append(" where ");
            else
              Str.append("   and ( ");
            for (ViewPivot P : V._Pivots)
              if (P != null)
                {
                  if (P != V._Pivots.get(0))
                    Str.append("        or ");
                  Str.append(getFullColumnVar(P._VC._SameAsObj));
                  Str.append(" in (").append(PrintValueList(P)).append(")\n");
                }
            if (V._SubQuery != null)
              Str.append("       )\n");
          }

        if (hasAggregates == true)
          {
            if (V._Pivots.isEmpty() == false)
              {
                Str.append(" group by ");
                int count = 0;
                for (int i = 0; i < V._ViewColumns.size(); ++i)
                  {
                    ViewColumn VC = V._ViewColumns.get(i);
                    if (VC._Aggregate != null)
                      break;
                    if (VC._JoinOnly == false)
                      {
                        if (count > 0)
                          Str.append(", ");
                        Str.append(++count);
                      }
                  }
                Str.append("\n");
              }
            else
              {
                int count = 0;
                for (ViewColumn VC : V._ViewColumns)
                  if (VC != null && VC._Aggregate == null && VC._JoinOnly == false/* && VC._FormulaOnly == false */) // base view must have the "blocked" columns
                    {
                      Str.append(count == 0 ? "     group by " : ", ");
                      Str.append(++count);
                    }
                if (First == false)
                  Str.append("\n");
              }
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
                if (VC.isSameAsLitteral() == true)
                  Str.append(VC._SameAs);
                else
                  {
                    Str.append(getShortColumnVar(VC._Name));
                  }
              }
            for (OrderBy OB : V._DistinctOn._OrderByObjs)
              {
                Str.append(", ").append(getFullColumnVar(OB._Col)).append(" ").append(OB._Order.name());
                if (OB._Nulls != null)
                  Str.append(" NULLS ").append(OB._Nulls.name());
              }
            Str.append("\n");
          }


        return Str.toString();
      }

    @Override
    public Query genViewJoin(StringBuilder Str, ViewJoin VJ)
    throws Exception
      {
        Str.append("     " + JoinType.printJoinType(VJ._Join) + " " + VJ._ObjectObj.getShortName());
        if (TextUtil.isNullOrEmpty(VJ._As) == false)
          Str.append(" as " + VJ._ObjectObj.getShortName().replace(".", "_") + VJ._As);
        Query Q = VJ.getQuery(this);
        if (Q == null)
          throw new Exception("Cannot generate the view because an 'on' clause matching the active database '" + this.getName() + "' is not available.");
        Str.append(" on " + rewriteExpressionColumnQuoting(Q._ClauseStatic));
        return Q;
      }

    private boolean PrintViewColumn(StringBuilder Str, ViewColumn VC, TableRankTracker TI, boolean NoAs)
    throws Exception
      {
        if (TextUtil.isNullOrEmpty(VC._Coalesce) == false && (VC._Aggregate == null || VC._Aggregate == AggregateType.COUNT))
          Str.append("coalesce(");

        boolean hasAggregates = false;
        // If the column has a sameAs string, but no sameAsObj and is managed, then we print the sameAs as is.
        if (VC.isSameAsLitteral() == true)
          {
            Str.append(TextUtil.isNullOrEmpty(VC._Expression) == true ? VC._SameAs : rewriteExpressionColumnQuoting(VC._Expression.replaceAll("\\?", VC._SameAs)));
          }
        else
          {
            boolean trimNeeded = stringNeedsTrim(VC._SameAsObj); // || VC._ParentView.getPivotWithColumn(VC._Name) != null;
            boolean textConversionNeeded = stringArrayAggNeedsText(VC);
            if (VC._Aggregate != null)
              {
                Str.append(getAggregateStr(VC._Aggregate) + "(");
                hasAggregates = true;
                if (VC._Distinct == Boolean.TRUE)
                  Str.append("distinct ");

                if (TextUtil.isNullOrEmpty(VC._Coalesce) == false && VC._Aggregate != AggregateType.COUNT)
                  Str.append("coalesce(");
              }
            if (trimNeeded)
              Str.append("trim(");
            String ColExpr = VC._Aggregate != null && VC._Aggregate.isWindowOnly() == true ? "" : (textConversionNeeded ? "CAST(" : "") + TI.getFullName() + "." + getShortColumnVar(VC._SameAsObj.getName()) + (textConversionNeeded ? " AS STRING)" : "");
            if (TextUtil.isNullOrEmpty(VC._Expression) == false)
              ColExpr = rewriteExpressionColumnQuoting(VC._Expression.replaceAll("\\?", ColExpr));
            boolean filteredAggregate = VC._Aggregate != null &&  TextUtil.isNullOrEmpty(VC._Filter) == false;
            if (filteredAggregate == true && supportsFilterClause() == false)
             Str.append("case when ").append(rewriteExpressionColumnQuoting(VC._Filter)).append(" then ");
            Str.append(ColExpr);
            if (filteredAggregate == true && supportsFilterClause() == false)
              Str.append(" else null end");
            if (trimNeeded)
              Str.append(")");
            if (VC._Aggregate != null)
              {
                if (TextUtil.isNullOrEmpty(VC._Coalesce) == false && VC._Aggregate != AggregateType.COUNT)
                  Str.append(", " + ValueHelper.printValueSQL(getSQlCodeGen(), VC._SameAsObj.getName(), VC.getType(), VC.isCollection(), VC._Coalesce) + ")");

                // We have to be able to handle cases for joins with an "as". If so, we have to use that, otherwise
                // we have to use the internal source of the column being ordered by.
                if (TextUtil.isNullOrEmpty(VC._AggregateAttributes) == false)
                  Str.append(", ").append(VC._AggregateAttributes);
                if (VC._partitionByObjs.size() != 0 || TextUtil.isNullOrEmpty(VC._Range) == false || VC._Aggregate.isWindowOnly() == true)
                  Str.append(") OVER (");
                printAggregatePartitionBy(Str, VC._partitionByObjs, TextUtil.isNullOrEmpty(TI._As) == false ? TI.getFullName() : null);
                printAggregateOrderBy(Str, VC._OrderByObjs, TextUtil.isNullOrEmpty(TI._As) == false ? TI.getFullName() : null, VC._Range);
                Str.append(")");
                if (TextUtil.isNullOrEmpty(VC._Filter) == false && supportsFilterClause() == true)
                  {
                    Str.append(" filter(where ").append(rewriteExpressionColumnQuoting(VC._Filter)).append(")");
                  }
              }
          }

        if (TextUtil.isNullOrEmpty(VC._Coalesce) == false && (VC._Aggregate == null || VC._Aggregate == AggregateType.COUNT))
          Str.append(", " + ValueHelper.printValueSQL(getSQlCodeGen(), VC._SameAsObj.getName(), VC.getType(), VC.isCollection(), VC._Coalesce) + ")");
        if (NoAs == false)
          Str.append(" as " + getShortColumnVar(VC.getName()) + " " + (VC._SameAsObj == null ? "" : "-- " + (TextUtil.isNullOrEmpty(VC._Description) == false ? VC._Description : VC._SameAsObj._Description)));
        if (VC._FormulaOnly == true)
          Str.append(" -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)");
        return hasAggregates;
      }

    protected void printAggregateOrderBy(StringBuilder str, List<OrderBy> orderByObjs, String objectFullName, String range)
      {
        if (orderByObjs != null && orderByObjs.isEmpty() == false)
          {
            str.append(" order by ");
            boolean First = true;
            for (OrderBy OB : orderByObjs)
              {
                if (First == true)
                  First = false;
                else
                  str.append(", ");
                str.append((TextUtil.isNullOrEmpty(objectFullName) == false ? objectFullName : OB._Col._ParentObject.getShortName()) + "." + getShortColumnVar(OB._Col.getName()) + " " + OB._Order);
                if (OB._Nulls != null)
                  str.append(" NULLS " + OB._Nulls);
              }
            if (TextUtil.isNullOrEmpty(range) == false)
              str.append(" rows between ").append(range);
          }
      }

    protected void printAggregatePartitionBy(StringBuilder str, List<Column> partitionByObjs, String objectFullName)
      {
        if (partitionByObjs != null && partitionByObjs.isEmpty() == false)
          {
            str.append(" partition by ");
            boolean First = true;
            for (Column col : partitionByObjs)
              {
                if (First == true)
                  First = false;
                else
                  str.append(", ");
                str.append((TextUtil.isNullOrEmpty(objectFullName) == false ? objectFullName : col._ParentObject.getShortName()) + "." + getShortColumnVar(col.getName()) + "");
              }
          }
      }

    @Override
    public void genDDL(PrintWriter OutFinal, View V)
    throws Exception
      {
        String Str = PrintBaseView(V, false);
        if (V._Pivots.isEmpty() == false)
          {
            Str = PivotGenericWay(V, Str);
          }
        if (V._Formulas != null && V._Formulas.isEmpty() == false)
          {
            Str = DoFormulasSuperView(V, Str, false);
          }
        OutFinal.println("-- " + getDDLMetadataVersion());
        OutFinal.println("create or replace view " + V._ParentSchema._Name + "." + V._Name + " as ");
        OutFinal.println(Str + ";\n");
        Set<View> SubRealizedViews = V.getSubRealizedViewRootNames();
        Set<View> AncestorRealizedViews = V.getAncestorRealizedViews();

        if (SubRealizedViews != null || AncestorRealizedViews != null) // View depends on realized views.
          {
            if (SubRealizedViews != null)
              {
                StringBuilder r = new StringBuilder();
                for (View srv : SubRealizedViews)
                  {
                    r.setLength(0);
                    r.append("(?i)\\b((");
                    r.append(srv._ParentSchema._Name.toUpperCase());
                    r.append("\\.)?");
                    r.append(srv.getRootViewName().toUpperCase());
                    // r.append(")(PIVOT)?VIEW\\b");
                    r.append(srv._Pivots == null || srv._Pivots.isEmpty() == true ? ")VIEW\\b" : ")PIVOTVIEW\\b");
                    Str = Str.replaceAll(r.toString(), srv._RealizedObj != null ? srv._RealizedObj._ParentSchema._Name + "." + srv._RealizedObj._Name : "$1Realized");
                  }
              }

            if (AncestorRealizedViews != null)
              for (View arv : AncestorRealizedViews)
                {
                  String regex = "(?i)\\b(" + arv.getShortName().replace(".", "\\.)?") + "\\b";
                  Str = Str.replaceAll(regex, arv.getViewSubRealizeFullName());
                }

            OutFinal.println("create or replace view " + V.getViewSubRealizeFullName() + " as ");
            OutFinal.println(Str + ";\n");
          }
        if (V._Realize != null)
          {
            OutFinal.println();
            String TName = V.getRealizedTableName(false);
            String RName = V.getRealizedTableName(true);
            ViewRealizeIncremental VRI = V._Realize._Incremental;

            if (VRI != null)
              {
                OutFinal.append("DROP FUNCTION IF EXISTS " + V._ParentSchema._Name + ".Refill_" + TName + "(__startDate__ DATE);\n")
                .append("CREATE OR REPLACE FUNCTION " + V._ParentSchema._Name + ".Refill_" + TName + "(__startDate__ DATE)\n");
              }
            else
              {
                OutFinal.append("DROP FUNCTION IF EXISTS " + V._ParentSchema._Name + ".Refill_" + TName + "();\n")
                .append("CREATE OR REPLACE FUNCTION " + V._ParentSchema._Name + ".Refill_" + TName + "()\n");
              }
            OutFinal.append(" RETURNS boolean AS $$\n")
            .append("declare\n")
            .append("  startDt        timestamptz;\n")
            .append("  insertStartDt  timestamptz;\n")
            .append("  insertEndDt    timestamptz;\n")
            .append("  deleteStartDt  timestamptz;\n")
            .append("  deleteEndDt    timestamptz;\n")
            .append("  analyzeStartDt timestamptz;\n")
            .append("  analyzeEndDt   timestamptz;\n")
            .append("  endDt          timestamptz;\n")
            .append("  insertRowCount bigint;\n")
            .append("  deleteRowCount bigint;\n")
            .append("BEGIN\n")
            .append("  startDt:= clock_timestamp();\n");

            StringWriter BaseLineInsert = new StringWriter();
            BaseLineInsert.append("  INSERT INTO " + RName + " (" + PrintInsertColumnNames(V) + ")\n     ");
            BaseLineInsert.append("SELECT ").append(genRealizedColumnList(V, "\n          "));

            if (SubRealizedViews != null || AncestorRealizedViews != null) // View depends on realized views.
              BaseLineInsert.append("\n     FROM " + V.getViewSubRealizeFullName());
            else
              BaseLineInsert.append("\n     FROM ").append(V._ParentSchema._Name).append(".").append(V._Name);

            if (VRI != null)
              {
                OutFinal.append("\n");
                OutFinal.append("  IF __startDate__ is null or __startDate__='1111-11-11'\n");
                OutFinal.append("  THEN\n");
                OutFinal.append("\n");
              }
            OutFinal.append("  TRUNCATE ").append(RName).append(";\n")
            .append("  insertStartDt:= clock_timestamp();\n");
            OutFinal.append(BaseLineInsert.toString());

            String vriWhereclause = resolveIncrementalWhereClause(V);
            // if (VRI != null)
            // OutFinal.append("\n WHERE " + vriWhereclause + "\n");
            OutFinal.append(";\n")
            .append("  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n")
            .append("  insertEndDt:= clock_timestamp();\n");
            if (VRI != null)
              {
                OutFinal.append("\n");
                OutFinal.append("  ELSE\n");
                OutFinal.append("\n");
                if (VRI._deleteFirst == true)
                  {
                    OutFinal.append("  deleteStartDt:= clock_timestamp();\n");
                    OutFinal.append("  delete from " + RName + " where " + vriWhereclause + ";\n");
                    OutFinal.append("  GET DIAGNOSTICS deleteRowCount = ROW_COUNT;\n");
                    OutFinal.append("  deleteEndDt:= clock_timestamp();\n");
                  }
                OutFinal.append("  insertStartDt:= clock_timestamp();\n");
                OutFinal.append(BaseLineInsert.toString());
                OutFinal.append("\n    WHERE " + vriWhereclause);

                // We used to not add the ON CONFLICT clause if _deleteFirst is true. This can cause some issues
                // because most of the time, one would delete with a "lastUpdated" timestamp. This means that it's
                // easy to have an object from let's say March 10th, and you run a refill on April 10th with a 10-day
                // lookback, essentially, the delete clause won't clear the object, and the insert will fail with
                // a duplicate key for sure.
                OutFinal.append("\n  ON CONFLICT (");
                boolean First = true;
                for (ViewColumn VC : VRI._IdentityViewColumns)
                  {
                    if (First == true)
                      First = false;
                    else
                      OutFinal.append(", ");
                    OutFinal.append(getShortColumnVar(VC._Name));
                  }
                OutFinal.append(")");
                OutFinal.append("  DO UPDATE SET\n");
                First = true;
                for (String ColNames : V._Realize._ParentRealized.getColumnNames())
                  {
                    OutFinal.append("    ");
                    if (First == true)
                      First = false;
                    else
                      OutFinal.append(",");
                    OutFinal.append(getShortColumnVar(ColNames)).append(" = EXCLUDED.").append(getShortColumnVar(ColNames)).append("\n");
                  }
                OutFinal.append("  ;\n");
                OutFinal.append("  GET DIAGNOSTICS insertRowCount = ROW_COUNT;\n");
                OutFinal.append("  insertEndDt:= clock_timestamp();\n");
                OutFinal.append("\n");
                OutFinal.append("  END IF;\n");
                OutFinal.append("\n");
              }

            OutFinal.append("  analyzeStartDt:= clock_timestamp();\n");
            OutFinal.append("  ANALYZE " + RName + ";\n");
            OutFinal.append("  analyzeEndDt:= clock_timestamp ( );\n");
            OutFinal.append("  endDt:= clock_timestamp();\n"); // technically, could have used analyzeEndDt, but this is clearer.
            OutFinal.append("\n");
            if (VRI != null)
              {
                OutFinal.append("  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startDateIncr, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)\n");
                OutFinal.append("                        VALUES('" + V._ParentSchema._Name + "', '" + TName + "', __startDate__, 'UTC', startDt, 'UTC', endDt\n");
              }
            else
              {
                OutFinal.append("  INSERT INTO TILDA.RefillPerf(schemaName, objectName, startTimeTZ, startTime, endTimeTZ, endTime, timeInsertSec, timeDeleteSec, timeAnalyzeSec, timeTotalSec, insertCount, deleteCount)\n");
                OutFinal.append("                        VALUES('" + V._ParentSchema._Name + "', '" + TName + "', 'UTC', startDt, 'UTC', endDt\n");
              }
            OutFinal.append("                                         , COALESCE(EXTRACT(EPOCH FROM insertEndDt-insertStartDt), 0)\n");
            OutFinal.append("                                         , COALESCE(EXTRACT(EPOCH FROM deleteEndDt-deleteStartDt), 0)\n");
            OutFinal.append("                                         , COALESCE(EXTRACT(EPOCH FROM analyzeEndDt-analyzeStartDt), 0)\n");
            OutFinal.append("                                         , COALESCE(EXTRACT(EPOCH FROM endDt-startDt), 0)\n");
            OutFinal.append("                                         , COALESCE(insertRowCount, 0)\n");
            OutFinal.append("                                         , COALESCE(deleteRowCount, 0));\n");
            OutFinal.append("  return true;\n");
            OutFinal.append("END; $$\n");
            OutFinal.append("LANGUAGE PLPGSQL;\n");
            OutFinal.append("\n");
            if (VRI != null)
              {
                OutFinal.append("DROP FUNCTION IF EXISTS " + V._ParentSchema._Name + ".Refill_" + TName + "();\n")
                .append("CREATE OR REPLACE FUNCTION " + V._ParentSchema._Name + ".Refill_" + TName + "()\n");
                OutFinal.append(" RETURNS boolean AS $$\n")
                .append("BEGIN\n");
                OutFinal.append("  return " + V._ParentSchema._Name + ".Refill_" + TName + "(null);\n")
                .append("END; $$\n")
                .append("LANGUAGE PLPGSQL;\n")
                .append("\n");
              }
            OutFinal.append("-- SELECT " + V._ParentSchema._Name + ".Refill_" + TName + "(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n");
          }
      }

    private String resolveIncrementalWhereClause(View V)
      {
        if (V._Realize == null || V._Realize._Incremental == null)
          return null;

        String whereClause = V._Realize._Incremental._whereClause.replaceAll("\\$\\{START_DATE\\}", "__startDate__");
        Matcher M = V._ViewColumnsRegEx.matcher(whereClause);
        StringBuffer Str = new StringBuffer();
        while (M.find() == true)
          {
            String s = M.group(1);
            M.appendReplacement(Str, getShortColumnVar(s));
          }
        M.appendTail(Str);
        return Str.toString();
      }

    private String PrintInsertColumnNames(View V)
      {
        StringBuilder Str = new StringBuilder();
        boolean First = true;
        for (ViewColumn VC : V._ViewColumns)
          {
            if (VC._FormulaOnly == true)
              continue;
            if (VC._SameAsObj != null && VC._SameAsObj._Mode == ColumnMode.CALCULATED || VC._JoinOnly == true)
              continue;
            if (TextUtil.findStarElement(V._Realize._Exclude_DEPRECATED, VC._Name, true, 0) != -1)
              continue;
            if (PivotHelper.getPivottedColumn(V, VC.getName()) != null)
              continue;
            if (First == true)
              First = false;
            else
              Str.append(", ");
            Str.append(getShortColumnVar(VC._Name));
          }

        for (Formula F : V._Formulas)
          if (F != null)
            {
              if (TextUtil.findStarElement(V._Realize._Exclude_DEPRECATED, F._Name, true, 0) != -1)
                continue;
              if (First == true)
                First = false;
              else
                Str.append(", ");
              Str.append(getShortColumnVar(F._Name));
            }

        for (ViewColumn VC : V._PivotColumns)
          {
            if (TextUtil.findStarElement(V._Realize._Exclude_DEPRECATED, VC.getName(), true, 0) != -1)
              continue;
            if (First == true)
              First = false;
            else
              Str.append(", ");
            Str.append(getShortColumnVar(VC.getName()));
          }
        return Str.toString();
      }

    private String DoFormulasSuperView(View V, String Str, boolean Realize)
      {
        StringBuilder b = new StringBuilder();
        b.append("select /*DoFormulasSuperView*/\n");
        boolean First = true;
        for (ViewColumn VC : V._ViewColumns)
          {
            if (VC._FormulaOnly == true)
              {
                b.append("--     ").append(getShortColumnVar(VC._Name)).append("  BLOCKED\n");
                continue;
              }
            if (Realize == true && TextUtil.findStarElement(V._Realize._Exclude_DEPRECATED, VC.getName(), true, 0) != -1)
              {
                b.append("--     ").append(getShortColumnVar(VC._Name)).append("  REALIZE-EXCLUDED\n");
                continue;
              }
            if (PivotHelper.getPivottedColumn(V, VC.getName()) != null) // V._Pivots.isEmpty() == false && (PivotHelper.isPivotColumn(VC) == true ||
                                                                        // PivotHelper.isPivotAggregate(VC) == true))
              {
                b.append("--     ").append(getShortColumnVar(VC._Name)).append(VC._Aggregate != null ? "  PIVOT AGGREGATE\n" : "  PIVOTED ON\n");
                continue;
              }
            if (VC._SameAsObj != null && VC._SameAsObj._Mode == ColumnMode.CALCULATED || VC._JoinOnly == true)
              continue;
            if (First == true)
              First = false;
            else
              b.append("     , ");

            // ViewRealizeMapping VRM = Realize == false ? null : V._Realize.getMapping(VC.getName());
            // if (Realize == false || VRM == null)
            b.append(getShortColumnVar(VC._Name) + " -- COLUMN\n");
            // else
            // b.append(VRM.printMapping() + " -- COLUMN (MAPPING OVERRIDE)\n");
          }

        for (Formula F : V._Formulas)
          {
            if (F == null)
              continue;
            String FormulaType = getColumnType(F.getType(), 8192, null, F.isCollection(), F._Precision, F._Scale);
            b.append("     -- ").append(String.join("\n     -- ", F._Description)).append("\n");
            if (First == true)
              First = false;
            else
              b.append("     , ");
            b.append("(").append(genFormulaCode(V, F)).append(")::" + FormulaType + " as ").append(getShortColumnVar(F._Name)).append("\n");
          }

        for (ViewColumn VC : V._PivotColumns)
          {
            if (First == true)
              First = false;
            else
              b.append(", ");
            b.append(getShortColumnVar(VC.getName()));
          }

        b.append("\n from (\n").append(Str).append("\n      ) as T\n");
        if (V._Realize != null)
          b.append("-- Realized as " + genRealizedColumnList(V, " ") + "\n");
        Str = b.toString();
        return Str;
      }

    private String PivotGenericWay(View V, String Str)
    throws Exception
      {
        StringBuilder groupByStr = new StringBuilder();
        Str = "with T as (\n" + Str + ") select ";
        int count = 0;
        int i = 0;
        for (; i < V._ViewColumns.size(); ++i)
          {
            ViewColumn VC = V._ViewColumns.get(i);
            if (VC == null)
              continue;
            if (PivotHelper.getPivottedColumn(V, VC.getName()) != null || PivotHelper.isPivotColumn(VC) == true)
              break;
            if (VC._SameAs.equals("_TS.p") == true || VC._SameAsObj._Mode != ColumnMode.CALCULATED && VC._JoinOnly == false)// && VC._FormulaOnly == false)
              {
                if (count != 0)
                  Str += "\n       , ";
                Str += getShortColumnVar(VC.getName()) + " "; // Date";
                groupByStr.append(count == 0 ? "" : ", ").append((++count));
              }
          }
        for (; i < V._ViewColumns.size(); ++i)
          {
            ViewColumn VC = V._ViewColumns.get(i);
            // don't output pivoted aggregates if not ok
            if (PivotHelper.isAllowedSourceAggregate(VC) == true)
              {
                Str += genCompositeAggregateColumnSQL(VC);
                ++count;
              }
            // Window-only columns are treated like regular columns for the purpose of the outer view. They are not composable.
            else if (VC._Aggregate != null && VC._Aggregate.isWindowOnly() == true)
              {
                groupByStr.append(count == 0 ? "" : ", ").append(++count);
                Str += "\n       , " + getShortColumnVar(VC._Name);
              }
          }

        // Output the pivots now for the "second level".
        for (ViewColumn VC : V._PivotColumns)
          Str += genPivotColumnSQL(VC);

        Str += "\n"
        + "from T\n";
        Str += "     group by " + groupByStr.toString();
        // int count = 0;
        // for (ViewColumn VC : V._ViewColumns.size())
        // {
        // if (VC == null)
        // continue;
        // if (PivotHelper.getPivottedColumn(V, VC.getName()) != null || PivotHelper.isPivotColumn(VC) == true)
        // break;
        //
        // if (PivotHelper.getPivottedColumn(V, VC.getName()) != null) // PivotHelper.isPivotColumn(V._ViewColumns.get(i)) == true)
        // break;
        // else if (V._ViewColumns.get(i)._JoinOnly == false)
        // {
        // ++count;
        // Str += (count == 1 ? "" : ", ") + count;
        // }
        // }
        Str += "\n";
        return Str;
      }

    public String genPivotColumnSQL(ViewColumn VC)
    throws Exception
      {
        if (VC._Aggregate.isWindowOnly() == true)
          throw new Error("Fuction genPivotColumnSQL called for '" + VC.getFullName() + "' with a window-only aggregate '" + VC._Aggregate.name() + "'.");

//        String aggr = VC._Aggregate == AggregateType.COUNT ? AggregateType.SUM.name()
//        : VC._Aggregate == AggregateType.ARRAY ? "array_agg"
//        : VC._Aggregate.name();

        StringBuilder Str = new StringBuilder();
        Str.append(/*aggr*/getAggregateStr(VC._Aggregate)).append("(");
        if (VC._Distinct == true)
          Str.append("distinct ");
        if (supportsFilterClause() == false)
         Str.append("case when ").append(rewriteExpressionColumnQuoting(VC._Filter)).append(" then ");
        Str.append(getShortColumnVar(VC._NameInner));
        if (supportsFilterClause() == false)
          Str.append(" else null end");

        if (TextUtil.isNullOrEmpty(VC._AggregateAttributes) == false)
          Str.append(", ").append(VC._AggregateAttributes);
        
        // If there is a partition or a range, we gotta switch to an OVER statement.
        if (VC._partitionByObjs.size() != 0 || TextUtil.isNullOrEmpty(VC._Range) == false)
          Str.append(") OVER (");
        printAggregatePartitionBy(Str, VC._partitionByObjs, "T");
        printAggregateOrderBy(Str, VC._OrderByObjs, "T", null);
        Str.append(")");
        if (supportsFilterClause() == true)  
         Str.append(" filter (where ").append(rewriteExpressionColumnQuoting(VC._Filter)).append(") ");

        String Expr = Str.toString();
        if (TextUtil.isNullOrEmpty(VC._Expression) == false)
          Expr = rewriteExpressionColumnQuoting(VC._Expression.replaceAll("\\?", Expr));

        if (TextUtil.isNullOrEmpty(VC._Coalesce) == false)
          Expr = "coalesce(" + Expr + ", " + ValueHelper.printValueSQL(getSQlCodeGen(), VC.getName(), VC.getType(), VC.isCollection(), VC._Coalesce) + ")";

        if (VC._Type != null)
          Expr = "(" + Expr + ")::" + getColumnType(VC._Type.getType(), VC._Type._Size, ColumnMode.NORMAL, VC._Type.isCollection(), VC._Precision, VC._Scale);

        return "\n     , " + Expr + " as " + getShortColumnVar(VC.getName());
      }

    public String genCompositeAggregateColumnSQL(ViewColumn VC)
      {
        if (VC._Aggregate == null)
          throw new Error("Method genCompositeAggregateColumnSQL called with non aggregate view column.");
        if (VC._Aggregate.isComposable() == false)
          throw new Error("Method genCompositeAggregateColumnSQL called with an aggregate view column that is not composable.");

        String aggr = VC._Aggregate == AggregateType.COUNT ? AggregateType.SUM.name()
        : VC._Aggregate == AggregateType.ARRAY ? "array_agg"
        : VC._Aggregate.name();

        return VC._Aggregate.isWindowOnly() == true ? "\n     , " + aggr + "() over() as " + getShortColumnVar(VC._Name)
        : "\n     , " + aggr + "(" + getShortColumnVar(VC.getName()) + ") as " + getShortColumnVar(VC._Name);
      }


    @Override
    public void genDDLComments(PrintWriter OutFinal, View V)
    throws Exception
      {
        StringBuilderWriter Str = new StringBuilderWriter();
        PrintWriter Out = new PrintWriter(Str);
        genDDL(Out, V);

        OutFinal.println("ALTER VIEW " + V._ParentSchema._Name + "." + V._Name + " set OPTIONS(description=" + TextUtil.escapeSingleQuoteForSQL(Str.toString().replace("\r\n", "\\n").replace("\n", "\\n")) + ");");
        OutFinal.println();
      }

    @Override
    public String getDDLMetadataVersion()
      {
        return "DDL META DATA VERSION 2021-09-02";
      }

    private String genFormulaCode(View ParentView, Formula F)
      {
        String FormulaStr = TextUtil.joinTrim(F._FormulaStrs, " ");

        Matcher M = F.getParentView()._ViewColumnsRegEx.matcher(FormulaStr);
        StringBuffer Str = new StringBuffer();
        while (M.find() == true)
          {
            String s = M.group(1);
            if (FormulaStr.substring(M.start()).toLowerCase().matches("^\\s*is\\s+null") == true)
              {
                M.appendReplacement(Str, getShortColumnVar(M.group(1)));
                continue;
              }
            for (ViewColumn VC : ParentView._ViewColumns)
              if (s.equals(VC._Name) == true)
                {
                  ColumnType T = VC._SameAsObj == null && VC._SameAs.equals("_TS.p") == true ? ColumnType.DATE : VC.getType();
                  boolean nullTest = FormulaStr.substring(M.end()).toLowerCase().matches("\\s*is\\s*(not)?\\s*null.*") || F._CoalesceNumbers == false;
                  if (nullTest == false && (T == ColumnType.INTEGER || T == ColumnType.SHORT || T == ColumnType.LONG || T == ColumnType.FLOAT || T == ColumnType.DOUBLE))
                    M.appendReplacement(Str, "coalesce(\"" + M.group(1) + "\", 0)");
                  else
                    M.appendReplacement(Str, getShortColumnVar(M.group(1)));
                  break;
                }
            for (ViewColumn VC : ParentView._PivotColumns)
              if (s.equals(VC.getName()) == true)
                {
                  ColumnType T = VC.getType();
                  boolean nullTest = FormulaStr.substring(M.end()).toLowerCase().matches("\\s*is\\s*(not)?\\s*null.*") || F._CoalesceNumbers == false;
                  if (nullTest == false && (T == ColumnType.INTEGER || T == ColumnType.SHORT || T == ColumnType.LONG || T == ColumnType.FLOAT || T == ColumnType.DOUBLE))
                    M.appendReplacement(Str, "coalesce(" + getShortColumnVar(M.group(1)) + ", 0)");
                  else
                    M.appendReplacement(Str, getShortColumnVar(M.group(1)));
                  break;
                }
          }
        M.appendTail(Str);
        FormulaStr = Str.toString();

        // Resolve sub-formulas
        if (F.getParentView()._FormulasRegEx != null)
          {
            M = F.getParentView()._FormulasRegEx.matcher(FormulaStr);
            Str.setLength(0);
            while (M.find() == true)
              {
                String s = M.group(1);
                for (Formula F2 : ParentView._Formulas)
                  if (s.equals(F2._Name) == true && s.equals(F._Name) == false)
                    {
                      String FormulaType = getColumnType(F2.getType(), F2._Size, null, F2.isCollection(), F2._Precision, F2._Scale);
                      M.appendReplacement(Str, "(" + genFormulaCode(ParentView, F2) + ")::" + FormulaType);
                      break;
                    }
              }
            M.appendTail(Str);
          }
        return Str.toString();
        
        // LDH-NOTE: See note in rewriteExpressionColumnQuoting. Issues with formulas being cleaned up.
//      return rewriteExpressionColumnQuoting(Str.toString());
        
      }

    private String genRealizedColumnList(View V, String Lead)
      {
        StringBuilder Str = new StringBuilder();
        Str.append("/*genRealizedColumnList*/");
        boolean First = true;
        boolean Blocked = false;
        // LOG.debug("View " + V._Name + ": " + TextUtil.print(V.getColumnNames()));
        for (ViewColumn VC : V._ViewColumns)
          {
            if (PivotHelper.getPivottedColumn(V, VC.getName()) != null) // PivotHelper.isPivotColumn(VC) == true || PivotHelper.isPivotAggregate(VC) == true)
              continue;
            if (VC == null || (VC._SameAsObj != null && VC._SameAsObj._Mode == ColumnMode.CALCULATED) || VC._JoinOnly == true || VC._FormulaOnly == true)
              {
                if (VC != null)
                  {
                    Str.append(Lead + "-- " + getShortColumnVar(VC._Name) + " -- " + (VC._FormulaOnly == true ? "BLOCKED" : "VIEW-EXCLUDED"));
                    Blocked = true;
                  }
                continue;
              }
            if (TextUtil.findStarElement(V._Realize._Exclude_DEPRECATED, VC.getName(), true, 0) == -1)
              {
                if (First == false)
                  Str.append(Lead).append(",");
                else
                  {
                    if (Blocked == true)
                      Str.append(Lead);
                    First = false;
                  }
                // ViewRealizeMapping VRM = V._Realize.getMapping(VC.getName());
                // if (VRM == null)
                Str.append(/* V._ParentSchema._Name + "." + V._Name + "."+ */ getShortColumnVar(VC._Name) + " -- COLUMN");
                // else
                // Str.append(VRM.printMapping() + " -- COLUMN (REALIZE MAPPING OVERRIDE)");
              }
            else
              {
                Blocked = true;
                Str.append(Lead + "-- " + getShortColumnVar(VC._Name) + " -- REALIZE-EXCLUDED");
              }
          }
        for (Formula F : V._Formulas)
          {
            if (F == null)
              continue;
            if (TextUtil.findStarElement(V._Realize._Exclude_DEPRECATED, F._Name, true, 0) == -1)
              {
                if (First == false)
                  Str.append(Lead).append(",");
                else
                  {
                    if (Blocked == true)
                      Str.append(Lead);
                    First = false;
                  }
                // ViewRealizeMapping VRM = V._Realize.getMapping(F._Name);
                // if (VRM == null)
                Str.append(getShortColumnVar(F._Name) + " -- FORMULA");
                // else
                // Str.append(VRM.printMapping() + " -- FORMULA (REALIZE MAPPING OVERRIDE)");
              }
          }
        for (ViewColumn VC : V._PivotColumns)
          {
            if (TextUtil.findStarElement(V._Realize._Exclude_DEPRECATED, VC.getName(), true, 0) != -1)
              continue;
            // ViewRealizeMapping VRM = V._Realize.getMapping(C.getName());
            // if (VRM == null)
            Str.append(Lead + ", " + getShortColumnVar(VC.getName()) + " -- PIVOT COLUMN");
            // else
            // Str.append(Lead + ", " + VRM.printMapping() + " -- PIVOT (REALIZE MAPPING OVERRIDE)");
          }

        return Str.toString();
      }

    private String PrintValueList(ViewPivot P)
      {
        StringBuilder Str = new StringBuilder();
        boolean trimNeeded = stringNeedsTrim(P._VC._SameAsObj);
        for (int i = 0; i < P._Values.length; ++i)
          {
            if (i != 0)
              Str.append(", ");
            String Pad = "";
            if (trimNeeded == true)
              Pad = PaddingUtil.getPad(P._VC._SameAsObj._Size - P._Values[i]._Value.length());
            Str.append(TextUtil.escapeSingleQuoteForSQL(P._Values[i]._Value + Pad));
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
    throws Exception
      {
        String DDLStr = alterTableAddIndexDDL(I);
        Out.print(DDLStr);
      }

    @Override
    public void genKeysManagement(PrintWriter Out, Object O)
      {
        if (supportsPrimaryKeys() == false)
         return;

        Out.println("delete from TILDA.Key where \"name\" = '" + O._ParentSchema._Name + "." + O._Name.toUpperCase() + "';");
        Out.println("insert into TILDA.Key (\"refnum\", \"name\", \"max\", \"count\", \"created\", \"lastUpdated\") values ((select COALESCE(max(\"refnum\"),0)+1 from TILDA.Key), '"
        + O._ParentSchema._Name + "." + O._Name.toUpperCase() + "',(select COALESCE(max(\"" + O._ParentSchema.getConventionPrimaryKeyName() + "\"),0)+1 from " + O._ParentSchema._Name + "." + O._Name
        + "), " + O._PrimaryKey._KeyBatch + ", current_timestamp, current_timestamp);");
      }

    public boolean PrintColumnList(PrintWriter Out, List<Column> Columns)
      {
        return PrintColumnList(Out, Columns, null);
      }

    /**
     * Prints a comma-separated list of columns, for example for an index or an FK.
     * 
     * @param Out the output stream
     * @param Columns the list of columns to print (must not be null)
     * @param LALs For indices, the list of columns marked as LAL-enabled (Left-Anchor-Like for efficient search such as like 'abc%').
     * @return
     */
    public boolean PrintColumnList(PrintWriter Out, List<Column> Columns, String[] LALs)
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
            Out.print(getShortColumnVar(C.getName()));
            if (LALs != null && TextUtil.findElement(LALs, C.getName(), false, 0) != -1)
              Out.print(" text_pattern_ops");
          }
        return First != true;
      }


    @Override
    public void genClassEnd(PrintWriter Out, GeneratorSession G)
    throws Exception
      {
      }

  }
