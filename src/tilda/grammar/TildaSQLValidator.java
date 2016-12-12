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

import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.enums.ColumnType;
import tilda.grammar.TildaSQLParser.Arithmetic_op_addContext;
import tilda.grammar.TildaSQLParser.Arithmetic_op_mulContext;
import tilda.grammar.TildaSQLParser.ColumnContext;
import tilda.grammar.TildaSQLParser.ExprContext;
import tilda.grammar.TildaSQLParser.ValueBooleanLiteralContext;
import tilda.grammar.TildaSQLParser.ValueNumericLiteralContext;
import tilda.grammar.TildaSQLParser.ValueStringLiteralContext;
import tilda.grammar.TildaSQLParser.ValueTimestampLiteralContext;
import tilda.types.ColumnDefinition;
import tilda.utils.ParseUtil;

public class TildaSQLValidator extends TildaSQLBaseListener
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQLValidator.class.getName());

    public TildaSQLValidator(String Expr, boolean Where)
      {
        ANTLRInputStream in = new ANTLRInputStream(Expr);
        TildaSQLLexer lexer = new TildaSQLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TildaSQLParser parser = new TildaSQLParser(tokens);
        _Tree = parser.main();
        _SyntaxErrors = parser.getNumberOfSyntaxErrors();
        _TreePrinter = new TildaSQLTreePrinter(parser);
      }

    protected ParseTree           _Tree;
    protected int                 _SyntaxErrors;

    protected TypeManager         _TypeManager = new TypeManager();
    protected ErrorList           _Errors      = new ErrorList();
    protected WhereClauseCodeGen  _CG;

    protected TildaSQLTreePrinter _TreePrinter;

    public int getParserSyntaxErrors()
      {
        return _SyntaxErrors;
      }

    public String PrintParseTree()
      {
        ParseTreeWalker.DEFAULT.walk(_TreePrinter, _Tree);
        return _TreePrinter._ParseTreeStr.toString();
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
    public void exitColumn(ColumnContext ctx)
      {
        _TypeManager.pushColumnType(ctx);
        super.enterColumn(ctx);
      }

    @Override
    public void exitValueNumericLiteral(ValueNumericLiteralContext ctx)
      {
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
              _TypeManager.pushType(Type, ctx.getText());
          }
        super.exitValueNumericLiteral(ctx);
      }

    @Override
    public void exitValueStringLiteral(ValueStringLiteralContext ctx)
      {
        _TypeManager.pushType(ColumnType.STRING, ctx.getText());
        super.exitValueStringLiteral(ctx);
      }

    @Override
    public void exitValueTimestampLiteral(ValueTimestampLiteralContext ctx)
      {
        _TypeManager.pushType(ColumnType.DATETIME, ctx.getText());
        super.exitValueTimestampLiteral(ctx);
      }

    @Override
    public void exitValueBooleanLiteral(ValueBooleanLiteralContext ctx)
      {
        _TypeManager.pushType(ColumnType.BOOLEAN, ctx.getText());
        super.exitValueBooleanLiteral(ctx);
      }

    @Override
    public void exitArithmetic_op_add(Arithmetic_op_addContext ctx)
      {
        ColumnType T2 = _TypeManager.popType();
        ColumnType T1 = _TypeManager.popType();
        if (T1 == null || T2 == null)
          {
            _Errors.addError("The operator '" + ctx.getText() + "' requires 2 operands. " + (T1 == null && T2 == null ? "None were found." : "Only one was found."), ctx);
            return;
          }
        if (T1 == ColumnType.DATETIME || T2 == ColumnType.DATETIME)
          {
            _Errors.addError("The operator '" + ctx.getText() + "' cannot be applied to Datetime values.", ctx);
            return;
          }
        if (ctx.K_MINUS() != null && (T1 == ColumnType.STRING || T2 == ColumnType.STRING || T1 == ColumnType.CHAR || T2 == ColumnType.CHAR))
          {
            _Errors.addError("The operator '" + ctx.getText() + "' cannot be applied to String or Char values.", ctx);
            return;
          }
        if (T1 == ColumnType.BOOLEAN || T2 == ColumnType.BOOLEAN)
          {
            _Errors.addError("The operator '" + ctx.getText() + "' cannot be applied to boolean values.", ctx);
            return;
          }
        if (T1 == ColumnType.CHAR && T2 != ColumnType.CHAR && T2 != ColumnType.STRING
        || T2 == ColumnType.CHAR && T1 != ColumnType.CHAR && T1 != ColumnType.STRING)
          {
            _Errors.addError("The operator '" + ctx.getText() + "' cannot be applied to " + T1.name() + " and " + T2.name() + ".", ctx);
            return;
          }

        ColumnType T = null;
        if (T1 == ColumnType.STRING || T2 == ColumnType.STRING)
          T = ColumnType.STRING;
        else if (T1 == ColumnType.DOUBLE || T2 == ColumnType.DOUBLE)
          T = ColumnType.DOUBLE;
        else if (T1 == ColumnType.FLOAT || T2 == ColumnType.FLOAT)
          T = ColumnType.FLOAT;
        else if (T1 == ColumnType.LONG || T2 == ColumnType.LONG)
          T = ColumnType.LONG;
        else if (T1 == ColumnType.INTEGER || T2 == ColumnType.INTEGER)
          T = ColumnType.INTEGER;

        if (T == null)
          {
            _Errors.addError("The operator '" + ctx.getText() + "' cannot be resolved to a type from its operands " + T1.name() + " and " + T2.name() + ".", ctx);
            return;
          }

        _TypeManager.pushType(T, ctx.getText());
        super.exitArithmetic_op_add(ctx);
      }

    @Override
    public void exitArithmetic_op_mul(Arithmetic_op_mulContext ctx)
      {
        ColumnType T2 = _TypeManager.popType();
        ColumnType T1 = _TypeManager.popType();
        if (T1 == null || T2 == null)
          {
            _Errors.addError("The operator '" + ctx.getText() + "' requires 2 operands. " + (T1 == null && T2 == null ? "None were found." : "Only one was found."), ctx);
            return;
          }
        if (T1 == ColumnType.DATETIME || T2 == ColumnType.DATETIME)
          {
            _Errors.addError("The operator '" + ctx.getText() + "' cannot be applied to Datetime values.", ctx);
            return;
          }
        if (T1 == ColumnType.STRING || T2 == ColumnType.STRING || T1 == ColumnType.CHAR || T2 == ColumnType.CHAR)
          {
            _Errors.addError("The operator '" + ctx.getText() + "' cannot be applied to String or Char values.", ctx);
            return;
          }
        if (T1 == ColumnType.BOOLEAN || T2 == ColumnType.BOOLEAN)
          {
            _Errors.addError("The operator '" + ctx.getText() + "' cannot be applied to boolean values.", ctx);
            return;
          }

        ColumnType T = null;
        if (T1 == ColumnType.DOUBLE || T2 == ColumnType.DOUBLE)
          T = ColumnType.DOUBLE;
        else if (T1 == ColumnType.FLOAT || T2 == ColumnType.FLOAT)
          T = ColumnType.FLOAT;
        else if (T1 == ColumnType.LONG || T2 == ColumnType.LONG)
          T = ColumnType.LONG;
        else if (T1 == ColumnType.INTEGER || T2 == ColumnType.INTEGER)
          T = ColumnType.INTEGER;

        if (T == null)
          {
            _Errors.addError("The operator '" + ctx.getText() + "' cannot be resolved to a type from its operands " + T1.name() + " and " + T2.name() + ".", ctx);
            return;
          }

        _TypeManager.pushType(T, ctx.getText());
        super.exitArithmetic_op_mul(ctx);
      }


    @Override
    public void exitExpr(ExprContext ctx)
      {
        if (ctx.concat != null)
          {
            ColumnType T2 = _TypeManager.popType();
            ColumnType T1 = _TypeManager.popType();
            if (T1 == null || T2 == null)
              {
                _Errors.addError("The operator '" + ctx.concat.getText() + "' requires 2 operands. " + (T1 == null && T2 == null ? "None were found." : "Only one was found."), ctx);
                return;
              }
            if (T1 == ColumnType.STRING || T1 == ColumnType.CHAR && T2 == ColumnType.STRING || T2 != ColumnType.CHAR)
              {
                _TypeManager.pushType(ColumnType.STRING, ctx.getText());
              }
            else
              {
                _Errors.addError("The operator '" + ctx.concat.getText() + "' requires 2 operands that must be a String or a Char: they are " + T1.name() + " and " + T2.name() + ".", ctx);
                return;
              }
          }
        else if (ctx.comparators1 != null || ctx.comparators2 != null || ctx.like != null)
          {
            Token Tok = ctx.comparators1 != null ? ctx.comparators1 : ctx.comparators2 != null ? ctx.comparators2 : ctx.like;
            ColumnType T2 = _TypeManager.popType();
            ColumnType T1 = _TypeManager.popType();
            if (T1 == null || T2 == null)
              {
                _Errors.addError("The operator '" + Tok.getText() + "' requires 2 operands. " + (T1 == null && T2 == null ? "None were found." : "Only one was found."), ctx);
                return;
              }
            if (   T1 == ColumnType.BOOLEAN && T2 == ColumnType.BOOLEAN
                || (   (T1 == ColumnType.INTEGER || T1 == ColumnType.LONG || T1 == ColumnType.FLOAT || T1 == ColumnType.DOUBLE)
                    && (T2 == ColumnType.INTEGER || T2 == ColumnType.LONG || T2 == ColumnType.FLOAT || T2 == ColumnType.DOUBLE)
                   )
                || (   (T1 == ColumnType.STRING || T1 == ColumnType.CHAR)
                    && (T2 == ColumnType.STRING || T2 == ColumnType.CHAR)
                   )
               )
              {
                _TypeManager.pushType(ColumnType.BOOLEAN, ctx.getText());
              }
            else
              {
                _Errors.addError("The operator '" + Tok.getText() + "' is comparing operands of incompatible types " + T1.name() + " and " + T2.name() + ".", ctx);
                return;
              }
          }
        else if (ctx.func != null)
          {
            if (ctx.func_name().K_LEN() != null)
              doFuncLen(ctx, ctx.expr());
            else if (ctx.func_name().K_DAYS_BETWEEN() != null)
              doFuncDaysBetween(ctx, ctx.expr());
            else
              {
                _Errors.addError("Unknown function name " + ctx.getText() + ".", ctx);
                return;
              }
          }
        super.exitExpr(ctx);
      }

    private void doFuncLen(ExprContext ctx, List<ExprContext> Params)
      {
        if (Params.size() != 1)
          {
            _Errors.addError("Function 'Len' must take a single String parameter: "+Params.size()+" were found.", ctx);
            return;
          }
        ColumnType T = _TypeManager.popType();
        if (T == null)
          {
            _Errors.addError("Function 'Len' must take a single String parameter, but no type could be derived from the parameter.", ctx);
            return;
          }
        if (T != ColumnType.STRING)
          {
            _Errors.addError("Function 'Len' must take a single String parameter: the type '"+T.name()+"' was derived instead.", ctx);
            return;
          }
        _TypeManager.pushType(ColumnType.INTEGER, ctx.getText());          
        
/*
        boolean err = false;

        if (Columns.size() == 1)
          {
            ColumnDefinition Col = Columns.get(0);
            if (Col._Type != ColumnType.STRING && Col._Collection != true)
              {
                err = true;
                _Errors.addError("Function 'Len' must take a single Collection column or a list of Strings: parameter '" + Col.getName() + "' is a " + Col._Type.toString() + ".", ctx);
              }
          }
        else
          for (ColumnDefinition Col : Columns)
            {
              if (Col._Type != ColumnType.STRING)
                {
                  err = true;
                  _Errors.addError("Function 'Len' must take a single Collection column or a list of Strings: parameter '" + Col.getName() + "' is a " + Col._Type.name() + ".", ctx);
                  break;
                }
              else if (Col._Collection == true)
                {
                  err = true;
                  _Errors.addError("Function 'Len' must take a single Collection column or a list of Strings: parameter '" + Col.getName() + "' is a Collection.", ctx);
                  break;
                }
            }

        if (err == false)
          {
            if (_TypeManager.replaceType(ColumnType.INTEGER, ctx.getText()) == true)
              if (_CG != null)
                _CG.funcLen(Columns);
          }
*/
      }

    private void doFuncDaysBetween(ExprContext ctx, List<ExprContext> Params)
      {
        if (Params.size() != 2)
          {
            _Errors.addError("Function 'DaysBetween' must take two DateTime parameters: "+Params.size()+" were found.", ctx);
            return;
          }
        ColumnType T2 = _TypeManager.popType();
        ColumnType T1 = _TypeManager.popType();
        if (T1 == null || T2 == null)
          {
            _Errors.addError("Function 'DaysBetween' must take two DateTime parameters, but only one parameter was found.", ctx);
            return;
          }
        if (T1 != ColumnType.DATETIME && T2 != ColumnType.DATETIME)
          {
            _Errors.addError("Function 'DaysBetween' must take two DateTime parameters: the types '"+T1.name()+"' and '"+T2.name()+"' were derived instead.", ctx);
            return;
          }
        _TypeManager.pushType(ColumnType.INTEGER, ctx.getText());          

/*
        boolean err = false;

        if (Columns.size() == 2)
          {
            for (ColumnDefinition Col : Columns)
              {
                if (Col._Type != ColumnType.DATETIME && Col._Collection != true)
                  {
                    err = true;
                    _Errors.addError("Function 'DaysBetween' must take 2 DateTime columns: parameter '" + Col.getName() + "' is a " + Col._Type.toString() + ".", ctx);
                  }
              }
          }
        else
          {
            err = true;
            _Errors.addError("Function 'DaysBetween' must take 2 DateTime columns: " + Columns.size() + " parameters were found.", ctx);
          }

        if (err == false)
          {
            if (_TypeManager.replaceType(ColumnType.INTEGER, ctx.getText()) == true)
              if (_CG != null)
                _CG.funcDaysBetween(Columns.get(0), Columns.get(1));
          }
*/
      }





    /*
     * @Override
     * public void exitValueNumericLiteral(ValueNumericLiteralContext ctx)
     * {
     * handleArgumentList();
     * if (_CG != null)
     * _CG.valueLiteralNumeric(ctx.getText());
     * 
     * Object Number = ParseUtil.parseNumber(ctx.getText());
     * if (Number == null)
     * _Errors.addError("Invalid number '" + ctx.getText() + "'", ctx);
     * else
     * {
     * ColumnType Type = Number.getClass() == Integer.class ? ColumnType.INTEGER
     * : Number.getClass() == Long.class ? ColumnType.LONG
     * : Number.getClass() == Float.class ? ColumnType.FLOAT
     * : Number.getClass() == Double.class ? ColumnType.DOUBLE
     * : null;
     * if (Type == null)
     * _Errors.addError("Invalid number '" + ctx.getText() + "' was was parsed incorrectly as " + Number.getClass().getName(), ctx);
     * else if (_TypeManager.handleType(Type, ctx) == false)
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * 
     * }
     * super.enterValueNumericLiteral(ctx);
     * }
     * 
     * @Override
     * public void enterValueStringLiteral(ValueStringLiteralContext ctx)
     * {
     * handleArgumentList();
     * String Str = ctx.getText();
     * Str = Str.substring(1, Str.length() - 1);
     * if (_TypeManager.handleType(Str.length() == 1 ? ColumnType.CHAR : ColumnType.STRING, ctx) == false) // a value of 'X' if 3-char long, but is a CHAR type-wise.
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * 
     * if (_TypeManager.peek() == ColumnType.CHAR)
     * {
     * if (_CG != null)
     * _CG.valueLiteralChar(Str.charAt(0));
     * }
     * else
     * {
     * if (_CG != null)
     * _CG.valueLiteralString(Str);
     * }
     * super.enterValueStringLiteral(ctx);
     * }
     * 
     * @Override
     * public void enterValueBindParam(ValueBindParamContext ctx)
     * {
     * handleArgumentList();
     * if (_CG != null)
     * _CG.valueParameter(ctx.getText().replaceAll("\\?\\{([^\\}]+)\\}", "$1"));
     * super.enterValueBindParam(ctx);
     * }
     * 
     * @Override
     * public void enterValueTimestampLiteral(ValueTimestampLiteralContext ctx)
     * {
     * handleArgumentList();
     * if (ctx.timestamp_literal().CURRENT_TIMESTAMP() != null)
     * {
     * if (_CG != null)
     * _CG.valueTimestampCurrent();
     * }
     * else if (ctx.timestamp_literal().TIMESTAMP_YESTERDAY() != null)
     * {
     * if (_CG != null)
     * _CG.valueTimestampYesterday(ctx.timestamp_literal().LAST() == null);
     * }
     * else if (ctx.timestamp_literal().TIMESTAMP_TODAY() != null)
     * {
     * if (_CG != null)
     * _CG.valueTimestampToday(ctx.timestamp_literal().LAST() == null);
     * }
     * else if (ctx.timestamp_literal().TIMESTAMP_TOMORROW() != null)
     * {
     * if (_CG != null)
     * _CG.valueTimestampTomorrow(ctx.timestamp_literal().LAST() == null);
     * }
     * else
     * {
     * ZonedDateTime ZDT = DateTimeUtil.parsefromJSON(ctx.getText().substring(1, ctx.getText().length() - 1));
     * if (ZDT == null)
     * _Errors.addError("Invalid timestamp " + ctx.getText(), ctx);
     * if (_CG != null)
     * _CG.valueLiteralTimestamp(ZDT);
     * }
     * if (_TypeManager.handleType(ColumnType.DATETIME, ctx) == false)
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * super.enterValueTimestampLiteral(ctx);
     * }
     * 
     * @Override
     * public void enterBool_op(Bool_opContext ctx)
     * {
     * super.enterBool_op(ctx);
     * 
     * if (ctx.K_AND() != null)
     * {
     * if (_CG != null)
     * _CG.boolOperatorAND(ctx.K_NOT() != null);
     * }
     * else if (ctx.K_OR() != null)
     * {
     * if (_CG != null)
     * _CG.boolOperatorOR(ctx.K_NOT() != null);
     * }
     * else
     * _Errors.addError("Unknown boolean operator " + ctx.getText(), ctx);
     * }
     * 
     * @Override
     * public void enterBool_expr_sub(Bool_expr_subContext ctx)
     * {
     * super.enterBool_expr_sub(ctx);
     * if (_CG != null)
     * _CG.boolOpenPar();
     * }
     * 
     * @Override
     * public void exitBool_expr_sub(Bool_expr_subContext ctx)
     * {
     * super.exitBool_expr_sub(ctx);
     * if (_CG != null)
     * _CG.boolClosePar();
     * }
     * 
     * 
     * 
     * @Override
     * public void enterBin_expr(Bin_exprContext ctx)
     * {
     * _TypeManager.openScope();
     * List<ColumnDefinition> Columns = new ArrayList<ColumnDefinition>();
     * for (ColumnContext colCtx : ctx.bin_expr_lhs().column())
     * {
     * ColumnDefinition CD = _TypeManager.handleColumn(colCtx);
     * if (CD != null)
     * Columns.add(CD);
     * else
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * }
     * for (ValueContext valCtx : ctx.bin_expr_lhs().value())
     * {
     * ColumnType Type = null;;
     * if (valCtx instanceof ValueTimestampLiteralContext == true)
     * Type = ColumnType.DATETIME;
     * else if (valCtx instanceof ValueStringLiteralContext == true)
     * Type = ColumnType.STRING;
     * else if (valCtx instanceof ValueNumericLiteralContext == true)
     * Type = ColumnType.INTEGER;
     * else if (valCtx instanceof ValueBindParamContext == true)
     * Type = ColumnType.LONG;
     * else
     * _Errors.addError("Unknown value type "+valCtx.getClass().getName(), valCtx);
     * if (Type != null)
     * Columns.add(new ColumnDefinition(null, null, valCtx.getText(), 0, Type, false, "Value constant"));
     * }
     * 
     * if (ctx.func_name() != null)
     * {
     * if (ctx.func_name().K_LEN() != null)
     * {
     * doFuncLen(ctx, Columns);
     * }
     * else if (ctx.func_name().K_DAYS_BETWEEN() != null)
     * {
     * doFuncDaysBetween(ctx, Columns);
     * }
     * else
     * _Errors.addError("Unknown function " + ctx.func_name().getText(), ctx);
     * Columns.clear();
     * }
     * 
     * if (ctx.bin_like() != null) // like
     * {
     * if (_CG != null)
     * _CG.binLike(Columns, ctx.bin_like().K_NOT() != null);
     * }
     * else if (ctx.bin_op() != null)
     * {
     * if (ctx.bin_op().K_EQ() != null) // equal
     * {
     * if (_CG != null)
     * 
     * _CG.binEqual(Columns, _TypeManager.peek(), false);
     * }
     * else if (ctx.bin_op().K_NEQ() != null) // not equal
     * {
     * if (_CG != null)
     * _CG.binEqual(Columns, _TypeManager.peek(), true);
     * }
     * else if (ctx.bin_op().K_LT() != null) // less than
     * {
     * if (_CG != null)
     * _CG.binLessThan(Columns, _TypeManager.peek());
     * }
     * else if (ctx.bin_op().K_LTE() != null) // less than or equal
     * {
     * if (_CG != null)
     * _CG.binLessThanOrEqual(Columns, _TypeManager.peek());
     * }
     * else if (ctx.bin_op().K_GT() != null) // greater than
     * {
     * if (_CG != null)
     * _CG.binGreaterThan(Columns, _TypeManager.peek());
     * }
     * else if (ctx.bin_op().K_GTE() != null) // greater than or equal
     * {
     * if (_CG != null)
     * _CG.binGreaterThanOrEqual(Columns, _TypeManager.peek());
     * }
     * else
     * _Errors.addError("Unknown binary operator " + ctx.bin_op().getText(), ctx);
     * }
     * else if (ctx.K_IN() != null) // greater than or equal
     * {
     * if (_CG != null)
     * _CG.binIn(Columns, ctx.K_NOT() != null);
     * }
     * else
     * _Errors.addError("Unparsable binary expression " + ctx.getText(), ctx);
     * 
     * if (ctx.column() != null)
     * {
     * _TypeManager.openScope();
     * ColumnDefinition CD = _TypeManager.handleColumn(ctx.column());
     * if (CD != null)
     * {
     * if (_CG != null)
     * _CG.col(CD);
     * }
     * else
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * }
     * 
     * super.enterBin_expr(ctx);
     * }
     * 
     * private void doFuncLen(Bin_exprContext ctx, List<ColumnDefinition> Columns)
     * {
     * boolean err = false;
     * 
     * if (Columns.size() == 1)
     * {
     * ColumnDefinition Col = Columns.get(0);
     * if (Col._Type != ColumnType.STRING && Col._Collection != true)
     * {
     * err = true;
     * _Errors.addError("Function 'Len' must take a single Collection column or a list of Strings: parameter '" + Col.getName() + "' is a " + Col._Type.toString() + ".", ctx);
     * }
     * }
     * else
     * for (ColumnDefinition Col : Columns)
     * {
     * if (Col._Type != ColumnType.STRING)
     * {
     * err = true;
     * _Errors.addError("Function 'Len' must take a single Collection column or a list of Strings: parameter '" + Col.getName() + "' is a " + Col._Type.name() + ".", ctx);
     * break;
     * }
     * else if (Col._Collection == true)
     * {
     * err = true;
     * _Errors.addError("Function 'Len' must take a single Collection column or a list of Strings: parameter '" + Col.getName() + "' is a Collection.", ctx);
     * break;
     * }
     * }
     * 
     * if (err == false)
     * {
     * if (_TypeManager.replaceType(ColumnType.INTEGER, ctx.getText()) == true)
     * if (_CG != null)
     * _CG.funcLen(Columns);
     * }
     * }
     * 
     * private void doFuncDaysBetween(Bin_exprContext ctx, List<ColumnDefinition> Columns)
     * {
     * boolean err = false;
     * 
     * if (Columns.size() == 2)
     * {
     * for (ColumnDefinition Col : Columns)
     * {
     * if (Col._Type != ColumnType.DATETIME && Col._Collection != true)
     * {
     * err = true;
     * _Errors.addError("Function 'DaysBetween' must take 2 DateTime columns: parameter '" + Col.getName() + "' is a " + Col._Type.toString() + ".", ctx);
     * }
     * }
     * }
     * else
     * {
     * err = true;
     * _Errors.addError("Function 'DaysBetween' must take 2 DateTime columns: " + Columns.size() + " parameters were found.", ctx);
     * }
     * 
     * if (err == false)
     * {
     * if (_TypeManager.replaceType(ColumnType.INTEGER, ctx.getText()) == true)
     * if (_CG != null)
     * _CG.funcDaysBetween(Columns.get(0), Columns.get(1));
     * }
     * }
     * 
     * @Override
     * public void exitBin_expr(Bin_exprContext ctx)
     * {
     * if (_CG != null)
     * {
     * String Err = _CG.binClose();
     * if (Err != null)
     * _Errors.addError(Err, ctx);
     * }
     * 
     * if (_TypeManager.rolloverArgumentType(ctx, "binary expression", true) == false)
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * 
     * super.exitBin_expr(ctx);
     * }
     * 
     * protected Deque<Counter> _ArgumentLists = new ArrayDeque<Counter>();
     * 
     * @Override
     * public void enterValue_list(Value_listContext ctx)
     * {
     * _ArgumentLists.push(new Counter());
     * _TypeManager.openScope();
     * if (_CG != null)
     * _CG.valueListOpen();
     * super.enterValue_list(ctx);
     * }
     * 
     * @Override
     * public void exitValue_list(Value_listContext ctx)
     * {
     * if (_ArgumentLists.pop().get() == 0)
     * _Errors.addError("Value list is empty", ctx);
     * else
     * {
     * TypeWrapper Type = _TypeManager.closeScope("value list", ctx, false);
     * if (Type == null)
     * {
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * }
     * else if (_CG != null)
     * {
     * String Err = _CG.valueListClose(Type._Type);
     * if (Err != null)
     * _Errors.addError(Err, ctx);
     * }
     * }
     * super.exitValue_list(ctx);
     * }
     * 
     * @Override
     * public void enterColumn(ColumnContext ctx)
     * {
     * // _TypeManager.handleColumn(ctx);
     * super.enterColumn(ctx);
     * }
     * 
     * @Override
     * public void enterArithmetic_expr_base(Arithmetic_expr_baseContext ctx)
     * {
     * _TypeManager.openScope();
     * super.enterArithmetic_expr_base(ctx);
     * }
     * 
     * @Override
     * public void exitArithmetic_expr_base(Arithmetic_expr_baseContext ctx)
     * {
     * // TODO Auto-generated method stub
     * super.exitArithmetic_expr_base(ctx);
     * }
     * 
     * @Override
     * public void enterArithmeticExpr(ArithmeticExprContext ctx)
     * {
     * _TypeManager.openScope();
     * super.enterArithmeticExpr(ctx);
     * }
     * 
     * @Override
     * public void exitArithmeticExpr(ArithmeticExprContext ctx)
     * {
     * if (_TypeManager.rolloverArgumentType(ctx, "Arithmetic expression", false) == false)
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * 
     * super.exitArithmeticExpr(ctx);
     * }
     * 
     * @Override
     * public void enterArithmetic_op_add(Arithmetic_op_addContext ctx)
     * {
     * 
     * ColumnType ExistingExpressionType = _TypeManager.peek();
     * if (ExistingExpressionType == ColumnType.STRING && ctx.K_MINUS() != null)
     * _Errors.addError("Operator " + ctx.getText() + " is not compatible in an expression currently of type STRING.", ctx);
     * if (_CG != null)
     * _CG.arithmeticPlus(ctx.K_MINUS() != null);
     * super.enterArithmetic_op_add(ctx);
     * }
     * 
     * @Override
     * public void enterArithmetic_op_mul(Arithmetic_op_mulContext ctx)
     * {
     * ColumnType ExistingExpressionType = _TypeManager.peek();
     * if (ExistingExpressionType == ColumnType.STRING)
     * _Errors.addError("Operator " + ctx.getText() + " is not compatible in an expression currently of type STRING.", ctx);
     * else if (ctx.K_DIV() != null)
     * {
     * if (_TypeManager.handleType(ColumnType.FLOAT, ctx) == false)
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * }
     * if (_CG != null)
     * _CG.arithmeticMultiply(ctx.K_DIV() != null);
     * super.enterArithmetic_op_mul(ctx);
     * }
     * 
     * @Override
     * public void enterArithmetic_expr_sub(Arithmetic_expr_subContext ctx)
     * {
     * _TypeManager.openScope();
     * if (_CG != null)
     * _CG.arithmeticOpenPar();
     * super.enterArithmetic_expr_sub(ctx);
     * }
     * 
     * @Override
     * public void exitArithmetic_expr_sub(Arithmetic_expr_subContext ctx)
     * {
     * if (_TypeManager.rolloverArgumentType(ctx, "sub arithmetic expression", false) == false)
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * if (_CG != null)
     * _CG.arithmeticClosePar();
     * super.enterArithmetic_expr_sub(ctx);
     * }
     * 
     * 
     * protected void handleArgumentList()
     * {
     * if (_ArgumentLists.isEmpty() == true)
     * return;
     * if (_ArgumentLists.peek().increment() != 1 && _CG != null)
     * _CG.valueListSeparator();
     * }
     * 
     * @Override
     * public void enterValueNumericLiteral(ValueNumericLiteralContext ctx)
     * {
     * handleArgumentList();
     * if (_CG != null)
     * _CG.valueLiteralNumeric(ctx.getText());
     * 
     * Object Number = ParseUtil.parseNumber(ctx.getText());
     * if (Number == null)
     * _Errors.addError("Invalid number '" + ctx.getText() + "'", ctx);
     * else
     * {
     * ColumnType Type = Number.getClass() == Integer.class ? ColumnType.INTEGER
     * : Number.getClass() == Long.class ? ColumnType.LONG
     * : Number.getClass() == Float.class ? ColumnType.FLOAT
     * : Number.getClass() == Double.class ? ColumnType.DOUBLE
     * : null;
     * if (Type == null)
     * _Errors.addError("Invalid number '" + ctx.getText() + "' was was parsed incorrectly as " + Number.getClass().getName(), ctx);
     * else if (_TypeManager.handleType(Type, ctx) == false)
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * 
     * }
     * super.enterValueNumericLiteral(ctx);
     * }
     * 
     * @Override
     * public void enterValueStringLiteral(ValueStringLiteralContext ctx)
     * {
     * handleArgumentList();
     * String Str = ctx.getText();
     * Str = Str.substring(1, Str.length() - 1);
     * if (_TypeManager.handleType(Str.length() == 1 ? ColumnType.CHAR : ColumnType.STRING, ctx) == false) // a value of 'X' if 3-char long, but is a CHAR type-wise.
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * 
     * if (_TypeManager.peek() == ColumnType.CHAR)
     * {
     * if (_CG != null)
     * _CG.valueLiteralChar(Str.charAt(0));
     * }
     * else
     * {
     * if (_CG != null)
     * _CG.valueLiteralString(Str);
     * }
     * super.enterValueStringLiteral(ctx);
     * }
     * 
     * @Override
     * public void enterValueBindParam(ValueBindParamContext ctx)
     * {
     * handleArgumentList();
     * if (_CG != null)
     * _CG.valueParameter(ctx.getText().replaceAll("\\?\\{([^\\}]+)\\}", "$1"));
     * super.enterValueBindParam(ctx);
     * }
     * 
     * @Override
     * public void enterValueTimestampLiteral(ValueTimestampLiteralContext ctx)
     * {
     * handleArgumentList();
     * if (ctx.timestamp_literal().CURRENT_TIMESTAMP() != null)
     * {
     * if (_CG != null)
     * _CG.valueTimestampCurrent();
     * }
     * else if (ctx.timestamp_literal().TIMESTAMP_YESTERDAY() != null)
     * {
     * if (_CG != null)
     * _CG.valueTimestampYesterday(ctx.timestamp_literal().LAST() == null);
     * }
     * else if (ctx.timestamp_literal().TIMESTAMP_TODAY() != null)
     * {
     * if (_CG != null)
     * _CG.valueTimestampToday(ctx.timestamp_literal().LAST() == null);
     * }
     * else if (ctx.timestamp_literal().TIMESTAMP_TOMORROW() != null)
     * {
     * if (_CG != null)
     * _CG.valueTimestampTomorrow(ctx.timestamp_literal().LAST() == null);
     * }
     * else
     * {
     * ZonedDateTime ZDT = DateTimeUtil.parsefromJSON(ctx.getText().substring(1, ctx.getText().length() - 1));
     * if (ZDT == null)
     * _Errors.addError("Invalid timestamp " + ctx.getText(), ctx);
     * if (_CG != null)
     * _CG.valueLiteralTimestamp(ZDT);
     * }
     * if (_TypeManager.handleType(ColumnType.DATETIME, ctx) == false)
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * super.enterValueTimestampLiteral(ctx);
     * }
     * 
     * @Override
     * public void exitWhere(WhereContext ctx)
     * {
     * if (_CG != null)
     * _CG.end();
     * super.exitWhere(ctx);
     * }
     * 
     * @Override
     * public void enterIsnull_expr(Isnull_exprContext ctx)
     * {
     * ColumnDefinition CD = _TypeManager.handleColumn(ctx.column());
     * boolean Err = false;
     * if (CD == null)
     * {
     * _Errors.addError(_TypeManager.getLastError(), ctx);
     * Err = true;
     * }
     * else if (ctx.isnull_op().K_EMPTY() != null)
     * {
     * if (CD._Type != ColumnType.STRING && CD._Collection != true)
     * {
     * Err = true;
     * _Errors.addError("Operator 'null or empty' must take a Collection column or a Strings: parameter '" + CD.getName() + "' is a " + CD._Type.toString() + ".", ctx);
     * }
     * }
     * 
     * if (Err == false && _CG != null)
     * _CG.isNull(CD, ctx.isnull_op().K_NOT() != null, ctx.isnull_op().K_EMPTY() != null);
     * 
     * super.enterIsnull_expr(ctx);
     * }
     */
  }
