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
import tilda.grammar.TildaSQLParser.Bin_exprContext;
import tilda.grammar.TildaSQLParser.Bool_exprContext;
import tilda.grammar.TildaSQLParser.Bool_expr_subContext;
import tilda.grammar.TildaSQLParser.Bool_opContext;
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
         _CodeGen.append(ctx.K_NOT()==null?".and()":".andNot()");
        else if (ctx.K_OR() != null)
         _CodeGen.append(ctx.K_NOT()==null?".or()":".orNot()");
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
      if (ctx.bin_op().K_NOT() != null) // not like
        {
          _CodeGen.append(".notLike(COLS.").append(ctx.column().getText()).append(", ").append(ctx.aryth_expr().getText()).append(")");
        }
      else if (ctx.bin_op().K_LIKE() != null) // like
        {
          _CodeGen.append(".like(COLS.").append(ctx.column().getText()).append(", ").append(ctx.aryth_expr().getText()).append(")");
        }
      else if (ctx.bin_op().K_EQ() != null) // equal
        {
          _CodeGen.append(".equal(COLS.").append(ctx.column().getText()).append(", ").append(ctx.aryth_expr().getText()).append(")");
        }
      else if (ctx.bin_op().K_NEQ() != null) // not equal
        {
          _CodeGen.append(".notEqual(COLS.").append(ctx.column().getText()).append(", ").append(ctx.aryth_expr().getText()).append(")");
        }
      else if (ctx.bin_op().K_LT() != null) // less than
        {
          _CodeGen.append(".lt(COLS.").append(ctx.column().getText()).append(", ").append(ctx.aryth_expr().getText()).append(")");
        }
      else if (ctx.bin_op().K_LTE() != null) // less than or equal
        {
          _CodeGen.append(".lte(COLS.").append(ctx.column().getText()).append(", ").append(ctx.aryth_expr().getText()).append(")");
        }
      else if (ctx.bin_op().K_GT() != null) // greater than
        {
          _CodeGen.append(".gt(COLS.").append(ctx.column().getText()).append(", ").append(ctx.aryth_expr().getText()).append(")");
        }
      else if (ctx.bin_op().K_GTE() != null) // greater than or equal
        {
          _CodeGen.append(".gte(COLS.").append(ctx.column().getText()).append(", ").append(ctx.aryth_expr().getText()).append(")");
        }
      else
        addError("Unknown binary operator " + ctx.bin_op().getText(), ctx);
      
      super.enterBin_expr(ctx);
    }
    
/*    
    @Override
    public void enterAryth_expr_sub(Aryth_expr_subContext ctx)
      {
        _CodeGen.append(".openPar()");
        super.enterAryth_expr_sub(ctx);
      }

    @Override
    public void exitAryth_expr_sub(Aryth_expr_subContext ctx)
      {
        _CodeGen.append(".closePar()");
        super.exitAryth_expr_sub(ctx);
      }
*/    

    @Override
    public void enterValueLiteralString(tilda.grammar.TildaSQLParser.ValueLiteralStringContext ctx)
      {
      };

    @Override
    public void enterValueLiteralTimestamp(tilda.grammar.TildaSQLParser.ValueLiteralTimestampContext ctx)
      {
        String val = ctx.getText();
        if (val.equalsIgnoreCase("CURRENT_TIMESTAMP") == true)
          {
            LOG.debug("Timestamp parsed: " + val + " -> " + DateTimeUtil.printDateTimeForJSON(DateTimeUtil.NOW_PLACEHOLDER_ZDT));
            return;
          }
        if (val.equalsIgnoreCase("TIMESTAMP_YESTERDAY") == true)
          {
            LOG.debug("Timestamp parsed: " + val + " -> " + DateTimeUtil.printDateTimeForJSON(DateTimeUtil.getYesterdayTimestamp(true)));
            return;
          }
        if (val.equalsIgnoreCase("TIMESTAMP_YESTERDAY_LAST") == true)
          {
            LOG.debug("Timestamp parsed: " + val + " -> " + DateTimeUtil.printDateTimeForJSON(DateTimeUtil.getYesterdayTimestamp(false)));
            return;
          }
        if (val.equalsIgnoreCase("TIMESTAMP_TODAY") == true)
          {
            LOG.debug("Timestamp parsed: " + val + " -> " + DateTimeUtil.printDateTimeForJSON(DateTimeUtil.getTodayTimestamp(true)));
            return;
          }
        if (val.equalsIgnoreCase("TIMESTAMP_TODAY_LAST") == true)
          {
            LOG.debug("Timestamp parsed: " + val + " -> " + DateTimeUtil.printDateTimeForJSON(DateTimeUtil.getTodayTimestamp(false)));
            return;
          }
        if (val.equalsIgnoreCase("TIMESTAMP_TOMORROW") == true)
          {
            LOG.debug("Timestamp parsed: " + val + " -> " + DateTimeUtil.printDateTimeForJSON(DateTimeUtil.getTomorrowTimestamp(true)));
            return;
          }
        if (val.equalsIgnoreCase("TIMESTAMP_TOMORROW_LAST") == true)
          {
            LOG.debug("Timestamp parsed: " + val + " -> " + DateTimeUtil.printDateTimeForJSON(DateTimeUtil.getTomorrowTimestamp(false)));
            return;
          }

        val = val.substring(1, val.length() - 1);
        ZonedDateTime ZDT = DateTimeUtil.parsefromJSON(val);
        if (ZDT == null)
          addError("Invalid timestamp " + val, ctx);
        else
          LOG.debug("Timestamp parsed: " + val + " -> " + DateTimeUtil.printDateTimeForJSON(ZDT));
      }
  }
