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

package tilda.generation.sqlserver2014;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.StringBuilderWriter;

import tilda.db.stores.MSSQL;
import tilda.enums.AggregateType;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.enums.DBStringType;
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
import tilda.utils.TextUtil;

public class Sql extends MSSQL implements CodeGenSql
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
        return "[" + C._ParentObject.getSchema()._Name + (i >= 2 ? "_" : "].[") + C._ParentObject.getBaseName() + (i >= 2 ? i : "") + "].[" + C.getName() + "]";
      }

    @Override
    public String getShortColumnVar(Column C)
      {
        return "[" + C.getName() + "]";
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
    public String getColumnType(Column C)
      {
        return getColumnType(C.getType(), C._Size, C._Mode, C.isCollection());
      }

    @Override
    public String getColumnType(Column C, ColumnType AggregateType)
      {
        return getColumnType(AggregateType, C._Size, C._Mode, C.isCollection());
      }

    @Override
    public String getColumnTypeRaw(Column C, boolean MultiOverride)
      {
        if (C.getType() == ColumnType.STRING && C._Mode != ColumnMode.CALCULATED)
          {
            DBStringType DBT = getDBStringType(C._Size);
            return C.isCollection() == true || MultiOverride == true ? "nvarchar(max)"
            : DBT == DBStringType.CHARACTER ? SQLServerType.CHAR._SQLType
            : DBT == DBStringType.VARCHAR ? SQLServerType.STRING._SQLType
            : "nvarchar(max)";
          }
        if (C.getType() == ColumnType.JSON)
          return "jsonb";
        return C.isCollection() == true ? SQLServerType.get(C.getType())._SQLArrayType : SQLServerType.get(C.getType())._SQLType;
      }

    @Override
    public String getColumnTypeRaw(ColumnType Type, int Size, boolean isArray)
      {
        if (Type == ColumnType.STRING)
          {
            DBStringType DBT = getDBStringType(Size);
            return isArray == true ? "text"
            : DBT == DBStringType.CHARACTER ? SQLServerType.CHAR._SQLType
            : DBT == DBStringType.VARCHAR ? SQLServerType.STRING._SQLType
            : "text";
          }
        return isArray == true ? SQLServerType.get(Type)._SQLArrayType : SQLServerType.get(Type)._SQLType;
      }


    @Override
    public boolean stringNeedsTrim(Column C)
      {
        return C.getType() == ColumnType.STRING && C._Mode != ColumnMode.CALCULATED && C.isCollection() == false && C._Size < 15;
      }

    @Override
    public boolean stringArrayAggNeedsText(ViewColumn VC)
      {
        // Arrays are not supported in SALServer and the future logic of CSV-serialization of an array to varchar(max) will need more care.
        throw new UnsupportedOperationException();
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
        return "= current_timestamp";
      }

    public String getCommaCurentTimestamp()
      {
        return ", current_timestamp";
      }
    
    @Override
    public String getEqualCurentDateTime()
      {
        return "= current_datetime";
      }

    @Override
    public String getCommaCurentDateTime()
      {
        return ", current_datetime";
      }
    

    @Override
    public void genFileStart(PrintWriter Out, Schema S)
    throws Exception
      {
        Out.println("create schema " + S._Name + ";");
      }

    @Override
    public void genClassStart(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
      }

    @Override
    public void genDDL(PrintWriter Out, Object O)
      {
        Out.println("create table [" + O._ParentSchema._Name + "].[" + O._Name + "] -- " + O._Description);
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
                Out.println(") REFERENCES [" + FK._DestObjectObj._ParentSchema._Name + "].[" + FK._DestObjectObj._Name + "] ON DELETE No Action ON UPDATE No Action");
              }
        Out.println(" );");
      }

    @Override
    public void genDDL(PrintWriter OutFinal, View V)
    throws Exception
      {
        StringBuilderWriter OutStr = new StringBuilderWriter();
        PrintWriter Out = new PrintWriter(OutStr);
        boolean hasAggregates = false;

        Object ObjectMain = V._ViewColumns.get(0)._SameAsObj._ParentObject;
        Out.println("-- " + TextUtil.escapeSingleQuoteForSQL(V._Description));
        Out.print("select ");
        boolean First = true;
        Map<String, Integer> M = new HashMap<String, Integer>();
        for (ViewColumn C : V._ViewColumns)
          {
            if (C == null)
              continue;
            if (C._Aggregate == AggregateType.COUNT || C._SameAsObj._Mode != ColumnMode.CALCULATED && C._JoinOnly == false)
              {
                if (First == true)
                  First = false;
                else
                  Out.print(", ");

                if (C._Aggregate == AggregateType.COUNT)
                  {
                    Out.print("count(*) as \"" + C.getName() + "\"");
                  }
                else
                  {
                    if (ObjectMain._Name.equals(C._SameAsObj._ParentObject._Name) == true)
                      {
                        Object FKObj = C._SameAsObj.getSingleColFK();
                        if (FKObj != null)
                          {
                            Integer I = M.get(FKObj._Name);
                            I = Integer.valueOf(I == null ? 1 : I.intValue() + 1);
                            M.put(FKObj._Name, I);
                          }
                      }

                    if (C._Aggregate != null)
                      {
                        Out.print(getAggregateStr(C._Aggregate) + "(");
                        hasAggregates = true;
                      }
                    Integer I = M.get(C._SameAsObj._ParentObject._Name);
                    if (I != null && I.intValue() > 1)
                      {
                        Out.print(getFullColumnVar(C._SameAsObj, I.intValue()));
                      }
                    else
                      {
                        Out.print(getFullColumnVar(C._SameAsObj));
                      }
                    if (C._Aggregate != null)
                      Out.print(")");
                    Out.print(" as [" + C.getName() + "]");
                  }
              }
          }
        Out.println();
        Set<String> Names = new HashSet<String>();
        List<Object> Objects = new ArrayList<Object>();
        Out.println("     from " + getFullTableVar(ObjectMain));
        Names.add(ObjectMain.getFullName());
        Objects.add(ObjectMain);
        for (ViewColumn C : V._ViewColumns)
          if (C != null)
            {
              Object T = C._SameAsObj._ParentObject;
              if (Names.add(T.getFullName()) == true)
                {
                  ViewJoin VJ = V.getViewjoin(T.getBaseName(), C._As);
                  if (VJ != null)
                    {
                      Out.print("     " + (C._Join == null ? "left" : C._Join) + " join " + getFullTableVar(VJ._ObjectObj));
                      Query Q = VJ.getQuery(this);
                      if (Q == null)
                        throw new Exception("Cannot generate the view because an 'on' clause matching the active database '" + getName() + "' is not available.");
                      Out.print(" on " + Q._ClauseStatic);
                      Integer I = M.get(VJ._ObjectObj._Name);
                      if (I != null)
                        for (int i = 2; i <= I.intValue(); ++i)
                          {
                            Out.println();
                            Out.print("     " + (C._Join == null ? "left" : C._Join) + " join " + getFullTableVar(VJ._ObjectObj));
                            Out.print(" as " + getFullTableVar(C._SameAsObj._ParentObject, I.intValue()));
                            Out.print(" on " + Q._ClauseStatic);
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
              Out.print("     where " + q._ClauseStatic);
            Out.println();
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

        OutFinal.println("create view [" + V._ParentSchema._Name + "].[" + V._Name + "] as ");
        String Str = OutStr.toString();
        OutFinal.print(Str);
        Str = Str.replaceAll("\n", "\\n");
        // Out.println("COMMENT ON VIEW " + V._ParentSchema._Name + "." + V._Name + " IS " + TextUtil.escapeSingleQuoteForSQL(Str) + ";");
        OutStr.close();
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
                    Out.print("     " + (C._Join == null ? "left" : C._Join) + " join " + getFullTableVar(Obj2));
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
                        Out.print("     " + (C._Join == null ? "inner" : C._Join) + " join " + getFullTableVar(Obj2));
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
        throw new UnsupportedOperationException();
//        String DDLStr = alterTableAddIndexDDL(I);
//        Out.print(DDLStr);
      }

    @Override
    public void genKeysManagement(PrintWriter Out, Object O)
      {
        Out.println("delete from [TILDA].[Key] where \"name\" = '" + O._ParentSchema._Name + "." + O._Name.toUpperCase() + "';");
        Out.println("insert into [TILDA].[Key] (\"refnum\", \"name\", \"max\", \"count\", \"created\", \"lastUpdated\") values ((select COALESCE(max(\"refnum\"),0)+1 from [TILDA].[Key]), '"
        + O._ParentSchema._Name + "." + O._Name.toUpperCase() + "',(select COALESCE(max(\"refnum\"),0)+1 from [" + O._ParentSchema._Name + "].[" + O._Name + "]"
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

    @Override
    public Query genViewJoin(StringBuilder Str, ViewJoin VJ)
    throws Exception
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public String getDDLMetadataVersion()
      {
        throw new UnsupportedOperationException();
      }

    @Override
    public void genDDLComments(PrintWriter Out, View V)
    throws Exception
      {
        // TODO Auto-generated method stub
        
      }

  }
