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
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.grammar.TildaCompositionParser.Bool_expr_subContext;
import tilda.grammar.TildaCompositionParser.Bool_opContext;
import tilda.grammar.TildaCompositionParser.ParameterContext;
import tilda.grammar.TildaCompositionParser.WhereContext;

public class TildaCompositionValidator extends TildaCompositionBaseListener
  {
    protected static final Logger LOG = LogManager.getLogger(TildaCompositionValidator.class.getName());

    public TildaCompositionValidator(String Expr, List<String> SubExpressions)
      {
        ANTLRInputStream in = new ANTLRInputStream(Expr);
        TildaCompositionLexer lexer = new TildaCompositionLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TildaCompositionParser parser = new TildaCompositionParser(tokens);
        _Tree = parser.where();
        _SyntaxErrors = parser.getNumberOfSyntaxErrors();
        _SubExpressions = SubExpressions;
      }

    protected ParseTree                     _Tree;
    protected int                           _SyntaxErrors;

    protected ErrorList                     _Errors = new ErrorList();
    protected WhereClauseCompositionCodeGen _CG;
    protected List<String>                  _SubExpressions;

    public int getParserSyntaxErrors()
      {
        return _SyntaxErrors;
      }

    public void setCodeGen(WhereClauseCompositionCodeGen CG)
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
    public void enterParameter(ParameterContext ctx)
      {
        super.enterParameter(ctx);
        String ParamName = ctx.getText();
        if (_SubExpressions.contains(ParamName) == false)
          _Errors.addError("Composed WhereClause '" + ParamName + "' has not been defined.", ctx);
        else if (_CG != null)
          _CG.parameter(ParamName);
      }

    @Override
    public void exitWhere(WhereContext ctx)
      {
        if (_CG != null)
          _CG.end();
        super.exitWhere(ctx);
      }
  }
