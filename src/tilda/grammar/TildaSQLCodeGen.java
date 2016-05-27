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
import java.util.List;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.grammar.TildaSQLParser.Aryth_expr_subContext;
import tilda.grammar.TildaSQLParser.Aryth_op_addContext;
import tilda.grammar.TildaSQLParser.Aryth_op_mulContext;
import tilda.grammar.TildaSQLParser.Bin_exprContext;
import tilda.grammar.TildaSQLParser.Bool_expr_subContext;
import tilda.grammar.TildaSQLParser.Bool_opContext;
import tilda.grammar.TildaSQLParser.ValueBindParamContext;
import tilda.grammar.TildaSQLParser.ValueNumericLiteralContext;
import tilda.grammar.TildaSQLParser.ValueStringLiteralContext;
import tilda.grammar.TildaSQLParser.ValueTimestampLiteralContext;
import tilda.utils.DateTimeUtil;

public class TildaSQLCodeGen extends TildaSQLBaseListener
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQLCodeGen.class.getName());


    public TildaSQLCodeGen(Parser parser)
      {
        _Parser = parser;
      }

    protected StringBuilder _CodeGen = new StringBuilder("Q");
    protected Parser        _Parser;
    protected List<String>  _Errors  = new ArrayList<String>();

    protected void addError(String err, ParserRuleContext ctx)
      {
        err += " (line " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() + ")";
        _Errors.add(err);
        LOG.error(err);
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


    @Override
    public void enterBin_expr(Bin_exprContext ctx)
      {
        String col1 = ctx.column().get(0).getText();
        String col2 = ctx.column().size() == 1 ? null : ctx.column().get(1).getText();
        if (ctx.bin_op().K_NOT() != null) // not like
          {
            _CodeGen.append(".notLike(COLS.").append(col1).append(", ");
          }
        else if (ctx.bin_op().K_LIKE() != null) // like
          {
            _CodeGen.append(".like(COLS.").append(col1).append(", ");
          }
        else if (ctx.bin_op().K_EQ() != null) // equal
          {
            _CodeGen.append(".equal(COLS.").append(col1).append(", ");
          }
        else if (ctx.bin_op().K_NEQ() != null) // not equal
          {
            _CodeGen.append(".notEqual(COLS.").append(col1).append(", ");
          }
        else if (ctx.bin_op().K_LT() != null) // less than
          {
            _CodeGen.append(".lt(COLS.").append(col1).append(", ");
          }
        else if (ctx.bin_op().K_LTE() != null) // less than or equal
          {
            _CodeGen.append(".lte(COLS.").append(col1).append(", ");
          }
        else if (ctx.bin_op().K_GT() != null) // greater than
          {
            _CodeGen.append(".gt(COLS.").append(col1).append(", ");
          }
        else if (ctx.bin_op().K_GTE() != null) // greater than or equal
          {
            _CodeGen.append(".gte(COLS.").append(col1).append(", ");
          }
        else
          addError("Unknown binary operator " + ctx.bin_op().getText(), ctx);

        if (col2 != null)
          _CodeGen.append("COLS.").append(col2);

        super.enterBin_expr(ctx);
      }

    @Override
    public void exitBin_expr(Bin_exprContext ctx)
      {
        _CodeGen.append(")");
        super.exitBin_expr(ctx);
      }

    @Override
    public void enterValueNumericLiteral(ValueNumericLiteralContext ctx)
      {
        _CodeGen.append(ctx.getText());
        super.enterValueNumericLiteral(ctx);
      }

    @Override
    public void enterValueStringLiteral(ValueStringLiteralContext ctx)
      {
        _CodeGen.append(ctx.getText());
        super.enterValueStringLiteral(ctx);
      }

    @Override
    public void enterValueBindParam(ValueBindParamContext ctx)
      {
        _CodeGen.append(ctx.getText().replaceAll("\\?\\{([^\\}]+)\\}", "$1"));
        super.enterValueBindParam(ctx);
      }

    @Override
    public void enterAryth_op_add(Aryth_op_addContext ctx)
      {
        _CodeGen.append(ctx.getText());
        super.enterAryth_op_add(ctx);
      }

    @Override
    public void enterAryth_op_mul(Aryth_op_mulContext ctx)
      {
        _CodeGen.append(ctx.getText());
        super.enterAryth_op_mul(ctx);
      }


    @Override
    public void enterAryth_expr_sub(Aryth_expr_subContext ctx)
      {
        _CodeGen.append("(");
        super.enterAryth_expr_sub(ctx);
      }

    @Override
    public void exitAryth_expr_sub(Aryth_expr_subContext ctx)
      {
        _CodeGen.append(")");
        super.enterAryth_expr_sub(ctx);
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

        if (ts != null)
          _CodeGen.append(ts);

        super.enterValueTimestampLiteral(ctx);
      }
  }
