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

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tilda.utils.SystemValues;

public class TildaSQL
  {
    protected static final Logger LOG = LogManager.getLogger(TildaSQL.class.getName());

    public static void main(String[] args)
    throws Exception
      {
        String Expression = "     toto.daysPostEpisode <= 7 "+SystemValues.NEWLINE
                           +" AND (    ( principalDischargeICD9 LIKE '410.%' AND  principalDischargeICD9 NOT LIKE '410._2' )"+SystemValues.NEWLINE
                           +"       OR ( secondaryDischargeICD9 LIKE '410.%' AND  secondaryDischargeICD9 NOT LIKE '410._2' )"+SystemValues.NEWLINE
                           +"     )"+SystemValues.NEWLINE
                           +" AND tawa(secondaryDischargeICD9, 12) = 1"+SystemValues.NEWLINE  
                           +" AND lower(secondaryDischargeICD9) == 'abc'"+SystemValues.NEWLINE  
                           +" AND (    papa.secondaryDischargeICD9 == '2001-03-11'"+SystemValues.NEWLINE
                           +"       OR papa.secondaryDischargeICD9 == '2001-03-11T22:00'"+SystemValues.NEWLINE
                           +"       OR papa.secondaryDischargeICD9 == '2001-06-11T22:00:30'"+SystemValues.NEWLINE
                           +"       OR papa.secondaryDischargeICD9 == '2001-03-11T22:00:30+00:00'"+SystemValues.NEWLINE
                           +"       OR papa.secondaryDischargeICD9 == '3001-03-11T22:00:30+00:00'"+SystemValues.NEWLINE
                           +"       OR papa.secondaryDischargeICD9 == '2001-14-11T22:00:30+00:00'"+SystemValues.NEWLINE
                           +"       OR papa.secondaryDischargeICD9 == '2001-03-44T22:00:30+00:00'"+SystemValues.NEWLINE
                           +"       OR papa.secondaryDischargeICD9 == '2001-03-11T32:00:30+00:00'"+SystemValues.NEWLINE
                           +"       OR papa.secondaryDischargeICD9 == '2001-03-11T22:70:30+00:00'"+SystemValues.NEWLINE
                           +"       OR papa.secondaryDischargeICD9 == '2001-03-11T22:00:70+00:00'"+SystemValues.NEWLINE
                           +"     )"+SystemValues.NEWLINE
                           +" AND (    papa.count1 > 2*(papa.count2+5+?{var1}+1)"+SystemValues.NEWLINE
                           +"     )"+SystemValues.NEWLINE
                           ;
        ANTLRInputStream in = new ANTLRInputStream(Expression);
        TildaSQLLexer lexer = new TildaSQLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TildaSQLParser parser = new TildaSQLParser(tokens);
        ParseTree tree = parser.where();
        LOG.debug(TildaSQLTreePrinter.print(tree, parser));
        
//        TestRig.main(new String[] { "TildaSQL", "prog", "-gui" } );
      }
 }
