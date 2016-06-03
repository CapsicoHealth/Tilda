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
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ErrorList
  {
    protected static final Logger LOG     = LogManager.getLogger(ErrorList.class.getName());

    protected List<String>        _Errors = new ArrayList<String>();

    public void addError(String err, ParserRuleContext ctx)
      {
        err += " (line " + ctx.getStart().getLine() + ":" + ctx.getStart().getCharPositionInLine() + ")";
        _Errors.add(err);
        LOG.error(err);
      }

    public Iterator<String> getErrors()
      {
        return _Errors.isEmpty() == true ? null : _Errors.iterator();
      }

    public void addErrors(Iterator<String> I)
      {
        if (I != null)
          while (I.hasNext() == true)
            _Errors.add(I.next());
      }
    
    public void addErrors(ErrorList Errors)
      {
        addErrors(Errors.getErrors());
      }
    
  }
