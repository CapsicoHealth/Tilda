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

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.JSONUtil;

public class ErrorList
  {
    protected static final Logger LOG = LogManager.getLogger(ErrorList.class.getName());

    public static class Error
      {
        public Error(String Msg, ParserRuleContext ctx)
          {
            _Msg = Msg;
            _Line = ctx.getStart().getLine();
            _Column = ctx.getStart().getCharPositionInLine();
          }

        public final String _Msg;
        public final int    _Line;
        public final int    _Column;

        public String toString()
          {
            return _Msg + " (line " + _Line + ":" + _Column + ")";
          }
        
        public void toJSON(Writer Out) throws IOException
          {
            Out.append("{");
            JSONUtil.Print(Out, "m", true , _Msg);
            JSONUtil.Print(Out, "l", false, _Line);
            JSONUtil.Print(Out, "c", false, _Column);
            Out.append("}");
          }
        
      }

    protected List<Error> _Errors = new ArrayList<Error>();

    public void addError(String Msg, ParserRuleContext ctx)
      {
        Error err = new Error(Msg, ctx);
        _Errors.add(err);
        LOG.error(err.toString());
      }

    public Iterator<Error> getErrors()
      {
        return _Errors.isEmpty() == true ? null : _Errors.iterator();
      }

    public void addErrors(Iterator<Error> I)
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
