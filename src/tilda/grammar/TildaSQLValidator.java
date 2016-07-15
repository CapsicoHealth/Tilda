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
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.grammar.TildaSQLParser.ArithmeticExprContext;
import tilda.grammar.TildaSQLParser.Arithmetic_expr_baseContext;
import tilda.grammar.TildaSQLParser.Arithmetic_expr_subContext;
import tilda.grammar.TildaSQLParser.Arithmetic_op_addContext;
import tilda.grammar.TildaSQLParser.Arithmetic_op_mulContext;
import tilda.grammar.TildaSQLParser.Bin_exprContext;
import tilda.grammar.TildaSQLParser.Bool_expr_subContext;
import tilda.grammar.TildaSQLParser.Bool_opContext;
import tilda.grammar.TildaSQLParser.ColumnContext;
import tilda.grammar.TildaSQLParser.Isnull_exprContext;
import tilda.grammar.TildaSQLParser.ValueBindParamContext;
import tilda.grammar.TildaSQLParser.ValueNumericLiteralContext;
import tilda.grammar.TildaSQLParser.ValueStringLiteralContext;
import tilda.grammar.TildaSQLParser.ValueTimestampLiteralContext;
import tilda.grammar.TildaSQLParser.Value_listContext;
import tilda.grammar.TildaSQLParser.WhereContext;
import tilda.types.ColumnDefinition;
import tilda.utils.Counter;
import tilda.utils.DateTimeUtil;
import tilda.utils.ParseUtil;

public class TildaSQLValidator extends TildaSQLBaseListener
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQLValidator.class.getName());

    public TildaSQLValidator(String Expr)
      {
        ANTLRInputStream in = new ANTLRInputStream(Expr);
        TildaSQLLexer lexer = new TildaSQLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TildaSQLParser parser = new TildaSQLParser(tokens);
        _Tree = parser.where();
        _SyntaxErrors = parser.getNumberOfSyntaxErrors();
      }

    protected ParseTree   _Tree;
    protected int         _SyntaxErrors;

    protected TypeManager _TypeManager = new TypeManager();
    protected ErrorList   _Errors      = new ErrorList();
    protected WhereClauseCodeGen     _CG;

    public int getParserSyntaxErrors()
      {
        return _SyntaxErrors;
      }

    public void setColumnEnvironment(List<ColumnDefinition> Columns)
      {
        _TypeManager.setColumnEnvironment(Columns);
      }

    public void setCodeGen(WhereClauseCodeGen CG)
      {
        _CG = CG;
      }

    public void validate()
      {
        ParseTreeWalker.DEFAULT.walk(this, _Tree);
      }

    public ErrorList getValidationErrors()
      {
        return _Errors;
      }

    @Override
    public void enterBool_op(Bool_opContext ctx)
      {
        super.enterBool_op(ctx);

        if (ctx.K_AND() != null)
          {
            if (_CG != null)
              _CG.boolOperatorAND(ctx.K_NOT() != null);
          }
        else if (ctx.K_OR() != null)
          {
            if (_CG != null)
              _CG.boolOperatorOR(ctx.K_NOT() != null);
          }
        else
          _Errors.addError("Unknown boolean operator " + ctx.getText(), ctx);
      }

    @Override
    public void enterBool_expr_sub(Bool_expr_subContext ctx)
      {
        super.enterBool_expr_sub(ctx);
        if (_CG != null)
          _CG.boolOpenPar();
      }

    @Override
    public void exitBool_expr_sub(Bool_expr_subContext ctx)
      {
        super.exitBool_expr_sub(ctx);
        if (_CG != null)
          _CG.boolClosePar();
      }



    @Override
    public void enterBin_expr(Bin_exprContext ctx)
      {
        _TypeManager.openScope();
        List<ColumnDefinition> Columns = new ArrayList<ColumnDefinition>();
        for (ColumnContext colCtx : ctx.bin_expr_lhs().column())
          {
            ColumnDefinition CD = _TypeManager.handleColumn(colCtx);
            if (CD != null)
              Columns.add(CD);
            else
              _Errors.addError(_TypeManager.getLastError(), ctx);
          }

        if (ctx.bin_op() != null)
          {
            if (ctx.bin_op().K_LIKE() != null) // like
              {
                if (_CG != null)
                  _CG.binLike(Columns, ctx.bin_op().K_NOT() != null);
              }
            else if (ctx.bin_op().K_EQ() != null) // equal
              {
                if (_CG != null)

                  _CG.binEqual(Columns, _TypeManager.peek(), false);
              }
            else if (ctx.bin_op().K_NEQ() != null) // not equal
              {
                if (_CG != null)
                  _CG.binEqual(Columns, _TypeManager.peek(), true);
              }
            else if (ctx.bin_op().K_LT() != null) // less than
              {
                if (_CG != null)
                  _CG.binLessThan(Columns, _TypeManager.peek());
              }
            else if (ctx.bin_op().K_LTE() != null) // less than or equal
              {
                if (_CG != null)
                  _CG.binLessThanOrEqual(Columns, _TypeManager.peek());
              }
            else if (ctx.bin_op().K_GT() != null) // greater than
              {
                if (_CG != null)
                  _CG.binGreaterThan(Columns, _TypeManager.peek());
              }
            else if (ctx.bin_op().K_GTE() != null) // greater than or equal
              {
                if (_CG != null)
                  _CG.binGreaterThanOrEqual(Columns, _TypeManager.peek());
              }
            else
              _Errors.addError("Unknown binary operator " + ctx.bin_op().getText(), ctx);
          }
        else if (ctx.K_IN() != null) // greater than or equal
          {
            if (_CG != null)
              _CG.binIn(Columns, ctx.K_NOT() != null);
          }
        else
          _Errors.addError("Unparsable binary expression " + ctx.getText(), ctx);

        if (ctx.column() != null)
          {
            _TypeManager.openScope();
            ColumnDefinition CD = _TypeManager.handleColumn(ctx.column());
            if (CD != null)
              {
                if (_CG != null)
              _CG.col(CD);
              }
            else
              _Errors.addError(_TypeManager.getLastError(), ctx);
          }

        super.enterBin_expr(ctx);
      }

    @Override
    public void exitBin_expr(Bin_exprContext ctx)
      {
        if (_CG != null)
          {
            String Err = _CG.binClose();
            if (Err != null)
              _Errors.addError(Err, ctx);
          }

        if (_TypeManager.rolloverArgumentType(ctx, "binary expression", true) == false)
         _Errors.addError(_TypeManager.getLastError(), ctx);

        super.exitBin_expr(ctx);
      }

    protected Deque<Counter> _ArgumentLists = new ArrayDeque<Counter>();

    @Override
    public void enterValue_list(Value_listContext ctx)
      {
        _ArgumentLists.push(new Counter());
        _TypeManager.openScope();
        if (_CG != null)
          _CG.valueListOpen();
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
                _Errors.addError(_TypeManager.getLastError(), ctx);
              }
            else if (_CG != null)
              {
                String Err = _CG.valueListClose(Type._Type);
                if (Err != null)
                  _Errors.addError(Err, ctx);
              }
          }
        super.exitValue_list(ctx);
      }

    @Override
    public void enterColumn(ColumnContext ctx)
      {
//        _TypeManager.handleColumn(ctx);
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
        if (_TypeManager.rolloverArgumentType(ctx, "Arithmetic expression", false) == false)
         _Errors.addError(_TypeManager.getLastError(), ctx);
          
        super.exitArithmeticExpr(ctx);
      }

    @Override
    public void enterArithmetic_op_add(Arithmetic_op_addContext ctx)
      {

        ColumnType ExistingExpressionType = _TypeManager.peek();
        if (ExistingExpressionType == ColumnType.STRING && ctx.K_MINUS() != null)
          _Errors.addError("Operator " + ctx.getText() + " is not compatible in an expression currently of type STRING.", ctx);
        if (_CG != null)
          _CG.arithmeticPlus(ctx.K_MINUS() != null);
        super.enterArithmetic_op_add(ctx);
      }

    @Override
    public void enterArithmetic_op_mul(Arithmetic_op_mulContext ctx)
      {
        ColumnType ExistingExpressionType = _TypeManager.peek();
        if (ExistingExpressionType == ColumnType.STRING)
          _Errors.addError("Operator " + ctx.getText() + " is not compatible in an expression currently of type STRING.", ctx);
        else if (ctx.K_DIV() != null)
          {
            if (_TypeManager.handleType(ColumnType.FLOAT, ctx) == false)
             _Errors.addError(_TypeManager.getLastError(), ctx);
          }
        if (_CG != null)
          _CG.arithmeticMultiply(ctx.K_DIV() != null);
        super.enterArithmetic_op_mul(ctx);
      }

    @Override
    public void enterArithmetic_expr_sub(Arithmetic_expr_subContext ctx)
      {
        _TypeManager.openScope();
        if (_CG != null)
          _CG.arithmeticOpenPar();
        super.enterArithmetic_expr_sub(ctx);
      }

    @Override
    public void exitArithmetic_expr_sub(Arithmetic_expr_subContext ctx)
      {
        if (_TypeManager.rolloverArgumentType(ctx, "sub arithmetic expression", false) == false)
         _Errors.addError(_TypeManager.getLastError(), ctx);
        if (_CG != null)
          _CG.arithmeticClosePar();
        super.enterArithmetic_expr_sub(ctx);
      }


    protected void handleArgumentList()
      {
        if (_ArgumentLists.isEmpty() == true)
          return;
        if (_ArgumentLists.peek().increment() != 1 && _CG != null)
          _CG.valueListSeparator();
      }

    @Override
    public void enterValueNumericLiteral(ValueNumericLiteralContext ctx)
      {
        handleArgumentList();
        if (_CG != null)
          _CG.valueLiteralNumeric(ctx.getText());

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
            else if (_TypeManager.handleType(Type, ctx) == false)
              _Errors.addError(_TypeManager.getLastError(), ctx);
              
          }
        super.enterValueNumericLiteral(ctx);
      }

    @Override
    public void enterValueStringLiteral(ValueStringLiteralContext ctx)
      {
        handleArgumentList();
        String Str = ctx.getText();
        Str = Str.substring(1, Str.length() - 1);
        if (_TypeManager.handleType(Str.length() == 1 ? ColumnType.CHAR : ColumnType.STRING, ctx) == false) // a value of 'X' if 3-char long, but is a CHAR type-wise.
         _Errors.addError(_TypeManager.getLastError(), ctx);

        if (_TypeManager.peek() == ColumnType.CHAR)
          {
            if (_CG != null)
              _CG.valueLiteralChar(Str.charAt(0));
          }
        else
          {
            if (_CG != null)
              _CG.valueLiteralString(Str);
          }
        super.enterValueStringLiteral(ctx);
      }

    @Override
    public void enterValueBindParam(ValueBindParamContext ctx)
      {
        handleArgumentList();
        if (_CG != null)
          _CG.valueParameter(ctx.getText().replaceAll("\\?\\{([^\\}]+)\\}", "$1"));
        super.enterValueBindParam(ctx);
      }

    @Override
    public void enterValueTimestampLiteral(ValueTimestampLiteralContext ctx)
      {
        handleArgumentList();
        if (ctx.timestamp_literal().CURRENT_TIMESTAMP() != null)
          {
            if (_CG != null)
              _CG.valueTimestampCurrent();
          }
        else if (ctx.timestamp_literal().TIMESTAMP_YESTERDAY() != null)
          {
            if (_CG != null)
              _CG.valueTimestampYesterday(ctx.timestamp_literal().LAST() == null);
          }
        else if (ctx.timestamp_literal().TIMESTAMP_TODAY() != null)
          {
            if (_CG != null)
              _CG.valueTimestampToday(ctx.timestamp_literal().LAST() == null);
          }
        else if (ctx.timestamp_literal().TIMESTAMP_TOMORROW() != null)
          {
            if (_CG != null)
              _CG.valueTimestampTomorrow(ctx.timestamp_literal().LAST() == null);
          }
        else
          {
            ZonedDateTime ZDT = DateTimeUtil.parsefromJSON(ctx.getText().substring(1, ctx.getText().length() - 1));
            if (ZDT == null)
              _Errors.addError("Invalid timestamp " + ctx.getText(), ctx);
            if (_CG != null)
              _CG.valueLiteralTimestamp(ZDT);
          }
        if (_TypeManager.handleType(ColumnType.DATETIME, ctx) == false)
         _Errors.addError(_TypeManager.getLastError(), ctx);
        super.enterValueTimestampLiteral(ctx);
      }

    @Override
    public void exitWhere(WhereContext ctx)
      {
        if (_CG != null)
          _CG.end();
        super.exitWhere(ctx);
      }
    
    @Override
    public void enterIsnull_expr(Isnull_exprContext ctx)
    {
      ColumnDefinition CD = _TypeManager.handleColumn(ctx.column());
      if (CD == null)
       _Errors.addError(_TypeManager.getLastError(), ctx);
      else if (_CG != null)
        _CG.isNull(CD, ctx.isnull_op().K_NOT() != null);
      super.enterIsnull_expr(ctx);
    }
  }
