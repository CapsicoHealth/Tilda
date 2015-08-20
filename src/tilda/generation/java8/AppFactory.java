/* ===========================================================================
 * Copyright (C) 2015 CapsicoHealth Inc.
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

package tilda.generation.java8;

import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenAppFactory;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;

public class AppFactory implements CodeGenAppFactory
  {
    protected static final Logger LOG = LogManager.getLogger(AppFactory.class.getName());

    @Override
    public String getFileName(Base O)
      {
        return O._OriginalName + "_Factory.java";
      }

    @Override
    public void genFileStart(PrintWriter Out, Schema S)
      throws Exception
      {
        Out.println("package " + S._Package + ";");
        Out.println();
        Out.println("import org.apache.logging.log4j.LogManager;");
        Out.println("import org.apache.logging.log4j.Logger;");
        Out.println();
        Out.println("import tilda.db.*;");
      }

    @Override
    public void genClassStart(PrintWriter Out, GeneratorSession G, Object O)
      throws Exception
      {
        Out.println("public class " + O._OriginalName + "_Factory extends " + Helper.getFullBaseClassName(O) + "_Factory");
        Out.println(" {");
        Out.println("   protected static final Logger LOG = LogManager.getLogger(" + O._OriginalName + "_Factory.class.getName());");
        Out.println();
        Out.println("   protected " + O._OriginalName + "_Factory() { }");
      }


    public void genClassCustomizations(PrintWriter Out, GeneratorSession G, Object O)
      throws Exception
      {
        Out.println();
        Out.println("   public static void init(Connection C) throws Exception");
        Out.println("    {");
        Out.println("      // Add logic to initialize your object, for example, caching some values, or validating some things.");
        Out.println("    }");
      }

    @Override
    public void genClassEnd(PrintWriter Out, GeneratorSession G)
      throws Exception
      {
        Out.println(" }");
      }

  }
