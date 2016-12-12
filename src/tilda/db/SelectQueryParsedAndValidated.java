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
import tilda.db.processors.ObjectProcessor;
import tilda.grammar.ErrorList;
import tilda.grammar.TildaSQLValidator;

/**
 * <B>LDH-NOTE</B>
 * This class allwos to pass in a full string-based where-clause that will be validated
 * against the TildaSQL parser
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
        super(null, null, OMD._ObjectName, false);

        TildaSQLValidator Validator = new TildaSQLValidator(WhereClause, true);
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

    @SuppressWarnings("unchecked")
    public <T> List<T> execute(Connection C, int Start, int Size)
    throws Exception
      {
        return (List<T>) _OMD._RunSelectMethodList.invoke(null, C, this, Start, Size);
      }

    public <T> void execute(Connection C, ObjectProcessor<T> OP, int Start, int Size)
    throws Exception
      {
        _OMD._RunSelectMethodOP.invoke(null, C, this, OP, Start, Size);
      }
    
  }
