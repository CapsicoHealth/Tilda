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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.generation.java8.JavaJDBCType;
import tilda.grammar.TildaSQLParser.ArythExprContext;
import tilda.grammar.TildaSQLParser.Aryth_expr_subContext;
import tilda.grammar.TildaSQLParser.Aryth_op_addContext;
import tilda.grammar.TildaSQLParser.Aryth_op_mulContext;
import tilda.grammar.TildaSQLParser.Bin_exprContext;
import tilda.grammar.TildaSQLParser.Bool_expr_subContext;
import tilda.grammar.TildaSQLParser.Bool_opContext;
import tilda.grammar.TildaSQLParser.ColumnContext;
import tilda.grammar.TildaSQLParser.ValueBindParamContext;
import tilda.grammar.TildaSQLParser.ValueNumericLiteralContext;
import tilda.grammar.TildaSQLParser.ValueStringLiteralContext;
import tilda.grammar.TildaSQLParser.ValueTimestampLiteralContext;
import tilda.grammar.TildaSQLParser.Value_listContext;
import tilda.types.ColumnDefinition;
import tilda.utils.Counter;
import tilda.utils.DateTimeUtil;
import tilda.utils.ParseUtil;

public class TildaSQLCodeGenListener extends TildaSQLBaseListener
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQLCodeGenListener.class.getName());


    public TildaSQLCodeGenListener(Parser parser)
      {
        _Parser = parser;
      }

    public void setColumnEnvironment(List<ColumnDefinition> Columns)
      {
        _Columns = Columns;
      }


    protected Parser        _Parser;
    List<ColumnDefinition>  _Columns = new ArrayList<ColumnDefinition>();
    protected StringBuilder _CodeGen = new StringBuilder("Q");
    protected List<String>  _Errors  = new ArrayList<String>();

    protected void addError(String err, ParserRuleContext ctx)
      {
        err += " (line " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() + ")";
        _Errors.add(err);
        LOG.error(err);
      }

    public Iterator<String> getErrors()
      {
        return _Errors.isEmpty() == true ? null : _Errors.iterator();
      }

    @Override
    public void enterBool_op(Bool_opContext ctx)
      {
        if (ctx.K_AND() != null)
          _CodeGen.append(ctx.K_NOT() == null ? ".and()" : ".andNot()");
        else if (ctx.K_OR() != null)
          _CodeGen.append(ctx.K_NOT() == null ? ".or()" : ".orNot()");
        else
          addError("Unknown boolean operator " + ctx.getText(), ctx);

        super.enterBool_op(ctx);
      }

    @Override
    public void enterBool_expr_sub(Bool_expr_subContext ctx)
      {
        _CodeGen.append(".openPar()");
        super.enterBool_expr_sub(ctx);
      }

    @Override
    public void exitBool_expr_sub(Bool_expr_subContext ctx)
      {
        _CodeGen.append(".closePar()");
        super.exitBool_expr_sub(ctx);
      }


    protected final static String TYPE_MARKER = "####XXXXX####";

    @Override
    public void enterBin_expr(Bin_exprContext ctx)
      {
        String LHS;
        if (ctx.bin_expr_lhs().column().size() == 1)
          LHS = "COLS." + ctx.bin_expr_lhs().column(0).getText();
        else
          {
            StringBuilder Str = new StringBuilder();
            for (ColumnContext colCtx : ctx.bin_expr_lhs().column())
              {
                if (Str.length() == 0)
                  Str.append("new COLS[] {");
                else
                  Str.append(", ");
                Str.append("COLS.").append(colCtx.getText());
              }
            Str.append("}");
            LHS = Str.toString();
          }
        if (ctx.bin_op() != null)
          {
            if (ctx.bin_op().K_NOT() != null) // not like
              {
                _CodeGen.append(".notLike(").append(LHS).append(", ");
              }
            else if (ctx.bin_op().K_LIKE() != null) // like
              {
                _CodeGen.append(".like(").append(LHS).append(", ");
              }
            else if (ctx.bin_op().K_EQ() != null) // equal
              {
                _CodeGen.append(".equal(").append(LHS).append(", ");
              }
            else if (ctx.bin_op().K_NEQ() != null) // not equal
              {
                _CodeGen.append(".notEqual(").append(LHS).append(", ");
              }
            else if (ctx.bin_op().K_LT() != null) // less than
              {
                _CodeGen.append(".lt(").append(LHS).append(", ");
              }
            else if (ctx.bin_op().K_LTE() != null) // less than or equal
              {
                _CodeGen.append(".lte(").append(LHS).append(", ");
              }
            else if (ctx.bin_op().K_GT() != null) // greater than
              {
                _CodeGen.append(".gt(").append(LHS).append(", ");
              }
            else if (ctx.bin_op().K_GTE() != null) // greater than or equal
              {
                _CodeGen.append(".gte(").append(LHS).append(", ");
              }
            else
              addError("Unknown binary operator " + ctx.bin_op().getText(), ctx);
          }
        else if (ctx.K_IN() != null) // greater than or equal
          {
            _CodeGen.append(".in(").append(LHS).append(", ");
          }
        else
          addError("Unparsable binary expression " + ctx.getText(), ctx);

        if (ctx.column() != null)
          {
            _CodeGen.append("COLS.").append(ctx.column().getText());
          }

        super.enterBin_expr(ctx);
      }

    @Override
    public void exitBin_expr(Bin_exprContext ctx)
      {
        _CodeGen.append(")");
        super.exitBin_expr(ctx);
      }


    protected Stack<ColumnTypeWrapper> _ArgumentTypes = new Stack<ColumnTypeWrapper>();
    protected Stack<Counter>           _ArgumentLists = new Stack<Counter>();

    @Override
    public void enterValue_list(Value_listContext ctx)
      {
        _ArgumentLists.push(new Counter());
        _ArgumentTypes.push(new ColumnTypeWrapper());
        _CodeGen.append("new ").append(TYPE_MARKER).append("[] {");
        super.enterValue_list(ctx);
      }

    @Override
    public void exitValue_list(Value_listContext ctx)
      {
        if (_ArgumentLists.pop().get() == 0)
          addError("Value list is empty", ctx);
        else
          {
            ColumnTypeWrapper Type = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.pop();
            if (Type == null)
              {
                addError("Closing a value list without having a Type manager active!!!!", ctx);
              }
            else
              {
                int i = _CodeGen.indexOf(TYPE_MARKER);
                if (i == -1)
                  {
                    addError("Closing a value list without having a Type marker in the codeGen string!!!!", ctx);
                  }
                else
                  {
                    if (Type.getLastError() != null)
                      {
                        addError("Unknown bin expression type", ctx);
                      }
                    else
                      {
                        _CodeGen.replace(i, i + TYPE_MARKER.length(), JavaJDBCType.get(Type._Type)._JavaType);
                      }
                  }
              }
          }
        _CodeGen.append("}");
        super.exitValue_list(ctx);
      }

    @Override
    public void enterColumn(ColumnContext ctx)
      {
        if (_Columns.isEmpty() == false)
          {
            String colName = ctx.getText();
            for (ColumnDefinition col : _Columns)
              if (col.getName().equals(colName) == true)
                {
                  handleArgumentType(col._Type, ctx);
                  return;
                }
            addError("Unknown column name '" + colName + "'.", ctx);
          }
        super.enterColumn(ctx);
      }

    @Override
    public void enterArythExpr(ArythExprContext ctx)
      {
        _ArgumentTypes.push(new ColumnTypeWrapper());
        super.enterArythExpr(ctx);
      }

    @Override
    public void exitArythExpr(ArythExprContext ctx)
      {
        ColumnTypeWrapper Type = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.pop();
        if (Type == null)
          {
            addError("Closing an expression without having a Type manager active!!!!", ctx);
          }
        else if (Type._Type == null)
          {
            addError("Closing a sub expression without having a Type gathered!!!!", ctx);
          }
        else
          {
            ColumnTypeWrapper Type2 = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.peek();
            if (Type2 != null && Type2.addType(Type._Type, ctx.getText()) == false)
              addError(Type2.getLastError(), ctx);
          }

        super.exitArythExpr(ctx);
      }

    @Override
    public void enterAryth_op_add(Aryth_op_addContext ctx)
      {
        ColumnType ExistingExpressionType = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.peek()._Type;
        if (ExistingExpressionType == ColumnType.STRING && ctx.K_MINUS() != null)
          addError("Operator " + ctx.getText() + " is not compatible in an expression currently of type STRING.", ctx);
        _CodeGen.append(ctx.getText());
        super.enterAryth_op_add(ctx);
      }

    @Override
    public void enterAryth_op_mul(Aryth_op_mulContext ctx)
      {
        ColumnType ExistingExpressionType = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.peek()._Type;
        // LOG.debug("Operator: '"+ctx.getText()+"', Parent: '"+ctx.getParent().getText()+"', _ArgumentTypes.peek._Type: "+ExistingExpressionType);
        if (ExistingExpressionType == ColumnType.STRING)
          addError("Operator " + ctx.getText() + " is not compatible in an expression currently of type STRING.", ctx);
        else if (ctx.K_DIV() != null)
          handleArgumentType(ColumnType.FLOAT, ctx);
        _CodeGen.append(ctx.getText());
        super.enterAryth_op_mul(ctx);
      }

    @Override
    public void enterAryth_expr_sub(Aryth_expr_subContext ctx)
      {
        _ArgumentTypes.push(new ColumnTypeWrapper());
        _CodeGen.append("(");
        super.enterAryth_expr_sub(ctx);
      }

    @Override
    public void exitAryth_expr_sub(Aryth_expr_subContext ctx)
      {
        ColumnTypeWrapper Type = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.pop();
        if (Type == null)
          {
            addError("Closing a sub expression without having a Type manager active!!!!", ctx);
          }
        else if (Type._Type == null)
          {
            addError("Closing a sub expression without having a Type gathered!!!!", ctx);
          }
        else
          {
            ColumnTypeWrapper Type2 = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.peek();
            if (Type2 != null && Type2.addType(Type._Type, ctx.getText()) == false)
              addError(Type2.getLastError(), ctx);
          }

        _CodeGen.append(")");
        super.enterAryth_expr_sub(ctx);
      }


    protected void handleArgumentList()
      {
        if (_ArgumentLists.isEmpty() == true)
          return;
        if (_ArgumentLists.peek().increment() != 1)
          _CodeGen.append(", ");
      }

    protected void handleArgumentType(ColumnType Type, ParserRuleContext ctx)
      {
        ColumnTypeWrapper w = _ArgumentTypes.isEmpty() == true ? null : _ArgumentTypes.peek();
        if (w != null)
          {
            if (w.addType(Type, ctx.getText()) == false)
              addError(w.getLastError(), ctx);
          }
      }


    @Override
    public void enterValueNumericLiteral(ValueNumericLiteralContext ctx)
      {
        handleArgumentList();
        _CodeGen.append(ctx.getText());

        Object Number = ParseUtil.parseNumber(ctx.getText());
        if (Number == null)
          addError("Invalid number '" + ctx.getText() + "'", ctx);
        else
          {
            ColumnType Type = Number.getClass() == Integer.class ? ColumnType.INTEGER
            : Number.getClass() == Long.class ? ColumnType.LONG
            : Number.getClass() == Float.class ? ColumnType.FLOAT
            : Number.getClass() == Double.class ? ColumnType.DOUBLE
            : null;
            if (Type == null)
              addError("Invalid number '" + ctx.getText() + "' was was parsed incorrectly as " + Number.getClass().getName(), ctx);
            else
              handleArgumentType(Type, ctx);
          }
        super.enterValueNumericLiteral(ctx);
      }

    @Override
    public void enterValueStringLiteral(ValueStringLiteralContext ctx)
      {
        handleArgumentList();
        handleArgumentType(ctx.getText().length() == 1 ? ColumnType.CHAR : ColumnType.STRING, ctx);
        _CodeGen.append(ctx.getText());
        super.enterValueStringLiteral(ctx);
      }

    @Override
    public void enterValueBindParam(ValueBindParamContext ctx)
      {
        handleArgumentList();
        _CodeGen.append(ctx.getText().replaceAll("\\?\\{([^\\}]+)\\}", "$1"));
        super.enterValueBindParam(ctx);
      }

    @Override
    public void enterValueTimestampLiteral(ValueTimestampLiteralContext ctx)
      {
        String ts = null;
        if (ctx.timestamp_literal().CURRENT_TIMESTAMP() != null)
          ts = "DateTimeUtil.NOW_PLACEHOLDER_ZDT";
        else if (ctx.timestamp_literal().TIMESTAMP_YESTERDAY() != null)
          ts = "DateTimeUtil.getYesterdayTimestamp(true)";
        else if (ctx.timestamp_literal().TIMESTAMP_YESTERDAY_LAST() != null)
          ts = "DateTimeUtil.getYesterdayTimestamp(false)";
        else if (ctx.timestamp_literal().TIMESTAMP_TODAY() != null)
          ts = "DateTimeUtil.getTodayTimestamp(true)";
        else if (ctx.timestamp_literal().TIMESTAMP_TODAY_LAST() != null)
          ts = "DateTimeUtil.getTodayTimestamp(false)";
        else if (ctx.timestamp_literal().TIMESTAMP_TOMORROW() != null)
          ts = "DateTimeUtil.getTomorrowTimestamp(true)";
        else if (ctx.timestamp_literal().TIMESTAMP_TOMORROW_LAST() != null)
          ts = "DateTimeUtil.getTomorrowTimestamp(false)";
        else
          {
            ts = ctx.getText().substring(1, ctx.getText().length() - 1);
            ZonedDateTime ZDT = DateTimeUtil.parsefromJSON(ts);
            if (ZDT == null)
              addError("Invalid timestamp " + ctx.getText(), ctx);
            else
              ts = "DateTimeUtil.parsefromJSON(\"" + DateTimeUtil.printDateTimeForJSON(ZDT) + "\")";
          }

        handleArgumentList();
        handleArgumentType(ColumnType.DATETIME, ctx);
        _CodeGen.append(ts != null ? ts : "INVALID_TIMESTAMP_LITERAL");

        super.enterValueTimestampLiteral(ctx);
      }
  }
