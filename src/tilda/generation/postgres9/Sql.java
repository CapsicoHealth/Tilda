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

import tilda.db.stores.PostgreSQL;
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
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.Value;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.parsing.parts.ViewJoin;
import tilda.parsing.parts.ViewPivot;
import tilda.parsing.parts.ViewPivotAggregate;
import tilda.parsing.parts.ViewPivotValue;
import tilda.parsing.parts.ViewRealizeUpsert;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.utils.PaddingTracker;
import tilda.utils.PaddingUtil;
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
        return getColumnType(C.getType(), C._Size, C._Mode, C.isCollection(), C._Precision, C._Scale);
      }

    @Override
    public String getColumnType(Column C, ColumnType AggregateType)
      {
        return getColumnType(AggregateType, C._Size, C._Mode, C.isCollection(), C._Precision, C._Scale);
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
          {
            DBStringType DBT = getDBStringType(Size);
            return isCollection == true || MultiOverride == true ? "text"
            : DBT == DBStringType.CHARACTER ? PostgresType.CHAR._SQLType
            : DBT == DBStringType.VARCHAR ? PostgresType.STRING._SQLType
            : "text";
          }
        if (Type == ColumnType.JSON)
          return "jsonb";
        return isCollection == true ? PostgresType.get(Type)._SQLArrayType : PostgresType.get(Type)._SQLType;
      }


    @Override
    public boolean stringNeedsTrim(Column C)
      {
        return C.getType() == ColumnType.STRING && C._Mode != ColumnMode.CALCULATED && C.isCollection() == false && getDBStringType(C._Size) == DBStringType.CHARACTER;
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
              Out.print("\"" + C.getName() + "\"" + O._PadderColumnNames.getPad(C.getName()) + "  " + PadderColumnTypes.pad(getColumnType(C)));
              Out.print(C._Nullable == false ? "  not null" : "          ");
              if (C._DefaultCreateValue != null)
                Out.print(" DEFAULT " + ValueHelper.printValue(C.getName(), C.getType(), C._DefaultCreateValue._Value));
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
                Out.print("  , CONSTRAINT " + FK.getName() + " FOREIGN KEY (");
                PrintColumnList(Out, FK._SrcColumnObjs);
                Out.println(") REFERENCES " + FK._DestObjectObj._ParentSchema._Name + "." + FK._DestObjectObj._Name + " ON DELETE restrict ON UPDATE cascade");
              }
        Out.println(" );");
        Out.println("COMMENT ON TABLE " + O.getShortName() + " IS E" + TextUtil.escapeSingleQuoteForSQL(O._Description) + ";");
        for (Column C : O._Columns)
          if (C != null && C._Mode != ColumnMode.CALCULATED)
            Out.println("COMMENT ON COLUMN " + O.getShortName() + ".\"" + C.getName() + "\" IS E" + TextUtil.escapeSingleQuoteForSQL(C._Description) + ";");
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
            TableRankTracker TI1 = TableRankTracker.getElementFromLast(TableStack, C1._ParentObject, null);
            TableRankTracker TI2 = TableRankTracker.getElementFromLast(TableStack, C2._ParentObject, null);
            if (TI1 == null)
              throw new Error("Cannot find source table " + C1._ParentObject.getFullName());
            if (TI2 == null)
              throw new Error("Cannot find referenced table " + C2._ParentObject.getFullName());
            Str.append(TI1.getFullName() + ".\"" + C1.getName()).append("\" = ").append(TI2.getFullName() + ".\"" + C2.getName() + "\"");
          }

        return Str.toString();
      }



    private String PrintBaseView(View V, boolean OmmitTZs)
    throws Exception
      {
        List<TotalMess> FuckList = TotalMess.ScanView(V); // Sorry for the explitives here, but this code is really messed up in very impolite ways!!!

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
                    Str.append("\"").append(VC._Name).append("\"");
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
                    if (V._ViewColumns.get(i)._Aggregate != null)
                      break;
                    if (V._ViewColumns.get(i)._JoinOnly == false)
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
        Str.append(" on " + Q._Clause);
        return Q;
      }

    private boolean PrintViewColumn(StringBuilder Str, ViewColumn VC, TableRankTracker TI, boolean NoAs)
    throws Exception
      {
        if (TextUtil.isNullOrEmpty(VC._Coalesce) == false)
          Str.append("coalesce(");

        boolean hasAggregates = false;
        // if (VC._Aggregate == AggregateType.COUNT)
        // {
        // if (VC._Distinct == true)
        // Str.append("count(distinct "+VC._SameAs+")");
        // else
        // Str.append("count(*)");
        // if (TextUtil.isNullOrEmpty(VC._Filter) == false)
        // {
        // Str.append(" filter(where ").append(VC._Filter).append(")");
        // }
        // hasAggregates = true;
        // }
        // else

        // If the column has a sameAs string, but no sameAsObj and is managed, then we print the sameAs as is.
        if (VC.isSameAsLitteral() == true)
          {
            Str.append(TextUtil.isNullOrEmpty(VC._Expression) == true ? VC._SameAs : VC._Expression.replaceAll("\\?", VC._SameAs));
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
              }
            if (trimNeeded)
              Str.append("trim(");
            String ColExpr = TI.getFullName() + ".\"" + VC._SameAsObj.getName() + "\"" + (textConversionNeeded ? "::TEXT" : "");
            if (TextUtil.isNullOrEmpty(VC._Expression) == false)
              ColExpr = VC._Expression.replaceAll("\\?", ColExpr);
            Str.append(ColExpr);
            if (trimNeeded)
              Str.append(")");
            if (VC._Aggregate != null)
              {
                if (VC._OrderByObjs != null && VC._OrderByObjs.isEmpty() == false)
                  {
                    Str.append(" order by ");
                    boolean First = true;
                    for (int i = 0; i < VC._OrderByObjs.size(); ++i)
                      {
                        if (First == true)
                          First = false;
                        else
                          Str.append(", ");
                        Str.append("\"" + VC._OrderByObjs.get(i).getName() + "\" " + VC._OrderByOrders.get(i));
                      }
                  }
                Str.append(")");
                if (TextUtil.isNullOrEmpty(VC._Filter) == false)
                  {
                    Str.append(" filter(where ").append(VC._Filter).append(")");
                  }
              }
          }
        if (TextUtil.isNullOrEmpty(VC._Coalesce) == false)
          Str.append(", " + ValueHelper.printValue(VC._SameAsObj.getName(), VC.getAggregateType(), VC._Coalesce) + ")");
        if (NoAs == false)
          Str.append(" as \"" + VC.getName() + "\" " + (VC._SameAsObj == null ? "" : "-- " + VC._SameAsObj._Description));
        if (VC._FormulaOnly == true)
          Str.append(" -- (BLOCKED IN SECONDARY VIEW FOR FORMULAS)");
        return hasAggregates;
      }

    public static String getViewSubRealizeSchemaName()
      {
        return "TILDATMP";
      }

    public static String getViewSubRealizeViewName(View V)
      {
        return V._ParentSchema._Name + "_" + V._Name + "_R";
      }

    public static String getViewSubRealizeName(View V)
      {
        return getViewSubRealizeSchemaName() + "." + getViewSubRealizeViewName(V);
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
            StringBuilder r = new StringBuilder();
            if (SubRealizedViews != null)
              {
                r.append("(?i)\\b(");
                boolean First = true;
                for (View srv : SubRealizedViews)
                  {
                    if (First == false)
                      r.append("|");
                    else
                      First = false;
                    r.append(srv.getRootViewName().toUpperCase());
                  }
                r.append(")(PIVOT)?VIEW\\b");
                Str = Str.replaceAll(r.toString(), "$1Realized");
              }

            if (AncestorRealizedViews != null)
              for (View arv : AncestorRealizedViews)
                {
                  String regex = "(?i)\\b(" + arv.getShortName().replace(".", "\\.)?") + "\\b";
                  Str = Str.replaceAll(regex, getViewSubRealizeName(arv));
                }

            OutFinal.println("create or replace view " + getViewSubRealizeName(V) + " as ");
            OutFinal.println(Str + ";\n");
          }
        if (V._Realize != null)
          {
            OutFinal.println();
            String TName = V.getRealizedTableName(false);
            String RName = V.getRealizedTableName(true);
            ViewRealizeUpsert Up = V._Realize._Upsert;

            if (Up != null)
              {
                String ColType = getColumnType(Up._UpsertTSColumnObj._SameAsObj);
                OutFinal.append("DROP FUNCTION IF EXISTS " + V._ParentSchema._Name + ".Refill_" + TName + "(fromInclusive " + ColType + ", toExclusive " + ColType + ");\n")
                .append("CREATE OR REPLACE FUNCTION " + V._ParentSchema._Name + ".Refill_" + TName + "(fromInclusive " + ColType + ", toExclusive " + ColType + ")\n");
              }
            else
              {
                OutFinal.append("DROP FUNCTION IF EXISTS " + V._ParentSchema._Name + ".Refill_" + TName + "();\n")
                .append("CREATE OR REPLACE FUNCTION " + V._ParentSchema._Name + ".Refill_" + TName + "()\n");
              }
            OutFinal.append(" RETURNS boolean AS $$\n")
            .append("BEGIN\n");

            StringWriter BaseLineInsert = new StringWriter();
            BaseLineInsert.append("  INSERT INTO " + RName + " (" + PrintInsertColumnNames(V) + ")\n     ");
            BaseLineInsert.append("SELECT ").append(genRealizedColumnList(V, "\n          "));

            if (SubRealizedViews != null || AncestorRealizedViews != null) // View depends on realized views.
              BaseLineInsert.append("\n     FROM " + getViewSubRealizeName(V));
            else
              BaseLineInsert.append("\n     FROM ").append(V._ParentSchema._Name).append(".").append(V._Name);

            if (Up != null)
              {
                OutFinal.append("  IF fromInclusive is null AND toExclusive is null\n");
                OutFinal.append("  THEN\n");
              }
            OutFinal.append("  TRUNCATE ").append(RName).append(";\n");
            OutFinal.append(BaseLineInsert.toString()).append(";\n");
            OutFinal.append("  ANALYZE " + RName + ";\n");
            if (Up != null)
              {
                OutFinal.append("  ELSE\n");
                OutFinal.append(BaseLineInsert.toString());
                OutFinal.append("\n    WHERE (fromInclusive is null or \"").append(Up._UpsertTSColumnObj.getName()).append("\" >= fromInclusive) and (toExclusive is null or \"").append(Up._UpsertTSColumnObj.getName()).append("\" < toExclusive)");
                OutFinal.append("\n  ON CONFLICT (");
                boolean First = true;
                for (ViewColumn VC : Up._IdentityViewColumns)
                  {
                    if (First == true)
                      First = false;
                    else
                      OutFinal.append(", ");
                    OutFinal.append("\"").append(VC._Name).append("\"");
                  }
                OutFinal.append(")");
                OutFinal.append("\n  DO UPDATE SET\n");
                First = true;
                for (String ColNames : V._Realize._ParentRealized.getColumnNames())
                  {
                    OutFinal.append("    ");
                    if (First == true)
                      First = false;
                    else
                      OutFinal.append(",");
                    OutFinal.append("\"").append(ColNames).append("\"").append(" = EXCLUDED.").append("\"").append(ColNames).append("\"").append("\n");
                  }
                OutFinal.append("  ;\n");
                if (Up._UpsertTSColumnObj != null)
                  OutFinal.append("  DELETE FROM " + RName + " WHERE \"" + Up._DeleteTSColumnObj.getName() + "\" is not null;\n");
                OutFinal.append("  END IF;\n");
              }
            // for (Index I : V._Realize._Indices)
            // if (I != null)
            // genIndex(OutFinal, I);

            // OutFinal.append(" GRANT ALL ON ").append(RName).append(" TO tilda_app;\n");
            // OutFinal.append(" GRANT SELECT ON ").append(RName).append(" TO tilda_read_only;\n");
            // OutFinal.append(" GRANT SELECT ON ").append(RName).append(" TO tilda_reporting;\n");
            // OutFinal.append(" ANALYZE " + RName + ";\n")
            OutFinal.append("  return true;\n")
            .append("END; $$\n")
            .append("LANGUAGE PLPGSQL;\n")
            .append("\n");
            if (Up != null)
              {
                String ColType = getColumnType(Up._UpsertTSColumnObj._SameAsObj);
                OutFinal.append("DROP FUNCTION IF EXISTS " + V._ParentSchema._Name + ".Refill_" + TName + "(fromInclusive " + ColType + ");\n")
                .append("CREATE OR REPLACE FUNCTION " + V._ParentSchema._Name + ".Refill_" + TName + "(fromInclusive " + ColType + ")\n");
                OutFinal.append(" RETURNS boolean AS $$\n")
                .append("BEGIN\n");
                OutFinal.append("  return " + V._ParentSchema._Name + ".Refill_" + TName + "(fromInclusive, null);\n")
                .append("END; $$\n")
                .append("LANGUAGE PLPGSQL;\n")
                .append("\n");
                OutFinal.append("DROP FUNCTION IF EXISTS " + V._ParentSchema._Name + ".Refill_" + TName + "();\n")
                .append("CREATE OR REPLACE FUNCTION " + V._ParentSchema._Name + ".Refill_" + TName + "()\n");
                OutFinal.append(" RETURNS boolean AS $$\n")
                .append("BEGIN\n");
                OutFinal.append("  return " + V._ParentSchema._Name + ".Refill_" + TName + "(null, null);\n")
                .append("END; $$\n")
                .append("LANGUAGE PLPGSQL;\n")
                .append("\n");
              }
            OutFinal.append("-- SELECT " + V._ParentSchema._Name + ".Refill_" + TName + "(); -- !!! THIS MAY TAKE SEVERAL MINUTES !!!\n");
          }
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
            if (TextUtil.FindStarElement(V._Realize._Exclude_DEPRECATED, VC._Name, true, 0) != -1)
              continue;
            if (V.isPivotColumn(VC) == true || V.isPivotAggregate(VC) == true)
              continue;
            if (First == true)
              First = false;
            else
              Str.append(", ");
            Str.append("\"").append(VC._Name).append("\"");
          }

        for (Formula F : V._Formulas)
          if (F != null)
            {
              if (TextUtil.FindStarElement(V._Realize._Exclude_DEPRECATED, F._Name, true, 0) != -1)
                continue;
              if (First == true)
                First = false;
              else
                Str.append(", ");
              Str.append("\"").append(F._Name).append("\"");
            }

        for (Column C : V._PivotColumns)
          {
            if (TextUtil.FindStarElement(V._Realize._Exclude_DEPRECATED, C.getName(), true, 0) != -1)
              continue;
            if (First == true)
              First = false;
            else
              Str.append(", ");
            Str.append("\"").append(C.getName()).append("\"");
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
                b.append("--     \"").append(VC._Name).append("\"  BLOCKED\n");
                continue;
              }
            if (Realize == true && TextUtil.FindStarElement(V._Realize._Exclude_DEPRECATED, VC.getName(), true, 0) != -1)
              {
                b.append("--     \"").append(VC._Name).append("\"  REALIZE-EXCLUDED\n");
                continue;
              }
            if (V._Pivots.isEmpty() == false && (V.isPivotColumn(VC) == true || V.isPivotAggregate(VC) == true))
              {
                b.append("--     \"").append(VC._Name).append(VC._Aggregate != null ? "\"  PIVOT AGGREGATE\n" : "\"  PIVOTED ON\n");
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
            b.append("\"" + VC._Name + "\" -- COLUMN\n");
            // else
            // b.append(VRM.printMapping() + " -- COLUMN (MAPPING OVERRIDE)\n");
          }

        for (Formula F : V._Formulas)
          {
            if (F == null)
              continue;
            String FormulaType = getColumnType(F.getType(), 8192, null, false, F._Precision, F._Scale);
            b.append("     -- ").append(String.join("\n     -- ", F._Description)).append("\n");
            if (First == true)
              First = false;
            else
              b.append("     , ");
            b.append("(").append(genFormulaCode(V, F)).append(")::" + FormulaType + " as \"").append(F._Name).append("\"\n");
          }

        for (Column C : V._PivotColumns)
          {
            if (First == true)
              First = false;
            else
              b.append(", ");
            b.append("\"").append(C.getName()).append("\"");
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
        Str = "with T as (\n" + Str + ") select ";
        int i = 0;
        for (; i < V._ViewColumns.size(); ++i)
          {
            ViewColumn VC = V._ViewColumns.get(i);
            if (VC == null)
              continue;
            if (V.isPivotColumn(VC) == true)
              break;
            if (VC._SameAs.equals("_TS.p") == true || VC._SameAsObj._Mode != ColumnMode.CALCULATED && VC._JoinOnly == false)// && VC._FormulaOnly == false)
              {
                if (i != 0)
                  Str += "\n       , ";
                Str += "\"" + VC.getName() + "\" "; // Date";
                // ++i;
              }
          }
        for (; i < V._ViewColumns.size(); ++i)
          {
            ViewColumn VC = V._ViewColumns.get(i);
            if (VC._Aggregate != null)
              {
                Str += genCompositeAggregateColumnSQL(VC);
              }
          }


        for (ViewPivot P : V._Pivots)
          {
            if (P._Interleave == false)
              {
                for (ViewPivotAggregate A : P._Aggregates)
                  for (ViewPivotValue VPV : P._Values)
                    if (VPV != null)
                      Str += genPivotColumnSQL(V, P, A, VPV);
              }
            else
              {
                for (ViewPivotValue VPV : P._Values)
                  for (ViewPivotAggregate A : P._Aggregates)
                    if (VPV != null)
                      Str += genPivotColumnSQL(V, P, A, VPV);
              }
          }
        Str += "\n"
        + "from T\n";
        Str += "     group by ";
        int count = 0;
        for (i = 0; i < V._ViewColumns.size(); ++i)
          if (V.isPivotColumn(V._ViewColumns.get(i)) == true)
            break;
          else if (V._ViewColumns.get(i)._JoinOnly == false)
            {
              ++count;
              Str += (count == 1 ? "" : ", ") + count;
            }
        Str += "\n";
        return Str;
      }

    public String genPivotColumnSQL(View V, ViewPivot P, ViewPivotAggregate A, ViewPivotValue VPV)
      {
        ViewColumn VC = V.getViewColumn(A._Name);

        String aggr = VC._Aggregate == AggregateType.COUNT ? AggregateType.SUM.name()
        : VC._Aggregate == AggregateType.ARRAY ? "array_agg"
        : VC._Aggregate.name();
        String Expr = aggr + "(\"" + VC.getName() + "\") filter (where \"" + P._VC.getName() + "\"= " + TextUtil.escapeSingleQuoteForSQL(VPV._Value) + ") ";

        if (TextUtil.isNullOrEmpty(VPV._Expression) == false)
          Expr = VPV._Expression.replaceAll("\\?", Expr);
        if (VPV._Type != null)
          Expr = "(" + Expr + ")::" + getColumnType(VPV._Type.getType(), VPV._Type._Size, ColumnMode.NORMAL, VPV._Type.isCollection(), VPV._Precision, VPV._Scale);
        return "\n     , " + Expr + " as \"" + A.makeName(VPV) + "\"";
      }

    public String genCompositeAggregateColumnSQL(ViewColumn VC)
      {
        if (VC._Aggregate == null)
          throw new Error("Method genCompositeAggregateColumnSQL called with non aggregate view column.");

        String aggr = VC._Aggregate == AggregateType.COUNT ? AggregateType.SUM.name()
        : VC._Aggregate == AggregateType.ARRAY ? "array_agg"
        : VC._Aggregate.name();

        return "\n     , " + aggr + "(\"" + VC.getName() + "\") as \"" + VC._Name + "\"";
      }


    @Override
    public void genDDLComments(PrintWriter OutFinal, View V)
    throws Exception
      {
        StringBuilderWriter Str = new StringBuilderWriter();
        PrintWriter Out = new PrintWriter(Str);
        genDDL(Out, V);

        OutFinal.println("COMMENT ON VIEW " + V._ParentSchema._Name + "." + V._Name + " IS E" + TextUtil.escapeSingleQuoteForSQL(Str.toString().replace("\r\n", "\\n").replace("\n", "\\n")) + ";");
        OutFinal.println();
        for (int i = 0; i < V._ViewColumns.size(); ++i)
          {
            ViewColumn VC = V._ViewColumns.get(i);
            if (V._Pivots.isEmpty() == false && (V.isPivotColumn(VC) == true || V.isPivotAggregate(VC) == true))
              continue;
            if (VC != null && VC._SameAsObj != null && VC._SameAsObj._Mode != ColumnMode.CALCULATED && VC._JoinOnly == false && VC._FormulaOnly == false)
              OutFinal.println("COMMENT ON COLUMN " + V.getShortName() + ".\"" + VC.getName() + "\" IS E" + TextUtil.escapeSingleQuoteForSQL(VC._SameAsObj._Description) + ";");
          }
        for (ViewPivot P : V._Pivots)
          if (P != null)
            for (ViewPivotAggregate A : P._Aggregates)
              {
                ViewColumn VC = V.getViewColumn(A._Name);
                for (ViewPivotValue VPV : P._Values)
                  if (VPV != null)
                    OutFinal.println("COMMENT ON COLUMN " + V.getShortName() + ".\"" + A.makeName(VPV) + "\" IS E"
                    + TextUtil.escapeSingleQuoteForSQL(VPV._Description + " (pivot of " + VC.getAggregateName() + " on " + P._VC._SameAsObj.getShortName() + "='" + VPV._Value + "')")
                    // + TextUtil.escapeSingleQuoteForSQL("The pivoted column count from '" + P._ColumnName + "'='" + P._Values[i]._Value + "', " + P._Values[i]._Description)
                    + ";");
              }
        if (V._Formulas != null)
          for (Formula F : V._Formulas)
            if (F != null)
              OutFinal.println("COMMENT ON COLUMN " + V.getShortName() + ".\"" + F._Name + "\" IS E"
              + TextUtil.escapeSingleQuoteForSQL("The calculated formula: " + String.join("\\n", F._Description))
              + ";");
      }

    @Override
    public String getDDLMetadataVersion()
      {
        return "DDL META DATA VERSION 2019-01-09";
      }

    @Override
    public void genDDLMetadata(PrintWriter OutFinal, View V)
    throws Exception
      {
        if (V._Formulas == null || V._Formulas.isEmpty() == true)
          {
            OutFinal.println("DO $$");
            OutFinal.println("-- This view doesn't have any formula, but just in case it used to and they were all repoved from the model, we still have to do some cleanup.");
            OutFinal.println("DECLARE");
            OutFinal.println("  ts timestamp;");
            OutFinal.println("BEGIN");
            OutFinal.println("  select into ts current_timestamp;");
            OutFinal.println("  UPDATE TILDA.Formula set deleted = current_timestamp where \"location\" = " + TextUtil.escapeSingleQuoteForSQL(V.getShortName()) + " AND \"lastUpdated\" < ts;");
            OutFinal.println("END; $$");
            OutFinal.println("LANGUAGE PLPGSQL;");
            return;
          }

        // OutFinal.println("DROP TABLE IF EXISTS " + V._ParentSchema._Name + ".TildaFormulaValue;");
        // OutFinal.println("DROP TABLE IF EXISTS " + V._ParentSchema._Name + ".TildaFormulaReference;");
        // OutFinal.println("DROP TABLE IF EXISTS " + V._ParentSchema._Name + ".TildaFormula;");


        OutFinal.println("DO $$");
        OutFinal.println("-- This view has formulas and we need to update all its meta-data.");
        OutFinal.println("DECLARE");
        OutFinal.println("  k bigint;");
        OutFinal.println("  ts timestamp;");
        OutFinal.println("BEGIN");
        OutFinal.println("  select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.FORMULA', " + V._Formulas.size() + ")-" + V._Formulas.size() + ";");
        OutFinal.println("  select into ts current_timestamp;");
        OutFinal.println();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Formulas
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String RealizedTable = V._Realize == null ? null : V._ParentSchema._Name + "." + V._Name.substring(0, V._Name.length() - (V._Pivots.isEmpty() == false ? "PivotView" : "View").length()) + "Realized";
        int count = -1;
        int MeasureCount = 0;
        for (Formula F : V._Formulas)
          {
            if (F == null)
              continue;

            if (++count == 0)
              {
                OutFinal.println("INSERT INTO TILDA.Formula (\"refnum\", \"location\", \"location2\", \"name\", \"type\", \"title\", \"description\", \"formula\", \"htmlDoc\", \"referencedColumns\", \"created\", \"lastUpdated\", \"deleted\")");
                OutFinal.print("    VALUES (");
              }
            else
              {
                OutFinal.print("          ,(");
              }
            if (F._Measure == true)
              ++MeasureCount;
            OutFinal.print("k+" + count);
            OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(V.getShortName()));
            OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(RealizedTable));
            OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(F._Name));
            OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(F.getType()._ShortName));
            OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(F._Title));
            OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(String.join("\n", F._Description)));
            OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(String.join("\n", F._FormulaStrs)));
            OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL("<B>N/A</B>"));
            List<ViewColumn> L = F.getDependencyColumns();
            if (L.isEmpty() == false)
              {
                String[] VCNames = new String[L.size()];
                for (int i = 0; i < L.size(); ++i)
                  {
                    VCNames[i] =  L.get(i)._ParentView.getShortName() + "." + L.get(i)._Name;
                  }
                OutFinal.print(", ARRAY[" + TextUtil.escapeSingleQuoteForSQL(VCNames, true) + "]");
              }
            else
              {
                OutFinal.print(", null");
              }
            OutFinal.println(", current_timestamp, current_timestamp, null)");
          }
        if (count >= 0)
          {
            OutFinal.println("  ON CONFLICT(\"location\", \"name\") DO UPDATE");
            OutFinal.println("    SET \"location2\" = EXCLUDED.\"location2\"");
            OutFinal.println("      , \"type\" = EXCLUDED.\"type\"");
            OutFinal.println("      , \"title\" = EXCLUDED.\"title\"");
            OutFinal.println("      , \"description\" = EXCLUDED.\"description\"");
            OutFinal.println("      , \"formula\" = EXCLUDED.\"formula\"");
            OutFinal.println("      , \"htmlDoc\" = EXCLUDED.\"htmlDoc\"");
            OutFinal.println("      , \"referencedColumns\" = EXCLUDED.\"referencedColumns\"");
            OutFinal.println("      , \"lastUpdated\" = current_timestamp");
            OutFinal.println("      , \"deleted\" = null");
            OutFinal.println("   ;");
          }
        OutFinal.println("UPDATE TILDA.Formula set deleted = current_timestamp where \"location\" = " + TextUtil.escapeSingleQuoteForSQL(V.getShortName()) + " AND \"lastUpdated\" < ts;");
        OutFinal.println();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // FormulaResult
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        count = -1;
        for (Formula F : V._Formulas)
          {
            if (F != null && F._Values != null && F._Values.length > 0)
              for (Value Val : F._Values)
                {
                  if (++count == 0)
                    {
                      OutFinal.println("INSERT INTO TILDA.FormulaResult (\"formulaRefnum\", \"value\", \"description\", \"created\", \"lastUpdated\", \"deleted\")");
                      OutFinal.print("    VALUES (");
                    }
                  else
                    {
                      OutFinal.print("          ,(");
                    }
                  OutFinal.print("(select refnum from TILDA.Formula where \"location\" = " + TextUtil.escapeSingleQuoteForSQL(V.getShortName()) + " AND \"name\" = " + TextUtil.escapeSingleQuoteForSQL(F._Name) + ")");
                  OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(Val._Value));
                  OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(Val._Description));
                  OutFinal.println(", current_timestamp, current_timestamp, null)");
                }
          }
        if (count >= 0)
          {
            OutFinal.println("  ON CONFLICT(\"formulaRefnum\", \"value\") DO UPDATE");
            OutFinal.println("    SET \"description\" = EXCLUDED.\"description\"");
            OutFinal.println("      , \"lastUpdated\" = current_timestamp");
            OutFinal.println("      , \"deleted\" = null");
            OutFinal.println("   ;");
          }
        OutFinal.println("UPDATE TILDA.FormulaResult");
        OutFinal.println("   set deleted = current_timestamp");
        OutFinal.println(" where \"formulaRefnum\" in (select refnum");
        OutFinal.println("                               from TILDA.Formula");
        OutFinal.println("                              where \"location\" = " + TextUtil.escapeSingleQuoteForSQL(V.getShortName()));
        OutFinal.println("                                and \"deleted\" is not null");
        OutFinal.println("                            );");
        OutFinal.println();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // FormulaDependency
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        count = -1;
        for (Formula F : V._Formulas)
          {
            if (F == null)
              continue;
            for (Formula F2 : F.getDependencyFormulas())
              if (F2 != null)
                {
                  if (++count == 0)
                    {
                      OutFinal.println("INSERT INTO TILDA.FormulaDependency(\"formulaRefnum\", \"dependencyRefnum\", \"created\", \"lastUpdated\", \"deleted\")");
                      OutFinal.print("    VALUES (");
                    }
                  else
                    {
                      OutFinal.print("          ,(");
                    }
                  OutFinal.println(" (select refnum from TILDA.Formula where \"location\" = " + TextUtil.escapeSingleQuoteForSQL(V.getShortName()) + " AND \"name\" = " + TextUtil.escapeSingleQuoteForSQL(F._Name) + ")");
                  OutFinal.println("            ,(select refnum from TILDA.Formula where \"location\" = " + TextUtil.escapeSingleQuoteForSQL(V.getShortName()) + " AND \"name\" = " + TextUtil.escapeSingleQuoteForSQL(F2._Name) + ")");
                  OutFinal.println("            ,current_timestamp, current_timestamp, null");
                  OutFinal.println("           )");
                }
          }
        if (count >= 0)
          {
            OutFinal.println("  ON CONFLICT(\"formulaRefnum\", \"dependencyRefnum\") DO UPDATE");
            OutFinal.println("    SET \"lastUpdated\" = current_timestamp");
            OutFinal.println("      , \"deleted\" = null");
            OutFinal.println("   ;");
          }
        OutFinal.println("UPDATE TILDA.FormulaDependency");
        OutFinal.println("   set deleted = current_timestamp");
        OutFinal.println(" where \"formulaRefnum\" in (select refnum");
        OutFinal.println("                               from TILDA.Formula");
        OutFinal.println("                              where \"location\" = " + TextUtil.escapeSingleQuoteForSQL(V.getShortName()));
        OutFinal.println("                                and \"deleted\" is not null");
        OutFinal.println("                            );");
        OutFinal.println();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Measures
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        OutFinal.println("select into k TILDA.getKeyBatchAsMaxExclusive('TILDA.MEASURE', " + MeasureCount + ")-" + MeasureCount + ";");
        count = -1;
        for (Formula F : V._Formulas)
          if (F != null && F._Measure == true)
            {
              if (++count == 0)
                {
                  OutFinal.println("INSERT INTO TILDA.Measure (\"refnum\", \"schema\", \"name\", \"created\", \"lastUpdated\", \"deleted\")");
                  OutFinal.print("    VALUES (");
                }
              else
                {
                  OutFinal.print("          ,(");
                }
              OutFinal.print("k+" + count);
              OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(V._ParentSchema._Name));
              OutFinal.print(", " + TextUtil.escapeSingleQuoteForSQL(F._Title));
              OutFinal.println(", current_timestamp, current_timestamp, null)");
            }
        if (count >= 0)
          {
            OutFinal.println("  ON CONFLICT(\"schema\", \"name\") DO UPDATE");
            OutFinal.println("    SET \"lastUpdated\" = current_timestamp");
            OutFinal.println("      , \"deleted\" = null");
            OutFinal.println("  ;");
          }
        OutFinal.println();


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Measure formulas
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        count = -1;
        for (Formula F : V._Formulas)
          if (F != null && F._Measure == true)
            {
              if (++count == 0)
                {
                  OutFinal.println("INSERT INTO TILDA.MeasureFormula (\"measureRefnum\", \"formulaRefnum\", \"created\", \"lastUpdated\", \"deleted\")");
                  OutFinal.print("    VALUES (");
                }
              else
                {
                  OutFinal.print("          ,(");
                }
              OutFinal.println(" (select refnum from TILDA.Measure where \"name\" = " + TextUtil.escapeSingleQuoteForSQL(F._Title) + " and \"schema\" = " + TextUtil.escapeSingleQuoteForSQL(V._ParentSchema._Name) + ")");
              OutFinal.println("            ,(select refnum from TILDA.Formula where \"location\" = " + TextUtil.escapeSingleQuoteForSQL(V.getShortName()) + " AND \"name\" = " + TextUtil.escapeSingleQuoteForSQL(F._Name) + ")");
              OutFinal.println(", current_timestamp, current_timestamp, null)");
            }
        if (count >= 0)
          {
            OutFinal.println("  ON CONFLICT(\"measureRefnum\", \"formulaRefnum\") DO UPDATE");
            OutFinal.println("    SET \"lastUpdated\" = current_timestamp");
            OutFinal.println("      , \"deleted\" = null");
            OutFinal.println("  ;");
          }
        OutFinal.println();
        OutFinal.println("DELETE FROM TILDA.MeasureFormula");
        OutFinal.println(" where \"formulaRefnum\" in (select refnum");
        OutFinal.println("                               from TILDA.Formula");
        OutFinal.println("                              where \"location\" = " + TextUtil.escapeSingleQuoteForSQL(V.getShortName()));
        OutFinal.println("                                and \"deleted\" is not null");
        OutFinal.println("                            );");
        OutFinal.println();
        OutFinal.println("UPDATE TILDA.Measure");
        OutFinal.println("   set deleted = current_timestamp");
        OutFinal.println(" where \"refnum\" not in (select \"measureRefnum\" from TILDA.MeasureFormula)");
        OutFinal.println(" ;");
        OutFinal.println();

        OutFinal.println("END; $$");
        OutFinal.println("LANGUAGE PLPGSQL;");

      }

    private String genFormulaCode(View ParentView, Formula F)
      {
        String FormulaStr = TextUtil.JoinTrim(F._FormulaStrs, " ");

        if (F._Name.startsWith("x_") == true)
         LOG.debug("xxxx");
        Matcher M = F.getParentView()._ViewColumnsRegEx.matcher(FormulaStr);
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
                  ColumnType T = VC._SameAsObj == null && VC._SameAs.equals("_TS.p") == true ? ColumnType.DATE : VC._SameAsObj.getType();
                  boolean nullTest = FormulaStr.substring(M.end()).toLowerCase().matches("\\s*is\\s*(not)?\\s*null.*");
                  if (nullTest == false && (T == ColumnType.INTEGER || T == ColumnType.LONG || T == ColumnType.FLOAT || T == ColumnType.DOUBLE))
                    M.appendReplacement(Str, "coalesce(\"" + M.group(1) + "\", 0)");
                  else
                    M.appendReplacement(Str, '"' + M.group(1) + '"');
                  break;
                }
            for (Column C : ParentView._PivotColumns)
              if (s.equals(C.getName()) == true)
                {
                  ColumnType T = C.getType();
                  boolean nullTest = FormulaStr.substring(M.end()).toLowerCase().matches("\\s*is\\s*(not)?\\s*null.*");
                  if (nullTest == false && (T == ColumnType.INTEGER || T == ColumnType.LONG || T == ColumnType.FLOAT || T == ColumnType.DOUBLE))
                    M.appendReplacement(Str, "coalesce(\"" + M.group(1) + "\", 0)");
                  else
                    M.appendReplacement(Str, '"' + M.group(1) + '"');
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
                      String FormulaType = getColumnType(F2.getType(), F2._Size, null, false, F2._Precision, F2._Scale);
                      M.appendReplacement(Str, "(" + genFormulaCode(ParentView, F2) + ")::" + FormulaType);
                      break;
                    }
              }
            M.appendTail(Str);
          }
        return Str.toString();
      }

    private String genRealizedColumnList(View V, String Lead)
      {
        StringBuilder Str = new StringBuilder();
        Str.append("/*genRealizedColumnList*/");
        boolean First = true;
        boolean Blocked = false;
        // LOG.debug("View " + V._Name + ": " + TextUtil.Print(V.getColumnNames()));
        for (ViewColumn VC : V._ViewColumns)
          {
            if (V.isPivotColumn(VC) == true || V.isPivotAggregate(VC) == true)
              continue;
            if (VC == null || (VC._SameAsObj != null && VC._SameAsObj._Mode == ColumnMode.CALCULATED) || VC._JoinOnly == true || VC._FormulaOnly == true)
              {
                if (VC != null)
                  {
                    Str.append(Lead + "-- \"" + VC._Name + "\" -- " + (VC._FormulaOnly == true ? "BLOCKED" : "VIEW-EXCLUDED"));
                    Blocked = true;
                  }
                continue;
              }
            if (TextUtil.FindStarElement(V._Realize._Exclude_DEPRECATED, VC.getName(), true, 0) == -1)
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
                Str.append(/* V._ParentSchema._Name + "." + V._Name + "."+ */"\"" + VC._Name + "\" -- COLUMN");
                // else
                // Str.append(VRM.printMapping() + " -- COLUMN (REALIZE MAPPING OVERRIDE)");
              }
            else
              {
                Blocked = true;
                Str.append(Lead + "-- \"" + VC._Name + "\" -- REALIZE-EXCLUDED");
              }
          }
        for (Formula F : V._Formulas)
          {
            if (F == null)
              continue;
            if (TextUtil.FindStarElement(V._Realize._Exclude_DEPRECATED, F._Name, true, 0) == -1)
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
                Str.append("\"" + F._Name + "\" -- FORMULA");
                // else
                // Str.append(VRM.printMapping() + " -- FORMULA (REALIZE MAPPING OVERRIDE)");
              }
          }
        for (Column C : V._PivotColumns)
          {
            if (TextUtil.FindStarElement(V._Realize._Exclude_DEPRECATED, C.getName(), true, 0) != -1)
              continue;
            // ViewRealizeMapping VRM = V._Realize.getMapping(C.getName());
            // if (VRM == null)
            Str.append(Lead + ", \"" + C.getName() + "\" -- PIVOT COLUMN");
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
        Out.println("delete from TILDA.Key where \"name\" = '" + O._ParentSchema._Name + "." + O._Name.toUpperCase() + "';");
        Out.println("insert into TILDA.Key (\"refnum\", \"name\", \"max\", \"count\", \"created\", \"lastUpdated\") values ((select COALESCE(max(\"refnum\"),0)+1 from TILDA.Key), '"
        + O._ParentSchema._Name + "." + O._Name.toUpperCase() + "',(select COALESCE(max(\"refnum\"),0)+1 from " + O._ParentSchema._Name + "." + O._Name
        + "), " + O._PrimaryKey._KeyBatch + ", current_timestamp, current_timestamp);");
      }

    public static boolean PrintColumnList(PrintWriter Out, List<Column> Columns)
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
