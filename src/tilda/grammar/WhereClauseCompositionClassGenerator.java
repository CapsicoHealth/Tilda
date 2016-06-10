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

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.SystemValues;
import tilda.utils.compiler.InMemoryJavaCompiler;

public class WhereClauseCompositionClassGenerator
  {
    protected static final Logger LOG = LogManager.getLogger(WhereClauseCompositionClassGenerator.class.getName());

    public WhereClauseCompositionClassGenerator(String CompositionWhereClauseExpression)
      {
        _CompositionWhereClauseExpression = CompositionWhereClauseExpression;
      }

    protected static class WhereClauseDef
      {
        public WhereClauseDef(String Name, String Source)
          {
            _Name = Name;
            _Source = Source;
          }

        public final String _Name;
        public final String _Source;
      }

    protected String                      _CompositionWhereClauseExpression;
    protected Map<String, WhereClauseDef> _WhereClauses = new HashMap<String, WhereClauseDef>();


    public boolean addWhereClauseDef(String Name, String Source)
      {
        if (_WhereClauses.get(Name) != null)
          {
            LOG.error("An expression by the name of '" + Name + "' has already been registered");
            return false;
          }

        _WhereClauses.put(Name, new WhereClauseDef(Name, Source));
        return true;
      }

    public tilda.grammar.CompiledWhereClause gen(String PackageName, String ClassName, Class<?> ObjClass)
    throws Exception
      {
        StringBuilder Source = new StringBuilder();

        Source.append("package ").append(PackageName).append(";").append(SystemValues.NEWLINE)
        .append(SystemValues.NEWLINE)
        .append("import tilda.utils.CompareUtil;").append(SystemValues.NEWLINE)
        .append("import tilda.utils.DateTimeUtil;").append(SystemValues.NEWLINE)
        .append(SystemValues.NEWLINE)
        .append("public class ").append(ClassName).append(" implements tilda.grammar.CompiledWhereClause").append(SystemValues.NEWLINE)
        .append(" { ").append(SystemValues.NEWLINE)
        .append("   public boolean run(Object ObjBase, int var1)").append(SystemValues.NEWLINE)
        .append("    { ").append(SystemValues.NEWLINE)
        .append("      ").append(ObjClass.getName().replace("$", ".")).append(" obj = (").append(ObjClass.getName().replace("$", ".")).append(") ObjBase;").append(SystemValues.NEWLINE)
        .append("      return ").append(_CompositionWhereClauseExpression).append(";").append(SystemValues.NEWLINE)
        .append("    } ").append(SystemValues.NEWLINE);

        for (WhereClauseDef Exp : _WhereClauses.values())
          {
            Source.append(SystemValues.NEWLINE)
            .append("   protected static boolean ").append(Exp._Name).append("(Object ObjBase, int var1)").append(SystemValues.NEWLINE)
            .append("    { ").append(SystemValues.NEWLINE)
            .append("      ").append(ObjClass.getName().replace("$", ".")).append(" obj = (").append(ObjClass.getName().replace("$", ".")).append(") ObjBase;").append(SystemValues.NEWLINE)
            .append("      return ").append(Exp._Source).append(";").append(SystemValues.NEWLINE)
            .append("    } ").append(SystemValues.NEWLINE);
          }

        Source.append(" } ").append(SystemValues.NEWLINE);
        LOG.debug(Source);
        Class<?> X = InMemoryJavaCompiler.compile(PackageName + "." + ClassName, Source.toString());
        if (X == null)
          return null;

        return (tilda.grammar.CompiledWhereClause) X.newInstance();
      }
  }
