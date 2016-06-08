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

public class WhereClauseGen
  {
    protected static final Logger LOG = LogManager.getLogger(WhereClauseGen.class.getName());

    public WhereClauseGen(String PackageName, String ClassName, Class ObjClass)
      {
        _PackageName = PackageName;
        _ClassName = ClassName;
        _ObjClass = ObjClass;

      }

    StringBuilder    _CodeGen = new StringBuilder();
    protected String _PackageName;
    protected String _ClassName;
    protected Object _ObjClass;

  }
