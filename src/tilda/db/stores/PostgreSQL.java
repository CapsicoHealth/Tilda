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

package tilda.db.stores;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import tilda.db.Connection;
import tilda.enums.ColumnMode;
import tilda.enums.ColumnType;
import tilda.generation.Generator;
import tilda.generation.interfaces.CodeGenSql;
import tilda.generation.postgres9.PostgresType;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.parsing.parts.View;
import tilda.parsing.parts.helpers.ValueHelper;
import tilda.utils.TextUtil;

public class PostgreSQL implements DBType
  {
    @Override
    public boolean isErrNoData(String SQLState, int ErrorCode)
      {
        return SQLState.equals("23505");
      }


    @Override
    public String getCurrentTimestampStr()
      {
        return "statement_timestamp()";
      }


    @Override
    public String getName()
      {
        return "PostgreSQL";
      }

    protected static final String[] _LOCK_CONN_ERROR_SUBSTR = { "deadlocked on lock"
        , "lock request time out"
        , "lock inconsistency found"
        , "connection reset"
        , "connection is closed"
        };

    @Override
    public boolean isLockOrConnectionError(SQLException E)
      {
        return TextUtil.indexOf(E.getMessage().toLowerCase(), _LOCK_CONN_ERROR_SUBSTR);
      }
    
    @Override
    public boolean needsSavepoint()
      {
        return true;
      }

    @Override
    public boolean supportsSelectSubsetting()
      {
        return true;
      }

    @Override
    public boolean getSelectSubsettingClause(StringBuilder Str, int Start, int Size)
      {
        if (Start <= 0 && Size <= 0)
         return false;
        
        if (Size <= 0)
         Str.append(" LIMIT ALL");
        else
         Str.append(" LIMIT ").append(Size);
        if (Start > 0)
         Str.append(" OFFSET "+Start);

        return true;
      }
    
    @Override
    public boolean FullIdentifierOnUpdate()
      {
        return true;
      }

    @Override
    public CodeGenSql getSQlCodeGen()
      {
        return new tilda.generation.postgres9.Sql();
      }

    @Override
    public boolean createSchema(Connection Con, Schema S) throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        getSQlCodeGen().genFileStart(Out, S);
        return Con.ExecuteUpdate(S.getShortName(), Str.toString()) >= 0;
      }

    @Override
    public boolean createTable(Connection Con, Object Obj) throws Exception
      {
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getFullTableDDL(getSQlCodeGen(), Out, Obj);
        return Con.ExecuteUpdate(Obj.getShortName(), Str.toString()) >= 0;
      }

    @Override
    public boolean createView(Connection Con, View V, boolean Drop) throws Exception
      {
        if (Drop == true)
          {
            Con.ExecuteUpdate(V.getShortName(), "DROP VIEW "+V.getShortName()+" CASCADE");
          }
        StringWriter Str = new StringWriter();
        PrintWriter Out = new PrintWriter(Str);
        Generator.getFullViewDDL(getSQlCodeGen(), Out, V);
        return Con.ExecuteUpdate(V.getShortName(), Str.toString()) >= 0;
      }

    @Override
    public boolean alterTableAddColumn(Connection Con, Column Col, String DefaultValue) throws Exception
      {
        if (Col._Nullable == false && DefaultValue == null)
         throw new Exception("Cannot add a new 'not null' column to a table without a default value. Add a default value in the model, or manually migrate your database.");
        String Q ="ALTER TABLE "+Col._ParentObject.getShortName()+" ADD COLUMN \""+Col.getName()+"\" "+getColumnType(Col._Type, Col._Size, Col._Mode, Col.isCollection());
        if (Col._Nullable == false)
          {
            Q+=" not null DEFAULT "+ValueHelper.printValue(Col, DefaultValue);
          }
           
        return Con.ExecuteUpdate(Col._ParentObject.getShortName(), Q) >= 0;
      }
    
    public static String getColumnType(ColumnType T, Integer S, ColumnMode M, boolean Collection)
      {
        if (T == ColumnType.STRING && M != ColumnMode.CALCULATED)
          return Collection == true ? "text[]" : S < 15 ? PostgresType.CHAR._SQLType + "(" + S + ")" : S < 4096 ? PostgresType.STRING._SQLType + "(" + S + ")" : "text";
        return PostgresType.get(T)._SQLType + (Collection == true ? "[]" : "");
      }
    
  }
