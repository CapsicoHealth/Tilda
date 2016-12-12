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
import tilda.grammar.TildaSQLParser.ValueContext;
import tilda.grammar.TildaSQLParser.ValueNumericLiteralContext;
import tilda.grammar.TildaSQLParser.ValueStringLiteralContext;
import tilda.grammar.TildaSQLParser.ValueTimestampLiteralContext;
import tilda.grammar.TildaSQLParser.Value_listContext;
import tilda.grammar.TildaSQLParser.WhereContext;
import tilda.types.ColumnDefinition;
import tilda.utils.Counter;
import tilda.utils.DateTimeUtil;
import tilda.utils.ParseUtil;

public class TildaSQL2Validator extends TildaSQL2BaseListener
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQL2Validator.class.getName());

    public TildaSQL2Validator(String Expr)
      {
        ANTLRInputStream in = new ANTLRInputStream(Expr);
        TildaSQL2Lexer lexer = new TildaSQL2Lexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TildaSQL2Parser parser = new TildaSQL2Parser(tokens);
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
    public void exitColumn(tilda.grammar.TildaSQL2Parser.ColumnContext ctx)
      {
        _TypeManager.handleColumn(ctx);
        super.exitColumn(ctx);
      }


  }
