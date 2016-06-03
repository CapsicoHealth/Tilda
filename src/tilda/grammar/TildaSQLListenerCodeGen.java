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
import tilda.grammar.TildaSQLParser.ArithmeticExprContext;
import tilda.grammar.TildaSQLParser.Arithmetic_expr_baseContext;
import tilda.grammar.TildaSQLParser.Arithmetic_expr_subContext;
import tilda.grammar.TildaSQLParser.Arithmetic_op_addContext;
import tilda.grammar.TildaSQLParser.Arithmetic_op_mulContext;
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

public class TildaSQLListenerCodeGen extends TildaSQLBaseListener
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQLListenerCodeGen.class.getName());


    public TildaSQLListenerCodeGen()
      {
      }

    public void setColumnEnvironment(List<ColumnDefinition> Columns)
      {
        _TypeManager.setColumnEnvironment(Columns);
      }


    protected StringBuilder _CodeGen     = new StringBuilder("Q");
    private TypeManager     _TypeManager = new TypeManager();
    private ErrorList       _Errors      = new ErrorList();

    public ErrorList getErrors()
      {
        return _Errors;
      }

    @Override
    public void enterBool_op(Bool_opContext ctx)
      {
        if (ctx.K_AND() != null)
          _CodeGen.append(ctx.K_NOT() == null ? ".and()" : ".andNot()");
        else if (ctx.K_OR() != null)
          _CodeGen.append(ctx.K_NOT() == null ? ".or()" : ".orNot()");
        else
          _Errors.addError("Unknown boolean operator " + ctx.getText(), ctx);

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
        _TypeManager.openScope();
        if (ctx.bin_expr_lhs().column().size() == 1)
          {
            LHS = "COLS." + ctx.bin_expr_lhs().column(0).getText();
            _TypeManager.handleColumn(ctx.bin_expr_lhs().column(0));
          }
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
                _TypeManager.handleColumn(colCtx);
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
              _Errors.addError("Unknown binary operator " + ctx.bin_op().getText(), ctx);
          }
        else if (ctx.K_IN() != null) // greater than or equal
          {
            _CodeGen.append(".in(").append(LHS).append(", ");
          }
        else
          _Errors.addError("Unparsable binary expression " + ctx.getText(), ctx);

        if (ctx.column() != null)
          {
            _TypeManager.openScope();
            _TypeManager.handleColumn(ctx.column());
            _CodeGen.append("COLS.").append(ctx.column().getText());
          }

        super.enterBin_expr(ctx);
      }

    @Override
    public void exitBin_expr(Bin_exprContext ctx)
      {
        _CodeGen.append(")");
        _TypeManager.rolloverArgumentType(ctx, "binary expression", true);
        super.exitBin_expr(ctx);
      }

    protected Deque<Counter>           _ArgumentLists = new ArrayDeque<Counter>();

    @Override
    public void enterValue_list(Value_listContext ctx)
      {
        _ArgumentLists.push(new Counter());
        _TypeManager.openScope();
        _CodeGen.append("new ").append(TYPE_MARKER).append("[] {");
        super.enterValue_list(ctx);
      }

    @Override
    public void exitValue_list(Value_listContext ctx)
      {
        if (_ArgumentLists.pop().get() == 0)
          _Errors.addError("Value list is empty", ctx);
        else
          {
            TypeWrapper Type = _TypeManager.closeScope("value list", ctx, false);
            if (Type == null)
              {
                _Errors.addErrors(_TypeManager.getErrors());
              }
            else
              {
                int i = _CodeGen.indexOf(TYPE_MARKER);
                if (i == -1)
                  {
                    _Errors.addError("Closing a value list without having a Type marker in the codeGen string!!!!", ctx);
                  }
                else
                  {
                    _CodeGen.replace(i, i + TYPE_MARKER.length(), JavaJDBCType.get(Type._Type)._JavaType);
                  }
              }
          }
        _CodeGen.append("}");
        super.exitValue_list(ctx);
      }

    @Override
    public void enterColumn(ColumnContext ctx)
      {
        _TypeManager.handleColumn(ctx);
        super.enterColumn(ctx);
      }

    @Override
    public void enterArithmetic_expr_base(Arithmetic_expr_baseContext ctx)
      {
        _TypeManager.openScope();
        super.enterArithmetic_expr_base(ctx);
      }

    @Override
    public void exitArithmetic_expr_base(Arithmetic_expr_baseContext ctx)
      {
        // TODO Auto-generated method stub
        super.exitArithmetic_expr_base(ctx);
      }

    @Override
    public void enterArithmeticExpr(ArithmeticExprContext ctx)
      {
        _TypeManager.openScope();
        super.enterArithmeticExpr(ctx);
      }

    @Override
    public void exitArithmeticExpr(ArithmeticExprContext ctx)
      {
        _TypeManager.rolloverArgumentType(ctx, "Arithmetic expression", false);
        super.exitArithmeticExpr(ctx);
      }

    @Override
    public void enterArithmetic_op_add(Arithmetic_op_addContext ctx)
      {
        
        ColumnType ExistingExpressionType = _TypeManager.peek();
        if (ExistingExpressionType == ColumnType.STRING && ctx.K_MINUS() != null)
          _Errors.addError("Operator " + ctx.getText() + " is not compatible in an expression currently of type STRING.", ctx);
        _CodeGen.append(ctx.getText());
        super.enterArithmetic_op_add(ctx);
      }

    @Override
    public void enterArithmetic_op_mul(Arithmetic_op_mulContext ctx)
      {
        ColumnType ExistingExpressionType = _TypeManager.peek();
        if (ExistingExpressionType == ColumnType.STRING)
          _Errors.addError("Operator " + ctx.getText() + " is not compatible in an expression currently of type STRING.", ctx);
        else if (ctx.K_DIV() != null)
          _TypeManager.handleType(ColumnType.FLOAT, ctx);
        _CodeGen.append(ctx.getText());
        super.enterArithmetic_op_mul(ctx);
      }

    @Override
    public void enterArithmetic_expr_sub(Arithmetic_expr_subContext ctx)
      {
        _TypeManager.openScope();
        _CodeGen.append("(");
        super.enterArithmetic_expr_sub(ctx);
      }

    @Override
    public void exitArithmetic_expr_sub(Arithmetic_expr_subContext ctx)
      {
        _TypeManager.rolloverArgumentType(ctx, "sub arithmetic expression", false);
        _CodeGen.append(")");
        super.enterArithmetic_expr_sub(ctx);
      }


    protected void handleArgumentList()
      {
        if (_ArgumentLists.isEmpty() == true)
          return;
        if (_ArgumentLists.peek().increment() != 1)
          _CodeGen.append(", ");
      }

    @Override
    public void enterValueNumericLiteral(ValueNumericLiteralContext ctx)
      {
        handleArgumentList();
        _CodeGen.append(ctx.getText());

        Object Number = ParseUtil.parseNumber(ctx.getText());
        if (Number == null)
          _Errors.addError("Invalid number '" + ctx.getText() + "'", ctx);
        else
          {
            ColumnType Type = Number.getClass() == Integer.class ? ColumnType.INTEGER
            : Number.getClass() == Long.class ? ColumnType.LONG
            : Number.getClass() == Float.class ? ColumnType.FLOAT
            : Number.getClass() == Double.class ? ColumnType.DOUBLE
            : null;
            if (Type == null)
              _Errors.addError("Invalid number '" + ctx.getText() + "' was was parsed incorrectly as " + Number.getClass().getName(), ctx);
            else
              _TypeManager.handleType(Type, ctx);
          }
        super.enterValueNumericLiteral(ctx);
      }

    @Override
    public void enterValueStringLiteral(ValueStringLiteralContext ctx)
      {
        handleArgumentList();
        _TypeManager.handleType(ctx.getText().length() == 3 ? ColumnType.CHAR : ColumnType.STRING, ctx); // a value of 'X' if 3-char long, but is a CHAR type-wise.
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
              _Errors.addError("Invalid timestamp " + ctx.getText(), ctx);
            else
              ts = "DateTimeUtil.parsefromJSON(\"" + DateTimeUtil.printDateTimeForJSON(ZDT) + "\")";
          }

        handleArgumentList();
        _TypeManager.handleType(ColumnType.DATETIME, ctx);
        _CodeGen.append(ts != null ? ts : "INVALID_TIMESTAMP_LITERAL");

        super.enterValueTimestampLiteral(ctx);
      }
  }
