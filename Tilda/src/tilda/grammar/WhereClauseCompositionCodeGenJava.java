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

public class WhereClauseCompositionCodeGenJava implements WhereClauseCompositionCodeGen
  {
    protected static final Logger LOG = LogManager.getLogger(WhereClauseCompositionCodeGenJava.class.getName());

    public WhereClauseCompositionCodeGenJava()
      {
      }

    protected StringBuilder _CodeGen = new StringBuilder();

    @Override
    public void boolOperatorAND(boolean not)
      {
        _CodeGen.append(not == true ? " && ! " : " && ");
      }

    @Override
    public void boolOperatorOR(boolean not)
      {
        _CodeGen.append(not == true ? " || ! " : " || ");
      }

    @Override
    public void boolOpenPar()
      {
        _CodeGen.append("(");
      }

    @Override
    public void boolClosePar()
      {
        _CodeGen.append(")");
      }
    
    @Override
    public void parameter(String Str)
      {
        _CodeGen.append(Str).append("(ObjBase, var1)");
      }
    

    @Override
    public void end()
      {
      }

  }
