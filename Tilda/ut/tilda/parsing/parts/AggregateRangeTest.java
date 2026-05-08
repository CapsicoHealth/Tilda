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

package tilda.parsing.parts;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.parsing.ParserSession;

public class AggregateRangeTest
  {
    protected static final Logger LOG          = LogManager.getLogger(AggregateRangeTest.class.getName());

//@formatter:off
    static final String[][] _TEST_VALUES = {{"unbounded preceding and unbounded following","T"}
                                           ,{"unbounded ROW and unbounded following","F"}
                                           ,{"current following and unbounded following","F"}
                                           ,{"unbounded preceding and unbounded ROW","F"}
                                           ,{"unbounded preceding and current following","F"}
                                           ,{"unbounded following and current row","F"}
                                           ,{"unbounded preceding and current row","T"}
                                           ,{"current row and unbounded following","T"}
                                           ,{"current row and unbounded preceding","F"}
                                           ,{"10 preceding and 5 preceding","T"}
                                           ,{"5 preceding and 10 preceding","F"}
                                           ,{"5 following and 10 following","T"}
                                           ,{"10 following and 5 following","F"}
                                           ,{"10 preceding and unbounded preceding","F"}
                                           ,{"unbounded preceding and 1 preceding","T"}
                                           ,{"unbounded following and 10 following","F"}
                                           ,{"1 following and unbounded following","T"}
                                           ,{"current row and current row","F"}
                                           ,{"current row and 10 following","T"}
                                           ,{"current row and 10 preceding","F"}
                                           ,{"10 preceding and current row","T"}
                                           ,{"10 following and current row","F"}
                                          };
  //@formatter:on

    public static void main(String[] args)
      {
        ParserSession PS = new ParserSession(null, null);
        List<String> errors = new ArrayList<String>();
        for (String[] t : _TEST_VALUES)
          {
            LOG.debug("Testing range pattern '" + t[0]);
            boolean success = ViewColumn.validateRange(PS, "NA", t[0]);
            if (t[1].equals(success ? "T" : "F") == false)
              {
                String err = "   - Test case FAILED! '" + t[0] + "' was expecting " + t[1] + " and got " + success;
                errors.add(err);
                LOG.error(err);
              }
          }
        if (errors.isEmpty() == false)
          {
            StringBuilder str = new StringBuilder();
            str.append("\n\n-------------------------------------------------------------------------\n");
            for (String err : errors)
              str.append(err).append("\n");
            str.append("-------------------------------------------------------------------------\n");
            LOG.error(str);
          }
        else
          LOG.info("\n\n-------------------------------------------------------------------------\n"
          + "--- ALL GOOD!\n"
          + "-------------------------------------------------------------------------\n");

      }
  }
