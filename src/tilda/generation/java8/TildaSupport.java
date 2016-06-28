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

import tilda.generation.Generator;
import tilda.generation.GeneratorSession;
import tilda.generation.interfaces.CodeGenTildaSupport;
import tilda.parsing.parts.Base;
import tilda.parsing.parts.Object;
import tilda.parsing.parts.Schema;

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
        Out.println("public final class TILDA__" + Generator.TILDA_VERSION_VAROK);
        Out.println(" {");
        Out.println("   protected static final Logger LOG = LogManager.getLogger(TILDA__" + Generator.TILDA_VERSION_VAROK + ".class.getName());");
      }

    public void genSupportCode(PrintWriter Out, GeneratorSession G, Schema S)
      {
        Out.println("   protected static final String _COMMAQUESTION            =TextUtil.Identity(\",?\");");
        Out.println("   protected static final String _EQUALQUESTION            =TextUtil.Identity(\"=?\");");
        Out.println();
        Out.println("   protected static boolean HandleCatch(Connection C, java.sql.SQLException E, String OperationDebugStr) throws java.sql.SQLException");
        Out.println("     {");
        Out.println("       if (C.isLockOrConnectionError(E) == true)");
        Out.println("        QueryDetails.setLastQueryDeadlocked();");
        Out.println("       else if (E.getSQLState() == null)");
        Out.println("        {");
        Out.println("          LOG.warn(\"JDBC Error: No row \"+OperationDebugStr+\": SQLState is null, ErrorCode=\"+E.getErrorCode());");
        Out.println("          LOG.warn(\"JDBC Message: \"+E.getMessage());");
        Out.println("          return false;");
        Out.println("        }");
        Out.println("       else if (C.isErrNoData(E.getSQLState(), E.getErrorCode()) == true)");
        Out.println("        {");
        Out.println("          LOG.warn(\"JDBC Error: No row \"+OperationDebugStr+\": SQLState=\"+E.getSQLState()+\", ErrorCode=\"+E.getErrorCode());");
        Out.println("          LOG.warn(\"JDBC Message: \"+E.getMessage());");
        Out.println("          return false;");
        Out.println("        }");
        Out.println("       LOG.error(\"JDBC Error: Fatal sql error: SQLState=\"+E.getSQLState()+\", ErrorCode=\"+E.getErrorCode());");
        Out.println("       LOG.catching(E);");
        Out.println("       throw E;");
        Out.println("     }");
        Out.println();
        Out.println("   protected static void HandleFinally(java.sql.PreparedStatement PS, long T0, String TableName, StatementType ST, int count, List<java.sql.Array> AllocatedArrays) throws java.sql.SQLException");
        Out.println("     {");
        Out.println("       if (PS != null) PS.close(); ");
        Out.println("       PerfTracker.add(TableName, ST, System.nanoTime()-T0, count);");
        Out.println("       for (java.sql.Array A : AllocatedArrays)");
        Out.println("        A.free();");
        Out.println("       AllocatedArrays.clear();");
        Out.println("     }");
      }

    @Override
    public void genInitMethod(PrintWriter Out, GeneratorSession G, Schema S)
      {
        Out.println("   public static void initSchema(Connection C) throws Exception");
        Out.println("    {");
        for (Object O : S._Objects)
          if (O != null)
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
