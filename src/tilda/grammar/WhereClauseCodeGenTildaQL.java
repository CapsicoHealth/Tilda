/* ===========================================================================
 * Copyright (C) 2016 CapsicoHealth Inc.
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

package tilda.grammar;

import java.time.ZonedDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.generation.java8.JavaJDBCType;
import tilda.types.ColumnDefinition;
import tilda.utils.DateTimeUtil;
import tilda.utils.TextUtil;

public class WhereClauseCodeGenTildaQL implements WhereClauseCodeGen
  {
    protected static final Logger LOG      = LogManager.getLogger(WhereClauseCodeGenTildaQL.class.getName());

    protected StringBuilder       _CodeGen = new StringBuilder("Q");

    public String getCodeStr()
      {
        return _CodeGen.toString();
      }

    @Override
    public void boolOperatorAND(boolean not)
      {
        _CodeGen.append(not == true ? ".andNot()" : ".and()");
      }

    @Override
    public void boolOperatorOR(boolean not)
      {
        _CodeGen.append(not == true ? ".orNot()" : ".or()");
      }

    @Override
    public void boolOpenPar()
      {
        _CodeGen.append(".openPar()");
      }

    @Override
    public void boolClosePar()
      {
        _CodeGen.append(".closePar()");
      }

    protected static void makeColumn(StringBuilder Str, ColumnDefinition Col)
      {
        Str.append("COLS.").append(Col.getName());
      }

    protected static void makeColumnList(StringBuilder Str, List<ColumnDefinition> Cols)
      {
        if (Cols.size() == 1)
          {
            makeColumn(Str, Cols.get(0));
            return;
          }

        for (ColumnDefinition c : Cols)
          {
            if (Str.length() == 0)
              Str.append("new ColumnDefinition[] {");
            else
              Str.append(", ");
            makeColumn(Str, c);
          }
        Str.append("}");
      }

    @Override
    public void binLike(List<ColumnDefinition> Columns, boolean not)
      {
        _CodeGen.append(not == true ? ".notLike(" : ".like(");
        makeColumnList(_CodeGen, Columns);
        _CodeGen.append(", ");
      }

    @Override
    public void binEqual(List<ColumnDefinition> Columns, ColumnType Type, boolean not)
      {
        _CodeGen.append(not == true ? ".notEqual(" : ".equal(");
        makeColumnList(_CodeGen, Columns);
        _CodeGen.append(", ");
      }

    @Override
    public void binLessThan(List<ColumnDefinition> Columns, ColumnType Type)
      {
        _CodeGen.append(".lt(");
        makeColumnList(_CodeGen, Columns);
        _CodeGen.append(", ");
      }

    @Override
    public void binLessThanOrEqual(List<ColumnDefinition> Columns, ColumnType Type)
      {
        _CodeGen.append(".lte(");
        makeColumnList(_CodeGen, Columns);
        _CodeGen.append(", ");
      }

    @Override
    public void binGreaterThan(List<ColumnDefinition> Columns, ColumnType Type)
      {
        _CodeGen.append(".gt(");
        makeColumnList(_CodeGen, Columns);
        _CodeGen.append(", ");
      }

    @Override
    public void binGreaterThanOrEqual(List<ColumnDefinition> Columns, ColumnType Type)
      {
        _CodeGen.append(".gte(");
        makeColumnList(_CodeGen, Columns);
        _CodeGen.append(", ");
      }

    @Override
    public void binIn(List<ColumnDefinition> Columns, boolean not)
      {
        _CodeGen.append(not == true ? ".notIn(" : ".in(");
        makeColumnList(_CodeGen, Columns);
        _CodeGen.append(", ");
      }

    @Override
    public void col(ColumnDefinition Column)
      {
        makeColumn(_CodeGen, Column);
      }
    
    public void funcLen(List<ColumnDefinition> Columns)
      {
        if (Columns.size() == 1 && Columns.get(0)._Collection == true)
          {
            _CodeGen.append(".len(");
            makeColumn(_CodeGen, Columns.get(0));
            _CodeGen.append(")");
          }
        else // must be a list of Strings.
          {
            _CodeGen.append(".len(");
            makeColumnList(_CodeGen, Columns);
            _CodeGen.append(")");
          }
      }
    

    @Override
    public String binClose()
      {
        _CodeGen.append(")");
        return null;
      }


    protected final static String TYPE_MARKER = "####XXXXX####";

    @Override
    public void valueListOpen()
      {
        _CodeGen.append("new ").append(TYPE_MARKER).append("[] {");
      }

    @Override
    public void valueListSeparator()
      {
        _CodeGen.append(", ");
      }

    @Override
    public void valueLiteralNumeric(String Number)
      {
        _CodeGen.append(Number);
      }

    @Override
    public void valueLiteralString(String Str)
      {
        TextUtil.EscapeDoubleQuoteWithSlash(_CodeGen, Str);
      }

    @Override
    public void valueLiteralChar(char c)
      {
        _CodeGen.append("'").append(c).append("'");
      }


    @Override
    public void valueParameter(String Str)
      {
        _CodeGen.append(Str);
      }

    @Override
    public void valueLiteralTimestamp(ZonedDateTime ZDT)
      {
        if (ZDT == null)
          _CodeGen.append("INVALID_TIMESTAMP_LITERAL");
        else
          _CodeGen.append("DateTimeUtil.parsefromJSON(\"" + DateTimeUtil.printDateTimeForJSON(ZDT) + "\")");
      }

    @Override
    public void valueTimestampCurrent()
      {
        _CodeGen.append("DateTimeUtil.NOW_PLACEHOLDER_ZDT");
      }

    @Override
    public void valueTimestampYesterday(boolean first)
      {
        _CodeGen.append("DateTimeUtil.getYesterdayTimestamp(").append(first).append(")");
      }

    @Override
    public void valueTimestampToday(boolean first)
      {
        _CodeGen.append("DateTimeUtil.getTodayTimestamp(").append(first).append(")");
      }

    @Override
    public void valueTimestampTomorrow(boolean first)
      {
        _CodeGen.append("DateTimeUtil.getTomorrowTimestamp(").append(first).append(")");
      }



    @Override
    public String valueListClose(ColumnType Type)
      {
        int i = _CodeGen.indexOf(TYPE_MARKER);
        if (i == -1)
          return "Closing a value list without having a Type marker in the codeGen string!!!!";

        _CodeGen.replace(i, i + TYPE_MARKER.length(), JavaJDBCType.get(Type)._JavaType);
        _CodeGen.append("}");
        return null;
      }

    @Override
    public void arithmeticOpenPar()
      {
        _CodeGen.append("(");
      }

    @Override
    public void arithmeticClosePar()
      {
        _CodeGen.append(")");
      }

    @Override
    public void arithmeticPlus(boolean minus)
      {
        _CodeGen.append(minus == true ? "-" : "+");
      }

    @Override
    public void arithmeticMultiply(boolean division)
      {
        _CodeGen.append(division == true ? "/" : "*");
      }

    @Override
    public void end()
      {
      }

    @Override
    public void isNull(ColumnDefinition Col, boolean not, boolean orEmpty)
      {
        /*@formatter:off*/
        _CodeGen.append(not==true ? (orEmpty==true ? ".isNotNullOrEmpty(" : ".isNotNull(")
                                  : (orEmpty==true ? ".isNullOrEmpty("    : ".isNull("   )
                       );
        /*@formatter:on*/
        makeColumn(_CodeGen, Col);
        _CodeGen.append(")");
      }

  }
