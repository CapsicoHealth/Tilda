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

import tilda.enums.ObjectMode;
import tilda.generation.Generator;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenTildaSupport;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;
import tilda.utils.SystemValues;

public class TildaSupport implements CodeGenTildaSupport
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSupport.class.getName());

    @Override
    public String getFileName(Base O)
      {
        return "TILDA__" + Generator.TILDA_VERSION_VAROK + ".java";
      }

    @Override
    public void genFileStart(PrintWriter Out, Schema S)
    throws Exception
      {
        Out.println("package " + S._Package + "." + Helper.TILDA_GEN_PACKAGE + ";");
        Out.println();
        Out.println("import java.util.*;");
        Out.println();
        Out.println("import org.apache.logging.log4j.LogManager;");
        Out.println("import org.apache.logging.log4j.Logger;");
        Out.println();
        Out.println("import tilda.db.*;");
        Out.println("import tilda.enums.StatementType;");
        Out.println("import tilda.performance.*;");
        Out.println("import tilda.utils.*;");
      }

    @Override
    public void genClassStart(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception
      {
        Out.println(Helper.getMultiLineDocCommentStart()
        + " @author    Tilda code gen for " + Helper.getCodeGenLanguage() + "/" + G.getSql().getName() + SystemValues.NEWLINE
        + "    @version   Tilda 1.0" + SystemValues.NEWLINE
// LDH-NOTE: @generated doesn't seem to be working properly with JavaDocs. Can't figure it out for now.
//        + "    @generated " + DateTimeUtil.printDateTimeFriendly(SystemValues.STARTUP_DATE, true, true) + SystemValues.NEWLINE
        + Helper.getMultiLineCommentEnd()
        );
        Out.println("public final class TILDA__" + Generator.TILDA_VERSION_VAROK);
        Out.println(" {");
        Out.println("   protected static final Logger LOG = LogManager.getLogger(TILDA__" + Generator.TILDA_VERSION_VAROK + ".class.getName());");
      }

    public void genSupportCode(PrintWriter Out, GeneratorSession G, Schema S)
      {
        Out.println("   protected static final String _COMMAQUESTION            =TextUtil.identity(\",?\");");
        Out.println("   protected static final String _EQUALQUESTION            =TextUtil.identity(\"=?\");");
        Out.println();
        Out.println("   protected static void handleFinally(java.sql.PreparedStatement PS, long T0, String TableName, StatementType ST, int count, List<java.sql.Array> AllocatedArrays) throws java.sql.SQLException");
        Out.println("     {");
        Out.println("       if (PS != null)");
        Out.println("        PS.close();");
        Out.println("       PerfTracker.add(TableName, ST, System.nanoTime()-T0, count);");
        Out.println("       if (AllocatedArrays != null)");
        Out.println("        {");
        Out.println("          for (java.sql.Array A : AllocatedArrays)");
        Out.println("           A.free();");
        Out.println("          AllocatedArrays.clear();");
        Out.println("        }");
        Out.println("     }");
      }

    @Override
    public void genInitMethod(PrintWriter Out, GeneratorSession G, Schema S)
      {
        Out.println("   public static void initSchema(Connection C) throws Exception");
        Out.println("    {");
        for (Object O : S._Objects)
          if (O != null && (O._Mode == ObjectMode.NORMAL || O._Mode == ObjectMode.CODE_ONLY))
            Out.println("      " + Helper.getFullBaseClassName(O) + "_Factory.initObject(C);");
        Out.println("    }");
      }

    @Override
    public void genClassEnd(PrintWriter Out, GeneratorSession G)
    throws Exception
      {
        Out.println(" }");
      }

  }
