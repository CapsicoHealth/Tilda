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
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.stores.PostgreSQL;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenSql;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.ForeignKey;
import tilda.parsing.parts.Index;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.utils.PaddingTracker;

public class Sql extends PostgreSQL implements CodeGenSql
  {
    protected static final Logger LOG = LogManager.getLogger(Sql.class.getName());

    @Override
    public String getFileName(Object O)
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
        return C._ParentThing.getSchema()._Name + "." + C._ParentThing.getBaseName() + ".\"" + C._Name + "\"";
      }

    @Override
    public String getShortColumnVar(Column C)
      {
        return "\"" + C._Name + "\"";
      }

    @Override
    public String getColumnType(Column C)
      {
        return getColumnType(C._Type, C._Size, C._Mode, C.isCollection());
      }

    public String getColumnType(ColumnType T, Integer S, ColumnMode M, boolean Collection)
      {
        if (T == ColumnType.STRING && M != ColumnMode.CALCULATED)
          return Collection == true ? "text[]" : S < 15 ? PostgresType.CHAR._SQLType + "(" + S + ")" : S < 4096 ? PostgresType.STRING._SQLType + "(" + S + ")" : "text";
        return PostgresType.get(T)._SQLType + (Collection == true ? "[]" : "");
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
    public void genDDL(PrintWriter Out, GeneratorSession G, Object O)
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
              Out.print("\"" + C._Name + "\"" + O._PadderColumnNames.getPad(C._Name) + "  " + PadderColumnTypes.pad(getColumnType(C)));
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

    @Override
    public void genIndex(PrintWriter Out, GeneratorSession G, Index I)
      {
        if (I._Db == false)
          Out.print("-- app-level index only -- ");
        Out.print("CREATE" + (I._Unique == true ? " UNIQUE" : "") + " INDEX " + I._ParentThing.getBaseName() + "_" + I._Name + " ON " + I._ParentThing.getShortName() + " (");
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
                Out.print("\"" + I._OrderByObjs.get(i)._Name + "\" " + I._OrderByOrders.get(i));
              }
          }
        Out.println(");");
      }

    @Override
    public void genKeysManagement(PrintWriter Out, GeneratorSession G, Object O)
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
            Out.print("\"" + C._Name + "\"");
          }
        return First != true;
      }

    @Override
    public void genClassEnd(PrintWriter Out, GeneratorSession G)
      throws Exception
      {
      }
  }
