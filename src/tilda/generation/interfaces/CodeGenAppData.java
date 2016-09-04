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

package tilda.generation.interfaces;

import java.io.PrintWriter;

import tilda.generation.GeneratorSession;
import tilda.parsing.parts.Object;

public interface CodeGenAppData extends CodeGenBase
  {
    /**
     * 
     * @param Out
     * @throws Exception
     */
    public void genFileStart(PrintWriter Out, Object O)
    throws Exception;


    /**
     * 
     * @param Out
     * @param G
     * @param O
     * @throws Exception
     */
    public void genClassCustomizations(PrintWriter Out, GeneratorSession G, Object O)
    throws Exception;

  }
