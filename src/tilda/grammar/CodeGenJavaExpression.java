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
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.generation.java8.JavaJDBCType;
import tilda.types.ColumnDefinition;
import tilda.utils.CompareUtil;
import tilda.utils.DateTimeUtil;
import tilda.utils.TextUtil;

public class CodeGenJavaExpression implements CodeGen
  {
    protected static final Logger LOG      = LogManager.getLogger(CodeGenJavaExpression.class.getName());

    protected StringBuilder       _CodeGen = new StringBuilder();

    @Override
    public void boolOperatorAND(boolean not)
      {
        _CodeGen.append(not == true ? " && ! " : " && ");
      }

    @Override
    public void boolOperatorOR(boolean not)
      {
        _CodeGen.append(not == true ? " || ! " : " || ");
      }

    @Override
    public void boolOpenPar()
      {
        _CodeGen.append("(");
      }

    @Override
    public void boolClosePar()
      {
        _CodeGen.append(")");
      }

    protected static void makeColumn(StringBuilder Str, ColumnDefinition Col)
      {
        Str.append("obj.get").append(Col.getName()).append("()");
      }

    protected static void binOperatorLHS(StringBuilder Str, List<ColumnDefinition> Columns)
      {
        boolean First = true;
        for (ColumnDefinition Col : Columns)
          {
            if (First == true)
              First = false;
            else
              Str.append("+");
            makeColumn(Str, Col);
          }
      }

    protected static void binOperator(StringBuilder Str, String Op, List<ColumnDefinition> Columns)
      {
        binOperatorLHS(Str, Columns);
        Str.append(Op);
      }

    protected Deque<String> _BinCloseSequences = new ArrayDeque<String>();

    @Override
    public void binLike(List<ColumnDefinition> Columns, boolean not)
      {
        _CodeGen.append(" CompareUtils.like(");
        binOperatorLHS(_CodeGen, Columns);
        _CodeGen.append(", ");
        _BinCloseSequences.push(") == " + !not);
      }

    @Override
    public void binEqual(List<ColumnDefinition> Columns, ColumnType Type, boolean not)
      {
        if (Type._Primitive == true)
          {
            binOperator(_CodeGen, not == true ? " != " : " == ", Columns);
            _BinCloseSequences.push("");
          }
        else
          {
            _CodeGen.append(" CompareUtils.equals(");
            binOperatorLHS(_CodeGen, Columns);
            _CodeGen.append(", ");
            _BinCloseSequences.push(") == " + !not);
          }
      }

    @Override
    public void binLessThan(List<ColumnDefinition> Columns, ColumnType Type)
      {
        if (Type._Primitive == true)
          {
            binOperator(_CodeGen, " < ", Columns);
            _BinCloseSequences.push("");
          }
        else
          {
            _CodeGen.append(" CompareUtils.compare(");
            binOperatorLHS(_CodeGen, Columns);
            _CodeGen.append(", ");
            _BinCloseSequences.push(") < 0");
          }
      }

    @Override
    public void binLessThanOrEqual(List<ColumnDefinition> Columns, ColumnType Type)
      {
        if (Type._Primitive == true)
          {
            binOperator(_CodeGen, " <= ", Columns);
            _BinCloseSequences.push("");
          }
        else
          {
            _CodeGen.append(" CompareUtils.compare(");
            binOperatorLHS(_CodeGen, Columns);
            _CodeGen.append(", ");
            _BinCloseSequences.push(") <= 0");
          }
      }

    @Override
    public void binGreaterThan(List<ColumnDefinition> Columns, ColumnType Type)
      {
        if (Type._Primitive == true)
          {
            binOperator(_CodeGen, " > ", Columns);
            _BinCloseSequences.push("");
          }
        else
          {
            _CodeGen.append(" CompareUtils.compare(");
            binOperatorLHS(_CodeGen, Columns);
            _CodeGen.append(", ");
            _BinCloseSequences.push(") > 0");
          }
      }

    @Override
    public void binGreaterThanOrEqual(List<ColumnDefinition> Columns, ColumnType Type)
      {
        if (Type._Primitive == true)
          {
            binOperator(_CodeGen, " > ", Columns);
            _BinCloseSequences.push("");
          }
        else
          {
            _CodeGen.append(" CompareUtils.compare(");
            binOperatorLHS(_CodeGen, Columns);
            _CodeGen.append(", ");
            _BinCloseSequences.push(") >= 0");
          }
      }

    @Override
    public void binIn(List<ColumnDefinition> Columns, boolean not)
      {
        _CodeGen.append(" CompareUtils.in(");
        binOperatorLHS(_CodeGen, Columns);
        _CodeGen.append(", ");
        _BinCloseSequences.push(") == " + !not);
      }

    @Override
    public void col(ColumnDefinition Column)
      {
        makeColumn(_CodeGen, Column);
      }

    @Override
    public String binClose()
      {
        if (_BinCloseSequences.isEmpty() == true)
          return "Closing a bin expression without a closing sequence in the stack.";
        _CodeGen.append(_BinCloseSequences.pop());
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


    /*@formatter:off*/
    protected static class TestObject
     {
       public char          getCLM_TYPE              () { return 0   ; }
       public String        getPRVDR_CLASS           () { return null; }
       public String        getPRIMARY_ICD9_DGNS_CD  () { return null; }
       public List<String>  getSECONDARY_ICD9_DGNS_CD() { return null; }
       public String        getPRIMARY_ICD9_PRCDR_CD () { return null; }
       public ZonedDateTime getBENE_BIRTH_DT         () { return null; }
       public float         getCLM_PMT_AMT           () { return 0   ; }
     }
    /*@formatter:on*/

    protected static void test(TestObject obj, int var1)
      {
      /*@formatter:off*/
      boolean x =     obj.getCLM_TYPE() > 'I' 
                  &&  CompareUtil.equals(obj.getPRVDR_CLASS(), "Abc") == true 
                  &&  CompareUtil.equals(obj.getPRVDR_CLASS(), obj.getCLM_TYPE()) == true 
                  && (   (   CompareUtil.like(obj.getPRIMARY_ICD9_DGNS_CD(), "410.%") == true 
                          && CompareUtil.like(obj.getPRIMARY_ICD9_DGNS_CD(), "410._2") == false
                         ) 
                      || (   CompareUtil.like(obj.getSECONDARY_ICD9_DGNS_CD(), "410.%") == true 
                          && CompareUtil.like(obj.getSECONDARY_ICD9_DGNS_CD(), "410._2") == false
                         ) 
                      || CompareUtil.in(obj.getPRIMARY_ICD9_DGNS_CD()+obj.getPRIMARY_ICD9_PRCDR_CD(), new String[] {"428.5", "428.54", "1"}) == true
                     ) 
                  && CompareUtil.in(obj.getPRIMARY_ICD9_PRCDR_CD(), new String[] {"234.23", "11.22"}) == false 
                  && (   CompareUtil.equals(obj.getBENE_BIRTH_DT(), DateTimeUtil.parsefromJSON("2001-03-11T00:00:00-05:00[America/New_York]")) == true 
                      || CompareUtil.equals(obj.getBENE_BIRTH_DT(), DateTimeUtil.parsefromJSON("2001-03-11T22:00:00-05:00[America/New_York]")) == true 
                      || CompareUtil.equals(obj.getBENE_BIRTH_DT(), DateTimeUtil.parsefromJSON("2001-06-11T22:00:30-04:00[America/New_York]")) == true 
                      || CompareUtil.equals(obj.getBENE_BIRTH_DT(), DateTimeUtil.parsefromJSON("2001-03-11T22:00:30Z")) == true 
                      || CompareUtil.equals(obj.getBENE_BIRTH_DT(), DateTimeUtil.NOW_PLACEHOLDER_ZDT) == true 
                      || CompareUtil.equals(obj.getBENE_BIRTH_DT(), DateTimeUtil.getTodayTimestamp(false)) == true
                     ) 
                  && (obj.getCLM_PMT_AMT() > 2*((5+(var1+1))))
                  ;
      /*@formatter:on*/
      }

  }
