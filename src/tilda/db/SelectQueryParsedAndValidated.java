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

package tilda.db;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.db.MasterFactory.ObjectMetaData;
import tilda.grammar.ErrorList;
import tilda.grammar.TildaSQLValidator;

/**
 * <B>LDH-NOTE</B>
 * This class helps build queries more safely, but it's not a compile-time tool. Therefore, there is no point
 * in trying to catch syntax errors as the database will do that plenty fine.<BR>
 * It's tempting to add extra features to catch mismatched parentheses, checking there is no duplicate
 * table names in the From clause. The only thing that was interesting is that using operators in the SET part
 * of a select or update causes weird things. For example, select a=3 evaluates as a boolean expression which
 * i find weird, so i check for it. Other than that, nothing except major issues like
 * 
 * @author ldh
 *
 */
public class SelectQueryParsedAndValidated extends SelectQuery
  {
    protected static final Logger LOG = LogManager.getLogger(SelectQueryParsedAndValidated.class.getName());

    public SelectQueryParsedAndValidated(ObjectMetaData OMD, String WhereClause)
      throws Exception
      {
        super(null, OMD._ObjectName);

        TildaSQLValidator Validator = new TildaSQLValidator(WhereClause);
        Validator.setColumnEnvironment(OMD._Cols);

        if (Validator.getParserSyntaxErrors() != 0)
          throw new Exception("WhereClause expression had " + Validator.getParserSyntaxErrors() + " syntax error(s).");

        Validator.validate();
        Iterator<ErrorList.Error> I = Validator.getValidationErrors().getErrors();
        if (I != null)
          {
            LOG.error("WhereClause expression had validation errors:");
            int i = 0;
            while (I.hasNext() == true)
              {
                LOG.error("        " + I.next());
                ++i;
              }
            throw new Exception("WhereClause expression had "+i+" validation error(s).");
          }
        _OMD = OMD;
        this._QueryStr.append(WhereClause);
      }
    
    protected final ObjectMetaData _OMD;

    public List<?> execute(Connection C, int Start, int Size)
    throws Exception
      {
        return (List<?>) _OMD._RunSelectMethod.invoke(null, C, this, Start, Size);
      }
  }
