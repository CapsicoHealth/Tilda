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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.types.ColumnDefinition;
import tilda.utils.SystemValues;
import tilda.utils.compiler.InMemoryJavaCompiler;

public class WhereClauseCompositionClassGenerator
  {
    protected static final Logger LOG = LogManager.getLogger(WhereClauseCompositionClassGenerator.class.getName());

    public WhereClauseCompositionClassGenerator(String WhereClauseSetName, Class<?> ObjClass)
      {
        _WhereClauseSetName = WhereClauseSetName;
        _ObjClass = ObjClass;
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
        public String       _SourceGen;
      }

    protected String                      _WhereClauseSetName;
    protected Class<?>                    _ObjClass;
    protected String                      _CompositionWhereClauseExpression;
    protected String                      _CompositionWhereClauseExpressionGen;
    protected Map<String, WhereClauseDef> _WhereClauses = new HashMap<String, WhereClauseDef>();
    
    

    public boolean addWhereClauseDef(String Name, String Source, List<ColumnDefinition> Columns)
      {
        if (_WhereClauses.get(Name) != null)
          {
            LOG.error("An expression by the name of '" + Name + "' has already been registered");
            return false;
          }
        WhereClauseDef WCD = new WhereClauseDef(Name, Source);
        _WhereClauses.put(Name, WCD);
        TildaSQLValidator Validator = new TildaSQLValidator(Source);
        if (Validator.getParserSyntaxErrors() != 0)
          {
            LOG.error("    --> Expression '" + Name + "' failed parsing with " + Validator.getParserSyntaxErrors() + " errors.");
            return false;
          }
        WhereClauseCodeGenJava CG = new WhereClauseCodeGenJava();
        Validator.setCodeGen(CG);
        Validator.setColumnEnvironment(Columns);
        Validator.validate();
        Iterator<ErrorList.Error> I = Validator.getValidationErrors().getErrors();
        if (I != null)
          {
            LOG.error("Some errors occurred validating expression '" + Name + "'.");
            while (I.hasNext() == true)
              LOG.error("        " + I.next());
            return false;
          }
        WCD._SourceGen = CG._CodeGen.toString();
        return true;
      }

    public boolean setCompositionExpression(String Source)
      {
        List<String> L = new ArrayList<String>();
        for (WhereClauseDef WCD : _WhereClauses.values())
          L.add(WCD._Name);

        _CompositionWhereClauseExpression = Source;
        TildaCompositionValidator Validator = new TildaCompositionValidator(Source, L);
        if (Validator.getParserSyntaxErrors() != 0)
          {
            LOG.error("    --> Composition expression '" + _WhereClauseSetName + "' failed parsing with " + Validator.getParserSyntaxErrors() + " errors.");
            return false;
          }
        WhereClauseCompositionCodeGenJava CG = new WhereClauseCompositionCodeGenJava();
        Validator.setCodeGen(CG);
        Validator.validate();
        Iterator<ErrorList.Error> I = Validator.getValidationErrors().getErrors();
        if (I != null)
          {
            LOG.error("Some errors occurred validating composition expression '" + _WhereClauseSetName + "'.");
            while (I.hasNext() == true)
              LOG.error("        " + I.next());
            return false;
          }
        _CompositionWhereClauseExpressionGen = CG._CodeGen.toString();
        return true;

      }


    public tilda.grammar.CompiledWhereClause gen(String PackageName)
    throws Exception
      {
        StringBuilder Source = new StringBuilder();

        Source.append("package ").append(PackageName).append(";").append(SystemValues.NEWLINE)
        .append(SystemValues.NEWLINE)
        .append("import tilda.utils.CompareUtil;").append(SystemValues.NEWLINE)
        .append("import tilda.utils.DateTimeUtil;").append(SystemValues.NEWLINE)
        .append(SystemValues.NEWLINE)
        .append("public class ").append(_WhereClauseSetName).append(" implements tilda.grammar.CompiledWhereClause").append(SystemValues.NEWLINE)
        .append(" { ").append(SystemValues.NEWLINE)
        .append("   public boolean run(Object ObjBase, int var1)").append(SystemValues.NEWLINE)
        .append("    { ").append(SystemValues.NEWLINE)
        .append("      ").append(_ObjClass.getName().replace("$", ".")).append(" obj = (").append(_ObjClass.getName().replace("$", ".")).append(") ObjBase;").append(SystemValues.NEWLINE)
        .append("      return ").append(_CompositionWhereClauseExpressionGen).append(";").append(SystemValues.NEWLINE)
        .append("    } ").append(SystemValues.NEWLINE);

        for (WhereClauseDef Exp : _WhereClauses.values())
          {
            Source.append(SystemValues.NEWLINE)
            .append("   protected static boolean ").append(Exp._Name).append("(Object ObjBase, int var1)").append(SystemValues.NEWLINE)
            .append("    { ").append(SystemValues.NEWLINE)
            .append("      ").append(_ObjClass.getName().replace("$", ".")).append(" obj = (").append(_ObjClass.getName().replace("$", ".")).append(") ObjBase;").append(SystemValues.NEWLINE)
            .append("      return ").append(Exp._SourceGen).append(";").append(SystemValues.NEWLINE)
            .append("    } ").append(SystemValues.NEWLINE);
          }

        Source.append(" } ").append(SystemValues.NEWLINE);
        LOG.debug(Source);
        Class<?> X = InMemoryJavaCompiler.compile(PackageName + "." + _WhereClauseSetName, Source.toString());
        if (X == null)
          return null;

        return (tilda.grammar.CompiledWhereClause) X.getDeclaredConstructor().newInstance();
      }
  }
