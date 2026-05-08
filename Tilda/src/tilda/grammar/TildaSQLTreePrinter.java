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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.PaddingUtil;
import tilda.utils.SystemValues;

public class TildaSQLTreePrinter extends TildaSQLBaseListener
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQLTreePrinter.class.getName());

    public TildaSQLTreePrinter(Parser parser)
      {
        _Parser = parser;
      }

    protected StringBuilder                  _ParseTreeStr = new StringBuilder();
    protected Parser                         _Parser;
    protected Map<RuleContext, List<String>> _Path         = new HashMap<RuleContext, List<String>>();

    protected static boolean isTerminalNode(ParseTree node)
      {
        return node.getChildCount() == 0;
      }

    protected static boolean isLeafNode(ParserRuleContext ctx)
      {
        if (ctx.getChildCount() == 0)
          return false;
        boolean Leaf = true;
        for (int i = 0; i < ctx.getChildCount(); ++i)
          if (isTerminalNode(ctx.getChild(i)) == false)
            Leaf = false;
        return Leaf;
      }

    @Override
    public void visitTerminal(TerminalNode node)
      {
        _Path.get(node.getParent()).add(node.getText());
      }

    @Override
    public void visitErrorNode(ErrorNode node)
      {
        _Path.get(node.getParent()).add(node.getText());
      }

    @Override
    public void enterEveryRule(ParserRuleContext ctx)
      {
        LOG.debug(PaddingUtil.getPad(ctx.depth() * 3) + _Parser.getRuleNames()[ctx.getRuleIndex()]);
        if (isLeafNode(ctx) == true)
          LOG.debug(PaddingUtil.getPad(ctx.depth() * 3) + "   -] " + ctx.getText());

        if (_Path.containsKey(ctx.parent) == false)
          _Path.put(ctx.parent, new ArrayList<String>());
        if (_Path.containsKey(ctx) == false)
          _Path.put(ctx, new ArrayList<String>());

        _Path.get(ctx).add(_Parser.getRuleNames()[ctx.getRuleIndex()]);
      }

    @Override
    public void exitEveryRule(ParserRuleContext ctx)
      {
        List<String> ruleStack = _Path.remove(ctx);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ruleStack.size(); ++i)
          {
            sb.append(PaddingUtil.getPad(_Path.size() * 3)).append(ruleStack.get(i)).append(SystemValues.NEWLINE);
          }
        _Path.get(ctx.parent).add(sb.toString());

        if (ctx.parent == null)
          _ParseTreeStr.append(sb.toString());
      }
  }
