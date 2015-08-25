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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.PostgreSQL;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Query;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.ViewColumn;
import tilda.parsing.parts.ViewJoin;
import tilda.utils.PaddingTracker;

public class Sql extends PostgreSQL implements CodeGenSql
  {
    protected static final Logger LOG = LogManager.getLogger(Sql.class.getName());

    @Override
    public String getFileName(Base O)
      {
        return "TILDA___" + getName() + "." + O.getSchema()._Name + ".sql";
      }

    @Override
    public String getFullTableVar(Object O)
      {
        return O._ParentSchema._Name + "." + O._Name;
      }

    @Override
    public String getFullColumnVar(Column C)
      {
        return C._ParentObject.getSchema()._Name + "." + C._ParentObject.getBaseName() + ".\"" + C.getBaseName() + "\"";
      }

    @Override
    public String getShortColumnVar(Column C)
      {
        return "\"" + C.getBaseName() + "\"";
      }

    @Override
    public String getColumnType(Column C)
      {
        return getColumnType(C._Type, C._Size, C._Mode, C.isCollection());
      }

    @Override
    public String getColumnTypeRaw(Column C)
      {
        if (C._Type == ColumnType.STRING && C._Mode != ColumnMode.CALCULATED)
          return C.isCollection() == true ? "text" : C._Size < 15 ? PostgresType.CHAR._SQLType : C._Size < 4096 ? PostgresType.STRING._SQLType : "text";
        return PostgresType.get(C._Type)._SQLType;
      }

    @Override
    public boolean stringNeedsTrim(Column C)
      {
        return C._Type == ColumnType.STRING && C._Mode != ColumnMode.CALCULATED && C.isCollection() == false && C._Size < 15;
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


    public String getEqualCurentTimestamp()
      {
        return "= statement_timestamp()";
      }

    public String getCommaCurentTimestamp()
      {
        return ", statement_timestamp()";
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
      }

    protected static String getAggregateStr(AggregateType AT)
      {
        switch (AT)
          {
            case AVG: return "avg";
            case DEV: return "stddev";
            case MAX: return "max";
            case MIN: return "min";
            case SUM: return "sum";
            case VAR: return "variance";
            default: throw new Error("Cannot convert AggregateType "+AT+" to a database aggregate function name.");
          }
      }

    @Override
    public void genDDL(PrintWriter Out, View V)
      {
        Out.println("create or replace view " + V._ParentSchema._Name + "." + V._Name + " -- " + V._Description);
        Out.print("  as select ");
        boolean First = true;
        for (ViewColumn C : V._ViewColumns)
          if (C != null && C._SameAsObj._Mode != ColumnMode.CALCULATED && C._JoinOnly == false)
            {
              if (First == true)
                First = false;
              else
                Out.print(", ");
              if (C._Aggregate != null)
                Out.print(getAggregateStr(C._Aggregate) + "(");
              Out.print(getFullColumnVar(C._SameAsObj));
              if (C._Aggregate != null)
                Out.print(")");
              if (C._Aliased == true)
                Out.print(" as \"" + C.getName() + "\"");
            }
        Out.println();
        Set<String> Names = new HashSet<String>();
        List<Object> Objects = new ArrayList<Object>();
        Object ObjectMain = V._ViewColumns.get(0)._SameAsObj._ParentObject;
        Out.println("     from " + ObjectMain.getShortName());
        Names.add(ObjectMain.getFullName());
        Objects.add(ObjectMain);
        for (ViewColumn C : V._ViewColumns)
          if (C != null)
            {
              Object T = C._SameAsObj._ParentObject;
              if (Names.add(T.getFullName()) == true)
                {
                  ViewJoin VJ = V.getViewjoin(T.getBaseName());
                  if (VJ != null)
                    {
                      Out.print("     " + (C._Join == null ? "left" : C._Join) + " join " + VJ._ObjectObj.getShortName() + " on " + VJ._On);
                    }
                  else
                    {
                      Object FoundFK = null;
                      for (Object Obj : Objects)
                        if (CheckFK(Out, Obj, T, C) == true)
                          {
                            if (FoundFK != null)
                              throw new Error("Object " + T.getFullName() + " has an FK to both " + FoundFK.getFullName() + " and " + Obj.getFullName() + ", which makes creating a view ambiguous.");
                            FoundFK = Obj;
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
              Out.print("     where " + q._Clause);
            Out.println();
          }
        if (V._GroupBy != null)
          {
            Out.print("     group by ");
            First = true;
            for (Column C : V._GroupBy._GroupByObjs)
              if (C != null)
                {
                  if (First == true)
                    First = false;
                  else
                    Out.print(", ");
                  Out.print(getFullColumnVar(C));
                }
            Out.println();
          }
        Out.println("    ;");
      }

    private boolean CheckFK(PrintWriter Out, Object Obj1, Object Obj2, ViewColumn C)
      {
        boolean Found = false;
        for (ForeignKey FK : Obj2._ForeignKeys)
          if (FK._DestObjectObj == Obj1)
            {
              Out.print("     " + (C._Join == null ? "left" : C._Join) + " join " + Obj2.getShortName() + " on ");
              for (int i = 0; i < FK._SrcColumnObjs.size(); ++i)
                {
                  if (i != 0)
                    Out.print(" AND ");
                  Out.print(getFullColumnVar(FK._SrcColumnObjs.get(i)) + "=" + getFullColumnVar(Obj1._PrimaryKey._ColumnObjs.get(i)));
                }
              Out.println();
              Found = true;
              break;
            }
        if (Found == false)
          {
            for (ForeignKey FK : Obj1._ForeignKeys)
              if (FK._DestObjectObj == Obj2)
                {
                  Out.print("     " + (C._Join == null ? "inner" : C._Join) + " join " + Obj2.getShortName() + " on ");
                  for (int i = 0; i < FK._SrcColumnObjs.size(); ++i)
                    {
                      if (i != 0)
                        Out.print(" AND ");
                      Out.print(getFullColumnVar(FK._SrcColumnObjs.get(i)) + "=" + getFullColumnVar(Obj2._PrimaryKey._ColumnObjs.get(i)));
                    }
                  Out.println();
                  Found = true;
                  break;
                }
          }
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
