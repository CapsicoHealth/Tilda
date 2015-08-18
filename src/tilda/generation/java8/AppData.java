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

import tilda.enums.ColumnMode;
import tilda.enums.ObjectLifecycle;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenAppData;
import tilda.parsing.parts.Column;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.utils.TextUtil;

public class AppData implements CodeGenAppData
  {
    protected static final Logger LOG = LogManager.getLogger(AppData.class.getName());

    @Override
    public String getFileName(Object O)
      {
        return O._AppDataClassName + ".java";
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
        Out.println("import tilda.db.Connection;");
      }

    @Override
    public void genClassStart(PrintWriter Out, GeneratorSession G, Object O)
      throws Exception
      {
        Out.println("public class " + O._AppDataClassName + " extends " + Helper.getFullBaseClassName(O));
        Out.println(" {");
        Out.println("   protected static final Logger LOG = LogManager.getLogger(" + O._AppDataClassName + ".class.getName());");
        Out.println();
        Out.println("   public " + O._AppDataClassName + "() { }");
      }

    @Override
    public void genClassCustomizations(PrintWriter Out, GeneratorSession G, Object O)
      throws Exception
      {
        for (Column C : O._Columns)
          if (C != null && C._Mode == ColumnMode.CALCULATED && C._MapperDef == null)
            {
              Out.println();
              Out.println("   @Override");
              Out.println("   public " + JavaJDBCType.getFieldType(C) + " get" + TextUtil.CapitalizeFirstCharacter(C.getName()) + "()");
              Out.println("    {");
              Out.println("      // return something");
              Out.println("    }");
            }
        if (O._LC != ObjectLifecycle.READONLY)
          {
            Out.println();
            Out.println("   @Override");
            Out.println("   protected boolean BeforeWrite(Connection C) throws Exception");
            Out.println("     {");
            Out.println("       // Do things before writing the object to disk, for example, take care of AUTO fields.");
            Out.println("       return true;");
            Out.println("     }");
          }
        Out.println();
        Out.println("   @Override");
        Out.println("   protected boolean AfterRead(Connection C) throws Exception");
        Out.println("     {");
        Out.println("       // Do things after an object has just been read form the data store, for example, take care of AUTO fields.");
        Out.println("       return true;");
        Out.println("     }");
      }

    @Override
    public void genClassEnd(PrintWriter Out, GeneratorSession G)
      throws Exception
      {
        Out.println(" }");
      }

  }
