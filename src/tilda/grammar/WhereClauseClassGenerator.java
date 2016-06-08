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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.SystemValues;
import tilda.utils.compiler.InMemoryJavaCompiler;

public class WhereClauseClassGenerator
  {
    protected static final Logger LOG = LogManager.getLogger(WhereClauseClassGenerator.class.getName());

    public static tilda.grammar.CompiledWhereClause gen(String PackageName, String ClassName, Class<?> ObjClass, String boolExpression)
    throws Exception
      {
        String Source = "package " + PackageName + ";" + SystemValues.NEWLINE
                      + SystemValues.NEWLINE
                      + "import tilda.utils.CompareUtil;" + SystemValues.NEWLINE
                      + "import tilda.utils.DateTimeUtil;" + SystemValues.NEWLINE
                      + SystemValues.NEWLINE
                      + "public class " + ClassName + " implements tilda.grammar.CompiledWhereClause" + SystemValues.NEWLINE
                      + " { " + SystemValues.NEWLINE
                      + "   public boolean run(Object ObjBase, int var1)" + SystemValues.NEWLINE
                      + "    { " + SystemValues.NEWLINE
                      + "      " + ObjClass.getName().replace("$", ".") + " obj = (" + ObjClass.getName().replace("$", ".") + ") ObjBase;" + SystemValues.NEWLINE
                      + "      return " + boolExpression + ";" + SystemValues.NEWLINE
                      + "    } " + SystemValues.NEWLINE
                      + " } " + SystemValues.NEWLINE;
        LOG.debug(Source);
        Class<?> X = InMemoryJavaCompiler.compile(PackageName+"."+ClassName, Source);
        if (X == null)
          return null;

        return (tilda.grammar.CompiledWhereClause) X.newInstance();
      }
  }
